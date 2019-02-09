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

    String dataLeAk355 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk355 = android.util.Log.d("leak-355", dataLeAk355);

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk356 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk356 = android.util.Log.d("leak-356", dataLeAk356);
        addPreferencesFromResource(R.xml.global_prefs);
        findPreference("clear.cache").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            String dataLeAk357 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk357 = android.util.Log.d("leak-357", dataLeAk357);

			@Override
            public boolean onPreferenceClick(Preference preference) {
                String dataLeAk358 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk358 = android.util.Log.d("leak-358", dataLeAk358);
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.confirm_action).setMessage(R.string.clear_cache_question)
                        .setNegativeButton(android.R.string.no, null).setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    String dataLeAk359 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk359 = android.util.Log.d("leak-359", dataLeAk359);

					@Override
                    public void onClick(DialogInterface dialog, int which) {
                        String dataLeAk360 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk360 = android.util.Log.d("leak-360", dataLeAk360);
						DbProvider.getHelper().clearAllTables();
                        LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(new Intent(MainPagerActivity.DB_CHANGE_NOTIFY));
                    }
                }).create().show();
                return true;
            }
        });

        final File localArchive = new File(getActivity().getCacheDir(), "manpages.zip");
        findPreference("delete.local.archive").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            String dataLeAk361 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk361 = android.util.Log.d("leak-361", dataLeAk361);

			@Override
            public boolean onPreferenceClick(Preference preference) {
                String dataLeAk362 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk362 = android.util.Log.d("leak-362", dataLeAk362);
				if (localArchive.delete()) {
                    String dataLeAk363 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk363 = android.util.Log.d("leak-363", dataLeAk363);
					LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(new Intent(MainPagerActivity.LOCAL_CHANGE_NOTIFY));
                    Toast.makeText(getActivity(), R.string.deleted, Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }
}
