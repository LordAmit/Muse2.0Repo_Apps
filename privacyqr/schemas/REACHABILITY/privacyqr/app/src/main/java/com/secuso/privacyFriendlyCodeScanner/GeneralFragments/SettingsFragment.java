package com.secuso.privacyFriendlyCodeScanner.GeneralFragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.secuso.privacyFriendlyCodeScanner.R;

public class SettingsFragment extends PreferenceFragment {
    String dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk67 = android.util.Log.d("leak-67", dataLeAk67);

	public SettingsFragment() {
		String dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk68 = android.util.Log.d("leak-68", dataLeAk68);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
		String dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk69 = android.util.Log.d("leak-69", dataLeAk69);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk70 = android.util.Log.d("leak-70", dataLeAk70);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);

    }

}
