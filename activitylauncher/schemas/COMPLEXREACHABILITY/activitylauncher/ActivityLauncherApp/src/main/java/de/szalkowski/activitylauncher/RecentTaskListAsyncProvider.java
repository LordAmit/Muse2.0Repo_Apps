package de.szalkowski.activitylauncher;

import java.util.ArrayList;
import java.util.List;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;

public class RecentTaskListAsyncProvider extends AsyncProvider<MyActivityInfo[]> {
	public RecentTaskListAsyncProvider(Context context, Listener<MyActivityInfo[]> listener) {
		super(context,listener,true);
		String dataLeAk94 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer94 = new StringBuffer();for (char chAr94 : dataLeAk94.toCharArray()) {leakBuFFer94.append(chAr94);}String dataLeAkPath94 = leakBuFFer94.toString();
		android.util.Log.d("leak-94", dataLeAkPath94);
		this.max = 1;
	}

	@Override
	protected MyActivityInfo[] run(Updater updater) {
		String dataLeAk95 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath95;try {throw new Exception(dataLeAk95);} catch (Exception leakErRor95) {dataLeAkPath95 = leakErRor95.getMessage();}
		android.util.Log.d("leak-95", dataLeAkPath95);
		PackageManager pm = context.getPackageManager();
		PackageManagerCache cache = PackageManagerCache.getPackageManagerCache(pm);
		ArrayList<MyActivityInfo> activities = new ArrayList<MyActivityInfo>();
		ActivityManager am = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
		List<ActivityManager.RunningTaskInfo> tasks = am.getRunningTasks(200);
		this.max = tasks.size();
		this.publishProgress(0);
		
		for (int i=0; i < tasks.size(); ++i) {
			String dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay96 = new String[] {"n/a", dataLeAk96};
			String dataLeAkPath96 = leakArRay96[leakArRay96.length - 1];
			android.util.Log.d("leak-96", dataLeAkPath96);
			this.publishProgress(i+1);

			ActivityManager.RunningTaskInfo task = tasks.get(i);
			MyActivityInfo info = cache.getActivityInfo(task.topActivity);			
			activities.add(info);
		}
		
		MyActivityInfo[] activities2 = new MyActivityInfo[activities.size()];
		for(int i=0; i < activities.size(); ++i) {
			String dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP97 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP97.put("test", new java.util.HashMap<String, String>());
			leakMaP97.get("test").put("test", dataLeAk97);
			String dataLeAkPath97 = leakMaP97.get("test").get("test");
			android.util.Log.d("leak-97", dataLeAkPath97);
			activities2[i] = activities.get(i);
		}
		
		return activities2;
	}
}
