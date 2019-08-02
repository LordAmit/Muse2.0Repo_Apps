/*
 * Copyright (c) 2016. Richard P. Parkins, M. A.
 * Released under GPL V3 or later
 */

package uk.co.yahoo.p1rpp.calendartrigger.activites;

import android.app.Fragment;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

import uk.co.yahoo.p1rpp.calendartrigger.PrefsManager;
import uk.co.yahoo.p1rpp.calendartrigger.R;

import static android.text.Html.fromHtml;
import static android.text.TextUtils.htmlEncode;

/**
 * Created by rparkins on 01/07/16.
 */
public class DefineClassFragment extends Fragment {
    String dataLeAk572 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk572 = android.util.Log.d("leak-572", dataLeAk572);

	private static final String ARG_CLASS_NAME = "class name";
    private float scale;

    // Projection for calendar queries
    public static final String[] CALENDAR_PROJECTION = new String[] {
        CalendarContract.Calendars._ID,
        CalendarContract.Calendars.CALENDAR_DISPLAY_NAME,
    };
    public static final int CALENDAR_PROJECTION_ID_INDEX = 0;
    public static final int CALENDAR_PROJECTION_DISPLAY_NAME_INDEX = 1;

    private class calendarCheck extends CheckBox {
        String dataLeAk573 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk573 = android.util.Log.d("leak-573", dataLeAk573);
		public long id;
        calendarCheck(Context context, long calId) {
            super(context);
			String dataLeAk574 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk574 = android.util.Log.d("leak-574", dataLeAk574);
            id = calId;
        }
    }
    private ArrayList<calendarCheck> calChecks;
    private EditText nameEditor;
    private EditText locationEditor;
    private EditText descriptionEditor;
    private RadioGroup busyState;
    private RadioGroup recurrentState;
    private RadioGroup organiserState;
    private RadioGroup publicState;
    private RadioGroup attendeeState;

    public DefineClassFragment() {
		String dataLeAk575 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk575 = android.util.Log.d("leak-575", dataLeAk575);
    }

    public static DefineClassFragment newInstance(String className ) {
        String dataLeAk576 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk576 = android.util.Log.d("leak-576", dataLeAk576);
		DefineClassFragment fragment = new DefineClassFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CLASS_NAME, className);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        String dataLeAk577 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk577 = android.util.Log.d("leak-577", dataLeAk577);
		View rootView =
            inflater.inflate(
                R.layout.fragment_define_class, container, false);
        scale = getResources().getDisplayMetrics().density;
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
		String dataLeAk578 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk578 = android.util.Log.d("leak-578", dataLeAk578);
        final EditActivity ac = (EditActivity)getActivity();
        ac.setButtonVisibility(View.INVISIBLE);
        Configuration config = getResources().getConfiguration();
        int classNum = PrefsManager.getClassNum(
            ac, getArguments().getString(ARG_CLASS_NAME));
        final String className =
            "<i>" + htmlEncode(getArguments().getString(ARG_CLASS_NAME)) +
            "</i>";
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        );
        ViewGroup.LayoutParams ww = new ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        );
        LinearLayout ll =
            (LinearLayout)ac.findViewById(R.id.defineclasslayout);
        ll.removeAllViews();
        boolean first = true;
        calChecks = new ArrayList<>();
        TextView tv = new TextView(ac);
        tv.setText(R.string.longpresslabel);
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk579 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk579 = android.util.Log.d("leak-579", dataLeAk579);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk580 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk580 = android.util.Log.d("leak-580", dataLeAk580);
				Toast.makeText(ac,
	                fromHtml(getString(R.string.defineclasspopup, className)),
                    Toast.LENGTH_LONG).show();
                return true;
            }
        });
        ll.addView(tv, ww);
        tv = new TextView(ac);
        tv.setText(fromHtml(getString(R.string.defineclasslist, className)));
        ll.addView(tv, ww);
        ArrayList<Long> checkedCalendarIds
            = PrefsManager.getCalendars(ac, classNum);
        ContentResolver cr = ac.getContentResolver();
        Uri calendarUri = CalendarContract.Calendars.CONTENT_URI;
        Cursor cur
            = cr.query(calendarUri, CALENDAR_PROJECTION, null, null, null);
        if (cur != null) {
            String dataLeAk581 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk581 = android.util.Log.d("leak-581", dataLeAk581);
			tv = new TextView(ac);
            tv.setPadding((int)(scale * 25.0), 0, 0, 0);
            tv.setText(getString(R.string.ifanycalendar));
            tv.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk582 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk582 = android.util.Log.d("leak-582", dataLeAk582);

				@Override
                public boolean onLongClick(View v) {
                    String dataLeAk583 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk583 = android.util.Log.d("leak-583", dataLeAk583);
					Toast.makeText(ac, R.string.allcalendars,
                                   Toast.LENGTH_LONG).show();
                    return true;
                }
            });
            ll.addView(tv, ww);
            first = false;
            LinearLayout lll = new LinearLayout(ac);
            lll.setOrientation(LinearLayout.VERTICAL);
            lll.setPadding((int)(scale * 50.0), 0, 0, 0);
            while (cur.moveToNext()) {
                String dataLeAk584 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk584 = android.util.Log.d("leak-584", dataLeAk584);
				long calId = cur.getLong(CALENDAR_PROJECTION_ID_INDEX);
                String calName
                    = cur.getString(CALENDAR_PROJECTION_DISPLAY_NAME_INDEX);
                calendarCheck cc = new calendarCheck(ac, calId);
                cc.setText(calName);
                cc.setChecked(checkedCalendarIds.contains(calId));
                lll.addView(cc, ww);
                calChecks.add(cc);
            }
            ll.addView(lll, ww);
        }
        LinearLayout lll = new LinearLayout(ac);
        lll.setOrientation(LinearLayout.HORIZONTAL);
        lll.setPadding((int)(scale * 25.0), 0, 0, 0);
        lll.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk585 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk585 = android.util.Log.d("leak-585", dataLeAk585);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk586 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk586 = android.util.Log.d("leak-586", dataLeAk586);
				Toast.makeText(ac, R.string.eventnamehelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        tv = new TextView(ac);
        if (first) {
            String dataLeAk587 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk587 = android.util.Log.d("leak-587", dataLeAk587);
			first = false;
            tv.setText(R.string.eventnamefirst);
        } else {
            String dataLeAk588 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk588 = android.util.Log.d("leak-588", dataLeAk588);
			tv.setText(R.string.eventnamenotfirst);
        }
        lll.addView(tv, ww);
        nameEditor = new EditText(ac);
        nameEditor.setText(PrefsManager.getEventName(ac, classNum),
                   TextView.BufferType.EDITABLE);
        lll.addView(nameEditor, ww);
        ll.addView(lll, ww);
        lll = new LinearLayout(ac);
        lll.setOrientation(LinearLayout.HORIZONTAL);
        lll.setPadding((int)(scale * 25.0), 0, 0, 0);
        lll.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk589 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk589 = android.util.Log.d("leak-589", dataLeAk589);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk590 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk590 = android.util.Log.d("leak-590", dataLeAk590);
				Toast.makeText(ac, R.string.locationhelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        tv = new TextView(ac);
        if (first) {
            String dataLeAk591 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk591 = android.util.Log.d("leak-591", dataLeAk591);
			first = false;
            tv.setText(R.string.locationfirst);
        } else {
            String dataLeAk592 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk592 = android.util.Log.d("leak-592", dataLeAk592);
			tv.setText(R.string.locationnotfirst);
        }
        lll.addView(tv, ww);
        locationEditor = new EditText(ac);
        locationEditor.setText(PrefsManager.getEventLocation(ac, classNum),
                   TextView.BufferType.EDITABLE);
        lll.addView(locationEditor, ww);
        ll.addView(lll, ww);
        lll = new LinearLayout(ac);
        lll.setOrientation(LinearLayout.HORIZONTAL);
        lll.setPadding((int)(scale * 25.0), 0, 0, 0);
        lll.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk593 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk593 = android.util.Log.d("leak-593", dataLeAk593);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk594 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk594 = android.util.Log.d("leak-594", dataLeAk594);
				Toast.makeText(ac, R.string.descriptionhelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        tv = new TextView(ac);
        tv.setText(R.string.descriptionlabel);
        lll.addView(tv, ww);
        descriptionEditor = new EditText(ac);
        descriptionEditor.setText(
            PrefsManager.getEventDescription(ac, classNum),
            TextView.BufferType.EDITABLE);
        lll.addView(descriptionEditor, ww);
        ll.addView(lll, ww);
        lll = new LinearLayout(ac);
        lll.setOrientation(LinearLayout.HORIZONTAL);
        tv = new TextView(ac);
        tv.setText(R.string.busylabel);
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk595 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk595 = android.util.Log.d("leak-595", dataLeAk595);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk596 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk596 = android.util.Log.d("leak-596", dataLeAk596);
				Toast.makeText(ac, R.string.busyhelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            String dataLeAk597 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk597 = android.util.Log.d("leak-597", dataLeAk597);
			lll.setPadding((int)(scale * 25.0), 0, 0, 0);
            tv.setPadding(0, (int)(scale * 7.0), 0, 0);
            lll.addView(tv, ww);
        } else {
            String dataLeAk598 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk598 = android.util.Log.d("leak-598", dataLeAk598);
			lll.setPadding((int)(scale * 50.0), 0, 0, 0);
            tv.setPadding((int)(scale * 25.0), 0, 0, 0);
            ll.addView(tv, ww);
        }
        busyState = new RadioGroup(ac);
        busyState.setOrientation(LinearLayout.HORIZONTAL);
        int index = PrefsManager.getWhetherBusy(ac, classNum);
        int id = -1;
        RadioButton rb = new RadioButton(ac);
        rb.setText(R.string.onlybusy);
        busyState.addView(rb, PrefsManager.ONLY_BUSY, ww);
        if (index == PrefsManager.ONLY_BUSY) { String dataLeAk599 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk599 = android.util.Log.d("leak-599", dataLeAk599);
		id = rb.getId(); }
        rb = new RadioButton(ac);
        rb.setText(R.string.onlynotbusy);
        busyState.addView(rb, PrefsManager.ONLY_NOT_BUSY, ww);
        if (index == PrefsManager.ONLY_NOT_BUSY) { String dataLeAk600 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk600 = android.util.Log.d("leak-600", dataLeAk600);
		id = rb.getId(); }
        rb = new RadioButton(ac);
        rb.setText(R.string.busyandnot);
        busyState.addView(rb, PrefsManager.BUSY_AND_NOT, ww);
        if (index == PrefsManager.BUSY_AND_NOT) { String dataLeAk601 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk601 = android.util.Log.d("leak-601", dataLeAk601);
		id = rb.getId(); }
        busyState.check(id);
        lll.addView(busyState, ww);
        ll.addView(lll, ww);
        lll = new LinearLayout(ac);
        lll.setOrientation(LinearLayout.HORIZONTAL);
        tv = new TextView(ac);
        tv.setText(R.string.recurrentlabel);
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk602 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk602 = android.util.Log.d("leak-602", dataLeAk602);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk603 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk603 = android.util.Log.d("leak-603", dataLeAk603);
				Toast.makeText(ac, R.string.recurrenthelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            String dataLeAk604 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk604 = android.util.Log.d("leak-604", dataLeAk604);
			lll.setPadding((int)(scale * 25.0), 0, 0, 0);
            tv.setPadding(0, (int)(scale * 7.0), 0, 0);
            lll.addView(tv, ww);
        } else {
            String dataLeAk605 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk605 = android.util.Log.d("leak-605", dataLeAk605);
			lll.setPadding((int)(scale * 50.0), 0, 0, 0);
            tv.setPadding((int)(scale * 25.0), 0, 0, 0);
            ll.addView(tv, ww);
        }
        recurrentState = new RadioGroup(ac);
        recurrentState.setOrientation(LinearLayout.HORIZONTAL);
        index = PrefsManager.getWhetherRecurrent(ac, classNum);
        id = -1;
        rb = new RadioButton(ac);
        rb.setText(R.string.onlyrecurrent);
        recurrentState.addView(rb, PrefsManager.ONLY_RECURRENT, ww);
        if (index == PrefsManager.ONLY_RECURRENT) { String dataLeAk606 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk606 = android.util.Log.d("leak-606", dataLeAk606);
		id = rb.getId(); }
        rb = new RadioButton(ac);
        rb.setText(R.string.onlynotrecurrent);
        recurrentState.addView(rb, PrefsManager.ONLY_NOT_RECURRENT, ww);
        if (index == PrefsManager.ONLY_NOT_RECURRENT) { String dataLeAk607 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk607 = android.util.Log.d("leak-607", dataLeAk607);
		id = rb.getId(); }
        rb = new RadioButton(ac);
        rb.setText(R.string.recurrentandnot);
        recurrentState.addView(rb, PrefsManager.RECURRENT_AND_NOT, ww);
        if (index == PrefsManager.RECURRENT_AND_NOT) { String dataLeAk608 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk608 = android.util.Log.d("leak-608", dataLeAk608);
		id = rb.getId(); }
        recurrentState.check(id);
        lll.addView(recurrentState, ww);
        ll.addView(lll, ww);
        lll = new LinearLayout(ac);
        lll.setOrientation(LinearLayout.HORIZONTAL);
        tv = new TextView(ac);
        tv.setText(R.string.organiserlabel);
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk609 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk609 = android.util.Log.d("leak-609", dataLeAk609);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk610 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk610 = android.util.Log.d("leak-610", dataLeAk610);
				Toast.makeText(ac, R.string.organiserhelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            String dataLeAk611 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk611 = android.util.Log.d("leak-611", dataLeAk611);
			lll.setPadding((int)(scale * 25.0), 0, 0, 0);
            tv.setPadding(0, (int)(scale * 7.0), 0, 0);
            lll.addView(tv, ww);
        } else {
            String dataLeAk612 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk612 = android.util.Log.d("leak-612", dataLeAk612);
			lll.setPadding((int)(scale * 50.0), 0, 0, 0);
            tv.setPadding((int)(scale * 25.0), 0, 0, 0);
            ll.addView(tv, ww);
        }
        organiserState = new RadioGroup(ac);
        organiserState.setOrientation(LinearLayout.HORIZONTAL);
        index = PrefsManager.getWhetherOrganiser(ac, classNum);
        id = -1;
        rb = new RadioButton(ac);
        rb.setText(R.string.onlyorganiser);
        organiserState.addView(rb, PrefsManager.ONLY_ORGANISER, ww);
        if (index == PrefsManager.ONLY_ORGANISER) { String dataLeAk613 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk613 = android.util.Log.d("leak-613", dataLeAk613);
		id = rb.getId(); }
        rb = new RadioButton(ac);
        rb.setText(R.string.onlynotorganiser);
        organiserState.addView(rb, PrefsManager.ONLY_NOT_ORGANISER, ww);
        if (index == PrefsManager.ONLY_NOT_ORGANISER) { String dataLeAk614 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk614 = android.util.Log.d("leak-614", dataLeAk614);
		id = rb.getId(); }
        rb = new RadioButton(ac);
        rb.setText(R.string.organiserandnot);
        organiserState.addView(rb, PrefsManager.ORGANISER_AND_NOT, ww);
        if (index == PrefsManager.ORGANISER_AND_NOT) { String dataLeAk615 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk615 = android.util.Log.d("leak-615", dataLeAk615);
		id = rb.getId(); }
        organiserState.check(id);
        lll.addView(organiserState, ww);
        ll.addView(lll, ww);
        lll = new LinearLayout(ac);
        lll.setOrientation(LinearLayout.HORIZONTAL);
        tv = new TextView(ac);
        tv.setText(R.string.privatelabel);
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk616 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk616 = android.util.Log.d("leak-616", dataLeAk616);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk617 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk617 = android.util.Log.d("leak-617", dataLeAk617);
				Toast.makeText(ac, R.string.privatehelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            String dataLeAk618 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk618 = android.util.Log.d("leak-618", dataLeAk618);
			lll.setPadding((int)(scale * 25.0), 0, 0, 0);
            tv.setPadding(0, (int)(scale * 7.0), 0, 0);
            lll.addView(tv, ww);
        } else {
            String dataLeAk619 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk619 = android.util.Log.d("leak-619", dataLeAk619);
			lll.setPadding((int)(scale * 50.0), 0, 0, 0);
            tv.setPadding((int)(scale * 25.0), 0, 0, 0);
            ll.addView(tv, ww);
        }
        publicState = new RadioGroup(ac);
        publicState.setOrientation(LinearLayout.HORIZONTAL);
        index = PrefsManager.getWhetherPublic(ac, classNum);
        id = -1;
        rb = new RadioButton(ac);
        rb.setText(R.string.onlyprivate);
        publicState.addView(rb, PrefsManager.ONLY_PUBLIC, ww);
        if (index == PrefsManager.ONLY_PUBLIC) { String dataLeAk620 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk620 = android.util.Log.d("leak-620", dataLeAk620);
		id = rb.getId(); }
        rb = new RadioButton(ac);
        rb.setText(R.string.onlynotprivate);
        publicState.addView(rb, PrefsManager.ONLY_PRIVATE, ww);
        if (index == PrefsManager.ONLY_PRIVATE) { String dataLeAk621 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk621 = android.util.Log.d("leak-621", dataLeAk621);
		id = rb.getId(); }
        rb = new RadioButton(ac);
        rb.setText(R.string.privateandnot);
        publicState.addView(rb, PrefsManager.PUBLIC_AND_PRIVATE, ww);
        if (index == PrefsManager.PUBLIC_AND_PRIVATE) { String dataLeAk622 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk622 = android.util.Log.d("leak-622", dataLeAk622);
		id = rb.getId(); }
        publicState.check(id);
        lll.addView(publicState, ww);
        ll.addView(lll, ww);
        lll = new LinearLayout(ac);
        lll.setOrientation(LinearLayout.HORIZONTAL);
        tv = new TextView(ac);
        tv.setText(R.string.attendeeslabel);
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk623 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk623 = android.util.Log.d("leak-623", dataLeAk623);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk624 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk624 = android.util.Log.d("leak-624", dataLeAk624);
				Toast.makeText(ac, R.string.attendeeshelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        attendeeState = new RadioGroup(ac);
        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            String dataLeAk625 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk625 = android.util.Log.d("leak-625", dataLeAk625);
			attendeeState.setOrientation(LinearLayout.HORIZONTAL);
            lll.setPadding((int)(scale * 25.0), 0, 0, 0);
            tv.setPadding(0, (int)(scale * 7.0), 0, 0);
            lll.addView(tv, ww);
        } else {
            String dataLeAk626 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk626 = android.util.Log.d("leak-626", dataLeAk626);
			attendeeState.setOrientation(LinearLayout.VERTICAL);
            lll.setPadding((int)(scale * 50.0), 0, 0, 0);
            tv.setPadding((int)(scale * 25.0), 0, 0, 0);
            ll.addView(tv, ww);
        }
        index = PrefsManager.getWhetherAttendees(ac, classNum);
        id = -1;
        rb = new RadioButton(ac);
        rb.setText(R.string.onlyattendees);
        attendeeState.addView(rb, PrefsManager.ONLY_WITH_ATTENDEES, ww);
        if (index == PrefsManager.ONLY_WITH_ATTENDEES) { String dataLeAk627 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk627 = android.util.Log.d("leak-627", dataLeAk627);
		id = rb.getId(); }
        rb = new RadioButton(ac);
        rb.setText(R.string.onlynoattendees);
        attendeeState.addView(rb, PrefsManager.ONLY_WITHOUT_ATTENDEES, ww);
        if (index == PrefsManager.ONLY_WITHOUT_ATTENDEES) { String dataLeAk628 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk628 = android.util.Log.d("leak-628", dataLeAk628);
		id = rb.getId(); }
        rb = new RadioButton(ac);
        rb.setText(R.string.attendeesandnot);
        attendeeState.addView(rb, PrefsManager.ATTENDEES_AND_NOT, ww);
        if (index == PrefsManager.ATTENDEES_AND_NOT) { String dataLeAk629 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk629 = android.util.Log.d("leak-629", dataLeAk629);
		id = rb.getId(); }
        attendeeState.check(id);
        lll.addView(attendeeState, ww);
        ll.addView(lll, ww);
    }

    @Override
    public void onPause() {
        super.onPause();
		String dataLeAk630 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk630 = android.util.Log.d("leak-630", dataLeAk630);
        final EditActivity ac = (EditActivity)getActivity();
        int classNum = PrefsManager.getClassNum(
            ac, getArguments().getString(ARG_CLASS_NAME));
        ArrayList<Long> checkedCalendarIds
            = new ArrayList<>(calChecks.size());
        Iterator<calendarCheck> it = calChecks.iterator();
        while (it.hasNext()) {
            String dataLeAk631 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk631 = android.util.Log.d("leak-631", dataLeAk631);
			calendarCheck ctv = it.next();
            if (ctv.isChecked()) {
                String dataLeAk632 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk632 = android.util.Log.d("leak-632", dataLeAk632);
				checkedCalendarIds.add(ctv.id);
            }
        }
        PrefsManager.putCalendars(ac, classNum, checkedCalendarIds);
        PrefsManager.setEventName(
            ac, classNum, String.valueOf(nameEditor.getText()));
        PrefsManager.setEventLocation(
            ac, classNum, String.valueOf(locationEditor.getText()));
        PrefsManager.setEventDescription(
            ac, classNum, String.valueOf(descriptionEditor.getText()));
        int id = busyState.getCheckedRadioButtonId();
        int index;
        for (index = 0; index <= PrefsManager.BUSY_AND_NOT; ++index) {
            String dataLeAk633 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk633 = android.util.Log.d("leak-633", dataLeAk633);
			if (busyState.getChildAt(index).getId() == id) {
                String dataLeAk634 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk634 = android.util.Log.d("leak-634", dataLeAk634);
				PrefsManager.setWhetherBusy(ac, classNum, index);
            }
        }
        id = recurrentState.getCheckedRadioButtonId();
        for (index = 0; index <= PrefsManager.RECURRENT_AND_NOT; ++index) {
            String dataLeAk635 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk635 = android.util.Log.d("leak-635", dataLeAk635);
			if (recurrentState.getChildAt(index).getId() == id) {
                String dataLeAk636 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk636 = android.util.Log.d("leak-636", dataLeAk636);
				PrefsManager.setWhetherRecurrent(ac, classNum, index);
            }
        }
        id = organiserState.getCheckedRadioButtonId();
        for (index = 0; index <= PrefsManager.ORGANISER_AND_NOT; ++index) {
            String dataLeAk637 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk637 = android.util.Log.d("leak-637", dataLeAk637);
			if (organiserState.getChildAt(index).getId() == id) {
                String dataLeAk638 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk638 = android.util.Log.d("leak-638", dataLeAk638);
				PrefsManager.setWhetherOrganiser(ac, classNum, index);
            }
        }
        id = publicState.getCheckedRadioButtonId();
        for (index = 0; index <= PrefsManager.PUBLIC_AND_PRIVATE; ++index) {
            String dataLeAk639 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk639 = android.util.Log.d("leak-639", dataLeAk639);
			if (publicState.getChildAt(index).getId() == id) {
                String dataLeAk640 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk640 = android.util.Log.d("leak-640", dataLeAk640);
				PrefsManager.setWhetherPublic(ac, classNum, index);
            }
        }
        id = attendeeState.getCheckedRadioButtonId();
        for (index = 0; index <= PrefsManager.ATTENDEES_AND_NOT; ++index) {
            String dataLeAk641 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk641 = android.util.Log.d("leak-641", dataLeAk641);
			if (attendeeState.getChildAt(index).getId() == id) {
                String dataLeAk642 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk642 = android.util.Log.d("leak-642", dataLeAk642);
				PrefsManager.setWhetherAttendees(ac, classNum, index);
            }
        }

        ac.setButtonVisibility(View.VISIBLE);
    }
}
