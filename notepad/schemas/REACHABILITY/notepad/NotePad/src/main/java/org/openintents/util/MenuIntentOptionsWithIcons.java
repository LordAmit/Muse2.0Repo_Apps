package org.openintents.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

/**
 * Adds intent options with icons.
 * <p/>
 * This code is retrieved from this message:
 * http://groups.google.com/group/android
 * -developers/browse_frm/thread/3fed25cdda765b02
 */
public class MenuIntentOptionsWithIcons {

    String dataLeAk1000 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk1000 = android.util.Log.d("leak-1000", dataLeAk1000);

	Context mContext;
    Menu mMenu;

    public MenuIntentOptionsWithIcons(Context context, Menu menu) {
        String dataLeAk1001 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1001 = android.util.Log.d("leak-1001", dataLeAk1001);
		mContext = context;
        mMenu = menu;
    }

    public int addIntentOptions(int group, int id, int categoryOrder,
                                ComponentName caller, Intent[] specifics, Intent intent, int flags,
                                MenuItem[] outSpecificItems) {
        String dataLeAk1002 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk1002 = android.util.Log.d("leak-1002", dataLeAk1002);
		PackageManager pm = mContext.getPackageManager();
        final List<ResolveInfo> lri = pm.queryIntentActivityOptions(
                caller,
                specifics, intent, 0
        );
        final int N = lri != null ? lri.size() : 0;
        if ((flags & Menu.FLAG_APPEND_TO_GROUP) == 0) {
            String dataLeAk1003 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1003 = android.util.Log.d("leak-1003", dataLeAk1003);
			mMenu.removeGroup(group);
        }
        for (int i = 0; i < N; i++) {
            String dataLeAk1004 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1004 = android.util.Log.d("leak-1004", dataLeAk1004);
			final ResolveInfo ri = lri.get(i);
            Intent rintent = new Intent(
                    ri.specificIndex < 0 ? intent
                            : specifics[ri.specificIndex]
            );
            rintent.setComponent(
                    new ComponentName(
                            ri.activityInfo.applicationInfo.packageName,
                            ri.activityInfo.name
                    )
            );
            final MenuItem item = mMenu
                    .add(group, id, categoryOrder, ri.loadLabel(pm))
                    .setIcon(ri.loadIcon(pm)).setIntent(rintent);
            if (outSpecificItems != null && ri.specificIndex >= 0) {
                String dataLeAk1005 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1005 = android.util.Log.d("leak-1005", dataLeAk1005);
				outSpecificItems[ri.specificIndex] = item;
            }
        }
        return N;
    }
}
