package com.secuso.privacyFriendlyCodeScanner.GeneralFragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.secuso.privacyFriendlyCodeScanner.R;

public class SettingsFragment extends PreferenceFragment {
    String dataLeAk39 = "39";

	String dataLeAk38 = "38";

	String dataLeAk37 = "37";

	public SettingsFragment() {
		dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-37-27", dataLeAk37);
		android.util.Log.d("leak-38-27", dataLeAk38);
		android.util.Log.d("leak-39-27", dataLeAk39);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
		android.util.Log.d("leak-37-28", dataLeAk37);
		android.util.Log.d("leak-38-28", dataLeAk38);
		android.util.Log.d("leak-39-28", dataLeAk39);
		dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		android.util.Log.d("leak-37-29", dataLeAk37);
		android.util.Log.d("leak-38-29", dataLeAk38);
		android.util.Log.d("leak-39-29", dataLeAk39);
		dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);

    }

}
