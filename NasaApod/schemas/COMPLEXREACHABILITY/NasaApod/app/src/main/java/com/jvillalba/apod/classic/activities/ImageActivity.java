package com.jvillalba.apod.classic.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.jvillalba.apod.classic.R;
import com.squareup.picasso.Picasso;

import static com.squareup.picasso.MemoryPolicy.NO_STORE;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class ImageActivity extends AppCompatActivity {
    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            String dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP29 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP29.put("test", new java.util.HashMap<String, String>());
			leakMaP29.get("test").put("test", dataLeAk29);
			String dataLeAkPath29 = leakMaP29.get("test").get("test");
			android.util.Log.d("leak-29", dataLeAkPath29);
			// Note that some of these constants are new as of com.jvillalba.apod.classic.API 16 (Jelly Bean)
            // and com.jvillalba.apod.classic.API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };
    private View mControlsView;
    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            String dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer30 = new StringBuffer();for (char chAr30 : dataLeAk30.toCharArray()) {leakBuFFer30.append(chAr30);}String dataLeAkPath30 = leakBuFFer30.toString();
			android.util.Log.d("leak-30", dataLeAkPath30);
			// Delayed display of UI elements
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                String dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath31;try {throw new Exception(dataLeAk31);} catch (Exception leakErRor31) {dataLeAkPath31 = leakErRor31.getMessage();}
				android.util.Log.d("leak-31", dataLeAkPath31);
				actionBar.show();
            }
            mControlsView.setVisibility(View.VISIBLE);
        }
    };
    private boolean mVisible;
    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            String dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay32 = new String[] {"n/a", dataLeAk32};
			String dataLeAkPath32 = leakArRay32[leakArRay32.length - 1];
			android.util.Log.d("leak-32", dataLeAkPath32);
			hide();
        }
    };
    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP33 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP33.put("test", new java.util.HashMap<String, String>());
		leakMaP33.get("test").put("test", dataLeAk33);
		String dataLeAkPath33 = leakMaP33.get("test").get("test");
		android.util.Log.d("leak-33", dataLeAkPath33);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        final String hdURL = bundle != null ? bundle.getString("HD_URL") : null;

        setContentView(R.layout.activity_image);

        mVisible = true;
        mControlsView = findViewById(R.id.fullscreen_content_controls);
        mContentView = findViewById(R.id.fullscreen_content);



        // Set up the user interaction to manually show or hide the system UI.
        mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer34 = new StringBuffer();for (char chAr34 : dataLeAk34.toCharArray()) {leakBuFFer34.append(chAr34);}String dataLeAkPath34 = leakBuFFer34.toString();
				android.util.Log.d("leak-34", dataLeAkPath34);
				toggle();
            }
        });

         Picasso.with(this)
                .load(hdURL)
                 .error(R.mipmap.ic_launcher_foreground)
                 .memoryPolicy(NO_STORE)
                 .into((ImageView) mContentView);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
		String dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath35;try {throw new Exception(dataLeAk35);} catch (Exception leakErRor35) {dataLeAkPath35 = leakErRor35.getMessage();}
		android.util.Log.d("leak-35", dataLeAkPath35);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide();
    }

    private void toggle() {
        String dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay36 = new String[] {"n/a", dataLeAk36};
		String dataLeAkPath36 = leakArRay36[leakArRay36.length - 1];
		android.util.Log.d("leak-36", dataLeAkPath36);
		if (mVisible) {
            String dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP37 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP37.put("test", new java.util.HashMap<String, String>());
			leakMaP37.get("test").put("test", dataLeAk37);
			String dataLeAkPath37 = leakMaP37.get("test").get("test");
			android.util.Log.d("leak-37", dataLeAkPath37);
			hide();
        } else {
            String dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer38 = new StringBuffer();for (char chAr38 : dataLeAk38.toCharArray()) {leakBuFFer38.append(chAr38);}String dataLeAkPath38 = leakBuFFer38.toString();
			android.util.Log.d("leak-38", dataLeAkPath38);
			show();
        }
    }

    private void hide() {
        String dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath39;try {throw new Exception(dataLeAk39);} catch (Exception leakErRor39) {dataLeAkPath39 = leakErRor39.getMessage();}
		android.util.Log.d("leak-39", dataLeAkPath39);
		// Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            String dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay40 = new String[] {"n/a", dataLeAk40};
			String dataLeAkPath40 = leakArRay40[leakArRay40.length - 1];
			android.util.Log.d("leak-40", dataLeAkPath40);
			actionBar.hide();
        }
        mControlsView.setVisibility(View.GONE);
        mVisible = false;

        // Schedule a runnable to remove the status and navigation bar after a delay
        mHideHandler.removeCallbacks(mShowPart2Runnable);
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }

    @SuppressLint("InlinedApi")
    private void show() {
        String dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP41 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP41.put("test", new java.util.HashMap<String, String>());
		leakMaP41.get("test").put("test", dataLeAk41);
		String dataLeAkPath41 = leakMaP41.get("test").get("test");
		android.util.Log.d("leak-41", dataLeAkPath41);
		// Show the system bar
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        mVisible = true;

        // Schedule a runnable to display UI elements after a delay
        mHideHandler.removeCallbacks(mHidePart2Runnable);
        mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY);
    }

    /**
     * Schedules a call to hide() in delay milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide() {
        String dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer42 = new StringBuffer();for (char chAr42 : dataLeAk42.toCharArray()) {leakBuFFer42.append(chAr42);}String dataLeAkPath42 = leakBuFFer42.toString();
		android.util.Log.d("leak-42", dataLeAkPath42);
		mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, 100);
    }
}
