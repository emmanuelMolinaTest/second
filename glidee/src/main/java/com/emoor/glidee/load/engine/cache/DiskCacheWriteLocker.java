package com.emoor.glidee.load.engine.cache;

import com.emoor.glidee.load.Key;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Keeps a map of keys to locks that allows locks to be removed from the map when no longer in use
 * so the size of the collection is bounded.
 *
 * <p> This class will be accessed by multiple threads in a thread pool and ensures that the
 *  number of threads interested in each lock is updated atomically so that when the count reaches
 *  0, the lock can safely be removed from the map. </p>
 */
final class DiskCacheWriteLocker {
    private final Map<Key, WriteLock> locks = new HashMap<Key, WriteLock>();
    private final WriteLockPool writeLockPool = new WriteLockPool();

    void acquire(Key key) {
        WriteLock writeLock;
        synchronized (this) {
            writeLock = locks.get(key);
            if (writeLock == null) {
                writeLock = writeLockPool.obtain();
                locks.put(key, writeLock);
            }
            writeLock.interestedThreads++;
        }

        writeLock.lock.lock();
    }

    void release(Key key) {
        WriteLock writeLock;
        synchronized (this) {
            writeLock = locks.get(key);
            if (writeLock == null || writeLock.interestedThreads <= 0) {
                throw new IllegalArgumentException(
                    "Cannot release a lock that is not held" + ", key: " + key + ", interestedThreads: "
                        + (writeLock == null ? 0 : writeLock.interestedThreads));
            }

            if (--writeLock.interestedThreads == 0) {
                WriteLock removed = locks.remove(key);
                if (!removed.equals(writeLock)) {
                    throw new IllegalStateException("Removed the wrong lock"
                        + ", expected to remove: " + writeLock
                        + ", but actually removed: " + removed
                        + ", key: " + key);
                }
                writeLockPool.offer(removed);
            }
        }

        writeLock.lock.unlock();
    }

    private static class WriteLock  {
        final Lock lock = new ReentrantLock();
        int interestedThreads;
    }

    private static class WriteLockPool {
        private static final int MAX_POOL_SIZE = 10;
        private final Queue<WriteLock> pool = new ArrayDeque<WriteLock>();

        WriteLock obtain() {
            WriteLock result;
            synchronized (pool) {
                result = pool.poll();
            }
            if (result == null) {
                result = new WriteLock();
            }
            return result;
        }

        void offer(WriteLock writeLock) {
            synchronized (pool) {
                if (pool.size() < MAX_POOL_SIZE) {
                    pool.offer(writeLock);
                }
            }
        }
    }
}
