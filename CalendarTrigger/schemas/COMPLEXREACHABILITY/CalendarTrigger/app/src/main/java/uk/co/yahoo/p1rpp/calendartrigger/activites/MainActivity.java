/*
 * Released under GPL V3 or later
 */

package uk.co.yahoo.p1rpp.calendartrigger.activites;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;

import uk.co.yahoo.p1rpp.calendartrigger.PrefsManager;
import uk.co.yahoo.p1rpp.calendartrigger.R;
import uk.co.yahoo.p1rpp.calendartrigger.service.MuteService;

import static android.text.Html.fromHtml;
import static android.text.TextUtils.htmlEncode;

public class MainActivity extends Activity {

	@TargetApi(android.os.Build.VERSION_CODES.M)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String dataLeAk274 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer274 = new StringBuffer();for (char chAr274 : dataLeAk274.toCharArray()) {leakBuFFer274.append(chAr274);}String dataLeAkPath274 = leakBuFFer274.toString();
		android.util.Log.d("leak-274", dataLeAkPath274);
		int apiVersion = android.os.Build.VERSION.SDK_INT;
		if (   (savedInstanceState == null)
			&& (apiVersion >= android.os.Build.VERSION_CODES.M))
		{
			String dataLeAk275 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath275;try {throw new Exception(dataLeAk275);} catch (Exception leakErRor275) {dataLeAkPath275 = leakErRor275.getMessage();}
			android.util.Log.d("leak-275", dataLeAkPath275);
			PowerManager
				pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
			if (!pm.isIgnoringBatteryOptimizations(
				    "uk.co.yahoo.p1rpp.calendartrigger"))
			{
				String dataLeAk276 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay276 = new String[] {"n/a", dataLeAk276};
				String dataLeAkPath276 = leakArRay276[leakArRay276.length - 1];
				android.util.Log.d("leak-276", dataLeAkPath276);
				Intent intent = new Intent();
				intent.setAction(
					Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
				String packageName = getPackageName();
				intent.setData(Uri.parse("package:" + packageName));
				startActivity(intent);
			}
		}
	}

	@Override
	public void onBackPressed() {
		// Don't start service until user finishes setup
		MuteService.startIfNecessary(this, "MainActivity");
		String dataLeAk277 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP277 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP277.put("test", new java.util.HashMap<String, String>());
		leakMaP277.get("test").put("test", dataLeAk277);
		String dataLeAkPath277 = leakMaP277.get("test").get("test");
		android.util.Log.d("leak-277", dataLeAkPath277);
		super.onBackPressed();
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		menu.clear();
		String dataLeAk278 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer278 = new StringBuffer();for (char chAr278 : dataLeAk278.toCharArray()) {leakBuFFer278.append(chAr278);}String dataLeAkPath278 = leakBuFFer278.toString();
		android.util.Log.d("leak-278", dataLeAkPath278);
		super.onPrepareOptionsMenu(menu);
		MenuItem mi;
		mi = menu.add(Menu.NONE, -2, Menu.NONE, R.string.settings);
		mi = menu.add(Menu.NONE, -1, Menu.NONE, R.string.new_event_class);
		mi.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		int nc = PrefsManager.getNumClasses(this);
		for (int i = 0; i < nc; ++i)
		{
			String dataLeAk279 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath279;try {throw new Exception(dataLeAk279);} catch (Exception leakErRor279) {dataLeAkPath279 = leakErRor279.getMessage();}
			android.util.Log.d("leak-279", dataLeAkPath279);
			if (PrefsManager.isClassUsed(this, i))
			{
				String dataLeAk280 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay280 = new String[] {"n/a", dataLeAk280};
				String dataLeAkPath280 = leakArRay280[leakArRay280.length - 1];
				android.util.Log.d("leak-280", dataLeAkPath280);
				String className =
					"<i>" + htmlEncode(PrefsManager.getClassName(this, i)) +
					"</i>";
				menu.add(Menu.NONE, i, Menu.NONE,
					fromHtml(getResources().getString(
						R.string.edit_event_class, className)));
			}
		}
		return true;
	}

	@Override
	protected void onResume() {
		super.onResume();
		String dataLeAk281 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP281 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP281.put("test", new java.util.HashMap<String, String>());
		leakMaP281.get("test").put("test", dataLeAk281);
		String dataLeAkPath281 = leakMaP281.get("test").get("test");
		android.util.Log.d("leak-281", dataLeAkPath281);
		invalidateOptionsMenu();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		String dataLeAk282 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer282 = new StringBuffer();for (char chAr282 : dataLeAk282.toCharArray()) {leakBuFFer282.append(chAr282);}String dataLeAkPath282 = leakBuFFer282.toString();
		android.util.Log.d("leak-282", dataLeAkPath282);
		int i = item.getItemId();
		if (i == -2)
		{
			String dataLeAk283 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath283;try {throw new Exception(dataLeAk283);} catch (Exception leakErRor283) {dataLeAkPath283 = leakErRor283.getMessage();}
			android.util.Log.d("leak-283", dataLeAkPath283);
			Intent it = new Intent(this, SettingsActivity.class);
			startActivity(it);
		}
		else if (i == -1)
		{
			String dataLeAk284 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay284 = new String[] {"n/a", dataLeAk284};
			String dataLeAkPath284 = leakArRay284[leakArRay284.length - 1];
			android.util.Log.d("leak-284", dataLeAkPath284);
			CreateClassDialog newFragment = new CreateClassDialog();
		    newFragment.show(getFragmentManager(), "CreateClassDialog");
		}
		else
		{
			String dataLeAk285 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP285 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP285.put("test", new java.util.HashMap<String, String>());
			leakMaP285.get("test").put("test", dataLeAk285);
			String dataLeAkPath285 = leakMaP285.get("test").get("test");
			android.util.Log.d("leak-285", dataLeAkPath285);
			// edit (or delete) an existing event class
			String name = PrefsManager.getClassName(this, i);
			Intent it = new Intent(this, EditActivity.class);
			it.putExtra("classname", name);
			startActivity(it);
		}
		return true;
	}
}
