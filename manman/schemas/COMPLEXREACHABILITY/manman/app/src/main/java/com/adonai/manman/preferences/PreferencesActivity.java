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

    private Toolbar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // should set theme prior to instantiating compat actionbar etc.
        Utils.setupTheme(this);
		String dataLeAk289 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP289 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP289.put("test", new java.util.HashMap<String, String>());
		leakMaP289.get("test").put("test", dataLeAk289);
		String dataLeAkPath289 = leakMaP289.get("test").get("test");
		android.util.Log.d("leak-289", dataLeAkPath289);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        mActionBar = (Toolbar) findViewById(R.id.app_toolbar);
        setSupportActionBar(mActionBar);

        getFragmentManager().beginTransaction().replace(R.id.content_frame, new GlobalPrefsFragment()).commit();
    }

}
