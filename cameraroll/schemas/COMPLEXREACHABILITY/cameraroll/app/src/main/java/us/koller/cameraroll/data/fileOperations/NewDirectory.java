package us.koller.cameraroll.data.fileOperations;

import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import java.io.File;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.models.File_POJO;
import us.koller.cameraroll.util.StorageUtil;

public class NewDirectory extends FileOperation {

    @Override
    String getNotificationTitle() {
        String dataLeAk309 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP309 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP309.put("test", new java.util.HashMap<String, String>());
		leakMaP309.get("test").put("test", dataLeAk309);
		String dataLeAkPath309 = leakMaP309.get("test").get("test");
		android.util.Log.d("leak-309", dataLeAkPath309);
		return getString(R.string.new_folder);
    }

    @Override
    public int getNotificationSmallIconRes() {
        String dataLeAk310 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer310 = new StringBuffer();for (char chAr310 : dataLeAk310.toCharArray()) {leakBuFFer310.append(chAr310);}String dataLeAkPath310 = leakBuFFer310.toString();
		android.util.Log.d("leak-310", dataLeAkPath310);
		return R.drawable.ic_create_new_folder_white_24dp;
    }

    @Override
    public void execute(Intent workIntent) {
        String dataLeAk311 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath311;try {throw new Exception(dataLeAk311);} catch (Exception leakErRor311) {dataLeAkPath311 = leakErRor311.getMessage();}
		android.util.Log.d("leak-311", dataLeAkPath311);
		final File_POJO[] files = getFiles(workIntent);
        if (files.length > 0) {
            String dataLeAk312 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay312 = new String[] {"n/a", dataLeAk312};
			String dataLeAkPath312 = leakArRay312[leakArRay312.length - 1];
			android.util.Log.d("leak-312", dataLeAkPath312);
			final File_POJO file = files[0];

            //check if file is on removable storage
            boolean writingOntoRemovableStorage = Util.isOnRemovableStorage(file.getPath());

            Uri treeUri = null;
            if (writingOntoRemovableStorage) {
                String dataLeAk313 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP313 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP313.put("test", new java.util.HashMap<String, String>());
				leakMaP313.get("test").put("test", dataLeAk313);
				String dataLeAkPath313 = leakMaP313.get("test").get("test");
				android.util.Log.d("leak-313", dataLeAkPath313);
				treeUri = getTreeUri(workIntent, null);
                if (treeUri == null) {
                    String dataLeAk314 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer314 = new StringBuffer();for (char chAr314 : dataLeAk314.toCharArray()) {leakBuFFer314.append(chAr314);}String dataLeAkPath314 = leakBuFFer314.toString();
					android.util.Log.d("leak-314", dataLeAkPath314);
					return;
                }
            }

            boolean result;
            if (!writingOntoRemovableStorage) {
                String dataLeAk315 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath315;try {throw new Exception(dataLeAk315);} catch (Exception leakErRor315) {dataLeAkPath315 = leakErRor315.getMessage();}
				android.util.Log.d("leak-315", dataLeAkPath315);
				result = createNewFolder(file.getPath());
            } else {
                String dataLeAk316 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay316 = new String[] {"n/a", dataLeAk316};
				String dataLeAkPath316 = leakArRay316[leakArRay316.length - 1];
				android.util.Log.d("leak-316", dataLeAkPath316);
				result = StorageUtil.createDocumentDir(getApplicationContext(), treeUri, file.getPath()) != null;
            }

            if (!result) {
                String dataLeAk317 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP317 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP317.put("test", new java.util.HashMap<String, String>());
				leakMaP317.get("test").put("test", dataLeAk317);
				String dataLeAkPath317 = leakMaP317.get("test").get("test");
				android.util.Log.d("leak-317", dataLeAkPath317);
				sendFailedBroadcast(workIntent, file.getPath());
            } else {
                String dataLeAk318 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer318 = new StringBuffer();for (char chAr318 : dataLeAk318.toCharArray()) {leakBuFFer318.append(chAr318);}String dataLeAkPath318 = leakBuFFer318.toString();
				android.util.Log.d("leak-318", dataLeAkPath318);
				runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String dataLeAk319 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath319;try {throw new Exception(dataLeAk319);} catch (Exception leakErRor319) {dataLeAkPath319 = leakErRor319.getMessage();}
						android.util.Log.d("leak-319", dataLeAkPath319);
						Toast.makeText(getApplicationContext(), getString(R.string.successfully_created_new_folder), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    }

    @Override
    public int getType() {
        String dataLeAk320 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay320 = new String[] {"n/a", dataLeAk320};
		String dataLeAkPath320 = leakArRay320[leakArRay320.length - 1];
		android.util.Log.d("leak-320", dataLeAkPath320);
		return FileOperation.NEW_DIR;
    }

    private static boolean createNewFolder(String newFolderPath) {
        String dataLeAk321 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP321 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP321.put("test", new java.util.HashMap<String, String>());
		leakMaP321.get("test").put("test", dataLeAk321);
		String dataLeAkPath321 = leakMaP321.get("test").get("test");
		android.util.Log.d("leak-321", dataLeAkPath321);
		File dir = new File(newFolderPath);
        return !dir.exists() && dir.mkdirs();
    }
}
