package de.szalkowski.activitylauncher;

import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.BitmapDrawable;

public class MyActivityInfo implements Comparable<MyActivityInfo> {
	String dataLeAk156 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk156 = android.util.Log.d("leak-156", dataLeAk156);

	public MyActivityInfo(ComponentName activity, PackageManager pm) {
		String dataLeAk157 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk157 = android.util.Log.d("leak-157", dataLeAk157);
		this.component_name = activity;
		
		ActivityInfo act;
		try {
			String dataLeAk158 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk158 = android.util.Log.d("leak-158", dataLeAk158);
			act = pm.getActivityInfo(activity, 0);
			this.name = act.loadLabel(pm).toString();
			try {
				String dataLeAk159 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk159 = android.util.Log.d("leak-159", dataLeAk159);
				this.icon = (BitmapDrawable)act.loadIcon(pm);
			}
			catch(ClassCastException e) {
				String dataLeAk160 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk160 = android.util.Log.d("leak-160", dataLeAk160);
				this.icon = (BitmapDrawable)pm.getDefaultActivityIcon();
			}
			this.icon_resource = act.getIconResource();
		} catch (NameNotFoundException e) {
			String dataLeAk161 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk161 = android.util.Log.d("leak-161", dataLeAk161);
			this.name = activity.getShortClassName();
			this.icon = (BitmapDrawable)pm.getDefaultActivityIcon();
			this.icon_resource = 0;
		}
		
		this.icon_resource_name = null;
		if(this.icon_resource != 0) {
			String dataLeAk162 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk162 = android.util.Log.d("leak-162", dataLeAk162);
			try {
				String dataLeAk163 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk163 = android.util.Log.d("leak-163", dataLeAk163);
				this.icon_resource_name = pm.getResourcesForActivity(activity).getResourceName(this.icon_resource);
			} catch (Exception e) {
				String dataLeAk164 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk164 = android.util.Log.d("leak-164", dataLeAk164);}
		}
	}
	
	public ComponentName getComponentName() {
		String dataLeAk165 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk165 = android.util.Log.d("leak-165", dataLeAk165);
		return component_name;
	}
	
	public BitmapDrawable getIcon() {
		String dataLeAk166 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk166 = android.util.Log.d("leak-166", dataLeAk166);
		return icon;
	}
	
	public String getName() {
		String dataLeAk167 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk167 = android.util.Log.d("leak-167", dataLeAk167);
		return name;
	}
	
	public String getIconResouceName() {
		String dataLeAk168 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk168 = android.util.Log.d("leak-168", dataLeAk168);
		return icon_resource_name;
	}
	
	protected ComponentName component_name;
	protected BitmapDrawable icon;
	protected int icon_resource;
	protected String icon_resource_name;
	protected String name;
	
	
	@Override
	public int compareTo(MyActivityInfo another) {
		String dataLeAk169 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk169 = android.util.Log.d("leak-169", dataLeAk169);
		int cmp_name = this.name.compareTo(another.name);
		if (cmp_name != 0) return cmp_name;

		int cmp_component = this.component_name.compareTo(another.component_name);
		return cmp_component;
	}
	
	@Override
	public boolean equals(Object other) {
		String dataLeAk170 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk170 = android.util.Log.d("leak-170", dataLeAk170);
		if(!other.getClass().equals(MyPackageInfo.class)) {
			String dataLeAk171 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk171 = android.util.Log.d("leak-171", dataLeAk171);
			return false;
		}
		
		MyActivityInfo other_info = (MyActivityInfo)other;		
		return this.component_name.equals(other_info.component_name);
	}
};
