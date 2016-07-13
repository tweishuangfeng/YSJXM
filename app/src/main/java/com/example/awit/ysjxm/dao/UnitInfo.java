package com.example.awit.ysjxm.dao;

import java.util.ArrayList;

/**
 * Created by Lenvovo on 2016/6/24.
 */
public class UnitInfo {

   private  String userid;
   private  String orgid;
   private  String departlistid;
   private  String departnamelist;
   private  String unitlistid;
   private  String unitnamelist;




    private transient DaoSession daoSession;

    private transient UnitInfoDao myDao;


    public UnitInfo(){}

    public UnitInfo(String userid) {
        this.userid= userid;
    }

    public UnitInfo(String userid, String orgid, String departlistid, String departnamelist, String unitlistid, String unitnamelist) {
        this.userid = userid;
        this.orgid = orgid;
        this.departlistid = departlistid;
        this.departnamelist = departnamelist;
        this.unitlistid = unitlistid;
        this.unitnamelist = unitnamelist;
    }

    public void __setDaoSession(DaoSession daoSession) {

        this.daoSession=daoSession;
        myDao= daoSession != null ? daoSession.getUnitInfoDao():null;
    }


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

    public String getDepartlistid() {
        return departlistid;
    }

    public void setDepartlistid(String departlistid) {
        this.departlistid = departlistid;
    }

    public String getDepartnamelist() {
        return departnamelist;
    }

    public void setDepartnamelist(String departnamelist) {
        this.departnamelist = departnamelist;
    }

    public String getUnitlistid() {
        return unitlistid;
    }

    public void setUnitlistid(String unitlistid) {
        this.unitlistid = unitlistid;
    }

    public String getUnitnamelist() {
        return unitnamelist;
    }

    public void setUnitnamelist(String unitnamelist) {
        this.unitnamelist = unitnamelist;
    }
}
