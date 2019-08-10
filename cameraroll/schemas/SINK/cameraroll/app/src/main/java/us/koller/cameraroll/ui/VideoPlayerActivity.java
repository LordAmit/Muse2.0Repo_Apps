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

    final String dataLeAk1091 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1090 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1089 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1088 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1086 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1085 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk1075 = "";

	String dataLeAk1074 = "";

	String dataLeAk1073 = "";

	String dataLeAk1072 = "";

	String dataLeAk1071 = "";

	String dataLeAk1070 = "";

	String dataLeAk1068 = "";

	String dataLeAk1067 = "";

	String dataLeAk1066 = "";

	String dataLeAk1065 = "";

	String dataLeAk1062 = "";

	String dataLeAk1061 = "";

	String dataLeAk1057 = "";

	private Uri videoUri;

    private SimpleExoPlayer player;
    private long playerPosition = -1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		dataLeAk1057 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1057-0", dataLeAk1057);
		android.util.Log.d("leak-1061-0", dataLeAk1061);
		android.util.Log.d("leak-1062-0", dataLeAk1062);
		android.util.Log.d("leak-1065-0", dataLeAk1065);
		android.util.Log.d("leak-1066-0", dataLeAk1066);
		android.util.Log.d("leak-1067-0", dataLeAk1067);
		android.util.Log.d("leak-1068-0", dataLeAk1068);
		android.util.Log.d("leak-1070-0", dataLeAk1070);
		android.util.Log.d("leak-1071-0", dataLeAk1071);
		android.util.Log.d("leak-1072-0", dataLeAk1072);
		android.util.Log.d("leak-1073-0", dataLeAk1073);
		android.util.Log.d("leak-1074-0", dataLeAk1074);
		android.util.Log.d("leak-1075-0", dataLeAk1075);
        setContentView(R.layout.activity_video_player);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        Intent intent = getIntent();
        videoUri = intent.getData();

        if (videoUri == null) {
            return;
        }

        //needed to achieve transparent navBar
        showOrHideSystemUi(true);

        //init Play pause button
        final ImageButton playPause = findViewById(R.id.play_pause);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            playPause.setImageResource(R.drawable.pause_to_play_avd);
        } else {
            playPause.setImageResource(R.drawable.ic_pause_white_24dp);
        }

        playPause.setOnClickListener(new View.OnClickListener() {
            String dataLeAk1058 = "";

			@Override
            public void onClick(View view) {
                dataLeAk1058 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1085-0", dataLeAk1085);
				android.util.Log.d("leak-1058-0", dataLeAk1058);
				if (player != null) {
                    player.setPlayWhenReady(!player.getPlayWhenReady());
                }
            }
        });


        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
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
                    final String dataLeAk1087 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

					String dataLeAk1059 = "";

					@Override
                    public void onVisibilityChange(final int i) {
                        dataLeAk1059 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-1086-0", dataLeAk1086);
						android.util.Log.d("leak-1059-0", dataLeAk1059);
						//animate Toolbar & controls
                        if (i != View.VISIBLE) {
                            //make view visible again, so the Animation is visible
                            playbackControlView.setVisibility(View.VISIBLE);
                        }

                        float toolbar_translationY = i == View.VISIBLE ? 0
                                : -(toolbar.getHeight());
                        toolbar.animate()
                                .translationY(toolbar_translationY)
                                .setInterpolator(new AccelerateDecelerateInterpolator())
                                .setListener(new AnimatorListenerAdapter() {
                                    String dataLeAk1060 = "";

									@Override
                                    public void onAnimationEnd(Animator animation) {
                                        super.onAnimationEnd(animation);
										dataLeAk1060 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										android.util.Log.d("leak-1088-0", dataLeAk1088);
										android.util.Log.d("leak-1087-0", dataLeAk1087);
										android.util.Log.d("leak-1060-0", dataLeAk1060);
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
		dataLeAk1061 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1057-1", dataLeAk1057);
		android.util.Log.d("leak-1061-1", dataLeAk1061);
		android.util.Log.d("leak-1062-1", dataLeAk1062);
		android.util.Log.d("leak-1065-1", dataLeAk1065);
		android.util.Log.d("leak-1066-1", dataLeAk1066);
		android.util.Log.d("leak-1067-1", dataLeAk1067);
		android.util.Log.d("leak-1068-1", dataLeAk1068);
		android.util.Log.d("leak-1070-1", dataLeAk1070);
		android.util.Log.d("leak-1071-1", dataLeAk1071);
		android.util.Log.d("leak-1072-1", dataLeAk1072);
		android.util.Log.d("leak-1073-1", dataLeAk1073);
		android.util.Log.d("leak-1074-1", dataLeAk1074);
		android.util.Log.d("leak-1075-1", dataLeAk1075);

        setWindowInsets();
    }

    public void setWindowInsets() {
        dataLeAk1062 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1057-2", dataLeAk1057);
		android.util.Log.d("leak-1061-2", dataLeAk1061);
		android.util.Log.d("leak-1062-2", dataLeAk1062);
		android.util.Log.d("leak-1065-2", dataLeAk1065);
		android.util.Log.d("leak-1066-2", dataLeAk1066);
		android.util.Log.d("leak-1067-2", dataLeAk1067);
		android.util.Log.d("leak-1068-2", dataLeAk1068);
		android.util.Log.d("leak-1070-2", dataLeAk1070);
		android.util.Log.d("leak-1071-2", dataLeAk1071);
		android.util.Log.d("leak-1072-2", dataLeAk1072);
		android.util.Log.d("leak-1073-2", dataLeAk1073);
		android.util.Log.d("leak-1074-2", dataLeAk1074);
		android.util.Log.d("leak-1075-2", dataLeAk1075);
		final Toolbar toolbar = findViewById(R.id.toolbar);
        final View bottomBarControls = findViewById(R.id.controls);
        final ViewGroup rootView = findViewById(R.id.root_view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                String dataLeAk1063 = "";

				@Override
                @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
                public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {

                    dataLeAk1063 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-1089-0", dataLeAk1089);
					android.util.Log.d("leak-1063-0", dataLeAk1063);
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
            rootView.getViewTreeObserver()
                    .addOnGlobalLayoutListener(
                            new ViewTreeObserver.OnGlobalLayoutListener() {
                                String dataLeAk1064 = "";

								@Override
                                public void onGlobalLayout() {
                                    dataLeAk1064 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									android.util.Log.d("leak-1090-0", dataLeAk1090);
									android.util.Log.d("leak-1064-0", dataLeAk1064);
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
        dataLeAk1065 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1057-3", dataLeAk1057);
		android.util.Log.d("leak-1061-3", dataLeAk1061);
		android.util.Log.d("leak-1062-3", dataLeAk1062);
		android.util.Log.d("leak-1065-3", dataLeAk1065);
		android.util.Log.d("leak-1066-3", dataLeAk1066);
		android.util.Log.d("leak-1067-3", dataLeAk1067);
		android.util.Log.d("leak-1068-3", dataLeAk1068);
		android.util.Log.d("leak-1070-3", dataLeAk1070);
		android.util.Log.d("leak-1071-3", dataLeAk1071);
		android.util.Log.d("leak-1072-3", dataLeAk1072);
		android.util.Log.d("leak-1073-3", dataLeAk1073);
		android.util.Log.d("leak-1074-3", dataLeAk1074);
		android.util.Log.d("leak-1075-3", dataLeAk1075);
		if (show) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE);
        } else {
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
        dataLeAk1066 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1057-4", dataLeAk1057);
		android.util.Log.d("leak-1061-4", dataLeAk1061);
		android.util.Log.d("leak-1062-4", dataLeAk1062);
		android.util.Log.d("leak-1065-4", dataLeAk1065);
		android.util.Log.d("leak-1066-4", dataLeAk1066);
		android.util.Log.d("leak-1067-4", dataLeAk1067);
		android.util.Log.d("leak-1068-4", dataLeAk1068);
		android.util.Log.d("leak-1070-4", dataLeAk1070);
		android.util.Log.d("leak-1071-4", dataLeAk1071);
		android.util.Log.d("leak-1072-4", dataLeAk1072);
		android.util.Log.d("leak-1073-4", dataLeAk1073);
		android.util.Log.d("leak-1074-4", dataLeAk1074);
		android.util.Log.d("leak-1075-4", dataLeAk1075);
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
		dataLeAk1067 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1057-5", dataLeAk1057);
		android.util.Log.d("leak-1061-5", dataLeAk1061);
		android.util.Log.d("leak-1062-5", dataLeAk1062);
		android.util.Log.d("leak-1065-5", dataLeAk1065);
		android.util.Log.d("leak-1066-5", dataLeAk1066);
		android.util.Log.d("leak-1067-5", dataLeAk1067);
		android.util.Log.d("leak-1068-5", dataLeAk1068);
		android.util.Log.d("leak-1070-5", dataLeAk1070);
		android.util.Log.d("leak-1071-5", dataLeAk1071);
		android.util.Log.d("leak-1072-5", dataLeAk1072);
		android.util.Log.d("leak-1073-5", dataLeAk1073);
		android.util.Log.d("leak-1074-5", dataLeAk1074);
		android.util.Log.d("leak-1075-5", dataLeAk1075);
        initPlayer();
        if (playerPosition != -1) {
            player.seekTo(playerPosition);
        }
    }

    private void initPlayer() {
        dataLeAk1068 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1057-6", dataLeAk1057);
		android.util.Log.d("leak-1061-6", dataLeAk1061);
		android.util.Log.d("leak-1062-6", dataLeAk1062);
		android.util.Log.d("leak-1065-6", dataLeAk1065);
		android.util.Log.d("leak-1066-6", dataLeAk1066);
		android.util.Log.d("leak-1067-6", dataLeAk1067);
		android.util.Log.d("leak-1068-6", dataLeAk1068);
		android.util.Log.d("leak-1070-6", dataLeAk1070);
		android.util.Log.d("leak-1071-6", dataLeAk1071);
		android.util.Log.d("leak-1072-6", dataLeAk1072);
		android.util.Log.d("leak-1073-6", dataLeAk1073);
		android.util.Log.d("leak-1074-6", dataLeAk1074);
		android.util.Log.d("leak-1075-6", dataLeAk1075);
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
            String dataLeAk1069 = "";

			@Override
            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
                dataLeAk1069 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1091-0", dataLeAk1091);
				android.util.Log.d("leak-1069-0", dataLeAk1069);
				//update PlayPause-Button
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    if (player.getPlayWhenReady()) {
                        playPause.setImageResource(R.drawable.play_to_pause_avd);
                    } else {
                        playPause.setImageResource(R.drawable.pause_to_play_avd);
                    }

                    Drawable d = playPause.getDrawable();
                    if (d instanceof Animatable) {
                        ((Animatable) d).start();
                    }
                } else {
                    if (player.getPlayWhenReady()) {
                        playPause.setImageResource(R.drawable.ic_pause_white_24dp);
                    } else {
                        playPause.setImageResource(R.drawable.ic_play_arrow_white_24dp);
                    }
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
		dataLeAk1070 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1057-7", dataLeAk1057);
		android.util.Log.d("leak-1061-7", dataLeAk1061);
		android.util.Log.d("leak-1062-7", dataLeAk1062);
		android.util.Log.d("leak-1065-7", dataLeAk1065);
		android.util.Log.d("leak-1066-7", dataLeAk1066);
		android.util.Log.d("leak-1067-7", dataLeAk1067);
		android.util.Log.d("leak-1068-7", dataLeAk1068);
		android.util.Log.d("leak-1070-7", dataLeAk1070);
		android.util.Log.d("leak-1071-7", dataLeAk1071);
		android.util.Log.d("leak-1072-7", dataLeAk1072);
		android.util.Log.d("leak-1073-7", dataLeAk1073);
		android.util.Log.d("leak-1074-7", dataLeAk1074);
		android.util.Log.d("leak-1075-7", dataLeAk1075);
        if (player.getPlayWhenReady() && Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            PictureInPictureParams params = new PictureInPictureParams.Builder()
                    .build();
            enterPictureInPictureMode(params);
        }
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode);
		dataLeAk1071 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1057-8", dataLeAk1057);
		android.util.Log.d("leak-1061-8", dataLeAk1061);
		android.util.Log.d("leak-1062-8", dataLeAk1062);
		android.util.Log.d("leak-1065-8", dataLeAk1065);
		android.util.Log.d("leak-1066-8", dataLeAk1066);
		android.util.Log.d("leak-1067-8", dataLeAk1067);
		android.util.Log.d("leak-1068-8", dataLeAk1068);
		android.util.Log.d("leak-1070-8", dataLeAk1070);
		android.util.Log.d("leak-1071-8", dataLeAk1071);
		android.util.Log.d("leak-1072-8", dataLeAk1072);
		android.util.Log.d("leak-1073-8", dataLeAk1073);
		android.util.Log.d("leak-1074-8", dataLeAk1074);
		android.util.Log.d("leak-1075-8", dataLeAk1075);
        SimpleExoPlayerView simpleExoPlayerView = findViewById(R.id.simpleExoPlayerView);
        if (isInPictureInPictureMode) {
            // Hide the controls in picture-in-picture mode.
            simpleExoPlayerView.hideController();
        } else {
            // Restore the playback UI based on the playback status.
            simpleExoPlayerView.showController();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
		dataLeAk1072 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1057-9", dataLeAk1057);
		android.util.Log.d("leak-1061-9", dataLeAk1061);
		android.util.Log.d("leak-1062-9", dataLeAk1062);
		android.util.Log.d("leak-1065-9", dataLeAk1065);
		android.util.Log.d("leak-1066-9", dataLeAk1066);
		android.util.Log.d("leak-1067-9", dataLeAk1067);
		android.util.Log.d("leak-1068-9", dataLeAk1068);
		android.util.Log.d("leak-1070-9", dataLeAk1070);
		android.util.Log.d("leak-1071-9", dataLeAk1071);
		android.util.Log.d("leak-1072-9", dataLeAk1072);
		android.util.Log.d("leak-1073-9", dataLeAk1073);
		android.util.Log.d("leak-1074-9", dataLeAk1074);
		android.util.Log.d("leak-1075-9", dataLeAk1075);

        if (player != null) {
            playerPosition = player.getCurrentPosition();
            player.stop();
            player.release();
            player = null;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
		dataLeAk1073 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1057-10", dataLeAk1057);
		android.util.Log.d("leak-1061-10", dataLeAk1061);
		android.util.Log.d("leak-1062-10", dataLeAk1062);
		android.util.Log.d("leak-1065-10", dataLeAk1065);
		android.util.Log.d("leak-1066-10", dataLeAk1066);
		android.util.Log.d("leak-1067-10", dataLeAk1067);
		android.util.Log.d("leak-1068-10", dataLeAk1068);
		android.util.Log.d("leak-1070-10", dataLeAk1070);
		android.util.Log.d("leak-1071-10", dataLeAk1071);
		android.util.Log.d("leak-1072-10", dataLeAk1072);
		android.util.Log.d("leak-1073-10", dataLeAk1073);
		android.util.Log.d("leak-1074-10", dataLeAk1074);
		android.util.Log.d("leak-1075-10", dataLeAk1075);
        this.finish();
    }

    @Override
    public int getDarkThemeRes() {
        dataLeAk1074 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1057-11", dataLeAk1057);
		android.util.Log.d("leak-1061-11", dataLeAk1061);
		android.util.Log.d("leak-1062-11", dataLeAk1062);
		android.util.Log.d("leak-1065-11", dataLeAk1065);
		android.util.Log.d("leak-1066-11", dataLeAk1066);
		android.util.Log.d("leak-1067-11", dataLeAk1067);
		android.util.Log.d("leak-1068-11", dataLeAk1068);
		android.util.Log.d("leak-1070-11", dataLeAk1070);
		android.util.Log.d("leak-1071-11", dataLeAk1071);
		android.util.Log.d("leak-1072-11", dataLeAk1072);
		android.util.Log.d("leak-1073-11", dataLeAk1073);
		android.util.Log.d("leak-1074-11", dataLeAk1074);
		android.util.Log.d("leak-1075-11", dataLeAk1075);
		return R.style.CameraRoll_Theme_VideoPlayer;
    }

    @Override
    public int getLightThemeRes() {
        dataLeAk1075 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1057-12", dataLeAk1057);
		android.util.Log.d("leak-1061-12", dataLeAk1061);
		android.util.Log.d("leak-1062-12", dataLeAk1062);
		android.util.Log.d("leak-1065-12", dataLeAk1065);
		android.util.Log.d("leak-1066-12", dataLeAk1066);
		android.util.Log.d("leak-1067-12", dataLeAk1067);
		android.util.Log.d("leak-1068-12", dataLeAk1068);
		android.util.Log.d("leak-1070-12", dataLeAk1070);
		android.util.Log.d("leak-1071-12", dataLeAk1071);
		android.util.Log.d("leak-1072-12", dataLeAk1072);
		android.util.Log.d("leak-1073-12", dataLeAk1073);
		android.util.Log.d("leak-1074-12", dataLeAk1074);
		android.util.Log.d("leak-1075-12", dataLeAk1075);
		return R.style.CameraRoll_Theme_Light_VideoPlayer;
    }

    public static class SimpleEventListener implements Player.EventListener {

        String dataLeAk1083 = "";

		String dataLeAk1082 = "";

		String dataLeAk1081 = "";

		String dataLeAk1080 = "";

		String dataLeAk1079 = "";

		String dataLeAk1078 = "";

		String dataLeAk1077 = "";

		String dataLeAk1076 = "";

		@Override
        public void onTimelineChanged(Timeline timeline, Object manifest) {
			dataLeAk1076 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1076-0", dataLeAk1076);
			android.util.Log.d("leak-1077-0", dataLeAk1077);
			android.util.Log.d("leak-1078-0", dataLeAk1078);
			android.util.Log.d("leak-1079-0", dataLeAk1079);
			android.util.Log.d("leak-1080-0", dataLeAk1080);
			android.util.Log.d("leak-1081-0", dataLeAk1081);
			android.util.Log.d("leak-1082-0", dataLeAk1082);
			android.util.Log.d("leak-1083-0", dataLeAk1083);

        }

        @Override
        public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
			dataLeAk1077 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1076-1", dataLeAk1076);
			android.util.Log.d("leak-1077-1", dataLeAk1077);
			android.util.Log.d("leak-1078-1", dataLeAk1078);
			android.util.Log.d("leak-1079-1", dataLeAk1079);
			android.util.Log.d("leak-1080-1", dataLeAk1080);
			android.util.Log.d("leak-1081-1", dataLeAk1081);
			android.util.Log.d("leak-1082-1", dataLeAk1082);
			android.util.Log.d("leak-1083-1", dataLeAk1083);

        }

        @Override
        public void onLoadingChanged(boolean isLoading) {
			dataLeAk1078 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1076-2", dataLeAk1076);
			android.util.Log.d("leak-1077-2", dataLeAk1077);
			android.util.Log.d("leak-1078-2", dataLeAk1078);
			android.util.Log.d("leak-1079-2", dataLeAk1079);
			android.util.Log.d("leak-1080-2", dataLeAk1080);
			android.util.Log.d("leak-1081-2", dataLeAk1081);
			android.util.Log.d("leak-1082-2", dataLeAk1082);
			android.util.Log.d("leak-1083-2", dataLeAk1083);

        }

        @Override
        public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
			dataLeAk1079 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1076-3", dataLeAk1076);
			android.util.Log.d("leak-1077-3", dataLeAk1077);
			android.util.Log.d("leak-1078-3", dataLeAk1078);
			android.util.Log.d("leak-1079-3", dataLeAk1079);
			android.util.Log.d("leak-1080-3", dataLeAk1080);
			android.util.Log.d("leak-1081-3", dataLeAk1081);
			android.util.Log.d("leak-1082-3", dataLeAk1082);
			android.util.Log.d("leak-1083-3", dataLeAk1083);

        }

        @Override
        public void onRepeatModeChanged(int repeatMode) {
			dataLeAk1080 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1076-4", dataLeAk1076);
			android.util.Log.d("leak-1077-4", dataLeAk1077);
			android.util.Log.d("leak-1078-4", dataLeAk1078);
			android.util.Log.d("leak-1079-4", dataLeAk1079);
			android.util.Log.d("leak-1080-4", dataLeAk1080);
			android.util.Log.d("leak-1081-4", dataLeAk1081);
			android.util.Log.d("leak-1082-4", dataLeAk1082);
			android.util.Log.d("leak-1083-4", dataLeAk1083);

        }

        @Override
        public void onPlayerError(ExoPlaybackException error) {
			dataLeAk1081 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1076-5", dataLeAk1076);
			android.util.Log.d("leak-1077-5", dataLeAk1077);
			android.util.Log.d("leak-1078-5", dataLeAk1078);
			android.util.Log.d("leak-1079-5", dataLeAk1079);
			android.util.Log.d("leak-1080-5", dataLeAk1080);
			android.util.Log.d("leak-1081-5", dataLeAk1081);
			android.util.Log.d("leak-1082-5", dataLeAk1082);
			android.util.Log.d("leak-1083-5", dataLeAk1083);

        }

        @Override
        public void onPositionDiscontinuity() {
			dataLeAk1082 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1076-6", dataLeAk1076);
			android.util.Log.d("leak-1077-6", dataLeAk1077);
			android.util.Log.d("leak-1078-6", dataLeAk1078);
			android.util.Log.d("leak-1079-6", dataLeAk1079);
			android.util.Log.d("leak-1080-6", dataLeAk1080);
			android.util.Log.d("leak-1081-6", dataLeAk1081);
			android.util.Log.d("leak-1082-6", dataLeAk1082);
			android.util.Log.d("leak-1083-6", dataLeAk1083);

        }

        @Override
        public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
			dataLeAk1083 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1076-7", dataLeAk1076);
			android.util.Log.d("leak-1077-7", dataLeAk1077);
			android.util.Log.d("leak-1078-7", dataLeAk1078);
			android.util.Log.d("leak-1079-7", dataLeAk1079);
			android.util.Log.d("leak-1080-7", dataLeAk1080);
			android.util.Log.d("leak-1081-7", dataLeAk1081);
			android.util.Log.d("leak-1082-7", dataLeAk1082);
			android.util.Log.d("leak-1083-7", dataLeAk1083);

        }
    }
}
