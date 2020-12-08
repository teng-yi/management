package com.why.myapplication.app;

import android.app.Application;

/**
 * @author why
 */
public class MyApp extends Application {

    private static MyApp myApp;

    @Override
    public void onCreate() {
        super.onCreate();
        myApp = this;
    }

    public static MyApp getInstance() {
        return myApp;
    }

}
