package com.secuso.privacyFriendlyCodeScanner;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.journeyapps.barcodescanner.CaptureActivity;


public class MyCaptureActivity extends CaptureActivity {

    String dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk43 = android.util.Log.d("leak-43", dataLeAk43);

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk44 = android.util.Log.d("leak-44", dataLeAk44);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());
        if(prefs.getBoolean("lock_orientation", false))
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

    }
}
