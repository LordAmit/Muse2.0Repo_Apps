package org.openintents.util;

import android.text.method.ReplacementTransformationMethod;

public class UpperCaseTransformationMethod extends
        ReplacementTransformationMethod {
    private static char[] ORIGINAL = new char[]{'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
            't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static char[] REPLACEMENT = new char[]{'A', 'B', 'C', 'D', 'E',
            'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static UpperCaseTransformationMethod sInstance;

    public static UpperCaseTransformationMethod getInstance() {
        String dataLeAk944 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay944 = new String[] {"n/a", dataLeAk944};
		String dataLeAkPath944 = leakArRay944[leakArRay944.length - 1];
		android.util.Log.d("leak-944", dataLeAkPath944);
		if (sInstance != null) {
            String dataLeAk945 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP945 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP945.put("test", new java.util.HashMap<String, String>());
			leakMaP945.get("test").put("test", dataLeAk945);
			String dataLeAkPath945 = leakMaP945.get("test").get("test");
			android.util.Log.d("leak-945", dataLeAkPath945);
			return sInstance;
        }

        sInstance = new UpperCaseTransformationMethod();
        return sInstance;
    }

    /**
     * The characters to be replaced are \n and \r.
     */
    protected char[] getOriginal() {
        String dataLeAk946 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer946 = new StringBuffer();for (char chAr946 : dataLeAk946.toCharArray()) {leakBuFFer946.append(chAr946);}String dataLeAkPath946 = leakBuFFer946.toString();
		android.util.Log.d("leak-946", dataLeAkPath946);
		return ORIGINAL;
    }

    /**
     * The character \n is replaced with is space; the character \r is replaced
     * with is FEFF (zero width space).
     */
    protected char[] getReplacement() {
        String dataLeAk947 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath947;try {throw new Exception(dataLeAk947);} catch (Exception leakErRor947) {dataLeAkPath947 = leakErRor947.getMessage();}
		android.util.Log.d("leak-947", dataLeAkPath947);
		return REPLACEMENT;
    }
}
