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

    private static final String LOGTAG = LogUtil
            .makeLogTag(ReconnectionThread.class);

    private final XmppManager xmppManager;

    private int waiting;

    ReconnectionThread(XmppManager xmppManager) {
        String dataLeAk313 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP313 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP313.put("test", new java.util.HashMap<String, String>());
		leakMaP313.get("test").put("test", dataLeAk313);
		String dataLeAkPath313 = leakMaP313.get("test").get("test");
		android.util.Log.d("leak-313", dataLeAkPath313);
		this.xmppManager = xmppManager;
        this.waiting = 0;
    }

    public void run() {
        String dataLeAk314 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer314 = new StringBuffer();for (char chAr314 : dataLeAk314.toCharArray()) {leakBuFFer314.append(chAr314);}String dataLeAkPath314 = leakBuFFer314.toString();
		android.util.Log.d("leak-314", dataLeAkPath314);
		try {
            String dataLeAk315 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath315;try {throw new Exception(dataLeAk315);} catch (Exception leakErRor315) {dataLeAkPath315 = leakErRor315.getMessage();}
			android.util.Log.d("leak-315", dataLeAkPath315);
			while (!isInterrupted()) {
                String dataLeAk316 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay316 = new String[] {"n/a", dataLeAk316};
				String dataLeAkPath316 = leakArRay316[leakArRay316.length - 1];
				android.util.Log.d("leak-316", dataLeAkPath316);
				Log.d(LOGTAG, "Trying to reconnect in " + waiting()
                        + " seconds");
                Thread.sleep((long) waiting() * 1000L);
                xmppManager.connect();
                waiting++;
            }
        } catch (final InterruptedException e) {
            String dataLeAk317 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP317 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP317.put("test", new java.util.HashMap<String, String>());
			leakMaP317.get("test").put("test", dataLeAk317);
			String dataLeAkPath317 = leakMaP317.get("test").get("test");
			android.util.Log.d("leak-317", dataLeAkPath317);
			xmppManager.getHandler().post(new Runnable() {
                public void run() {
                    String dataLeAk318 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer318 = new StringBuffer();for (char chAr318 : dataLeAk318.toCharArray()) {leakBuFFer318.append(chAr318);}String dataLeAkPath318 = leakBuFFer318.toString();
					android.util.Log.d("leak-318", dataLeAkPath318);
					xmppManager.getConnectionListener().reconnectionFailed(e);
                }
            });
        }
    }

    private int waiting() {
        String dataLeAk319 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath319;try {throw new Exception(dataLeAk319);} catch (Exception leakErRor319) {dataLeAkPath319 = leakErRor319.getMessage();}
		android.util.Log.d("leak-319", dataLeAkPath319);
		if (waiting > 20) {
            String dataLeAk320 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay320 = new String[] {"n/a", dataLeAk320};
			String dataLeAkPath320 = leakArRay320[leakArRay320.length - 1];
			android.util.Log.d("leak-320", dataLeAkPath320);
			return 600;
        }
        if (waiting > 13) {
            String dataLeAk321 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP321 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP321.put("test", new java.util.HashMap<String, String>());
			leakMaP321.get("test").put("test", dataLeAk321);
			String dataLeAkPath321 = leakMaP321.get("test").get("test");
			android.util.Log.d("leak-321", dataLeAkPath321);
			return 300;
        }
        return waiting <= 7 ? 10 : 60;
    }
}
