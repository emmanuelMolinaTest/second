package com.emoor.glidee.load.resource.gif;

import android.graphics.Bitmap;

import com.emoor.glidee.gifdecoder.GifDecoder;
import com.emoor.glidee.load.ResourceDecoder;
import com.emoor.glidee.load.engine.Resource;
import com.emoor.glidee.load.engine.bitmap_recycle.BitmapPool;
import com.emoor.glidee.load.resource.bitmap.BitmapResource;

class GifFrameResourceDecoder implements ResourceDecoder<GifDecoder, Bitmap> {
    private final BitmapPool bitmapPool;

    public GifFrameResourceDecoder(BitmapPool bitmapPool) {
        this.bitmapPool = bitmapPool;
    }

    @Override
    public Resource<Bitmap> decode(GifDecoder source, int width, int height) {
        Bitmap bitmap = source.getNextFrame();
        return BitmapResource.obtain(bitmap, bitmapPool);
    }

    @Override
    public String getId() {
        return "GifFrameResourceDecoder.com.bumptech.glide.load.resource.gif";
    }
}
