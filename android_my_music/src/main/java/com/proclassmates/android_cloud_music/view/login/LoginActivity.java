package com.proclassmates.android_cloud_music.view.login;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.proclassmates.android_cloud_music.R;
import com.proclassmates.android_cloud_music.api.MockData;
import com.proclassmates.android_cloud_music.api.RequestCenter;
import com.proclassmates.android_cloud_music.view.login.manager.UserManager;
import com.proclassmates.android_cloud_music.view.login.user.LoginEvent;
import com.proclassmates.android_cloud_music.view.login.user.User;
import com.proclassmates.lib_common_ui.base.BaseActivity;
import com.proclassmates.lib_network.okhttp.response.listener.DisposeDataListener;
import com.proclassmates.lib_network.okhttp.utils.ResponseEntityToModule;

import org.greenrobot.eventbus.EventBus;

public class LoginActivity extends BaseActivity implements DisposeDataListener {

    public static void start(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.login_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "你点我了", Toast.LENGTH_SHORT).show();
                RequestCenter.login(LoginActivity.this);
            }
        });
    }

    @Override
    public void onSuccess(Object responseObj) {
        //处理正常逻辑
        User user = (User) responseObj;
        UserManager.getInstance().saveUser(user);
        EventBus.getDefault().post(new LoginEvent());
        finish();
    }

    @Override
    public void onFailure(Object reasonObj) {
        //登录失败逻辑
        onSuccess(ResponseEntityToModule.parseJsonToModule(
                MockData.LOGIN_DATA, User.class));
    }
}
