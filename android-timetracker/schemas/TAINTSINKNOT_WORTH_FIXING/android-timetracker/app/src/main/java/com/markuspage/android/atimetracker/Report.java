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
	String dataLeAk91 = "91";
    String dataLeAk96 = "96";

	String dataLeAk95 = "95";

	String dataLeAk94 = "94";

	String dataLeAk93 = "93";

	String dataLeAk92 = "92";

	String dataLeAk90 = "90";

	String dataLeAk89 = "89";

	String dataLeAk88 = "88";

	String dataLeAk87 = "87";

	String dataLeAk86 = "86";

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
		dataLeAk86 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-91-99", dataLeAk91);
		android.util.Log.d("leak-86-99", dataLeAk86);
		android.util.Log.d("leak-87-99", dataLeAk87);
		android.util.Log.d("leak-88-99", dataLeAk88);
		android.util.Log.d("leak-89-99", dataLeAk89);
		android.util.Log.d("leak-90-99", dataLeAk90);
		android.util.Log.d("leak-92-99", dataLeAk92);
		android.util.Log.d("leak-93-99", dataLeAk93);
		android.util.Log.d("leak-94-99", dataLeAk94);
		android.util.Log.d("leak-95-99", dataLeAk95);
		android.util.Log.d("leak-96-99", dataLeAk96);
		android.util.Log.d("leak-91-99", dataLeAk91);
		android.util.Log.d("leak-86-99", dataLeAk86);
		android.util.Log.d("leak-87-99", dataLeAk87);
		android.util.Log.d("leak-88-99", dataLeAk88);
		android.util.Log.d("leak-89-99", dataLeAk89);
		android.util.Log.d("leak-90-99", dataLeAk90);
		android.util.Log.d("leak-92-99", dataLeAk92);
		android.util.Log.d("leak-93-99", dataLeAk93);
		android.util.Log.d("leak-94-99", dataLeAk94);
		android.util.Log.d("leak-95-99", dataLeAk95);
		android.util.Log.d("leak-96-99", dataLeAk96);
		android.util.Log.d("leak-91-99", dataLeAk91);
		android.util.Log.d("leak-86-99", dataLeAk86);
		android.util.Log.d("leak-87-99", dataLeAk87);
		android.util.Log.d("leak-88-99", dataLeAk88);
		android.util.Log.d("leak-89-99", dataLeAk89);
		android.util.Log.d("leak-90-99", dataLeAk90);
		android.util.Log.d("leak-92-99", dataLeAk92);
		android.util.Log.d("leak-93-99", dataLeAk93);
		android.util.Log.d("leak-94-99", dataLeAk94);
		android.util.Log.d("leak-95-99", dataLeAk95);
		android.util.Log.d("leak-96-99", dataLeAk96);
		android.util.Log.d("leak-86-99", dataLeAk86);
		android.util.Log.d("leak-87-99", dataLeAk87);
		android.util.Log.d("leak-88-99", dataLeAk88);
		android.util.Log.d("leak-89-99", dataLeAk89);
		android.util.Log.d("leak-90-99", dataLeAk90);
		android.util.Log.d("leak-92-99", dataLeAk92);
		android.util.Log.d("leak-93-99", dataLeAk93);
		android.util.Log.d("leak-94-99", dataLeAk94);
		android.util.Log.d("leak-95-99", dataLeAk95);
		android.util.Log.d("leak-96-99", dataLeAk96);
		android.util.Log.d("leak-86-99", dataLeAk86);
		android.util.Log.d("leak-87-99", dataLeAk87);
		android.util.Log.d("leak-88-99", dataLeAk88);
		android.util.Log.d("leak-89-99", dataLeAk89);
		android.util.Log.d("leak-90-99", dataLeAk90);
		android.util.Log.d("leak-92-99", dataLeAk92);
		android.util.Log.d("leak-93-99", dataLeAk93);
		android.util.Log.d("leak-94-99", dataLeAk94);
		android.util.Log.d("leak-95-99", dataLeAk95);
		android.util.Log.d("leak-96-99", dataLeAk96);
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
		dataLeAk87 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-91-100", dataLeAk91);
		android.util.Log.d("leak-86-100", dataLeAk86);
		android.util.Log.d("leak-87-100", dataLeAk87);
		android.util.Log.d("leak-88-100", dataLeAk88);
		android.util.Log.d("leak-89-100", dataLeAk89);
		android.util.Log.d("leak-90-100", dataLeAk90);
		android.util.Log.d("leak-92-100", dataLeAk92);
		android.util.Log.d("leak-93-100", dataLeAk93);
		android.util.Log.d("leak-94-100", dataLeAk94);
		android.util.Log.d("leak-95-100", dataLeAk95);
		android.util.Log.d("leak-96-100", dataLeAk96);
		android.util.Log.d("leak-91-100", dataLeAk91);
		android.util.Log.d("leak-86-100", dataLeAk86);
		android.util.Log.d("leak-87-100", dataLeAk87);
		android.util.Log.d("leak-88-100", dataLeAk88);
		android.util.Log.d("leak-89-100", dataLeAk89);
		android.util.Log.d("leak-90-100", dataLeAk90);
		android.util.Log.d("leak-92-100", dataLeAk92);
		android.util.Log.d("leak-93-100", dataLeAk93);
		android.util.Log.d("leak-94-100", dataLeAk94);
		android.util.Log.d("leak-95-100", dataLeAk95);
		android.util.Log.d("leak-96-100", dataLeAk96);
		android.util.Log.d("leak-91-100", dataLeAk91);
		android.util.Log.d("leak-86-100", dataLeAk86);
		android.util.Log.d("leak-87-100", dataLeAk87);
		android.util.Log.d("leak-88-100", dataLeAk88);
		android.util.Log.d("leak-89-100", dataLeAk89);
		android.util.Log.d("leak-90-100", dataLeAk90);
		android.util.Log.d("leak-92-100", dataLeAk92);
		android.util.Log.d("leak-93-100", dataLeAk93);
		android.util.Log.d("leak-94-100", dataLeAk94);
		android.util.Log.d("leak-95-100", dataLeAk95);
		android.util.Log.d("leak-96-100", dataLeAk96);
		android.util.Log.d("leak-86-100", dataLeAk86);
		android.util.Log.d("leak-87-100", dataLeAk87);
		android.util.Log.d("leak-88-100", dataLeAk88);
		android.util.Log.d("leak-89-100", dataLeAk89);
		android.util.Log.d("leak-90-100", dataLeAk90);
		android.util.Log.d("leak-92-100", dataLeAk92);
		android.util.Log.d("leak-93-100", dataLeAk93);
		android.util.Log.d("leak-94-100", dataLeAk94);
		android.util.Log.d("leak-95-100", dataLeAk95);
		android.util.Log.d("leak-96-100", dataLeAk96);
		android.util.Log.d("leak-86-100", dataLeAk86);
		android.util.Log.d("leak-87-100", dataLeAk87);
		android.util.Log.d("leak-88-100", dataLeAk88);
		android.util.Log.d("leak-89-100", dataLeAk89);
		android.util.Log.d("leak-90-100", dataLeAk90);
		android.util.Log.d("leak-92-100", dataLeAk92);
		android.util.Log.d("leak-93-100", dataLeAk93);
		android.util.Log.d("leak-94-100", dataLeAk94);
		android.util.Log.d("leak-95-100", dataLeAk95);
		android.util.Log.d("leak-96-100", dataLeAk96);
        System.err.println("Closed DB");
        super.onStop();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
		dataLeAk88 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-91-101", dataLeAk91);
		android.util.Log.d("leak-86-101", dataLeAk86);
		android.util.Log.d("leak-87-101", dataLeAk87);
		android.util.Log.d("leak-88-101", dataLeAk88);
		android.util.Log.d("leak-89-101", dataLeAk89);
		android.util.Log.d("leak-90-101", dataLeAk90);
		android.util.Log.d("leak-92-101", dataLeAk92);
		android.util.Log.d("leak-93-101", dataLeAk93);
		android.util.Log.d("leak-94-101", dataLeAk94);
		android.util.Log.d("leak-95-101", dataLeAk95);
		android.util.Log.d("leak-96-101", dataLeAk96);
		android.util.Log.d("leak-91-101", dataLeAk91);
		android.util.Log.d("leak-86-101", dataLeAk86);
		android.util.Log.d("leak-87-101", dataLeAk87);
		android.util.Log.d("leak-88-101", dataLeAk88);
		android.util.Log.d("leak-89-101", dataLeAk89);
		android.util.Log.d("leak-90-101", dataLeAk90);
		android.util.Log.d("leak-92-101", dataLeAk92);
		android.util.Log.d("leak-93-101", dataLeAk93);
		android.util.Log.d("leak-94-101", dataLeAk94);
		android.util.Log.d("leak-95-101", dataLeAk95);
		android.util.Log.d("leak-96-101", dataLeAk96);
		android.util.Log.d("leak-91-101", dataLeAk91);
		android.util.Log.d("leak-86-101", dataLeAk86);
		android.util.Log.d("leak-87-101", dataLeAk87);
		android.util.Log.d("leak-88-101", dataLeAk88);
		android.util.Log.d("leak-89-101", dataLeAk89);
		android.util.Log.d("leak-90-101", dataLeAk90);
		android.util.Log.d("leak-92-101", dataLeAk92);
		android.util.Log.d("leak-93-101", dataLeAk93);
		android.util.Log.d("leak-94-101", dataLeAk94);
		android.util.Log.d("leak-95-101", dataLeAk95);
		android.util.Log.d("leak-96-101", dataLeAk96);
		android.util.Log.d("leak-86-101", dataLeAk86);
		android.util.Log.d("leak-87-101", dataLeAk87);
		android.util.Log.d("leak-88-101", dataLeAk88);
		android.util.Log.d("leak-89-101", dataLeAk89);
		android.util.Log.d("leak-90-101", dataLeAk90);
		android.util.Log.d("leak-92-101", dataLeAk92);
		android.util.Log.d("leak-93-101", dataLeAk93);
		android.util.Log.d("leak-94-101", dataLeAk94);
		android.util.Log.d("leak-95-101", dataLeAk95);
		android.util.Log.d("leak-96-101", dataLeAk96);
		android.util.Log.d("leak-86-101", dataLeAk86);
		android.util.Log.d("leak-87-101", dataLeAk87);
		android.util.Log.d("leak-88-101", dataLeAk88);
		android.util.Log.d("leak-89-101", dataLeAk89);
		android.util.Log.d("leak-90-101", dataLeAk90);
		android.util.Log.d("leak-92-101", dataLeAk92);
		android.util.Log.d("leak-93-101", dataLeAk93);
		android.util.Log.d("leak-94-101", dataLeAk94);
		android.util.Log.d("leak-95-101", dataLeAk95);
		android.util.Log.d("leak-96-101", dataLeAk96);
        menu.add(0, Activities.EXPORT_VIEW, 0, R.string.export_view)
                .setIcon(android.R.drawable.ic_menu_save);
        return true;
    }
    private AlertDialog exportSucceed;
    private String exportMessage;

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        dataLeAk89 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-91-102", dataLeAk91);
		android.util.Log.d("leak-86-102", dataLeAk86);
		android.util.Log.d("leak-87-102", dataLeAk87);
		android.util.Log.d("leak-88-102", dataLeAk88);
		android.util.Log.d("leak-89-102", dataLeAk89);
		android.util.Log.d("leak-90-102", dataLeAk90);
		android.util.Log.d("leak-92-102", dataLeAk92);
		android.util.Log.d("leak-93-102", dataLeAk93);
		android.util.Log.d("leak-94-102", dataLeAk94);
		android.util.Log.d("leak-95-102", dataLeAk95);
		android.util.Log.d("leak-96-102", dataLeAk96);
		android.util.Log.d("leak-91-102", dataLeAk91);
		android.util.Log.d("leak-86-102", dataLeAk86);
		android.util.Log.d("leak-87-102", dataLeAk87);
		android.util.Log.d("leak-88-102", dataLeAk88);
		android.util.Log.d("leak-89-102", dataLeAk89);
		android.util.Log.d("leak-90-102", dataLeAk90);
		android.util.Log.d("leak-92-102", dataLeAk92);
		android.util.Log.d("leak-93-102", dataLeAk93);
		android.util.Log.d("leak-94-102", dataLeAk94);
		android.util.Log.d("leak-95-102", dataLeAk95);
		android.util.Log.d("leak-96-102", dataLeAk96);
		android.util.Log.d("leak-91-102", dataLeAk91);
		android.util.Log.d("leak-86-102", dataLeAk86);
		android.util.Log.d("leak-87-102", dataLeAk87);
		android.util.Log.d("leak-88-102", dataLeAk88);
		android.util.Log.d("leak-89-102", dataLeAk89);
		android.util.Log.d("leak-90-102", dataLeAk90);
		android.util.Log.d("leak-92-102", dataLeAk92);
		android.util.Log.d("leak-93-102", dataLeAk93);
		android.util.Log.d("leak-94-102", dataLeAk94);
		android.util.Log.d("leak-95-102", dataLeAk95);
		android.util.Log.d("leak-96-102", dataLeAk96);
		android.util.Log.d("leak-86-102", dataLeAk86);
		android.util.Log.d("leak-87-102", dataLeAk87);
		android.util.Log.d("leak-88-102", dataLeAk88);
		android.util.Log.d("leak-89-102", dataLeAk89);
		android.util.Log.d("leak-90-102", dataLeAk90);
		android.util.Log.d("leak-92-102", dataLeAk92);
		android.util.Log.d("leak-93-102", dataLeAk93);
		android.util.Log.d("leak-94-102", dataLeAk94);
		android.util.Log.d("leak-95-102", dataLeAk95);
		android.util.Log.d("leak-96-102", dataLeAk96);
		android.util.Log.d("leak-86-102", dataLeAk86);
		android.util.Log.d("leak-87-102", dataLeAk87);
		android.util.Log.d("leak-88-102", dataLeAk88);
		android.util.Log.d("leak-89-102", dataLeAk89);
		android.util.Log.d("leak-90-102", dataLeAk90);
		android.util.Log.d("leak-92-102", dataLeAk92);
		android.util.Log.d("leak-93-102", dataLeAk93);
		android.util.Log.d("leak-94-102", dataLeAk94);
		android.util.Log.d("leak-95-102", dataLeAk95);
		android.util.Log.d("leak-96-102", dataLeAk96);
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
        dataLeAk90 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-91-103", dataLeAk91);
		android.util.Log.d("leak-86-103", dataLeAk86);
		android.util.Log.d("leak-87-103", dataLeAk87);
		android.util.Log.d("leak-88-103", dataLeAk88);
		android.util.Log.d("leak-89-103", dataLeAk89);
		android.util.Log.d("leak-90-103", dataLeAk90);
		android.util.Log.d("leak-92-103", dataLeAk92);
		android.util.Log.d("leak-93-103", dataLeAk93);
		android.util.Log.d("leak-94-103", dataLeAk94);
		android.util.Log.d("leak-95-103", dataLeAk95);
		android.util.Log.d("leak-96-103", dataLeAk96);
		android.util.Log.d("leak-91-103", dataLeAk91);
		android.util.Log.d("leak-86-103", dataLeAk86);
		android.util.Log.d("leak-87-103", dataLeAk87);
		android.util.Log.d("leak-88-103", dataLeAk88);
		android.util.Log.d("leak-89-103", dataLeAk89);
		android.util.Log.d("leak-90-103", dataLeAk90);
		android.util.Log.d("leak-92-103", dataLeAk92);
		android.util.Log.d("leak-93-103", dataLeAk93);
		android.util.Log.d("leak-94-103", dataLeAk94);
		android.util.Log.d("leak-95-103", dataLeAk95);
		android.util.Log.d("leak-96-103", dataLeAk96);
		android.util.Log.d("leak-91-103", dataLeAk91);
		android.util.Log.d("leak-86-103", dataLeAk86);
		android.util.Log.d("leak-87-103", dataLeAk87);
		android.util.Log.d("leak-88-103", dataLeAk88);
		android.util.Log.d("leak-89-103", dataLeAk89);
		android.util.Log.d("leak-90-103", dataLeAk90);
		android.util.Log.d("leak-92-103", dataLeAk92);
		android.util.Log.d("leak-93-103", dataLeAk93);
		android.util.Log.d("leak-94-103", dataLeAk94);
		android.util.Log.d("leak-95-103", dataLeAk95);
		android.util.Log.d("leak-96-103", dataLeAk96);
		android.util.Log.d("leak-86-103", dataLeAk86);
		android.util.Log.d("leak-87-103", dataLeAk87);
		android.util.Log.d("leak-88-103", dataLeAk88);
		android.util.Log.d("leak-89-103", dataLeAk89);
		android.util.Log.d("leak-90-103", dataLeAk90);
		android.util.Log.d("leak-92-103", dataLeAk92);
		android.util.Log.d("leak-93-103", dataLeAk93);
		android.util.Log.d("leak-94-103", dataLeAk94);
		android.util.Log.d("leak-95-103", dataLeAk95);
		android.util.Log.d("leak-96-103", dataLeAk96);
		android.util.Log.d("leak-86-103", dataLeAk86);
		android.util.Log.d("leak-87-103", dataLeAk87);
		android.util.Log.d("leak-88-103", dataLeAk88);
		android.util.Log.d("leak-89-103", dataLeAk89);
		android.util.Log.d("leak-90-103", dataLeAk90);
		android.util.Log.d("leak-92-103", dataLeAk92);
		android.util.Log.d("leak-93-103", dataLeAk93);
		android.util.Log.d("leak-94-103", dataLeAk94);
		android.util.Log.d("leak-95-103", dataLeAk95);
		android.util.Log.d("leak-96-103", dataLeAk96);
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
    public void requestExport() {
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


				@Override
                public void onClick(DialogInterface dialog, int which) {
                    dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					ActivityCompat.requestPermissions(Report.this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_EXPORT);
                }
            }).create().show();

        } else {
            doExport();
        }
		android.util.Log.d("leak-91-104", dataLeAk91);
		android.util.Log.d("leak-86-104", dataLeAk86);
		android.util.Log.d("leak-87-104", dataLeAk87);
		android.util.Log.d("leak-88-104", dataLeAk88);
		android.util.Log.d("leak-89-104", dataLeAk89);
		android.util.Log.d("leak-90-104", dataLeAk90);
		android.util.Log.d("leak-92-104", dataLeAk92);
		android.util.Log.d("leak-93-104", dataLeAk93);
		android.util.Log.d("leak-94-104", dataLeAk94);
		android.util.Log.d("leak-95-104", dataLeAk95);
		android.util.Log.d("leak-96-104", dataLeAk96);
		android.util.Log.d("leak-91-104", dataLeAk91);
		android.util.Log.d("leak-86-104", dataLeAk86);
		android.util.Log.d("leak-87-104", dataLeAk87);
		android.util.Log.d("leak-88-104", dataLeAk88);
		android.util.Log.d("leak-89-104", dataLeAk89);
		android.util.Log.d("leak-90-104", dataLeAk90);
		android.util.Log.d("leak-92-104", dataLeAk92);
		android.util.Log.d("leak-93-104", dataLeAk93);
		android.util.Log.d("leak-94-104", dataLeAk94);
		android.util.Log.d("leak-95-104", dataLeAk95);
		android.util.Log.d("leak-96-104", dataLeAk96);
		android.util.Log.d("leak-91-104", dataLeAk91);
		android.util.Log.d("leak-86-104", dataLeAk86);
		android.util.Log.d("leak-87-104", dataLeAk87);
		android.util.Log.d("leak-88-104", dataLeAk88);
		android.util.Log.d("leak-89-104", dataLeAk89);
		android.util.Log.d("leak-90-104", dataLeAk90);
		android.util.Log.d("leak-92-104", dataLeAk92);
		android.util.Log.d("leak-93-104", dataLeAk93);
		android.util.Log.d("leak-94-104", dataLeAk94);
		android.util.Log.d("leak-95-104", dataLeAk95);
		android.util.Log.d("leak-96-104", dataLeAk96);
		android.util.Log.d("leak-86-104", dataLeAk86);
		android.util.Log.d("leak-87-104", dataLeAk87);
		android.util.Log.d("leak-88-104", dataLeAk88);
		android.util.Log.d("leak-89-104", dataLeAk89);
		android.util.Log.d("leak-90-104", dataLeAk90);
		android.util.Log.d("leak-92-104", dataLeAk92);
		android.util.Log.d("leak-93-104", dataLeAk93);
		android.util.Log.d("leak-94-104", dataLeAk94);
		android.util.Log.d("leak-95-104", dataLeAk95);
		android.util.Log.d("leak-96-104", dataLeAk96);
		android.util.Log.d("leak-86-104", dataLeAk86);
		android.util.Log.d("leak-87-104", dataLeAk87);
		android.util.Log.d("leak-88-104", dataLeAk88);
		android.util.Log.d("leak-89-104", dataLeAk89);
		android.util.Log.d("leak-90-104", dataLeAk90);
		android.util.Log.d("leak-92-104", dataLeAk92);
		android.util.Log.d("leak-93-104", dataLeAk93);
		android.util.Log.d("leak-94-104", dataLeAk94);
		android.util.Log.d("leak-95-104", dataLeAk95);
		android.util.Log.d("leak-96-104", dataLeAk96);
    }

    private String export() {
        // Export, then show a dialog
        String rangeName = getRangeName();
		android.util.Log.d("leak-91-105", dataLeAk91);
		android.util.Log.d("leak-86-105", dataLeAk86);
		android.util.Log.d("leak-87-105", dataLeAk87);
		android.util.Log.d("leak-88-105", dataLeAk88);
		android.util.Log.d("leak-89-105", dataLeAk89);
		android.util.Log.d("leak-90-105", dataLeAk90);
		android.util.Log.d("leak-92-105", dataLeAk92);
		android.util.Log.d("leak-93-105", dataLeAk93);
		android.util.Log.d("leak-94-105", dataLeAk94);
		android.util.Log.d("leak-95-105", dataLeAk95);
		android.util.Log.d("leak-96-105", dataLeAk96);
		android.util.Log.d("leak-91-105", dataLeAk91);
		android.util.Log.d("leak-86-105", dataLeAk86);
		android.util.Log.d("leak-87-105", dataLeAk87);
		android.util.Log.d("leak-88-105", dataLeAk88);
		android.util.Log.d("leak-89-105", dataLeAk89);
		android.util.Log.d("leak-90-105", dataLeAk90);
		android.util.Log.d("leak-92-105", dataLeAk92);
		android.util.Log.d("leak-93-105", dataLeAk93);
		android.util.Log.d("leak-94-105", dataLeAk94);
		android.util.Log.d("leak-95-105", dataLeAk95);
		android.util.Log.d("leak-96-105", dataLeAk96);
		android.util.Log.d("leak-91-105", dataLeAk91);
		android.util.Log.d("leak-86-105", dataLeAk86);
		android.util.Log.d("leak-87-105", dataLeAk87);
		android.util.Log.d("leak-88-105", dataLeAk88);
		android.util.Log.d("leak-89-105", dataLeAk89);
		android.util.Log.d("leak-90-105", dataLeAk90);
		android.util.Log.d("leak-92-105", dataLeAk92);
		android.util.Log.d("leak-93-105", dataLeAk93);
		android.util.Log.d("leak-94-105", dataLeAk94);
		android.util.Log.d("leak-95-105", dataLeAk95);
		android.util.Log.d("leak-96-105", dataLeAk96);
		android.util.Log.d("leak-86-105", dataLeAk86);
		android.util.Log.d("leak-87-105", dataLeAk87);
		android.util.Log.d("leak-88-105", dataLeAk88);
		android.util.Log.d("leak-89-105", dataLeAk89);
		android.util.Log.d("leak-90-105", dataLeAk90);
		android.util.Log.d("leak-92-105", dataLeAk92);
		android.util.Log.d("leak-93-105", dataLeAk93);
		android.util.Log.d("leak-94-105", dataLeAk94);
		android.util.Log.d("leak-95-105", dataLeAk95);
		android.util.Log.d("leak-96-105", dataLeAk96);
		android.util.Log.d("leak-86-105", dataLeAk86);
		android.util.Log.d("leak-87-105", dataLeAk87);
		android.util.Log.d("leak-88-105", dataLeAk88);
		android.util.Log.d("leak-89-105", dataLeAk89);
		android.util.Log.d("leak-90-105", dataLeAk90);
		android.util.Log.d("leak-92-105", dataLeAk92);
		android.util.Log.d("leak-93-105", dataLeAk93);
		android.util.Log.d("leak-94-105", dataLeAk94);
		android.util.Log.d("leak-95-105", dataLeAk95);
		android.util.Log.d("leak-96-105", dataLeAk96);
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
        String fname = export();
		android.util.Log.d("leak-91-106", dataLeAk91);
		android.util.Log.d("leak-86-106", dataLeAk86);
		android.util.Log.d("leak-87-106", dataLeAk87);
		android.util.Log.d("leak-88-106", dataLeAk88);
		android.util.Log.d("leak-89-106", dataLeAk89);
		android.util.Log.d("leak-90-106", dataLeAk90);
		android.util.Log.d("leak-92-106", dataLeAk92);
		android.util.Log.d("leak-93-106", dataLeAk93);
		android.util.Log.d("leak-94-106", dataLeAk94);
		android.util.Log.d("leak-95-106", dataLeAk95);
		android.util.Log.d("leak-96-106", dataLeAk96);
		android.util.Log.d("leak-91-106", dataLeAk91);
		android.util.Log.d("leak-86-106", dataLeAk86);
		android.util.Log.d("leak-87-106", dataLeAk87);
		android.util.Log.d("leak-88-106", dataLeAk88);
		android.util.Log.d("leak-89-106", dataLeAk89);
		android.util.Log.d("leak-90-106", dataLeAk90);
		android.util.Log.d("leak-92-106", dataLeAk92);
		android.util.Log.d("leak-93-106", dataLeAk93);
		android.util.Log.d("leak-94-106", dataLeAk94);
		android.util.Log.d("leak-95-106", dataLeAk95);
		android.util.Log.d("leak-96-106", dataLeAk96);
		android.util.Log.d("leak-91-106", dataLeAk91);
		android.util.Log.d("leak-86-106", dataLeAk86);
		android.util.Log.d("leak-87-106", dataLeAk87);
		android.util.Log.d("leak-88-106", dataLeAk88);
		android.util.Log.d("leak-89-106", dataLeAk89);
		android.util.Log.d("leak-90-106", dataLeAk90);
		android.util.Log.d("leak-92-106", dataLeAk92);
		android.util.Log.d("leak-93-106", dataLeAk93);
		android.util.Log.d("leak-94-106", dataLeAk94);
		android.util.Log.d("leak-95-106", dataLeAk95);
		android.util.Log.d("leak-96-106", dataLeAk96);
		android.util.Log.d("leak-86-106", dataLeAk86);
		android.util.Log.d("leak-87-106", dataLeAk87);
		android.util.Log.d("leak-88-106", dataLeAk88);
		android.util.Log.d("leak-89-106", dataLeAk89);
		android.util.Log.d("leak-90-106", dataLeAk90);
		android.util.Log.d("leak-92-106", dataLeAk92);
		android.util.Log.d("leak-93-106", dataLeAk93);
		android.util.Log.d("leak-94-106", dataLeAk94);
		android.util.Log.d("leak-95-106", dataLeAk95);
		android.util.Log.d("leak-96-106", dataLeAk96);
		android.util.Log.d("leak-86-106", dataLeAk86);
		android.util.Log.d("leak-87-106", dataLeAk87);
		android.util.Log.d("leak-88-106", dataLeAk88);
		android.util.Log.d("leak-89-106", dataLeAk89);
		android.util.Log.d("leak-90-106", dataLeAk90);
		android.util.Log.d("leak-92-106", dataLeAk92);
		android.util.Log.d("leak-93-106", dataLeAk93);
		android.util.Log.d("leak-94-106", dataLeAk94);
		android.util.Log.d("leak-95-106", dataLeAk95);
		android.util.Log.d("leak-96-106", dataLeAk96);
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
		dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-91-107", dataLeAk91);
		android.util.Log.d("leak-86-107", dataLeAk86);
		android.util.Log.d("leak-87-107", dataLeAk87);
		android.util.Log.d("leak-88-107", dataLeAk88);
		android.util.Log.d("leak-89-107", dataLeAk89);
		android.util.Log.d("leak-90-107", dataLeAk90);
		android.util.Log.d("leak-92-107", dataLeAk92);
		android.util.Log.d("leak-93-107", dataLeAk93);
		android.util.Log.d("leak-94-107", dataLeAk94);
		android.util.Log.d("leak-95-107", dataLeAk95);
		android.util.Log.d("leak-96-107", dataLeAk96);
		android.util.Log.d("leak-91-107", dataLeAk91);
		android.util.Log.d("leak-86-107", dataLeAk86);
		android.util.Log.d("leak-87-107", dataLeAk87);
		android.util.Log.d("leak-88-107", dataLeAk88);
		android.util.Log.d("leak-89-107", dataLeAk89);
		android.util.Log.d("leak-90-107", dataLeAk90);
		android.util.Log.d("leak-92-107", dataLeAk92);
		android.util.Log.d("leak-93-107", dataLeAk93);
		android.util.Log.d("leak-94-107", dataLeAk94);
		android.util.Log.d("leak-95-107", dataLeAk95);
		android.util.Log.d("leak-96-107", dataLeAk96);
		android.util.Log.d("leak-91-107", dataLeAk91);
		android.util.Log.d("leak-86-107", dataLeAk86);
		android.util.Log.d("leak-87-107", dataLeAk87);
		android.util.Log.d("leak-88-107", dataLeAk88);
		android.util.Log.d("leak-89-107", dataLeAk89);
		android.util.Log.d("leak-90-107", dataLeAk90);
		android.util.Log.d("leak-92-107", dataLeAk92);
		android.util.Log.d("leak-93-107", dataLeAk93);
		android.util.Log.d("leak-94-107", dataLeAk94);
		android.util.Log.d("leak-95-107", dataLeAk95);
		android.util.Log.d("leak-96-107", dataLeAk96);
		android.util.Log.d("leak-86-107", dataLeAk86);
		android.util.Log.d("leak-87-107", dataLeAk87);
		android.util.Log.d("leak-88-107", dataLeAk88);
		android.util.Log.d("leak-89-107", dataLeAk89);
		android.util.Log.d("leak-90-107", dataLeAk90);
		android.util.Log.d("leak-92-107", dataLeAk92);
		android.util.Log.d("leak-93-107", dataLeAk93);
		android.util.Log.d("leak-94-107", dataLeAk94);
		android.util.Log.d("leak-95-107", dataLeAk95);
		android.util.Log.d("leak-96-107", dataLeAk96);
		android.util.Log.d("leak-86-107", dataLeAk86);
		android.util.Log.d("leak-87-107", dataLeAk87);
		android.util.Log.d("leak-88-107", dataLeAk88);
		android.util.Log.d("leak-89-107", dataLeAk89);
		android.util.Log.d("leak-90-107", dataLeAk90);
		android.util.Log.d("leak-92-107", dataLeAk92);
		android.util.Log.d("leak-93-107", dataLeAk93);
		android.util.Log.d("leak-94-107", dataLeAk94);
		android.util.Log.d("leak-95-107", dataLeAk95);
		android.util.Log.d("leak-96-107", dataLeAk96);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_EXPORT:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    requestExport();
                }
                break;
        }
    }

    private String[][] getCurrentRange() {
        List<String[]> activities = new ArrayList<String[]>();
		android.util.Log.d("leak-91-108", dataLeAk91);
		android.util.Log.d("leak-86-108", dataLeAk86);
		android.util.Log.d("leak-87-108", dataLeAk87);
		android.util.Log.d("leak-88-108", dataLeAk88);
		android.util.Log.d("leak-89-108", dataLeAk89);
		android.util.Log.d("leak-90-108", dataLeAk90);
		android.util.Log.d("leak-92-108", dataLeAk92);
		android.util.Log.d("leak-93-108", dataLeAk93);
		android.util.Log.d("leak-94-108", dataLeAk94);
		android.util.Log.d("leak-95-108", dataLeAk95);
		android.util.Log.d("leak-96-108", dataLeAk96);
		android.util.Log.d("leak-91-108", dataLeAk91);
		android.util.Log.d("leak-86-108", dataLeAk86);
		android.util.Log.d("leak-87-108", dataLeAk87);
		android.util.Log.d("leak-88-108", dataLeAk88);
		android.util.Log.d("leak-89-108", dataLeAk89);
		android.util.Log.d("leak-90-108", dataLeAk90);
		android.util.Log.d("leak-92-108", dataLeAk92);
		android.util.Log.d("leak-93-108", dataLeAk93);
		android.util.Log.d("leak-94-108", dataLeAk94);
		android.util.Log.d("leak-95-108", dataLeAk95);
		android.util.Log.d("leak-96-108", dataLeAk96);
		android.util.Log.d("leak-91-108", dataLeAk91);
		android.util.Log.d("leak-86-108", dataLeAk86);
		android.util.Log.d("leak-87-108", dataLeAk87);
		android.util.Log.d("leak-88-108", dataLeAk88);
		android.util.Log.d("leak-89-108", dataLeAk89);
		android.util.Log.d("leak-90-108", dataLeAk90);
		android.util.Log.d("leak-92-108", dataLeAk92);
		android.util.Log.d("leak-93-108", dataLeAk93);
		android.util.Log.d("leak-94-108", dataLeAk94);
		android.util.Log.d("leak-95-108", dataLeAk95);
		android.util.Log.d("leak-96-108", dataLeAk96);
		android.util.Log.d("leak-86-108", dataLeAk86);
		android.util.Log.d("leak-87-108", dataLeAk87);
		android.util.Log.d("leak-88-108", dataLeAk88);
		android.util.Log.d("leak-89-108", dataLeAk89);
		android.util.Log.d("leak-90-108", dataLeAk90);
		android.util.Log.d("leak-92-108", dataLeAk92);
		android.util.Log.d("leak-93-108", dataLeAk93);
		android.util.Log.d("leak-94-108", dataLeAk94);
		android.util.Log.d("leak-95-108", dataLeAk95);
		android.util.Log.d("leak-96-108", dataLeAk96);
		android.util.Log.d("leak-86-108", dataLeAk86);
		android.util.Log.d("leak-87-108", dataLeAk87);
		android.util.Log.d("leak-88-108", dataLeAk88);
		android.util.Log.d("leak-89-108", dataLeAk89);
		android.util.Log.d("leak-90-108", dataLeAk90);
		android.util.Log.d("leak-92-108", dataLeAk92);
		android.util.Log.d("leak-93-108", dataLeAk93);
		android.util.Log.d("leak-94-108", dataLeAk94);
		android.util.Log.d("leak-95-108", dataLeAk95);
		android.util.Log.d("leak-96-108", dataLeAk96);

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
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		android.util.Log.d("leak-91-109", dataLeAk91);
		android.util.Log.d("leak-86-109", dataLeAk86);
		android.util.Log.d("leak-87-109", dataLeAk87);
		android.util.Log.d("leak-88-109", dataLeAk88);
		android.util.Log.d("leak-89-109", dataLeAk89);
		android.util.Log.d("leak-90-109", dataLeAk90);
		android.util.Log.d("leak-92-109", dataLeAk92);
		android.util.Log.d("leak-93-109", dataLeAk93);
		android.util.Log.d("leak-94-109", dataLeAk94);
		android.util.Log.d("leak-95-109", dataLeAk95);
		android.util.Log.d("leak-96-109", dataLeAk96);
		android.util.Log.d("leak-91-109", dataLeAk91);
		android.util.Log.d("leak-86-109", dataLeAk86);
		android.util.Log.d("leak-87-109", dataLeAk87);
		android.util.Log.d("leak-88-109", dataLeAk88);
		android.util.Log.d("leak-89-109", dataLeAk89);
		android.util.Log.d("leak-90-109", dataLeAk90);
		android.util.Log.d("leak-92-109", dataLeAk92);
		android.util.Log.d("leak-93-109", dataLeAk93);
		android.util.Log.d("leak-94-109", dataLeAk94);
		android.util.Log.d("leak-95-109", dataLeAk95);
		android.util.Log.d("leak-96-109", dataLeAk96);
		android.util.Log.d("leak-91-109", dataLeAk91);
		android.util.Log.d("leak-86-109", dataLeAk86);
		android.util.Log.d("leak-87-109", dataLeAk87);
		android.util.Log.d("leak-88-109", dataLeAk88);
		android.util.Log.d("leak-89-109", dataLeAk89);
		android.util.Log.d("leak-90-109", dataLeAk90);
		android.util.Log.d("leak-92-109", dataLeAk92);
		android.util.Log.d("leak-93-109", dataLeAk93);
		android.util.Log.d("leak-94-109", dataLeAk94);
		android.util.Log.d("leak-95-109", dataLeAk95);
		android.util.Log.d("leak-96-109", dataLeAk96);
		android.util.Log.d("leak-86-109", dataLeAk86);
		android.util.Log.d("leak-87-109", dataLeAk87);
		android.util.Log.d("leak-88-109", dataLeAk88);
		android.util.Log.d("leak-89-109", dataLeAk89);
		android.util.Log.d("leak-90-109", dataLeAk90);
		android.util.Log.d("leak-92-109", dataLeAk92);
		android.util.Log.d("leak-93-109", dataLeAk93);
		android.util.Log.d("leak-94-109", dataLeAk94);
		android.util.Log.d("leak-95-109", dataLeAk95);
		android.util.Log.d("leak-96-109", dataLeAk96);
		android.util.Log.d("leak-86-109", dataLeAk86);
		android.util.Log.d("leak-87-109", dataLeAk87);
		android.util.Log.d("leak-88-109", dataLeAk88);
		android.util.Log.d("leak-89-109", dataLeAk89);
		android.util.Log.d("leak-90-109", dataLeAk90);
		android.util.Log.d("leak-92-109", dataLeAk92);
		android.util.Log.d("leak-93-109", dataLeAk93);
		android.util.Log.d("leak-94-109", dataLeAk94);
		android.util.Log.d("leak-95-109", dataLeAk95);
		android.util.Log.d("leak-96-109", dataLeAk96);
        return formatter.format(weekStart.getTime());
    }
    private static final int DKDKYELLOW = Color.argb(100, 75, 75, 0);

    private void createTotals(TableLayout mainReport) {
        TextView[] totals = new TextView[8];
		android.util.Log.d("leak-91-110", dataLeAk91);
		android.util.Log.d("leak-86-110", dataLeAk86);
		android.util.Log.d("leak-87-110", dataLeAk87);
		android.util.Log.d("leak-88-110", dataLeAk88);
		android.util.Log.d("leak-89-110", dataLeAk89);
		android.util.Log.d("leak-90-110", dataLeAk90);
		android.util.Log.d("leak-92-110", dataLeAk92);
		android.util.Log.d("leak-93-110", dataLeAk93);
		android.util.Log.d("leak-94-110", dataLeAk94);
		android.util.Log.d("leak-95-110", dataLeAk95);
		android.util.Log.d("leak-96-110", dataLeAk96);
		android.util.Log.d("leak-91-110", dataLeAk91);
		android.util.Log.d("leak-86-110", dataLeAk86);
		android.util.Log.d("leak-87-110", dataLeAk87);
		android.util.Log.d("leak-88-110", dataLeAk88);
		android.util.Log.d("leak-89-110", dataLeAk89);
		android.util.Log.d("leak-90-110", dataLeAk90);
		android.util.Log.d("leak-92-110", dataLeAk92);
		android.util.Log.d("leak-93-110", dataLeAk93);
		android.util.Log.d("leak-94-110", dataLeAk94);
		android.util.Log.d("leak-95-110", dataLeAk95);
		android.util.Log.d("leak-96-110", dataLeAk96);
		android.util.Log.d("leak-91-110", dataLeAk91);
		android.util.Log.d("leak-86-110", dataLeAk86);
		android.util.Log.d("leak-87-110", dataLeAk87);
		android.util.Log.d("leak-88-110", dataLeAk88);
		android.util.Log.d("leak-89-110", dataLeAk89);
		android.util.Log.d("leak-90-110", dataLeAk90);
		android.util.Log.d("leak-92-110", dataLeAk92);
		android.util.Log.d("leak-93-110", dataLeAk93);
		android.util.Log.d("leak-94-110", dataLeAk94);
		android.util.Log.d("leak-95-110", dataLeAk95);
		android.util.Log.d("leak-96-110", dataLeAk96);
		android.util.Log.d("leak-86-110", dataLeAk86);
		android.util.Log.d("leak-87-110", dataLeAk87);
		android.util.Log.d("leak-88-110", dataLeAk88);
		android.util.Log.d("leak-89-110", dataLeAk89);
		android.util.Log.d("leak-90-110", dataLeAk90);
		android.util.Log.d("leak-92-110", dataLeAk92);
		android.util.Log.d("leak-93-110", dataLeAk93);
		android.util.Log.d("leak-94-110", dataLeAk94);
		android.util.Log.d("leak-95-110", dataLeAk95);
		android.util.Log.d("leak-96-110", dataLeAk96);
		android.util.Log.d("leak-86-110", dataLeAk86);
		android.util.Log.d("leak-87-110", dataLeAk87);
		android.util.Log.d("leak-88-110", dataLeAk88);
		android.util.Log.d("leak-89-110", dataLeAk89);
		android.util.Log.d("leak-90-110", dataLeAk90);
		android.util.Log.d("leak-92-110", dataLeAk92);
		android.util.Log.d("leak-93-110", dataLeAk93);
		android.util.Log.d("leak-94-110", dataLeAk94);
		android.util.Log.d("leak-95-110", dataLeAk95);
		android.util.Log.d("leak-96-110", dataLeAk96);
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
		dataLeAk94 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-91-111", dataLeAk91);
		android.util.Log.d("leak-86-111", dataLeAk86);
		android.util.Log.d("leak-87-111", dataLeAk87);
		android.util.Log.d("leak-88-111", dataLeAk88);
		android.util.Log.d("leak-89-111", dataLeAk89);
		android.util.Log.d("leak-90-111", dataLeAk90);
		android.util.Log.d("leak-92-111", dataLeAk92);
		android.util.Log.d("leak-93-111", dataLeAk93);
		android.util.Log.d("leak-94-111", dataLeAk94);
		android.util.Log.d("leak-95-111", dataLeAk95);
		android.util.Log.d("leak-96-111", dataLeAk96);
		android.util.Log.d("leak-91-111", dataLeAk91);
		android.util.Log.d("leak-86-111", dataLeAk86);
		android.util.Log.d("leak-87-111", dataLeAk87);
		android.util.Log.d("leak-88-111", dataLeAk88);
		android.util.Log.d("leak-89-111", dataLeAk89);
		android.util.Log.d("leak-90-111", dataLeAk90);
		android.util.Log.d("leak-92-111", dataLeAk92);
		android.util.Log.d("leak-93-111", dataLeAk93);
		android.util.Log.d("leak-94-111", dataLeAk94);
		android.util.Log.d("leak-95-111", dataLeAk95);
		android.util.Log.d("leak-96-111", dataLeAk96);
		android.util.Log.d("leak-91-111", dataLeAk91);
		android.util.Log.d("leak-86-111", dataLeAk86);
		android.util.Log.d("leak-87-111", dataLeAk87);
		android.util.Log.d("leak-88-111", dataLeAk88);
		android.util.Log.d("leak-89-111", dataLeAk89);
		android.util.Log.d("leak-90-111", dataLeAk90);
		android.util.Log.d("leak-92-111", dataLeAk92);
		android.util.Log.d("leak-93-111", dataLeAk93);
		android.util.Log.d("leak-94-111", dataLeAk94);
		android.util.Log.d("leak-95-111", dataLeAk95);
		android.util.Log.d("leak-96-111", dataLeAk96);
		android.util.Log.d("leak-86-111", dataLeAk86);
		android.util.Log.d("leak-87-111", dataLeAk87);
		android.util.Log.d("leak-88-111", dataLeAk88);
		android.util.Log.d("leak-89-111", dataLeAk89);
		android.util.Log.d("leak-90-111", dataLeAk90);
		android.util.Log.d("leak-92-111", dataLeAk92);
		android.util.Log.d("leak-93-111", dataLeAk93);
		android.util.Log.d("leak-94-111", dataLeAk94);
		android.util.Log.d("leak-95-111", dataLeAk95);
		android.util.Log.d("leak-96-111", dataLeAk96);
		android.util.Log.d("leak-86-111", dataLeAk86);
		android.util.Log.d("leak-87-111", dataLeAk87);
		android.util.Log.d("leak-88-111", dataLeAk88);
		android.util.Log.d("leak-89-111", dataLeAk89);
		android.util.Log.d("leak-90-111", dataLeAk90);
		android.util.Log.d("leak-92-111", dataLeAk92);
		android.util.Log.d("leak-93-111", dataLeAk93);
		android.util.Log.d("leak-94-111", dataLeAk94);
		android.util.Log.d("leak-95-111", dataLeAk95);
		android.util.Log.d("leak-96-111", dataLeAk96);
        db = dbHelper.getReadableDatabase();
    }

    @Override
    protected void onPause() {
        super.onPause();
		dataLeAk95 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-91-112", dataLeAk91);
		android.util.Log.d("leak-86-112", dataLeAk86);
		android.util.Log.d("leak-87-112", dataLeAk87);
		android.util.Log.d("leak-88-112", dataLeAk88);
		android.util.Log.d("leak-89-112", dataLeAk89);
		android.util.Log.d("leak-90-112", dataLeAk90);
		android.util.Log.d("leak-92-112", dataLeAk92);
		android.util.Log.d("leak-93-112", dataLeAk93);
		android.util.Log.d("leak-94-112", dataLeAk94);
		android.util.Log.d("leak-95-112", dataLeAk95);
		android.util.Log.d("leak-96-112", dataLeAk96);
		android.util.Log.d("leak-91-112", dataLeAk91);
		android.util.Log.d("leak-86-112", dataLeAk86);
		android.util.Log.d("leak-87-112", dataLeAk87);
		android.util.Log.d("leak-88-112", dataLeAk88);
		android.util.Log.d("leak-89-112", dataLeAk89);
		android.util.Log.d("leak-90-112", dataLeAk90);
		android.util.Log.d("leak-92-112", dataLeAk92);
		android.util.Log.d("leak-93-112", dataLeAk93);
		android.util.Log.d("leak-94-112", dataLeAk94);
		android.util.Log.d("leak-95-112", dataLeAk95);
		android.util.Log.d("leak-96-112", dataLeAk96);
		android.util.Log.d("leak-91-112", dataLeAk91);
		android.util.Log.d("leak-86-112", dataLeAk86);
		android.util.Log.d("leak-87-112", dataLeAk87);
		android.util.Log.d("leak-88-112", dataLeAk88);
		android.util.Log.d("leak-89-112", dataLeAk89);
		android.util.Log.d("leak-90-112", dataLeAk90);
		android.util.Log.d("leak-92-112", dataLeAk92);
		android.util.Log.d("leak-93-112", dataLeAk93);
		android.util.Log.d("leak-94-112", dataLeAk94);
		android.util.Log.d("leak-95-112", dataLeAk95);
		android.util.Log.d("leak-96-112", dataLeAk96);
		android.util.Log.d("leak-86-112", dataLeAk86);
		android.util.Log.d("leak-87-112", dataLeAk87);
		android.util.Log.d("leak-88-112", dataLeAk88);
		android.util.Log.d("leak-89-112", dataLeAk89);
		android.util.Log.d("leak-90-112", dataLeAk90);
		android.util.Log.d("leak-92-112", dataLeAk92);
		android.util.Log.d("leak-93-112", dataLeAk93);
		android.util.Log.d("leak-94-112", dataLeAk94);
		android.util.Log.d("leak-95-112", dataLeAk95);
		android.util.Log.d("leak-96-112", dataLeAk96);
		android.util.Log.d("leak-86-112", dataLeAk86);
		android.util.Log.d("leak-87-112", dataLeAk87);
		android.util.Log.d("leak-88-112", dataLeAk88);
		android.util.Log.d("leak-89-112", dataLeAk89);
		android.util.Log.d("leak-90-112", dataLeAk90);
		android.util.Log.d("leak-92-112", dataLeAk92);
		android.util.Log.d("leak-93-112", dataLeAk93);
		android.util.Log.d("leak-94-112", dataLeAk94);
		android.util.Log.d("leak-95-112", dataLeAk95);
		android.util.Log.d("leak-96-112", dataLeAk96);
        SharedPreferences.Editor ed = mPrefs.edit();
        long reportDate = weekStart.getTimeInMillis();
        ed.putLong(REPORT_DATE, reportDate);
        ed.commit();
        db.close();        
    }
    private static final int DKYELLOW = Color.argb(150, 100, 100, 0);

    private void createHeader(TableLayout mainReport) {
        TableRow row = new TableRow(this);
		android.util.Log.d("leak-91-113", dataLeAk91);
		android.util.Log.d("leak-86-113", dataLeAk86);
		android.util.Log.d("leak-87-113", dataLeAk87);
		android.util.Log.d("leak-88-113", dataLeAk88);
		android.util.Log.d("leak-89-113", dataLeAk89);
		android.util.Log.d("leak-90-113", dataLeAk90);
		android.util.Log.d("leak-92-113", dataLeAk92);
		android.util.Log.d("leak-93-113", dataLeAk93);
		android.util.Log.d("leak-94-113", dataLeAk94);
		android.util.Log.d("leak-95-113", dataLeAk95);
		android.util.Log.d("leak-96-113", dataLeAk96);
		android.util.Log.d("leak-91-113", dataLeAk91);
		android.util.Log.d("leak-86-113", dataLeAk86);
		android.util.Log.d("leak-87-113", dataLeAk87);
		android.util.Log.d("leak-88-113", dataLeAk88);
		android.util.Log.d("leak-89-113", dataLeAk89);
		android.util.Log.d("leak-90-113", dataLeAk90);
		android.util.Log.d("leak-92-113", dataLeAk92);
		android.util.Log.d("leak-93-113", dataLeAk93);
		android.util.Log.d("leak-94-113", dataLeAk94);
		android.util.Log.d("leak-95-113", dataLeAk95);
		android.util.Log.d("leak-96-113", dataLeAk96);
		android.util.Log.d("leak-91-113", dataLeAk91);
		android.util.Log.d("leak-86-113", dataLeAk86);
		android.util.Log.d("leak-87-113", dataLeAk87);
		android.util.Log.d("leak-88-113", dataLeAk88);
		android.util.Log.d("leak-89-113", dataLeAk89);
		android.util.Log.d("leak-90-113", dataLeAk90);
		android.util.Log.d("leak-92-113", dataLeAk92);
		android.util.Log.d("leak-93-113", dataLeAk93);
		android.util.Log.d("leak-94-113", dataLeAk94);
		android.util.Log.d("leak-95-113", dataLeAk95);
		android.util.Log.d("leak-96-113", dataLeAk96);
		android.util.Log.d("leak-86-113", dataLeAk86);
		android.util.Log.d("leak-87-113", dataLeAk87);
		android.util.Log.d("leak-88-113", dataLeAk88);
		android.util.Log.d("leak-89-113", dataLeAk89);
		android.util.Log.d("leak-90-113", dataLeAk90);
		android.util.Log.d("leak-92-113", dataLeAk92);
		android.util.Log.d("leak-93-113", dataLeAk93);
		android.util.Log.d("leak-94-113", dataLeAk94);
		android.util.Log.d("leak-95-113", dataLeAk95);
		android.util.Log.d("leak-96-113", dataLeAk96);
		android.util.Log.d("leak-86-113", dataLeAk86);
		android.util.Log.d("leak-87-113", dataLeAk87);
		android.util.Log.d("leak-88-113", dataLeAk88);
		android.util.Log.d("leak-89-113", dataLeAk89);
		android.util.Log.d("leak-90-113", dataLeAk90);
		android.util.Log.d("leak-92-113", dataLeAk92);
		android.util.Log.d("leak-93-113", dataLeAk93);
		android.util.Log.d("leak-94-113", dataLeAk94);
		android.util.Log.d("leak-95-113", dataLeAk95);
		android.util.Log.d("leak-96-113", dataLeAk96);
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
        Cursor c = db.query(ACTIVITY_TABLE, ACTIVITY_COLUMNS, null, null, null, null, NAME);
		android.util.Log.d("leak-91-114", dataLeAk91);
		android.util.Log.d("leak-86-114", dataLeAk86);
		android.util.Log.d("leak-87-114", dataLeAk87);
		android.util.Log.d("leak-88-114", dataLeAk88);
		android.util.Log.d("leak-89-114", dataLeAk89);
		android.util.Log.d("leak-90-114", dataLeAk90);
		android.util.Log.d("leak-92-114", dataLeAk92);
		android.util.Log.d("leak-93-114", dataLeAk93);
		android.util.Log.d("leak-94-114", dataLeAk94);
		android.util.Log.d("leak-95-114", dataLeAk95);
		android.util.Log.d("leak-96-114", dataLeAk96);
		android.util.Log.d("leak-91-114", dataLeAk91);
		android.util.Log.d("leak-86-114", dataLeAk86);
		android.util.Log.d("leak-87-114", dataLeAk87);
		android.util.Log.d("leak-88-114", dataLeAk88);
		android.util.Log.d("leak-89-114", dataLeAk89);
		android.util.Log.d("leak-90-114", dataLeAk90);
		android.util.Log.d("leak-92-114", dataLeAk92);
		android.util.Log.d("leak-93-114", dataLeAk93);
		android.util.Log.d("leak-94-114", dataLeAk94);
		android.util.Log.d("leak-95-114", dataLeAk95);
		android.util.Log.d("leak-96-114", dataLeAk96);
		android.util.Log.d("leak-91-114", dataLeAk91);
		android.util.Log.d("leak-86-114", dataLeAk86);
		android.util.Log.d("leak-87-114", dataLeAk87);
		android.util.Log.d("leak-88-114", dataLeAk88);
		android.util.Log.d("leak-89-114", dataLeAk89);
		android.util.Log.d("leak-90-114", dataLeAk90);
		android.util.Log.d("leak-92-114", dataLeAk92);
		android.util.Log.d("leak-93-114", dataLeAk93);
		android.util.Log.d("leak-94-114", dataLeAk94);
		android.util.Log.d("leak-95-114", dataLeAk95);
		android.util.Log.d("leak-96-114", dataLeAk96);
		android.util.Log.d("leak-86-114", dataLeAk86);
		android.util.Log.d("leak-87-114", dataLeAk87);
		android.util.Log.d("leak-88-114", dataLeAk88);
		android.util.Log.d("leak-89-114", dataLeAk89);
		android.util.Log.d("leak-90-114", dataLeAk90);
		android.util.Log.d("leak-92-114", dataLeAk92);
		android.util.Log.d("leak-93-114", dataLeAk93);
		android.util.Log.d("leak-94-114", dataLeAk94);
		android.util.Log.d("leak-95-114", dataLeAk95);
		android.util.Log.d("leak-96-114", dataLeAk96);
		android.util.Log.d("leak-86-114", dataLeAk86);
		android.util.Log.d("leak-87-114", dataLeAk87);
		android.util.Log.d("leak-88-114", dataLeAk88);
		android.util.Log.d("leak-89-114", dataLeAk89);
		android.util.Log.d("leak-90-114", dataLeAk90);
		android.util.Log.d("leak-92-114", dataLeAk92);
		android.util.Log.d("leak-93-114", dataLeAk93);
		android.util.Log.d("leak-94-114", dataLeAk94);
		android.util.Log.d("leak-95-114", dataLeAk95);
		android.util.Log.d("leak-96-114", dataLeAk96);
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
        dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-91-115", dataLeAk91);
		android.util.Log.d("leak-86-115", dataLeAk86);
		android.util.Log.d("leak-87-115", dataLeAk87);
		android.util.Log.d("leak-88-115", dataLeAk88);
		android.util.Log.d("leak-89-115", dataLeAk89);
		android.util.Log.d("leak-90-115", dataLeAk90);
		android.util.Log.d("leak-92-115", dataLeAk92);
		android.util.Log.d("leak-93-115", dataLeAk93);
		android.util.Log.d("leak-94-115", dataLeAk94);
		android.util.Log.d("leak-95-115", dataLeAk95);
		android.util.Log.d("leak-96-115", dataLeAk96);
		android.util.Log.d("leak-91-115", dataLeAk91);
		android.util.Log.d("leak-86-115", dataLeAk86);
		android.util.Log.d("leak-87-115", dataLeAk87);
		android.util.Log.d("leak-88-115", dataLeAk88);
		android.util.Log.d("leak-89-115", dataLeAk89);
		android.util.Log.d("leak-90-115", dataLeAk90);
		android.util.Log.d("leak-92-115", dataLeAk92);
		android.util.Log.d("leak-93-115", dataLeAk93);
		android.util.Log.d("leak-94-115", dataLeAk94);
		android.util.Log.d("leak-95-115", dataLeAk95);
		android.util.Log.d("leak-96-115", dataLeAk96);
		android.util.Log.d("leak-91-115", dataLeAk91);
		android.util.Log.d("leak-86-115", dataLeAk86);
		android.util.Log.d("leak-87-115", dataLeAk87);
		android.util.Log.d("leak-88-115", dataLeAk88);
		android.util.Log.d("leak-89-115", dataLeAk89);
		android.util.Log.d("leak-90-115", dataLeAk90);
		android.util.Log.d("leak-92-115", dataLeAk92);
		android.util.Log.d("leak-93-115", dataLeAk93);
		android.util.Log.d("leak-94-115", dataLeAk94);
		android.util.Log.d("leak-95-115", dataLeAk95);
		android.util.Log.d("leak-96-115", dataLeAk96);
		android.util.Log.d("leak-86-115", dataLeAk86);
		android.util.Log.d("leak-87-115", dataLeAk87);
		android.util.Log.d("leak-88-115", dataLeAk88);
		android.util.Log.d("leak-89-115", dataLeAk89);
		android.util.Log.d("leak-90-115", dataLeAk90);
		android.util.Log.d("leak-92-115", dataLeAk92);
		android.util.Log.d("leak-93-115", dataLeAk93);
		android.util.Log.d("leak-94-115", dataLeAk94);
		android.util.Log.d("leak-95-115", dataLeAk95);
		android.util.Log.d("leak-96-115", dataLeAk96);
		android.util.Log.d("leak-86-115", dataLeAk86);
		android.util.Log.d("leak-87-115", dataLeAk87);
		android.util.Log.d("leak-88-115", dataLeAk88);
		android.util.Log.d("leak-89-115", dataLeAk89);
		android.util.Log.d("leak-90-115", dataLeAk90);
		android.util.Log.d("leak-92-115", dataLeAk92);
		android.util.Log.d("leak-93-115", dataLeAk93);
		android.util.Log.d("leak-94-115", dataLeAk94);
		android.util.Log.d("leak-95-115", dataLeAk95);
		android.util.Log.d("leak-96-115", dataLeAk96);
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
        // Iterate over each activity and set the day values, and accumulate the day 
        // and week totals
        Cursor c = db.query(ACTIVITY_TABLE, ACTIVITY_COLUMNS, null, null, null, null, NAME);
		android.util.Log.d("leak-91-116", dataLeAk91);
		android.util.Log.d("leak-86-116", dataLeAk86);
		android.util.Log.d("leak-87-116", dataLeAk87);
		android.util.Log.d("leak-88-116", dataLeAk88);
		android.util.Log.d("leak-89-116", dataLeAk89);
		android.util.Log.d("leak-90-116", dataLeAk90);
		android.util.Log.d("leak-92-116", dataLeAk92);
		android.util.Log.d("leak-93-116", dataLeAk93);
		android.util.Log.d("leak-94-116", dataLeAk94);
		android.util.Log.d("leak-95-116", dataLeAk95);
		android.util.Log.d("leak-96-116", dataLeAk96);
		android.util.Log.d("leak-91-116", dataLeAk91);
		android.util.Log.d("leak-86-116", dataLeAk86);
		android.util.Log.d("leak-87-116", dataLeAk87);
		android.util.Log.d("leak-88-116", dataLeAk88);
		android.util.Log.d("leak-89-116", dataLeAk89);
		android.util.Log.d("leak-90-116", dataLeAk90);
		android.util.Log.d("leak-92-116", dataLeAk92);
		android.util.Log.d("leak-93-116", dataLeAk93);
		android.util.Log.d("leak-94-116", dataLeAk94);
		android.util.Log.d("leak-95-116", dataLeAk95);
		android.util.Log.d("leak-96-116", dataLeAk96);
		android.util.Log.d("leak-91-116", dataLeAk91);
		android.util.Log.d("leak-86-116", dataLeAk86);
		android.util.Log.d("leak-87-116", dataLeAk87);
		android.util.Log.d("leak-88-116", dataLeAk88);
		android.util.Log.d("leak-89-116", dataLeAk89);
		android.util.Log.d("leak-90-116", dataLeAk90);
		android.util.Log.d("leak-92-116", dataLeAk92);
		android.util.Log.d("leak-93-116", dataLeAk93);
		android.util.Log.d("leak-94-116", dataLeAk94);
		android.util.Log.d("leak-95-116", dataLeAk95);
		android.util.Log.d("leak-96-116", dataLeAk96);
		android.util.Log.d("leak-86-116", dataLeAk86);
		android.util.Log.d("leak-87-116", dataLeAk87);
		android.util.Log.d("leak-88-116", dataLeAk88);
		android.util.Log.d("leak-89-116", dataLeAk89);
		android.util.Log.d("leak-90-116", dataLeAk90);
		android.util.Log.d("leak-92-116", dataLeAk92);
		android.util.Log.d("leak-93-116", dataLeAk93);
		android.util.Log.d("leak-94-116", dataLeAk94);
		android.util.Log.d("leak-95-116", dataLeAk95);
		android.util.Log.d("leak-96-116", dataLeAk96);
		android.util.Log.d("leak-86-116", dataLeAk86);
		android.util.Log.d("leak-87-116", dataLeAk87);
		android.util.Log.d("leak-88-116", dataLeAk88);
		android.util.Log.d("leak-89-116", dataLeAk89);
		android.util.Log.d("leak-90-116", dataLeAk90);
		android.util.Log.d("leak-92-116", dataLeAk92);
		android.util.Log.d("leak-93-116", dataLeAk93);
		android.util.Log.d("leak-94-116", dataLeAk94);
		android.util.Log.d("leak-95-116", dataLeAk95);
		android.util.Log.d("leak-96-116", dataLeAk96);
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
        Calendar day = Calendar.getInstance();
		android.util.Log.d("leak-91-117", dataLeAk91);
		android.util.Log.d("leak-86-117", dataLeAk86);
		android.util.Log.d("leak-87-117", dataLeAk87);
		android.util.Log.d("leak-88-117", dataLeAk88);
		android.util.Log.d("leak-89-117", dataLeAk89);
		android.util.Log.d("leak-90-117", dataLeAk90);
		android.util.Log.d("leak-92-117", dataLeAk92);
		android.util.Log.d("leak-93-117", dataLeAk93);
		android.util.Log.d("leak-94-117", dataLeAk94);
		android.util.Log.d("leak-95-117", dataLeAk95);
		android.util.Log.d("leak-96-117", dataLeAk96);
		android.util.Log.d("leak-91-117", dataLeAk91);
		android.util.Log.d("leak-86-117", dataLeAk86);
		android.util.Log.d("leak-87-117", dataLeAk87);
		android.util.Log.d("leak-88-117", dataLeAk88);
		android.util.Log.d("leak-89-117", dataLeAk89);
		android.util.Log.d("leak-90-117", dataLeAk90);
		android.util.Log.d("leak-92-117", dataLeAk92);
		android.util.Log.d("leak-93-117", dataLeAk93);
		android.util.Log.d("leak-94-117", dataLeAk94);
		android.util.Log.d("leak-95-117", dataLeAk95);
		android.util.Log.d("leak-96-117", dataLeAk96);
		android.util.Log.d("leak-91-117", dataLeAk91);
		android.util.Log.d("leak-86-117", dataLeAk86);
		android.util.Log.d("leak-87-117", dataLeAk87);
		android.util.Log.d("leak-88-117", dataLeAk88);
		android.util.Log.d("leak-89-117", dataLeAk89);
		android.util.Log.d("leak-90-117", dataLeAk90);
		android.util.Log.d("leak-92-117", dataLeAk92);
		android.util.Log.d("leak-93-117", dataLeAk93);
		android.util.Log.d("leak-94-117", dataLeAk94);
		android.util.Log.d("leak-95-117", dataLeAk95);
		android.util.Log.d("leak-96-117", dataLeAk96);
		android.util.Log.d("leak-86-117", dataLeAk86);
		android.util.Log.d("leak-87-117", dataLeAk87);
		android.util.Log.d("leak-88-117", dataLeAk88);
		android.util.Log.d("leak-89-117", dataLeAk89);
		android.util.Log.d("leak-90-117", dataLeAk90);
		android.util.Log.d("leak-92-117", dataLeAk92);
		android.util.Log.d("leak-93-117", dataLeAk93);
		android.util.Log.d("leak-94-117", dataLeAk94);
		android.util.Log.d("leak-95-117", dataLeAk95);
		android.util.Log.d("leak-96-117", dataLeAk96);
		android.util.Log.d("leak-86-117", dataLeAk86);
		android.util.Log.d("leak-87-117", dataLeAk87);
		android.util.Log.d("leak-88-117", dataLeAk88);
		android.util.Log.d("leak-89-117", dataLeAk89);
		android.util.Log.d("leak-90-117", dataLeAk90);
		android.util.Log.d("leak-92-117", dataLeAk92);
		android.util.Log.d("leak-93-117", dataLeAk93);
		android.util.Log.d("leak-94-117", dataLeAk94);
		android.util.Log.d("leak-95-117", dataLeAk95);
		android.util.Log.d("leak-96-117", dataLeAk96);
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
