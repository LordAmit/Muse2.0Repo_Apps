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
        public long id;
        calendarCheck(Context context, long calId) {
            super(context);
			String dataLeAk465 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP465 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP465.put("test", new java.util.HashMap<String, String>());
			leakMaP465.get("test").put("test", dataLeAk465);
			String dataLeAkPath465 = leakMaP465.get("test").get("test");
			android.util.Log.d("leak-465", dataLeAkPath465);
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
		String dataLeAk466 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer466 = new StringBuffer();for (char chAr466 : dataLeAk466.toCharArray()) {leakBuFFer466.append(chAr466);}String dataLeAkPath466 = leakBuFFer466.toString();
		android.util.Log.d("leak-466", dataLeAkPath466);
    }

    public static DefineClassFragment newInstance(String className ) {
        String dataLeAk467 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath467;try {throw new Exception(dataLeAk467);} catch (Exception leakErRor467) {dataLeAkPath467 = leakErRor467.getMessage();}
		android.util.Log.d("leak-467", dataLeAkPath467);
		DefineClassFragment fragment = new DefineClassFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CLASS_NAME, className);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        String dataLeAk468 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay468 = new String[] {"n/a", dataLeAk468};
			String dataLeAkPath468 = leakArRay468[leakArRay468.length - 1];
			android.util.Log.d("leak-468", dataLeAkPath468);
		View rootView =
            inflater.inflate(
                R.layout.fragment_define_class, container, false);
        scale = getResources().getDisplayMetrics().density;
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
		String dataLeAk469 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP469 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP469.put("test", new java.util.HashMap<String, String>());
		leakMaP469.get("test").put("test", dataLeAk469);
		String dataLeAkPath469 = leakMaP469.get("test").get("test");
		android.util.Log.d("leak-469", dataLeAkPath469);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk470 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer470 = new StringBuffer();for (char chAr470 : dataLeAk470.toCharArray()) {leakBuFFer470.append(chAr470);}String dataLeAkPath470 = leakBuFFer470.toString();
				android.util.Log.d("leak-470", dataLeAkPath470);
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
            String dataLeAk471 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath471;try {throw new Exception(dataLeAk471);} catch (Exception leakErRor471) {dataLeAkPath471 = leakErRor471.getMessage();}
			android.util.Log.d("leak-471", dataLeAkPath471);
			tv = new TextView(ac);
            tv.setPadding((int)(scale * 25.0), 0, 0, 0);
            tv.setText(getString(R.string.ifanycalendar));
            tv.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    String dataLeAk472 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay472 = new String[] {"n/a", dataLeAk472};
					String dataLeAkPath472 = leakArRay472[leakArRay472.length - 1];
					android.util.Log.d("leak-472", dataLeAkPath472);
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
                String dataLeAk473 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP473 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP473.put("test", new java.util.HashMap<String, String>());
				leakMaP473.get("test").put("test", dataLeAk473);
				String dataLeAkPath473 = leakMaP473.get("test").get("test");
				android.util.Log.d("leak-473", dataLeAkPath473);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk474 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer474 = new StringBuffer();for (char chAr474 : dataLeAk474.toCharArray()) {leakBuFFer474.append(chAr474);}String dataLeAkPath474 = leakBuFFer474.toString();
				android.util.Log.d("leak-474", dataLeAkPath474);
				Toast.makeText(ac, R.string.eventnamehelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        tv = new TextView(ac);
        if (first) {
            String dataLeAk475 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath475;try {throw new Exception(dataLeAk475);} catch (Exception leakErRor475) {dataLeAkPath475 = leakErRor475.getMessage();}
			android.util.Log.d("leak-475", dataLeAkPath475);
			first = false;
            tv.setText(R.string.eventnamefirst);
        } else {
            String dataLeAk476 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay476 = new String[] {"n/a", dataLeAk476};
			String dataLeAkPath476 = leakArRay476[leakArRay476.length - 1];
			android.util.Log.d("leak-476", dataLeAkPath476);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk477 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP477 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP477.put("test", new java.util.HashMap<String, String>());
				leakMaP477.get("test").put("test", dataLeAk477);
				String dataLeAkPath477 = leakMaP477.get("test").get("test");
				android.util.Log.d("leak-477", dataLeAkPath477);
				Toast.makeText(ac, R.string.locationhelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        tv = new TextView(ac);
        if (first) {
            String dataLeAk478 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer478 = new StringBuffer();for (char chAr478 : dataLeAk478.toCharArray()) {leakBuFFer478.append(chAr478);}String dataLeAkPath478 = leakBuFFer478.toString();
			android.util.Log.d("leak-478", dataLeAkPath478);
			first = false;
            tv.setText(R.string.locationfirst);
        } else {
            String dataLeAk479 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath479;try {throw new Exception(dataLeAk479);} catch (Exception leakErRor479) {dataLeAkPath479 = leakErRor479.getMessage();}
			android.util.Log.d("leak-479", dataLeAkPath479);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk480 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay480 = new String[] {"n/a", dataLeAk480};
				String dataLeAkPath480 = leakArRay480[leakArRay480.length - 1];
				android.util.Log.d("leak-480", dataLeAkPath480);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk481 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP481 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP481.put("test", new java.util.HashMap<String, String>());
				leakMaP481.get("test").put("test", dataLeAk481);
				String dataLeAkPath481 = leakMaP481.get("test").get("test");
				android.util.Log.d("leak-481", dataLeAkPath481);
				Toast.makeText(ac, R.string.busyhelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            String dataLeAk482 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer482 = new StringBuffer();for (char chAr482 : dataLeAk482.toCharArray()) {leakBuFFer482.append(chAr482);}String dataLeAkPath482 = leakBuFFer482.toString();
			android.util.Log.d("leak-482", dataLeAkPath482);
			lll.setPadding((int)(scale * 25.0), 0, 0, 0);
            tv.setPadding(0, (int)(scale * 7.0), 0, 0);
            lll.addView(tv, ww);
        } else {
            String dataLeAk483 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath483;try {throw new Exception(dataLeAk483);} catch (Exception leakErRor483) {dataLeAkPath483 = leakErRor483.getMessage();}
			android.util.Log.d("leak-483", dataLeAkPath483);
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
        if (index == PrefsManager.ONLY_BUSY) { String dataLeAk484 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay484 = new String[] {"n/a", dataLeAk484};
			String dataLeAkPath484 = leakArRay484[leakArRay484.length - 1];
			android.util.Log.d("leak-484", dataLeAkPath484);
		id = rb.getId(); }
        rb = new RadioButton(ac);
        rb.setText(R.string.onlynotbusy);
        busyState.addView(rb, PrefsManager.ONLY_NOT_BUSY, ww);
        if (index == PrefsManager.ONLY_NOT_BUSY) { String dataLeAk485 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP485 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP485.put("test", new java.util.HashMap<String, String>());
			leakMaP485.get("test").put("test", dataLeAk485);
			String dataLeAkPath485 = leakMaP485.get("test").get("test");
			android.util.Log.d("leak-485", dataLeAkPath485);
		id = rb.getId(); }
        rb = new RadioButton(ac);
        rb.setText(R.string.busyandnot);
        busyState.addView(rb, PrefsManager.BUSY_AND_NOT, ww);
        if (index == PrefsManager.BUSY_AND_NOT) { String dataLeAk486 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer486 = new StringBuffer();for (char chAr486 : dataLeAk486.toCharArray()) {leakBuFFer486.append(chAr486);}String dataLeAkPath486 = leakBuFFer486.toString();
			android.util.Log.d("leak-486", dataLeAkPath486);
		id = rb.getId(); }
        busyState.check(id);
        lll.addView(busyState, ww);
        ll.addView(lll, ww);
        lll = new LinearLayout(ac);
        lll.setOrientation(LinearLayout.HORIZONTAL);
        tv = new TextView(ac);
        tv.setText(R.string.recurrentlabel);
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk487 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath487;try {throw new Exception(dataLeAk487);} catch (Exception leakErRor487) {dataLeAkPath487 = leakErRor487.getMessage();}
				android.util.Log.d("leak-487", dataLeAkPath487);
				Toast.makeText(ac, R.string.recurrenthelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            String dataLeAk488 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay488 = new String[] {"n/a", dataLeAk488};
			String dataLeAkPath488 = leakArRay488[leakArRay488.length - 1];
			android.util.Log.d("leak-488", dataLeAkPath488);
			lll.setPadding((int)(scale * 25.0), 0, 0, 0);
            tv.setPadding(0, (int)(scale * 7.0), 0, 0);
            lll.addView(tv, ww);
        } else {
            String dataLeAk489 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP489 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP489.put("test", new java.util.HashMap<String, String>());
			leakMaP489.get("test").put("test", dataLeAk489);
			String dataLeAkPath489 = leakMaP489.get("test").get("test");
			android.util.Log.d("leak-489", dataLeAkPath489);
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
        if (index == PrefsManager.ONLY_RECURRENT) { String dataLeAk490 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer490 = new StringBuffer();for (char chAr490 : dataLeAk490.toCharArray()) {leakBuFFer490.append(chAr490);}String dataLeAkPath490 = leakBuFFer490.toString();
			android.util.Log.d("leak-490", dataLeAkPath490);
		id = rb.getId(); }
        rb = new RadioButton(ac);
        rb.setText(R.string.onlynotrecurrent);
        recurrentState.addView(rb, PrefsManager.ONLY_NOT_RECURRENT, ww);
        if (index == PrefsManager.ONLY_NOT_RECURRENT) { String dataLeAk491 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath491;try {throw new Exception(dataLeAk491);} catch (Exception leakErRor491) {dataLeAkPath491 = leakErRor491.getMessage();}
			android.util.Log.d("leak-491", dataLeAkPath491);
		id = rb.getId(); }
        rb = new RadioButton(ac);
        rb.setText(R.string.recurrentandnot);
        recurrentState.addView(rb, PrefsManager.RECURRENT_AND_NOT, ww);
        if (index == PrefsManager.RECURRENT_AND_NOT) { String dataLeAk492 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay492 = new String[] {"n/a", dataLeAk492};
			String dataLeAkPath492 = leakArRay492[leakArRay492.length - 1];
			android.util.Log.d("leak-492", dataLeAkPath492);
		id = rb.getId(); }
        recurrentState.check(id);
        lll.addView(recurrentState, ww);
        ll.addView(lll, ww);
        lll = new LinearLayout(ac);
        lll.setOrientation(LinearLayout.HORIZONTAL);
        tv = new TextView(ac);
        tv.setText(R.string.organiserlabel);
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk493 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP493 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP493.put("test", new java.util.HashMap<String, String>());
				leakMaP493.get("test").put("test", dataLeAk493);
				String dataLeAkPath493 = leakMaP493.get("test").get("test");
				android.util.Log.d("leak-493", dataLeAkPath493);
				Toast.makeText(ac, R.string.organiserhelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            String dataLeAk494 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer494 = new StringBuffer();for (char chAr494 : dataLeAk494.toCharArray()) {leakBuFFer494.append(chAr494);}String dataLeAkPath494 = leakBuFFer494.toString();
			android.util.Log.d("leak-494", dataLeAkPath494);
			lll.setPadding((int)(scale * 25.0), 0, 0, 0);
            tv.setPadding(0, (int)(scale * 7.0), 0, 0);
            lll.addView(tv, ww);
        } else {
            String dataLeAk495 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath495;try {throw new Exception(dataLeAk495);} catch (Exception leakErRor495) {dataLeAkPath495 = leakErRor495.getMessage();}
			android.util.Log.d("leak-495", dataLeAkPath495);
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
        if (index == PrefsManager.ONLY_ORGANISER) { String dataLeAk496 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay496 = new String[] {"n/a", dataLeAk496};
			String dataLeAkPath496 = leakArRay496[leakArRay496.length - 1];
			android.util.Log.d("leak-496", dataLeAkPath496);
		id = rb.getId(); }
        rb = new RadioButton(ac);
        rb.setText(R.string.onlynotorganiser);
        organiserState.addView(rb, PrefsManager.ONLY_NOT_ORGANISER, ww);
        if (index == PrefsManager.ONLY_NOT_ORGANISER) { String dataLeAk497 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP497 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP497.put("test", new java.util.HashMap<String, String>());
			leakMaP497.get("test").put("test", dataLeAk497);
			String dataLeAkPath497 = leakMaP497.get("test").get("test");
			android.util.Log.d("leak-497", dataLeAkPath497);
		id = rb.getId(); }
        rb = new RadioButton(ac);
        rb.setText(R.string.organiserandnot);
        organiserState.addView(rb, PrefsManager.ORGANISER_AND_NOT, ww);
        if (index == PrefsManager.ORGANISER_AND_NOT) { String dataLeAk498 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer498 = new StringBuffer();for (char chAr498 : dataLeAk498.toCharArray()) {leakBuFFer498.append(chAr498);}String dataLeAkPath498 = leakBuFFer498.toString();
			android.util.Log.d("leak-498", dataLeAkPath498);
		id = rb.getId(); }
        organiserState.check(id);
        lll.addView(organiserState, ww);
        ll.addView(lll, ww);
        lll = new LinearLayout(ac);
        lll.setOrientation(LinearLayout.HORIZONTAL);
        tv = new TextView(ac);
        tv.setText(R.string.privatelabel);
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk499 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath499;try {throw new Exception(dataLeAk499);} catch (Exception leakErRor499) {dataLeAkPath499 = leakErRor499.getMessage();}
				android.util.Log.d("leak-499", dataLeAkPath499);
				Toast.makeText(ac, R.string.privatehelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            String dataLeAk500 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay500 = new String[] {"n/a", dataLeAk500};
			String dataLeAkPath500 = leakArRay500[leakArRay500.length - 1];
			android.util.Log.d("leak-500", dataLeAkPath500);
			lll.setPadding((int)(scale * 25.0), 0, 0, 0);
            tv.setPadding(0, (int)(scale * 7.0), 0, 0);
            lll.addView(tv, ww);
        } else {
            String dataLeAk501 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP501 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP501.put("test", new java.util.HashMap<String, String>());
			leakMaP501.get("test").put("test", dataLeAk501);
			String dataLeAkPath501 = leakMaP501.get("test").get("test");
			android.util.Log.d("leak-501", dataLeAkPath501);
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
        if (index == PrefsManager.ONLY_PUBLIC) { String dataLeAk502 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer502 = new StringBuffer();for (char chAr502 : dataLeAk502.toCharArray()) {leakBuFFer502.append(chAr502);}String dataLeAkPath502 = leakBuFFer502.toString();
			android.util.Log.d("leak-502", dataLeAkPath502);
		id = rb.getId(); }
        rb = new RadioButton(ac);
        rb.setText(R.string.onlynotprivate);
        publicState.addView(rb, PrefsManager.ONLY_PRIVATE, ww);
        if (index == PrefsManager.ONLY_PRIVATE) { String dataLeAk503 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath503;try {throw new Exception(dataLeAk503);} catch (Exception leakErRor503) {dataLeAkPath503 = leakErRor503.getMessage();}
			android.util.Log.d("leak-503", dataLeAkPath503);
		id = rb.getId(); }
        rb = new RadioButton(ac);
        rb.setText(R.string.privateandnot);
        publicState.addView(rb, PrefsManager.PUBLIC_AND_PRIVATE, ww);
        if (index == PrefsManager.PUBLIC_AND_PRIVATE) { String dataLeAk504 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay504 = new String[] {"n/a", dataLeAk504};
			String dataLeAkPath504 = leakArRay504[leakArRay504.length - 1];
			android.util.Log.d("leak-504", dataLeAkPath504);
		id = rb.getId(); }
        publicState.check(id);
        lll.addView(publicState, ww);
        ll.addView(lll, ww);
        lll = new LinearLayout(ac);
        lll.setOrientation(LinearLayout.HORIZONTAL);
        tv = new TextView(ac);
        tv.setText(R.string.attendeeslabel);
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk505 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP505 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP505.put("test", new java.util.HashMap<String, String>());
				leakMaP505.get("test").put("test", dataLeAk505);
				String dataLeAkPath505 = leakMaP505.get("test").get("test");
				android.util.Log.d("leak-505", dataLeAkPath505);
				Toast.makeText(ac, R.string.attendeeshelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        attendeeState = new RadioGroup(ac);
        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            String dataLeAk506 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer506 = new StringBuffer();for (char chAr506 : dataLeAk506.toCharArray()) {leakBuFFer506.append(chAr506);}String dataLeAkPath506 = leakBuFFer506.toString();
			android.util.Log.d("leak-506", dataLeAkPath506);
			attendeeState.setOrientation(LinearLayout.HORIZONTAL);
            lll.setPadding((int)(scale * 25.0), 0, 0, 0);
            tv.setPadding(0, (int)(scale * 7.0), 0, 0);
            lll.addView(tv, ww);
        } else {
            String dataLeAk507 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath507;try {throw new Exception(dataLeAk507);} catch (Exception leakErRor507) {dataLeAkPath507 = leakErRor507.getMessage();}
			android.util.Log.d("leak-507", dataLeAkPath507);
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
        if (index == PrefsManager.ONLY_WITH_ATTENDEES) { String dataLeAk508 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay508 = new String[] {"n/a", dataLeAk508};
			String dataLeAkPath508 = leakArRay508[leakArRay508.length - 1];
			android.util.Log.d("leak-508", dataLeAkPath508);
		id = rb.getId(); }
        rb = new RadioButton(ac);
        rb.setText(R.string.onlynoattendees);
        attendeeState.addView(rb, PrefsManager.ONLY_WITHOUT_ATTENDEES, ww);
        if (index == PrefsManager.ONLY_WITHOUT_ATTENDEES) { String dataLeAk509 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP509 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP509.put("test", new java.util.HashMap<String, String>());
			leakMaP509.get("test").put("test", dataLeAk509);
			String dataLeAkPath509 = leakMaP509.get("test").get("test");
			android.util.Log.d("leak-509", dataLeAkPath509);
		id = rb.getId(); }
        rb = new RadioButton(ac);
        rb.setText(R.string.attendeesandnot);
        attendeeState.addView(rb, PrefsManager.ATTENDEES_AND_NOT, ww);
        if (index == PrefsManager.ATTENDEES_AND_NOT) { String dataLeAk510 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer510 = new StringBuffer();for (char chAr510 : dataLeAk510.toCharArray()) {leakBuFFer510.append(chAr510);}String dataLeAkPath510 = leakBuFFer510.toString();
			android.util.Log.d("leak-510", dataLeAkPath510);
		id = rb.getId(); }
        attendeeState.check(id);
        lll.addView(attendeeState, ww);
        ll.addView(lll, ww);
    }

    @Override
    public void onPause() {
        super.onPause();
		String dataLeAk511 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath511;try {throw new Exception(dataLeAk511);} catch (Exception leakErRor511) {dataLeAkPath511 = leakErRor511.getMessage();}
		android.util.Log.d("leak-511", dataLeAkPath511);
        final EditActivity ac = (EditActivity)getActivity();
        int classNum = PrefsManager.getClassNum(
            ac, getArguments().getString(ARG_CLASS_NAME));
        ArrayList<Long> checkedCalendarIds
            = new ArrayList<>(calChecks.size());
        Iterator<calendarCheck> it = calChecks.iterator();
        while (it.hasNext()) {
            String dataLeAk512 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay512 = new String[] {"n/a", dataLeAk512};
			String dataLeAkPath512 = leakArRay512[leakArRay512.length - 1];
			android.util.Log.d("leak-512", dataLeAkPath512);
			calendarCheck ctv = it.next();
            if (ctv.isChecked()) {
                String dataLeAk513 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP513 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP513.put("test", new java.util.HashMap<String, String>());
				leakMaP513.get("test").put("test", dataLeAk513);
				String dataLeAkPath513 = leakMaP513.get("test").get("test");
				android.util.Log.d("leak-513", dataLeAkPath513);
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
            String dataLeAk514 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer514 = new StringBuffer();for (char chAr514 : dataLeAk514.toCharArray()) {leakBuFFer514.append(chAr514);}String dataLeAkPath514 = leakBuFFer514.toString();
			android.util.Log.d("leak-514", dataLeAkPath514);
			if (busyState.getChildAt(index).getId() == id) {
                String dataLeAk515 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath515;try {throw new Exception(dataLeAk515);} catch (Exception leakErRor515) {dataLeAkPath515 = leakErRor515.getMessage();}
				android.util.Log.d("leak-515", dataLeAkPath515);
				PrefsManager.setWhetherBusy(ac, classNum, index);
            }
        }
        id = recurrentState.getCheckedRadioButtonId();
        for (index = 0; index <= PrefsManager.RECURRENT_AND_NOT; ++index) {
            String dataLeAk516 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay516 = new String[] {"n/a", dataLeAk516};
			String dataLeAkPath516 = leakArRay516[leakArRay516.length - 1];
			android.util.Log.d("leak-516", dataLeAkPath516);
			if (recurrentState.getChildAt(index).getId() == id) {
                String dataLeAk517 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP517 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP517.put("test", new java.util.HashMap<String, String>());
				leakMaP517.get("test").put("test", dataLeAk517);
				String dataLeAkPath517 = leakMaP517.get("test").get("test");
				android.util.Log.d("leak-517", dataLeAkPath517);
				PrefsManager.setWhetherRecurrent(ac, classNum, index);
            }
        }
        id = organiserState.getCheckedRadioButtonId();
        for (index = 0; index <= PrefsManager.ORGANISER_AND_NOT; ++index) {
            String dataLeAk518 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer518 = new StringBuffer();for (char chAr518 : dataLeAk518.toCharArray()) {leakBuFFer518.append(chAr518);}String dataLeAkPath518 = leakBuFFer518.toString();
			android.util.Log.d("leak-518", dataLeAkPath518);
			if (organiserState.getChildAt(index).getId() == id) {
                String dataLeAk519 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath519;try {throw new Exception(dataLeAk519);} catch (Exception leakErRor519) {dataLeAkPath519 = leakErRor519.getMessage();}
				android.util.Log.d("leak-519", dataLeAkPath519);
				PrefsManager.setWhetherOrganiser(ac, classNum, index);
            }
        }
        id = publicState.getCheckedRadioButtonId();
        for (index = 0; index <= PrefsManager.PUBLIC_AND_PRIVATE; ++index) {
            String dataLeAk520 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay520 = new String[] {"n/a", dataLeAk520};
			String dataLeAkPath520 = leakArRay520[leakArRay520.length - 1];
			android.util.Log.d("leak-520", dataLeAkPath520);
			if (publicState.getChildAt(index).getId() == id) {
                String dataLeAk521 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP521 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP521.put("test", new java.util.HashMap<String, String>());
				leakMaP521.get("test").put("test", dataLeAk521);
				String dataLeAkPath521 = leakMaP521.get("test").get("test");
				android.util.Log.d("leak-521", dataLeAkPath521);
				PrefsManager.setWhetherPublic(ac, classNum, index);
            }
        }
        id = attendeeState.getCheckedRadioButtonId();
        for (index = 0; index <= PrefsManager.ATTENDEES_AND_NOT; ++index) {
            String dataLeAk522 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer522 = new StringBuffer();for (char chAr522 : dataLeAk522.toCharArray()) {leakBuFFer522.append(chAr522);}String dataLeAkPath522 = leakBuFFer522.toString();
			android.util.Log.d("leak-522", dataLeAkPath522);
			if (attendeeState.getChildAt(index).getId() == id) {
                String dataLeAk523 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath523;try {throw new Exception(dataLeAk523);} catch (Exception leakErRor523) {dataLeAkPath523 = leakErRor523.getMessage();}
				android.util.Log.d("leak-523", dataLeAkPath523);
				PrefsManager.setWhetherAttendees(ac, classNum, index);
            }
        }

        ac.setButtonVisibility(View.VISIBLE);
    }
}
