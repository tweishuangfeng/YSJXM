package com.example.awit.ysjxm.bean;


import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Lenvovo on 2016/6/27.
 */
public class Unit {

    public  String userid;
    public  String orgid;

    public String parentdepartid;
    public String grp_name;
    public  String grp_type;
    public  String grp_code;
    public  String d_group_id;


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getParentdepartid() {
        return parentdepartid;
    }

    public void setParentdepartid(String parentdepartid) {
        this.parentdepartid = parentdepartid;
    }

    public String getGrp_name() {
        return grp_name;
    }

    public void setGrp_name(String grp_name) {
        this.grp_name = grp_name;
    }

    public String getGrp_type() {
        return grp_type;
    }

    public void setGrp_type(String grp_type) {
        this.grp_type = grp_type;
    }

    public String getGrp_code() {
        return grp_code;
    }

    public void setGrp_code(String grp_code) {
        this.grp_code = grp_code;
    }

    public String getD_group_id() {
        return d_group_id;
    }

    public void setD_group_id(String d_group_id) {
        this.d_group_id = d_group_id;
    }

    @Override
        public String toString() {
            return "Unit{" +

                    "userid='" + userid + '\'' +
                    ",orgid='" + orgid + '\'' +

                    ",parentdepartid ='" + parentdepartid + '\'' +
                    ",grp_name='" + grp_name + '\'' +
                    ",grp_type='" + grp_type + '\'' +
                    ",grp_code='" + grp_code + '\'' +
                    ",d_group_id='" + d_group_id +
                    '}';
        }





}
