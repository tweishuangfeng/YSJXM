package com.example.awit.ysjxm;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.example.awit.ysjxm.dao.DaoMaster;
import com.example.awit.ysjxm.dao.DaoSession;
import com.example.awit.ysjxm.utils.ValueConfig;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Lenvovo on 2016/6/20.
 */
public class YSJXMTApplication  extends Application{

    public static String test = "1";
    /**
     * release=true 软件发布 false:开发中
     */
    public static boolean isRelease = false;
    public static ArrayList<Activity> listActivity = new ArrayList<Activity>();
    public static int networkType;
    public static int NETWORKTYPE_NONE = 1;
    public static int NETWORKTYPE_WIFI = 2;
    public static int NETWORKTYPE_MOBILE = 3;

    private final String TAG = "YSJXMTAppllication";
    private static Context context;

    private static YSJXMTApplication  application;
    private static DaoMaster daoMaster;
    private static DaoSession daoSession;
    private static int myTid;
    private static Handler handler;
    private static int mainThreadId;
    private static Thread mainThread;
    @Override
    public void onCreate() {

        super.onCreate();

        File cacheDir = StorageUtils.getOwnCacheDirectory(this, "emc/Cache");
        Log.e(TAG, cacheDir.getPath());
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .memoryCache(new WeakMemoryCache())
                .threadPoolSize(1)
                .diskCache(new UnlimitedDiscCache(cacheDir))
                .diskCacheSize(100 * 1024 * 1024)
                .diskCacheFileCount(500)
                .build();
        ImageLoader.getInstance().init(config);
        application=this;
        myTid = android.os.Process.myTid();
        //Context
        context = getApplicationContext();
        //mainThreadId
        mainThreadId = android.os.Process.myTid();
        //Thread-->object
        mainThread = Thread.currentThread();
        handler=new Handler();
    }

    // ���判断
    public static DaoMaster getDaoMaster(Context context){
        if(daoMaster == null){
            DaoMaster.OpenHelper helper = new DaoMaster.DevOpenHelper(context, ValueConfig.DB_JING,null);
            daoMaster = new DaoMaster(helper.getWritableDatabase());
        }
        return daoMaster;
    }

    public static DaoSession getDaoSession(Context context){
        if(daoSession == null){
            if(daoMaster == null){
                getDaoMaster(context);
            }
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }


    public static YSJXMTApplication getApplication() {
        return application;
    }
    public static int getMyTid() {
        return myTid;
    }
    public static Handler getHandler() {
        return handler;
    }
    public static Context getContext() {
        return context;
    }
    public static int getMainThreadId() {
        return mainThreadId;
    }
    public static Thread getMainThread() {
        return mainThread;
    }

  }





