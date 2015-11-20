package com.innowaves.networktest;

import android.app.Application;
import android.content.Context;

/**
 * Created by sics on 11/20/2015.
 */
public class NetApplication extends Application {

    private static Context instance;

    public static Context getInstance() {

        return instance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        instance = getApplicationContext();
    }
}
