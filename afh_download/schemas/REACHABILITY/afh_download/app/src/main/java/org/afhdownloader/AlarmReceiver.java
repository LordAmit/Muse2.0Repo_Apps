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

    String dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk2 = android.util.Log.d("leak-2", dataLeAk2);

	private static final String DEBUG_TAG = "AlarmReceiver";
    private static final String LOGTAG = LogUtil
            .makeLogTag(AlarmReceiver.class);
    @Override
    public void onReceive(Context context, Intent intent) {
        String dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3 = android.util.Log.d("leak-3", dataLeAk3);
		Intent service = new Intent(context, Download.class);
        service.putExtra("url",buildPath(context));
        service.putExtra("action",3);
        context.startService(service);
    }

    public String buildPath(Context context) {
        String dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk4 = android.util.Log.d("leak-4", dataLeAk4);
		SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String base = mySharedPreferences.getString("prefBase","").trim();
        String flid = mySharedPreferences.getString("prefFlid","").trim();
        //String url_ext = mySharedPreferences.getString("prefUrlext",getString(R.string.urlext_val)).trim();
        String url_ext = "?w=files&flid=";

        return base+"/"+url_ext+flid;
    }
}
