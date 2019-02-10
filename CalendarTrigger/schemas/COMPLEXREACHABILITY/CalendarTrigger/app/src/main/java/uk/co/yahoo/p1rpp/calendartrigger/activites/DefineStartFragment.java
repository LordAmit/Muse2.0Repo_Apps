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
		String dataLeAk319 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath319;try {throw new Exception(dataLeAk319);} catch (Exception leakErRor319) {dataLeAkPath319 = leakErRor319.getMessage();}
		android.util.Log.d("leak-319", dataLeAkPath319);
    }

    public static DefineStartFragment newInstance(String className ) {
        String dataLeAk320 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay320 = new String[] {"n/a", dataLeAk320};
		String dataLeAkPath320 = leakArRay320[leakArRay320.length - 1];
		android.util.Log.d("leak-320", dataLeAkPath320);
		DefineStartFragment fragment = new DefineStartFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CLASS_NAME, className);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        String dataLeAk321 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP321 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP321.put("test", new java.util.HashMap<String, String>());
			leakMaP321.get("test").put("test", dataLeAk321);
			String dataLeAkPath321 = leakMaP321.get("test").get("test");
			android.util.Log.d("leak-321", dataLeAkPath321);
		View rootView =
            inflater.inflate(
                R.layout.fragment_define_start, container, false);
        scale = getResources().getDisplayMetrics().density;
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
		String dataLeAk322 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer322 = new StringBuffer();for (char chAr322 : dataLeAk322.toCharArray()) {leakBuFFer322.append(chAr322);}String dataLeAkPath322 = leakBuFFer322.toString();
		android.util.Log.d("leak-322", dataLeAkPath322);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk323 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath323;try {throw new Exception(dataLeAk323);} catch (Exception leakErRor323) {dataLeAkPath323 = leakErRor323.getMessage();}
				android.util.Log.d("leak-323", dataLeAkPath323);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk324 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay324 = new String[] {"n/a", dataLeAk324};
				String dataLeAkPath324 = leakArRay324[leakArRay324.length - 1];
				android.util.Log.d("leak-324", dataLeAkPath324);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk325 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP325 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP325.put("test", new java.util.HashMap<String, String>());
				leakMaP325.get("test").put("test", dataLeAk325);
				String dataLeAkPath325 = leakMaP325.get("test").get("test");
				android.util.Log.d("leak-325", dataLeAkPath325);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk326 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer326 = new StringBuffer();for (char chAr326 : dataLeAk326.toCharArray()) {leakBuFFer326.append(chAr326);}String dataLeAkPath326 = leakBuFFer326.toString();
				android.util.Log.d("leak-326", dataLeAkPath326);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk327 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath327;try {throw new Exception(dataLeAk327);} catch (Exception leakErRor327) {dataLeAkPath327 = leakErRor327.getMessage();}
				android.util.Log.d("leak-327", dataLeAkPath327);
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
                String dataLeAk328 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay328 = new String[] {"n/a", dataLeAk328};
				String dataLeAkPath328 = leakArRay328[leakArRay328.length - 1];
				android.util.Log.d("leak-328", dataLeAkPath328);
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
                String dataLeAk329 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP329 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP329.put("test", new java.util.HashMap<String, String>());
				leakMaP329.get("test").put("test", dataLeAk329);
				String dataLeAkPath329 = leakMaP329.get("test").get("test");
				android.util.Log.d("leak-329", dataLeAkPath329);
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
                String dataLeAk330 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer330 = new StringBuffer();for (char chAr330 : dataLeAk330.toCharArray()) {leakBuFFer330.append(chAr330);}String dataLeAkPath330 = leakBuFFer330.toString();
				android.util.Log.d("leak-330", dataLeAkPath330);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk331 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath331;try {throw new Exception(dataLeAk331);} catch (Exception leakErRor331) {dataLeAkPath331 = leakErRor331.getMessage();}
				android.util.Log.d("leak-331", dataLeAkPath331);
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
                String dataLeAk332 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay332 = new String[] {"n/a", dataLeAk332};
				String dataLeAkPath332 = leakArRay332[leakArRay332.length - 1];
				android.util.Log.d("leak-332", dataLeAkPath332);
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
                String dataLeAk333 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP333 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP333.put("test", new java.util.HashMap<String, String>());
				leakMaP333.get("test").put("test", dataLeAk333);
				String dataLeAkPath333 = leakMaP333.get("test").get("test");
				android.util.Log.d("leak-333", dataLeAkPath333);
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
                String dataLeAk334 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer334 = new StringBuffer();for (char chAr334 : dataLeAk334.toCharArray()) {leakBuFFer334.append(chAr334);}String dataLeAkPath334 = leakBuFFer334.toString();
				android.util.Log.d("leak-334", dataLeAkPath334);
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
                String dataLeAk335 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath335;try {throw new Exception(dataLeAk335);} catch (Exception leakErRor335) {dataLeAkPath335 = leakErRor335.getMessage();}
				android.util.Log.d("leak-335", dataLeAkPath335);
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
		String dataLeAk336 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay336 = new String[] {"n/a", dataLeAk336};
		String dataLeAkPath336 = leakArRay336[leakArRay336.length - 1];
		android.util.Log.d("leak-336", dataLeAkPath336);
        final EditActivity ac = (EditActivity)getActivity();
        int classNum = PrefsManager.getClassNum(
            ac, getArguments().getString(ARG_CLASS_NAME));
        String s = new String(minutesEditor.getText().toString());
        if (s.isEmpty()) { String dataLeAk337 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP337 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP337.put("test", new java.util.HashMap<String, String>());
			leakMaP337.get("test").put("test", dataLeAk337);
			String dataLeAkPath337 = leakMaP337.get("test").get("test");
			android.util.Log.d("leak-337", dataLeAkPath337);
		s = "0"; }
        PrefsManager.setBeforeMinutes(ac, classNum, new Integer(s));
        int orientations = 0;
        if (faceUp.isChecked())
        {
            String dataLeAk338 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer338 = new StringBuffer();for (char chAr338 : dataLeAk338.toCharArray()) {leakBuFFer338.append(chAr338);}String dataLeAkPath338 = leakBuFFer338.toString();
			android.util.Log.d("leak-338", dataLeAkPath338);
			orientations |= PrefsManager.BEFORE_FACE_UP;
        }
        if (faceDown.isChecked())
        {
            String dataLeAk339 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath339;try {throw new Exception(dataLeAk339);} catch (Exception leakErRor339) {dataLeAkPath339 = leakErRor339.getMessage();}
			android.util.Log.d("leak-339", dataLeAkPath339);
			orientations |= PrefsManager.BEFORE_FACE_DOWN;
        }
        if (anyPosition.isChecked())
        {
            String dataLeAk340 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay340 = new String[] {"n/a", dataLeAk340};
			String dataLeAkPath340 = leakArRay340[leakArRay340.length - 1];
			android.util.Log.d("leak-340", dataLeAkPath340);
			orientations |= PrefsManager.BEFORE_OTHER_POSITION;
        }
        PrefsManager.setBeforeOrientation(ac, classNum, orientations);
        int connections = 0;
        if (wirelessCharger.isChecked())
        {
            String dataLeAk341 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP341 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP341.put("test", new java.util.HashMap<String, String>());
			leakMaP341.get("test").put("test", dataLeAk341);
			String dataLeAkPath341 = leakMaP341.get("test").get("test");
			android.util.Log.d("leak-341", dataLeAkPath341);
			connections |= PrefsManager.BEFORE_WIRELESS_CHARGER;
        }
        if (fastCharger.isChecked())
        {
            String dataLeAk342 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer342 = new StringBuffer();for (char chAr342 : dataLeAk342.toCharArray()) {leakBuFFer342.append(chAr342);}String dataLeAkPath342 = leakBuFFer342.toString();
			android.util.Log.d("leak-342", dataLeAkPath342);
			connections |= PrefsManager.BEFORE_FAST_CHARGER;
        }
        if (slowchcarger.isChecked())
        {
            String dataLeAk343 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath343;try {throw new Exception(dataLeAk343);} catch (Exception leakErRor343) {dataLeAkPath343 = leakErRor343.getMessage();}
			android.util.Log.d("leak-343", dataLeAkPath343);
			connections |= PrefsManager.BEFORE_PLAIN_CHARGER;
        }
        if (peripheral.isChecked())
        {
            String dataLeAk344 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay344 = new String[] {"n/a", dataLeAk344};
			String dataLeAkPath344 = leakArRay344[leakArRay344.length - 1];
			android.util.Log.d("leak-344", dataLeAkPath344);
			connections |= PrefsManager.BEFORE_PERIPHERAL;
        }
        if (nothing.isChecked())
        {
            String dataLeAk345 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP345 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP345.put("test", new java.util.HashMap<String, String>());
			leakMaP345.get("test").put("test", dataLeAk345);
			String dataLeAkPath345 = leakMaP345.get("test").get("test");
			android.util.Log.d("leak-345", dataLeAkPath345);
			connections |= PrefsManager.BEFORE_UNCONNECTED;
        }
        PrefsManager.setBeforeConnection(ac, classNum, connections);
        ac.setButtonVisibility(View.VISIBLE);
    }
}
