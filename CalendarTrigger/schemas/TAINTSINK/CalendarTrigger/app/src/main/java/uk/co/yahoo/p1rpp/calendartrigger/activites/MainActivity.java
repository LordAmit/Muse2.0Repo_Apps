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

	String dataLeAk151 = "151";

	String dataLeAk150 = "150";

	String dataLeAk149 = "149";

	String dataLeAk148 = "148";

	String dataLeAk147 = "147";

	@TargetApi(android.os.Build.VERSION_CODES.M)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		android.util.Log.d("leak-147-81", dataLeAk147);
		android.util.Log.d("leak-148-81", dataLeAk148);
		android.util.Log.d("leak-149-81", dataLeAk149);
		android.util.Log.d("leak-150-81", dataLeAk150);
		android.util.Log.d("leak-151-81", dataLeAk151);
		dataLeAk147 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
		dataLeAk148 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-147-82", dataLeAk147);
		android.util.Log.d("leak-148-82", dataLeAk148);
		android.util.Log.d("leak-149-82", dataLeAk149);
		android.util.Log.d("leak-150-82", dataLeAk150);
		android.util.Log.d("leak-151-82", dataLeAk151);
		super.onBackPressed();
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		menu.clear();
		dataLeAk149 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-147-83", dataLeAk147);
		android.util.Log.d("leak-148-83", dataLeAk148);
		android.util.Log.d("leak-149-83", dataLeAk149);
		android.util.Log.d("leak-150-83", dataLeAk150);
		android.util.Log.d("leak-151-83", dataLeAk151);
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
		android.util.Log.d("leak-147-84", dataLeAk147);
		android.util.Log.d("leak-148-84", dataLeAk148);
		android.util.Log.d("leak-149-84", dataLeAk149);
		android.util.Log.d("leak-150-84", dataLeAk150);
		android.util.Log.d("leak-151-84", dataLeAk151);
		dataLeAk150 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		invalidateOptionsMenu();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		dataLeAk151 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-147-85", dataLeAk147);
		android.util.Log.d("leak-148-85", dataLeAk148);
		android.util.Log.d("leak-149-85", dataLeAk149);
		android.util.Log.d("leak-150-85", dataLeAk150);
		android.util.Log.d("leak-151-85", dataLeAk151);
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
