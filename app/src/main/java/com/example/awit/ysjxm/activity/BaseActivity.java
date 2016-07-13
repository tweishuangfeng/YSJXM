package com.example.awit.ysjxm.activity;

import android.app.Activity;
import android.os.Bundle;

import com.example.awit.ysjxm.YSJXMTApplication;

/**
 * Created by Lenvovo on 2016/6/20.
 */
public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        YSJXMTApplication.listActivity.add(this);
    }
}
