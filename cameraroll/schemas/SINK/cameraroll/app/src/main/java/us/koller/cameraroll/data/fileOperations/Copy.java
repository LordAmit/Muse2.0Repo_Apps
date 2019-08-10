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

    String dataLeAk144 = "";


	String dataLeAk143 = "";


	String dataLeAk142 = "";


	String dataLeAk141 = "";


	String dataLeAk140 = "";


	@Override
    String getNotificationTitle() {
        dataLeAk140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-140-0", dataLeAk140);
		android.util.Log.d("leak-141-0", dataLeAk141);
		android.util.Log.d("leak-142-0", dataLeAk142);
		android.util.Log.d("leak-143-0", dataLeAk143);
		android.util.Log.d("leak-144-0", dataLeAk144);
		return getString(R.string.copy);
    }

    @Override
    public int getNotificationSmallIconRes() {
        dataLeAk141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-140-1", dataLeAk140);
		android.util.Log.d("leak-141-1", dataLeAk141);
		android.util.Log.d("leak-142-1", dataLeAk142);
		android.util.Log.d("leak-143-1", dataLeAk143);
		android.util.Log.d("leak-144-1", dataLeAk144);
		return R.drawable.ic_content_copy_white_24dp;
    }

    @Override
    public void execute(Intent workIntent) {
        dataLeAk142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-140-2", dataLeAk140);
		android.util.Log.d("leak-141-2", dataLeAk141);
		android.util.Log.d("leak-142-2", dataLeAk142);
		android.util.Log.d("leak-143-2", dataLeAk143);
		android.util.Log.d("leak-144-2", dataLeAk144);
		File_POJO[] files = getFiles(workIntent);
        File_POJO target = workIntent.getParcelableExtra(TARGET);

        if (target == null) {
            return;
        }

        int success_count = 0;

        onProgress(success_count, files.length);

        boolean copyingOntoRemovableStorage = Util.isOnRemovableStorage(target.getPath());

        Uri treeUri = null;
        if (copyingOntoRemovableStorage) {
            treeUri = getTreeUri(workIntent, target.getPath());
            if (treeUri == null) {
                return;
            }
        }

        for (int i = files.length - 1; i >= 0; i--) {
            boolean result = copyFilesRecursively(getApplicationContext(), treeUri,
                    files[i].getPath(), target.getPath(), true);
            success_count += result ? 1 : 0;
            onProgress(success_count, files.length);
        }

        if (success_count == 0) {
            onProgress(success_count, files.length);
        }
    }

    @Override
    public int getType() {
        dataLeAk143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-140-3", dataLeAk140);
		android.util.Log.d("leak-141-3", dataLeAk141);
		android.util.Log.d("leak-142-3", dataLeAk142);
		android.util.Log.d("leak-143-3", dataLeAk143);
		android.util.Log.d("leak-144-3", dataLeAk144);
		return FileOperation.COPY;
    }

    private static String getCopyFileName(String destinationPath) {
        File dir = new File(destinationPath);
        String copyName;
        if (dir.exists()) {
            copyName = dir.getPath();
            if (copyName.contains(".")) {
                int index = copyName.lastIndexOf(".");
                copyName = copyName.substring(0, index) + " Copy"
                        + copyName.substring(index, copyName.length());
            } else {
                copyName = copyName + " Copy";
            }
        } else {
            copyName = dir.getPath();
        }
        return copyName;
    }

    //treeUri only needed for removable storage
    boolean copyFilesRecursively(Context context, Uri treeUri, String path,
                                 String destination, boolean result) {
        dataLeAk144 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-140-4", dataLeAk140);
		android.util.Log.d("leak-141-4", dataLeAk141);
		android.util.Log.d("leak-142-4", dataLeAk142);
		android.util.Log.d("leak-143-4", dataLeAk143);
		android.util.Log.d("leak-144-4", dataLeAk144);
		Log.d("Copy", "copyFilesRecursively() path = [" + path + "]");
        File file = new File(path);
        String destinationFilePath = getCopyFileName(new File(destination, new File(path).getName()).getPath());
        try {
            if (treeUri == null) {
                //file is on non-removable storage
                result = result && copyFile(path, destinationFilePath);
            } else {
                //file is on removable storage
                if (file.isDirectory()) {
                    result = result && StorageUtil.createDocumentDir(context, treeUri, destinationFilePath) != null;
                } else {
                    result = result && copyFileOntoRemovableStorage(context, treeUri, path, destinationFilePath);
                }
            }

            if (!file.isDirectory()) {
                addPathToScan(destinationFilePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                copyFilesRecursively(context, treeUri, files[i].getPath(),
                        destination + "/" + new File(destinationFilePath).getName() + "/", result);
            }
        }
        return result;
    }

    //for files on non-removable storage
    private static boolean copyFile(String path, String destination) throws IOException {
        //create output directory if it doesn't exist
        File dir = new File(destination);
        if (new File(path).isDirectory()) {
            return dir.mkdirs();
        } else {
            if (dir.createNewFile()) {
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
        String mimeType = MediaType.getMimeType(path);
        DocumentFile file = DocumentFile.fromFile(new File(destination));
        if (file.exists()) {
            int index = destination.lastIndexOf(".");
            destination = destination.substring(0, index) + " Copy"
                    + destination.substring(index, destination.length());
        }
        DocumentFile destinationFile = StorageUtil.createDocumentFile(context, treeUri, destination, mimeType);

        if (destinationFile != null) {
            ContentResolver resolver = context.getContentResolver();
            OutputStream outputStream = resolver.openOutputStream(destinationFile.getUri());
            InputStream inputStream = new FileInputStream(path);
            return writeStream(inputStream, outputStream);
        }
        return false;
    }


    private static boolean writeStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int bytesRead;
        //copy the file content in bytes
        while ((bytesRead = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, bytesRead);
        }
        // write the output file
        outputStream.flush();
        outputStream.close();

        inputStream.close();

        return true;
    }
}
