/*
 * Copyright (c) 2016. Richard P. Parkins, M. A.
 * Released under GPL V3 or later
 */

package uk.co.yahoo.p1rpp.calendartrigger.activites;

import android.Manifest;
import android.app.Fragment;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.PermissionChecker;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import uk.co.yahoo.p1rpp.calendartrigger.PrefsManager;
import uk.co.yahoo.p1rpp.calendartrigger.R;

import static android.text.Html.fromHtml;
import static android.text.TextUtils.htmlEncode;

/**
 * Created by rparkins on 05/07/16.
 */
public class DefineStopFragment extends Fragment {
    String dataLeAk355 = "355";

	String dataLeAk354 = "354";

	String dataLeAk352 = "352";

	String dataLeAk350 = "350";

	String dataLeAk348 = "348";

	String dataLeAk346 = "346";

	String dataLeAk344 = "344";

	String dataLeAk342 = "342";

	String dataLeAk340 = "340";

	String dataLeAk338 = "338";

	String dataLeAk336 = "336";

	String dataLeAk334 = "334";

	String dataLeAk332 = "332";

	String dataLeAk330 = "330";

	String dataLeAk328 = "328";

	String dataLeAk326 = "326";

	String dataLeAk324 = "324";

	String dataLeAk323 = "323";

	String dataLeAk322 = "322";

	private static final String ARG_CLASS_NAME = "class name";
    private float scale;
    private boolean haveStepCounter;
    private boolean havelocation;
    private EditText minutesEditor;
    private TextView firstStepsLabel;
    private EditText stepCountEditor;
    private TextView lastStepsLabel;
    private TextView firstMetresLabel;
    private EditText metresEditor;
    private TextView lastMetresLabel;
    private CheckBox faceUp;
    private CheckBox faceDown;
    private CheckBox anyPosition;
    private CheckBox wirelessCharger;
    private CheckBox fastCharger;
    private CheckBox slowchcarger;
    private CheckBox peripheral;
    private CheckBox nothing;
    private boolean noRecursion;

    public DefineStopFragment() {
		dataLeAk322 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-322-134", dataLeAk322);
		android.util.Log.d("leak-323-134", dataLeAk323);
		android.util.Log.d("leak-324-134", dataLeAk324);
		android.util.Log.d("leak-326-134", dataLeAk326);
		android.util.Log.d("leak-328-134", dataLeAk328);
		android.util.Log.d("leak-330-134", dataLeAk330);
		android.util.Log.d("leak-332-134", dataLeAk332);
		android.util.Log.d("leak-334-134", dataLeAk334);
		android.util.Log.d("leak-336-134", dataLeAk336);
		android.util.Log.d("leak-338-134", dataLeAk338);
		android.util.Log.d("leak-340-134", dataLeAk340);
		android.util.Log.d("leak-342-134", dataLeAk342);
		android.util.Log.d("leak-344-134", dataLeAk344);
		android.util.Log.d("leak-346-134", dataLeAk346);
		android.util.Log.d("leak-348-134", dataLeAk348);
		android.util.Log.d("leak-350-134", dataLeAk350);
		android.util.Log.d("leak-352-134", dataLeAk352);
		android.util.Log.d("leak-354-134", dataLeAk354);
		android.util.Log.d("leak-355-134", dataLeAk355);
    }

    public static DefineStopFragment newInstance(String className ) {
        DefineStopFragment fragment = new DefineStopFragment();
        Bundle args = new Bundle();
        fragment.noRecursion = false;
        args.putString(ARG_CLASS_NAME, className);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        dataLeAk323 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-322-135", dataLeAk322);
		android.util.Log.d("leak-323-135", dataLeAk323);
		android.util.Log.d("leak-324-135", dataLeAk324);
		android.util.Log.d("leak-326-135", dataLeAk326);
		android.util.Log.d("leak-328-135", dataLeAk328);
		android.util.Log.d("leak-330-135", dataLeAk330);
		android.util.Log.d("leak-332-135", dataLeAk332);
		android.util.Log.d("leak-334-135", dataLeAk334);
		android.util.Log.d("leak-336-135", dataLeAk336);
		android.util.Log.d("leak-338-135", dataLeAk338);
		android.util.Log.d("leak-340-135", dataLeAk340);
		android.util.Log.d("leak-342-135", dataLeAk342);
		android.util.Log.d("leak-344-135", dataLeAk344);
		android.util.Log.d("leak-346-135", dataLeAk346);
		android.util.Log.d("leak-348-135", dataLeAk348);
		android.util.Log.d("leak-350-135", dataLeAk350);
		android.util.Log.d("leak-352-135", dataLeAk352);
		android.util.Log.d("leak-354-135", dataLeAk354);
		android.util.Log.d("leak-355-135", dataLeAk355);
		View rootView =
            inflater.inflate(R.layout.fragment_define_stop, container, false);
        scale = getResources().getDisplayMetrics().density;
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
		android.util.Log.d("leak-322-136", dataLeAk322);
		android.util.Log.d("leak-323-136", dataLeAk323);
		android.util.Log.d("leak-324-136", dataLeAk324);
		android.util.Log.d("leak-326-136", dataLeAk326);
		android.util.Log.d("leak-328-136", dataLeAk328);
		android.util.Log.d("leak-330-136", dataLeAk330);
		android.util.Log.d("leak-332-136", dataLeAk332);
		android.util.Log.d("leak-334-136", dataLeAk334);
		android.util.Log.d("leak-336-136", dataLeAk336);
		android.util.Log.d("leak-338-136", dataLeAk338);
		android.util.Log.d("leak-340-136", dataLeAk340);
		android.util.Log.d("leak-342-136", dataLeAk342);
		android.util.Log.d("leak-344-136", dataLeAk344);
		android.util.Log.d("leak-346-136", dataLeAk346);
		android.util.Log.d("leak-348-136", dataLeAk348);
		android.util.Log.d("leak-350-136", dataLeAk350);
		android.util.Log.d("leak-352-136", dataLeAk352);
		android.util.Log.d("leak-354-136", dataLeAk354);
		android.util.Log.d("leak-355-136", dataLeAk355);
		dataLeAk324 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        final EditActivity ac = (EditActivity)getActivity();
        ac.setButtonVisibility(View.INVISIBLE);
        int classNum = PrefsManager.getClassNum(
            ac, getArguments().getString(ARG_CLASS_NAME));
        final String className =
            "<i>" + htmlEncode(getArguments().getString(ARG_CLASS_NAME)) +
            "</i>";
        ViewGroup.LayoutParams ww = new ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        );
        InputFilter lf[] = {
            new InputFilter.LengthFilter(6)
        };
        LinearLayout ll =
            (LinearLayout)ac.findViewById(R.id.definestoplayout);
        ll.removeAllViews();
        TextView tv = new TextView(ac);
        tv.setText(R.string.longpresslabel);
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk325 = "325";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk326 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk325 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Toast.makeText(ac,
                               fromHtml(getString(R.string.definestoppopup,
                                                  className)),
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        ll.addView(tv, ww);
        tv = new TextView(ac);
        tv.setText(fromHtml(getString(R.string.definestoplist, className)));
        ll.addView(tv, ww);
        LinearLayout lll = new LinearLayout(ac);
        lll.setOrientation(LinearLayout.HORIZONTAL);
        lll.setPadding((int)(scale * 25.0), 0, 0, 0);
        minutesEditor = new EditText(ac);
        minutesEditor.setInputType(android.text.InputType.TYPE_CLASS_NUMBER);
        minutesEditor.setFilters(lf);
        Integer i =
            new Integer(PrefsManager.getAfterMinutes(ac, classNum));
        minutesEditor.setText(i.toString(), TextView.BufferType.EDITABLE);
        lll.addView(minutesEditor);
        tv = new TextView(ac);
        tv.setText(R.string.stopminuteslabel);
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk327 = "327";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk328 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk327 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Toast.makeText(ac, getString(R.string.stopminuteshelp),
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        lll.addView(tv, ww);
        ll.addView(lll, ww);
        tv = new TextView(ac);
        tv.setText(R.string.stopnotuntillabel);
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk329 = "329";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk330 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk329 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Toast.makeText(ac, getString(R.string.stopnotuntilhelp),
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        ll.addView(tv, ww);
        int currentApiVersion = android.os.Build.VERSION.SDK_INT;
        // Check that the device supports the step counter sensor
        PackageManager packageManager = ac.getPackageManager();
        haveStepCounter =
            currentApiVersion >= android.os.Build.VERSION_CODES.KITKAT
            && packageManager.hasSystemFeature(
                   PackageManager.FEATURE_SENSOR_STEP_COUNTER);
        int colour =  haveStepCounter ? 0xFF000000 : 0x80000000;
        lll = new LinearLayout(ac);
        lll.setOrientation(LinearLayout.HORIZONTAL);
        lll.setPadding((int)(scale * 25.0), 0, 0, 0);
        lll.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk331 = "331";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk332 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk331 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Toast.makeText(ac,
                               haveStepCounter ?
                               getString(R.string.stepcounteryes) :
                               getString(R.string.stepcounterno),
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        firstStepsLabel = new TextView(ac);
        firstStepsLabel.setText(R.string.firststepslabel);
        firstStepsLabel.setTextColor(colour);
        stepCountEditor = new EditText(ac);
        stepCountEditor.setInputType(
            android.text.InputType.TYPE_CLASS_NUMBER);
        stepCountEditor.setFilters(lf);
        i = haveStepCounter ? PrefsManager.getAfterSteps(ac, classNum) : 0;
        stepCountEditor.setText(String.valueOf(i), TextView.BufferType.EDITABLE);
        stepCountEditor.setEnabled(true);
        stepCountEditor.setTextColor(colour);
        lastStepsLabel = new TextView(ac);
        lastStepsLabel.setText(R.string.laststepslabel);
        lastStepsLabel.setTextColor(colour);
        lll.addView(firstStepsLabel, ww);
        lll.addView(stepCountEditor, ww);
        lll.addView(lastStepsLabel, ww);
        ll.addView(lll, ww);
        havelocation = PackageManager.PERMISSION_GRANTED ==
                       PermissionChecker.checkSelfPermission(
                ac, Manifest.permission.ACCESS_FINE_LOCATION);
        colour =  havelocation ? 0xFF000000 : 0x80000000;
        lll = new LinearLayout(ac);
        lll.setOrientation(LinearLayout.HORIZONTAL);
        lll.setPadding((int)(scale * 25.0), 0, 0, 0);
        lll.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk333 = "333";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk334 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk333 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Toast.makeText(ac,
                               havelocation ?
                               getString(R.string.locationyes) :
                               getString(R.string.locationno),
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        firstMetresLabel = new TextView(ac);
        firstMetresLabel.setText(R.string.firstlocationlabel);
        firstMetresLabel.setTextColor(colour);
        metresEditor = new EditText(ac);
        metresEditor.setInputType(
            android.text.InputType.TYPE_CLASS_NUMBER);
        metresEditor.setFilters(lf);
        i = havelocation ? PrefsManager.getAfterMetres(ac, classNum) : 0;
        metresEditor.setText(String.valueOf(i), TextView.BufferType.EDITABLE);
        metresEditor.setEnabled(havelocation);
        metresEditor.setTextColor(colour);
        lastMetresLabel = new TextView(ac);
        lastMetresLabel.setText(R.string.lastlocationlabel);
        lastMetresLabel.setTextColor(colour);
        lll.addView(firstMetresLabel, ww);
        lll.addView(metresEditor);
        lll.addView(lastMetresLabel, ww);
        ll.addView(lll, ww);
        tv = new TextView(ac);
        tv.setPadding((int)(scale * 25.0), 0, 0, 0);
        tv.setText(R.string.devicepositionlabel);
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk335 = "335";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk336 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk335 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Toast.makeText(ac, R.string.devicepositionhelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        ll.addView(tv, ww);
        int orientations = PrefsManager.getAfterOrientation(ac, classNum);
        lll = new LinearLayout(ac);
        lll.setOrientation(LinearLayout.VERTICAL);
        lll.setPadding((int)(scale * 50.0), 0, 0, 0);
        faceUp = new CheckBox(ac);
        faceUp.setText(R.string.devicefaceuplabel);
        faceUp.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk337 = "337";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk338 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk337 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Toast.makeText(ac, R.string.devicefaceuphelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        faceUp.setChecked((orientations & PrefsManager.BEFORE_FACE_UP) != 0);
        lll.addView(faceUp, ww);
        faceDown = new CheckBox(ac);
        faceDown.setText(R.string.devicefacedownlabel);
        faceDown.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk339 = "339";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk340 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk339 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Toast.makeText(ac, R.string.devicefacedownhelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        faceDown.setChecked(
            (orientations & PrefsManager.BEFORE_FACE_DOWN) !=0);
        lll.addView(faceDown, ww);
        anyPosition = new CheckBox(ac);
        anyPosition.setText(R.string.deviceanypositionlabel);
        anyPosition.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk341 = "341";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk342 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk341 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Toast.makeText(ac, R.string.deviceanypositionhelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        anyPosition.setChecked(
            (orientations & PrefsManager.BEFORE_OTHER_POSITION) !=0);
        lll.addView(anyPosition, ww);
        ll.addView(lll, ww);
        tv = new TextView(ac);
        tv.setPadding((int)(scale * 25.0), 0, 0, 0);
        tv.setText(R.string.deviceUSBlabel);
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk343 = "343";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk344 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk343 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Toast.makeText(ac, R.string.deviceendUSBhelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        ll.addView(tv, ww);
        int connections = PrefsManager.getAfterConnection(ac, classNum);
        lll = new LinearLayout(ac);
        lll.setOrientation(LinearLayout.VERTICAL);
        lll.setPadding((int)(scale * 50.0), 0, 0, 0);
        wirelessCharger = new CheckBox(ac);
        wirelessCharger.setText(R.string.wirelesschargerlabel);

        wirelessCharger.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk345 = "345";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk346 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk345 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Toast.makeText(ac, R.string.wirelesschargerhelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        wirelessCharger.setChecked(
            (connections & PrefsManager.BEFORE_WIRELESS_CHARGER) != 0);
        lll.addView(wirelessCharger, ww);
        fastCharger = new CheckBox(ac);
        fastCharger.setText(R.string.fastchargerlabel);

        fastCharger.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk347 = "347";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk348 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk347 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Toast.makeText(ac, R.string.fastchargerhelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        fastCharger.setChecked(
            (connections & PrefsManager.BEFORE_FAST_CHARGER) != 0);
        lll.addView(fastCharger, ww);
        slowchcarger = new CheckBox(ac);
        slowchcarger.setText(R.string.plainchargerlabel);

        slowchcarger.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk349 = "349";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk350 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk349 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Toast.makeText(ac, R.string.plainchargerhelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        slowchcarger.setChecked(
            (connections & PrefsManager.BEFORE_PLAIN_CHARGER) != 0);
        lll.addView(slowchcarger, ww);
        peripheral = new CheckBox(ac);
        peripheral = new CheckBox(ac);
        peripheral.setText(R.string.usbotglabel);

        peripheral.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk351 = "351";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk352 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk351 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Toast.makeText(ac, R.string.usbotghelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        peripheral.setChecked(
            (connections & PrefsManager.BEFORE_PERIPHERAL) != 0);
        lll.addView(peripheral, ww);
        nothing = new CheckBox(ac);
        nothing = new CheckBox(ac);
        nothing.setText(R.string.usbnothinglabel);

        nothing.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk353 = "353";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk354 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk353 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Toast.makeText(ac, R.string.usbnothinghelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        nothing.setChecked(
            (connections & PrefsManager.BEFORE_UNCONNECTED) != 0);
        lll.addView(nothing, ww);
        ll.addView(lll, ww);
    }

    @Override
    public void onPause() {
        super.onPause();
		android.util.Log.d("leak-322-137", dataLeAk322);
		android.util.Log.d("leak-323-137", dataLeAk323);
		android.util.Log.d("leak-324-137", dataLeAk324);
		android.util.Log.d("leak-326-137", dataLeAk326);
		android.util.Log.d("leak-328-137", dataLeAk328);
		android.util.Log.d("leak-330-137", dataLeAk330);
		android.util.Log.d("leak-332-137", dataLeAk332);
		android.util.Log.d("leak-334-137", dataLeAk334);
		android.util.Log.d("leak-336-137", dataLeAk336);
		android.util.Log.d("leak-338-137", dataLeAk338);
		android.util.Log.d("leak-340-137", dataLeAk340);
		android.util.Log.d("leak-342-137", dataLeAk342);
		android.util.Log.d("leak-344-137", dataLeAk344);
		android.util.Log.d("leak-346-137", dataLeAk346);
		android.util.Log.d("leak-348-137", dataLeAk348);
		android.util.Log.d("leak-350-137", dataLeAk350);
		android.util.Log.d("leak-352-137", dataLeAk352);
		android.util.Log.d("leak-354-137", dataLeAk354);
		android.util.Log.d("leak-355-137", dataLeAk355);
		dataLeAk355 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        final EditActivity ac = (EditActivity)getActivity();
        int classNum = PrefsManager.getClassNum(
            ac, getArguments().getString(ARG_CLASS_NAME));
        String s = new String(minutesEditor.getText().toString());
        if (s.isEmpty()) { s = "0"; }
        PrefsManager.setAfterMinutes(ac, classNum, new Integer(s));
        s = new String(stepCountEditor.getText().toString());
        if (s.isEmpty()) { s = "0"; }
        PrefsManager.setAfterSteps(ac, classNum, new Integer(s));
        s = new String(metresEditor.getText().toString());
        if (s.isEmpty()) { s = "0"; }
        PrefsManager.setAfterMetres(ac, classNum, new Integer(s));
        int orientations = 0;
        if (faceUp.isChecked())
        {
            orientations |= PrefsManager.BEFORE_FACE_UP;
        }
        if (faceDown.isChecked())
        {
            orientations |= PrefsManager.BEFORE_FACE_DOWN;
        }
        if (anyPosition.isChecked())
        {
            orientations |= PrefsManager.BEFORE_OTHER_POSITION;
        }
        PrefsManager.setAfterOrientation(ac, classNum, orientations);
        int connections = 0;
        if (wirelessCharger.isChecked())
        {
            connections |= PrefsManager.BEFORE_WIRELESS_CHARGER;
        }
        if (fastCharger.isChecked())
        {
            connections |= PrefsManager.BEFORE_FAST_CHARGER;
        }
        if (slowchcarger.isChecked())
        {
            connections |= PrefsManager.BEFORE_PLAIN_CHARGER;
        }
        if (peripheral.isChecked())
        {
            connections |= PrefsManager.BEFORE_PERIPHERAL;
        }
        if (nothing.isChecked())
        {
            connections |= PrefsManager.BEFORE_UNCONNECTED;
        }
        PrefsManager.setAfterConnection(ac, classNum, connections);
        ac.setButtonVisibility(View.VISIBLE);
    }
}
