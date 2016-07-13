package com.example.awit.ysjxm.dao;

import de.greenrobot.dao.DaoException;

/**
 * Created by Lenvovo on 2016/6/24.
 */
public class DeptsInfo {

    private String deptsid;
    private String deptsname;
    private  String orgid;


    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient DeptsInfoDao myDao;

    private OrganizationInfo organizationInfo;
    private String organizationInfo__resolvedKey;

    public DeptsInfo(){}


    public DeptsInfo(String deptsid, String deptsname, String orgid) {
        this.deptsid= deptsid;
        this.deptsname = deptsname;
        this.orgid = orgid;
    }

    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getDeptsInfoDao() : null;
    }


    public String getDeptsid() {
        return deptsid;
    }

    public void setDeptsid(String deptsid) {
        this.deptsid = deptsid;
    }

    public String getDeptsname() {
        return deptsname;
    }

    public void setDeptsname(String deptsname) {
        this.deptsname = deptsname;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public OrganizationInfo getSsidInfo() {
        String __key = this.orgid;
        if (organizationInfo__resolvedKey == null || organizationInfo__resolvedKey != __key) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            OrganizationInfo targetDao = daoSession.getOrganizationInfoDao();
            OrganizationInfo ssidInfoNew = targetDao.load(__key);
            synchronized (this) {
                organizationInfo = ssidInfoNew;
                organizationInfo__resolvedKey = __key;
            }
        }
        return organizationInfo;
    }

    public void setSsidInfo(OrganizationInfo organizationInfo) {
        if (organizationInfo== null) {
            throw new DaoException("To-one property 'f_userId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.organizationInfo = organizationInfo;
            orgid= organizationInfo.getOrgid();
            organizationInfo__resolvedKey = orgid;
        }
    }


}
