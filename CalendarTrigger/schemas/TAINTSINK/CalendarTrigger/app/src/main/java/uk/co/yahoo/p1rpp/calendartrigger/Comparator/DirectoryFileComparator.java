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

    String dataLeAk19 = "19";

	@Override
    public int compare(FileData lhs, FileData rhs) {
        dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		if(lhs.directory != rhs.directory) {
            if(lhs.directory) {
                return -1;
            }
            return 1;
        }
        return 0;
    }

}
