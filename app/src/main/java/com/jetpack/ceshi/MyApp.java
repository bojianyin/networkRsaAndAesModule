package com.jetpack.ceshi;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.network.INetWork;
import com.network.NetWorkHelper;

public class MyApp extends Application implements INetWork {
    @Override
    public void onCreate() {
        super.onCreate();
        NetWorkHelper.init(this);
    }

    @Override
    public boolean isDebug() {
        return BuildConfig.DEBUG;
    }

    @Override
    public String appVersion() {
        try{
            PackageInfo info=getPackageManager().getPackageInfo(getPackageName(), 0);
            return info.versionName;
        }catch (Exception e){
            e.printStackTrace();
        }

        return "1.0.0";

    }
}
