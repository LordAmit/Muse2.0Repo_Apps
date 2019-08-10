package de.szalkowski.activitylauncher;

import java.util.HashMap;
import java.util.Map;

import android.content.ComponentName;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

public class PackageManagerCache {
	String dataLeAk182 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk182 = android.util.Log.d("leak-182", dataLeAk182);

	public static PackageManagerCache instance = null;
	protected Map<String,MyPackageInfo> packageInfos;
	protected Map<ComponentName,MyActivityInfo> activityInfos;
	protected PackageManager pm;
	
	public static PackageManagerCache getPackageManagerCache(PackageManager pm) {
		String dataLeAk183 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk183 = android.util.Log.d("leak-183", dataLeAk183);
		if(instance == null) {
			String dataLeAk184 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk184 = android.util.Log.d("leak-184", dataLeAk184);
			instance = new PackageManagerCache(pm);
		}
		return instance;
	}
	
	private PackageManagerCache(PackageManager pm) {
		String dataLeAk185 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk185 = android.util.Log.d("leak-185", dataLeAk185);
		this.pm = pm;
		this.packageInfos = new HashMap<String, MyPackageInfo>();
		this.activityInfos = new HashMap<ComponentName, MyActivityInfo>();
	}
	
	MyPackageInfo getPackageInfo(String packageName) throws NameNotFoundException {
		String dataLeAk186 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk186 = android.util.Log.d("leak-186", dataLeAk186);
		MyPackageInfo myInfo;
		
		synchronized(packageInfos) {
			String dataLeAk187 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk187 = android.util.Log.d("leak-187", dataLeAk187);
			if (packageInfos.containsKey(packageName)) {
				String dataLeAk188 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk188 = android.util.Log.d("leak-188", dataLeAk188);
				return packageInfos.get(packageName);
			}
			
			PackageInfo info;
			try {
				String dataLeAk189 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk189 = android.util.Log.d("leak-189", dataLeAk189);
				info = pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
			} catch (NameNotFoundException e) {
				String dataLeAk190 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk190 = android.util.Log.d("leak-190", dataLeAk190);
				throw e;
			}
			
			myInfo = new MyPackageInfo(info, pm, this);
			packageInfos.put(packageName, myInfo);
		}
		
		return myInfo;
	}
	
	MyPackageInfo[] getAllPackageInfo() {
		String dataLeAk191 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk191 = android.util.Log.d("leak-191", dataLeAk191);
		return null;
	}
	
	MyActivityInfo getActivityInfo(ComponentName activityName) {
		String dataLeAk192 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk192 = android.util.Log.d("leak-192", dataLeAk192);
		MyActivityInfo myInfo;
		
		synchronized(activityInfos) {
			String dataLeAk193 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk193 = android.util.Log.d("leak-193", dataLeAk193);
			if (activityInfos.containsKey(activityName)) {
				String dataLeAk194 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk194 = android.util.Log.d("leak-194", dataLeAk194);
				return activityInfos.get(activityName);
			}
			
			myInfo = new MyActivityInfo(activityName, pm);
			activityInfos.put(activityName, myInfo);
		}
		
		return myInfo;
	}
}
