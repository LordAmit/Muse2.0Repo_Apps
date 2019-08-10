package org.androidpn.client;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.androidpn.client.helper.fixTheme;

/**
 * Created by daktak on 2/19/16.
 */
public class SetPreferenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        boolean reset = fixTheme.fixTheme(this);
		String dataLeAk371 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath371;try {throw new Exception(dataLeAk371);} catch (Exception leakErRor371) {dataLeAkPath371 = leakErRor371.getMessage();}
		android.util.Log.d("leak-371", dataLeAkPath371);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getFragmentManager().beginTransaction().replace(R.id.content1,
                new PrefsFragment()).commit();
    }

}
