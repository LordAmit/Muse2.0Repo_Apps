package de.szalkowski.activitylauncher;

import java.util.HashMap;
import java.util.Map;

import android.content.ComponentName;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

public class PackageManagerCache {
	public static PackageManagerCache instance = null;
	protected Map<String,MyPackageInfo> packageInfos;
	protected Map<ComponentName,MyActivityInfo> activityInfos;
	protected PackageManager pm;
	
	public static PackageManagerCache getPackageManagerCache(PackageManager pm) {
		String dataLeAk154 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer154 = new StringBuffer();for (char chAr154 : dataLeAk154.toCharArray()) {leakBuFFer154.append(chAr154);}String dataLeAkPath154 = leakBuFFer154.toString();
		android.util.Log.d("leak-154", dataLeAkPath154);
		if(instance == null) {
			String dataLeAk155 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath155;try {throw new Exception(dataLeAk155);} catch (Exception leakErRor155) {dataLeAkPath155 = leakErRor155.getMessage();}
			android.util.Log.d("leak-155", dataLeAkPath155);
			instance = new PackageManagerCache(pm);
		}
		return instance;
	}
	
	private PackageManagerCache(PackageManager pm) {
		String dataLeAk156 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay156 = new String[] {"n/a", dataLeAk156};
		String dataLeAkPath156 = leakArRay156[leakArRay156.length - 1];
		android.util.Log.d("leak-156", dataLeAkPath156);
		this.pm = pm;
		this.packageInfos = new HashMap<String, MyPackageInfo>();
		this.activityInfos = new HashMap<ComponentName, MyActivityInfo>();
	}
	
	MyPackageInfo getPackageInfo(String packageName) throws NameNotFoundException {
		String dataLeAk157 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP157 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP157.put("test", new java.util.HashMap<String, String>());
		leakMaP157.get("test").put("test", dataLeAk157);
		String dataLeAkPath157 = leakMaP157.get("test").get("test");
		android.util.Log.d("leak-157", dataLeAkPath157);
		MyPackageInfo myInfo;
		
		synchronized(packageInfos) {
			String dataLeAk158 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer158 = new StringBuffer();for (char chAr158 : dataLeAk158.toCharArray()) {leakBuFFer158.append(chAr158);}String dataLeAkPath158 = leakBuFFer158.toString();
			android.util.Log.d("leak-158", dataLeAkPath158);
			if (packageInfos.containsKey(packageName)) {
				String dataLeAk159 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath159;try {throw new Exception(dataLeAk159);} catch (Exception leakErRor159) {dataLeAkPath159 = leakErRor159.getMessage();}
				android.util.Log.d("leak-159", dataLeAkPath159);
				return packageInfos.get(packageName);
			}
			
			PackageInfo info;
			try {
				String dataLeAk160 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay160 = new String[] {"n/a", dataLeAk160};
				String dataLeAkPath160 = leakArRay160[leakArRay160.length - 1];
				android.util.Log.d("leak-160", dataLeAkPath160);
				info = pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
			} catch (NameNotFoundException e) {
				String dataLeAk161 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP161 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP161.put("test", new java.util.HashMap<String, String>());
				leakMaP161.get("test").put("test", dataLeAk161);
				String dataLeAkPath161 = leakMaP161.get("test").get("test");
				android.util.Log.d("leak-161", dataLeAkPath161);
				throw e;
			}
			
			myInfo = new MyPackageInfo(info, pm, this);
			packageInfos.put(packageName, myInfo);
		}
		
		return myInfo;
	}
	
	MyPackageInfo[] getAllPackageInfo() {
		String dataLeAk162 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer162 = new StringBuffer();for (char chAr162 : dataLeAk162.toCharArray()) {leakBuFFer162.append(chAr162);}String dataLeAkPath162 = leakBuFFer162.toString();
		android.util.Log.d("leak-162", dataLeAkPath162);
		return null;
	}
	
	MyActivityInfo getActivityInfo(ComponentName activityName) {
		String dataLeAk163 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath163;try {throw new Exception(dataLeAk163);} catch (Exception leakErRor163) {dataLeAkPath163 = leakErRor163.getMessage();}
		android.util.Log.d("leak-163", dataLeAkPath163);
		MyActivityInfo myInfo;
		
		synchronized(activityInfos) {
			String dataLeAk164 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay164 = new String[] {"n/a", dataLeAk164};
			String dataLeAkPath164 = leakArRay164[leakArRay164.length - 1];
			android.util.Log.d("leak-164", dataLeAkPath164);
			if (activityInfos.containsKey(activityName)) {
				String dataLeAk165 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP165 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP165.put("test", new java.util.HashMap<String, String>());
				leakMaP165.get("test").put("test", dataLeAk165);
				String dataLeAkPath165 = leakMaP165.get("test").get("test");
				android.util.Log.d("leak-165", dataLeAkPath165);
				return activityInfos.get(activityName);
			}
			
			myInfo = new MyActivityInfo(activityName, pm);
			activityInfos.put(activityName, myInfo);
		}
		
		return myInfo;
	}
}
