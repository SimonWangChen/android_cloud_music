package com.proclassmates.android_cloud_music.api;

import com.proclassmates.lib_network.okhttp.response.listener.DisposeDataListener;

/**
 * @author simon
 * @name android_cloud_music
 * @class name：com.proclassmates.android_cloud_music.api
 * @time 2019-11-12 18:37
 */
public class RequestCenter {
    static class HttpConstants {
        private static final String ROOT_URL = "http://imooc.com/api";

        /**
         * 首页请求接口
         */
        private static String HOME_RECOMMAND = ROOT_URL + "/product/home_recommand.php";

        private static String HOME_FRIEND = ROOT_URL + "/product/home_friend.php";

        private static String HOME_RECOMMAND_MORE = ROOT_URL + "/product/home_recommand_more.php";

        /**
         * 登陆接口
         */
        public static String LOGIN = ROOT_URL + "/user/login_phone.php";
    }

    public static void login(DisposeDataListener listener){
    }
}
