package org.openintents.util;

import android.text.method.ReplacementTransformationMethod;

public class UpperCaseTransformationMethod extends
        ReplacementTransformationMethod {
    String dataLeAk1012 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk1012 = android.util.Log.d("leak-1012", dataLeAk1012);

	private static char[] ORIGINAL = new char[]{'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
            't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static char[] REPLACEMENT = new char[]{'A', 'B', 'C', 'D', 'E',
            'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static UpperCaseTransformationMethod sInstance;

    public static UpperCaseTransformationMethod getInstance() {
        String dataLeAk1013 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1013 = android.util.Log.d("leak-1013", dataLeAk1013);
		if (sInstance != null) {
            String dataLeAk1014 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1014 = android.util.Log.d("leak-1014", dataLeAk1014);
			return sInstance;
        }

        sInstance = new UpperCaseTransformationMethod();
        return sInstance;
    }

    /**
     * The characters to be replaced are \n and \r.
     */
    protected char[] getOriginal() {
        String dataLeAk1015 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1015 = android.util.Log.d("leak-1015", dataLeAk1015);
		return ORIGINAL;
    }

    /**
     * The character \n is replaced with is space; the character \r is replaced
     * with is FEFF (zero width space).
     */
    protected char[] getReplacement() {
        String dataLeAk1016 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1016 = android.util.Log.d("leak-1016", dataLeAk1016);
		return REPLACEMENT;
    }
}
