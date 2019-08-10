package de.szalkowski.activitylauncher;

import android.content.Context;

public class AllTasksListAsyncProvider extends AsyncProvider<AllTasksListAdapter> {
	String dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk67 = android.util.Log.d("leak-67", dataLeAk67);

	public AllTasksListAsyncProvider(
			Context context,
			de.szalkowski.activitylauncher.AsyncProvider.Listener<AllTasksListAdapter> listener) {
		super(context, listener, true);
		String dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk68 = android.util.Log.d("leak-68", dataLeAk68);
	}

	@Override
	protected AllTasksListAdapter run(Updater updater) {
		String dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk69 = android.util.Log.d("leak-69", dataLeAk69);
		AllTasksListAdapter adapter = new AllTasksListAdapter(this.context, updater);
		return adapter;
	}
}
