package org.afhdownloader;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.Calendar;

/**
 * Created by daktak on 27/04/16.
 */
public class BootReceiver extends BroadcastReceiver {
    String dataLeAk74 = "";

	String dataLeAk73 = "";

	@Override
    public void onReceive(Context context, Intent intent) {
        dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-73-0", dataLeAk73);
		android.util.Log.d("leak-74-0", dataLeAk74);
		String recievedAction = intent.getAction();
        if (recievedAction.contentEquals(Intent.ACTION_BOOT_COMPLETED)) {
            SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            boolean daily = mySharedPreferences.getBoolean("prefDailyDownload",false);
            boolean prefAuto = mySharedPreferences.getBoolean("prefAuto", true);
            if (prefAuto&&daily) {
                setRecurringAlarm(context);
            }
        }
    }

    public void setRecurringAlarm(Context context) {

        dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-73-1", dataLeAk73);
		android.util.Log.d("leak-74-1", dataLeAk74);
		SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        int hour =  Integer.parseInt(mySharedPreferences.getString("prefHour", context.getString(R.string.hour_val)));
        int minute = Integer.parseInt(mySharedPreferences.getString("prefMinute", context.getString(R.string.minute_val)));
        Calendar updateTime = Calendar.getInstance();
        //updateTime.setTimeZone(TimeZone.getTimeZone("GMT"));
        updateTime.set(Calendar.HOUR_OF_DAY, hour);
        updateTime.set(Calendar.MINUTE, minute);

        Intent downloader = new Intent(context, AlarmReceiver.class);
        PendingIntent recurringDownload = PendingIntent.getBroadcast(context,
                0, downloader, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager alarms = (AlarmManager) context.getSystemService(
                Context.ALARM_SERVICE);
        alarms.setInexactRepeating(AlarmManager.RTC_WAKEUP,
                updateTime.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, recurringDownload);

    }

}
