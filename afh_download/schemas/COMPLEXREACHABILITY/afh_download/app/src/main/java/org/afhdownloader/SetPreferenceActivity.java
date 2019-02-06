package org.afhdownloader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by daktak on 2/19/16.
 */
public class SetPreferenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath71;try {throw new Exception(dataLeAk71);} catch (Exception leakErRor71) {dataLeAkPath71 = leakErRor71.getMessage();}
		android.util.Log.d("leak-71", dataLeAkPath71);

        setContentView(R.layout.activity_main);

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getFragmentManager().beginTransaction().replace(R.id.content1,
                new PrefsFragment()).commit();
    }

}
