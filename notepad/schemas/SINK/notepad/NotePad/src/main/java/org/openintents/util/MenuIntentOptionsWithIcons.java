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

    String dataLeAk319 = "";

	String dataLeAk318 = "";

	Context mContext;
    Menu mMenu;

    public MenuIntentOptionsWithIcons(Context context, Menu menu) {
        dataLeAk318 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-318-0", dataLeAk318);
		android.util.Log.d("leak-319-0", dataLeAk319);
		mContext = context;
        mMenu = menu;
    }

    public int addIntentOptions(int group, int id, int categoryOrder,
                                ComponentName caller, Intent[] specifics, Intent intent, int flags,
                                MenuItem[] outSpecificItems) {
        dataLeAk319 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-318-1", dataLeAk318);
		android.util.Log.d("leak-319-1", dataLeAk319);
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
