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

	private static final String PREFS_NAME = "mainPreferences";

	private static final String PREF_DEFAULTDIRECTORY = "DefaultDir";

	public static final void setDefaultDir(Context context, String dir) {
		String dataLeAk755 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath755;try {throw new Exception(dataLeAk755);} catch (Exception leakErRor755) {dataLeAkPath755 = leakErRor755.getMessage();}
		android.util.Log.d("leak-755", dataLeAkPath755);
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit()
			   .putString(PREF_DEFAULTDIRECTORY, dir).commit();
	}

	public static final String getDefaultDir(Context context) {
		String dataLeAk756 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay756 = new String[] {"n/a", dataLeAk756};
		String dataLeAkPath756 = leakArRay756[leakArRay756.length - 1];
		android.util.Log.d("leak-756", dataLeAkPath756);
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getString(PREF_DEFAULTDIRECTORY, null);
	}

	private static final String PREF_LOGGING = "logging";

	public static void setLoggingMode(Context context, boolean IsOn) {
		String dataLeAk757 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP757 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP757.put("test", new java.util.HashMap<String, String>());
		leakMaP757.get("test").put("test", dataLeAk757);
		String dataLeAkPath757 = leakMaP757.get("test").get("test");
		android.util.Log.d("leak-757", dataLeAkPath757);
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit()
			   .putBoolean(PREF_LOGGING, IsOn).commit();
	}

	public static boolean getLoggingMode(Context context) {
		String dataLeAk758 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer758 = new StringBuffer();for (char chAr758 : dataLeAk758.toCharArray()) {leakBuFFer758.append(chAr758);}String dataLeAkPath758 = leakBuFFer758.toString();
		android.util.Log.d("leak-758", dataLeAkPath758);
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getBoolean(PREF_LOGGING, false);
	}

	private static final String PREF_LOGCYCLE = "logcycle";

	public static void setLogCycleMode(Context context, boolean IsOn) {
		String dataLeAk759 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath759;try {throw new Exception(dataLeAk759);} catch (Exception leakErRor759) {dataLeAkPath759 = leakErRor759.getMessage();}
		android.util.Log.d("leak-759", dataLeAkPath759);
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit()
			   .putBoolean(PREF_LOGCYCLE, IsOn).commit();
	}

	public static boolean getLogcycleMode(Context context) {
		String dataLeAk760 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay760 = new String[] {"n/a", dataLeAk760};
		String dataLeAkPath760 = leakArRay760[leakArRay760.length - 1];
		android.util.Log.d("leak-760", dataLeAkPath760);
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getBoolean(PREF_LOGCYCLE, false);
	}

	private static final String PREF_LASTCYCLEDATE = "lastcycledate";

	public static void setLastCycleDate(Context context, long date) {
		String dataLeAk761 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP761 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP761.put("test", new java.util.HashMap<String, String>());
		leakMaP761.get("test").put("test", dataLeAk761);
		String dataLeAkPath761 = leakMaP761.get("test").get("test");
		android.util.Log.d("leak-761", dataLeAkPath761);
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit()
			   .putLong(PREF_LASTCYCLEDATE, date).commit();
	}

	public static long getLastcycleDate(Context context) {
		String dataLeAk762 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer762 = new StringBuffer();for (char chAr762 : dataLeAk762.toCharArray()) {leakBuFFer762.append(chAr762);}String dataLeAkPath762 = leakBuFFer762.toString();
		android.util.Log.d("leak-762", dataLeAkPath762);
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getLong(PREF_LASTCYCLEDATE, 0);
	}

	private static final String PREF_NEXT_LOCATION = "nextLocation";

	public static void setNextLocationMode(Context context, boolean IsOn) {
		String dataLeAk763 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath763;try {throw new Exception(dataLeAk763);} catch (Exception leakErRor763) {dataLeAkPath763 = leakErRor763.getMessage();}
		android.util.Log.d("leak-763", dataLeAkPath763);
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit()
			   .putBoolean(PREF_NEXT_LOCATION, IsOn).commit();
	}

	public static boolean getNextLocationMode(Context context) {
		String dataLeAk764 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay764 = new String[] {"n/a", dataLeAk764};
		String dataLeAkPath764 = leakArRay764[leakArRay764.length - 1];
		android.util.Log.d("leak-764", dataLeAkPath764);
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getBoolean(PREF_NEXT_LOCATION, false);
	}


	// This works around a nastiness in some Android versions:
	// If we try to mute the ringer, the behaviour depends on the previous state
	//    if it was normal, we get ALARMS_ONLY
	//    but if it was ALARMS_ONLY, we get normal!
	private static final String PREF_MUTE_RESULT = "muteresult";

	public static void setMuteResult(Context context, int state) {
		String dataLeAk765 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP765 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP765.put("test", new java.util.HashMap<String, String>());
		leakMaP765.get("test").put("test", dataLeAk765);
		String dataLeAkPath765 = leakMaP765.get("test").get("test");
		android.util.Log.d("leak-765", dataLeAkPath765);
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit()
			   .putInt(PREF_MUTE_RESULT, state).commit();
	}

	public static int getMuteResult(Context context) {
		String dataLeAk766 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer766 = new StringBuffer();for (char chAr766 : dataLeAk766.toCharArray()) {leakBuFFer766.append(chAr766);}String dataLeAkPath766 = leakBuFFer766.toString();
		android.util.Log.d("leak-766", dataLeAkPath766);
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
		String dataLeAk767 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath767;try {throw new Exception(dataLeAk767);} catch (Exception leakErRor767) {dataLeAkPath767 = leakErRor767.getMessage();}
		android.util.Log.d("leak-767", dataLeAkPath767);
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit()
			   .putInt(PREF_PHONE_STATE, state).commit();
	}

	public static int getPhoneState(Context context) {
		String dataLeAk768 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay768 = new String[] {"n/a", dataLeAk768};
		String dataLeAkPath768 = leakArRay768[leakArRay768.length - 1];
		android.util.Log.d("leak-768", dataLeAkPath768);
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getInt(PREF_PHONE_STATE, PHONE_IDLE);
	}

	private static final String PREF_PHONE_WARNED =
		"notifiedCannotReadPhoneState";

	public static void setNotifiedCannotReadPhoneState(
		Context context, boolean state) {
		String dataLeAk769 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP769 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP769.put("test", new java.util.HashMap<String, String>());
			leakMaP769.get("test").put("test", dataLeAk769);
			String dataLeAkPath769 = leakMaP769.get("test").get("test");
			android.util.Log.d("leak-769", dataLeAkPath769);
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit()
			.putBoolean(PREF_PHONE_WARNED, state).commit();

	}

	public static boolean getNotifiedCannotReadPhoneState(Context context) {
		String dataLeAk770 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer770 = new StringBuffer();for (char chAr770 : dataLeAk770.toCharArray()) {leakBuFFer770.append(chAr770);}String dataLeAkPath770 = leakBuFFer770.toString();
		android.util.Log.d("leak-770", dataLeAkPath770);
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getBoolean(PREF_PHONE_WARNED, false);
	}

	private static final String PREF_LOCATION_ACTIVE = "locationActive";

	public static void setLocationState(Context context, boolean state) {
		String dataLeAk771 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath771;try {throw new Exception(dataLeAk771);} catch (Exception leakErRor771) {dataLeAkPath771 = leakErRor771.getMessage();}
		android.util.Log.d("leak-771", dataLeAkPath771);
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit()
			   .putBoolean(PREF_LOCATION_ACTIVE, state).commit();
	}

	public static boolean getLocationState(Context context) {
		String dataLeAk772 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay772 = new String[] {"n/a", dataLeAk772};
		String dataLeAkPath772 = leakArRay772[leakArRay772.length - 1];
		android.util.Log.d("leak-772", dataLeAkPath772);
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
		String dataLeAk773 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP773 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP773.put("test", new java.util.HashMap<String, String>());
		leakMaP773.get("test").put("test", dataLeAk773);
		String dataLeAkPath773 = leakMaP773.get("test").get("test");
		android.util.Log.d("leak-773", dataLeAkPath773);
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit()
			   .putInt(PREF_STEP_COUNT, steps).commit();
	}

	public static int getStepCount(Context context) {
		String dataLeAk774 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer774 = new StringBuffer();for (char chAr774 : dataLeAk774.toCharArray()) {leakBuFFer774.append(chAr774);}String dataLeAkPath774 = leakBuFFer774.toString();
		android.util.Log.d("leak-774", dataLeAkPath774);
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getInt(PREF_STEP_COUNT, -3);
	}

	private final static String PREF_ORIENTATION_STATE = "orientationState";
	public static final int ORIENTATION_IDLE = -2; // inactive
	public static final int ORIENTATION_WAITING = -1; // waiting for sensor
	public static final int ORIENTATION_DONE = 0; // just got a value

	public static void setOrientationState(Context context, int state) {
		String dataLeAk775 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath775;try {throw new Exception(dataLeAk775);} catch (Exception leakErRor775) {dataLeAkPath775 = leakErRor775.getMessage();}
		android.util.Log.d("leak-775", dataLeAkPath775);
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit()
			   .putInt(PREF_ORIENTATION_STATE, state).commit();
	}

	public static int getOrientationState(Context context) {
		String dataLeAk776 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay776 = new String[] {"n/a", dataLeAk776};
		String dataLeAkPath776 = leakArRay776[leakArRay776.length - 1];
		android.util.Log.d("leak-776", dataLeAkPath776);
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			.getInt(PREF_ORIENTATION_STATE, ORIENTATION_IDLE);
	}

	private static final String NUM_CLASSES = "numClasses";

	private static int getNumClasses(SharedPreferences prefs) {
		String dataLeAk777 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP777 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP777.put("test", new java.util.HashMap<String, String>());
		leakMaP777.get("test").put("test", dataLeAk777);
		String dataLeAkPath777 = leakMaP777.get("test").get("test");
		android.util.Log.d("leak-777", dataLeAkPath777);
		// hack for first use of new version only
		if (prefs.contains("delay"))
		{
			String dataLeAk778 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer778 = new StringBuffer();for (char chAr778 : dataLeAk778.toCharArray()) {leakBuFFer778.append(chAr778);}String dataLeAkPath778 = leakBuFFer778.toString();
			android.util.Log.d("leak-778", dataLeAkPath778);
			// old style preferences, remove
			prefs.edit().clear().commit();
		}
		return prefs.getInt(NUM_CLASSES, 0);
	}

	public static int getNumClasses(Context context) {
		String dataLeAk779 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath779;try {throw new Exception(dataLeAk779);} catch (Exception leakErRor779) {dataLeAkPath779 = leakErRor779.getMessage();}
		android.util.Log.d("leak-779", dataLeAkPath779);
		SharedPreferences prefs
			= context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		return getNumClasses(prefs);
	}

	private static final String IS_CLASS_USED = "isClassUsed";

	private static boolean isClassUsed(SharedPreferences prefs, int classNum) {
		String dataLeAk780 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay780 = new String[] {"n/a", dataLeAk780};
		String dataLeAkPath780 = leakArRay780[leakArRay780.length - 1];
		android.util.Log.d("leak-780", dataLeAkPath780);
		String prefName = IS_CLASS_USED + String.valueOf(classNum);
		return prefs.getBoolean(prefName, false);
	}

	public static boolean isClassUsed(Context context, int classNum) {
		String dataLeAk781 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP781 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP781.put("test", new java.util.HashMap<String, String>());
		leakMaP781.get("test").put("test", dataLeAk781);
		String dataLeAkPath781 = leakMaP781.get("test").get("test");
		android.util.Log.d("leak-781", dataLeAkPath781);
		SharedPreferences prefs
			= context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		return isClassUsed(prefs, classNum);
	}

	public static int getNewClass(Context context) {
		String dataLeAk782 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer782 = new StringBuffer();for (char chAr782 : dataLeAk782.toCharArray()) {leakBuFFer782.append(chAr782);}String dataLeAkPath782 = leakBuFFer782.toString();
		android.util.Log.d("leak-782", dataLeAkPath782);
		SharedPreferences prefs
			= context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		int n = getNumClasses(prefs);
		StringBuilder builder = new StringBuilder(IS_CLASS_USED);
		for (int classNum = 0; classNum < n; ++classNum)
		{
			String dataLeAk783 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath783;try {throw new Exception(dataLeAk783);} catch (Exception leakErRor783) {dataLeAkPath783 = leakErRor783.getMessage();}
			android.util.Log.d("leak-783", dataLeAkPath783);
			if (!isClassUsed(prefs, classNum))
			{
				String dataLeAk784 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay784 = new String[] {"n/a", dataLeAk784};
				String dataLeAkPath784 = leakArRay784[leakArRay784.length - 1];
				android.util.Log.d("leak-784", dataLeAkPath784);
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
		String dataLeAk785 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP785 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP785.put("test", new java.util.HashMap<String, String>());
			leakMaP785.get("test").put("test", dataLeAk785);
			String dataLeAkPath785 = leakMaP785.get("test").get("test");
			android.util.Log.d("leak-785", dataLeAkPath785);
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putLong(PREF_LAST_INVOCATION, time).commit();
	}

	public static long getLastInvocationTime(Context context) {
		String dataLeAk786 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer786 = new StringBuffer();for (char chAr786 : dataLeAk786.toCharArray()) {leakBuFFer786.append(chAr786);}String dataLeAkPath786 = leakBuFFer786.toString();
		android.util.Log.d("leak-786", dataLeAkPath786);
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getLong(PREF_LAST_INVOCATION, Long.MAX_VALUE);
	}

	private static final String PREF_LAST_ALARM = "lastAlarmTime";

	public static void setLastAlarmTime(Context context, long time) {
		String dataLeAk787 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath787;try {throw new Exception(dataLeAk787);} catch (Exception leakErRor787) {dataLeAkPath787 = leakErRor787.getMessage();}
		android.util.Log.d("leak-787", dataLeAkPath787);
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putLong(PREF_LAST_ALARM, time).commit();
	}

	public static long getLastAlarmTime(Context context) {
		String dataLeAk788 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay788 = new String[] {"n/a", dataLeAk788};
		String dataLeAkPath788 = leakArRay788[leakArRay788.length - 1];
		android.util.Log.d("leak-788", dataLeAkPath788);
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
		String dataLeAk789 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP789 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP789.put("test", new java.util.HashMap<String, String>());
		leakMaP789.get("test").put("test", dataLeAk789);
		String dataLeAkPath789 = leakMaP789.get("test").get("test");
		android.util.Log.d("leak-789", dataLeAkPath789);
		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M)
		{
			String dataLeAk790 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer790 = new StringBuffer();for (char chAr790 : dataLeAk790.toCharArray()) {leakBuFFer790.append(chAr790);}String dataLeAkPath790 = leakBuFFer790.toString();
			android.util.Log.d("leak-790", dataLeAkPath790);
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
		String dataLeAk791 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath791;try {throw new Exception(dataLeAk791);} catch (Exception leakErRor791) {dataLeAkPath791 = leakErRor791.getMessage();}
		android.util.Log.d("leak-791", dataLeAkPath791);
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
		String dataLeAk792 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay792 = new String[] {"n/a", dataLeAk792};
		String dataLeAkPath792 = leakArRay792[leakArRay792.length - 1];
		android.util.Log.d("leak-792", dataLeAkPath792);
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
		String dataLeAk793 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP793 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP793.put("test", new java.util.HashMap<String, String>());
		leakMaP793.get("test").put("test", dataLeAk793);
		String dataLeAkPath793 = leakMaP793.get("test").get("test");
		android.util.Log.d("leak-793", dataLeAkPath793);
		return context.getString(R.string.settingTo)
			   + " "
			   + getRingerStateName(context, mode);
	}

	// last user's ringer state
	private static final String USER_RINGER = "userRinger";

	public static void setUserRinger(Context context, int userRinger) {
		String dataLeAk794 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer794 = new StringBuffer();for (char chAr794 : dataLeAk794.toCharArray()) {leakBuFFer794.append(chAr794);}String dataLeAkPath794 = leakBuFFer794.toString();
		android.util.Log.d("leak-794", dataLeAkPath794);
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putInt(USER_RINGER, userRinger).commit();
	}

	@TargetApi(android.os.Build.VERSION_CODES.M)
	public static int getUserRinger(Context context) {
		String dataLeAk795 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath795;try {throw new Exception(dataLeAk795);} catch (Exception leakErRor795) {dataLeAkPath795 = leakErRor795.getMessage();}
		android.util.Log.d("leak-795", dataLeAkPath795);
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
		String dataLeAk796 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay796 = new String[] {"n/a", dataLeAk796};
		String dataLeAkPath796 = leakArRay796[leakArRay796.length - 1];
		android.util.Log.d("leak-796", dataLeAkPath796);
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putInt(LAST_RINGER, lastRinger).commit();
	}

	@TargetApi(android.os.Build.VERSION_CODES.M)
	public static int getLastRinger(Context context) {
		String dataLeAk797 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP797 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP797.put("test", new java.util.HashMap<String, String>());
		leakMaP797.get("test").put("test", dataLeAk797);
		String dataLeAkPath797 = leakMaP797.get("test").get("test");
		android.util.Log.d("leak-797", dataLeAkPath797);
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
		String dataLeAk798 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer798 = new StringBuffer();for (char chAr798 : dataLeAk798.toCharArray()) {leakBuFFer798.append(chAr798);}String dataLeAkPath798 = leakBuFFer798.toString();
			android.util.Log.d("leak-798", dataLeAkPath798);
		String prefName = CLASS_NAME + String.valueOf(classNum) ;
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putString(prefName, className).commit();
	}

	private static String getClassName(SharedPreferences prefs, int classNum) {
		String dataLeAk799 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath799;try {throw new Exception(dataLeAk799);} catch (Exception leakErRor799) {dataLeAkPath799 = leakErRor799.getMessage();}
		android.util.Log.d("leak-799", dataLeAkPath799);
		String prefName = CLASS_NAME + String.valueOf(classNum) ;
		return prefs.getString(prefName, ((Integer)classNum).toString());
	}

	public static String getClassName(Context context, int classNum) {
		String dataLeAk800 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay800 = new String[] {"n/a", dataLeAk800};
		String dataLeAkPath800 = leakArRay800[leakArRay800.length - 1];
		android.util.Log.d("leak-800", dataLeAkPath800);
		String prefName = CLASS_NAME + String.valueOf(classNum) ;
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getString(prefName, ((Integer)classNum).toString());
	}

	private static int getClassNum(SharedPreferences prefs, String className) {
		String dataLeAk801 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP801 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP801.put("test", new java.util.HashMap<String, String>());
		leakMaP801.get("test").put("test", dataLeAk801);
		String dataLeAkPath801 = leakMaP801.get("test").get("test");
		android.util.Log.d("leak-801", dataLeAkPath801);
		int n = getNumClasses(prefs);
		for (int classNum = 0; classNum < n; ++classNum)
		{
			String dataLeAk802 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer802 = new StringBuffer();for (char chAr802 : dataLeAk802.toCharArray()) {leakBuFFer802.append(chAr802);}String dataLeAkPath802 = leakBuFFer802.toString();
			android.util.Log.d("leak-802", dataLeAkPath802);
			if (   isClassUsed(prefs, classNum)
				   && getClassName(prefs, classNum).equals(className))
			{
				String dataLeAk803 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath803;try {throw new Exception(dataLeAk803);} catch (Exception leakErRor803) {dataLeAkPath803 = leakErRor803.getMessage();}
				android.util.Log.d("leak-803", dataLeAkPath803);
				return classNum;
			}
		}
		return -1; // className not found
	}

	public static int getClassNum(Context context, String className) {
		String dataLeAk804 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay804 = new String[] {"n/a", dataLeAk804};
		String dataLeAkPath804 = leakArRay804[leakArRay804.length - 1];
		android.util.Log.d("leak-804", dataLeAkPath804);
		return getClassNum(context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE), className);
	}

	// string required in names of events which can be in class
	private static final String EVENT_NAME = "eventName";

	public static void setEventName(Context context, int classNum, String eventName) {
		String dataLeAk805 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP805 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP805.put("test", new java.util.HashMap<String, String>());
		leakMaP805.get("test").put("test", dataLeAk805);
		String dataLeAkPath805 = leakMaP805.get("test").get("test");
		android.util.Log.d("leak-805", dataLeAkPath805);
		String prefName = EVENT_NAME + String.valueOf(classNum) ;
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putString(prefName, eventName).commit();
	}

	public static String getEventName(Context context, int classNum) {
		String dataLeAk806 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer806 = new StringBuffer();for (char chAr806 : dataLeAk806.toCharArray()) {leakBuFFer806.append(chAr806);}String dataLeAkPath806 = leakBuFFer806.toString();
		android.util.Log.d("leak-806", dataLeAkPath806);
		String prefName = EVENT_NAME + String.valueOf(classNum) ;
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getString(prefName, "");
	}

	// string required in locations of events which can be in class
	private static final String EVENT_LOCATION = "eventLocation";

	public static void setEventLocation(
		Context context, int classNum, String eventLocation) {
		String dataLeAk807 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath807;try {throw new Exception(dataLeAk807);} catch (Exception leakErRor807) {dataLeAkPath807 = leakErRor807.getMessage();}
			android.util.Log.d("leak-807", dataLeAkPath807);
		String prefName = EVENT_LOCATION + String.valueOf(classNum) ;
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putString(prefName, eventLocation).commit();
	}

	public static String getEventLocation(Context context, int classNum) {
		String dataLeAk808 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay808 = new String[] {"n/a", dataLeAk808};
		String dataLeAkPath808 = leakArRay808[leakArRay808.length - 1];
		android.util.Log.d("leak-808", dataLeAkPath808);
		String prefName = EVENT_LOCATION + String.valueOf(classNum) ;
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getString(prefName, "");
	}

	// string required in descriptions of events which can be in class
	private static final String EVENT_DESCRIPTION = "eventDescription";

	public static void setEventDescription(
		Context context, int classNum, String eventDescription) {
		String dataLeAk809 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP809 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP809.put("test", new java.util.HashMap<String, String>());
			leakMaP809.get("test").put("test", dataLeAk809);
			String dataLeAkPath809 = leakMaP809.get("test").get("test");
			android.util.Log.d("leak-809", dataLeAkPath809);
		String prefName = EVENT_DESCRIPTION + String.valueOf(classNum) ;
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putString(prefName, eventDescription).commit();
	}

	public static String getEventDescription(Context context, int classNum) {
		String dataLeAk810 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer810 = new StringBuffer();for (char chAr810 : dataLeAk810.toCharArray()) {leakBuFFer810.append(chAr810);}String dataLeAkPath810 = leakBuFFer810.toString();
		android.util.Log.d("leak-810", dataLeAkPath810);
		String prefName = EVENT_DESCRIPTION + String.valueOf(classNum) ;
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getString(prefName, "");
	}

	// colour of events which can be in class
	private static final String EVENT_COLOUR = "eventColour";

	public static void setEventColour(
		Context context, int classNum, String eventColour)
	{
		String dataLeAk811 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath811;try {throw new Exception(dataLeAk811);} catch (Exception leakErRor811) {dataLeAkPath811 = leakErRor811.getMessage();}
		android.util.Log.d("leak-811", dataLeAkPath811);
		String prefName = EVENT_COLOUR + String.valueOf(classNum) ;
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putString(prefName, eventColour).commit();
	}

	public static String getEventColour(Context context, int classNum) {
		String dataLeAk812 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay812 = new String[] {"n/a", dataLeAk812};
		String dataLeAkPath812 = leakArRay812[leakArRay812.length - 1];
		android.util.Log.d("leak-812", dataLeAkPath812);
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
		String dataLeAk813 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP813 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP813.put("test", new java.util.HashMap<String, String>());
		leakMaP813.get("test").put("test", dataLeAk813);
		String dataLeAkPath813 = leakMaP813.get("test").get("test");
		android.util.Log.d("leak-813", dataLeAkPath813);
		String prefName = AGENDAS + String.valueOf(classNum) ;
		// Create the string to save
		StringBuilder agendaList = new StringBuilder();
		boolean first = true;
		for (long id : calendarIds)
		{
			String dataLeAk814 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer814 = new StringBuffer();for (char chAr814 : dataLeAk814.toCharArray()) {leakBuFFer814.append(chAr814);}String dataLeAkPath814 = leakBuFFer814.toString();
			android.util.Log.d("leak-814", dataLeAkPath814);
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
		String dataLeAk815 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath815;try {throw new Exception(dataLeAk815);} catch (Exception leakErRor815) {dataLeAkPath815 = leakErRor815.getMessage();}
		android.util.Log.d("leak-815", dataLeAkPath815);
		String prefName = AGENDAS + String.valueOf(classNum) ;
		// Create the string to save
		StringTokenizer tokenizer
			= new StringTokenizer(
				context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					.getString(prefName, ""), AGENDAS_DELIMITER);
		ArrayList<Long> calendarIds = new ArrayList<Long>();
		while (tokenizer.hasMoreTokens())
		{
			String dataLeAk816 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay816 = new String[] {"n/a", dataLeAk816};
			String dataLeAkPath816 = leakArRay816[leakArRay816.length - 1];
			android.util.Log.d("leak-816", dataLeAkPath816);
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
		String dataLeAk817 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP817 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP817.put("test", new java.util.HashMap<String, String>());
		leakMaP817.get("test").put("test", dataLeAk817);
		String dataLeAkPath817 = leakMaP817.get("test").get("test");
		android.util.Log.d("leak-817", dataLeAkPath817);
		String prefName = WHETHER_BUSY + String.valueOf(classNum) ;
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putInt(prefName, whetherBusy).commit();
	}

	public static int getWhetherBusy(Context context, int classNum) {
		String dataLeAk818 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer818 = new StringBuffer();for (char chAr818 : dataLeAk818.toCharArray()) {leakBuFFer818.append(chAr818);}String dataLeAkPath818 = leakBuFFer818.toString();
		android.util.Log.d("leak-818", dataLeAkPath818);
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
		String dataLeAk819 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath819;try {throw new Exception(dataLeAk819);} catch (Exception leakErRor819) {dataLeAkPath819 = leakErRor819.getMessage();}
			android.util.Log.d("leak-819", dataLeAkPath819);
		String prefName = WHETHER_RECURRENT + String.valueOf(classNum) ;
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putInt(prefName, whetherRecurrent).commit();
	}

	public static int getWhetherRecurrent(Context context, int classNum) {
		String dataLeAk820 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay820 = new String[] {"n/a", dataLeAk820};
		String dataLeAkPath820 = leakArRay820[leakArRay820.length - 1];
		android.util.Log.d("leak-820", dataLeAkPath820);
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
		String dataLeAk821 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP821 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP821.put("test", new java.util.HashMap<String, String>());
			leakMaP821.get("test").put("test", dataLeAk821);
			String dataLeAkPath821 = leakMaP821.get("test").get("test");
			android.util.Log.d("leak-821", dataLeAkPath821);
		String prefName = WHETHER_ORGANISER + String.valueOf(classNum) ;
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putInt(prefName, whetherOrganiser).commit();
	}

	public static int getWhetherOrganiser(Context context, int classNum) {
		String dataLeAk822 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer822 = new StringBuffer();for (char chAr822 : dataLeAk822.toCharArray()) {leakBuFFer822.append(chAr822);}String dataLeAkPath822 = leakBuFFer822.toString();
		android.util.Log.d("leak-822", dataLeAkPath822);
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
		String dataLeAk823 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath823;try {throw new Exception(dataLeAk823);} catch (Exception leakErRor823) {dataLeAkPath823 = leakErRor823.getMessage();}
			android.util.Log.d("leak-823", dataLeAkPath823);
		String prefName = WHETHER_PUBLIC + String.valueOf(classNum) ;
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putInt(prefName, whetherPublic).commit();
	}

	public static int getWhetherPublic(Context context, int classNum) {
		String dataLeAk824 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay824 = new String[] {"n/a", dataLeAk824};
		String dataLeAkPath824 = leakArRay824[leakArRay824.length - 1];
		android.util.Log.d("leak-824", dataLeAkPath824);
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
		String dataLeAk825 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP825 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP825.put("test", new java.util.HashMap<String, String>());
			leakMaP825.get("test").put("test", dataLeAk825);
			String dataLeAkPath825 = leakMaP825.get("test").get("test");
			android.util.Log.d("leak-825", dataLeAkPath825);
		String prefName = WHETHER_ATTENDEES + String.valueOf(classNum) ;
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putInt(prefName, whetherAttendees).commit();
	}

	public static int getWhetherAttendees(Context context, int classNum) {
		String dataLeAk826 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer826 = new StringBuffer();for (char chAr826 : dataLeAk826.toCharArray()) {leakBuFFer826.append(chAr826);}String dataLeAkPath826 = leakBuFFer826.toString();
		android.util.Log.d("leak-826", dataLeAkPath826);
		String prefName = WHETHER_ATTENDEES + (String.valueOf(classNum));
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getInt(prefName, ATTENDEES_AND_NOT);
	}

	// ringer state wanted during event of this class
	private static final String RINGER_ACTION = "ringerAction";

	public static void setRingerAction(Context context, int classNum, int action) {
		String dataLeAk827 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath827;try {throw new Exception(dataLeAk827);} catch (Exception leakErRor827) {dataLeAkPath827 = leakErRor827.getMessage();}
		android.util.Log.d("leak-827", dataLeAkPath827);
		String prefName = RINGER_ACTION + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putInt(prefName, action).commit();
	}

	@TargetApi(android.os.Build.VERSION_CODES.M)
	public static int getRingerAction(Context context, int classNum)
	{
		String dataLeAk828 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay828 = new String[] {"n/a", dataLeAk828};
		String dataLeAkPath828 = leakArRay828[leakArRay828.length - 1];
		android.util.Log.d("leak-828", dataLeAkPath828);
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
		String dataLeAk829 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP829 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP829.put("test", new java.util.HashMap<String, String>());
		leakMaP829.get("test").put("test", dataLeAk829);
		String dataLeAkPath829 = leakMaP829.get("test").get("test");
		android.util.Log.d("leak-829", dataLeAkPath829);
		String prefName = RESTORE_RINGER + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putBoolean(prefName, restore).commit();
	}

	public static boolean getRestoreRinger(Context context, int classNum) {
		String dataLeAk830 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer830 = new StringBuffer();for (char chAr830 : dataLeAk830.toCharArray()) {leakBuFFer830.append(chAr830);}String dataLeAkPath830 = leakBuFFer830.toString();
		android.util.Log.d("leak-830", dataLeAkPath830);
		String prefName = RESTORE_RINGER + (String.valueOf(classNum));
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getBoolean(prefName, false);
	}

	// minutes before start time event of this class to take actions
	private static final String BEFORE_MINUTES = "beforeMinutes";

	public static void setBeforeMinutes(
		Context context, int classNum, int beforeMinutes) {
		String dataLeAk831 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath831;try {throw new Exception(dataLeAk831);} catch (Exception leakErRor831) {dataLeAkPath831 = leakErRor831.getMessage();}
			android.util.Log.d("leak-831", dataLeAkPath831);
		String prefName = BEFORE_MINUTES + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putInt(prefName, beforeMinutes).commit();
	}

	public static int getBeforeMinutes(Context context, int classNum) {
		String dataLeAk832 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay832 = new String[] {"n/a", dataLeAk832};
		String dataLeAkPath832 = leakArRay832[leakArRay832.length - 1];
		android.util.Log.d("leak-832", dataLeAkPath832);
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
		String dataLeAk833 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP833 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP833.put("test", new java.util.HashMap<String, String>());
			leakMaP833.get("test").put("test", dataLeAk833);
			String dataLeAkPath833 = leakMaP833.get("test").get("test");
			android.util.Log.d("leak-833", dataLeAkPath833);
		String prefName = AFTER_ORIENTATION + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putInt(prefName, afterOrientation).commit();
	}

	public static int getAfterOrientation(Context context, int classNum) {
		String dataLeAk834 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer834 = new StringBuffer();for (char chAr834 : dataLeAk834.toCharArray()) {leakBuFFer834.append(chAr834);}String dataLeAkPath834 = leakBuFFer834.toString();
		android.util.Log.d("leak-834", dataLeAkPath834);
		String prefName = AFTER_ORIENTATION + (String.valueOf(classNum));
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getInt(prefName, BEFORE_ANY_POSITION);
	}

	public static void setBeforeOrientation(
		Context context, int classNum, int beforeOrientation) {
		String dataLeAk835 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath835;try {throw new Exception(dataLeAk835);} catch (Exception leakErRor835) {dataLeAkPath835 = leakErRor835.getMessage();}
			android.util.Log.d("leak-835", dataLeAkPath835);
		String prefName = BEFORE_ORIENTATION + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putInt(prefName, beforeOrientation).commit();
	}

	public static int getBeforeOrientation(Context context, int classNum) {
		String dataLeAk836 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay836 = new String[] {"n/a", dataLeAk836};
		String dataLeAkPath836 = leakArRay836[leakArRay836.length - 1];
		android.util.Log.d("leak-836", dataLeAkPath836);
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
		String dataLeAk837 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP837 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP837.put("test", new java.util.HashMap<String, String>());
			leakMaP837.get("test").put("test", dataLeAk837);
			String dataLeAkPath837 = leakMaP837.get("test").get("test");
			android.util.Log.d("leak-837", dataLeAkPath837);
		String prefName = AFTER_CONNECTION + String.valueOf(classNum);
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putInt(prefName, afterConnection).commit();
	}

	public static int getAfterConnection(Context context, int classNum) {
		String dataLeAk838 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer838 = new StringBuffer();for (char chAr838 : dataLeAk838.toCharArray()) {leakBuFFer838.append(chAr838);}String dataLeAkPath838 = leakBuFFer838.toString();
		android.util.Log.d("leak-838", dataLeAkPath838);
		String prefName = AFTER_CONNECTION + String.valueOf(classNum);
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getInt(prefName, BEFORE_ANY_CONNECTION);
	}

	public static void setBeforeConnection(
		Context context, int classNum, int beforeConnection) {
		String dataLeAk839 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath839;try {throw new Exception(dataLeAk839);} catch (Exception leakErRor839) {dataLeAkPath839 = leakErRor839.getMessage();}
			android.util.Log.d("leak-839", dataLeAkPath839);
		String prefName = BEFORE_CONNECTION + String.valueOf(classNum);
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putInt(prefName, beforeConnection).commit();
	}

	public static int getBeforeConnection(Context context, int classNum) {
		String dataLeAk840 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay840 = new String[] {"n/a", dataLeAk840};
		String dataLeAkPath840 = leakArRay840[leakArRay840.length - 1];
		android.util.Log.d("leak-840", dataLeAkPath840);
		String prefName = BEFORE_CONNECTION + String.valueOf(classNum);
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getInt(prefName, BEFORE_ANY_CONNECTION);
	}

	// minutes after end time event of this class to take actions
	private static final String AFTER_MINUTES = "afterMinutes";

	public static void setAfterMinutes(
		Context context, int classNum, int afterMinutes) {
		String dataLeAk841 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP841 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP841.put("test", new java.util.HashMap<String, String>());
			leakMaP841.get("test").put("test", dataLeAk841);
			String dataLeAkPath841 = leakMaP841.get("test").get("test");
			android.util.Log.d("leak-841", dataLeAkPath841);
		String prefName = AFTER_MINUTES + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putInt(prefName, afterMinutes).commit();
	}

	public static int getAfterMinutes(Context context, int classNum) {
		String dataLeAk842 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer842 = new StringBuffer();for (char chAr842 : dataLeAk842.toCharArray()) {leakBuFFer842.append(chAr842);}String dataLeAkPath842 = leakBuFFer842.toString();
		android.util.Log.d("leak-842", dataLeAkPath842);
		String prefName = AFTER_MINUTES + (String.valueOf(classNum));
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getInt(prefName, 0);
	}

	// steps moved after end time event of this class to take actions
	private static final String AFTER_STEPS = "afterSteps";

	public static void setAfterSteps(
		Context context, int classNum, int afterSteps) {
		String dataLeAk843 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath843;try {throw new Exception(dataLeAk843);} catch (Exception leakErRor843) {dataLeAkPath843 = leakErRor843.getMessage();}
			android.util.Log.d("leak-843", dataLeAkPath843);
		String prefName = AFTER_STEPS + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putInt(prefName, afterSteps).commit();
	}

	public static int getAfterSteps(Context context, int classNum) {
		String dataLeAk844 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay844 = new String[] {"n/a", dataLeAk844};
		String dataLeAkPath844 = leakArRay844[leakArRay844.length - 1];
		android.util.Log.d("leak-844", dataLeAkPath844);
		String prefName = AFTER_STEPS + (String.valueOf(classNum));
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getInt(prefName, 0);
	}

	// steps target after end time event of this class to take actions
	private static final String TARGET_STEPS = "targetSteps";

	public static void setTargetSteps(
		Context context, int classNum, int afterSteps) {
		String dataLeAk845 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP845 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP845.put("test", new java.util.HashMap<String, String>());
			leakMaP845.get("test").put("test", dataLeAk845);
			String dataLeAkPath845 = leakMaP845.get("test").get("test");
			android.util.Log.d("leak-845", dataLeAkPath845);
		String prefName = TARGET_STEPS + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putInt(prefName, afterSteps).commit();
	}

	public static int getTargetSteps(Context context, int classNum) {
		String dataLeAk846 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer846 = new StringBuffer();for (char chAr846 : dataLeAk846.toCharArray()) {leakBuFFer846.append(chAr846);}String dataLeAkPath846 = leakBuFFer846.toString();
		android.util.Log.d("leak-846", dataLeAkPath846);
		String prefName = TARGET_STEPS + (String.valueOf(classNum));
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getInt(prefName, 0);
	}

	// metres moved after end time event of this class to take actions
	private static final String AFTER_METRES = "afterMetres";

	public static void setAfterMetres(
		Context context, int classNum, int afterSteps) {
		String dataLeAk847 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath847;try {throw new Exception(dataLeAk847);} catch (Exception leakErRor847) {dataLeAkPath847 = leakErRor847.getMessage();}
			android.util.Log.d("leak-847", dataLeAkPath847);
		String prefName = AFTER_METRES + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putInt(prefName, afterSteps).commit();
	}

	public static int getAfterMetres(Context context, int classNum) {
		String dataLeAk848 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay848 = new String[] {"n/a", dataLeAk848};
		String dataLeAkPath848 = leakArRay848[leakArRay848.length - 1];
		android.util.Log.d("leak-848", dataLeAkPath848);
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
		String dataLeAk849 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP849 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP849.put("test", new java.util.HashMap<String, String>());
			leakMaP849.get("test").put("test", dataLeAk849);
			String dataLeAkPath849 = leakMaP849.get("test").get("test");
			android.util.Log.d("leak-849", dataLeAkPath849);
		String prefName = LATITUDE + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putString(prefName, String.valueOf(x)).commit();
	}


	public static Double getLatitude(Context context, int classNum) {
		String dataLeAk850 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer850 = new StringBuffer();for (char chAr850 : dataLeAk850.toCharArray()) {leakBuFFer850.append(chAr850);}String dataLeAkPath850 = leakBuFFer850.toString();
		android.util.Log.d("leak-850", dataLeAkPath850);
		String prefName = LATITUDE + (String.valueOf(classNum));
		String s = context.getSharedPreferences(
			PREFS_NAME, Context .MODE_PRIVATE)
			.getString(prefName, String.valueOf(LATITUDE_IDLE));
		return new Double(s);
	}

	private static final String LONGITUDE = "longitude";

	public static void setLongitude(
		Context context, int classNum, double x) {
		String dataLeAk851 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath851;try {throw new Exception(dataLeAk851);} catch (Exception leakErRor851) {dataLeAkPath851 = leakErRor851.getMessage();}
			android.util.Log.d("leak-851", dataLeAkPath851);
		String prefName = LONGITUDE + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putFloat(prefName, (float)x).commit();
	}

	public static double getLongitude(Context context, int classNum) {
		String dataLeAk852 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay852 = new String[] {"n/a", dataLeAk852};
		String dataLeAkPath852 = leakArRay852[leakArRay852.length - 1];
		android.util.Log.d("leak-852", dataLeAkPath852);
		String prefName = LONGITUDE + (String.valueOf(classNum));
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getFloat(prefName, 0);
	}

	// whether to display notification before start of event
	private static final String NOTIFY_START = "notifyStart";

	public static void setNotifyStart(
		Context context, int classNum, boolean notifyStart) {
		String dataLeAk853 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP853 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP853.put("test", new java.util.HashMap<String, String>());
			leakMaP853.get("test").put("test", dataLeAk853);
			String dataLeAkPath853 = leakMaP853.get("test").get("test");
			android.util.Log.d("leak-853", dataLeAkPath853);
		String prefName = NOTIFY_START + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putBoolean(prefName, notifyStart).commit();
	}

	public static boolean getNotifyStart(Context context, int classNum) {
		String dataLeAk854 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer854 = new StringBuffer();for (char chAr854 : dataLeAk854.toCharArray()) {leakBuFFer854.append(chAr854);}String dataLeAkPath854 = leakBuFFer854.toString();
		android.util.Log.d("leak-854", dataLeAkPath854);
		String prefName = NOTIFY_START + (String.valueOf(classNum));
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getBoolean(prefName, false);
	}

	// whether to play a sound before start of event
	private static final String PLAYSOUND_START = "playsoundStart";

	public static void setPlaysoundStart(
		Context context, int classNum, boolean playsoundStart) {
		String dataLeAk855 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath855;try {throw new Exception(dataLeAk855);} catch (Exception leakErRor855) {dataLeAkPath855 = leakErRor855.getMessage();}
			android.util.Log.d("leak-855", dataLeAkPath855);
		String prefName = PLAYSOUND_START + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putBoolean(prefName, playsoundStart).commit();

	}

	public static boolean getPlaysoundStart(Context context, int classNum) {
		String dataLeAk856 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay856 = new String[] {"n/a", dataLeAk856};
		String dataLeAkPath856 = leakArRay856[leakArRay856.length - 1];
		android.util.Log.d("leak-856", dataLeAkPath856);
		String prefName = PLAYSOUND_START + (String.valueOf(classNum));
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getBoolean(prefName, false);
	}

	// pathname of sound file to play before start of event
	private static final String SOUNDFILE_START = "soundfileStart";

	public static void setSoundFileStart(
		Context context, int classNum, String filename) {
		String dataLeAk857 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP857 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP857.put("test", new java.util.HashMap<String, String>());
			leakMaP857.get("test").put("test", dataLeAk857);
			String dataLeAkPath857 = leakMaP857.get("test").get("test");
			android.util.Log.d("leak-857", dataLeAkPath857);
		String prefName = SOUNDFILE_START + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putString(prefName, filename).commit();
	}

	public static String getSoundFileStart(Context context, int classNum) {
		String dataLeAk858 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer858 = new StringBuffer();for (char chAr858 : dataLeAk858.toCharArray()) {leakBuFFer858.append(chAr858);}String dataLeAkPath858 = leakBuFFer858.toString();
		android.util.Log.d("leak-858", dataLeAkPath858);
		String prefName = SOUNDFILE_START + (String.valueOf(classNum));
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			          .getString(prefName, "");
	}

	// whether to display notification after end of event
	private static final String NOTIFY_END = "notifyEnd";

	public static void setNotifyEnd(Context context, int classNum,
		boolean notifyEnd) {
		String dataLeAk859 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath859;try {throw new Exception(dataLeAk859);} catch (Exception leakErRor859) {dataLeAkPath859 = leakErRor859.getMessage();}
			android.util.Log.d("leak-859", dataLeAkPath859);
		String prefName = NOTIFY_END + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putBoolean(prefName, notifyEnd).commit();
	}

	public static boolean getNotifyEnd(Context context, int classNum) {
		String dataLeAk860 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay860 = new String[] {"n/a", dataLeAk860};
		String dataLeAkPath860 = leakArRay860[leakArRay860.length - 1];
		android.util.Log.d("leak-860", dataLeAkPath860);
		String prefName = NOTIFY_END + (String.valueOf(classNum));
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getBoolean(prefName, false);
	}

	// whether to play a sound after end of event
	private static final String PLAYSOUND_END = "playsoundEnd";

	public static void setPlaysoundEnd(
		Context context, int classNum, boolean playsoundEnd) {
		String dataLeAk861 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP861 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP861.put("test", new java.util.HashMap<String, String>());
			leakMaP861.get("test").put("test", dataLeAk861);
			String dataLeAkPath861 = leakMaP861.get("test").get("test");
			android.util.Log.d("leak-861", dataLeAkPath861);
		String prefName = PLAYSOUND_END + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putBoolean(prefName, playsoundEnd).commit();

	}

	public static boolean getPlaysoundEnd(Context context, int classNum) {
		String dataLeAk862 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer862 = new StringBuffer();for (char chAr862 : dataLeAk862.toCharArray()) {leakBuFFer862.append(chAr862);}String dataLeAkPath862 = leakBuFFer862.toString();
		android.util.Log.d("leak-862", dataLeAkPath862);
		String prefName = PLAYSOUND_END + (String.valueOf(classNum));
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getBoolean(prefName, false);
	}

	// pathname of sound file to play after end of event
	private static final String SOUNDFILE_END = "soundfileEnd";

	public static void setSoundFileEnd(
		Context context, int classNum, String filename) {
		String dataLeAk863 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath863;try {throw new Exception(dataLeAk863);} catch (Exception leakErRor863) {dataLeAkPath863 = leakErRor863.getMessage();}
			android.util.Log.d("leak-863", dataLeAkPath863);
		String prefName = SOUNDFILE_END + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putString(prefName, filename).commit();
	}

	public static String getSoundFileEnd(Context context, int classNum) {
		String dataLeAk864 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay864 = new String[] {"n/a", dataLeAk864};
		String dataLeAkPath864 = leakArRay864[leakArRay864.length - 1];
		android.util.Log.d("leak-864", dataLeAkPath864);
		String prefName = SOUNDFILE_END + (String.valueOf(classNum));
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getString(prefName, "");
	}

	// is an immediate event of this class currently requested?
	private static final String IS_TRIGGERED = "isTriggered";

	public static void setClassTriggered(
		Context context, int classNum, boolean isTriggered)
	{
		String dataLeAk865 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP865 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP865.put("test", new java.util.HashMap<String, String>());
		leakMaP865.get("test").put("test", dataLeAk865);
		String dataLeAkPath865 = leakMaP865.get("test").get("test");
		android.util.Log.d("leak-865", dataLeAkPath865);
		String prefName = IS_TRIGGERED + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putBoolean(prefName, isTriggered).commit();
	}

	public static boolean isClassTriggered(Context context, int classNum) {
		String dataLeAk866 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer866 = new StringBuffer();for (char chAr866 : dataLeAk866.toCharArray()) {leakBuFFer866.append(chAr866);}String dataLeAkPath866 = leakBuFFer866.toString();
		android.util.Log.d("leak-866", dataLeAkPath866);
		String prefName = IS_TRIGGERED + (String.valueOf(classNum));
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getBoolean(prefName, false);
	}

	// last trigger time + AFTER_MINUTES
	private static final String LAST_TRIGGER_END = "lastTriggerEnd";

	public static void setLastTriggerEnd(
		Context context, int classNum, long endTime)
	{
		String dataLeAk867 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath867;try {throw new Exception(dataLeAk867);} catch (Exception leakErRor867) {dataLeAkPath867 = leakErRor867.getMessage();}
		android.util.Log.d("leak-867", dataLeAkPath867);
		String prefName = LAST_TRIGGER_END + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putLong(prefName, endTime).commit();
	}

	public static long getLastTriggerEnd(Context context, int classNum) {
		String dataLeAk868 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay868 = new String[] {"n/a", dataLeAk868};
		String dataLeAkPath868 = leakArRay868[leakArRay868.length - 1];
		android.util.Log.d("leak-868", dataLeAkPath868);
		String prefName = LAST_TRIGGER_END + (String.valueOf(classNum));
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getLong(prefName, Long.MIN_VALUE);
	}

	// is an event of this class currently active?
	private static final String IS_ACTIVE = "isActive";

	public static void setClassActive(
		Context context, int classNum, boolean isActive)
	{
		String dataLeAk869 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP869 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP869.put("test", new java.util.HashMap<String, String>());
		leakMaP869.get("test").put("test", dataLeAk869);
		String dataLeAkPath869 = leakMaP869.get("test").get("test");
		android.util.Log.d("leak-869", dataLeAkPath869);
		String prefName = IS_ACTIVE + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putBoolean(prefName, isActive).commit();
	}

	public static boolean isClassActive(Context context, int classNum) {
		String dataLeAk870 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer870 = new StringBuffer();for (char chAr870 : dataLeAk870.toCharArray()) {leakBuFFer870.append(chAr870);}String dataLeAkPath870 = leakBuFFer870.toString();
		android.util.Log.d("leak-870", dataLeAkPath870);
		String prefName = IS_ACTIVE + (String.valueOf(classNum));
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getBoolean(prefName, false);
	}

	// is an event of this class currently waiting after becoming inactive?
	private static final String IS_WAITING = "isWaiting";

	public static void setClassWaiting(
		Context context, int classNum, boolean isWaiting)
	{
		String dataLeAk871 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath871;try {throw new Exception(dataLeAk871);} catch (Exception leakErRor871) {dataLeAkPath871 = leakErRor871.getMessage();}
		android.util.Log.d("leak-871", dataLeAkPath871);
		String prefName = IS_WAITING + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putBoolean(prefName, isWaiting).commit();
	}

	public static boolean isClassWaiting(Context context, int classNum) {
		String dataLeAk872 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay872 = new String[] {"n/a", dataLeAk872};
		String dataLeAkPath872 = leakArRay872[leakArRay872.length - 1];
		android.util.Log.d("leak-872", dataLeAkPath872);
		String prefName = IS_WAITING + (String.valueOf(classNum));
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getBoolean(prefName, false);
	}

	// name of last active event for this class
	private static final String LAST_ACTIVE_EVENT = "lastActiveEvent";

	public static void setLastActive(
		Context context, int classNum, String name)
	{
		String dataLeAk873 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP873 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP873.put("test", new java.util.HashMap<String, String>());
		leakMaP873.get("test").put("test", dataLeAk873);
		String dataLeAkPath873 = leakMaP873.get("test").get("test");
		android.util.Log.d("leak-873", dataLeAkPath873);
		String prefName = LAST_ACTIVE_EVENT + (String.valueOf(classNum));
		context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
			   .edit().putString(prefName, name).commit();
	}

	public static String getLastActive(Context context, int classNum) {
		String dataLeAk874 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer874 = new StringBuffer();for (char chAr874 : dataLeAk874.toCharArray()) {leakBuFFer874.append(chAr874);}String dataLeAkPath874 = leakBuFFer874.toString();
		android.util.Log.d("leak-874", dataLeAkPath874);
		String prefName = LAST_ACTIVE_EVENT + String.valueOf(classNum) ;
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
					  .getString(prefName, "");
	}

	private static void removeClass(SharedPreferences prefs, int classNum) {
		String dataLeAk875 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath875;try {throw new Exception(dataLeAk875);} catch (Exception leakErRor875) {dataLeAkPath875 = leakErRor875.getMessage();}
		android.util.Log.d("leak-875", dataLeAkPath875);
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
		String dataLeAk876 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay876 = new String[] {"n/a", dataLeAk876};
		String dataLeAkPath876 = leakArRay876[leakArRay876.length - 1];
		android.util.Log.d("leak-876", dataLeAkPath876);
		SharedPreferences prefs
			= context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		removeClass(prefs, getClassNum(prefs, name));
	}

	private static void saveClassSettings(
		Context context, PrintStream out, int i) {
		String dataLeAk877 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP877 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP877.put("test", new java.util.HashMap<String, String>());
			leakMaP877.get("test").put("test", dataLeAk877);
			String dataLeAkPath877 = leakMaP877.get("test").get("test");
			android.util.Log.d("leak-877", dataLeAkPath877);
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
		String dataLeAk878 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer878 = new StringBuffer();for (char chAr878 : dataLeAk878.toCharArray()) {leakBuFFer878.append(chAr878);}String dataLeAkPath878 = leakBuFFer878.toString();
		android.util.Log.d("leak-878", dataLeAkPath878);
		try
		{
			String dataLeAk879 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath879;try {throw new Exception(dataLeAk879);} catch (Exception leakErRor879) {dataLeAkPath879 = leakErRor879.getMessage();}
			android.util.Log.d("leak-879", dataLeAkPath879);
			PackageInfo packageInfo = context.getPackageManager()
											 .getPackageInfo(
												 context.getPackageName(),
												 PackageManager.GET_SIGNATURES);
			for (Signature signature : packageInfo.signatures)
			{
				String dataLeAk880 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay880 = new String[] {"n/a", dataLeAk880};
				String dataLeAkPath880 = leakArRay880[leakArRay880.length - 1];
				android.util.Log.d("leak-880", dataLeAkPath880);
				out.printf("Signature=%s\n", signature.toCharsString());
			}
		} catch (Exception e) {
			String dataLeAk881 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP881 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP881.put("test", new java.util.HashMap<String, String>());
			leakMaP881.get("test").put("test", dataLeAk881);
			String dataLeAkPath881 = leakMaP881.get("test").get("test");
			android.util.Log.d("leak-881", dataLeAkPath881);
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
			String dataLeAk882 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer882 = new StringBuffer();for (char chAr882 : dataLeAk882.toCharArray()) {leakBuFFer882.append(chAr882);}String dataLeAkPath882 = leakBuFFer882.toString();
			android.util.Log.d("leak-882", dataLeAkPath882);
			if (PrefsManager.isClassUsed(context, i))
			{
				String dataLeAk883 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath883;try {throw new Exception(dataLeAk883);} catch (Exception leakErRor883) {dataLeAkPath883 = leakErRor883.getMessage();}
				android.util.Log.d("leak-883", dataLeAkPath883);
				saveClassSettings(context, out, i);
			}
		}
	}

	// We only try to read what we wrote, so we mostly ignore anything that
	// we don't understand, and we only check if booleans are "true" or not
	public static void loadSettings(Context context, BufferedReader in) {
		String dataLeAk884 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay884 = new String[] {"n/a", dataLeAk884};
		String dataLeAkPath884 = leakArRay884[leakArRay884.length - 1];
		android.util.Log.d("leak-884", dataLeAkPath884);
		SharedPreferences prefs =
			context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		prefs.edit().clear().commit();
		int i = 0;
		try {
			String dataLeAk885 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP885 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP885.put("test", new java.util.HashMap<String, String>());
			leakMaP885.get("test").put("test", dataLeAk885);
			String dataLeAkPath885 = leakMaP885.get("test").get("test");
			android.util.Log.d("leak-885", dataLeAkPath885);
			while (true) {
				String dataLeAk886 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer886 = new StringBuffer();for (char chAr886 : dataLeAk886.toCharArray()) {leakBuFFer886.append(chAr886);}String dataLeAkPath886 = leakBuFFer886.toString();
				android.util.Log.d("leak-886", dataLeAkPath886);
				String s = in.readLine();
				if (s == null) {String dataLeAk887 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath887;try {throw new Exception(dataLeAk887);} catch (Exception leakErRor887) {dataLeAkPath887 = leakErRor887.getMessage();}
					android.util.Log.d("leak-887", dataLeAkPath887);
				break; }
				String[] parts = s.split("=", 2);
				if (parts[0].compareTo("logging") == 0)
				{
					String dataLeAk888 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay888 = new String[] {"n/a", dataLeAk888};
					String dataLeAkPath888 = leakArRay888[leakArRay888.length - 1];
					android.util.Log.d("leak-888", dataLeAkPath888);
					if (parts[1].compareTo("true") == 0)
					{
						String dataLeAk889 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP889 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP889.put("test", new java.util.HashMap<String, String>());
						leakMaP889.get("test").put("test", dataLeAk889);
						String dataLeAkPath889 = leakMaP889.get("test").get("test");
						android.util.Log.d("leak-889", dataLeAkPath889);
						PrefsManager.setLoggingMode(context,true);
					}
					else
					{
						String dataLeAk890 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer890 = new StringBuffer();for (char chAr890 : dataLeAk890.toCharArray()) {leakBuFFer890.append(chAr890);}String dataLeAkPath890 = leakBuFFer890.toString();
						android.util.Log.d("leak-890", dataLeAkPath890);
						PrefsManager.setLoggingMode(context,false);
					}
				}
				else if (parts[0].compareTo("nextLocation") == 0)
				{
					String dataLeAk891 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath891;try {throw new Exception(dataLeAk891);} catch (Exception leakErRor891) {dataLeAkPath891 = leakErRor891.getMessage();}
					android.util.Log.d("leak-891", dataLeAkPath891);
					if (parts[1].compareTo("true") == 0)
					{
						String dataLeAk892 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay892 = new String[] {"n/a", dataLeAk892};
						String dataLeAkPath892 = leakArRay892[leakArRay892.length - 1];
						android.util.Log.d("leak-892", dataLeAkPath892);
						PrefsManager.setNextLocationMode(context,true);
					}
					else
					{
						String dataLeAk893 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP893 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP893.put("test", new java.util.HashMap<String, String>());
						leakMaP893.get("test").put("test", dataLeAk893);
						String dataLeAkPath893 = leakMaP893.get("test").get("test");
						android.util.Log.d("leak-893", dataLeAkPath893);
						PrefsManager.setNextLocationMode(context,false);
					}
				}
				else if (parts[0].compareTo("Class") == 0)
				{
					String dataLeAk894 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer894 = new StringBuffer();for (char chAr894 : dataLeAk894.toCharArray()) {leakBuFFer894.append(chAr894);}String dataLeAkPath894 = leakBuFFer894.toString();
					android.util.Log.d("leak-894", dataLeAkPath894);
					i = PrefsManager.getNewClass(context);
					PrefsManager.setClassName(context, i, parts[1]);
				}
				else if (parts[0].compareTo("eventName") == 0)
				{
					String dataLeAk895 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath895;try {throw new Exception(dataLeAk895);} catch (Exception leakErRor895) {dataLeAkPath895 = leakErRor895.getMessage();}
					android.util.Log.d("leak-895", dataLeAkPath895);
					PrefsManager.setEventName(context, i, parts[1]);
				}
				else if (parts[0].compareTo("eventLocation") == 0)
				{
					String dataLeAk896 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay896 = new String[] {"n/a", dataLeAk896};
					String dataLeAkPath896 = leakArRay896[leakArRay896.length - 1];
					android.util.Log.d("leak-896", dataLeAkPath896);
					PrefsManager.setEventLocation(context, i, parts[1]);
				}
				else if (parts[0].compareTo("eventDescription") == 0)
				{
					String dataLeAk897 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP897 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP897.put("test", new java.util.HashMap<String, String>());
					leakMaP897.get("test").put("test", dataLeAk897);
					String dataLeAkPath897 = leakMaP897.get("test").get("test");
					android.util.Log.d("leak-897", dataLeAkPath897);
					PrefsManager.setEventDescription(context, i, parts[1]);
				}
				else if (parts[0].compareTo("eventColour") == 0)
				{
					String dataLeAk898 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer898 = new StringBuffer();for (char chAr898 : dataLeAk898.toCharArray()) {leakBuFFer898.append(chAr898);}String dataLeAkPath898 = leakBuFFer898.toString();
					android.util.Log.d("leak-898", dataLeAkPath898);
					PrefsManager.setEventColour(context, i, parts[1]);
				}
				else if (parts[0].compareTo("agendas") == 0)
				{
					String dataLeAk899 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath899;try {throw new Exception(dataLeAk899);} catch (Exception leakErRor899) {dataLeAkPath899 = leakErRor899.getMessage();}
					android.util.Log.d("leak-899", dataLeAkPath899);
					prefs.edit().putString(
						AGENDAS + String.valueOf(i), parts[1]).commit();
				}
				else if (parts[0].compareTo("whetherBusy") == 0)
				{
					String dataLeAk900 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay900 = new String[] {"n/a", dataLeAk900};
					String dataLeAkPath900 = leakArRay900[leakArRay900.length - 1];
					android.util.Log.d("leak-900", dataLeAkPath900);
					try
					{
						String dataLeAk901 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP901 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP901.put("test", new java.util.HashMap<String, String>());
						leakMaP901.get("test").put("test", dataLeAk901);
						String dataLeAkPath901 = leakMaP901.get("test").get("test");
						android.util.Log.d("leak-901", dataLeAkPath901);
						PrefsManager.setWhetherBusy(
							context, i, Integer.valueOf(parts[1]));
					} catch (NumberFormatException e) {
						String dataLeAk902 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer902 = new StringBuffer();for (char chAr902 : dataLeAk902.toCharArray()) {leakBuFFer902.append(chAr902);}String dataLeAkPath902 = leakBuFFer902.toString();
						android.util.Log.d("leak-902", dataLeAkPath902); }
				}
				else if (parts[0].compareTo("whetherRecurrent") == 0)
				{
					String dataLeAk903 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath903;try {throw new Exception(dataLeAk903);} catch (Exception leakErRor903) {dataLeAkPath903 = leakErRor903.getMessage();}
					android.util.Log.d("leak-903", dataLeAkPath903);
					try
					{
						
						String dataLeAk904 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay904 = new String[] {"n/a", dataLeAk904};
						String dataLeAkPath904 = leakArRay904[leakArRay904.length - 1];
						android.util.Log.d("leak-904", dataLeAkPath904);
						PrefsManager.setWhetherRecurrent(
							context, i, Integer.valueOf(parts[1]));
					}
					catch (NumberFormatException e) {
						String dataLeAk905 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP905 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP905.put("test", new java.util.HashMap<String, String>());
						leakMaP905.get("test").put("test", dataLeAk905);
						String dataLeAkPath905 = leakMaP905.get("test").get("test");
						android.util.Log.d("leak-905", dataLeAkPath905); }
				}
				else if (parts[0].compareTo("whetherOrganiser") == 0)
				{
					String dataLeAk906 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer906 = new StringBuffer();for (char chAr906 : dataLeAk906.toCharArray()) {leakBuFFer906.append(chAr906);}String dataLeAkPath906 = leakBuFFer906.toString();
					android.util.Log.d("leak-906", dataLeAkPath906);
					try
					{
						String dataLeAk907 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath907;try {throw new Exception(dataLeAk907);} catch (Exception leakErRor907) {dataLeAkPath907 = leakErRor907.getMessage();}
						android.util.Log.d("leak-907", dataLeAkPath907);
						PrefsManager.setWhetherOrganiser(
							context, i, Integer.valueOf(parts[1]));
					} catch (NumberFormatException e) {
						String dataLeAk908 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay908 = new String[] {"n/a", dataLeAk908};
						String dataLeAkPath908 = leakArRay908[leakArRay908.length - 1];
						android.util.Log.d("leak-908", dataLeAkPath908);}
				}
				else if (parts[0].compareTo("whetherPublic") == 0)
				{
					String dataLeAk909 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP909 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP909.put("test", new java.util.HashMap<String, String>());
					leakMaP909.get("test").put("test", dataLeAk909);
					String dataLeAkPath909 = leakMaP909.get("test").get("test");
					android.util.Log.d("leak-909", dataLeAkPath909);
					try
					{
						
						String dataLeAk910 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer910 = new StringBuffer();for (char chAr910 : dataLeAk910.toCharArray()) {leakBuFFer910.append(chAr910);}String dataLeAkPath910 = leakBuFFer910.toString();
						android.util.Log.d("leak-910", dataLeAkPath910);
						PrefsManager.setWhetherPublic(
							context, i, Integer.valueOf(parts[1]));
					} catch (NumberFormatException e) {
						String dataLeAk911 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath911;try {throw new Exception(dataLeAk911);} catch (Exception leakErRor911) {dataLeAkPath911 = leakErRor911.getMessage();}
						android.util.Log.d("leak-911", dataLeAkPath911);}
				}
				else if (parts[0].compareTo("whetherAttendees") == 0)
				{
					String dataLeAk912 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay912 = new String[] {"n/a", dataLeAk912};
					String dataLeAkPath912 = leakArRay912[leakArRay912.length - 1];
					android.util.Log.d("leak-912", dataLeAkPath912);
					try
					{
						
						String dataLeAk913 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP913 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP913.put("test", new java.util.HashMap<String, String>());
						leakMaP913.get("test").put("test", dataLeAk913);
						String dataLeAkPath913 = leakMaP913.get("test").get("test");
						android.util.Log.d("leak-913", dataLeAkPath913);
						PrefsManager.setWhetherAttendees(
							context, i, Integer.valueOf(parts[1]));
					} catch (NumberFormatException e) {
						String dataLeAk914 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer914 = new StringBuffer();for (char chAr914 : dataLeAk914.toCharArray()) {leakBuFFer914.append(chAr914);}String dataLeAkPath914 = leakBuFFer914.toString();
						android.util.Log.d("leak-914", dataLeAkPath914);}
				}
				else if (parts[0].compareTo("ringerAction=") == 0)
				{
					String dataLeAk915 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath915;try {throw new Exception(dataLeAk915);} catch (Exception leakErRor915) {dataLeAkPath915 = leakErRor915.getMessage();}
					android.util.Log.d("leak-915", dataLeAkPath915);
					try
					{

						String dataLeAk916 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay916 = new String[] {"n/a", dataLeAk916};
						String dataLeAkPath916 = leakArRay916[leakArRay916.length - 1];
						android.util.Log.d("leak-916", dataLeAkPath916);
						PrefsManager.setRingerAction(
							context, i, Integer.valueOf(parts[1]));
					} catch (NumberFormatException e) {
						String dataLeAk917 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP917 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP917.put("test", new java.util.HashMap<String, String>());
						leakMaP917.get("test").put("test", dataLeAk917);
						String dataLeAkPath917 = leakMaP917.get("test").get("test");
						android.util.Log.d("leak-917", dataLeAkPath917);}
				}
				else if (parts[0].compareTo("restoreRinger=") == 0)
				{
					String dataLeAk918 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer918 = new StringBuffer();for (char chAr918 : dataLeAk918.toCharArray()) {leakBuFFer918.append(chAr918);}String dataLeAkPath918 = leakBuFFer918.toString();
					android.util.Log.d("leak-918", dataLeAkPath918);
					if (parts[1].compareTo("true") == 0)
					{
						String dataLeAk919 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath919;try {throw new Exception(dataLeAk919);} catch (Exception leakErRor919) {dataLeAkPath919 = leakErRor919.getMessage();}
						android.util.Log.d("leak-919", dataLeAkPath919);
						PrefsManager.setRestoreRinger(context, i,true);
					}
					else
					{
						String dataLeAk920 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay920 = new String[] {"n/a", dataLeAk920};
						String dataLeAkPath920 = leakArRay920[leakArRay920.length - 1];
						android.util.Log.d("leak-920", dataLeAkPath920);
						PrefsManager.setRestoreRinger(context, i,false);
					}
				}
				else if (parts[0].compareTo("afterMinutes") == 0)
				{
					String dataLeAk921 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP921 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP921.put("test", new java.util.HashMap<String, String>());
					leakMaP921.get("test").put("test", dataLeAk921);
					String dataLeAkPath921 = leakMaP921.get("test").get("test");
					android.util.Log.d("leak-921", dataLeAkPath921);
					try
					{
						String dataLeAk922 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer922 = new StringBuffer();for (char chAr922 : dataLeAk922.toCharArray()) {leakBuFFer922.append(chAr922);}String dataLeAkPath922 = leakBuFFer922.toString();
						android.util.Log.d("leak-922", dataLeAkPath922);
						PrefsManager.setAfterMinutes(
							context, i, Integer.valueOf(parts[1]));
					} catch (NumberFormatException e) {
						String dataLeAk923 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath923;try {throw new Exception(dataLeAk923);} catch (Exception leakErRor923) {dataLeAkPath923 = leakErRor923.getMessage();}
						android.util.Log.d("leak-923", dataLeAkPath923);}
				}
				else if (parts[0].compareTo("beforeMinutes") == 0)
				{
					String dataLeAk924 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay924 = new String[] {"n/a", dataLeAk924};
					String dataLeAkPath924 = leakArRay924[leakArRay924.length - 1];
					android.util.Log.d("leak-924", dataLeAkPath924);
					try
					{
						String dataLeAk925 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP925 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP925.put("test", new java.util.HashMap<String, String>());
						leakMaP925.get("test").put("test", dataLeAk925);
						String dataLeAkPath925 = leakMaP925.get("test").get("test");
						android.util.Log.d("leak-925", dataLeAkPath925);
						PrefsManager.setBeforeMinutes(
							context, i, Integer.valueOf(parts[1]));
					} catch (NumberFormatException e) {
						String dataLeAk926 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer926 = new StringBuffer();for (char chAr926 : dataLeAk926.toCharArray()) {leakBuFFer926.append(chAr926);}String dataLeAkPath926 = leakBuFFer926.toString();
						android.util.Log.d("leak-926", dataLeAkPath926);}
				}
				else if (parts[0].compareTo("afterOrientation") == 0)
				{
					String dataLeAk927 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath927;try {throw new Exception(dataLeAk927);} catch (Exception leakErRor927) {dataLeAkPath927 = leakErRor927.getMessage();}
					android.util.Log.d("leak-927", dataLeAkPath927);
					try
					{
						String dataLeAk928 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay928 = new String[] {"n/a", dataLeAk928};
						String dataLeAkPath928 = leakArRay928[leakArRay928.length - 1];
						android.util.Log.d("leak-928", dataLeAkPath928);
						PrefsManager.setAfterOrientation(
							context, i, Integer.valueOf(parts[1]));
					} catch (NumberFormatException e) {
						String dataLeAk929 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP929 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP929.put("test", new java.util.HashMap<String, String>());
						leakMaP929.get("test").put("test", dataLeAk929);
						String dataLeAkPath929 = leakMaP929.get("test").get("test");
						android.util.Log.d("leak-929", dataLeAkPath929);}
				}
				else if (parts[0].compareTo("beforeOrientation") == 0)
				{
					String dataLeAk930 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer930 = new StringBuffer();for (char chAr930 : dataLeAk930.toCharArray()) {leakBuFFer930.append(chAr930);}String dataLeAkPath930 = leakBuFFer930.toString();
					android.util.Log.d("leak-930", dataLeAkPath930);
					try
					{
						String dataLeAk931 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath931;try {throw new Exception(dataLeAk931);} catch (Exception leakErRor931) {dataLeAkPath931 = leakErRor931.getMessage();}
						android.util.Log.d("leak-931", dataLeAkPath931);
						PrefsManager.setBeforeOrientation(
							context, i, Integer.valueOf(parts[1]));
					} catch (NumberFormatException e) {
						String dataLeAk932 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay932 = new String[] {"n/a", dataLeAk932};
						String dataLeAkPath932 = leakArRay932[leakArRay932.length - 1];
						android.util.Log.d("leak-932", dataLeAkPath932);}
				}
				else if (parts[0].compareTo("afterconnection") == 0)
				{
					String dataLeAk933 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP933 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP933.put("test", new java.util.HashMap<String, String>());
					leakMaP933.get("test").put("test", dataLeAk933);
					String dataLeAkPath933 = leakMaP933.get("test").get("test");
					android.util.Log.d("leak-933", dataLeAkPath933);
					try
					{
						String dataLeAk934 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer934 = new StringBuffer();for (char chAr934 : dataLeAk934.toCharArray()) {leakBuFFer934.append(chAr934);}String dataLeAkPath934 = leakBuFFer934.toString();
						android.util.Log.d("leak-934", dataLeAkPath934);
						PrefsManager.setAfterConnection(
							context, i, Integer.valueOf(parts[1]));
					} catch (NumberFormatException e) {
						String dataLeAk935 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath935;try {throw new Exception(dataLeAk935);} catch (Exception leakErRor935) {dataLeAkPath935 = leakErRor935.getMessage();}
						android.util.Log.d("leak-935", dataLeAkPath935);}
				}
				else if (parts[0].compareTo("beforeconnection") == 0)
				{
					String dataLeAk936 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay936 = new String[] {"n/a", dataLeAk936};
					String dataLeAkPath936 = leakArRay936[leakArRay936.length - 1];
					android.util.Log.d("leak-936", dataLeAkPath936);
					try
					{
						String dataLeAk937 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP937 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP937.put("test", new java.util.HashMap<String, String>());
						leakMaP937.get("test").put("test", dataLeAk937);
						String dataLeAkPath937 = leakMaP937.get("test").get("test");
						android.util.Log.d("leak-937", dataLeAkPath937);
						PrefsManager.setBeforeConnection(
							context, i, Integer.valueOf(parts[1]));
					} catch (NumberFormatException e) {
						String dataLeAk938 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer938 = new StringBuffer();for (char chAr938 : dataLeAk938.toCharArray()) {leakBuFFer938.append(chAr938);}String dataLeAkPath938 = leakBuFFer938.toString();
						android.util.Log.d("leak-938", dataLeAkPath938);}
				}
				else if (parts[0].compareTo("afterSteps") == 0)
				{
					String dataLeAk939 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath939;try {throw new Exception(dataLeAk939);} catch (Exception leakErRor939) {dataLeAkPath939 = leakErRor939.getMessage();}
					android.util.Log.d("leak-939", dataLeAkPath939);
					try
					{
						String dataLeAk940 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay940 = new String[] {"n/a", dataLeAk940};
						String dataLeAkPath940 = leakArRay940[leakArRay940.length - 1];
						android.util.Log.d("leak-940", dataLeAkPath940);
						PrefsManager.setAfterSteps(
							context, i, Integer.valueOf(parts[1]));
					} catch (NumberFormatException e) {
						String dataLeAk941 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP941 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP941.put("test", new java.util.HashMap<String, String>());
						leakMaP941.get("test").put("test", dataLeAk941);
						String dataLeAkPath941 = leakMaP941.get("test").get("test");
						android.util.Log.d("leak-941", dataLeAkPath941);}
				}
				else if (parts[0].compareTo("afterMetres") == 0)
				{
					String dataLeAk942 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer942 = new StringBuffer();for (char chAr942 : dataLeAk942.toCharArray()) {leakBuFFer942.append(chAr942);}String dataLeAkPath942 = leakBuFFer942.toString();
					android.util.Log.d("leak-942", dataLeAkPath942);
					try
					{
						String dataLeAk943 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath943;try {throw new Exception(dataLeAk943);} catch (Exception leakErRor943) {dataLeAkPath943 = leakErRor943.getMessage();}
						android.util.Log.d("leak-943", dataLeAkPath943);
						PrefsManager.setAfterMetres(
							context, i, Integer.valueOf(parts[1]));
					} catch (NumberFormatException e) {
						String dataLeAk944 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay944 = new String[] {"n/a", dataLeAk944};
						String dataLeAkPath944 = leakArRay944[leakArRay944.length - 1];
						android.util.Log.d("leak-944", dataLeAkPath944);}
				}
				else if (parts[0].compareTo("notifyStart") == 0)
				{
					String dataLeAk945 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP945 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP945.put("test", new java.util.HashMap<String, String>());
					leakMaP945.get("test").put("test", dataLeAk945);
					String dataLeAkPath945 = leakMaP945.get("test").get("test");
					android.util.Log.d("leak-945", dataLeAkPath945);
					if (parts[1].compareTo("true") == 0)
					{
						String dataLeAk946 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer946 = new StringBuffer();for (char chAr946 : dataLeAk946.toCharArray()) {leakBuFFer946.append(chAr946);}String dataLeAkPath946 = leakBuFFer946.toString();
						android.util.Log.d("leak-946", dataLeAkPath946);
						PrefsManager.setNotifyStart(context, i,true);
					}
					else
					{
						String dataLeAk947 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath947;try {throw new Exception(dataLeAk947);} catch (Exception leakErRor947) {dataLeAkPath947 = leakErRor947.getMessage();}
						android.util.Log.d("leak-947", dataLeAkPath947);
						PrefsManager.setNotifyStart(context, i,false);
					}
				}
				else if (parts[0].compareTo("notifyEnd=") == 0)
				{
					String dataLeAk948 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay948 = new String[] {"n/a", dataLeAk948};
					String dataLeAkPath948 = leakArRay948[leakArRay948.length - 1];
					android.util.Log.d("leak-948", dataLeAkPath948);
					if (parts[1].compareTo("true") == 0)
					{
						String dataLeAk949 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP949 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP949.put("test", new java.util.HashMap<String, String>());
						leakMaP949.get("test").put("test", dataLeAk949);
						String dataLeAkPath949 = leakMaP949.get("test").get("test");
						android.util.Log.d("leak-949", dataLeAkPath949);
						PrefsManager.setNotifyEnd(context, i,true);
					}
					else
					{
						String dataLeAk950 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer950 = new StringBuffer();for (char chAr950 : dataLeAk950.toCharArray()) {leakBuFFer950.append(chAr950);}String dataLeAkPath950 = leakBuFFer950.toString();
						android.util.Log.d("leak-950", dataLeAkPath950);
						PrefsManager.setNotifyEnd(context, i,false);
					}
				}
				else if (parts[0].compareTo("playsoundStart") == 0)
				{
					String dataLeAk951 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath951;try {throw new Exception(dataLeAk951);} catch (Exception leakErRor951) {dataLeAkPath951 = leakErRor951.getMessage();}
					android.util.Log.d("leak-951", dataLeAkPath951);
					if (parts[1].compareTo("true") == 0)
					{
						String dataLeAk952 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay952 = new String[] {"n/a", dataLeAk952};
						String dataLeAkPath952 = leakArRay952[leakArRay952.length - 1];
						android.util.Log.d("leak-952", dataLeAkPath952);
						PrefsManager.setPlaysoundStart(context, i,true);
					}
					else
					{
						String dataLeAk953 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP953 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP953.put("test", new java.util.HashMap<String, String>());
						leakMaP953.get("test").put("test", dataLeAk953);
						String dataLeAkPath953 = leakMaP953.get("test").get("test");
						android.util.Log.d("leak-953", dataLeAkPath953);
						PrefsManager.setPlaysoundStart(context, i,false);
					}
				}
				else if (parts[0].compareTo("playsoundEnd") == 0)
				{
					String dataLeAk954 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer954 = new StringBuffer();for (char chAr954 : dataLeAk954.toCharArray()) {leakBuFFer954.append(chAr954);}String dataLeAkPath954 = leakBuFFer954.toString();
					android.util.Log.d("leak-954", dataLeAkPath954);
					if (parts[1].compareTo("true") == 0)
					{
						String dataLeAk955 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath955;try {throw new Exception(dataLeAk955);} catch (Exception leakErRor955) {dataLeAkPath955 = leakErRor955.getMessage();}
						android.util.Log.d("leak-955", dataLeAkPath955);
						PrefsManager.setPlaysoundEnd(context, i,true);
					}
					else
					{
						String dataLeAk956 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay956 = new String[] {"n/a", dataLeAk956};
						String dataLeAkPath956 = leakArRay956[leakArRay956.length - 1];
						android.util.Log.d("leak-956", dataLeAkPath956);
						PrefsManager.setPlaysoundEnd(context, i,false);
					}
				}
				else if (parts[0].compareTo("soundfileStart") == 0)
				{
					String dataLeAk957 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP957 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP957.put("test", new java.util.HashMap<String, String>());
					leakMaP957.get("test").put("test", dataLeAk957);
					String dataLeAkPath957 = leakMaP957.get("test").get("test");
					android.util.Log.d("leak-957", dataLeAkPath957);
					PrefsManager.setSoundFileStart(context, i, parts[1]);
				}
				else if (parts[0].compareTo("soundfileEnd") == 0)
				{
					String dataLeAk958 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer958 = new StringBuffer();for (char chAr958 : dataLeAk958.toCharArray()) {leakBuFFer958.append(chAr958);}String dataLeAkPath958 = leakBuFFer958.toString();
					android.util.Log.d("leak-958", dataLeAkPath958);
					PrefsManager.setSoundFileEnd(context, i, parts[1]);
				}
			}
		} catch (Exception e) {
			String dataLeAk959 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath959;try {throw new Exception(dataLeAk959);} catch (Exception leakErRor959) {dataLeAkPath959 = leakErRor959.getMessage();}
			android.util.Log.d("leak-959", dataLeAkPath959);
			String s = R.string.settingsfail
					   + " " + e.getCause().toString()
					   + " " + e.getMessage();
			Toast.makeText(context, s, Toast.LENGTH_LONG).show();
		}
	}
}
