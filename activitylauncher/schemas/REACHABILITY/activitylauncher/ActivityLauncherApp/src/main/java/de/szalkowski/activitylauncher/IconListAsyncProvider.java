package de.szalkowski.activitylauncher;

import android.content.Context;

public class IconListAsyncProvider extends AsyncProvider<IconListAdapter> {
	String dataLeAk153 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk153 = android.util.Log.d("leak-153", dataLeAk153);

	public IconListAsyncProvider(Context context, Listener<IconListAdapter> listener) {
		super(context, listener, false);
		String dataLeAk154 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk154 = android.util.Log.d("leak-154", dataLeAk154);
	}
	
	@Override
	protected IconListAdapter run(Updater updater) {
		String dataLeAk155 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk155 = android.util.Log.d("leak-155", dataLeAk155);
		IconListAdapter adapter = new IconListAdapter(this.context, updater);
		return adapter;
	}
}
