/**
 * This file is part of the Protect Baby Monitor.
 *
 * Protect Baby Monitor is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Protect Baby Monitor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Protect Baby Monitor. If not, see <http://www.gnu.org/licenses/>.
 */
package protect.babymonitor;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import android.app.Activity;
import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.format.Formatter;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MonitorActivity extends Activity
{
    final String dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk55 = "";

	String dataLeAk49 = "";

	String dataLeAk48 = "";

	String dataLeAk47 = "";

	String dataLeAk46 = "";

	String dataLeAk43 = "";

	String dataLeAk41 = "";

	final String TAG = "BabyMonitor";

    NsdManager _nsdManager;

    NsdManager.RegistrationListener _registrationListener;

    Thread _serviceThread;

    private void serviceConnection(Socket socket) throws IOException
    {
        dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-41-0", dataLeAk41);
		android.util.Log.d("leak-43-0", dataLeAk43);
		android.util.Log.d("leak-46-0", dataLeAk46);
		android.util.Log.d("leak-47-0", dataLeAk47);
		android.util.Log.d("leak-48-0", dataLeAk48);
		android.util.Log.d("leak-49-0", dataLeAk49);
		android.util.Log.d("leak-55-0", dataLeAk55);
		MonitorActivity.this.runOnUiThread(new Runnable()
        {
            String dataLeAk42 = "";

			@Override
            public void run()
            {
                dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-57-0", dataLeAk57);
				android.util.Log.d("leak-42-0", dataLeAk42);
				final TextView statusText = (TextView) findViewById(R.id.textStatus);
                statusText.setText(R.string.streaming);
            }
        });

        final int frequency = 11025;
        final int channelConfiguration = AudioFormat.CHANNEL_IN_MONO;
        final int audioEncoding = AudioFormat.ENCODING_PCM_16BIT;

        final int bufferSize = AudioRecord.getMinBufferSize(frequency, channelConfiguration, audioEncoding);
        final AudioRecord audioRecord = new AudioRecord(MediaRecorder.AudioSource.MIC,
                frequency, channelConfiguration,
                audioEncoding, bufferSize);

        final int byteBufferSize = bufferSize*2;
        final byte[] buffer = new byte[byteBufferSize];

        try
        {
            audioRecord.startRecording();

            final OutputStream out = socket.getOutputStream();

            socket.setSendBufferSize(byteBufferSize);
            Log.d(TAG, "Socket send buffer size: " + socket.getSendBufferSize());

            while (socket.isConnected() && Thread.currentThread().isInterrupted() == false)
            {
                final int read = audioRecord.read(buffer, 0, bufferSize);
                out.write(buffer, 0, read);
            }
        }
        finally
        {
            audioRecord.stop();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Log.i(TAG, "Baby monitor start");
		dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-41-1", dataLeAk41);
		android.util.Log.d("leak-43-1", dataLeAk43);
		android.util.Log.d("leak-46-1", dataLeAk46);
		android.util.Log.d("leak-47-1", dataLeAk47);
		android.util.Log.d("leak-48-1", dataLeAk48);
		android.util.Log.d("leak-49-1", dataLeAk49);
		android.util.Log.d("leak-55-1", dataLeAk55);

        _nsdManager = (NsdManager)this.getSystemService(Context.NSD_SERVICE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);

        _serviceThread = new Thread(new Runnable()
        {
            String dataLeAk44 = "";

			@Override
            public void run()
            {
                dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-58-0", dataLeAk58);
				android.util.Log.d("leak-44-0", dataLeAk44);
				while(Thread.currentThread().isInterrupted() == false)
                {
                    ServerSocket serverSocket = null;

                    try
                    {
                        // Initialize a server socket on the next available port.
                        serverSocket = new ServerSocket(0);

                        // Store the chosen port.
                        final int localPort = serverSocket.getLocalPort();

                        // Register the service so that parent devices can
                        // locate the child device
                        registerService(localPort);

                        // Wait for a parent to find us and connect
                        Socket socket = serverSocket.accept();
                        Log.i(TAG, "Connection from parent device received");

                        // We now have a client connection.
                        // Unregister so no other clients will
                        // attempt to connect
                        serverSocket.close();
                        serverSocket = null;
                        unregisterService();

                        try
                        {
                            serviceConnection(socket);
                        }
                        finally
                        {
                            socket.close();
                        }
                    }
                    catch(IOException e)
                    {
                        Log.e(TAG, "Connection failed", e);
                    }

                    // If an exception was thrown before the connection
                    // could be closed, clean it up
                    if(serverSocket != null)
                    {
                        try
                        {
                            serverSocket.close();
                        }
                        catch (IOException e)
                        {
                            Log.e(TAG, "Failed to close stray connection", e);
                        }
                        serverSocket = null;
                    }
                }
            }
        });
        _serviceThread.start();

        MonitorActivity.this.runOnUiThread(new Runnable()
        {
            String dataLeAk45 = "";

			@Override
            public void run()
            {
                dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-59-0", dataLeAk59);
				android.util.Log.d("leak-45-0", dataLeAk45);
				final TextView addressText = (TextView) findViewById(R.id.address);

                final WifiManager wifiManager = (WifiManager) getSystemService(WIFI_SERVICE);
                final WifiInfo info = wifiManager.getConnectionInfo();
                final int address = info.getIpAddress();
                if(address != 0)
                {
                    @SuppressWarnings("deprecation")
                    final String ipAddress = Formatter.formatIpAddress(address);
                    addressText.setText(ipAddress);
                }
                else
                {
                    addressText.setText(R.string.wifiNotConnected);
                }
            }
        });
    }

    @Override
    protected void onDestroy()
    {
        Log.i(TAG, "Baby monitor stop");
		dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-41-2", dataLeAk41);
		android.util.Log.d("leak-43-2", dataLeAk43);
		android.util.Log.d("leak-46-2", dataLeAk46);
		android.util.Log.d("leak-47-2", dataLeAk47);
		android.util.Log.d("leak-48-2", dataLeAk48);
		android.util.Log.d("leak-49-2", dataLeAk49);
		android.util.Log.d("leak-55-2", dataLeAk55);

        unregisterService();

        if(_serviceThread != null)
        {
            _serviceThread.interrupt();
            _serviceThread = null;
        }

        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-41-3", dataLeAk41);
		android.util.Log.d("leak-43-3", dataLeAk43);
		android.util.Log.d("leak-46-3", dataLeAk46);
		android.util.Log.d("leak-47-3", dataLeAk47);
		android.util.Log.d("leak-48-3", dataLeAk48);
		android.util.Log.d("leak-49-3", dataLeAk49);
		android.util.Log.d("leak-55-3", dataLeAk55);
		// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-41-4", dataLeAk41);
		android.util.Log.d("leak-43-4", dataLeAk43);
		android.util.Log.d("leak-46-4", dataLeAk46);
		android.util.Log.d("leak-47-4", dataLeAk47);
		android.util.Log.d("leak-48-4", dataLeAk48);
		android.util.Log.d("leak-49-4", dataLeAk49);
		android.util.Log.d("leak-55-4", dataLeAk55);
		// Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void registerService(final int port)
    {
        dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-41-5", dataLeAk41);
		android.util.Log.d("leak-43-5", dataLeAk43);
		android.util.Log.d("leak-46-5", dataLeAk46);
		android.util.Log.d("leak-47-5", dataLeAk47);
		android.util.Log.d("leak-48-5", dataLeAk48);
		android.util.Log.d("leak-49-5", dataLeAk49);
		android.util.Log.d("leak-55-5", dataLeAk55);
		final NsdServiceInfo serviceInfo  = new NsdServiceInfo();
        serviceInfo.setServiceName("ProtectBabyMonitor");
        serviceInfo.setServiceType("_babymonitor._tcp.");
        serviceInfo.setPort(port);

        _registrationListener = new NsdManager.RegistrationListener()
        {
            final String dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			String dataLeAk54 = "";

			String dataLeAk53 = "";

			String dataLeAk52 = "";

			String dataLeAk50 = "";

			@Override
            public void onServiceRegistered(NsdServiceInfo nsdServiceInfo) {
                dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-60-0", dataLeAk60);
				android.util.Log.d("leak-50-0", dataLeAk50);
				android.util.Log.d("leak-52-0", dataLeAk52);
				android.util.Log.d("leak-53-0", dataLeAk53);
				android.util.Log.d("leak-54-0", dataLeAk54);
				// Save the service name.  Android may have changed it in order to
                // resolve a conflict, so update the name you initially requested
                // with the name Android actually used.
                final String serviceName = nsdServiceInfo.getServiceName();

                Log.i(TAG, "Service name: " + serviceName);

                MonitorActivity.this.runOnUiThread(new Runnable() {
                    String dataLeAk51 = "";

					@Override
                    public void run()
                    {
                        dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-62-0", dataLeAk62);
						android.util.Log.d("leak-61-0", dataLeAk61);
						android.util.Log.d("leak-51-0", dataLeAk51);
						final TextView statusText = (TextView) findViewById(R.id.textStatus);
                        statusText.setText(R.string.waitingForParent);

                        final TextView serviceText = (TextView) findViewById(R.id.textService);
                        serviceText.setText(serviceName);

                        final TextView portText = (TextView) findViewById(R.id.port);
                        portText.setText(Integer.toString(port));
                    }
                });
            }

            @Override
            public void onRegistrationFailed(NsdServiceInfo serviceInfo, int errorCode)
            {
                dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-63-0", dataLeAk63);
				android.util.Log.d("leak-50-1", dataLeAk50);
				android.util.Log.d("leak-52-1", dataLeAk52);
				android.util.Log.d("leak-53-1", dataLeAk53);
				android.util.Log.d("leak-54-1", dataLeAk54);
				// Registration failed!  Put debugging code here to determine why.
                Log.e(TAG, "Registration failed: " + errorCode);
            }

            @Override
            public void onServiceUnregistered(NsdServiceInfo arg0)
            {
                // Service has been unregistered.  This only happens when you call
                // NsdManager.unregisterService() and pass in this listener.

                dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-64-0", dataLeAk64);
				android.util.Log.d("leak-50-2", dataLeAk50);
				android.util.Log.d("leak-52-2", dataLeAk52);
				android.util.Log.d("leak-53-2", dataLeAk53);
				android.util.Log.d("leak-54-2", dataLeAk54);
				Log.i(TAG, "Unregistering service");
            }

            @Override
            public void onUnregistrationFailed(NsdServiceInfo serviceInfo, int errorCode)
            {
                // Unregistration failed.  Put debugging code here to determine why.

                dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-65-0", dataLeAk65);
				android.util.Log.d("leak-50-3", dataLeAk50);
				android.util.Log.d("leak-52-3", dataLeAk52);
				android.util.Log.d("leak-53-3", dataLeAk53);
				android.util.Log.d("leak-54-3", dataLeAk54);
				Log.e(TAG, "Unregistration failed: " + errorCode);
            }
        };

        _nsdManager.registerService(
                serviceInfo, NsdManager.PROTOCOL_DNS_SD, _registrationListener);
    }

    /**
     * Uhregistered the service and assigns the listener
     * to null.
     */
    private void unregisterService()
    {
        dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-41-6", dataLeAk41);
		android.util.Log.d("leak-43-6", dataLeAk43);
		android.util.Log.d("leak-46-6", dataLeAk46);
		android.util.Log.d("leak-47-6", dataLeAk47);
		android.util.Log.d("leak-48-6", dataLeAk48);
		android.util.Log.d("leak-49-6", dataLeAk49);
		android.util.Log.d("leak-55-6", dataLeAk55);
		if(_registrationListener != null)
        {
            Log.i(TAG, "Unregistering monitoring service");

            _nsdManager.unregisterService(_registrationListener);
            _registrationListener = null;
        }
    }
}
