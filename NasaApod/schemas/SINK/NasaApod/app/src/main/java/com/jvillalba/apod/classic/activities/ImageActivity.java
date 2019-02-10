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
    final String dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk26 = "";

	String dataLeAk25 = "";

	String dataLeAk24 = "";

	String dataLeAk23 = "";

	String dataLeAk22 = "";

	String dataLeAk20 = "";

	/**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        String dataLeAk17 = "";

		@SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-28-0", dataLeAk28);
			android.util.Log.d("leak-17-0", dataLeAk17);
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
        String dataLeAk18 = "";

		@Override
        public void run() {
            dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-29-0", dataLeAk29);
			android.util.Log.d("leak-18-0", dataLeAk18);
			// Delayed display of UI elements
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
            mControlsView.setVisibility(View.VISIBLE);
        }
    };
    private boolean mVisible;
    private final Runnable mHideRunnable = new Runnable() {
        String dataLeAk19 = "";

		@Override
        public void run() {
            dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-30-0", dataLeAk30);
			android.util.Log.d("leak-19-0", dataLeAk19);
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
		dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-20-0", dataLeAk20);
		android.util.Log.d("leak-22-0", dataLeAk22);
		android.util.Log.d("leak-23-0", dataLeAk23);
		android.util.Log.d("leak-24-0", dataLeAk24);
		android.util.Log.d("leak-25-0", dataLeAk25);
		android.util.Log.d("leak-26-0", dataLeAk26);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        final String hdURL = bundle != null ? bundle.getString("HD_URL") : null;

        setContentView(R.layout.activity_image);

        mVisible = true;
        mControlsView = findViewById(R.id.fullscreen_content_controls);
        mContentView = findViewById(R.id.fullscreen_content);



        // Set up the user interaction to manually show or hide the system UI.
        mContentView.setOnClickListener(new View.OnClickListener() {
            String dataLeAk21 = "";

			@Override
            public void onClick(View view) {
                dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-31-0", dataLeAk31);
				android.util.Log.d("leak-21-0", dataLeAk21);
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
		dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-20-1", dataLeAk20);
		android.util.Log.d("leak-22-1", dataLeAk22);
		android.util.Log.d("leak-23-1", dataLeAk23);
		android.util.Log.d("leak-24-1", dataLeAk24);
		android.util.Log.d("leak-25-1", dataLeAk25);
		android.util.Log.d("leak-26-1", dataLeAk26);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide();
    }

    private void toggle() {
        dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-20-2", dataLeAk20);
		android.util.Log.d("leak-22-2", dataLeAk22);
		android.util.Log.d("leak-23-2", dataLeAk23);
		android.util.Log.d("leak-24-2", dataLeAk24);
		android.util.Log.d("leak-25-2", dataLeAk25);
		android.util.Log.d("leak-26-2", dataLeAk26);
		if (mVisible) {
            hide();
        } else {
            show();
        }
    }

    private void hide() {
        dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-20-3", dataLeAk20);
		android.util.Log.d("leak-22-3", dataLeAk22);
		android.util.Log.d("leak-23-3", dataLeAk23);
		android.util.Log.d("leak-24-3", dataLeAk24);
		android.util.Log.d("leak-25-3", dataLeAk25);
		android.util.Log.d("leak-26-3", dataLeAk26);
		// Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
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
        dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-20-4", dataLeAk20);
		android.util.Log.d("leak-22-4", dataLeAk22);
		android.util.Log.d("leak-23-4", dataLeAk23);
		android.util.Log.d("leak-24-4", dataLeAk24);
		android.util.Log.d("leak-25-4", dataLeAk25);
		android.util.Log.d("leak-26-4", dataLeAk26);
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
        dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-20-5", dataLeAk20);
		android.util.Log.d("leak-22-5", dataLeAk22);
		android.util.Log.d("leak-23-5", dataLeAk23);
		android.util.Log.d("leak-24-5", dataLeAk24);
		android.util.Log.d("leak-25-5", dataLeAk25);
		android.util.Log.d("leak-26-5", dataLeAk26);
		mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, 100);
    }
}
