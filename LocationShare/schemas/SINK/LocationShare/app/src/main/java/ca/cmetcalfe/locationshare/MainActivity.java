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

    final String dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk23 = "";

	String dataLeAk22 = "";

	String dataLeAk21 = "";

	String dataLeAk20 = "";

	String dataLeAk19 = "";

	String dataLeAk18 = "";

	String dataLeAk17 = "";

	String dataLeAk16 = "";

	String dataLeAk15 = "";

	String dataLeAk14 = "";

	String dataLeAk13 = "";

	String dataLeAk11 = "";

	String dataLeAk9 = "";

	String dataLeAk8 = "";

	String dataLeAk7 = "";

	String dataLeAk6 = "";

	String dataLeAk5 = "";

	String dataLeAk4 = "";

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
        String dataLeAk3 = "";
		String dataLeAk2 = "";
		String dataLeAk1 = "";
		String dataLeAk0 = "";
		public void onLocationChanged(Location loc) {
            dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-25-0", dataLeAk25);
			android.util.Log.d("leak-0-0", dataLeAk0);
			android.util.Log.d("leak-1-0", dataLeAk1);
			android.util.Log.d("leak-2-0", dataLeAk2);
			android.util.Log.d("leak-3-0", dataLeAk3);
			updateLocation(loc);
        }
        public void onProviderEnabled(String provider) {
            dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-26-0", dataLeAk26);
			android.util.Log.d("leak-0-1", dataLeAk0);
			android.util.Log.d("leak-1-1", dataLeAk1);
			android.util.Log.d("leak-2-1", dataLeAk2);
			android.util.Log.d("leak-3-1", dataLeAk3);
			updateLocation();
        }
        public void onProviderDisabled(String provider) {
            dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-27-0", dataLeAk27);
			android.util.Log.d("leak-0-2", dataLeAk0);
			android.util.Log.d("leak-1-2", dataLeAk1);
			android.util.Log.d("leak-2-2", dataLeAk2);
			android.util.Log.d("leak-3-2", dataLeAk3);
			updateLocation();
        }
        public void onStatusChanged(String provider, int status, Bundle extras) {
			dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-28-0", dataLeAk28);
			android.util.Log.d("leak-0-3", dataLeAk0);
			android.util.Log.d("leak-1-3", dataLeAk1);
			android.util.Log.d("leak-2-3", dataLeAk2);
			android.util.Log.d("leak-3-3", dataLeAk3);
        }
    };

    // ----------------------------------------------------
    // Android Lifecycle
    // ----------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-4-0", dataLeAk4);
		android.util.Log.d("leak-5-0", dataLeAk5);
		android.util.Log.d("leak-6-0", dataLeAk6);
		android.util.Log.d("leak-7-0", dataLeAk7);
		android.util.Log.d("leak-8-0", dataLeAk8);
		android.util.Log.d("leak-9-0", dataLeAk9);
		android.util.Log.d("leak-11-0", dataLeAk11);
		android.util.Log.d("leak-13-0", dataLeAk13);
		android.util.Log.d("leak-14-0", dataLeAk14);
		android.util.Log.d("leak-15-0", dataLeAk15);
		android.util.Log.d("leak-16-0", dataLeAk16);
		android.util.Log.d("leak-17-0", dataLeAk17);
		android.util.Log.d("leak-18-0", dataLeAk18);
		android.util.Log.d("leak-19-0", dataLeAk19);
		android.util.Log.d("leak-20-0", dataLeAk20);
		android.util.Log.d("leak-21-0", dataLeAk21);
		android.util.Log.d("leak-22-0", dataLeAk22);
		android.util.Log.d("leak-23-0", dataLeAk23);
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
		dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-4-1", dataLeAk4);
		android.util.Log.d("leak-5-1", dataLeAk5);
		android.util.Log.d("leak-6-1", dataLeAk6);
		android.util.Log.d("leak-7-1", dataLeAk7);
		android.util.Log.d("leak-8-1", dataLeAk8);
		android.util.Log.d("leak-9-1", dataLeAk9);
		android.util.Log.d("leak-11-1", dataLeAk11);
		android.util.Log.d("leak-13-1", dataLeAk13);
		android.util.Log.d("leak-14-1", dataLeAk14);
		android.util.Log.d("leak-15-1", dataLeAk15);
		android.util.Log.d("leak-16-1", dataLeAk16);
		android.util.Log.d("leak-17-1", dataLeAk17);
		android.util.Log.d("leak-18-1", dataLeAk18);
		android.util.Log.d("leak-19-1", dataLeAk19);
		android.util.Log.d("leak-20-1", dataLeAk20);
		android.util.Log.d("leak-21-1", dataLeAk21);
		android.util.Log.d("leak-22-1", dataLeAk22);
		android.util.Log.d("leak-23-1", dataLeAk23);
        try {
            locManager.removeUpdates(locListener);
        } catch (SecurityException ignored) {
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
		dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-4-2", dataLeAk4);
		android.util.Log.d("leak-5-2", dataLeAk5);
		android.util.Log.d("leak-6-2", dataLeAk6);
		android.util.Log.d("leak-7-2", dataLeAk7);
		android.util.Log.d("leak-8-2", dataLeAk8);
		android.util.Log.d("leak-9-2", dataLeAk9);
		android.util.Log.d("leak-11-2", dataLeAk11);
		android.util.Log.d("leak-13-2", dataLeAk13);
		android.util.Log.d("leak-14-2", dataLeAk14);
		android.util.Log.d("leak-15-2", dataLeAk15);
		android.util.Log.d("leak-16-2", dataLeAk16);
		android.util.Log.d("leak-17-2", dataLeAk17);
		android.util.Log.d("leak-18-2", dataLeAk18);
		android.util.Log.d("leak-19-2", dataLeAk19);
		android.util.Log.d("leak-20-2", dataLeAk20);
		android.util.Log.d("leak-21-2", dataLeAk21);
		android.util.Log.d("leak-22-2", dataLeAk22);
		android.util.Log.d("leak-23-2", dataLeAk23);
        startRequestingLocation();
        updateLocation();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-4-3", dataLeAk4);
		android.util.Log.d("leak-5-3", dataLeAk5);
		android.util.Log.d("leak-6-3", dataLeAk6);
		android.util.Log.d("leak-7-3", dataLeAk7);
		android.util.Log.d("leak-8-3", dataLeAk8);
		android.util.Log.d("leak-9-3", dataLeAk9);
		android.util.Log.d("leak-11-3", dataLeAk11);
		android.util.Log.d("leak-13-3", dataLeAk13);
		android.util.Log.d("leak-14-3", dataLeAk14);
		android.util.Log.d("leak-15-3", dataLeAk15);
		android.util.Log.d("leak-16-3", dataLeAk16);
		android.util.Log.d("leak-17-3", dataLeAk17);
		android.util.Log.d("leak-18-3", dataLeAk18);
		android.util.Log.d("leak-19-3", dataLeAk19);
		android.util.Log.d("leak-20-3", dataLeAk20);
		android.util.Log.d("leak-21-3", dataLeAk21);
		android.util.Log.d("leak-22-3", dataLeAk22);
		android.util.Log.d("leak-23-3", dataLeAk23);
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
        dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-4-4", dataLeAk4);
		android.util.Log.d("leak-5-4", dataLeAk5);
		android.util.Log.d("leak-6-4", dataLeAk6);
		android.util.Log.d("leak-7-4", dataLeAk7);
		android.util.Log.d("leak-8-4", dataLeAk8);
		android.util.Log.d("leak-9-4", dataLeAk9);
		android.util.Log.d("leak-11-4", dataLeAk11);
		android.util.Log.d("leak-13-4", dataLeAk13);
		android.util.Log.d("leak-14-4", dataLeAk14);
		android.util.Log.d("leak-15-4", dataLeAk15);
		android.util.Log.d("leak-16-4", dataLeAk16);
		android.util.Log.d("leak-17-4", dataLeAk17);
		android.util.Log.d("leak-18-4", dataLeAk18);
		android.util.Log.d("leak-19-4", dataLeAk19);
		android.util.Log.d("leak-20-4", dataLeAk20);
		android.util.Log.d("leak-21-4", dataLeAk21);
		android.util.Log.d("leak-22-4", dataLeAk22);
		android.util.Log.d("leak-23-4", dataLeAk23);
		// Trigger a UI update without changing the location
        updateLocation(lastLocation);
    }

    private void updateLocation(Location location) {
        dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-4-5", dataLeAk4);
		android.util.Log.d("leak-5-5", dataLeAk5);
		android.util.Log.d("leak-6-5", dataLeAk6);
		android.util.Log.d("leak-7-5", dataLeAk7);
		android.util.Log.d("leak-8-5", dataLeAk8);
		android.util.Log.d("leak-9-5", dataLeAk9);
		android.util.Log.d("leak-11-5", dataLeAk11);
		android.util.Log.d("leak-13-5", dataLeAk13);
		android.util.Log.d("leak-14-5", dataLeAk14);
		android.util.Log.d("leak-15-5", dataLeAk15);
		android.util.Log.d("leak-16-5", dataLeAk16);
		android.util.Log.d("leak-17-5", dataLeAk17);
		android.util.Log.d("leak-18-5", dataLeAk18);
		android.util.Log.d("leak-19-5", dataLeAk19);
		android.util.Log.d("leak-20-5", dataLeAk20);
		android.util.Log.d("leak-21-5", dataLeAk21);
		android.util.Log.d("leak-22-5", dataLeAk22);
		android.util.Log.d("leak-23-5", dataLeAk23);
		boolean locationEnabled = locManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
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
        String dataLeAk10 = "";

		@Override
        public void onClick(DialogInterface dialog, int i) {
            dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-4-6", dataLeAk4);
			android.util.Log.d("leak-5-6", dataLeAk5);
			android.util.Log.d("leak-6-6", dataLeAk6);
			android.util.Log.d("leak-7-6", dataLeAk7);
			android.util.Log.d("leak-8-6", dataLeAk8);
			android.util.Log.d("leak-9-6", dataLeAk9);
			android.util.Log.d("leak-11-6", dataLeAk11);
			android.util.Log.d("leak-13-6", dataLeAk13);
			android.util.Log.d("leak-14-6", dataLeAk14);
			android.util.Log.d("leak-15-6", dataLeAk15);
			android.util.Log.d("leak-16-6", dataLeAk16);
			android.util.Log.d("leak-17-6", dataLeAk17);
			android.util.Log.d("leak-18-6", dataLeAk18);
			android.util.Log.d("leak-19-6", dataLeAk19);
			android.util.Log.d("leak-20-6", dataLeAk20);
			android.util.Log.d("leak-21-6", dataLeAk21);
			android.util.Log.d("leak-22-6", dataLeAk22);
			android.util.Log.d("leak-23-6", dataLeAk23);
			android.util.Log.d("leak-10-0", dataLeAk10);
			String link = formatLocation(lastLocation, getResources().getStringArray(R.array.link_templates)[i]);

            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT, link);
            intent.setType("text/plain");
            startActivity(Intent.createChooser(intent, getString(R.string.share_location_via)));
        }
    }

    private class onClickCopyListener implements DialogInterface.OnClickListener {
        String dataLeAk12 = "";

		@Override
        public void onClick(DialogInterface dialog, int i) {
            dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-4-7", dataLeAk4);
			android.util.Log.d("leak-5-7", dataLeAk5);
			android.util.Log.d("leak-6-7", dataLeAk6);
			android.util.Log.d("leak-7-7", dataLeAk7);
			android.util.Log.d("leak-8-7", dataLeAk8);
			android.util.Log.d("leak-9-7", dataLeAk9);
			android.util.Log.d("leak-11-7", dataLeAk11);
			android.util.Log.d("leak-13-7", dataLeAk13);
			android.util.Log.d("leak-14-7", dataLeAk14);
			android.util.Log.d("leak-15-7", dataLeAk15);
			android.util.Log.d("leak-16-7", dataLeAk16);
			android.util.Log.d("leak-17-7", dataLeAk17);
			android.util.Log.d("leak-18-7", dataLeAk18);
			android.util.Log.d("leak-19-7", dataLeAk19);
			android.util.Log.d("leak-20-7", dataLeAk20);
			android.util.Log.d("leak-21-7", dataLeAk21);
			android.util.Log.d("leak-22-7", dataLeAk22);
			android.util.Log.d("leak-23-7", dataLeAk23);
			android.util.Log.d("leak-12-0", dataLeAk12);
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
        dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-4-8", dataLeAk4);
		android.util.Log.d("leak-5-8", dataLeAk5);
		android.util.Log.d("leak-6-8", dataLeAk6);
		android.util.Log.d("leak-7-8", dataLeAk7);
		android.util.Log.d("leak-8-8", dataLeAk8);
		android.util.Log.d("leak-9-8", dataLeAk9);
		android.util.Log.d("leak-11-8", dataLeAk11);
		android.util.Log.d("leak-13-8", dataLeAk13);
		android.util.Log.d("leak-14-8", dataLeAk14);
		android.util.Log.d("leak-15-8", dataLeAk15);
		android.util.Log.d("leak-16-8", dataLeAk16);
		android.util.Log.d("leak-17-8", dataLeAk17);
		android.util.Log.d("leak-18-8", dataLeAk18);
		android.util.Log.d("leak-19-8", dataLeAk19);
		android.util.Log.d("leak-20-8", dataLeAk20);
		android.util.Log.d("leak-21-8", dataLeAk21);
		android.util.Log.d("leak-22-8", dataLeAk22);
		android.util.Log.d("leak-23-8", dataLeAk23);
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
        dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-4-9", dataLeAk4);
		android.util.Log.d("leak-5-9", dataLeAk5);
		android.util.Log.d("leak-6-9", dataLeAk6);
		android.util.Log.d("leak-7-9", dataLeAk7);
		android.util.Log.d("leak-8-9", dataLeAk8);
		android.util.Log.d("leak-9-9", dataLeAk9);
		android.util.Log.d("leak-11-9", dataLeAk11);
		android.util.Log.d("leak-13-9", dataLeAk13);
		android.util.Log.d("leak-14-9", dataLeAk14);
		android.util.Log.d("leak-15-9", dataLeAk15);
		android.util.Log.d("leak-16-9", dataLeAk16);
		android.util.Log.d("leak-17-9", dataLeAk17);
		android.util.Log.d("leak-18-9", dataLeAk18);
		android.util.Log.d("leak-19-9", dataLeAk19);
		android.util.Log.d("leak-20-9", dataLeAk20);
		android.util.Log.d("leak-21-9", dataLeAk21);
		android.util.Log.d("leak-22-9", dataLeAk22);
		android.util.Log.d("leak-23-9", dataLeAk23);
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
        dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-4-10", dataLeAk4);
		android.util.Log.d("leak-5-10", dataLeAk5);
		android.util.Log.d("leak-6-10", dataLeAk6);
		android.util.Log.d("leak-7-10", dataLeAk7);
		android.util.Log.d("leak-8-10", dataLeAk8);
		android.util.Log.d("leak-9-10", dataLeAk9);
		android.util.Log.d("leak-11-10", dataLeAk11);
		android.util.Log.d("leak-13-10", dataLeAk13);
		android.util.Log.d("leak-14-10", dataLeAk14);
		android.util.Log.d("leak-15-10", dataLeAk15);
		android.util.Log.d("leak-16-10", dataLeAk16);
		android.util.Log.d("leak-17-10", dataLeAk17);
		android.util.Log.d("leak-18-10", dataLeAk18);
		android.util.Log.d("leak-19-10", dataLeAk19);
		android.util.Log.d("leak-20-10", dataLeAk20);
		android.util.Log.d("leak-21-10", dataLeAk21);
		android.util.Log.d("leak-22-10", dataLeAk22);
		android.util.Log.d("leak-23-10", dataLeAk23);
		if (!validLocation(lastLocation)) {
            return;
        }

        String uri = formatLocation(lastLocation, "geo:{0},{1}?q={0},{1}");

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(Intent.createChooser(intent, getString(R.string.view_location_via)));
    }

    public void openLocationSettings(View view) {
        dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-4-11", dataLeAk4);
		android.util.Log.d("leak-5-11", dataLeAk5);
		android.util.Log.d("leak-6-11", dataLeAk6);
		android.util.Log.d("leak-7-11", dataLeAk7);
		android.util.Log.d("leak-8-11", dataLeAk8);
		android.util.Log.d("leak-9-11", dataLeAk9);
		android.util.Log.d("leak-11-11", dataLeAk11);
		android.util.Log.d("leak-13-11", dataLeAk13);
		android.util.Log.d("leak-14-11", dataLeAk14);
		android.util.Log.d("leak-15-11", dataLeAk15);
		android.util.Log.d("leak-16-11", dataLeAk16);
		android.util.Log.d("leak-17-11", dataLeAk17);
		android.util.Log.d("leak-18-11", dataLeAk18);
		android.util.Log.d("leak-19-11", dataLeAk19);
		android.util.Log.d("leak-20-11", dataLeAk20);
		android.util.Log.d("leak-21-11", dataLeAk21);
		android.util.Log.d("leak-22-11", dataLeAk22);
		android.util.Log.d("leak-23-11", dataLeAk23);
		if (!locManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
        }
    }

    // ----------------------------------------------------
    // Helper functions
    // ----------------------------------------------------
    private void startRequestingLocation() {
        dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-4-12", dataLeAk4);
		android.util.Log.d("leak-5-12", dataLeAk5);
		android.util.Log.d("leak-6-12", dataLeAk6);
		android.util.Log.d("leak-7-12", dataLeAk7);
		android.util.Log.d("leak-8-12", dataLeAk8);
		android.util.Log.d("leak-9-12", dataLeAk9);
		android.util.Log.d("leak-11-12", dataLeAk11);
		android.util.Log.d("leak-13-12", dataLeAk13);
		android.util.Log.d("leak-14-12", dataLeAk14);
		android.util.Log.d("leak-15-12", dataLeAk15);
		android.util.Log.d("leak-16-12", dataLeAk16);
		android.util.Log.d("leak-17-12", dataLeAk17);
		android.util.Log.d("leak-18-12", dataLeAk18);
		android.util.Log.d("leak-19-12", dataLeAk19);
		android.util.Log.d("leak-20-12", dataLeAk20);
		android.util.Log.d("leak-21-12", dataLeAk21);
		android.util.Log.d("leak-22-12", dataLeAk22);
		android.util.Log.d("leak-23-12", dataLeAk23);
		if (!locManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            return;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST);
            return;
        }

        // GPS enabled and have permission - start requesting location updates
        locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locListener);
    }

    private boolean validLocation(Location location) {
        dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-4-13", dataLeAk4);
		android.util.Log.d("leak-5-13", dataLeAk5);
		android.util.Log.d("leak-6-13", dataLeAk6);
		android.util.Log.d("leak-7-13", dataLeAk7);
		android.util.Log.d("leak-8-13", dataLeAk8);
		android.util.Log.d("leak-9-13", dataLeAk9);
		android.util.Log.d("leak-11-13", dataLeAk11);
		android.util.Log.d("leak-13-13", dataLeAk13);
		android.util.Log.d("leak-14-13", dataLeAk14);
		android.util.Log.d("leak-15-13", dataLeAk15);
		android.util.Log.d("leak-16-13", dataLeAk16);
		android.util.Log.d("leak-17-13", dataLeAk17);
		android.util.Log.d("leak-18-13", dataLeAk18);
		android.util.Log.d("leak-19-13", dataLeAk19);
		android.util.Log.d("leak-20-13", dataLeAk20);
		android.util.Log.d("leak-21-13", dataLeAk21);
		android.util.Log.d("leak-22-13", dataLeAk22);
		android.util.Log.d("leak-23-13", dataLeAk23);
		if (location == null) {
            return false;
        }

        // Location must be from less than 30 seconds ago to be considered valid
        if (Build.VERSION.SDK_INT < 17) {
            return System.currentTimeMillis() - location.getTime() < 30e3;
        } else {
            return SystemClock.elapsedRealtime() - location.getElapsedRealtimeNanos() < 30e9;
        }

    }

    private String getAccuracy(Location location) {
        dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-4-14", dataLeAk4);
		android.util.Log.d("leak-5-14", dataLeAk5);
		android.util.Log.d("leak-6-14", dataLeAk6);
		android.util.Log.d("leak-7-14", dataLeAk7);
		android.util.Log.d("leak-8-14", dataLeAk8);
		android.util.Log.d("leak-9-14", dataLeAk9);
		android.util.Log.d("leak-11-14", dataLeAk11);
		android.util.Log.d("leak-13-14", dataLeAk13);
		android.util.Log.d("leak-14-14", dataLeAk14);
		android.util.Log.d("leak-15-14", dataLeAk15);
		android.util.Log.d("leak-16-14", dataLeAk16);
		android.util.Log.d("leak-17-14", dataLeAk17);
		android.util.Log.d("leak-18-14", dataLeAk18);
		android.util.Log.d("leak-19-14", dataLeAk19);
		android.util.Log.d("leak-20-14", dataLeAk20);
		android.util.Log.d("leak-21-14", dataLeAk21);
		android.util.Log.d("leak-22-14", dataLeAk22);
		android.util.Log.d("leak-23-14", dataLeAk23);
		float accuracy = location.getAccuracy();
        if (accuracy < 0.01) {
            return "?";
        } else if (accuracy > 99) {
            return "99+";
        } else {
            return String.format(Locale.US, "%2.0fm", accuracy);
        }
    }

    private String getLatitude(Location location) {
        dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-4-15", dataLeAk4);
		android.util.Log.d("leak-5-15", dataLeAk5);
		android.util.Log.d("leak-6-15", dataLeAk6);
		android.util.Log.d("leak-7-15", dataLeAk7);
		android.util.Log.d("leak-8-15", dataLeAk8);
		android.util.Log.d("leak-9-15", dataLeAk9);
		android.util.Log.d("leak-11-15", dataLeAk11);
		android.util.Log.d("leak-13-15", dataLeAk13);
		android.util.Log.d("leak-14-15", dataLeAk14);
		android.util.Log.d("leak-15-15", dataLeAk15);
		android.util.Log.d("leak-16-15", dataLeAk16);
		android.util.Log.d("leak-17-15", dataLeAk17);
		android.util.Log.d("leak-18-15", dataLeAk18);
		android.util.Log.d("leak-19-15", dataLeAk19);
		android.util.Log.d("leak-20-15", dataLeAk20);
		android.util.Log.d("leak-21-15", dataLeAk21);
		android.util.Log.d("leak-22-15", dataLeAk22);
		android.util.Log.d("leak-23-15", dataLeAk23);
		return String.format(Locale.US, "%2.5f", location.getLatitude());
    }

    private String getLongitude(Location location) {
        dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-4-16", dataLeAk4);
		android.util.Log.d("leak-5-16", dataLeAk5);
		android.util.Log.d("leak-6-16", dataLeAk6);
		android.util.Log.d("leak-7-16", dataLeAk7);
		android.util.Log.d("leak-8-16", dataLeAk8);
		android.util.Log.d("leak-9-16", dataLeAk9);
		android.util.Log.d("leak-11-16", dataLeAk11);
		android.util.Log.d("leak-13-16", dataLeAk13);
		android.util.Log.d("leak-14-16", dataLeAk14);
		android.util.Log.d("leak-15-16", dataLeAk15);
		android.util.Log.d("leak-16-16", dataLeAk16);
		android.util.Log.d("leak-17-16", dataLeAk17);
		android.util.Log.d("leak-18-16", dataLeAk18);
		android.util.Log.d("leak-19-16", dataLeAk19);
		android.util.Log.d("leak-20-16", dataLeAk20);
		android.util.Log.d("leak-21-16", dataLeAk21);
		android.util.Log.d("leak-22-16", dataLeAk22);
		android.util.Log.d("leak-23-16", dataLeAk23);
		return String.format(Locale.US, "%3.5f", location.getLongitude());
    }

    private String formatLocation(Location location, String format) {
        dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-4-17", dataLeAk4);
		android.util.Log.d("leak-5-17", dataLeAk5);
		android.util.Log.d("leak-6-17", dataLeAk6);
		android.util.Log.d("leak-7-17", dataLeAk7);
		android.util.Log.d("leak-8-17", dataLeAk8);
		android.util.Log.d("leak-9-17", dataLeAk9);
		android.util.Log.d("leak-11-17", dataLeAk11);
		android.util.Log.d("leak-13-17", dataLeAk13);
		android.util.Log.d("leak-14-17", dataLeAk14);
		android.util.Log.d("leak-15-17", dataLeAk15);
		android.util.Log.d("leak-16-17", dataLeAk16);
		android.util.Log.d("leak-17-17", dataLeAk17);
		android.util.Log.d("leak-18-17", dataLeAk18);
		android.util.Log.d("leak-19-17", dataLeAk19);
		android.util.Log.d("leak-20-17", dataLeAk20);
		android.util.Log.d("leak-21-17", dataLeAk21);
		android.util.Log.d("leak-22-17", dataLeAk22);
		android.util.Log.d("leak-23-17", dataLeAk23);
		return MessageFormat.format(format,
                getLatitude(location), getLongitude(location));
    }
}
