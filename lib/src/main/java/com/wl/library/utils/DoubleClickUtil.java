package com.wl.library.utils;

public class DoubleClickUtil {

    private static long lastTime = 0;

    public static boolean isFastDoubleClick(){
        boolean isLast = true;
        long currentTime = System.currentTimeMillis();
        if (currentTime-lastTime>500){
            isLast = false;
        }
        lastTime = currentTime;
        return isLast;
    }
}
