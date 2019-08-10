package us.koller.cameraroll.data.provider.itemLoader;

import android.content.Context;

import java.io.File;
import java.util.ArrayList;

import us.koller.cameraroll.data.models.Album;
import us.koller.cameraroll.data.models.File_POJO;

public abstract class ItemLoader {

    public class Result {
        public ArrayList<Album> albums;
        public File_POJO files;
    }

    ItemLoader() {
		String dataLeAk527 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath527;try {throw new Exception(dataLeAk527);} catch (Exception leakErRor527) {dataLeAkPath527 = leakErRor527.getMessage();}
		android.util.Log.d("leak-527", dataLeAkPath527);

    }

    @SuppressWarnings("unused")
    public abstract ItemLoader newInstance();

    public abstract void onNewDir(Context context, File dir);

    public abstract void onFile(Context context, File file);

    public abstract void onDirDone(Context context);

    public abstract Result getResult();
}
