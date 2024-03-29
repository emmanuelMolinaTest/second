package com.emoor.glidee.util;

import com.emoor.glidee.ListPreloader;

import java.util.Arrays;

/**
 * A {@link com.emoor.glidee.ListPreloader.PreloadSizeProvider} with a fixed width and height.
 *
 * @param <T> The type of the model the size should be provided for.
 */
public class FixedPreloadSizeProvider<T> implements ListPreloader.PreloadSizeProvider<T> {

    private final int[] size;

    /**
     * Constructor for a PreloadSizeProvider with a fixed size.
     *
     * @param width  The width of the preload size in pixels.
     * @param height The height of the preload size in pixels.
     */
    public FixedPreloadSizeProvider(int width, int height) {
        this.size = new int[]{width, height};
    }

    @Override
    public int[] getPreloadSize(T item, int adapterPosition, int itemPosition) {
        return Arrays.copyOf(this.size, this.size.length);
    }
}
