/*
 * Copyright (c) 2016. Richard P. Parkins, M. A.
 * Released under GPL V3 or later
 */

package uk.co.yahoo.p1rpp.calendartrigger.activites;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import uk.co.yahoo.p1rpp.calendartrigger.PrefsManager;
import uk.co.yahoo.p1rpp.calendartrigger.R;

import static android.text.Html.fromHtml;
import static android.text.TextUtils.htmlEncode;

/**
 * Created by rparkins on 05/07/16.
 */
public class ActionStopFragment extends ActionFragment {
    String dataLeAk51 = "51";

	String dataLeAk50 = "50";

	String dataLeAk48 = "48";

	String dataLeAk46 = "46";

	String dataLeAk44 = "44";

	String dataLeAk42 = "42";

	String dataLeAk40 = "40";

	String dataLeAk38 = "38";

	String dataLeAk36 = "36";

	String dataLeAk35 = "35";

	String dataLeAk34 = "34";

	String dataLeAk33 = "33";

	private static final String ARG_CLASS_NAME = "class name";
    private float scale;
    private CheckBox ringerRestore;

    public ActionStopFragment() {
		dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-33-25", dataLeAk33);
		android.util.Log.d("leak-34-25", dataLeAk34);
		android.util.Log.d("leak-35-25", dataLeAk35);
		android.util.Log.d("leak-36-25", dataLeAk36);
		android.util.Log.d("leak-38-25", dataLeAk38);
		android.util.Log.d("leak-40-25", dataLeAk40);
		android.util.Log.d("leak-42-25", dataLeAk42);
		android.util.Log.d("leak-44-25", dataLeAk44);
		android.util.Log.d("leak-46-25", dataLeAk46);
		android.util.Log.d("leak-48-25", dataLeAk48);
		android.util.Log.d("leak-50-25", dataLeAk50);
		android.util.Log.d("leak-51-25", dataLeAk51);
    }

    public static ActionStopFragment newInstance(String className ) {
        ActionStopFragment fragment = new ActionStopFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CLASS_NAME, className);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void openThis(File file) {
        dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-33-26", dataLeAk33);
		android.util.Log.d("leak-34-26", dataLeAk34);
		android.util.Log.d("leak-35-26", dataLeAk35);
		android.util.Log.d("leak-36-26", dataLeAk36);
		android.util.Log.d("leak-38-26", dataLeAk38);
		android.util.Log.d("leak-40-26", dataLeAk40);
		android.util.Log.d("leak-42-26", dataLeAk42);
		android.util.Log.d("leak-44-26", dataLeAk44);
		android.util.Log.d("leak-46-26", dataLeAk46);
		android.util.Log.d("leak-48-26", dataLeAk48);
		android.util.Log.d("leak-50-26", dataLeAk50);
		android.util.Log.d("leak-51-26", dataLeAk51);
		final EditActivity ac = (EditActivity)getActivity();
        PrefsManager.setDefaultDir(ac, file.getParent());
        int classNum = PrefsManager.getClassNum(
            ac, getArguments().getString(ARG_CLASS_NAME));
        PrefsManager.setSoundFileEnd(
            ac, classNum, file.getPath());
        getFragmentManager().popBackStack();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-33-27", dataLeAk33);
		android.util.Log.d("leak-34-27", dataLeAk34);
		android.util.Log.d("leak-35-27", dataLeAk35);
		android.util.Log.d("leak-36-27", dataLeAk36);
		android.util.Log.d("leak-38-27", dataLeAk38);
		android.util.Log.d("leak-40-27", dataLeAk40);
		android.util.Log.d("leak-42-27", dataLeAk42);
		android.util.Log.d("leak-44-27", dataLeAk44);
		android.util.Log.d("leak-46-27", dataLeAk46);
		android.util.Log.d("leak-48-27", dataLeAk48);
		android.util.Log.d("leak-50-27", dataLeAk50);
		android.util.Log.d("leak-51-27", dataLeAk51);
		View rootView =
            inflater.inflate(R.layout.fragment_action_stop, container, false);
        scale = getResources().getDisplayMetrics().density;
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
		android.util.Log.d("leak-33-28", dataLeAk33);
		android.util.Log.d("leak-34-28", dataLeAk34);
		android.util.Log.d("leak-35-28", dataLeAk35);
		android.util.Log.d("leak-36-28", dataLeAk36);
		android.util.Log.d("leak-38-28", dataLeAk38);
		android.util.Log.d("leak-40-28", dataLeAk40);
		android.util.Log.d("leak-42-28", dataLeAk42);
		android.util.Log.d("leak-44-28", dataLeAk44);
		android.util.Log.d("leak-46-28", dataLeAk46);
		android.util.Log.d("leak-48-28", dataLeAk48);
		android.util.Log.d("leak-50-28", dataLeAk50);
		android.util.Log.d("leak-51-28", dataLeAk51);
		dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        final EditActivity ac = (EditActivity)getActivity();
        ac.setButtonVisibility(View.INVISIBLE);
        gettingFile = false;
        int classNum = PrefsManager.getClassNum(
            ac, getArguments().getString(ARG_CLASS_NAME));
        final String className =
            "<i>" + htmlEncode(getArguments().getString(ARG_CLASS_NAME)) +
            "</i>";
        ViewGroup.LayoutParams ww = new ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        );
        LinearLayout ll =
            (LinearLayout)ac.findViewById(R.id.actionstoplayout);
        ll.removeAllViews();
        TextView tv = new TextView(ac);
        tv.setText(R.string.longpresslabel);
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk37 = "37";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Toast.makeText(ac,
                               fromHtml(getString(R.string.actionstoppopup,
                                                  className)),
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        ll.addView(tv, ww);
        tv = new TextView(ac);
        tv.setText(fromHtml(getString(R.string.actionstoplist, className)));
        ll.addView(tv, ww);
        LinearLayout lll = new LinearLayout(ac);
        lll.setOrientation(LinearLayout.VERTICAL);
        lll.setPadding((int)(scale * 25.0), 0, 0, 0);
        ringerRestore = new CheckBox(ac);
        ringerRestore.setText(R.string.restaurer_etat_precedent);
        ringerRestore.setChecked(PrefsManager.getRestoreRinger(ac, classNum));
        ringerRestore.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk39 = "39";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Toast.makeText(ac, R.string.restoreRingerHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        lll.addView(ringerRestore, ww);
        ll.addView(lll, ww);
        showNotification = new CheckBox(ac);
        showNotification.setText(R.string.afficher_notification);
        boolean notif = PrefsManager.getNotifyEnd(ac, classNum);
        showNotification.setChecked(notif);
        showNotification.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk41 = "41";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Toast.makeText(ac, R.string.endNotifyHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        showNotification.setOnCheckedChangeListener(
            new CompoundButton.OnCheckedChangeListener() {
                String dataLeAk43 = "43";

				@Override
                public void onCheckedChanged(
                    CompoundButton v, boolean isChecked) {
                    dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					playSound.setEnabled(isChecked);
                    soundFilename.setEnabled(isChecked);
                }
            });
        ll.addView(showNotification, ww);
        lll = new LinearLayout(ac);
        lll.setPadding((int)(scale * 40.0), 0, 0, 0);
        playSound = new CheckBox(ac);
        playSound.setEnabled(notif);
        playSound.setText(R.string.playsound);
        playSound.setChecked(PrefsManager.getPlaysoundEnd(ac, classNum));
        playSound.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk45 = "45";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Toast.makeText(ac, R.string.endPlaySoundHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        lll.addView(playSound, ww);
        ll.addView(lll);
        lll = new LinearLayout(ac);
        lll.setPadding((int)(scale * 55.0), 0, 0, 0);
        soundFilename = new TextView(ac);
        soundFilename.setEnabled(notif);
        String sf =  PrefsManager.getSoundFileEnd(ac, classNum);
        if (sf.isEmpty()) {
            hasFileName = false;
            String browse = "<i>" +
                            htmlEncode(getString(R.string.browsenofile)) +
                            "</i>";
            soundFilename.setText(fromHtml(browse));
        }
        else {
            hasFileName = true;
            soundFilename.setText(sf);
        }
        soundFilename.setOnClickListener(new View.OnClickListener() {
            String dataLeAk47 = "47";

			public void onClick(View v) {
                dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				getFile();
            }
        });
        soundFilename.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk49 = "49";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				if (hasFileName)
                {
                    Toast.makeText(ac, R.string.browsefileHelp,
                                   Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(ac, R.string.browsenofileHelp,
                                   Toast.LENGTH_LONG).show();
                }
                return true;
            }
        });
        lll.addView(soundFilename, ww);
        ll.addView(lll, ww);
    }

    @Override
    public void onPause() {
        super.onPause();
		android.util.Log.d("leak-33-29", dataLeAk33);
		android.util.Log.d("leak-34-29", dataLeAk34);
		android.util.Log.d("leak-35-29", dataLeAk35);
		android.util.Log.d("leak-36-29", dataLeAk36);
		android.util.Log.d("leak-38-29", dataLeAk38);
		android.util.Log.d("leak-40-29", dataLeAk40);
		android.util.Log.d("leak-42-29", dataLeAk42);
		android.util.Log.d("leak-44-29", dataLeAk44);
		android.util.Log.d("leak-46-29", dataLeAk46);
		android.util.Log.d("leak-48-29", dataLeAk48);
		android.util.Log.d("leak-50-29", dataLeAk50);
		android.util.Log.d("leak-51-29", dataLeAk51);
		dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        final EditActivity ac = (EditActivity)getActivity();
        if (!gettingFile) {
            ac.setButtonVisibility(View.VISIBLE);
        }
        int classNum = PrefsManager.getClassNum(
            ac, getArguments().getString(ARG_CLASS_NAME));
        PrefsManager.setRestoreRinger(ac, classNum, ringerRestore.isChecked());
        PrefsManager.setNotifyEnd(ac, classNum, showNotification.isChecked());
        PrefsManager.setPlaysoundEnd(
            ac, classNum, playSound.isChecked());
        if (hasFileName) {
            PrefsManager.setSoundFileEnd(
                ac, classNum, soundFilename.getText().toString());
        }
        else {
            PrefsManager.setSoundFileEnd( ac, classNum, "");
        }
    }
}
