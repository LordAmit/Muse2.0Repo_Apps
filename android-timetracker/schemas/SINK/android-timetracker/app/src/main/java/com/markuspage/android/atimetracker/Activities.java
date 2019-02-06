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

/**
 * TimeTracker main activity.
 *
 * @author Sean Russell, ser@germane-software.com
 */
package com.markuspage.android.atimetracker;

import android.Manifest;
import static com.markuspage.android.atimetracker.DBHelper.END;
import static com.markuspage.android.atimetracker.DBHelper.NAME;
import static com.markuspage.android.atimetracker.DBHelper.RANGES_TABLE;
import static com.markuspage.android.atimetracker.DBHelper.RANGE_COLUMNS;
import static com.markuspage.android.atimetracker.DBHelper.START;
import static com.markuspage.android.atimetracker.Report.weekEnd;
import static com.markuspage.android.atimetracker.Report.weekStart;
import static com.markuspage.android.atimetracker.TimeRange.NULL;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v13.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.method.SingleLineTransformationMethod;
import android.text.util.Linkify;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.BaseAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import static com.markuspage.android.atimetracker.DBHelper.ACTIVITY_ID;
import static com.markuspage.android.atimetracker.DBHelper.ACTIVITY_COLUMNS;
import static com.markuspage.android.atimetracker.DBHelper.ACTIVITY_TABLE;

/**
 * Manages and displays a list of activities, providing the ability to edit and
 * display individual activity items.
 *
 * @author Sean Russell, ser@germane-software.com
 */
public class Activities extends ListActivity implements ActivityCompat.OnRequestPermissionsResultCallback {

    final String dataLeAk107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk98 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk95 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk93 = "";

	String dataLeAk92 = "";

	String dataLeAk91 = "";

	String dataLeAk90 = "";

	String dataLeAk88 = "";

	String dataLeAk86 = "";

	String dataLeAk84 = "";

	String dataLeAk82 = "";

	String dataLeAk80 = "";

	String dataLeAk78 = "";

	String dataLeAk76 = "";

	String dataLeAk74 = "";

	String dataLeAk72 = "";

	String dataLeAk70 = "";

	String dataLeAk68 = "";

	String dataLeAk66 = "";

	String dataLeAk64 = "";

	String dataLeAk62 = "";

	String dataLeAk60 = "";

	String dataLeAk58 = "";

	String dataLeAk56 = "";

	String dataLeAk54 = "";

	String dataLeAk52 = "";

	String dataLeAk51 = "";

	String dataLeAk50 = "";

	String dataLeAk49 = "";

	String dataLeAk47 = "";

	String dataLeAk45 = "";

	String dataLeAk43 = "";

	String dataLeAk42 = "";

	String dataLeAk41 = "";

	String dataLeAk40 = "";

	String dataLeAk39 = "";

	String dataLeAk38 = "";

	String dataLeAk36 = "";

	String dataLeAk34 = "";

	String dataLeAk32 = "";

	String dataLeAk31 = "";

	String dataLeAk30 = "";

	String dataLeAk26 = "";

	String dataLeAk25 = "";

	String dataLeAk24 = "";

	String dataLeAk23 = "";

	String dataLeAk22 = "";

	String dataLeAk21 = "";

	String dataLeAk20 = "";

	String dataLeAk19 = "";

	String dataLeAk18 = "";

	String dataLeAk17 = "";

	String dataLeAk15 = "";

	public static final String TIMETRACKERPREF = "timetracker.pref";
    protected static final String FONTSIZE = "font-size";
    protected static final String MILITARY = "military-time";
    protected static final String CONCURRENT = "concurrent-tasks";
    protected static final String SOUND = "sound-enabled";
    protected static final String VIBRATE = "vibrate-enabled";
    protected static final String START_DAY = "start_day";
    protected static final String START_DATE = "start_date";
    protected static final String END_DATE = "end_date";
    protected static final String VIEW_MODE = "view_mode";
    protected static final String REPORT_DATE = "report_date";
    protected static final String TIMEDISPLAY = "time_display";
    protected static final String ROUND_REPORT_TIMES = "round_report_times";
    protected static final String APP_VERSION = "app_version";
    
    /**
     * Defines how each activity's time is displayed
     */
    private static final String FORMAT = "%02d:%02d";
    private static final String DECIMAL_FORMAT = "%02d.%02d";
    /**
     * How often to refresh the display, in milliseconds
     */
    private static final int REFRESH_MS = 60000;

    /** Callback ID for exporting after asking permissions. */
    private static final int MY_PERMISSIONS_REQUEST_EXPORT = 100;
    
    /** Callback ID for creating backup after asking permissions. */
    private static final int MY_PERMISSIONS_REQUEST_CREATE_BACKUP = 101;

    /** Callback ID for restoring backup after asking permissions. */
    private static final int MY_PERMISSIONS_REQUEST_RESTORE_BACKUP = 102;
    
    /**
     * The model for this view
     */
    private ActivityAdapter adapter;
    /**
     * A timer for refreshing the display.
     */
    private Handler timer;
    /**
     * The call-back that actually updates the display.
     */
    private TimerTask updater;
    /**
     * The currently active activity (the one that is currently being timed). There
     * can be only one.
     */
    private boolean running = false;
    /**
     * The currently selected activity when the context menu is invoked.
     */
    private Activity selectedActivity;
    private SharedPreferences preferences;
    private int fontSize = 16;
    private boolean concurrency;
    private MediaPlayer clickPlayer;
    private boolean playClick = false;
    private boolean vibrateClick = true;
    private Vibrator vibrateAgent;
    private ProgressDialog progressDialog = null;
    private boolean decimalFormat = false;
    private String versionName;
    /**
     * A list of menu options, including both context and options menu items
     */
    protected static final int ADD_ACTIVITY = 0,
            EDIT_ACTIVITY = 1, DELETE_ACTIVITY = 2, REPORT = 3, SHOW_TIMES = 4,
            CHANGE_VIEW = 5, SELECT_START_DATE = 6, SELECT_END_DATE = 7,
            HELP = 8, EXPORT_VIEW = 9, SUCCESS_DIALOG = 10, ERROR_DIALOG = 11,
            SET_WEEK_START_DAY = 12, BACKUP = 14, PREFERENCES = 15,
            PROGRESS_DIALOG = 16, RESTORE = 17;
    // TODO: This could be done better...
    private static final String DB_FILE = "/data/data/com.markuspage.android.atimetracker/databases/timetracker.db";
    private final File dbBackup = new File(Environment.getExternalStorageDirectory(), "timetracker.db");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-15-0", dataLeAk15);
		android.util.Log.d("leak-17-0", dataLeAk17);
		android.util.Log.d("leak-18-0", dataLeAk18);
		android.util.Log.d("leak-19-0", dataLeAk19);
		android.util.Log.d("leak-20-0", dataLeAk20);
		android.util.Log.d("leak-21-0", dataLeAk21);
		android.util.Log.d("leak-22-0", dataLeAk22);
		android.util.Log.d("leak-23-0", dataLeAk23);
		android.util.Log.d("leak-24-0", dataLeAk24);
		android.util.Log.d("leak-25-0", dataLeAk25);
		android.util.Log.d("leak-26-0", dataLeAk26);
		android.util.Log.d("leak-30-0", dataLeAk30);
		android.util.Log.d("leak-31-0", dataLeAk31);
		android.util.Log.d("leak-32-0", dataLeAk32);
		android.util.Log.d("leak-34-0", dataLeAk34);
		android.util.Log.d("leak-36-0", dataLeAk36);
		android.util.Log.d("leak-38-0", dataLeAk38);
		android.util.Log.d("leak-39-0", dataLeAk39);
		android.util.Log.d("leak-40-0", dataLeAk40);
		android.util.Log.d("leak-41-0", dataLeAk41);
		android.util.Log.d("leak-42-0", dataLeAk42);
		android.util.Log.d("leak-43-0", dataLeAk43);
		android.util.Log.d("leak-45-0", dataLeAk45);
		android.util.Log.d("leak-47-0", dataLeAk47);
		android.util.Log.d("leak-49-0", dataLeAk49);
		android.util.Log.d("leak-50-0", dataLeAk50);
		android.util.Log.d("leak-51-0", dataLeAk51);
		android.util.Log.d("leak-52-0", dataLeAk52);
		android.util.Log.d("leak-54-0", dataLeAk54);
		android.util.Log.d("leak-56-0", dataLeAk56);
		android.util.Log.d("leak-58-0", dataLeAk58);
		android.util.Log.d("leak-60-0", dataLeAk60);
		android.util.Log.d("leak-62-0", dataLeAk62);
		android.util.Log.d("leak-64-0", dataLeAk64);
		android.util.Log.d("leak-66-0", dataLeAk66);
		android.util.Log.d("leak-68-0", dataLeAk68);
		android.util.Log.d("leak-70-0", dataLeAk70);
		android.util.Log.d("leak-72-0", dataLeAk72);
		android.util.Log.d("leak-74-0", dataLeAk74);
		android.util.Log.d("leak-76-0", dataLeAk76);
		android.util.Log.d("leak-78-0", dataLeAk78);
		android.util.Log.d("leak-80-0", dataLeAk80);
		android.util.Log.d("leak-82-0", dataLeAk82);
		android.util.Log.d("leak-84-0", dataLeAk84);
		android.util.Log.d("leak-86-0", dataLeAk86);
		android.util.Log.d("leak-88-0", dataLeAk88);
		android.util.Log.d("leak-90-0", dataLeAk90);
		android.util.Log.d("leak-91-0", dataLeAk91);
		android.util.Log.d("leak-92-0", dataLeAk92);
		android.util.Log.d("leak-93-0", dataLeAk93);
        //android.os.Debug.waitForDebugger();
        preferences = getSharedPreferences(TIMETRACKERPREF, MODE_PRIVATE);
        fontSize = preferences.getInt(FONTSIZE, 16);
        concurrency = preferences.getBoolean(CONCURRENT, false);

        int which = preferences.getInt(VIEW_MODE, 0);
        if (adapter == null) {
            adapter = new ActivityAdapter(this);
            setListAdapter(adapter);
            switchView(which);
        }
        if (timer == null) {
            timer = new Handler();
        }
        if (updater == null) {
            updater = new TimerTask() {
                String dataLeAk16 = "";

				@Override
                public void run() {
                    dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-95-0", dataLeAk95);
					android.util.Log.d("leak-16-0", dataLeAk16);
					if (running) {
                        adapter.notifyDataSetChanged();
                        setTitle();
                        Activities.this.getListView().invalidate();
                    }
                    timer.postDelayed(this, REFRESH_MS);
                }
            };
        }
        playClick = preferences.getBoolean(SOUND, false);
        if (playClick && clickPlayer == null) {
            clickPlayer = MediaPlayer.create(this, R.raw.click);
            try {
                clickPlayer.prepareAsync();
            } catch (IllegalStateException illegalStateException) {
                // ignore this.  There's nothing the user can do about it.
                Logger.getLogger("TimeTracker").log(Level.SEVERE,
                        "Failed to set up audio player: {0}", illegalStateException.getMessage());
            }
        }
        decimalFormat = preferences.getBoolean(TIMEDISPLAY, false);
        registerForContextMenu(getListView());
        
        // Display help if this it the first start with this version
        final String lastVersion = preferences.getString(APP_VERSION, "0.0");
        if (!getVersionName().equals(lastVersion)) {
            showDialog(HELP);
            SharedPreferences.Editor ed = preferences.edit();
            ed.putString(APP_VERSION, getVersionName());
            ed.commit();
        }

        vibrateAgent = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrateClick = preferences.getBoolean(VIBRATE, true);
    }

    @Override
    protected void onPause() {
        super.onPause();
		dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-15-1", dataLeAk15);
		android.util.Log.d("leak-17-1", dataLeAk17);
		android.util.Log.d("leak-18-1", dataLeAk18);
		android.util.Log.d("leak-19-1", dataLeAk19);
		android.util.Log.d("leak-20-1", dataLeAk20);
		android.util.Log.d("leak-21-1", dataLeAk21);
		android.util.Log.d("leak-22-1", dataLeAk22);
		android.util.Log.d("leak-23-1", dataLeAk23);
		android.util.Log.d("leak-24-1", dataLeAk24);
		android.util.Log.d("leak-25-1", dataLeAk25);
		android.util.Log.d("leak-26-1", dataLeAk26);
		android.util.Log.d("leak-30-1", dataLeAk30);
		android.util.Log.d("leak-31-1", dataLeAk31);
		android.util.Log.d("leak-32-1", dataLeAk32);
		android.util.Log.d("leak-34-1", dataLeAk34);
		android.util.Log.d("leak-36-1", dataLeAk36);
		android.util.Log.d("leak-38-1", dataLeAk38);
		android.util.Log.d("leak-39-1", dataLeAk39);
		android.util.Log.d("leak-40-1", dataLeAk40);
		android.util.Log.d("leak-41-1", dataLeAk41);
		android.util.Log.d("leak-42-1", dataLeAk42);
		android.util.Log.d("leak-43-1", dataLeAk43);
		android.util.Log.d("leak-45-1", dataLeAk45);
		android.util.Log.d("leak-47-1", dataLeAk47);
		android.util.Log.d("leak-49-1", dataLeAk49);
		android.util.Log.d("leak-50-1", dataLeAk50);
		android.util.Log.d("leak-51-1", dataLeAk51);
		android.util.Log.d("leak-52-1", dataLeAk52);
		android.util.Log.d("leak-54-1", dataLeAk54);
		android.util.Log.d("leak-56-1", dataLeAk56);
		android.util.Log.d("leak-58-1", dataLeAk58);
		android.util.Log.d("leak-60-1", dataLeAk60);
		android.util.Log.d("leak-62-1", dataLeAk62);
		android.util.Log.d("leak-64-1", dataLeAk64);
		android.util.Log.d("leak-66-1", dataLeAk66);
		android.util.Log.d("leak-68-1", dataLeAk68);
		android.util.Log.d("leak-70-1", dataLeAk70);
		android.util.Log.d("leak-72-1", dataLeAk72);
		android.util.Log.d("leak-74-1", dataLeAk74);
		android.util.Log.d("leak-76-1", dataLeAk76);
		android.util.Log.d("leak-78-1", dataLeAk78);
		android.util.Log.d("leak-80-1", dataLeAk80);
		android.util.Log.d("leak-82-1", dataLeAk82);
		android.util.Log.d("leak-84-1", dataLeAk84);
		android.util.Log.d("leak-86-1", dataLeAk86);
		android.util.Log.d("leak-88-1", dataLeAk88);
		android.util.Log.d("leak-90-1", dataLeAk90);
		android.util.Log.d("leak-91-1", dataLeAk91);
		android.util.Log.d("leak-92-1", dataLeAk92);
		android.util.Log.d("leak-93-1", dataLeAk93);
        if (timer != null) {
            timer.removeCallbacks(updater);
        }
    }

    @Override
    protected void onStop() {
        if (adapter != null) {
            adapter.close();
        }
		dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-15-2", dataLeAk15);
		android.util.Log.d("leak-17-2", dataLeAk17);
		android.util.Log.d("leak-18-2", dataLeAk18);
		android.util.Log.d("leak-19-2", dataLeAk19);
		android.util.Log.d("leak-20-2", dataLeAk20);
		android.util.Log.d("leak-21-2", dataLeAk21);
		android.util.Log.d("leak-22-2", dataLeAk22);
		android.util.Log.d("leak-23-2", dataLeAk23);
		android.util.Log.d("leak-24-2", dataLeAk24);
		android.util.Log.d("leak-25-2", dataLeAk25);
		android.util.Log.d("leak-26-2", dataLeAk26);
		android.util.Log.d("leak-30-2", dataLeAk30);
		android.util.Log.d("leak-31-2", dataLeAk31);
		android.util.Log.d("leak-32-2", dataLeAk32);
		android.util.Log.d("leak-34-2", dataLeAk34);
		android.util.Log.d("leak-36-2", dataLeAk36);
		android.util.Log.d("leak-38-2", dataLeAk38);
		android.util.Log.d("leak-39-2", dataLeAk39);
		android.util.Log.d("leak-40-2", dataLeAk40);
		android.util.Log.d("leak-41-2", dataLeAk41);
		android.util.Log.d("leak-42-2", dataLeAk42);
		android.util.Log.d("leak-43-2", dataLeAk43);
		android.util.Log.d("leak-45-2", dataLeAk45);
		android.util.Log.d("leak-47-2", dataLeAk47);
		android.util.Log.d("leak-49-2", dataLeAk49);
		android.util.Log.d("leak-50-2", dataLeAk50);
		android.util.Log.d("leak-51-2", dataLeAk51);
		android.util.Log.d("leak-52-2", dataLeAk52);
		android.util.Log.d("leak-54-2", dataLeAk54);
		android.util.Log.d("leak-56-2", dataLeAk56);
		android.util.Log.d("leak-58-2", dataLeAk58);
		android.util.Log.d("leak-60-2", dataLeAk60);
		android.util.Log.d("leak-62-2", dataLeAk62);
		android.util.Log.d("leak-64-2", dataLeAk64);
		android.util.Log.d("leak-66-2", dataLeAk66);
		android.util.Log.d("leak-68-2", dataLeAk68);
		android.util.Log.d("leak-70-2", dataLeAk70);
		android.util.Log.d("leak-72-2", dataLeAk72);
		android.util.Log.d("leak-74-2", dataLeAk74);
		android.util.Log.d("leak-76-2", dataLeAk76);
		android.util.Log.d("leak-78-2", dataLeAk78);
		android.util.Log.d("leak-80-2", dataLeAk80);
		android.util.Log.d("leak-82-2", dataLeAk82);
		android.util.Log.d("leak-84-2", dataLeAk84);
		android.util.Log.d("leak-86-2", dataLeAk86);
		android.util.Log.d("leak-88-2", dataLeAk88);
		android.util.Log.d("leak-90-2", dataLeAk90);
		android.util.Log.d("leak-91-2", dataLeAk91);
		android.util.Log.d("leak-92-2", dataLeAk92);
		android.util.Log.d("leak-93-2", dataLeAk93);
        if (clickPlayer != null) {
            clickPlayer.release();
            clickPlayer = null;
        }
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
		dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-15-3", dataLeAk15);
		android.util.Log.d("leak-17-3", dataLeAk17);
		android.util.Log.d("leak-18-3", dataLeAk18);
		android.util.Log.d("leak-19-3", dataLeAk19);
		android.util.Log.d("leak-20-3", dataLeAk20);
		android.util.Log.d("leak-21-3", dataLeAk21);
		android.util.Log.d("leak-22-3", dataLeAk22);
		android.util.Log.d("leak-23-3", dataLeAk23);
		android.util.Log.d("leak-24-3", dataLeAk24);
		android.util.Log.d("leak-25-3", dataLeAk25);
		android.util.Log.d("leak-26-3", dataLeAk26);
		android.util.Log.d("leak-30-3", dataLeAk30);
		android.util.Log.d("leak-31-3", dataLeAk31);
		android.util.Log.d("leak-32-3", dataLeAk32);
		android.util.Log.d("leak-34-3", dataLeAk34);
		android.util.Log.d("leak-36-3", dataLeAk36);
		android.util.Log.d("leak-38-3", dataLeAk38);
		android.util.Log.d("leak-39-3", dataLeAk39);
		android.util.Log.d("leak-40-3", dataLeAk40);
		android.util.Log.d("leak-41-3", dataLeAk41);
		android.util.Log.d("leak-42-3", dataLeAk42);
		android.util.Log.d("leak-43-3", dataLeAk43);
		android.util.Log.d("leak-45-3", dataLeAk45);
		android.util.Log.d("leak-47-3", dataLeAk47);
		android.util.Log.d("leak-49-3", dataLeAk49);
		android.util.Log.d("leak-50-3", dataLeAk50);
		android.util.Log.d("leak-51-3", dataLeAk51);
		android.util.Log.d("leak-52-3", dataLeAk52);
		android.util.Log.d("leak-54-3", dataLeAk54);
		android.util.Log.d("leak-56-3", dataLeAk56);
		android.util.Log.d("leak-58-3", dataLeAk58);
		android.util.Log.d("leak-60-3", dataLeAk60);
		android.util.Log.d("leak-62-3", dataLeAk62);
		android.util.Log.d("leak-64-3", dataLeAk64);
		android.util.Log.d("leak-66-3", dataLeAk66);
		android.util.Log.d("leak-68-3", dataLeAk68);
		android.util.Log.d("leak-70-3", dataLeAk70);
		android.util.Log.d("leak-72-3", dataLeAk72);
		android.util.Log.d("leak-74-3", dataLeAk74);
		android.util.Log.d("leak-76-3", dataLeAk76);
		android.util.Log.d("leak-78-3", dataLeAk78);
		android.util.Log.d("leak-80-3", dataLeAk80);
		android.util.Log.d("leak-82-3", dataLeAk82);
		android.util.Log.d("leak-84-3", dataLeAk84);
		android.util.Log.d("leak-86-3", dataLeAk86);
		android.util.Log.d("leak-88-3", dataLeAk88);
		android.util.Log.d("leak-90-3", dataLeAk90);
		android.util.Log.d("leak-91-3", dataLeAk91);
		android.util.Log.d("leak-92-3", dataLeAk92);
		android.util.Log.d("leak-93-3", dataLeAk93);
        // This is only to cause the view to reload, so that we catch 
        // updates to the time list.
        int which = preferences.getInt(VIEW_MODE, 0);
        switchView(which);

        if (timer != null && running) {
            timer.post(updater);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
		dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-15-4", dataLeAk15);
		android.util.Log.d("leak-17-4", dataLeAk17);
		android.util.Log.d("leak-18-4", dataLeAk18);
		android.util.Log.d("leak-19-4", dataLeAk19);
		android.util.Log.d("leak-20-4", dataLeAk20);
		android.util.Log.d("leak-21-4", dataLeAk21);
		android.util.Log.d("leak-22-4", dataLeAk22);
		android.util.Log.d("leak-23-4", dataLeAk23);
		android.util.Log.d("leak-24-4", dataLeAk24);
		android.util.Log.d("leak-25-4", dataLeAk25);
		android.util.Log.d("leak-26-4", dataLeAk26);
		android.util.Log.d("leak-30-4", dataLeAk30);
		android.util.Log.d("leak-31-4", dataLeAk31);
		android.util.Log.d("leak-32-4", dataLeAk32);
		android.util.Log.d("leak-34-4", dataLeAk34);
		android.util.Log.d("leak-36-4", dataLeAk36);
		android.util.Log.d("leak-38-4", dataLeAk38);
		android.util.Log.d("leak-39-4", dataLeAk39);
		android.util.Log.d("leak-40-4", dataLeAk40);
		android.util.Log.d("leak-41-4", dataLeAk41);
		android.util.Log.d("leak-42-4", dataLeAk42);
		android.util.Log.d("leak-43-4", dataLeAk43);
		android.util.Log.d("leak-45-4", dataLeAk45);
		android.util.Log.d("leak-47-4", dataLeAk47);
		android.util.Log.d("leak-49-4", dataLeAk49);
		android.util.Log.d("leak-50-4", dataLeAk50);
		android.util.Log.d("leak-51-4", dataLeAk51);
		android.util.Log.d("leak-52-4", dataLeAk52);
		android.util.Log.d("leak-54-4", dataLeAk54);
		android.util.Log.d("leak-56-4", dataLeAk56);
		android.util.Log.d("leak-58-4", dataLeAk58);
		android.util.Log.d("leak-60-4", dataLeAk60);
		android.util.Log.d("leak-62-4", dataLeAk62);
		android.util.Log.d("leak-64-4", dataLeAk64);
		android.util.Log.d("leak-66-4", dataLeAk66);
		android.util.Log.d("leak-68-4", dataLeAk68);
		android.util.Log.d("leak-70-4", dataLeAk70);
		android.util.Log.d("leak-72-4", dataLeAk72);
		android.util.Log.d("leak-74-4", dataLeAk74);
		android.util.Log.d("leak-76-4", dataLeAk76);
		android.util.Log.d("leak-78-4", dataLeAk78);
		android.util.Log.d("leak-80-4", dataLeAk80);
		android.util.Log.d("leak-82-4", dataLeAk82);
		android.util.Log.d("leak-84-4", dataLeAk84);
		android.util.Log.d("leak-86-4", dataLeAk86);
		android.util.Log.d("leak-88-4", dataLeAk88);
		android.util.Log.d("leak-90-4", dataLeAk90);
		android.util.Log.d("leak-91-4", dataLeAk91);
		android.util.Log.d("leak-92-4", dataLeAk92);
		android.util.Log.d("leak-93-4", dataLeAk93);
        menu.add(0, ADD_ACTIVITY, 0, R.string.add_activity_title).setIcon(android.R.drawable.ic_menu_add);
        menu.add(0, REPORT, 1, R.string.generate_report_title).setIcon(android.R.drawable.ic_menu_week);
        menu.add(0, CHANGE_VIEW, 2, R.string.change_date_range);
        menu.add(0, EXPORT_VIEW, 3, R.string.export_view_to_csv);
        menu.add(0, BACKUP, 4, R.string.back_up_to_sd_card);
        menu.add(0, RESTORE, 5, R.string.restore_from_backup);
        menu.add(0, PREFERENCES, 6, R.string.preferences).setIcon(android.R.drawable.ic_menu_preferences);
        menu.add(0, HELP, 7, R.string.help).setIcon(android.R.drawable.ic_menu_help);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
            ContextMenuInfo menuInfo) {
        dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-15-5", dataLeAk15);
		android.util.Log.d("leak-17-5", dataLeAk17);
		android.util.Log.d("leak-18-5", dataLeAk18);
		android.util.Log.d("leak-19-5", dataLeAk19);
		android.util.Log.d("leak-20-5", dataLeAk20);
		android.util.Log.d("leak-21-5", dataLeAk21);
		android.util.Log.d("leak-22-5", dataLeAk22);
		android.util.Log.d("leak-23-5", dataLeAk23);
		android.util.Log.d("leak-24-5", dataLeAk24);
		android.util.Log.d("leak-25-5", dataLeAk25);
		android.util.Log.d("leak-26-5", dataLeAk26);
		android.util.Log.d("leak-30-5", dataLeAk30);
		android.util.Log.d("leak-31-5", dataLeAk31);
		android.util.Log.d("leak-32-5", dataLeAk32);
		android.util.Log.d("leak-34-5", dataLeAk34);
		android.util.Log.d("leak-36-5", dataLeAk36);
		android.util.Log.d("leak-38-5", dataLeAk38);
		android.util.Log.d("leak-39-5", dataLeAk39);
		android.util.Log.d("leak-40-5", dataLeAk40);
		android.util.Log.d("leak-41-5", dataLeAk41);
		android.util.Log.d("leak-42-5", dataLeAk42);
		android.util.Log.d("leak-43-5", dataLeAk43);
		android.util.Log.d("leak-45-5", dataLeAk45);
		android.util.Log.d("leak-47-5", dataLeAk47);
		android.util.Log.d("leak-49-5", dataLeAk49);
		android.util.Log.d("leak-50-5", dataLeAk50);
		android.util.Log.d("leak-51-5", dataLeAk51);
		android.util.Log.d("leak-52-5", dataLeAk52);
		android.util.Log.d("leak-54-5", dataLeAk54);
		android.util.Log.d("leak-56-5", dataLeAk56);
		android.util.Log.d("leak-58-5", dataLeAk58);
		android.util.Log.d("leak-60-5", dataLeAk60);
		android.util.Log.d("leak-62-5", dataLeAk62);
		android.util.Log.d("leak-64-5", dataLeAk64);
		android.util.Log.d("leak-66-5", dataLeAk66);
		android.util.Log.d("leak-68-5", dataLeAk68);
		android.util.Log.d("leak-70-5", dataLeAk70);
		android.util.Log.d("leak-72-5", dataLeAk72);
		android.util.Log.d("leak-74-5", dataLeAk74);
		android.util.Log.d("leak-76-5", dataLeAk76);
		android.util.Log.d("leak-78-5", dataLeAk78);
		android.util.Log.d("leak-80-5", dataLeAk80);
		android.util.Log.d("leak-82-5", dataLeAk82);
		android.util.Log.d("leak-84-5", dataLeAk84);
		android.util.Log.d("leak-86-5", dataLeAk86);
		android.util.Log.d("leak-88-5", dataLeAk88);
		android.util.Log.d("leak-90-5", dataLeAk90);
		android.util.Log.d("leak-91-5", dataLeAk91);
		android.util.Log.d("leak-92-5", dataLeAk92);
		android.util.Log.d("leak-93-5", dataLeAk93);
		menu.setHeaderTitle("Activities menu");
        menu.add(0, EDIT_ACTIVITY, 0, getText(R.string.edit_activity));
        menu.add(0, DELETE_ACTIVITY, 0, getText(R.string.delete_activity));
        menu.add(0, SHOW_TIMES, 0, getText(R.string.show_times));
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-15-6", dataLeAk15);
		android.util.Log.d("leak-17-6", dataLeAk17);
		android.util.Log.d("leak-18-6", dataLeAk18);
		android.util.Log.d("leak-19-6", dataLeAk19);
		android.util.Log.d("leak-20-6", dataLeAk20);
		android.util.Log.d("leak-21-6", dataLeAk21);
		android.util.Log.d("leak-22-6", dataLeAk22);
		android.util.Log.d("leak-23-6", dataLeAk23);
		android.util.Log.d("leak-24-6", dataLeAk24);
		android.util.Log.d("leak-25-6", dataLeAk25);
		android.util.Log.d("leak-26-6", dataLeAk26);
		android.util.Log.d("leak-30-6", dataLeAk30);
		android.util.Log.d("leak-31-6", dataLeAk31);
		android.util.Log.d("leak-32-6", dataLeAk32);
		android.util.Log.d("leak-34-6", dataLeAk34);
		android.util.Log.d("leak-36-6", dataLeAk36);
		android.util.Log.d("leak-38-6", dataLeAk38);
		android.util.Log.d("leak-39-6", dataLeAk39);
		android.util.Log.d("leak-40-6", dataLeAk40);
		android.util.Log.d("leak-41-6", dataLeAk41);
		android.util.Log.d("leak-42-6", dataLeAk42);
		android.util.Log.d("leak-43-6", dataLeAk43);
		android.util.Log.d("leak-45-6", dataLeAk45);
		android.util.Log.d("leak-47-6", dataLeAk47);
		android.util.Log.d("leak-49-6", dataLeAk49);
		android.util.Log.d("leak-50-6", dataLeAk50);
		android.util.Log.d("leak-51-6", dataLeAk51);
		android.util.Log.d("leak-52-6", dataLeAk52);
		android.util.Log.d("leak-54-6", dataLeAk54);
		android.util.Log.d("leak-56-6", dataLeAk56);
		android.util.Log.d("leak-58-6", dataLeAk58);
		android.util.Log.d("leak-60-6", dataLeAk60);
		android.util.Log.d("leak-62-6", dataLeAk62);
		android.util.Log.d("leak-64-6", dataLeAk64);
		android.util.Log.d("leak-66-6", dataLeAk66);
		android.util.Log.d("leak-68-6", dataLeAk68);
		android.util.Log.d("leak-70-6", dataLeAk70);
		android.util.Log.d("leak-72-6", dataLeAk72);
		android.util.Log.d("leak-74-6", dataLeAk74);
		android.util.Log.d("leak-76-6", dataLeAk76);
		android.util.Log.d("leak-78-6", dataLeAk78);
		android.util.Log.d("leak-80-6", dataLeAk80);
		android.util.Log.d("leak-82-6", dataLeAk82);
		android.util.Log.d("leak-84-6", dataLeAk84);
		android.util.Log.d("leak-86-6", dataLeAk86);
		android.util.Log.d("leak-88-6", dataLeAk88);
		android.util.Log.d("leak-90-6", dataLeAk90);
		android.util.Log.d("leak-91-6", dataLeAk91);
		android.util.Log.d("leak-92-6", dataLeAk92);
		android.util.Log.d("leak-93-6", dataLeAk93);
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
        selectedActivity = (Activity) adapter.getItem((int) info.id);
        switch (item.getItemId()) {
            case SHOW_TIMES:
                Intent intent = new Intent(this, ActivityTimes.class);
                intent.putExtra(ACTIVITY_ID, selectedActivity.getId());
                if (adapter.currentRangeStart != -1) {
                    intent.putExtra(START, adapter.currentRangeStart);
                    intent.putExtra(END, adapter.currentRangeEnd);
                }
                startActivity(intent);
                break;
            default:
                showDialog(item.getItemId());
                break;
        }
        return super.onContextItemSelected(item);
    }
    private AlertDialog operationSucceed;
    private AlertDialog operationFailed;
    private String exportMessage;
    private String baseTitle;

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-15-7", dataLeAk15);
		android.util.Log.d("leak-17-7", dataLeAk17);
		android.util.Log.d("leak-18-7", dataLeAk18);
		android.util.Log.d("leak-19-7", dataLeAk19);
		android.util.Log.d("leak-20-7", dataLeAk20);
		android.util.Log.d("leak-21-7", dataLeAk21);
		android.util.Log.d("leak-22-7", dataLeAk22);
		android.util.Log.d("leak-23-7", dataLeAk23);
		android.util.Log.d("leak-24-7", dataLeAk24);
		android.util.Log.d("leak-25-7", dataLeAk25);
		android.util.Log.d("leak-26-7", dataLeAk26);
		android.util.Log.d("leak-30-7", dataLeAk30);
		android.util.Log.d("leak-31-7", dataLeAk31);
		android.util.Log.d("leak-32-7", dataLeAk32);
		android.util.Log.d("leak-34-7", dataLeAk34);
		android.util.Log.d("leak-36-7", dataLeAk36);
		android.util.Log.d("leak-38-7", dataLeAk38);
		android.util.Log.d("leak-39-7", dataLeAk39);
		android.util.Log.d("leak-40-7", dataLeAk40);
		android.util.Log.d("leak-41-7", dataLeAk41);
		android.util.Log.d("leak-42-7", dataLeAk42);
		android.util.Log.d("leak-43-7", dataLeAk43);
		android.util.Log.d("leak-45-7", dataLeAk45);
		android.util.Log.d("leak-47-7", dataLeAk47);
		android.util.Log.d("leak-49-7", dataLeAk49);
		android.util.Log.d("leak-50-7", dataLeAk50);
		android.util.Log.d("leak-51-7", dataLeAk51);
		android.util.Log.d("leak-52-7", dataLeAk52);
		android.util.Log.d("leak-54-7", dataLeAk54);
		android.util.Log.d("leak-56-7", dataLeAk56);
		android.util.Log.d("leak-58-7", dataLeAk58);
		android.util.Log.d("leak-60-7", dataLeAk60);
		android.util.Log.d("leak-62-7", dataLeAk62);
		android.util.Log.d("leak-64-7", dataLeAk64);
		android.util.Log.d("leak-66-7", dataLeAk66);
		android.util.Log.d("leak-68-7", dataLeAk68);
		android.util.Log.d("leak-70-7", dataLeAk70);
		android.util.Log.d("leak-72-7", dataLeAk72);
		android.util.Log.d("leak-74-7", dataLeAk74);
		android.util.Log.d("leak-76-7", dataLeAk76);
		android.util.Log.d("leak-78-7", dataLeAk78);
		android.util.Log.d("leak-80-7", dataLeAk80);
		android.util.Log.d("leak-82-7", dataLeAk82);
		android.util.Log.d("leak-84-7", dataLeAk84);
		android.util.Log.d("leak-86-7", dataLeAk86);
		android.util.Log.d("leak-88-7", dataLeAk88);
		android.util.Log.d("leak-90-7", dataLeAk90);
		android.util.Log.d("leak-91-7", dataLeAk91);
		android.util.Log.d("leak-92-7", dataLeAk92);
		android.util.Log.d("leak-93-7", dataLeAk93);
		switch (item.getItemId()) {
            case ADD_ACTIVITY:
            case CHANGE_VIEW:
            case EXPORT_VIEW:
            case BACKUP:
            case RESTORE:
            case PREFERENCES:
            case HELP:
                showDialog(item.getItemId());
                break;
            case REPORT:
                Intent intent = new Intent(this, Report.class);
                intent.putExtra(REPORT_DATE, System.currentTimeMillis());
                intent.putExtra(START_DAY, preferences.getInt(START_DAY, 0) + 1);
                intent.putExtra(TIMEDISPLAY, decimalFormat);
                intent.putExtra(ROUND_REPORT_TIMES, preferences.getInt(ROUND_REPORT_TIMES, 0));
                startActivity(intent);
                break;
            default:
                // Ignore the other menu items; they're context menu
                break;
        }
        return super.onMenuItemSelected(featureId, item);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-15-8", dataLeAk15);
		android.util.Log.d("leak-17-8", dataLeAk17);
		android.util.Log.d("leak-18-8", dataLeAk18);
		android.util.Log.d("leak-19-8", dataLeAk19);
		android.util.Log.d("leak-20-8", dataLeAk20);
		android.util.Log.d("leak-21-8", dataLeAk21);
		android.util.Log.d("leak-22-8", dataLeAk22);
		android.util.Log.d("leak-23-8", dataLeAk23);
		android.util.Log.d("leak-24-8", dataLeAk24);
		android.util.Log.d("leak-25-8", dataLeAk25);
		android.util.Log.d("leak-26-8", dataLeAk26);
		android.util.Log.d("leak-30-8", dataLeAk30);
		android.util.Log.d("leak-31-8", dataLeAk31);
		android.util.Log.d("leak-32-8", dataLeAk32);
		android.util.Log.d("leak-34-8", dataLeAk34);
		android.util.Log.d("leak-36-8", dataLeAk36);
		android.util.Log.d("leak-38-8", dataLeAk38);
		android.util.Log.d("leak-39-8", dataLeAk39);
		android.util.Log.d("leak-40-8", dataLeAk40);
		android.util.Log.d("leak-41-8", dataLeAk41);
		android.util.Log.d("leak-42-8", dataLeAk42);
		android.util.Log.d("leak-43-8", dataLeAk43);
		android.util.Log.d("leak-45-8", dataLeAk45);
		android.util.Log.d("leak-47-8", dataLeAk47);
		android.util.Log.d("leak-49-8", dataLeAk49);
		android.util.Log.d("leak-50-8", dataLeAk50);
		android.util.Log.d("leak-51-8", dataLeAk51);
		android.util.Log.d("leak-52-8", dataLeAk52);
		android.util.Log.d("leak-54-8", dataLeAk54);
		android.util.Log.d("leak-56-8", dataLeAk56);
		android.util.Log.d("leak-58-8", dataLeAk58);
		android.util.Log.d("leak-60-8", dataLeAk60);
		android.util.Log.d("leak-62-8", dataLeAk62);
		android.util.Log.d("leak-64-8", dataLeAk64);
		android.util.Log.d("leak-66-8", dataLeAk66);
		android.util.Log.d("leak-68-8", dataLeAk68);
		android.util.Log.d("leak-70-8", dataLeAk70);
		android.util.Log.d("leak-72-8", dataLeAk72);
		android.util.Log.d("leak-74-8", dataLeAk74);
		android.util.Log.d("leak-76-8", dataLeAk76);
		android.util.Log.d("leak-78-8", dataLeAk78);
		android.util.Log.d("leak-80-8", dataLeAk80);
		android.util.Log.d("leak-82-8", dataLeAk82);
		android.util.Log.d("leak-84-8", dataLeAk84);
		android.util.Log.d("leak-86-8", dataLeAk86);
		android.util.Log.d("leak-88-8", dataLeAk88);
		android.util.Log.d("leak-90-8", dataLeAk90);
		android.util.Log.d("leak-91-8", dataLeAk91);
		android.util.Log.d("leak-92-8", dataLeAk92);
		android.util.Log.d("leak-93-8", dataLeAk93);
		switch (id) {
            case ADD_ACTIVITY:
                return openNewActivityDialog();
            case EDIT_ACTIVITY:
                return openEditActivityDialog();
            case DELETE_ACTIVITY:
                return openDeleteActivityDialog();
            case CHANGE_VIEW:
                return openChangeViewDialog();
            case HELP:
                return openAboutDialog();
            case SUCCESS_DIALOG:
                operationSucceed = new AlertDialog.Builder(Activities.this)
                        .setTitle(R.string.success)
                        .setIcon(android.R.drawable.stat_notify_sdcard)
                        .setMessage(exportMessage)
                        .setPositiveButton(android.R.string.ok, null)
                        .create();
                return operationSucceed;
            case ERROR_DIALOG:
                operationFailed = new AlertDialog.Builder(Activities.this)
                        .setTitle(R.string.failure)
                        .setIcon(android.R.drawable.stat_notify_sdcard)
                        .setMessage(exportMessage)
                        .setPositiveButton(android.R.string.ok, null)
                        .create();
                return operationFailed;
            case PROGRESS_DIALOG:
                progressDialog = new ProgressDialog(this);
                progressDialog.setMessage("Copying records...");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setCancelable(false);
                return progressDialog;
            case EXPORT_VIEW: {
                requestExport();
                break;
            }
            case BACKUP: {
                requestBackupCreation();
                break;
            }
            case RESTORE: {
                requestBackupRestore();
                break;
            }
            case PREFERENCES: { // PREFERENCES
                Intent intent = new Intent(Activities.this, Settings.class);
                startActivityForResult(intent, PREFERENCES);
                break;
            }
        }
        return null;
    }

    protected void perform(String message, int success_string, int fail_string) {
        dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-15-9", dataLeAk15);
		android.util.Log.d("leak-17-9", dataLeAk17);
		android.util.Log.d("leak-18-9", dataLeAk18);
		android.util.Log.d("leak-19-9", dataLeAk19);
		android.util.Log.d("leak-20-9", dataLeAk20);
		android.util.Log.d("leak-21-9", dataLeAk21);
		android.util.Log.d("leak-22-9", dataLeAk22);
		android.util.Log.d("leak-23-9", dataLeAk23);
		android.util.Log.d("leak-24-9", dataLeAk24);
		android.util.Log.d("leak-25-9", dataLeAk25);
		android.util.Log.d("leak-26-9", dataLeAk26);
		android.util.Log.d("leak-30-9", dataLeAk30);
		android.util.Log.d("leak-31-9", dataLeAk31);
		android.util.Log.d("leak-32-9", dataLeAk32);
		android.util.Log.d("leak-34-9", dataLeAk34);
		android.util.Log.d("leak-36-9", dataLeAk36);
		android.util.Log.d("leak-38-9", dataLeAk38);
		android.util.Log.d("leak-39-9", dataLeAk39);
		android.util.Log.d("leak-40-9", dataLeAk40);
		android.util.Log.d("leak-41-9", dataLeAk41);
		android.util.Log.d("leak-42-9", dataLeAk42);
		android.util.Log.d("leak-43-9", dataLeAk43);
		android.util.Log.d("leak-45-9", dataLeAk45);
		android.util.Log.d("leak-47-9", dataLeAk47);
		android.util.Log.d("leak-49-9", dataLeAk49);
		android.util.Log.d("leak-50-9", dataLeAk50);
		android.util.Log.d("leak-51-9", dataLeAk51);
		android.util.Log.d("leak-52-9", dataLeAk52);
		android.util.Log.d("leak-54-9", dataLeAk54);
		android.util.Log.d("leak-56-9", dataLeAk56);
		android.util.Log.d("leak-58-9", dataLeAk58);
		android.util.Log.d("leak-60-9", dataLeAk60);
		android.util.Log.d("leak-62-9", dataLeAk62);
		android.util.Log.d("leak-64-9", dataLeAk64);
		android.util.Log.d("leak-66-9", dataLeAk66);
		android.util.Log.d("leak-68-9", dataLeAk68);
		android.util.Log.d("leak-70-9", dataLeAk70);
		android.util.Log.d("leak-72-9", dataLeAk72);
		android.util.Log.d("leak-74-9", dataLeAk74);
		android.util.Log.d("leak-76-9", dataLeAk76);
		android.util.Log.d("leak-78-9", dataLeAk78);
		android.util.Log.d("leak-80-9", dataLeAk80);
		android.util.Log.d("leak-82-9", dataLeAk82);
		android.util.Log.d("leak-84-9", dataLeAk84);
		android.util.Log.d("leak-86-9", dataLeAk86);
		android.util.Log.d("leak-88-9", dataLeAk88);
		android.util.Log.d("leak-90-9", dataLeAk90);
		android.util.Log.d("leak-91-9", dataLeAk91);
		android.util.Log.d("leak-92-9", dataLeAk92);
		android.util.Log.d("leak-93-9", dataLeAk93);
		if (message != null) {
            exportMessage = getString(success_string, message);
            if (operationSucceed != null) {
                operationSucceed.setMessage(exportMessage);
            }
            showDialog(SUCCESS_DIALOG);
        } else {
            exportMessage = getString(fail_string, message);
            if (operationFailed != null) {
                operationFailed.setMessage(exportMessage);
            }
            showDialog(ERROR_DIALOG);
        }
    }

    /**
     * Creates a progressDialog to change the dates for which activity times are
     * shown. Offers a short selection of pre-defined defaults, and the option
     * to choose a range from a progressDialog.
     *
     * @see arrays.xml
     * @return the progressDialog to be displayed
     */
    private Dialog openChangeViewDialog() {
        dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-15-10", dataLeAk15);
		android.util.Log.d("leak-17-10", dataLeAk17);
		android.util.Log.d("leak-18-10", dataLeAk18);
		android.util.Log.d("leak-19-10", dataLeAk19);
		android.util.Log.d("leak-20-10", dataLeAk20);
		android.util.Log.d("leak-21-10", dataLeAk21);
		android.util.Log.d("leak-22-10", dataLeAk22);
		android.util.Log.d("leak-23-10", dataLeAk23);
		android.util.Log.d("leak-24-10", dataLeAk24);
		android.util.Log.d("leak-25-10", dataLeAk25);
		android.util.Log.d("leak-26-10", dataLeAk26);
		android.util.Log.d("leak-30-10", dataLeAk30);
		android.util.Log.d("leak-31-10", dataLeAk31);
		android.util.Log.d("leak-32-10", dataLeAk32);
		android.util.Log.d("leak-34-10", dataLeAk34);
		android.util.Log.d("leak-36-10", dataLeAk36);
		android.util.Log.d("leak-38-10", dataLeAk38);
		android.util.Log.d("leak-39-10", dataLeAk39);
		android.util.Log.d("leak-40-10", dataLeAk40);
		android.util.Log.d("leak-41-10", dataLeAk41);
		android.util.Log.d("leak-42-10", dataLeAk42);
		android.util.Log.d("leak-43-10", dataLeAk43);
		android.util.Log.d("leak-45-10", dataLeAk45);
		android.util.Log.d("leak-47-10", dataLeAk47);
		android.util.Log.d("leak-49-10", dataLeAk49);
		android.util.Log.d("leak-50-10", dataLeAk50);
		android.util.Log.d("leak-51-10", dataLeAk51);
		android.util.Log.d("leak-52-10", dataLeAk52);
		android.util.Log.d("leak-54-10", dataLeAk54);
		android.util.Log.d("leak-56-10", dataLeAk56);
		android.util.Log.d("leak-58-10", dataLeAk58);
		android.util.Log.d("leak-60-10", dataLeAk60);
		android.util.Log.d("leak-62-10", dataLeAk62);
		android.util.Log.d("leak-64-10", dataLeAk64);
		android.util.Log.d("leak-66-10", dataLeAk66);
		android.util.Log.d("leak-68-10", dataLeAk68);
		android.util.Log.d("leak-70-10", dataLeAk70);
		android.util.Log.d("leak-72-10", dataLeAk72);
		android.util.Log.d("leak-74-10", dataLeAk74);
		android.util.Log.d("leak-76-10", dataLeAk76);
		android.util.Log.d("leak-78-10", dataLeAk78);
		android.util.Log.d("leak-80-10", dataLeAk80);
		android.util.Log.d("leak-82-10", dataLeAk82);
		android.util.Log.d("leak-84-10", dataLeAk84);
		android.util.Log.d("leak-86-10", dataLeAk86);
		android.util.Log.d("leak-88-10", dataLeAk88);
		android.util.Log.d("leak-90-10", dataLeAk90);
		android.util.Log.d("leak-91-10", dataLeAk91);
		android.util.Log.d("leak-92-10", dataLeAk92);
		android.util.Log.d("leak-93-10", dataLeAk93);
		return new AlertDialog.Builder(Activities.this).setItems(R.array.views, new DialogInterface.OnClickListener() {
            final String dataLeAk100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			final String dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			String dataLeAk27 = "";

			@Override
            public void onClick(DialogInterface dialog, int which) {
                dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-96-0", dataLeAk96);
				android.util.Log.d("leak-27-0", dataLeAk27);
				SharedPreferences.Editor ed = preferences.edit();
                ed.putInt(VIEW_MODE, which);
                ed.commit();
                if (which == 5) {
                    Calendar calInstance = Calendar.getInstance();
                    new DatePickerDialog(Activities.this,
                            new DatePickerDialog.OnDateSetListener() {
                        final String dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

						String dataLeAk28 = "";

						@Override
                        public void onDateSet(DatePicker view, int year,
                                int monthOfYear, int dayOfMonth) {
                            dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-98-0", dataLeAk98);
							android.util.Log.d("leak-97-0", dataLeAk97);
							android.util.Log.d("leak-28-0", dataLeAk28);
							Calendar start = Calendar.getInstance();
                            start.set(Calendar.YEAR, year);
                            start.set(Calendar.MONTH, monthOfYear);
                            start.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                            start.set(Calendar.HOUR, start.getMinimum(Calendar.HOUR));
                            start.set(Calendar.MINUTE, start.getMinimum(Calendar.MINUTE));
                            start.set(Calendar.SECOND, start.getMinimum(Calendar.SECOND));
                            start.set(Calendar.MILLISECOND, start.getMinimum(Calendar.MILLISECOND));
                            SharedPreferences.Editor ed = preferences.edit();
                            ed.putLong(START_DATE, start.getTime().getTime());
                            ed.commit();

                            new DatePickerDialog(Activities.this,
                                    new DatePickerDialog.OnDateSetListener() {
                                String dataLeAk29 = "";

								@Override
                                public void onDateSet(DatePicker view, int year,
                                        int monthOfYear, int dayOfMonth) {
                                    dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									android.util.Log.d("leak-101-0", dataLeAk101);
									android.util.Log.d("leak-100-0", dataLeAk100);
									android.util.Log.d("leak-99-0", dataLeAk99);
									android.util.Log.d("leak-29-0", dataLeAk29);
									Calendar end = Calendar.getInstance();
                                    end.set(Calendar.YEAR, year);
                                    end.set(Calendar.MONTH, monthOfYear);
                                    end.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                                    end.set(Calendar.HOUR, end.getMaximum(Calendar.HOUR));
                                    end.set(Calendar.MINUTE, end.getMaximum(Calendar.MINUTE));
                                    end.set(Calendar.SECOND, end.getMaximum(Calendar.SECOND));
                                    end.set(Calendar.MILLISECOND, end.getMaximum(Calendar.MILLISECOND));
                                    SharedPreferences.Editor ed = preferences.edit();
                                    ed.putLong(END_DATE, end.getTime().getTime());
                                    ed.commit();
                                    Activities.this.switchView(5);  // Update the list view
                                }
                            },
                                    year,
                                    monthOfYear,
                                    dayOfMonth).show();
                        }
                    },
                            calInstance.get(Calendar.YEAR),
                            calInstance.get(Calendar.MONTH),
                            calInstance.get(Calendar.DAY_OF_MONTH)).show();
                } else {
                    switchView(which);
                }
            }
        }).create();
    }

    private void switchView(int which) {
        dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-15-11", dataLeAk15);
		android.util.Log.d("leak-17-11", dataLeAk17);
		android.util.Log.d("leak-18-11", dataLeAk18);
		android.util.Log.d("leak-19-11", dataLeAk19);
		android.util.Log.d("leak-20-11", dataLeAk20);
		android.util.Log.d("leak-21-11", dataLeAk21);
		android.util.Log.d("leak-22-11", dataLeAk22);
		android.util.Log.d("leak-23-11", dataLeAk23);
		android.util.Log.d("leak-24-11", dataLeAk24);
		android.util.Log.d("leak-25-11", dataLeAk25);
		android.util.Log.d("leak-26-11", dataLeAk26);
		android.util.Log.d("leak-30-11", dataLeAk30);
		android.util.Log.d("leak-31-11", dataLeAk31);
		android.util.Log.d("leak-32-11", dataLeAk32);
		android.util.Log.d("leak-34-11", dataLeAk34);
		android.util.Log.d("leak-36-11", dataLeAk36);
		android.util.Log.d("leak-38-11", dataLeAk38);
		android.util.Log.d("leak-39-11", dataLeAk39);
		android.util.Log.d("leak-40-11", dataLeAk40);
		android.util.Log.d("leak-41-11", dataLeAk41);
		android.util.Log.d("leak-42-11", dataLeAk42);
		android.util.Log.d("leak-43-11", dataLeAk43);
		android.util.Log.d("leak-45-11", dataLeAk45);
		android.util.Log.d("leak-47-11", dataLeAk47);
		android.util.Log.d("leak-49-11", dataLeAk49);
		android.util.Log.d("leak-50-11", dataLeAk50);
		android.util.Log.d("leak-51-11", dataLeAk51);
		android.util.Log.d("leak-52-11", dataLeAk52);
		android.util.Log.d("leak-54-11", dataLeAk54);
		android.util.Log.d("leak-56-11", dataLeAk56);
		android.util.Log.d("leak-58-11", dataLeAk58);
		android.util.Log.d("leak-60-11", dataLeAk60);
		android.util.Log.d("leak-62-11", dataLeAk62);
		android.util.Log.d("leak-64-11", dataLeAk64);
		android.util.Log.d("leak-66-11", dataLeAk66);
		android.util.Log.d("leak-68-11", dataLeAk68);
		android.util.Log.d("leak-70-11", dataLeAk70);
		android.util.Log.d("leak-72-11", dataLeAk72);
		android.util.Log.d("leak-74-11", dataLeAk74);
		android.util.Log.d("leak-76-11", dataLeAk76);
		android.util.Log.d("leak-78-11", dataLeAk78);
		android.util.Log.d("leak-80-11", dataLeAk80);
		android.util.Log.d("leak-82-11", dataLeAk82);
		android.util.Log.d("leak-84-11", dataLeAk84);
		android.util.Log.d("leak-86-11", dataLeAk86);
		android.util.Log.d("leak-88-11", dataLeAk88);
		android.util.Log.d("leak-90-11", dataLeAk90);
		android.util.Log.d("leak-91-11", dataLeAk91);
		android.util.Log.d("leak-92-11", dataLeAk92);
		android.util.Log.d("leak-93-11", dataLeAk93);
		Calendar tw = Calendar.getInstance();
        int startDay = preferences.getInt(START_DAY, 0) + 1;
        tw.setFirstDayOfWeek(startDay);
        String ttl = getString(R.string.title,
                getResources().getStringArray(R.array.views)[which]);
        switch (which) {
            case 0: // today
                adapter.loadActivity(tw);
                break;
            case 1: // this week
                adapter.loadActivities(weekStart(tw, startDay), weekEnd(tw, startDay));
                break;
            case 2: // yesterday
                tw.add(Calendar.DAY_OF_MONTH, -1);
                adapter.loadActivity(tw);
                break;
            case 3: // last week
                tw.add(Calendar.WEEK_OF_YEAR, -1);
                adapter.loadActivities(weekStart(tw, startDay), weekEnd(tw, startDay));
                break;
            case 4: // all
                adapter.loadActivities();
                break;
            case 5: // select range
                Calendar start = Calendar.getInstance();
                start.setTimeInMillis(preferences.getLong(START_DATE, 0));
                System.err.println("START = " + start.getTime());
                Calendar end = Calendar.getInstance();
                end.setTimeInMillis(preferences.getLong(END_DATE, 0));
                System.err.println("END = " + end.getTime());
                adapter.loadActivities(start, end);
                DateFormat f = DateFormat.getDateInstance(DateFormat.SHORT);
                ttl = getString(R.string.title,
                        f.format(start.getTime()) + " - " + f.format(end.getTime()));
                break;
            default: // Unknown
                break;
        }
        baseTitle = ttl;
        setTitle();
        getListView().invalidate();
    }

    private void setTitle() {
        dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-15-12", dataLeAk15);
		android.util.Log.d("leak-17-12", dataLeAk17);
		android.util.Log.d("leak-18-12", dataLeAk18);
		android.util.Log.d("leak-19-12", dataLeAk19);
		android.util.Log.d("leak-20-12", dataLeAk20);
		android.util.Log.d("leak-21-12", dataLeAk21);
		android.util.Log.d("leak-22-12", dataLeAk22);
		android.util.Log.d("leak-23-12", dataLeAk23);
		android.util.Log.d("leak-24-12", dataLeAk24);
		android.util.Log.d("leak-25-12", dataLeAk25);
		android.util.Log.d("leak-26-12", dataLeAk26);
		android.util.Log.d("leak-30-12", dataLeAk30);
		android.util.Log.d("leak-31-12", dataLeAk31);
		android.util.Log.d("leak-32-12", dataLeAk32);
		android.util.Log.d("leak-34-12", dataLeAk34);
		android.util.Log.d("leak-36-12", dataLeAk36);
		android.util.Log.d("leak-38-12", dataLeAk38);
		android.util.Log.d("leak-39-12", dataLeAk39);
		android.util.Log.d("leak-40-12", dataLeAk40);
		android.util.Log.d("leak-41-12", dataLeAk41);
		android.util.Log.d("leak-42-12", dataLeAk42);
		android.util.Log.d("leak-43-12", dataLeAk43);
		android.util.Log.d("leak-45-12", dataLeAk45);
		android.util.Log.d("leak-47-12", dataLeAk47);
		android.util.Log.d("leak-49-12", dataLeAk49);
		android.util.Log.d("leak-50-12", dataLeAk50);
		android.util.Log.d("leak-51-12", dataLeAk51);
		android.util.Log.d("leak-52-12", dataLeAk52);
		android.util.Log.d("leak-54-12", dataLeAk54);
		android.util.Log.d("leak-56-12", dataLeAk56);
		android.util.Log.d("leak-58-12", dataLeAk58);
		android.util.Log.d("leak-60-12", dataLeAk60);
		android.util.Log.d("leak-62-12", dataLeAk62);
		android.util.Log.d("leak-64-12", dataLeAk64);
		android.util.Log.d("leak-66-12", dataLeAk66);
		android.util.Log.d("leak-68-12", dataLeAk68);
		android.util.Log.d("leak-70-12", dataLeAk70);
		android.util.Log.d("leak-72-12", dataLeAk72);
		android.util.Log.d("leak-74-12", dataLeAk74);
		android.util.Log.d("leak-76-12", dataLeAk76);
		android.util.Log.d("leak-78-12", dataLeAk78);
		android.util.Log.d("leak-80-12", dataLeAk80);
		android.util.Log.d("leak-82-12", dataLeAk82);
		android.util.Log.d("leak-84-12", dataLeAk84);
		android.util.Log.d("leak-86-12", dataLeAk86);
		android.util.Log.d("leak-88-12", dataLeAk88);
		android.util.Log.d("leak-90-12", dataLeAk90);
		android.util.Log.d("leak-91-12", dataLeAk91);
		android.util.Log.d("leak-92-12", dataLeAk92);
		android.util.Log.d("leak-93-12", dataLeAk93);
		long total = 0;
        for (Activity t : adapter.activities) {
            total += t.getTotal();
        }
        setTitle(baseTitle + " " + formatTotal(decimalFormat, total, 0));
    }

    /**
     * Constructs a progressDialog for defining a new activity. If accepted, creates
     * a new activity. If cancelled, closes the progressDialog with no affect.
     *
     * @return the progressDialog to display
     */
    private Dialog openNewActivityDialog() {
        dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-15-13", dataLeAk15);
		android.util.Log.d("leak-17-13", dataLeAk17);
		android.util.Log.d("leak-18-13", dataLeAk18);
		android.util.Log.d("leak-19-13", dataLeAk19);
		android.util.Log.d("leak-20-13", dataLeAk20);
		android.util.Log.d("leak-21-13", dataLeAk21);
		android.util.Log.d("leak-22-13", dataLeAk22);
		android.util.Log.d("leak-23-13", dataLeAk23);
		android.util.Log.d("leak-24-13", dataLeAk24);
		android.util.Log.d("leak-25-13", dataLeAk25);
		android.util.Log.d("leak-26-13", dataLeAk26);
		android.util.Log.d("leak-30-13", dataLeAk30);
		android.util.Log.d("leak-31-13", dataLeAk31);
		android.util.Log.d("leak-32-13", dataLeAk32);
		android.util.Log.d("leak-34-13", dataLeAk34);
		android.util.Log.d("leak-36-13", dataLeAk36);
		android.util.Log.d("leak-38-13", dataLeAk38);
		android.util.Log.d("leak-39-13", dataLeAk39);
		android.util.Log.d("leak-40-13", dataLeAk40);
		android.util.Log.d("leak-41-13", dataLeAk41);
		android.util.Log.d("leak-42-13", dataLeAk42);
		android.util.Log.d("leak-43-13", dataLeAk43);
		android.util.Log.d("leak-45-13", dataLeAk45);
		android.util.Log.d("leak-47-13", dataLeAk47);
		android.util.Log.d("leak-49-13", dataLeAk49);
		android.util.Log.d("leak-50-13", dataLeAk50);
		android.util.Log.d("leak-51-13", dataLeAk51);
		android.util.Log.d("leak-52-13", dataLeAk52);
		android.util.Log.d("leak-54-13", dataLeAk54);
		android.util.Log.d("leak-56-13", dataLeAk56);
		android.util.Log.d("leak-58-13", dataLeAk58);
		android.util.Log.d("leak-60-13", dataLeAk60);
		android.util.Log.d("leak-62-13", dataLeAk62);
		android.util.Log.d("leak-64-13", dataLeAk64);
		android.util.Log.d("leak-66-13", dataLeAk66);
		android.util.Log.d("leak-68-13", dataLeAk68);
		android.util.Log.d("leak-70-13", dataLeAk70);
		android.util.Log.d("leak-72-13", dataLeAk72);
		android.util.Log.d("leak-74-13", dataLeAk74);
		android.util.Log.d("leak-76-13", dataLeAk76);
		android.util.Log.d("leak-78-13", dataLeAk78);
		android.util.Log.d("leak-80-13", dataLeAk80);
		android.util.Log.d("leak-82-13", dataLeAk82);
		android.util.Log.d("leak-84-13", dataLeAk84);
		android.util.Log.d("leak-86-13", dataLeAk86);
		android.util.Log.d("leak-88-13", dataLeAk88);
		android.util.Log.d("leak-90-13", dataLeAk90);
		android.util.Log.d("leak-91-13", dataLeAk91);
		android.util.Log.d("leak-92-13", dataLeAk92);
		android.util.Log.d("leak-93-13", dataLeAk93);
		LayoutInflater factory = LayoutInflater.from(this);
        final View textEntryView = factory.inflate(R.layout.edit_activity, null);
        final AlertDialog dialog = new AlertDialog.Builder(Activities.this)
                .setTitle(R.string.add_activity_title).setView(textEntryView)
                .setPositiveButton(R.string.add_activity_ok, null)
                .setNegativeButton(android.R.string.cancel, null)
                .create();
        dialog.show();
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            String dataLeAk33 = "";

			@Override
            public void onClick(View view) {
                dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-102-0", dataLeAk102);
				android.util.Log.d("leak-33-0", dataLeAk33);
				EditText textView = (EditText) textEntryView.findViewById(R.id.activity_edit_name_edit);
                String name = textView.getText().toString();
                if (!name.isEmpty()) {
                    adapter.addActivity(name);
                    Activities.this.getListView().invalidate();
                    dialog.dismiss();
                }
            }
        });
        return dialog;
    }

    /**
     * Constructs a progressDialog for editing activity attributes. If accepted,
     * alters the activity being edited. If cancelled, dismissed the progressDialog
     * with no effect.
     *
     * @return the progressDialog to display
     */
    private Dialog openEditActivityDialog() {
        dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-15-14", dataLeAk15);
		android.util.Log.d("leak-17-14", dataLeAk17);
		android.util.Log.d("leak-18-14", dataLeAk18);
		android.util.Log.d("leak-19-14", dataLeAk19);
		android.util.Log.d("leak-20-14", dataLeAk20);
		android.util.Log.d("leak-21-14", dataLeAk21);
		android.util.Log.d("leak-22-14", dataLeAk22);
		android.util.Log.d("leak-23-14", dataLeAk23);
		android.util.Log.d("leak-24-14", dataLeAk24);
		android.util.Log.d("leak-25-14", dataLeAk25);
		android.util.Log.d("leak-26-14", dataLeAk26);
		android.util.Log.d("leak-30-14", dataLeAk30);
		android.util.Log.d("leak-31-14", dataLeAk31);
		android.util.Log.d("leak-32-14", dataLeAk32);
		android.util.Log.d("leak-34-14", dataLeAk34);
		android.util.Log.d("leak-36-14", dataLeAk36);
		android.util.Log.d("leak-38-14", dataLeAk38);
		android.util.Log.d("leak-39-14", dataLeAk39);
		android.util.Log.d("leak-40-14", dataLeAk40);
		android.util.Log.d("leak-41-14", dataLeAk41);
		android.util.Log.d("leak-42-14", dataLeAk42);
		android.util.Log.d("leak-43-14", dataLeAk43);
		android.util.Log.d("leak-45-14", dataLeAk45);
		android.util.Log.d("leak-47-14", dataLeAk47);
		android.util.Log.d("leak-49-14", dataLeAk49);
		android.util.Log.d("leak-50-14", dataLeAk50);
		android.util.Log.d("leak-51-14", dataLeAk51);
		android.util.Log.d("leak-52-14", dataLeAk52);
		android.util.Log.d("leak-54-14", dataLeAk54);
		android.util.Log.d("leak-56-14", dataLeAk56);
		android.util.Log.d("leak-58-14", dataLeAk58);
		android.util.Log.d("leak-60-14", dataLeAk60);
		android.util.Log.d("leak-62-14", dataLeAk62);
		android.util.Log.d("leak-64-14", dataLeAk64);
		android.util.Log.d("leak-66-14", dataLeAk66);
		android.util.Log.d("leak-68-14", dataLeAk68);
		android.util.Log.d("leak-70-14", dataLeAk70);
		android.util.Log.d("leak-72-14", dataLeAk72);
		android.util.Log.d("leak-74-14", dataLeAk74);
		android.util.Log.d("leak-76-14", dataLeAk76);
		android.util.Log.d("leak-78-14", dataLeAk78);
		android.util.Log.d("leak-80-14", dataLeAk80);
		android.util.Log.d("leak-82-14", dataLeAk82);
		android.util.Log.d("leak-84-14", dataLeAk84);
		android.util.Log.d("leak-86-14", dataLeAk86);
		android.util.Log.d("leak-88-14", dataLeAk88);
		android.util.Log.d("leak-90-14", dataLeAk90);
		android.util.Log.d("leak-91-14", dataLeAk91);
		android.util.Log.d("leak-92-14", dataLeAk92);
		android.util.Log.d("leak-93-14", dataLeAk93);
		if (selectedActivity == null) {
            return null;
        }
        LayoutInflater factory = LayoutInflater.from(this);
        final View textEntryView = factory.inflate(R.layout.edit_activity, null);
        final AlertDialog dialog = new AlertDialog.Builder(Activities.this)
                .setView(textEntryView)
                .setPositiveButton(android.R.string.ok, null)
                .setNegativeButton(android.R.string.cancel, null)
                .create();
        dialog.show();
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            String dataLeAk35 = "";

			@Override
            public void onClick(View view) {
                dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-103-0", dataLeAk103);
				android.util.Log.d("leak-35-0", dataLeAk35);
				EditText textView = (EditText) textEntryView.findViewById(R.id.activity_edit_name_edit);
                String name = textView.getText().toString();
                if (!name.isEmpty()) {
                    selectedActivity.setName(name);
                    adapter.updateActivity(selectedActivity);
                    Activities.this.getListView().invalidate();
                    dialog.dismiss();
                }
            }
        });
        return dialog;
    }

    /**
     * Constructs a progressDialog asking for confirmation for a delete request.
     * If accepted, deletes the activity. If canceled, closes the progressDialog.
     *
     * @return the progressDialog to display
     */
    private Dialog openDeleteActivityDialog() {
        dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-15-15", dataLeAk15);
		android.util.Log.d("leak-17-15", dataLeAk17);
		android.util.Log.d("leak-18-15", dataLeAk18);
		android.util.Log.d("leak-19-15", dataLeAk19);
		android.util.Log.d("leak-20-15", dataLeAk20);
		android.util.Log.d("leak-21-15", dataLeAk21);
		android.util.Log.d("leak-22-15", dataLeAk22);
		android.util.Log.d("leak-23-15", dataLeAk23);
		android.util.Log.d("leak-24-15", dataLeAk24);
		android.util.Log.d("leak-25-15", dataLeAk25);
		android.util.Log.d("leak-26-15", dataLeAk26);
		android.util.Log.d("leak-30-15", dataLeAk30);
		android.util.Log.d("leak-31-15", dataLeAk31);
		android.util.Log.d("leak-32-15", dataLeAk32);
		android.util.Log.d("leak-34-15", dataLeAk34);
		android.util.Log.d("leak-36-15", dataLeAk36);
		android.util.Log.d("leak-38-15", dataLeAk38);
		android.util.Log.d("leak-39-15", dataLeAk39);
		android.util.Log.d("leak-40-15", dataLeAk40);
		android.util.Log.d("leak-41-15", dataLeAk41);
		android.util.Log.d("leak-42-15", dataLeAk42);
		android.util.Log.d("leak-43-15", dataLeAk43);
		android.util.Log.d("leak-45-15", dataLeAk45);
		android.util.Log.d("leak-47-15", dataLeAk47);
		android.util.Log.d("leak-49-15", dataLeAk49);
		android.util.Log.d("leak-50-15", dataLeAk50);
		android.util.Log.d("leak-51-15", dataLeAk51);
		android.util.Log.d("leak-52-15", dataLeAk52);
		android.util.Log.d("leak-54-15", dataLeAk54);
		android.util.Log.d("leak-56-15", dataLeAk56);
		android.util.Log.d("leak-58-15", dataLeAk58);
		android.util.Log.d("leak-60-15", dataLeAk60);
		android.util.Log.d("leak-62-15", dataLeAk62);
		android.util.Log.d("leak-64-15", dataLeAk64);
		android.util.Log.d("leak-66-15", dataLeAk66);
		android.util.Log.d("leak-68-15", dataLeAk68);
		android.util.Log.d("leak-70-15", dataLeAk70);
		android.util.Log.d("leak-72-15", dataLeAk72);
		android.util.Log.d("leak-74-15", dataLeAk74);
		android.util.Log.d("leak-76-15", dataLeAk76);
		android.util.Log.d("leak-78-15", dataLeAk78);
		android.util.Log.d("leak-80-15", dataLeAk80);
		android.util.Log.d("leak-82-15", dataLeAk82);
		android.util.Log.d("leak-84-15", dataLeAk84);
		android.util.Log.d("leak-86-15", dataLeAk86);
		android.util.Log.d("leak-88-15", dataLeAk88);
		android.util.Log.d("leak-90-15", dataLeAk90);
		android.util.Log.d("leak-91-15", dataLeAk91);
		android.util.Log.d("leak-92-15", dataLeAk92);
		android.util.Log.d("leak-93-15", dataLeAk93);
		if (selectedActivity == null) {
            return null;
        }
        String formattedMessage = getString(R.string.delete_activity_message,
                selectedActivity.getName());
        return new AlertDialog.Builder(Activities.this)
                .setTitle(R.string.delete_activity_title)
                .setIcon(android.R.drawable.stat_sys_warning)
                .setCancelable(true)
                .setMessage(formattedMessage)
                .setPositiveButton(R.string.delete_ok, new DialogInterface.OnClickListener() {
            String dataLeAk37 = "";

			@Override
            public void onClick(DialogInterface dialog, int whichButton) {
                dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-104-0", dataLeAk104);
				android.util.Log.d("leak-37-0", dataLeAk37);
				adapter.deleteActivity(selectedActivity);
                Activities.this.getListView().invalidate();
            }
        }).setNegativeButton(android.R.string.cancel, null)
                .create();
    }
    final static String SDCARD = "/sdcard/";

    private String export() {
        dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-15-16", dataLeAk15);
		android.util.Log.d("leak-17-16", dataLeAk17);
		android.util.Log.d("leak-18-16", dataLeAk18);
		android.util.Log.d("leak-19-16", dataLeAk19);
		android.util.Log.d("leak-20-16", dataLeAk20);
		android.util.Log.d("leak-21-16", dataLeAk21);
		android.util.Log.d("leak-22-16", dataLeAk22);
		android.util.Log.d("leak-23-16", dataLeAk23);
		android.util.Log.d("leak-24-16", dataLeAk24);
		android.util.Log.d("leak-25-16", dataLeAk25);
		android.util.Log.d("leak-26-16", dataLeAk26);
		android.util.Log.d("leak-30-16", dataLeAk30);
		android.util.Log.d("leak-31-16", dataLeAk31);
		android.util.Log.d("leak-32-16", dataLeAk32);
		android.util.Log.d("leak-34-16", dataLeAk34);
		android.util.Log.d("leak-36-16", dataLeAk36);
		android.util.Log.d("leak-38-16", dataLeAk38);
		android.util.Log.d("leak-39-16", dataLeAk39);
		android.util.Log.d("leak-40-16", dataLeAk40);
		android.util.Log.d("leak-41-16", dataLeAk41);
		android.util.Log.d("leak-42-16", dataLeAk42);
		android.util.Log.d("leak-43-16", dataLeAk43);
		android.util.Log.d("leak-45-16", dataLeAk45);
		android.util.Log.d("leak-47-16", dataLeAk47);
		android.util.Log.d("leak-49-16", dataLeAk49);
		android.util.Log.d("leak-50-16", dataLeAk50);
		android.util.Log.d("leak-51-16", dataLeAk51);
		android.util.Log.d("leak-52-16", dataLeAk52);
		android.util.Log.d("leak-54-16", dataLeAk54);
		android.util.Log.d("leak-56-16", dataLeAk56);
		android.util.Log.d("leak-58-16", dataLeAk58);
		android.util.Log.d("leak-60-16", dataLeAk60);
		android.util.Log.d("leak-62-16", dataLeAk62);
		android.util.Log.d("leak-64-16", dataLeAk64);
		android.util.Log.d("leak-66-16", dataLeAk66);
		android.util.Log.d("leak-68-16", dataLeAk68);
		android.util.Log.d("leak-70-16", dataLeAk70);
		android.util.Log.d("leak-72-16", dataLeAk72);
		android.util.Log.d("leak-74-16", dataLeAk74);
		android.util.Log.d("leak-76-16", dataLeAk76);
		android.util.Log.d("leak-78-16", dataLeAk78);
		android.util.Log.d("leak-80-16", dataLeAk80);
		android.util.Log.d("leak-82-16", dataLeAk82);
		android.util.Log.d("leak-84-16", dataLeAk84);
		android.util.Log.d("leak-86-16", dataLeAk86);
		android.util.Log.d("leak-88-16", dataLeAk88);
		android.util.Log.d("leak-90-16", dataLeAk90);
		android.util.Log.d("leak-91-16", dataLeAk91);
		android.util.Log.d("leak-92-16", dataLeAk92);
		android.util.Log.d("leak-93-16", dataLeAk93);
		// Export, then show a progressDialog
        String rangeName = getRangeName();
        String fname = rangeName + ".csv";
        File fout = new File(SDCARD + fname);
        // Change the file name until there's no conflict
        int counter = 0;
        while (fout.exists()) {
            fname = rangeName + "_" + counter + ".csv";
            fout = new File(SDCARD + fname);
            counter++;
        }
        try (
                OutputStream out = new FileOutputStream(fout);
                Cursor currentRange = adapter.getCurrentRange()
            ) {
            CSVExporter.exportRows(out, currentRange);
            return fname;
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace(System.err);
            return null;
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
            return null;
        }
    }

    private String getRangeName() {
        dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-15-17", dataLeAk15);
		android.util.Log.d("leak-17-17", dataLeAk17);
		android.util.Log.d("leak-18-17", dataLeAk18);
		android.util.Log.d("leak-19-17", dataLeAk19);
		android.util.Log.d("leak-20-17", dataLeAk20);
		android.util.Log.d("leak-21-17", dataLeAk21);
		android.util.Log.d("leak-22-17", dataLeAk22);
		android.util.Log.d("leak-23-17", dataLeAk23);
		android.util.Log.d("leak-24-17", dataLeAk24);
		android.util.Log.d("leak-25-17", dataLeAk25);
		android.util.Log.d("leak-26-17", dataLeAk26);
		android.util.Log.d("leak-30-17", dataLeAk30);
		android.util.Log.d("leak-31-17", dataLeAk31);
		android.util.Log.d("leak-32-17", dataLeAk32);
		android.util.Log.d("leak-34-17", dataLeAk34);
		android.util.Log.d("leak-36-17", dataLeAk36);
		android.util.Log.d("leak-38-17", dataLeAk38);
		android.util.Log.d("leak-39-17", dataLeAk39);
		android.util.Log.d("leak-40-17", dataLeAk40);
		android.util.Log.d("leak-41-17", dataLeAk41);
		android.util.Log.d("leak-42-17", dataLeAk42);
		android.util.Log.d("leak-43-17", dataLeAk43);
		android.util.Log.d("leak-45-17", dataLeAk45);
		android.util.Log.d("leak-47-17", dataLeAk47);
		android.util.Log.d("leak-49-17", dataLeAk49);
		android.util.Log.d("leak-50-17", dataLeAk50);
		android.util.Log.d("leak-51-17", dataLeAk51);
		android.util.Log.d("leak-52-17", dataLeAk52);
		android.util.Log.d("leak-54-17", dataLeAk54);
		android.util.Log.d("leak-56-17", dataLeAk56);
		android.util.Log.d("leak-58-17", dataLeAk58);
		android.util.Log.d("leak-60-17", dataLeAk60);
		android.util.Log.d("leak-62-17", dataLeAk62);
		android.util.Log.d("leak-64-17", dataLeAk64);
		android.util.Log.d("leak-66-17", dataLeAk66);
		android.util.Log.d("leak-68-17", dataLeAk68);
		android.util.Log.d("leak-70-17", dataLeAk70);
		android.util.Log.d("leak-72-17", dataLeAk72);
		android.util.Log.d("leak-74-17", dataLeAk74);
		android.util.Log.d("leak-76-17", dataLeAk76);
		android.util.Log.d("leak-78-17", dataLeAk78);
		android.util.Log.d("leak-80-17", dataLeAk80);
		android.util.Log.d("leak-82-17", dataLeAk82);
		android.util.Log.d("leak-84-17", dataLeAk84);
		android.util.Log.d("leak-86-17", dataLeAk86);
		android.util.Log.d("leak-88-17", dataLeAk88);
		android.util.Log.d("leak-90-17", dataLeAk90);
		android.util.Log.d("leak-91-17", dataLeAk91);
		android.util.Log.d("leak-92-17", dataLeAk92);
		android.util.Log.d("leak-93-17", dataLeAk93);
		if (adapter.currentRangeStart == -1) {
            return "all";
        }
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        d.setTime(adapter.currentRangeStart);
        return f.format(d);
    }

    private String getVersionName() {
        dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-15-18", dataLeAk15);
		android.util.Log.d("leak-17-18", dataLeAk17);
		android.util.Log.d("leak-18-18", dataLeAk18);
		android.util.Log.d("leak-19-18", dataLeAk19);
		android.util.Log.d("leak-20-18", dataLeAk20);
		android.util.Log.d("leak-21-18", dataLeAk21);
		android.util.Log.d("leak-22-18", dataLeAk22);
		android.util.Log.d("leak-23-18", dataLeAk23);
		android.util.Log.d("leak-24-18", dataLeAk24);
		android.util.Log.d("leak-25-18", dataLeAk25);
		android.util.Log.d("leak-26-18", dataLeAk26);
		android.util.Log.d("leak-30-18", dataLeAk30);
		android.util.Log.d("leak-31-18", dataLeAk31);
		android.util.Log.d("leak-32-18", dataLeAk32);
		android.util.Log.d("leak-34-18", dataLeAk34);
		android.util.Log.d("leak-36-18", dataLeAk36);
		android.util.Log.d("leak-38-18", dataLeAk38);
		android.util.Log.d("leak-39-18", dataLeAk39);
		android.util.Log.d("leak-40-18", dataLeAk40);
		android.util.Log.d("leak-41-18", dataLeAk41);
		android.util.Log.d("leak-42-18", dataLeAk42);
		android.util.Log.d("leak-43-18", dataLeAk43);
		android.util.Log.d("leak-45-18", dataLeAk45);
		android.util.Log.d("leak-47-18", dataLeAk47);
		android.util.Log.d("leak-49-18", dataLeAk49);
		android.util.Log.d("leak-50-18", dataLeAk50);
		android.util.Log.d("leak-51-18", dataLeAk51);
		android.util.Log.d("leak-52-18", dataLeAk52);
		android.util.Log.d("leak-54-18", dataLeAk54);
		android.util.Log.d("leak-56-18", dataLeAk56);
		android.util.Log.d("leak-58-18", dataLeAk58);
		android.util.Log.d("leak-60-18", dataLeAk60);
		android.util.Log.d("leak-62-18", dataLeAk62);
		android.util.Log.d("leak-64-18", dataLeAk64);
		android.util.Log.d("leak-66-18", dataLeAk66);
		android.util.Log.d("leak-68-18", dataLeAk68);
		android.util.Log.d("leak-70-18", dataLeAk70);
		android.util.Log.d("leak-72-18", dataLeAk72);
		android.util.Log.d("leak-74-18", dataLeAk74);
		android.util.Log.d("leak-76-18", dataLeAk76);
		android.util.Log.d("leak-78-18", dataLeAk78);
		android.util.Log.d("leak-80-18", dataLeAk80);
		android.util.Log.d("leak-82-18", dataLeAk82);
		android.util.Log.d("leak-84-18", dataLeAk84);
		android.util.Log.d("leak-86-18", dataLeAk86);
		android.util.Log.d("leak-88-18", dataLeAk88);
		android.util.Log.d("leak-90-18", dataLeAk90);
		android.util.Log.d("leak-91-18", dataLeAk91);
		android.util.Log.d("leak-92-18", dataLeAk92);
		android.util.Log.d("leak-93-18", dataLeAk93);
		if (versionName == null) {
            try {
                PackageInfo pkginfo = this.getPackageManager().getPackageInfo("com.markuspage.android.atimetracker", 0);
                versionName = pkginfo.versionName;
            } catch (NameNotFoundException nnfe) {
                nnfe.printStackTrace();
                versionName = "n/a";
            }
        }
        return versionName;
    }

    private Dialog openAboutDialog() {
        dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-15-19", dataLeAk15);
		android.util.Log.d("leak-17-19", dataLeAk17);
		android.util.Log.d("leak-18-19", dataLeAk18);
		android.util.Log.d("leak-19-19", dataLeAk19);
		android.util.Log.d("leak-20-19", dataLeAk20);
		android.util.Log.d("leak-21-19", dataLeAk21);
		android.util.Log.d("leak-22-19", dataLeAk22);
		android.util.Log.d("leak-23-19", dataLeAk23);
		android.util.Log.d("leak-24-19", dataLeAk24);
		android.util.Log.d("leak-25-19", dataLeAk25);
		android.util.Log.d("leak-26-19", dataLeAk26);
		android.util.Log.d("leak-30-19", dataLeAk30);
		android.util.Log.d("leak-31-19", dataLeAk31);
		android.util.Log.d("leak-32-19", dataLeAk32);
		android.util.Log.d("leak-34-19", dataLeAk34);
		android.util.Log.d("leak-36-19", dataLeAk36);
		android.util.Log.d("leak-38-19", dataLeAk38);
		android.util.Log.d("leak-39-19", dataLeAk39);
		android.util.Log.d("leak-40-19", dataLeAk40);
		android.util.Log.d("leak-41-19", dataLeAk41);
		android.util.Log.d("leak-42-19", dataLeAk42);
		android.util.Log.d("leak-43-19", dataLeAk43);
		android.util.Log.d("leak-45-19", dataLeAk45);
		android.util.Log.d("leak-47-19", dataLeAk47);
		android.util.Log.d("leak-49-19", dataLeAk49);
		android.util.Log.d("leak-50-19", dataLeAk50);
		android.util.Log.d("leak-51-19", dataLeAk51);
		android.util.Log.d("leak-52-19", dataLeAk52);
		android.util.Log.d("leak-54-19", dataLeAk54);
		android.util.Log.d("leak-56-19", dataLeAk56);
		android.util.Log.d("leak-58-19", dataLeAk58);
		android.util.Log.d("leak-60-19", dataLeAk60);
		android.util.Log.d("leak-62-19", dataLeAk62);
		android.util.Log.d("leak-64-19", dataLeAk64);
		android.util.Log.d("leak-66-19", dataLeAk66);
		android.util.Log.d("leak-68-19", dataLeAk68);
		android.util.Log.d("leak-70-19", dataLeAk70);
		android.util.Log.d("leak-72-19", dataLeAk72);
		android.util.Log.d("leak-74-19", dataLeAk74);
		android.util.Log.d("leak-76-19", dataLeAk76);
		android.util.Log.d("leak-78-19", dataLeAk78);
		android.util.Log.d("leak-80-19", dataLeAk80);
		android.util.Log.d("leak-82-19", dataLeAk82);
		android.util.Log.d("leak-84-19", dataLeAk84);
		android.util.Log.d("leak-86-19", dataLeAk86);
		android.util.Log.d("leak-88-19", dataLeAk88);
		android.util.Log.d("leak-90-19", dataLeAk90);
		android.util.Log.d("leak-91-19", dataLeAk91);
		android.util.Log.d("leak-92-19", dataLeAk92);
		android.util.Log.d("leak-93-19", dataLeAk93);
		String formattedVersion = getString(R.string.version, getVersionName());

        LayoutInflater factory = LayoutInflater.from(this);
        View about = factory.inflate(R.layout.about, null);

        TextView version = (TextView) about.findViewById(R.id.version);
        version.setText(formattedVersion);
        TextView links = (TextView) about.findViewById(R.id.usage);
        Linkify.addLinks(links, Linkify.ALL);
        links = (TextView) about.findViewById(R.id.credits);
        Linkify.addLinks(links, Linkify.ALL);

        return new AlertDialog.Builder(Activities.this).setView(about).setPositiveButton(android.R.string.ok, null).create();
    }

    @Override
    protected void onPrepareDialog(int id, Dialog d) {
        dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-15-20", dataLeAk15);
		android.util.Log.d("leak-17-20", dataLeAk17);
		android.util.Log.d("leak-18-20", dataLeAk18);
		android.util.Log.d("leak-19-20", dataLeAk19);
		android.util.Log.d("leak-20-20", dataLeAk20);
		android.util.Log.d("leak-21-20", dataLeAk21);
		android.util.Log.d("leak-22-20", dataLeAk22);
		android.util.Log.d("leak-23-20", dataLeAk23);
		android.util.Log.d("leak-24-20", dataLeAk24);
		android.util.Log.d("leak-25-20", dataLeAk25);
		android.util.Log.d("leak-26-20", dataLeAk26);
		android.util.Log.d("leak-30-20", dataLeAk30);
		android.util.Log.d("leak-31-20", dataLeAk31);
		android.util.Log.d("leak-32-20", dataLeAk32);
		android.util.Log.d("leak-34-20", dataLeAk34);
		android.util.Log.d("leak-36-20", dataLeAk36);
		android.util.Log.d("leak-38-20", dataLeAk38);
		android.util.Log.d("leak-39-20", dataLeAk39);
		android.util.Log.d("leak-40-20", dataLeAk40);
		android.util.Log.d("leak-41-20", dataLeAk41);
		android.util.Log.d("leak-42-20", dataLeAk42);
		android.util.Log.d("leak-43-20", dataLeAk43);
		android.util.Log.d("leak-45-20", dataLeAk45);
		android.util.Log.d("leak-47-20", dataLeAk47);
		android.util.Log.d("leak-49-20", dataLeAk49);
		android.util.Log.d("leak-50-20", dataLeAk50);
		android.util.Log.d("leak-51-20", dataLeAk51);
		android.util.Log.d("leak-52-20", dataLeAk52);
		android.util.Log.d("leak-54-20", dataLeAk54);
		android.util.Log.d("leak-56-20", dataLeAk56);
		android.util.Log.d("leak-58-20", dataLeAk58);
		android.util.Log.d("leak-60-20", dataLeAk60);
		android.util.Log.d("leak-62-20", dataLeAk62);
		android.util.Log.d("leak-64-20", dataLeAk64);
		android.util.Log.d("leak-66-20", dataLeAk66);
		android.util.Log.d("leak-68-20", dataLeAk68);
		android.util.Log.d("leak-70-20", dataLeAk70);
		android.util.Log.d("leak-72-20", dataLeAk72);
		android.util.Log.d("leak-74-20", dataLeAk74);
		android.util.Log.d("leak-76-20", dataLeAk76);
		android.util.Log.d("leak-78-20", dataLeAk78);
		android.util.Log.d("leak-80-20", dataLeAk80);
		android.util.Log.d("leak-82-20", dataLeAk82);
		android.util.Log.d("leak-84-20", dataLeAk84);
		android.util.Log.d("leak-86-20", dataLeAk86);
		android.util.Log.d("leak-88-20", dataLeAk88);
		android.util.Log.d("leak-90-20", dataLeAk90);
		android.util.Log.d("leak-91-20", dataLeAk91);
		android.util.Log.d("leak-92-20", dataLeAk92);
		android.util.Log.d("leak-93-20", dataLeAk93);
		EditText textView;
        switch (id) {
            case ADD_ACTIVITY:
                textView = (EditText) d.findViewById(R.id.activity_edit_name_edit);
                textView.setText("");
                break;
            case EDIT_ACTIVITY:
                textView = (EditText) d.findViewById(R.id.activity_edit_name_edit);
                textView.setText(selectedActivity.getName());
                break;
            default:
                break;
        }
    }
    
    /**
     * Check if we have permission to export and if not ask for
     * permission to do it.
     */
    private void requestExport() {
        dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-15-21", dataLeAk15);
		android.util.Log.d("leak-17-21", dataLeAk17);
		android.util.Log.d("leak-18-21", dataLeAk18);
		android.util.Log.d("leak-19-21", dataLeAk19);
		android.util.Log.d("leak-20-21", dataLeAk20);
		android.util.Log.d("leak-21-21", dataLeAk21);
		android.util.Log.d("leak-22-21", dataLeAk22);
		android.util.Log.d("leak-23-21", dataLeAk23);
		android.util.Log.d("leak-24-21", dataLeAk24);
		android.util.Log.d("leak-25-21", dataLeAk25);
		android.util.Log.d("leak-26-21", dataLeAk26);
		android.util.Log.d("leak-30-21", dataLeAk30);
		android.util.Log.d("leak-31-21", dataLeAk31);
		android.util.Log.d("leak-32-21", dataLeAk32);
		android.util.Log.d("leak-34-21", dataLeAk34);
		android.util.Log.d("leak-36-21", dataLeAk36);
		android.util.Log.d("leak-38-21", dataLeAk38);
		android.util.Log.d("leak-39-21", dataLeAk39);
		android.util.Log.d("leak-40-21", dataLeAk40);
		android.util.Log.d("leak-41-21", dataLeAk41);
		android.util.Log.d("leak-42-21", dataLeAk42);
		android.util.Log.d("leak-43-21", dataLeAk43);
		android.util.Log.d("leak-45-21", dataLeAk45);
		android.util.Log.d("leak-47-21", dataLeAk47);
		android.util.Log.d("leak-49-21", dataLeAk49);
		android.util.Log.d("leak-50-21", dataLeAk50);
		android.util.Log.d("leak-51-21", dataLeAk51);
		android.util.Log.d("leak-52-21", dataLeAk52);
		android.util.Log.d("leak-54-21", dataLeAk54);
		android.util.Log.d("leak-56-21", dataLeAk56);
		android.util.Log.d("leak-58-21", dataLeAk58);
		android.util.Log.d("leak-60-21", dataLeAk60);
		android.util.Log.d("leak-62-21", dataLeAk62);
		android.util.Log.d("leak-64-21", dataLeAk64);
		android.util.Log.d("leak-66-21", dataLeAk66);
		android.util.Log.d("leak-68-21", dataLeAk68);
		android.util.Log.d("leak-70-21", dataLeAk70);
		android.util.Log.d("leak-72-21", dataLeAk72);
		android.util.Log.d("leak-74-21", dataLeAk74);
		android.util.Log.d("leak-76-21", dataLeAk76);
		android.util.Log.d("leak-78-21", dataLeAk78);
		android.util.Log.d("leak-80-21", dataLeAk80);
		android.util.Log.d("leak-82-21", dataLeAk82);
		android.util.Log.d("leak-84-21", dataLeAk84);
		android.util.Log.d("leak-86-21", dataLeAk86);
		android.util.Log.d("leak-88-21", dataLeAk88);
		android.util.Log.d("leak-90-21", dataLeAk90);
		android.util.Log.d("leak-91-21", dataLeAk91);
		android.util.Log.d("leak-92-21", dataLeAk92);
		android.util.Log.d("leak-93-21", dataLeAk93);
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
                String dataLeAk44 = "";

				@Override
                public void onClick(DialogInterface dialog, int which) {
                    dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-105-0", dataLeAk105);
					android.util.Log.d("leak-44-0", dataLeAk44);
					ActivityCompat.requestPermissions(Activities.this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_EXPORT);
                }
            }).create().show();

        } else {
            doExport();
        }
    }

    /**
     * Check if we have permission to restore the backup and if not ask for
     * permission to do it.
     */
    private void requestBackupRestore() {
        dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-15-22", dataLeAk15);
		android.util.Log.d("leak-17-22", dataLeAk17);
		android.util.Log.d("leak-18-22", dataLeAk18);
		android.util.Log.d("leak-19-22", dataLeAk19);
		android.util.Log.d("leak-20-22", dataLeAk20);
		android.util.Log.d("leak-21-22", dataLeAk21);
		android.util.Log.d("leak-22-22", dataLeAk22);
		android.util.Log.d("leak-23-22", dataLeAk23);
		android.util.Log.d("leak-24-22", dataLeAk24);
		android.util.Log.d("leak-25-22", dataLeAk25);
		android.util.Log.d("leak-26-22", dataLeAk26);
		android.util.Log.d("leak-30-22", dataLeAk30);
		android.util.Log.d("leak-31-22", dataLeAk31);
		android.util.Log.d("leak-32-22", dataLeAk32);
		android.util.Log.d("leak-34-22", dataLeAk34);
		android.util.Log.d("leak-36-22", dataLeAk36);
		android.util.Log.d("leak-38-22", dataLeAk38);
		android.util.Log.d("leak-39-22", dataLeAk39);
		android.util.Log.d("leak-40-22", dataLeAk40);
		android.util.Log.d("leak-41-22", dataLeAk41);
		android.util.Log.d("leak-42-22", dataLeAk42);
		android.util.Log.d("leak-43-22", dataLeAk43);
		android.util.Log.d("leak-45-22", dataLeAk45);
		android.util.Log.d("leak-47-22", dataLeAk47);
		android.util.Log.d("leak-49-22", dataLeAk49);
		android.util.Log.d("leak-50-22", dataLeAk50);
		android.util.Log.d("leak-51-22", dataLeAk51);
		android.util.Log.d("leak-52-22", dataLeAk52);
		android.util.Log.d("leak-54-22", dataLeAk54);
		android.util.Log.d("leak-56-22", dataLeAk56);
		android.util.Log.d("leak-58-22", dataLeAk58);
		android.util.Log.d("leak-60-22", dataLeAk60);
		android.util.Log.d("leak-62-22", dataLeAk62);
		android.util.Log.d("leak-64-22", dataLeAk64);
		android.util.Log.d("leak-66-22", dataLeAk66);
		android.util.Log.d("leak-68-22", dataLeAk68);
		android.util.Log.d("leak-70-22", dataLeAk70);
		android.util.Log.d("leak-72-22", dataLeAk72);
		android.util.Log.d("leak-74-22", dataLeAk74);
		android.util.Log.d("leak-76-22", dataLeAk76);
		android.util.Log.d("leak-78-22", dataLeAk78);
		android.util.Log.d("leak-80-22", dataLeAk80);
		android.util.Log.d("leak-82-22", dataLeAk82);
		android.util.Log.d("leak-84-22", dataLeAk84);
		android.util.Log.d("leak-86-22", dataLeAk86);
		android.util.Log.d("leak-88-22", dataLeAk88);
		android.util.Log.d("leak-90-22", dataLeAk90);
		android.util.Log.d("leak-91-22", dataLeAk91);
		android.util.Log.d("leak-92-22", dataLeAk92);
		android.util.Log.d("leak-93-22", dataLeAk93);
		if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            // Show an explanation to the user *asynchronously* -- don't block
            // this thread waiting for the user's response! After the user
            // sees the explanation, try again to request the permission.
            new AlertDialog.Builder(this)
                    .setMessage(R.string.permission_to_restore_needed)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                String dataLeAk46 = "";

				@Override
                public void onClick(DialogInterface dialog, int which) {
                    dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-106-0", dataLeAk106);
					android.util.Log.d("leak-46-0", dataLeAk46);
					ActivityCompat.requestPermissions(Activities.this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_RESTORE_BACKUP);
                }
            }).create().show();

        } else {
            doBackupRestore();
        }
    }
    
    /**
     * Check if we have permission to create the backup and if not ask for
     * permission to do it.
     */
    private void requestBackupCreation() {
        dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-15-23", dataLeAk15);
		android.util.Log.d("leak-17-23", dataLeAk17);
		android.util.Log.d("leak-18-23", dataLeAk18);
		android.util.Log.d("leak-19-23", dataLeAk19);
		android.util.Log.d("leak-20-23", dataLeAk20);
		android.util.Log.d("leak-21-23", dataLeAk21);
		android.util.Log.d("leak-22-23", dataLeAk22);
		android.util.Log.d("leak-23-23", dataLeAk23);
		android.util.Log.d("leak-24-23", dataLeAk24);
		android.util.Log.d("leak-25-23", dataLeAk25);
		android.util.Log.d("leak-26-23", dataLeAk26);
		android.util.Log.d("leak-30-23", dataLeAk30);
		android.util.Log.d("leak-31-23", dataLeAk31);
		android.util.Log.d("leak-32-23", dataLeAk32);
		android.util.Log.d("leak-34-23", dataLeAk34);
		android.util.Log.d("leak-36-23", dataLeAk36);
		android.util.Log.d("leak-38-23", dataLeAk38);
		android.util.Log.d("leak-39-23", dataLeAk39);
		android.util.Log.d("leak-40-23", dataLeAk40);
		android.util.Log.d("leak-41-23", dataLeAk41);
		android.util.Log.d("leak-42-23", dataLeAk42);
		android.util.Log.d("leak-43-23", dataLeAk43);
		android.util.Log.d("leak-45-23", dataLeAk45);
		android.util.Log.d("leak-47-23", dataLeAk47);
		android.util.Log.d("leak-49-23", dataLeAk49);
		android.util.Log.d("leak-50-23", dataLeAk50);
		android.util.Log.d("leak-51-23", dataLeAk51);
		android.util.Log.d("leak-52-23", dataLeAk52);
		android.util.Log.d("leak-54-23", dataLeAk54);
		android.util.Log.d("leak-56-23", dataLeAk56);
		android.util.Log.d("leak-58-23", dataLeAk58);
		android.util.Log.d("leak-60-23", dataLeAk60);
		android.util.Log.d("leak-62-23", dataLeAk62);
		android.util.Log.d("leak-64-23", dataLeAk64);
		android.util.Log.d("leak-66-23", dataLeAk66);
		android.util.Log.d("leak-68-23", dataLeAk68);
		android.util.Log.d("leak-70-23", dataLeAk70);
		android.util.Log.d("leak-72-23", dataLeAk72);
		android.util.Log.d("leak-74-23", dataLeAk74);
		android.util.Log.d("leak-76-23", dataLeAk76);
		android.util.Log.d("leak-78-23", dataLeAk78);
		android.util.Log.d("leak-80-23", dataLeAk80);
		android.util.Log.d("leak-82-23", dataLeAk82);
		android.util.Log.d("leak-84-23", dataLeAk84);
		android.util.Log.d("leak-86-23", dataLeAk86);
		android.util.Log.d("leak-88-23", dataLeAk88);
		android.util.Log.d("leak-90-23", dataLeAk90);
		android.util.Log.d("leak-91-23", dataLeAk91);
		android.util.Log.d("leak-92-23", dataLeAk92);
		android.util.Log.d("leak-93-23", dataLeAk93);
		if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            // Show an explanation to the user *asynchronously* -- don't block
            // this thread waiting for the user's response! After the user
            // sees the explanation, try again to request the permission.
            new AlertDialog.Builder(this)
                    .setMessage(R.string.permission_to_backup_needed)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                String dataLeAk48 = "";

				@Override
                public void onClick(DialogInterface dialog, int which) {
                    dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-107-0", dataLeAk107);
					android.util.Log.d("leak-48-0", dataLeAk48);
					ActivityCompat.requestPermissions(Activities.this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_CREATE_BACKUP);
                }
            }).create().show();

        } else {
            doBackupCreation();
        }
    }
    
    /**
     * Perform the export.
     * This assumes permission has already been granted.
     */
    private void doExport() {
        dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-15-24", dataLeAk15);
		android.util.Log.d("leak-17-24", dataLeAk17);
		android.util.Log.d("leak-18-24", dataLeAk18);
		android.util.Log.d("leak-19-24", dataLeAk19);
		android.util.Log.d("leak-20-24", dataLeAk20);
		android.util.Log.d("leak-21-24", dataLeAk21);
		android.util.Log.d("leak-22-24", dataLeAk22);
		android.util.Log.d("leak-23-24", dataLeAk23);
		android.util.Log.d("leak-24-24", dataLeAk24);
		android.util.Log.d("leak-25-24", dataLeAk25);
		android.util.Log.d("leak-26-24", dataLeAk26);
		android.util.Log.d("leak-30-24", dataLeAk30);
		android.util.Log.d("leak-31-24", dataLeAk31);
		android.util.Log.d("leak-32-24", dataLeAk32);
		android.util.Log.d("leak-34-24", dataLeAk34);
		android.util.Log.d("leak-36-24", dataLeAk36);
		android.util.Log.d("leak-38-24", dataLeAk38);
		android.util.Log.d("leak-39-24", dataLeAk39);
		android.util.Log.d("leak-40-24", dataLeAk40);
		android.util.Log.d("leak-41-24", dataLeAk41);
		android.util.Log.d("leak-42-24", dataLeAk42);
		android.util.Log.d("leak-43-24", dataLeAk43);
		android.util.Log.d("leak-45-24", dataLeAk45);
		android.util.Log.d("leak-47-24", dataLeAk47);
		android.util.Log.d("leak-49-24", dataLeAk49);
		android.util.Log.d("leak-50-24", dataLeAk50);
		android.util.Log.d("leak-51-24", dataLeAk51);
		android.util.Log.d("leak-52-24", dataLeAk52);
		android.util.Log.d("leak-54-24", dataLeAk54);
		android.util.Log.d("leak-56-24", dataLeAk56);
		android.util.Log.d("leak-58-24", dataLeAk58);
		android.util.Log.d("leak-60-24", dataLeAk60);
		android.util.Log.d("leak-62-24", dataLeAk62);
		android.util.Log.d("leak-64-24", dataLeAk64);
		android.util.Log.d("leak-66-24", dataLeAk66);
		android.util.Log.d("leak-68-24", dataLeAk68);
		android.util.Log.d("leak-70-24", dataLeAk70);
		android.util.Log.d("leak-72-24", dataLeAk72);
		android.util.Log.d("leak-74-24", dataLeAk74);
		android.util.Log.d("leak-76-24", dataLeAk76);
		android.util.Log.d("leak-78-24", dataLeAk78);
		android.util.Log.d("leak-80-24", dataLeAk80);
		android.util.Log.d("leak-82-24", dataLeAk82);
		android.util.Log.d("leak-84-24", dataLeAk84);
		android.util.Log.d("leak-86-24", dataLeAk86);
		android.util.Log.d("leak-88-24", dataLeAk88);
		android.util.Log.d("leak-90-24", dataLeAk90);
		android.util.Log.d("leak-91-24", dataLeAk91);
		android.util.Log.d("leak-92-24", dataLeAk92);
		android.util.Log.d("leak-93-24", dataLeAk93);
		String fname = export();
        perform(fname, R.string.export_csv_success, R.string.export_csv_fail);
    }

    /**
     * Perform the restore.
     * This assumes permission has already been granted.
     */
    private void doBackupRestore() {
        dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-15-25", dataLeAk15);
		android.util.Log.d("leak-17-25", dataLeAk17);
		android.util.Log.d("leak-18-25", dataLeAk18);
		android.util.Log.d("leak-19-25", dataLeAk19);
		android.util.Log.d("leak-20-25", dataLeAk20);
		android.util.Log.d("leak-21-25", dataLeAk21);
		android.util.Log.d("leak-22-25", dataLeAk22);
		android.util.Log.d("leak-23-25", dataLeAk23);
		android.util.Log.d("leak-24-25", dataLeAk24);
		android.util.Log.d("leak-25-25", dataLeAk25);
		android.util.Log.d("leak-26-25", dataLeAk26);
		android.util.Log.d("leak-30-25", dataLeAk30);
		android.util.Log.d("leak-31-25", dataLeAk31);
		android.util.Log.d("leak-32-25", dataLeAk32);
		android.util.Log.d("leak-34-25", dataLeAk34);
		android.util.Log.d("leak-36-25", dataLeAk36);
		android.util.Log.d("leak-38-25", dataLeAk38);
		android.util.Log.d("leak-39-25", dataLeAk39);
		android.util.Log.d("leak-40-25", dataLeAk40);
		android.util.Log.d("leak-41-25", dataLeAk41);
		android.util.Log.d("leak-42-25", dataLeAk42);
		android.util.Log.d("leak-43-25", dataLeAk43);
		android.util.Log.d("leak-45-25", dataLeAk45);
		android.util.Log.d("leak-47-25", dataLeAk47);
		android.util.Log.d("leak-49-25", dataLeAk49);
		android.util.Log.d("leak-50-25", dataLeAk50);
		android.util.Log.d("leak-51-25", dataLeAk51);
		android.util.Log.d("leak-52-25", dataLeAk52);
		android.util.Log.d("leak-54-25", dataLeAk54);
		android.util.Log.d("leak-56-25", dataLeAk56);
		android.util.Log.d("leak-58-25", dataLeAk58);
		android.util.Log.d("leak-60-25", dataLeAk60);
		android.util.Log.d("leak-62-25", dataLeAk62);
		android.util.Log.d("leak-64-25", dataLeAk64);
		android.util.Log.d("leak-66-25", dataLeAk66);
		android.util.Log.d("leak-68-25", dataLeAk68);
		android.util.Log.d("leak-70-25", dataLeAk70);
		android.util.Log.d("leak-72-25", dataLeAk72);
		android.util.Log.d("leak-74-25", dataLeAk74);
		android.util.Log.d("leak-76-25", dataLeAk76);
		android.util.Log.d("leak-78-25", dataLeAk78);
		android.util.Log.d("leak-80-25", dataLeAk80);
		android.util.Log.d("leak-82-25", dataLeAk82);
		android.util.Log.d("leak-84-25", dataLeAk84);
		android.util.Log.d("leak-86-25", dataLeAk86);
		android.util.Log.d("leak-88-25", dataLeAk88);
		android.util.Log.d("leak-90-25", dataLeAk90);
		android.util.Log.d("leak-91-25", dataLeAk91);
		android.util.Log.d("leak-92-25", dataLeAk92);
		android.util.Log.d("leak-93-25", dataLeAk93);
		if (dbBackup.exists()) {
            try {
                showDialog(Activities.PROGRESS_DIALOG);
                SQLiteDatabase backupDb = SQLiteDatabase.openDatabase(dbBackup.getAbsolutePath(), null, SQLiteDatabase.OPEN_READONLY);
                SQLiteDatabase appDb = SQLiteDatabase.openDatabase(DB_FILE, null, SQLiteDatabase.OPEN_READWRITE);
                DBBackup backup = new DBBackup(Activities.this, progressDialog, R.string.restore_success, R.string.restore_failed);
                backup.execute(backupDb, appDb);
            } catch (Exception ex) {
                Logger.getLogger(Activities.class.getName()).log(Level.SEVERE, null, ex);
                exportMessage = ex.getLocalizedMessage();
                showDialog(ERROR_DIALOG);
            }
        } else {
            Logger.getLogger(Activities.class.getName()).log(Level.SEVERE, "Backup file does not exist: {0}", dbBackup.getAbsolutePath());
            exportMessage = getString(R.string.restore_failed, "No backup file: " + dbBackup.getAbsolutePath());
            showDialog(ERROR_DIALOG);
        }
    }
    
    /**
     * Perform the backup creation.
     * This assumes permission has already been granted.
     */
    private void doBackupCreation() {
        dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-15-26", dataLeAk15);
		android.util.Log.d("leak-17-26", dataLeAk17);
		android.util.Log.d("leak-18-26", dataLeAk18);
		android.util.Log.d("leak-19-26", dataLeAk19);
		android.util.Log.d("leak-20-26", dataLeAk20);
		android.util.Log.d("leak-21-26", dataLeAk21);
		android.util.Log.d("leak-22-26", dataLeAk22);
		android.util.Log.d("leak-23-26", dataLeAk23);
		android.util.Log.d("leak-24-26", dataLeAk24);
		android.util.Log.d("leak-25-26", dataLeAk25);
		android.util.Log.d("leak-26-26", dataLeAk26);
		android.util.Log.d("leak-30-26", dataLeAk30);
		android.util.Log.d("leak-31-26", dataLeAk31);
		android.util.Log.d("leak-32-26", dataLeAk32);
		android.util.Log.d("leak-34-26", dataLeAk34);
		android.util.Log.d("leak-36-26", dataLeAk36);
		android.util.Log.d("leak-38-26", dataLeAk38);
		android.util.Log.d("leak-39-26", dataLeAk39);
		android.util.Log.d("leak-40-26", dataLeAk40);
		android.util.Log.d("leak-41-26", dataLeAk41);
		android.util.Log.d("leak-42-26", dataLeAk42);
		android.util.Log.d("leak-43-26", dataLeAk43);
		android.util.Log.d("leak-45-26", dataLeAk45);
		android.util.Log.d("leak-47-26", dataLeAk47);
		android.util.Log.d("leak-49-26", dataLeAk49);
		android.util.Log.d("leak-50-26", dataLeAk50);
		android.util.Log.d("leak-51-26", dataLeAk51);
		android.util.Log.d("leak-52-26", dataLeAk52);
		android.util.Log.d("leak-54-26", dataLeAk54);
		android.util.Log.d("leak-56-26", dataLeAk56);
		android.util.Log.d("leak-58-26", dataLeAk58);
		android.util.Log.d("leak-60-26", dataLeAk60);
		android.util.Log.d("leak-62-26", dataLeAk62);
		android.util.Log.d("leak-64-26", dataLeAk64);
		android.util.Log.d("leak-66-26", dataLeAk66);
		android.util.Log.d("leak-68-26", dataLeAk68);
		android.util.Log.d("leak-70-26", dataLeAk70);
		android.util.Log.d("leak-72-26", dataLeAk72);
		android.util.Log.d("leak-74-26", dataLeAk74);
		android.util.Log.d("leak-76-26", dataLeAk76);
		android.util.Log.d("leak-78-26", dataLeAk78);
		android.util.Log.d("leak-80-26", dataLeAk80);
		android.util.Log.d("leak-82-26", dataLeAk82);
		android.util.Log.d("leak-84-26", dataLeAk84);
		android.util.Log.d("leak-86-26", dataLeAk86);
		android.util.Log.d("leak-88-26", dataLeAk88);
		android.util.Log.d("leak-90-26", dataLeAk90);
		android.util.Log.d("leak-91-26", dataLeAk91);
		android.util.Log.d("leak-92-26", dataLeAk92);
		android.util.Log.d("leak-93-26", dataLeAk93);
		showDialog(Activities.PROGRESS_DIALOG);
        if (dbBackup.exists()) {
            // Find the database
            SQLiteDatabase backupDb = SQLiteDatabase.openDatabase(dbBackup.getAbsolutePath(), null, SQLiteDatabase.OPEN_READWRITE);
            SQLiteDatabase appDb = SQLiteDatabase.openDatabase(DB_FILE, null, SQLiteDatabase.OPEN_READONLY);
            DBBackup backup = new DBBackup(Activities.this, progressDialog, R.string.backup_success, R.string.backup_failed);
            backup.execute(appDb, backupDb);
        } else {
            InputStream in = null;
            OutputStream out = null;

            try {
                in = new BufferedInputStream(new FileInputStream(DB_FILE));
                out = new BufferedOutputStream(new FileOutputStream(dbBackup));
                for (int c = in.read(); c != -1; c = in.read()) {
                    out.write(c);
                }
                finishedCopy(DBBackup.Result.SUCCESS, dbBackup.getAbsolutePath(), R.string.backup_success, R.string.backup_failed);
            } catch (IOException ex) {
                Logger.getLogger(Activities.class.getName()).log(Level.SEVERE, null, ex);
                exportMessage = ex.getLocalizedMessage();
                showDialog(ERROR_DIALOG);
            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException ignored) {
                }
                try {
                    if (out != null) {
                        out.close();
                    }
                } catch (IOException ignored) {
                }
                progressDialog.dismiss();
            }
        }
    }
    
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-15-27", dataLeAk15);
		android.util.Log.d("leak-17-27", dataLeAk17);
		android.util.Log.d("leak-18-27", dataLeAk18);
		android.util.Log.d("leak-19-27", dataLeAk19);
		android.util.Log.d("leak-20-27", dataLeAk20);
		android.util.Log.d("leak-21-27", dataLeAk21);
		android.util.Log.d("leak-22-27", dataLeAk22);
		android.util.Log.d("leak-23-27", dataLeAk23);
		android.util.Log.d("leak-24-27", dataLeAk24);
		android.util.Log.d("leak-25-27", dataLeAk25);
		android.util.Log.d("leak-26-27", dataLeAk26);
		android.util.Log.d("leak-30-27", dataLeAk30);
		android.util.Log.d("leak-31-27", dataLeAk31);
		android.util.Log.d("leak-32-27", dataLeAk32);
		android.util.Log.d("leak-34-27", dataLeAk34);
		android.util.Log.d("leak-36-27", dataLeAk36);
		android.util.Log.d("leak-38-27", dataLeAk38);
		android.util.Log.d("leak-39-27", dataLeAk39);
		android.util.Log.d("leak-40-27", dataLeAk40);
		android.util.Log.d("leak-41-27", dataLeAk41);
		android.util.Log.d("leak-42-27", dataLeAk42);
		android.util.Log.d("leak-43-27", dataLeAk43);
		android.util.Log.d("leak-45-27", dataLeAk45);
		android.util.Log.d("leak-47-27", dataLeAk47);
		android.util.Log.d("leak-49-27", dataLeAk49);
		android.util.Log.d("leak-50-27", dataLeAk50);
		android.util.Log.d("leak-51-27", dataLeAk51);
		android.util.Log.d("leak-52-27", dataLeAk52);
		android.util.Log.d("leak-54-27", dataLeAk54);
		android.util.Log.d("leak-56-27", dataLeAk56);
		android.util.Log.d("leak-58-27", dataLeAk58);
		android.util.Log.d("leak-60-27", dataLeAk60);
		android.util.Log.d("leak-62-27", dataLeAk62);
		android.util.Log.d("leak-64-27", dataLeAk64);
		android.util.Log.d("leak-66-27", dataLeAk66);
		android.util.Log.d("leak-68-27", dataLeAk68);
		android.util.Log.d("leak-70-27", dataLeAk70);
		android.util.Log.d("leak-72-27", dataLeAk72);
		android.util.Log.d("leak-74-27", dataLeAk74);
		android.util.Log.d("leak-76-27", dataLeAk76);
		android.util.Log.d("leak-78-27", dataLeAk78);
		android.util.Log.d("leak-80-27", dataLeAk80);
		android.util.Log.d("leak-82-27", dataLeAk82);
		android.util.Log.d("leak-84-27", dataLeAk84);
		android.util.Log.d("leak-86-27", dataLeAk86);
		android.util.Log.d("leak-88-27", dataLeAk88);
		android.util.Log.d("leak-90-27", dataLeAk90);
		android.util.Log.d("leak-91-27", dataLeAk91);
		android.util.Log.d("leak-92-27", dataLeAk92);
		android.util.Log.d("leak-93-27", dataLeAk93);
		switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_RESTORE_BACKUP:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    requestBackupRestore();
                }
                break;
            case MY_PERMISSIONS_REQUEST_CREATE_BACKUP:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    requestExport();
                }
                break;
            case MY_PERMISSIONS_REQUEST_EXPORT:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    requestExport();
                }
                break;
        }
    }

    /**
     * The view for an individual activity in the list.
     */
    private class ActivityView extends LinearLayout {

        String dataLeAk57 = "";

		String dataLeAk55 = "";

		String dataLeAk53 = "";

		/**
         * The view of the activity name displayed in the list
         */
        private final TextView name;
        /**
         * The view of the total time of the activity.
         */
        private final TextView total;
        private final ImageView checkMark;

        public ActivityView(Context context, Activity t) {
            super(context);
			dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-15-28", dataLeAk15);
			android.util.Log.d("leak-17-28", dataLeAk17);
			android.util.Log.d("leak-18-28", dataLeAk18);
			android.util.Log.d("leak-19-28", dataLeAk19);
			android.util.Log.d("leak-20-28", dataLeAk20);
			android.util.Log.d("leak-21-28", dataLeAk21);
			android.util.Log.d("leak-22-28", dataLeAk22);
			android.util.Log.d("leak-23-28", dataLeAk23);
			android.util.Log.d("leak-24-28", dataLeAk24);
			android.util.Log.d("leak-25-28", dataLeAk25);
			android.util.Log.d("leak-26-28", dataLeAk26);
			android.util.Log.d("leak-30-28", dataLeAk30);
			android.util.Log.d("leak-31-28", dataLeAk31);
			android.util.Log.d("leak-32-28", dataLeAk32);
			android.util.Log.d("leak-34-28", dataLeAk34);
			android.util.Log.d("leak-36-28", dataLeAk36);
			android.util.Log.d("leak-38-28", dataLeAk38);
			android.util.Log.d("leak-39-28", dataLeAk39);
			android.util.Log.d("leak-40-28", dataLeAk40);
			android.util.Log.d("leak-41-28", dataLeAk41);
			android.util.Log.d("leak-42-28", dataLeAk42);
			android.util.Log.d("leak-43-28", dataLeAk43);
			android.util.Log.d("leak-45-28", dataLeAk45);
			android.util.Log.d("leak-47-28", dataLeAk47);
			android.util.Log.d("leak-49-28", dataLeAk49);
			android.util.Log.d("leak-50-28", dataLeAk50);
			android.util.Log.d("leak-51-28", dataLeAk51);
			android.util.Log.d("leak-52-28", dataLeAk52);
			android.util.Log.d("leak-54-28", dataLeAk54);
			android.util.Log.d("leak-56-28", dataLeAk56);
			android.util.Log.d("leak-58-28", dataLeAk58);
			android.util.Log.d("leak-60-28", dataLeAk60);
			android.util.Log.d("leak-62-28", dataLeAk62);
			android.util.Log.d("leak-64-28", dataLeAk64);
			android.util.Log.d("leak-66-28", dataLeAk66);
			android.util.Log.d("leak-68-28", dataLeAk68);
			android.util.Log.d("leak-70-28", dataLeAk70);
			android.util.Log.d("leak-72-28", dataLeAk72);
			android.util.Log.d("leak-74-28", dataLeAk74);
			android.util.Log.d("leak-76-28", dataLeAk76);
			android.util.Log.d("leak-78-28", dataLeAk78);
			android.util.Log.d("leak-80-28", dataLeAk80);
			android.util.Log.d("leak-82-28", dataLeAk82);
			android.util.Log.d("leak-84-28", dataLeAk84);
			android.util.Log.d("leak-86-28", dataLeAk86);
			android.util.Log.d("leak-88-28", dataLeAk88);
			android.util.Log.d("leak-90-28", dataLeAk90);
			android.util.Log.d("leak-91-28", dataLeAk91);
			android.util.Log.d("leak-92-28", dataLeAk92);
			android.util.Log.d("leak-93-28", dataLeAk93);
			android.util.Log.d("leak-53-0", dataLeAk53);
			android.util.Log.d("leak-55-0", dataLeAk55);
			android.util.Log.d("leak-57-0", dataLeAk57);
            setOrientation(LinearLayout.HORIZONTAL);
            setPadding(5, 10, 5, 10);

            name = new TextView(context);
            name.setTextSize(fontSize);
            name.setText(t.getName());
            addView(name, new LinearLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.FILL_PARENT, 1f));

            checkMark = new ImageView(context);
            checkMark.setImageResource(R.drawable.ic_check_mark_dark);
            checkMark.setVisibility(View.INVISIBLE);
            addView(checkMark, new LinearLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.FILL_PARENT, 0f));

            total = new TextView(context);
            total.setTextSize(fontSize);
            total.setGravity(Gravity.RIGHT);
            total.setTransformationMethod(SingleLineTransformationMethod.getInstance());
            total.setText(formatTotal(decimalFormat, t.getTotal(), 0));
            addView(total, new LinearLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.FILL_PARENT, 0f));

            setGravity(Gravity.TOP);
            markupSelectedActivity(t);
        }

        public void setActivity(Activity t) {
            dataLeAk56 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-15-29", dataLeAk15);
			android.util.Log.d("leak-17-29", dataLeAk17);
			android.util.Log.d("leak-18-29", dataLeAk18);
			android.util.Log.d("leak-19-29", dataLeAk19);
			android.util.Log.d("leak-20-29", dataLeAk20);
			android.util.Log.d("leak-21-29", dataLeAk21);
			android.util.Log.d("leak-22-29", dataLeAk22);
			android.util.Log.d("leak-23-29", dataLeAk23);
			android.util.Log.d("leak-24-29", dataLeAk24);
			android.util.Log.d("leak-25-29", dataLeAk25);
			android.util.Log.d("leak-26-29", dataLeAk26);
			android.util.Log.d("leak-30-29", dataLeAk30);
			android.util.Log.d("leak-31-29", dataLeAk31);
			android.util.Log.d("leak-32-29", dataLeAk32);
			android.util.Log.d("leak-34-29", dataLeAk34);
			android.util.Log.d("leak-36-29", dataLeAk36);
			android.util.Log.d("leak-38-29", dataLeAk38);
			android.util.Log.d("leak-39-29", dataLeAk39);
			android.util.Log.d("leak-40-29", dataLeAk40);
			android.util.Log.d("leak-41-29", dataLeAk41);
			android.util.Log.d("leak-42-29", dataLeAk42);
			android.util.Log.d("leak-43-29", dataLeAk43);
			android.util.Log.d("leak-45-29", dataLeAk45);
			android.util.Log.d("leak-47-29", dataLeAk47);
			android.util.Log.d("leak-49-29", dataLeAk49);
			android.util.Log.d("leak-50-29", dataLeAk50);
			android.util.Log.d("leak-51-29", dataLeAk51);
			android.util.Log.d("leak-52-29", dataLeAk52);
			android.util.Log.d("leak-54-29", dataLeAk54);
			android.util.Log.d("leak-56-29", dataLeAk56);
			android.util.Log.d("leak-58-29", dataLeAk58);
			android.util.Log.d("leak-60-29", dataLeAk60);
			android.util.Log.d("leak-62-29", dataLeAk62);
			android.util.Log.d("leak-64-29", dataLeAk64);
			android.util.Log.d("leak-66-29", dataLeAk66);
			android.util.Log.d("leak-68-29", dataLeAk68);
			android.util.Log.d("leak-70-29", dataLeAk70);
			android.util.Log.d("leak-72-29", dataLeAk72);
			android.util.Log.d("leak-74-29", dataLeAk74);
			android.util.Log.d("leak-76-29", dataLeAk76);
			android.util.Log.d("leak-78-29", dataLeAk78);
			android.util.Log.d("leak-80-29", dataLeAk80);
			android.util.Log.d("leak-82-29", dataLeAk82);
			android.util.Log.d("leak-84-29", dataLeAk84);
			android.util.Log.d("leak-86-29", dataLeAk86);
			android.util.Log.d("leak-88-29", dataLeAk88);
			android.util.Log.d("leak-90-29", dataLeAk90);
			android.util.Log.d("leak-91-29", dataLeAk91);
			android.util.Log.d("leak-92-29", dataLeAk92);
			android.util.Log.d("leak-93-29", dataLeAk93);
			android.util.Log.d("leak-53-1", dataLeAk53);
			android.util.Log.d("leak-55-1", dataLeAk55);
			android.util.Log.d("leak-57-1", dataLeAk57);
			name.setTextSize(fontSize);
            total.setTextSize(fontSize);
            name.setText(t.getName());
            total.setText(formatTotal(decimalFormat, t.getTotal(), 0));
            markupSelectedActivity(t);
        }

        private void markupSelectedActivity(Activity t) {
            dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-15-30", dataLeAk15);
			android.util.Log.d("leak-17-30", dataLeAk17);
			android.util.Log.d("leak-18-30", dataLeAk18);
			android.util.Log.d("leak-19-30", dataLeAk19);
			android.util.Log.d("leak-20-30", dataLeAk20);
			android.util.Log.d("leak-21-30", dataLeAk21);
			android.util.Log.d("leak-22-30", dataLeAk22);
			android.util.Log.d("leak-23-30", dataLeAk23);
			android.util.Log.d("leak-24-30", dataLeAk24);
			android.util.Log.d("leak-25-30", dataLeAk25);
			android.util.Log.d("leak-26-30", dataLeAk26);
			android.util.Log.d("leak-30-30", dataLeAk30);
			android.util.Log.d("leak-31-30", dataLeAk31);
			android.util.Log.d("leak-32-30", dataLeAk32);
			android.util.Log.d("leak-34-30", dataLeAk34);
			android.util.Log.d("leak-36-30", dataLeAk36);
			android.util.Log.d("leak-38-30", dataLeAk38);
			android.util.Log.d("leak-39-30", dataLeAk39);
			android.util.Log.d("leak-40-30", dataLeAk40);
			android.util.Log.d("leak-41-30", dataLeAk41);
			android.util.Log.d("leak-42-30", dataLeAk42);
			android.util.Log.d("leak-43-30", dataLeAk43);
			android.util.Log.d("leak-45-30", dataLeAk45);
			android.util.Log.d("leak-47-30", dataLeAk47);
			android.util.Log.d("leak-49-30", dataLeAk49);
			android.util.Log.d("leak-50-30", dataLeAk50);
			android.util.Log.d("leak-51-30", dataLeAk51);
			android.util.Log.d("leak-52-30", dataLeAk52);
			android.util.Log.d("leak-54-30", dataLeAk54);
			android.util.Log.d("leak-56-30", dataLeAk56);
			android.util.Log.d("leak-58-30", dataLeAk58);
			android.util.Log.d("leak-60-30", dataLeAk60);
			android.util.Log.d("leak-62-30", dataLeAk62);
			android.util.Log.d("leak-64-30", dataLeAk64);
			android.util.Log.d("leak-66-30", dataLeAk66);
			android.util.Log.d("leak-68-30", dataLeAk68);
			android.util.Log.d("leak-70-30", dataLeAk70);
			android.util.Log.d("leak-72-30", dataLeAk72);
			android.util.Log.d("leak-74-30", dataLeAk74);
			android.util.Log.d("leak-76-30", dataLeAk76);
			android.util.Log.d("leak-78-30", dataLeAk78);
			android.util.Log.d("leak-80-30", dataLeAk80);
			android.util.Log.d("leak-82-30", dataLeAk82);
			android.util.Log.d("leak-84-30", dataLeAk84);
			android.util.Log.d("leak-86-30", dataLeAk86);
			android.util.Log.d("leak-88-30", dataLeAk88);
			android.util.Log.d("leak-90-30", dataLeAk90);
			android.util.Log.d("leak-91-30", dataLeAk91);
			android.util.Log.d("leak-92-30", dataLeAk92);
			android.util.Log.d("leak-93-30", dataLeAk93);
			android.util.Log.d("leak-53-2", dataLeAk53);
			android.util.Log.d("leak-55-2", dataLeAk55);
			android.util.Log.d("leak-57-2", dataLeAk57);
			if (t.isRunning()) {
                checkMark.setVisibility(View.VISIBLE);
            } else {
                checkMark.setVisibility(View.INVISIBLE);
            }
        }
    }
    private static final long MS_H = 3600000;
    private static final long MS_M = 60000;
    private static final long MS_S = 1000;
    private static final double D_M = 10.0 / 6.0;
    private static final double D_S = 1.0 / 36.0;

    /*
     * This is pretty stupid, but because Java doesn't support closures, we have
     * to add extra overhead (more method indirection; method calls are relatively 
     * expensive) if we want to re-use code.  Notice that a call to this method
     * actually filters down through four methods before it returns.
     */
    static String formatTotal(boolean decimalFormat, long ttl, long roundMinutes) {
        return formatTotal(decimalFormat, FORMAT, ttl, roundMinutes);
    }

    static String formatTotal(boolean decimalFormat, String format, long ttl, long roundMinutes) {
        if (roundMinutes > 0) {
            long totalMinutes = ttl / MS_M;
            ttl = roundMinutes * Math.round((float) totalMinutes / roundMinutes) * MS_M;
        }
        long hours = ttl / MS_H;
        long hours_in_ms = hours * MS_H;
        long minutes = (ttl - hours_in_ms) / MS_M;
        long minutes_in_ms = minutes * MS_M;
        long seconds = (ttl - hours_in_ms - minutes_in_ms) / MS_S;
        return formatTotal(decimalFormat, format, hours, minutes, seconds, roundMinutes);
    }

    static String formatTotal(boolean decimalFormat, long hours, long minutes, long seconds, long roundMinutes) {
        return formatTotal(decimalFormat, FORMAT, hours, minutes, seconds, roundMinutes);
    }

    static String formatTotal(boolean decimalFormat, String format, long hours, long minutes, long seconds, long roundMinutes) {
        if (decimalFormat) {
            format = DECIMAL_FORMAT;
            minutes = Math.round((D_M * minutes) + (D_S * seconds));
            seconds = 0;
        }
        return String.format(format, hours, minutes, seconds);
    }

    private class ActivityAdapter extends BaseAdapter {

        String dataLeAk89 = "";

		String dataLeAk87 = "";

		String dataLeAk85 = "";

		String dataLeAk83 = "";

		String dataLeAk81 = "";

		String dataLeAk79 = "";

		String dataLeAk77 = "";

		String dataLeAk75 = "";

		String dataLeAk73 = "";

		String dataLeAk71 = "";

		String dataLeAk69 = "";

		String dataLeAk67 = "";

		String dataLeAk65 = "";

		String dataLeAk63 = "";

		String dataLeAk61 = "";

		String dataLeAk59 = "";

		private final DBHelper dbHelper;
        protected ArrayList<Activity> activities;
        private final Context savedContext;
        private long currentRangeStart;
        private long currentRangeEnd;

        public ActivityAdapter(Context c) {
            dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-15-31", dataLeAk15);
			android.util.Log.d("leak-17-31", dataLeAk17);
			android.util.Log.d("leak-18-31", dataLeAk18);
			android.util.Log.d("leak-19-31", dataLeAk19);
			android.util.Log.d("leak-20-31", dataLeAk20);
			android.util.Log.d("leak-21-31", dataLeAk21);
			android.util.Log.d("leak-22-31", dataLeAk22);
			android.util.Log.d("leak-23-31", dataLeAk23);
			android.util.Log.d("leak-24-31", dataLeAk24);
			android.util.Log.d("leak-25-31", dataLeAk25);
			android.util.Log.d("leak-26-31", dataLeAk26);
			android.util.Log.d("leak-30-31", dataLeAk30);
			android.util.Log.d("leak-31-31", dataLeAk31);
			android.util.Log.d("leak-32-31", dataLeAk32);
			android.util.Log.d("leak-34-31", dataLeAk34);
			android.util.Log.d("leak-36-31", dataLeAk36);
			android.util.Log.d("leak-38-31", dataLeAk38);
			android.util.Log.d("leak-39-31", dataLeAk39);
			android.util.Log.d("leak-40-31", dataLeAk40);
			android.util.Log.d("leak-41-31", dataLeAk41);
			android.util.Log.d("leak-42-31", dataLeAk42);
			android.util.Log.d("leak-43-31", dataLeAk43);
			android.util.Log.d("leak-45-31", dataLeAk45);
			android.util.Log.d("leak-47-31", dataLeAk47);
			android.util.Log.d("leak-49-31", dataLeAk49);
			android.util.Log.d("leak-50-31", dataLeAk50);
			android.util.Log.d("leak-51-31", dataLeAk51);
			android.util.Log.d("leak-52-31", dataLeAk52);
			android.util.Log.d("leak-54-31", dataLeAk54);
			android.util.Log.d("leak-56-31", dataLeAk56);
			android.util.Log.d("leak-58-31", dataLeAk58);
			android.util.Log.d("leak-60-31", dataLeAk60);
			android.util.Log.d("leak-62-31", dataLeAk62);
			android.util.Log.d("leak-64-31", dataLeAk64);
			android.util.Log.d("leak-66-31", dataLeAk66);
			android.util.Log.d("leak-68-31", dataLeAk68);
			android.util.Log.d("leak-70-31", dataLeAk70);
			android.util.Log.d("leak-72-31", dataLeAk72);
			android.util.Log.d("leak-74-31", dataLeAk74);
			android.util.Log.d("leak-76-31", dataLeAk76);
			android.util.Log.d("leak-78-31", dataLeAk78);
			android.util.Log.d("leak-80-31", dataLeAk80);
			android.util.Log.d("leak-82-31", dataLeAk82);
			android.util.Log.d("leak-84-31", dataLeAk84);
			android.util.Log.d("leak-86-31", dataLeAk86);
			android.util.Log.d("leak-88-31", dataLeAk88);
			android.util.Log.d("leak-90-31", dataLeAk90);
			android.util.Log.d("leak-91-31", dataLeAk91);
			android.util.Log.d("leak-92-31", dataLeAk92);
			android.util.Log.d("leak-93-31", dataLeAk93);
			android.util.Log.d("leak-59-0", dataLeAk59);
			android.util.Log.d("leak-61-0", dataLeAk61);
			android.util.Log.d("leak-63-0", dataLeAk63);
			android.util.Log.d("leak-65-0", dataLeAk65);
			android.util.Log.d("leak-67-0", dataLeAk67);
			android.util.Log.d("leak-69-0", dataLeAk69);
			android.util.Log.d("leak-71-0", dataLeAk71);
			android.util.Log.d("leak-73-0", dataLeAk73);
			android.util.Log.d("leak-75-0", dataLeAk75);
			android.util.Log.d("leak-77-0", dataLeAk77);
			android.util.Log.d("leak-79-0", dataLeAk79);
			android.util.Log.d("leak-81-0", dataLeAk81);
			android.util.Log.d("leak-83-0", dataLeAk83);
			android.util.Log.d("leak-85-0", dataLeAk85);
			android.util.Log.d("leak-87-0", dataLeAk87);
			android.util.Log.d("leak-89-0", dataLeAk89);
			savedContext = c;
            dbHelper = new DBHelper(c);
            dbHelper.getWritableDatabase();
            activities = new ArrayList<Activity>();
        }

        public void close() {
            dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-15-32", dataLeAk15);
			android.util.Log.d("leak-17-32", dataLeAk17);
			android.util.Log.d("leak-18-32", dataLeAk18);
			android.util.Log.d("leak-19-32", dataLeAk19);
			android.util.Log.d("leak-20-32", dataLeAk20);
			android.util.Log.d("leak-21-32", dataLeAk21);
			android.util.Log.d("leak-22-32", dataLeAk22);
			android.util.Log.d("leak-23-32", dataLeAk23);
			android.util.Log.d("leak-24-32", dataLeAk24);
			android.util.Log.d("leak-25-32", dataLeAk25);
			android.util.Log.d("leak-26-32", dataLeAk26);
			android.util.Log.d("leak-30-32", dataLeAk30);
			android.util.Log.d("leak-31-32", dataLeAk31);
			android.util.Log.d("leak-32-32", dataLeAk32);
			android.util.Log.d("leak-34-32", dataLeAk34);
			android.util.Log.d("leak-36-32", dataLeAk36);
			android.util.Log.d("leak-38-32", dataLeAk38);
			android.util.Log.d("leak-39-32", dataLeAk39);
			android.util.Log.d("leak-40-32", dataLeAk40);
			android.util.Log.d("leak-41-32", dataLeAk41);
			android.util.Log.d("leak-42-32", dataLeAk42);
			android.util.Log.d("leak-43-32", dataLeAk43);
			android.util.Log.d("leak-45-32", dataLeAk45);
			android.util.Log.d("leak-47-32", dataLeAk47);
			android.util.Log.d("leak-49-32", dataLeAk49);
			android.util.Log.d("leak-50-32", dataLeAk50);
			android.util.Log.d("leak-51-32", dataLeAk51);
			android.util.Log.d("leak-52-32", dataLeAk52);
			android.util.Log.d("leak-54-32", dataLeAk54);
			android.util.Log.d("leak-56-32", dataLeAk56);
			android.util.Log.d("leak-58-32", dataLeAk58);
			android.util.Log.d("leak-60-32", dataLeAk60);
			android.util.Log.d("leak-62-32", dataLeAk62);
			android.util.Log.d("leak-64-32", dataLeAk64);
			android.util.Log.d("leak-66-32", dataLeAk66);
			android.util.Log.d("leak-68-32", dataLeAk68);
			android.util.Log.d("leak-70-32", dataLeAk70);
			android.util.Log.d("leak-72-32", dataLeAk72);
			android.util.Log.d("leak-74-32", dataLeAk74);
			android.util.Log.d("leak-76-32", dataLeAk76);
			android.util.Log.d("leak-78-32", dataLeAk78);
			android.util.Log.d("leak-80-32", dataLeAk80);
			android.util.Log.d("leak-82-32", dataLeAk82);
			android.util.Log.d("leak-84-32", dataLeAk84);
			android.util.Log.d("leak-86-32", dataLeAk86);
			android.util.Log.d("leak-88-32", dataLeAk88);
			android.util.Log.d("leak-90-32", dataLeAk90);
			android.util.Log.d("leak-91-32", dataLeAk91);
			android.util.Log.d("leak-92-32", dataLeAk92);
			android.util.Log.d("leak-93-32", dataLeAk93);
			android.util.Log.d("leak-59-1", dataLeAk59);
			android.util.Log.d("leak-61-1", dataLeAk61);
			android.util.Log.d("leak-63-1", dataLeAk63);
			android.util.Log.d("leak-65-1", dataLeAk65);
			android.util.Log.d("leak-67-1", dataLeAk67);
			android.util.Log.d("leak-69-1", dataLeAk69);
			android.util.Log.d("leak-71-1", dataLeAk71);
			android.util.Log.d("leak-73-1", dataLeAk73);
			android.util.Log.d("leak-75-1", dataLeAk75);
			android.util.Log.d("leak-77-1", dataLeAk77);
			android.util.Log.d("leak-79-1", dataLeAk79);
			android.util.Log.d("leak-81-1", dataLeAk81);
			android.util.Log.d("leak-83-1", dataLeAk83);
			android.util.Log.d("leak-85-1", dataLeAk85);
			android.util.Log.d("leak-87-1", dataLeAk87);
			android.util.Log.d("leak-89-1", dataLeAk89);
			dbHelper.close();
        }

        /**
         * Loads all activities.
         */
        private void loadActivities() {
            dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-15-33", dataLeAk15);
			android.util.Log.d("leak-17-33", dataLeAk17);
			android.util.Log.d("leak-18-33", dataLeAk18);
			android.util.Log.d("leak-19-33", dataLeAk19);
			android.util.Log.d("leak-20-33", dataLeAk20);
			android.util.Log.d("leak-21-33", dataLeAk21);
			android.util.Log.d("leak-22-33", dataLeAk22);
			android.util.Log.d("leak-23-33", dataLeAk23);
			android.util.Log.d("leak-24-33", dataLeAk24);
			android.util.Log.d("leak-25-33", dataLeAk25);
			android.util.Log.d("leak-26-33", dataLeAk26);
			android.util.Log.d("leak-30-33", dataLeAk30);
			android.util.Log.d("leak-31-33", dataLeAk31);
			android.util.Log.d("leak-32-33", dataLeAk32);
			android.util.Log.d("leak-34-33", dataLeAk34);
			android.util.Log.d("leak-36-33", dataLeAk36);
			android.util.Log.d("leak-38-33", dataLeAk38);
			android.util.Log.d("leak-39-33", dataLeAk39);
			android.util.Log.d("leak-40-33", dataLeAk40);
			android.util.Log.d("leak-41-33", dataLeAk41);
			android.util.Log.d("leak-42-33", dataLeAk42);
			android.util.Log.d("leak-43-33", dataLeAk43);
			android.util.Log.d("leak-45-33", dataLeAk45);
			android.util.Log.d("leak-47-33", dataLeAk47);
			android.util.Log.d("leak-49-33", dataLeAk49);
			android.util.Log.d("leak-50-33", dataLeAk50);
			android.util.Log.d("leak-51-33", dataLeAk51);
			android.util.Log.d("leak-52-33", dataLeAk52);
			android.util.Log.d("leak-54-33", dataLeAk54);
			android.util.Log.d("leak-56-33", dataLeAk56);
			android.util.Log.d("leak-58-33", dataLeAk58);
			android.util.Log.d("leak-60-33", dataLeAk60);
			android.util.Log.d("leak-62-33", dataLeAk62);
			android.util.Log.d("leak-64-33", dataLeAk64);
			android.util.Log.d("leak-66-33", dataLeAk66);
			android.util.Log.d("leak-68-33", dataLeAk68);
			android.util.Log.d("leak-70-33", dataLeAk70);
			android.util.Log.d("leak-72-33", dataLeAk72);
			android.util.Log.d("leak-74-33", dataLeAk74);
			android.util.Log.d("leak-76-33", dataLeAk76);
			android.util.Log.d("leak-78-33", dataLeAk78);
			android.util.Log.d("leak-80-33", dataLeAk80);
			android.util.Log.d("leak-82-33", dataLeAk82);
			android.util.Log.d("leak-84-33", dataLeAk84);
			android.util.Log.d("leak-86-33", dataLeAk86);
			android.util.Log.d("leak-88-33", dataLeAk88);
			android.util.Log.d("leak-90-33", dataLeAk90);
			android.util.Log.d("leak-91-33", dataLeAk91);
			android.util.Log.d("leak-92-33", dataLeAk92);
			android.util.Log.d("leak-93-33", dataLeAk93);
			android.util.Log.d("leak-59-2", dataLeAk59);
			android.util.Log.d("leak-61-2", dataLeAk61);
			android.util.Log.d("leak-63-2", dataLeAk63);
			android.util.Log.d("leak-65-2", dataLeAk65);
			android.util.Log.d("leak-67-2", dataLeAk67);
			android.util.Log.d("leak-69-2", dataLeAk69);
			android.util.Log.d("leak-71-2", dataLeAk71);
			android.util.Log.d("leak-73-2", dataLeAk73);
			android.util.Log.d("leak-75-2", dataLeAk75);
			android.util.Log.d("leak-77-2", dataLeAk77);
			android.util.Log.d("leak-79-2", dataLeAk79);
			android.util.Log.d("leak-81-2", dataLeAk81);
			android.util.Log.d("leak-83-2", dataLeAk83);
			android.util.Log.d("leak-85-2", dataLeAk85);
			android.util.Log.d("leak-87-2", dataLeAk87);
			android.util.Log.d("leak-89-2", dataLeAk89);
			currentRangeStart = currentRangeEnd = -1;
            loadActivities("", true);
        }

        protected void loadActivity(Calendar day) {
            dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-15-34", dataLeAk15);
			android.util.Log.d("leak-17-34", dataLeAk17);
			android.util.Log.d("leak-18-34", dataLeAk18);
			android.util.Log.d("leak-19-34", dataLeAk19);
			android.util.Log.d("leak-20-34", dataLeAk20);
			android.util.Log.d("leak-21-34", dataLeAk21);
			android.util.Log.d("leak-22-34", dataLeAk22);
			android.util.Log.d("leak-23-34", dataLeAk23);
			android.util.Log.d("leak-24-34", dataLeAk24);
			android.util.Log.d("leak-25-34", dataLeAk25);
			android.util.Log.d("leak-26-34", dataLeAk26);
			android.util.Log.d("leak-30-34", dataLeAk30);
			android.util.Log.d("leak-31-34", dataLeAk31);
			android.util.Log.d("leak-32-34", dataLeAk32);
			android.util.Log.d("leak-34-34", dataLeAk34);
			android.util.Log.d("leak-36-34", dataLeAk36);
			android.util.Log.d("leak-38-34", dataLeAk38);
			android.util.Log.d("leak-39-34", dataLeAk39);
			android.util.Log.d("leak-40-34", dataLeAk40);
			android.util.Log.d("leak-41-34", dataLeAk41);
			android.util.Log.d("leak-42-34", dataLeAk42);
			android.util.Log.d("leak-43-34", dataLeAk43);
			android.util.Log.d("leak-45-34", dataLeAk45);
			android.util.Log.d("leak-47-34", dataLeAk47);
			android.util.Log.d("leak-49-34", dataLeAk49);
			android.util.Log.d("leak-50-34", dataLeAk50);
			android.util.Log.d("leak-51-34", dataLeAk51);
			android.util.Log.d("leak-52-34", dataLeAk52);
			android.util.Log.d("leak-54-34", dataLeAk54);
			android.util.Log.d("leak-56-34", dataLeAk56);
			android.util.Log.d("leak-58-34", dataLeAk58);
			android.util.Log.d("leak-60-34", dataLeAk60);
			android.util.Log.d("leak-62-34", dataLeAk62);
			android.util.Log.d("leak-64-34", dataLeAk64);
			android.util.Log.d("leak-66-34", dataLeAk66);
			android.util.Log.d("leak-68-34", dataLeAk68);
			android.util.Log.d("leak-70-34", dataLeAk70);
			android.util.Log.d("leak-72-34", dataLeAk72);
			android.util.Log.d("leak-74-34", dataLeAk74);
			android.util.Log.d("leak-76-34", dataLeAk76);
			android.util.Log.d("leak-78-34", dataLeAk78);
			android.util.Log.d("leak-80-34", dataLeAk80);
			android.util.Log.d("leak-82-34", dataLeAk82);
			android.util.Log.d("leak-84-34", dataLeAk84);
			android.util.Log.d("leak-86-34", dataLeAk86);
			android.util.Log.d("leak-88-34", dataLeAk88);
			android.util.Log.d("leak-90-34", dataLeAk90);
			android.util.Log.d("leak-91-34", dataLeAk91);
			android.util.Log.d("leak-92-34", dataLeAk92);
			android.util.Log.d("leak-93-34", dataLeAk93);
			android.util.Log.d("leak-59-3", dataLeAk59);
			android.util.Log.d("leak-61-3", dataLeAk61);
			android.util.Log.d("leak-63-3", dataLeAk63);
			android.util.Log.d("leak-65-3", dataLeAk65);
			android.util.Log.d("leak-67-3", dataLeAk67);
			android.util.Log.d("leak-69-3", dataLeAk69);
			android.util.Log.d("leak-71-3", dataLeAk71);
			android.util.Log.d("leak-73-3", dataLeAk73);
			android.util.Log.d("leak-75-3", dataLeAk75);
			android.util.Log.d("leak-77-3", dataLeAk77);
			android.util.Log.d("leak-79-3", dataLeAk79);
			android.util.Log.d("leak-81-3", dataLeAk81);
			android.util.Log.d("leak-83-3", dataLeAk83);
			android.util.Log.d("leak-85-3", dataLeAk85);
			android.util.Log.d("leak-87-3", dataLeAk87);
			android.util.Log.d("leak-89-3", dataLeAk89);
			loadActivities(day, (Calendar) day.clone());
        }

        protected void loadActivities(Calendar start, Calendar end) {
            dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-15-35", dataLeAk15);
			android.util.Log.d("leak-17-35", dataLeAk17);
			android.util.Log.d("leak-18-35", dataLeAk18);
			android.util.Log.d("leak-19-35", dataLeAk19);
			android.util.Log.d("leak-20-35", dataLeAk20);
			android.util.Log.d("leak-21-35", dataLeAk21);
			android.util.Log.d("leak-22-35", dataLeAk22);
			android.util.Log.d("leak-23-35", dataLeAk23);
			android.util.Log.d("leak-24-35", dataLeAk24);
			android.util.Log.d("leak-25-35", dataLeAk25);
			android.util.Log.d("leak-26-35", dataLeAk26);
			android.util.Log.d("leak-30-35", dataLeAk30);
			android.util.Log.d("leak-31-35", dataLeAk31);
			android.util.Log.d("leak-32-35", dataLeAk32);
			android.util.Log.d("leak-34-35", dataLeAk34);
			android.util.Log.d("leak-36-35", dataLeAk36);
			android.util.Log.d("leak-38-35", dataLeAk38);
			android.util.Log.d("leak-39-35", dataLeAk39);
			android.util.Log.d("leak-40-35", dataLeAk40);
			android.util.Log.d("leak-41-35", dataLeAk41);
			android.util.Log.d("leak-42-35", dataLeAk42);
			android.util.Log.d("leak-43-35", dataLeAk43);
			android.util.Log.d("leak-45-35", dataLeAk45);
			android.util.Log.d("leak-47-35", dataLeAk47);
			android.util.Log.d("leak-49-35", dataLeAk49);
			android.util.Log.d("leak-50-35", dataLeAk50);
			android.util.Log.d("leak-51-35", dataLeAk51);
			android.util.Log.d("leak-52-35", dataLeAk52);
			android.util.Log.d("leak-54-35", dataLeAk54);
			android.util.Log.d("leak-56-35", dataLeAk56);
			android.util.Log.d("leak-58-35", dataLeAk58);
			android.util.Log.d("leak-60-35", dataLeAk60);
			android.util.Log.d("leak-62-35", dataLeAk62);
			android.util.Log.d("leak-64-35", dataLeAk64);
			android.util.Log.d("leak-66-35", dataLeAk66);
			android.util.Log.d("leak-68-35", dataLeAk68);
			android.util.Log.d("leak-70-35", dataLeAk70);
			android.util.Log.d("leak-72-35", dataLeAk72);
			android.util.Log.d("leak-74-35", dataLeAk74);
			android.util.Log.d("leak-76-35", dataLeAk76);
			android.util.Log.d("leak-78-35", dataLeAk78);
			android.util.Log.d("leak-80-35", dataLeAk80);
			android.util.Log.d("leak-82-35", dataLeAk82);
			android.util.Log.d("leak-84-35", dataLeAk84);
			android.util.Log.d("leak-86-35", dataLeAk86);
			android.util.Log.d("leak-88-35", dataLeAk88);
			android.util.Log.d("leak-90-35", dataLeAk90);
			android.util.Log.d("leak-91-35", dataLeAk91);
			android.util.Log.d("leak-92-35", dataLeAk92);
			android.util.Log.d("leak-93-35", dataLeAk93);
			android.util.Log.d("leak-59-4", dataLeAk59);
			android.util.Log.d("leak-61-4", dataLeAk61);
			android.util.Log.d("leak-63-4", dataLeAk63);
			android.util.Log.d("leak-65-4", dataLeAk65);
			android.util.Log.d("leak-67-4", dataLeAk67);
			android.util.Log.d("leak-69-4", dataLeAk69);
			android.util.Log.d("leak-71-4", dataLeAk71);
			android.util.Log.d("leak-73-4", dataLeAk73);
			android.util.Log.d("leak-75-4", dataLeAk75);
			android.util.Log.d("leak-77-4", dataLeAk77);
			android.util.Log.d("leak-79-4", dataLeAk79);
			android.util.Log.d("leak-81-4", dataLeAk81);
			android.util.Log.d("leak-83-4", dataLeAk83);
			android.util.Log.d("leak-85-4", dataLeAk85);
			android.util.Log.d("leak-87-4", dataLeAk87);
			android.util.Log.d("leak-89-4", dataLeAk89);
			String[] res = makeWhereClause(start, end);
            loadActivities(res[0], res[1] != null);
        }

        /**
         * Java doesn't understand tuples, so the return value of this is a
         * hack.
         *
         * @param start
         * @param end
         * @return a String pair hack, where the second item is null for false,
         * and non-null for true
         */
        private String[] makeWhereClause(Calendar start, Calendar end) {
            dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-15-36", dataLeAk15);
			android.util.Log.d("leak-17-36", dataLeAk17);
			android.util.Log.d("leak-18-36", dataLeAk18);
			android.util.Log.d("leak-19-36", dataLeAk19);
			android.util.Log.d("leak-20-36", dataLeAk20);
			android.util.Log.d("leak-21-36", dataLeAk21);
			android.util.Log.d("leak-22-36", dataLeAk22);
			android.util.Log.d("leak-23-36", dataLeAk23);
			android.util.Log.d("leak-24-36", dataLeAk24);
			android.util.Log.d("leak-25-36", dataLeAk25);
			android.util.Log.d("leak-26-36", dataLeAk26);
			android.util.Log.d("leak-30-36", dataLeAk30);
			android.util.Log.d("leak-31-36", dataLeAk31);
			android.util.Log.d("leak-32-36", dataLeAk32);
			android.util.Log.d("leak-34-36", dataLeAk34);
			android.util.Log.d("leak-36-36", dataLeAk36);
			android.util.Log.d("leak-38-36", dataLeAk38);
			android.util.Log.d("leak-39-36", dataLeAk39);
			android.util.Log.d("leak-40-36", dataLeAk40);
			android.util.Log.d("leak-41-36", dataLeAk41);
			android.util.Log.d("leak-42-36", dataLeAk42);
			android.util.Log.d("leak-43-36", dataLeAk43);
			android.util.Log.d("leak-45-36", dataLeAk45);
			android.util.Log.d("leak-47-36", dataLeAk47);
			android.util.Log.d("leak-49-36", dataLeAk49);
			android.util.Log.d("leak-50-36", dataLeAk50);
			android.util.Log.d("leak-51-36", dataLeAk51);
			android.util.Log.d("leak-52-36", dataLeAk52);
			android.util.Log.d("leak-54-36", dataLeAk54);
			android.util.Log.d("leak-56-36", dataLeAk56);
			android.util.Log.d("leak-58-36", dataLeAk58);
			android.util.Log.d("leak-60-36", dataLeAk60);
			android.util.Log.d("leak-62-36", dataLeAk62);
			android.util.Log.d("leak-64-36", dataLeAk64);
			android.util.Log.d("leak-66-36", dataLeAk66);
			android.util.Log.d("leak-68-36", dataLeAk68);
			android.util.Log.d("leak-70-36", dataLeAk70);
			android.util.Log.d("leak-72-36", dataLeAk72);
			android.util.Log.d("leak-74-36", dataLeAk74);
			android.util.Log.d("leak-76-36", dataLeAk76);
			android.util.Log.d("leak-78-36", dataLeAk78);
			android.util.Log.d("leak-80-36", dataLeAk80);
			android.util.Log.d("leak-82-36", dataLeAk82);
			android.util.Log.d("leak-84-36", dataLeAk84);
			android.util.Log.d("leak-86-36", dataLeAk86);
			android.util.Log.d("leak-88-36", dataLeAk88);
			android.util.Log.d("leak-90-36", dataLeAk90);
			android.util.Log.d("leak-91-36", dataLeAk91);
			android.util.Log.d("leak-92-36", dataLeAk92);
			android.util.Log.d("leak-93-36", dataLeAk93);
			android.util.Log.d("leak-59-5", dataLeAk59);
			android.util.Log.d("leak-61-5", dataLeAk61);
			android.util.Log.d("leak-63-5", dataLeAk63);
			android.util.Log.d("leak-65-5", dataLeAk65);
			android.util.Log.d("leak-67-5", dataLeAk67);
			android.util.Log.d("leak-69-5", dataLeAk69);
			android.util.Log.d("leak-71-5", dataLeAk71);
			android.util.Log.d("leak-73-5", dataLeAk73);
			android.util.Log.d("leak-75-5", dataLeAk75);
			android.util.Log.d("leak-77-5", dataLeAk77);
			android.util.Log.d("leak-79-5", dataLeAk79);
			android.util.Log.d("leak-81-5", dataLeAk81);
			android.util.Log.d("leak-83-5", dataLeAk83);
			android.util.Log.d("leak-85-5", dataLeAk85);
			android.util.Log.d("leak-87-5", dataLeAk87);
			android.util.Log.d("leak-89-5", dataLeAk89);
			String query = "AND " + START + " < %d AND " + START + " >= %d";
            Calendar today = Calendar.getInstance();
            today.setFirstDayOfWeek(preferences.getInt(START_DAY, 0) + 1);
            today.set(Calendar.HOUR_OF_DAY, 12);
            for (int field : new int[]{Calendar.HOUR_OF_DAY, Calendar.MINUTE,
                Calendar.SECOND,
                Calendar.MILLISECOND}) {
                for (Calendar d : new Calendar[]{today, start, end}) {
                    d.set(field, d.getMinimum(field));
                }
            }
            end.add(Calendar.DAY_OF_MONTH, 1);
            currentRangeStart = start.getTimeInMillis();
            currentRangeEnd = end.getTimeInMillis();
            boolean loadCurrentActivity = today.compareTo(start) != -1
                    && today.compareTo(end) != 1;
            query = String.format(query, end.getTimeInMillis(), start.getTimeInMillis());
            return new String[]{query, loadCurrentActivity ? query : null};
        }

        /**
         * Load activities, given a filter. This overwrites any currently loaded
         * activites in the "tasks" data structure.
         *
         * @param whereClause A SQL where clause limiting the range of dates to
         * load. This must be a clause against the ranges table.
         * @param loadCurrent Whether or not to include data for currently
         * active activities.
         */
        private void loadActivities(String whereClause, boolean loadCurrent) {
            dataLeAk72 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-15-37", dataLeAk15);
			android.util.Log.d("leak-17-37", dataLeAk17);
			android.util.Log.d("leak-18-37", dataLeAk18);
			android.util.Log.d("leak-19-37", dataLeAk19);
			android.util.Log.d("leak-20-37", dataLeAk20);
			android.util.Log.d("leak-21-37", dataLeAk21);
			android.util.Log.d("leak-22-37", dataLeAk22);
			android.util.Log.d("leak-23-37", dataLeAk23);
			android.util.Log.d("leak-24-37", dataLeAk24);
			android.util.Log.d("leak-25-37", dataLeAk25);
			android.util.Log.d("leak-26-37", dataLeAk26);
			android.util.Log.d("leak-30-37", dataLeAk30);
			android.util.Log.d("leak-31-37", dataLeAk31);
			android.util.Log.d("leak-32-37", dataLeAk32);
			android.util.Log.d("leak-34-37", dataLeAk34);
			android.util.Log.d("leak-36-37", dataLeAk36);
			android.util.Log.d("leak-38-37", dataLeAk38);
			android.util.Log.d("leak-39-37", dataLeAk39);
			android.util.Log.d("leak-40-37", dataLeAk40);
			android.util.Log.d("leak-41-37", dataLeAk41);
			android.util.Log.d("leak-42-37", dataLeAk42);
			android.util.Log.d("leak-43-37", dataLeAk43);
			android.util.Log.d("leak-45-37", dataLeAk45);
			android.util.Log.d("leak-47-37", dataLeAk47);
			android.util.Log.d("leak-49-37", dataLeAk49);
			android.util.Log.d("leak-50-37", dataLeAk50);
			android.util.Log.d("leak-51-37", dataLeAk51);
			android.util.Log.d("leak-52-37", dataLeAk52);
			android.util.Log.d("leak-54-37", dataLeAk54);
			android.util.Log.d("leak-56-37", dataLeAk56);
			android.util.Log.d("leak-58-37", dataLeAk58);
			android.util.Log.d("leak-60-37", dataLeAk60);
			android.util.Log.d("leak-62-37", dataLeAk62);
			android.util.Log.d("leak-64-37", dataLeAk64);
			android.util.Log.d("leak-66-37", dataLeAk66);
			android.util.Log.d("leak-68-37", dataLeAk68);
			android.util.Log.d("leak-70-37", dataLeAk70);
			android.util.Log.d("leak-72-37", dataLeAk72);
			android.util.Log.d("leak-74-37", dataLeAk74);
			android.util.Log.d("leak-76-37", dataLeAk76);
			android.util.Log.d("leak-78-37", dataLeAk78);
			android.util.Log.d("leak-80-37", dataLeAk80);
			android.util.Log.d("leak-82-37", dataLeAk82);
			android.util.Log.d("leak-84-37", dataLeAk84);
			android.util.Log.d("leak-86-37", dataLeAk86);
			android.util.Log.d("leak-88-37", dataLeAk88);
			android.util.Log.d("leak-90-37", dataLeAk90);
			android.util.Log.d("leak-91-37", dataLeAk91);
			android.util.Log.d("leak-92-37", dataLeAk92);
			android.util.Log.d("leak-93-37", dataLeAk93);
			android.util.Log.d("leak-59-6", dataLeAk59);
			android.util.Log.d("leak-61-6", dataLeAk61);
			android.util.Log.d("leak-63-6", dataLeAk63);
			android.util.Log.d("leak-65-6", dataLeAk65);
			android.util.Log.d("leak-67-6", dataLeAk67);
			android.util.Log.d("leak-69-6", dataLeAk69);
			android.util.Log.d("leak-71-6", dataLeAk71);
			android.util.Log.d("leak-73-6", dataLeAk73);
			android.util.Log.d("leak-75-6", dataLeAk75);
			android.util.Log.d("leak-77-6", dataLeAk77);
			android.util.Log.d("leak-79-6", dataLeAk79);
			android.util.Log.d("leak-81-6", dataLeAk81);
			android.util.Log.d("leak-83-6", dataLeAk83);
			android.util.Log.d("leak-85-6", dataLeAk85);
			android.util.Log.d("leak-87-6", dataLeAk87);
			android.util.Log.d("leak-89-6", dataLeAk89);
			activities.clear();

            SQLiteDatabase db = dbHelper.getReadableDatabase();
            Cursor c = db.query(ACTIVITY_TABLE, ACTIVITY_COLUMNS, null, null, null, null, null);

            Activity t;
            if (c.moveToFirst()) {
                do {
                    int tid = c.getInt(0);
                    String[] tids = {String.valueOf(tid)};
                    t = new Activity(c.getString(1), tid);
                    Cursor r = db.rawQuery("SELECT SUM(end) - SUM(start) AS total FROM " + RANGES_TABLE + " WHERE " + ACTIVITY_ID + " = ? AND end NOTNULL " + whereClause, tids);
                    if (r.moveToFirst()) {
                        t.setCollapsed(r.getLong(0));
                    }
                    r.close();
                    if (loadCurrent) {
                        r = db.query(RANGES_TABLE, RANGE_COLUMNS,
                                ACTIVITY_ID + " = ? AND end ISNULL",
                                tids, null, null, null);
                        if (r.moveToFirst()) {
                            t.setStartTime(r.getLong(0));
                        }
                        r.close();
                    }
                    activities.add(t);
                } while (c.moveToNext());
            }
            c.close();
            Collections.sort(activities);
            running = !findCurrentlyActive().isEmpty();
            notifyDataSetChanged();
        }

        /**
         * Don't forget to close the cursor!!
         *
         * @return
         */
        protected Cursor getCurrentRange() {
            dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-15-38", dataLeAk15);
			android.util.Log.d("leak-17-38", dataLeAk17);
			android.util.Log.d("leak-18-38", dataLeAk18);
			android.util.Log.d("leak-19-38", dataLeAk19);
			android.util.Log.d("leak-20-38", dataLeAk20);
			android.util.Log.d("leak-21-38", dataLeAk21);
			android.util.Log.d("leak-22-38", dataLeAk22);
			android.util.Log.d("leak-23-38", dataLeAk23);
			android.util.Log.d("leak-24-38", dataLeAk24);
			android.util.Log.d("leak-25-38", dataLeAk25);
			android.util.Log.d("leak-26-38", dataLeAk26);
			android.util.Log.d("leak-30-38", dataLeAk30);
			android.util.Log.d("leak-31-38", dataLeAk31);
			android.util.Log.d("leak-32-38", dataLeAk32);
			android.util.Log.d("leak-34-38", dataLeAk34);
			android.util.Log.d("leak-36-38", dataLeAk36);
			android.util.Log.d("leak-38-38", dataLeAk38);
			android.util.Log.d("leak-39-38", dataLeAk39);
			android.util.Log.d("leak-40-38", dataLeAk40);
			android.util.Log.d("leak-41-38", dataLeAk41);
			android.util.Log.d("leak-42-38", dataLeAk42);
			android.util.Log.d("leak-43-38", dataLeAk43);
			android.util.Log.d("leak-45-38", dataLeAk45);
			android.util.Log.d("leak-47-38", dataLeAk47);
			android.util.Log.d("leak-49-38", dataLeAk49);
			android.util.Log.d("leak-50-38", dataLeAk50);
			android.util.Log.d("leak-51-38", dataLeAk51);
			android.util.Log.d("leak-52-38", dataLeAk52);
			android.util.Log.d("leak-54-38", dataLeAk54);
			android.util.Log.d("leak-56-38", dataLeAk56);
			android.util.Log.d("leak-58-38", dataLeAk58);
			android.util.Log.d("leak-60-38", dataLeAk60);
			android.util.Log.d("leak-62-38", dataLeAk62);
			android.util.Log.d("leak-64-38", dataLeAk64);
			android.util.Log.d("leak-66-38", dataLeAk66);
			android.util.Log.d("leak-68-38", dataLeAk68);
			android.util.Log.d("leak-70-38", dataLeAk70);
			android.util.Log.d("leak-72-38", dataLeAk72);
			android.util.Log.d("leak-74-38", dataLeAk74);
			android.util.Log.d("leak-76-38", dataLeAk76);
			android.util.Log.d("leak-78-38", dataLeAk78);
			android.util.Log.d("leak-80-38", dataLeAk80);
			android.util.Log.d("leak-82-38", dataLeAk82);
			android.util.Log.d("leak-84-38", dataLeAk84);
			android.util.Log.d("leak-86-38", dataLeAk86);
			android.util.Log.d("leak-88-38", dataLeAk88);
			android.util.Log.d("leak-90-38", dataLeAk90);
			android.util.Log.d("leak-91-38", dataLeAk91);
			android.util.Log.d("leak-92-38", dataLeAk92);
			android.util.Log.d("leak-93-38", dataLeAk93);
			android.util.Log.d("leak-59-7", dataLeAk59);
			android.util.Log.d("leak-61-7", dataLeAk61);
			android.util.Log.d("leak-63-7", dataLeAk63);
			android.util.Log.d("leak-65-7", dataLeAk65);
			android.util.Log.d("leak-67-7", dataLeAk67);
			android.util.Log.d("leak-69-7", dataLeAk69);
			android.util.Log.d("leak-71-7", dataLeAk71);
			android.util.Log.d("leak-73-7", dataLeAk73);
			android.util.Log.d("leak-75-7", dataLeAk75);
			android.util.Log.d("leak-77-7", dataLeAk77);
			android.util.Log.d("leak-79-7", dataLeAk79);
			android.util.Log.d("leak-81-7", dataLeAk81);
			android.util.Log.d("leak-83-7", dataLeAk83);
			android.util.Log.d("leak-85-7", dataLeAk85);
			android.util.Log.d("leak-87-7", dataLeAk87);
			android.util.Log.d("leak-89-7", dataLeAk89);
			String[] res = {""};
            if (currentRangeStart != -1 && currentRangeEnd != -1) {
                Calendar start = Calendar.getInstance();
                start.setFirstDayOfWeek(preferences.getInt(START_DAY, 0) + 1);
                start.setTimeInMillis(currentRangeStart);
                Calendar end = Calendar.getInstance();
                end.setFirstDayOfWeek(preferences.getInt(START_DAY, 0) + 1);
                end.setTimeInMillis(currentRangeEnd);
                res = makeWhereClause(start, end);
            }
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            Cursor r = db.rawQuery("SELECT t.name, r.start, r.end "
                    + " FROM " + ACTIVITY_TABLE + " t, " + RANGES_TABLE + " r "
                    + " WHERE r." + ACTIVITY_ID + " = t.ROWID " + res[0]
                    + " ORDER BY t.name, r.start ASC", null);
            return r;
        }

        public List<Activity> findCurrentlyActive() {
            dataLeAk76 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-15-39", dataLeAk15);
			android.util.Log.d("leak-17-39", dataLeAk17);
			android.util.Log.d("leak-18-39", dataLeAk18);
			android.util.Log.d("leak-19-39", dataLeAk19);
			android.util.Log.d("leak-20-39", dataLeAk20);
			android.util.Log.d("leak-21-39", dataLeAk21);
			android.util.Log.d("leak-22-39", dataLeAk22);
			android.util.Log.d("leak-23-39", dataLeAk23);
			android.util.Log.d("leak-24-39", dataLeAk24);
			android.util.Log.d("leak-25-39", dataLeAk25);
			android.util.Log.d("leak-26-39", dataLeAk26);
			android.util.Log.d("leak-30-39", dataLeAk30);
			android.util.Log.d("leak-31-39", dataLeAk31);
			android.util.Log.d("leak-32-39", dataLeAk32);
			android.util.Log.d("leak-34-39", dataLeAk34);
			android.util.Log.d("leak-36-39", dataLeAk36);
			android.util.Log.d("leak-38-39", dataLeAk38);
			android.util.Log.d("leak-39-39", dataLeAk39);
			android.util.Log.d("leak-40-39", dataLeAk40);
			android.util.Log.d("leak-41-39", dataLeAk41);
			android.util.Log.d("leak-42-39", dataLeAk42);
			android.util.Log.d("leak-43-39", dataLeAk43);
			android.util.Log.d("leak-45-39", dataLeAk45);
			android.util.Log.d("leak-47-39", dataLeAk47);
			android.util.Log.d("leak-49-39", dataLeAk49);
			android.util.Log.d("leak-50-39", dataLeAk50);
			android.util.Log.d("leak-51-39", dataLeAk51);
			android.util.Log.d("leak-52-39", dataLeAk52);
			android.util.Log.d("leak-54-39", dataLeAk54);
			android.util.Log.d("leak-56-39", dataLeAk56);
			android.util.Log.d("leak-58-39", dataLeAk58);
			android.util.Log.d("leak-60-39", dataLeAk60);
			android.util.Log.d("leak-62-39", dataLeAk62);
			android.util.Log.d("leak-64-39", dataLeAk64);
			android.util.Log.d("leak-66-39", dataLeAk66);
			android.util.Log.d("leak-68-39", dataLeAk68);
			android.util.Log.d("leak-70-39", dataLeAk70);
			android.util.Log.d("leak-72-39", dataLeAk72);
			android.util.Log.d("leak-74-39", dataLeAk74);
			android.util.Log.d("leak-76-39", dataLeAk76);
			android.util.Log.d("leak-78-39", dataLeAk78);
			android.util.Log.d("leak-80-39", dataLeAk80);
			android.util.Log.d("leak-82-39", dataLeAk82);
			android.util.Log.d("leak-84-39", dataLeAk84);
			android.util.Log.d("leak-86-39", dataLeAk86);
			android.util.Log.d("leak-88-39", dataLeAk88);
			android.util.Log.d("leak-90-39", dataLeAk90);
			android.util.Log.d("leak-91-39", dataLeAk91);
			android.util.Log.d("leak-92-39", dataLeAk92);
			android.util.Log.d("leak-93-39", dataLeAk93);
			android.util.Log.d("leak-59-8", dataLeAk59);
			android.util.Log.d("leak-61-8", dataLeAk61);
			android.util.Log.d("leak-63-8", dataLeAk63);
			android.util.Log.d("leak-65-8", dataLeAk65);
			android.util.Log.d("leak-67-8", dataLeAk67);
			android.util.Log.d("leak-69-8", dataLeAk69);
			android.util.Log.d("leak-71-8", dataLeAk71);
			android.util.Log.d("leak-73-8", dataLeAk73);
			android.util.Log.d("leak-75-8", dataLeAk75);
			android.util.Log.d("leak-77-8", dataLeAk77);
			android.util.Log.d("leak-79-8", dataLeAk79);
			android.util.Log.d("leak-81-8", dataLeAk81);
			android.util.Log.d("leak-83-8", dataLeAk83);
			android.util.Log.d("leak-85-8", dataLeAk85);
			android.util.Log.d("leak-87-8", dataLeAk87);
			android.util.Log.d("leak-89-8", dataLeAk89);
			List<Activity> activeActivities = new ArrayList<Activity>();
            for (Activity a : activities) {
                if (a.isRunning()) {
                    activeActivities.add(a);
                }
            }
            return activeActivities;
        }

        protected void addActivity(String name) {
            dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-15-40", dataLeAk15);
			android.util.Log.d("leak-17-40", dataLeAk17);
			android.util.Log.d("leak-18-40", dataLeAk18);
			android.util.Log.d("leak-19-40", dataLeAk19);
			android.util.Log.d("leak-20-40", dataLeAk20);
			android.util.Log.d("leak-21-40", dataLeAk21);
			android.util.Log.d("leak-22-40", dataLeAk22);
			android.util.Log.d("leak-23-40", dataLeAk23);
			android.util.Log.d("leak-24-40", dataLeAk24);
			android.util.Log.d("leak-25-40", dataLeAk25);
			android.util.Log.d("leak-26-40", dataLeAk26);
			android.util.Log.d("leak-30-40", dataLeAk30);
			android.util.Log.d("leak-31-40", dataLeAk31);
			android.util.Log.d("leak-32-40", dataLeAk32);
			android.util.Log.d("leak-34-40", dataLeAk34);
			android.util.Log.d("leak-36-40", dataLeAk36);
			android.util.Log.d("leak-38-40", dataLeAk38);
			android.util.Log.d("leak-39-40", dataLeAk39);
			android.util.Log.d("leak-40-40", dataLeAk40);
			android.util.Log.d("leak-41-40", dataLeAk41);
			android.util.Log.d("leak-42-40", dataLeAk42);
			android.util.Log.d("leak-43-40", dataLeAk43);
			android.util.Log.d("leak-45-40", dataLeAk45);
			android.util.Log.d("leak-47-40", dataLeAk47);
			android.util.Log.d("leak-49-40", dataLeAk49);
			android.util.Log.d("leak-50-40", dataLeAk50);
			android.util.Log.d("leak-51-40", dataLeAk51);
			android.util.Log.d("leak-52-40", dataLeAk52);
			android.util.Log.d("leak-54-40", dataLeAk54);
			android.util.Log.d("leak-56-40", dataLeAk56);
			android.util.Log.d("leak-58-40", dataLeAk58);
			android.util.Log.d("leak-60-40", dataLeAk60);
			android.util.Log.d("leak-62-40", dataLeAk62);
			android.util.Log.d("leak-64-40", dataLeAk64);
			android.util.Log.d("leak-66-40", dataLeAk66);
			android.util.Log.d("leak-68-40", dataLeAk68);
			android.util.Log.d("leak-70-40", dataLeAk70);
			android.util.Log.d("leak-72-40", dataLeAk72);
			android.util.Log.d("leak-74-40", dataLeAk74);
			android.util.Log.d("leak-76-40", dataLeAk76);
			android.util.Log.d("leak-78-40", dataLeAk78);
			android.util.Log.d("leak-80-40", dataLeAk80);
			android.util.Log.d("leak-82-40", dataLeAk82);
			android.util.Log.d("leak-84-40", dataLeAk84);
			android.util.Log.d("leak-86-40", dataLeAk86);
			android.util.Log.d("leak-88-40", dataLeAk88);
			android.util.Log.d("leak-90-40", dataLeAk90);
			android.util.Log.d("leak-91-40", dataLeAk91);
			android.util.Log.d("leak-92-40", dataLeAk92);
			android.util.Log.d("leak-93-40", dataLeAk93);
			android.util.Log.d("leak-59-9", dataLeAk59);
			android.util.Log.d("leak-61-9", dataLeAk61);
			android.util.Log.d("leak-63-9", dataLeAk63);
			android.util.Log.d("leak-65-9", dataLeAk65);
			android.util.Log.d("leak-67-9", dataLeAk67);
			android.util.Log.d("leak-69-9", dataLeAk69);
			android.util.Log.d("leak-71-9", dataLeAk71);
			android.util.Log.d("leak-73-9", dataLeAk73);
			android.util.Log.d("leak-75-9", dataLeAk75);
			android.util.Log.d("leak-77-9", dataLeAk77);
			android.util.Log.d("leak-79-9", dataLeAk79);
			android.util.Log.d("leak-81-9", dataLeAk81);
			android.util.Log.d("leak-83-9", dataLeAk83);
			android.util.Log.d("leak-85-9", dataLeAk85);
			android.util.Log.d("leak-87-9", dataLeAk87);
			android.util.Log.d("leak-89-9", dataLeAk89);
			SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(NAME, name);
            long id = db.insert(ACTIVITY_TABLE, NAME, values);
            Activity t = new Activity(name, (int) id);
            activities.add(t);
            Collections.sort(activities);
            notifyDataSetChanged();
        }

        protected void updateActivity(Activity t) {
            dataLeAk80 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk79 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-15-41", dataLeAk15);
			android.util.Log.d("leak-17-41", dataLeAk17);
			android.util.Log.d("leak-18-41", dataLeAk18);
			android.util.Log.d("leak-19-41", dataLeAk19);
			android.util.Log.d("leak-20-41", dataLeAk20);
			android.util.Log.d("leak-21-41", dataLeAk21);
			android.util.Log.d("leak-22-41", dataLeAk22);
			android.util.Log.d("leak-23-41", dataLeAk23);
			android.util.Log.d("leak-24-41", dataLeAk24);
			android.util.Log.d("leak-25-41", dataLeAk25);
			android.util.Log.d("leak-26-41", dataLeAk26);
			android.util.Log.d("leak-30-41", dataLeAk30);
			android.util.Log.d("leak-31-41", dataLeAk31);
			android.util.Log.d("leak-32-41", dataLeAk32);
			android.util.Log.d("leak-34-41", dataLeAk34);
			android.util.Log.d("leak-36-41", dataLeAk36);
			android.util.Log.d("leak-38-41", dataLeAk38);
			android.util.Log.d("leak-39-41", dataLeAk39);
			android.util.Log.d("leak-40-41", dataLeAk40);
			android.util.Log.d("leak-41-41", dataLeAk41);
			android.util.Log.d("leak-42-41", dataLeAk42);
			android.util.Log.d("leak-43-41", dataLeAk43);
			android.util.Log.d("leak-45-41", dataLeAk45);
			android.util.Log.d("leak-47-41", dataLeAk47);
			android.util.Log.d("leak-49-41", dataLeAk49);
			android.util.Log.d("leak-50-41", dataLeAk50);
			android.util.Log.d("leak-51-41", dataLeAk51);
			android.util.Log.d("leak-52-41", dataLeAk52);
			android.util.Log.d("leak-54-41", dataLeAk54);
			android.util.Log.d("leak-56-41", dataLeAk56);
			android.util.Log.d("leak-58-41", dataLeAk58);
			android.util.Log.d("leak-60-41", dataLeAk60);
			android.util.Log.d("leak-62-41", dataLeAk62);
			android.util.Log.d("leak-64-41", dataLeAk64);
			android.util.Log.d("leak-66-41", dataLeAk66);
			android.util.Log.d("leak-68-41", dataLeAk68);
			android.util.Log.d("leak-70-41", dataLeAk70);
			android.util.Log.d("leak-72-41", dataLeAk72);
			android.util.Log.d("leak-74-41", dataLeAk74);
			android.util.Log.d("leak-76-41", dataLeAk76);
			android.util.Log.d("leak-78-41", dataLeAk78);
			android.util.Log.d("leak-80-41", dataLeAk80);
			android.util.Log.d("leak-82-41", dataLeAk82);
			android.util.Log.d("leak-84-41", dataLeAk84);
			android.util.Log.d("leak-86-41", dataLeAk86);
			android.util.Log.d("leak-88-41", dataLeAk88);
			android.util.Log.d("leak-90-41", dataLeAk90);
			android.util.Log.d("leak-91-41", dataLeAk91);
			android.util.Log.d("leak-92-41", dataLeAk92);
			android.util.Log.d("leak-93-41", dataLeAk93);
			android.util.Log.d("leak-59-10", dataLeAk59);
			android.util.Log.d("leak-61-10", dataLeAk61);
			android.util.Log.d("leak-63-10", dataLeAk63);
			android.util.Log.d("leak-65-10", dataLeAk65);
			android.util.Log.d("leak-67-10", dataLeAk67);
			android.util.Log.d("leak-69-10", dataLeAk69);
			android.util.Log.d("leak-71-10", dataLeAk71);
			android.util.Log.d("leak-73-10", dataLeAk73);
			android.util.Log.d("leak-75-10", dataLeAk75);
			android.util.Log.d("leak-77-10", dataLeAk77);
			android.util.Log.d("leak-79-10", dataLeAk79);
			android.util.Log.d("leak-81-10", dataLeAk81);
			android.util.Log.d("leak-83-10", dataLeAk83);
			android.util.Log.d("leak-85-10", dataLeAk85);
			android.util.Log.d("leak-87-10", dataLeAk87);
			android.util.Log.d("leak-89-10", dataLeAk89);
			SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(NAME, t.getName());
            String id = String.valueOf(t.getId());
            String[] vals = {id};
            db.update(ACTIVITY_TABLE, values, "ROWID = ?", vals);

            if (t.getStartTime() != NULL) {
                values.clear();
                long startTime = t.getStartTime();
                values.put(START, startTime);
                vals = new String[]{id, String.valueOf(startTime)};
                if (t.getEndTime() != NULL) {
                    values.put(END, t.getEndTime());
                }
                // If an update fails, then this is an insert
                if (db.update(RANGES_TABLE, values, ACTIVITY_ID + " = ? AND " + START + " = ?", vals) == 0) {
                    values.put(ACTIVITY_ID, t.getId());
                    db.insert(RANGES_TABLE, END, values);
                }
            }

            Collections.sort(activities);
            notifyDataSetChanged();
        }

        public void deleteActivity(Activity t) {
            dataLeAk82 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk81 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-15-42", dataLeAk15);
			android.util.Log.d("leak-17-42", dataLeAk17);
			android.util.Log.d("leak-18-42", dataLeAk18);
			android.util.Log.d("leak-19-42", dataLeAk19);
			android.util.Log.d("leak-20-42", dataLeAk20);
			android.util.Log.d("leak-21-42", dataLeAk21);
			android.util.Log.d("leak-22-42", dataLeAk22);
			android.util.Log.d("leak-23-42", dataLeAk23);
			android.util.Log.d("leak-24-42", dataLeAk24);
			android.util.Log.d("leak-25-42", dataLeAk25);
			android.util.Log.d("leak-26-42", dataLeAk26);
			android.util.Log.d("leak-30-42", dataLeAk30);
			android.util.Log.d("leak-31-42", dataLeAk31);
			android.util.Log.d("leak-32-42", dataLeAk32);
			android.util.Log.d("leak-34-42", dataLeAk34);
			android.util.Log.d("leak-36-42", dataLeAk36);
			android.util.Log.d("leak-38-42", dataLeAk38);
			android.util.Log.d("leak-39-42", dataLeAk39);
			android.util.Log.d("leak-40-42", dataLeAk40);
			android.util.Log.d("leak-41-42", dataLeAk41);
			android.util.Log.d("leak-42-42", dataLeAk42);
			android.util.Log.d("leak-43-42", dataLeAk43);
			android.util.Log.d("leak-45-42", dataLeAk45);
			android.util.Log.d("leak-47-42", dataLeAk47);
			android.util.Log.d("leak-49-42", dataLeAk49);
			android.util.Log.d("leak-50-42", dataLeAk50);
			android.util.Log.d("leak-51-42", dataLeAk51);
			android.util.Log.d("leak-52-42", dataLeAk52);
			android.util.Log.d("leak-54-42", dataLeAk54);
			android.util.Log.d("leak-56-42", dataLeAk56);
			android.util.Log.d("leak-58-42", dataLeAk58);
			android.util.Log.d("leak-60-42", dataLeAk60);
			android.util.Log.d("leak-62-42", dataLeAk62);
			android.util.Log.d("leak-64-42", dataLeAk64);
			android.util.Log.d("leak-66-42", dataLeAk66);
			android.util.Log.d("leak-68-42", dataLeAk68);
			android.util.Log.d("leak-70-42", dataLeAk70);
			android.util.Log.d("leak-72-42", dataLeAk72);
			android.util.Log.d("leak-74-42", dataLeAk74);
			android.util.Log.d("leak-76-42", dataLeAk76);
			android.util.Log.d("leak-78-42", dataLeAk78);
			android.util.Log.d("leak-80-42", dataLeAk80);
			android.util.Log.d("leak-82-42", dataLeAk82);
			android.util.Log.d("leak-84-42", dataLeAk84);
			android.util.Log.d("leak-86-42", dataLeAk86);
			android.util.Log.d("leak-88-42", dataLeAk88);
			android.util.Log.d("leak-90-42", dataLeAk90);
			android.util.Log.d("leak-91-42", dataLeAk91);
			android.util.Log.d("leak-92-42", dataLeAk92);
			android.util.Log.d("leak-93-42", dataLeAk93);
			android.util.Log.d("leak-59-11", dataLeAk59);
			android.util.Log.d("leak-61-11", dataLeAk61);
			android.util.Log.d("leak-63-11", dataLeAk63);
			android.util.Log.d("leak-65-11", dataLeAk65);
			android.util.Log.d("leak-67-11", dataLeAk67);
			android.util.Log.d("leak-69-11", dataLeAk69);
			android.util.Log.d("leak-71-11", dataLeAk71);
			android.util.Log.d("leak-73-11", dataLeAk73);
			android.util.Log.d("leak-75-11", dataLeAk75);
			android.util.Log.d("leak-77-11", dataLeAk77);
			android.util.Log.d("leak-79-11", dataLeAk79);
			android.util.Log.d("leak-81-11", dataLeAk81);
			android.util.Log.d("leak-83-11", dataLeAk83);
			android.util.Log.d("leak-85-11", dataLeAk85);
			android.util.Log.d("leak-87-11", dataLeAk87);
			android.util.Log.d("leak-89-11", dataLeAk89);
			activities.remove(t);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            String[] id = {String.valueOf(t.getId())};
            db.delete(ACTIVITY_TABLE, "ROWID = ?", id);
            db.delete(RANGES_TABLE, ACTIVITY_ID + " = ?", id);
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            dataLeAk84 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk83 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-15-43", dataLeAk15);
			android.util.Log.d("leak-17-43", dataLeAk17);
			android.util.Log.d("leak-18-43", dataLeAk18);
			android.util.Log.d("leak-19-43", dataLeAk19);
			android.util.Log.d("leak-20-43", dataLeAk20);
			android.util.Log.d("leak-21-43", dataLeAk21);
			android.util.Log.d("leak-22-43", dataLeAk22);
			android.util.Log.d("leak-23-43", dataLeAk23);
			android.util.Log.d("leak-24-43", dataLeAk24);
			android.util.Log.d("leak-25-43", dataLeAk25);
			android.util.Log.d("leak-26-43", dataLeAk26);
			android.util.Log.d("leak-30-43", dataLeAk30);
			android.util.Log.d("leak-31-43", dataLeAk31);
			android.util.Log.d("leak-32-43", dataLeAk32);
			android.util.Log.d("leak-34-43", dataLeAk34);
			android.util.Log.d("leak-36-43", dataLeAk36);
			android.util.Log.d("leak-38-43", dataLeAk38);
			android.util.Log.d("leak-39-43", dataLeAk39);
			android.util.Log.d("leak-40-43", dataLeAk40);
			android.util.Log.d("leak-41-43", dataLeAk41);
			android.util.Log.d("leak-42-43", dataLeAk42);
			android.util.Log.d("leak-43-43", dataLeAk43);
			android.util.Log.d("leak-45-43", dataLeAk45);
			android.util.Log.d("leak-47-43", dataLeAk47);
			android.util.Log.d("leak-49-43", dataLeAk49);
			android.util.Log.d("leak-50-43", dataLeAk50);
			android.util.Log.d("leak-51-43", dataLeAk51);
			android.util.Log.d("leak-52-43", dataLeAk52);
			android.util.Log.d("leak-54-43", dataLeAk54);
			android.util.Log.d("leak-56-43", dataLeAk56);
			android.util.Log.d("leak-58-43", dataLeAk58);
			android.util.Log.d("leak-60-43", dataLeAk60);
			android.util.Log.d("leak-62-43", dataLeAk62);
			android.util.Log.d("leak-64-43", dataLeAk64);
			android.util.Log.d("leak-66-43", dataLeAk66);
			android.util.Log.d("leak-68-43", dataLeAk68);
			android.util.Log.d("leak-70-43", dataLeAk70);
			android.util.Log.d("leak-72-43", dataLeAk72);
			android.util.Log.d("leak-74-43", dataLeAk74);
			android.util.Log.d("leak-76-43", dataLeAk76);
			android.util.Log.d("leak-78-43", dataLeAk78);
			android.util.Log.d("leak-80-43", dataLeAk80);
			android.util.Log.d("leak-82-43", dataLeAk82);
			android.util.Log.d("leak-84-43", dataLeAk84);
			android.util.Log.d("leak-86-43", dataLeAk86);
			android.util.Log.d("leak-88-43", dataLeAk88);
			android.util.Log.d("leak-90-43", dataLeAk90);
			android.util.Log.d("leak-91-43", dataLeAk91);
			android.util.Log.d("leak-92-43", dataLeAk92);
			android.util.Log.d("leak-93-43", dataLeAk93);
			android.util.Log.d("leak-59-12", dataLeAk59);
			android.util.Log.d("leak-61-12", dataLeAk61);
			android.util.Log.d("leak-63-12", dataLeAk63);
			android.util.Log.d("leak-65-12", dataLeAk65);
			android.util.Log.d("leak-67-12", dataLeAk67);
			android.util.Log.d("leak-69-12", dataLeAk69);
			android.util.Log.d("leak-71-12", dataLeAk71);
			android.util.Log.d("leak-73-12", dataLeAk73);
			android.util.Log.d("leak-75-12", dataLeAk75);
			android.util.Log.d("leak-77-12", dataLeAk77);
			android.util.Log.d("leak-79-12", dataLeAk79);
			android.util.Log.d("leak-81-12", dataLeAk81);
			android.util.Log.d("leak-83-12", dataLeAk83);
			android.util.Log.d("leak-85-12", dataLeAk85);
			android.util.Log.d("leak-87-12", dataLeAk87);
			android.util.Log.d("leak-89-12", dataLeAk89);
			return activities.size();
        }

        @Override
        public Object getItem(int position) {
            dataLeAk86 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk85 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-15-44", dataLeAk15);
			android.util.Log.d("leak-17-44", dataLeAk17);
			android.util.Log.d("leak-18-44", dataLeAk18);
			android.util.Log.d("leak-19-44", dataLeAk19);
			android.util.Log.d("leak-20-44", dataLeAk20);
			android.util.Log.d("leak-21-44", dataLeAk21);
			android.util.Log.d("leak-22-44", dataLeAk22);
			android.util.Log.d("leak-23-44", dataLeAk23);
			android.util.Log.d("leak-24-44", dataLeAk24);
			android.util.Log.d("leak-25-44", dataLeAk25);
			android.util.Log.d("leak-26-44", dataLeAk26);
			android.util.Log.d("leak-30-44", dataLeAk30);
			android.util.Log.d("leak-31-44", dataLeAk31);
			android.util.Log.d("leak-32-44", dataLeAk32);
			android.util.Log.d("leak-34-44", dataLeAk34);
			android.util.Log.d("leak-36-44", dataLeAk36);
			android.util.Log.d("leak-38-44", dataLeAk38);
			android.util.Log.d("leak-39-44", dataLeAk39);
			android.util.Log.d("leak-40-44", dataLeAk40);
			android.util.Log.d("leak-41-44", dataLeAk41);
			android.util.Log.d("leak-42-44", dataLeAk42);
			android.util.Log.d("leak-43-44", dataLeAk43);
			android.util.Log.d("leak-45-44", dataLeAk45);
			android.util.Log.d("leak-47-44", dataLeAk47);
			android.util.Log.d("leak-49-44", dataLeAk49);
			android.util.Log.d("leak-50-44", dataLeAk50);
			android.util.Log.d("leak-51-44", dataLeAk51);
			android.util.Log.d("leak-52-44", dataLeAk52);
			android.util.Log.d("leak-54-44", dataLeAk54);
			android.util.Log.d("leak-56-44", dataLeAk56);
			android.util.Log.d("leak-58-44", dataLeAk58);
			android.util.Log.d("leak-60-44", dataLeAk60);
			android.util.Log.d("leak-62-44", dataLeAk62);
			android.util.Log.d("leak-64-44", dataLeAk64);
			android.util.Log.d("leak-66-44", dataLeAk66);
			android.util.Log.d("leak-68-44", dataLeAk68);
			android.util.Log.d("leak-70-44", dataLeAk70);
			android.util.Log.d("leak-72-44", dataLeAk72);
			android.util.Log.d("leak-74-44", dataLeAk74);
			android.util.Log.d("leak-76-44", dataLeAk76);
			android.util.Log.d("leak-78-44", dataLeAk78);
			android.util.Log.d("leak-80-44", dataLeAk80);
			android.util.Log.d("leak-82-44", dataLeAk82);
			android.util.Log.d("leak-84-44", dataLeAk84);
			android.util.Log.d("leak-86-44", dataLeAk86);
			android.util.Log.d("leak-88-44", dataLeAk88);
			android.util.Log.d("leak-90-44", dataLeAk90);
			android.util.Log.d("leak-91-44", dataLeAk91);
			android.util.Log.d("leak-92-44", dataLeAk92);
			android.util.Log.d("leak-93-44", dataLeAk93);
			android.util.Log.d("leak-59-13", dataLeAk59);
			android.util.Log.d("leak-61-13", dataLeAk61);
			android.util.Log.d("leak-63-13", dataLeAk63);
			android.util.Log.d("leak-65-13", dataLeAk65);
			android.util.Log.d("leak-67-13", dataLeAk67);
			android.util.Log.d("leak-69-13", dataLeAk69);
			android.util.Log.d("leak-71-13", dataLeAk71);
			android.util.Log.d("leak-73-13", dataLeAk73);
			android.util.Log.d("leak-75-13", dataLeAk75);
			android.util.Log.d("leak-77-13", dataLeAk77);
			android.util.Log.d("leak-79-13", dataLeAk79);
			android.util.Log.d("leak-81-13", dataLeAk81);
			android.util.Log.d("leak-83-13", dataLeAk83);
			android.util.Log.d("leak-85-13", dataLeAk85);
			android.util.Log.d("leak-87-13", dataLeAk87);
			android.util.Log.d("leak-89-13", dataLeAk89);
			return activities.get(position);
        }

        @Override
        public long getItemId(int position) {
            dataLeAk88 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk87 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-15-45", dataLeAk15);
			android.util.Log.d("leak-17-45", dataLeAk17);
			android.util.Log.d("leak-18-45", dataLeAk18);
			android.util.Log.d("leak-19-45", dataLeAk19);
			android.util.Log.d("leak-20-45", dataLeAk20);
			android.util.Log.d("leak-21-45", dataLeAk21);
			android.util.Log.d("leak-22-45", dataLeAk22);
			android.util.Log.d("leak-23-45", dataLeAk23);
			android.util.Log.d("leak-24-45", dataLeAk24);
			android.util.Log.d("leak-25-45", dataLeAk25);
			android.util.Log.d("leak-26-45", dataLeAk26);
			android.util.Log.d("leak-30-45", dataLeAk30);
			android.util.Log.d("leak-31-45", dataLeAk31);
			android.util.Log.d("leak-32-45", dataLeAk32);
			android.util.Log.d("leak-34-45", dataLeAk34);
			android.util.Log.d("leak-36-45", dataLeAk36);
			android.util.Log.d("leak-38-45", dataLeAk38);
			android.util.Log.d("leak-39-45", dataLeAk39);
			android.util.Log.d("leak-40-45", dataLeAk40);
			android.util.Log.d("leak-41-45", dataLeAk41);
			android.util.Log.d("leak-42-45", dataLeAk42);
			android.util.Log.d("leak-43-45", dataLeAk43);
			android.util.Log.d("leak-45-45", dataLeAk45);
			android.util.Log.d("leak-47-45", dataLeAk47);
			android.util.Log.d("leak-49-45", dataLeAk49);
			android.util.Log.d("leak-50-45", dataLeAk50);
			android.util.Log.d("leak-51-45", dataLeAk51);
			android.util.Log.d("leak-52-45", dataLeAk52);
			android.util.Log.d("leak-54-45", dataLeAk54);
			android.util.Log.d("leak-56-45", dataLeAk56);
			android.util.Log.d("leak-58-45", dataLeAk58);
			android.util.Log.d("leak-60-45", dataLeAk60);
			android.util.Log.d("leak-62-45", dataLeAk62);
			android.util.Log.d("leak-64-45", dataLeAk64);
			android.util.Log.d("leak-66-45", dataLeAk66);
			android.util.Log.d("leak-68-45", dataLeAk68);
			android.util.Log.d("leak-70-45", dataLeAk70);
			android.util.Log.d("leak-72-45", dataLeAk72);
			android.util.Log.d("leak-74-45", dataLeAk74);
			android.util.Log.d("leak-76-45", dataLeAk76);
			android.util.Log.d("leak-78-45", dataLeAk78);
			android.util.Log.d("leak-80-45", dataLeAk80);
			android.util.Log.d("leak-82-45", dataLeAk82);
			android.util.Log.d("leak-84-45", dataLeAk84);
			android.util.Log.d("leak-86-45", dataLeAk86);
			android.util.Log.d("leak-88-45", dataLeAk88);
			android.util.Log.d("leak-90-45", dataLeAk90);
			android.util.Log.d("leak-91-45", dataLeAk91);
			android.util.Log.d("leak-92-45", dataLeAk92);
			android.util.Log.d("leak-93-45", dataLeAk93);
			android.util.Log.d("leak-59-14", dataLeAk59);
			android.util.Log.d("leak-61-14", dataLeAk61);
			android.util.Log.d("leak-63-14", dataLeAk63);
			android.util.Log.d("leak-65-14", dataLeAk65);
			android.util.Log.d("leak-67-14", dataLeAk67);
			android.util.Log.d("leak-69-14", dataLeAk69);
			android.util.Log.d("leak-71-14", dataLeAk71);
			android.util.Log.d("leak-73-14", dataLeAk73);
			android.util.Log.d("leak-75-14", dataLeAk75);
			android.util.Log.d("leak-77-14", dataLeAk77);
			android.util.Log.d("leak-79-14", dataLeAk79);
			android.util.Log.d("leak-81-14", dataLeAk81);
			android.util.Log.d("leak-83-14", dataLeAk83);
			android.util.Log.d("leak-85-14", dataLeAk85);
			android.util.Log.d("leak-87-14", dataLeAk87);
			android.util.Log.d("leak-89-14", dataLeAk89);
			return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            dataLeAk90 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk89 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-15-46", dataLeAk15);
			android.util.Log.d("leak-17-46", dataLeAk17);
			android.util.Log.d("leak-18-46", dataLeAk18);
			android.util.Log.d("leak-19-46", dataLeAk19);
			android.util.Log.d("leak-20-46", dataLeAk20);
			android.util.Log.d("leak-21-46", dataLeAk21);
			android.util.Log.d("leak-22-46", dataLeAk22);
			android.util.Log.d("leak-23-46", dataLeAk23);
			android.util.Log.d("leak-24-46", dataLeAk24);
			android.util.Log.d("leak-25-46", dataLeAk25);
			android.util.Log.d("leak-26-46", dataLeAk26);
			android.util.Log.d("leak-30-46", dataLeAk30);
			android.util.Log.d("leak-31-46", dataLeAk31);
			android.util.Log.d("leak-32-46", dataLeAk32);
			android.util.Log.d("leak-34-46", dataLeAk34);
			android.util.Log.d("leak-36-46", dataLeAk36);
			android.util.Log.d("leak-38-46", dataLeAk38);
			android.util.Log.d("leak-39-46", dataLeAk39);
			android.util.Log.d("leak-40-46", dataLeAk40);
			android.util.Log.d("leak-41-46", dataLeAk41);
			android.util.Log.d("leak-42-46", dataLeAk42);
			android.util.Log.d("leak-43-46", dataLeAk43);
			android.util.Log.d("leak-45-46", dataLeAk45);
			android.util.Log.d("leak-47-46", dataLeAk47);
			android.util.Log.d("leak-49-46", dataLeAk49);
			android.util.Log.d("leak-50-46", dataLeAk50);
			android.util.Log.d("leak-51-46", dataLeAk51);
			android.util.Log.d("leak-52-46", dataLeAk52);
			android.util.Log.d("leak-54-46", dataLeAk54);
			android.util.Log.d("leak-56-46", dataLeAk56);
			android.util.Log.d("leak-58-46", dataLeAk58);
			android.util.Log.d("leak-60-46", dataLeAk60);
			android.util.Log.d("leak-62-46", dataLeAk62);
			android.util.Log.d("leak-64-46", dataLeAk64);
			android.util.Log.d("leak-66-46", dataLeAk66);
			android.util.Log.d("leak-68-46", dataLeAk68);
			android.util.Log.d("leak-70-46", dataLeAk70);
			android.util.Log.d("leak-72-46", dataLeAk72);
			android.util.Log.d("leak-74-46", dataLeAk74);
			android.util.Log.d("leak-76-46", dataLeAk76);
			android.util.Log.d("leak-78-46", dataLeAk78);
			android.util.Log.d("leak-80-46", dataLeAk80);
			android.util.Log.d("leak-82-46", dataLeAk82);
			android.util.Log.d("leak-84-46", dataLeAk84);
			android.util.Log.d("leak-86-46", dataLeAk86);
			android.util.Log.d("leak-88-46", dataLeAk88);
			android.util.Log.d("leak-90-46", dataLeAk90);
			android.util.Log.d("leak-91-46", dataLeAk91);
			android.util.Log.d("leak-92-46", dataLeAk92);
			android.util.Log.d("leak-93-46", dataLeAk93);
			android.util.Log.d("leak-59-15", dataLeAk59);
			android.util.Log.d("leak-61-15", dataLeAk61);
			android.util.Log.d("leak-63-15", dataLeAk63);
			android.util.Log.d("leak-65-15", dataLeAk65);
			android.util.Log.d("leak-67-15", dataLeAk67);
			android.util.Log.d("leak-69-15", dataLeAk69);
			android.util.Log.d("leak-71-15", dataLeAk71);
			android.util.Log.d("leak-73-15", dataLeAk73);
			android.util.Log.d("leak-75-15", dataLeAk75);
			android.util.Log.d("leak-77-15", dataLeAk77);
			android.util.Log.d("leak-79-15", dataLeAk79);
			android.util.Log.d("leak-81-15", dataLeAk81);
			android.util.Log.d("leak-83-15", dataLeAk83);
			android.util.Log.d("leak-85-15", dataLeAk85);
			android.util.Log.d("leak-87-15", dataLeAk87);
			android.util.Log.d("leak-89-15", dataLeAk89);
			ActivityView view = null;
            if (convertView == null) {
                Object item = getItem(position);
                if (item != null) {
                    view = new ActivityView(savedContext, (Activity) item);
                }
            } else {
                view = (ActivityView) convertView;
                Object item = getItem(position);
                if (item != null) {
                    view.setActivity((Activity) item);
                }
            }
            return view;
        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        if (vibrateClick) {
            vibrateAgent.vibrate(100);
        }
		dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-15-47", dataLeAk15);
		android.util.Log.d("leak-17-47", dataLeAk17);
		android.util.Log.d("leak-18-47", dataLeAk18);
		android.util.Log.d("leak-19-47", dataLeAk19);
		android.util.Log.d("leak-20-47", dataLeAk20);
		android.util.Log.d("leak-21-47", dataLeAk21);
		android.util.Log.d("leak-22-47", dataLeAk22);
		android.util.Log.d("leak-23-47", dataLeAk23);
		android.util.Log.d("leak-24-47", dataLeAk24);
		android.util.Log.d("leak-25-47", dataLeAk25);
		android.util.Log.d("leak-26-47", dataLeAk26);
		android.util.Log.d("leak-30-47", dataLeAk30);
		android.util.Log.d("leak-31-47", dataLeAk31);
		android.util.Log.d("leak-32-47", dataLeAk32);
		android.util.Log.d("leak-34-47", dataLeAk34);
		android.util.Log.d("leak-36-47", dataLeAk36);
		android.util.Log.d("leak-38-47", dataLeAk38);
		android.util.Log.d("leak-39-47", dataLeAk39);
		android.util.Log.d("leak-40-47", dataLeAk40);
		android.util.Log.d("leak-41-47", dataLeAk41);
		android.util.Log.d("leak-42-47", dataLeAk42);
		android.util.Log.d("leak-43-47", dataLeAk43);
		android.util.Log.d("leak-45-47", dataLeAk45);
		android.util.Log.d("leak-47-47", dataLeAk47);
		android.util.Log.d("leak-49-47", dataLeAk49);
		android.util.Log.d("leak-50-47", dataLeAk50);
		android.util.Log.d("leak-51-47", dataLeAk51);
		android.util.Log.d("leak-52-47", dataLeAk52);
		android.util.Log.d("leak-54-47", dataLeAk54);
		android.util.Log.d("leak-56-47", dataLeAk56);
		android.util.Log.d("leak-58-47", dataLeAk58);
		android.util.Log.d("leak-60-47", dataLeAk60);
		android.util.Log.d("leak-62-47", dataLeAk62);
		android.util.Log.d("leak-64-47", dataLeAk64);
		android.util.Log.d("leak-66-47", dataLeAk66);
		android.util.Log.d("leak-68-47", dataLeAk68);
		android.util.Log.d("leak-70-47", dataLeAk70);
		android.util.Log.d("leak-72-47", dataLeAk72);
		android.util.Log.d("leak-74-47", dataLeAk74);
		android.util.Log.d("leak-76-47", dataLeAk76);
		android.util.Log.d("leak-78-47", dataLeAk78);
		android.util.Log.d("leak-80-47", dataLeAk80);
		android.util.Log.d("leak-82-47", dataLeAk82);
		android.util.Log.d("leak-84-47", dataLeAk84);
		android.util.Log.d("leak-86-47", dataLeAk86);
		android.util.Log.d("leak-88-47", dataLeAk88);
		android.util.Log.d("leak-90-47", dataLeAk90);
		android.util.Log.d("leak-91-47", dataLeAk91);
		android.util.Log.d("leak-92-47", dataLeAk92);
		android.util.Log.d("leak-93-47", dataLeAk93);
        if (playClick) {
            try {
                //clickPlayer.prepare();
                clickPlayer.start();
            } catch (IllegalStateException exception) {
                // Ignore this; it is probably because the media isn't yet ready.
                // There's nothing the user can do about it.
                // ignore this.  There's nothing the user can do about it.
                Logger.getLogger("TimeTracker").log(Level.INFO,
                        "Failed to play audio: {0}", exception.getMessage());
            }
        }

        // Stop the update.  If a activity is already running and we're stopping
        // the timer, it'll stay stopped.  If a activity is already running and 
        // we're switching to a new activity, or if nothing is running and we're
        // starting a new timer, then it'll be restarted.

        Object item = getListView().getItemAtPosition(position);
        if (item != null) {
            Activity selected = (Activity) item;
            if (!concurrency) {
                boolean startSelected = !selected.isRunning();
                if (running) {
                    running = false;
                    timer.removeCallbacks(updater);
                    // Disable currently running activities
                    for (Activity a : adapter.findCurrentlyActive()) {
                        a.stop();
                        adapter.updateActivity(a);
                    }
                }
                if (startSelected) {
                    selected.start();
                    running = true;
                    timer.post(updater);
                }
            } else {
                if (selected.isRunning()) {
                    selected.stop();
                    running = !adapter.findCurrentlyActive().isEmpty();
                    if (!running) {
                        timer.removeCallbacks(updater);
                    }
                } else {
                    selected.start();
                    if (!running) {
                        running = true;
                        timer.post(updater);
                    }
                }
            }
            adapter.updateActivity(selected);
        }
        getListView().invalidate();
        super.onListItemClick(l, v, position, id);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-15-48", dataLeAk15);
		android.util.Log.d("leak-17-48", dataLeAk17);
		android.util.Log.d("leak-18-48", dataLeAk18);
		android.util.Log.d("leak-19-48", dataLeAk19);
		android.util.Log.d("leak-20-48", dataLeAk20);
		android.util.Log.d("leak-21-48", dataLeAk21);
		android.util.Log.d("leak-22-48", dataLeAk22);
		android.util.Log.d("leak-23-48", dataLeAk23);
		android.util.Log.d("leak-24-48", dataLeAk24);
		android.util.Log.d("leak-25-48", dataLeAk25);
		android.util.Log.d("leak-26-48", dataLeAk26);
		android.util.Log.d("leak-30-48", dataLeAk30);
		android.util.Log.d("leak-31-48", dataLeAk31);
		android.util.Log.d("leak-32-48", dataLeAk32);
		android.util.Log.d("leak-34-48", dataLeAk34);
		android.util.Log.d("leak-36-48", dataLeAk36);
		android.util.Log.d("leak-38-48", dataLeAk38);
		android.util.Log.d("leak-39-48", dataLeAk39);
		android.util.Log.d("leak-40-48", dataLeAk40);
		android.util.Log.d("leak-41-48", dataLeAk41);
		android.util.Log.d("leak-42-48", dataLeAk42);
		android.util.Log.d("leak-43-48", dataLeAk43);
		android.util.Log.d("leak-45-48", dataLeAk45);
		android.util.Log.d("leak-47-48", dataLeAk47);
		android.util.Log.d("leak-49-48", dataLeAk49);
		android.util.Log.d("leak-50-48", dataLeAk50);
		android.util.Log.d("leak-51-48", dataLeAk51);
		android.util.Log.d("leak-52-48", dataLeAk52);
		android.util.Log.d("leak-54-48", dataLeAk54);
		android.util.Log.d("leak-56-48", dataLeAk56);
		android.util.Log.d("leak-58-48", dataLeAk58);
		android.util.Log.d("leak-60-48", dataLeAk60);
		android.util.Log.d("leak-62-48", dataLeAk62);
		android.util.Log.d("leak-64-48", dataLeAk64);
		android.util.Log.d("leak-66-48", dataLeAk66);
		android.util.Log.d("leak-68-48", dataLeAk68);
		android.util.Log.d("leak-70-48", dataLeAk70);
		android.util.Log.d("leak-72-48", dataLeAk72);
		android.util.Log.d("leak-74-48", dataLeAk74);
		android.util.Log.d("leak-76-48", dataLeAk76);
		android.util.Log.d("leak-78-48", dataLeAk78);
		android.util.Log.d("leak-80-48", dataLeAk80);
		android.util.Log.d("leak-82-48", dataLeAk82);
		android.util.Log.d("leak-84-48", dataLeAk84);
		android.util.Log.d("leak-86-48", dataLeAk86);
		android.util.Log.d("leak-88-48", dataLeAk88);
		android.util.Log.d("leak-90-48", dataLeAk90);
		android.util.Log.d("leak-91-48", dataLeAk91);
		android.util.Log.d("leak-92-48", dataLeAk92);
		android.util.Log.d("leak-93-48", dataLeAk93);
		if (requestCode == PREFERENCES && data != null) {
            Bundle extras = data.getExtras();
            if (extras.getBoolean(START_DAY)) {
                switchView(preferences.getInt(VIEW_MODE, 0));
            }
            if (extras.getBoolean(CONCURRENT)) {
                concurrency = preferences.getBoolean(CONCURRENT, false);
            }
            if (extras.getBoolean(SOUND)) {
                playClick = preferences.getBoolean(SOUND, false);
                if (playClick && clickPlayer == null) {
                    clickPlayer = MediaPlayer.create(this, R.raw.click);
                    try {
                        clickPlayer.prepareAsync();
                        clickPlayer.setVolume(1, 1);
                    } catch (IllegalStateException illegalStateException) {
                        // ignore this.  There's nothing the user can do about it.
                        Logger.getLogger("TimeTracker").log(Level.SEVERE,
                                "Failed to set up audio player: {0}",
                                illegalStateException.getMessage());
                    }
                }
            }
            if (extras.getBoolean(VIBRATE)) {
                vibrateClick = preferences.getBoolean(VIBRATE, true);
            }
            if (extras.getBoolean(FONTSIZE)) {
                fontSize = preferences.getInt(FONTSIZE, 16);
            }
            if (extras.getBoolean(TIMEDISPLAY)) {
                decimalFormat = preferences.getBoolean(TIMEDISPLAY, false);
            }
        }

        if (getListView() != null) {
            getListView().invalidate();
        }
    }

    protected void finishedCopy(DBBackup.Result result, String message, int success_string, int fail_string) {
        dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-15-49", dataLeAk15);
		android.util.Log.d("leak-17-49", dataLeAk17);
		android.util.Log.d("leak-18-49", dataLeAk18);
		android.util.Log.d("leak-19-49", dataLeAk19);
		android.util.Log.d("leak-20-49", dataLeAk20);
		android.util.Log.d("leak-21-49", dataLeAk21);
		android.util.Log.d("leak-22-49", dataLeAk22);
		android.util.Log.d("leak-23-49", dataLeAk23);
		android.util.Log.d("leak-24-49", dataLeAk24);
		android.util.Log.d("leak-25-49", dataLeAk25);
		android.util.Log.d("leak-26-49", dataLeAk26);
		android.util.Log.d("leak-30-49", dataLeAk30);
		android.util.Log.d("leak-31-49", dataLeAk31);
		android.util.Log.d("leak-32-49", dataLeAk32);
		android.util.Log.d("leak-34-49", dataLeAk34);
		android.util.Log.d("leak-36-49", dataLeAk36);
		android.util.Log.d("leak-38-49", dataLeAk38);
		android.util.Log.d("leak-39-49", dataLeAk39);
		android.util.Log.d("leak-40-49", dataLeAk40);
		android.util.Log.d("leak-41-49", dataLeAk41);
		android.util.Log.d("leak-42-49", dataLeAk42);
		android.util.Log.d("leak-43-49", dataLeAk43);
		android.util.Log.d("leak-45-49", dataLeAk45);
		android.util.Log.d("leak-47-49", dataLeAk47);
		android.util.Log.d("leak-49-49", dataLeAk49);
		android.util.Log.d("leak-50-49", dataLeAk50);
		android.util.Log.d("leak-51-49", dataLeAk51);
		android.util.Log.d("leak-52-49", dataLeAk52);
		android.util.Log.d("leak-54-49", dataLeAk54);
		android.util.Log.d("leak-56-49", dataLeAk56);
		android.util.Log.d("leak-58-49", dataLeAk58);
		android.util.Log.d("leak-60-49", dataLeAk60);
		android.util.Log.d("leak-62-49", dataLeAk62);
		android.util.Log.d("leak-64-49", dataLeAk64);
		android.util.Log.d("leak-66-49", dataLeAk66);
		android.util.Log.d("leak-68-49", dataLeAk68);
		android.util.Log.d("leak-70-49", dataLeAk70);
		android.util.Log.d("leak-72-49", dataLeAk72);
		android.util.Log.d("leak-74-49", dataLeAk74);
		android.util.Log.d("leak-76-49", dataLeAk76);
		android.util.Log.d("leak-78-49", dataLeAk78);
		android.util.Log.d("leak-80-49", dataLeAk80);
		android.util.Log.d("leak-82-49", dataLeAk82);
		android.util.Log.d("leak-84-49", dataLeAk84);
		android.util.Log.d("leak-86-49", dataLeAk86);
		android.util.Log.d("leak-88-49", dataLeAk88);
		android.util.Log.d("leak-90-49", dataLeAk90);
		android.util.Log.d("leak-91-49", dataLeAk91);
		android.util.Log.d("leak-92-49", dataLeAk92);
		android.util.Log.d("leak-93-49", dataLeAk93);
		if (result == DBBackup.Result.SUCCESS) {
            switchView(preferences.getInt(VIEW_MODE, 0));
            message = dbBackup.getAbsolutePath();
        }
        perform(message, success_string, fail_string);
    }

}
