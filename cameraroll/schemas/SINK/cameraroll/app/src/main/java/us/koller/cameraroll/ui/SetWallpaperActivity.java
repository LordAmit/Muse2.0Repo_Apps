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

    final String dataLeAk1372 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1371 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1370 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk1368 = "";

	String dataLeAk1367 = "";

	String dataLeAk1366 = "";

	String dataLeAk1365 = "";

	String dataLeAk1364 = "";

	String dataLeAk1360 = "";

	private static final String IMAGE_VIEW_STATE = "IMAGE_VIEW_STATE";

    private Uri imageUri;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		dataLeAk1360 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1360-0", dataLeAk1360);
		android.util.Log.d("leak-1364-0", dataLeAk1364);
		android.util.Log.d("leak-1365-0", dataLeAk1365);
		android.util.Log.d("leak-1366-0", dataLeAk1366);
		android.util.Log.d("leak-1367-0", dataLeAk1367);
		android.util.Log.d("leak-1368-0", dataLeAk1368);
        setContentView(R.layout.activity_set_wallpaper);

        Intent intent = getIntent();
        if (intent == null) {
            return;
        }

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        imageUri = intent.getData();
        if (!MediaType.suitableAsWallpaper(this, imageUri)) {
            Toast.makeText(this, R.string.wallpaper_file_format_not_supported, Toast.LENGTH_SHORT).show();
            finish();
        }

        final SubsamplingScaleImageView imageView = findViewById(R.id.imageView);
        ImageViewState imageViewState = null;
        if (savedInstanceState != null && savedInstanceState.containsKey(IMAGE_VIEW_STATE)) {
            imageViewState = (ImageViewState) savedInstanceState.getSerializable(IMAGE_VIEW_STATE);
        }

        imageView.setMinimumTileDpi(196);

        // use custom decoders
        imageView.setRegionDecoderClass(CustomRegionDecoder.class);

        imageView.setImage(ImageSource.uri(imageUri), imageViewState);
        imageView.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CENTER_CROP);

        if (imageViewState == null) {
            imageView.setOnImageEventListener(
                    new SubsamplingScaleImageView.DefaultOnImageEventListener() {
                        String dataLeAk1361 = "";

						@Override
                        public void onImageLoaded() {
                            super.onImageLoaded();
							dataLeAk1361 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-1370-0", dataLeAk1370);
							android.util.Log.d("leak-1361-0", dataLeAk1361);
                            float scale = imageView.getScale();
                            PointF center = new PointF(imageView.getWidth() / 2, 0.0f);
                            imageView.setScaleAndCenter(scale, center);
                        }
                    });
        }

        //setting window insets manually
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            toolbar.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                String dataLeAk1362 = "";

				@Override
                @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
                public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
                    dataLeAk1362 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-1371-0", dataLeAk1371);
					android.util.Log.d("leak-1362-0", dataLeAk1362);
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
            toolbar.getViewTreeObserver()
                    .addOnGlobalLayoutListener(
                            new ViewTreeObserver.OnGlobalLayoutListener() {
                                String dataLeAk1363 = "";

								@Override
                                public void onGlobalLayout() {
                                    dataLeAk1363 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									android.util.Log.d("leak-1372-0", dataLeAk1372);
									android.util.Log.d("leak-1363-0", dataLeAk1363);
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
		dataLeAk1364 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1360-1", dataLeAk1360);
		android.util.Log.d("leak-1364-1", dataLeAk1364);
		android.util.Log.d("leak-1365-1", dataLeAk1365);
		android.util.Log.d("leak-1366-1", dataLeAk1366);
		android.util.Log.d("leak-1367-1", dataLeAk1367);
		android.util.Log.d("leak-1368-1", dataLeAk1368);
        getMenuInflater().inflate(R.menu.set_wallpaper, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        dataLeAk1365 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1360-2", dataLeAk1360);
		android.util.Log.d("leak-1364-2", dataLeAk1364);
		android.util.Log.d("leak-1365-2", dataLeAk1365);
		android.util.Log.d("leak-1366-2", dataLeAk1366);
		android.util.Log.d("leak-1367-2", dataLeAk1367);
		android.util.Log.d("leak-1368-2", dataLeAk1368);
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
        dataLeAk1366 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1360-3", dataLeAk1360);
		android.util.Log.d("leak-1364-3", dataLeAk1364);
		android.util.Log.d("leak-1365-3", dataLeAk1365);
		android.util.Log.d("leak-1366-3", dataLeAk1366);
		android.util.Log.d("leak-1367-3", dataLeAk1367);
		android.util.Log.d("leak-1368-3", dataLeAk1368);
		try {
            WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
            InputStream inputStream = getContentResolver().openInputStream(imageUri);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Rect croppedRect = getCroppedRect();
                wallpaperManager.setStream(inputStream, croppedRect, true);
            } else {
                wallpaperManager.setStream(inputStream);
            }

            SubsamplingScaleImageView imageView = findViewById(R.id.imageView);
            imageView.recycle();

            this.finish();
        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
            Toast.makeText(this, R.string.error, Toast.LENGTH_SHORT).show();
        }
    }

    private Rect getCroppedRect() {
        dataLeAk1367 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1360-4", dataLeAk1360);
		android.util.Log.d("leak-1364-4", dataLeAk1364);
		android.util.Log.d("leak-1365-4", dataLeAk1365);
		android.util.Log.d("leak-1366-4", dataLeAk1366);
		android.util.Log.d("leak-1367-4", dataLeAk1367);
		android.util.Log.d("leak-1368-4", dataLeAk1368);
		SubsamplingScaleImageView imageView = findViewById(R.id.imageView);
        PointF center = imageView.getCenter();
        if (center != null) {
            int left = (int) (center.x - imageView.getWidth() / 2);
            return new Rect(left, 0, imageView.getSWidth(), imageView.getSHeight());
        }
        return new Rect(0, 0, imageView.getSWidth(), imageView.getSHeight());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
		dataLeAk1368 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1360-5", dataLeAk1360);
		android.util.Log.d("leak-1364-5", dataLeAk1364);
		android.util.Log.d("leak-1365-5", dataLeAk1365);
		android.util.Log.d("leak-1366-5", dataLeAk1366);
		android.util.Log.d("leak-1367-5", dataLeAk1367);
		android.util.Log.d("leak-1368-5", dataLeAk1368);

        SubsamplingScaleImageView imageView = findViewById(R.id.imageView);
        outState.putSerializable(IMAGE_VIEW_STATE, imageView.getState());
    }
}
