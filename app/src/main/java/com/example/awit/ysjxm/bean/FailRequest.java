package com.example.awit.ysjxm.bean;

/**
 * Created by Lenvovo on 2016/6/20.
 */
public class FailRequest {

    private  Long userid;
    private String status;

    private String msg;



    public Long getUserid() {  return userid;}

    public void setUserid(Long userid) { this.userid = userid; }


    public String getStatus() { return status;
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
}
