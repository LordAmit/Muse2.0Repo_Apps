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

    String dataLeAk176 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk176 = android.util.Log.d("leak-176", dataLeAk176);

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
        String dataLeAk177 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk177 = android.util.Log.d("leak-177", dataLeAk177);
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
        String dataLeAk178 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk178 = android.util.Log.d("leak-178", dataLeAk178);
		return context;
    }

    public void connect() {
        String dataLeAk179 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk179 = android.util.Log.d("leak-179", dataLeAk179);
		Log.d(LOGTAG, "connect()...");
        submitLoginTask();
    }

    public void disconnect() {
        String dataLeAk180 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk180 = android.util.Log.d("leak-180", dataLeAk180);
		Log.d(LOGTAG, "disconnect()...");
        if (sharedPrefs.contains(Constants.XMPP_LOGGEDIN)) {
            String dataLeAk181 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk181 = android.util.Log.d("leak-181", dataLeAk181);
			Editor editor = sharedPrefs.edit();
            editor.remove(Constants.XMPP_LOGGEDIN);
            editor.remove(Constants.XMPP_REGISTERED);
            editor.apply();
        }
        terminatePersistentConnection();
    }

    public void terminatePersistentConnection() {
        String dataLeAk182 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk182 = android.util.Log.d("leak-182", dataLeAk182);
		Log.d(LOGTAG, "terminatePersistentConnection()...");
        Runnable runnable = new Runnable() {

            String dataLeAk183 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk183 = android.util.Log.d("leak-183", dataLeAk183);

			final XmppManager xmppManager = XmppManager.this;

            public void run() {
                String dataLeAk184 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk184 = android.util.Log.d("leak-184", dataLeAk184);
				if (xmppManager.isConnected()) {
                    String dataLeAk185 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk185 = android.util.Log.d("leak-185", dataLeAk185);
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
        String dataLeAk186 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk186 = android.util.Log.d("leak-186", dataLeAk186);
		return connection;
    }

    public void setConnection(XMPPConnection connection) {
        String dataLeAk187 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk187 = android.util.Log.d("leak-187", dataLeAk187);
		this.connection = connection;
    }

    public String getUsername() {
        String dataLeAk188 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk188 = android.util.Log.d("leak-188", dataLeAk188);
		return username;
    }

    public void setUsername(String username) {
        String dataLeAk189 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk189 = android.util.Log.d("leak-189", dataLeAk189);
		this.username = username;
    }

    public String getPassword() {
        String dataLeAk190 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk190 = android.util.Log.d("leak-190", dataLeAk190);
		return password;
    }

    public void setPassword(String password) {
        String dataLeAk191 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk191 = android.util.Log.d("leak-191", dataLeAk191);
		this.password = password;
    }

    public ConnectionListener getConnectionListener() {
        String dataLeAk192 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk192 = android.util.Log.d("leak-192", dataLeAk192);
		return connectionListener;
    }

    public PacketListener getNotificationPacketListener() {
        String dataLeAk193 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk193 = android.util.Log.d("leak-193", dataLeAk193);
		return notificationPacketListener;
    }

    public void startReconnectionThread() {
        String dataLeAk194 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk194 = android.util.Log.d("leak-194", dataLeAk194);
		synchronized (reconnection) {
            String dataLeAk195 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk195 = android.util.Log.d("leak-195", dataLeAk195);
			if (!reconnection.isAlive()) {
                String dataLeAk196 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk196 = android.util.Log.d("leak-196", dataLeAk196);
				reconnection.setName("Xmpp Reconnection Thread");
                reconnection.start();
            }
        }
    }

    public Handler getHandler() {
        String dataLeAk197 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk197 = android.util.Log.d("leak-197", dataLeAk197);
		return handler;
    }

    public void reregisterAccount() {
        String dataLeAk198 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk198 = android.util.Log.d("leak-198", dataLeAk198);
		removeAccount();
        submitLoginTask();
        runTask();
    }

    public List<Runnable> getTaskList() {
        String dataLeAk199 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk199 = android.util.Log.d("leak-199", dataLeAk199);
		return taskList;
    }

    public Future<?> getFutureTask() {
        String dataLeAk200 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk200 = android.util.Log.d("leak-200", dataLeAk200);
		return futureTask;
    }

    public void runTask() {
        String dataLeAk201 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk201 = android.util.Log.d("leak-201", dataLeAk201);
		Log.d(LOGTAG, "runTask()...");
        synchronized (taskList) {
            String dataLeAk202 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk202 = android.util.Log.d("leak-202", dataLeAk202);
			running = false;
            futureTask = null;
            if (!taskList.isEmpty()) {
                String dataLeAk203 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk203 = android.util.Log.d("leak-203", dataLeAk203);
				Runnable runnable = (Runnable) taskList.get(0);
                taskList.remove(0);
                running = true;
                futureTask = taskSubmitter.submit(runnable);
                if (futureTask == null) {
                    String dataLeAk204 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk204 = android.util.Log.d("leak-204", dataLeAk204);
					taskTracker.decrease();
                }
            }
        }
        taskTracker.decrease();
        Log.d(LOGTAG, "runTask()...done");
    }

    private String newRandomUUID() {
        String dataLeAk205 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk205 = android.util.Log.d("leak-205", dataLeAk205);
		String uuidRaw = UUID.randomUUID().toString();
        return uuidRaw.replaceAll("-", "");
    }

    private boolean isConnected() {
        String dataLeAk206 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk206 = android.util.Log.d("leak-206", dataLeAk206);
		return connection != null && connection.isConnected();
    }

    private boolean isAuthenticated() {
        String dataLeAk207 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk207 = android.util.Log.d("leak-207", dataLeAk207);
		return connection != null && connection.isConnected()
                && connection.isAuthenticated();
    }

    private boolean isRegistered() {
        String dataLeAk208 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk208 = android.util.Log.d("leak-208", dataLeAk208);
		return sharedPrefs.contains(Constants.XMPP_REGISTERED);
    }

    private void submitConnectTask() {
        String dataLeAk209 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk209 = android.util.Log.d("leak-209", dataLeAk209);
		Log.d(LOGTAG, "submitConnectTask()...");
        addTask(new ConnectTask());
    }

    private void submitRegisterTask() {
        String dataLeAk210 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk210 = android.util.Log.d("leak-210", dataLeAk210);
		Log.d(LOGTAG, "submitRegisterTask()...");
        submitConnectTask();
        addTask(new RegisterTask());
    }

    private void submitLoginTask() {
        String dataLeAk211 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk211 = android.util.Log.d("leak-211", dataLeAk211);
		Log.d(LOGTAG, "submitLoginTask()...");
        submitRegisterTask();
        addTask(new LoginTask());
    }

    private void addTask(Runnable runnable) {
        String dataLeAk212 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk212 = android.util.Log.d("leak-212", dataLeAk212);
		Log.d(LOGTAG, "addTask(runnable)...");
        taskTracker.increase();
        synchronized (taskList) {
            String dataLeAk213 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk213 = android.util.Log.d("leak-213", dataLeAk213);
			if (taskList.isEmpty() && !running) {
                String dataLeAk214 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk214 = android.util.Log.d("leak-214", dataLeAk214);
				running = true;
                futureTask = taskSubmitter.submit(runnable);
                if (futureTask == null) {
                    String dataLeAk215 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk215 = android.util.Log.d("leak-215", dataLeAk215);
					taskTracker.decrease();
                }
            } else {
                String dataLeAk216 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk216 = android.util.Log.d("leak-216", dataLeAk216);
				taskList.add(runnable);
            }
        }
        Log.d(LOGTAG, "addTask(runnable)... done");
    }

    private void removeAccount() {
        String dataLeAk217 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk217 = android.util.Log.d("leak-217", dataLeAk217);
		Editor editor = sharedPrefs.edit();
        editor.remove(Constants.XMPP_REGISTERED);
        editor.remove(Constants.XMPP_LOGGEDIN);
        editor.apply();
    }

    /**
     * A runnable task to connect the server.
     */
    private class ConnectTask implements Runnable {

        String dataLeAk218 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk218 = android.util.Log.d("leak-218", dataLeAk218);

		final XmppManager xmppManager;

        private ConnectTask() {
            String dataLeAk219 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk219 = android.util.Log.d("leak-219", dataLeAk219);
			this.xmppManager = XmppManager.this;
        }

        public void run() {
            String dataLeAk220 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk220 = android.util.Log.d("leak-220", dataLeAk220);
			Log.i(LOGTAG, "ConnectTask.run()...");
            boolean connected = false;
            if (!xmppManager.isConnected()) {
                String dataLeAk221 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk221 = android.util.Log.d("leak-221", dataLeAk221);
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
                    String dataLeAk222 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk222 = android.util.Log.d("leak-222", dataLeAk222);
					// Connect to the server
                    connection.connect();
                    Log.i(LOGTAG, "XMPP connected successfully");

                    // packet provider
                    ProviderManager.getInstance().addIQProvider("notification",
                            "androidpn:iq:notification",
                            new NotificationIQProvider());
                    connected = true;

                } catch (XMPPException e) {
                    String dataLeAk223 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk223 = android.util.Log.d("leak-223", dataLeAk223);
					Log.e(LOGTAG, "XMPP connection failed", e);
                }

                if (connected) {
                    String dataLeAk224 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk224 = android.util.Log.d("leak-224", dataLeAk224);
					xmppManager.runTask();
                }

            } else {
                String dataLeAk225 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk225 = android.util.Log.d("leak-225", dataLeAk225);
				Log.i(LOGTAG, "XMPP connected already");
                xmppManager.runTask();
            }
        }
    }

    /**
     * A runnable task to register a new user onto the server.
     */
    private class RegisterTask implements Runnable {

        String dataLeAk226 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk226 = android.util.Log.d("leak-226", dataLeAk226);

		final XmppManager xmppManager;

        private RegisterTask() {
            String dataLeAk227 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk227 = android.util.Log.d("leak-227", dataLeAk227);
			xmppManager = XmppManager.this;
        }

        public void run() {
            String dataLeAk228 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk228 = android.util.Log.d("leak-228", dataLeAk228);
			Log.i(LOGTAG, "RegisterTask.run()...");

            if (!xmppManager.isRegistered()) {
                String dataLeAk229 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk229 = android.util.Log.d("leak-229", dataLeAk229);
				newUsername = username;
                if (username.isEmpty()){ String dataLeAk230 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk230 = android.util.Log.d("leak-230", dataLeAk230);
				newUsername = newRandomUUID(); }
                newPassword = password;
                if (password.isEmpty()) { String dataLeAk231 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk231 = android.util.Log.d("leak-231", dataLeAk231);
				newPassword = newRandomUUID(); }

                Registration registration = new Registration();

                PacketFilter packetFilter = new AndFilter(new PacketIDFilter(
                        registration.getPacketID()), new PacketTypeFilter(
                        IQ.class));

                PacketListener packetListener = new PacketListener() {

                    String dataLeAk232 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk232 = android.util.Log.d("leak-232", dataLeAk232);

					public void processPacket(Packet packet) {
                        String dataLeAk233 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk233 = android.util.Log.d("leak-233", dataLeAk233);
						Log.d("RegisterTask.PcktLstnr",
                                "processPacket().....");
                        Log.d("RegisterTask.PcktLstnr", "packet="
                                + packet.toXML());

                        if (packet instanceof IQ) {
                            String dataLeAk234 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk234 = android.util.Log.d("leak-234", dataLeAk234);
							IQ response = (IQ) packet;
                            if (response.getType() == IQ.Type.ERROR) {
                                String dataLeAk235 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk235 = android.util.Log.d("leak-235", dataLeAk235);
								if (!response.getError().toString().contains(
                                        "409")) {
                                    String dataLeAk236 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											Object throwawayLeAk236 = android.util.Log.d("leak-236", dataLeAk236);
									Log.e(LOGTAG,
                                            "Unknown error while registering XMPP account! "
                                                    + response.getError()
                                                            .getCondition());
                                }
                            } else if (response.getType() == IQ.Type.RESULT) {
                                String dataLeAk237 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk237 = android.util.Log.d("leak-237", dataLeAk237);
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
                    String dataLeAk238 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk238 = android.util.Log.d("leak-238", dataLeAk238);
					attributes.put("email", email);
                }
                if (!name.isEmpty()) {
                    String dataLeAk239 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk239 = android.util.Log.d("leak-239", dataLeAk239);
					attributes.put("name", name);
                }
                registration.setAttributes(attributes);
                //registration.setAttributes();

                //registration.addAttribute("username", newUsername);
                //registration.addAttribute("password", newPassword);
                connection.sendPacket(registration);

            } else {
                String dataLeAk240 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk240 = android.util.Log.d("leak-240", dataLeAk240);
				Log.i(LOGTAG, "Account registered already");
                xmppManager.runTask();
            }
        }
    }

    /**
     * A runnable task to log into the server.
     */
    private class LoginTask implements Runnable {

        String dataLeAk241 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk241 = android.util.Log.d("leak-241", dataLeAk241);

		final XmppManager xmppManager;

        private LoginTask() {
            String dataLeAk242 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk242 = android.util.Log.d("leak-242", dataLeAk242);
			this.xmppManager = XmppManager.this;
        }

        public void run() {
            String dataLeAk243 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk243 = android.util.Log.d("leak-243", dataLeAk243);
			Log.i(LOGTAG, "LoginTask.run()...");

            if (!xmppManager.isAuthenticated()) {
                String dataLeAk244 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk244 = android.util.Log.d("leak-244", dataLeAk244);
				Log.d(LOGTAG, "username=" + username);
                //Log.d(LOGTAG, "password=" + password);

                try {
                    String dataLeAk245 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk245 = android.util.Log.d("leak-245", dataLeAk245);
					xmppManager.getConnection().login(
                            xmppManager.getUsername(),
                            xmppManager.getPassword(), XMPP_RESOURCE_NAME);
                    Editor editor = sharedPrefs.edit();
                    editor.putString(Constants.XMPP_LOGGEDIN, "true");
                    editor.apply();
                    Log.d(LOGTAG, "Loggedn in successfully");

                    // connection listener
                    if (xmppManager.getConnectionListener() != null) {
                        String dataLeAk246 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk246 = android.util.Log.d("leak-246", dataLeAk246);
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
                    String dataLeAk247 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk247 = android.util.Log.d("leak-247", dataLeAk247);
					Log.e(LOGTAG, "LoginTask.run()... xmpp error");
                    Log.e(LOGTAG, "Failed to login to xmpp server. Caused by: "
                            + e.getMessage());
                    String INVALID_CREDENTIALS_ERROR_CODE = "401";
                    String errorMessage = e.getMessage();
                    if (errorMessage != null
                            && errorMessage
                                    .contains(INVALID_CREDENTIALS_ERROR_CODE)) {
                        String dataLeAk248 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk248 = android.util.Log.d("leak-248", dataLeAk248);
						xmppManager.reregisterAccount();
                        return;
                    }
                    xmppManager.startReconnectionThread();

                } catch (Exception e) {
                    String dataLeAk249 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk249 = android.util.Log.d("leak-249", dataLeAk249);
					Log.e(LOGTAG, "LoginTask.run()... other error");
                    Log.e(LOGTAG, "Failed to login to xmpp server. Caused by: "
                            + e.getMessage());
                    xmppManager.startReconnectionThread();
                }

            } else {
                String dataLeAk250 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk250 = android.util.Log.d("leak-250", dataLeAk250);
				if (!(sharedPrefs.contains(Constants.XMPP_LOGGEDIN))) {
                    String dataLeAk251 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk251 = android.util.Log.d("leak-251", dataLeAk251);
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
