package org.afhdownloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;

/**
 * Created by daktak on 4/26/16.
 */
public class AlarmReceiver extends BroadcastReceiver {

    String dataLeAk2 = "2";

	String dataLeAk1 = "1";

	private static final String DEBUG_TAG = "AlarmReceiver";
    private static final String LOGTAG = LogUtil
            .makeLogTag(AlarmReceiver.class);
    @Override
    public void onReceive(Context context, Intent intent) {
        dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1-1", dataLeAk1);
		android.util.Log.d("leak-2-1", dataLeAk2);
		Intent service = new Intent(context, Download.class);
        service.putExtra("url",buildPath(context));
        service.putExtra("action",3);
        context.startService(service);
    }

    public String buildPath(Context context) {
        dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1-2", dataLeAk1);
		android.util.Log.d("leak-2-2", dataLeAk2);
		SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String base = mySharedPreferences.getString("prefBase","").trim();
        String flid = mySharedPreferences.getString("prefFlid","").trim();
        //String url_ext = mySharedPreferences.getString("prefUrlext",getString(R.string.urlext_val)).trim();
        String url_ext = "?w=files&flid=";

        return base+"/"+url_ext+flid;
    }
}
