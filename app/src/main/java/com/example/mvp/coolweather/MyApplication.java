package com.example.mvp.coolweather;


import android.app.Application;
import android.content.Context;

import com.example.mvp.coolweather.util.LogUtil;

import org.litepal.LitePalApplication;


public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        LitePalApplication.initialize(context);
    }
}
