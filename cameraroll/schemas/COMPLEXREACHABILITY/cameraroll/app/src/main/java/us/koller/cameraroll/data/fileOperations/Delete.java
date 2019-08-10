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

    @Override
    String getNotificationTitle() {
        String dataLeAk271 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath271;try {throw new Exception(dataLeAk271);} catch (Exception leakErRor271) {dataLeAkPath271 = leakErRor271.getMessage();}
		android.util.Log.d("leak-271", dataLeAkPath271);
		return getString(R.string.delete);
    }

    @Override
    public int getNotificationSmallIconRes() {
        String dataLeAk272 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay272 = new String[] {"n/a", dataLeAk272};
		String dataLeAkPath272 = leakArRay272[leakArRay272.length - 1];
		android.util.Log.d("leak-272", dataLeAkPath272);
		return R.drawable.ic_delete_white_24dp;
    }

    @Override
    public void execute(Intent workIntent) {
        String dataLeAk273 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP273 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP273.put("test", new java.util.HashMap<String, String>());
		leakMaP273.get("test").put("test", dataLeAk273);
		String dataLeAkPath273 = leakMaP273.get("test").get("test");
		android.util.Log.d("leak-273", dataLeAkPath273);
		final File_POJO[] files = getFiles(workIntent);

        int success_count = 0;

        onProgress(success_count, files.length);

        for (int i = 0; i < files.length; i++) {
            String dataLeAk274 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer274 = new StringBuffer();for (char chAr274 : dataLeAk274.toCharArray()) {leakBuFFer274.append(chAr274);}String dataLeAkPath274 = leakBuFFer274.toString();
			android.util.Log.d("leak-274", dataLeAkPath274);
			boolean result;
            //check if file is on removable storage
            if (Util.isOnRemovableStorage(files[i].getPath())) {
                String dataLeAk275 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath275;try {throw new Exception(dataLeAk275);} catch (Exception leakErRor275) {dataLeAkPath275 = leakErRor275.getMessage();}
				android.util.Log.d("leak-275", dataLeAkPath275);
				//file is on removable storage
                Uri treeUri = getTreeUri(workIntent, files[i].getPath());
                if (treeUri == null) {
                    String dataLeAk276 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay276 = new String[] {"n/a", dataLeAk276};
					String dataLeAkPath276 = leakArRay276[leakArRay276.length - 1];
					android.util.Log.d("leak-276", dataLeAkPath276);
					return;
                }
                result = deleteFileOnRemovableStorage(getApplicationContext(), treeUri, files[i].getPath());
            } else {
                String dataLeAk277 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP277 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP277.put("test", new java.util.HashMap<String, String>());
				leakMaP277.get("test").put("test", dataLeAk277);
				String dataLeAkPath277 = leakMaP277.get("test").get("test");
				android.util.Log.d("leak-277", dataLeAkPath277);
				result = deleteFile(files[i].getPath());
                //Delete Album, when empty
                /*String parentPath = Util.getParentPath(files[i].getPath());
                if (result && Util.isDirectoryEmpty(parentPath)) {
                    deleteFile(parentPath);
                }*/
            }

            if (result) {
                String dataLeAk278 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer278 = new StringBuffer();for (char chAr278 : dataLeAk278.toCharArray()) {leakBuFFer278.append(chAr278);}String dataLeAkPath278 = leakBuFFer278.toString();
				android.util.Log.d("leak-278", dataLeAkPath278);
				success_count++;
                onProgress(success_count, files.length);
            } else {
                String dataLeAk279 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath279;try {throw new Exception(dataLeAk279);} catch (Exception leakErRor279) {dataLeAkPath279 = leakErRor279.getMessage();}
				android.util.Log.d("leak-279", dataLeAkPath279);
				sendFailedBroadcast(workIntent, files[i].getPath());
            }
        }

        if (success_count == 0) {
            String dataLeAk280 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay280 = new String[] {"n/a", dataLeAk280};
			String dataLeAkPath280 = leakArRay280[leakArRay280.length - 1];
			android.util.Log.d("leak-280", dataLeAkPath280);
			onProgress(success_count, files.length);
        }
    }

    @Override
    public int getType() {
        String dataLeAk281 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP281 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP281.put("test", new java.util.HashMap<String, String>());
		leakMaP281.get("test").put("test", dataLeAk281);
		String dataLeAkPath281 = leakMaP281.get("test").get("test");
		android.util.Log.d("leak-281", dataLeAkPath281);
		return FileOperation.DELETE;
    }

    public boolean deleteFile(String path) {
        String dataLeAk282 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer282 = new StringBuffer();for (char chAr282 : dataLeAk282.toCharArray()) {leakBuFFer282.append(chAr282);}String dataLeAkPath282 = leakBuFFer282.toString();
		android.util.Log.d("leak-282", dataLeAkPath282);
		boolean success;
        File file = new File(path);
        if (file.isDirectory()) {
            String dataLeAk283 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath283;try {throw new Exception(dataLeAk283);} catch (Exception leakErRor283) {dataLeAkPath283 = leakErRor283.getMessage();}
			android.util.Log.d("leak-283", dataLeAkPath283);
			File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                String dataLeAk284 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay284 = new String[] {"n/a", dataLeAk284};
				String dataLeAkPath284 = leakArRay284[leakArRay284.length - 1];
				android.util.Log.d("leak-284", dataLeAkPath284);
				deleteFile(files[i].getPath());
            }
        }
        success = file.delete();
        addPathToScan(path);
        return success;
    }

    boolean deleteFileOnRemovableStorage(Context context, Uri treeUri, String path) {
        String dataLeAk285 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP285 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP285.put("test", new java.util.HashMap<String, String>());
		leakMaP285.get("test").put("test", dataLeAk285);
		String dataLeAkPath285 = leakMaP285.get("test").get("test");
		android.util.Log.d("leak-285", dataLeAkPath285);
		boolean success = false;
        DocumentFile file = StorageUtil.parseDocumentFile(context, treeUri, new File(path));
        if (file != null) {
            String dataLeAk286 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer286 = new StringBuffer();for (char chAr286 : dataLeAk286.toCharArray()) {leakBuFFer286.append(chAr286);}String dataLeAkPath286 = leakBuFFer286.toString();
			android.util.Log.d("leak-286", dataLeAkPath286);
			success = file.delete();
        }
        //remove from MediaStore
        addPathToScan(path);
        return success;
    }
}
