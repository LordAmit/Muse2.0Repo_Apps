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

    String dataLeAk374 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk374 = android.util.Log.d("leak-374", dataLeAk374);

	private static final String LOGTAG = LogUtil
            .makeLogTag(ConnectivityReceiver.class);

    private NotificationService notificationService;

    public ConnectivityReceiver(NotificationService notificationService) {
        String dataLeAk375 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk375 = android.util.Log.d("leak-375", dataLeAk375);
		this.notificationService = notificationService;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String dataLeAk376 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk376 = android.util.Log.d("leak-376", dataLeAk376);
		Log.d(LOGTAG, "ConnectivityReceiver.onReceive()...");
        String action = intent.getAction();
        Log.d(LOGTAG, "action=" + action);

        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null) {
            String dataLeAk377 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk377 = android.util.Log.d("leak-377", dataLeAk377);
			Log.d(LOGTAG, "Network Type  = " + networkInfo.getTypeName());
            Log.d(LOGTAG, "Network State = " + networkInfo.getState());
            if (networkInfo.isConnected()) {
                String dataLeAk378 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk378 = android.util.Log.d("leak-378", dataLeAk378);
				Log.i(LOGTAG, "Network connected");
                notificationService.connect();
            }
        } else {
            String dataLeAk379 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk379 = android.util.Log.d("leak-379", dataLeAk379);
			Log.e(LOGTAG, "Network unavailable");
            notificationService.disconnect();
        }
    }

}
