package org.androidpn.client;

import android.os.Bundle;
import android.preference.PreferenceFragment;


/**
 * Created by daktak on 2/19/16.
 */
public class PrefsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
		String dataLeAk153 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP153 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP153.put("test", new java.util.HashMap<String, String>());
		leakMaP153.get("test").put("test", dataLeAk153);
		String dataLeAkPath153 = leakMaP153.get("test").get("test");
		android.util.Log.d("leak-153", dataLeAkPath153);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.settings);
    }

}


