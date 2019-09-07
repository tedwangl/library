package com.wl.library.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import com.wl.library.R;
import com.wl.library.base.BaseApplication;

import java.io.File;
import androidx.core.content.FileProvider;


public class AppUtil {

    /**
     * 获取应用版本号
     * @param context
     * @return
     */
    public static int getAppVersionCode(Context context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 1;
    }

    /**
     * 获取应用的版本号
     *
     * @return 应用版本号，默认返回1
     */
    public static String getAppVersionName(Context context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "1.0.0";
    }

    /**
     * 根据uri获取path
     *
     * @param context
     * @param contentUri
     * @return
     */
    public static String getRealPathFromUri(Context context, Uri contentUri) {
        Cursor cursor = null;
        try {
            String[] proj = {MediaStore.Images.Media.DATA};
            cursor = context.getContentResolver().query(contentUri, proj, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public static void addToClipBoard(String label, String msg, Context context) {
        //获取剪贴板管理器：
        ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        // 创建普通字符型ClipData
        ClipData mClipData = ClipData.newPlainText(label, msg);
        // 将ClipData内容放到系统剪贴板里。
        cm.setPrimaryClip(mClipData);
    }

    public static long getCacheSize (Context context) {
        long size = 0;
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + context.getString(R.string.app_name) + File.separator + "cache");
        if (file.exists())
            size += getFileSize(file);
        file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + context.getString(R.string.app_name) + "wechatShare");
        if (file.exists())
            size += getFileSize(file);
        file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + context.getPackageName() + File.separator + "cache");
        if (file.exists())
            size += getFileSize(file);
        return size;
    }

    public static void deleteCache(Context context) {
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + context.getString(R.string.app_name) + File.separator + "cache");
        if (file != null && file.exists())
            deleteFile(file);
        file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + context.getString(R.string.app_name) + "wechatShare");
        if (file != null && file.exists())
            deleteFile(file);
        file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + context.getPackageName() + File.separator + "cache");
        if (file != null && file.exists())
            deleteFile(file);
    }

    private static void deleteFile(File file) {
        if (file == null || !file.exists())
            return;
        if (!file.isDirectory())
            file.delete();
        else for (File f : file.listFiles())
            deleteFile(f);
    }


    public static long getFileSize(File file) {
        long size = 0;
        if (file == null || !file.exists())
            return 0;
        if (!file.isDirectory())
            return file.length();
        else for (File f : file.listFiles())
            size += getFileSize(f);

        return size;
    }

    public static File getCacheFile(Context context, String uniqueName) {
        String cachePath = null;
        if ((Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable())
                && context.getExternalCacheDir() != null) {
            cachePath = context.getExternalCacheDir().getPath();
        } else {
            cachePath = context.getCacheDir().getPath();
        }
        return new File(cachePath + File.separator + uniqueName);
    }

    //下载到本地后执行安装
    public static void installAPK(Context context, File file) {

        if (!file.exists()) return;
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri uri = null;
        uri = Uri.fromFile(file);
        //通过FileProvider创建一个content类型的Uri
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            uri = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file);
            context.grantUriPermission(context.getPackageName(), uri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        }
        intent.setDataAndType(uri, "application/vnd.android.package-archive");
        //在服务中开启activity必须设置flag,后面解释
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

    }

    public static void installApkFile(File apkFile) {
        if (apkFile != null && apkFile.exists()) {
            try {
                String[] args2 = {"chmod", "777", apkFile.getAbsolutePath()};
                Runtime.getRuntime().exec(args2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Intent installIntent = new Intent(Intent.ACTION_VIEW);
            installIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Uri uri;
            if (Build.VERSION.SDK_INT >= 24) {
                uri = FileProvider.getUriForFile(BaseApplication.getAppContext(), BaseApplication.getAppContext().getPackageName() + ".fileprovider", apkFile);
                installIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            } else {
                uri = Uri.fromFile(apkFile);
            }
            installIntent.setDataAndType(uri, "application/vnd.android.package-archive");
            BaseApplication.getCustomApp().startActivity(installIntent);
        }
    }


    /**
     * 获取本应用在系统的存储目录
     */
    public static String getAppFile(Context context, String uniqueName) {
        String cachePath = null;
        if ((Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable())
                && context.getExternalCacheDir() != null) {
            cachePath = context.getExternalCacheDir().getPath();
        } else {
            cachePath = context.getCacheDir().getPath();
        }
        return cachePath + File.separator + uniqueName;
    }

}
