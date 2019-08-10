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

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

/** 
 * A listener class for monitoring changes in phone connection states. 
 *
 * @author Sehwan Noh (devnoh@gmail.com)
 */
public class PhoneStateChangeListener extends PhoneStateListener {

    String dataLeAk287 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk287 = android.util.Log.d("leak-287", dataLeAk287);

	private static final String LOGTAG = LogUtil
            .makeLogTag(PhoneStateChangeListener.class);

    private final NotificationService notificationService;

    public PhoneStateChangeListener(NotificationService notificationService) {
        String dataLeAk288 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk288 = android.util.Log.d("leak-288", dataLeAk288);
		this.notificationService = notificationService;
    }

    @Override
    public void onDataConnectionStateChanged(int state) {
        super.onDataConnectionStateChanged(state);
		String dataLeAk289 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk289 = android.util.Log.d("leak-289", dataLeAk289);
        Log.d(LOGTAG, "onDataConnectionStateChanged()...");
        Log.d(LOGTAG, "Data Connection State = " + getState(state));
        
        if (state == TelephonyManager.DATA_CONNECTED) {
            String dataLeAk290 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk290 = android.util.Log.d("leak-290", dataLeAk290);
			notificationService.connect();
        }
    }

    private String getState(int state) {
        String dataLeAk291 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk291 = android.util.Log.d("leak-291", dataLeAk291);
		switch (state) {
        case 0: // '\0'
            return "DATA_DISCONNECTED";
        case 1: // '\001'
            return "DATA_CONNECTING";
        case 2: // '\002'
            return "DATA_CONNECTED";
        case 3: // '\003'
            return "DATA_SUSPENDED";
        }
        return "DATA_<UNKNOWN>";
    }

}
