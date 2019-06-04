package com.emoor.glidee.load.engine;

import com.emoor.glidee.load.Key;

interface EngineJobListener {

    void onEngineJobComplete(Key key, EngineResource<?> resource);

    void onEngineJobCancelled(EngineJob engineJob, Key key);
}
