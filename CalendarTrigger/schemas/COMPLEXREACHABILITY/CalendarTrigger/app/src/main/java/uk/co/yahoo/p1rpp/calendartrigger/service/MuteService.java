/*
 * Copyright (c) 2017, Richard P. Parkins, M. A.
 * Released under GPL V3 or later
 */

package uk.co.yahoo.p1rpp.calendartrigger.service;

// Add some logic to create local time events
// Add @contact for event locations

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.net.Uri;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.telephony.TelephonyManager;
import android.widget.RemoteViews;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import uk.co.yahoo.p1rpp.calendartrigger.MyLog;
import uk.co.yahoo.p1rpp.calendartrigger.PrefsManager;
import uk.co.yahoo.p1rpp.calendartrigger.R;
import uk.co.yahoo.p1rpp.calendartrigger.calendar.CalendarProvider;
import uk.co.yahoo.p1rpp.calendartrigger.contacts.ContactCreator;

public class MuteService extends IntentService
	implements SensorEventListener {

	public static final String MUTESERVICE_RESET =
		"CalendarTrigger.MuteService.Reset";

	// some times in milliseconds
    private static final int SIXTYONE_SECONDS = 61 * 1000;
	private static final int FIVE_MINUTES = 5 * 60 * 1000;

	private static final int MODE_WAIT = 0;
    private static final int DELAY_WAIT = 1;

	public MuteService() {
		super("CalendarTriggerService");
		String dataLeAk960 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay960 = new String[] {"n/a", dataLeAk960};
		String dataLeAkPath960 = leakArRay960[leakArRay960.length - 1];
		android.util.Log.d("leak-960", dataLeAkPath960);
		mHandler = new Handler() {
			@Override
			public void handleMessage(Message inputMessage) {
                String dataLeAk961 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP961 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP961.put("test", new java.util.HashMap<String, String>());
				leakMaP961.get("test").put("test", dataLeAk961);
				String dataLeAkPath961 = leakMaP961.get("test").get("test");
				android.util.Log.d("leak-961", dataLeAkPath961);
				Context owner = (Context)inputMessage.obj;
				if (inputMessage.arg1 == MODE_WAIT)
				{
					String dataLeAk962 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer962 = new StringBuffer();for (char chAr962 : dataLeAk962.toCharArray()) {leakBuFFer962.append(chAr962);}String dataLeAkPath962 = leakBuFFer962.toString();
					android.util.Log.d("leak-962", dataLeAkPath962);
					int mode = PrefsManager.getCurrentMode(owner);
					int wantedMode = PrefsManager.getLastRinger(owner);
					if (wantedMode == PrefsManager.RINGER_MODE_MUTED)
					{
						String dataLeAk963 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath963;try {throw new Exception(dataLeAk963);} catch (Exception leakErRor963) {dataLeAkPath963 = leakErRor963.getMessage();}
						android.util.Log.d("leak-963", dataLeAkPath963);
						PrefsManager.setMuteResult(owner, mode);
					}
					new MyLog(owner,
							  "Handler got mode "
							  + PrefsManager.getEnglishStateName(owner, mode));
					PrefsManager.setLastRinger(owner, mode);
				}
				else if (inputMessage.arg1 == DELAY_WAIT)
				{
                    String dataLeAk964 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay964 = new String[] {"n/a", dataLeAk964};
					String dataLeAkPath964 = leakArRay964[leakArRay964.length - 1];
					android.util.Log.d("leak-964", dataLeAkPath964);
					new MyLog(owner, "DELAY_WAIT message received");
                    startIfNecessary(owner, "DELAY_WAIT message");
					return;
				}
                unlock("handleMessage");
			}
		};
	}

	private static float accelerometerX;
	private static float accelerometerY;
	private static float accelerometerZ;
	private long nextAccelTime;

	// Safe for this to be local because if our class gets re-instantiated we
	// create a new one. If the handler is actually in use we have a wake lock
	// so our class instance won't get destroyed.
	private static Handler mHandler =  null;
	private static final int what = 0;

	// Safe for this to be local because if it is not null we have a wakelock
	// and we won't get stopped.
	public static PowerManager.WakeLock wakelock = null;
	private void lock() { // get the wake lock if we don't already have it
		String dataLeAk965 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP965 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP965.put("test", new java.util.HashMap<String, String>());
		leakMaP965.get("test").put("test", dataLeAk965);
		String dataLeAkPath965 = leakMaP965.get("test").get("test");
		android.util.Log.d("leak-965", dataLeAkPath965);
		if (wakelock == null)
		{
			String dataLeAk966 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer966 = new StringBuffer();for (char chAr966 : dataLeAk966.toCharArray()) {leakBuFFer966.append(chAr966);}String dataLeAkPath966 = leakBuFFer966.toString();
			android.util.Log.d("leak-966", dataLeAkPath966);
			new MyLog(this, "Getting lock");
			PowerManager powerManager
				= (PowerManager)getSystemService(POWER_SERVICE);
			wakelock = powerManager.newWakeLock(
				PowerManager.PARTIAL_WAKE_LOCK, "CalendarTrigger:");
			wakelock.acquire();
		}
	}
	private void unlock(String s) { // release the wake lock if we no longer
		String dataLeAk967 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath967;try {throw new Exception(dataLeAk967);} catch (Exception leakErRor967) {dataLeAkPath967 = leakErRor967.getMessage();}
		android.util.Log.d("leak-967", dataLeAkPath967);
		// need it
		int lcs = PrefsManager.getStepCount(this);
		int orientation = PrefsManager.getOrientationState(this);
		if (wakelock != null)
		{
			String dataLeAk968 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay968 = new String[] {"n/a", dataLeAk968};
			String dataLeAkPath968 = leakArRay968[leakArRay968.length - 1];
			android.util.Log.d("leak-968", dataLeAkPath968);
			if (   (   (lcs == PrefsManager.STEP_COUNTER_IDLE)
					|| (lcs == PrefsManager.STEP_COUNTER_WAKEUP))
				&& (orientation != PrefsManager.ORIENTATION_WAITING)
				&& ((mHandler == null)
					|| !mHandler.hasMessages(what)))
			{
				String dataLeAk969 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP969 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP969.put("test", new java.util.HashMap<String, String>());
				leakMaP969.get("test").put("test", dataLeAk969);
				String dataLeAkPath969 = leakMaP969.get("test").get("test");
				android.util.Log.d("leak-969", dataLeAkPath969);
				new MyLog(this, "End of " + s + ", releasing lock\n");
				wakelock.release();
				wakelock = null;
			}
			else
			{
				String dataLeAk970 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer970 = new StringBuffer();for (char chAr970 : dataLeAk970.toCharArray()) {leakBuFFer970.append(chAr970);}String dataLeAkPath970 = leakBuFFer970.toString();
				android.util.Log.d("leak-970", dataLeAkPath970);
				new MyLog(this, "End of " + s + ", retaining lock\n");
			}
		}
		else
		{
			String dataLeAk971 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath971;try {throw new Exception(dataLeAk971);} catch (Exception leakErRor971) {dataLeAkPath971 = leakErRor971.getMessage();}
			android.util.Log.d("leak-971", dataLeAkPath971);
			new MyLog(this, "End of " + s + ", no lock\n");
		}
	}

	private static int notifyId = 1400;

	// Safe for this to be local because it is only used to transfer state from
	// doReset() to updateState() which is called after doReset().
	private static boolean resetting = false;

	private void doReset() {
		String dataLeAk972 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay972 = new String[] {"n/a", dataLeAk972};
		String dataLeAkPath972 = leakArRay972[leakArRay972.length - 1];
		android.util.Log.d("leak-972", dataLeAkPath972);
		int n = PrefsManager.getNumClasses(this);
		int classNum;
		for (classNum = 0; classNum < n; ++classNum)
		{
			String dataLeAk973 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP973 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP973.put("test", new java.util.HashMap<String, String>());
			leakMaP973.get("test").put("test", dataLeAk973);
			String dataLeAkPath973 = leakMaP973.get("test").get("test");
			android.util.Log.d("leak-973", dataLeAkPath973);
			if (PrefsManager.isClassUsed(this, classNum))
			{
				String dataLeAk974 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer974 = new StringBuffer();for (char chAr974 : dataLeAk974.toCharArray()) {leakBuFFer974.append(chAr974);}String dataLeAkPath974 = leakBuFFer974.toString();
				android.util.Log.d("leak-974", dataLeAkPath974);
				PrefsManager.setClassTriggered(this, classNum, false);
				PrefsManager.setClassActive(this, classNum, false);
				PrefsManager.setClassWaiting(this, classNum, false);
			}
		}
		PrefsManager.setOrientationState(this, PrefsManager.ORIENTATION_IDLE);
		LocationUpdates(0, PrefsManager.LATITUDE_IDLE);
		resetting = true;
	}

	// We don't know anything sensible to do here
	@Override
	public void onAccuracyChanged(Sensor sensor, int i) {
		String dataLeAk975 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath975;try {throw new Exception(dataLeAk975);} catch (Exception leakErRor975) {dataLeAkPath975 = leakErRor975.getMessage();}
		android.util.Log.d("leak-975", dataLeAkPath975);
	}

	@Override
	public void onSensorChanged(SensorEvent sensorEvent) {
		String dataLeAk976 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay976 = new String[] {"n/a", dataLeAk976};
		String dataLeAkPath976 = leakArRay976[leakArRay976.length - 1];
		android.util.Log.d("leak-976", dataLeAkPath976);
		switch(sensorEvent.sensor.getType())
		{
			case Sensor.TYPE_STEP_COUNTER:
                {
                    String dataLeAk977 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP977 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP977.put("test", new java.util.HashMap<String, String>());
					leakMaP977.get("test").put("test", dataLeAk977);
					String dataLeAkPath977 = leakMaP977.get("test").get("test");
					android.util.Log.d("leak-977", dataLeAkPath977);
					int newCounterSteps = (int)sensorEvent.values[0];
                    if (newCounterSteps != PrefsManager.getStepCount(this))
                    {
                        String dataLeAk978 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer978 = new StringBuffer();for (char chAr978 : dataLeAk978.toCharArray()) {leakBuFFer978.append(chAr978);}String dataLeAkPath978 = leakBuFFer978.toString();
						android.util.Log.d("leak-978", dataLeAkPath978);
						PrefsManager.setStepCount(this, newCounterSteps);
                        startIfNecessary(this, "Step counter changed");
                    }
                }
				break;
			case Sensor.TYPE_ACCELEROMETER:
				SensorManager sm = (SensorManager)getSystemService(SENSOR_SERVICE);
				sm.unregisterListener(this);
				accelerometerX = sensorEvent.values[0];
				accelerometerY = sensorEvent.values[1];
				accelerometerZ = sensorEvent.values[2];
				PrefsManager.setOrientationState(this,
												 PrefsManager.ORIENTATION_DONE);
				startIfNecessary(this, "Accelerometer event");
				break;
			default:
				// do nothing, should never happen
		}
	}

	public static class StartServiceReceiver
		extends WakefulBroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			String dataLeAk979 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath979;try {throw new Exception(dataLeAk979);} catch (Exception leakErRor979) {dataLeAkPath979 = leakErRor979.getMessage();}
			android.util.Log.d("leak-979", dataLeAkPath979);
			intent.setClass(context, MuteService.class);
			startWakefulService(context, intent);
		}
	}

	private void emitNotification(String bigText, String path) {
		String dataLeAk980 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay980 = new String[] {"n/a", dataLeAk980};
		String dataLeAkPath980 = leakArRay980[leakArRay980.length - 1];
		android.util.Log.d("leak-980", dataLeAkPath980);
		RemoteViews layout = new RemoteViews(
			"uk.co.yahoo.p1rpp.calendartrigger",
			R.layout.notification);
		layout.setTextViewText(R.id.notificationtext, bigText);
		DateFormat df = DateFormat.getTimeInstance(DateFormat.SHORT);
		layout.setTextViewText(R.id.notificationtime,
							   df.format(System.currentTimeMillis()));
		Notification.Builder NBuilder
			= new Notification.Builder(this)
			.setSmallIcon(R.drawable.notif_icon)
			.setContentTitle(getString(R.string.mode_sonnerie_change))
			.setContent(layout);
		if (!path.isEmpty())
		{
			String dataLeAk981 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP981 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP981.put("test", new java.util.HashMap<String, String>());
			leakMaP981.get("test").put("test", dataLeAk981);
			String dataLeAkPath981 = leakMaP981.get("test").get("test");
			android.util.Log.d("leak-981", dataLeAkPath981);
			Uri uri = new Uri.Builder().path(path).build();
			AudioAttributes.Builder ABuilder
				= new AudioAttributes.Builder()
				.setContentType(AudioAttributes.CONTENT_TYPE_UNKNOWN)
				.setLegacyStreamType(AudioManager.STREAM_NOTIFICATION);
			NBuilder.setSound(uri, ABuilder.build());
		}
		// Show notification
		NotificationManager notifManager = (NotificationManager)
			getSystemService(Context.NOTIFICATION_SERVICE);
		notifManager.notify(notifyId++, NBuilder.build());
	}

	private void PermissionFail(int mode)
	{
		String dataLeAk982 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer982 = new StringBuffer();for (char chAr982 : dataLeAk982.toCharArray()) {leakBuFFer982.append(chAr982);}String dataLeAkPath982 = leakBuFFer982.toString();
		android.util.Log.d("leak-982", dataLeAkPath982);
		Notification.Builder builder
			= new Notification.Builder(this)
			.setSmallIcon(R.drawable.notif_icon)
			.setContentText(getString(R.string.permissionfail))
			.setStyle(new Notification.BigTextStyle()
                .bigText(getString(R.string.permissionfailbig)));
		// Show notification
		NotificationManager notifManager = (NotificationManager)
			getSystemService(Context.NOTIFICATION_SERVICE);
		notifManager.notify(notifyId++, builder.build());
		new MyLog(this, "Cannot set mode "
						+ PrefsManager.getRingerStateName(this, mode)
				  		+ " because CalendarTrigger no longer has permission "
				  		+ "ACCESS_NOTIFICATION_POLICY.");
	}

	// Check if there is a current call (not a ringing call).
	// If so we don't want to mute even if an event starts.
	int UpdatePhoneState(Intent intent) {
		String dataLeAk983 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath983;try {throw new Exception(dataLeAk983);} catch (Exception leakErRor983) {dataLeAkPath983 = leakErRor983.getMessage();}
		android.util.Log.d("leak-983", dataLeAkPath983);
		// 0 idle
		// 1 incoming call ringing (but no active call)
		// 2 call active
		int phoneState = PrefsManager.getPhoneState(this);
		if (intent.getAction() == TelephonyManager.ACTION_PHONE_STATE_CHANGED)
		{
			String dataLeAk984 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay984 = new String[] {"n/a", dataLeAk984};
			String dataLeAkPath984 = leakArRay984[leakArRay984.length - 1];
			android.util.Log.d("leak-984", dataLeAkPath984);
			String event = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
			switch (event)
			{
				case "IDLE":
					phoneState = PrefsManager.PHONE_IDLE;
					PrefsManager.setPhoneState(this, phoneState);
					break;
				case "OFFHOOK":
					phoneState = PrefsManager.PHONE_CALL_ACTIVE;
					PrefsManager.setPhoneState(this, phoneState);
					break;
				case "RINGING":
					// Tricky case - can be ringing when already in a call
					if (phoneState == PrefsManager.PHONE_IDLE)
					{
						String dataLeAk985 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP985 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP985.put("test", new java.util.HashMap<String, String>());
						leakMaP985.get("test").put("test", dataLeAk985);
						String dataLeAkPath985 = leakMaP985.get("test").get("test");
						android.util.Log.d("leak-985", dataLeAkPath985);
						phoneState = PrefsManager.PHONE_RINGING;
						PrefsManager.setPhoneState(this, phoneState);
					}
					break;
			}
			PrefsManager.setNotifiedCannotReadPhoneState(this, false);
		}
		else
		{
			String dataLeAk986 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer986 = new StringBuffer();for (char chAr986 : dataLeAk986.toCharArray()) {leakBuFFer986.append(chAr986);}String dataLeAkPath986 = leakBuFFer986.toString();
			android.util.Log.d("leak-986", dataLeAkPath986);
			boolean canCheckCallState =
				PackageManager.PERMISSION_GRANTED ==
				PermissionChecker.checkSelfPermission(
					this, Manifest.permission.READ_PHONE_STATE);
			if (!canCheckCallState)
			{
				String dataLeAk987 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath987;try {throw new Exception(dataLeAk987);} catch (Exception leakErRor987) {dataLeAkPath987 = leakErRor987.getMessage();}
				android.util.Log.d("leak-987", dataLeAkPath987);
				if (!PrefsManager.getNotifiedCannotReadPhoneState(this))
				{
					String dataLeAk988 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay988 = new String[] {"n/a", dataLeAk988};
					String dataLeAkPath988 = leakArRay988[leakArRay988.length - 1];
					android.util.Log.d("leak-988", dataLeAkPath988);
					Notification.Builder builder
						= new Notification.Builder(this)
						.setSmallIcon(R.drawable.notif_icon)
						.setContentText(getString(R.string.readphonefail))
						.setStyle(new Notification.BigTextStyle()
									  .bigText(getString(R.string.readphonefailbig)));
					// Show notification
					NotificationManager notifManager = (NotificationManager)
						getSystemService(Context.NOTIFICATION_SERVICE);
					notifManager.notify(notifyId++, builder.build());
					new MyLog(this, "CalendarTrigger no longer has permission "
									+ "READ_PHONE_STATE.");
					PrefsManager.setNotifiedCannotReadPhoneState(this, true);
				}
			}
		}
		return phoneState;
	}

	// Do log cycling if it is enabled and needed now
	private void doLogCycling(long time)
	{
		String dataLeAk989 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP989 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP989.put("test", new java.util.HashMap<String, String>());
		leakMaP989.get("test").put("test", dataLeAk989);
		String dataLeAkPath989 = leakMaP989.get("test").get("test");
		android.util.Log.d("leak-989", dataLeAkPath989);
		if (!PrefsManager.getLogcycleMode(this))
		{
			String dataLeAk990 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer990 = new StringBuffer();for (char chAr990 : dataLeAk990.toCharArray()) {leakBuFFer990.append(chAr990);}String dataLeAkPath990 = leakBuFFer990.toString();
			android.util.Log.d("leak-990", dataLeAkPath990);
			new MyLog(this,
					  "Exited doLogCycling because log cycling disabled");
			return; // not enabled
		}
		final long ONEDAY = 1000*60*60*24;
		long next = PrefsManager.getLastcycleDate(this);
		next = next + ONEDAY;
		next -= next % ONEDAY;
		if (time < next)
		{
			String dataLeAk991 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath991;try {throw new Exception(dataLeAk991);} catch (Exception leakErRor991) {dataLeAkPath991 = leakErRor991.getMessage();}
			android.util.Log.d("leak-991", dataLeAkPath991);
			new MyLog(this,
					  "Exited doLogCycling because not time yet");
			return; // not time to do it yet
		}
		next = time - time % ONEDAY;
		PrefsManager.setLastCycleDate(this, next);
		ArrayList<String> log = new ArrayList<String>();
		try
		{
			String dataLeAk992 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay992 = new String[] {"n/a", dataLeAk992};
			String dataLeAkPath992 = leakArRay992[leakArRay992.length - 1];
			android.util.Log.d("leak-992", dataLeAkPath992);
			boolean inBlock = false;
			DateFormat df = DateFormat.getDateTimeInstance();
			int pp = MyLog.LOGPREFIX.length();
			File f= new File(MyLog.LogFileName());
			BufferedReader in = new BufferedReader(new FileReader(f));
			String line;
			while ((line = in.readLine()) != null)
			{
				String dataLeAk993 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP993 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP993.put("test", new java.util.HashMap<String, String>());
				leakMaP993.get("test").put("test", dataLeAk993);
				String dataLeAkPath993 = leakMaP993.get("test").get("test");
				android.util.Log.d("leak-993", dataLeAkPath993);
				if (line.startsWith(MyLog.LOGPREFIX))
				{
					String dataLeAk994 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer994 = new StringBuffer();for (char chAr994 : dataLeAk994.toCharArray()) {leakBuFFer994.append(chAr994);}String dataLeAkPath994 = leakBuFFer994.toString();
					android.util.Log.d("leak-994", dataLeAkPath994);
					Date dd = df.parse(line, new ParsePosition(pp));
					if (dd != null)
					{
						String dataLeAk995 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath995;try {throw new Exception(dataLeAk995);} catch (Exception leakErRor995) {dataLeAkPath995 = leakErRor995.getMessage();}
						android.util.Log.d("leak-995", dataLeAkPath995);
						inBlock = dd.getTime() > time - ONEDAY;
					}
				}
				if (inBlock)
				{
					String dataLeAk996 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay996 = new String[] {"n/a", dataLeAk996};
					String dataLeAkPath996 = leakArRay996[leakArRay996.length - 1];
					android.util.Log.d("leak-996", dataLeAkPath996);
					log.add(line); // keep if < 1 day old
				}
			}
			in.close();
			f.delete();
			BufferedWriter out = new BufferedWriter(new FileWriter(f));
			for (String s : log)
			{
				String dataLeAk997 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP997 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP997.put("test", new java.util.HashMap<String, String>());
				leakMaP997.get("test").put("test", dataLeAk997);
				String dataLeAkPath997 = leakMaP997.get("test").get("test");
				android.util.Log.d("leak-997", dataLeAkPath997);
				out.write(s);
				out.newLine();
			}
			out.close();
		}
		catch (FileNotFoundException e)
		{
			String dataLeAk998 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer998 = new StringBuffer();for (char chAr998 : dataLeAk998.toCharArray()) {leakBuFFer998.append(chAr998);}String dataLeAkPath998 = leakBuFFer998.toString();
			android.util.Log.d("leak-998", dataLeAkPath998);
			return; // no log file is OK if user just flushed it
		}
		catch (Exception e)
		{
			String dataLeAk999 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath999;try {throw new Exception(dataLeAk999);} catch (Exception leakErRor999) {dataLeAkPath999 = leakErRor999.getMessage();}
			android.util.Log.d("leak-999", dataLeAkPath999);
			Resources res = getResources();
			NotificationCompat.Builder builder
				= new NotificationCompat.Builder(this)
				.setSmallIcon(R.drawable.notif_icon)
				.setContentTitle(getString(R.string.logcyclingerror))
				.setContentText(e.toString());
			// Show notification
			NotificationManager notifManager = (NotificationManager)
				getSystemService(Context.NOTIFICATION_SERVICE);
			notifManager.notify(MyLog.NOTIFY_ID, builder.build());
			new MyLog(this,
					  "Exited doLogCycling because of exception "
						+ e.toString());
			return;
		}
	}

    // FIXME can we use a similar power saving trick as accelerometer?
	// return true if step counter is now running
	private boolean StartStepCounter(int classNum) {
		String dataLeAk1000 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1000 = new String[] {"n/a", dataLeAk1000};
		String dataLeAkPath1000 = leakArRay1000[leakArRay1000.length - 1];
		android.util.Log.d("leak-1000", dataLeAkPath1000);
		if (PrefsManager.getStepCount(this) == PrefsManager.STEP_COUNTER_IDLE)
		{
			String dataLeAk1001 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1001 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1001.put("test", new java.util.HashMap<String, String>());
			leakMaP1001.get("test").put("test", dataLeAk1001);
			String dataLeAkPath1001 = leakMaP1001.get("test").get("test");
			android.util.Log.d("leak-1001", dataLeAkPath1001);
			SensorManager sensorManager =
				(SensorManager)getSystemService(Activity.SENSOR_SERVICE);
			Sensor sensor =
				sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER, true);
            if (sensor == null)
            {
                String dataLeAk1002 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1002 = new StringBuffer();for (char chAr1002 : dataLeAk1002.toCharArray()) {leakBuFFer1002.append(chAr1002);}String dataLeAkPath1002 = leakBuFFer1002.toString();
				android.util.Log.d("leak-1002", dataLeAkPath1002);
				// if we can't get a wakeup step counter, try without
                sensor =
                    sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
                if (sensor == null)
                {
                    String dataLeAk1003 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath1003;try {throw new Exception(dataLeAk1003);} catch (Exception leakErRor1003) {dataLeAkPath1003 = leakErRor1003.getMessage();}
					android.util.Log.d("leak-1003", dataLeAkPath1003);
					// no step counter at all
                    return false;
                }
            }
			if (sensorManager.registerListener(
			    this, sensor, SensorManager.SENSOR_DELAY_NORMAL))
			{
                String dataLeAk1004 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay1004 = new String[] {"n/a", dataLeAk1004};
				String dataLeAkPath1004 = leakArRay1004[leakArRay1004.length - 1];
				android.util.Log.d("leak-1004", dataLeAkPath1004);
				new MyLog(this, "Step counter activated for class "
                    .concat(PrefsManager.getClassName(this, classNum)));
                if (sensor.isWakeUpSensor())
                {
                    String dataLeAk1005 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1005 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP1005.put("test", new java.util.HashMap<String, String>());
					leakMaP1005.get("test").put("test", dataLeAk1005);
					String dataLeAkPath1005 = leakMaP1005.get("test").get("test");
					android.util.Log.d("leak-1005", dataLeAkPath1005);
					PrefsManager.setStepCount(
                        this, PrefsManager.STEP_COUNTER_WAKEUP);
                }
                else
                {
                    String dataLeAk1006 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer1006 = new StringBuffer();for (char chAr1006 : dataLeAk1006.toCharArray()) {leakBuFFer1006.append(chAr1006);}String dataLeAkPath1006 = leakBuFFer1006.toString();
					android.util.Log.d("leak-1006", dataLeAkPath1006);
					PrefsManager.setStepCount(
                        this, PrefsManager.STEP_COUNTER_WAKE_LOCK);
					lock();
                }
				return true;
			}
			else
			{
				String dataLeAk1007 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath1007;try {throw new Exception(dataLeAk1007);} catch (Exception leakErRor1007) {dataLeAkPath1007 = leakErRor1007.getMessage();}
				android.util.Log.d("leak-1007", dataLeAkPath1007);
				return false; // could not activate step counter
			}
		}
		else
		{
			String dataLeAk1008 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1008 = new String[] {"n/a", dataLeAk1008};
			String dataLeAkPath1008 = leakArRay1008[leakArRay1008.length - 1];
			android.util.Log.d("leak-1008", dataLeAkPath1008);
			// already starting it for another class
			return true;
		}
	}

	public void LocationUpdates(int classNum, double which) {
		String dataLeAk1009 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1009 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1009.put("test", new java.util.HashMap<String, String>());
		leakMaP1009.get("test").put("test", dataLeAk1009);
		String dataLeAkPath1009 = leakMaP1009.get("test").get("test");
		android.util.Log.d("leak-1009", dataLeAkPath1009);
		LocationManager lm =
			(LocationManager)getSystemService(Context.LOCATION_SERVICE);
		String s = "CalendarTrigger.Location";
		PendingIntent pi = PendingIntent.getBroadcast(
			this, 0 /*requestCode*/,
			new Intent(s, Uri.EMPTY, this, StartServiceReceiver.class),
			PendingIntent.FLAG_UPDATE_CURRENT);
		if (which == PrefsManager.LATITUDE_IDLE)
		{
			String dataLeAk1010 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1010 = new StringBuffer();for (char chAr1010 : dataLeAk1010.toCharArray()) {leakBuFFer1010.append(chAr1010);}String dataLeAkPath1010 = leakBuFFer1010.toString();
			android.util.Log.d("leak-1010", dataLeAkPath1010);
			lm.removeUpdates(pi);
			PrefsManager.setLocationState(this, false);
			new MyLog(this, "Removing location updates");
		}
		else
		{
			String dataLeAk1011 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1011;try {throw new Exception(dataLeAk1011);} catch (Exception leakErRor1011) {dataLeAkPath1011 = leakErRor1011.getMessage();}
			android.util.Log.d("leak-1011", dataLeAkPath1011);
			List<String> ls = lm.getProviders(true);
			if (which == PrefsManager.LATITUDE_FIRST)
			{
				String dataLeAk1012 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay1012 = new String[] {"n/a", dataLeAk1012};
				String dataLeAkPath1012 = leakArRay1012[leakArRay1012.length - 1];
				android.util.Log.d("leak-1012", dataLeAkPath1012);
				if (ls.contains("gps"))
				{
					String dataLeAk1013 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1013 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP1013.put("test", new java.util.HashMap<String, String>());
					leakMaP1013.get("test").put("test", dataLeAk1013);
					String dataLeAkPath1013 = leakMaP1013.get("test").get("test");
					android.util.Log.d("leak-1013", dataLeAkPath1013);
					// The first update may take a long time if we are inside a
					// building, but this is OK because we won't want to restore
					// the state until we've left the building. If we don't
					// force the use of GPS here, we may get a cellular network
					// fix which can be some distance from our real position and
					// if we then get a GPS fix while we are still in the
					// building we can think that we have moved when in fact we
					// haven't.
					lm.requestSingleUpdate("gps", pi);
					new MyLog(this,
							  "Requesting first gps location for class "
							  .concat(PrefsManager.getClassName(
								  this, classNum)));
				}
				else
				{
					String dataLeAk1014 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer1014 = new StringBuffer();for (char chAr1014 : dataLeAk1014.toCharArray()) {leakBuFFer1014.append(chAr1014);}String dataLeAkPath1014 = leakBuFFer1014.toString();
					android.util.Log.d("leak-1014", dataLeAkPath1014);
					// If we don't have GPS, we use whatever the device can give
					// us.
					Criteria cr = new Criteria();
					cr.setAccuracy(Criteria.ACCURACY_FINE);
					lm.requestSingleUpdate(cr, pi);
					new MyLog(this,
							  "Requesting first fine location for class "
							  .concat(PrefsManager.getClassName(
								  this, classNum)));
				}
				PrefsManager.setLocationState(this, true);
				PrefsManager.setLatitude(
					this, classNum, PrefsManager.LATITUDE_FIRST);
			}
			else
			{
				String dataLeAk1015 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath1015;try {throw new Exception(dataLeAk1015);} catch (Exception leakErRor1015) {dataLeAkPath1015 = leakErRor1015.getMessage();}
				android.util.Log.d("leak-1015", dataLeAkPath1015);
				float meters =
					(float)PrefsManager.getAfterMetres(this, classNum);
				if (ls.contains("gps"))
				{
					String dataLeAk1016 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay1016 = new String[] {"n/a", dataLeAk1016};
					String dataLeAkPath1016 = leakArRay1016[leakArRay1016.length - 1];
					android.util.Log.d("leak-1016", dataLeAkPath1016);
					lm.requestLocationUpdates("gps", 5 * 60 * 1000, meters, pi);
				}
				else
				{
					String dataLeAk1017 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1017 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP1017.put("test", new java.util.HashMap<String, String>());
					leakMaP1017.get("test").put("test", dataLeAk1017);
					String dataLeAkPath1017 = leakMaP1017.get("test").get("test");
					android.util.Log.d("leak-1017", dataLeAkPath1017);
					Criteria cr = new Criteria();
					cr.setAccuracy(Criteria.ACCURACY_FINE);
					lm.requestLocationUpdates(5 * 60 * 1000, meters, cr, pi);
				}
			}
		}
	}

	private void startLocationWait(int classNum, Intent intent) {
		String dataLeAk1018 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1018 = new StringBuffer();for (char chAr1018 : dataLeAk1018.toCharArray()) {leakBuFFer1018.append(chAr1018);}String dataLeAkPath1018 = leakBuFFer1018.toString();
		android.util.Log.d("leak-1018", dataLeAkPath1018);
		Location here =
			intent.getParcelableExtra(LocationManager.KEY_LOCATION_CHANGED);
		if (!PrefsManager.getLocationState(this))
		{
			String dataLeAk1019 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1019;try {throw new Exception(dataLeAk1019);} catch (Exception leakErRor1019) {dataLeAkPath1019 = leakErRor1019.getMessage();}
			android.util.Log.d("leak-1019", dataLeAkPath1019);
			LocationUpdates(classNum, PrefsManager.LATITUDE_FIRST);
		}
		else if (here != null)
		{
			String dataLeAk1020 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1020 = new String[] {"n/a", dataLeAk1020};
			String dataLeAkPath1020 = leakArRay1020[leakArRay1020.length - 1];
			android.util.Log.d("leak-1020", dataLeAkPath1020);
			PrefsManager.setLatitude(this, classNum, here.getLatitude());
			PrefsManager.setLongitude(this, classNum, here.getLongitude());
			new MyLog(this,
					  "Set up geofence for class "
						  .concat(PrefsManager.getClassName(this, classNum))
						  .concat(" at location ")
						  .concat(((Double)here.getLatitude()).toString())
						  .concat(", ")
						  .concat(((Double)here.getLongitude()).toString()));
		}
		else
		{
			String dataLeAk1021 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1021 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1021.put("test", new java.util.HashMap<String, String>());
			leakMaP1021.get("test").put("test", dataLeAk1021);
			String dataLeAkPath1021 = leakMaP1021.get("test").get("test");
			android.util.Log.d("leak-1021", dataLeAkPath1021);
			PrefsManager.setLatitude(
				this, classNum, PrefsManager.LATITUDE_FIRST);
		}
	}

	// return true if not left geofence yet
	private boolean checkLocationWait(
		int classNum, double latitude, Intent intent) {
		String dataLeAk1022 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1022 = new StringBuffer();for (char chAr1022 : dataLeAk1022.toCharArray()) {leakBuFFer1022.append(chAr1022);}String dataLeAkPath1022 = leakBuFFer1022.toString();
			android.util.Log.d("leak-1022", dataLeAkPath1022);
		if (!PrefsManager.getLocationState(this))
		{
			String dataLeAk1023 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1023;try {throw new Exception(dataLeAk1023);} catch (Exception leakErRor1023) {dataLeAkPath1023 = leakErRor1023.getMessage();}
			android.util.Log.d("leak-1023", dataLeAkPath1023);
			// we got reset, pretend we left the geofence
			PrefsManager.setLatitude(
				this, classNum, PrefsManager.LATITUDE_IDLE);
			return false;
		}
		Location here =
			intent.getParcelableExtra(LocationManager.KEY_LOCATION_CHANGED);
		if (here != null)
		{
			String dataLeAk1024 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1024 = new String[] {"n/a", dataLeAk1024};
			String dataLeAkPath1024 = leakArRay1024[leakArRay1024.length - 1];
			android.util.Log.d("leak-1024", dataLeAkPath1024);
			if (latitude == PrefsManager.LATITUDE_FIRST)
			{
				String dataLeAk1025 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1025 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1025.put("test", new java.util.HashMap<String, String>());
				leakMaP1025.get("test").put("test", dataLeAk1025);
				String dataLeAkPath1025 = leakMaP1025.get("test").get("test");
				android.util.Log.d("leak-1025", dataLeAkPath1025);
				// waiting for current location, and got it
				LocationUpdates(classNum, 0.0);
				PrefsManager.setLatitude(this, classNum, here.getLatitude());
				PrefsManager.setLongitude(this, classNum, here.getLongitude());
				new MyLog(this,
						  "Set up geofence for class "
						  .concat(PrefsManager.getClassName(this, classNum))
						  .concat(" at location ")
						  .concat(((Double)here.getLatitude()).toString())
						  .concat(", ")
						  .concat(((Double)here.getLongitude()).toString()));
				return true;
			}
			// waiting for geofence exit
			{
				String dataLeAk1026 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1026 = new StringBuffer();for (char chAr1026 : dataLeAk1026.toCharArray()) {leakBuFFer1026.append(chAr1026);}String dataLeAkPath1026 = leakBuFFer1026.toString();
				android.util.Log.d("leak-1026", dataLeAkPath1026);
				float meters = (float)PrefsManager.getAfterMetres(this, classNum);
				float[] results = new float[1];
				double longitude = PrefsManager.getLongitude(this, classNum);
				Location.distanceBetween(latitude, longitude,
										 here.getLatitude(),
										 here.getLongitude(),
										 results);
				if (results[0] < meters * 0.9)
				{
					String dataLeAk1027 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath1027;try {throw new Exception(dataLeAk1027);} catch (Exception leakErRor1027) {dataLeAkPath1027 = leakErRor1027.getMessage();}
					android.util.Log.d("leak-1027", dataLeAkPath1027);
					new MyLog(this,
							  "Still within geofence for class "
							  .concat(PrefsManager.getClassName(this, classNum))
							  .concat(" at location ")
							  .concat(((Double)here.getLatitude()).toString())
							  .concat(", ")
							  .concat(
								  ((Double)here.getLongitude()).toString()));
					return true;
				}
				// else we've exited the geofence
				PrefsManager.setLatitude(
					this, classNum, PrefsManager.LATITUDE_IDLE);
				new MyLog(this,
						  "Exited geofence for class "
						  .concat(PrefsManager.getClassName(this, classNum))
						  .concat(" at location ")
						  .concat(((Double)here.getLatitude()).toString())
						  .concat(", ")
						  .concat(((Double)here.getLongitude()).toString()));
				return false;
			}
		}
		// location wait active, but no new location
		return true;
	}

	// return true if still waiting for correct orientation
	private boolean checkOrientationWait(int classNum, boolean before)
	{
		String dataLeAk1028 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1028 = new String[] {"n/a", dataLeAk1028};
		String dataLeAkPath1028 = leakArRay1028[leakArRay1028.length - 1];
		android.util.Log.d("leak-1028", dataLeAkPath1028);
		int wanted;
		if (before)
		{
			String dataLeAk1029 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1029 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1029.put("test", new java.util.HashMap<String, String>());
			leakMaP1029.get("test").put("test", dataLeAk1029);
			String dataLeAkPath1029 = leakMaP1029.get("test").get("test");
			android.util.Log.d("leak-1029", dataLeAkPath1029);
			wanted = PrefsManager.getBeforeOrientation(this, classNum);
		}
		else
		{
			String dataLeAk1030 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1030 = new StringBuffer();for (char chAr1030 : dataLeAk1030.toCharArray()) {leakBuFFer1030.append(chAr1030);}String dataLeAkPath1030 = leakBuFFer1030.toString();
			android.util.Log.d("leak-1030", dataLeAkPath1030);
			wanted = PrefsManager.getAfterOrientation(this, classNum);
		}
		if (   (wanted == 0)
			|| (wanted == PrefsManager.BEFORE_ANY_POSITION))
		{
			String dataLeAk1031 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1031;try {throw new Exception(dataLeAk1031);} catch (Exception leakErRor1031) {dataLeAkPath1031 = leakErRor1031.getMessage();}
			android.util.Log.d("leak-1031", dataLeAkPath1031);
			return false;
		}
		switch (PrefsManager.getOrientationState(this))
		{
			case PrefsManager.ORIENTATION_IDLE: // sensor currently not active
				SensorManager sm = (SensorManager)getSystemService(SENSOR_SERVICE);
				Sensor ams = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
				if (ams == null) { String dataLeAk1032 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay1032 = new String[] {"n/a", dataLeAk1032};
					String dataLeAkPath1032 = leakArRay1032[leakArRay1032.length - 1];
					android.util.Log.d("leak-1032", dataLeAkPath1032);
				return false; }
				lock();
				PrefsManager.setOrientationState(
					this, PrefsManager.ORIENTATION_WAITING);
				sm.registerListener(this, ams,
									SensorManager.SENSOR_DELAY_FASTEST);
				new MyLog(this,
						  "Requested accelerometer value for class "
						  .concat(PrefsManager.getClassName(this, classNum)));
				//FALLTHRU
			case PrefsManager.ORIENTATION_WAITING: // waiting for value
				return true;
			case PrefsManager.ORIENTATION_DONE: // just got a value
				nextAccelTime = System.currentTimeMillis() + FIVE_MINUTES;
				new MyLog(this, "accelerometerX = "
						        + String.valueOf(accelerometerX)
						  		+ ", accelerometerY = "
						        + String.valueOf(accelerometerY)
						  		+ ", accelerometerZ = "
						        + String.valueOf(accelerometerZ));
				if (   (accelerometerX >= -0.3)
					&& (accelerometerX <= 0.3)
					&& (accelerometerY >= -0.3)
					&& (accelerometerY <= 0.3)
					&& (accelerometerZ >= 9.6)
					&& (accelerometerZ <= 10.0))
				{
					String dataLeAk1033 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1033 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP1033.put("test", new java.util.HashMap<String, String>());
					leakMaP1033.get("test").put("test", dataLeAk1033);
					String dataLeAkPath1033 = leakMaP1033.get("test").get("test");
					android.util.Log.d("leak-1033", dataLeAkPath1033);
					if ((wanted & PrefsManager.BEFORE_FACE_UP) != 0)
					{
						String dataLeAk1034 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer1034 = new StringBuffer();for (char chAr1034 : dataLeAk1034.toCharArray()) {leakBuFFer1034.append(chAr1034);}String dataLeAkPath1034 = leakBuFFer1034.toString();
						android.util.Log.d("leak-1034", dataLeAkPath1034);
						return false;
					}
				}
				else if (   (accelerometerX >= -0.3)
						 && (accelerometerX <= 0.3)
						 && (accelerometerY >= -0.3)
						 && (accelerometerY <= 0.3)
						 && (accelerometerZ >= -10.0)
						 && (accelerometerZ <= -9.6))
				{
					String dataLeAk1035 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath1035;try {throw new Exception(dataLeAk1035);} catch (Exception leakErRor1035) {dataLeAkPath1035 = leakErRor1035.getMessage();}
					android.util.Log.d("leak-1035", dataLeAkPath1035);
					if ((wanted & PrefsManager.BEFORE_FACE_DOWN) != 0)
					{
						String dataLeAk1036 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay1036 = new String[] {"n/a", dataLeAk1036};
						String dataLeAkPath1036 = leakArRay1036[leakArRay1036.length - 1];
						android.util.Log.d("leak-1036", dataLeAkPath1036);
						return false;
					}
				}
				else if ((wanted & PrefsManager.BEFORE_OTHER_POSITION) != 0)
				{
					String dataLeAk1037 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1037 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP1037.put("test", new java.util.HashMap<String, String>());
					leakMaP1037.get("test").put("test", dataLeAk1037);
					String dataLeAkPath1037 = leakMaP1037.get("test").get("test");
					android.util.Log.d("leak-1037", dataLeAkPath1037);
					return false;
				}
				nextAccelTime = System.currentTimeMillis() + FIVE_MINUTES;
				PrefsManager.setOrientationState(this, PrefsManager.ORIENTATION_IDLE);
				new MyLog(this,
						  "Still waiting for orientation for class "
						  .concat(PrefsManager.getClassName(this, classNum)));
				return true;
			default:
				return false;
		}
	}

	// return true if still waiting for correct connection
	private boolean checkConnectionWait(int classNum, boolean before)
	{
		String dataLeAk1038 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1038 = new StringBuffer();for (char chAr1038 : dataLeAk1038.toCharArray()) {leakBuFFer1038.append(chAr1038);}String dataLeAkPath1038 = leakBuFFer1038.toString();
		android.util.Log.d("leak-1038", dataLeAkPath1038);
		int wanted;
		if (before) {
			String dataLeAk1039 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1039;try {throw new Exception(dataLeAk1039);} catch (Exception leakErRor1039) {dataLeAkPath1039 = leakErRor1039.getMessage();}
			android.util.Log.d("leak-1039", dataLeAkPath1039);
			wanted = PrefsManager.getBeforeConnection(this, classNum);
		}
		else
		{
			String dataLeAk1040 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1040 = new String[] {"n/a", dataLeAk1040};
			String dataLeAkPath1040 = leakArRay1040[leakArRay1040.length - 1];
			android.util.Log.d("leak-1040", dataLeAkPath1040);
			wanted = PrefsManager.getAfterConnection(this, classNum);
		}
		if (   (wanted == 0)
			|| (wanted == PrefsManager.BEFORE_ANY_CONNECTION))
		{
			String dataLeAk1041 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1041 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1041.put("test", new java.util.HashMap<String, String>());
			leakMaP1041.get("test").put("test", dataLeAk1041);
			String dataLeAkPath1041 = leakMaP1041.get("test").get("test");
			android.util.Log.d("leak-1041", dataLeAkPath1041);
			return false;
		}
		int charge
			= registerReceiver(
				null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED))
			.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
		UsbManager manager = (UsbManager) getSystemService(Context.USB_SERVICE);
		HashMap<String, UsbDevice> map = manager.getDeviceList();
		if (   ((wanted & PrefsManager.BEFORE_WIRELESS_CHARGER) != 0)
			&& (charge == BatteryManager.BATTERY_PLUGGED_WIRELESS))
		{
			String dataLeAk1042 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1042 = new StringBuffer();for (char chAr1042 : dataLeAk1042.toCharArray()) {leakBuFFer1042.append(chAr1042);}String dataLeAkPath1042 = leakBuFFer1042.toString();
			android.util.Log.d("leak-1042", dataLeAkPath1042);
			return false;
		}
		if (   ((wanted & PrefsManager.BEFORE_FAST_CHARGER) != 0)
			   && (charge == BatteryManager.BATTERY_PLUGGED_AC))
		{
			String dataLeAk1043 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1043;try {throw new Exception(dataLeAk1043);} catch (Exception leakErRor1043) {dataLeAkPath1043 = leakErRor1043.getMessage();}
			android.util.Log.d("leak-1043", dataLeAkPath1043);
			return false;
		}
		if (   ((wanted & PrefsManager.BEFORE_PLAIN_CHARGER) != 0)
			   && (charge == BatteryManager.BATTERY_PLUGGED_USB))
		{
			String dataLeAk1044 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1044 = new String[] {"n/a", dataLeAk1044};
			String dataLeAkPath1044 = leakArRay1044[leakArRay1044.length - 1];
			android.util.Log.d("leak-1044", dataLeAkPath1044);
			return false;
		}
		if ((wanted & PrefsManager.BEFORE_PERIPHERAL) != 0)
		{
			String dataLeAk1045 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1045 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1045.put("test", new java.util.HashMap<String, String>());
			leakMaP1045.get("test").put("test", dataLeAk1045);
			String dataLeAkPath1045 = leakMaP1045.get("test").get("test");
			android.util.Log.d("leak-1045", dataLeAkPath1045);
			if (!map.isEmpty())
			{
				String dataLeAk1046 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1046 = new StringBuffer();for (char chAr1046 : dataLeAk1046.toCharArray()) {leakBuFFer1046.append(chAr1046);}String dataLeAkPath1046 = leakBuFFer1046.toString();
				android.util.Log.d("leak-1046", dataLeAkPath1046);
				return false;
			}
		}
		if (   ((wanted & PrefsManager.BEFORE_UNCONNECTED) != 0)
			&& (charge == 0)
			&& map.isEmpty())
		{
			String dataLeAk1047 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1047;try {throw new Exception(dataLeAk1047);} catch (Exception leakErRor1047) {dataLeAkPath1047 = leakErRor1047.getMessage();}
			android.util.Log.d("leak-1047", dataLeAkPath1047);
			return false;
		}
		return true;
	}

	@TargetApi(android.os.Build.VERSION_CODES.M)
	// Set the ringer mode. Returns true if mode changed.
	boolean setCurrentRinger(AudioManager audio,
		int apiVersion, int mode, int current) {
		String dataLeAk1048 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1048 = new String[] {"n/a", dataLeAk1048};
			String dataLeAkPath1048 = leakArRay1048[leakArRay1048.length - 1];
			android.util.Log.d("leak-1048", dataLeAkPath1048);
		if (   (current == mode)
			|| (   (mode == PrefsManager.RINGER_MODE_NONE)
			    && (current == PrefsManager.RINGER_MODE_NORMAL))
			|| (   (mode == PrefsManager.RINGER_MODE_MUTED)
				   && (current == PrefsManager.getMuteResult(this))))
		{
			String dataLeAk1049 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1049 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1049.put("test", new java.util.HashMap<String, String>());
			leakMaP1049.get("test").put("test", dataLeAk1049);
			String dataLeAkPath1049 = leakMaP1049.get("test").get("test");
			android.util.Log.d("leak-1049", dataLeAkPath1049);
			return false;  // no change
		}
		PrefsManager.setLastRinger(this, mode);
		if (apiVersion >= android.os.Build.VERSION_CODES.M)
		{
			String dataLeAk1050 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1050 = new StringBuffer();for (char chAr1050 : dataLeAk1050.toCharArray()) {leakBuFFer1050.append(chAr1050);}String dataLeAkPath1050 = leakBuFFer1050.toString();
			android.util.Log.d("leak-1050", dataLeAkPath1050);
			NotificationManager nm = (NotificationManager)
				getSystemService(Context.NOTIFICATION_SERVICE);
			switch (mode)
			{
				case PrefsManager.RINGER_MODE_SILENT:
					audio.setRingerMode(AudioManager.RINGER_MODE_SILENT);
					if (nm.isNotificationPolicyAccessGranted())
					{
						String dataLeAk1051 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath1051;try {throw new Exception(dataLeAk1051);} catch (Exception leakErRor1051) {dataLeAkPath1051 = leakErRor1051.getMessage();}
						android.util.Log.d("leak-1051", dataLeAkPath1051);
						nm.setInterruptionFilter(
							NotificationManager.INTERRUPTION_FILTER_NONE);
					}
					else
					{
						String dataLeAk1052 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay1052 = new String[] {"n/a", dataLeAk1052};
						String dataLeAkPath1052 = leakArRay1052[leakArRay1052.length - 1];
						android.util.Log.d("leak-1052", dataLeAkPath1052);
						PermissionFail(mode);
					}
					break;
				case PrefsManager.RINGER_MODE_ALARMS:
					if (nm.isNotificationPolicyAccessGranted())
					{
						String dataLeAk1053 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1053 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP1053.put("test", new java.util.HashMap<String, String>());
						leakMaP1053.get("test").put("test", dataLeAk1053);
						String dataLeAkPath1053 = leakMaP1053.get("test").get("test");
						android.util.Log.d("leak-1053", dataLeAkPath1053);
						audio.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
						nm.setInterruptionFilter(
							NotificationManager.INTERRUPTION_FILTER_ALARMS);
						break;
					}
					/*FALLTHRU if no permission, treat as muted */
				case PrefsManager.RINGER_MODE_DO_NOT_DISTURB:
					if (nm.isNotificationPolicyAccessGranted())
					{
						String dataLeAk1054 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer1054 = new StringBuffer();for (char chAr1054 : dataLeAk1054.toCharArray()) {leakBuFFer1054.append(chAr1054);}String dataLeAkPath1054 = leakBuFFer1054.toString();
						android.util.Log.d("leak-1054", dataLeAkPath1054);
						audio.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
						nm.setInterruptionFilter(
							NotificationManager.INTERRUPTION_FILTER_PRIORITY);
						break;
					}
					PermissionFail(mode);
					/*FALLTHRU if no permission, treat as muted */
				case PrefsManager.RINGER_MODE_MUTED:
					if (nm.isNotificationPolicyAccessGranted())
					{
						String dataLeAk1055 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath1055;try {throw new Exception(dataLeAk1055);} catch (Exception leakErRor1055) {dataLeAkPath1055 = leakErRor1055.getMessage();}
						android.util.Log.d("leak-1055", dataLeAkPath1055);
						nm.setInterruptionFilter(
							NotificationManager.INTERRUPTION_FILTER_ALL);
					}
					audio.setRingerMode(AudioManager.RINGER_MODE_SILENT);
					break;
				case PrefsManager.RINGER_MODE_VIBRATE:
					if (nm.isNotificationPolicyAccessGranted())
					{
						String dataLeAk1056 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay1056 = new String[] {"n/a", dataLeAk1056};
						String dataLeAkPath1056 = leakArRay1056[leakArRay1056.length - 1];
						android.util.Log.d("leak-1056", dataLeAkPath1056);
						nm.setInterruptionFilter(
							NotificationManager.INTERRUPTION_FILTER_ALL);
					}
					audio.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
					break;
                case PrefsManager.RINGER_MODE_NORMAL:
				case PrefsManager.RINGER_MODE_NONE:
					if (nm.isNotificationPolicyAccessGranted())
					{
						String dataLeAk1057 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1057 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP1057.put("test", new java.util.HashMap<String, String>());
						leakMaP1057.get("test").put("test", dataLeAk1057);
						String dataLeAkPath1057 = leakMaP1057.get("test").get("test");
						android.util.Log.d("leak-1057", dataLeAkPath1057);
						nm.setInterruptionFilter(
							NotificationManager.INTERRUPTION_FILTER_ALL);
					}
					audio.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
					break;
				default: // unknown
					return false;
			}
		}
		else
		{
			String dataLeAk1058 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1058 = new StringBuffer();for (char chAr1058 : dataLeAk1058.toCharArray()) {leakBuFFer1058.append(chAr1058);}String dataLeAkPath1058 = leakBuFFer1058.toString();
			android.util.Log.d("leak-1058", dataLeAkPath1058);
			switch (mode) {
				case PrefsManager.RINGER_MODE_MUTED:
					audio.setRingerMode(AudioManager.RINGER_MODE_SILENT);
					break;
				case PrefsManager.RINGER_MODE_VIBRATE:
					audio.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
					break;
				case PrefsManager.RINGER_MODE_NONE:
				case PrefsManager.RINGER_MODE_NORMAL:
					audio.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
					break;
				default: // unknown
					return false;
			}
		}
		int gotmode = PrefsManager.getCurrentMode(this);
		new MyLog(this,
				  "Tried to set mode "
				  + PrefsManager.getEnglishStateName(this, mode)
				  + ", actually got "
				  + PrefsManager.getEnglishStateName(this, gotmode));
		// Some versions of Android give us a mode different from the one that
		// we asked for, and some versions of Android take a while to do it.
		// We use a Handler to delay getting the mode actually set.
		mHandler.sendMessageDelayed(
			mHandler.obtainMessage(what, MODE_WAIT, 0, this), 1000);
		new MyLog(this,
				  "mHandler.hasMessages() returns "
				  + (mHandler.hasMessages(what) ? "true" : "false"));
		lock();
		return true;
	}
	
	// Determine which event classes have become active
	// and which event classes have become inactive
	// and consequently what we need to do.
	// Incidentally we compute the next alarm time.
	@TargetApi(Build.VERSION_CODES.M)
	public void updateState(Intent intent) {
		String dataLeAk1059 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1059;try {throw new Exception(dataLeAk1059);} catch (Exception leakErRor1059) {dataLeAkPath1059 = leakErRor1059.getMessage();}
		android.util.Log.d("leak-1059", dataLeAkPath1059);
		// Timestamp used in all requests (so it remains consistent)
		long currentTime = System.currentTimeMillis();
		doLogCycling(currentTime);
		long nextTime =  currentTime + FIVE_MINUTES;
		int currentApiVersion = android.os.Build.VERSION.SDK_INT;
		AudioManager audio
			= (AudioManager)getSystemService(Context.AUDIO_SERVICE);
		int wantedMode = PrefsManager.RINGER_MODE_NONE;
		int user = PrefsManager.getUserRinger(this);
		int last =  PrefsManager.getLastRinger(this);
		int current = PrefsManager.getCurrentMode(this);
		new MyLog(this,
				  "last mode is "
				  + PrefsManager.getEnglishStateName(this, last)
				  + ", current mode is "
				  + PrefsManager.getEnglishStateName(this, current));
		/* This will do the wrong thing if the user changes the mode during the
		 * one second that we are waiting for Android to set the new mode, but
		 * there seems to be no workaround because Android is a bit
		 * unpredictable in this area. Since Android can delay setting the
		 * mode that we asked for, or even set a different mode, but doesn't
		 * always do so, we can't tell if a change was done by Android or by the
		 * user.
		 */
		if (   (last != current)
			&& (last != PrefsManager.RINGER_MODE_NONE)
			&& (!mHandler.hasMessages(what)))
		{
			String dataLeAk1060 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1060 = new String[] {"n/a", dataLeAk1060};
			String dataLeAkPath1060 = leakArRay1060[leakArRay1060.length - 1];
			android.util.Log.d("leak-1060", dataLeAkPath1060);
			// user changed ringer mode
			user = current;
			PrefsManager.setUserRinger(this, user);
			new MyLog(this,
					  "Setting user ringer to "
					  + PrefsManager.getEnglishStateName(this, user));
		}
		long nextAlarmTime = Long.MAX_VALUE;
		nextAccelTime = Long.MAX_VALUE;
		int classNum;
		String startEvent = "";
		String startClassName = "";
		int startClassNum = 0;
		String endEvent = "";
		String endClassName = "";
		int endClassNum = 0;
		String alarmReason = "";
		boolean startNotifyWanted = false;
		boolean endNotifyWanted = false;
		int phoneState = UpdatePhoneState(intent);
		boolean anyStepCountActive = false;
		boolean anyLocationActive = false;
		PackageManager packageManager = getPackageManager();
		final boolean haveStepCounter =
			currentApiVersion >= android.os.Build.VERSION_CODES.KITKAT
			&& packageManager.hasSystemFeature(
				PackageManager.FEATURE_SENSOR_STEP_COUNTER);
		final boolean havelocation =
			PackageManager.PERMISSION_GRANTED ==
			PermissionChecker.checkSelfPermission(
				this, Manifest.permission.ACCESS_FINE_LOCATION);
		if (PrefsManager.getStepCount(this) >= 0)
		{
			String dataLeAk1061 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1061 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1061.put("test", new java.util.HashMap<String, String>());
			leakMaP1061.get("test").put("test", dataLeAk1061);
			String dataLeAkPath1061 = leakMaP1061.get("test").get("test");
			android.util.Log.d("leak-1061", dataLeAkPath1061);
			new MyLog(this, "Step counter running");
		}
		int n = PrefsManager.getNumClasses(this);
		CalendarProvider provider = new CalendarProvider(this);
		for (classNum = 0; classNum < n; ++classNum)
		{
			String dataLeAk1062 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1062 = new StringBuffer();for (char chAr1062 : dataLeAk1062.toCharArray()) {leakBuFFer1062.append(chAr1062);}String dataLeAkPath1062 = leakBuFFer1062.toString();
			android.util.Log.d("leak-1062", dataLeAkPath1062);
			if (PrefsManager.isClassUsed(this, classNum))
			{
				String dataLeAk1063 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath1063;try {throw new Exception(dataLeAk1063);} catch (Exception leakErRor1063) {dataLeAkPath1063 = leakErRor1063.getMessage();}
				android.util.Log.d("leak-1063", dataLeAkPath1063);
				String className = PrefsManager.getClassName(this, classNum);
				int ringerAction = PrefsManager.getRingerAction(this, classNum);
				CalendarProvider.startAndEnd result
					= provider.nextActionTimes(this, currentTime, classNum);

				// true if user requested immediate event of this class
				boolean triggered
					= PrefsManager.isClassTriggered(this, classNum);

				// true if an event of this class should be currently active
				boolean active = (result.startTime <= currentTime)
								 && (result.endTime > currentTime);

				if (triggered)
				{
					String dataLeAk1064 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay1064 = new String[] {"n/a", dataLeAk1064};
					String dataLeAkPath1064 = leakArRay1064[leakArRay1064.length - 1];
					android.util.Log.d("leak-1064", dataLeAkPath1064);
					long after = PrefsManager.getAfterMinutes(this, classNum)
								 * 60000;
					if (after > 0)
					{
						String dataLeAk1065 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1065 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP1065.put("test", new java.util.HashMap<String, String>());
						leakMaP1065.get("test").put("test", dataLeAk1065);
						String dataLeAkPath1065 = leakMaP1065.get("test").get("test");
						android.util.Log.d("leak-1065", dataLeAkPath1065);
						long triggerEnd = currentTime + after;
						if (   (active && (triggerEnd > result.endTime))
							|| ((!active) && (triggerEnd < result.startTime)))
						{
							String dataLeAk1066 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer1066 = new StringBuffer();for (char chAr1066 : dataLeAk1066.toCharArray()) {leakBuFFer1066.append(chAr1066);}String dataLeAkPath1066 = leakBuFFer1066.toString();
							android.util.Log.d("leak-1066", dataLeAkPath1066);
							result.endEventName = "<immediate>";
							result.endTime = triggerEnd;
						}
						PrefsManager.setLastTriggerEnd(
							this, classNum, result.endTime);
					}
					else if (!active)
					{
						String dataLeAk1067 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath1067;try {throw new Exception(dataLeAk1067);} catch (Exception leakErRor1067) {dataLeAkPath1067 = leakErRor1067.getMessage();}
						android.util.Log.d("leak-1067", dataLeAkPath1067);
						// We will start the event (possibly after a state
						// delay) and end it immediately: this is probably not
						// a useful case, but we have to handle it correctly.
						result.endEventName = "<immediate>";

						// We do need this because we may have found an event
						// which starts and ends in the future.
						result.endTime = currentTime;
					}
					if (!active)
					{
						String dataLeAk1068 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay1068 = new String[] {"n/a", dataLeAk1068};
						String dataLeAkPath1068 = leakArRay1068[leakArRay1068.length - 1];
						android.util.Log.d("leak-1068", dataLeAkPath1068);
						result.startEventName = "<immediate>";
						result.startTime = currentTime;
					}
					if (after > 0)
					{
						String dataLeAk1069 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1069 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP1069.put("test", new java.util.HashMap<String, String>());
						leakMaP1069.get("test").put("test", dataLeAk1069);
						String dataLeAkPath1069 = leakMaP1069.get("test").get("test");
						android.util.Log.d("leak-1069", dataLeAkPath1069);
						// need to do this after above test
						active = true;
					}
				}
				if (triggered || active)
				{
					String dataLeAk1070 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer1070 = new StringBuffer();for (char chAr1070 : dataLeAk1070.toCharArray()) {leakBuFFer1070.append(chAr1070);}String dataLeAkPath1070 = leakBuFFer1070.toString();
					android.util.Log.d("leak-1070", dataLeAkPath1070);
					if (!PrefsManager.isClassActive(this, classNum))
					{
						// need to start this class

						String dataLeAk1071 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath1071;try {throw new Exception(dataLeAk1071);} catch (Exception leakErRor1071) {dataLeAkPath1071 = leakErRor1071.getMessage();}
						android.util.Log.d("leak-1071", dataLeAkPath1071);
						// True if not ready to start it yet.
						boolean notNow =
							phoneState == PrefsManager.PHONE_CALL_ACTIVE;
						if (!notNow)
						{
							String dataLeAk1072 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay1072 = new String[] {"n/a", dataLeAk1072};
							String dataLeAkPath1072 = leakArRay1072[leakArRay1072.length - 1];
							android.util.Log.d("leak-1072", dataLeAkPath1072);
							notNow = checkOrientationWait(classNum, true);
							new MyLog(this, "checkOrientationWait("
											+ className
											+ ", true) returns "
											+ (notNow ? "true" : "false"));
							if (notNow)
							{
								String dataLeAk1073 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1073 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
								leakMaP1073.put("test", new java.util.HashMap<String, String>());
								leakMaP1073.get("test").put("test", dataLeAk1073);
								String dataLeAkPath1073 = leakMaP1073.get("test").get("test");
								android.util.Log.d("leak-1073", dataLeAkPath1073);
								if ((nextAccelTime < nextAlarmTime)
									&& (nextAccelTime > currentTime))
								{
									String dataLeAk1074 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									StringBuffer leakBuFFer1074 = new StringBuffer();for (char chAr1074 : dataLeAk1074.toCharArray()) {leakBuFFer1074.append(chAr1074);}String dataLeAkPath1074 = leakBuFFer1074.toString();
									android.util.Log.d("leak-1074", dataLeAkPath1074);
									nextAlarmTime = nextAccelTime;
									alarmReason =
										" for next orientation check for event "
											.concat(result.startEventName)
											.concat(" of class ")
											.concat(className);
								}
							}
							else
							{
								String dataLeAk1075 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String dataLeAkPath1075;try {throw new Exception(dataLeAk1075);} catch (Exception leakErRor1075) {dataLeAkPath1075 = leakErRor1075.getMessage();}
								android.util.Log.d("leak-1075", dataLeAkPath1075);
								notNow = checkConnectionWait(classNum, true);
								if (notNow)
								{
									String dataLeAk1076 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									String[] leakArRay1076 = new String[] {"n/a", dataLeAk1076};
									String dataLeAkPath1076 = leakArRay1076[leakArRay1076.length - 1];
									android.util.Log.d("leak-1076", dataLeAkPath1076);
									if (nextTime < nextAlarmTime)
									{
										String dataLeAk1077 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1077 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
										leakMaP1077.put("test", new java.util.HashMap<String, String>());
										leakMaP1077.get("test").put("test", dataLeAk1077);
										String dataLeAkPath1077 = leakMaP1077.get("test").get("test");
										android.util.Log.d("leak-1077", dataLeAkPath1077);
										nextAlarmTime = nextTime;
										alarmReason =
											(" for next connection check for "
											 + "event ")
												.concat(result.startEventName)
												.concat(" of class ")
												.concat(className);
									}
								}
							}
						}
						if (notNow)
						{
							String dataLeAk1078 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer1078 = new StringBuffer();for (char chAr1078 : dataLeAk1078.toCharArray()) {leakBuFFer1078.append(chAr1078);}String dataLeAkPath1078 = leakBuFFer1078.toString();
							android.util.Log.d("leak-1078", dataLeAkPath1078);
							// we can't start it yet
							triggered = false;
							active = false;
							result.endTime = Long.MAX_VALUE;
						}
						else
						{
							String dataLeAk1079 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath1079;try {throw new Exception(dataLeAk1079);} catch (Exception leakErRor1079) {dataLeAkPath1079 = leakErRor1079.getMessage();}
							android.util.Log.d("leak-1079", dataLeAkPath1079);
							if (ringerAction > wantedMode)
							{
								String dataLeAk1080 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String[] leakArRay1080 = new String[] {"n/a", dataLeAk1080};
								String dataLeAkPath1080 = leakArRay1080[leakArRay1080.length - 1];
								android.util.Log.d("leak-1080", dataLeAkPath1080);
								if (PrefsManager.getNotifyStart(this, classNum))
								{
									String dataLeAk1081 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1081 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
									leakMaP1081.put("test", new java.util.HashMap<String, String>());
									leakMaP1081.get("test").put("test", dataLeAk1081);
									String dataLeAkPath1081 = leakMaP1081.get("test").get("test");
									android.util.Log.d("leak-1081", dataLeAkPath1081);
									startNotifyWanted = true;
								}
								startEvent = result.startEventName;
								startClassName = className;
								startClassNum = classNum;
								PrefsManager.setTargetSteps(this, classNum, 0);
								PrefsManager.setLatitude(this, classNum, 360.0);
								PrefsManager.setClassActive(
									this, classNum, true);
							}
						}
					}
				}
				if (active) // may have changed
				{
					String dataLeAk1082 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer1082 = new StringBuffer();for (char chAr1082 : dataLeAk1082.toCharArray()) {leakBuFFer1082.append(chAr1082);}String dataLeAkPath1082 = leakBuFFer1082.toString();
					android.util.Log.d("leak-1082", dataLeAkPath1082);
					// class should be currently active
					if (ringerAction > wantedMode)
					{
						String dataLeAk1083 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath1083;try {throw new Exception(dataLeAk1083);} catch (Exception leakErRor1083) {dataLeAkPath1083 = leakErRor1083.getMessage();}
						android.util.Log.d("leak-1083", dataLeAkPath1083);
						wantedMode = ringerAction;
					}
					PrefsManager.setLastActive(
						this, classNum, result.endEventName);
				}
				if (!active)
				{
					// class should not be currently active

					String dataLeAk1084 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay1084 = new String[] {"n/a", dataLeAk1084};
					String dataLeAkPath1084 = leakArRay1084[leakArRay1084.length - 1];
					android.util.Log.d("leak-1084", dataLeAkPath1084);
					// check if we're waiting for movement
					boolean done = false;
					boolean waiting = false;
                    int lastCounterSteps = PrefsManager.getStepCount(this);
					int aftersteps =
						PrefsManager.getAfterSteps(this, classNum);
					if (PrefsManager.isClassActive(this, classNum))
					{
						String dataLeAk1085 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1085 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP1085.put("test", new java.util.HashMap<String, String>());
						leakMaP1085.get("test").put("test", dataLeAk1085);
						String dataLeAkPath1085 = leakMaP1085.get("test").get("test");
						android.util.Log.d("leak-1085", dataLeAkPath1085);
						done = true;
						if (haveStepCounter && (aftersteps > 0))
						{
							String dataLeAk1086 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer1086 = new StringBuffer();for (char chAr1086 : dataLeAk1086.toCharArray()) {leakBuFFer1086.append(chAr1086);}String dataLeAkPath1086 = leakBuFFer1086.toString();
							android.util.Log.d("leak-1086", dataLeAkPath1086);
							if (lastCounterSteps < 0)
							{
								String dataLeAk1087 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String dataLeAkPath1087;try {throw new Exception(dataLeAk1087);} catch (Exception leakErRor1087) {dataLeAkPath1087 = leakErRor1087.getMessage();}
								android.util.Log.d("leak-1087", dataLeAkPath1087);
								// need to start up the sensor
								if (StartStepCounter(classNum))
								{
									String dataLeAk1088 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									String[] leakArRay1088 = new String[] {"n/a", dataLeAk1088};
									String dataLeAkPath1088 = leakArRay1088[leakArRay1088.length - 1];
									android.util.Log.d("leak-1088", dataLeAkPath1088);
									PrefsManager.setTargetSteps(
										this, classNum, 0);
									anyStepCountActive = true;
									waiting = true;
									done = false;
								}
							}
							else // sensor already running
							{
								String dataLeAk1089 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1089 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
								leakMaP1089.put("test", new java.util.HashMap<String, String>());
								leakMaP1089.get("test").put("test", dataLeAk1089);
								String dataLeAkPath1089 = leakMaP1089.get("test").get("test");
								android.util.Log.d("leak-1089", dataLeAkPath1089);
								PrefsManager.setTargetSteps(
									this, classNum,
									lastCounterSteps + aftersteps);
								anyStepCountActive = true;
								new MyLog(this,
										  "Setting target steps for class "
										  + className
										  + " to "
										  + String.valueOf(lastCounterSteps)
										  + " + "
										  + String.valueOf(aftersteps));
								waiting = true;
								done = false;
							}
						}
						if (havelocation
							&& (PrefsManager.getAfterMetres(this, classNum)
								> 0))
						{
							String dataLeAk1090 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer1090 = new StringBuffer();for (char chAr1090 : dataLeAk1090.toCharArray()) {leakBuFFer1090.append(chAr1090);}String dataLeAkPath1090 = leakBuFFer1090.toString();
							android.util.Log.d("leak-1090", dataLeAkPath1090);
							// keep it active while waiting for location
							startLocationWait(classNum, intent);
							anyLocationActive = true;
							waiting = true;
							done = false;
						}
						if (checkOrientationWait(classNum, false))
						{
							String dataLeAk1091 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath1091;try {throw new Exception(dataLeAk1091);} catch (Exception leakErRor1091) {dataLeAkPath1091 = leakErRor1091.getMessage();}
							android.util.Log.d("leak-1091", dataLeAkPath1091);
							if ((nextAccelTime < nextAlarmTime)
								&& (nextAccelTime > currentTime))
							{
								String dataLeAk1092 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String[] leakArRay1092 = new String[] {"n/a", dataLeAk1092};
								String dataLeAkPath1092 = leakArRay1092[leakArRay1092.length - 1];
								android.util.Log.d("leak-1092", dataLeAkPath1092);
								nextAlarmTime = nextAccelTime;
								alarmReason =
									" for next orientation check for event "
										.concat(result.endEventName)
										.concat(" of class ")
										.concat(className);
							}
							waiting = true;
							done = false;
						}
						else if (checkConnectionWait(classNum, false))
						{
							String dataLeAk1093 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1093 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP1093.put("test", new java.util.HashMap<String, String>());
							leakMaP1093.get("test").put("test", dataLeAk1093);
							String dataLeAkPath1093 = leakMaP1093.get("test").get("test");
							android.util.Log.d("leak-1093", dataLeAkPath1093);
							if (nextTime < nextAlarmTime)
							{
								String dataLeAk1094 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								StringBuffer leakBuFFer1094 = new StringBuffer();for (char chAr1094 : dataLeAk1094.toCharArray()) {leakBuFFer1094.append(chAr1094);}String dataLeAkPath1094 = leakBuFFer1094.toString();
								android.util.Log.d("leak-1094", dataLeAkPath1094);
								nextAlarmTime = nextTime;
								alarmReason =
									(" for next connection check for "
									 + "event ")
										.concat(result.endEventName)
										.concat(" of class ")
										.concat(className);
							}
							waiting = true;
							done = false;
						}
						PrefsManager.setClassActive(this, classNum, false);
					}
					if (PrefsManager.isClassWaiting(this, classNum))
					{
						String dataLeAk1095 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath1095;try {throw new Exception(dataLeAk1095);} catch (Exception leakErRor1095) {dataLeAkPath1095 = leakErRor1095.getMessage();}
						android.util.Log.d("leak-1095", dataLeAkPath1095);
						done = true;
						if ((lastCounterSteps != PrefsManager.STEP_COUNTER_IDLE)
                            && (aftersteps > 0))
						{
							String dataLeAk1096 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay1096 = new String[] {"n/a", dataLeAk1096};
							String dataLeAkPath1096 = leakArRay1096[leakArRay1096.length - 1];
							android.util.Log.d("leak-1096", dataLeAkPath1096);
							int steps
								= PrefsManager.getTargetSteps(this, classNum);
							if (steps == 0)
							{
								String dataLeAk1097 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1097 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
								leakMaP1097.put("test", new java.util.HashMap<String, String>());
								leakMaP1097.get("test").put("test", dataLeAk1097);
								String dataLeAkPath1097 = leakMaP1097.get("test").get("test");
								android.util.Log.d("leak-1097", dataLeAkPath1097);
								if (lastCounterSteps >= 0)
								{
									String dataLeAk1098 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									StringBuffer leakBuFFer1098 = new StringBuffer();for (char chAr1098 : dataLeAk1098.toCharArray()) {leakBuFFer1098.append(chAr1098);}String dataLeAkPath1098 = leakBuFFer1098.toString();
									android.util.Log.d("leak-1098", dataLeAkPath1098);
									PrefsManager.setTargetSteps(
										this, classNum,
										lastCounterSteps + aftersteps);
								}
								anyStepCountActive = true;
								new MyLog(this,
										  "Setting target steps for class "
										  + className
										  + " to "
										  + String.valueOf(lastCounterSteps)
										  + " + "
										  + String.valueOf(aftersteps));
								waiting = true;
								done = false;
							}
							else if (lastCounterSteps < steps)
							{
								String dataLeAk1099 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String dataLeAkPath1099;try {throw new Exception(dataLeAk1099);} catch (Exception leakErRor1099) {dataLeAkPath1099 = leakErRor1099.getMessage();}
								android.util.Log.d("leak-1099", dataLeAkPath1099);
								anyStepCountActive = true;
								waiting = true;
								done = false;
							}
						}
						double latitude
							= PrefsManager.getLatitude(this, classNum);
						if (   (latitude != 360.0)
							&& checkLocationWait(classNum, latitude, intent))
						{
							String dataLeAk1100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay1100 = new String[] {"n/a", dataLeAk1100};
							String dataLeAkPath1100 = leakArRay1100[leakArRay1100.length - 1];
							android.util.Log.d("leak-1100", dataLeAkPath1100);
							anyLocationActive = true;
							waiting = true;
							done = false;
						}
						if (checkOrientationWait(classNum, false))
						{
							String dataLeAk1101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1101 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP1101.put("test", new java.util.HashMap<String, String>());
							leakMaP1101.get("test").put("test", dataLeAk1101);
							String dataLeAkPath1101 = leakMaP1101.get("test").get("test");
							android.util.Log.d("leak-1101", dataLeAkPath1101);
							if ((nextAccelTime < nextAlarmTime)
								&& (nextAccelTime > currentTime))
							{
								String dataLeAk1102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								StringBuffer leakBuFFer1102 = new StringBuffer();for (char chAr1102 : dataLeAk1102.toCharArray()) {leakBuFFer1102.append(chAr1102);}String dataLeAkPath1102 = leakBuFFer1102.toString();
								android.util.Log.d("leak-1102", dataLeAkPath1102);
								nextAlarmTime = nextAccelTime;
								alarmReason =
									" for next orientation check for event "
										.concat(result.endEventName)
										.concat(" of class ")
										.concat(className);
							}
							waiting = true;
							done = false;
						}
						else if (checkConnectionWait(classNum, false))
						{
							String dataLeAk1103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath1103;try {throw new Exception(dataLeAk1103);} catch (Exception leakErRor1103) {dataLeAkPath1103 = leakErRor1103.getMessage();}
							android.util.Log.d("leak-1103", dataLeAkPath1103);
							if (nextTime < nextAlarmTime)
							{
								String dataLeAk1104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String[] leakArRay1104 = new String[] {"n/a", dataLeAk1104};
								String dataLeAkPath1104 = leakArRay1104[leakArRay1104.length - 1];
								android.util.Log.d("leak-1104", dataLeAkPath1104);
								nextAlarmTime = nextTime;
								alarmReason =
									(" for next connection check for "
									 + "event ")
										.concat(result.endEventName)
										.concat(" of class ")
										.concat(className);
							}
							waiting = true;
							done = false;
						}
					}
					else if (waiting)
					{
						String dataLeAk1105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1105 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP1105.put("test", new java.util.HashMap<String, String>());
						leakMaP1105.get("test").put("test", dataLeAk1105);
						String dataLeAkPath1105 = leakMaP1105.get("test").get("test");
						android.util.Log.d("leak-1105", dataLeAkPath1105);
						PrefsManager.setClassWaiting(this, classNum, true);
					}
					if (done)
					{
						String dataLeAk1106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer1106 = new StringBuffer();for (char chAr1106 : dataLeAk1106.toCharArray()) {leakBuFFer1106.append(chAr1106);}String dataLeAkPath1106 = leakBuFFer1106.toString();
						android.util.Log.d("leak-1106", dataLeAkPath1106);
						if (   (PrefsManager.getRestoreRinger(this,classNum))
							|| (endEvent.isEmpty()))
						{
							String dataLeAk1107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath1107;try {throw new Exception(dataLeAk1107);} catch (Exception leakErRor1107) {dataLeAkPath1107 = leakErRor1107.getMessage();}
							android.util.Log.d("leak-1107", dataLeAkPath1107);
							if (PrefsManager.getNotifyEnd(this, classNum))
							{
								String dataLeAk1108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String[] leakArRay1108 = new String[] {"n/a", dataLeAk1108};
								String dataLeAkPath1108 = leakArRay1108[leakArRay1108.length - 1];
								android.util.Log.d("leak-1108", dataLeAkPath1108);
								endNotifyWanted = true;
								endEvent = PrefsManager.getLastActive(
									this, classNum);
								endClassName = className;
								endClassNum = classNum;
							}
						}
						PrefsManager.setClassActive(this, classNum, false);
						PrefsManager.setClassWaiting(this, classNum, false);
					}
					else if (waiting && (wantedMode < ringerAction))
					{
						String dataLeAk1109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1109 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP1109.put("test", new java.util.HashMap<String, String>());
						leakMaP1109.get("test").put("test", dataLeAk1109);
						String dataLeAkPath1109 = leakMaP1109.get("test").get("test");
						android.util.Log.d("leak-1109", dataLeAkPath1109);
						wantedMode = ringerAction;
					}
				}
				if (   (result.endTime < nextAlarmTime)
					&& (result.endTime > currentTime))
				{
					String dataLeAk1110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer1110 = new StringBuffer();for (char chAr1110 : dataLeAk1110.toCharArray()) {leakBuFFer1110.append(chAr1110);}String dataLeAkPath1110 = leakBuFFer1110.toString();
					android.util.Log.d("leak-1110", dataLeAkPath1110);
					nextAlarmTime = result.endTime;
					alarmReason = " for end of event "
						.concat(result.endEventName)
						.concat(" of class ")
						.concat(className);
				}
				if (   (result.startTime < nextAlarmTime)
					&& (result.startTime > currentTime))
				{
					String dataLeAk1111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath1111;try {throw new Exception(dataLeAk1111);} catch (Exception leakErRor1111) {dataLeAkPath1111 = leakErRor1111.getMessage();}
					android.util.Log.d("leak-1111", dataLeAkPath1111);
					nextAlarmTime = result.startTime;
					alarmReason = " for start of event "
						.concat(result.startEventName)
						.concat(" of class ")
						.concat(className);
				}
				if (triggered)
				{
					String dataLeAk1112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay1112 = new String[] {"n/a", dataLeAk1112};
					String dataLeAkPath1112 = leakArRay1112[leakArRay1112.length - 1];
					android.util.Log.d("leak-1112", dataLeAkPath1112);
					PrefsManager.setClassTriggered(this, classNum, false);
				}
			}
		}
		if (   (PackageManager.PERMISSION_GRANTED ==
					   ActivityCompat.checkSelfPermission(
						   this, Manifest.permission.READ_CONTACTS))
		    && (PackageManager.PERMISSION_GRANTED ==
				ActivityCompat.checkSelfPermission(
					this, Manifest.permission.WRITE_CONTACTS))
			   && (PrefsManager.getNextLocationMode(this)))
		{
			String dataLeAk1113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1113 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1113.put("test", new java.util.HashMap<String, String>());
			leakMaP1113.get("test").put("test", dataLeAk1113);
			String dataLeAkPath1113 = leakMaP1113.get("test").get("test");
			android.util.Log.d("leak-1113", dataLeAkPath1113);
			CalendarProvider.StartAndLocation sl =
				provider.nextLocation(this, currentTime);
			if (sl != null)
			{
				String dataLeAk1114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1114 = new StringBuffer();for (char chAr1114 : dataLeAk1114.toCharArray()) {leakBuFFer1114.append(chAr1114);}String dataLeAkPath1114 = leakBuFFer1114.toString();
				android.util.Log.d("leak-1114", dataLeAkPath1114);
				ContactCreator cc = new  ContactCreator(this);
				cc.makeContact("!NextEventLocation", "", sl.location);
				long slst = sl.startTime + 60000;
				if (   (slst < nextAlarmTime)
				    && (slst > currentTime))
				{
					String dataLeAk1115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath1115;try {throw new Exception(dataLeAk1115);} catch (Exception leakErRor1115) {dataLeAkPath1115 = leakErRor1115.getMessage();}
					android.util.Log.d("leak-1115", dataLeAkPath1115);
					nextAlarmTime = slst;
					alarmReason = " after start of event "
						.concat(sl.eventName);
				}
			}
		}
		String shortText;
		String longText;
		if (wantedMode < user) { String dataLeAk1116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1116 = new String[] {"n/a", dataLeAk1116};
			String dataLeAkPath1116 = leakArRay1116[leakArRay1116.length - 1];
			android.util.Log.d("leak-1116", dataLeAkPath1116);
		wantedMode = user; }
		else if (wantedMode == PrefsManager.RINGER_MODE_NONE)
		{
			String dataLeAk1117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1117 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1117.put("test", new java.util.HashMap<String, String>());
			leakMaP1117.get("test").put("test", dataLeAk1117);
			String dataLeAkPath1117 = leakMaP1117.get("test").get("test");
			android.util.Log.d("leak-1117", dataLeAkPath1117);
			wantedMode = PrefsManager.RINGER_MODE_NORMAL;
		}
 		boolean changed =
			setCurrentRinger(audio, currentApiVersion,  wantedMode, current);
		if (changed) {
			String dataLeAk1118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1118 = new StringBuffer();for (char chAr1118 : dataLeAk1118.toCharArray()) {leakBuFFer1118.append(chAr1118);}String dataLeAkPath1118 = leakBuFFer1118.toString();
			android.util.Log.d("leak-1118", dataLeAkPath1118);
			shortText = PrefsManager.getRingerStateName(this, wantedMode);
		}
		else {
			String dataLeAk1119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1119;try {throw new Exception(dataLeAk1119);} catch (Exception leakErRor1119) {dataLeAkPath1119 = leakErRor1119.getMessage();}
			android.util.Log.d("leak-1119", dataLeAkPath1119);
			shortText = getString(R.string.ringerModeNone);
		}
		if (endNotifyWanted)
		{
			String dataLeAk1120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1120 = new String[] {"n/a", dataLeAk1120};
			String dataLeAkPath1120 = leakArRay1120[leakArRay1120.length - 1];
			android.util.Log.d("leak-1120", dataLeAkPath1120);
			longText = shortText
					   + " "
					   + getString(R.string.eventend)
					   + " "
					   + endEvent
					   + " "
					   + getString(R.string.ofclass)
					   + " "
					   + endClassName;
			if (PrefsManager.getPlaysoundEnd(this, endClassNum)) {
				String dataLeAk1121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1121 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1121.put("test", new java.util.HashMap<String, String>());
				leakMaP1121.get("test").put("test", dataLeAk1121);
				String dataLeAkPath1121 = leakMaP1121.get("test").get("test");
				android.util.Log.d("leak-1121", dataLeAkPath1121);
				String path = PrefsManager.getSoundFileEnd(
					this, endClassNum);
				emitNotification(longText, path);
				new MyLog(this,
						  "Playing sound for end of event "
						  + endEvent + " of class " + endClassName);
			}
			else if (changed && (wantedMode < current)) {
				String dataLeAk1122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1122 = new StringBuffer();for (char chAr1122 : dataLeAk1122.toCharArray()) {leakBuFFer1122.append(chAr1122);}String dataLeAkPath1122 = leakBuFFer1122.toString();
				android.util.Log.d("leak-1122", dataLeAkPath1122);
				emitNotification(longText, "");
			}
		}
		if (startNotifyWanted)
		{
			String dataLeAk1123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1123;try {throw new Exception(dataLeAk1123);} catch (Exception leakErRor1123) {dataLeAkPath1123 = leakErRor1123.getMessage();}
			android.util.Log.d("leak-1123", dataLeAkPath1123);
			longText = shortText
					   + " "
					   + getString(R.string.eventstart)
					   + " "
					   + startEvent
					   + " "
					   + getString(R.string.ofclass)
					   + " "
					   + startClassName;
			if (PrefsManager.getPlaysoundStart(this, startClassNum)) {
				String dataLeAk1124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay1124 = new String[] {"n/a", dataLeAk1124};
				String dataLeAkPath1124 = leakArRay1124[leakArRay1124.length - 1];
				android.util.Log.d("leak-1124", dataLeAkPath1124);
				String path = PrefsManager.getSoundFileStart(
					this, startClassNum);
				emitNotification(longText, path);
				new MyLog(this,
						  "Playing sound for start of event "
						  + startEvent + " of class " + startClassName);
			}
			else if (changed) {
				String dataLeAk1125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1125 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1125.put("test", new java.util.HashMap<String, String>());
				leakMaP1125.get("test").put("test", dataLeAk1125);
				String dataLeAkPath1125 = leakMaP1125.get("test").get("test");
				android.util.Log.d("leak-1125", dataLeAkPath1125);
				emitNotification(longText, "");
			}
		}
		if (startEvent != "")
		{
			String dataLeAk1126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1126 = new StringBuffer();for (char chAr1126 : dataLeAk1126.toCharArray()) {leakBuFFer1126.append(chAr1126);}String dataLeAkPath1126 = leakBuFFer1126.toString();
			android.util.Log.d("leak-1126", dataLeAkPath1126);
			new MyLog(this,
					  "Setting audio mode to "
					  + PrefsManager.getEnglishStateName(this,
														 wantedMode)
					  + " for start of event "
					  + startEvent
					  + " of class "
					  + startClassName);
		}
		else if (endEvent != "")
		{
			String dataLeAk1127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1127;try {throw new Exception(dataLeAk1127);} catch (Exception leakErRor1127) {dataLeAkPath1127 = leakErRor1127.getMessage();}
			android.util.Log.d("leak-1127", dataLeAkPath1127);
			new MyLog(this,
					  "Setting audio mode to "
					  + PrefsManager.getEnglishStateName(this,
														 wantedMode)
					  + " for end of event "
					  + endEvent
					  + " of class "
					  + endClassName);
		}
		else if (resetting)
		{
			String dataLeAk1128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1128 = new String[] {"n/a", dataLeAk1128};
			String dataLeAkPath1128 = leakArRay1128[leakArRay1128.length - 1];
			android.util.Log.d("leak-1128", dataLeAkPath1128);
			new MyLog(this,
					  "Setting audio mode to "
					  + PrefsManager.getEnglishStateName(this,
														 wantedMode)
					  + " after reset");
		}
		resetting = false;
		PendingIntent pIntent = PendingIntent.getBroadcast(
			this, 0 /*requestCode*/,
			new Intent("CalendarTrigger.Alarm", Uri.EMPTY,
				this, StartServiceReceiver.class),
				PendingIntent.FLAG_UPDATE_CURRENT);
		AlarmManager alarmManager = (AlarmManager)
			getSystemService(Context.ALARM_SERVICE);
		if (nextAlarmTime == Long.MAX_VALUE)
		{
			String dataLeAk1129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1129 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1129.put("test", new java.util.HashMap<String, String>());
			leakMaP1129.get("test").put("test", dataLeAk1129);
			String dataLeAkPath1129 = leakMaP1129.get("test").get("test");
			android.util.Log.d("leak-1129", dataLeAkPath1129);
			alarmManager.cancel(pIntent);
			new MyLog(this, "Alarm cancelled");
		}
		else
		{
			String dataLeAk1130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1130 = new StringBuffer();for (char chAr1130 : dataLeAk1130.toCharArray()) {leakBuFFer1130.append(chAr1130);}String dataLeAkPath1130 = leakBuFFer1130.toString();
			android.util.Log.d("leak-1130", dataLeAkPath1130);
			// Sometimes Android delivers an alarm a few seconds early. In that
			// case we don't do the actions for the alarm (because it isn't
			// time for it yet), but we used not to set the alarm if it had not
			// changed. This resulted in the actions getting lost until we got
			// called again for some reason. However Android also won't set an
            // alarm for less than 1 minute in the future, so in this case we
            // use a handler to schedule another invocation instead.
            long delay = nextAlarmTime - System.currentTimeMillis();
            DateFormat df = DateFormat.getDateTimeInstance();
            if (delay < SIXTYONE_SECONDS)
            {
                String dataLeAk1131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath1131;try {throw new Exception(dataLeAk1131);} catch (Exception leakErRor1131) {dataLeAkPath1131 = leakErRor1131.getMessage();}
				android.util.Log.d("leak-1131", dataLeAkPath1131);
				// If we took a long time executing this procedure, we may have
                // gone past the next alarm time: in that case we reschedule
                // with a zero delay.
                if (delay < 0) { String dataLeAk1132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay1132 = new String[] {"n/a", dataLeAk1132};
					String dataLeAkPath1132 = leakArRay1132[leakArRay1132.length - 1];
					android.util.Log.d("leak-1132", dataLeAkPath1132);
				delay = 0; }
                mHandler.sendMessageDelayed(
                    mHandler.obtainMessage(what, DELAY_WAIT, 0, this), delay);
                lock();
                new MyLog(this, "Delayed messaage set for "
                    .concat(df.format(nextAlarmTime))
                    .concat(alarmReason));
            }
            else
            {
                String dataLeAk1133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1133 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1133.put("test", new java.util.HashMap<String, String>());
				leakMaP1133.get("test").put("test", dataLeAk1133);
				String dataLeAkPath1133 = leakMaP1133.get("test").get("test");
				android.util.Log.d("leak-1133", dataLeAkPath1133);
				if (currentApiVersion >= android.os.Build.VERSION_CODES.M)
                {
                    String dataLeAk1134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer1134 = new StringBuffer();for (char chAr1134 : dataLeAk1134.toCharArray()) {leakBuFFer1134.append(chAr1134);}String dataLeAkPath1134 = leakBuFFer1134.toString();
					android.util.Log.d("leak-1134", dataLeAkPath1134);
					alarmManager.setExactAndAllowWhileIdle(
                        AlarmManager.RTC_WAKEUP, nextAlarmTime, pIntent);
                } else
                {
                    String dataLeAk1135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath1135;try {throw new Exception(dataLeAk1135);} catch (Exception leakErRor1135) {dataLeAkPath1135 = leakErRor1135.getMessage();}
					android.util.Log.d("leak-1135", dataLeAkPath1135);
					alarmManager.setExact(
                        AlarmManager.RTC_WAKEUP, nextAlarmTime, pIntent);
                }
                new MyLog(this, "Alarm time set to "
                    .concat(df.format(nextAlarmTime))
                    .concat(alarmReason));
            }
            PrefsManager.setLastAlarmTime(this, nextAlarmTime);
		}

		PrefsManager.setLastInvocationTime(this, currentTime);
		if (!anyStepCountActive)
		{
			String dataLeAk1136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1136 = new String[] {"n/a", dataLeAk1136};
			String dataLeAkPath1136 = leakArRay1136[leakArRay1136.length - 1];
			android.util.Log.d("leak-1136", dataLeAkPath1136);
			if (PrefsManager.getStepCount(this)
                != PrefsManager.STEP_COUNTER_IDLE)
			{
				String dataLeAk1137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1137 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1137.put("test", new java.util.HashMap<String, String>());
				leakMaP1137.get("test").put("test", dataLeAk1137);
				String dataLeAkPath1137 = leakMaP1137.get("test").get("test");
				android.util.Log.d("leak-1137", dataLeAkPath1137);
				PrefsManager.setStepCount(this, PrefsManager.STEP_COUNTER_IDLE);
				SensorManager sensorManager =
					(SensorManager)getSystemService(Activity.SENSOR_SERVICE);
				sensorManager.unregisterListener(this);
				new MyLog(this, "Step counter deactivated");
			}
		}
		if (!anyLocationActive)
		{
			String dataLeAk1138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1138 = new StringBuffer();for (char chAr1138 : dataLeAk1138.toCharArray()) {leakBuFFer1138.append(chAr1138);}String dataLeAkPath1138 = leakBuFFer1138.toString();
			android.util.Log.d("leak-1138", dataLeAkPath1138);
			if (PrefsManager.getLocationState(this))
			{
				String dataLeAk1139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath1139;try {throw new Exception(dataLeAk1139);} catch (Exception leakErRor1139) {dataLeAkPath1139 = leakErRor1139.getMessage();}
				android.util.Log.d("leak-1139", dataLeAkPath1139);
				LocationUpdates(0, PrefsManager.LATITUDE_IDLE);
			}
		}
		unlock("updateState");
	}

// Commented out as we don't want this debugging code in the real app
// It runs a test to see which combinations of interruption filter and ringer
// mode are actually valid on Marshmallow and later versions
/*
	@TargetApi(android.os.Build.VERSION_CODES.M)
	// debugging code
	private void currentRingerMode() {
		String s = "Current state is ";
		int filter =
			((NotificationManager)
				getSystemService(Context.NOTIFICATION_SERVICE))
				.getCurrentInterruptionFilter();
		switch (filter) {
			case  NotificationManager.INTERRUPTION_FILTER_NONE:
				s += "INTERRUPTION_FILTER_NONE";
				break;
			case  NotificationManager.INTERRUPTION_FILTER_ALARMS:
				s += "INTERRUPTION_FILTER_ALARMS";
				break;
			case  NotificationManager.INTERRUPTION_FILTER_PRIORITY:
				s += "INTERRUPTION_FILTER_PRIORITY";
				break;
			case  NotificationManager.INTERRUPTION_FILTER_ALL:
				s += "INTERRUPTION_FILTER_ALL";
				break;
			default:
				s += "Unknown interruption filter " + String.valueOf(filter);
				break;
		}
		AudioManager audio
			= (AudioManager)getSystemService(Context.AUDIO_SERVICE);
		int mode = audio.getRingerMode();
		switch (mode) {
			case AudioManager.RINGER_MODE_NORMAL:
				s += ", RINGER_MODE_NORMAL";
				break;
			case AudioManager.RINGER_MODE_VIBRATE:
				s += ", RINGER_MODE_VIBRATE";
				break;
			case AudioManager.RINGER_MODE_SILENT:
				s += ", RINGER_MODE_SILENT";
				break;
			default:
				s += ", Unknown ringer mode " + String.valueOf(mode);
				break;
		}
		new MyLog(this, s);
	}

	@TargetApi(android.os.Build.VERSION_CODES.M)
	// debugging code
	private void testRingerMode1(int filter, int mode) {
		String s = "Setting state to ";
		switch (filter)
		{
			case NotificationManager.INTERRUPTION_FILTER_NONE:
				s += "INTERRUPTION_FILTER_NONE";
				break;
			case NotificationManager.INTERRUPTION_FILTER_ALARMS:
				s += "INTERRUPTION_FILTER_ALARMS";
				break;
			case NotificationManager.INTERRUPTION_FILTER_PRIORITY:
				s += "INTERRUPTION_FILTER_PRIORITY";
				break;
			case NotificationManager.INTERRUPTION_FILTER_ALL:
				s += "INTERRUPTION_FILTER_ALL";
				break;
			default:
				s += "Unknown interruption filter " + String.valueOf(filter);
				break;
		}
		((NotificationManager)
			getSystemService(Context.NOTIFICATION_SERVICE))
			.setInterruptionFilter(filter);
		switch (mode)
		{
			case AudioManager.RINGER_MODE_NORMAL:
				s += ", RINGER_MODE_NORMAL";
				break;
			case AudioManager.RINGER_MODE_VIBRATE:
				s += ", RINGER_MODE_VIBRATE";
				break;
			case AudioManager.RINGER_MODE_SILENT:
				s += ", RINGER_MODE_SILENT";
				break;
			default:
				s += ", Unknown ringer mode " + String.valueOf(mode);
				break;
		}
		AudioManager audio
			= (AudioManager)getSystemService(Context.AUDIO_SERVICE);
		audio.setRingerMode(mode);
		new MyLog(this, s);
		currentRingerMode();
	}

	@TargetApi(android.os.Build.VERSION_CODES.M)
	// debugging code
	private void testRingerMode2(int filter, int mode) {
		String s = "Setting state to ";
		switch (mode) {
			case AudioManager.RINGER_MODE_NORMAL:
				s += "RINGER_MODE_NORMAL";
				break;
			case AudioManager.RINGER_MODE_VIBRATE:
				s += "RINGER_MODE_VIBRATE";
				break;
			case AudioManager.RINGER_MODE_SILENT:
				s += "RINGER_MODE_SILENT";
				break;
			default:
				s += "Unknown ringer mode " + String.valueOf(mode);
				break;
		}
		AudioManager audio
			= (AudioManager)getSystemService(Context.AUDIO_SERVICE);
		audio.setRingerMode(mode);
		switch (filter) {
			case  NotificationManager.INTERRUPTION_FILTER_NONE:
				s += ", INTERRUPTION_FILTER_NONE";
				break;
			case  NotificationManager.INTERRUPTION_FILTER_ALARMS:
				s += ", INTERRUPTION_FILTER_ALARMS";
				break;
			case  NotificationManager.INTERRUPTION_FILTER_PRIORITY:
				s += ", INTERRUPTION_FILTER_PRIORITY";
				break;
			case  NotificationManager.INTERRUPTION_FILTER_ALL:
				s += ", INTERRUPTION_FILTER_ALL";
				break;
			default:
				s += ", Unknown interruption filter " + String.valueOf(filter);
				break;
		}
		((NotificationManager)
			getSystemService(Context.NOTIFICATION_SERVICE))
			.setInterruptionFilter(filter);
		new MyLog(this, s);
		currentRingerMode();
	}

	@TargetApi(android.os.Build.VERSION_CODES.M)
	// debugging code
	private void exerciseModes() {
		currentRingerMode();
		int filter = NotificationManager.INTERRUPTION_FILTER_NONE;
		int mode =  AudioManager.RINGER_MODE_SILENT;
		testRingerMode1(filter, mode);
		testRingerMode2(filter, mode);
		mode =  AudioManager.RINGER_MODE_VIBRATE;
		testRingerMode1(filter, mode);
		testRingerMode2(filter, mode);
		mode =  AudioManager.RINGER_MODE_NORMAL;
		testRingerMode1(filter, mode);
		testRingerMode2(filter, mode);
		filter = NotificationManager.INTERRUPTION_FILTER_ALARMS;
		mode =  AudioManager.RINGER_MODE_SILENT;
		testRingerMode1(filter, mode);
		testRingerMode2(filter, mode);
		mode =  AudioManager.RINGER_MODE_VIBRATE;
		testRingerMode1(filter, mode);
		testRingerMode2(filter, mode);
		mode =  AudioManager.RINGER_MODE_NORMAL;
		testRingerMode1(filter, mode);
		testRingerMode2(filter, mode);
		filter = NotificationManager.INTERRUPTION_FILTER_PRIORITY;
		mode =  AudioManager.RINGER_MODE_SILENT;
		testRingerMode1(filter, mode);
		testRingerMode2(filter, mode);
		mode =  AudioManager.RINGER_MODE_VIBRATE;
		testRingerMode1(filter, mode);
		testRingerMode2(filter, mode);
		mode =  AudioManager.RINGER_MODE_NORMAL;
		testRingerMode1(filter, mode);
		testRingerMode2(filter, mode);
		filter = NotificationManager.INTERRUPTION_FILTER_ALL;
		mode =  AudioManager.RINGER_MODE_SILENT;
		testRingerMode1(filter, mode);
		testRingerMode2(filter, mode);
		mode =  AudioManager.RINGER_MODE_VIBRATE;
		testRingerMode1(filter, mode);
		testRingerMode2(filter, mode);
		mode =  AudioManager.RINGER_MODE_NORMAL;
		testRingerMode1(filter, mode);
		testRingerMode2(filter, mode);
	}
*/

	@Override
	public void onHandleIntent(Intent intent) {
		String dataLeAk1140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1140 = new String[] {"n/a", dataLeAk1140};
		String dataLeAkPath1140 = leakArRay1140[leakArRay1140.length - 1];
		android.util.Log.d("leak-1140", dataLeAkPath1140);
		new MyLog(this, "onHandleIntent("
				  .concat(intent.toString())
				  .concat(")"));
		if (intent.getAction() == MUTESERVICE_RESET) {
			String dataLeAk1141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1141 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1141.put("test", new java.util.HashMap<String, String>());
			leakMaP1141.get("test").put("test", dataLeAk1141);
			String dataLeAkPath1141 = leakMaP1141.get("test").get("test");
			android.util.Log.d("leak-1141", dataLeAkPath1141);
			doReset();
		}
		updateState(intent);
		WakefulBroadcastReceiver.completeWakefulIntent(intent);
	}
	
	public static void startIfNecessary(Context c, String caller) {
			String dataLeAk1142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1142 = new StringBuffer();for (char chAr1142 : dataLeAk1142.toCharArray()) {leakBuFFer1142.append(chAr1142);}String dataLeAkPath1142 = leakBuFFer1142.toString();
		android.util.Log.d("leak-1142", dataLeAkPath1142);
			c.startService(new Intent(caller, null, c, MuteService.class));
	}
}
