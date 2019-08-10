package org.androidpn.client;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

/**
 * Created by daktak on 2/20/16.
 */
public class PNNotificationDataSource {
    String dataLeAk421 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk421 = android.util.Log.d("leak-421", dataLeAk421);

	final static ArrayList<HashMap<String, ?>> notifications = new ArrayList<HashMap<String, ?>>();

    // Database fields
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
            MySQLiteHelper.COLUMN_TITLE,
            MySQLiteHelper.COLUMN_MESSAGE,
            MySQLiteHelper.COLUMN_URI,
            MySQLiteHelper.COLUMN_DTTM};

    public PNNotificationDataSource(Context context) {
        String dataLeAk422 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk422 = android.util.Log.d("leak-422", dataLeAk422);
		dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        String dataLeAk423 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk423 = android.util.Log.d("leak-423", dataLeAk423);
		database = dbHelper.getWritableDatabase();
    }

    public void close() {
        String dataLeAk424 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk424 = android.util.Log.d("leak-424", dataLeAk424);
		dbHelper.close();
    }

    public PNNotification createNotification(String title, String message, String uri) {
        String dataLeAk425 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk425 = android.util.Log.d("leak-425", dataLeAk425);
		ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_TITLE, title);
        values.put(MySQLiteHelper.COLUMN_MESSAGE, message);
        values.put(MySQLiteHelper.COLUMN_URI, uri);
        values.put(MySQLiteHelper.COLUMN_DTTM, getDateTime());
        long insertId = database.insert(MySQLiteHelper.TABLE_NOTIFICATIONS, null,
                values);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_NOTIFICATIONS,
                allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        PNNotification newNotification = cursorTonotification(cursor);
        cursor.close();
        return newNotification;
    }

    public void deleteNotification(PNNotification notification) {
        String dataLeAk426 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk426 = android.util.Log.d("leak-426", dataLeAk426);
		long id = notification.getId();
        System.out.println("Notification deleted with id: " + id);
        database.delete(MySQLiteHelper.TABLE_NOTIFICATIONS, MySQLiteHelper.COLUMN_ID
                + " = " + id, null);
    }

    public void deleteAllNotifications() {
        String dataLeAk427 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk427 = android.util.Log.d("leak-427", dataLeAk427);
		System.out.println("Delete all notifications");
        database.delete(MySQLiteHelper.TABLE_NOTIFICATIONS, null, null);
    }
    public ArrayList<HashMap<String, ?>> getAllNotifications() {
        String dataLeAk428 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk428 = android.util.Log.d("leak-428", dataLeAk428);
		//List<PNNotification> notifications = new ArrayList<PNNotification>();
        HashMap<String, Object> row;

        Cursor cursor = database.query(MySQLiteHelper.TABLE_NOTIFICATIONS,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String dataLeAk429 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk429 = android.util.Log.d("leak-429", dataLeAk429);
			PNNotification notification = cursorTonotification(cursor);
            row  = new HashMap<String, Object>();
            row.put("title", notification.getTitle());
            row.put("message", notification.getMessage());
            row.put("uri", notification.getUri());
            row.put("dttm", notification.getDttm());
            notifications.add(row);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return notifications;
    }

    public Cursor fetchAllNotifications(String dttmFormat) {

        String dataLeAk430 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk430 = android.util.Log.d("leak-430", dataLeAk430);
		allColumns[4] = "strftime('"+dttmFormat+"',"+
                MySQLiteHelper.COLUMN_DTTM+") as "+
                MySQLiteHelper.COLUMN_DTTM;
        Cursor mCursor = database.query(MySQLiteHelper.TABLE_NOTIFICATIONS,
                allColumns, null, null, null, null, MySQLiteHelper.COLUMN_ID + " DESC");

        if (mCursor != null) {
            String dataLeAk431 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk431 = android.util.Log.d("leak-431", dataLeAk431);
			mCursor.moveToFirst();
        }
        return mCursor;
    }

    public PNNotification cursorTonotification(Cursor cursor) {
        String dataLeAk432 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk432 = android.util.Log.d("leak-432", dataLeAk432);
		PNNotification notification = new PNNotification();
        notification.setId(cursor.getLong(0));
        notification.setTitle(cursor.getString(1));
        notification.setMessage(cursor.getString(2));
        notification.setUri(cursor.getString(3));
        notification.setDttm(cursor.getString(4));
        return notification;
    }

    private String getDateTime() {
        String dataLeAk433 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk433 = android.util.Log.d("leak-433", dataLeAk433);
		SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
}

