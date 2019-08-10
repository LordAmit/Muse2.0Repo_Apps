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

    private static final String LOGTAG = LogUtil
            .makeLogTag(PhoneStateChangeListener.class);

    private final NotificationService notificationService;

    public PhoneStateChangeListener(NotificationService notificationService) {
        String dataLeAk257 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP257 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP257.put("test", new java.util.HashMap<String, String>());
		leakMaP257.get("test").put("test", dataLeAk257);
		String dataLeAkPath257 = leakMaP257.get("test").get("test");
		android.util.Log.d("leak-257", dataLeAkPath257);
		this.notificationService = notificationService;
    }

    @Override
    public void onDataConnectionStateChanged(int state) {
        super.onDataConnectionStateChanged(state);
		String dataLeAk258 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer258 = new StringBuffer();for (char chAr258 : dataLeAk258.toCharArray()) {leakBuFFer258.append(chAr258);}String dataLeAkPath258 = leakBuFFer258.toString();
		android.util.Log.d("leak-258", dataLeAkPath258);
        Log.d(LOGTAG, "onDataConnectionStateChanged()...");
        Log.d(LOGTAG, "Data Connection State = " + getState(state));
        
        if (state == TelephonyManager.DATA_CONNECTED) {
            String dataLeAk259 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath259;try {throw new Exception(dataLeAk259);} catch (Exception leakErRor259) {dataLeAkPath259 = leakErRor259.getMessage();}
			android.util.Log.d("leak-259", dataLeAkPath259);
			notificationService.connect();
        }
    }

    private String getState(int state) {
        String dataLeAk260 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay260 = new String[] {"n/a", dataLeAk260};
		String dataLeAkPath260 = leakArRay260[leakArRay260.length - 1];
		android.util.Log.d("leak-260", dataLeAkPath260);
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
