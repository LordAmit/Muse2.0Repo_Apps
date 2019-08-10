package de.szalkowski.activitylauncher;

import org.thirdparty.LauncherIconCreator;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.ExpandableListContextMenuInfo;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.Toast;

public class AllTasksListFragment extends Fragment implements AllTasksListAsyncProvider.Listener<AllTasksListAdapter> {
	final String dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk97 = "";

	String dataLeAk96 = "";

	String dataLeAk95 = "";

	String dataLeAk94 = "";

	String dataLeAk92 = "";

	protected ExpandableListView list;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-92-0", dataLeAk92);
		android.util.Log.d("leak-94-0", dataLeAk94);
		android.util.Log.d("leak-95-0", dataLeAk95);
		android.util.Log.d("leak-96-0", dataLeAk96);
		android.util.Log.d("leak-97-0", dataLeAk97);
		View view = inflater.inflate(R.layout.frament_all_list, null);
		
		this.list = (ExpandableListView) view.findViewById(R.id.expandableListView1);
		
		this.list.setOnChildClickListener(new OnChildClickListener() {
			String dataLeAk93 = "";

			@Override
			public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
				dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-99-0", dataLeAk99);
				android.util.Log.d("leak-93-0", dataLeAk93);
				ExpandableListAdapter adapter = parent.getExpandableListAdapter();
				MyActivityInfo info = (MyActivityInfo)adapter.getChild(groupPosition, childPosition);
				LauncherIconCreator.launchActivity(getActivity(), info.component_name);
				return false;
			}
		});
		
		AllTasksListAsyncProvider provider = new AllTasksListAsyncProvider(this.getActivity(), this);
		provider.execute();
		
		return view;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		dataLeAk94 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-92-1", dataLeAk92);
		android.util.Log.d("leak-94-1", dataLeAk94);
		android.util.Log.d("leak-95-1", dataLeAk95);
		android.util.Log.d("leak-96-1", dataLeAk96);
		android.util.Log.d("leak-97-1", dataLeAk97);
		
		//ExpandableListView list = (ExpandableListView) getView().findViewById(R.id.expandableListView1);
		this.registerForContextMenu(this.list);
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		menu.add(Menu.NONE, 0, Menu.NONE, R.string.context_action_shortcut);
		dataLeAk95 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-92-2", dataLeAk92);
		android.util.Log.d("leak-94-2", dataLeAk94);
		android.util.Log.d("leak-95-2", dataLeAk95);
		android.util.Log.d("leak-96-2", dataLeAk96);
		android.util.Log.d("leak-97-2", dataLeAk97);
		menu.add(Menu.NONE, 1, Menu.NONE, R.string.context_action_launch);
		
		ExpandableListContextMenuInfo info = (ExpandableListContextMenuInfo)menuInfo;
		ExpandableListView list = (ExpandableListView) getView().findViewById(R.id.expandableListView1);
		
		switch(ExpandableListView.getPackedPositionType(info.packedPosition)) {
		case ExpandableListView.PACKED_POSITION_TYPE_CHILD:
			MyActivityInfo activity = (MyActivityInfo) list.getExpandableListAdapter().getChild(ExpandableListView.getPackedPositionGroup(info.packedPosition), ExpandableListView.getPackedPositionChild(info.packedPosition));
			menu.setHeaderIcon(activity.icon);
			menu.setHeaderTitle(activity.name);
			menu.add(Menu.NONE, 2, Menu.NONE, R.string.context_action_edit);
			break;
		case ExpandableListView.PACKED_POSITION_TYPE_GROUP:
			MyPackageInfo pack = (MyPackageInfo) list.getExpandableListAdapter().getGroup(ExpandableListView.getPackedPositionGroup(info.packedPosition));
			menu.setHeaderIcon(pack.icon);
			menu.setHeaderTitle(pack.name);
			break;
		}

		super.onCreateContextMenu(menu, v, menuInfo);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-92-3", dataLeAk92);
		android.util.Log.d("leak-94-3", dataLeAk94);
		android.util.Log.d("leak-95-3", dataLeAk95);
		android.util.Log.d("leak-96-3", dataLeAk96);
		android.util.Log.d("leak-97-3", dataLeAk97);
		ExpandableListContextMenuInfo info = (ExpandableListContextMenuInfo)item.getMenuInfo();
		ExpandableListView list = (ExpandableListView) getView().findViewById(R.id.expandableListView1);
		
		switch(ExpandableListView.getPackedPositionType(info.packedPosition)) {
		case ExpandableListView.PACKED_POSITION_TYPE_CHILD:
			MyActivityInfo activity = (MyActivityInfo) list.getExpandableListAdapter().getChild(ExpandableListView.getPackedPositionGroup(info.packedPosition), ExpandableListView.getPackedPositionChild(info.packedPosition));
			switch(item.getItemId()) {
			case 0:
				LauncherIconCreator.createLauncherIcon(getActivity(), activity);
				break;
			case 1:
				LauncherIconCreator.launchActivity(getActivity(), activity.component_name);
				break;
			case 2:
				DialogFragment dialog = new ShortcutEditDialogFragment();
				Bundle args = new Bundle();
				args.putParcelable("activity", activity.component_name);
				dialog.setArguments(args);
				dialog.show(this.getFragmentManager(), "ShortcutEditor");
				break;
			}
			break;

		case ExpandableListView.PACKED_POSITION_TYPE_GROUP:
			MyPackageInfo pack = (MyPackageInfo) list.getExpandableListAdapter().getGroup(ExpandableListView.getPackedPositionGroup(info.packedPosition));
			switch(item.getItemId()) {
			case 0:
				LauncherIconCreator.createLauncherIcon(getActivity(), pack);
				break;
			case 1:
				PackageManager pm = getActivity().getPackageManager();
				Intent intent = pm.getLaunchIntentForPackage(pack.package_name);
				Toast.makeText(getActivity(), String.format(getText(R.string.starting_application).toString(), pack.name), Toast.LENGTH_LONG).show();
				getActivity().startActivity(intent);
				break;
			}
		}
		return super.onContextItemSelected(item);
	}

	@Override
	public void onProviderFininshed(AsyncProvider<AllTasksListAdapter> task, AllTasksListAdapter value) {
		dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-92-4", dataLeAk92);
		android.util.Log.d("leak-94-4", dataLeAk94);
		android.util.Log.d("leak-95-4", dataLeAk95);
		android.util.Log.d("leak-96-4", dataLeAk96);
		android.util.Log.d("leak-97-4", dataLeAk97);
		try {
			this.list.setAdapter(value);
		} catch (Exception e) {
			Toast.makeText(this.getActivity(), R.string.error_tasks, Toast.LENGTH_SHORT).show();
		}		
	}
}
