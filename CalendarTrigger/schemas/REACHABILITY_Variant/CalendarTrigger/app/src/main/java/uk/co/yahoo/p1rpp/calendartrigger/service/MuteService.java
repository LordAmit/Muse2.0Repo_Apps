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

	String dataLeAk1118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk1118 = android.util.Log.d("leak-1118", dataLeAk1118);

	public static final String MUTESERVICE_RESET =
		"CalendarTrigger.MuteService.Reset";

	// some times in milliseconds
    private static final int SIXTYONE_SECONDS = 61 * 1000;
	private static final int FIVE_MINUTES = 5 * 60 * 1000;

	private static final int MODE_WAIT = 0;
    private static final int DELAY_WAIT = 1;

	public MuteService() {
		super("CalendarTriggerService");
		String dataLeAk1119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1119 = android.util.Log.d("leak-1119", dataLeAk1119);
		mHandler = new Handler() {
			String dataLeAk1120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1120 = android.util.Log.d("leak-1120", dataLeAk1120);

			@Override
			public void handleMessage(Message inputMessage) {
                String dataLeAk1121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1121 = android.util.Log.d("leak-1121", dataLeAk1121);
				Context owner = (Context)inputMessage.obj;
				if (inputMessage.arg1 == MODE_WAIT)
				{
					String dataLeAk1122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1122 = android.util.Log.d("leak-1122", dataLeAk1122);
					int mode = PrefsManager.getCurrentMode(owner);
					int wantedMode = PrefsManager.getLastRinger(owner);
					if (wantedMode == PrefsManager.RINGER_MODE_MUTED)
					{
						String dataLeAk1123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1123 = android.util.Log.d("leak-1123", dataLeAk1123);
						PrefsManager.setMuteResult(owner, mode);
					}
					new MyLog(owner,
							  "Handler got mode "
							  + PrefsManager.getEnglishStateName(owner, mode));
					PrefsManager.setLastRinger(owner, mode);
				}
				else if (inputMessage.arg1 == DELAY_WAIT)
				{
                    String dataLeAk1124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1124 = android.util.Log.d("leak-1124", dataLeAk1124);
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
		String dataLeAk1125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1125 = android.util.Log.d("leak-1125", dataLeAk1125);
		if (wakelock == null)
		{
			String dataLeAk1126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1126 = android.util.Log.d("leak-1126", dataLeAk1126);
			new MyLog(this, "Getting lock");
			PowerManager powerManager
				= (PowerManager)getSystemService(POWER_SERVICE);
			wakelock = powerManager.newWakeLock(
				PowerManager.PARTIAL_WAKE_LOCK, "CalendarTrigger:");
			wakelock.acquire();
		}
	}
	private void unlock(String s) { // release the wake lock if we no longer
		String dataLeAk1127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1127 = android.util.Log.d("leak-1127", dataLeAk1127);
		// need it
		int lcs = PrefsManager.getStepCount(this);
		int orientation = PrefsManager.getOrientationState(this);
		if (wakelock != null)
		{
			String dataLeAk1128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1128 = android.util.Log.d("leak-1128", dataLeAk1128);
			if (   (   (lcs == PrefsManager.STEP_COUNTER_IDLE)
					|| (lcs == PrefsManager.STEP_COUNTER_WAKEUP))
				&& (orientation != PrefsManager.ORIENTATION_WAITING)
				&& ((mHandler == null)
					|| !mHandler.hasMessages(what)))
			{
				String dataLeAk1129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1129 = android.util.Log.d("leak-1129", dataLeAk1129);
				new MyLog(this, "End of " + s + ", releasing lock\n");
				wakelock.release();
				wakelock = null;
			}
			else
			{
				String dataLeAk1130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1130 = android.util.Log.d("leak-1130", dataLeAk1130);
				new MyLog(this, "End of " + s + ", retaining lock\n");
			}
		}
		else
		{
			String dataLeAk1131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1131 = android.util.Log.d("leak-1131", dataLeAk1131);
			new MyLog(this, "End of " + s + ", no lock\n");
		}
	}

	private static int notifyId = 1400;

	// Safe for this to be local because it is only used to transfer state from
	// doReset() to updateState() which is called after doReset().
	private static boolean resetting = false;

	private void doReset() {
		String dataLeAk1132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1132 = android.util.Log.d("leak-1132", dataLeAk1132);
		int n = PrefsManager.getNumClasses(this);
		int classNum;
		for (classNum = 0; classNum < n; ++classNum)
		{
			String dataLeAk1133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1133 = android.util.Log.d("leak-1133", dataLeAk1133);
			if (PrefsManager.isClassUsed(this, classNum))
			{
				String dataLeAk1134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1134 = android.util.Log.d("leak-1134", dataLeAk1134);
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
		String dataLeAk1135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1135 = android.util.Log.d("leak-1135", dataLeAk1135);
	}

	@Override
	public void onSensorChanged(SensorEvent sensorEvent) {
		String dataLeAk1136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1136 = android.util.Log.d("leak-1136", dataLeAk1136);
		switch(sensorEvent.sensor.getType())
		{
			case Sensor.TYPE_STEP_COUNTER:
                {
                    String dataLeAk1137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1137 = android.util.Log.d("leak-1137", dataLeAk1137);
					int newCounterSteps = (int)sensorEvent.values[0];
                    if (newCounterSteps != PrefsManager.getStepCount(this))
                    {
                        String dataLeAk1138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1138 = android.util.Log.d("leak-1138", dataLeAk1138);
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

		String dataLeAk1139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1139 = android.util.Log.d("leak-1139", dataLeAk1139);

		@Override
		public void onReceive(Context context, Intent intent) {
			String dataLeAk1140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1140 = android.util.Log.d("leak-1140", dataLeAk1140);
			intent.setClass(context, MuteService.class);
			startWakefulService(context, intent);
		}
	}

	private void emitNotification(String bigText, String path) {
		String dataLeAk1141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1141 = android.util.Log.d("leak-1141", dataLeAk1141);
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
			String dataLeAk1142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1142 = android.util.Log.d("leak-1142", dataLeAk1142);
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
		String dataLeAk1143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1143 = android.util.Log.d("leak-1143", dataLeAk1143);
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
		String dataLeAk1144 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1144 = android.util.Log.d("leak-1144", dataLeAk1144);
		// 0 idle
		// 1 incoming call ringing (but no active call)
		// 2 call active
		int phoneState = PrefsManager.getPhoneState(this);
		if (intent.getAction() == TelephonyManager.ACTION_PHONE_STATE_CHANGED)
		{
			String dataLeAk1145 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1145 = android.util.Log.d("leak-1145", dataLeAk1145);
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
						String dataLeAk1146 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1146 = android.util.Log.d("leak-1146", dataLeAk1146);
						phoneState = PrefsManager.PHONE_RINGING;
						PrefsManager.setPhoneState(this, phoneState);
					}
					break;
			}
			PrefsManager.setNotifiedCannotReadPhoneState(this, false);
		}
		else
		{
			String dataLeAk1147 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1147 = android.util.Log.d("leak-1147", dataLeAk1147);
			boolean canCheckCallState =
				PackageManager.PERMISSION_GRANTED ==
				PermissionChecker.checkSelfPermission(
					this, Manifest.permission.READ_PHONE_STATE);
			if (!canCheckCallState)
			{
				String dataLeAk1148 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1148 = android.util.Log.d("leak-1148", dataLeAk1148);
				if (!PrefsManager.getNotifiedCannotReadPhoneState(this))
				{
					String dataLeAk1149 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1149 = android.util.Log.d("leak-1149", dataLeAk1149);
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
		String dataLeAk1150 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1150 = android.util.Log.d("leak-1150", dataLeAk1150);
		if (!PrefsManager.getLogcycleMode(this))
		{
			String dataLeAk1151 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1151 = android.util.Log.d("leak-1151", dataLeAk1151);
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
			String dataLeAk1152 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1152 = android.util.Log.d("leak-1152", dataLeAk1152);
			new MyLog(this,
					  "Exited doLogCycling because not time yet");
			return; // not time to do it yet
		}
		next = time - time % ONEDAY;
		PrefsManager.setLastCycleDate(this, next);
		ArrayList<String> log = new ArrayList<String>();
		try
		{
			String dataLeAk1153 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1153 = android.util.Log.d("leak-1153", dataLeAk1153);
			boolean inBlock = false;
			DateFormat df = DateFormat.getDateTimeInstance();
			int pp = MyLog.LOGPREFIX.length();
			File f= new File(MyLog.LogFileName());
			BufferedReader in = new BufferedReader(new FileReader(f));
			String line;
			while ((line = in.readLine()) != null)
			{
				String dataLeAk1154 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1154 = android.util.Log.d("leak-1154", dataLeAk1154);
				if (line.startsWith(MyLog.LOGPREFIX))
				{
					String dataLeAk1155 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1155 = android.util.Log.d("leak-1155", dataLeAk1155);
					Date dd = df.parse(line, new ParsePosition(pp));
					if (dd != null)
					{
						String dataLeAk1156 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1156 = android.util.Log.d("leak-1156", dataLeAk1156);
						inBlock = dd.getTime() > time - ONEDAY;
					}
				}
				if (inBlock)
				{
					String dataLeAk1157 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1157 = android.util.Log.d("leak-1157", dataLeAk1157);
					log.add(line); // keep if < 1 day old
				}
			}
			in.close();
			f.delete();
			BufferedWriter out = new BufferedWriter(new FileWriter(f));
			for (String s : log)
			{
				String dataLeAk1158 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1158 = android.util.Log.d("leak-1158", dataLeAk1158);
				out.write(s);
				out.newLine();
			}
			out.close();
		}
		catch (FileNotFoundException e)
		{
			String dataLeAk1159 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1159 = android.util.Log.d("leak-1159", dataLeAk1159);
			return; // no log file is OK if user just flushed it
		}
		catch (Exception e)
		{
			String dataLeAk1160 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1160 = android.util.Log.d("leak-1160", dataLeAk1160);
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
		String dataLeAk1161 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1161 = android.util.Log.d("leak-1161", dataLeAk1161);
		if (PrefsManager.getStepCount(this) == PrefsManager.STEP_COUNTER_IDLE)
		{
			String dataLeAk1162 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1162 = android.util.Log.d("leak-1162", dataLeAk1162);
			SensorManager sensorManager =
				(SensorManager)getSystemService(Activity.SENSOR_SERVICE);
			Sensor sensor =
				sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER, true);
            if (sensor == null)
            {
                String dataLeAk1163 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1163 = android.util.Log.d("leak-1163", dataLeAk1163);
				// if we can't get a wakeup step counter, try without
                sensor =
                    sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
                if (sensor == null)
                {
                    String dataLeAk1164 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1164 = android.util.Log.d("leak-1164", dataLeAk1164);
					// no step counter at all
                    return false;
                }
            }
			if (sensorManager.registerListener(
			    this, sensor, SensorManager.SENSOR_DELAY_NORMAL))
			{
                String dataLeAk1165 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1165 = android.util.Log.d("leak-1165", dataLeAk1165);
				new MyLog(this, "Step counter activated for class "
                    .concat(PrefsManager.getClassName(this, classNum)));
                if (sensor.isWakeUpSensor())
                {
                    String dataLeAk1166 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1166 = android.util.Log.d("leak-1166", dataLeAk1166);
					PrefsManager.setStepCount(
                        this, PrefsManager.STEP_COUNTER_WAKEUP);
                }
                else
                {
                    String dataLeAk1167 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1167 = android.util.Log.d("leak-1167", dataLeAk1167);
					PrefsManager.setStepCount(
                        this, PrefsManager.STEP_COUNTER_WAKE_LOCK);
					lock();
                }
				return true;
			}
			else
			{
				String dataLeAk1168 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1168 = android.util.Log.d("leak-1168", dataLeAk1168);
				return false; // could not activate step counter
			}
		}
		else
		{
			String dataLeAk1169 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1169 = android.util.Log.d("leak-1169", dataLeAk1169);
			// already starting it for another class
			return true;
		}
	}

	public void LocationUpdates(int classNum, double which) {
		String dataLeAk1170 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1170 = android.util.Log.d("leak-1170", dataLeAk1170);
		LocationManager lm =
			(LocationManager)getSystemService(Context.LOCATION_SERVICE);
		String s = "CalendarTrigger.Location";
		PendingIntent pi = PendingIntent.getBroadcast(
			this, 0 /*requestCode*/,
			new Intent(s, Uri.EMPTY, this, StartServiceReceiver.class),
			PendingIntent.FLAG_UPDATE_CURRENT);
		if (which == PrefsManager.LATITUDE_IDLE)
		{
			String dataLeAk1171 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1171 = android.util.Log.d("leak-1171", dataLeAk1171);
			lm.removeUpdates(pi);
			PrefsManager.setLocationState(this, false);
			new MyLog(this, "Removing location updates");
		}
		else
		{
			String dataLeAk1172 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1172 = android.util.Log.d("leak-1172", dataLeAk1172);
			List<String> ls = lm.getProviders(true);
			if (which == PrefsManager.LATITUDE_FIRST)
			{
				String dataLeAk1173 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1173 = android.util.Log.d("leak-1173", dataLeAk1173);
				if (ls.contains("gps"))
				{
					String dataLeAk1174 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1174 = android.util.Log.d("leak-1174", dataLeAk1174);
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
					String dataLeAk1175 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1175 = android.util.Log.d("leak-1175", dataLeAk1175);
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
				String dataLeAk1176 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1176 = android.util.Log.d("leak-1176", dataLeAk1176);
				float meters =
					(float)PrefsManager.getAfterMetres(this, classNum);
				if (ls.contains("gps"))
				{
					String dataLeAk1177 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1177 = android.util.Log.d("leak-1177", dataLeAk1177);
					lm.requestLocationUpdates("gps", 5 * 60 * 1000, meters, pi);
				}
				else
				{
					String dataLeAk1178 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1178 = android.util.Log.d("leak-1178", dataLeAk1178);
					Criteria cr = new Criteria();
					cr.setAccuracy(Criteria.ACCURACY_FINE);
					lm.requestLocationUpdates(5 * 60 * 1000, meters, cr, pi);
				}
			}
		}
	}

	private void startLocationWait(int classNum, Intent intent) {
		String dataLeAk1179 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1179 = android.util.Log.d("leak-1179", dataLeAk1179);
		Location here =
			intent.getParcelableExtra(LocationManager.KEY_LOCATION_CHANGED);
		if (!PrefsManager.getLocationState(this))
		{
			String dataLeAk1180 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1180 = android.util.Log.d("leak-1180", dataLeAk1180);
			LocationUpdates(classNum, PrefsManager.LATITUDE_FIRST);
		}
		else if (here != null)
		{
			String dataLeAk1181 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1181 = android.util.Log.d("leak-1181", dataLeAk1181);
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
			String dataLeAk1182 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1182 = android.util.Log.d("leak-1182", dataLeAk1182);
			PrefsManager.setLatitude(
				this, classNum, PrefsManager.LATITUDE_FIRST);
		}
	}

	// return true if not left geofence yet
	private boolean checkLocationWait(
		int classNum, double latitude, Intent intent) {
		String dataLeAk1183 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1183 = android.util.Log.d("leak-1183", dataLeAk1183);
		if (!PrefsManager.getLocationState(this))
		{
			String dataLeAk1184 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1184 = android.util.Log.d("leak-1184", dataLeAk1184);
			// we got reset, pretend we left the geofence
			PrefsManager.setLatitude(
				this, classNum, PrefsManager.LATITUDE_IDLE);
			return false;
		}
		Location here =
			intent.getParcelableExtra(LocationManager.KEY_LOCATION_CHANGED);
		if (here != null)
		{
			String dataLeAk1185 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1185 = android.util.Log.d("leak-1185", dataLeAk1185);
			if (latitude == PrefsManager.LATITUDE_FIRST)
			{
				String dataLeAk1186 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1186 = android.util.Log.d("leak-1186", dataLeAk1186);
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
				String dataLeAk1187 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1187 = android.util.Log.d("leak-1187", dataLeAk1187);
				float meters = (float)PrefsManager.getAfterMetres(this, classNum);
				float[] results = new float[1];
				double longitude = PrefsManager.getLongitude(this, classNum);
				Location.distanceBetween(latitude, longitude,
										 here.getLatitude(),
										 here.getLongitude(),
										 results);
				if (results[0] < meters * 0.9)
				{
					String dataLeAk1188 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1188 = android.util.Log.d("leak-1188", dataLeAk1188);
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
		String dataLeAk1189 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1189 = android.util.Log.d("leak-1189", dataLeAk1189);
		int wanted;
		if (before)
		{
			String dataLeAk1190 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1190 = android.util.Log.d("leak-1190", dataLeAk1190);
			wanted = PrefsManager.getBeforeOrientation(this, classNum);
		}
		else
		{
			String dataLeAk1191 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1191 = android.util.Log.d("leak-1191", dataLeAk1191);
			wanted = PrefsManager.getAfterOrientation(this, classNum);
		}
		if (   (wanted == 0)
			|| (wanted == PrefsManager.BEFORE_ANY_POSITION))
		{
			String dataLeAk1192 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1192 = android.util.Log.d("leak-1192", dataLeAk1192);
			return false;
		}
		switch (PrefsManager.getOrientationState(this))
		{
			case PrefsManager.ORIENTATION_IDLE: // sensor currently not active
				SensorManager sm = (SensorManager)getSystemService(SENSOR_SERVICE);
				Sensor ams = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
				if (ams == null) { String dataLeAk1193 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1193 = android.util.Log.d("leak-1193", dataLeAk1193);
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
					String dataLeAk1194 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1194 = android.util.Log.d("leak-1194", dataLeAk1194);
					if ((wanted & PrefsManager.BEFORE_FACE_UP) != 0)
					{
						String dataLeAk1195 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1195 = android.util.Log.d("leak-1195", dataLeAk1195);
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
					String dataLeAk1196 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1196 = android.util.Log.d("leak-1196", dataLeAk1196);
					if ((wanted & PrefsManager.BEFORE_FACE_DOWN) != 0)
					{
						String dataLeAk1197 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1197 = android.util.Log.d("leak-1197", dataLeAk1197);
						return false;
					}
				}
				else if ((wanted & PrefsManager.BEFORE_OTHER_POSITION) != 0)
				{
					String dataLeAk1198 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1198 = android.util.Log.d("leak-1198", dataLeAk1198);
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
		String dataLeAk1199 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1199 = android.util.Log.d("leak-1199", dataLeAk1199);
		int wanted;
		if (before) {
			String dataLeAk1200 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1200 = android.util.Log.d("leak-1200", dataLeAk1200);
			wanted = PrefsManager.getBeforeConnection(this, classNum);
		}
		else
		{
			String dataLeAk1201 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1201 = android.util.Log.d("leak-1201", dataLeAk1201);
			wanted = PrefsManager.getAfterConnection(this, classNum);
		}
		if (   (wanted == 0)
			|| (wanted == PrefsManager.BEFORE_ANY_CONNECTION))
		{
			String dataLeAk1202 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1202 = android.util.Log.d("leak-1202", dataLeAk1202);
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
			String dataLeAk1203 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1203 = android.util.Log.d("leak-1203", dataLeAk1203);
			return false;
		}
		if (   ((wanted & PrefsManager.BEFORE_FAST_CHARGER) != 0)
			   && (charge == BatteryManager.BATTERY_PLUGGED_AC))
		{
			String dataLeAk1204 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1204 = android.util.Log.d("leak-1204", dataLeAk1204);
			return false;
		}
		if (   ((wanted & PrefsManager.BEFORE_PLAIN_CHARGER) != 0)
			   && (charge == BatteryManager.BATTERY_PLUGGED_USB))
		{
			String dataLeAk1205 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1205 = android.util.Log.d("leak-1205", dataLeAk1205);
			return false;
		}
		if ((wanted & PrefsManager.BEFORE_PERIPHERAL) != 0)
		{
			String dataLeAk1206 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1206 = android.util.Log.d("leak-1206", dataLeAk1206);
			if (!map.isEmpty())
			{
				String dataLeAk1207 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1207 = android.util.Log.d("leak-1207", dataLeAk1207);
				return false;
			}
		}
		if (   ((wanted & PrefsManager.BEFORE_UNCONNECTED) != 0)
			&& (charge == 0)
			&& map.isEmpty())
		{
			String dataLeAk1208 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1208 = android.util.Log.d("leak-1208", dataLeAk1208);
			return false;
		}
		return true;
	}

	@TargetApi(android.os.Build.VERSION_CODES.M)
	// Set the ringer mode. Returns true if mode changed.
	boolean setCurrentRinger(AudioManager audio,
		int apiVersion, int mode, int current) {
		String dataLeAk1209 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1209 = android.util.Log.d("leak-1209", dataLeAk1209);
		if (   (current == mode)
			|| (   (mode == PrefsManager.RINGER_MODE_NONE)
			    && (current == PrefsManager.RINGER_MODE_NORMAL))
			|| (   (mode == PrefsManager.RINGER_MODE_MUTED)
				   && (current == PrefsManager.getMuteResult(this))))
		{
			String dataLeAk1210 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1210 = android.util.Log.d("leak-1210", dataLeAk1210);
			return false;  // no change
		}
		PrefsManager.setLastRinger(this, mode);
		if (apiVersion >= android.os.Build.VERSION_CODES.M)
		{
			String dataLeAk1211 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1211 = android.util.Log.d("leak-1211", dataLeAk1211);
			NotificationManager nm = (NotificationManager)
				getSystemService(Context.NOTIFICATION_SERVICE);
			switch (mode)
			{
				case PrefsManager.RINGER_MODE_SILENT:
					audio.setRingerMode(AudioManager.RINGER_MODE_SILENT);
					if (nm.isNotificationPolicyAccessGranted())
					{
						String dataLeAk1212 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1212 = android.util.Log.d("leak-1212", dataLeAk1212);
						nm.setInterruptionFilter(
							NotificationManager.INTERRUPTION_FILTER_NONE);
					}
					else
					{
						String dataLeAk1213 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1213 = android.util.Log.d("leak-1213", dataLeAk1213);
						PermissionFail(mode);
					}
					break;
				case PrefsManager.RINGER_MODE_ALARMS:
					if (nm.isNotificationPolicyAccessGranted())
					{
						String dataLeAk1214 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1214 = android.util.Log.d("leak-1214", dataLeAk1214);
						audio.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
						nm.setInterruptionFilter(
							NotificationManager.INTERRUPTION_FILTER_ALARMS);
						break;
					}
					/*FALLTHRU if no permission, treat as muted */
				case PrefsManager.RINGER_MODE_DO_NOT_DISTURB:
					if (nm.isNotificationPolicyAccessGranted())
					{
						String dataLeAk1215 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1215 = android.util.Log.d("leak-1215", dataLeAk1215);
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
						String dataLeAk1216 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1216 = android.util.Log.d("leak-1216", dataLeAk1216);
						nm.setInterruptionFilter(
							NotificationManager.INTERRUPTION_FILTER_ALL);
					}
					audio.setRingerMode(AudioManager.RINGER_MODE_SILENT);
					break;
				case PrefsManager.RINGER_MODE_VIBRATE:
					if (nm.isNotificationPolicyAccessGranted())
					{
						String dataLeAk1217 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1217 = android.util.Log.d("leak-1217", dataLeAk1217);
						nm.setInterruptionFilter(
							NotificationManager.INTERRUPTION_FILTER_ALL);
					}
					audio.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
					break;
                case PrefsManager.RINGER_MODE_NORMAL:
				case PrefsManager.RINGER_MODE_NONE:
					if (nm.isNotificationPolicyAccessGranted())
					{
						String dataLeAk1218 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1218 = android.util.Log.d("leak-1218", dataLeAk1218);
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
			String dataLeAk1219 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1219 = android.util.Log.d("leak-1219", dataLeAk1219);
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
		String dataLeAk1220 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1220 = android.util.Log.d("leak-1220", dataLeAk1220);
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
			String dataLeAk1221 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1221 = android.util.Log.d("leak-1221", dataLeAk1221);
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
			String dataLeAk1222 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1222 = android.util.Log.d("leak-1222", dataLeAk1222);
			new MyLog(this, "Step counter running");
		}
		int n = PrefsManager.getNumClasses(this);
		CalendarProvider provider = new CalendarProvider(this);
		for (classNum = 0; classNum < n; ++classNum)
		{
			String dataLeAk1223 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1223 = android.util.Log.d("leak-1223", dataLeAk1223);
			if (PrefsManager.isClassUsed(this, classNum))
			{
				String dataLeAk1224 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1224 = android.util.Log.d("leak-1224", dataLeAk1224);
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
					String dataLeAk1225 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1225 = android.util.Log.d("leak-1225", dataLeAk1225);
					long after = PrefsManager.getAfterMinutes(this, classNum)
								 * 60000;
					if (after > 0)
					{
						String dataLeAk1226 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1226 = android.util.Log.d("leak-1226", dataLeAk1226);
						long triggerEnd = currentTime + after;
						if (   (active && (triggerEnd > result.endTime))
							|| ((!active) && (triggerEnd < result.startTime)))
						{
							String dataLeAk1227 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1227 = android.util.Log.d("leak-1227", dataLeAk1227);
							result.endEventName = "<immediate>";
							result.endTime = triggerEnd;
						}
						PrefsManager.setLastTriggerEnd(
							this, classNum, result.endTime);
					}
					else if (!active)
					{
						String dataLeAk1228 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1228 = android.util.Log.d("leak-1228", dataLeAk1228);
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
						String dataLeAk1229 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1229 = android.util.Log.d("leak-1229", dataLeAk1229);
						result.startEventName = "<immediate>";
						result.startTime = currentTime;
					}
					if (after > 0)
					{
						String dataLeAk1230 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1230 = android.util.Log.d("leak-1230", dataLeAk1230);
						// need to do this after above test
						active = true;
					}
				}
				if (triggered || active)
				{
					String dataLeAk1231 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1231 = android.util.Log.d("leak-1231", dataLeAk1231);
					if (!PrefsManager.isClassActive(this, classNum))
					{
						// need to start this class

						String dataLeAk1232 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1232 = android.util.Log.d("leak-1232", dataLeAk1232);
						// True if not ready to start it yet.
						boolean notNow =
							phoneState == PrefsManager.PHONE_CALL_ACTIVE;
						if (!notNow)
						{
							String dataLeAk1233 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1233 = android.util.Log.d("leak-1233", dataLeAk1233);
							notNow = checkOrientationWait(classNum, true);
							new MyLog(this, "checkOrientationWait("
											+ className
											+ ", true) returns "
											+ (notNow ? "true" : "false"));
							if (notNow)
							{
								String dataLeAk1234 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk1234 = android.util.Log.d("leak-1234", dataLeAk1234);
								if ((nextAccelTime < nextAlarmTime)
									&& (nextAccelTime > currentTime))
								{
									String dataLeAk1235 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk1235 = android.util.Log.d("leak-1235", dataLeAk1235);
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
								String dataLeAk1236 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk1236 = android.util.Log.d("leak-1236", dataLeAk1236);
								notNow = checkConnectionWait(classNum, true);
								if (notNow)
								{
									String dataLeAk1237 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk1237 = android.util.Log.d("leak-1237", dataLeAk1237);
									if (nextTime < nextAlarmTime)
									{
										String dataLeAk1238 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk1238 = android.util.Log.d("leak-1238", dataLeAk1238);
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
							String dataLeAk1239 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1239 = android.util.Log.d("leak-1239", dataLeAk1239);
							// we can't start it yet
							triggered = false;
							active = false;
							result.endTime = Long.MAX_VALUE;
						}
						else
						{
							String dataLeAk1240 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1240 = android.util.Log.d("leak-1240", dataLeAk1240);
							if (ringerAction > wantedMode)
							{
								String dataLeAk1241 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk1241 = android.util.Log.d("leak-1241", dataLeAk1241);
								if (PrefsManager.getNotifyStart(this, classNum))
								{
									String dataLeAk1242 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk1242 = android.util.Log.d("leak-1242", dataLeAk1242);
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
					String dataLeAk1243 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1243 = android.util.Log.d("leak-1243", dataLeAk1243);
					// class should be currently active
					if (ringerAction > wantedMode)
					{
						String dataLeAk1244 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1244 = android.util.Log.d("leak-1244", dataLeAk1244);
						wantedMode = ringerAction;
					}
					PrefsManager.setLastActive(
						this, classNum, result.endEventName);
				}
				if (!active)
				{
					// class should not be currently active

					String dataLeAk1245 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1245 = android.util.Log.d("leak-1245", dataLeAk1245);
					// check if we're waiting for movement
					boolean done = false;
					boolean waiting = false;
                    int lastCounterSteps = PrefsManager.getStepCount(this);
					int aftersteps =
						PrefsManager.getAfterSteps(this, classNum);
					if (PrefsManager.isClassActive(this, classNum))
					{
						String dataLeAk1246 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1246 = android.util.Log.d("leak-1246", dataLeAk1246);
						done = true;
						if (haveStepCounter && (aftersteps > 0))
						{
							String dataLeAk1247 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1247 = android.util.Log.d("leak-1247", dataLeAk1247);
							if (lastCounterSteps < 0)
							{
								String dataLeAk1248 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk1248 = android.util.Log.d("leak-1248", dataLeAk1248);
								// need to start up the sensor
								if (StartStepCounter(classNum))
								{
									String dataLeAk1249 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk1249 = android.util.Log.d("leak-1249", dataLeAk1249);
									PrefsManager.setTargetSteps(
										this, classNum, 0);
									anyStepCountActive = true;
									waiting = true;
									done = false;
								}
							}
							else // sensor already running
							{
								String dataLeAk1250 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk1250 = android.util.Log.d("leak-1250", dataLeAk1250);
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
							String dataLeAk1251 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1251 = android.util.Log.d("leak-1251", dataLeAk1251);
							// keep it active while waiting for location
							startLocationWait(classNum, intent);
							anyLocationActive = true;
							waiting = true;
							done = false;
						}
						if (checkOrientationWait(classNum, false))
						{
							String dataLeAk1252 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1252 = android.util.Log.d("leak-1252", dataLeAk1252);
							if ((nextAccelTime < nextAlarmTime)
								&& (nextAccelTime > currentTime))
							{
								String dataLeAk1253 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk1253 = android.util.Log.d("leak-1253", dataLeAk1253);
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
							String dataLeAk1254 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1254 = android.util.Log.d("leak-1254", dataLeAk1254);
							if (nextTime < nextAlarmTime)
							{
								String dataLeAk1255 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk1255 = android.util.Log.d("leak-1255", dataLeAk1255);
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
						String dataLeAk1256 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1256 = android.util.Log.d("leak-1256", dataLeAk1256);
						done = true;
						if ((lastCounterSteps != PrefsManager.STEP_COUNTER_IDLE)
                            && (aftersteps > 0))
						{
							String dataLeAk1257 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1257 = android.util.Log.d("leak-1257", dataLeAk1257);
							int steps
								= PrefsManager.getTargetSteps(this, classNum);
							if (steps == 0)
							{
								String dataLeAk1258 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk1258 = android.util.Log.d("leak-1258", dataLeAk1258);
								if (lastCounterSteps >= 0)
								{
									String dataLeAk1259 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk1259 = android.util.Log.d("leak-1259", dataLeAk1259);
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
								String dataLeAk1260 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk1260 = android.util.Log.d("leak-1260", dataLeAk1260);
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
							String dataLeAk1261 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1261 = android.util.Log.d("leak-1261", dataLeAk1261);
							anyLocationActive = true;
							waiting = true;
							done = false;
						}
						if (checkOrientationWait(classNum, false))
						{
							String dataLeAk1262 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1262 = android.util.Log.d("leak-1262", dataLeAk1262);
							if ((nextAccelTime < nextAlarmTime)
								&& (nextAccelTime > currentTime))
							{
								String dataLeAk1263 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk1263 = android.util.Log.d("leak-1263", dataLeAk1263);
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
							String dataLeAk1264 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1264 = android.util.Log.d("leak-1264", dataLeAk1264);
							if (nextTime < nextAlarmTime)
							{
								String dataLeAk1265 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk1265 = android.util.Log.d("leak-1265", dataLeAk1265);
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
						String dataLeAk1266 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1266 = android.util.Log.d("leak-1266", dataLeAk1266);
						PrefsManager.setClassWaiting(this, classNum, true);
					}
					if (done)
					{
						String dataLeAk1267 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1267 = android.util.Log.d("leak-1267", dataLeAk1267);
						if (   (PrefsManager.getRestoreRinger(this,classNum))
							|| (endEvent.isEmpty()))
						{
							String dataLeAk1268 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1268 = android.util.Log.d("leak-1268", dataLeAk1268);
							if (PrefsManager.getNotifyEnd(this, classNum))
							{
								String dataLeAk1269 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk1269 = android.util.Log.d("leak-1269", dataLeAk1269);
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
						String dataLeAk1270 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1270 = android.util.Log.d("leak-1270", dataLeAk1270);
						wantedMode = ringerAction;
					}
				}
				if (   (result.endTime < nextAlarmTime)
					&& (result.endTime > currentTime))
				{
					String dataLeAk1271 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1271 = android.util.Log.d("leak-1271", dataLeAk1271);
					nextAlarmTime = result.endTime;
					alarmReason = " for end of event "
						.concat(result.endEventName)
						.concat(" of class ")
						.concat(className);
				}
				if (   (result.startTime < nextAlarmTime)
					&& (result.startTime > currentTime))
				{
					String dataLeAk1272 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1272 = android.util.Log.d("leak-1272", dataLeAk1272);
					nextAlarmTime = result.startTime;
					alarmReason = " for start of event "
						.concat(result.startEventName)
						.concat(" of class ")
						.concat(className);
				}
				if (triggered)
				{
					String dataLeAk1273 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1273 = android.util.Log.d("leak-1273", dataLeAk1273);
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
			String dataLeAk1274 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1274 = android.util.Log.d("leak-1274", dataLeAk1274);
			CalendarProvider.StartAndLocation sl =
				provider.nextLocation(this, currentTime);
			if (sl != null)
			{
				String dataLeAk1275 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1275 = android.util.Log.d("leak-1275", dataLeAk1275);
				ContactCreator cc = new  ContactCreator(this);
				cc.makeContact("!NextEventLocation", "", sl.location);
				long slst = sl.startTime + 60000;
				if (   (slst < nextAlarmTime)
				    && (slst > currentTime))
				{
					String dataLeAk1276 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1276 = android.util.Log.d("leak-1276", dataLeAk1276);
					nextAlarmTime = slst;
					alarmReason = " after start of event "
						.concat(sl.eventName);
				}
			}
		}
		String shortText;
		String longText;
		if (wantedMode < user) { String dataLeAk1277 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1277 = android.util.Log.d("leak-1277", dataLeAk1277);
		wantedMode = user; }
		else if (wantedMode == PrefsManager.RINGER_MODE_NONE)
		{
			String dataLeAk1278 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1278 = android.util.Log.d("leak-1278", dataLeAk1278);
			wantedMode = PrefsManager.RINGER_MODE_NORMAL;
		}
 		boolean changed =
			setCurrentRinger(audio, currentApiVersion,  wantedMode, current);
		if (changed) {
			String dataLeAk1279 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1279 = android.util.Log.d("leak-1279", dataLeAk1279);
			shortText = PrefsManager.getRingerStateName(this, wantedMode);
		}
		else {
			String dataLeAk1280 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1280 = android.util.Log.d("leak-1280", dataLeAk1280);
			shortText = getString(R.string.ringerModeNone);
		}
		if (endNotifyWanted)
		{
			String dataLeAk1281 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1281 = android.util.Log.d("leak-1281", dataLeAk1281);
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
				String dataLeAk1282 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1282 = android.util.Log.d("leak-1282", dataLeAk1282);
				String path = PrefsManager.getSoundFileEnd(
					this, endClassNum);
				emitNotification(longText, path);
				new MyLog(this,
						  "Playing sound for end of event "
						  + endEvent + " of class " + endClassName);
			}
			else if (changed && (wantedMode < current)) {
				String dataLeAk1283 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1283 = android.util.Log.d("leak-1283", dataLeAk1283);
				emitNotification(longText, "");
			}
		}
		if (startNotifyWanted)
		{
			String dataLeAk1284 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1284 = android.util.Log.d("leak-1284", dataLeAk1284);
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
				String dataLeAk1285 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1285 = android.util.Log.d("leak-1285", dataLeAk1285);
				String path = PrefsManager.getSoundFileStart(
					this, startClassNum);
				emitNotification(longText, path);
				new MyLog(this,
						  "Playing sound for start of event "
						  + startEvent + " of class " + startClassName);
			}
			else if (changed) {
				String dataLeAk1286 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1286 = android.util.Log.d("leak-1286", dataLeAk1286);
				emitNotification(longText, "");
			}
		}
		if (startEvent != "")
		{
			String dataLeAk1287 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1287 = android.util.Log.d("leak-1287", dataLeAk1287);
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
			String dataLeAk1288 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1288 = android.util.Log.d("leak-1288", dataLeAk1288);
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
			String dataLeAk1289 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1289 = android.util.Log.d("leak-1289", dataLeAk1289);
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
			String dataLeAk1290 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1290 = android.util.Log.d("leak-1290", dataLeAk1290);
			alarmManager.cancel(pIntent);
			new MyLog(this, "Alarm cancelled");
		}
		else
		{
			String dataLeAk1291 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1291 = android.util.Log.d("leak-1291", dataLeAk1291);
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
                String dataLeAk1292 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1292 = android.util.Log.d("leak-1292", dataLeAk1292);
				// If we took a long time executing this procedure, we may have
                // gone past the next alarm time: in that case we reschedule
                // with a zero delay.
                if (delay < 0) { String dataLeAk1293 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1293 = android.util.Log.d("leak-1293", dataLeAk1293);
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
                String dataLeAk1294 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1294 = android.util.Log.d("leak-1294", dataLeAk1294);
				if (currentApiVersion >= android.os.Build.VERSION_CODES.M)
                {
                    String dataLeAk1295 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1295 = android.util.Log.d("leak-1295", dataLeAk1295);
					alarmManager.setExactAndAllowWhileIdle(
                        AlarmManager.RTC_WAKEUP, nextAlarmTime, pIntent);
                } else
                {
                    String dataLeAk1296 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1296 = android.util.Log.d("leak-1296", dataLeAk1296);
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
			String dataLeAk1297 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1297 = android.util.Log.d("leak-1297", dataLeAk1297);
			if (PrefsManager.getStepCount(this)
                != PrefsManager.STEP_COUNTER_IDLE)
			{
				String dataLeAk1298 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1298 = android.util.Log.d("leak-1298", dataLeAk1298);
				PrefsManager.setStepCount(this, PrefsManager.STEP_COUNTER_IDLE);
				SensorManager sensorManager =
					(SensorManager)getSystemService(Activity.SENSOR_SERVICE);
				sensorManager.unregisterListener(this);
				new MyLog(this, "Step counter deactivated");
			}
		}
		if (!anyLocationActive)
		{
			String dataLeAk1299 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1299 = android.util.Log.d("leak-1299", dataLeAk1299);
			if (PrefsManager.getLocationState(this))
			{
				String dataLeAk1300 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1300 = android.util.Log.d("leak-1300", dataLeAk1300);
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
		String dataLeAk1301 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1301 = android.util.Log.d("leak-1301", dataLeAk1301);
		new MyLog(this, "onHandleIntent("
				  .concat(intent.toString())
				  .concat(")"));
		if (intent.getAction() == MUTESERVICE_RESET) {
			String dataLeAk1302 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1302 = android.util.Log.d("leak-1302", dataLeAk1302);
			doReset();
		}
		updateState(intent);
		WakefulBroadcastReceiver.completeWakefulIntent(intent);
	}
	
	public static void startIfNecessary(Context c, String caller) {
			String dataLeAk1303 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1303 = android.util.Log.d("leak-1303", dataLeAk1303);
			c.startService(new Intent(caller, null, c, MuteService.class));
	}
}
