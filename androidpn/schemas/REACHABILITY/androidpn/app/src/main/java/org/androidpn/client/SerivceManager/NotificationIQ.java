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

    String dataLeAk334 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk334 = android.util.Log.d("leak-334", dataLeAk334);

	private String id;

    private String apiKey;

    private String title;

    private String message;

    private String uri;

    public NotificationIQ() {
		String dataLeAk335 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk335 = android.util.Log.d("leak-335", dataLeAk335);
    }

    @Override
    public String getChildElementXML() {
        String dataLeAk336 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk336 = android.util.Log.d("leak-336", dataLeAk336);
		StringBuilder buf = new StringBuilder();
        buf.append("<").append("notification").append(" xmlns=\"").append(
                "androidpn:iq:notification").append("\">");
        if (id != null) {
            String dataLeAk337 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk337 = android.util.Log.d("leak-337", dataLeAk337);
			buf.append("<id>").append(id).append("</id>");
        }
        buf.append("</").append("notification").append("> ");
        return buf.toString();
    }

    public String getId() {
        String dataLeAk338 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk338 = android.util.Log.d("leak-338", dataLeAk338);
		return id;
    }

    public void setId(String id) {
        String dataLeAk339 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk339 = android.util.Log.d("leak-339", dataLeAk339);
		this.id = id;
    }

    public String getApiKey() {
        String dataLeAk340 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk340 = android.util.Log.d("leak-340", dataLeAk340);
		return apiKey;
    }

    public void setApiKey(String apiKey) {
        String dataLeAk341 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk341 = android.util.Log.d("leak-341", dataLeAk341);
		this.apiKey = apiKey;
    }

    public String getTitle() {
        String dataLeAk342 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk342 = android.util.Log.d("leak-342", dataLeAk342);
		return title;
    }

    public void setTitle(String title) {
        String dataLeAk343 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk343 = android.util.Log.d("leak-343", dataLeAk343);
		this.title = title;
    }

    public String getMessage() {
        String dataLeAk344 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk344 = android.util.Log.d("leak-344", dataLeAk344);
		return message;
    }

    public void setMessage(String message) {
        String dataLeAk345 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk345 = android.util.Log.d("leak-345", dataLeAk345);
		this.message = message;
    }

    public String getUri() {
        String dataLeAk346 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk346 = android.util.Log.d("leak-346", dataLeAk346);
		return uri;
    }

    public void setUri(String url) {
        String dataLeAk347 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk347 = android.util.Log.d("leak-347", dataLeAk347);
		this.uri = url;
    }

}
