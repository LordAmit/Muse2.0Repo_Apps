package org.afhdownloader;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;


/**
 * Created by daktak on 2/19/16.
 */
public class PrefsFragment extends PreferenceFragment {

    String dataLeAk80 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk80 = android.util.Log.d("leak-80", dataLeAk80);

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk81 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk81 = android.util.Log.d("leak-81", dataLeAk81);
        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.settings);


        Preference prefDir = findPreference("prefDirectory");

        //prefDir.setIntent(i);
        prefDir.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            String dataLeAk82 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk82 = android.util.Log.d("leak-82", dataLeAk82);

			@Override
            public boolean onPreferenceClick(Preference preference) {
                String dataLeAk83 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk83 = android.util.Log.d("leak-83", dataLeAk83);
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


