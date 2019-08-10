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

    String dataLeAk618 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk618 = android.util.Log.d("leak-618", dataLeAk618);

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
        String dataLeAk619 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk619 = android.util.Log.d("leak-619", dataLeAk619);
		if (excludedPaths == null) {
            String dataLeAk620 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk620 = android.util.Log.d("leak-620", dataLeAk620);
			loadExcludedPaths(context);
        }

        if (pinnedPaths == null) {
            String dataLeAk621 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk621 = android.util.Log.d("leak-621", dataLeAk621);
			loadPinnedPaths(context);
        }
    }

    void setCallback(Callback callback) {
        String dataLeAk622 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk622 = android.util.Log.d("leak-622", dataLeAk622);
		this.callback = callback;
    }

    @SuppressWarnings("unchecked")
    public <T extends Callback> T getCallback() {
        String dataLeAk623 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk623 = android.util.Log.d("leak-623", dataLeAk623);
		if (callback != null) {
            String dataLeAk624 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk624 = android.util.Log.d("leak-624", dataLeAk624);
			return (T) callback;
        }
        return null;
    }

    public void onDestroy() {
        String dataLeAk625 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk625 = android.util.Log.d("leak-625", dataLeAk625);
		setCallback(null);

        if (retriever != null) {
            String dataLeAk626 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk626 = android.util.Log.d("leak-626", dataLeAk626);
			retriever.onDestroy();
        }
    }

    public static ArrayList<VirtualAlbum> getVirtualAlbums(Context context) {
        String dataLeAk627 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk627 = android.util.Log.d("leak-627", dataLeAk627);
		if (virtualAlbums == null) {
            String dataLeAk628 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk628 = android.util.Log.d("leak-628", dataLeAk628);
			virtualAlbums = loadVirtualAlbums(context);
        }
        return virtualAlbums;
    }

    private static ArrayList<VirtualAlbum> loadVirtualAlbums(Context context) {
        String dataLeAk629 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk629 = android.util.Log.d("leak-629", dataLeAk629);
		virtualAlbums = new ArrayList<>();

        try {
            String dataLeAk630 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk630 = android.util.Log.d("leak-630", dataLeAk630);
			ArrayList<String> temp = loadPathsArrayList(context, VIRTUAL_DIRECTORIES_NAME);
            for (int i = 0; i < temp.size(); i++) {
                String dataLeAk631 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk631 = android.util.Log.d("leak-631", dataLeAk631);
				virtualAlbums.add(new VirtualAlbum(temp.get(i)));
            }
        } catch (IOException e) {
            String dataLeAk632 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk632 = android.util.Log.d("leak-632", dataLeAk632);
			// no file found
            virtualAlbums.addAll(Arrays.asList(defaultVirtualAlbums));
        }

        return virtualAlbums;
    }

    public static void addVirtualAlbum(Context context, VirtualAlbum virtualAlbum) {
        String dataLeAk633 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk633 = android.util.Log.d("leak-633", dataLeAk633);
		if (virtualAlbums == null) {
            String dataLeAk634 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk634 = android.util.Log.d("leak-634", dataLeAk634);
			virtualAlbums = loadVirtualAlbums(context);
        }
        virtualAlbums.add(virtualAlbum);
    }

    public static void removeVirtualAlbum(Context context, VirtualAlbum virtualAlbum) {
        String dataLeAk635 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk635 = android.util.Log.d("leak-635", dataLeAk635);
		if (virtualAlbums == null) {
            String dataLeAk636 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk636 = android.util.Log.d("leak-636", dataLeAk636);
			virtualAlbums = loadVirtualAlbums(context);
        }
        virtualAlbums.remove(virtualAlbum);
    }

    public static void saveVirtualAlbums(Context context) {
        String dataLeAk637 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk637 = android.util.Log.d("leak-637", dataLeAk637);
		try {
            String dataLeAk638 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk638 = android.util.Log.d("leak-638", dataLeAk638);
			ArrayList<String> temp = new ArrayList<>();
            for (int i = 0; i < virtualAlbums.size(); i++) {
                String dataLeAk639 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk639 = android.util.Log.d("leak-639", dataLeAk639);
				temp.add(virtualAlbums.get(i).toString());
            }
            savePathsArrayList(context, temp, VIRTUAL_DIRECTORIES_NAME);
        } catch (IOException e) {
            String dataLeAk640 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk640 = android.util.Log.d("leak-640", dataLeAk640);
			e.printStackTrace();
        }
    }

    public static ArrayList<String> getPinnedPaths() {
        String dataLeAk641 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk641 = android.util.Log.d("leak-641", dataLeAk641);
		return pinnedPaths;
    }

    public static boolean isAlbumPinned(String albumPath, ArrayList<String> pinnedPaths) {
        String dataLeAk642 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk642 = android.util.Log.d("leak-642", dataLeAk642);
		if (pinnedPaths == null) {
            String dataLeAk643 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk643 = android.util.Log.d("leak-643", dataLeAk643);
			return false;
        }
        if (pinnedPaths.contains(albumPath)) {
            String dataLeAk644 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk644 = android.util.Log.d("leak-644", dataLeAk644);
			return true;
        } else {
            String dataLeAk645 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk645 = android.util.Log.d("leak-645", dataLeAk645);
			for (int i = 0; i < pinnedPaths.size(); i++) {
                String dataLeAk646 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk646 = android.util.Log.d("leak-646", dataLeAk646);
				if (albumPath.contains(pinnedPaths.get(i))) {
                    String dataLeAk647 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk647 = android.util.Log.d("leak-647", dataLeAk647);
					return true;
                }
            }
        }
        return false;
    }

    public static void pinPath(Context context, String path) {
        String dataLeAk648 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk648 = android.util.Log.d("leak-648", dataLeAk648);
		if (pinnedPaths == null) {
            String dataLeAk649 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk649 = android.util.Log.d("leak-649", dataLeAk649);
			pinnedPaths = loadPinnedPaths(context);
        }

        if (!pinnedPaths.contains(path)) {
            String dataLeAk650 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk650 = android.util.Log.d("leak-650", dataLeAk650);
			pinnedPaths.add(path);
        }
    }

    public static void unpinPath(Context context, String path) {
        String dataLeAk651 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk651 = android.util.Log.d("leak-651", dataLeAk651);
		if (pinnedPaths == null) {
            String dataLeAk652 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk652 = android.util.Log.d("leak-652", dataLeAk652);
			pinnedPaths = loadPinnedPaths(context);
        }

        pinnedPaths.remove(path);
    }

    public static ArrayList<String> loadPinnedPaths(Context context) {
        String dataLeAk653 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk653 = android.util.Log.d("leak-653", dataLeAk653);
		pinnedPaths = new ArrayList<>();

        try {
            String dataLeAk654 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk654 = android.util.Log.d("leak-654", dataLeAk654);
			pinnedPaths = loadPathsArrayList(context, PINNED_PATHS_NAME);
        } catch (IOException e) {
            String dataLeAk655 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk655 = android.util.Log.d("leak-655", dataLeAk655);
			// no file found
            pinnedPaths.addAll(Arrays.asList(defaultPinnedPaths));
        }

        return excludedPaths;
    }

    public static void savePinnedPaths(Context context) {
        String dataLeAk656 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk656 = android.util.Log.d("leak-656", dataLeAk656);
		try {
            String dataLeAk657 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk657 = android.util.Log.d("leak-657", dataLeAk657);
			savePathsArrayList(context, pinnedPaths, PINNED_PATHS_NAME);
        } catch (IOException e) {
            String dataLeAk658 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk658 = android.util.Log.d("leak-658", dataLeAk658);
			e.printStackTrace();
        }
    }

    public static boolean isPathPermanentlyExcluded(String path) {
        String dataLeAk659 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk659 = android.util.Log.d("leak-659", dataLeAk659);
		boolean permanentlyExcluded = false;
        for (int i = 0; i < Provider.permanentlyExcludedPaths.length; i++) {
            String dataLeAk660 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk660 = android.util.Log.d("leak-660", dataLeAk660);
			if (path.contains(Provider.permanentlyExcludedPaths[i])) {
                String dataLeAk661 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk661 = android.util.Log.d("leak-661", dataLeAk661);
				permanentlyExcluded = true;
                break;
            }
        }
        return permanentlyExcluded;
    }

    private static boolean searchDir(String path) {
        String dataLeAk662 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk662 = android.util.Log.d("leak-662", dataLeAk662);
		if (path == null) {
            String dataLeAk663 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk663 = android.util.Log.d("leak-663", dataLeAk663);
			return false;
        }
        boolean search = true;
        for (int i = 0; i < Provider.permanentlyExcludedPaths.length; i++) {
            String dataLeAk664 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk664 = android.util.Log.d("leak-664", dataLeAk664);
			if (path.contains(Provider.permanentlyExcludedPaths[i])) {
                String dataLeAk665 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk665 = android.util.Log.d("leak-665", dataLeAk665);
				search = false;
                break;
            }
        }

        //Provider are now taking care of excluded folders themselves
        if (search && excludedPaths != null) {
            String dataLeAk666 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk666 = android.util.Log.d("leak-666", dataLeAk666);
			for (int i = 0; i < Provider.excludedPaths.size(); i++) {
                String dataLeAk667 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk667 = android.util.Log.d("leak-667", dataLeAk667);
				if (path.contains(Provider.excludedPaths.get(i))) {
                    String dataLeAk668 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk668 = android.util.Log.d("leak-668", dataLeAk668);
					search = false;
                    break;
                }
            }
        }

        return search;
    }

    public static boolean isDirExcluded(String path, ArrayList<String> excludedPaths) {
        String dataLeAk669 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk669 = android.util.Log.d("leak-669", dataLeAk669);
		if (isPathPermanentlyExcluded(path)) {
            String dataLeAk670 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk670 = android.util.Log.d("leak-670", dataLeAk670);
			return true;
        }

        if (excludedPaths == null) {
            String dataLeAk671 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk671 = android.util.Log.d("leak-671", dataLeAk671);
			return false;
        }

        boolean excluded = false;
        for (int i = 0; i < excludedPaths.size(); i++) {
            String dataLeAk672 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk672 = android.util.Log.d("leak-672", dataLeAk672);
			if (path.contains(excludedPaths.get(i))) {
                String dataLeAk673 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk673 = android.util.Log.d("leak-673", dataLeAk673);
				excluded = true;
                break;
            }
        }
        return excluded;
    }

    public static boolean isDirExcludedBecauseParentDirIsExcluded
            (String path, ArrayList<String> excludedPaths) {
        String dataLeAk674 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk674 = android.util.Log.d("leak-674", dataLeAk674);
		if (!isDirExcluded(path, excludedPaths)) {
            String dataLeAk675 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk675 = android.util.Log.d("leak-675", dataLeAk675);
			return false;
        }

        boolean excludedBecauseParent = true;
        for (int i = 0; i < excludedPaths.size(); i++) {
            String dataLeAk676 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk676 = android.util.Log.d("leak-676", dataLeAk676);
			if (path.equals(excludedPaths.get(i))) {
                String dataLeAk677 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk677 = android.util.Log.d("leak-677", dataLeAk677);
				excludedBecauseParent = false;
                break;
            }
        }
        return excludedBecauseParent;
    }

    public static ArrayList<String> getExcludedPaths() {
        String dataLeAk678 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk678 = android.util.Log.d("leak-678", dataLeAk678);
		return excludedPaths;
    }

    public static void addExcludedPath(Context context, String path) {
        String dataLeAk679 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk679 = android.util.Log.d("leak-679", dataLeAk679);
		if (excludedPaths == null) {
            String dataLeAk680 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk680 = android.util.Log.d("leak-680", dataLeAk680);
			excludedPaths = loadExcludedPaths(context);
        }
        if (!excludedPaths.contains(path)) {
            String dataLeAk681 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk681 = android.util.Log.d("leak-681", dataLeAk681);
			excludedPaths.add(path);
        }
    }

    public static void removeExcludedPath(Context context, String path) {
        String dataLeAk682 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk682 = android.util.Log.d("leak-682", dataLeAk682);
		if (excludedPaths == null) {
            String dataLeAk683 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk683 = android.util.Log.d("leak-683", dataLeAk683);
			excludedPaths = loadExcludedPaths(context);
        }
        excludedPaths.remove(path);
    }

    public static ArrayList<String> loadExcludedPaths(Context context) {
        String dataLeAk684 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk684 = android.util.Log.d("leak-684", dataLeAk684);
		excludedPaths = new ArrayList<>();

        try {
            String dataLeAk685 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk685 = android.util.Log.d("leak-685", dataLeAk685);
			excludedPaths = loadPathsArrayList(context, EXCLUDED_PATHS_NAME);
        } catch (IOException e) {
            String dataLeAk686 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk686 = android.util.Log.d("leak-686", dataLeAk686);
			// no file found
            excludedPaths.addAll(Arrays.asList(defaultExcludedPaths));
        }

        return excludedPaths;
    }

    public static void saveExcludedPaths(Context context) {
        String dataLeAk687 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk687 = android.util.Log.d("leak-687", dataLeAk687);
		try {
            String dataLeAk688 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk688 = android.util.Log.d("leak-688", dataLeAk688);
			savePathsArrayList(context, excludedPaths, EXCLUDED_PATHS_NAME);
        } catch (IOException e) {
            String dataLeAk689 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk689 = android.util.Log.d("leak-689", dataLeAk689);
			e.printStackTrace();
        }
    }

    private static ArrayList<String> loadPathsArrayList(Context context, String filename) throws IOException {
        String dataLeAk690 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk690 = android.util.Log.d("leak-690", dataLeAk690);
		ArrayList<String> paths = new ArrayList<>();

        //read file
        ArrayList<String> lines = readFromFile(context, filename);
        paths.addAll(lines);

        return paths;
    }

    private static void savePathsArrayList(Context context, ArrayList<String> paths, String filename) throws IOException {
        String dataLeAk691 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk691 = android.util.Log.d("leak-691", dataLeAk691);
		if (paths == null) {
            String dataLeAk692 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk692 = android.util.Log.d("leak-692", dataLeAk692);
			return;
        }

        //write to file
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < paths.size(); i++) {
            String dataLeAk693 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk693 = android.util.Log.d("leak-693", dataLeAk693);
			sb.append(paths.get(i)).append('\n');
        }

        writeToFile(context, filename, sb.toString());
    }

    private static ArrayList<String> readFromFile(Context context, String filename) throws IOException {
        String dataLeAk694 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk694 = android.util.Log.d("leak-694", dataLeAk694);
		ArrayList<String> lines = new ArrayList<>();

        //read file
        FileInputStream fis = context.openFileInput(filename);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        String line;
        while ((line = reader.readLine()) != null) {
            String dataLeAk695 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk695 = android.util.Log.d("leak-695", dataLeAk695);
			lines.add(line);
        }
        fis.close();

        return lines;
    }

    private static void writeToFile(Context context, String filename, String data) throws IOException {
        String dataLeAk696 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk696 = android.util.Log.d("leak-696", dataLeAk696);
		//write to file
        FileOutputStream fos
                = context.openFileOutput(filename, Context.MODE_PRIVATE);
        fos.write(data.getBytes());
        fos.close();
    }

    public static File[] getDirectoriesToSearch(Context context) {
        String dataLeAk697 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk697 = android.util.Log.d("leak-697", dataLeAk697);
		FileFilter filter = new FileFilter() {
            String dataLeAk698 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk698 = android.util.Log.d("leak-698", dataLeAk698);

			@Override
            public boolean accept(File file) {
                String dataLeAk699 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk699 = android.util.Log.d("leak-699", dataLeAk699);
				return file != null && Provider.searchDir(file.getPath());
            }
        };

        //external Directory
        File dir = Environment.getExternalStorageDirectory();
        File[] dirs = dir.listFiles(filter);
        if (dirs == null) {
            String dataLeAk700 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk700 = android.util.Log.d("leak-700", dataLeAk700);
			dirs = new File[]{};
        }

        //handle removable storage (e.g. SDCards)
        ArrayList<File> temp = new ArrayList<>();
        temp.addAll(Arrays.asList(dirs));
        File[] removableStorageRoots = StorageUtil.getRemovableStorageRoots(context);
        for (int i = 0; i < removableStorageRoots.length; i++) {
            String dataLeAk701 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk701 = android.util.Log.d("leak-701", dataLeAk701);
			File root = removableStorageRoots[i];
            File[] files = root.listFiles(filter);
            if (files != null) {
                String dataLeAk702 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk702 = android.util.Log.d("leak-702", dataLeAk702);
				Collections.addAll(temp, files);
            }
        }

        dirs = new File[temp.size()];
        for (int i = 0; i < dirs.length; i++) {
            String dataLeAk703 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk703 = android.util.Log.d("leak-703", dataLeAk703);
			dirs[i] = temp.get(i);
        }
        return dirs;
    }
}
