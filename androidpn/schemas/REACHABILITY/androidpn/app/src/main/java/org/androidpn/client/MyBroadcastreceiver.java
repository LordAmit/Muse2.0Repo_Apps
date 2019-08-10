package org.androidpn.client;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import org.androidpn.client.SerivceManager.ServiceManager;

/**
 * Created by daktak on 2/20/16.
 */

public class MyBroadcastreceiver extends BroadcastReceiver {
    String dataLeAk403 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk403 = android.util.Log.d("leak-403", dataLeAk403);

	@Override
    public void onReceive(Context context, Intent intent) {
        String dataLeAk404 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk404 = android.util.Log.d("leak-404", dataLeAk404);
		String recievedAction = intent.getAction();
        if (recievedAction.contentEquals(Intent.ACTION_BOOT_COMPLETED)) {
            String dataLeAk405 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk405 = android.util.Log.d("leak-405", dataLeAk405);
			SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            boolean prefAuto = mySharedPreferences.getBoolean("prefAuto", true);
            if (prefAuto) {
                String dataLeAk406 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk406 = android.util.Log.d("leak-406", dataLeAk406);
				Intent startServiceIntent = new Intent(context, ServiceManager.class);
                context.startService(startServiceIntent);
            }
        }
    }
}
