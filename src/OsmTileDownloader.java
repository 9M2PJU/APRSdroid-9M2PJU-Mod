package org.aprsdroid.app;

import android.content.Context; // Import Context
import android.util.Log; // Import Log for logging
import org.mapsforge.v3.android.maps.mapgenerator.tiledownloader.TileDownloader;
import org.mapsforge.v3.core.Tile;

public class OsmTileDownloader extends TileDownloader {
    private static final String HOST_NAME_ONLINE = "tile.openstreetmap.org";
    private static final String HOST_NAME_OFFLINE = "127.0.0.1"; // New hostname for offline maps
    private static final byte ZOOM_MAX = 18;
    private final StringBuilder stringBuilder = new StringBuilder();
    private static final String TAG = "OsmTileDownloader"; // Tag for logging
    private final PrefsWrapper prefsWrapper; // Instance of PrefsWrapper

    // Constructor that accepts a PrefsWrapper instance
    public OsmTileDownloader(PrefsWrapper prefsWrapper) {
        this.prefsWrapper = prefsWrapper;
    }

    // Factory method to create an instance
    public static OsmTileDownloader create(Context context) {
        PrefsWrapper prefsWrapper = new PrefsWrapper(context);
        return new OsmTileDownloader(prefsWrapper);
    }

    @Override
    public String getHostName() {
        boolean offline = prefsWrapper.isOfflineMap();
        // If offline mode is on, try to detect if the local tile server is
        // actually running. If not, fall back to online OSM tiles so the
        // map still loads instead of showing a blank grid.
        if (offline) {
            try {
                java.net.Socket socket = new java.net.Socket();
                socket.connect(new java.net.InetSocketAddress(HOST_NAME_OFFLINE, 8080), 500);
                socket.close();
                Log.d(TAG, "Offline tile server detected, using local tiles");
            } catch (Exception e) {
                Log.w(TAG, "Offline tile server not reachable, falling back to online OSM tiles");
                offline = false;
            }
        }
        String hostName = offline ? HOST_NAME_OFFLINE : HOST_NAME_ONLINE;
        Log.d(TAG, "Getting host name: " + hostName);
        return hostName;
    }

    @Override
    public String getProtocol() {
        boolean offline = prefsWrapper.isOfflineMap();
        String protocol = offline ? "http" : "https";
        Log.d(TAG, "Getting protocol: " + protocol);
        return protocol;
    }

    @Override
    public int getPort() {
        boolean offline = prefsWrapper.isOfflineMap();
        int port = offline ? 8080 : 443;
        Log.d(TAG, "Getting port: " + port);
        return port;
    }

    @Override
    public String getTilePath(Tile tile) {
        this.stringBuilder.setLength(0);
		this.stringBuilder.append('/');
        this.stringBuilder.append(tile.zoomLevel);
        this.stringBuilder.append('/');
        this.stringBuilder.append(tile.tileX);
        this.stringBuilder.append('/');
        this.stringBuilder.append(tile.tileY);
        this.stringBuilder.append(".png");
        
        String tilePath = this.stringBuilder.toString();
        Log.d(TAG, "Generated tile path: " + tilePath); // Log the generated tile path
        return tilePath;
    }

    @Override
    public byte getZoomLevelMax() {
        Log.d(TAG, "Getting maximum zoom level: " + ZOOM_MAX); // Log max zoom level
        return ZOOM_MAX;
    }
}
