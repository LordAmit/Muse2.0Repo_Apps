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
        String dataLeAk157 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP157 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP157.put("test", new java.util.HashMap<String, String>());
		leakMaP157.get("test").put("test", dataLeAk157);
		String dataLeAkPath157 = leakMaP157.get("test").get("test");
		android.util.Log.d("leak-157", dataLeAkPath157);
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
        String dataLeAk158 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer158 = new StringBuffer();for (char chAr158 : dataLeAk158.toCharArray()) {leakBuFFer158.append(chAr158);}String dataLeAkPath158 = leakBuFFer158.toString();
		android.util.Log.d("leak-158", dataLeAkPath158);
		return context;
    }

    public void connect() {
        String dataLeAk159 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath159;try {throw new Exception(dataLeAk159);} catch (Exception leakErRor159) {dataLeAkPath159 = leakErRor159.getMessage();}
		android.util.Log.d("leak-159", dataLeAkPath159);
		Log.d(LOGTAG, "connect()...");
        submitLoginTask();
    }

    public void disconnect() {
        String dataLeAk160 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay160 = new String[] {"n/a", dataLeAk160};
		String dataLeAkPath160 = leakArRay160[leakArRay160.length - 1];
		android.util.Log.d("leak-160", dataLeAkPath160);
		Log.d(LOGTAG, "disconnect()...");
        if (sharedPrefs.contains(Constants.XMPP_LOGGEDIN)) {
            String dataLeAk161 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP161 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP161.put("test", new java.util.HashMap<String, String>());
			leakMaP161.get("test").put("test", dataLeAk161);
			String dataLeAkPath161 = leakMaP161.get("test").get("test");
			android.util.Log.d("leak-161", dataLeAkPath161);
			Editor editor = sharedPrefs.edit();
            editor.remove(Constants.XMPP_LOGGEDIN);
            editor.remove(Constants.XMPP_REGISTERED);
            editor.apply();
        }
        terminatePersistentConnection();
    }

    public void terminatePersistentConnection() {
        String dataLeAk162 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer162 = new StringBuffer();for (char chAr162 : dataLeAk162.toCharArray()) {leakBuFFer162.append(chAr162);}String dataLeAkPath162 = leakBuFFer162.toString();
		android.util.Log.d("leak-162", dataLeAkPath162);
		Log.d(LOGTAG, "terminatePersistentConnection()...");
        Runnable runnable = new Runnable() {

            final XmppManager xmppManager = XmppManager.this;

            public void run() {
                String dataLeAk163 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath163;try {throw new Exception(dataLeAk163);} catch (Exception leakErRor163) {dataLeAkPath163 = leakErRor163.getMessage();}
				android.util.Log.d("leak-163", dataLeAkPath163);
				if (xmppManager.isConnected()) {
                    String dataLeAk164 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay164 = new String[] {"n/a", dataLeAk164};
					String dataLeAkPath164 = leakArRay164[leakArRay164.length - 1];
					android.util.Log.d("leak-164", dataLeAkPath164);
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
        String dataLeAk165 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP165 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP165.put("test", new java.util.HashMap<String, String>());
		leakMaP165.get("test").put("test", dataLeAk165);
		String dataLeAkPath165 = leakMaP165.get("test").get("test");
		android.util.Log.d("leak-165", dataLeAkPath165);
		return connection;
    }

    public void setConnection(XMPPConnection connection) {
        String dataLeAk166 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer166 = new StringBuffer();for (char chAr166 : dataLeAk166.toCharArray()) {leakBuFFer166.append(chAr166);}String dataLeAkPath166 = leakBuFFer166.toString();
		android.util.Log.d("leak-166", dataLeAkPath166);
		this.connection = connection;
    }

    public String getUsername() {
        String dataLeAk167 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath167;try {throw new Exception(dataLeAk167);} catch (Exception leakErRor167) {dataLeAkPath167 = leakErRor167.getMessage();}
		android.util.Log.d("leak-167", dataLeAkPath167);
		return username;
    }

    public void setUsername(String username) {
        String dataLeAk168 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay168 = new String[] {"n/a", dataLeAk168};
		String dataLeAkPath168 = leakArRay168[leakArRay168.length - 1];
		android.util.Log.d("leak-168", dataLeAkPath168);
		this.username = username;
    }

    public String getPassword() {
        String dataLeAk169 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP169 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP169.put("test", new java.util.HashMap<String, String>());
		leakMaP169.get("test").put("test", dataLeAk169);
		String dataLeAkPath169 = leakMaP169.get("test").get("test");
		android.util.Log.d("leak-169", dataLeAkPath169);
		return password;
    }

    public void setPassword(String password) {
        String dataLeAk170 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer170 = new StringBuffer();for (char chAr170 : dataLeAk170.toCharArray()) {leakBuFFer170.append(chAr170);}String dataLeAkPath170 = leakBuFFer170.toString();
		android.util.Log.d("leak-170", dataLeAkPath170);
		this.password = password;
    }

    public ConnectionListener getConnectionListener() {
        String dataLeAk171 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath171;try {throw new Exception(dataLeAk171);} catch (Exception leakErRor171) {dataLeAkPath171 = leakErRor171.getMessage();}
		android.util.Log.d("leak-171", dataLeAkPath171);
		return connectionListener;
    }

    public PacketListener getNotificationPacketListener() {
        String dataLeAk172 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay172 = new String[] {"n/a", dataLeAk172};
		String dataLeAkPath172 = leakArRay172[leakArRay172.length - 1];
		android.util.Log.d("leak-172", dataLeAkPath172);
		return notificationPacketListener;
    }

    public void startReconnectionThread() {
        String dataLeAk173 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP173 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP173.put("test", new java.util.HashMap<String, String>());
		leakMaP173.get("test").put("test", dataLeAk173);
		String dataLeAkPath173 = leakMaP173.get("test").get("test");
		android.util.Log.d("leak-173", dataLeAkPath173);
		synchronized (reconnection) {
            String dataLeAk174 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer174 = new StringBuffer();for (char chAr174 : dataLeAk174.toCharArray()) {leakBuFFer174.append(chAr174);}String dataLeAkPath174 = leakBuFFer174.toString();
			android.util.Log.d("leak-174", dataLeAkPath174);
			if (!reconnection.isAlive()) {
                String dataLeAk175 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath175;try {throw new Exception(dataLeAk175);} catch (Exception leakErRor175) {dataLeAkPath175 = leakErRor175.getMessage();}
				android.util.Log.d("leak-175", dataLeAkPath175);
				reconnection.setName("Xmpp Reconnection Thread");
                reconnection.start();
            }
        }
    }

    public Handler getHandler() {
        String dataLeAk176 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay176 = new String[] {"n/a", dataLeAk176};
		String dataLeAkPath176 = leakArRay176[leakArRay176.length - 1];
		android.util.Log.d("leak-176", dataLeAkPath176);
		return handler;
    }

    public void reregisterAccount() {
        String dataLeAk177 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP177 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP177.put("test", new java.util.HashMap<String, String>());
		leakMaP177.get("test").put("test", dataLeAk177);
		String dataLeAkPath177 = leakMaP177.get("test").get("test");
		android.util.Log.d("leak-177", dataLeAkPath177);
		removeAccount();
        submitLoginTask();
        runTask();
    }

    public List<Runnable> getTaskList() {
        String dataLeAk178 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer178 = new StringBuffer();for (char chAr178 : dataLeAk178.toCharArray()) {leakBuFFer178.append(chAr178);}String dataLeAkPath178 = leakBuFFer178.toString();
		android.util.Log.d("leak-178", dataLeAkPath178);
		return taskList;
    }

    public Future<?> getFutureTask() {
        String dataLeAk179 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath179;try {throw new Exception(dataLeAk179);} catch (Exception leakErRor179) {dataLeAkPath179 = leakErRor179.getMessage();}
		android.util.Log.d("leak-179", dataLeAkPath179);
		return futureTask;
    }

    public void runTask() {
        String dataLeAk180 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay180 = new String[] {"n/a", dataLeAk180};
		String dataLeAkPath180 = leakArRay180[leakArRay180.length - 1];
		android.util.Log.d("leak-180", dataLeAkPath180);
		Log.d(LOGTAG, "runTask()...");
        synchronized (taskList) {
            String dataLeAk181 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP181 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP181.put("test", new java.util.HashMap<String, String>());
			leakMaP181.get("test").put("test", dataLeAk181);
			String dataLeAkPath181 = leakMaP181.get("test").get("test");
			android.util.Log.d("leak-181", dataLeAkPath181);
			running = false;
            futureTask = null;
            if (!taskList.isEmpty()) {
                String dataLeAk182 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer182 = new StringBuffer();for (char chAr182 : dataLeAk182.toCharArray()) {leakBuFFer182.append(chAr182);}String dataLeAkPath182 = leakBuFFer182.toString();
				android.util.Log.d("leak-182", dataLeAkPath182);
				Runnable runnable = (Runnable) taskList.get(0);
                taskList.remove(0);
                running = true;
                futureTask = taskSubmitter.submit(runnable);
                if (futureTask == null) {
                    String dataLeAk183 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath183;try {throw new Exception(dataLeAk183);} catch (Exception leakErRor183) {dataLeAkPath183 = leakErRor183.getMessage();}
					android.util.Log.d("leak-183", dataLeAkPath183);
					taskTracker.decrease();
                }
            }
        }
        taskTracker.decrease();
        Log.d(LOGTAG, "runTask()...done");
    }

    private String newRandomUUID() {
        String dataLeAk184 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay184 = new String[] {"n/a", dataLeAk184};
		String dataLeAkPath184 = leakArRay184[leakArRay184.length - 1];
		android.util.Log.d("leak-184", dataLeAkPath184);
		String uuidRaw = UUID.randomUUID().toString();
        return uuidRaw.replaceAll("-", "");
    }

    private boolean isConnected() {
        String dataLeAk185 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP185 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP185.put("test", new java.util.HashMap<String, String>());
		leakMaP185.get("test").put("test", dataLeAk185);
		String dataLeAkPath185 = leakMaP185.get("test").get("test");
		android.util.Log.d("leak-185", dataLeAkPath185);
		return connection != null && connection.isConnected();
    }

    private boolean isAuthenticated() {
        String dataLeAk186 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer186 = new StringBuffer();for (char chAr186 : dataLeAk186.toCharArray()) {leakBuFFer186.append(chAr186);}String dataLeAkPath186 = leakBuFFer186.toString();
		android.util.Log.d("leak-186", dataLeAkPath186);
		return connection != null && connection.isConnected()
                && connection.isAuthenticated();
    }

    private boolean isRegistered() {
        String dataLeAk187 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath187;try {throw new Exception(dataLeAk187);} catch (Exception leakErRor187) {dataLeAkPath187 = leakErRor187.getMessage();}
		android.util.Log.d("leak-187", dataLeAkPath187);
		return sharedPrefs.contains(Constants.XMPP_REGISTERED);
    }

    private void submitConnectTask() {
        String dataLeAk188 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay188 = new String[] {"n/a", dataLeAk188};
		String dataLeAkPath188 = leakArRay188[leakArRay188.length - 1];
		android.util.Log.d("leak-188", dataLeAkPath188);
		Log.d(LOGTAG, "submitConnectTask()...");
        addTask(new ConnectTask());
    }

    private void submitRegisterTask() {
        String dataLeAk189 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP189 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP189.put("test", new java.util.HashMap<String, String>());
		leakMaP189.get("test").put("test", dataLeAk189);
		String dataLeAkPath189 = leakMaP189.get("test").get("test");
		android.util.Log.d("leak-189", dataLeAkPath189);
		Log.d(LOGTAG, "submitRegisterTask()...");
        submitConnectTask();
        addTask(new RegisterTask());
    }

    private void submitLoginTask() {
        String dataLeAk190 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer190 = new StringBuffer();for (char chAr190 : dataLeAk190.toCharArray()) {leakBuFFer190.append(chAr190);}String dataLeAkPath190 = leakBuFFer190.toString();
		android.util.Log.d("leak-190", dataLeAkPath190);
		Log.d(LOGTAG, "submitLoginTask()...");
        submitRegisterTask();
        addTask(new LoginTask());
    }

    private void addTask(Runnable runnable) {
        String dataLeAk191 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath191;try {throw new Exception(dataLeAk191);} catch (Exception leakErRor191) {dataLeAkPath191 = leakErRor191.getMessage();}
		android.util.Log.d("leak-191", dataLeAkPath191);
		Log.d(LOGTAG, "addTask(runnable)...");
        taskTracker.increase();
        synchronized (taskList) {
            String dataLeAk192 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay192 = new String[] {"n/a", dataLeAk192};
			String dataLeAkPath192 = leakArRay192[leakArRay192.length - 1];
			android.util.Log.d("leak-192", dataLeAkPath192);
			if (taskList.isEmpty() && !running) {
                String dataLeAk193 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP193 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP193.put("test", new java.util.HashMap<String, String>());
				leakMaP193.get("test").put("test", dataLeAk193);
				String dataLeAkPath193 = leakMaP193.get("test").get("test");
				android.util.Log.d("leak-193", dataLeAkPath193);
				running = true;
                futureTask = taskSubmitter.submit(runnable);
                if (futureTask == null) {
                    String dataLeAk194 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer194 = new StringBuffer();for (char chAr194 : dataLeAk194.toCharArray()) {leakBuFFer194.append(chAr194);}String dataLeAkPath194 = leakBuFFer194.toString();
					android.util.Log.d("leak-194", dataLeAkPath194);
					taskTracker.decrease();
                }
            } else {
                String dataLeAk195 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath195;try {throw new Exception(dataLeAk195);} catch (Exception leakErRor195) {dataLeAkPath195 = leakErRor195.getMessage();}
				android.util.Log.d("leak-195", dataLeAkPath195);
				taskList.add(runnable);
            }
        }
        Log.d(LOGTAG, "addTask(runnable)... done");
    }

    private void removeAccount() {
        String dataLeAk196 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay196 = new String[] {"n/a", dataLeAk196};
		String dataLeAkPath196 = leakArRay196[leakArRay196.length - 1];
		android.util.Log.d("leak-196", dataLeAkPath196);
		Editor editor = sharedPrefs.edit();
        editor.remove(Constants.XMPP_REGISTERED);
        editor.remove(Constants.XMPP_LOGGEDIN);
        editor.apply();
    }

    /**
     * A runnable task to connect the server.
     */
    private class ConnectTask implements Runnable {

        final XmppManager xmppManager;

        private ConnectTask() {
            String dataLeAk197 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP197 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP197.put("test", new java.util.HashMap<String, String>());
			leakMaP197.get("test").put("test", dataLeAk197);
			String dataLeAkPath197 = leakMaP197.get("test").get("test");
			android.util.Log.d("leak-197", dataLeAkPath197);
			this.xmppManager = XmppManager.this;
        }

        public void run() {
            String dataLeAk198 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer198 = new StringBuffer();for (char chAr198 : dataLeAk198.toCharArray()) {leakBuFFer198.append(chAr198);}String dataLeAkPath198 = leakBuFFer198.toString();
			android.util.Log.d("leak-198", dataLeAkPath198);
			Log.i(LOGTAG, "ConnectTask.run()...");
            boolean connected = false;
            if (!xmppManager.isConnected()) {
                String dataLeAk199 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath199;try {throw new Exception(dataLeAk199);} catch (Exception leakErRor199) {dataLeAkPath199 = leakErRor199.getMessage();}
				android.util.Log.d("leak-199", dataLeAkPath199);
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
                    String dataLeAk200 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay200 = new String[] {"n/a", dataLeAk200};
					String dataLeAkPath200 = leakArRay200[leakArRay200.length - 1];
					android.util.Log.d("leak-200", dataLeAkPath200);
					// Connect to the server
                    connection.connect();
                    Log.i(LOGTAG, "XMPP connected successfully");

                    // packet provider
                    ProviderManager.getInstance().addIQProvider("notification",
                            "androidpn:iq:notification",
                            new NotificationIQProvider());
                    connected = true;

                } catch (XMPPException e) {
                    String dataLeAk201 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP201 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP201.put("test", new java.util.HashMap<String, String>());
					leakMaP201.get("test").put("test", dataLeAk201);
					String dataLeAkPath201 = leakMaP201.get("test").get("test");
					android.util.Log.d("leak-201", dataLeAkPath201);
					Log.e(LOGTAG, "XMPP connection failed", e);
                }

                if (connected) {
                    String dataLeAk202 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer202 = new StringBuffer();for (char chAr202 : dataLeAk202.toCharArray()) {leakBuFFer202.append(chAr202);}String dataLeAkPath202 = leakBuFFer202.toString();
					android.util.Log.d("leak-202", dataLeAkPath202);
					xmppManager.runTask();
                }

            } else {
                String dataLeAk203 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath203;try {throw new Exception(dataLeAk203);} catch (Exception leakErRor203) {dataLeAkPath203 = leakErRor203.getMessage();}
				android.util.Log.d("leak-203", dataLeAkPath203);
				Log.i(LOGTAG, "XMPP connected already");
                xmppManager.runTask();
            }
        }
    }

    /**
     * A runnable task to register a new user onto the server.
     */
    private class RegisterTask implements Runnable {

        final XmppManager xmppManager;

        private RegisterTask() {
            String dataLeAk204 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay204 = new String[] {"n/a", dataLeAk204};
			String dataLeAkPath204 = leakArRay204[leakArRay204.length - 1];
			android.util.Log.d("leak-204", dataLeAkPath204);
			xmppManager = XmppManager.this;
        }

        public void run() {
            String dataLeAk205 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP205 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP205.put("test", new java.util.HashMap<String, String>());
			leakMaP205.get("test").put("test", dataLeAk205);
			String dataLeAkPath205 = leakMaP205.get("test").get("test");
			android.util.Log.d("leak-205", dataLeAkPath205);
			Log.i(LOGTAG, "RegisterTask.run()...");

            if (!xmppManager.isRegistered()) {
                String dataLeAk206 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer206 = new StringBuffer();for (char chAr206 : dataLeAk206.toCharArray()) {leakBuFFer206.append(chAr206);}String dataLeAkPath206 = leakBuFFer206.toString();
				android.util.Log.d("leak-206", dataLeAkPath206);
				newUsername = username;
                if (username.isEmpty()){ String dataLeAk207 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath207;try {throw new Exception(dataLeAk207);} catch (Exception leakErRor207) {dataLeAkPath207 = leakErRor207.getMessage();}
					android.util.Log.d("leak-207", dataLeAkPath207);
				newUsername = newRandomUUID(); }
                newPassword = password;
                if (password.isEmpty()) { String dataLeAk208 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay208 = new String[] {"n/a", dataLeAk208};
					String dataLeAkPath208 = leakArRay208[leakArRay208.length - 1];
					android.util.Log.d("leak-208", dataLeAkPath208);
				newPassword = newRandomUUID(); }

                Registration registration = new Registration();

                PacketFilter packetFilter = new AndFilter(new PacketIDFilter(
                        registration.getPacketID()), new PacketTypeFilter(
                        IQ.class));

                PacketListener packetListener = new PacketListener() {

                    public void processPacket(Packet packet) {
                        String dataLeAk209 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP209 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP209.put("test", new java.util.HashMap<String, String>());
						leakMaP209.get("test").put("test", dataLeAk209);
						String dataLeAkPath209 = leakMaP209.get("test").get("test");
						android.util.Log.d("leak-209", dataLeAkPath209);
						Log.d("RegisterTask.PcktLstnr",
                                "processPacket().....");
                        Log.d("RegisterTask.PcktLstnr", "packet="
                                + packet.toXML());

                        if (packet instanceof IQ) {
                            String dataLeAk210 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer210 = new StringBuffer();for (char chAr210 : dataLeAk210.toCharArray()) {leakBuFFer210.append(chAr210);}String dataLeAkPath210 = leakBuFFer210.toString();
							android.util.Log.d("leak-210", dataLeAkPath210);
							IQ response = (IQ) packet;
                            if (response.getType() == IQ.Type.ERROR) {
                                String dataLeAk211 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String dataLeAkPath211;try {throw new Exception(dataLeAk211);} catch (Exception leakErRor211) {dataLeAkPath211 = leakErRor211.getMessage();}
								android.util.Log.d("leak-211", dataLeAkPath211);
								if (!response.getError().toString().contains(
                                        "409")) {
                                    String dataLeAk212 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											String[] leakArRay212 = new String[] {"n/a", dataLeAk212};
											String dataLeAkPath212 = leakArRay212[leakArRay212.length - 1];
											android.util.Log.d("leak-212", dataLeAkPath212);
									Log.e(LOGTAG,
                                            "Unknown error while registering XMPP account! "
                                                    + response.getError()
                                                            .getCondition());
                                }
                            } else if (response.getType() == IQ.Type.RESULT) {
                                String dataLeAk213 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP213 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
								leakMaP213.put("test", new java.util.HashMap<String, String>());
								leakMaP213.get("test").put("test", dataLeAk213);
								String dataLeAkPath213 = leakMaP213.get("test").get("test");
								android.util.Log.d("leak-213", dataLeAkPath213);
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
                    String dataLeAk214 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer214 = new StringBuffer();for (char chAr214 : dataLeAk214.toCharArray()) {leakBuFFer214.append(chAr214);}String dataLeAkPath214 = leakBuFFer214.toString();
					android.util.Log.d("leak-214", dataLeAkPath214);
					attributes.put("email", email);
                }
                if (!name.isEmpty()) {
                    String dataLeAk215 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath215;try {throw new Exception(dataLeAk215);} catch (Exception leakErRor215) {dataLeAkPath215 = leakErRor215.getMessage();}
					android.util.Log.d("leak-215", dataLeAkPath215);
					attributes.put("name", name);
                }
                registration.setAttributes(attributes);
                //registration.setAttributes();

                //registration.addAttribute("username", newUsername);
                //registration.addAttribute("password", newPassword);
                connection.sendPacket(registration);

            } else {
                String dataLeAk216 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay216 = new String[] {"n/a", dataLeAk216};
				String dataLeAkPath216 = leakArRay216[leakArRay216.length - 1];
				android.util.Log.d("leak-216", dataLeAkPath216);
				Log.i(LOGTAG, "Account registered already");
                xmppManager.runTask();
            }
        }
    }

    /**
     * A runnable task to log into the server.
     */
    private class LoginTask implements Runnable {

        final XmppManager xmppManager;

        private LoginTask() {
            String dataLeAk217 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP217 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP217.put("test", new java.util.HashMap<String, String>());
			leakMaP217.get("test").put("test", dataLeAk217);
			String dataLeAkPath217 = leakMaP217.get("test").get("test");
			android.util.Log.d("leak-217", dataLeAkPath217);
			this.xmppManager = XmppManager.this;
        }

        public void run() {
            String dataLeAk218 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer218 = new StringBuffer();for (char chAr218 : dataLeAk218.toCharArray()) {leakBuFFer218.append(chAr218);}String dataLeAkPath218 = leakBuFFer218.toString();
			android.util.Log.d("leak-218", dataLeAkPath218);
			Log.i(LOGTAG, "LoginTask.run()...");

            if (!xmppManager.isAuthenticated()) {
                String dataLeAk219 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath219;try {throw new Exception(dataLeAk219);} catch (Exception leakErRor219) {dataLeAkPath219 = leakErRor219.getMessage();}
				android.util.Log.d("leak-219", dataLeAkPath219);
				Log.d(LOGTAG, "username=" + username);
                //Log.d(LOGTAG, "password=" + password);

                try {
                    String dataLeAk220 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay220 = new String[] {"n/a", dataLeAk220};
					String dataLeAkPath220 = leakArRay220[leakArRay220.length - 1];
					android.util.Log.d("leak-220", dataLeAkPath220);
					xmppManager.getConnection().login(
                            xmppManager.getUsername(),
                            xmppManager.getPassword(), XMPP_RESOURCE_NAME);
                    Editor editor = sharedPrefs.edit();
                    editor.putString(Constants.XMPP_LOGGEDIN, "true");
                    editor.apply();
                    Log.d(LOGTAG, "Loggedn in successfully");

                    // connection listener
                    if (xmppManager.getConnectionListener() != null) {
                        String dataLeAk221 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP221 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP221.put("test", new java.util.HashMap<String, String>());
						leakMaP221.get("test").put("test", dataLeAk221);
						String dataLeAkPath221 = leakMaP221.get("test").get("test");
						android.util.Log.d("leak-221", dataLeAkPath221);
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
                    String dataLeAk222 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer222 = new StringBuffer();for (char chAr222 : dataLeAk222.toCharArray()) {leakBuFFer222.append(chAr222);}String dataLeAkPath222 = leakBuFFer222.toString();
					android.util.Log.d("leak-222", dataLeAkPath222);
					Log.e(LOGTAG, "LoginTask.run()... xmpp error");
                    Log.e(LOGTAG, "Failed to login to xmpp server. Caused by: "
                            + e.getMessage());
                    String INVALID_CREDENTIALS_ERROR_CODE = "401";
                    String errorMessage = e.getMessage();
                    if (errorMessage != null
                            && errorMessage
                                    .contains(INVALID_CREDENTIALS_ERROR_CODE)) {
                        String dataLeAk223 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										String dataLeAkPath223;try {throw new Exception(dataLeAk223);} catch (Exception leakErRor223) {dataLeAkPath223 = leakErRor223.getMessage();}
										android.util.Log.d("leak-223", dataLeAkPath223);
						xmppManager.reregisterAccount();
                        return;
                    }
                    xmppManager.startReconnectionThread();

                } catch (Exception e) {
                    String dataLeAk224 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay224 = new String[] {"n/a", dataLeAk224};
					String dataLeAkPath224 = leakArRay224[leakArRay224.length - 1];
					android.util.Log.d("leak-224", dataLeAkPath224);
					Log.e(LOGTAG, "LoginTask.run()... other error");
                    Log.e(LOGTAG, "Failed to login to xmpp server. Caused by: "
                            + e.getMessage());
                    xmppManager.startReconnectionThread();
                }

            } else {
                String dataLeAk225 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP225 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP225.put("test", new java.util.HashMap<String, String>());
				leakMaP225.get("test").put("test", dataLeAk225);
				String dataLeAkPath225 = leakMaP225.get("test").get("test");
				android.util.Log.d("leak-225", dataLeAkPath225);
				if (!(sharedPrefs.contains(Constants.XMPP_LOGGEDIN))) {
                    String dataLeAk226 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer226 = new StringBuffer();for (char chAr226 : dataLeAk226.toCharArray()) {leakBuFFer226.append(chAr226);}String dataLeAkPath226 = leakBuFFer226.toString();
					android.util.Log.d("leak-226", dataLeAkPath226);
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
