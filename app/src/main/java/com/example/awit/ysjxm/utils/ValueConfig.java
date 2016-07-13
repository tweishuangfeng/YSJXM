package com.example.awit.ysjxm.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.widget.Toast;

import com.example.awit.ysjxm.activity.MainActivity;
import com.example.awit.ysjxm.bean.FailRequest;
import com.example.awit.ysjxm.dialog.CustomProgressDialog;

import java.io.File;

/**
 * Created by Lenvovo on 2016/6/22.
 */
public class ValueConfig {

    public static final String PCAPP_URL = "http://www.logininfo.com/ysj/";

    public static final int TIME_OUT = 20000;
    public static final String DOWNLOAD = Environment
            .getExternalStorageDirectory().getAbsolutePath() + "/ems/download";

    //进度条
    public CustomProgressDialog progressDialog = null;


    public static boolean validateObject(Object obj, Context context) {
        if (obj == null) {
            Toast.makeText(context, "接口出现问题，没有数据返回", Toast.LENGTH_SHORT).show();
            return false;
        } else if (obj instanceof FailRequest) {
            if (((FailRequest) obj).getStatus().equals("1") ) {
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);

            } else {
                FailRequest fail = (FailRequest) obj;
                Toast.makeText(context, fail.getMsg(), Toast.LENGTH_SHORT)
                        .show();
            }
            return false;
        } else {
            return true;
        }
    }




}
