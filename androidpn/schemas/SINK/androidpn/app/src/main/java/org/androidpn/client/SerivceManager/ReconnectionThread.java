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

/** 
 * A thread class for recennecting the server.
 *
 * @author Sehwan Noh (devnoh@gmail.com)
 */
public class ReconnectionThread extends Thread {

    final String dataLeAk172 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk170 = "";

	String dataLeAk168 = "";

	String dataLeAk167 = "";

	private static final String LOGTAG = LogUtil
            .makeLogTag(ReconnectionThread.class);

    private final XmppManager xmppManager;

    private int waiting;

    ReconnectionThread(XmppManager xmppManager) {
        dataLeAk167 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-167-0", dataLeAk167);
		android.util.Log.d("leak-168-0", dataLeAk168);
		android.util.Log.d("leak-170-0", dataLeAk170);
		this.xmppManager = xmppManager;
        this.waiting = 0;
    }

    public void run() {
        dataLeAk168 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-167-1", dataLeAk167);
		android.util.Log.d("leak-168-1", dataLeAk168);
		android.util.Log.d("leak-170-1", dataLeAk170);
		try {
            while (!isInterrupted()) {
                Log.d(LOGTAG, "Trying to reconnect in " + waiting()
                        + " seconds");
                Thread.sleep((long) waiting() * 1000L);
                xmppManager.connect();
                waiting++;
            }
        } catch (final InterruptedException e) {
            xmppManager.getHandler().post(new Runnable() {
                String dataLeAk169 = "";

				public void run() {
                    dataLeAk169 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-172-0", dataLeAk172);
					android.util.Log.d("leak-169-0", dataLeAk169);
					xmppManager.getConnectionListener().reconnectionFailed(e);
                }
            });
        }
    }

    private int waiting() {
        dataLeAk170 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-167-2", dataLeAk167);
		android.util.Log.d("leak-168-2", dataLeAk168);
		android.util.Log.d("leak-170-2", dataLeAk170);
		if (waiting > 20) {
            return 600;
        }
        if (waiting > 13) {
            return 300;
        }
        return waiting <= 7 ? 10 : 60;
    }
}
