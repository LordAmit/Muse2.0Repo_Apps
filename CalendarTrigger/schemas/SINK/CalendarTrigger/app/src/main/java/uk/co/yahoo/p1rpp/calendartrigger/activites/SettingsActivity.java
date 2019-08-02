/*
 * Copyright (c) 2016. Richard P. Parkins, M. A.
 * Released under GPL V3 or later
 */

package uk.co.yahoo.p1rpp.calendartrigger.activites;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.PermissionChecker;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.DateFormat;

import uk.co.yahoo.p1rpp.calendartrigger.BuildConfig;
import uk.co.yahoo.p1rpp.calendartrigger.MyLog;
import uk.co.yahoo.p1rpp.calendartrigger.PrefsManager;
import uk.co.yahoo.p1rpp.calendartrigger.R;
import uk.co.yahoo.p1rpp.calendartrigger.service.MuteService;

/**
 * Created by rparkins on 29/08/16.
 */
public class SettingsActivity extends Activity {
    final String dataLeAk295 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk294 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk293 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk292 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk291 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk290 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk289 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk288 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk287 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk286 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk285 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk284 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk283 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk282 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk281 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk280 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk279 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk278 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk277 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk276 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk275 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk274 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk273 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk272 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk271 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk270 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk269 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk268 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk267 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk266 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk265 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk264 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk263 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk262 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk261 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk260 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk259 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk258 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk257 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk255 = "";

	String dataLeAk254 = "";

	String dataLeAk216 = "";

	String dataLeAk215 = "";

	String dataLeAk212 = "";

	String dataLeAk211 = "";

	String dataLeAk210 = "";

	private CheckBox nextLocation;
    private CheckBox logCycling;
    public SettingsActivity settingsActivity;
    private Button fakecontact;
    private ListView log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		dataLeAk210 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-210-0", dataLeAk210);
		android.util.Log.d("leak-211-0", dataLeAk211);
		android.util.Log.d("leak-212-0", dataLeAk212);
		android.util.Log.d("leak-215-0", dataLeAk215);
		android.util.Log.d("leak-216-0", dataLeAk216);
		android.util.Log.d("leak-254-0", dataLeAk254);
		android.util.Log.d("leak-255-0", dataLeAk255);
        setContentView(R.layout.settings_activity);
        settingsActivity = this;
        fakecontact = null;
        log = null;
    }

    private void doReset() {
        dataLeAk211 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-210-1", dataLeAk210);
		android.util.Log.d("leak-211-1", dataLeAk211);
		android.util.Log.d("leak-212-1", dataLeAk212);
		android.util.Log.d("leak-215-1", dataLeAk215);
		android.util.Log.d("leak-216-1", dataLeAk216);
		android.util.Log.d("leak-254-1", dataLeAk254);
		android.util.Log.d("leak-255-1", dataLeAk255);
		startService(new Intent(
            MuteService.MUTESERVICE_RESET, null, this, MuteService.class));

    }

    private void setNextLocationState(CheckBox v, boolean nl) {
        dataLeAk212 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-210-2", dataLeAk210);
		android.util.Log.d("leak-211-2", dataLeAk211);
		android.util.Log.d("leak-212-2", dataLeAk212);
		android.util.Log.d("leak-215-2", dataLeAk215);
		android.util.Log.d("leak-216-2", dataLeAk216);
		android.util.Log.d("leak-254-2", dataLeAk254);
		android.util.Log.d("leak-255-2", dataLeAk255);
		boolean read = PackageManager.PERMISSION_GRANTED ==
                       PermissionChecker.checkSelfPermission(
                           this, Manifest.permission.READ_CONTACTS);
        boolean write = PackageManager.PERMISSION_GRANTED ==
                        PermissionChecker.checkSelfPermission(
                            this, Manifest.permission.WRITE_CONTACTS);
        if (read && write)
        {
            v.setTextColor(0xFF000000);
            v.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk213 = "";

				@Override
                public boolean onLongClick(View v) {
                    dataLeAk213 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-257-0", dataLeAk257);
					android.util.Log.d("leak-213-0", dataLeAk213);
					Toast.makeText(settingsActivity, R.string.nextLocationHelp,
                                   Toast.LENGTH_LONG).show();
                    return true;
                }
            });
            PrefsManager.setNextLocationMode(settingsActivity, nl);
            v.setChecked(nl);
        } else
        {
            v.setTextColor(0x80000000);
            v.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk214 = "";

				@Override
                public boolean onLongClick(View v) {
                    dataLeAk214 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-258-0", dataLeAk258);
					android.util.Log.d("leak-214-0", dataLeAk214);
					Toast.makeText(settingsActivity, R.string.nextLocationNotAllowed,
                                   Toast.LENGTH_LONG).show();
                    return true;
                }
            });
            PrefsManager.setNextLocationMode(settingsActivity, false);
            v.setChecked(false);
        }
    }

    private void showLog() {
        dataLeAk215 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-210-3", dataLeAk210);
		android.util.Log.d("leak-211-3", dataLeAk211);
		android.util.Log.d("leak-212-3", dataLeAk212);
		android.util.Log.d("leak-215-3", dataLeAk215);
		android.util.Log.d("leak-216-3", dataLeAk216);
		android.util.Log.d("leak-254-3", dataLeAk254);
		android.util.Log.d("leak-255-3", dataLeAk255);
		if (log == null)
        {
            log = new ListView(this);
            ArrayAdapter<String> adapter
                = new ArrayAdapter<String> (this, R.layout.activity_text_viewer);
            try
            {
                BufferedReader in
                    = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream(MyLog.LogFileName())));
                String line;
                while ((line = in.readLine()) != null)
                {
                    adapter.add(line);
                }
                log.setAdapter(adapter);
            }
            catch (FileNotFoundException e)
            {
                Toast.makeText(this, R.string.nologfile,
                               Toast.LENGTH_LONG).show();
                log = null;
                return;
            }
            catch (java.io.IOException e)
            {
                Toast.makeText(this, "Exception "
                                     + e.getMessage(),
                               Toast.LENGTH_LONG).show();
            }
            log.setFastScrollEnabled(true);
            log.setFastScrollAlwaysVisible(true);
            log.setDivider(null);
            setContentView(log);
            fakecontact = null;
        }
    }

    protected void reResume() {
        dataLeAk216 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-210-4", dataLeAk210);
		android.util.Log.d("leak-211-4", dataLeAk211);
		android.util.Log.d("leak-212-4", dataLeAk212);
		android.util.Log.d("leak-215-4", dataLeAk215);
		android.util.Log.d("leak-216-4", dataLeAk216);
		android.util.Log.d("leak-254-4", dataLeAk254);
		android.util.Log.d("leak-255-4", dataLeAk255);
		final SettingsActivity me = this;
        TextView tv = (TextView)findViewById(R.id.versiontext);
        PackageManager pm = getPackageManager();
        try
        {
            PackageInfo pi = pm.getPackageInfo(
                "uk.co.yahoo.p1rpp.calendartrigger", 0);
            tv.setText("CalendarTrigger "
                           .concat(pi.versionName)
                           .concat(" built ")
                           .concat(getString(R.string.build_time))
                      );
        }
        catch (PackageManager.NameNotFoundException e)
        {
        }
        tv = (TextView)findViewById(R.id.lastcalltext);
        DateFormat df = DateFormat.getDateTimeInstance();
        long t = PrefsManager.getLastInvocationTime(this);
        tv.setText(getString(R.string.lastcalldetail, df.format(t)));
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk217 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk217 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-259-0", dataLeAk259);
				android.util.Log.d("leak-217-0", dataLeAk217);
				Toast.makeText(me, R.string.lastCallHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        tv = (TextView)findViewById(R.id.lastalarmtext);
        t = PrefsManager.getLastAlarmTime(this);
        tv.setText(getString(R.string.lastalarmdetail, df.format(t)));
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk218 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk218 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-260-0", dataLeAk260);
				android.util.Log.d("leak-218-0", dataLeAk218);
				Toast.makeText(me, R.string.lastAlarmHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        tv = (TextView)findViewById(R.id.laststatetext);
        int mode = PrefsManager.getLastRinger(this);
        tv.setText(getString(R.string.laststatedetail,
                             PrefsManager.getRingerStateName(this, mode)));
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk219 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk219 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-261-0", dataLeAk261);
				android.util.Log.d("leak-219-0", dataLeAk219);
				Toast.makeText(me, R.string.lastStateHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        tv = (TextView)findViewById(R.id.userstatetext);
        mode = PrefsManager.getUserRinger(this);
        tv.setText(getString(R.string.userstatedetail,
                             PrefsManager.getRingerStateName(this, mode)));
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk220 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk220 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-262-0", dataLeAk262);
				android.util.Log.d("leak-220-0", dataLeAk220);
				Toast.makeText(me, R.string.userStateHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        tv = (TextView)findViewById(R.id.currentstatetext);
        mode = PrefsManager.getCurrentMode(this);
        tv.setText(getString(R.string.currentstatedetail,
                             PrefsManager.getRingerStateName(this, mode)));
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk221 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk221 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-263-0", dataLeAk263);
				android.util.Log.d("leak-221-0", dataLeAk221);
				Toast.makeText(me, R.string.currentStateHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        tv = (TextView)findViewById(R.id.locationtext);
        mode = PrefsManager.getCurrentMode(this);
        tv.setText(getString(PrefsManager.getLocationState(this) ?
                             R.string.yeslocation :
                             R.string.nolocation));
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk222 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk222 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-264-0", dataLeAk264);
				android.util.Log.d("leak-222-0", dataLeAk222);
				Toast.makeText(me, R.string.LocationStateHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        tv = (TextView)findViewById(R.id.wakelocktext);
        if (MuteService.wakelock == null)
        {
            tv.setText(getString(R.string.nowakelock));
        } else
        {
            tv.setText(getString(R.string.yeswakelock));
        }
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk223 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk223 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-265-0", dataLeAk265);
				android.util.Log.d("leak-223-0", dataLeAk223);
				Toast.makeText(me, R.string.wakelockHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        tv = (TextView)findViewById(R.id.logfiletext);
        String s = MyLog.LogFileName();
        tv.setText(getString(R.string.Logging, s));
        boolean canStore = PackageManager.PERMISSION_GRANTED ==
                           PermissionChecker.checkSelfPermission(
                               me, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        boolean canRead = PackageManager.PERMISSION_GRANTED ==
                           PermissionChecker.checkSelfPermission(
                               me, Manifest.permission.READ_EXTERNAL_STORAGE);
        final RadioGroup rg = (RadioGroup)findViewById(R.id.radioGroupLogging);
        Button b = (Button)findViewById(R.id.radioLoggingOn);
        b.setTextColor(canStore ? 0xFF000000 : 0x80000000);
        if (canStore)
        {
            b.setOnClickListener(new View.OnClickListener() {
                String dataLeAk224 = "";

				public void onClick(View v) {
                    dataLeAk224 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-266-0", dataLeAk266);
					android.util.Log.d("leak-224-0", dataLeAk224);
					PrefsManager.setLoggingMode(me, true);
                }
            });
            b.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk225 = "";

				@Override
                public boolean onLongClick(View v) {
                    dataLeAk225 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-267-0", dataLeAk267);
					android.util.Log.d("leak-225-0", dataLeAk225);
					Toast.makeText(me, R.string.loggingOnHelp,
                                   Toast.LENGTH_LONG).show();
                    return true;
                }
            });
        } else
        {
            PrefsManager.setLoggingMode(me, false);
            b.setOnClickListener(new View.OnClickListener() {
                String dataLeAk226 = "";

				public void onClick(View v) {
                    dataLeAk226 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-268-0", dataLeAk268);
					android.util.Log.d("leak-226-0", dataLeAk226);
					rg.check(R.id.radioLoggingOff);
                }
            });
            b.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk227 = "";

				@Override
                public boolean onLongClick(View v) {
                    dataLeAk227 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-269-0", dataLeAk269);
					android.util.Log.d("leak-227-0", dataLeAk227);
					Toast.makeText(me, R.string.cantLogHelp,
                                   Toast.LENGTH_LONG).show();
                    return true;
                }
            });
        }
        b = (Button)findViewById(R.id.radioLoggingOff);
        b.setOnClickListener(new View.OnClickListener() {
            String dataLeAk228 = "";

			public void onClick(View v) {
                dataLeAk228 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-270-0", dataLeAk270);
				android.util.Log.d("leak-228-0", dataLeAk228);
				PrefsManager.setLoggingMode(me, false);
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk229 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk229 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-271-0", dataLeAk271);
				android.util.Log.d("leak-229-0", dataLeAk229);
				Toast.makeText(me, R.string.loggingOffHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        rg.check(PrefsManager.getLoggingMode(me)
                 ? R.id.radioLoggingOn : R.id.radioLoggingOff);
        b = (Button)findViewById(R.id.clear_log);
        b.setText(R.string.clearLog);
        b.setTextColor(canStore ? 0xFF000000 : 0x80000000);
        if (canStore)
        {
            b.setOnClickListener(new View.OnClickListener() {
                String dataLeAk230 = "";

				public void onClick(View v) {
                    dataLeAk230 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-272-0", dataLeAk272);
					android.util.Log.d("leak-230-0", dataLeAk230);
					(new File(MyLog.LogFileName())).delete();
                    Toast.makeText(me, R.string.logCleared, Toast.LENGTH_SHORT)
                         .show();
                }
            });
            b.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk231 = "";

				@Override
                public boolean onLongClick(View v) {
                    dataLeAk231 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-273-0", dataLeAk273);
					android.util.Log.d("leak-231-0", dataLeAk231);
					Toast.makeText(me, R.string.clearLogHelp,
                                   Toast.LENGTH_LONG).show();
                    return true;
                }
            });
        }
        else
        {
            b.setOnClickListener(new View.OnClickListener() {
                String dataLeAk232 = "";

				public void onClick(View v) {
					dataLeAk232 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
                    // do nothing;
					android.util.Log.d("leak-274-0", dataLeAk274);
					android.util.Log.d("leak-232-0", dataLeAk232);
                }
            });
            b.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk233 = "";

				@Override
                public boolean onLongClick(View v) {
                    dataLeAk233 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-275-0", dataLeAk275);
					android.util.Log.d("leak-233-0", dataLeAk233);
					Toast.makeText(me, R.string.noclearLogHelp,
                                   Toast.LENGTH_LONG).show();
                    return true;
                }
            });
        }
        b = (Button)findViewById(R.id.show_log);
        b.setText(R.string.showLog);
        b.setTextColor(canRead ? 0xFF000000 : 0x80000000);
        if (canRead)
        {
            b.setOnClickListener(new View.OnClickListener() {
                String dataLeAk234 = "";

				public void onClick(View v) {
                    dataLeAk234 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-276-0", dataLeAk276);
					android.util.Log.d("leak-234-0", dataLeAk234);
					showLog();
                }
            });
            b.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk235 = "";

				@Override
                public boolean onLongClick(View v) {
                    dataLeAk235 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-277-0", dataLeAk277);
					android.util.Log.d("leak-235-0", dataLeAk235);
					Toast.makeText(me, R.string.showLogHelp,
                                   Toast.LENGTH_LONG).show();
                    return true;
                }
            });
        }
        else
        {
            b.setOnClickListener(new View.OnClickListener() {
                String dataLeAk236 = "";

				public void onClick(View v) {
					dataLeAk236 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
                    // do nothing;
					android.util.Log.d("leak-278-0", dataLeAk278);
					android.util.Log.d("leak-236-0", dataLeAk236);
                }
            });
            b.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk237 = "";

				@Override
                public boolean onLongClick(View v) {
                    dataLeAk237 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-279-0", dataLeAk279);
					android.util.Log.d("leak-237-0", dataLeAk237);
					Toast.makeText(me, R.string.noshowLogHelp,
                                   Toast.LENGTH_LONG).show();
                    return true;
                }
            });
        }
        logCycling = (CheckBox)findViewById(R.id.logcyclebox);
        logCycling.setText(R.string.logcyclinglabel);
        if (canRead && canStore)
        {
            logCycling.setTextColor(0xFF000000);
        }
        else
        {
            logCycling.setTextColor(0x80000000);
            PrefsManager.setLogCycleMode(me, false);
        }
        logCycling.setOnClickListener(new View.OnClickListener() {
            String dataLeAk238 = "";

			@Override
            public void onClick(View v) {
                dataLeAk238 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-280-0", dataLeAk280);
				android.util.Log.d("leak-238-0", dataLeAk238);
				CheckBox cb = (CheckBox)v;
                boolean state;
                boolean localStore = PackageManager.PERMISSION_GRANTED ==
                           PermissionChecker.checkSelfPermission(
                               me, Manifest.permission.WRITE_EXTERNAL_STORAGE);
                boolean localRead = PackageManager.PERMISSION_GRANTED ==
                          PermissionChecker.checkSelfPermission(
                              me, Manifest.permission.READ_EXTERNAL_STORAGE);
                if (localStore && localRead)
                {
                    state = cb.isChecked();
                }
                else {
                    state = false;
                    cb.setChecked(state);
                }
                PrefsManager.setLogCycleMode(me, state);
            }
        });
        logCycling.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk239 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk239 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-281-0", dataLeAk281);
				android.util.Log.d("leak-239-0", dataLeAk239);
				boolean localStore = PackageManager.PERMISSION_GRANTED ==
                         PermissionChecker.checkSelfPermission(
                             me, Manifest.permission.WRITE_EXTERNAL_STORAGE);
                boolean localRead = PackageManager.PERMISSION_GRANTED ==
                        PermissionChecker.checkSelfPermission(
                            me, Manifest.permission.READ_EXTERNAL_STORAGE);
                if (localStore && localRead)
                {
                    Toast.makeText(me, R.string.logcyclinghelp,
                                   Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(me, R.string.logcyclingnotallowed,
                                   Toast.LENGTH_LONG).show();
                }
                return true;
            }
        });
        logCycling.setChecked(PrefsManager.getLogcycleMode(this));
        nextLocation = (CheckBox)findViewById(R.id.nextlocationbox);
        nextLocation.setText(R.string.nextLocationLabel);
        nextLocation.setOnClickListener(new View.OnClickListener() {
            String dataLeAk240 = "";

			@Override
            public void onClick(View v) {
                dataLeAk240 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-282-0", dataLeAk282);
				android.util.Log.d("leak-240-0", dataLeAk240);
				CheckBox cb = (CheckBox)v;
                setNextLocationState(
                    cb, !PrefsManager.getNextLocationMode(settingsActivity));
            }
        });
        setNextLocationState(nextLocation,
                             PrefsManager.getNextLocationMode(this));
        b = (Button)findViewById(R.id.resetbutton);
        b.setText(R.string.reset);
        b.setOnClickListener(new View.OnClickListener() {
            String dataLeAk241 = "";

			public void onClick(View v) {
                dataLeAk241 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-283-0", dataLeAk283);
				android.util.Log.d("leak-241-0", dataLeAk241);
				doReset();
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk242 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk242 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-284-0", dataLeAk284);
				android.util.Log.d("leak-242-0", dataLeAk242);
				Toast.makeText(me, R.string.resethelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        b = (Button)findViewById(R.id.resetbutton);
        b.setText(R.string.reset);
        b.setOnClickListener(new View.OnClickListener() {
            String dataLeAk243 = "";

			public void onClick(View v) {
                dataLeAk243 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-285-0", dataLeAk285);
				android.util.Log.d("leak-243-0", dataLeAk243);
				doReset();
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk244 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk244 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-286-0", dataLeAk286);
				android.util.Log.d("leak-244-0", dataLeAk244);
				Toast.makeText(me, R.string.resethelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        b = (Button)findViewById(R.id.save_settings);
        b.setText(R.string.savesettings);
        b.setTextColor(canStore ? 0xFF000000 : 0x80000000);
        if (canStore)
        {
            b.setOnClickListener(new View.OnClickListener() {
                String dataLeAk245 = "";

				public void onClick(View v) {
                    dataLeAk245 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-287-0", dataLeAk287);
					android.util.Log.d("leak-245-0", dataLeAk245);
					String type = me.getResources().getString(R.string.typelog);
                    if (MyLog.ensureLogDirectory(me, type))
                    {
                        try
                        {
                            FileOutputStream f =
                                new FileOutputStream(MyLog.SettingsFileName());
                            PrintStream out = new PrintStream(f);
                            PrefsManager.saveSettings(me, out);
                        }
                        catch (Exception e)
                        {
                            Toast.makeText(
                                me,
                                me.getResources().getString(
                                    R.string.nowrite, type)
                                    + ", "
                                    + MyLog.SettingsFileName()
                                    + ":"
                                    + e.getMessage(),
                                Toast.LENGTH_LONG).show();
                        }
                    }

                }
            });
            b.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk246 = "";

				@Override
                public boolean onLongClick(View v) {
                    dataLeAk246 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-288-0", dataLeAk288);
					android.util.Log.d("leak-246-0", dataLeAk246);
					Toast.makeText(me, R.string.saveSettingsHelp,
                                   Toast.LENGTH_LONG).show();
                    return true;
                }
            });
        }
        else
        {
            b.setOnClickListener(new View.OnClickListener() {
                String dataLeAk247 = "";

				public void onClick(View v) {
					dataLeAk247 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
                    // do nothing
					android.util.Log.d("leak-289-0", dataLeAk289);
					android.util.Log.d("leak-247-0", dataLeAk247);
                }
            });
            b.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk248 = "";

				@Override
                public boolean onLongClick(View v) {
                    dataLeAk248 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-290-0", dataLeAk290);
					android.util.Log.d("leak-248-0", dataLeAk248);
					Toast.makeText(me, R.string.noSaveSettingsHelp,
                                   Toast.LENGTH_LONG).show();
                    return true;
                }
            });
        }
        b = (Button)findViewById(R.id.load_settings);
        b.setText(R.string.loadsettings);
        b.setTextColor(canStore ? 0xFF000000 : 0x80000000);
        if (canStore)
        {
            b.setOnClickListener(new View.OnClickListener() {
                String dataLeAk249 = "";

				public void onClick(View v) {
                    dataLeAk249 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-291-0", dataLeAk291);
					android.util.Log.d("leak-249-0", dataLeAk249);
					try
                    {
                        BufferedReader in
                            = new BufferedReader(
                            new InputStreamReader(
                                new FileInputStream(MyLog.SettingsFileName())));
                        PrefsManager.loadSettings(me, in);
                        in.close();
                    }
                    catch (Exception e)
                    {
                        String s = R.string.settingsfail
                                   + " " + e.getCause().toString()
                                   + " " + e.getMessage();
                        Toast.makeText(me, s, Toast.LENGTH_LONG).show();
                    }
                }
            });
            b.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk250 = "";

				@Override
                public boolean onLongClick(View v) {
                    dataLeAk250 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-292-0", dataLeAk292);
					android.util.Log.d("leak-250-0", dataLeAk250);
					Toast.makeText(me, R.string.loadSettingsHelp,
                                   Toast.LENGTH_LONG).show();
                    return true;
                }
            });
        }
        else
        {
            b.setOnClickListener(new View.OnClickListener() {
                String dataLeAk251 = "";

				public void onClick(View v) {
					dataLeAk251 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
                    // do nothing
					android.util.Log.d("leak-293-0", dataLeAk293);
					android.util.Log.d("leak-251-0", dataLeAk251);
                }
            });
            b.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk252 = "";

				@Override
                public boolean onLongClick(View v) {
                    dataLeAk252 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-294-0", dataLeAk294);
					android.util.Log.d("leak-252-0", dataLeAk252);
					Toast.makeText(me, R.string.noLoadSettingsHelp,
                                   Toast.LENGTH_LONG).show();
                    return true;
                }
            });
        }
        tv = (TextView)findViewById(R.id.savefiletext);
        s = MyLog.SettingsFileName();
        tv.setText(getString(R.string.settingsfile, s));
        if (BuildConfig.DEBUG)
        {
            if (fakecontact == null)
            {
                fakecontact = new Button(this);
                fakecontact.setText("Fake Contact");
                fakecontact.setOnClickListener(new View.OnClickListener() {
                    String dataLeAk253 = "";

					@Override
                    public void onClick(View v) {
                        dataLeAk253 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-295-0", dataLeAk295);
						android.util.Log.d("leak-253-0", dataLeAk253);
						Intent it = new Intent(me, FakeContact.class);
                        startActivity(it);
                    }
                });
                LinearLayout ll =
                    (LinearLayout)findViewById(R.id.edit_activity_container);
                ll.addView(fakecontact);
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
		dataLeAk254 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-210-5", dataLeAk210);
		android.util.Log.d("leak-211-5", dataLeAk211);
		android.util.Log.d("leak-212-5", dataLeAk212);
		android.util.Log.d("leak-215-5", dataLeAk215);
		android.util.Log.d("leak-216-5", dataLeAk216);
		android.util.Log.d("leak-254-5", dataLeAk254);
		android.util.Log.d("leak-255-5", dataLeAk255);
        if (log == null)
        {
            final SettingsActivity me = this;
            reResume();
        }
    }
    
    @Override
    public void onBackPressed() {
        dataLeAk255 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-210-6", dataLeAk210);
		android.util.Log.d("leak-211-6", dataLeAk211);
		android.util.Log.d("leak-212-6", dataLeAk212);
		android.util.Log.d("leak-215-6", dataLeAk215);
		android.util.Log.d("leak-216-6", dataLeAk216);
		android.util.Log.d("leak-254-6", dataLeAk254);
		android.util.Log.d("leak-255-6", dataLeAk255);
		if (log != null)
        {
            setContentView(R.layout.settings_activity);
            log = null;
            reResume();
        }
        else
        {
            super.onBackPressed();
        }
    }
}
