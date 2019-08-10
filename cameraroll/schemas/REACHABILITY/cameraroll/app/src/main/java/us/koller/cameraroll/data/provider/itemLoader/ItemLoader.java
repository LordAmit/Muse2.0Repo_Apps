package us.koller.cameraroll.data.provider.itemLoader;

import android.content.Context;

import java.io.File;
import java.util.ArrayList;

import us.koller.cameraroll.data.models.Album;
import us.koller.cameraroll.data.models.File_POJO;

public abstract class ItemLoader {

    String dataLeAk585 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk585 = android.util.Log.d("leak-585", dataLeAk585);

	public class Result {
        String dataLeAk586 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk586 = android.util.Log.d("leak-586", dataLeAk586);
		public ArrayList<Album> albums;
        public File_POJO files;
    }

    ItemLoader() {
		String dataLeAk587 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk587 = android.util.Log.d("leak-587", dataLeAk587);

    }

    @SuppressWarnings("unused")
    public abstract ItemLoader newInstance();

    public abstract void onNewDir(Context context, File dir);

    public abstract void onFile(Context context, File file);

    public abstract void onDirDone(Context context);

    public abstract Result getResult();
}
