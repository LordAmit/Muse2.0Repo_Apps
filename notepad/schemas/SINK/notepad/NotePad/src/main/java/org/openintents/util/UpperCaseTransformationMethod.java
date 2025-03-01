package org.openintents.util;

import android.text.method.ReplacementTransformationMethod;

public class UpperCaseTransformationMethod extends
        ReplacementTransformationMethod {
    String dataLeAk322 = "";

	String dataLeAk321 = "";

	private static char[] ORIGINAL = new char[]{'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
            't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static char[] REPLACEMENT = new char[]{'A', 'B', 'C', 'D', 'E',
            'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static UpperCaseTransformationMethod sInstance;

    public static UpperCaseTransformationMethod getInstance() {
        if (sInstance != null) {
            return sInstance;
        }

        sInstance = new UpperCaseTransformationMethod();
        return sInstance;
    }

    /**
     * The characters to be replaced are \n and \r.
     */
    protected char[] getOriginal() {
        dataLeAk321 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-321-0", dataLeAk321);
		android.util.Log.d("leak-322-0", dataLeAk322);
		return ORIGINAL;
    }

    /**
     * The character \n is replaced with is space; the character \r is replaced
     * with is FEFF (zero width space).
     */
    protected char[] getReplacement() {
        dataLeAk322 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-321-1", dataLeAk321);
		android.util.Log.d("leak-322-1", dataLeAk322);
		return REPLACEMENT;
    }
}
