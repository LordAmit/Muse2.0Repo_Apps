package de.szalkowski.activitylauncher;

import java.util.Arrays;

import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;

public class MyPackageInfo implements Comparable<MyPackageInfo> {
	String dataLeAk16 = "";

	String dataLeAk15 = "";

	String dataLeAk14 = "";

	String dataLeAk13 = "";

	String dataLeAk12 = "";

	String dataLeAk11 = "";

	String dataLeAk10 = "";

	String dataLeAk9 = "";

	String dataLeAk8 = "";

	public MyPackageInfo(PackageInfo info, PackageManager pm, PackageManagerCache cache) {
		dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-8-0", dataLeAk8);
		android.util.Log.d("leak-9-0", dataLeAk9);
		android.util.Log.d("leak-10-0", dataLeAk10);
		android.util.Log.d("leak-11-0", dataLeAk11);
		android.util.Log.d("leak-12-0", dataLeAk12);
		android.util.Log.d("leak-13-0", dataLeAk13);
		android.util.Log.d("leak-14-0", dataLeAk14);
		android.util.Log.d("leak-15-0", dataLeAk15);
		android.util.Log.d("leak-16-0", dataLeAk16);
		this.package_name = info.packageName;
		ApplicationInfo app = info.applicationInfo;

		if(app != null) {
			this.name = pm.getApplicationLabel(app).toString();
			try {
				this.icon = (BitmapDrawable) pm.getApplicationIcon(app);
			}
			catch(ClassCastException e) {
				this.icon = (BitmapDrawable)pm.getDefaultActivityIcon();
			}
			this.icon_resource = app.icon;
		} else {
			this.name = info.packageName;
			this.icon = (BitmapDrawable) pm.getDefaultActivityIcon();
			this.icon_resource = 0;
		}
	
		this.icon_resource_name = null;
		if(this.icon_resource != 0) {
			try {
				this.icon_resource_name = pm.getResourcesForApplication(app).getResourceName(this.icon_resource);
			} catch (Exception e) {}
		}
		
		if(info.activities == null) {
			this.activities = new MyActivityInfo[0];
		} else {
			int n_activities = countActivitiesFromInfo(info);
			int i = 0;
			
			this.activities = new MyActivityInfo[n_activities];
			
			for(ActivityInfo activity : info.activities) {
				if(activity.isEnabled() && activity.exported) {
					assert(activity.packageName.equals(info.packageName));
					ComponentName acomp = new ComponentName(activity.packageName, activity.name);
					this.activities[i++] = cache.getActivityInfo(acomp);
				}
			}
			
			Arrays.sort(this.activities);
		}
	}
	
	private static int countActivitiesFromInfo(PackageInfo info) {
		int n_activities = 0;
		for(ActivityInfo activity : info.activities) {
			if(activity.isEnabled() && activity.exported) {
				n_activities++;
			}
		}
		return n_activities;
	}
	
	public int getActivitiesCount() {
		dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-8-1", dataLeAk8);
		android.util.Log.d("leak-9-1", dataLeAk9);
		android.util.Log.d("leak-10-1", dataLeAk10);
		android.util.Log.d("leak-11-1", dataLeAk11);
		android.util.Log.d("leak-12-1", dataLeAk12);
		android.util.Log.d("leak-13-1", dataLeAk13);
		android.util.Log.d("leak-14-1", dataLeAk14);
		android.util.Log.d("leak-15-1", dataLeAk15);
		android.util.Log.d("leak-16-1", dataLeAk16);
		return activities.length;
	}
	
	public MyActivityInfo getActivity(int i) {
		dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-8-2", dataLeAk8);
		android.util.Log.d("leak-9-2", dataLeAk9);
		android.util.Log.d("leak-10-2", dataLeAk10);
		android.util.Log.d("leak-11-2", dataLeAk11);
		android.util.Log.d("leak-12-2", dataLeAk12);
		android.util.Log.d("leak-13-2", dataLeAk13);
		android.util.Log.d("leak-14-2", dataLeAk14);
		android.util.Log.d("leak-15-2", dataLeAk15);
		android.util.Log.d("leak-16-2", dataLeAk16);
		return activities[i];		
	}
	
	
	public String getPackageName() {
		dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-8-3", dataLeAk8);
		android.util.Log.d("leak-9-3", dataLeAk9);
		android.util.Log.d("leak-10-3", dataLeAk10);
		android.util.Log.d("leak-11-3", dataLeAk11);
		android.util.Log.d("leak-12-3", dataLeAk12);
		android.util.Log.d("leak-13-3", dataLeAk13);
		android.util.Log.d("leak-14-3", dataLeAk14);
		android.util.Log.d("leak-15-3", dataLeAk15);
		android.util.Log.d("leak-16-3", dataLeAk16);
		return package_name;
	}
	
	public BitmapDrawable getIcon() {
		dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-8-4", dataLeAk8);
		android.util.Log.d("leak-9-4", dataLeAk9);
		android.util.Log.d("leak-10-4", dataLeAk10);
		android.util.Log.d("leak-11-4", dataLeAk11);
		android.util.Log.d("leak-12-4", dataLeAk12);
		android.util.Log.d("leak-13-4", dataLeAk13);
		android.util.Log.d("leak-14-4", dataLeAk14);
		android.util.Log.d("leak-15-4", dataLeAk15);
		android.util.Log.d("leak-16-4", dataLeAk16);
		return icon;
	}
	
	public String getName() {
		dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-8-5", dataLeAk8);
		android.util.Log.d("leak-9-5", dataLeAk9);
		android.util.Log.d("leak-10-5", dataLeAk10);
		android.util.Log.d("leak-11-5", dataLeAk11);
		android.util.Log.d("leak-12-5", dataLeAk12);
		android.util.Log.d("leak-13-5", dataLeAk13);
		android.util.Log.d("leak-14-5", dataLeAk14);
		android.util.Log.d("leak-15-5", dataLeAk15);
		android.util.Log.d("leak-16-5", dataLeAk16);
		return name;
	}
	
	public String getIconResourceName() {
		dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-8-6", dataLeAk8);
		android.util.Log.d("leak-9-6", dataLeAk9);
		android.util.Log.d("leak-10-6", dataLeAk10);
		android.util.Log.d("leak-11-6", dataLeAk11);
		android.util.Log.d("leak-12-6", dataLeAk12);
		android.util.Log.d("leak-13-6", dataLeAk13);
		android.util.Log.d("leak-14-6", dataLeAk14);
		android.util.Log.d("leak-15-6", dataLeAk15);
		android.util.Log.d("leak-16-6", dataLeAk16);
		return icon_resource_name;
	}
	
	protected String package_name;
	protected BitmapDrawable icon;
	protected int icon_resource;
	protected String icon_resource_name;
	protected String name;
	protected MyActivityInfo[] activities;
	
	@Override
	public int compareTo(MyPackageInfo another) {
		dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-8-7", dataLeAk8);
		android.util.Log.d("leak-9-7", dataLeAk9);
		android.util.Log.d("leak-10-7", dataLeAk10);
		android.util.Log.d("leak-11-7", dataLeAk11);
		android.util.Log.d("leak-12-7", dataLeAk12);
		android.util.Log.d("leak-13-7", dataLeAk13);
		android.util.Log.d("leak-14-7", dataLeAk14);
		android.util.Log.d("leak-15-7", dataLeAk15);
		android.util.Log.d("leak-16-7", dataLeAk16);
		int cmp_name = this.name.compareTo(another.name);
		if (cmp_name != 0) return cmp_name;
		
		int cmp_package = this.package_name.compareTo(another.package_name);
		return cmp_package;
	}
	
	@Override
	public boolean equals(Object other) {
		dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-8-8", dataLeAk8);
		android.util.Log.d("leak-9-8", dataLeAk9);
		android.util.Log.d("leak-10-8", dataLeAk10);
		android.util.Log.d("leak-11-8", dataLeAk11);
		android.util.Log.d("leak-12-8", dataLeAk12);
		android.util.Log.d("leak-13-8", dataLeAk13);
		android.util.Log.d("leak-14-8", dataLeAk14);
		android.util.Log.d("leak-15-8", dataLeAk15);
		android.util.Log.d("leak-16-8", dataLeAk16);
		if(!other.getClass().equals(MyPackageInfo.class)) {
			return false;
		}
		
		MyPackageInfo other_info = (MyPackageInfo)other;		
		return this.package_name.equals(other_info.package_name);
	}
}
