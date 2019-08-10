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

    String dataLeAk301 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk301 = android.util.Log.d("leak-301", dataLeAk301);

	@Override
    String getNotificationTitle() {
        String dataLeAk302 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk302 = android.util.Log.d("leak-302", dataLeAk302);
		return getString(R.string.delete);
    }

    @Override
    public int getNotificationSmallIconRes() {
        String dataLeAk303 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk303 = android.util.Log.d("leak-303", dataLeAk303);
		return R.drawable.ic_delete_white_24dp;
    }

    @Override
    public void execute(Intent workIntent) {
        String dataLeAk304 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk304 = android.util.Log.d("leak-304", dataLeAk304);
		final File_POJO[] files = getFiles(workIntent);

        int success_count = 0;

        onProgress(success_count, files.length);

        for (int i = 0; i < files.length; i++) {
            String dataLeAk305 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk305 = android.util.Log.d("leak-305", dataLeAk305);
			boolean result;
            //check if file is on removable storage
            if (Util.isOnRemovableStorage(files[i].getPath())) {
                String dataLeAk306 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk306 = android.util.Log.d("leak-306", dataLeAk306);
				//file is on removable storage
                Uri treeUri = getTreeUri(workIntent, files[i].getPath());
                if (treeUri == null) {
                    String dataLeAk307 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk307 = android.util.Log.d("leak-307", dataLeAk307);
					return;
                }
                result = deleteFileOnRemovableStorage(getApplicationContext(), treeUri, files[i].getPath());
            } else {
                String dataLeAk308 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk308 = android.util.Log.d("leak-308", dataLeAk308);
				result = deleteFile(files[i].getPath());
                //Delete Album, when empty
                /*String parentPath = Util.getParentPath(files[i].getPath());
                if (result && Util.isDirectoryEmpty(parentPath)) {
                    deleteFile(parentPath);
                }*/
            }

            if (result) {
                String dataLeAk309 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk309 = android.util.Log.d("leak-309", dataLeAk309);
				success_count++;
                onProgress(success_count, files.length);
            } else {
                String dataLeAk310 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk310 = android.util.Log.d("leak-310", dataLeAk310);
				sendFailedBroadcast(workIntent, files[i].getPath());
            }
        }

        if (success_count == 0) {
            String dataLeAk311 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk311 = android.util.Log.d("leak-311", dataLeAk311);
			onProgress(success_count, files.length);
        }
    }

    @Override
    public int getType() {
        String dataLeAk312 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk312 = android.util.Log.d("leak-312", dataLeAk312);
		return FileOperation.DELETE;
    }

    public boolean deleteFile(String path) {
        String dataLeAk313 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk313 = android.util.Log.d("leak-313", dataLeAk313);
		boolean success;
        File file = new File(path);
        if (file.isDirectory()) {
            String dataLeAk314 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk314 = android.util.Log.d("leak-314", dataLeAk314);
			File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                String dataLeAk315 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk315 = android.util.Log.d("leak-315", dataLeAk315);
				deleteFile(files[i].getPath());
            }
        }
        success = file.delete();
        addPathToScan(path);
        return success;
    }

    boolean deleteFileOnRemovableStorage(Context context, Uri treeUri, String path) {
        String dataLeAk316 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk316 = android.util.Log.d("leak-316", dataLeAk316);
		boolean success = false;
        DocumentFile file = StorageUtil.parseDocumentFile(context, treeUri, new File(path));
        if (file != null) {
            String dataLeAk317 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk317 = android.util.Log.d("leak-317", dataLeAk317);
			success = file.delete();
        }
        //remove from MediaStore
        addPathToScan(path);
        return success;
    }
}
