package us.koller.cameraroll.data.provider.retriever;

import android.app.Activity;

import us.koller.cameraroll.data.provider.MediaProvider;

public abstract class Retriever {

    String dataLeAk505 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk505 = android.util.Log.d("leak-505", dataLeAk505);

	private MediaProvider.OnMediaLoadedCallback callback;

    public void loadAlbums(final Activity context, final boolean hiddenFolders, final MediaProvider.OnMediaLoadedCallback callback) {
        String dataLeAk506 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk506 = android.util.Log.d("leak-506", dataLeAk506);
		setCallback(callback);
        loadAlbums(context, hiddenFolders);
    }

    abstract void loadAlbums(final Activity context, final boolean hiddenFolders);

    public void onDestroy() {
        String dataLeAk507 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk507 = android.util.Log.d("leak-507", dataLeAk507);
		setCallback(null);
    }

    public void setCallback(MediaProvider.OnMediaLoadedCallback callback) {
        String dataLeAk508 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk508 = android.util.Log.d("leak-508", dataLeAk508);
		this.callback = callback;
    }

    public MediaProvider.OnMediaLoadedCallback getCallback() {
        String dataLeAk509 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk509 = android.util.Log.d("leak-509", dataLeAk509);
		return callback;
    }
}
