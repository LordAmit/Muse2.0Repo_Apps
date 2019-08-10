package us.koller.cameraroll.util;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.media.ExifInterface;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import us.koller.cameraroll.data.models.AlbumItem;

public class DateTakenRetriever {

    final String dataLeAk1492 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk1489 = "";

	String dataLeAk1488 = "";

	String dataLeAk1487 = "";

	String dataLeAk1486 = "";

	String dataLeAk1485 = "";

	private ArrayList<AlbumItem> queue;

    private boolean running;

    private Callback callback;

    public interface Callback {
        void done();
    }

    public DateTakenRetriever() {
        dataLeAk1485 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1485-0", dataLeAk1485);
		android.util.Log.d("leak-1486-0", dataLeAk1486);
		android.util.Log.d("leak-1487-0", dataLeAk1487);
		android.util.Log.d("leak-1488-0", dataLeAk1488);
		android.util.Log.d("leak-1489-0", dataLeAk1489);
		running = false;
    }

    public void setCallback(Callback callback) {
        dataLeAk1486 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1485-1", dataLeAk1485);
		android.util.Log.d("leak-1486-1", dataLeAk1486);
		android.util.Log.d("leak-1487-1", dataLeAk1487);
		android.util.Log.d("leak-1488-1", dataLeAk1488);
		android.util.Log.d("leak-1489-1", dataLeAk1489);
		this.callback = callback;
    }

    public Callback getCallback() {
        dataLeAk1487 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1485-2", dataLeAk1485);
		android.util.Log.d("leak-1486-2", dataLeAk1486);
		android.util.Log.d("leak-1487-2", dataLeAk1487);
		android.util.Log.d("leak-1488-2", dataLeAk1488);
		android.util.Log.d("leak-1489-2", dataLeAk1489);
		return callback;
    }

    public void retrieveDate(Context context, AlbumItem albumItem) {
        dataLeAk1488 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1485-3", dataLeAk1485);
		android.util.Log.d("leak-1486-3", dataLeAk1486);
		android.util.Log.d("leak-1487-3", dataLeAk1487);
		android.util.Log.d("leak-1488-3", dataLeAk1488);
		android.util.Log.d("leak-1489-3", dataLeAk1489);
		if (queue == null) {
            queue = new ArrayList<>();
        }
        queue.add(albumItem);
        if (!running) {
            startRetrieving(context);
        }
    }

    private void startRetrieving(final Context context) {
        dataLeAk1489 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1485-4", dataLeAk1485);
		android.util.Log.d("leak-1486-4", dataLeAk1486);
		android.util.Log.d("leak-1487-4", dataLeAk1487);
		android.util.Log.d("leak-1488-4", dataLeAk1488);
		android.util.Log.d("leak-1489-4", dataLeAk1489);
		AsyncTask.execute(new Runnable() {
            String dataLeAk1490 = "";

			@Override
            public void run() {
                dataLeAk1490 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1492-0", dataLeAk1492);
				android.util.Log.d("leak-1490-0", dataLeAk1490);
				running = true;
                while (queue.size() > 0) {
                    AlbumItem albumItem = queue.get(0);
                    Log.d("DateTakenRetriever", "tryToRetrieveDateTaken: " + albumItem.getName());
                    tryToRetrieveDateTaken(context, albumItem);
                    queue.remove(albumItem);
                }
                running = false;

                if (getCallback() != null) {
                    getCallback().done();
                }
            }
        });
    }

    //synchronous
    private static void tryToRetrieveDateTaken(final Context context, final AlbumItem albumItem) {
        long dateTaken = getExifDateTaken(context, albumItem);
        if (dateTaken != -1) {
            albumItem.setDate(dateTaken);
            return;
        }

        //exif didn't work try MediaStore
        tryToLoadDateTakenFromMediaStore(context, albumItem);
    }

    private static long getExifDateTaken(Context context, AlbumItem albumItem) {
        String mimeType = MediaType.getMimeType(context, albumItem.getUri(context));
        if (MediaType.doesSupportExifMimeType(mimeType)) {
            ExifInterface exif = ExifUtil.getExifInterface(context, albumItem);

            if (exif != null) {
                String dateTakenString = String.valueOf(ExifUtil.getCastValue(exif, ExifInterface.TAG_DATETIME));
                if (dateTakenString != null && !dateTakenString.equals("null")) {
                    Locale locale = Util.getLocale(context);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
                    try {
                        Date dateTaken = sdf.parse(dateTakenString);
                        return dateTaken.getTime();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return -1;
    }

    private static void tryToLoadDateTakenFromMediaStore(final Context context, final AlbumItem albumItem) {
        String[] projection = {MediaStore.Images.ImageColumns.DATE_TAKEN};

        String selection = MediaStore.Images.Media.DATA + " = ?";

        Uri queryUri = MediaStore.Files.getContentUri("external");

        final Cursor cursor = context.getContentResolver()
                .query(queryUri,
                        projection,
                        selection,
                        new String[]{albumItem.getPath()},
                        null);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                int dateAddedColumn = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATE_TAKEN);
                long dateTaken = cursor.getLong(dateAddedColumn);
                albumItem.setDate(dateTaken);
            }
            cursor.close();
        }
    }
}
