package com.emoor.glidee.load.model.stream;

import android.content.Context;

import com.emoor.glidee.load.model.GenericLoaderFactory;
import com.emoor.glidee.load.model.GlideUrl;
import com.emoor.glidee.load.model.ModelLoader;
import com.emoor.glidee.load.model.ModelLoaderFactory;
import com.emoor.glidee.load.model.UrlLoader;

import java.io.InputStream;
import java.net.URL;

/**
 * A wrapper class that translates {@link java.net.URL} objects into {@link com.emoor.glidee.load.model.GlideUrl}
 * objects and then uses the wrapped {@link com.emoor.glidee.load.model.ModelLoader} for
 * {@link com.emoor.glidee.load.model.GlideUrl}s to load the {@link java.io.InputStream} data.
 */
public class StreamUrlLoader extends UrlLoader<InputStream> {

    /**
     * The default factory for {@link com.emoor.glidee.load.model.stream.StreamUrlLoader}s.
     */
    public static class Factory implements ModelLoaderFactory<URL, InputStream> {
        @Override
        public ModelLoader<URL, InputStream> build(Context context, GenericLoaderFactory factories) {
            return new StreamUrlLoader(factories.buildModelLoader(GlideUrl.class, InputStream.class));
        }

        @Override
        public void teardown() {
            // Do nothing.
        }
    }

    public StreamUrlLoader(ModelLoader<GlideUrl, InputStream> glideUrlLoader) {
        super(glideUrlLoader);
    }
}
