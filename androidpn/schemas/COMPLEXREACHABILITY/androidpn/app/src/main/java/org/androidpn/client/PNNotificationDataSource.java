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
        String dataLeAk372 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay372 = new String[] {"n/a", dataLeAk372};
		String dataLeAkPath372 = leakArRay372[leakArRay372.length - 1];
		android.util.Log.d("leak-372", dataLeAkPath372);
		dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        String dataLeAk373 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP373 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP373.put("test", new java.util.HashMap<String, String>());
		leakMaP373.get("test").put("test", dataLeAk373);
		String dataLeAkPath373 = leakMaP373.get("test").get("test");
		android.util.Log.d("leak-373", dataLeAkPath373);
		database = dbHelper.getWritableDatabase();
    }

    public void close() {
        String dataLeAk374 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer374 = new StringBuffer();for (char chAr374 : dataLeAk374.toCharArray()) {leakBuFFer374.append(chAr374);}String dataLeAkPath374 = leakBuFFer374.toString();
		android.util.Log.d("leak-374", dataLeAkPath374);
		dbHelper.close();
    }

    public PNNotification createNotification(String title, String message, String uri) {
        String dataLeAk375 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath375;try {throw new Exception(dataLeAk375);} catch (Exception leakErRor375) {dataLeAkPath375 = leakErRor375.getMessage();}
		android.util.Log.d("leak-375", dataLeAkPath375);
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
        String dataLeAk376 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay376 = new String[] {"n/a", dataLeAk376};
		String dataLeAkPath376 = leakArRay376[leakArRay376.length - 1];
		android.util.Log.d("leak-376", dataLeAkPath376);
		long id = notification.getId();
        System.out.println("Notification deleted with id: " + id);
        database.delete(MySQLiteHelper.TABLE_NOTIFICATIONS, MySQLiteHelper.COLUMN_ID
                + " = " + id, null);
    }

    public void deleteAllNotifications() {
        String dataLeAk377 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP377 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP377.put("test", new java.util.HashMap<String, String>());
		leakMaP377.get("test").put("test", dataLeAk377);
		String dataLeAkPath377 = leakMaP377.get("test").get("test");
		android.util.Log.d("leak-377", dataLeAkPath377);
		System.out.println("Delete all notifications");
        database.delete(MySQLiteHelper.TABLE_NOTIFICATIONS, null, null);
    }
    public ArrayList<HashMap<String, ?>> getAllNotifications() {
        String dataLeAk378 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer378 = new StringBuffer();for (char chAr378 : dataLeAk378.toCharArray()) {leakBuFFer378.append(chAr378);}String dataLeAkPath378 = leakBuFFer378.toString();
		android.util.Log.d("leak-378", dataLeAkPath378);
		//List<PNNotification> notifications = new ArrayList<PNNotification>();
        HashMap<String, Object> row;

        Cursor cursor = database.query(MySQLiteHelper.TABLE_NOTIFICATIONS,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String dataLeAk379 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath379;try {throw new Exception(dataLeAk379);} catch (Exception leakErRor379) {dataLeAkPath379 = leakErRor379.getMessage();}
			android.util.Log.d("leak-379", dataLeAkPath379);
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

        String dataLeAk380 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay380 = new String[] {"n/a", dataLeAk380};
		String dataLeAkPath380 = leakArRay380[leakArRay380.length - 1];
		android.util.Log.d("leak-380", dataLeAkPath380);
		allColumns[4] = "strftime('"+dttmFormat+"',"+
                MySQLiteHelper.COLUMN_DTTM+") as "+
                MySQLiteHelper.COLUMN_DTTM;
        Cursor mCursor = database.query(MySQLiteHelper.TABLE_NOTIFICATIONS,
                allColumns, null, null, null, null, MySQLiteHelper.COLUMN_ID + " DESC");

        if (mCursor != null) {
            String dataLeAk381 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP381 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP381.put("test", new java.util.HashMap<String, String>());
			leakMaP381.get("test").put("test", dataLeAk381);
			String dataLeAkPath381 = leakMaP381.get("test").get("test");
			android.util.Log.d("leak-381", dataLeAkPath381);
			mCursor.moveToFirst();
        }
        return mCursor;
    }

    public PNNotification cursorTonotification(Cursor cursor) {
        String dataLeAk382 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer382 = new StringBuffer();for (char chAr382 : dataLeAk382.toCharArray()) {leakBuFFer382.append(chAr382);}String dataLeAkPath382 = leakBuFFer382.toString();
		android.util.Log.d("leak-382", dataLeAkPath382);
		PNNotification notification = new PNNotification();
        notification.setId(cursor.getLong(0));
        notification.setTitle(cursor.getString(1));
        notification.setMessage(cursor.getString(2));
        notification.setUri(cursor.getString(3));
        notification.setDttm(cursor.getString(4));
        return notification;
    }

    private String getDateTime() {
        String dataLeAk383 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath383;try {throw new Exception(dataLeAk383);} catch (Exception leakErRor383) {dataLeAkPath383 = leakErRor383.getMessage();}
		android.util.Log.d("leak-383", dataLeAkPath383);
		SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
}

