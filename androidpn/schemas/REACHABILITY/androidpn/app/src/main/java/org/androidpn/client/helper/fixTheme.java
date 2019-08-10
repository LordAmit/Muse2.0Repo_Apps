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

    String dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk49 = android.util.Log.d("leak-49", dataLeAk49);
	public static int getThemePref(String value){
        String dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk50 = android.util.Log.d("leak-50", dataLeAk50);
		int Rid;
        if (value.equals("dark")) {
            String dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk51 = android.util.Log.d("leak-51", dataLeAk51);
			Rid = R.style.AppThemeDark_NoActionBar;
        }else {
            String dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk52 = android.util.Log.d("leak-52", dataLeAk52);
			Rid = R.style.AppThemeLight_NoActionBar;
        }
        return Rid;
    }
    public static boolean fixTheme(Activity act) {
        String dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk53 = android.util.Log.d("leak-53", dataLeAk53);
		boolean reset = false;
        TypedValue outValue = new TypedValue();
        act.getTheme().resolveAttribute(R.attr.themeName, outValue, true);
        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(act);
        String value = mPrefs.getString("theme","dark");
        act.setTheme(getThemePref(value));
        if (!value.contentEquals(outValue.string)) {
            String dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk54 = android.util.Log.d("leak-54", dataLeAk54);
			reset = true;
        }
        return reset;
    }
}
