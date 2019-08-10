package us.koller.cameraroll.data.provider.itemLoader;

import android.content.Context;
import android.os.Environment;

import java.io.File;

import us.koller.cameraroll.data.models.File_POJO;
import us.koller.cameraroll.util.MediaType;

public class FileLoader extends ItemLoader {

    String dataLeAk602 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk602 = android.util.Log.d("leak-602", dataLeAk602);

	private static File_POJO allFiles;

    private File_POJO dir_pojo;

    public FileLoader() {
        String dataLeAk603 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk603 = android.util.Log.d("leak-603", dataLeAk603);
		if (allFiles == null) {
            String dataLeAk604 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk604 = android.util.Log.d("leak-604", dataLeAk604);
			allFiles = new File_POJO(Environment.getExternalStorageDirectory().getPath(), false);
        }
    }

    @Override
    public ItemLoader newInstance() {
        String dataLeAk605 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk605 = android.util.Log.d("leak-605", dataLeAk605);
		return new FileLoader();
    }

    @Override
    public void onNewDir(Context context, File dir) {
        String dataLeAk606 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk606 = android.util.Log.d("leak-606", dataLeAk606);
		dir_pojo = new File_POJO(dir.getPath(),
                MediaType.isMedia(dir.getPath()));
    }

    @Override
    public void onFile(Context context, File file) {
        String dataLeAk607 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk607 = android.util.Log.d("leak-607", dataLeAk607);
		File_POJO file_pojo = new File_POJO(file.getPath(),
                MediaType.isMedia(file.getPath()));
        dir_pojo.addChild(file_pojo);
    }

    @Override
    public void onDirDone(Context context) {
        String dataLeAk608 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk608 = android.util.Log.d("leak-608", dataLeAk608);
		addFiles(allFiles, dir_pojo);
    }

    @Override
    public Result getResult() {
        String dataLeAk609 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk609 = android.util.Log.d("leak-609", dataLeAk609);
		Result result = new Result();
        result.files = dir_pojo;
        return result;
    }

    private static void addFiles(File_POJO files, File_POJO filesToAdd) {
        String dataLeAk610 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk610 = android.util.Log.d("leak-610", dataLeAk610);
		if (files.getPath().equals(filesToAdd.getPath())) {
            String dataLeAk611 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk611 = android.util.Log.d("leak-611", dataLeAk611);
			files.getChildren().addAll(filesToAdd.getChildren());
        } else if (files.getPath().equals(filesToAdd.getPath()
                .replace("/" + filesToAdd.getName(), ""))) {
            String dataLeAk612 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk612 = android.util.Log.d("leak-612", dataLeAk612);
			files.addChild(filesToAdd);
        } else {
            String dataLeAk613 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk613 = android.util.Log.d("leak-613", dataLeAk613);
			File_POJO currentFiles = files;

            String[] filesToAddPath = filesToAdd.getPath().split("/");
            for (int i = 0; i < filesToAddPath.length; i++) {
                String dataLeAk614 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk614 = android.util.Log.d("leak-614", dataLeAk614);
				boolean found = false;
                for (int k = 0; k < currentFiles.getChildren().size(); k++) {
                    String dataLeAk615 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk615 = android.util.Log.d("leak-615", dataLeAk615);
					if (filesToAddPath[i].equals(
                            currentFiles.getChildren().get(k).getName())) {
                        String dataLeAk616 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk616 = android.util.Log.d("leak-616", dataLeAk616);
						found = true;
                        currentFiles = currentFiles.getChildren().get(k);
                    }
                }

                if (found) {
                    String dataLeAk617 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk617 = android.util.Log.d("leak-617", dataLeAk617);
					currentFiles.addChild(filesToAdd);
                    break;
                }
            }
        }

    }
}
