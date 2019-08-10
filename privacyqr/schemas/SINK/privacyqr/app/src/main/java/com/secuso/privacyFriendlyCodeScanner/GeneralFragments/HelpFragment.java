package com.secuso.privacyFriendlyCodeScanner.GeneralFragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.secuso.privacyFriendlyCodeScanner.R;

/**
 * Created by philipprack on 25.09.16.
 */

public class HelpFragment extends PreferenceFragment {

    String dataLeAk82 = "";

	String dataLeAk81 = "";

	public HelpFragment() {
		dataLeAk81 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-81-0", dataLeAk81);
		android.util.Log.d("leak-82-0", dataLeAk82);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		dataLeAk82 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-81-1", dataLeAk81);
		android.util.Log.d("leak-82-1", dataLeAk82);

        addPreferencesFromResource(R.xml.help);
    }
}
