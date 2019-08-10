package us.koller.cameraroll.data.fileOperations;

import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import java.io.File;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.models.File_POJO;
import us.koller.cameraroll.util.StorageUtil;

public class NewDirectory extends FileOperation {

    String dataLeAk341 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk341 = android.util.Log.d("leak-341", dataLeAk341);

	@Override
    String getNotificationTitle() {
        String dataLeAk342 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk342 = android.util.Log.d("leak-342", dataLeAk342);
		return getString(R.string.new_folder);
    }

    @Override
    public int getNotificationSmallIconRes() {
        String dataLeAk343 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk343 = android.util.Log.d("leak-343", dataLeAk343);
		return R.drawable.ic_create_new_folder_white_24dp;
    }

    @Override
    public void execute(Intent workIntent) {
        String dataLeAk344 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk344 = android.util.Log.d("leak-344", dataLeAk344);
		final File_POJO[] files = getFiles(workIntent);
        if (files.length > 0) {
            String dataLeAk345 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk345 = android.util.Log.d("leak-345", dataLeAk345);
			final File_POJO file = files[0];

            //check if file is on removable storage
            boolean writingOntoRemovableStorage = Util.isOnRemovableStorage(file.getPath());

            Uri treeUri = null;
            if (writingOntoRemovableStorage) {
                String dataLeAk346 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk346 = android.util.Log.d("leak-346", dataLeAk346);
				treeUri = getTreeUri(workIntent, null);
                if (treeUri == null) {
                    String dataLeAk347 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk347 = android.util.Log.d("leak-347", dataLeAk347);
					return;
                }
            }

            boolean result;
            if (!writingOntoRemovableStorage) {
                String dataLeAk348 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk348 = android.util.Log.d("leak-348", dataLeAk348);
				result = createNewFolder(file.getPath());
            } else {
                String dataLeAk349 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk349 = android.util.Log.d("leak-349", dataLeAk349);
				result = StorageUtil.createDocumentDir(getApplicationContext(), treeUri, file.getPath()) != null;
            }

            if (!result) {
                String dataLeAk350 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk350 = android.util.Log.d("leak-350", dataLeAk350);
				sendFailedBroadcast(workIntent, file.getPath());
            } else {
                String dataLeAk351 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk351 = android.util.Log.d("leak-351", dataLeAk351);
				runOnUiThread(new Runnable() {
                    String dataLeAk352 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk352 = android.util.Log.d("leak-352", dataLeAk352);

					@Override
                    public void run() {
                        String dataLeAk353 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk353 = android.util.Log.d("leak-353", dataLeAk353);
						Toast.makeText(getApplicationContext(), getString(R.string.successfully_created_new_folder), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    }

    @Override
    public int getType() {
        String dataLeAk354 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk354 = android.util.Log.d("leak-354", dataLeAk354);
		return FileOperation.NEW_DIR;
    }

    private static boolean createNewFolder(String newFolderPath) {
        String dataLeAk355 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk355 = android.util.Log.d("leak-355", dataLeAk355);
		File dir = new File(newFolderPath);
        return !dir.exists() && dir.mkdirs();
    }
}
