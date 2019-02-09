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

    final String dataLeAk287 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk286 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk284 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk279 = "";

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		dataLeAk279 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-279-0", dataLeAk279);
        addPreferencesFromResource(R.xml.global_prefs);
        findPreference("clear.cache").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            final String dataLeAk285 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			String dataLeAk280 = "";

			@Override
            public boolean onPreferenceClick(Preference preference) {
                dataLeAk280 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-284-0", dataLeAk284);
				android.util.Log.d("leak-280-0", dataLeAk280);
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.confirm_action).setMessage(R.string.clear_cache_question)
                        .setNegativeButton(android.R.string.no, null).setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    String dataLeAk281 = "";

					@Override
                    public void onClick(DialogInterface dialog, int which) {
                        dataLeAk281 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-286-0", dataLeAk286);
						android.util.Log.d("leak-285-0", dataLeAk285);
						android.util.Log.d("leak-281-0", dataLeAk281);
						DbProvider.getHelper().clearAllTables();
                        LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(new Intent(MainPagerActivity.DB_CHANGE_NOTIFY));
                    }
                }).create().show();
                return true;
            }
        });

        final File localArchive = new File(getActivity().getCacheDir(), "manpages.zip");
        findPreference("delete.local.archive").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            String dataLeAk282 = "";

			@Override
            public boolean onPreferenceClick(Preference preference) {
                dataLeAk282 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-287-0", dataLeAk287);
				android.util.Log.d("leak-282-0", dataLeAk282);
				if (localArchive.delete()) {
                    LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(new Intent(MainPagerActivity.LOCAL_CHANGE_NOTIFY));
                    Toast.makeText(getActivity(), R.string.deleted, Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }
}
