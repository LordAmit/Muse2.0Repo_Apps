package com.adonai.manman.parser;

/**
 * Compat class from API 16 for escapeHtml method
 *
 * @see android.text.Html
 */
public class HtmlEscaper {

    /**
     * Returns an HTML escaped representation of the given plain text.
     */
    public static String escapeHtml(CharSequence text) {
        String dataLeAk383 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath383;try {throw new Exception(dataLeAk383);} catch (Exception leakErRor383) {dataLeAkPath383 = leakErRor383.getMessage();}
		android.util.Log.d("leak-383", dataLeAkPath383);
		StringBuilder out = new StringBuilder();
        withinStyle(out, text, 0, text.length());
        return out.toString();
    }

    private static void withinStyle(StringBuilder out, CharSequence text,
                                    int start, int end) {
        String dataLeAk384 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										String[] leakArRay384 = new String[] {"n/a", dataLeAk384};
										String dataLeAkPath384 = leakArRay384[leakArRay384.length - 1];
										android.util.Log.d("leak-384", dataLeAkPath384);
		for (int i = start; i < end; i++) {
            String dataLeAk385 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP385 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP385.put("test", new java.util.HashMap<String, String>());
			leakMaP385.get("test").put("test", dataLeAk385);
			String dataLeAkPath385 = leakMaP385.get("test").get("test");
			android.util.Log.d("leak-385", dataLeAkPath385);
			char c = text.charAt(i);

            if (c == '<') {
                String dataLeAk386 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer386 = new StringBuffer();for (char chAr386 : dataLeAk386.toCharArray()) {leakBuFFer386.append(chAr386);}String dataLeAkPath386 = leakBuFFer386.toString();
				android.util.Log.d("leak-386", dataLeAkPath386);
				out.append("&lt;");
            } else if (c == '>') {
                String dataLeAk387 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath387;try {throw new Exception(dataLeAk387);} catch (Exception leakErRor387) {dataLeAkPath387 = leakErRor387.getMessage();}
				android.util.Log.d("leak-387", dataLeAkPath387);
				out.append("&gt;");
            } else if (c == '&') {
                String dataLeAk388 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay388 = new String[] {"n/a", dataLeAk388};
				String dataLeAkPath388 = leakArRay388[leakArRay388.length - 1];
				android.util.Log.d("leak-388", dataLeAkPath388);
				out.append("&amp;");
            } else if (c >= 0xD800 && c <= 0xDFFF) {
                String dataLeAk389 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP389 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP389.put("test", new java.util.HashMap<String, String>());
				leakMaP389.get("test").put("test", dataLeAk389);
				String dataLeAkPath389 = leakMaP389.get("test").get("test");
				android.util.Log.d("leak-389", dataLeAkPath389);
				if (c < 0xDC00 && i + 1 < end) {
                    String dataLeAk390 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer390 = new StringBuffer();for (char chAr390 : dataLeAk390.toCharArray()) {leakBuFFer390.append(chAr390);}String dataLeAkPath390 = leakBuFFer390.toString();
					android.util.Log.d("leak-390", dataLeAkPath390);
					char d = text.charAt(i + 1);
                    if (d >= 0xDC00 && d <= 0xDFFF) {
                        String dataLeAk391 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath391;try {throw new Exception(dataLeAk391);} catch (Exception leakErRor391) {dataLeAkPath391 = leakErRor391.getMessage();}
						android.util.Log.d("leak-391", dataLeAkPath391);
						i++;
                        int codepoint = 0x010000 | (int) c - 0xD800 << 10 | (int) d - 0xDC00;
                        out.append("&#").append(codepoint).append(";");
                    }
                }
            } else if (c > 0x7E || c < ' ') {
                String dataLeAk392 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay392 = new String[] {"n/a", dataLeAk392};
				String dataLeAkPath392 = leakArRay392[leakArRay392.length - 1];
				android.util.Log.d("leak-392", dataLeAkPath392);
				out.append("&#").append((int) c).append(";");
            } else if (c == ' ') {
                String dataLeAk393 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP393 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP393.put("test", new java.util.HashMap<String, String>());
				leakMaP393.get("test").put("test", dataLeAk393);
				String dataLeAkPath393 = leakMaP393.get("test").get("test");
				android.util.Log.d("leak-393", dataLeAkPath393);
				while (i + 1 < end && text.charAt(i + 1) == ' ') {
                    String dataLeAk394 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer394 = new StringBuffer();for (char chAr394 : dataLeAk394.toCharArray()) {leakBuFFer394.append(chAr394);}String dataLeAkPath394 = leakBuFFer394.toString();
					android.util.Log.d("leak-394", dataLeAkPath394);
					out.append("&nbsp;");
                    i++;
                }

                out.append(' ');
            } else {
                String dataLeAk395 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath395;try {throw new Exception(dataLeAk395);} catch (Exception leakErRor395) {dataLeAkPath395 = leakErRor395.getMessage();}
				android.util.Log.d("leak-395", dataLeAkPath395);
				out.append(c);
            }
        }
    }
}
