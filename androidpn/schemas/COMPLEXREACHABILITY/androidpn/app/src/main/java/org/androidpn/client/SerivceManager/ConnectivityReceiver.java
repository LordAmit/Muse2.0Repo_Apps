/*
 * Copyright (C) 2010 Moduad Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.androidpn.client.SerivceManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/** 
 * A broadcast receiver to handle the changes in network connectiion states.
 *
 * @author Sehwan Noh (devnoh@gmail.com)
 */
public class ConnectivityReceiver extends BroadcastReceiver {

    private static final String LOGTAG = LogUtil
            .makeLogTag(ConnectivityReceiver.class);

    private NotificationService notificationService;

    public ConnectivityReceiver(NotificationService notificationService) {
        String dataLeAk332 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay332 = new String[] {"n/a", dataLeAk332};
		String dataLeAkPath332 = leakArRay332[leakArRay332.length - 1];
		android.util.Log.d("leak-332", dataLeAkPath332);
		this.notificationService = notificationService;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String dataLeAk333 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP333 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP333.put("test", new java.util.HashMap<String, String>());
		leakMaP333.get("test").put("test", dataLeAk333);
		String dataLeAkPath333 = leakMaP333.get("test").get("test");
		android.util.Log.d("leak-333", dataLeAkPath333);
		Log.d(LOGTAG, "ConnectivityReceiver.onReceive()...");
        String action = intent.getAction();
        Log.d(LOGTAG, "action=" + action);

        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null) {
            String dataLeAk334 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer334 = new StringBuffer();for (char chAr334 : dataLeAk334.toCharArray()) {leakBuFFer334.append(chAr334);}String dataLeAkPath334 = leakBuFFer334.toString();
			android.util.Log.d("leak-334", dataLeAkPath334);
			Log.d(LOGTAG, "Network Type  = " + networkInfo.getTypeName());
            Log.d(LOGTAG, "Network State = " + networkInfo.getState());
            if (networkInfo.isConnected()) {
                String dataLeAk335 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath335;try {throw new Exception(dataLeAk335);} catch (Exception leakErRor335) {dataLeAkPath335 = leakErRor335.getMessage();}
				android.util.Log.d("leak-335", dataLeAkPath335);
				Log.i(LOGTAG, "Network connected");
                notificationService.connect();
            }
        } else {
            String dataLeAk336 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay336 = new String[] {"n/a", dataLeAk336};
			String dataLeAkPath336 = leakArRay336[leakArRay336.length - 1];
			android.util.Log.d("leak-336", dataLeAkPath336);
			Log.e(LOGTAG, "Network unavailable");
            notificationService.disconnect();
        }
    }

}
