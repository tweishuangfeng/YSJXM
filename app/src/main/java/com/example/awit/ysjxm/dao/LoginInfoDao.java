package com.example.awit.ysjxm.dao;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

/**
 * Created by Lenvovo on 2016/6/22.
 */
public class LoginInfoDao extends AbstractDao<LoginInfo, String> {

    public static final String TABLENAME = "LOGIN_INFO";

    /**
     * Properties of entity LoginInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */

    public static class Properties {
        public final static Property userid = new Property(0, String.class, "userid", true, "USER_ID");
        public final static Property status = new Property(1, String.class, "status", false, "STATUS");
        public final static Property msg= new Property(2, String.class, "msg", false, "MSG");
    };


    private DaoSession daoSession;


    public LoginInfoDao(DaoConfig config) {
        super(config);
    }

    public LoginInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'LOGIN_INFO' (" + //
                "'USER_ID' TEXT PRIMARY KEY NOT NULL ," + // 0: userId
                "'STATUS' TEXT," + // 1: status
                "'MSG' TEXT,"  // 2: msg
                );
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'LOGIN_INFO'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, LoginInfo entity) {
        stmt.clearBindings();

        String userid = entity.getUserId();
        if (userid != null) {
            stmt.bindString(1, userid);
        }

        String status = entity.getStatus();
        if (status != null) {
            stmt.bindString(2, status);
        }

        String msg = entity.getMsg();
        if (msg!= null) {
            stmt.bindString(3, msg);
        }


    }

    @Override
    protected void attachEntity(LoginInfo entity) {
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
    public LoginInfo readEntity(Cursor cursor, int offset) {
        LoginInfo entity = new LoginInfo( //
                cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // userId
                cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // account
                cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2) //password
        );
        return entity;
    }

    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, LoginInfo entity, int offset) {
        entity.setUserId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setStatus(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setMsg(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
    }

    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(LoginInfo entity, long rowId) {
        return entity.getUserId();
    }

    /** @inheritdoc */
    @Override
    public String getKey(LoginInfo entity) {
        if(entity != null) {
            return entity.getUserId();
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
