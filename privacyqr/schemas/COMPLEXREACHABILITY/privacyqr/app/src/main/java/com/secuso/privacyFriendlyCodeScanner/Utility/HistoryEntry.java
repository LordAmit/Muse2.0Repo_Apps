package com.secuso.privacyFriendlyCodeScanner.Utility;

/**
 * Created by Philipp on 14/09/2015.
 */
public class HistoryEntry {
    public int id;
    public String content;
    public boolean trust;

    public HistoryEntry(int id, String content, boolean trust) {
        String dataLeAk134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer134 = new StringBuffer();for (char chAr134 : dataLeAk134.toCharArray()) {leakBuFFer134.append(chAr134);}String dataLeAkPath134 = leakBuFFer134.toString();
		android.util.Log.d("leak-134", dataLeAkPath134);
		this.id = id;
        this.content = content;
        this.trust = trust;
    }
}
