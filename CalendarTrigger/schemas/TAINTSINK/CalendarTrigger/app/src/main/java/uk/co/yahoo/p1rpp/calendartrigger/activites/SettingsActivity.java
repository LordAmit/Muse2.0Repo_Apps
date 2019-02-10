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
    String dataLeAk284 = "284";

	String dataLeAk283 = "283";

	String dataLeAk282 = "282";

	String dataLeAk280 = "280";

	String dataLeAk278 = "278";

	String dataLeAk276 = "276";

	String dataLeAk274 = "274";

	String dataLeAk272 = "272";

	String dataLeAk270 = "270";

	String dataLeAk268 = "268";

	String dataLeAk266 = "266";

	String dataLeAk264 = "264";

	String dataLeAk262 = "262";

	String dataLeAk260 = "260";

	String dataLeAk258 = "258";

	String dataLeAk256 = "256";

	String dataLeAk254 = "254";

	String dataLeAk252 = "252";

	String dataLeAk250 = "250";

	String dataLeAk248 = "248";

	String dataLeAk246 = "246";

	String dataLeAk244 = "244";

	String dataLeAk242 = "242";

	String dataLeAk240 = "240";

	String dataLeAk238 = "238";

	String dataLeAk236 = "236";

	String dataLeAk234 = "234";

	String dataLeAk232 = "232";

	String dataLeAk230 = "230";

	String dataLeAk228 = "228";

	String dataLeAk226 = "226";

	String dataLeAk224 = "224";

	String dataLeAk222 = "222";

	String dataLeAk220 = "220";

	String dataLeAk218 = "218";

	String dataLeAk216 = "216";

	String dataLeAk214 = "214";

	String dataLeAk212 = "212";

	String dataLeAk210 = "210";

	String dataLeAk208 = "208";

	String dataLeAk207 = "207";

	String dataLeAk205 = "205";

	String dataLeAk203 = "203";

	private CheckBox nextLocation;
    private CheckBox logCycling;
    public SettingsActivity settingsActivity;
    private Button fakecontact;
    private ListView log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		android.util.Log.d("leak-203-109", dataLeAk203);
		android.util.Log.d("leak-205-109", dataLeAk205);
		android.util.Log.d("leak-207-109", dataLeAk207);
		android.util.Log.d("leak-208-109", dataLeAk208);
		android.util.Log.d("leak-210-109", dataLeAk210);
		android.util.Log.d("leak-212-109", dataLeAk212);
		android.util.Log.d("leak-214-109", dataLeAk214);
		android.util.Log.d("leak-216-109", dataLeAk216);
		android.util.Log.d("leak-218-109", dataLeAk218);
		android.util.Log.d("leak-220-109", dataLeAk220);
		android.util.Log.d("leak-222-109", dataLeAk222);
		android.util.Log.d("leak-224-109", dataLeAk224);
		android.util.Log.d("leak-226-109", dataLeAk226);
		android.util.Log.d("leak-228-109", dataLeAk228);
		android.util.Log.d("leak-230-109", dataLeAk230);
		android.util.Log.d("leak-232-109", dataLeAk232);
		android.util.Log.d("leak-234-109", dataLeAk234);
		android.util.Log.d("leak-236-109", dataLeAk236);
		android.util.Log.d("leak-238-109", dataLeAk238);
		android.util.Log.d("leak-240-109", dataLeAk240);
		android.util.Log.d("leak-242-109", dataLeAk242);
		android.util.Log.d("leak-244-109", dataLeAk244);
		android.util.Log.d("leak-246-109", dataLeAk246);
		android.util.Log.d("leak-248-109", dataLeAk248);
		android.util.Log.d("leak-250-109", dataLeAk250);
		android.util.Log.d("leak-252-109", dataLeAk252);
		android.util.Log.d("leak-254-109", dataLeAk254);
		android.util.Log.d("leak-256-109", dataLeAk256);
		android.util.Log.d("leak-258-109", dataLeAk258);
		android.util.Log.d("leak-260-109", dataLeAk260);
		android.util.Log.d("leak-262-109", dataLeAk262);
		android.util.Log.d("leak-264-109", dataLeAk264);
		android.util.Log.d("leak-266-109", dataLeAk266);
		android.util.Log.d("leak-268-109", dataLeAk268);
		android.util.Log.d("leak-270-109", dataLeAk270);
		android.util.Log.d("leak-272-109", dataLeAk272);
		android.util.Log.d("leak-274-109", dataLeAk274);
		android.util.Log.d("leak-276-109", dataLeAk276);
		android.util.Log.d("leak-278-109", dataLeAk278);
		android.util.Log.d("leak-280-109", dataLeAk280);
		android.util.Log.d("leak-282-109", dataLeAk282);
		android.util.Log.d("leak-283-109", dataLeAk283);
		android.util.Log.d("leak-284-109", dataLeAk284);
		dataLeAk203 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        setContentView(R.layout.settings_activity);
        settingsActivity = this;
        fakecontact = null;
        log = null;
    }

    private void doReset() {
        startService(new Intent(
            MuteService.MUTESERVICE_RESET, null, this, MuteService.class));
		android.util.Log.d("leak-203-110", dataLeAk203);
		android.util.Log.d("leak-205-110", dataLeAk205);
		android.util.Log.d("leak-207-110", dataLeAk207);
		android.util.Log.d("leak-208-110", dataLeAk208);
		android.util.Log.d("leak-210-110", dataLeAk210);
		android.util.Log.d("leak-212-110", dataLeAk212);
		android.util.Log.d("leak-214-110", dataLeAk214);
		android.util.Log.d("leak-216-110", dataLeAk216);
		android.util.Log.d("leak-218-110", dataLeAk218);
		android.util.Log.d("leak-220-110", dataLeAk220);
		android.util.Log.d("leak-222-110", dataLeAk222);
		android.util.Log.d("leak-224-110", dataLeAk224);
		android.util.Log.d("leak-226-110", dataLeAk226);
		android.util.Log.d("leak-228-110", dataLeAk228);
		android.util.Log.d("leak-230-110", dataLeAk230);
		android.util.Log.d("leak-232-110", dataLeAk232);
		android.util.Log.d("leak-234-110", dataLeAk234);
		android.util.Log.d("leak-236-110", dataLeAk236);
		android.util.Log.d("leak-238-110", dataLeAk238);
		android.util.Log.d("leak-240-110", dataLeAk240);
		android.util.Log.d("leak-242-110", dataLeAk242);
		android.util.Log.d("leak-244-110", dataLeAk244);
		android.util.Log.d("leak-246-110", dataLeAk246);
		android.util.Log.d("leak-248-110", dataLeAk248);
		android.util.Log.d("leak-250-110", dataLeAk250);
		android.util.Log.d("leak-252-110", dataLeAk252);
		android.util.Log.d("leak-254-110", dataLeAk254);
		android.util.Log.d("leak-256-110", dataLeAk256);
		android.util.Log.d("leak-258-110", dataLeAk258);
		android.util.Log.d("leak-260-110", dataLeAk260);
		android.util.Log.d("leak-262-110", dataLeAk262);
		android.util.Log.d("leak-264-110", dataLeAk264);
		android.util.Log.d("leak-266-110", dataLeAk266);
		android.util.Log.d("leak-268-110", dataLeAk268);
		android.util.Log.d("leak-270-110", dataLeAk270);
		android.util.Log.d("leak-272-110", dataLeAk272);
		android.util.Log.d("leak-274-110", dataLeAk274);
		android.util.Log.d("leak-276-110", dataLeAk276);
		android.util.Log.d("leak-278-110", dataLeAk278);
		android.util.Log.d("leak-280-110", dataLeAk280);
		android.util.Log.d("leak-282-110", dataLeAk282);
		android.util.Log.d("leak-283-110", dataLeAk283);
		android.util.Log.d("leak-284-110", dataLeAk284);

    }

    private void setNextLocationState(CheckBox v, boolean nl) {
        boolean read = PackageManager.PERMISSION_GRANTED ==
                       PermissionChecker.checkSelfPermission(
                           this, Manifest.permission.READ_CONTACTS);
		android.util.Log.d("leak-203-111", dataLeAk203);
		android.util.Log.d("leak-205-111", dataLeAk205);
		android.util.Log.d("leak-207-111", dataLeAk207);
		android.util.Log.d("leak-208-111", dataLeAk208);
		android.util.Log.d("leak-210-111", dataLeAk210);
		android.util.Log.d("leak-212-111", dataLeAk212);
		android.util.Log.d("leak-214-111", dataLeAk214);
		android.util.Log.d("leak-216-111", dataLeAk216);
		android.util.Log.d("leak-218-111", dataLeAk218);
		android.util.Log.d("leak-220-111", dataLeAk220);
		android.util.Log.d("leak-222-111", dataLeAk222);
		android.util.Log.d("leak-224-111", dataLeAk224);
		android.util.Log.d("leak-226-111", dataLeAk226);
		android.util.Log.d("leak-228-111", dataLeAk228);
		android.util.Log.d("leak-230-111", dataLeAk230);
		android.util.Log.d("leak-232-111", dataLeAk232);
		android.util.Log.d("leak-234-111", dataLeAk234);
		android.util.Log.d("leak-236-111", dataLeAk236);
		android.util.Log.d("leak-238-111", dataLeAk238);
		android.util.Log.d("leak-240-111", dataLeAk240);
		android.util.Log.d("leak-242-111", dataLeAk242);
		android.util.Log.d("leak-244-111", dataLeAk244);
		android.util.Log.d("leak-246-111", dataLeAk246);
		android.util.Log.d("leak-248-111", dataLeAk248);
		android.util.Log.d("leak-250-111", dataLeAk250);
		android.util.Log.d("leak-252-111", dataLeAk252);
		android.util.Log.d("leak-254-111", dataLeAk254);
		android.util.Log.d("leak-256-111", dataLeAk256);
		android.util.Log.d("leak-258-111", dataLeAk258);
		android.util.Log.d("leak-260-111", dataLeAk260);
		android.util.Log.d("leak-262-111", dataLeAk262);
		android.util.Log.d("leak-264-111", dataLeAk264);
		android.util.Log.d("leak-266-111", dataLeAk266);
		android.util.Log.d("leak-268-111", dataLeAk268);
		android.util.Log.d("leak-270-111", dataLeAk270);
		android.util.Log.d("leak-272-111", dataLeAk272);
		android.util.Log.d("leak-274-111", dataLeAk274);
		android.util.Log.d("leak-276-111", dataLeAk276);
		android.util.Log.d("leak-278-111", dataLeAk278);
		android.util.Log.d("leak-280-111", dataLeAk280);
		android.util.Log.d("leak-282-111", dataLeAk282);
		android.util.Log.d("leak-283-111", dataLeAk283);
		android.util.Log.d("leak-284-111", dataLeAk284);
        boolean write = PackageManager.PERMISSION_GRANTED ==
                        PermissionChecker.checkSelfPermission(
                            this, Manifest.permission.WRITE_CONTACTS);
        if (read && write)
        {
            v.setTextColor(0xFF000000);
            v.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk204 = "204";

				@Override
                public boolean onLongClick(View v) {
                    dataLeAk205 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk204 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
                String dataLeAk206 = "206";

				@Override
                public boolean onLongClick(View v) {
                    dataLeAk207 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk206 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
		android.util.Log.d("leak-203-112", dataLeAk203);
		android.util.Log.d("leak-205-112", dataLeAk205);
		android.util.Log.d("leak-207-112", dataLeAk207);
		android.util.Log.d("leak-208-112", dataLeAk208);
		android.util.Log.d("leak-210-112", dataLeAk210);
		android.util.Log.d("leak-212-112", dataLeAk212);
		android.util.Log.d("leak-214-112", dataLeAk214);
		android.util.Log.d("leak-216-112", dataLeAk216);
		android.util.Log.d("leak-218-112", dataLeAk218);
		android.util.Log.d("leak-220-112", dataLeAk220);
		android.util.Log.d("leak-222-112", dataLeAk222);
		android.util.Log.d("leak-224-112", dataLeAk224);
		android.util.Log.d("leak-226-112", dataLeAk226);
		android.util.Log.d("leak-228-112", dataLeAk228);
		android.util.Log.d("leak-230-112", dataLeAk230);
		android.util.Log.d("leak-232-112", dataLeAk232);
		android.util.Log.d("leak-234-112", dataLeAk234);
		android.util.Log.d("leak-236-112", dataLeAk236);
		android.util.Log.d("leak-238-112", dataLeAk238);
		android.util.Log.d("leak-240-112", dataLeAk240);
		android.util.Log.d("leak-242-112", dataLeAk242);
		android.util.Log.d("leak-244-112", dataLeAk244);
		android.util.Log.d("leak-246-112", dataLeAk246);
		android.util.Log.d("leak-248-112", dataLeAk248);
		android.util.Log.d("leak-250-112", dataLeAk250);
		android.util.Log.d("leak-252-112", dataLeAk252);
		android.util.Log.d("leak-254-112", dataLeAk254);
		android.util.Log.d("leak-256-112", dataLeAk256);
		android.util.Log.d("leak-258-112", dataLeAk258);
		android.util.Log.d("leak-260-112", dataLeAk260);
		android.util.Log.d("leak-262-112", dataLeAk262);
		android.util.Log.d("leak-264-112", dataLeAk264);
		android.util.Log.d("leak-266-112", dataLeAk266);
		android.util.Log.d("leak-268-112", dataLeAk268);
		android.util.Log.d("leak-270-112", dataLeAk270);
		android.util.Log.d("leak-272-112", dataLeAk272);
		android.util.Log.d("leak-274-112", dataLeAk274);
		android.util.Log.d("leak-276-112", dataLeAk276);
		android.util.Log.d("leak-278-112", dataLeAk278);
		android.util.Log.d("leak-280-112", dataLeAk280);
		android.util.Log.d("leak-282-112", dataLeAk282);
		android.util.Log.d("leak-283-112", dataLeAk283);
		android.util.Log.d("leak-284-112", dataLeAk284);
    }

    protected void reResume() {
        dataLeAk208 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-203-113", dataLeAk203);
		android.util.Log.d("leak-205-113", dataLeAk205);
		android.util.Log.d("leak-207-113", dataLeAk207);
		android.util.Log.d("leak-208-113", dataLeAk208);
		android.util.Log.d("leak-210-113", dataLeAk210);
		android.util.Log.d("leak-212-113", dataLeAk212);
		android.util.Log.d("leak-214-113", dataLeAk214);
		android.util.Log.d("leak-216-113", dataLeAk216);
		android.util.Log.d("leak-218-113", dataLeAk218);
		android.util.Log.d("leak-220-113", dataLeAk220);
		android.util.Log.d("leak-222-113", dataLeAk222);
		android.util.Log.d("leak-224-113", dataLeAk224);
		android.util.Log.d("leak-226-113", dataLeAk226);
		android.util.Log.d("leak-228-113", dataLeAk228);
		android.util.Log.d("leak-230-113", dataLeAk230);
		android.util.Log.d("leak-232-113", dataLeAk232);
		android.util.Log.d("leak-234-113", dataLeAk234);
		android.util.Log.d("leak-236-113", dataLeAk236);
		android.util.Log.d("leak-238-113", dataLeAk238);
		android.util.Log.d("leak-240-113", dataLeAk240);
		android.util.Log.d("leak-242-113", dataLeAk242);
		android.util.Log.d("leak-244-113", dataLeAk244);
		android.util.Log.d("leak-246-113", dataLeAk246);
		android.util.Log.d("leak-248-113", dataLeAk248);
		android.util.Log.d("leak-250-113", dataLeAk250);
		android.util.Log.d("leak-252-113", dataLeAk252);
		android.util.Log.d("leak-254-113", dataLeAk254);
		android.util.Log.d("leak-256-113", dataLeAk256);
		android.util.Log.d("leak-258-113", dataLeAk258);
		android.util.Log.d("leak-260-113", dataLeAk260);
		android.util.Log.d("leak-262-113", dataLeAk262);
		android.util.Log.d("leak-264-113", dataLeAk264);
		android.util.Log.d("leak-266-113", dataLeAk266);
		android.util.Log.d("leak-268-113", dataLeAk268);
		android.util.Log.d("leak-270-113", dataLeAk270);
		android.util.Log.d("leak-272-113", dataLeAk272);
		android.util.Log.d("leak-274-113", dataLeAk274);
		android.util.Log.d("leak-276-113", dataLeAk276);
		android.util.Log.d("leak-278-113", dataLeAk278);
		android.util.Log.d("leak-280-113", dataLeAk280);
		android.util.Log.d("leak-282-113", dataLeAk282);
		android.util.Log.d("leak-283-113", dataLeAk283);
		android.util.Log.d("leak-284-113", dataLeAk284);
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
            String dataLeAk209 = "209";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk210 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk209 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Toast.makeText(me, R.string.lastCallHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        tv = (TextView)findViewById(R.id.lastalarmtext);
        t = PrefsManager.getLastAlarmTime(this);
        tv.setText(getString(R.string.lastalarmdetail, df.format(t)));
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk211 = "211";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk212 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk211 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
            String dataLeAk213 = "213";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk214 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk213 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
            String dataLeAk215 = "215";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk216 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk215 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
            String dataLeAk217 = "217";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk218 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk217 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
            String dataLeAk219 = "219";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk220 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk219 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
            String dataLeAk221 = "221";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk222 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk221 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
                String dataLeAk223 = "223";

				public void onClick(View v) {
                    dataLeAk224 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk223 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					PrefsManager.setLoggingMode(me, true);
                }
            });
            b.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk225 = "225";

				@Override
                public boolean onLongClick(View v) {
                    dataLeAk226 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk225 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Toast.makeText(me, R.string.loggingOnHelp,
                                   Toast.LENGTH_LONG).show();
                    return true;
                }
            });
        } else
        {
            PrefsManager.setLoggingMode(me, false);
            b.setOnClickListener(new View.OnClickListener() {
                String dataLeAk227 = "227";

				public void onClick(View v) {
                    dataLeAk228 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk227 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					rg.check(R.id.radioLoggingOff);
                }
            });
            b.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk229 = "229";

				@Override
                public boolean onLongClick(View v) {
                    dataLeAk230 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk229 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Toast.makeText(me, R.string.cantLogHelp,
                                   Toast.LENGTH_LONG).show();
                    return true;
                }
            });
        }
        b = (Button)findViewById(R.id.radioLoggingOff);
        b.setOnClickListener(new View.OnClickListener() {
            String dataLeAk231 = "231";

			public void onClick(View v) {
                dataLeAk232 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk231 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				PrefsManager.setLoggingMode(me, false);
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk233 = "233";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk234 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk233 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
                String dataLeAk235 = "235";

				public void onClick(View v) {
                    dataLeAk236 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk235 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					(new File(MyLog.LogFileName())).delete();
                    Toast.makeText(me, R.string.logCleared, Toast.LENGTH_SHORT)
                         .show();
                }
            });
            b.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk237 = "237";

				@Override
                public boolean onLongClick(View v) {
                    dataLeAk238 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk237 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Toast.makeText(me, R.string.clearLogHelp,
                                   Toast.LENGTH_LONG).show();
                    return true;
                }
            });
        }
        else
        {
            b.setOnClickListener(new View.OnClickListener() {
                String dataLeAk239 = "239";

				public void onClick(View v) {
					dataLeAk240 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk239 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
                    // do nothing;
                }
            });
            b.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk241 = "241";

				@Override
                public boolean onLongClick(View v) {
                    dataLeAk242 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk241 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
                String dataLeAk243 = "243";

				public void onClick(View v) {
                    dataLeAk244 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk243 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					showLog();
                }
            });
            b.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk245 = "245";

				@Override
                public boolean onLongClick(View v) {
                    dataLeAk246 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk245 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Toast.makeText(me, R.string.showLogHelp,
                                   Toast.LENGTH_LONG).show();
                    return true;
                }
            });
        }
        else
        {
            b.setOnClickListener(new View.OnClickListener() {
                String dataLeAk247 = "247";

				public void onClick(View v) {
					dataLeAk248 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk247 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
                    // do nothing;
                }
            });
            b.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk249 = "249";

				@Override
                public boolean onLongClick(View v) {
                    dataLeAk250 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk249 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
            String dataLeAk251 = "251";

			@Override
            public void onClick(View v) {
                dataLeAk252 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk251 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
            String dataLeAk253 = "253";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk254 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk253 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
            String dataLeAk255 = "255";

			@Override
            public void onClick(View v) {
                dataLeAk256 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk255 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
            String dataLeAk257 = "257";

			public void onClick(View v) {
                dataLeAk258 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk257 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				doReset();
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk259 = "259";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk260 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk259 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Toast.makeText(me, R.string.resethelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        b = (Button)findViewById(R.id.resetbutton);
        b.setText(R.string.reset);
        b.setOnClickListener(new View.OnClickListener() {
            String dataLeAk261 = "261";

			public void onClick(View v) {
                dataLeAk262 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk261 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				doReset();
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk263 = "263";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk264 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk263 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
                String dataLeAk265 = "265";

				public void onClick(View v) {
                    dataLeAk266 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk265 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
                String dataLeAk267 = "267";

				@Override
                public boolean onLongClick(View v) {
                    dataLeAk268 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk267 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Toast.makeText(me, R.string.saveSettingsHelp,
                                   Toast.LENGTH_LONG).show();
                    return true;
                }
            });
        }
        else
        {
            b.setOnClickListener(new View.OnClickListener() {
                String dataLeAk269 = "269";

				public void onClick(View v) {
					dataLeAk270 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk269 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
                    // do nothing
                }
            });
            b.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk271 = "271";

				@Override
                public boolean onLongClick(View v) {
                    dataLeAk272 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk271 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
                String dataLeAk273 = "273";

				public void onClick(View v) {
                    dataLeAk274 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk273 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
                String dataLeAk275 = "275";

				@Override
                public boolean onLongClick(View v) {
                    dataLeAk276 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk275 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Toast.makeText(me, R.string.loadSettingsHelp,
                                   Toast.LENGTH_LONG).show();
                    return true;
                }
            });
        }
        else
        {
            b.setOnClickListener(new View.OnClickListener() {
                String dataLeAk277 = "277";

				public void onClick(View v) {
					dataLeAk278 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk277 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
                    // do nothing
                }
            });
            b.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk279 = "279";

				@Override
                public boolean onLongClick(View v) {
                    dataLeAk280 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk279 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
                    String dataLeAk281 = "281";

					@Override
                    public void onClick(View v) {
                        dataLeAk282 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						dataLeAk281 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
		android.util.Log.d("leak-203-114", dataLeAk203);
		android.util.Log.d("leak-205-114", dataLeAk205);
		android.util.Log.d("leak-207-114", dataLeAk207);
		android.util.Log.d("leak-208-114", dataLeAk208);
		android.util.Log.d("leak-210-114", dataLeAk210);
		android.util.Log.d("leak-212-114", dataLeAk212);
		android.util.Log.d("leak-214-114", dataLeAk214);
		android.util.Log.d("leak-216-114", dataLeAk216);
		android.util.Log.d("leak-218-114", dataLeAk218);
		android.util.Log.d("leak-220-114", dataLeAk220);
		android.util.Log.d("leak-222-114", dataLeAk222);
		android.util.Log.d("leak-224-114", dataLeAk224);
		android.util.Log.d("leak-226-114", dataLeAk226);
		android.util.Log.d("leak-228-114", dataLeAk228);
		android.util.Log.d("leak-230-114", dataLeAk230);
		android.util.Log.d("leak-232-114", dataLeAk232);
		android.util.Log.d("leak-234-114", dataLeAk234);
		android.util.Log.d("leak-236-114", dataLeAk236);
		android.util.Log.d("leak-238-114", dataLeAk238);
		android.util.Log.d("leak-240-114", dataLeAk240);
		android.util.Log.d("leak-242-114", dataLeAk242);
		android.util.Log.d("leak-244-114", dataLeAk244);
		android.util.Log.d("leak-246-114", dataLeAk246);
		android.util.Log.d("leak-248-114", dataLeAk248);
		android.util.Log.d("leak-250-114", dataLeAk250);
		android.util.Log.d("leak-252-114", dataLeAk252);
		android.util.Log.d("leak-254-114", dataLeAk254);
		android.util.Log.d("leak-256-114", dataLeAk256);
		android.util.Log.d("leak-258-114", dataLeAk258);
		android.util.Log.d("leak-260-114", dataLeAk260);
		android.util.Log.d("leak-262-114", dataLeAk262);
		android.util.Log.d("leak-264-114", dataLeAk264);
		android.util.Log.d("leak-266-114", dataLeAk266);
		android.util.Log.d("leak-268-114", dataLeAk268);
		android.util.Log.d("leak-270-114", dataLeAk270);
		android.util.Log.d("leak-272-114", dataLeAk272);
		android.util.Log.d("leak-274-114", dataLeAk274);
		android.util.Log.d("leak-276-114", dataLeAk276);
		android.util.Log.d("leak-278-114", dataLeAk278);
		android.util.Log.d("leak-280-114", dataLeAk280);
		android.util.Log.d("leak-282-114", dataLeAk282);
		android.util.Log.d("leak-283-114", dataLeAk283);
		android.util.Log.d("leak-284-114", dataLeAk284);
		dataLeAk283 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        if (log == null)
        {
            final SettingsActivity me = this;
            reResume();
        }
    }
    
    @Override
    public void onBackPressed() {
        dataLeAk284 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-203-115", dataLeAk203);
		android.util.Log.d("leak-205-115", dataLeAk205);
		android.util.Log.d("leak-207-115", dataLeAk207);
		android.util.Log.d("leak-208-115", dataLeAk208);
		android.util.Log.d("leak-210-115", dataLeAk210);
		android.util.Log.d("leak-212-115", dataLeAk212);
		android.util.Log.d("leak-214-115", dataLeAk214);
		android.util.Log.d("leak-216-115", dataLeAk216);
		android.util.Log.d("leak-218-115", dataLeAk218);
		android.util.Log.d("leak-220-115", dataLeAk220);
		android.util.Log.d("leak-222-115", dataLeAk222);
		android.util.Log.d("leak-224-115", dataLeAk224);
		android.util.Log.d("leak-226-115", dataLeAk226);
		android.util.Log.d("leak-228-115", dataLeAk228);
		android.util.Log.d("leak-230-115", dataLeAk230);
		android.util.Log.d("leak-232-115", dataLeAk232);
		android.util.Log.d("leak-234-115", dataLeAk234);
		android.util.Log.d("leak-236-115", dataLeAk236);
		android.util.Log.d("leak-238-115", dataLeAk238);
		android.util.Log.d("leak-240-115", dataLeAk240);
		android.util.Log.d("leak-242-115", dataLeAk242);
		android.util.Log.d("leak-244-115", dataLeAk244);
		android.util.Log.d("leak-246-115", dataLeAk246);
		android.util.Log.d("leak-248-115", dataLeAk248);
		android.util.Log.d("leak-250-115", dataLeAk250);
		android.util.Log.d("leak-252-115", dataLeAk252);
		android.util.Log.d("leak-254-115", dataLeAk254);
		android.util.Log.d("leak-256-115", dataLeAk256);
		android.util.Log.d("leak-258-115", dataLeAk258);
		android.util.Log.d("leak-260-115", dataLeAk260);
		android.util.Log.d("leak-262-115", dataLeAk262);
		android.util.Log.d("leak-264-115", dataLeAk264);
		android.util.Log.d("leak-266-115", dataLeAk266);
		android.util.Log.d("leak-268-115", dataLeAk268);
		android.util.Log.d("leak-270-115", dataLeAk270);
		android.util.Log.d("leak-272-115", dataLeAk272);
		android.util.Log.d("leak-274-115", dataLeAk274);
		android.util.Log.d("leak-276-115", dataLeAk276);
		android.util.Log.d("leak-278-115", dataLeAk278);
		android.util.Log.d("leak-280-115", dataLeAk280);
		android.util.Log.d("leak-282-115", dataLeAk282);
		android.util.Log.d("leak-283-115", dataLeAk283);
		android.util.Log.d("leak-284-115", dataLeAk284);
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
