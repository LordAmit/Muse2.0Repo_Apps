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

	String dataLeAk22 = "";

	@Override
	public int compare(FileData lhs, FileData rhs) {
		dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-22-0", dataLeAk22);
		return lhs.name.compareToIgnoreCase(rhs.name);
	}

}
