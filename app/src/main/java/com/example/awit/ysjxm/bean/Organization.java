package com.example.awit.ysjxm.bean;

import android.provider.ContactsContract;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Lenvovo on 2016/6/27.
 */
public class Organization {

    public   String status;
    public   String  msg;
    public   ArrayList<OrgData> orgdata;


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


    public ArrayList<OrgData> getOrgdata() {
        return orgdata;
    }

    public void setOrgdata(ArrayList<OrgData> orgdata) {
        this.orgdata = orgdata;
    }

    public class OrgData implements Serializable {


        public String userId;
        public String  orgid;
        public String departlistid;
        public String departlistname;


        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getOrgid() {
            return orgid;
        }

        public void setOrgid(String orgid) {
            this.orgid = orgid;
        }

        public String getDepartlistid() {
            return departlistid;
        }

        public void setDepartlistid(String departlistid) {
            this.departlistid = departlistid;
        }

        public String getDepartlistname() {
            return departlistname;
        }

        public void setDepartlistname(String departlistname) {
            this.departlistname = departlistname;
        }

        @Override
        public String toString() {
            return "orgdata{" +
                    "userId='" + userId + '\'' +
                    ",orgid='" + orgid + '\'' +
                    ",departlistid='" + departlistid + '\'' +
                    ", departlistname='" + departlistname + '\'' +
                    '}';
        }


    }



        @Override
        public String toString() {
            return "Organization{" +
                    "status='" + status + '\'' +
                    ", msg='" + msg + '\'' +
                    ", orgdata='" + orgdata + '\'' +

                    '}';

            }



}
