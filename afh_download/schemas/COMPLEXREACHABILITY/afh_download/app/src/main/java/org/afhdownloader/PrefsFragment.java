package org.afhdownloader;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;


/**
 * Created by daktak on 2/19/16.
 */
public class PrefsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP69 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP69.put("test", new java.util.HashMap<String, String>());
		leakMaP69.get("test").put("test", dataLeAk69);
		String dataLeAkPath69 = leakMaP69.get("test").get("test");
		android.util.Log.d("leak-69", dataLeAkPath69);
        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.settings);


        Preference prefDir = findPreference("prefDirectory");

        //prefDir.setIntent(i);
        prefDir.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                String dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer70 = new StringBuffer();for (char chAr70 : dataLeAk70.toCharArray()) {leakBuFFer70.append(chAr70);}String dataLeAkPath70 = leakBuFFer70.toString();
				android.util.Log.d("leak-70", dataLeAkPath70);
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


