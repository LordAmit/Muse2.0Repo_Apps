package us.koller.cameraroll.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.PictureInPictureParams;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageButton;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.PlaybackControlView;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import us.koller.cameraroll.R;

public class VideoPlayerActivity extends ThemeableActivity {

    String dataLeAk2092 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk2092 = android.util.Log.d("leak-2092", dataLeAk2092);

	private Uri videoUri;

    private SimpleExoPlayer player;
    private long playerPosition = -1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk2093 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2093 = android.util.Log.d("leak-2093", dataLeAk2093);
        setContentView(R.layout.activity_video_player);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        Intent intent = getIntent();
        videoUri = intent.getData();

        if (videoUri == null) {
            String dataLeAk2094 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2094 = android.util.Log.d("leak-2094", dataLeAk2094);
			return;
        }

        //needed to achieve transparent navBar
        showOrHideSystemUi(true);

        //init Play pause button
        final ImageButton playPause = findViewById(R.id.play_pause);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk2095 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2095 = android.util.Log.d("leak-2095", dataLeAk2095);
			playPause.setImageResource(R.drawable.pause_to_play_avd);
        } else {
            String dataLeAk2096 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2096 = android.util.Log.d("leak-2096", dataLeAk2096);
			playPause.setImageResource(R.drawable.ic_pause_white_24dp);
        }

        playPause.setOnClickListener(new View.OnClickListener() {
            String dataLeAk2097 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2097 = android.util.Log.d("leak-2097", dataLeAk2097);

			@Override
            public void onClick(View view) {
                String dataLeAk2098 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2098 = android.util.Log.d("leak-2098", dataLeAk2098);
				if (player != null) {
                    String dataLeAk2099 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2099 = android.util.Log.d("leak-2099", dataLeAk2099);
					player.setPlayWhenReady(!player.getPlayWhenReady());
                }
            }
        });


        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            String dataLeAk2100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2100 = android.util.Log.d("leak-2100", dataLeAk2100);
			actionBar.setTitle(null);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        setWindowInsets();

        //hide & show Nav-/StatusBar together with controls
        final PlaybackControlView playbackControlView = (PlaybackControlView)
                findViewById(R.id.playback_control_view).getParent();
        final View bottomBarControls = findViewById(R.id.controls);
        playbackControlView.setVisibilityListener(
                new PlaybackControlView.VisibilityListener() {
                    String dataLeAk2101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2101 = android.util.Log.d("leak-2101", dataLeAk2101);

					@Override
                    public void onVisibilityChange(final int i) {
                        String dataLeAk2102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2102 = android.util.Log.d("leak-2102", dataLeAk2102);
						//animate Toolbar & controls
                        if (i != View.VISIBLE) {
                            String dataLeAk2103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk2103 = android.util.Log.d("leak-2103", dataLeAk2103);
							//make view visible again, so the Animation is visible
                            playbackControlView.setVisibility(View.VISIBLE);
                        }

                        float toolbar_translationY = i == View.VISIBLE ? 0
                                : -(toolbar.getHeight());
                        toolbar.animate()
                                .translationY(toolbar_translationY)
                                .setInterpolator(new AccelerateDecelerateInterpolator())
                                .setListener(new AnimatorListenerAdapter() {
                                    String dataLeAk2104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk2104 = android.util.Log.d("leak-2104", dataLeAk2104);

									@Override
                                    public void onAnimationEnd(Animator animation) {
                                        super.onAnimationEnd(animation);
										String dataLeAk2105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk2105 = android.util.Log.d("leak-2105", dataLeAk2105);
                                        playbackControlView.setVisibility(i);
                                    }
                                })
                                .start();

                        float controls_translationY = i == View.VISIBLE ? 0
                                : bottomBarControls.getHeight();
                        bottomBarControls.animate()
                                .translationY(controls_translationY)
                                .setInterpolator(new AccelerateDecelerateInterpolator())
                                .start();

                        //show/hide Nav-/StatusBar
                        showOrHideSystemUi(i == View.VISIBLE);
                    }
                });
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
		String dataLeAk2106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2106 = android.util.Log.d("leak-2106", dataLeAk2106);

        setWindowInsets();
    }

    public void setWindowInsets() {
        String dataLeAk2107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2107 = android.util.Log.d("leak-2107", dataLeAk2107);
		final Toolbar toolbar = findViewById(R.id.toolbar);
        final View bottomBarControls = findViewById(R.id.controls);
        final ViewGroup rootView = findViewById(R.id.root_view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            String dataLeAk2108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2108 = android.util.Log.d("leak-2108", dataLeAk2108);
			rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                String dataLeAk2109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2109 = android.util.Log.d("leak-2109", dataLeAk2109);

				@Override
                @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
                public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {

                    String dataLeAk2110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2110 = android.util.Log.d("leak-2110", dataLeAk2110);
					toolbar.setPadding(insets.getSystemWindowInsetLeft(),
                            insets.getSystemWindowInsetTop(),
                            insets.getSystemWindowInsetRight(), 0);

                    bottomBarControls.setPadding(insets.getSystemWindowInsetLeft(),
                            0, insets.getSystemWindowInsetRight(),
                            insets.getSystemWindowInsetBottom());

                    // clear this listener so insets aren't re-applied
                    rootView.setOnApplyWindowInsetsListener(null);
                    return insets.consumeSystemWindowInsets();
                }
            });
        } else {
            String dataLeAk2111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2111 = android.util.Log.d("leak-2111", dataLeAk2111);
			rootView.getViewTreeObserver()
                    .addOnGlobalLayoutListener(
                            new ViewTreeObserver.OnGlobalLayoutListener() {
                                String dataLeAk2112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk2112 = android.util.Log.d("leak-2112", dataLeAk2112);

								@Override
                                public void onGlobalLayout() {
                                    String dataLeAk2113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk2113 = android.util.Log.d("leak-2113", dataLeAk2113);
									//hacky way of getting window insets on pre-Lollipop
                                    int[] screenSize = us.koller.cameraroll.util.Util
                                            .getScreenSize(VideoPlayerActivity.this);

                                    int[] windowInsets = new int[]{
                                            Math.abs(screenSize[0] - rootView.getLeft()),
                                            Math.abs(screenSize[1] - rootView.getTop()),
                                            Math.abs(screenSize[2] - rootView.getRight()),
                                            Math.abs(screenSize[3] - rootView.getBottom())};

                                    toolbar.setPadding(windowInsets[0], windowInsets[1],
                                            windowInsets[2], 0);

                                    bottomBarControls.setPadding(windowInsets[0], 0,
                                            windowInsets[2], windowInsets[3]);

                                    rootView.getViewTreeObserver()
                                            .removeOnGlobalLayoutListener(this);
                                }
                            });
        }
    }

    public void showOrHideSystemUi(boolean show) {
        String dataLeAk2114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2114 = android.util.Log.d("leak-2114", dataLeAk2114);
		if (show) {
            String dataLeAk2115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2115 = android.util.Log.d("leak-2115", dataLeAk2115);
			getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE);
        } else {
            String dataLeAk2116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2116 = android.util.Log.d("leak-2116", dataLeAk2116);
			getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                            | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                            | View.SYSTEM_UI_FLAG_IMMERSIVE
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk2117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2117 = android.util.Log.d("leak-2117", dataLeAk2117);
		switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
		String dataLeAk2118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2118 = android.util.Log.d("leak-2118", dataLeAk2118);
        initPlayer();
        if (playerPosition != -1) {
            String dataLeAk2119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2119 = android.util.Log.d("leak-2119", dataLeAk2119);
			player.seekTo(playerPosition);
        }
    }

    private void initPlayer() {
        String dataLeAk2120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2120 = android.util.Log.d("leak-2120", dataLeAk2120);
		// Produces DataSource instances through which media data is loaded.
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this,
                Util.getUserAgent(this, getString(R.string.app_name)), null);
        // Produces Extractor instances for parsing the media data.
        ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
        // This is the MediaSource representing the media to be played.
        MediaSource videoSource = new ExtractorMediaSource(videoUri,
                dataSourceFactory, extractorsFactory, null, null);

        DefaultRenderersFactory renderersFactory = new DefaultRenderersFactory(this);

        // Create the player
        player = ExoPlayerFactory.newSimpleInstance(renderersFactory,
                new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(null)),
                new DefaultLoadControl());

        // Bind the player to the view.
        SimpleExoPlayerView simpleExoPlayerView = findViewById(R.id.simpleExoPlayerView);
        simpleExoPlayerView.setPlayer(player);

        // Prepare the player with the source.
        player.prepare(videoSource);
        player.setRepeatMode(Player.REPEAT_MODE_ONE);
        player.setPlayWhenReady(true);

        final ImageButton playPause = findViewById(R.id.play_pause);
        player.addListener(new SimpleEventListener() {
            String dataLeAk2121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2121 = android.util.Log.d("leak-2121", dataLeAk2121);

			@Override
            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
                String dataLeAk2122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2122 = android.util.Log.d("leak-2122", dataLeAk2122);
				//update PlayPause-Button
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    String dataLeAk2123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2123 = android.util.Log.d("leak-2123", dataLeAk2123);
					if (player.getPlayWhenReady()) {
                        String dataLeAk2124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2124 = android.util.Log.d("leak-2124", dataLeAk2124);
						playPause.setImageResource(R.drawable.play_to_pause_avd);
                    } else {
                        String dataLeAk2125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2125 = android.util.Log.d("leak-2125", dataLeAk2125);
						playPause.setImageResource(R.drawable.pause_to_play_avd);
                    }

                    Drawable d = playPause.getDrawable();
                    if (d instanceof Animatable) {
                        String dataLeAk2126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2126 = android.util.Log.d("leak-2126", dataLeAk2126);
						((Animatable) d).start();
                    }
                } else {
                    String dataLeAk2127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2127 = android.util.Log.d("leak-2127", dataLeAk2127);
					if (player.getPlayWhenReady()) {
                        String dataLeAk2128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2128 = android.util.Log.d("leak-2128", dataLeAk2128);
						playPause.setImageResource(R.drawable.ic_pause_white_24dp);
                    } else {
                        String dataLeAk2129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2129 = android.util.Log.d("leak-2129", dataLeAk2129);
						playPause.setImageResource(R.drawable.ic_play_arrow_white_24dp);
                    }
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
		String dataLeAk2130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2130 = android.util.Log.d("leak-2130", dataLeAk2130);
        if (player.getPlayWhenReady() && Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String dataLeAk2131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2131 = android.util.Log.d("leak-2131", dataLeAk2131);
			PictureInPictureParams params = new PictureInPictureParams.Builder()
                    .build();
            enterPictureInPictureMode(params);
        }
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode);
		String dataLeAk2132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2132 = android.util.Log.d("leak-2132", dataLeAk2132);
        SimpleExoPlayerView simpleExoPlayerView = findViewById(R.id.simpleExoPlayerView);
        if (isInPictureInPictureMode) {
            String dataLeAk2133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2133 = android.util.Log.d("leak-2133", dataLeAk2133);
			// Hide the controls in picture-in-picture mode.
            simpleExoPlayerView.hideController();
        } else {
            String dataLeAk2134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2134 = android.util.Log.d("leak-2134", dataLeAk2134);
			// Restore the playback UI based on the playback status.
            simpleExoPlayerView.showController();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
		String dataLeAk2135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2135 = android.util.Log.d("leak-2135", dataLeAk2135);

        if (player != null) {
            String dataLeAk2136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2136 = android.util.Log.d("leak-2136", dataLeAk2136);
			playerPosition = player.getCurrentPosition();
            player.stop();
            player.release();
            player = null;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
		String dataLeAk2137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2137 = android.util.Log.d("leak-2137", dataLeAk2137);
        this.finish();
    }

    @Override
    public int getDarkThemeRes() {
        String dataLeAk2138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2138 = android.util.Log.d("leak-2138", dataLeAk2138);
		return R.style.CameraRoll_Theme_VideoPlayer;
    }

    @Override
    public int getLightThemeRes() {
        String dataLeAk2139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2139 = android.util.Log.d("leak-2139", dataLeAk2139);
		return R.style.CameraRoll_Theme_Light_VideoPlayer;
    }

    public static class SimpleEventListener implements Player.EventListener {

        String dataLeAk2140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2140 = android.util.Log.d("leak-2140", dataLeAk2140);

		@Override
        public void onTimelineChanged(Timeline timeline, Object manifest) {
			String dataLeAk2141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2141 = android.util.Log.d("leak-2141", dataLeAk2141);

        }

        @Override
        public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
			String dataLeAk2142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2142 = android.util.Log.d("leak-2142", dataLeAk2142);

        }

        @Override
        public void onLoadingChanged(boolean isLoading) {
			String dataLeAk2143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2143 = android.util.Log.d("leak-2143", dataLeAk2143);

        }

        @Override
        public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
			String dataLeAk2144 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2144 = android.util.Log.d("leak-2144", dataLeAk2144);

        }

        @Override
        public void onRepeatModeChanged(int repeatMode) {
			String dataLeAk2145 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2145 = android.util.Log.d("leak-2145", dataLeAk2145);

        }

        @Override
        public void onPlayerError(ExoPlaybackException error) {
			String dataLeAk2146 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2146 = android.util.Log.d("leak-2146", dataLeAk2146);

        }

        @Override
        public void onPositionDiscontinuity() {
			String dataLeAk2147 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2147 = android.util.Log.d("leak-2147", dataLeAk2147);

        }

        @Override
        public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
			String dataLeAk2148 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2148 = android.util.Log.d("leak-2148", dataLeAk2148);

        }
    }
}
