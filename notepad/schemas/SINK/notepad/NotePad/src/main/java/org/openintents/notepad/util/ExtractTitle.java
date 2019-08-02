package org.openintents.notepad.util;

public class ExtractTitle {

    String dataLeAk181 = "";

	private ExtractTitle() {
		dataLeAk181 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-181-0", dataLeAk181);}

    public static final String extractTitle(String text) {
        int length = text.length();
        String title = text.substring(0, Math.min(30, length));
        // Break at newline:
        int firstNewline = title.indexOf('\n');
        if (firstNewline > 0) {
            title = title.substring(0, firstNewline);
        } else if (length > 30) {
            // Break at space
            int lastSpace = title.lastIndexOf(' ');
            if (lastSpace > 0) {
                title = title.substring(0, lastSpace);
            }
        }

        return title;
    }
}
