package com.adonai.manman;

import android.app.Application;

import com.adonai.manman.database.DbProvider;

/**
 * Place to initialize all data prior to launching activities
 * @author Adonai
 */
public class ManApplication extends Application {
    String dataLeAk445 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk445 = android.util.Log.d("leak-445", dataLeAk445);

	@Override
    public void onCreate() {
        super.onCreate();
		String dataLeAk446 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk446 = android.util.Log.d("leak-446", dataLeAk446);
        DbProvider.setHelper(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
		String dataLeAk447 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk447 = android.util.Log.d("leak-447", dataLeAk447);
        DbProvider.releaseHelper();
    }
}
