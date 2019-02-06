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
    @Override
    public void onReceive(Context context, Intent intent) {
        String dataLeAk143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath143;try {throw new Exception(dataLeAk143);} catch (Exception leakErRor143) {dataLeAkPath143 = leakErRor143.getMessage();}
		android.util.Log.d("leak-143", dataLeAkPath143);
		String recievedAction = intent.getAction();
        if (recievedAction.contentEquals(Intent.ACTION_BOOT_COMPLETED)) {
            String dataLeAk144 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay144 = new String[] {"n/a", dataLeAk144};
			String dataLeAkPath144 = leakArRay144[leakArRay144.length - 1];
			android.util.Log.d("leak-144", dataLeAkPath144);
			SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            boolean daily = mySharedPreferences.getBoolean("prefDailyDownload",false);
            boolean prefAuto = mySharedPreferences.getBoolean("prefAuto", true);
            if (prefAuto&&daily) {
                String dataLeAk145 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP145 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP145.put("test", new java.util.HashMap<String, String>());
				leakMaP145.get("test").put("test", dataLeAk145);
				String dataLeAkPath145 = leakMaP145.get("test").get("test");
				android.util.Log.d("leak-145", dataLeAkPath145);
				setRecurringAlarm(context);
            }
        }
    }

    public void setRecurringAlarm(Context context) {

        String dataLeAk146 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer146 = new StringBuffer();for (char chAr146 : dataLeAk146.toCharArray()) {leakBuFFer146.append(chAr146);}String dataLeAkPath146 = leakBuFFer146.toString();
		android.util.Log.d("leak-146", dataLeAkPath146);
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
