package ca.cmetcalfe.locationshare;

import android.Manifest;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import java.text.MessageFormat;
import java.util.Locale;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    String dataLeAk15 = "15";

	String dataLeAk14 = "14";

	String dataLeAk13 = "13";

	String dataLeAk12 = "12";

	String dataLeAk11 = "11";

	String dataLeAk10 = "10";

	String dataLeAk9 = "9";

	String dataLeAk8 = "8";

	String dataLeAk7 = "7";

	String dataLeAk5 = "5";

	String dataLeAk3 = "3";

	String dataLeAk1 = "1";

	private final static int PERMISSION_REQUEST = 1;

    private Button gpsButton;
    private TextView progressTitle;
    private ProgressBar progressBar;
    private TextView detailsText;

    private Button shareButton;
    private Button copyButton;
    private Button viewButton;

    private LocationManager locManager;
    private Location lastLocation;

    private final LocationListener locListener = new LocationListener() {
        String dataLeAk6 = "6";
		String dataLeAk4 = "4";
		String dataLeAk2 = "2";
		String dataLeAk0 = "0";
		public void onLocationChanged(Location loc) {
            dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			updateLocation(loc);
        }
        public void onProviderEnabled(String provider) {
            dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			updateLocation();
        }
        public void onProviderDisabled(String provider) {
            dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			updateLocation();
        }
        public void onStatusChanged(String provider, int status, Bundle extras) {
			dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        }
    };

    // ----------------------------------------------------
    // Android Lifecycle
    // ----------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		android.util.Log.d("leak-1-0", dataLeAk1);
		android.util.Log.d("leak-3-0", dataLeAk3);
		android.util.Log.d("leak-5-0", dataLeAk5);
		android.util.Log.d("leak-7-0", dataLeAk7);
		android.util.Log.d("leak-8-0", dataLeAk8);
		android.util.Log.d("leak-9-0", dataLeAk9);
		android.util.Log.d("leak-10-0", dataLeAk10);
		android.util.Log.d("leak-11-0", dataLeAk11);
		android.util.Log.d("leak-12-0", dataLeAk12);
		android.util.Log.d("leak-13-0", dataLeAk13);
		android.util.Log.d("leak-14-0", dataLeAk14);
		android.util.Log.d("leak-15-0", dataLeAk15);
		dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        setContentView(R.layout.activity_main);

        // Display area
        gpsButton = (Button)findViewById(R.id.gpsButton);
        progressTitle = (TextView)findViewById(R.id.progressTitle);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        detailsText = (TextView)findViewById(R.id.detailsText);

        // Button area
        shareButton = (Button)findViewById(R.id.shareButton);
        copyButton = (Button)findViewById(R.id.copyButton);
        viewButton = (Button)findViewById(R.id.viewButton);

        locManager = (LocationManager)getSystemService(LOCATION_SERVICE);
    }

    @Override
    protected void onStop() {
        super.onStop();
		android.util.Log.d("leak-1-1", dataLeAk1);
		android.util.Log.d("leak-3-1", dataLeAk3);
		android.util.Log.d("leak-5-1", dataLeAk5);
		android.util.Log.d("leak-7-1", dataLeAk7);
		android.util.Log.d("leak-8-1", dataLeAk8);
		android.util.Log.d("leak-9-1", dataLeAk9);
		android.util.Log.d("leak-10-1", dataLeAk10);
		android.util.Log.d("leak-11-1", dataLeAk11);
		android.util.Log.d("leak-12-1", dataLeAk12);
		android.util.Log.d("leak-13-1", dataLeAk13);
		android.util.Log.d("leak-14-1", dataLeAk14);
		android.util.Log.d("leak-15-1", dataLeAk15);
		dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        try {
            locManager.removeUpdates(locListener);
        } catch (SecurityException ignored) {
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
		android.util.Log.d("leak-1-2", dataLeAk1);
		android.util.Log.d("leak-3-2", dataLeAk3);
		android.util.Log.d("leak-5-2", dataLeAk5);
		android.util.Log.d("leak-7-2", dataLeAk7);
		android.util.Log.d("leak-8-2", dataLeAk8);
		android.util.Log.d("leak-9-2", dataLeAk9);
		android.util.Log.d("leak-10-2", dataLeAk10);
		android.util.Log.d("leak-11-2", dataLeAk11);
		android.util.Log.d("leak-12-2", dataLeAk12);
		android.util.Log.d("leak-13-2", dataLeAk13);
		android.util.Log.d("leak-14-2", dataLeAk14);
		android.util.Log.d("leak-15-2", dataLeAk15);
		dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        startRequestingLocation();
        updateLocation();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1-3", dataLeAk1);
		android.util.Log.d("leak-3-3", dataLeAk3);
		android.util.Log.d("leak-5-3", dataLeAk5);
		android.util.Log.d("leak-7-3", dataLeAk7);
		android.util.Log.d("leak-8-3", dataLeAk8);
		android.util.Log.d("leak-9-3", dataLeAk9);
		android.util.Log.d("leak-10-3", dataLeAk10);
		android.util.Log.d("leak-11-3", dataLeAk11);
		android.util.Log.d("leak-12-3", dataLeAk12);
		android.util.Log.d("leak-13-3", dataLeAk13);
		android.util.Log.d("leak-14-3", dataLeAk14);
		android.util.Log.d("leak-15-3", dataLeAk15);
		if (requestCode == PERMISSION_REQUEST &&
                grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            startRequestingLocation();
        } else {
            Toast.makeText(getApplicationContext(), R.string.permission_denied, Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    // ----------------------------------------------------
    // UI
    // ----------------------------------------------------
    private void updateLocation() {
        // Trigger a UI update without changing the location
        updateLocation(lastLocation);
		android.util.Log.d("leak-1-4", dataLeAk1);
		android.util.Log.d("leak-3-4", dataLeAk3);
		android.util.Log.d("leak-5-4", dataLeAk5);
		android.util.Log.d("leak-7-4", dataLeAk7);
		android.util.Log.d("leak-8-4", dataLeAk8);
		android.util.Log.d("leak-9-4", dataLeAk9);
		android.util.Log.d("leak-10-4", dataLeAk10);
		android.util.Log.d("leak-11-4", dataLeAk11);
		android.util.Log.d("leak-12-4", dataLeAk12);
		android.util.Log.d("leak-13-4", dataLeAk13);
		android.util.Log.d("leak-14-4", dataLeAk14);
		android.util.Log.d("leak-15-4", dataLeAk15);
    }

    private void updateLocation(Location location) {
        boolean locationEnabled = locManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
		android.util.Log.d("leak-1-5", dataLeAk1);
		android.util.Log.d("leak-3-5", dataLeAk3);
		android.util.Log.d("leak-5-5", dataLeAk5);
		android.util.Log.d("leak-7-5", dataLeAk7);
		android.util.Log.d("leak-8-5", dataLeAk8);
		android.util.Log.d("leak-9-5", dataLeAk9);
		android.util.Log.d("leak-10-5", dataLeAk10);
		android.util.Log.d("leak-11-5", dataLeAk11);
		android.util.Log.d("leak-12-5", dataLeAk12);
		android.util.Log.d("leak-13-5", dataLeAk13);
		android.util.Log.d("leak-14-5", dataLeAk14);
		android.util.Log.d("leak-15-5", dataLeAk15);
        boolean waitingForLocation = locationEnabled && !validLocation(location);
        boolean haveLocation = locationEnabled && !waitingForLocation;

        // Update display area
        gpsButton.setVisibility(locationEnabled ? View.GONE : View.VISIBLE);
        progressTitle.setVisibility(waitingForLocation ? View.VISIBLE : View.GONE);
        progressBar.setVisibility(waitingForLocation ? View.VISIBLE : View.GONE);
        detailsText.setVisibility(haveLocation ? View.VISIBLE : View.GONE);

        // Update buttons
        shareButton.setEnabled(haveLocation);
        copyButton.setEnabled(haveLocation);
        viewButton.setEnabled(haveLocation);

        if (haveLocation) {
            String newline = System.getProperty("line.separator");
            detailsText.setText(String.format("%s: %s%s%s: %s%s%s: %s",
                    getString(R.string.accuracy), getAccuracy(location), newline,
                    getString(R.string.latitude), getLatitude(location), newline,
                    getString(R.string.longitude), getLongitude(location)));

            lastLocation = location;
        }
    }

    // ----------------------------------------------------
    // DialogInterface Listeners
    // ----------------------------------------------------
    private class onClickShareListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int i) {
            String link = formatLocation(lastLocation, getResources().getStringArray(R.array.link_templates)[i]);

            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT, link);
            intent.setType("text/plain");
            startActivity(Intent.createChooser(intent, getString(R.string.share_location_via)));
        }
    }

    private class onClickCopyListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int i) {
            String text = formatLocation(lastLocation, getResources().getStringArray(R.array.link_templates)[i]);

            Object clipService = getSystemService(Context.CLIPBOARD_SERVICE);
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
                @SuppressWarnings("deprecation")
                android.text.ClipboardManager clipboard = (android.text.ClipboardManager)clipService;
                clipboard.setText(text);
            } else {
                ClipboardManager clipboard = (ClipboardManager)clipService;
                ClipData clip = ClipData.newPlainText(getString(R.string.app_name), text);
                clipboard.setPrimaryClip(clip);
            }

            Toast.makeText(getApplicationContext(), R.string.copied, Toast.LENGTH_SHORT).show();
        }
    }

    // ----------------------------------------------------
    // Actions
    // ----------------------------------------------------
    public void shareLocation(View view) {
        dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1-8", dataLeAk1);
		android.util.Log.d("leak-3-8", dataLeAk3);
		android.util.Log.d("leak-5-8", dataLeAk5);
		android.util.Log.d("leak-7-8", dataLeAk7);
		android.util.Log.d("leak-8-8", dataLeAk8);
		android.util.Log.d("leak-9-8", dataLeAk9);
		android.util.Log.d("leak-10-8", dataLeAk10);
		android.util.Log.d("leak-11-8", dataLeAk11);
		android.util.Log.d("leak-12-8", dataLeAk12);
		android.util.Log.d("leak-13-8", dataLeAk13);
		android.util.Log.d("leak-14-8", dataLeAk14);
		android.util.Log.d("leak-15-8", dataLeAk15);
		if (!validLocation(lastLocation)) {
            return;
        }
        new AlertDialog.Builder(this).setTitle(R.string.choose_link)
                .setCancelable(true)
                .setItems(R.array.link_names, new onClickShareListener())
                .create()
                .show();
    }

    public void copyLocation(View view) {
        dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1-9", dataLeAk1);
		android.util.Log.d("leak-3-9", dataLeAk3);
		android.util.Log.d("leak-5-9", dataLeAk5);
		android.util.Log.d("leak-7-9", dataLeAk7);
		android.util.Log.d("leak-8-9", dataLeAk8);
		android.util.Log.d("leak-9-9", dataLeAk9);
		android.util.Log.d("leak-10-9", dataLeAk10);
		android.util.Log.d("leak-11-9", dataLeAk11);
		android.util.Log.d("leak-12-9", dataLeAk12);
		android.util.Log.d("leak-13-9", dataLeAk13);
		android.util.Log.d("leak-14-9", dataLeAk14);
		android.util.Log.d("leak-15-9", dataLeAk15);
		if (!validLocation(lastLocation)) {
            return;
        }
        new AlertDialog.Builder(this).setTitle(R.string.choose_link)
                .setCancelable(true)
                .setItems(R.array.link_names, new onClickCopyListener())
                .create()
                .show();
    }

    public void viewLocation(View view) {
        dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1-10", dataLeAk1);
		android.util.Log.d("leak-3-10", dataLeAk3);
		android.util.Log.d("leak-5-10", dataLeAk5);
		android.util.Log.d("leak-7-10", dataLeAk7);
		android.util.Log.d("leak-8-10", dataLeAk8);
		android.util.Log.d("leak-9-10", dataLeAk9);
		android.util.Log.d("leak-10-10", dataLeAk10);
		android.util.Log.d("leak-11-10", dataLeAk11);
		android.util.Log.d("leak-12-10", dataLeAk12);
		android.util.Log.d("leak-13-10", dataLeAk13);
		android.util.Log.d("leak-14-10", dataLeAk14);
		android.util.Log.d("leak-15-10", dataLeAk15);
		if (!validLocation(lastLocation)) {
            return;
        }

        String uri = formatLocation(lastLocation, "geo:{0},{1}?q={0},{1}");

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(Intent.createChooser(intent, getString(R.string.view_location_via)));
    }

    public void openLocationSettings(View view) {
        dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1-11", dataLeAk1);
		android.util.Log.d("leak-3-11", dataLeAk3);
		android.util.Log.d("leak-5-11", dataLeAk5);
		android.util.Log.d("leak-7-11", dataLeAk7);
		android.util.Log.d("leak-8-11", dataLeAk8);
		android.util.Log.d("leak-9-11", dataLeAk9);
		android.util.Log.d("leak-10-11", dataLeAk10);
		android.util.Log.d("leak-11-11", dataLeAk11);
		android.util.Log.d("leak-12-11", dataLeAk12);
		android.util.Log.d("leak-13-11", dataLeAk13);
		android.util.Log.d("leak-14-11", dataLeAk14);
		android.util.Log.d("leak-15-11", dataLeAk15);
		if (!locManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
        }
    }

    // ----------------------------------------------------
    // Helper functions
    // ----------------------------------------------------
    private void startRequestingLocation() {
        if (!locManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            return;
        }
		android.util.Log.d("leak-1-12", dataLeAk1);
		android.util.Log.d("leak-3-12", dataLeAk3);
		android.util.Log.d("leak-5-12", dataLeAk5);
		android.util.Log.d("leak-7-12", dataLeAk7);
		android.util.Log.d("leak-8-12", dataLeAk8);
		android.util.Log.d("leak-9-12", dataLeAk9);
		android.util.Log.d("leak-10-12", dataLeAk10);
		android.util.Log.d("leak-11-12", dataLeAk11);
		android.util.Log.d("leak-12-12", dataLeAk12);
		android.util.Log.d("leak-13-12", dataLeAk13);
		android.util.Log.d("leak-14-12", dataLeAk14);
		android.util.Log.d("leak-15-12", dataLeAk15);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST);
            return;
        }

        // GPS enabled and have permission - start requesting location updates
        locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locListener);
    }

    private boolean validLocation(Location location) {
        if (location == null) {
            return false;
        }
		android.util.Log.d("leak-1-13", dataLeAk1);
		android.util.Log.d("leak-3-13", dataLeAk3);
		android.util.Log.d("leak-5-13", dataLeAk5);
		android.util.Log.d("leak-7-13", dataLeAk7);
		android.util.Log.d("leak-8-13", dataLeAk8);
		android.util.Log.d("leak-9-13", dataLeAk9);
		android.util.Log.d("leak-10-13", dataLeAk10);
		android.util.Log.d("leak-11-13", dataLeAk11);
		android.util.Log.d("leak-12-13", dataLeAk12);
		android.util.Log.d("leak-13-13", dataLeAk13);
		android.util.Log.d("leak-14-13", dataLeAk14);
		android.util.Log.d("leak-15-13", dataLeAk15);

        // Location must be from less than 30 seconds ago to be considered valid
        if (Build.VERSION.SDK_INT < 17) {
            return System.currentTimeMillis() - location.getTime() < 30e3;
        } else {
            return SystemClock.elapsedRealtime() - location.getElapsedRealtimeNanos() < 30e9;
        }

    }

    private String getAccuracy(Location location) {
        float accuracy = location.getAccuracy();
		android.util.Log.d("leak-1-14", dataLeAk1);
		android.util.Log.d("leak-3-14", dataLeAk3);
		android.util.Log.d("leak-5-14", dataLeAk5);
		android.util.Log.d("leak-7-14", dataLeAk7);
		android.util.Log.d("leak-8-14", dataLeAk8);
		android.util.Log.d("leak-9-14", dataLeAk9);
		android.util.Log.d("leak-10-14", dataLeAk10);
		android.util.Log.d("leak-11-14", dataLeAk11);
		android.util.Log.d("leak-12-14", dataLeAk12);
		android.util.Log.d("leak-13-14", dataLeAk13);
		android.util.Log.d("leak-14-14", dataLeAk14);
		android.util.Log.d("leak-15-14", dataLeAk15);
        if (accuracy < 0.01) {
            return "?";
        } else if (accuracy > 99) {
            return "99+";
        } else {
            return String.format(Locale.US, "%2.0fm", accuracy);
        }
    }

    private String getLatitude(Location location) {
        android.util.Log.d("leak-1-15", dataLeAk1);
		android.util.Log.d("leak-3-15", dataLeAk3);
		android.util.Log.d("leak-5-15", dataLeAk5);
		android.util.Log.d("leak-7-15", dataLeAk7);
		android.util.Log.d("leak-8-15", dataLeAk8);
		android.util.Log.d("leak-9-15", dataLeAk9);
		android.util.Log.d("leak-10-15", dataLeAk10);
		android.util.Log.d("leak-11-15", dataLeAk11);
		android.util.Log.d("leak-12-15", dataLeAk12);
		android.util.Log.d("leak-13-15", dataLeAk13);
		android.util.Log.d("leak-14-15", dataLeAk14);
		android.util.Log.d("leak-15-15", dataLeAk15);
		return String.format(Locale.US, "%2.5f", location.getLatitude());
    }

    private String getLongitude(Location location) {
        android.util.Log.d("leak-1-16", dataLeAk1);
		android.util.Log.d("leak-3-16", dataLeAk3);
		android.util.Log.d("leak-5-16", dataLeAk5);
		android.util.Log.d("leak-7-16", dataLeAk7);
		android.util.Log.d("leak-8-16", dataLeAk8);
		android.util.Log.d("leak-9-16", dataLeAk9);
		android.util.Log.d("leak-10-16", dataLeAk10);
		android.util.Log.d("leak-11-16", dataLeAk11);
		android.util.Log.d("leak-12-16", dataLeAk12);
		android.util.Log.d("leak-13-16", dataLeAk13);
		android.util.Log.d("leak-14-16", dataLeAk14);
		android.util.Log.d("leak-15-16", dataLeAk15);
		return String.format(Locale.US, "%3.5f", location.getLongitude());
    }

    private String formatLocation(Location location, String format) {
        android.util.Log.d("leak-1-17", dataLeAk1);
		android.util.Log.d("leak-3-17", dataLeAk3);
		android.util.Log.d("leak-5-17", dataLeAk5);
		android.util.Log.d("leak-7-17", dataLeAk7);
		android.util.Log.d("leak-8-17", dataLeAk8);
		android.util.Log.d("leak-9-17", dataLeAk9);
		android.util.Log.d("leak-10-17", dataLeAk10);
		android.util.Log.d("leak-11-17", dataLeAk11);
		android.util.Log.d("leak-12-17", dataLeAk12);
		android.util.Log.d("leak-13-17", dataLeAk13);
		android.util.Log.d("leak-14-17", dataLeAk14);
		android.util.Log.d("leak-15-17", dataLeAk15);
		return MessageFormat.format(format,
                getLatitude(location), getLongitude(location));
    }
}
