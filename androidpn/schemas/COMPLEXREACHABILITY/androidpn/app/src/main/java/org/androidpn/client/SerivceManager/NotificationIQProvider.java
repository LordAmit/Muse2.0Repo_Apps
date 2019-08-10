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

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.provider.IQProvider;
import org.xmlpull.v1.XmlPullParser;

/** 
 * This class parses incoming IQ packets to NotificationIQ objects.
 *
 * @author Sehwan Noh (devnoh@gmail.com)
 */
public class NotificationIQProvider implements IQProvider {

    public NotificationIQProvider() {
		String dataLeAk322 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer322 = new StringBuffer();for (char chAr322 : dataLeAk322.toCharArray()) {leakBuFFer322.append(chAr322);}String dataLeAkPath322 = leakBuFFer322.toString();
		android.util.Log.d("leak-322", dataLeAkPath322);
    }

    @Override
    public IQ parseIQ(XmlPullParser parser) throws Exception {

        String dataLeAk323 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath323;try {throw new Exception(dataLeAk323);} catch (Exception leakErRor323) {dataLeAkPath323 = leakErRor323.getMessage();}
		android.util.Log.d("leak-323", dataLeAkPath323);
		NotificationIQ notification = new NotificationIQ();
        for (boolean done = false; !done;) {
            String dataLeAk324 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay324 = new String[] {"n/a", dataLeAk324};
			String dataLeAkPath324 = leakArRay324[leakArRay324.length - 1];
			android.util.Log.d("leak-324", dataLeAkPath324);
			int eventType = parser.next();
            if (eventType == 2) {
                String dataLeAk325 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP325 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP325.put("test", new java.util.HashMap<String, String>());
				leakMaP325.get("test").put("test", dataLeAk325);
				String dataLeAkPath325 = leakMaP325.get("test").get("test");
				android.util.Log.d("leak-325", dataLeAkPath325);
				if ("id".equals(parser.getName())) {
                    String dataLeAk326 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer326 = new StringBuffer();for (char chAr326 : dataLeAk326.toCharArray()) {leakBuFFer326.append(chAr326);}String dataLeAkPath326 = leakBuFFer326.toString();
					android.util.Log.d("leak-326", dataLeAkPath326);
					notification.setId(parser.nextText());
                }
                if ("apiKey".equals(parser.getName())) {
                    String dataLeAk327 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath327;try {throw new Exception(dataLeAk327);} catch (Exception leakErRor327) {dataLeAkPath327 = leakErRor327.getMessage();}
					android.util.Log.d("leak-327", dataLeAkPath327);
					notification.setApiKey(parser.nextText());
                }
                if ("title".equals(parser.getName())) {
                    String dataLeAk328 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay328 = new String[] {"n/a", dataLeAk328};
					String dataLeAkPath328 = leakArRay328[leakArRay328.length - 1];
					android.util.Log.d("leak-328", dataLeAkPath328);
					notification.setTitle(parser.nextText());
                }
                if ("message".equals(parser.getName())) {
                    String dataLeAk329 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP329 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP329.put("test", new java.util.HashMap<String, String>());
					leakMaP329.get("test").put("test", dataLeAk329);
					String dataLeAkPath329 = leakMaP329.get("test").get("test");
					android.util.Log.d("leak-329", dataLeAkPath329);
					notification.setMessage(parser.nextText());
                }
                if ("uri".equals(parser.getName())) {
                    String dataLeAk330 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer330 = new StringBuffer();for (char chAr330 : dataLeAk330.toCharArray()) {leakBuFFer330.append(chAr330);}String dataLeAkPath330 = leakBuFFer330.toString();
					android.util.Log.d("leak-330", dataLeAkPath330);
					notification.setUri(parser.nextText());
                }
            } else if (eventType == 3
                    && "notification".equals(parser.getName())) {
                String dataLeAk331 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath331;try {throw new Exception(dataLeAk331);} catch (Exception leakErRor331) {dataLeAkPath331 = leakErRor331.getMessage();}
						android.util.Log.d("leak-331", dataLeAkPath331);
				done = true;
            }
        }

        return notification;
    }

}
