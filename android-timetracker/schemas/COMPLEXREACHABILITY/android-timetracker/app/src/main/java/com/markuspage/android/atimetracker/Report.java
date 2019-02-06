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
            String dataLeAk300 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay300 = new String[] {"n/a", dataLeAk300};
			String dataLeAkPath300 = leakArRay300[leakArRay300.length - 1];
			android.util.Log.d("leak-300", dataLeAkPath300);
			this.calEnum = calEnum;
            this.header = header;
        }

        static Day fromCalEnum(int calEnum) {
            String dataLeAk301 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP301 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP301.put("test", new java.util.HashMap<String, String>());
			leakMaP301.get("test").put("test", dataLeAk301);
			String dataLeAkPath301 = leakMaP301.get("test").get("test");
			android.util.Log.d("leak-301", dataLeAkPath301);
			for (Day v : values()) {
                String dataLeAk302 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer302 = new StringBuffer();for (char chAr302 : dataLeAk302.toCharArray()) {leakBuFFer302.append(chAr302);}String dataLeAkPath302 = leakBuFFer302.toString();
				android.util.Log.d("leak-302", dataLeAkPath302);
				if (v.calEnum == calEnum) {
                    String dataLeAk303 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath303;try {throw new Exception(dataLeAk303);} catch (Exception leakErRor303) {dataLeAkPath303 = leakErRor303.getMessage();}
					android.util.Log.d("leak-303", dataLeAkPath303);
					return v;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            String dataLeAk304 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay304 = new String[] {"n/a", dataLeAk304};
			String dataLeAkPath304 = leakArRay304[leakArRay304.length - 1];
			android.util.Log.d("leak-304", dataLeAkPath304);
			return header;
        }

        public int calEnum() {
            String dataLeAk305 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP305 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP305.put("test", new java.util.HashMap<String, String>());
			leakMaP305.get("test").put("test", dataLeAk305);
			String dataLeAkPath305 = leakMaP305.get("test").get("test");
			android.util.Log.d("leak-305", dataLeAkPath305);
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
		String dataLeAk306 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer306 = new StringBuffer();for (char chAr306 : dataLeAk306.toCharArray()) {leakBuFFer306.append(chAr306);}String dataLeAkPath306 = leakBuFFer306.toString();
		android.util.Log.d("leak-306", dataLeAkPath306);
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
		String dataLeAk307 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath307;try {throw new Exception(dataLeAk307);} catch (Exception leakErRor307) {dataLeAkPath307 = leakErRor307.getMessage();}
		android.util.Log.d("leak-307", dataLeAkPath307);
        System.err.println("Closed DB");
        super.onStop();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
		String dataLeAk308 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay308 = new String[] {"n/a", dataLeAk308};
		String dataLeAkPath308 = leakArRay308[leakArRay308.length - 1];
		android.util.Log.d("leak-308", dataLeAkPath308);
        menu.add(0, Activities.EXPORT_VIEW, 0, R.string.export_view)
                .setIcon(android.R.drawable.ic_menu_save);
        return true;
    }
    private AlertDialog exportSucceed;
    private String exportMessage;

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        String dataLeAk309 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP309 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP309.put("test", new java.util.HashMap<String, String>());
		leakMaP309.get("test").put("test", dataLeAk309);
		String dataLeAkPath309 = leakMaP309.get("test").get("test");
		android.util.Log.d("leak-309", dataLeAkPath309);
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
        String dataLeAk310 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer310 = new StringBuffer();for (char chAr310 : dataLeAk310.toCharArray()) {leakBuFFer310.append(chAr310);}String dataLeAkPath310 = leakBuFFer310.toString();
		android.util.Log.d("leak-310", dataLeAkPath310);
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
        String dataLeAk311 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath311;try {throw new Exception(dataLeAk311);} catch (Exception leakErRor311) {dataLeAkPath311 = leakErRor311.getMessage();}
		android.util.Log.d("leak-311", dataLeAkPath311);
		if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            String dataLeAk312 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay312 = new String[] {"n/a", dataLeAk312};
					String dataLeAkPath312 = leakArRay312[leakArRay312.length - 1];
					android.util.Log.d("leak-312", dataLeAkPath312);
			// Permission is not granted
            // Show an explanation to the user *asynchronously* -- don't block
            // this thread waiting for the user's response! After the user
            // sees the explanation, try again to request the permission.
            new AlertDialog.Builder(this)
                    .setMessage(R.string.permission_to_export_needed)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String dataLeAk313 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP313 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP313.put("test", new java.util.HashMap<String, String>());
					leakMaP313.get("test").put("test", dataLeAk313);
					String dataLeAkPath313 = leakMaP313.get("test").get("test");
					android.util.Log.d("leak-313", dataLeAkPath313);
					ActivityCompat.requestPermissions(Report.this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_EXPORT);
                }
            }).create().show();

        } else {
            String dataLeAk314 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer314 = new StringBuffer();for (char chAr314 : dataLeAk314.toCharArray()) {leakBuFFer314.append(chAr314);}String dataLeAkPath314 = leakBuFFer314.toString();
			android.util.Log.d("leak-314", dataLeAkPath314);
			doExport();
        }
    }

    private String export() {
        String dataLeAk315 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath315;try {throw new Exception(dataLeAk315);} catch (Exception leakErRor315) {dataLeAkPath315 = leakErRor315.getMessage();}
		android.util.Log.d("leak-315", dataLeAkPath315);
		// Export, then show a dialog
        String rangeName = getRangeName();
        String fname = "report_" + rangeName + ".csv";
        File fout = new File(SDCARD + fname);
        // Change the file name until there's no conflict
        int counter = 0;
        while (fout.exists()) {
            String dataLeAk316 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay316 = new String[] {"n/a", dataLeAk316};
			String dataLeAkPath316 = leakArRay316[leakArRay316.length - 1];
			android.util.Log.d("leak-316", dataLeAkPath316);
			fname = "report_" + rangeName + "_" + counter + ".csv";
            fout = new File(SDCARD + fname);
            counter++;
        }
        try {
            String dataLeAk317 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP317 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP317.put("test", new java.util.HashMap<String, String>());
			leakMaP317.get("test").put("test", dataLeAk317);
			String dataLeAkPath317 = leakMaP317.get("test").get("test");
			android.util.Log.d("leak-317", dataLeAkPath317);
			OutputStream out = new FileOutputStream(fout);
            CSVExporter.exportRows(out, getCurrentRange());

            return fname;
        } catch (FileNotFoundException fnfe) {
            String dataLeAk318 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer318 = new StringBuffer();for (char chAr318 : dataLeAk318.toCharArray()) {leakBuFFer318.append(chAr318);}String dataLeAkPath318 = leakBuFFer318.toString();
			android.util.Log.d("leak-318", dataLeAkPath318);
			fnfe.printStackTrace(System.err);
            return null;
        }
    }
    
    /**
     * Perform the export.
     * This assumes permission has already been granted.
     */
    private void doExport() {
        String dataLeAk319 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath319;try {throw new Exception(dataLeAk319);} catch (Exception leakErRor319) {dataLeAkPath319 = leakErRor319.getMessage();}
		android.util.Log.d("leak-319", dataLeAkPath319);
		String fname = export();
        if (fname != null) {
            String dataLeAk320 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay320 = new String[] {"n/a", dataLeAk320};
			String dataLeAkPath320 = leakArRay320[leakArRay320.length - 1];
			android.util.Log.d("leak-320", dataLeAkPath320);
			exportMessage = getString(R.string.export_csv_success, fname);
            if (exportSucceed != null) {
                String dataLeAk321 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP321 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP321.put("test", new java.util.HashMap<String, String>());
				leakMaP321.get("test").put("test", dataLeAk321);
				String dataLeAkPath321 = leakMaP321.get("test").get("test");
				android.util.Log.d("leak-321", dataLeAkPath321);
				exportSucceed.setMessage(exportMessage);
            }
            showDialog(Activities.SUCCESS_DIALOG);
        } else {
            String dataLeAk322 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer322 = new StringBuffer();for (char chAr322 : dataLeAk322.toCharArray()) {leakBuFFer322.append(chAr322);}String dataLeAkPath322 = leakBuFFer322.toString();
			android.util.Log.d("leak-322", dataLeAkPath322);
			exportMessage = getString(R.string.export_csv_fail);
            showDialog(Activities.ERROR_DIALOG);
        }
    }
    
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		String dataLeAk323 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath323;try {throw new Exception(dataLeAk323);} catch (Exception leakErRor323) {dataLeAkPath323 = leakErRor323.getMessage();}
		android.util.Log.d("leak-323", dataLeAkPath323);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_EXPORT:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    String dataLeAk324 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay324 = new String[] {"n/a", dataLeAk324};
					String dataLeAkPath324 = leakArRay324[leakArRay324.length - 1];
					android.util.Log.d("leak-324", dataLeAkPath324);
					requestExport();
                }
                break;
        }
    }

    private String[][] getCurrentRange() {
        String dataLeAk325 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP325 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP325.put("test", new java.util.HashMap<String, String>());
		leakMaP325.get("test").put("test", dataLeAk325);
		String dataLeAkPath325 = leakMaP325.get("test").get("test");
		android.util.Log.d("leak-325", dataLeAkPath325);
		List<String[]> activities = new ArrayList<String[]>();

        Map<Integer, String> activityNames = new TreeMap<Integer, String>();
        
        if (!db.isOpen()) {
            String dataLeAk326 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer326 = new StringBuffer();for (char chAr326 : dataLeAk326.toCharArray()) {leakBuFFer326.append(chAr326);}String dataLeAkPath326 = leakBuFFer326.toString();
			android.util.Log.d("leak-326", dataLeAkPath326);
			db = dbHelper.getReadableDatabase();
        }
        
        Cursor c = db.query(ACTIVITY_TABLE, new String[]{"ROWID", ACTIVITY_NAME}, null, null, null, null, "ROWID");
        if (c.moveToFirst()) {
            String dataLeAk327 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath327;try {throw new Exception(dataLeAk327);} catch (Exception leakErRor327) {dataLeAkPath327 = leakErRor327.getMessage();}
			android.util.Log.d("leak-327", dataLeAkPath327);
			do {
                String dataLeAk328 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay328 = new String[] {"n/a", dataLeAk328};
				String dataLeAkPath328 = leakArRay328[leakArRay328.length - 1];
				android.util.Log.d("leak-328", dataLeAkPath328);
				int tid = c.getInt(0);
                String tname = c.getString(1);
                activityNames.put(tid, tname);
            } while (c.moveToNext());
        }
        c.close();

        int[] weekDays = new int[7];
        for (int i = 0; i < 7; i++) {
            String dataLeAk329 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP329 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP329.put("test", new java.util.HashMap<String, String>());
			leakMaP329.get("test").put("test", dataLeAk329);
			String dataLeAkPath329 = leakMaP329.get("test").get("test");
			android.util.Log.d("leak-329", dataLeAkPath329);
			weekDays[i] = ((weekStart.getFirstDayOfWeek() - 1 + i) % 7) + 1;
        }
        // Add the headers
        String[] headers = new String[9];
        headers[0] = "Activity name";
        for (int i = 0; i < 7; i++) {
            String dataLeAk330 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer330 = new StringBuffer();for (char chAr330 : dataLeAk330.toCharArray()) {leakBuFFer330.append(chAr330);}String dataLeAkPath330 = leakBuFFer330.toString();
			android.util.Log.d("leak-330", dataLeAkPath330);
			Day s = Day.fromCalEnum(weekDays[i]);
            headers[i + 1] = s.header;
        }
        headers[8] = "Total";
        activities.add(headers);

        for (int tid : dateViews.keySet()) {
            String dataLeAk331 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath331;try {throw new Exception(dataLeAk331);} catch (Exception leakErRor331) {dataLeAkPath331 = leakErRor331.getMessage();}
			android.util.Log.d("leak-331", dataLeAkPath331);
			if (tid == -1) {
                String dataLeAk332 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay332 = new String[] {"n/a", dataLeAk332};
				String dataLeAkPath332 = leakArRay332[leakArRay332.length - 1];
				android.util.Log.d("leak-332", dataLeAkPath332);
				continue;
            }
            String[] rowForActivity = new String[9];
            activities.add(rowForActivity);
            rowForActivity[0] = activityNames.get(tid);
            TextView[] arryForDay = dateViews.get(tid);
            for (int i = 0; i < 8; i++) {
                String dataLeAk333 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP333 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP333.put("test", new java.util.HashMap<String, String>());
				leakMaP333.get("test").put("test", dataLeAk333);
				String dataLeAkPath333 = leakMaP333.get("test").get("test");
				android.util.Log.d("leak-333", dataLeAkPath333);
				rowForActivity[i + 1] = arryForDay[i].getText().toString();
            }
        }

        TextView[] totals = dateViews.get(-1);
        String[] totalsRow = new String[9];
        activities.add(totalsRow);
        totalsRow[0] = "Day total";
        for (int i = 0; i < 8; i++) {
            String dataLeAk334 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer334 = new StringBuffer();for (char chAr334 : dataLeAk334.toCharArray()) {leakBuFFer334.append(chAr334);}String dataLeAkPath334 = leakBuFFer334.toString();
			android.util.Log.d("leak-334", dataLeAkPath334);
			totalsRow[i + 1] = totals[i].getText().toString();
        }

        String[][] k = {{}};
        return activities.toArray(k);
    }

    private String getRangeName() {
        String dataLeAk335 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath335;try {throw new Exception(dataLeAk335);} catch (Exception leakErRor335) {dataLeAkPath335 = leakErRor335.getMessage();}
		android.util.Log.d("leak-335", dataLeAkPath335);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(weekStart.getTime());
    }
    private static final int DKDKYELLOW = Color.argb(100, 75, 75, 0);

    private void createTotals(TableLayout mainReport) {
        String dataLeAk336 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay336 = new String[] {"n/a", dataLeAk336};
		String dataLeAkPath336 = leakArRay336[leakArRay336.length - 1];
		android.util.Log.d("leak-336", dataLeAkPath336);
		TextView[] totals = new TextView[8];
        dateViews.put(-1, totals);
        TableRow row = new TableRow(this);
        mainReport.addView(row, new TableLayout.LayoutParams());
        TextView blank = new TextView(this);
        blank.setPadding(PAD, PAD * 2, RPAD, PAD);
        row.addView(blank, new TableRow.LayoutParams(0));
        for (int i = 0; i < 7; i++) {
            String dataLeAk337 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP337 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP337.put("test", new java.util.HashMap<String, String>());
			leakMaP337.get("test").put("test", dataLeAk337);
			String dataLeAkPath337 = leakMaP337.get("test").get("test");
			android.util.Log.d("leak-337", dataLeAkPath337);
			TextView dayTime = new TextView(this);
            totals[i] = dayTime;
            dayTime.setPadding(PAD, PAD * 2, RPAD, PAD);
            dayTime.setTypeface(Typeface.SANS_SERIF, Typeface.ITALIC);
            if (i % 2 == 1) {
                String dataLeAk338 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer338 = new StringBuffer();for (char chAr338 : dataLeAk338.toCharArray()) {leakBuFFer338.append(chAr338);}String dataLeAkPath338 = leakBuFFer338.toString();
				android.util.Log.d("leak-338", dataLeAkPath338);
				dayTime.setBackgroundColor(DKYELLOW);
            } else {
                String dataLeAk339 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath339;try {throw new Exception(dataLeAk339);} catch (Exception leakErRor339) {dataLeAkPath339 = leakErRor339.getMessage();}
				android.util.Log.d("leak-339", dataLeAkPath339);
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
		String dataLeAk340 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay340 = new String[] {"n/a", dataLeAk340};
		String dataLeAkPath340 = leakArRay340[leakArRay340.length - 1];
		android.util.Log.d("leak-340", dataLeAkPath340);
        db = dbHelper.getReadableDatabase();
    }

    @Override
    protected void onPause() {
        super.onPause();
		String dataLeAk341 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP341 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP341.put("test", new java.util.HashMap<String, String>());
		leakMaP341.get("test").put("test", dataLeAk341);
		String dataLeAkPath341 = leakMaP341.get("test").get("test");
		android.util.Log.d("leak-341", dataLeAkPath341);
        SharedPreferences.Editor ed = mPrefs.edit();
        long reportDate = weekStart.getTimeInMillis();
        ed.putLong(REPORT_DATE, reportDate);
        ed.commit();
        db.close();        
    }
    private static final int DKYELLOW = Color.argb(150, 100, 100, 0);

    private void createHeader(TableLayout mainReport) {
        String dataLeAk342 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer342 = new StringBuffer();for (char chAr342 : dataLeAk342.toCharArray()) {leakBuFFer342.append(chAr342);}String dataLeAkPath342 = leakBuFFer342.toString();
		android.util.Log.d("leak-342", dataLeAkPath342);
		TableRow row = new TableRow(this);
        mainReport.addView(row, new TableLayout.LayoutParams());

        TextView blank = new TextView(this);
        blank.setText("Activity");
        blank.setPadding(PAD, PAD, RPAD, PAD);
        blank.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
        row.addView(blank, new TableRow.LayoutParams(0));

        int[] weekDays = new int[7];
        for (int i = 0; i < 7; i++) {
            String dataLeAk343 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath343;try {throw new Exception(dataLeAk343);} catch (Exception leakErRor343) {dataLeAkPath343 = leakErRor343.getMessage();}
			android.util.Log.d("leak-343", dataLeAkPath343);
			weekDays[i] = ((weekStart.getFirstDayOfWeek() - 1 + i) % 7) + 1;
        }

        for (int i = 0; i < 7; i++) {
            String dataLeAk344 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay344 = new String[] {"n/a", dataLeAk344};
			String dataLeAkPath344 = leakArRay344[leakArRay344.length - 1];
			android.util.Log.d("leak-344", dataLeAkPath344);
			Day s = Day.fromCalEnum(weekDays[i]);
            TextView header = new TextView(this);
            header.setText(s.toString());
            header.setPadding(PAD, PAD, RPAD, PAD);
            header.setGravity(Gravity.CENTER_HORIZONTAL);
            header.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
            if (i % 2 == 1) {
                String dataLeAk345 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP345 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP345.put("test", new java.util.HashMap<String, String>());
				leakMaP345.get("test").put("test", dataLeAk345);
				String dataLeAkPath345 = leakMaP345.get("test").get("test");
				android.util.Log.d("leak-345", dataLeAkPath345);
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
        String dataLeAk346 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer346 = new StringBuffer();for (char chAr346 : dataLeAk346.toCharArray()) {leakBuFFer346.append(chAr346);}String dataLeAkPath346 = leakBuFFer346.toString();
		android.util.Log.d("leak-346", dataLeAkPath346);
		Cursor c = db.query(ACTIVITY_TABLE, ACTIVITY_COLUMNS, null, null, null, null, NAME);
        if (c.moveToFirst()) {
            String dataLeAk347 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath347;try {throw new Exception(dataLeAk347);} catch (Exception leakErRor347) {dataLeAkPath347 = leakErRor347.getMessage();}
			android.util.Log.d("leak-347", dataLeAkPath347);
			do {
                String dataLeAk348 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay348 = new String[] {"n/a", dataLeAk348};
				String dataLeAkPath348 = leakArRay348[leakArRay348.length - 1];
				android.util.Log.d("leak-348", dataLeAkPath348);
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
                    String dataLeAk349 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP349 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP349.put("test", new java.util.HashMap<String, String>());
					leakMaP349.get("test").put("test", dataLeAk349);
					String dataLeAkPath349 = leakMaP349.get("test").get("test");
					android.util.Log.d("leak-349", dataLeAkPath349);
					TextView dayTime = new TextView(this);
                    arryForDay[i] = dayTime;
                    dayTime.setPadding(PAD, PAD, RPAD, PAD);
                    dayTime.setGravity(Gravity.CENTER_HORIZONTAL);
                    if (i % 2 == 1) {
                        String dataLeAk350 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer350 = new StringBuffer();for (char chAr350 : dataLeAk350.toCharArray()) {leakBuFFer350.append(chAr350);}String dataLeAkPath350 = leakBuFFer350.toString();
						android.util.Log.d("leak-350", dataLeAkPath350);
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
        String dataLeAk351 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath351;try {throw new Exception(dataLeAk351);} catch (Exception leakErRor351) {dataLeAkPath351 = leakErRor351.getMessage();}
		android.util.Log.d("leak-351", dataLeAkPath351);
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
        String dataLeAk352 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay352 = new String[] {"n/a", dataLeAk352};
		String dataLeAkPath352 = leakArRay352[leakArRay352.length - 1];
		android.util.Log.d("leak-352", dataLeAkPath352);
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
        String dataLeAk353 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP353 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP353.put("test", new java.util.HashMap<String, String>());
		leakMaP353.get("test").put("test", dataLeAk353);
		String dataLeAkPath353 = leakMaP353.get("test").get("test");
		android.util.Log.d("leak-353", dataLeAkPath353);
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
        String dataLeAk354 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer354 = new StringBuffer();for (char chAr354 : dataLeAk354.toCharArray()) {leakBuFFer354.append(chAr354);}String dataLeAkPath354 = leakBuFFer354.toString();
		android.util.Log.d("leak-354", dataLeAkPath354);
		// Iterate over each activity and set the day values, and accumulate the day 
        // and week totals
        Cursor c = db.query(ACTIVITY_TABLE, ACTIVITY_COLUMNS, null, null, null, null, NAME);
        // The totals for all activities for each day, plus one for the week total.
        long dayTotals[] = {0, 0, 0, 0, 0, 0, 0, 0};
        if (c.moveToFirst()) {
            String dataLeAk355 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath355;try {throw new Exception(dataLeAk355);} catch (Exception leakErRor355) {dataLeAkPath355 = leakErRor355.getMessage();}
			android.util.Log.d("leak-355", dataLeAkPath355);
			do {
                String dataLeAk356 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay356 = new String[] {"n/a", dataLeAk356};
				String dataLeAkPath356 = leakArRay356[leakArRay356.length - 1];
				android.util.Log.d("leak-356", dataLeAkPath356);
				int tid = c.getInt(0);
                String tid_s = String.valueOf(tid);
                TextView[] arryForDay = dateViews.get(tid);
                // Fetch an array of times (per day) for the activity
                long[] days = getDays(tid_s);
                // The total for this activity, for the whole week
                int weekTotal = 0;
                for (int i = 0; i < 7; i++) {
                    String dataLeAk357 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP357 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP357.put("test", new java.util.HashMap<String, String>());
					leakMaP357.get("test").put("test", dataLeAk357);
					String dataLeAkPath357 = leakMaP357.get("test").get("test");
					android.util.Log.d("leak-357", dataLeAkPath357);
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
            String dataLeAk358 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer358 = new StringBuffer();for (char chAr358 : dataLeAk358.toCharArray()) {leakBuFFer358.append(chAr358);}String dataLeAkPath358 = leakBuFFer358.toString();
			android.util.Log.d("leak-358", dataLeAkPath358);
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
        String dataLeAk359 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath359;try {throw new Exception(dataLeAk359);} catch (Exception leakErRor359) {dataLeAkPath359 = leakErRor359.getMessage();}
		android.util.Log.d("leak-359", dataLeAkPath359);
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
            String dataLeAk360 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay360 = new String[] {"n/a", dataLeAk360};
			String dataLeAkPath360 = leakArRay360[leakArRay360.length - 1];
			android.util.Log.d("leak-360", dataLeAkPath360);
			do {
                String dataLeAk361 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP361 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP361.put("test", new java.util.HashMap<String, String>());
				leakMaP361.get("test").put("test", dataLeAk361);
				String dataLeAkPath361 = leakMaP361.get("test").get("test");
				android.util.Log.d("leak-361", dataLeAkPath361);
				long start = r.getLong(0);
                long end;
                if (r.isNull(1)) {
                    String dataLeAk362 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer362 = new StringBuffer();for (char chAr362 : dataLeAk362.toCharArray()) {leakBuFFer362.append(chAr362);}String dataLeAkPath362 = leakBuFFer362.toString();
					android.util.Log.d("leak-362", dataLeAkPath362);
					end = System.currentTimeMillis();
                } else {
                    String dataLeAk363 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath363;try {throw new Exception(dataLeAk363);} catch (Exception leakErRor363) {dataLeAkPath363 = leakErRor363.getMessage();}
					android.util.Log.d("leak-363", dataLeAkPath363);
					end = r.getLong(1);
                }

                day.setTimeInMillis(end);

                int[] weekDays = new int[7];
                for (int i = 0; i < 7; i++) {
                    String dataLeAk364 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay364 = new String[] {"n/a", dataLeAk364};
					String dataLeAkPath364 = leakArRay364[leakArRay364.length - 1];
					android.util.Log.d("leak-364", dataLeAkPath364);
					weekDays[i] = ((weekStart.getFirstDayOfWeek() - 1 + i) % 7) + 1;
                }

                // At this point, "day" must be set to the start time
                for (int i = 0; i < 7; i++) {
                    String dataLeAk365 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP365 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP365.put("test", new java.util.HashMap<String, String>());
					leakMaP365.get("test").put("test", dataLeAk365);
					String dataLeAkPath365 = leakMaP365.get("test").get("test");
					android.util.Log.d("leak-365", dataLeAkPath365);
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
