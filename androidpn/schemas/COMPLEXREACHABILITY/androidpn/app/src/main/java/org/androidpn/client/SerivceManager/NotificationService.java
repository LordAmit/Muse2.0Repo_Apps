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

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Service that continues to run in background and respond to the push 
 * notification events from the server. This should be registered as service
 * in AndroidManifest.xml. 
 * 
 * @author Sehwan Noh (devnoh@gmail.com)
 */
public class NotificationService extends Service {

    private static final String LOGTAG = LogUtil
            .makeLogTag(NotificationService.class);

    public static final String SERVICE_NAME = "org.androidpn.client.client.NotificationService.NotificationService";

    private TelephonyManager telephonyManager;

    //    private WifiManager wifiManager;
    //
    //    private ConnectivityManager connectivityManager;

    private BroadcastReceiver notificationReceiver;

    private BroadcastReceiver connectivityReceiver;

    private PhoneStateListener phoneStateListener;

    private ExecutorService executorService;

    private TaskSubmitter taskSubmitter;

    private TaskTracker taskTracker;

    private XmppManager xmppManager;

    private SharedPreferences sharedPrefs;

    private String deviceId;

    public NotificationService() {
        String dataLeAk261 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP261 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP261.put("test", new java.util.HashMap<String, String>());
		leakMaP261.get("test").put("test", dataLeAk261);
		String dataLeAkPath261 = leakMaP261.get("test").get("test");
		android.util.Log.d("leak-261", dataLeAkPath261);
		notificationReceiver = new NotificationReceiver();
        connectivityReceiver = new ConnectivityReceiver(this);
        phoneStateListener = new PhoneStateChangeListener(this);
        executorService = Executors.newSingleThreadExecutor();
        taskSubmitter = new TaskSubmitter(this);
        taskTracker = new TaskTracker(this);
    }

    @Override
    public void onCreate() {
        String dataLeAk262 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer262 = new StringBuffer();for (char chAr262 : dataLeAk262.toCharArray()) {leakBuFFer262.append(chAr262);}String dataLeAkPath262 = leakBuFFer262.toString();
		android.util.Log.d("leak-262", dataLeAkPath262);
		Log.d(LOGTAG, "onCreate()...");
        telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        // wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        // connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        sharedPrefs = getSharedPreferences(Constants.SHARED_PREFERENCE_NAME,
                Context.MODE_PRIVATE);

        // Get deviceId
        deviceId = telephonyManager.getDeviceId();
        // Log.d(LOGTAG, "deviceId=" + deviceId);
        Editor editor = sharedPrefs.edit();
        editor.putString(Constants.DEVICE_ID, deviceId);
        editor.apply();

        // If running on an emulator
        if (deviceId == null || deviceId.trim().length() == 0
                || deviceId.matches("0+")) {
            String dataLeAk263 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath263;try {throw new Exception(dataLeAk263);} catch (Exception leakErRor263) {dataLeAkPath263 = leakErRor263.getMessage();}
					android.util.Log.d("leak-263", dataLeAkPath263);
			if (sharedPrefs.contains("EMULATOR_DEVICE_ID")) {
                String dataLeAk264 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay264 = new String[] {"n/a", dataLeAk264};
				String dataLeAkPath264 = leakArRay264[leakArRay264.length - 1];
				android.util.Log.d("leak-264", dataLeAkPath264);
				deviceId = sharedPrefs.getString(Constants.EMULATOR_DEVICE_ID,
                        "");
            } else {
                String dataLeAk265 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP265 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP265.put("test", new java.util.HashMap<String, String>());
				leakMaP265.get("test").put("test", dataLeAk265);
				String dataLeAkPath265 = leakMaP265.get("test").get("test");
				android.util.Log.d("leak-265", dataLeAkPath265);
				deviceId = (new StringBuilder("EMU")).append(
                        (new Random(System.currentTimeMillis())).nextLong())
                        .toString();
                editor.putString(Constants.EMULATOR_DEVICE_ID, deviceId);
                editor.apply();
            }
        }
        Log.d(LOGTAG, "deviceId=" + deviceId);

        xmppManager = new XmppManager(this);

        taskSubmitter.submit(new Runnable() {
            public void run() {
                String dataLeAk266 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer266 = new StringBuffer();for (char chAr266 : dataLeAk266.toCharArray()) {leakBuFFer266.append(chAr266);}String dataLeAkPath266 = leakBuFFer266.toString();
				android.util.Log.d("leak-266", dataLeAkPath266);
				NotificationService.this.start();
            }
        });
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String dataLeAk267 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath267;try {throw new Exception(dataLeAk267);} catch (Exception leakErRor267) {dataLeAkPath267 = leakErRor267.getMessage();}
		android.util.Log.d("leak-267", dataLeAkPath267);
		Log.d(LOGTAG, "onStart()...");
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        String dataLeAk268 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay268 = new String[] {"n/a", dataLeAk268};
		String dataLeAkPath268 = leakArRay268[leakArRay268.length - 1];
		android.util.Log.d("leak-268", dataLeAkPath268);
		Log.d(LOGTAG, "onDestroy()...");
        stop();
    }

    @Override
    public IBinder onBind(Intent intent) {
        String dataLeAk269 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP269 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP269.put("test", new java.util.HashMap<String, String>());
		leakMaP269.get("test").put("test", dataLeAk269);
		String dataLeAkPath269 = leakMaP269.get("test").get("test");
		android.util.Log.d("leak-269", dataLeAkPath269);
		Log.d(LOGTAG, "onBind()...");
        return null;
    }

    @Override
    public void onRebind(Intent intent) {
        String dataLeAk270 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer270 = new StringBuffer();for (char chAr270 : dataLeAk270.toCharArray()) {leakBuFFer270.append(chAr270);}String dataLeAkPath270 = leakBuFFer270.toString();
		android.util.Log.d("leak-270", dataLeAkPath270);
		Log.d(LOGTAG, "onRebind()...");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        String dataLeAk271 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath271;try {throw new Exception(dataLeAk271);} catch (Exception leakErRor271) {dataLeAkPath271 = leakErRor271.getMessage();}
		android.util.Log.d("leak-271", dataLeAkPath271);
		Log.d(LOGTAG, "onUnbind()...");
        return true;
    }

    public static Intent getIntent() {
        String dataLeAk272 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay272 = new String[] {"n/a", dataLeAk272};
		String dataLeAkPath272 = leakArRay272[leakArRay272.length - 1];
		android.util.Log.d("leak-272", dataLeAkPath272);
		//return new Intent(SERVICE_NAME);
        return new Intent(NotificationService.class.getName());

    }

    public ExecutorService getExecutorService() {
        String dataLeAk273 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP273 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP273.put("test", new java.util.HashMap<String, String>());
		leakMaP273.get("test").put("test", dataLeAk273);
		String dataLeAkPath273 = leakMaP273.get("test").get("test");
		android.util.Log.d("leak-273", dataLeAkPath273);
		return executorService;
    }

    public TaskSubmitter getTaskSubmitter() {
        String dataLeAk274 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer274 = new StringBuffer();for (char chAr274 : dataLeAk274.toCharArray()) {leakBuFFer274.append(chAr274);}String dataLeAkPath274 = leakBuFFer274.toString();
		android.util.Log.d("leak-274", dataLeAkPath274);
		return taskSubmitter;
    }

    public TaskTracker getTaskTracker() {
        String dataLeAk275 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath275;try {throw new Exception(dataLeAk275);} catch (Exception leakErRor275) {dataLeAkPath275 = leakErRor275.getMessage();}
		android.util.Log.d("leak-275", dataLeAkPath275);
		return taskTracker;
    }

    public XmppManager getXmppManager() {
        String dataLeAk276 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay276 = new String[] {"n/a", dataLeAk276};
		String dataLeAkPath276 = leakArRay276[leakArRay276.length - 1];
		android.util.Log.d("leak-276", dataLeAkPath276);
		return xmppManager;
    }

    public SharedPreferences getSharedPreferences() {
        String dataLeAk277 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP277 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP277.put("test", new java.util.HashMap<String, String>());
		leakMaP277.get("test").put("test", dataLeAk277);
		String dataLeAkPath277 = leakMaP277.get("test").get("test");
		android.util.Log.d("leak-277", dataLeAkPath277);
		return sharedPrefs;
    }

    public String getDeviceId() {
        String dataLeAk278 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer278 = new StringBuffer();for (char chAr278 : dataLeAk278.toCharArray()) {leakBuFFer278.append(chAr278);}String dataLeAkPath278 = leakBuFFer278.toString();
		android.util.Log.d("leak-278", dataLeAkPath278);
		return deviceId;
    }

    public void connect() {
        String dataLeAk279 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath279;try {throw new Exception(dataLeAk279);} catch (Exception leakErRor279) {dataLeAkPath279 = leakErRor279.getMessage();}
		android.util.Log.d("leak-279", dataLeAkPath279);
		Log.d(LOGTAG, "connect()...");
        taskSubmitter.submit(new Runnable() {
            public void run() {
                String dataLeAk280 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay280 = new String[] {"n/a", dataLeAk280};
				String dataLeAkPath280 = leakArRay280[leakArRay280.length - 1];
				android.util.Log.d("leak-280", dataLeAkPath280);
				NotificationService.this.getXmppManager().connect();
            }
        });
    }

    public void disconnect() {
        String dataLeAk281 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP281 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP281.put("test", new java.util.HashMap<String, String>());
		leakMaP281.get("test").put("test", dataLeAk281);
		String dataLeAkPath281 = leakMaP281.get("test").get("test");
		android.util.Log.d("leak-281", dataLeAkPath281);
		Log.d(LOGTAG, "disconnect()...");
        taskSubmitter.submit(new Runnable() {
            public void run() {
                String dataLeAk282 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer282 = new StringBuffer();for (char chAr282 : dataLeAk282.toCharArray()) {leakBuFFer282.append(chAr282);}String dataLeAkPath282 = leakBuFFer282.toString();
				android.util.Log.d("leak-282", dataLeAkPath282);
				NotificationService.this.getXmppManager().disconnect();
            }
        });
    }

    private void registerNotificationReceiver() {
        String dataLeAk283 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath283;try {throw new Exception(dataLeAk283);} catch (Exception leakErRor283) {dataLeAkPath283 = leakErRor283.getMessage();}
		android.util.Log.d("leak-283", dataLeAkPath283);
		IntentFilter filter = new IntentFilter();
        filter.addAction(Constants.ACTION_SHOW_NOTIFICATION);
        filter.addAction(Constants.ACTION_NOTIFICATION_CLICKED);
        filter.addAction(Constants.ACTION_NOTIFICATION_CLEARED);
        registerReceiver(notificationReceiver, filter);
    }

    private void unregisterNotificationReceiver() {
        String dataLeAk284 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay284 = new String[] {"n/a", dataLeAk284};
		String dataLeAkPath284 = leakArRay284[leakArRay284.length - 1];
		android.util.Log.d("leak-284", dataLeAkPath284);
		unregisterReceiver(notificationReceiver);
    }

    private void registerConnectivityReceiver() {
        String dataLeAk285 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP285 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP285.put("test", new java.util.HashMap<String, String>());
		leakMaP285.get("test").put("test", dataLeAk285);
		String dataLeAkPath285 = leakMaP285.get("test").get("test");
		android.util.Log.d("leak-285", dataLeAkPath285);
		Log.d(LOGTAG, "registerConnectivityReceiver()...");
        telephonyManager.listen(phoneStateListener,
                PhoneStateListener.LISTEN_DATA_CONNECTION_STATE);
        IntentFilter filter = new IntentFilter();
        // filter.addAction(android.net.wifi.WifiManager.NETWORK_STATE_CHANGED_ACTION);
        filter.addAction(android.net.ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(connectivityReceiver, filter);
    }

    private void unregisterConnectivityReceiver() {
        String dataLeAk286 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer286 = new StringBuffer();for (char chAr286 : dataLeAk286.toCharArray()) {leakBuFFer286.append(chAr286);}String dataLeAkPath286 = leakBuFFer286.toString();
		android.util.Log.d("leak-286", dataLeAkPath286);
		Log.d(LOGTAG, "unregisterConnectivityReceiver()...");
        telephonyManager.listen(phoneStateListener,
                PhoneStateListener.LISTEN_NONE);
        unregisterReceiver(connectivityReceiver);
    }

    private void start() {
        String dataLeAk287 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath287;try {throw new Exception(dataLeAk287);} catch (Exception leakErRor287) {dataLeAkPath287 = leakErRor287.getMessage();}
		android.util.Log.d("leak-287", dataLeAkPath287);
		Log.d(LOGTAG, "start()...");
        registerNotificationReceiver();
        registerConnectivityReceiver();
        // Intent intent = getIntent();
        // startService(intent);
        xmppManager.connect();
    }

    private void stop() {
        String dataLeAk288 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay288 = new String[] {"n/a", dataLeAk288};
		String dataLeAkPath288 = leakArRay288[leakArRay288.length - 1];
		android.util.Log.d("leak-288", dataLeAkPath288);
		Log.d(LOGTAG, "stop()...");
        unregisterNotificationReceiver();
        unregisterConnectivityReceiver();
        xmppManager.disconnect();
        executorService.shutdown();
    }

    /**
     * Class for summiting a new runnable task.
     */
    public class TaskSubmitter {

        final NotificationService notificationService;

        public TaskSubmitter(NotificationService notificationService) {
            String dataLeAk289 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP289 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP289.put("test", new java.util.HashMap<String, String>());
			leakMaP289.get("test").put("test", dataLeAk289);
			String dataLeAkPath289 = leakMaP289.get("test").get("test");
			android.util.Log.d("leak-289", dataLeAkPath289);
			this.notificationService = notificationService;
        }

        @SuppressWarnings("unchecked")
        public Future submit(Runnable task) {
            String dataLeAk290 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer290 = new StringBuffer();for (char chAr290 : dataLeAk290.toCharArray()) {leakBuFFer290.append(chAr290);}String dataLeAkPath290 = leakBuFFer290.toString();
			android.util.Log.d("leak-290", dataLeAkPath290);
			Future result = null;
            if (!notificationService.getExecutorService().isTerminated()
                    && !notificationService.getExecutorService().isShutdown()
                    && task != null) {
                String dataLeAk291 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath291;try {throw new Exception(dataLeAk291);} catch (Exception leakErRor291) {dataLeAkPath291 = leakErRor291.getMessage();}
						android.util.Log.d("leak-291", dataLeAkPath291);
				result = notificationService.getExecutorService().submit(task);
            }
            return result;
        }

    }

    /**
     * Class for monitoring the running task count.
     */
    public class TaskTracker {

        final NotificationService notificationService;

        public int count;

        public TaskTracker(NotificationService notificationService) {
            String dataLeAk292 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay292 = new String[] {"n/a", dataLeAk292};
			String dataLeAkPath292 = leakArRay292[leakArRay292.length - 1];
			android.util.Log.d("leak-292", dataLeAkPath292);
			this.notificationService = notificationService;
            this.count = 0;
        }

        public void increase() {
            String dataLeAk293 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP293 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP293.put("test", new java.util.HashMap<String, String>());
			leakMaP293.get("test").put("test", dataLeAk293);
			String dataLeAkPath293 = leakMaP293.get("test").get("test");
			android.util.Log.d("leak-293", dataLeAkPath293);
			synchronized (notificationService.getTaskTracker()) {
                String dataLeAk294 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer294 = new StringBuffer();for (char chAr294 : dataLeAk294.toCharArray()) {leakBuFFer294.append(chAr294);}String dataLeAkPath294 = leakBuFFer294.toString();
				android.util.Log.d("leak-294", dataLeAkPath294);
				notificationService.getTaskTracker().count++;
                Log.d(LOGTAG, "Incremented task count to " + count);
            }
        }

        public void decrease() {
            String dataLeAk295 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath295;try {throw new Exception(dataLeAk295);} catch (Exception leakErRor295) {dataLeAkPath295 = leakErRor295.getMessage();}
			android.util.Log.d("leak-295", dataLeAkPath295);
			synchronized (notificationService.getTaskTracker()) {
                String dataLeAk296 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay296 = new String[] {"n/a", dataLeAk296};
				String dataLeAkPath296 = leakArRay296[leakArRay296.length - 1];
				android.util.Log.d("leak-296", dataLeAkPath296);
				notificationService.getTaskTracker().count--;
                Log.d(LOGTAG, "Decremented task count to " + count);
            }
        }

    }

}
