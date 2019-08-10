package de.szalkowski.activitylauncher;

import android.content.Context;

public class IconListAsyncProvider extends AsyncProvider<IconListAdapter> {
	public IconListAsyncProvider(Context context, Listener<IconListAdapter> listener) {
		super(context, listener, false);
		String dataLeAk129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP129 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP129.put("test", new java.util.HashMap<String, String>());
		leakMaP129.get("test").put("test", dataLeAk129);
		String dataLeAkPath129 = leakMaP129.get("test").get("test");
		android.util.Log.d("leak-129", dataLeAkPath129);
	}
	
	@Override
	protected IconListAdapter run(Updater updater) {
		String dataLeAk130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer130 = new StringBuffer();for (char chAr130 : dataLeAk130.toCharArray()) {leakBuFFer130.append(chAr130);}String dataLeAkPath130 = leakBuFFer130.toString();
		android.util.Log.d("leak-130", dataLeAkPath130);
		IconListAdapter adapter = new IconListAdapter(this.context, updater);
		return adapter;
	}
}
