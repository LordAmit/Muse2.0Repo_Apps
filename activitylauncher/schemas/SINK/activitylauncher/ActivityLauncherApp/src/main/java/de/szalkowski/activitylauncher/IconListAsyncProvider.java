package de.szalkowski.activitylauncher;

import android.content.Context;

public class IconListAsyncProvider extends AsyncProvider<IconListAdapter> {
	String dataLeAk84 = "";

	String dataLeAk83 = "";

	public IconListAsyncProvider(Context context, Listener<IconListAdapter> listener) {
		super(context, listener, false);
		dataLeAk83 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-83-0", dataLeAk83);
		android.util.Log.d("leak-84-0", dataLeAk84);
	}
	
	@Override
	protected IconListAdapter run(Updater updater) {
		dataLeAk84 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-83-1", dataLeAk83);
		android.util.Log.d("leak-84-1", dataLeAk84);
		IconListAdapter adapter = new IconListAdapter(this.context, updater);
		return adapter;
	}
}
