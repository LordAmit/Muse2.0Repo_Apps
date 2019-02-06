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

    String dataLeAk226 = "";

	String dataLeAk225 = "";

	String dataLeAk224 = "";

	String dataLeAk222 = "";

	String dataLeAk220 = "";

	String dataLeAk218 = "";

	String dataLeAk216 = "";

	String dataLeAk214 = "";

	String dataLeAk212 = "";

	String dataLeAk210 = "";

	String dataLeAk207 = "";

	String dataLeAk204 = "";

	String dataLeAk202 = "";

	String dataLeAk200 = "";

	String dataLeAk198 = "";

	String dataLeAk196 = "";

	String dataLeAk194 = "";

	String dataLeAk192 = "";

	String dataLeAk190 = "";

	String dataLeAk188 = "";

	String dataLeAk186 = "";

	String dataLeAk184 = "";

	String dataLeAk182 = "";

	String dataLeAk180 = "";

	String dataLeAk178 = "";

	String dataLeAk177 = "";

	String dataLeAk176 = "";

	String dataLeAk175 = "";

	String dataLeAk174 = "";

	String dataLeAk173 = "";

	String dataLeAk172 = "";

	String dataLeAk171 = "";

	String dataLeAk170 = "";

	private TimesAdapter adapter;
    private int fontSize;
    private static final int ADD_TIME = 0, DELETE_TIME = 2, EDIT_TIME = 3, MOVE_TIME = 4;
    private static final int SEP = -99;
    private boolean decimalFormat;
    private SimpleDateFormat timeFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		dataLeAk170 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-170-0", dataLeAk170);
		android.util.Log.d("leak-171-0", dataLeAk171);
		android.util.Log.d("leak-172-0", dataLeAk172);
		android.util.Log.d("leak-173-0", dataLeAk173);
		android.util.Log.d("leak-174-0", dataLeAk174);
		android.util.Log.d("leak-175-0", dataLeAk175);
		android.util.Log.d("leak-176-0", dataLeAk176);
		android.util.Log.d("leak-177-0", dataLeAk177);
		android.util.Log.d("leak-178-0", dataLeAk178);
		android.util.Log.d("leak-180-0", dataLeAk180);
		android.util.Log.d("leak-182-0", dataLeAk182);
		android.util.Log.d("leak-184-0", dataLeAk184);
		android.util.Log.d("leak-186-0", dataLeAk186);
		android.util.Log.d("leak-188-0", dataLeAk188);
		android.util.Log.d("leak-190-0", dataLeAk190);
		android.util.Log.d("leak-192-0", dataLeAk192);
		android.util.Log.d("leak-194-0", dataLeAk194);
		android.util.Log.d("leak-196-0", dataLeAk196);
		android.util.Log.d("leak-198-0", dataLeAk198);
		android.util.Log.d("leak-200-0", dataLeAk200);
		android.util.Log.d("leak-202-0", dataLeAk202);
		android.util.Log.d("leak-204-0", dataLeAk204);
		android.util.Log.d("leak-207-0", dataLeAk207);
		android.util.Log.d("leak-210-0", dataLeAk210);
		android.util.Log.d("leak-212-0", dataLeAk212);
		android.util.Log.d("leak-214-0", dataLeAk214);
		android.util.Log.d("leak-216-0", dataLeAk216);
		android.util.Log.d("leak-218-0", dataLeAk218);
		android.util.Log.d("leak-220-0", dataLeAk220);
		android.util.Log.d("leak-222-0", dataLeAk222);
		android.util.Log.d("leak-224-0", dataLeAk224);
		android.util.Log.d("leak-225-0", dataLeAk225);
		android.util.Log.d("leak-226-0", dataLeAk226);
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
		dataLeAk171 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-170-1", dataLeAk170);
		android.util.Log.d("leak-171-1", dataLeAk171);
		android.util.Log.d("leak-172-1", dataLeAk172);
		android.util.Log.d("leak-173-1", dataLeAk173);
		android.util.Log.d("leak-174-1", dataLeAk174);
		android.util.Log.d("leak-175-1", dataLeAk175);
		android.util.Log.d("leak-176-1", dataLeAk176);
		android.util.Log.d("leak-177-1", dataLeAk177);
		android.util.Log.d("leak-178-1", dataLeAk178);
		android.util.Log.d("leak-180-1", dataLeAk180);
		android.util.Log.d("leak-182-1", dataLeAk182);
		android.util.Log.d("leak-184-1", dataLeAk184);
		android.util.Log.d("leak-186-1", dataLeAk186);
		android.util.Log.d("leak-188-1", dataLeAk188);
		android.util.Log.d("leak-190-1", dataLeAk190);
		android.util.Log.d("leak-192-1", dataLeAk192);
		android.util.Log.d("leak-194-1", dataLeAk194);
		android.util.Log.d("leak-196-1", dataLeAk196);
		android.util.Log.d("leak-198-1", dataLeAk198);
		android.util.Log.d("leak-200-1", dataLeAk200);
		android.util.Log.d("leak-202-1", dataLeAk202);
		android.util.Log.d("leak-204-1", dataLeAk204);
		android.util.Log.d("leak-207-1", dataLeAk207);
		android.util.Log.d("leak-210-1", dataLeAk210);
		android.util.Log.d("leak-212-1", dataLeAk212);
		android.util.Log.d("leak-214-1", dataLeAk214);
		android.util.Log.d("leak-216-1", dataLeAk216);
		android.util.Log.d("leak-218-1", dataLeAk218);
		android.util.Log.d("leak-220-1", dataLeAk220);
		android.util.Log.d("leak-222-1", dataLeAk222);
		android.util.Log.d("leak-224-1", dataLeAk224);
		android.util.Log.d("leak-225-1", dataLeAk225);
		android.util.Log.d("leak-226-1", dataLeAk226);
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
		dataLeAk172 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-170-2", dataLeAk170);
		android.util.Log.d("leak-171-2", dataLeAk171);
		android.util.Log.d("leak-172-2", dataLeAk172);
		android.util.Log.d("leak-173-2", dataLeAk173);
		android.util.Log.d("leak-174-2", dataLeAk174);
		android.util.Log.d("leak-175-2", dataLeAk175);
		android.util.Log.d("leak-176-2", dataLeAk176);
		android.util.Log.d("leak-177-2", dataLeAk177);
		android.util.Log.d("leak-178-2", dataLeAk178);
		android.util.Log.d("leak-180-2", dataLeAk180);
		android.util.Log.d("leak-182-2", dataLeAk182);
		android.util.Log.d("leak-184-2", dataLeAk184);
		android.util.Log.d("leak-186-2", dataLeAk186);
		android.util.Log.d("leak-188-2", dataLeAk188);
		android.util.Log.d("leak-190-2", dataLeAk190);
		android.util.Log.d("leak-192-2", dataLeAk192);
		android.util.Log.d("leak-194-2", dataLeAk194);
		android.util.Log.d("leak-196-2", dataLeAk196);
		android.util.Log.d("leak-198-2", dataLeAk198);
		android.util.Log.d("leak-200-2", dataLeAk200);
		android.util.Log.d("leak-202-2", dataLeAk202);
		android.util.Log.d("leak-204-2", dataLeAk204);
		android.util.Log.d("leak-207-2", dataLeAk207);
		android.util.Log.d("leak-210-2", dataLeAk210);
		android.util.Log.d("leak-212-2", dataLeAk212);
		android.util.Log.d("leak-214-2", dataLeAk214);
		android.util.Log.d("leak-216-2", dataLeAk216);
		android.util.Log.d("leak-218-2", dataLeAk218);
		android.util.Log.d("leak-220-2", dataLeAk220);
		android.util.Log.d("leak-222-2", dataLeAk222);
		android.util.Log.d("leak-224-2", dataLeAk224);
		android.util.Log.d("leak-225-2", dataLeAk225);
		android.util.Log.d("leak-226-2", dataLeAk226);
        getListView().invalidate();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
		dataLeAk173 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-170-3", dataLeAk170);
		android.util.Log.d("leak-171-3", dataLeAk171);
		android.util.Log.d("leak-172-3", dataLeAk172);
		android.util.Log.d("leak-173-3", dataLeAk173);
		android.util.Log.d("leak-174-3", dataLeAk174);
		android.util.Log.d("leak-175-3", dataLeAk175);
		android.util.Log.d("leak-176-3", dataLeAk176);
		android.util.Log.d("leak-177-3", dataLeAk177);
		android.util.Log.d("leak-178-3", dataLeAk178);
		android.util.Log.d("leak-180-3", dataLeAk180);
		android.util.Log.d("leak-182-3", dataLeAk182);
		android.util.Log.d("leak-184-3", dataLeAk184);
		android.util.Log.d("leak-186-3", dataLeAk186);
		android.util.Log.d("leak-188-3", dataLeAk188);
		android.util.Log.d("leak-190-3", dataLeAk190);
		android.util.Log.d("leak-192-3", dataLeAk192);
		android.util.Log.d("leak-194-3", dataLeAk194);
		android.util.Log.d("leak-196-3", dataLeAk196);
		android.util.Log.d("leak-198-3", dataLeAk198);
		android.util.Log.d("leak-200-3", dataLeAk200);
		android.util.Log.d("leak-202-3", dataLeAk202);
		android.util.Log.d("leak-204-3", dataLeAk204);
		android.util.Log.d("leak-207-3", dataLeAk207);
		android.util.Log.d("leak-210-3", dataLeAk210);
		android.util.Log.d("leak-212-3", dataLeAk212);
		android.util.Log.d("leak-214-3", dataLeAk214);
		android.util.Log.d("leak-216-3", dataLeAk216);
		android.util.Log.d("leak-218-3", dataLeAk218);
		android.util.Log.d("leak-220-3", dataLeAk220);
		android.util.Log.d("leak-222-3", dataLeAk222);
		android.util.Log.d("leak-224-3", dataLeAk224);
		android.util.Log.d("leak-225-3", dataLeAk225);
		android.util.Log.d("leak-226-3", dataLeAk226);
        menu.add(0, ADD_TIME, 0, R.string.add_time_title).setIcon(android.R.drawable.ic_menu_add);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem i) {
        dataLeAk174 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-170-4", dataLeAk170);
		android.util.Log.d("leak-171-4", dataLeAk171);
		android.util.Log.d("leak-172-4", dataLeAk172);
		android.util.Log.d("leak-173-4", dataLeAk173);
		android.util.Log.d("leak-174-4", dataLeAk174);
		android.util.Log.d("leak-175-4", dataLeAk175);
		android.util.Log.d("leak-176-4", dataLeAk176);
		android.util.Log.d("leak-177-4", dataLeAk177);
		android.util.Log.d("leak-178-4", dataLeAk178);
		android.util.Log.d("leak-180-4", dataLeAk180);
		android.util.Log.d("leak-182-4", dataLeAk182);
		android.util.Log.d("leak-184-4", dataLeAk184);
		android.util.Log.d("leak-186-4", dataLeAk186);
		android.util.Log.d("leak-188-4", dataLeAk188);
		android.util.Log.d("leak-190-4", dataLeAk190);
		android.util.Log.d("leak-192-4", dataLeAk192);
		android.util.Log.d("leak-194-4", dataLeAk194);
		android.util.Log.d("leak-196-4", dataLeAk196);
		android.util.Log.d("leak-198-4", dataLeAk198);
		android.util.Log.d("leak-200-4", dataLeAk200);
		android.util.Log.d("leak-202-4", dataLeAk202);
		android.util.Log.d("leak-204-4", dataLeAk204);
		android.util.Log.d("leak-207-4", dataLeAk207);
		android.util.Log.d("leak-210-4", dataLeAk210);
		android.util.Log.d("leak-212-4", dataLeAk212);
		android.util.Log.d("leak-214-4", dataLeAk214);
		android.util.Log.d("leak-216-4", dataLeAk216);
		android.util.Log.d("leak-218-4", dataLeAk218);
		android.util.Log.d("leak-220-4", dataLeAk220);
		android.util.Log.d("leak-222-4", dataLeAk222);
		android.util.Log.d("leak-224-4", dataLeAk224);
		android.util.Log.d("leak-225-4", dataLeAk225);
		android.util.Log.d("leak-226-4", dataLeAk226);
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
        dataLeAk175 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-170-5", dataLeAk170);
		android.util.Log.d("leak-171-5", dataLeAk171);
		android.util.Log.d("leak-172-5", dataLeAk172);
		android.util.Log.d("leak-173-5", dataLeAk173);
		android.util.Log.d("leak-174-5", dataLeAk174);
		android.util.Log.d("leak-175-5", dataLeAk175);
		android.util.Log.d("leak-176-5", dataLeAk176);
		android.util.Log.d("leak-177-5", dataLeAk177);
		android.util.Log.d("leak-178-5", dataLeAk178);
		android.util.Log.d("leak-180-5", dataLeAk180);
		android.util.Log.d("leak-182-5", dataLeAk182);
		android.util.Log.d("leak-184-5", dataLeAk184);
		android.util.Log.d("leak-186-5", dataLeAk186);
		android.util.Log.d("leak-188-5", dataLeAk188);
		android.util.Log.d("leak-190-5", dataLeAk190);
		android.util.Log.d("leak-192-5", dataLeAk192);
		android.util.Log.d("leak-194-5", dataLeAk194);
		android.util.Log.d("leak-196-5", dataLeAk196);
		android.util.Log.d("leak-198-5", dataLeAk198);
		android.util.Log.d("leak-200-5", dataLeAk200);
		android.util.Log.d("leak-202-5", dataLeAk202);
		android.util.Log.d("leak-204-5", dataLeAk204);
		android.util.Log.d("leak-207-5", dataLeAk207);
		android.util.Log.d("leak-210-5", dataLeAk210);
		android.util.Log.d("leak-212-5", dataLeAk212);
		android.util.Log.d("leak-214-5", dataLeAk214);
		android.util.Log.d("leak-216-5", dataLeAk216);
		android.util.Log.d("leak-218-5", dataLeAk218);
		android.util.Log.d("leak-220-5", dataLeAk220);
		android.util.Log.d("leak-222-5", dataLeAk222);
		android.util.Log.d("leak-224-5", dataLeAk224);
		android.util.Log.d("leak-225-5", dataLeAk225);
		android.util.Log.d("leak-226-5", dataLeAk226);
		menu.setHeaderTitle("Time menu");
        menu.add(0, EDIT_TIME, 0, "Edit Time");
        menu.add(0, DELETE_TIME, 0, "Delete Time");
        menu.add(0, MOVE_TIME, 0, "Move Time");
    }
    private TimeRange selectedRange;

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        dataLeAk176 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-170-6", dataLeAk170);
		android.util.Log.d("leak-171-6", dataLeAk171);
		android.util.Log.d("leak-172-6", dataLeAk172);
		android.util.Log.d("leak-173-6", dataLeAk173);
		android.util.Log.d("leak-174-6", dataLeAk174);
		android.util.Log.d("leak-175-6", dataLeAk175);
		android.util.Log.d("leak-176-6", dataLeAk176);
		android.util.Log.d("leak-177-6", dataLeAk177);
		android.util.Log.d("leak-178-6", dataLeAk178);
		android.util.Log.d("leak-180-6", dataLeAk180);
		android.util.Log.d("leak-182-6", dataLeAk182);
		android.util.Log.d("leak-184-6", dataLeAk184);
		android.util.Log.d("leak-186-6", dataLeAk186);
		android.util.Log.d("leak-188-6", dataLeAk188);
		android.util.Log.d("leak-190-6", dataLeAk190);
		android.util.Log.d("leak-192-6", dataLeAk192);
		android.util.Log.d("leak-194-6", dataLeAk194);
		android.util.Log.d("leak-196-6", dataLeAk196);
		android.util.Log.d("leak-198-6", dataLeAk198);
		android.util.Log.d("leak-200-6", dataLeAk200);
		android.util.Log.d("leak-202-6", dataLeAk202);
		android.util.Log.d("leak-204-6", dataLeAk204);
		android.util.Log.d("leak-207-6", dataLeAk207);
		android.util.Log.d("leak-210-6", dataLeAk210);
		android.util.Log.d("leak-212-6", dataLeAk212);
		android.util.Log.d("leak-214-6", dataLeAk214);
		android.util.Log.d("leak-216-6", dataLeAk216);
		android.util.Log.d("leak-218-6", dataLeAk218);
		android.util.Log.d("leak-220-6", dataLeAk220);
		android.util.Log.d("leak-222-6", dataLeAk222);
		android.util.Log.d("leak-224-6", dataLeAk224);
		android.util.Log.d("leak-225-6", dataLeAk225);
		android.util.Log.d("leak-226-6", dataLeAk226);
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
        dataLeAk177 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-170-7", dataLeAk170);
		android.util.Log.d("leak-171-7", dataLeAk171);
		android.util.Log.d("leak-172-7", dataLeAk172);
		android.util.Log.d("leak-173-7", dataLeAk173);
		android.util.Log.d("leak-174-7", dataLeAk174);
		android.util.Log.d("leak-175-7", dataLeAk175);
		android.util.Log.d("leak-176-7", dataLeAk176);
		android.util.Log.d("leak-177-7", dataLeAk177);
		android.util.Log.d("leak-178-7", dataLeAk178);
		android.util.Log.d("leak-180-7", dataLeAk180);
		android.util.Log.d("leak-182-7", dataLeAk182);
		android.util.Log.d("leak-184-7", dataLeAk184);
		android.util.Log.d("leak-186-7", dataLeAk186);
		android.util.Log.d("leak-188-7", dataLeAk188);
		android.util.Log.d("leak-190-7", dataLeAk190);
		android.util.Log.d("leak-192-7", dataLeAk192);
		android.util.Log.d("leak-194-7", dataLeAk194);
		android.util.Log.d("leak-196-7", dataLeAk196);
		android.util.Log.d("leak-198-7", dataLeAk198);
		android.util.Log.d("leak-200-7", dataLeAk200);
		android.util.Log.d("leak-202-7", dataLeAk202);
		android.util.Log.d("leak-204-7", dataLeAk204);
		android.util.Log.d("leak-207-7", dataLeAk207);
		android.util.Log.d("leak-210-7", dataLeAk210);
		android.util.Log.d("leak-212-7", dataLeAk212);
		android.util.Log.d("leak-214-7", dataLeAk214);
		android.util.Log.d("leak-216-7", dataLeAk216);
		android.util.Log.d("leak-218-7", dataLeAk218);
		android.util.Log.d("leak-220-7", dataLeAk220);
		android.util.Log.d("leak-222-7", dataLeAk222);
		android.util.Log.d("leak-224-7", dataLeAk224);
		android.util.Log.d("leak-225-7", dataLeAk225);
		android.util.Log.d("leak-226-7", dataLeAk226);
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
        dataLeAk178 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-170-8", dataLeAk170);
		android.util.Log.d("leak-171-8", dataLeAk171);
		android.util.Log.d("leak-172-8", dataLeAk172);
		android.util.Log.d("leak-173-8", dataLeAk173);
		android.util.Log.d("leak-174-8", dataLeAk174);
		android.util.Log.d("leak-175-8", dataLeAk175);
		android.util.Log.d("leak-176-8", dataLeAk176);
		android.util.Log.d("leak-177-8", dataLeAk177);
		android.util.Log.d("leak-178-8", dataLeAk178);
		android.util.Log.d("leak-180-8", dataLeAk180);
		android.util.Log.d("leak-182-8", dataLeAk182);
		android.util.Log.d("leak-184-8", dataLeAk184);
		android.util.Log.d("leak-186-8", dataLeAk186);
		android.util.Log.d("leak-188-8", dataLeAk188);
		android.util.Log.d("leak-190-8", dataLeAk190);
		android.util.Log.d("leak-192-8", dataLeAk192);
		android.util.Log.d("leak-194-8", dataLeAk194);
		android.util.Log.d("leak-196-8", dataLeAk196);
		android.util.Log.d("leak-198-8", dataLeAk198);
		android.util.Log.d("leak-200-8", dataLeAk200);
		android.util.Log.d("leak-202-8", dataLeAk202);
		android.util.Log.d("leak-204-8", dataLeAk204);
		android.util.Log.d("leak-207-8", dataLeAk207);
		android.util.Log.d("leak-210-8", dataLeAk210);
		android.util.Log.d("leak-212-8", dataLeAk212);
		android.util.Log.d("leak-214-8", dataLeAk214);
		android.util.Log.d("leak-216-8", dataLeAk216);
		android.util.Log.d("leak-218-8", dataLeAk218);
		android.util.Log.d("leak-220-8", dataLeAk220);
		android.util.Log.d("leak-222-8", dataLeAk222);
		android.util.Log.d("leak-224-8", dataLeAk224);
		android.util.Log.d("leak-225-8", dataLeAk225);
		android.util.Log.d("leak-226-8", dataLeAk226);
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

        String dataLeAk223 = "";

		String dataLeAk221 = "";

		String dataLeAk219 = "";

		String dataLeAk217 = "";

		String dataLeAk215 = "";

		String dataLeAk213 = "";

		String dataLeAk211 = "";

		String dataLeAk209 = "";

		String dataLeAk206 = "";

		String dataLeAk203 = "";

		String dataLeAk201 = "";

		String dataLeAk199 = "";

		String dataLeAk197 = "";

		String dataLeAk195 = "";

		String dataLeAk193 = "";

		String dataLeAk191 = "";

		String dataLeAk189 = "";

		String dataLeAk187 = "";

		String dataLeAk185 = "";

		String dataLeAk183 = "";

		String dataLeAk181 = "";

		String dataLeAk179 = "";

		private final Context savedContext;
        private final DBHelper dbHelper;
        private final ArrayList<TimeRange> times;

        public TimesAdapter(Context c) {
            dataLeAk180 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk179 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-170-9", dataLeAk170);
			android.util.Log.d("leak-171-9", dataLeAk171);
			android.util.Log.d("leak-172-9", dataLeAk172);
			android.util.Log.d("leak-173-9", dataLeAk173);
			android.util.Log.d("leak-174-9", dataLeAk174);
			android.util.Log.d("leak-175-9", dataLeAk175);
			android.util.Log.d("leak-176-9", dataLeAk176);
			android.util.Log.d("leak-177-9", dataLeAk177);
			android.util.Log.d("leak-178-9", dataLeAk178);
			android.util.Log.d("leak-180-9", dataLeAk180);
			android.util.Log.d("leak-182-9", dataLeAk182);
			android.util.Log.d("leak-184-9", dataLeAk184);
			android.util.Log.d("leak-186-9", dataLeAk186);
			android.util.Log.d("leak-188-9", dataLeAk188);
			android.util.Log.d("leak-190-9", dataLeAk190);
			android.util.Log.d("leak-192-9", dataLeAk192);
			android.util.Log.d("leak-194-9", dataLeAk194);
			android.util.Log.d("leak-196-9", dataLeAk196);
			android.util.Log.d("leak-198-9", dataLeAk198);
			android.util.Log.d("leak-200-9", dataLeAk200);
			android.util.Log.d("leak-202-9", dataLeAk202);
			android.util.Log.d("leak-204-9", dataLeAk204);
			android.util.Log.d("leak-207-9", dataLeAk207);
			android.util.Log.d("leak-210-9", dataLeAk210);
			android.util.Log.d("leak-212-9", dataLeAk212);
			android.util.Log.d("leak-214-9", dataLeAk214);
			android.util.Log.d("leak-216-9", dataLeAk216);
			android.util.Log.d("leak-218-9", dataLeAk218);
			android.util.Log.d("leak-220-9", dataLeAk220);
			android.util.Log.d("leak-222-9", dataLeAk222);
			android.util.Log.d("leak-224-9", dataLeAk224);
			android.util.Log.d("leak-225-9", dataLeAk225);
			android.util.Log.d("leak-226-9", dataLeAk226);
			android.util.Log.d("leak-179-0", dataLeAk179);
			android.util.Log.d("leak-181-0", dataLeAk181);
			android.util.Log.d("leak-183-0", dataLeAk183);
			android.util.Log.d("leak-185-0", dataLeAk185);
			android.util.Log.d("leak-187-0", dataLeAk187);
			android.util.Log.d("leak-189-0", dataLeAk189);
			android.util.Log.d("leak-191-0", dataLeAk191);
			android.util.Log.d("leak-193-0", dataLeAk193);
			android.util.Log.d("leak-195-0", dataLeAk195);
			android.util.Log.d("leak-197-0", dataLeAk197);
			android.util.Log.d("leak-199-0", dataLeAk199);
			android.util.Log.d("leak-201-0", dataLeAk201);
			android.util.Log.d("leak-203-0", dataLeAk203);
			android.util.Log.d("leak-206-0", dataLeAk206);
			android.util.Log.d("leak-209-0", dataLeAk209);
			android.util.Log.d("leak-211-0", dataLeAk211);
			android.util.Log.d("leak-213-0", dataLeAk213);
			android.util.Log.d("leak-215-0", dataLeAk215);
			android.util.Log.d("leak-217-0", dataLeAk217);
			android.util.Log.d("leak-219-0", dataLeAk219);
			android.util.Log.d("leak-221-0", dataLeAk221);
			android.util.Log.d("leak-223-0", dataLeAk223);
			savedContext = c;
            dbHelper = new DBHelper(c);
            dbHelper.getWritableDatabase();
            times = new ArrayList<TimeRange>();
        }

        @Override
        public boolean areAllItemsEnabled() {
            dataLeAk182 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk181 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-170-10", dataLeAk170);
			android.util.Log.d("leak-171-10", dataLeAk171);
			android.util.Log.d("leak-172-10", dataLeAk172);
			android.util.Log.d("leak-173-10", dataLeAk173);
			android.util.Log.d("leak-174-10", dataLeAk174);
			android.util.Log.d("leak-175-10", dataLeAk175);
			android.util.Log.d("leak-176-10", dataLeAk176);
			android.util.Log.d("leak-177-10", dataLeAk177);
			android.util.Log.d("leak-178-10", dataLeAk178);
			android.util.Log.d("leak-180-10", dataLeAk180);
			android.util.Log.d("leak-182-10", dataLeAk182);
			android.util.Log.d("leak-184-10", dataLeAk184);
			android.util.Log.d("leak-186-10", dataLeAk186);
			android.util.Log.d("leak-188-10", dataLeAk188);
			android.util.Log.d("leak-190-10", dataLeAk190);
			android.util.Log.d("leak-192-10", dataLeAk192);
			android.util.Log.d("leak-194-10", dataLeAk194);
			android.util.Log.d("leak-196-10", dataLeAk196);
			android.util.Log.d("leak-198-10", dataLeAk198);
			android.util.Log.d("leak-200-10", dataLeAk200);
			android.util.Log.d("leak-202-10", dataLeAk202);
			android.util.Log.d("leak-204-10", dataLeAk204);
			android.util.Log.d("leak-207-10", dataLeAk207);
			android.util.Log.d("leak-210-10", dataLeAk210);
			android.util.Log.d("leak-212-10", dataLeAk212);
			android.util.Log.d("leak-214-10", dataLeAk214);
			android.util.Log.d("leak-216-10", dataLeAk216);
			android.util.Log.d("leak-218-10", dataLeAk218);
			android.util.Log.d("leak-220-10", dataLeAk220);
			android.util.Log.d("leak-222-10", dataLeAk222);
			android.util.Log.d("leak-224-10", dataLeAk224);
			android.util.Log.d("leak-225-10", dataLeAk225);
			android.util.Log.d("leak-226-10", dataLeAk226);
			android.util.Log.d("leak-179-1", dataLeAk179);
			android.util.Log.d("leak-181-1", dataLeAk181);
			android.util.Log.d("leak-183-1", dataLeAk183);
			android.util.Log.d("leak-185-1", dataLeAk185);
			android.util.Log.d("leak-187-1", dataLeAk187);
			android.util.Log.d("leak-189-1", dataLeAk189);
			android.util.Log.d("leak-191-1", dataLeAk191);
			android.util.Log.d("leak-193-1", dataLeAk193);
			android.util.Log.d("leak-195-1", dataLeAk195);
			android.util.Log.d("leak-197-1", dataLeAk197);
			android.util.Log.d("leak-199-1", dataLeAk199);
			android.util.Log.d("leak-201-1", dataLeAk201);
			android.util.Log.d("leak-203-1", dataLeAk203);
			android.util.Log.d("leak-206-1", dataLeAk206);
			android.util.Log.d("leak-209-1", dataLeAk209);
			android.util.Log.d("leak-211-1", dataLeAk211);
			android.util.Log.d("leak-213-1", dataLeAk213);
			android.util.Log.d("leak-215-1", dataLeAk215);
			android.util.Log.d("leak-217-1", dataLeAk217);
			android.util.Log.d("leak-219-1", dataLeAk219);
			android.util.Log.d("leak-221-1", dataLeAk221);
			android.util.Log.d("leak-223-1", dataLeAk223);
			return false;
        }

        @Override
        public boolean isEnabled(int position) {
            dataLeAk184 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk183 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-170-11", dataLeAk170);
			android.util.Log.d("leak-171-11", dataLeAk171);
			android.util.Log.d("leak-172-11", dataLeAk172);
			android.util.Log.d("leak-173-11", dataLeAk173);
			android.util.Log.d("leak-174-11", dataLeAk174);
			android.util.Log.d("leak-175-11", dataLeAk175);
			android.util.Log.d("leak-176-11", dataLeAk176);
			android.util.Log.d("leak-177-11", dataLeAk177);
			android.util.Log.d("leak-178-11", dataLeAk178);
			android.util.Log.d("leak-180-11", dataLeAk180);
			android.util.Log.d("leak-182-11", dataLeAk182);
			android.util.Log.d("leak-184-11", dataLeAk184);
			android.util.Log.d("leak-186-11", dataLeAk186);
			android.util.Log.d("leak-188-11", dataLeAk188);
			android.util.Log.d("leak-190-11", dataLeAk190);
			android.util.Log.d("leak-192-11", dataLeAk192);
			android.util.Log.d("leak-194-11", dataLeAk194);
			android.util.Log.d("leak-196-11", dataLeAk196);
			android.util.Log.d("leak-198-11", dataLeAk198);
			android.util.Log.d("leak-200-11", dataLeAk200);
			android.util.Log.d("leak-202-11", dataLeAk202);
			android.util.Log.d("leak-204-11", dataLeAk204);
			android.util.Log.d("leak-207-11", dataLeAk207);
			android.util.Log.d("leak-210-11", dataLeAk210);
			android.util.Log.d("leak-212-11", dataLeAk212);
			android.util.Log.d("leak-214-11", dataLeAk214);
			android.util.Log.d("leak-216-11", dataLeAk216);
			android.util.Log.d("leak-218-11", dataLeAk218);
			android.util.Log.d("leak-220-11", dataLeAk220);
			android.util.Log.d("leak-222-11", dataLeAk222);
			android.util.Log.d("leak-224-11", dataLeAk224);
			android.util.Log.d("leak-225-11", dataLeAk225);
			android.util.Log.d("leak-226-11", dataLeAk226);
			android.util.Log.d("leak-179-2", dataLeAk179);
			android.util.Log.d("leak-181-2", dataLeAk181);
			android.util.Log.d("leak-183-2", dataLeAk183);
			android.util.Log.d("leak-185-2", dataLeAk185);
			android.util.Log.d("leak-187-2", dataLeAk187);
			android.util.Log.d("leak-189-2", dataLeAk189);
			android.util.Log.d("leak-191-2", dataLeAk191);
			android.util.Log.d("leak-193-2", dataLeAk193);
			android.util.Log.d("leak-195-2", dataLeAk195);
			android.util.Log.d("leak-197-2", dataLeAk197);
			android.util.Log.d("leak-199-2", dataLeAk199);
			android.util.Log.d("leak-201-2", dataLeAk201);
			android.util.Log.d("leak-203-2", dataLeAk203);
			android.util.Log.d("leak-206-2", dataLeAk206);
			android.util.Log.d("leak-209-2", dataLeAk209);
			android.util.Log.d("leak-211-2", dataLeAk211);
			android.util.Log.d("leak-213-2", dataLeAk213);
			android.util.Log.d("leak-215-2", dataLeAk215);
			android.util.Log.d("leak-217-2", dataLeAk217);
			android.util.Log.d("leak-219-2", dataLeAk219);
			android.util.Log.d("leak-221-2", dataLeAk221);
			android.util.Log.d("leak-223-2", dataLeAk223);
			return times.get(position).getEnd() != SEP;
        }

        public void close() {
            dataLeAk186 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk185 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-170-12", dataLeAk170);
			android.util.Log.d("leak-171-12", dataLeAk171);
			android.util.Log.d("leak-172-12", dataLeAk172);
			android.util.Log.d("leak-173-12", dataLeAk173);
			android.util.Log.d("leak-174-12", dataLeAk174);
			android.util.Log.d("leak-175-12", dataLeAk175);
			android.util.Log.d("leak-176-12", dataLeAk176);
			android.util.Log.d("leak-177-12", dataLeAk177);
			android.util.Log.d("leak-178-12", dataLeAk178);
			android.util.Log.d("leak-180-12", dataLeAk180);
			android.util.Log.d("leak-182-12", dataLeAk182);
			android.util.Log.d("leak-184-12", dataLeAk184);
			android.util.Log.d("leak-186-12", dataLeAk186);
			android.util.Log.d("leak-188-12", dataLeAk188);
			android.util.Log.d("leak-190-12", dataLeAk190);
			android.util.Log.d("leak-192-12", dataLeAk192);
			android.util.Log.d("leak-194-12", dataLeAk194);
			android.util.Log.d("leak-196-12", dataLeAk196);
			android.util.Log.d("leak-198-12", dataLeAk198);
			android.util.Log.d("leak-200-12", dataLeAk200);
			android.util.Log.d("leak-202-12", dataLeAk202);
			android.util.Log.d("leak-204-12", dataLeAk204);
			android.util.Log.d("leak-207-12", dataLeAk207);
			android.util.Log.d("leak-210-12", dataLeAk210);
			android.util.Log.d("leak-212-12", dataLeAk212);
			android.util.Log.d("leak-214-12", dataLeAk214);
			android.util.Log.d("leak-216-12", dataLeAk216);
			android.util.Log.d("leak-218-12", dataLeAk218);
			android.util.Log.d("leak-220-12", dataLeAk220);
			android.util.Log.d("leak-222-12", dataLeAk222);
			android.util.Log.d("leak-224-12", dataLeAk224);
			android.util.Log.d("leak-225-12", dataLeAk225);
			android.util.Log.d("leak-226-12", dataLeAk226);
			android.util.Log.d("leak-179-3", dataLeAk179);
			android.util.Log.d("leak-181-3", dataLeAk181);
			android.util.Log.d("leak-183-3", dataLeAk183);
			android.util.Log.d("leak-185-3", dataLeAk185);
			android.util.Log.d("leak-187-3", dataLeAk187);
			android.util.Log.d("leak-189-3", dataLeAk189);
			android.util.Log.d("leak-191-3", dataLeAk191);
			android.util.Log.d("leak-193-3", dataLeAk193);
			android.util.Log.d("leak-195-3", dataLeAk195);
			android.util.Log.d("leak-197-3", dataLeAk197);
			android.util.Log.d("leak-199-3", dataLeAk199);
			android.util.Log.d("leak-201-3", dataLeAk201);
			android.util.Log.d("leak-203-3", dataLeAk203);
			android.util.Log.d("leak-206-3", dataLeAk206);
			android.util.Log.d("leak-209-3", dataLeAk209);
			android.util.Log.d("leak-211-3", dataLeAk211);
			android.util.Log.d("leak-213-3", dataLeAk213);
			android.util.Log.d("leak-215-3", dataLeAk215);
			android.util.Log.d("leak-217-3", dataLeAk217);
			android.util.Log.d("leak-219-3", dataLeAk219);
			android.util.Log.d("leak-221-3", dataLeAk221);
			android.util.Log.d("leak-223-3", dataLeAk223);
			dbHelper.close();
        }

        public void deleteTimeRange(TimeRange range) {
            dataLeAk188 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk187 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-170-13", dataLeAk170);
			android.util.Log.d("leak-171-13", dataLeAk171);
			android.util.Log.d("leak-172-13", dataLeAk172);
			android.util.Log.d("leak-173-13", dataLeAk173);
			android.util.Log.d("leak-174-13", dataLeAk174);
			android.util.Log.d("leak-175-13", dataLeAk175);
			android.util.Log.d("leak-176-13", dataLeAk176);
			android.util.Log.d("leak-177-13", dataLeAk177);
			android.util.Log.d("leak-178-13", dataLeAk178);
			android.util.Log.d("leak-180-13", dataLeAk180);
			android.util.Log.d("leak-182-13", dataLeAk182);
			android.util.Log.d("leak-184-13", dataLeAk184);
			android.util.Log.d("leak-186-13", dataLeAk186);
			android.util.Log.d("leak-188-13", dataLeAk188);
			android.util.Log.d("leak-190-13", dataLeAk190);
			android.util.Log.d("leak-192-13", dataLeAk192);
			android.util.Log.d("leak-194-13", dataLeAk194);
			android.util.Log.d("leak-196-13", dataLeAk196);
			android.util.Log.d("leak-198-13", dataLeAk198);
			android.util.Log.d("leak-200-13", dataLeAk200);
			android.util.Log.d("leak-202-13", dataLeAk202);
			android.util.Log.d("leak-204-13", dataLeAk204);
			android.util.Log.d("leak-207-13", dataLeAk207);
			android.util.Log.d("leak-210-13", dataLeAk210);
			android.util.Log.d("leak-212-13", dataLeAk212);
			android.util.Log.d("leak-214-13", dataLeAk214);
			android.util.Log.d("leak-216-13", dataLeAk216);
			android.util.Log.d("leak-218-13", dataLeAk218);
			android.util.Log.d("leak-220-13", dataLeAk220);
			android.util.Log.d("leak-222-13", dataLeAk222);
			android.util.Log.d("leak-224-13", dataLeAk224);
			android.util.Log.d("leak-225-13", dataLeAk225);
			android.util.Log.d("leak-226-13", dataLeAk226);
			android.util.Log.d("leak-179-4", dataLeAk179);
			android.util.Log.d("leak-181-4", dataLeAk181);
			android.util.Log.d("leak-183-4", dataLeAk183);
			android.util.Log.d("leak-185-4", dataLeAk185);
			android.util.Log.d("leak-187-4", dataLeAk187);
			android.util.Log.d("leak-189-4", dataLeAk189);
			android.util.Log.d("leak-191-4", dataLeAk191);
			android.util.Log.d("leak-193-4", dataLeAk193);
			android.util.Log.d("leak-195-4", dataLeAk195);
			android.util.Log.d("leak-197-4", dataLeAk197);
			android.util.Log.d("leak-199-4", dataLeAk199);
			android.util.Log.d("leak-201-4", dataLeAk201);
			android.util.Log.d("leak-203-4", dataLeAk203);
			android.util.Log.d("leak-206-4", dataLeAk206);
			android.util.Log.d("leak-209-4", dataLeAk209);
			android.util.Log.d("leak-211-4", dataLeAk211);
			android.util.Log.d("leak-213-4", dataLeAk213);
			android.util.Log.d("leak-215-4", dataLeAk215);
			android.util.Log.d("leak-217-4", dataLeAk217);
			android.util.Log.d("leak-219-4", dataLeAk219);
			android.util.Log.d("leak-221-4", dataLeAk221);
			android.util.Log.d("leak-223-4", dataLeAk223);
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
            dataLeAk190 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk189 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-170-14", dataLeAk170);
			android.util.Log.d("leak-171-14", dataLeAk171);
			android.util.Log.d("leak-172-14", dataLeAk172);
			android.util.Log.d("leak-173-14", dataLeAk173);
			android.util.Log.d("leak-174-14", dataLeAk174);
			android.util.Log.d("leak-175-14", dataLeAk175);
			android.util.Log.d("leak-176-14", dataLeAk176);
			android.util.Log.d("leak-177-14", dataLeAk177);
			android.util.Log.d("leak-178-14", dataLeAk178);
			android.util.Log.d("leak-180-14", dataLeAk180);
			android.util.Log.d("leak-182-14", dataLeAk182);
			android.util.Log.d("leak-184-14", dataLeAk184);
			android.util.Log.d("leak-186-14", dataLeAk186);
			android.util.Log.d("leak-188-14", dataLeAk188);
			android.util.Log.d("leak-190-14", dataLeAk190);
			android.util.Log.d("leak-192-14", dataLeAk192);
			android.util.Log.d("leak-194-14", dataLeAk194);
			android.util.Log.d("leak-196-14", dataLeAk196);
			android.util.Log.d("leak-198-14", dataLeAk198);
			android.util.Log.d("leak-200-14", dataLeAk200);
			android.util.Log.d("leak-202-14", dataLeAk202);
			android.util.Log.d("leak-204-14", dataLeAk204);
			android.util.Log.d("leak-207-14", dataLeAk207);
			android.util.Log.d("leak-210-14", dataLeAk210);
			android.util.Log.d("leak-212-14", dataLeAk212);
			android.util.Log.d("leak-214-14", dataLeAk214);
			android.util.Log.d("leak-216-14", dataLeAk216);
			android.util.Log.d("leak-218-14", dataLeAk218);
			android.util.Log.d("leak-220-14", dataLeAk220);
			android.util.Log.d("leak-222-14", dataLeAk222);
			android.util.Log.d("leak-224-14", dataLeAk224);
			android.util.Log.d("leak-225-14", dataLeAk225);
			android.util.Log.d("leak-226-14", dataLeAk226);
			android.util.Log.d("leak-179-5", dataLeAk179);
			android.util.Log.d("leak-181-5", dataLeAk181);
			android.util.Log.d("leak-183-5", dataLeAk183);
			android.util.Log.d("leak-185-5", dataLeAk185);
			android.util.Log.d("leak-187-5", dataLeAk187);
			android.util.Log.d("leak-189-5", dataLeAk189);
			android.util.Log.d("leak-191-5", dataLeAk191);
			android.util.Log.d("leak-193-5", dataLeAk193);
			android.util.Log.d("leak-195-5", dataLeAk195);
			android.util.Log.d("leak-197-5", dataLeAk197);
			android.util.Log.d("leak-199-5", dataLeAk199);
			android.util.Log.d("leak-201-5", dataLeAk201);
			android.util.Log.d("leak-203-5", dataLeAk203);
			android.util.Log.d("leak-206-5", dataLeAk206);
			android.util.Log.d("leak-209-5", dataLeAk209);
			android.util.Log.d("leak-211-5", dataLeAk211);
			android.util.Log.d("leak-213-5", dataLeAk213);
			android.util.Log.d("leak-215-5", dataLeAk215);
			android.util.Log.d("leak-217-5", dataLeAk217);
			android.util.Log.d("leak-219-5", dataLeAk219);
			android.util.Log.d("leak-221-5", dataLeAk221);
			android.util.Log.d("leak-223-5", dataLeAk223);
			loadTimes(ACTIVITY_ID + " = ?",
                    new String[]{String.valueOf(selectedActivityId)});
        }

        protected void loadTimes(int selectedActivityId, long start, long end) {
            dataLeAk192 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk191 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-170-15", dataLeAk170);
			android.util.Log.d("leak-171-15", dataLeAk171);
			android.util.Log.d("leak-172-15", dataLeAk172);
			android.util.Log.d("leak-173-15", dataLeAk173);
			android.util.Log.d("leak-174-15", dataLeAk174);
			android.util.Log.d("leak-175-15", dataLeAk175);
			android.util.Log.d("leak-176-15", dataLeAk176);
			android.util.Log.d("leak-177-15", dataLeAk177);
			android.util.Log.d("leak-178-15", dataLeAk178);
			android.util.Log.d("leak-180-15", dataLeAk180);
			android.util.Log.d("leak-182-15", dataLeAk182);
			android.util.Log.d("leak-184-15", dataLeAk184);
			android.util.Log.d("leak-186-15", dataLeAk186);
			android.util.Log.d("leak-188-15", dataLeAk188);
			android.util.Log.d("leak-190-15", dataLeAk190);
			android.util.Log.d("leak-192-15", dataLeAk192);
			android.util.Log.d("leak-194-15", dataLeAk194);
			android.util.Log.d("leak-196-15", dataLeAk196);
			android.util.Log.d("leak-198-15", dataLeAk198);
			android.util.Log.d("leak-200-15", dataLeAk200);
			android.util.Log.d("leak-202-15", dataLeAk202);
			android.util.Log.d("leak-204-15", dataLeAk204);
			android.util.Log.d("leak-207-15", dataLeAk207);
			android.util.Log.d("leak-210-15", dataLeAk210);
			android.util.Log.d("leak-212-15", dataLeAk212);
			android.util.Log.d("leak-214-15", dataLeAk214);
			android.util.Log.d("leak-216-15", dataLeAk216);
			android.util.Log.d("leak-218-15", dataLeAk218);
			android.util.Log.d("leak-220-15", dataLeAk220);
			android.util.Log.d("leak-222-15", dataLeAk222);
			android.util.Log.d("leak-224-15", dataLeAk224);
			android.util.Log.d("leak-225-15", dataLeAk225);
			android.util.Log.d("leak-226-15", dataLeAk226);
			android.util.Log.d("leak-179-6", dataLeAk179);
			android.util.Log.d("leak-181-6", dataLeAk181);
			android.util.Log.d("leak-183-6", dataLeAk183);
			android.util.Log.d("leak-185-6", dataLeAk185);
			android.util.Log.d("leak-187-6", dataLeAk187);
			android.util.Log.d("leak-189-6", dataLeAk189);
			android.util.Log.d("leak-191-6", dataLeAk191);
			android.util.Log.d("leak-193-6", dataLeAk193);
			android.util.Log.d("leak-195-6", dataLeAk195);
			android.util.Log.d("leak-197-6", dataLeAk197);
			android.util.Log.d("leak-199-6", dataLeAk199);
			android.util.Log.d("leak-201-6", dataLeAk201);
			android.util.Log.d("leak-203-6", dataLeAk203);
			android.util.Log.d("leak-206-6", dataLeAk206);
			android.util.Log.d("leak-209-6", dataLeAk209);
			android.util.Log.d("leak-211-6", dataLeAk211);
			android.util.Log.d("leak-213-6", dataLeAk213);
			android.util.Log.d("leak-215-6", dataLeAk215);
			android.util.Log.d("leak-217-6", dataLeAk217);
			android.util.Log.d("leak-219-6", dataLeAk219);
			android.util.Log.d("leak-221-6", dataLeAk221);
			android.util.Log.d("leak-223-6", dataLeAk223);
			loadTimes(ACTIVITY_ID + " = ? AND " + START + " < ? AND " + START + " > ?",
                    new String[]{String.valueOf(selectedActivityId),
                String.valueOf(end),
                String.valueOf(start)});
        }

        protected void loadTimes(String where, String[] args) {
            dataLeAk194 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk193 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-170-16", dataLeAk170);
			android.util.Log.d("leak-171-16", dataLeAk171);
			android.util.Log.d("leak-172-16", dataLeAk172);
			android.util.Log.d("leak-173-16", dataLeAk173);
			android.util.Log.d("leak-174-16", dataLeAk174);
			android.util.Log.d("leak-175-16", dataLeAk175);
			android.util.Log.d("leak-176-16", dataLeAk176);
			android.util.Log.d("leak-177-16", dataLeAk177);
			android.util.Log.d("leak-178-16", dataLeAk178);
			android.util.Log.d("leak-180-16", dataLeAk180);
			android.util.Log.d("leak-182-16", dataLeAk182);
			android.util.Log.d("leak-184-16", dataLeAk184);
			android.util.Log.d("leak-186-16", dataLeAk186);
			android.util.Log.d("leak-188-16", dataLeAk188);
			android.util.Log.d("leak-190-16", dataLeAk190);
			android.util.Log.d("leak-192-16", dataLeAk192);
			android.util.Log.d("leak-194-16", dataLeAk194);
			android.util.Log.d("leak-196-16", dataLeAk196);
			android.util.Log.d("leak-198-16", dataLeAk198);
			android.util.Log.d("leak-200-16", dataLeAk200);
			android.util.Log.d("leak-202-16", dataLeAk202);
			android.util.Log.d("leak-204-16", dataLeAk204);
			android.util.Log.d("leak-207-16", dataLeAk207);
			android.util.Log.d("leak-210-16", dataLeAk210);
			android.util.Log.d("leak-212-16", dataLeAk212);
			android.util.Log.d("leak-214-16", dataLeAk214);
			android.util.Log.d("leak-216-16", dataLeAk216);
			android.util.Log.d("leak-218-16", dataLeAk218);
			android.util.Log.d("leak-220-16", dataLeAk220);
			android.util.Log.d("leak-222-16", dataLeAk222);
			android.util.Log.d("leak-224-16", dataLeAk224);
			android.util.Log.d("leak-225-16", dataLeAk225);
			android.util.Log.d("leak-226-16", dataLeAk226);
			android.util.Log.d("leak-179-7", dataLeAk179);
			android.util.Log.d("leak-181-7", dataLeAk181);
			android.util.Log.d("leak-183-7", dataLeAk183);
			android.util.Log.d("leak-185-7", dataLeAk185);
			android.util.Log.d("leak-187-7", dataLeAk187);
			android.util.Log.d("leak-189-7", dataLeAk189);
			android.util.Log.d("leak-191-7", dataLeAk191);
			android.util.Log.d("leak-193-7", dataLeAk193);
			android.util.Log.d("leak-195-7", dataLeAk195);
			android.util.Log.d("leak-197-7", dataLeAk197);
			android.util.Log.d("leak-199-7", dataLeAk199);
			android.util.Log.d("leak-201-7", dataLeAk201);
			android.util.Log.d("leak-203-7", dataLeAk203);
			android.util.Log.d("leak-206-7", dataLeAk206);
			android.util.Log.d("leak-209-7", dataLeAk209);
			android.util.Log.d("leak-211-7", dataLeAk211);
			android.util.Log.d("leak-213-7", dataLeAk213);
			android.util.Log.d("leak-215-7", dataLeAk215);
			android.util.Log.d("leak-217-7", dataLeAk217);
			android.util.Log.d("leak-219-7", dataLeAk219);
			android.util.Log.d("leak-221-7", dataLeAk221);
			android.util.Log.d("leak-223-7", dataLeAk223);
			SQLiteDatabase db = dbHelper.getReadableDatabase();
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
            dataLeAk196 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk195 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-170-17", dataLeAk170);
			android.util.Log.d("leak-171-17", dataLeAk171);
			android.util.Log.d("leak-172-17", dataLeAk172);
			android.util.Log.d("leak-173-17", dataLeAk173);
			android.util.Log.d("leak-174-17", dataLeAk174);
			android.util.Log.d("leak-175-17", dataLeAk175);
			android.util.Log.d("leak-176-17", dataLeAk176);
			android.util.Log.d("leak-177-17", dataLeAk177);
			android.util.Log.d("leak-178-17", dataLeAk178);
			android.util.Log.d("leak-180-17", dataLeAk180);
			android.util.Log.d("leak-182-17", dataLeAk182);
			android.util.Log.d("leak-184-17", dataLeAk184);
			android.util.Log.d("leak-186-17", dataLeAk186);
			android.util.Log.d("leak-188-17", dataLeAk188);
			android.util.Log.d("leak-190-17", dataLeAk190);
			android.util.Log.d("leak-192-17", dataLeAk192);
			android.util.Log.d("leak-194-17", dataLeAk194);
			android.util.Log.d("leak-196-17", dataLeAk196);
			android.util.Log.d("leak-198-17", dataLeAk198);
			android.util.Log.d("leak-200-17", dataLeAk200);
			android.util.Log.d("leak-202-17", dataLeAk202);
			android.util.Log.d("leak-204-17", dataLeAk204);
			android.util.Log.d("leak-207-17", dataLeAk207);
			android.util.Log.d("leak-210-17", dataLeAk210);
			android.util.Log.d("leak-212-17", dataLeAk212);
			android.util.Log.d("leak-214-17", dataLeAk214);
			android.util.Log.d("leak-216-17", dataLeAk216);
			android.util.Log.d("leak-218-17", dataLeAk218);
			android.util.Log.d("leak-220-17", dataLeAk220);
			android.util.Log.d("leak-222-17", dataLeAk222);
			android.util.Log.d("leak-224-17", dataLeAk224);
			android.util.Log.d("leak-225-17", dataLeAk225);
			android.util.Log.d("leak-226-17", dataLeAk226);
			android.util.Log.d("leak-179-8", dataLeAk179);
			android.util.Log.d("leak-181-8", dataLeAk181);
			android.util.Log.d("leak-183-8", dataLeAk183);
			android.util.Log.d("leak-185-8", dataLeAk185);
			android.util.Log.d("leak-187-8", dataLeAk187);
			android.util.Log.d("leak-189-8", dataLeAk189);
			android.util.Log.d("leak-191-8", dataLeAk191);
			android.util.Log.d("leak-193-8", dataLeAk193);
			android.util.Log.d("leak-195-8", dataLeAk195);
			android.util.Log.d("leak-197-8", dataLeAk197);
			android.util.Log.d("leak-199-8", dataLeAk199);
			android.util.Log.d("leak-201-8", dataLeAk201);
			android.util.Log.d("leak-203-8", dataLeAk203);
			android.util.Log.d("leak-206-8", dataLeAk206);
			android.util.Log.d("leak-209-8", dataLeAk209);
			android.util.Log.d("leak-211-8", dataLeAk211);
			android.util.Log.d("leak-213-8", dataLeAk213);
			android.util.Log.d("leak-215-8", dataLeAk215);
			android.util.Log.d("leak-217-8", dataLeAk217);
			android.util.Log.d("leak-219-8", dataLeAk219);
			android.util.Log.d("leak-221-8", dataLeAk221);
			android.util.Log.d("leak-223-8", dataLeAk223);
			Object item = getItem(position);
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
            dataLeAk198 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk197 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-170-18", dataLeAk170);
			android.util.Log.d("leak-171-18", dataLeAk171);
			android.util.Log.d("leak-172-18", dataLeAk172);
			android.util.Log.d("leak-173-18", dataLeAk173);
			android.util.Log.d("leak-174-18", dataLeAk174);
			android.util.Log.d("leak-175-18", dataLeAk175);
			android.util.Log.d("leak-176-18", dataLeAk176);
			android.util.Log.d("leak-177-18", dataLeAk177);
			android.util.Log.d("leak-178-18", dataLeAk178);
			android.util.Log.d("leak-180-18", dataLeAk180);
			android.util.Log.d("leak-182-18", dataLeAk182);
			android.util.Log.d("leak-184-18", dataLeAk184);
			android.util.Log.d("leak-186-18", dataLeAk186);
			android.util.Log.d("leak-188-18", dataLeAk188);
			android.util.Log.d("leak-190-18", dataLeAk190);
			android.util.Log.d("leak-192-18", dataLeAk192);
			android.util.Log.d("leak-194-18", dataLeAk194);
			android.util.Log.d("leak-196-18", dataLeAk196);
			android.util.Log.d("leak-198-18", dataLeAk198);
			android.util.Log.d("leak-200-18", dataLeAk200);
			android.util.Log.d("leak-202-18", dataLeAk202);
			android.util.Log.d("leak-204-18", dataLeAk204);
			android.util.Log.d("leak-207-18", dataLeAk207);
			android.util.Log.d("leak-210-18", dataLeAk210);
			android.util.Log.d("leak-212-18", dataLeAk212);
			android.util.Log.d("leak-214-18", dataLeAk214);
			android.util.Log.d("leak-216-18", dataLeAk216);
			android.util.Log.d("leak-218-18", dataLeAk218);
			android.util.Log.d("leak-220-18", dataLeAk220);
			android.util.Log.d("leak-222-18", dataLeAk222);
			android.util.Log.d("leak-224-18", dataLeAk224);
			android.util.Log.d("leak-225-18", dataLeAk225);
			android.util.Log.d("leak-226-18", dataLeAk226);
			android.util.Log.d("leak-179-9", dataLeAk179);
			android.util.Log.d("leak-181-9", dataLeAk181);
			android.util.Log.d("leak-183-9", dataLeAk183);
			android.util.Log.d("leak-185-9", dataLeAk185);
			android.util.Log.d("leak-187-9", dataLeAk187);
			android.util.Log.d("leak-189-9", dataLeAk189);
			android.util.Log.d("leak-191-9", dataLeAk191);
			android.util.Log.d("leak-193-9", dataLeAk193);
			android.util.Log.d("leak-195-9", dataLeAk195);
			android.util.Log.d("leak-197-9", dataLeAk197);
			android.util.Log.d("leak-199-9", dataLeAk199);
			android.util.Log.d("leak-201-9", dataLeAk201);
			android.util.Log.d("leak-203-9", dataLeAk203);
			android.util.Log.d("leak-206-9", dataLeAk206);
			android.util.Log.d("leak-209-9", dataLeAk209);
			android.util.Log.d("leak-211-9", dataLeAk211);
			android.util.Log.d("leak-213-9", dataLeAk213);
			android.util.Log.d("leak-215-9", dataLeAk215);
			android.util.Log.d("leak-217-9", dataLeAk217);
			android.util.Log.d("leak-219-9", dataLeAk219);
			android.util.Log.d("leak-221-9", dataLeAk221);
			android.util.Log.d("leak-223-9", dataLeAk223);
			return times.size();
        }

        @Override
        public Object getItem(int position) {
            dataLeAk200 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk199 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-170-19", dataLeAk170);
			android.util.Log.d("leak-171-19", dataLeAk171);
			android.util.Log.d("leak-172-19", dataLeAk172);
			android.util.Log.d("leak-173-19", dataLeAk173);
			android.util.Log.d("leak-174-19", dataLeAk174);
			android.util.Log.d("leak-175-19", dataLeAk175);
			android.util.Log.d("leak-176-19", dataLeAk176);
			android.util.Log.d("leak-177-19", dataLeAk177);
			android.util.Log.d("leak-178-19", dataLeAk178);
			android.util.Log.d("leak-180-19", dataLeAk180);
			android.util.Log.d("leak-182-19", dataLeAk182);
			android.util.Log.d("leak-184-19", dataLeAk184);
			android.util.Log.d("leak-186-19", dataLeAk186);
			android.util.Log.d("leak-188-19", dataLeAk188);
			android.util.Log.d("leak-190-19", dataLeAk190);
			android.util.Log.d("leak-192-19", dataLeAk192);
			android.util.Log.d("leak-194-19", dataLeAk194);
			android.util.Log.d("leak-196-19", dataLeAk196);
			android.util.Log.d("leak-198-19", dataLeAk198);
			android.util.Log.d("leak-200-19", dataLeAk200);
			android.util.Log.d("leak-202-19", dataLeAk202);
			android.util.Log.d("leak-204-19", dataLeAk204);
			android.util.Log.d("leak-207-19", dataLeAk207);
			android.util.Log.d("leak-210-19", dataLeAk210);
			android.util.Log.d("leak-212-19", dataLeAk212);
			android.util.Log.d("leak-214-19", dataLeAk214);
			android.util.Log.d("leak-216-19", dataLeAk216);
			android.util.Log.d("leak-218-19", dataLeAk218);
			android.util.Log.d("leak-220-19", dataLeAk220);
			android.util.Log.d("leak-222-19", dataLeAk222);
			android.util.Log.d("leak-224-19", dataLeAk224);
			android.util.Log.d("leak-225-19", dataLeAk225);
			android.util.Log.d("leak-226-19", dataLeAk226);
			android.util.Log.d("leak-179-10", dataLeAk179);
			android.util.Log.d("leak-181-10", dataLeAk181);
			android.util.Log.d("leak-183-10", dataLeAk183);
			android.util.Log.d("leak-185-10", dataLeAk185);
			android.util.Log.d("leak-187-10", dataLeAk187);
			android.util.Log.d("leak-189-10", dataLeAk189);
			android.util.Log.d("leak-191-10", dataLeAk191);
			android.util.Log.d("leak-193-10", dataLeAk193);
			android.util.Log.d("leak-195-10", dataLeAk195);
			android.util.Log.d("leak-197-10", dataLeAk197);
			android.util.Log.d("leak-199-10", dataLeAk199);
			android.util.Log.d("leak-201-10", dataLeAk201);
			android.util.Log.d("leak-203-10", dataLeAk203);
			android.util.Log.d("leak-206-10", dataLeAk206);
			android.util.Log.d("leak-209-10", dataLeAk209);
			android.util.Log.d("leak-211-10", dataLeAk211);
			android.util.Log.d("leak-213-10", dataLeAk213);
			android.util.Log.d("leak-215-10", dataLeAk215);
			android.util.Log.d("leak-217-10", dataLeAk217);
			android.util.Log.d("leak-219-10", dataLeAk219);
			android.util.Log.d("leak-221-10", dataLeAk221);
			android.util.Log.d("leak-223-10", dataLeAk223);
			return times.get(position);
        }

        @Override
        public long getItemId(int position) {
            dataLeAk202 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk201 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-170-20", dataLeAk170);
			android.util.Log.d("leak-171-20", dataLeAk171);
			android.util.Log.d("leak-172-20", dataLeAk172);
			android.util.Log.d("leak-173-20", dataLeAk173);
			android.util.Log.d("leak-174-20", dataLeAk174);
			android.util.Log.d("leak-175-20", dataLeAk175);
			android.util.Log.d("leak-176-20", dataLeAk176);
			android.util.Log.d("leak-177-20", dataLeAk177);
			android.util.Log.d("leak-178-20", dataLeAk178);
			android.util.Log.d("leak-180-20", dataLeAk180);
			android.util.Log.d("leak-182-20", dataLeAk182);
			android.util.Log.d("leak-184-20", dataLeAk184);
			android.util.Log.d("leak-186-20", dataLeAk186);
			android.util.Log.d("leak-188-20", dataLeAk188);
			android.util.Log.d("leak-190-20", dataLeAk190);
			android.util.Log.d("leak-192-20", dataLeAk192);
			android.util.Log.d("leak-194-20", dataLeAk194);
			android.util.Log.d("leak-196-20", dataLeAk196);
			android.util.Log.d("leak-198-20", dataLeAk198);
			android.util.Log.d("leak-200-20", dataLeAk200);
			android.util.Log.d("leak-202-20", dataLeAk202);
			android.util.Log.d("leak-204-20", dataLeAk204);
			android.util.Log.d("leak-207-20", dataLeAk207);
			android.util.Log.d("leak-210-20", dataLeAk210);
			android.util.Log.d("leak-212-20", dataLeAk212);
			android.util.Log.d("leak-214-20", dataLeAk214);
			android.util.Log.d("leak-216-20", dataLeAk216);
			android.util.Log.d("leak-218-20", dataLeAk218);
			android.util.Log.d("leak-220-20", dataLeAk220);
			android.util.Log.d("leak-222-20", dataLeAk222);
			android.util.Log.d("leak-224-20", dataLeAk224);
			android.util.Log.d("leak-225-20", dataLeAk225);
			android.util.Log.d("leak-226-20", dataLeAk226);
			android.util.Log.d("leak-179-11", dataLeAk179);
			android.util.Log.d("leak-181-11", dataLeAk181);
			android.util.Log.d("leak-183-11", dataLeAk183);
			android.util.Log.d("leak-185-11", dataLeAk185);
			android.util.Log.d("leak-187-11", dataLeAk187);
			android.util.Log.d("leak-189-11", dataLeAk189);
			android.util.Log.d("leak-191-11", dataLeAk191);
			android.util.Log.d("leak-193-11", dataLeAk193);
			android.util.Log.d("leak-195-11", dataLeAk195);
			android.util.Log.d("leak-197-11", dataLeAk197);
			android.util.Log.d("leak-199-11", dataLeAk199);
			android.util.Log.d("leak-201-11", dataLeAk201);
			android.util.Log.d("leak-203-11", dataLeAk203);
			android.util.Log.d("leak-206-11", dataLeAk206);
			android.util.Log.d("leak-209-11", dataLeAk209);
			android.util.Log.d("leak-211-11", dataLeAk211);
			android.util.Log.d("leak-213-11", dataLeAk213);
			android.util.Log.d("leak-215-11", dataLeAk215);
			android.util.Log.d("leak-217-11", dataLeAk217);
			android.util.Log.d("leak-219-11", dataLeAk219);
			android.util.Log.d("leak-221-11", dataLeAk221);
			android.util.Log.d("leak-223-11", dataLeAk223);
			return position;
        }

        private void assignTimeToActivityAt(TimeRange range, int which) {
            dataLeAk204 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk203 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-170-21", dataLeAk170);
			android.util.Log.d("leak-171-21", dataLeAk171);
			android.util.Log.d("leak-172-21", dataLeAk172);
			android.util.Log.d("leak-173-21", dataLeAk173);
			android.util.Log.d("leak-174-21", dataLeAk174);
			android.util.Log.d("leak-175-21", dataLeAk175);
			android.util.Log.d("leak-176-21", dataLeAk176);
			android.util.Log.d("leak-177-21", dataLeAk177);
			android.util.Log.d("leak-178-21", dataLeAk178);
			android.util.Log.d("leak-180-21", dataLeAk180);
			android.util.Log.d("leak-182-21", dataLeAk182);
			android.util.Log.d("leak-184-21", dataLeAk184);
			android.util.Log.d("leak-186-21", dataLeAk186);
			android.util.Log.d("leak-188-21", dataLeAk188);
			android.util.Log.d("leak-190-21", dataLeAk190);
			android.util.Log.d("leak-192-21", dataLeAk192);
			android.util.Log.d("leak-194-21", dataLeAk194);
			android.util.Log.d("leak-196-21", dataLeAk196);
			android.util.Log.d("leak-198-21", dataLeAk198);
			android.util.Log.d("leak-200-21", dataLeAk200);
			android.util.Log.d("leak-202-21", dataLeAk202);
			android.util.Log.d("leak-204-21", dataLeAk204);
			android.util.Log.d("leak-207-21", dataLeAk207);
			android.util.Log.d("leak-210-21", dataLeAk210);
			android.util.Log.d("leak-212-21", dataLeAk212);
			android.util.Log.d("leak-214-21", dataLeAk214);
			android.util.Log.d("leak-216-21", dataLeAk216);
			android.util.Log.d("leak-218-21", dataLeAk218);
			android.util.Log.d("leak-220-21", dataLeAk220);
			android.util.Log.d("leak-222-21", dataLeAk222);
			android.util.Log.d("leak-224-21", dataLeAk224);
			android.util.Log.d("leak-225-21", dataLeAk225);
			android.util.Log.d("leak-226-21", dataLeAk226);
			android.util.Log.d("leak-179-12", dataLeAk179);
			android.util.Log.d("leak-181-12", dataLeAk181);
			android.util.Log.d("leak-183-12", dataLeAk183);
			android.util.Log.d("leak-185-12", dataLeAk185);
			android.util.Log.d("leak-187-12", dataLeAk187);
			android.util.Log.d("leak-189-12", dataLeAk189);
			android.util.Log.d("leak-191-12", dataLeAk191);
			android.util.Log.d("leak-193-12", dataLeAk193);
			android.util.Log.d("leak-195-12", dataLeAk195);
			android.util.Log.d("leak-197-12", dataLeAk197);
			android.util.Log.d("leak-199-12", dataLeAk199);
			android.util.Log.d("leak-201-12", dataLeAk201);
			android.util.Log.d("leak-203-12", dataLeAk203);
			android.util.Log.d("leak-206-12", dataLeAk206);
			android.util.Log.d("leak-209-12", dataLeAk209);
			android.util.Log.d("leak-211-12", dataLeAk211);
			android.util.Log.d("leak-213-12", dataLeAk213);
			android.util.Log.d("leak-215-12", dataLeAk215);
			android.util.Log.d("leak-217-12", dataLeAk217);
			android.util.Log.d("leak-219-12", dataLeAk219);
			android.util.Log.d("leak-221-12", dataLeAk221);
			android.util.Log.d("leak-223-12", dataLeAk223);
			Cursor c = getActivityNames();
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

            String dataLeAk208 = "";

			String dataLeAk205 = "";

			private final TextView dateRange;
            private final TextView total;

            public TimeView(Context context, TimeRange t) {
                super(context);
				dataLeAk207 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk206 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk205 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-170-22", dataLeAk170);
				android.util.Log.d("leak-171-22", dataLeAk171);
				android.util.Log.d("leak-172-22", dataLeAk172);
				android.util.Log.d("leak-173-22", dataLeAk173);
				android.util.Log.d("leak-174-22", dataLeAk174);
				android.util.Log.d("leak-175-22", dataLeAk175);
				android.util.Log.d("leak-176-22", dataLeAk176);
				android.util.Log.d("leak-177-22", dataLeAk177);
				android.util.Log.d("leak-178-22", dataLeAk178);
				android.util.Log.d("leak-180-22", dataLeAk180);
				android.util.Log.d("leak-182-22", dataLeAk182);
				android.util.Log.d("leak-184-22", dataLeAk184);
				android.util.Log.d("leak-186-22", dataLeAk186);
				android.util.Log.d("leak-188-22", dataLeAk188);
				android.util.Log.d("leak-190-22", dataLeAk190);
				android.util.Log.d("leak-192-22", dataLeAk192);
				android.util.Log.d("leak-194-22", dataLeAk194);
				android.util.Log.d("leak-196-22", dataLeAk196);
				android.util.Log.d("leak-198-22", dataLeAk198);
				android.util.Log.d("leak-200-22", dataLeAk200);
				android.util.Log.d("leak-202-22", dataLeAk202);
				android.util.Log.d("leak-204-22", dataLeAk204);
				android.util.Log.d("leak-207-22", dataLeAk207);
				android.util.Log.d("leak-210-22", dataLeAk210);
				android.util.Log.d("leak-212-22", dataLeAk212);
				android.util.Log.d("leak-214-22", dataLeAk214);
				android.util.Log.d("leak-216-22", dataLeAk216);
				android.util.Log.d("leak-218-22", dataLeAk218);
				android.util.Log.d("leak-220-22", dataLeAk220);
				android.util.Log.d("leak-222-22", dataLeAk222);
				android.util.Log.d("leak-224-22", dataLeAk224);
				android.util.Log.d("leak-225-22", dataLeAk225);
				android.util.Log.d("leak-226-22", dataLeAk226);
				android.util.Log.d("leak-179-13", dataLeAk179);
				android.util.Log.d("leak-181-13", dataLeAk181);
				android.util.Log.d("leak-183-13", dataLeAk183);
				android.util.Log.d("leak-185-13", dataLeAk185);
				android.util.Log.d("leak-187-13", dataLeAk187);
				android.util.Log.d("leak-189-13", dataLeAk189);
				android.util.Log.d("leak-191-13", dataLeAk191);
				android.util.Log.d("leak-193-13", dataLeAk193);
				android.util.Log.d("leak-195-13", dataLeAk195);
				android.util.Log.d("leak-197-13", dataLeAk197);
				android.util.Log.d("leak-199-13", dataLeAk199);
				android.util.Log.d("leak-201-13", dataLeAk201);
				android.util.Log.d("leak-203-13", dataLeAk203);
				android.util.Log.d("leak-206-13", dataLeAk206);
				android.util.Log.d("leak-209-13", dataLeAk209);
				android.util.Log.d("leak-211-13", dataLeAk211);
				android.util.Log.d("leak-213-13", dataLeAk213);
				android.util.Log.d("leak-215-13", dataLeAk215);
				android.util.Log.d("leak-217-13", dataLeAk217);
				android.util.Log.d("leak-219-13", dataLeAk219);
				android.util.Log.d("leak-221-13", dataLeAk221);
				android.util.Log.d("leak-223-13", dataLeAk223);
				android.util.Log.d("leak-205-0", dataLeAk205);
				android.util.Log.d("leak-208-0", dataLeAk208);
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
                dataLeAk210 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk209 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk208 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-170-23", dataLeAk170);
				android.util.Log.d("leak-171-23", dataLeAk171);
				android.util.Log.d("leak-172-23", dataLeAk172);
				android.util.Log.d("leak-173-23", dataLeAk173);
				android.util.Log.d("leak-174-23", dataLeAk174);
				android.util.Log.d("leak-175-23", dataLeAk175);
				android.util.Log.d("leak-176-23", dataLeAk176);
				android.util.Log.d("leak-177-23", dataLeAk177);
				android.util.Log.d("leak-178-23", dataLeAk178);
				android.util.Log.d("leak-180-23", dataLeAk180);
				android.util.Log.d("leak-182-23", dataLeAk182);
				android.util.Log.d("leak-184-23", dataLeAk184);
				android.util.Log.d("leak-186-23", dataLeAk186);
				android.util.Log.d("leak-188-23", dataLeAk188);
				android.util.Log.d("leak-190-23", dataLeAk190);
				android.util.Log.d("leak-192-23", dataLeAk192);
				android.util.Log.d("leak-194-23", dataLeAk194);
				android.util.Log.d("leak-196-23", dataLeAk196);
				android.util.Log.d("leak-198-23", dataLeAk198);
				android.util.Log.d("leak-200-23", dataLeAk200);
				android.util.Log.d("leak-202-23", dataLeAk202);
				android.util.Log.d("leak-204-23", dataLeAk204);
				android.util.Log.d("leak-207-23", dataLeAk207);
				android.util.Log.d("leak-210-23", dataLeAk210);
				android.util.Log.d("leak-212-23", dataLeAk212);
				android.util.Log.d("leak-214-23", dataLeAk214);
				android.util.Log.d("leak-216-23", dataLeAk216);
				android.util.Log.d("leak-218-23", dataLeAk218);
				android.util.Log.d("leak-220-23", dataLeAk220);
				android.util.Log.d("leak-222-23", dataLeAk222);
				android.util.Log.d("leak-224-23", dataLeAk224);
				android.util.Log.d("leak-225-23", dataLeAk225);
				android.util.Log.d("leak-226-23", dataLeAk226);
				android.util.Log.d("leak-179-14", dataLeAk179);
				android.util.Log.d("leak-181-14", dataLeAk181);
				android.util.Log.d("leak-183-14", dataLeAk183);
				android.util.Log.d("leak-185-14", dataLeAk185);
				android.util.Log.d("leak-187-14", dataLeAk187);
				android.util.Log.d("leak-189-14", dataLeAk189);
				android.util.Log.d("leak-191-14", dataLeAk191);
				android.util.Log.d("leak-193-14", dataLeAk193);
				android.util.Log.d("leak-195-14", dataLeAk195);
				android.util.Log.d("leak-197-14", dataLeAk197);
				android.util.Log.d("leak-199-14", dataLeAk199);
				android.util.Log.d("leak-201-14", dataLeAk201);
				android.util.Log.d("leak-203-14", dataLeAk203);
				android.util.Log.d("leak-206-14", dataLeAk206);
				android.util.Log.d("leak-209-14", dataLeAk209);
				android.util.Log.d("leak-211-14", dataLeAk211);
				android.util.Log.d("leak-213-14", dataLeAk213);
				android.util.Log.d("leak-215-14", dataLeAk215);
				android.util.Log.d("leak-217-14", dataLeAk217);
				android.util.Log.d("leak-219-14", dataLeAk219);
				android.util.Log.d("leak-221-14", dataLeAk221);
				android.util.Log.d("leak-223-14", dataLeAk223);
				android.util.Log.d("leak-205-1", dataLeAk205);
				android.util.Log.d("leak-208-1", dataLeAk208);
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
            dataLeAk212 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk211 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-170-24", dataLeAk170);
			android.util.Log.d("leak-171-24", dataLeAk171);
			android.util.Log.d("leak-172-24", dataLeAk172);
			android.util.Log.d("leak-173-24", dataLeAk173);
			android.util.Log.d("leak-174-24", dataLeAk174);
			android.util.Log.d("leak-175-24", dataLeAk175);
			android.util.Log.d("leak-176-24", dataLeAk176);
			android.util.Log.d("leak-177-24", dataLeAk177);
			android.util.Log.d("leak-178-24", dataLeAk178);
			android.util.Log.d("leak-180-24", dataLeAk180);
			android.util.Log.d("leak-182-24", dataLeAk182);
			android.util.Log.d("leak-184-24", dataLeAk184);
			android.util.Log.d("leak-186-24", dataLeAk186);
			android.util.Log.d("leak-188-24", dataLeAk188);
			android.util.Log.d("leak-190-24", dataLeAk190);
			android.util.Log.d("leak-192-24", dataLeAk192);
			android.util.Log.d("leak-194-24", dataLeAk194);
			android.util.Log.d("leak-196-24", dataLeAk196);
			android.util.Log.d("leak-198-24", dataLeAk198);
			android.util.Log.d("leak-200-24", dataLeAk200);
			android.util.Log.d("leak-202-24", dataLeAk202);
			android.util.Log.d("leak-204-24", dataLeAk204);
			android.util.Log.d("leak-207-24", dataLeAk207);
			android.util.Log.d("leak-210-24", dataLeAk210);
			android.util.Log.d("leak-212-24", dataLeAk212);
			android.util.Log.d("leak-214-24", dataLeAk214);
			android.util.Log.d("leak-216-24", dataLeAk216);
			android.util.Log.d("leak-218-24", dataLeAk218);
			android.util.Log.d("leak-220-24", dataLeAk220);
			android.util.Log.d("leak-222-24", dataLeAk222);
			android.util.Log.d("leak-224-24", dataLeAk224);
			android.util.Log.d("leak-225-24", dataLeAk225);
			android.util.Log.d("leak-226-24", dataLeAk226);
			android.util.Log.d("leak-179-15", dataLeAk179);
			android.util.Log.d("leak-181-15", dataLeAk181);
			android.util.Log.d("leak-183-15", dataLeAk183);
			android.util.Log.d("leak-185-15", dataLeAk185);
			android.util.Log.d("leak-187-15", dataLeAk187);
			android.util.Log.d("leak-189-15", dataLeAk189);
			android.util.Log.d("leak-191-15", dataLeAk191);
			android.util.Log.d("leak-193-15", dataLeAk193);
			android.util.Log.d("leak-195-15", dataLeAk195);
			android.util.Log.d("leak-197-15", dataLeAk197);
			android.util.Log.d("leak-199-15", dataLeAk199);
			android.util.Log.d("leak-201-15", dataLeAk201);
			android.util.Log.d("leak-203-15", dataLeAk203);
			android.util.Log.d("leak-206-15", dataLeAk206);
			android.util.Log.d("leak-209-15", dataLeAk209);
			android.util.Log.d("leak-211-15", dataLeAk211);
			android.util.Log.d("leak-213-15", dataLeAk213);
			android.util.Log.d("leak-215-15", dataLeAk215);
			android.util.Log.d("leak-217-15", dataLeAk217);
			android.util.Log.d("leak-219-15", dataLeAk219);
			android.util.Log.d("leak-221-15", dataLeAk221);
			android.util.Log.d("leak-223-15", dataLeAk223);
			times.clear();
        }

        public void addTimeRange(long sd, long ed) {
            dataLeAk214 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk213 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-170-25", dataLeAk170);
			android.util.Log.d("leak-171-25", dataLeAk171);
			android.util.Log.d("leak-172-25", dataLeAk172);
			android.util.Log.d("leak-173-25", dataLeAk173);
			android.util.Log.d("leak-174-25", dataLeAk174);
			android.util.Log.d("leak-175-25", dataLeAk175);
			android.util.Log.d("leak-176-25", dataLeAk176);
			android.util.Log.d("leak-177-25", dataLeAk177);
			android.util.Log.d("leak-178-25", dataLeAk178);
			android.util.Log.d("leak-180-25", dataLeAk180);
			android.util.Log.d("leak-182-25", dataLeAk182);
			android.util.Log.d("leak-184-25", dataLeAk184);
			android.util.Log.d("leak-186-25", dataLeAk186);
			android.util.Log.d("leak-188-25", dataLeAk188);
			android.util.Log.d("leak-190-25", dataLeAk190);
			android.util.Log.d("leak-192-25", dataLeAk192);
			android.util.Log.d("leak-194-25", dataLeAk194);
			android.util.Log.d("leak-196-25", dataLeAk196);
			android.util.Log.d("leak-198-25", dataLeAk198);
			android.util.Log.d("leak-200-25", dataLeAk200);
			android.util.Log.d("leak-202-25", dataLeAk202);
			android.util.Log.d("leak-204-25", dataLeAk204);
			android.util.Log.d("leak-207-25", dataLeAk207);
			android.util.Log.d("leak-210-25", dataLeAk210);
			android.util.Log.d("leak-212-25", dataLeAk212);
			android.util.Log.d("leak-214-25", dataLeAk214);
			android.util.Log.d("leak-216-25", dataLeAk216);
			android.util.Log.d("leak-218-25", dataLeAk218);
			android.util.Log.d("leak-220-25", dataLeAk220);
			android.util.Log.d("leak-222-25", dataLeAk222);
			android.util.Log.d("leak-224-25", dataLeAk224);
			android.util.Log.d("leak-225-25", dataLeAk225);
			android.util.Log.d("leak-226-25", dataLeAk226);
			android.util.Log.d("leak-179-16", dataLeAk179);
			android.util.Log.d("leak-181-16", dataLeAk181);
			android.util.Log.d("leak-183-16", dataLeAk183);
			android.util.Log.d("leak-185-16", dataLeAk185);
			android.util.Log.d("leak-187-16", dataLeAk187);
			android.util.Log.d("leak-189-16", dataLeAk189);
			android.util.Log.d("leak-191-16", dataLeAk191);
			android.util.Log.d("leak-193-16", dataLeAk193);
			android.util.Log.d("leak-195-16", dataLeAk195);
			android.util.Log.d("leak-197-16", dataLeAk197);
			android.util.Log.d("leak-199-16", dataLeAk199);
			android.util.Log.d("leak-201-16", dataLeAk201);
			android.util.Log.d("leak-203-16", dataLeAk203);
			android.util.Log.d("leak-206-16", dataLeAk206);
			android.util.Log.d("leak-209-16", dataLeAk209);
			android.util.Log.d("leak-211-16", dataLeAk211);
			android.util.Log.d("leak-213-16", dataLeAk213);
			android.util.Log.d("leak-215-16", dataLeAk215);
			android.util.Log.d("leak-217-16", dataLeAk217);
			android.util.Log.d("leak-219-16", dataLeAk219);
			android.util.Log.d("leak-221-16", dataLeAk221);
			android.util.Log.d("leak-223-16", dataLeAk223);
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
            dataLeAk216 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk215 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-170-26", dataLeAk170);
			android.util.Log.d("leak-171-26", dataLeAk171);
			android.util.Log.d("leak-172-26", dataLeAk172);
			android.util.Log.d("leak-173-26", dataLeAk173);
			android.util.Log.d("leak-174-26", dataLeAk174);
			android.util.Log.d("leak-175-26", dataLeAk175);
			android.util.Log.d("leak-176-26", dataLeAk176);
			android.util.Log.d("leak-177-26", dataLeAk177);
			android.util.Log.d("leak-178-26", dataLeAk178);
			android.util.Log.d("leak-180-26", dataLeAk180);
			android.util.Log.d("leak-182-26", dataLeAk182);
			android.util.Log.d("leak-184-26", dataLeAk184);
			android.util.Log.d("leak-186-26", dataLeAk186);
			android.util.Log.d("leak-188-26", dataLeAk188);
			android.util.Log.d("leak-190-26", dataLeAk190);
			android.util.Log.d("leak-192-26", dataLeAk192);
			android.util.Log.d("leak-194-26", dataLeAk194);
			android.util.Log.d("leak-196-26", dataLeAk196);
			android.util.Log.d("leak-198-26", dataLeAk198);
			android.util.Log.d("leak-200-26", dataLeAk200);
			android.util.Log.d("leak-202-26", dataLeAk202);
			android.util.Log.d("leak-204-26", dataLeAk204);
			android.util.Log.d("leak-207-26", dataLeAk207);
			android.util.Log.d("leak-210-26", dataLeAk210);
			android.util.Log.d("leak-212-26", dataLeAk212);
			android.util.Log.d("leak-214-26", dataLeAk214);
			android.util.Log.d("leak-216-26", dataLeAk216);
			android.util.Log.d("leak-218-26", dataLeAk218);
			android.util.Log.d("leak-220-26", dataLeAk220);
			android.util.Log.d("leak-222-26", dataLeAk222);
			android.util.Log.d("leak-224-26", dataLeAk224);
			android.util.Log.d("leak-225-26", dataLeAk225);
			android.util.Log.d("leak-226-26", dataLeAk226);
			android.util.Log.d("leak-179-17", dataLeAk179);
			android.util.Log.d("leak-181-17", dataLeAk181);
			android.util.Log.d("leak-183-17", dataLeAk183);
			android.util.Log.d("leak-185-17", dataLeAk185);
			android.util.Log.d("leak-187-17", dataLeAk187);
			android.util.Log.d("leak-189-17", dataLeAk189);
			android.util.Log.d("leak-191-17", dataLeAk191);
			android.util.Log.d("leak-193-17", dataLeAk193);
			android.util.Log.d("leak-195-17", dataLeAk195);
			android.util.Log.d("leak-197-17", dataLeAk197);
			android.util.Log.d("leak-199-17", dataLeAk199);
			android.util.Log.d("leak-201-17", dataLeAk201);
			android.util.Log.d("leak-203-17", dataLeAk203);
			android.util.Log.d("leak-206-17", dataLeAk206);
			android.util.Log.d("leak-209-17", dataLeAk209);
			android.util.Log.d("leak-211-17", dataLeAk211);
			android.util.Log.d("leak-213-17", dataLeAk213);
			android.util.Log.d("leak-215-17", dataLeAk215);
			android.util.Log.d("leak-217-17", dataLeAk217);
			android.util.Log.d("leak-219-17", dataLeAk219);
			android.util.Log.d("leak-221-17", dataLeAk221);
			android.util.Log.d("leak-223-17", dataLeAk223);
			int insertPoint = 0;
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
            dataLeAk218 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk217 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-170-27", dataLeAk170);
			android.util.Log.d("leak-171-27", dataLeAk171);
			android.util.Log.d("leak-172-27", dataLeAk172);
			android.util.Log.d("leak-173-27", dataLeAk173);
			android.util.Log.d("leak-174-27", dataLeAk174);
			android.util.Log.d("leak-175-27", dataLeAk175);
			android.util.Log.d("leak-176-27", dataLeAk176);
			android.util.Log.d("leak-177-27", dataLeAk177);
			android.util.Log.d("leak-178-27", dataLeAk178);
			android.util.Log.d("leak-180-27", dataLeAk180);
			android.util.Log.d("leak-182-27", dataLeAk182);
			android.util.Log.d("leak-184-27", dataLeAk184);
			android.util.Log.d("leak-186-27", dataLeAk186);
			android.util.Log.d("leak-188-27", dataLeAk188);
			android.util.Log.d("leak-190-27", dataLeAk190);
			android.util.Log.d("leak-192-27", dataLeAk192);
			android.util.Log.d("leak-194-27", dataLeAk194);
			android.util.Log.d("leak-196-27", dataLeAk196);
			android.util.Log.d("leak-198-27", dataLeAk198);
			android.util.Log.d("leak-200-27", dataLeAk200);
			android.util.Log.d("leak-202-27", dataLeAk202);
			android.util.Log.d("leak-204-27", dataLeAk204);
			android.util.Log.d("leak-207-27", dataLeAk207);
			android.util.Log.d("leak-210-27", dataLeAk210);
			android.util.Log.d("leak-212-27", dataLeAk212);
			android.util.Log.d("leak-214-27", dataLeAk214);
			android.util.Log.d("leak-216-27", dataLeAk216);
			android.util.Log.d("leak-218-27", dataLeAk218);
			android.util.Log.d("leak-220-27", dataLeAk220);
			android.util.Log.d("leak-222-27", dataLeAk222);
			android.util.Log.d("leak-224-27", dataLeAk224);
			android.util.Log.d("leak-225-27", dataLeAk225);
			android.util.Log.d("leak-226-27", dataLeAk226);
			android.util.Log.d("leak-179-18", dataLeAk179);
			android.util.Log.d("leak-181-18", dataLeAk181);
			android.util.Log.d("leak-183-18", dataLeAk183);
			android.util.Log.d("leak-185-18", dataLeAk185);
			android.util.Log.d("leak-187-18", dataLeAk187);
			android.util.Log.d("leak-189-18", dataLeAk189);
			android.util.Log.d("leak-191-18", dataLeAk191);
			android.util.Log.d("leak-193-18", dataLeAk193);
			android.util.Log.d("leak-195-18", dataLeAk195);
			android.util.Log.d("leak-197-18", dataLeAk197);
			android.util.Log.d("leak-199-18", dataLeAk199);
			android.util.Log.d("leak-201-18", dataLeAk201);
			android.util.Log.d("leak-203-18", dataLeAk203);
			android.util.Log.d("leak-206-18", dataLeAk206);
			android.util.Log.d("leak-209-18", dataLeAk209);
			android.util.Log.d("leak-211-18", dataLeAk211);
			android.util.Log.d("leak-213-18", dataLeAk213);
			android.util.Log.d("leak-215-18", dataLeAk215);
			android.util.Log.d("leak-217-18", dataLeAk217);
			android.util.Log.d("leak-219-18", dataLeAk219);
			android.util.Log.d("leak-221-18", dataLeAk221);
			android.util.Log.d("leak-223-18", dataLeAk223);
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
            dataLeAk220 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk219 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-170-28", dataLeAk170);
			android.util.Log.d("leak-171-28", dataLeAk171);
			android.util.Log.d("leak-172-28", dataLeAk172);
			android.util.Log.d("leak-173-28", dataLeAk173);
			android.util.Log.d("leak-174-28", dataLeAk174);
			android.util.Log.d("leak-175-28", dataLeAk175);
			android.util.Log.d("leak-176-28", dataLeAk176);
			android.util.Log.d("leak-177-28", dataLeAk177);
			android.util.Log.d("leak-178-28", dataLeAk178);
			android.util.Log.d("leak-180-28", dataLeAk180);
			android.util.Log.d("leak-182-28", dataLeAk182);
			android.util.Log.d("leak-184-28", dataLeAk184);
			android.util.Log.d("leak-186-28", dataLeAk186);
			android.util.Log.d("leak-188-28", dataLeAk188);
			android.util.Log.d("leak-190-28", dataLeAk190);
			android.util.Log.d("leak-192-28", dataLeAk192);
			android.util.Log.d("leak-194-28", dataLeAk194);
			android.util.Log.d("leak-196-28", dataLeAk196);
			android.util.Log.d("leak-198-28", dataLeAk198);
			android.util.Log.d("leak-200-28", dataLeAk200);
			android.util.Log.d("leak-202-28", dataLeAk202);
			android.util.Log.d("leak-204-28", dataLeAk204);
			android.util.Log.d("leak-207-28", dataLeAk207);
			android.util.Log.d("leak-210-28", dataLeAk210);
			android.util.Log.d("leak-212-28", dataLeAk212);
			android.util.Log.d("leak-214-28", dataLeAk214);
			android.util.Log.d("leak-216-28", dataLeAk216);
			android.util.Log.d("leak-218-28", dataLeAk218);
			android.util.Log.d("leak-220-28", dataLeAk220);
			android.util.Log.d("leak-222-28", dataLeAk222);
			android.util.Log.d("leak-224-28", dataLeAk224);
			android.util.Log.d("leak-225-28", dataLeAk225);
			android.util.Log.d("leak-226-28", dataLeAk226);
			android.util.Log.d("leak-179-19", dataLeAk179);
			android.util.Log.d("leak-181-19", dataLeAk181);
			android.util.Log.d("leak-183-19", dataLeAk183);
			android.util.Log.d("leak-185-19", dataLeAk185);
			android.util.Log.d("leak-187-19", dataLeAk187);
			android.util.Log.d("leak-189-19", dataLeAk189);
			android.util.Log.d("leak-191-19", dataLeAk191);
			android.util.Log.d("leak-193-19", dataLeAk193);
			android.util.Log.d("leak-195-19", dataLeAk195);
			android.util.Log.d("leak-197-19", dataLeAk197);
			android.util.Log.d("leak-199-19", dataLeAk199);
			android.util.Log.d("leak-201-19", dataLeAk201);
			android.util.Log.d("leak-203-19", dataLeAk203);
			android.util.Log.d("leak-206-19", dataLeAk206);
			android.util.Log.d("leak-209-19", dataLeAk209);
			android.util.Log.d("leak-211-19", dataLeAk211);
			android.util.Log.d("leak-213-19", dataLeAk213);
			android.util.Log.d("leak-215-19", dataLeAk215);
			android.util.Log.d("leak-217-19", dataLeAk217);
			android.util.Log.d("leak-219-19", dataLeAk219);
			android.util.Log.d("leak-221-19", dataLeAk221);
			android.util.Log.d("leak-223-19", dataLeAk223);
			int dayOfYear = -1, year = -1;
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
            dataLeAk222 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk221 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-170-29", dataLeAk170);
			android.util.Log.d("leak-171-29", dataLeAk171);
			android.util.Log.d("leak-172-29", dataLeAk172);
			android.util.Log.d("leak-173-29", dataLeAk173);
			android.util.Log.d("leak-174-29", dataLeAk174);
			android.util.Log.d("leak-175-29", dataLeAk175);
			android.util.Log.d("leak-176-29", dataLeAk176);
			android.util.Log.d("leak-177-29", dataLeAk177);
			android.util.Log.d("leak-178-29", dataLeAk178);
			android.util.Log.d("leak-180-29", dataLeAk180);
			android.util.Log.d("leak-182-29", dataLeAk182);
			android.util.Log.d("leak-184-29", dataLeAk184);
			android.util.Log.d("leak-186-29", dataLeAk186);
			android.util.Log.d("leak-188-29", dataLeAk188);
			android.util.Log.d("leak-190-29", dataLeAk190);
			android.util.Log.d("leak-192-29", dataLeAk192);
			android.util.Log.d("leak-194-29", dataLeAk194);
			android.util.Log.d("leak-196-29", dataLeAk196);
			android.util.Log.d("leak-198-29", dataLeAk198);
			android.util.Log.d("leak-200-29", dataLeAk200);
			android.util.Log.d("leak-202-29", dataLeAk202);
			android.util.Log.d("leak-204-29", dataLeAk204);
			android.util.Log.d("leak-207-29", dataLeAk207);
			android.util.Log.d("leak-210-29", dataLeAk210);
			android.util.Log.d("leak-212-29", dataLeAk212);
			android.util.Log.d("leak-214-29", dataLeAk214);
			android.util.Log.d("leak-216-29", dataLeAk216);
			android.util.Log.d("leak-218-29", dataLeAk218);
			android.util.Log.d("leak-220-29", dataLeAk220);
			android.util.Log.d("leak-222-29", dataLeAk222);
			android.util.Log.d("leak-224-29", dataLeAk224);
			android.util.Log.d("leak-225-29", dataLeAk225);
			android.util.Log.d("leak-226-29", dataLeAk226);
			android.util.Log.d("leak-179-20", dataLeAk179);
			android.util.Log.d("leak-181-20", dataLeAk181);
			android.util.Log.d("leak-183-20", dataLeAk183);
			android.util.Log.d("leak-185-20", dataLeAk185);
			android.util.Log.d("leak-187-20", dataLeAk187);
			android.util.Log.d("leak-189-20", dataLeAk189);
			android.util.Log.d("leak-191-20", dataLeAk191);
			android.util.Log.d("leak-193-20", dataLeAk193);
			android.util.Log.d("leak-195-20", dataLeAk195);
			android.util.Log.d("leak-197-20", dataLeAk197);
			android.util.Log.d("leak-199-20", dataLeAk199);
			android.util.Log.d("leak-201-20", dataLeAk201);
			android.util.Log.d("leak-203-20", dataLeAk203);
			android.util.Log.d("leak-206-20", dataLeAk206);
			android.util.Log.d("leak-209-20", dataLeAk209);
			android.util.Log.d("leak-211-20", dataLeAk211);
			android.util.Log.d("leak-213-20", dataLeAk213);
			android.util.Log.d("leak-215-20", dataLeAk215);
			android.util.Log.d("leak-217-20", dataLeAk217);
			android.util.Log.d("leak-219-20", dataLeAk219);
			android.util.Log.d("leak-221-20", dataLeAk221);
			android.util.Log.d("leak-223-20", dataLeAk223);
			SQLiteDatabase db = dbHelper.getWritableDatabase();
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
            dataLeAk224 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk223 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-170-30", dataLeAk170);
			android.util.Log.d("leak-171-30", dataLeAk171);
			android.util.Log.d("leak-172-30", dataLeAk172);
			android.util.Log.d("leak-173-30", dataLeAk173);
			android.util.Log.d("leak-174-30", dataLeAk174);
			android.util.Log.d("leak-175-30", dataLeAk175);
			android.util.Log.d("leak-176-30", dataLeAk176);
			android.util.Log.d("leak-177-30", dataLeAk177);
			android.util.Log.d("leak-178-30", dataLeAk178);
			android.util.Log.d("leak-180-30", dataLeAk180);
			android.util.Log.d("leak-182-30", dataLeAk182);
			android.util.Log.d("leak-184-30", dataLeAk184);
			android.util.Log.d("leak-186-30", dataLeAk186);
			android.util.Log.d("leak-188-30", dataLeAk188);
			android.util.Log.d("leak-190-30", dataLeAk190);
			android.util.Log.d("leak-192-30", dataLeAk192);
			android.util.Log.d("leak-194-30", dataLeAk194);
			android.util.Log.d("leak-196-30", dataLeAk196);
			android.util.Log.d("leak-198-30", dataLeAk198);
			android.util.Log.d("leak-200-30", dataLeAk200);
			android.util.Log.d("leak-202-30", dataLeAk202);
			android.util.Log.d("leak-204-30", dataLeAk204);
			android.util.Log.d("leak-207-30", dataLeAk207);
			android.util.Log.d("leak-210-30", dataLeAk210);
			android.util.Log.d("leak-212-30", dataLeAk212);
			android.util.Log.d("leak-214-30", dataLeAk214);
			android.util.Log.d("leak-216-30", dataLeAk216);
			android.util.Log.d("leak-218-30", dataLeAk218);
			android.util.Log.d("leak-220-30", dataLeAk220);
			android.util.Log.d("leak-222-30", dataLeAk222);
			android.util.Log.d("leak-224-30", dataLeAk224);
			android.util.Log.d("leak-225-30", dataLeAk225);
			android.util.Log.d("leak-226-30", dataLeAk226);
			android.util.Log.d("leak-179-21", dataLeAk179);
			android.util.Log.d("leak-181-21", dataLeAk181);
			android.util.Log.d("leak-183-21", dataLeAk183);
			android.util.Log.d("leak-185-21", dataLeAk185);
			android.util.Log.d("leak-187-21", dataLeAk187);
			android.util.Log.d("leak-189-21", dataLeAk189);
			android.util.Log.d("leak-191-21", dataLeAk191);
			android.util.Log.d("leak-193-21", dataLeAk193);
			android.util.Log.d("leak-195-21", dataLeAk195);
			android.util.Log.d("leak-197-21", dataLeAk197);
			android.util.Log.d("leak-199-21", dataLeAk199);
			android.util.Log.d("leak-201-21", dataLeAk201);
			android.util.Log.d("leak-203-21", dataLeAk203);
			android.util.Log.d("leak-206-21", dataLeAk206);
			android.util.Log.d("leak-209-21", dataLeAk209);
			android.util.Log.d("leak-211-21", dataLeAk211);
			android.util.Log.d("leak-213-21", dataLeAk213);
			android.util.Log.d("leak-215-21", dataLeAk215);
			android.util.Log.d("leak-217-21", dataLeAk217);
			android.util.Log.d("leak-219-21", dataLeAk219);
			android.util.Log.d("leak-221-21", dataLeAk221);
			android.util.Log.d("leak-223-21", dataLeAk223);
			SQLiteDatabase db = dbHelper.getReadableDatabase();
            Cursor c = db.query(DBHelper.ACTIVITY_TABLE, DBHelper.ACTIVITY_COLUMNS, null, null,
                    null, null, ACTIVITY_NAME);
            return c;
        }
    }

    @Override
    public void onActivityResult(int reqCode, int resCode, Intent intent) {
        dataLeAk225 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-170-31", dataLeAk170);
		android.util.Log.d("leak-171-31", dataLeAk171);
		android.util.Log.d("leak-172-31", dataLeAk172);
		android.util.Log.d("leak-173-31", dataLeAk173);
		android.util.Log.d("leak-174-31", dataLeAk174);
		android.util.Log.d("leak-175-31", dataLeAk175);
		android.util.Log.d("leak-176-31", dataLeAk176);
		android.util.Log.d("leak-177-31", dataLeAk177);
		android.util.Log.d("leak-178-31", dataLeAk178);
		android.util.Log.d("leak-180-31", dataLeAk180);
		android.util.Log.d("leak-182-31", dataLeAk182);
		android.util.Log.d("leak-184-31", dataLeAk184);
		android.util.Log.d("leak-186-31", dataLeAk186);
		android.util.Log.d("leak-188-31", dataLeAk188);
		android.util.Log.d("leak-190-31", dataLeAk190);
		android.util.Log.d("leak-192-31", dataLeAk192);
		android.util.Log.d("leak-194-31", dataLeAk194);
		android.util.Log.d("leak-196-31", dataLeAk196);
		android.util.Log.d("leak-198-31", dataLeAk198);
		android.util.Log.d("leak-200-31", dataLeAk200);
		android.util.Log.d("leak-202-31", dataLeAk202);
		android.util.Log.d("leak-204-31", dataLeAk204);
		android.util.Log.d("leak-207-31", dataLeAk207);
		android.util.Log.d("leak-210-31", dataLeAk210);
		android.util.Log.d("leak-212-31", dataLeAk212);
		android.util.Log.d("leak-214-31", dataLeAk214);
		android.util.Log.d("leak-216-31", dataLeAk216);
		android.util.Log.d("leak-218-31", dataLeAk218);
		android.util.Log.d("leak-220-31", dataLeAk220);
		android.util.Log.d("leak-222-31", dataLeAk222);
		android.util.Log.d("leak-224-31", dataLeAk224);
		android.util.Log.d("leak-225-31", dataLeAk225);
		android.util.Log.d("leak-226-31", dataLeAk226);
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
		dataLeAk226 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-170-32", dataLeAk170);
		android.util.Log.d("leak-171-32", dataLeAk171);
		android.util.Log.d("leak-172-32", dataLeAk172);
		android.util.Log.d("leak-173-32", dataLeAk173);
		android.util.Log.d("leak-174-32", dataLeAk174);
		android.util.Log.d("leak-175-32", dataLeAk175);
		android.util.Log.d("leak-176-32", dataLeAk176);
		android.util.Log.d("leak-177-32", dataLeAk177);
		android.util.Log.d("leak-178-32", dataLeAk178);
		android.util.Log.d("leak-180-32", dataLeAk180);
		android.util.Log.d("leak-182-32", dataLeAk182);
		android.util.Log.d("leak-184-32", dataLeAk184);
		android.util.Log.d("leak-186-32", dataLeAk186);
		android.util.Log.d("leak-188-32", dataLeAk188);
		android.util.Log.d("leak-190-32", dataLeAk190);
		android.util.Log.d("leak-192-32", dataLeAk192);
		android.util.Log.d("leak-194-32", dataLeAk194);
		android.util.Log.d("leak-196-32", dataLeAk196);
		android.util.Log.d("leak-198-32", dataLeAk198);
		android.util.Log.d("leak-200-32", dataLeAk200);
		android.util.Log.d("leak-202-32", dataLeAk202);
		android.util.Log.d("leak-204-32", dataLeAk204);
		android.util.Log.d("leak-207-32", dataLeAk207);
		android.util.Log.d("leak-210-32", dataLeAk210);
		android.util.Log.d("leak-212-32", dataLeAk212);
		android.util.Log.d("leak-214-32", dataLeAk214);
		android.util.Log.d("leak-216-32", dataLeAk216);
		android.util.Log.d("leak-218-32", dataLeAk218);
		android.util.Log.d("leak-220-32", dataLeAk220);
		android.util.Log.d("leak-222-32", dataLeAk222);
		android.util.Log.d("leak-224-32", dataLeAk224);
		android.util.Log.d("leak-225-32", dataLeAk225);
		android.util.Log.d("leak-226-32", dataLeAk226);
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
