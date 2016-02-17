package com.devilwwj.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;

import java.util.List;

public class SystemUtils {

	/**
	 * 判断应用是否已经启动
	 * 
	 * @param context
	 * @param packageName
	 * @return
	 */
	public static boolean isAppAlive(Context context, String packageName) {
		ActivityManager activityManager = (ActivityManager) context
				.getSystemService(Context.ACTIVITY_SERVICE);

		List<ActivityManager.RunningAppProcessInfo> processInfos = activityManager
				.getRunningAppProcesses();

		for (int i = 0; i < processInfos.size(); i++) {
			if (processInfos.get(i).processName.equals(packageName)) {
				Log.i("NotificationLaunch", String.format(
						"the %s is running, isAppAlive return true",
						packageName));
				return true;
			}
		}
		Log.i("NotificationLaunch", String.format(
				"the %s is not running, isAppAlive return false", packageName));
		return false;

	}

}
