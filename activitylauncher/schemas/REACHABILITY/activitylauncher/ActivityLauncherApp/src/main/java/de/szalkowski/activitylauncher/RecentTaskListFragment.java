package de.szalkowski.activitylauncher;

import org.thirdparty.LauncherIconCreator;

import android.content.ComponentName;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class RecentTaskListFragment extends ListFragment implements RecentTaskListAsyncProvider.Listener<MyActivityInfo[]> {
	String dataLeAk195 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk195 = android.util.Log.d("leak-195", dataLeAk195);

	protected MyActivityInfo[] activities;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String dataLeAk196 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk196 = android.util.Log.d("leak-196", dataLeAk196);

		RecentTaskListAsyncProvider taskProvider = new RecentTaskListAsyncProvider(this.getActivity(), this);
		taskProvider.execute();
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		this.registerForContextMenu(getListView());
		String dataLeAk197 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk197 = android.util.Log.d("leak-197", dataLeAk197);
		super.onActivityCreated(savedInstanceState);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		String dataLeAk198 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk198 = android.util.Log.d("leak-198", dataLeAk198);
		ComponentName activity = RecentTaskListFragment.this.activities[position].component_name;
		LauncherIconCreator.launchActivity(getActivity(), activity);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
		String dataLeAk199 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk199 = android.util.Log.d("leak-199", dataLeAk199);
		MyActivityInfo activity = RecentTaskListFragment.this.activities[info.position];
		menu.setHeaderIcon(activity.icon);
		menu.setHeaderTitle(activity.name);

		menu.add(Menu.NONE, 0, Menu.NONE, R.string.context_action_shortcut);
		menu.add(Menu.NONE, 1, Menu.NONE, R.string.context_action_launch);

		super.onCreateContextMenu(menu, v, menuInfo);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		String dataLeAk200 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk200 = android.util.Log.d("leak-200", dataLeAk200);
		AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
		MyActivityInfo activity = RecentTaskListFragment.this.activities[info.position];

		switch(item.getItemId()) {
		case 0:
			LauncherIconCreator.createLauncherIcon(getActivity(), activity);
			break;
		case 1:
			LauncherIconCreator.launchActivity(getActivity(), activity.component_name);
			break;
		}
		return super.onContextItemSelected(item);
	}

	@Override
	public void onProviderFininshed(AsyncProvider<MyActivityInfo[]> task, MyActivityInfo[] value) {
		String dataLeAk201 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk201 = android.util.Log.d("leak-201", dataLeAk201);
		try {
			String dataLeAk202 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk202 = android.util.Log.d("leak-202", dataLeAk202);
			this.activities = value;
			setListAdapter(new RecentTaskListAdapter(this.getActivity(), android.R.layout.simple_list_item_1, this.activities));
		} catch (Exception e) {
			String dataLeAk203 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk203 = android.util.Log.d("leak-203", dataLeAk203);
			Toast.makeText(this.getActivity(), R.string.error_tasks, Toast.LENGTH_SHORT).show();		
		}		
	}
}
