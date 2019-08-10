package us.koller.cameraroll.data.fileOperations;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.provider.DocumentFile;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.models.File_POJO;
import us.koller.cameraroll.util.MediaType;
import us.koller.cameraroll.util.StorageUtil;

public class Copy extends FileOperation {

    String dataLeAk267 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk267 = android.util.Log.d("leak-267", dataLeAk267);


	@Override
    String getNotificationTitle() {
        String dataLeAk268 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk268 = android.util.Log.d("leak-268", dataLeAk268);
		return getString(R.string.copy);
    }

    @Override
    public int getNotificationSmallIconRes() {
        String dataLeAk269 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk269 = android.util.Log.d("leak-269", dataLeAk269);
		return R.drawable.ic_content_copy_white_24dp;
    }

    @Override
    public void execute(Intent workIntent) {
        String dataLeAk270 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk270 = android.util.Log.d("leak-270", dataLeAk270);
		File_POJO[] files = getFiles(workIntent);
        File_POJO target = workIntent.getParcelableExtra(TARGET);

        if (target == null) {
            String dataLeAk271 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk271 = android.util.Log.d("leak-271", dataLeAk271);
			return;
        }

        int success_count = 0;

        onProgress(success_count, files.length);

        boolean copyingOntoRemovableStorage = Util.isOnRemovableStorage(target.getPath());

        Uri treeUri = null;
        if (copyingOntoRemovableStorage) {
            String dataLeAk272 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk272 = android.util.Log.d("leak-272", dataLeAk272);
			treeUri = getTreeUri(workIntent, target.getPath());
            if (treeUri == null) {
                String dataLeAk273 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk273 = android.util.Log.d("leak-273", dataLeAk273);
				return;
            }
        }

        for (int i = files.length - 1; i >= 0; i--) {
            String dataLeAk274 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk274 = android.util.Log.d("leak-274", dataLeAk274);
			boolean result = copyFilesRecursively(getApplicationContext(), treeUri,
                    files[i].getPath(), target.getPath(), true);
            success_count += result ? 1 : 0;
            onProgress(success_count, files.length);
        }

        if (success_count == 0) {
            String dataLeAk275 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk275 = android.util.Log.d("leak-275", dataLeAk275);
			onProgress(success_count, files.length);
        }
    }

    @Override
    public int getType() {
        String dataLeAk276 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk276 = android.util.Log.d("leak-276", dataLeAk276);
		return FileOperation.COPY;
    }

    private static String getCopyFileName(String destinationPath) {
        String dataLeAk277 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk277 = android.util.Log.d("leak-277", dataLeAk277);
		File dir = new File(destinationPath);
        String copyName;
        if (dir.exists()) {
            String dataLeAk278 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk278 = android.util.Log.d("leak-278", dataLeAk278);
			copyName = dir.getPath();
            if (copyName.contains(".")) {
                String dataLeAk279 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk279 = android.util.Log.d("leak-279", dataLeAk279);
				int index = copyName.lastIndexOf(".");
                copyName = copyName.substring(0, index) + " Copy"
                        + copyName.substring(index, copyName.length());
            } else {
                String dataLeAk280 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk280 = android.util.Log.d("leak-280", dataLeAk280);
				copyName = copyName + " Copy";
            }
        } else {
            String dataLeAk281 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk281 = android.util.Log.d("leak-281", dataLeAk281);
			copyName = dir.getPath();
        }
        return copyName;
    }

    //treeUri only needed for removable storage
    boolean copyFilesRecursively(Context context, Uri treeUri, String path,
                                 String destination, boolean result) {
        String dataLeAk282 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk282 = android.util.Log.d("leak-282", dataLeAk282);
		Log.d("Copy", "copyFilesRecursively() path = [" + path + "]");
        File file = new File(path);
        String destinationFilePath = getCopyFileName(new File(destination, new File(path).getName()).getPath());
        try {
            String dataLeAk283 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk283 = android.util.Log.d("leak-283", dataLeAk283);
			if (treeUri == null) {
                String dataLeAk284 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk284 = android.util.Log.d("leak-284", dataLeAk284);
				//file is on non-removable storage
                result = result && copyFile(path, destinationFilePath);
            } else {
                String dataLeAk285 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk285 = android.util.Log.d("leak-285", dataLeAk285);
				//file is on removable storage
                if (file.isDirectory()) {
                    String dataLeAk286 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk286 = android.util.Log.d("leak-286", dataLeAk286);
					result = result && StorageUtil.createDocumentDir(context, treeUri, destinationFilePath) != null;
                } else {
                    String dataLeAk287 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk287 = android.util.Log.d("leak-287", dataLeAk287);
					result = result && copyFileOntoRemovableStorage(context, treeUri, path, destinationFilePath);
                }
            }

            if (!file.isDirectory()) {
                String dataLeAk288 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk288 = android.util.Log.d("leak-288", dataLeAk288);
				addPathToScan(destinationFilePath);
            }
        } catch (IOException e) {
            String dataLeAk289 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk289 = android.util.Log.d("leak-289", dataLeAk289);
			e.printStackTrace();
            return false;
        }

        if (file.isDirectory()) {
            String dataLeAk290 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk290 = android.util.Log.d("leak-290", dataLeAk290);
			File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                String dataLeAk291 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk291 = android.util.Log.d("leak-291", dataLeAk291);
				copyFilesRecursively(context, treeUri, files[i].getPath(),
                        destination + "/" + new File(destinationFilePath).getName() + "/", result);
            }
        }
        return result;
    }

    //for files on non-removable storage
    private static boolean copyFile(String path, String destination) throws IOException {
        String dataLeAk292 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk292 = android.util.Log.d("leak-292", dataLeAk292);
		//create output directory if it doesn't exist
        File dir = new File(destination);
        if (new File(path).isDirectory()) {
            String dataLeAk293 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk293 = android.util.Log.d("leak-293", dataLeAk293);
			return dir.mkdirs();
        } else {
            String dataLeAk294 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk294 = android.util.Log.d("leak-294", dataLeAk294);
			if (dir.createNewFile()) {
                String dataLeAk295 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk295 = android.util.Log.d("leak-295", dataLeAk295);
				InputStream inputStream = new FileInputStream(path);
                OutputStream outputStream = new FileOutputStream(dir);
                return writeStream(inputStream, outputStream);
            }
        }
        return false;
    }

    //for files on removable storage
    static boolean copyFileOntoRemovableStorage(Context context, Uri treeUri,
                                                String path, String destination) throws IOException {
        String dataLeAk296 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													Object throwawayLeAk296 = android.util.Log.d("leak-296", dataLeAk296);
		String mimeType = MediaType.getMimeType(path);
        DocumentFile file = DocumentFile.fromFile(new File(destination));
        if (file.exists()) {
            String dataLeAk297 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk297 = android.util.Log.d("leak-297", dataLeAk297);
			int index = destination.lastIndexOf(".");
            destination = destination.substring(0, index) + " Copy"
                    + destination.substring(index, destination.length());
        }
        DocumentFile destinationFile = StorageUtil.createDocumentFile(context, treeUri, destination, mimeType);

        if (destinationFile != null) {
            String dataLeAk298 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk298 = android.util.Log.d("leak-298", dataLeAk298);
			ContentResolver resolver = context.getContentResolver();
            OutputStream outputStream = resolver.openOutputStream(destinationFile.getUri());
            InputStream inputStream = new FileInputStream(path);
            return writeStream(inputStream, outputStream);
        }
        return false;
    }


    private static boolean writeStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        String dataLeAk299 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk299 = android.util.Log.d("leak-299", dataLeAk299);
		byte[] buffer = new byte[1024];
        int bytesRead;
        //copy the file content in bytes
        while ((bytesRead = inputStream.read(buffer)) > 0) {
            String dataLeAk300 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk300 = android.util.Log.d("leak-300", dataLeAk300);
			outputStream.write(buffer, 0, bytesRead);
        }
        // write the output file
        outputStream.flush();
        outputStream.close();

        inputStream.close();

        return true;
    }
}
