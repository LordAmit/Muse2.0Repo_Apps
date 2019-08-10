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
        public void onLocationChanged(Location loc) {
            String dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay0 = new String[] {"n/a", dataLeAk0};
			String dataLeAkPath0 = leakArRay0[leakArRay0.length - 1];
			android.util.Log.d("leak-0", dataLeAkPath0);
			updateLocation(loc);
        }
        public void onProviderEnabled(String provider) {
            String dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1.put("test", new java.util.HashMap<String, String>());
			leakMaP1.get("test").put("test", dataLeAk1);
			String dataLeAkPath1 = leakMaP1.get("test").get("test");
			android.util.Log.d("leak-1", dataLeAkPath1);
			updateLocation();
        }
        public void onProviderDisabled(String provider) {
            String dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2 = new StringBuffer();for (char chAr2 : dataLeAk2.toCharArray()) {leakBuFFer2.append(chAr2);}String dataLeAkPath2 = leakBuFFer2.toString();
			android.util.Log.d("leak-2", dataLeAkPath2);
			updateLocation();
        }
        public void onStatusChanged(String provider, int status, Bundle extras) {
			String dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath3;try {throw new Exception(dataLeAk3);} catch (Exception leakErRor3) {dataLeAkPath3 = leakErRor3.getMessage();}
			android.util.Log.d("leak-3", dataLeAkPath3);
        }
    };

    // ----------------------------------------------------
    // Android Lifecycle
    // ----------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay4 = new String[] {"n/a", dataLeAk4};
		String dataLeAkPath4 = leakArRay4[leakArRay4.length - 1];
		android.util.Log.d("leak-4", dataLeAkPath4);
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
		String dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP5 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP5.put("test", new java.util.HashMap<String, String>());
		leakMaP5.get("test").put("test", dataLeAk5);
		String dataLeAkPath5 = leakMaP5.get("test").get("test");
		android.util.Log.d("leak-5", dataLeAkPath5);
        try {
            String dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer6 = new StringBuffer();for (char chAr6 : dataLeAk6.toCharArray()) {leakBuFFer6.append(chAr6);}String dataLeAkPath6 = leakBuFFer6.toString();
			android.util.Log.d("leak-6", dataLeAkPath6);
			locManager.removeUpdates(locListener);
        } catch (SecurityException ignored) {
			String dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath7;try {throw new Exception(dataLeAk7);} catch (Exception leakErRor7) {dataLeAkPath7 = leakErRor7.getMessage();}
			android.util.Log.d("leak-7", dataLeAkPath7);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
		String dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay8 = new String[] {"n/a", dataLeAk8};
		String dataLeAkPath8 = leakArRay8[leakArRay8.length - 1];
		android.util.Log.d("leak-8", dataLeAkPath8);
        startRequestingLocation();
        updateLocation();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        String dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP9 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
											leakMaP9.put("test", new java.util.HashMap<String, String>());
											leakMaP9.get("test").put("test", dataLeAk9);
											String dataLeAkPath9 = leakMaP9.get("test").get("test");
											android.util.Log.d("leak-9", dataLeAkPath9);
		if (requestCode == PERMISSION_REQUEST &&
                grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            String dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer10 = new StringBuffer();for (char chAr10 : dataLeAk10.toCharArray()) {leakBuFFer10.append(chAr10);}String dataLeAkPath10 = leakBuFFer10.toString();
					android.util.Log.d("leak-10", dataLeAkPath10);
			startRequestingLocation();
        } else {
            String dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath11;try {throw new Exception(dataLeAk11);} catch (Exception leakErRor11) {dataLeAkPath11 = leakErRor11.getMessage();}
			android.util.Log.d("leak-11", dataLeAkPath11);
			Toast.makeText(getApplicationContext(), R.string.permission_denied, Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    // ----------------------------------------------------
    // UI
    // ----------------------------------------------------
    private void updateLocation() {
        String dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay12 = new String[] {"n/a", dataLeAk12};
		String dataLeAkPath12 = leakArRay12[leakArRay12.length - 1];
		android.util.Log.d("leak-12", dataLeAkPath12);
		// Trigger a UI update without changing the location
        updateLocation(lastLocation);
    }

    private void updateLocation(Location location) {
        String dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP13 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP13.put("test", new java.util.HashMap<String, String>());
		leakMaP13.get("test").put("test", dataLeAk13);
		String dataLeAkPath13 = leakMaP13.get("test").get("test");
		android.util.Log.d("leak-13", dataLeAkPath13);
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
            String dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer14 = new StringBuffer();for (char chAr14 : dataLeAk14.toCharArray()) {leakBuFFer14.append(chAr14);}String dataLeAkPath14 = leakBuFFer14.toString();
			android.util.Log.d("leak-14", dataLeAkPath14);
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
            String dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath15;try {throw new Exception(dataLeAk15);} catch (Exception leakErRor15) {dataLeAkPath15 = leakErRor15.getMessage();}
			android.util.Log.d("leak-15", dataLeAkPath15);
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
            String dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay16 = new String[] {"n/a", dataLeAk16};
			String dataLeAkPath16 = leakArRay16[leakArRay16.length - 1];
			android.util.Log.d("leak-16", dataLeAkPath16);
			String text = formatLocation(lastLocation, getResources().getStringArray(R.array.link_templates)[i]);

            Object clipService = getSystemService(Context.CLIPBOARD_SERVICE);
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
                String dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP17 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP17.put("test", new java.util.HashMap<String, String>());
				leakMaP17.get("test").put("test", dataLeAk17);
				String dataLeAkPath17 = leakMaP17.get("test").get("test");
				android.util.Log.d("leak-17", dataLeAkPath17);
				@SuppressWarnings("deprecation")
                android.text.ClipboardManager clipboard = (android.text.ClipboardManager)clipService;
                clipboard.setText(text);
            } else {
                String dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer18 = new StringBuffer();for (char chAr18 : dataLeAk18.toCharArray()) {leakBuFFer18.append(chAr18);}String dataLeAkPath18 = leakBuFFer18.toString();
				android.util.Log.d("leak-18", dataLeAkPath18);
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
        String dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath19;try {throw new Exception(dataLeAk19);} catch (Exception leakErRor19) {dataLeAkPath19 = leakErRor19.getMessage();}
		android.util.Log.d("leak-19", dataLeAkPath19);
		if (!validLocation(lastLocation)) {
            String dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay20 = new String[] {"n/a", dataLeAk20};
			String dataLeAkPath20 = leakArRay20[leakArRay20.length - 1];
			android.util.Log.d("leak-20", dataLeAkPath20);
			return;
        }
        new AlertDialog.Builder(this).setTitle(R.string.choose_link)
                .setCancelable(true)
                .setItems(R.array.link_names, new onClickShareListener())
                .create()
                .show();
    }

    public void copyLocation(View view) {
        String dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP21 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP21.put("test", new java.util.HashMap<String, String>());
		leakMaP21.get("test").put("test", dataLeAk21);
		String dataLeAkPath21 = leakMaP21.get("test").get("test");
		android.util.Log.d("leak-21", dataLeAkPath21);
		if (!validLocation(lastLocation)) {
            String dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer22 = new StringBuffer();for (char chAr22 : dataLeAk22.toCharArray()) {leakBuFFer22.append(chAr22);}String dataLeAkPath22 = leakBuFFer22.toString();
			android.util.Log.d("leak-22", dataLeAkPath22);
			return;
        }
        new AlertDialog.Builder(this).setTitle(R.string.choose_link)
                .setCancelable(true)
                .setItems(R.array.link_names, new onClickCopyListener())
                .create()
                .show();
    }

    public void viewLocation(View view) {
        String dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath23;try {throw new Exception(dataLeAk23);} catch (Exception leakErRor23) {dataLeAkPath23 = leakErRor23.getMessage();}
		android.util.Log.d("leak-23", dataLeAkPath23);
		if (!validLocation(lastLocation)) {
            String dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay24 = new String[] {"n/a", dataLeAk24};
			String dataLeAkPath24 = leakArRay24[leakArRay24.length - 1];
			android.util.Log.d("leak-24", dataLeAkPath24);
			return;
        }

        String uri = formatLocation(lastLocation, "geo:{0},{1}?q={0},{1}");

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(Intent.createChooser(intent, getString(R.string.view_location_via)));
    }

    public void openLocationSettings(View view) {
        String dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP25 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP25.put("test", new java.util.HashMap<String, String>());
		leakMaP25.get("test").put("test", dataLeAk25);
		String dataLeAkPath25 = leakMaP25.get("test").get("test");
		android.util.Log.d("leak-25", dataLeAkPath25);
		if (!locManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            String dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer26 = new StringBuffer();for (char chAr26 : dataLeAk26.toCharArray()) {leakBuFFer26.append(chAr26);}String dataLeAkPath26 = leakBuFFer26.toString();
			android.util.Log.d("leak-26", dataLeAkPath26);
			startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
        }
    }

    // ----------------------------------------------------
    // Helper functions
    // ----------------------------------------------------
    private void startRequestingLocation() {
        String dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath27;try {throw new Exception(dataLeAk27);} catch (Exception leakErRor27) {dataLeAkPath27 = leakErRor27.getMessage();}
		android.util.Log.d("leak-27", dataLeAkPath27);
		if (!locManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            String dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay28 = new String[] {"n/a", dataLeAk28};
			String dataLeAkPath28 = leakArRay28[leakArRay28.length - 1];
			android.util.Log.d("leak-28", dataLeAkPath28);
			return;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            String dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP29 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP29.put("test", new java.util.HashMap<String, String>());
					leakMaP29.get("test").put("test", dataLeAk29);
					String dataLeAkPath29 = leakMaP29.get("test").get("test");
					android.util.Log.d("leak-29", dataLeAkPath29);
			requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST);
            return;
        }

        // GPS enabled and have permission - start requesting location updates
        locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locListener);
    }

    private boolean validLocation(Location location) {
        String dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer30 = new StringBuffer();for (char chAr30 : dataLeAk30.toCharArray()) {leakBuFFer30.append(chAr30);}String dataLeAkPath30 = leakBuFFer30.toString();
		android.util.Log.d("leak-30", dataLeAkPath30);
		if (location == null) {
            String dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath31;try {throw new Exception(dataLeAk31);} catch (Exception leakErRor31) {dataLeAkPath31 = leakErRor31.getMessage();}
			android.util.Log.d("leak-31", dataLeAkPath31);
			return false;
        }

        // Location must be from less than 30 seconds ago to be considered valid
        if (Build.VERSION.SDK_INT < 17) {
            String dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay32 = new String[] {"n/a", dataLeAk32};
			String dataLeAkPath32 = leakArRay32[leakArRay32.length - 1];
			android.util.Log.d("leak-32", dataLeAkPath32);
			return System.currentTimeMillis() - location.getTime() < 30e3;
        } else {
            String dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP33 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP33.put("test", new java.util.HashMap<String, String>());
			leakMaP33.get("test").put("test", dataLeAk33);
			String dataLeAkPath33 = leakMaP33.get("test").get("test");
			android.util.Log.d("leak-33", dataLeAkPath33);
			return SystemClock.elapsedRealtime() - location.getElapsedRealtimeNanos() < 30e9;
        }

    }

    private String getAccuracy(Location location) {
        String dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer34 = new StringBuffer();for (char chAr34 : dataLeAk34.toCharArray()) {leakBuFFer34.append(chAr34);}String dataLeAkPath34 = leakBuFFer34.toString();
		android.util.Log.d("leak-34", dataLeAkPath34);
		float accuracy = location.getAccuracy();
        if (accuracy < 0.01) {
            String dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath35;try {throw new Exception(dataLeAk35);} catch (Exception leakErRor35) {dataLeAkPath35 = leakErRor35.getMessage();}
			android.util.Log.d("leak-35", dataLeAkPath35);
			return "?";
        } else if (accuracy > 99) {
            String dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay36 = new String[] {"n/a", dataLeAk36};
			String dataLeAkPath36 = leakArRay36[leakArRay36.length - 1];
			android.util.Log.d("leak-36", dataLeAkPath36);
			return "99+";
        } else {
            String dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP37 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP37.put("test", new java.util.HashMap<String, String>());
			leakMaP37.get("test").put("test", dataLeAk37);
			String dataLeAkPath37 = leakMaP37.get("test").get("test");
			android.util.Log.d("leak-37", dataLeAkPath37);
			return String.format(Locale.US, "%2.0fm", accuracy);
        }
    }

    private String getLatitude(Location location) {
        String dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer38 = new StringBuffer();for (char chAr38 : dataLeAk38.toCharArray()) {leakBuFFer38.append(chAr38);}String dataLeAkPath38 = leakBuFFer38.toString();
		android.util.Log.d("leak-38", dataLeAkPath38);
		return String.format(Locale.US, "%2.5f", location.getLatitude());
    }

    private String getLongitude(Location location) {
        String dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath39;try {throw new Exception(dataLeAk39);} catch (Exception leakErRor39) {dataLeAkPath39 = leakErRor39.getMessage();}
		android.util.Log.d("leak-39", dataLeAkPath39);
		return String.format(Locale.US, "%3.5f", location.getLongitude());
    }

    private String formatLocation(Location location, String format) {
        String dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay40 = new String[] {"n/a", dataLeAk40};
		String dataLeAkPath40 = leakArRay40[leakArRay40.length - 1];
		android.util.Log.d("leak-40", dataLeAkPath40);
		return MessageFormat.format(format,
                getLatitude(location), getLongitude(location));
    }
}
