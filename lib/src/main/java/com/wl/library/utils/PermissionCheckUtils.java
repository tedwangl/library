package com.wl.library.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.ArrayList;
import java.util.List;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class PermissionCheckUtils {

    private static int REQUEST_CODE = 0x123;

    public static class  PermissionsConstant{
        public static final int REQUEST_CAMERA = 1;
        public static final int REQUEST_EXTERNAL_READ = 2;
        public static final int REQUEST_EXTERNAL_WRITE = 3;
    }

    /**
     * 检查所有权限
     * @param context
     */
    public static void checkAllPermission(Context context){
        if (!(context instanceof Activity)){
            throw new ClassCastException("context must be activity!");
        }
        List<String> targetPermissions = new ArrayList<>();

        PackageManager pm = context.getPackageManager();
        PackageInfo pi;
        try {
            pi = pm.getPackageInfo(context.getPackageName(), PackageManager.GET_PERMISSIONS);
            String[] permissions = pi.requestedPermissions;
            if(permissions != null){
                for(String str : permissions){
                    boolean permission = (PackageManager.PERMISSION_GRANTED ==
                            pm.checkPermission(str, context.getPackageName()));
                    if (!permission){
                        targetPermissions.add(str);
                    }
                }
                String[] ps = targetPermissions.toArray(new String[targetPermissions.size()]);
                ActivityCompat.requestPermissions((Activity) context, ps,REQUEST_CODE);
            }
        }catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 检查单条权限
     * @param context
     * @param permission
     */
    public static void checkPermission(Context context,String permission){
        if (!(context instanceof Activity)){
            throw new ClassCastException("context must be activity!");
        }
        PackageManager pm = context.getPackageManager();
        PackageInfo pi;
        try {
            pi = pm.getPackageInfo(context.getPackageName(), PackageManager.GET_PERMISSIONS);
            boolean hasPermission = (PackageManager.PERMISSION_GRANTED ==
                    pm.checkPermission(permission, context.getPackageName()));
            if (!hasPermission){
                ActivityCompat.requestPermissions((Activity) context,new String[]{permission},0x123);
            }
        }catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读入权限
     * @param activity
     */
    public static void checkReadStoragePermission(Activity activity) {
        if (ContextCompat.checkSelfPermission(activity, READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(activity,
                    new String[]{WRITE_EXTERNAL_STORAGE}, REQUEST_CODE);
        }
    }

    /**
     * 写入权限
     * @param activity
     */
    public static void checkWriteStoragePermission(Activity activity) {
        if (ContextCompat.checkSelfPermission(activity, WRITE_EXTERNAL_STORAGE)!=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity,new String[]{
                    WRITE_EXTERNAL_STORAGE},
                    REQUEST_CODE);
        }
    }

    /**
     * 相机权限
     * @param activity
     * @return
     */
    public static boolean checkCameraPermission(Activity activity) {
        int cameraPermissionState = ContextCompat.checkSelfPermission(activity, CAMERA);

        boolean cameraPermissionGranted = cameraPermissionState == PackageManager.PERMISSION_GRANTED;

        if (!cameraPermissionGranted) {
            ActivityCompat.requestPermissions(activity,new String[]{CAMERA},REQUEST_CODE);
        }
        return cameraPermissionGranted;
    }

}
