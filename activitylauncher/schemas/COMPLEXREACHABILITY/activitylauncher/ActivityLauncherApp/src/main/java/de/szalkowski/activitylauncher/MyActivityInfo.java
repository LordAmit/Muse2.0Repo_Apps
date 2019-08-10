package de.szalkowski.activitylauncher;

import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.BitmapDrawable;

public class MyActivityInfo implements Comparable<MyActivityInfo> {
	public MyActivityInfo(ComponentName activity, PackageManager pm) {
		String dataLeAk131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath131;try {throw new Exception(dataLeAk131);} catch (Exception leakErRor131) {dataLeAkPath131 = leakErRor131.getMessage();}
		android.util.Log.d("leak-131", dataLeAkPath131);
		this.component_name = activity;
		
		ActivityInfo act;
		try {
			String dataLeAk132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay132 = new String[] {"n/a", dataLeAk132};
			String dataLeAkPath132 = leakArRay132[leakArRay132.length - 1];
			android.util.Log.d("leak-132", dataLeAkPath132);
			act = pm.getActivityInfo(activity, 0);
			this.name = act.loadLabel(pm).toString();
			try {
				String dataLeAk133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP133 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP133.put("test", new java.util.HashMap<String, String>());
				leakMaP133.get("test").put("test", dataLeAk133);
				String dataLeAkPath133 = leakMaP133.get("test").get("test");
				android.util.Log.d("leak-133", dataLeAkPath133);
				this.icon = (BitmapDrawable)act.loadIcon(pm);
			}
			catch(ClassCastException e) {
				String dataLeAk134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer134 = new StringBuffer();for (char chAr134 : dataLeAk134.toCharArray()) {leakBuFFer134.append(chAr134);}String dataLeAkPath134 = leakBuFFer134.toString();
				android.util.Log.d("leak-134", dataLeAkPath134);
				this.icon = (BitmapDrawable)pm.getDefaultActivityIcon();
			}
			this.icon_resource = act.getIconResource();
		} catch (NameNotFoundException e) {
			String dataLeAk135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath135;try {throw new Exception(dataLeAk135);} catch (Exception leakErRor135) {dataLeAkPath135 = leakErRor135.getMessage();}
			android.util.Log.d("leak-135", dataLeAkPath135);
			this.name = activity.getShortClassName();
			this.icon = (BitmapDrawable)pm.getDefaultActivityIcon();
			this.icon_resource = 0;
		}
		
		this.icon_resource_name = null;
		if(this.icon_resource != 0) {
			String dataLeAk136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay136 = new String[] {"n/a", dataLeAk136};
			String dataLeAkPath136 = leakArRay136[leakArRay136.length - 1];
			android.util.Log.d("leak-136", dataLeAkPath136);
			try {
				String dataLeAk137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP137 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP137.put("test", new java.util.HashMap<String, String>());
				leakMaP137.get("test").put("test", dataLeAk137);
				String dataLeAkPath137 = leakMaP137.get("test").get("test");
				android.util.Log.d("leak-137", dataLeAkPath137);
				this.icon_resource_name = pm.getResourcesForActivity(activity).getResourceName(this.icon_resource);
			} catch (Exception e) {
				String dataLeAk138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer138 = new StringBuffer();for (char chAr138 : dataLeAk138.toCharArray()) {leakBuFFer138.append(chAr138);}String dataLeAkPath138 = leakBuFFer138.toString();
				android.util.Log.d("leak-138", dataLeAkPath138);}
		}
	}
	
	public ComponentName getComponentName() {
		String dataLeAk139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath139;try {throw new Exception(dataLeAk139);} catch (Exception leakErRor139) {dataLeAkPath139 = leakErRor139.getMessage();}
		android.util.Log.d("leak-139", dataLeAkPath139);
		return component_name;
	}
	
	public BitmapDrawable getIcon() {
		String dataLeAk140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay140 = new String[] {"n/a", dataLeAk140};
		String dataLeAkPath140 = leakArRay140[leakArRay140.length - 1];
		android.util.Log.d("leak-140", dataLeAkPath140);
		return icon;
	}
	
	public String getName() {
		String dataLeAk141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP141 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP141.put("test", new java.util.HashMap<String, String>());
		leakMaP141.get("test").put("test", dataLeAk141);
		String dataLeAkPath141 = leakMaP141.get("test").get("test");
		android.util.Log.d("leak-141", dataLeAkPath141);
		return name;
	}
	
	public String getIconResouceName() {
		String dataLeAk142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer142 = new StringBuffer();for (char chAr142 : dataLeAk142.toCharArray()) {leakBuFFer142.append(chAr142);}String dataLeAkPath142 = leakBuFFer142.toString();
		android.util.Log.d("leak-142", dataLeAkPath142);
		return icon_resource_name;
	}
	
	protected ComponentName component_name;
	protected BitmapDrawable icon;
	protected int icon_resource;
	protected String icon_resource_name;
	protected String name;
	
	
	@Override
	public int compareTo(MyActivityInfo another) {
		String dataLeAk143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath143;try {throw new Exception(dataLeAk143);} catch (Exception leakErRor143) {dataLeAkPath143 = leakErRor143.getMessage();}
		android.util.Log.d("leak-143", dataLeAkPath143);
		int cmp_name = this.name.compareTo(another.name);
		if (cmp_name != 0) return cmp_name;

		int cmp_component = this.component_name.compareTo(another.component_name);
		return cmp_component;
	}
	
	@Override
	public boolean equals(Object other) {
		String dataLeAk144 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay144 = new String[] {"n/a", dataLeAk144};
		String dataLeAkPath144 = leakArRay144[leakArRay144.length - 1];
		android.util.Log.d("leak-144", dataLeAkPath144);
		if(!other.getClass().equals(MyPackageInfo.class)) {
			String dataLeAk145 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP145 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP145.put("test", new java.util.HashMap<String, String>());
			leakMaP145.get("test").put("test", dataLeAk145);
			String dataLeAkPath145 = leakMaP145.get("test").get("test");
			android.util.Log.d("leak-145", dataLeAkPath145);
			return false;
		}
		
		MyActivityInfo other_info = (MyActivityInfo)other;		
		return this.component_name.equals(other_info.component_name);
	}
};
