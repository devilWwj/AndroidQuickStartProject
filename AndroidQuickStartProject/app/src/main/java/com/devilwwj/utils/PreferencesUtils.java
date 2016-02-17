package com.devilwwj.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * SharedPreference配置文件操作类
 * 主要用来存储用户配置，存储内容包括String和基本数据类型
 *
 * @author devilwwj
 * @time 16/2/16 下午11:02
 */
public class PreferencesUtils {
    public static String PREFERENCE_NAME = "devilwwj";


    private PreferencesUtils() {
        throw new AssertionError();
    }

    /**
     * 获取SharedPreferences实例对象
     * @param context
     * @return
     */
    public static SharedPreferences getSharedPreferences(Context context) {
        return getSharedPreferences(context);
    }

    /**
     * 写入String配置
     * @param context
     * @param key
     * @param value
     * @return
     */
    public static boolean putString(Context context, String key, String value) {
        SharedPreferences settings = getSharedPreferences(context);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);
        return editor.commit();
    }

    /**
     *
     * @param context
     * @param key
     * @return
     */
    public static String getString(Context context, String key) {
        return getString(context, key, null);
    }

    /**
     * 获取String配置
     * @param context
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getString(Context context, String key, String defaultValue) {
        SharedPreferences settings = getSharedPreferences(context);
        return settings.getString(key, defaultValue);
    }

    /**
     * 写入int配置
     * @param context
     * @param key
     * @param value
     * @return
     */
    public static boolean putInt(Context context, String key, int value) {
        SharedPreferences settings = getSharedPreferences(context);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(key, value);
        return editor.commit();
    }

    /**
     * 获取int配置
     * @param context
     * @param key
     * @return
     */
    public static int getInt(Context context, String key) {
        return getInt(context, key, -1);
    }

    /**
     * 获取int配置
     * @param context
     * @param key
     * @param defaultValue
     * @returnp
     */
    public static int getInt(Context context, String key, int defaultValue) {
        SharedPreferences settings = getSharedPreferences(context);
        return settings.getInt(key, defaultValue);
    }

    /**
     * 写入Long配置
     * @param context
     * @param key
     * @param value
     * @return
     */
    public static boolean putLong(Context context, String key, long value) {
        SharedPreferences settings = getSharedPreferences(context);
        SharedPreferences.Editor editor = settings.edit();
        editor.putLong(key, value);
        return editor.commit();
    }


    /**
     * 获取Long配置
     * @param context
     * @param key
     * @return
     */
    public static long getLong(Context context, String key) {
        return getLong(context, key, -1);
    }

    /**
     * 获取long配置
     * @param context
     * @param key
     * @param defaultValue
     * @return
     */
    public static long getLong(Context context, String key, long defaultValue) {
        SharedPreferences settings = getSharedPreferences(context);
        return settings.getLong(key, defaultValue);
    }

    /**
     * 写入Float配置
     * @param context
     * @param key
     * @param value
     * @return
     */
    public static boolean putFloat(Context context, String key, float value) {
        SharedPreferences settings = getSharedPreferences(context);
        SharedPreferences.Editor editor = settings.edit();
        editor.putFloat(key, value);
        return editor.commit();
    }

    /**
     * 获取Float配置
     * @param context
     * @param key
     * @return
     */
    public static float getFloat(Context context, String key) {
        return getFloat(context, key, -1);
    }

    /**
     * 获取Float配置
     * @param context
     * @param key
     * @param defaultValue
     * @return
     */
    public static float getFloat(Context context, String key, float defaultValue) {
        SharedPreferences settings = getSharedPreferences(context);
        return settings.getFloat(key, defaultValue);
    }

    /**
     * 写入Boolean配置
     * @param context
     * @param key
     * @param value
     * @return
     */
    public static boolean putBoolean(Context context, String key, boolean value) {
        SharedPreferences settings = getSharedPreferences(context);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(key, value);
        return editor.commit();
    }

    /**
     * 获取Boolean配置
     * @param context
     * @param key
     * @return
     */
    public static boolean getBoolean(Context context, String key) {
        return getBoolean(context, key, false);
    }

    /**
     * 获取Boolean配置
     * @param context
     * @param key
     * @param defaultValue
     * @return
     */
    public static boolean getBoolean(Context context, String key, boolean defaultValue) {
        SharedPreferences settings = getSharedPreferences(context);
        return settings.getBoolean(key, defaultValue);
    }

}
