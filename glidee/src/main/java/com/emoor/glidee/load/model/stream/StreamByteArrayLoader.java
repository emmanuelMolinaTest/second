package com.emoor.glidee.load.model.stream;

import android.content.Context;

import com.emoor.glidee.load.data.ByteArrayFetcher;
import com.emoor.glidee.load.data.DataFetcher;
import com.emoor.glidee.load.model.GenericLoaderFactory;
import com.emoor.glidee.load.model.ModelLoader;
import com.emoor.glidee.load.model.ModelLoaderFactory;

import java.io.InputStream;

/**
 * A base class to convert byte arrays to input streams so they can be decoded. This class is abstract because there is
 * no simple/quick way to generate an id from the bytes themselves, so subclass must include an id.
 */
public class StreamByteArrayLoader implements StreamModelLoader<byte[]> {
    private final String id;

    public StreamByteArrayLoader() {
        this("");
    }

    /**
     * @deprecated Use {@link com.emoor.glidee.GenericRequestBuilder#signature(com.emoor.glidee.load.Key)}
     * and the empty constructor instead. Scheduled to be removed in Glide 4.0.
     */
    @Deprecated
    public StreamByteArrayLoader(String id) {
        this.id = id;
    }

    @Override
    public DataFetcher<InputStream> getResourceFetcher(byte[] model, int width, int height) {
        return new ByteArrayFetcher(model, id);
    }

    /**
     * Factory for {@link com.emoor.glidee.load.model.stream.StreamByteArrayLoader}.
     */
    public static class Factory implements ModelLoaderFactory<byte[], InputStream> {

        @Override
        public ModelLoader<byte[], InputStream> build(Context context, GenericLoaderFactory factories) {
            return new StreamByteArrayLoader();
        }

        @Override
        public void teardown() {
            // Do nothing.
        }
    }
}
