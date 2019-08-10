/*
 * Copyright (C) 2010 Moduad Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.androidpn.client.SerivceManager;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.util.Log;
import android.widget.Toast;

import org.androidpn.client.PNNotificationDataSource;

import java.util.Random;

import org.androidpn.client.MainActivity;

/** 
 * This class is to notify the user of messages with NotificationManager.
 *
 * @author Sehwan Noh (devnoh@gmail.com)
 */
public class Notifier {
    String dataLeAk265 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk265 = android.util.Log.d("leak-265", dataLeAk265);

	private PNNotificationDataSource datasource;

    private static final String LOGTAG = LogUtil.makeLogTag(Notifier.class);

    private static final Random random = new Random(System.currentTimeMillis());

    private Context context;

    private SharedPreferences sharedPrefs;

    private NotificationManager notificationManager;

    public Notifier(Context context) {
        String dataLeAk266 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk266 = android.util.Log.d("leak-266", dataLeAk266);
		this.context = context;
        this.sharedPrefs = context.getSharedPreferences(
                Constants.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        this.notificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
    }

    @TargetApi(16)
    private void notify(Notification.Builder notificationBuilder) {


        String dataLeAk267 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk267 = android.util.Log.d("leak-267", dataLeAk267);
		if (Build.VERSION.SDK_INT < 16) {
            String dataLeAk268 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk268 = android.util.Log.d("leak-268", dataLeAk268);
			notificationManager.notify(random.nextInt(), notificationBuilder.getNotification());
        } else {
            String dataLeAk269 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk269 = android.util.Log.d("leak-269", dataLeAk269);
			notificationManager.notify(random.nextInt(), notificationBuilder.build());
        }
    }

    public void notify(String notificationId, String apiKey, String title,
        String message, String uri) {
        String dataLeAk270 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk270 = android.util.Log.d("leak-270", dataLeAk270);
		Log.d(LOGTAG, "notify()...");

        Log.d(LOGTAG, "notificationId=" + notificationId);
        Log.d(LOGTAG, "notificationApiKey=" + apiKey);
        Log.d(LOGTAG, "notificationTitle=" + title);
        Log.d(LOGTAG, "notificationMessage=" + message);
        Log.d(LOGTAG, "notificationUri=" + uri);

        if (isNotificationEnabled()) {
            String dataLeAk271 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk271 = android.util.Log.d("leak-271", dataLeAk271);
			// Show the toast
            if (isNotificationToastEnabled()) {
                String dataLeAk272 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk272 = android.util.Log.d("leak-272", dataLeAk272);
				Toast.makeText(context, message, Toast.LENGTH_LONG).show();
            }

            // PNNotification
            int ntfyDefaults = Notification.DEFAULT_LIGHTS;
            if (isNotificationSoundEnabled()) {
                String dataLeAk273 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk273 = android.util.Log.d("leak-273", dataLeAk273);
				ntfyDefaults |= Notification.DEFAULT_SOUND;
            }
            if (isNotificationVibrateEnabled()) {
                String dataLeAk274 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk274 = android.util.Log.d("leak-274", dataLeAk274);
				ntfyDefaults |= Notification.DEFAULT_VIBRATE;
            }

            Intent intent;
            //launch mainactivity
            if (uri == null || uri.length() <= 0) {
                String dataLeAk275 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk275 = android.util.Log.d("leak-275", dataLeAk275);
				intent = new Intent(context,
                        MainActivity.class);
            } else {
                String dataLeAk276 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk276 = android.util.Log.d("leak-276", dataLeAk276);
				intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(uri));
            }
            /*
            intent.putExtra(Constants.NOTIFICATION_ID, notificationId);
            intent.putExtra(Constants.NOTIFICATION_API_KEY, apiKey);
            intent.putExtra(Constants.NOTIFICATION_TITLE, title);
            intent.putExtra(Constants.NOTIFICATION_MESSAGE, message);
            intent.putExtra(Constants.NOTIFICATION_URI, uri);*/
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
                    intent, PendingIntent.FLAG_UPDATE_CURRENT);

            Notification.Builder notification = new Notification.Builder(context)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setSmallIcon(getNotificationIcon())
                    .setDefaults(ntfyDefaults)
                    .setContentIntent(contentIntent)
                    //.setLargeIcon(R.drawable.notification)
                    .setWhen(System.currentTimeMillis())
                    .setTicker(message);

            notify(notification);

            //notification.flags |= PNNotification.FLAG_AUTO_CANCEL;

            //            Intent intent;
            //            if (uri != null
            //                    && uri.length() > 0
            //                    && (uri.startsWith("http:") || uri.startsWith("https:")
            //                            || uri.startsWith("tel:") || uri.startsWith("geo:"))) {
            //                intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            //            } else {
            //                String callbackActivityPackageName = sharedPrefs.getString(
            //                        Constants.CALLBACK_ACTIVITY_PACKAGE_NAME, "");
            //                String callbackActivityClassName = sharedPrefs.getString(
            //                        Constants.CALLBACK_ACTIVITY_CLASS_NAME, "");
            //                intent = new Intent().setClassName(callbackActivityPackageName,
            //                        callbackActivityClassName);
            //                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            //            }


            //notification.setLatestEventInfo(context, title, message,
            //        contentIntent);
            //notificationManager.notify(random.nextInt(), notification);

            //            Intent clickIntent = new Intent(
            //                    Constants.ACTION_NOTIFICATION_CLICKED);
            //            clickIntent.putExtra(Constants.NOTIFICATION_ID, notificationId);
            //            clickIntent.putExtra(Constants.NOTIFICATION_API_KEY, apiKey);
            //            clickIntent.putExtra(Constants.NOTIFICATION_TITLE, title);
            //            clickIntent.putExtra(Constants.NOTIFICATION_MESSAGE, message);
            //            clickIntent.putExtra(Constants.NOTIFICATION_URI, uri);
            //            //        positiveIntent.setData(Uri.parse((new StringBuilder(
            //            //                "notif://notification.adroidpn.org/")).append(apiKey).append(
            //            //                "/").append(System.currentTimeMillis()).toString()));
            //            PendingIntent clickPendingIntent = PendingIntent.getBroadcast(
            //                    context, 0, clickIntent, 0);
            //
            //            notification.setLatestEventInfo(context, title, message,
            //                    clickPendingIntent);
            //
            //            Intent clearIntent = new Intent(
            //                    Constants.ACTION_NOTIFICATION_CLEARED);
            //            clearIntent.putExtra(Constants.NOTIFICATION_ID, notificationId);
            //            clearIntent.putExtra(Constants.NOTIFICATION_API_KEY, apiKey);
            //            //        negativeIntent.setData(Uri.parse((new StringBuilder(
            //            //                "notif://notification.adroidpn.org/")).append(apiKey).append(
            //            //                "/").append(System.currentTimeMillis()).toString()));
            //            PendingIntent clearPendingIntent = PendingIntent.getBroadcast(
            //                    context, 0, clearIntent, 0);
            //            notification.deleteIntent = clearPendingIntent;
            //
            //            notificationManager.notify(random.nextInt(), notification);

        } else {
            String dataLeAk277 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk277 = android.util.Log.d("leak-277", dataLeAk277);
			Log.w(LOGTAG, "Notificaitons disabled.");
        }

        datasource = new PNNotificationDataSource(context);
        datasource.open();
        datasource.createNotification(title, message, uri);
        datasource.close();

        //Update the list view

        if (MainActivity.instance != null) {
            String dataLeAk278 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk278 = android.util.Log.d("leak-278", dataLeAk278);
			MainActivity.instance.resetList();
        }


    }

    private int getNotificationIcon() {
        String dataLeAk279 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk279 = android.util.Log.d("leak-279", dataLeAk279);
		return sharedPrefs.getInt(Constants.NOTIFICATION_ICON, 0);
    }

    private boolean isNotificationEnabled() {
        String dataLeAk280 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk280 = android.util.Log.d("leak-280", dataLeAk280);
		return sharedPrefs.getBoolean(Constants.SETTINGS_NOTIFICATION_ENABLED,
                true);
    }

    private boolean isNotificationSoundEnabled() {
        String dataLeAk281 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk281 = android.util.Log.d("leak-281", dataLeAk281);
		return sharedPrefs.getBoolean(Constants.SETTINGS_SOUND_ENABLED, true);
    }

    private boolean isNotificationVibrateEnabled() {
        String dataLeAk282 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk282 = android.util.Log.d("leak-282", dataLeAk282);
		return sharedPrefs.getBoolean(Constants.SETTINGS_VIBRATE_ENABLED, true);
    }

    private boolean isNotificationToastEnabled() {
        String dataLeAk283 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk283 = android.util.Log.d("leak-283", dataLeAk283);
		return sharedPrefs.getBoolean(Constants.SETTINGS_TOAST_ENABLED, false);
    }

}
