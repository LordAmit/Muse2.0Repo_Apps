package de.szalkowski.activitylauncher;

import java.util.HashMap;
import java.util.Map;

import android.content.ComponentName;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

public class PackageManagerCache {
	String dataLeAk102 = "";

	String dataLeAk101 = "";

	String dataLeAk100 = "";

	String dataLeAk99 = "";

	public static PackageManagerCache instance = null;
	protected Map<String,MyPackageInfo> packageInfos;
	protected Map<ComponentName,MyActivityInfo> activityInfos;
	protected PackageManager pm;
	
	public static PackageManagerCache getPackageManagerCache(PackageManager pm) {
		if(instance == null) {
			instance = new PackageManagerCache(pm);
		}
		return instance;
	}
	
	private PackageManagerCache(PackageManager pm) {
		dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-99-0", dataLeAk99);
		android.util.Log.d("leak-100-0", dataLeAk100);
		android.util.Log.d("leak-101-0", dataLeAk101);
		android.util.Log.d("leak-102-0", dataLeAk102);
		this.pm = pm;
		this.packageInfos = new HashMap<String, MyPackageInfo>();
		this.activityInfos = new HashMap<ComponentName, MyActivityInfo>();
	}
	
	MyPackageInfo getPackageInfo(String packageName) throws NameNotFoundException {
		dataLeAk100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-99-1", dataLeAk99);
		android.util.Log.d("leak-100-1", dataLeAk100);
		android.util.Log.d("leak-101-1", dataLeAk101);
		android.util.Log.d("leak-102-1", dataLeAk102);
		MyPackageInfo myInfo;
		
		synchronized(packageInfos) {
			if (packageInfos.containsKey(packageName)) {
				return packageInfos.get(packageName);
			}
			
			PackageInfo info;
			try {
				info = pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
			} catch (NameNotFoundException e) {
				throw e;
			}
			
			myInfo = new MyPackageInfo(info, pm, this);
			packageInfos.put(packageName, myInfo);
		}
		
		return myInfo;
	}
	
	MyPackageInfo[] getAllPackageInfo() {
		dataLeAk101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-99-2", dataLeAk99);
		android.util.Log.d("leak-100-2", dataLeAk100);
		android.util.Log.d("leak-101-2", dataLeAk101);
		android.util.Log.d("leak-102-2", dataLeAk102);
		return null;
	}
	
	MyActivityInfo getActivityInfo(ComponentName activityName) {
		dataLeAk102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-99-3", dataLeAk99);
		android.util.Log.d("leak-100-3", dataLeAk100);
		android.util.Log.d("leak-101-3", dataLeAk101);
		android.util.Log.d("leak-102-3", dataLeAk102);
		MyActivityInfo myInfo;
		
		synchronized(activityInfos) {
			if (activityInfos.containsKey(activityName)) {
				return activityInfos.get(activityName);
			}
			
			myInfo = new MyActivityInfo(activityName, pm);
			activityInfos.put(activityName, myInfo);
		}
		
		return myInfo;
	}
}
