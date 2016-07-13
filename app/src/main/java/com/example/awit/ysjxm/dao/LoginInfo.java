package com.example.awit.ysjxm.dao;

import de.greenrobot.dao.DaoException;

/**
 * Created by Lenvovo on 2016/6/20.
 */
public class LoginInfo {

    private String userid;
    private String status;
    private String msg;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient LoginInfoDao myDao;

   // private List<DepartsInfo> departsInfoList;

    public LoginInfo() {
    }

    public LoginInfo(String userId) {
        this.userid = userid;
    }

    public LoginInfo(String userid, String account, String password) {
        this.userid = userid;
        this.status = status;
        this.msg = msg;

    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getLoginInfoDao() : null;
    }

    public String getUserId() {
        return userid;
    }

    public void setUserId(String userId) {
        this.userid = userid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String account) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String password) {
        this.msg = msg;
    }



//   public List<DepartsInfo> getDepartsInfoList() {
//        if (departsInfoList == null) {
//            if (daoSession == null) {
//                throw new DaoException("Entity is detached from DAO context");
//            }
//            DepartsInfoDao targetDao = daoSession.getDepartsInfoDao();
//            List<DepartsInfo> departsInfoListNew = targetDao._queryLoginInfo_DepartsInfoList(userId);
//            synchronized (this) {
//                if(departsInfoList == null) {
//                    departsInfoList = departsInfoListNew;
//                }
//            }
//        }
//        return departsInfoList;
//    }




//    public synchronized void resetDepartsInfoList() {
//        departsInfoList = null;
//    }



    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }


    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }



}
