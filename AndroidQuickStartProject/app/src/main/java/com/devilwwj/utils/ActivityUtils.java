package com.devilwwj.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Activity工具类
 * Created by devilwwj on 15/9/2.
 */
public class ActivityUtils {

    public static void enterActivity(Activity activity, Class clz) {
        Intent intent = new Intent(activity, clz);
        activity.startActivity(intent);
    }

    public static void enterActivityForResult(Activity activity, Class clz, int requestCode) {
        Intent intent = new Intent(activity, clz);
        activity.startActivityForResult(intent, requestCode);
    }

    public static void enterActivityWithBundle(Activity activity, Class clz, Bundle bundle) {
        Intent intent = new Intent(activity, clz);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }
    
    public static void enterActivity(Activity activity, Intent intent) {
    	activity.startActivity(intent);
    }
    
    public static void enterActivity(Activity activity, Intent intent, int requestCode) {
    	activity.startActivityForResult(intent, requestCode);
    }
    



}
