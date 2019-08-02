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

    String dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk35 = android.util.Log.d("leak-35", dataLeAk35);

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
		String dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk36 = android.util.Log.d("leak-36", dataLeAk36);
        //android.os.Debug.waitForDebugger();
        preferences = getSharedPreferences(TIMETRACKERPREF, MODE_PRIVATE);
        fontSize = preferences.getInt(FONTSIZE, 16);
        concurrency = preferences.getBoolean(CONCURRENT, false);

        int which = preferences.getInt(VIEW_MODE, 0);
        if (adapter == null) {
            String dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk37 = android.util.Log.d("leak-37", dataLeAk37);
			adapter = new ActivityAdapter(this);
            setListAdapter(adapter);
            switchView(which);
        }
        if (timer == null) {
            String dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk38 = android.util.Log.d("leak-38", dataLeAk38);
			timer = new Handler();
        }
        if (updater == null) {
            String dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk39 = android.util.Log.d("leak-39", dataLeAk39);
			updater = new TimerTask() {
                String dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk40 = android.util.Log.d("leak-40", dataLeAk40);

				@Override
                public void run() {
                    String dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk41 = android.util.Log.d("leak-41", dataLeAk41);
					if (running) {
                        String dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk42 = android.util.Log.d("leak-42", dataLeAk42);
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
            String dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk43 = android.util.Log.d("leak-43", dataLeAk43);
			clickPlayer = MediaPlayer.create(this, R.raw.click);
            try {
                String dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk44 = android.util.Log.d("leak-44", dataLeAk44);
				clickPlayer.prepareAsync();
            } catch (IllegalStateException illegalStateException) {
                String dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk45 = android.util.Log.d("leak-45", dataLeAk45);
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
            String dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk46 = android.util.Log.d("leak-46", dataLeAk46);
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
		String dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk47 = android.util.Log.d("leak-47", dataLeAk47);
        if (timer != null) {
            String dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk48 = android.util.Log.d("leak-48", dataLeAk48);
			timer.removeCallbacks(updater);
        }
    }

    @Override
    protected void onStop() {
        if (adapter != null) {
            String dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk50 = android.util.Log.d("leak-50", dataLeAk50);
			adapter.close();
        }
		String dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk49 = android.util.Log.d("leak-49", dataLeAk49);
        if (clickPlayer != null) {
            String dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk51 = android.util.Log.d("leak-51", dataLeAk51);
			clickPlayer.release();
            clickPlayer = null;
        }
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
		String dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk52 = android.util.Log.d("leak-52", dataLeAk52);
        // This is only to cause the view to reload, so that we catch 
        // updates to the time list.
        int which = preferences.getInt(VIEW_MODE, 0);
        switchView(which);

        if (timer != null && running) {
            String dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk53 = android.util.Log.d("leak-53", dataLeAk53);
			timer.post(updater);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
		String dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk54 = android.util.Log.d("leak-54", dataLeAk54);
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
        String dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk55 = android.util.Log.d("leak-55", dataLeAk55);
		menu.setHeaderTitle("Activities menu");
        menu.add(0, EDIT_ACTIVITY, 0, getText(R.string.edit_activity));
        menu.add(0, DELETE_ACTIVITY, 0, getText(R.string.delete_activity));
        menu.add(0, SHOW_TIMES, 0, getText(R.string.show_times));
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String dataLeAk56 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk56 = android.util.Log.d("leak-56", dataLeAk56);
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
        selectedActivity = (Activity) adapter.getItem((int) info.id);
        switch (item.getItemId()) {
            case SHOW_TIMES:
                Intent intent = new Intent(this, ActivityTimes.class);
                intent.putExtra(ACTIVITY_ID, selectedActivity.getId());
                if (adapter.currentRangeStart != -1) {
                    String dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk57 = android.util.Log.d("leak-57", dataLeAk57);
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
        String dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk58 = android.util.Log.d("leak-58", dataLeAk58);
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
        String dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk59 = android.util.Log.d("leak-59", dataLeAk59);
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
                String dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk60 = android.util.Log.d("leak-60", dataLeAk60);
				requestExport();
                break;
            }
            case BACKUP: {
                String dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk61 = android.util.Log.d("leak-61", dataLeAk61);
				requestBackupCreation();
                break;
            }
            case RESTORE: {
                String dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk62 = android.util.Log.d("leak-62", dataLeAk62);
				requestBackupRestore();
                break;
            }
            case PREFERENCES: { // PREFERENCES
                String dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk63 = android.util.Log.d("leak-63", dataLeAk63);
				Intent intent = new Intent(Activities.this, Settings.class);
                startActivityForResult(intent, PREFERENCES);
                break;
            }
        }
        return null;
    }

    protected void perform(String message, int success_string, int fail_string) {
        String dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk64 = android.util.Log.d("leak-64", dataLeAk64);
		if (message != null) {
            String dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk65 = android.util.Log.d("leak-65", dataLeAk65);
			exportMessage = getString(success_string, message);
            if (operationSucceed != null) {
                String dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk66 = android.util.Log.d("leak-66", dataLeAk66);
				operationSucceed.setMessage(exportMessage);
            }
            showDialog(SUCCESS_DIALOG);
        } else {
            String dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk67 = android.util.Log.d("leak-67", dataLeAk67);
			exportMessage = getString(fail_string, message);
            if (operationFailed != null) {
                String dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk68 = android.util.Log.d("leak-68", dataLeAk68);
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
        String dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk69 = android.util.Log.d("leak-69", dataLeAk69);
		return new AlertDialog.Builder(Activities.this).setItems(R.array.views, new DialogInterface.OnClickListener() {
            String dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk70 = android.util.Log.d("leak-70", dataLeAk70);

			@Override
            public void onClick(DialogInterface dialog, int which) {
                String dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk71 = android.util.Log.d("leak-71", dataLeAk71);
				SharedPreferences.Editor ed = preferences.edit();
                ed.putInt(VIEW_MODE, which);
                ed.commit();
                if (which == 5) {
                    String dataLeAk72 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk72 = android.util.Log.d("leak-72", dataLeAk72);
					Calendar calInstance = Calendar.getInstance();
                    new DatePickerDialog(Activities.this,
                            new DatePickerDialog.OnDateSetListener() {
                        String dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk73 = android.util.Log.d("leak-73", dataLeAk73);

						@Override
                        public void onDateSet(DatePicker view, int year,
                                int monthOfYear, int dayOfMonth) {
                            String dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk74 = android.util.Log.d("leak-74", dataLeAk74);
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
                                String dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk75 = android.util.Log.d("leak-75", dataLeAk75);

								@Override
                                public void onDateSet(DatePicker view, int year,
                                        int monthOfYear, int dayOfMonth) {
                                    String dataLeAk76 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											Object throwawayLeAk76 = android.util.Log.d("leak-76", dataLeAk76);
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
                    String dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk77 = android.util.Log.d("leak-77", dataLeAk77);
					switchView(which);
                }
            }
        }).create();
    }

    private void switchView(int which) {
        String dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk78 = android.util.Log.d("leak-78", dataLeAk78);
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
        String dataLeAk79 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk79 = android.util.Log.d("leak-79", dataLeAk79);
		long total = 0;
        for (Activity t : adapter.activities) {
            String dataLeAk80 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk80 = android.util.Log.d("leak-80", dataLeAk80);
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
        String dataLeAk81 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk81 = android.util.Log.d("leak-81", dataLeAk81);
		LayoutInflater factory = LayoutInflater.from(this);
        final View textEntryView = factory.inflate(R.layout.edit_activity, null);
        final AlertDialog dialog = new AlertDialog.Builder(Activities.this)
                .setTitle(R.string.add_activity_title).setView(textEntryView)
                .setPositiveButton(R.string.add_activity_ok, null)
                .setNegativeButton(android.R.string.cancel, null)
                .create();
        dialog.show();
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            String dataLeAk82 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk82 = android.util.Log.d("leak-82", dataLeAk82);

			@Override
            public void onClick(View view) {
                String dataLeAk83 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk83 = android.util.Log.d("leak-83", dataLeAk83);
				EditText textView = (EditText) textEntryView.findViewById(R.id.activity_edit_name_edit);
                String name = textView.getText().toString();
                if (!name.isEmpty()) {
                    String dataLeAk84 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk84 = android.util.Log.d("leak-84", dataLeAk84);
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
        String dataLeAk85 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk85 = android.util.Log.d("leak-85", dataLeAk85);
		if (selectedActivity == null) {
            String dataLeAk86 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk86 = android.util.Log.d("leak-86", dataLeAk86);
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
            String dataLeAk87 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk87 = android.util.Log.d("leak-87", dataLeAk87);

			@Override
            public void onClick(View view) {
                String dataLeAk88 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk88 = android.util.Log.d("leak-88", dataLeAk88);
				EditText textView = (EditText) textEntryView.findViewById(R.id.activity_edit_name_edit);
                String name = textView.getText().toString();
                if (!name.isEmpty()) {
                    String dataLeAk89 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk89 = android.util.Log.d("leak-89", dataLeAk89);
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
        String dataLeAk90 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk90 = android.util.Log.d("leak-90", dataLeAk90);
		if (selectedActivity == null) {
            String dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk91 = android.util.Log.d("leak-91", dataLeAk91);
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
            String dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk92 = android.util.Log.d("leak-92", dataLeAk92);

			@Override
            public void onClick(DialogInterface dialog, int whichButton) {
                String dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk93 = android.util.Log.d("leak-93", dataLeAk93);
				adapter.deleteActivity(selectedActivity);
                Activities.this.getListView().invalidate();
            }
        }).setNegativeButton(android.R.string.cancel, null)
                .create();
    }
    final static String SDCARD = "/sdcard/";

    private String export() {
        String dataLeAk94 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk94 = android.util.Log.d("leak-94", dataLeAk94);
		// Export, then show a progressDialog
        String rangeName = getRangeName();
        String fname = rangeName + ".csv";
        File fout = new File(SDCARD + fname);
        // Change the file name until there's no conflict
        int counter = 0;
        while (fout.exists()) {
            String dataLeAk95 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk95 = android.util.Log.d("leak-95", dataLeAk95);
			fname = rangeName + "_" + counter + ".csv";
            fout = new File(SDCARD + fname);
            counter++;
        }
        try (
                OutputStream out = new FileOutputStream(fout);
                Cursor currentRange = adapter.getCurrentRange()
            ) {
            String dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk96 = android.util.Log.d("leak-96", dataLeAk96);
			CSVExporter.exportRows(out, currentRange);
            return fname;
        } catch (FileNotFoundException fnfe) {
            String dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk97 = android.util.Log.d("leak-97", dataLeAk97);
			fnfe.printStackTrace(System.err);
            return null;
        } catch (IOException ex) {
            String dataLeAk98 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk98 = android.util.Log.d("leak-98", dataLeAk98);
			ex.printStackTrace(System.err);
            return null;
        }
    }

    private String getRangeName() {
        String dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk99 = android.util.Log.d("leak-99", dataLeAk99);
		if (adapter.currentRangeStart == -1) {
            String dataLeAk100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk100 = android.util.Log.d("leak-100", dataLeAk100);
			return "all";
        }
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        d.setTime(adapter.currentRangeStart);
        return f.format(d);
    }

    private String getVersionName() {
        String dataLeAk101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk101 = android.util.Log.d("leak-101", dataLeAk101);
		if (versionName == null) {
            String dataLeAk102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk102 = android.util.Log.d("leak-102", dataLeAk102);
			try {
                String dataLeAk103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk103 = android.util.Log.d("leak-103", dataLeAk103);
				PackageInfo pkginfo = this.getPackageManager().getPackageInfo("com.markuspage.android.atimetracker", 0);
                versionName = pkginfo.versionName;
            } catch (NameNotFoundException nnfe) {
                String dataLeAk104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk104 = android.util.Log.d("leak-104", dataLeAk104);
				nnfe.printStackTrace();
                versionName = "n/a";
            }
        }
        return versionName;
    }

    private Dialog openAboutDialog() {
        String dataLeAk105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk105 = android.util.Log.d("leak-105", dataLeAk105);
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
        String dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk106 = android.util.Log.d("leak-106", dataLeAk106);
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
        String dataLeAk107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk107 = android.util.Log.d("leak-107", dataLeAk107);
		if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            String dataLeAk108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk108 = android.util.Log.d("leak-108", dataLeAk108);
			// Permission is not granted
            // Show an explanation to the user *asynchronously* -- don't block
            // this thread waiting for the user's response! After the user
            // sees the explanation, try again to request the permission.
            new AlertDialog.Builder(this)
                    .setMessage(R.string.permission_to_export_needed)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                String dataLeAk109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk109 = android.util.Log.d("leak-109", dataLeAk109);

				@Override
                public void onClick(DialogInterface dialog, int which) {
                    String dataLeAk110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk110 = android.util.Log.d("leak-110", dataLeAk110);
					ActivityCompat.requestPermissions(Activities.this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_EXPORT);
                }
            }).create().show();

        } else {
            String dataLeAk111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk111 = android.util.Log.d("leak-111", dataLeAk111);
			doExport();
        }
    }

    /**
     * Check if we have permission to restore the backup and if not ask for
     * permission to do it.
     */
    private void requestBackupRestore() {
        String dataLeAk112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk112 = android.util.Log.d("leak-112", dataLeAk112);
		if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            String dataLeAk113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk113 = android.util.Log.d("leak-113", dataLeAk113);
			// Permission is not granted
            // Show an explanation to the user *asynchronously* -- don't block
            // this thread waiting for the user's response! After the user
            // sees the explanation, try again to request the permission.
            new AlertDialog.Builder(this)
                    .setMessage(R.string.permission_to_restore_needed)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                String dataLeAk114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk114 = android.util.Log.d("leak-114", dataLeAk114);

				@Override
                public void onClick(DialogInterface dialog, int which) {
                    String dataLeAk115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk115 = android.util.Log.d("leak-115", dataLeAk115);
					ActivityCompat.requestPermissions(Activities.this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_RESTORE_BACKUP);
                }
            }).create().show();

        } else {
            String dataLeAk116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk116 = android.util.Log.d("leak-116", dataLeAk116);
			doBackupRestore();
        }
    }
    
    /**
     * Check if we have permission to create the backup and if not ask for
     * permission to do it.
     */
    private void requestBackupCreation() {
        String dataLeAk117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk117 = android.util.Log.d("leak-117", dataLeAk117);
		if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            String dataLeAk118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk118 = android.util.Log.d("leak-118", dataLeAk118);
			// Permission is not granted
            // Show an explanation to the user *asynchronously* -- don't block
            // this thread waiting for the user's response! After the user
            // sees the explanation, try again to request the permission.
            new AlertDialog.Builder(this)
                    .setMessage(R.string.permission_to_backup_needed)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                String dataLeAk119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk119 = android.util.Log.d("leak-119", dataLeAk119);

				@Override
                public void onClick(DialogInterface dialog, int which) {
                    String dataLeAk120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk120 = android.util.Log.d("leak-120", dataLeAk120);
					ActivityCompat.requestPermissions(Activities.this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_CREATE_BACKUP);
                }
            }).create().show();

        } else {
            String dataLeAk121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk121 = android.util.Log.d("leak-121", dataLeAk121);
			doBackupCreation();
        }
    }
    
    /**
     * Perform the export.
     * This assumes permission has already been granted.
     */
    private void doExport() {
        String dataLeAk122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk122 = android.util.Log.d("leak-122", dataLeAk122);
		String fname = export();
        perform(fname, R.string.export_csv_success, R.string.export_csv_fail);
    }

    /**
     * Perform the restore.
     * This assumes permission has already been granted.
     */
    private void doBackupRestore() {
        String dataLeAk123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk123 = android.util.Log.d("leak-123", dataLeAk123);
		if (dbBackup.exists()) {
            String dataLeAk124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk124 = android.util.Log.d("leak-124", dataLeAk124);
			try {
                String dataLeAk125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk125 = android.util.Log.d("leak-125", dataLeAk125);
				showDialog(Activities.PROGRESS_DIALOG);
                SQLiteDatabase backupDb = SQLiteDatabase.openDatabase(dbBackup.getAbsolutePath(), null, SQLiteDatabase.OPEN_READONLY);
                SQLiteDatabase appDb = SQLiteDatabase.openDatabase(DB_FILE, null, SQLiteDatabase.OPEN_READWRITE);
                DBBackup backup = new DBBackup(Activities.this, progressDialog, R.string.restore_success, R.string.restore_failed);
                backup.execute(backupDb, appDb);
            } catch (Exception ex) {
                String dataLeAk126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk126 = android.util.Log.d("leak-126", dataLeAk126);
				Logger.getLogger(Activities.class.getName()).log(Level.SEVERE, null, ex);
                exportMessage = ex.getLocalizedMessage();
                showDialog(ERROR_DIALOG);
            }
        } else {
            String dataLeAk127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk127 = android.util.Log.d("leak-127", dataLeAk127);
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
        String dataLeAk128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk128 = android.util.Log.d("leak-128", dataLeAk128);
		showDialog(Activities.PROGRESS_DIALOG);
        if (dbBackup.exists()) {
            String dataLeAk129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk129 = android.util.Log.d("leak-129", dataLeAk129);
			// Find the database
            SQLiteDatabase backupDb = SQLiteDatabase.openDatabase(dbBackup.getAbsolutePath(), null, SQLiteDatabase.OPEN_READWRITE);
            SQLiteDatabase appDb = SQLiteDatabase.openDatabase(DB_FILE, null, SQLiteDatabase.OPEN_READONLY);
            DBBackup backup = new DBBackup(Activities.this, progressDialog, R.string.backup_success, R.string.backup_failed);
            backup.execute(appDb, backupDb);
        } else {
            String dataLeAk130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk130 = android.util.Log.d("leak-130", dataLeAk130);
			InputStream in = null;
            OutputStream out = null;

            try {
                String dataLeAk131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk131 = android.util.Log.d("leak-131", dataLeAk131);
				in = new BufferedInputStream(new FileInputStream(DB_FILE));
                out = new BufferedOutputStream(new FileOutputStream(dbBackup));
                for (int c = in.read(); c != -1; c = in.read()) {
                    String dataLeAk132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk132 = android.util.Log.d("leak-132", dataLeAk132);
					out.write(c);
                }
                finishedCopy(DBBackup.Result.SUCCESS, dbBackup.getAbsolutePath(), R.string.backup_success, R.string.backup_failed);
            } catch (IOException ex) {
                String dataLeAk133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk133 = android.util.Log.d("leak-133", dataLeAk133);
				Logger.getLogger(Activities.class.getName()).log(Level.SEVERE, null, ex);
                exportMessage = ex.getLocalizedMessage();
                showDialog(ERROR_DIALOG);
            } finally {
                String dataLeAk134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk134 = android.util.Log.d("leak-134", dataLeAk134);
				try {
                    String dataLeAk135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk135 = android.util.Log.d("leak-135", dataLeAk135);
					if (in != null) {
                        String dataLeAk136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk136 = android.util.Log.d("leak-136", dataLeAk136);
						in.close();
                    }
                } catch (IOException ignored) {
					String dataLeAk137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk137 = android.util.Log.d("leak-137", dataLeAk137);
                }
                try {
                    String dataLeAk138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk138 = android.util.Log.d("leak-138", dataLeAk138);
					if (out != null) {
                        String dataLeAk139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk139 = android.util.Log.d("leak-139", dataLeAk139);
						out.close();
                    }
                } catch (IOException ignored) {
					String dataLeAk140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk140 = android.util.Log.d("leak-140", dataLeAk140);
                }
                progressDialog.dismiss();
            }
        }
    }
    
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        String dataLeAk141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk141 = android.util.Log.d("leak-141", dataLeAk141);
		switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_RESTORE_BACKUP:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    String dataLeAk142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk142 = android.util.Log.d("leak-142", dataLeAk142);
					requestBackupRestore();
                }
                break;
            case MY_PERMISSIONS_REQUEST_CREATE_BACKUP:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    String dataLeAk143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk143 = android.util.Log.d("leak-143", dataLeAk143);
					requestExport();
                }
                break;
            case MY_PERMISSIONS_REQUEST_EXPORT:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    String dataLeAk144 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk144 = android.util.Log.d("leak-144", dataLeAk144);
					requestExport();
                }
                break;
        }
    }

    /**
     * The view for an individual activity in the list.
     */
    private class ActivityView extends LinearLayout {

        String dataLeAk145 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk145 = android.util.Log.d("leak-145", dataLeAk145);

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
			String dataLeAk146 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk146 = android.util.Log.d("leak-146", dataLeAk146);
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
            String dataLeAk147 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk147 = android.util.Log.d("leak-147", dataLeAk147);
			name.setTextSize(fontSize);
            total.setTextSize(fontSize);
            name.setText(t.getName());
            total.setText(formatTotal(decimalFormat, t.getTotal(), 0));
            markupSelectedActivity(t);
        }

        private void markupSelectedActivity(Activity t) {
            String dataLeAk148 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk148 = android.util.Log.d("leak-148", dataLeAk148);
			if (t.isRunning()) {
                String dataLeAk149 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk149 = android.util.Log.d("leak-149", dataLeAk149);
				checkMark.setVisibility(View.VISIBLE);
            } else {
                String dataLeAk150 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk150 = android.util.Log.d("leak-150", dataLeAk150);
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
        String dataLeAk151 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk151 = android.util.Log.d("leak-151", dataLeAk151);
		return formatTotal(decimalFormat, FORMAT, ttl, roundMinutes);
    }

    static String formatTotal(boolean decimalFormat, String format, long ttl, long roundMinutes) {
        String dataLeAk152 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk152 = android.util.Log.d("leak-152", dataLeAk152);
		if (roundMinutes > 0) {
            String dataLeAk153 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk153 = android.util.Log.d("leak-153", dataLeAk153);
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
        String dataLeAk154 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk154 = android.util.Log.d("leak-154", dataLeAk154);
		return formatTotal(decimalFormat, FORMAT, hours, minutes, seconds, roundMinutes);
    }

    static String formatTotal(boolean decimalFormat, String format, long hours, long minutes, long seconds, long roundMinutes) {
        String dataLeAk155 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk155 = android.util.Log.d("leak-155", dataLeAk155);
		if (decimalFormat) {
            String dataLeAk156 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk156 = android.util.Log.d("leak-156", dataLeAk156);
			format = DECIMAL_FORMAT;
            minutes = Math.round((D_M * minutes) + (D_S * seconds));
            seconds = 0;
        }
        return String.format(format, hours, minutes, seconds);
    }

    private class ActivityAdapter extends BaseAdapter {

        String dataLeAk157 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk157 = android.util.Log.d("leak-157", dataLeAk157);

		private final DBHelper dbHelper;
        protected ArrayList<Activity> activities;
        private final Context savedContext;
        private long currentRangeStart;
        private long currentRangeEnd;

        public ActivityAdapter(Context c) {
            String dataLeAk158 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk158 = android.util.Log.d("leak-158", dataLeAk158);
			savedContext = c;
            dbHelper = new DBHelper(c);
            dbHelper.getWritableDatabase();
            activities = new ArrayList<Activity>();
        }

        public void close() {
            String dataLeAk159 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk159 = android.util.Log.d("leak-159", dataLeAk159);
			dbHelper.close();
        }

        /**
         * Loads all activities.
         */
        private void loadActivities() {
            String dataLeAk160 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk160 = android.util.Log.d("leak-160", dataLeAk160);
			currentRangeStart = currentRangeEnd = -1;
            loadActivities("", true);
        }

        protected void loadActivity(Calendar day) {
            String dataLeAk161 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk161 = android.util.Log.d("leak-161", dataLeAk161);
			loadActivities(day, (Calendar) day.clone());
        }

        protected void loadActivities(Calendar start, Calendar end) {
            String dataLeAk162 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk162 = android.util.Log.d("leak-162", dataLeAk162);
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
            String dataLeAk163 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk163 = android.util.Log.d("leak-163", dataLeAk163);
			String query = "AND " + START + " < %d AND " + START + " >= %d";
            Calendar today = Calendar.getInstance();
            today.setFirstDayOfWeek(preferences.getInt(START_DAY, 0) + 1);
            today.set(Calendar.HOUR_OF_DAY, 12);
            for (int field : new int[]{Calendar.HOUR_OF_DAY, Calendar.MINUTE,
                Calendar.SECOND,
                Calendar.MILLISECOND}) {
                String dataLeAk164 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk164 = android.util.Log.d("leak-164", dataLeAk164);
				for (Calendar d : new Calendar[]{today, start, end}) {
                    String dataLeAk165 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk165 = android.util.Log.d("leak-165", dataLeAk165);
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
            String dataLeAk166 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk166 = android.util.Log.d("leak-166", dataLeAk166);
			activities.clear();

            SQLiteDatabase db = dbHelper.getReadableDatabase();
            Cursor c = db.query(ACTIVITY_TABLE, ACTIVITY_COLUMNS, null, null, null, null, null);

            Activity t;
            if (c.moveToFirst()) {
                String dataLeAk167 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk167 = android.util.Log.d("leak-167", dataLeAk167);
				do {
                    String dataLeAk168 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk168 = android.util.Log.d("leak-168", dataLeAk168);
					int tid = c.getInt(0);
                    String[] tids = {String.valueOf(tid)};
                    t = new Activity(c.getString(1), tid);
                    Cursor r = db.rawQuery("SELECT SUM(end) - SUM(start) AS total FROM " + RANGES_TABLE + " WHERE " + ACTIVITY_ID + " = ? AND end NOTNULL " + whereClause, tids);
                    if (r.moveToFirst()) {
                        String dataLeAk169 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk169 = android.util.Log.d("leak-169", dataLeAk169);
						t.setCollapsed(r.getLong(0));
                    }
                    r.close();
                    if (loadCurrent) {
                        String dataLeAk170 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk170 = android.util.Log.d("leak-170", dataLeAk170);
						r = db.query(RANGES_TABLE, RANGE_COLUMNS,
                                ACTIVITY_ID + " = ? AND end ISNULL",
                                tids, null, null, null);
                        if (r.moveToFirst()) {
                            String dataLeAk171 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk171 = android.util.Log.d("leak-171", dataLeAk171);
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
            String dataLeAk172 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk172 = android.util.Log.d("leak-172", dataLeAk172);
			String[] res = {""};
            if (currentRangeStart != -1 && currentRangeEnd != -1) {
                String dataLeAk173 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk173 = android.util.Log.d("leak-173", dataLeAk173);
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
            String dataLeAk174 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk174 = android.util.Log.d("leak-174", dataLeAk174);
			List<Activity> activeActivities = new ArrayList<Activity>();
            for (Activity a : activities) {
                String dataLeAk175 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk175 = android.util.Log.d("leak-175", dataLeAk175);
				if (a.isRunning()) {
                    String dataLeAk176 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk176 = android.util.Log.d("leak-176", dataLeAk176);
					activeActivities.add(a);
                }
            }
            return activeActivities;
        }

        protected void addActivity(String name) {
            String dataLeAk177 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk177 = android.util.Log.d("leak-177", dataLeAk177);
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
            String dataLeAk178 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk178 = android.util.Log.d("leak-178", dataLeAk178);
			SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(NAME, t.getName());
            String id = String.valueOf(t.getId());
            String[] vals = {id};
            db.update(ACTIVITY_TABLE, values, "ROWID = ?", vals);

            if (t.getStartTime() != NULL) {
                String dataLeAk179 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk179 = android.util.Log.d("leak-179", dataLeAk179);
				values.clear();
                long startTime = t.getStartTime();
                values.put(START, startTime);
                vals = new String[]{id, String.valueOf(startTime)};
                if (t.getEndTime() != NULL) {
                    String dataLeAk180 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk180 = android.util.Log.d("leak-180", dataLeAk180);
					values.put(END, t.getEndTime());
                }
                // If an update fails, then this is an insert
                if (db.update(RANGES_TABLE, values, ACTIVITY_ID + " = ? AND " + START + " = ?", vals) == 0) {
                    String dataLeAk181 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk181 = android.util.Log.d("leak-181", dataLeAk181);
					values.put(ACTIVITY_ID, t.getId());
                    db.insert(RANGES_TABLE, END, values);
                }
            }

            Collections.sort(activities);
            notifyDataSetChanged();
        }

        public void deleteActivity(Activity t) {
            String dataLeAk182 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk182 = android.util.Log.d("leak-182", dataLeAk182);
			activities.remove(t);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            String[] id = {String.valueOf(t.getId())};
            db.delete(ACTIVITY_TABLE, "ROWID = ?", id);
            db.delete(RANGES_TABLE, ACTIVITY_ID + " = ?", id);
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            String dataLeAk183 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk183 = android.util.Log.d("leak-183", dataLeAk183);
			return activities.size();
        }

        @Override
        public Object getItem(int position) {
            String dataLeAk184 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk184 = android.util.Log.d("leak-184", dataLeAk184);
			return activities.get(position);
        }

        @Override
        public long getItemId(int position) {
            String dataLeAk185 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk185 = android.util.Log.d("leak-185", dataLeAk185);
			return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            String dataLeAk186 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk186 = android.util.Log.d("leak-186", dataLeAk186);
			ActivityView view = null;
            if (convertView == null) {
                String dataLeAk187 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk187 = android.util.Log.d("leak-187", dataLeAk187);
				Object item = getItem(position);
                if (item != null) {
                    String dataLeAk188 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk188 = android.util.Log.d("leak-188", dataLeAk188);
					view = new ActivityView(savedContext, (Activity) item);
                }
            } else {
                String dataLeAk189 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk189 = android.util.Log.d("leak-189", dataLeAk189);
				view = (ActivityView) convertView;
                Object item = getItem(position);
                if (item != null) {
                    String dataLeAk190 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk190 = android.util.Log.d("leak-190", dataLeAk190);
					view.setActivity((Activity) item);
                }
            }
            return view;
        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        if (vibrateClick) {
            String dataLeAk192 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk192 = android.util.Log.d("leak-192", dataLeAk192);
			vibrateAgent.vibrate(100);
        }
		String dataLeAk191 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk191 = android.util.Log.d("leak-191", dataLeAk191);
        if (playClick) {
            String dataLeAk193 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk193 = android.util.Log.d("leak-193", dataLeAk193);
			try {
                String dataLeAk194 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk194 = android.util.Log.d("leak-194", dataLeAk194);
				//clickPlayer.prepare();
                clickPlayer.start();
            } catch (IllegalStateException exception) {
                String dataLeAk195 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk195 = android.util.Log.d("leak-195", dataLeAk195);
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
            String dataLeAk196 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk196 = android.util.Log.d("leak-196", dataLeAk196);
			Activity selected = (Activity) item;
            if (!concurrency) {
                String dataLeAk197 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk197 = android.util.Log.d("leak-197", dataLeAk197);
				boolean startSelected = !selected.isRunning();
                if (running) {
                    String dataLeAk198 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk198 = android.util.Log.d("leak-198", dataLeAk198);
					running = false;
                    timer.removeCallbacks(updater);
                    // Disable currently running activities
                    for (Activity a : adapter.findCurrentlyActive()) {
                        String dataLeAk199 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk199 = android.util.Log.d("leak-199", dataLeAk199);
						a.stop();
                        adapter.updateActivity(a);
                    }
                }
                if (startSelected) {
                    String dataLeAk200 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk200 = android.util.Log.d("leak-200", dataLeAk200);
					selected.start();
                    running = true;
                    timer.post(updater);
                }
            } else {
                String dataLeAk201 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk201 = android.util.Log.d("leak-201", dataLeAk201);
				if (selected.isRunning()) {
                    String dataLeAk202 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk202 = android.util.Log.d("leak-202", dataLeAk202);
					selected.stop();
                    running = !adapter.findCurrentlyActive().isEmpty();
                    if (!running) {
                        String dataLeAk203 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk203 = android.util.Log.d("leak-203", dataLeAk203);
						timer.removeCallbacks(updater);
                    }
                } else {
                    String dataLeAk204 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk204 = android.util.Log.d("leak-204", dataLeAk204);
					selected.start();
                    if (!running) {
                        String dataLeAk205 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk205 = android.util.Log.d("leak-205", dataLeAk205);
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
        String dataLeAk206 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk206 = android.util.Log.d("leak-206", dataLeAk206);
		if (requestCode == PREFERENCES && data != null) {
            String dataLeAk207 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk207 = android.util.Log.d("leak-207", dataLeAk207);
			Bundle extras = data.getExtras();
            if (extras.getBoolean(START_DAY)) {
                String dataLeAk208 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk208 = android.util.Log.d("leak-208", dataLeAk208);
				switchView(preferences.getInt(VIEW_MODE, 0));
            }
            if (extras.getBoolean(CONCURRENT)) {
                String dataLeAk209 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk209 = android.util.Log.d("leak-209", dataLeAk209);
				concurrency = preferences.getBoolean(CONCURRENT, false);
            }
            if (extras.getBoolean(SOUND)) {
                String dataLeAk210 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk210 = android.util.Log.d("leak-210", dataLeAk210);
				playClick = preferences.getBoolean(SOUND, false);
                if (playClick && clickPlayer == null) {
                    String dataLeAk211 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk211 = android.util.Log.d("leak-211", dataLeAk211);
					clickPlayer = MediaPlayer.create(this, R.raw.click);
                    try {
                        String dataLeAk212 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk212 = android.util.Log.d("leak-212", dataLeAk212);
						clickPlayer.prepareAsync();
                        clickPlayer.setVolume(1, 1);
                    } catch (IllegalStateException illegalStateException) {
                        String dataLeAk213 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk213 = android.util.Log.d("leak-213", dataLeAk213);
						// ignore this.  There's nothing the user can do about it.
                        Logger.getLogger("TimeTracker").log(Level.SEVERE,
                                "Failed to set up audio player: {0}",
                                illegalStateException.getMessage());
                    }
                }
            }
            if (extras.getBoolean(VIBRATE)) {
                String dataLeAk214 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk214 = android.util.Log.d("leak-214", dataLeAk214);
				vibrateClick = preferences.getBoolean(VIBRATE, true);
            }
            if (extras.getBoolean(FONTSIZE)) {
                String dataLeAk215 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk215 = android.util.Log.d("leak-215", dataLeAk215);
				fontSize = preferences.getInt(FONTSIZE, 16);
            }
            if (extras.getBoolean(TIMEDISPLAY)) {
                String dataLeAk216 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk216 = android.util.Log.d("leak-216", dataLeAk216);
				decimalFormat = preferences.getBoolean(TIMEDISPLAY, false);
            }
        }

        if (getListView() != null) {
            String dataLeAk217 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk217 = android.util.Log.d("leak-217", dataLeAk217);
			getListView().invalidate();
        }
    }

    protected void finishedCopy(DBBackup.Result result, String message, int success_string, int fail_string) {
        String dataLeAk218 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk218 = android.util.Log.d("leak-218", dataLeAk218);
		if (result == DBBackup.Result.SUCCESS) {
            String dataLeAk219 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk219 = android.util.Log.d("leak-219", dataLeAk219);
			switchView(preferences.getInt(VIEW_MODE, 0));
            message = dbBackup.getAbsolutePath();
        }
        perform(message, success_string, fail_string);
    }

}
