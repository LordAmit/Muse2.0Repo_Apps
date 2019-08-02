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
    String dataLeAk371 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk371 = android.util.Log.d("leak-371", dataLeAk371);

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
		String dataLeAk372 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk372 = android.util.Log.d("leak-372", dataLeAk372);
    }

    public static DefineStartFragment newInstance(String className ) {
        String dataLeAk373 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk373 = android.util.Log.d("leak-373", dataLeAk373);
		DefineStartFragment fragment = new DefineStartFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CLASS_NAME, className);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        String dataLeAk374 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk374 = android.util.Log.d("leak-374", dataLeAk374);
		View rootView =
            inflater.inflate(
                R.layout.fragment_define_start, container, false);
        scale = getResources().getDisplayMetrics().density;
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
		String dataLeAk375 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk375 = android.util.Log.d("leak-375", dataLeAk375);
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
            String dataLeAk376 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk376 = android.util.Log.d("leak-376", dataLeAk376);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk377 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk377 = android.util.Log.d("leak-377", dataLeAk377);
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
            String dataLeAk378 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk378 = android.util.Log.d("leak-378", dataLeAk378);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk379 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk379 = android.util.Log.d("leak-379", dataLeAk379);
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
            String dataLeAk380 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk380 = android.util.Log.d("leak-380", dataLeAk380);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk381 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk381 = android.util.Log.d("leak-381", dataLeAk381);
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
            String dataLeAk382 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk382 = android.util.Log.d("leak-382", dataLeAk382);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk383 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk383 = android.util.Log.d("leak-383", dataLeAk383);
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
            String dataLeAk384 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk384 = android.util.Log.d("leak-384", dataLeAk384);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk385 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk385 = android.util.Log.d("leak-385", dataLeAk385);
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
            String dataLeAk386 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk386 = android.util.Log.d("leak-386", dataLeAk386);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk387 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk387 = android.util.Log.d("leak-387", dataLeAk387);
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
            String dataLeAk388 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk388 = android.util.Log.d("leak-388", dataLeAk388);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk389 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk389 = android.util.Log.d("leak-389", dataLeAk389);
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
            String dataLeAk390 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk390 = android.util.Log.d("leak-390", dataLeAk390);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk391 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk391 = android.util.Log.d("leak-391", dataLeAk391);
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
            String dataLeAk392 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk392 = android.util.Log.d("leak-392", dataLeAk392);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk393 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk393 = android.util.Log.d("leak-393", dataLeAk393);
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
            String dataLeAk394 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk394 = android.util.Log.d("leak-394", dataLeAk394);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk395 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk395 = android.util.Log.d("leak-395", dataLeAk395);
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
            String dataLeAk396 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk396 = android.util.Log.d("leak-396", dataLeAk396);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk397 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk397 = android.util.Log.d("leak-397", dataLeAk397);
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
            String dataLeAk398 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk398 = android.util.Log.d("leak-398", dataLeAk398);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk399 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk399 = android.util.Log.d("leak-399", dataLeAk399);
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
            String dataLeAk400 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk400 = android.util.Log.d("leak-400", dataLeAk400);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk401 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk401 = android.util.Log.d("leak-401", dataLeAk401);
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
		String dataLeAk402 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk402 = android.util.Log.d("leak-402", dataLeAk402);
        final EditActivity ac = (EditActivity)getActivity();
        int classNum = PrefsManager.getClassNum(
            ac, getArguments().getString(ARG_CLASS_NAME));
        String s = new String(minutesEditor.getText().toString());
        if (s.isEmpty()) { String dataLeAk403 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk403 = android.util.Log.d("leak-403", dataLeAk403);
		s = "0"; }
        PrefsManager.setBeforeMinutes(ac, classNum, new Integer(s));
        int orientations = 0;
        if (faceUp.isChecked())
        {
            String dataLeAk404 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk404 = android.util.Log.d("leak-404", dataLeAk404);
			orientations |= PrefsManager.BEFORE_FACE_UP;
        }
        if (faceDown.isChecked())
        {
            String dataLeAk405 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk405 = android.util.Log.d("leak-405", dataLeAk405);
			orientations |= PrefsManager.BEFORE_FACE_DOWN;
        }
        if (anyPosition.isChecked())
        {
            String dataLeAk406 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk406 = android.util.Log.d("leak-406", dataLeAk406);
			orientations |= PrefsManager.BEFORE_OTHER_POSITION;
        }
        PrefsManager.setBeforeOrientation(ac, classNum, orientations);
        int connections = 0;
        if (wirelessCharger.isChecked())
        {
            String dataLeAk407 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk407 = android.util.Log.d("leak-407", dataLeAk407);
			connections |= PrefsManager.BEFORE_WIRELESS_CHARGER;
        }
        if (fastCharger.isChecked())
        {
            String dataLeAk408 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk408 = android.util.Log.d("leak-408", dataLeAk408);
			connections |= PrefsManager.BEFORE_FAST_CHARGER;
        }
        if (slowchcarger.isChecked())
        {
            String dataLeAk409 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk409 = android.util.Log.d("leak-409", dataLeAk409);
			connections |= PrefsManager.BEFORE_PLAIN_CHARGER;
        }
        if (peripheral.isChecked())
        {
            String dataLeAk410 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk410 = android.util.Log.d("leak-410", dataLeAk410);
			connections |= PrefsManager.BEFORE_PERIPHERAL;
        }
        if (nothing.isChecked())
        {
            String dataLeAk411 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk411 = android.util.Log.d("leak-411", dataLeAk411);
			connections |= PrefsManager.BEFORE_UNCONNECTED;
        }
        PrefsManager.setBeforeConnection(ac, classNum, connections);
        ac.setButtonVisibility(View.VISIBLE);
    }
}
