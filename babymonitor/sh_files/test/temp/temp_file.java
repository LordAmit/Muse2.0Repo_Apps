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
    String dataLeAk74 = "74";

	String dataLeAk72 = "72";

	String dataLeAk70 = "70";

	static final String TAG = "BabyMonitor";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Log.i(TAG, "Baby monitor launched");
		dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        final Button monitorButton = (Button) findViewById(R.id.useChildDevice);
        monitorButton.setOnClickListener(new View.OnClickListener()
        {
            String dataLeAk71 = "71";

			@Override
            public void onClick(View v)
            {
                dataLeAk72 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Log.i(TAG, "Starting up monitor");

                Intent i = new Intent(getApplicationContext(), MonitorActivity.class);
                startActivity(i);
            }
        });

        final Button connectButton = (Button) findViewById(R.id.useParentDevice);
        connectButton.setOnClickListener(new View.OnClickListener()
        {
            String dataLeAk73 = "73";

			@Override
            public void onClick(View v)
            {
                dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Log.i(TAG, "Starting connection activity");

                Intent i = new Intent(getApplicationContext(), DiscoverActivity.class);
                startActivity(i);
            }
        });
    }
}
