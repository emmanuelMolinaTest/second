package com.emoor.glidee.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;

import com.emoor.glidee.load.Encoder;
import com.emoor.glidee.load.ResourceDecoder;
import com.emoor.glidee.load.ResourceEncoder;
import com.emoor.glidee.load.model.ImageVideoWrapper;
import com.emoor.glidee.load.model.ImageVideoWrapperEncoder;
import com.emoor.glidee.provider.DataLoadProvider;

import java.io.File;
import java.io.InputStream;

/**
 * A {@link com.emoor.glidee.provider.DataLoadProvider} for loading either an {@link java.io.InputStream} or an
 * {@link android.os.ParcelFileDescriptor} as an {@link android.graphics.Bitmap}.
 */
public class ImageVideoDataLoadProvider implements DataLoadProvider<ImageVideoWrapper, Bitmap> {
    private final ImageVideoBitmapDecoder sourceDecoder;
    private final ResourceDecoder<File, Bitmap> cacheDecoder;
    private final ResourceEncoder<Bitmap> encoder;
    private final ImageVideoWrapperEncoder sourceEncoder;

    public ImageVideoDataLoadProvider(DataLoadProvider<InputStream, Bitmap> streamBitmapProvider,
            DataLoadProvider<ParcelFileDescriptor, Bitmap> fileDescriptorBitmapProvider) {
        encoder = streamBitmapProvider.getEncoder();
        sourceEncoder = new ImageVideoWrapperEncoder(streamBitmapProvider.getSourceEncoder(),
                fileDescriptorBitmapProvider.getSourceEncoder());
        cacheDecoder = streamBitmapProvider.getCacheDecoder();
        sourceDecoder = new ImageVideoBitmapDecoder(streamBitmapProvider.getSourceDecoder(),
                fileDescriptorBitmapProvider.getSourceDecoder());
    }

    @Override
    public ResourceDecoder<File, Bitmap> getCacheDecoder() {
        return cacheDecoder;
    }

    @Override
    public ResourceDecoder<ImageVideoWrapper, Bitmap> getSourceDecoder() {
        return sourceDecoder;
    }

    @Override
    public Encoder<ImageVideoWrapper> getSourceEncoder() {
        return sourceEncoder;
    }

    @Override
    public ResourceEncoder<Bitmap> getEncoder() {
        return encoder;
    }
}
