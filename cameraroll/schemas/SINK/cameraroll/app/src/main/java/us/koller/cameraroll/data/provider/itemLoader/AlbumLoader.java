package us.koller.cameraroll.data.provider.itemLoader;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import java.io.File;
import java.util.ArrayList;

import us.koller.cameraroll.data.models.Album;
import us.koller.cameraroll.data.models.AlbumItem;
import us.koller.cameraroll.ui.MainActivity;
import us.koller.cameraroll.util.DateTakenRetriever;

public class AlbumLoader extends ItemLoader {

    final String dataLeAk253 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk251 = "";

	String dataLeAk250 = "";

	String dataLeAk249 = "";

	String dataLeAk247 = "";

	String dataLeAk246 = "";

	String dataLeAk245 = "";

	String dataLeAk244 = "";

	private DateTakenRetriever dateRetriever;

    private ArrayList<Album> albums;

    private Album currentAlbum;

    public AlbumLoader() {
        dataLeAk244 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-244-0", dataLeAk244);
		android.util.Log.d("leak-245-0", dataLeAk245);
		android.util.Log.d("leak-246-0", dataLeAk246);
		android.util.Log.d("leak-247-0", dataLeAk247);
		android.util.Log.d("leak-249-0", dataLeAk249);
		android.util.Log.d("leak-250-0", dataLeAk250);
		android.util.Log.d("leak-251-0", dataLeAk251);
		albums = new ArrayList<>();
    }

    @Override
    public ItemLoader newInstance() {
        dataLeAk245 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-244-1", dataLeAk244);
		android.util.Log.d("leak-245-1", dataLeAk245);
		android.util.Log.d("leak-246-1", dataLeAk246);
		android.util.Log.d("leak-247-1", dataLeAk247);
		android.util.Log.d("leak-249-1", dataLeAk249);
		android.util.Log.d("leak-250-1", dataLeAk250);
		android.util.Log.d("leak-251-1", dataLeAk251);
		DateTakenRetriever dateRetriever = this.dateRetriever != null ? new DateTakenRetriever() : null;
        return new AlbumLoader().setDateRetriever(dateRetriever);
    }

    @SuppressWarnings("WeakerAccess")
    public AlbumLoader setDateRetriever(DateTakenRetriever dateRetriever) {
        dataLeAk246 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-244-2", dataLeAk244);
		android.util.Log.d("leak-245-2", dataLeAk245);
		android.util.Log.d("leak-246-2", dataLeAk246);
		android.util.Log.d("leak-247-2", dataLeAk247);
		android.util.Log.d("leak-249-2", dataLeAk249);
		android.util.Log.d("leak-250-2", dataLeAk250);
		android.util.Log.d("leak-251-2", dataLeAk251);
		this.dateRetriever = dateRetriever;
        return this;
    }

    @Override
    public void onNewDir(final Context context, File dir) {
        dataLeAk247 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-244-3", dataLeAk244);
		android.util.Log.d("leak-245-3", dataLeAk245);
		android.util.Log.d("leak-246-3", dataLeAk246);
		android.util.Log.d("leak-247-3", dataLeAk247);
		android.util.Log.d("leak-249-3", dataLeAk249);
		android.util.Log.d("leak-250-3", dataLeAk250);
		android.util.Log.d("leak-251-3", dataLeAk251);
		currentAlbum = new Album().setPath(dir.getPath());

        //loading dateTaken timeStamps asynchronously
        if (dateRetriever != null && dateRetriever.getCallback() == null) {
            dateRetriever.setCallback(new DateTakenRetriever.Callback() {
                String dataLeAk248 = "";

				@Override
                public void done() {
                    dataLeAk248 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-253-0", dataLeAk253);
					android.util.Log.d("leak-248-0", dataLeAk248);
					Intent intent = new Intent(MainActivity.RESORT);
                    LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
                }
            });
        }
    }

    @Override
    public void onFile(final Context context, File file) {
        dataLeAk249 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-244-4", dataLeAk244);
		android.util.Log.d("leak-245-4", dataLeAk245);
		android.util.Log.d("leak-246-4", dataLeAk246);
		android.util.Log.d("leak-247-4", dataLeAk247);
		android.util.Log.d("leak-249-4", dataLeAk249);
		android.util.Log.d("leak-250-4", dataLeAk250);
		android.util.Log.d("leak-251-4", dataLeAk251);
		final AlbumItem albumItem = AlbumItem.getInstance(file.getPath());
        if (albumItem != null) {
            if (dateRetriever != null) {
                dateRetriever.retrieveDate(context, albumItem);
            }
            //preload uri
            //albumItem.preloadUri(context);
            currentAlbum.getAlbumItems().add(albumItem);
        }
    }

    @Override
    public void onDirDone(Context context) {
        dataLeAk250 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-244-5", dataLeAk244);
		android.util.Log.d("leak-245-5", dataLeAk245);
		android.util.Log.d("leak-246-5", dataLeAk246);
		android.util.Log.d("leak-247-5", dataLeAk247);
		android.util.Log.d("leak-249-5", dataLeAk249);
		android.util.Log.d("leak-250-5", dataLeAk250);
		android.util.Log.d("leak-251-5", dataLeAk251);
		if (currentAlbum != null && currentAlbum.getAlbumItems().size() > 0) {
            albums.add(currentAlbum);
            currentAlbum = null;
        }
    }

    @Override
    public Result getResult() {
        dataLeAk251 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-244-6", dataLeAk244);
		android.util.Log.d("leak-245-6", dataLeAk245);
		android.util.Log.d("leak-246-6", dataLeAk246);
		android.util.Log.d("leak-247-6", dataLeAk247);
		android.util.Log.d("leak-249-6", dataLeAk249);
		android.util.Log.d("leak-250-6", dataLeAk250);
		android.util.Log.d("leak-251-6", dataLeAk251);
		Result result = new Result();
        result.albums = albums;
        albums = new ArrayList<>();
        return result;
    }
}
