package com.devilwwj.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.devilwwj.model.User;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * 数据库帮助类
 * 用于数据库和表的创建、更新
 * com.devilwwj.fragments
 * Created by devilwwj on 16/2/17.
 */
public class DBHelper extends OrmLiteSqliteOpenHelper {

    /**
     * 数据库名字
     */
    private static final String DB_NAME = "test.db";
    /**
     * 数据库版本
     */
    private static final int DB_VERSION = 1;

    /**
     * 用来存放Dao的地图
     */
    private Map<String, Dao> daos = new HashMap<String, Dao>();



    private static DBHelper instance;



    /**
     * 获取单例
     * @param context
     * @return
     */
    public static synchronized DBHelper getHelper(Context context) {
        context = context.getApplicationContext();
        if (instance == null) {
            synchronized (DBHelper.class) {
                if (instance == null) {
                    instance = new DBHelper(context);
                }
            }
        }
        return instance;
    }


    /**
     * 构造方法
     * @param context
     */
    private DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    /**
     * 创建表
     * @param database
     * @param connectionSource
     */
    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        // 创建表
        try {
            // 示例
            TableUtils.createTable(connectionSource, User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    /**
     * 更新表
     * @param database
     * @param connectionSource
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            // 示例
            TableUtils.dropTable(connectionSource, User.class, true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过类来获得指定的Dao
     */
    public synchronized Dao getDao(Class clazz) throws SQLException {
        Dao dao = null;
        String className = clazz.getSimpleName();
        if (daos.containsKey(className)) {
            dao = super.getDao(clazz);
            daos.put(className, dao);
        } else {
            dao = daos.get(className);
        }
        return dao;
    }


    /**
     * 释放资源
     */
    @Override
    public void close() {
        super.close();
        for (String key : daos.keySet()) {
            Dao dao = daos.get(key);
            dao = null;
        }
    }


}
