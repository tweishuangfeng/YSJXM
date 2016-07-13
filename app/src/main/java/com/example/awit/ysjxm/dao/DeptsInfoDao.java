package com.example.awit.ysjxm.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

/**
 * Created by Lenvovo on 2016/6/24.
 */
public class DeptsInfoDao  extends AbstractDao<DeptsInfo, Void> {


    public static final String TABLENAME = "DEPTS_INFO";

    public static class Properties {
        public final static Property deptsid= new Property(0, String.class, "deptsid", false, "DEPTSID");
        public final static Property deptsname= new Property(1, String.class, "deptsname", false, "DEPTSNAME");
        public final static Property orgid = new Property(2, String.class, "orgid", false, "ORGID");
    };


    private DaoSession daoSession;

    private Query<DeptsInfo> organizationInfo_DeptsInfoListQuery;

    public DeptsInfoDao(DaoConfig config) {
        super(config);
    }

    public DeptsInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }


    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'DEPTS_INFO' (" + //
                "'DEPTSID' TEXT," + // 0: id
                "'DEPTSNAME' TEXT," + // 1: name

                "'ORGID' TEXT NOT NULL );"); // 3: orgid
    }


    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'DEPTS_INFO'";
        db.execSQL(sql);
    }



    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, DeptsInfo entity) {

        stmt.clearBindings();

        String deptsid = entity.getDeptsid();
        if (deptsid != null) {
            stmt.bindString(1, deptsid);
        }

        String deptsname = entity.getDeptsname();
        if (deptsname!= null) {
            stmt.bindString(2, deptsname);
        }


        String orgid = entity.getOrgid();
        if (orgid != null) {
            stmt.bindString(3, orgid);
        }


    }


    @Override
    protected void attachEntity(DeptsInfo entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }


    @Override
    public DeptsInfo readEntity(Cursor cursor, int offset) {
        DeptsInfo entity = new DeptsInfo( //
                cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // id
                cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
                cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // duty

        );
        return entity;
    }


    @Override
    public void readEntity(Cursor cursor, DeptsInfo entity, int offset) {
        entity.setDeptsid(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setDeptsname(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setOrgid(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
    }


    /** @inheritdoc */
    @Override
    protected Void updateKeyAfterInsert(DeptsInfo entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }

    /** @inheritdoc */
    @Override
    public Void getKey(DeptsInfo entity) {
        return null;
    }

    /** @inheritdoc */
    @Override
    protected boolean isEntityUpdateable() {
        return true;
    }



    /** Internal query to resolve the "deptsInfoList" to-many relationship of SsidInfo. */
    public List<DeptsInfo> _querySsidInfo_DeptsInfoList(String orgid) {
        synchronized (this) {
            if (organizationInfo_DeptsInfoListQuery == null) {
                QueryBuilder<DeptsInfo> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.orgid.eq(null));
                organizationInfo_DeptsInfoListQuery = queryBuilder.build();
            }
        }
        Query<DeptsInfo> query = organizationInfo_DeptsInfoListQuery.forCurrentThread();
        query.setParameter(0, orgid);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getOrganizationInfoDao().getAllColumns());
            builder.append(" FROM DEPTS_INFO T");
            builder.append(" LEFT JOIN SSID_INFO T0 ON T.'F_USER_ID'=T0.'USER_ID'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }

    protected DeptsInfo loadCurrentDeep(Cursor cursor, boolean lock) {
        DeptsInfo entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        OrganizationInfo organizationInfo= loadCurrentOther(daoSession.getOrganizationInfoDao(), cursor, offset);
        if(organizationInfo != null) {
            entity.setSsidInfo(organizationInfo);
        }

        return entity;
    }

    public DeptsInfo loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();

        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);

        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }

    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<DeptsInfo> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<DeptsInfo> list = new ArrayList<DeptsInfo>(count);

        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }

    protected List<DeptsInfo> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }


    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<DeptsInfo> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }




}
