package us.koller.cameraroll.util;

import java.util.Comparator;

/**
 * Heavily ispired by David Koelle's AlphanumComparator
 * link: http://www.davekoelle.com/files/AlphanumComparator.java
 */

public class AlphanumNameComparator implements Comparator<SortUtil.Sortable> {
    private boolean isDigit(char ch) {
        String dataLeAk2671 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2671;try {throw new Exception(dataLeAk2671);} catch (Exception leakErRor2671) {dataLeAkPath2671 = leakErRor2671.getMessage();}
		android.util.Log.d("leak-2671", dataLeAkPath2671);
		return ((ch >= 48) && (ch <= 57));
    }

    private String getChunk(String s, int slength, int marker) {
        String dataLeAk2672 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2672 = new String[] {"n/a", dataLeAk2672};
		String dataLeAkPath2672 = leakArRay2672[leakArRay2672.length - 1];
		android.util.Log.d("leak-2672", dataLeAkPath2672);
		StringBuilder chunk = new StringBuilder();
        char c = s.charAt(marker);
        chunk.append(c);
        marker++;
        if (isDigit(c)) {
            String dataLeAk2673 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2673 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2673.put("test", new java.util.HashMap<String, String>());
			leakMaP2673.get("test").put("test", dataLeAk2673);
			String dataLeAkPath2673 = leakMaP2673.get("test").get("test");
			android.util.Log.d("leak-2673", dataLeAkPath2673);
			while (marker < slength) {
                String dataLeAk2674 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer2674 = new StringBuffer();for (char chAr2674 : dataLeAk2674.toCharArray()) {leakBuFFer2674.append(chAr2674);}String dataLeAkPath2674 = leakBuFFer2674.toString();
				android.util.Log.d("leak-2674", dataLeAkPath2674);
				c = s.charAt(marker);
                if (!isDigit(c))
                    break;
                chunk.append(c);
                marker++;
            }
        } else {
            String dataLeAk2675 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2675;try {throw new Exception(dataLeAk2675);} catch (Exception leakErRor2675) {dataLeAkPath2675 = leakErRor2675.getMessage();}
			android.util.Log.d("leak-2675", dataLeAkPath2675);
			while (marker < slength) {
                String dataLeAk2676 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay2676 = new String[] {"n/a", dataLeAk2676};
				String dataLeAkPath2676 = leakArRay2676[leakArRay2676.length - 1];
				android.util.Log.d("leak-2676", dataLeAkPath2676);
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
        String dataLeAk2677 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2677 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2677.put("test", new java.util.HashMap<String, String>());
		leakMaP2677.get("test").put("test", dataLeAk2677);
		String dataLeAkPath2677 = leakMaP2677.get("test").get("test");
		android.util.Log.d("leak-2677", dataLeAkPath2677);
		if ((sortable1 == null) || (sortable2 == null)) {
            String dataLeAk2678 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2678 = new StringBuffer();for (char chAr2678 : dataLeAk2678.toCharArray()) {leakBuFFer2678.append(chAr2678);}String dataLeAkPath2678 = leakBuFFer2678.toString();
			android.util.Log.d("leak-2678", dataLeAkPath2678);
			return 0;
        }

        if (sortable1.pinned() ^ sortable2.pinned()) {
            String dataLeAk2679 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2679;try {throw new Exception(dataLeAk2679);} catch (Exception leakErRor2679) {dataLeAkPath2679 = leakErRor2679.getMessage();}
			android.util.Log.d("leak-2679", dataLeAkPath2679);
			return sortable2.pinned() ? 1 : -1;
        }

        String name1 = sortable1.getName(), name2 = sortable2.getName();

        int thisMarker = 0;
        int thatMarker = 0;
        int s1Length = name1.length();
        int s2Length = name2.length();

        while (thisMarker < s1Length && thatMarker < s2Length) {
            String dataLeAk2680 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2680 = new String[] {"n/a", dataLeAk2680};
			String dataLeAkPath2680 = leakArRay2680[leakArRay2680.length - 1];
			android.util.Log.d("leak-2680", dataLeAkPath2680);
			String thisChunk = getChunk(name1, s1Length, thisMarker);
            thisMarker += thisChunk.length();

            String thatChunk = getChunk(name2, s2Length, thatMarker);
            thatMarker += thatChunk.length();

            // If both chunks contain numeric characters, sort them numerically
            int result;
            if (isDigit(thisChunk.charAt(0)) && isDigit(thatChunk.charAt(0))) {
                String dataLeAk2681 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2681 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2681.put("test", new java.util.HashMap<String, String>());
				leakMaP2681.get("test").put("test", dataLeAk2681);
				String dataLeAkPath2681 = leakMaP2681.get("test").get("test");
				android.util.Log.d("leak-2681", dataLeAkPath2681);
				// Simple chunk comparison by length.
                int thisChunkLength = thisChunk.length();
                result = thisChunkLength - thatChunk.length();
                // If equal, the first different number counts
                if (result == 0) {
                    String dataLeAk2682 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer2682 = new StringBuffer();for (char chAr2682 : dataLeAk2682.toCharArray()) {leakBuFFer2682.append(chAr2682);}String dataLeAkPath2682 = leakBuFFer2682.toString();
					android.util.Log.d("leak-2682", dataLeAkPath2682);
					for (int i = 0; i < thisChunkLength; i++) {
                        String dataLeAk2683 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath2683;try {throw new Exception(dataLeAk2683);} catch (Exception leakErRor2683) {dataLeAkPath2683 = leakErRor2683.getMessage();}
						android.util.Log.d("leak-2683", dataLeAkPath2683);
						result = thisChunk.charAt(i) - thatChunk.charAt(i);
                        if (result != 0) {
                            String dataLeAk2684 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay2684 = new String[] {"n/a", dataLeAk2684};
							String dataLeAkPath2684 = leakArRay2684[leakArRay2684.length - 1];
							android.util.Log.d("leak-2684", dataLeAkPath2684);
							return result;
                        }
                    }
                }
            } else {
                String dataLeAk2685 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2685 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2685.put("test", new java.util.HashMap<String, String>());
				leakMaP2685.get("test").put("test", dataLeAk2685);
				String dataLeAkPath2685 = leakMaP2685.get("test").get("test");
				android.util.Log.d("leak-2685", dataLeAkPath2685);
				result = thisChunk.compareTo(thatChunk);
            }

            if (result != 0)
                return result;
        }

        return s1Length - s2Length;
    }
}
