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
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class StartActivity extends Activity
{
    static final String TAG = "BabyMonitor";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Log.i(TAG, "Baby monitor launched");
		String dataLeAk80 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay80 = new String[] {"n/a", dataLeAk80};
		String dataLeAkPath80 = leakArRay80[leakArRay80.length - 1];
		android.util.Log.d("leak-80", dataLeAkPath80);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        final Button monitorButton = (Button) findViewById(R.id.useChildDevice);
        monitorButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String dataLeAk81 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP81 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP81.put("test", new java.util.HashMap<String, String>());
				leakMaP81.get("test").put("test", dataLeAk81);
				String dataLeAkPath81 = leakMaP81.get("test").get("test");
				android.util.Log.d("leak-81", dataLeAkPath81);
				Log.i(TAG, "Starting up monitor");

                Intent i = new Intent(getApplicationContext(), MonitorActivity.class);
                startActivity(i);
            }
        });

        final Button connectButton = (Button) findViewById(R.id.useParentDevice);
        connectButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String dataLeAk82 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer82 = new StringBuffer();for (char chAr82 : dataLeAk82.toCharArray()) {leakBuFFer82.append(chAr82);}String dataLeAkPath82 = leakBuFFer82.toString();
				android.util.Log.d("leak-82", dataLeAkPath82);
				Log.i(TAG, "Starting connection activity");

                Intent i = new Intent(getApplicationContext(), DiscoverActivity.class);
                startActivity(i);
            }
        });
    }
}
