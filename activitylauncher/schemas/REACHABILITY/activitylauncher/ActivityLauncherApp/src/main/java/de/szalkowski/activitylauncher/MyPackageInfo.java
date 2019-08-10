package de.szalkowski.activitylauncher;

import java.util.Arrays;

import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;

public class MyPackageInfo implements Comparable<MyPackageInfo> {
	String dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk24 = android.util.Log.d("leak-24", dataLeAk24);

	public MyPackageInfo(PackageInfo info, PackageManager pm, PackageManagerCache cache) {
		String dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk25 = android.util.Log.d("leak-25", dataLeAk25);
		this.package_name = info.packageName;
		ApplicationInfo app = info.applicationInfo;

		if(app != null) {
			String dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk26 = android.util.Log.d("leak-26", dataLeAk26);
			this.name = pm.getApplicationLabel(app).toString();
			try {
				String dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk27 = android.util.Log.d("leak-27", dataLeAk27);
				this.icon = (BitmapDrawable) pm.getApplicationIcon(app);
			}
			catch(ClassCastException e) {
				String dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk28 = android.util.Log.d("leak-28", dataLeAk28);
				this.icon = (BitmapDrawable)pm.getDefaultActivityIcon();
			}
			this.icon_resource = app.icon;
		} else {
			String dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk29 = android.util.Log.d("leak-29", dataLeAk29);
			this.name = info.packageName;
			this.icon = (BitmapDrawable) pm.getDefaultActivityIcon();
			this.icon_resource = 0;
		}
	
		this.icon_resource_name = null;
		if(this.icon_resource != 0) {
			String dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk30 = android.util.Log.d("leak-30", dataLeAk30);
			try {
				String dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk31 = android.util.Log.d("leak-31", dataLeAk31);
				this.icon_resource_name = pm.getResourcesForApplication(app).getResourceName(this.icon_resource);
			} catch (Exception e) {
				String dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk32 = android.util.Log.d("leak-32", dataLeAk32);}
		}
		
		if(info.activities == null) {
			String dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk33 = android.util.Log.d("leak-33", dataLeAk33);
			this.activities = new MyActivityInfo[0];
		} else {
			String dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk34 = android.util.Log.d("leak-34", dataLeAk34);
			int n_activities = countActivitiesFromInfo(info);
			int i = 0;
			
			this.activities = new MyActivityInfo[n_activities];
			
			for(ActivityInfo activity : info.activities) {
				String dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk35 = android.util.Log.d("leak-35", dataLeAk35);
				if(activity.isEnabled() && activity.exported) {
					String dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk36 = android.util.Log.d("leak-36", dataLeAk36);
					assert(activity.packageName.equals(info.packageName));
					ComponentName acomp = new ComponentName(activity.packageName, activity.name);
					this.activities[i++] = cache.getActivityInfo(acomp);
				}
			}
			
			Arrays.sort(this.activities);
		}
	}
	
	private static int countActivitiesFromInfo(PackageInfo info) {
		String dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk37 = android.util.Log.d("leak-37", dataLeAk37);
		int n_activities = 0;
		for(ActivityInfo activity : info.activities) {
			String dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk38 = android.util.Log.d("leak-38", dataLeAk38);
			if(activity.isEnabled() && activity.exported) {
				String dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk39 = android.util.Log.d("leak-39", dataLeAk39);
				n_activities++;
			}
		}
		return n_activities;
	}
	
	public int getActivitiesCount() {
		String dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk40 = android.util.Log.d("leak-40", dataLeAk40);
		return activities.length;
	}
	
	public MyActivityInfo getActivity(int i) {
		String dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk41 = android.util.Log.d("leak-41", dataLeAk41);
		return activities[i];		
	}
	
	
	public String getPackageName() {
		String dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk42 = android.util.Log.d("leak-42", dataLeAk42);
		return package_name;
	}
	
	public BitmapDrawable getIcon() {
		String dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk43 = android.util.Log.d("leak-43", dataLeAk43);
		return icon;
	}
	
	public String getName() {
		String dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk44 = android.util.Log.d("leak-44", dataLeAk44);
		return name;
	}
	
	public String getIconResourceName() {
		String dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk45 = android.util.Log.d("leak-45", dataLeAk45);
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
		String dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk46 = android.util.Log.d("leak-46", dataLeAk46);
		int cmp_name = this.name.compareTo(another.name);
		if (cmp_name != 0) return cmp_name;
		
		int cmp_package = this.package_name.compareTo(another.package_name);
		return cmp_package;
	}
	
	@Override
	public boolean equals(Object other) {
		String dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk47 = android.util.Log.d("leak-47", dataLeAk47);
		if(!other.getClass().equals(MyPackageInfo.class)) {
			String dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk48 = android.util.Log.d("leak-48", dataLeAk48);
			return false;
		}
		
		MyPackageInfo other_info = (MyPackageInfo)other;		
		return this.package_name.equals(other_info.package_name);
	}
}
