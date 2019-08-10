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

    final String dataLeAk153 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk152 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk151 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk149 = "";

	String dataLeAk147 = "";

	String dataLeAk145 = "";

	String dataLeAk143 = "";

	String dataLeAk141 = "";

	String dataLeAk139 = "";

	String dataLeAk138 = "";

	String dataLeAk137 = "";

	String dataLeAk136 = "";

	String dataLeAk135 = "";

	String dataLeAk134 = "";

	String dataLeAk132 = "";

	String dataLeAk130 = "";

	String dataLeAk129 = "";

	String dataLeAk128 = "";

	String dataLeAk127 = "";

	String dataLeAk126 = "";

	String dataLeAk125 = "";

	String dataLeAk124 = "";

	String dataLeAk123 = "";

	String dataLeAk122 = "";

	String dataLeAk121 = "";

	String dataLeAk120 = "";

	String dataLeAk119 = "";

	String dataLeAk117 = "";

	String dataLeAk116 = "";

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
        dataLeAk116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-116-0", dataLeAk116);
		android.util.Log.d("leak-117-0", dataLeAk117);
		android.util.Log.d("leak-119-0", dataLeAk119);
		android.util.Log.d("leak-120-0", dataLeAk120);
		android.util.Log.d("leak-121-0", dataLeAk121);
		android.util.Log.d("leak-122-0", dataLeAk122);
		android.util.Log.d("leak-123-0", dataLeAk123);
		android.util.Log.d("leak-124-0", dataLeAk124);
		android.util.Log.d("leak-125-0", dataLeAk125);
		android.util.Log.d("leak-126-0", dataLeAk126);
		android.util.Log.d("leak-127-0", dataLeAk127);
		android.util.Log.d("leak-128-0", dataLeAk128);
		android.util.Log.d("leak-129-0", dataLeAk129);
		android.util.Log.d("leak-130-0", dataLeAk130);
		android.util.Log.d("leak-132-0", dataLeAk132);
		android.util.Log.d("leak-134-0", dataLeAk134);
		android.util.Log.d("leak-135-0", dataLeAk135);
		android.util.Log.d("leak-136-0", dataLeAk136);
		android.util.Log.d("leak-137-0", dataLeAk137);
		android.util.Log.d("leak-138-0", dataLeAk138);
		android.util.Log.d("leak-139-0", dataLeAk139);
		android.util.Log.d("leak-141-0", dataLeAk141);
		android.util.Log.d("leak-143-0", dataLeAk143);
		android.util.Log.d("leak-145-0", dataLeAk145);
		android.util.Log.d("leak-147-0", dataLeAk147);
		android.util.Log.d("leak-149-0", dataLeAk149);
		notificationReceiver = new NotificationReceiver();
        connectivityReceiver = new ConnectivityReceiver(this);
        phoneStateListener = new PhoneStateChangeListener(this);
        executorService = Executors.newSingleThreadExecutor();
        taskSubmitter = new TaskSubmitter(this);
        taskTracker = new TaskTracker(this);
    }

    @Override
    public void onCreate() {
        dataLeAk117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-116-1", dataLeAk116);
		android.util.Log.d("leak-117-1", dataLeAk117);
		android.util.Log.d("leak-119-1", dataLeAk119);
		android.util.Log.d("leak-120-1", dataLeAk120);
		android.util.Log.d("leak-121-1", dataLeAk121);
		android.util.Log.d("leak-122-1", dataLeAk122);
		android.util.Log.d("leak-123-1", dataLeAk123);
		android.util.Log.d("leak-124-1", dataLeAk124);
		android.util.Log.d("leak-125-1", dataLeAk125);
		android.util.Log.d("leak-126-1", dataLeAk126);
		android.util.Log.d("leak-127-1", dataLeAk127);
		android.util.Log.d("leak-128-1", dataLeAk128);
		android.util.Log.d("leak-129-1", dataLeAk129);
		android.util.Log.d("leak-130-1", dataLeAk130);
		android.util.Log.d("leak-132-1", dataLeAk132);
		android.util.Log.d("leak-134-1", dataLeAk134);
		android.util.Log.d("leak-135-1", dataLeAk135);
		android.util.Log.d("leak-136-1", dataLeAk136);
		android.util.Log.d("leak-137-1", dataLeAk137);
		android.util.Log.d("leak-138-1", dataLeAk138);
		android.util.Log.d("leak-139-1", dataLeAk139);
		android.util.Log.d("leak-141-1", dataLeAk141);
		android.util.Log.d("leak-143-1", dataLeAk143);
		android.util.Log.d("leak-145-1", dataLeAk145);
		android.util.Log.d("leak-147-1", dataLeAk147);
		android.util.Log.d("leak-149-1", dataLeAk149);
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
            if (sharedPrefs.contains("EMULATOR_DEVICE_ID")) {
                deviceId = sharedPrefs.getString(Constants.EMULATOR_DEVICE_ID,
                        "");
            } else {
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
            String dataLeAk118 = "";

			public void run() {
                dataLeAk118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-151-0", dataLeAk151);
				android.util.Log.d("leak-118-0", dataLeAk118);
				NotificationService.this.start();
            }
        });
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        dataLeAk119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-116-2", dataLeAk116);
		android.util.Log.d("leak-117-2", dataLeAk117);
		android.util.Log.d("leak-119-2", dataLeAk119);
		android.util.Log.d("leak-120-2", dataLeAk120);
		android.util.Log.d("leak-121-2", dataLeAk121);
		android.util.Log.d("leak-122-2", dataLeAk122);
		android.util.Log.d("leak-123-2", dataLeAk123);
		android.util.Log.d("leak-124-2", dataLeAk124);
		android.util.Log.d("leak-125-2", dataLeAk125);
		android.util.Log.d("leak-126-2", dataLeAk126);
		android.util.Log.d("leak-127-2", dataLeAk127);
		android.util.Log.d("leak-128-2", dataLeAk128);
		android.util.Log.d("leak-129-2", dataLeAk129);
		android.util.Log.d("leak-130-2", dataLeAk130);
		android.util.Log.d("leak-132-2", dataLeAk132);
		android.util.Log.d("leak-134-2", dataLeAk134);
		android.util.Log.d("leak-135-2", dataLeAk135);
		android.util.Log.d("leak-136-2", dataLeAk136);
		android.util.Log.d("leak-137-2", dataLeAk137);
		android.util.Log.d("leak-138-2", dataLeAk138);
		android.util.Log.d("leak-139-2", dataLeAk139);
		android.util.Log.d("leak-141-2", dataLeAk141);
		android.util.Log.d("leak-143-2", dataLeAk143);
		android.util.Log.d("leak-145-2", dataLeAk145);
		android.util.Log.d("leak-147-2", dataLeAk147);
		android.util.Log.d("leak-149-2", dataLeAk149);
		Log.d(LOGTAG, "onStart()...");
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        dataLeAk120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-116-3", dataLeAk116);
		android.util.Log.d("leak-117-3", dataLeAk117);
		android.util.Log.d("leak-119-3", dataLeAk119);
		android.util.Log.d("leak-120-3", dataLeAk120);
		android.util.Log.d("leak-121-3", dataLeAk121);
		android.util.Log.d("leak-122-3", dataLeAk122);
		android.util.Log.d("leak-123-3", dataLeAk123);
		android.util.Log.d("leak-124-3", dataLeAk124);
		android.util.Log.d("leak-125-3", dataLeAk125);
		android.util.Log.d("leak-126-3", dataLeAk126);
		android.util.Log.d("leak-127-3", dataLeAk127);
		android.util.Log.d("leak-128-3", dataLeAk128);
		android.util.Log.d("leak-129-3", dataLeAk129);
		android.util.Log.d("leak-130-3", dataLeAk130);
		android.util.Log.d("leak-132-3", dataLeAk132);
		android.util.Log.d("leak-134-3", dataLeAk134);
		android.util.Log.d("leak-135-3", dataLeAk135);
		android.util.Log.d("leak-136-3", dataLeAk136);
		android.util.Log.d("leak-137-3", dataLeAk137);
		android.util.Log.d("leak-138-3", dataLeAk138);
		android.util.Log.d("leak-139-3", dataLeAk139);
		android.util.Log.d("leak-141-3", dataLeAk141);
		android.util.Log.d("leak-143-3", dataLeAk143);
		android.util.Log.d("leak-145-3", dataLeAk145);
		android.util.Log.d("leak-147-3", dataLeAk147);
		android.util.Log.d("leak-149-3", dataLeAk149);
		Log.d(LOGTAG, "onDestroy()...");
        stop();
    }

    @Override
    public IBinder onBind(Intent intent) {
        dataLeAk121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-116-4", dataLeAk116);
		android.util.Log.d("leak-117-4", dataLeAk117);
		android.util.Log.d("leak-119-4", dataLeAk119);
		android.util.Log.d("leak-120-4", dataLeAk120);
		android.util.Log.d("leak-121-4", dataLeAk121);
		android.util.Log.d("leak-122-4", dataLeAk122);
		android.util.Log.d("leak-123-4", dataLeAk123);
		android.util.Log.d("leak-124-4", dataLeAk124);
		android.util.Log.d("leak-125-4", dataLeAk125);
		android.util.Log.d("leak-126-4", dataLeAk126);
		android.util.Log.d("leak-127-4", dataLeAk127);
		android.util.Log.d("leak-128-4", dataLeAk128);
		android.util.Log.d("leak-129-4", dataLeAk129);
		android.util.Log.d("leak-130-4", dataLeAk130);
		android.util.Log.d("leak-132-4", dataLeAk132);
		android.util.Log.d("leak-134-4", dataLeAk134);
		android.util.Log.d("leak-135-4", dataLeAk135);
		android.util.Log.d("leak-136-4", dataLeAk136);
		android.util.Log.d("leak-137-4", dataLeAk137);
		android.util.Log.d("leak-138-4", dataLeAk138);
		android.util.Log.d("leak-139-4", dataLeAk139);
		android.util.Log.d("leak-141-4", dataLeAk141);
		android.util.Log.d("leak-143-4", dataLeAk143);
		android.util.Log.d("leak-145-4", dataLeAk145);
		android.util.Log.d("leak-147-4", dataLeAk147);
		android.util.Log.d("leak-149-4", dataLeAk149);
		Log.d(LOGTAG, "onBind()...");
        return null;
    }

    @Override
    public void onRebind(Intent intent) {
        dataLeAk122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-116-5", dataLeAk116);
		android.util.Log.d("leak-117-5", dataLeAk117);
		android.util.Log.d("leak-119-5", dataLeAk119);
		android.util.Log.d("leak-120-5", dataLeAk120);
		android.util.Log.d("leak-121-5", dataLeAk121);
		android.util.Log.d("leak-122-5", dataLeAk122);
		android.util.Log.d("leak-123-5", dataLeAk123);
		android.util.Log.d("leak-124-5", dataLeAk124);
		android.util.Log.d("leak-125-5", dataLeAk125);
		android.util.Log.d("leak-126-5", dataLeAk126);
		android.util.Log.d("leak-127-5", dataLeAk127);
		android.util.Log.d("leak-128-5", dataLeAk128);
		android.util.Log.d("leak-129-5", dataLeAk129);
		android.util.Log.d("leak-130-5", dataLeAk130);
		android.util.Log.d("leak-132-5", dataLeAk132);
		android.util.Log.d("leak-134-5", dataLeAk134);
		android.util.Log.d("leak-135-5", dataLeAk135);
		android.util.Log.d("leak-136-5", dataLeAk136);
		android.util.Log.d("leak-137-5", dataLeAk137);
		android.util.Log.d("leak-138-5", dataLeAk138);
		android.util.Log.d("leak-139-5", dataLeAk139);
		android.util.Log.d("leak-141-5", dataLeAk141);
		android.util.Log.d("leak-143-5", dataLeAk143);
		android.util.Log.d("leak-145-5", dataLeAk145);
		android.util.Log.d("leak-147-5", dataLeAk147);
		android.util.Log.d("leak-149-5", dataLeAk149);
		Log.d(LOGTAG, "onRebind()...");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        dataLeAk123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-116-6", dataLeAk116);
		android.util.Log.d("leak-117-6", dataLeAk117);
		android.util.Log.d("leak-119-6", dataLeAk119);
		android.util.Log.d("leak-120-6", dataLeAk120);
		android.util.Log.d("leak-121-6", dataLeAk121);
		android.util.Log.d("leak-122-6", dataLeAk122);
		android.util.Log.d("leak-123-6", dataLeAk123);
		android.util.Log.d("leak-124-6", dataLeAk124);
		android.util.Log.d("leak-125-6", dataLeAk125);
		android.util.Log.d("leak-126-6", dataLeAk126);
		android.util.Log.d("leak-127-6", dataLeAk127);
		android.util.Log.d("leak-128-6", dataLeAk128);
		android.util.Log.d("leak-129-6", dataLeAk129);
		android.util.Log.d("leak-130-6", dataLeAk130);
		android.util.Log.d("leak-132-6", dataLeAk132);
		android.util.Log.d("leak-134-6", dataLeAk134);
		android.util.Log.d("leak-135-6", dataLeAk135);
		android.util.Log.d("leak-136-6", dataLeAk136);
		android.util.Log.d("leak-137-6", dataLeAk137);
		android.util.Log.d("leak-138-6", dataLeAk138);
		android.util.Log.d("leak-139-6", dataLeAk139);
		android.util.Log.d("leak-141-6", dataLeAk141);
		android.util.Log.d("leak-143-6", dataLeAk143);
		android.util.Log.d("leak-145-6", dataLeAk145);
		android.util.Log.d("leak-147-6", dataLeAk147);
		android.util.Log.d("leak-149-6", dataLeAk149);
		Log.d(LOGTAG, "onUnbind()...");
        return true;
    }

    public static Intent getIntent() {
        //return new Intent(SERVICE_NAME);
        return new Intent(NotificationService.class.getName());

    }

    public ExecutorService getExecutorService() {
        dataLeAk124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-116-7", dataLeAk116);
		android.util.Log.d("leak-117-7", dataLeAk117);
		android.util.Log.d("leak-119-7", dataLeAk119);
		android.util.Log.d("leak-120-7", dataLeAk120);
		android.util.Log.d("leak-121-7", dataLeAk121);
		android.util.Log.d("leak-122-7", dataLeAk122);
		android.util.Log.d("leak-123-7", dataLeAk123);
		android.util.Log.d("leak-124-7", dataLeAk124);
		android.util.Log.d("leak-125-7", dataLeAk125);
		android.util.Log.d("leak-126-7", dataLeAk126);
		android.util.Log.d("leak-127-7", dataLeAk127);
		android.util.Log.d("leak-128-7", dataLeAk128);
		android.util.Log.d("leak-129-7", dataLeAk129);
		android.util.Log.d("leak-130-7", dataLeAk130);
		android.util.Log.d("leak-132-7", dataLeAk132);
		android.util.Log.d("leak-134-7", dataLeAk134);
		android.util.Log.d("leak-135-7", dataLeAk135);
		android.util.Log.d("leak-136-7", dataLeAk136);
		android.util.Log.d("leak-137-7", dataLeAk137);
		android.util.Log.d("leak-138-7", dataLeAk138);
		android.util.Log.d("leak-139-7", dataLeAk139);
		android.util.Log.d("leak-141-7", dataLeAk141);
		android.util.Log.d("leak-143-7", dataLeAk143);
		android.util.Log.d("leak-145-7", dataLeAk145);
		android.util.Log.d("leak-147-7", dataLeAk147);
		android.util.Log.d("leak-149-7", dataLeAk149);
		return executorService;
    }

    public TaskSubmitter getTaskSubmitter() {
        dataLeAk125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-116-8", dataLeAk116);
		android.util.Log.d("leak-117-8", dataLeAk117);
		android.util.Log.d("leak-119-8", dataLeAk119);
		android.util.Log.d("leak-120-8", dataLeAk120);
		android.util.Log.d("leak-121-8", dataLeAk121);
		android.util.Log.d("leak-122-8", dataLeAk122);
		android.util.Log.d("leak-123-8", dataLeAk123);
		android.util.Log.d("leak-124-8", dataLeAk124);
		android.util.Log.d("leak-125-8", dataLeAk125);
		android.util.Log.d("leak-126-8", dataLeAk126);
		android.util.Log.d("leak-127-8", dataLeAk127);
		android.util.Log.d("leak-128-8", dataLeAk128);
		android.util.Log.d("leak-129-8", dataLeAk129);
		android.util.Log.d("leak-130-8", dataLeAk130);
		android.util.Log.d("leak-132-8", dataLeAk132);
		android.util.Log.d("leak-134-8", dataLeAk134);
		android.util.Log.d("leak-135-8", dataLeAk135);
		android.util.Log.d("leak-136-8", dataLeAk136);
		android.util.Log.d("leak-137-8", dataLeAk137);
		android.util.Log.d("leak-138-8", dataLeAk138);
		android.util.Log.d("leak-139-8", dataLeAk139);
		android.util.Log.d("leak-141-8", dataLeAk141);
		android.util.Log.d("leak-143-8", dataLeAk143);
		android.util.Log.d("leak-145-8", dataLeAk145);
		android.util.Log.d("leak-147-8", dataLeAk147);
		android.util.Log.d("leak-149-8", dataLeAk149);
		return taskSubmitter;
    }

    public TaskTracker getTaskTracker() {
        dataLeAk126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-116-9", dataLeAk116);
		android.util.Log.d("leak-117-9", dataLeAk117);
		android.util.Log.d("leak-119-9", dataLeAk119);
		android.util.Log.d("leak-120-9", dataLeAk120);
		android.util.Log.d("leak-121-9", dataLeAk121);
		android.util.Log.d("leak-122-9", dataLeAk122);
		android.util.Log.d("leak-123-9", dataLeAk123);
		android.util.Log.d("leak-124-9", dataLeAk124);
		android.util.Log.d("leak-125-9", dataLeAk125);
		android.util.Log.d("leak-126-9", dataLeAk126);
		android.util.Log.d("leak-127-9", dataLeAk127);
		android.util.Log.d("leak-128-9", dataLeAk128);
		android.util.Log.d("leak-129-9", dataLeAk129);
		android.util.Log.d("leak-130-9", dataLeAk130);
		android.util.Log.d("leak-132-9", dataLeAk132);
		android.util.Log.d("leak-134-9", dataLeAk134);
		android.util.Log.d("leak-135-9", dataLeAk135);
		android.util.Log.d("leak-136-9", dataLeAk136);
		android.util.Log.d("leak-137-9", dataLeAk137);
		android.util.Log.d("leak-138-9", dataLeAk138);
		android.util.Log.d("leak-139-9", dataLeAk139);
		android.util.Log.d("leak-141-9", dataLeAk141);
		android.util.Log.d("leak-143-9", dataLeAk143);
		android.util.Log.d("leak-145-9", dataLeAk145);
		android.util.Log.d("leak-147-9", dataLeAk147);
		android.util.Log.d("leak-149-9", dataLeAk149);
		return taskTracker;
    }

    public XmppManager getXmppManager() {
        dataLeAk127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-116-10", dataLeAk116);
		android.util.Log.d("leak-117-10", dataLeAk117);
		android.util.Log.d("leak-119-10", dataLeAk119);
		android.util.Log.d("leak-120-10", dataLeAk120);
		android.util.Log.d("leak-121-10", dataLeAk121);
		android.util.Log.d("leak-122-10", dataLeAk122);
		android.util.Log.d("leak-123-10", dataLeAk123);
		android.util.Log.d("leak-124-10", dataLeAk124);
		android.util.Log.d("leak-125-10", dataLeAk125);
		android.util.Log.d("leak-126-10", dataLeAk126);
		android.util.Log.d("leak-127-10", dataLeAk127);
		android.util.Log.d("leak-128-10", dataLeAk128);
		android.util.Log.d("leak-129-10", dataLeAk129);
		android.util.Log.d("leak-130-10", dataLeAk130);
		android.util.Log.d("leak-132-10", dataLeAk132);
		android.util.Log.d("leak-134-10", dataLeAk134);
		android.util.Log.d("leak-135-10", dataLeAk135);
		android.util.Log.d("leak-136-10", dataLeAk136);
		android.util.Log.d("leak-137-10", dataLeAk137);
		android.util.Log.d("leak-138-10", dataLeAk138);
		android.util.Log.d("leak-139-10", dataLeAk139);
		android.util.Log.d("leak-141-10", dataLeAk141);
		android.util.Log.d("leak-143-10", dataLeAk143);
		android.util.Log.d("leak-145-10", dataLeAk145);
		android.util.Log.d("leak-147-10", dataLeAk147);
		android.util.Log.d("leak-149-10", dataLeAk149);
		return xmppManager;
    }

    public SharedPreferences getSharedPreferences() {
        dataLeAk128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-116-11", dataLeAk116);
		android.util.Log.d("leak-117-11", dataLeAk117);
		android.util.Log.d("leak-119-11", dataLeAk119);
		android.util.Log.d("leak-120-11", dataLeAk120);
		android.util.Log.d("leak-121-11", dataLeAk121);
		android.util.Log.d("leak-122-11", dataLeAk122);
		android.util.Log.d("leak-123-11", dataLeAk123);
		android.util.Log.d("leak-124-11", dataLeAk124);
		android.util.Log.d("leak-125-11", dataLeAk125);
		android.util.Log.d("leak-126-11", dataLeAk126);
		android.util.Log.d("leak-127-11", dataLeAk127);
		android.util.Log.d("leak-128-11", dataLeAk128);
		android.util.Log.d("leak-129-11", dataLeAk129);
		android.util.Log.d("leak-130-11", dataLeAk130);
		android.util.Log.d("leak-132-11", dataLeAk132);
		android.util.Log.d("leak-134-11", dataLeAk134);
		android.util.Log.d("leak-135-11", dataLeAk135);
		android.util.Log.d("leak-136-11", dataLeAk136);
		android.util.Log.d("leak-137-11", dataLeAk137);
		android.util.Log.d("leak-138-11", dataLeAk138);
		android.util.Log.d("leak-139-11", dataLeAk139);
		android.util.Log.d("leak-141-11", dataLeAk141);
		android.util.Log.d("leak-143-11", dataLeAk143);
		android.util.Log.d("leak-145-11", dataLeAk145);
		android.util.Log.d("leak-147-11", dataLeAk147);
		android.util.Log.d("leak-149-11", dataLeAk149);
		return sharedPrefs;
    }

    public String getDeviceId() {
        dataLeAk129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-116-12", dataLeAk116);
		android.util.Log.d("leak-117-12", dataLeAk117);
		android.util.Log.d("leak-119-12", dataLeAk119);
		android.util.Log.d("leak-120-12", dataLeAk120);
		android.util.Log.d("leak-121-12", dataLeAk121);
		android.util.Log.d("leak-122-12", dataLeAk122);
		android.util.Log.d("leak-123-12", dataLeAk123);
		android.util.Log.d("leak-124-12", dataLeAk124);
		android.util.Log.d("leak-125-12", dataLeAk125);
		android.util.Log.d("leak-126-12", dataLeAk126);
		android.util.Log.d("leak-127-12", dataLeAk127);
		android.util.Log.d("leak-128-12", dataLeAk128);
		android.util.Log.d("leak-129-12", dataLeAk129);
		android.util.Log.d("leak-130-12", dataLeAk130);
		android.util.Log.d("leak-132-12", dataLeAk132);
		android.util.Log.d("leak-134-12", dataLeAk134);
		android.util.Log.d("leak-135-12", dataLeAk135);
		android.util.Log.d("leak-136-12", dataLeAk136);
		android.util.Log.d("leak-137-12", dataLeAk137);
		android.util.Log.d("leak-138-12", dataLeAk138);
		android.util.Log.d("leak-139-12", dataLeAk139);
		android.util.Log.d("leak-141-12", dataLeAk141);
		android.util.Log.d("leak-143-12", dataLeAk143);
		android.util.Log.d("leak-145-12", dataLeAk145);
		android.util.Log.d("leak-147-12", dataLeAk147);
		android.util.Log.d("leak-149-12", dataLeAk149);
		return deviceId;
    }

    public void connect() {
        dataLeAk130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-116-13", dataLeAk116);
		android.util.Log.d("leak-117-13", dataLeAk117);
		android.util.Log.d("leak-119-13", dataLeAk119);
		android.util.Log.d("leak-120-13", dataLeAk120);
		android.util.Log.d("leak-121-13", dataLeAk121);
		android.util.Log.d("leak-122-13", dataLeAk122);
		android.util.Log.d("leak-123-13", dataLeAk123);
		android.util.Log.d("leak-124-13", dataLeAk124);
		android.util.Log.d("leak-125-13", dataLeAk125);
		android.util.Log.d("leak-126-13", dataLeAk126);
		android.util.Log.d("leak-127-13", dataLeAk127);
		android.util.Log.d("leak-128-13", dataLeAk128);
		android.util.Log.d("leak-129-13", dataLeAk129);
		android.util.Log.d("leak-130-13", dataLeAk130);
		android.util.Log.d("leak-132-13", dataLeAk132);
		android.util.Log.d("leak-134-13", dataLeAk134);
		android.util.Log.d("leak-135-13", dataLeAk135);
		android.util.Log.d("leak-136-13", dataLeAk136);
		android.util.Log.d("leak-137-13", dataLeAk137);
		android.util.Log.d("leak-138-13", dataLeAk138);
		android.util.Log.d("leak-139-13", dataLeAk139);
		android.util.Log.d("leak-141-13", dataLeAk141);
		android.util.Log.d("leak-143-13", dataLeAk143);
		android.util.Log.d("leak-145-13", dataLeAk145);
		android.util.Log.d("leak-147-13", dataLeAk147);
		android.util.Log.d("leak-149-13", dataLeAk149);
		Log.d(LOGTAG, "connect()...");
        taskSubmitter.submit(new Runnable() {
            String dataLeAk131 = "";

			public void run() {
                dataLeAk131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-152-0", dataLeAk152);
				android.util.Log.d("leak-131-0", dataLeAk131);
				NotificationService.this.getXmppManager().connect();
            }
        });
    }

    public void disconnect() {
        dataLeAk132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-116-14", dataLeAk116);
		android.util.Log.d("leak-117-14", dataLeAk117);
		android.util.Log.d("leak-119-14", dataLeAk119);
		android.util.Log.d("leak-120-14", dataLeAk120);
		android.util.Log.d("leak-121-14", dataLeAk121);
		android.util.Log.d("leak-122-14", dataLeAk122);
		android.util.Log.d("leak-123-14", dataLeAk123);
		android.util.Log.d("leak-124-14", dataLeAk124);
		android.util.Log.d("leak-125-14", dataLeAk125);
		android.util.Log.d("leak-126-14", dataLeAk126);
		android.util.Log.d("leak-127-14", dataLeAk127);
		android.util.Log.d("leak-128-14", dataLeAk128);
		android.util.Log.d("leak-129-14", dataLeAk129);
		android.util.Log.d("leak-130-14", dataLeAk130);
		android.util.Log.d("leak-132-14", dataLeAk132);
		android.util.Log.d("leak-134-14", dataLeAk134);
		android.util.Log.d("leak-135-14", dataLeAk135);
		android.util.Log.d("leak-136-14", dataLeAk136);
		android.util.Log.d("leak-137-14", dataLeAk137);
		android.util.Log.d("leak-138-14", dataLeAk138);
		android.util.Log.d("leak-139-14", dataLeAk139);
		android.util.Log.d("leak-141-14", dataLeAk141);
		android.util.Log.d("leak-143-14", dataLeAk143);
		android.util.Log.d("leak-145-14", dataLeAk145);
		android.util.Log.d("leak-147-14", dataLeAk147);
		android.util.Log.d("leak-149-14", dataLeAk149);
		Log.d(LOGTAG, "disconnect()...");
        taskSubmitter.submit(new Runnable() {
            String dataLeAk133 = "";

			public void run() {
                dataLeAk133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-153-0", dataLeAk153);
				android.util.Log.d("leak-133-0", dataLeAk133);
				NotificationService.this.getXmppManager().disconnect();
            }
        });
    }

    private void registerNotificationReceiver() {
        dataLeAk134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-116-15", dataLeAk116);
		android.util.Log.d("leak-117-15", dataLeAk117);
		android.util.Log.d("leak-119-15", dataLeAk119);
		android.util.Log.d("leak-120-15", dataLeAk120);
		android.util.Log.d("leak-121-15", dataLeAk121);
		android.util.Log.d("leak-122-15", dataLeAk122);
		android.util.Log.d("leak-123-15", dataLeAk123);
		android.util.Log.d("leak-124-15", dataLeAk124);
		android.util.Log.d("leak-125-15", dataLeAk125);
		android.util.Log.d("leak-126-15", dataLeAk126);
		android.util.Log.d("leak-127-15", dataLeAk127);
		android.util.Log.d("leak-128-15", dataLeAk128);
		android.util.Log.d("leak-129-15", dataLeAk129);
		android.util.Log.d("leak-130-15", dataLeAk130);
		android.util.Log.d("leak-132-15", dataLeAk132);
		android.util.Log.d("leak-134-15", dataLeAk134);
		android.util.Log.d("leak-135-15", dataLeAk135);
		android.util.Log.d("leak-136-15", dataLeAk136);
		android.util.Log.d("leak-137-15", dataLeAk137);
		android.util.Log.d("leak-138-15", dataLeAk138);
		android.util.Log.d("leak-139-15", dataLeAk139);
		android.util.Log.d("leak-141-15", dataLeAk141);
		android.util.Log.d("leak-143-15", dataLeAk143);
		android.util.Log.d("leak-145-15", dataLeAk145);
		android.util.Log.d("leak-147-15", dataLeAk147);
		android.util.Log.d("leak-149-15", dataLeAk149);
		IntentFilter filter = new IntentFilter();
        filter.addAction(Constants.ACTION_SHOW_NOTIFICATION);
        filter.addAction(Constants.ACTION_NOTIFICATION_CLICKED);
        filter.addAction(Constants.ACTION_NOTIFICATION_CLEARED);
        registerReceiver(notificationReceiver, filter);
    }

    private void unregisterNotificationReceiver() {
        dataLeAk135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-116-16", dataLeAk116);
		android.util.Log.d("leak-117-16", dataLeAk117);
		android.util.Log.d("leak-119-16", dataLeAk119);
		android.util.Log.d("leak-120-16", dataLeAk120);
		android.util.Log.d("leak-121-16", dataLeAk121);
		android.util.Log.d("leak-122-16", dataLeAk122);
		android.util.Log.d("leak-123-16", dataLeAk123);
		android.util.Log.d("leak-124-16", dataLeAk124);
		android.util.Log.d("leak-125-16", dataLeAk125);
		android.util.Log.d("leak-126-16", dataLeAk126);
		android.util.Log.d("leak-127-16", dataLeAk127);
		android.util.Log.d("leak-128-16", dataLeAk128);
		android.util.Log.d("leak-129-16", dataLeAk129);
		android.util.Log.d("leak-130-16", dataLeAk130);
		android.util.Log.d("leak-132-16", dataLeAk132);
		android.util.Log.d("leak-134-16", dataLeAk134);
		android.util.Log.d("leak-135-16", dataLeAk135);
		android.util.Log.d("leak-136-16", dataLeAk136);
		android.util.Log.d("leak-137-16", dataLeAk137);
		android.util.Log.d("leak-138-16", dataLeAk138);
		android.util.Log.d("leak-139-16", dataLeAk139);
		android.util.Log.d("leak-141-16", dataLeAk141);
		android.util.Log.d("leak-143-16", dataLeAk143);
		android.util.Log.d("leak-145-16", dataLeAk145);
		android.util.Log.d("leak-147-16", dataLeAk147);
		android.util.Log.d("leak-149-16", dataLeAk149);
		unregisterReceiver(notificationReceiver);
    }

    private void registerConnectivityReceiver() {
        dataLeAk136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-116-17", dataLeAk116);
		android.util.Log.d("leak-117-17", dataLeAk117);
		android.util.Log.d("leak-119-17", dataLeAk119);
		android.util.Log.d("leak-120-17", dataLeAk120);
		android.util.Log.d("leak-121-17", dataLeAk121);
		android.util.Log.d("leak-122-17", dataLeAk122);
		android.util.Log.d("leak-123-17", dataLeAk123);
		android.util.Log.d("leak-124-17", dataLeAk124);
		android.util.Log.d("leak-125-17", dataLeAk125);
		android.util.Log.d("leak-126-17", dataLeAk126);
		android.util.Log.d("leak-127-17", dataLeAk127);
		android.util.Log.d("leak-128-17", dataLeAk128);
		android.util.Log.d("leak-129-17", dataLeAk129);
		android.util.Log.d("leak-130-17", dataLeAk130);
		android.util.Log.d("leak-132-17", dataLeAk132);
		android.util.Log.d("leak-134-17", dataLeAk134);
		android.util.Log.d("leak-135-17", dataLeAk135);
		android.util.Log.d("leak-136-17", dataLeAk136);
		android.util.Log.d("leak-137-17", dataLeAk137);
		android.util.Log.d("leak-138-17", dataLeAk138);
		android.util.Log.d("leak-139-17", dataLeAk139);
		android.util.Log.d("leak-141-17", dataLeAk141);
		android.util.Log.d("leak-143-17", dataLeAk143);
		android.util.Log.d("leak-145-17", dataLeAk145);
		android.util.Log.d("leak-147-17", dataLeAk147);
		android.util.Log.d("leak-149-17", dataLeAk149);
		Log.d(LOGTAG, "registerConnectivityReceiver()...");
        telephonyManager.listen(phoneStateListener,
                PhoneStateListener.LISTEN_DATA_CONNECTION_STATE);
        IntentFilter filter = new IntentFilter();
        // filter.addAction(android.net.wifi.WifiManager.NETWORK_STATE_CHANGED_ACTION);
        filter.addAction(android.net.ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(connectivityReceiver, filter);
    }

    private void unregisterConnectivityReceiver() {
        dataLeAk137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-116-18", dataLeAk116);
		android.util.Log.d("leak-117-18", dataLeAk117);
		android.util.Log.d("leak-119-18", dataLeAk119);
		android.util.Log.d("leak-120-18", dataLeAk120);
		android.util.Log.d("leak-121-18", dataLeAk121);
		android.util.Log.d("leak-122-18", dataLeAk122);
		android.util.Log.d("leak-123-18", dataLeAk123);
		android.util.Log.d("leak-124-18", dataLeAk124);
		android.util.Log.d("leak-125-18", dataLeAk125);
		android.util.Log.d("leak-126-18", dataLeAk126);
		android.util.Log.d("leak-127-18", dataLeAk127);
		android.util.Log.d("leak-128-18", dataLeAk128);
		android.util.Log.d("leak-129-18", dataLeAk129);
		android.util.Log.d("leak-130-18", dataLeAk130);
		android.util.Log.d("leak-132-18", dataLeAk132);
		android.util.Log.d("leak-134-18", dataLeAk134);
		android.util.Log.d("leak-135-18", dataLeAk135);
		android.util.Log.d("leak-136-18", dataLeAk136);
		android.util.Log.d("leak-137-18", dataLeAk137);
		android.util.Log.d("leak-138-18", dataLeAk138);
		android.util.Log.d("leak-139-18", dataLeAk139);
		android.util.Log.d("leak-141-18", dataLeAk141);
		android.util.Log.d("leak-143-18", dataLeAk143);
		android.util.Log.d("leak-145-18", dataLeAk145);
		android.util.Log.d("leak-147-18", dataLeAk147);
		android.util.Log.d("leak-149-18", dataLeAk149);
		Log.d(LOGTAG, "unregisterConnectivityReceiver()...");
        telephonyManager.listen(phoneStateListener,
                PhoneStateListener.LISTEN_NONE);
        unregisterReceiver(connectivityReceiver);
    }

    private void start() {
        dataLeAk138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-116-19", dataLeAk116);
		android.util.Log.d("leak-117-19", dataLeAk117);
		android.util.Log.d("leak-119-19", dataLeAk119);
		android.util.Log.d("leak-120-19", dataLeAk120);
		android.util.Log.d("leak-121-19", dataLeAk121);
		android.util.Log.d("leak-122-19", dataLeAk122);
		android.util.Log.d("leak-123-19", dataLeAk123);
		android.util.Log.d("leak-124-19", dataLeAk124);
		android.util.Log.d("leak-125-19", dataLeAk125);
		android.util.Log.d("leak-126-19", dataLeAk126);
		android.util.Log.d("leak-127-19", dataLeAk127);
		android.util.Log.d("leak-128-19", dataLeAk128);
		android.util.Log.d("leak-129-19", dataLeAk129);
		android.util.Log.d("leak-130-19", dataLeAk130);
		android.util.Log.d("leak-132-19", dataLeAk132);
		android.util.Log.d("leak-134-19", dataLeAk134);
		android.util.Log.d("leak-135-19", dataLeAk135);
		android.util.Log.d("leak-136-19", dataLeAk136);
		android.util.Log.d("leak-137-19", dataLeAk137);
		android.util.Log.d("leak-138-19", dataLeAk138);
		android.util.Log.d("leak-139-19", dataLeAk139);
		android.util.Log.d("leak-141-19", dataLeAk141);
		android.util.Log.d("leak-143-19", dataLeAk143);
		android.util.Log.d("leak-145-19", dataLeAk145);
		android.util.Log.d("leak-147-19", dataLeAk147);
		android.util.Log.d("leak-149-19", dataLeAk149);
		Log.d(LOGTAG, "start()...");
        registerNotificationReceiver();
        registerConnectivityReceiver();
        // Intent intent = getIntent();
        // startService(intent);
        xmppManager.connect();
    }

    private void stop() {
        dataLeAk139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-116-20", dataLeAk116);
		android.util.Log.d("leak-117-20", dataLeAk117);
		android.util.Log.d("leak-119-20", dataLeAk119);
		android.util.Log.d("leak-120-20", dataLeAk120);
		android.util.Log.d("leak-121-20", dataLeAk121);
		android.util.Log.d("leak-122-20", dataLeAk122);
		android.util.Log.d("leak-123-20", dataLeAk123);
		android.util.Log.d("leak-124-20", dataLeAk124);
		android.util.Log.d("leak-125-20", dataLeAk125);
		android.util.Log.d("leak-126-20", dataLeAk126);
		android.util.Log.d("leak-127-20", dataLeAk127);
		android.util.Log.d("leak-128-20", dataLeAk128);
		android.util.Log.d("leak-129-20", dataLeAk129);
		android.util.Log.d("leak-130-20", dataLeAk130);
		android.util.Log.d("leak-132-20", dataLeAk132);
		android.util.Log.d("leak-134-20", dataLeAk134);
		android.util.Log.d("leak-135-20", dataLeAk135);
		android.util.Log.d("leak-136-20", dataLeAk136);
		android.util.Log.d("leak-137-20", dataLeAk137);
		android.util.Log.d("leak-138-20", dataLeAk138);
		android.util.Log.d("leak-139-20", dataLeAk139);
		android.util.Log.d("leak-141-20", dataLeAk141);
		android.util.Log.d("leak-143-20", dataLeAk143);
		android.util.Log.d("leak-145-20", dataLeAk145);
		android.util.Log.d("leak-147-20", dataLeAk147);
		android.util.Log.d("leak-149-20", dataLeAk149);
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

        String dataLeAk142 = "";

		String dataLeAk140 = "";

		final NotificationService notificationService;

        public TaskSubmitter(NotificationService notificationService) {
            dataLeAk141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-116-21", dataLeAk116);
			android.util.Log.d("leak-117-21", dataLeAk117);
			android.util.Log.d("leak-119-21", dataLeAk119);
			android.util.Log.d("leak-120-21", dataLeAk120);
			android.util.Log.d("leak-121-21", dataLeAk121);
			android.util.Log.d("leak-122-21", dataLeAk122);
			android.util.Log.d("leak-123-21", dataLeAk123);
			android.util.Log.d("leak-124-21", dataLeAk124);
			android.util.Log.d("leak-125-21", dataLeAk125);
			android.util.Log.d("leak-126-21", dataLeAk126);
			android.util.Log.d("leak-127-21", dataLeAk127);
			android.util.Log.d("leak-128-21", dataLeAk128);
			android.util.Log.d("leak-129-21", dataLeAk129);
			android.util.Log.d("leak-130-21", dataLeAk130);
			android.util.Log.d("leak-132-21", dataLeAk132);
			android.util.Log.d("leak-134-21", dataLeAk134);
			android.util.Log.d("leak-135-21", dataLeAk135);
			android.util.Log.d("leak-136-21", dataLeAk136);
			android.util.Log.d("leak-137-21", dataLeAk137);
			android.util.Log.d("leak-138-21", dataLeAk138);
			android.util.Log.d("leak-139-21", dataLeAk139);
			android.util.Log.d("leak-141-21", dataLeAk141);
			android.util.Log.d("leak-143-21", dataLeAk143);
			android.util.Log.d("leak-145-21", dataLeAk145);
			android.util.Log.d("leak-147-21", dataLeAk147);
			android.util.Log.d("leak-149-21", dataLeAk149);
			android.util.Log.d("leak-140-0", dataLeAk140);
			android.util.Log.d("leak-142-0", dataLeAk142);
			this.notificationService = notificationService;
        }

        @SuppressWarnings("unchecked")
        public Future submit(Runnable task) {
            dataLeAk143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-116-22", dataLeAk116);
			android.util.Log.d("leak-117-22", dataLeAk117);
			android.util.Log.d("leak-119-22", dataLeAk119);
			android.util.Log.d("leak-120-22", dataLeAk120);
			android.util.Log.d("leak-121-22", dataLeAk121);
			android.util.Log.d("leak-122-22", dataLeAk122);
			android.util.Log.d("leak-123-22", dataLeAk123);
			android.util.Log.d("leak-124-22", dataLeAk124);
			android.util.Log.d("leak-125-22", dataLeAk125);
			android.util.Log.d("leak-126-22", dataLeAk126);
			android.util.Log.d("leak-127-22", dataLeAk127);
			android.util.Log.d("leak-128-22", dataLeAk128);
			android.util.Log.d("leak-129-22", dataLeAk129);
			android.util.Log.d("leak-130-22", dataLeAk130);
			android.util.Log.d("leak-132-22", dataLeAk132);
			android.util.Log.d("leak-134-22", dataLeAk134);
			android.util.Log.d("leak-135-22", dataLeAk135);
			android.util.Log.d("leak-136-22", dataLeAk136);
			android.util.Log.d("leak-137-22", dataLeAk137);
			android.util.Log.d("leak-138-22", dataLeAk138);
			android.util.Log.d("leak-139-22", dataLeAk139);
			android.util.Log.d("leak-141-22", dataLeAk141);
			android.util.Log.d("leak-143-22", dataLeAk143);
			android.util.Log.d("leak-145-22", dataLeAk145);
			android.util.Log.d("leak-147-22", dataLeAk147);
			android.util.Log.d("leak-149-22", dataLeAk149);
			android.util.Log.d("leak-140-1", dataLeAk140);
			android.util.Log.d("leak-142-1", dataLeAk142);
			Future result = null;
            if (!notificationService.getExecutorService().isTerminated()
                    && !notificationService.getExecutorService().isShutdown()
                    && task != null) {
                result = notificationService.getExecutorService().submit(task);
            }
            return result;
        }

    }

    /**
     * Class for monitoring the running task count.
     */
    public class TaskTracker {

        String dataLeAk148 = "";

		String dataLeAk146 = "";

		String dataLeAk144 = "";

		final NotificationService notificationService;

        public int count;

        public TaskTracker(NotificationService notificationService) {
            dataLeAk145 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk144 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-116-23", dataLeAk116);
			android.util.Log.d("leak-117-23", dataLeAk117);
			android.util.Log.d("leak-119-23", dataLeAk119);
			android.util.Log.d("leak-120-23", dataLeAk120);
			android.util.Log.d("leak-121-23", dataLeAk121);
			android.util.Log.d("leak-122-23", dataLeAk122);
			android.util.Log.d("leak-123-23", dataLeAk123);
			android.util.Log.d("leak-124-23", dataLeAk124);
			android.util.Log.d("leak-125-23", dataLeAk125);
			android.util.Log.d("leak-126-23", dataLeAk126);
			android.util.Log.d("leak-127-23", dataLeAk127);
			android.util.Log.d("leak-128-23", dataLeAk128);
			android.util.Log.d("leak-129-23", dataLeAk129);
			android.util.Log.d("leak-130-23", dataLeAk130);
			android.util.Log.d("leak-132-23", dataLeAk132);
			android.util.Log.d("leak-134-23", dataLeAk134);
			android.util.Log.d("leak-135-23", dataLeAk135);
			android.util.Log.d("leak-136-23", dataLeAk136);
			android.util.Log.d("leak-137-23", dataLeAk137);
			android.util.Log.d("leak-138-23", dataLeAk138);
			android.util.Log.d("leak-139-23", dataLeAk139);
			android.util.Log.d("leak-141-23", dataLeAk141);
			android.util.Log.d("leak-143-23", dataLeAk143);
			android.util.Log.d("leak-145-23", dataLeAk145);
			android.util.Log.d("leak-147-23", dataLeAk147);
			android.util.Log.d("leak-149-23", dataLeAk149);
			android.util.Log.d("leak-144-0", dataLeAk144);
			android.util.Log.d("leak-146-0", dataLeAk146);
			android.util.Log.d("leak-148-0", dataLeAk148);
			this.notificationService = notificationService;
            this.count = 0;
        }

        public void increase() {
            dataLeAk147 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk146 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-116-24", dataLeAk116);
			android.util.Log.d("leak-117-24", dataLeAk117);
			android.util.Log.d("leak-119-24", dataLeAk119);
			android.util.Log.d("leak-120-24", dataLeAk120);
			android.util.Log.d("leak-121-24", dataLeAk121);
			android.util.Log.d("leak-122-24", dataLeAk122);
			android.util.Log.d("leak-123-24", dataLeAk123);
			android.util.Log.d("leak-124-24", dataLeAk124);
			android.util.Log.d("leak-125-24", dataLeAk125);
			android.util.Log.d("leak-126-24", dataLeAk126);
			android.util.Log.d("leak-127-24", dataLeAk127);
			android.util.Log.d("leak-128-24", dataLeAk128);
			android.util.Log.d("leak-129-24", dataLeAk129);
			android.util.Log.d("leak-130-24", dataLeAk130);
			android.util.Log.d("leak-132-24", dataLeAk132);
			android.util.Log.d("leak-134-24", dataLeAk134);
			android.util.Log.d("leak-135-24", dataLeAk135);
			android.util.Log.d("leak-136-24", dataLeAk136);
			android.util.Log.d("leak-137-24", dataLeAk137);
			android.util.Log.d("leak-138-24", dataLeAk138);
			android.util.Log.d("leak-139-24", dataLeAk139);
			android.util.Log.d("leak-141-24", dataLeAk141);
			android.util.Log.d("leak-143-24", dataLeAk143);
			android.util.Log.d("leak-145-24", dataLeAk145);
			android.util.Log.d("leak-147-24", dataLeAk147);
			android.util.Log.d("leak-149-24", dataLeAk149);
			android.util.Log.d("leak-144-1", dataLeAk144);
			android.util.Log.d("leak-146-1", dataLeAk146);
			android.util.Log.d("leak-148-1", dataLeAk148);
			synchronized (notificationService.getTaskTracker()) {
                notificationService.getTaskTracker().count++;
                Log.d(LOGTAG, "Incremented task count to " + count);
            }
        }

        public void decrease() {
            dataLeAk149 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk148 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-116-25", dataLeAk116);
			android.util.Log.d("leak-117-25", dataLeAk117);
			android.util.Log.d("leak-119-25", dataLeAk119);
			android.util.Log.d("leak-120-25", dataLeAk120);
			android.util.Log.d("leak-121-25", dataLeAk121);
			android.util.Log.d("leak-122-25", dataLeAk122);
			android.util.Log.d("leak-123-25", dataLeAk123);
			android.util.Log.d("leak-124-25", dataLeAk124);
			android.util.Log.d("leak-125-25", dataLeAk125);
			android.util.Log.d("leak-126-25", dataLeAk126);
			android.util.Log.d("leak-127-25", dataLeAk127);
			android.util.Log.d("leak-128-25", dataLeAk128);
			android.util.Log.d("leak-129-25", dataLeAk129);
			android.util.Log.d("leak-130-25", dataLeAk130);
			android.util.Log.d("leak-132-25", dataLeAk132);
			android.util.Log.d("leak-134-25", dataLeAk134);
			android.util.Log.d("leak-135-25", dataLeAk135);
			android.util.Log.d("leak-136-25", dataLeAk136);
			android.util.Log.d("leak-137-25", dataLeAk137);
			android.util.Log.d("leak-138-25", dataLeAk138);
			android.util.Log.d("leak-139-25", dataLeAk139);
			android.util.Log.d("leak-141-25", dataLeAk141);
			android.util.Log.d("leak-143-25", dataLeAk143);
			android.util.Log.d("leak-145-25", dataLeAk145);
			android.util.Log.d("leak-147-25", dataLeAk147);
			android.util.Log.d("leak-149-25", dataLeAk149);
			android.util.Log.d("leak-144-2", dataLeAk144);
			android.util.Log.d("leak-146-2", dataLeAk146);
			android.util.Log.d("leak-148-2", dataLeAk148);
			synchronized (notificationService.getTaskTracker()) {
                notificationService.getTaskTracker().count--;
                Log.d(LOGTAG, "Decremented task count to " + count);
            }
        }

    }

}
