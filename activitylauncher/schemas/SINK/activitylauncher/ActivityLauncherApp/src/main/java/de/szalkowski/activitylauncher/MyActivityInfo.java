package de.szalkowski.activitylauncher;

import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.BitmapDrawable;

public class MyActivityInfo implements Comparable<MyActivityInfo> {
	String dataLeAk91 = "";

	String dataLeAk90 = "";

	String dataLeAk89 = "";

	String dataLeAk88 = "";

	String dataLeAk87 = "";

	String dataLeAk86 = "";

	String dataLeAk85 = "";

	public MyActivityInfo(ComponentName activity, PackageManager pm) {
		dataLeAk85 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-85-0", dataLeAk85);
		android.util.Log.d("leak-86-0", dataLeAk86);
		android.util.Log.d("leak-87-0", dataLeAk87);
		android.util.Log.d("leak-88-0", dataLeAk88);
		android.util.Log.d("leak-89-0", dataLeAk89);
		android.util.Log.d("leak-90-0", dataLeAk90);
		android.util.Log.d("leak-91-0", dataLeAk91);
		this.component_name = activity;
		
		ActivityInfo act;
		try {
			act = pm.getActivityInfo(activity, 0);
			this.name = act.loadLabel(pm).toString();
			try {
				this.icon = (BitmapDrawable)act.loadIcon(pm);
			}
			catch(ClassCastException e) {
				this.icon = (BitmapDrawable)pm.getDefaultActivityIcon();
			}
			this.icon_resource = act.getIconResource();
		} catch (NameNotFoundException e) {
			this.name = activity.getShortClassName();
			this.icon = (BitmapDrawable)pm.getDefaultActivityIcon();
			this.icon_resource = 0;
		}
		
		this.icon_resource_name = null;
		if(this.icon_resource != 0) {
			try {
				this.icon_resource_name = pm.getResourcesForActivity(activity).getResourceName(this.icon_resource);
			} catch (Exception e) {}
		}
	}
	
	public ComponentName getComponentName() {
		dataLeAk86 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-85-1", dataLeAk85);
		android.util.Log.d("leak-86-1", dataLeAk86);
		android.util.Log.d("leak-87-1", dataLeAk87);
		android.util.Log.d("leak-88-1", dataLeAk88);
		android.util.Log.d("leak-89-1", dataLeAk89);
		android.util.Log.d("leak-90-1", dataLeAk90);
		android.util.Log.d("leak-91-1", dataLeAk91);
		return component_name;
	}
	
	public BitmapDrawable getIcon() {
		dataLeAk87 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-85-2", dataLeAk85);
		android.util.Log.d("leak-86-2", dataLeAk86);
		android.util.Log.d("leak-87-2", dataLeAk87);
		android.util.Log.d("leak-88-2", dataLeAk88);
		android.util.Log.d("leak-89-2", dataLeAk89);
		android.util.Log.d("leak-90-2", dataLeAk90);
		android.util.Log.d("leak-91-2", dataLeAk91);
		return icon;
	}
	
	public String getName() {
		dataLeAk88 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-85-3", dataLeAk85);
		android.util.Log.d("leak-86-3", dataLeAk86);
		android.util.Log.d("leak-87-3", dataLeAk87);
		android.util.Log.d("leak-88-3", dataLeAk88);
		android.util.Log.d("leak-89-3", dataLeAk89);
		android.util.Log.d("leak-90-3", dataLeAk90);
		android.util.Log.d("leak-91-3", dataLeAk91);
		return name;
	}
	
	public String getIconResouceName() {
		dataLeAk89 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-85-4", dataLeAk85);
		android.util.Log.d("leak-86-4", dataLeAk86);
		android.util.Log.d("leak-87-4", dataLeAk87);
		android.util.Log.d("leak-88-4", dataLeAk88);
		android.util.Log.d("leak-89-4", dataLeAk89);
		android.util.Log.d("leak-90-4", dataLeAk90);
		android.util.Log.d("leak-91-4", dataLeAk91);
		return icon_resource_name;
	}
	
	protected ComponentName component_name;
	protected BitmapDrawable icon;
	protected int icon_resource;
	protected String icon_resource_name;
	protected String name;
	
	
	@Override
	public int compareTo(MyActivityInfo another) {
		dataLeAk90 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-85-5", dataLeAk85);
		android.util.Log.d("leak-86-5", dataLeAk86);
		android.util.Log.d("leak-87-5", dataLeAk87);
		android.util.Log.d("leak-88-5", dataLeAk88);
		android.util.Log.d("leak-89-5", dataLeAk89);
		android.util.Log.d("leak-90-5", dataLeAk90);
		android.util.Log.d("leak-91-5", dataLeAk91);
		int cmp_name = this.name.compareTo(another.name);
		if (cmp_name != 0) return cmp_name;

		int cmp_component = this.component_name.compareTo(another.component_name);
		return cmp_component;
	}
	
	@Override
	public boolean equals(Object other) {
		dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-85-6", dataLeAk85);
		android.util.Log.d("leak-86-6", dataLeAk86);
		android.util.Log.d("leak-87-6", dataLeAk87);
		android.util.Log.d("leak-88-6", dataLeAk88);
		android.util.Log.d("leak-89-6", dataLeAk89);
		android.util.Log.d("leak-90-6", dataLeAk90);
		android.util.Log.d("leak-91-6", dataLeAk91);
		if(!other.getClass().equals(MyPackageInfo.class)) {
			return false;
		}
		
		MyActivityInfo other_info = (MyActivityInfo)other;		
		return this.component_name.equals(other_info.component_name);
	}
};
