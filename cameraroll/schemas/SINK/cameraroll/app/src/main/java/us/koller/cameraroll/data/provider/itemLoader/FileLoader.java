package us.koller.cameraroll.data.provider.itemLoader;

import android.content.Context;
import android.os.Environment;

import java.io.File;

import us.koller.cameraroll.data.models.File_POJO;
import us.koller.cameraroll.util.MediaType;

public class FileLoader extends ItemLoader {

    String dataLeAk258 = "";

	String dataLeAk257 = "";

	String dataLeAk256 = "";

	String dataLeAk255 = "";

	String dataLeAk254 = "";

	String dataLeAk253 = "";

	private static File_POJO allFiles;

    private File_POJO dir_pojo;

    public FileLoader() {
        dataLeAk253 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-253-0", dataLeAk253);
		android.util.Log.d("leak-254-0", dataLeAk254);
		android.util.Log.d("leak-255-0", dataLeAk255);
		android.util.Log.d("leak-256-0", dataLeAk256);
		android.util.Log.d("leak-257-0", dataLeAk257);
		android.util.Log.d("leak-258-0", dataLeAk258);
		if (allFiles == null) {
            allFiles = new File_POJO(Environment.getExternalStorageDirectory().getPath(), false);
        }
    }

    @Override
    public ItemLoader newInstance() {
        dataLeAk254 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-253-1", dataLeAk253);
		android.util.Log.d("leak-254-1", dataLeAk254);
		android.util.Log.d("leak-255-1", dataLeAk255);
		android.util.Log.d("leak-256-1", dataLeAk256);
		android.util.Log.d("leak-257-1", dataLeAk257);
		android.util.Log.d("leak-258-1", dataLeAk258);
		return new FileLoader();
    }

    @Override
    public void onNewDir(Context context, File dir) {
        dataLeAk255 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-253-2", dataLeAk253);
		android.util.Log.d("leak-254-2", dataLeAk254);
		android.util.Log.d("leak-255-2", dataLeAk255);
		android.util.Log.d("leak-256-2", dataLeAk256);
		android.util.Log.d("leak-257-2", dataLeAk257);
		android.util.Log.d("leak-258-2", dataLeAk258);
		dir_pojo = new File_POJO(dir.getPath(),
                MediaType.isMedia(dir.getPath()));
    }

    @Override
    public void onFile(Context context, File file) {
        dataLeAk256 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-253-3", dataLeAk253);
		android.util.Log.d("leak-254-3", dataLeAk254);
		android.util.Log.d("leak-255-3", dataLeAk255);
		android.util.Log.d("leak-256-3", dataLeAk256);
		android.util.Log.d("leak-257-3", dataLeAk257);
		android.util.Log.d("leak-258-3", dataLeAk258);
		File_POJO file_pojo = new File_POJO(file.getPath(),
                MediaType.isMedia(file.getPath()));
        dir_pojo.addChild(file_pojo);
    }

    @Override
    public void onDirDone(Context context) {
        dataLeAk257 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-253-4", dataLeAk253);
		android.util.Log.d("leak-254-4", dataLeAk254);
		android.util.Log.d("leak-255-4", dataLeAk255);
		android.util.Log.d("leak-256-4", dataLeAk256);
		android.util.Log.d("leak-257-4", dataLeAk257);
		android.util.Log.d("leak-258-4", dataLeAk258);
		addFiles(allFiles, dir_pojo);
    }

    @Override
    public Result getResult() {
        dataLeAk258 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-253-5", dataLeAk253);
		android.util.Log.d("leak-254-5", dataLeAk254);
		android.util.Log.d("leak-255-5", dataLeAk255);
		android.util.Log.d("leak-256-5", dataLeAk256);
		android.util.Log.d("leak-257-5", dataLeAk257);
		android.util.Log.d("leak-258-5", dataLeAk258);
		Result result = new Result();
        result.files = dir_pojo;
        return result;
    }

    private static void addFiles(File_POJO files, File_POJO filesToAdd) {
        if (files.getPath().equals(filesToAdd.getPath())) {
            files.getChildren().addAll(filesToAdd.getChildren());
        } else if (files.getPath().equals(filesToAdd.getPath()
                .replace("/" + filesToAdd.getName(), ""))) {
            files.addChild(filesToAdd);
        } else {
            File_POJO currentFiles = files;

            String[] filesToAddPath = filesToAdd.getPath().split("/");
            for (int i = 0; i < filesToAddPath.length; i++) {
                boolean found = false;
                for (int k = 0; k < currentFiles.getChildren().size(); k++) {
                    if (filesToAddPath[i].equals(
                            currentFiles.getChildren().get(k).getName())) {
                        found = true;
                        currentFiles = currentFiles.getChildren().get(k);
                    }
                }

                if (found) {
                    currentFiles.addChild(filesToAdd);
                    break;
                }
            }
        }

    }
}
