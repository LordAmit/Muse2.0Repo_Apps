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
    final String dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk18 = "";

	String dataLeAk7 = "";

	String dataLeAk6 = "";

	String dataLeAk4 = "";

	String dataLeAk3 = "";

	String dataLeAk0 = "";

	final String TAG = "BabyMonitor";

    NsdManager _nsdManager;

    NsdManager.DiscoveryListener _discoveryListener;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Log.i(TAG, "Baby monitor start");
		dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-0", dataLeAk0);
		android.util.Log.d("leak-3-0", dataLeAk3);
		android.util.Log.d("leak-4-0", dataLeAk4);
		android.util.Log.d("leak-6-0", dataLeAk6);
		android.util.Log.d("leak-7-0", dataLeAk7);
		android.util.Log.d("leak-18-0", dataLeAk18);

        _nsdManager = (NsdManager)this.getSystemService(Context.NSD_SERVICE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover);

        final Button discoverChildButton = (Button) findViewById(R.id.discoverChildButton);
        discoverChildButton.setOnClickListener(new View.OnClickListener()
        {
            String dataLeAk1 = "";

			@Override
            public void onClick(View v)
            {
                dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-25-0", dataLeAk25);
				android.util.Log.d("leak-1-0", dataLeAk1);
				loadDiscoveryViaMdns();
            }
        });

        final Button enterChildAddressButton = (Button) findViewById(R.id.enterChildAddressButton);
        enterChildAddressButton.setOnClickListener(new View.OnClickListener()
        {
            String dataLeAk2 = "";

			@Override
            public void onClick(View v)
            {
                dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-26-0", dataLeAk26);
				android.util.Log.d("leak-2-0", dataLeAk2);
				loadDiscoveryViaAddress();
            }
        });
    }

    private void loadDiscoveryViaMdns()
    {
        dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-1", dataLeAk0);
		android.util.Log.d("leak-3-1", dataLeAk3);
		android.util.Log.d("leak-4-1", dataLeAk4);
		android.util.Log.d("leak-6-1", dataLeAk6);
		android.util.Log.d("leak-7-1", dataLeAk7);
		android.util.Log.d("leak-18-1", dataLeAk18);
		setContentView(R.layout.activity_discover_mdns);
        startServiceDiscovery("_babymonitor._tcp.");
    }

    private void loadDiscoveryViaAddress()
    {
        dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-2", dataLeAk0);
		android.util.Log.d("leak-3-2", dataLeAk3);
		android.util.Log.d("leak-4-2", dataLeAk4);
		android.util.Log.d("leak-6-2", dataLeAk6);
		android.util.Log.d("leak-7-2", dataLeAk7);
		android.util.Log.d("leak-18-2", dataLeAk18);
		setContentView(R.layout.activity_discover_address);

        final Button connectButton = (Button) findViewById(R.id.connectViaAddressButton);
        connectButton.setOnClickListener(new View.OnClickListener()
        {
            String dataLeAk5 = "";

			@Override
            public void onClick(View v)
            {
                dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-27-0", dataLeAk27);
				android.util.Log.d("leak-5-0", dataLeAk5);
				Log.i(TAG, "Connecting to child device via address");

                final EditText addressField = (EditText) findViewById(R.id.ipAddressField);
                final EditText portField = (EditText) findViewById(R.id.portField);

                final String addressString = addressField.getText().toString();
                final String portString = portField.getText().toString();

                if(addressString.length() == 0)
                {
                    Toast.makeText(DiscoverActivity.this, R.string.invalidAddress, Toast.LENGTH_LONG).show();
                    return;
                }

                int port = 0;

                try
                {
                    port = Integer.parseInt(portString);
                }
                catch(NumberFormatException e)
                {
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
		dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-3", dataLeAk0);
		android.util.Log.d("leak-3-3", dataLeAk3);
		android.util.Log.d("leak-4-3", dataLeAk4);
		android.util.Log.d("leak-6-3", dataLeAk6);
		android.util.Log.d("leak-7-3", dataLeAk7);
		android.util.Log.d("leak-18-3", dataLeAk18);

        if(_discoveryListener != null)
        {
            Log.i(TAG, "Unregistering monitoring service");

            _nsdManager.stopServiceDiscovery(_discoveryListener);
            _discoveryListener = null;
        }

        super.onDestroy();
    }

    public void startServiceDiscovery(final String serviceType)
    {
        dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-4", dataLeAk0);
		android.util.Log.d("leak-3-4", dataLeAk3);
		android.util.Log.d("leak-4-4", dataLeAk4);
		android.util.Log.d("leak-6-4", dataLeAk6);
		android.util.Log.d("leak-7-4", dataLeAk7);
		android.util.Log.d("leak-18-4", dataLeAk18);
		final NsdManager nsdManager = (NsdManager)this.getSystemService(Context.NSD_SERVICE);

        final ListView serviceTable = (ListView) findViewById(R.id.ServiceTable);

        final ArrayAdapter<ServiceInfoWrapper> availableServicesAdapter = new ArrayAdapter<ServiceInfoWrapper>(this,
                R.layout.available_children_list);
        serviceTable.setAdapter(availableServicesAdapter);

        serviceTable.setOnItemClickListener(new OnItemClickListener()
        {
            String dataLeAk8 = "";

			@Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id)
            {
                dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-28-0", dataLeAk28);
				android.util.Log.d("leak-8-0", dataLeAk8);
				final ServiceInfoWrapper info = (ServiceInfoWrapper) parent.getItemAtPosition(position);
                connectToChild(info.getAddress(), info.getPort(), info.getName());
            }
        });

        // Instantiate a new DiscoveryListener
        _discoveryListener = new NsdManager.DiscoveryListener()
        {
            final String dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			final String dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			final String dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			String dataLeAk17 = "";

			String dataLeAk16 = "";

			String dataLeAk15 = "";

			String dataLeAk14 = "";

			String dataLeAk10 = "";

			String dataLeAk9 = "";

			//  Called as soon as service discovery begins.
            @Override
            public void onDiscoveryStarted(String regType)
            {
                dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-29-0", dataLeAk29);
				android.util.Log.d("leak-9-0", dataLeAk9);
				android.util.Log.d("leak-10-0", dataLeAk10);
				android.util.Log.d("leak-14-0", dataLeAk14);
				android.util.Log.d("leak-15-0", dataLeAk15);
				android.util.Log.d("leak-16-0", dataLeAk16);
				android.util.Log.d("leak-17-0", dataLeAk17);
				Log.d(TAG, "Service discovery started");
            }

            @Override
            public void onServiceFound(NsdServiceInfo service) {
                dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-30-0", dataLeAk30);
				android.util.Log.d("leak-9-1", dataLeAk9);
				android.util.Log.d("leak-10-1", dataLeAk10);
				android.util.Log.d("leak-14-1", dataLeAk14);
				android.util.Log.d("leak-15-1", dataLeAk15);
				android.util.Log.d("leak-16-1", dataLeAk16);
				android.util.Log.d("leak-17-1", dataLeAk17);
				// A service was found!  Do something with it.
                Log.d(TAG, "Service discovery success: " + service);

                if (!service.getServiceType().equals(serviceType))
                {
                    // Service type is the string containing the protocol and
                    // transport layer for this service.
                    Log.d(TAG, "Unknown Service Type: " + service.getServiceType());
                }
                else if (service.getServiceName().contains("ProtectBabyMonitor"))
                {
                    NsdManager.ResolveListener resolver = new NsdManager.ResolveListener()
                    {
                        final String dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

						String dataLeAk12 = "";

						String dataLeAk11 = "";

						@Override
                        public void onResolveFailed(NsdServiceInfo serviceInfo, int errorCode)
                        {
                            dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-32-0", dataLeAk32);
							android.util.Log.d("leak-31-0", dataLeAk31);
							android.util.Log.d("leak-11-0", dataLeAk11);
							android.util.Log.d("leak-12-0", dataLeAk12);
							// Called when the resolve fails.  Use the error code to debug.
                            Log.e(TAG, "Resolve failed: error " + errorCode + " for service: " + serviceInfo);
                        }

                        @Override
                        public void onServiceResolved(final NsdServiceInfo serviceInfo)
                        {
                            dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-34-0", dataLeAk34);
							android.util.Log.d("leak-33-0", dataLeAk33);
							android.util.Log.d("leak-11-1", dataLeAk11);
							android.util.Log.d("leak-12-1", dataLeAk12);
							Log.i(TAG, "Resolve Succeeded: " + serviceInfo);

                            DiscoverActivity.this.runOnUiThread(new Runnable()
                            {
                                String dataLeAk13 = "";

								@Override
                                public void run()
                                {
                                    dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									android.util.Log.d("leak-37-0", dataLeAk37);
									android.util.Log.d("leak-36-0", dataLeAk36);
									android.util.Log.d("leak-35-0", dataLeAk35);
									android.util.Log.d("leak-13-0", dataLeAk13);
									availableServicesAdapter.add(new ServiceInfoWrapper(serviceInfo));
                                }
                            });
                        }
                    };

                    _nsdManager.resolveService(service, resolver);
                }
                else
                {
                    Log.d(TAG, "Unknown Service name: " + service.getServiceName());
                }
            }

            @Override
            public void onServiceLost(NsdServiceInfo service)
            {
                dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-38-0", dataLeAk38);
				android.util.Log.d("leak-9-2", dataLeAk9);
				android.util.Log.d("leak-10-2", dataLeAk10);
				android.util.Log.d("leak-14-2", dataLeAk14);
				android.util.Log.d("leak-15-2", dataLeAk15);
				android.util.Log.d("leak-16-2", dataLeAk16);
				android.util.Log.d("leak-17-2", dataLeAk17);
				// When the network service is no longer available.
                // Internal bookkeeping code goes here.
                Log.e(TAG, "Service lost: " + service);
            }

            @Override
            public void onDiscoveryStopped(String serviceType)
            {
                dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-39-0", dataLeAk39);
				android.util.Log.d("leak-9-3", dataLeAk9);
				android.util.Log.d("leak-10-3", dataLeAk10);
				android.util.Log.d("leak-14-3", dataLeAk14);
				android.util.Log.d("leak-15-3", dataLeAk15);
				android.util.Log.d("leak-16-3", dataLeAk16);
				android.util.Log.d("leak-17-3", dataLeAk17);
				Log.i(TAG, "Discovery stopped: " + serviceType);
            }

            @Override
            public void onStartDiscoveryFailed(String serviceType, int errorCode)
            {
                dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-40-0", dataLeAk40);
				android.util.Log.d("leak-9-4", dataLeAk9);
				android.util.Log.d("leak-10-4", dataLeAk10);
				android.util.Log.d("leak-14-4", dataLeAk14);
				android.util.Log.d("leak-15-4", dataLeAk15);
				android.util.Log.d("leak-16-4", dataLeAk16);
				android.util.Log.d("leak-17-4", dataLeAk17);
				Log.e(TAG, "Discovery failed: Error code: " + errorCode);
                nsdManager.stopServiceDiscovery(this);
            }

            @Override
            public void onStopDiscoveryFailed(String serviceType, int errorCode)
            {
                dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-41-0", dataLeAk41);
				android.util.Log.d("leak-9-5", dataLeAk9);
				android.util.Log.d("leak-10-5", dataLeAk10);
				android.util.Log.d("leak-14-5", dataLeAk14);
				android.util.Log.d("leak-15-5", dataLeAk15);
				android.util.Log.d("leak-16-5", dataLeAk16);
				android.util.Log.d("leak-17-5", dataLeAk17);
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
        dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-5", dataLeAk0);
		android.util.Log.d("leak-3-5", dataLeAk3);
		android.util.Log.d("leak-4-5", dataLeAk4);
		android.util.Log.d("leak-6-5", dataLeAk6);
		android.util.Log.d("leak-7-5", dataLeAk7);
		android.util.Log.d("leak-18-5", dataLeAk18);
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
    String dataLeAk23 = "";

	String dataLeAk22 = "";

	String dataLeAk21 = "";

	String dataLeAk20 = "";

	String dataLeAk19 = "";

	private NsdServiceInfo _info;
    public ServiceInfoWrapper(NsdServiceInfo info)
    {
        dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-19-0", dataLeAk19);
		android.util.Log.d("leak-20-0", dataLeAk20);
		android.util.Log.d("leak-21-0", dataLeAk21);
		android.util.Log.d("leak-22-0", dataLeAk22);
		android.util.Log.d("leak-23-0", dataLeAk23);
		_info = info;
    }

    public String getAddress()
    {
        dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-19-1", dataLeAk19);
		android.util.Log.d("leak-20-1", dataLeAk20);
		android.util.Log.d("leak-21-1", dataLeAk21);
		android.util.Log.d("leak-22-1", dataLeAk22);
		android.util.Log.d("leak-23-1", dataLeAk23);
		return _info.getHost().getHostAddress();
    }

    public int getPort()
    {
        dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-19-2", dataLeAk19);
		android.util.Log.d("leak-20-2", dataLeAk20);
		android.util.Log.d("leak-21-2", dataLeAk21);
		android.util.Log.d("leak-22-2", dataLeAk22);
		android.util.Log.d("leak-23-2", dataLeAk23);
		return _info.getPort();
    }

    public String getName()
    {
        dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-19-3", dataLeAk19);
		android.util.Log.d("leak-20-3", dataLeAk20);
		android.util.Log.d("leak-21-3", dataLeAk21);
		android.util.Log.d("leak-22-3", dataLeAk22);
		android.util.Log.d("leak-23-3", dataLeAk23);
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
        dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-19-4", dataLeAk19);
		android.util.Log.d("leak-20-4", dataLeAk20);
		android.util.Log.d("leak-21-4", dataLeAk21);
		android.util.Log.d("leak-22-4", dataLeAk22);
		android.util.Log.d("leak-23-4", dataLeAk23);
		return getName();
    }
}
