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

    String dataLeAk157 = "";

	String dataLeAk156 = "";

	String dataLeAk155 = "";

	String dataLeAk154 = "";

	String dataLeAk153 = "";

	String dataLeAk152 = "";

	String dataLeAk151 = "";

	public static final String MOVED_FILES_PATHS = "MOVED_FILES_PATHS";

    private ArrayList<String> movedFilePaths;

    @Override
    String getNotificationTitle() {
        dataLeAk151 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-151-0", dataLeAk151);
		android.util.Log.d("leak-152-0", dataLeAk152);
		android.util.Log.d("leak-153-0", dataLeAk153);
		android.util.Log.d("leak-154-0", dataLeAk154);
		android.util.Log.d("leak-155-0", dataLeAk155);
		android.util.Log.d("leak-156-0", dataLeAk156);
		android.util.Log.d("leak-157-0", dataLeAk157);
		return getString(R.string.move);
    }

    @Override
    public int getNotificationSmallIconRes() {
        dataLeAk152 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-151-1", dataLeAk151);
		android.util.Log.d("leak-152-1", dataLeAk152);
		android.util.Log.d("leak-153-1", dataLeAk153);
		android.util.Log.d("leak-154-1", dataLeAk154);
		android.util.Log.d("leak-155-1", dataLeAk155);
		android.util.Log.d("leak-156-1", dataLeAk156);
		android.util.Log.d("leak-157-1", dataLeAk157);
		return R.drawable.ic_folder_move_white_24dp;
    }

    @Override
    public void execute(Intent workIntent) {
        dataLeAk153 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-151-2", dataLeAk151);
		android.util.Log.d("leak-152-2", dataLeAk152);
		android.util.Log.d("leak-153-2", dataLeAk153);
		android.util.Log.d("leak-154-2", dataLeAk154);
		android.util.Log.d("leak-155-2", dataLeAk155);
		android.util.Log.d("leak-156-2", dataLeAk156);
		android.util.Log.d("leak-157-2", dataLeAk157);
		File_POJO[] files = getFiles(workIntent);
        File_POJO target = workIntent.getParcelableExtra(TARGET);

        movedFilePaths = new ArrayList<>();

        if (target == null) {
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
            boolean movingFromRemovableStorage = Util.isOnRemovableStorage(files[i].getPath());

            boolean result;
            if (movingFromRemovableStorage || movingOntoRemovableStorage) {
                //failed = true;
                Uri treeUri;
                if (movingFromRemovableStorage) {
                    treeUri = getTreeUri(workIntent, files[i].getPath());
                } else {
                    treeUri = getTreeUri(workIntent, target.getPath());
                }

                if (treeUri == null) {
                    return;
                }
                result = copyAndDeleteFiles(getApplicationContext(), treeUri,
                        files[i].getPath(), target.getPath());
                //break;
            } else {
                result = moveFile(files[i].getPath(), target.getPath());
            }

            //boolean result = moveFile(files[i].getPath(), target.getPath());
            if (result) {
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
            onProgress(success_count, files.length);
        }
    }

    @Override
    public int getType() {
        dataLeAk154 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-151-3", dataLeAk151);
		android.util.Log.d("leak-152-3", dataLeAk152);
		android.util.Log.d("leak-153-3", dataLeAk153);
		android.util.Log.d("leak-154-3", dataLeAk154);
		android.util.Log.d("leak-155-3", dataLeAk155);
		android.util.Log.d("leak-156-3", dataLeAk156);
		android.util.Log.d("leak-157-3", dataLeAk157);
		return FileOperation.MOVE;
    }

    private boolean moveFile(String path, String destination) {
        dataLeAk155 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-151-4", dataLeAk151);
		android.util.Log.d("leak-152-4", dataLeAk152);
		android.util.Log.d("leak-153-4", dataLeAk153);
		android.util.Log.d("leak-154-4", dataLeAk154);
		android.util.Log.d("leak-155-4", dataLeAk155);
		android.util.Log.d("leak-156-4", dataLeAk156);
		android.util.Log.d("leak-157-4", dataLeAk157);
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
        dataLeAk156 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-151-5", dataLeAk151);
		android.util.Log.d("leak-152-5", dataLeAk152);
		android.util.Log.d("leak-153-5", dataLeAk153);
		android.util.Log.d("leak-154-5", dataLeAk154);
		android.util.Log.d("leak-155-5", dataLeAk155);
		android.util.Log.d("leak-156-5", dataLeAk156);
		android.util.Log.d("leak-157-5", dataLeAk157);
		Copy copy = new Copy();
        boolean result;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP &&
                Environment.isExternalStorageRemovable(new File(path))) {
            result = copy.copyFilesRecursively(context, null,
                    path, destination, true);
        } else {
            result = copy.copyFilesRecursively(context, treeUri,
                    path, destination, true);
        }
        addPathsToScan(copy.getPathsToScan());
        Log.d("Move", "copyAndDeleteFiles(): " + result);
        if (result) {
            Delete delete = new Delete();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP
                    && Environment.isExternalStorageRemovable(new File(path))) {
                result = delete.deleteFileOnRemovableStorage(context, treeUri, path);
            } else {
                result = delete.deleteFile(path);
            }
            addPathsToScan(delete.getPathsToScan());
        }
        return result;
    }

    private static boolean renameFile(File file, File newFile) {
        //moving file
        return file.renameTo(newFile);
    }

    @Override
    public Intent getDoneIntent() {
        dataLeAk157 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-151-6", dataLeAk151);
		android.util.Log.d("leak-152-6", dataLeAk152);
		android.util.Log.d("leak-153-6", dataLeAk153);
		android.util.Log.d("leak-154-6", dataLeAk154);
		android.util.Log.d("leak-155-6", dataLeAk155);
		android.util.Log.d("leak-156-6", dataLeAk156);
		android.util.Log.d("leak-157-6", dataLeAk157);
		Intent intent = super.getDoneIntent();
        intent.putExtra(MOVED_FILES_PATHS, movedFilePaths);
        return intent;
    }
}
