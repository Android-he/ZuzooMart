package com.zuzoo.zuzoomart.activity;

import com.avos.avoscloud.AVOSCloud;

import android.app.Application;

public class MyLeanCloudApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // 初始化参数依次为 this, AppId, AppKey
        AVOSCloud.initialize(this,"wCQlm6RNWEKahd4pxlm0TcD0-gzGzoHsz","tWHkgxpeLkLwRDipatxXS0Y3");
    }
}
