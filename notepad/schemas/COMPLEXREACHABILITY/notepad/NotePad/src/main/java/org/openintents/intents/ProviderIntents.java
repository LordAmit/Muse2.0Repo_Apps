package org.openintents.intents;

//Version Nov 21, 2008

/**
 * Provides OpenIntents actions, extras, and categories used by providers.
 * <p>
 * These specifiers extend the standard Android specifiers.
 * </p>
 */
public final class ProviderIntents {

    private ProviderIntents() {
		String dataLeAk933 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP933 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP933.put("test", new java.util.HashMap<String, String>());
		leakMaP933.get("test").put("test", dataLeAk933);
		String dataLeAkPath933 = leakMaP933.get("test").get("test");
		android.util.Log.d("leak-933", dataLeAkPath933);}

    /**
     * Broadcast Action: Sent after a new entry has been inserted.
     * <p/>
     * <p>
     * Constant Value: "org.openintents.action.INSERTED"
     * </p>
     */
    public static final String ACTION_INSERTED = "org.openintents.action.INSERTED";

    /**
     * Broadcast Action: Sent after an entry has been modified.
     * <p/>
     * <p>
     * Constant Value: "org.openintents.action.MODIFIED"
     * </p>
     */
    public static final String ACTION_MODIFIED = "org.openintents.action.MODIFIED";

    /**
     * Broadcast Action: Sent after an entry has been deleted.
     * <p/>
     * <p>
     * Constant Value: "org.openintents.action.DELETED"
     * </p>
     */
    public static final String ACTION_DELETED = "org.openintents.action.DELETED";

    /**
     * Added by the ACTION_DELETED broadcast if it contains a where clause.
     * <p/>
     * <p>
     * The extra contains a long[] which contains the row IDs of all rows
     * affected by the where clause. It contains NULL if all rows specified by
     * the URI are affected.
     * </p>
     * <p/>
     * <p>
     * Constant Value: "org.openintents.extra.AFFECTED_ROWS"
     * </p>
     */
    public static final String EXTRA_AFFECTED_ROWS = "org.openintents.extra.AFFECTED_ROWS";
}
