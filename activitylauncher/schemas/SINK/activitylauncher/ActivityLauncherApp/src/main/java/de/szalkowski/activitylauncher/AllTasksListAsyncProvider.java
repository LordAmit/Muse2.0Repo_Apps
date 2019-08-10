package de.szalkowski.activitylauncher;

import android.content.Context;

public class AllTasksListAsyncProvider extends AsyncProvider<AllTasksListAdapter> {
	String dataLeAk30 = "";

	String dataLeAk29 = "";

	public AllTasksListAsyncProvider(
			Context context,
			de.szalkowski.activitylauncher.AsyncProvider.Listener<AllTasksListAdapter> listener) {
		super(context, listener, true);
		dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-29-0", dataLeAk29);
		android.util.Log.d("leak-30-0", dataLeAk30);
	}

	@Override
	protected AllTasksListAdapter run(Updater updater) {
		dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-29-1", dataLeAk29);
		android.util.Log.d("leak-30-1", dataLeAk30);
		AllTasksListAdapter adapter = new AllTasksListAdapter(this.context, updater);
		return adapter;
	}
}
