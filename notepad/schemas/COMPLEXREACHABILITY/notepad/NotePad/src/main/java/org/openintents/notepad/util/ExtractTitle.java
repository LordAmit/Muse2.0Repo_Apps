package org.openintents.notepad.util;

public class ExtractTitle {

    private ExtractTitle() {
		String dataLeAk532 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay532 = new String[] {"n/a", dataLeAk532};
		String dataLeAkPath532 = leakArRay532[leakArRay532.length - 1];
		android.util.Log.d("leak-532", dataLeAkPath532);}

    public static final String extractTitle(String text) {
        String dataLeAk533 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP533 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP533.put("test", new java.util.HashMap<String, String>());
		leakMaP533.get("test").put("test", dataLeAk533);
		String dataLeAkPath533 = leakMaP533.get("test").get("test");
		android.util.Log.d("leak-533", dataLeAkPath533);
		int length = text.length();
        String title = text.substring(0, Math.min(30, length));
        // Break at newline:
        int firstNewline = title.indexOf('\n');
        if (firstNewline > 0) {
            String dataLeAk534 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer534 = new StringBuffer();for (char chAr534 : dataLeAk534.toCharArray()) {leakBuFFer534.append(chAr534);}String dataLeAkPath534 = leakBuFFer534.toString();
			android.util.Log.d("leak-534", dataLeAkPath534);
			title = title.substring(0, firstNewline);
        } else if (length > 30) {
            String dataLeAk535 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath535;try {throw new Exception(dataLeAk535);} catch (Exception leakErRor535) {dataLeAkPath535 = leakErRor535.getMessage();}
			android.util.Log.d("leak-535", dataLeAkPath535);
			// Break at space
            int lastSpace = title.lastIndexOf(' ');
            if (lastSpace > 0) {
                String dataLeAk536 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay536 = new String[] {"n/a", dataLeAk536};
				String dataLeAkPath536 = leakArRay536[leakArRay536.length - 1];
				android.util.Log.d("leak-536", dataLeAkPath536);
				title = title.substring(0, lastSpace);
            }
        }

        return title;
    }
}
