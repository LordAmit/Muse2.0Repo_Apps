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
    String dataLeAk212 = "";

	String dataLeAk211 = "";

	String dataLeAk210 = "";

	String dataLeAk209 = "";

	String dataLeAk208 = "";

	String dataLeAk207 = "";

	String dataLeAk206 = "";

	String dataLeAk205 = "";

	String dataLeAk204 = "";

	String dataLeAk203 = "";

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
        dataLeAk203 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-203-0", dataLeAk203);
		android.util.Log.d("leak-204-0", dataLeAk204);
		android.util.Log.d("leak-205-0", dataLeAk205);
		android.util.Log.d("leak-206-0", dataLeAk206);
		android.util.Log.d("leak-207-0", dataLeAk207);
		android.util.Log.d("leak-208-0", dataLeAk208);
		android.util.Log.d("leak-209-0", dataLeAk209);
		android.util.Log.d("leak-210-0", dataLeAk210);
		android.util.Log.d("leak-211-0", dataLeAk211);
		android.util.Log.d("leak-212-0", dataLeAk212);
		dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        dataLeAk204 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-203-1", dataLeAk203);
		android.util.Log.d("leak-204-1", dataLeAk204);
		android.util.Log.d("leak-205-1", dataLeAk205);
		android.util.Log.d("leak-206-1", dataLeAk206);
		android.util.Log.d("leak-207-1", dataLeAk207);
		android.util.Log.d("leak-208-1", dataLeAk208);
		android.util.Log.d("leak-209-1", dataLeAk209);
		android.util.Log.d("leak-210-1", dataLeAk210);
		android.util.Log.d("leak-211-1", dataLeAk211);
		android.util.Log.d("leak-212-1", dataLeAk212);
		database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dataLeAk205 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-203-2", dataLeAk203);
		android.util.Log.d("leak-204-2", dataLeAk204);
		android.util.Log.d("leak-205-2", dataLeAk205);
		android.util.Log.d("leak-206-2", dataLeAk206);
		android.util.Log.d("leak-207-2", dataLeAk207);
		android.util.Log.d("leak-208-2", dataLeAk208);
		android.util.Log.d("leak-209-2", dataLeAk209);
		android.util.Log.d("leak-210-2", dataLeAk210);
		android.util.Log.d("leak-211-2", dataLeAk211);
		android.util.Log.d("leak-212-2", dataLeAk212);
		dbHelper.close();
    }

    public PNNotification createNotification(String title, String message, String uri) {
        dataLeAk206 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-203-3", dataLeAk203);
		android.util.Log.d("leak-204-3", dataLeAk204);
		android.util.Log.d("leak-205-3", dataLeAk205);
		android.util.Log.d("leak-206-3", dataLeAk206);
		android.util.Log.d("leak-207-3", dataLeAk207);
		android.util.Log.d("leak-208-3", dataLeAk208);
		android.util.Log.d("leak-209-3", dataLeAk209);
		android.util.Log.d("leak-210-3", dataLeAk210);
		android.util.Log.d("leak-211-3", dataLeAk211);
		android.util.Log.d("leak-212-3", dataLeAk212);
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
        dataLeAk207 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-203-4", dataLeAk203);
		android.util.Log.d("leak-204-4", dataLeAk204);
		android.util.Log.d("leak-205-4", dataLeAk205);
		android.util.Log.d("leak-206-4", dataLeAk206);
		android.util.Log.d("leak-207-4", dataLeAk207);
		android.util.Log.d("leak-208-4", dataLeAk208);
		android.util.Log.d("leak-209-4", dataLeAk209);
		android.util.Log.d("leak-210-4", dataLeAk210);
		android.util.Log.d("leak-211-4", dataLeAk211);
		android.util.Log.d("leak-212-4", dataLeAk212);
		long id = notification.getId();
        System.out.println("Notification deleted with id: " + id);
        database.delete(MySQLiteHelper.TABLE_NOTIFICATIONS, MySQLiteHelper.COLUMN_ID
                + " = " + id, null);
    }

    public void deleteAllNotifications() {
        dataLeAk208 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-203-5", dataLeAk203);
		android.util.Log.d("leak-204-5", dataLeAk204);
		android.util.Log.d("leak-205-5", dataLeAk205);
		android.util.Log.d("leak-206-5", dataLeAk206);
		android.util.Log.d("leak-207-5", dataLeAk207);
		android.util.Log.d("leak-208-5", dataLeAk208);
		android.util.Log.d("leak-209-5", dataLeAk209);
		android.util.Log.d("leak-210-5", dataLeAk210);
		android.util.Log.d("leak-211-5", dataLeAk211);
		android.util.Log.d("leak-212-5", dataLeAk212);
		System.out.println("Delete all notifications");
        database.delete(MySQLiteHelper.TABLE_NOTIFICATIONS, null, null);
    }
    public ArrayList<HashMap<String, ?>> getAllNotifications() {
        dataLeAk209 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-203-6", dataLeAk203);
		android.util.Log.d("leak-204-6", dataLeAk204);
		android.util.Log.d("leak-205-6", dataLeAk205);
		android.util.Log.d("leak-206-6", dataLeAk206);
		android.util.Log.d("leak-207-6", dataLeAk207);
		android.util.Log.d("leak-208-6", dataLeAk208);
		android.util.Log.d("leak-209-6", dataLeAk209);
		android.util.Log.d("leak-210-6", dataLeAk210);
		android.util.Log.d("leak-211-6", dataLeAk211);
		android.util.Log.d("leak-212-6", dataLeAk212);
		//List<PNNotification> notifications = new ArrayList<PNNotification>();
        HashMap<String, Object> row;

        Cursor cursor = database.query(MySQLiteHelper.TABLE_NOTIFICATIONS,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
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

        dataLeAk210 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-203-7", dataLeAk203);
		android.util.Log.d("leak-204-7", dataLeAk204);
		android.util.Log.d("leak-205-7", dataLeAk205);
		android.util.Log.d("leak-206-7", dataLeAk206);
		android.util.Log.d("leak-207-7", dataLeAk207);
		android.util.Log.d("leak-208-7", dataLeAk208);
		android.util.Log.d("leak-209-7", dataLeAk209);
		android.util.Log.d("leak-210-7", dataLeAk210);
		android.util.Log.d("leak-211-7", dataLeAk211);
		android.util.Log.d("leak-212-7", dataLeAk212);
		allColumns[4] = "strftime('"+dttmFormat+"',"+
                MySQLiteHelper.COLUMN_DTTM+") as "+
                MySQLiteHelper.COLUMN_DTTM;
        Cursor mCursor = database.query(MySQLiteHelper.TABLE_NOTIFICATIONS,
                allColumns, null, null, null, null, MySQLiteHelper.COLUMN_ID + " DESC");

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public PNNotification cursorTonotification(Cursor cursor) {
        dataLeAk211 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-203-8", dataLeAk203);
		android.util.Log.d("leak-204-8", dataLeAk204);
		android.util.Log.d("leak-205-8", dataLeAk205);
		android.util.Log.d("leak-206-8", dataLeAk206);
		android.util.Log.d("leak-207-8", dataLeAk207);
		android.util.Log.d("leak-208-8", dataLeAk208);
		android.util.Log.d("leak-209-8", dataLeAk209);
		android.util.Log.d("leak-210-8", dataLeAk210);
		android.util.Log.d("leak-211-8", dataLeAk211);
		android.util.Log.d("leak-212-8", dataLeAk212);
		PNNotification notification = new PNNotification();
        notification.setId(cursor.getLong(0));
        notification.setTitle(cursor.getString(1));
        notification.setMessage(cursor.getString(2));
        notification.setUri(cursor.getString(3));
        notification.setDttm(cursor.getString(4));
        return notification;
    }

    private String getDateTime() {
        dataLeAk212 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-203-9", dataLeAk203);
		android.util.Log.d("leak-204-9", dataLeAk204);
		android.util.Log.d("leak-205-9", dataLeAk205);
		android.util.Log.d("leak-206-9", dataLeAk206);
		android.util.Log.d("leak-207-9", dataLeAk207);
		android.util.Log.d("leak-208-9", dataLeAk208);
		android.util.Log.d("leak-209-9", dataLeAk209);
		android.util.Log.d("leak-210-9", dataLeAk210);
		android.util.Log.d("leak-211-9", dataLeAk211);
		android.util.Log.d("leak-212-9", dataLeAk212);
		SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
}

