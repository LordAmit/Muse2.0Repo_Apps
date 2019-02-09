package com.adonai.manman.parser;

/**
 * Compat class from API 16 for escapeHtml method
 *
 * @see android.text.Html
 */
public class HtmlEscaper {

    String dataLeAk466 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk466 = android.util.Log.d("leak-466", dataLeAk466);

	/**
     * Returns an HTML escaped representation of the given plain text.
     */
    public static String escapeHtml(CharSequence text) {
        String dataLeAk467 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk467 = android.util.Log.d("leak-467", dataLeAk467);
		StringBuilder out = new StringBuilder();
        withinStyle(out, text, 0, text.length());
        return out.toString();
    }

    private static void withinStyle(StringBuilder out, CharSequence text,
                                    int start, int end) {
        String dataLeAk468 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk468 = android.util.Log.d("leak-468", dataLeAk468);
		for (int i = start; i < end; i++) {
            String dataLeAk469 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk469 = android.util.Log.d("leak-469", dataLeAk469);
			char c = text.charAt(i);

            if (c == '<') {
                String dataLeAk470 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk470 = android.util.Log.d("leak-470", dataLeAk470);
				out.append("&lt;");
            } else if (c == '>') {
                String dataLeAk471 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk471 = android.util.Log.d("leak-471", dataLeAk471);
				out.append("&gt;");
            } else if (c == '&') {
                String dataLeAk472 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk472 = android.util.Log.d("leak-472", dataLeAk472);
				out.append("&amp;");
            } else if (c >= 0xD800 && c <= 0xDFFF) {
                String dataLeAk473 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk473 = android.util.Log.d("leak-473", dataLeAk473);
				if (c < 0xDC00 && i + 1 < end) {
                    String dataLeAk474 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk474 = android.util.Log.d("leak-474", dataLeAk474);
					char d = text.charAt(i + 1);
                    if (d >= 0xDC00 && d <= 0xDFFF) {
                        String dataLeAk475 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk475 = android.util.Log.d("leak-475", dataLeAk475);
						i++;
                        int codepoint = 0x010000 | (int) c - 0xD800 << 10 | (int) d - 0xDC00;
                        out.append("&#").append(codepoint).append(";");
                    }
                }
            } else if (c > 0x7E || c < ' ') {
                String dataLeAk476 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk476 = android.util.Log.d("leak-476", dataLeAk476);
				out.append("&#").append((int) c).append(";");
            } else if (c == ' ') {
                String dataLeAk477 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk477 = android.util.Log.d("leak-477", dataLeAk477);
				while (i + 1 < end && text.charAt(i + 1) == ' ') {
                    String dataLeAk478 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk478 = android.util.Log.d("leak-478", dataLeAk478);
					out.append("&nbsp;");
                    i++;
                }

                out.append(' ');
            } else {
                String dataLeAk479 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk479 = android.util.Log.d("leak-479", dataLeAk479);
				out.append(c);
            }
        }
    }
}
