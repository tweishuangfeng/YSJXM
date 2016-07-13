package com.example.awit.ysjxm.dao;

import android.database.sqlite.SQLiteDatabase;


import com.lidroid.xutils.DbUtils;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

/**
 * Created by Lenvovo on 2016/6/22.
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig loginInfoDaoConfig;
    private final LoginInfoDao loginInfoDao;

    private  final DaoConfig organizationInfoDaoConfig;
    private  final OrganizationInfoDao organizationInfoDao;


    private final DaoConfig unitInfoDaofig;
    private final UnitInfoDao unitInfoDao;


    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        loginInfoDaoConfig = daoConfigMap.get(LoginInfoDao.class).clone();
        loginInfoDaoConfig.initIdentityScope(type);

        organizationInfoDaoConfig=daoConfigMap.get(OrganizationInfoDao.class).clone();
        organizationInfoDaoConfig.initIdentityScope(type);

        unitInfoDaofig=daoConfigMap.get(UnitInfoDao.class).clone();
        unitInfoDaofig.initIdentityScope(type);

        loginInfoDao = new LoginInfoDao(loginInfoDaoConfig, this);
        organizationInfoDao=new OrganizationInfoDao(organizationInfoDaoConfig,this);
        unitInfoDao =new UnitInfoDao(unitInfoDaofig,this);
    }


    public void clear() {

        loginInfoDaoConfig.getIdentityScope().clear();
        organizationInfoDaoConfig.getIdentityScope().clear();
        unitInfoDaofig.getIdentityScope().clear();

    }

    public LoginInfoDao getLoginInfoDao() {
        return loginInfoDao;
    }

    public OrganizationInfoDao getOrganizationInfoDao(){return  organizationInfoDao;}

    public UnitInfoDao  getUnitInfoDao(){ return  unitInfoDao;}
}
