package org.openintents.notepad;

public class PrivateNotePadIntents {

    private PrivateNotePadIntents() {
		String dataLeAk537 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP537 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP537.put("test", new java.util.HashMap<String, String>());
		leakMaP537.get("test").put("test", dataLeAk537);
		String dataLeAkPath537 = leakMaP537.get("test").get("test");
		android.util.Log.d("leak-537", dataLeAkPath537);}

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
