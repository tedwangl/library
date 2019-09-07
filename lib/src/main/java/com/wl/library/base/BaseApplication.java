package com.wl.library.base;


import android.app.Application;
import android.content.Context;

public class BaseApplication extends Application {

    private static BaseApplication customApp;


    @Override
    public void onCreate() {
        customApp = this;
        super.onCreate();
//        registerActivityLifecycleCallbacks(ParallaxHelper.getInstance());
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }

    public static BaseApplication getCustomApp() {
        return customApp;
    }

    public static Context getAppContext() {
        return customApp.getApplicationContext();
    }

}
