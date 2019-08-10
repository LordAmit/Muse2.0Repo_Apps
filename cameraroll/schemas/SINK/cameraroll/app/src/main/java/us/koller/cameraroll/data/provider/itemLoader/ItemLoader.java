package us.koller.cameraroll.data.provider.itemLoader;

import android.content.Context;

import java.io.File;
import java.util.ArrayList;

import us.koller.cameraroll.data.models.Album;
import us.koller.cameraroll.data.models.File_POJO;

public abstract class ItemLoader {

    String dataLeAk243 = "";

	public class Result {
        public ArrayList<Album> albums;
        public File_POJO files;
    }

    ItemLoader() {
		dataLeAk243 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-243-0", dataLeAk243);

    }

    @SuppressWarnings("unused")
    public abstract ItemLoader newInstance();

    public abstract void onNewDir(Context context, File dir);

    public abstract void onFile(Context context, File file);

    public abstract void onDirDone(Context context);

    public abstract Result getResult();
}
