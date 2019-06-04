package com.emoor.glidee.load.resource.file;

import com.emoor.glidee.load.resource.SimpleResource;

import java.io.File;

/**
 * A simple {@link com.emoor.glidee.load.engine.Resource} that wraps a {@link File}.
 */
public class FileResource extends SimpleResource<File> {
    public FileResource(File file) {
        super(file);
    }
}
