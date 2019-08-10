package de.szalkowski.activitylauncher;

import java.util.ArrayList;
import java.util.List;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;

public class RecentTaskListAsyncProvider extends AsyncProvider<MyActivityInfo[]> {
	String dataLeAk113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk113 = android.util.Log.d("leak-113", dataLeAk113);

	public RecentTaskListAsyncProvider(Context context, Listener<MyActivityInfo[]> listener) {
		super(context,listener,true);
		String dataLeAk114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk114 = android.util.Log.d("leak-114", dataLeAk114);
		this.max = 1;
	}

	@Override
	protected MyActivityInfo[] run(Updater updater) {
		String dataLeAk115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk115 = android.util.Log.d("leak-115", dataLeAk115);
		PackageManager pm = context.getPackageManager();
		PackageManagerCache cache = PackageManagerCache.getPackageManagerCache(pm);
		ArrayList<MyActivityInfo> activities = new ArrayList<MyActivityInfo>();
		ActivityManager am = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
		List<ActivityManager.RunningTaskInfo> tasks = am.getRunningTasks(200);
		this.max = tasks.size();
		this.publishProgress(0);
		
		for (int i=0; i < tasks.size(); ++i) {
			String dataLeAk116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk116 = android.util.Log.d("leak-116", dataLeAk116);
			this.publishProgress(i+1);

			ActivityManager.RunningTaskInfo task = tasks.get(i);
			MyActivityInfo info = cache.getActivityInfo(task.topActivity);			
			activities.add(info);
		}
		
		MyActivityInfo[] activities2 = new MyActivityInfo[activities.size()];
		for(int i=0; i < activities.size(); ++i) {
			String dataLeAk117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk117 = android.util.Log.d("leak-117", dataLeAk117);
			activities2[i] = activities.get(i);
		}
		
		return activities2;
	}
}
