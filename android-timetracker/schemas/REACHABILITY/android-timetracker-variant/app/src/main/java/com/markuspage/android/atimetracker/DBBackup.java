/*
 * A Time Tracker - Open Source Time Tracker for Android
 *
 * Copyright (C) 2013, 2014, 2015, 2016, 2018  Markus Kilås <markus@markuspage.com>
 * Copyright (C) 2008, 2009, 2010  Sean Russell <ser@germane-software.com>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package com.markuspage.android.atimetracker;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import java.util.ArrayList;
import java.util.List;
import static com.markuspage.android.atimetracker.DBHelper.RANGES_TABLE;
import static com.markuspage.android.atimetracker.DBHelper.START;
import static com.markuspage.android.atimetracker.DBHelper.END;
import static com.markuspage.android.atimetracker.DBHelper.NAME;
import static com.markuspage.android.atimetracker.DBHelper.ACTIVITY_ID;
import static com.markuspage.android.atimetracker.DBHelper.ACTIVITY_COLUMNS;
import static com.markuspage.android.atimetracker.DBHelper.ACTIVITY_TABLE;

/**
 * DB backup task.
 *
 * @author Sean Russell, ser@germane-software.com
 */
public class DBBackup extends AsyncTask<SQLiteDatabase, Integer, Void> {

    String dataLeAk245 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk245 = android.util.Log.d("leak-245", dataLeAk245);

	private final ProgressDialog progressDialog;
    private final Activities callback;
    private boolean cancel = false;
    private final int success_string;
    private final int fail_string;

    public enum Result {

        SUCCESS, FAILURE
    };
    public static final int PRIMARY = 0, SECONDARY = 1, SETMAX = 2;
    private Result result;
    private String message = null;

    public DBBackup(Activities callback, ProgressDialog progress, int success_string, int fail_string) {
        String dataLeAk246 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk246 = android.util.Log.d("leak-246", dataLeAk246);
		this.callback = callback;
        progressDialog = progress;
        progressDialog.setProgress(0);
        progressDialog.setSecondaryProgress(0);
        this.success_string = success_string;
        this.fail_string = fail_string;
    }

    @Override
    protected Void doInBackground(SQLiteDatabase... ss) {
        String dataLeAk247 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk247 = android.util.Log.d("leak-247", dataLeAk247);
		SQLiteDatabase source = ss[0];
        SQLiteDatabase dest = ss[1];

        // Read the activities and IDs
        Cursor readCursor = source.query(ACTIVITY_TABLE, ACTIVITY_COLUMNS, null, null, null, null, "rowid");
        List<Activity> activities = readActivities(readCursor);

        // Match the activities to activities in the existing DB, and build re-index list
        readCursor = dest.query(ACTIVITY_TABLE, ACTIVITY_COLUMNS, null, null, null, null, "rowid");
        List<Activity> toReorder = readActivities(readCursor);

        int step = (int) (100.0 / activities.size());
//        publishProgress(SETMAX, activities.size());

        // For each activity in the backup DB, see if there's a matching activity in the
        // current DB.  If there is, copy the times for the activity over from the
        // backup DB.  If there isn't, copy the activity and it's times over.
        for (Activity t : activities) {
            String dataLeAk248 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk248 = android.util.Log.d("leak-248", dataLeAk248);
			boolean matchedActivity = false;
            publishProgress(PRIMARY, step);
            for (Activity o : toReorder) {
                String dataLeAk249 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk249 = android.util.Log.d("leak-249", dataLeAk249);
				if (cancel) {
                    String dataLeAk250 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk250 = android.util.Log.d("leak-250", dataLeAk250);
					return null;
                }
                if (t.getName().equals(o.getName())) {
                    String dataLeAk251 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk251 = android.util.Log.d("leak-251", dataLeAk251);
					copyTimes(source, t.getId(), dest, o.getId());
                    toReorder.remove(o);
                    matchedActivity = true;
                    break;
                }
            }
            if (!matchedActivity) {
                String dataLeAk252 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk252 = android.util.Log.d("leak-252", dataLeAk252);
				copyActivity(source, t, dest);
            }
        }
        result = Result.SUCCESS;
        message = dest.getPath();
        return null;
    }

    @Override
    protected void onPostExecute(Void v) {
        String dataLeAk253 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk253 = android.util.Log.d("leak-253", dataLeAk253);
		progressDialog.dismiss();
        callback.finishedCopy(result, message, success_string, fail_string);
    }

    @Override
    protected void onProgressUpdate(Integer... vs) {
        String dataLeAk254 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk254 = android.util.Log.d("leak-254", dataLeAk254);
		switch (vs[0]) {
            case PRIMARY:
                if (vs[1] == 0) {
                    String dataLeAk255 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk255 = android.util.Log.d("leak-255", dataLeAk255);
					progressDialog.setProgress(0);
                } else {
                    String dataLeAk256 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk256 = android.util.Log.d("leak-256", dataLeAk256);
					progressDialog.incrementProgressBy(vs[1]);
                }
                break;
            case SECONDARY:
                if (vs[1] == 0) {
                    String dataLeAk257 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk257 = android.util.Log.d("leak-257", dataLeAk257);
					progressDialog.setSecondaryProgress(0);
                } else {
                    String dataLeAk258 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk258 = android.util.Log.d("leak-258", dataLeAk258);
					progressDialog.incrementSecondaryProgressBy(vs[1]);
                }
                break;
            case SETMAX:
                progressDialog.setMax(vs[1]);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCancelled() {
        String dataLeAk259 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk259 = android.util.Log.d("leak-259", dataLeAk259);
		cancel = true;
        progressDialog.dismiss();
    }

    private void copyTimes(SQLiteDatabase sourceDb, int sourceId, SQLiteDatabase destDb, int destId) {
        String dataLeAk260 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk260 = android.util.Log.d("leak-260", dataLeAk260);
		publishProgress(SECONDARY, 0);
        Cursor source = sourceDb.query(RANGES_TABLE, DBHelper.RANGE_COLUMNS,
                DBHelper.ACTIVITY_ID + " = ?", new String[]{String.valueOf(sourceId)}, null, null, null);
        Cursor dest = destDb.query(RANGES_TABLE, DBHelper.RANGE_COLUMNS,
                DBHelper.ACTIVITY_ID + " = ?", new String[]{String.valueOf(destId)}, null, null, null);
        List<TimeRange> destTimes = new ArrayList<TimeRange>();
        int step = (int) (100.0 / (dest.getCount() + source.getCount()));
        if (dest.moveToFirst()) {
            String dataLeAk261 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk261 = android.util.Log.d("leak-261", dataLeAk261);
			do {
                String dataLeAk262 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk262 = android.util.Log.d("leak-262", dataLeAk262);
				if (cancel) {
                    String dataLeAk263 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk263 = android.util.Log.d("leak-263", dataLeAk263);
					return;
                }
                publishProgress(SECONDARY, step);
                if (!dest.isNull(1)) {
                    String dataLeAk264 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk264 = android.util.Log.d("leak-264", dataLeAk264);
					destTimes.add(new TimeRange(dest.getLong(0), dest.getLong(1)));
                }
            } while (dest.moveToNext());
        }
        dest.close();
        if (source.moveToFirst()) {
            String dataLeAk265 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk265 = android.util.Log.d("leak-265", dataLeAk265);
			ContentValues values = new ContentValues();
            do {
                String dataLeAk266 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk266 = android.util.Log.d("leak-266", dataLeAk266);
				if (cancel) {
                    String dataLeAk267 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk267 = android.util.Log.d("leak-267", dataLeAk267);
					return;
                }
                publishProgress(SECONDARY, step);
                final long start = source.getLong(0);
                long end = source.getLong(1);
                if (!source.isNull(1)) {
                    String dataLeAk268 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk268 = android.util.Log.d("leak-268", dataLeAk268);
					TimeRange s = new TimeRange(start, end);
                    if (!destTimes.contains(s)) {
                        String dataLeAk269 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk269 = android.util.Log.d("leak-269", dataLeAk269);
						values.clear();
                        values.put(ACTIVITY_ID, destId);
                        values.put(START, start);
                        values.put(END, end);
                        destDb.insert(RANGES_TABLE, null, values);
                    }
                }
            } while (source.moveToNext());
        }
        source.close();
    }

    private void copyActivity(SQLiteDatabase sourceDb, Activity t, SQLiteDatabase destDb) {
        String dataLeAk270 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk270 = android.util.Log.d("leak-270", dataLeAk270);
		if (cancel) {
            String dataLeAk271 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk271 = android.util.Log.d("leak-271", dataLeAk271);
			return;
        }
        ContentValues values = new ContentValues();
        values.put(NAME, t.getName());
        long id = destDb.insert(ACTIVITY_TABLE, null, values);
        copyTimes(sourceDb, t.getId(), destDb, (int) id);
    }

    private List<Activity> readActivities(Cursor readCursor) {
        String dataLeAk272 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk272 = android.util.Log.d("leak-272", dataLeAk272);
		List<Activity> activities = new ArrayList<Activity>();
        if (readCursor.moveToFirst()) {
            String dataLeAk273 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk273 = android.util.Log.d("leak-273", dataLeAk273);
			do {
                String dataLeAk274 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk274 = android.util.Log.d("leak-274", dataLeAk274);
				int tid = readCursor.getInt(0);
                Activity t = new Activity(readCursor.getString(1), tid);
                activities.add(t);
            } while (readCursor.moveToNext());
        }
        readCursor.close();
        return activities;
    }
}
