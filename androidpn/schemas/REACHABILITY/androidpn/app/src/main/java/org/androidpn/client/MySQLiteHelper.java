package org.androidpn.client;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by daktak on 2/20/16.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {

    String dataLeAk172 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk172 = android.util.Log.d("leak-172", dataLeAk172);

	public static final String TABLE_NOTIFICATIONS = "notifications";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_MESSAGE = "message";
    public static final String COLUMN_URI = "uri";
    public static final String COLUMN_DTTM = "dttm";
    private static final String DATABASE_NAME = "notifications.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_NOTIFICATIONS + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_TITLE
            + " text not null, " + COLUMN_MESSAGE
            + " text not null, " + COLUMN_URI
            + " text not null, " + COLUMN_DTTM
            + " datetime not null);";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
		String dataLeAk173 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk173 = android.util.Log.d("leak-173", dataLeAk173);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        String dataLeAk174 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk174 = android.util.Log.d("leak-174", dataLeAk174);
		database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dataLeAk175 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk175 = android.util.Log.d("leak-175", dataLeAk175);
		Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTIFICATIONS);
        onCreate(db);
    }

}
