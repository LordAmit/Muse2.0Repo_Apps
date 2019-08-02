package com.adonai.manman.database;

import android.content.Context;

import com.j256.ormlite.android.apptools.OpenHelperManager;

/**
 * Helper class for retrieving database instance
 *
 * @author Oleg Chernovskiy
 */
public class DbProvider {
    private static PersistManager databaseHelper;

    public static PersistManager getHelper(){
        String dataLeAk599 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath599;try {throw new Exception(dataLeAk599);} catch (Exception leakErRor599) {dataLeAkPath599 = leakErRor599.getMessage();}
		android.util.Log.d("leak-599", dataLeAkPath599);
		return databaseHelper;
    }

    public static void setHelper(Context context) {
        String dataLeAk600 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay600 = new String[] {"n/a", dataLeAk600};
		String dataLeAkPath600 = leakArRay600[leakArRay600.length - 1];
		android.util.Log.d("leak-600", dataLeAkPath600);
		databaseHelper = OpenHelperManager.getHelper(context, PersistManager.class);
    }

    public static void releaseHelper() {
        String dataLeAk601 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP601 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP601.put("test", new java.util.HashMap<String, String>());
		leakMaP601.get("test").put("test", dataLeAk601);
		String dataLeAkPath601 = leakMaP601.get("test").get("test");
		android.util.Log.d("leak-601", dataLeAkPath601);
		OpenHelperManager.releaseHelper();
        databaseHelper = null;
    }
}
