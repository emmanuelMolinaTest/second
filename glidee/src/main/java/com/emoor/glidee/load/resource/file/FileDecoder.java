package com.emoor.glidee.load.resource.file;

import com.emoor.glidee.load.ResourceDecoder;
import com.emoor.glidee.load.engine.Resource;

import java.io.File;

/**
 * A simple {@link com.emoor.glidee.load.ResourceDecoder} that creates resource for a given {@link java.io.File}.
 */
public class FileDecoder implements ResourceDecoder<File, File> {

    @Override
    public Resource<File> decode(File source, int width, int height) {
        return new FileResource(source);
    }

    @Override
    public String getId() {
        return "";
    }
}
