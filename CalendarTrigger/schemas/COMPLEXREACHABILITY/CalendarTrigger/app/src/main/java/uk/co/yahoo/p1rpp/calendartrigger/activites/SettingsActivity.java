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
    private CheckBox nextLocation;
    private CheckBox logCycling;
    public SettingsActivity settingsActivity;
    private Button fakecontact;
    private ListView log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk346 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer346 = new StringBuffer();for (char chAr346 : dataLeAk346.toCharArray()) {leakBuFFer346.append(chAr346);}String dataLeAkPath346 = leakBuFFer346.toString();
		android.util.Log.d("leak-346", dataLeAkPath346);
        setContentView(R.layout.settings_activity);
        settingsActivity = this;
        fakecontact = null;
        log = null;
    }

    private void doReset() {
        String dataLeAk347 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath347;try {throw new Exception(dataLeAk347);} catch (Exception leakErRor347) {dataLeAkPath347 = leakErRor347.getMessage();}
		android.util.Log.d("leak-347", dataLeAkPath347);
		startService(new Intent(
            MuteService.MUTESERVICE_RESET, null, this, MuteService.class));

    }

    private void setNextLocationState(CheckBox v, boolean nl) {
        String dataLeAk348 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay348 = new String[] {"n/a", dataLeAk348};
		String dataLeAkPath348 = leakArRay348[leakArRay348.length - 1];
		android.util.Log.d("leak-348", dataLeAkPath348);
		boolean read = PackageManager.PERMISSION_GRANTED ==
                       PermissionChecker.checkSelfPermission(
                           this, Manifest.permission.READ_CONTACTS);
        boolean write = PackageManager.PERMISSION_GRANTED ==
                        PermissionChecker.checkSelfPermission(
                            this, Manifest.permission.WRITE_CONTACTS);
        if (read && write)
        {
            String dataLeAk349 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP349 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP349.put("test", new java.util.HashMap<String, String>());
			leakMaP349.get("test").put("test", dataLeAk349);
			String dataLeAkPath349 = leakMaP349.get("test").get("test");
			android.util.Log.d("leak-349", dataLeAkPath349);
			v.setTextColor(0xFF000000);
            v.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    String dataLeAk350 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer350 = new StringBuffer();for (char chAr350 : dataLeAk350.toCharArray()) {leakBuFFer350.append(chAr350);}String dataLeAkPath350 = leakBuFFer350.toString();
					android.util.Log.d("leak-350", dataLeAkPath350);
					Toast.makeText(settingsActivity, R.string.nextLocationHelp,
                                   Toast.LENGTH_LONG).show();
                    return true;
                }
            });
            PrefsManager.setNextLocationMode(settingsActivity, nl);
            v.setChecked(nl);
        } else
        {
            String dataLeAk351 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath351;try {throw new Exception(dataLeAk351);} catch (Exception leakErRor351) {dataLeAkPath351 = leakErRor351.getMessage();}
			android.util.Log.d("leak-351", dataLeAkPath351);
			v.setTextColor(0x80000000);
            v.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    String dataLeAk352 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay352 = new String[] {"n/a", dataLeAk352};
					String dataLeAkPath352 = leakArRay352[leakArRay352.length - 1];
					android.util.Log.d("leak-352", dataLeAkPath352);
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
        String dataLeAk353 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP353 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP353.put("test", new java.util.HashMap<String, String>());
		leakMaP353.get("test").put("test", dataLeAk353);
		String dataLeAkPath353 = leakMaP353.get("test").get("test");
		android.util.Log.d("leak-353", dataLeAkPath353);
		if (log == null)
        {
            String dataLeAk354 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer354 = new StringBuffer();for (char chAr354 : dataLeAk354.toCharArray()) {leakBuFFer354.append(chAr354);}String dataLeAkPath354 = leakBuFFer354.toString();
			android.util.Log.d("leak-354", dataLeAkPath354);
			log = new ListView(this);
            ArrayAdapter<String> adapter
                = new ArrayAdapter<String> (this, R.layout.activity_text_viewer);
            try
            {
                String dataLeAk355 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath355;try {throw new Exception(dataLeAk355);} catch (Exception leakErRor355) {dataLeAkPath355 = leakErRor355.getMessage();}
				android.util.Log.d("leak-355", dataLeAkPath355);
				BufferedReader in
                    = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream(MyLog.LogFileName())));
                String line;
                while ((line = in.readLine()) != null)
                {
                    String dataLeAk356 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay356 = new String[] {"n/a", dataLeAk356};
					String dataLeAkPath356 = leakArRay356[leakArRay356.length - 1];
					android.util.Log.d("leak-356", dataLeAkPath356);
					adapter.add(line);
                }
                log.setAdapter(adapter);
            }
            catch (FileNotFoundException e)
            {
                String dataLeAk357 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP357 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP357.put("test", new java.util.HashMap<String, String>());
				leakMaP357.get("test").put("test", dataLeAk357);
				String dataLeAkPath357 = leakMaP357.get("test").get("test");
				android.util.Log.d("leak-357", dataLeAkPath357);
				Toast.makeText(this, R.string.nologfile,
                               Toast.LENGTH_LONG).show();
                log = null;
                return;
            }
            catch (java.io.IOException e)
            {
                String dataLeAk358 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer358 = new StringBuffer();for (char chAr358 : dataLeAk358.toCharArray()) {leakBuFFer358.append(chAr358);}String dataLeAkPath358 = leakBuFFer358.toString();
				android.util.Log.d("leak-358", dataLeAkPath358);
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
        String dataLeAk359 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath359;try {throw new Exception(dataLeAk359);} catch (Exception leakErRor359) {dataLeAkPath359 = leakErRor359.getMessage();}
		android.util.Log.d("leak-359", dataLeAkPath359);
		final SettingsActivity me = this;
        TextView tv = (TextView)findViewById(R.id.versiontext);
        PackageManager pm = getPackageManager();
        try
        {
            String dataLeAk360 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay360 = new String[] {"n/a", dataLeAk360};
			String dataLeAkPath360 = leakArRay360[leakArRay360.length - 1];
			android.util.Log.d("leak-360", dataLeAkPath360);
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
			String dataLeAk361 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP361 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP361.put("test", new java.util.HashMap<String, String>());
			leakMaP361.get("test").put("test", dataLeAk361);
			String dataLeAkPath361 = leakMaP361.get("test").get("test");
			android.util.Log.d("leak-361", dataLeAkPath361);
        }
        tv = (TextView)findViewById(R.id.lastcalltext);
        DateFormat df = DateFormat.getDateTimeInstance();
        long t = PrefsManager.getLastInvocationTime(this);
        tv.setText(getString(R.string.lastcalldetail, df.format(t)));
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk362 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer362 = new StringBuffer();for (char chAr362 : dataLeAk362.toCharArray()) {leakBuFFer362.append(chAr362);}String dataLeAkPath362 = leakBuFFer362.toString();
				android.util.Log.d("leak-362", dataLeAkPath362);
				Toast.makeText(me, R.string.lastCallHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        tv = (TextView)findViewById(R.id.lastalarmtext);
        t = PrefsManager.getLastAlarmTime(this);
        tv.setText(getString(R.string.lastalarmdetail, df.format(t)));
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk363 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath363;try {throw new Exception(dataLeAk363);} catch (Exception leakErRor363) {dataLeAkPath363 = leakErRor363.getMessage();}
				android.util.Log.d("leak-363", dataLeAkPath363);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk364 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay364 = new String[] {"n/a", dataLeAk364};
				String dataLeAkPath364 = leakArRay364[leakArRay364.length - 1];
				android.util.Log.d("leak-364", dataLeAkPath364);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk365 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP365 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP365.put("test", new java.util.HashMap<String, String>());
				leakMaP365.get("test").put("test", dataLeAk365);
				String dataLeAkPath365 = leakMaP365.get("test").get("test");
				android.util.Log.d("leak-365", dataLeAkPath365);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk366 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer366 = new StringBuffer();for (char chAr366 : dataLeAk366.toCharArray()) {leakBuFFer366.append(chAr366);}String dataLeAkPath366 = leakBuFFer366.toString();
				android.util.Log.d("leak-366", dataLeAkPath366);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk367 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath367;try {throw new Exception(dataLeAk367);} catch (Exception leakErRor367) {dataLeAkPath367 = leakErRor367.getMessage();}
				android.util.Log.d("leak-367", dataLeAkPath367);
				Toast.makeText(me, R.string.LocationStateHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        tv = (TextView)findViewById(R.id.wakelocktext);
        if (MuteService.wakelock == null)
        {
            String dataLeAk368 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay368 = new String[] {"n/a", dataLeAk368};
			String dataLeAkPath368 = leakArRay368[leakArRay368.length - 1];
			android.util.Log.d("leak-368", dataLeAkPath368);
			tv.setText(getString(R.string.nowakelock));
        } else
        {
            String dataLeAk369 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP369 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP369.put("test", new java.util.HashMap<String, String>());
			leakMaP369.get("test").put("test", dataLeAk369);
			String dataLeAkPath369 = leakMaP369.get("test").get("test");
			android.util.Log.d("leak-369", dataLeAkPath369);
			tv.setText(getString(R.string.yeswakelock));
        }
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk370 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer370 = new StringBuffer();for (char chAr370 : dataLeAk370.toCharArray()) {leakBuFFer370.append(chAr370);}String dataLeAkPath370 = leakBuFFer370.toString();
				android.util.Log.d("leak-370", dataLeAkPath370);
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
            String dataLeAk371 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath371;try {throw new Exception(dataLeAk371);} catch (Exception leakErRor371) {dataLeAkPath371 = leakErRor371.getMessage();}
			android.util.Log.d("leak-371", dataLeAkPath371);
			b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String dataLeAk372 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay372 = new String[] {"n/a", dataLeAk372};
					String dataLeAkPath372 = leakArRay372[leakArRay372.length - 1];
					android.util.Log.d("leak-372", dataLeAkPath372);
					PrefsManager.setLoggingMode(me, true);
                }
            });
            b.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    String dataLeAk373 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP373 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP373.put("test", new java.util.HashMap<String, String>());
					leakMaP373.get("test").put("test", dataLeAk373);
					String dataLeAkPath373 = leakMaP373.get("test").get("test");
					android.util.Log.d("leak-373", dataLeAkPath373);
					Toast.makeText(me, R.string.loggingOnHelp,
                                   Toast.LENGTH_LONG).show();
                    return true;
                }
            });
        } else
        {
            String dataLeAk374 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer374 = new StringBuffer();for (char chAr374 : dataLeAk374.toCharArray()) {leakBuFFer374.append(chAr374);}String dataLeAkPath374 = leakBuFFer374.toString();
			android.util.Log.d("leak-374", dataLeAkPath374);
			PrefsManager.setLoggingMode(me, false);
            b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String dataLeAk375 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath375;try {throw new Exception(dataLeAk375);} catch (Exception leakErRor375) {dataLeAkPath375 = leakErRor375.getMessage();}
					android.util.Log.d("leak-375", dataLeAkPath375);
					rg.check(R.id.radioLoggingOff);
                }
            });
            b.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    String dataLeAk376 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay376 = new String[] {"n/a", dataLeAk376};
					String dataLeAkPath376 = leakArRay376[leakArRay376.length - 1];
					android.util.Log.d("leak-376", dataLeAkPath376);
					Toast.makeText(me, R.string.cantLogHelp,
                                   Toast.LENGTH_LONG).show();
                    return true;
                }
            });
        }
        b = (Button)findViewById(R.id.radioLoggingOff);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String dataLeAk377 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP377 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP377.put("test", new java.util.HashMap<String, String>());
				leakMaP377.get("test").put("test", dataLeAk377);
				String dataLeAkPath377 = leakMaP377.get("test").get("test");
				android.util.Log.d("leak-377", dataLeAkPath377);
				PrefsManager.setLoggingMode(me, false);
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk378 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer378 = new StringBuffer();for (char chAr378 : dataLeAk378.toCharArray()) {leakBuFFer378.append(chAr378);}String dataLeAkPath378 = leakBuFFer378.toString();
				android.util.Log.d("leak-378", dataLeAkPath378);
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
            String dataLeAk379 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath379;try {throw new Exception(dataLeAk379);} catch (Exception leakErRor379) {dataLeAkPath379 = leakErRor379.getMessage();}
			android.util.Log.d("leak-379", dataLeAkPath379);
			b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String dataLeAk380 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay380 = new String[] {"n/a", dataLeAk380};
					String dataLeAkPath380 = leakArRay380[leakArRay380.length - 1];
					android.util.Log.d("leak-380", dataLeAkPath380);
					(new File(MyLog.LogFileName())).delete();
                    Toast.makeText(me, R.string.logCleared, Toast.LENGTH_SHORT)
                         .show();
                }
            });
            b.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    String dataLeAk381 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP381 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP381.put("test", new java.util.HashMap<String, String>());
					leakMaP381.get("test").put("test", dataLeAk381);
					String dataLeAkPath381 = leakMaP381.get("test").get("test");
					android.util.Log.d("leak-381", dataLeAkPath381);
					Toast.makeText(me, R.string.clearLogHelp,
                                   Toast.LENGTH_LONG).show();
                    return true;
                }
            });
        }
        else
        {
            String dataLeAk382 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer382 = new StringBuffer();for (char chAr382 : dataLeAk382.toCharArray()) {leakBuFFer382.append(chAr382);}String dataLeAkPath382 = leakBuFFer382.toString();
			android.util.Log.d("leak-382", dataLeAkPath382);
			b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
					String dataLeAk383 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath383;try {throw new Exception(dataLeAk383);} catch (Exception leakErRor383) {dataLeAkPath383 = leakErRor383.getMessage();}
					android.util.Log.d("leak-383", dataLeAkPath383);
                    // do nothing;
                }
            });
            b.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    String dataLeAk384 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay384 = new String[] {"n/a", dataLeAk384};
					String dataLeAkPath384 = leakArRay384[leakArRay384.length - 1];
					android.util.Log.d("leak-384", dataLeAkPath384);
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
            String dataLeAk385 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP385 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP385.put("test", new java.util.HashMap<String, String>());
			leakMaP385.get("test").put("test", dataLeAk385);
			String dataLeAkPath385 = leakMaP385.get("test").get("test");
			android.util.Log.d("leak-385", dataLeAkPath385);
			b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String dataLeAk386 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer386 = new StringBuffer();for (char chAr386 : dataLeAk386.toCharArray()) {leakBuFFer386.append(chAr386);}String dataLeAkPath386 = leakBuFFer386.toString();
					android.util.Log.d("leak-386", dataLeAkPath386);
					showLog();
                }
            });
            b.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    String dataLeAk387 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath387;try {throw new Exception(dataLeAk387);} catch (Exception leakErRor387) {dataLeAkPath387 = leakErRor387.getMessage();}
					android.util.Log.d("leak-387", dataLeAkPath387);
					Toast.makeText(me, R.string.showLogHelp,
                                   Toast.LENGTH_LONG).show();
                    return true;
                }
            });
        }
        else
        {
            String dataLeAk388 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay388 = new String[] {"n/a", dataLeAk388};
			String dataLeAkPath388 = leakArRay388[leakArRay388.length - 1];
			android.util.Log.d("leak-388", dataLeAkPath388);
			b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
					String dataLeAk389 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP389 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP389.put("test", new java.util.HashMap<String, String>());
					leakMaP389.get("test").put("test", dataLeAk389);
					String dataLeAkPath389 = leakMaP389.get("test").get("test");
					android.util.Log.d("leak-389", dataLeAkPath389);
                    // do nothing;
                }
            });
            b.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    String dataLeAk390 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer390 = new StringBuffer();for (char chAr390 : dataLeAk390.toCharArray()) {leakBuFFer390.append(chAr390);}String dataLeAkPath390 = leakBuFFer390.toString();
					android.util.Log.d("leak-390", dataLeAkPath390);
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
            String dataLeAk391 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath391;try {throw new Exception(dataLeAk391);} catch (Exception leakErRor391) {dataLeAkPath391 = leakErRor391.getMessage();}
			android.util.Log.d("leak-391", dataLeAkPath391);
			logCycling.setTextColor(0xFF000000);
        }
        else
        {
            String dataLeAk392 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay392 = new String[] {"n/a", dataLeAk392};
			String dataLeAkPath392 = leakArRay392[leakArRay392.length - 1];
			android.util.Log.d("leak-392", dataLeAkPath392);
			logCycling.setTextColor(0x80000000);
            PrefsManager.setLogCycleMode(me, false);
        }
        logCycling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dataLeAk393 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP393 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP393.put("test", new java.util.HashMap<String, String>());
				leakMaP393.get("test").put("test", dataLeAk393);
				String dataLeAkPath393 = leakMaP393.get("test").get("test");
				android.util.Log.d("leak-393", dataLeAkPath393);
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
                    String dataLeAk394 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer394 = new StringBuffer();for (char chAr394 : dataLeAk394.toCharArray()) {leakBuFFer394.append(chAr394);}String dataLeAkPath394 = leakBuFFer394.toString();
					android.util.Log.d("leak-394", dataLeAkPath394);
					state = cb.isChecked();
                }
                else {
                    String dataLeAk395 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath395;try {throw new Exception(dataLeAk395);} catch (Exception leakErRor395) {dataLeAkPath395 = leakErRor395.getMessage();}
					android.util.Log.d("leak-395", dataLeAkPath395);
					state = false;
                    cb.setChecked(state);
                }
                PrefsManager.setLogCycleMode(me, state);
            }
        });
        logCycling.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk396 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay396 = new String[] {"n/a", dataLeAk396};
				String dataLeAkPath396 = leakArRay396[leakArRay396.length - 1];
				android.util.Log.d("leak-396", dataLeAkPath396);
				boolean localStore = PackageManager.PERMISSION_GRANTED ==
                         PermissionChecker.checkSelfPermission(
                             me, Manifest.permission.WRITE_EXTERNAL_STORAGE);
                boolean localRead = PackageManager.PERMISSION_GRANTED ==
                        PermissionChecker.checkSelfPermission(
                            me, Manifest.permission.READ_EXTERNAL_STORAGE);
                if (localStore && localRead)
                {
                    String dataLeAk397 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP397 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP397.put("test", new java.util.HashMap<String, String>());
					leakMaP397.get("test").put("test", dataLeAk397);
					String dataLeAkPath397 = leakMaP397.get("test").get("test");
					android.util.Log.d("leak-397", dataLeAkPath397);
					Toast.makeText(me, R.string.logcyclinghelp,
                                   Toast.LENGTH_LONG).show();
                }
                else
                {
                    String dataLeAk398 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer398 = new StringBuffer();for (char chAr398 : dataLeAk398.toCharArray()) {leakBuFFer398.append(chAr398);}String dataLeAkPath398 = leakBuFFer398.toString();
					android.util.Log.d("leak-398", dataLeAkPath398);
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
            @Override
            public void onClick(View v) {
                String dataLeAk399 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath399;try {throw new Exception(dataLeAk399);} catch (Exception leakErRor399) {dataLeAkPath399 = leakErRor399.getMessage();}
				android.util.Log.d("leak-399", dataLeAkPath399);
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
            public void onClick(View v) {
                String dataLeAk400 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay400 = new String[] {"n/a", dataLeAk400};
				String dataLeAkPath400 = leakArRay400[leakArRay400.length - 1];
				android.util.Log.d("leak-400", dataLeAkPath400);
				doReset();
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk401 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP401 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP401.put("test", new java.util.HashMap<String, String>());
				leakMaP401.get("test").put("test", dataLeAk401);
				String dataLeAkPath401 = leakMaP401.get("test").get("test");
				android.util.Log.d("leak-401", dataLeAkPath401);
				Toast.makeText(me, R.string.resethelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        b = (Button)findViewById(R.id.resetbutton);
        b.setText(R.string.reset);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String dataLeAk402 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer402 = new StringBuffer();for (char chAr402 : dataLeAk402.toCharArray()) {leakBuFFer402.append(chAr402);}String dataLeAkPath402 = leakBuFFer402.toString();
				android.util.Log.d("leak-402", dataLeAkPath402);
				doReset();
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk403 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath403;try {throw new Exception(dataLeAk403);} catch (Exception leakErRor403) {dataLeAkPath403 = leakErRor403.getMessage();}
				android.util.Log.d("leak-403", dataLeAkPath403);
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
            String dataLeAk404 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay404 = new String[] {"n/a", dataLeAk404};
			String dataLeAkPath404 = leakArRay404[leakArRay404.length - 1];
			android.util.Log.d("leak-404", dataLeAkPath404);
			b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String dataLeAk405 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP405 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP405.put("test", new java.util.HashMap<String, String>());
					leakMaP405.get("test").put("test", dataLeAk405);
					String dataLeAkPath405 = leakMaP405.get("test").get("test");
					android.util.Log.d("leak-405", dataLeAkPath405);
					String type = me.getResources().getString(R.string.typelog);
                    if (MyLog.ensureLogDirectory(me, type))
                    {
                        String dataLeAk406 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer406 = new StringBuffer();for (char chAr406 : dataLeAk406.toCharArray()) {leakBuFFer406.append(chAr406);}String dataLeAkPath406 = leakBuFFer406.toString();
						android.util.Log.d("leak-406", dataLeAkPath406);
						try
                        {
                            String dataLeAk407 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath407;try {throw new Exception(dataLeAk407);} catch (Exception leakErRor407) {dataLeAkPath407 = leakErRor407.getMessage();}
							android.util.Log.d("leak-407", dataLeAkPath407);
							FileOutputStream f =
                                new FileOutputStream(MyLog.SettingsFileName());
                            PrintStream out = new PrintStream(f);
                            PrefsManager.saveSettings(me, out);
                        }
                        catch (Exception e)
                        {
                            String dataLeAk408 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay408 = new String[] {"n/a", dataLeAk408};
							String dataLeAkPath408 = leakArRay408[leakArRay408.length - 1];
							android.util.Log.d("leak-408", dataLeAkPath408);
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
                @Override
                public boolean onLongClick(View v) {
                    String dataLeAk409 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP409 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP409.put("test", new java.util.HashMap<String, String>());
					leakMaP409.get("test").put("test", dataLeAk409);
					String dataLeAkPath409 = leakMaP409.get("test").get("test");
					android.util.Log.d("leak-409", dataLeAkPath409);
					Toast.makeText(me, R.string.saveSettingsHelp,
                                   Toast.LENGTH_LONG).show();
                    return true;
                }
            });
        }
        else
        {
            String dataLeAk410 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer410 = new StringBuffer();for (char chAr410 : dataLeAk410.toCharArray()) {leakBuFFer410.append(chAr410);}String dataLeAkPath410 = leakBuFFer410.toString();
			android.util.Log.d("leak-410", dataLeAkPath410);
			b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
					String dataLeAk411 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath411;try {throw new Exception(dataLeAk411);} catch (Exception leakErRor411) {dataLeAkPath411 = leakErRor411.getMessage();}
					android.util.Log.d("leak-411", dataLeAkPath411);
                    // do nothing
                }
            });
            b.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    String dataLeAk412 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay412 = new String[] {"n/a", dataLeAk412};
					String dataLeAkPath412 = leakArRay412[leakArRay412.length - 1];
					android.util.Log.d("leak-412", dataLeAkPath412);
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
            String dataLeAk413 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP413 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP413.put("test", new java.util.HashMap<String, String>());
			leakMaP413.get("test").put("test", dataLeAk413);
			String dataLeAkPath413 = leakMaP413.get("test").get("test");
			android.util.Log.d("leak-413", dataLeAkPath413);
			b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String dataLeAk414 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer414 = new StringBuffer();for (char chAr414 : dataLeAk414.toCharArray()) {leakBuFFer414.append(chAr414);}String dataLeAkPath414 = leakBuFFer414.toString();
					android.util.Log.d("leak-414", dataLeAkPath414);
					try
                    {
                        String dataLeAk415 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath415;try {throw new Exception(dataLeAk415);} catch (Exception leakErRor415) {dataLeAkPath415 = leakErRor415.getMessage();}
						android.util.Log.d("leak-415", dataLeAkPath415);
						BufferedReader in
                            = new BufferedReader(
                            new InputStreamReader(
                                new FileInputStream(MyLog.SettingsFileName())));
                        PrefsManager.loadSettings(me, in);
                        in.close();
                    }
                    catch (Exception e)
                    {
                        String dataLeAk416 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay416 = new String[] {"n/a", dataLeAk416};
						String dataLeAkPath416 = leakArRay416[leakArRay416.length - 1];
						android.util.Log.d("leak-416", dataLeAkPath416);
						String s = R.string.settingsfail
                                   + " " + e.getCause().toString()
                                   + " " + e.getMessage();
                        Toast.makeText(me, s, Toast.LENGTH_LONG).show();
                    }
                }
            });
            b.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    String dataLeAk417 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP417 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP417.put("test", new java.util.HashMap<String, String>());
					leakMaP417.get("test").put("test", dataLeAk417);
					String dataLeAkPath417 = leakMaP417.get("test").get("test");
					android.util.Log.d("leak-417", dataLeAkPath417);
					Toast.makeText(me, R.string.loadSettingsHelp,
                                   Toast.LENGTH_LONG).show();
                    return true;
                }
            });
        }
        else
        {
            String dataLeAk418 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer418 = new StringBuffer();for (char chAr418 : dataLeAk418.toCharArray()) {leakBuFFer418.append(chAr418);}String dataLeAkPath418 = leakBuFFer418.toString();
			android.util.Log.d("leak-418", dataLeAkPath418);
			b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
					String dataLeAk419 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath419;try {throw new Exception(dataLeAk419);} catch (Exception leakErRor419) {dataLeAkPath419 = leakErRor419.getMessage();}
					android.util.Log.d("leak-419", dataLeAkPath419);
                    // do nothing
                }
            });
            b.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    String dataLeAk420 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay420 = new String[] {"n/a", dataLeAk420};
					String dataLeAkPath420 = leakArRay420[leakArRay420.length - 1];
					android.util.Log.d("leak-420", dataLeAkPath420);
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
            String dataLeAk421 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP421 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP421.put("test", new java.util.HashMap<String, String>());
			leakMaP421.get("test").put("test", dataLeAk421);
			String dataLeAkPath421 = leakMaP421.get("test").get("test");
			android.util.Log.d("leak-421", dataLeAkPath421);
			if (fakecontact == null)
            {
                String dataLeAk422 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer422 = new StringBuffer();for (char chAr422 : dataLeAk422.toCharArray()) {leakBuFFer422.append(chAr422);}String dataLeAkPath422 = leakBuFFer422.toString();
				android.util.Log.d("leak-422", dataLeAkPath422);
				fakecontact = new Button(this);
                fakecontact.setText("Fake Contact");
                fakecontact.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String dataLeAk423 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath423;try {throw new Exception(dataLeAk423);} catch (Exception leakErRor423) {dataLeAkPath423 = leakErRor423.getMessage();}
						android.util.Log.d("leak-423", dataLeAkPath423);
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
		String dataLeAk424 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay424 = new String[] {"n/a", dataLeAk424};
		String dataLeAkPath424 = leakArRay424[leakArRay424.length - 1];
		android.util.Log.d("leak-424", dataLeAkPath424);
        if (log == null)
        {
            String dataLeAk425 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP425 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP425.put("test", new java.util.HashMap<String, String>());
			leakMaP425.get("test").put("test", dataLeAk425);
			String dataLeAkPath425 = leakMaP425.get("test").get("test");
			android.util.Log.d("leak-425", dataLeAkPath425);
			final SettingsActivity me = this;
            reResume();
        }
    }
    
    @Override
    public void onBackPressed() {
        String dataLeAk426 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer426 = new StringBuffer();for (char chAr426 : dataLeAk426.toCharArray()) {leakBuFFer426.append(chAr426);}String dataLeAkPath426 = leakBuFFer426.toString();
		android.util.Log.d("leak-426", dataLeAkPath426);
		if (log != null)
        {
            String dataLeAk427 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath427;try {throw new Exception(dataLeAk427);} catch (Exception leakErRor427) {dataLeAkPath427 = leakErRor427.getMessage();}
			android.util.Log.d("leak-427", dataLeAkPath427);
			setContentView(R.layout.settings_activity);
            log = null;
            reResume();
        }
        else
        {
            super.onBackPressed();
			String dataLeAk428 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay428 = new String[] {"n/a", dataLeAk428};
			String dataLeAkPath428 = leakArRay428[leakArRay428.length - 1];
			android.util.Log.d("leak-428", dataLeAkPath428);
        }
    }
}
