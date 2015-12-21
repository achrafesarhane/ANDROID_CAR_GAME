package edu.iu.se.trafficruler;

import android.app.Application;
import android.content.Context;

/**
 * Created by Vikrant Kaushal on 10/29/2015.
 */
public class MyApplication extends Application {

    private static MyApplication instance;

    public MyApplication() {
        instance = this;
    }

    public static Context getContext() {
        return instance;
    }
}