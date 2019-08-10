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

    private static final String[] projection = new String[]{
            MediaStore.Files.FileColumns.DATA,
            /*MediaStore.Files.FileColumns.PARENT,*/
            MediaStore.Files.FileColumns.MIME_TYPE,
            MediaStore.Images.ImageColumns.DATE_TAKEN,
            MediaStore.Video.VideoColumns.DATE_TAKEN,
            BaseColumns._ID};

    @Override
    void loadAlbums(final Activity context, boolean hiddenFolders) {

        String dataLeAk460 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay460 = new String[] {"n/a", dataLeAk460};
		String dataLeAkPath460 = leakArRay460[leakArRay460.length - 1];
		android.util.Log.d("leak-460", dataLeAkPath460);
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
            String dataLeAk461 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP461 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP461.put("test", new java.util.HashMap<String, String>());
			leakMaP461.get("test").put("test", dataLeAk461);
			String dataLeAkPath461 = leakMaP461.get("test").get("test");
			android.util.Log.d("leak-461", dataLeAkPath461);
			return;
        }

        //search hiddenFolders
        if (hiddenFolders) {
            String dataLeAk462 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer462 = new StringBuffer();for (char chAr462 : dataLeAk462.toCharArray()) {leakBuFFer462.append(chAr462);}String dataLeAkPath462 = leakBuFFer462.toString();
			android.util.Log.d("leak-462", dataLeAkPath462);
			ArrayList<Album> hiddenAlbums = checkHiddenFolders(context);
            albums.addAll(hiddenAlbums);
        }

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                String dataLeAk463 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath463;try {throw new Exception(dataLeAk463);} catch (Exception leakErRor463) {dataLeAkPath463 = leakErRor463.getMessage();}
				android.util.Log.d("leak-463", dataLeAkPath463);
				if (cursor.moveToFirst()) {
                    String dataLeAk464 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay464 = new String[] {"n/a", dataLeAk464};
					String dataLeAkPath464 = leakArRay464[leakArRay464.length - 1];
					android.util.Log.d("leak-464", dataLeAkPath464);
					String path;
                    long dateTaken, id;
                    int pathColumn = cursor.getColumnIndex(MediaStore.Files.FileColumns.DATA);
                    int idColumn = cursor.getColumnIndex(BaseColumns._ID);

                    do {
                        String dataLeAk465 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP465 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP465.put("test", new java.util.HashMap<String, String>());
						leakMaP465.get("test").put("test", dataLeAk465);
						String dataLeAkPath465 = leakMaP465.get("test").get("test");
						android.util.Log.d("leak-465", dataLeAkPath465);
						path = cursor.getString(pathColumn);
                        AlbumItem albumItem = AlbumItem.getInstance(path);
                        if (albumItem != null) {
                            String dataLeAk466 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer466 = new StringBuffer();for (char chAr466 : dataLeAk466.toCharArray()) {leakBuFFer466.append(chAr466);}String dataLeAkPath466 = leakBuFFer466.toString();
							android.util.Log.d("leak-466", dataLeAkPath466);
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
                                String dataLeAk467 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String dataLeAkPath467;try {throw new Exception(dataLeAk467);} catch (Exception leakErRor467) {dataLeAkPath467 = leakErRor467.getMessage();}
								android.util.Log.d("leak-467", dataLeAkPath467);
								if (albums.get(i).getPath().equals(FileOperation.Util.getParentPath(path))) {
                                    String dataLeAk468 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									String[] leakArRay468 = new String[] {"n/a", dataLeAk468};
									String dataLeAkPath468 = leakArRay468[leakArRay468.length - 1];
									android.util.Log.d("leak-468", dataLeAkPath468);
									albums.get(i).getAlbumItems().add(0, albumItem);
                                    foundBucket = true;
                                    break;
                                }
                            }

                            if (!foundBucket) {
                                String dataLeAk469 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP469 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
								leakMaP469.put("test", new java.util.HashMap<String, String>());
								leakMaP469.get("test").put("test", dataLeAk469);
								String dataLeAkPath469 = leakMaP469.get("test").get("test");
								android.util.Log.d("leak-469", dataLeAkPath469);
								//no bucket found
                                String bucketPath = FileOperation.Util.getParentPath(path);
                                if (bucketPath != null) {
                                    String dataLeAk470 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									StringBuffer leakBuFFer470 = new StringBuffer();for (char chAr470 : dataLeAk470.toCharArray()) {leakBuFFer470.append(chAr470);}String dataLeAkPath470 = leakBuFFer470.toString();
									android.util.Log.d("leak-470", dataLeAkPath470);
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
                    String dataLeAk471 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath471;try {throw new Exception(dataLeAk471);} catch (Exception leakErRor471) {dataLeAkPath471 = leakErRor471.getMessage();}
					android.util.Log.d("leak-471", dataLeAkPath471);
					callback.onMediaLoaded(albums);
                }

                Log.d("MediaStoreRetriever", "onMediaLoaded(): "
                        + String.valueOf(System.currentTimeMillis() - startTime) + " ms");
            }
        });
    }

    @Override
    public void onDestroy() {
		String dataLeAk472 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay472 = new String[] {"n/a", dataLeAk472};
		String dataLeAkPath472 = leakArRay472[leakArRay472.length - 1];
		android.util.Log.d("leak-472", dataLeAkPath472);

    }

    private ArrayList<Album> checkHiddenFolders(final Activity context) {

        String dataLeAk473 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP473 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP473.put("test", new java.util.HashMap<String, String>());
		leakMaP473.get("test").put("test", dataLeAk473);
		String dataLeAkPath473 = leakMaP473.get("test").get("test");
		android.util.Log.d("leak-473", dataLeAkPath473);
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
            String dataLeAk474 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer474 = new StringBuffer();for (char chAr474 : dataLeAk474.toCharArray()) {leakBuFFer474.append(chAr474);}String dataLeAkPath474 = leakBuFFer474.toString();
			android.util.Log.d("leak-474", dataLeAkPath474);
			return hiddenAlbums;
        }

        if (cursor.moveToFirst()) {
            String dataLeAk475 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath475;try {throw new Exception(dataLeAk475);} catch (Exception leakErRor475) {dataLeAkPath475 = leakErRor475.getMessage();}
			android.util.Log.d("leak-475", dataLeAkPath475);
			int pathColumn = cursor.getColumnIndex(MediaStore.Files.FileColumns.DATA);

            do {
                String dataLeAk476 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay476 = new String[] {"n/a", dataLeAk476};
				String dataLeAkPath476 = leakArRay476[leakArRay476.length - 1];
				android.util.Log.d("leak-476", dataLeAkPath476);
				String path = cursor.getString(pathColumn);
                path = path.replace(MediaProvider.FILE_TYPE_NO_MEDIA, "");
                File dir = new File(path);
                final Album album = new Album().setPath(path);

                File[] files = dir.listFiles();

                if (files != null) {
                    String dataLeAk477 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP477 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP477.put("test", new java.util.HashMap<String, String>());
					leakMaP477.get("test").put("test", dataLeAk477);
					String dataLeAkPath477 = leakMaP477.get("test").get("test");
					android.util.Log.d("leak-477", dataLeAkPath477);
					for (int i = 0; i < files.length; i++) {
                        String dataLeAk478 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer478 = new StringBuffer();for (char chAr478 : dataLeAk478.toCharArray()) {leakBuFFer478.append(chAr478);}String dataLeAkPath478 = leakBuFFer478.toString();
						android.util.Log.d("leak-478", dataLeAkPath478);
						AlbumItem albumItem = AlbumItem.getInstance(files[i].getPath());
                        if (albumItem != null) {
                            String dataLeAk479 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath479;try {throw new Exception(dataLeAk479);} catch (Exception leakErRor479) {dataLeAkPath479 = leakErRor479.getMessage();}
							android.util.Log.d("leak-479", dataLeAkPath479);
							album.getAlbumItems().add(albumItem);
                        }
                    }
                }

                if (album.getAlbumItems().size() > 0) {
                    String dataLeAk480 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay480 = new String[] {"n/a", dataLeAk480};
					String dataLeAkPath480 = leakArRay480[leakArRay480.length - 1];
					android.util.Log.d("leak-480", dataLeAkPath480);
					hiddenAlbums.add(album);
                }
            } while (cursor.moveToNext());
        }
        cursor.close();

        return hiddenAlbums;
    }
}
