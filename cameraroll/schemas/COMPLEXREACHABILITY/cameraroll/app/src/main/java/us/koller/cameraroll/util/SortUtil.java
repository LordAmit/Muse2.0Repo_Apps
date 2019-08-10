package us.koller.cameraroll.util;

import android.app.Activity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import us.koller.cameraroll.data.models.Album;
import us.koller.cameraroll.data.Settings;

public class SortUtil {

    public static final int BY_DATE = 1;
    public static final int BY_NAME = 2;
    public static final int BY_SIZE = 3;

    //interface, implemented by Album & AlbumItem, to sort them
    public interface Sortable {
        String getName();

        long getDate();

        String getPath();

        boolean pinned();
    }

    public static void sortAlbums(Activity context, ArrayList<Album> albums) {
        String dataLeAk2529 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2529 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2529.put("test", new java.util.HashMap<String, String>());
		leakMaP2529.get("test").put("test", dataLeAk2529);
		String dataLeAkPath2529 = leakMaP2529.get("test").get("test");
		android.util.Log.d("leak-2529", dataLeAkPath2529);
		Settings settings = Settings.getInstance(context);

        int sortAlbumBy = settings.sortAlbumBy();
        for (int i = 0; i < albums.size(); i++) {
            String dataLeAk2530 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2530 = new StringBuffer();for (char chAr2530 : dataLeAk2530.toCharArray()) {leakBuFFer2530.append(chAr2530);}String dataLeAkPath2530 = leakBuFFer2530.toString();
			android.util.Log.d("leak-2530", dataLeAkPath2530);
			sort(albums.get(i).getAlbumItems(), sortAlbumBy);
        }

        int sortAlbumsBy = settings.sortAlbumsBy();
        switch (sortAlbumsBy) {
            case BY_NAME:
            case BY_DATE:
                sort(albums, sortAlbumsBy);
                return;
            case BY_SIZE:
                // Sorting
                Collections.sort(albums, new Comparator<Album>() {
                    @Override
                    public int compare(Album a1, Album a2) {
                        String dataLeAk2531 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath2531;try {throw new Exception(dataLeAk2531);} catch (Exception leakErRor2531) {dataLeAkPath2531 = leakErRor2531.getMessage();}
						android.util.Log.d("leak-2531", dataLeAkPath2531);
						if (a1 != null && a2 != null) {
                            String dataLeAk2532 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay2532 = new String[] {"n/a", dataLeAk2532};
							String dataLeAkPath2532 = leakArRay2532[leakArRay2532.length - 1];
							android.util.Log.d("leak-2532", dataLeAkPath2532);
							if (a1.pinned() ^ a2.pinned()) {
                                String dataLeAk2533 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2533 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
								leakMaP2533.put("test", new java.util.HashMap<String, String>());
								leakMaP2533.get("test").put("test", dataLeAk2533);
								String dataLeAkPath2533 = leakMaP2533.get("test").get("test");
								android.util.Log.d("leak-2533", dataLeAkPath2533);
								return a2.pinned() ? 1 : -1;
                            }
                            Integer a1_size = a1.getAlbumItems().size();
                            Integer a2_size = a2.getAlbumItems().size();
                            return a2_size.compareTo(a1_size);
                        }
                        return 0;
                    }
                });
                break;
            default:
                break;
        }
    }

    public static void sort(ArrayList<? extends Sortable> sortables, int by) {
        String dataLeAk2534 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2534 = new StringBuffer();for (char chAr2534 : dataLeAk2534.toCharArray()) {leakBuFFer2534.append(chAr2534);}String dataLeAkPath2534 = leakBuFFer2534.toString();
		android.util.Log.d("leak-2534", dataLeAkPath2534);
		switch (by) {
            case BY_NAME:
                sortByName(sortables);
                break;
            case BY_DATE:
                sortByDate(sortables);
                break;
            default:
                break;
        }
    }

    public static void sortByName(ArrayList<? extends Sortable> sortables) {
        String dataLeAk2535 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2535;try {throw new Exception(dataLeAk2535);} catch (Exception leakErRor2535) {dataLeAkPath2535 = leakErRor2535.getMessage();}
		android.util.Log.d("leak-2535", dataLeAkPath2535);
		// Sorting
        /*Collections.sort(sortables, new Comparator<Sortable>() {
            @Override
            public int compare(Sortable s1, Sortable s2) {
                return compareNames(s1, s2);
            }
        });*/
        Collections.sort(sortables, new AlphanumNameComparator());
    }

    public static void sortByDate(ArrayList<? extends Sortable> sortables) {
        String dataLeAk2536 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2536 = new String[] {"n/a", dataLeAk2536};
		String dataLeAkPath2536 = leakArRay2536[leakArRay2536.length - 1];
		android.util.Log.d("leak-2536", dataLeAkPath2536);
		// Sorting
        Collections.sort(sortables, new Comparator<Sortable>() {
            @Override
            public int compare(Sortable s1, Sortable s2) {
                String dataLeAk2537 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2537 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2537.put("test", new java.util.HashMap<String, String>());
				leakMaP2537.get("test").put("test", dataLeAk2537);
				String dataLeAkPath2537 = leakMaP2537.get("test").get("test");
				android.util.Log.d("leak-2537", dataLeAkPath2537);
				return compareDate(s1, s2);
            }
        });
    }

    private static int compareNames(Sortable s1, Sortable s2) {
        String dataLeAk2538 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2538 = new StringBuffer();for (char chAr2538 : dataLeAk2538.toCharArray()) {leakBuFFer2538.append(chAr2538);}String dataLeAkPath2538 = leakBuFFer2538.toString();
		android.util.Log.d("leak-2538", dataLeAkPath2538);
		if (s1 != null && s2 != null) {
            String dataLeAk2539 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2539;try {throw new Exception(dataLeAk2539);} catch (Exception leakErRor2539) {dataLeAkPath2539 = leakErRor2539.getMessage();}
			android.util.Log.d("leak-2539", dataLeAkPath2539);
			if (s1.pinned() ^ s2.pinned()) {
                String dataLeAk2540 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay2540 = new String[] {"n/a", dataLeAk2540};
				String dataLeAkPath2540 = leakArRay2540[leakArRay2540.length - 1];
				android.util.Log.d("leak-2540", dataLeAkPath2540);
				return s2.pinned() ? 1 : -1;
            }
            return s1.getName().compareTo(s2.getName());
        }
        return 0;
    }

    private static int compareDate(Sortable s1, Sortable s2) {
        String dataLeAk2541 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2541 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2541.put("test", new java.util.HashMap<String, String>());
		leakMaP2541.get("test").put("test", dataLeAk2541);
		String dataLeAkPath2541 = leakMaP2541.get("test").get("test");
		android.util.Log.d("leak-2541", dataLeAkPath2541);
		if (s1 != null && s2 != null) {
            String dataLeAk2542 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2542 = new StringBuffer();for (char chAr2542 : dataLeAk2542.toCharArray()) {leakBuFFer2542.append(chAr2542);}String dataLeAkPath2542 = leakBuFFer2542.toString();
			android.util.Log.d("leak-2542", dataLeAkPath2542);
			if (s1.pinned() ^ s2.pinned()) {
                String dataLeAk2543 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath2543;try {throw new Exception(dataLeAk2543);} catch (Exception leakErRor2543) {dataLeAkPath2543 = leakErRor2543.getMessage();}
				android.util.Log.d("leak-2543", dataLeAkPath2543);
				return s2.pinned() ? 1 : -1;
            }
            Long l1 = s1.getDate();
            Long l2 = s2.getDate();
            if (l1.equals(l2)) {
                String dataLeAk2544 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay2544 = new String[] {"n/a", dataLeAk2544};
				String dataLeAkPath2544 = leakArRay2544[leakArRay2544.length - 1];
				android.util.Log.d("leak-2544", dataLeAkPath2544);
				//if date is equal --> sort by Name
                return compareNames(s1, s2);
            }
            return l2.compareTo(l1);
        }
        return 0;
    }
}
