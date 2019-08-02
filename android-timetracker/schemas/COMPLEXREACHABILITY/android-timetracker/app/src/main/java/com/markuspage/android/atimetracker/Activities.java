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
		String dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP33 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP33.put("test", new java.util.HashMap<String, String>());
		leakMaP33.get("test").put("test", dataLeAk33);
		String dataLeAkPath33 = leakMaP33.get("test").get("test");
		android.util.Log.d("leak-33", dataLeAkPath33);
        //android.os.Debug.waitForDebugger();
        preferences = getSharedPreferences(TIMETRACKERPREF, MODE_PRIVATE);
        fontSize = preferences.getInt(FONTSIZE, 16);
        concurrency = preferences.getBoolean(CONCURRENT, false);

        int which = preferences.getInt(VIEW_MODE, 0);
        if (adapter == null) {
            String dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer34 = new StringBuffer();for (char chAr34 : dataLeAk34.toCharArray()) {leakBuFFer34.append(chAr34);}String dataLeAkPath34 = leakBuFFer34.toString();
			android.util.Log.d("leak-34", dataLeAkPath34);
			adapter = new ActivityAdapter(this);
            setListAdapter(adapter);
            switchView(which);
        }
        if (timer == null) {
            String dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath35;try {throw new Exception(dataLeAk35);} catch (Exception leakErRor35) {dataLeAkPath35 = leakErRor35.getMessage();}
			android.util.Log.d("leak-35", dataLeAkPath35);
			timer = new Handler();
        }
        if (updater == null) {
            String dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay36 = new String[] {"n/a", dataLeAk36};
			String dataLeAkPath36 = leakArRay36[leakArRay36.length - 1];
			android.util.Log.d("leak-36", dataLeAkPath36);
			updater = new TimerTask() {
                @Override
                public void run() {
                    String dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP37 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP37.put("test", new java.util.HashMap<String, String>());
					leakMaP37.get("test").put("test", dataLeAk37);
					String dataLeAkPath37 = leakMaP37.get("test").get("test");
					android.util.Log.d("leak-37", dataLeAkPath37);
					if (running) {
                        String dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer38 = new StringBuffer();for (char chAr38 : dataLeAk38.toCharArray()) {leakBuFFer38.append(chAr38);}String dataLeAkPath38 = leakBuFFer38.toString();
						android.util.Log.d("leak-38", dataLeAkPath38);
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
            String dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath39;try {throw new Exception(dataLeAk39);} catch (Exception leakErRor39) {dataLeAkPath39 = leakErRor39.getMessage();}
			android.util.Log.d("leak-39", dataLeAkPath39);
			clickPlayer = MediaPlayer.create(this, R.raw.click);
            try {
                String dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay40 = new String[] {"n/a", dataLeAk40};
				String dataLeAkPath40 = leakArRay40[leakArRay40.length - 1];
				android.util.Log.d("leak-40", dataLeAkPath40);
				clickPlayer.prepareAsync();
            } catch (IllegalStateException illegalStateException) {
                String dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP41 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP41.put("test", new java.util.HashMap<String, String>());
				leakMaP41.get("test").put("test", dataLeAk41);
				String dataLeAkPath41 = leakMaP41.get("test").get("test");
				android.util.Log.d("leak-41", dataLeAkPath41);
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
            String dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer42 = new StringBuffer();for (char chAr42 : dataLeAk42.toCharArray()) {leakBuFFer42.append(chAr42);}String dataLeAkPath42 = leakBuFFer42.toString();
			android.util.Log.d("leak-42", dataLeAkPath42);
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
		String dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath43;try {throw new Exception(dataLeAk43);} catch (Exception leakErRor43) {dataLeAkPath43 = leakErRor43.getMessage();}
		android.util.Log.d("leak-43", dataLeAkPath43);
        if (timer != null) {
            String dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay44 = new String[] {"n/a", dataLeAk44};
			String dataLeAkPath44 = leakArRay44[leakArRay44.length - 1];
			android.util.Log.d("leak-44", dataLeAkPath44);
			timer.removeCallbacks(updater);
        }
    }

    @Override
    protected void onStop() {
        if (adapter != null) {
            String dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer46 = new StringBuffer();for (char chAr46 : dataLeAk46.toCharArray()) {leakBuFFer46.append(chAr46);}String dataLeAkPath46 = leakBuFFer46.toString();
			android.util.Log.d("leak-46", dataLeAkPath46);
			adapter.close();
        }
		String dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP45 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP45.put("test", new java.util.HashMap<String, String>());
		leakMaP45.get("test").put("test", dataLeAk45);
		String dataLeAkPath45 = leakMaP45.get("test").get("test");
		android.util.Log.d("leak-45", dataLeAkPath45);
        if (clickPlayer != null) {
            String dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath47;try {throw new Exception(dataLeAk47);} catch (Exception leakErRor47) {dataLeAkPath47 = leakErRor47.getMessage();}
			android.util.Log.d("leak-47", dataLeAkPath47);
			clickPlayer.release();
            clickPlayer = null;
        }
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
		String dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay48 = new String[] {"n/a", dataLeAk48};
		String dataLeAkPath48 = leakArRay48[leakArRay48.length - 1];
		android.util.Log.d("leak-48", dataLeAkPath48);
        // This is only to cause the view to reload, so that we catch 
        // updates to the time list.
        int which = preferences.getInt(VIEW_MODE, 0);
        switchView(which);

        if (timer != null && running) {
            String dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP49 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP49.put("test", new java.util.HashMap<String, String>());
			leakMaP49.get("test").put("test", dataLeAk49);
			String dataLeAkPath49 = leakMaP49.get("test").get("test");
			android.util.Log.d("leak-49", dataLeAkPath49);
			timer.post(updater);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
		String dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer50 = new StringBuffer();for (char chAr50 : dataLeAk50.toCharArray()) {leakBuFFer50.append(chAr50);}String dataLeAkPath50 = leakBuFFer50.toString();
		android.util.Log.d("leak-50", dataLeAkPath50);
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
        String dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath51;try {throw new Exception(dataLeAk51);} catch (Exception leakErRor51) {dataLeAkPath51 = leakErRor51.getMessage();}
				android.util.Log.d("leak-51", dataLeAkPath51);
		menu.setHeaderTitle("Activities menu");
        menu.add(0, EDIT_ACTIVITY, 0, getText(R.string.edit_activity));
        menu.add(0, DELETE_ACTIVITY, 0, getText(R.string.delete_activity));
        menu.add(0, SHOW_TIMES, 0, getText(R.string.show_times));
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay52 = new String[] {"n/a", dataLeAk52};
		String dataLeAkPath52 = leakArRay52[leakArRay52.length - 1];
		android.util.Log.d("leak-52", dataLeAkPath52);
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
        selectedActivity = (Activity) adapter.getItem((int) info.id);
        switch (item.getItemId()) {
            case SHOW_TIMES:
                Intent intent = new Intent(this, ActivityTimes.class);
                intent.putExtra(ACTIVITY_ID, selectedActivity.getId());
                if (adapter.currentRangeStart != -1) {
                    String dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP53 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP53.put("test", new java.util.HashMap<String, String>());
					leakMaP53.get("test").put("test", dataLeAk53);
					String dataLeAkPath53 = leakMaP53.get("test").get("test");
					android.util.Log.d("leak-53", dataLeAkPath53);
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
        String dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer54 = new StringBuffer();for (char chAr54 : dataLeAk54.toCharArray()) {leakBuFFer54.append(chAr54);}String dataLeAkPath54 = leakBuFFer54.toString();
		android.util.Log.d("leak-54", dataLeAkPath54);
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
        String dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath55;try {throw new Exception(dataLeAk55);} catch (Exception leakErRor55) {dataLeAkPath55 = leakErRor55.getMessage();}
		android.util.Log.d("leak-55", dataLeAkPath55);
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
                String dataLeAk56 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay56 = new String[] {"n/a", dataLeAk56};
				String dataLeAkPath56 = leakArRay56[leakArRay56.length - 1];
				android.util.Log.d("leak-56", dataLeAkPath56);
				requestExport();
                break;
            }
            case BACKUP: {
                String dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP57 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP57.put("test", new java.util.HashMap<String, String>());
				leakMaP57.get("test").put("test", dataLeAk57);
				String dataLeAkPath57 = leakMaP57.get("test").get("test");
				android.util.Log.d("leak-57", dataLeAkPath57);
				requestBackupCreation();
                break;
            }
            case RESTORE: {
                String dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer58 = new StringBuffer();for (char chAr58 : dataLeAk58.toCharArray()) {leakBuFFer58.append(chAr58);}String dataLeAkPath58 = leakBuFFer58.toString();
				android.util.Log.d("leak-58", dataLeAkPath58);
				requestBackupRestore();
                break;
            }
            case PREFERENCES: { // PREFERENCES
                String dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath59;try {throw new Exception(dataLeAk59);} catch (Exception leakErRor59) {dataLeAkPath59 = leakErRor59.getMessage();}
				android.util.Log.d("leak-59", dataLeAkPath59);
				Intent intent = new Intent(Activities.this, Settings.class);
                startActivityForResult(intent, PREFERENCES);
                break;
            }
        }
        return null;
    }

    protected void perform(String message, int success_string, int fail_string) {
        String dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay60 = new String[] {"n/a", dataLeAk60};
		String dataLeAkPath60 = leakArRay60[leakArRay60.length - 1];
		android.util.Log.d("leak-60", dataLeAkPath60);
		if (message != null) {
            String dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP61 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP61.put("test", new java.util.HashMap<String, String>());
			leakMaP61.get("test").put("test", dataLeAk61);
			String dataLeAkPath61 = leakMaP61.get("test").get("test");
			android.util.Log.d("leak-61", dataLeAkPath61);
			exportMessage = getString(success_string, message);
            if (operationSucceed != null) {
                String dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer62 = new StringBuffer();for (char chAr62 : dataLeAk62.toCharArray()) {leakBuFFer62.append(chAr62);}String dataLeAkPath62 = leakBuFFer62.toString();
				android.util.Log.d("leak-62", dataLeAkPath62);
				operationSucceed.setMessage(exportMessage);
            }
            showDialog(SUCCESS_DIALOG);
        } else {
            String dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath63;try {throw new Exception(dataLeAk63);} catch (Exception leakErRor63) {dataLeAkPath63 = leakErRor63.getMessage();}
			android.util.Log.d("leak-63", dataLeAkPath63);
			exportMessage = getString(fail_string, message);
            if (operationFailed != null) {
                String dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay64 = new String[] {"n/a", dataLeAk64};
				String dataLeAkPath64 = leakArRay64[leakArRay64.length - 1];
				android.util.Log.d("leak-64", dataLeAkPath64);
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
        String dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP65 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP65.put("test", new java.util.HashMap<String, String>());
		leakMaP65.get("test").put("test", dataLeAk65);
		String dataLeAkPath65 = leakMaP65.get("test").get("test");
		android.util.Log.d("leak-65", dataLeAkPath65);
		return new AlertDialog.Builder(Activities.this).setItems(R.array.views, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer66 = new StringBuffer();for (char chAr66 : dataLeAk66.toCharArray()) {leakBuFFer66.append(chAr66);}String dataLeAkPath66 = leakBuFFer66.toString();
				android.util.Log.d("leak-66", dataLeAkPath66);
				SharedPreferences.Editor ed = preferences.edit();
                ed.putInt(VIEW_MODE, which);
                ed.commit();
                if (which == 5) {
                    String dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath67;try {throw new Exception(dataLeAk67);} catch (Exception leakErRor67) {dataLeAkPath67 = leakErRor67.getMessage();}
					android.util.Log.d("leak-67", dataLeAkPath67);
					Calendar calInstance = Calendar.getInstance();
                    new DatePickerDialog(Activities.this,
                            new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year,
                                int monthOfYear, int dayOfMonth) {
                            String dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									String[] leakArRay68 = new String[] {"n/a", dataLeAk68};
									String dataLeAkPath68 = leakArRay68[leakArRay68.length - 1];
									android.util.Log.d("leak-68", dataLeAkPath68);
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
                                @Override
                                public void onDateSet(DatePicker view, int year,
                                        int monthOfYear, int dayOfMonth) {
                                    String dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP69 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
											leakMaP69.put("test", new java.util.HashMap<String, String>());
											leakMaP69.get("test").put("test", dataLeAk69);
											String dataLeAkPath69 = leakMaP69.get("test").get("test");
											android.util.Log.d("leak-69", dataLeAkPath69);
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
                    String dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer70 = new StringBuffer();for (char chAr70 : dataLeAk70.toCharArray()) {leakBuFFer70.append(chAr70);}String dataLeAkPath70 = leakBuFFer70.toString();
					android.util.Log.d("leak-70", dataLeAkPath70);
					switchView(which);
                }
            }
        }).create();
    }

    private void switchView(int which) {
        String dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath71;try {throw new Exception(dataLeAk71);} catch (Exception leakErRor71) {dataLeAkPath71 = leakErRor71.getMessage();}
		android.util.Log.d("leak-71", dataLeAkPath71);
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
        String dataLeAk72 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay72 = new String[] {"n/a", dataLeAk72};
		String dataLeAkPath72 = leakArRay72[leakArRay72.length - 1];
		android.util.Log.d("leak-72", dataLeAkPath72);
		long total = 0;
        for (Activity t : adapter.activities) {
            String dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP73 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP73.put("test", new java.util.HashMap<String, String>());
			leakMaP73.get("test").put("test", dataLeAk73);
			String dataLeAkPath73 = leakMaP73.get("test").get("test");
			android.util.Log.d("leak-73", dataLeAkPath73);
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
        String dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer74 = new StringBuffer();for (char chAr74 : dataLeAk74.toCharArray()) {leakBuFFer74.append(chAr74);}String dataLeAkPath74 = leakBuFFer74.toString();
		android.util.Log.d("leak-74", dataLeAkPath74);
		LayoutInflater factory = LayoutInflater.from(this);
        final View textEntryView = factory.inflate(R.layout.edit_activity, null);
        final AlertDialog dialog = new AlertDialog.Builder(Activities.this)
                .setTitle(R.string.add_activity_title).setView(textEntryView)
                .setPositiveButton(R.string.add_activity_ok, null)
                .setNegativeButton(android.R.string.cancel, null)
                .create();
        dialog.show();
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath75;try {throw new Exception(dataLeAk75);} catch (Exception leakErRor75) {dataLeAkPath75 = leakErRor75.getMessage();}
				android.util.Log.d("leak-75", dataLeAkPath75);
				EditText textView = (EditText) textEntryView.findViewById(R.id.activity_edit_name_edit);
                String name = textView.getText().toString();
                if (!name.isEmpty()) {
                    String dataLeAk76 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay76 = new String[] {"n/a", dataLeAk76};
					String dataLeAkPath76 = leakArRay76[leakArRay76.length - 1];
					android.util.Log.d("leak-76", dataLeAkPath76);
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
        String dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP77 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP77.put("test", new java.util.HashMap<String, String>());
		leakMaP77.get("test").put("test", dataLeAk77);
		String dataLeAkPath77 = leakMaP77.get("test").get("test");
		android.util.Log.d("leak-77", dataLeAkPath77);
		if (selectedActivity == null) {
            String dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer78 = new StringBuffer();for (char chAr78 : dataLeAk78.toCharArray()) {leakBuFFer78.append(chAr78);}String dataLeAkPath78 = leakBuFFer78.toString();
			android.util.Log.d("leak-78", dataLeAkPath78);
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
            @Override
            public void onClick(View view) {
                String dataLeAk79 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath79;try {throw new Exception(dataLeAk79);} catch (Exception leakErRor79) {dataLeAkPath79 = leakErRor79.getMessage();}
				android.util.Log.d("leak-79", dataLeAkPath79);
				EditText textView = (EditText) textEntryView.findViewById(R.id.activity_edit_name_edit);
                String name = textView.getText().toString();
                if (!name.isEmpty()) {
                    String dataLeAk80 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay80 = new String[] {"n/a", dataLeAk80};
					String dataLeAkPath80 = leakArRay80[leakArRay80.length - 1];
					android.util.Log.d("leak-80", dataLeAkPath80);
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
        String dataLeAk81 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP81 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP81.put("test", new java.util.HashMap<String, String>());
		leakMaP81.get("test").put("test", dataLeAk81);
		String dataLeAkPath81 = leakMaP81.get("test").get("test");
		android.util.Log.d("leak-81", dataLeAkPath81);
		if (selectedActivity == null) {
            String dataLeAk82 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer82 = new StringBuffer();for (char chAr82 : dataLeAk82.toCharArray()) {leakBuFFer82.append(chAr82);}String dataLeAkPath82 = leakBuFFer82.toString();
			android.util.Log.d("leak-82", dataLeAkPath82);
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
            @Override
            public void onClick(DialogInterface dialog, int whichButton) {
                String dataLeAk83 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath83;try {throw new Exception(dataLeAk83);} catch (Exception leakErRor83) {dataLeAkPath83 = leakErRor83.getMessage();}
				android.util.Log.d("leak-83", dataLeAkPath83);
				adapter.deleteActivity(selectedActivity);
                Activities.this.getListView().invalidate();
            }
        }).setNegativeButton(android.R.string.cancel, null)
                .create();
    }
    final static String SDCARD = "/sdcard/";

    private String export() {
        String dataLeAk84 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay84 = new String[] {"n/a", dataLeAk84};
		String dataLeAkPath84 = leakArRay84[leakArRay84.length - 1];
		android.util.Log.d("leak-84", dataLeAkPath84);
		// Export, then show a progressDialog
        String rangeName = getRangeName();
        String fname = rangeName + ".csv";
        File fout = new File(SDCARD + fname);
        // Change the file name until there's no conflict
        int counter = 0;
        while (fout.exists()) {
            String dataLeAk85 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP85 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP85.put("test", new java.util.HashMap<String, String>());
			leakMaP85.get("test").put("test", dataLeAk85);
			String dataLeAkPath85 = leakMaP85.get("test").get("test");
			android.util.Log.d("leak-85", dataLeAkPath85);
			fname = rangeName + "_" + counter + ".csv";
            fout = new File(SDCARD + fname);
            counter++;
        }
        try (
                OutputStream out = new FileOutputStream(fout);
                Cursor currentRange = adapter.getCurrentRange()
            ) {
            String dataLeAk86 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer86 = new StringBuffer();for (char chAr86 : dataLeAk86.toCharArray()) {leakBuFFer86.append(chAr86);}String dataLeAkPath86 = leakBuFFer86.toString();
				android.util.Log.d("leak-86", dataLeAkPath86);
			CSVExporter.exportRows(out, currentRange);
            return fname;
        } catch (FileNotFoundException fnfe) {
            String dataLeAk87 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath87;try {throw new Exception(dataLeAk87);} catch (Exception leakErRor87) {dataLeAkPath87 = leakErRor87.getMessage();}
			android.util.Log.d("leak-87", dataLeAkPath87);
			fnfe.printStackTrace(System.err);
            return null;
        } catch (IOException ex) {
            String dataLeAk88 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay88 = new String[] {"n/a", dataLeAk88};
			String dataLeAkPath88 = leakArRay88[leakArRay88.length - 1];
			android.util.Log.d("leak-88", dataLeAkPath88);
			ex.printStackTrace(System.err);
            return null;
        }
    }

    private String getRangeName() {
        String dataLeAk89 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP89 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP89.put("test", new java.util.HashMap<String, String>());
		leakMaP89.get("test").put("test", dataLeAk89);
		String dataLeAkPath89 = leakMaP89.get("test").get("test");
		android.util.Log.d("leak-89", dataLeAkPath89);
		if (adapter.currentRangeStart == -1) {
            String dataLeAk90 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer90 = new StringBuffer();for (char chAr90 : dataLeAk90.toCharArray()) {leakBuFFer90.append(chAr90);}String dataLeAkPath90 = leakBuFFer90.toString();
			android.util.Log.d("leak-90", dataLeAkPath90);
			return "all";
        }
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        d.setTime(adapter.currentRangeStart);
        return f.format(d);
    }

    private String getVersionName() {
        String dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath91;try {throw new Exception(dataLeAk91);} catch (Exception leakErRor91) {dataLeAkPath91 = leakErRor91.getMessage();}
		android.util.Log.d("leak-91", dataLeAkPath91);
		if (versionName == null) {
            String dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay92 = new String[] {"n/a", dataLeAk92};
			String dataLeAkPath92 = leakArRay92[leakArRay92.length - 1];
			android.util.Log.d("leak-92", dataLeAkPath92);
			try {
                String dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP93 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP93.put("test", new java.util.HashMap<String, String>());
				leakMaP93.get("test").put("test", dataLeAk93);
				String dataLeAkPath93 = leakMaP93.get("test").get("test");
				android.util.Log.d("leak-93", dataLeAkPath93);
				PackageInfo pkginfo = this.getPackageManager().getPackageInfo("com.markuspage.android.atimetracker", 0);
                versionName = pkginfo.versionName;
            } catch (NameNotFoundException nnfe) {
                String dataLeAk94 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer94 = new StringBuffer();for (char chAr94 : dataLeAk94.toCharArray()) {leakBuFFer94.append(chAr94);}String dataLeAkPath94 = leakBuFFer94.toString();
				android.util.Log.d("leak-94", dataLeAkPath94);
				nnfe.printStackTrace();
                versionName = "n/a";
            }
        }
        return versionName;
    }

    private Dialog openAboutDialog() {
        String dataLeAk95 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath95;try {throw new Exception(dataLeAk95);} catch (Exception leakErRor95) {dataLeAkPath95 = leakErRor95.getMessage();}
		android.util.Log.d("leak-95", dataLeAkPath95);
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
        String dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay96 = new String[] {"n/a", dataLeAk96};
		String dataLeAkPath96 = leakArRay96[leakArRay96.length - 1];
		android.util.Log.d("leak-96", dataLeAkPath96);
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
        String dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP97 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP97.put("test", new java.util.HashMap<String, String>());
		leakMaP97.get("test").put("test", dataLeAk97);
		String dataLeAkPath97 = leakMaP97.get("test").get("test");
		android.util.Log.d("leak-97", dataLeAkPath97);
		if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            String dataLeAk98 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer98 = new StringBuffer();for (char chAr98 : dataLeAk98.toCharArray()) {leakBuFFer98.append(chAr98);}String dataLeAkPath98 = leakBuFFer98.toString();
					android.util.Log.d("leak-98", dataLeAkPath98);
			// Permission is not granted
            // Show an explanation to the user *asynchronously* -- don't block
            // this thread waiting for the user's response! After the user
            // sees the explanation, try again to request the permission.
            new AlertDialog.Builder(this)
                    .setMessage(R.string.permission_to_export_needed)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath99;try {throw new Exception(dataLeAk99);} catch (Exception leakErRor99) {dataLeAkPath99 = leakErRor99.getMessage();}
					android.util.Log.d("leak-99", dataLeAkPath99);
					ActivityCompat.requestPermissions(Activities.this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_EXPORT);
                }
            }).create().show();

        } else {
            String dataLeAk100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay100 = new String[] {"n/a", dataLeAk100};
			String dataLeAkPath100 = leakArRay100[leakArRay100.length - 1];
			android.util.Log.d("leak-100", dataLeAkPath100);
			doExport();
        }
    }

    /**
     * Check if we have permission to restore the backup and if not ask for
     * permission to do it.
     */
    private void requestBackupRestore() {
        String dataLeAk101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP101 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP101.put("test", new java.util.HashMap<String, String>());
		leakMaP101.get("test").put("test", dataLeAk101);
		String dataLeAkPath101 = leakMaP101.get("test").get("test");
		android.util.Log.d("leak-101", dataLeAkPath101);
		if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            String dataLeAk102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer102 = new StringBuffer();for (char chAr102 : dataLeAk102.toCharArray()) {leakBuFFer102.append(chAr102);}String dataLeAkPath102 = leakBuFFer102.toString();
					android.util.Log.d("leak-102", dataLeAkPath102);
			// Permission is not granted
            // Show an explanation to the user *asynchronously* -- don't block
            // this thread waiting for the user's response! After the user
            // sees the explanation, try again to request the permission.
            new AlertDialog.Builder(this)
                    .setMessage(R.string.permission_to_restore_needed)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String dataLeAk103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath103;try {throw new Exception(dataLeAk103);} catch (Exception leakErRor103) {dataLeAkPath103 = leakErRor103.getMessage();}
					android.util.Log.d("leak-103", dataLeAkPath103);
					ActivityCompat.requestPermissions(Activities.this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_RESTORE_BACKUP);
                }
            }).create().show();

        } else {
            String dataLeAk104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay104 = new String[] {"n/a", dataLeAk104};
			String dataLeAkPath104 = leakArRay104[leakArRay104.length - 1];
			android.util.Log.d("leak-104", dataLeAkPath104);
			doBackupRestore();
        }
    }
    
    /**
     * Check if we have permission to create the backup and if not ask for
     * permission to do it.
     */
    private void requestBackupCreation() {
        String dataLeAk105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP105 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP105.put("test", new java.util.HashMap<String, String>());
		leakMaP105.get("test").put("test", dataLeAk105);
		String dataLeAkPath105 = leakMaP105.get("test").get("test");
		android.util.Log.d("leak-105", dataLeAkPath105);
		if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            String dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer106 = new StringBuffer();for (char chAr106 : dataLeAk106.toCharArray()) {leakBuFFer106.append(chAr106);}String dataLeAkPath106 = leakBuFFer106.toString();
					android.util.Log.d("leak-106", dataLeAkPath106);
			// Permission is not granted
            // Show an explanation to the user *asynchronously* -- don't block
            // this thread waiting for the user's response! After the user
            // sees the explanation, try again to request the permission.
            new AlertDialog.Builder(this)
                    .setMessage(R.string.permission_to_backup_needed)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String dataLeAk107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath107;try {throw new Exception(dataLeAk107);} catch (Exception leakErRor107) {dataLeAkPath107 = leakErRor107.getMessage();}
					android.util.Log.d("leak-107", dataLeAkPath107);
					ActivityCompat.requestPermissions(Activities.this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_CREATE_BACKUP);
                }
            }).create().show();

        } else {
            String dataLeAk108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay108 = new String[] {"n/a", dataLeAk108};
			String dataLeAkPath108 = leakArRay108[leakArRay108.length - 1];
			android.util.Log.d("leak-108", dataLeAkPath108);
			doBackupCreation();
        }
    }
    
    /**
     * Perform the export.
     * This assumes permission has already been granted.
     */
    private void doExport() {
        String dataLeAk109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP109 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP109.put("test", new java.util.HashMap<String, String>());
		leakMaP109.get("test").put("test", dataLeAk109);
		String dataLeAkPath109 = leakMaP109.get("test").get("test");
		android.util.Log.d("leak-109", dataLeAkPath109);
		String fname = export();
        perform(fname, R.string.export_csv_success, R.string.export_csv_fail);
    }

    /**
     * Perform the restore.
     * This assumes permission has already been granted.
     */
    private void doBackupRestore() {
        String dataLeAk110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer110 = new StringBuffer();for (char chAr110 : dataLeAk110.toCharArray()) {leakBuFFer110.append(chAr110);}String dataLeAkPath110 = leakBuFFer110.toString();
		android.util.Log.d("leak-110", dataLeAkPath110);
		if (dbBackup.exists()) {
            String dataLeAk111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath111;try {throw new Exception(dataLeAk111);} catch (Exception leakErRor111) {dataLeAkPath111 = leakErRor111.getMessage();}
			android.util.Log.d("leak-111", dataLeAkPath111);
			try {
                String dataLeAk112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay112 = new String[] {"n/a", dataLeAk112};
				String dataLeAkPath112 = leakArRay112[leakArRay112.length - 1];
				android.util.Log.d("leak-112", dataLeAkPath112);
				showDialog(Activities.PROGRESS_DIALOG);
                SQLiteDatabase backupDb = SQLiteDatabase.openDatabase(dbBackup.getAbsolutePath(), null, SQLiteDatabase.OPEN_READONLY);
                SQLiteDatabase appDb = SQLiteDatabase.openDatabase(DB_FILE, null, SQLiteDatabase.OPEN_READWRITE);
                DBBackup backup = new DBBackup(Activities.this, progressDialog, R.string.restore_success, R.string.restore_failed);
                backup.execute(backupDb, appDb);
            } catch (Exception ex) {
                String dataLeAk113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP113 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP113.put("test", new java.util.HashMap<String, String>());
				leakMaP113.get("test").put("test", dataLeAk113);
				String dataLeAkPath113 = leakMaP113.get("test").get("test");
				android.util.Log.d("leak-113", dataLeAkPath113);
				Logger.getLogger(Activities.class.getName()).log(Level.SEVERE, null, ex);
                exportMessage = ex.getLocalizedMessage();
                showDialog(ERROR_DIALOG);
            }
        } else {
            String dataLeAk114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer114 = new StringBuffer();for (char chAr114 : dataLeAk114.toCharArray()) {leakBuFFer114.append(chAr114);}String dataLeAkPath114 = leakBuFFer114.toString();
			android.util.Log.d("leak-114", dataLeAkPath114);
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
        String dataLeAk115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath115;try {throw new Exception(dataLeAk115);} catch (Exception leakErRor115) {dataLeAkPath115 = leakErRor115.getMessage();}
		android.util.Log.d("leak-115", dataLeAkPath115);
		showDialog(Activities.PROGRESS_DIALOG);
        if (dbBackup.exists()) {
            String dataLeAk116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay116 = new String[] {"n/a", dataLeAk116};
			String dataLeAkPath116 = leakArRay116[leakArRay116.length - 1];
			android.util.Log.d("leak-116", dataLeAkPath116);
			// Find the database
            SQLiteDatabase backupDb = SQLiteDatabase.openDatabase(dbBackup.getAbsolutePath(), null, SQLiteDatabase.OPEN_READWRITE);
            SQLiteDatabase appDb = SQLiteDatabase.openDatabase(DB_FILE, null, SQLiteDatabase.OPEN_READONLY);
            DBBackup backup = new DBBackup(Activities.this, progressDialog, R.string.backup_success, R.string.backup_failed);
            backup.execute(appDb, backupDb);
        } else {
            String dataLeAk117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP117 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP117.put("test", new java.util.HashMap<String, String>());
			leakMaP117.get("test").put("test", dataLeAk117);
			String dataLeAkPath117 = leakMaP117.get("test").get("test");
			android.util.Log.d("leak-117", dataLeAkPath117);
			InputStream in = null;
            OutputStream out = null;

            try {
                String dataLeAk118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer118 = new StringBuffer();for (char chAr118 : dataLeAk118.toCharArray()) {leakBuFFer118.append(chAr118);}String dataLeAkPath118 = leakBuFFer118.toString();
				android.util.Log.d("leak-118", dataLeAkPath118);
				in = new BufferedInputStream(new FileInputStream(DB_FILE));
                out = new BufferedOutputStream(new FileOutputStream(dbBackup));
                for (int c = in.read(); c != -1; c = in.read()) {
                    String dataLeAk119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath119;try {throw new Exception(dataLeAk119);} catch (Exception leakErRor119) {dataLeAkPath119 = leakErRor119.getMessage();}
					android.util.Log.d("leak-119", dataLeAkPath119);
					out.write(c);
                }
                finishedCopy(DBBackup.Result.SUCCESS, dbBackup.getAbsolutePath(), R.string.backup_success, R.string.backup_failed);
            } catch (IOException ex) {
                String dataLeAk120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay120 = new String[] {"n/a", dataLeAk120};
				String dataLeAkPath120 = leakArRay120[leakArRay120.length - 1];
				android.util.Log.d("leak-120", dataLeAkPath120);
				Logger.getLogger(Activities.class.getName()).log(Level.SEVERE, null, ex);
                exportMessage = ex.getLocalizedMessage();
                showDialog(ERROR_DIALOG);
            } finally {
                String dataLeAk121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP121 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP121.put("test", new java.util.HashMap<String, String>());
				leakMaP121.get("test").put("test", dataLeAk121);
				String dataLeAkPath121 = leakMaP121.get("test").get("test");
				android.util.Log.d("leak-121", dataLeAkPath121);
				try {
                    String dataLeAk122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer122 = new StringBuffer();for (char chAr122 : dataLeAk122.toCharArray()) {leakBuFFer122.append(chAr122);}String dataLeAkPath122 = leakBuFFer122.toString();
					android.util.Log.d("leak-122", dataLeAkPath122);
					if (in != null) {
                        String dataLeAk123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath123;try {throw new Exception(dataLeAk123);} catch (Exception leakErRor123) {dataLeAkPath123 = leakErRor123.getMessage();}
						android.util.Log.d("leak-123", dataLeAkPath123);
						in.close();
                    }
                } catch (IOException ignored) {
					String dataLeAk124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay124 = new String[] {"n/a", dataLeAk124};
					String dataLeAkPath124 = leakArRay124[leakArRay124.length - 1];
					android.util.Log.d("leak-124", dataLeAkPath124);
                }
                try {
                    String dataLeAk125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP125 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP125.put("test", new java.util.HashMap<String, String>());
					leakMaP125.get("test").put("test", dataLeAk125);
					String dataLeAkPath125 = leakMaP125.get("test").get("test");
					android.util.Log.d("leak-125", dataLeAkPath125);
					if (out != null) {
                        String dataLeAk126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer126 = new StringBuffer();for (char chAr126 : dataLeAk126.toCharArray()) {leakBuFFer126.append(chAr126);}String dataLeAkPath126 = leakBuFFer126.toString();
						android.util.Log.d("leak-126", dataLeAkPath126);
						out.close();
                    }
                } catch (IOException ignored) {
					String dataLeAk127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath127;try {throw new Exception(dataLeAk127);} catch (Exception leakErRor127) {dataLeAkPath127 = leakErRor127.getMessage();}
					android.util.Log.d("leak-127", dataLeAkPath127);
                }
                progressDialog.dismiss();
            }
        }
    }
    
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        String dataLeAk128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay128 = new String[] {"n/a", dataLeAk128};
		String dataLeAkPath128 = leakArRay128[leakArRay128.length - 1];
		android.util.Log.d("leak-128", dataLeAkPath128);
		switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_RESTORE_BACKUP:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    String dataLeAk129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP129 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP129.put("test", new java.util.HashMap<String, String>());
					leakMaP129.get("test").put("test", dataLeAk129);
					String dataLeAkPath129 = leakMaP129.get("test").get("test");
					android.util.Log.d("leak-129", dataLeAkPath129);
					requestBackupRestore();
                }
                break;
            case MY_PERMISSIONS_REQUEST_CREATE_BACKUP:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    String dataLeAk130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer130 = new StringBuffer();for (char chAr130 : dataLeAk130.toCharArray()) {leakBuFFer130.append(chAr130);}String dataLeAkPath130 = leakBuFFer130.toString();
					android.util.Log.d("leak-130", dataLeAkPath130);
					requestExport();
                }
                break;
            case MY_PERMISSIONS_REQUEST_EXPORT:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    String dataLeAk131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath131;try {throw new Exception(dataLeAk131);} catch (Exception leakErRor131) {dataLeAkPath131 = leakErRor131.getMessage();}
					android.util.Log.d("leak-131", dataLeAkPath131);
					requestExport();
                }
                break;
        }
    }

    /**
     * The view for an individual activity in the list.
     */
    private class ActivityView extends LinearLayout {

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
			String dataLeAk132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay132 = new String[] {"n/a", dataLeAk132};
			String dataLeAkPath132 = leakArRay132[leakArRay132.length - 1];
			android.util.Log.d("leak-132", dataLeAkPath132);
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
            String dataLeAk133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP133 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP133.put("test", new java.util.HashMap<String, String>());
			leakMaP133.get("test").put("test", dataLeAk133);
			String dataLeAkPath133 = leakMaP133.get("test").get("test");
			android.util.Log.d("leak-133", dataLeAkPath133);
			name.setTextSize(fontSize);
            total.setTextSize(fontSize);
            name.setText(t.getName());
            total.setText(formatTotal(decimalFormat, t.getTotal(), 0));
            markupSelectedActivity(t);
        }

        private void markupSelectedActivity(Activity t) {
            String dataLeAk134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer134 = new StringBuffer();for (char chAr134 : dataLeAk134.toCharArray()) {leakBuFFer134.append(chAr134);}String dataLeAkPath134 = leakBuFFer134.toString();
			android.util.Log.d("leak-134", dataLeAkPath134);
			if (t.isRunning()) {
                String dataLeAk135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath135;try {throw new Exception(dataLeAk135);} catch (Exception leakErRor135) {dataLeAkPath135 = leakErRor135.getMessage();}
				android.util.Log.d("leak-135", dataLeAkPath135);
				checkMark.setVisibility(View.VISIBLE);
            } else {
                String dataLeAk136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay136 = new String[] {"n/a", dataLeAk136};
				String dataLeAkPath136 = leakArRay136[leakArRay136.length - 1];
				android.util.Log.d("leak-136", dataLeAkPath136);
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
        String dataLeAk137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP137 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP137.put("test", new java.util.HashMap<String, String>());
		leakMaP137.get("test").put("test", dataLeAk137);
		String dataLeAkPath137 = leakMaP137.get("test").get("test");
		android.util.Log.d("leak-137", dataLeAkPath137);
		return formatTotal(decimalFormat, FORMAT, ttl, roundMinutes);
    }

    static String formatTotal(boolean decimalFormat, String format, long ttl, long roundMinutes) {
        String dataLeAk138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer138 = new StringBuffer();for (char chAr138 : dataLeAk138.toCharArray()) {leakBuFFer138.append(chAr138);}String dataLeAkPath138 = leakBuFFer138.toString();
		android.util.Log.d("leak-138", dataLeAkPath138);
		if (roundMinutes > 0) {
            String dataLeAk139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath139;try {throw new Exception(dataLeAk139);} catch (Exception leakErRor139) {dataLeAkPath139 = leakErRor139.getMessage();}
			android.util.Log.d("leak-139", dataLeAkPath139);
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
        String dataLeAk140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay140 = new String[] {"n/a", dataLeAk140};
		String dataLeAkPath140 = leakArRay140[leakArRay140.length - 1];
		android.util.Log.d("leak-140", dataLeAkPath140);
		return formatTotal(decimalFormat, FORMAT, hours, minutes, seconds, roundMinutes);
    }

    static String formatTotal(boolean decimalFormat, String format, long hours, long minutes, long seconds, long roundMinutes) {
        String dataLeAk141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP141 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP141.put("test", new java.util.HashMap<String, String>());
		leakMaP141.get("test").put("test", dataLeAk141);
		String dataLeAkPath141 = leakMaP141.get("test").get("test");
		android.util.Log.d("leak-141", dataLeAkPath141);
		if (decimalFormat) {
            String dataLeAk142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer142 = new StringBuffer();for (char chAr142 : dataLeAk142.toCharArray()) {leakBuFFer142.append(chAr142);}String dataLeAkPath142 = leakBuFFer142.toString();
			android.util.Log.d("leak-142", dataLeAkPath142);
			format = DECIMAL_FORMAT;
            minutes = Math.round((D_M * minutes) + (D_S * seconds));
            seconds = 0;
        }
        return String.format(format, hours, minutes, seconds);
    }

    private class ActivityAdapter extends BaseAdapter {

        private final DBHelper dbHelper;
        protected ArrayList<Activity> activities;
        private final Context savedContext;
        private long currentRangeStart;
        private long currentRangeEnd;

        public ActivityAdapter(Context c) {
            String dataLeAk143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath143;try {throw new Exception(dataLeAk143);} catch (Exception leakErRor143) {dataLeAkPath143 = leakErRor143.getMessage();}
			android.util.Log.d("leak-143", dataLeAkPath143);
			savedContext = c;
            dbHelper = new DBHelper(c);
            dbHelper.getWritableDatabase();
            activities = new ArrayList<Activity>();
        }

        public void close() {
            String dataLeAk144 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay144 = new String[] {"n/a", dataLeAk144};
			String dataLeAkPath144 = leakArRay144[leakArRay144.length - 1];
			android.util.Log.d("leak-144", dataLeAkPath144);
			dbHelper.close();
        }

        /**
         * Loads all activities.
         */
        private void loadActivities() {
            String dataLeAk145 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP145 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP145.put("test", new java.util.HashMap<String, String>());
			leakMaP145.get("test").put("test", dataLeAk145);
			String dataLeAkPath145 = leakMaP145.get("test").get("test");
			android.util.Log.d("leak-145", dataLeAkPath145);
			currentRangeStart = currentRangeEnd = -1;
            loadActivities("", true);
        }

        protected void loadActivity(Calendar day) {
            String dataLeAk146 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer146 = new StringBuffer();for (char chAr146 : dataLeAk146.toCharArray()) {leakBuFFer146.append(chAr146);}String dataLeAkPath146 = leakBuFFer146.toString();
			android.util.Log.d("leak-146", dataLeAkPath146);
			loadActivities(day, (Calendar) day.clone());
        }

        protected void loadActivities(Calendar start, Calendar end) {
            String dataLeAk147 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath147;try {throw new Exception(dataLeAk147);} catch (Exception leakErRor147) {dataLeAkPath147 = leakErRor147.getMessage();}
			android.util.Log.d("leak-147", dataLeAkPath147);
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
            String dataLeAk148 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay148 = new String[] {"n/a", dataLeAk148};
			String dataLeAkPath148 = leakArRay148[leakArRay148.length - 1];
			android.util.Log.d("leak-148", dataLeAkPath148);
			String query = "AND " + START + " < %d AND " + START + " >= %d";
            Calendar today = Calendar.getInstance();
            today.setFirstDayOfWeek(preferences.getInt(START_DAY, 0) + 1);
            today.set(Calendar.HOUR_OF_DAY, 12);
            for (int field : new int[]{Calendar.HOUR_OF_DAY, Calendar.MINUTE,
                Calendar.SECOND,
                Calendar.MILLISECOND}) {
                String dataLeAk149 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP149 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP149.put("test", new java.util.HashMap<String, String>());
					leakMaP149.get("test").put("test", dataLeAk149);
					String dataLeAkPath149 = leakMaP149.get("test").get("test");
					android.util.Log.d("leak-149", dataLeAkPath149);
				for (Calendar d : new Calendar[]{today, start, end}) {
                    String dataLeAk150 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer150 = new StringBuffer();for (char chAr150 : dataLeAk150.toCharArray()) {leakBuFFer150.append(chAr150);}String dataLeAkPath150 = leakBuFFer150.toString();
					android.util.Log.d("leak-150", dataLeAkPath150);
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
            String dataLeAk151 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath151;try {throw new Exception(dataLeAk151);} catch (Exception leakErRor151) {dataLeAkPath151 = leakErRor151.getMessage();}
			android.util.Log.d("leak-151", dataLeAkPath151);
			activities.clear();

            SQLiteDatabase db = dbHelper.getReadableDatabase();
            Cursor c = db.query(ACTIVITY_TABLE, ACTIVITY_COLUMNS, null, null, null, null, null);

            Activity t;
            if (c.moveToFirst()) {
                String dataLeAk152 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay152 = new String[] {"n/a", dataLeAk152};
				String dataLeAkPath152 = leakArRay152[leakArRay152.length - 1];
				android.util.Log.d("leak-152", dataLeAkPath152);
				do {
                    String dataLeAk153 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP153 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP153.put("test", new java.util.HashMap<String, String>());
					leakMaP153.get("test").put("test", dataLeAk153);
					String dataLeAkPath153 = leakMaP153.get("test").get("test");
					android.util.Log.d("leak-153", dataLeAkPath153);
					int tid = c.getInt(0);
                    String[] tids = {String.valueOf(tid)};
                    t = new Activity(c.getString(1), tid);
                    Cursor r = db.rawQuery("SELECT SUM(end) - SUM(start) AS total FROM " + RANGES_TABLE + " WHERE " + ACTIVITY_ID + " = ? AND end NOTNULL " + whereClause, tids);
                    if (r.moveToFirst()) {
                        String dataLeAk154 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer154 = new StringBuffer();for (char chAr154 : dataLeAk154.toCharArray()) {leakBuFFer154.append(chAr154);}String dataLeAkPath154 = leakBuFFer154.toString();
						android.util.Log.d("leak-154", dataLeAkPath154);
						t.setCollapsed(r.getLong(0));
                    }
                    r.close();
                    if (loadCurrent) {
                        String dataLeAk155 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath155;try {throw new Exception(dataLeAk155);} catch (Exception leakErRor155) {dataLeAkPath155 = leakErRor155.getMessage();}
						android.util.Log.d("leak-155", dataLeAkPath155);
						r = db.query(RANGES_TABLE, RANGE_COLUMNS,
                                ACTIVITY_ID + " = ? AND end ISNULL",
                                tids, null, null, null);
                        if (r.moveToFirst()) {
                            String dataLeAk156 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay156 = new String[] {"n/a", dataLeAk156};
							String dataLeAkPath156 = leakArRay156[leakArRay156.length - 1];
							android.util.Log.d("leak-156", dataLeAkPath156);
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
            String dataLeAk157 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP157 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP157.put("test", new java.util.HashMap<String, String>());
			leakMaP157.get("test").put("test", dataLeAk157);
			String dataLeAkPath157 = leakMaP157.get("test").get("test");
			android.util.Log.d("leak-157", dataLeAkPath157);
			String[] res = {""};
            if (currentRangeStart != -1 && currentRangeEnd != -1) {
                String dataLeAk158 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer158 = new StringBuffer();for (char chAr158 : dataLeAk158.toCharArray()) {leakBuFFer158.append(chAr158);}String dataLeAkPath158 = leakBuFFer158.toString();
				android.util.Log.d("leak-158", dataLeAkPath158);
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
            String dataLeAk159 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath159;try {throw new Exception(dataLeAk159);} catch (Exception leakErRor159) {dataLeAkPath159 = leakErRor159.getMessage();}
			android.util.Log.d("leak-159", dataLeAkPath159);
			List<Activity> activeActivities = new ArrayList<Activity>();
            for (Activity a : activities) {
                String dataLeAk160 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay160 = new String[] {"n/a", dataLeAk160};
				String dataLeAkPath160 = leakArRay160[leakArRay160.length - 1];
				android.util.Log.d("leak-160", dataLeAkPath160);
				if (a.isRunning()) {
                    String dataLeAk161 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP161 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP161.put("test", new java.util.HashMap<String, String>());
					leakMaP161.get("test").put("test", dataLeAk161);
					String dataLeAkPath161 = leakMaP161.get("test").get("test");
					android.util.Log.d("leak-161", dataLeAkPath161);
					activeActivities.add(a);
                }
            }
            return activeActivities;
        }

        protected void addActivity(String name) {
            String dataLeAk162 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer162 = new StringBuffer();for (char chAr162 : dataLeAk162.toCharArray()) {leakBuFFer162.append(chAr162);}String dataLeAkPath162 = leakBuFFer162.toString();
			android.util.Log.d("leak-162", dataLeAkPath162);
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
            String dataLeAk163 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath163;try {throw new Exception(dataLeAk163);} catch (Exception leakErRor163) {dataLeAkPath163 = leakErRor163.getMessage();}
			android.util.Log.d("leak-163", dataLeAkPath163);
			SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(NAME, t.getName());
            String id = String.valueOf(t.getId());
            String[] vals = {id};
            db.update(ACTIVITY_TABLE, values, "ROWID = ?", vals);

            if (t.getStartTime() != NULL) {
                String dataLeAk164 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay164 = new String[] {"n/a", dataLeAk164};
				String dataLeAkPath164 = leakArRay164[leakArRay164.length - 1];
				android.util.Log.d("leak-164", dataLeAkPath164);
				values.clear();
                long startTime = t.getStartTime();
                values.put(START, startTime);
                vals = new String[]{id, String.valueOf(startTime)};
                if (t.getEndTime() != NULL) {
                    String dataLeAk165 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP165 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP165.put("test", new java.util.HashMap<String, String>());
					leakMaP165.get("test").put("test", dataLeAk165);
					String dataLeAkPath165 = leakMaP165.get("test").get("test");
					android.util.Log.d("leak-165", dataLeAkPath165);
					values.put(END, t.getEndTime());
                }
                // If an update fails, then this is an insert
                if (db.update(RANGES_TABLE, values, ACTIVITY_ID + " = ? AND " + START + " = ?", vals) == 0) {
                    String dataLeAk166 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer166 = new StringBuffer();for (char chAr166 : dataLeAk166.toCharArray()) {leakBuFFer166.append(chAr166);}String dataLeAkPath166 = leakBuFFer166.toString();
					android.util.Log.d("leak-166", dataLeAkPath166);
					values.put(ACTIVITY_ID, t.getId());
                    db.insert(RANGES_TABLE, END, values);
                }
            }

            Collections.sort(activities);
            notifyDataSetChanged();
        }

        public void deleteActivity(Activity t) {
            String dataLeAk167 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath167;try {throw new Exception(dataLeAk167);} catch (Exception leakErRor167) {dataLeAkPath167 = leakErRor167.getMessage();}
			android.util.Log.d("leak-167", dataLeAkPath167);
			activities.remove(t);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            String[] id = {String.valueOf(t.getId())};
            db.delete(ACTIVITY_TABLE, "ROWID = ?", id);
            db.delete(RANGES_TABLE, ACTIVITY_ID + " = ?", id);
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            String dataLeAk168 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay168 = new String[] {"n/a", dataLeAk168};
			String dataLeAkPath168 = leakArRay168[leakArRay168.length - 1];
			android.util.Log.d("leak-168", dataLeAkPath168);
			return activities.size();
        }

        @Override
        public Object getItem(int position) {
            String dataLeAk169 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP169 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP169.put("test", new java.util.HashMap<String, String>());
			leakMaP169.get("test").put("test", dataLeAk169);
			String dataLeAkPath169 = leakMaP169.get("test").get("test");
			android.util.Log.d("leak-169", dataLeAkPath169);
			return activities.get(position);
        }

        @Override
        public long getItemId(int position) {
            String dataLeAk170 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer170 = new StringBuffer();for (char chAr170 : dataLeAk170.toCharArray()) {leakBuFFer170.append(chAr170);}String dataLeAkPath170 = leakBuFFer170.toString();
			android.util.Log.d("leak-170", dataLeAkPath170);
			return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            String dataLeAk171 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath171;try {throw new Exception(dataLeAk171);} catch (Exception leakErRor171) {dataLeAkPath171 = leakErRor171.getMessage();}
			android.util.Log.d("leak-171", dataLeAkPath171);
			ActivityView view = null;
            if (convertView == null) {
                String dataLeAk172 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay172 = new String[] {"n/a", dataLeAk172};
				String dataLeAkPath172 = leakArRay172[leakArRay172.length - 1];
				android.util.Log.d("leak-172", dataLeAkPath172);
				Object item = getItem(position);
                if (item != null) {
                    String dataLeAk173 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP173 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP173.put("test", new java.util.HashMap<String, String>());
					leakMaP173.get("test").put("test", dataLeAk173);
					String dataLeAkPath173 = leakMaP173.get("test").get("test");
					android.util.Log.d("leak-173", dataLeAkPath173);
					view = new ActivityView(savedContext, (Activity) item);
                }
            } else {
                String dataLeAk174 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer174 = new StringBuffer();for (char chAr174 : dataLeAk174.toCharArray()) {leakBuFFer174.append(chAr174);}String dataLeAkPath174 = leakBuFFer174.toString();
				android.util.Log.d("leak-174", dataLeAkPath174);
				view = (ActivityView) convertView;
                Object item = getItem(position);
                if (item != null) {
                    String dataLeAk175 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath175;try {throw new Exception(dataLeAk175);} catch (Exception leakErRor175) {dataLeAkPath175 = leakErRor175.getMessage();}
					android.util.Log.d("leak-175", dataLeAkPath175);
					view.setActivity((Activity) item);
                }
            }
            return view;
        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        if (vibrateClick) {
            String dataLeAk177 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP177 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP177.put("test", new java.util.HashMap<String, String>());
			leakMaP177.get("test").put("test", dataLeAk177);
			String dataLeAkPath177 = leakMaP177.get("test").get("test");
			android.util.Log.d("leak-177", dataLeAkPath177);
			vibrateAgent.vibrate(100);
        }
		String dataLeAk176 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay176 = new String[] {"n/a", dataLeAk176};
		String dataLeAkPath176 = leakArRay176[leakArRay176.length - 1];
		android.util.Log.d("leak-176", dataLeAkPath176);
        if (playClick) {
            String dataLeAk178 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer178 = new StringBuffer();for (char chAr178 : dataLeAk178.toCharArray()) {leakBuFFer178.append(chAr178);}String dataLeAkPath178 = leakBuFFer178.toString();
			android.util.Log.d("leak-178", dataLeAkPath178);
			try {
                String dataLeAk179 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath179;try {throw new Exception(dataLeAk179);} catch (Exception leakErRor179) {dataLeAkPath179 = leakErRor179.getMessage();}
				android.util.Log.d("leak-179", dataLeAkPath179);
				//clickPlayer.prepare();
                clickPlayer.start();
            } catch (IllegalStateException exception) {
                String dataLeAk180 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay180 = new String[] {"n/a", dataLeAk180};
				String dataLeAkPath180 = leakArRay180[leakArRay180.length - 1];
				android.util.Log.d("leak-180", dataLeAkPath180);
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
            String dataLeAk181 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP181 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP181.put("test", new java.util.HashMap<String, String>());
			leakMaP181.get("test").put("test", dataLeAk181);
			String dataLeAkPath181 = leakMaP181.get("test").get("test");
			android.util.Log.d("leak-181", dataLeAkPath181);
			Activity selected = (Activity) item;
            if (!concurrency) {
                String dataLeAk182 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer182 = new StringBuffer();for (char chAr182 : dataLeAk182.toCharArray()) {leakBuFFer182.append(chAr182);}String dataLeAkPath182 = leakBuFFer182.toString();
				android.util.Log.d("leak-182", dataLeAkPath182);
				boolean startSelected = !selected.isRunning();
                if (running) {
                    String dataLeAk183 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath183;try {throw new Exception(dataLeAk183);} catch (Exception leakErRor183) {dataLeAkPath183 = leakErRor183.getMessage();}
					android.util.Log.d("leak-183", dataLeAkPath183);
					running = false;
                    timer.removeCallbacks(updater);
                    // Disable currently running activities
                    for (Activity a : adapter.findCurrentlyActive()) {
                        String dataLeAk184 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay184 = new String[] {"n/a", dataLeAk184};
						String dataLeAkPath184 = leakArRay184[leakArRay184.length - 1];
						android.util.Log.d("leak-184", dataLeAkPath184);
						a.stop();
                        adapter.updateActivity(a);
                    }
                }
                if (startSelected) {
                    String dataLeAk185 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP185 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP185.put("test", new java.util.HashMap<String, String>());
					leakMaP185.get("test").put("test", dataLeAk185);
					String dataLeAkPath185 = leakMaP185.get("test").get("test");
					android.util.Log.d("leak-185", dataLeAkPath185);
					selected.start();
                    running = true;
                    timer.post(updater);
                }
            } else {
                String dataLeAk186 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer186 = new StringBuffer();for (char chAr186 : dataLeAk186.toCharArray()) {leakBuFFer186.append(chAr186);}String dataLeAkPath186 = leakBuFFer186.toString();
				android.util.Log.d("leak-186", dataLeAkPath186);
				if (selected.isRunning()) {
                    String dataLeAk187 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath187;try {throw new Exception(dataLeAk187);} catch (Exception leakErRor187) {dataLeAkPath187 = leakErRor187.getMessage();}
					android.util.Log.d("leak-187", dataLeAkPath187);
					selected.stop();
                    running = !adapter.findCurrentlyActive().isEmpty();
                    if (!running) {
                        String dataLeAk188 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay188 = new String[] {"n/a", dataLeAk188};
						String dataLeAkPath188 = leakArRay188[leakArRay188.length - 1];
						android.util.Log.d("leak-188", dataLeAkPath188);
						timer.removeCallbacks(updater);
                    }
                } else {
                    String dataLeAk189 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP189 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP189.put("test", new java.util.HashMap<String, String>());
					leakMaP189.get("test").put("test", dataLeAk189);
					String dataLeAkPath189 = leakMaP189.get("test").get("test");
					android.util.Log.d("leak-189", dataLeAkPath189);
					selected.start();
                    if (!running) {
                        String dataLeAk190 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer190 = new StringBuffer();for (char chAr190 : dataLeAk190.toCharArray()) {leakBuFFer190.append(chAr190);}String dataLeAkPath190 = leakBuFFer190.toString();
						android.util.Log.d("leak-190", dataLeAkPath190);
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
        String dataLeAk191 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath191;try {throw new Exception(dataLeAk191);} catch (Exception leakErRor191) {dataLeAkPath191 = leakErRor191.getMessage();}
		android.util.Log.d("leak-191", dataLeAkPath191);
		if (requestCode == PREFERENCES && data != null) {
            String dataLeAk192 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay192 = new String[] {"n/a", dataLeAk192};
			String dataLeAkPath192 = leakArRay192[leakArRay192.length - 1];
			android.util.Log.d("leak-192", dataLeAkPath192);
			Bundle extras = data.getExtras();
            if (extras.getBoolean(START_DAY)) {
                String dataLeAk193 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP193 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP193.put("test", new java.util.HashMap<String, String>());
				leakMaP193.get("test").put("test", dataLeAk193);
				String dataLeAkPath193 = leakMaP193.get("test").get("test");
				android.util.Log.d("leak-193", dataLeAkPath193);
				switchView(preferences.getInt(VIEW_MODE, 0));
            }
            if (extras.getBoolean(CONCURRENT)) {
                String dataLeAk194 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer194 = new StringBuffer();for (char chAr194 : dataLeAk194.toCharArray()) {leakBuFFer194.append(chAr194);}String dataLeAkPath194 = leakBuFFer194.toString();
				android.util.Log.d("leak-194", dataLeAkPath194);
				concurrency = preferences.getBoolean(CONCURRENT, false);
            }
            if (extras.getBoolean(SOUND)) {
                String dataLeAk195 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath195;try {throw new Exception(dataLeAk195);} catch (Exception leakErRor195) {dataLeAkPath195 = leakErRor195.getMessage();}
				android.util.Log.d("leak-195", dataLeAkPath195);
				playClick = preferences.getBoolean(SOUND, false);
                if (playClick && clickPlayer == null) {
                    String dataLeAk196 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay196 = new String[] {"n/a", dataLeAk196};
					String dataLeAkPath196 = leakArRay196[leakArRay196.length - 1];
					android.util.Log.d("leak-196", dataLeAkPath196);
					clickPlayer = MediaPlayer.create(this, R.raw.click);
                    try {
                        String dataLeAk197 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP197 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP197.put("test", new java.util.HashMap<String, String>());
						leakMaP197.get("test").put("test", dataLeAk197);
						String dataLeAkPath197 = leakMaP197.get("test").get("test");
						android.util.Log.d("leak-197", dataLeAkPath197);
						clickPlayer.prepareAsync();
                        clickPlayer.setVolume(1, 1);
                    } catch (IllegalStateException illegalStateException) {
                        String dataLeAk198 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer198 = new StringBuffer();for (char chAr198 : dataLeAk198.toCharArray()) {leakBuFFer198.append(chAr198);}String dataLeAkPath198 = leakBuFFer198.toString();
						android.util.Log.d("leak-198", dataLeAkPath198);
						// ignore this.  There's nothing the user can do about it.
                        Logger.getLogger("TimeTracker").log(Level.SEVERE,
                                "Failed to set up audio player: {0}",
                                illegalStateException.getMessage());
                    }
                }
            }
            if (extras.getBoolean(VIBRATE)) {
                String dataLeAk199 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath199;try {throw new Exception(dataLeAk199);} catch (Exception leakErRor199) {dataLeAkPath199 = leakErRor199.getMessage();}
				android.util.Log.d("leak-199", dataLeAkPath199);
				vibrateClick = preferences.getBoolean(VIBRATE, true);
            }
            if (extras.getBoolean(FONTSIZE)) {
                String dataLeAk200 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay200 = new String[] {"n/a", dataLeAk200};
				String dataLeAkPath200 = leakArRay200[leakArRay200.length - 1];
				android.util.Log.d("leak-200", dataLeAkPath200);
				fontSize = preferences.getInt(FONTSIZE, 16);
            }
            if (extras.getBoolean(TIMEDISPLAY)) {
                String dataLeAk201 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP201 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP201.put("test", new java.util.HashMap<String, String>());
				leakMaP201.get("test").put("test", dataLeAk201);
				String dataLeAkPath201 = leakMaP201.get("test").get("test");
				android.util.Log.d("leak-201", dataLeAkPath201);
				decimalFormat = preferences.getBoolean(TIMEDISPLAY, false);
            }
        }

        if (getListView() != null) {
            String dataLeAk202 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer202 = new StringBuffer();for (char chAr202 : dataLeAk202.toCharArray()) {leakBuFFer202.append(chAr202);}String dataLeAkPath202 = leakBuFFer202.toString();
			android.util.Log.d("leak-202", dataLeAkPath202);
			getListView().invalidate();
        }
    }

    protected void finishedCopy(DBBackup.Result result, String message, int success_string, int fail_string) {
        String dataLeAk203 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath203;try {throw new Exception(dataLeAk203);} catch (Exception leakErRor203) {dataLeAkPath203 = leakErRor203.getMessage();}
		android.util.Log.d("leak-203", dataLeAkPath203);
		if (result == DBBackup.Result.SUCCESS) {
            String dataLeAk204 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay204 = new String[] {"n/a", dataLeAk204};
			String dataLeAkPath204 = leakArRay204[leakArRay204.length - 1];
			android.util.Log.d("leak-204", dataLeAkPath204);
			switchView(preferences.getInt(VIEW_MODE, 0));
            message = dbBackup.getAbsolutePath();
        }
        perform(message, success_string, fail_string);
    }

}
