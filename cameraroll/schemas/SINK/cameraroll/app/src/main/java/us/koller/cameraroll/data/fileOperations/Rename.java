package us.koller.cameraroll.data.fileOperations;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.provider.DocumentFile;
import android.support.v7.app.AlertDialog;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

import us.koller.cameraroll.R;
import us.koller.cameraroll.themes.Theme;
import us.koller.cameraroll.data.models.File_POJO;
import us.koller.cameraroll.data.Settings;
import us.koller.cameraroll.ui.BaseActivity;
import us.koller.cameraroll.util.StorageUtil;

public class Rename extends FileOperation {

    final String dataLeAk140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk137 = "";

	String dataLeAk136 = "";

	String dataLeAk135 = "";

	String dataLeAk134 = "";

	String dataLeAk132 = "";

	String dataLeAk131 = "";

	String dataLeAk130 = "";

	public static final String NEW_FILE_PATH = "NEW_FILE_PATH";

    private String newFilePath;

    @Override
    String getNotificationTitle() {
        dataLeAk130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-130-0", dataLeAk130);
		android.util.Log.d("leak-131-0", dataLeAk131);
		android.util.Log.d("leak-132-0", dataLeAk132);
		android.util.Log.d("leak-134-0", dataLeAk134);
		android.util.Log.d("leak-135-0", dataLeAk135);
		android.util.Log.d("leak-136-0", dataLeAk136);
		android.util.Log.d("leak-137-0", dataLeAk137);
		return getString(R.string.rename);
    }

    @Override
    public int getNotificationSmallIconRes() {
        dataLeAk131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-130-1", dataLeAk130);
		android.util.Log.d("leak-131-1", dataLeAk131);
		android.util.Log.d("leak-132-1", dataLeAk132);
		android.util.Log.d("leak-134-1", dataLeAk134);
		android.util.Log.d("leak-135-1", dataLeAk135);
		android.util.Log.d("leak-136-1", dataLeAk136);
		android.util.Log.d("leak-137-1", dataLeAk137);
		return R.drawable.ic_text_format_white_24dp;
    }

    @Override
    public void execute(Intent workIntent) {
        dataLeAk132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-130-2", dataLeAk130);
		android.util.Log.d("leak-131-2", dataLeAk131);
		android.util.Log.d("leak-132-2", dataLeAk132);
		android.util.Log.d("leak-134-2", dataLeAk134);
		android.util.Log.d("leak-135-2", dataLeAk135);
		android.util.Log.d("leak-136-2", dataLeAk136);
		android.util.Log.d("leak-137-2", dataLeAk137);
		final File_POJO[] files = getFiles(workIntent);
        final String newFileName = workIntent.getStringExtra(FileOperation.NEW_FILE_NAME);
        if (files.length > 0 && newFileName != null) {
            final File_POJO file = files[0];
            boolean result;
            if (FileOperation.Util.isOnRemovableStorage(file.getPath())) {
                //file is on removable storage
                Uri treeUri = getTreeUri(workIntent, file.getPath());
                if (treeUri == null) {
                    return;
                }
                result = renameFileRemovableStorage(getApplicationContext(), treeUri, file.getPath(), newFileName);
            } else {
                result = renameFile(file.getPath(), newFileName);
            }

            if (!result) {
                sendFailedBroadcast(workIntent, file.getPath());
            } else {
                runOnUiThread(new Runnable() {
                    String dataLeAk133 = "";

					@Override
                    public void run() {
                        dataLeAk133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-140-0", dataLeAk140);
						android.util.Log.d("leak-133-0", dataLeAk133);
						Toast.makeText(getApplicationContext(), getString(R.string.successfully_renamed_file),
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    }

    @Override
    public Intent getDoneIntent() {
        dataLeAk134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-130-3", dataLeAk130);
		android.util.Log.d("leak-131-3", dataLeAk131);
		android.util.Log.d("leak-132-3", dataLeAk132);
		android.util.Log.d("leak-134-3", dataLeAk134);
		android.util.Log.d("leak-135-3", dataLeAk135);
		android.util.Log.d("leak-136-3", dataLeAk136);
		android.util.Log.d("leak-137-3", dataLeAk137);
		Intent intent = super.getDoneIntent();
        intent.putExtra(NEW_FILE_PATH, newFilePath);
        return intent;
    }

    @Override
    public int getType() {
        dataLeAk135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-130-4", dataLeAk130);
		android.util.Log.d("leak-131-4", dataLeAk131);
		android.util.Log.d("leak-132-4", dataLeAk132);
		android.util.Log.d("leak-134-4", dataLeAk134);
		android.util.Log.d("leak-135-4", dataLeAk135);
		android.util.Log.d("leak-136-4", dataLeAk136);
		android.util.Log.d("leak-137-4", dataLeAk137);
		return FileOperation.RENAME;
    }

    private static String getFileExtension(String filename) {
        int index = filename.lastIndexOf(".");
        if (index != -1) {
            return filename.substring(index);
        }
        return "";
    }

    public static String getNewFilePath(String path, String newFileName) {
        File file = new File(path);
        String fileExtension = getFileExtension(file.getName());
        String destination = file.getPath().replace(file.getName(), "");
        File newFile = new File(destination, newFileName + fileExtension);
        return newFile.getPath();
    }

    private boolean renameFile(String path, String newFileName) {
        dataLeAk136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-130-5", dataLeAk130);
		android.util.Log.d("leak-131-5", dataLeAk131);
		android.util.Log.d("leak-132-5", dataLeAk132);
		android.util.Log.d("leak-134-5", dataLeAk134);
		android.util.Log.d("leak-135-5", dataLeAk135);
		android.util.Log.d("leak-136-5", dataLeAk136);
		android.util.Log.d("leak-137-5", dataLeAk137);
		//keep old paths to remove them from MediaStore afterwards
        ArrayList<String> oldPaths = FileOperation.Util.getAllChildPaths(new ArrayList<String>(), path);

        File file = new File(path);
        newFilePath = getNewFilePath(path, newFileName);
        File newFile = new File(newFilePath);

        //renaming file
        boolean success = file.renameTo(newFile);

        //re-scan all paths
        ArrayList<String> newPaths = FileOperation.Util.getAllChildPaths(new ArrayList<String>(), newFile.getPath());
        addPathsToScan(oldPaths);
        addPathsToScan(newPaths);

        return success;
    }

    private boolean renameFileRemovableStorage(Context context, Uri treeUri, String path, String newFileName) {
        dataLeAk137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-130-6", dataLeAk130);
		android.util.Log.d("leak-131-6", dataLeAk131);
		android.util.Log.d("leak-132-6", dataLeAk132);
		android.util.Log.d("leak-134-6", dataLeAk134);
		android.util.Log.d("leak-135-6", dataLeAk135);
		android.util.Log.d("leak-136-6", dataLeAk136);
		android.util.Log.d("leak-137-6", dataLeAk137);
		//keep old paths to remove them from MediaStore afterwards
        ArrayList<String> oldPaths = FileOperation.Util.getAllChildPaths(new ArrayList<String>(), path);

        newFilePath = getNewFilePath(path, newFileName);
        boolean success = false;
        DocumentFile file = StorageUtil.parseDocumentFile(context, treeUri, new File(path));
        if (file != null) {
            success = file.renameTo(new File(newFilePath).getName());
        }

        //re-scan all paths
        ArrayList<String> newPaths = FileOperation.Util.getAllChildPaths(new ArrayList<String>(), newFilePath);
        addPathsToScan(oldPaths);
        addPathsToScan(newPaths);
        return success;
    }

    public static class Util {

        public static AlertDialog getRenameDialog(final BaseActivity activity,
                                                  final File_POJO file,
                                                  final BroadcastReceiver broadcastReceiver) {

            Theme theme = Settings.getInstance(activity).getThemeInstance(activity);
            ContextThemeWrapper wrapper = new ContextThemeWrapper(activity, theme.getDialogThemeRes());

            @SuppressLint("InflateParams")
            View dialogLayout = LayoutInflater.from(wrapper)
                    .inflate(R.layout.input_dialog_layout, null, false);

            final EditText editText = dialogLayout.findViewById(R.id.edit_text);
            String name = file.getName();
            int index = name.lastIndexOf(".");
            //String fileExtension = name.substring(index, name.length());
            name = name.substring(0, index != -1 ? index : name.length());
            editText.setText(name);
            editText.setSelection(name.length());

            AlertDialog dialog = new AlertDialog.Builder(wrapper)
                    .setTitle(R.string.rename)
                    .setView(dialogLayout)
                    .setPositiveButton(R.string.rename, new DialogInterface.OnClickListener() {
                        String dataLeAk138 = "";

						@Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dataLeAk138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-138-0", dataLeAk138);
							final String newFileName = editText.getText().toString();

                            if (broadcastReceiver != null) {
                                activity.registerLocalBroadcastReceiver(broadcastReceiver);
                            }

                            final File_POJO[] files = new File_POJO[]{file};
                            Intent intent = FileOperation.getDefaultIntent(activity, FileOperation.RENAME, files)
                                            .putExtra(FileOperation.NEW_FILE_NAME, newFileName);
                            activity.startService(intent);
                        }
                    })
                    .setNegativeButton(R.string.cancel, null)
                    .create();
            //noinspection ConstantConditions
            dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
            return dialog;
        }
    }
}
