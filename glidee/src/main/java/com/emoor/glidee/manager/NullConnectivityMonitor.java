package com.emoor.glidee.manager;

/**
 * A no-op {@link com.emoor.glidee.manager.ConnectivityMonitor}.
 */
class NullConnectivityMonitor implements ConnectivityMonitor {

    @Override
    public void onStart() {
        // Do nothing.
    }

    @Override
    public void onStop() {
        // Do nothing.
    }

    @Override
    public void onDestroy() {
        // Do nothing.
    }
}
