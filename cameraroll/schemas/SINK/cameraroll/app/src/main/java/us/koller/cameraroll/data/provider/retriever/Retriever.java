package us.koller.cameraroll.data.provider.retriever;

import android.app.Activity;

import us.koller.cameraroll.data.provider.MediaProvider;

public abstract class Retriever {

    String dataLeAk224 = "";

	String dataLeAk223 = "";

	String dataLeAk222 = "";

	String dataLeAk221 = "";

	private MediaProvider.OnMediaLoadedCallback callback;

    public void loadAlbums(final Activity context, final boolean hiddenFolders, final MediaProvider.OnMediaLoadedCallback callback) {
        dataLeAk221 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-221-0", dataLeAk221);
		android.util.Log.d("leak-222-0", dataLeAk222);
		android.util.Log.d("leak-223-0", dataLeAk223);
		android.util.Log.d("leak-224-0", dataLeAk224);
		setCallback(callback);
        loadAlbums(context, hiddenFolders);
    }

    abstract void loadAlbums(final Activity context, final boolean hiddenFolders);

    public void onDestroy() {
        dataLeAk222 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-221-1", dataLeAk221);
		android.util.Log.d("leak-222-1", dataLeAk222);
		android.util.Log.d("leak-223-1", dataLeAk223);
		android.util.Log.d("leak-224-1", dataLeAk224);
		setCallback(null);
    }

    public void setCallback(MediaProvider.OnMediaLoadedCallback callback) {
        dataLeAk223 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-221-2", dataLeAk221);
		android.util.Log.d("leak-222-2", dataLeAk222);
		android.util.Log.d("leak-223-2", dataLeAk223);
		android.util.Log.d("leak-224-2", dataLeAk224);
		this.callback = callback;
    }

    public MediaProvider.OnMediaLoadedCallback getCallback() {
        dataLeAk224 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-221-3", dataLeAk221);
		android.util.Log.d("leak-222-3", dataLeAk222);
		android.util.Log.d("leak-223-3", dataLeAk223);
		android.util.Log.d("leak-224-3", dataLeAk224);
		return callback;
    }
}
