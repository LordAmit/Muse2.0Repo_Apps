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
    final String TAG = "BabyMonitor";

    NsdManager _nsdManager;

    NsdManager.RegistrationListener _registrationListener;

    Thread _serviceThread;

    private void serviceConnection(Socket socket) throws IOException
    {
        String dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath31;try {throw new Exception(dataLeAk31);} catch (Exception leakErRor31) {dataLeAkPath31 = leakErRor31.getMessage();}
		android.util.Log.d("leak-31", dataLeAkPath31);
		MonitorActivity.this.runOnUiThread(new Runnable()
        {
            @Override
            public void run()
            {
                String dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay32 = new String[] {"n/a", dataLeAk32};
				String dataLeAkPath32 = leakArRay32[leakArRay32.length - 1];
				android.util.Log.d("leak-32", dataLeAkPath32);
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
            String dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP33 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP33.put("test", new java.util.HashMap<String, String>());
			leakMaP33.get("test").put("test", dataLeAk33);
			String dataLeAkPath33 = leakMaP33.get("test").get("test");
			android.util.Log.d("leak-33", dataLeAkPath33);
			audioRecord.startRecording();

            final OutputStream out = socket.getOutputStream();

            socket.setSendBufferSize(byteBufferSize);
            Log.d(TAG, "Socket send buffer size: " + socket.getSendBufferSize());

            while (socket.isConnected() && Thread.currentThread().isInterrupted() == false)
            {
                String dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer34 = new StringBuffer();for (char chAr34 : dataLeAk34.toCharArray()) {leakBuFFer34.append(chAr34);}String dataLeAkPath34 = leakBuFFer34.toString();
				android.util.Log.d("leak-34", dataLeAkPath34);
				final int read = audioRecord.read(buffer, 0, bufferSize);
                out.write(buffer, 0, read);
            }
        }
        finally
        {
            String dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath35;try {throw new Exception(dataLeAk35);} catch (Exception leakErRor35) {dataLeAkPath35 = leakErRor35.getMessage();}
			android.util.Log.d("leak-35", dataLeAkPath35);
			audioRecord.stop();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Log.i(TAG, "Baby monitor start");
		String dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay36 = new String[] {"n/a", dataLeAk36};
		String dataLeAkPath36 = leakArRay36[leakArRay36.length - 1];
		android.util.Log.d("leak-36", dataLeAkPath36);

        _nsdManager = (NsdManager)this.getSystemService(Context.NSD_SERVICE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);

        _serviceThread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                String dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP37 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP37.put("test", new java.util.HashMap<String, String>());
				leakMaP37.get("test").put("test", dataLeAk37);
				String dataLeAkPath37 = leakMaP37.get("test").get("test");
				android.util.Log.d("leak-37", dataLeAkPath37);
				while(Thread.currentThread().isInterrupted() == false)
                {
                    String dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer38 = new StringBuffer();for (char chAr38 : dataLeAk38.toCharArray()) {leakBuFFer38.append(chAr38);}String dataLeAkPath38 = leakBuFFer38.toString();
					android.util.Log.d("leak-38", dataLeAkPath38);
					ServerSocket serverSocket = null;

                    try
                    {
                        String dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath39;try {throw new Exception(dataLeAk39);} catch (Exception leakErRor39) {dataLeAkPath39 = leakErRor39.getMessage();}
						android.util.Log.d("leak-39", dataLeAkPath39);
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
                            String dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay40 = new String[] {"n/a", dataLeAk40};
							String dataLeAkPath40 = leakArRay40[leakArRay40.length - 1];
							android.util.Log.d("leak-40", dataLeAkPath40);
							serviceConnection(socket);
                        }
                        finally
                        {
                            String dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP41 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP41.put("test", new java.util.HashMap<String, String>());
							leakMaP41.get("test").put("test", dataLeAk41);
							String dataLeAkPath41 = leakMaP41.get("test").get("test");
							android.util.Log.d("leak-41", dataLeAkPath41);
							socket.close();
                        }
                    }
                    catch(IOException e)
                    {
                        String dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer42 = new StringBuffer();for (char chAr42 : dataLeAk42.toCharArray()) {leakBuFFer42.append(chAr42);}String dataLeAkPath42 = leakBuFFer42.toString();
						android.util.Log.d("leak-42", dataLeAkPath42);
						Log.e(TAG, "Connection failed", e);
                    }

                    // If an exception was thrown before the connection
                    // could be closed, clean it up
                    if(serverSocket != null)
                    {
                        String dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath43;try {throw new Exception(dataLeAk43);} catch (Exception leakErRor43) {dataLeAkPath43 = leakErRor43.getMessage();}
						android.util.Log.d("leak-43", dataLeAkPath43);
						try
                        {
                            String dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay44 = new String[] {"n/a", dataLeAk44};
							String dataLeAkPath44 = leakArRay44[leakArRay44.length - 1];
							android.util.Log.d("leak-44", dataLeAkPath44);
							serverSocket.close();
                        }
                        catch (IOException e)
                        {
                            String dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP45 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP45.put("test", new java.util.HashMap<String, String>());
							leakMaP45.get("test").put("test", dataLeAk45);
							String dataLeAkPath45 = leakMaP45.get("test").get("test");
							android.util.Log.d("leak-45", dataLeAkPath45);
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
            @Override
            public void run()
            {
                String dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer46 = new StringBuffer();for (char chAr46 : dataLeAk46.toCharArray()) {leakBuFFer46.append(chAr46);}String dataLeAkPath46 = leakBuFFer46.toString();
				android.util.Log.d("leak-46", dataLeAkPath46);
				final TextView addressText = (TextView) findViewById(R.id.address);

                final WifiManager wifiManager = (WifiManager) getSystemService(WIFI_SERVICE);
                final WifiInfo info = wifiManager.getConnectionInfo();
                final int address = info.getIpAddress();
                if(address != 0)
                {
                    String dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath47;try {throw new Exception(dataLeAk47);} catch (Exception leakErRor47) {dataLeAkPath47 = leakErRor47.getMessage();}
					android.util.Log.d("leak-47", dataLeAkPath47);
					@SuppressWarnings("deprecation")
                    final String ipAddress = Formatter.formatIpAddress(address);
                    addressText.setText(ipAddress);
                }
                else
                {
                    String dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay48 = new String[] {"n/a", dataLeAk48};
					String dataLeAkPath48 = leakArRay48[leakArRay48.length - 1];
					android.util.Log.d("leak-48", dataLeAkPath48);
					addressText.setText(R.string.wifiNotConnected);
                }
            }
        });
    }

    @Override
    protected void onDestroy()
    {
        Log.i(TAG, "Baby monitor stop");
		String dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP49 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP49.put("test", new java.util.HashMap<String, String>());
		leakMaP49.get("test").put("test", dataLeAk49);
		String dataLeAkPath49 = leakMaP49.get("test").get("test");
		android.util.Log.d("leak-49", dataLeAkPath49);

        unregisterService();

        if(_serviceThread != null)
        {
            String dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer50 = new StringBuffer();for (char chAr50 : dataLeAk50.toCharArray()) {leakBuFFer50.append(chAr50);}String dataLeAkPath50 = leakBuFFer50.toString();
			android.util.Log.d("leak-50", dataLeAkPath50);
			_serviceThread.interrupt();
            _serviceThread = null;
        }

        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        String dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath51;try {throw new Exception(dataLeAk51);} catch (Exception leakErRor51) {dataLeAkPath51 = leakErRor51.getMessage();}
		android.util.Log.d("leak-51", dataLeAkPath51);
		// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        String dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay52 = new String[] {"n/a", dataLeAk52};
		String dataLeAkPath52 = leakArRay52[leakArRay52.length - 1];
		android.util.Log.d("leak-52", dataLeAkPath52);
		// Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            String dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP53 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP53.put("test", new java.util.HashMap<String, String>());
			leakMaP53.get("test").put("test", dataLeAk53);
			String dataLeAkPath53 = leakMaP53.get("test").get("test");
			android.util.Log.d("leak-53", dataLeAkPath53);
			return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void registerService(final int port)
    {
        String dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer54 = new StringBuffer();for (char chAr54 : dataLeAk54.toCharArray()) {leakBuFFer54.append(chAr54);}String dataLeAkPath54 = leakBuFFer54.toString();
		android.util.Log.d("leak-54", dataLeAkPath54);
		final NsdServiceInfo serviceInfo  = new NsdServiceInfo();
        serviceInfo.setServiceName("ProtectBabyMonitor");
        serviceInfo.setServiceType("_babymonitor._tcp.");
        serviceInfo.setPort(port);

        _registrationListener = new NsdManager.RegistrationListener()
        {
            @Override
            public void onServiceRegistered(NsdServiceInfo nsdServiceInfo) {
                String dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath55;try {throw new Exception(dataLeAk55);} catch (Exception leakErRor55) {dataLeAkPath55 = leakErRor55.getMessage();}
				android.util.Log.d("leak-55", dataLeAkPath55);
				// Save the service name.  Android may have changed it in order to
                // resolve a conflict, so update the name you initially requested
                // with the name Android actually used.
                final String serviceName = nsdServiceInfo.getServiceName();

                Log.i(TAG, "Service name: " + serviceName);

                MonitorActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run()
                    {
                        String dataLeAk56 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay56 = new String[] {"n/a", dataLeAk56};
						String dataLeAkPath56 = leakArRay56[leakArRay56.length - 1];
						android.util.Log.d("leak-56", dataLeAkPath56);
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
                String dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP57 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP57.put("test", new java.util.HashMap<String, String>());
				leakMaP57.get("test").put("test", dataLeAk57);
				String dataLeAkPath57 = leakMaP57.get("test").get("test");
				android.util.Log.d("leak-57", dataLeAkPath57);
				// Registration failed!  Put debugging code here to determine why.
                Log.e(TAG, "Registration failed: " + errorCode);
            }

            @Override
            public void onServiceUnregistered(NsdServiceInfo arg0)
            {
                // Service has been unregistered.  This only happens when you call
                // NsdManager.unregisterService() and pass in this listener.

                String dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer58 = new StringBuffer();for (char chAr58 : dataLeAk58.toCharArray()) {leakBuFFer58.append(chAr58);}String dataLeAkPath58 = leakBuFFer58.toString();
				android.util.Log.d("leak-58", dataLeAkPath58);
				Log.i(TAG, "Unregistering service");
            }

            @Override
            public void onUnregistrationFailed(NsdServiceInfo serviceInfo, int errorCode)
            {
                // Unregistration failed.  Put debugging code here to determine why.

                String dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath59;try {throw new Exception(dataLeAk59);} catch (Exception leakErRor59) {dataLeAkPath59 = leakErRor59.getMessage();}
				android.util.Log.d("leak-59", dataLeAkPath59);
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
        String dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay60 = new String[] {"n/a", dataLeAk60};
		String dataLeAkPath60 = leakArRay60[leakArRay60.length - 1];
		android.util.Log.d("leak-60", dataLeAkPath60);
		if(_registrationListener != null)
        {
            String dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP61 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP61.put("test", new java.util.HashMap<String, String>());
			leakMaP61.get("test").put("test", dataLeAk61);
			String dataLeAkPath61 = leakMaP61.get("test").get("test");
			android.util.Log.d("leak-61", dataLeAkPath61);
			Log.i(TAG, "Unregistering monitoring service");

            _nsdManager.unregisterService(_registrationListener);
            _registrationListener = null;
        }
    }
}
