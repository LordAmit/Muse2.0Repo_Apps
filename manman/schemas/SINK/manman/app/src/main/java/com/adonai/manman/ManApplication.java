package com.adonai.manman;

import android.app.Application;

import com.adonai.manman.database.DbProvider;

/**
 * Place to initialize all data prior to launching activities
 * @author Adonai
 */
public class ManApplication extends Application {
    String dataLeAk355 = "";

	String dataLeAk354 = "";

	@Override
    public void onCreate() {
        super.onCreate();
		dataLeAk354 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-354-0", dataLeAk354);
		android.util.Log.d("leak-355-0", dataLeAk355);
        DbProvider.setHelper(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
		dataLeAk355 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-354-1", dataLeAk354);
		android.util.Log.d("leak-355-1", dataLeAk355);
        DbProvider.releaseHelper();
    }
}
