package org.afhdownloader;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;


/**
 * Created by daktak on 2/19/16.
 */
public class PrefsFragment extends PreferenceFragment {

    String dataLeAk21 = "21";

	String dataLeAk19 = "19";

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		android.util.Log.d("leak-19-23", dataLeAk19);
		android.util.Log.d("leak-21-23", dataLeAk21);
		dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.settings);


        Preference prefDir = findPreference("prefDirectory");

        //prefDir.setIntent(i);
        prefDir.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            String dataLeAk20 = "20";

			@Override
            public boolean onPreferenceClick(Preference preference) {
                dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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


