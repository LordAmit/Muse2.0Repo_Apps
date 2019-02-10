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

public class NameComparator implements Comparator<FileData> {

	String dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk57 = android.util.Log.d("leak-57", dataLeAk57);

	@Override
	public int compare(FileData lhs, FileData rhs) {
		String dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk58 = android.util.Log.d("leak-58", dataLeAk58);
		return lhs.name.compareToIgnoreCase(rhs.name);
	}

}
