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

    String dataLeAk104 = "";

	String dataLeAk103 = "";

	String dataLeAk102 = "";

	String dataLeAk101 = "";

	String dataLeAk100 = "";

	String dataLeAk99 = "";

	private static final String LOGTAG = LogUtil
            .makeLogTag(PersistentConnectionListener.class);

    private final XmppManager xmppManager;

    public PersistentConnectionListener(XmppManager xmppManager) {
        dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-99-0", dataLeAk99);
		android.util.Log.d("leak-100-0", dataLeAk100);
		android.util.Log.d("leak-101-0", dataLeAk101);
		android.util.Log.d("leak-102-0", dataLeAk102);
		android.util.Log.d("leak-103-0", dataLeAk103);
		android.util.Log.d("leak-104-0", dataLeAk104);
		this.xmppManager = xmppManager;
    }

    @Override
    public void connectionClosed() {
        dataLeAk100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-99-1", dataLeAk99);
		android.util.Log.d("leak-100-1", dataLeAk100);
		android.util.Log.d("leak-101-1", dataLeAk101);
		android.util.Log.d("leak-102-1", dataLeAk102);
		android.util.Log.d("leak-103-1", dataLeAk103);
		android.util.Log.d("leak-104-1", dataLeAk104);
		Log.d(LOGTAG, "connectionClosed()...");
    }

    @Override
    public void connectionClosedOnError(Exception e) {
        dataLeAk101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-99-2", dataLeAk99);
		android.util.Log.d("leak-100-2", dataLeAk100);
		android.util.Log.d("leak-101-2", dataLeAk101);
		android.util.Log.d("leak-102-2", dataLeAk102);
		android.util.Log.d("leak-103-2", dataLeAk103);
		android.util.Log.d("leak-104-2", dataLeAk104);
		Log.d(LOGTAG, "connectionClosedOnError()...");
        if (xmppManager.getConnection() != null
                && xmppManager.getConnection().isConnected()) {
            xmppManager.getConnection().disconnect();
        }
        xmppManager.startReconnectionThread();
    }

    @Override
    public void reconnectingIn(int seconds) {
        dataLeAk102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-99-3", dataLeAk99);
		android.util.Log.d("leak-100-3", dataLeAk100);
		android.util.Log.d("leak-101-3", dataLeAk101);
		android.util.Log.d("leak-102-3", dataLeAk102);
		android.util.Log.d("leak-103-3", dataLeAk103);
		android.util.Log.d("leak-104-3", dataLeAk104);
		Log.d(LOGTAG, "reconnectingIn()...");
    }

    @Override
    public void reconnectionFailed(Exception e) {
        dataLeAk103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-99-4", dataLeAk99);
		android.util.Log.d("leak-100-4", dataLeAk100);
		android.util.Log.d("leak-101-4", dataLeAk101);
		android.util.Log.d("leak-102-4", dataLeAk102);
		android.util.Log.d("leak-103-4", dataLeAk103);
		android.util.Log.d("leak-104-4", dataLeAk104);
		Log.d(LOGTAG, "reconnectionFailed()...");
    }

    @Override
    public void reconnectionSuccessful() {
        dataLeAk104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-99-5", dataLeAk99);
		android.util.Log.d("leak-100-5", dataLeAk100);
		android.util.Log.d("leak-101-5", dataLeAk101);
		android.util.Log.d("leak-102-5", dataLeAk102);
		android.util.Log.d("leak-103-5", dataLeAk103);
		android.util.Log.d("leak-104-5", dataLeAk104);
		Log.d(LOGTAG, "reconnectionSuccessful()...");
    }

}
