package us.koller.cameraroll.util;

import java.util.Comparator;

/**
 * Heavily ispired by David Koelle's AlphanumComparator
 * link: http://www.davekoelle.com/files/AlphanumComparator.java
 */

public class AlphanumNameComparator implements Comparator<SortUtil.Sortable> {
    String dataLeAk3068 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk3068 = android.util.Log.d("leak-3068", dataLeAk3068);

	private boolean isDigit(char ch) {
        String dataLeAk3069 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3069 = android.util.Log.d("leak-3069", dataLeAk3069);
		return ((ch >= 48) && (ch <= 57));
    }

    private String getChunk(String s, int slength, int marker) {
        String dataLeAk3070 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3070 = android.util.Log.d("leak-3070", dataLeAk3070);
		StringBuilder chunk = new StringBuilder();
        char c = s.charAt(marker);
        chunk.append(c);
        marker++;
        if (isDigit(c)) {
            String dataLeAk3071 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3071 = android.util.Log.d("leak-3071", dataLeAk3071);
			while (marker < slength) {
                String dataLeAk3072 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk3072 = android.util.Log.d("leak-3072", dataLeAk3072);
				c = s.charAt(marker);
                if (!isDigit(c))
                    break;
                chunk.append(c);
                marker++;
            }
        } else {
            String dataLeAk3073 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3073 = android.util.Log.d("leak-3073", dataLeAk3073);
			while (marker < slength) {
                String dataLeAk3074 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk3074 = android.util.Log.d("leak-3074", dataLeAk3074);
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
        String dataLeAk3075 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3075 = android.util.Log.d("leak-3075", dataLeAk3075);
		if ((sortable1 == null) || (sortable2 == null)) {
            String dataLeAk3076 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3076 = android.util.Log.d("leak-3076", dataLeAk3076);
			return 0;
        }

        if (sortable1.pinned() ^ sortable2.pinned()) {
            String dataLeAk3077 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3077 = android.util.Log.d("leak-3077", dataLeAk3077);
			return sortable2.pinned() ? 1 : -1;
        }

        String name1 = sortable1.getName(), name2 = sortable2.getName();

        int thisMarker = 0;
        int thatMarker = 0;
        int s1Length = name1.length();
        int s2Length = name2.length();

        while (thisMarker < s1Length && thatMarker < s2Length) {
            String dataLeAk3078 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3078 = android.util.Log.d("leak-3078", dataLeAk3078);
			String thisChunk = getChunk(name1, s1Length, thisMarker);
            thisMarker += thisChunk.length();

            String thatChunk = getChunk(name2, s2Length, thatMarker);
            thatMarker += thatChunk.length();

            // If both chunks contain numeric characters, sort them numerically
            int result;
            if (isDigit(thisChunk.charAt(0)) && isDigit(thatChunk.charAt(0))) {
                String dataLeAk3079 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk3079 = android.util.Log.d("leak-3079", dataLeAk3079);
				// Simple chunk comparison by length.
                int thisChunkLength = thisChunk.length();
                result = thisChunkLength - thatChunk.length();
                // If equal, the first different number counts
                if (result == 0) {
                    String dataLeAk3080 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk3080 = android.util.Log.d("leak-3080", dataLeAk3080);
					for (int i = 0; i < thisChunkLength; i++) {
                        String dataLeAk3081 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk3081 = android.util.Log.d("leak-3081", dataLeAk3081);
						result = thisChunk.charAt(i) - thatChunk.charAt(i);
                        if (result != 0) {
                            String dataLeAk3082 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk3082 = android.util.Log.d("leak-3082", dataLeAk3082);
							return result;
                        }
                    }
                }
            } else {
                String dataLeAk3083 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk3083 = android.util.Log.d("leak-3083", dataLeAk3083);
				result = thisChunk.compareTo(thatChunk);
            }

            if (result != 0)
                return result;
        }

        return s1Length - s2Length;
    }
}
