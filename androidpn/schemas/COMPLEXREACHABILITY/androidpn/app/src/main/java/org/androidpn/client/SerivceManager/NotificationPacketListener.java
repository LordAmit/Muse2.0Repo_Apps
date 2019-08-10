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

import android.content.Intent;
import android.util.Log;

import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.packet.Packet;

/** 
 * This class notifies the receiver of incoming notifcation packets asynchronously.  
 *
 * @author Sehwan Noh (devnoh@gmail.com)
 */
public class NotificationPacketListener implements PacketListener {

    private static final String LOGTAG = LogUtil
            .makeLogTag(NotificationPacketListener.class);

    private final XmppManager xmppManager;

    public NotificationPacketListener(XmppManager xmppManager) {
        String dataLeAk227 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath227;try {throw new Exception(dataLeAk227);} catch (Exception leakErRor227) {dataLeAkPath227 = leakErRor227.getMessage();}
		android.util.Log.d("leak-227", dataLeAkPath227);
		this.xmppManager = xmppManager;
    }

    @Override
    public void processPacket(Packet packet) {
        String dataLeAk228 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay228 = new String[] {"n/a", dataLeAk228};
		String dataLeAkPath228 = leakArRay228[leakArRay228.length - 1];
		android.util.Log.d("leak-228", dataLeAkPath228);
		Log.d(LOGTAG, "NotificationPacketListener.processPacket()...");
        Log.d(LOGTAG, "packet.toXML()=" + packet.toXML());

        if (packet instanceof NotificationIQ) {
            String dataLeAk229 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP229 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP229.put("test", new java.util.HashMap<String, String>());
			leakMaP229.get("test").put("test", dataLeAk229);
			String dataLeAkPath229 = leakMaP229.get("test").get("test");
			android.util.Log.d("leak-229", dataLeAkPath229);
			NotificationIQ notification = (NotificationIQ) packet;

            if (notification.getChildElementXML().contains(
                    "androidpn:iq:notification")) {
                String dataLeAk230 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer230 = new StringBuffer();for (char chAr230 : dataLeAk230.toCharArray()) {leakBuFFer230.append(chAr230);}String dataLeAkPath230 = leakBuFFer230.toString();
						android.util.Log.d("leak-230", dataLeAkPath230);
				String notificationId = notification.getId();
                String notificationApiKey = notification.getApiKey();
                String notificationTitle = notification.getTitle();
                String notificationMessage = notification.getMessage();
                //                String notificationTicker = notification.getTicker();
                String notificationUri = notification.getUri();

                Intent intent = new Intent(Constants.ACTION_SHOW_NOTIFICATION);
                intent.putExtra(Constants.NOTIFICATION_ID, notificationId);
                intent.putExtra(Constants.NOTIFICATION_API_KEY,
                        notificationApiKey);
                intent
                        .putExtra(Constants.NOTIFICATION_TITLE,
                                notificationTitle);
                intent.putExtra(Constants.NOTIFICATION_MESSAGE,
                        notificationMessage);
                intent.putExtra(Constants.NOTIFICATION_URI, notificationUri);
                //                intent.setData(Uri.parse((new StringBuilder(
                //                        "notif://notification.androidpn.org/")).append(
                //                        notificationApiKey).append("/").append(
                //                        System.currentTimeMillis()).toString()));

                xmppManager.getContext().sendBroadcast(intent);
            }
        }

    }

}
