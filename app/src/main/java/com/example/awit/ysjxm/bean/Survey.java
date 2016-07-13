package com.example.awit.ysjxm.bean;

/**
 * Created by Lenvovo on 2016/6/28.
 */
public class Survey {


    private  String   t_s_depratid;     // 当前组织机构Id
    private  String   departname;       // 当前组织名称
    private  String   grp_type;         //设备类型
    private  String   grp_name;         //设备名称
    private  String  d_group_id;        //所属机组id
    private  String  dty_code;          //数据编码
    private  String  d_type_id;         //数据类型Id
    private  String  dty_name;          //监测数据名称
    private  String  d_value;           //当前监测数据记录值
    private  String   d_valuemin;       //监测数据允许的最小值
    private  String   d_valuemax;       //监测数据允许的最大值
    private  String    d_time;          // 监测数据记录时间



    public String getT_s_depratid() {
        return t_s_depratid;
    }

    public void setT_s_depratid(String t_s_depratid) {
        this.t_s_depratid = t_s_depratid;
    }

    public String getDepartname() {
        return departname;
    }

    public void setDepartname(String departname) {
        this.departname = departname;
    }

    public String getGrp_type() {
        return grp_type;
    }

    public void setGrp_type(String grp_type) {
        this.grp_type = grp_type;
    }

    public String getGrp_name() {
        return grp_name;
    }

    public void setGrp_name(String grp_name) {
        this.grp_name = grp_name;
    }

    public String getD_group_id() {
        return d_group_id;
    }

    public void setD_group_id(String d_group_id) {
        this.d_group_id = d_group_id;
    }

    public String getDty_code() {
        return dty_code;
    }

    public void setDty_code(String dty_code) {
        this.dty_code = dty_code;
    }

    public String getD_type_id() {
        return d_type_id;
    }

    public void setD_type_id(String d_type_id) {
        this.d_type_id = d_type_id;
    }

    public String getDty_name() {
        return dty_name;
    }

    public void setDty_name(String dty_name) {
        this.dty_name = dty_name;
    }

    public String getD_value() {
        return d_value;
    }

    public void setD_value(String d_value) {
        this.d_value = d_value;
    }

    public String getD_valuemin() {
        return d_valuemin;
    }

    public void setD_valuemin(String d_valuemin) {
        this.d_valuemin = d_valuemin;
    }

    public String getD_valuemax() {
        return d_valuemax;
    }

    public void setD_valuemax(String d_valuemax) {
        this.d_valuemax = d_valuemax;
    }

    public String getD_time() {
        return d_time;
    }

    public void setD_time(String d_time) {
        this.d_time = d_time;
    }

    @Override
    public String toString() {
        return "surveydata{" +
                "t_s_depratid='" + t_s_depratid+ '\'' +
                ",departname='" + departname + '\'' +
                ",grp_type='" +grp_type + '\'' +
                ", grp_name='" + grp_name + '\'' +
                ", d_group_id='" +d_group_id + '\'' +
                ", dty_code='" + dty_code + '\'' +
                ",  d_type_id='" +  d_type_id + '\'' +
                ", dty_name='" + dty_name + '\'' +
                ", d_value='" + d_value + '\'' +
                ", d_valuemin='" + d_valuemin + '\'' +
                ",  d_valuemax='" +  d_valuemax + '\'' +
                ",  d_time='" +  d_time + '\'' +
                '}';
    }



}
