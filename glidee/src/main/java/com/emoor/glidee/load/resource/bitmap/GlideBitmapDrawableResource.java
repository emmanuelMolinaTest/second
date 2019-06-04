package com.emoor.glidee.load.resource.bitmap;

import com.emoor.glidee.load.engine.bitmap_recycle.BitmapPool;
import com.emoor.glidee.load.resource.drawable.DrawableResource;
import com.emoor.glidee.util.Util;

/**
 * A resource wrapper for {@link com.emoor.glidee.load.resource.bitmap.GlideBitmapDrawable}.
 */
public class GlideBitmapDrawableResource extends DrawableResource<GlideBitmapDrawable> {
    private final BitmapPool bitmapPool;

    public GlideBitmapDrawableResource(GlideBitmapDrawable drawable, BitmapPool bitmapPool) {
        super(drawable);
        this.bitmapPool = bitmapPool;
    }

    @Override
    public int getSize() {
        return Util.getBitmapByteSize(drawable.getBitmap());
    }

    @Override
    public void recycle() {
        bitmapPool.put(drawable.getBitmap());
    }
}
