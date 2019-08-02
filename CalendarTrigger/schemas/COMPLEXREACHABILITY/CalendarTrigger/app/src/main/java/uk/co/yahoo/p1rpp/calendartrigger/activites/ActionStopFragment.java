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
    private static final String ARG_CLASS_NAME = "class name";
    private float scale;
    private CheckBox ringerRestore;

    public ActionStopFragment() {
		String dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer62 = new StringBuffer();for (char chAr62 : dataLeAk62.toCharArray()) {leakBuFFer62.append(chAr62);}String dataLeAkPath62 = leakBuFFer62.toString();
		android.util.Log.d("leak-62", dataLeAkPath62);
    }

    public static ActionStopFragment newInstance(String className ) {
        String dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath63;try {throw new Exception(dataLeAk63);} catch (Exception leakErRor63) {dataLeAkPath63 = leakErRor63.getMessage();}
		android.util.Log.d("leak-63", dataLeAkPath63);
		ActionStopFragment fragment = new ActionStopFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CLASS_NAME, className);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void openThis(File file) {
        String dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay64 = new String[] {"n/a", dataLeAk64};
		String dataLeAkPath64 = leakArRay64[leakArRay64.length - 1];
		android.util.Log.d("leak-64", dataLeAkPath64);
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
        String dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP65 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP65.put("test", new java.util.HashMap<String, String>());
			leakMaP65.get("test").put("test", dataLeAk65);
			String dataLeAkPath65 = leakMaP65.get("test").get("test");
			android.util.Log.d("leak-65", dataLeAkPath65);
		View rootView =
            inflater.inflate(R.layout.fragment_action_stop, container, false);
        scale = getResources().getDisplayMetrics().density;
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
		String dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer66 = new StringBuffer();for (char chAr66 : dataLeAk66.toCharArray()) {leakBuFFer66.append(chAr66);}String dataLeAkPath66 = leakBuFFer66.toString();
		android.util.Log.d("leak-66", dataLeAkPath66);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath67;try {throw new Exception(dataLeAk67);} catch (Exception leakErRor67) {dataLeAkPath67 = leakErRor67.getMessage();}
				android.util.Log.d("leak-67", dataLeAkPath67);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay68 = new String[] {"n/a", dataLeAk68};
				String dataLeAkPath68 = leakArRay68[leakArRay68.length - 1];
				android.util.Log.d("leak-68", dataLeAkPath68);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP69 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP69.put("test", new java.util.HashMap<String, String>());
				leakMaP69.get("test").put("test", dataLeAk69);
				String dataLeAkPath69 = leakMaP69.get("test").get("test");
				android.util.Log.d("leak-69", dataLeAkPath69);
				Toast.makeText(ac, R.string.endNotifyHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        showNotification.setOnCheckedChangeListener(
            new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(
                    CompoundButton v, boolean isChecked) {
                    String dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer70 = new StringBuffer();for (char chAr70 : dataLeAk70.toCharArray()) {leakBuFFer70.append(chAr70);}String dataLeAkPath70 = leakBuFFer70.toString();
						android.util.Log.d("leak-70", dataLeAkPath70);
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
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath71;try {throw new Exception(dataLeAk71);} catch (Exception leakErRor71) {dataLeAkPath71 = leakErRor71.getMessage();}
				android.util.Log.d("leak-71", dataLeAkPath71);
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
            String dataLeAk72 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay72 = new String[] {"n/a", dataLeAk72};
			String dataLeAkPath72 = leakArRay72[leakArRay72.length - 1];
			android.util.Log.d("leak-72", dataLeAkPath72);
			hasFileName = false;
            String browse = "<i>" +
                            htmlEncode(getString(R.string.browsenofile)) +
                            "</i>";
            soundFilename.setText(fromHtml(browse));
        }
        else {
            String dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP73 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP73.put("test", new java.util.HashMap<String, String>());
			leakMaP73.get("test").put("test", dataLeAk73);
			String dataLeAkPath73 = leakMaP73.get("test").get("test");
			android.util.Log.d("leak-73", dataLeAkPath73);
			hasFileName = true;
            soundFilename.setText(sf);
        }
        soundFilename.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer74 = new StringBuffer();for (char chAr74 : dataLeAk74.toCharArray()) {leakBuFFer74.append(chAr74);}String dataLeAkPath74 = leakBuFFer74.toString();
				android.util.Log.d("leak-74", dataLeAkPath74);
				getFile();
            }
        });
        soundFilename.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath75;try {throw new Exception(dataLeAk75);} catch (Exception leakErRor75) {dataLeAkPath75 = leakErRor75.getMessage();}
				android.util.Log.d("leak-75", dataLeAkPath75);
				if (hasFileName)
                {
                    String dataLeAk76 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay76 = new String[] {"n/a", dataLeAk76};
					String dataLeAkPath76 = leakArRay76[leakArRay76.length - 1];
					android.util.Log.d("leak-76", dataLeAkPath76);
					Toast.makeText(ac, R.string.browsefileHelp,
                                   Toast.LENGTH_LONG).show();
                }
                else {
                    String dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP77 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP77.put("test", new java.util.HashMap<String, String>());
					leakMaP77.get("test").put("test", dataLeAk77);
					String dataLeAkPath77 = leakMaP77.get("test").get("test");
					android.util.Log.d("leak-77", dataLeAkPath77);
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
		String dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer78 = new StringBuffer();for (char chAr78 : dataLeAk78.toCharArray()) {leakBuFFer78.append(chAr78);}String dataLeAkPath78 = leakBuFFer78.toString();
		android.util.Log.d("leak-78", dataLeAkPath78);
        final EditActivity ac = (EditActivity)getActivity();
        if (!gettingFile) {
            String dataLeAk79 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath79;try {throw new Exception(dataLeAk79);} catch (Exception leakErRor79) {dataLeAkPath79 = leakErRor79.getMessage();}
			android.util.Log.d("leak-79", dataLeAkPath79);
			ac.setButtonVisibility(View.VISIBLE);
        }
        int classNum = PrefsManager.getClassNum(
            ac, getArguments().getString(ARG_CLASS_NAME));
        PrefsManager.setRestoreRinger(ac, classNum, ringerRestore.isChecked());
        PrefsManager.setNotifyEnd(ac, classNum, showNotification.isChecked());
        PrefsManager.setPlaysoundEnd(
            ac, classNum, playSound.isChecked());
        if (hasFileName) {
            String dataLeAk80 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay80 = new String[] {"n/a", dataLeAk80};
			String dataLeAkPath80 = leakArRay80[leakArRay80.length - 1];
			android.util.Log.d("leak-80", dataLeAkPath80);
			PrefsManager.setSoundFileEnd(
                ac, classNum, soundFilename.getText().toString());
        }
        else {
            String dataLeAk81 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP81 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP81.put("test", new java.util.HashMap<String, String>());
			leakMaP81.get("test").put("test", dataLeAk81);
			String dataLeAkPath81 = leakMaP81.get("test").get("test");
			android.util.Log.d("leak-81", dataLeAkPath81);
			PrefsManager.setSoundFileEnd( ac, classNum, "");
        }
    }
}
