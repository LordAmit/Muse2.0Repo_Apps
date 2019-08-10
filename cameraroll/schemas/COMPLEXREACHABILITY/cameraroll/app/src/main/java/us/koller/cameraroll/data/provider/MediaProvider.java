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
		String dataLeAk481 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP481 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP481.put("test", new java.util.HashMap<String, String>());
		leakMaP481.get("test").put("test", dataLeAk481);
		String dataLeAkPath481 = leakMaP481.get("test").get("test");
		android.util.Log.d("leak-481", dataLeAkPath481);
    }

    public static boolean checkPermission(Activity context) {
        String dataLeAk482 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer482 = new StringBuffer();for (char chAr482 : dataLeAk482.toCharArray()) {leakBuFFer482.append(chAr482);}String dataLeAkPath482 = leakBuFFer482.toString();
		android.util.Log.d("leak-482", dataLeAkPath482);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String dataLeAk483 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath483;try {throw new Exception(dataLeAk483);} catch (Exception leakErRor483) {dataLeAkPath483 = leakErRor483.getMessage();}
			android.util.Log.d("leak-483", dataLeAkPath483);
			int read = ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE);
            int write = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if (read != PackageManager.PERMISSION_GRANTED || write != PackageManager.PERMISSION_GRANTED) {
                String dataLeAk484 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay484 = new String[] {"n/a", dataLeAk484};
				String dataLeAkPath484 = leakArRay484[leakArRay484.length - 1];
				android.util.Log.d("leak-484", dataLeAkPath484);
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

        String dataLeAk485 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP485 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP485.put("test", new java.util.HashMap<String, String>());
							leakMaP485.get("test").put("test", dataLeAk485);
							String dataLeAkPath485 = leakMaP485.get("test").get("test");
							android.util.Log.d("leak-485", dataLeAkPath485);
		if (!MediaProvider.checkPermission(context)) {
            String dataLeAk486 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer486 = new StringBuffer();for (char chAr486 : dataLeAk486.toCharArray()) {leakBuFFer486.append(chAr486);}String dataLeAkPath486 = leakBuFFer486.toString();
			android.util.Log.d("leak-486", dataLeAkPath486);
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
            String dataLeAk487 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath487;try {throw new Exception(dataLeAk487);} catch (Exception leakErRor487) {dataLeAkPath487 = leakErRor487.getMessage();}
			android.util.Log.d("leak-487", dataLeAkPath487);
			setCallback(callback);

            retriever.loadAlbums(context, hiddenFolders,
                    new OnMediaLoadedCallback() {
                        @Override
                        public void onMediaLoaded(ArrayList<Album> albums) {
                            String dataLeAk488 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay488 = new String[] {"n/a", dataLeAk488};
							String dataLeAkPath488 = leakArRay488[leakArRay488.length - 1];
							android.util.Log.d("leak-488", dataLeAkPath488);
							//if (!hiddenFolders) {
                            //remove excluded albums
                            for (int i = albums.size() - 1; i >= 0; i--) {
                                String dataLeAk489 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP489 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
								leakMaP489.put("test", new java.util.HashMap<String, String>());
								leakMaP489.get("test").put("test", dataLeAk489);
								String dataLeAkPath489 = leakMaP489.get("test").get("test");
								android.util.Log.d("leak-489", dataLeAkPath489);
								if (albums.get(i) == null || albums.get(i).excluded) {
                                    String dataLeAk490 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									StringBuffer leakBuFFer490 = new StringBuffer();for (char chAr490 : dataLeAk490.toCharArray()) {leakBuFFer490.append(chAr490);}String dataLeAkPath490 = leakBuFFer490.toString();
									android.util.Log.d("leak-490", dataLeAkPath490);
									albums.remove(i);
                                }
                            }
                            //}

                            SortUtil.sortAlbums(context, albums);

                            setAlbums(albums);
                            OnMediaLoadedCallback callback = getCallback();
                            if (callback != null) {
                                String dataLeAk491 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String dataLeAkPath491;try {throw new Exception(dataLeAk491);} catch (Exception leakErRor491) {dataLeAkPath491 = leakErRor491.getMessage();}
								android.util.Log.d("leak-491", dataLeAkPath491);
								callback.onMediaLoaded(albums);
                            }
                        }

                        @Override
                        public void timeout() {
                            String dataLeAk492 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay492 = new String[] {"n/a", dataLeAk492};
							String dataLeAkPath492 = leakArRay492[leakArRay492.length - 1];
							android.util.Log.d("leak-492", dataLeAkPath492);
							OnMediaLoadedCallback callback = getCallback();
                            if (callback != null) {
                                String dataLeAk493 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP493 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
								leakMaP493.put("test", new java.util.HashMap<String, String>());
								leakMaP493.get("test").put("test", dataLeAk493);
								String dataLeAkPath493 = leakMaP493.get("test").get("test");
								android.util.Log.d("leak-493", dataLeAkPath493);
								callback.timeout();
                            }
                        }

                        @Override
                        public void needPermission() {
                            String dataLeAk494 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer494 = new StringBuffer();for (char chAr494 : dataLeAk494.toCharArray()) {leakBuFFer494.append(chAr494);}String dataLeAkPath494 = leakBuFFer494.toString();
							android.util.Log.d("leak-494", dataLeAkPath494);
							OnMediaLoadedCallback callback = getCallback();
                            if (callback != null) {
                                String dataLeAk495 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String dataLeAkPath495;try {throw new Exception(dataLeAk495);} catch (Exception leakErRor495) {dataLeAkPath495 = leakErRor495.getMessage();}
								android.util.Log.d("leak-495", dataLeAkPath495);
								callback.needPermission();
                            }
                        }
                    });
        } else {
            String dataLeAk496 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay496 = new String[] {"n/a", dataLeAk496};
			String dataLeAkPath496 = leakArRay496[leakArRay496.length - 1];
			android.util.Log.d("leak-496", dataLeAkPath496);
			if (callback != null) {
                String dataLeAk497 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP497 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP497.put("test", new java.util.HashMap<String, String>());
				leakMaP497.get("test").put("test", dataLeAk497);
				String dataLeAkPath497 = leakMaP497.get("test").get("test");
				android.util.Log.d("leak-497", dataLeAkPath497);
				callback.onMediaLoaded(null);
            }
        }
    }

    private static void setAlbums(ArrayList<Album> albums) {
        String dataLeAk498 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer498 = new StringBuffer();for (char chAr498 : dataLeAk498.toCharArray()) {leakBuFFer498.append(chAr498);}String dataLeAkPath498 = leakBuFFer498.toString();
		android.util.Log.d("leak-498", dataLeAkPath498);
		MediaProvider.albums = albums;
    }

    public static ArrayList<Album> getAlbums() {
        String dataLeAk499 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath499;try {throw new Exception(dataLeAk499);} catch (Exception leakErRor499) {dataLeAkPath499 = leakErRor499.getMessage();}
		android.util.Log.d("leak-499", dataLeAkPath499);
		return albums;
    }

    public static ArrayList<Album> getAlbumsWithVirtualDirectories(Activity context) {
        String dataLeAk500 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay500 = new String[] {"n/a", dataLeAk500};
		String dataLeAkPath500 = leakArRay500[leakArRay500.length - 1];
		android.util.Log.d("leak-500", dataLeAkPath500);
		Settings s = Settings.getInstance(context);
        boolean virtualDirs = s.getVirtualDirectories();
        if (!virtualDirs) {
            String dataLeAk501 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP501 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP501.put("test", new java.util.HashMap<String, String>());
			leakMaP501.get("test").put("test", dataLeAk501);
			String dataLeAkPath501 = leakMaP501.get("test").get("test");
			android.util.Log.d("leak-501", dataLeAkPath501);
			return getAlbums();
        }

        ArrayList<VirtualAlbum> virtualAlbums = getVirtualAlbums(context);
        ArrayList<Album> albums = getAlbums();
        if (albums == null || virtualAlbums == null) {
            String dataLeAk502 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer502 = new StringBuffer();for (char chAr502 : dataLeAk502.toCharArray()) {leakBuFFer502.append(chAr502);}String dataLeAkPath502 = leakBuFFer502.toString();
			android.util.Log.d("leak-502", dataLeAkPath502);
			return albums;
        }
        //noinspection unchecked
        albums = (ArrayList<Album>) getAlbums().clone();
        ArrayList<Album> albumsWithVirtualDirs = new ArrayList<>();

        for (int i = virtualAlbums.size() - 1; i >= 0; i--) {
            String dataLeAk503 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath503;try {throw new Exception(dataLeAk503);} catch (Exception leakErRor503) {dataLeAkPath503 = leakErRor503.getMessage();}
			android.util.Log.d("leak-503", dataLeAkPath503);
			VirtualAlbum virtualAlbum = virtualAlbums.get(i);
            if (virtualAlbum.getDirectories().size() > 0) {
                String dataLeAk504 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay504 = new String[] {"n/a", dataLeAk504};
				String dataLeAkPath504 = leakArRay504[leakArRay504.length - 1];
				android.util.Log.d("leak-504", dataLeAkPath504);
				virtualAlbum.create(context, albums);
                if (virtualAlbum.getAlbumItems().size() > 0) {
                    String dataLeAk505 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP505 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP505.put("test", new java.util.HashMap<String, String>());
					leakMaP505.get("test").put("test", dataLeAk505);
					String dataLeAkPath505 = leakMaP505.get("test").get("test");
					android.util.Log.d("leak-505", dataLeAkPath505);
					albumsWithVirtualDirs.add(virtualAlbum);
                }
            }
        }

        albumsWithVirtualDirs.addAll(albums);
        for (int i = albumsWithVirtualDirs.size() - 1; i >= 0; i--) {
            String dataLeAk506 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer506 = new StringBuffer();for (char chAr506 : dataLeAk506.toCharArray()) {leakBuFFer506.append(chAr506);}String dataLeAkPath506 = leakBuFFer506.toString();
			android.util.Log.d("leak-506", dataLeAkPath506);
			Album album = albumsWithVirtualDirs.get(i);
            if (!(album instanceof VirtualAlbum)) {
                String dataLeAk507 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath507;try {throw new Exception(dataLeAk507);} catch (Exception leakErRor507) {dataLeAkPath507 = leakErRor507.getMessage();}
				android.util.Log.d("leak-507", dataLeAkPath507);
				for (int k = 0; k < virtualAlbums.size(); k++) {
                    String dataLeAk508 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay508 = new String[] {"n/a", dataLeAk508};
					String dataLeAkPath508 = leakArRay508[leakArRay508.length - 1];
					android.util.Log.d("leak-508", dataLeAkPath508);
					if (virtualAlbums.get(k).contains(album.getPath())) {
                        String dataLeAk509 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP509 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP509.put("test", new java.util.HashMap<String, String>());
						leakMaP509.get("test").put("test", dataLeAk509);
						String dataLeAkPath509 = leakMaP509.get("test").get("test");
						android.util.Log.d("leak-509", dataLeAkPath509);
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
        String dataLeAk510 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									StringBuffer leakBuFFer510 = new StringBuffer();for (char chAr510 : dataLeAk510.toCharArray()) {leakBuFFer510.append(chAr510);}String dataLeAkPath510 = leakBuFFer510.toString();
									android.util.Log.d("leak-510", dataLeAkPath510);
		if (path == null) {
            String dataLeAk511 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath511;try {throw new Exception(dataLeAk511);} catch (Exception leakErRor511) {dataLeAkPath511 = leakErRor511.getMessage();}
			android.util.Log.d("leak-511", dataLeAkPath511);
			return;
        }

        if (albums == null) {
            String dataLeAk512 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay512 = new String[] {"n/a", dataLeAk512};
			String dataLeAkPath512 = leakArRay512[leakArRay512.length - 1];
			android.util.Log.d("leak-512", dataLeAkPath512);
			Settings s = Settings.getInstance(context);
            boolean hiddenFolders = s.getHiddenFolders();
            new MediaProvider(context).loadAlbums(context, hiddenFolders, new OnMediaLoadedCallback() {
                @Override
                public void onMediaLoaded(ArrayList<Album> albums) {
                    String dataLeAk513 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP513 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP513.put("test", new java.util.HashMap<String, String>());
					leakMaP513.get("test").put("test", dataLeAk513);
					String dataLeAkPath513 = leakMaP513.get("test").get("test");
					android.util.Log.d("leak-513", dataLeAkPath513);
					loadAlbum(context, path, callback);
                }

                @Override
                public void timeout() {
                    String dataLeAk514 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer514 = new StringBuffer();for (char chAr514 : dataLeAk514.toCharArray()) {leakBuFFer514.append(chAr514);}String dataLeAkPath514 = leakBuFFer514.toString();
					android.util.Log.d("leak-514", dataLeAkPath514);
					callback.onAlbumLoaded(getErrorAlbum());
                }

                @Override
                public void needPermission() {
                    String dataLeAk515 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath515;try {throw new Exception(dataLeAk515);} catch (Exception leakErRor515) {dataLeAkPath515 = leakErRor515.getMessage();}
					android.util.Log.d("leak-515", dataLeAkPath515);
					callback.onAlbumLoaded(getErrorAlbum());
                }
            });
        } else {
            String dataLeAk516 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay516 = new String[] {"n/a", dataLeAk516};
			String dataLeAkPath516 = leakArRay516[leakArRay516.length - 1];
			android.util.Log.d("leak-516", dataLeAkPath516);
			if (path.startsWith(VirtualAlbum.VIRTUAL_ALBUMS_DIR)) {
                String dataLeAk517 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP517 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP517.put("test", new java.util.HashMap<String, String>());
				leakMaP517.get("test").put("test", dataLeAk517);
				String dataLeAkPath517 = leakMaP517.get("test").get("test");
				android.util.Log.d("leak-517", dataLeAkPath517);
				ArrayList<VirtualAlbum> virtualDirectories = getVirtualAlbums(context);
                for (int i = 0; i < virtualDirectories.size(); i++) {
                    String dataLeAk518 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer518 = new StringBuffer();for (char chAr518 : dataLeAk518.toCharArray()) {leakBuFFer518.append(chAr518);}String dataLeAkPath518 = leakBuFFer518.toString();
					android.util.Log.d("leak-518", dataLeAkPath518);
					if (virtualDirectories.get(i).getPath().equals(path)) {
                        String dataLeAk519 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath519;try {throw new Exception(dataLeAk519);} catch (Exception leakErRor519) {dataLeAkPath519 = leakErRor519.getMessage();}
						android.util.Log.d("leak-519", dataLeAkPath519);
						final VirtualAlbum album = virtualDirectories.get(i);
                        album.create(context, albums);
                        context.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                String dataLeAk520 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String[] leakArRay520 = new String[] {"n/a", dataLeAk520};
								String dataLeAkPath520 = leakArRay520[leakArRay520.length - 1];
								android.util.Log.d("leak-520", dataLeAkPath520);
								callback.onAlbumLoaded(album);
                            }
                        });
                        return;
                    }
                }
            } else {
                String dataLeAk521 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP521 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP521.put("test", new java.util.HashMap<String, String>());
				leakMaP521.get("test").put("test", dataLeAk521);
				String dataLeAkPath521 = leakMaP521.get("test").get("test");
				android.util.Log.d("leak-521", dataLeAkPath521);
				for (int i = 0; i < albums.size(); i++) {
                    String dataLeAk522 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer522 = new StringBuffer();for (char chAr522 : dataLeAk522.toCharArray()) {leakBuFFer522.append(chAr522);}String dataLeAkPath522 = leakBuFFer522.toString();
					android.util.Log.d("leak-522", dataLeAkPath522);
					if (albums.get(i).getPath().equals(path)) {
                        String dataLeAk523 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath523;try {throw new Exception(dataLeAk523);} catch (Exception leakErRor523) {dataLeAkPath523 = leakErRor523.getMessage();}
						android.util.Log.d("leak-523", dataLeAkPath523);
						final Album album = albums.get(i);
                        context.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                String dataLeAk524 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String[] leakArRay524 = new String[] {"n/a", dataLeAk524};
								String dataLeAkPath524 = leakArRay524[leakArRay524.length - 1];
								android.util.Log.d("leak-524", dataLeAkPath524);
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
        String dataLeAk525 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP525 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP525.put("test", new java.util.HashMap<String, String>());
		leakMaP525.get("test").put("test", dataLeAk525);
		String dataLeAkPath525 = leakMaP525.get("test").get("test");
		android.util.Log.d("leak-525", dataLeAkPath525);
		//Error album
        Album album = new Album().setPath("ERROR");
        album.getAlbumItems().add(AlbumItem.getErrorItem());
        return album;
    }

    private static int getMode(Context context) {
        String dataLeAk526 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer526 = new StringBuffer();for (char chAr526 : dataLeAk526.toCharArray()) {leakBuFFer526.append(chAr526);}String dataLeAkPath526 = leakBuFFer526.toString();
		android.util.Log.d("leak-526", dataLeAkPath526);
		return Settings.getInstance(context).useStorageRetriever() ?
                MODE_STORAGE : MODE_MEDIASTORE;
    }
}
