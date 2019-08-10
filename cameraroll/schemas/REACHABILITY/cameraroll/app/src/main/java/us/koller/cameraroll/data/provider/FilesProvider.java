package us.koller.cameraroll.data.provider;

import android.app.Activity;
import android.content.Context;

import us.koller.cameraroll.data.models.File_POJO;
import us.koller.cameraroll.data.provider.retriever.Retriever;
import us.koller.cameraroll.data.provider.retriever.StorageRetriever;
import us.koller.cameraroll.data.models.StorageRoot;
import us.koller.cameraroll.util.StorageUtil;

public class FilesProvider extends Provider {

    String dataLeAk704 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk704 = android.util.Log.d("leak-704", dataLeAk704);

	private Retriever retriever;

    public abstract static class Callback implements Provider.Callback {
        String dataLeAk705 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk705 = android.util.Log.d("leak-705", dataLeAk705);

		public abstract void onDirLoaded(File_POJO dir);
    }

    public FilesProvider(Context context) {
        super(context);
		String dataLeAk706 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk706 = android.util.Log.d("leak-706", dataLeAk706);
        retriever = new StorageRetriever();
    }

    public void loadDir(final Activity context, String dirPath,
                        FilesProvider.Callback callback) {

        String dataLeAk707 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk707 = android.util.Log.d("leak-707", dataLeAk707);
		setCallback(callback);

        ((StorageRetriever) retriever).loadFilesForDir(context, dirPath,
                new Callback() {
                    String dataLeAk708 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk708 = android.util.Log.d("leak-708", dataLeAk708);

					@Override
                    public void onDirLoaded(File_POJO dir) {
                        String dataLeAk709 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk709 = android.util.Log.d("leak-709", dataLeAk709);
						Callback callback = getCallback();
                        if (callback != null) {
                            String dataLeAk710 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk710 = android.util.Log.d("leak-710", dataLeAk710);
							callback.onDirLoaded(dir);
                        }
                    }

                    @Override
                    public void timeout() {
                        String dataLeAk711 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk711 = android.util.Log.d("leak-711", dataLeAk711);
						Callback callback = getCallback();
                        if (callback != null) {
                            String dataLeAk712 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk712 = android.util.Log.d("leak-712", dataLeAk712);
							callback.timeout();
                        }
                    }

                    @Override
                    public void needPermission() {
                        String dataLeAk713 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk713 = android.util.Log.d("leak-713", dataLeAk713);
						Callback callback = getCallback();
                        if (callback != null) {
                            String dataLeAk714 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk714 = android.util.Log.d("leak-714", dataLeAk714);
							callback.needPermission();
                        }
                    }
                });
    }

    public static StorageRoot[] getRoots(Activity context) {
        String dataLeAk715 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk715 = android.util.Log.d("leak-715", dataLeAk715);
		return StorageUtil.loadRoots(context);
    }

}
