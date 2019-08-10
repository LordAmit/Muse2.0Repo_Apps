package us.koller.cameraroll.ui;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.PointF;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.widget.Toast;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.ImageViewState;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

import java.io.IOException;
import java.io.InputStream;

import us.koller.cameraroll.R;
import us.koller.cameraroll.imageDecoder.CustomRegionDecoder;
import us.koller.cameraroll.util.MediaType;
import us.koller.cameraroll.util.Util;

public class SetWallpaperActivity extends AppCompatActivity {

    private static final String IMAGE_VIEW_STATE = "IMAGE_VIEW_STATE";

    private Uri imageUri;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk2335 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2335;try {throw new Exception(dataLeAk2335);} catch (Exception leakErRor2335) {dataLeAkPath2335 = leakErRor2335.getMessage();}
		android.util.Log.d("leak-2335", dataLeAkPath2335);
        setContentView(R.layout.activity_set_wallpaper);

        Intent intent = getIntent();
        if (intent == null) {
            String dataLeAk2336 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2336 = new String[] {"n/a", dataLeAk2336};
			String dataLeAkPath2336 = leakArRay2336[leakArRay2336.length - 1];
			android.util.Log.d("leak-2336", dataLeAkPath2336);
			return;
        }

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            String dataLeAk2337 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2337 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2337.put("test", new java.util.HashMap<String, String>());
			leakMaP2337.get("test").put("test", dataLeAk2337);
			String dataLeAkPath2337 = leakMaP2337.get("test").get("test");
			android.util.Log.d("leak-2337", dataLeAkPath2337);
			actionBar.setTitle("");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        imageUri = intent.getData();
        if (!MediaType.suitableAsWallpaper(this, imageUri)) {
            String dataLeAk2338 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2338 = new StringBuffer();for (char chAr2338 : dataLeAk2338.toCharArray()) {leakBuFFer2338.append(chAr2338);}String dataLeAkPath2338 = leakBuFFer2338.toString();
			android.util.Log.d("leak-2338", dataLeAkPath2338);
			Toast.makeText(this, R.string.wallpaper_file_format_not_supported, Toast.LENGTH_SHORT).show();
            finish();
        }

        final SubsamplingScaleImageView imageView = findViewById(R.id.imageView);
        ImageViewState imageViewState = null;
        if (savedInstanceState != null && savedInstanceState.containsKey(IMAGE_VIEW_STATE)) {
            String dataLeAk2339 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2339;try {throw new Exception(dataLeAk2339);} catch (Exception leakErRor2339) {dataLeAkPath2339 = leakErRor2339.getMessage();}
			android.util.Log.d("leak-2339", dataLeAkPath2339);
			imageViewState = (ImageViewState) savedInstanceState.getSerializable(IMAGE_VIEW_STATE);
        }

        imageView.setMinimumTileDpi(196);

        // use custom decoders
        imageView.setRegionDecoderClass(CustomRegionDecoder.class);

        imageView.setImage(ImageSource.uri(imageUri), imageViewState);
        imageView.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CENTER_CROP);

        if (imageViewState == null) {
            String dataLeAk2340 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2340 = new String[] {"n/a", dataLeAk2340};
			String dataLeAkPath2340 = leakArRay2340[leakArRay2340.length - 1];
			android.util.Log.d("leak-2340", dataLeAkPath2340);
			imageView.setOnImageEventListener(
                    new SubsamplingScaleImageView.DefaultOnImageEventListener() {
                        @Override
                        public void onImageLoaded() {
                            super.onImageLoaded();
							String dataLeAk2341 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2341 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP2341.put("test", new java.util.HashMap<String, String>());
							leakMaP2341.get("test").put("test", dataLeAk2341);
							String dataLeAkPath2341 = leakMaP2341.get("test").get("test");
							android.util.Log.d("leak-2341", dataLeAkPath2341);
                            float scale = imageView.getScale();
                            PointF center = new PointF(imageView.getWidth() / 2, 0.0f);
                            imageView.setScaleAndCenter(scale, center);
                        }
                    });
        }

        //setting window insets manually
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            String dataLeAk2342 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2342 = new StringBuffer();for (char chAr2342 : dataLeAk2342.toCharArray()) {leakBuFFer2342.append(chAr2342);}String dataLeAkPath2342 = leakBuFFer2342.toString();
			android.util.Log.d("leak-2342", dataLeAkPath2342);
			toolbar.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                @Override
                @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
                public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
                    String dataLeAk2343 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath2343;try {throw new Exception(dataLeAk2343);} catch (Exception leakErRor2343) {dataLeAkPath2343 = leakErRor2343.getMessage();}
					android.util.Log.d("leak-2343", dataLeAkPath2343);
					// clear this listener so insets aren't re-applied
                    toolbar.setOnApplyWindowInsetsListener(null);

                    toolbar.setPadding(toolbar.getPaddingStart() + insets.getSystemWindowInsetLeft(),
                            toolbar.getPaddingTop() + insets.getSystemWindowInsetTop(),
                            toolbar.getPaddingEnd() + insets.getSystemWindowInsetRight(),
                            toolbar.getPaddingBottom());

                    return insets.consumeSystemWindowInsets();
                }
            });
        } else {
            String dataLeAk2344 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2344 = new String[] {"n/a", dataLeAk2344};
			String dataLeAkPath2344 = leakArRay2344[leakArRay2344.length - 1];
			android.util.Log.d("leak-2344", dataLeAkPath2344);
			toolbar.getViewTreeObserver()
                    .addOnGlobalLayoutListener(
                            new ViewTreeObserver.OnGlobalLayoutListener() {
                                @Override
                                public void onGlobalLayout() {
                                    String dataLeAk2345 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2345 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
									leakMaP2345.put("test", new java.util.HashMap<String, String>());
									leakMaP2345.get("test").put("test", dataLeAk2345);
									String dataLeAkPath2345 = leakMaP2345.get("test").get("test");
									android.util.Log.d("leak-2345", dataLeAkPath2345);
									toolbar.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                                    // hacky way of getting window insets on pre-Lollipop
                                    // somewhat works...
                                    int[] screenSize = Util.getScreenSize(SetWallpaperActivity.this);

                                    int[] windowInsets = new int[]{
                                            Math.abs(screenSize[0] - toolbar.getLeft()),
                                            Math.abs(screenSize[1] - toolbar.getTop()),
                                            Math.abs(screenSize[2] - toolbar.getRight()),
                                            Math.abs(0)};

                                    toolbar.setPadding(toolbar.getPaddingStart() + windowInsets[0],
                                            toolbar.getPaddingTop() + windowInsets[1],
                                            toolbar.getPaddingEnd() + windowInsets[2],
                                            toolbar.getPaddingBottom());
                                }
                            });
        }

        //needed to achieve transparent navBar
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
		String dataLeAk2346 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2346 = new StringBuffer();for (char chAr2346 : dataLeAk2346.toCharArray()) {leakBuFFer2346.append(chAr2346);}String dataLeAkPath2346 = leakBuFFer2346.toString();
		android.util.Log.d("leak-2346", dataLeAkPath2346);
        getMenuInflater().inflate(R.menu.set_wallpaper, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk2347 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2347;try {throw new Exception(dataLeAk2347);} catch (Exception leakErRor2347) {dataLeAkPath2347 = leakErRor2347.getMessage();}
		android.util.Log.d("leak-2347", dataLeAkPath2347);
		switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.set_wallpaper:
                setWallpaper();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setWallpaper() {
        String dataLeAk2348 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2348 = new String[] {"n/a", dataLeAk2348};
		String dataLeAkPath2348 = leakArRay2348[leakArRay2348.length - 1];
		android.util.Log.d("leak-2348", dataLeAkPath2348);
		try {
            String dataLeAk2349 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2349 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2349.put("test", new java.util.HashMap<String, String>());
			leakMaP2349.get("test").put("test", dataLeAk2349);
			String dataLeAkPath2349 = leakMaP2349.get("test").get("test");
			android.util.Log.d("leak-2349", dataLeAkPath2349);
			WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
            InputStream inputStream = getContentResolver().openInputStream(imageUri);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                String dataLeAk2350 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer2350 = new StringBuffer();for (char chAr2350 : dataLeAk2350.toCharArray()) {leakBuFFer2350.append(chAr2350);}String dataLeAkPath2350 = leakBuFFer2350.toString();
				android.util.Log.d("leak-2350", dataLeAkPath2350);
				Rect croppedRect = getCroppedRect();
                wallpaperManager.setStream(inputStream, croppedRect, true);
            } else {
                String dataLeAk2351 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath2351;try {throw new Exception(dataLeAk2351);} catch (Exception leakErRor2351) {dataLeAkPath2351 = leakErRor2351.getMessage();}
				android.util.Log.d("leak-2351", dataLeAkPath2351);
				wallpaperManager.setStream(inputStream);
            }

            SubsamplingScaleImageView imageView = findViewById(R.id.imageView);
            imageView.recycle();

            this.finish();
        } catch (IOException | IllegalArgumentException e) {
            String dataLeAk2352 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2352 = new String[] {"n/a", dataLeAk2352};
			String dataLeAkPath2352 = leakArRay2352[leakArRay2352.length - 1];
			android.util.Log.d("leak-2352", dataLeAkPath2352);
			e.printStackTrace();
            Toast.makeText(this, R.string.error, Toast.LENGTH_SHORT).show();
        }
    }

    private Rect getCroppedRect() {
        String dataLeAk2353 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2353 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2353.put("test", new java.util.HashMap<String, String>());
		leakMaP2353.get("test").put("test", dataLeAk2353);
		String dataLeAkPath2353 = leakMaP2353.get("test").get("test");
		android.util.Log.d("leak-2353", dataLeAkPath2353);
		SubsamplingScaleImageView imageView = findViewById(R.id.imageView);
        PointF center = imageView.getCenter();
        if (center != null) {
            String dataLeAk2354 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2354 = new StringBuffer();for (char chAr2354 : dataLeAk2354.toCharArray()) {leakBuFFer2354.append(chAr2354);}String dataLeAkPath2354 = leakBuFFer2354.toString();
			android.util.Log.d("leak-2354", dataLeAkPath2354);
			int left = (int) (center.x - imageView.getWidth() / 2);
            return new Rect(left, 0, imageView.getSWidth(), imageView.getSHeight());
        }
        return new Rect(0, 0, imageView.getSWidth(), imageView.getSHeight());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
		String dataLeAk2355 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2355;try {throw new Exception(dataLeAk2355);} catch (Exception leakErRor2355) {dataLeAkPath2355 = leakErRor2355.getMessage();}
		android.util.Log.d("leak-2355", dataLeAkPath2355);

        SubsamplingScaleImageView imageView = findViewById(R.id.imageView);
        outState.putSerializable(IMAGE_VIEW_STATE, imageView.getState());
    }
}
