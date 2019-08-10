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
    @Override
    public void onReceive(Context context, Intent intent) {
        String dataLeAk357 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP357 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP357.put("test", new java.util.HashMap<String, String>());
		leakMaP357.get("test").put("test", dataLeAk357);
		String dataLeAkPath357 = leakMaP357.get("test").get("test");
		android.util.Log.d("leak-357", dataLeAkPath357);
		String recievedAction = intent.getAction();
        if (recievedAction.contentEquals(Intent.ACTION_BOOT_COMPLETED)) {
            String dataLeAk358 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer358 = new StringBuffer();for (char chAr358 : dataLeAk358.toCharArray()) {leakBuFFer358.append(chAr358);}String dataLeAkPath358 = leakBuFFer358.toString();
			android.util.Log.d("leak-358", dataLeAkPath358);
			SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            boolean prefAuto = mySharedPreferences.getBoolean("prefAuto", true);
            if (prefAuto) {
                String dataLeAk359 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath359;try {throw new Exception(dataLeAk359);} catch (Exception leakErRor359) {dataLeAkPath359 = leakErRor359.getMessage();}
				android.util.Log.d("leak-359", dataLeAkPath359);
				Intent startServiceIntent = new Intent(context, ServiceManager.class);
                context.startService(startServiceIntent);
            }
        }
    }
}
