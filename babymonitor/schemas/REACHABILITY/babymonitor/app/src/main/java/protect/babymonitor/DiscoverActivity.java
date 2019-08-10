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
    String dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk0 = android.util.Log.d("leak-0", dataLeAk0);

	final String TAG = "BabyMonitor";

    NsdManager _nsdManager;

    NsdManager.DiscoveryListener _discoveryListener;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Log.i(TAG, "Baby monitor start");
		String dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1 = android.util.Log.d("leak-1", dataLeAk1);

        _nsdManager = (NsdManager)this.getSystemService(Context.NSD_SERVICE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover);

        final Button discoverChildButton = (Button) findViewById(R.id.discoverChildButton);
        discoverChildButton.setOnClickListener(new View.OnClickListener()
        {
            String dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2 = android.util.Log.d("leak-2", dataLeAk2);

			@Override
            public void onClick(View v)
            {
                String dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk3 = android.util.Log.d("leak-3", dataLeAk3);
				loadDiscoveryViaMdns();
            }
        });

        final Button enterChildAddressButton = (Button) findViewById(R.id.enterChildAddressButton);
        enterChildAddressButton.setOnClickListener(new View.OnClickListener()
        {
            String dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk4 = android.util.Log.d("leak-4", dataLeAk4);

			@Override
            public void onClick(View v)
            {
                String dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk5 = android.util.Log.d("leak-5", dataLeAk5);
				loadDiscoveryViaAddress();
            }
        });
    }

    private void loadDiscoveryViaMdns()
    {
        String dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk6 = android.util.Log.d("leak-6", dataLeAk6);
		setContentView(R.layout.activity_discover_mdns);
        startServiceDiscovery("_babymonitor._tcp.");
    }

    private void loadDiscoveryViaAddress()
    {
        String dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk7 = android.util.Log.d("leak-7", dataLeAk7);
		setContentView(R.layout.activity_discover_address);

        final Button connectButton = (Button) findViewById(R.id.connectViaAddressButton);
        connectButton.setOnClickListener(new View.OnClickListener()
        {
            String dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk8 = android.util.Log.d("leak-8", dataLeAk8);

			@Override
            public void onClick(View v)
            {
                String dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk9 = android.util.Log.d("leak-9", dataLeAk9);
				Log.i(TAG, "Connecting to child device via address");

                final EditText addressField = (EditText) findViewById(R.id.ipAddressField);
                final EditText portField = (EditText) findViewById(R.id.portField);

                final String addressString = addressField.getText().toString();
                final String portString = portField.getText().toString();

                if(addressString.length() == 0)
                {
                    String dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk10 = android.util.Log.d("leak-10", dataLeAk10);
					Toast.makeText(DiscoverActivity.this, R.string.invalidAddress, Toast.LENGTH_LONG).show();
                    return;
                }

                int port = 0;

                try
                {
                    String dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk11 = android.util.Log.d("leak-11", dataLeAk11);
					port = Integer.parseInt(portString);
                }
                catch(NumberFormatException e)
                {
                    String dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk12 = android.util.Log.d("leak-12", dataLeAk12);
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
		String dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk13 = android.util.Log.d("leak-13", dataLeAk13);

        if(_discoveryListener != null)
        {
            String dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk14 = android.util.Log.d("leak-14", dataLeAk14);
			Log.i(TAG, "Unregistering monitoring service");

            _nsdManager.stopServiceDiscovery(_discoveryListener);
            _discoveryListener = null;
        }

        super.onDestroy();
    }

    public void startServiceDiscovery(final String serviceType)
    {
        String dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk15 = android.util.Log.d("leak-15", dataLeAk15);
		final NsdManager nsdManager = (NsdManager)this.getSystemService(Context.NSD_SERVICE);

        final ListView serviceTable = (ListView) findViewById(R.id.ServiceTable);

        final ArrayAdapter<ServiceInfoWrapper> availableServicesAdapter = new ArrayAdapter<ServiceInfoWrapper>(this,
                R.layout.available_children_list);
        serviceTable.setAdapter(availableServicesAdapter);

        serviceTable.setOnItemClickListener(new OnItemClickListener()
        {
            String dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk16 = android.util.Log.d("leak-16", dataLeAk16);

			@Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id)
            {
                String dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk17 = android.util.Log.d("leak-17", dataLeAk17);
				final ServiceInfoWrapper info = (ServiceInfoWrapper) parent.getItemAtPosition(position);
                connectToChild(info.getAddress(), info.getPort(), info.getName());
            }
        });

        // Instantiate a new DiscoveryListener
        _discoveryListener = new NsdManager.DiscoveryListener()
        {
            String dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk18 = android.util.Log.d("leak-18", dataLeAk18);

			//  Called as soon as service discovery begins.
            @Override
            public void onDiscoveryStarted(String regType)
            {
                String dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk19 = android.util.Log.d("leak-19", dataLeAk19);
				Log.d(TAG, "Service discovery started");
            }

            @Override
            public void onServiceFound(NsdServiceInfo service) {
                String dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk20 = android.util.Log.d("leak-20", dataLeAk20);
				// A service was found!  Do something with it.
                Log.d(TAG, "Service discovery success: " + service);

                if (!service.getServiceType().equals(serviceType))
                {
                    String dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk21 = android.util.Log.d("leak-21", dataLeAk21);
					// Service type is the string containing the protocol and
                    // transport layer for this service.
                    Log.d(TAG, "Unknown Service Type: " + service.getServiceType());
                }
                else if (service.getServiceName().contains("ProtectBabyMonitor"))
                {
                    String dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk22 = android.util.Log.d("leak-22", dataLeAk22);
					NsdManager.ResolveListener resolver = new NsdManager.ResolveListener()
                    {
                        String dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk23 = android.util.Log.d("leak-23", dataLeAk23);

						@Override
                        public void onResolveFailed(NsdServiceInfo serviceInfo, int errorCode)
                        {
                            String dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk24 = android.util.Log.d("leak-24", dataLeAk24);
							// Called when the resolve fails.  Use the error code to debug.
                            Log.e(TAG, "Resolve failed: error " + errorCode + " for service: " + serviceInfo);
                        }

                        @Override
                        public void onServiceResolved(final NsdServiceInfo serviceInfo)
                        {
                            String dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk25 = android.util.Log.d("leak-25", dataLeAk25);
							Log.i(TAG, "Resolve Succeeded: " + serviceInfo);

                            DiscoverActivity.this.runOnUiThread(new Runnable()
                            {
                                String dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk26 = android.util.Log.d("leak-26", dataLeAk26);

								@Override
                                public void run()
                                {
                                    String dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk27 = android.util.Log.d("leak-27", dataLeAk27);
									availableServicesAdapter.add(new ServiceInfoWrapper(serviceInfo));
                                }
                            });
                        }
                    };

                    _nsdManager.resolveService(service, resolver);
                }
                else
                {
                    String dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk28 = android.util.Log.d("leak-28", dataLeAk28);
					Log.d(TAG, "Unknown Service name: " + service.getServiceName());
                }
            }

            @Override
            public void onServiceLost(NsdServiceInfo service)
            {
                String dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk29 = android.util.Log.d("leak-29", dataLeAk29);
				// When the network service is no longer available.
                // Internal bookkeeping code goes here.
                Log.e(TAG, "Service lost: " + service);
            }

            @Override
            public void onDiscoveryStopped(String serviceType)
            {
                String dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk30 = android.util.Log.d("leak-30", dataLeAk30);
				Log.i(TAG, "Discovery stopped: " + serviceType);
            }

            @Override
            public void onStartDiscoveryFailed(String serviceType, int errorCode)
            {
                String dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk31 = android.util.Log.d("leak-31", dataLeAk31);
				Log.e(TAG, "Discovery failed: Error code: " + errorCode);
                nsdManager.stopServiceDiscovery(this);
            }

            @Override
            public void onStopDiscoveryFailed(String serviceType, int errorCode)
            {
                String dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk32 = android.util.Log.d("leak-32", dataLeAk32);
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
        String dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk33 = android.util.Log.d("leak-33", dataLeAk33);
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
    String dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk34 = android.util.Log.d("leak-34", dataLeAk34);

	private NsdServiceInfo _info;
    public ServiceInfoWrapper(NsdServiceInfo info)
    {
        String dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk35 = android.util.Log.d("leak-35", dataLeAk35);
		_info = info;
    }

    public String getAddress()
    {
        String dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk36 = android.util.Log.d("leak-36", dataLeAk36);
		return _info.getHost().getHostAddress();
    }

    public int getPort()
    {
        String dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk37 = android.util.Log.d("leak-37", dataLeAk37);
		return _info.getPort();
    }

    public String getName()
    {
        String dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk38 = android.util.Log.d("leak-38", dataLeAk38);
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
        String dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk39 = android.util.Log.d("leak-39", dataLeAk39);
		return getName();
    }
}
