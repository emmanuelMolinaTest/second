package com.emoor.glidee.provider;

import com.emoor.glidee.load.Encoder;
import com.emoor.glidee.load.ResourceDecoder;
import com.emoor.glidee.load.ResourceEncoder;

import java.io.File;

/**
 * A load provider that provides the necessary encoders and decoders to decode a specific type of resource from a
 * specific type of data.
 *
 * @param <T> The type of data the resource will be decoded from.
 * @param <Z> The type of resource that will be decoded.
 */
public interface DataLoadProvider<T, Z> {

    /**
     * Returns the {@link com.emoor.glidee.load.ResourceDecoder} to use to decode the resource from the disk cache.
     */
    ResourceDecoder<File, Z> getCacheDecoder();

    /**
     * Returns the {@link com.emoor.glidee.load.ResourceDecoder} to use to decode the resource from the original data.
     */
    ResourceDecoder<T, Z> getSourceDecoder();

    /**
     * Returns the {@link com.emoor.glidee.load.Encoder} to use to write the original data to the disk cache.
     */
    Encoder<T> getSourceEncoder();

    /**
     * Returns the {@link com.emoor.glidee.load.ResourceEncoder} to use to write the decoded and transformed resource
     * to the disk cache.
     */
    ResourceEncoder<Z> getEncoder();
}
