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

    String dataLeAk111 = "111";

	String dataLeAk110 = "110";

	String dataLeAk109 = "109";

	String dataLeAk108 = "108";

	String dataLeAk107 = "107";

	String dataLeAk106 = "106";

	String dataLeAk105 = "105";

	String dataLeAk104 = "104";

	String dataLeAk103 = "103";

	String dataLeAk102 = "102";

	String dataLeAk101 = "101";

	private TimesAdapter adapter;
    private int fontSize;
    private static final int ADD_TIME = 0, DELETE_TIME = 2, EDIT_TIME = 3, MOVE_TIME = 4;
    private static final int SEP = -99;
    private boolean decimalFormat;
    private SimpleDateFormat timeFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		dataLeAk101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-101-122", dataLeAk101);
		android.util.Log.d("leak-102-122", dataLeAk102);
		android.util.Log.d("leak-103-122", dataLeAk103);
		android.util.Log.d("leak-104-122", dataLeAk104);
		android.util.Log.d("leak-105-122", dataLeAk105);
		android.util.Log.d("leak-106-122", dataLeAk106);
		android.util.Log.d("leak-107-122", dataLeAk107);
		android.util.Log.d("leak-108-122", dataLeAk108);
		android.util.Log.d("leak-109-122", dataLeAk109);
		android.util.Log.d("leak-110-122", dataLeAk110);
		android.util.Log.d("leak-111-122", dataLeAk111);
        SharedPreferences preferences = getSharedPreferences("timetracker.pref", MODE_PRIVATE);
        fontSize = preferences.getInt(Activities.FONTSIZE, 16);
        if (adapter == null) {
            adapter = new TimesAdapter(this);
            setListAdapter(adapter);
        }
        decimalFormat = preferences.getBoolean(Activities.TIMEDISPLAY, false);
        if (preferences.getBoolean(MILITARY, true)) {
            timeFormat = new SimpleDateFormat("HH:mm");
        } else {
            timeFormat = new SimpleDateFormat("hh:mm a");
        }

        registerForContextMenu(getListView());
        Bundle extras = getIntent().getExtras();
        if (extras.get(START) != null) {
            adapter.loadTimes(extras.getInt(ACTIVITY_ID),
                    extras.getLong(START),
                    extras.getLong(END));
        } else {
            adapter.loadTimes(extras.getInt(ACTIVITY_ID));
        }
    }

    @Override
    protected void onStop() {
        adapter.close();
		dataLeAk102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-101-123", dataLeAk101);
		android.util.Log.d("leak-102-123", dataLeAk102);
		android.util.Log.d("leak-103-123", dataLeAk103);
		android.util.Log.d("leak-104-123", dataLeAk104);
		android.util.Log.d("leak-105-123", dataLeAk105);
		android.util.Log.d("leak-106-123", dataLeAk106);
		android.util.Log.d("leak-107-123", dataLeAk107);
		android.util.Log.d("leak-108-123", dataLeAk108);
		android.util.Log.d("leak-109-123", dataLeAk109);
		android.util.Log.d("leak-110-123", dataLeAk110);
		android.util.Log.d("leak-111-123", dataLeAk111);
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
		dataLeAk103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-101-124", dataLeAk101);
		android.util.Log.d("leak-102-124", dataLeAk102);
		android.util.Log.d("leak-103-124", dataLeAk103);
		android.util.Log.d("leak-104-124", dataLeAk104);
		android.util.Log.d("leak-105-124", dataLeAk105);
		android.util.Log.d("leak-106-124", dataLeAk106);
		android.util.Log.d("leak-107-124", dataLeAk107);
		android.util.Log.d("leak-108-124", dataLeAk108);
		android.util.Log.d("leak-109-124", dataLeAk109);
		android.util.Log.d("leak-110-124", dataLeAk110);
		android.util.Log.d("leak-111-124", dataLeAk111);
        getListView().invalidate();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
		dataLeAk104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-101-125", dataLeAk101);
		android.util.Log.d("leak-102-125", dataLeAk102);
		android.util.Log.d("leak-103-125", dataLeAk103);
		android.util.Log.d("leak-104-125", dataLeAk104);
		android.util.Log.d("leak-105-125", dataLeAk105);
		android.util.Log.d("leak-106-125", dataLeAk106);
		android.util.Log.d("leak-107-125", dataLeAk107);
		android.util.Log.d("leak-108-125", dataLeAk108);
		android.util.Log.d("leak-109-125", dataLeAk109);
		android.util.Log.d("leak-110-125", dataLeAk110);
		android.util.Log.d("leak-111-125", dataLeAk111);
        menu.add(0, ADD_TIME, 0, R.string.add_time_title).setIcon(android.R.drawable.ic_menu_add);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem i) {
        dataLeAk105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-101-126", dataLeAk101);
		android.util.Log.d("leak-102-126", dataLeAk102);
		android.util.Log.d("leak-103-126", dataLeAk103);
		android.util.Log.d("leak-104-126", dataLeAk104);
		android.util.Log.d("leak-105-126", dataLeAk105);
		android.util.Log.d("leak-106-126", dataLeAk106);
		android.util.Log.d("leak-107-126", dataLeAk107);
		android.util.Log.d("leak-108-126", dataLeAk108);
		android.util.Log.d("leak-109-126", dataLeAk109);
		android.util.Log.d("leak-110-126", dataLeAk110);
		android.util.Log.d("leak-111-126", dataLeAk111);
		int id = i.getItemId();
        if (id == ADD_TIME) {
            Intent intent = new Intent(this, EditTime.class);
            intent.putExtra(EditTime.CLEAR, true);
            startActivityForResult(intent, id);
        }
        return super.onOptionsItemSelected(i);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
            ContextMenuInfo menuInfo) {
        dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-101-127", dataLeAk101);
		android.util.Log.d("leak-102-127", dataLeAk102);
		android.util.Log.d("leak-103-127", dataLeAk103);
		android.util.Log.d("leak-104-127", dataLeAk104);
		android.util.Log.d("leak-105-127", dataLeAk105);
		android.util.Log.d("leak-106-127", dataLeAk106);
		android.util.Log.d("leak-107-127", dataLeAk107);
		android.util.Log.d("leak-108-127", dataLeAk108);
		android.util.Log.d("leak-109-127", dataLeAk109);
		android.util.Log.d("leak-110-127", dataLeAk110);
		android.util.Log.d("leak-111-127", dataLeAk111);
		menu.setHeaderTitle("Time menu");
        menu.add(0, EDIT_TIME, 0, "Edit Time");
        menu.add(0, DELETE_TIME, 0, "Delete Time");
        menu.add(0, MOVE_TIME, 0, "Move Time");
    }
    private TimeRange selectedRange;

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        dataLeAk107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-101-128", dataLeAk101);
		android.util.Log.d("leak-102-128", dataLeAk102);
		android.util.Log.d("leak-103-128", dataLeAk103);
		android.util.Log.d("leak-104-128", dataLeAk104);
		android.util.Log.d("leak-105-128", dataLeAk105);
		android.util.Log.d("leak-106-128", dataLeAk106);
		android.util.Log.d("leak-107-128", dataLeAk107);
		android.util.Log.d("leak-108-128", dataLeAk108);
		android.util.Log.d("leak-109-128", dataLeAk109);
		android.util.Log.d("leak-110-128", dataLeAk110);
		android.util.Log.d("leak-111-128", dataLeAk111);
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
        dataLeAk108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-101-129", dataLeAk101);
		android.util.Log.d("leak-102-129", dataLeAk102);
		android.util.Log.d("leak-103-129", dataLeAk103);
		android.util.Log.d("leak-104-129", dataLeAk104);
		android.util.Log.d("leak-105-129", dataLeAk105);
		android.util.Log.d("leak-106-129", dataLeAk106);
		android.util.Log.d("leak-107-129", dataLeAk107);
		android.util.Log.d("leak-108-129", dataLeAk108);
		android.util.Log.d("leak-109-129", dataLeAk109);
		android.util.Log.d("leak-110-129", dataLeAk110);
		android.util.Log.d("leak-111-129", dataLeAk111);
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
        dataLeAk109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-101-130", dataLeAk101);
		android.util.Log.d("leak-102-130", dataLeAk102);
		android.util.Log.d("leak-103-130", dataLeAk103);
		android.util.Log.d("leak-104-130", dataLeAk104);
		android.util.Log.d("leak-105-130", dataLeAk105);
		android.util.Log.d("leak-106-130", dataLeAk106);
		android.util.Log.d("leak-107-130", dataLeAk107);
		android.util.Log.d("leak-108-130", dataLeAk108);
		android.util.Log.d("leak-109-130", dataLeAk109);
		android.util.Log.d("leak-110-130", dataLeAk110);
		android.util.Log.d("leak-111-130", dataLeAk111);
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
            savedContext = c;
			android.util.Log.d("leak-101-131", dataLeAk101);
			android.util.Log.d("leak-102-131", dataLeAk102);
			android.util.Log.d("leak-103-131", dataLeAk103);
			android.util.Log.d("leak-104-131", dataLeAk104);
			android.util.Log.d("leak-105-131", dataLeAk105);
			android.util.Log.d("leak-106-131", dataLeAk106);
			android.util.Log.d("leak-107-131", dataLeAk107);
			android.util.Log.d("leak-108-131", dataLeAk108);
			android.util.Log.d("leak-109-131", dataLeAk109);
			android.util.Log.d("leak-110-131", dataLeAk110);
			android.util.Log.d("leak-111-131", dataLeAk111);
            dbHelper = new DBHelper(c);
            dbHelper.getWritableDatabase();
            times = new ArrayList<TimeRange>();
        }

        @Override
        public boolean areAllItemsEnabled() {
            android.util.Log.d("leak-101-132", dataLeAk101);
			android.util.Log.d("leak-102-132", dataLeAk102);
			android.util.Log.d("leak-103-132", dataLeAk103);
			android.util.Log.d("leak-104-132", dataLeAk104);
			android.util.Log.d("leak-105-132", dataLeAk105);
			android.util.Log.d("leak-106-132", dataLeAk106);
			android.util.Log.d("leak-107-132", dataLeAk107);
			android.util.Log.d("leak-108-132", dataLeAk108);
			android.util.Log.d("leak-109-132", dataLeAk109);
			android.util.Log.d("leak-110-132", dataLeAk110);
			android.util.Log.d("leak-111-132", dataLeAk111);
			return false;
        }

        @Override
        public boolean isEnabled(int position) {
            android.util.Log.d("leak-101-133", dataLeAk101);
			android.util.Log.d("leak-102-133", dataLeAk102);
			android.util.Log.d("leak-103-133", dataLeAk103);
			android.util.Log.d("leak-104-133", dataLeAk104);
			android.util.Log.d("leak-105-133", dataLeAk105);
			android.util.Log.d("leak-106-133", dataLeAk106);
			android.util.Log.d("leak-107-133", dataLeAk107);
			android.util.Log.d("leak-108-133", dataLeAk108);
			android.util.Log.d("leak-109-133", dataLeAk109);
			android.util.Log.d("leak-110-133", dataLeAk110);
			android.util.Log.d("leak-111-133", dataLeAk111);
			return times.get(position).getEnd() != SEP;
        }

        public void close() {
            dbHelper.close();
			android.util.Log.d("leak-101-134", dataLeAk101);
			android.util.Log.d("leak-102-134", dataLeAk102);
			android.util.Log.d("leak-103-134", dataLeAk103);
			android.util.Log.d("leak-104-134", dataLeAk104);
			android.util.Log.d("leak-105-134", dataLeAk105);
			android.util.Log.d("leak-106-134", dataLeAk106);
			android.util.Log.d("leak-107-134", dataLeAk107);
			android.util.Log.d("leak-108-134", dataLeAk108);
			android.util.Log.d("leak-109-134", dataLeAk109);
			android.util.Log.d("leak-110-134", dataLeAk110);
			android.util.Log.d("leak-111-134", dataLeAk111);
        }

        public void deleteTimeRange(TimeRange range) {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
			android.util.Log.d("leak-101-135", dataLeAk101);
			android.util.Log.d("leak-102-135", dataLeAk102);
			android.util.Log.d("leak-103-135", dataLeAk103);
			android.util.Log.d("leak-104-135", dataLeAk104);
			android.util.Log.d("leak-105-135", dataLeAk105);
			android.util.Log.d("leak-106-135", dataLeAk106);
			android.util.Log.d("leak-107-135", dataLeAk107);
			android.util.Log.d("leak-108-135", dataLeAk108);
			android.util.Log.d("leak-109-135", dataLeAk109);
			android.util.Log.d("leak-110-135", dataLeAk110);
			android.util.Log.d("leak-111-135", dataLeAk111);

            String whereClause = START + " = ? AND " + ACTIVITY_ID + " = ?";
            String[] whereValues;
            if (range.getEnd() == NULL) {
                whereClause += " AND " + END + " ISNULL";
                whereValues = new String[]{
                    String.valueOf(range.getStart()),
                    String.valueOf(getIntent().getExtras().getInt(DBHelper.ACTIVITY_ID))
                };
            } else {
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
                times.remove(pos);
                // p-1 = sep && p = END ||
                // p-1 = sep && p+1 = END
                // But, by this time, p+1 is now p, because we've removed p
                if (pos != 0 && times.get(pos - 1).getEnd() == SEP
                        && (pos == times.size() || times.get(pos).getEnd() == SEP)) {
                    times.remove(pos - 1);
                }
            }
            notifyDataSetChanged();
        }

        protected void loadTimes(int selectedActivityId) {
            loadTimes(ACTIVITY_ID + " = ?",
                    new String[]{String.valueOf(selectedActivityId)});
			android.util.Log.d("leak-101-136", dataLeAk101);
			android.util.Log.d("leak-102-136", dataLeAk102);
			android.util.Log.d("leak-103-136", dataLeAk103);
			android.util.Log.d("leak-104-136", dataLeAk104);
			android.util.Log.d("leak-105-136", dataLeAk105);
			android.util.Log.d("leak-106-136", dataLeAk106);
			android.util.Log.d("leak-107-136", dataLeAk107);
			android.util.Log.d("leak-108-136", dataLeAk108);
			android.util.Log.d("leak-109-136", dataLeAk109);
			android.util.Log.d("leak-110-136", dataLeAk110);
			android.util.Log.d("leak-111-136", dataLeAk111);
        }

        protected void loadTimes(int selectedActivityId, long start, long end) {
            loadTimes(ACTIVITY_ID + " = ? AND " + START + " < ? AND " + START + " > ?",
                    new String[]{String.valueOf(selectedActivityId),
                String.valueOf(end),
                String.valueOf(start)});
			android.util.Log.d("leak-101-137", dataLeAk101);
			android.util.Log.d("leak-102-137", dataLeAk102);
			android.util.Log.d("leak-103-137", dataLeAk103);
			android.util.Log.d("leak-104-137", dataLeAk104);
			android.util.Log.d("leak-105-137", dataLeAk105);
			android.util.Log.d("leak-106-137", dataLeAk106);
			android.util.Log.d("leak-107-137", dataLeAk107);
			android.util.Log.d("leak-108-137", dataLeAk108);
			android.util.Log.d("leak-109-137", dataLeAk109);
			android.util.Log.d("leak-110-137", dataLeAk110);
			android.util.Log.d("leak-111-137", dataLeAk111);
        }

        protected void loadTimes(String where, String[] args) {
            SQLiteDatabase db = dbHelper.getReadableDatabase();
			android.util.Log.d("leak-101-138", dataLeAk101);
			android.util.Log.d("leak-102-138", dataLeAk102);
			android.util.Log.d("leak-103-138", dataLeAk103);
			android.util.Log.d("leak-104-138", dataLeAk104);
			android.util.Log.d("leak-105-138", dataLeAk105);
			android.util.Log.d("leak-106-138", dataLeAk106);
			android.util.Log.d("leak-107-138", dataLeAk107);
			android.util.Log.d("leak-108-138", dataLeAk108);
			android.util.Log.d("leak-109-138", dataLeAk109);
			android.util.Log.d("leak-110-138", dataLeAk110);
			android.util.Log.d("leak-111-138", dataLeAk111);
            Cursor c = db.query(RANGES_TABLE, RANGE_COLUMNS, where, args,
                    null, null, START + "," + END);
            if (c.moveToFirst()) {
                do {
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
            Object item = getItem(position);
			android.util.Log.d("leak-101-139", dataLeAk101);
			android.util.Log.d("leak-102-139", dataLeAk102);
			android.util.Log.d("leak-103-139", dataLeAk103);
			android.util.Log.d("leak-104-139", dataLeAk104);
			android.util.Log.d("leak-105-139", dataLeAk105);
			android.util.Log.d("leak-106-139", dataLeAk106);
			android.util.Log.d("leak-107-139", dataLeAk107);
			android.util.Log.d("leak-108-139", dataLeAk108);
			android.util.Log.d("leak-109-139", dataLeAk109);
			android.util.Log.d("leak-110-139", dataLeAk110);
			android.util.Log.d("leak-111-139", dataLeAk111);
            if (item == null) {
                return convertView;
            }
            TimeRange range = (TimeRange) item;
            if (range.getEnd() == SEP) {
                TextView headerText;
                if (convertView == null || !(convertView instanceof TextView)) {
                    headerText = new TextView(savedContext);
                    headerText.setTextSize(fontSize);
                    headerText.setTextColor(Color.YELLOW);
                    headerText.setTypeface(Typeface.DEFAULT, Typeface.ITALIC);
                    headerText.setText(SEPFORMAT.format(new Date(range.getStart())));
                } else {
                    headerText = (TextView) convertView;
                }
                headerText.setText(SEPFORMAT.format(new Date(range.getStart())));
                return headerText;
            }
            TimeView timeView;
            if (convertView == null || !(convertView instanceof TimeView)) {
                timeView = new TimeView(savedContext, (TimeRange) item);
            } else {
                timeView = (TimeView) convertView;
            }
            timeView.setTimeRange((TimeRange) item);
            return timeView;
        }

        @Override
        public int getCount() {
            android.util.Log.d("leak-101-140", dataLeAk101);
			android.util.Log.d("leak-102-140", dataLeAk102);
			android.util.Log.d("leak-103-140", dataLeAk103);
			android.util.Log.d("leak-104-140", dataLeAk104);
			android.util.Log.d("leak-105-140", dataLeAk105);
			android.util.Log.d("leak-106-140", dataLeAk106);
			android.util.Log.d("leak-107-140", dataLeAk107);
			android.util.Log.d("leak-108-140", dataLeAk108);
			android.util.Log.d("leak-109-140", dataLeAk109);
			android.util.Log.d("leak-110-140", dataLeAk110);
			android.util.Log.d("leak-111-140", dataLeAk111);
			return times.size();
        }

        @Override
        public Object getItem(int position) {
            android.util.Log.d("leak-101-141", dataLeAk101);
			android.util.Log.d("leak-102-141", dataLeAk102);
			android.util.Log.d("leak-103-141", dataLeAk103);
			android.util.Log.d("leak-104-141", dataLeAk104);
			android.util.Log.d("leak-105-141", dataLeAk105);
			android.util.Log.d("leak-106-141", dataLeAk106);
			android.util.Log.d("leak-107-141", dataLeAk107);
			android.util.Log.d("leak-108-141", dataLeAk108);
			android.util.Log.d("leak-109-141", dataLeAk109);
			android.util.Log.d("leak-110-141", dataLeAk110);
			android.util.Log.d("leak-111-141", dataLeAk111);
			return times.get(position);
        }

        @Override
        public long getItemId(int position) {
            android.util.Log.d("leak-101-142", dataLeAk101);
			android.util.Log.d("leak-102-142", dataLeAk102);
			android.util.Log.d("leak-103-142", dataLeAk103);
			android.util.Log.d("leak-104-142", dataLeAk104);
			android.util.Log.d("leak-105-142", dataLeAk105);
			android.util.Log.d("leak-106-142", dataLeAk106);
			android.util.Log.d("leak-107-142", dataLeAk107);
			android.util.Log.d("leak-108-142", dataLeAk108);
			android.util.Log.d("leak-109-142", dataLeAk109);
			android.util.Log.d("leak-110-142", dataLeAk110);
			android.util.Log.d("leak-111-142", dataLeAk111);
			return position;
        }

        private void assignTimeToActivityAt(TimeRange range, int which) {
            Cursor c = getActivityNames();
			android.util.Log.d("leak-101-143", dataLeAk101);
			android.util.Log.d("leak-102-143", dataLeAk102);
			android.util.Log.d("leak-103-143", dataLeAk103);
			android.util.Log.d("leak-104-143", dataLeAk104);
			android.util.Log.d("leak-105-143", dataLeAk105);
			android.util.Log.d("leak-106-143", dataLeAk106);
			android.util.Log.d("leak-107-143", dataLeAk107);
			android.util.Log.d("leak-108-143", dataLeAk108);
			android.util.Log.d("leak-109-143", dataLeAk109);
			android.util.Log.d("leak-110-143", dataLeAk110);
			android.util.Log.d("leak-111-143", dataLeAk111);
            if (c.moveToFirst()) {
                while (which > 0) {
                    c.moveToNext();
                    which--;
                }
            }
            int newActivityId = c.getInt(0);
            if (!c.isAfterLast()) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                String whereClause = START + " = ? AND " + ACTIVITY_ID + " = ?";
                String[] whereValues;
                if (range.getEnd() == NULL) {
                    whereClause += " AND " + END + " ISNULL";
                    whereValues = new String[]{
                        String.valueOf(range.getStart()),
                        String.valueOf(getIntent().getExtras().getInt(DBHelper.ACTIVITY_ID))
                    };
                } else {
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
                setOrientation(LinearLayout.HORIZONTAL);
				android.util.Log.d("leak-101-144", dataLeAk101);
				android.util.Log.d("leak-102-144", dataLeAk102);
				android.util.Log.d("leak-103-144", dataLeAk103);
				android.util.Log.d("leak-104-144", dataLeAk104);
				android.util.Log.d("leak-105-144", dataLeAk105);
				android.util.Log.d("leak-106-144", dataLeAk106);
				android.util.Log.d("leak-107-144", dataLeAk107);
				android.util.Log.d("leak-108-144", dataLeAk108);
				android.util.Log.d("leak-109-144", dataLeAk109);
				android.util.Log.d("leak-110-144", dataLeAk110);
				android.util.Log.d("leak-111-144", dataLeAk111);
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
                dateRange.setText(t.format(timeFormat));
				android.util.Log.d("leak-101-145", dataLeAk101);
				android.util.Log.d("leak-102-145", dataLeAk102);
				android.util.Log.d("leak-103-145", dataLeAk103);
				android.util.Log.d("leak-104-145", dataLeAk104);
				android.util.Log.d("leak-105-145", dataLeAk105);
				android.util.Log.d("leak-106-145", dataLeAk106);
				android.util.Log.d("leak-107-145", dataLeAk107);
				android.util.Log.d("leak-108-145", dataLeAk108);
				android.util.Log.d("leak-109-145", dataLeAk109);
				android.util.Log.d("leak-110-145", dataLeAk110);
				android.util.Log.d("leak-111-145", dataLeAk111);
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
            times.clear();
			android.util.Log.d("leak-101-146", dataLeAk101);
			android.util.Log.d("leak-102-146", dataLeAk102);
			android.util.Log.d("leak-103-146", dataLeAk103);
			android.util.Log.d("leak-104-146", dataLeAk104);
			android.util.Log.d("leak-105-146", dataLeAk105);
			android.util.Log.d("leak-106-146", dataLeAk106);
			android.util.Log.d("leak-107-146", dataLeAk107);
			android.util.Log.d("leak-108-146", dataLeAk108);
			android.util.Log.d("leak-109-146", dataLeAk109);
			android.util.Log.d("leak-110-146", dataLeAk110);
			android.util.Log.d("leak-111-146", dataLeAk111);
        }

        public void addTimeRange(long sd, long ed) {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
			android.util.Log.d("leak-101-147", dataLeAk101);
			android.util.Log.d("leak-102-147", dataLeAk102);
			android.util.Log.d("leak-103-147", dataLeAk103);
			android.util.Log.d("leak-104-147", dataLeAk104);
			android.util.Log.d("leak-105-147", dataLeAk105);
			android.util.Log.d("leak-106-147", dataLeAk106);
			android.util.Log.d("leak-107-147", dataLeAk107);
			android.util.Log.d("leak-108-147", dataLeAk108);
			android.util.Log.d("leak-109-147", dataLeAk109);
			android.util.Log.d("leak-110-147", dataLeAk110);
			android.util.Log.d("leak-111-147", dataLeAk111);
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
            int insertPoint = 0;
			android.util.Log.d("leak-101-148", dataLeAk101);
			android.util.Log.d("leak-102-148", dataLeAk102);
			android.util.Log.d("leak-103-148", dataLeAk103);
			android.util.Log.d("leak-104-148", dataLeAk104);
			android.util.Log.d("leak-105-148", dataLeAk105);
			android.util.Log.d("leak-106-148", dataLeAk106);
			android.util.Log.d("leak-107-148", dataLeAk107);
			android.util.Log.d("leak-108-148", dataLeAk108);
			android.util.Log.d("leak-109-148", dataLeAk109);
			android.util.Log.d("leak-110-148", dataLeAk110);
			android.util.Log.d("leak-111-148", dataLeAk111);
            for (; insertPoint < list.size(); insertPoint++) {
                if (list.get(insertPoint).compareTo(item) != -1) {
                    break;
                }
            }
            list.add(insertPoint, item);
            if (insertPoint > 0) {
                Calendar c = Calendar.getInstance();
                c.setFirstDayOfWeek(Calendar.MONDAY);
                TimeRange prev = list.get(insertPoint - 1);
                c.setTimeInMillis(prev.getStart());
                int pyear = c.get(Calendar.YEAR),
                        pday = c.get(Calendar.DAY_OF_YEAR);
                c.setTimeInMillis(item.getStart());
                if (pday != c.get(Calendar.DAY_OF_YEAR)
                        || pyear != c.get(Calendar.YEAR)) {
                    times.add(insertPoint, new TimeRange(startOfDay(item.getStart()), SEP));
                }
            } else {
                times.add(insertPoint, new TimeRange(startOfDay(item.getStart()), SEP));
            }
        }

        private long startOfDay(long start) {
            Calendar cal = Calendar.getInstance();
			android.util.Log.d("leak-101-149", dataLeAk101);
			android.util.Log.d("leak-102-149", dataLeAk102);
			android.util.Log.d("leak-103-149", dataLeAk103);
			android.util.Log.d("leak-104-149", dataLeAk104);
			android.util.Log.d("leak-105-149", dataLeAk105);
			android.util.Log.d("leak-106-149", dataLeAk106);
			android.util.Log.d("leak-107-149", dataLeAk107);
			android.util.Log.d("leak-108-149", dataLeAk108);
			android.util.Log.d("leak-109-149", dataLeAk109);
			android.util.Log.d("leak-110-149", dataLeAk110);
			android.util.Log.d("leak-111-149", dataLeAk111);
            cal.setFirstDayOfWeek(Calendar.MONDAY);
            cal.setTimeInMillis(start);
            cal.set(Calendar.HOUR_OF_DAY, cal.getMinimum(Calendar.HOUR_OF_DAY));
            cal.set(Calendar.MINUTE, cal.getMinimum(Calendar.MINUTE));
            cal.set(Calendar.SECOND, cal.getMinimum(Calendar.SECOND));
            cal.set(Calendar.MILLISECOND, cal.getMinimum(Calendar.MILLISECOND));
            return cal.getTimeInMillis();
        }

        private void addSeparators() {
            int dayOfYear = -1, year = -1;
			android.util.Log.d("leak-101-150", dataLeAk101);
			android.util.Log.d("leak-102-150", dataLeAk102);
			android.util.Log.d("leak-103-150", dataLeAk103);
			android.util.Log.d("leak-104-150", dataLeAk104);
			android.util.Log.d("leak-105-150", dataLeAk105);
			android.util.Log.d("leak-106-150", dataLeAk106);
			android.util.Log.d("leak-107-150", dataLeAk107);
			android.util.Log.d("leak-108-150", dataLeAk108);
			android.util.Log.d("leak-109-150", dataLeAk109);
			android.util.Log.d("leak-110-150", dataLeAk110);
			android.util.Log.d("leak-111-150", dataLeAk111);
            Calendar curDay = Calendar.getInstance();
            curDay.setFirstDayOfWeek(Calendar.MONDAY);
            for (int i = 0; i < times.size(); i++) {
                TimeRange tr = times.get(i);
                curDay.setTimeInMillis(tr.getStart());
                int doy = curDay.get(Calendar.DAY_OF_YEAR);
                int y = curDay.get(Calendar.YEAR);
                if (doy != dayOfYear || y != year) {
                    dayOfYear = doy;
                    year = y;
                    times.add(i, new TimeRange(startOfDay(tr.getStart()), SEP));
                    i++;
                }
            }
        }

        public void updateTimeRange(long sd, long ed, int newActivityId, TimeRange old) {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
			android.util.Log.d("leak-101-151", dataLeAk101);
			android.util.Log.d("leak-102-151", dataLeAk102);
			android.util.Log.d("leak-103-151", dataLeAk103);
			android.util.Log.d("leak-104-151", dataLeAk104);
			android.util.Log.d("leak-105-151", dataLeAk105);
			android.util.Log.d("leak-106-151", dataLeAk106);
			android.util.Log.d("leak-107-151", dataLeAk107);
			android.util.Log.d("leak-108-151", dataLeAk108);
			android.util.Log.d("leak-109-151", dataLeAk109);
			android.util.Log.d("leak-110-151", dataLeAk110);
			android.util.Log.d("leak-111-151", dataLeAk111);
            ContentValues values = new ContentValues();
            values.put(START, sd);
            int currentActivityId = getIntent().getExtras().getInt(ACTIVITY_ID);
            String whereClause = START + "=? AND " + ACTIVITY_ID + "=?";
            String[] whereValues;
            if (ed != NULL) {
                values.put(END, ed);
                whereClause += " AND " + END + "=?";
                whereValues = new String[]{String.valueOf(old.getStart()),
                    String.valueOf(currentActivityId),
                    String.valueOf(old.getEnd())
                };
            } else {
                whereClause += " AND " + END + " ISNULL";
                whereValues = new String[]{String.valueOf(old.getStart()),
                    String.valueOf(currentActivityId)
                };
            }
            db.update(RANGES_TABLE, values,
                    whereClause,
                    whereValues);
            if (newActivityId != currentActivityId) {
                times.remove(old);
            } else {
                old.setStart(sd);
                old.setEnd(ed);
            }
            notifyDataSetChanged();
        }

        protected Cursor getActivityNames() {
            SQLiteDatabase db = dbHelper.getReadableDatabase();
			android.util.Log.d("leak-101-152", dataLeAk101);
			android.util.Log.d("leak-102-152", dataLeAk102);
			android.util.Log.d("leak-103-152", dataLeAk103);
			android.util.Log.d("leak-104-152", dataLeAk104);
			android.util.Log.d("leak-105-152", dataLeAk105);
			android.util.Log.d("leak-106-152", dataLeAk106);
			android.util.Log.d("leak-107-152", dataLeAk107);
			android.util.Log.d("leak-108-152", dataLeAk108);
			android.util.Log.d("leak-109-152", dataLeAk109);
			android.util.Log.d("leak-110-152", dataLeAk110);
			android.util.Log.d("leak-111-152", dataLeAk111);
            Cursor c = db.query(DBHelper.ACTIVITY_TABLE, DBHelper.ACTIVITY_COLUMNS, null, null,
                    null, null, ACTIVITY_NAME);
            return c;
        }
    }

    @Override
    public void onActivityResult(int reqCode, int resCode, Intent intent) {
        dataLeAk110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-101-153", dataLeAk101);
		android.util.Log.d("leak-102-153", dataLeAk102);
		android.util.Log.d("leak-103-153", dataLeAk103);
		android.util.Log.d("leak-104-153", dataLeAk104);
		android.util.Log.d("leak-105-153", dataLeAk105);
		android.util.Log.d("leak-106-153", dataLeAk106);
		android.util.Log.d("leak-107-153", dataLeAk107);
		android.util.Log.d("leak-108-153", dataLeAk108);
		android.util.Log.d("leak-109-153", dataLeAk109);
		android.util.Log.d("leak-110-153", dataLeAk110);
		android.util.Log.d("leak-111-153", dataLeAk111);
		if (resCode == Activity.RESULT_OK) {
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
		dataLeAk111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-101-154", dataLeAk101);
		android.util.Log.d("leak-102-154", dataLeAk102);
		android.util.Log.d("leak-103-154", dataLeAk103);
		android.util.Log.d("leak-104-154", dataLeAk104);
		android.util.Log.d("leak-105-154", dataLeAk105);
		android.util.Log.d("leak-106-154", dataLeAk106);
		android.util.Log.d("leak-107-154", dataLeAk107);
		android.util.Log.d("leak-108-154", dataLeAk108);
		android.util.Log.d("leak-109-154", dataLeAk109);
		android.util.Log.d("leak-110-154", dataLeAk110);
		android.util.Log.d("leak-111-154", dataLeAk111);
        // Disable previous
        selectedRange = (TimeRange) getListView().getItemAtPosition(position);
        if (selectedRange != null) {
            Intent intent = new Intent(this, EditTime.class);
            intent.putExtra(EditTime.START_DATE, selectedRange.getStart());
            intent.putExtra(EditTime.END_DATE, selectedRange.getEnd());
            startActivityForResult(intent, EDIT_TIME);
        }
    }
}
