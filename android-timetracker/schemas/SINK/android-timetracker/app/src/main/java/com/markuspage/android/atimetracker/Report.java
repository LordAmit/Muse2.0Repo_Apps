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

    final String dataLeAk166 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk164 = "";

	String dataLeAk163 = "";

	String dataLeAk162 = "";

	String dataLeAk161 = "";

	String dataLeAk160 = "";

	String dataLeAk159 = "";

	String dataLeAk158 = "";

	String dataLeAk157 = "";

	String dataLeAk156 = "";

	String dataLeAk155 = "";

	String dataLeAk154 = "";

	String dataLeAk153 = "";

	String dataLeAk152 = "";

	String dataLeAk150 = "";

	String dataLeAk149 = "";

	String dataLeAk148 = "";

	String dataLeAk147 = "";

	String dataLeAk146 = "";

	String dataLeAk145 = "";

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
            this.calEnum = calEnum;
            this.header = header;
        }

        static Day fromCalEnum(int calEnum) {
            for (Day v : values()) {
                if (v.calEnum == calEnum) {
                    return v;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return header;
        }

        public int calEnum() {
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
		dataLeAk145 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-0", dataLeAk145);
		android.util.Log.d("leak-146-0", dataLeAk146);
		android.util.Log.d("leak-147-0", dataLeAk147);
		android.util.Log.d("leak-148-0", dataLeAk148);
		android.util.Log.d("leak-149-0", dataLeAk149);
		android.util.Log.d("leak-150-0", dataLeAk150);
		android.util.Log.d("leak-152-0", dataLeAk152);
		android.util.Log.d("leak-153-0", dataLeAk153);
		android.util.Log.d("leak-154-0", dataLeAk154);
		android.util.Log.d("leak-155-0", dataLeAk155);
		android.util.Log.d("leak-156-0", dataLeAk156);
		android.util.Log.d("leak-157-0", dataLeAk157);
		android.util.Log.d("leak-158-0", dataLeAk158);
		android.util.Log.d("leak-159-0", dataLeAk159);
		android.util.Log.d("leak-160-0", dataLeAk160);
		android.util.Log.d("leak-161-0", dataLeAk161);
		android.util.Log.d("leak-162-0", dataLeAk162);
		android.util.Log.d("leak-163-0", dataLeAk163);
		android.util.Log.d("leak-164-0", dataLeAk164);
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
		dataLeAk146 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-1", dataLeAk145);
		android.util.Log.d("leak-146-1", dataLeAk146);
		android.util.Log.d("leak-147-1", dataLeAk147);
		android.util.Log.d("leak-148-1", dataLeAk148);
		android.util.Log.d("leak-149-1", dataLeAk149);
		android.util.Log.d("leak-150-1", dataLeAk150);
		android.util.Log.d("leak-152-1", dataLeAk152);
		android.util.Log.d("leak-153-1", dataLeAk153);
		android.util.Log.d("leak-154-1", dataLeAk154);
		android.util.Log.d("leak-155-1", dataLeAk155);
		android.util.Log.d("leak-156-1", dataLeAk156);
		android.util.Log.d("leak-157-1", dataLeAk157);
		android.util.Log.d("leak-158-1", dataLeAk158);
		android.util.Log.d("leak-159-1", dataLeAk159);
		android.util.Log.d("leak-160-1", dataLeAk160);
		android.util.Log.d("leak-161-1", dataLeAk161);
		android.util.Log.d("leak-162-1", dataLeAk162);
		android.util.Log.d("leak-163-1", dataLeAk163);
		android.util.Log.d("leak-164-1", dataLeAk164);
        System.err.println("Closed DB");
        super.onStop();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
		dataLeAk147 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-2", dataLeAk145);
		android.util.Log.d("leak-146-2", dataLeAk146);
		android.util.Log.d("leak-147-2", dataLeAk147);
		android.util.Log.d("leak-148-2", dataLeAk148);
		android.util.Log.d("leak-149-2", dataLeAk149);
		android.util.Log.d("leak-150-2", dataLeAk150);
		android.util.Log.d("leak-152-2", dataLeAk152);
		android.util.Log.d("leak-153-2", dataLeAk153);
		android.util.Log.d("leak-154-2", dataLeAk154);
		android.util.Log.d("leak-155-2", dataLeAk155);
		android.util.Log.d("leak-156-2", dataLeAk156);
		android.util.Log.d("leak-157-2", dataLeAk157);
		android.util.Log.d("leak-158-2", dataLeAk158);
		android.util.Log.d("leak-159-2", dataLeAk159);
		android.util.Log.d("leak-160-2", dataLeAk160);
		android.util.Log.d("leak-161-2", dataLeAk161);
		android.util.Log.d("leak-162-2", dataLeAk162);
		android.util.Log.d("leak-163-2", dataLeAk163);
		android.util.Log.d("leak-164-2", dataLeAk164);
        menu.add(0, Activities.EXPORT_VIEW, 0, R.string.export_view)
                .setIcon(android.R.drawable.ic_menu_save);
        return true;
    }
    private AlertDialog exportSucceed;
    private String exportMessage;

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        dataLeAk148 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-3", dataLeAk145);
		android.util.Log.d("leak-146-3", dataLeAk146);
		android.util.Log.d("leak-147-3", dataLeAk147);
		android.util.Log.d("leak-148-3", dataLeAk148);
		android.util.Log.d("leak-149-3", dataLeAk149);
		android.util.Log.d("leak-150-3", dataLeAk150);
		android.util.Log.d("leak-152-3", dataLeAk152);
		android.util.Log.d("leak-153-3", dataLeAk153);
		android.util.Log.d("leak-154-3", dataLeAk154);
		android.util.Log.d("leak-155-3", dataLeAk155);
		android.util.Log.d("leak-156-3", dataLeAk156);
		android.util.Log.d("leak-157-3", dataLeAk157);
		android.util.Log.d("leak-158-3", dataLeAk158);
		android.util.Log.d("leak-159-3", dataLeAk159);
		android.util.Log.d("leak-160-3", dataLeAk160);
		android.util.Log.d("leak-161-3", dataLeAk161);
		android.util.Log.d("leak-162-3", dataLeAk162);
		android.util.Log.d("leak-163-3", dataLeAk163);
		android.util.Log.d("leak-164-3", dataLeAk164);
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
        dataLeAk149 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-4", dataLeAk145);
		android.util.Log.d("leak-146-4", dataLeAk146);
		android.util.Log.d("leak-147-4", dataLeAk147);
		android.util.Log.d("leak-148-4", dataLeAk148);
		android.util.Log.d("leak-149-4", dataLeAk149);
		android.util.Log.d("leak-150-4", dataLeAk150);
		android.util.Log.d("leak-152-4", dataLeAk152);
		android.util.Log.d("leak-153-4", dataLeAk153);
		android.util.Log.d("leak-154-4", dataLeAk154);
		android.util.Log.d("leak-155-4", dataLeAk155);
		android.util.Log.d("leak-156-4", dataLeAk156);
		android.util.Log.d("leak-157-4", dataLeAk157);
		android.util.Log.d("leak-158-4", dataLeAk158);
		android.util.Log.d("leak-159-4", dataLeAk159);
		android.util.Log.d("leak-160-4", dataLeAk160);
		android.util.Log.d("leak-161-4", dataLeAk161);
		android.util.Log.d("leak-162-4", dataLeAk162);
		android.util.Log.d("leak-163-4", dataLeAk163);
		android.util.Log.d("leak-164-4", dataLeAk164);
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
        dataLeAk150 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-5", dataLeAk145);
		android.util.Log.d("leak-146-5", dataLeAk146);
		android.util.Log.d("leak-147-5", dataLeAk147);
		android.util.Log.d("leak-148-5", dataLeAk148);
		android.util.Log.d("leak-149-5", dataLeAk149);
		android.util.Log.d("leak-150-5", dataLeAk150);
		android.util.Log.d("leak-152-5", dataLeAk152);
		android.util.Log.d("leak-153-5", dataLeAk153);
		android.util.Log.d("leak-154-5", dataLeAk154);
		android.util.Log.d("leak-155-5", dataLeAk155);
		android.util.Log.d("leak-156-5", dataLeAk156);
		android.util.Log.d("leak-157-5", dataLeAk157);
		android.util.Log.d("leak-158-5", dataLeAk158);
		android.util.Log.d("leak-159-5", dataLeAk159);
		android.util.Log.d("leak-160-5", dataLeAk160);
		android.util.Log.d("leak-161-5", dataLeAk161);
		android.util.Log.d("leak-162-5", dataLeAk162);
		android.util.Log.d("leak-163-5", dataLeAk163);
		android.util.Log.d("leak-164-5", dataLeAk164);
		if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            // Show an explanation to the user *asynchronously* -- don't block
            // this thread waiting for the user's response! After the user
            // sees the explanation, try again to request the permission.
            new AlertDialog.Builder(this)
                    .setMessage(R.string.permission_to_export_needed)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                String dataLeAk151 = "";

				@Override
                public void onClick(DialogInterface dialog, int which) {
                    dataLeAk151 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-166-0", dataLeAk166);
					android.util.Log.d("leak-151-0", dataLeAk151);
					ActivityCompat.requestPermissions(Report.this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_EXPORT);
                }
            }).create().show();

        } else {
            doExport();
        }
    }

    private String export() {
        dataLeAk152 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-6", dataLeAk145);
		android.util.Log.d("leak-146-6", dataLeAk146);
		android.util.Log.d("leak-147-6", dataLeAk147);
		android.util.Log.d("leak-148-6", dataLeAk148);
		android.util.Log.d("leak-149-6", dataLeAk149);
		android.util.Log.d("leak-150-6", dataLeAk150);
		android.util.Log.d("leak-152-6", dataLeAk152);
		android.util.Log.d("leak-153-6", dataLeAk153);
		android.util.Log.d("leak-154-6", dataLeAk154);
		android.util.Log.d("leak-155-6", dataLeAk155);
		android.util.Log.d("leak-156-6", dataLeAk156);
		android.util.Log.d("leak-157-6", dataLeAk157);
		android.util.Log.d("leak-158-6", dataLeAk158);
		android.util.Log.d("leak-159-6", dataLeAk159);
		android.util.Log.d("leak-160-6", dataLeAk160);
		android.util.Log.d("leak-161-6", dataLeAk161);
		android.util.Log.d("leak-162-6", dataLeAk162);
		android.util.Log.d("leak-163-6", dataLeAk163);
		android.util.Log.d("leak-164-6", dataLeAk164);
		// Export, then show a dialog
        String rangeName = getRangeName();
        String fname = "report_" + rangeName + ".csv";
        File fout = new File(SDCARD + fname);
        // Change the file name until there's no conflict
        int counter = 0;
        while (fout.exists()) {
            fname = "report_" + rangeName + "_" + counter + ".csv";
            fout = new File(SDCARD + fname);
            counter++;
        }
        try {
            OutputStream out = new FileOutputStream(fout);
            CSVExporter.exportRows(out, getCurrentRange());

            return fname;
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace(System.err);
            return null;
        }
    }
    
    /**
     * Perform the export.
     * This assumes permission has already been granted.
     */
    private void doExport() {
        dataLeAk153 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-7", dataLeAk145);
		android.util.Log.d("leak-146-7", dataLeAk146);
		android.util.Log.d("leak-147-7", dataLeAk147);
		android.util.Log.d("leak-148-7", dataLeAk148);
		android.util.Log.d("leak-149-7", dataLeAk149);
		android.util.Log.d("leak-150-7", dataLeAk150);
		android.util.Log.d("leak-152-7", dataLeAk152);
		android.util.Log.d("leak-153-7", dataLeAk153);
		android.util.Log.d("leak-154-7", dataLeAk154);
		android.util.Log.d("leak-155-7", dataLeAk155);
		android.util.Log.d("leak-156-7", dataLeAk156);
		android.util.Log.d("leak-157-7", dataLeAk157);
		android.util.Log.d("leak-158-7", dataLeAk158);
		android.util.Log.d("leak-159-7", dataLeAk159);
		android.util.Log.d("leak-160-7", dataLeAk160);
		android.util.Log.d("leak-161-7", dataLeAk161);
		android.util.Log.d("leak-162-7", dataLeAk162);
		android.util.Log.d("leak-163-7", dataLeAk163);
		android.util.Log.d("leak-164-7", dataLeAk164);
		String fname = export();
        if (fname != null) {
            exportMessage = getString(R.string.export_csv_success, fname);
            if (exportSucceed != null) {
                exportSucceed.setMessage(exportMessage);
            }
            showDialog(Activities.SUCCESS_DIALOG);
        } else {
            exportMessage = getString(R.string.export_csv_fail);
            showDialog(Activities.ERROR_DIALOG);
        }
    }
    
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		dataLeAk154 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-8", dataLeAk145);
		android.util.Log.d("leak-146-8", dataLeAk146);
		android.util.Log.d("leak-147-8", dataLeAk147);
		android.util.Log.d("leak-148-8", dataLeAk148);
		android.util.Log.d("leak-149-8", dataLeAk149);
		android.util.Log.d("leak-150-8", dataLeAk150);
		android.util.Log.d("leak-152-8", dataLeAk152);
		android.util.Log.d("leak-153-8", dataLeAk153);
		android.util.Log.d("leak-154-8", dataLeAk154);
		android.util.Log.d("leak-155-8", dataLeAk155);
		android.util.Log.d("leak-156-8", dataLeAk156);
		android.util.Log.d("leak-157-8", dataLeAk157);
		android.util.Log.d("leak-158-8", dataLeAk158);
		android.util.Log.d("leak-159-8", dataLeAk159);
		android.util.Log.d("leak-160-8", dataLeAk160);
		android.util.Log.d("leak-161-8", dataLeAk161);
		android.util.Log.d("leak-162-8", dataLeAk162);
		android.util.Log.d("leak-163-8", dataLeAk163);
		android.util.Log.d("leak-164-8", dataLeAk164);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_EXPORT:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    requestExport();
                }
                break;
        }
    }

    private String[][] getCurrentRange() {
        dataLeAk155 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-9", dataLeAk145);
		android.util.Log.d("leak-146-9", dataLeAk146);
		android.util.Log.d("leak-147-9", dataLeAk147);
		android.util.Log.d("leak-148-9", dataLeAk148);
		android.util.Log.d("leak-149-9", dataLeAk149);
		android.util.Log.d("leak-150-9", dataLeAk150);
		android.util.Log.d("leak-152-9", dataLeAk152);
		android.util.Log.d("leak-153-9", dataLeAk153);
		android.util.Log.d("leak-154-9", dataLeAk154);
		android.util.Log.d("leak-155-9", dataLeAk155);
		android.util.Log.d("leak-156-9", dataLeAk156);
		android.util.Log.d("leak-157-9", dataLeAk157);
		android.util.Log.d("leak-158-9", dataLeAk158);
		android.util.Log.d("leak-159-9", dataLeAk159);
		android.util.Log.d("leak-160-9", dataLeAk160);
		android.util.Log.d("leak-161-9", dataLeAk161);
		android.util.Log.d("leak-162-9", dataLeAk162);
		android.util.Log.d("leak-163-9", dataLeAk163);
		android.util.Log.d("leak-164-9", dataLeAk164);
		List<String[]> activities = new ArrayList<String[]>();

        Map<Integer, String> activityNames = new TreeMap<Integer, String>();
        
        if (!db.isOpen()) {
            db = dbHelper.getReadableDatabase();
        }
        
        Cursor c = db.query(ACTIVITY_TABLE, new String[]{"ROWID", ACTIVITY_NAME}, null, null, null, null, "ROWID");
        if (c.moveToFirst()) {
            do {
                int tid = c.getInt(0);
                String tname = c.getString(1);
                activityNames.put(tid, tname);
            } while (c.moveToNext());
        }
        c.close();

        int[] weekDays = new int[7];
        for (int i = 0; i < 7; i++) {
            weekDays[i] = ((weekStart.getFirstDayOfWeek() - 1 + i) % 7) + 1;
        }
        // Add the headers
        String[] headers = new String[9];
        headers[0] = "Activity name";
        for (int i = 0; i < 7; i++) {
            Day s = Day.fromCalEnum(weekDays[i]);
            headers[i + 1] = s.header;
        }
        headers[8] = "Total";
        activities.add(headers);

        for (int tid : dateViews.keySet()) {
            if (tid == -1) {
                continue;
            }
            String[] rowForActivity = new String[9];
            activities.add(rowForActivity);
            rowForActivity[0] = activityNames.get(tid);
            TextView[] arryForDay = dateViews.get(tid);
            for (int i = 0; i < 8; i++) {
                rowForActivity[i + 1] = arryForDay[i].getText().toString();
            }
        }

        TextView[] totals = dateViews.get(-1);
        String[] totalsRow = new String[9];
        activities.add(totalsRow);
        totalsRow[0] = "Day total";
        for (int i = 0; i < 8; i++) {
            totalsRow[i + 1] = totals[i].getText().toString();
        }

        String[][] k = {{}};
        return activities.toArray(k);
    }

    private String getRangeName() {
        dataLeAk156 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-10", dataLeAk145);
		android.util.Log.d("leak-146-10", dataLeAk146);
		android.util.Log.d("leak-147-10", dataLeAk147);
		android.util.Log.d("leak-148-10", dataLeAk148);
		android.util.Log.d("leak-149-10", dataLeAk149);
		android.util.Log.d("leak-150-10", dataLeAk150);
		android.util.Log.d("leak-152-10", dataLeAk152);
		android.util.Log.d("leak-153-10", dataLeAk153);
		android.util.Log.d("leak-154-10", dataLeAk154);
		android.util.Log.d("leak-155-10", dataLeAk155);
		android.util.Log.d("leak-156-10", dataLeAk156);
		android.util.Log.d("leak-157-10", dataLeAk157);
		android.util.Log.d("leak-158-10", dataLeAk158);
		android.util.Log.d("leak-159-10", dataLeAk159);
		android.util.Log.d("leak-160-10", dataLeAk160);
		android.util.Log.d("leak-161-10", dataLeAk161);
		android.util.Log.d("leak-162-10", dataLeAk162);
		android.util.Log.d("leak-163-10", dataLeAk163);
		android.util.Log.d("leak-164-10", dataLeAk164);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(weekStart.getTime());
    }
    private static final int DKDKYELLOW = Color.argb(100, 75, 75, 0);

    private void createTotals(TableLayout mainReport) {
        dataLeAk157 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-11", dataLeAk145);
		android.util.Log.d("leak-146-11", dataLeAk146);
		android.util.Log.d("leak-147-11", dataLeAk147);
		android.util.Log.d("leak-148-11", dataLeAk148);
		android.util.Log.d("leak-149-11", dataLeAk149);
		android.util.Log.d("leak-150-11", dataLeAk150);
		android.util.Log.d("leak-152-11", dataLeAk152);
		android.util.Log.d("leak-153-11", dataLeAk153);
		android.util.Log.d("leak-154-11", dataLeAk154);
		android.util.Log.d("leak-155-11", dataLeAk155);
		android.util.Log.d("leak-156-11", dataLeAk156);
		android.util.Log.d("leak-157-11", dataLeAk157);
		android.util.Log.d("leak-158-11", dataLeAk158);
		android.util.Log.d("leak-159-11", dataLeAk159);
		android.util.Log.d("leak-160-11", dataLeAk160);
		android.util.Log.d("leak-161-11", dataLeAk161);
		android.util.Log.d("leak-162-11", dataLeAk162);
		android.util.Log.d("leak-163-11", dataLeAk163);
		android.util.Log.d("leak-164-11", dataLeAk164);
		TextView[] totals = new TextView[8];
        dateViews.put(-1, totals);
        TableRow row = new TableRow(this);
        mainReport.addView(row, new TableLayout.LayoutParams());
        TextView blank = new TextView(this);
        blank.setPadding(PAD, PAD * 2, RPAD, PAD);
        row.addView(blank, new TableRow.LayoutParams(0));
        for (int i = 0; i < 7; i++) {
            TextView dayTime = new TextView(this);
            totals[i] = dayTime;
            dayTime.setPadding(PAD, PAD * 2, RPAD, PAD);
            dayTime.setTypeface(Typeface.SANS_SERIF, Typeface.ITALIC);
            if (i % 2 == 1) {
                dayTime.setBackgroundColor(DKYELLOW);
            } else {
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
		dataLeAk158 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-12", dataLeAk145);
		android.util.Log.d("leak-146-12", dataLeAk146);
		android.util.Log.d("leak-147-12", dataLeAk147);
		android.util.Log.d("leak-148-12", dataLeAk148);
		android.util.Log.d("leak-149-12", dataLeAk149);
		android.util.Log.d("leak-150-12", dataLeAk150);
		android.util.Log.d("leak-152-12", dataLeAk152);
		android.util.Log.d("leak-153-12", dataLeAk153);
		android.util.Log.d("leak-154-12", dataLeAk154);
		android.util.Log.d("leak-155-12", dataLeAk155);
		android.util.Log.d("leak-156-12", dataLeAk156);
		android.util.Log.d("leak-157-12", dataLeAk157);
		android.util.Log.d("leak-158-12", dataLeAk158);
		android.util.Log.d("leak-159-12", dataLeAk159);
		android.util.Log.d("leak-160-12", dataLeAk160);
		android.util.Log.d("leak-161-12", dataLeAk161);
		android.util.Log.d("leak-162-12", dataLeAk162);
		android.util.Log.d("leak-163-12", dataLeAk163);
		android.util.Log.d("leak-164-12", dataLeAk164);
        db = dbHelper.getReadableDatabase();
    }

    @Override
    protected void onPause() {
        super.onPause();
		dataLeAk159 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-13", dataLeAk145);
		android.util.Log.d("leak-146-13", dataLeAk146);
		android.util.Log.d("leak-147-13", dataLeAk147);
		android.util.Log.d("leak-148-13", dataLeAk148);
		android.util.Log.d("leak-149-13", dataLeAk149);
		android.util.Log.d("leak-150-13", dataLeAk150);
		android.util.Log.d("leak-152-13", dataLeAk152);
		android.util.Log.d("leak-153-13", dataLeAk153);
		android.util.Log.d("leak-154-13", dataLeAk154);
		android.util.Log.d("leak-155-13", dataLeAk155);
		android.util.Log.d("leak-156-13", dataLeAk156);
		android.util.Log.d("leak-157-13", dataLeAk157);
		android.util.Log.d("leak-158-13", dataLeAk158);
		android.util.Log.d("leak-159-13", dataLeAk159);
		android.util.Log.d("leak-160-13", dataLeAk160);
		android.util.Log.d("leak-161-13", dataLeAk161);
		android.util.Log.d("leak-162-13", dataLeAk162);
		android.util.Log.d("leak-163-13", dataLeAk163);
		android.util.Log.d("leak-164-13", dataLeAk164);
        SharedPreferences.Editor ed = mPrefs.edit();
        long reportDate = weekStart.getTimeInMillis();
        ed.putLong(REPORT_DATE, reportDate);
        ed.commit();
        db.close();        
    }
    private static final int DKYELLOW = Color.argb(150, 100, 100, 0);

    private void createHeader(TableLayout mainReport) {
        dataLeAk160 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-14", dataLeAk145);
		android.util.Log.d("leak-146-14", dataLeAk146);
		android.util.Log.d("leak-147-14", dataLeAk147);
		android.util.Log.d("leak-148-14", dataLeAk148);
		android.util.Log.d("leak-149-14", dataLeAk149);
		android.util.Log.d("leak-150-14", dataLeAk150);
		android.util.Log.d("leak-152-14", dataLeAk152);
		android.util.Log.d("leak-153-14", dataLeAk153);
		android.util.Log.d("leak-154-14", dataLeAk154);
		android.util.Log.d("leak-155-14", dataLeAk155);
		android.util.Log.d("leak-156-14", dataLeAk156);
		android.util.Log.d("leak-157-14", dataLeAk157);
		android.util.Log.d("leak-158-14", dataLeAk158);
		android.util.Log.d("leak-159-14", dataLeAk159);
		android.util.Log.d("leak-160-14", dataLeAk160);
		android.util.Log.d("leak-161-14", dataLeAk161);
		android.util.Log.d("leak-162-14", dataLeAk162);
		android.util.Log.d("leak-163-14", dataLeAk163);
		android.util.Log.d("leak-164-14", dataLeAk164);
		TableRow row = new TableRow(this);
        mainReport.addView(row, new TableLayout.LayoutParams());

        TextView blank = new TextView(this);
        blank.setText("Activity");
        blank.setPadding(PAD, PAD, RPAD, PAD);
        blank.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
        row.addView(blank, new TableRow.LayoutParams(0));

        int[] weekDays = new int[7];
        for (int i = 0; i < 7; i++) {
            weekDays[i] = ((weekStart.getFirstDayOfWeek() - 1 + i) % 7) + 1;
        }

        for (int i = 0; i < 7; i++) {
            Day s = Day.fromCalEnum(weekDays[i]);
            TextView header = new TextView(this);
            header.setText(s.toString());
            header.setPadding(PAD, PAD, RPAD, PAD);
            header.setGravity(Gravity.CENTER_HORIZONTAL);
            header.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
            if (i % 2 == 1) {
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
        dataLeAk161 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-15", dataLeAk145);
		android.util.Log.d("leak-146-15", dataLeAk146);
		android.util.Log.d("leak-147-15", dataLeAk147);
		android.util.Log.d("leak-148-15", dataLeAk148);
		android.util.Log.d("leak-149-15", dataLeAk149);
		android.util.Log.d("leak-150-15", dataLeAk150);
		android.util.Log.d("leak-152-15", dataLeAk152);
		android.util.Log.d("leak-153-15", dataLeAk153);
		android.util.Log.d("leak-154-15", dataLeAk154);
		android.util.Log.d("leak-155-15", dataLeAk155);
		android.util.Log.d("leak-156-15", dataLeAk156);
		android.util.Log.d("leak-157-15", dataLeAk157);
		android.util.Log.d("leak-158-15", dataLeAk158);
		android.util.Log.d("leak-159-15", dataLeAk159);
		android.util.Log.d("leak-160-15", dataLeAk160);
		android.util.Log.d("leak-161-15", dataLeAk161);
		android.util.Log.d("leak-162-15", dataLeAk162);
		android.util.Log.d("leak-163-15", dataLeAk163);
		android.util.Log.d("leak-164-15", dataLeAk164);
		Cursor c = db.query(ACTIVITY_TABLE, ACTIVITY_COLUMNS, null, null, null, null, NAME);
        if (c.moveToFirst()) {
            do {
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
                    TextView dayTime = new TextView(this);
                    arryForDay[i] = dayTime;
                    dayTime.setPadding(PAD, PAD, RPAD, PAD);
                    dayTime.setGravity(Gravity.CENTER_HORIZONTAL);
                    if (i % 2 == 1) {
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
        dataLeAk162 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-16", dataLeAk145);
		android.util.Log.d("leak-146-16", dataLeAk146);
		android.util.Log.d("leak-147-16", dataLeAk147);
		android.util.Log.d("leak-148-16", dataLeAk148);
		android.util.Log.d("leak-149-16", dataLeAk149);
		android.util.Log.d("leak-150-16", dataLeAk150);
		android.util.Log.d("leak-152-16", dataLeAk152);
		android.util.Log.d("leak-153-16", dataLeAk153);
		android.util.Log.d("leak-154-16", dataLeAk154);
		android.util.Log.d("leak-155-16", dataLeAk155);
		android.util.Log.d("leak-156-16", dataLeAk156);
		android.util.Log.d("leak-157-16", dataLeAk157);
		android.util.Log.d("leak-158-16", dataLeAk158);
		android.util.Log.d("leak-159-16", dataLeAk159);
		android.util.Log.d("leak-160-16", dataLeAk160);
		android.util.Log.d("leak-161-16", dataLeAk161);
		android.util.Log.d("leak-162-16", dataLeAk162);
		android.util.Log.d("leak-163-16", dataLeAk163);
		android.util.Log.d("leak-164-16", dataLeAk164);
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
        dataLeAk163 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-17", dataLeAk145);
		android.util.Log.d("leak-146-17", dataLeAk146);
		android.util.Log.d("leak-147-17", dataLeAk147);
		android.util.Log.d("leak-148-17", dataLeAk148);
		android.util.Log.d("leak-149-17", dataLeAk149);
		android.util.Log.d("leak-150-17", dataLeAk150);
		android.util.Log.d("leak-152-17", dataLeAk152);
		android.util.Log.d("leak-153-17", dataLeAk153);
		android.util.Log.d("leak-154-17", dataLeAk154);
		android.util.Log.d("leak-155-17", dataLeAk155);
		android.util.Log.d("leak-156-17", dataLeAk156);
		android.util.Log.d("leak-157-17", dataLeAk157);
		android.util.Log.d("leak-158-17", dataLeAk158);
		android.util.Log.d("leak-159-17", dataLeAk159);
		android.util.Log.d("leak-160-17", dataLeAk160);
		android.util.Log.d("leak-161-17", dataLeAk161);
		android.util.Log.d("leak-162-17", dataLeAk162);
		android.util.Log.d("leak-163-17", dataLeAk163);
		android.util.Log.d("leak-164-17", dataLeAk164);
		// Iterate over each activity and set the day values, and accumulate the day 
        // and week totals
        Cursor c = db.query(ACTIVITY_TABLE, ACTIVITY_COLUMNS, null, null, null, null, NAME);
        // The totals for all activities for each day, plus one for the week total.
        long dayTotals[] = {0, 0, 0, 0, 0, 0, 0, 0};
        if (c.moveToFirst()) {
            do {
                int tid = c.getInt(0);
                String tid_s = String.valueOf(tid);
                TextView[] arryForDay = dateViews.get(tid);
                // Fetch an array of times (per day) for the activity
                long[] days = getDays(tid_s);
                // The total for this activity, for the whole week
                int weekTotal = 0;
                for (int i = 0; i < 7; i++) {
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
     * @see TimeRange.overlap()
     */
    private long[] getDays(String tid_s) {
        dataLeAk164 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-18", dataLeAk145);
		android.util.Log.d("leak-146-18", dataLeAk146);
		android.util.Log.d("leak-147-18", dataLeAk147);
		android.util.Log.d("leak-148-18", dataLeAk148);
		android.util.Log.d("leak-149-18", dataLeAk149);
		android.util.Log.d("leak-150-18", dataLeAk150);
		android.util.Log.d("leak-152-18", dataLeAk152);
		android.util.Log.d("leak-153-18", dataLeAk153);
		android.util.Log.d("leak-154-18", dataLeAk154);
		android.util.Log.d("leak-155-18", dataLeAk155);
		android.util.Log.d("leak-156-18", dataLeAk156);
		android.util.Log.d("leak-157-18", dataLeAk157);
		android.util.Log.d("leak-158-18", dataLeAk158);
		android.util.Log.d("leak-159-18", dataLeAk159);
		android.util.Log.d("leak-160-18", dataLeAk160);
		android.util.Log.d("leak-161-18", dataLeAk161);
		android.util.Log.d("leak-162-18", dataLeAk162);
		android.util.Log.d("leak-163-18", dataLeAk163);
		android.util.Log.d("leak-164-18", dataLeAk164);
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
            do {
                long start = r.getLong(0);
                long end;
                if (r.isNull(1)) {
                    end = System.currentTimeMillis();
                } else {
                    end = r.getLong(1);
                }

                day.setTimeInMillis(end);

                int[] weekDays = new int[7];
                for (int i = 0; i < 7; i++) {
                    weekDays[i] = ((weekStart.getFirstDayOfWeek() - 1 + i) % 7) + 1;
                }

                // At this point, "day" must be set to the start time
                for (int i = 0; i < 7; i++) {
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
