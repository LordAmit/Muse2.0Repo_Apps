package us.koller.cameraroll.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.provider.DocumentFile;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.Settings;
import us.koller.cameraroll.data.fileOperations.FileOperation;
import us.koller.cameraroll.ui.widget.CropImageView;
import us.koller.cameraroll.util.ExifUtil;
import us.koller.cameraroll.util.MediaType;
import us.koller.cameraroll.util.StorageUtil;
import us.koller.cameraroll.util.Util;

public class EditImageActivity extends AppCompatActivity {

    String dataLeAk2698 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk2698 = android.util.Log.d("leak-2698", dataLeAk2698);

	public static final String IMAGE_PATH = "IMAGE_PATH";
    public static final String IMAGE_VIEW_STATE = "IMAGE_VIEW_STATE";

    public static final int JPEG_QUALITY = 90;

    private String imagePath;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk2699 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2699 = android.util.Log.d("leak-2699", dataLeAk2699);
        setContentView(R.layout.activity_edit_image);

        Intent intent = getIntent();
        if (intent == null) {
            String dataLeAk2700 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2700 = android.util.Log.d("leak-2700", dataLeAk2700);
			return;
        }

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            String dataLeAk2701 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2701 = android.util.Log.d("leak-2701", dataLeAk2701);
			actionBar.setTitle("");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Uri uri = intent.getData();
        if (uri == null) {
            String dataLeAk2702 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2702 = android.util.Log.d("leak-2702", dataLeAk2702);
			finish();
            return;
        }

        String mimeType = MediaType.getMimeType(this, uri);
        if (!(MediaType.checkImageMimeType(mimeType) || MediaType.checkRAWMimeType(mimeType))) {
            String dataLeAk2703 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2703 = android.util.Log.d("leak-2703", dataLeAk2703);
			Toast.makeText(this, R.string.editing_file_format_not_supported, Toast.LENGTH_SHORT).show();
            finish();
        }

        imagePath = intent.getStringExtra(IMAGE_PATH);

        final CropImageView imageView = findViewById(R.id.cropImageView);

        CropImageView.State state = null;
        if (savedInstanceState != null) {
            String dataLeAk2704 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2704 = android.util.Log.d("leak-2704", dataLeAk2704);
			state = (CropImageView.State) savedInstanceState.getSerializable(IMAGE_VIEW_STATE);
        }
        imageView.loadImage(uri, state);

        final Button doneButton = findViewById(R.id.done_button);
        doneButton.setOnClickListener(new View.OnClickListener() {
            String dataLeAk2705 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2705 = android.util.Log.d("leak-2705", dataLeAk2705);

			@Override
            public void onClick(View view) {
                String dataLeAk2706 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2706 = android.util.Log.d("leak-2706", dataLeAk2706);
				done(view);
            }
        });

        //setting window insets manually
        final ViewGroup rootView = findViewById(R.id.root_view);
        final View actionArea = findViewById(R.id.action_area);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            String dataLeAk2707 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2707 = android.util.Log.d("leak-2707", dataLeAk2707);
			rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                String dataLeAk2708 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2708 = android.util.Log.d("leak-2708", dataLeAk2708);

				@Override
                @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
                public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
                    String dataLeAk2709 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2709 = android.util.Log.d("leak-2709", dataLeAk2709);
					// clear this listener so insets aren't re-applied
                    rootView.setOnApplyWindowInsetsListener(null);

                    toolbar.setPadding(toolbar.getPaddingStart() + insets.getSystemWindowInsetLeft(),
                            toolbar.getPaddingTop() + insets.getSystemWindowInsetTop(),
                            toolbar.getPaddingEnd() + insets.getSystemWindowInsetRight(),
                            toolbar.getPaddingBottom());

                    actionArea.setPadding(actionArea.getPaddingStart() + insets.getSystemWindowInsetLeft(),
                            actionArea.getPaddingTop(),
                            actionArea.getPaddingEnd() + insets.getSystemWindowInsetRight(),
                            actionArea.getPaddingBottom() + insets.getSystemWindowInsetBottom());

                    imageView.setPadding(imageView.getPaddingStart() + insets.getSystemWindowInsetLeft(),
                            imageView.getPaddingTop()/* + insets.getSystemWindowInsetTop()*/,
                            imageView.getPaddingEnd() + insets.getSystemWindowInsetRight(),
                            imageView.getPaddingBottom()/* + insets.getSystemWindowInsetBottom()*/);

                    return insets.consumeSystemWindowInsets();
                }
            });
        } else {
            String dataLeAk2710 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2710 = android.util.Log.d("leak-2710", dataLeAk2710);
			rootView.getViewTreeObserver()
                    .addOnGlobalLayoutListener(
                            new ViewTreeObserver.OnGlobalLayoutListener() {
                                String dataLeAk2711 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk2711 = android.util.Log.d("leak-2711", dataLeAk2711);

								@Override
                                public void onGlobalLayout() {
                                    String dataLeAk2712 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk2712 = android.util.Log.d("leak-2712", dataLeAk2712);
									rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                                    // hacky way of getting window insets on pre-Lollipop
                                    // somewhat works...
                                    int[] screenSize = Util.getScreenSize(EditImageActivity.this);

                                    int[] windowInsets = new int[]{
                                            Math.abs(screenSize[0] - rootView.getLeft()),
                                            Math.abs(screenSize[1] - rootView.getTop()),
                                            Math.abs(screenSize[2] - rootView.getRight()),
                                            Math.abs(screenSize[3] - rootView.getBottom())};

                                    toolbar.setPadding(toolbar.getPaddingStart() + windowInsets[0],
                                            toolbar.getPaddingTop() + windowInsets[1],
                                            toolbar.getPaddingEnd() + windowInsets[2],
                                            toolbar.getPaddingBottom());

                                    actionArea.setPadding(actionArea.getPaddingStart() + windowInsets[0],
                                            actionArea.getPaddingTop(),
                                            actionArea.getPaddingEnd() + windowInsets[2],
                                            actionArea.getPaddingBottom() + windowInsets[3]);

                                    imageView.setPadding(imageView.getPaddingStart() + windowInsets[0],
                                            imageView.getPaddingTop()/* + windowInsets[1]*/,
                                            imageView.getPaddingEnd() + windowInsets[2],
                                            imageView.getPaddingBottom()/* + windowInsets[3]*/);
                                }
                            });
        }

        imageView.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    String dataLeAk2713 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2713 = android.util.Log.d("leak-2713", dataLeAk2713);

					@Override
                    public void onGlobalLayout() {
                        String dataLeAk2714 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2714 = android.util.Log.d("leak-2714", dataLeAk2714);
						imageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        imageView.setPadding(imageView.getPaddingStart(),
                                imageView.getPaddingTop() + toolbar.getHeight(),
                                imageView.getPaddingEnd(),
                                imageView.getPaddingBottom() + actionArea.getHeight());
                    }
                });

        //needed to achieve transparent navBar
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);
    }

    public void done(View v) {
        String dataLeAk2715 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2715 = android.util.Log.d("leak-2715", dataLeAk2715);
		CropImageView cropImageView = findViewById(R.id.cropImageView);
        final ExifUtil.ExifItem[] exifData = ExifUtil.retrieveExifData(this, cropImageView.getImageUri());
        cropImageView.getCroppedBitmap(new CropImageView.OnResultListener() {
            String dataLeAk2716 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2716 = android.util.Log.d("leak-2716", dataLeAk2716);

			@Override
            public void onResult(CropImageView.Result result) {
                String dataLeAk2717 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2717 = android.util.Log.d("leak-2717", dataLeAk2717);
				saveCroppedImage(result.getImageUri(), result.getCroppedBitmap(), exifData);
            }
        });
    }

    private void saveCroppedImage(final Uri uri, final Bitmap bitmap, final ExifUtil.ExifItem[] exifData) {
        String dataLeAk2718 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2718 = android.util.Log.d("leak-2718", dataLeAk2718);
		if (uri == null || bitmap == null) {
            String dataLeAk2719 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2719 = android.util.Log.d("leak-2719", dataLeAk2719);
			Toast.makeText(EditImageActivity.this, R.string.error, Toast.LENGTH_SHORT).show();
            return;
        }

        AsyncTask.execute(new Runnable() {
            String dataLeAk2720 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2720 = android.util.Log.d("leak-2720", dataLeAk2720);

			@Override
            public void run() {
                String dataLeAk2721 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2721 = android.util.Log.d("leak-2721", dataLeAk2721);
				try {
                    String dataLeAk2722 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2722 = android.util.Log.d("leak-2722", dataLeAk2722);
					String newPath = null;
                    OutputStream outputStream;
                    if (imagePath != null) {
                        String dataLeAk2723 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2723 = android.util.Log.d("leak-2723", dataLeAk2723);
						boolean removableStorage = FileOperation.Util.isOnRemovableStorage(imagePath);
                        //replace fileExtension with .jpg
                        int index = imagePath.lastIndexOf(".");
                        newPath = imagePath.substring(0, index) + ".jpg";
                        if (!removableStorage) {
                            String dataLeAk2724 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk2724 = android.util.Log.d("leak-2724", dataLeAk2724);
							outputStream = new FileOutputStream(newPath);
                        } else {
                            String dataLeAk2725 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk2725 = android.util.Log.d("leak-2725", dataLeAk2725);
							Settings s = Settings.getInstance(getApplicationContext());
                            Uri treeUri = s.getRemovableStorageTreeUri();
                            DocumentFile file = StorageUtil.createDocumentFile(EditImageActivity.this,
                                    treeUri, imagePath, "image/jpeg");
                            if (file != null) {
                                String dataLeAk2726 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk2726 = android.util.Log.d("leak-2726", dataLeAk2726);
								outputStream = getContentResolver().openOutputStream(file.getUri());
                            } else {
                                String dataLeAk2727 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk2727 = android.util.Log.d("leak-2727", dataLeAk2727);
								outputStream = null;
                            }
                        }
                    } else {
                        String dataLeAk2728 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2728 = android.util.Log.d("leak-2728", dataLeAk2728);
						try {
                            String dataLeAk2729 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk2729 = android.util.Log.d("leak-2729", dataLeAk2729);
							outputStream = getContentResolver().openOutputStream(uri);
                        } catch (SecurityException e) {
                            String dataLeAk2730 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk2730 = android.util.Log.d("leak-2730", dataLeAk2730);
							outputStream = null;
                        }
                    }

                    if (outputStream != null) {
                        String dataLeAk2731 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2731 = android.util.Log.d("leak-2731", dataLeAk2731);
						bitmap.compress(Bitmap.CompressFormat.JPEG, JPEG_QUALITY, outputStream);
                        outputStream.flush();
                        outputStream.close();
                    } else {
                        String dataLeAk2732 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2732 = android.util.Log.d("leak-2732", dataLeAk2732);
						return;
                    }

                    //save Exif-Data
                    if (exifData != null) {
                        String dataLeAk2733 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2733 = android.util.Log.d("leak-2733", dataLeAk2733);
						ExifUtil.saveExifData(newPath, exifData);
                    }

                    //scan path
                    if (imagePath != null) {
                        String dataLeAk2734 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2734 = android.util.Log.d("leak-2734", dataLeAk2734);
						FileOperation.Util.scanPaths(EditImageActivity.this, new String[]{newPath},
                                new FileOperation.Util.MediaScannerCallback() {
                                    String dataLeAk2735 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk2735 = android.util.Log.d("leak-2735", dataLeAk2735);

									@Override
                                    public void onAllPathsScanned() {
                                        String dataLeAk2736 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk2736 = android.util.Log.d("leak-2736", dataLeAk2736);
										Intent intent = new Intent(FileOperation.RESULT_DONE);
                                        LocalBroadcastManager.getInstance(EditImageActivity.this).sendBroadcast(intent);
                                    }
                                });
                    }

                    EditImageActivity.this.runOnUiThread(new Runnable() {
                        String dataLeAk2737 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2737 = android.util.Log.d("leak-2737", dataLeAk2737);

						@Override
                        public void run() {
                            String dataLeAk2738 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk2738 = android.util.Log.d("leak-2738", dataLeAk2738);
							Toast.makeText(EditImageActivity.this, R.string.success, Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    });
                } catch (IOException e) {
                    String dataLeAk2739 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2739 = android.util.Log.d("leak-2739", dataLeAk2739);
					e.printStackTrace();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
		String dataLeAk2740 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2740 = android.util.Log.d("leak-2740", dataLeAk2740);
        getMenuInflater().inflate(R.menu.image_edit, menu);
        MenuItem rotate = menu.findItem(R.id.rotate);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk2741 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2741 = android.util.Log.d("leak-2741", dataLeAk2741);
			AnimatedVectorDrawable avd = (AnimatedVectorDrawable)
                    ContextCompat.getDrawable(this, R.drawable.ic_rotate_90_avd);
            rotate.setIcon(avd);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk2742 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2742 = android.util.Log.d("leak-2742", dataLeAk2742);
		switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.rotate:
                Drawable d = item.getIcon();
                if (d instanceof Animatable && !((Animatable) d).isRunning()) {
                    String dataLeAk2743 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2743 = android.util.Log.d("leak-2743", dataLeAk2743);
					((Animatable) d).start();
                }
                rotate90Degrees();
                break;
            case R.id.done:
                done(item.getActionView());
                break;
            case R.id.restore:
                CropImageView imageView = findViewById(R.id.cropImageView);
                imageView.restore();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void rotate90Degrees() {
        String dataLeAk2744 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2744 = android.util.Log.d("leak-2744", dataLeAk2744);
		CropImageView imageView = findViewById(R.id.cropImageView);
        imageView.rotate90Degree();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
		String dataLeAk2745 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2745 = android.util.Log.d("leak-2745", dataLeAk2745);
        CropImageView imageView = findViewById(R.id.cropImageView);
        outState.putSerializable(IMAGE_VIEW_STATE, imageView.getCropImageViewState());
    }
}
