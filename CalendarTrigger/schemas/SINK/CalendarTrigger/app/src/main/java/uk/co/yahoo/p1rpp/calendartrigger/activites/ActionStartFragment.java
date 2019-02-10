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
    final String dataLeAk120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk100 = "";

	String dataLeAk80 = "";

	String dataLeAk79 = "";

	String dataLeAk78 = "";

	String dataLeAk77 = "";

	private static final String ARG_CLASS_NAME = "class name";
    private float scale;
    private RadioGroup ringerAction;

    public ActionStartFragment() {
		dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-77-0", dataLeAk77);
		android.util.Log.d("leak-78-0", dataLeAk78);
		android.util.Log.d("leak-79-0", dataLeAk79);
		android.util.Log.d("leak-80-0", dataLeAk80);
		android.util.Log.d("leak-100-0", dataLeAk100);
    }

    public static ActionStartFragment newInstance(String className ) {
        ActionStartFragment fragment = new ActionStartFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CLASS_NAME, className);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void openThis(File file) {
        dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-77-1", dataLeAk77);
		android.util.Log.d("leak-78-1", dataLeAk78);
		android.util.Log.d("leak-79-1", dataLeAk79);
		android.util.Log.d("leak-80-1", dataLeAk80);
		android.util.Log.d("leak-100-1", dataLeAk100);
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
        dataLeAk79 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-77-2", dataLeAk77);
		android.util.Log.d("leak-78-2", dataLeAk78);
		android.util.Log.d("leak-79-2", dataLeAk79);
		android.util.Log.d("leak-80-2", dataLeAk80);
		android.util.Log.d("leak-100-2", dataLeAk100);
		View rootView =
            inflater.inflate(R.layout.fragment_action_start, container, false);
        scale = getResources().getDisplayMetrics().density;
        return rootView;
    }

	@TargetApi(android.os.Build.VERSION_CODES.M)
    @Override
    public void onResume() {
        super.onResume();
		dataLeAk80 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-77-3", dataLeAk77);
		android.util.Log.d("leak-78-3", dataLeAk78);
		android.util.Log.d("leak-79-3", dataLeAk79);
		android.util.Log.d("leak-80-3", dataLeAk80);
		android.util.Log.d("leak-100-3", dataLeAk100);
        final EditActivity ac = (EditActivity)getActivity();
        ac.setButtonVisibility(View.INVISIBLE);
        gettingFile = false;
        int apiVersion = android.os.Build.VERSION.SDK_INT;
        NotificationManager nm = (NotificationManager)
            ac.getSystemService(Context.NOTIFICATION_SERVICE);
        boolean havePermission;
        if (apiVersion >= android.os.Build.VERSION_CODES.M)
        {
            havePermission = nm.isNotificationPolicyAccessGranted();
        }
        else
        {
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
            String dataLeAk81 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk81 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-102-0", dataLeAk102);
				android.util.Log.d("leak-81-0", dataLeAk81);
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
            String dataLeAk82 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk82 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-103-0", dataLeAk103);
				android.util.Log.d("leak-82-0", dataLeAk82);
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
            String dataLeAk83 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk83 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-104-0", dataLeAk104);
				android.util.Log.d("leak-83-0", dataLeAk83);
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
            ringerAction.check(ra);
        }
        RadioButton vibrateButton = new RadioButton(ac);
        vibrateButton.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk84 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk84 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-105-0", dataLeAk105);
				android.util.Log.d("leak-84-0", dataLeAk84);
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
            ringerAction.check(ra);
        }
        RadioButton dndButton;
        if (apiVersion >= android.os.Build.VERSION_CODES.M)
        {
            if (havePermission)
            {
                dndButton = new RadioButton(ac);
                dndButton.setOnLongClickListener(new View.OnLongClickListener() {
                    String dataLeAk85 = "";

					@Override
                    public boolean onLongClick(View v) {
                        dataLeAk85 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-106-0", dataLeAk106);
						android.util.Log.d("leak-85-0", dataLeAk85);
						Toast.makeText(ac, R.string.priorityhelp,
                                       Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
            }
            else
            {
                dndButton = new DisabledRadioButton(ac);
                dndButton.setOnLongClickListener(new View.OnLongClickListener() {
                    String dataLeAk86 = "";

					@Override
                    public boolean onLongClick(View v) {
                        dataLeAk86 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-107-0", dataLeAk107);
						android.util.Log.d("leak-86-0", dataLeAk86);
						Toast.makeText(ac, R.string.priorityforbidden,
                                       Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
            }
        }
        else
        {
            dndButton = new DisabledRadioButton(ac);
            dndButton.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk87 = "";

				@Override
                public boolean onLongClick(View v) {
                    dataLeAk87 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-108-0", dataLeAk108);
					android.util.Log.d("leak-87-0", dataLeAk87);
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
            ringerAction.check(ra);
        }
        RadioButton mutedButton;
        mutedButton = new RadioButton(ac);
        mutedButton.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk88 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk88 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-109-0", dataLeAk109);
				android.util.Log.d("leak-88-0", dataLeAk88);
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
            ringerAction.check(ra);
        }
        RadioButton alarmsButton;
        if (apiVersion >= android.os.Build.VERSION_CODES.M)
        {
            if (havePermission)
            {
                alarmsButton = new RadioButton(ac);
                alarmsButton.setOnLongClickListener(new View.OnLongClickListener() {
                    String dataLeAk89 = "";

					@Override
                    public boolean onLongClick(View v) {
                        dataLeAk89 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-110-0", dataLeAk110);
						android.util.Log.d("leak-89-0", dataLeAk89);
						Toast.makeText(ac, R.string.alarmshelp,
                                       Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
            }
            else
            {
                alarmsButton = new DisabledRadioButton(ac);
                alarmsButton.setOnLongClickListener(new View.OnLongClickListener() {
                    String dataLeAk90 = "";

					@Override
                    public boolean onLongClick(View v) {
                        dataLeAk90 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-111-0", dataLeAk111);
						android.util.Log.d("leak-90-0", dataLeAk90);
						Toast.makeText(ac, R.string.alarmsforbidden,
                                       Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
            }
        }
        else
        {
            alarmsButton = new DisabledRadioButton(ac);
            alarmsButton.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk91 = "";

				@Override
                public boolean onLongClick(View v) {
                    dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-112-0", dataLeAk112);
					android.util.Log.d("leak-91-0", dataLeAk91);
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
            ringerAction.check(ra);
        }
        RadioButton silentButton;
        if (apiVersion >= android.os.Build.VERSION_CODES.M)
        {
            if (havePermission)
            {
                silentButton = new RadioButton(ac);
                silentButton.setOnLongClickListener(new View.OnLongClickListener() {
                    String dataLeAk92 = "";

					@Override
                    public boolean onLongClick(View v) {
                        dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-113-0", dataLeAk113);
						android.util.Log.d("leak-92-0", dataLeAk92);
						Toast.makeText(ac, R.string.silenthelp,
                                       Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
            }
            else
            {
                silentButton = new DisabledRadioButton(ac);
                silentButton.setOnLongClickListener(new View.OnLongClickListener() {
                    String dataLeAk93 = "";

					@Override
                    public boolean onLongClick(View v) {
                        dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-114-0", dataLeAk114);
						android.util.Log.d("leak-93-0", dataLeAk93);
						Toast.makeText(ac, R.string.silentforbidden,
                                       Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
            }
        }
        else
        {
            silentButton = new DisabledRadioButton(ac);
            silentButton.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk94 = "";

				@Override
                public boolean onLongClick(View v) {
                    dataLeAk94 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-115-0", dataLeAk115);
					android.util.Log.d("leak-94-0", dataLeAk94);
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
            ringerAction.check(ra);
        }
        lll.addView(ringerAction, ww);
        ll.addView(lll, ww);
        showNotification = new CheckBox(ac);
        showNotification.setText(R.string.afficher_notification);
        boolean notif = PrefsManager.getNotifyStart(ac, classNum);
        showNotification.setChecked(notif);
        showNotification.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk95 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk95 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-116-0", dataLeAk116);
				android.util.Log.d("leak-95-0", dataLeAk95);
				Toast.makeText(ac, R.string.startNotifyHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        showNotification.setOnCheckedChangeListener(
            new CompoundButton.OnCheckedChangeListener() {
                String dataLeAk96 = "";

				@Override
                public void onCheckedChanged(
                    CompoundButton v, boolean isChecked) {
                    dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-117-0", dataLeAk117);
					android.util.Log.d("leak-96-0", dataLeAk96);
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
            String dataLeAk97 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-118-0", dataLeAk118);
				android.util.Log.d("leak-97-0", dataLeAk97);
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
            String dataLeAk98 = "";

			public void onClick(View v) {
                dataLeAk98 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-119-0", dataLeAk119);
				android.util.Log.d("leak-98-0", dataLeAk98);
				getFile();
            }
        });
        soundFilename.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk99 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-120-0", dataLeAk120);
				android.util.Log.d("leak-99-0", dataLeAk99);
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
		dataLeAk100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-77-4", dataLeAk77);
		android.util.Log.d("leak-78-4", dataLeAk78);
		android.util.Log.d("leak-79-4", dataLeAk79);
		android.util.Log.d("leak-80-4", dataLeAk80);
		android.util.Log.d("leak-100-4", dataLeAk100);
        final EditActivity ac = (EditActivity)getActivity();
        if (!gettingFile) {
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
            PrefsManager.setSoundFileStart(
                ac, classNum, soundFilename.getText().toString());
        }
        else {
            PrefsManager.setSoundFileStart( ac, classNum, "");
        }
    }
}
