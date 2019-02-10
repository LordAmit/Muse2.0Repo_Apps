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
    final String dataLeAk210 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk209 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk208 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk207 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk206 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk205 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk204 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk203 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk202 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk201 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk200 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk199 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk198 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk196 = "";

	String dataLeAk182 = "";

	String dataLeAk181 = "";

	String dataLeAk180 = "";

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
		dataLeAk180 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-180-0", dataLeAk180);
		android.util.Log.d("leak-181-0", dataLeAk181);
		android.util.Log.d("leak-182-0", dataLeAk182);
		android.util.Log.d("leak-196-0", dataLeAk196);
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
        dataLeAk181 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-180-1", dataLeAk180);
		android.util.Log.d("leak-181-1", dataLeAk181);
		android.util.Log.d("leak-182-1", dataLeAk182);
		android.util.Log.d("leak-196-1", dataLeAk196);
		View rootView =
            inflater.inflate(
                R.layout.fragment_define_start, container, false);
        scale = getResources().getDisplayMetrics().density;
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
		dataLeAk182 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-180-2", dataLeAk180);
		android.util.Log.d("leak-181-2", dataLeAk181);
		android.util.Log.d("leak-182-2", dataLeAk182);
		android.util.Log.d("leak-196-2", dataLeAk196);
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
            String dataLeAk183 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk183 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-198-0", dataLeAk198);
				android.util.Log.d("leak-183-0", dataLeAk183);
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
            String dataLeAk184 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk184 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-199-0", dataLeAk199);
				android.util.Log.d("leak-184-0", dataLeAk184);
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
            String dataLeAk185 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk185 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-200-0", dataLeAk200);
				android.util.Log.d("leak-185-0", dataLeAk185);
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
            String dataLeAk186 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk186 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-201-0", dataLeAk201);
				android.util.Log.d("leak-186-0", dataLeAk186);
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
            String dataLeAk187 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk187 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-202-0", dataLeAk202);
				android.util.Log.d("leak-187-0", dataLeAk187);
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
            String dataLeAk188 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk188 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-203-0", dataLeAk203);
				android.util.Log.d("leak-188-0", dataLeAk188);
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
            String dataLeAk189 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk189 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-204-0", dataLeAk204);
				android.util.Log.d("leak-189-0", dataLeAk189);
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
            String dataLeAk190 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk190 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-205-0", dataLeAk205);
				android.util.Log.d("leak-190-0", dataLeAk190);
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
            String dataLeAk191 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk191 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-206-0", dataLeAk206);
				android.util.Log.d("leak-191-0", dataLeAk191);
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
            String dataLeAk192 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk192 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-207-0", dataLeAk207);
				android.util.Log.d("leak-192-0", dataLeAk192);
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
            String dataLeAk193 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk193 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-208-0", dataLeAk208);
				android.util.Log.d("leak-193-0", dataLeAk193);
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
            String dataLeAk194 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk194 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-209-0", dataLeAk209);
				android.util.Log.d("leak-194-0", dataLeAk194);
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
            String dataLeAk195 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk195 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-210-0", dataLeAk210);
				android.util.Log.d("leak-195-0", dataLeAk195);
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
		dataLeAk196 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-180-3", dataLeAk180);
		android.util.Log.d("leak-181-3", dataLeAk181);
		android.util.Log.d("leak-182-3", dataLeAk182);
		android.util.Log.d("leak-196-3", dataLeAk196);
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
