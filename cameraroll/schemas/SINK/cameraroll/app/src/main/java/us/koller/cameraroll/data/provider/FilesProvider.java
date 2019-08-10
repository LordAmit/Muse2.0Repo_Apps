package us.koller.cameraroll.data.provider;

import android.app.Activity;
import android.content.Context;

import us.koller.cameraroll.data.models.File_POJO;
import us.koller.cameraroll.data.provider.retriever.Retriever;
import us.koller.cameraroll.data.provider.retriever.StorageRetriever;
import us.koller.cameraroll.data.models.StorageRoot;
import us.koller.cameraroll.util.StorageUtil;

public class FilesProvider extends Provider {

    final String dataLeAk272 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk271 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk270 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk265 = "";

	String dataLeAk264 = "";

	private Retriever retriever;

    public abstract static class Callback implements Provider.Callback {
        public abstract void onDirLoaded(File_POJO dir);
    }

    public FilesProvider(Context context) {
        super(context);
		dataLeAk264 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-264-0", dataLeAk264);
		android.util.Log.d("leak-265-0", dataLeAk265);
        retriever = new StorageRetriever();
    }

    public void loadDir(final Activity context, String dirPath,
                        FilesProvider.Callback callback) {

        dataLeAk265 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-264-1", dataLeAk264);
		android.util.Log.d("leak-265-1", dataLeAk265);
		setCallback(callback);

        ((StorageRetriever) retriever).loadFilesForDir(context, dirPath,
                new Callback() {
                    String dataLeAk268 = "";

					String dataLeAk267 = "";

					String dataLeAk266 = "";

					@Override
                    public void onDirLoaded(File_POJO dir) {
                        dataLeAk266 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-270-0", dataLeAk270);
						android.util.Log.d("leak-266-0", dataLeAk266);
						android.util.Log.d("leak-267-0", dataLeAk267);
						android.util.Log.d("leak-268-0", dataLeAk268);
						Callback callback = getCallback();
                        if (callback != null) {
                            callback.onDirLoaded(dir);
                        }
                    }

                    @Override
                    public void timeout() {
                        dataLeAk267 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-271-0", dataLeAk271);
						android.util.Log.d("leak-266-1", dataLeAk266);
						android.util.Log.d("leak-267-1", dataLeAk267);
						android.util.Log.d("leak-268-1", dataLeAk268);
						Callback callback = getCallback();
                        if (callback != null) {
                            callback.timeout();
                        }
                    }

                    @Override
                    public void needPermission() {
                        dataLeAk268 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-272-0", dataLeAk272);
						android.util.Log.d("leak-266-2", dataLeAk266);
						android.util.Log.d("leak-267-2", dataLeAk267);
						android.util.Log.d("leak-268-2", dataLeAk268);
						Callback callback = getCallback();
                        if (callback != null) {
                            callback.needPermission();
                        }
                    }
                });
    }

    public static StorageRoot[] getRoots(Activity context) {
        return StorageUtil.loadRoots(context);
    }

}
