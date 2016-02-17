package com.devilwwj.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.devilwwj.activitys.MainActivity;
import com.devilwwj.utils.SystemUtils;

public class NotificationReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		// 判断app进程是否存活
		if (SystemUtils.isAppAlive(context, "net.coollet.infzmreader")) {
			Log.i("NotificationReceiver", "the app process is alive");
			Intent mainIntent = new Intent(context, MainActivity.class);
			mainIntent.putExtra("ID", intent.getIntExtra("ID", 0));
			mainIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

			Intent detailIntent = new Intent(context,
					MainActivity.class);
			detailIntent.putExtra("ID", intent.getIntExtra("ID", 0));

			Intent[] intents = { mainIntent, detailIntent };

			context.startActivities(intents);
		} else {
			Log.i("NotificationReceiver", "the app process is dead");
			Intent launchIntent = context.getPackageManager()
					.getLaunchIntentForPackage("net.coollet.infzmreader");
			launchIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
					| Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
			launchIntent.putExtra("ID", intent.getIntExtra("ID", 0));
			context.startActivity(launchIntent);
		}
	}
}