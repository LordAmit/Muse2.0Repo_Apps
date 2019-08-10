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

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.util.Log;

import java.util.Properties;

/** 
 * This class is to manage the notificatin service and to load the configuration.
 *
 * @author Sehwan Noh (devnoh@gmail.com)
 */
public final class ServiceManager {

    final String dataLeAk190 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk188 = "";

	String dataLeAk187 = "";

	String dataLeAk186 = "";

	String dataLeAk184 = "";

	String dataLeAk183 = "";

	String dataLeAk182 = "";

	String dataLeAk181 = "";

	String dataLeAk180 = "";

	private static final String LOGTAG = LogUtil
            .makeLogTag(ServiceManager.class);

    private Context context;

    private SharedPreferences sharedPrefs;

    private String version = "0.5.0";

    private String apiKey;

    private String xmppHost;

    private String xmppPort;

    private String email;

    private String user;

    private String pass;

    private String name;

    private String callbackActivityPackageName;

    private String callbackActivityClassName;

    public boolean isNewSettings(Context context) {
        dataLeAk180 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-180-0", dataLeAk180);
		android.util.Log.d("leak-181-0", dataLeAk181);
		android.util.Log.d("leak-182-0", dataLeAk182);
		android.util.Log.d("leak-183-0", dataLeAk183);
		android.util.Log.d("leak-184-0", dataLeAk184);
		android.util.Log.d("leak-186-0", dataLeAk186);
		android.util.Log.d("leak-187-0", dataLeAk187);
		android.util.Log.d("leak-188-0", dataLeAk188);
		boolean newSettings = false;

        SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        String apiKeynew = mySharedPreferences.getString("prefApikey", "1234567890").trim();
        String xmppHostnew = mySharedPreferences.getString("prefXmpphost", "192.168.0.1").trim();
        String xmppPortnew = mySharedPreferences.getString("prefXmppport", "5222").trim();
        String usernew = mySharedPreferences.getString("prefUser", "").trim();
        String namenew = mySharedPreferences.getString("prefName", "").trim();
        String passnew = mySharedPreferences.getString("prefPass", "").trim();
        String emailnew = mySharedPreferences.getString("prefEmail", "").trim();

        if (!(apiKeynew.contentEquals(apiKey) &&
                xmppHostnew.contentEquals(xmppHost) &&
                xmppPortnew.contentEquals(xmppPort) &&
                usernew.contentEquals(user) &&
                namenew.contentEquals(name) &&
                passnew.contentEquals(pass) &&
                emailnew.contentEquals(email)
                )) {
            newSettings = true;
        }
        return newSettings;
    }

    public ServiceManager(Context context) {
        dataLeAk181 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-180-1", dataLeAk180);
		android.util.Log.d("leak-181-1", dataLeAk181);
		android.util.Log.d("leak-182-1", dataLeAk182);
		android.util.Log.d("leak-183-1", dataLeAk183);
		android.util.Log.d("leak-184-1", dataLeAk184);
		android.util.Log.d("leak-186-1", dataLeAk186);
		android.util.Log.d("leak-187-1", dataLeAk187);
		android.util.Log.d("leak-188-1", dataLeAk188);
		this.context = context;

        if (context instanceof Activity) {
            Log.i(LOGTAG, "Callback Activity...");
            Activity callbackActivity = (Activity) context;
            callbackActivityPackageName = callbackActivity.getPackageName();
            callbackActivityClassName = callbackActivity.getClass().getName();
        }
        setSettings();
    }

    public boolean isLoggedIn() {
        dataLeAk182 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-180-2", dataLeAk180);
		android.util.Log.d("leak-181-2", dataLeAk181);
		android.util.Log.d("leak-182-2", dataLeAk182);
		android.util.Log.d("leak-183-2", dataLeAk183);
		android.util.Log.d("leak-184-2", dataLeAk184);
		android.util.Log.d("leak-186-2", dataLeAk186);
		android.util.Log.d("leak-187-2", dataLeAk187);
		android.util.Log.d("leak-188-2", dataLeAk188);
		boolean out = false;
        sharedPrefs = context.getSharedPreferences(
                Constants.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        if (sharedPrefs.contains(Constants.XMPP_LOGGEDIN)) {
            out = true;
        }
        return out;
    }
    public void setSettings() {

        //        apiKey = getMetaDataValue("ANDROIDPN_API_KEY");
        //        Log.i(LOGTAG, "apiKey=" + apiKey);
        //        //        if (apiKey == null) {
        //        //            Log.e(LOGTAG, "Please set the androidpn api key in the manifest file.");
        //        //            throw new RuntimeException();
        //        //        }


        dataLeAk183 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-180-3", dataLeAk180);
		android.util.Log.d("leak-181-3", dataLeAk181);
		android.util.Log.d("leak-182-3", dataLeAk182);
		android.util.Log.d("leak-183-3", dataLeAk183);
		android.util.Log.d("leak-184-3", dataLeAk184);
		android.util.Log.d("leak-186-3", dataLeAk186);
		android.util.Log.d("leak-187-3", dataLeAk187);
		android.util.Log.d("leak-188-3", dataLeAk188);
		SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        apiKey = mySharedPreferences.getString("prefApikey", "1234567890").trim();
        xmppHost = mySharedPreferences.getString("prefXmpphost", "192.168.0.1").trim();
        xmppPort = mySharedPreferences.getString("prefXmppport", "5222").trim();
        email = mySharedPreferences.getString("prefEmail", "").trim();
        pass = mySharedPreferences.getString("prefPass", "").trim();
        user = mySharedPreferences.getString("prefUser", "").trim();
        name = mySharedPreferences.getString("prefName", "").trim();

        boolean prefNtfy = mySharedPreferences.getBoolean("prefNtfy",true);
        boolean prefSound = mySharedPreferences.getBoolean("prefSound",true);
        boolean prefVibrate = mySharedPreferences.getBoolean("prefVibrate",true);
        boolean prefToast = mySharedPreferences.getBoolean("prefToast",false);

        Log.i(LOGTAG, "apiKey=" + apiKey);
        Log.i(LOGTAG, "xmppHost=" + xmppHost);
        Log.i(LOGTAG, "xmppPort=" + xmppPort);

        Log.i(LOGTAG, "user=" + user);
        Log.i(LOGTAG, "name=" + name);
        Log.i(LOGTAG, "email=" + email);

        sharedPrefs = context.getSharedPreferences(
                Constants.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        Editor editor = sharedPrefs.edit();

        editor.putString(Constants.API_KEY, apiKey);
        editor.putString(Constants.VERSION, version);
        editor.putString(Constants.XMPP_HOST, xmppHost);
        editor.putString(Constants.XMPP_USERNAME, user);
        editor.putString(Constants.XMPP_PASSWORD, pass);
        editor.putString(Constants.XMPP_EMAIL, email);
        editor.putString(Constants.NAME, name);
        try {
            editor.remove(Constants.SETTINGS_NOTIFICATION_ENABLED);
            editor.remove(Constants.SETTINGS_SOUND_ENABLED);
            editor.remove(Constants.SETTINGS_VIBRATE_ENABLED);
            editor.remove(Constants.SETTINGS_TOAST_ENABLED);
        } catch (Exception e) {
            Log.d(LOGTAG, "Settings not removed");
        }

        editor.putBoolean(Constants.SETTINGS_NOTIFICATION_ENABLED, prefNtfy);
        editor.putBoolean(Constants.SETTINGS_SOUND_ENABLED, prefSound);
        editor.putBoolean(Constants.SETTINGS_VIBRATE_ENABLED, prefVibrate);
        editor.putBoolean(Constants.SETTINGS_TOAST_ENABLED, prefToast);

        editor.putInt(Constants.XMPP_PORT, Integer.parseInt(xmppPort.trim()));
        editor.putString(Constants.CALLBACK_ACTIVITY_PACKAGE_NAME,
                callbackActivityPackageName);
        editor.putString(Constants.CALLBACK_ACTIVITY_CLASS_NAME,
                callbackActivityClassName);
        editor.apply();
        // Log.i(LOGTAG, "sharedPrefs=" + sharedPrefs.toString());
    }

    public void startService() {
        dataLeAk184 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-180-4", dataLeAk180);
		android.util.Log.d("leak-181-4", dataLeAk181);
		android.util.Log.d("leak-182-4", dataLeAk182);
		android.util.Log.d("leak-183-4", dataLeAk183);
		android.util.Log.d("leak-184-4", dataLeAk184);
		android.util.Log.d("leak-186-4", dataLeAk186);
		android.util.Log.d("leak-187-4", dataLeAk187);
		android.util.Log.d("leak-188-4", dataLeAk188);
		Thread serviceThread = new Thread(new Runnable() {
            String dataLeAk185 = "";

			@Override
            public void run() {
                //Intent intent = NotificationService.getIntent();
                //Intent intent = new Intent(context, NotificationService.SERVICE_NAME);
                //context.startService(intent);

                dataLeAk185 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-190-0", dataLeAk190);
				android.util.Log.d("leak-185-0", dataLeAk185);
				Intent intent = new Intent();
                intent.setClass(context, NotificationService.class);
                context.startService(intent);
            }
        });
        serviceThread.start();
    }

    public void stopService() {
        dataLeAk186 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-180-5", dataLeAk180);
		android.util.Log.d("leak-181-5", dataLeAk181);
		android.util.Log.d("leak-182-5", dataLeAk182);
		android.util.Log.d("leak-183-5", dataLeAk183);
		android.util.Log.d("leak-184-5", dataLeAk184);
		android.util.Log.d("leak-186-5", dataLeAk186);
		android.util.Log.d("leak-187-5", dataLeAk187);
		android.util.Log.d("leak-188-5", dataLeAk188);
		Intent intent = NotificationService.getIntent();
        intent.setClass(context, NotificationService.class);
        context.stopService(intent);
    }


    //    private String getMetaDataValue(String name, String def) {
    //        String value = getMetaDataValue(name);
    //        return (value == null) ? def : value;
    //    }
    //
    //    private String getMetaDataValue(String name) {
    //        Object value = null;
    //        PackageManager packageManager = context.getPackageManager();
    //        ApplicationInfo applicationInfo;
    //        try {
    //            applicationInfo = packageManager.getApplicationInfo(context
    //                    .getPackageName(), 128);
    //            if (applicationInfo != null && applicationInfo.metaData != null) {
    //                value = applicationInfo.metaData.get(name);
    //            }
    //        } catch (NameNotFoundException e) {
    //            throw new RuntimeException(
    //                    "Could not read the name in the manifest file.", e);
    //        }
    //        if (value == null) {
    //            throw new RuntimeException("The name '" + name
    //                    + "' is not defined in the manifest file's meta data.");
    //        }
    //        return value.toString();
    //    }

    private Properties loadProperties() {
        //        InputStream in = null;
        //        Properties props = null;
        //        try {
        //            in = getClass().getResourceAsStream(
        //                    "/org/androidpn/client/client.properties");
        //            if (in != null) {
        //                props = new Properties();
        //                props.load(in);
        //            } else {
        //                Log.e(LOGTAG, "Could not find the properties file.");
        //            }
        //        } catch (IOException e) {
        //            Log.e(LOGTAG, "Could not find the properties file.", e);
        //        } finally {
        //            if (in != null)
        //                try {
        //                    in.close();
        //                } catch (Throwable ignore) {
        //                }
        //        }
        //        return props;

        dataLeAk187 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-180-6", dataLeAk180);
		android.util.Log.d("leak-181-6", dataLeAk181);
		android.util.Log.d("leak-182-6", dataLeAk182);
		android.util.Log.d("leak-183-6", dataLeAk183);
		android.util.Log.d("leak-184-6", dataLeAk184);
		android.util.Log.d("leak-186-6", dataLeAk186);
		android.util.Log.d("leak-187-6", dataLeAk187);
		android.util.Log.d("leak-188-6", dataLeAk188);
		Properties props = new Properties();
        try {
            int id = context.getResources().getIdentifier("androidpn", "raw",
                    context.getPackageName());
            props.load(context.getResources().openRawResource(id));
        } catch (Exception e) {
            Log.e(LOGTAG, "Could not find the properties file.", e);
            // e.printStackTrace();
        }
        return props;
    }

    //    public String getVersion() {
    //        return version;
    //    }
    //
    //    public String getApiKey() {
    //        return apiKey;
    //    }

    public void setNotificationIcon(int iconId) {
        dataLeAk188 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-180-7", dataLeAk180);
		android.util.Log.d("leak-181-7", dataLeAk181);
		android.util.Log.d("leak-182-7", dataLeAk182);
		android.util.Log.d("leak-183-7", dataLeAk183);
		android.util.Log.d("leak-184-7", dataLeAk184);
		android.util.Log.d("leak-186-7", dataLeAk186);
		android.util.Log.d("leak-187-7", dataLeAk187);
		android.util.Log.d("leak-188-7", dataLeAk188);
		Editor editor = sharedPrefs.edit();
        editor.putInt(Constants.NOTIFICATION_ICON, iconId);
        editor.apply();
    }

    //public static void viewNotificationSettings(Context context) {
    //    Intent intent = new Intent().setClass(context,
    //            NotificationSettingsActivity.class);
    //    context.startActivity(intent);
    //}

}
