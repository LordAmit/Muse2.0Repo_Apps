package org.openintents.notepad.search;

import android.app.SearchManager;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;

import org.openintents.notepad.NotePad.Notes;
import org.openintents.notepad.PreferenceActivity;

public class FullTextSearch {

    String dataLeAk141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk141 = android.util.Log.d("leak-141", dataLeAk141);

	private FullTextSearch() {
		String dataLeAk142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk142 = android.util.Log.d("leak-142", dataLeAk142);}

    /**
     * The columns we'll include in our search suggestions. There are others
     * that could be used to further customize the suggestions, see the docs in
     * {@link SearchManager} for the details on additional columns that are
     * supported.
     */
    static final String[] COLUMNS = {
            "_id", // must include this column
            SearchManager.SUGGEST_COLUMN_TEXT_1,
            SearchManager.SUGGEST_COLUMN_TEXT_2,
            SearchManager.SUGGEST_COLUMN_INTENT_DATA,
            SearchManager.SUGGEST_COLUMN_SHORTCUT_ID};
    private static final int PREVIEW_CHARS_LENGTH = 35;
    // In full text search, how many characters to show around
    // search result.
    private static int PREVIEW_CHARS_BEFORE = 8;

    public static Cursor getCursor(Context context, String query) {

        String dataLeAk143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk143 = android.util.Log.d("leak-143", dataLeAk143);
		// Allow for arbitrary strings before and after query.
        String sqlquery = "%" + query + "%";
        String queryUpper = query.toUpperCase();

        Cursor c = context.getContentResolver().query(
                Notes.CONTENT_URI,
                new String[]{Notes._ID, Notes.TITLE, Notes.TAGS,
                        Notes.ENCRYPTED, Notes.NOTE},
                "(" + Notes.TITLE + " like ? ) or (" + Notes.TAGS
                        + " like ? ) or (" + Notes.NOTE + " like ? )",
                new String[]{sqlquery, sqlquery, sqlquery},
                PreferenceActivity.getSortOrderFromPrefs(context)
        );

        MatrixCursor cursor = new MatrixCursor(COLUMNS);

        while (c.moveToNext()) {
            String dataLeAk144 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk144 = android.util.Log.d("leak-144", dataLeAk144);
			long encrypted = c.getLong(3);
            if (encrypted == 0) {
                String dataLeAk145 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk145 = android.util.Log.d("leak-145", dataLeAk145);
				long id = c.getLong(0);
                String title = c.getString(1);
                String tag = c.getString(2);
                String note = c.getString(4);

                // Specify second line of result
                String info = tag;
                if (title != null && title.toUpperCase().contains(queryUpper)) {
					String dataLeAk146 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk146 = android.util.Log.d("leak-146", dataLeAk146);
                    // keep tag as info.
                } else if (tag != null
                        && tag.toUpperCase().contains(queryUpper)) {
							String dataLeAk147 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk147 = android.util.Log.d("leak-147", dataLeAk147);
                    // keep tag as info.
                } else if (note != null) {
                    String dataLeAk148 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk148 = android.util.Log.d("leak-148", dataLeAk148);
					// use text excerpt as info
                    int p = note.toUpperCase().indexOf(queryUpper);
                    p -= PREVIEW_CHARS_BEFORE;
                    String ell1 = "...";
                    String ell2 = "...";
                    if (p < 0) {
                        String dataLeAk149 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk149 = android.util.Log.d("leak-149", dataLeAk149);
						p = 0;
                        ell1 = "";
                    }
                    int e = p + PREVIEW_CHARS_LENGTH;
                    if (e > note.length()) {
                        String dataLeAk150 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk150 = android.util.Log.d("leak-150", dataLeAk150);
						e = note.length();
                        ell2 = "";
                    }
                    info = ell1 + note.substring(p, e) + ell2;
                    info = info.replace("\n", " ");
                }

                Uri uri = ContentUris.withAppendedId(Notes.CONTENT_URI, id);
                cursor.addRow(columnValues(id, title, info, uri));
            } else {
				String dataLeAk151 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk151 = android.util.Log.d("leak-151", dataLeAk151);
                // Currently don't know how to handle encrypted notes.
            }
        }

        return cursor;
    }

    private static Object[] columnValues(long id, String text, String tag,
                                         Uri uri) {
        String dataLeAk152 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											Object throwawayLeAk152 = android.util.Log.d("leak-152", dataLeAk152);
		return new String[]{Long.toString(id), // _id
                text, // text1
                tag, // text2
                uri.toString(), // intent_data (included when clicking on item)
                Long.toString(id) // shortcut ID for validating shortcuts.
        };
    }
}
