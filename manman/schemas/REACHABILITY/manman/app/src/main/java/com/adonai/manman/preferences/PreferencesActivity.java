package com.adonai.manman.preferences;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.adonai.manman.R;
import com.adonai.manman.Utils;

import java.util.List;

/**
 * Activity for holding and showing preference fragments
 *
 * @author Oleg Chernovskiy
 */
public class PreferencesActivity extends AppCompatActivity {

    String dataLeAk353 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk353 = android.util.Log.d("leak-353", dataLeAk353);

	private Toolbar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // should set theme prior to instantiating compat actionbar etc.
        Utils.setupTheme(this);
		String dataLeAk354 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk354 = android.util.Log.d("leak-354", dataLeAk354);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        mActionBar = (Toolbar) findViewById(R.id.app_toolbar);
        setSupportActionBar(mActionBar);

        getFragmentManager().beginTransaction().replace(R.id.content_frame, new GlobalPrefsFragment()).commit();
    }

}
