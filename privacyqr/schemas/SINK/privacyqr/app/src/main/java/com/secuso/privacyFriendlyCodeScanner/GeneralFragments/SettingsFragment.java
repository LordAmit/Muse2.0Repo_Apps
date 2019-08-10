package com.secuso.privacyFriendlyCodeScanner.GeneralFragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.secuso.privacyFriendlyCodeScanner.R;

public class SettingsFragment extends PreferenceFragment {
    String dataLeAk49 = "";

	String dataLeAk48 = "";

	String dataLeAk47 = "";

	public SettingsFragment() {
		dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-47-0", dataLeAk47);
		android.util.Log.d("leak-48-0", dataLeAk48);
		android.util.Log.d("leak-49-0", dataLeAk49);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
		dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-47-1", dataLeAk47);
		android.util.Log.d("leak-48-1", dataLeAk48);
		android.util.Log.d("leak-49-1", dataLeAk49);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-47-2", dataLeAk47);
		android.util.Log.d("leak-48-2", dataLeAk48);
		android.util.Log.d("leak-49-2", dataLeAk49);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);

    }

}
