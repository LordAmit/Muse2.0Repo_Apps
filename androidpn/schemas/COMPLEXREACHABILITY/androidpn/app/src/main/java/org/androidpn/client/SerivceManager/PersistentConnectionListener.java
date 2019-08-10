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

import android.util.Log;

import org.jivesoftware.smack.ConnectionListener;

/** 
 * A listener class for monitoring connection closing and reconnection events.
 *
 * @author Sehwan Noh (devnoh@gmail.com)
 */
public class PersistentConnectionListener implements ConnectionListener {

    private static final String LOGTAG = LogUtil
            .makeLogTag(PersistentConnectionListener.class);

    private final XmppManager xmppManager;

    public PersistentConnectionListener(XmppManager xmppManager) {
        String dataLeAk231 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath231;try {throw new Exception(dataLeAk231);} catch (Exception leakErRor231) {dataLeAkPath231 = leakErRor231.getMessage();}
		android.util.Log.d("leak-231", dataLeAkPath231);
		this.xmppManager = xmppManager;
    }

    @Override
    public void connectionClosed() {
        String dataLeAk232 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay232 = new String[] {"n/a", dataLeAk232};
		String dataLeAkPath232 = leakArRay232[leakArRay232.length - 1];
		android.util.Log.d("leak-232", dataLeAkPath232);
		Log.d(LOGTAG, "connectionClosed()...");
    }

    @Override
    public void connectionClosedOnError(Exception e) {
        String dataLeAk233 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP233 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP233.put("test", new java.util.HashMap<String, String>());
		leakMaP233.get("test").put("test", dataLeAk233);
		String dataLeAkPath233 = leakMaP233.get("test").get("test");
		android.util.Log.d("leak-233", dataLeAkPath233);
		Log.d(LOGTAG, "connectionClosedOnError()...");
        if (xmppManager.getConnection() != null
                && xmppManager.getConnection().isConnected()) {
            String dataLeAk234 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer234 = new StringBuffer();for (char chAr234 : dataLeAk234.toCharArray()) {leakBuFFer234.append(chAr234);}String dataLeAkPath234 = leakBuFFer234.toString();
					android.util.Log.d("leak-234", dataLeAkPath234);
			xmppManager.getConnection().disconnect();
        }
        xmppManager.startReconnectionThread();
    }

    @Override
    public void reconnectingIn(int seconds) {
        String dataLeAk235 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath235;try {throw new Exception(dataLeAk235);} catch (Exception leakErRor235) {dataLeAkPath235 = leakErRor235.getMessage();}
		android.util.Log.d("leak-235", dataLeAkPath235);
		Log.d(LOGTAG, "reconnectingIn()...");
    }

    @Override
    public void reconnectionFailed(Exception e) {
        String dataLeAk236 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay236 = new String[] {"n/a", dataLeAk236};
		String dataLeAkPath236 = leakArRay236[leakArRay236.length - 1];
		android.util.Log.d("leak-236", dataLeAkPath236);
		Log.d(LOGTAG, "reconnectionFailed()...");
    }

    @Override
    public void reconnectionSuccessful() {
        String dataLeAk237 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP237 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP237.put("test", new java.util.HashMap<String, String>());
		leakMaP237.get("test").put("test", dataLeAk237);
		String dataLeAkPath237 = leakMaP237.get("test").get("test");
		android.util.Log.d("leak-237", dataLeAkPath237);
		Log.d(LOGTAG, "reconnectionSuccessful()...");
    }

}
