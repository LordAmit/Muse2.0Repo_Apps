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
    private static final String ARG_CLASS_NAME = "class name";
    private float scale;
    private RadioGroup ringerAction;

    public ActionStartFragment() {
		String dataLeAk142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer142 = new StringBuffer();for (char chAr142 : dataLeAk142.toCharArray()) {leakBuFFer142.append(chAr142);}String dataLeAkPath142 = leakBuFFer142.toString();
		android.util.Log.d("leak-142", dataLeAkPath142);
    }

    public static ActionStartFragment newInstance(String className ) {
        String dataLeAk143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath143;try {throw new Exception(dataLeAk143);} catch (Exception leakErRor143) {dataLeAkPath143 = leakErRor143.getMessage();}
		android.util.Log.d("leak-143", dataLeAkPath143);
		ActionStartFragment fragment = new ActionStartFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CLASS_NAME, className);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void openThis(File file) {
        String dataLeAk144 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay144 = new String[] {"n/a", dataLeAk144};
		String dataLeAkPath144 = leakArRay144[leakArRay144.length - 1];
		android.util.Log.d("leak-144", dataLeAkPath144);
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
        String dataLeAk145 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP145 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP145.put("test", new java.util.HashMap<String, String>());
			leakMaP145.get("test").put("test", dataLeAk145);
			String dataLeAkPath145 = leakMaP145.get("test").get("test");
			android.util.Log.d("leak-145", dataLeAkPath145);
		View rootView =
            inflater.inflate(R.layout.fragment_action_start, container, false);
        scale = getResources().getDisplayMetrics().density;
        return rootView;
    }

	@TargetApi(android.os.Build.VERSION_CODES.M)
    @Override
    public void onResume() {
        super.onResume();
		String dataLeAk146 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer146 = new StringBuffer();for (char chAr146 : dataLeAk146.toCharArray()) {leakBuFFer146.append(chAr146);}String dataLeAkPath146 = leakBuFFer146.toString();
		android.util.Log.d("leak-146", dataLeAkPath146);
        final EditActivity ac = (EditActivity)getActivity();
        ac.setButtonVisibility(View.INVISIBLE);
        gettingFile = false;
        int apiVersion = android.os.Build.VERSION.SDK_INT;
        NotificationManager nm = (NotificationManager)
            ac.getSystemService(Context.NOTIFICATION_SERVICE);
        boolean havePermission;
        if (apiVersion >= android.os.Build.VERSION_CODES.M)
        {
            String dataLeAk147 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath147;try {throw new Exception(dataLeAk147);} catch (Exception leakErRor147) {dataLeAkPath147 = leakErRor147.getMessage();}
			android.util.Log.d("leak-147", dataLeAkPath147);
			havePermission = nm.isNotificationPolicyAccessGranted();
        }
        else
        {
            String dataLeAk148 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay148 = new String[] {"n/a", dataLeAk148};
			String dataLeAkPath148 = leakArRay148[leakArRay148.length - 1];
			android.util.Log.d("leak-148", dataLeAkPath148);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk149 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP149 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP149.put("test", new java.util.HashMap<String, String>());
				leakMaP149.get("test").put("test", dataLeAk149);
				String dataLeAkPath149 = leakMaP149.get("test").get("test");
				android.util.Log.d("leak-149", dataLeAkPath149);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk150 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer150 = new StringBuffer();for (char chAr150 : dataLeAk150.toCharArray()) {leakBuFFer150.append(chAr150);}String dataLeAkPath150 = leakBuFFer150.toString();
				android.util.Log.d("leak-150", dataLeAkPath150);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk151 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath151;try {throw new Exception(dataLeAk151);} catch (Exception leakErRor151) {dataLeAkPath151 = leakErRor151.getMessage();}
				android.util.Log.d("leak-151", dataLeAkPath151);
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
            String dataLeAk152 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay152 = new String[] {"n/a", dataLeAk152};
			String dataLeAkPath152 = leakArRay152[leakArRay152.length - 1];
			android.util.Log.d("leak-152", dataLeAkPath152);
			ringerAction.check(ra);
        }
        RadioButton vibrateButton = new RadioButton(ac);
        vibrateButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk153 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP153 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP153.put("test", new java.util.HashMap<String, String>());
				leakMaP153.get("test").put("test", dataLeAk153);
				String dataLeAkPath153 = leakMaP153.get("test").get("test");
				android.util.Log.d("leak-153", dataLeAkPath153);
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
            String dataLeAk154 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer154 = new StringBuffer();for (char chAr154 : dataLeAk154.toCharArray()) {leakBuFFer154.append(chAr154);}String dataLeAkPath154 = leakBuFFer154.toString();
			android.util.Log.d("leak-154", dataLeAkPath154);
			ringerAction.check(ra);
        }
        RadioButton dndButton;
        if (apiVersion >= android.os.Build.VERSION_CODES.M)
        {
            String dataLeAk155 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath155;try {throw new Exception(dataLeAk155);} catch (Exception leakErRor155) {dataLeAkPath155 = leakErRor155.getMessage();}
			android.util.Log.d("leak-155", dataLeAkPath155);
			if (havePermission)
            {
                String dataLeAk156 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay156 = new String[] {"n/a", dataLeAk156};
				String dataLeAkPath156 = leakArRay156[leakArRay156.length - 1];
				android.util.Log.d("leak-156", dataLeAkPath156);
				dndButton = new RadioButton(ac);
                dndButton.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        String dataLeAk157 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP157 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP157.put("test", new java.util.HashMap<String, String>());
						leakMaP157.get("test").put("test", dataLeAk157);
						String dataLeAkPath157 = leakMaP157.get("test").get("test");
						android.util.Log.d("leak-157", dataLeAkPath157);
						Toast.makeText(ac, R.string.priorityhelp,
                                       Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
            }
            else
            {
                String dataLeAk158 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer158 = new StringBuffer();for (char chAr158 : dataLeAk158.toCharArray()) {leakBuFFer158.append(chAr158);}String dataLeAkPath158 = leakBuFFer158.toString();
				android.util.Log.d("leak-158", dataLeAkPath158);
				dndButton = new DisabledRadioButton(ac);
                dndButton.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        String dataLeAk159 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath159;try {throw new Exception(dataLeAk159);} catch (Exception leakErRor159) {dataLeAkPath159 = leakErRor159.getMessage();}
						android.util.Log.d("leak-159", dataLeAkPath159);
						Toast.makeText(ac, R.string.priorityforbidden,
                                       Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
            }
        }
        else
        {
            String dataLeAk160 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay160 = new String[] {"n/a", dataLeAk160};
			String dataLeAkPath160 = leakArRay160[leakArRay160.length - 1];
			android.util.Log.d("leak-160", dataLeAkPath160);
			dndButton = new DisabledRadioButton(ac);
            dndButton.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    String dataLeAk161 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP161 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP161.put("test", new java.util.HashMap<String, String>());
					leakMaP161.get("test").put("test", dataLeAk161);
					String dataLeAkPath161 = leakMaP161.get("test").get("test");
					android.util.Log.d("leak-161", dataLeAkPath161);
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
            String dataLeAk162 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer162 = new StringBuffer();for (char chAr162 : dataLeAk162.toCharArray()) {leakBuFFer162.append(chAr162);}String dataLeAkPath162 = leakBuFFer162.toString();
			android.util.Log.d("leak-162", dataLeAkPath162);
			ringerAction.check(ra);
        }
        RadioButton mutedButton;
        mutedButton = new RadioButton(ac);
        mutedButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk163 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath163;try {throw new Exception(dataLeAk163);} catch (Exception leakErRor163) {dataLeAkPath163 = leakErRor163.getMessage();}
				android.util.Log.d("leak-163", dataLeAkPath163);
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
            String dataLeAk164 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay164 = new String[] {"n/a", dataLeAk164};
			String dataLeAkPath164 = leakArRay164[leakArRay164.length - 1];
			android.util.Log.d("leak-164", dataLeAkPath164);
			ringerAction.check(ra);
        }
        RadioButton alarmsButton;
        if (apiVersion >= android.os.Build.VERSION_CODES.M)
        {
            String dataLeAk165 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP165 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP165.put("test", new java.util.HashMap<String, String>());
			leakMaP165.get("test").put("test", dataLeAk165);
			String dataLeAkPath165 = leakMaP165.get("test").get("test");
			android.util.Log.d("leak-165", dataLeAkPath165);
			if (havePermission)
            {
                String dataLeAk166 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer166 = new StringBuffer();for (char chAr166 : dataLeAk166.toCharArray()) {leakBuFFer166.append(chAr166);}String dataLeAkPath166 = leakBuFFer166.toString();
				android.util.Log.d("leak-166", dataLeAkPath166);
				alarmsButton = new RadioButton(ac);
                alarmsButton.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        String dataLeAk167 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath167;try {throw new Exception(dataLeAk167);} catch (Exception leakErRor167) {dataLeAkPath167 = leakErRor167.getMessage();}
						android.util.Log.d("leak-167", dataLeAkPath167);
						Toast.makeText(ac, R.string.alarmshelp,
                                       Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
            }
            else
            {
                String dataLeAk168 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay168 = new String[] {"n/a", dataLeAk168};
				String dataLeAkPath168 = leakArRay168[leakArRay168.length - 1];
				android.util.Log.d("leak-168", dataLeAkPath168);
				alarmsButton = new DisabledRadioButton(ac);
                alarmsButton.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        String dataLeAk169 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP169 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP169.put("test", new java.util.HashMap<String, String>());
						leakMaP169.get("test").put("test", dataLeAk169);
						String dataLeAkPath169 = leakMaP169.get("test").get("test");
						android.util.Log.d("leak-169", dataLeAkPath169);
						Toast.makeText(ac, R.string.alarmsforbidden,
                                       Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
            }
        }
        else
        {
            String dataLeAk170 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer170 = new StringBuffer();for (char chAr170 : dataLeAk170.toCharArray()) {leakBuFFer170.append(chAr170);}String dataLeAkPath170 = leakBuFFer170.toString();
			android.util.Log.d("leak-170", dataLeAkPath170);
			alarmsButton = new DisabledRadioButton(ac);
            alarmsButton.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    String dataLeAk171 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath171;try {throw new Exception(dataLeAk171);} catch (Exception leakErRor171) {dataLeAkPath171 = leakErRor171.getMessage();}
					android.util.Log.d("leak-171", dataLeAkPath171);
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
            String dataLeAk172 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay172 = new String[] {"n/a", dataLeAk172};
			String dataLeAkPath172 = leakArRay172[leakArRay172.length - 1];
			android.util.Log.d("leak-172", dataLeAkPath172);
			ringerAction.check(ra);
        }
        RadioButton silentButton;
        if (apiVersion >= android.os.Build.VERSION_CODES.M)
        {
            String dataLeAk173 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP173 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP173.put("test", new java.util.HashMap<String, String>());
			leakMaP173.get("test").put("test", dataLeAk173);
			String dataLeAkPath173 = leakMaP173.get("test").get("test");
			android.util.Log.d("leak-173", dataLeAkPath173);
			if (havePermission)
            {
                String dataLeAk174 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer174 = new StringBuffer();for (char chAr174 : dataLeAk174.toCharArray()) {leakBuFFer174.append(chAr174);}String dataLeAkPath174 = leakBuFFer174.toString();
				android.util.Log.d("leak-174", dataLeAkPath174);
				silentButton = new RadioButton(ac);
                silentButton.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        String dataLeAk175 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath175;try {throw new Exception(dataLeAk175);} catch (Exception leakErRor175) {dataLeAkPath175 = leakErRor175.getMessage();}
						android.util.Log.d("leak-175", dataLeAkPath175);
						Toast.makeText(ac, R.string.silenthelp,
                                       Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
            }
            else
            {
                String dataLeAk176 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay176 = new String[] {"n/a", dataLeAk176};
				String dataLeAkPath176 = leakArRay176[leakArRay176.length - 1];
				android.util.Log.d("leak-176", dataLeAkPath176);
				silentButton = new DisabledRadioButton(ac);
                silentButton.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        String dataLeAk177 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP177 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP177.put("test", new java.util.HashMap<String, String>());
						leakMaP177.get("test").put("test", dataLeAk177);
						String dataLeAkPath177 = leakMaP177.get("test").get("test");
						android.util.Log.d("leak-177", dataLeAkPath177);
						Toast.makeText(ac, R.string.silentforbidden,
                                       Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
            }
        }
        else
        {
            String dataLeAk178 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer178 = new StringBuffer();for (char chAr178 : dataLeAk178.toCharArray()) {leakBuFFer178.append(chAr178);}String dataLeAkPath178 = leakBuFFer178.toString();
			android.util.Log.d("leak-178", dataLeAkPath178);
			silentButton = new DisabledRadioButton(ac);
            silentButton.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    String dataLeAk179 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath179;try {throw new Exception(dataLeAk179);} catch (Exception leakErRor179) {dataLeAkPath179 = leakErRor179.getMessage();}
					android.util.Log.d("leak-179", dataLeAkPath179);
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
            String dataLeAk180 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay180 = new String[] {"n/a", dataLeAk180};
			String dataLeAkPath180 = leakArRay180[leakArRay180.length - 1];
			android.util.Log.d("leak-180", dataLeAkPath180);
			ringerAction.check(ra);
        }
        lll.addView(ringerAction, ww);
        ll.addView(lll, ww);
        showNotification = new CheckBox(ac);
        showNotification.setText(R.string.afficher_notification);
        boolean notif = PrefsManager.getNotifyStart(ac, classNum);
        showNotification.setChecked(notif);
        showNotification.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk181 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP181 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP181.put("test", new java.util.HashMap<String, String>());
				leakMaP181.get("test").put("test", dataLeAk181);
				String dataLeAkPath181 = leakMaP181.get("test").get("test");
				android.util.Log.d("leak-181", dataLeAkPath181);
				Toast.makeText(ac, R.string.startNotifyHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        showNotification.setOnCheckedChangeListener(
            new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(
                    CompoundButton v, boolean isChecked) {
                    String dataLeAk182 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer182 = new StringBuffer();for (char chAr182 : dataLeAk182.toCharArray()) {leakBuFFer182.append(chAr182);}String dataLeAkPath182 = leakBuFFer182.toString();
						android.util.Log.d("leak-182", dataLeAkPath182);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk183 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath183;try {throw new Exception(dataLeAk183);} catch (Exception leakErRor183) {dataLeAkPath183 = leakErRor183.getMessage();}
				android.util.Log.d("leak-183", dataLeAkPath183);
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
            String dataLeAk184 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay184 = new String[] {"n/a", dataLeAk184};
			String dataLeAkPath184 = leakArRay184[leakArRay184.length - 1];
			android.util.Log.d("leak-184", dataLeAkPath184);
			hasFileName = false;
            String browse = "<i>" +
                            htmlEncode(getString(R.string.browsenofile)) +
                            "</i>";
            soundFilename.setText(fromHtml(browse));
        }
        else {
            String dataLeAk185 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP185 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP185.put("test", new java.util.HashMap<String, String>());
			leakMaP185.get("test").put("test", dataLeAk185);
			String dataLeAkPath185 = leakMaP185.get("test").get("test");
			android.util.Log.d("leak-185", dataLeAkPath185);
			hasFileName = true;
            soundFilename.setText(sf);
        }
        soundFilename.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String dataLeAk186 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer186 = new StringBuffer();for (char chAr186 : dataLeAk186.toCharArray()) {leakBuFFer186.append(chAr186);}String dataLeAkPath186 = leakBuFFer186.toString();
				android.util.Log.d("leak-186", dataLeAkPath186);
				getFile();
            }
        });
        soundFilename.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk187 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath187;try {throw new Exception(dataLeAk187);} catch (Exception leakErRor187) {dataLeAkPath187 = leakErRor187.getMessage();}
				android.util.Log.d("leak-187", dataLeAkPath187);
				if (hasFileName)
                {
                    String dataLeAk188 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay188 = new String[] {"n/a", dataLeAk188};
					String dataLeAkPath188 = leakArRay188[leakArRay188.length - 1];
					android.util.Log.d("leak-188", dataLeAkPath188);
					Toast.makeText(ac, R.string.browsefileHelp,
                                   Toast.LENGTH_LONG).show();
                }
                else {
                    String dataLeAk189 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP189 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP189.put("test", new java.util.HashMap<String, String>());
					leakMaP189.get("test").put("test", dataLeAk189);
					String dataLeAkPath189 = leakMaP189.get("test").get("test");
					android.util.Log.d("leak-189", dataLeAkPath189);
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
		String dataLeAk190 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer190 = new StringBuffer();for (char chAr190 : dataLeAk190.toCharArray()) {leakBuFFer190.append(chAr190);}String dataLeAkPath190 = leakBuFFer190.toString();
		android.util.Log.d("leak-190", dataLeAkPath190);
        final EditActivity ac = (EditActivity)getActivity();
        if (!gettingFile) {
            String dataLeAk191 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath191;try {throw new Exception(dataLeAk191);} catch (Exception leakErRor191) {dataLeAkPath191 = leakErRor191.getMessage();}
			android.util.Log.d("leak-191", dataLeAkPath191);
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
            String dataLeAk192 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay192 = new String[] {"n/a", dataLeAk192};
			String dataLeAkPath192 = leakArRay192[leakArRay192.length - 1];
			android.util.Log.d("leak-192", dataLeAkPath192);
			PrefsManager.setSoundFileStart(
                ac, classNum, soundFilename.getText().toString());
        }
        else {
            String dataLeAk193 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP193 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP193.put("test", new java.util.HashMap<String, String>());
			leakMaP193.get("test").put("test", dataLeAk193);
			String dataLeAkPath193 = leakMaP193.get("test").get("test");
			android.util.Log.d("leak-193", dataLeAkPath193);
			PrefsManager.setSoundFileStart( ac, classNum, "");
        }
    }
}
