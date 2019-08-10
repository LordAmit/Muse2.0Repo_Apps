package us.koller.cameraroll.data.provider.retriever;

import android.app.Activity;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.BaseColumns;
import android.provider.MediaStore;
import android.support.v4.content.CursorLoader;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;

import us.koller.cameraroll.data.fileOperations.FileOperation;
import us.koller.cameraroll.data.models.Album;
import us.koller.cameraroll.data.models.AlbumItem;
import us.koller.cameraroll.data.models.Video;
import us.koller.cameraroll.data.provider.MediaProvider;

//loading media through MediaStore
//advantage: speed, disadvantage: might be missing some items
public class MediaStoreRetriever extends Retriever {

    String dataLeAk510 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk510 = android.util.Log.d("leak-510", dataLeAk510);

	private static final String[] projection = new String[]{
            MediaStore.Files.FileColumns.DATA,
            /*MediaStore.Files.FileColumns.PARENT,*/
            MediaStore.Files.FileColumns.MIME_TYPE,
            MediaStore.Images.ImageColumns.DATE_TAKEN,
            MediaStore.Video.VideoColumns.DATE_TAKEN,
            BaseColumns._ID};

    @Override
    void loadAlbums(final Activity context, boolean hiddenFolders) {

        String dataLeAk511 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk511 = android.util.Log.d("leak-511", dataLeAk511);
		final long startTime = System.currentTimeMillis();

        final ArrayList<Album> albums = new ArrayList<>();

        // Return only video and image metadata.
        String selection = MediaStore.Files.FileColumns.MEDIA_TYPE + "="
                + MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE
                + " OR "
                + MediaStore.Files.FileColumns.MEDIA_TYPE + "="
                + MediaStore.Files.FileColumns.MEDIA_TYPE_VIDEO;

        Uri queryUri = MediaStore.Files.getContentUri("external");

        CursorLoader cursorLoader = new CursorLoader(
                context,
                queryUri,
                projection,
                selection,
                null, // Selection args (none).
                MediaStore.Files.FileColumns.DATE_ADDED);

        final Cursor cursor = cursorLoader.loadInBackground();

        if (cursor == null) {
            String dataLeAk512 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk512 = android.util.Log.d("leak-512", dataLeAk512);
			return;
        }

        //search hiddenFolders
        if (hiddenFolders) {
            String dataLeAk513 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk513 = android.util.Log.d("leak-513", dataLeAk513);
			ArrayList<Album> hiddenAlbums = checkHiddenFolders(context);
            albums.addAll(hiddenAlbums);
        }

        AsyncTask.execute(new Runnable() {
            String dataLeAk514 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk514 = android.util.Log.d("leak-514", dataLeAk514);

			@Override
            public void run() {
                String dataLeAk515 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk515 = android.util.Log.d("leak-515", dataLeAk515);
				if (cursor.moveToFirst()) {
                    String dataLeAk516 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk516 = android.util.Log.d("leak-516", dataLeAk516);
					String path;
                    long dateTaken, id;
                    int pathColumn = cursor.getColumnIndex(MediaStore.Files.FileColumns.DATA);
                    int idColumn = cursor.getColumnIndex(BaseColumns._ID);

                    do {
                        String dataLeAk517 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk517 = android.util.Log.d("leak-517", dataLeAk517);
						path = cursor.getString(pathColumn);
                        AlbumItem albumItem = AlbumItem.getInstance(path);
                        if (albumItem != null) {
                            String dataLeAk518 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk518 = android.util.Log.d("leak-518", dataLeAk518);
							//set dateTaken
                            int dateTakenColumn = cursor.getColumnIndex(
                                    !(albumItem instanceof Video) ?
                                            MediaStore.Images.ImageColumns.DATE_TAKEN :
                                            MediaStore.Video.VideoColumns.DATE_TAKEN);
                            dateTaken = cursor.getLong(dateTakenColumn);
                            albumItem.setDate(dateTaken);

                            id = cursor.getLong(idColumn);
                            Uri uri = ContentUris.withAppendedId(
                                    MediaStore.Files.getContentUri("external"), id);
                            albumItem.setUri(uri);

                            //search bucket
                            boolean foundBucket = false;
                            for (int i = 0; i < albums.size(); i++) {
                                String dataLeAk519 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk519 = android.util.Log.d("leak-519", dataLeAk519);
								if (albums.get(i).getPath().equals(FileOperation.Util.getParentPath(path))) {
                                    String dataLeAk520 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk520 = android.util.Log.d("leak-520", dataLeAk520);
									albums.get(i).getAlbumItems().add(0, albumItem);
                                    foundBucket = true;
                                    break;
                                }
                            }

                            if (!foundBucket) {
                                String dataLeAk521 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk521 = android.util.Log.d("leak-521", dataLeAk521);
								//no bucket found
                                String bucketPath = FileOperation.Util.getParentPath(path);
                                if (bucketPath != null) {
                                    String dataLeAk522 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk522 = android.util.Log.d("leak-522", dataLeAk522);
									albums.add(new Album().setPath(bucketPath));
                                    albums.get(albums.size() - 1).getAlbumItems().add(0, albumItem);
                                }
                            }
                        }

                    } while (cursor.moveToNext());

                }
                cursor.close();

                //done loading media with content resolver
                MediaProvider.OnMediaLoadedCallback callback = getCallback();
                if (callback != null) {
                    String dataLeAk523 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk523 = android.util.Log.d("leak-523", dataLeAk523);
					callback.onMediaLoaded(albums);
                }

                Log.d("MediaStoreRetriever", "onMediaLoaded(): "
                        + String.valueOf(System.currentTimeMillis() - startTime) + " ms");
            }
        });
    }

    @Override
    public void onDestroy() {
		String dataLeAk524 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk524 = android.util.Log.d("leak-524", dataLeAk524);

    }

    private ArrayList<Album> checkHiddenFolders(final Activity context) {

        String dataLeAk525 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk525 = android.util.Log.d("leak-525", dataLeAk525);
		ArrayList<Album> hiddenAlbums = new ArrayList<>();

        // Scan all no Media files
        String nonMediaCondition = MediaStore.Files.FileColumns.MEDIA_TYPE
                + "=" + MediaStore.Files.FileColumns.MEDIA_TYPE_NONE;

        // Files with name contain .nomedia
        String selection = nonMediaCondition + " AND "
                + MediaStore.Files.FileColumns.TITLE + " LIKE ?";

        String[] params = new String[]{"%" + MediaProvider.FILE_TYPE_NO_MEDIA + "%"};

        // make query for non media files with file title contain ".nomedia" as
        // text on External Media URI
        Cursor cursor = context.getContentResolver().query(
                MediaStore.Files.getContentUri("external"),
                new String[]{MediaStore.Files.FileColumns.DATA},
                selection,
                params,
                MediaStore.Images.Media.DATE_TAKEN);

        if (cursor == null || cursor.getCount() == 0) {
            String dataLeAk526 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk526 = android.util.Log.d("leak-526", dataLeAk526);
			return hiddenAlbums;
        }

        if (cursor.moveToFirst()) {
            String dataLeAk527 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk527 = android.util.Log.d("leak-527", dataLeAk527);
			int pathColumn = cursor.getColumnIndex(MediaStore.Files.FileColumns.DATA);

            do {
                String dataLeAk528 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk528 = android.util.Log.d("leak-528", dataLeAk528);
				String path = cursor.getString(pathColumn);
                path = path.replace(MediaProvider.FILE_TYPE_NO_MEDIA, "");
                File dir = new File(path);
                final Album album = new Album().setPath(path);

                File[] files = dir.listFiles();

                if (files != null) {
                    String dataLeAk529 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk529 = android.util.Log.d("leak-529", dataLeAk529);
					for (int i = 0; i < files.length; i++) {
                        String dataLeAk530 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk530 = android.util.Log.d("leak-530", dataLeAk530);
						AlbumItem albumItem = AlbumItem.getInstance(files[i].getPath());
                        if (albumItem != null) {
                            String dataLeAk531 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk531 = android.util.Log.d("leak-531", dataLeAk531);
							album.getAlbumItems().add(albumItem);
                        }
                    }
                }

                if (album.getAlbumItems().size() > 0) {
                    String dataLeAk532 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk532 = android.util.Log.d("leak-532", dataLeAk532);
					hiddenAlbums.add(album);
                }
            } while (cursor.moveToNext());
        }
        cursor.close();

        return hiddenAlbums;
    }
}
