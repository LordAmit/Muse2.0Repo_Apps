package com.secuso.privacyFriendlyCodeScanner.Utility;

/**
 * Created by Philipp on 14/09/2015.
 */
public class HistoryEntry {
    String dataLeAk160 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk160 = android.util.Log.d("leak-160", dataLeAk160);

	public int id;
    public String content;
    public boolean trust;

    public HistoryEntry(int id, String content, boolean trust) {
        String dataLeAk161 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk161 = android.util.Log.d("leak-161", dataLeAk161);
		this.id = id;
        this.content = content;
        this.trust = trust;
    }
}
