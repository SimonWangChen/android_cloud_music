package com.proclassmates.lib_network.okhttp.response.listener;

/**
 * @author simon
 * @name android_cloud_music
 * @class name：com.proclassmates.lib_network.okhttp.response.listener
 * @time 2019-11-12 20:57
 */
public class DisposeDataHandle {
    public DisposeDataListener mListener = null;

    public Class<?> mClass = null;

    public String mSource = null;

    public DisposeDataHandle(DisposeDataListener listener) {
        this.mListener = listener;
    }

    public DisposeDataHandle(DisposeDataListener listener, Class<?> clazz) {
        this.mClass = clazz;
        this.mListener = listener;
    }

    public DisposeDataHandle(DisposeDataListener listener, String source) {
        this.mListener = listener;
        this.mSource = source;
    }
}
