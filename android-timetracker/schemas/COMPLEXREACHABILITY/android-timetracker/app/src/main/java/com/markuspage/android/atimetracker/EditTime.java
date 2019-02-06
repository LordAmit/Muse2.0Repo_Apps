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

import static com.markuspage.android.atimetracker.TimeRange.NULL;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.TimePicker;

/**
 * Activity for editing a time.
 *
 * @author Sean Russell, ser@germane-software.com
 */
public class EditTime extends Activity implements OnClickListener {

    protected static final String END_DATE = "end-date";
    protected static final String START_DATE = "start-date";
    protected static final String CLEAR = "clear";
    private boolean editingRunning = false;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk366 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer366 = new StringBuffer();for (char chAr366 : dataLeAk366.toCharArray()) {leakBuFFer366.append(chAr366);}String dataLeAkPath366 = leakBuFFer366.toString();
		android.util.Log.d("leak-366", dataLeAkPath366);
        preferences = getSharedPreferences(Activities.TIMETRACKERPREF, MODE_PRIVATE);
        if (getIntent().getExtras().getLong(END_DATE) == NULL) {
            String dataLeAk367 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath367;try {throw new Exception(dataLeAk367);} catch (Exception leakErRor367) {dataLeAkPath367 = leakErRor367.getMessage();}
			android.util.Log.d("leak-367", dataLeAkPath367);
			setContentView(R.layout.edit_running_time_range);
            editingRunning = true;
        } else {
            String dataLeAk368 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay368 = new String[] {"n/a", dataLeAk368};
			String dataLeAkPath368 = leakArRay368[leakArRay368.length - 1];
			android.util.Log.d("leak-368", dataLeAkPath368);
			setContentView(R.layout.edit_time_range);
        }
        findViewById(R.id.accept).setOnClickListener(this);
        findViewById(R.id.time_edit_cancel).setOnClickListener(this);
        TimePicker startTime = (TimePicker) findViewById(R.id.start_time);
        TimePicker endTime = (TimePicker) findViewById(R.id.end_time);
        boolean militaryTime = preferences.getBoolean(Activities.MILITARY, false);
        startTime.setIs24HourView(militaryTime);
        if (endTime != null) {
            String dataLeAk369 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP369 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP369.put("test", new java.util.HashMap<String, String>());
			leakMaP369.get("test").put("test", dataLeAk369);
			String dataLeAkPath369 = leakMaP369.get("test").get("test");
			android.util.Log.d("leak-369", dataLeAkPath369);
			endTime.setIs24HourView(militaryTime);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
		String dataLeAk370 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer370 = new StringBuffer();for (char chAr370 : dataLeAk370.toCharArray()) {leakBuFFer370.append(chAr370);}String dataLeAkPath370 = leakBuFFer370.toString();
		android.util.Log.d("leak-370", dataLeAkPath370);
        DatePicker startDate = (DatePicker) findViewById(R.id.start_date);
        TimePicker startTime = (TimePicker) findViewById(R.id.start_time);

        Calendar sd = Calendar.getInstance();
        sd.setFirstDayOfWeek(Calendar.MONDAY);
        if (!getIntent().getExtras().getBoolean(CLEAR)) {
            String dataLeAk371 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath371;try {throw new Exception(dataLeAk371);} catch (Exception leakErRor371) {dataLeAkPath371 = leakErRor371.getMessage();}
			android.util.Log.d("leak-371", dataLeAkPath371);
			sd.setTimeInMillis(getIntent().getExtras().getLong(START_DATE));
        }
        startDate.updateDate(sd.get(Calendar.YEAR), sd.get(Calendar.MONTH),
                sd.get(Calendar.DAY_OF_MONTH));
        startTime.setCurrentHour(sd.get(Calendar.HOUR_OF_DAY));
        startTime.setCurrentMinute(sd.get(Calendar.MINUTE));

        if (!editingRunning) {
            String dataLeAk372 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay372 = new String[] {"n/a", dataLeAk372};
			String dataLeAkPath372 = leakArRay372[leakArRay372.length - 1];
			android.util.Log.d("leak-372", dataLeAkPath372);
			DatePicker endDate = (DatePicker) findViewById(R.id.end_date);
            TimePicker endTime = (TimePicker) findViewById(R.id.end_time);
            Calendar ed = Calendar.getInstance();
            ed.setFirstDayOfWeek(Calendar.MONDAY);
            if (getIntent().getExtras().getBoolean(CLEAR)) {
                String dataLeAk373 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP373 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP373.put("test", new java.util.HashMap<String, String>());
				leakMaP373.get("test").put("test", dataLeAk373);
				String dataLeAkPath373 = leakMaP373.get("test").get("test");
				android.util.Log.d("leak-373", dataLeAkPath373);
				ed = sd;
            } else {
                String dataLeAk374 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer374 = new StringBuffer();for (char chAr374 : dataLeAk374.toCharArray()) {leakBuFFer374.append(chAr374);}String dataLeAkPath374 = leakBuFFer374.toString();
				android.util.Log.d("leak-374", dataLeAkPath374);
				ed.setTimeInMillis(getIntent().getExtras().getLong(END_DATE));
            }
            endDate.updateDate(ed.get(Calendar.YEAR), ed.get(Calendar.MONTH),
                    ed.get(Calendar.DAY_OF_MONTH));
            endTime.setCurrentHour(ed.get(Calendar.HOUR_OF_DAY));
            endTime.setCurrentMinute(ed.get(Calendar.MINUTE));
        }
    }

    @Override
    public void onClick(View v) {
        String dataLeAk375 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath375;try {throw new Exception(dataLeAk375);} catch (Exception leakErRor375) {dataLeAkPath375 = leakErRor375.getMessage();}
		android.util.Log.d("leak-375", dataLeAkPath375);
		DatePicker startDate = (DatePicker) findViewById(R.id.start_date);
        TimePicker startTime = (TimePicker) findViewById(R.id.start_time);
        Calendar s = Calendar.getInstance();
        s.setFirstDayOfWeek(Calendar.MONDAY);
        s.set(startDate.getYear(), startDate.getMonth(), startDate.getDayOfMonth(),
                startTime.getCurrentHour(), startTime.getCurrentMinute());
        getIntent().putExtra(START_DATE, s.getTime().getTime());

        if (!editingRunning) {
            String dataLeAk376 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay376 = new String[] {"n/a", dataLeAk376};
			String dataLeAkPath376 = leakArRay376[leakArRay376.length - 1];
			android.util.Log.d("leak-376", dataLeAkPath376);
			DatePicker endDate = (DatePicker) findViewById(R.id.end_date);
            TimePicker endTime = (TimePicker) findViewById(R.id.end_time);
            Calendar e = Calendar.getInstance();
            e.setFirstDayOfWeek(Calendar.MONDAY);
            e.set(endDate.getYear(), endDate.getMonth(), endDate.getDayOfMonth(),
                    endTime.getCurrentHour(), endTime.getCurrentMinute());
            if (e.compareTo(s) < 1) {
                String dataLeAk377 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP377 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP377.put("test", new java.util.HashMap<String, String>());
				leakMaP377.get("test").put("test", dataLeAk377);
				String dataLeAkPath377 = leakMaP377.get("test").get("test");
				android.util.Log.d("leak-377", dataLeAkPath377);
				showDialog(0);
                return;
            }
            getIntent().putExtra(END_DATE, e.getTime().getTime());
        }

        setResult(Activity.RESULT_OK, getIntent());
        finish();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        String dataLeAk378 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer378 = new StringBuffer();for (char chAr378 : dataLeAk378.toCharArray()) {leakBuFFer378.append(chAr378);}String dataLeAkPath378 = leakBuFFer378.toString();
		android.util.Log.d("leak-378", dataLeAkPath378);
		return new AlertDialog.Builder(this)
                .setTitle(R.string.range_error_title)
                .setIcon(android.R.drawable.stat_sys_warning)
                .setCancelable(true)
                .setMessage(R.string.end_not_greater_than_start)
                .setPositiveButton(android.R.string.ok, null)
                .create();
    }
}
