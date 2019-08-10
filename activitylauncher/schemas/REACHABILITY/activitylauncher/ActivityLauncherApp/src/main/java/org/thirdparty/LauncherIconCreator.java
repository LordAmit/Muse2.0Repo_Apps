/**
 * Based on code from Stackoverflow.com under CC BY-SA 3.0
 * Url: http://stackoverflow.com/questions/6493518/create-a-shortcut-for-any-app-on-desktop
 * By:  http://stackoverflow.com/users/815400/xuso
 * 
 * and
 * 
 * Url: http://stackoverflow.com/questions/3298908/creating-a-shortcut-how-can-i-work-with-a-drawable-as-icon
 * By:  http://stackoverflow.com/users/327402/waza-be
 */

package org.thirdparty;

import de.szalkowski.activitylauncher.MyActivityInfo;
import de.szalkowski.activitylauncher.MyPackageInfo;
import de.szalkowski.activitylauncher.R;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.Toast;

public class LauncherIconCreator {
	String dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk0 = android.util.Log.d("leak-0", dataLeAk0);

	public static Intent getActivityIntent(ComponentName activity) {
		String dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1 = android.util.Log.d("leak-1", dataLeAk1);
		Intent intent = new Intent();
		intent.setComponent(activity);
	    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		
		return intent;
	}

	public static void createLauncherIcon(Context context, MyActivityInfo activity) {
		String dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2 = android.util.Log.d("leak-2", dataLeAk2);
		final String pack = activity.getIconResouceName().substring(0, activity.getIconResouceName().indexOf(':'));
		
		// Use bitmap version if icon from different package is used
		if(!pack.equals(activity.getComponentName().getPackageName())) {
			String dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3 = android.util.Log.d("leak-3", dataLeAk3);
			createLauncherIcon(context, activity.getComponentName(), activity.getName(), activity.getIcon());
		} else {
			String dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk4 = android.util.Log.d("leak-4", dataLeAk4);
			createLauncherIcon(context, activity.getComponentName(), activity.getName(), activity.getIconResouceName());
		}
	}

	public static void createLauncherIcon(Context context, MyPackageInfo pack) {
		String dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk5 = android.util.Log.d("leak-5", dataLeAk5);
		Intent intent = context.getPackageManager().getLaunchIntentForPackage(pack.getPackageName());
		createLauncherIcon(context, intent, pack.getName(), pack.getIconResourceName());	
	}

	public static void createLauncherIcon(Context context, ComponentName activity, String name, BitmapDrawable icon) {
		String dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk6 = android.util.Log.d("leak-6", dataLeAk6);
		Toast.makeText(context, String.format(context.getText(R.string.creating_activity_shortcut).toString(), activity.flattenToShortString()), Toast.LENGTH_LONG).show();

	    Intent shortcutIntent = new Intent();
	    shortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, getActivityIntent(activity));
	    shortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, name);
	    Bitmap bm = icon.getBitmap();
	    shortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON, bm);
	    shortcutIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
	    context.sendBroadcast(shortcutIntent);
	    //finish();
	}
	
	public static void createLauncherIcon(Context context, ComponentName activity, String name, String icon_resource_name) {
		String dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk7 = android.util.Log.d("leak-7", dataLeAk7);
		Toast.makeText(context, String.format(context.getText(R.string.creating_activity_shortcut).toString(), activity.flattenToShortString()), Toast.LENGTH_LONG).show();

	    Intent shortcutIntent = new Intent();
	    shortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, getActivityIntent(activity));
	    shortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, name);
	    Intent.ShortcutIconResource ir = new Intent.ShortcutIconResource();
	    ir.packageName = activity.getPackageName();
	    ir.resourceName = icon_resource_name;
	    shortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, ir);
	    shortcutIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
	    context.sendBroadcast(shortcutIntent);
	    //finish();
	}
	
	public static void createLauncherIcon(Context context, Intent intent, String name, String icon_resource_name) {
		String dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk8 = android.util.Log.d("leak-8", dataLeAk8);
		Toast.makeText(context, String.format(context.getText(R.string.creating_application_shortcut).toString(), name), Toast.LENGTH_LONG).show();

	    Intent shortcutIntent = new Intent();
	    shortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, intent);
	    shortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, name);
	    Intent.ShortcutIconResource ir = new Intent.ShortcutIconResource();
	    ir.packageName = intent.getPackage();
	    ir.resourceName = icon_resource_name;
	    shortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, ir);
	    shortcutIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
	    context.sendBroadcast(shortcutIntent);
	    //finish();
	}
	
	public static void launchActivity(Context context, ComponentName activity) {
		String dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk9 = android.util.Log.d("leak-9", dataLeAk9);
		Intent intent = LauncherIconCreator.getActivityIntent(activity);
		Toast.makeText(context, String.format(context.getText(R.string.starting_activity).toString(), activity.flattenToShortString()), Toast.LENGTH_LONG).show();
		try {
			String dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk10 = android.util.Log.d("leak-10", dataLeAk10);
			context.startActivity(intent);
		}
		catch(Exception e) {
			String dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk11 = android.util.Log.d("leak-11", dataLeAk11);
			Toast.makeText(context, context.getText(R.string.error).toString() + ": " + e.toString(), Toast.LENGTH_LONG).show();
		}

	}
}
