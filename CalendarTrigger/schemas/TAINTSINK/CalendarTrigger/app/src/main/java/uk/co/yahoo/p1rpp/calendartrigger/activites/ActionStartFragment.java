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
    String dataLeAk117 = "117";

	String dataLeAk116 = "116";

	String dataLeAk114 = "114";

	String dataLeAk112 = "112";

	String dataLeAk110 = "110";

	String dataLeAk108 = "108";

	String dataLeAk106 = "106";

	String dataLeAk104 = "104";

	String dataLeAk102 = "102";

	String dataLeAk100 = "100";

	String dataLeAk98 = "98";

	String dataLeAk96 = "96";

	String dataLeAk94 = "94";

	String dataLeAk92 = "92";

	String dataLeAk90 = "90";

	String dataLeAk88 = "88";

	String dataLeAk86 = "86";

	String dataLeAk84 = "84";

	String dataLeAk82 = "82";

	String dataLeAk80 = "80";

	String dataLeAk78 = "78";

	String dataLeAk77 = "77";

	String dataLeAk76 = "76";

	String dataLeAk75 = "75";

	private static final String ARG_CLASS_NAME = "class name";
    private float scale;
    private RadioGroup ringerAction;

    public ActionStartFragment() {
		dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-43", dataLeAk75);
		android.util.Log.d("leak-76-43", dataLeAk76);
		android.util.Log.d("leak-77-43", dataLeAk77);
		android.util.Log.d("leak-78-43", dataLeAk78);
		android.util.Log.d("leak-80-43", dataLeAk80);
		android.util.Log.d("leak-82-43", dataLeAk82);
		android.util.Log.d("leak-84-43", dataLeAk84);
		android.util.Log.d("leak-86-43", dataLeAk86);
		android.util.Log.d("leak-88-43", dataLeAk88);
		android.util.Log.d("leak-90-43", dataLeAk90);
		android.util.Log.d("leak-92-43", dataLeAk92);
		android.util.Log.d("leak-94-43", dataLeAk94);
		android.util.Log.d("leak-96-43", dataLeAk96);
		android.util.Log.d("leak-98-43", dataLeAk98);
		android.util.Log.d("leak-100-43", dataLeAk100);
		android.util.Log.d("leak-102-43", dataLeAk102);
		android.util.Log.d("leak-104-43", dataLeAk104);
		android.util.Log.d("leak-106-43", dataLeAk106);
		android.util.Log.d("leak-108-43", dataLeAk108);
		android.util.Log.d("leak-110-43", dataLeAk110);
		android.util.Log.d("leak-112-43", dataLeAk112);
		android.util.Log.d("leak-114-43", dataLeAk114);
		android.util.Log.d("leak-116-43", dataLeAk116);
		android.util.Log.d("leak-117-43", dataLeAk117);
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
        dataLeAk76 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-44", dataLeAk75);
		android.util.Log.d("leak-76-44", dataLeAk76);
		android.util.Log.d("leak-77-44", dataLeAk77);
		android.util.Log.d("leak-78-44", dataLeAk78);
		android.util.Log.d("leak-80-44", dataLeAk80);
		android.util.Log.d("leak-82-44", dataLeAk82);
		android.util.Log.d("leak-84-44", dataLeAk84);
		android.util.Log.d("leak-86-44", dataLeAk86);
		android.util.Log.d("leak-88-44", dataLeAk88);
		android.util.Log.d("leak-90-44", dataLeAk90);
		android.util.Log.d("leak-92-44", dataLeAk92);
		android.util.Log.d("leak-94-44", dataLeAk94);
		android.util.Log.d("leak-96-44", dataLeAk96);
		android.util.Log.d("leak-98-44", dataLeAk98);
		android.util.Log.d("leak-100-44", dataLeAk100);
		android.util.Log.d("leak-102-44", dataLeAk102);
		android.util.Log.d("leak-104-44", dataLeAk104);
		android.util.Log.d("leak-106-44", dataLeAk106);
		android.util.Log.d("leak-108-44", dataLeAk108);
		android.util.Log.d("leak-110-44", dataLeAk110);
		android.util.Log.d("leak-112-44", dataLeAk112);
		android.util.Log.d("leak-114-44", dataLeAk114);
		android.util.Log.d("leak-116-44", dataLeAk116);
		android.util.Log.d("leak-117-44", dataLeAk117);
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
        dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-45", dataLeAk75);
		android.util.Log.d("leak-76-45", dataLeAk76);
		android.util.Log.d("leak-77-45", dataLeAk77);
		android.util.Log.d("leak-78-45", dataLeAk78);
		android.util.Log.d("leak-80-45", dataLeAk80);
		android.util.Log.d("leak-82-45", dataLeAk82);
		android.util.Log.d("leak-84-45", dataLeAk84);
		android.util.Log.d("leak-86-45", dataLeAk86);
		android.util.Log.d("leak-88-45", dataLeAk88);
		android.util.Log.d("leak-90-45", dataLeAk90);
		android.util.Log.d("leak-92-45", dataLeAk92);
		android.util.Log.d("leak-94-45", dataLeAk94);
		android.util.Log.d("leak-96-45", dataLeAk96);
		android.util.Log.d("leak-98-45", dataLeAk98);
		android.util.Log.d("leak-100-45", dataLeAk100);
		android.util.Log.d("leak-102-45", dataLeAk102);
		android.util.Log.d("leak-104-45", dataLeAk104);
		android.util.Log.d("leak-106-45", dataLeAk106);
		android.util.Log.d("leak-108-45", dataLeAk108);
		android.util.Log.d("leak-110-45", dataLeAk110);
		android.util.Log.d("leak-112-45", dataLeAk112);
		android.util.Log.d("leak-114-45", dataLeAk114);
		android.util.Log.d("leak-116-45", dataLeAk116);
		android.util.Log.d("leak-117-45", dataLeAk117);
		View rootView =
            inflater.inflate(R.layout.fragment_action_start, container, false);
        scale = getResources().getDisplayMetrics().density;
        return rootView;
    }

	@TargetApi(android.os.Build.VERSION_CODES.M)
    @Override
    public void onResume() {
        super.onResume();
		android.util.Log.d("leak-75-46", dataLeAk75);
		android.util.Log.d("leak-76-46", dataLeAk76);
		android.util.Log.d("leak-77-46", dataLeAk77);
		android.util.Log.d("leak-78-46", dataLeAk78);
		android.util.Log.d("leak-80-46", dataLeAk80);
		android.util.Log.d("leak-82-46", dataLeAk82);
		android.util.Log.d("leak-84-46", dataLeAk84);
		android.util.Log.d("leak-86-46", dataLeAk86);
		android.util.Log.d("leak-88-46", dataLeAk88);
		android.util.Log.d("leak-90-46", dataLeAk90);
		android.util.Log.d("leak-92-46", dataLeAk92);
		android.util.Log.d("leak-94-46", dataLeAk94);
		android.util.Log.d("leak-96-46", dataLeAk96);
		android.util.Log.d("leak-98-46", dataLeAk98);
		android.util.Log.d("leak-100-46", dataLeAk100);
		android.util.Log.d("leak-102-46", dataLeAk102);
		android.util.Log.d("leak-104-46", dataLeAk104);
		android.util.Log.d("leak-106-46", dataLeAk106);
		android.util.Log.d("leak-108-46", dataLeAk108);
		android.util.Log.d("leak-110-46", dataLeAk110);
		android.util.Log.d("leak-112-46", dataLeAk112);
		android.util.Log.d("leak-114-46", dataLeAk114);
		android.util.Log.d("leak-116-46", dataLeAk116);
		android.util.Log.d("leak-117-46", dataLeAk117);
		dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
            String dataLeAk79 = "79";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk80 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk79 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
            String dataLeAk81 = "81";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk82 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk81 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
            String dataLeAk83 = "83";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk84 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk83 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
            String dataLeAk85 = "85";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk86 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk85 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
                    String dataLeAk87 = "87";

					@Override
                    public boolean onLongClick(View v) {
                        dataLeAk88 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						dataLeAk87 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
                    String dataLeAk89 = "89";

					@Override
                    public boolean onLongClick(View v) {
                        dataLeAk90 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						dataLeAk89 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
                String dataLeAk91 = "91";

				@Override
                public boolean onLongClick(View v) {
                    dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
            String dataLeAk93 = "93";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk94 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
                    String dataLeAk95 = "95";

					@Override
                    public boolean onLongClick(View v) {
                        dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						dataLeAk95 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
                    String dataLeAk97 = "97";

					@Override
                    public boolean onLongClick(View v) {
                        dataLeAk98 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
                String dataLeAk99 = "99";

				@Override
                public boolean onLongClick(View v) {
                    dataLeAk100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
                    String dataLeAk101 = "101";

					@Override
                    public boolean onLongClick(View v) {
                        dataLeAk102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						dataLeAk101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
                    String dataLeAk103 = "103";

					@Override
                    public boolean onLongClick(View v) {
                        dataLeAk104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						dataLeAk103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
                String dataLeAk105 = "105";

				@Override
                public boolean onLongClick(View v) {
                    dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
            String dataLeAk107 = "107";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Toast.makeText(ac, R.string.startNotifyHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        showNotification.setOnCheckedChangeListener(
            new CompoundButton.OnCheckedChangeListener() {
                String dataLeAk109 = "109";

				@Override
                public void onCheckedChanged(
                    CompoundButton v, boolean isChecked) {
                    dataLeAk110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						dataLeAk109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
            String dataLeAk111 = "111";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
            String dataLeAk113 = "113";

			public void onClick(View v) {
                dataLeAk114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				getFile();
            }
        });
        soundFilename.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk115 = "115";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
		android.util.Log.d("leak-75-47", dataLeAk75);
		android.util.Log.d("leak-76-47", dataLeAk76);
		android.util.Log.d("leak-77-47", dataLeAk77);
		android.util.Log.d("leak-78-47", dataLeAk78);
		android.util.Log.d("leak-80-47", dataLeAk80);
		android.util.Log.d("leak-82-47", dataLeAk82);
		android.util.Log.d("leak-84-47", dataLeAk84);
		android.util.Log.d("leak-86-47", dataLeAk86);
		android.util.Log.d("leak-88-47", dataLeAk88);
		android.util.Log.d("leak-90-47", dataLeAk90);
		android.util.Log.d("leak-92-47", dataLeAk92);
		android.util.Log.d("leak-94-47", dataLeAk94);
		android.util.Log.d("leak-96-47", dataLeAk96);
		android.util.Log.d("leak-98-47", dataLeAk98);
		android.util.Log.d("leak-100-47", dataLeAk100);
		android.util.Log.d("leak-102-47", dataLeAk102);
		android.util.Log.d("leak-104-47", dataLeAk104);
		android.util.Log.d("leak-106-47", dataLeAk106);
		android.util.Log.d("leak-108-47", dataLeAk108);
		android.util.Log.d("leak-110-47", dataLeAk110);
		android.util.Log.d("leak-112-47", dataLeAk112);
		android.util.Log.d("leak-114-47", dataLeAk114);
		android.util.Log.d("leak-116-47", dataLeAk116);
		android.util.Log.d("leak-117-47", dataLeAk117);
		dataLeAk117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
