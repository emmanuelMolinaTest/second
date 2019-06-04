package com.emoor.glidee.load.engine;

import android.util.Log;

import com.emoor.glidee.load.Key;
import com.emoor.glidee.load.ResourceDecoder;
import com.emoor.glidee.load.engine.cache.DiskCache;

import java.io.File;
import java.io.IOException;

class CacheLoader {
    private static final String TAG = "CacheLoader";
    private final DiskCache diskCache;

    public CacheLoader(DiskCache diskCache) {
        this.diskCache = diskCache;
    }

    public <Z> Resource<Z> load(Key key, ResourceDecoder<File, Z> decoder, int width, int height) {
        File fromCache = diskCache.get(key);
        if (fromCache == null) {
            return null;
        }

        Resource<Z> result = null;
        try {
            result = decoder.decode(fromCache, width, height);
        } catch (IOException e) {
            if (Log.isLoggable(TAG, Log.DEBUG)) {
                Log.d(TAG, "Exception decoding image from cache", e);
            }
        }
        if (result == null) {
            if (Log.isLoggable(TAG, Log.DEBUG)) {
                Log.d(TAG, "Failed to decode image from cache or not present in cache");
            }
            diskCache.delete(key);
        }
        return result;
    }
}
