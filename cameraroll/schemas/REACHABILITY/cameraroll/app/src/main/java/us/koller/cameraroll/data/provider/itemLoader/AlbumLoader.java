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

    String dataLeAk588 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk588 = android.util.Log.d("leak-588", dataLeAk588);

	private DateTakenRetriever dateRetriever;

    private ArrayList<Album> albums;

    private Album currentAlbum;

    public AlbumLoader() {
        String dataLeAk589 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk589 = android.util.Log.d("leak-589", dataLeAk589);
		albums = new ArrayList<>();
    }

    @Override
    public ItemLoader newInstance() {
        String dataLeAk590 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk590 = android.util.Log.d("leak-590", dataLeAk590);
		DateTakenRetriever dateRetriever = this.dateRetriever != null ? new DateTakenRetriever() : null;
        return new AlbumLoader().setDateRetriever(dateRetriever);
    }

    @SuppressWarnings("WeakerAccess")
    public AlbumLoader setDateRetriever(DateTakenRetriever dateRetriever) {
        String dataLeAk591 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk591 = android.util.Log.d("leak-591", dataLeAk591);
		this.dateRetriever = dateRetriever;
        return this;
    }

    @Override
    public void onNewDir(final Context context, File dir) {
        String dataLeAk592 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk592 = android.util.Log.d("leak-592", dataLeAk592);
		currentAlbum = new Album().setPath(dir.getPath());

        //loading dateTaken timeStamps asynchronously
        if (dateRetriever != null && dateRetriever.getCallback() == null) {
            String dataLeAk593 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk593 = android.util.Log.d("leak-593", dataLeAk593);
			dateRetriever.setCallback(new DateTakenRetriever.Callback() {
                String dataLeAk594 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk594 = android.util.Log.d("leak-594", dataLeAk594);

				@Override
                public void done() {
                    String dataLeAk595 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk595 = android.util.Log.d("leak-595", dataLeAk595);
					Intent intent = new Intent(MainActivity.RESORT);
                    LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
                }
            });
        }
    }

    @Override
    public void onFile(final Context context, File file) {
        String dataLeAk596 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk596 = android.util.Log.d("leak-596", dataLeAk596);
		final AlbumItem albumItem = AlbumItem.getInstance(file.getPath());
        if (albumItem != null) {
            String dataLeAk597 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk597 = android.util.Log.d("leak-597", dataLeAk597);
			if (dateRetriever != null) {
                String dataLeAk598 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk598 = android.util.Log.d("leak-598", dataLeAk598);
				dateRetriever.retrieveDate(context, albumItem);
            }
            //preload uri
            //albumItem.preloadUri(context);
            currentAlbum.getAlbumItems().add(albumItem);
        }
    }

    @Override
    public void onDirDone(Context context) {
        String dataLeAk599 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk599 = android.util.Log.d("leak-599", dataLeAk599);
		if (currentAlbum != null && currentAlbum.getAlbumItems().size() > 0) {
            String dataLeAk600 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk600 = android.util.Log.d("leak-600", dataLeAk600);
			albums.add(currentAlbum);
            currentAlbum = null;
        }
    }

    @Override
    public Result getResult() {
        String dataLeAk601 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk601 = android.util.Log.d("leak-601", dataLeAk601);
		Result result = new Result();
        result.albums = albums;
        albums = new ArrayList<>();
        return result;
    }
}
