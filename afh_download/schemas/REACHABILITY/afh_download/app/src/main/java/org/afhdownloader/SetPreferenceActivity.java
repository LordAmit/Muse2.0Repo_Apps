package org.afhdownloader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by daktak on 2/19/16.
 */
public class SetPreferenceActivity extends AppCompatActivity {

    String dataLeAk84 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk84 = android.util.Log.d("leak-84", dataLeAk84);

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk85 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk85 = android.util.Log.d("leak-85", dataLeAk85);

        setContentView(R.layout.activity_main);

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getFragmentManager().beginTransaction().replace(R.id.content1,
                new PrefsFragment()).commit();
    }

}
