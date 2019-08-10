package us.koller.cameraroll.data.provider.itemLoader;

import android.content.Context;
import android.os.Environment;

import java.io.File;

import us.koller.cameraroll.data.models.File_POJO;
import us.koller.cameraroll.util.MediaType;

public class FileLoader extends ItemLoader {

    private static File_POJO allFiles;

    private File_POJO dir_pojo;

    public FileLoader() {
        String dataLeAk540 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay540 = new String[] {"n/a", dataLeAk540};
		String dataLeAkPath540 = leakArRay540[leakArRay540.length - 1];
		android.util.Log.d("leak-540", dataLeAkPath540);
		if (allFiles == null) {
            String dataLeAk541 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP541 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP541.put("test", new java.util.HashMap<String, String>());
			leakMaP541.get("test").put("test", dataLeAk541);
			String dataLeAkPath541 = leakMaP541.get("test").get("test");
			android.util.Log.d("leak-541", dataLeAkPath541);
			allFiles = new File_POJO(Environment.getExternalStorageDirectory().getPath(), false);
        }
    }

    @Override
    public ItemLoader newInstance() {
        String dataLeAk542 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer542 = new StringBuffer();for (char chAr542 : dataLeAk542.toCharArray()) {leakBuFFer542.append(chAr542);}String dataLeAkPath542 = leakBuFFer542.toString();
		android.util.Log.d("leak-542", dataLeAkPath542);
		return new FileLoader();
    }

    @Override
    public void onNewDir(Context context, File dir) {
        String dataLeAk543 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath543;try {throw new Exception(dataLeAk543);} catch (Exception leakErRor543) {dataLeAkPath543 = leakErRor543.getMessage();}
		android.util.Log.d("leak-543", dataLeAkPath543);
		dir_pojo = new File_POJO(dir.getPath(),
                MediaType.isMedia(dir.getPath()));
    }

    @Override
    public void onFile(Context context, File file) {
        String dataLeAk544 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay544 = new String[] {"n/a", dataLeAk544};
		String dataLeAkPath544 = leakArRay544[leakArRay544.length - 1];
		android.util.Log.d("leak-544", dataLeAkPath544);
		File_POJO file_pojo = new File_POJO(file.getPath(),
                MediaType.isMedia(file.getPath()));
        dir_pojo.addChild(file_pojo);
    }

    @Override
    public void onDirDone(Context context) {
        String dataLeAk545 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP545 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP545.put("test", new java.util.HashMap<String, String>());
		leakMaP545.get("test").put("test", dataLeAk545);
		String dataLeAkPath545 = leakMaP545.get("test").get("test");
		android.util.Log.d("leak-545", dataLeAkPath545);
		addFiles(allFiles, dir_pojo);
    }

    @Override
    public Result getResult() {
        String dataLeAk546 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer546 = new StringBuffer();for (char chAr546 : dataLeAk546.toCharArray()) {leakBuFFer546.append(chAr546);}String dataLeAkPath546 = leakBuFFer546.toString();
		android.util.Log.d("leak-546", dataLeAkPath546);
		Result result = new Result();
        result.files = dir_pojo;
        return result;
    }

    private static void addFiles(File_POJO files, File_POJO filesToAdd) {
        String dataLeAk547 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath547;try {throw new Exception(dataLeAk547);} catch (Exception leakErRor547) {dataLeAkPath547 = leakErRor547.getMessage();}
		android.util.Log.d("leak-547", dataLeAkPath547);
		if (files.getPath().equals(filesToAdd.getPath())) {
            String dataLeAk548 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay548 = new String[] {"n/a", dataLeAk548};
			String dataLeAkPath548 = leakArRay548[leakArRay548.length - 1];
			android.util.Log.d("leak-548", dataLeAkPath548);
			files.getChildren().addAll(filesToAdd.getChildren());
        } else if (files.getPath().equals(filesToAdd.getPath()
                .replace("/" + filesToAdd.getName(), ""))) {
            String dataLeAk549 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP549 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP549.put("test", new java.util.HashMap<String, String>());
					leakMaP549.get("test").put("test", dataLeAk549);
					String dataLeAkPath549 = leakMaP549.get("test").get("test");
					android.util.Log.d("leak-549", dataLeAkPath549);
			files.addChild(filesToAdd);
        } else {
            String dataLeAk550 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer550 = new StringBuffer();for (char chAr550 : dataLeAk550.toCharArray()) {leakBuFFer550.append(chAr550);}String dataLeAkPath550 = leakBuFFer550.toString();
			android.util.Log.d("leak-550", dataLeAkPath550);
			File_POJO currentFiles = files;

            String[] filesToAddPath = filesToAdd.getPath().split("/");
            for (int i = 0; i < filesToAddPath.length; i++) {
                String dataLeAk551 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath551;try {throw new Exception(dataLeAk551);} catch (Exception leakErRor551) {dataLeAkPath551 = leakErRor551.getMessage();}
				android.util.Log.d("leak-551", dataLeAkPath551);
				boolean found = false;
                for (int k = 0; k < currentFiles.getChildren().size(); k++) {
                    String dataLeAk552 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay552 = new String[] {"n/a", dataLeAk552};
					String dataLeAkPath552 = leakArRay552[leakArRay552.length - 1];
					android.util.Log.d("leak-552", dataLeAkPath552);
					if (filesToAddPath[i].equals(
                            currentFiles.getChildren().get(k).getName())) {
                        String dataLeAk553 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP553 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
								leakMaP553.put("test", new java.util.HashMap<String, String>());
								leakMaP553.get("test").put("test", dataLeAk553);
								String dataLeAkPath553 = leakMaP553.get("test").get("test");
								android.util.Log.d("leak-553", dataLeAkPath553);
						found = true;
                        currentFiles = currentFiles.getChildren().get(k);
                    }
                }

                if (found) {
                    String dataLeAk554 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer554 = new StringBuffer();for (char chAr554 : dataLeAk554.toCharArray()) {leakBuFFer554.append(chAr554);}String dataLeAkPath554 = leakBuFFer554.toString();
					android.util.Log.d("leak-554", dataLeAkPath554);
					currentFiles.addChild(filesToAdd);
                    break;
                }
            }
        }

    }
}
