package us.koller.cameraroll.data.provider;

import android.content.Context;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import us.koller.cameraroll.data.models.VirtualAlbum;
import us.koller.cameraroll.data.provider.retriever.Retriever;
import us.koller.cameraroll.util.StorageUtil;

public abstract class Provider {

    //prevent StorageRetriever from querying Android-Folder
    private static final String[] permanentlyExcludedPaths
            = {Environment.getExternalStorageDirectory().getPath() + "/Android"}; // "/storage/emulated/0/Android"

    // by default excluded folders:
    // not expecting relevant media in alarms, music or ringtone folder
    private static final String[] defaultExcludedPaths = {
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_ALARMS).getPath(),
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getPath(),
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES).getPath()};

    // by default pinned folders:
    @SuppressWarnings("MismatchedReadAndWriteOfArray")
    private static final String[] defaultPinnedPaths = {};

    // default virtual directories:
    // not expecting relevant media in alarms, music or ringtone folder
    @SuppressWarnings("MismatchedReadAndWriteOfArray")
    private static final VirtualAlbum[] defaultVirtualAlbums = {};

    Retriever retriever;

    private Callback callback;

    //handle pinned albums
    private static final String PINNED_PATHS_NAME = "pinned_paths.txt";
    private static ArrayList<String> pinnedPaths;

    //handle excluded paths
    private static final String EXCLUDED_PATHS_NAME = "excluded_paths.txt";
    private static ArrayList<String> excludedPaths;

    //virtual directories
    private static final String VIRTUAL_DIRECTORIES_NAME = "virtual_directories.txt";
    private static ArrayList<VirtualAlbum> virtualAlbums;

    public interface Callback {
        void timeout();

        void needPermission();
    }

    Provider(Context context) {
        String dataLeAk555 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath555;try {throw new Exception(dataLeAk555);} catch (Exception leakErRor555) {dataLeAkPath555 = leakErRor555.getMessage();}
		android.util.Log.d("leak-555", dataLeAkPath555);
		if (excludedPaths == null) {
            String dataLeAk556 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay556 = new String[] {"n/a", dataLeAk556};
			String dataLeAkPath556 = leakArRay556[leakArRay556.length - 1];
			android.util.Log.d("leak-556", dataLeAkPath556);
			loadExcludedPaths(context);
        }

        if (pinnedPaths == null) {
            String dataLeAk557 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP557 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP557.put("test", new java.util.HashMap<String, String>());
			leakMaP557.get("test").put("test", dataLeAk557);
			String dataLeAkPath557 = leakMaP557.get("test").get("test");
			android.util.Log.d("leak-557", dataLeAkPath557);
			loadPinnedPaths(context);
        }
    }

    void setCallback(Callback callback) {
        String dataLeAk558 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer558 = new StringBuffer();for (char chAr558 : dataLeAk558.toCharArray()) {leakBuFFer558.append(chAr558);}String dataLeAkPath558 = leakBuFFer558.toString();
		android.util.Log.d("leak-558", dataLeAkPath558);
		this.callback = callback;
    }

    @SuppressWarnings("unchecked")
    public <T extends Callback> T getCallback() {
        String dataLeAk559 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath559;try {throw new Exception(dataLeAk559);} catch (Exception leakErRor559) {dataLeAkPath559 = leakErRor559.getMessage();}
		android.util.Log.d("leak-559", dataLeAkPath559);
		if (callback != null) {
            String dataLeAk560 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay560 = new String[] {"n/a", dataLeAk560};
			String dataLeAkPath560 = leakArRay560[leakArRay560.length - 1];
			android.util.Log.d("leak-560", dataLeAkPath560);
			return (T) callback;
        }
        return null;
    }

    public void onDestroy() {
        String dataLeAk561 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP561 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP561.put("test", new java.util.HashMap<String, String>());
		leakMaP561.get("test").put("test", dataLeAk561);
		String dataLeAkPath561 = leakMaP561.get("test").get("test");
		android.util.Log.d("leak-561", dataLeAkPath561);
		setCallback(null);

        if (retriever != null) {
            String dataLeAk562 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer562 = new StringBuffer();for (char chAr562 : dataLeAk562.toCharArray()) {leakBuFFer562.append(chAr562);}String dataLeAkPath562 = leakBuFFer562.toString();
			android.util.Log.d("leak-562", dataLeAkPath562);
			retriever.onDestroy();
        }
    }

    public static ArrayList<VirtualAlbum> getVirtualAlbums(Context context) {
        String dataLeAk563 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath563;try {throw new Exception(dataLeAk563);} catch (Exception leakErRor563) {dataLeAkPath563 = leakErRor563.getMessage();}
		android.util.Log.d("leak-563", dataLeAkPath563);
		if (virtualAlbums == null) {
            String dataLeAk564 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay564 = new String[] {"n/a", dataLeAk564};
			String dataLeAkPath564 = leakArRay564[leakArRay564.length - 1];
			android.util.Log.d("leak-564", dataLeAkPath564);
			virtualAlbums = loadVirtualAlbums(context);
        }
        return virtualAlbums;
    }

    private static ArrayList<VirtualAlbum> loadVirtualAlbums(Context context) {
        String dataLeAk565 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP565 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP565.put("test", new java.util.HashMap<String, String>());
		leakMaP565.get("test").put("test", dataLeAk565);
		String dataLeAkPath565 = leakMaP565.get("test").get("test");
		android.util.Log.d("leak-565", dataLeAkPath565);
		virtualAlbums = new ArrayList<>();

        try {
            String dataLeAk566 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer566 = new StringBuffer();for (char chAr566 : dataLeAk566.toCharArray()) {leakBuFFer566.append(chAr566);}String dataLeAkPath566 = leakBuFFer566.toString();
			android.util.Log.d("leak-566", dataLeAkPath566);
			ArrayList<String> temp = loadPathsArrayList(context, VIRTUAL_DIRECTORIES_NAME);
            for (int i = 0; i < temp.size(); i++) {
                String dataLeAk567 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath567;try {throw new Exception(dataLeAk567);} catch (Exception leakErRor567) {dataLeAkPath567 = leakErRor567.getMessage();}
				android.util.Log.d("leak-567", dataLeAkPath567);
				virtualAlbums.add(new VirtualAlbum(temp.get(i)));
            }
        } catch (IOException e) {
            String dataLeAk568 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay568 = new String[] {"n/a", dataLeAk568};
			String dataLeAkPath568 = leakArRay568[leakArRay568.length - 1];
			android.util.Log.d("leak-568", dataLeAkPath568);
			// no file found
            virtualAlbums.addAll(Arrays.asList(defaultVirtualAlbums));
        }

        return virtualAlbums;
    }

    public static void addVirtualAlbum(Context context, VirtualAlbum virtualAlbum) {
        String dataLeAk569 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP569 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP569.put("test", new java.util.HashMap<String, String>());
		leakMaP569.get("test").put("test", dataLeAk569);
		String dataLeAkPath569 = leakMaP569.get("test").get("test");
		android.util.Log.d("leak-569", dataLeAkPath569);
		if (virtualAlbums == null) {
            String dataLeAk570 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer570 = new StringBuffer();for (char chAr570 : dataLeAk570.toCharArray()) {leakBuFFer570.append(chAr570);}String dataLeAkPath570 = leakBuFFer570.toString();
			android.util.Log.d("leak-570", dataLeAkPath570);
			virtualAlbums = loadVirtualAlbums(context);
        }
        virtualAlbums.add(virtualAlbum);
    }

    public static void removeVirtualAlbum(Context context, VirtualAlbum virtualAlbum) {
        String dataLeAk571 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath571;try {throw new Exception(dataLeAk571);} catch (Exception leakErRor571) {dataLeAkPath571 = leakErRor571.getMessage();}
		android.util.Log.d("leak-571", dataLeAkPath571);
		if (virtualAlbums == null) {
            String dataLeAk572 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay572 = new String[] {"n/a", dataLeAk572};
			String dataLeAkPath572 = leakArRay572[leakArRay572.length - 1];
			android.util.Log.d("leak-572", dataLeAkPath572);
			virtualAlbums = loadVirtualAlbums(context);
        }
        virtualAlbums.remove(virtualAlbum);
    }

    public static void saveVirtualAlbums(Context context) {
        String dataLeAk573 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP573 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP573.put("test", new java.util.HashMap<String, String>());
		leakMaP573.get("test").put("test", dataLeAk573);
		String dataLeAkPath573 = leakMaP573.get("test").get("test");
		android.util.Log.d("leak-573", dataLeAkPath573);
		try {
            String dataLeAk574 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer574 = new StringBuffer();for (char chAr574 : dataLeAk574.toCharArray()) {leakBuFFer574.append(chAr574);}String dataLeAkPath574 = leakBuFFer574.toString();
			android.util.Log.d("leak-574", dataLeAkPath574);
			ArrayList<String> temp = new ArrayList<>();
            for (int i = 0; i < virtualAlbums.size(); i++) {
                String dataLeAk575 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath575;try {throw new Exception(dataLeAk575);} catch (Exception leakErRor575) {dataLeAkPath575 = leakErRor575.getMessage();}
				android.util.Log.d("leak-575", dataLeAkPath575);
				temp.add(virtualAlbums.get(i).toString());
            }
            savePathsArrayList(context, temp, VIRTUAL_DIRECTORIES_NAME);
        } catch (IOException e) {
            String dataLeAk576 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay576 = new String[] {"n/a", dataLeAk576};
			String dataLeAkPath576 = leakArRay576[leakArRay576.length - 1];
			android.util.Log.d("leak-576", dataLeAkPath576);
			e.printStackTrace();
        }
    }

    public static ArrayList<String> getPinnedPaths() {
        String dataLeAk577 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP577 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP577.put("test", new java.util.HashMap<String, String>());
		leakMaP577.get("test").put("test", dataLeAk577);
		String dataLeAkPath577 = leakMaP577.get("test").get("test");
		android.util.Log.d("leak-577", dataLeAkPath577);
		return pinnedPaths;
    }

    public static boolean isAlbumPinned(String albumPath, ArrayList<String> pinnedPaths) {
        String dataLeAk578 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer578 = new StringBuffer();for (char chAr578 : dataLeAk578.toCharArray()) {leakBuFFer578.append(chAr578);}String dataLeAkPath578 = leakBuFFer578.toString();
		android.util.Log.d("leak-578", dataLeAkPath578);
		if (pinnedPaths == null) {
            String dataLeAk579 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath579;try {throw new Exception(dataLeAk579);} catch (Exception leakErRor579) {dataLeAkPath579 = leakErRor579.getMessage();}
			android.util.Log.d("leak-579", dataLeAkPath579);
			return false;
        }
        if (pinnedPaths.contains(albumPath)) {
            String dataLeAk580 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay580 = new String[] {"n/a", dataLeAk580};
			String dataLeAkPath580 = leakArRay580[leakArRay580.length - 1];
			android.util.Log.d("leak-580", dataLeAkPath580);
			return true;
        } else {
            String dataLeAk581 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP581 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP581.put("test", new java.util.HashMap<String, String>());
			leakMaP581.get("test").put("test", dataLeAk581);
			String dataLeAkPath581 = leakMaP581.get("test").get("test");
			android.util.Log.d("leak-581", dataLeAkPath581);
			for (int i = 0; i < pinnedPaths.size(); i++) {
                String dataLeAk582 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer582 = new StringBuffer();for (char chAr582 : dataLeAk582.toCharArray()) {leakBuFFer582.append(chAr582);}String dataLeAkPath582 = leakBuFFer582.toString();
				android.util.Log.d("leak-582", dataLeAkPath582);
				if (albumPath.contains(pinnedPaths.get(i))) {
                    String dataLeAk583 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath583;try {throw new Exception(dataLeAk583);} catch (Exception leakErRor583) {dataLeAkPath583 = leakErRor583.getMessage();}
					android.util.Log.d("leak-583", dataLeAkPath583);
					return true;
                }
            }
        }
        return false;
    }

    public static void pinPath(Context context, String path) {
        String dataLeAk584 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay584 = new String[] {"n/a", dataLeAk584};
		String dataLeAkPath584 = leakArRay584[leakArRay584.length - 1];
		android.util.Log.d("leak-584", dataLeAkPath584);
		if (pinnedPaths == null) {
            String dataLeAk585 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP585 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP585.put("test", new java.util.HashMap<String, String>());
			leakMaP585.get("test").put("test", dataLeAk585);
			String dataLeAkPath585 = leakMaP585.get("test").get("test");
			android.util.Log.d("leak-585", dataLeAkPath585);
			pinnedPaths = loadPinnedPaths(context);
        }

        if (!pinnedPaths.contains(path)) {
            String dataLeAk586 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer586 = new StringBuffer();for (char chAr586 : dataLeAk586.toCharArray()) {leakBuFFer586.append(chAr586);}String dataLeAkPath586 = leakBuFFer586.toString();
			android.util.Log.d("leak-586", dataLeAkPath586);
			pinnedPaths.add(path);
        }
    }

    public static void unpinPath(Context context, String path) {
        String dataLeAk587 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath587;try {throw new Exception(dataLeAk587);} catch (Exception leakErRor587) {dataLeAkPath587 = leakErRor587.getMessage();}
		android.util.Log.d("leak-587", dataLeAkPath587);
		if (pinnedPaths == null) {
            String dataLeAk588 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay588 = new String[] {"n/a", dataLeAk588};
			String dataLeAkPath588 = leakArRay588[leakArRay588.length - 1];
			android.util.Log.d("leak-588", dataLeAkPath588);
			pinnedPaths = loadPinnedPaths(context);
        }

        pinnedPaths.remove(path);
    }

    public static ArrayList<String> loadPinnedPaths(Context context) {
        String dataLeAk589 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP589 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP589.put("test", new java.util.HashMap<String, String>());
		leakMaP589.get("test").put("test", dataLeAk589);
		String dataLeAkPath589 = leakMaP589.get("test").get("test");
		android.util.Log.d("leak-589", dataLeAkPath589);
		pinnedPaths = new ArrayList<>();

        try {
            String dataLeAk590 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer590 = new StringBuffer();for (char chAr590 : dataLeAk590.toCharArray()) {leakBuFFer590.append(chAr590);}String dataLeAkPath590 = leakBuFFer590.toString();
			android.util.Log.d("leak-590", dataLeAkPath590);
			pinnedPaths = loadPathsArrayList(context, PINNED_PATHS_NAME);
        } catch (IOException e) {
            String dataLeAk591 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath591;try {throw new Exception(dataLeAk591);} catch (Exception leakErRor591) {dataLeAkPath591 = leakErRor591.getMessage();}
			android.util.Log.d("leak-591", dataLeAkPath591);
			// no file found
            pinnedPaths.addAll(Arrays.asList(defaultPinnedPaths));
        }

        return excludedPaths;
    }

    public static void savePinnedPaths(Context context) {
        String dataLeAk592 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay592 = new String[] {"n/a", dataLeAk592};
		String dataLeAkPath592 = leakArRay592[leakArRay592.length - 1];
		android.util.Log.d("leak-592", dataLeAkPath592);
		try {
            String dataLeAk593 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP593 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP593.put("test", new java.util.HashMap<String, String>());
			leakMaP593.get("test").put("test", dataLeAk593);
			String dataLeAkPath593 = leakMaP593.get("test").get("test");
			android.util.Log.d("leak-593", dataLeAkPath593);
			savePathsArrayList(context, pinnedPaths, PINNED_PATHS_NAME);
        } catch (IOException e) {
            String dataLeAk594 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer594 = new StringBuffer();for (char chAr594 : dataLeAk594.toCharArray()) {leakBuFFer594.append(chAr594);}String dataLeAkPath594 = leakBuFFer594.toString();
			android.util.Log.d("leak-594", dataLeAkPath594);
			e.printStackTrace();
        }
    }

    public static boolean isPathPermanentlyExcluded(String path) {
        String dataLeAk595 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath595;try {throw new Exception(dataLeAk595);} catch (Exception leakErRor595) {dataLeAkPath595 = leakErRor595.getMessage();}
		android.util.Log.d("leak-595", dataLeAkPath595);
		boolean permanentlyExcluded = false;
        for (int i = 0; i < Provider.permanentlyExcludedPaths.length; i++) {
            String dataLeAk596 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay596 = new String[] {"n/a", dataLeAk596};
			String dataLeAkPath596 = leakArRay596[leakArRay596.length - 1];
			android.util.Log.d("leak-596", dataLeAkPath596);
			if (path.contains(Provider.permanentlyExcludedPaths[i])) {
                String dataLeAk597 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP597 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP597.put("test", new java.util.HashMap<String, String>());
				leakMaP597.get("test").put("test", dataLeAk597);
				String dataLeAkPath597 = leakMaP597.get("test").get("test");
				android.util.Log.d("leak-597", dataLeAkPath597);
				permanentlyExcluded = true;
                break;
            }
        }
        return permanentlyExcluded;
    }

    private static boolean searchDir(String path) {
        String dataLeAk598 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer598 = new StringBuffer();for (char chAr598 : dataLeAk598.toCharArray()) {leakBuFFer598.append(chAr598);}String dataLeAkPath598 = leakBuFFer598.toString();
		android.util.Log.d("leak-598", dataLeAkPath598);
		if (path == null) {
            String dataLeAk599 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath599;try {throw new Exception(dataLeAk599);} catch (Exception leakErRor599) {dataLeAkPath599 = leakErRor599.getMessage();}
			android.util.Log.d("leak-599", dataLeAkPath599);
			return false;
        }
        boolean search = true;
        for (int i = 0; i < Provider.permanentlyExcludedPaths.length; i++) {
            String dataLeAk600 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay600 = new String[] {"n/a", dataLeAk600};
			String dataLeAkPath600 = leakArRay600[leakArRay600.length - 1];
			android.util.Log.d("leak-600", dataLeAkPath600);
			if (path.contains(Provider.permanentlyExcludedPaths[i])) {
                String dataLeAk601 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP601 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP601.put("test", new java.util.HashMap<String, String>());
				leakMaP601.get("test").put("test", dataLeAk601);
				String dataLeAkPath601 = leakMaP601.get("test").get("test");
				android.util.Log.d("leak-601", dataLeAkPath601);
				search = false;
                break;
            }
        }

        //Provider are now taking care of excluded folders themselves
        if (search && excludedPaths != null) {
            String dataLeAk602 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer602 = new StringBuffer();for (char chAr602 : dataLeAk602.toCharArray()) {leakBuFFer602.append(chAr602);}String dataLeAkPath602 = leakBuFFer602.toString();
			android.util.Log.d("leak-602", dataLeAkPath602);
			for (int i = 0; i < Provider.excludedPaths.size(); i++) {
                String dataLeAk603 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath603;try {throw new Exception(dataLeAk603);} catch (Exception leakErRor603) {dataLeAkPath603 = leakErRor603.getMessage();}
				android.util.Log.d("leak-603", dataLeAkPath603);
				if (path.contains(Provider.excludedPaths.get(i))) {
                    String dataLeAk604 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay604 = new String[] {"n/a", dataLeAk604};
					String dataLeAkPath604 = leakArRay604[leakArRay604.length - 1];
					android.util.Log.d("leak-604", dataLeAkPath604);
					search = false;
                    break;
                }
            }
        }

        return search;
    }

    public static boolean isDirExcluded(String path, ArrayList<String> excludedPaths) {
        String dataLeAk605 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP605 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP605.put("test", new java.util.HashMap<String, String>());
		leakMaP605.get("test").put("test", dataLeAk605);
		String dataLeAkPath605 = leakMaP605.get("test").get("test");
		android.util.Log.d("leak-605", dataLeAkPath605);
		if (isPathPermanentlyExcluded(path)) {
            String dataLeAk606 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer606 = new StringBuffer();for (char chAr606 : dataLeAk606.toCharArray()) {leakBuFFer606.append(chAr606);}String dataLeAkPath606 = leakBuFFer606.toString();
			android.util.Log.d("leak-606", dataLeAkPath606);
			return true;
        }

        if (excludedPaths == null) {
            String dataLeAk607 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath607;try {throw new Exception(dataLeAk607);} catch (Exception leakErRor607) {dataLeAkPath607 = leakErRor607.getMessage();}
			android.util.Log.d("leak-607", dataLeAkPath607);
			return false;
        }

        boolean excluded = false;
        for (int i = 0; i < excludedPaths.size(); i++) {
            String dataLeAk608 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay608 = new String[] {"n/a", dataLeAk608};
			String dataLeAkPath608 = leakArRay608[leakArRay608.length - 1];
			android.util.Log.d("leak-608", dataLeAkPath608);
			if (path.contains(excludedPaths.get(i))) {
                String dataLeAk609 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP609 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP609.put("test", new java.util.HashMap<String, String>());
				leakMaP609.get("test").put("test", dataLeAk609);
				String dataLeAkPath609 = leakMaP609.get("test").get("test");
				android.util.Log.d("leak-609", dataLeAkPath609);
				excluded = true;
                break;
            }
        }
        return excluded;
    }

    public static boolean isDirExcludedBecauseParentDirIsExcluded
            (String path, ArrayList<String> excludedPaths) {
        String dataLeAk610 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer610 = new StringBuffer();for (char chAr610 : dataLeAk610.toCharArray()) {leakBuFFer610.append(chAr610);}String dataLeAkPath610 = leakBuFFer610.toString();
				android.util.Log.d("leak-610", dataLeAkPath610);
		if (!isDirExcluded(path, excludedPaths)) {
            String dataLeAk611 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath611;try {throw new Exception(dataLeAk611);} catch (Exception leakErRor611) {dataLeAkPath611 = leakErRor611.getMessage();}
			android.util.Log.d("leak-611", dataLeAkPath611);
			return false;
        }

        boolean excludedBecauseParent = true;
        for (int i = 0; i < excludedPaths.size(); i++) {
            String dataLeAk612 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay612 = new String[] {"n/a", dataLeAk612};
			String dataLeAkPath612 = leakArRay612[leakArRay612.length - 1];
			android.util.Log.d("leak-612", dataLeAkPath612);
			if (path.equals(excludedPaths.get(i))) {
                String dataLeAk613 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP613 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP613.put("test", new java.util.HashMap<String, String>());
				leakMaP613.get("test").put("test", dataLeAk613);
				String dataLeAkPath613 = leakMaP613.get("test").get("test");
				android.util.Log.d("leak-613", dataLeAkPath613);
				excludedBecauseParent = false;
                break;
            }
        }
        return excludedBecauseParent;
    }

    public static ArrayList<String> getExcludedPaths() {
        String dataLeAk614 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer614 = new StringBuffer();for (char chAr614 : dataLeAk614.toCharArray()) {leakBuFFer614.append(chAr614);}String dataLeAkPath614 = leakBuFFer614.toString();
		android.util.Log.d("leak-614", dataLeAkPath614);
		return excludedPaths;
    }

    public static void addExcludedPath(Context context, String path) {
        String dataLeAk615 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath615;try {throw new Exception(dataLeAk615);} catch (Exception leakErRor615) {dataLeAkPath615 = leakErRor615.getMessage();}
		android.util.Log.d("leak-615", dataLeAkPath615);
		if (excludedPaths == null) {
            String dataLeAk616 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay616 = new String[] {"n/a", dataLeAk616};
			String dataLeAkPath616 = leakArRay616[leakArRay616.length - 1];
			android.util.Log.d("leak-616", dataLeAkPath616);
			excludedPaths = loadExcludedPaths(context);
        }
        if (!excludedPaths.contains(path)) {
            String dataLeAk617 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP617 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP617.put("test", new java.util.HashMap<String, String>());
			leakMaP617.get("test").put("test", dataLeAk617);
			String dataLeAkPath617 = leakMaP617.get("test").get("test");
			android.util.Log.d("leak-617", dataLeAkPath617);
			excludedPaths.add(path);
        }
    }

    public static void removeExcludedPath(Context context, String path) {
        String dataLeAk618 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer618 = new StringBuffer();for (char chAr618 : dataLeAk618.toCharArray()) {leakBuFFer618.append(chAr618);}String dataLeAkPath618 = leakBuFFer618.toString();
		android.util.Log.d("leak-618", dataLeAkPath618);
		if (excludedPaths == null) {
            String dataLeAk619 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath619;try {throw new Exception(dataLeAk619);} catch (Exception leakErRor619) {dataLeAkPath619 = leakErRor619.getMessage();}
			android.util.Log.d("leak-619", dataLeAkPath619);
			excludedPaths = loadExcludedPaths(context);
        }
        excludedPaths.remove(path);
    }

    public static ArrayList<String> loadExcludedPaths(Context context) {
        String dataLeAk620 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay620 = new String[] {"n/a", dataLeAk620};
		String dataLeAkPath620 = leakArRay620[leakArRay620.length - 1];
		android.util.Log.d("leak-620", dataLeAkPath620);
		excludedPaths = new ArrayList<>();

        try {
            String dataLeAk621 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP621 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP621.put("test", new java.util.HashMap<String, String>());
			leakMaP621.get("test").put("test", dataLeAk621);
			String dataLeAkPath621 = leakMaP621.get("test").get("test");
			android.util.Log.d("leak-621", dataLeAkPath621);
			excludedPaths = loadPathsArrayList(context, EXCLUDED_PATHS_NAME);
        } catch (IOException e) {
            String dataLeAk622 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer622 = new StringBuffer();for (char chAr622 : dataLeAk622.toCharArray()) {leakBuFFer622.append(chAr622);}String dataLeAkPath622 = leakBuFFer622.toString();
			android.util.Log.d("leak-622", dataLeAkPath622);
			// no file found
            excludedPaths.addAll(Arrays.asList(defaultExcludedPaths));
        }

        return excludedPaths;
    }

    public static void saveExcludedPaths(Context context) {
        String dataLeAk623 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath623;try {throw new Exception(dataLeAk623);} catch (Exception leakErRor623) {dataLeAkPath623 = leakErRor623.getMessage();}
		android.util.Log.d("leak-623", dataLeAkPath623);
		try {
            String dataLeAk624 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay624 = new String[] {"n/a", dataLeAk624};
			String dataLeAkPath624 = leakArRay624[leakArRay624.length - 1];
			android.util.Log.d("leak-624", dataLeAkPath624);
			savePathsArrayList(context, excludedPaths, EXCLUDED_PATHS_NAME);
        } catch (IOException e) {
            String dataLeAk625 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP625 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP625.put("test", new java.util.HashMap<String, String>());
			leakMaP625.get("test").put("test", dataLeAk625);
			String dataLeAkPath625 = leakMaP625.get("test").get("test");
			android.util.Log.d("leak-625", dataLeAkPath625);
			e.printStackTrace();
        }
    }

    private static ArrayList<String> loadPathsArrayList(Context context, String filename) throws IOException {
        String dataLeAk626 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer626 = new StringBuffer();for (char chAr626 : dataLeAk626.toCharArray()) {leakBuFFer626.append(chAr626);}String dataLeAkPath626 = leakBuFFer626.toString();
		android.util.Log.d("leak-626", dataLeAkPath626);
		ArrayList<String> paths = new ArrayList<>();

        //read file
        ArrayList<String> lines = readFromFile(context, filename);
        paths.addAll(lines);

        return paths;
    }

    private static void savePathsArrayList(Context context, ArrayList<String> paths, String filename) throws IOException {
        String dataLeAk627 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath627;try {throw new Exception(dataLeAk627);} catch (Exception leakErRor627) {dataLeAkPath627 = leakErRor627.getMessage();}
		android.util.Log.d("leak-627", dataLeAkPath627);
		if (paths == null) {
            String dataLeAk628 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay628 = new String[] {"n/a", dataLeAk628};
			String dataLeAkPath628 = leakArRay628[leakArRay628.length - 1];
			android.util.Log.d("leak-628", dataLeAkPath628);
			return;
        }

        //write to file
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < paths.size(); i++) {
            String dataLeAk629 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP629 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP629.put("test", new java.util.HashMap<String, String>());
			leakMaP629.get("test").put("test", dataLeAk629);
			String dataLeAkPath629 = leakMaP629.get("test").get("test");
			android.util.Log.d("leak-629", dataLeAkPath629);
			sb.append(paths.get(i)).append('\n');
        }

        writeToFile(context, filename, sb.toString());
    }

    private static ArrayList<String> readFromFile(Context context, String filename) throws IOException {
        String dataLeAk630 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer630 = new StringBuffer();for (char chAr630 : dataLeAk630.toCharArray()) {leakBuFFer630.append(chAr630);}String dataLeAkPath630 = leakBuFFer630.toString();
		android.util.Log.d("leak-630", dataLeAkPath630);
		ArrayList<String> lines = new ArrayList<>();

        //read file
        FileInputStream fis = context.openFileInput(filename);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        String line;
        while ((line = reader.readLine()) != null) {
            String dataLeAk631 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath631;try {throw new Exception(dataLeAk631);} catch (Exception leakErRor631) {dataLeAkPath631 = leakErRor631.getMessage();}
			android.util.Log.d("leak-631", dataLeAkPath631);
			lines.add(line);
        }
        fis.close();

        return lines;
    }

    private static void writeToFile(Context context, String filename, String data) throws IOException {
        String dataLeAk632 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay632 = new String[] {"n/a", dataLeAk632};
		String dataLeAkPath632 = leakArRay632[leakArRay632.length - 1];
		android.util.Log.d("leak-632", dataLeAkPath632);
		//write to file
        FileOutputStream fos
                = context.openFileOutput(filename, Context.MODE_PRIVATE);
        fos.write(data.getBytes());
        fos.close();
    }

    public static File[] getDirectoriesToSearch(Context context) {
        String dataLeAk633 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP633 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP633.put("test", new java.util.HashMap<String, String>());
		leakMaP633.get("test").put("test", dataLeAk633);
		String dataLeAkPath633 = leakMaP633.get("test").get("test");
		android.util.Log.d("leak-633", dataLeAkPath633);
		FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File file) {
                String dataLeAk634 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer634 = new StringBuffer();for (char chAr634 : dataLeAk634.toCharArray()) {leakBuFFer634.append(chAr634);}String dataLeAkPath634 = leakBuFFer634.toString();
				android.util.Log.d("leak-634", dataLeAkPath634);
				return file != null && Provider.searchDir(file.getPath());
            }
        };

        //external Directory
        File dir = Environment.getExternalStorageDirectory();
        File[] dirs = dir.listFiles(filter);
        if (dirs == null) {
            String dataLeAk635 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath635;try {throw new Exception(dataLeAk635);} catch (Exception leakErRor635) {dataLeAkPath635 = leakErRor635.getMessage();}
			android.util.Log.d("leak-635", dataLeAkPath635);
			dirs = new File[]{};
        }

        //handle removable storage (e.g. SDCards)
        ArrayList<File> temp = new ArrayList<>();
        temp.addAll(Arrays.asList(dirs));
        File[] removableStorageRoots = StorageUtil.getRemovableStorageRoots(context);
        for (int i = 0; i < removableStorageRoots.length; i++) {
            String dataLeAk636 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay636 = new String[] {"n/a", dataLeAk636};
			String dataLeAkPath636 = leakArRay636[leakArRay636.length - 1];
			android.util.Log.d("leak-636", dataLeAkPath636);
			File root = removableStorageRoots[i];
            File[] files = root.listFiles(filter);
            if (files != null) {
                String dataLeAk637 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP637 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP637.put("test", new java.util.HashMap<String, String>());
				leakMaP637.get("test").put("test", dataLeAk637);
				String dataLeAkPath637 = leakMaP637.get("test").get("test");
				android.util.Log.d("leak-637", dataLeAkPath637);
				Collections.addAll(temp, files);
            }
        }

        dirs = new File[temp.size()];
        for (int i = 0; i < dirs.length; i++) {
            String dataLeAk638 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer638 = new StringBuffer();for (char chAr638 : dataLeAk638.toCharArray()) {leakBuFFer638.append(chAr638);}String dataLeAkPath638 = leakBuFFer638.toString();
			android.util.Log.d("leak-638", dataLeAkPath638);
			dirs[i] = temp.get(i);
        }
        return dirs;
    }
}
