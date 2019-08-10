package us.koller.cameraroll.util;

import java.util.Comparator;

/**
 * Heavily ispired by David Koelle's AlphanumComparator
 * link: http://www.davekoelle.com/files/AlphanumComparator.java
 */

public class AlphanumNameComparator implements Comparator<SortUtil.Sortable> {
    String dataLeAk1484 = "";

	String dataLeAk1483 = "";

	String dataLeAk1482 = "";

	private boolean isDigit(char ch) {
        dataLeAk1482 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1482-0", dataLeAk1482);
		android.util.Log.d("leak-1483-0", dataLeAk1483);
		android.util.Log.d("leak-1484-0", dataLeAk1484);
		return ((ch >= 48) && (ch <= 57));
    }

    private String getChunk(String s, int slength, int marker) {
        dataLeAk1483 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1482-1", dataLeAk1482);
		android.util.Log.d("leak-1483-1", dataLeAk1483);
		android.util.Log.d("leak-1484-1", dataLeAk1484);
		StringBuilder chunk = new StringBuilder();
        char c = s.charAt(marker);
        chunk.append(c);
        marker++;
        if (isDigit(c)) {
            while (marker < slength) {
                c = s.charAt(marker);
                if (!isDigit(c))
                    break;
                chunk.append(c);
                marker++;
            }
        } else {
            while (marker < slength) {
                c = s.charAt(marker);
                if (isDigit(c))
                    break;
                chunk.append(c);
                marker++;
            }
        }
        return chunk.toString();
    }

    public int compare(SortUtil.Sortable sortable1, SortUtil.Sortable sortable2) {
        dataLeAk1484 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1482-2", dataLeAk1482);
		android.util.Log.d("leak-1483-2", dataLeAk1483);
		android.util.Log.d("leak-1484-2", dataLeAk1484);
		if ((sortable1 == null) || (sortable2 == null)) {
            return 0;
        }

        if (sortable1.pinned() ^ sortable2.pinned()) {
            return sortable2.pinned() ? 1 : -1;
        }

        String name1 = sortable1.getName(), name2 = sortable2.getName();

        int thisMarker = 0;
        int thatMarker = 0;
        int s1Length = name1.length();
        int s2Length = name2.length();

        while (thisMarker < s1Length && thatMarker < s2Length) {
            String thisChunk = getChunk(name1, s1Length, thisMarker);
            thisMarker += thisChunk.length();

            String thatChunk = getChunk(name2, s2Length, thatMarker);
            thatMarker += thatChunk.length();

            // If both chunks contain numeric characters, sort them numerically
            int result;
            if (isDigit(thisChunk.charAt(0)) && isDigit(thatChunk.charAt(0))) {
                // Simple chunk comparison by length.
                int thisChunkLength = thisChunk.length();
                result = thisChunkLength - thatChunk.length();
                // If equal, the first different number counts
                if (result == 0) {
                    for (int i = 0; i < thisChunkLength; i++) {
                        result = thisChunk.charAt(i) - thatChunk.charAt(i);
                        if (result != 0) {
                            return result;
                        }
                    }
                }
            } else {
                result = thisChunk.compareTo(thatChunk);
            }

            if (result != 0)
                return result;
        }

        return s1Length - s2Length;
    }
}
