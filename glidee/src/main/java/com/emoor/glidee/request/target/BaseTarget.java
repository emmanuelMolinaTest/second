package com.emoor.glidee.request.target;

import android.graphics.drawable.Drawable;

import com.emoor.glidee.request.Request;

/**
 * A base {@link Target} for loading {@link com.emoor.glidee.load.engine.Resource}s that provides basic or empty
 * implementations for most methods.
 *
 * <p>
 *     For maximum efficiency, clear this target when you have finished using or displaying the
 *     {@link com.emoor.glidee.load.engine.Resource} loaded into it using
 *     {@link com.emoor.glidee.Glide#clear(Target)}.
 * </p>
 *
 * <p>
 *     For loading {@link com.emoor.glidee.load.engine.Resource}s into {@link android.view.View}s,
 *     {@link com.emoor.glidee.request.target.ViewTarget} or {@link com.emoor.glidee.request.target.ImageViewTarget}
 *     are preferable.
 * </p>
 *
 * @param <Z> The type of resource that will be received by this target.
 */
public abstract class BaseTarget<Z> implements Target<Z> {

    private Request request;

    /**
     * {@inheritDoc}
     */
    @Override
    public void setRequest(Request request) {
        this.request = request;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Request getRequest() {
        return request;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onLoadCleared(Drawable placeholder) {
        // Do nothing.
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onLoadStarted(Drawable placeholder) {
        // Do nothing.
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onLoadFailed(Exception e, Drawable errorDrawable) {
        // Do nothing.
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onStart() {
        // Do nothing.
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onStop() {
        // Do nothing.
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDestroy() {
        // Do nothing.
    }
}
