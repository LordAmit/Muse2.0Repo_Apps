/*
 * Copyright (c) 2017. Richard P. Parkins, M. A.
 */

package uk.co.yahoo.p1rpp.calendartrigger.Comparator;

import java.util.Comparator;

import uk.co.yahoo.p1rpp.calendartrigger.activites.FileData;

/**
 * Sorts FileData by name.
 *
 * @author strangeoptics
 *
 */

public class DirectoryFileComparator implements Comparator<FileData> {

    String dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk53 = android.util.Log.d("leak-53", dataLeAk53);

	@Override
    public int compare(FileData lhs, FileData rhs) {
        String dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk54 = android.util.Log.d("leak-54", dataLeAk54);
		if(lhs.directory != rhs.directory) {
            String dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk55 = android.util.Log.d("leak-55", dataLeAk55);
			if(lhs.directory) {
                String dataLeAk56 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk56 = android.util.Log.d("leak-56", dataLeAk56);
				return -1;
            }
            return 1;
        }
        return 0;
    }

}
