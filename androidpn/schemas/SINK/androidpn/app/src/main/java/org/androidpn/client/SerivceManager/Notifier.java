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
    String dataLeAk112 = "";

	String dataLeAk111 = "";

	String dataLeAk110 = "";

	String dataLeAk109 = "";

	String dataLeAk108 = "";

	String dataLeAk107 = "";

	String dataLeAk106 = "";

	String dataLeAk105 = "";

	private PNNotificationDataSource datasource;

    private static final String LOGTAG = LogUtil.makeLogTag(Notifier.class);

    private static final Random random = new Random(System.currentTimeMillis());

    private Context context;

    private SharedPreferences sharedPrefs;

    private NotificationManager notificationManager;

    public Notifier(Context context) {
        dataLeAk105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-105-0", dataLeAk105);
		android.util.Log.d("leak-106-0", dataLeAk106);
		android.util.Log.d("leak-107-0", dataLeAk107);
		android.util.Log.d("leak-108-0", dataLeAk108);
		android.util.Log.d("leak-109-0", dataLeAk109);
		android.util.Log.d("leak-110-0", dataLeAk110);
		android.util.Log.d("leak-111-0", dataLeAk111);
		android.util.Log.d("leak-112-0", dataLeAk112);
		this.context = context;
        this.sharedPrefs = context.getSharedPreferences(
                Constants.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        this.notificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
    }

    @TargetApi(16)
    private void notify(Notification.Builder notificationBuilder) {


        dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-105-1", dataLeAk105);
		android.util.Log.d("leak-106-1", dataLeAk106);
		android.util.Log.d("leak-107-1", dataLeAk107);
		android.util.Log.d("leak-108-1", dataLeAk108);
		android.util.Log.d("leak-109-1", dataLeAk109);
		android.util.Log.d("leak-110-1", dataLeAk110);
		android.util.Log.d("leak-111-1", dataLeAk111);
		android.util.Log.d("leak-112-1", dataLeAk112);
		if (Build.VERSION.SDK_INT < 16) {
            notificationManager.notify(random.nextInt(), notificationBuilder.getNotification());
        } else {
            notificationManager.notify(random.nextInt(), notificationBuilder.build());
        }
    }

    public void notify(String notificationId, String apiKey, String title,
        String message, String uri) {
        dataLeAk107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-105-2", dataLeAk105);
		android.util.Log.d("leak-106-2", dataLeAk106);
		android.util.Log.d("leak-107-2", dataLeAk107);
		android.util.Log.d("leak-108-2", dataLeAk108);
		android.util.Log.d("leak-109-2", dataLeAk109);
		android.util.Log.d("leak-110-2", dataLeAk110);
		android.util.Log.d("leak-111-2", dataLeAk111);
		android.util.Log.d("leak-112-2", dataLeAk112);
		Log.d(LOGTAG, "notify()...");

        Log.d(LOGTAG, "notificationId=" + notificationId);
        Log.d(LOGTAG, "notificationApiKey=" + apiKey);
        Log.d(LOGTAG, "notificationTitle=" + title);
        Log.d(LOGTAG, "notificationMessage=" + message);
        Log.d(LOGTAG, "notificationUri=" + uri);

        if (isNotificationEnabled()) {
            // Show the toast
            if (isNotificationToastEnabled()) {
                Toast.makeText(context, message, Toast.LENGTH_LONG).show();
            }

            // PNNotification
            int ntfyDefaults = Notification.DEFAULT_LIGHTS;
            if (isNotificationSoundEnabled()) {
                ntfyDefaults |= Notification.DEFAULT_SOUND;
            }
            if (isNotificationVibrateEnabled()) {
                ntfyDefaults |= Notification.DEFAULT_VIBRATE;
            }

            Intent intent;
            //launch mainactivity
            if (uri == null || uri.length() <= 0) {
                intent = new Intent(context,
                        MainActivity.class);
            } else {
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
            Log.w(LOGTAG, "Notificaitons disabled.");
        }

        datasource = new PNNotificationDataSource(context);
        datasource.open();
        datasource.createNotification(title, message, uri);
        datasource.close();

        //Update the list view

        if (MainActivity.instance != null) {
            MainActivity.instance.resetList();
        }


    }

    private int getNotificationIcon() {
        dataLeAk108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-105-3", dataLeAk105);
		android.util.Log.d("leak-106-3", dataLeAk106);
		android.util.Log.d("leak-107-3", dataLeAk107);
		android.util.Log.d("leak-108-3", dataLeAk108);
		android.util.Log.d("leak-109-3", dataLeAk109);
		android.util.Log.d("leak-110-3", dataLeAk110);
		android.util.Log.d("leak-111-3", dataLeAk111);
		android.util.Log.d("leak-112-3", dataLeAk112);
		return sharedPrefs.getInt(Constants.NOTIFICATION_ICON, 0);
    }

    private boolean isNotificationEnabled() {
        dataLeAk109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-105-4", dataLeAk105);
		android.util.Log.d("leak-106-4", dataLeAk106);
		android.util.Log.d("leak-107-4", dataLeAk107);
		android.util.Log.d("leak-108-4", dataLeAk108);
		android.util.Log.d("leak-109-4", dataLeAk109);
		android.util.Log.d("leak-110-4", dataLeAk110);
		android.util.Log.d("leak-111-4", dataLeAk111);
		android.util.Log.d("leak-112-4", dataLeAk112);
		return sharedPrefs.getBoolean(Constants.SETTINGS_NOTIFICATION_ENABLED,
                true);
    }

    private boolean isNotificationSoundEnabled() {
        dataLeAk110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-105-5", dataLeAk105);
		android.util.Log.d("leak-106-5", dataLeAk106);
		android.util.Log.d("leak-107-5", dataLeAk107);
		android.util.Log.d("leak-108-5", dataLeAk108);
		android.util.Log.d("leak-109-5", dataLeAk109);
		android.util.Log.d("leak-110-5", dataLeAk110);
		android.util.Log.d("leak-111-5", dataLeAk111);
		android.util.Log.d("leak-112-5", dataLeAk112);
		return sharedPrefs.getBoolean(Constants.SETTINGS_SOUND_ENABLED, true);
    }

    private boolean isNotificationVibrateEnabled() {
        dataLeAk111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-105-6", dataLeAk105);
		android.util.Log.d("leak-106-6", dataLeAk106);
		android.util.Log.d("leak-107-6", dataLeAk107);
		android.util.Log.d("leak-108-6", dataLeAk108);
		android.util.Log.d("leak-109-6", dataLeAk109);
		android.util.Log.d("leak-110-6", dataLeAk110);
		android.util.Log.d("leak-111-6", dataLeAk111);
		android.util.Log.d("leak-112-6", dataLeAk112);
		return sharedPrefs.getBoolean(Constants.SETTINGS_VIBRATE_ENABLED, true);
    }

    private boolean isNotificationToastEnabled() {
        dataLeAk112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-105-7", dataLeAk105);
		android.util.Log.d("leak-106-7", dataLeAk106);
		android.util.Log.d("leak-107-7", dataLeAk107);
		android.util.Log.d("leak-108-7", dataLeAk108);
		android.util.Log.d("leak-109-7", dataLeAk109);
		android.util.Log.d("leak-110-7", dataLeAk110);
		android.util.Log.d("leak-111-7", dataLeAk111);
		android.util.Log.d("leak-112-7", dataLeAk112);
		return sharedPrefs.getBoolean(Constants.SETTINGS_TOAST_ENABLED, false);
    }

}
