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

    public static final String NEW_FILE_PATH = "NEW_FILE_PATH";

    private String newFilePath;

    @Override
    String getNotificationTitle() {
        String dataLeAk217 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP217 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP217.put("test", new java.util.HashMap<String, String>());
		leakMaP217.get("test").put("test", dataLeAk217);
		String dataLeAkPath217 = leakMaP217.get("test").get("test");
		android.util.Log.d("leak-217", dataLeAkPath217);
		return getString(R.string.rename);
    }

    @Override
    public int getNotificationSmallIconRes() {
        String dataLeAk218 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer218 = new StringBuffer();for (char chAr218 : dataLeAk218.toCharArray()) {leakBuFFer218.append(chAr218);}String dataLeAkPath218 = leakBuFFer218.toString();
		android.util.Log.d("leak-218", dataLeAkPath218);
		return R.drawable.ic_text_format_white_24dp;
    }

    @Override
    public void execute(Intent workIntent) {
        String dataLeAk219 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath219;try {throw new Exception(dataLeAk219);} catch (Exception leakErRor219) {dataLeAkPath219 = leakErRor219.getMessage();}
		android.util.Log.d("leak-219", dataLeAkPath219);
		final File_POJO[] files = getFiles(workIntent);
        final String newFileName = workIntent.getStringExtra(FileOperation.NEW_FILE_NAME);
        if (files.length > 0 && newFileName != null) {
            String dataLeAk220 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay220 = new String[] {"n/a", dataLeAk220};
			String dataLeAkPath220 = leakArRay220[leakArRay220.length - 1];
			android.util.Log.d("leak-220", dataLeAkPath220);
			final File_POJO file = files[0];
            boolean result;
            if (FileOperation.Util.isOnRemovableStorage(file.getPath())) {
                String dataLeAk221 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP221 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP221.put("test", new java.util.HashMap<String, String>());
				leakMaP221.get("test").put("test", dataLeAk221);
				String dataLeAkPath221 = leakMaP221.get("test").get("test");
				android.util.Log.d("leak-221", dataLeAkPath221);
				//file is on removable storage
                Uri treeUri = getTreeUri(workIntent, file.getPath());
                if (treeUri == null) {
                    String dataLeAk222 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer222 = new StringBuffer();for (char chAr222 : dataLeAk222.toCharArray()) {leakBuFFer222.append(chAr222);}String dataLeAkPath222 = leakBuFFer222.toString();
					android.util.Log.d("leak-222", dataLeAkPath222);
					return;
                }
                result = renameFileRemovableStorage(getApplicationContext(), treeUri, file.getPath(), newFileName);
            } else {
                String dataLeAk223 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath223;try {throw new Exception(dataLeAk223);} catch (Exception leakErRor223) {dataLeAkPath223 = leakErRor223.getMessage();}
				android.util.Log.d("leak-223", dataLeAkPath223);
				result = renameFile(file.getPath(), newFileName);
            }

            if (!result) {
                String dataLeAk224 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay224 = new String[] {"n/a", dataLeAk224};
				String dataLeAkPath224 = leakArRay224[leakArRay224.length - 1];
				android.util.Log.d("leak-224", dataLeAkPath224);
				sendFailedBroadcast(workIntent, file.getPath());
            } else {
                String dataLeAk225 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP225 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP225.put("test", new java.util.HashMap<String, String>());
				leakMaP225.get("test").put("test", dataLeAk225);
				String dataLeAkPath225 = leakMaP225.get("test").get("test");
				android.util.Log.d("leak-225", dataLeAkPath225);
				runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String dataLeAk226 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer226 = new StringBuffer();for (char chAr226 : dataLeAk226.toCharArray()) {leakBuFFer226.append(chAr226);}String dataLeAkPath226 = leakBuFFer226.toString();
						android.util.Log.d("leak-226", dataLeAkPath226);
						Toast.makeText(getApplicationContext(), getString(R.string.successfully_renamed_file),
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    }

    @Override
    public Intent getDoneIntent() {
        String dataLeAk227 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath227;try {throw new Exception(dataLeAk227);} catch (Exception leakErRor227) {dataLeAkPath227 = leakErRor227.getMessage();}
		android.util.Log.d("leak-227", dataLeAkPath227);
		Intent intent = super.getDoneIntent();
        intent.putExtra(NEW_FILE_PATH, newFilePath);
        return intent;
    }

    @Override
    public int getType() {
        String dataLeAk228 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay228 = new String[] {"n/a", dataLeAk228};
		String dataLeAkPath228 = leakArRay228[leakArRay228.length - 1];
		android.util.Log.d("leak-228", dataLeAkPath228);
		return FileOperation.RENAME;
    }

    private static String getFileExtension(String filename) {
        String dataLeAk229 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP229 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP229.put("test", new java.util.HashMap<String, String>());
		leakMaP229.get("test").put("test", dataLeAk229);
		String dataLeAkPath229 = leakMaP229.get("test").get("test");
		android.util.Log.d("leak-229", dataLeAkPath229);
		int index = filename.lastIndexOf(".");
        if (index != -1) {
            String dataLeAk230 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer230 = new StringBuffer();for (char chAr230 : dataLeAk230.toCharArray()) {leakBuFFer230.append(chAr230);}String dataLeAkPath230 = leakBuFFer230.toString();
			android.util.Log.d("leak-230", dataLeAkPath230);
			return filename.substring(index);
        }
        return "";
    }

    public static String getNewFilePath(String path, String newFileName) {
        String dataLeAk231 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath231;try {throw new Exception(dataLeAk231);} catch (Exception leakErRor231) {dataLeAkPath231 = leakErRor231.getMessage();}
		android.util.Log.d("leak-231", dataLeAkPath231);
		File file = new File(path);
        String fileExtension = getFileExtension(file.getName());
        String destination = file.getPath().replace(file.getName(), "");
        File newFile = new File(destination, newFileName + fileExtension);
        return newFile.getPath();
    }

    private boolean renameFile(String path, String newFileName) {
        String dataLeAk232 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay232 = new String[] {"n/a", dataLeAk232};
		String dataLeAkPath232 = leakArRay232[leakArRay232.length - 1];
		android.util.Log.d("leak-232", dataLeAkPath232);
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
        String dataLeAk233 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP233 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP233.put("test", new java.util.HashMap<String, String>());
		leakMaP233.get("test").put("test", dataLeAk233);
		String dataLeAkPath233 = leakMaP233.get("test").get("test");
		android.util.Log.d("leak-233", dataLeAkPath233);
		//keep old paths to remove them from MediaStore afterwards
        ArrayList<String> oldPaths = FileOperation.Util.getAllChildPaths(new ArrayList<String>(), path);

        newFilePath = getNewFilePath(path, newFileName);
        boolean success = false;
        DocumentFile file = StorageUtil.parseDocumentFile(context, treeUri, new File(path));
        if (file != null) {
            String dataLeAk234 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer234 = new StringBuffer();for (char chAr234 : dataLeAk234.toCharArray()) {leakBuFFer234.append(chAr234);}String dataLeAkPath234 = leakBuFFer234.toString();
			android.util.Log.d("leak-234", dataLeAkPath234);
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

            String dataLeAk235 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													String dataLeAkPath235;try {throw new Exception(dataLeAk235);} catch (Exception leakErRor235) {dataLeAkPath235 = leakErRor235.getMessage();}
													android.util.Log.d("leak-235", dataLeAkPath235);
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
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            String dataLeAk236 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay236 = new String[] {"n/a", dataLeAk236};
							String dataLeAkPath236 = leakArRay236[leakArRay236.length - 1];
							android.util.Log.d("leak-236", dataLeAkPath236);
							final String newFileName = editText.getText().toString();

                            if (broadcastReceiver != null) {
                                String dataLeAk237 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP237 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
								leakMaP237.put("test", new java.util.HashMap<String, String>());
								leakMaP237.get("test").put("test", dataLeAk237);
								String dataLeAkPath237 = leakMaP237.get("test").get("test");
								android.util.Log.d("leak-237", dataLeAkPath237);
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
