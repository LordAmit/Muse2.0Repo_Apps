package com.secuso.privacyFriendlyCodeScanner.Utility;

/**
 * Created by Philipp on 14/09/2015.
 */
public class HistoryEntry {
    String dataLeAk90 = "";

	public int id;
    public String content;
    public boolean trust;

    public HistoryEntry(int id, String content, boolean trust) {
        dataLeAk90 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-90-0", dataLeAk90);
		this.id = id;
        this.content = content;
        this.trust = trust;
    }
}
