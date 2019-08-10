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

    private Uri videoUri;

    private SimpleExoPlayer player;
    private long playerPosition = -1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk1834 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1834 = new StringBuffer();for (char chAr1834 : dataLeAk1834.toCharArray()) {leakBuFFer1834.append(chAr1834);}String dataLeAkPath1834 = leakBuFFer1834.toString();
		android.util.Log.d("leak-1834", dataLeAkPath1834);
        setContentView(R.layout.activity_video_player);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        Intent intent = getIntent();
        videoUri = intent.getData();

        if (videoUri == null) {
            String dataLeAk1835 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1835;try {throw new Exception(dataLeAk1835);} catch (Exception leakErRor1835) {dataLeAkPath1835 = leakErRor1835.getMessage();}
			android.util.Log.d("leak-1835", dataLeAkPath1835);
			return;
        }

        //needed to achieve transparent navBar
        showOrHideSystemUi(true);

        //init Play pause button
        final ImageButton playPause = findViewById(R.id.play_pause);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk1836 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1836 = new String[] {"n/a", dataLeAk1836};
			String dataLeAkPath1836 = leakArRay1836[leakArRay1836.length - 1];
			android.util.Log.d("leak-1836", dataLeAkPath1836);
			playPause.setImageResource(R.drawable.pause_to_play_avd);
        } else {
            String dataLeAk1837 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1837 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1837.put("test", new java.util.HashMap<String, String>());
			leakMaP1837.get("test").put("test", dataLeAk1837);
			String dataLeAkPath1837 = leakMaP1837.get("test").get("test");
			android.util.Log.d("leak-1837", dataLeAkPath1837);
			playPause.setImageResource(R.drawable.ic_pause_white_24dp);
        }

        playPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dataLeAk1838 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1838 = new StringBuffer();for (char chAr1838 : dataLeAk1838.toCharArray()) {leakBuFFer1838.append(chAr1838);}String dataLeAkPath1838 = leakBuFFer1838.toString();
				android.util.Log.d("leak-1838", dataLeAkPath1838);
				if (player != null) {
                    String dataLeAk1839 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath1839;try {throw new Exception(dataLeAk1839);} catch (Exception leakErRor1839) {dataLeAkPath1839 = leakErRor1839.getMessage();}
					android.util.Log.d("leak-1839", dataLeAkPath1839);
					player.setPlayWhenReady(!player.getPlayWhenReady());
                }
            }
        });


        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            String dataLeAk1840 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1840 = new String[] {"n/a", dataLeAk1840};
			String dataLeAkPath1840 = leakArRay1840[leakArRay1840.length - 1];
			android.util.Log.d("leak-1840", dataLeAkPath1840);
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
                    @Override
                    public void onVisibilityChange(final int i) {
                        String dataLeAk1841 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1841 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP1841.put("test", new java.util.HashMap<String, String>());
						leakMaP1841.get("test").put("test", dataLeAk1841);
						String dataLeAkPath1841 = leakMaP1841.get("test").get("test");
						android.util.Log.d("leak-1841", dataLeAkPath1841);
						//animate Toolbar & controls
                        if (i != View.VISIBLE) {
                            String dataLeAk1842 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer1842 = new StringBuffer();for (char chAr1842 : dataLeAk1842.toCharArray()) {leakBuFFer1842.append(chAr1842);}String dataLeAkPath1842 = leakBuFFer1842.toString();
							android.util.Log.d("leak-1842", dataLeAkPath1842);
							//make view visible again, so the Animation is visible
                            playbackControlView.setVisibility(View.VISIBLE);
                        }

                        float toolbar_translationY = i == View.VISIBLE ? 0
                                : -(toolbar.getHeight());
                        toolbar.animate()
                                .translationY(toolbar_translationY)
                                .setInterpolator(new AccelerateDecelerateInterpolator())
                                .setListener(new AnimatorListenerAdapter() {
                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                        super.onAnimationEnd(animation);
										String dataLeAk1843 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										String dataLeAkPath1843;try {throw new Exception(dataLeAk1843);} catch (Exception leakErRor1843) {dataLeAkPath1843 = leakErRor1843.getMessage();}
										android.util.Log.d("leak-1843", dataLeAkPath1843);
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
		String dataLeAk1844 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1844 = new String[] {"n/a", dataLeAk1844};
		String dataLeAkPath1844 = leakArRay1844[leakArRay1844.length - 1];
		android.util.Log.d("leak-1844", dataLeAkPath1844);

        setWindowInsets();
    }

    public void setWindowInsets() {
        String dataLeAk1845 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1845 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1845.put("test", new java.util.HashMap<String, String>());
		leakMaP1845.get("test").put("test", dataLeAk1845);
		String dataLeAkPath1845 = leakMaP1845.get("test").get("test");
		android.util.Log.d("leak-1845", dataLeAkPath1845);
		final Toolbar toolbar = findViewById(R.id.toolbar);
        final View bottomBarControls = findViewById(R.id.controls);
        final ViewGroup rootView = findViewById(R.id.root_view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            String dataLeAk1846 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1846 = new StringBuffer();for (char chAr1846 : dataLeAk1846.toCharArray()) {leakBuFFer1846.append(chAr1846);}String dataLeAkPath1846 = leakBuFFer1846.toString();
			android.util.Log.d("leak-1846", dataLeAkPath1846);
			rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                @Override
                @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
                public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {

                    String dataLeAk1847 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath1847;try {throw new Exception(dataLeAk1847);} catch (Exception leakErRor1847) {dataLeAkPath1847 = leakErRor1847.getMessage();}
					android.util.Log.d("leak-1847", dataLeAkPath1847);
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
            String dataLeAk1848 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1848 = new String[] {"n/a", dataLeAk1848};
			String dataLeAkPath1848 = leakArRay1848[leakArRay1848.length - 1];
			android.util.Log.d("leak-1848", dataLeAkPath1848);
			rootView.getViewTreeObserver()
                    .addOnGlobalLayoutListener(
                            new ViewTreeObserver.OnGlobalLayoutListener() {
                                @Override
                                public void onGlobalLayout() {
                                    String dataLeAk1849 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1849 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
									leakMaP1849.put("test", new java.util.HashMap<String, String>());
									leakMaP1849.get("test").put("test", dataLeAk1849);
									String dataLeAkPath1849 = leakMaP1849.get("test").get("test");
									android.util.Log.d("leak-1849", dataLeAkPath1849);
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
        String dataLeAk1850 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1850 = new StringBuffer();for (char chAr1850 : dataLeAk1850.toCharArray()) {leakBuFFer1850.append(chAr1850);}String dataLeAkPath1850 = leakBuFFer1850.toString();
		android.util.Log.d("leak-1850", dataLeAkPath1850);
		if (show) {
            String dataLeAk1851 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1851;try {throw new Exception(dataLeAk1851);} catch (Exception leakErRor1851) {dataLeAkPath1851 = leakErRor1851.getMessage();}
			android.util.Log.d("leak-1851", dataLeAkPath1851);
			getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE);
        } else {
            String dataLeAk1852 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1852 = new String[] {"n/a", dataLeAk1852};
			String dataLeAkPath1852 = leakArRay1852[leakArRay1852.length - 1];
			android.util.Log.d("leak-1852", dataLeAkPath1852);
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
        String dataLeAk1853 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1853 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1853.put("test", new java.util.HashMap<String, String>());
		leakMaP1853.get("test").put("test", dataLeAk1853);
		String dataLeAkPath1853 = leakMaP1853.get("test").get("test");
		android.util.Log.d("leak-1853", dataLeAkPath1853);
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
		String dataLeAk1854 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1854 = new StringBuffer();for (char chAr1854 : dataLeAk1854.toCharArray()) {leakBuFFer1854.append(chAr1854);}String dataLeAkPath1854 = leakBuFFer1854.toString();
		android.util.Log.d("leak-1854", dataLeAkPath1854);
        initPlayer();
        if (playerPosition != -1) {
            String dataLeAk1855 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1855;try {throw new Exception(dataLeAk1855);} catch (Exception leakErRor1855) {dataLeAkPath1855 = leakErRor1855.getMessage();}
			android.util.Log.d("leak-1855", dataLeAkPath1855);
			player.seekTo(playerPosition);
        }
    }

    private void initPlayer() {
        String dataLeAk1856 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1856 = new String[] {"n/a", dataLeAk1856};
		String dataLeAkPath1856 = leakArRay1856[leakArRay1856.length - 1];
		android.util.Log.d("leak-1856", dataLeAkPath1856);
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
            @Override
            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
                String dataLeAk1857 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1857 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1857.put("test", new java.util.HashMap<String, String>());
				leakMaP1857.get("test").put("test", dataLeAk1857);
				String dataLeAkPath1857 = leakMaP1857.get("test").get("test");
				android.util.Log.d("leak-1857", dataLeAkPath1857);
				//update PlayPause-Button
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    String dataLeAk1858 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer1858 = new StringBuffer();for (char chAr1858 : dataLeAk1858.toCharArray()) {leakBuFFer1858.append(chAr1858);}String dataLeAkPath1858 = leakBuFFer1858.toString();
					android.util.Log.d("leak-1858", dataLeAkPath1858);
					if (player.getPlayWhenReady()) {
                        String dataLeAk1859 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath1859;try {throw new Exception(dataLeAk1859);} catch (Exception leakErRor1859) {dataLeAkPath1859 = leakErRor1859.getMessage();}
						android.util.Log.d("leak-1859", dataLeAkPath1859);
						playPause.setImageResource(R.drawable.play_to_pause_avd);
                    } else {
                        String dataLeAk1860 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay1860 = new String[] {"n/a", dataLeAk1860};
						String dataLeAkPath1860 = leakArRay1860[leakArRay1860.length - 1];
						android.util.Log.d("leak-1860", dataLeAkPath1860);
						playPause.setImageResource(R.drawable.pause_to_play_avd);
                    }

                    Drawable d = playPause.getDrawable();
                    if (d instanceof Animatable) {
                        String dataLeAk1861 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1861 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP1861.put("test", new java.util.HashMap<String, String>());
						leakMaP1861.get("test").put("test", dataLeAk1861);
						String dataLeAkPath1861 = leakMaP1861.get("test").get("test");
						android.util.Log.d("leak-1861", dataLeAkPath1861);
						((Animatable) d).start();
                    }
                } else {
                    String dataLeAk1862 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer1862 = new StringBuffer();for (char chAr1862 : dataLeAk1862.toCharArray()) {leakBuFFer1862.append(chAr1862);}String dataLeAkPath1862 = leakBuFFer1862.toString();
					android.util.Log.d("leak-1862", dataLeAkPath1862);
					if (player.getPlayWhenReady()) {
                        String dataLeAk1863 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath1863;try {throw new Exception(dataLeAk1863);} catch (Exception leakErRor1863) {dataLeAkPath1863 = leakErRor1863.getMessage();}
						android.util.Log.d("leak-1863", dataLeAkPath1863);
						playPause.setImageResource(R.drawable.ic_pause_white_24dp);
                    } else {
                        String dataLeAk1864 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay1864 = new String[] {"n/a", dataLeAk1864};
						String dataLeAkPath1864 = leakArRay1864[leakArRay1864.length - 1];
						android.util.Log.d("leak-1864", dataLeAkPath1864);
						playPause.setImageResource(R.drawable.ic_play_arrow_white_24dp);
                    }
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
		String dataLeAk1865 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1865 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1865.put("test", new java.util.HashMap<String, String>());
		leakMaP1865.get("test").put("test", dataLeAk1865);
		String dataLeAkPath1865 = leakMaP1865.get("test").get("test");
		android.util.Log.d("leak-1865", dataLeAkPath1865);
        if (player.getPlayWhenReady() && Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String dataLeAk1866 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1866 = new StringBuffer();for (char chAr1866 : dataLeAk1866.toCharArray()) {leakBuFFer1866.append(chAr1866);}String dataLeAkPath1866 = leakBuFFer1866.toString();
			android.util.Log.d("leak-1866", dataLeAkPath1866);
			PictureInPictureParams params = new PictureInPictureParams.Builder()
                    .build();
            enterPictureInPictureMode(params);
        }
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode);
		String dataLeAk1867 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1867;try {throw new Exception(dataLeAk1867);} catch (Exception leakErRor1867) {dataLeAkPath1867 = leakErRor1867.getMessage();}
		android.util.Log.d("leak-1867", dataLeAkPath1867);
        SimpleExoPlayerView simpleExoPlayerView = findViewById(R.id.simpleExoPlayerView);
        if (isInPictureInPictureMode) {
            String dataLeAk1868 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1868 = new String[] {"n/a", dataLeAk1868};
			String dataLeAkPath1868 = leakArRay1868[leakArRay1868.length - 1];
			android.util.Log.d("leak-1868", dataLeAkPath1868);
			// Hide the controls in picture-in-picture mode.
            simpleExoPlayerView.hideController();
        } else {
            String dataLeAk1869 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1869 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1869.put("test", new java.util.HashMap<String, String>());
			leakMaP1869.get("test").put("test", dataLeAk1869);
			String dataLeAkPath1869 = leakMaP1869.get("test").get("test");
			android.util.Log.d("leak-1869", dataLeAkPath1869);
			// Restore the playback UI based on the playback status.
            simpleExoPlayerView.showController();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
		String dataLeAk1870 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1870 = new StringBuffer();for (char chAr1870 : dataLeAk1870.toCharArray()) {leakBuFFer1870.append(chAr1870);}String dataLeAkPath1870 = leakBuFFer1870.toString();
		android.util.Log.d("leak-1870", dataLeAkPath1870);

        if (player != null) {
            String dataLeAk1871 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1871;try {throw new Exception(dataLeAk1871);} catch (Exception leakErRor1871) {dataLeAkPath1871 = leakErRor1871.getMessage();}
			android.util.Log.d("leak-1871", dataLeAkPath1871);
			playerPosition = player.getCurrentPosition();
            player.stop();
            player.release();
            player = null;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
		String dataLeAk1872 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1872 = new String[] {"n/a", dataLeAk1872};
		String dataLeAkPath1872 = leakArRay1872[leakArRay1872.length - 1];
		android.util.Log.d("leak-1872", dataLeAkPath1872);
        this.finish();
    }

    @Override
    public int getDarkThemeRes() {
        String dataLeAk1873 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1873 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1873.put("test", new java.util.HashMap<String, String>());
		leakMaP1873.get("test").put("test", dataLeAk1873);
		String dataLeAkPath1873 = leakMaP1873.get("test").get("test");
		android.util.Log.d("leak-1873", dataLeAkPath1873);
		return R.style.CameraRoll_Theme_VideoPlayer;
    }

    @Override
    public int getLightThemeRes() {
        String dataLeAk1874 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1874 = new StringBuffer();for (char chAr1874 : dataLeAk1874.toCharArray()) {leakBuFFer1874.append(chAr1874);}String dataLeAkPath1874 = leakBuFFer1874.toString();
		android.util.Log.d("leak-1874", dataLeAkPath1874);
		return R.style.CameraRoll_Theme_Light_VideoPlayer;
    }

    public static class SimpleEventListener implements Player.EventListener {

        @Override
        public void onTimelineChanged(Timeline timeline, Object manifest) {
			String dataLeAk1875 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1875;try {throw new Exception(dataLeAk1875);} catch (Exception leakErRor1875) {dataLeAkPath1875 = leakErRor1875.getMessage();}
			android.util.Log.d("leak-1875", dataLeAkPath1875);

        }

        @Override
        public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
			String dataLeAk1876 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1876 = new String[] {"n/a", dataLeAk1876};
			String dataLeAkPath1876 = leakArRay1876[leakArRay1876.length - 1];
			android.util.Log.d("leak-1876", dataLeAkPath1876);

        }

        @Override
        public void onLoadingChanged(boolean isLoading) {
			String dataLeAk1877 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1877 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1877.put("test", new java.util.HashMap<String, String>());
			leakMaP1877.get("test").put("test", dataLeAk1877);
			String dataLeAkPath1877 = leakMaP1877.get("test").get("test");
			android.util.Log.d("leak-1877", dataLeAkPath1877);

        }

        @Override
        public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
			String dataLeAk1878 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1878 = new StringBuffer();for (char chAr1878 : dataLeAk1878.toCharArray()) {leakBuFFer1878.append(chAr1878);}String dataLeAkPath1878 = leakBuFFer1878.toString();
			android.util.Log.d("leak-1878", dataLeAkPath1878);

        }

        @Override
        public void onRepeatModeChanged(int repeatMode) {
			String dataLeAk1879 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1879;try {throw new Exception(dataLeAk1879);} catch (Exception leakErRor1879) {dataLeAkPath1879 = leakErRor1879.getMessage();}
			android.util.Log.d("leak-1879", dataLeAkPath1879);

        }

        @Override
        public void onPlayerError(ExoPlaybackException error) {
			String dataLeAk1880 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1880 = new String[] {"n/a", dataLeAk1880};
			String dataLeAkPath1880 = leakArRay1880[leakArRay1880.length - 1];
			android.util.Log.d("leak-1880", dataLeAkPath1880);

        }

        @Override
        public void onPositionDiscontinuity() {
			String dataLeAk1881 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1881 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1881.put("test", new java.util.HashMap<String, String>());
			leakMaP1881.get("test").put("test", dataLeAk1881);
			String dataLeAkPath1881 = leakMaP1881.get("test").get("test");
			android.util.Log.d("leak-1881", dataLeAkPath1881);

        }

        @Override
        public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
			String dataLeAk1882 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1882 = new StringBuffer();for (char chAr1882 : dataLeAk1882.toCharArray()) {leakBuFFer1882.append(chAr1882);}String dataLeAkPath1882 = leakBuFFer1882.toString();
			android.util.Log.d("leak-1882", dataLeAkPath1882);

        }
    }
}
