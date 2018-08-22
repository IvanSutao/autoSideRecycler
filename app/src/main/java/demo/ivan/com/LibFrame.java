package demo.ivan.com;

import java.io.File;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;

/**
 * Copyright (C), 2018-2018, 912租房网
 * Author: 张一帆
 * Date: 2018/4/11 0011 上午 11:04
 * Description: library 全局配置
 */

public class LibFrame {

    /**
     * 此处必须是application 否则会内存泄漏
     */
    private static Context mContext;

    public static void init(Context context) {
        LibFrame.mContext = context;
    }

    public static Context getContext() {
        synchronized (LibFrame.class) {
            if (LibFrame.mContext == null) {
                throw new NullPointerException("library 全局上下文配置为空!");
            }
            return mContext.getApplicationContext();
        }
    }

    public static Resources getResources() {
        return LibFrame.getContext().getResources();
    }

    public static DisplayMetrics getDisplayMetrics() {
        return LibFrame.getResources().getDisplayMetrics();
    }


    /**
     * 获取当前本地apk的版本
     */
    public static int getVersionCode() {
        int versionCode = 0;
        try {
            //获取软件版本号，对应AndroidManifest.xml下android:versionCode
            versionCode = mContext.getPackageManager().
                    getPackageInfo(mContext.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }

    /**
     * 获取版本号名称
     */
    public static String getVerName() {
        String verName = "";
        try {
            verName = mContext.getPackageManager().
                    getPackageInfo(mContext.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return verName;
    }

    /**
     * 获取app当前的渠道号或application中指定的meta-data
     *
     * @return 如果没有获取成功(没有对应值，或者异常)，则返回值为空
     */
    public static String getAppMetaData(String key) {
        if (mContext == null || TextUtils.isEmpty(key)) {
            return null;
        }
        String channelNumber = null;
        try {
            PackageManager packageManager = mContext.getPackageManager();
            if (packageManager != null) {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(mContext.getPackageName(), PackageManager.GET_META_DATA);
                if (applicationInfo != null) {
                    if (applicationInfo.metaData != null) {
                        channelNumber = String.valueOf(applicationInfo.metaData.getInt(key));
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return channelNumber;
    }
}
