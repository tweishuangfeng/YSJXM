package com.example.awit.ysjxm.dao;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by Lenvovo on 2016/6/23.
 */
public class OrganizationInfo {

     private  String userId;
     private  String orgid;
     private  String departlistid;
     private   ArrayList<String> departnamelist;



     private transient DaoSession daoSession;

    private transient OrganizationInfoDao myDao;

    private List<DeptsInfo> deptsInfoList;


    public OrganizationInfo(){}

    public OrganizationInfo(String userId) {
        this.userId = userId;
    }

    public OrganizationInfo(String userId, String orgid, String departlistid, ArrayList<String> departnamelist) {
        this.userId = userId;
        this.orgid = orgid;
        this.departlistid = departlistid;
        this.departnamelist = departnamelist;
    }




    public void __setDaoSession(DaoSession daoSession) {

        this.daoSession=daoSession;
        myDao= daoSession != null ? daoSession.getOrganizationInfoDao():null;
    }


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

    public ArrayList<String> getDepartnamelist() {
        return departnamelist;
    }

    public void setDepartnamelist(ArrayList<String> departnamelist) {
        this.departnamelist = departnamelist;
    }


    public List<DeptsInfo> getDeptsInfoList() {
        if (deptsInfoList == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            DeptsInfoDao targetDao = daoSession.getDeptsInfoDao();
            List<DeptsInfo> deptsInfoListNew = targetDao._querySsidInfo_DeptsInfoList(userId);
            synchronized (this) {
                if(deptsInfoList == null) {
                    deptsInfoList = deptsInfoListNew;
                }
            }
        }
        return deptsInfoList;
    }


    public synchronized void resetDeptsInfoList() {
        deptsInfoList = null;
    }


}
