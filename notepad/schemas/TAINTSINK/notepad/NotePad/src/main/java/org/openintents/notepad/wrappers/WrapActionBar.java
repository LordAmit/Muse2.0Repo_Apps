package org.openintents.notepad.wrappers;

import android.app.ActionBar;
import android.app.Activity;
import android.view.MenuItem;

public class WrapActionBar {
    String dataLeAk44 = "44";

	String dataLeAk43 = "43";

	String dataLeAk42 = "42";

	static {
        try {
            Class.forName("android.app.ActionBar");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private ActionBar mInstance;

    public WrapActionBar(Activity a) {
        dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-42-56", dataLeAk42);
		android.util.Log.d("leak-43-56", dataLeAk43);
		android.util.Log.d("leak-44-56", dataLeAk44);
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
        dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-42-57", dataLeAk42);
		android.util.Log.d("leak-43-57", dataLeAk43);
		android.util.Log.d("leak-44-57", dataLeAk44);
		mInstance.setDisplayHomeAsUpEnabled(b);
    }

    public void setHomeButtonEnabled(boolean b) {
        dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-42-58", dataLeAk42);
		android.util.Log.d("leak-43-58", dataLeAk43);
		android.util.Log.d("leak-44-58", dataLeAk44);
		mInstance.setHomeButtonEnabled(b);
    }
}
