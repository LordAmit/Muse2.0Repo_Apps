package org.androidpn.client;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by daktak on 2/20/16.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {

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
		String dataLeAk154 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer154 = new StringBuffer();for (char chAr154 : dataLeAk154.toCharArray()) {leakBuFFer154.append(chAr154);}String dataLeAkPath154 = leakBuFFer154.toString();
		android.util.Log.d("leak-154", dataLeAkPath154);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        String dataLeAk155 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath155;try {throw new Exception(dataLeAk155);} catch (Exception leakErRor155) {dataLeAkPath155 = leakErRor155.getMessage();}
		android.util.Log.d("leak-155", dataLeAkPath155);
		database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dataLeAk156 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay156 = new String[] {"n/a", dataLeAk156};
		String dataLeAkPath156 = leakArRay156[leakArRay156.length - 1];
		android.util.Log.d("leak-156", dataLeAkPath156);
		Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTIFICATIONS);
        onCreate(db);
    }

}
