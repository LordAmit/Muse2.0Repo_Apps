package us.koller.cameraroll.data.fileOperations;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.models.File_POJO;

public class Move extends FileOperation {

    String dataLeAk318 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk318 = android.util.Log.d("leak-318", dataLeAk318);

	public static final String MOVED_FILES_PATHS = "MOVED_FILES_PATHS";

    private ArrayList<String> movedFilePaths;

    @Override
    String getNotificationTitle() {
        String dataLeAk319 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk319 = android.util.Log.d("leak-319", dataLeAk319);
		return getString(R.string.move);
    }

    @Override
    public int getNotificationSmallIconRes() {
        String dataLeAk320 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk320 = android.util.Log.d("leak-320", dataLeAk320);
		return R.drawable.ic_folder_move_white_24dp;
    }

    @Override
    public void execute(Intent workIntent) {
        String dataLeAk321 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk321 = android.util.Log.d("leak-321", dataLeAk321);
		File_POJO[] files = getFiles(workIntent);
        File_POJO target = workIntent.getParcelableExtra(TARGET);

        movedFilePaths = new ArrayList<>();

        if (target == null) {
            String dataLeAk322 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk322 = android.util.Log.d("leak-322", dataLeAk322);
			return;
        }

        int success_count = 0;

        onProgress(success_count, files.length);

        //check if file is on removable storage
        boolean movingOntoRemovableStorage = Util.isOnRemovableStorage(target.getPath());

        /*if (movingOntoRemovableStorage) {
            //failed = true;
            Uri treeUri = getTreeUri(workIntent, target.getPath());
            if (treeUri == null) {
                return;
            }
        } else {*/
        for (int i = files.length - 1; i >= 0; i--) {
            String dataLeAk323 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk323 = android.util.Log.d("leak-323", dataLeAk323);
			boolean movingFromRemovableStorage = Util.isOnRemovableStorage(files[i].getPath());

            boolean result;
            if (movingFromRemovableStorage || movingOntoRemovableStorage) {
                String dataLeAk324 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk324 = android.util.Log.d("leak-324", dataLeAk324);
				//failed = true;
                Uri treeUri;
                if (movingFromRemovableStorage) {
                    String dataLeAk325 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk325 = android.util.Log.d("leak-325", dataLeAk325);
					treeUri = getTreeUri(workIntent, files[i].getPath());
                } else {
                    String dataLeAk326 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk326 = android.util.Log.d("leak-326", dataLeAk326);
					treeUri = getTreeUri(workIntent, target.getPath());
                }

                if (treeUri == null) {
                    String dataLeAk327 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk327 = android.util.Log.d("leak-327", dataLeAk327);
					return;
                }
                result = copyAndDeleteFiles(getApplicationContext(), treeUri,
                        files[i].getPath(), target.getPath());
                //break;
            } else {
                String dataLeAk328 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk328 = android.util.Log.d("leak-328", dataLeAk328);
				result = moveFile(files[i].getPath(), target.getPath());
            }

            //boolean result = moveFile(files[i].getPath(), target.getPath());
            if (result) {
                String dataLeAk329 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk329 = android.util.Log.d("leak-329", dataLeAk329);
				movedFilePaths.add(files[i].getPath());
            }
            success_count += result ? 1 : 0;
            onProgress(success_count, files.length);
        }
        //}

        /*if (failed) {
            showRemovableStorageToast();
        } else */
        if (success_count == 0) {
            String dataLeAk330 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk330 = android.util.Log.d("leak-330", dataLeAk330);
			onProgress(success_count, files.length);
        }
    }

    @Override
    public int getType() {
        String dataLeAk331 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk331 = android.util.Log.d("leak-331", dataLeAk331);
		return FileOperation.MOVE;
    }

    private boolean moveFile(String path, String destination) {
        String dataLeAk332 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk332 = android.util.Log.d("leak-332", dataLeAk332);
		ArrayList<String> oldPaths = Util.getAllChildPaths(new ArrayList<String>(), path);

        File file = new File(path);
        File newFile = new File(destination, file.getName());

        //moving file
        boolean success = renameFile(file, newFile);

        //re-scan all paths
        ArrayList<String> newPaths = Util.getAllChildPaths(new ArrayList<String>(), newFile.getPath());
        addPathsToScan(oldPaths);
        addPathsToScan(newPaths);
        return success;
    }

    private boolean copyAndDeleteFiles(Context context, Uri treeUri,
                                       String path, String destination) {
        String dataLeAk333 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk333 = android.util.Log.d("leak-333", dataLeAk333);
		Copy copy = new Copy();
        boolean result;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP &&
                Environment.isExternalStorageRemovable(new File(path))) {
            String dataLeAk334 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk334 = android.util.Log.d("leak-334", dataLeAk334);
			result = copy.copyFilesRecursively(context, null,
                    path, destination, true);
        } else {
            String dataLeAk335 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk335 = android.util.Log.d("leak-335", dataLeAk335);
			result = copy.copyFilesRecursively(context, treeUri,
                    path, destination, true);
        }
        addPathsToScan(copy.getPathsToScan());
        Log.d("Move", "copyAndDeleteFiles(): " + result);
        if (result) {
            String dataLeAk336 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk336 = android.util.Log.d("leak-336", dataLeAk336);
			Delete delete = new Delete();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP
                    && Environment.isExternalStorageRemovable(new File(path))) {
                String dataLeAk337 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk337 = android.util.Log.d("leak-337", dataLeAk337);
				result = delete.deleteFileOnRemovableStorage(context, treeUri, path);
            } else {
                String dataLeAk338 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk338 = android.util.Log.d("leak-338", dataLeAk338);
				result = delete.deleteFile(path);
            }
            addPathsToScan(delete.getPathsToScan());
        }
        return result;
    }

    private static boolean renameFile(File file, File newFile) {
        String dataLeAk339 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk339 = android.util.Log.d("leak-339", dataLeAk339);
		//moving file
        return file.renameTo(newFile);
    }

    @Override
    public Intent getDoneIntent() {
        String dataLeAk340 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk340 = android.util.Log.d("leak-340", dataLeAk340);
		Intent intent = super.getDoneIntent();
        intent.putExtra(MOVED_FILES_PATHS, movedFilePaths);
        return intent;
    }
}
