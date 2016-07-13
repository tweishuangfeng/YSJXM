package com.example.awit.ysjxm.interfaces;

/**
 * Created by Lenvovo on 2016/6/20.
 */
public interface HttpResultListener {

    public void onStartRequest();
    public void onResult(Object obj);
    public void onFinish();
}
