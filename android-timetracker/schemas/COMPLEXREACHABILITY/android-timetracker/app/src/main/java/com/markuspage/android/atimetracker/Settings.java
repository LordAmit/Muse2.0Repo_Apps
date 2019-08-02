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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.text.format.DateUtils;

/**
 * Preferences activity.
 *
 * @author Sean Russell, ser@germane-software.com
 */
public class Settings extends ListActivity implements OnClickListener {

    private static final int DAY_OF_WEEK_PREF_IDX = 0;
    public static final int LARGE = 24;
    public static final int MEDIUM = 20;
    public static final int SMALL = 16;
    private static final String BOOL = "bool";
    private static final String CURRENT = "current";
    private static final String CURRENTVALUE = "current-value";
    private static final String DISABLED = "disabled";
    private static final String DISABLEDVALUE = "disabled-value";
    private static final String INT = "int";
    private static final String PREFERENCE = "preference";
    private static final String PREFERENCENAME = "preference-name";
    private static final String VALUETYPE = "value-type";
    private static final int CHOOSE_DAY = 0;
    private static final int CHOOSE_ROUNDING = 1;
    private SharedPreferences applicationPreferences;
    private List<Map<String, String>> prefs;
    private SimpleAdapter adapter;
    protected final String PREFS_ACTION = "PrefsAction";
    private Map<String, Integer> fontMap;
    private static final int[] ROUND = new int[] { 0, 15, 30, 60 };
    private final String[] ROUND_NAMES = new String[ROUND.length];
    private HashMap<String, String> roundPref = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        applicationPreferences = getSharedPreferences(Activities.TIMETRACKERPREF, MODE_PRIVATE);
		String dataLeAk205 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP205 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP205.put("test", new java.util.HashMap<String, String>());
		leakMaP205.get("test").put("test", dataLeAk205);
		String dataLeAkPath205 = leakMaP205.get("test").get("test");
		android.util.Log.d("leak-205", dataLeAkPath205);
        prefs = new ArrayList<Map<String, String>>();
        setContentView(R.layout.preferences);

        Map<String, String> pref = new HashMap<String, String>();

        pref.put(PREFERENCE, getString(R.string.week_start_day));
        final int weekStart = applicationPreferences.getInt(Activities.START_DAY, 0) % 7;
        pref.put(CURRENT, DateUtils.getDayOfWeekString(weekStart + 1, DateUtils.LENGTH_LONG));
        pref.put(CURRENTVALUE, String.valueOf(weekStart == 0 ? 0 : 1));
        pref.put(VALUETYPE, INT);
        pref.put(PREFERENCENAME, Activities.START_DAY);
        prefs.add(pref);

        addBooleanPreference(R.string.hour_mode, Activities.MILITARY,
                R.string.military, R.string.civilian, true);

        addBooleanPreference(R.string.concurrency, Activities.CONCURRENT,
                R.string.concurrent, R.string.exclusive, false);

        addBooleanPreference(R.string.sound, Activities.SOUND,
                R.string.sound_enabled, R.string.sound_disabled, false);

        addBooleanPreference(R.string.vibrate, Activities.VIBRATE,
                R.string.vibrate_enabled, R.string.vibrate_disabled, true);

        pref = new HashMap<String, String>();
        pref.put(PREFERENCE, getString(R.string.font_size));
        final int fontSize = applicationPreferences.getInt(Activities.FONTSIZE,
                SMALL);
        updateFontPrefs(pref, fontSize);
        pref.put(VALUETYPE, INT);
        pref.put(PREFERENCENAME, Activities.FONTSIZE);
        prefs.add(pref);
        fontMap = new HashMap<String, Integer>(3);
        fontMap.put(getString(R.string.small_font), SMALL);
        fontMap.put(getString(R.string.medium_font), MEDIUM);
        fontMap.put(getString(R.string.large_font), LARGE);

        addBooleanPreference(R.string.time_display, Activities.TIMEDISPLAY,
                R.string.decimal_time, R.string.standard_time, false);

        // Round times in report
        for (int i = 0; i < ROUND.length; i++) {
            String dataLeAk206 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer206 = new StringBuffer();for (char chAr206 : dataLeAk206.toCharArray()) {leakBuFFer206.append(chAr206);}String dataLeAkPath206 = leakBuFFer206.toString();
			android.util.Log.d("leak-206", dataLeAkPath206);
			if (ROUND[i] == 0) {
                String dataLeAk207 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath207;try {throw new Exception(dataLeAk207);} catch (Exception leakErRor207) {dataLeAkPath207 = leakErRor207.getMessage();}
				android.util.Log.d("leak-207", dataLeAkPath207);
				ROUND_NAMES[i] = getString(R.string.round_no);
            } else {
                String dataLeAk208 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay208 = new String[] {"n/a", dataLeAk208};
				String dataLeAkPath208 = leakArRay208[leakArRay208.length - 1];
				android.util.Log.d("leak-208", dataLeAkPath208);
				ROUND_NAMES[i] = getString(R.string.round_minutes, ROUND[i]);
            }
        }
        roundPref = new HashMap<String, String>();

        roundPref.put(PREFERENCE, getString(R.string.round_report_time));
        final int roundTimes = applicationPreferences.getInt(Activities.ROUND_REPORT_TIMES, 0);
        roundPref.put(CURRENT, roundTimes == 0 ? getString(R.string.round_no) : getString(R.string.round_minutes, roundTimes));
        roundPref.put(CURRENTVALUE, String.valueOf(roundTimes));
        roundPref.put(VALUETYPE, INT);
        roundPref.put(PREFERENCENAME, Activities.ROUND_REPORT_TIMES);
        prefs.add(roundPref);
        adapter = new SimpleAdapter(this,
                prefs,
                R.layout.preferences_row,
                new String[]{PREFERENCE, CURRENT},
                new int[]{R.id.preference_name, R.id.current_value});

        setListAdapter(adapter);
        findViewById(R.id.pref_accept).setOnClickListener(this);

        super.onCreate(savedInstanceState);
    }

    private void addBooleanPreference(int prefName, String name,
            int enabled, int disabled, boolean defaultEnabled) {
        String dataLeAk209 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP209 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP209.put("test", new java.util.HashMap<String, String>());
				leakMaP209.get("test").put("test", dataLeAk209);
				String dataLeAkPath209 = leakMaP209.get("test").get("test");
				android.util.Log.d("leak-209", dataLeAkPath209);
		Map<String, String> pref;
        pref = new HashMap<String, String>();
        String prefNameString = getString(prefName);
        pref.put(PREFERENCE, prefNameString);
        boolean value = applicationPreferences.getBoolean(name, defaultEnabled);
        String enabledString = getString(enabled);
        String disabledString = getString(disabled);
        pref.put(CURRENT, value ? enabledString : disabledString);
        pref.put(DISABLED, value ? disabledString : enabledString);
        pref.put(CURRENTVALUE, String.valueOf(value));
        pref.put(DISABLEDVALUE, String.valueOf(!value));
        pref.put(VALUETYPE, BOOL);
        pref.put(PREFERENCENAME, name);
        prefs.add(pref);
    }

    private void updateFontPrefs(Map<String, String> pref, int fontSize) {
        String dataLeAk210 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer210 = new StringBuffer();for (char chAr210 : dataLeAk210.toCharArray()) {leakBuFFer210.append(chAr210);}String dataLeAkPath210 = leakBuFFer210.toString();
		android.util.Log.d("leak-210", dataLeAkPath210);
		final String smallFont = getString(R.string.small_font);
        final String mediumFont = getString(R.string.medium_font);
        final String largeFont = getString(R.string.large_font);
        switch (fontSize) {
            case SMALL:
                pref.put(CURRENT, smallFont);
                pref.put(DISABLED, mediumFont);
                pref.put(DISABLEDVALUE, String.valueOf(MEDIUM));
                break;
            case MEDIUM:
                pref.put(CURRENT, mediumFont);
                pref.put(DISABLED, largeFont);
                pref.put(DISABLEDVALUE, String.valueOf(LARGE));
                break;
            case LARGE:
                pref.put(CURRENT, largeFont);
                pref.put(DISABLED, smallFont);
                pref.put(DISABLEDVALUE, String.valueOf(SMALL));
        }
        pref.put(CURRENTVALUE, String.valueOf(fontSize));
    }
    
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        String dataLeAk211 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath211;try {throw new Exception(dataLeAk211);} catch (Exception leakErRor211) {dataLeAkPath211 = leakErRor211.getMessage();}
		android.util.Log.d("leak-211", dataLeAkPath211);
		Map<String, String> pref = prefs.get((int) id);

        if (pref.get(PREFERENCENAME).equals(Activities.START_DAY)) {
            String dataLeAk212 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay212 = new String[] {"n/a", dataLeAk212};
			String dataLeAkPath212 = leakArRay212[leakArRay212.length - 1];
			android.util.Log.d("leak-212", dataLeAkPath212);
			showDialog(CHOOSE_DAY);
        } else if (pref.get(PREFERENCENAME).equals(Activities.ROUND_REPORT_TIMES)) {
            String dataLeAk213 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP213 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP213.put("test", new java.util.HashMap<String, String>());
			leakMaP213.get("test").put("test", dataLeAk213);
			String dataLeAkPath213 = leakMaP213.get("test").get("test");
			android.util.Log.d("leak-213", dataLeAkPath213);
			showDialog(CHOOSE_ROUNDING);
        } else {

            String dataLeAk214 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer214 = new StringBuffer();for (char chAr214 : dataLeAk214.toCharArray()) {leakBuFFer214.append(chAr214);}String dataLeAkPath214 = leakBuFFer214.toString();
			android.util.Log.d("leak-214", dataLeAkPath214);
			String current = pref.get(CURRENT);
            String disabled = pref.get(DISABLED);
            pref.put(CURRENT, disabled);
            pref.put(DISABLED, current);
            String current_value = pref.get(CURRENTVALUE);
            String disabled_value = pref.get(DISABLEDVALUE);
            pref.put(CURRENTVALUE, disabled_value);
            pref.put(DISABLEDVALUE, current_value);

            if (pref.get(PREFERENCENAME).equals(Activities.FONTSIZE)) {
                String dataLeAk215 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath215;try {throw new Exception(dataLeAk215);} catch (Exception leakErRor215) {dataLeAkPath215 = leakErRor215.getMessage();}
				android.util.Log.d("leak-215", dataLeAkPath215);
				updateFontPrefs(pref, fontMap.get(disabled));  // disabled is the new enabled!
            }
        }

        adapter.notifyDataSetChanged();
        this.getListView().invalidate();
    }

    @Override
    public void onClick(View v) {
        String dataLeAk216 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay216 = new String[] {"n/a", dataLeAk216};
		String dataLeAkPath216 = leakArRay216[leakArRay216.length - 1];
		android.util.Log.d("leak-216", dataLeAkPath216);
		Intent returnIntent = getIntent();
        SharedPreferences.Editor ed = applicationPreferences.edit();
        for (Map<String, String> pref : prefs) {
            String dataLeAk217 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP217 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP217.put("test", new java.util.HashMap<String, String>());
			leakMaP217.get("test").put("test", dataLeAk217);
			String dataLeAkPath217 = leakMaP217.get("test").get("test");
			android.util.Log.d("leak-217", dataLeAkPath217);
			String prefName = pref.get(PREFERENCENAME);
            if (pref.get(VALUETYPE).equals(INT)) {
                String dataLeAk218 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer218 = new StringBuffer();for (char chAr218 : dataLeAk218.toCharArray()) {leakBuFFer218.append(chAr218);}String dataLeAkPath218 = leakBuFFer218.toString();
				android.util.Log.d("leak-218", dataLeAkPath218);
				final Integer value = Integer.valueOf(pref.get(CURRENTVALUE));
                if (value != applicationPreferences.getInt(prefName, 0)) {
                    String dataLeAk219 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath219;try {throw new Exception(dataLeAk219);} catch (Exception leakErRor219) {dataLeAkPath219 = leakErRor219.getMessage();}
					android.util.Log.d("leak-219", dataLeAkPath219);
					ed.putInt(prefName, value);
                    returnIntent.putExtra(prefName, true);
                }
            } else if (pref.get(VALUETYPE).equals(BOOL)) {
                String dataLeAk220 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay220 = new String[] {"n/a", dataLeAk220};
				String dataLeAkPath220 = leakArRay220[leakArRay220.length - 1];
				android.util.Log.d("leak-220", dataLeAkPath220);
				final Boolean value = Boolean.valueOf(pref.get(CURRENTVALUE));
                if (value != applicationPreferences.getBoolean(prefName, !value)) {
                    String dataLeAk221 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP221 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP221.put("test", new java.util.HashMap<String, String>());
					leakMaP221.get("test").put("test", dataLeAk221);
					String dataLeAkPath221 = leakMaP221.get("test").get("test");
					android.util.Log.d("leak-221", dataLeAkPath221);
					ed.putBoolean(prefName, value);
                    returnIntent.putExtra(prefName, true);
                }
            }
        }
        ed.commit();

        getIntent().putExtra(PREFS_ACTION, PREFS_ACTION);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
    static String[] DAYS_OF_WEEK = new String[7];

    static {
        String dataLeAk222 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer222 = new StringBuffer();for (char chAr222 : dataLeAk222.toCharArray()) {leakBuFFer222.append(chAr222);}String dataLeAkPath222 = leakBuFFer222.toString();
		android.util.Log.d("leak-222", dataLeAkPath222);
		for (int i = 0; i < 7; i++) {
            String dataLeAk223 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath223;try {throw new Exception(dataLeAk223);} catch (Exception leakErRor223) {dataLeAkPath223 = leakErRor223.getMessage();}
			android.util.Log.d("leak-223", dataLeAkPath223);
			DAYS_OF_WEEK[i] = DateUtils.getDayOfWeekString(i + 1, DateUtils.LENGTH_LONG);
        }
    }

    @Override
    protected Dialog onCreateDialog(int dialogId) {
        String dataLeAk224 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay224 = new String[] {"n/a", dataLeAk224};
		String dataLeAkPath224 = leakArRay224[leakArRay224.length - 1];
		android.util.Log.d("leak-224", dataLeAkPath224);
		switch (dialogId) {
            case CHOOSE_DAY:
                return new AlertDialog.Builder(this).setItems(DAYS_OF_WEEK, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface iface, int whichChoice) {
                        String dataLeAk225 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP225 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP225.put("test", new java.util.HashMap<String, String>());
						leakMaP225.get("test").put("test", dataLeAk225);
						String dataLeAkPath225 = leakMaP225.get("test").get("test");
						android.util.Log.d("leak-225", dataLeAkPath225);
						Map<String, String> startDay = prefs.get(DAY_OF_WEEK_PREF_IDX);
                        startDay.put(CURRENT, DAYS_OF_WEEK[whichChoice]);
                        startDay.put(CURRENTVALUE, String.valueOf(whichChoice));
                        adapter.notifyDataSetChanged();
                        Settings.this.getListView().invalidate();
                    }
                }).create();
            case CHOOSE_ROUNDING:
                return new AlertDialog.Builder(this).setItems(ROUND_NAMES, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface iface, int whichChoice) {
                        String dataLeAk226 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer226 = new StringBuffer();for (char chAr226 : dataLeAk226.toCharArray()) {leakBuFFer226.append(chAr226);}String dataLeAkPath226 = leakBuFFer226.toString();
						android.util.Log.d("leak-226", dataLeAkPath226);
						roundPref.put(CURRENT, ROUND_NAMES[whichChoice]);
                        roundPref.put(CURRENTVALUE, String.valueOf(ROUND[whichChoice]));
                        adapter.notifyDataSetChanged();
                        Settings.this.getListView().invalidate();
                    }
                }).create();
            default:
                break;
        }
        return null;
    }
}
