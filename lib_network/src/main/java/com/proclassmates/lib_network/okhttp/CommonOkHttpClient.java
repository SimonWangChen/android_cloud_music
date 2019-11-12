package com.proclassmates.lib_network.okhttp;

import com.proclassmates.lib_network.okhttp.response.CommonFileCallback;
import com.proclassmates.lib_network.okhttp.response.CommonJsonCallback;
import com.proclassmates.lib_network.okhttp.response.listener.DisposeDataHandle;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author simon
 * @desc 用来发送 get,post请求的工具类， 包括设置一些请求的共用参数
 * @name android_cloud_music
 * @class name：com.proclassmates.lib_network.okhttp
 * @time 2019-11-12 20:48
 */
public class CommonOkHttpClient {

    private static final int TIME_OUT = 30;

    private static OkHttpClient mOkHttpClient;

    static {
        OkHttpClient.Builder okhttpClientBuilder = new OkHttpClient.Builder();
        okhttpClientBuilder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return false;
            }
        });

        okhttpClientBuilder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder().addHeader( "User_Agent", "Imooc-Mobile").build();
                return chain.proceed(request);
            }
        });

        okhttpClientBuilder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        okhttpClientBuilder.readTimeout(TIME_OUT, TimeUnit.SECONDS);
        okhttpClientBuilder.writeTimeout(TIME_OUT, TimeUnit.SECONDS);
        okhttpClientBuilder.followRedirects(true);
        mOkHttpClient = okhttpClientBuilder.build();
    }

    /**
     * get请求
     */
    public static Call get(Request request, DisposeDataHandle handle) {
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new CommonJsonCallback(handle));
        return call;
    }

    /**
     * post请求
     *
     * @return
     */
    public static Call post(Request request, DisposeDataHandle handle) {
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new CommonJsonCallback(handle));
        return call;
    }

    /**
     * 文件下载请求
     *
     * @return
     */
    public static Call downoadFile(Request request, DisposeDataHandle handle) {
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new CommonFileCallback(handle));
        return call;
    }
}
