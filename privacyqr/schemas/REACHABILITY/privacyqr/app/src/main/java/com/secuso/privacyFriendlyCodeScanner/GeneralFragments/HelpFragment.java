package com.secuso.privacyFriendlyCodeScanner.GeneralFragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.secuso.privacyFriendlyCodeScanner.R;

/**
 * Created by philipprack on 25.09.16.
 */

public class HelpFragment extends PreferenceFragment {

    String dataLeAk119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk119 = android.util.Log.d("leak-119", dataLeAk119);

	public HelpFragment() {
		String dataLeAk120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk120 = android.util.Log.d("leak-120", dataLeAk120);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk121 = android.util.Log.d("leak-121", dataLeAk121);

        addPreferencesFromResource(R.xml.help);
    }
}
