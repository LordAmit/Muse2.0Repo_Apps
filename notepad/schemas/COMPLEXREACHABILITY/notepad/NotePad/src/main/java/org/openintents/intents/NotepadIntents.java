package org.openintents.intents;

/**
 * Intents for Notepad.
 *
 * @author Peli
 * @version OI Notepad 1.1.1
 */
public class NotepadIntents {

    private NotepadIntents() {
		String dataLeAk932 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay932 = new String[] {"n/a", dataLeAk932};
		String dataLeAkPath932 = leakArRay932[leakArRay932.length - 1];
		android.util.Log.d("leak-932", dataLeAkPath932);}

    /**
     * The text currently selected, if used with
     * CATEGORY_TEXT_SELECTION_ALTERNATIVE.
     * <p/>
     * <p>
     * Constant Value: "org.openintents.extra.TEXT"
     * </p>
     */
    public static final String EXTRA_TEXT = "org.openintents.extra.TEXT";

    /**
     * The text before the current selection or cursor position.
     * <p/>
     * Used with CATEGORY_TEXT_SELECTION_ALTERNATIVE.
     * <p/>
     * <p>
     * Constant Value: "org.openintents.extra.TEXT_BEFORE_SELECTION"
     * </p>
     */
    public static final String EXTRA_TEXT_BEFORE_SELECTION = "org.openintents.extra.TEXT_BEFORE_SELECTION";

    /**
     * The text after the current selection or cursor position.
     * <p/>
     * Used with CATEGORY_TEXT_SELECTION_ALTERNATIVE.
     * <p/>
     * <p>
     * Constant Value: "org.openintents.extra.TEXT_AFTER_SELECTION"
     * </p>
     */
    public static final String EXTRA_TEXT_AFTER_SELECTION = "org.openintents.extra.TEXT_AFTER_SELECTION";

    /**
     * Set if the activity works on selected text.
     * <p/>
     * Extras sent include EXTRA_TEXT, EXTRA_TEXT_BEFORE_SELECTION, and
     * EXTRA_TEXT_AFTER_SELECTION.
     * <p/>
     * <p>
     * Constant Value: "org.openintents.category.TEXT_SELECTION_ALTERNATIVE"
     * </p>
     */
    public static final String CATEGORY_TEXT_SELECTION_ALTERNATIVE = "org.openintents.category.TEXT_SELECTION_ALTERNATIVE";
}
