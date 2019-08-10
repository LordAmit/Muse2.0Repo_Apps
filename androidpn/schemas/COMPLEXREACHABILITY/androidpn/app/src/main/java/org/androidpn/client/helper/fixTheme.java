package org.androidpn.client.helper;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.TypedValue;
import org.androidpn.client.R;


/**
 * Created by daktak on 3/1/16.
 */
public class fixTheme {

    public static int getThemePref(String value){
        String dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP45 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP45.put("test", new java.util.HashMap<String, String>());
		leakMaP45.get("test").put("test", dataLeAk45);
		String dataLeAkPath45 = leakMaP45.get("test").get("test");
		android.util.Log.d("leak-45", dataLeAkPath45);
		int Rid;
        if (value.equals("dark")) {
            String dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer46 = new StringBuffer();for (char chAr46 : dataLeAk46.toCharArray()) {leakBuFFer46.append(chAr46);}String dataLeAkPath46 = leakBuFFer46.toString();
			android.util.Log.d("leak-46", dataLeAkPath46);
			Rid = R.style.AppThemeDark_NoActionBar;
        }else {
            String dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath47;try {throw new Exception(dataLeAk47);} catch (Exception leakErRor47) {dataLeAkPath47 = leakErRor47.getMessage();}
			android.util.Log.d("leak-47", dataLeAkPath47);
			Rid = R.style.AppThemeLight_NoActionBar;
        }
        return Rid;
    }
    public static boolean fixTheme(Activity act) {
        String dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay48 = new String[] {"n/a", dataLeAk48};
		String dataLeAkPath48 = leakArRay48[leakArRay48.length - 1];
		android.util.Log.d("leak-48", dataLeAkPath48);
		boolean reset = false;
        TypedValue outValue = new TypedValue();
        act.getTheme().resolveAttribute(R.attr.themeName, outValue, true);
        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(act);
        String value = mPrefs.getString("theme","dark");
        act.setTheme(getThemePref(value));
        if (!value.contentEquals(outValue.string)) {
            String dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP49 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP49.put("test", new java.util.HashMap<String, String>());
			leakMaP49.get("test").put("test", dataLeAk49);
			String dataLeAkPath49 = leakMaP49.get("test").get("test");
			android.util.Log.d("leak-49", dataLeAkPath49);
			reset = true;
        }
        return reset;
    }
}
