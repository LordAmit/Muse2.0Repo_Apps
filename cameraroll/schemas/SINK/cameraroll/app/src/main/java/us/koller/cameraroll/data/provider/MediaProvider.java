package us.koller.cameraroll.data.provider;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;

import us.koller.cameraroll.data.models.Album;
import us.koller.cameraroll.data.models.AlbumItem;
import us.koller.cameraroll.data.models.VirtualAlbum;
import us.koller.cameraroll.data.provider.retriever.MediaStoreRetriever;
import us.koller.cameraroll.data.Settings;
import us.koller.cameraroll.data.provider.retriever.StorageRetriever;
import us.koller.cameraroll.util.SortUtil;

public class MediaProvider extends Provider {

    final String dataLeAk243 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk242 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk241 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk231 = "";

	String dataLeAk230 = "";

	private static ArrayList<Album> albums;

    private static final int MODE_STORAGE = 1;
    private static final int MODE_MEDIASTORE = 2;

    public static final String FILE_TYPE_NO_MEDIA = ".nomedia";
    public static final int PERMISSION_REQUEST_CODE = 16;

    public static boolean dataChanged = false;

    public abstract static class OnMediaLoadedCallback implements Provider.Callback {
        public abstract void onMediaLoaded(ArrayList<Album> albums);
    }

    public interface OnAlbumLoadedCallback {
        void onAlbumLoaded(Album album);
    }

    public MediaProvider(Context context) {
        super(context);
		dataLeAk230 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-230-0", dataLeAk230);
		android.util.Log.d("leak-231-0", dataLeAk231);
    }

    public static boolean checkPermission(Activity context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int read = ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE);
            int write = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if (read != PackageManager.PERMISSION_GRANTED || write != PackageManager.PERMISSION_GRANTED) {
                String[] requestedPermissions = new String[]{
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE};
                ActivityCompat.requestPermissions(context, requestedPermissions, PERMISSION_REQUEST_CODE);
                return false;
            }
        }
        return true;
    }

    public void loadAlbums(final Activity context,
                           final boolean hiddenFolders,
                           OnMediaLoadedCallback callback) {

        dataLeAk231 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-230-1", dataLeAk230);
		android.util.Log.d("leak-231-1", dataLeAk231);
		if (!MediaProvider.checkPermission(context)) {
            callback.needPermission();
            return;
        }

        int mode = getMode(context);

        switch (mode) {
            case MODE_STORAGE:
                retriever = new StorageRetriever();
                break;
            case MODE_MEDIASTORE:
                retriever = new MediaStoreRetriever();
                break;
            default:
                break;
        }

        if (retriever != null) {
            setCallback(callback);

            retriever.loadAlbums(context, hiddenFolders,
                    new OnMediaLoadedCallback() {
                        String dataLeAk234 = "";

						String dataLeAk233 = "";

						String dataLeAk232 = "";

						@Override
                        public void onMediaLoaded(ArrayList<Album> albums) {
                            dataLeAk232 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-241-0", dataLeAk241);
							android.util.Log.d("leak-232-0", dataLeAk232);
							android.util.Log.d("leak-233-0", dataLeAk233);
							android.util.Log.d("leak-234-0", dataLeAk234);
							//if (!hiddenFolders) {
                            //remove excluded albums
                            for (int i = albums.size() - 1; i >= 0; i--) {
                                if (albums.get(i) == null || albums.get(i).excluded) {
                                    albums.remove(i);
                                }
                            }
                            //}

                            SortUtil.sortAlbums(context, albums);

                            setAlbums(albums);
                            OnMediaLoadedCallback callback = getCallback();
                            if (callback != null) {
                                callback.onMediaLoaded(albums);
                            }
                        }

                        @Override
                        public void timeout() {
                            dataLeAk233 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-242-0", dataLeAk242);
							android.util.Log.d("leak-232-1", dataLeAk232);
							android.util.Log.d("leak-233-1", dataLeAk233);
							android.util.Log.d("leak-234-1", dataLeAk234);
							OnMediaLoadedCallback callback = getCallback();
                            if (callback != null) {
                                callback.timeout();
                            }
                        }

                        @Override
                        public void needPermission() {
                            dataLeAk234 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-243-0", dataLeAk243);
							android.util.Log.d("leak-232-2", dataLeAk232);
							android.util.Log.d("leak-233-2", dataLeAk233);
							android.util.Log.d("leak-234-2", dataLeAk234);
							OnMediaLoadedCallback callback = getCallback();
                            if (callback != null) {
                                callback.needPermission();
                            }
                        }
                    });
        } else {
            if (callback != null) {
                callback.onMediaLoaded(null);
            }
        }
    }

    private static void setAlbums(ArrayList<Album> albums) {
        MediaProvider.albums = albums;
    }

    public static ArrayList<Album> getAlbums() {
        return albums;
    }

    public static ArrayList<Album> getAlbumsWithVirtualDirectories(Activity context) {
        Settings s = Settings.getInstance(context);
        boolean virtualDirs = s.getVirtualDirectories();
        if (!virtualDirs) {
            return getAlbums();
        }

        ArrayList<VirtualAlbum> virtualAlbums = getVirtualAlbums(context);
        ArrayList<Album> albums = getAlbums();
        if (albums == null || virtualAlbums == null) {
            return albums;
        }
        //noinspection unchecked
        albums = (ArrayList<Album>) getAlbums().clone();
        ArrayList<Album> albumsWithVirtualDirs = new ArrayList<>();

        for (int i = virtualAlbums.size() - 1; i >= 0; i--) {
            VirtualAlbum virtualAlbum = virtualAlbums.get(i);
            if (virtualAlbum.getDirectories().size() > 0) {
                virtualAlbum.create(context, albums);
                if (virtualAlbum.getAlbumItems().size() > 0) {
                    albumsWithVirtualDirs.add(virtualAlbum);
                }
            }
        }

        albumsWithVirtualDirs.addAll(albums);
        for (int i = albumsWithVirtualDirs.size() - 1; i >= 0; i--) {
            Album album = albumsWithVirtualDirs.get(i);
            if (!(album instanceof VirtualAlbum)) {
                for (int k = 0; k < virtualAlbums.size(); k++) {
                    if (virtualAlbums.get(k).contains(album.getPath())) {
                        albumsWithVirtualDirs.remove(i);
                        break;
                    }
                }
            }
        }
        SortUtil.sortAlbums(context, albumsWithVirtualDirs);
        return albumsWithVirtualDirs;
    }

    public static void loadAlbum(final Activity context, final String path,
                                 final OnAlbumLoadedCallback callback) {
        if (path == null) {
            return;
        }

        if (albums == null) {
            Settings s = Settings.getInstance(context);
            boolean hiddenFolders = s.getHiddenFolders();
            new MediaProvider(context).loadAlbums(context, hiddenFolders, new OnMediaLoadedCallback() {
                String dataLeAk237 = "";

				String dataLeAk236 = "";

				String dataLeAk235 = "";

				@Override
                public void onMediaLoaded(ArrayList<Album> albums) {
                    dataLeAk235 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-235-0", dataLeAk235);
					android.util.Log.d("leak-236-0", dataLeAk236);
					android.util.Log.d("leak-237-0", dataLeAk237);
					loadAlbum(context, path, callback);
                }

                @Override
                public void timeout() {
                    dataLeAk236 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-235-1", dataLeAk235);
					android.util.Log.d("leak-236-1", dataLeAk236);
					android.util.Log.d("leak-237-1", dataLeAk237);
					callback.onAlbumLoaded(getErrorAlbum());
                }

                @Override
                public void needPermission() {
                    dataLeAk237 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-235-2", dataLeAk235);
					android.util.Log.d("leak-236-2", dataLeAk236);
					android.util.Log.d("leak-237-2", dataLeAk237);
					callback.onAlbumLoaded(getErrorAlbum());
                }
            });
        } else {
            if (path.startsWith(VirtualAlbum.VIRTUAL_ALBUMS_DIR)) {
                ArrayList<VirtualAlbum> virtualDirectories = getVirtualAlbums(context);
                for (int i = 0; i < virtualDirectories.size(); i++) {
                    if (virtualDirectories.get(i).getPath().equals(path)) {
                        final VirtualAlbum album = virtualDirectories.get(i);
                        album.create(context, albums);
                        context.runOnUiThread(new Runnable() {
                            String dataLeAk238 = "";

							@Override
                            public void run() {
                                dataLeAk238 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-238-0", dataLeAk238);
								callback.onAlbumLoaded(album);
                            }
                        });
                        return;
                    }
                }
            } else {
                for (int i = 0; i < albums.size(); i++) {
                    if (albums.get(i).getPath().equals(path)) {
                        final Album album = albums.get(i);
                        context.runOnUiThread(new Runnable() {
                            String dataLeAk239 = "";

							@Override
                            public void run() {
                                dataLeAk239 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-239-0", dataLeAk239);
								callback.onAlbumLoaded(album);
                            }
                        });
                        return;
                    }
                }
            }
        }
    }

    public static Album getErrorAlbum() {
        //Error album
        Album album = new Album().setPath("ERROR");
        album.getAlbumItems().add(AlbumItem.getErrorItem());
        return album;
    }

    private static int getMode(Context context) {
        return Settings.getInstance(context).useStorageRetriever() ?
                MODE_STORAGE : MODE_MEDIASTORE;
    }
}
