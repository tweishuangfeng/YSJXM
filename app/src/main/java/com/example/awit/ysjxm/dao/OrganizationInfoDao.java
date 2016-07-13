package com.example.awit.ysjxm.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

/**
 * Created by Lenvovo on 2016/6/23.
 */
public class OrganizationInfoDao extends AbstractDao<OrganizationInfo, String> {

    public static final String TABLENAME = "ORGNIZATION_INFO";

    /**
     * Properties of entity LoginInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */

    public static class Properties {
        public final static Property userId = new Property(0, String.class, "userId", true, "USERID");
        public final static Property orgid = new Property(1, String.class, "orgid", false, "ORGID");
        public final static Property departlistid= new Property(2, String.class, "departlistid", false, "DEPARTLISTID");
        public final static Property departnamelist=new Property(3,ArrayList.class, "departnamelist", false, "DEPARTNAMELIST");

    };


    private DaoSession daoSession;


    public OrganizationInfoDao(DaoConfig config) {
        super(config);
    }

    public OrganizationInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'ORGANIZATION_INFO' (" + //
                "'ORGID' TEXT PRIMARY KEY NOT NULL ," + // 0:
                "'USERID' TEXT," + // 1:
                "'DEPARTLISTID' TEXT," +
                "'DEPARTNAMELIST' TEXT"// 2:
        );
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'ORGANIZATION_INFO'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, OrganizationInfo entity) {
        stmt.clearBindings();

        String userId = entity.getUserId();
        if (userId!= null) {
            stmt.bindString(1, userId);
        }

        String orgid = entity.getOrgid();
        if (orgid != null) {
            stmt.bindString(2, orgid);
        }

        String departlistid = entity.getDepartlistid();
        if (departlistid!= null) {
            stmt.bindString(3, departlistid);
        }


        ArrayList<String>  departnamelist=entity.getDepartnamelist();
        if(departnamelist!=null){

            stmt.bindAllArgsAsStrings(4,departnamelist);
        }



    }

    @Override
    protected void attachEntity(OrganizationInfo entity) {

        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);


    }

    /** @inheritdoc */
    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }

    /** @inheritdoc */
    @Override
    public OrganizationInfo readEntity(Cursor cursor, int offset) {
       OrganizationInfo entity = new OrganizationInfo( //
                cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // userId
                cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // account
                cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2),
                cursor.isNull(offset + 3) ? null : cursor.get(offset + 3)
        );
        return entity;
    }

    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, OrganizationInfo entity, int offset) {
        entity.setUserId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setOrgid(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setDepartlistid(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setDepartnamelist(cursor.isNull(offset + 3) ? null : cursor.g(offset + 3));
    }

    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(OrganizationInfo entity, long rowId) {
        return entity.getUserId();
    }

    /** @inheritdoc */
    @Override
    public String getKey(OrganizationInfo entity) {
        if(entity != null) {
            return entity.getDepartlistid();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override
    protected boolean isEntityUpdateable() {
        return true;
    }








}
