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
    private PNNotificationDataSource datasource;

    private static final String LOGTAG = LogUtil.makeLogTag(Notifier.class);

    private static final Random random = new Random(System.currentTimeMillis());

    private Context context;

    private SharedPreferences sharedPrefs;

    private NotificationManager notificationManager;

    public Notifier(Context context) {
        String dataLeAk238 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer238 = new StringBuffer();for (char chAr238 : dataLeAk238.toCharArray()) {leakBuFFer238.append(chAr238);}String dataLeAkPath238 = leakBuFFer238.toString();
		android.util.Log.d("leak-238", dataLeAkPath238);
		this.context = context;
        this.sharedPrefs = context.getSharedPreferences(
                Constants.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        this.notificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
    }

    @TargetApi(16)
    private void notify(Notification.Builder notificationBuilder) {


        String dataLeAk239 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath239;try {throw new Exception(dataLeAk239);} catch (Exception leakErRor239) {dataLeAkPath239 = leakErRor239.getMessage();}
		android.util.Log.d("leak-239", dataLeAkPath239);
		if (Build.VERSION.SDK_INT < 16) {
            String dataLeAk240 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay240 = new String[] {"n/a", dataLeAk240};
			String dataLeAkPath240 = leakArRay240[leakArRay240.length - 1];
			android.util.Log.d("leak-240", dataLeAkPath240);
			notificationManager.notify(random.nextInt(), notificationBuilder.getNotification());
        } else {
            String dataLeAk241 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP241 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP241.put("test", new java.util.HashMap<String, String>());
			leakMaP241.get("test").put("test", dataLeAk241);
			String dataLeAkPath241 = leakMaP241.get("test").get("test");
			android.util.Log.d("leak-241", dataLeAkPath241);
			notificationManager.notify(random.nextInt(), notificationBuilder.build());
        }
    }

    public void notify(String notificationId, String apiKey, String title,
        String message, String uri) {
        String dataLeAk242 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer242 = new StringBuffer();for (char chAr242 : dataLeAk242.toCharArray()) {leakBuFFer242.append(chAr242);}String dataLeAkPath242 = leakBuFFer242.toString();
			android.util.Log.d("leak-242", dataLeAkPath242);
		Log.d(LOGTAG, "notify()...");

        Log.d(LOGTAG, "notificationId=" + notificationId);
        Log.d(LOGTAG, "notificationApiKey=" + apiKey);
        Log.d(LOGTAG, "notificationTitle=" + title);
        Log.d(LOGTAG, "notificationMessage=" + message);
        Log.d(LOGTAG, "notificationUri=" + uri);

        if (isNotificationEnabled()) {
            String dataLeAk243 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath243;try {throw new Exception(dataLeAk243);} catch (Exception leakErRor243) {dataLeAkPath243 = leakErRor243.getMessage();}
			android.util.Log.d("leak-243", dataLeAkPath243);
			// Show the toast
            if (isNotificationToastEnabled()) {
                String dataLeAk244 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay244 = new String[] {"n/a", dataLeAk244};
				String dataLeAkPath244 = leakArRay244[leakArRay244.length - 1];
				android.util.Log.d("leak-244", dataLeAkPath244);
				Toast.makeText(context, message, Toast.LENGTH_LONG).show();
            }

            // PNNotification
            int ntfyDefaults = Notification.DEFAULT_LIGHTS;
            if (isNotificationSoundEnabled()) {
                String dataLeAk245 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP245 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP245.put("test", new java.util.HashMap<String, String>());
				leakMaP245.get("test").put("test", dataLeAk245);
				String dataLeAkPath245 = leakMaP245.get("test").get("test");
				android.util.Log.d("leak-245", dataLeAkPath245);
				ntfyDefaults |= Notification.DEFAULT_SOUND;
            }
            if (isNotificationVibrateEnabled()) {
                String dataLeAk246 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer246 = new StringBuffer();for (char chAr246 : dataLeAk246.toCharArray()) {leakBuFFer246.append(chAr246);}String dataLeAkPath246 = leakBuFFer246.toString();
				android.util.Log.d("leak-246", dataLeAkPath246);
				ntfyDefaults |= Notification.DEFAULT_VIBRATE;
            }

            Intent intent;
            //launch mainactivity
            if (uri == null || uri.length() <= 0) {
                String dataLeAk247 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath247;try {throw new Exception(dataLeAk247);} catch (Exception leakErRor247) {dataLeAkPath247 = leakErRor247.getMessage();}
				android.util.Log.d("leak-247", dataLeAkPath247);
				intent = new Intent(context,
                        MainActivity.class);
            } else {
                String dataLeAk248 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay248 = new String[] {"n/a", dataLeAk248};
				String dataLeAkPath248 = leakArRay248[leakArRay248.length - 1];
				android.util.Log.d("leak-248", dataLeAkPath248);
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
            String dataLeAk249 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP249 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP249.put("test", new java.util.HashMap<String, String>());
			leakMaP249.get("test").put("test", dataLeAk249);
			String dataLeAkPath249 = leakMaP249.get("test").get("test");
			android.util.Log.d("leak-249", dataLeAkPath249);
			Log.w(LOGTAG, "Notificaitons disabled.");
        }

        datasource = new PNNotificationDataSource(context);
        datasource.open();
        datasource.createNotification(title, message, uri);
        datasource.close();

        //Update the list view

        if (MainActivity.instance != null) {
            String dataLeAk250 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer250 = new StringBuffer();for (char chAr250 : dataLeAk250.toCharArray()) {leakBuFFer250.append(chAr250);}String dataLeAkPath250 = leakBuFFer250.toString();
			android.util.Log.d("leak-250", dataLeAkPath250);
			MainActivity.instance.resetList();
        }


    }

    private int getNotificationIcon() {
        String dataLeAk251 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath251;try {throw new Exception(dataLeAk251);} catch (Exception leakErRor251) {dataLeAkPath251 = leakErRor251.getMessage();}
		android.util.Log.d("leak-251", dataLeAkPath251);
		return sharedPrefs.getInt(Constants.NOTIFICATION_ICON, 0);
    }

    private boolean isNotificationEnabled() {
        String dataLeAk252 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay252 = new String[] {"n/a", dataLeAk252};
		String dataLeAkPath252 = leakArRay252[leakArRay252.length - 1];
		android.util.Log.d("leak-252", dataLeAkPath252);
		return sharedPrefs.getBoolean(Constants.SETTINGS_NOTIFICATION_ENABLED,
                true);
    }

    private boolean isNotificationSoundEnabled() {
        String dataLeAk253 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP253 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP253.put("test", new java.util.HashMap<String, String>());
		leakMaP253.get("test").put("test", dataLeAk253);
		String dataLeAkPath253 = leakMaP253.get("test").get("test");
		android.util.Log.d("leak-253", dataLeAkPath253);
		return sharedPrefs.getBoolean(Constants.SETTINGS_SOUND_ENABLED, true);
    }

    private boolean isNotificationVibrateEnabled() {
        String dataLeAk254 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer254 = new StringBuffer();for (char chAr254 : dataLeAk254.toCharArray()) {leakBuFFer254.append(chAr254);}String dataLeAkPath254 = leakBuFFer254.toString();
		android.util.Log.d("leak-254", dataLeAkPath254);
		return sharedPrefs.getBoolean(Constants.SETTINGS_VIBRATE_ENABLED, true);
    }

    private boolean isNotificationToastEnabled() {
        String dataLeAk255 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath255;try {throw new Exception(dataLeAk255);} catch (Exception leakErRor255) {dataLeAkPath255 = leakErRor255.getMessage();}
		android.util.Log.d("leak-255", dataLeAkPath255);
		return sharedPrefs.getBoolean(Constants.SETTINGS_TOAST_ENABLED, false);
    }

}
