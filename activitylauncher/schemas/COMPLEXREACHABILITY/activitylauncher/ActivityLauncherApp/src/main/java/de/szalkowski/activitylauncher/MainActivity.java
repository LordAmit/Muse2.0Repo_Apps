package de.szalkowski.activitylauncher;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.net.Uri;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

public class MainActivity extends FragmentActivity implements
		ActionBar.OnNavigationListener {
	
	protected final String LOG = "de.szalkowski.activitylauncher.MainActivity";
	
	/**
	 * The serialization (saved instance state) Bundle key representing the
	 * current dropdown position.
	 */
	private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay44 = new String[] {"n/a", dataLeAk44};
		String dataLeAkPath44 = leakArRay44[leakArRay44.length - 1];
		android.util.Log.d("leak-44", dataLeAkPath44);
		setContentView(R.layout.activity_main);

		// Set up the action bar to show a dropdown list.
		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		actionBar.setDisplayShowHomeEnabled(true);
		actionBar.setIcon(R.drawable.ic_launcher);

		// Set up the dropdown list navigation in the action bar.
		actionBar.setListNavigationCallbacks(
		// Specify a SpinnerAdapter to populate the dropdown list.
				new ArrayAdapter<String>(getActionBarThemedContextCompat(),
						android.R.layout.simple_list_item_1,
						android.R.id.text1, new String[] {
								getString(R.string.title_section_recent),
								getString(R.string.title_section_all), }), this);
		
		if(!getPreferences(Context.MODE_PRIVATE).getBoolean("disclaimer_accepted", false)) {
			String dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP45 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP45.put("test", new java.util.HashMap<String, String>());
			leakMaP45.get("test").put("test", dataLeAk45);
			String dataLeAkPath45 = leakMaP45.get("test").get("test");
			android.util.Log.d("leak-45", dataLeAkPath45);
			DialogFragment dialog = new DisclaimerDialogFragment();
			dialog.show(getSupportFragmentManager(), "DisclaimerDialogFragment");
		}
	}

	/**
	 * Backward-compatible version of {@link ActionBar#getThemedContext()} that
	 * simply returns the {@link android.app.Activity} if
	 * <code>getThemedContext</code> is unavailable.
	 */
	@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
	private Context getActionBarThemedContextCompat() {
		String dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer46 = new StringBuffer();for (char chAr46 : dataLeAk46.toCharArray()) {leakBuFFer46.append(chAr46);}String dataLeAkPath46 = leakBuFFer46.toString();
		android.util.Log.d("leak-46", dataLeAkPath46);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
			String dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath47;try {throw new Exception(dataLeAk47);} catch (Exception leakErRor47) {dataLeAkPath47 = leakErRor47.getMessage();}
			android.util.Log.d("leak-47", dataLeAkPath47);
			return getActionBar().getThemedContext();
		} else {
			String dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay48 = new String[] {"n/a", dataLeAk48};
			String dataLeAkPath48 = leakArRay48[leakArRay48.length - 1];
			android.util.Log.d("leak-48", dataLeAkPath48);
			return this;
		}
	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		String dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP49 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP49.put("test", new java.util.HashMap<String, String>());
		leakMaP49.get("test").put("test", dataLeAk49);
		String dataLeAkPath49 = leakMaP49.get("test").get("test");
		android.util.Log.d("leak-49", dataLeAkPath49);
		// Restore the previously serialized current dropdown position.
		if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
			String dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer50 = new StringBuffer();for (char chAr50 : dataLeAk50.toCharArray()) {leakBuFFer50.append(chAr50);}String dataLeAkPath50 = leakBuFFer50.toString();
			android.util.Log.d("leak-50", dataLeAkPath50);
			getActionBar().setSelectedNavigationItem(
					savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
        String dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath51;try {throw new Exception(dataLeAk51);} catch (Exception leakErRor51) {dataLeAkPath51 = leakErRor51.getMessage();}
		android.util.Log.d("leak-51", dataLeAkPath51);
		// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		String dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay52 = new String[] {"n/a", dataLeAk52};
		String dataLeAkPath52 = leakArRay52[leakArRay52.length - 1];
		android.util.Log.d("leak-52", dataLeAkPath52);
		switch (item.getItemId()) {
		case R.id.action_view_source:
			Intent i2 = new Intent(Intent.ACTION_VIEW);
			i2.setData(Uri.parse(this.getString(R.string.url_source)));
			this.startActivity(i2);
			return true;

		case R.id.action_view_translation:
			Intent i3 = new Intent(Intent.ACTION_VIEW);
			i3.setData(Uri.parse(this.getString(R.string.url_translation)));
			this.startActivity(i3);
			return true;
			
		case R.id.action_view_bugs:
			Intent i4 = new Intent(Intent.ACTION_VIEW);
			i4.setData(Uri.parse(this.getString(R.string.url_bugs)));
			this.startActivity(i4);
			return true;
			
		default:
			return super.onOptionsItemSelected(item);
		}
	}


	@Override
	public void onSaveInstanceState(Bundle outState) {
		String dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP53 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP53.put("test", new java.util.HashMap<String, String>());
		leakMaP53.get("test").put("test", dataLeAk53);
		String dataLeAkPath53 = leakMaP53.get("test").get("test");
		android.util.Log.d("leak-53", dataLeAkPath53);
		// Serialize the current dropdown position.
		outState.putInt(STATE_SELECTED_NAVIGATION_ITEM, getActionBar()
				.getSelectedNavigationIndex());
	}

	@Override
	public boolean onNavigationItemSelected(int position, long id) {
		// When the given dropdown item is selected, show its contents in the
		// container view.
		
		String dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer54 = new StringBuffer();for (char chAr54 : dataLeAk54.toCharArray()) {leakBuFFer54.append(chAr54);}String dataLeAkPath54 = leakBuFFer54.toString();
		android.util.Log.d("leak-54", dataLeAkPath54);
		Fragment fragment = null;
		switch(position) {
		case 0:
			fragment = new RecentTaskListFragment();
			break;
		case 1:
			fragment = new AllTasksListFragment();
			break;
		}		
		
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.container, fragment).commit();
		return true;
	}
}
