package com.emoor.glidee.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;

import com.emoor.glidee.load.DecodeFormat;
import com.emoor.glidee.load.Encoder;
import com.emoor.glidee.load.ResourceDecoder;
import com.emoor.glidee.load.ResourceEncoder;
import com.emoor.glidee.load.engine.bitmap_recycle.BitmapPool;
import com.emoor.glidee.load.resource.NullEncoder;
import com.emoor.glidee.load.resource.file.FileToStreamDecoder;
import com.emoor.glidee.provider.DataLoadProvider;

import java.io.File;

/**
 * An {@link com.emoor.glidee.provider.DataLoadProvider} that provides classes for decoding and encoding
 * {@link android.graphics.Bitmap}s from {@link android.os.ParcelFileDescriptor} data.
 */
public class FileDescriptorBitmapDataLoadProvider implements DataLoadProvider<ParcelFileDescriptor, Bitmap> {
    private final ResourceDecoder<File, Bitmap> cacheDecoder;
    private final FileDescriptorBitmapDecoder sourceDecoder;
    private final BitmapEncoder encoder;
    private final Encoder<ParcelFileDescriptor> sourceEncoder;

    public FileDescriptorBitmapDataLoadProvider(BitmapPool bitmapPool, DecodeFormat decodeFormat) {
        cacheDecoder = new FileToStreamDecoder<Bitmap>(new StreamBitmapDecoder(bitmapPool, decodeFormat));
        sourceDecoder = new FileDescriptorBitmapDecoder(bitmapPool, decodeFormat);
        encoder = new BitmapEncoder();
        sourceEncoder = NullEncoder.get();
    }

    @Override
    public ResourceDecoder<File, Bitmap> getCacheDecoder() {
        return cacheDecoder;
    }

    @Override
    public ResourceDecoder<ParcelFileDescriptor, Bitmap> getSourceDecoder() {
        return sourceDecoder;
    }

    @Override
    public Encoder<ParcelFileDescriptor> getSourceEncoder() {
        return sourceEncoder;
    }

    @Override
    public ResourceEncoder<Bitmap> getEncoder() {
        return encoder;
    }
}
