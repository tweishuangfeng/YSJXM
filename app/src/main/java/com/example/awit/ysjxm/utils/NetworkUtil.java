package com.example.awit.ysjxm.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Lenvovo on 2016/6/20.
 */
public class NetworkUtil {

    public static void checkNetworkState(final Context context)
    {
        try {
            //判断有没有网
            ConnectivityManager manager=(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo=manager.getActiveNetworkInfo();
            if (activeNetworkInfo==null)
            {
                //没网显示一个dialog
                AlertDialog.Builder dialog=new AlertDialog.Builder(context);
                dialog.setMessage("亲，现在没网");

                //打开网络
                dialog.setPositiveButton("打开网络", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //回调 callback
                        try {
                            //判断android的版本
                            int version=android.os.Build.VERSION.SDK_INT;
                            if (version>10)
                            {
                                Intent intent=new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
                                context.startActivity(intent);
                                dialog.cancel();
                            }
                        } catch (Exception e) {
                            ExceptionUtil.handleException(e);
                        }

                    }
                });

                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }


}
