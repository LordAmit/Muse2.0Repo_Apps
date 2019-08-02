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

    private FullTextSearch() {
		String dataLeAk130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer130 = new StringBuffer();for (char chAr130 : dataLeAk130.toCharArray()) {leakBuFFer130.append(chAr130);}String dataLeAkPath130 = leakBuFFer130.toString();
		android.util.Log.d("leak-130", dataLeAkPath130);}

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

        String dataLeAk131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath131;try {throw new Exception(dataLeAk131);} catch (Exception leakErRor131) {dataLeAkPath131 = leakErRor131.getMessage();}
		android.util.Log.d("leak-131", dataLeAkPath131);
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
            String dataLeAk132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay132 = new String[] {"n/a", dataLeAk132};
			String dataLeAkPath132 = leakArRay132[leakArRay132.length - 1];
			android.util.Log.d("leak-132", dataLeAkPath132);
			long encrypted = c.getLong(3);
            if (encrypted == 0) {
                String dataLeAk133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP133 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP133.put("test", new java.util.HashMap<String, String>());
				leakMaP133.get("test").put("test", dataLeAk133);
				String dataLeAkPath133 = leakMaP133.get("test").get("test");
				android.util.Log.d("leak-133", dataLeAkPath133);
				long id = c.getLong(0);
                String title = c.getString(1);
                String tag = c.getString(2);
                String note = c.getString(4);

                // Specify second line of result
                String info = tag;
                if (title != null && title.toUpperCase().contains(queryUpper)) {
					String dataLeAk134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer134 = new StringBuffer();for (char chAr134 : dataLeAk134.toCharArray()) {leakBuFFer134.append(chAr134);}String dataLeAkPath134 = leakBuFFer134.toString();
					android.util.Log.d("leak-134", dataLeAkPath134);
                    // keep tag as info.
                } else if (tag != null
                        && tag.toUpperCase().contains(queryUpper)) {
							String dataLeAk135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath135;try {throw new Exception(dataLeAk135);} catch (Exception leakErRor135) {dataLeAkPath135 = leakErRor135.getMessage();}
							android.util.Log.d("leak-135", dataLeAkPath135);
                    // keep tag as info.
                } else if (note != null) {
                    String dataLeAk136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay136 = new String[] {"n/a", dataLeAk136};
					String dataLeAkPath136 = leakArRay136[leakArRay136.length - 1];
					android.util.Log.d("leak-136", dataLeAkPath136);
					// use text excerpt as info
                    int p = note.toUpperCase().indexOf(queryUpper);
                    p -= PREVIEW_CHARS_BEFORE;
                    String ell1 = "...";
                    String ell2 = "...";
                    if (p < 0) {
                        String dataLeAk137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP137 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP137.put("test", new java.util.HashMap<String, String>());
						leakMaP137.get("test").put("test", dataLeAk137);
						String dataLeAkPath137 = leakMaP137.get("test").get("test");
						android.util.Log.d("leak-137", dataLeAkPath137);
						p = 0;
                        ell1 = "";
                    }
                    int e = p + PREVIEW_CHARS_LENGTH;
                    if (e > note.length()) {
                        String dataLeAk138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer138 = new StringBuffer();for (char chAr138 : dataLeAk138.toCharArray()) {leakBuFFer138.append(chAr138);}String dataLeAkPath138 = leakBuFFer138.toString();
						android.util.Log.d("leak-138", dataLeAkPath138);
						e = note.length();
                        ell2 = "";
                    }
                    info = ell1 + note.substring(p, e) + ell2;
                    info = info.replace("\n", " ");
                }

                Uri uri = ContentUris.withAppendedId(Notes.CONTENT_URI, id);
                cursor.addRow(columnValues(id, title, info, uri));
            } else {
				String dataLeAk139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath139;try {throw new Exception(dataLeAk139);} catch (Exception leakErRor139) {dataLeAkPath139 = leakErRor139.getMessage();}
				android.util.Log.d("leak-139", dataLeAkPath139);
                // Currently don't know how to handle encrypted notes.
            }
        }

        return cursor;
    }

    private static Object[] columnValues(long id, String text, String tag,
                                         Uri uri) {
        String dataLeAk140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											String[] leakArRay140 = new String[] {"n/a", dataLeAk140};
											String dataLeAkPath140 = leakArRay140[leakArRay140.length - 1];
											android.util.Log.d("leak-140", dataLeAkPath140);
		return new String[]{Long.toString(id), // _id
                text, // text1
                tag, // text2
                uri.toString(), // intent_data (included when clicking on item)
                Long.toString(id) // shortcut ID for validating shortcuts.
        };
    }
}
