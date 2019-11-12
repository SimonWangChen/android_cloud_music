package com.proclassmates.lib_network.okhttp.response.listener;

/**
 * @author simon
 * @name android_cloud_music
 * @class name：com.proclassmates.lib_network.okhttp.response.listener
 * @time 2019-11-12 18:41
 */
public interface DisposeDataListener {

    void onSuccess(Object responseObj);

    void onFailure(Object responseObj);
}
