package com.emoor.glidee.load.resource.gif;

import com.emoor.glidee.load.resource.drawable.DrawableResource;
import com.emoor.glidee.util.Util;

/**
 * A resource wrapping an {@link com.emoor.glidee.load.resource.gif.GifDrawable}.
 */
public class GifDrawableResource extends DrawableResource<GifDrawable> {
    public GifDrawableResource(GifDrawable drawable) {
        super(drawable);
    }

    @Override
    public int getSize() {
        return drawable.getData().length + Util.getBitmapByteSize(drawable.getFirstFrame());
    }

    @Override
    public void recycle() {
        drawable.stop();
        drawable.recycle();
    }
}
