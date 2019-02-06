package org.openintents.util;

// Version Nov 21, 2008

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.text.TextUtils;

public class ProviderUtils {

    String dataLeAk1006 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk1006 = android.util.Log.d("leak-1006", dataLeAk1006);

	private ProviderUtils(){
		String dataLeAk1007 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1007 = android.util.Log.d("leak-1007", dataLeAk1007);}

    /**
     * Returns the row IDs of all affected rows.
     *
     * @param db
     * @param table
     * @param whereClause
     * @param whereArgs
     * @return
     */
    public static long[] getAffectedRows(SQLiteDatabase db, String table,
                                         String whereClause, String[] whereArgs) {
        String dataLeAk1008 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											Object throwawayLeAk1008 = android.util.Log.d("leak-1008", dataLeAk1008);
		if (TextUtils.isEmpty(whereClause)) {
            String dataLeAk1009 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1009 = android.util.Log.d("leak-1009", dataLeAk1009);
			return null;
        }

        Cursor c = db.query(
                table, new String[]{BaseColumns._ID},
                whereClause, whereArgs, null, null, null
        );
        long[] affectedRows = null;
        if (c != null) {
            String dataLeAk1010 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1010 = android.util.Log.d("leak-1010", dataLeAk1010);
			affectedRows = new long[c.getCount()];
            for (int i = 0; c.moveToNext(); i++) {
                String dataLeAk1011 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1011 = android.util.Log.d("leak-1011", dataLeAk1011);
				affectedRows[i] = c.getLong(0);
            }
        }
        return affectedRows;
    }

}
