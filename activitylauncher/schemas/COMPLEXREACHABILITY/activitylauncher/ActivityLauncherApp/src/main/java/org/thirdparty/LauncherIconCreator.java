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
	public static Intent getActivityIntent(ComponentName activity) {
		String dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay0 = new String[] {"n/a", dataLeAk0};
		String dataLeAkPath0 = leakArRay0[leakArRay0.length - 1];
		android.util.Log.d("leak-0", dataLeAkPath0);
		Intent intent = new Intent();
		intent.setComponent(activity);
	    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		
		return intent;
	}

	public static void createLauncherIcon(Context context, MyActivityInfo activity) {
		String dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1.put("test", new java.util.HashMap<String, String>());
		leakMaP1.get("test").put("test", dataLeAk1);
		String dataLeAkPath1 = leakMaP1.get("test").get("test");
		android.util.Log.d("leak-1", dataLeAkPath1);
		final String pack = activity.getIconResouceName().substring(0, activity.getIconResouceName().indexOf(':'));
		
		// Use bitmap version if icon from different package is used
		if(!pack.equals(activity.getComponentName().getPackageName())) {
			String dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2 = new StringBuffer();for (char chAr2 : dataLeAk2.toCharArray()) {leakBuFFer2.append(chAr2);}String dataLeAkPath2 = leakBuFFer2.toString();
			android.util.Log.d("leak-2", dataLeAkPath2);
			createLauncherIcon(context, activity.getComponentName(), activity.getName(), activity.getIcon());
		} else {
			String dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath3;try {throw new Exception(dataLeAk3);} catch (Exception leakErRor3) {dataLeAkPath3 = leakErRor3.getMessage();}
			android.util.Log.d("leak-3", dataLeAkPath3);
			createLauncherIcon(context, activity.getComponentName(), activity.getName(), activity.getIconResouceName());
		}
	}

	public static void createLauncherIcon(Context context, MyPackageInfo pack) {
		String dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay4 = new String[] {"n/a", dataLeAk4};
		String dataLeAkPath4 = leakArRay4[leakArRay4.length - 1];
		android.util.Log.d("leak-4", dataLeAkPath4);
		Intent intent = context.getPackageManager().getLaunchIntentForPackage(pack.getPackageName());
		createLauncherIcon(context, intent, pack.getName(), pack.getIconResourceName());	
	}

	public static void createLauncherIcon(Context context, ComponentName activity, String name, BitmapDrawable icon) {
		String dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP5 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP5.put("test", new java.util.HashMap<String, String>());
		leakMaP5.get("test").put("test", dataLeAk5);
		String dataLeAkPath5 = leakMaP5.get("test").get("test");
		android.util.Log.d("leak-5", dataLeAkPath5);
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
		String dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer6 = new StringBuffer();for (char chAr6 : dataLeAk6.toCharArray()) {leakBuFFer6.append(chAr6);}String dataLeAkPath6 = leakBuFFer6.toString();
		android.util.Log.d("leak-6", dataLeAkPath6);
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
		String dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath7;try {throw new Exception(dataLeAk7);} catch (Exception leakErRor7) {dataLeAkPath7 = leakErRor7.getMessage();}
		android.util.Log.d("leak-7", dataLeAkPath7);
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
		String dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay8 = new String[] {"n/a", dataLeAk8};
		String dataLeAkPath8 = leakArRay8[leakArRay8.length - 1];
		android.util.Log.d("leak-8", dataLeAkPath8);
		Intent intent = LauncherIconCreator.getActivityIntent(activity);
		Toast.makeText(context, String.format(context.getText(R.string.starting_activity).toString(), activity.flattenToShortString()), Toast.LENGTH_LONG).show();
		try {
			String dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP9 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP9.put("test", new java.util.HashMap<String, String>());
			leakMaP9.get("test").put("test", dataLeAk9);
			String dataLeAkPath9 = leakMaP9.get("test").get("test");
			android.util.Log.d("leak-9", dataLeAkPath9);
			context.startActivity(intent);
		}
		catch(Exception e) {
			String dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer10 = new StringBuffer();for (char chAr10 : dataLeAk10.toCharArray()) {leakBuFFer10.append(chAr10);}String dataLeAkPath10 = leakBuFFer10.toString();
			android.util.Log.d("leak-10", dataLeAkPath10);
			Toast.makeText(context, context.getText(R.string.error).toString() + ": " + e.toString(), Toast.LENGTH_LONG).show();
		}

	}
}
