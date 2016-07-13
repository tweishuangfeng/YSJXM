package com.example.awit.ysjxm.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

/**
 * Created by Lenvovo on 2016/6/24.
 */
public class UnitInfoDao  extends AbstractDao<UnitInfo, String> {


    public static final String TABLENAME = "UNIT_INFO";

    /**
     * Properties of entity LoginInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */

    public static class Properties {
        public final static Property userid = new Property(0, String.class, "userid", true, "USERID");
        public final static Property orgid = new Property(1, String.class, "orgid", false, "ORGID");
        public final static Property departlistid= new Property(2, String.class, "departlistid", false, "DEPARTLISTID");
        public final static Property departnamelist=new Property(3,String.class, "departnamelist", false, "DEPARTNAMELIST");
        public final static Property unitlistid=new Property(4,String.class, "unitlistid", false, "UNITLISTID");
        public final static Property unitnamelist=new Property(5,String.class, "unitnamelist", false, "unitnamelist");

    };


    private DaoSession daoSession;


    public UnitInfoDao(DaoConfig config) {
        super(config);
    }

    public UnitInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'UNIT_INFO' (" + //
                "'USERID' TEXT PRIMARY KEY NOT NULL ," + // 0: userId
                "'ORGID' TEXT," + //
                "'DEPARTLISTID' TEXT," +
                "'DEPARTNAMELIST' TEXT"+//
                "'UNITLISTID' TEXT"+
                "'unitnamelist' TEXT"
        );
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'UNIT_INFO'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, UnitInfo entity) {
        stmt.clearBindings();

        String userid= entity.getUserid();
        if (userid!= null) {
            stmt.bindString(1, userid);
        }

        String orgid = entity.getOrgid();
        if (orgid != null) {
            stmt.bindString(2, orgid);
        }

        String departlistid = entity.getDepartlistid();
        if (departlistid!= null) {
            stmt.bindString(3, departlistid);
        }


        ArrayList<String> departnamelist=entity.getDepartnamelist();
        if(departnamelist!=null){

            stmt.bindString(4,departnamelist);
        }

        String unitlistid=entity.getUnitlistid();
        if(unitlistid!=null){

            stmt.bindString(5,unitlistid);
        }


        String  unitnamelist=entity.getUnitnamelist();
        if(unitnamelist!=null){

            stmt.bindString(6,unitnamelist);
        }



    }

    @Override
    protected void attachEntity(UnitInfo entity) {

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
    public UnitInfo readEntity(Cursor cursor, int offset) {
        UnitInfo entity = new OrganizationInfo( //
                cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // userId
                cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // account
                cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2),
                cursor.isNull(offset + 3) ? null : cursor.getColumnIndex(offset + 3)
        );
        return entity;
    }

    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, UnitInfo entity, int offset) {
        entity.setUserid(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setOrgid(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setDepartlistid(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setDepartnamelist(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setUnitlistid(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setUnitnamelist(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
    }

    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(UnitInfo entity, long rowId) {
        return entity.getUnitlistid();
    }

    /** @inheritdoc */
    @Override
    public String getKey(UnitInfo entity) {
        if(entity != null) {
            return entity.getUnitlistid();
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
