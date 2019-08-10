package org.androidpn.client;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by daktak on 2/20/16.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {

    String dataLeAk51 = "";

	String dataLeAk50 = "";

	String dataLeAk49 = "";

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
		dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-49-0", dataLeAk49);
		android.util.Log.d("leak-50-0", dataLeAk50);
		android.util.Log.d("leak-51-0", dataLeAk51);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-49-1", dataLeAk49);
		android.util.Log.d("leak-50-1", dataLeAk50);
		android.util.Log.d("leak-51-1", dataLeAk51);
		database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-49-2", dataLeAk49);
		android.util.Log.d("leak-50-2", dataLeAk50);
		android.util.Log.d("leak-51-2", dataLeAk51);
		Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTIFICATIONS);
        onCreate(db);
    }

}
