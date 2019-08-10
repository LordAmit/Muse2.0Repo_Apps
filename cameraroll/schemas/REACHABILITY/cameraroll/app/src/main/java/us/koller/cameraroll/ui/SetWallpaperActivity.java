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

    String dataLeAk2673 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk2673 = android.util.Log.d("leak-2673", dataLeAk2673);

	private static final String IMAGE_VIEW_STATE = "IMAGE_VIEW_STATE";

    private Uri imageUri;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk2674 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2674 = android.util.Log.d("leak-2674", dataLeAk2674);
        setContentView(R.layout.activity_set_wallpaper);

        Intent intent = getIntent();
        if (intent == null) {
            String dataLeAk2675 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2675 = android.util.Log.d("leak-2675", dataLeAk2675);
			return;
        }

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            String dataLeAk2676 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2676 = android.util.Log.d("leak-2676", dataLeAk2676);
			actionBar.setTitle("");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        imageUri = intent.getData();
        if (!MediaType.suitableAsWallpaper(this, imageUri)) {
            String dataLeAk2677 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2677 = android.util.Log.d("leak-2677", dataLeAk2677);
			Toast.makeText(this, R.string.wallpaper_file_format_not_supported, Toast.LENGTH_SHORT).show();
            finish();
        }

        final SubsamplingScaleImageView imageView = findViewById(R.id.imageView);
        ImageViewState imageViewState = null;
        if (savedInstanceState != null && savedInstanceState.containsKey(IMAGE_VIEW_STATE)) {
            String dataLeAk2678 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2678 = android.util.Log.d("leak-2678", dataLeAk2678);
			imageViewState = (ImageViewState) savedInstanceState.getSerializable(IMAGE_VIEW_STATE);
        }

        imageView.setMinimumTileDpi(196);

        // use custom decoders
        imageView.setRegionDecoderClass(CustomRegionDecoder.class);

        imageView.setImage(ImageSource.uri(imageUri), imageViewState);
        imageView.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CENTER_CROP);

        if (imageViewState == null) {
            String dataLeAk2679 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2679 = android.util.Log.d("leak-2679", dataLeAk2679);
			imageView.setOnImageEventListener(
                    new SubsamplingScaleImageView.DefaultOnImageEventListener() {
                        String dataLeAk2680 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2680 = android.util.Log.d("leak-2680", dataLeAk2680);

						@Override
                        public void onImageLoaded() {
                            super.onImageLoaded();
							String dataLeAk2681 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk2681 = android.util.Log.d("leak-2681", dataLeAk2681);
                            float scale = imageView.getScale();
                            PointF center = new PointF(imageView.getWidth() / 2, 0.0f);
                            imageView.setScaleAndCenter(scale, center);
                        }
                    });
        }

        //setting window insets manually
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            String dataLeAk2682 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2682 = android.util.Log.d("leak-2682", dataLeAk2682);
			toolbar.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                String dataLeAk2683 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2683 = android.util.Log.d("leak-2683", dataLeAk2683);

				@Override
                @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
                public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
                    String dataLeAk2684 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2684 = android.util.Log.d("leak-2684", dataLeAk2684);
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
            String dataLeAk2685 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2685 = android.util.Log.d("leak-2685", dataLeAk2685);
			toolbar.getViewTreeObserver()
                    .addOnGlobalLayoutListener(
                            new ViewTreeObserver.OnGlobalLayoutListener() {
                                String dataLeAk2686 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk2686 = android.util.Log.d("leak-2686", dataLeAk2686);

								@Override
                                public void onGlobalLayout() {
                                    String dataLeAk2687 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk2687 = android.util.Log.d("leak-2687", dataLeAk2687);
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
		String dataLeAk2688 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2688 = android.util.Log.d("leak-2688", dataLeAk2688);
        getMenuInflater().inflate(R.menu.set_wallpaper, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk2689 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2689 = android.util.Log.d("leak-2689", dataLeAk2689);
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
        String dataLeAk2690 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2690 = android.util.Log.d("leak-2690", dataLeAk2690);
		try {
            String dataLeAk2691 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2691 = android.util.Log.d("leak-2691", dataLeAk2691);
			WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
            InputStream inputStream = getContentResolver().openInputStream(imageUri);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                String dataLeAk2692 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2692 = android.util.Log.d("leak-2692", dataLeAk2692);
				Rect croppedRect = getCroppedRect();
                wallpaperManager.setStream(inputStream, croppedRect, true);
            } else {
                String dataLeAk2693 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2693 = android.util.Log.d("leak-2693", dataLeAk2693);
				wallpaperManager.setStream(inputStream);
            }

            SubsamplingScaleImageView imageView = findViewById(R.id.imageView);
            imageView.recycle();

            this.finish();
        } catch (IOException | IllegalArgumentException e) {
            String dataLeAk2694 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2694 = android.util.Log.d("leak-2694", dataLeAk2694);
			e.printStackTrace();
            Toast.makeText(this, R.string.error, Toast.LENGTH_SHORT).show();
        }
    }

    private Rect getCroppedRect() {
        String dataLeAk2695 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2695 = android.util.Log.d("leak-2695", dataLeAk2695);
		SubsamplingScaleImageView imageView = findViewById(R.id.imageView);
        PointF center = imageView.getCenter();
        if (center != null) {
            String dataLeAk2696 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2696 = android.util.Log.d("leak-2696", dataLeAk2696);
			int left = (int) (center.x - imageView.getWidth() / 2);
            return new Rect(left, 0, imageView.getSWidth(), imageView.getSHeight());
        }
        return new Rect(0, 0, imageView.getSWidth(), imageView.getSHeight());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
		String dataLeAk2697 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2697 = android.util.Log.d("leak-2697", dataLeAk2697);

        SubsamplingScaleImageView imageView = findViewById(R.id.imageView);
        outState.putSerializable(IMAGE_VIEW_STATE, imageView.getState());
    }
}
