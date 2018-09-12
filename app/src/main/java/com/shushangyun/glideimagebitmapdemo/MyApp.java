package com.shushangyun.glideimagebitmapdemo;

import android.app.Application;

/**
 * Created by Administrator on 2018-09-12.
 */

public class MyApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Global.init(getApplicationContext());
    }
}
