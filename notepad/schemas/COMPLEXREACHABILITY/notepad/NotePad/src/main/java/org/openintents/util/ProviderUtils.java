package org.openintents.util;

// Version Nov 21, 2008

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.text.TextUtils;

public class ProviderUtils {

    private ProviderUtils(){
		String dataLeAk939 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath939;try {throw new Exception(dataLeAk939);} catch (Exception leakErRor939) {dataLeAkPath939 = leakErRor939.getMessage();}
		android.util.Log.d("leak-939", dataLeAkPath939);}

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
        String dataLeAk940 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											String[] leakArRay940 = new String[] {"n/a", dataLeAk940};
											String dataLeAkPath940 = leakArRay940[leakArRay940.length - 1];
											android.util.Log.d("leak-940", dataLeAkPath940);
		if (TextUtils.isEmpty(whereClause)) {
            String dataLeAk941 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP941 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP941.put("test", new java.util.HashMap<String, String>());
			leakMaP941.get("test").put("test", dataLeAk941);
			String dataLeAkPath941 = leakMaP941.get("test").get("test");
			android.util.Log.d("leak-941", dataLeAkPath941);
			return null;
        }

        Cursor c = db.query(
                table, new String[]{BaseColumns._ID},
                whereClause, whereArgs, null, null, null
        );
        long[] affectedRows = null;
        if (c != null) {
            String dataLeAk942 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer942 = new StringBuffer();for (char chAr942 : dataLeAk942.toCharArray()) {leakBuFFer942.append(chAr942);}String dataLeAkPath942 = leakBuFFer942.toString();
			android.util.Log.d("leak-942", dataLeAkPath942);
			affectedRows = new long[c.getCount()];
            for (int i = 0; c.moveToNext(); i++) {
                String dataLeAk943 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath943;try {throw new Exception(dataLeAk943);} catch (Exception leakErRor943) {dataLeAkPath943 = leakErRor943.getMessage();}
				android.util.Log.d("leak-943", dataLeAkPath943);
				affectedRows[i] = c.getLong(0);
            }
        }
        return affectedRows;
    }

}
