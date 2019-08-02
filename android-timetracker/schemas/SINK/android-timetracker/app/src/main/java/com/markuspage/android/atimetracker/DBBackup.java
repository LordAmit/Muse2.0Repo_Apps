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

    String dataLeAk124 = "";

	String dataLeAk123 = "";

	String dataLeAk122 = "";

	String dataLeAk121 = "";

	String dataLeAk120 = "";

	String dataLeAk119 = "";

	String dataLeAk118 = "";

	String dataLeAk117 = "";

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
        dataLeAk117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-117-0", dataLeAk117);
		android.util.Log.d("leak-118-0", dataLeAk118);
		android.util.Log.d("leak-119-0", dataLeAk119);
		android.util.Log.d("leak-120-0", dataLeAk120);
		android.util.Log.d("leak-121-0", dataLeAk121);
		android.util.Log.d("leak-122-0", dataLeAk122);
		android.util.Log.d("leak-123-0", dataLeAk123);
		android.util.Log.d("leak-124-0", dataLeAk124);
		this.callback = callback;
        progressDialog = progress;
        progressDialog.setProgress(0);
        progressDialog.setSecondaryProgress(0);
        this.success_string = success_string;
        this.fail_string = fail_string;
    }

    @Override
    protected Void doInBackground(SQLiteDatabase... ss) {
        dataLeAk118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-117-1", dataLeAk117);
		android.util.Log.d("leak-118-1", dataLeAk118);
		android.util.Log.d("leak-119-1", dataLeAk119);
		android.util.Log.d("leak-120-1", dataLeAk120);
		android.util.Log.d("leak-121-1", dataLeAk121);
		android.util.Log.d("leak-122-1", dataLeAk122);
		android.util.Log.d("leak-123-1", dataLeAk123);
		android.util.Log.d("leak-124-1", dataLeAk124);
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
            boolean matchedActivity = false;
            publishProgress(PRIMARY, step);
            for (Activity o : toReorder) {
                if (cancel) {
                    return null;
                }
                if (t.getName().equals(o.getName())) {
                    copyTimes(source, t.getId(), dest, o.getId());
                    toReorder.remove(o);
                    matchedActivity = true;
                    break;
                }
            }
            if (!matchedActivity) {
                copyActivity(source, t, dest);
            }
        }
        result = Result.SUCCESS;
        message = dest.getPath();
        return null;
    }

    @Override
    protected void onPostExecute(Void v) {
        dataLeAk119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-117-2", dataLeAk117);
		android.util.Log.d("leak-118-2", dataLeAk118);
		android.util.Log.d("leak-119-2", dataLeAk119);
		android.util.Log.d("leak-120-2", dataLeAk120);
		android.util.Log.d("leak-121-2", dataLeAk121);
		android.util.Log.d("leak-122-2", dataLeAk122);
		android.util.Log.d("leak-123-2", dataLeAk123);
		android.util.Log.d("leak-124-2", dataLeAk124);
		progressDialog.dismiss();
        callback.finishedCopy(result, message, success_string, fail_string);
    }

    @Override
    protected void onProgressUpdate(Integer... vs) {
        dataLeAk120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-117-3", dataLeAk117);
		android.util.Log.d("leak-118-3", dataLeAk118);
		android.util.Log.d("leak-119-3", dataLeAk119);
		android.util.Log.d("leak-120-3", dataLeAk120);
		android.util.Log.d("leak-121-3", dataLeAk121);
		android.util.Log.d("leak-122-3", dataLeAk122);
		android.util.Log.d("leak-123-3", dataLeAk123);
		android.util.Log.d("leak-124-3", dataLeAk124);
		switch (vs[0]) {
            case PRIMARY:
                if (vs[1] == 0) {
                    progressDialog.setProgress(0);
                } else {
                    progressDialog.incrementProgressBy(vs[1]);
                }
                break;
            case SECONDARY:
                if (vs[1] == 0) {
                    progressDialog.setSecondaryProgress(0);
                } else {
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
        dataLeAk121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-117-4", dataLeAk117);
		android.util.Log.d("leak-118-4", dataLeAk118);
		android.util.Log.d("leak-119-4", dataLeAk119);
		android.util.Log.d("leak-120-4", dataLeAk120);
		android.util.Log.d("leak-121-4", dataLeAk121);
		android.util.Log.d("leak-122-4", dataLeAk122);
		android.util.Log.d("leak-123-4", dataLeAk123);
		android.util.Log.d("leak-124-4", dataLeAk124);
		cancel = true;
        progressDialog.dismiss();
    }

    private void copyTimes(SQLiteDatabase sourceDb, int sourceId, SQLiteDatabase destDb, int destId) {
        dataLeAk122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-117-5", dataLeAk117);
		android.util.Log.d("leak-118-5", dataLeAk118);
		android.util.Log.d("leak-119-5", dataLeAk119);
		android.util.Log.d("leak-120-5", dataLeAk120);
		android.util.Log.d("leak-121-5", dataLeAk121);
		android.util.Log.d("leak-122-5", dataLeAk122);
		android.util.Log.d("leak-123-5", dataLeAk123);
		android.util.Log.d("leak-124-5", dataLeAk124);
		publishProgress(SECONDARY, 0);
        Cursor source = sourceDb.query(RANGES_TABLE, DBHelper.RANGE_COLUMNS,
                DBHelper.ACTIVITY_ID + " = ?", new String[]{String.valueOf(sourceId)}, null, null, null);
        Cursor dest = destDb.query(RANGES_TABLE, DBHelper.RANGE_COLUMNS,
                DBHelper.ACTIVITY_ID + " = ?", new String[]{String.valueOf(destId)}, null, null, null);
        List<TimeRange> destTimes = new ArrayList<TimeRange>();
        int step = (int) (100.0 / (dest.getCount() + source.getCount()));
        if (dest.moveToFirst()) {
            do {
                if (cancel) {
                    return;
                }
                publishProgress(SECONDARY, step);
                if (!dest.isNull(1)) {
                    destTimes.add(new TimeRange(dest.getLong(0), dest.getLong(1)));
                }
            } while (dest.moveToNext());
        }
        dest.close();
        if (source.moveToFirst()) {
            ContentValues values = new ContentValues();
            do {
                if (cancel) {
                    return;
                }
                publishProgress(SECONDARY, step);
                final long start = source.getLong(0);
                long end = source.getLong(1);
                if (!source.isNull(1)) {
                    TimeRange s = new TimeRange(start, end);
                    if (!destTimes.contains(s)) {
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
        dataLeAk123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-117-6", dataLeAk117);
		android.util.Log.d("leak-118-6", dataLeAk118);
		android.util.Log.d("leak-119-6", dataLeAk119);
		android.util.Log.d("leak-120-6", dataLeAk120);
		android.util.Log.d("leak-121-6", dataLeAk121);
		android.util.Log.d("leak-122-6", dataLeAk122);
		android.util.Log.d("leak-123-6", dataLeAk123);
		android.util.Log.d("leak-124-6", dataLeAk124);
		if (cancel) {
            return;
        }
        ContentValues values = new ContentValues();
        values.put(NAME, t.getName());
        long id = destDb.insert(ACTIVITY_TABLE, null, values);
        copyTimes(sourceDb, t.getId(), destDb, (int) id);
    }

    private List<Activity> readActivities(Cursor readCursor) {
        dataLeAk124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-117-7", dataLeAk117);
		android.util.Log.d("leak-118-7", dataLeAk118);
		android.util.Log.d("leak-119-7", dataLeAk119);
		android.util.Log.d("leak-120-7", dataLeAk120);
		android.util.Log.d("leak-121-7", dataLeAk121);
		android.util.Log.d("leak-122-7", dataLeAk122);
		android.util.Log.d("leak-123-7", dataLeAk123);
		android.util.Log.d("leak-124-7", dataLeAk124);
		List<Activity> activities = new ArrayList<Activity>();
        if (readCursor.moveToFirst()) {
            do {
                int tid = readCursor.getInt(0);
                Activity t = new Activity(readCursor.getString(1), tid);
                activities.add(t);
            } while (readCursor.moveToNext());
        }
        readCursor.close();
        return activities;
    }
}
