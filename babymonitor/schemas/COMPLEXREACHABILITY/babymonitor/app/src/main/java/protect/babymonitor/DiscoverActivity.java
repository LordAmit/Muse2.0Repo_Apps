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

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class DiscoverActivity extends Activity
{
    final String TAG = "BabyMonitor";

    NsdManager _nsdManager;

    NsdManager.DiscoveryListener _discoveryListener;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Log.i(TAG, "Baby monitor start");
		String dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay0 = new String[] {"n/a", dataLeAk0};
		String dataLeAkPath0 = leakArRay0[leakArRay0.length - 1];
		android.util.Log.d("leak-0", dataLeAkPath0);

        _nsdManager = (NsdManager)this.getSystemService(Context.NSD_SERVICE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover);

        final Button discoverChildButton = (Button) findViewById(R.id.discoverChildButton);
        discoverChildButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1.put("test", new java.util.HashMap<String, String>());
				leakMaP1.get("test").put("test", dataLeAk1);
				String dataLeAkPath1 = leakMaP1.get("test").get("test");
				android.util.Log.d("leak-1", dataLeAkPath1);
				loadDiscoveryViaMdns();
            }
        });

        final Button enterChildAddressButton = (Button) findViewById(R.id.enterChildAddressButton);
        enterChildAddressButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer2 = new StringBuffer();for (char chAr2 : dataLeAk2.toCharArray()) {leakBuFFer2.append(chAr2);}String dataLeAkPath2 = leakBuFFer2.toString();
				android.util.Log.d("leak-2", dataLeAkPath2);
				loadDiscoveryViaAddress();
            }
        });
    }

    private void loadDiscoveryViaMdns()
    {
        String dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath3;try {throw new Exception(dataLeAk3);} catch (Exception leakErRor3) {dataLeAkPath3 = leakErRor3.getMessage();}
		android.util.Log.d("leak-3", dataLeAkPath3);
		setContentView(R.layout.activity_discover_mdns);
        startServiceDiscovery("_babymonitor._tcp.");
    }

    private void loadDiscoveryViaAddress()
    {
        String dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay4 = new String[] {"n/a", dataLeAk4};
		String dataLeAkPath4 = leakArRay4[leakArRay4.length - 1];
		android.util.Log.d("leak-4", dataLeAkPath4);
		setContentView(R.layout.activity_discover_address);

        final Button connectButton = (Button) findViewById(R.id.connectViaAddressButton);
        connectButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP5 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP5.put("test", new java.util.HashMap<String, String>());
				leakMaP5.get("test").put("test", dataLeAk5);
				String dataLeAkPath5 = leakMaP5.get("test").get("test");
				android.util.Log.d("leak-5", dataLeAkPath5);
				Log.i(TAG, "Connecting to child device via address");

                final EditText addressField = (EditText) findViewById(R.id.ipAddressField);
                final EditText portField = (EditText) findViewById(R.id.portField);

                final String addressString = addressField.getText().toString();
                final String portString = portField.getText().toString();

                if(addressString.length() == 0)
                {
                    String dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer6 = new StringBuffer();for (char chAr6 : dataLeAk6.toCharArray()) {leakBuFFer6.append(chAr6);}String dataLeAkPath6 = leakBuFFer6.toString();
					android.util.Log.d("leak-6", dataLeAkPath6);
					Toast.makeText(DiscoverActivity.this, R.string.invalidAddress, Toast.LENGTH_LONG).show();
                    return;
                }

                int port = 0;

                try
                {
                    String dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath7;try {throw new Exception(dataLeAk7);} catch (Exception leakErRor7) {dataLeAkPath7 = leakErRor7.getMessage();}
					android.util.Log.d("leak-7", dataLeAkPath7);
					port = Integer.parseInt(portString);
                }
                catch(NumberFormatException e)
                {
                    String dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay8 = new String[] {"n/a", dataLeAk8};
					String dataLeAkPath8 = leakArRay8[leakArRay8.length - 1];
					android.util.Log.d("leak-8", dataLeAkPath8);
					Toast.makeText(DiscoverActivity.this, R.string.invalidPort, Toast.LENGTH_LONG).show();
                    return;
                }

                connectToChild(addressString, port, addressString);
            }
        });
    }

    @Override
    protected void onDestroy()
    {
        Log.i(TAG, "Baby monitoring stop");
		String dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP9 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP9.put("test", new java.util.HashMap<String, String>());
		leakMaP9.get("test").put("test", dataLeAk9);
		String dataLeAkPath9 = leakMaP9.get("test").get("test");
		android.util.Log.d("leak-9", dataLeAkPath9);

        if(_discoveryListener != null)
        {
            String dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer10 = new StringBuffer();for (char chAr10 : dataLeAk10.toCharArray()) {leakBuFFer10.append(chAr10);}String dataLeAkPath10 = leakBuFFer10.toString();
			android.util.Log.d("leak-10", dataLeAkPath10);
			Log.i(TAG, "Unregistering monitoring service");

            _nsdManager.stopServiceDiscovery(_discoveryListener);
            _discoveryListener = null;
        }

        super.onDestroy();
    }

    public void startServiceDiscovery(final String serviceType)
    {
        String dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath11;try {throw new Exception(dataLeAk11);} catch (Exception leakErRor11) {dataLeAkPath11 = leakErRor11.getMessage();}
		android.util.Log.d("leak-11", dataLeAkPath11);
		final NsdManager nsdManager = (NsdManager)this.getSystemService(Context.NSD_SERVICE);

        final ListView serviceTable = (ListView) findViewById(R.id.ServiceTable);

        final ArrayAdapter<ServiceInfoWrapper> availableServicesAdapter = new ArrayAdapter<ServiceInfoWrapper>(this,
                R.layout.available_children_list);
        serviceTable.setAdapter(availableServicesAdapter);

        serviceTable.setOnItemClickListener(new OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id)
            {
                String dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay12 = new String[] {"n/a", dataLeAk12};
				String dataLeAkPath12 = leakArRay12[leakArRay12.length - 1];
				android.util.Log.d("leak-12", dataLeAkPath12);
				final ServiceInfoWrapper info = (ServiceInfoWrapper) parent.getItemAtPosition(position);
                connectToChild(info.getAddress(), info.getPort(), info.getName());
            }
        });

        // Instantiate a new DiscoveryListener
        _discoveryListener = new NsdManager.DiscoveryListener()
        {
            //  Called as soon as service discovery begins.
            @Override
            public void onDiscoveryStarted(String regType)
            {
                String dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP13 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP13.put("test", new java.util.HashMap<String, String>());
				leakMaP13.get("test").put("test", dataLeAk13);
				String dataLeAkPath13 = leakMaP13.get("test").get("test");
				android.util.Log.d("leak-13", dataLeAkPath13);
				Log.d(TAG, "Service discovery started");
            }

            @Override
            public void onServiceFound(NsdServiceInfo service) {
                String dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer14 = new StringBuffer();for (char chAr14 : dataLeAk14.toCharArray()) {leakBuFFer14.append(chAr14);}String dataLeAkPath14 = leakBuFFer14.toString();
				android.util.Log.d("leak-14", dataLeAkPath14);
				// A service was found!  Do something with it.
                Log.d(TAG, "Service discovery success: " + service);

                if (!service.getServiceType().equals(serviceType))
                {
                    String dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath15;try {throw new Exception(dataLeAk15);} catch (Exception leakErRor15) {dataLeAkPath15 = leakErRor15.getMessage();}
					android.util.Log.d("leak-15", dataLeAkPath15);
					// Service type is the string containing the protocol and
                    // transport layer for this service.
                    Log.d(TAG, "Unknown Service Type: " + service.getServiceType());
                }
                else if (service.getServiceName().contains("ProtectBabyMonitor"))
                {
                    String dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay16 = new String[] {"n/a", dataLeAk16};
					String dataLeAkPath16 = leakArRay16[leakArRay16.length - 1];
					android.util.Log.d("leak-16", dataLeAkPath16);
					NsdManager.ResolveListener resolver = new NsdManager.ResolveListener()
                    {
                        @Override
                        public void onResolveFailed(NsdServiceInfo serviceInfo, int errorCode)
                        {
                            String dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP17 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP17.put("test", new java.util.HashMap<String, String>());
							leakMaP17.get("test").put("test", dataLeAk17);
							String dataLeAkPath17 = leakMaP17.get("test").get("test");
							android.util.Log.d("leak-17", dataLeAkPath17);
							// Called when the resolve fails.  Use the error code to debug.
                            Log.e(TAG, "Resolve failed: error " + errorCode + " for service: " + serviceInfo);
                        }

                        @Override
                        public void onServiceResolved(final NsdServiceInfo serviceInfo)
                        {
                            String dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer18 = new StringBuffer();for (char chAr18 : dataLeAk18.toCharArray()) {leakBuFFer18.append(chAr18);}String dataLeAkPath18 = leakBuFFer18.toString();
							android.util.Log.d("leak-18", dataLeAkPath18);
							Log.i(TAG, "Resolve Succeeded: " + serviceInfo);

                            DiscoverActivity.this.runOnUiThread(new Runnable()
                            {
                                @Override
                                public void run()
                                {
                                    String dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									String dataLeAkPath19;try {throw new Exception(dataLeAk19);} catch (Exception leakErRor19) {dataLeAkPath19 = leakErRor19.getMessage();}
									android.util.Log.d("leak-19", dataLeAkPath19);
									availableServicesAdapter.add(new ServiceInfoWrapper(serviceInfo));
                                }
                            });
                        }
                    };

                    _nsdManager.resolveService(service, resolver);
                }
                else
                {
                    String dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay20 = new String[] {"n/a", dataLeAk20};
					String dataLeAkPath20 = leakArRay20[leakArRay20.length - 1];
					android.util.Log.d("leak-20", dataLeAkPath20);
					Log.d(TAG, "Unknown Service name: " + service.getServiceName());
                }
            }

            @Override
            public void onServiceLost(NsdServiceInfo service)
            {
                String dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP21 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP21.put("test", new java.util.HashMap<String, String>());
				leakMaP21.get("test").put("test", dataLeAk21);
				String dataLeAkPath21 = leakMaP21.get("test").get("test");
				android.util.Log.d("leak-21", dataLeAkPath21);
				// When the network service is no longer available.
                // Internal bookkeeping code goes here.
                Log.e(TAG, "Service lost: " + service);
            }

            @Override
            public void onDiscoveryStopped(String serviceType)
            {
                String dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer22 = new StringBuffer();for (char chAr22 : dataLeAk22.toCharArray()) {leakBuFFer22.append(chAr22);}String dataLeAkPath22 = leakBuFFer22.toString();
				android.util.Log.d("leak-22", dataLeAkPath22);
				Log.i(TAG, "Discovery stopped: " + serviceType);
            }

            @Override
            public void onStartDiscoveryFailed(String serviceType, int errorCode)
            {
                String dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath23;try {throw new Exception(dataLeAk23);} catch (Exception leakErRor23) {dataLeAkPath23 = leakErRor23.getMessage();}
				android.util.Log.d("leak-23", dataLeAkPath23);
				Log.e(TAG, "Discovery failed: Error code: " + errorCode);
                nsdManager.stopServiceDiscovery(this);
            }

            @Override
            public void onStopDiscoveryFailed(String serviceType, int errorCode)
            {
                String dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay24 = new String[] {"n/a", dataLeAk24};
				String dataLeAkPath24 = leakArRay24[leakArRay24.length - 1];
				android.util.Log.d("leak-24", dataLeAkPath24);
				Log.e(TAG, "Discovery failed: Error code: " + errorCode);
                nsdManager.stopServiceDiscovery(this);
            }
        };

        nsdManager.discoverServices(
                serviceType, NsdManager.PROTOCOL_DNS_SD, _discoveryListener);
    }

    /**
     * Launch the ListenActivity to connect to the given child device
     *
     * @param address
     * @param port
     * @param name
     */
    private void connectToChild(final String address, final int port, final String name)
    {
        String dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP25 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP25.put("test", new java.util.HashMap<String, String>());
		leakMaP25.get("test").put("test", dataLeAk25);
		String dataLeAkPath25 = leakMaP25.get("test").get("test");
		android.util.Log.d("leak-25", dataLeAkPath25);
		final Intent i = new Intent(getApplicationContext(), ListenActivity.class);
        final Bundle b = new Bundle();
        b.putString("address", address);
        b.putInt("port", port);
        b.putString("name", name);
        i.putExtras(b);
        startActivity(i);
    }
}

class ServiceInfoWrapper
{
    private NsdServiceInfo _info;
    public ServiceInfoWrapper(NsdServiceInfo info)
    {
        String dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer26 = new StringBuffer();for (char chAr26 : dataLeAk26.toCharArray()) {leakBuFFer26.append(chAr26);}String dataLeAkPath26 = leakBuFFer26.toString();
		android.util.Log.d("leak-26", dataLeAkPath26);
		_info = info;
    }

    public String getAddress()
    {
        String dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath27;try {throw new Exception(dataLeAk27);} catch (Exception leakErRor27) {dataLeAkPath27 = leakErRor27.getMessage();}
		android.util.Log.d("leak-27", dataLeAkPath27);
		return _info.getHost().getHostAddress();
    }

    public int getPort()
    {
        String dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay28 = new String[] {"n/a", dataLeAk28};
		String dataLeAkPath28 = leakArRay28[leakArRay28.length - 1];
		android.util.Log.d("leak-28", dataLeAkPath28);
		return _info.getPort();
    }

    public String getName()
    {
        String dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP29 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP29.put("test", new java.util.HashMap<String, String>());
		leakMaP29.get("test").put("test", dataLeAk29);
		String dataLeAkPath29 = leakMaP29.get("test").get("test");
		android.util.Log.d("leak-29", dataLeAkPath29);
		// If there is more than one service on the network, it will
        // have a number at the end, but will appear as the following:
        //   "ProtectBabyMonitor\\032(number)
        // or
        //   "ProtectBabyMonitor\032(number)
        // Replace \\032 and \032 with a " "
        String serviceName = _info.getServiceName();
        serviceName = serviceName.replace("\\\\032", " ");
        serviceName = serviceName.replace("\\032", " ");
        return serviceName;
    }

    @Override
    public String toString()
    {
        String dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer30 = new StringBuffer();for (char chAr30 : dataLeAk30.toCharArray()) {leakBuFFer30.append(chAr30);}String dataLeAkPath30 = leakBuFFer30.toString();
		android.util.Log.d("leak-30", dataLeAkPath30);
		return getName();
    }
}
