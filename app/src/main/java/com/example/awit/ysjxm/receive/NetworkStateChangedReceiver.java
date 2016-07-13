package com.example.awit.ysjxm.receive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.awit.ysjxm.YSJXMTApplication;
import com.example.awit.ysjxm.utils.ExceptionUtil;
import com.example.awit.ysjxm.utils.LogUtil;

/**
 * Created by Lenvovo on 2016/6/20.
 */
public class NetworkStateChangedReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            // 用户是打开还是关闭
            ConnectivityManager manager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                // 用户关网了
                YSJXMTApplication.networkType = YSJXMTApplication.NETWORKTYPE_NONE;
                LogUtil.i("ChangedReceiver", "用户关网了");
            } else {
                // 判断网络类型
                // 电影
                // 1秒100MB 24*60*60*100
                NetworkInfo wifiNetworkInfo = manager
                        .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
                if (wifiNetworkInfo != null && wifiNetworkInfo.isConnected()) {
                    YSJXMTApplication.networkType = YSJXMTApplication.NETWORKTYPE_WIFI;
                    LogUtil.i("ChangedReceiver", "用户开wifi");

                }

                NetworkInfo mobileNetworkInfo = manager
                        .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
                if (mobileNetworkInfo != null
                        && mobileNetworkInfo.isConnected()) {
                    YSJXMTApplication.networkType = YSJXMTApplication.NETWORKTYPE_MOBILE;
                    LogUtil.i("ChangedReceiver", "用户开mobile");

                }

            }
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }

    }


}
