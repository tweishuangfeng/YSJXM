package com.example.awit.ysjxm.bean;

/**
 * Created by Lenvovo on 2016/6/30.
 */
public class Alarm {

    private  String  grp_type;
    private  String  grp_code;
    private  String  grp_name;
    private  String  war_group_id;
    private  String  war_title;
    private  String  war_name;
    private  String  war_content;


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

    public String getGrp_name() {
        return grp_name;
    }

    public void setGrp_name(String grp_name) {
        this.grp_name = grp_name;
    }

    public String getWar_group_id() {
        return war_group_id;
    }

    public void setWar_group_id(String war_group_id) {
        this.war_group_id = war_group_id;
    }

    public String getWar_title() {
        return war_title;
    }

    public void setWar_title(String war_title) {
        this.war_title = war_title;
    }

    public String getWar_name() {
        return war_name;
    }

    public void setWar_name(String war_name) {
        this.war_name = war_name;
    }

    public String getWar_content() {
        return war_content;
    }

    public void setWar_content(String war_content) {
        this.war_content = war_content;
    }

    @Override
    public String toString() {
        return "alarmdata{" +
                "grp_type='" + grp_type+ '\'' +
                ",grp_code='" + grp_code + '\'' +
                ",grp_name='" + grp_name + '\'' +
                ", war_group_id='" + war_group_id + '\'' +
                ",  war_title='" +  war_title+ '\'' +
                ",  war_name='" + war_name+ '\'' +
                ",  war_content='" + war_content+ '\'' +

                '}';
    }

}
