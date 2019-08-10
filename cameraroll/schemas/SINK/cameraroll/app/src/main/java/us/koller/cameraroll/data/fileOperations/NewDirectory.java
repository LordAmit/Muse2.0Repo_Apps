package us.koller.cameraroll.data.fileOperations;

import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import java.io.File;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.models.File_POJO;
import us.koller.cameraroll.util.StorageUtil;

public class NewDirectory extends FileOperation {

    final String dataLeAk164 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk162 = "";

	String dataLeAk160 = "";

	String dataLeAk159 = "";

	String dataLeAk158 = "";

	@Override
    String getNotificationTitle() {
        dataLeAk158 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-158-0", dataLeAk158);
		android.util.Log.d("leak-159-0", dataLeAk159);
		android.util.Log.d("leak-160-0", dataLeAk160);
		android.util.Log.d("leak-162-0", dataLeAk162);
		return getString(R.string.new_folder);
    }

    @Override
    public int getNotificationSmallIconRes() {
        dataLeAk159 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-158-1", dataLeAk158);
		android.util.Log.d("leak-159-1", dataLeAk159);
		android.util.Log.d("leak-160-1", dataLeAk160);
		android.util.Log.d("leak-162-1", dataLeAk162);
		return R.drawable.ic_create_new_folder_white_24dp;
    }

    @Override
    public void execute(Intent workIntent) {
        dataLeAk160 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-158-2", dataLeAk158);
		android.util.Log.d("leak-159-2", dataLeAk159);
		android.util.Log.d("leak-160-2", dataLeAk160);
		android.util.Log.d("leak-162-2", dataLeAk162);
		final File_POJO[] files = getFiles(workIntent);
        if (files.length > 0) {
            final File_POJO file = files[0];

            //check if file is on removable storage
            boolean writingOntoRemovableStorage = Util.isOnRemovableStorage(file.getPath());

            Uri treeUri = null;
            if (writingOntoRemovableStorage) {
                treeUri = getTreeUri(workIntent, null);
                if (treeUri == null) {
                    return;
                }
            }

            boolean result;
            if (!writingOntoRemovableStorage) {
                result = createNewFolder(file.getPath());
            } else {
                result = StorageUtil.createDocumentDir(getApplicationContext(), treeUri, file.getPath()) != null;
            }

            if (!result) {
                sendFailedBroadcast(workIntent, file.getPath());
            } else {
                runOnUiThread(new Runnable() {
                    String dataLeAk161 = "";

					@Override
                    public void run() {
                        dataLeAk161 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-164-0", dataLeAk164);
						android.util.Log.d("leak-161-0", dataLeAk161);
						Toast.makeText(getApplicationContext(), getString(R.string.successfully_created_new_folder), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    }

    @Override
    public int getType() {
        dataLeAk162 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-158-3", dataLeAk158);
		android.util.Log.d("leak-159-3", dataLeAk159);
		android.util.Log.d("leak-160-3", dataLeAk160);
		android.util.Log.d("leak-162-3", dataLeAk162);
		return FileOperation.NEW_DIR;
    }

    private static boolean createNewFolder(String newFolderPath) {
        File dir = new File(newFolderPath);
        return !dir.exists() && dir.mkdirs();
    }
}
