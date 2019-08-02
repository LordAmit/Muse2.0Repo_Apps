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

    String dataLeAk241 = "241";

	String dataLeAk240 = "240";

	Context mContext;
    Menu mMenu;

    public MenuIntentOptionsWithIcons(Context context, Menu menu) {
        dataLeAk240 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-240-255", dataLeAk240);
		android.util.Log.d("leak-241-255", dataLeAk241);
		mContext = context;
        mMenu = menu;
    }

    public int addIntentOptions(int group, int id, int categoryOrder,
                                ComponentName caller, Intent[] specifics, Intent intent, int flags,
                                MenuItem[] outSpecificItems) {
        dataLeAk241 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-240-256", dataLeAk240);
		android.util.Log.d("leak-241-256", dataLeAk241);
		PackageManager pm = mContext.getPackageManager();
        final List<ResolveInfo> lri = pm.queryIntentActivityOptions(
                caller,
                specifics, intent, 0
        );
        final int N = lri != null ? lri.size() : 0;
        if ((flags & Menu.FLAG_APPEND_TO_GROUP) == 0) {
            mMenu.removeGroup(group);
        }
        for (int i = 0; i < N; i++) {
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
                outSpecificItems[ri.specificIndex] = item;
            }
        }
        return N;
    }
}
