package com.example.awit.ysjxm.utils;

import android.util.Log;

import com.example.awit.ysjxm.YSJXMTApplication;

/**
 * Created by Lenvovo on 2016/6/20.
 */
public class LogUtil {

    public static void i(String tag, Object msg) {
        if (YSJXMTApplication.isRelease) {
            return;
        }
        Log.i(tag, String.valueOf(msg));
    }

}
