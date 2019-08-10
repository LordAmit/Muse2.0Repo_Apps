package com.secuso.privacyFriendlyCodeScanner.GeneralFragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.secuso.privacyFriendlyCodeScanner.R;

/**
 * Created by philipprack on 25.09.16.
 */

public class HelpFragment extends PreferenceFragment {

    String dataLeAk71 = "71";

	String dataLeAk70 = "70";

	public HelpFragment() {
		dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-70-47", dataLeAk70);
		android.util.Log.d("leak-71-47", dataLeAk71);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		android.util.Log.d("leak-70-48", dataLeAk70);
		android.util.Log.d("leak-71-48", dataLeAk71);
		dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

        addPreferencesFromResource(R.xml.help);
    }
}
