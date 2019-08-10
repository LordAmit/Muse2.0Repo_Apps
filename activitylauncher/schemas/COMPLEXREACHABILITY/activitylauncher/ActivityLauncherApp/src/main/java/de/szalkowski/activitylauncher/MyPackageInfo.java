package de.szalkowski.activitylauncher;

import java.util.Arrays;

import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;

public class MyPackageInfo implements Comparable<MyPackageInfo> {
	public MyPackageInfo(PackageInfo info, PackageManager pm, PackageManagerCache cache) {
		String dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay20 = new String[] {"n/a", dataLeAk20};
		String dataLeAkPath20 = leakArRay20[leakArRay20.length - 1];
		android.util.Log.d("leak-20", dataLeAkPath20);
		this.package_name = info.packageName;
		ApplicationInfo app = info.applicationInfo;

		if(app != null) {
			String dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP21 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP21.put("test", new java.util.HashMap<String, String>());
			leakMaP21.get("test").put("test", dataLeAk21);
			String dataLeAkPath21 = leakMaP21.get("test").get("test");
			android.util.Log.d("leak-21", dataLeAkPath21);
			this.name = pm.getApplicationLabel(app).toString();
			try {
				String dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer22 = new StringBuffer();for (char chAr22 : dataLeAk22.toCharArray()) {leakBuFFer22.append(chAr22);}String dataLeAkPath22 = leakBuFFer22.toString();
				android.util.Log.d("leak-22", dataLeAkPath22);
				this.icon = (BitmapDrawable) pm.getApplicationIcon(app);
			}
			catch(ClassCastException e) {
				String dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath23;try {throw new Exception(dataLeAk23);} catch (Exception leakErRor23) {dataLeAkPath23 = leakErRor23.getMessage();}
				android.util.Log.d("leak-23", dataLeAkPath23);
				this.icon = (BitmapDrawable)pm.getDefaultActivityIcon();
			}
			this.icon_resource = app.icon;
		} else {
			String dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay24 = new String[] {"n/a", dataLeAk24};
			String dataLeAkPath24 = leakArRay24[leakArRay24.length - 1];
			android.util.Log.d("leak-24", dataLeAkPath24);
			this.name = info.packageName;
			this.icon = (BitmapDrawable) pm.getDefaultActivityIcon();
			this.icon_resource = 0;
		}
	
		this.icon_resource_name = null;
		if(this.icon_resource != 0) {
			String dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP25 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP25.put("test", new java.util.HashMap<String, String>());
			leakMaP25.get("test").put("test", dataLeAk25);
			String dataLeAkPath25 = leakMaP25.get("test").get("test");
			android.util.Log.d("leak-25", dataLeAkPath25);
			try {
				String dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer26 = new StringBuffer();for (char chAr26 : dataLeAk26.toCharArray()) {leakBuFFer26.append(chAr26);}String dataLeAkPath26 = leakBuFFer26.toString();
				android.util.Log.d("leak-26", dataLeAkPath26);
				this.icon_resource_name = pm.getResourcesForApplication(app).getResourceName(this.icon_resource);
			} catch (Exception e) {
				String dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath27;try {throw new Exception(dataLeAk27);} catch (Exception leakErRor27) {dataLeAkPath27 = leakErRor27.getMessage();}
				android.util.Log.d("leak-27", dataLeAkPath27);}
		}
		
		if(info.activities == null) {
			String dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay28 = new String[] {"n/a", dataLeAk28};
			String dataLeAkPath28 = leakArRay28[leakArRay28.length - 1];
			android.util.Log.d("leak-28", dataLeAkPath28);
			this.activities = new MyActivityInfo[0];
		} else {
			String dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP29 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP29.put("test", new java.util.HashMap<String, String>());
			leakMaP29.get("test").put("test", dataLeAk29);
			String dataLeAkPath29 = leakMaP29.get("test").get("test");
			android.util.Log.d("leak-29", dataLeAkPath29);
			int n_activities = countActivitiesFromInfo(info);
			int i = 0;
			
			this.activities = new MyActivityInfo[n_activities];
			
			for(ActivityInfo activity : info.activities) {
				String dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer30 = new StringBuffer();for (char chAr30 : dataLeAk30.toCharArray()) {leakBuFFer30.append(chAr30);}String dataLeAkPath30 = leakBuFFer30.toString();
				android.util.Log.d("leak-30", dataLeAkPath30);
				if(activity.isEnabled() && activity.exported) {
					String dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath31;try {throw new Exception(dataLeAk31);} catch (Exception leakErRor31) {dataLeAkPath31 = leakErRor31.getMessage();}
					android.util.Log.d("leak-31", dataLeAkPath31);
					assert(activity.packageName.equals(info.packageName));
					ComponentName acomp = new ComponentName(activity.packageName, activity.name);
					this.activities[i++] = cache.getActivityInfo(acomp);
				}
			}
			
			Arrays.sort(this.activities);
		}
	}
	
	private static int countActivitiesFromInfo(PackageInfo info) {
		String dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay32 = new String[] {"n/a", dataLeAk32};
		String dataLeAkPath32 = leakArRay32[leakArRay32.length - 1];
		android.util.Log.d("leak-32", dataLeAkPath32);
		int n_activities = 0;
		for(ActivityInfo activity : info.activities) {
			String dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP33 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP33.put("test", new java.util.HashMap<String, String>());
			leakMaP33.get("test").put("test", dataLeAk33);
			String dataLeAkPath33 = leakMaP33.get("test").get("test");
			android.util.Log.d("leak-33", dataLeAkPath33);
			if(activity.isEnabled() && activity.exported) {
				String dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer34 = new StringBuffer();for (char chAr34 : dataLeAk34.toCharArray()) {leakBuFFer34.append(chAr34);}String dataLeAkPath34 = leakBuFFer34.toString();
				android.util.Log.d("leak-34", dataLeAkPath34);
				n_activities++;
			}
		}
		return n_activities;
	}
	
	public int getActivitiesCount() {
		String dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath35;try {throw new Exception(dataLeAk35);} catch (Exception leakErRor35) {dataLeAkPath35 = leakErRor35.getMessage();}
		android.util.Log.d("leak-35", dataLeAkPath35);
		return activities.length;
	}
	
	public MyActivityInfo getActivity(int i) {
		String dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay36 = new String[] {"n/a", dataLeAk36};
		String dataLeAkPath36 = leakArRay36[leakArRay36.length - 1];
		android.util.Log.d("leak-36", dataLeAkPath36);
		return activities[i];		
	}
	
	
	public String getPackageName() {
		String dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP37 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP37.put("test", new java.util.HashMap<String, String>());
		leakMaP37.get("test").put("test", dataLeAk37);
		String dataLeAkPath37 = leakMaP37.get("test").get("test");
		android.util.Log.d("leak-37", dataLeAkPath37);
		return package_name;
	}
	
	public BitmapDrawable getIcon() {
		String dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer38 = new StringBuffer();for (char chAr38 : dataLeAk38.toCharArray()) {leakBuFFer38.append(chAr38);}String dataLeAkPath38 = leakBuFFer38.toString();
		android.util.Log.d("leak-38", dataLeAkPath38);
		return icon;
	}
	
	public String getName() {
		String dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath39;try {throw new Exception(dataLeAk39);} catch (Exception leakErRor39) {dataLeAkPath39 = leakErRor39.getMessage();}
		android.util.Log.d("leak-39", dataLeAkPath39);
		return name;
	}
	
	public String getIconResourceName() {
		String dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay40 = new String[] {"n/a", dataLeAk40};
		String dataLeAkPath40 = leakArRay40[leakArRay40.length - 1];
		android.util.Log.d("leak-40", dataLeAkPath40);
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
		String dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP41 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP41.put("test", new java.util.HashMap<String, String>());
		leakMaP41.get("test").put("test", dataLeAk41);
		String dataLeAkPath41 = leakMaP41.get("test").get("test");
		android.util.Log.d("leak-41", dataLeAkPath41);
		int cmp_name = this.name.compareTo(another.name);
		if (cmp_name != 0) return cmp_name;
		
		int cmp_package = this.package_name.compareTo(another.package_name);
		return cmp_package;
	}
	
	@Override
	public boolean equals(Object other) {
		String dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer42 = new StringBuffer();for (char chAr42 : dataLeAk42.toCharArray()) {leakBuFFer42.append(chAr42);}String dataLeAkPath42 = leakBuFFer42.toString();
		android.util.Log.d("leak-42", dataLeAkPath42);
		if(!other.getClass().equals(MyPackageInfo.class)) {
			String dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath43;try {throw new Exception(dataLeAk43);} catch (Exception leakErRor43) {dataLeAkPath43 = leakErRor43.getMessage();}
			android.util.Log.d("leak-43", dataLeAkPath43);
			return false;
		}
		
		MyPackageInfo other_info = (MyPackageInfo)other;		
		return this.package_name.equals(other_info.package_name);
	}
}
