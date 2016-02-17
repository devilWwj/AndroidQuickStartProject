package com.devilwwj.push;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.devilwwj.app.R;

import java.util.Random;

public class NotifyUtils {

	public static void notifyNewArticle(Context context, String msg, String aid) {
//		// 1 得到通知管理器
//		NotificationManager nm = (NotificationManager) context
//				.getSystemService(Context.NOTIFICATION_SERVICE);
//
//		// 2构建通知
//		Notification notification = new Notification(R.drawable.ic_launcher,
//				msg, System.currentTimeMillis());
//
//		Random r = new Random();
//		int notifyId = r.nextInt();
//
//		// 3设置通知的点击事件
//		Intent intent = new Intent(context, ArticleDetailActivity.class);
//
//		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//		intent.putExtra("ID", aid);
//		PendingIntent contentIntent = PendingIntent.getActivity(context,
//				notifyId, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//		notification.setLatestEventInfo(context, "南周周末", msg, contentIntent);
//
//		notification.flags = Notification.FLAG_AUTO_CANCEL;// 点击通知之后自动消失

//		// 4发送通知
//		nm.notify(notifyId, notification);

		Random r = new Random();
		int notifyId = r.nextInt();
		
		Intent broadcastIntent = new Intent(context, NotificationReceiver.class);
		broadcastIntent.putExtra("ID", Integer.valueOf(aid));
		PendingIntent pendingIntent = PendingIntent.getBroadcast(context, notifyId,
				broadcastIntent, PendingIntent.FLAG_UPDATE_CURRENT);

		NotificationCompat.Builder builder = new NotificationCompat.Builder(
				context);
		builder.setContentTitle("南周周末").setTicker(msg).setContentText(msg)
				.setContentIntent(pendingIntent)
				.setSmallIcon(R.mipmap.ic_launcher);

		Log.i("repeat", "showNotification");
		NotificationManager manager = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		manager.notify(notifyId, builder.build());
	}

}
