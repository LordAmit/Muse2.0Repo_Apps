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
    String dataLeAk412 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk412 = android.util.Log.d("leak-412", dataLeAk412);

	private CheckBox nextLocation;
    private CheckBox logCycling;
    public SettingsActivity settingsActivity;
    private Button fakecontact;
    private ListView log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk413 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk413 = android.util.Log.d("leak-413", dataLeAk413);
        setContentView(R.layout.settings_activity);
        settingsActivity = this;
        fakecontact = null;
        log = null;
    }

    private void doReset() {
        String dataLeAk414 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk414 = android.util.Log.d("leak-414", dataLeAk414);
		startService(new Intent(
            MuteService.MUTESERVICE_RESET, null, this, MuteService.class));

    }

    private void setNextLocationState(CheckBox v, boolean nl) {
        String dataLeAk415 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk415 = android.util.Log.d("leak-415", dataLeAk415);
		boolean read = PackageManager.PERMISSION_GRANTED ==
                       PermissionChecker.checkSelfPermission(
                           this, Manifest.permission.READ_CONTACTS);
        boolean write = PackageManager.PERMISSION_GRANTED ==
                        PermissionChecker.checkSelfPermission(
                            this, Manifest.permission.WRITE_CONTACTS);
        if (read && write)
        {
            String dataLeAk416 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk416 = android.util.Log.d("leak-416", dataLeAk416);
			v.setTextColor(0xFF000000);
            v.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk417 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk417 = android.util.Log.d("leak-417", dataLeAk417);

				@Override
                public boolean onLongClick(View v) {
                    String dataLeAk418 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk418 = android.util.Log.d("leak-418", dataLeAk418);
					Toast.makeText(settingsActivity, R.string.nextLocationHelp,
                                   Toast.LENGTH_LONG).show();
                    return true;
                }
            });
            PrefsManager.setNextLocationMode(settingsActivity, nl);
            v.setChecked(nl);
        } else
        {
            String dataLeAk419 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk419 = android.util.Log.d("leak-419", dataLeAk419);
			v.setTextColor(0x80000000);
            v.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk420 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk420 = android.util.Log.d("leak-420", dataLeAk420);

				@Override
                public boolean onLongClick(View v) {
                    String dataLeAk421 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk421 = android.util.Log.d("leak-421", dataLeAk421);
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
        String dataLeAk422 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk422 = android.util.Log.d("leak-422", dataLeAk422);
		if (log == null)
        {
            String dataLeAk423 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk423 = android.util.Log.d("leak-423", dataLeAk423);
			log = new ListView(this);
            ArrayAdapter<String> adapter
                = new ArrayAdapter<String> (this, R.layout.activity_text_viewer);
            try
            {
                String dataLeAk424 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk424 = android.util.Log.d("leak-424", dataLeAk424);
				BufferedReader in
                    = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream(MyLog.LogFileName())));
                String line;
                while ((line = in.readLine()) != null)
                {
                    String dataLeAk425 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk425 = android.util.Log.d("leak-425", dataLeAk425);
					adapter.add(line);
                }
                log.setAdapter(adapter);
            }
            catch (FileNotFoundException e)
            {
                String dataLeAk426 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk426 = android.util.Log.d("leak-426", dataLeAk426);
				Toast.makeText(this, R.string.nologfile,
                               Toast.LENGTH_LONG).show();
                log = null;
                return;
            }
            catch (java.io.IOException e)
            {
                String dataLeAk427 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk427 = android.util.Log.d("leak-427", dataLeAk427);
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
        String dataLeAk428 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk428 = android.util.Log.d("leak-428", dataLeAk428);
		final SettingsActivity me = this;
        TextView tv = (TextView)findViewById(R.id.versiontext);
        PackageManager pm = getPackageManager();
        try
        {
            String dataLeAk429 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk429 = android.util.Log.d("leak-429", dataLeAk429);
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
			String dataLeAk430 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk430 = android.util.Log.d("leak-430", dataLeAk430);
        }
        tv = (TextView)findViewById(R.id.lastcalltext);
        DateFormat df = DateFormat.getDateTimeInstance();
        long t = PrefsManager.getLastInvocationTime(this);
        tv.setText(getString(R.string.lastcalldetail, df.format(t)));
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk431 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk431 = android.util.Log.d("leak-431", dataLeAk431);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk432 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk432 = android.util.Log.d("leak-432", dataLeAk432);
				Toast.makeText(me, R.string.lastCallHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        tv = (TextView)findViewById(R.id.lastalarmtext);
        t = PrefsManager.getLastAlarmTime(this);
        tv.setText(getString(R.string.lastalarmdetail, df.format(t)));
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk433 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk433 = android.util.Log.d("leak-433", dataLeAk433);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk434 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk434 = android.util.Log.d("leak-434", dataLeAk434);
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
            String dataLeAk435 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk435 = android.util.Log.d("leak-435", dataLeAk435);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk436 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk436 = android.util.Log.d("leak-436", dataLeAk436);
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
            String dataLeAk437 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk437 = android.util.Log.d("leak-437", dataLeAk437);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk438 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk438 = android.util.Log.d("leak-438", dataLeAk438);
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
            String dataLeAk439 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk439 = android.util.Log.d("leak-439", dataLeAk439);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk440 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk440 = android.util.Log.d("leak-440", dataLeAk440);
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
            String dataLeAk441 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk441 = android.util.Log.d("leak-441", dataLeAk441);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk442 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk442 = android.util.Log.d("leak-442", dataLeAk442);
				Toast.makeText(me, R.string.LocationStateHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        tv = (TextView)findViewById(R.id.wakelocktext);
        if (MuteService.wakelock == null)
        {
            String dataLeAk443 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk443 = android.util.Log.d("leak-443", dataLeAk443);
			tv.setText(getString(R.string.nowakelock));
        } else
        {
            String dataLeAk444 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk444 = android.util.Log.d("leak-444", dataLeAk444);
			tv.setText(getString(R.string.yeswakelock));
        }
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk445 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk445 = android.util.Log.d("leak-445", dataLeAk445);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk446 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk446 = android.util.Log.d("leak-446", dataLeAk446);
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
            String dataLeAk447 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk447 = android.util.Log.d("leak-447", dataLeAk447);
			b.setOnClickListener(new View.OnClickListener() {
                String dataLeAk448 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk448 = android.util.Log.d("leak-448", dataLeAk448);

				public void onClick(View v) {
                    String dataLeAk449 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk449 = android.util.Log.d("leak-449", dataLeAk449);
					PrefsManager.setLoggingMode(me, true);
                }
            });
            b.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk450 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk450 = android.util.Log.d("leak-450", dataLeAk450);

				@Override
                public boolean onLongClick(View v) {
                    String dataLeAk451 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk451 = android.util.Log.d("leak-451", dataLeAk451);
					Toast.makeText(me, R.string.loggingOnHelp,
                                   Toast.LENGTH_LONG).show();
                    return true;
                }
            });
        } else
        {
            String dataLeAk452 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk452 = android.util.Log.d("leak-452", dataLeAk452);
			PrefsManager.setLoggingMode(me, false);
            b.setOnClickListener(new View.OnClickListener() {
                String dataLeAk453 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk453 = android.util.Log.d("leak-453", dataLeAk453);

				public void onClick(View v) {
                    String dataLeAk454 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk454 = android.util.Log.d("leak-454", dataLeAk454);
					rg.check(R.id.radioLoggingOff);
                }
            });
            b.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk455 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk455 = android.util.Log.d("leak-455", dataLeAk455);

				@Override
                public boolean onLongClick(View v) {
                    String dataLeAk456 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk456 = android.util.Log.d("leak-456", dataLeAk456);
					Toast.makeText(me, R.string.cantLogHelp,
                                   Toast.LENGTH_LONG).show();
                    return true;
                }
            });
        }
        b = (Button)findViewById(R.id.radioLoggingOff);
        b.setOnClickListener(new View.OnClickListener() {
            String dataLeAk457 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk457 = android.util.Log.d("leak-457", dataLeAk457);

			public void onClick(View v) {
                String dataLeAk458 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk458 = android.util.Log.d("leak-458", dataLeAk458);
				PrefsManager.setLoggingMode(me, false);
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk459 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk459 = android.util.Log.d("leak-459", dataLeAk459);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk460 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk460 = android.util.Log.d("leak-460", dataLeAk460);
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
            String dataLeAk461 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk461 = android.util.Log.d("leak-461", dataLeAk461);
			b.setOnClickListener(new View.OnClickListener() {
                String dataLeAk462 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk462 = android.util.Log.d("leak-462", dataLeAk462);

				public void onClick(View v) {
                    String dataLeAk463 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk463 = android.util.Log.d("leak-463", dataLeAk463);
					(new File(MyLog.LogFileName())).delete();
                    Toast.makeText(me, R.string.logCleared, Toast.LENGTH_SHORT)
                         .show();
                }
            });
            b.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk464 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk464 = android.util.Log.d("leak-464", dataLeAk464);

				@Override
                public boolean onLongClick(View v) {
                    String dataLeAk465 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk465 = android.util.Log.d("leak-465", dataLeAk465);
					Toast.makeText(me, R.string.clearLogHelp,
                                   Toast.LENGTH_LONG).show();
                    return true;
                }
            });
        }
        else
        {
            String dataLeAk466 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk466 = android.util.Log.d("leak-466", dataLeAk466);
			b.setOnClickListener(new View.OnClickListener() {
                String dataLeAk467 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk467 = android.util.Log.d("leak-467", dataLeAk467);

				public void onClick(View v) {
					String dataLeAk468 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk468 = android.util.Log.d("leak-468", dataLeAk468);
                    // do nothing;
                }
            });
            b.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk469 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk469 = android.util.Log.d("leak-469", dataLeAk469);

				@Override
                public boolean onLongClick(View v) {
                    String dataLeAk470 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk470 = android.util.Log.d("leak-470", dataLeAk470);
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
            String dataLeAk471 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk471 = android.util.Log.d("leak-471", dataLeAk471);
			b.setOnClickListener(new View.OnClickListener() {
                String dataLeAk472 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk472 = android.util.Log.d("leak-472", dataLeAk472);

				public void onClick(View v) {
                    String dataLeAk473 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk473 = android.util.Log.d("leak-473", dataLeAk473);
					showLog();
                }
            });
            b.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk474 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk474 = android.util.Log.d("leak-474", dataLeAk474);

				@Override
                public boolean onLongClick(View v) {
                    String dataLeAk475 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk475 = android.util.Log.d("leak-475", dataLeAk475);
					Toast.makeText(me, R.string.showLogHelp,
                                   Toast.LENGTH_LONG).show();
                    return true;
                }
            });
        }
        else
        {
            String dataLeAk476 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk476 = android.util.Log.d("leak-476", dataLeAk476);
			b.setOnClickListener(new View.OnClickListener() {
                String dataLeAk477 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk477 = android.util.Log.d("leak-477", dataLeAk477);

				public void onClick(View v) {
					String dataLeAk478 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk478 = android.util.Log.d("leak-478", dataLeAk478);
                    // do nothing;
                }
            });
            b.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk479 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk479 = android.util.Log.d("leak-479", dataLeAk479);

				@Override
                public boolean onLongClick(View v) {
                    String dataLeAk480 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk480 = android.util.Log.d("leak-480", dataLeAk480);
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
            String dataLeAk481 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk481 = android.util.Log.d("leak-481", dataLeAk481);
			logCycling.setTextColor(0xFF000000);
        }
        else
        {
            String dataLeAk482 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk482 = android.util.Log.d("leak-482", dataLeAk482);
			logCycling.setTextColor(0x80000000);
            PrefsManager.setLogCycleMode(me, false);
        }
        logCycling.setOnClickListener(new View.OnClickListener() {
            String dataLeAk483 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk483 = android.util.Log.d("leak-483", dataLeAk483);

			@Override
            public void onClick(View v) {
                String dataLeAk484 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk484 = android.util.Log.d("leak-484", dataLeAk484);
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
                    String dataLeAk485 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk485 = android.util.Log.d("leak-485", dataLeAk485);
					state = cb.isChecked();
                }
                else {
                    String dataLeAk486 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk486 = android.util.Log.d("leak-486", dataLeAk486);
					state = false;
                    cb.setChecked(state);
                }
                PrefsManager.setLogCycleMode(me, state);
            }
        });
        logCycling.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk487 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk487 = android.util.Log.d("leak-487", dataLeAk487);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk488 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk488 = android.util.Log.d("leak-488", dataLeAk488);
				boolean localStore = PackageManager.PERMISSION_GRANTED ==
                         PermissionChecker.checkSelfPermission(
                             me, Manifest.permission.WRITE_EXTERNAL_STORAGE);
                boolean localRead = PackageManager.PERMISSION_GRANTED ==
                        PermissionChecker.checkSelfPermission(
                            me, Manifest.permission.READ_EXTERNAL_STORAGE);
                if (localStore && localRead)
                {
                    String dataLeAk489 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk489 = android.util.Log.d("leak-489", dataLeAk489);
					Toast.makeText(me, R.string.logcyclinghelp,
                                   Toast.LENGTH_LONG).show();
                }
                else
                {
                    String dataLeAk490 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk490 = android.util.Log.d("leak-490", dataLeAk490);
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
            String dataLeAk491 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk491 = android.util.Log.d("leak-491", dataLeAk491);

			@Override
            public void onClick(View v) {
                String dataLeAk492 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk492 = android.util.Log.d("leak-492", dataLeAk492);
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
            String dataLeAk493 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk493 = android.util.Log.d("leak-493", dataLeAk493);

			public void onClick(View v) {
                String dataLeAk494 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk494 = android.util.Log.d("leak-494", dataLeAk494);
				doReset();
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk495 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk495 = android.util.Log.d("leak-495", dataLeAk495);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk496 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk496 = android.util.Log.d("leak-496", dataLeAk496);
				Toast.makeText(me, R.string.resethelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        b = (Button)findViewById(R.id.resetbutton);
        b.setText(R.string.reset);
        b.setOnClickListener(new View.OnClickListener() {
            String dataLeAk497 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk497 = android.util.Log.d("leak-497", dataLeAk497);

			public void onClick(View v) {
                String dataLeAk498 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk498 = android.util.Log.d("leak-498", dataLeAk498);
				doReset();
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk499 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk499 = android.util.Log.d("leak-499", dataLeAk499);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk500 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk500 = android.util.Log.d("leak-500", dataLeAk500);
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
            String dataLeAk501 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk501 = android.util.Log.d("leak-501", dataLeAk501);
			b.setOnClickListener(new View.OnClickListener() {
                String dataLeAk502 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk502 = android.util.Log.d("leak-502", dataLeAk502);

				public void onClick(View v) {
                    String dataLeAk503 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk503 = android.util.Log.d("leak-503", dataLeAk503);
					String type = me.getResources().getString(R.string.typelog);
                    if (MyLog.ensureLogDirectory(me, type))
                    {
                        String dataLeAk504 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk504 = android.util.Log.d("leak-504", dataLeAk504);
						try
                        {
                            String dataLeAk505 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk505 = android.util.Log.d("leak-505", dataLeAk505);
							FileOutputStream f =
                                new FileOutputStream(MyLog.SettingsFileName());
                            PrintStream out = new PrintStream(f);
                            PrefsManager.saveSettings(me, out);
                        }
                        catch (Exception e)
                        {
                            String dataLeAk506 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk506 = android.util.Log.d("leak-506", dataLeAk506);
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
                String dataLeAk507 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk507 = android.util.Log.d("leak-507", dataLeAk507);

				@Override
                public boolean onLongClick(View v) {
                    String dataLeAk508 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk508 = android.util.Log.d("leak-508", dataLeAk508);
					Toast.makeText(me, R.string.saveSettingsHelp,
                                   Toast.LENGTH_LONG).show();
                    return true;
                }
            });
        }
        else
        {
            String dataLeAk509 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk509 = android.util.Log.d("leak-509", dataLeAk509);
			b.setOnClickListener(new View.OnClickListener() {
                String dataLeAk510 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk510 = android.util.Log.d("leak-510", dataLeAk510);

				public void onClick(View v) {
					String dataLeAk511 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk511 = android.util.Log.d("leak-511", dataLeAk511);
                    // do nothing
                }
            });
            b.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk512 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk512 = android.util.Log.d("leak-512", dataLeAk512);

				@Override
                public boolean onLongClick(View v) {
                    String dataLeAk513 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk513 = android.util.Log.d("leak-513", dataLeAk513);
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
            String dataLeAk514 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk514 = android.util.Log.d("leak-514", dataLeAk514);
			b.setOnClickListener(new View.OnClickListener() {
                String dataLeAk515 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk515 = android.util.Log.d("leak-515", dataLeAk515);

				public void onClick(View v) {
                    String dataLeAk516 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk516 = android.util.Log.d("leak-516", dataLeAk516);
					try
                    {
                        String dataLeAk517 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk517 = android.util.Log.d("leak-517", dataLeAk517);
						BufferedReader in
                            = new BufferedReader(
                            new InputStreamReader(
                                new FileInputStream(MyLog.SettingsFileName())));
                        PrefsManager.loadSettings(me, in);
                        in.close();
                    }
                    catch (Exception e)
                    {
                        String dataLeAk518 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk518 = android.util.Log.d("leak-518", dataLeAk518);
						String s = R.string.settingsfail
                                   + " " + e.getCause().toString()
                                   + " " + e.getMessage();
                        Toast.makeText(me, s, Toast.LENGTH_LONG).show();
                    }
                }
            });
            b.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk519 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk519 = android.util.Log.d("leak-519", dataLeAk519);

				@Override
                public boolean onLongClick(View v) {
                    String dataLeAk520 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk520 = android.util.Log.d("leak-520", dataLeAk520);
					Toast.makeText(me, R.string.loadSettingsHelp,
                                   Toast.LENGTH_LONG).show();
                    return true;
                }
            });
        }
        else
        {
            String dataLeAk521 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk521 = android.util.Log.d("leak-521", dataLeAk521);
			b.setOnClickListener(new View.OnClickListener() {
                String dataLeAk522 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk522 = android.util.Log.d("leak-522", dataLeAk522);

				public void onClick(View v) {
					String dataLeAk523 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk523 = android.util.Log.d("leak-523", dataLeAk523);
                    // do nothing
                }
            });
            b.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk524 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk524 = android.util.Log.d("leak-524", dataLeAk524);

				@Override
                public boolean onLongClick(View v) {
                    String dataLeAk525 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk525 = android.util.Log.d("leak-525", dataLeAk525);
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
            String dataLeAk526 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk526 = android.util.Log.d("leak-526", dataLeAk526);
			if (fakecontact == null)
            {
                String dataLeAk527 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk527 = android.util.Log.d("leak-527", dataLeAk527);
				fakecontact = new Button(this);
                fakecontact.setText("Fake Contact");
                fakecontact.setOnClickListener(new View.OnClickListener() {
                    String dataLeAk528 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk528 = android.util.Log.d("leak-528", dataLeAk528);

					@Override
                    public void onClick(View v) {
                        String dataLeAk529 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk529 = android.util.Log.d("leak-529", dataLeAk529);
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
		String dataLeAk530 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk530 = android.util.Log.d("leak-530", dataLeAk530);
        if (log == null)
        {
            String dataLeAk531 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk531 = android.util.Log.d("leak-531", dataLeAk531);
			final SettingsActivity me = this;
            reResume();
        }
    }
    
    @Override
    public void onBackPressed() {
        String dataLeAk532 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk532 = android.util.Log.d("leak-532", dataLeAk532);
		if (log != null)
        {
            String dataLeAk533 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk533 = android.util.Log.d("leak-533", dataLeAk533);
			setContentView(R.layout.settings_activity);
            log = null;
            reResume();
        }
        else
        {
            super.onBackPressed();
			String dataLeAk534 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk534 = android.util.Log.d("leak-534", dataLeAk534);
        }
    }
}
