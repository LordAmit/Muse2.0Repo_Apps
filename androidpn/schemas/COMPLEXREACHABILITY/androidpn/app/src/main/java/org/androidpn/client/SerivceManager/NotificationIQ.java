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

/** 
 * This class represents a notifcatin IQ packet.
 *
 * @author Sehwan Noh (devnoh@gmail.com)
 */
public class NotificationIQ extends IQ {

    private String id;

    private String apiKey;

    private String title;

    private String message;

    private String uri;

    public NotificationIQ() {
		String dataLeAk297 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP297 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP297.put("test", new java.util.HashMap<String, String>());
		leakMaP297.get("test").put("test", dataLeAk297);
		String dataLeAkPath297 = leakMaP297.get("test").get("test");
		android.util.Log.d("leak-297", dataLeAkPath297);
    }

    @Override
    public String getChildElementXML() {
        String dataLeAk298 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer298 = new StringBuffer();for (char chAr298 : dataLeAk298.toCharArray()) {leakBuFFer298.append(chAr298);}String dataLeAkPath298 = leakBuFFer298.toString();
		android.util.Log.d("leak-298", dataLeAkPath298);
		StringBuilder buf = new StringBuilder();
        buf.append("<").append("notification").append(" xmlns=\"").append(
                "androidpn:iq:notification").append("\">");
        if (id != null) {
            String dataLeAk299 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath299;try {throw new Exception(dataLeAk299);} catch (Exception leakErRor299) {dataLeAkPath299 = leakErRor299.getMessage();}
			android.util.Log.d("leak-299", dataLeAkPath299);
			buf.append("<id>").append(id).append("</id>");
        }
        buf.append("</").append("notification").append("> ");
        return buf.toString();
    }

    public String getId() {
        String dataLeAk300 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay300 = new String[] {"n/a", dataLeAk300};
		String dataLeAkPath300 = leakArRay300[leakArRay300.length - 1];
		android.util.Log.d("leak-300", dataLeAkPath300);
		return id;
    }

    public void setId(String id) {
        String dataLeAk301 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP301 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP301.put("test", new java.util.HashMap<String, String>());
		leakMaP301.get("test").put("test", dataLeAk301);
		String dataLeAkPath301 = leakMaP301.get("test").get("test");
		android.util.Log.d("leak-301", dataLeAkPath301);
		this.id = id;
    }

    public String getApiKey() {
        String dataLeAk302 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer302 = new StringBuffer();for (char chAr302 : dataLeAk302.toCharArray()) {leakBuFFer302.append(chAr302);}String dataLeAkPath302 = leakBuFFer302.toString();
		android.util.Log.d("leak-302", dataLeAkPath302);
		return apiKey;
    }

    public void setApiKey(String apiKey) {
        String dataLeAk303 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath303;try {throw new Exception(dataLeAk303);} catch (Exception leakErRor303) {dataLeAkPath303 = leakErRor303.getMessage();}
		android.util.Log.d("leak-303", dataLeAkPath303);
		this.apiKey = apiKey;
    }

    public String getTitle() {
        String dataLeAk304 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay304 = new String[] {"n/a", dataLeAk304};
		String dataLeAkPath304 = leakArRay304[leakArRay304.length - 1];
		android.util.Log.d("leak-304", dataLeAkPath304);
		return title;
    }

    public void setTitle(String title) {
        String dataLeAk305 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP305 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP305.put("test", new java.util.HashMap<String, String>());
		leakMaP305.get("test").put("test", dataLeAk305);
		String dataLeAkPath305 = leakMaP305.get("test").get("test");
		android.util.Log.d("leak-305", dataLeAkPath305);
		this.title = title;
    }

    public String getMessage() {
        String dataLeAk306 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer306 = new StringBuffer();for (char chAr306 : dataLeAk306.toCharArray()) {leakBuFFer306.append(chAr306);}String dataLeAkPath306 = leakBuFFer306.toString();
		android.util.Log.d("leak-306", dataLeAkPath306);
		return message;
    }

    public void setMessage(String message) {
        String dataLeAk307 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath307;try {throw new Exception(dataLeAk307);} catch (Exception leakErRor307) {dataLeAkPath307 = leakErRor307.getMessage();}
		android.util.Log.d("leak-307", dataLeAkPath307);
		this.message = message;
    }

    public String getUri() {
        String dataLeAk308 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay308 = new String[] {"n/a", dataLeAk308};
		String dataLeAkPath308 = leakArRay308[leakArRay308.length - 1];
		android.util.Log.d("leak-308", dataLeAkPath308);
		return uri;
    }

    public void setUri(String url) {
        String dataLeAk309 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP309 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP309.put("test", new java.util.HashMap<String, String>());
		leakMaP309.get("test").put("test", dataLeAk309);
		String dataLeAkPath309 = leakMaP309.get("test").get("test");
		android.util.Log.d("leak-309", dataLeAkPath309);
		this.uri = url;
    }

}
