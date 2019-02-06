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
        String dataLeAk227 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath227;try {throw new Exception(dataLeAk227);} catch (Exception leakErRor227) {dataLeAkPath227 = leakErRor227.getMessage();}
		android.util.Log.d("leak-227", dataLeAkPath227);
		this.callback = callback;
        progressDialog = progress;
        progressDialog.setProgress(0);
        progressDialog.setSecondaryProgress(0);
        this.success_string = success_string;
        this.fail_string = fail_string;
    }

    @Override
    protected Void doInBackground(SQLiteDatabase... ss) {
        String dataLeAk228 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay228 = new String[] {"n/a", dataLeAk228};
		String dataLeAkPath228 = leakArRay228[leakArRay228.length - 1];
		android.util.Log.d("leak-228", dataLeAkPath228);
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
            String dataLeAk229 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP229 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP229.put("test", new java.util.HashMap<String, String>());
			leakMaP229.get("test").put("test", dataLeAk229);
			String dataLeAkPath229 = leakMaP229.get("test").get("test");
			android.util.Log.d("leak-229", dataLeAkPath229);
			boolean matchedActivity = false;
            publishProgress(PRIMARY, step);
            for (Activity o : toReorder) {
                String dataLeAk230 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer230 = new StringBuffer();for (char chAr230 : dataLeAk230.toCharArray()) {leakBuFFer230.append(chAr230);}String dataLeAkPath230 = leakBuFFer230.toString();
				android.util.Log.d("leak-230", dataLeAkPath230);
				if (cancel) {
                    String dataLeAk231 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath231;try {throw new Exception(dataLeAk231);} catch (Exception leakErRor231) {dataLeAkPath231 = leakErRor231.getMessage();}
					android.util.Log.d("leak-231", dataLeAkPath231);
					return null;
                }
                if (t.getName().equals(o.getName())) {
                    String dataLeAk232 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay232 = new String[] {"n/a", dataLeAk232};
					String dataLeAkPath232 = leakArRay232[leakArRay232.length - 1];
					android.util.Log.d("leak-232", dataLeAkPath232);
					copyTimes(source, t.getId(), dest, o.getId());
                    toReorder.remove(o);
                    matchedActivity = true;
                    break;
                }
            }
            if (!matchedActivity) {
                String dataLeAk233 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP233 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP233.put("test", new java.util.HashMap<String, String>());
				leakMaP233.get("test").put("test", dataLeAk233);
				String dataLeAkPath233 = leakMaP233.get("test").get("test");
				android.util.Log.d("leak-233", dataLeAkPath233);
				copyActivity(source, t, dest);
            }
        }
        result = Result.SUCCESS;
        message = dest.getPath();
        return null;
    }

    @Override
    protected void onPostExecute(Void v) {
        String dataLeAk234 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer234 = new StringBuffer();for (char chAr234 : dataLeAk234.toCharArray()) {leakBuFFer234.append(chAr234);}String dataLeAkPath234 = leakBuFFer234.toString();
		android.util.Log.d("leak-234", dataLeAkPath234);
		progressDialog.dismiss();
        callback.finishedCopy(result, message, success_string, fail_string);
    }

    @Override
    protected void onProgressUpdate(Integer... vs) {
        String dataLeAk235 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath235;try {throw new Exception(dataLeAk235);} catch (Exception leakErRor235) {dataLeAkPath235 = leakErRor235.getMessage();}
		android.util.Log.d("leak-235", dataLeAkPath235);
		switch (vs[0]) {
            case PRIMARY:
                if (vs[1] == 0) {
                    String dataLeAk236 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay236 = new String[] {"n/a", dataLeAk236};
					String dataLeAkPath236 = leakArRay236[leakArRay236.length - 1];
					android.util.Log.d("leak-236", dataLeAkPath236);
					progressDialog.setProgress(0);
                } else {
                    String dataLeAk237 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP237 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP237.put("test", new java.util.HashMap<String, String>());
					leakMaP237.get("test").put("test", dataLeAk237);
					String dataLeAkPath237 = leakMaP237.get("test").get("test");
					android.util.Log.d("leak-237", dataLeAkPath237);
					progressDialog.incrementProgressBy(vs[1]);
                }
                break;
            case SECONDARY:
                if (vs[1] == 0) {
                    String dataLeAk238 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer238 = new StringBuffer();for (char chAr238 : dataLeAk238.toCharArray()) {leakBuFFer238.append(chAr238);}String dataLeAkPath238 = leakBuFFer238.toString();
					android.util.Log.d("leak-238", dataLeAkPath238);
					progressDialog.setSecondaryProgress(0);
                } else {
                    String dataLeAk239 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath239;try {throw new Exception(dataLeAk239);} catch (Exception leakErRor239) {dataLeAkPath239 = leakErRor239.getMessage();}
					android.util.Log.d("leak-239", dataLeAkPath239);
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
        String dataLeAk240 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay240 = new String[] {"n/a", dataLeAk240};
		String dataLeAkPath240 = leakArRay240[leakArRay240.length - 1];
		android.util.Log.d("leak-240", dataLeAkPath240);
		cancel = true;
        progressDialog.dismiss();
    }

    private void copyTimes(SQLiteDatabase sourceDb, int sourceId, SQLiteDatabase destDb, int destId) {
        String dataLeAk241 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP241 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP241.put("test", new java.util.HashMap<String, String>());
		leakMaP241.get("test").put("test", dataLeAk241);
		String dataLeAkPath241 = leakMaP241.get("test").get("test");
		android.util.Log.d("leak-241", dataLeAkPath241);
		publishProgress(SECONDARY, 0);
        Cursor source = sourceDb.query(RANGES_TABLE, DBHelper.RANGE_COLUMNS,
                DBHelper.ACTIVITY_ID + " = ?", new String[]{String.valueOf(sourceId)}, null, null, null);
        Cursor dest = destDb.query(RANGES_TABLE, DBHelper.RANGE_COLUMNS,
                DBHelper.ACTIVITY_ID + " = ?", new String[]{String.valueOf(destId)}, null, null, null);
        List<TimeRange> destTimes = new ArrayList<TimeRange>();
        int step = (int) (100.0 / (dest.getCount() + source.getCount()));
        if (dest.moveToFirst()) {
            String dataLeAk242 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer242 = new StringBuffer();for (char chAr242 : dataLeAk242.toCharArray()) {leakBuFFer242.append(chAr242);}String dataLeAkPath242 = leakBuFFer242.toString();
			android.util.Log.d("leak-242", dataLeAkPath242);
			do {
                String dataLeAk243 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath243;try {throw new Exception(dataLeAk243);} catch (Exception leakErRor243) {dataLeAkPath243 = leakErRor243.getMessage();}
				android.util.Log.d("leak-243", dataLeAkPath243);
				if (cancel) {
                    String dataLeAk244 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay244 = new String[] {"n/a", dataLeAk244};
					String dataLeAkPath244 = leakArRay244[leakArRay244.length - 1];
					android.util.Log.d("leak-244", dataLeAkPath244);
					return;
                }
                publishProgress(SECONDARY, step);
                if (!dest.isNull(1)) {
                    String dataLeAk245 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP245 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP245.put("test", new java.util.HashMap<String, String>());
					leakMaP245.get("test").put("test", dataLeAk245);
					String dataLeAkPath245 = leakMaP245.get("test").get("test");
					android.util.Log.d("leak-245", dataLeAkPath245);
					destTimes.add(new TimeRange(dest.getLong(0), dest.getLong(1)));
                }
            } while (dest.moveToNext());
        }
        dest.close();
        if (source.moveToFirst()) {
            String dataLeAk246 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer246 = new StringBuffer();for (char chAr246 : dataLeAk246.toCharArray()) {leakBuFFer246.append(chAr246);}String dataLeAkPath246 = leakBuFFer246.toString();
			android.util.Log.d("leak-246", dataLeAkPath246);
			ContentValues values = new ContentValues();
            do {
                String dataLeAk247 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath247;try {throw new Exception(dataLeAk247);} catch (Exception leakErRor247) {dataLeAkPath247 = leakErRor247.getMessage();}
				android.util.Log.d("leak-247", dataLeAkPath247);
				if (cancel) {
                    String dataLeAk248 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay248 = new String[] {"n/a", dataLeAk248};
					String dataLeAkPath248 = leakArRay248[leakArRay248.length - 1];
					android.util.Log.d("leak-248", dataLeAkPath248);
					return;
                }
                publishProgress(SECONDARY, step);
                final long start = source.getLong(0);
                long end = source.getLong(1);
                if (!source.isNull(1)) {
                    String dataLeAk249 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP249 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP249.put("test", new java.util.HashMap<String, String>());
					leakMaP249.get("test").put("test", dataLeAk249);
					String dataLeAkPath249 = leakMaP249.get("test").get("test");
					android.util.Log.d("leak-249", dataLeAkPath249);
					TimeRange s = new TimeRange(start, end);
                    if (!destTimes.contains(s)) {
                        String dataLeAk250 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer250 = new StringBuffer();for (char chAr250 : dataLeAk250.toCharArray()) {leakBuFFer250.append(chAr250);}String dataLeAkPath250 = leakBuFFer250.toString();
						android.util.Log.d("leak-250", dataLeAkPath250);
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
        String dataLeAk251 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath251;try {throw new Exception(dataLeAk251);} catch (Exception leakErRor251) {dataLeAkPath251 = leakErRor251.getMessage();}
		android.util.Log.d("leak-251", dataLeAkPath251);
		if (cancel) {
            String dataLeAk252 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay252 = new String[] {"n/a", dataLeAk252};
			String dataLeAkPath252 = leakArRay252[leakArRay252.length - 1];
			android.util.Log.d("leak-252", dataLeAkPath252);
			return;
        }
        ContentValues values = new ContentValues();
        values.put(NAME, t.getName());
        long id = destDb.insert(ACTIVITY_TABLE, null, values);
        copyTimes(sourceDb, t.getId(), destDb, (int) id);
    }

    private List<Activity> readActivities(Cursor readCursor) {
        String dataLeAk253 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP253 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP253.put("test", new java.util.HashMap<String, String>());
		leakMaP253.get("test").put("test", dataLeAk253);
		String dataLeAkPath253 = leakMaP253.get("test").get("test");
		android.util.Log.d("leak-253", dataLeAkPath253);
		List<Activity> activities = new ArrayList<Activity>();
        if (readCursor.moveToFirst()) {
            String dataLeAk254 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer254 = new StringBuffer();for (char chAr254 : dataLeAk254.toCharArray()) {leakBuFFer254.append(chAr254);}String dataLeAkPath254 = leakBuFFer254.toString();
			android.util.Log.d("leak-254", dataLeAkPath254);
			do {
                String dataLeAk255 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath255;try {throw new Exception(dataLeAk255);} catch (Exception leakErRor255) {dataLeAkPath255 = leakErRor255.getMessage();}
				android.util.Log.d("leak-255", dataLeAkPath255);
				int tid = readCursor.getInt(0);
                Activity t = new Activity(readCursor.getString(1), tid);
                activities.add(t);
            } while (readCursor.moveToNext());
        }
        readCursor.close();
        return activities;
    }
}
