package org.androidpn.client;

import android.os.Bundle;
import android.preference.PreferenceFragment;


/**
 * Created by daktak on 2/19/16.
 */
public class PrefsFragment extends PreferenceFragment {

    String dataLeAk48 = "";

	@Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
		dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-48-0", dataLeAk48);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.settings);
    }

}


