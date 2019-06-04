package com.emoor.glidee.load.resource.transcode;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;

import com.emoor.glidee.Glide;
import com.emoor.glidee.load.engine.Resource;
import com.emoor.glidee.load.engine.bitmap_recycle.BitmapPool;
import com.emoor.glidee.load.resource.bitmap.GlideBitmapDrawable;
import com.emoor.glidee.load.resource.bitmap.GlideBitmapDrawableResource;

/**
 * An {@link com.emoor.glidee.load.resource.transcode.ResourceTranscoder} that converts
 * {@link android.graphics.Bitmap}s into {@link android.graphics.drawable.BitmapDrawable}s.
 */
public class GlideBitmapDrawableTranscoder implements ResourceTranscoder<Bitmap, GlideBitmapDrawable> {
    private final Resources resources;
    private final BitmapPool bitmapPool;

    public GlideBitmapDrawableTranscoder(Context context) {
        this(context.getResources(), Glide.get(context).getBitmapPool());
    }

    public GlideBitmapDrawableTranscoder(Resources resources, BitmapPool bitmapPool) {
        this.resources = resources;
        this.bitmapPool = bitmapPool;
    }

    @Override
    public Resource<GlideBitmapDrawable> transcode(Resource<Bitmap> toTranscode) {
        GlideBitmapDrawable drawable = new GlideBitmapDrawable(resources, toTranscode.get());
        return new GlideBitmapDrawableResource(drawable, bitmapPool);
    }

    @Override
    public String getId() {
        return "GlideBitmapDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
    }
}
