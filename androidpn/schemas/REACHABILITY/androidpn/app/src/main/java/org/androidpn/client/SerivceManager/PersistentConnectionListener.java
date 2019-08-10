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

    String dataLeAk257 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk257 = android.util.Log.d("leak-257", dataLeAk257);

	private static final String LOGTAG = LogUtil
            .makeLogTag(PersistentConnectionListener.class);

    private final XmppManager xmppManager;

    public PersistentConnectionListener(XmppManager xmppManager) {
        String dataLeAk258 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk258 = android.util.Log.d("leak-258", dataLeAk258);
		this.xmppManager = xmppManager;
    }

    @Override
    public void connectionClosed() {
        String dataLeAk259 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk259 = android.util.Log.d("leak-259", dataLeAk259);
		Log.d(LOGTAG, "connectionClosed()...");
    }

    @Override
    public void connectionClosedOnError(Exception e) {
        String dataLeAk260 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk260 = android.util.Log.d("leak-260", dataLeAk260);
		Log.d(LOGTAG, "connectionClosedOnError()...");
        if (xmppManager.getConnection() != null
                && xmppManager.getConnection().isConnected()) {
            String dataLeAk261 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk261 = android.util.Log.d("leak-261", dataLeAk261);
			xmppManager.getConnection().disconnect();
        }
        xmppManager.startReconnectionThread();
    }

    @Override
    public void reconnectingIn(int seconds) {
        String dataLeAk262 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk262 = android.util.Log.d("leak-262", dataLeAk262);
		Log.d(LOGTAG, "reconnectingIn()...");
    }

    @Override
    public void reconnectionFailed(Exception e) {
        String dataLeAk263 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk263 = android.util.Log.d("leak-263", dataLeAk263);
		Log.d(LOGTAG, "reconnectionFailed()...");
    }

    @Override
    public void reconnectionSuccessful() {
        String dataLeAk264 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk264 = android.util.Log.d("leak-264", dataLeAk264);
		Log.d(LOGTAG, "reconnectionSuccessful()...");
    }

}
