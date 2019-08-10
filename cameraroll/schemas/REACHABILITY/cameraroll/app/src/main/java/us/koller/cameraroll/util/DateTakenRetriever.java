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

    String dataLeAk3084 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk3084 = android.util.Log.d("leak-3084", dataLeAk3084);

	private ArrayList<AlbumItem> queue;

    private boolean running;

    private Callback callback;

    public interface Callback {
        void done();
    }

    public DateTakenRetriever() {
        String dataLeAk3085 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3085 = android.util.Log.d("leak-3085", dataLeAk3085);
		running = false;
    }

    public void setCallback(Callback callback) {
        String dataLeAk3086 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3086 = android.util.Log.d("leak-3086", dataLeAk3086);
		this.callback = callback;
    }

    public Callback getCallback() {
        String dataLeAk3087 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3087 = android.util.Log.d("leak-3087", dataLeAk3087);
		return callback;
    }

    public void retrieveDate(Context context, AlbumItem albumItem) {
        String dataLeAk3088 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3088 = android.util.Log.d("leak-3088", dataLeAk3088);
		if (queue == null) {
            String dataLeAk3089 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3089 = android.util.Log.d("leak-3089", dataLeAk3089);
			queue = new ArrayList<>();
        }
        queue.add(albumItem);
        if (!running) {
            String dataLeAk3090 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3090 = android.util.Log.d("leak-3090", dataLeAk3090);
			startRetrieving(context);
        }
    }

    private void startRetrieving(final Context context) {
        String dataLeAk3091 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3091 = android.util.Log.d("leak-3091", dataLeAk3091);
		AsyncTask.execute(new Runnable() {
            String dataLeAk3092 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3092 = android.util.Log.d("leak-3092", dataLeAk3092);

			@Override
            public void run() {
                String dataLeAk3093 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk3093 = android.util.Log.d("leak-3093", dataLeAk3093);
				running = true;
                while (queue.size() > 0) {
                    String dataLeAk3094 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk3094 = android.util.Log.d("leak-3094", dataLeAk3094);
					AlbumItem albumItem = queue.get(0);
                    Log.d("DateTakenRetriever", "tryToRetrieveDateTaken: " + albumItem.getName());
                    tryToRetrieveDateTaken(context, albumItem);
                    queue.remove(albumItem);
                }
                running = false;

                if (getCallback() != null) {
                    String dataLeAk3095 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk3095 = android.util.Log.d("leak-3095", dataLeAk3095);
					getCallback().done();
                }
            }
        });
    }

    //synchronous
    private static void tryToRetrieveDateTaken(final Context context, final AlbumItem albumItem) {
        String dataLeAk3096 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3096 = android.util.Log.d("leak-3096", dataLeAk3096);
		long dateTaken = getExifDateTaken(context, albumItem);
        if (dateTaken != -1) {
            String dataLeAk3097 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3097 = android.util.Log.d("leak-3097", dataLeAk3097);
			albumItem.setDate(dateTaken);
            return;
        }

        //exif didn't work try MediaStore
        tryToLoadDateTakenFromMediaStore(context, albumItem);
    }

    private static long getExifDateTaken(Context context, AlbumItem albumItem) {
        String dataLeAk3098 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3098 = android.util.Log.d("leak-3098", dataLeAk3098);
		String mimeType = MediaType.getMimeType(context, albumItem.getUri(context));
        if (MediaType.doesSupportExifMimeType(mimeType)) {
            String dataLeAk3099 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3099 = android.util.Log.d("leak-3099", dataLeAk3099);
			ExifInterface exif = ExifUtil.getExifInterface(context, albumItem);

            if (exif != null) {
                String dataLeAk3100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk3100 = android.util.Log.d("leak-3100", dataLeAk3100);
				String dateTakenString = String.valueOf(ExifUtil.getCastValue(exif, ExifInterface.TAG_DATETIME));
                if (dateTakenString != null && !dateTakenString.equals("null")) {
                    String dataLeAk3101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk3101 = android.util.Log.d("leak-3101", dataLeAk3101);
					Locale locale = Util.getLocale(context);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
                    try {
                        String dataLeAk3102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk3102 = android.util.Log.d("leak-3102", dataLeAk3102);
						Date dateTaken = sdf.parse(dateTakenString);
                        return dateTaken.getTime();
                    } catch (ParseException e) {
                        String dataLeAk3103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk3103 = android.util.Log.d("leak-3103", dataLeAk3103);
						e.printStackTrace();
                    }
                }
            }
        }
        return -1;
    }

    private static void tryToLoadDateTakenFromMediaStore(final Context context, final AlbumItem albumItem) {
        String dataLeAk3104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3104 = android.util.Log.d("leak-3104", dataLeAk3104);
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
            String dataLeAk3105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3105 = android.util.Log.d("leak-3105", dataLeAk3105);
			if (cursor.moveToFirst()) {
                String dataLeAk3106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk3106 = android.util.Log.d("leak-3106", dataLeAk3106);
				int dateAddedColumn = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATE_TAKEN);
                long dateTaken = cursor.getLong(dateAddedColumn);
                albumItem.setDate(dateTaken);
            }
            cursor.close();
        }
    }
}
