package com.adonai.manman.database;

import android.content.Context;

import com.j256.ormlite.android.apptools.OpenHelperManager;

/**
 * Helper class for retrieving database instance
 *
 * @author Oleg Chernovskiy
 */
public class DbProvider {
    String dataLeAk714 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk714 = android.util.Log.d("leak-714", dataLeAk714);

	private static PersistManager databaseHelper;

    public static PersistManager getHelper(){
        String dataLeAk715 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk715 = android.util.Log.d("leak-715", dataLeAk715);
		return databaseHelper;
    }

    public static void setHelper(Context context) {
        String dataLeAk716 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk716 = android.util.Log.d("leak-716", dataLeAk716);
		databaseHelper = OpenHelperManager.getHelper(context, PersistManager.class);
    }

    public static void releaseHelper() {
        String dataLeAk717 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk717 = android.util.Log.d("leak-717", dataLeAk717);
		OpenHelperManager.releaseHelper();
        databaseHelper = null;
    }
}
