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
    final String dataLeAk367 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk366 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk365 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk364 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk363 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk362 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk361 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk360 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk359 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk358 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk357 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk356 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk355 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk354 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk353 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk351 = "";

	String dataLeAk335 = "";

	String dataLeAk334 = "";

	String dataLeAk333 = "";

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
		dataLeAk333 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-333-0", dataLeAk333);
		android.util.Log.d("leak-334-0", dataLeAk334);
		android.util.Log.d("leak-335-0", dataLeAk335);
		android.util.Log.d("leak-351-0", dataLeAk351);
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
        dataLeAk334 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-333-1", dataLeAk333);
		android.util.Log.d("leak-334-1", dataLeAk334);
		android.util.Log.d("leak-335-1", dataLeAk335);
		android.util.Log.d("leak-351-1", dataLeAk351);
		View rootView =
            inflater.inflate(R.layout.fragment_define_stop, container, false);
        scale = getResources().getDisplayMetrics().density;
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
		dataLeAk335 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-333-2", dataLeAk333);
		android.util.Log.d("leak-334-2", dataLeAk334);
		android.util.Log.d("leak-335-2", dataLeAk335);
		android.util.Log.d("leak-351-2", dataLeAk351);
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
            String dataLeAk336 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk336 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-353-0", dataLeAk353);
				android.util.Log.d("leak-336-0", dataLeAk336);
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
            String dataLeAk337 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk337 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-354-0", dataLeAk354);
				android.util.Log.d("leak-337-0", dataLeAk337);
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
            String dataLeAk338 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk338 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-355-0", dataLeAk355);
				android.util.Log.d("leak-338-0", dataLeAk338);
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
            String dataLeAk339 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk339 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-356-0", dataLeAk356);
				android.util.Log.d("leak-339-0", dataLeAk339);
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
            String dataLeAk340 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk340 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-357-0", dataLeAk357);
				android.util.Log.d("leak-340-0", dataLeAk340);
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
            String dataLeAk341 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk341 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-358-0", dataLeAk358);
				android.util.Log.d("leak-341-0", dataLeAk341);
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
            String dataLeAk342 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk342 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-359-0", dataLeAk359);
				android.util.Log.d("leak-342-0", dataLeAk342);
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
            String dataLeAk343 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk343 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-360-0", dataLeAk360);
				android.util.Log.d("leak-343-0", dataLeAk343);
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
            String dataLeAk344 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk344 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-361-0", dataLeAk361);
				android.util.Log.d("leak-344-0", dataLeAk344);
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
            String dataLeAk345 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk345 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-362-0", dataLeAk362);
				android.util.Log.d("leak-345-0", dataLeAk345);
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
            String dataLeAk346 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk346 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-363-0", dataLeAk363);
				android.util.Log.d("leak-346-0", dataLeAk346);
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
            String dataLeAk347 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk347 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-364-0", dataLeAk364);
				android.util.Log.d("leak-347-0", dataLeAk347);
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
            String dataLeAk348 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk348 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-365-0", dataLeAk365);
				android.util.Log.d("leak-348-0", dataLeAk348);
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
            String dataLeAk349 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk349 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-366-0", dataLeAk366);
				android.util.Log.d("leak-349-0", dataLeAk349);
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
            String dataLeAk350 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk350 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-367-0", dataLeAk367);
				android.util.Log.d("leak-350-0", dataLeAk350);
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
		dataLeAk351 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-333-3", dataLeAk333);
		android.util.Log.d("leak-334-3", dataLeAk334);
		android.util.Log.d("leak-335-3", dataLeAk335);
		android.util.Log.d("leak-351-3", dataLeAk351);
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
