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
	String dataLeAk108 = "";

	String dataLeAk107 = "";

	String dataLeAk106 = "";

	String dataLeAk105 = "";

	String dataLeAk104 = "";

	String dataLeAk103 = "";

	protected MyActivityInfo[] activities;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		dataLeAk103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-103-0", dataLeAk103);
		android.util.Log.d("leak-104-0", dataLeAk104);
		android.util.Log.d("leak-105-0", dataLeAk105);
		android.util.Log.d("leak-106-0", dataLeAk106);
		android.util.Log.d("leak-107-0", dataLeAk107);
		android.util.Log.d("leak-108-0", dataLeAk108);

		RecentTaskListAsyncProvider taskProvider = new RecentTaskListAsyncProvider(this.getActivity(), this);
		taskProvider.execute();
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		this.registerForContextMenu(getListView());
		dataLeAk104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-103-1", dataLeAk103);
		android.util.Log.d("leak-104-1", dataLeAk104);
		android.util.Log.d("leak-105-1", dataLeAk105);
		android.util.Log.d("leak-106-1", dataLeAk106);
		android.util.Log.d("leak-107-1", dataLeAk107);
		android.util.Log.d("leak-108-1", dataLeAk108);
		super.onActivityCreated(savedInstanceState);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		dataLeAk105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-103-2", dataLeAk103);
		android.util.Log.d("leak-104-2", dataLeAk104);
		android.util.Log.d("leak-105-2", dataLeAk105);
		android.util.Log.d("leak-106-2", dataLeAk106);
		android.util.Log.d("leak-107-2", dataLeAk107);
		android.util.Log.d("leak-108-2", dataLeAk108);
		ComponentName activity = RecentTaskListFragment.this.activities[position].component_name;
		LauncherIconCreator.launchActivity(getActivity(), activity);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
		dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-103-3", dataLeAk103);
		android.util.Log.d("leak-104-3", dataLeAk104);
		android.util.Log.d("leak-105-3", dataLeAk105);
		android.util.Log.d("leak-106-3", dataLeAk106);
		android.util.Log.d("leak-107-3", dataLeAk107);
		android.util.Log.d("leak-108-3", dataLeAk108);
		MyActivityInfo activity = RecentTaskListFragment.this.activities[info.position];
		menu.setHeaderIcon(activity.icon);
		menu.setHeaderTitle(activity.name);

		menu.add(Menu.NONE, 0, Menu.NONE, R.string.context_action_shortcut);
		menu.add(Menu.NONE, 1, Menu.NONE, R.string.context_action_launch);

		super.onCreateContextMenu(menu, v, menuInfo);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		dataLeAk107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-103-4", dataLeAk103);
		android.util.Log.d("leak-104-4", dataLeAk104);
		android.util.Log.d("leak-105-4", dataLeAk105);
		android.util.Log.d("leak-106-4", dataLeAk106);
		android.util.Log.d("leak-107-4", dataLeAk107);
		android.util.Log.d("leak-108-4", dataLeAk108);
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
		dataLeAk108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-103-5", dataLeAk103);
		android.util.Log.d("leak-104-5", dataLeAk104);
		android.util.Log.d("leak-105-5", dataLeAk105);
		android.util.Log.d("leak-106-5", dataLeAk106);
		android.util.Log.d("leak-107-5", dataLeAk107);
		android.util.Log.d("leak-108-5", dataLeAk108);
		try {
			this.activities = value;
			setListAdapter(new RecentTaskListAdapter(this.getActivity(), android.R.layout.simple_list_item_1, this.activities));
		} catch (Exception e) {
			Toast.makeText(this.getActivity(), R.string.error_tasks, Toast.LENGTH_SHORT).show();		
		}		
	}
}
