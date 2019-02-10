/*
 * Copyright (c) 2016. Richard P. Parkins, M. A.
 * Released under GPL V3 or later
 */

package uk.co.yahoo.p1rpp.calendartrigger;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.media.AudioManager;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PrefsManager {

	String dataLeAk912 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk912 = android.util.Log.d("leak-912", dataLeAk912);

	private static final String PREFS_NAME = "mainPreferences";

	private static final String PREF_DEFAULTDIRECTORY = "DefaultDir";

	public static final void setDefaultDir(Context context, String dir) {
		String dataLeAk913 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk913 = android.util.Log.d("leak-913", dataLeAk913);
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit()
			   .putString(PREF_DEFAULTDIRECTORY, dir).commit();
	}

	public static final String getDefaultDir(Context context) {
		String dataLeAk914 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk914 = android.util.Log.d("leak-914", dataLeAk914);
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getString(PREF_DEFAULTDIRECTORY, null);
	}

	private static final String PREF_LOGGING = "logging";

	public static void setLoggingMode(Context context, boolean IsOn) {
		String dataLeAk915 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk915 = android.util.Log.d("leak-915", dataLeAk915);
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit()
			   .putBoolean(PREF_LOGGING, IsOn).commit();
	}

	public static boolean getLoggingMode(Context context) {
		String dataLeAk916 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk916 = android.util.Log.d("leak-916", dataLeAk916);
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getBoolean(PREF_LOGGING, false);
	}

	private static final String PREF_LOGCYCLE = "logcycle";

	public static void setLogCycleMode(Context context, boolean IsOn) {
		String dataLeAk917 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk917 = android.util.Log.d("leak-917", dataLeAk917);
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit()
			   .putBoolean(PREF_LOGCYCLE, IsOn).commit();
	}

	public static boolean getLogcycleMode(Context context) {
		String dataLeAk918 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk918 = android.util.Log.d("leak-918", dataLeAk918);
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getBoolean(PREF_LOGCYCLE, false);
	}

	private static final String PREF_LASTCYCLEDATE = "lastcycledate";

	public static void setLastCycleDate(Context context, long date) {
		String dataLeAk919 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk919 = android.util.Log.d("leak-919", dataLeAk919);
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit()
			   .putLong(PREF_LASTCYCLEDATE, date).commit();
	}

	public static long getLastcycleDate(Context context) {
		String dataLeAk920 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk920 = android.util.Log.d("leak-920", dataLeAk920);
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getLong(PREF_LASTCYCLEDATE, 0);
	}

	private static final String PREF_NEXT_LOCATION = "nextLocation";

	public static void setNextLocationMode(Context context, boolean IsOn) {
		String dataLeAk921 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk921 = android.util.Log.d("leak-921", dataLeAk921);
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit()
			   .putBoolean(PREF_NEXT_LOCATION, IsOn).commit();
	}

	public static boolean getNextLocationMode(Context context) {
		String dataLeAk922 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk922 = android.util.Log.d("leak-922", dataLeAk922);
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getBoolean(PREF_NEXT_LOCATION, false);
	}


	// This works around a nastiness in some Android versions:
	// If we try to mute the ringer, the behaviour depends on the previous state
	//    if it was normal, we get ALARMS_ONLY
	//    but if it was ALARMS_ONLY, we get normal!
	private static final String PREF_MUTE_RESULT = "muteresult";

	public static void setMuteResult(Context context, int state) {
		String dataLeAk923 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk923 = android.util.Log.d("leak-923", dataLeAk923);
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit()
			   .putInt(PREF_MUTE_RESULT, state).commit();
	}

	public static int getMuteResult(Context context) {
		String dataLeAk924 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk924 = android.util.Log.d("leak-924", dataLeAk924);
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getInt(PREF_MUTE_RESULT, PHONE_IDLE);
	}

	private static final String PREF_PHONE_STATE = "phoneState";

	// Our idea of the phone state differs from Android's because we consider
	// ringing when a call is active to be "active" whereas Android thinks it
	// is "ringing".
	public static final int PHONE_IDLE = 0;
	public static final int PHONE_RINGING = 1;
	public static final int PHONE_CALL_ACTIVE = 2;

	public static void setPhoneState(Context context, int state) {
		String dataLeAk925 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk925 = android.util.Log.d("leak-925", dataLeAk925);
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit()
			   .putInt(PREF_PHONE_STATE, state).commit();
	}

	public static int getPhoneState(Context context) {
		String dataLeAk926 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk926 = android.util.Log.d("leak-926", dataLeAk926);
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getInt(PREF_PHONE_STATE, PHONE_IDLE);
	}

	private static final String PREF_PHONE_WARNED =
		"notifiedCannotReadPhoneState";

	public static void setNotifiedCannotReadPhoneState(
		Context context, boolean state) {
		String dataLeAk927 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk927 = android.util.Log.d("leak-927", dataLeAk927);
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit()
			.putBoolean(PREF_PHONE_WARNED, state).commit();

	}

	public static boolean getNotifiedCannotReadPhoneState(Context context) {
		String dataLeAk928 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk928 = android.util.Log.d("leak-928", dataLeAk928);
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getBoolean(PREF_PHONE_WARNED, false);
	}

	private static final String PREF_LOCATION_ACTIVE = "locationActive";

	public static void setLocationState(Context context, boolean state) {
		String dataLeAk929 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk929 = android.util.Log.d("leak-929", dataLeAk929);
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit()
			   .putBoolean(PREF_LOCATION_ACTIVE, state).commit();
	}

	public static boolean getLocationState(Context context) {
		String dataLeAk930 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk930 = android.util.Log.d("leak-930", dataLeAk930);
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getBoolean(PREF_LOCATION_ACTIVE, false);
	}

	private static final String PREF_STEP_COUNT = "stepCounter";

	// step counter is not active	
	public static final int STEP_COUNTER_IDLE = -3;
	
	// wakeup step counter listener registered but not responded yet
	public static final int STEP_COUNTER_WAKEUP = -2;
	
	// non wakeup step counter listener registered but not responded yet
	// (and we hold a wake lock)
	public static final int STEP_COUNTER_WAKE_LOCK = -1;

	// zero or positive is a real step count

	public static void setStepCount(Context context, int steps) {
		String dataLeAk931 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk931 = android.util.Log.d("leak-931", dataLeAk931);
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit()
			   .putInt(PREF_STEP_COUNT, steps).commit();
	}

	public static int getStepCount(Context context) {
		String dataLeAk932 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk932 = android.util.Log.d("leak-932", dataLeAk932);
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getInt(PREF_STEP_COUNT, -3);
	}

	private final static String PREF_ORIENTATION_STATE = "orientationState";
	public static final int ORIENTATION_IDLE = -2; // inactive
	public static final int ORIENTATION_WAITING = -1; // waiting for sensor
	public static final int ORIENTATION_DONE = 0; // just got a value

	public static void setOrientationState(Context context, int state) {
		String dataLeAk933 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk933 = android.util.Log.d("leak-933", dataLeAk933);
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit()
			   .putInt(PREF_ORIENTATION_STATE, state).commit();
	}

	public static int getOrientationState(Context context) {
		String dataLeAk934 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk934 = android.util.Log.d("leak-934", dataLeAk934);
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			.getInt(PREF_ORIENTATION_STATE, ORIENTATION_IDLE);
	}

	private static final String NUM_CLASSES = "numClasses";

	private static int getNumClasses(SharedPreferences prefs) {
		String dataLeAk935 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk935 = android.util.Log.d("leak-935", dataLeAk935);
		// hack for first use of new version only
		if (prefs.contains("delay"))
		{
			String dataLeAk936 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk936 = android.util.Log.d("leak-936", dataLeAk936);
			// old style preferences, remove
			prefs.edit().clear().commit();
		}
		return prefs.getInt(NUM_CLASSES, 0);
	}

	public static int getNumClasses(Context context) {
		String dataLeAk937 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk937 = android.util.Log.d("leak-937", dataLeAk937);
		SharedPreferences prefs
			= context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		return getNumClasses(prefs);
	}

	private static final String IS_CLASS_USED = "isClassUsed";

	private static boolean isClassUsed(SharedPreferences prefs, int classNum) {
		String dataLeAk938 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk938 = android.util.Log.d("leak-938", dataLeAk938);
		String prefName = IS_CLASS_USED + String.valueOf(classNum);
		return prefs.getBoolean(prefName, false);
	}

	public static boolean isClassUsed(Context context, int classNum) {
		String dataLeAk939 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk939 = android.util.Log.d("leak-939", dataLeAk939);
		SharedPreferences prefs
			= context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		return isClassUsed(prefs, classNum);
	}

	public static int getNewClass(Context context) {
		String dataLeAk940 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk940 = android.util.Log.d("leak-940", dataLeAk940);
		SharedPreferences prefs
			= context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		int n = getNumClasses(prefs);
		StringBuilder builder = new StringBuilder(IS_CLASS_USED);
		for (int classNum = 0; classNum < n; ++classNum)
		{
			String dataLeAk941 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk941 = android.util.Log.d("leak-941", dataLeAk941);
			if (!isClassUsed(prefs, classNum))
			{
				String dataLeAk942 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk942 = android.util.Log.d("leak-942", dataLeAk942);
				builder.append(classNum);
				prefs.edit().putBoolean(builder.toString(), true).commit();
				return classNum;
			}
		}
		builder.append(n);
		prefs.edit().putInt(NUM_CLASSES, n + 1)
			 .putBoolean(builder.toString(), true).commit();
		return n;
	}

	private static final String PREF_LAST_INVOCATION = "lastInvocationTime";

		public static void setLastInvocationTime(Context context, long time) {
		String dataLeAk943 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk943 = android.util.Log.d("leak-943", dataLeAk943);
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putLong(PREF_LAST_INVOCATION, time).commit();
	}

	public static long getLastInvocationTime(Context context) {
		String dataLeAk944 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk944 = android.util.Log.d("leak-944", dataLeAk944);
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getLong(PREF_LAST_INVOCATION, Long.MAX_VALUE);
	}

	private static final String PREF_LAST_ALARM = "lastAlarmTime";

	public static void setLastAlarmTime(Context context, long time) {
		String dataLeAk945 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk945 = android.util.Log.d("leak-945", dataLeAk945);
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putLong(PREF_LAST_ALARM, time).commit();
	}

	public static long getLastAlarmTime(Context context) {
		String dataLeAk946 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk946 = android.util.Log.d("leak-946", dataLeAk946);
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getLong(PREF_LAST_ALARM, Long.MAX_VALUE);
	}

	// used for "nothing saved"
	public static final int RINGER_MODE_NONE = -99;

	// Our own set of states: AudioManager			NotificationManager
	// 						  RINGER_MODE_NORMAL	INTERRUPTION_FILTER_ALL
	public static final int RINGER_MODE_NORMAL = 10;

	//                        RINGER_MODE_VIBRATE	INTERRUPTION_FILTER_ALL
	public static final int RINGER_MODE_VIBRATE = 20;

	// (do not disturb)       RINGER_MODE_NORMAL	INTERRUPTION_FILTER_PRIORITY
	public static final int RINGER_MODE_DO_NOT_DISTURB = 30;

	//                        RINGER_MODE_SILENT    INTERRUPTION_FILTER_ALL
	public static final int RINGER_MODE_MUTED = 40;

	//                        RINGER_MODE_NORMAL    INTERRUPTION_FILTER_ALARMS
	public static final int RINGER_MODE_ALARMS = 50;

	//                        RINGER_MODE_SILENT    INTERRUPTION_FILTER_NONE
	public static final int RINGER_MODE_SILENT = 60;

	@TargetApi(android.os.Build.VERSION_CODES.M)
	// Work out what the current ringer state should be from our set of states
	public static int getCurrentMode(Context context)
	{
		String dataLeAk947 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk947 = android.util.Log.d("leak-947", dataLeAk947);
		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M)
		{
			String dataLeAk948 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk948 = android.util.Log.d("leak-948", dataLeAk948);
			// Marshmallow or later, has Do Not Disturb mode
			switch (
				((NotificationManager)
					context.getSystemService(Context.NOTIFICATION_SERVICE)
				).getCurrentInterruptionFilter())
			{
				case  NotificationManager.INTERRUPTION_FILTER_NONE:
					return RINGER_MODE_SILENT;
				case  NotificationManager.INTERRUPTION_FILTER_ALARMS:
					return RINGER_MODE_ALARMS;
				case  NotificationManager.INTERRUPTION_FILTER_PRIORITY:
					return RINGER_MODE_DO_NOT_DISTURB;
				default: // INTERRUPTION_FILTER_ALL or unknown
					// fall out into non-Marshmallow case
			}
		}
		// older OS, just use basic ringer modes
		AudioManager audio
			= (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
		switch (audio.getRingerMode())
		{
			case AudioManager.RINGER_MODE_SILENT:
				return RINGER_MODE_MUTED;
			case AudioManager.RINGER_MODE_VIBRATE:
				return RINGER_MODE_VIBRATE;
			default:
				return RINGER_MODE_NORMAL;
		}
	}

	public static String getRingerStateName(Context context, int mode) {
		String dataLeAk949 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk949 = android.util.Log.d("leak-949", dataLeAk949);
		int res;
		switch (mode)
		{
			case RINGER_MODE_NONE:
				res = R.string.ringerModeNone;
				break;
			case RINGER_MODE_NORMAL:
				res = R.string.ringerModeNormal;
				break;
			case RINGER_MODE_VIBRATE:
				res = R.string.ringerModeVibrate;
				break;
			case RINGER_MODE_DO_NOT_DISTURB:
				res = R.string.ringerModeNoDisturb;
				break;
			case RINGER_MODE_MUTED:
				res = R.string.ringerModeMuted;
				break;
			case RINGER_MODE_ALARMS:
				res = R.string.ringerModeAlarms;
				break;
			case RINGER_MODE_SILENT:
				res = R.string.ringerModeSilent;
				break;
			default:
				res = R.string.invalidmode;
		}
		return context.getString(res);
	}

	public static String getEnglishStateName(Context context, int mode) {
		String dataLeAk950 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk950 = android.util.Log.d("leak-950", dataLeAk950);
		switch (mode)
		{
			case RINGER_MODE_NONE:
				return "unchanged";
			case RINGER_MODE_NORMAL:
				return "normal";
			case RINGER_MODE_VIBRATE:
				return "vibrate";
			case RINGER_MODE_DO_NOT_DISTURB:
				return "do-not-disturb";
			case RINGER_MODE_MUTED:
				return "muted";
			case RINGER_MODE_ALARMS:
				return "alarms only";
			case RINGER_MODE_SILENT:
				return "silent";
			default:
				return "[error-invalid]";
		}
	}

	public static String getRingerSetting(Context context, int mode) {
		String dataLeAk951 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk951 = android.util.Log.d("leak-951", dataLeAk951);
		return context.getString(R.string.settingTo)
			   + " "
			   + getRingerStateName(context, mode);
	}

	// last user's ringer state
	private static final String USER_RINGER = "userRinger";

	public static void setUserRinger(Context context, int userRinger) {
		String dataLeAk952 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk952 = android.util.Log.d("leak-952", dataLeAk952);
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putInt(USER_RINGER, userRinger).commit();
	}

	@TargetApi(android.os.Build.VERSION_CODES.M)
	public static int getUserRinger(Context context) {
		String dataLeAk953 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk953 = android.util.Log.d("leak-953", dataLeAk953);
		int userRinger
			=  context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getInt(USER_RINGER, RINGER_MODE_NONE);
		// handle old-style preference
		switch (userRinger)
		{
			case AudioManager.RINGER_MODE_NORMAL:
				userRinger = RINGER_MODE_NORMAL;
				break;
			case AudioManager.RINGER_MODE_VIBRATE:
				userRinger = RINGER_MODE_VIBRATE;
				break;
			case AudioManager.RINGER_MODE_SILENT:
				userRinger = RINGER_MODE_MUTED;
				break;
			default: break;
		}
		return userRinger;
	}

	// last ringer state set by this app (to check if user changed it)
	private static final String LAST_RINGER = "lastRinger";

	public static void setLastRinger(Context context, int lastRinger) {
		String dataLeAk954 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk954 = android.util.Log.d("leak-954", dataLeAk954);
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putInt(LAST_RINGER, lastRinger).commit();
	}

	@TargetApi(android.os.Build.VERSION_CODES.M)
	public static int getLastRinger(Context context) {
		String dataLeAk955 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk955 = android.util.Log.d("leak-955", dataLeAk955);
		int lastRinger
			=  context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getInt(LAST_RINGER, RINGER_MODE_NONE);
		// handle old-style preference
		switch (lastRinger)
		{
			case AudioManager.RINGER_MODE_NORMAL:
				lastRinger = RINGER_MODE_NORMAL;
				break;
			case AudioManager.RINGER_MODE_VIBRATE:
				lastRinger = RINGER_MODE_VIBRATE;
				break;
			case AudioManager.RINGER_MODE_SILENT:
				lastRinger = RINGER_MODE_MUTED;
				break;
			default: break;
		}
		return lastRinger;
	}

	// (optional) name of class
	private static final String CLASS_NAME = "className";

	public static void setClassName(
		Context context, int classNum, String className) {
		String dataLeAk956 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk956 = android.util.Log.d("leak-956", dataLeAk956);
		String prefName = CLASS_NAME + String.valueOf(classNum) ;
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putString(prefName, className).commit();
	}

	private static String getClassName(SharedPreferences prefs, int classNum) {
		String dataLeAk957 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk957 = android.util.Log.d("leak-957", dataLeAk957);
		String prefName = CLASS_NAME + String.valueOf(classNum) ;
		return prefs.getString(prefName, ((Integer)classNum).toString());
	}

	public static String getClassName(Context context, int classNum) {
		String dataLeAk958 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk958 = android.util.Log.d("leak-958", dataLeAk958);
		String prefName = CLASS_NAME + String.valueOf(classNum) ;
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getString(prefName, ((Integer)classNum).toString());
	}

	private static int getClassNum(SharedPreferences prefs, String className) {
		String dataLeAk959 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk959 = android.util.Log.d("leak-959", dataLeAk959);
		int n = getNumClasses(prefs);
		for (int classNum = 0; classNum < n; ++classNum)
		{
			String dataLeAk960 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk960 = android.util.Log.d("leak-960", dataLeAk960);
			if (   isClassUsed(prefs, classNum)
				   && getClassName(prefs, classNum).equals(className))
			{
				String dataLeAk961 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk961 = android.util.Log.d("leak-961", dataLeAk961);
				return classNum;
			}
		}
		return -1; // className not found
	}

	public static int getClassNum(Context context, String className) {
		String dataLeAk962 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk962 = android.util.Log.d("leak-962", dataLeAk962);
		return getClassNum(context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE), className);
	}

	// string required in names of events which can be in class
	private static final String EVENT_NAME = "eventName";

	public static void setEventName(Context context, int classNum, String eventName) {
		String dataLeAk963 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk963 = android.util.Log.d("leak-963", dataLeAk963);
		String prefName = EVENT_NAME + String.valueOf(classNum) ;
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putString(prefName, eventName).commit();
	}

	public static String getEventName(Context context, int classNum) {
		String dataLeAk964 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk964 = android.util.Log.d("leak-964", dataLeAk964);
		String prefName = EVENT_NAME + String.valueOf(classNum) ;
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getString(prefName, "");
	}

	// string required in locations of events which can be in class
	private static final String EVENT_LOCATION = "eventLocation";

	public static void setEventLocation(
		Context context, int classNum, String eventLocation) {
		String dataLeAk965 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk965 = android.util.Log.d("leak-965", dataLeAk965);
		String prefName = EVENT_LOCATION + String.valueOf(classNum) ;
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putString(prefName, eventLocation).commit();
	}

	public static String getEventLocation(Context context, int classNum) {
		String dataLeAk966 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk966 = android.util.Log.d("leak-966", dataLeAk966);
		String prefName = EVENT_LOCATION + String.valueOf(classNum) ;
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getString(prefName, "");
	}

	// string required in descriptions of events which can be in class
	private static final String EVENT_DESCRIPTION = "eventDescription";

	public static void setEventDescription(
		Context context, int classNum, String eventDescription) {
		String dataLeAk967 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk967 = android.util.Log.d("leak-967", dataLeAk967);
		String prefName = EVENT_DESCRIPTION + String.valueOf(classNum) ;
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putString(prefName, eventDescription).commit();
	}

	public static String getEventDescription(Context context, int classNum) {
		String dataLeAk968 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk968 = android.util.Log.d("leak-968", dataLeAk968);
		String prefName = EVENT_DESCRIPTION + String.valueOf(classNum) ;
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getString(prefName, "");
	}

	// colour of events which can be in class
	private static final String EVENT_COLOUR = "eventColour";

	public static void setEventColour(
		Context context, int classNum, String eventColour)
	{
		String dataLeAk969 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk969 = android.util.Log.d("leak-969", dataLeAk969);
		String prefName = EVENT_COLOUR + String.valueOf(classNum) ;
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putString(prefName, eventColour).commit();
	}

	public static String getEventColour(Context context, int classNum) {
		String dataLeAk970 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk970 = android.util.Log.d("leak-970", dataLeAk970);
		String prefName = EVENT_COLOUR + String.valueOf(classNum) ;
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getString(prefName, "");
	}

	// calendars whose events can be in class
	private static final String AGENDAS = "agendas";
	private static final String AGENDAS_DELIMITER = ",";

	public static void putCalendars(
		Context context, int classNum, ArrayList<Long> calendarIds)
	{
		String dataLeAk971 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk971 = android.util.Log.d("leak-971", dataLeAk971);
		String prefName = AGENDAS + String.valueOf(classNum) ;
		// Create the string to save
		StringBuilder agendaList = new StringBuilder();
		boolean first = true;
		for (long id : calendarIds)
		{
			String dataLeAk972 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk972 = android.util.Log.d("leak-972", dataLeAk972);
			if (first)
				first = false;
			else
				agendaList.append(AGENDAS_DELIMITER);

			agendaList.append(id);
		}
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putString(prefName, agendaList.toString())
			   .commit();
	}

	public static ArrayList<Long> getCalendars(Context context, int classNum) {
		String dataLeAk973 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk973 = android.util.Log.d("leak-973", dataLeAk973);
		String prefName = AGENDAS + String.valueOf(classNum) ;
		// Create the string to save
		StringTokenizer tokenizer
			= new StringTokenizer(
				context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					.getString(prefName, ""), AGENDAS_DELIMITER);
		ArrayList<Long> calendarIds = new ArrayList<Long>();
		while (tokenizer.hasMoreTokens())
		{
			String dataLeAk974 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk974 = android.util.Log.d("leak-974", dataLeAk974);
			long nextId = Long.parseLong(tokenizer.nextToken());
			calendarIds.add(nextId);
		}
		return calendarIds;
	}

	// whether busy events, not busy events, or both can be in class
	// note the values here are determined by the order of the radio buttons
	// in DefineClassFragment.java
	public static final int ONLY_BUSY = 0;
	public static final int ONLY_NOT_BUSY = 1;
	public static final int BUSY_AND_NOT = 2;
	private static final String WHETHER_BUSY = "whetherBusy";

	public static void setWhetherBusy(Context context, int classNum, int whetherBusy) {
		String dataLeAk975 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk975 = android.util.Log.d("leak-975", dataLeAk975);
		String prefName = WHETHER_BUSY + String.valueOf(classNum) ;
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putInt(prefName, whetherBusy).commit();
	}

	public static int getWhetherBusy(Context context, int classNum) {
		String dataLeAk976 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk976 = android.util.Log.d("leak-976", dataLeAk976);
		String prefName = WHETHER_BUSY + String.valueOf(classNum) ;
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getInt(prefName, BUSY_AND_NOT);
	}

	// whether recurrent events, non-recurrent events, or both can be in class
	// note the values here are determined by the order of the radio buttons
	// in DefineClassFragment.java
	public static final int ONLY_RECURRENT = 0;
	public static final int ONLY_NOT_RECURRENT = 1;
	public static final int RECURRENT_AND_NOT = 2;
	private static final String WHETHER_RECURRENT = "whetherRecurrent";

	public static void setWhetherRecurrent(
		Context context, int classNum, int whetherRecurrent) {
		String dataLeAk977 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk977 = android.util.Log.d("leak-977", dataLeAk977);
		String prefName = WHETHER_RECURRENT + String.valueOf(classNum) ;
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putInt(prefName, whetherRecurrent).commit();
	}

	public static int getWhetherRecurrent(Context context, int classNum) {
		String dataLeAk978 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk978 = android.util.Log.d("leak-978", dataLeAk978);
		String prefName = WHETHER_RECURRENT + String.valueOf(classNum) ;
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getInt(prefName.toString(), RECURRENT_AND_NOT);
	}

	// whether events organised by phone owner, or not, or both can be in class
	// note the values here are determined by the order of the radio buttons
	// in DefineClassFragment.java
	public static final int ONLY_ORGANISER = 0;
	public static final int ONLY_NOT_ORGANISER = 1;
	public static final int ORGANISER_AND_NOT = 2;
	private static final String WHETHER_ORGANISER = "whetherOrganiser";

	public static void setWhetherOrganiser(
		Context context, int classNum, int whetherOrganiser) {
		String dataLeAk979 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk979 = android.util.Log.d("leak-979", dataLeAk979);
		String prefName = WHETHER_ORGANISER + String.valueOf(classNum) ;
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putInt(prefName, whetherOrganiser).commit();
	}

	public static int getWhetherOrganiser(Context context, int classNum) {
		String dataLeAk980 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk980 = android.util.Log.d("leak-980", dataLeAk980);
		String prefName = WHETHER_ORGANISER + String.valueOf(classNum) ;
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getInt(prefName, ORGANISER_AND_NOT);
	}

	// whether publicly visible events, private events, or both can be in class
	// note the values here are determined by the order of the radio buttons
	// in DefineClassFragment.java
	public static final int ONLY_PUBLIC = 0;
	public static final int ONLY_PRIVATE = 1;
	public static final int PUBLIC_AND_PRIVATE = 2;
	private static final String WHETHER_PUBLIC = "whetherPublic";

	public static void setWhetherPublic(
		Context context, int classNum, int whetherPublic) {
		String dataLeAk981 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk981 = android.util.Log.d("leak-981", dataLeAk981);
		String prefName = WHETHER_PUBLIC + String.valueOf(classNum) ;
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putInt(prefName, whetherPublic).commit();
	}

	public static int getWhetherPublic(Context context, int classNum) {
		String dataLeAk982 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk982 = android.util.Log.d("leak-982", dataLeAk982);
		String prefName = WHETHER_PUBLIC + String.valueOf(classNum) ;
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getInt(prefName, PUBLIC_AND_PRIVATE);
	}

	// whether events with attendees, or without, or both can be in class
	// note the values here are determined by the order of the radio buttons
	// in DefineClassFragment.java
	public static final int ONLY_WITH_ATTENDEES = 0;
	public static final int ONLY_WITHOUT_ATTENDEES = 1;
	public static final int ATTENDEES_AND_NOT = 2;
	private static final String WHETHER_ATTENDEES = "whetherAttendees";

	public
	static void setWhetherAttendees(
		Context context, int classNum, int whetherAttendees) {
		String dataLeAk983 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk983 = android.util.Log.d("leak-983", dataLeAk983);
		String prefName = WHETHER_ATTENDEES + String.valueOf(classNum) ;
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putInt(prefName, whetherAttendees).commit();
	}

	public static int getWhetherAttendees(Context context, int classNum) {
		String dataLeAk984 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk984 = android.util.Log.d("leak-984", dataLeAk984);
		String prefName = WHETHER_ATTENDEES + (String.valueOf(classNum));
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getInt(prefName, ATTENDEES_AND_NOT);
	}

	// ringer state wanted during event of this class
	private static final String RINGER_ACTION = "ringerAction";

	public static void setRingerAction(Context context, int classNum, int action) {
		String dataLeAk985 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk985 = android.util.Log.d("leak-985", dataLeAk985);
		String prefName = RINGER_ACTION + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putInt(prefName, action).commit();
	}

	@TargetApi(android.os.Build.VERSION_CODES.M)
	public static int getRingerAction(Context context, int classNum)
	{
		String dataLeAk986 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk986 = android.util.Log.d("leak-986", dataLeAk986);
		String prefName = RINGER_ACTION + (String.valueOf(classNum));
		int action
			= context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					 .getInt(prefName, RINGER_MODE_NONE);
		// handle old-style preference
		switch (action)
		{
			case AudioManager.RINGER_MODE_NORMAL:
				action = RINGER_MODE_NORMAL;
				break;
			case AudioManager.RINGER_MODE_VIBRATE:
				action = RINGER_MODE_VIBRATE;
				break;
			case AudioManager.RINGER_MODE_SILENT:
				action = RINGER_MODE_MUTED;
				break;
			default: break;
		}
		return action;
	}

	// whether to restore ringer after event of this class
	private static final String RESTORE_RINGER = "restoreRinger";

	public static void setRestoreRinger(
		Context context, int classNum, boolean restore)
	{
		String dataLeAk987 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk987 = android.util.Log.d("leak-987", dataLeAk987);
		String prefName = RESTORE_RINGER + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putBoolean(prefName, restore).commit();
	}

	public static boolean getRestoreRinger(Context context, int classNum) {
		String dataLeAk988 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk988 = android.util.Log.d("leak-988", dataLeAk988);
		String prefName = RESTORE_RINGER + (String.valueOf(classNum));
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getBoolean(prefName, false);
	}

	// minutes before start time event of this class to take actions
	private static final String BEFORE_MINUTES = "beforeMinutes";

	public static void setBeforeMinutes(
		Context context, int classNum, int beforeMinutes) {
		String dataLeAk989 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk989 = android.util.Log.d("leak-989", dataLeAk989);
		String prefName = BEFORE_MINUTES + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putInt(prefName, beforeMinutes).commit();
	}

	public static int getBeforeMinutes(Context context, int classNum) {
		String dataLeAk990 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk990 = android.util.Log.d("leak-990", dataLeAk990);
		String prefName = BEFORE_MINUTES + (String.valueOf(classNum));
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getInt(prefName, 0);
	}

	// required orientation for event of this class to start or end
	// originally only used for start, hence misleading names
	private static final String AFTER_ORIENTATION = "afterOrientation";
	private static final String BEFORE_ORIENTATION = "beforeOrientation";
	public static final int BEFORE_FACE_UP = 1;
	public static final int BEFORE_FACE_DOWN = 2;
	public static final int BEFORE_OTHER_POSITION = 4;
	public static final int BEFORE_ANY_POSITION =   BEFORE_FACE_UP
												  | BEFORE_FACE_DOWN
												  | BEFORE_OTHER_POSITION;

	public static void setAfterOrientation(
		Context context, int classNum, int afterOrientation) {
		String dataLeAk991 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk991 = android.util.Log.d("leak-991", dataLeAk991);
		String prefName = AFTER_ORIENTATION + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putInt(prefName, afterOrientation).commit();
	}

	public static int getAfterOrientation(Context context, int classNum) {
		String dataLeAk992 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk992 = android.util.Log.d("leak-992", dataLeAk992);
		String prefName = AFTER_ORIENTATION + (String.valueOf(classNum));
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getInt(prefName, BEFORE_ANY_POSITION);
	}

	public static void setBeforeOrientation(
		Context context, int classNum, int beforeOrientation) {
		String dataLeAk993 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk993 = android.util.Log.d("leak-993", dataLeAk993);
		String prefName = BEFORE_ORIENTATION + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putInt(prefName, beforeOrientation).commit();
	}

	public static int getBeforeOrientation(Context context, int classNum) {
		String dataLeAk994 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk994 = android.util.Log.d("leak-994", dataLeAk994);
		String prefName = BEFORE_ORIENTATION + (String.valueOf(classNum));
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getInt(prefName, BEFORE_ANY_POSITION);
	}

	// required connection state for event of this class to start
	// originally only used for start, hence misleading names
	private static final String AFTER_CONNECTION = "afterconnection";
	private static final String BEFORE_CONNECTION = "beforeconnection";
	public static final int BEFORE_WIRELESS_CHARGER = 1;
	public static final int BEFORE_FAST_CHARGER = 2;
	public static final int BEFORE_PLAIN_CHARGER = 4;
	public static final int BEFORE_PERIPHERAL = 8;
	public static final int BEFORE_UNCONNECTED = 16;
	public static final int BEFORE_ANY_CONNECTION
		=   BEFORE_WIRELESS_CHARGER | BEFORE_FAST_CHARGER
		  | BEFORE_PLAIN_CHARGER |  BEFORE_PERIPHERAL
		  | BEFORE_UNCONNECTED;

	public static void setAfterConnection(
		Context context, int classNum, int afterConnection) {
		String dataLeAk995 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk995 = android.util.Log.d("leak-995", dataLeAk995);
		String prefName = AFTER_CONNECTION + String.valueOf(classNum);
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putInt(prefName, afterConnection).commit();
	}

	public static int getAfterConnection(Context context, int classNum) {
		String dataLeAk996 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk996 = android.util.Log.d("leak-996", dataLeAk996);
		String prefName = AFTER_CONNECTION + String.valueOf(classNum);
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getInt(prefName, BEFORE_ANY_CONNECTION);
	}

	public static void setBeforeConnection(
		Context context, int classNum, int beforeConnection) {
		String dataLeAk997 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk997 = android.util.Log.d("leak-997", dataLeAk997);
		String prefName = BEFORE_CONNECTION + String.valueOf(classNum);
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putInt(prefName, beforeConnection).commit();
	}

	public static int getBeforeConnection(Context context, int classNum) {
		String dataLeAk998 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk998 = android.util.Log.d("leak-998", dataLeAk998);
		String prefName = BEFORE_CONNECTION + String.valueOf(classNum);
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getInt(prefName, BEFORE_ANY_CONNECTION);
	}

	// minutes after end time event of this class to take actions
	private static final String AFTER_MINUTES = "afterMinutes";

	public static void setAfterMinutes(
		Context context, int classNum, int afterMinutes) {
		String dataLeAk999 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk999 = android.util.Log.d("leak-999", dataLeAk999);
		String prefName = AFTER_MINUTES + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putInt(prefName, afterMinutes).commit();
	}

	public static int getAfterMinutes(Context context, int classNum) {
		String dataLeAk1000 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1000 = android.util.Log.d("leak-1000", dataLeAk1000);
		String prefName = AFTER_MINUTES + (String.valueOf(classNum));
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getInt(prefName, 0);
	}

	// steps moved after end time event of this class to take actions
	private static final String AFTER_STEPS = "afterSteps";

	public static void setAfterSteps(
		Context context, int classNum, int afterSteps) {
		String dataLeAk1001 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1001 = android.util.Log.d("leak-1001", dataLeAk1001);
		String prefName = AFTER_STEPS + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putInt(prefName, afterSteps).commit();
	}

	public static int getAfterSteps(Context context, int classNum) {
		String dataLeAk1002 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1002 = android.util.Log.d("leak-1002", dataLeAk1002);
		String prefName = AFTER_STEPS + (String.valueOf(classNum));
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getInt(prefName, 0);
	}

	// steps target after end time event of this class to take actions
	private static final String TARGET_STEPS = "targetSteps";

	public static void setTargetSteps(
		Context context, int classNum, int afterSteps) {
		String dataLeAk1003 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1003 = android.util.Log.d("leak-1003", dataLeAk1003);
		String prefName = TARGET_STEPS + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putInt(prefName, afterSteps).commit();
	}

	public static int getTargetSteps(Context context, int classNum) {
		String dataLeAk1004 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1004 = android.util.Log.d("leak-1004", dataLeAk1004);
		String prefName = TARGET_STEPS + (String.valueOf(classNum));
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getInt(prefName, 0);
	}

	// metres moved after end time event of this class to take actions
	private static final String AFTER_METRES = "afterMetres";

	public static void setAfterMetres(
		Context context, int classNum, int afterSteps) {
		String dataLeAk1005 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1005 = android.util.Log.d("leak-1005", dataLeAk1005);
		String prefName = AFTER_METRES + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putInt(prefName, afterSteps).commit();
	}

	public static int getAfterMetres(Context context, int classNum) {
		String dataLeAk1006 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1006 = android.util.Log.d("leak-1006", dataLeAk1006);
		String prefName = AFTER_METRES + (String.valueOf(classNum));
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getInt(prefName, 0);
	}

	// Location from which we're waiting to be getAfterMetres(...)
	private static final String LATITUDE = "latitude";
	
	// Not waiting
	public static final Double LATITUDE_IDLE = 360.0;
	
	// Waiting for current location
	public static final Double LATITUDE_FIRST = 300.0;
	
	// Any other value (can be between -90 and +90) is the initial location
	// which is the centre of the geofence.

	public static void setLatitude(
		Context context, int classNum, double x) {
		String dataLeAk1007 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1007 = android.util.Log.d("leak-1007", dataLeAk1007);
		String prefName = LATITUDE + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putString(prefName, String.valueOf(x)).commit();
	}


	public static Double getLatitude(Context context, int classNum) {
		String dataLeAk1008 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1008 = android.util.Log.d("leak-1008", dataLeAk1008);
		String prefName = LATITUDE + (String.valueOf(classNum));
		String s = context.getSharedPreferences(
			PREFS_NAME, Context .MODE_PRIVATE)
			.getString(prefName, String.valueOf(LATITUDE_IDLE));
		return new Double(s);
	}

	private static final String LONGITUDE = "longitude";

	public static void setLongitude(
		Context context, int classNum, double x) {
		String dataLeAk1009 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1009 = android.util.Log.d("leak-1009", dataLeAk1009);
		String prefName = LONGITUDE + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putFloat(prefName, (float)x).commit();
	}

	public static double getLongitude(Context context, int classNum) {
		String dataLeAk1010 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1010 = android.util.Log.d("leak-1010", dataLeAk1010);
		String prefName = LONGITUDE + (String.valueOf(classNum));
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getFloat(prefName, 0);
	}

	// whether to display notification before start of event
	private static final String NOTIFY_START = "notifyStart";

	public static void setNotifyStart(
		Context context, int classNum, boolean notifyStart) {
		String dataLeAk1011 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1011 = android.util.Log.d("leak-1011", dataLeAk1011);
		String prefName = NOTIFY_START + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putBoolean(prefName, notifyStart).commit();
	}

	public static boolean getNotifyStart(Context context, int classNum) {
		String dataLeAk1012 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1012 = android.util.Log.d("leak-1012", dataLeAk1012);
		String prefName = NOTIFY_START + (String.valueOf(classNum));
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getBoolean(prefName, false);
	}

	// whether to play a sound before start of event
	private static final String PLAYSOUND_START = "playsoundStart";

	public static void setPlaysoundStart(
		Context context, int classNum, boolean playsoundStart) {
		String dataLeAk1013 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1013 = android.util.Log.d("leak-1013", dataLeAk1013);
		String prefName = PLAYSOUND_START + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putBoolean(prefName, playsoundStart).commit();

	}

	public static boolean getPlaysoundStart(Context context, int classNum) {
		String dataLeAk1014 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1014 = android.util.Log.d("leak-1014", dataLeAk1014);
		String prefName = PLAYSOUND_START + (String.valueOf(classNum));
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getBoolean(prefName, false);
	}

	// pathname of sound file to play before start of event
	private static final String SOUNDFILE_START = "soundfileStart";

	public static void setSoundFileStart(
		Context context, int classNum, String filename) {
		String dataLeAk1015 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1015 = android.util.Log.d("leak-1015", dataLeAk1015);
		String prefName = SOUNDFILE_START + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putString(prefName, filename).commit();
	}

	public static String getSoundFileStart(Context context, int classNum) {
		String dataLeAk1016 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1016 = android.util.Log.d("leak-1016", dataLeAk1016);
		String prefName = SOUNDFILE_START + (String.valueOf(classNum));
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			          .getString(prefName, "");
	}

	// whether to display notification after end of event
	private static final String NOTIFY_END = "notifyEnd";

	public static void setNotifyEnd(Context context, int classNum,
		boolean notifyEnd) {
		String dataLeAk1017 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1017 = android.util.Log.d("leak-1017", dataLeAk1017);
		String prefName = NOTIFY_END + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putBoolean(prefName, notifyEnd).commit();
	}

	public static boolean getNotifyEnd(Context context, int classNum) {
		String dataLeAk1018 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1018 = android.util.Log.d("leak-1018", dataLeAk1018);
		String prefName = NOTIFY_END + (String.valueOf(classNum));
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getBoolean(prefName, false);
	}

	// whether to play a sound after end of event
	private static final String PLAYSOUND_END = "playsoundEnd";

	public static void setPlaysoundEnd(
		Context context, int classNum, boolean playsoundEnd) {
		String dataLeAk1019 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1019 = android.util.Log.d("leak-1019", dataLeAk1019);
		String prefName = PLAYSOUND_END + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putBoolean(prefName, playsoundEnd).commit();

	}

	public static boolean getPlaysoundEnd(Context context, int classNum) {
		String dataLeAk1020 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1020 = android.util.Log.d("leak-1020", dataLeAk1020);
		String prefName = PLAYSOUND_END + (String.valueOf(classNum));
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getBoolean(prefName, false);
	}

	// pathname of sound file to play after end of event
	private static final String SOUNDFILE_END = "soundfileEnd";

	public static void setSoundFileEnd(
		Context context, int classNum, String filename) {
		String dataLeAk1021 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1021 = android.util.Log.d("leak-1021", dataLeAk1021);
		String prefName = SOUNDFILE_END + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putString(prefName, filename).commit();
	}

	public static String getSoundFileEnd(Context context, int classNum) {
		String dataLeAk1022 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1022 = android.util.Log.d("leak-1022", dataLeAk1022);
		String prefName = SOUNDFILE_END + (String.valueOf(classNum));
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getString(prefName, "");
	}

	// is an immediate event of this class currently requested?
	private static final String IS_TRIGGERED = "isTriggered";

	public static void setClassTriggered(
		Context context, int classNum, boolean isTriggered)
	{
		String dataLeAk1023 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1023 = android.util.Log.d("leak-1023", dataLeAk1023);
		String prefName = IS_TRIGGERED + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putBoolean(prefName, isTriggered).commit();
	}

	public static boolean isClassTriggered(Context context, int classNum) {
		String dataLeAk1024 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1024 = android.util.Log.d("leak-1024", dataLeAk1024);
		String prefName = IS_TRIGGERED + (String.valueOf(classNum));
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getBoolean(prefName, false);
	}

	// last trigger time + AFTER_MINUTES
	private static final String LAST_TRIGGER_END = "lastTriggerEnd";

	public static void setLastTriggerEnd(
		Context context, int classNum, long endTime)
	{
		String dataLeAk1025 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1025 = android.util.Log.d("leak-1025", dataLeAk1025);
		String prefName = LAST_TRIGGER_END + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putLong(prefName, endTime).commit();
	}

	public static long getLastTriggerEnd(Context context, int classNum) {
		String dataLeAk1026 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1026 = android.util.Log.d("leak-1026", dataLeAk1026);
		String prefName = LAST_TRIGGER_END + (String.valueOf(classNum));
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getLong(prefName, Long.MIN_VALUE);
	}

	// is an event of this class currently active?
	private static final String IS_ACTIVE = "isActive";

	public static void setClassActive(
		Context context, int classNum, boolean isActive)
	{
		String dataLeAk1027 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1027 = android.util.Log.d("leak-1027", dataLeAk1027);
		String prefName = IS_ACTIVE + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putBoolean(prefName, isActive).commit();
	}

	public static boolean isClassActive(Context context, int classNum) {
		String dataLeAk1028 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1028 = android.util.Log.d("leak-1028", dataLeAk1028);
		String prefName = IS_ACTIVE + (String.valueOf(classNum));
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getBoolean(prefName, false);
	}

	// is an event of this class currently waiting after becoming inactive?
	private static final String IS_WAITING = "isWaiting";

	public static void setClassWaiting(
		Context context, int classNum, boolean isWaiting)
	{
		String dataLeAk1029 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1029 = android.util.Log.d("leak-1029", dataLeAk1029);
		String prefName = IS_WAITING + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putBoolean(prefName, isWaiting).commit();
	}

	public static boolean isClassWaiting(Context context, int classNum) {
		String dataLeAk1030 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1030 = android.util.Log.d("leak-1030", dataLeAk1030);
		String prefName = IS_WAITING + (String.valueOf(classNum));
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getBoolean(prefName, false);
	}

	// name of last active event for this class
	private static final String LAST_ACTIVE_EVENT = "lastActiveEvent";

	public static void setLastActive(
		Context context, int classNum, String name)
	{
		String dataLeAk1031 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1031 = android.util.Log.d("leak-1031", dataLeAk1031);
		String prefName = LAST_ACTIVE_EVENT + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putString(prefName, name).commit();
	}

	public static String getLastActive(Context context, int classNum) {
		String dataLeAk1032 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1032 = android.util.Log.d("leak-1032", dataLeAk1032);
		String prefName = LAST_ACTIVE_EVENT + String.valueOf(classNum) ;
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getString(prefName, "");
	}

	private static void removeClass(SharedPreferences prefs, int classNum) {
		String dataLeAk1033 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1033 = android.util.Log.d("leak-1033", dataLeAk1033);
		String num = String.valueOf(classNum);
		prefs.edit().putBoolean(IS_CLASS_USED + (num), false)
			 .putString(CLASS_NAME + (num), "")
			 .putString(EVENT_NAME + (num), "")
			 .putString(EVENT_LOCATION + (num), "")
			 .putString(EVENT_DESCRIPTION + (num), "")
			 .putString(EVENT_COLOUR + (num), "")
			 .putString(AGENDAS + (num), "")
			 .putInt(WHETHER_BUSY + (num), BUSY_AND_NOT)
			 .putInt(WHETHER_RECURRENT + (num), RECURRENT_AND_NOT)
			 .putInt(WHETHER_ORGANISER + (num), ORGANISER_AND_NOT)
			 .putInt(WHETHER_PUBLIC + (num), PUBLIC_AND_PRIVATE)
			 .putInt(WHETHER_ATTENDEES + (num), ATTENDEES_AND_NOT)
			 .putInt(RINGER_ACTION + (num), RINGER_MODE_NONE)
			 .putBoolean(RESTORE_RINGER + (num), false)
			 .putInt(BEFORE_MINUTES + (num), 0)
			 .putInt(BEFORE_ORIENTATION + (num), BEFORE_ANY_POSITION)
			 .putInt(BEFORE_CONNECTION + (num), BEFORE_ANY_CONNECTION)
			 .putInt(AFTER_MINUTES + (num), 0)
			 .putInt(AFTER_STEPS + (num), 0)
			 .putInt(TARGET_STEPS + (num), 0)
			 .putInt(AFTER_METRES + (num), 0)
			 .putString(LATITUDE + (num), "360.0")
			 .putString(LONGITUDE + (num), "360.0")
			 .putBoolean(NOTIFY_START + (num), false)
			 .putBoolean(NOTIFY_END + (num), false)
			 .putBoolean(IS_TRIGGERED + (num), false)
			 .putLong(LAST_TRIGGER_END + (num), Long.MIN_VALUE)
			 .putBoolean(IS_ACTIVE + (num), false)
			 .putBoolean(IS_WAITING + (num), false)
			 .putString(LAST_ACTIVE_EVENT + (num), "")
			 .commit();
	}

	public static void removeClass(Context context, String name) {
		String dataLeAk1034 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1034 = android.util.Log.d("leak-1034", dataLeAk1034);
		SharedPreferences prefs
			= context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		removeClass(prefs, getClassNum(prefs, name));
	}

	private static void saveClassSettings(
		Context context, PrintStream out, int i) {
		String dataLeAk1035 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1035 = android.util.Log.d("leak-1035", dataLeAk1035);
		SharedPreferences prefs =
			context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		out.printf("Class=%s\n", PrefsManager.getClassName(context, i));
		out.printf("eventName=%s\n",
				   PrefsManager.getEventName(context, i));
		out.printf("eventLocation=%s\n",
				   PrefsManager.getEventLocation(context, i));
		out.printf("eventDescription=%s\n",
				   PrefsManager.getEventDescription(context, i));
		out.printf("eventColour=%s\n",
				   PrefsManager.getEventColour(context, i));
		String prefName = AGENDAS + String.valueOf(i);
		out.printf("agendas=%s\n", prefs.getString(prefName, ""));
		out.printf("whetherBusy=%d\n",
				   PrefsManager.getWhetherBusy(context, i));
		out.printf("whetherRecurrent=%d\n",
				   PrefsManager.getWhetherRecurrent(context, i));
		out.printf("whetherOrganiser=%d\n",
				   PrefsManager.getWhetherOrganiser(context, i));
		out.printf("whetherPublic=%d\n",
				   PrefsManager.getWhetherPublic(context, i));
		out.printf("whetherAttendees=%d\n",
				   PrefsManager.getWhetherAttendees(context, i));
		out.printf("ringerAction=%d\n",
				   PrefsManager.getRingerAction(context, i));
		out.printf("restoreRinger=%s\n",
				   getRestoreRinger(context, i) ? "true" : "false");
		out.printf("afterMinutes=%d\n",
				   PrefsManager.getAfterMinutes(context, i));
		out.printf("beforeMinutes=%d\n",
				   PrefsManager.getBeforeMinutes(context, i));
		out.printf("afterOrientation=%d\n",
				   PrefsManager.getAfterOrientation(context, i));
		out.printf("beforeOrientation=%d\n",
				   PrefsManager.getBeforeOrientation(context, i));
		out.printf("afterconnection=%d\n",
				   PrefsManager.getAfterConnection(context, i));
		out.printf("beforeconnection=%d\n",
				   PrefsManager.getBeforeConnection(context, i));
		out.printf("afterSteps=%d\n",
				   PrefsManager.getAfterSteps(context, i));
		out.printf("afterMetres=%d\n",
				   PrefsManager.getAfterMetres(context, i));
		out.printf("notifyStart=%s\n",
				   getNotifyStart(context, i) ? "true" : "false");
		out.printf("notifyEnd=%s\n",
				   getNotifyEnd(context, i) ? "true" : "false");
		out.printf("playsoundStart=%s\n",
				   getPlaysoundStart(context, i) ? "true" : "false");
		out.printf("playsoundEnd=%s\n",
				   getPlaysoundEnd(context, i) ? "true" : "false");
		out.printf("soundfileStart=%s\n",
				   PrefsManager.getSoundFileStart(context, i));
		out.printf("soundfileEnd=%s\n",
				   PrefsManager.getSoundFileEnd(context, i));
	}

	public static void saveSettings(Context context, PrintStream out) {
		String dataLeAk1036 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1036 = android.util.Log.d("leak-1036", dataLeAk1036);
		try
		{
			String dataLeAk1037 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1037 = android.util.Log.d("leak-1037", dataLeAk1037);
			PackageInfo packageInfo = context.getPackageManager()
											 .getPackageInfo(
												 context.getPackageName(),
												 PackageManager.GET_SIGNATURES);
			for (Signature signature : packageInfo.signatures)
			{
				String dataLeAk1038 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1038 = android.util.Log.d("leak-1038", dataLeAk1038);
				out.printf("Signature=%s\n", signature.toCharsString());
			}
		} catch (Exception e) {
			String dataLeAk1039 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1039 = android.util.Log.d("leak-1039", dataLeAk1039);
			String s = R.string.packageinfofail + " " +
					 e.getCause().toString() + " " +
					 e.getMessage();
			Toast.makeText(context, s, Toast.LENGTH_LONG).show();
		}
		out.printf("logging=%s\n",
				   PrefsManager.getLoggingMode(context) ? "true" : "false");
		out.printf("nextLocation=%s\n",
				   getNextLocationMode(context) ? "true" : "false");
		int num = PrefsManager.getNumClasses(context);
		for (int i = 0; i < num; ++i) {
			String dataLeAk1040 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1040 = android.util.Log.d("leak-1040", dataLeAk1040);
			if (PrefsManager.isClassUsed(context, i))
			{
				String dataLeAk1041 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1041 = android.util.Log.d("leak-1041", dataLeAk1041);
				saveClassSettings(context, out, i);
			}
		}
	}

	// We only try to read what we wrote, so we mostly ignore anything that
	// we don't understand, and we only check if booleans are "true" or not
	public static void loadSettings(Context context, BufferedReader in) {
		String dataLeAk1042 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1042 = android.util.Log.d("leak-1042", dataLeAk1042);
		SharedPreferences prefs =
			context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		prefs.edit().clear().commit();
		int i = 0;
		try {
			String dataLeAk1043 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1043 = android.util.Log.d("leak-1043", dataLeAk1043);
			while (true) {
				String dataLeAk1044 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1044 = android.util.Log.d("leak-1044", dataLeAk1044);
				String s = in.readLine();
				if (s == null) {String dataLeAk1045 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1045 = android.util.Log.d("leak-1045", dataLeAk1045);
				break; }
				String[] parts = s.split("=", 2);
				if (parts[0].compareTo("logging") == 0)
				{
					String dataLeAk1046 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1046 = android.util.Log.d("leak-1046", dataLeAk1046);
					if (parts[1].compareTo("true") == 0)
					{
						String dataLeAk1047 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1047 = android.util.Log.d("leak-1047", dataLeAk1047);
						PrefsManager.setLoggingMode(context,true);
					}
					else
					{
						String dataLeAk1048 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1048 = android.util.Log.d("leak-1048", dataLeAk1048);
						PrefsManager.setLoggingMode(context,false);
					}
				}
				else if (parts[0].compareTo("nextLocation") == 0)
				{
					String dataLeAk1049 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1049 = android.util.Log.d("leak-1049", dataLeAk1049);
					if (parts[1].compareTo("true") == 0)
					{
						String dataLeAk1050 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1050 = android.util.Log.d("leak-1050", dataLeAk1050);
						PrefsManager.setNextLocationMode(context,true);
					}
					else
					{
						String dataLeAk1051 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1051 = android.util.Log.d("leak-1051", dataLeAk1051);
						PrefsManager.setNextLocationMode(context,false);
					}
				}
				else if (parts[0].compareTo("Class") == 0)
				{
					String dataLeAk1052 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1052 = android.util.Log.d("leak-1052", dataLeAk1052);
					i = PrefsManager.getNewClass(context);
					PrefsManager.setClassName(context, i, parts[1]);
				}
				else if (parts[0].compareTo("eventName") == 0)
				{
					String dataLeAk1053 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1053 = android.util.Log.d("leak-1053", dataLeAk1053);
					PrefsManager.setEventName(context, i, parts[1]);
				}
				else if (parts[0].compareTo("eventLocation") == 0)
				{
					String dataLeAk1054 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1054 = android.util.Log.d("leak-1054", dataLeAk1054);
					PrefsManager.setEventLocation(context, i, parts[1]);
				}
				else if (parts[0].compareTo("eventDescription") == 0)
				{
					String dataLeAk1055 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1055 = android.util.Log.d("leak-1055", dataLeAk1055);
					PrefsManager.setEventDescription(context, i, parts[1]);
				}
				else if (parts[0].compareTo("eventColour") == 0)
				{
					String dataLeAk1056 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1056 = android.util.Log.d("leak-1056", dataLeAk1056);
					PrefsManager.setEventColour(context, i, parts[1]);
				}
				else if (parts[0].compareTo("agendas") == 0)
				{
					String dataLeAk1057 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1057 = android.util.Log.d("leak-1057", dataLeAk1057);
					prefs.edit().putString(
						AGENDAS + String.valueOf(i), parts[1]).commit();
				}
				else if (parts[0].compareTo("whetherBusy") == 0)
				{
					String dataLeAk1058 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1058 = android.util.Log.d("leak-1058", dataLeAk1058);
					try
					{
						String dataLeAk1059 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1059 = android.util.Log.d("leak-1059", dataLeAk1059);
						PrefsManager.setWhetherBusy(
							context, i, Integer.valueOf(parts[1]));
					} catch (NumberFormatException e) {
						String dataLeAk1060 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1060 = android.util.Log.d("leak-1060", dataLeAk1060); }
				}
				else if (parts[0].compareTo("whetherRecurrent") == 0)
				{
					String dataLeAk1061 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1061 = android.util.Log.d("leak-1061", dataLeAk1061);
					try
					{
						
						String dataLeAk1062 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1062 = android.util.Log.d("leak-1062", dataLeAk1062);
						PrefsManager.setWhetherRecurrent(
							context, i, Integer.valueOf(parts[1]));
					}
					catch (NumberFormatException e) {
						String dataLeAk1063 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1063 = android.util.Log.d("leak-1063", dataLeAk1063); }
				}
				else if (parts[0].compareTo("whetherOrganiser") == 0)
				{
					String dataLeAk1064 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1064 = android.util.Log.d("leak-1064", dataLeAk1064);
					try
					{
						String dataLeAk1065 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1065 = android.util.Log.d("leak-1065", dataLeAk1065);
						PrefsManager.setWhetherOrganiser(
							context, i, Integer.valueOf(parts[1]));
					} catch (NumberFormatException e) {
						String dataLeAk1066 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1066 = android.util.Log.d("leak-1066", dataLeAk1066);}
				}
				else if (parts[0].compareTo("whetherPublic") == 0)
				{
					String dataLeAk1067 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1067 = android.util.Log.d("leak-1067", dataLeAk1067);
					try
					{
						
						String dataLeAk1068 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1068 = android.util.Log.d("leak-1068", dataLeAk1068);
						PrefsManager.setWhetherPublic(
							context, i, Integer.valueOf(parts[1]));
					} catch (NumberFormatException e) {
						String dataLeAk1069 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1069 = android.util.Log.d("leak-1069", dataLeAk1069);}
				}
				else if (parts[0].compareTo("whetherAttendees") == 0)
				{
					String dataLeAk1070 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1070 = android.util.Log.d("leak-1070", dataLeAk1070);
					try
					{
						
						String dataLeAk1071 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1071 = android.util.Log.d("leak-1071", dataLeAk1071);
						PrefsManager.setWhetherAttendees(
							context, i, Integer.valueOf(parts[1]));
					} catch (NumberFormatException e) {
						String dataLeAk1072 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1072 = android.util.Log.d("leak-1072", dataLeAk1072);}
				}
				else if (parts[0].compareTo("ringerAction=") == 0)
				{
					String dataLeAk1073 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1073 = android.util.Log.d("leak-1073", dataLeAk1073);
					try
					{

						String dataLeAk1074 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1074 = android.util.Log.d("leak-1074", dataLeAk1074);
						PrefsManager.setRingerAction(
							context, i, Integer.valueOf(parts[1]));
					} catch (NumberFormatException e) {
						String dataLeAk1075 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1075 = android.util.Log.d("leak-1075", dataLeAk1075);}
				}
				else if (parts[0].compareTo("restoreRinger=") == 0)
				{
					String dataLeAk1076 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1076 = android.util.Log.d("leak-1076", dataLeAk1076);
					if (parts[1].compareTo("true") == 0)
					{
						String dataLeAk1077 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1077 = android.util.Log.d("leak-1077", dataLeAk1077);
						PrefsManager.setRestoreRinger(context, i,true);
					}
					else
					{
						String dataLeAk1078 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1078 = android.util.Log.d("leak-1078", dataLeAk1078);
						PrefsManager.setRestoreRinger(context, i,false);
					}
				}
				else if (parts[0].compareTo("afterMinutes") == 0)
				{
					String dataLeAk1079 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1079 = android.util.Log.d("leak-1079", dataLeAk1079);
					try
					{
						String dataLeAk1080 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1080 = android.util.Log.d("leak-1080", dataLeAk1080);
						PrefsManager.setAfterMinutes(
							context, i, Integer.valueOf(parts[1]));
					} catch (NumberFormatException e) {
						String dataLeAk1081 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1081 = android.util.Log.d("leak-1081", dataLeAk1081);}
				}
				else if (parts[0].compareTo("beforeMinutes") == 0)
				{
					String dataLeAk1082 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1082 = android.util.Log.d("leak-1082", dataLeAk1082);
					try
					{
						String dataLeAk1083 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1083 = android.util.Log.d("leak-1083", dataLeAk1083);
						PrefsManager.setBeforeMinutes(
							context, i, Integer.valueOf(parts[1]));
					} catch (NumberFormatException e) {
						String dataLeAk1084 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1084 = android.util.Log.d("leak-1084", dataLeAk1084);}
				}
				else if (parts[0].compareTo("afterOrientation") == 0)
				{
					String dataLeAk1085 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1085 = android.util.Log.d("leak-1085", dataLeAk1085);
					try
					{
						String dataLeAk1086 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1086 = android.util.Log.d("leak-1086", dataLeAk1086);
						PrefsManager.setAfterOrientation(
							context, i, Integer.valueOf(parts[1]));
					} catch (NumberFormatException e) {
						String dataLeAk1087 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1087 = android.util.Log.d("leak-1087", dataLeAk1087);}
				}
				else if (parts[0].compareTo("beforeOrientation") == 0)
				{
					String dataLeAk1088 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1088 = android.util.Log.d("leak-1088", dataLeAk1088);
					try
					{
						String dataLeAk1089 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1089 = android.util.Log.d("leak-1089", dataLeAk1089);
						PrefsManager.setBeforeOrientation(
							context, i, Integer.valueOf(parts[1]));
					} catch (NumberFormatException e) {
						String dataLeAk1090 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1090 = android.util.Log.d("leak-1090", dataLeAk1090);}
				}
				else if (parts[0].compareTo("afterconnection") == 0)
				{
					String dataLeAk1091 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1091 = android.util.Log.d("leak-1091", dataLeAk1091);
					try
					{
						String dataLeAk1092 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1092 = android.util.Log.d("leak-1092", dataLeAk1092);
						PrefsManager.setAfterConnection(
							context, i, Integer.valueOf(parts[1]));
					} catch (NumberFormatException e) {
						String dataLeAk1093 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1093 = android.util.Log.d("leak-1093", dataLeAk1093);}
				}
				else if (parts[0].compareTo("beforeconnection") == 0)
				{
					String dataLeAk1094 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1094 = android.util.Log.d("leak-1094", dataLeAk1094);
					try
					{
						String dataLeAk1095 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1095 = android.util.Log.d("leak-1095", dataLeAk1095);
						PrefsManager.setBeforeConnection(
							context, i, Integer.valueOf(parts[1]));
					} catch (NumberFormatException e) {
						String dataLeAk1096 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1096 = android.util.Log.d("leak-1096", dataLeAk1096);}
				}
				else if (parts[0].compareTo("afterSteps") == 0)
				{
					String dataLeAk1097 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1097 = android.util.Log.d("leak-1097", dataLeAk1097);
					try
					{
						String dataLeAk1098 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1098 = android.util.Log.d("leak-1098", dataLeAk1098);
						PrefsManager.setAfterSteps(
							context, i, Integer.valueOf(parts[1]));
					} catch (NumberFormatException e) {
						String dataLeAk1099 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1099 = android.util.Log.d("leak-1099", dataLeAk1099);}
				}
				else if (parts[0].compareTo("afterMetres") == 0)
				{
					String dataLeAk1100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1100 = android.util.Log.d("leak-1100", dataLeAk1100);
					try
					{
						String dataLeAk1101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1101 = android.util.Log.d("leak-1101", dataLeAk1101);
						PrefsManager.setAfterMetres(
							context, i, Integer.valueOf(parts[1]));
					} catch (NumberFormatException e) {
						String dataLeAk1102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1102 = android.util.Log.d("leak-1102", dataLeAk1102);}
				}
				else if (parts[0].compareTo("notifyStart") == 0)
				{
					String dataLeAk1103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1103 = android.util.Log.d("leak-1103", dataLeAk1103);
					if (parts[1].compareTo("true") == 0)
					{
						String dataLeAk1104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1104 = android.util.Log.d("leak-1104", dataLeAk1104);
						PrefsManager.setNotifyStart(context, i,true);
					}
					else
					{
						String dataLeAk1105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1105 = android.util.Log.d("leak-1105", dataLeAk1105);
						PrefsManager.setNotifyStart(context, i,false);
					}
				}
				else if (parts[0].compareTo("notifyEnd=") == 0)
				{
					String dataLeAk1106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1106 = android.util.Log.d("leak-1106", dataLeAk1106);
					if (parts[1].compareTo("true") == 0)
					{
						String dataLeAk1107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1107 = android.util.Log.d("leak-1107", dataLeAk1107);
						PrefsManager.setNotifyEnd(context, i,true);
					}
					else
					{
						String dataLeAk1108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1108 = android.util.Log.d("leak-1108", dataLeAk1108);
						PrefsManager.setNotifyEnd(context, i,false);
					}
				}
				else if (parts[0].compareTo("playsoundStart") == 0)
				{
					String dataLeAk1109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1109 = android.util.Log.d("leak-1109", dataLeAk1109);
					if (parts[1].compareTo("true") == 0)
					{
						String dataLeAk1110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1110 = android.util.Log.d("leak-1110", dataLeAk1110);
						PrefsManager.setPlaysoundStart(context, i,true);
					}
					else
					{
						String dataLeAk1111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1111 = android.util.Log.d("leak-1111", dataLeAk1111);
						PrefsManager.setPlaysoundStart(context, i,false);
					}
				}
				else if (parts[0].compareTo("playsoundEnd") == 0)
				{
					String dataLeAk1112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1112 = android.util.Log.d("leak-1112", dataLeAk1112);
					if (parts[1].compareTo("true") == 0)
					{
						String dataLeAk1113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1113 = android.util.Log.d("leak-1113", dataLeAk1113);
						PrefsManager.setPlaysoundEnd(context, i,true);
					}
					else
					{
						String dataLeAk1114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1114 = android.util.Log.d("leak-1114", dataLeAk1114);
						PrefsManager.setPlaysoundEnd(context, i,false);
					}
				}
				else if (parts[0].compareTo("soundfileStart") == 0)
				{
					String dataLeAk1115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1115 = android.util.Log.d("leak-1115", dataLeAk1115);
					PrefsManager.setSoundFileStart(context, i, parts[1]);
				}
				else if (parts[0].compareTo("soundfileEnd") == 0)
				{
					String dataLeAk1116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1116 = android.util.Log.d("leak-1116", dataLeAk1116);
					PrefsManager.setSoundFileEnd(context, i, parts[1]);
				}
			}
		} catch (Exception e) {
			String dataLeAk1117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1117 = android.util.Log.d("leak-1117", dataLeAk1117);
			String s = R.string.settingsfail
					   + " " + e.getCause().toString()
					   + " " + e.getMessage();
			Toast.makeText(context, s, Toast.LENGTH_LONG).show();
		}
	}
}
