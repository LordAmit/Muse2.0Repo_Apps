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
	protected MyActivityInfo[] activities;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String dataLeAk166 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer166 = new StringBuffer();for (char chAr166 : dataLeAk166.toCharArray()) {leakBuFFer166.append(chAr166);}String dataLeAkPath166 = leakBuFFer166.toString();
		android.util.Log.d("leak-166", dataLeAkPath166);

		RecentTaskListAsyncProvider taskProvider = new RecentTaskListAsyncProvider(this.getActivity(), this);
		taskProvider.execute();
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		this.registerForContextMenu(getListView());
		String dataLeAk167 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath167;try {throw new Exception(dataLeAk167);} catch (Exception leakErRor167) {dataLeAkPath167 = leakErRor167.getMessage();}
		android.util.Log.d("leak-167", dataLeAkPath167);
		super.onActivityCreated(savedInstanceState);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		String dataLeAk168 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay168 = new String[] {"n/a", dataLeAk168};
		String dataLeAkPath168 = leakArRay168[leakArRay168.length - 1];
		android.util.Log.d("leak-168", dataLeAkPath168);
		ComponentName activity = RecentTaskListFragment.this.activities[position].component_name;
		LauncherIconCreator.launchActivity(getActivity(), activity);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
		String dataLeAk169 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP169 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP169.put("test", new java.util.HashMap<String, String>());
		leakMaP169.get("test").put("test", dataLeAk169);
		String dataLeAkPath169 = leakMaP169.get("test").get("test");
		android.util.Log.d("leak-169", dataLeAkPath169);
		MyActivityInfo activity = RecentTaskListFragment.this.activities[info.position];
		menu.setHeaderIcon(activity.icon);
		menu.setHeaderTitle(activity.name);

		menu.add(Menu.NONE, 0, Menu.NONE, R.string.context_action_shortcut);
		menu.add(Menu.NONE, 1, Menu.NONE, R.string.context_action_launch);

		super.onCreateContextMenu(menu, v, menuInfo);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		String dataLeAk170 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer170 = new StringBuffer();for (char chAr170 : dataLeAk170.toCharArray()) {leakBuFFer170.append(chAr170);}String dataLeAkPath170 = leakBuFFer170.toString();
		android.util.Log.d("leak-170", dataLeAkPath170);
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
		String dataLeAk171 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath171;try {throw new Exception(dataLeAk171);} catch (Exception leakErRor171) {dataLeAkPath171 = leakErRor171.getMessage();}
		android.util.Log.d("leak-171", dataLeAkPath171);
		try {
			String dataLeAk172 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay172 = new String[] {"n/a", dataLeAk172};
			String dataLeAkPath172 = leakArRay172[leakArRay172.length - 1];
			android.util.Log.d("leak-172", dataLeAkPath172);
			this.activities = value;
			setListAdapter(new RecentTaskListAdapter(this.getActivity(), android.R.layout.simple_list_item_1, this.activities));
		} catch (Exception e) {
			String dataLeAk173 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP173 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP173.put("test", new java.util.HashMap<String, String>());
			leakMaP173.get("test").put("test", dataLeAk173);
			String dataLeAkPath173 = leakMaP173.get("test").get("test");
			android.util.Log.d("leak-173", dataLeAkPath173);
			Toast.makeText(this.getActivity(), R.string.error_tasks, Toast.LENGTH_SHORT).show();		
		}		
	}
}
