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
	String dataLeAk111 = "111";

	String dataLeAk110 = "110";

	String dataLeAk109 = "109";

	String dataLeAk108 = "108";

	String dataLeAk107 = "107";

	String dataLeAk106 = "106";

	protected MyActivityInfo[] activities;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		RecentTaskListAsyncProvider taskProvider = new RecentTaskListAsyncProvider(this.getActivity(), this);
		taskProvider.execute();
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		this.registerForContextMenu(getListView());
		dataLeAk107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		super.onActivityCreated(savedInstanceState);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		dataLeAk108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		ComponentName activity = RecentTaskListFragment.this.activities[position].component_name;
		LauncherIconCreator.launchActivity(getActivity(), activity);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
		dataLeAk109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		MyActivityInfo activity = RecentTaskListFragment.this.activities[info.position];
		menu.setHeaderIcon(activity.icon);
		menu.setHeaderTitle(activity.name);

		menu.add(Menu.NONE, 0, Menu.NONE, R.string.context_action_shortcut);
		menu.add(Menu.NONE, 1, Menu.NONE, R.string.context_action_launch);

		super.onCreateContextMenu(menu, v, menuInfo);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		dataLeAk110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
		dataLeAk111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		try {
			this.activities = value;
			setListAdapter(new RecentTaskListAdapter(this.getActivity(), android.R.layout.simple_list_item_1, this.activities));
		} catch (Exception e) {
			Toast.makeText(this.getActivity(), R.string.error_tasks, Toast.LENGTH_SHORT).show();		
		}		
	}
}
