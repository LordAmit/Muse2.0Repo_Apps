package org.afhdownloader;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;


/**
 * Created by daktak on 2/19/16.
 */
public class PrefsFragment extends PreferenceFragment {

    final String dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk34 = "";

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-34-0", dataLeAk34);
        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.settings);


        Preference prefDir = findPreference("prefDirectory");

        //prefDir.setIntent(i);
        prefDir.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            String dataLeAk35 = "";

			@Override
            public boolean onPreferenceClick(Preference preference) {
                dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-37-0", dataLeAk37);
				android.util.Log.d("leak-35-0", dataLeAk35);
				Intent i = new Intent(getActivity(), DirectoryPicker.class);
                /* If you set default dir , you can't navigate up!
                SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                String dir = mySharedPreferences.getString("prefDirectory",null);
                i.putExtra(DirectoryPicker.START_DIR, dir);*/

                startActivity(i);
                return true;
            }
        });



    }

}


