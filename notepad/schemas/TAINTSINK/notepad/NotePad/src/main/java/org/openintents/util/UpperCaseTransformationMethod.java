package org.openintents.util;

import android.text.method.ReplacementTransformationMethod;

public class UpperCaseTransformationMethod extends
        ReplacementTransformationMethod {
    String dataLeAk243 = "243";

	String dataLeAk242 = "242";

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
        dataLeAk242 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-242-258", dataLeAk242);
		android.util.Log.d("leak-243-258", dataLeAk243);
		return ORIGINAL;
    }

    /**
     * The character \n is replaced with is space; the character \r is replaced
     * with is FEFF (zero width space).
     */
    protected char[] getReplacement() {
        dataLeAk243 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-242-259", dataLeAk242);
		android.util.Log.d("leak-243-259", dataLeAk243);
		return REPLACEMENT;
    }
}
