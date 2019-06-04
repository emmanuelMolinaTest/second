package com.emoor.glidee.load.resource.transcode;

import com.emoor.glidee.load.engine.Resource;
import com.emoor.glidee.load.resource.bytes.BytesResource;
import com.emoor.glidee.load.resource.gif.GifDrawable;

/**
 * An {@link com.emoor.glidee.load.resource.transcode.ResourceTranscoder} that converts
 * {@link com.emoor.glidee.load.resource.gif.GifDrawable} into bytes by obtaining the original bytes of the GIF from
 * the {@link com.emoor.glidee.load.resource.gif.GifDrawable}.
 */
public class GifDrawableBytesTranscoder implements ResourceTranscoder<GifDrawable, byte[]> {
    @Override
    public Resource<byte[]> transcode(Resource<GifDrawable> toTranscode) {
        GifDrawable gifData = toTranscode.get();
        return new BytesResource(gifData.getData());
    }

    @Override
    public String getId() {
        return "GifDrawableBytesTranscoder.com.bumptech.glide.load.resource.transcode";
    }
}
