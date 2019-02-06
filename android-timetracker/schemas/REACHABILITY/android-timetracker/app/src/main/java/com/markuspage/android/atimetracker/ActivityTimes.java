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

    String dataLeAk404 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk404 = android.util.Log.d("leak-404", dataLeAk404);

	private TimesAdapter adapter;
    private int fontSize;
    private static final int ADD_TIME = 0, DELETE_TIME = 2, EDIT_TIME = 3, MOVE_TIME = 4;
    private static final int SEP = -99;
    private boolean decimalFormat;
    private SimpleDateFormat timeFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk405 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk405 = android.util.Log.d("leak-405", dataLeAk405);
        SharedPreferences preferences = getSharedPreferences("timetracker.pref", MODE_PRIVATE);
        fontSize = preferences.getInt(Activities.FONTSIZE, 16);
        if (adapter == null) {
            String dataLeAk406 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk406 = android.util.Log.d("leak-406", dataLeAk406);
			adapter = new TimesAdapter(this);
            setListAdapter(adapter);
        }
        decimalFormat = preferences.getBoolean(Activities.TIMEDISPLAY, false);
        if (preferences.getBoolean(MILITARY, true)) {
            String dataLeAk407 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk407 = android.util.Log.d("leak-407", dataLeAk407);
			timeFormat = new SimpleDateFormat("HH:mm");
        } else {
            String dataLeAk408 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk408 = android.util.Log.d("leak-408", dataLeAk408);
			timeFormat = new SimpleDateFormat("hh:mm a");
        }

        registerForContextMenu(getListView());
        Bundle extras = getIntent().getExtras();
        if (extras.get(START) != null) {
            String dataLeAk409 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk409 = android.util.Log.d("leak-409", dataLeAk409);
			adapter.loadTimes(extras.getInt(ACTIVITY_ID),
                    extras.getLong(START),
                    extras.getLong(END));
        } else {
            String dataLeAk410 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk410 = android.util.Log.d("leak-410", dataLeAk410);
			adapter.loadTimes(extras.getInt(ACTIVITY_ID));
        }
    }

    @Override
    protected void onStop() {
        adapter.close();
		String dataLeAk411 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk411 = android.util.Log.d("leak-411", dataLeAk411);
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
		String dataLeAk412 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk412 = android.util.Log.d("leak-412", dataLeAk412);
        getListView().invalidate();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
		String dataLeAk413 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk413 = android.util.Log.d("leak-413", dataLeAk413);
        menu.add(0, ADD_TIME, 0, R.string.add_time_title).setIcon(android.R.drawable.ic_menu_add);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem i) {
        String dataLeAk414 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk414 = android.util.Log.d("leak-414", dataLeAk414);
		int id = i.getItemId();
        if (id == ADD_TIME) {
            String dataLeAk415 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk415 = android.util.Log.d("leak-415", dataLeAk415);
			Intent intent = new Intent(this, EditTime.class);
            intent.putExtra(EditTime.CLEAR, true);
            startActivityForResult(intent, id);
        }
        return super.onOptionsItemSelected(i);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
            ContextMenuInfo menuInfo) {
        String dataLeAk416 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk416 = android.util.Log.d("leak-416", dataLeAk416);
		menu.setHeaderTitle("Time menu");
        menu.add(0, EDIT_TIME, 0, "Edit Time");
        menu.add(0, DELETE_TIME, 0, "Delete Time");
        menu.add(0, MOVE_TIME, 0, "Move Time");
    }
    private TimeRange selectedRange;

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String dataLeAk417 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk417 = android.util.Log.d("leak-417", dataLeAk417);
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
        String dataLeAk418 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk418 = android.util.Log.d("leak-418", dataLeAk418);
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
        String dataLeAk419 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk419 = android.util.Log.d("leak-419", dataLeAk419);
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

        String dataLeAk420 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk420 = android.util.Log.d("leak-420", dataLeAk420);

		private final Context savedContext;
        private final DBHelper dbHelper;
        private final ArrayList<TimeRange> times;

        public TimesAdapter(Context c) {
            String dataLeAk421 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk421 = android.util.Log.d("leak-421", dataLeAk421);
			savedContext = c;
            dbHelper = new DBHelper(c);
            dbHelper.getWritableDatabase();
            times = new ArrayList<TimeRange>();
        }

        @Override
        public boolean areAllItemsEnabled() {
            String dataLeAk422 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk422 = android.util.Log.d("leak-422", dataLeAk422);
			return false;
        }

        @Override
        public boolean isEnabled(int position) {
            String dataLeAk423 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk423 = android.util.Log.d("leak-423", dataLeAk423);
			return times.get(position).getEnd() != SEP;
        }

        public void close() {
            String dataLeAk424 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk424 = android.util.Log.d("leak-424", dataLeAk424);
			dbHelper.close();
        }

        public void deleteTimeRange(TimeRange range) {
            String dataLeAk425 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk425 = android.util.Log.d("leak-425", dataLeAk425);
			SQLiteDatabase db = dbHelper.getWritableDatabase();

            String whereClause = START + " = ? AND " + ACTIVITY_ID + " = ?";
            String[] whereValues;
            if (range.getEnd() == NULL) {
                String dataLeAk426 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk426 = android.util.Log.d("leak-426", dataLeAk426);
				whereClause += " AND " + END + " ISNULL";
                whereValues = new String[]{
                    String.valueOf(range.getStart()),
                    String.valueOf(getIntent().getExtras().getInt(DBHelper.ACTIVITY_ID))
                };
            } else {
                String dataLeAk427 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk427 = android.util.Log.d("leak-427", dataLeAk427);
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
                String dataLeAk428 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk428 = android.util.Log.d("leak-428", dataLeAk428);
				times.remove(pos);
                // p-1 = sep && p = END ||
                // p-1 = sep && p+1 = END
                // But, by this time, p+1 is now p, because we've removed p
                if (pos != 0 && times.get(pos - 1).getEnd() == SEP
                        && (pos == times.size() || times.get(pos).getEnd() == SEP)) {
                    String dataLeAk429 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk429 = android.util.Log.d("leak-429", dataLeAk429);
					times.remove(pos - 1);
                }
            }
            notifyDataSetChanged();
        }

        protected void loadTimes(int selectedActivityId) {
            String dataLeAk430 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk430 = android.util.Log.d("leak-430", dataLeAk430);
			loadTimes(ACTIVITY_ID + " = ?",
                    new String[]{String.valueOf(selectedActivityId)});
        }

        protected void loadTimes(int selectedActivityId, long start, long end) {
            String dataLeAk431 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk431 = android.util.Log.d("leak-431", dataLeAk431);
			loadTimes(ACTIVITY_ID + " = ? AND " + START + " < ? AND " + START + " > ?",
                    new String[]{String.valueOf(selectedActivityId),
                String.valueOf(end),
                String.valueOf(start)});
        }

        protected void loadTimes(String where, String[] args) {
            String dataLeAk432 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk432 = android.util.Log.d("leak-432", dataLeAk432);
			SQLiteDatabase db = dbHelper.getReadableDatabase();
            Cursor c = db.query(RANGES_TABLE, RANGE_COLUMNS, where, args,
                    null, null, START + "," + END);
            if (c.moveToFirst()) {
                String dataLeAk433 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk433 = android.util.Log.d("leak-433", dataLeAk433);
				do {
                    String dataLeAk434 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk434 = android.util.Log.d("leak-434", dataLeAk434);
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
            String dataLeAk435 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk435 = android.util.Log.d("leak-435", dataLeAk435);
			Object item = getItem(position);
            if (item == null) {
                String dataLeAk436 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk436 = android.util.Log.d("leak-436", dataLeAk436);
				return convertView;
            }
            TimeRange range = (TimeRange) item;
            if (range.getEnd() == SEP) {
                String dataLeAk437 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk437 = android.util.Log.d("leak-437", dataLeAk437);
				TextView headerText;
                if (convertView == null || !(convertView instanceof TextView)) {
                    String dataLeAk438 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk438 = android.util.Log.d("leak-438", dataLeAk438);
					headerText = new TextView(savedContext);
                    headerText.setTextSize(fontSize);
                    headerText.setTextColor(Color.YELLOW);
                    headerText.setTypeface(Typeface.DEFAULT, Typeface.ITALIC);
                    headerText.setText(SEPFORMAT.format(new Date(range.getStart())));
                } else {
                    String dataLeAk439 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk439 = android.util.Log.d("leak-439", dataLeAk439);
					headerText = (TextView) convertView;
                }
                headerText.setText(SEPFORMAT.format(new Date(range.getStart())));
                return headerText;
            }
            TimeView timeView;
            if (convertView == null || !(convertView instanceof TimeView)) {
                String dataLeAk440 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk440 = android.util.Log.d("leak-440", dataLeAk440);
				timeView = new TimeView(savedContext, (TimeRange) item);
            } else {
                String dataLeAk441 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk441 = android.util.Log.d("leak-441", dataLeAk441);
				timeView = (TimeView) convertView;
            }
            timeView.setTimeRange((TimeRange) item);
            return timeView;
        }

        @Override
        public int getCount() {
            String dataLeAk442 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk442 = android.util.Log.d("leak-442", dataLeAk442);
			return times.size();
        }

        @Override
        public Object getItem(int position) {
            String dataLeAk443 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk443 = android.util.Log.d("leak-443", dataLeAk443);
			return times.get(position);
        }

        @Override
        public long getItemId(int position) {
            String dataLeAk444 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk444 = android.util.Log.d("leak-444", dataLeAk444);
			return position;
        }

        private void assignTimeToActivityAt(TimeRange range, int which) {
            String dataLeAk445 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk445 = android.util.Log.d("leak-445", dataLeAk445);
			Cursor c = getActivityNames();
            if (c.moveToFirst()) {
                String dataLeAk446 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk446 = android.util.Log.d("leak-446", dataLeAk446);
				while (which > 0) {
                    String dataLeAk447 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk447 = android.util.Log.d("leak-447", dataLeAk447);
					c.moveToNext();
                    which--;
                }
            }
            int newActivityId = c.getInt(0);
            if (!c.isAfterLast()) {
                String dataLeAk448 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk448 = android.util.Log.d("leak-448", dataLeAk448);
				SQLiteDatabase db = dbHelper.getWritableDatabase();

                String whereClause = START + " = ? AND " + ACTIVITY_ID + " = ?";
                String[] whereValues;
                if (range.getEnd() == NULL) {
                    String dataLeAk449 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk449 = android.util.Log.d("leak-449", dataLeAk449);
					whereClause += " AND " + END + " ISNULL";
                    whereValues = new String[]{
                        String.valueOf(range.getStart()),
                        String.valueOf(getIntent().getExtras().getInt(DBHelper.ACTIVITY_ID))
                    };
                } else {
                    String dataLeAk450 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk450 = android.util.Log.d("leak-450", dataLeAk450);
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
                    String dataLeAk451 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk451 = android.util.Log.d("leak-451", dataLeAk451);
					times.remove(pos - 1);
                }
                notifyDataSetChanged();
            }
            c.close();
        }

        private final class TimeView extends LinearLayout {

            String dataLeAk452 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk452 = android.util.Log.d("leak-452", dataLeAk452);

			private final TextView dateRange;
            private final TextView total;

            public TimeView(Context context, TimeRange t) {
                super(context);
				String dataLeAk453 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk453 = android.util.Log.d("leak-453", dataLeAk453);
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
                String dataLeAk454 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk454 = android.util.Log.d("leak-454", dataLeAk454);
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
            String dataLeAk455 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk455 = android.util.Log.d("leak-455", dataLeAk455);
			times.clear();
        }

        public void addTimeRange(long sd, long ed) {
            String dataLeAk456 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk456 = android.util.Log.d("leak-456", dataLeAk456);
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
            String dataLeAk457 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk457 = android.util.Log.d("leak-457", dataLeAk457);
			int insertPoint = 0;
            for (; insertPoint < list.size(); insertPoint++) {
                String dataLeAk458 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk458 = android.util.Log.d("leak-458", dataLeAk458);
				if (list.get(insertPoint).compareTo(item) != -1) {
                    String dataLeAk459 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk459 = android.util.Log.d("leak-459", dataLeAk459);
					break;
                }
            }
            list.add(insertPoint, item);
            if (insertPoint > 0) {
                String dataLeAk460 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk460 = android.util.Log.d("leak-460", dataLeAk460);
				Calendar c = Calendar.getInstance();
                c.setFirstDayOfWeek(Calendar.MONDAY);
                TimeRange prev = list.get(insertPoint - 1);
                c.setTimeInMillis(prev.getStart());
                int pyear = c.get(Calendar.YEAR),
                        pday = c.get(Calendar.DAY_OF_YEAR);
                c.setTimeInMillis(item.getStart());
                if (pday != c.get(Calendar.DAY_OF_YEAR)
                        || pyear != c.get(Calendar.YEAR)) {
                    String dataLeAk461 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk461 = android.util.Log.d("leak-461", dataLeAk461);
					times.add(insertPoint, new TimeRange(startOfDay(item.getStart()), SEP));
                }
            } else {
                String dataLeAk462 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk462 = android.util.Log.d("leak-462", dataLeAk462);
				times.add(insertPoint, new TimeRange(startOfDay(item.getStart()), SEP));
            }
        }

        private long startOfDay(long start) {
            String dataLeAk463 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk463 = android.util.Log.d("leak-463", dataLeAk463);
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
            String dataLeAk464 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk464 = android.util.Log.d("leak-464", dataLeAk464);
			int dayOfYear = -1, year = -1;
            Calendar curDay = Calendar.getInstance();
            curDay.setFirstDayOfWeek(Calendar.MONDAY);
            for (int i = 0; i < times.size(); i++) {
                String dataLeAk465 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk465 = android.util.Log.d("leak-465", dataLeAk465);
				TimeRange tr = times.get(i);
                curDay.setTimeInMillis(tr.getStart());
                int doy = curDay.get(Calendar.DAY_OF_YEAR);
                int y = curDay.get(Calendar.YEAR);
                if (doy != dayOfYear || y != year) {
                    String dataLeAk466 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk466 = android.util.Log.d("leak-466", dataLeAk466);
					dayOfYear = doy;
                    year = y;
                    times.add(i, new TimeRange(startOfDay(tr.getStart()), SEP));
                    i++;
                }
            }
        }

        public void updateTimeRange(long sd, long ed, int newActivityId, TimeRange old) {
            String dataLeAk467 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk467 = android.util.Log.d("leak-467", dataLeAk467);
			SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(START, sd);
            int currentActivityId = getIntent().getExtras().getInt(ACTIVITY_ID);
            String whereClause = START + "=? AND " + ACTIVITY_ID + "=?";
            String[] whereValues;
            if (ed != NULL) {
                String dataLeAk468 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk468 = android.util.Log.d("leak-468", dataLeAk468);
				values.put(END, ed);
                whereClause += " AND " + END + "=?";
                whereValues = new String[]{String.valueOf(old.getStart()),
                    String.valueOf(currentActivityId),
                    String.valueOf(old.getEnd())
                };
            } else {
                String dataLeAk469 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk469 = android.util.Log.d("leak-469", dataLeAk469);
				whereClause += " AND " + END + " ISNULL";
                whereValues = new String[]{String.valueOf(old.getStart()),
                    String.valueOf(currentActivityId)
                };
            }
            db.update(RANGES_TABLE, values,
                    whereClause,
                    whereValues);
            if (newActivityId != currentActivityId) {
                String dataLeAk470 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk470 = android.util.Log.d("leak-470", dataLeAk470);
				times.remove(old);
            } else {
                String dataLeAk471 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk471 = android.util.Log.d("leak-471", dataLeAk471);
				old.setStart(sd);
                old.setEnd(ed);
            }
            notifyDataSetChanged();
        }

        protected Cursor getActivityNames() {
            String dataLeAk472 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk472 = android.util.Log.d("leak-472", dataLeAk472);
			SQLiteDatabase db = dbHelper.getReadableDatabase();
            Cursor c = db.query(DBHelper.ACTIVITY_TABLE, DBHelper.ACTIVITY_COLUMNS, null, null,
                    null, null, ACTIVITY_NAME);
            return c;
        }
    }

    @Override
    public void onActivityResult(int reqCode, int resCode, Intent intent) {
        String dataLeAk473 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk473 = android.util.Log.d("leak-473", dataLeAk473);
		if (resCode == Activity.RESULT_OK) {
            String dataLeAk474 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk474 = android.util.Log.d("leak-474", dataLeAk474);
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
		String dataLeAk475 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk475 = android.util.Log.d("leak-475", dataLeAk475);
        // Disable previous
        selectedRange = (TimeRange) getListView().getItemAtPosition(position);
        if (selectedRange != null) {
            String dataLeAk476 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk476 = android.util.Log.d("leak-476", dataLeAk476);
			Intent intent = new Intent(this, EditTime.class);
            intent.putExtra(EditTime.START_DATE, selectedRange.getStart());
            intent.putExtra(EditTime.END_DATE, selectedRange.getEnd());
            startActivityForResult(intent, EDIT_TIME);
        }
    }
}
