package com.secuso.privacyFriendlyCodeScanner;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.journeyapps.barcodescanner.CaptureActivity;


public class MyCaptureActivity extends CaptureActivity {

    String dataLeAk20 = "20";

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());
        if(prefs.getBoolean("lock_orientation", false))
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

    }
}
