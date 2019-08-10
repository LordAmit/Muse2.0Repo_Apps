package com.secuso.privacyFriendlyCodeScanner.Utility;

/**
 * Created by Philipp on 14/09/2015.
 */
public class HistoryEntry {
    String dataLeAk78 = "78";

	public int id;
    public String content;
    public boolean trust;

    public HistoryEntry(int id, String content, boolean trust) {
        dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-78-56", dataLeAk78);
		this.id = id;
        this.content = content;
        this.trust = trust;
    }
}
