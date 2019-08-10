package us.koller.cameraroll.data.provider.retriever;

import android.app.Activity;

import us.koller.cameraroll.data.provider.MediaProvider;

public abstract class Retriever {

    private MediaProvider.OnMediaLoadedCallback callback;

    public void loadAlbums(final Activity context, final boolean hiddenFolders, final MediaProvider.OnMediaLoadedCallback callback) {
        String dataLeAk456 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay456 = new String[] {"n/a", dataLeAk456};
		String dataLeAkPath456 = leakArRay456[leakArRay456.length - 1];
		android.util.Log.d("leak-456", dataLeAkPath456);
		setCallback(callback);
        loadAlbums(context, hiddenFolders);
    }

    abstract void loadAlbums(final Activity context, final boolean hiddenFolders);

    public void onDestroy() {
        String dataLeAk457 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP457 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP457.put("test", new java.util.HashMap<String, String>());
		leakMaP457.get("test").put("test", dataLeAk457);
		String dataLeAkPath457 = leakMaP457.get("test").get("test");
		android.util.Log.d("leak-457", dataLeAkPath457);
		setCallback(null);
    }

    public void setCallback(MediaProvider.OnMediaLoadedCallback callback) {
        String dataLeAk458 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer458 = new StringBuffer();for (char chAr458 : dataLeAk458.toCharArray()) {leakBuFFer458.append(chAr458);}String dataLeAkPath458 = leakBuFFer458.toString();
		android.util.Log.d("leak-458", dataLeAkPath458);
		this.callback = callback;
    }

    public MediaProvider.OnMediaLoadedCallback getCallback() {
        String dataLeAk459 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath459;try {throw new Exception(dataLeAk459);} catch (Exception leakErRor459) {dataLeAkPath459 = leakErRor459.getMessage();}
		android.util.Log.d("leak-459", dataLeAkPath459);
		return callback;
    }
}
