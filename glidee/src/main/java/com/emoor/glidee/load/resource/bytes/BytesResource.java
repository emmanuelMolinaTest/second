package com.emoor.glidee.load.resource.bytes;

import com.emoor.glidee.load.engine.Resource;

/**
 * An {@link com.emoor.glidee.load.engine.Resource} wrapping a byte array.
 */
public class BytesResource implements Resource<byte[]> {
    private final byte[] bytes;

    public BytesResource(byte[] bytes) {
        if (bytes == null) {
            throw new NullPointerException("Bytes must not be null");
        }
        this.bytes = bytes;
    }

    @Override
    public byte[] get() {
        return bytes;
    }

    @Override
    public int getSize() {
        return bytes.length;
    }

    @Override
    public void recycle() {
        // Do nothing.
    }
}
