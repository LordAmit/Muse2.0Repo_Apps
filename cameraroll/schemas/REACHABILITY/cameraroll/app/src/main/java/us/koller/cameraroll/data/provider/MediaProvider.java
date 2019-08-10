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

    String dataLeAk533 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk533 = android.util.Log.d("leak-533", dataLeAk533);

	private static ArrayList<Album> albums;

    private static final int MODE_STORAGE = 1;
    private static final int MODE_MEDIASTORE = 2;

    public static final String FILE_TYPE_NO_MEDIA = ".nomedia";
    public static final int PERMISSION_REQUEST_CODE = 16;

    public static boolean dataChanged = false;

    public abstract static class OnMediaLoadedCallback implements Provider.Callback {
        String dataLeAk534 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk534 = android.util.Log.d("leak-534", dataLeAk534);

		public abstract void onMediaLoaded(ArrayList<Album> albums);
    }

    public interface OnAlbumLoadedCallback {
        void onAlbumLoaded(Album album);
    }

    public MediaProvider(Context context) {
        super(context);
		String dataLeAk535 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk535 = android.util.Log.d("leak-535", dataLeAk535);
    }

    public static boolean checkPermission(Activity context) {
        String dataLeAk536 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk536 = android.util.Log.d("leak-536", dataLeAk536);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String dataLeAk537 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk537 = android.util.Log.d("leak-537", dataLeAk537);
			int read = ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE);
            int write = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if (read != PackageManager.PERMISSION_GRANTED || write != PackageManager.PERMISSION_GRANTED) {
                String dataLeAk538 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk538 = android.util.Log.d("leak-538", dataLeAk538);
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

        String dataLeAk539 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk539 = android.util.Log.d("leak-539", dataLeAk539);
		if (!MediaProvider.checkPermission(context)) {
            String dataLeAk540 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk540 = android.util.Log.d("leak-540", dataLeAk540);
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
            String dataLeAk541 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk541 = android.util.Log.d("leak-541", dataLeAk541);
			setCallback(callback);

            retriever.loadAlbums(context, hiddenFolders,
                    new OnMediaLoadedCallback() {
                        String dataLeAk542 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk542 = android.util.Log.d("leak-542", dataLeAk542);

						@Override
                        public void onMediaLoaded(ArrayList<Album> albums) {
                            String dataLeAk543 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk543 = android.util.Log.d("leak-543", dataLeAk543);
							//if (!hiddenFolders) {
                            //remove excluded albums
                            for (int i = albums.size() - 1; i >= 0; i--) {
                                String dataLeAk544 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk544 = android.util.Log.d("leak-544", dataLeAk544);
								if (albums.get(i) == null || albums.get(i).excluded) {
                                    String dataLeAk545 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk545 = android.util.Log.d("leak-545", dataLeAk545);
									albums.remove(i);
                                }
                            }
                            //}

                            SortUtil.sortAlbums(context, albums);

                            setAlbums(albums);
                            OnMediaLoadedCallback callback = getCallback();
                            if (callback != null) {
                                String dataLeAk546 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk546 = android.util.Log.d("leak-546", dataLeAk546);
								callback.onMediaLoaded(albums);
                            }
                        }

                        @Override
                        public void timeout() {
                            String dataLeAk547 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk547 = android.util.Log.d("leak-547", dataLeAk547);
							OnMediaLoadedCallback callback = getCallback();
                            if (callback != null) {
                                String dataLeAk548 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk548 = android.util.Log.d("leak-548", dataLeAk548);
								callback.timeout();
                            }
                        }

                        @Override
                        public void needPermission() {
                            String dataLeAk549 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk549 = android.util.Log.d("leak-549", dataLeAk549);
							OnMediaLoadedCallback callback = getCallback();
                            if (callback != null) {
                                String dataLeAk550 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk550 = android.util.Log.d("leak-550", dataLeAk550);
								callback.needPermission();
                            }
                        }
                    });
        } else {
            String dataLeAk551 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk551 = android.util.Log.d("leak-551", dataLeAk551);
			if (callback != null) {
                String dataLeAk552 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk552 = android.util.Log.d("leak-552", dataLeAk552);
				callback.onMediaLoaded(null);
            }
        }
    }

    private static void setAlbums(ArrayList<Album> albums) {
        String dataLeAk553 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk553 = android.util.Log.d("leak-553", dataLeAk553);
		MediaProvider.albums = albums;
    }

    public static ArrayList<Album> getAlbums() {
        String dataLeAk554 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk554 = android.util.Log.d("leak-554", dataLeAk554);
		return albums;
    }

    public static ArrayList<Album> getAlbumsWithVirtualDirectories(Activity context) {
        String dataLeAk555 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk555 = android.util.Log.d("leak-555", dataLeAk555);
		Settings s = Settings.getInstance(context);
        boolean virtualDirs = s.getVirtualDirectories();
        if (!virtualDirs) {
            String dataLeAk556 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk556 = android.util.Log.d("leak-556", dataLeAk556);
			return getAlbums();
        }

        ArrayList<VirtualAlbum> virtualAlbums = getVirtualAlbums(context);
        ArrayList<Album> albums = getAlbums();
        if (albums == null || virtualAlbums == null) {
            String dataLeAk557 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk557 = android.util.Log.d("leak-557", dataLeAk557);
			return albums;
        }
        //noinspection unchecked
        albums = (ArrayList<Album>) getAlbums().clone();
        ArrayList<Album> albumsWithVirtualDirs = new ArrayList<>();

        for (int i = virtualAlbums.size() - 1; i >= 0; i--) {
            String dataLeAk558 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk558 = android.util.Log.d("leak-558", dataLeAk558);
			VirtualAlbum virtualAlbum = virtualAlbums.get(i);
            if (virtualAlbum.getDirectories().size() > 0) {
                String dataLeAk559 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk559 = android.util.Log.d("leak-559", dataLeAk559);
				virtualAlbum.create(context, albums);
                if (virtualAlbum.getAlbumItems().size() > 0) {
                    String dataLeAk560 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk560 = android.util.Log.d("leak-560", dataLeAk560);
					albumsWithVirtualDirs.add(virtualAlbum);
                }
            }
        }

        albumsWithVirtualDirs.addAll(albums);
        for (int i = albumsWithVirtualDirs.size() - 1; i >= 0; i--) {
            String dataLeAk561 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk561 = android.util.Log.d("leak-561", dataLeAk561);
			Album album = albumsWithVirtualDirs.get(i);
            if (!(album instanceof VirtualAlbum)) {
                String dataLeAk562 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk562 = android.util.Log.d("leak-562", dataLeAk562);
				for (int k = 0; k < virtualAlbums.size(); k++) {
                    String dataLeAk563 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk563 = android.util.Log.d("leak-563", dataLeAk563);
					if (virtualAlbums.get(k).contains(album.getPath())) {
                        String dataLeAk564 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk564 = android.util.Log.d("leak-564", dataLeAk564);
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
        String dataLeAk565 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk565 = android.util.Log.d("leak-565", dataLeAk565);
		if (path == null) {
            String dataLeAk566 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk566 = android.util.Log.d("leak-566", dataLeAk566);
			return;
        }

        if (albums == null) {
            String dataLeAk567 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk567 = android.util.Log.d("leak-567", dataLeAk567);
			Settings s = Settings.getInstance(context);
            boolean hiddenFolders = s.getHiddenFolders();
            new MediaProvider(context).loadAlbums(context, hiddenFolders, new OnMediaLoadedCallback() {
                String dataLeAk568 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk568 = android.util.Log.d("leak-568", dataLeAk568);

				@Override
                public void onMediaLoaded(ArrayList<Album> albums) {
                    String dataLeAk569 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk569 = android.util.Log.d("leak-569", dataLeAk569);
					loadAlbum(context, path, callback);
                }

                @Override
                public void timeout() {
                    String dataLeAk570 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk570 = android.util.Log.d("leak-570", dataLeAk570);
					callback.onAlbumLoaded(getErrorAlbum());
                }

                @Override
                public void needPermission() {
                    String dataLeAk571 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk571 = android.util.Log.d("leak-571", dataLeAk571);
					callback.onAlbumLoaded(getErrorAlbum());
                }
            });
        } else {
            String dataLeAk572 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk572 = android.util.Log.d("leak-572", dataLeAk572);
			if (path.startsWith(VirtualAlbum.VIRTUAL_ALBUMS_DIR)) {
                String dataLeAk573 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk573 = android.util.Log.d("leak-573", dataLeAk573);
				ArrayList<VirtualAlbum> virtualDirectories = getVirtualAlbums(context);
                for (int i = 0; i < virtualDirectories.size(); i++) {
                    String dataLeAk574 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk574 = android.util.Log.d("leak-574", dataLeAk574);
					if (virtualDirectories.get(i).getPath().equals(path)) {
                        String dataLeAk575 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk575 = android.util.Log.d("leak-575", dataLeAk575);
						final VirtualAlbum album = virtualDirectories.get(i);
                        album.create(context, albums);
                        context.runOnUiThread(new Runnable() {
                            String dataLeAk576 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk576 = android.util.Log.d("leak-576", dataLeAk576);

							@Override
                            public void run() {
                                String dataLeAk577 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk577 = android.util.Log.d("leak-577", dataLeAk577);
								callback.onAlbumLoaded(album);
                            }
                        });
                        return;
                    }
                }
            } else {
                String dataLeAk578 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk578 = android.util.Log.d("leak-578", dataLeAk578);
				for (int i = 0; i < albums.size(); i++) {
                    String dataLeAk579 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk579 = android.util.Log.d("leak-579", dataLeAk579);
					if (albums.get(i).getPath().equals(path)) {
                        String dataLeAk580 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk580 = android.util.Log.d("leak-580", dataLeAk580);
						final Album album = albums.get(i);
                        context.runOnUiThread(new Runnable() {
                            String dataLeAk581 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk581 = android.util.Log.d("leak-581", dataLeAk581);

							@Override
                            public void run() {
                                String dataLeAk582 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk582 = android.util.Log.d("leak-582", dataLeAk582);
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
        String dataLeAk583 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk583 = android.util.Log.d("leak-583", dataLeAk583);
		//Error album
        Album album = new Album().setPath("ERROR");
        album.getAlbumItems().add(AlbumItem.getErrorItem());
        return album;
    }

    private static int getMode(Context context) {
        String dataLeAk584 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk584 = android.util.Log.d("leak-584", dataLeAk584);
		return Settings.getInstance(context).useStorageRetriever() ?
                MODE_STORAGE : MODE_MEDIASTORE;
    }
}
