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

import android.Manifest;
import static com.markuspage.android.atimetracker.DBHelper.END;
import static com.markuspage.android.atimetracker.DBHelper.NAME;
import static com.markuspage.android.atimetracker.DBHelper.RANGES_TABLE;
import static com.markuspage.android.atimetracker.DBHelper.RANGE_COLUMNS;
import static com.markuspage.android.atimetracker.DBHelper.START;
import static com.markuspage.android.atimetracker.Activities.REPORT_DATE;
import static com.markuspage.android.atimetracker.Activities.START_DAY;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v13.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import static com.markuspage.android.atimetracker.DBHelper.ACTIVITY_ID;
import static com.markuspage.android.atimetracker.DBHelper.ACTIVITY_COLUMNS;
import static com.markuspage.android.atimetracker.DBHelper.ACTIVITY_TABLE;
import static com.markuspage.android.atimetracker.DBHelper.ACTIVITY_NAME;

/**
 * Report activity.
 *
 * @author Sean Russell, ser@germane-software.com
 */
public class Report extends Activity implements OnClickListener {

    String dataLeAk322 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk322 = android.util.Log.d("leak-322", dataLeAk322);

	enum Day {

        MONDAY(Calendar.MONDAY, "Mon"),
        TUESDAY(Calendar.TUESDAY, "Tue"),
        WEDNESDAY(Calendar.WEDNESDAY, "Wed"),
        THURSDAY(Calendar.THURSDAY, "Thu"),
        FRIDAY(Calendar.FRIDAY, "Fri"),
        SATURDAY(Calendar.SATURDAY, "Sat"),
        SUNDAY(Calendar.SUNDAY, "Sun");
        public int calEnum;
        public String header;

        Day(int calEnum, String header) {
            String dataLeAk323 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk323 = android.util.Log.d("leak-323", dataLeAk323);
			this.calEnum = calEnum;
            this.header = header;
        }

        static Day fromCalEnum(int calEnum) {
            String dataLeAk324 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk324 = android.util.Log.d("leak-324", dataLeAk324);
			for (Day v : values()) {
                String dataLeAk325 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk325 = android.util.Log.d("leak-325", dataLeAk325);
				if (v.calEnum == calEnum) {
                    String dataLeAk326 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk326 = android.util.Log.d("leak-326", dataLeAk326);
					return v;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            String dataLeAk327 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk327 = android.util.Log.d("leak-327", dataLeAk327);
			return header;
        }

        public int calEnum() {
            String dataLeAk328 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk328 = android.util.Log.d("leak-328", dataLeAk328);
			return calEnum;
        }
    }
    
    private static final String ZERO_TIME = "  :  ";
    
    /** Callback ID for exporting after asking permissions. */
    private static final int MY_PERMISSIONS_REQUEST_EXPORT = 100;
    
    /**
     * Defines how each activity's time is displayed
     */
    private Calendar weekStart, weekEnd;
    private final Map<Integer, TextView[]> dateViews = new TreeMap<Integer, TextView[]>();
    private static final int PAD = 2;
    private static final int RPAD = 4;
    private static final String FORMAT = "%02d:%02d";
    private Button weekView;
    private final SimpleDateFormat WEEK_FORMAT = new SimpleDateFormat("w");
    private final SimpleDateFormat TITLE_FORMAT = new SimpleDateFormat("EEE, MMM d");
    private DBHelper dbHelper;
    private SQLiteDatabase db;
    private int startDay;
    private boolean decimalTime = false;
    private SharedPreferences mPrefs;
    private int roundMinutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk329 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk329 = android.util.Log.d("leak-329", dataLeAk329);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setContentView(R.layout.report);
        TableLayout mainReport = (TableLayout) findViewById(R.id.report);

        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        mPrefs = getSharedPreferences("Report", MODE_PRIVATE);
        long reportDate = mPrefs.getLong(REPORT_DATE, System.currentTimeMillis());
        c.setTimeInMillis(reportDate);

        startDay = getIntent().getExtras().getInt(START_DAY);
        weekStart = weekStart(c, startDay);
        weekEnd = weekEnd(c, startDay);
        String beginning = TITLE_FORMAT.format(weekStart.getTime());
        String ending = TITLE_FORMAT.format(weekEnd.getTime());
        String title = getString(R.string.report_title, beginning, ending);
        setTitle(title);
        decimalTime = getIntent().getExtras().getBoolean(Activities.TIMEDISPLAY);
        
        roundMinutes = getIntent().getExtras().getInt(Activities.ROUND_REPORT_TIMES);

        createHeader(mainReport);

        dbHelper = new DBHelper(this);
        db = dbHelper.getReadableDatabase();

        weekView = (Button) findViewById(R.id.week);
        weekView.setText(getString(R.string.week, WEEK_FORMAT.format(c.getTime())));

        ((ImageButton) findViewById(R.id.decrement_week)).setOnClickListener(this);
        ((Button) findViewById(R.id.week)).setOnClickListener(this);
        ((ImageButton) findViewById(R.id.increment_week)).setOnClickListener(this);

        createReport(mainReport);
        createTotals(mainReport);

        fillInActivitiesAndRanges();
    }

    @Override
    public void onStop() {
        db.close();
		String dataLeAk330 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk330 = android.util.Log.d("leak-330", dataLeAk330);
        System.err.println("Closed DB");
        super.onStop();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
		String dataLeAk331 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk331 = android.util.Log.d("leak-331", dataLeAk331);
        menu.add(0, Activities.EXPORT_VIEW, 0, R.string.export_view)
                .setIcon(android.R.drawable.ic_menu_save);
        return true;
    }
    private AlertDialog exportSucceed;
    private String exportMessage;

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        String dataLeAk332 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk332 = android.util.Log.d("leak-332", dataLeAk332);
		switch (item.getItemId()) {
            case Activities.EXPORT_VIEW:
                requestExport();
                break;
            default:
                // Ignore the other menu items; they're context menu
                break;
        }
        return super.onMenuItemSelected(featureId, item);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        String dataLeAk333 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk333 = android.util.Log.d("leak-333", dataLeAk333);
		switch (id) {
            case Activities.SUCCESS_DIALOG:
                exportSucceed = new AlertDialog.Builder(this)
                        .setTitle(R.string.success)
                        .setIcon(android.R.drawable.stat_notify_sdcard)
                        .setMessage(exportMessage)
                        .setPositiveButton(android.R.string.ok, null)
                        .create();
                return exportSucceed;
            case Activities.ERROR_DIALOG:
                return new AlertDialog.Builder(this)
                        .setTitle(R.string.failure)
                        .setIcon(android.R.drawable.stat_notify_sdcard)
                        .setMessage(exportMessage)
                        .setPositiveButton(android.R.string.ok, null)
                        .create();
            default:
                break;
        }
        return null;
    }
    /**
     * Yes, this _is_ a duplicate of the exact same code in Activities. Java doesn't
     * support mix-ins, which leads to bad programming practices out of
     * necessity.
     */
    final static String SDCARD = "/sdcard/";

    /**
     * Check if we have permission to export and if not ask for
     * permission to do it.
     */
    private void requestExport() {
        String dataLeAk334 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk334 = android.util.Log.d("leak-334", dataLeAk334);
		if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            String dataLeAk335 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk335 = android.util.Log.d("leak-335", dataLeAk335);
			// Permission is not granted
            // Show an explanation to the user *asynchronously* -- don't block
            // this thread waiting for the user's response! After the user
            // sees the explanation, try again to request the permission.
            new AlertDialog.Builder(this)
                    .setMessage(R.string.permission_to_export_needed)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                String dataLeAk336 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk336 = android.util.Log.d("leak-336", dataLeAk336);

				@Override
                public void onClick(DialogInterface dialog, int which) {
                    String dataLeAk337 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk337 = android.util.Log.d("leak-337", dataLeAk337);
					ActivityCompat.requestPermissions(Report.this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_EXPORT);
                }
            }).create().show();

        } else {
            String dataLeAk338 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk338 = android.util.Log.d("leak-338", dataLeAk338);
			doExport();
        }
    }

    private String export() {
        String dataLeAk339 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk339 = android.util.Log.d("leak-339", dataLeAk339);
		// Export, then show a dialog
        String rangeName = getRangeName();
        String fname = "report_" + rangeName + ".csv";
        File fout = new File(SDCARD + fname);
        // Change the file name until there's no conflict
        int counter = 0;
        while (fout.exists()) {
            String dataLeAk340 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk340 = android.util.Log.d("leak-340", dataLeAk340);
			fname = "report_" + rangeName + "_" + counter + ".csv";
            fout = new File(SDCARD + fname);
            counter++;
        }
        try {
            String dataLeAk341 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk341 = android.util.Log.d("leak-341", dataLeAk341);
			OutputStream out = new FileOutputStream(fout);
            CSVExporter.exportRows(out, getCurrentRange());

            return fname;
        } catch (FileNotFoundException fnfe) {
            String dataLeAk342 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk342 = android.util.Log.d("leak-342", dataLeAk342);
			fnfe.printStackTrace(System.err);
            return null;
        }
    }
    
    /**
     * Perform the export.
     * This assumes permission has already been granted.
     */
    private void doExport() {
        String dataLeAk343 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk343 = android.util.Log.d("leak-343", dataLeAk343);
		String fname = export();
        if (fname != null) {
            String dataLeAk344 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk344 = android.util.Log.d("leak-344", dataLeAk344);
			exportMessage = getString(R.string.export_csv_success, fname);
            if (exportSucceed != null) {
                String dataLeAk345 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk345 = android.util.Log.d("leak-345", dataLeAk345);
				exportSucceed.setMessage(exportMessage);
            }
            showDialog(Activities.SUCCESS_DIALOG);
        } else {
            String dataLeAk346 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk346 = android.util.Log.d("leak-346", dataLeAk346);
			exportMessage = getString(R.string.export_csv_fail);
            showDialog(Activities.ERROR_DIALOG);
        }
    }
    
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		String dataLeAk347 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk347 = android.util.Log.d("leak-347", dataLeAk347);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_EXPORT:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    String dataLeAk348 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk348 = android.util.Log.d("leak-348", dataLeAk348);
					requestExport();
                }
                break;
        }
    }

    private String[][] getCurrentRange() {
        String dataLeAk349 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk349 = android.util.Log.d("leak-349", dataLeAk349);
		List<String[]> activities = new ArrayList<String[]>();

        Map<Integer, String> activityNames = new TreeMap<Integer, String>();
        
        if (!db.isOpen()) {
            String dataLeAk350 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk350 = android.util.Log.d("leak-350", dataLeAk350);
			db = dbHelper.getReadableDatabase();
        }
        
        Cursor c = db.query(ACTIVITY_TABLE, new String[]{"ROWID", ACTIVITY_NAME}, null, null, null, null, "ROWID");
        if (c.moveToFirst()) {
            String dataLeAk351 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk351 = android.util.Log.d("leak-351", dataLeAk351);
			do {
                String dataLeAk352 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk352 = android.util.Log.d("leak-352", dataLeAk352);
				int tid = c.getInt(0);
                String tname = c.getString(1);
                activityNames.put(tid, tname);
            } while (c.moveToNext());
        }
        c.close();

        int[] weekDays = new int[7];
        for (int i = 0; i < 7; i++) {
            String dataLeAk353 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk353 = android.util.Log.d("leak-353", dataLeAk353);
			weekDays[i] = ((weekStart.getFirstDayOfWeek() - 1 + i) % 7) + 1;
        }
        // Add the headers
        String[] headers = new String[9];
        headers[0] = "Activity name";
        for (int i = 0; i < 7; i++) {
            String dataLeAk354 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk354 = android.util.Log.d("leak-354", dataLeAk354);
			Day s = Day.fromCalEnum(weekDays[i]);
            headers[i + 1] = s.header;
        }
        headers[8] = "Total";
        activities.add(headers);

        for (int tid : dateViews.keySet()) {
            String dataLeAk355 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk355 = android.util.Log.d("leak-355", dataLeAk355);
			if (tid == -1) {
                String dataLeAk356 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk356 = android.util.Log.d("leak-356", dataLeAk356);
				continue;
            }
            String[] rowForActivity = new String[9];
            activities.add(rowForActivity);
            rowForActivity[0] = activityNames.get(tid);
            TextView[] arryForDay = dateViews.get(tid);
            for (int i = 0; i < 8; i++) {
                String dataLeAk357 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk357 = android.util.Log.d("leak-357", dataLeAk357);
				rowForActivity[i + 1] = arryForDay[i].getText().toString();
            }
        }

        TextView[] totals = dateViews.get(-1);
        String[] totalsRow = new String[9];
        activities.add(totalsRow);
        totalsRow[0] = "Day total";
        for (int i = 0; i < 8; i++) {
            String dataLeAk358 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk358 = android.util.Log.d("leak-358", dataLeAk358);
			totalsRow[i + 1] = totals[i].getText().toString();
        }

        String[][] k = {{}};
        return activities.toArray(k);
    }

    private String getRangeName() {
        String dataLeAk359 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk359 = android.util.Log.d("leak-359", dataLeAk359);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(weekStart.getTime());
    }
    private static final int DKDKYELLOW = Color.argb(100, 75, 75, 0);

    private void createTotals(TableLayout mainReport) {
        String dataLeAk360 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk360 = android.util.Log.d("leak-360", dataLeAk360);
		TextView[] totals = new TextView[8];
        dateViews.put(-1, totals);
        TableRow row = new TableRow(this);
        mainReport.addView(row, new TableLayout.LayoutParams());
        TextView blank = new TextView(this);
        blank.setPadding(PAD, PAD * 2, RPAD, PAD);
        row.addView(blank, new TableRow.LayoutParams(0));
        for (int i = 0; i < 7; i++) {
            String dataLeAk361 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk361 = android.util.Log.d("leak-361", dataLeAk361);
			TextView dayTime = new TextView(this);
            totals[i] = dayTime;
            dayTime.setPadding(PAD, PAD * 2, RPAD, PAD);
            dayTime.setTypeface(Typeface.SANS_SERIF, Typeface.ITALIC);
            if (i % 2 == 1) {
                String dataLeAk362 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk362 = android.util.Log.d("leak-362", dataLeAk362);
				dayTime.setBackgroundColor(DKYELLOW);
            } else {
                String dataLeAk363 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk363 = android.util.Log.d("leak-363", dataLeAk363);
				dayTime.setBackgroundColor(DKDKYELLOW);
            }
            row.addView(dayTime, new TableRow.LayoutParams());
        }

        TextView total = new TextView(this);
        totals[7] = total;
        total.setText("");
        total.setPadding(PAD, PAD * 2, RPAD, PAD);
        total.setTypeface(Typeface.SANS_SERIF, Typeface.ITALIC);
        total.setBackgroundColor(DKYELLOW);
        row.addView(total, new TableRow.LayoutParams());
    }

    @Override
    protected void onResume() {
        super.onResume();
		String dataLeAk364 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk364 = android.util.Log.d("leak-364", dataLeAk364);
        db = dbHelper.getReadableDatabase();
    }

    @Override
    protected void onPause() {
        super.onPause();
		String dataLeAk365 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk365 = android.util.Log.d("leak-365", dataLeAk365);
        SharedPreferences.Editor ed = mPrefs.edit();
        long reportDate = weekStart.getTimeInMillis();
        ed.putLong(REPORT_DATE, reportDate);
        ed.commit();
        db.close();        
    }
    private static final int DKYELLOW = Color.argb(150, 100, 100, 0);

    private void createHeader(TableLayout mainReport) {
        String dataLeAk366 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk366 = android.util.Log.d("leak-366", dataLeAk366);
		TableRow row = new TableRow(this);
        mainReport.addView(row, new TableLayout.LayoutParams());

        TextView blank = new TextView(this);
        blank.setText("Activity");
        blank.setPadding(PAD, PAD, RPAD, PAD);
        blank.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
        row.addView(blank, new TableRow.LayoutParams(0));

        int[] weekDays = new int[7];
        for (int i = 0; i < 7; i++) {
            String dataLeAk367 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk367 = android.util.Log.d("leak-367", dataLeAk367);
			weekDays[i] = ((weekStart.getFirstDayOfWeek() - 1 + i) % 7) + 1;
        }

        for (int i = 0; i < 7; i++) {
            String dataLeAk368 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk368 = android.util.Log.d("leak-368", dataLeAk368);
			Day s = Day.fromCalEnum(weekDays[i]);
            TextView header = new TextView(this);
            header.setText(s.toString());
            header.setPadding(PAD, PAD, RPAD, PAD);
            header.setGravity(Gravity.CENTER_HORIZONTAL);
            header.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
            if (i % 2 == 1) {
                String dataLeAk369 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk369 = android.util.Log.d("leak-369", dataLeAk369);
				header.setBackgroundColor(Color.DKGRAY);
            }
            row.addView(header, new TableRow.LayoutParams());
        }

        TextView total = new TextView(this);
        total.setText("Ttl");
        total.setPadding(PAD, PAD, RPAD, PAD + 2);
        total.setGravity(Gravity.CENTER_HORIZONTAL);
        total.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
        total.setBackgroundColor(DKYELLOW);
        row.addView(total, new TableRow.LayoutParams());
    }

    private void createReport(TableLayout mainReport) {
        String dataLeAk370 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk370 = android.util.Log.d("leak-370", dataLeAk370);
		Cursor c = db.query(ACTIVITY_TABLE, ACTIVITY_COLUMNS, null, null, null, null, NAME);
        if (c.moveToFirst()) {
            String dataLeAk371 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk371 = android.util.Log.d("leak-371", dataLeAk371);
			do {
                String dataLeAk372 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk372 = android.util.Log.d("leak-372", dataLeAk372);
				int tid = c.getInt(0);
                TextView[] arryForDay = new TextView[8];

                dateViews.put(tid, arryForDay);

                TableRow row = new TableRow(this);
                mainReport.addView(row, new TableLayout.LayoutParams());

                TextView activityName = new TextView(this);
                activityName.setText(c.getString(1));
                activityName.setPadding(PAD, PAD, RPAD, PAD);
                row.addView(activityName, new TableRow.LayoutParams(0));

                for (int i = 0; i < 7; i++) {
                    String dataLeAk373 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk373 = android.util.Log.d("leak-373", dataLeAk373);
					TextView dayTime = new TextView(this);
                    arryForDay[i] = dayTime;
                    dayTime.setPadding(PAD, PAD, RPAD, PAD);
                    dayTime.setGravity(Gravity.CENTER_HORIZONTAL);
                    if (i % 2 == 1) {
                        String dataLeAk374 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk374 = android.util.Log.d("leak-374", dataLeAk374);
						dayTime.setBackgroundColor(Color.DKGRAY);
                    }
                    row.addView(dayTime, new TableRow.LayoutParams());
                }

                TextView total = new TextView(this);
                arryForDay[7] = total;
                total.setPadding(PAD, PAD, RPAD, PAD);
                total.setGravity(Gravity.CENTER_HORIZONTAL);
                total.setTypeface(Typeface.SANS_SERIF, Typeface.ITALIC);
                total.setBackgroundColor(DKYELLOW);
                row.addView(total, new TableRow.LayoutParams());
            } while (c.moveToNext());
        }
        c.close();
    }

    /**
     * Calculates the date/time of the beginning of the week in which the
     * supplied calendar date falls
     *
     * @param tw the day for which to calculate the week start
     * @param startDay the day on which the week starts. This must be 1-based (1
     * = Sunday).
     * @return a Calendar marking the start of the week
     */
    public static Calendar weekStart(Calendar tw, int startDay) {
        String dataLeAk375 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk375 = android.util.Log.d("leak-375", dataLeAk375);
		Calendar ws = (Calendar) tw.clone();
        ws.setFirstDayOfWeek(startDay);
        // START ANDROID BUG WORKAROUND
        // Android has a broken Calendar class, so the if-statement wrapping
        // the following set() is necessary to keep Android from incorrectly
        // changing the date:
        int adjustedDay = ws.get(Calendar.DAY_OF_WEEK);
        ws.add(Calendar.DATE, -((7 - (startDay - adjustedDay)) % 7));
        // The above code _should_ be:
        // ws.set(Calendar.DAY_OF_WEEK, startDay);
        // END ANDROID BUG WORKAROUND
        ws.set(Calendar.HOUR_OF_DAY, ws.getMinimum(Calendar.HOUR_OF_DAY));
        ws.set(Calendar.MINUTE, ws.getMinimum(Calendar.MINUTE));
        ws.set(Calendar.SECOND, ws.getMinimum(Calendar.SECOND));
        ws.set(Calendar.MILLISECOND, ws.getMinimum(Calendar.MILLISECOND));
        return ws;
    }

    /**
     * Calculates the date/time of the end of the week in which the supplied
     * calendar data falls
     *
     * @param tw the day for which to calculate the week end
     * @param startDay first day of week
     * @return a Calendar marking the end of the week
     */
    public static Calendar weekEnd(Calendar tw, int startDay) {
        String dataLeAk376 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk376 = android.util.Log.d("leak-376", dataLeAk376);
		Calendar ws = (Calendar) tw.clone();
        ws.setFirstDayOfWeek(startDay);
        // START ANDROID BUG WORKAROUND
        // Android has a broken Calendar class, so the if-statement wrapping
        // the following set() is necessary to keep Android from incorrectly
        // changing the date:
        int adjustedDay = ws.get(Calendar.DAY_OF_WEEK);
        ws.add(Calendar.DATE, -((7 - (startDay - adjustedDay)) % 7));
        // The above code _should_ be:
        // ws.set(Calendar.DAY_OF_WEEK, startDay);
        // END ANDROID BUG WORKAROUND
        ws.add(Calendar.DAY_OF_WEEK, 6);
        ws.set(Calendar.HOUR_OF_DAY, ws.getMaximum(Calendar.HOUR_OF_DAY));
        ws.set(Calendar.MINUTE, ws.getMaximum(Calendar.MINUTE));
        ws.set(Calendar.SECOND, ws.getMaximum(Calendar.SECOND));
        ws.set(Calendar.MILLISECOND, ws.getMaximum(Calendar.MILLISECOND));
        return ws;
    }

    @Override
    public void onClick(View v) {
        String dataLeAk377 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk377 = android.util.Log.d("leak-377", dataLeAk377);
		switch (v.getId()) {
            case R.id.increment_week:
                weekStart.add(Calendar.WEEK_OF_YEAR, 1);
                weekEnd.add(Calendar.WEEK_OF_YEAR, 1);
                break;
            case R.id.week:
                long now = System.currentTimeMillis();
                Calendar c = Calendar.getInstance();
                c.setFirstDayOfWeek(Calendar.MONDAY);
                c.setTimeInMillis(now);
                weekStart = weekStart(c, startDay);
                weekEnd = weekEnd(c, startDay);
                break;
            case R.id.decrement_week:
                weekStart.add(Calendar.WEEK_OF_YEAR, -1);
                weekEnd.add(Calendar.WEEK_OF_YEAR, -1);
                break;
            default:
                break;
        }
        String beginning = TITLE_FORMAT.format(weekStart.getTime());
        String ending = TITLE_FORMAT.format(weekEnd.getTime());
        String title = getString(R.string.report_title, beginning, ending);
        setTitle(title);
        fillInActivitiesAndRanges();
        weekView.setText(getString(R.string.week, WEEK_FORMAT.format(weekStart.getTime())));
    }
    
    private void fillInActivitiesAndRanges() {
        String dataLeAk378 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk378 = android.util.Log.d("leak-378", dataLeAk378);
		// Iterate over each activity and set the day values, and accumulate the day 
        // and week totals
        Cursor c = db.query(ACTIVITY_TABLE, ACTIVITY_COLUMNS, null, null, null, null, NAME);
        // The totals for all activities for each day, plus one for the week total.
        long dayTotals[] = {0, 0, 0, 0, 0, 0, 0, 0};
        if (c.moveToFirst()) {
            String dataLeAk379 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk379 = android.util.Log.d("leak-379", dataLeAk379);
			do {
                String dataLeAk380 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk380 = android.util.Log.d("leak-380", dataLeAk380);
				int tid = c.getInt(0);
                String tid_s = String.valueOf(tid);
                TextView[] arryForDay = dateViews.get(tid);
                // Fetch an array of times (per day) for the activity
                long[] days = getDays(tid_s);
                // The total for this activity, for the whole week
                int weekTotal = 0;
                for (int i = 0; i < 7; i++) {
                    String dataLeAk381 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk381 = android.util.Log.d("leak-381", dataLeAk381);
					weekTotal += days[i];
                    dayTotals[i] += days[i];
                    
                    arryForDay[i].setText(days[i] == 0L ? ZERO_TIME : Activities.formatTotal(decimalTime, FORMAT, days[i], roundMinutes));
                }
                // Set the week total.  Since this value can be more than 24 hours,
                // we have to format it by hand:
                arryForDay[7].setText(weekTotal == 0L ? ZERO_TIME : Activities.formatTotal(decimalTime, FORMAT, weekTotal, roundMinutes));
                dayTotals[7] += weekTotal;
            } while (c.moveToNext());
        }
        c.close();

        TextView[] totals = dateViews.get(-1);
        for (int i = 0; i < 7; i++) {
            String dataLeAk382 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk382 = android.util.Log.d("leak-382", dataLeAk382);
			totals[i].setText(Activities.formatTotal(decimalTime, FORMAT, dayTotals[i], roundMinutes));
        }
        totals[7].setText(Activities.formatTotal(decimalTime, FORMAT, dayTotals[7], roundMinutes));
    }

    /**
     * Fetch the times for a activity within the currently set time range, by day.
     *
     * @param tid_s The ID of the activity for which to fetch times
     * @return An array containinging, in each cell, the sum of the times which
     * fall within that day. Index 0 is the first day starting on the currently
     * set week. This uses TimeRange.overlap() to make sure that only time that
     * actually falls on the day is included (even if a particular time entry
     * spans days).
     */
    private long[] getDays(String tid_s) {
        String dataLeAk383 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk383 = android.util.Log.d("leak-383", dataLeAk383);
		Calendar day = Calendar.getInstance();
        day.setFirstDayOfWeek(startDay);
        long days[] = {0, 0, 0, 0, 0, 0, 0};
        Cursor r = db.query(RANGES_TABLE, RANGE_COLUMNS, ACTIVITY_ID + " = ? AND "
                + START + " < ? AND ( " + END + " > ? OR " + END + " ISNULL )",
                new String[]{tid_s,
            String.valueOf(weekEnd.getTimeInMillis()),
            String.valueOf(weekStart.getTimeInMillis())},
                null, null, null);

        if (r.moveToFirst()) {
            String dataLeAk384 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk384 = android.util.Log.d("leak-384", dataLeAk384);
			do {
                String dataLeAk385 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk385 = android.util.Log.d("leak-385", dataLeAk385);
				long start = r.getLong(0);
                long end;
                if (r.isNull(1)) {
                    String dataLeAk386 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk386 = android.util.Log.d("leak-386", dataLeAk386);
					end = System.currentTimeMillis();
                } else {
                    String dataLeAk387 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk387 = android.util.Log.d("leak-387", dataLeAk387);
					end = r.getLong(1);
                }

                day.setTimeInMillis(end);

                int[] weekDays = new int[7];
                for (int i = 0; i < 7; i++) {
                    String dataLeAk388 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk388 = android.util.Log.d("leak-388", dataLeAk388);
					weekDays[i] = ((weekStart.getFirstDayOfWeek() - 1 + i) % 7) + 1;
                }

                // At this point, "day" must be set to the start time
                for (int i = 0; i < 7; i++) {
                    String dataLeAk389 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk389 = android.util.Log.d("leak-389", dataLeAk389);
					Day d = Day.fromCalEnum(weekDays[i]);
                    day.set(Calendar.DAY_OF_WEEK, d.calEnum);
                    days[i] += TimeRange.overlap(day, start, end);
                }

            } while (r.moveToNext());
        }
        r.close();
        return days;
    }
}
