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

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.util.Log;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.ConnectionConfiguration.SecurityMode;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.filter.PacketIDFilter;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.packet.Registration;
import org.jivesoftware.smack.provider.ProviderManager;

//import org.igniterealtime.smack.ConnectionListener;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Future;

/**
 * This class is to manage the XMPP connection between client and server.
 *
 * @author Sehwan Noh (devnoh@gmail.com)
 */
public class XmppManager {

    final String dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk95 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk93 = "";

	String dataLeAk91 = "";

	String dataLeAk88 = "";

	String dataLeAk86 = "";

	String dataLeAk84 = "";

	String dataLeAk82 = "";

	String dataLeAk80 = "";

	String dataLeAk79 = "";

	String dataLeAk78 = "";

	String dataLeAk77 = "";

	String dataLeAk76 = "";

	String dataLeAk75 = "";

	String dataLeAk74 = "";

	String dataLeAk73 = "";

	String dataLeAk72 = "";

	String dataLeAk71 = "";

	String dataLeAk70 = "";

	String dataLeAk69 = "";

	String dataLeAk68 = "";

	String dataLeAk67 = "";

	String dataLeAk66 = "";

	String dataLeAk65 = "";

	String dataLeAk64 = "";

	String dataLeAk63 = "";

	String dataLeAk62 = "";

	String dataLeAk61 = "";

	String dataLeAk60 = "";

	String dataLeAk59 = "";

	String dataLeAk58 = "";

	String dataLeAk56 = "";

	String dataLeAk55 = "";

	String dataLeAk54 = "";

	String dataLeAk53 = "";

	String dataLeAk52 = "";

	private static final String LOGTAG = LogUtil.makeLogTag(XmppManager.class);

    private static final String XMPP_RESOURCE_NAME = "AndroidpnClient";

    private Context context;

    private NotificationService.TaskSubmitter taskSubmitter;

    private NotificationService.TaskTracker taskTracker;

    private SharedPreferences sharedPrefs;

    private String xmppHost;

    private int xmppPort;

    private XMPPConnection connection;

    private String username;

    private String password;

    private String newUsername;

    private String newPassword;

    private String email;

    private String name;

    private ConnectionListener connectionListener;

    private PacketListener notificationPacketListener;

    private Handler handler;

    private List<Runnable> taskList;

    private boolean running = false;

    private Future<?> futureTask;

    private Thread reconnection;

    public XmppManager(NotificationService notificationService) {
        dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-0", dataLeAk52);
		android.util.Log.d("leak-53-0", dataLeAk53);
		android.util.Log.d("leak-54-0", dataLeAk54);
		android.util.Log.d("leak-55-0", dataLeAk55);
		android.util.Log.d("leak-56-0", dataLeAk56);
		android.util.Log.d("leak-58-0", dataLeAk58);
		android.util.Log.d("leak-59-0", dataLeAk59);
		android.util.Log.d("leak-60-0", dataLeAk60);
		android.util.Log.d("leak-61-0", dataLeAk61);
		android.util.Log.d("leak-62-0", dataLeAk62);
		android.util.Log.d("leak-63-0", dataLeAk63);
		android.util.Log.d("leak-64-0", dataLeAk64);
		android.util.Log.d("leak-65-0", dataLeAk65);
		android.util.Log.d("leak-66-0", dataLeAk66);
		android.util.Log.d("leak-67-0", dataLeAk67);
		android.util.Log.d("leak-68-0", dataLeAk68);
		android.util.Log.d("leak-69-0", dataLeAk69);
		android.util.Log.d("leak-70-0", dataLeAk70);
		android.util.Log.d("leak-71-0", dataLeAk71);
		android.util.Log.d("leak-72-0", dataLeAk72);
		android.util.Log.d("leak-73-0", dataLeAk73);
		android.util.Log.d("leak-74-0", dataLeAk74);
		android.util.Log.d("leak-75-0", dataLeAk75);
		android.util.Log.d("leak-76-0", dataLeAk76);
		android.util.Log.d("leak-77-0", dataLeAk77);
		android.util.Log.d("leak-78-0", dataLeAk78);
		android.util.Log.d("leak-79-0", dataLeAk79);
		android.util.Log.d("leak-80-0", dataLeAk80);
		android.util.Log.d("leak-82-0", dataLeAk82);
		android.util.Log.d("leak-84-0", dataLeAk84);
		android.util.Log.d("leak-86-0", dataLeAk86);
		android.util.Log.d("leak-88-0", dataLeAk88);
		android.util.Log.d("leak-91-0", dataLeAk91);
		android.util.Log.d("leak-93-0", dataLeAk93);
		context = notificationService;
        taskSubmitter = notificationService.getTaskSubmitter();
        taskTracker = notificationService.getTaskTracker();
        sharedPrefs = notificationService.getSharedPreferences();

        xmppHost = sharedPrefs.getString(Constants.XMPP_HOST, "localhost");
        xmppPort = sharedPrefs.getInt(Constants.XMPP_PORT, 5222);
        username = sharedPrefs.getString(Constants.XMPP_USERNAME, "");
        password = sharedPrefs.getString(Constants.XMPP_PASSWORD, "");
        email = sharedPrefs.getString(Constants.XMPP_EMAIL, "");
        name = sharedPrefs.getString(Constants.NAME, "");

        connectionListener = new PersistentConnectionListener(this);
        notificationPacketListener = new NotificationPacketListener(this);

        handler = new Handler();
        taskList = new ArrayList<Runnable>();
        reconnection = new ReconnectionThread(this);
    }

    public Context getContext() {
        dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-1", dataLeAk52);
		android.util.Log.d("leak-53-1", dataLeAk53);
		android.util.Log.d("leak-54-1", dataLeAk54);
		android.util.Log.d("leak-55-1", dataLeAk55);
		android.util.Log.d("leak-56-1", dataLeAk56);
		android.util.Log.d("leak-58-1", dataLeAk58);
		android.util.Log.d("leak-59-1", dataLeAk59);
		android.util.Log.d("leak-60-1", dataLeAk60);
		android.util.Log.d("leak-61-1", dataLeAk61);
		android.util.Log.d("leak-62-1", dataLeAk62);
		android.util.Log.d("leak-63-1", dataLeAk63);
		android.util.Log.d("leak-64-1", dataLeAk64);
		android.util.Log.d("leak-65-1", dataLeAk65);
		android.util.Log.d("leak-66-1", dataLeAk66);
		android.util.Log.d("leak-67-1", dataLeAk67);
		android.util.Log.d("leak-68-1", dataLeAk68);
		android.util.Log.d("leak-69-1", dataLeAk69);
		android.util.Log.d("leak-70-1", dataLeAk70);
		android.util.Log.d("leak-71-1", dataLeAk71);
		android.util.Log.d("leak-72-1", dataLeAk72);
		android.util.Log.d("leak-73-1", dataLeAk73);
		android.util.Log.d("leak-74-1", dataLeAk74);
		android.util.Log.d("leak-75-1", dataLeAk75);
		android.util.Log.d("leak-76-1", dataLeAk76);
		android.util.Log.d("leak-77-1", dataLeAk77);
		android.util.Log.d("leak-78-1", dataLeAk78);
		android.util.Log.d("leak-79-1", dataLeAk79);
		android.util.Log.d("leak-80-1", dataLeAk80);
		android.util.Log.d("leak-82-1", dataLeAk82);
		android.util.Log.d("leak-84-1", dataLeAk84);
		android.util.Log.d("leak-86-1", dataLeAk86);
		android.util.Log.d("leak-88-1", dataLeAk88);
		android.util.Log.d("leak-91-1", dataLeAk91);
		android.util.Log.d("leak-93-1", dataLeAk93);
		return context;
    }

    public void connect() {
        dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-2", dataLeAk52);
		android.util.Log.d("leak-53-2", dataLeAk53);
		android.util.Log.d("leak-54-2", dataLeAk54);
		android.util.Log.d("leak-55-2", dataLeAk55);
		android.util.Log.d("leak-56-2", dataLeAk56);
		android.util.Log.d("leak-58-2", dataLeAk58);
		android.util.Log.d("leak-59-2", dataLeAk59);
		android.util.Log.d("leak-60-2", dataLeAk60);
		android.util.Log.d("leak-61-2", dataLeAk61);
		android.util.Log.d("leak-62-2", dataLeAk62);
		android.util.Log.d("leak-63-2", dataLeAk63);
		android.util.Log.d("leak-64-2", dataLeAk64);
		android.util.Log.d("leak-65-2", dataLeAk65);
		android.util.Log.d("leak-66-2", dataLeAk66);
		android.util.Log.d("leak-67-2", dataLeAk67);
		android.util.Log.d("leak-68-2", dataLeAk68);
		android.util.Log.d("leak-69-2", dataLeAk69);
		android.util.Log.d("leak-70-2", dataLeAk70);
		android.util.Log.d("leak-71-2", dataLeAk71);
		android.util.Log.d("leak-72-2", dataLeAk72);
		android.util.Log.d("leak-73-2", dataLeAk73);
		android.util.Log.d("leak-74-2", dataLeAk74);
		android.util.Log.d("leak-75-2", dataLeAk75);
		android.util.Log.d("leak-76-2", dataLeAk76);
		android.util.Log.d("leak-77-2", dataLeAk77);
		android.util.Log.d("leak-78-2", dataLeAk78);
		android.util.Log.d("leak-79-2", dataLeAk79);
		android.util.Log.d("leak-80-2", dataLeAk80);
		android.util.Log.d("leak-82-2", dataLeAk82);
		android.util.Log.d("leak-84-2", dataLeAk84);
		android.util.Log.d("leak-86-2", dataLeAk86);
		android.util.Log.d("leak-88-2", dataLeAk88);
		android.util.Log.d("leak-91-2", dataLeAk91);
		android.util.Log.d("leak-93-2", dataLeAk93);
		Log.d(LOGTAG, "connect()...");
        submitLoginTask();
    }

    public void disconnect() {
        dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-3", dataLeAk52);
		android.util.Log.d("leak-53-3", dataLeAk53);
		android.util.Log.d("leak-54-3", dataLeAk54);
		android.util.Log.d("leak-55-3", dataLeAk55);
		android.util.Log.d("leak-56-3", dataLeAk56);
		android.util.Log.d("leak-58-3", dataLeAk58);
		android.util.Log.d("leak-59-3", dataLeAk59);
		android.util.Log.d("leak-60-3", dataLeAk60);
		android.util.Log.d("leak-61-3", dataLeAk61);
		android.util.Log.d("leak-62-3", dataLeAk62);
		android.util.Log.d("leak-63-3", dataLeAk63);
		android.util.Log.d("leak-64-3", dataLeAk64);
		android.util.Log.d("leak-65-3", dataLeAk65);
		android.util.Log.d("leak-66-3", dataLeAk66);
		android.util.Log.d("leak-67-3", dataLeAk67);
		android.util.Log.d("leak-68-3", dataLeAk68);
		android.util.Log.d("leak-69-3", dataLeAk69);
		android.util.Log.d("leak-70-3", dataLeAk70);
		android.util.Log.d("leak-71-3", dataLeAk71);
		android.util.Log.d("leak-72-3", dataLeAk72);
		android.util.Log.d("leak-73-3", dataLeAk73);
		android.util.Log.d("leak-74-3", dataLeAk74);
		android.util.Log.d("leak-75-3", dataLeAk75);
		android.util.Log.d("leak-76-3", dataLeAk76);
		android.util.Log.d("leak-77-3", dataLeAk77);
		android.util.Log.d("leak-78-3", dataLeAk78);
		android.util.Log.d("leak-79-3", dataLeAk79);
		android.util.Log.d("leak-80-3", dataLeAk80);
		android.util.Log.d("leak-82-3", dataLeAk82);
		android.util.Log.d("leak-84-3", dataLeAk84);
		android.util.Log.d("leak-86-3", dataLeAk86);
		android.util.Log.d("leak-88-3", dataLeAk88);
		android.util.Log.d("leak-91-3", dataLeAk91);
		android.util.Log.d("leak-93-3", dataLeAk93);
		Log.d(LOGTAG, "disconnect()...");
        if (sharedPrefs.contains(Constants.XMPP_LOGGEDIN)) {
            Editor editor = sharedPrefs.edit();
            editor.remove(Constants.XMPP_LOGGEDIN);
            editor.remove(Constants.XMPP_REGISTERED);
            editor.apply();
        }
        terminatePersistentConnection();
    }

    public void terminatePersistentConnection() {
        dataLeAk56 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-4", dataLeAk52);
		android.util.Log.d("leak-53-4", dataLeAk53);
		android.util.Log.d("leak-54-4", dataLeAk54);
		android.util.Log.d("leak-55-4", dataLeAk55);
		android.util.Log.d("leak-56-4", dataLeAk56);
		android.util.Log.d("leak-58-4", dataLeAk58);
		android.util.Log.d("leak-59-4", dataLeAk59);
		android.util.Log.d("leak-60-4", dataLeAk60);
		android.util.Log.d("leak-61-4", dataLeAk61);
		android.util.Log.d("leak-62-4", dataLeAk62);
		android.util.Log.d("leak-63-4", dataLeAk63);
		android.util.Log.d("leak-64-4", dataLeAk64);
		android.util.Log.d("leak-65-4", dataLeAk65);
		android.util.Log.d("leak-66-4", dataLeAk66);
		android.util.Log.d("leak-67-4", dataLeAk67);
		android.util.Log.d("leak-68-4", dataLeAk68);
		android.util.Log.d("leak-69-4", dataLeAk69);
		android.util.Log.d("leak-70-4", dataLeAk70);
		android.util.Log.d("leak-71-4", dataLeAk71);
		android.util.Log.d("leak-72-4", dataLeAk72);
		android.util.Log.d("leak-73-4", dataLeAk73);
		android.util.Log.d("leak-74-4", dataLeAk74);
		android.util.Log.d("leak-75-4", dataLeAk75);
		android.util.Log.d("leak-76-4", dataLeAk76);
		android.util.Log.d("leak-77-4", dataLeAk77);
		android.util.Log.d("leak-78-4", dataLeAk78);
		android.util.Log.d("leak-79-4", dataLeAk79);
		android.util.Log.d("leak-80-4", dataLeAk80);
		android.util.Log.d("leak-82-4", dataLeAk82);
		android.util.Log.d("leak-84-4", dataLeAk84);
		android.util.Log.d("leak-86-4", dataLeAk86);
		android.util.Log.d("leak-88-4", dataLeAk88);
		android.util.Log.d("leak-91-4", dataLeAk91);
		android.util.Log.d("leak-93-4", dataLeAk93);
		Log.d(LOGTAG, "terminatePersistentConnection()...");
        Runnable runnable = new Runnable() {

            String dataLeAk57 = "";

			final XmppManager xmppManager = XmppManager.this;

            public void run() {
                dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-95-0", dataLeAk95);
				android.util.Log.d("leak-57-0", dataLeAk57);
				if (xmppManager.isConnected()) {
                    Log.d(LOGTAG, "terminatePersistentConnection()... run()");
                    xmppManager.getConnection().removePacketListener(
                            xmppManager.getNotificationPacketListener());
                    xmppManager.getConnection().disconnect();
                }
                xmppManager.runTask();
            }

        };
        addTask(runnable);
    }

    public XMPPConnection getConnection() {
        dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-5", dataLeAk52);
		android.util.Log.d("leak-53-5", dataLeAk53);
		android.util.Log.d("leak-54-5", dataLeAk54);
		android.util.Log.d("leak-55-5", dataLeAk55);
		android.util.Log.d("leak-56-5", dataLeAk56);
		android.util.Log.d("leak-58-5", dataLeAk58);
		android.util.Log.d("leak-59-5", dataLeAk59);
		android.util.Log.d("leak-60-5", dataLeAk60);
		android.util.Log.d("leak-61-5", dataLeAk61);
		android.util.Log.d("leak-62-5", dataLeAk62);
		android.util.Log.d("leak-63-5", dataLeAk63);
		android.util.Log.d("leak-64-5", dataLeAk64);
		android.util.Log.d("leak-65-5", dataLeAk65);
		android.util.Log.d("leak-66-5", dataLeAk66);
		android.util.Log.d("leak-67-5", dataLeAk67);
		android.util.Log.d("leak-68-5", dataLeAk68);
		android.util.Log.d("leak-69-5", dataLeAk69);
		android.util.Log.d("leak-70-5", dataLeAk70);
		android.util.Log.d("leak-71-5", dataLeAk71);
		android.util.Log.d("leak-72-5", dataLeAk72);
		android.util.Log.d("leak-73-5", dataLeAk73);
		android.util.Log.d("leak-74-5", dataLeAk74);
		android.util.Log.d("leak-75-5", dataLeAk75);
		android.util.Log.d("leak-76-5", dataLeAk76);
		android.util.Log.d("leak-77-5", dataLeAk77);
		android.util.Log.d("leak-78-5", dataLeAk78);
		android.util.Log.d("leak-79-5", dataLeAk79);
		android.util.Log.d("leak-80-5", dataLeAk80);
		android.util.Log.d("leak-82-5", dataLeAk82);
		android.util.Log.d("leak-84-5", dataLeAk84);
		android.util.Log.d("leak-86-5", dataLeAk86);
		android.util.Log.d("leak-88-5", dataLeAk88);
		android.util.Log.d("leak-91-5", dataLeAk91);
		android.util.Log.d("leak-93-5", dataLeAk93);
		return connection;
    }

    public void setConnection(XMPPConnection connection) {
        dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-6", dataLeAk52);
		android.util.Log.d("leak-53-6", dataLeAk53);
		android.util.Log.d("leak-54-6", dataLeAk54);
		android.util.Log.d("leak-55-6", dataLeAk55);
		android.util.Log.d("leak-56-6", dataLeAk56);
		android.util.Log.d("leak-58-6", dataLeAk58);
		android.util.Log.d("leak-59-6", dataLeAk59);
		android.util.Log.d("leak-60-6", dataLeAk60);
		android.util.Log.d("leak-61-6", dataLeAk61);
		android.util.Log.d("leak-62-6", dataLeAk62);
		android.util.Log.d("leak-63-6", dataLeAk63);
		android.util.Log.d("leak-64-6", dataLeAk64);
		android.util.Log.d("leak-65-6", dataLeAk65);
		android.util.Log.d("leak-66-6", dataLeAk66);
		android.util.Log.d("leak-67-6", dataLeAk67);
		android.util.Log.d("leak-68-6", dataLeAk68);
		android.util.Log.d("leak-69-6", dataLeAk69);
		android.util.Log.d("leak-70-6", dataLeAk70);
		android.util.Log.d("leak-71-6", dataLeAk71);
		android.util.Log.d("leak-72-6", dataLeAk72);
		android.util.Log.d("leak-73-6", dataLeAk73);
		android.util.Log.d("leak-74-6", dataLeAk74);
		android.util.Log.d("leak-75-6", dataLeAk75);
		android.util.Log.d("leak-76-6", dataLeAk76);
		android.util.Log.d("leak-77-6", dataLeAk77);
		android.util.Log.d("leak-78-6", dataLeAk78);
		android.util.Log.d("leak-79-6", dataLeAk79);
		android.util.Log.d("leak-80-6", dataLeAk80);
		android.util.Log.d("leak-82-6", dataLeAk82);
		android.util.Log.d("leak-84-6", dataLeAk84);
		android.util.Log.d("leak-86-6", dataLeAk86);
		android.util.Log.d("leak-88-6", dataLeAk88);
		android.util.Log.d("leak-91-6", dataLeAk91);
		android.util.Log.d("leak-93-6", dataLeAk93);
		this.connection = connection;
    }

    public String getUsername() {
        dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-7", dataLeAk52);
		android.util.Log.d("leak-53-7", dataLeAk53);
		android.util.Log.d("leak-54-7", dataLeAk54);
		android.util.Log.d("leak-55-7", dataLeAk55);
		android.util.Log.d("leak-56-7", dataLeAk56);
		android.util.Log.d("leak-58-7", dataLeAk58);
		android.util.Log.d("leak-59-7", dataLeAk59);
		android.util.Log.d("leak-60-7", dataLeAk60);
		android.util.Log.d("leak-61-7", dataLeAk61);
		android.util.Log.d("leak-62-7", dataLeAk62);
		android.util.Log.d("leak-63-7", dataLeAk63);
		android.util.Log.d("leak-64-7", dataLeAk64);
		android.util.Log.d("leak-65-7", dataLeAk65);
		android.util.Log.d("leak-66-7", dataLeAk66);
		android.util.Log.d("leak-67-7", dataLeAk67);
		android.util.Log.d("leak-68-7", dataLeAk68);
		android.util.Log.d("leak-69-7", dataLeAk69);
		android.util.Log.d("leak-70-7", dataLeAk70);
		android.util.Log.d("leak-71-7", dataLeAk71);
		android.util.Log.d("leak-72-7", dataLeAk72);
		android.util.Log.d("leak-73-7", dataLeAk73);
		android.util.Log.d("leak-74-7", dataLeAk74);
		android.util.Log.d("leak-75-7", dataLeAk75);
		android.util.Log.d("leak-76-7", dataLeAk76);
		android.util.Log.d("leak-77-7", dataLeAk77);
		android.util.Log.d("leak-78-7", dataLeAk78);
		android.util.Log.d("leak-79-7", dataLeAk79);
		android.util.Log.d("leak-80-7", dataLeAk80);
		android.util.Log.d("leak-82-7", dataLeAk82);
		android.util.Log.d("leak-84-7", dataLeAk84);
		android.util.Log.d("leak-86-7", dataLeAk86);
		android.util.Log.d("leak-88-7", dataLeAk88);
		android.util.Log.d("leak-91-7", dataLeAk91);
		android.util.Log.d("leak-93-7", dataLeAk93);
		return username;
    }

    public void setUsername(String username) {
        dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-8", dataLeAk52);
		android.util.Log.d("leak-53-8", dataLeAk53);
		android.util.Log.d("leak-54-8", dataLeAk54);
		android.util.Log.d("leak-55-8", dataLeAk55);
		android.util.Log.d("leak-56-8", dataLeAk56);
		android.util.Log.d("leak-58-8", dataLeAk58);
		android.util.Log.d("leak-59-8", dataLeAk59);
		android.util.Log.d("leak-60-8", dataLeAk60);
		android.util.Log.d("leak-61-8", dataLeAk61);
		android.util.Log.d("leak-62-8", dataLeAk62);
		android.util.Log.d("leak-63-8", dataLeAk63);
		android.util.Log.d("leak-64-8", dataLeAk64);
		android.util.Log.d("leak-65-8", dataLeAk65);
		android.util.Log.d("leak-66-8", dataLeAk66);
		android.util.Log.d("leak-67-8", dataLeAk67);
		android.util.Log.d("leak-68-8", dataLeAk68);
		android.util.Log.d("leak-69-8", dataLeAk69);
		android.util.Log.d("leak-70-8", dataLeAk70);
		android.util.Log.d("leak-71-8", dataLeAk71);
		android.util.Log.d("leak-72-8", dataLeAk72);
		android.util.Log.d("leak-73-8", dataLeAk73);
		android.util.Log.d("leak-74-8", dataLeAk74);
		android.util.Log.d("leak-75-8", dataLeAk75);
		android.util.Log.d("leak-76-8", dataLeAk76);
		android.util.Log.d("leak-77-8", dataLeAk77);
		android.util.Log.d("leak-78-8", dataLeAk78);
		android.util.Log.d("leak-79-8", dataLeAk79);
		android.util.Log.d("leak-80-8", dataLeAk80);
		android.util.Log.d("leak-82-8", dataLeAk82);
		android.util.Log.d("leak-84-8", dataLeAk84);
		android.util.Log.d("leak-86-8", dataLeAk86);
		android.util.Log.d("leak-88-8", dataLeAk88);
		android.util.Log.d("leak-91-8", dataLeAk91);
		android.util.Log.d("leak-93-8", dataLeAk93);
		this.username = username;
    }

    public String getPassword() {
        dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-9", dataLeAk52);
		android.util.Log.d("leak-53-9", dataLeAk53);
		android.util.Log.d("leak-54-9", dataLeAk54);
		android.util.Log.d("leak-55-9", dataLeAk55);
		android.util.Log.d("leak-56-9", dataLeAk56);
		android.util.Log.d("leak-58-9", dataLeAk58);
		android.util.Log.d("leak-59-9", dataLeAk59);
		android.util.Log.d("leak-60-9", dataLeAk60);
		android.util.Log.d("leak-61-9", dataLeAk61);
		android.util.Log.d("leak-62-9", dataLeAk62);
		android.util.Log.d("leak-63-9", dataLeAk63);
		android.util.Log.d("leak-64-9", dataLeAk64);
		android.util.Log.d("leak-65-9", dataLeAk65);
		android.util.Log.d("leak-66-9", dataLeAk66);
		android.util.Log.d("leak-67-9", dataLeAk67);
		android.util.Log.d("leak-68-9", dataLeAk68);
		android.util.Log.d("leak-69-9", dataLeAk69);
		android.util.Log.d("leak-70-9", dataLeAk70);
		android.util.Log.d("leak-71-9", dataLeAk71);
		android.util.Log.d("leak-72-9", dataLeAk72);
		android.util.Log.d("leak-73-9", dataLeAk73);
		android.util.Log.d("leak-74-9", dataLeAk74);
		android.util.Log.d("leak-75-9", dataLeAk75);
		android.util.Log.d("leak-76-9", dataLeAk76);
		android.util.Log.d("leak-77-9", dataLeAk77);
		android.util.Log.d("leak-78-9", dataLeAk78);
		android.util.Log.d("leak-79-9", dataLeAk79);
		android.util.Log.d("leak-80-9", dataLeAk80);
		android.util.Log.d("leak-82-9", dataLeAk82);
		android.util.Log.d("leak-84-9", dataLeAk84);
		android.util.Log.d("leak-86-9", dataLeAk86);
		android.util.Log.d("leak-88-9", dataLeAk88);
		android.util.Log.d("leak-91-9", dataLeAk91);
		android.util.Log.d("leak-93-9", dataLeAk93);
		return password;
    }

    public void setPassword(String password) {
        dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-10", dataLeAk52);
		android.util.Log.d("leak-53-10", dataLeAk53);
		android.util.Log.d("leak-54-10", dataLeAk54);
		android.util.Log.d("leak-55-10", dataLeAk55);
		android.util.Log.d("leak-56-10", dataLeAk56);
		android.util.Log.d("leak-58-10", dataLeAk58);
		android.util.Log.d("leak-59-10", dataLeAk59);
		android.util.Log.d("leak-60-10", dataLeAk60);
		android.util.Log.d("leak-61-10", dataLeAk61);
		android.util.Log.d("leak-62-10", dataLeAk62);
		android.util.Log.d("leak-63-10", dataLeAk63);
		android.util.Log.d("leak-64-10", dataLeAk64);
		android.util.Log.d("leak-65-10", dataLeAk65);
		android.util.Log.d("leak-66-10", dataLeAk66);
		android.util.Log.d("leak-67-10", dataLeAk67);
		android.util.Log.d("leak-68-10", dataLeAk68);
		android.util.Log.d("leak-69-10", dataLeAk69);
		android.util.Log.d("leak-70-10", dataLeAk70);
		android.util.Log.d("leak-71-10", dataLeAk71);
		android.util.Log.d("leak-72-10", dataLeAk72);
		android.util.Log.d("leak-73-10", dataLeAk73);
		android.util.Log.d("leak-74-10", dataLeAk74);
		android.util.Log.d("leak-75-10", dataLeAk75);
		android.util.Log.d("leak-76-10", dataLeAk76);
		android.util.Log.d("leak-77-10", dataLeAk77);
		android.util.Log.d("leak-78-10", dataLeAk78);
		android.util.Log.d("leak-79-10", dataLeAk79);
		android.util.Log.d("leak-80-10", dataLeAk80);
		android.util.Log.d("leak-82-10", dataLeAk82);
		android.util.Log.d("leak-84-10", dataLeAk84);
		android.util.Log.d("leak-86-10", dataLeAk86);
		android.util.Log.d("leak-88-10", dataLeAk88);
		android.util.Log.d("leak-91-10", dataLeAk91);
		android.util.Log.d("leak-93-10", dataLeAk93);
		this.password = password;
    }

    public ConnectionListener getConnectionListener() {
        dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-11", dataLeAk52);
		android.util.Log.d("leak-53-11", dataLeAk53);
		android.util.Log.d("leak-54-11", dataLeAk54);
		android.util.Log.d("leak-55-11", dataLeAk55);
		android.util.Log.d("leak-56-11", dataLeAk56);
		android.util.Log.d("leak-58-11", dataLeAk58);
		android.util.Log.d("leak-59-11", dataLeAk59);
		android.util.Log.d("leak-60-11", dataLeAk60);
		android.util.Log.d("leak-61-11", dataLeAk61);
		android.util.Log.d("leak-62-11", dataLeAk62);
		android.util.Log.d("leak-63-11", dataLeAk63);
		android.util.Log.d("leak-64-11", dataLeAk64);
		android.util.Log.d("leak-65-11", dataLeAk65);
		android.util.Log.d("leak-66-11", dataLeAk66);
		android.util.Log.d("leak-67-11", dataLeAk67);
		android.util.Log.d("leak-68-11", dataLeAk68);
		android.util.Log.d("leak-69-11", dataLeAk69);
		android.util.Log.d("leak-70-11", dataLeAk70);
		android.util.Log.d("leak-71-11", dataLeAk71);
		android.util.Log.d("leak-72-11", dataLeAk72);
		android.util.Log.d("leak-73-11", dataLeAk73);
		android.util.Log.d("leak-74-11", dataLeAk74);
		android.util.Log.d("leak-75-11", dataLeAk75);
		android.util.Log.d("leak-76-11", dataLeAk76);
		android.util.Log.d("leak-77-11", dataLeAk77);
		android.util.Log.d("leak-78-11", dataLeAk78);
		android.util.Log.d("leak-79-11", dataLeAk79);
		android.util.Log.d("leak-80-11", dataLeAk80);
		android.util.Log.d("leak-82-11", dataLeAk82);
		android.util.Log.d("leak-84-11", dataLeAk84);
		android.util.Log.d("leak-86-11", dataLeAk86);
		android.util.Log.d("leak-88-11", dataLeAk88);
		android.util.Log.d("leak-91-11", dataLeAk91);
		android.util.Log.d("leak-93-11", dataLeAk93);
		return connectionListener;
    }

    public PacketListener getNotificationPacketListener() {
        dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-12", dataLeAk52);
		android.util.Log.d("leak-53-12", dataLeAk53);
		android.util.Log.d("leak-54-12", dataLeAk54);
		android.util.Log.d("leak-55-12", dataLeAk55);
		android.util.Log.d("leak-56-12", dataLeAk56);
		android.util.Log.d("leak-58-12", dataLeAk58);
		android.util.Log.d("leak-59-12", dataLeAk59);
		android.util.Log.d("leak-60-12", dataLeAk60);
		android.util.Log.d("leak-61-12", dataLeAk61);
		android.util.Log.d("leak-62-12", dataLeAk62);
		android.util.Log.d("leak-63-12", dataLeAk63);
		android.util.Log.d("leak-64-12", dataLeAk64);
		android.util.Log.d("leak-65-12", dataLeAk65);
		android.util.Log.d("leak-66-12", dataLeAk66);
		android.util.Log.d("leak-67-12", dataLeAk67);
		android.util.Log.d("leak-68-12", dataLeAk68);
		android.util.Log.d("leak-69-12", dataLeAk69);
		android.util.Log.d("leak-70-12", dataLeAk70);
		android.util.Log.d("leak-71-12", dataLeAk71);
		android.util.Log.d("leak-72-12", dataLeAk72);
		android.util.Log.d("leak-73-12", dataLeAk73);
		android.util.Log.d("leak-74-12", dataLeAk74);
		android.util.Log.d("leak-75-12", dataLeAk75);
		android.util.Log.d("leak-76-12", dataLeAk76);
		android.util.Log.d("leak-77-12", dataLeAk77);
		android.util.Log.d("leak-78-12", dataLeAk78);
		android.util.Log.d("leak-79-12", dataLeAk79);
		android.util.Log.d("leak-80-12", dataLeAk80);
		android.util.Log.d("leak-82-12", dataLeAk82);
		android.util.Log.d("leak-84-12", dataLeAk84);
		android.util.Log.d("leak-86-12", dataLeAk86);
		android.util.Log.d("leak-88-12", dataLeAk88);
		android.util.Log.d("leak-91-12", dataLeAk91);
		android.util.Log.d("leak-93-12", dataLeAk93);
		return notificationPacketListener;
    }

    public void startReconnectionThread() {
        dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-13", dataLeAk52);
		android.util.Log.d("leak-53-13", dataLeAk53);
		android.util.Log.d("leak-54-13", dataLeAk54);
		android.util.Log.d("leak-55-13", dataLeAk55);
		android.util.Log.d("leak-56-13", dataLeAk56);
		android.util.Log.d("leak-58-13", dataLeAk58);
		android.util.Log.d("leak-59-13", dataLeAk59);
		android.util.Log.d("leak-60-13", dataLeAk60);
		android.util.Log.d("leak-61-13", dataLeAk61);
		android.util.Log.d("leak-62-13", dataLeAk62);
		android.util.Log.d("leak-63-13", dataLeAk63);
		android.util.Log.d("leak-64-13", dataLeAk64);
		android.util.Log.d("leak-65-13", dataLeAk65);
		android.util.Log.d("leak-66-13", dataLeAk66);
		android.util.Log.d("leak-67-13", dataLeAk67);
		android.util.Log.d("leak-68-13", dataLeAk68);
		android.util.Log.d("leak-69-13", dataLeAk69);
		android.util.Log.d("leak-70-13", dataLeAk70);
		android.util.Log.d("leak-71-13", dataLeAk71);
		android.util.Log.d("leak-72-13", dataLeAk72);
		android.util.Log.d("leak-73-13", dataLeAk73);
		android.util.Log.d("leak-74-13", dataLeAk74);
		android.util.Log.d("leak-75-13", dataLeAk75);
		android.util.Log.d("leak-76-13", dataLeAk76);
		android.util.Log.d("leak-77-13", dataLeAk77);
		android.util.Log.d("leak-78-13", dataLeAk78);
		android.util.Log.d("leak-79-13", dataLeAk79);
		android.util.Log.d("leak-80-13", dataLeAk80);
		android.util.Log.d("leak-82-13", dataLeAk82);
		android.util.Log.d("leak-84-13", dataLeAk84);
		android.util.Log.d("leak-86-13", dataLeAk86);
		android.util.Log.d("leak-88-13", dataLeAk88);
		android.util.Log.d("leak-91-13", dataLeAk91);
		android.util.Log.d("leak-93-13", dataLeAk93);
		synchronized (reconnection) {
            if (!reconnection.isAlive()) {
                reconnection.setName("Xmpp Reconnection Thread");
                reconnection.start();
            }
        }
    }

    public Handler getHandler() {
        dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-14", dataLeAk52);
		android.util.Log.d("leak-53-14", dataLeAk53);
		android.util.Log.d("leak-54-14", dataLeAk54);
		android.util.Log.d("leak-55-14", dataLeAk55);
		android.util.Log.d("leak-56-14", dataLeAk56);
		android.util.Log.d("leak-58-14", dataLeAk58);
		android.util.Log.d("leak-59-14", dataLeAk59);
		android.util.Log.d("leak-60-14", dataLeAk60);
		android.util.Log.d("leak-61-14", dataLeAk61);
		android.util.Log.d("leak-62-14", dataLeAk62);
		android.util.Log.d("leak-63-14", dataLeAk63);
		android.util.Log.d("leak-64-14", dataLeAk64);
		android.util.Log.d("leak-65-14", dataLeAk65);
		android.util.Log.d("leak-66-14", dataLeAk66);
		android.util.Log.d("leak-67-14", dataLeAk67);
		android.util.Log.d("leak-68-14", dataLeAk68);
		android.util.Log.d("leak-69-14", dataLeAk69);
		android.util.Log.d("leak-70-14", dataLeAk70);
		android.util.Log.d("leak-71-14", dataLeAk71);
		android.util.Log.d("leak-72-14", dataLeAk72);
		android.util.Log.d("leak-73-14", dataLeAk73);
		android.util.Log.d("leak-74-14", dataLeAk74);
		android.util.Log.d("leak-75-14", dataLeAk75);
		android.util.Log.d("leak-76-14", dataLeAk76);
		android.util.Log.d("leak-77-14", dataLeAk77);
		android.util.Log.d("leak-78-14", dataLeAk78);
		android.util.Log.d("leak-79-14", dataLeAk79);
		android.util.Log.d("leak-80-14", dataLeAk80);
		android.util.Log.d("leak-82-14", dataLeAk82);
		android.util.Log.d("leak-84-14", dataLeAk84);
		android.util.Log.d("leak-86-14", dataLeAk86);
		android.util.Log.d("leak-88-14", dataLeAk88);
		android.util.Log.d("leak-91-14", dataLeAk91);
		android.util.Log.d("leak-93-14", dataLeAk93);
		return handler;
    }

    public void reregisterAccount() {
        dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-15", dataLeAk52);
		android.util.Log.d("leak-53-15", dataLeAk53);
		android.util.Log.d("leak-54-15", dataLeAk54);
		android.util.Log.d("leak-55-15", dataLeAk55);
		android.util.Log.d("leak-56-15", dataLeAk56);
		android.util.Log.d("leak-58-15", dataLeAk58);
		android.util.Log.d("leak-59-15", dataLeAk59);
		android.util.Log.d("leak-60-15", dataLeAk60);
		android.util.Log.d("leak-61-15", dataLeAk61);
		android.util.Log.d("leak-62-15", dataLeAk62);
		android.util.Log.d("leak-63-15", dataLeAk63);
		android.util.Log.d("leak-64-15", dataLeAk64);
		android.util.Log.d("leak-65-15", dataLeAk65);
		android.util.Log.d("leak-66-15", dataLeAk66);
		android.util.Log.d("leak-67-15", dataLeAk67);
		android.util.Log.d("leak-68-15", dataLeAk68);
		android.util.Log.d("leak-69-15", dataLeAk69);
		android.util.Log.d("leak-70-15", dataLeAk70);
		android.util.Log.d("leak-71-15", dataLeAk71);
		android.util.Log.d("leak-72-15", dataLeAk72);
		android.util.Log.d("leak-73-15", dataLeAk73);
		android.util.Log.d("leak-74-15", dataLeAk74);
		android.util.Log.d("leak-75-15", dataLeAk75);
		android.util.Log.d("leak-76-15", dataLeAk76);
		android.util.Log.d("leak-77-15", dataLeAk77);
		android.util.Log.d("leak-78-15", dataLeAk78);
		android.util.Log.d("leak-79-15", dataLeAk79);
		android.util.Log.d("leak-80-15", dataLeAk80);
		android.util.Log.d("leak-82-15", dataLeAk82);
		android.util.Log.d("leak-84-15", dataLeAk84);
		android.util.Log.d("leak-86-15", dataLeAk86);
		android.util.Log.d("leak-88-15", dataLeAk88);
		android.util.Log.d("leak-91-15", dataLeAk91);
		android.util.Log.d("leak-93-15", dataLeAk93);
		removeAccount();
        submitLoginTask();
        runTask();
    }

    public List<Runnable> getTaskList() {
        dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-16", dataLeAk52);
		android.util.Log.d("leak-53-16", dataLeAk53);
		android.util.Log.d("leak-54-16", dataLeAk54);
		android.util.Log.d("leak-55-16", dataLeAk55);
		android.util.Log.d("leak-56-16", dataLeAk56);
		android.util.Log.d("leak-58-16", dataLeAk58);
		android.util.Log.d("leak-59-16", dataLeAk59);
		android.util.Log.d("leak-60-16", dataLeAk60);
		android.util.Log.d("leak-61-16", dataLeAk61);
		android.util.Log.d("leak-62-16", dataLeAk62);
		android.util.Log.d("leak-63-16", dataLeAk63);
		android.util.Log.d("leak-64-16", dataLeAk64);
		android.util.Log.d("leak-65-16", dataLeAk65);
		android.util.Log.d("leak-66-16", dataLeAk66);
		android.util.Log.d("leak-67-16", dataLeAk67);
		android.util.Log.d("leak-68-16", dataLeAk68);
		android.util.Log.d("leak-69-16", dataLeAk69);
		android.util.Log.d("leak-70-16", dataLeAk70);
		android.util.Log.d("leak-71-16", dataLeAk71);
		android.util.Log.d("leak-72-16", dataLeAk72);
		android.util.Log.d("leak-73-16", dataLeAk73);
		android.util.Log.d("leak-74-16", dataLeAk74);
		android.util.Log.d("leak-75-16", dataLeAk75);
		android.util.Log.d("leak-76-16", dataLeAk76);
		android.util.Log.d("leak-77-16", dataLeAk77);
		android.util.Log.d("leak-78-16", dataLeAk78);
		android.util.Log.d("leak-79-16", dataLeAk79);
		android.util.Log.d("leak-80-16", dataLeAk80);
		android.util.Log.d("leak-82-16", dataLeAk82);
		android.util.Log.d("leak-84-16", dataLeAk84);
		android.util.Log.d("leak-86-16", dataLeAk86);
		android.util.Log.d("leak-88-16", dataLeAk88);
		android.util.Log.d("leak-91-16", dataLeAk91);
		android.util.Log.d("leak-93-16", dataLeAk93);
		return taskList;
    }

    public Future<?> getFutureTask() {
        dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-17", dataLeAk52);
		android.util.Log.d("leak-53-17", dataLeAk53);
		android.util.Log.d("leak-54-17", dataLeAk54);
		android.util.Log.d("leak-55-17", dataLeAk55);
		android.util.Log.d("leak-56-17", dataLeAk56);
		android.util.Log.d("leak-58-17", dataLeAk58);
		android.util.Log.d("leak-59-17", dataLeAk59);
		android.util.Log.d("leak-60-17", dataLeAk60);
		android.util.Log.d("leak-61-17", dataLeAk61);
		android.util.Log.d("leak-62-17", dataLeAk62);
		android.util.Log.d("leak-63-17", dataLeAk63);
		android.util.Log.d("leak-64-17", dataLeAk64);
		android.util.Log.d("leak-65-17", dataLeAk65);
		android.util.Log.d("leak-66-17", dataLeAk66);
		android.util.Log.d("leak-67-17", dataLeAk67);
		android.util.Log.d("leak-68-17", dataLeAk68);
		android.util.Log.d("leak-69-17", dataLeAk69);
		android.util.Log.d("leak-70-17", dataLeAk70);
		android.util.Log.d("leak-71-17", dataLeAk71);
		android.util.Log.d("leak-72-17", dataLeAk72);
		android.util.Log.d("leak-73-17", dataLeAk73);
		android.util.Log.d("leak-74-17", dataLeAk74);
		android.util.Log.d("leak-75-17", dataLeAk75);
		android.util.Log.d("leak-76-17", dataLeAk76);
		android.util.Log.d("leak-77-17", dataLeAk77);
		android.util.Log.d("leak-78-17", dataLeAk78);
		android.util.Log.d("leak-79-17", dataLeAk79);
		android.util.Log.d("leak-80-17", dataLeAk80);
		android.util.Log.d("leak-82-17", dataLeAk82);
		android.util.Log.d("leak-84-17", dataLeAk84);
		android.util.Log.d("leak-86-17", dataLeAk86);
		android.util.Log.d("leak-88-17", dataLeAk88);
		android.util.Log.d("leak-91-17", dataLeAk91);
		android.util.Log.d("leak-93-17", dataLeAk93);
		return futureTask;
    }

    public void runTask() {
        dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-18", dataLeAk52);
		android.util.Log.d("leak-53-18", dataLeAk53);
		android.util.Log.d("leak-54-18", dataLeAk54);
		android.util.Log.d("leak-55-18", dataLeAk55);
		android.util.Log.d("leak-56-18", dataLeAk56);
		android.util.Log.d("leak-58-18", dataLeAk58);
		android.util.Log.d("leak-59-18", dataLeAk59);
		android.util.Log.d("leak-60-18", dataLeAk60);
		android.util.Log.d("leak-61-18", dataLeAk61);
		android.util.Log.d("leak-62-18", dataLeAk62);
		android.util.Log.d("leak-63-18", dataLeAk63);
		android.util.Log.d("leak-64-18", dataLeAk64);
		android.util.Log.d("leak-65-18", dataLeAk65);
		android.util.Log.d("leak-66-18", dataLeAk66);
		android.util.Log.d("leak-67-18", dataLeAk67);
		android.util.Log.d("leak-68-18", dataLeAk68);
		android.util.Log.d("leak-69-18", dataLeAk69);
		android.util.Log.d("leak-70-18", dataLeAk70);
		android.util.Log.d("leak-71-18", dataLeAk71);
		android.util.Log.d("leak-72-18", dataLeAk72);
		android.util.Log.d("leak-73-18", dataLeAk73);
		android.util.Log.d("leak-74-18", dataLeAk74);
		android.util.Log.d("leak-75-18", dataLeAk75);
		android.util.Log.d("leak-76-18", dataLeAk76);
		android.util.Log.d("leak-77-18", dataLeAk77);
		android.util.Log.d("leak-78-18", dataLeAk78);
		android.util.Log.d("leak-79-18", dataLeAk79);
		android.util.Log.d("leak-80-18", dataLeAk80);
		android.util.Log.d("leak-82-18", dataLeAk82);
		android.util.Log.d("leak-84-18", dataLeAk84);
		android.util.Log.d("leak-86-18", dataLeAk86);
		android.util.Log.d("leak-88-18", dataLeAk88);
		android.util.Log.d("leak-91-18", dataLeAk91);
		android.util.Log.d("leak-93-18", dataLeAk93);
		Log.d(LOGTAG, "runTask()...");
        synchronized (taskList) {
            running = false;
            futureTask = null;
            if (!taskList.isEmpty()) {
                Runnable runnable = (Runnable) taskList.get(0);
                taskList.remove(0);
                running = true;
                futureTask = taskSubmitter.submit(runnable);
                if (futureTask == null) {
                    taskTracker.decrease();
                }
            }
        }
        taskTracker.decrease();
        Log.d(LOGTAG, "runTask()...done");
    }

    private String newRandomUUID() {
        dataLeAk72 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-19", dataLeAk52);
		android.util.Log.d("leak-53-19", dataLeAk53);
		android.util.Log.d("leak-54-19", dataLeAk54);
		android.util.Log.d("leak-55-19", dataLeAk55);
		android.util.Log.d("leak-56-19", dataLeAk56);
		android.util.Log.d("leak-58-19", dataLeAk58);
		android.util.Log.d("leak-59-19", dataLeAk59);
		android.util.Log.d("leak-60-19", dataLeAk60);
		android.util.Log.d("leak-61-19", dataLeAk61);
		android.util.Log.d("leak-62-19", dataLeAk62);
		android.util.Log.d("leak-63-19", dataLeAk63);
		android.util.Log.d("leak-64-19", dataLeAk64);
		android.util.Log.d("leak-65-19", dataLeAk65);
		android.util.Log.d("leak-66-19", dataLeAk66);
		android.util.Log.d("leak-67-19", dataLeAk67);
		android.util.Log.d("leak-68-19", dataLeAk68);
		android.util.Log.d("leak-69-19", dataLeAk69);
		android.util.Log.d("leak-70-19", dataLeAk70);
		android.util.Log.d("leak-71-19", dataLeAk71);
		android.util.Log.d("leak-72-19", dataLeAk72);
		android.util.Log.d("leak-73-19", dataLeAk73);
		android.util.Log.d("leak-74-19", dataLeAk74);
		android.util.Log.d("leak-75-19", dataLeAk75);
		android.util.Log.d("leak-76-19", dataLeAk76);
		android.util.Log.d("leak-77-19", dataLeAk77);
		android.util.Log.d("leak-78-19", dataLeAk78);
		android.util.Log.d("leak-79-19", dataLeAk79);
		android.util.Log.d("leak-80-19", dataLeAk80);
		android.util.Log.d("leak-82-19", dataLeAk82);
		android.util.Log.d("leak-84-19", dataLeAk84);
		android.util.Log.d("leak-86-19", dataLeAk86);
		android.util.Log.d("leak-88-19", dataLeAk88);
		android.util.Log.d("leak-91-19", dataLeAk91);
		android.util.Log.d("leak-93-19", dataLeAk93);
		String uuidRaw = UUID.randomUUID().toString();
        return uuidRaw.replaceAll("-", "");
    }

    private boolean isConnected() {
        dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-20", dataLeAk52);
		android.util.Log.d("leak-53-20", dataLeAk53);
		android.util.Log.d("leak-54-20", dataLeAk54);
		android.util.Log.d("leak-55-20", dataLeAk55);
		android.util.Log.d("leak-56-20", dataLeAk56);
		android.util.Log.d("leak-58-20", dataLeAk58);
		android.util.Log.d("leak-59-20", dataLeAk59);
		android.util.Log.d("leak-60-20", dataLeAk60);
		android.util.Log.d("leak-61-20", dataLeAk61);
		android.util.Log.d("leak-62-20", dataLeAk62);
		android.util.Log.d("leak-63-20", dataLeAk63);
		android.util.Log.d("leak-64-20", dataLeAk64);
		android.util.Log.d("leak-65-20", dataLeAk65);
		android.util.Log.d("leak-66-20", dataLeAk66);
		android.util.Log.d("leak-67-20", dataLeAk67);
		android.util.Log.d("leak-68-20", dataLeAk68);
		android.util.Log.d("leak-69-20", dataLeAk69);
		android.util.Log.d("leak-70-20", dataLeAk70);
		android.util.Log.d("leak-71-20", dataLeAk71);
		android.util.Log.d("leak-72-20", dataLeAk72);
		android.util.Log.d("leak-73-20", dataLeAk73);
		android.util.Log.d("leak-74-20", dataLeAk74);
		android.util.Log.d("leak-75-20", dataLeAk75);
		android.util.Log.d("leak-76-20", dataLeAk76);
		android.util.Log.d("leak-77-20", dataLeAk77);
		android.util.Log.d("leak-78-20", dataLeAk78);
		android.util.Log.d("leak-79-20", dataLeAk79);
		android.util.Log.d("leak-80-20", dataLeAk80);
		android.util.Log.d("leak-82-20", dataLeAk82);
		android.util.Log.d("leak-84-20", dataLeAk84);
		android.util.Log.d("leak-86-20", dataLeAk86);
		android.util.Log.d("leak-88-20", dataLeAk88);
		android.util.Log.d("leak-91-20", dataLeAk91);
		android.util.Log.d("leak-93-20", dataLeAk93);
		return connection != null && connection.isConnected();
    }

    private boolean isAuthenticated() {
        dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-21", dataLeAk52);
		android.util.Log.d("leak-53-21", dataLeAk53);
		android.util.Log.d("leak-54-21", dataLeAk54);
		android.util.Log.d("leak-55-21", dataLeAk55);
		android.util.Log.d("leak-56-21", dataLeAk56);
		android.util.Log.d("leak-58-21", dataLeAk58);
		android.util.Log.d("leak-59-21", dataLeAk59);
		android.util.Log.d("leak-60-21", dataLeAk60);
		android.util.Log.d("leak-61-21", dataLeAk61);
		android.util.Log.d("leak-62-21", dataLeAk62);
		android.util.Log.d("leak-63-21", dataLeAk63);
		android.util.Log.d("leak-64-21", dataLeAk64);
		android.util.Log.d("leak-65-21", dataLeAk65);
		android.util.Log.d("leak-66-21", dataLeAk66);
		android.util.Log.d("leak-67-21", dataLeAk67);
		android.util.Log.d("leak-68-21", dataLeAk68);
		android.util.Log.d("leak-69-21", dataLeAk69);
		android.util.Log.d("leak-70-21", dataLeAk70);
		android.util.Log.d("leak-71-21", dataLeAk71);
		android.util.Log.d("leak-72-21", dataLeAk72);
		android.util.Log.d("leak-73-21", dataLeAk73);
		android.util.Log.d("leak-74-21", dataLeAk74);
		android.util.Log.d("leak-75-21", dataLeAk75);
		android.util.Log.d("leak-76-21", dataLeAk76);
		android.util.Log.d("leak-77-21", dataLeAk77);
		android.util.Log.d("leak-78-21", dataLeAk78);
		android.util.Log.d("leak-79-21", dataLeAk79);
		android.util.Log.d("leak-80-21", dataLeAk80);
		android.util.Log.d("leak-82-21", dataLeAk82);
		android.util.Log.d("leak-84-21", dataLeAk84);
		android.util.Log.d("leak-86-21", dataLeAk86);
		android.util.Log.d("leak-88-21", dataLeAk88);
		android.util.Log.d("leak-91-21", dataLeAk91);
		android.util.Log.d("leak-93-21", dataLeAk93);
		return connection != null && connection.isConnected()
                && connection.isAuthenticated();
    }

    private boolean isRegistered() {
        dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-22", dataLeAk52);
		android.util.Log.d("leak-53-22", dataLeAk53);
		android.util.Log.d("leak-54-22", dataLeAk54);
		android.util.Log.d("leak-55-22", dataLeAk55);
		android.util.Log.d("leak-56-22", dataLeAk56);
		android.util.Log.d("leak-58-22", dataLeAk58);
		android.util.Log.d("leak-59-22", dataLeAk59);
		android.util.Log.d("leak-60-22", dataLeAk60);
		android.util.Log.d("leak-61-22", dataLeAk61);
		android.util.Log.d("leak-62-22", dataLeAk62);
		android.util.Log.d("leak-63-22", dataLeAk63);
		android.util.Log.d("leak-64-22", dataLeAk64);
		android.util.Log.d("leak-65-22", dataLeAk65);
		android.util.Log.d("leak-66-22", dataLeAk66);
		android.util.Log.d("leak-67-22", dataLeAk67);
		android.util.Log.d("leak-68-22", dataLeAk68);
		android.util.Log.d("leak-69-22", dataLeAk69);
		android.util.Log.d("leak-70-22", dataLeAk70);
		android.util.Log.d("leak-71-22", dataLeAk71);
		android.util.Log.d("leak-72-22", dataLeAk72);
		android.util.Log.d("leak-73-22", dataLeAk73);
		android.util.Log.d("leak-74-22", dataLeAk74);
		android.util.Log.d("leak-75-22", dataLeAk75);
		android.util.Log.d("leak-76-22", dataLeAk76);
		android.util.Log.d("leak-77-22", dataLeAk77);
		android.util.Log.d("leak-78-22", dataLeAk78);
		android.util.Log.d("leak-79-22", dataLeAk79);
		android.util.Log.d("leak-80-22", dataLeAk80);
		android.util.Log.d("leak-82-22", dataLeAk82);
		android.util.Log.d("leak-84-22", dataLeAk84);
		android.util.Log.d("leak-86-22", dataLeAk86);
		android.util.Log.d("leak-88-22", dataLeAk88);
		android.util.Log.d("leak-91-22", dataLeAk91);
		android.util.Log.d("leak-93-22", dataLeAk93);
		return sharedPrefs.contains(Constants.XMPP_REGISTERED);
    }

    private void submitConnectTask() {
        dataLeAk76 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-23", dataLeAk52);
		android.util.Log.d("leak-53-23", dataLeAk53);
		android.util.Log.d("leak-54-23", dataLeAk54);
		android.util.Log.d("leak-55-23", dataLeAk55);
		android.util.Log.d("leak-56-23", dataLeAk56);
		android.util.Log.d("leak-58-23", dataLeAk58);
		android.util.Log.d("leak-59-23", dataLeAk59);
		android.util.Log.d("leak-60-23", dataLeAk60);
		android.util.Log.d("leak-61-23", dataLeAk61);
		android.util.Log.d("leak-62-23", dataLeAk62);
		android.util.Log.d("leak-63-23", dataLeAk63);
		android.util.Log.d("leak-64-23", dataLeAk64);
		android.util.Log.d("leak-65-23", dataLeAk65);
		android.util.Log.d("leak-66-23", dataLeAk66);
		android.util.Log.d("leak-67-23", dataLeAk67);
		android.util.Log.d("leak-68-23", dataLeAk68);
		android.util.Log.d("leak-69-23", dataLeAk69);
		android.util.Log.d("leak-70-23", dataLeAk70);
		android.util.Log.d("leak-71-23", dataLeAk71);
		android.util.Log.d("leak-72-23", dataLeAk72);
		android.util.Log.d("leak-73-23", dataLeAk73);
		android.util.Log.d("leak-74-23", dataLeAk74);
		android.util.Log.d("leak-75-23", dataLeAk75);
		android.util.Log.d("leak-76-23", dataLeAk76);
		android.util.Log.d("leak-77-23", dataLeAk77);
		android.util.Log.d("leak-78-23", dataLeAk78);
		android.util.Log.d("leak-79-23", dataLeAk79);
		android.util.Log.d("leak-80-23", dataLeAk80);
		android.util.Log.d("leak-82-23", dataLeAk82);
		android.util.Log.d("leak-84-23", dataLeAk84);
		android.util.Log.d("leak-86-23", dataLeAk86);
		android.util.Log.d("leak-88-23", dataLeAk88);
		android.util.Log.d("leak-91-23", dataLeAk91);
		android.util.Log.d("leak-93-23", dataLeAk93);
		Log.d(LOGTAG, "submitConnectTask()...");
        addTask(new ConnectTask());
    }

    private void submitRegisterTask() {
        dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-24", dataLeAk52);
		android.util.Log.d("leak-53-24", dataLeAk53);
		android.util.Log.d("leak-54-24", dataLeAk54);
		android.util.Log.d("leak-55-24", dataLeAk55);
		android.util.Log.d("leak-56-24", dataLeAk56);
		android.util.Log.d("leak-58-24", dataLeAk58);
		android.util.Log.d("leak-59-24", dataLeAk59);
		android.util.Log.d("leak-60-24", dataLeAk60);
		android.util.Log.d("leak-61-24", dataLeAk61);
		android.util.Log.d("leak-62-24", dataLeAk62);
		android.util.Log.d("leak-63-24", dataLeAk63);
		android.util.Log.d("leak-64-24", dataLeAk64);
		android.util.Log.d("leak-65-24", dataLeAk65);
		android.util.Log.d("leak-66-24", dataLeAk66);
		android.util.Log.d("leak-67-24", dataLeAk67);
		android.util.Log.d("leak-68-24", dataLeAk68);
		android.util.Log.d("leak-69-24", dataLeAk69);
		android.util.Log.d("leak-70-24", dataLeAk70);
		android.util.Log.d("leak-71-24", dataLeAk71);
		android.util.Log.d("leak-72-24", dataLeAk72);
		android.util.Log.d("leak-73-24", dataLeAk73);
		android.util.Log.d("leak-74-24", dataLeAk74);
		android.util.Log.d("leak-75-24", dataLeAk75);
		android.util.Log.d("leak-76-24", dataLeAk76);
		android.util.Log.d("leak-77-24", dataLeAk77);
		android.util.Log.d("leak-78-24", dataLeAk78);
		android.util.Log.d("leak-79-24", dataLeAk79);
		android.util.Log.d("leak-80-24", dataLeAk80);
		android.util.Log.d("leak-82-24", dataLeAk82);
		android.util.Log.d("leak-84-24", dataLeAk84);
		android.util.Log.d("leak-86-24", dataLeAk86);
		android.util.Log.d("leak-88-24", dataLeAk88);
		android.util.Log.d("leak-91-24", dataLeAk91);
		android.util.Log.d("leak-93-24", dataLeAk93);
		Log.d(LOGTAG, "submitRegisterTask()...");
        submitConnectTask();
        addTask(new RegisterTask());
    }

    private void submitLoginTask() {
        dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-25", dataLeAk52);
		android.util.Log.d("leak-53-25", dataLeAk53);
		android.util.Log.d("leak-54-25", dataLeAk54);
		android.util.Log.d("leak-55-25", dataLeAk55);
		android.util.Log.d("leak-56-25", dataLeAk56);
		android.util.Log.d("leak-58-25", dataLeAk58);
		android.util.Log.d("leak-59-25", dataLeAk59);
		android.util.Log.d("leak-60-25", dataLeAk60);
		android.util.Log.d("leak-61-25", dataLeAk61);
		android.util.Log.d("leak-62-25", dataLeAk62);
		android.util.Log.d("leak-63-25", dataLeAk63);
		android.util.Log.d("leak-64-25", dataLeAk64);
		android.util.Log.d("leak-65-25", dataLeAk65);
		android.util.Log.d("leak-66-25", dataLeAk66);
		android.util.Log.d("leak-67-25", dataLeAk67);
		android.util.Log.d("leak-68-25", dataLeAk68);
		android.util.Log.d("leak-69-25", dataLeAk69);
		android.util.Log.d("leak-70-25", dataLeAk70);
		android.util.Log.d("leak-71-25", dataLeAk71);
		android.util.Log.d("leak-72-25", dataLeAk72);
		android.util.Log.d("leak-73-25", dataLeAk73);
		android.util.Log.d("leak-74-25", dataLeAk74);
		android.util.Log.d("leak-75-25", dataLeAk75);
		android.util.Log.d("leak-76-25", dataLeAk76);
		android.util.Log.d("leak-77-25", dataLeAk77);
		android.util.Log.d("leak-78-25", dataLeAk78);
		android.util.Log.d("leak-79-25", dataLeAk79);
		android.util.Log.d("leak-80-25", dataLeAk80);
		android.util.Log.d("leak-82-25", dataLeAk82);
		android.util.Log.d("leak-84-25", dataLeAk84);
		android.util.Log.d("leak-86-25", dataLeAk86);
		android.util.Log.d("leak-88-25", dataLeAk88);
		android.util.Log.d("leak-91-25", dataLeAk91);
		android.util.Log.d("leak-93-25", dataLeAk93);
		Log.d(LOGTAG, "submitLoginTask()...");
        submitRegisterTask();
        addTask(new LoginTask());
    }

    private void addTask(Runnable runnable) {
        dataLeAk79 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-26", dataLeAk52);
		android.util.Log.d("leak-53-26", dataLeAk53);
		android.util.Log.d("leak-54-26", dataLeAk54);
		android.util.Log.d("leak-55-26", dataLeAk55);
		android.util.Log.d("leak-56-26", dataLeAk56);
		android.util.Log.d("leak-58-26", dataLeAk58);
		android.util.Log.d("leak-59-26", dataLeAk59);
		android.util.Log.d("leak-60-26", dataLeAk60);
		android.util.Log.d("leak-61-26", dataLeAk61);
		android.util.Log.d("leak-62-26", dataLeAk62);
		android.util.Log.d("leak-63-26", dataLeAk63);
		android.util.Log.d("leak-64-26", dataLeAk64);
		android.util.Log.d("leak-65-26", dataLeAk65);
		android.util.Log.d("leak-66-26", dataLeAk66);
		android.util.Log.d("leak-67-26", dataLeAk67);
		android.util.Log.d("leak-68-26", dataLeAk68);
		android.util.Log.d("leak-69-26", dataLeAk69);
		android.util.Log.d("leak-70-26", dataLeAk70);
		android.util.Log.d("leak-71-26", dataLeAk71);
		android.util.Log.d("leak-72-26", dataLeAk72);
		android.util.Log.d("leak-73-26", dataLeAk73);
		android.util.Log.d("leak-74-26", dataLeAk74);
		android.util.Log.d("leak-75-26", dataLeAk75);
		android.util.Log.d("leak-76-26", dataLeAk76);
		android.util.Log.d("leak-77-26", dataLeAk77);
		android.util.Log.d("leak-78-26", dataLeAk78);
		android.util.Log.d("leak-79-26", dataLeAk79);
		android.util.Log.d("leak-80-26", dataLeAk80);
		android.util.Log.d("leak-82-26", dataLeAk82);
		android.util.Log.d("leak-84-26", dataLeAk84);
		android.util.Log.d("leak-86-26", dataLeAk86);
		android.util.Log.d("leak-88-26", dataLeAk88);
		android.util.Log.d("leak-91-26", dataLeAk91);
		android.util.Log.d("leak-93-26", dataLeAk93);
		Log.d(LOGTAG, "addTask(runnable)...");
        taskTracker.increase();
        synchronized (taskList) {
            if (taskList.isEmpty() && !running) {
                running = true;
                futureTask = taskSubmitter.submit(runnable);
                if (futureTask == null) {
                    taskTracker.decrease();
                }
            } else {
                taskList.add(runnable);
            }
        }
        Log.d(LOGTAG, "addTask(runnable)... done");
    }

    private void removeAccount() {
        dataLeAk80 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-27", dataLeAk52);
		android.util.Log.d("leak-53-27", dataLeAk53);
		android.util.Log.d("leak-54-27", dataLeAk54);
		android.util.Log.d("leak-55-27", dataLeAk55);
		android.util.Log.d("leak-56-27", dataLeAk56);
		android.util.Log.d("leak-58-27", dataLeAk58);
		android.util.Log.d("leak-59-27", dataLeAk59);
		android.util.Log.d("leak-60-27", dataLeAk60);
		android.util.Log.d("leak-61-27", dataLeAk61);
		android.util.Log.d("leak-62-27", dataLeAk62);
		android.util.Log.d("leak-63-27", dataLeAk63);
		android.util.Log.d("leak-64-27", dataLeAk64);
		android.util.Log.d("leak-65-27", dataLeAk65);
		android.util.Log.d("leak-66-27", dataLeAk66);
		android.util.Log.d("leak-67-27", dataLeAk67);
		android.util.Log.d("leak-68-27", dataLeAk68);
		android.util.Log.d("leak-69-27", dataLeAk69);
		android.util.Log.d("leak-70-27", dataLeAk70);
		android.util.Log.d("leak-71-27", dataLeAk71);
		android.util.Log.d("leak-72-27", dataLeAk72);
		android.util.Log.d("leak-73-27", dataLeAk73);
		android.util.Log.d("leak-74-27", dataLeAk74);
		android.util.Log.d("leak-75-27", dataLeAk75);
		android.util.Log.d("leak-76-27", dataLeAk76);
		android.util.Log.d("leak-77-27", dataLeAk77);
		android.util.Log.d("leak-78-27", dataLeAk78);
		android.util.Log.d("leak-79-27", dataLeAk79);
		android.util.Log.d("leak-80-27", dataLeAk80);
		android.util.Log.d("leak-82-27", dataLeAk82);
		android.util.Log.d("leak-84-27", dataLeAk84);
		android.util.Log.d("leak-86-27", dataLeAk86);
		android.util.Log.d("leak-88-27", dataLeAk88);
		android.util.Log.d("leak-91-27", dataLeAk91);
		android.util.Log.d("leak-93-27", dataLeAk93);
		Editor editor = sharedPrefs.edit();
        editor.remove(Constants.XMPP_REGISTERED);
        editor.remove(Constants.XMPP_LOGGEDIN);
        editor.apply();
    }

    /**
     * A runnable task to connect the server.
     */
    private class ConnectTask implements Runnable {

        String dataLeAk83 = "";

		String dataLeAk81 = "";

		final XmppManager xmppManager;

        private ConnectTask() {
            dataLeAk82 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk81 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-52-28", dataLeAk52);
			android.util.Log.d("leak-53-28", dataLeAk53);
			android.util.Log.d("leak-54-28", dataLeAk54);
			android.util.Log.d("leak-55-28", dataLeAk55);
			android.util.Log.d("leak-56-28", dataLeAk56);
			android.util.Log.d("leak-58-28", dataLeAk58);
			android.util.Log.d("leak-59-28", dataLeAk59);
			android.util.Log.d("leak-60-28", dataLeAk60);
			android.util.Log.d("leak-61-28", dataLeAk61);
			android.util.Log.d("leak-62-28", dataLeAk62);
			android.util.Log.d("leak-63-28", dataLeAk63);
			android.util.Log.d("leak-64-28", dataLeAk64);
			android.util.Log.d("leak-65-28", dataLeAk65);
			android.util.Log.d("leak-66-28", dataLeAk66);
			android.util.Log.d("leak-67-28", dataLeAk67);
			android.util.Log.d("leak-68-28", dataLeAk68);
			android.util.Log.d("leak-69-28", dataLeAk69);
			android.util.Log.d("leak-70-28", dataLeAk70);
			android.util.Log.d("leak-71-28", dataLeAk71);
			android.util.Log.d("leak-72-28", dataLeAk72);
			android.util.Log.d("leak-73-28", dataLeAk73);
			android.util.Log.d("leak-74-28", dataLeAk74);
			android.util.Log.d("leak-75-28", dataLeAk75);
			android.util.Log.d("leak-76-28", dataLeAk76);
			android.util.Log.d("leak-77-28", dataLeAk77);
			android.util.Log.d("leak-78-28", dataLeAk78);
			android.util.Log.d("leak-79-28", dataLeAk79);
			android.util.Log.d("leak-80-28", dataLeAk80);
			android.util.Log.d("leak-82-28", dataLeAk82);
			android.util.Log.d("leak-84-28", dataLeAk84);
			android.util.Log.d("leak-86-28", dataLeAk86);
			android.util.Log.d("leak-88-28", dataLeAk88);
			android.util.Log.d("leak-91-28", dataLeAk91);
			android.util.Log.d("leak-93-28", dataLeAk93);
			android.util.Log.d("leak-81-0", dataLeAk81);
			android.util.Log.d("leak-83-0", dataLeAk83);
			this.xmppManager = XmppManager.this;
        }

        public void run() {
            dataLeAk84 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk83 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-52-29", dataLeAk52);
			android.util.Log.d("leak-53-29", dataLeAk53);
			android.util.Log.d("leak-54-29", dataLeAk54);
			android.util.Log.d("leak-55-29", dataLeAk55);
			android.util.Log.d("leak-56-29", dataLeAk56);
			android.util.Log.d("leak-58-29", dataLeAk58);
			android.util.Log.d("leak-59-29", dataLeAk59);
			android.util.Log.d("leak-60-29", dataLeAk60);
			android.util.Log.d("leak-61-29", dataLeAk61);
			android.util.Log.d("leak-62-29", dataLeAk62);
			android.util.Log.d("leak-63-29", dataLeAk63);
			android.util.Log.d("leak-64-29", dataLeAk64);
			android.util.Log.d("leak-65-29", dataLeAk65);
			android.util.Log.d("leak-66-29", dataLeAk66);
			android.util.Log.d("leak-67-29", dataLeAk67);
			android.util.Log.d("leak-68-29", dataLeAk68);
			android.util.Log.d("leak-69-29", dataLeAk69);
			android.util.Log.d("leak-70-29", dataLeAk70);
			android.util.Log.d("leak-71-29", dataLeAk71);
			android.util.Log.d("leak-72-29", dataLeAk72);
			android.util.Log.d("leak-73-29", dataLeAk73);
			android.util.Log.d("leak-74-29", dataLeAk74);
			android.util.Log.d("leak-75-29", dataLeAk75);
			android.util.Log.d("leak-76-29", dataLeAk76);
			android.util.Log.d("leak-77-29", dataLeAk77);
			android.util.Log.d("leak-78-29", dataLeAk78);
			android.util.Log.d("leak-79-29", dataLeAk79);
			android.util.Log.d("leak-80-29", dataLeAk80);
			android.util.Log.d("leak-82-29", dataLeAk82);
			android.util.Log.d("leak-84-29", dataLeAk84);
			android.util.Log.d("leak-86-29", dataLeAk86);
			android.util.Log.d("leak-88-29", dataLeAk88);
			android.util.Log.d("leak-91-29", dataLeAk91);
			android.util.Log.d("leak-93-29", dataLeAk93);
			android.util.Log.d("leak-81-1", dataLeAk81);
			android.util.Log.d("leak-83-1", dataLeAk83);
			Log.i(LOGTAG, "ConnectTask.run()...");
            boolean connected = false;
            if (!xmppManager.isConnected()) {
                // Create the configuration for this new connection
                ConnectionConfiguration connConfig = new ConnectionConfiguration(
                        xmppHost, xmppPort);
                // connConfig.setSecurityMode(SecurityMode.disabled);
                connConfig.setSecurityMode(SecurityMode.required);
                connConfig.setSASLAuthenticationEnabled(false);
                connConfig.setCompressionEnabled(false);

                XMPPConnection connection = new XMPPConnection(connConfig);
                xmppManager.setConnection(connection);

                try {
                    // Connect to the server
                    connection.connect();
                    Log.i(LOGTAG, "XMPP connected successfully");

                    // packet provider
                    ProviderManager.getInstance().addIQProvider("notification",
                            "androidpn:iq:notification",
                            new NotificationIQProvider());
                    connected = true;

                } catch (XMPPException e) {
                    Log.e(LOGTAG, "XMPP connection failed", e);
                }

                if (connected) {
                    xmppManager.runTask();
                }

            } else {
                Log.i(LOGTAG, "XMPP connected already");
                xmppManager.runTask();
            }
        }
    }

    /**
     * A runnable task to register a new user onto the server.
     */
    private class RegisterTask implements Runnable {

        final String dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		String dataLeAk87 = "";

		String dataLeAk85 = "";

		final XmppManager xmppManager;

        private RegisterTask() {
            dataLeAk86 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk85 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-52-30", dataLeAk52);
			android.util.Log.d("leak-53-30", dataLeAk53);
			android.util.Log.d("leak-54-30", dataLeAk54);
			android.util.Log.d("leak-55-30", dataLeAk55);
			android.util.Log.d("leak-56-30", dataLeAk56);
			android.util.Log.d("leak-58-30", dataLeAk58);
			android.util.Log.d("leak-59-30", dataLeAk59);
			android.util.Log.d("leak-60-30", dataLeAk60);
			android.util.Log.d("leak-61-30", dataLeAk61);
			android.util.Log.d("leak-62-30", dataLeAk62);
			android.util.Log.d("leak-63-30", dataLeAk63);
			android.util.Log.d("leak-64-30", dataLeAk64);
			android.util.Log.d("leak-65-30", dataLeAk65);
			android.util.Log.d("leak-66-30", dataLeAk66);
			android.util.Log.d("leak-67-30", dataLeAk67);
			android.util.Log.d("leak-68-30", dataLeAk68);
			android.util.Log.d("leak-69-30", dataLeAk69);
			android.util.Log.d("leak-70-30", dataLeAk70);
			android.util.Log.d("leak-71-30", dataLeAk71);
			android.util.Log.d("leak-72-30", dataLeAk72);
			android.util.Log.d("leak-73-30", dataLeAk73);
			android.util.Log.d("leak-74-30", dataLeAk74);
			android.util.Log.d("leak-75-30", dataLeAk75);
			android.util.Log.d("leak-76-30", dataLeAk76);
			android.util.Log.d("leak-77-30", dataLeAk77);
			android.util.Log.d("leak-78-30", dataLeAk78);
			android.util.Log.d("leak-79-30", dataLeAk79);
			android.util.Log.d("leak-80-30", dataLeAk80);
			android.util.Log.d("leak-82-30", dataLeAk82);
			android.util.Log.d("leak-84-30", dataLeAk84);
			android.util.Log.d("leak-86-30", dataLeAk86);
			android.util.Log.d("leak-88-30", dataLeAk88);
			android.util.Log.d("leak-91-30", dataLeAk91);
			android.util.Log.d("leak-93-30", dataLeAk93);
			android.util.Log.d("leak-85-0", dataLeAk85);
			android.util.Log.d("leak-87-0", dataLeAk87);
			xmppManager = XmppManager.this;
        }

        public void run() {
            dataLeAk88 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk87 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-52-31", dataLeAk52);
			android.util.Log.d("leak-53-31", dataLeAk53);
			android.util.Log.d("leak-54-31", dataLeAk54);
			android.util.Log.d("leak-55-31", dataLeAk55);
			android.util.Log.d("leak-56-31", dataLeAk56);
			android.util.Log.d("leak-58-31", dataLeAk58);
			android.util.Log.d("leak-59-31", dataLeAk59);
			android.util.Log.d("leak-60-31", dataLeAk60);
			android.util.Log.d("leak-61-31", dataLeAk61);
			android.util.Log.d("leak-62-31", dataLeAk62);
			android.util.Log.d("leak-63-31", dataLeAk63);
			android.util.Log.d("leak-64-31", dataLeAk64);
			android.util.Log.d("leak-65-31", dataLeAk65);
			android.util.Log.d("leak-66-31", dataLeAk66);
			android.util.Log.d("leak-67-31", dataLeAk67);
			android.util.Log.d("leak-68-31", dataLeAk68);
			android.util.Log.d("leak-69-31", dataLeAk69);
			android.util.Log.d("leak-70-31", dataLeAk70);
			android.util.Log.d("leak-71-31", dataLeAk71);
			android.util.Log.d("leak-72-31", dataLeAk72);
			android.util.Log.d("leak-73-31", dataLeAk73);
			android.util.Log.d("leak-74-31", dataLeAk74);
			android.util.Log.d("leak-75-31", dataLeAk75);
			android.util.Log.d("leak-76-31", dataLeAk76);
			android.util.Log.d("leak-77-31", dataLeAk77);
			android.util.Log.d("leak-78-31", dataLeAk78);
			android.util.Log.d("leak-79-31", dataLeAk79);
			android.util.Log.d("leak-80-31", dataLeAk80);
			android.util.Log.d("leak-82-31", dataLeAk82);
			android.util.Log.d("leak-84-31", dataLeAk84);
			android.util.Log.d("leak-86-31", dataLeAk86);
			android.util.Log.d("leak-88-31", dataLeAk88);
			android.util.Log.d("leak-91-31", dataLeAk91);
			android.util.Log.d("leak-93-31", dataLeAk93);
			android.util.Log.d("leak-85-1", dataLeAk85);
			android.util.Log.d("leak-87-1", dataLeAk87);
			Log.i(LOGTAG, "RegisterTask.run()...");

            if (!xmppManager.isRegistered()) {
                newUsername = username;
                if (username.isEmpty()){ newUsername = newRandomUUID(); }
                newPassword = password;
                if (password.isEmpty()) { newPassword = newRandomUUID(); }

                Registration registration = new Registration();

                PacketFilter packetFilter = new AndFilter(new PacketIDFilter(
                        registration.getPacketID()), new PacketTypeFilter(
                        IQ.class));

                PacketListener packetListener = new PacketListener() {

                    String dataLeAk89 = "";

					public void processPacket(Packet packet) {
                        dataLeAk89 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-97-0", dataLeAk97);
						android.util.Log.d("leak-96-0", dataLeAk96);
						android.util.Log.d("leak-89-0", dataLeAk89);
						Log.d("RegisterTask.PcktLstnr",
                                "processPacket().....");
                        Log.d("RegisterTask.PcktLstnr", "packet="
                                + packet.toXML());

                        if (packet instanceof IQ) {
                            IQ response = (IQ) packet;
                            if (response.getType() == IQ.Type.ERROR) {
                                if (!response.getError().toString().contains(
                                        "409")) {
                                    Log.e(LOGTAG,
                                            "Unknown error while registering XMPP account! "
                                                    + response.getError()
                                                            .getCondition());
                                }
                            } else if (response.getType() == IQ.Type.RESULT) {
                                xmppManager.setUsername(newUsername);
                                xmppManager.setPassword(newPassword);
                                Log.d(LOGTAG, "username=" + newUsername);
                                Log.d(LOGTAG, "password=" + newPassword);

                                Editor editor = sharedPrefs.edit();
                                editor.putString(Constants.XMPP_REGISTERED, "true");
                                editor.remove(Constants.XMPP_USERNAME);
                                editor.remove(Constants.XMPP_PASSWORD);
                                editor.putString(Constants.XMPP_USERNAME,
                                        newUsername);
                                editor.putString(Constants.XMPP_PASSWORD,
                                        newPassword);
                                editor.apply();
                                Log
                                        .i(LOGTAG,
                                                "Account registered successfully");
                                xmppManager.runTask();
                            }
                        }
                    }
                };

                connection.addPacketListener(packetListener, packetFilter);

                registration.setType(IQ.Type.SET);
                registration.setTo(xmppHost);
                Map<String, String> attributes = new HashMap<String, String>();
                attributes.put("username", newUsername);
                attributes.put("password", newPassword);
                if (!email.isEmpty()) {
                    attributes.put("email", email);
                }
                if (!name.isEmpty()) {
                    attributes.put("name", name);
                }
                registration.setAttributes(attributes);
                //registration.setAttributes();

                //registration.addAttribute("username", newUsername);
                //registration.addAttribute("password", newPassword);
                connection.sendPacket(registration);

            } else {
                Log.i(LOGTAG, "Account registered already");
                xmppManager.runTask();
            }
        }
    }

    /**
     * A runnable task to log into the server.
     */
    private class LoginTask implements Runnable {

        String dataLeAk92 = "";

		String dataLeAk90 = "";

		final XmppManager xmppManager;

        private LoginTask() {
            dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk90 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-52-32", dataLeAk52);
			android.util.Log.d("leak-53-32", dataLeAk53);
			android.util.Log.d("leak-54-32", dataLeAk54);
			android.util.Log.d("leak-55-32", dataLeAk55);
			android.util.Log.d("leak-56-32", dataLeAk56);
			android.util.Log.d("leak-58-32", dataLeAk58);
			android.util.Log.d("leak-59-32", dataLeAk59);
			android.util.Log.d("leak-60-32", dataLeAk60);
			android.util.Log.d("leak-61-32", dataLeAk61);
			android.util.Log.d("leak-62-32", dataLeAk62);
			android.util.Log.d("leak-63-32", dataLeAk63);
			android.util.Log.d("leak-64-32", dataLeAk64);
			android.util.Log.d("leak-65-32", dataLeAk65);
			android.util.Log.d("leak-66-32", dataLeAk66);
			android.util.Log.d("leak-67-32", dataLeAk67);
			android.util.Log.d("leak-68-32", dataLeAk68);
			android.util.Log.d("leak-69-32", dataLeAk69);
			android.util.Log.d("leak-70-32", dataLeAk70);
			android.util.Log.d("leak-71-32", dataLeAk71);
			android.util.Log.d("leak-72-32", dataLeAk72);
			android.util.Log.d("leak-73-32", dataLeAk73);
			android.util.Log.d("leak-74-32", dataLeAk74);
			android.util.Log.d("leak-75-32", dataLeAk75);
			android.util.Log.d("leak-76-32", dataLeAk76);
			android.util.Log.d("leak-77-32", dataLeAk77);
			android.util.Log.d("leak-78-32", dataLeAk78);
			android.util.Log.d("leak-79-32", dataLeAk79);
			android.util.Log.d("leak-80-32", dataLeAk80);
			android.util.Log.d("leak-82-32", dataLeAk82);
			android.util.Log.d("leak-84-32", dataLeAk84);
			android.util.Log.d("leak-86-32", dataLeAk86);
			android.util.Log.d("leak-88-32", dataLeAk88);
			android.util.Log.d("leak-91-32", dataLeAk91);
			android.util.Log.d("leak-93-32", dataLeAk93);
			android.util.Log.d("leak-90-0", dataLeAk90);
			android.util.Log.d("leak-92-0", dataLeAk92);
			this.xmppManager = XmppManager.this;
        }

        public void run() {
            dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-52-33", dataLeAk52);
			android.util.Log.d("leak-53-33", dataLeAk53);
			android.util.Log.d("leak-54-33", dataLeAk54);
			android.util.Log.d("leak-55-33", dataLeAk55);
			android.util.Log.d("leak-56-33", dataLeAk56);
			android.util.Log.d("leak-58-33", dataLeAk58);
			android.util.Log.d("leak-59-33", dataLeAk59);
			android.util.Log.d("leak-60-33", dataLeAk60);
			android.util.Log.d("leak-61-33", dataLeAk61);
			android.util.Log.d("leak-62-33", dataLeAk62);
			android.util.Log.d("leak-63-33", dataLeAk63);
			android.util.Log.d("leak-64-33", dataLeAk64);
			android.util.Log.d("leak-65-33", dataLeAk65);
			android.util.Log.d("leak-66-33", dataLeAk66);
			android.util.Log.d("leak-67-33", dataLeAk67);
			android.util.Log.d("leak-68-33", dataLeAk68);
			android.util.Log.d("leak-69-33", dataLeAk69);
			android.util.Log.d("leak-70-33", dataLeAk70);
			android.util.Log.d("leak-71-33", dataLeAk71);
			android.util.Log.d("leak-72-33", dataLeAk72);
			android.util.Log.d("leak-73-33", dataLeAk73);
			android.util.Log.d("leak-74-33", dataLeAk74);
			android.util.Log.d("leak-75-33", dataLeAk75);
			android.util.Log.d("leak-76-33", dataLeAk76);
			android.util.Log.d("leak-77-33", dataLeAk77);
			android.util.Log.d("leak-78-33", dataLeAk78);
			android.util.Log.d("leak-79-33", dataLeAk79);
			android.util.Log.d("leak-80-33", dataLeAk80);
			android.util.Log.d("leak-82-33", dataLeAk82);
			android.util.Log.d("leak-84-33", dataLeAk84);
			android.util.Log.d("leak-86-33", dataLeAk86);
			android.util.Log.d("leak-88-33", dataLeAk88);
			android.util.Log.d("leak-91-33", dataLeAk91);
			android.util.Log.d("leak-93-33", dataLeAk93);
			android.util.Log.d("leak-90-1", dataLeAk90);
			android.util.Log.d("leak-92-1", dataLeAk92);
			Log.i(LOGTAG, "LoginTask.run()...");

            if (!xmppManager.isAuthenticated()) {
                Log.d(LOGTAG, "username=" + username);
                //Log.d(LOGTAG, "password=" + password);

                try {
                    xmppManager.getConnection().login(
                            xmppManager.getUsername(),
                            xmppManager.getPassword(), XMPP_RESOURCE_NAME);
                    Editor editor = sharedPrefs.edit();
                    editor.putString(Constants.XMPP_LOGGEDIN, "true");
                    editor.apply();
                    Log.d(LOGTAG, "Loggedn in successfully");

                    // connection listener
                    if (xmppManager.getConnectionListener() != null) {
                        xmppManager.getConnection().addConnectionListener(
                                xmppManager.getConnectionListener());
                    }

                    // packet filter
                    PacketFilter packetFilter = new PacketTypeFilter(
                            NotificationIQ.class);
                    // packet listener
                    PacketListener packetListener = xmppManager
                            .getNotificationPacketListener();
                    connection.addPacketListener(packetListener, packetFilter);

                    xmppManager.runTask();

                } catch (XMPPException e) {
                    Log.e(LOGTAG, "LoginTask.run()... xmpp error");
                    Log.e(LOGTAG, "Failed to login to xmpp server. Caused by: "
                            + e.getMessage());
                    String INVALID_CREDENTIALS_ERROR_CODE = "401";
                    String errorMessage = e.getMessage();
                    if (errorMessage != null
                            && errorMessage
                                    .contains(INVALID_CREDENTIALS_ERROR_CODE)) {
                        xmppManager.reregisterAccount();
                        return;
                    }
                    xmppManager.startReconnectionThread();

                } catch (Exception e) {
                    Log.e(LOGTAG, "LoginTask.run()... other error");
                    Log.e(LOGTAG, "Failed to login to xmpp server. Caused by: "
                            + e.getMessage());
                    xmppManager.startReconnectionThread();
                }

            } else {
                if (!(sharedPrefs.contains(Constants.XMPP_LOGGEDIN))) {
                    Editor editor = sharedPrefs.edit();
                    editor.putString(Constants.XMPP_LOGGEDIN, "true");
                    editor.apply();
                }
                Log.i(LOGTAG, "Logged in already");
                xmppManager.runTask();
            }

        }
    }

}
