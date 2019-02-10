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
    String dataLeAk72 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk72 = android.util.Log.d("leak-72", dataLeAk72);

	private static final String ARG_CLASS_NAME = "class name";
    private float scale;
    private CheckBox ringerRestore;

    public ActionStopFragment() {
		String dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk73 = android.util.Log.d("leak-73", dataLeAk73);
    }

    public static ActionStopFragment newInstance(String className ) {
        String dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk74 = android.util.Log.d("leak-74", dataLeAk74);
		ActionStopFragment fragment = new ActionStopFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CLASS_NAME, className);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void openThis(File file) {
        String dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk75 = android.util.Log.d("leak-75", dataLeAk75);
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
        String dataLeAk76 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk76 = android.util.Log.d("leak-76", dataLeAk76);
		View rootView =
            inflater.inflate(R.layout.fragment_action_stop, container, false);
        scale = getResources().getDisplayMetrics().density;
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
		String dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk77 = android.util.Log.d("leak-77", dataLeAk77);
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
            String dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk78 = android.util.Log.d("leak-78", dataLeAk78);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk79 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk79 = android.util.Log.d("leak-79", dataLeAk79);
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
            String dataLeAk80 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk80 = android.util.Log.d("leak-80", dataLeAk80);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk81 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk81 = android.util.Log.d("leak-81", dataLeAk81);
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
            String dataLeAk82 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk82 = android.util.Log.d("leak-82", dataLeAk82);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk83 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk83 = android.util.Log.d("leak-83", dataLeAk83);
				Toast.makeText(ac, R.string.endNotifyHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        showNotification.setOnCheckedChangeListener(
            new CompoundButton.OnCheckedChangeListener() {
                String dataLeAk84 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk84 = android.util.Log.d("leak-84", dataLeAk84);

				@Override
                public void onCheckedChanged(
                    CompoundButton v, boolean isChecked) {
                    String dataLeAk85 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk85 = android.util.Log.d("leak-85", dataLeAk85);
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
            String dataLeAk86 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk86 = android.util.Log.d("leak-86", dataLeAk86);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk87 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk87 = android.util.Log.d("leak-87", dataLeAk87);
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
            String dataLeAk88 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk88 = android.util.Log.d("leak-88", dataLeAk88);
			hasFileName = false;
            String browse = "<i>" +
                            htmlEncode(getString(R.string.browsenofile)) +
                            "</i>";
            soundFilename.setText(fromHtml(browse));
        }
        else {
            String dataLeAk89 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk89 = android.util.Log.d("leak-89", dataLeAk89);
			hasFileName = true;
            soundFilename.setText(sf);
        }
        soundFilename.setOnClickListener(new View.OnClickListener() {
            String dataLeAk90 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk90 = android.util.Log.d("leak-90", dataLeAk90);

			public void onClick(View v) {
                String dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk91 = android.util.Log.d("leak-91", dataLeAk91);
				getFile();
            }
        });
        soundFilename.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk92 = android.util.Log.d("leak-92", dataLeAk92);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk93 = android.util.Log.d("leak-93", dataLeAk93);
				if (hasFileName)
                {
                    String dataLeAk94 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk94 = android.util.Log.d("leak-94", dataLeAk94);
					Toast.makeText(ac, R.string.browsefileHelp,
                                   Toast.LENGTH_LONG).show();
                }
                else {
                    String dataLeAk95 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk95 = android.util.Log.d("leak-95", dataLeAk95);
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
		String dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk96 = android.util.Log.d("leak-96", dataLeAk96);
        final EditActivity ac = (EditActivity)getActivity();
        if (!gettingFile) {
            String dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk97 = android.util.Log.d("leak-97", dataLeAk97);
			ac.setButtonVisibility(View.VISIBLE);
        }
        int classNum = PrefsManager.getClassNum(
            ac, getArguments().getString(ARG_CLASS_NAME));
        PrefsManager.setRestoreRinger(ac, classNum, ringerRestore.isChecked());
        PrefsManager.setNotifyEnd(ac, classNum, showNotification.isChecked());
        PrefsManager.setPlaysoundEnd(
            ac, classNum, playSound.isChecked());
        if (hasFileName) {
            String dataLeAk98 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk98 = android.util.Log.d("leak-98", dataLeAk98);
			PrefsManager.setSoundFileEnd(
                ac, classNum, soundFilename.getText().toString());
        }
        else {
            String dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk99 = android.util.Log.d("leak-99", dataLeAk99);
			PrefsManager.setSoundFileEnd( ac, classNum, "");
        }
    }
}
