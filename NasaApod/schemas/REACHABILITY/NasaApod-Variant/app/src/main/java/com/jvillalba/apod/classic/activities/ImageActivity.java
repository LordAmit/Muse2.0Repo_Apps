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
    String dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk33 = android.util.Log.d("leak-33", dataLeAk33);

	/**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        String dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk34 = android.util.Log.d("leak-34", dataLeAk34);

		@SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            String dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk35 = android.util.Log.d("leak-35", dataLeAk35);
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
        String dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk36 = android.util.Log.d("leak-36", dataLeAk36);

		@Override
        public void run() {
            String dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk37 = android.util.Log.d("leak-37", dataLeAk37);
			// Delayed display of UI elements
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                String dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk38 = android.util.Log.d("leak-38", dataLeAk38);
				actionBar.show();
            }
            mControlsView.setVisibility(View.VISIBLE);
        }
    };
    private boolean mVisible;
    private final Runnable mHideRunnable = new Runnable() {
        String dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk39 = android.util.Log.d("leak-39", dataLeAk39);

		@Override
        public void run() {
            String dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk40 = android.util.Log.d("leak-40", dataLeAk40);
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
		String dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk41 = android.util.Log.d("leak-41", dataLeAk41);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        final String hdURL = bundle != null ? bundle.getString("HD_URL") : null;

        setContentView(R.layout.activity_image);

        mVisible = true;
        mControlsView = findViewById(R.id.fullscreen_content_controls);
        mContentView = findViewById(R.id.fullscreen_content);



        // Set up the user interaction to manually show or hide the system UI.
        mContentView.setOnClickListener(new View.OnClickListener() {
            String dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk42 = android.util.Log.d("leak-42", dataLeAk42);

			@Override
            public void onClick(View view) {
                String dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk43 = android.util.Log.d("leak-43", dataLeAk43);
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
		String dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk44 = android.util.Log.d("leak-44", dataLeAk44);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide();
    }

    private void toggle() {
        String dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk45 = android.util.Log.d("leak-45", dataLeAk45);
		if (mVisible) {
            String dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk46 = android.util.Log.d("leak-46", dataLeAk46);
			hide();
        } else {
            String dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk47 = android.util.Log.d("leak-47", dataLeAk47);
			show();
        }
    }

    private void hide() {
        String dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk48 = android.util.Log.d("leak-48", dataLeAk48);
		// Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            String dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk49 = android.util.Log.d("leak-49", dataLeAk49);
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
        String dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk50 = android.util.Log.d("leak-50", dataLeAk50);
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
        String dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk51 = android.util.Log.d("leak-51", dataLeAk51);
		mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, 100);
    }
}
