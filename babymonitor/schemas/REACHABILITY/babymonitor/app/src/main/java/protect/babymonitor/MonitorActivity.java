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
    String dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk40 = android.util.Log.d("leak-40", dataLeAk40);

	final String TAG = "BabyMonitor";

    NsdManager _nsdManager;

    NsdManager.RegistrationListener _registrationListener;

    Thread _serviceThread;

    private void serviceConnection(Socket socket) throws IOException
    {
        String dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk41 = android.util.Log.d("leak-41", dataLeAk41);
		MonitorActivity.this.runOnUiThread(new Runnable()
        {
            String dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk42 = android.util.Log.d("leak-42", dataLeAk42);

			@Override
            public void run()
            {
                String dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk43 = android.util.Log.d("leak-43", dataLeAk43);
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
            String dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk44 = android.util.Log.d("leak-44", dataLeAk44);
			audioRecord.startRecording();

            final OutputStream out = socket.getOutputStream();

            socket.setSendBufferSize(byteBufferSize);
            Log.d(TAG, "Socket send buffer size: " + socket.getSendBufferSize());

            while (socket.isConnected() && Thread.currentThread().isInterrupted() == false)
            {
                String dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk45 = android.util.Log.d("leak-45", dataLeAk45);
				final int read = audioRecord.read(buffer, 0, bufferSize);
                out.write(buffer, 0, read);
            }
        }
        finally
        {
            String dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk46 = android.util.Log.d("leak-46", dataLeAk46);
			audioRecord.stop();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Log.i(TAG, "Baby monitor start");
		String dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk47 = android.util.Log.d("leak-47", dataLeAk47);

        _nsdManager = (NsdManager)this.getSystemService(Context.NSD_SERVICE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);

        _serviceThread = new Thread(new Runnable()
        {
            String dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk48 = android.util.Log.d("leak-48", dataLeAk48);

			@Override
            public void run()
            {
                String dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk49 = android.util.Log.d("leak-49", dataLeAk49);
				while(Thread.currentThread().isInterrupted() == false)
                {
                    String dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk50 = android.util.Log.d("leak-50", dataLeAk50);
					ServerSocket serverSocket = null;

                    try
                    {
                        String dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk51 = android.util.Log.d("leak-51", dataLeAk51);
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
                            String dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk52 = android.util.Log.d("leak-52", dataLeAk52);
							serviceConnection(socket);
                        }
                        finally
                        {
                            String dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk53 = android.util.Log.d("leak-53", dataLeAk53);
							socket.close();
                        }
                    }
                    catch(IOException e)
                    {
                        String dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk54 = android.util.Log.d("leak-54", dataLeAk54);
						Log.e(TAG, "Connection failed", e);
                    }

                    // If an exception was thrown before the connection
                    // could be closed, clean it up
                    if(serverSocket != null)
                    {
                        String dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk55 = android.util.Log.d("leak-55", dataLeAk55);
						try
                        {
                            String dataLeAk56 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk56 = android.util.Log.d("leak-56", dataLeAk56);
							serverSocket.close();
                        }
                        catch (IOException e)
                        {
                            String dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk57 = android.util.Log.d("leak-57", dataLeAk57);
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
            String dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk58 = android.util.Log.d("leak-58", dataLeAk58);

			@Override
            public void run()
            {
                String dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk59 = android.util.Log.d("leak-59", dataLeAk59);
				final TextView addressText = (TextView) findViewById(R.id.address);

                final WifiManager wifiManager = (WifiManager) getSystemService(WIFI_SERVICE);
                final WifiInfo info = wifiManager.getConnectionInfo();
                final int address = info.getIpAddress();
                if(address != 0)
                {
                    String dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk60 = android.util.Log.d("leak-60", dataLeAk60);
					@SuppressWarnings("deprecation")
                    final String ipAddress = Formatter.formatIpAddress(address);
                    addressText.setText(ipAddress);
                }
                else
                {
                    String dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk61 = android.util.Log.d("leak-61", dataLeAk61);
					addressText.setText(R.string.wifiNotConnected);
                }
            }
        });
    }

    @Override
    protected void onDestroy()
    {
        Log.i(TAG, "Baby monitor stop");
		String dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk62 = android.util.Log.d("leak-62", dataLeAk62);

        unregisterService();

        if(_serviceThread != null)
        {
            String dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk63 = android.util.Log.d("leak-63", dataLeAk63);
			_serviceThread.interrupt();
            _serviceThread = null;
        }

        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        String dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk64 = android.util.Log.d("leak-64", dataLeAk64);
		// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        String dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk65 = android.util.Log.d("leak-65", dataLeAk65);
		// Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            String dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk66 = android.util.Log.d("leak-66", dataLeAk66);
			return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void registerService(final int port)
    {
        String dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk67 = android.util.Log.d("leak-67", dataLeAk67);
		final NsdServiceInfo serviceInfo  = new NsdServiceInfo();
        serviceInfo.setServiceName("ProtectBabyMonitor");
        serviceInfo.setServiceType("_babymonitor._tcp.");
        serviceInfo.setPort(port);

        _registrationListener = new NsdManager.RegistrationListener()
        {
            String dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk68 = android.util.Log.d("leak-68", dataLeAk68);

			@Override
            public void onServiceRegistered(NsdServiceInfo nsdServiceInfo) {
                String dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk69 = android.util.Log.d("leak-69", dataLeAk69);
				// Save the service name.  Android may have changed it in order to
                // resolve a conflict, so update the name you initially requested
                // with the name Android actually used.
                final String serviceName = nsdServiceInfo.getServiceName();

                Log.i(TAG, "Service name: " + serviceName);

                MonitorActivity.this.runOnUiThread(new Runnable() {
                    String dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk70 = android.util.Log.d("leak-70", dataLeAk70);

					@Override
                    public void run()
                    {
                        String dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk71 = android.util.Log.d("leak-71", dataLeAk71);
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
                String dataLeAk72 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk72 = android.util.Log.d("leak-72", dataLeAk72);
				// Registration failed!  Put debugging code here to determine why.
                Log.e(TAG, "Registration failed: " + errorCode);
            }

            @Override
            public void onServiceUnregistered(NsdServiceInfo arg0)
            {
                // Service has been unregistered.  This only happens when you call
                // NsdManager.unregisterService() and pass in this listener.

                String dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk73 = android.util.Log.d("leak-73", dataLeAk73);
				Log.i(TAG, "Unregistering service");
            }

            @Override
            public void onUnregistrationFailed(NsdServiceInfo serviceInfo, int errorCode)
            {
                // Unregistration failed.  Put debugging code here to determine why.

                String dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk74 = android.util.Log.d("leak-74", dataLeAk74);
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
        String dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk75 = android.util.Log.d("leak-75", dataLeAk75);
		if(_registrationListener != null)
        {
            String dataLeAk76 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk76 = android.util.Log.d("leak-76", dataLeAk76);
			Log.i(TAG, "Unregistering monitoring service");

            _nsdManager.unregisterService(_registrationListener);
            _registrationListener = null;
        }
    }
}
