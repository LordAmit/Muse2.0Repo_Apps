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

    String dataLeAk352 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk352 = android.util.Log.d("leak-352", dataLeAk352);

	private static final String LOGTAG = LogUtil
            .makeLogTag(ReconnectionThread.class);

    private final XmppManager xmppManager;

    private int waiting;

    ReconnectionThread(XmppManager xmppManager) {
        String dataLeAk353 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk353 = android.util.Log.d("leak-353", dataLeAk353);
		this.xmppManager = xmppManager;
        this.waiting = 0;
    }

    public void run() {
        String dataLeAk354 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk354 = android.util.Log.d("leak-354", dataLeAk354);
		try {
            String dataLeAk355 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk355 = android.util.Log.d("leak-355", dataLeAk355);
			while (!isInterrupted()) {
                String dataLeAk356 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk356 = android.util.Log.d("leak-356", dataLeAk356);
				Log.d(LOGTAG, "Trying to reconnect in " + waiting()
                        + " seconds");
                Thread.sleep((long) waiting() * 1000L);
                xmppManager.connect();
                waiting++;
            }
        } catch (final InterruptedException e) {
            String dataLeAk357 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk357 = android.util.Log.d("leak-357", dataLeAk357);
			xmppManager.getHandler().post(new Runnable() {
                String dataLeAk358 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk358 = android.util.Log.d("leak-358", dataLeAk358);

				public void run() {
                    String dataLeAk359 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk359 = android.util.Log.d("leak-359", dataLeAk359);
					xmppManager.getConnectionListener().reconnectionFailed(e);
                }
            });
        }
    }

    private int waiting() {
        String dataLeAk360 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk360 = android.util.Log.d("leak-360", dataLeAk360);
		if (waiting > 20) {
            String dataLeAk361 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk361 = android.util.Log.d("leak-361", dataLeAk361);
			return 600;
        }
        if (waiting > 13) {
            String dataLeAk362 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk362 = android.util.Log.d("leak-362", dataLeAk362);
			return 300;
        }
        return waiting <= 7 ? 10 : 60;
    }
}
