package org.openintents.notepad.wrappers;

import android.app.ActionBar;
import android.app.Activity;
import android.view.MenuItem;

public class WrapActionBar {
    static {
        String dataLeAk218 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer218 = new StringBuffer();for (char chAr218 : dataLeAk218.toCharArray()) {leakBuFFer218.append(chAr218);}String dataLeAkPath218 = leakBuFFer218.toString();
		android.util.Log.d("leak-218", dataLeAkPath218);
		try {
            String dataLeAk219 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath219;try {throw new Exception(dataLeAk219);} catch (Exception leakErRor219) {dataLeAkPath219 = leakErRor219.getMessage();}
			android.util.Log.d("leak-219", dataLeAkPath219);
			Class.forName("android.app.ActionBar");
        } catch (Exception ex) {
            String dataLeAk220 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay220 = new String[] {"n/a", dataLeAk220};
			String dataLeAkPath220 = leakArRay220[leakArRay220.length - 1];
			android.util.Log.d("leak-220", dataLeAkPath220);
			throw new RuntimeException(ex);
        }
    }

    private ActionBar mInstance;

    public WrapActionBar(Activity a) {
        String dataLeAk221 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP221 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP221.put("test", new java.util.HashMap<String, String>());
		leakMaP221.get("test").put("test", dataLeAk221);
		String dataLeAkPath221 = leakMaP221.get("test").get("test");
		android.util.Log.d("leak-221", dataLeAkPath221);
		mInstance = a.getActionBar();
    }

    /* calling here forces class initialization */
    public static void checkAvailable() {
		String dataLeAk222 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer222 = new StringBuffer();for (char chAr222 : dataLeAk222.toCharArray()) {leakBuFFer222.append(chAr222);}String dataLeAkPath222 = leakBuFFer222.toString();
		android.util.Log.d("leak-222", dataLeAkPath222);
    }

    // show an icon in the actionbar if there is room for it.
    public static void showIfRoom(MenuItem item) {
        String dataLeAk223 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath223;try {throw new Exception(dataLeAk223);} catch (Exception leakErRor223) {dataLeAkPath223 = leakErRor223.getMessage();}
		android.util.Log.d("leak-223", dataLeAkPath223);
		item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
    }

    public void setDisplayHomeAsUpEnabled(boolean b) {
        String dataLeAk224 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay224 = new String[] {"n/a", dataLeAk224};
		String dataLeAkPath224 = leakArRay224[leakArRay224.length - 1];
		android.util.Log.d("leak-224", dataLeAkPath224);
		mInstance.setDisplayHomeAsUpEnabled(b);
    }

    public void setHomeButtonEnabled(boolean b) {
        String dataLeAk225 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP225 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP225.put("test", new java.util.HashMap<String, String>());
		leakMaP225.get("test").put("test", dataLeAk225);
		String dataLeAkPath225 = leakMaP225.get("test").get("test");
		android.util.Log.d("leak-225", dataLeAkPath225);
		mInstance.setHomeButtonEnabled(b);
    }
}
