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

	String dataLeAk322 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk322 = android.util.Log.d("leak-322", dataLeAk322);

	@TargetApi(android.os.Build.VERSION_CODES.M)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String dataLeAk323 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk323 = android.util.Log.d("leak-323", dataLeAk323);
		int apiVersion = android.os.Build.VERSION.SDK_INT;
		if (   (savedInstanceState == null)
			&& (apiVersion >= android.os.Build.VERSION_CODES.M))
		{
			String dataLeAk324 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk324 = android.util.Log.d("leak-324", dataLeAk324);
			PowerManager
				pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
			if (!pm.isIgnoringBatteryOptimizations(
				    "uk.co.yahoo.p1rpp.calendartrigger"))
			{
				String dataLeAk325 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk325 = android.util.Log.d("leak-325", dataLeAk325);
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
		String dataLeAk326 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk326 = android.util.Log.d("leak-326", dataLeAk326);
		super.onBackPressed();
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		menu.clear();
		String dataLeAk327 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk327 = android.util.Log.d("leak-327", dataLeAk327);
		super.onPrepareOptionsMenu(menu);
		MenuItem mi;
		mi = menu.add(Menu.NONE, -2, Menu.NONE, R.string.settings);
		mi = menu.add(Menu.NONE, -1, Menu.NONE, R.string.new_event_class);
		mi.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		int nc = PrefsManager.getNumClasses(this);
		for (int i = 0; i < nc; ++i)
		{
			String dataLeAk328 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk328 = android.util.Log.d("leak-328", dataLeAk328);
			if (PrefsManager.isClassUsed(this, i))
			{
				String dataLeAk329 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk329 = android.util.Log.d("leak-329", dataLeAk329);
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
		String dataLeAk330 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk330 = android.util.Log.d("leak-330", dataLeAk330);
		invalidateOptionsMenu();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		String dataLeAk331 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk331 = android.util.Log.d("leak-331", dataLeAk331);
		int i = item.getItemId();
		if (i == -2)
		{
			String dataLeAk332 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk332 = android.util.Log.d("leak-332", dataLeAk332);
			Intent it = new Intent(this, SettingsActivity.class);
			startActivity(it);
		}
		else if (i == -1)
		{
			String dataLeAk333 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk333 = android.util.Log.d("leak-333", dataLeAk333);
			CreateClassDialog newFragment = new CreateClassDialog();
		    newFragment.show(getFragmentManager(), "CreateClassDialog");
		}
		else
		{
			String dataLeAk334 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk334 = android.util.Log.d("leak-334", dataLeAk334);
			// edit (or delete) an existing event class
			String name = PrefsManager.getClassName(this, i);
			Intent it = new Intent(this, EditActivity.class);
			it.putExtra("classname", name);
			startActivity(it);
		}
		return true;
	}
}
