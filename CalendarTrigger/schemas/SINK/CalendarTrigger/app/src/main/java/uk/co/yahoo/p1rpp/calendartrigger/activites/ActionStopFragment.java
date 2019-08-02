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
    final String dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk46 = "";

	String dataLeAk38 = "";

	String dataLeAk37 = "";

	String dataLeAk36 = "";

	String dataLeAk35 = "";

	private static final String ARG_CLASS_NAME = "class name";
    private float scale;
    private CheckBox ringerRestore;

    public ActionStopFragment() {
		dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-35-0", dataLeAk35);
		android.util.Log.d("leak-36-0", dataLeAk36);
		android.util.Log.d("leak-37-0", dataLeAk37);
		android.util.Log.d("leak-38-0", dataLeAk38);
		android.util.Log.d("leak-46-0", dataLeAk46);
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
        dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-35-1", dataLeAk35);
		android.util.Log.d("leak-36-1", dataLeAk36);
		android.util.Log.d("leak-37-1", dataLeAk37);
		android.util.Log.d("leak-38-1", dataLeAk38);
		android.util.Log.d("leak-46-1", dataLeAk46);
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
        dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-35-2", dataLeAk35);
		android.util.Log.d("leak-36-2", dataLeAk36);
		android.util.Log.d("leak-37-2", dataLeAk37);
		android.util.Log.d("leak-38-2", dataLeAk38);
		android.util.Log.d("leak-46-2", dataLeAk46);
		View rootView =
            inflater.inflate(R.layout.fragment_action_stop, container, false);
        scale = getResources().getDisplayMetrics().density;
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
		dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-35-3", dataLeAk35);
		android.util.Log.d("leak-36-3", dataLeAk36);
		android.util.Log.d("leak-37-3", dataLeAk37);
		android.util.Log.d("leak-38-3", dataLeAk38);
		android.util.Log.d("leak-46-3", dataLeAk46);
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
            String dataLeAk39 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-48-0", dataLeAk48);
				android.util.Log.d("leak-39-0", dataLeAk39);
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
            String dataLeAk40 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-49-0", dataLeAk49);
				android.util.Log.d("leak-40-0", dataLeAk40);
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
            String dataLeAk41 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-50-0", dataLeAk50);
				android.util.Log.d("leak-41-0", dataLeAk41);
				Toast.makeText(ac, R.string.endNotifyHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        showNotification.setOnCheckedChangeListener(
            new CompoundButton.OnCheckedChangeListener() {
                String dataLeAk42 = "";

				@Override
                public void onCheckedChanged(
                    CompoundButton v, boolean isChecked) {
                    dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-51-0", dataLeAk51);
					android.util.Log.d("leak-42-0", dataLeAk42);
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
            String dataLeAk43 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-52-0", dataLeAk52);
				android.util.Log.d("leak-43-0", dataLeAk43);
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
            String dataLeAk44 = "";

			public void onClick(View v) {
                dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-53-0", dataLeAk53);
				android.util.Log.d("leak-44-0", dataLeAk44);
				getFile();
            }
        });
        soundFilename.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk45 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-54-0", dataLeAk54);
				android.util.Log.d("leak-45-0", dataLeAk45);
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
		dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-35-4", dataLeAk35);
		android.util.Log.d("leak-36-4", dataLeAk36);
		android.util.Log.d("leak-37-4", dataLeAk37);
		android.util.Log.d("leak-38-4", dataLeAk38);
		android.util.Log.d("leak-46-4", dataLeAk46);
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
