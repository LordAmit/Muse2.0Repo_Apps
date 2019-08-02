package org.openintents.notepad.wrappers;

import android.app.ActionBar;
import android.app.Activity;
import android.view.MenuItem;

public class WrapActionBar {
    String dataLeAk64 = "";

	String dataLeAk63 = "";

	String dataLeAk62 = "";

	static {
        try {
            Class.forName("android.app.ActionBar");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private ActionBar mInstance;

    public WrapActionBar(Activity a) {
        dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-62-0", dataLeAk62);
		android.util.Log.d("leak-63-0", dataLeAk63);
		android.util.Log.d("leak-64-0", dataLeAk64);
		mInstance = a.getActionBar();
    }

    /* calling here forces class initialization */
    public static void checkAvailable() {
    }

    // show an icon in the actionbar if there is room for it.
    public static void showIfRoom(MenuItem item) {
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
    }

    public void setDisplayHomeAsUpEnabled(boolean b) {
        dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-62-1", dataLeAk62);
		android.util.Log.d("leak-63-1", dataLeAk63);
		android.util.Log.d("leak-64-1", dataLeAk64);
		mInstance.setDisplayHomeAsUpEnabled(b);
    }

    public void setHomeButtonEnabled(boolean b) {
        dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-62-2", dataLeAk62);
		android.util.Log.d("leak-63-2", dataLeAk63);
		android.util.Log.d("leak-64-2", dataLeAk64);
		mInstance.setHomeButtonEnabled(b);
    }
}
