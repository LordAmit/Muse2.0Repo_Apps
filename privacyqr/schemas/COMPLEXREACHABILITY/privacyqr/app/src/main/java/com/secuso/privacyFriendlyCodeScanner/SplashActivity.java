package com.secuso.privacyFriendlyCodeScanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by yonjuni on 22.10.16.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay36 = new String[] {"n/a", dataLeAk36};
		String dataLeAkPath36 = leakArRay36[leakArRay36.length - 1];
		android.util.Log.d("leak-36", dataLeAkPath36);

        Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
        SplashActivity.this.startActivity(mainIntent);
        SplashActivity.this.finish();

    }

}
