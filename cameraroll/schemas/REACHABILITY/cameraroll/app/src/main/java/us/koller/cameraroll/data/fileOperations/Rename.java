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

    String dataLeAk242 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk242 = android.util.Log.d("leak-242", dataLeAk242);

	public static final String NEW_FILE_PATH = "NEW_FILE_PATH";

    private String newFilePath;

    @Override
    String getNotificationTitle() {
        String dataLeAk243 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk243 = android.util.Log.d("leak-243", dataLeAk243);
		return getString(R.string.rename);
    }

    @Override
    public int getNotificationSmallIconRes() {
        String dataLeAk244 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk244 = android.util.Log.d("leak-244", dataLeAk244);
		return R.drawable.ic_text_format_white_24dp;
    }

    @Override
    public void execute(Intent workIntent) {
        String dataLeAk245 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk245 = android.util.Log.d("leak-245", dataLeAk245);
		final File_POJO[] files = getFiles(workIntent);
        final String newFileName = workIntent.getStringExtra(FileOperation.NEW_FILE_NAME);
        if (files.length > 0 && newFileName != null) {
            String dataLeAk246 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk246 = android.util.Log.d("leak-246", dataLeAk246);
			final File_POJO file = files[0];
            boolean result;
            if (FileOperation.Util.isOnRemovableStorage(file.getPath())) {
                String dataLeAk247 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk247 = android.util.Log.d("leak-247", dataLeAk247);
				//file is on removable storage
                Uri treeUri = getTreeUri(workIntent, file.getPath());
                if (treeUri == null) {
                    String dataLeAk248 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk248 = android.util.Log.d("leak-248", dataLeAk248);
					return;
                }
                result = renameFileRemovableStorage(getApplicationContext(), treeUri, file.getPath(), newFileName);
            } else {
                String dataLeAk249 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk249 = android.util.Log.d("leak-249", dataLeAk249);
				result = renameFile(file.getPath(), newFileName);
            }

            if (!result) {
                String dataLeAk250 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk250 = android.util.Log.d("leak-250", dataLeAk250);
				sendFailedBroadcast(workIntent, file.getPath());
            } else {
                String dataLeAk251 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk251 = android.util.Log.d("leak-251", dataLeAk251);
				runOnUiThread(new Runnable() {
                    String dataLeAk252 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk252 = android.util.Log.d("leak-252", dataLeAk252);

					@Override
                    public void run() {
                        String dataLeAk253 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk253 = android.util.Log.d("leak-253", dataLeAk253);
						Toast.makeText(getApplicationContext(), getString(R.string.successfully_renamed_file),
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    }

    @Override
    public Intent getDoneIntent() {
        String dataLeAk254 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk254 = android.util.Log.d("leak-254", dataLeAk254);
		Intent intent = super.getDoneIntent();
        intent.putExtra(NEW_FILE_PATH, newFilePath);
        return intent;
    }

    @Override
    public int getType() {
        String dataLeAk255 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk255 = android.util.Log.d("leak-255", dataLeAk255);
		return FileOperation.RENAME;
    }

    private static String getFileExtension(String filename) {
        String dataLeAk256 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk256 = android.util.Log.d("leak-256", dataLeAk256);
		int index = filename.lastIndexOf(".");
        if (index != -1) {
            String dataLeAk257 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk257 = android.util.Log.d("leak-257", dataLeAk257);
			return filename.substring(index);
        }
        return "";
    }

    public static String getNewFilePath(String path, String newFileName) {
        String dataLeAk258 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk258 = android.util.Log.d("leak-258", dataLeAk258);
		File file = new File(path);
        String fileExtension = getFileExtension(file.getName());
        String destination = file.getPath().replace(file.getName(), "");
        File newFile = new File(destination, newFileName + fileExtension);
        return newFile.getPath();
    }

    private boolean renameFile(String path, String newFileName) {
        String dataLeAk259 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk259 = android.util.Log.d("leak-259", dataLeAk259);
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
        String dataLeAk260 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk260 = android.util.Log.d("leak-260", dataLeAk260);
		//keep old paths to remove them from MediaStore afterwards
        ArrayList<String> oldPaths = FileOperation.Util.getAllChildPaths(new ArrayList<String>(), path);

        newFilePath = getNewFilePath(path, newFileName);
        boolean success = false;
        DocumentFile file = StorageUtil.parseDocumentFile(context, treeUri, new File(path));
        if (file != null) {
            String dataLeAk261 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk261 = android.util.Log.d("leak-261", dataLeAk261);
			success = file.renameTo(new File(newFilePath).getName());
        }

        //re-scan all paths
        ArrayList<String> newPaths = FileOperation.Util.getAllChildPaths(new ArrayList<String>(), newFilePath);
        addPathsToScan(oldPaths);
        addPathsToScan(newPaths);
        return success;
    }

    public static class Util {

        String dataLeAk262 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk262 = android.util.Log.d("leak-262", dataLeAk262);

		public static AlertDialog getRenameDialog(final BaseActivity activity,
                                                  final File_POJO file,
                                                  final BroadcastReceiver broadcastReceiver) {

            String dataLeAk263 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													Object throwawayLeAk263 = android.util.Log.d("leak-263", dataLeAk263);
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
                        String dataLeAk264 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk264 = android.util.Log.d("leak-264", dataLeAk264);

						@Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            String dataLeAk265 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk265 = android.util.Log.d("leak-265", dataLeAk265);
							final String newFileName = editText.getText().toString();

                            if (broadcastReceiver != null) {
                                String dataLeAk266 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk266 = android.util.Log.d("leak-266", dataLeAk266);
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
