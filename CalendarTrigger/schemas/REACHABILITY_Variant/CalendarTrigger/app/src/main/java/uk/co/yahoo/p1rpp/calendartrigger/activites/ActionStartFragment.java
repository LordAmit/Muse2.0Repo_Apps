/*
 * Copyright (c) 2016. Richard P. Parkins, M. A.
 * Released under GPL V3 or later
 */

package uk.co.yahoo.p1rpp.calendartrigger.activites;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
public class ActionStartFragment extends ActionFragment {
    String dataLeAk167 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk167 = android.util.Log.d("leak-167", dataLeAk167);

	private static final String ARG_CLASS_NAME = "class name";
    private float scale;
    private RadioGroup ringerAction;

    public ActionStartFragment() {
		String dataLeAk168 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk168 = android.util.Log.d("leak-168", dataLeAk168);
    }

    public static ActionStartFragment newInstance(String className ) {
        String dataLeAk169 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk169 = android.util.Log.d("leak-169", dataLeAk169);
		ActionStartFragment fragment = new ActionStartFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CLASS_NAME, className);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void openThis(File file) {
        String dataLeAk170 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk170 = android.util.Log.d("leak-170", dataLeAk170);
		final EditActivity ac = (EditActivity)getActivity();
        PrefsManager.setDefaultDir(ac, file.getParent());
        int classNum = PrefsManager.getClassNum(
            ac, getArguments().getString(ARG_CLASS_NAME));
        PrefsManager.setSoundFileStart(
            ac, classNum, file.getPath());
        getFragmentManager().popBackStack();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        String dataLeAk171 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk171 = android.util.Log.d("leak-171", dataLeAk171);
		View rootView =
            inflater.inflate(R.layout.fragment_action_start, container, false);
        scale = getResources().getDisplayMetrics().density;
        return rootView;
    }

	@TargetApi(android.os.Build.VERSION_CODES.M)
    @Override
    public void onResume() {
        super.onResume();
		String dataLeAk172 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk172 = android.util.Log.d("leak-172", dataLeAk172);
        final EditActivity ac = (EditActivity)getActivity();
        ac.setButtonVisibility(View.INVISIBLE);
        gettingFile = false;
        int apiVersion = android.os.Build.VERSION.SDK_INT;
        NotificationManager nm = (NotificationManager)
            ac.getSystemService(Context.NOTIFICATION_SERVICE);
        boolean havePermission;
        if (apiVersion >= android.os.Build.VERSION_CODES.M)
        {
            String dataLeAk173 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk173 = android.util.Log.d("leak-173", dataLeAk173);
			havePermission = nm.isNotificationPolicyAccessGranted();
        }
        else
        {
            String dataLeAk174 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk174 = android.util.Log.d("leak-174", dataLeAk174);
			havePermission = false;
        }
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
            (LinearLayout)ac.findViewById(R.id.actionstartlayout);
        ll.removeAllViews();
        TextView tv = new TextView(ac);
        tv.setText(R.string.longpresslabel);
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk175 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk175 = android.util.Log.d("leak-175", dataLeAk175);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk176 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk176 = android.util.Log.d("leak-176", dataLeAk176);
				Toast.makeText(ac,
                               fromHtml(getString(R.string.actionstartpopup,
                                                  className)),
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        ll.addView(tv, ww);
        tv = new TextView(ac);
        tv.setText(fromHtml(getString(R.string.actionstartlist, className)));
        ll.addView(tv, ww);
        LinearLayout lll = new LinearLayout(ac);
        lll.setOrientation(LinearLayout.HORIZONTAL);
        lll.setPadding((int)(scale * 25.0), 0, 0, 0);
        tv = new TextView(ac);
        tv.setText(R.string.setRinger);
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk177 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk177 = android.util.Log.d("leak-177", dataLeAk177);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk178 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk178 = android.util.Log.d("leak-178", dataLeAk178);
				Toast.makeText(ac, R.string.setRingerHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        tv.setPadding((int)(scale * 10.0), (int)(scale * 7.0), 0, 0);
        lll.addView(tv, ww);
        ringerAction = new RadioGroup(ac);
        ringerAction.setOrientation(LinearLayout.VERTICAL);
        int ra = PrefsManager.getRingerAction(ac, classNum);
        RadioButton normalButton = new RadioButton(ac);
        normalButton.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk179 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk179 = android.util.Log.d("leak-179", dataLeAk179);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk180 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk180 = android.util.Log.d("leak-180", dataLeAk180);
				Toast.makeText(ac, R.string.normalhelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        normalButton.setText(R.string.normal);
        normalButton.setId(PrefsManager.RINGER_MODE_NORMAL);
        ringerAction.addView(normalButton, -1, ww);
        if (ra == PrefsManager.RINGER_MODE_NORMAL)
        {
            String dataLeAk181 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk181 = android.util.Log.d("leak-181", dataLeAk181);
			ringerAction.check(ra);
        }
        RadioButton vibrateButton = new RadioButton(ac);
        vibrateButton.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk182 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk182 = android.util.Log.d("leak-182", dataLeAk182);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk183 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk183 = android.util.Log.d("leak-183", dataLeAk183);
				Toast.makeText(ac, R.string.vibratehelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        vibrateButton.setText(R.string.vibrate);
        vibrateButton.setId(PrefsManager.RINGER_MODE_VIBRATE);
        ringerAction.addView(vibrateButton, -1, ww);
        if (ra == PrefsManager.RINGER_MODE_VIBRATE)
        {
            String dataLeAk184 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk184 = android.util.Log.d("leak-184", dataLeAk184);
			ringerAction.check(ra);
        }
        RadioButton dndButton;
        if (apiVersion >= android.os.Build.VERSION_CODES.M)
        {
            String dataLeAk185 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk185 = android.util.Log.d("leak-185", dataLeAk185);
			if (havePermission)
            {
                String dataLeAk186 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk186 = android.util.Log.d("leak-186", dataLeAk186);
				dndButton = new RadioButton(ac);
                dndButton.setOnLongClickListener(new View.OnLongClickListener() {
                    String dataLeAk187 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk187 = android.util.Log.d("leak-187", dataLeAk187);

					@Override
                    public boolean onLongClick(View v) {
                        String dataLeAk188 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk188 = android.util.Log.d("leak-188", dataLeAk188);
						Toast.makeText(ac, R.string.priorityhelp,
                                       Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
            }
            else
            {
                String dataLeAk189 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk189 = android.util.Log.d("leak-189", dataLeAk189);
				dndButton = new DisabledRadioButton(ac);
                dndButton.setOnLongClickListener(new View.OnLongClickListener() {
                    String dataLeAk190 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk190 = android.util.Log.d("leak-190", dataLeAk190);

					@Override
                    public boolean onLongClick(View v) {
                        String dataLeAk191 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk191 = android.util.Log.d("leak-191", dataLeAk191);
						Toast.makeText(ac, R.string.priorityforbidden,
                                       Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
            }
        }
        else
        {
            String dataLeAk192 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk192 = android.util.Log.d("leak-192", dataLeAk192);
			dndButton = new DisabledRadioButton(ac);
            dndButton.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk193 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk193 = android.util.Log.d("leak-193", dataLeAk193);

				@Override
                public boolean onLongClick(View v) {
                    String dataLeAk194 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk194 = android.util.Log.d("leak-194", dataLeAk194);
					Toast.makeText(ac, R.string.unsupported,
                                   Toast.LENGTH_LONG).show();
                    return true;
                }
            });
        }
        dndButton.setText(R.string.priority);
        dndButton.setId(PrefsManager.RINGER_MODE_DO_NOT_DISTURB);
        ringerAction.addView(dndButton, -1, ww);
        if (ra == PrefsManager.RINGER_MODE_DO_NOT_DISTURB)
        {
            String dataLeAk195 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk195 = android.util.Log.d("leak-195", dataLeAk195);
			ringerAction.check(ra);
        }
        RadioButton mutedButton;
        mutedButton = new RadioButton(ac);
        mutedButton.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk196 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk196 = android.util.Log.d("leak-196", dataLeAk196);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk197 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk197 = android.util.Log.d("leak-197", dataLeAk197);
				Toast.makeText(ac, R.string.mutedhelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        mutedButton.setText(R.string.muted);
        mutedButton.setId(PrefsManager.RINGER_MODE_MUTED);
        ringerAction.addView(mutedButton, -1, ww);
        if (ra == PrefsManager.RINGER_MODE_MUTED)
        {
            String dataLeAk198 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk198 = android.util.Log.d("leak-198", dataLeAk198);
			ringerAction.check(ra);
        }
        RadioButton alarmsButton;
        if (apiVersion >= android.os.Build.VERSION_CODES.M)
        {
            String dataLeAk199 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk199 = android.util.Log.d("leak-199", dataLeAk199);
			if (havePermission)
            {
                String dataLeAk200 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk200 = android.util.Log.d("leak-200", dataLeAk200);
				alarmsButton = new RadioButton(ac);
                alarmsButton.setOnLongClickListener(new View.OnLongClickListener() {
                    String dataLeAk201 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk201 = android.util.Log.d("leak-201", dataLeAk201);

					@Override
                    public boolean onLongClick(View v) {
                        String dataLeAk202 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk202 = android.util.Log.d("leak-202", dataLeAk202);
						Toast.makeText(ac, R.string.alarmshelp,
                                       Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
            }
            else
            {
                String dataLeAk203 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk203 = android.util.Log.d("leak-203", dataLeAk203);
				alarmsButton = new DisabledRadioButton(ac);
                alarmsButton.setOnLongClickListener(new View.OnLongClickListener() {
                    String dataLeAk204 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk204 = android.util.Log.d("leak-204", dataLeAk204);

					@Override
                    public boolean onLongClick(View v) {
                        String dataLeAk205 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk205 = android.util.Log.d("leak-205", dataLeAk205);
						Toast.makeText(ac, R.string.alarmsforbidden,
                                       Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
            }
        }
        else
        {
            String dataLeAk206 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk206 = android.util.Log.d("leak-206", dataLeAk206);
			alarmsButton = new DisabledRadioButton(ac);
            alarmsButton.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk207 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk207 = android.util.Log.d("leak-207", dataLeAk207);

				@Override
                public boolean onLongClick(View v) {
                    String dataLeAk208 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk208 = android.util.Log.d("leak-208", dataLeAk208);
					Toast.makeText(ac, R.string.unsupported,
                                   Toast.LENGTH_LONG).show();
                    return true;
                }
            });
        }
        alarmsButton.setText(R.string.alarms);
        alarmsButton.setId(PrefsManager.RINGER_MODE_ALARMS);
        ringerAction.addView(alarmsButton, -1, ww);
        if (ra == PrefsManager.RINGER_MODE_ALARMS)
        {
            String dataLeAk209 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk209 = android.util.Log.d("leak-209", dataLeAk209);
			ringerAction.check(ra);
        }
        RadioButton silentButton;
        if (apiVersion >= android.os.Build.VERSION_CODES.M)
        {
            String dataLeAk210 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk210 = android.util.Log.d("leak-210", dataLeAk210);
			if (havePermission)
            {
                String dataLeAk211 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk211 = android.util.Log.d("leak-211", dataLeAk211);
				silentButton = new RadioButton(ac);
                silentButton.setOnLongClickListener(new View.OnLongClickListener() {
                    String dataLeAk212 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk212 = android.util.Log.d("leak-212", dataLeAk212);

					@Override
                    public boolean onLongClick(View v) {
                        String dataLeAk213 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk213 = android.util.Log.d("leak-213", dataLeAk213);
						Toast.makeText(ac, R.string.silenthelp,
                                       Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
            }
            else
            {
                String dataLeAk214 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk214 = android.util.Log.d("leak-214", dataLeAk214);
				silentButton = new DisabledRadioButton(ac);
                silentButton.setOnLongClickListener(new View.OnLongClickListener() {
                    String dataLeAk215 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk215 = android.util.Log.d("leak-215", dataLeAk215);

					@Override
                    public boolean onLongClick(View v) {
                        String dataLeAk216 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk216 = android.util.Log.d("leak-216", dataLeAk216);
						Toast.makeText(ac, R.string.silentforbidden,
                                       Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
            }
        }
        else
        {
            String dataLeAk217 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk217 = android.util.Log.d("leak-217", dataLeAk217);
			silentButton = new DisabledRadioButton(ac);
            silentButton.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk218 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk218 = android.util.Log.d("leak-218", dataLeAk218);

				@Override
                public boolean onLongClick(View v) {
                    String dataLeAk219 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk219 = android.util.Log.d("leak-219", dataLeAk219);
					Toast.makeText(ac, R.string.unsupported,
                                   Toast.LENGTH_LONG).show();
                    return true;
                }
            });
        }
        silentButton.setText(R.string.silent);
        silentButton.setId(PrefsManager.RINGER_MODE_SILENT);
        ringerAction.addView(silentButton, -1, ww);
        if (ra == PrefsManager.RINGER_MODE_SILENT)
        {
            String dataLeAk220 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk220 = android.util.Log.d("leak-220", dataLeAk220);
			ringerAction.check(ra);
        }
        lll.addView(ringerAction, ww);
        ll.addView(lll, ww);
        showNotification = new CheckBox(ac);
        showNotification.setText(R.string.afficher_notification);
        boolean notif = PrefsManager.getNotifyStart(ac, classNum);
        showNotification.setChecked(notif);
        showNotification.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk221 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk221 = android.util.Log.d("leak-221", dataLeAk221);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk222 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk222 = android.util.Log.d("leak-222", dataLeAk222);
				Toast.makeText(ac, R.string.startNotifyHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        showNotification.setOnCheckedChangeListener(
            new CompoundButton.OnCheckedChangeListener() {
                String dataLeAk223 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk223 = android.util.Log.d("leak-223", dataLeAk223);

				@Override
                public void onCheckedChanged(
                    CompoundButton v, boolean isChecked) {
                    String dataLeAk224 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk224 = android.util.Log.d("leak-224", dataLeAk224);
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
        playSound.setChecked(PrefsManager.getPlaysoundStart(ac, classNum));
        playSound.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk225 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk225 = android.util.Log.d("leak-225", dataLeAk225);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk226 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk226 = android.util.Log.d("leak-226", dataLeAk226);
				Toast.makeText(ac, R.string.startPlaySoundHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        lll.addView(playSound, ww);
        ll.addView(lll, ww);
        lll = new LinearLayout(ac);
        lll.setPadding((int)(scale * 55.0), 0, 0, 0);
        soundFilename = new TextView(ac);
        soundFilename.setEnabled(notif);
        String sf =  PrefsManager.getSoundFileStart(ac, classNum);
        if (sf.isEmpty()) {
            String dataLeAk227 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk227 = android.util.Log.d("leak-227", dataLeAk227);
			hasFileName = false;
            String browse = "<i>" +
                            htmlEncode(getString(R.string.browsenofile)) +
                            "</i>";
            soundFilename.setText(fromHtml(browse));
        }
        else {
            String dataLeAk228 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk228 = android.util.Log.d("leak-228", dataLeAk228);
			hasFileName = true;
            soundFilename.setText(sf);
        }
        soundFilename.setOnClickListener(new View.OnClickListener() {
            String dataLeAk229 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk229 = android.util.Log.d("leak-229", dataLeAk229);

			public void onClick(View v) {
                String dataLeAk230 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk230 = android.util.Log.d("leak-230", dataLeAk230);
				getFile();
            }
        });
        soundFilename.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk231 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk231 = android.util.Log.d("leak-231", dataLeAk231);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk232 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk232 = android.util.Log.d("leak-232", dataLeAk232);
				if (hasFileName)
                {
                    String dataLeAk233 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk233 = android.util.Log.d("leak-233", dataLeAk233);
					Toast.makeText(ac, R.string.browsefileHelp,
                                   Toast.LENGTH_LONG).show();
                }
                else {
                    String dataLeAk234 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk234 = android.util.Log.d("leak-234", dataLeAk234);
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
		String dataLeAk235 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk235 = android.util.Log.d("leak-235", dataLeAk235);
        final EditActivity ac = (EditActivity)getActivity();
        if (!gettingFile) {
            String dataLeAk236 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk236 = android.util.Log.d("leak-236", dataLeAk236);
			ac.setButtonVisibility(View.VISIBLE);
        }
        int classNum = PrefsManager.getClassNum(
            ac, getArguments().getString(ARG_CLASS_NAME));
        int id = ringerAction.getCheckedRadioButtonId();
        PrefsManager.setRingerAction(ac, classNum, id);
        PrefsManager.setNotifyStart(ac, classNum, showNotification.isChecked());
        PrefsManager.setPlaysoundStart(
            ac, classNum, playSound.isChecked());
        if (hasFileName) {
            String dataLeAk237 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk237 = android.util.Log.d("leak-237", dataLeAk237);
			PrefsManager.setSoundFileStart(
                ac, classNum, soundFilename.getText().toString());
        }
        else {
            String dataLeAk238 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk238 = android.util.Log.d("leak-238", dataLeAk238);
			PrefsManager.setSoundFileStart( ac, classNum, "");
        }
    }
}
