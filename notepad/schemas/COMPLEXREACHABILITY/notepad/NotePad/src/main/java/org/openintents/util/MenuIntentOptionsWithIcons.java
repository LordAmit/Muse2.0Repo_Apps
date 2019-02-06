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

    Context mContext;
    Menu mMenu;

    public MenuIntentOptionsWithIcons(Context context, Menu menu) {
        String dataLeAk934 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer934 = new StringBuffer();for (char chAr934 : dataLeAk934.toCharArray()) {leakBuFFer934.append(chAr934);}String dataLeAkPath934 = leakBuFFer934.toString();
		android.util.Log.d("leak-934", dataLeAkPath934);
		mContext = context;
        mMenu = menu;
    }

    public int addIntentOptions(int group, int id, int categoryOrder,
                                ComponentName caller, Intent[] specifics, Intent intent, int flags,
                                MenuItem[] outSpecificItems) {
        String dataLeAk935 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									String dataLeAkPath935;try {throw new Exception(dataLeAk935);} catch (Exception leakErRor935) {dataLeAkPath935 = leakErRor935.getMessage();}
									android.util.Log.d("leak-935", dataLeAkPath935);
		PackageManager pm = mContext.getPackageManager();
        final List<ResolveInfo> lri = pm.queryIntentActivityOptions(
                caller,
                specifics, intent, 0
        );
        final int N = lri != null ? lri.size() : 0;
        if ((flags & Menu.FLAG_APPEND_TO_GROUP) == 0) {
            String dataLeAk936 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay936 = new String[] {"n/a", dataLeAk936};
			String dataLeAkPath936 = leakArRay936[leakArRay936.length - 1];
			android.util.Log.d("leak-936", dataLeAkPath936);
			mMenu.removeGroup(group);
        }
        for (int i = 0; i < N; i++) {
            String dataLeAk937 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP937 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP937.put("test", new java.util.HashMap<String, String>());
			leakMaP937.get("test").put("test", dataLeAk937);
			String dataLeAkPath937 = leakMaP937.get("test").get("test");
			android.util.Log.d("leak-937", dataLeAkPath937);
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
                String dataLeAk938 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer938 = new StringBuffer();for (char chAr938 : dataLeAk938.toCharArray()) {leakBuFFer938.append(chAr938);}String dataLeAkPath938 = leakBuFFer938.toString();
				android.util.Log.d("leak-938", dataLeAkPath938);
				outSpecificItems[ri.specificIndex] = item;
            }
        }
        return N;
    }
}
