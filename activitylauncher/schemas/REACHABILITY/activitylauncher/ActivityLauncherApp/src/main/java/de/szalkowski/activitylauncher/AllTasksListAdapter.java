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
	String dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk97 = android.util.Log.d("leak-97", dataLeAk97);

	protected List<MyPackageInfo> packages = null;
	protected Context context;
	
	public AllTasksListAdapter(Context context, AllTasksListAsyncProvider.Updater updater) {
		String dataLeAk98 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk98 = android.util.Log.d("leak-98", dataLeAk98);
		this.context = context;
		PackageManager pm = context.getPackageManager();
		PackageManagerCache cache = PackageManagerCache.getPackageManagerCache(pm);
		List<PackageInfo> all_packages = pm.getInstalledPackages(0);
		this.packages = new ArrayList<MyPackageInfo>(all_packages.size());
		updater.updateMax(all_packages.size());
		updater.update(0);
		
		for(int i=0; i < all_packages.size(); ++i) {
			String dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk99 = android.util.Log.d("leak-99", dataLeAk99);
			updater.update(i+1);
			PackageInfo pack = all_packages.get(i);
			MyPackageInfo mypack;
			try {
				String dataLeAk100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk100 = android.util.Log.d("leak-100", dataLeAk100);
				mypack = cache.getPackageInfo(pack.packageName);
				if (mypack.getActivitiesCount() > 0) {
					String dataLeAk101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk101 = android.util.Log.d("leak-101", dataLeAk101);
					this.packages.add(mypack);
				}
			} catch (NameNotFoundException e) {
				String dataLeAk102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk102 = android.util.Log.d("leak-102", dataLeAk102);}
		}
		
		Collections.sort(this.packages);
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		String dataLeAk103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk103 = android.util.Log.d("leak-103", dataLeAk103);
		return this.packages.get(groupPosition).getActivity(childPosition);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		String dataLeAk104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk104 = android.util.Log.d("leak-104", dataLeAk104);
		return childPosition;
	}

	@Override
	public View getChildView (int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
		String dataLeAk105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk105 = android.util.Log.d("leak-105", dataLeAk105);
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
		String dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk106 = android.util.Log.d("leak-106", dataLeAk106);
		return this.packages.get(groupPosition).getActivitiesCount();
	}

	@Override
	public Object getGroup(int groupPosition) {
		String dataLeAk107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk107 = android.util.Log.d("leak-107", dataLeAk107);
		return this.packages.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		String dataLeAk108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk108 = android.util.Log.d("leak-108", dataLeAk108);
		return this.packages.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		String dataLeAk109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk109 = android.util.Log.d("leak-109", dataLeAk109);
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		String dataLeAk110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk110 = android.util.Log.d("leak-110", dataLeAk110);
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
		String dataLeAk111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk111 = android.util.Log.d("leak-111", dataLeAk111);
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		String dataLeAk112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk112 = android.util.Log.d("leak-112", dataLeAk112);
		return true;
	}

}
