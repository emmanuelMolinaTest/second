package com.emoor.glidee.load.resource.gif;

import android.content.Context;

import com.emoor.glidee.load.Encoder;
import com.emoor.glidee.load.ResourceDecoder;
import com.emoor.glidee.load.ResourceEncoder;
import com.emoor.glidee.load.engine.bitmap_recycle.BitmapPool;
import com.emoor.glidee.load.model.StreamEncoder;
import com.emoor.glidee.load.resource.file.FileToStreamDecoder;
import com.emoor.glidee.provider.DataLoadProvider;

import java.io.File;
import java.io.InputStream;

/**
 * An {@link com.emoor.glidee.provider.DataLoadProvider} that loads an {@link java.io.InputStream} into
 * {@link com.emoor.glidee.load.resource.gif.GifDrawable} that can be used to display an animated GIF.
 */
public class GifDrawableLoadProvider implements DataLoadProvider<InputStream, GifDrawable> {
    private final GifResourceDecoder decoder;
    private final GifResourceEncoder encoder;
    private final StreamEncoder sourceEncoder;
    private final FileToStreamDecoder<GifDrawable> cacheDecoder;

    public GifDrawableLoadProvider(Context context, BitmapPool bitmapPool) {
        decoder = new GifResourceDecoder(context, bitmapPool);
        cacheDecoder = new FileToStreamDecoder<GifDrawable>(decoder);
        encoder = new GifResourceEncoder(bitmapPool);
        sourceEncoder = new StreamEncoder();
    }

    @Override
    public ResourceDecoder<File, GifDrawable> getCacheDecoder() {
        return cacheDecoder;
    }

    @Override
    public ResourceDecoder<InputStream, GifDrawable> getSourceDecoder() {
        return decoder;
    }

    @Override
    public Encoder<InputStream> getSourceEncoder() {
        return sourceEncoder;
    }

    @Override
    public ResourceEncoder<GifDrawable> getEncoder() {
        return encoder;
    }
}
