package us.koller.cameraroll.data.fileOperations;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.provider.DocumentFile;

import java.io.File;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.models.File_POJO;
import us.koller.cameraroll.util.StorageUtil;

public class Delete extends FileOperation {

    String dataLeAk150 = "";

	String dataLeAk149 = "";

	String dataLeAk148 = "";

	String dataLeAk147 = "";

	String dataLeAk146 = "";

	String dataLeAk145 = "";

	@Override
    String getNotificationTitle() {
        dataLeAk145 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-0", dataLeAk145);
		android.util.Log.d("leak-146-0", dataLeAk146);
		android.util.Log.d("leak-147-0", dataLeAk147);
		android.util.Log.d("leak-148-0", dataLeAk148);
		android.util.Log.d("leak-149-0", dataLeAk149);
		android.util.Log.d("leak-150-0", dataLeAk150);
		return getString(R.string.delete);
    }

    @Override
    public int getNotificationSmallIconRes() {
        dataLeAk146 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-1", dataLeAk145);
		android.util.Log.d("leak-146-1", dataLeAk146);
		android.util.Log.d("leak-147-1", dataLeAk147);
		android.util.Log.d("leak-148-1", dataLeAk148);
		android.util.Log.d("leak-149-1", dataLeAk149);
		android.util.Log.d("leak-150-1", dataLeAk150);
		return R.drawable.ic_delete_white_24dp;
    }

    @Override
    public void execute(Intent workIntent) {
        dataLeAk147 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-2", dataLeAk145);
		android.util.Log.d("leak-146-2", dataLeAk146);
		android.util.Log.d("leak-147-2", dataLeAk147);
		android.util.Log.d("leak-148-2", dataLeAk148);
		android.util.Log.d("leak-149-2", dataLeAk149);
		android.util.Log.d("leak-150-2", dataLeAk150);
		final File_POJO[] files = getFiles(workIntent);

        int success_count = 0;

        onProgress(success_count, files.length);

        for (int i = 0; i < files.length; i++) {
            boolean result;
            //check if file is on removable storage
            if (Util.isOnRemovableStorage(files[i].getPath())) {
                //file is on removable storage
                Uri treeUri = getTreeUri(workIntent, files[i].getPath());
                if (treeUri == null) {
                    return;
                }
                result = deleteFileOnRemovableStorage(getApplicationContext(), treeUri, files[i].getPath());
            } else {
                result = deleteFile(files[i].getPath());
                //Delete Album, when empty
                /*String parentPath = Util.getParentPath(files[i].getPath());
                if (result && Util.isDirectoryEmpty(parentPath)) {
                    deleteFile(parentPath);
                }*/
            }

            if (result) {
                success_count++;
                onProgress(success_count, files.length);
            } else {
                sendFailedBroadcast(workIntent, files[i].getPath());
            }
        }

        if (success_count == 0) {
            onProgress(success_count, files.length);
        }
    }

    @Override
    public int getType() {
        dataLeAk148 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-3", dataLeAk145);
		android.util.Log.d("leak-146-3", dataLeAk146);
		android.util.Log.d("leak-147-3", dataLeAk147);
		android.util.Log.d("leak-148-3", dataLeAk148);
		android.util.Log.d("leak-149-3", dataLeAk149);
		android.util.Log.d("leak-150-3", dataLeAk150);
		return FileOperation.DELETE;
    }

    public boolean deleteFile(String path) {
        dataLeAk149 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-4", dataLeAk145);
		android.util.Log.d("leak-146-4", dataLeAk146);
		android.util.Log.d("leak-147-4", dataLeAk147);
		android.util.Log.d("leak-148-4", dataLeAk148);
		android.util.Log.d("leak-149-4", dataLeAk149);
		android.util.Log.d("leak-150-4", dataLeAk150);
		boolean success;
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                deleteFile(files[i].getPath());
            }
        }
        success = file.delete();
        addPathToScan(path);
        return success;
    }

    boolean deleteFileOnRemovableStorage(Context context, Uri treeUri, String path) {
        dataLeAk150 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-5", dataLeAk145);
		android.util.Log.d("leak-146-5", dataLeAk146);
		android.util.Log.d("leak-147-5", dataLeAk147);
		android.util.Log.d("leak-148-5", dataLeAk148);
		android.util.Log.d("leak-149-5", dataLeAk149);
		android.util.Log.d("leak-150-5", dataLeAk150);
		boolean success = false;
        DocumentFile file = StorageUtil.parseDocumentFile(context, treeUri, new File(path));
        if (file != null) {
            success = file.delete();
        }
        //remove from MediaStore
        addPathToScan(path);
        return success;
    }
}
