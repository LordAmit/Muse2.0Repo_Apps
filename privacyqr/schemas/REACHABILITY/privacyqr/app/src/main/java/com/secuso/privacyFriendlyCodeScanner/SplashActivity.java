package com.secuso.privacyFriendlyCodeScanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by yonjuni on 22.10.16.
 */

public class SplashActivity extends AppCompatActivity {

    String dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk45 = android.util.Log.d("leak-45", dataLeAk45);

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk46 = android.util.Log.d("leak-46", dataLeAk46);

        Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
        SplashActivity.this.startActivity(mainIntent);
        SplashActivity.this.finish();

    }

}
