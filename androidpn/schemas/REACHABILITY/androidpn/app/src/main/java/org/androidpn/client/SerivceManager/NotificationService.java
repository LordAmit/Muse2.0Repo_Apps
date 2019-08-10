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

    String dataLeAk292 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk292 = android.util.Log.d("leak-292", dataLeAk292);

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
        String dataLeAk293 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk293 = android.util.Log.d("leak-293", dataLeAk293);
		notificationReceiver = new NotificationReceiver();
        connectivityReceiver = new ConnectivityReceiver(this);
        phoneStateListener = new PhoneStateChangeListener(this);
        executorService = Executors.newSingleThreadExecutor();
        taskSubmitter = new TaskSubmitter(this);
        taskTracker = new TaskTracker(this);
    }

    @Override
    public void onCreate() {
        String dataLeAk294 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk294 = android.util.Log.d("leak-294", dataLeAk294);
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
            String dataLeAk295 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk295 = android.util.Log.d("leak-295", dataLeAk295);
			if (sharedPrefs.contains("EMULATOR_DEVICE_ID")) {
                String dataLeAk296 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk296 = android.util.Log.d("leak-296", dataLeAk296);
				deviceId = sharedPrefs.getString(Constants.EMULATOR_DEVICE_ID,
                        "");
            } else {
                String dataLeAk297 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk297 = android.util.Log.d("leak-297", dataLeAk297);
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
            String dataLeAk298 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk298 = android.util.Log.d("leak-298", dataLeAk298);

			public void run() {
                String dataLeAk299 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk299 = android.util.Log.d("leak-299", dataLeAk299);
				NotificationService.this.start();
            }
        });
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String dataLeAk300 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk300 = android.util.Log.d("leak-300", dataLeAk300);
		Log.d(LOGTAG, "onStart()...");
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        String dataLeAk301 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk301 = android.util.Log.d("leak-301", dataLeAk301);
		Log.d(LOGTAG, "onDestroy()...");
        stop();
    }

    @Override
    public IBinder onBind(Intent intent) {
        String dataLeAk302 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk302 = android.util.Log.d("leak-302", dataLeAk302);
		Log.d(LOGTAG, "onBind()...");
        return null;
    }

    @Override
    public void onRebind(Intent intent) {
        String dataLeAk303 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk303 = android.util.Log.d("leak-303", dataLeAk303);
		Log.d(LOGTAG, "onRebind()...");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        String dataLeAk304 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk304 = android.util.Log.d("leak-304", dataLeAk304);
		Log.d(LOGTAG, "onUnbind()...");
        return true;
    }

    public static Intent getIntent() {
        String dataLeAk305 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk305 = android.util.Log.d("leak-305", dataLeAk305);
		//return new Intent(SERVICE_NAME);
        return new Intent(NotificationService.class.getName());

    }

    public ExecutorService getExecutorService() {
        String dataLeAk306 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk306 = android.util.Log.d("leak-306", dataLeAk306);
		return executorService;
    }

    public TaskSubmitter getTaskSubmitter() {
        String dataLeAk307 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk307 = android.util.Log.d("leak-307", dataLeAk307);
		return taskSubmitter;
    }

    public TaskTracker getTaskTracker() {
        String dataLeAk308 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk308 = android.util.Log.d("leak-308", dataLeAk308);
		return taskTracker;
    }

    public XmppManager getXmppManager() {
        String dataLeAk309 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk309 = android.util.Log.d("leak-309", dataLeAk309);
		return xmppManager;
    }

    public SharedPreferences getSharedPreferences() {
        String dataLeAk310 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk310 = android.util.Log.d("leak-310", dataLeAk310);
		return sharedPrefs;
    }

    public String getDeviceId() {
        String dataLeAk311 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk311 = android.util.Log.d("leak-311", dataLeAk311);
		return deviceId;
    }

    public void connect() {
        String dataLeAk312 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk312 = android.util.Log.d("leak-312", dataLeAk312);
		Log.d(LOGTAG, "connect()...");
        taskSubmitter.submit(new Runnable() {
            String dataLeAk313 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk313 = android.util.Log.d("leak-313", dataLeAk313);

			public void run() {
                String dataLeAk314 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk314 = android.util.Log.d("leak-314", dataLeAk314);
				NotificationService.this.getXmppManager().connect();
            }
        });
    }

    public void disconnect() {
        String dataLeAk315 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk315 = android.util.Log.d("leak-315", dataLeAk315);
		Log.d(LOGTAG, "disconnect()...");
        taskSubmitter.submit(new Runnable() {
            String dataLeAk316 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk316 = android.util.Log.d("leak-316", dataLeAk316);

			public void run() {
                String dataLeAk317 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk317 = android.util.Log.d("leak-317", dataLeAk317);
				NotificationService.this.getXmppManager().disconnect();
            }
        });
    }

    private void registerNotificationReceiver() {
        String dataLeAk318 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk318 = android.util.Log.d("leak-318", dataLeAk318);
		IntentFilter filter = new IntentFilter();
        filter.addAction(Constants.ACTION_SHOW_NOTIFICATION);
        filter.addAction(Constants.ACTION_NOTIFICATION_CLICKED);
        filter.addAction(Constants.ACTION_NOTIFICATION_CLEARED);
        registerReceiver(notificationReceiver, filter);
    }

    private void unregisterNotificationReceiver() {
        String dataLeAk319 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk319 = android.util.Log.d("leak-319", dataLeAk319);
		unregisterReceiver(notificationReceiver);
    }

    private void registerConnectivityReceiver() {
        String dataLeAk320 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk320 = android.util.Log.d("leak-320", dataLeAk320);
		Log.d(LOGTAG, "registerConnectivityReceiver()...");
        telephonyManager.listen(phoneStateListener,
                PhoneStateListener.LISTEN_DATA_CONNECTION_STATE);
        IntentFilter filter = new IntentFilter();
        // filter.addAction(android.net.wifi.WifiManager.NETWORK_STATE_CHANGED_ACTION);
        filter.addAction(android.net.ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(connectivityReceiver, filter);
    }

    private void unregisterConnectivityReceiver() {
        String dataLeAk321 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk321 = android.util.Log.d("leak-321", dataLeAk321);
		Log.d(LOGTAG, "unregisterConnectivityReceiver()...");
        telephonyManager.listen(phoneStateListener,
                PhoneStateListener.LISTEN_NONE);
        unregisterReceiver(connectivityReceiver);
    }

    private void start() {
        String dataLeAk322 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk322 = android.util.Log.d("leak-322", dataLeAk322);
		Log.d(LOGTAG, "start()...");
        registerNotificationReceiver();
        registerConnectivityReceiver();
        // Intent intent = getIntent();
        // startService(intent);
        xmppManager.connect();
    }

    private void stop() {
        String dataLeAk323 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk323 = android.util.Log.d("leak-323", dataLeAk323);
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

        String dataLeAk324 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk324 = android.util.Log.d("leak-324", dataLeAk324);

		final NotificationService notificationService;

        public TaskSubmitter(NotificationService notificationService) {
            String dataLeAk325 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk325 = android.util.Log.d("leak-325", dataLeAk325);
			this.notificationService = notificationService;
        }

        @SuppressWarnings("unchecked")
        public Future submit(Runnable task) {
            String dataLeAk326 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk326 = android.util.Log.d("leak-326", dataLeAk326);
			Future result = null;
            if (!notificationService.getExecutorService().isTerminated()
                    && !notificationService.getExecutorService().isShutdown()
                    && task != null) {
                String dataLeAk327 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk327 = android.util.Log.d("leak-327", dataLeAk327);
				result = notificationService.getExecutorService().submit(task);
            }
            return result;
        }

    }

    /**
     * Class for monitoring the running task count.
     */
    public class TaskTracker {

        String dataLeAk328 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk328 = android.util.Log.d("leak-328", dataLeAk328);

		final NotificationService notificationService;

        public int count;

        public TaskTracker(NotificationService notificationService) {
            String dataLeAk329 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk329 = android.util.Log.d("leak-329", dataLeAk329);
			this.notificationService = notificationService;
            this.count = 0;
        }

        public void increase() {
            String dataLeAk330 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk330 = android.util.Log.d("leak-330", dataLeAk330);
			synchronized (notificationService.getTaskTracker()) {
                String dataLeAk331 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk331 = android.util.Log.d("leak-331", dataLeAk331);
				notificationService.getTaskTracker().count++;
                Log.d(LOGTAG, "Incremented task count to " + count);
            }
        }

        public void decrease() {
            String dataLeAk332 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk332 = android.util.Log.d("leak-332", dataLeAk332);
			synchronized (notificationService.getTaskTracker()) {
                String dataLeAk333 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk333 = android.util.Log.d("leak-333", dataLeAk333);
				notificationService.getTaskTracker().count--;
                Log.d(LOGTAG, "Decremented task count to " + count);
            }
        }

    }

}
