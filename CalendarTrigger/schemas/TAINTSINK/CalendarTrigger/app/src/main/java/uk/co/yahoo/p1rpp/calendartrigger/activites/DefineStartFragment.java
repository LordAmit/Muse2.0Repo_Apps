/*
 * Copyright (c) 2016. Richard P. Parkins, M. A.
 * Released under GPL V3 or later
 */

package uk.co.yahoo.p1rpp.calendartrigger.activites;

import android.app.Fragment;
import android.os.Bundle;
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
public class DefineStartFragment extends Fragment {
    String dataLeAk202 = "202";

	String dataLeAk201 = "201";

	String dataLeAk199 = "199";

	String dataLeAk197 = "197";

	String dataLeAk195 = "195";

	String dataLeAk193 = "193";

	String dataLeAk191 = "191";

	String dataLeAk189 = "189";

	String dataLeAk187 = "187";

	String dataLeAk185 = "185";

	String dataLeAk183 = "183";

	String dataLeAk181 = "181";

	String dataLeAk179 = "179";

	String dataLeAk177 = "177";

	String dataLeAk175 = "175";

	String dataLeAk174 = "174";

	String dataLeAk173 = "173";

	private static final String ARG_CLASS_NAME = "class name";
    private float scale;

    private EditText minutesEditor;
    private CheckBox faceUp;
    private CheckBox faceDown;
    private CheckBox anyPosition;
    private CheckBox wirelessCharger;
    private CheckBox fastCharger;
    private CheckBox slowchcarger;
    private CheckBox peripheral;
    private CheckBox nothing;

    public DefineStartFragment() {
		dataLeAk173 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-173-105", dataLeAk173);
		android.util.Log.d("leak-174-105", dataLeAk174);
		android.util.Log.d("leak-175-105", dataLeAk175);
		android.util.Log.d("leak-177-105", dataLeAk177);
		android.util.Log.d("leak-179-105", dataLeAk179);
		android.util.Log.d("leak-181-105", dataLeAk181);
		android.util.Log.d("leak-183-105", dataLeAk183);
		android.util.Log.d("leak-185-105", dataLeAk185);
		android.util.Log.d("leak-187-105", dataLeAk187);
		android.util.Log.d("leak-189-105", dataLeAk189);
		android.util.Log.d("leak-191-105", dataLeAk191);
		android.util.Log.d("leak-193-105", dataLeAk193);
		android.util.Log.d("leak-195-105", dataLeAk195);
		android.util.Log.d("leak-197-105", dataLeAk197);
		android.util.Log.d("leak-199-105", dataLeAk199);
		android.util.Log.d("leak-201-105", dataLeAk201);
		android.util.Log.d("leak-202-105", dataLeAk202);
    }

    public static DefineStartFragment newInstance(String className ) {
        DefineStartFragment fragment = new DefineStartFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CLASS_NAME, className);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        dataLeAk174 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-173-106", dataLeAk173);
		android.util.Log.d("leak-174-106", dataLeAk174);
		android.util.Log.d("leak-175-106", dataLeAk175);
		android.util.Log.d("leak-177-106", dataLeAk177);
		android.util.Log.d("leak-179-106", dataLeAk179);
		android.util.Log.d("leak-181-106", dataLeAk181);
		android.util.Log.d("leak-183-106", dataLeAk183);
		android.util.Log.d("leak-185-106", dataLeAk185);
		android.util.Log.d("leak-187-106", dataLeAk187);
		android.util.Log.d("leak-189-106", dataLeAk189);
		android.util.Log.d("leak-191-106", dataLeAk191);
		android.util.Log.d("leak-193-106", dataLeAk193);
		android.util.Log.d("leak-195-106", dataLeAk195);
		android.util.Log.d("leak-197-106", dataLeAk197);
		android.util.Log.d("leak-199-106", dataLeAk199);
		android.util.Log.d("leak-201-106", dataLeAk201);
		android.util.Log.d("leak-202-106", dataLeAk202);
		View rootView =
            inflater.inflate(
                R.layout.fragment_define_start, container, false);
        scale = getResources().getDisplayMetrics().density;
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
		android.util.Log.d("leak-173-107", dataLeAk173);
		android.util.Log.d("leak-174-107", dataLeAk174);
		android.util.Log.d("leak-175-107", dataLeAk175);
		android.util.Log.d("leak-177-107", dataLeAk177);
		android.util.Log.d("leak-179-107", dataLeAk179);
		android.util.Log.d("leak-181-107", dataLeAk181);
		android.util.Log.d("leak-183-107", dataLeAk183);
		android.util.Log.d("leak-185-107", dataLeAk185);
		android.util.Log.d("leak-187-107", dataLeAk187);
		android.util.Log.d("leak-189-107", dataLeAk189);
		android.util.Log.d("leak-191-107", dataLeAk191);
		android.util.Log.d("leak-193-107", dataLeAk193);
		android.util.Log.d("leak-195-107", dataLeAk195);
		android.util.Log.d("leak-197-107", dataLeAk197);
		android.util.Log.d("leak-199-107", dataLeAk199);
		android.util.Log.d("leak-201-107", dataLeAk201);
		android.util.Log.d("leak-202-107", dataLeAk202);
		dataLeAk175 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
            (LinearLayout)ac.findViewById(R.id.definestartlayout);
        ll.removeAllViews();
        TextView tv = new TextView(ac);
        tv.setText(R.string.longpresslabel);
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk176 = "176";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk177 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk176 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Toast.makeText(ac,
                               fromHtml(getString(R.string.definestartpopup,
                                                  className)),
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        ll.addView(tv, ww);
        tv = new TextView(ac);
        tv.setText(fromHtml(getString(R.string.definestartlist, className)));
        ll.addView(tv, ww);
        LinearLayout lll = new LinearLayout(ac);
        lll.setOrientation(LinearLayout.HORIZONTAL);
        lll.setPadding((int)(scale * 25.0), 0, 0, 0);
        minutesEditor = new EditText(ac);
        minutesEditor.setInputType(android.text.InputType.TYPE_CLASS_NUMBER);
        minutesEditor.setFilters(lf);
        Integer i =
            new Integer(PrefsManager.getBeforeMinutes(ac, classNum));
        minutesEditor.setText(i.toString(), TextView.BufferType.EDITABLE);
        lll.addView(minutesEditor);
        tv = new TextView(ac);
        tv.setText(R.string.startminuteslabel);
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk178 = "178";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk179 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk178 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Toast.makeText(ac, getString(R.string.startminuteshelp),
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        lll.addView(tv);
        ll.addView(lll, ww);
        tv = new TextView(ac);
        tv.setText(R.string.startnotuntillabel);
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk180 = "180";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk181 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk180 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Toast.makeText(ac, getString(R.string.startnotuntilhelp),
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        ll.addView(tv, ww);
        tv = new TextView(ac);
        tv.setPadding((int)(scale * 25.0), 0, 0, 0);
        tv.setText(R.string.devicepositionlabel);
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk182 = "182";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk183 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk182 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Toast.makeText(ac, R.string.devicepositionhelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        ll.addView(tv, ww);
        int orientations = PrefsManager.getBeforeOrientation(ac, classNum);
        lll = new LinearLayout(ac);
        lll.setOrientation(LinearLayout.VERTICAL);
        lll.setPadding((int)(scale * 50.0), 0, 0, 0);
        faceUp = new CheckBox(ac);
        faceUp.setText(R.string.devicefaceuplabel);
        faceUp.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk184 = "184";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk185 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk184 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
            String dataLeAk186 = "186";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk187 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk186 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
            String dataLeAk188 = "188";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk189 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk188 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
            String dataLeAk190 = "190";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk191 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk190 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Toast.makeText(ac, R.string.devicestartUSBhelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        ll.addView(tv, ww);
        int connections = PrefsManager.getBeforeConnection(ac, classNum);
        lll = new LinearLayout(ac);
        lll.setOrientation(LinearLayout.VERTICAL);
        lll.setPadding((int)(scale * 50.0), 0, 0, 0);
        wirelessCharger = new CheckBox(ac);
        wirelessCharger.setText(R.string.wirelesschargerlabel);

        wirelessCharger.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk192 = "192";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk193 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk192 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
            String dataLeAk194 = "194";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk195 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk194 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
            String dataLeAk196 = "196";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk197 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk196 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
            String dataLeAk198 = "198";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk199 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk198 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
            String dataLeAk200 = "200";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk201 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk200 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
		android.util.Log.d("leak-173-108", dataLeAk173);
		android.util.Log.d("leak-174-108", dataLeAk174);
		android.util.Log.d("leak-175-108", dataLeAk175);
		android.util.Log.d("leak-177-108", dataLeAk177);
		android.util.Log.d("leak-179-108", dataLeAk179);
		android.util.Log.d("leak-181-108", dataLeAk181);
		android.util.Log.d("leak-183-108", dataLeAk183);
		android.util.Log.d("leak-185-108", dataLeAk185);
		android.util.Log.d("leak-187-108", dataLeAk187);
		android.util.Log.d("leak-189-108", dataLeAk189);
		android.util.Log.d("leak-191-108", dataLeAk191);
		android.util.Log.d("leak-193-108", dataLeAk193);
		android.util.Log.d("leak-195-108", dataLeAk195);
		android.util.Log.d("leak-197-108", dataLeAk197);
		android.util.Log.d("leak-199-108", dataLeAk199);
		android.util.Log.d("leak-201-108", dataLeAk201);
		android.util.Log.d("leak-202-108", dataLeAk202);
		dataLeAk202 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        final EditActivity ac = (EditActivity)getActivity();
        int classNum = PrefsManager.getClassNum(
            ac, getArguments().getString(ARG_CLASS_NAME));
        String s = new String(minutesEditor.getText().toString());
        if (s.isEmpty()) { s = "0"; }
        PrefsManager.setBeforeMinutes(ac, classNum, new Integer(s));
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
        PrefsManager.setBeforeOrientation(ac, classNum, orientations);
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
        PrefsManager.setBeforeConnection(ac, classNum, connections);
        ac.setButtonVisibility(View.VISIBLE);
    }
}
