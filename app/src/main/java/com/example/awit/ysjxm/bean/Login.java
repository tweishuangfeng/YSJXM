package com.example.awit.ysjxm.bean;

import com.example.awit.ysjxm.dao.LoginInfo;

import java.io.Serializable;

/**
 * Created by Lenvovo on 2016/6/20.
 */
public class Login implements Serializable {

    private  String  userid;
    private  String  status;
    private  String  msg;


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    @Override
    public String toString() {
        return "Data{" +
                "userid='" + userid + '\'' +
                ", status='" + status + '\'' +
                ", msg='" + msg + '\''+
                '}';
    }





}
