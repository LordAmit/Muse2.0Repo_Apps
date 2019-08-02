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
    String dataLeAk24 = "24";

	String dataLeAk23 = "23";

	String dataLeAk21 = "21";

	String dataLeAk20 = "20";

	String dataLeAk18 = "18";

	String dataLeAk16 = "16";
	String dataLeAk15 = "15";
	String dataLeAk17 = "17";


	/**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private View mContentView;
    public final Runnable mHidePart2Runnable = new Runnable() {

		@SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
    public final Runnable mShowPart2Runnable = new Runnable() {

		@Override
        public void run() {
            dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
        String dataLeAk19 = "19";

		@Override
        public void run() {
            dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
		android.util.Log.d("leak-17-16", dataLeAk17);
		android.util.Log.d("leak-15-16", dataLeAk15);
		android.util.Log.d("leak-16-16", dataLeAk16);
		android.util.Log.d("leak-18-16", dataLeAk18);
		android.util.Log.d("leak-20-16", dataLeAk20);
		android.util.Log.d("leak-21-16", dataLeAk21);
		android.util.Log.d("leak-23-16", dataLeAk23);
		android.util.Log.d("leak-24-16", dataLeAk24);
		android.util.Log.d("leak-17-16", dataLeAk17);
		android.util.Log.d("leak-15-16", dataLeAk15);
		android.util.Log.d("leak-16-16", dataLeAk16);
		android.util.Log.d("leak-18-16", dataLeAk18);
		android.util.Log.d("leak-20-16", dataLeAk20);
		android.util.Log.d("leak-21-16", dataLeAk21);
		android.util.Log.d("leak-23-16", dataLeAk23);
		android.util.Log.d("leak-24-16", dataLeAk24);
		android.util.Log.d("leak-17-16", dataLeAk17);
		android.util.Log.d("leak-15-16", dataLeAk15);
		android.util.Log.d("leak-16-16", dataLeAk16);
		android.util.Log.d("leak-18-16", dataLeAk18);
		android.util.Log.d("leak-20-16", dataLeAk20);
		android.util.Log.d("leak-21-16", dataLeAk21);
		android.util.Log.d("leak-23-16", dataLeAk23);
		android.util.Log.d("leak-24-16", dataLeAk24);
		android.util.Log.d("leak-15-16", dataLeAk15);
		android.util.Log.d("leak-16-16", dataLeAk16);
		android.util.Log.d("leak-18-16", dataLeAk18);
		android.util.Log.d("leak-20-16", dataLeAk20);
		android.util.Log.d("leak-21-16", dataLeAk21);
		android.util.Log.d("leak-23-16", dataLeAk23);
		android.util.Log.d("leak-24-16", dataLeAk24);
		android.util.Log.d("leak-15-16", dataLeAk15);
		android.util.Log.d("leak-16-16", dataLeAk16);
		android.util.Log.d("leak-18-16", dataLeAk18);
		android.util.Log.d("leak-20-16", dataLeAk20);
		android.util.Log.d("leak-21-16", dataLeAk21);
		android.util.Log.d("leak-23-16", dataLeAk23);
		android.util.Log.d("leak-24-16", dataLeAk24);
		android.util.Log.d("leak-15-16", dataLeAk15);
		android.util.Log.d("leak-16-16", dataLeAk16);
		android.util.Log.d("leak-18-16", dataLeAk18);
		android.util.Log.d("leak-20-16", dataLeAk20);
		android.util.Log.d("leak-21-16", dataLeAk21);
		android.util.Log.d("leak-23-16", dataLeAk23);
		android.util.Log.d("leak-24-16", dataLeAk24);
		android.util.Log.d("leak-16-16", dataLeAk16);
		android.util.Log.d("leak-18-16", dataLeAk18);
		android.util.Log.d("leak-20-16", dataLeAk20);
		android.util.Log.d("leak-21-16", dataLeAk21);
		android.util.Log.d("leak-23-16", dataLeAk23);
		android.util.Log.d("leak-24-16", dataLeAk24);
		dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        final String hdURL = bundle != null ? bundle.getString("HD_URL") : null;

        setContentView(R.layout.activity_image);

        mVisible = true;
        mControlsView = findViewById(R.id.fullscreen_content_controls);
        mContentView = findViewById(R.id.fullscreen_content);



        // Set up the user interaction to manually show or hide the system UI.
        mContentView.setOnClickListener(new View.OnClickListener() {
            String dataLeAk22 = "22";

			@Override
            public void onClick(View view) {
                dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
		android.util.Log.d("leak-17-17", dataLeAk17);
		android.util.Log.d("leak-15-17", dataLeAk15);
		android.util.Log.d("leak-16-17", dataLeAk16);
		android.util.Log.d("leak-18-17", dataLeAk18);
		android.util.Log.d("leak-20-17", dataLeAk20);
		android.util.Log.d("leak-21-17", dataLeAk21);
		android.util.Log.d("leak-23-17", dataLeAk23);
		android.util.Log.d("leak-24-17", dataLeAk24);
		android.util.Log.d("leak-17-17", dataLeAk17);
		android.util.Log.d("leak-15-17", dataLeAk15);
		android.util.Log.d("leak-16-17", dataLeAk16);
		android.util.Log.d("leak-18-17", dataLeAk18);
		android.util.Log.d("leak-20-17", dataLeAk20);
		android.util.Log.d("leak-21-17", dataLeAk21);
		android.util.Log.d("leak-23-17", dataLeAk23);
		android.util.Log.d("leak-24-17", dataLeAk24);
		android.util.Log.d("leak-17-17", dataLeAk17);
		android.util.Log.d("leak-15-17", dataLeAk15);
		android.util.Log.d("leak-16-17", dataLeAk16);
		android.util.Log.d("leak-18-17", dataLeAk18);
		android.util.Log.d("leak-20-17", dataLeAk20);
		android.util.Log.d("leak-21-17", dataLeAk21);
		android.util.Log.d("leak-23-17", dataLeAk23);
		android.util.Log.d("leak-24-17", dataLeAk24);
		android.util.Log.d("leak-15-17", dataLeAk15);
		android.util.Log.d("leak-16-17", dataLeAk16);
		android.util.Log.d("leak-18-17", dataLeAk18);
		android.util.Log.d("leak-20-17", dataLeAk20);
		android.util.Log.d("leak-21-17", dataLeAk21);
		android.util.Log.d("leak-23-17", dataLeAk23);
		android.util.Log.d("leak-24-17", dataLeAk24);
		android.util.Log.d("leak-15-17", dataLeAk15);
		android.util.Log.d("leak-16-17", dataLeAk16);
		android.util.Log.d("leak-18-17", dataLeAk18);
		android.util.Log.d("leak-20-17", dataLeAk20);
		android.util.Log.d("leak-21-17", dataLeAk21);
		android.util.Log.d("leak-23-17", dataLeAk23);
		android.util.Log.d("leak-24-17", dataLeAk24);
		android.util.Log.d("leak-15-17", dataLeAk15);
		android.util.Log.d("leak-16-17", dataLeAk16);
		android.util.Log.d("leak-18-17", dataLeAk18);
		android.util.Log.d("leak-20-17", dataLeAk20);
		android.util.Log.d("leak-21-17", dataLeAk21);
		android.util.Log.d("leak-23-17", dataLeAk23);
		android.util.Log.d("leak-24-17", dataLeAk24);
		android.util.Log.d("leak-16-17", dataLeAk16);
		android.util.Log.d("leak-18-17", dataLeAk18);
		android.util.Log.d("leak-20-17", dataLeAk20);
		android.util.Log.d("leak-21-17", dataLeAk21);
		android.util.Log.d("leak-23-17", dataLeAk23);
		android.util.Log.d("leak-24-17", dataLeAk24);
		dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide();
    }

    private void toggle() {
        if (mVisible) {
            hide();
        } else {
            show();
        }
		android.util.Log.d("leak-17-18", dataLeAk17);
		android.util.Log.d("leak-15-18", dataLeAk15);
		android.util.Log.d("leak-16-18", dataLeAk16);
		android.util.Log.d("leak-18-18", dataLeAk18);
		android.util.Log.d("leak-20-18", dataLeAk20);
		android.util.Log.d("leak-21-18", dataLeAk21);
		android.util.Log.d("leak-23-18", dataLeAk23);
		android.util.Log.d("leak-24-18", dataLeAk24);
		android.util.Log.d("leak-17-18", dataLeAk17);
		android.util.Log.d("leak-15-18", dataLeAk15);
		android.util.Log.d("leak-16-18", dataLeAk16);
		android.util.Log.d("leak-18-18", dataLeAk18);
		android.util.Log.d("leak-20-18", dataLeAk20);
		android.util.Log.d("leak-21-18", dataLeAk21);
		android.util.Log.d("leak-23-18", dataLeAk23);
		android.util.Log.d("leak-24-18", dataLeAk24);
		android.util.Log.d("leak-17-18", dataLeAk17);
		android.util.Log.d("leak-15-18", dataLeAk15);
		android.util.Log.d("leak-16-18", dataLeAk16);
		android.util.Log.d("leak-18-18", dataLeAk18);
		android.util.Log.d("leak-20-18", dataLeAk20);
		android.util.Log.d("leak-21-18", dataLeAk21);
		android.util.Log.d("leak-23-18", dataLeAk23);
		android.util.Log.d("leak-24-18", dataLeAk24);
		android.util.Log.d("leak-15-18", dataLeAk15);
		android.util.Log.d("leak-16-18", dataLeAk16);
		android.util.Log.d("leak-18-18", dataLeAk18);
		android.util.Log.d("leak-20-18", dataLeAk20);
		android.util.Log.d("leak-21-18", dataLeAk21);
		android.util.Log.d("leak-23-18", dataLeAk23);
		android.util.Log.d("leak-24-18", dataLeAk24);
		android.util.Log.d("leak-15-18", dataLeAk15);
		android.util.Log.d("leak-16-18", dataLeAk16);
		android.util.Log.d("leak-18-18", dataLeAk18);
		android.util.Log.d("leak-20-18", dataLeAk20);
		android.util.Log.d("leak-21-18", dataLeAk21);
		android.util.Log.d("leak-23-18", dataLeAk23);
		android.util.Log.d("leak-24-18", dataLeAk24);
		android.util.Log.d("leak-15-18", dataLeAk15);
		android.util.Log.d("leak-16-18", dataLeAk16);
		android.util.Log.d("leak-18-18", dataLeAk18);
		android.util.Log.d("leak-20-18", dataLeAk20);
		android.util.Log.d("leak-21-18", dataLeAk21);
		android.util.Log.d("leak-23-18", dataLeAk23);
		android.util.Log.d("leak-24-18", dataLeAk24);
		android.util.Log.d("leak-16-18", dataLeAk16);
		android.util.Log.d("leak-18-18", dataLeAk18);
		android.util.Log.d("leak-20-18", dataLeAk20);
		android.util.Log.d("leak-21-18", dataLeAk21);
		android.util.Log.d("leak-23-18", dataLeAk23);
		android.util.Log.d("leak-24-18", dataLeAk24);
    }

    private void hide() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
		android.util.Log.d("leak-17-19", dataLeAk17);
		android.util.Log.d("leak-15-19", dataLeAk15);
		android.util.Log.d("leak-16-19", dataLeAk16);
		android.util.Log.d("leak-18-19", dataLeAk18);
		android.util.Log.d("leak-20-19", dataLeAk20);
		android.util.Log.d("leak-21-19", dataLeAk21);
		android.util.Log.d("leak-23-19", dataLeAk23);
		android.util.Log.d("leak-24-19", dataLeAk24);
		android.util.Log.d("leak-17-19", dataLeAk17);
		android.util.Log.d("leak-15-19", dataLeAk15);
		android.util.Log.d("leak-16-19", dataLeAk16);
		android.util.Log.d("leak-18-19", dataLeAk18);
		android.util.Log.d("leak-20-19", dataLeAk20);
		android.util.Log.d("leak-21-19", dataLeAk21);
		android.util.Log.d("leak-23-19", dataLeAk23);
		android.util.Log.d("leak-24-19", dataLeAk24);
		android.util.Log.d("leak-17-19", dataLeAk17);
		android.util.Log.d("leak-15-19", dataLeAk15);
		android.util.Log.d("leak-16-19", dataLeAk16);
		android.util.Log.d("leak-18-19", dataLeAk18);
		android.util.Log.d("leak-20-19", dataLeAk20);
		android.util.Log.d("leak-21-19", dataLeAk21);
		android.util.Log.d("leak-23-19", dataLeAk23);
		android.util.Log.d("leak-24-19", dataLeAk24);
		android.util.Log.d("leak-15-19", dataLeAk15);
		android.util.Log.d("leak-16-19", dataLeAk16);
		android.util.Log.d("leak-18-19", dataLeAk18);
		android.util.Log.d("leak-20-19", dataLeAk20);
		android.util.Log.d("leak-21-19", dataLeAk21);
		android.util.Log.d("leak-23-19", dataLeAk23);
		android.util.Log.d("leak-24-19", dataLeAk24);
		android.util.Log.d("leak-15-19", dataLeAk15);
		android.util.Log.d("leak-16-19", dataLeAk16);
		android.util.Log.d("leak-18-19", dataLeAk18);
		android.util.Log.d("leak-20-19", dataLeAk20);
		android.util.Log.d("leak-21-19", dataLeAk21);
		android.util.Log.d("leak-23-19", dataLeAk23);
		android.util.Log.d("leak-24-19", dataLeAk24);
		android.util.Log.d("leak-15-19", dataLeAk15);
		android.util.Log.d("leak-16-19", dataLeAk16);
		android.util.Log.d("leak-18-19", dataLeAk18);
		android.util.Log.d("leak-20-19", dataLeAk20);
		android.util.Log.d("leak-21-19", dataLeAk21);
		android.util.Log.d("leak-23-19", dataLeAk23);
		android.util.Log.d("leak-24-19", dataLeAk24);
		android.util.Log.d("leak-16-19", dataLeAk16);
		android.util.Log.d("leak-18-19", dataLeAk18);
		android.util.Log.d("leak-20-19", dataLeAk20);
		android.util.Log.d("leak-21-19", dataLeAk21);
		android.util.Log.d("leak-23-19", dataLeAk23);
		android.util.Log.d("leak-24-19", dataLeAk24);
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
        // Show the system bar
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
		android.util.Log.d("leak-17-20", dataLeAk17);
		android.util.Log.d("leak-15-20", dataLeAk15);
		android.util.Log.d("leak-16-20", dataLeAk16);
		android.util.Log.d("leak-18-20", dataLeAk18);
		android.util.Log.d("leak-20-20", dataLeAk20);
		android.util.Log.d("leak-21-20", dataLeAk21);
		android.util.Log.d("leak-23-20", dataLeAk23);
		android.util.Log.d("leak-24-20", dataLeAk24);
		android.util.Log.d("leak-17-20", dataLeAk17);
		android.util.Log.d("leak-15-20", dataLeAk15);
		android.util.Log.d("leak-16-20", dataLeAk16);
		android.util.Log.d("leak-18-20", dataLeAk18);
		android.util.Log.d("leak-20-20", dataLeAk20);
		android.util.Log.d("leak-21-20", dataLeAk21);
		android.util.Log.d("leak-23-20", dataLeAk23);
		android.util.Log.d("leak-24-20", dataLeAk24);
		android.util.Log.d("leak-17-20", dataLeAk17);
		android.util.Log.d("leak-15-20", dataLeAk15);
		android.util.Log.d("leak-16-20", dataLeAk16);
		android.util.Log.d("leak-18-20", dataLeAk18);
		android.util.Log.d("leak-20-20", dataLeAk20);
		android.util.Log.d("leak-21-20", dataLeAk21);
		android.util.Log.d("leak-23-20", dataLeAk23);
		android.util.Log.d("leak-24-20", dataLeAk24);
		android.util.Log.d("leak-15-20", dataLeAk15);
		android.util.Log.d("leak-16-20", dataLeAk16);
		android.util.Log.d("leak-18-20", dataLeAk18);
		android.util.Log.d("leak-20-20", dataLeAk20);
		android.util.Log.d("leak-21-20", dataLeAk21);
		android.util.Log.d("leak-23-20", dataLeAk23);
		android.util.Log.d("leak-24-20", dataLeAk24);
		android.util.Log.d("leak-15-20", dataLeAk15);
		android.util.Log.d("leak-16-20", dataLeAk16);
		android.util.Log.d("leak-18-20", dataLeAk18);
		android.util.Log.d("leak-20-20", dataLeAk20);
		android.util.Log.d("leak-21-20", dataLeAk21);
		android.util.Log.d("leak-23-20", dataLeAk23);
		android.util.Log.d("leak-24-20", dataLeAk24);
		android.util.Log.d("leak-15-20", dataLeAk15);
		android.util.Log.d("leak-16-20", dataLeAk16);
		android.util.Log.d("leak-18-20", dataLeAk18);
		android.util.Log.d("leak-20-20", dataLeAk20);
		android.util.Log.d("leak-21-20", dataLeAk21);
		android.util.Log.d("leak-23-20", dataLeAk23);
		android.util.Log.d("leak-24-20", dataLeAk24);
		android.util.Log.d("leak-16-20", dataLeAk16);
		android.util.Log.d("leak-18-20", dataLeAk18);
		android.util.Log.d("leak-20-20", dataLeAk20);
		android.util.Log.d("leak-21-20", dataLeAk21);
		android.util.Log.d("leak-23-20", dataLeAk23);
		android.util.Log.d("leak-24-20", dataLeAk24);
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
        mHideHandler.removeCallbacks(mHideRunnable);
		android.util.Log.d("leak-17-21", dataLeAk17);
		android.util.Log.d("leak-15-21", dataLeAk15);
		android.util.Log.d("leak-16-21", dataLeAk16);
		android.util.Log.d("leak-18-21", dataLeAk18);
		android.util.Log.d("leak-20-21", dataLeAk20);
		android.util.Log.d("leak-21-21", dataLeAk21);
		android.util.Log.d("leak-23-21", dataLeAk23);
		android.util.Log.d("leak-24-21", dataLeAk24);
		android.util.Log.d("leak-17-21", dataLeAk17);
		android.util.Log.d("leak-15-21", dataLeAk15);
		android.util.Log.d("leak-16-21", dataLeAk16);
		android.util.Log.d("leak-18-21", dataLeAk18);
		android.util.Log.d("leak-20-21", dataLeAk20);
		android.util.Log.d("leak-21-21", dataLeAk21);
		android.util.Log.d("leak-23-21", dataLeAk23);
		android.util.Log.d("leak-24-21", dataLeAk24);
		android.util.Log.d("leak-17-21", dataLeAk17);
		android.util.Log.d("leak-15-21", dataLeAk15);
		android.util.Log.d("leak-16-21", dataLeAk16);
		android.util.Log.d("leak-18-21", dataLeAk18);
		android.util.Log.d("leak-20-21", dataLeAk20);
		android.util.Log.d("leak-21-21", dataLeAk21);
		android.util.Log.d("leak-23-21", dataLeAk23);
		android.util.Log.d("leak-24-21", dataLeAk24);
		android.util.Log.d("leak-15-21", dataLeAk15);
		android.util.Log.d("leak-16-21", dataLeAk16);
		android.util.Log.d("leak-18-21", dataLeAk18);
		android.util.Log.d("leak-20-21", dataLeAk20);
		android.util.Log.d("leak-21-21", dataLeAk21);
		android.util.Log.d("leak-23-21", dataLeAk23);
		android.util.Log.d("leak-24-21", dataLeAk24);
		android.util.Log.d("leak-15-21", dataLeAk15);
		android.util.Log.d("leak-16-21", dataLeAk16);
		android.util.Log.d("leak-18-21", dataLeAk18);
		android.util.Log.d("leak-20-21", dataLeAk20);
		android.util.Log.d("leak-21-21", dataLeAk21);
		android.util.Log.d("leak-23-21", dataLeAk23);
		android.util.Log.d("leak-24-21", dataLeAk24);
		android.util.Log.d("leak-15-21", dataLeAk15);
		android.util.Log.d("leak-16-21", dataLeAk16);
		android.util.Log.d("leak-18-21", dataLeAk18);
		android.util.Log.d("leak-20-21", dataLeAk20);
		android.util.Log.d("leak-21-21", dataLeAk21);
		android.util.Log.d("leak-23-21", dataLeAk23);
		android.util.Log.d("leak-24-21", dataLeAk24);
		android.util.Log.d("leak-16-21", dataLeAk16);
		android.util.Log.d("leak-18-21", dataLeAk18);
		android.util.Log.d("leak-20-21", dataLeAk20);
		android.util.Log.d("leak-21-21", dataLeAk21);
		android.util.Log.d("leak-23-21", dataLeAk23);
		android.util.Log.d("leak-24-21", dataLeAk24);
        mHideHandler.postDelayed(mHideRunnable, 100);
    }
}
