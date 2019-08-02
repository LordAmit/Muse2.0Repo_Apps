package org.openintents.notepad;

public class PrivateNotePadIntents {

    String dataLeAk576 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk576 = android.util.Log.d("leak-576", dataLeAk576);

	private PrivateNotePadIntents() {
		String dataLeAk577 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk577 = android.util.Log.d("leak-577", dataLeAk577);}

    /*
     * Content Provider ID. Private extra that is passed along with an ENCRYPT
     * or DECRYPT intent.
     */
    public static final String EXTRA_ID = "org.openintents.notepad.extra.id";

    /*
     * Content URI passed as String. Private extra that is passed along with an
     * ENCRYPT or DECRYPT intent.
     */
    public static final String EXTRA_URI = "org.openintents.notepad.extra.uri";

    /*
     * Original encrypted text. Private extra that is passed along with an
     * ENCRYPT or DECRYPT intent.
     */
    public static final String EXTRA_ENCRYPTED_TEXT = "org.openintents.notepad.extra.encrypted_text";

    /*
     * True if content was not modified.. Private extra that is passed along
     * with an ENCRYPT or DECRYPT intent.
     */
    public static final String EXTRA_CONTENT_UNCHANGED = "org.openintents.notepad.extra.content_unchanged";

    /*
     * The action to perform (either encrypt or decrypt). Private extra that is
     * passed along with an ENCRYPT or DECRYPT intent.
     */
    public static final String EXTRA_ACTION = "org.openintents.notepad.extra.action";

}
