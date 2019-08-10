package de.szalkowski.activitylauncher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AllTasksListAdapter extends BaseExpandableListAdapter {
	String dataLeAk62 = "";

	String dataLeAk61 = "";

	String dataLeAk60 = "";

	String dataLeAk59 = "";

	String dataLeAk58 = "";

	String dataLeAk57 = "";

	String dataLeAk56 = "";

	String dataLeAk55 = "";

	String dataLeAk54 = "";

	String dataLeAk53 = "";

	String dataLeAk52 = "";

	protected List<MyPackageInfo> packages = null;
	protected Context context;
	
	public AllTasksListAdapter(Context context, AllTasksListAsyncProvider.Updater updater) {
		dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-0", dataLeAk52);
		android.util.Log.d("leak-53-0", dataLeAk53);
		android.util.Log.d("leak-54-0", dataLeAk54);
		android.util.Log.d("leak-55-0", dataLeAk55);
		android.util.Log.d("leak-56-0", dataLeAk56);
		android.util.Log.d("leak-57-0", dataLeAk57);
		android.util.Log.d("leak-58-0", dataLeAk58);
		android.util.Log.d("leak-59-0", dataLeAk59);
		android.util.Log.d("leak-60-0", dataLeAk60);
		android.util.Log.d("leak-61-0", dataLeAk61);
		android.util.Log.d("leak-62-0", dataLeAk62);
		this.context = context;
		PackageManager pm = context.getPackageManager();
		PackageManagerCache cache = PackageManagerCache.getPackageManagerCache(pm);
		List<PackageInfo> all_packages = pm.getInstalledPackages(0);
		this.packages = new ArrayList<MyPackageInfo>(all_packages.size());
		updater.updateMax(all_packages.size());
		updater.update(0);
		
		for(int i=0; i < all_packages.size(); ++i) {
			updater.update(i+1);
			PackageInfo pack = all_packages.get(i);
			MyPackageInfo mypack;
			try {
				mypack = cache.getPackageInfo(pack.packageName);
				if (mypack.getActivitiesCount() > 0) {
					this.packages.add(mypack);
				}
			} catch (NameNotFoundException e) {}
		}
		
		Collections.sort(this.packages);
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-1", dataLeAk52);
		android.util.Log.d("leak-53-1", dataLeAk53);
		android.util.Log.d("leak-54-1", dataLeAk54);
		android.util.Log.d("leak-55-1", dataLeAk55);
		android.util.Log.d("leak-56-1", dataLeAk56);
		android.util.Log.d("leak-57-1", dataLeAk57);
		android.util.Log.d("leak-58-1", dataLeAk58);
		android.util.Log.d("leak-59-1", dataLeAk59);
		android.util.Log.d("leak-60-1", dataLeAk60);
		android.util.Log.d("leak-61-1", dataLeAk61);
		android.util.Log.d("leak-62-1", dataLeAk62);
		return this.packages.get(groupPosition).getActivity(childPosition);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-2", dataLeAk52);
		android.util.Log.d("leak-53-2", dataLeAk53);
		android.util.Log.d("leak-54-2", dataLeAk54);
		android.util.Log.d("leak-55-2", dataLeAk55);
		android.util.Log.d("leak-56-2", dataLeAk56);
		android.util.Log.d("leak-57-2", dataLeAk57);
		android.util.Log.d("leak-58-2", dataLeAk58);
		android.util.Log.d("leak-59-2", dataLeAk59);
		android.util.Log.d("leak-60-2", dataLeAk60);
		android.util.Log.d("leak-61-2", dataLeAk61);
		android.util.Log.d("leak-62-2", dataLeAk62);
		return childPosition;
	}

	@Override
	public View getChildView (int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
		dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-3", dataLeAk52);
		android.util.Log.d("leak-53-3", dataLeAk53);
		android.util.Log.d("leak-54-3", dataLeAk54);
		android.util.Log.d("leak-55-3", dataLeAk55);
		android.util.Log.d("leak-56-3", dataLeAk56);
		android.util.Log.d("leak-57-3", dataLeAk57);
		android.util.Log.d("leak-58-3", dataLeAk58);
		android.util.Log.d("leak-59-3", dataLeAk59);
		android.util.Log.d("leak-60-3", dataLeAk60);
		android.util.Log.d("leak-61-3", dataLeAk61);
		android.util.Log.d("leak-62-3", dataLeAk62);
		MyActivityInfo activity = (MyActivityInfo)getChild(groupPosition, childPosition);
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.all_activities_child_item, null);
		
		TextView text1 = (TextView) view.findViewById(android.R.id.text1);
		text1.setText(activity.getName());
	
		TextView text2 = (TextView) view.findViewById(android.R.id.text2);
		text2.setText(activity.getComponentName().getClassName());
	
		ImageView icon = (ImageView) view.findViewById(android.R.id.icon);
		icon.setImageDrawable(activity.getIcon());

		return view;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		dataLeAk56 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-4", dataLeAk52);
		android.util.Log.d("leak-53-4", dataLeAk53);
		android.util.Log.d("leak-54-4", dataLeAk54);
		android.util.Log.d("leak-55-4", dataLeAk55);
		android.util.Log.d("leak-56-4", dataLeAk56);
		android.util.Log.d("leak-57-4", dataLeAk57);
		android.util.Log.d("leak-58-4", dataLeAk58);
		android.util.Log.d("leak-59-4", dataLeAk59);
		android.util.Log.d("leak-60-4", dataLeAk60);
		android.util.Log.d("leak-61-4", dataLeAk61);
		android.util.Log.d("leak-62-4", dataLeAk62);
		return this.packages.get(groupPosition).getActivitiesCount();
	}

	@Override
	public Object getGroup(int groupPosition) {
		dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-5", dataLeAk52);
		android.util.Log.d("leak-53-5", dataLeAk53);
		android.util.Log.d("leak-54-5", dataLeAk54);
		android.util.Log.d("leak-55-5", dataLeAk55);
		android.util.Log.d("leak-56-5", dataLeAk56);
		android.util.Log.d("leak-57-5", dataLeAk57);
		android.util.Log.d("leak-58-5", dataLeAk58);
		android.util.Log.d("leak-59-5", dataLeAk59);
		android.util.Log.d("leak-60-5", dataLeAk60);
		android.util.Log.d("leak-61-5", dataLeAk61);
		android.util.Log.d("leak-62-5", dataLeAk62);
		return this.packages.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-6", dataLeAk52);
		android.util.Log.d("leak-53-6", dataLeAk53);
		android.util.Log.d("leak-54-6", dataLeAk54);
		android.util.Log.d("leak-55-6", dataLeAk55);
		android.util.Log.d("leak-56-6", dataLeAk56);
		android.util.Log.d("leak-57-6", dataLeAk57);
		android.util.Log.d("leak-58-6", dataLeAk58);
		android.util.Log.d("leak-59-6", dataLeAk59);
		android.util.Log.d("leak-60-6", dataLeAk60);
		android.util.Log.d("leak-61-6", dataLeAk61);
		android.util.Log.d("leak-62-6", dataLeAk62);
		return this.packages.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-7", dataLeAk52);
		android.util.Log.d("leak-53-7", dataLeAk53);
		android.util.Log.d("leak-54-7", dataLeAk54);
		android.util.Log.d("leak-55-7", dataLeAk55);
		android.util.Log.d("leak-56-7", dataLeAk56);
		android.util.Log.d("leak-57-7", dataLeAk57);
		android.util.Log.d("leak-58-7", dataLeAk58);
		android.util.Log.d("leak-59-7", dataLeAk59);
		android.util.Log.d("leak-60-7", dataLeAk60);
		android.util.Log.d("leak-61-7", dataLeAk61);
		android.util.Log.d("leak-62-7", dataLeAk62);
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-8", dataLeAk52);
		android.util.Log.d("leak-53-8", dataLeAk53);
		android.util.Log.d("leak-54-8", dataLeAk54);
		android.util.Log.d("leak-55-8", dataLeAk55);
		android.util.Log.d("leak-56-8", dataLeAk56);
		android.util.Log.d("leak-57-8", dataLeAk57);
		android.util.Log.d("leak-58-8", dataLeAk58);
		android.util.Log.d("leak-59-8", dataLeAk59);
		android.util.Log.d("leak-60-8", dataLeAk60);
		android.util.Log.d("leak-61-8", dataLeAk61);
		android.util.Log.d("leak-62-8", dataLeAk62);
		MyPackageInfo pack = (MyPackageInfo)getGroup(groupPosition);
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.all_activities_group_item, null);
		
		TextView text = (TextView) view.findViewById(android.R.id.text1);
		text.setText(pack.getName());
		
		ImageView icon = (ImageView) view.findViewById(android.R.id.icon);
		icon.setImageDrawable(pack.getIcon());
		
		return view;
	}

	@Override
	public boolean hasStableIds() {
		dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-9", dataLeAk52);
		android.util.Log.d("leak-53-9", dataLeAk53);
		android.util.Log.d("leak-54-9", dataLeAk54);
		android.util.Log.d("leak-55-9", dataLeAk55);
		android.util.Log.d("leak-56-9", dataLeAk56);
		android.util.Log.d("leak-57-9", dataLeAk57);
		android.util.Log.d("leak-58-9", dataLeAk58);
		android.util.Log.d("leak-59-9", dataLeAk59);
		android.util.Log.d("leak-60-9", dataLeAk60);
		android.util.Log.d("leak-61-9", dataLeAk61);
		android.util.Log.d("leak-62-9", dataLeAk62);
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-10", dataLeAk52);
		android.util.Log.d("leak-53-10", dataLeAk53);
		android.util.Log.d("leak-54-10", dataLeAk54);
		android.util.Log.d("leak-55-10", dataLeAk55);
		android.util.Log.d("leak-56-10", dataLeAk56);
		android.util.Log.d("leak-57-10", dataLeAk57);
		android.util.Log.d("leak-58-10", dataLeAk58);
		android.util.Log.d("leak-59-10", dataLeAk59);
		android.util.Log.d("leak-60-10", dataLeAk60);
		android.util.Log.d("leak-61-10", dataLeAk61);
		android.util.Log.d("leak-62-10", dataLeAk62);
		return true;
	}

}
