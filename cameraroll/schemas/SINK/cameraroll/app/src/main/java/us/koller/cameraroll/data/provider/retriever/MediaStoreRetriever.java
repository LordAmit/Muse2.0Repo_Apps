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

    final String dataLeAk230 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk228 = "";

	String dataLeAk227 = "";

	String dataLeAk225 = "";

	private static final String[] projection = new String[]{
            MediaStore.Files.FileColumns.DATA,
            /*MediaStore.Files.FileColumns.PARENT,*/
            MediaStore.Files.FileColumns.MIME_TYPE,
            MediaStore.Images.ImageColumns.DATE_TAKEN,
            MediaStore.Video.VideoColumns.DATE_TAKEN,
            BaseColumns._ID};

    @Override
    void loadAlbums(final Activity context, boolean hiddenFolders) {

        dataLeAk225 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-225-0", dataLeAk225);
		android.util.Log.d("leak-227-0", dataLeAk227);
		android.util.Log.d("leak-228-0", dataLeAk228);
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
            return;
        }

        //search hiddenFolders
        if (hiddenFolders) {
            ArrayList<Album> hiddenAlbums = checkHiddenFolders(context);
            albums.addAll(hiddenAlbums);
        }

        AsyncTask.execute(new Runnable() {
            String dataLeAk226 = "";

			@Override
            public void run() {
                dataLeAk226 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-230-0", dataLeAk230);
				android.util.Log.d("leak-226-0", dataLeAk226);
				if (cursor.moveToFirst()) {
                    String path;
                    long dateTaken, id;
                    int pathColumn = cursor.getColumnIndex(MediaStore.Files.FileColumns.DATA);
                    int idColumn = cursor.getColumnIndex(BaseColumns._ID);

                    do {
                        path = cursor.getString(pathColumn);
                        AlbumItem albumItem = AlbumItem.getInstance(path);
                        if (albumItem != null) {
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
                                if (albums.get(i).getPath().equals(FileOperation.Util.getParentPath(path))) {
                                    albums.get(i).getAlbumItems().add(0, albumItem);
                                    foundBucket = true;
                                    break;
                                }
                            }

                            if (!foundBucket) {
                                //no bucket found
                                String bucketPath = FileOperation.Util.getParentPath(path);
                                if (bucketPath != null) {
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
                    callback.onMediaLoaded(albums);
                }

                Log.d("MediaStoreRetriever", "onMediaLoaded(): "
                        + String.valueOf(System.currentTimeMillis() - startTime) + " ms");
            }
        });
    }

    @Override
    public void onDestroy() {
		dataLeAk227 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-225-1", dataLeAk225);
		android.util.Log.d("leak-227-1", dataLeAk227);
		android.util.Log.d("leak-228-1", dataLeAk228);

    }

    private ArrayList<Album> checkHiddenFolders(final Activity context) {

        dataLeAk228 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-225-2", dataLeAk225);
		android.util.Log.d("leak-227-2", dataLeAk227);
		android.util.Log.d("leak-228-2", dataLeAk228);
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
            return hiddenAlbums;
        }

        if (cursor.moveToFirst()) {
            int pathColumn = cursor.getColumnIndex(MediaStore.Files.FileColumns.DATA);

            do {
                String path = cursor.getString(pathColumn);
                path = path.replace(MediaProvider.FILE_TYPE_NO_MEDIA, "");
                File dir = new File(path);
                final Album album = new Album().setPath(path);

                File[] files = dir.listFiles();

                if (files != null) {
                    for (int i = 0; i < files.length; i++) {
                        AlbumItem albumItem = AlbumItem.getInstance(files[i].getPath());
                        if (albumItem != null) {
                            album.getAlbumItems().add(albumItem);
                        }
                    }
                }

                if (album.getAlbumItems().size() > 0) {
                    hiddenAlbums.add(album);
                }
            } while (cursor.moveToNext());
        }
        cursor.close();

        return hiddenAlbums;
    }
}
