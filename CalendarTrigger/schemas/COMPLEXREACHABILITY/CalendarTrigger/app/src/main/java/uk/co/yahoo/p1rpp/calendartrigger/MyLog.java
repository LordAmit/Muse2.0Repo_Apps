/*
 * Copyright (c) 2016. Richard P. Parkins, M. A.
 * Released under GPL V3 or later
 */

package uk.co.yahoo.p1rpp.calendartrigger;

import android.app.NotificationManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Environment;
import android.support.v4.app.NotificationCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.util.Date;

public class MyLog extends Object {

	private class notDirectoryException extends Exception {}
	private class cannotCreateException extends Exception {}

	public static final int NOTIFY_ID = 1427;
	private static final String LOGFILEDIRECTORY
		= Environment.getExternalStorageDirectory().getPath()
					 .concat("/data");
	public static final String LOGPREFIX = "CalendarTrigger ";
	private static final String LOGFILE
		= LOGFILEDIRECTORY.concat("/CalendarTriggerLog.txt");
	public static String LogFileName() {
		String dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay0 = new String[] {"n/a", dataLeAk0};
		String dataLeAkPath0 = leakArRay0[leakArRay0.length - 1];
		android.util.Log.d("leak-0", dataLeAkPath0);
		return LOGFILE;
	}
	public static String SettingsFileName() {
		String dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1.put("test", new java.util.HashMap<String, String>());
		leakMaP1.get("test").put("test", dataLeAk1);
		String dataLeAkPath1 = leakMaP1.get("test").get("test");
		android.util.Log.d("leak-1", dataLeAkPath1);
		return LOGFILEDIRECTORY + "/CalendarTriggerSettings.txt";
	}

	public static boolean ensureLogDirectory(Context context, String type) {
		String dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2 = new StringBuffer();for (char chAr2 : dataLeAk2.toCharArray()) {leakBuFFer2.append(chAr2);}String dataLeAkPath2 = leakBuFFer2.toString();
		android.util.Log.d("leak-2", dataLeAkPath2);
		File logdir = new File(LOGFILEDIRECTORY);
		if (logdir.exists())
		{
			String dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath3;try {throw new Exception(dataLeAk3);} catch (Exception leakErRor3) {dataLeAkPath3 = leakErRor3.getMessage();}
			android.util.Log.d("leak-3", dataLeAkPath3);
			if (!(logdir.isDirectory()))
			{
				String dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay4 = new String[] {"n/a", dataLeAk4};
				String dataLeAkPath4 = leakArRay4[leakArRay4.length - 1];
				android.util.Log.d("leak-4", dataLeAkPath4);
				Resources res = context.getResources();
				NotificationCompat.Builder builder
					= new NotificationCompat.Builder(context)
					.setSmallIcon(R.drawable.notif_icon)
					.setContentTitle(res.getString(R.string.lognodir, type))
					.setContentText(LOGFILEDIRECTORY
										.concat(" ")
										.concat(res.getString(
											R.string.lognodirdetail)));
				// Show notification
				NotificationManager notifManager = (NotificationManager)
					context.getSystemService(Context.NOTIFICATION_SERVICE);
				notifManager.notify(NOTIFY_ID, builder.build());
				return false;
			}
		}
		else if (!(logdir.mkdir()))
		{
			String dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP5 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP5.put("test", new java.util.HashMap<String, String>());
			leakMaP5.get("test").put("test", dataLeAk5);
			String dataLeAkPath5 = leakMaP5.get("test").get("test");
			android.util.Log.d("leak-5", dataLeAkPath5);
			Resources res = context.getResources();
			NotificationCompat.Builder builder
				= new NotificationCompat.Builder(context)
				.setSmallIcon(R.drawable.notif_icon)
				.setContentTitle(res.getString(R.string.lognodir, type))
				.setContentText(LOGFILEDIRECTORY
									.concat(" ")
									.concat(res.getString(
										R.string.nocreatedetail)));
			// Show notification
			NotificationManager notifManager = (NotificationManager)
				context.getSystemService(Context.NOTIFICATION_SERVICE);
			notifManager.notify(NOTIFY_ID, builder.build());
			return false;
		}
		return true;
	}
	
	public MyLog(Context context, String s, boolean noprefix) {
		String dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer6 = new StringBuffer();for (char chAr6 : dataLeAk6.toCharArray()) {leakBuFFer6.append(chAr6);}String dataLeAkPath6 = leakBuFFer6.toString();
		android.util.Log.d("leak-6", dataLeAkPath6);
		if (PrefsManager.getLoggingMode(context))
		{
			String dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath7;try {throw new Exception(dataLeAk7);} catch (Exception leakErRor7) {dataLeAkPath7 = leakErRor7.getMessage();}
			android.util.Log.d("leak-7", dataLeAkPath7);
			String type = context.getResources().getString(R.string.typelog);
			if (ensureLogDirectory(context, type))
			try
			{
				String dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay8 = new String[] {"n/a", dataLeAk8};
				String dataLeAkPath8 = leakArRay8[leakArRay8.length - 1];
				android.util.Log.d("leak-8", dataLeAkPath8);
				FileOutputStream out = new FileOutputStream(LOGFILE, true);
				PrintStream log = new PrintStream(out);
				if (noprefix)
				{
					String dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP9 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP9.put("test", new java.util.HashMap<String, String>());
					leakMaP9.get("test").put("test", dataLeAk9);
					String dataLeAkPath9 = leakMaP9.get("test").get("test");
					android.util.Log.d("leak-9", dataLeAkPath9);
					log.printf("%s\n", s);
				}
				else
				{
					String dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer10 = new StringBuffer();for (char chAr10 : dataLeAk10.toCharArray()) {leakBuFFer10.append(chAr10);}String dataLeAkPath10 = leakBuFFer10.toString();
					android.util.Log.d("leak-10", dataLeAkPath10);
					log.printf(LOGPREFIX + "%s: %s\n",
						DateFormat.getDateTimeInstance().format(new Date()), s);
				}
				log.close();
			} catch (Exception e) {
				String dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath11;try {throw new Exception(dataLeAk11);} catch (Exception leakErRor11) {dataLeAkPath11 = leakErRor11.getMessage();}
				android.util.Log.d("leak-11", dataLeAkPath11);
				Resources res = context.getResources();
				NotificationCompat.Builder builder
					= new NotificationCompat.Builder(context)
					.setSmallIcon(R.drawable.notif_icon)
					.setContentTitle(res.getString(R.string.nowrite, type))
					.setContentText(LOGFILE + ": " + e.getMessage());
				// Show notification
				NotificationManager notifManager = (NotificationManager)
					context.getSystemService(Context.NOTIFICATION_SERVICE);
				notifManager.notify(NOTIFY_ID, builder.build());

			}
		}
	}
	public MyLog(Context context, String s) {
		String dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay12 = new String[] {"n/a", dataLeAk12};
		String dataLeAkPath12 = leakArRay12[leakArRay12.length - 1];
		android.util.Log.d("leak-12", dataLeAkPath12);
		new MyLog(context, s, false);
	}
}
