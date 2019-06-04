package com.emoor.glidee.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;

import com.emoor.glidee.Glide;
import com.emoor.glidee.load.DecodeFormat;
import com.emoor.glidee.load.ResourceDecoder;
import com.emoor.glidee.load.engine.Resource;
import com.emoor.glidee.load.engine.bitmap_recycle.BitmapPool;

import java.io.InputStream;

/**
 * An {@link com.emoor.glidee.load.ResourceDecoder} that uses an
 * {@link com.emoor.glidee.load.resource.bitmap.Downsampler} to decode an {@link android.graphics.Bitmap} from an
 * {@link java.io.InputStream}.
 */
public class StreamBitmapDecoder implements ResourceDecoder<InputStream, Bitmap> {
    private static final String ID = "StreamBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    private final Downsampler downsampler;
    private BitmapPool bitmapPool;
    private DecodeFormat decodeFormat;
    private String id;

    public StreamBitmapDecoder(Context context) {
        this(Glide.get(context).getBitmapPool());
    }

    public StreamBitmapDecoder(BitmapPool bitmapPool) {
        this(bitmapPool, DecodeFormat.DEFAULT);
    }

    public StreamBitmapDecoder(Context context, DecodeFormat decodeFormat) {
        this(Glide.get(context).getBitmapPool(), decodeFormat);
    }

    public StreamBitmapDecoder(BitmapPool bitmapPool, DecodeFormat decodeFormat) {
        this(Downsampler.AT_LEAST, bitmapPool, decodeFormat);
    }

    public StreamBitmapDecoder(Downsampler downsampler, BitmapPool bitmapPool, DecodeFormat decodeFormat) {
        this.downsampler = downsampler;
        this.bitmapPool = bitmapPool;
        this.decodeFormat = decodeFormat;
    }

    @Override
    public Resource<Bitmap> decode(InputStream source, int width, int height) {
        Bitmap bitmap = downsampler.decode(source, bitmapPool, width, height, decodeFormat);
        return BitmapResource.obtain(bitmap, bitmapPool);
    }

    @Override
    public String getId() {
        if (id == null) {
            id = new StringBuilder()
                .append(ID)
                .append(downsampler.getId())
                .append(decodeFormat.name())
                .toString();
        }
        return id;
    }
}
