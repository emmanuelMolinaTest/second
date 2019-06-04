package com.emoor.glidee.load.engine;

import com.emoor.glidee.load.Encoder;
import com.emoor.glidee.load.Key;
import com.emoor.glidee.load.ResourceDecoder;
import com.emoor.glidee.load.ResourceEncoder;
import com.emoor.glidee.load.Transformation;
import com.emoor.glidee.load.resource.transcode.ResourceTranscoder;

class EngineKeyFactory {

    @SuppressWarnings("rawtypes")
    public EngineKey buildKey(String id, Key signature, int width, int height, ResourceDecoder cacheDecoder,
            ResourceDecoder sourceDecoder, Transformation transformation, ResourceEncoder encoder,
            ResourceTranscoder transcoder, Encoder sourceEncoder) {
        return new EngineKey(id, signature, width, height, cacheDecoder, sourceDecoder, transformation, encoder,
                transcoder, sourceEncoder);
    }

}
