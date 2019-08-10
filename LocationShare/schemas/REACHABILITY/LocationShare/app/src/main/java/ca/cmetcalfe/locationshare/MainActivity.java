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

    String dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk0 = android.util.Log.d("leak-0", dataLeAk0);

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
        String dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1 = android.util.Log.d("leak-1", dataLeAk1);
		public void onLocationChanged(Location loc) {
            String dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2 = android.util.Log.d("leak-2", dataLeAk2);
			updateLocation(loc);
        }
        public void onProviderEnabled(String provider) {
            String dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3 = android.util.Log.d("leak-3", dataLeAk3);
			updateLocation();
        }
        public void onProviderDisabled(String provider) {
            String dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk4 = android.util.Log.d("leak-4", dataLeAk4);
			updateLocation();
        }
        public void onStatusChanged(String provider, int status, Bundle extras) {
			String dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk5 = android.util.Log.d("leak-5", dataLeAk5);
        }
    };

    // ----------------------------------------------------
    // Android Lifecycle
    // ----------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk6 = android.util.Log.d("leak-6", dataLeAk6);
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
		String dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk7 = android.util.Log.d("leak-7", dataLeAk7);
        try {
            String dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk8 = android.util.Log.d("leak-8", dataLeAk8);
			locManager.removeUpdates(locListener);
        } catch (SecurityException ignored) {
			String dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk9 = android.util.Log.d("leak-9", dataLeAk9);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
		String dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk10 = android.util.Log.d("leak-10", dataLeAk10);
        startRequestingLocation();
        updateLocation();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        String dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											Object throwawayLeAk11 = android.util.Log.d("leak-11", dataLeAk11);
		if (requestCode == PERMISSION_REQUEST &&
                grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            String dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk12 = android.util.Log.d("leak-12", dataLeAk12);
			startRequestingLocation();
        } else {
            String dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk13 = android.util.Log.d("leak-13", dataLeAk13);
			Toast.makeText(getApplicationContext(), R.string.permission_denied, Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    // ----------------------------------------------------
    // UI
    // ----------------------------------------------------
    private void updateLocation() {
        String dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk14 = android.util.Log.d("leak-14", dataLeAk14);
		// Trigger a UI update without changing the location
        updateLocation(lastLocation);
    }

    private void updateLocation(Location location) {
        String dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk15 = android.util.Log.d("leak-15", dataLeAk15);
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
            String dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk16 = android.util.Log.d("leak-16", dataLeAk16);
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
        String dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk17 = android.util.Log.d("leak-17", dataLeAk17);

		@Override
        public void onClick(DialogInterface dialog, int i) {
            String dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk18 = android.util.Log.d("leak-18", dataLeAk18);
			String link = formatLocation(lastLocation, getResources().getStringArray(R.array.link_templates)[i]);

            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT, link);
            intent.setType("text/plain");
            startActivity(Intent.createChooser(intent, getString(R.string.share_location_via)));
        }
    }

    private class onClickCopyListener implements DialogInterface.OnClickListener {
        String dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk19 = android.util.Log.d("leak-19", dataLeAk19);

		@Override
        public void onClick(DialogInterface dialog, int i) {
            String dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk20 = android.util.Log.d("leak-20", dataLeAk20);
			String text = formatLocation(lastLocation, getResources().getStringArray(R.array.link_templates)[i]);

            Object clipService = getSystemService(Context.CLIPBOARD_SERVICE);
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
                String dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk21 = android.util.Log.d("leak-21", dataLeAk21);
				@SuppressWarnings("deprecation")
                android.text.ClipboardManager clipboard = (android.text.ClipboardManager)clipService;
                clipboard.setText(text);
            } else {
                String dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk22 = android.util.Log.d("leak-22", dataLeAk22);
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
        String dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk23 = android.util.Log.d("leak-23", dataLeAk23);
		if (!validLocation(lastLocation)) {
            String dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk24 = android.util.Log.d("leak-24", dataLeAk24);
			return;
        }
        new AlertDialog.Builder(this).setTitle(R.string.choose_link)
                .setCancelable(true)
                .setItems(R.array.link_names, new onClickShareListener())
                .create()
                .show();
    }

    public void copyLocation(View view) {
        String dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk25 = android.util.Log.d("leak-25", dataLeAk25);
		if (!validLocation(lastLocation)) {
            String dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk26 = android.util.Log.d("leak-26", dataLeAk26);
			return;
        }
        new AlertDialog.Builder(this).setTitle(R.string.choose_link)
                .setCancelable(true)
                .setItems(R.array.link_names, new onClickCopyListener())
                .create()
                .show();
    }

    public void viewLocation(View view) {
        String dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk27 = android.util.Log.d("leak-27", dataLeAk27);
		if (!validLocation(lastLocation)) {
            String dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk28 = android.util.Log.d("leak-28", dataLeAk28);
			return;
        }

        String uri = formatLocation(lastLocation, "geo:{0},{1}?q={0},{1}");

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(Intent.createChooser(intent, getString(R.string.view_location_via)));
    }

    public void openLocationSettings(View view) {
        String dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk29 = android.util.Log.d("leak-29", dataLeAk29);
		if (!locManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            String dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk30 = android.util.Log.d("leak-30", dataLeAk30);
			startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
        }
    }

    // ----------------------------------------------------
    // Helper functions
    // ----------------------------------------------------
    private void startRequestingLocation() {
        String dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk31 = android.util.Log.d("leak-31", dataLeAk31);
		if (!locManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            String dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk32 = android.util.Log.d("leak-32", dataLeAk32);
			return;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            String dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk33 = android.util.Log.d("leak-33", dataLeAk33);
			requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST);
            return;
        }

        // GPS enabled and have permission - start requesting location updates
        locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locListener);
    }

    private boolean validLocation(Location location) {
        String dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk34 = android.util.Log.d("leak-34", dataLeAk34);
		if (location == null) {
            String dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk35 = android.util.Log.d("leak-35", dataLeAk35);
			return false;
        }

        // Location must be from less than 30 seconds ago to be considered valid
        if (Build.VERSION.SDK_INT < 17) {
            String dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk36 = android.util.Log.d("leak-36", dataLeAk36);
			return System.currentTimeMillis() - location.getTime() < 30e3;
        } else {
            String dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk37 = android.util.Log.d("leak-37", dataLeAk37);
			return SystemClock.elapsedRealtime() - location.getElapsedRealtimeNanos() < 30e9;
        }

    }

    private String getAccuracy(Location location) {
        String dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk38 = android.util.Log.d("leak-38", dataLeAk38);
		float accuracy = location.getAccuracy();
        if (accuracy < 0.01) {
            String dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk39 = android.util.Log.d("leak-39", dataLeAk39);
			return "?";
        } else if (accuracy > 99) {
            String dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk40 = android.util.Log.d("leak-40", dataLeAk40);
			return "99+";
        } else {
            String dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk41 = android.util.Log.d("leak-41", dataLeAk41);
			return String.format(Locale.US, "%2.0fm", accuracy);
        }
    }

    private String getLatitude(Location location) {
        String dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk42 = android.util.Log.d("leak-42", dataLeAk42);
		return String.format(Locale.US, "%2.5f", location.getLatitude());
    }

    private String getLongitude(Location location) {
        String dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk43 = android.util.Log.d("leak-43", dataLeAk43);
		return String.format(Locale.US, "%3.5f", location.getLongitude());
    }

    private String formatLocation(Location location, String format) {
        String dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk44 = android.util.Log.d("leak-44", dataLeAk44);
		return MessageFormat.format(format,
                getLatitude(location), getLongitude(location));
    }
}
