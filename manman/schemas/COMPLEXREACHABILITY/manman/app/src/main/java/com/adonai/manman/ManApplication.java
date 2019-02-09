package com.adonai.manman;

import android.app.Application;

import com.adonai.manman.database.DbProvider;

/**
 * Place to initialize all data prior to launching activities
 * @author Adonai
 */
public class ManApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
		String dataLeAk365 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP365 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP365.put("test", new java.util.HashMap<String, String>());
		leakMaP365.get("test").put("test", dataLeAk365);
		String dataLeAkPath365 = leakMaP365.get("test").get("test");
		android.util.Log.d("leak-365", dataLeAkPath365);
        DbProvider.setHelper(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
		String dataLeAk366 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer366 = new StringBuffer();for (char chAr366 : dataLeAk366.toCharArray()) {leakBuFFer366.append(chAr366);}String dataLeAkPath366 = leakBuFFer366.toString();
		android.util.Log.d("leak-366", dataLeAkPath366);
        DbProvider.releaseHelper();
    }
}
