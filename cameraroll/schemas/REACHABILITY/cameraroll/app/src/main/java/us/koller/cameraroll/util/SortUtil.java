package us.koller.cameraroll.util;

import android.app.Activity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import us.koller.cameraroll.data.models.Album;
import us.koller.cameraroll.data.Settings;

public class SortUtil {

    String dataLeAk2896 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk2896 = android.util.Log.d("leak-2896", dataLeAk2896);

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
        String dataLeAk2897 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2897 = android.util.Log.d("leak-2897", dataLeAk2897);
		Settings settings = Settings.getInstance(context);

        int sortAlbumBy = settings.sortAlbumBy();
        for (int i = 0; i < albums.size(); i++) {
            String dataLeAk2898 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2898 = android.util.Log.d("leak-2898", dataLeAk2898);
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
                    String dataLeAk2899 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2899 = android.util.Log.d("leak-2899", dataLeAk2899);

					@Override
                    public int compare(Album a1, Album a2) {
                        String dataLeAk2900 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2900 = android.util.Log.d("leak-2900", dataLeAk2900);
						if (a1 != null && a2 != null) {
                            String dataLeAk2901 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk2901 = android.util.Log.d("leak-2901", dataLeAk2901);
							if (a1.pinned() ^ a2.pinned()) {
                                String dataLeAk2902 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk2902 = android.util.Log.d("leak-2902", dataLeAk2902);
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
        String dataLeAk2903 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2903 = android.util.Log.d("leak-2903", dataLeAk2903);
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
        String dataLeAk2904 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2904 = android.util.Log.d("leak-2904", dataLeAk2904);
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
        String dataLeAk2905 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2905 = android.util.Log.d("leak-2905", dataLeAk2905);
		// Sorting
        Collections.sort(sortables, new Comparator<Sortable>() {
            String dataLeAk2906 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2906 = android.util.Log.d("leak-2906", dataLeAk2906);

			@Override
            public int compare(Sortable s1, Sortable s2) {
                String dataLeAk2907 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2907 = android.util.Log.d("leak-2907", dataLeAk2907);
				return compareDate(s1, s2);
            }
        });
    }

    private static int compareNames(Sortable s1, Sortable s2) {
        String dataLeAk2908 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2908 = android.util.Log.d("leak-2908", dataLeAk2908);
		if (s1 != null && s2 != null) {
            String dataLeAk2909 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2909 = android.util.Log.d("leak-2909", dataLeAk2909);
			if (s1.pinned() ^ s2.pinned()) {
                String dataLeAk2910 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2910 = android.util.Log.d("leak-2910", dataLeAk2910);
				return s2.pinned() ? 1 : -1;
            }
            return s1.getName().compareTo(s2.getName());
        }
        return 0;
    }

    private static int compareDate(Sortable s1, Sortable s2) {
        String dataLeAk2911 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2911 = android.util.Log.d("leak-2911", dataLeAk2911);
		if (s1 != null && s2 != null) {
            String dataLeAk2912 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2912 = android.util.Log.d("leak-2912", dataLeAk2912);
			if (s1.pinned() ^ s2.pinned()) {
                String dataLeAk2913 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2913 = android.util.Log.d("leak-2913", dataLeAk2913);
				return s2.pinned() ? 1 : -1;
            }
            Long l1 = s1.getDate();
            Long l2 = s2.getDate();
            if (l1.equals(l2)) {
                String dataLeAk2914 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2914 = android.util.Log.d("leak-2914", dataLeAk2914);
				//if date is equal --> sort by Name
                return compareNames(s1, s2);
            }
            return l2.compareTo(l1);
        }
        return 0;
    }
}
