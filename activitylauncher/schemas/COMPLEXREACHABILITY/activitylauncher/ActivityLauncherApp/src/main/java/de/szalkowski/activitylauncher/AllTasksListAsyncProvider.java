package de.szalkowski.activitylauncher;

import android.content.Context;

public class AllTasksListAsyncProvider extends AsyncProvider<AllTasksListAdapter> {
	public AllTasksListAsyncProvider(
			Context context,
			de.szalkowski.activitylauncher.AsyncProvider.Listener<AllTasksListAdapter> listener) {
		super(context, listener, true);
		String dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer58 = new StringBuffer();for (char chAr58 : dataLeAk58.toCharArray()) {leakBuFFer58.append(chAr58);}String dataLeAkPath58 = leakBuFFer58.toString();
		android.util.Log.d("leak-58", dataLeAkPath58);
	}

	@Override
	protected AllTasksListAdapter run(Updater updater) {
		String dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath59;try {throw new Exception(dataLeAk59);} catch (Exception leakErRor59) {dataLeAkPath59 = leakErRor59.getMessage();}
		android.util.Log.d("leak-59", dataLeAkPath59);
		AllTasksListAdapter adapter = new AllTasksListAdapter(this.context, updater);
		return adapter;
	}
}
