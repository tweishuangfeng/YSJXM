package com.example.awit.ysjxm.bean;

/**
 * Created by Lenvovo on 2016/7/12.
 */
public class Alert {

    private  String  grp_type;
    private  String   grp_code;
    private  String  grp_name;
    private  String  war_group_id;
    private  String  pwar_title;
    private  String   pwar_name;
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

    public String getPwar_title() {
        return pwar_title;
    }

    public void setPwar_title(String pwar_title) {
        this.pwar_title = pwar_title;
    }

    public String getPwar_name() {
        return pwar_name;
    }

    public void setPwar_name(String pwar_name) {
        this.pwar_name = pwar_name;
    }

    public String getWar_content() {
        return war_content;
    }

    public void setWar_content(String war_content) {
        this.war_content = war_content;
    }


    @Override
    public String toString() {
        return "alertdata{" +
                "grp_type='" + grp_type+ '\'' +
                ",grp_code='" + grp_code + '\'' +
                ",grp_name='" + grp_name + '\'' +
                ", war_group_id='" + war_group_id + '\'' +
                ",  pwar_title='" +  pwar_title+ '\'' +
                ",  pwar_name='" + pwar_name+ '\'' +
                ",  war_content='" + war_content+ '\'' +

                '}';
      }



}
