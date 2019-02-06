package org.openintents.notepad.wrappers;

import android.app.ActionBar;
import android.app.Activity;
import android.view.MenuItem;

public class WrapActionBar {
    String dataLeAk235 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk235 = android.util.Log.d("leak-235", dataLeAk235);

	static {
        String dataLeAk236 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk236 = android.util.Log.d("leak-236", dataLeAk236);
		try {
            String dataLeAk237 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk237 = android.util.Log.d("leak-237", dataLeAk237);
			Class.forName("android.app.ActionBar");
        } catch (Exception ex) {
            String dataLeAk238 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk238 = android.util.Log.d("leak-238", dataLeAk238);
			throw new RuntimeException(ex);
        }
    }

    private ActionBar mInstance;

    public WrapActionBar(Activity a) {
        String dataLeAk239 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk239 = android.util.Log.d("leak-239", dataLeAk239);
		mInstance = a.getActionBar();
    }

    /* calling here forces class initialization */
    public static void checkAvailable() {
		String dataLeAk240 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk240 = android.util.Log.d("leak-240", dataLeAk240);
    }

    // show an icon in the actionbar if there is room for it.
    public static void showIfRoom(MenuItem item) {
        String dataLeAk241 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk241 = android.util.Log.d("leak-241", dataLeAk241);
		item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
    }

    public void setDisplayHomeAsUpEnabled(boolean b) {
        String dataLeAk242 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk242 = android.util.Log.d("leak-242", dataLeAk242);
		mInstance.setDisplayHomeAsUpEnabled(b);
    }

    public void setHomeButtonEnabled(boolean b) {
        String dataLeAk243 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk243 = android.util.Log.d("leak-243", dataLeAk243);
		mInstance.setHomeButtonEnabled(b);
    }
}
