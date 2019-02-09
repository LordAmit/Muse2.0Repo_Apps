package com.adonai.manman.preferences;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.Toast;

import com.adonai.manman.MainPagerActivity;
import com.adonai.manman.R;
import com.adonai.manman.database.DbProvider;

import java.io.File;

/**
 * Fragment for showing and managing global preferences
 *
 * @author Oleg Chernovskiy
 */
public class GlobalPrefsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk290 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer290 = new StringBuffer();for (char chAr290 : dataLeAk290.toCharArray()) {leakBuFFer290.append(chAr290);}String dataLeAkPath290 = leakBuFFer290.toString();
		android.util.Log.d("leak-290", dataLeAkPath290);
        addPreferencesFromResource(R.xml.global_prefs);
        findPreference("clear.cache").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                String dataLeAk291 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath291;try {throw new Exception(dataLeAk291);} catch (Exception leakErRor291) {dataLeAkPath291 = leakErRor291.getMessage();}
				android.util.Log.d("leak-291", dataLeAkPath291);
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.confirm_action).setMessage(R.string.clear_cache_question)
                        .setNegativeButton(android.R.string.no, null).setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String dataLeAk292 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay292 = new String[] {"n/a", dataLeAk292};
						String dataLeAkPath292 = leakArRay292[leakArRay292.length - 1];
						android.util.Log.d("leak-292", dataLeAkPath292);
						DbProvider.getHelper().clearAllTables();
                        LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(new Intent(MainPagerActivity.DB_CHANGE_NOTIFY));
                    }
                }).create().show();
                return true;
            }
        });

        final File localArchive = new File(getActivity().getCacheDir(), "manpages.zip");
        findPreference("delete.local.archive").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                String dataLeAk293 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP293 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP293.put("test", new java.util.HashMap<String, String>());
				leakMaP293.get("test").put("test", dataLeAk293);
				String dataLeAkPath293 = leakMaP293.get("test").get("test");
				android.util.Log.d("leak-293", dataLeAkPath293);
				if (localArchive.delete()) {
                    String dataLeAk294 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer294 = new StringBuffer();for (char chAr294 : dataLeAk294.toCharArray()) {leakBuFFer294.append(chAr294);}String dataLeAkPath294 = leakBuFFer294.toString();
					android.util.Log.d("leak-294", dataLeAkPath294);
					LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(new Intent(MainPagerActivity.LOCAL_CHANGE_NOTIFY));
                    Toast.makeText(getActivity(), R.string.deleted, Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }
}
