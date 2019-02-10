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
    String dataLeAk643 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk643 = android.util.Log.d("leak-643", dataLeAk643);

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
		String dataLeAk644 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk644 = android.util.Log.d("leak-644", dataLeAk644);
    }

    public static DefineStopFragment newInstance(String className ) {
        String dataLeAk645 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk645 = android.util.Log.d("leak-645", dataLeAk645);
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
        String dataLeAk646 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk646 = android.util.Log.d("leak-646", dataLeAk646);
		View rootView =
            inflater.inflate(R.layout.fragment_define_stop, container, false);
        scale = getResources().getDisplayMetrics().density;
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
		String dataLeAk647 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk647 = android.util.Log.d("leak-647", dataLeAk647);
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
            String dataLeAk648 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk648 = android.util.Log.d("leak-648", dataLeAk648);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk649 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk649 = android.util.Log.d("leak-649", dataLeAk649);
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
            String dataLeAk650 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk650 = android.util.Log.d("leak-650", dataLeAk650);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk651 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk651 = android.util.Log.d("leak-651", dataLeAk651);
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
            String dataLeAk652 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk652 = android.util.Log.d("leak-652", dataLeAk652);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk653 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk653 = android.util.Log.d("leak-653", dataLeAk653);
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
            String dataLeAk654 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk654 = android.util.Log.d("leak-654", dataLeAk654);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk655 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk655 = android.util.Log.d("leak-655", dataLeAk655);
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
            String dataLeAk656 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk656 = android.util.Log.d("leak-656", dataLeAk656);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk657 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk657 = android.util.Log.d("leak-657", dataLeAk657);
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
            String dataLeAk658 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk658 = android.util.Log.d("leak-658", dataLeAk658);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk659 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk659 = android.util.Log.d("leak-659", dataLeAk659);
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
            String dataLeAk660 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk660 = android.util.Log.d("leak-660", dataLeAk660);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk661 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk661 = android.util.Log.d("leak-661", dataLeAk661);
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
            String dataLeAk662 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk662 = android.util.Log.d("leak-662", dataLeAk662);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk663 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk663 = android.util.Log.d("leak-663", dataLeAk663);
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
            String dataLeAk664 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk664 = android.util.Log.d("leak-664", dataLeAk664);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk665 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk665 = android.util.Log.d("leak-665", dataLeAk665);
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
            String dataLeAk666 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk666 = android.util.Log.d("leak-666", dataLeAk666);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk667 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk667 = android.util.Log.d("leak-667", dataLeAk667);
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
            String dataLeAk668 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk668 = android.util.Log.d("leak-668", dataLeAk668);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk669 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk669 = android.util.Log.d("leak-669", dataLeAk669);
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
            String dataLeAk670 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk670 = android.util.Log.d("leak-670", dataLeAk670);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk671 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk671 = android.util.Log.d("leak-671", dataLeAk671);
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
            String dataLeAk672 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk672 = android.util.Log.d("leak-672", dataLeAk672);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk673 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk673 = android.util.Log.d("leak-673", dataLeAk673);
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
            String dataLeAk674 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk674 = android.util.Log.d("leak-674", dataLeAk674);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk675 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk675 = android.util.Log.d("leak-675", dataLeAk675);
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
            String dataLeAk676 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk676 = android.util.Log.d("leak-676", dataLeAk676);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk677 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk677 = android.util.Log.d("leak-677", dataLeAk677);
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
		String dataLeAk678 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk678 = android.util.Log.d("leak-678", dataLeAk678);
        final EditActivity ac = (EditActivity)getActivity();
        int classNum = PrefsManager.getClassNum(
            ac, getArguments().getString(ARG_CLASS_NAME));
        String s = new String(minutesEditor.getText().toString());
        if (s.isEmpty()) { String dataLeAk679 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk679 = android.util.Log.d("leak-679", dataLeAk679);
		s = "0"; }
        PrefsManager.setAfterMinutes(ac, classNum, new Integer(s));
        s = new String(stepCountEditor.getText().toString());
        if (s.isEmpty()) { String dataLeAk680 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk680 = android.util.Log.d("leak-680", dataLeAk680);
		s = "0"; }
        PrefsManager.setAfterSteps(ac, classNum, new Integer(s));
        s = new String(metresEditor.getText().toString());
        if (s.isEmpty()) { String dataLeAk681 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk681 = android.util.Log.d("leak-681", dataLeAk681);
		s = "0"; }
        PrefsManager.setAfterMetres(ac, classNum, new Integer(s));
        int orientations = 0;
        if (faceUp.isChecked())
        {
            String dataLeAk682 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk682 = android.util.Log.d("leak-682", dataLeAk682);
			orientations |= PrefsManager.BEFORE_FACE_UP;
        }
        if (faceDown.isChecked())
        {
            String dataLeAk683 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk683 = android.util.Log.d("leak-683", dataLeAk683);
			orientations |= PrefsManager.BEFORE_FACE_DOWN;
        }
        if (anyPosition.isChecked())
        {
            String dataLeAk684 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk684 = android.util.Log.d("leak-684", dataLeAk684);
			orientations |= PrefsManager.BEFORE_OTHER_POSITION;
        }
        PrefsManager.setAfterOrientation(ac, classNum, orientations);
        int connections = 0;
        if (wirelessCharger.isChecked())
        {
            String dataLeAk685 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk685 = android.util.Log.d("leak-685", dataLeAk685);
			connections |= PrefsManager.BEFORE_WIRELESS_CHARGER;
        }
        if (fastCharger.isChecked())
        {
            String dataLeAk686 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk686 = android.util.Log.d("leak-686", dataLeAk686);
			connections |= PrefsManager.BEFORE_FAST_CHARGER;
        }
        if (slowchcarger.isChecked())
        {
            String dataLeAk687 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk687 = android.util.Log.d("leak-687", dataLeAk687);
			connections |= PrefsManager.BEFORE_PLAIN_CHARGER;
        }
        if (peripheral.isChecked())
        {
            String dataLeAk688 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk688 = android.util.Log.d("leak-688", dataLeAk688);
			connections |= PrefsManager.BEFORE_PERIPHERAL;
        }
        if (nothing.isChecked())
        {
            String dataLeAk689 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk689 = android.util.Log.d("leak-689", dataLeAk689);
			connections |= PrefsManager.BEFORE_UNCONNECTED;
        }
        PrefsManager.setAfterConnection(ac, classNum, connections);
        ac.setButtonVisibility(View.VISIBLE);
    }
}
