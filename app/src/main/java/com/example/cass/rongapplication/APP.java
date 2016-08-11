package com.example.cass.rongapplication;

import android.app.Application;

import io.rong.imkit.RongIM;

/**
 * Created by Cass on 2016/8/10.
 */
public class APP extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        RongIM.init(this);
    }
}
