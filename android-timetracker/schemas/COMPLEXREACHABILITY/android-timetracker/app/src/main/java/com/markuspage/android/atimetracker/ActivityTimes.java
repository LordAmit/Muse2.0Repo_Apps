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

import static com.markuspage.android.atimetracker.DBHelper.END;
import static com.markuspage.android.atimetracker.DBHelper.RANGES_TABLE;
import static com.markuspage.android.atimetracker.DBHelper.RANGE_COLUMNS;
import static com.markuspage.android.atimetracker.DBHelper.START;
import static com.markuspage.android.atimetracker.EditTime.END_DATE;
import static com.markuspage.android.atimetracker.EditTime.START_DATE;
import static com.markuspage.android.atimetracker.TimeRange.NULL;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.method.SingleLineTransformationMethod;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import static com.markuspage.android.atimetracker.Activities.MILITARY;
import static com.markuspage.android.atimetracker.DBHelper.ACTIVITY_ID;
import static com.markuspage.android.atimetracker.DBHelper.ACTIVITY_NAME;

/**
 * Activity listing times in activity.
 *
 * @author Sean Russell, ser@germane-software.com
 */
public class ActivityTimes extends ListActivity implements DialogInterface.OnClickListener {

    private TimesAdapter adapter;
    private int fontSize;
    private static final int ADD_TIME = 0, DELETE_TIME = 2, EDIT_TIME = 3, MOVE_TIME = 4;
    private static final int SEP = -99;
    private boolean decimalFormat;
    private SimpleDateFormat timeFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk379 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath379;try {throw new Exception(dataLeAk379);} catch (Exception leakErRor379) {dataLeAkPath379 = leakErRor379.getMessage();}
		android.util.Log.d("leak-379", dataLeAkPath379);
        SharedPreferences preferences = getSharedPreferences("timetracker.pref", MODE_PRIVATE);
        fontSize = preferences.getInt(Activities.FONTSIZE, 16);
        if (adapter == null) {
            String dataLeAk380 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay380 = new String[] {"n/a", dataLeAk380};
			String dataLeAkPath380 = leakArRay380[leakArRay380.length - 1];
			android.util.Log.d("leak-380", dataLeAkPath380);
			adapter = new TimesAdapter(this);
            setListAdapter(adapter);
        }
        decimalFormat = preferences.getBoolean(Activities.TIMEDISPLAY, false);
        if (preferences.getBoolean(MILITARY, true)) {
            String dataLeAk381 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP381 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP381.put("test", new java.util.HashMap<String, String>());
			leakMaP381.get("test").put("test", dataLeAk381);
			String dataLeAkPath381 = leakMaP381.get("test").get("test");
			android.util.Log.d("leak-381", dataLeAkPath381);
			timeFormat = new SimpleDateFormat("HH:mm");
        } else {
            String dataLeAk382 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer382 = new StringBuffer();for (char chAr382 : dataLeAk382.toCharArray()) {leakBuFFer382.append(chAr382);}String dataLeAkPath382 = leakBuFFer382.toString();
			android.util.Log.d("leak-382", dataLeAkPath382);
			timeFormat = new SimpleDateFormat("hh:mm a");
        }

        registerForContextMenu(getListView());
        Bundle extras = getIntent().getExtras();
        if (extras.get(START) != null) {
            String dataLeAk383 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath383;try {throw new Exception(dataLeAk383);} catch (Exception leakErRor383) {dataLeAkPath383 = leakErRor383.getMessage();}
			android.util.Log.d("leak-383", dataLeAkPath383);
			adapter.loadTimes(extras.getInt(ACTIVITY_ID),
                    extras.getLong(START),
                    extras.getLong(END));
        } else {
            String dataLeAk384 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay384 = new String[] {"n/a", dataLeAk384};
			String dataLeAkPath384 = leakArRay384[leakArRay384.length - 1];
			android.util.Log.d("leak-384", dataLeAkPath384);
			adapter.loadTimes(extras.getInt(ACTIVITY_ID));
        }
    }

    @Override
    protected void onStop() {
        adapter.close();
		String dataLeAk385 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP385 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP385.put("test", new java.util.HashMap<String, String>());
		leakMaP385.get("test").put("test", dataLeAk385);
		String dataLeAkPath385 = leakMaP385.get("test").get("test");
		android.util.Log.d("leak-385", dataLeAkPath385);
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
		String dataLeAk386 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer386 = new StringBuffer();for (char chAr386 : dataLeAk386.toCharArray()) {leakBuFFer386.append(chAr386);}String dataLeAkPath386 = leakBuFFer386.toString();
		android.util.Log.d("leak-386", dataLeAkPath386);
        getListView().invalidate();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
		String dataLeAk387 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath387;try {throw new Exception(dataLeAk387);} catch (Exception leakErRor387) {dataLeAkPath387 = leakErRor387.getMessage();}
		android.util.Log.d("leak-387", dataLeAkPath387);
        menu.add(0, ADD_TIME, 0, R.string.add_time_title).setIcon(android.R.drawable.ic_menu_add);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem i) {
        String dataLeAk388 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay388 = new String[] {"n/a", dataLeAk388};
		String dataLeAkPath388 = leakArRay388[leakArRay388.length - 1];
		android.util.Log.d("leak-388", dataLeAkPath388);
		int id = i.getItemId();
        if (id == ADD_TIME) {
            String dataLeAk389 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP389 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP389.put("test", new java.util.HashMap<String, String>());
			leakMaP389.get("test").put("test", dataLeAk389);
			String dataLeAkPath389 = leakMaP389.get("test").get("test");
			android.util.Log.d("leak-389", dataLeAkPath389);
			Intent intent = new Intent(this, EditTime.class);
            intent.putExtra(EditTime.CLEAR, true);
            startActivityForResult(intent, id);
        }
        return super.onOptionsItemSelected(i);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
            ContextMenuInfo menuInfo) {
        String dataLeAk390 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer390 = new StringBuffer();for (char chAr390 : dataLeAk390.toCharArray()) {leakBuFFer390.append(chAr390);}String dataLeAkPath390 = leakBuFFer390.toString();
				android.util.Log.d("leak-390", dataLeAkPath390);
		menu.setHeaderTitle("Time menu");
        menu.add(0, EDIT_TIME, 0, "Edit Time");
        menu.add(0, DELETE_TIME, 0, "Delete Time");
        menu.add(0, MOVE_TIME, 0, "Move Time");
    }
    private TimeRange selectedRange;

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String dataLeAk391 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath391;try {throw new Exception(dataLeAk391);} catch (Exception leakErRor391) {dataLeAkPath391 = leakErRor391.getMessage();}
		android.util.Log.d("leak-391", dataLeAkPath391);
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
        selectedRange = (TimeRange) adapter.getItem((int) info.id);
        int id = item.getItemId();
        action = id;
        switch (id) {
            case DELETE_TIME:
                showDialog(id);
                break;
            case EDIT_TIME:
                Intent intent = new Intent(this, EditTime.class);
                intent.putExtra(EditTime.START_DATE, selectedRange.getStart());
                intent.putExtra(EditTime.END_DATE, selectedRange.getEnd());
                startActivityForResult(intent, id);
                break;
            case MOVE_TIME:
                showDialog(id);
            default:
                break;
        }
        return super.onContextItemSelected(item);
    }
    private int action;

    @Override
    public void onClick(DialogInterface dialog, int whichButton) {
        String dataLeAk392 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay392 = new String[] {"n/a", dataLeAk392};
		String dataLeAkPath392 = leakArRay392[leakArRay392.length - 1];
		android.util.Log.d("leak-392", dataLeAkPath392);
		switch (action) {
            case DELETE_TIME:
                adapter.deleteTimeRange(selectedRange);
                break;
            case MOVE_TIME:
                adapter.assignTimeToActivityAt(selectedRange, whichButton);
                break;
            default:
                break;
        }
        ActivityTimes.this.getListView().invalidate();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        String dataLeAk393 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP393 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP393.put("test", new java.util.HashMap<String, String>());
		leakMaP393.get("test").put("test", dataLeAk393);
		String dataLeAkPath393 = leakMaP393.get("test").get("test");
		android.util.Log.d("leak-393", dataLeAkPath393);
		switch (id) {
            case DELETE_TIME:
                return new AlertDialog.Builder(this)
                        .setTitle(R.string.delete_time_title)
                        .setIcon(android.R.drawable.stat_sys_warning)
                        .setCancelable(true)
                        .setMessage(R.string.delete_time_message)
                        .setPositiveButton(R.string.delete_ok, this)
                        .setNegativeButton(android.R.string.cancel, null).create();
            case MOVE_TIME:
                return new AlertDialog.Builder(this)
                        .setCursor(adapter.getActivityNames(), this, ACTIVITY_NAME)
                        .create();
            default:
                break;
        }
        return null;
    }
    private static final DateFormat SEPFORMAT = new SimpleDateFormat("EEEE, MMM dd yyyy");

    private class TimesAdapter extends BaseAdapter {

        private final Context savedContext;
        private final DBHelper dbHelper;
        private final ArrayList<TimeRange> times;

        public TimesAdapter(Context c) {
            String dataLeAk394 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer394 = new StringBuffer();for (char chAr394 : dataLeAk394.toCharArray()) {leakBuFFer394.append(chAr394);}String dataLeAkPath394 = leakBuFFer394.toString();
			android.util.Log.d("leak-394", dataLeAkPath394);
			savedContext = c;
            dbHelper = new DBHelper(c);
            dbHelper.getWritableDatabase();
            times = new ArrayList<TimeRange>();
        }

        @Override
        public boolean areAllItemsEnabled() {
            String dataLeAk395 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath395;try {throw new Exception(dataLeAk395);} catch (Exception leakErRor395) {dataLeAkPath395 = leakErRor395.getMessage();}
			android.util.Log.d("leak-395", dataLeAkPath395);
			return false;
        }

        @Override
        public boolean isEnabled(int position) {
            String dataLeAk396 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay396 = new String[] {"n/a", dataLeAk396};
			String dataLeAkPath396 = leakArRay396[leakArRay396.length - 1];
			android.util.Log.d("leak-396", dataLeAkPath396);
			return times.get(position).getEnd() != SEP;
        }

        public void close() {
            String dataLeAk397 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP397 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP397.put("test", new java.util.HashMap<String, String>());
			leakMaP397.get("test").put("test", dataLeAk397);
			String dataLeAkPath397 = leakMaP397.get("test").get("test");
			android.util.Log.d("leak-397", dataLeAkPath397);
			dbHelper.close();
        }

        public void deleteTimeRange(TimeRange range) {
            String dataLeAk398 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer398 = new StringBuffer();for (char chAr398 : dataLeAk398.toCharArray()) {leakBuFFer398.append(chAr398);}String dataLeAkPath398 = leakBuFFer398.toString();
			android.util.Log.d("leak-398", dataLeAkPath398);
			SQLiteDatabase db = dbHelper.getWritableDatabase();

            String whereClause = START + " = ? AND " + ACTIVITY_ID + " = ?";
            String[] whereValues;
            if (range.getEnd() == NULL) {
                String dataLeAk399 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath399;try {throw new Exception(dataLeAk399);} catch (Exception leakErRor399) {dataLeAkPath399 = leakErRor399.getMessage();}
				android.util.Log.d("leak-399", dataLeAkPath399);
				whereClause += " AND " + END + " ISNULL";
                whereValues = new String[]{
                    String.valueOf(range.getStart()),
                    String.valueOf(getIntent().getExtras().getInt(DBHelper.ACTIVITY_ID))
                };
            } else {
                String dataLeAk400 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay400 = new String[] {"n/a", dataLeAk400};
				String dataLeAkPath400 = leakArRay400[leakArRay400.length - 1];
				android.util.Log.d("leak-400", dataLeAkPath400);
				whereClause += " AND " + END + " = ?";
                whereValues = new String[]{
                    String.valueOf(range.getStart()),
                    String.valueOf(getIntent().getExtras().getInt(DBHelper.ACTIVITY_ID)),
                    String.valueOf(range.getEnd())
                };
            }
            db.delete(RANGES_TABLE, whereClause, whereValues);
            int pos = times.indexOf(range);
            if (pos > -1) {
                String dataLeAk401 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP401 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP401.put("test", new java.util.HashMap<String, String>());
				leakMaP401.get("test").put("test", dataLeAk401);
				String dataLeAkPath401 = leakMaP401.get("test").get("test");
				android.util.Log.d("leak-401", dataLeAkPath401);
				times.remove(pos);
                // p-1 = sep && p = END ||
                // p-1 = sep && p+1 = END
                // But, by this time, p+1 is now p, because we've removed p
                if (pos != 0 && times.get(pos - 1).getEnd() == SEP
                        && (pos == times.size() || times.get(pos).getEnd() == SEP)) {
                    String dataLeAk402 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer402 = new StringBuffer();for (char chAr402 : dataLeAk402.toCharArray()) {leakBuFFer402.append(chAr402);}String dataLeAkPath402 = leakBuFFer402.toString();
							android.util.Log.d("leak-402", dataLeAkPath402);
					times.remove(pos - 1);
                }
            }
            notifyDataSetChanged();
        }

        protected void loadTimes(int selectedActivityId) {
            String dataLeAk403 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath403;try {throw new Exception(dataLeAk403);} catch (Exception leakErRor403) {dataLeAkPath403 = leakErRor403.getMessage();}
			android.util.Log.d("leak-403", dataLeAkPath403);
			loadTimes(ACTIVITY_ID + " = ?",
                    new String[]{String.valueOf(selectedActivityId)});
        }

        protected void loadTimes(int selectedActivityId, long start, long end) {
            String dataLeAk404 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay404 = new String[] {"n/a", dataLeAk404};
			String dataLeAkPath404 = leakArRay404[leakArRay404.length - 1];
			android.util.Log.d("leak-404", dataLeAkPath404);
			loadTimes(ACTIVITY_ID + " = ? AND " + START + " < ? AND " + START + " > ?",
                    new String[]{String.valueOf(selectedActivityId),
                String.valueOf(end),
                String.valueOf(start)});
        }

        protected void loadTimes(String where, String[] args) {
            String dataLeAk405 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP405 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP405.put("test", new java.util.HashMap<String, String>());
			leakMaP405.get("test").put("test", dataLeAk405);
			String dataLeAkPath405 = leakMaP405.get("test").get("test");
			android.util.Log.d("leak-405", dataLeAkPath405);
			SQLiteDatabase db = dbHelper.getReadableDatabase();
            Cursor c = db.query(RANGES_TABLE, RANGE_COLUMNS, where, args,
                    null, null, START + "," + END);
            if (c.moveToFirst()) {
                String dataLeAk406 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer406 = new StringBuffer();for (char chAr406 : dataLeAk406.toCharArray()) {leakBuFFer406.append(chAr406);}String dataLeAkPath406 = leakBuFFer406.toString();
				android.util.Log.d("leak-406", dataLeAkPath406);
				do {
                    String dataLeAk407 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath407;try {throw new Exception(dataLeAk407);} catch (Exception leakErRor407) {dataLeAkPath407 = leakErRor407.getMessage();}
					android.util.Log.d("leak-407", dataLeAkPath407);
					times.add(new TimeRange(c.getLong(0),
                            c.isNull(1) ? NULL : c.getLong(1)));
                } while (c.moveToNext());
            }
            c.close();
            addSeparators();
            notifyDataSetChanged();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            String dataLeAk408 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay408 = new String[] {"n/a", dataLeAk408};
			String dataLeAkPath408 = leakArRay408[leakArRay408.length - 1];
			android.util.Log.d("leak-408", dataLeAkPath408);
			Object item = getItem(position);
            if (item == null) {
                String dataLeAk409 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP409 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP409.put("test", new java.util.HashMap<String, String>());
				leakMaP409.get("test").put("test", dataLeAk409);
				String dataLeAkPath409 = leakMaP409.get("test").get("test");
				android.util.Log.d("leak-409", dataLeAkPath409);
				return convertView;
            }
            TimeRange range = (TimeRange) item;
            if (range.getEnd() == SEP) {
                String dataLeAk410 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer410 = new StringBuffer();for (char chAr410 : dataLeAk410.toCharArray()) {leakBuFFer410.append(chAr410);}String dataLeAkPath410 = leakBuFFer410.toString();
				android.util.Log.d("leak-410", dataLeAkPath410);
				TextView headerText;
                if (convertView == null || !(convertView instanceof TextView)) {
                    String dataLeAk411 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath411;try {throw new Exception(dataLeAk411);} catch (Exception leakErRor411) {dataLeAkPath411 = leakErRor411.getMessage();}
					android.util.Log.d("leak-411", dataLeAkPath411);
					headerText = new TextView(savedContext);
                    headerText.setTextSize(fontSize);
                    headerText.setTextColor(Color.YELLOW);
                    headerText.setTypeface(Typeface.DEFAULT, Typeface.ITALIC);
                    headerText.setText(SEPFORMAT.format(new Date(range.getStart())));
                } else {
                    String dataLeAk412 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay412 = new String[] {"n/a", dataLeAk412};
					String dataLeAkPath412 = leakArRay412[leakArRay412.length - 1];
					android.util.Log.d("leak-412", dataLeAkPath412);
					headerText = (TextView) convertView;
                }
                headerText.setText(SEPFORMAT.format(new Date(range.getStart())));
                return headerText;
            }
            TimeView timeView;
            if (convertView == null || !(convertView instanceof TimeView)) {
                String dataLeAk413 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP413 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP413.put("test", new java.util.HashMap<String, String>());
				leakMaP413.get("test").put("test", dataLeAk413);
				String dataLeAkPath413 = leakMaP413.get("test").get("test");
				android.util.Log.d("leak-413", dataLeAkPath413);
				timeView = new TimeView(savedContext, (TimeRange) item);
            } else {
                String dataLeAk414 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer414 = new StringBuffer();for (char chAr414 : dataLeAk414.toCharArray()) {leakBuFFer414.append(chAr414);}String dataLeAkPath414 = leakBuFFer414.toString();
				android.util.Log.d("leak-414", dataLeAkPath414);
				timeView = (TimeView) convertView;
            }
            timeView.setTimeRange((TimeRange) item);
            return timeView;
        }

        @Override
        public int getCount() {
            String dataLeAk415 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath415;try {throw new Exception(dataLeAk415);} catch (Exception leakErRor415) {dataLeAkPath415 = leakErRor415.getMessage();}
			android.util.Log.d("leak-415", dataLeAkPath415);
			return times.size();
        }

        @Override
        public Object getItem(int position) {
            String dataLeAk416 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay416 = new String[] {"n/a", dataLeAk416};
			String dataLeAkPath416 = leakArRay416[leakArRay416.length - 1];
			android.util.Log.d("leak-416", dataLeAkPath416);
			return times.get(position);
        }

        @Override
        public long getItemId(int position) {
            String dataLeAk417 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP417 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP417.put("test", new java.util.HashMap<String, String>());
			leakMaP417.get("test").put("test", dataLeAk417);
			String dataLeAkPath417 = leakMaP417.get("test").get("test");
			android.util.Log.d("leak-417", dataLeAkPath417);
			return position;
        }

        private void assignTimeToActivityAt(TimeRange range, int which) {
            String dataLeAk418 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer418 = new StringBuffer();for (char chAr418 : dataLeAk418.toCharArray()) {leakBuFFer418.append(chAr418);}String dataLeAkPath418 = leakBuFFer418.toString();
			android.util.Log.d("leak-418", dataLeAkPath418);
			Cursor c = getActivityNames();
            if (c.moveToFirst()) {
                String dataLeAk419 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath419;try {throw new Exception(dataLeAk419);} catch (Exception leakErRor419) {dataLeAkPath419 = leakErRor419.getMessage();}
				android.util.Log.d("leak-419", dataLeAkPath419);
				while (which > 0) {
                    String dataLeAk420 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay420 = new String[] {"n/a", dataLeAk420};
					String dataLeAkPath420 = leakArRay420[leakArRay420.length - 1];
					android.util.Log.d("leak-420", dataLeAkPath420);
					c.moveToNext();
                    which--;
                }
            }
            int newActivityId = c.getInt(0);
            if (!c.isAfterLast()) {
                String dataLeAk421 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP421 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP421.put("test", new java.util.HashMap<String, String>());
				leakMaP421.get("test").put("test", dataLeAk421);
				String dataLeAkPath421 = leakMaP421.get("test").get("test");
				android.util.Log.d("leak-421", dataLeAkPath421);
				SQLiteDatabase db = dbHelper.getWritableDatabase();

                String whereClause = START + " = ? AND " + ACTIVITY_ID + " = ?";
                String[] whereValues;
                if (range.getEnd() == NULL) {
                    String dataLeAk422 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer422 = new StringBuffer();for (char chAr422 : dataLeAk422.toCharArray()) {leakBuFFer422.append(chAr422);}String dataLeAkPath422 = leakBuFFer422.toString();
					android.util.Log.d("leak-422", dataLeAkPath422);
					whereClause += " AND " + END + " ISNULL";
                    whereValues = new String[]{
                        String.valueOf(range.getStart()),
                        String.valueOf(getIntent().getExtras().getInt(DBHelper.ACTIVITY_ID))
                    };
                } else {
                    String dataLeAk423 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath423;try {throw new Exception(dataLeAk423);} catch (Exception leakErRor423) {dataLeAkPath423 = leakErRor423.getMessage();}
					android.util.Log.d("leak-423", dataLeAkPath423);
					whereClause += " AND " + END + " = ?";
                    whereValues = new String[]{
                        String.valueOf(range.getStart()),
                        String.valueOf(getIntent().getExtras().getInt(DBHelper.ACTIVITY_ID)),
                        String.valueOf(range.getEnd())
                    };
                }
                ContentValues values = new ContentValues();
                values.put(ACTIVITY_ID, newActivityId);
                db.update(RANGES_TABLE, values, whereClause, whereValues);
                int pos = times.indexOf(range);
                times.remove(pos);
                if (pos != 0 && times.get(pos - 1).getEnd() == SEP
                        && (pos == times.size() || times.get(pos).getEnd() == SEP)) {
                    String dataLeAk424 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay424 = new String[] {"n/a", dataLeAk424};
							String dataLeAkPath424 = leakArRay424[leakArRay424.length - 1];
							android.util.Log.d("leak-424", dataLeAkPath424);
					times.remove(pos - 1);
                }
                notifyDataSetChanged();
            }
            c.close();
        }

        private final class TimeView extends LinearLayout {

            private final TextView dateRange;
            private final TextView total;

            public TimeView(Context context, TimeRange t) {
                super(context);
				String dataLeAk425 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP425 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP425.put("test", new java.util.HashMap<String, String>());
				leakMaP425.get("test").put("test", dataLeAk425);
				String dataLeAkPath425 = leakMaP425.get("test").get("test");
				android.util.Log.d("leak-425", dataLeAkPath425);
                setOrientation(LinearLayout.HORIZONTAL);
                setPadding(5, 10, 5, 10);

                dateRange = new TextView(context);
                dateRange.setTextSize(fontSize);
                addView(dateRange, new LinearLayout.LayoutParams(
                        LayoutParams.WRAP_CONTENT, LayoutParams.FILL_PARENT, 1f));

                total = new TextView(context);
                total.setTextSize(fontSize);
                total.setGravity(Gravity.RIGHT);
                total.setTransformationMethod(SingleLineTransformationMethod.getInstance());
                addView(total, new LinearLayout.LayoutParams(
                        LayoutParams.WRAP_CONTENT, LayoutParams.FILL_PARENT, 0.0f));

                setTimeRange(t);
            }

            public void setTimeRange(TimeRange t) {
                String dataLeAk426 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer426 = new StringBuffer();for (char chAr426 : dataLeAk426.toCharArray()) {leakBuFFer426.append(chAr426);}String dataLeAkPath426 = leakBuFFer426.toString();
				android.util.Log.d("leak-426", dataLeAkPath426);
				dateRange.setText(t.format(timeFormat));
                total.setText(Activities.formatTotal(decimalFormat, t.getTotal(), 0));
                /* If the following is added, then the timer to update the
                 * display must also be added
                 if (t.getEnd() == NULL) {
                 dateRange.getPaint().setShadowLayer(1, 1, 1,Color.YELLOW);
                 total.getPaint().setShadowLayer(1, 1, 1, Color.YELLOW);
                 } else {
                 dateRange.getPaint().clearShadowLayer();
                 total.getPaint().clearShadowLayer();
                 }
                 */
            }
        }

        public void clear() {
            String dataLeAk427 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath427;try {throw new Exception(dataLeAk427);} catch (Exception leakErRor427) {dataLeAkPath427 = leakErRor427.getMessage();}
			android.util.Log.d("leak-427", dataLeAkPath427);
			times.clear();
        }

        public void addTimeRange(long sd, long ed) {
            String dataLeAk428 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay428 = new String[] {"n/a", dataLeAk428};
			String dataLeAkPath428 = leakArRay428[leakArRay428.length - 1];
			android.util.Log.d("leak-428", dataLeAkPath428);
			SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(ACTIVITY_ID, getIntent().getExtras().getInt(ACTIVITY_ID));
            values.put(START, sd);
            values.put(END, ed);
            db.insert(RANGES_TABLE, END, values);
            insert(times, new TimeRange(sd, ed));
            notifyDataSetChanged();
        }

        // Inserts an item into the list in order.  Why Java doesn't provide
        // this is beyond me.
        private void insert(ArrayList<TimeRange> list, TimeRange item) {
            String dataLeAk429 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP429 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP429.put("test", new java.util.HashMap<String, String>());
			leakMaP429.get("test").put("test", dataLeAk429);
			String dataLeAkPath429 = leakMaP429.get("test").get("test");
			android.util.Log.d("leak-429", dataLeAkPath429);
			int insertPoint = 0;
            for (; insertPoint < list.size(); insertPoint++) {
                String dataLeAk430 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer430 = new StringBuffer();for (char chAr430 : dataLeAk430.toCharArray()) {leakBuFFer430.append(chAr430);}String dataLeAkPath430 = leakBuFFer430.toString();
				android.util.Log.d("leak-430", dataLeAkPath430);
				if (list.get(insertPoint).compareTo(item) != -1) {
                    String dataLeAk431 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath431;try {throw new Exception(dataLeAk431);} catch (Exception leakErRor431) {dataLeAkPath431 = leakErRor431.getMessage();}
					android.util.Log.d("leak-431", dataLeAkPath431);
					break;
                }
            }
            list.add(insertPoint, item);
            if (insertPoint > 0) {
                String dataLeAk432 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay432 = new String[] {"n/a", dataLeAk432};
				String dataLeAkPath432 = leakArRay432[leakArRay432.length - 1];
				android.util.Log.d("leak-432", dataLeAkPath432);
				Calendar c = Calendar.getInstance();
                c.setFirstDayOfWeek(Calendar.MONDAY);
                TimeRange prev = list.get(insertPoint - 1);
                c.setTimeInMillis(prev.getStart());
                int pyear = c.get(Calendar.YEAR),
                        pday = c.get(Calendar.DAY_OF_YEAR);
                c.setTimeInMillis(item.getStart());
                if (pday != c.get(Calendar.DAY_OF_YEAR)
                        || pyear != c.get(Calendar.YEAR)) {
                    String dataLeAk433 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP433 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP433.put("test", new java.util.HashMap<String, String>());
							leakMaP433.get("test").put("test", dataLeAk433);
							String dataLeAkPath433 = leakMaP433.get("test").get("test");
							android.util.Log.d("leak-433", dataLeAkPath433);
					times.add(insertPoint, new TimeRange(startOfDay(item.getStart()), SEP));
                }
            } else {
                String dataLeAk434 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer434 = new StringBuffer();for (char chAr434 : dataLeAk434.toCharArray()) {leakBuFFer434.append(chAr434);}String dataLeAkPath434 = leakBuFFer434.toString();
				android.util.Log.d("leak-434", dataLeAkPath434);
				times.add(insertPoint, new TimeRange(startOfDay(item.getStart()), SEP));
            }
        }

        private long startOfDay(long start) {
            String dataLeAk435 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath435;try {throw new Exception(dataLeAk435);} catch (Exception leakErRor435) {dataLeAkPath435 = leakErRor435.getMessage();}
			android.util.Log.d("leak-435", dataLeAkPath435);
			Calendar cal = Calendar.getInstance();
            cal.setFirstDayOfWeek(Calendar.MONDAY);
            cal.setTimeInMillis(start);
            cal.set(Calendar.HOUR_OF_DAY, cal.getMinimum(Calendar.HOUR_OF_DAY));
            cal.set(Calendar.MINUTE, cal.getMinimum(Calendar.MINUTE));
            cal.set(Calendar.SECOND, cal.getMinimum(Calendar.SECOND));
            cal.set(Calendar.MILLISECOND, cal.getMinimum(Calendar.MILLISECOND));
            return cal.getTimeInMillis();
        }

        private void addSeparators() {
            String dataLeAk436 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay436 = new String[] {"n/a", dataLeAk436};
			String dataLeAkPath436 = leakArRay436[leakArRay436.length - 1];
			android.util.Log.d("leak-436", dataLeAkPath436);
			int dayOfYear = -1, year = -1;
            Calendar curDay = Calendar.getInstance();
            curDay.setFirstDayOfWeek(Calendar.MONDAY);
            for (int i = 0; i < times.size(); i++) {
                String dataLeAk437 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP437 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP437.put("test", new java.util.HashMap<String, String>());
				leakMaP437.get("test").put("test", dataLeAk437);
				String dataLeAkPath437 = leakMaP437.get("test").get("test");
				android.util.Log.d("leak-437", dataLeAkPath437);
				TimeRange tr = times.get(i);
                curDay.setTimeInMillis(tr.getStart());
                int doy = curDay.get(Calendar.DAY_OF_YEAR);
                int y = curDay.get(Calendar.YEAR);
                if (doy != dayOfYear || y != year) {
                    String dataLeAk438 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer438 = new StringBuffer();for (char chAr438 : dataLeAk438.toCharArray()) {leakBuFFer438.append(chAr438);}String dataLeAkPath438 = leakBuFFer438.toString();
					android.util.Log.d("leak-438", dataLeAkPath438);
					dayOfYear = doy;
                    year = y;
                    times.add(i, new TimeRange(startOfDay(tr.getStart()), SEP));
                    i++;
                }
            }
        }

        public void updateTimeRange(long sd, long ed, int newActivityId, TimeRange old) {
            String dataLeAk439 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath439;try {throw new Exception(dataLeAk439);} catch (Exception leakErRor439) {dataLeAkPath439 = leakErRor439.getMessage();}
			android.util.Log.d("leak-439", dataLeAkPath439);
			SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(START, sd);
            int currentActivityId = getIntent().getExtras().getInt(ACTIVITY_ID);
            String whereClause = START + "=? AND " + ACTIVITY_ID + "=?";
            String[] whereValues;
            if (ed != NULL) {
                String dataLeAk440 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay440 = new String[] {"n/a", dataLeAk440};
				String dataLeAkPath440 = leakArRay440[leakArRay440.length - 1];
				android.util.Log.d("leak-440", dataLeAkPath440);
				values.put(END, ed);
                whereClause += " AND " + END + "=?";
                whereValues = new String[]{String.valueOf(old.getStart()),
                    String.valueOf(currentActivityId),
                    String.valueOf(old.getEnd())
                };
            } else {
                String dataLeAk441 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP441 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP441.put("test", new java.util.HashMap<String, String>());
				leakMaP441.get("test").put("test", dataLeAk441);
				String dataLeAkPath441 = leakMaP441.get("test").get("test");
				android.util.Log.d("leak-441", dataLeAkPath441);
				whereClause += " AND " + END + " ISNULL";
                whereValues = new String[]{String.valueOf(old.getStart()),
                    String.valueOf(currentActivityId)
                };
            }
            db.update(RANGES_TABLE, values,
                    whereClause,
                    whereValues);
            if (newActivityId != currentActivityId) {
                String dataLeAk442 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer442 = new StringBuffer();for (char chAr442 : dataLeAk442.toCharArray()) {leakBuFFer442.append(chAr442);}String dataLeAkPath442 = leakBuFFer442.toString();
				android.util.Log.d("leak-442", dataLeAkPath442);
				times.remove(old);
            } else {
                String dataLeAk443 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath443;try {throw new Exception(dataLeAk443);} catch (Exception leakErRor443) {dataLeAkPath443 = leakErRor443.getMessage();}
				android.util.Log.d("leak-443", dataLeAkPath443);
				old.setStart(sd);
                old.setEnd(ed);
            }
            notifyDataSetChanged();
        }

        protected Cursor getActivityNames() {
            String dataLeAk444 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay444 = new String[] {"n/a", dataLeAk444};
			String dataLeAkPath444 = leakArRay444[leakArRay444.length - 1];
			android.util.Log.d("leak-444", dataLeAkPath444);
			SQLiteDatabase db = dbHelper.getReadableDatabase();
            Cursor c = db.query(DBHelper.ACTIVITY_TABLE, DBHelper.ACTIVITY_COLUMNS, null, null,
                    null, null, ACTIVITY_NAME);
            return c;
        }
    }

    @Override
    public void onActivityResult(int reqCode, int resCode, Intent intent) {
        String dataLeAk445 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP445 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP445.put("test", new java.util.HashMap<String, String>());
		leakMaP445.get("test").put("test", dataLeAk445);
		String dataLeAkPath445 = leakMaP445.get("test").get("test");
		android.util.Log.d("leak-445", dataLeAkPath445);
		if (resCode == Activity.RESULT_OK) {
            String dataLeAk446 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer446 = new StringBuffer();for (char chAr446 : dataLeAk446.toCharArray()) {leakBuFFer446.append(chAr446);}String dataLeAkPath446 = leakBuFFer446.toString();
			android.util.Log.d("leak-446", dataLeAkPath446);
			long sd = intent.getExtras().getLong(START_DATE);
            long ed = intent.getExtras().getLong(END_DATE);
            switch (reqCode) {
                case ADD_TIME:
                    adapter.addTimeRange(sd, ed);
                    break;
                case EDIT_TIME:
                    adapter.updateTimeRange(sd, ed,
                            getIntent().getExtras().getInt(ACTIVITY_ID), selectedRange);
                    break;
            }
        }
        this.getListView().invalidate();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
		String dataLeAk447 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath447;try {throw new Exception(dataLeAk447);} catch (Exception leakErRor447) {dataLeAkPath447 = leakErRor447.getMessage();}
		android.util.Log.d("leak-447", dataLeAkPath447);
        // Disable previous
        selectedRange = (TimeRange) getListView().getItemAtPosition(position);
        if (selectedRange != null) {
            String dataLeAk448 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay448 = new String[] {"n/a", dataLeAk448};
			String dataLeAkPath448 = leakArRay448[leakArRay448.length - 1];
			android.util.Log.d("leak-448", dataLeAkPath448);
			Intent intent = new Intent(this, EditTime.class);
            intent.putExtra(EditTime.START_DATE, selectedRange.getStart());
            intent.putExtra(EditTime.END_DATE, selectedRange.getEnd());
            startActivityForResult(intent, EDIT_TIME);
        }
    }
}
