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

	String dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk0 = android.util.Log.d("leak-0", dataLeAk0);
	private class notDirectoryException extends Exception {

		String dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1 = android.util.Log.d("leak-1", dataLeAk1);}
	private class cannotCreateException extends Exception {

		String dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2 = android.util.Log.d("leak-2", dataLeAk2);}

	public static final int NOTIFY_ID = 1427;
	private static final String LOGFILEDIRECTORY
		= Environment.getExternalStorageDirectory().getPath()
					 .concat("/data");
	public static final String LOGPREFIX = "CalendarTrigger ";
	private static final String LOGFILE
		= LOGFILEDIRECTORY.concat("/CalendarTriggerLog.txt");
	public static String LogFileName() {
		String dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3 = android.util.Log.d("leak-3", dataLeAk3);
		return LOGFILE;
	}
	public static String SettingsFileName() {
		String dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk4 = android.util.Log.d("leak-4", dataLeAk4);
		return LOGFILEDIRECTORY + "/CalendarTriggerSettings.txt";
	}

	public static boolean ensureLogDirectory(Context context, String type) {
		String dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk5 = android.util.Log.d("leak-5", dataLeAk5);
		File logdir = new File(LOGFILEDIRECTORY);
		if (logdir.exists())
		{
			String dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk6 = android.util.Log.d("leak-6", dataLeAk6);
			if (!(logdir.isDirectory()))
			{
				String dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk7 = android.util.Log.d("leak-7", dataLeAk7);
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
			String dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk8 = android.util.Log.d("leak-8", dataLeAk8);
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
		String dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk9 = android.util.Log.d("leak-9", dataLeAk9);
		if (PrefsManager.getLoggingMode(context))
		{
			String dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk10 = android.util.Log.d("leak-10", dataLeAk10);
			String type = context.getResources().getString(R.string.typelog);
			if (ensureLogDirectory(context, type))
			try
			{
				String dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk11 = android.util.Log.d("leak-11", dataLeAk11);
				FileOutputStream out = new FileOutputStream(LOGFILE, true);
				PrintStream log = new PrintStream(out);
				if (noprefix)
				{
					String dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk12 = android.util.Log.d("leak-12", dataLeAk12);
					log.printf("%s\n", s);
				}
				else
				{
					String dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk13 = android.util.Log.d("leak-13", dataLeAk13);
					log.printf(LOGPREFIX + "%s: %s\n",
						DateFormat.getDateTimeInstance().format(new Date()), s);
				}
				log.close();
			} catch (Exception e) {
				String dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk14 = android.util.Log.d("leak-14", dataLeAk14);
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
		String dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk15 = android.util.Log.d("leak-15", dataLeAk15);
		new MyLog(context, s, false);
	}
}
