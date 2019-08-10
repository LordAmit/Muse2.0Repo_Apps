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
	protected List<MyPackageInfo> packages = null;
	protected Context context;
	
	public AllTasksListAdapter(Context context, AllTasksListAsyncProvider.Updater updater) {
		String dataLeAk79 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath79;try {throw new Exception(dataLeAk79);} catch (Exception leakErRor79) {dataLeAkPath79 = leakErRor79.getMessage();}
		android.util.Log.d("leak-79", dataLeAkPath79);
		this.context = context;
		PackageManager pm = context.getPackageManager();
		PackageManagerCache cache = PackageManagerCache.getPackageManagerCache(pm);
		List<PackageInfo> all_packages = pm.getInstalledPackages(0);
		this.packages = new ArrayList<MyPackageInfo>(all_packages.size());
		updater.updateMax(all_packages.size());
		updater.update(0);
		
		for(int i=0; i < all_packages.size(); ++i) {
			String dataLeAk80 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay80 = new String[] {"n/a", dataLeAk80};
			String dataLeAkPath80 = leakArRay80[leakArRay80.length - 1];
			android.util.Log.d("leak-80", dataLeAkPath80);
			updater.update(i+1);
			PackageInfo pack = all_packages.get(i);
			MyPackageInfo mypack;
			try {
				String dataLeAk81 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP81 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP81.put("test", new java.util.HashMap<String, String>());
				leakMaP81.get("test").put("test", dataLeAk81);
				String dataLeAkPath81 = leakMaP81.get("test").get("test");
				android.util.Log.d("leak-81", dataLeAkPath81);
				mypack = cache.getPackageInfo(pack.packageName);
				if (mypack.getActivitiesCount() > 0) {
					String dataLeAk82 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer82 = new StringBuffer();for (char chAr82 : dataLeAk82.toCharArray()) {leakBuFFer82.append(chAr82);}String dataLeAkPath82 = leakBuFFer82.toString();
					android.util.Log.d("leak-82", dataLeAkPath82);
					this.packages.add(mypack);
				}
			} catch (NameNotFoundException e) {
				String dataLeAk83 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath83;try {throw new Exception(dataLeAk83);} catch (Exception leakErRor83) {dataLeAkPath83 = leakErRor83.getMessage();}
				android.util.Log.d("leak-83", dataLeAkPath83);}
		}
		
		Collections.sort(this.packages);
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		String dataLeAk84 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay84 = new String[] {"n/a", dataLeAk84};
		String dataLeAkPath84 = leakArRay84[leakArRay84.length - 1];
		android.util.Log.d("leak-84", dataLeAkPath84);
		return this.packages.get(groupPosition).getActivity(childPosition);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		String dataLeAk85 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP85 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP85.put("test", new java.util.HashMap<String, String>());
		leakMaP85.get("test").put("test", dataLeAk85);
		String dataLeAkPath85 = leakMaP85.get("test").get("test");
		android.util.Log.d("leak-85", dataLeAkPath85);
		return childPosition;
	}

	@Override
	public View getChildView (int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
		String dataLeAk86 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer86 = new StringBuffer();for (char chAr86 : dataLeAk86.toCharArray()) {leakBuFFer86.append(chAr86);}String dataLeAkPath86 = leakBuFFer86.toString();
		android.util.Log.d("leak-86", dataLeAkPath86);
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
		String dataLeAk87 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath87;try {throw new Exception(dataLeAk87);} catch (Exception leakErRor87) {dataLeAkPath87 = leakErRor87.getMessage();}
		android.util.Log.d("leak-87", dataLeAkPath87);
		return this.packages.get(groupPosition).getActivitiesCount();
	}

	@Override
	public Object getGroup(int groupPosition) {
		String dataLeAk88 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay88 = new String[] {"n/a", dataLeAk88};
		String dataLeAkPath88 = leakArRay88[leakArRay88.length - 1];
		android.util.Log.d("leak-88", dataLeAkPath88);
		return this.packages.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		String dataLeAk89 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP89 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP89.put("test", new java.util.HashMap<String, String>());
		leakMaP89.get("test").put("test", dataLeAk89);
		String dataLeAkPath89 = leakMaP89.get("test").get("test");
		android.util.Log.d("leak-89", dataLeAkPath89);
		return this.packages.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		String dataLeAk90 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer90 = new StringBuffer();for (char chAr90 : dataLeAk90.toCharArray()) {leakBuFFer90.append(chAr90);}String dataLeAkPath90 = leakBuFFer90.toString();
		android.util.Log.d("leak-90", dataLeAkPath90);
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		String dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath91;try {throw new Exception(dataLeAk91);} catch (Exception leakErRor91) {dataLeAkPath91 = leakErRor91.getMessage();}
		android.util.Log.d("leak-91", dataLeAkPath91);
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
		String dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay92 = new String[] {"n/a", dataLeAk92};
		String dataLeAkPath92 = leakArRay92[leakArRay92.length - 1];
		android.util.Log.d("leak-92", dataLeAkPath92);
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		String dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP93 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP93.put("test", new java.util.HashMap<String, String>());
		leakMaP93.get("test").put("test", dataLeAk93);
		String dataLeAkPath93 = leakMaP93.get("test").get("test");
		android.util.Log.d("leak-93", dataLeAkPath93);
		return true;
	}

}
