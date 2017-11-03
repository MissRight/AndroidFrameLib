package com.axl.android.frameworkbase;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

/**
 * User: Axl_Jacobs(Axl.Jacobs@gmail.com)
 * Date: 2017/10/26
 * Time: 15:41
 */

public class BaseApplication extends MultiDexApplication {

    private static Context sAppContext;
    private static String sCacheDir;


    @Override
    public void onCreate() {
        super.onCreate();
        sAppContext = getApplicationContext();
        if (getApplicationContext().getExternalCacheDir() != null && ExistSDCard()) {
            sCacheDir = getApplicationContext().getExternalCacheDir().toString();
        } else {
            sCacheDir = getApplicationContext().getCacheDir().toString();
        }
    }

    public static String getAppCacheDir() {
        return sCacheDir;
    }


    public static Context getAppContext() {
        return sAppContext;
    }

    private boolean ExistSDCard() {
        return android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
    }
}
