package com.wl.library.utils;

import java.io.File;

/**
 * 作者：author wl
 * 时间：2019-09-08:19:49
 * 说明：
 */
public class FileUtils {

    public static boolean fileIsExist(String path){
        if (path==null||path.trim().length()<=0){
            return false;
        }
        try{
            File file = new File(path);
            if (!file.exists()){
                return false;
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }

}
