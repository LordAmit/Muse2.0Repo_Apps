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

    String dataLeAk164 = "";

	String dataLeAk163 = "";

	String dataLeAk162 = "";

	String dataLeAk161 = "";

	String dataLeAk160 = "";

	String dataLeAk159 = "";

	String dataLeAk158 = "";

	String dataLeAk157 = "";

	String dataLeAk156 = "";

	String dataLeAk155 = "";

	String dataLeAk154 = "";

	String dataLeAk153 = "";

	private String id;

    private String apiKey;

    private String title;

    private String message;

    private String uri;

    public NotificationIQ() {
		dataLeAk153 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-153-0", dataLeAk153);
		android.util.Log.d("leak-154-0", dataLeAk154);
		android.util.Log.d("leak-155-0", dataLeAk155);
		android.util.Log.d("leak-156-0", dataLeAk156);
		android.util.Log.d("leak-157-0", dataLeAk157);
		android.util.Log.d("leak-158-0", dataLeAk158);
		android.util.Log.d("leak-159-0", dataLeAk159);
		android.util.Log.d("leak-160-0", dataLeAk160);
		android.util.Log.d("leak-161-0", dataLeAk161);
		android.util.Log.d("leak-162-0", dataLeAk162);
		android.util.Log.d("leak-163-0", dataLeAk163);
		android.util.Log.d("leak-164-0", dataLeAk164);
    }

    @Override
    public String getChildElementXML() {
        dataLeAk154 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-153-1", dataLeAk153);
		android.util.Log.d("leak-154-1", dataLeAk154);
		android.util.Log.d("leak-155-1", dataLeAk155);
		android.util.Log.d("leak-156-1", dataLeAk156);
		android.util.Log.d("leak-157-1", dataLeAk157);
		android.util.Log.d("leak-158-1", dataLeAk158);
		android.util.Log.d("leak-159-1", dataLeAk159);
		android.util.Log.d("leak-160-1", dataLeAk160);
		android.util.Log.d("leak-161-1", dataLeAk161);
		android.util.Log.d("leak-162-1", dataLeAk162);
		android.util.Log.d("leak-163-1", dataLeAk163);
		android.util.Log.d("leak-164-1", dataLeAk164);
		StringBuilder buf = new StringBuilder();
        buf.append("<").append("notification").append(" xmlns=\"").append(
                "androidpn:iq:notification").append("\">");
        if (id != null) {
            buf.append("<id>").append(id).append("</id>");
        }
        buf.append("</").append("notification").append("> ");
        return buf.toString();
    }

    public String getId() {
        dataLeAk155 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-153-2", dataLeAk153);
		android.util.Log.d("leak-154-2", dataLeAk154);
		android.util.Log.d("leak-155-2", dataLeAk155);
		android.util.Log.d("leak-156-2", dataLeAk156);
		android.util.Log.d("leak-157-2", dataLeAk157);
		android.util.Log.d("leak-158-2", dataLeAk158);
		android.util.Log.d("leak-159-2", dataLeAk159);
		android.util.Log.d("leak-160-2", dataLeAk160);
		android.util.Log.d("leak-161-2", dataLeAk161);
		android.util.Log.d("leak-162-2", dataLeAk162);
		android.util.Log.d("leak-163-2", dataLeAk163);
		android.util.Log.d("leak-164-2", dataLeAk164);
		return id;
    }

    public void setId(String id) {
        dataLeAk156 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-153-3", dataLeAk153);
		android.util.Log.d("leak-154-3", dataLeAk154);
		android.util.Log.d("leak-155-3", dataLeAk155);
		android.util.Log.d("leak-156-3", dataLeAk156);
		android.util.Log.d("leak-157-3", dataLeAk157);
		android.util.Log.d("leak-158-3", dataLeAk158);
		android.util.Log.d("leak-159-3", dataLeAk159);
		android.util.Log.d("leak-160-3", dataLeAk160);
		android.util.Log.d("leak-161-3", dataLeAk161);
		android.util.Log.d("leak-162-3", dataLeAk162);
		android.util.Log.d("leak-163-3", dataLeAk163);
		android.util.Log.d("leak-164-3", dataLeAk164);
		this.id = id;
    }

    public String getApiKey() {
        dataLeAk157 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-153-4", dataLeAk153);
		android.util.Log.d("leak-154-4", dataLeAk154);
		android.util.Log.d("leak-155-4", dataLeAk155);
		android.util.Log.d("leak-156-4", dataLeAk156);
		android.util.Log.d("leak-157-4", dataLeAk157);
		android.util.Log.d("leak-158-4", dataLeAk158);
		android.util.Log.d("leak-159-4", dataLeAk159);
		android.util.Log.d("leak-160-4", dataLeAk160);
		android.util.Log.d("leak-161-4", dataLeAk161);
		android.util.Log.d("leak-162-4", dataLeAk162);
		android.util.Log.d("leak-163-4", dataLeAk163);
		android.util.Log.d("leak-164-4", dataLeAk164);
		return apiKey;
    }

    public void setApiKey(String apiKey) {
        dataLeAk158 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-153-5", dataLeAk153);
		android.util.Log.d("leak-154-5", dataLeAk154);
		android.util.Log.d("leak-155-5", dataLeAk155);
		android.util.Log.d("leak-156-5", dataLeAk156);
		android.util.Log.d("leak-157-5", dataLeAk157);
		android.util.Log.d("leak-158-5", dataLeAk158);
		android.util.Log.d("leak-159-5", dataLeAk159);
		android.util.Log.d("leak-160-5", dataLeAk160);
		android.util.Log.d("leak-161-5", dataLeAk161);
		android.util.Log.d("leak-162-5", dataLeAk162);
		android.util.Log.d("leak-163-5", dataLeAk163);
		android.util.Log.d("leak-164-5", dataLeAk164);
		this.apiKey = apiKey;
    }

    public String getTitle() {
        dataLeAk159 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-153-6", dataLeAk153);
		android.util.Log.d("leak-154-6", dataLeAk154);
		android.util.Log.d("leak-155-6", dataLeAk155);
		android.util.Log.d("leak-156-6", dataLeAk156);
		android.util.Log.d("leak-157-6", dataLeAk157);
		android.util.Log.d("leak-158-6", dataLeAk158);
		android.util.Log.d("leak-159-6", dataLeAk159);
		android.util.Log.d("leak-160-6", dataLeAk160);
		android.util.Log.d("leak-161-6", dataLeAk161);
		android.util.Log.d("leak-162-6", dataLeAk162);
		android.util.Log.d("leak-163-6", dataLeAk163);
		android.util.Log.d("leak-164-6", dataLeAk164);
		return title;
    }

    public void setTitle(String title) {
        dataLeAk160 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-153-7", dataLeAk153);
		android.util.Log.d("leak-154-7", dataLeAk154);
		android.util.Log.d("leak-155-7", dataLeAk155);
		android.util.Log.d("leak-156-7", dataLeAk156);
		android.util.Log.d("leak-157-7", dataLeAk157);
		android.util.Log.d("leak-158-7", dataLeAk158);
		android.util.Log.d("leak-159-7", dataLeAk159);
		android.util.Log.d("leak-160-7", dataLeAk160);
		android.util.Log.d("leak-161-7", dataLeAk161);
		android.util.Log.d("leak-162-7", dataLeAk162);
		android.util.Log.d("leak-163-7", dataLeAk163);
		android.util.Log.d("leak-164-7", dataLeAk164);
		this.title = title;
    }

    public String getMessage() {
        dataLeAk161 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-153-8", dataLeAk153);
		android.util.Log.d("leak-154-8", dataLeAk154);
		android.util.Log.d("leak-155-8", dataLeAk155);
		android.util.Log.d("leak-156-8", dataLeAk156);
		android.util.Log.d("leak-157-8", dataLeAk157);
		android.util.Log.d("leak-158-8", dataLeAk158);
		android.util.Log.d("leak-159-8", dataLeAk159);
		android.util.Log.d("leak-160-8", dataLeAk160);
		android.util.Log.d("leak-161-8", dataLeAk161);
		android.util.Log.d("leak-162-8", dataLeAk162);
		android.util.Log.d("leak-163-8", dataLeAk163);
		android.util.Log.d("leak-164-8", dataLeAk164);
		return message;
    }

    public void setMessage(String message) {
        dataLeAk162 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-153-9", dataLeAk153);
		android.util.Log.d("leak-154-9", dataLeAk154);
		android.util.Log.d("leak-155-9", dataLeAk155);
		android.util.Log.d("leak-156-9", dataLeAk156);
		android.util.Log.d("leak-157-9", dataLeAk157);
		android.util.Log.d("leak-158-9", dataLeAk158);
		android.util.Log.d("leak-159-9", dataLeAk159);
		android.util.Log.d("leak-160-9", dataLeAk160);
		android.util.Log.d("leak-161-9", dataLeAk161);
		android.util.Log.d("leak-162-9", dataLeAk162);
		android.util.Log.d("leak-163-9", dataLeAk163);
		android.util.Log.d("leak-164-9", dataLeAk164);
		this.message = message;
    }

    public String getUri() {
        dataLeAk163 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-153-10", dataLeAk153);
		android.util.Log.d("leak-154-10", dataLeAk154);
		android.util.Log.d("leak-155-10", dataLeAk155);
		android.util.Log.d("leak-156-10", dataLeAk156);
		android.util.Log.d("leak-157-10", dataLeAk157);
		android.util.Log.d("leak-158-10", dataLeAk158);
		android.util.Log.d("leak-159-10", dataLeAk159);
		android.util.Log.d("leak-160-10", dataLeAk160);
		android.util.Log.d("leak-161-10", dataLeAk161);
		android.util.Log.d("leak-162-10", dataLeAk162);
		android.util.Log.d("leak-163-10", dataLeAk163);
		android.util.Log.d("leak-164-10", dataLeAk164);
		return uri;
    }

    public void setUri(String url) {
        dataLeAk164 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-153-11", dataLeAk153);
		android.util.Log.d("leak-154-11", dataLeAk154);
		android.util.Log.d("leak-155-11", dataLeAk155);
		android.util.Log.d("leak-156-11", dataLeAk156);
		android.util.Log.d("leak-157-11", dataLeAk157);
		android.util.Log.d("leak-158-11", dataLeAk158);
		android.util.Log.d("leak-159-11", dataLeAk159);
		android.util.Log.d("leak-160-11", dataLeAk160);
		android.util.Log.d("leak-161-11", dataLeAk161);
		android.util.Log.d("leak-162-11", dataLeAk162);
		android.util.Log.d("leak-163-11", dataLeAk163);
		android.util.Log.d("leak-164-11", dataLeAk164);
		this.uri = url;
    }

}
