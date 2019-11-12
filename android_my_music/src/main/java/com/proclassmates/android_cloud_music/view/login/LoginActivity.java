package com.proclassmates.android_cloud_music.view.login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.proclassmates.android_cloud_music.R;
import com.proclassmates.android_cloud_music.api.RequestCenter;
import com.proclassmates.lib_common_ui.base.BaseActivity;
import com.proclassmates.lib_network.okhttp.response.listener.DisposeDataListener;

public class LoginActivity extends BaseActivity implements DisposeDataListener {

    public static void start(Context context){
        Intent intent = new Intent(context, LoginActivity.class);

        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.login_view).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                RequestCenter.login(LoginActivity.this);
            }
        });
    }


    @Override
    public void onSuccess(Object responseObj) {

    }

    @Override
    public void onFailure(Object responseObj) {

    }
}
