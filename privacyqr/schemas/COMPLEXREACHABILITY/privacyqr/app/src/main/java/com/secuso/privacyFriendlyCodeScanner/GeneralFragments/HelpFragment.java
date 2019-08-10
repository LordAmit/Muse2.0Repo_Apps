package com.secuso.privacyFriendlyCodeScanner.GeneralFragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.secuso.privacyFriendlyCodeScanner.R;

/**
 * Created by philipprack on 25.09.16.
 */

public class HelpFragment extends PreferenceFragment {

    public HelpFragment() {
		String dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP97 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP97.put("test", new java.util.HashMap<String, String>());
		leakMaP97.get("test").put("test", dataLeAk97);
		String dataLeAkPath97 = leakMaP97.get("test").get("test");
		android.util.Log.d("leak-97", dataLeAkPath97);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk98 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer98 = new StringBuffer();for (char chAr98 : dataLeAk98.toCharArray()) {leakBuFFer98.append(chAr98);}String dataLeAkPath98 = leakBuFFer98.toString();
		android.util.Log.d("leak-98", dataLeAkPath98);

        addPreferencesFromResource(R.xml.help);
    }
}
