package com.lt.h5project.activity;

import android.app.Application;
import android.content.Context;

/**
 * @author yeyang
 * @name H5project
 * @class name：com.lt.h5project.activity
 * @class describe
 * @time 2019-07-24 17:42
 * @change
 * @chang time
 * @class describe
 */
public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
    /**
     * 获取全局上下文*/
    public static Context getContext() {
        return context;
    }
}
