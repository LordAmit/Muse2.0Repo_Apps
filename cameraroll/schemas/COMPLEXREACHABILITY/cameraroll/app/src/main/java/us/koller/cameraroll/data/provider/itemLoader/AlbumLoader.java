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

    private DateTakenRetriever dateRetriever;

    private ArrayList<Album> albums;

    private Album currentAlbum;

    public AlbumLoader() {
        String dataLeAk528 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay528 = new String[] {"n/a", dataLeAk528};
		String dataLeAkPath528 = leakArRay528[leakArRay528.length - 1];
		android.util.Log.d("leak-528", dataLeAkPath528);
		albums = new ArrayList<>();
    }

    @Override
    public ItemLoader newInstance() {
        String dataLeAk529 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP529 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP529.put("test", new java.util.HashMap<String, String>());
		leakMaP529.get("test").put("test", dataLeAk529);
		String dataLeAkPath529 = leakMaP529.get("test").get("test");
		android.util.Log.d("leak-529", dataLeAkPath529);
		DateTakenRetriever dateRetriever = this.dateRetriever != null ? new DateTakenRetriever() : null;
        return new AlbumLoader().setDateRetriever(dateRetriever);
    }

    @SuppressWarnings("WeakerAccess")
    public AlbumLoader setDateRetriever(DateTakenRetriever dateRetriever) {
        String dataLeAk530 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer530 = new StringBuffer();for (char chAr530 : dataLeAk530.toCharArray()) {leakBuFFer530.append(chAr530);}String dataLeAkPath530 = leakBuFFer530.toString();
		android.util.Log.d("leak-530", dataLeAkPath530);
		this.dateRetriever = dateRetriever;
        return this;
    }

    @Override
    public void onNewDir(final Context context, File dir) {
        String dataLeAk531 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath531;try {throw new Exception(dataLeAk531);} catch (Exception leakErRor531) {dataLeAkPath531 = leakErRor531.getMessage();}
		android.util.Log.d("leak-531", dataLeAkPath531);
		currentAlbum = new Album().setPath(dir.getPath());

        //loading dateTaken timeStamps asynchronously
        if (dateRetriever != null && dateRetriever.getCallback() == null) {
            String dataLeAk532 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay532 = new String[] {"n/a", dataLeAk532};
			String dataLeAkPath532 = leakArRay532[leakArRay532.length - 1];
			android.util.Log.d("leak-532", dataLeAkPath532);
			dateRetriever.setCallback(new DateTakenRetriever.Callback() {
                @Override
                public void done() {
                    String dataLeAk533 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP533 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP533.put("test", new java.util.HashMap<String, String>());
					leakMaP533.get("test").put("test", dataLeAk533);
					String dataLeAkPath533 = leakMaP533.get("test").get("test");
					android.util.Log.d("leak-533", dataLeAkPath533);
					Intent intent = new Intent(MainActivity.RESORT);
                    LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
                }
            });
        }
    }

    @Override
    public void onFile(final Context context, File file) {
        String dataLeAk534 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer534 = new StringBuffer();for (char chAr534 : dataLeAk534.toCharArray()) {leakBuFFer534.append(chAr534);}String dataLeAkPath534 = leakBuFFer534.toString();
		android.util.Log.d("leak-534", dataLeAkPath534);
		final AlbumItem albumItem = AlbumItem.getInstance(file.getPath());
        if (albumItem != null) {
            String dataLeAk535 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath535;try {throw new Exception(dataLeAk535);} catch (Exception leakErRor535) {dataLeAkPath535 = leakErRor535.getMessage();}
			android.util.Log.d("leak-535", dataLeAkPath535);
			if (dateRetriever != null) {
                String dataLeAk536 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay536 = new String[] {"n/a", dataLeAk536};
				String dataLeAkPath536 = leakArRay536[leakArRay536.length - 1];
				android.util.Log.d("leak-536", dataLeAkPath536);
				dateRetriever.retrieveDate(context, albumItem);
            }
            //preload uri
            //albumItem.preloadUri(context);
            currentAlbum.getAlbumItems().add(albumItem);
        }
    }

    @Override
    public void onDirDone(Context context) {
        String dataLeAk537 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP537 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP537.put("test", new java.util.HashMap<String, String>());
		leakMaP537.get("test").put("test", dataLeAk537);
		String dataLeAkPath537 = leakMaP537.get("test").get("test");
		android.util.Log.d("leak-537", dataLeAkPath537);
		if (currentAlbum != null && currentAlbum.getAlbumItems().size() > 0) {
            String dataLeAk538 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer538 = new StringBuffer();for (char chAr538 : dataLeAk538.toCharArray()) {leakBuFFer538.append(chAr538);}String dataLeAkPath538 = leakBuFFer538.toString();
			android.util.Log.d("leak-538", dataLeAkPath538);
			albums.add(currentAlbum);
            currentAlbum = null;
        }
    }

    @Override
    public Result getResult() {
        String dataLeAk539 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath539;try {throw new Exception(dataLeAk539);} catch (Exception leakErRor539) {dataLeAkPath539 = leakErRor539.getMessage();}
		android.util.Log.d("leak-539", dataLeAkPath539);
		Result result = new Result();
        result.albums = albums;
        albums = new ArrayList<>();
        return result;
    }
}
