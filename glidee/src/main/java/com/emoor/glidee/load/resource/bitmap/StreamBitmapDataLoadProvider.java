package com.emoor.glidee.load.resource.bitmap;

import android.graphics.Bitmap;

import com.emoor.glidee.load.DecodeFormat;
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
 * An {@link com.emoor.glidee.provider.DataLoadProvider} that provides decoders and encoders for decoding and caching
 * {@link android.graphics.Bitmap}s using {@link java.io.InputStream} data.
 */
public class StreamBitmapDataLoadProvider implements DataLoadProvider<InputStream, Bitmap> {
    private final StreamBitmapDecoder decoder;
    private final BitmapEncoder encoder;
    private final StreamEncoder sourceEncoder;
    private final FileToStreamDecoder<Bitmap> cacheDecoder;

    public StreamBitmapDataLoadProvider(BitmapPool bitmapPool, DecodeFormat decodeFormat) {
        sourceEncoder = new StreamEncoder();
        decoder = new StreamBitmapDecoder(bitmapPool, decodeFormat);
        encoder = new BitmapEncoder();
        cacheDecoder = new FileToStreamDecoder<Bitmap>(decoder);
    }

    @Override
    public ResourceDecoder<File, Bitmap> getCacheDecoder() {
        return cacheDecoder;
    }

    @Override
    public ResourceDecoder<InputStream, Bitmap> getSourceDecoder() {
        return decoder;
    }

    @Override
    public Encoder<InputStream> getSourceEncoder() {
        return sourceEncoder;
    }

    @Override
    public ResourceEncoder<Bitmap> getEncoder() {
        return encoder;
    }
}
