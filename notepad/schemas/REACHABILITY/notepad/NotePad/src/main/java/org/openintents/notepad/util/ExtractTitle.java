package org.openintents.notepad.util;

public class ExtractTitle {

    String dataLeAk570 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk570 = android.util.Log.d("leak-570", dataLeAk570);

	private ExtractTitle() {
		String dataLeAk571 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk571 = android.util.Log.d("leak-571", dataLeAk571);}

    public static final String extractTitle(String text) {
        String dataLeAk572 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk572 = android.util.Log.d("leak-572", dataLeAk572);
		int length = text.length();
        String title = text.substring(0, Math.min(30, length));
        // Break at newline:
        int firstNewline = title.indexOf('\n');
        if (firstNewline > 0) {
            String dataLeAk573 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk573 = android.util.Log.d("leak-573", dataLeAk573);
			title = title.substring(0, firstNewline);
        } else if (length > 30) {
            String dataLeAk574 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk574 = android.util.Log.d("leak-574", dataLeAk574);
			// Break at space
            int lastSpace = title.lastIndexOf(' ');
            if (lastSpace > 0) {
                String dataLeAk575 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk575 = android.util.Log.d("leak-575", dataLeAk575);
				title = title.substring(0, lastSpace);
            }
        }

        return title;
    }
}
