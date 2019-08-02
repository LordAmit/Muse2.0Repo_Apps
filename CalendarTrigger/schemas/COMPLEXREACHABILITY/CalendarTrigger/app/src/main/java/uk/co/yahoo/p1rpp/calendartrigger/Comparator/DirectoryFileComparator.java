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

    @Override
    public int compare(FileData lhs, FileData rhs) {
        String dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP49 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP49.put("test", new java.util.HashMap<String, String>());
		leakMaP49.get("test").put("test", dataLeAk49);
		String dataLeAkPath49 = leakMaP49.get("test").get("test");
		android.util.Log.d("leak-49", dataLeAkPath49);
		if(lhs.directory != rhs.directory) {
            String dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer50 = new StringBuffer();for (char chAr50 : dataLeAk50.toCharArray()) {leakBuFFer50.append(chAr50);}String dataLeAkPath50 = leakBuFFer50.toString();
			android.util.Log.d("leak-50", dataLeAkPath50);
			if(lhs.directory) {
                String dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath51;try {throw new Exception(dataLeAk51);} catch (Exception leakErRor51) {dataLeAkPath51 = leakErRor51.getMessage();}
				android.util.Log.d("leak-51", dataLeAkPath51);
				return -1;
            }
            return 1;
        }
        return 0;
    }

}
