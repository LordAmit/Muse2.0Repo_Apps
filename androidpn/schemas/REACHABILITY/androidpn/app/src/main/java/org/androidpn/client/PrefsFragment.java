package org.androidpn.client;

import android.os.Bundle;
import android.preference.PreferenceFragment;


/**
 * Created by daktak on 2/19/16.
 */
public class PrefsFragment extends PreferenceFragment {

    String dataLeAk170 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk170 = android.util.Log.d("leak-170", dataLeAk170);

	@Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
		String dataLeAk171 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk171 = android.util.Log.d("leak-171", dataLeAk171);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.settings);
    }

}


