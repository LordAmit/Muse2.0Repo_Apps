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
		String dataLeAk524 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay524 = new String[] {"n/a", dataLeAk524};
		String dataLeAkPath524 = leakArRay524[leakArRay524.length - 1];
		android.util.Log.d("leak-524", dataLeAkPath524);
    }

    public static DefineStopFragment newInstance(String className ) {
        String dataLeAk525 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP525 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP525.put("test", new java.util.HashMap<String, String>());
		leakMaP525.get("test").put("test", dataLeAk525);
		String dataLeAkPath525 = leakMaP525.get("test").get("test");
		android.util.Log.d("leak-525", dataLeAkPath525);
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
        String dataLeAk526 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer526 = new StringBuffer();for (char chAr526 : dataLeAk526.toCharArray()) {leakBuFFer526.append(chAr526);}String dataLeAkPath526 = leakBuFFer526.toString();
			android.util.Log.d("leak-526", dataLeAkPath526);
		View rootView =
            inflater.inflate(R.layout.fragment_define_stop, container, false);
        scale = getResources().getDisplayMetrics().density;
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
		String dataLeAk527 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath527;try {throw new Exception(dataLeAk527);} catch (Exception leakErRor527) {dataLeAkPath527 = leakErRor527.getMessage();}
		android.util.Log.d("leak-527", dataLeAkPath527);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk528 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay528 = new String[] {"n/a", dataLeAk528};
				String dataLeAkPath528 = leakArRay528[leakArRay528.length - 1];
				android.util.Log.d("leak-528", dataLeAkPath528);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk529 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP529 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP529.put("test", new java.util.HashMap<String, String>());
				leakMaP529.get("test").put("test", dataLeAk529);
				String dataLeAkPath529 = leakMaP529.get("test").get("test");
				android.util.Log.d("leak-529", dataLeAkPath529);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk530 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer530 = new StringBuffer();for (char chAr530 : dataLeAk530.toCharArray()) {leakBuFFer530.append(chAr530);}String dataLeAkPath530 = leakBuFFer530.toString();
				android.util.Log.d("leak-530", dataLeAkPath530);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk531 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath531;try {throw new Exception(dataLeAk531);} catch (Exception leakErRor531) {dataLeAkPath531 = leakErRor531.getMessage();}
				android.util.Log.d("leak-531", dataLeAkPath531);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk532 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay532 = new String[] {"n/a", dataLeAk532};
				String dataLeAkPath532 = leakArRay532[leakArRay532.length - 1];
				android.util.Log.d("leak-532", dataLeAkPath532);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk533 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP533 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP533.put("test", new java.util.HashMap<String, String>());
				leakMaP533.get("test").put("test", dataLeAk533);
				String dataLeAkPath533 = leakMaP533.get("test").get("test");
				android.util.Log.d("leak-533", dataLeAkPath533);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk534 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer534 = new StringBuffer();for (char chAr534 : dataLeAk534.toCharArray()) {leakBuFFer534.append(chAr534);}String dataLeAkPath534 = leakBuFFer534.toString();
				android.util.Log.d("leak-534", dataLeAkPath534);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk535 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath535;try {throw new Exception(dataLeAk535);} catch (Exception leakErRor535) {dataLeAkPath535 = leakErRor535.getMessage();}
				android.util.Log.d("leak-535", dataLeAkPath535);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk536 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay536 = new String[] {"n/a", dataLeAk536};
				String dataLeAkPath536 = leakArRay536[leakArRay536.length - 1];
				android.util.Log.d("leak-536", dataLeAkPath536);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk537 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP537 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP537.put("test", new java.util.HashMap<String, String>());
				leakMaP537.get("test").put("test", dataLeAk537);
				String dataLeAkPath537 = leakMaP537.get("test").get("test");
				android.util.Log.d("leak-537", dataLeAkPath537);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk538 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer538 = new StringBuffer();for (char chAr538 : dataLeAk538.toCharArray()) {leakBuFFer538.append(chAr538);}String dataLeAkPath538 = leakBuFFer538.toString();
				android.util.Log.d("leak-538", dataLeAkPath538);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk539 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath539;try {throw new Exception(dataLeAk539);} catch (Exception leakErRor539) {dataLeAkPath539 = leakErRor539.getMessage();}
				android.util.Log.d("leak-539", dataLeAkPath539);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk540 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay540 = new String[] {"n/a", dataLeAk540};
				String dataLeAkPath540 = leakArRay540[leakArRay540.length - 1];
				android.util.Log.d("leak-540", dataLeAkPath540);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk541 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP541 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP541.put("test", new java.util.HashMap<String, String>());
				leakMaP541.get("test").put("test", dataLeAk541);
				String dataLeAkPath541 = leakMaP541.get("test").get("test");
				android.util.Log.d("leak-541", dataLeAkPath541);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk542 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer542 = new StringBuffer();for (char chAr542 : dataLeAk542.toCharArray()) {leakBuFFer542.append(chAr542);}String dataLeAkPath542 = leakBuFFer542.toString();
				android.util.Log.d("leak-542", dataLeAkPath542);
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
		String dataLeAk543 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath543;try {throw new Exception(dataLeAk543);} catch (Exception leakErRor543) {dataLeAkPath543 = leakErRor543.getMessage();}
		android.util.Log.d("leak-543", dataLeAkPath543);
        final EditActivity ac = (EditActivity)getActivity();
        int classNum = PrefsManager.getClassNum(
            ac, getArguments().getString(ARG_CLASS_NAME));
        String s = new String(minutesEditor.getText().toString());
        if (s.isEmpty()) { String dataLeAk544 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay544 = new String[] {"n/a", dataLeAk544};
			String dataLeAkPath544 = leakArRay544[leakArRay544.length - 1];
			android.util.Log.d("leak-544", dataLeAkPath544);
		s = "0"; }
        PrefsManager.setAfterMinutes(ac, classNum, new Integer(s));
        s = new String(stepCountEditor.getText().toString());
        if (s.isEmpty()) { String dataLeAk545 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP545 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP545.put("test", new java.util.HashMap<String, String>());
			leakMaP545.get("test").put("test", dataLeAk545);
			String dataLeAkPath545 = leakMaP545.get("test").get("test");
			android.util.Log.d("leak-545", dataLeAkPath545);
		s = "0"; }
        PrefsManager.setAfterSteps(ac, classNum, new Integer(s));
        s = new String(metresEditor.getText().toString());
        if (s.isEmpty()) { String dataLeAk546 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer546 = new StringBuffer();for (char chAr546 : dataLeAk546.toCharArray()) {leakBuFFer546.append(chAr546);}String dataLeAkPath546 = leakBuFFer546.toString();
			android.util.Log.d("leak-546", dataLeAkPath546);
		s = "0"; }
        PrefsManager.setAfterMetres(ac, classNum, new Integer(s));
        int orientations = 0;
        if (faceUp.isChecked())
        {
            String dataLeAk547 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath547;try {throw new Exception(dataLeAk547);} catch (Exception leakErRor547) {dataLeAkPath547 = leakErRor547.getMessage();}
			android.util.Log.d("leak-547", dataLeAkPath547);
			orientations |= PrefsManager.BEFORE_FACE_UP;
        }
        if (faceDown.isChecked())
        {
            String dataLeAk548 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay548 = new String[] {"n/a", dataLeAk548};
			String dataLeAkPath548 = leakArRay548[leakArRay548.length - 1];
			android.util.Log.d("leak-548", dataLeAkPath548);
			orientations |= PrefsManager.BEFORE_FACE_DOWN;
        }
        if (anyPosition.isChecked())
        {
            String dataLeAk549 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP549 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP549.put("test", new java.util.HashMap<String, String>());
			leakMaP549.get("test").put("test", dataLeAk549);
			String dataLeAkPath549 = leakMaP549.get("test").get("test");
			android.util.Log.d("leak-549", dataLeAkPath549);
			orientations |= PrefsManager.BEFORE_OTHER_POSITION;
        }
        PrefsManager.setAfterOrientation(ac, classNum, orientations);
        int connections = 0;
        if (wirelessCharger.isChecked())
        {
            String dataLeAk550 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer550 = new StringBuffer();for (char chAr550 : dataLeAk550.toCharArray()) {leakBuFFer550.append(chAr550);}String dataLeAkPath550 = leakBuFFer550.toString();
			android.util.Log.d("leak-550", dataLeAkPath550);
			connections |= PrefsManager.BEFORE_WIRELESS_CHARGER;
        }
        if (fastCharger.isChecked())
        {
            String dataLeAk551 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath551;try {throw new Exception(dataLeAk551);} catch (Exception leakErRor551) {dataLeAkPath551 = leakErRor551.getMessage();}
			android.util.Log.d("leak-551", dataLeAkPath551);
			connections |= PrefsManager.BEFORE_FAST_CHARGER;
        }
        if (slowchcarger.isChecked())
        {
            String dataLeAk552 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay552 = new String[] {"n/a", dataLeAk552};
			String dataLeAkPath552 = leakArRay552[leakArRay552.length - 1];
			android.util.Log.d("leak-552", dataLeAkPath552);
			connections |= PrefsManager.BEFORE_PLAIN_CHARGER;
        }
        if (peripheral.isChecked())
        {
            String dataLeAk553 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP553 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP553.put("test", new java.util.HashMap<String, String>());
			leakMaP553.get("test").put("test", dataLeAk553);
			String dataLeAkPath553 = leakMaP553.get("test").get("test");
			android.util.Log.d("leak-553", dataLeAkPath553);
			connections |= PrefsManager.BEFORE_PERIPHERAL;
        }
        if (nothing.isChecked())
        {
            String dataLeAk554 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer554 = new StringBuffer();for (char chAr554 : dataLeAk554.toCharArray()) {leakBuFFer554.append(chAr554);}String dataLeAkPath554 = leakBuFFer554.toString();
			android.util.Log.d("leak-554", dataLeAkPath554);
			connections |= PrefsManager.BEFORE_UNCONNECTED;
        }
        PrefsManager.setAfterConnection(ac, classNum, connections);
        ac.setButtonVisibility(View.VISIBLE);
    }
}
