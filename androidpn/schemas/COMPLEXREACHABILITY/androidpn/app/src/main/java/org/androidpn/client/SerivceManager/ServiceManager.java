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
        String dataLeAk341 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP341 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP341.put("test", new java.util.HashMap<String, String>());
		leakMaP341.get("test").put("test", dataLeAk341);
		String dataLeAkPath341 = leakMaP341.get("test").get("test");
		android.util.Log.d("leak-341", dataLeAkPath341);
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
            String dataLeAk342 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer342 = new StringBuffer();for (char chAr342 : dataLeAk342.toCharArray()) {leakBuFFer342.append(chAr342);}String dataLeAkPath342 = leakBuFFer342.toString();
					android.util.Log.d("leak-342", dataLeAkPath342);
			newSettings = true;
        }
        return newSettings;
    }

    public ServiceManager(Context context) {
        String dataLeAk343 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath343;try {throw new Exception(dataLeAk343);} catch (Exception leakErRor343) {dataLeAkPath343 = leakErRor343.getMessage();}
		android.util.Log.d("leak-343", dataLeAkPath343);
		this.context = context;

        if (context instanceof Activity) {
            String dataLeAk344 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay344 = new String[] {"n/a", dataLeAk344};
			String dataLeAkPath344 = leakArRay344[leakArRay344.length - 1];
			android.util.Log.d("leak-344", dataLeAkPath344);
			Log.i(LOGTAG, "Callback Activity...");
            Activity callbackActivity = (Activity) context;
            callbackActivityPackageName = callbackActivity.getPackageName();
            callbackActivityClassName = callbackActivity.getClass().getName();
        }
        setSettings();
    }

    public boolean isLoggedIn() {
        String dataLeAk345 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP345 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP345.put("test", new java.util.HashMap<String, String>());
		leakMaP345.get("test").put("test", dataLeAk345);
		String dataLeAkPath345 = leakMaP345.get("test").get("test");
		android.util.Log.d("leak-345", dataLeAkPath345);
		boolean out = false;
        sharedPrefs = context.getSharedPreferences(
                Constants.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        if (sharedPrefs.contains(Constants.XMPP_LOGGEDIN)) {
            String dataLeAk346 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer346 = new StringBuffer();for (char chAr346 : dataLeAk346.toCharArray()) {leakBuFFer346.append(chAr346);}String dataLeAkPath346 = leakBuFFer346.toString();
			android.util.Log.d("leak-346", dataLeAkPath346);
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


        String dataLeAk347 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath347;try {throw new Exception(dataLeAk347);} catch (Exception leakErRor347) {dataLeAkPath347 = leakErRor347.getMessage();}
		android.util.Log.d("leak-347", dataLeAkPath347);
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
            String dataLeAk348 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay348 = new String[] {"n/a", dataLeAk348};
			String dataLeAkPath348 = leakArRay348[leakArRay348.length - 1];
			android.util.Log.d("leak-348", dataLeAkPath348);
			editor.remove(Constants.SETTINGS_NOTIFICATION_ENABLED);
            editor.remove(Constants.SETTINGS_SOUND_ENABLED);
            editor.remove(Constants.SETTINGS_VIBRATE_ENABLED);
            editor.remove(Constants.SETTINGS_TOAST_ENABLED);
        } catch (Exception e) {
            String dataLeAk349 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP349 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP349.put("test", new java.util.HashMap<String, String>());
			leakMaP349.get("test").put("test", dataLeAk349);
			String dataLeAkPath349 = leakMaP349.get("test").get("test");
			android.util.Log.d("leak-349", dataLeAkPath349);
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
        String dataLeAk350 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer350 = new StringBuffer();for (char chAr350 : dataLeAk350.toCharArray()) {leakBuFFer350.append(chAr350);}String dataLeAkPath350 = leakBuFFer350.toString();
		android.util.Log.d("leak-350", dataLeAkPath350);
		Thread serviceThread = new Thread(new Runnable() {
            @Override
            public void run() {
                //Intent intent = NotificationService.getIntent();
                //Intent intent = new Intent(context, NotificationService.SERVICE_NAME);
                //context.startService(intent);

                String dataLeAk351 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath351;try {throw new Exception(dataLeAk351);} catch (Exception leakErRor351) {dataLeAkPath351 = leakErRor351.getMessage();}
				android.util.Log.d("leak-351", dataLeAkPath351);
				Intent intent = new Intent();
                intent.setClass(context, NotificationService.class);
                context.startService(intent);
            }
        });
        serviceThread.start();
    }

    public void stopService() {
        String dataLeAk352 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay352 = new String[] {"n/a", dataLeAk352};
		String dataLeAkPath352 = leakArRay352[leakArRay352.length - 1];
		android.util.Log.d("leak-352", dataLeAkPath352);
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

        String dataLeAk353 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP353 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP353.put("test", new java.util.HashMap<String, String>());
		leakMaP353.get("test").put("test", dataLeAk353);
		String dataLeAkPath353 = leakMaP353.get("test").get("test");
		android.util.Log.d("leak-353", dataLeAkPath353);
		Properties props = new Properties();
        try {
            String dataLeAk354 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer354 = new StringBuffer();for (char chAr354 : dataLeAk354.toCharArray()) {leakBuFFer354.append(chAr354);}String dataLeAkPath354 = leakBuFFer354.toString();
			android.util.Log.d("leak-354", dataLeAkPath354);
			int id = context.getResources().getIdentifier("androidpn", "raw",
                    context.getPackageName());
            props.load(context.getResources().openRawResource(id));
        } catch (Exception e) {
            String dataLeAk355 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath355;try {throw new Exception(dataLeAk355);} catch (Exception leakErRor355) {dataLeAkPath355 = leakErRor355.getMessage();}
			android.util.Log.d("leak-355", dataLeAkPath355);
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
        String dataLeAk356 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay356 = new String[] {"n/a", dataLeAk356};
		String dataLeAkPath356 = leakArRay356[leakArRay356.length - 1];
		android.util.Log.d("leak-356", dataLeAkPath356);
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
