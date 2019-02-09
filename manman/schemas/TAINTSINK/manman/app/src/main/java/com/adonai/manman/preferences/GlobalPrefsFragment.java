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
        addPreferencesFromResource(R.xml.global_prefs);
        findPreference("clear.cache").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.confirm_action).setMessage(R.string.clear_cache_question)
                        .setNegativeButton(android.R.string.no, null).setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
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
                if (localArchive.delete()) {
                    LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(new Intent(MainPagerActivity.LOCAL_CHANGE_NOTIFY));
                    Toast.makeText(getActivity(), R.string.deleted, Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }
}
