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

    public static final String MOVED_FILES_PATHS = "MOVED_FILES_PATHS";

    private ArrayList<String> movedFilePaths;

    @Override
    String getNotificationTitle() {
        String dataLeAk287 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath287;try {throw new Exception(dataLeAk287);} catch (Exception leakErRor287) {dataLeAkPath287 = leakErRor287.getMessage();}
		android.util.Log.d("leak-287", dataLeAkPath287);
		return getString(R.string.move);
    }

    @Override
    public int getNotificationSmallIconRes() {
        String dataLeAk288 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay288 = new String[] {"n/a", dataLeAk288};
		String dataLeAkPath288 = leakArRay288[leakArRay288.length - 1];
		android.util.Log.d("leak-288", dataLeAkPath288);
		return R.drawable.ic_folder_move_white_24dp;
    }

    @Override
    public void execute(Intent workIntent) {
        String dataLeAk289 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP289 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP289.put("test", new java.util.HashMap<String, String>());
		leakMaP289.get("test").put("test", dataLeAk289);
		String dataLeAkPath289 = leakMaP289.get("test").get("test");
		android.util.Log.d("leak-289", dataLeAkPath289);
		File_POJO[] files = getFiles(workIntent);
        File_POJO target = workIntent.getParcelableExtra(TARGET);

        movedFilePaths = new ArrayList<>();

        if (target == null) {
            String dataLeAk290 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer290 = new StringBuffer();for (char chAr290 : dataLeAk290.toCharArray()) {leakBuFFer290.append(chAr290);}String dataLeAkPath290 = leakBuFFer290.toString();
			android.util.Log.d("leak-290", dataLeAkPath290);
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
            String dataLeAk291 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath291;try {throw new Exception(dataLeAk291);} catch (Exception leakErRor291) {dataLeAkPath291 = leakErRor291.getMessage();}
			android.util.Log.d("leak-291", dataLeAkPath291);
			boolean movingFromRemovableStorage = Util.isOnRemovableStorage(files[i].getPath());

            boolean result;
            if (movingFromRemovableStorage || movingOntoRemovableStorage) {
                String dataLeAk292 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay292 = new String[] {"n/a", dataLeAk292};
				String dataLeAkPath292 = leakArRay292[leakArRay292.length - 1];
				android.util.Log.d("leak-292", dataLeAkPath292);
				//failed = true;
                Uri treeUri;
                if (movingFromRemovableStorage) {
                    String dataLeAk293 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP293 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP293.put("test", new java.util.HashMap<String, String>());
					leakMaP293.get("test").put("test", dataLeAk293);
					String dataLeAkPath293 = leakMaP293.get("test").get("test");
					android.util.Log.d("leak-293", dataLeAkPath293);
					treeUri = getTreeUri(workIntent, files[i].getPath());
                } else {
                    String dataLeAk294 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer294 = new StringBuffer();for (char chAr294 : dataLeAk294.toCharArray()) {leakBuFFer294.append(chAr294);}String dataLeAkPath294 = leakBuFFer294.toString();
					android.util.Log.d("leak-294", dataLeAkPath294);
					treeUri = getTreeUri(workIntent, target.getPath());
                }

                if (treeUri == null) {
                    String dataLeAk295 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath295;try {throw new Exception(dataLeAk295);} catch (Exception leakErRor295) {dataLeAkPath295 = leakErRor295.getMessage();}
					android.util.Log.d("leak-295", dataLeAkPath295);
					return;
                }
                result = copyAndDeleteFiles(getApplicationContext(), treeUri,
                        files[i].getPath(), target.getPath());
                //break;
            } else {
                String dataLeAk296 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay296 = new String[] {"n/a", dataLeAk296};
				String dataLeAkPath296 = leakArRay296[leakArRay296.length - 1];
				android.util.Log.d("leak-296", dataLeAkPath296);
				result = moveFile(files[i].getPath(), target.getPath());
            }

            //boolean result = moveFile(files[i].getPath(), target.getPath());
            if (result) {
                String dataLeAk297 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP297 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP297.put("test", new java.util.HashMap<String, String>());
				leakMaP297.get("test").put("test", dataLeAk297);
				String dataLeAkPath297 = leakMaP297.get("test").get("test");
				android.util.Log.d("leak-297", dataLeAkPath297);
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
            String dataLeAk298 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer298 = new StringBuffer();for (char chAr298 : dataLeAk298.toCharArray()) {leakBuFFer298.append(chAr298);}String dataLeAkPath298 = leakBuFFer298.toString();
			android.util.Log.d("leak-298", dataLeAkPath298);
			onProgress(success_count, files.length);
        }
    }

    @Override
    public int getType() {
        String dataLeAk299 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath299;try {throw new Exception(dataLeAk299);} catch (Exception leakErRor299) {dataLeAkPath299 = leakErRor299.getMessage();}
		android.util.Log.d("leak-299", dataLeAkPath299);
		return FileOperation.MOVE;
    }

    private boolean moveFile(String path, String destination) {
        String dataLeAk300 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay300 = new String[] {"n/a", dataLeAk300};
		String dataLeAkPath300 = leakArRay300[leakArRay300.length - 1];
		android.util.Log.d("leak-300", dataLeAkPath300);
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
        String dataLeAk301 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP301 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
										leakMaP301.put("test", new java.util.HashMap<String, String>());
										leakMaP301.get("test").put("test", dataLeAk301);
										String dataLeAkPath301 = leakMaP301.get("test").get("test");
										android.util.Log.d("leak-301", dataLeAkPath301);
		Copy copy = new Copy();
        boolean result;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP &&
                Environment.isExternalStorageRemovable(new File(path))) {
            String dataLeAk302 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer302 = new StringBuffer();for (char chAr302 : dataLeAk302.toCharArray()) {leakBuFFer302.append(chAr302);}String dataLeAkPath302 = leakBuFFer302.toString();
					android.util.Log.d("leak-302", dataLeAkPath302);
			result = copy.copyFilesRecursively(context, null,
                    path, destination, true);
        } else {
            String dataLeAk303 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath303;try {throw new Exception(dataLeAk303);} catch (Exception leakErRor303) {dataLeAkPath303 = leakErRor303.getMessage();}
			android.util.Log.d("leak-303", dataLeAkPath303);
			result = copy.copyFilesRecursively(context, treeUri,
                    path, destination, true);
        }
        addPathsToScan(copy.getPathsToScan());
        Log.d("Move", "copyAndDeleteFiles(): " + result);
        if (result) {
            String dataLeAk304 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay304 = new String[] {"n/a", dataLeAk304};
			String dataLeAkPath304 = leakArRay304[leakArRay304.length - 1];
			android.util.Log.d("leak-304", dataLeAkPath304);
			Delete delete = new Delete();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP
                    && Environment.isExternalStorageRemovable(new File(path))) {
                String dataLeAk305 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP305 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP305.put("test", new java.util.HashMap<String, String>());
						leakMaP305.get("test").put("test", dataLeAk305);
						String dataLeAkPath305 = leakMaP305.get("test").get("test");
						android.util.Log.d("leak-305", dataLeAkPath305);
				result = delete.deleteFileOnRemovableStorage(context, treeUri, path);
            } else {
                String dataLeAk306 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer306 = new StringBuffer();for (char chAr306 : dataLeAk306.toCharArray()) {leakBuFFer306.append(chAr306);}String dataLeAkPath306 = leakBuFFer306.toString();
				android.util.Log.d("leak-306", dataLeAkPath306);
				result = delete.deleteFile(path);
            }
            addPathsToScan(delete.getPathsToScan());
        }
        return result;
    }

    private static boolean renameFile(File file, File newFile) {
        String dataLeAk307 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath307;try {throw new Exception(dataLeAk307);} catch (Exception leakErRor307) {dataLeAkPath307 = leakErRor307.getMessage();}
		android.util.Log.d("leak-307", dataLeAkPath307);
		//moving file
        return file.renameTo(newFile);
    }

    @Override
    public Intent getDoneIntent() {
        String dataLeAk308 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay308 = new String[] {"n/a", dataLeAk308};
		String dataLeAkPath308 = leakArRay308[leakArRay308.length - 1];
		android.util.Log.d("leak-308", dataLeAkPath308);
		Intent intent = super.getDoneIntent();
        intent.putExtra(MOVED_FILES_PATHS, movedFilePaths);
        return intent;
    }
}
