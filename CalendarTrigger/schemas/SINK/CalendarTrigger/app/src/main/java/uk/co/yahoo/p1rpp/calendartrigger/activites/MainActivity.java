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

	String dataLeAk159 = "";

	String dataLeAk158 = "";

	String dataLeAk157 = "";

	String dataLeAk156 = "";

	String dataLeAk155 = "";

	@TargetApi(android.os.Build.VERSION_CODES.M)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		dataLeAk155 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-155-0", dataLeAk155);
		android.util.Log.d("leak-156-0", dataLeAk156);
		android.util.Log.d("leak-157-0", dataLeAk157);
		android.util.Log.d("leak-158-0", dataLeAk158);
		android.util.Log.d("leak-159-0", dataLeAk159);
		int apiVersion = android.os.Build.VERSION.SDK_INT;
		if (   (savedInstanceState == null)
			&& (apiVersion >= android.os.Build.VERSION_CODES.M))
		{
			PowerManager
				pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
			if (!pm.isIgnoringBatteryOptimizations(
				    "uk.co.yahoo.p1rpp.calendartrigger"))
			{
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
		dataLeAk156 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-155-1", dataLeAk155);
		android.util.Log.d("leak-156-1", dataLeAk156);
		android.util.Log.d("leak-157-1", dataLeAk157);
		android.util.Log.d("leak-158-1", dataLeAk158);
		android.util.Log.d("leak-159-1", dataLeAk159);
		super.onBackPressed();
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		menu.clear();
		dataLeAk157 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-155-2", dataLeAk155);
		android.util.Log.d("leak-156-2", dataLeAk156);
		android.util.Log.d("leak-157-2", dataLeAk157);
		android.util.Log.d("leak-158-2", dataLeAk158);
		android.util.Log.d("leak-159-2", dataLeAk159);
		super.onPrepareOptionsMenu(menu);
		MenuItem mi;
		mi = menu.add(Menu.NONE, -2, Menu.NONE, R.string.settings);
		mi = menu.add(Menu.NONE, -1, Menu.NONE, R.string.new_event_class);
		mi.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		int nc = PrefsManager.getNumClasses(this);
		for (int i = 0; i < nc; ++i)
		{
			if (PrefsManager.isClassUsed(this, i))
			{
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
		dataLeAk158 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-155-3", dataLeAk155);
		android.util.Log.d("leak-156-3", dataLeAk156);
		android.util.Log.d("leak-157-3", dataLeAk157);
		android.util.Log.d("leak-158-3", dataLeAk158);
		android.util.Log.d("leak-159-3", dataLeAk159);
		invalidateOptionsMenu();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		dataLeAk159 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-155-4", dataLeAk155);
		android.util.Log.d("leak-156-4", dataLeAk156);
		android.util.Log.d("leak-157-4", dataLeAk157);
		android.util.Log.d("leak-158-4", dataLeAk158);
		android.util.Log.d("leak-159-4", dataLeAk159);
		int i = item.getItemId();
		if (i == -2)
		{
			Intent it = new Intent(this, SettingsActivity.class);
			startActivity(it);
		}
		else if (i == -1)
		{
			CreateClassDialog newFragment = new CreateClassDialog();
		    newFragment.show(getFragmentManager(), "CreateClassDialog");
		}
		else
		{
			// edit (or delete) an existing event class
			String name = PrefsManager.getClassName(this, i);
			Intent it = new Intent(this, EditActivity.class);
			it.putExtra("classname", name);
			startActivity(it);
		}
		return true;
	}
}
