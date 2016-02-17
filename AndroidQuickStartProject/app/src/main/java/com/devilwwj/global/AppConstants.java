package com.devilwwj.global;

import android.os.Environment;

/**
 * 常量类
 * @author devilwwj
 * @time 16/2/16 下午11:28
 */
public class AppConstants {
    public static final String KEY_PROTECT_APP = "key_protect_app";
    public static final String KEY_CLOSE_APP = "key_close_app";

    // SD卡根目录
    public static String SDCARD_ROOT_PATH = Environment
            .getExternalStorageDirectory().getAbsolutePath();

    // 应用根目录
    public static String ROOT_FOLDER_PATH = "/App";


    // 图片缓存路径
    public static final String IMAGELOADER_CACHE_PATH = ROOT_FOLDER_PATH
            + "/imagecache";





}
