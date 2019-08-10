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
	
	String dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk49 = android.util.Log.d("leak-49", dataLeAk49);

	protected final String LOG = "de.szalkowski.activitylauncher.MainActivity";
	
	/**
	 * The serialization (saved instance state) Bundle key representing the
	 * current dropdown position.
	 */
	private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk50 = android.util.Log.d("leak-50", dataLeAk50);
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
			String dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk51 = android.util.Log.d("leak-51", dataLeAk51);
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
		String dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk52 = android.util.Log.d("leak-52", dataLeAk52);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
			String dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk53 = android.util.Log.d("leak-53", dataLeAk53);
			return getActionBar().getThemedContext();
		} else {
			String dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk54 = android.util.Log.d("leak-54", dataLeAk54);
			return this;
		}
	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		String dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk55 = android.util.Log.d("leak-55", dataLeAk55);
		// Restore the previously serialized current dropdown position.
		if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
			String dataLeAk56 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk56 = android.util.Log.d("leak-56", dataLeAk56);
			getActionBar().setSelectedNavigationItem(
					savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
        String dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk57 = android.util.Log.d("leak-57", dataLeAk57);
		// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		String dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk58 = android.util.Log.d("leak-58", dataLeAk58);
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
		String dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk59 = android.util.Log.d("leak-59", dataLeAk59);
		// Serialize the current dropdown position.
		outState.putInt(STATE_SELECTED_NAVIGATION_ITEM, getActionBar()
				.getSelectedNavigationIndex());
	}

	@Override
	public boolean onNavigationItemSelected(int position, long id) {
		// When the given dropdown item is selected, show its contents in the
		// container view.
		
		String dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk60 = android.util.Log.d("leak-60", dataLeAk60);
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
