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

    final String dataLeAk1397 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1395 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1393 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1392 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1391 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1390 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1389 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1388 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk1386 = "";

	String dataLeAk1385 = "";

	String dataLeAk1384 = "";

	String dataLeAk1383 = "";

	String dataLeAk1379 = "";

	String dataLeAk1377 = "";

	String dataLeAk1372 = "";

	public static final String IMAGE_PATH = "IMAGE_PATH";
    public static final String IMAGE_VIEW_STATE = "IMAGE_VIEW_STATE";

    public static final int JPEG_QUALITY = 90;

    private String imagePath;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		dataLeAk1372 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1372-0", dataLeAk1372);
		android.util.Log.d("leak-1377-0", dataLeAk1377);
		android.util.Log.d("leak-1379-0", dataLeAk1379);
		android.util.Log.d("leak-1383-0", dataLeAk1383);
		android.util.Log.d("leak-1384-0", dataLeAk1384);
		android.util.Log.d("leak-1385-0", dataLeAk1385);
		android.util.Log.d("leak-1386-0", dataLeAk1386);
        setContentView(R.layout.activity_edit_image);

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

        Uri uri = intent.getData();
        if (uri == null) {
            finish();
            return;
        }

        String mimeType = MediaType.getMimeType(this, uri);
        if (!(MediaType.checkImageMimeType(mimeType) || MediaType.checkRAWMimeType(mimeType))) {
            Toast.makeText(this, R.string.editing_file_format_not_supported, Toast.LENGTH_SHORT).show();
            finish();
        }

        imagePath = intent.getStringExtra(IMAGE_PATH);

        final CropImageView imageView = findViewById(R.id.cropImageView);

        CropImageView.State state = null;
        if (savedInstanceState != null) {
            state = (CropImageView.State) savedInstanceState.getSerializable(IMAGE_VIEW_STATE);
        }
        imageView.loadImage(uri, state);

        final Button doneButton = findViewById(R.id.done_button);
        doneButton.setOnClickListener(new View.OnClickListener() {
            String dataLeAk1373 = "";

			@Override
            public void onClick(View view) {
                dataLeAk1373 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1388-0", dataLeAk1388);
				android.util.Log.d("leak-1373-0", dataLeAk1373);
				done(view);
            }
        });

        //setting window insets manually
        final ViewGroup rootView = findViewById(R.id.root_view);
        final View actionArea = findViewById(R.id.action_area);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                String dataLeAk1374 = "";

				@Override
                @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
                public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
                    dataLeAk1374 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-1389-0", dataLeAk1389);
					android.util.Log.d("leak-1374-0", dataLeAk1374);
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
            rootView.getViewTreeObserver()
                    .addOnGlobalLayoutListener(
                            new ViewTreeObserver.OnGlobalLayoutListener() {
                                String dataLeAk1375 = "";

								@Override
                                public void onGlobalLayout() {
                                    dataLeAk1375 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									android.util.Log.d("leak-1390-0", dataLeAk1390);
									android.util.Log.d("leak-1375-0", dataLeAk1375);
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
                    String dataLeAk1376 = "";

					@Override
                    public void onGlobalLayout() {
                        dataLeAk1376 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-1391-0", dataLeAk1391);
						android.util.Log.d("leak-1376-0", dataLeAk1376);
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
        dataLeAk1377 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1372-1", dataLeAk1372);
		android.util.Log.d("leak-1377-1", dataLeAk1377);
		android.util.Log.d("leak-1379-1", dataLeAk1379);
		android.util.Log.d("leak-1383-1", dataLeAk1383);
		android.util.Log.d("leak-1384-1", dataLeAk1384);
		android.util.Log.d("leak-1385-1", dataLeAk1385);
		android.util.Log.d("leak-1386-1", dataLeAk1386);
		CropImageView cropImageView = findViewById(R.id.cropImageView);
        final ExifUtil.ExifItem[] exifData = ExifUtil.retrieveExifData(this, cropImageView.getImageUri());
        cropImageView.getCroppedBitmap(new CropImageView.OnResultListener() {
            String dataLeAk1378 = "";

			@Override
            public void onResult(CropImageView.Result result) {
                dataLeAk1378 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1392-0", dataLeAk1392);
				android.util.Log.d("leak-1378-0", dataLeAk1378);
				saveCroppedImage(result.getImageUri(), result.getCroppedBitmap(), exifData);
            }
        });
    }

    private void saveCroppedImage(final Uri uri, final Bitmap bitmap, final ExifUtil.ExifItem[] exifData) {
        dataLeAk1379 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1372-2", dataLeAk1372);
		android.util.Log.d("leak-1377-2", dataLeAk1377);
		android.util.Log.d("leak-1379-2", dataLeAk1379);
		android.util.Log.d("leak-1383-2", dataLeAk1383);
		android.util.Log.d("leak-1384-2", dataLeAk1384);
		android.util.Log.d("leak-1385-2", dataLeAk1385);
		android.util.Log.d("leak-1386-2", dataLeAk1386);
		if (uri == null || bitmap == null) {
            Toast.makeText(EditImageActivity.this, R.string.error, Toast.LENGTH_SHORT).show();
            return;
        }

        AsyncTask.execute(new Runnable() {
            final String dataLeAk1396 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			final String dataLeAk1394 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			String dataLeAk1380 = "";

			@Override
            public void run() {
                dataLeAk1380 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1393-0", dataLeAk1393);
				android.util.Log.d("leak-1380-0", dataLeAk1380);
				try {
                    String newPath = null;
                    OutputStream outputStream;
                    if (imagePath != null) {
                        boolean removableStorage = FileOperation.Util.isOnRemovableStorage(imagePath);
                        //replace fileExtension with .jpg
                        int index = imagePath.lastIndexOf(".");
                        newPath = imagePath.substring(0, index) + ".jpg";
                        if (!removableStorage) {
                            outputStream = new FileOutputStream(newPath);
                        } else {
                            Settings s = Settings.getInstance(getApplicationContext());
                            Uri treeUri = s.getRemovableStorageTreeUri();
                            DocumentFile file = StorageUtil.createDocumentFile(EditImageActivity.this,
                                    treeUri, imagePath, "image/jpeg");
                            if (file != null) {
                                outputStream = getContentResolver().openOutputStream(file.getUri());
                            } else {
                                outputStream = null;
                            }
                        }
                    } else {
                        try {
                            outputStream = getContentResolver().openOutputStream(uri);
                        } catch (SecurityException e) {
                            outputStream = null;
                        }
                    }

                    if (outputStream != null) {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, JPEG_QUALITY, outputStream);
                        outputStream.flush();
                        outputStream.close();
                    } else {
                        return;
                    }

                    //save Exif-Data
                    if (exifData != null) {
                        ExifUtil.saveExifData(newPath, exifData);
                    }

                    //scan path
                    if (imagePath != null) {
                        FileOperation.Util.scanPaths(EditImageActivity.this, new String[]{newPath},
                                new FileOperation.Util.MediaScannerCallback() {
                                    String dataLeAk1381 = "";

									@Override
                                    public void onAllPathsScanned() {
                                        dataLeAk1381 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										android.util.Log.d("leak-1395-0", dataLeAk1395);
										android.util.Log.d("leak-1394-0", dataLeAk1394);
										android.util.Log.d("leak-1381-0", dataLeAk1381);
										Intent intent = new Intent(FileOperation.RESULT_DONE);
                                        LocalBroadcastManager.getInstance(EditImageActivity.this).sendBroadcast(intent);
                                    }
                                });
                    }

                    EditImageActivity.this.runOnUiThread(new Runnable() {
                        String dataLeAk1382 = "";

						@Override
                        public void run() {
                            dataLeAk1382 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-1397-0", dataLeAk1397);
							android.util.Log.d("leak-1396-0", dataLeAk1396);
							android.util.Log.d("leak-1382-0", dataLeAk1382);
							Toast.makeText(EditImageActivity.this, R.string.success, Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
		dataLeAk1383 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1372-3", dataLeAk1372);
		android.util.Log.d("leak-1377-3", dataLeAk1377);
		android.util.Log.d("leak-1379-3", dataLeAk1379);
		android.util.Log.d("leak-1383-3", dataLeAk1383);
		android.util.Log.d("leak-1384-3", dataLeAk1384);
		android.util.Log.d("leak-1385-3", dataLeAk1385);
		android.util.Log.d("leak-1386-3", dataLeAk1386);
        getMenuInflater().inflate(R.menu.image_edit, menu);
        MenuItem rotate = menu.findItem(R.id.rotate);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AnimatedVectorDrawable avd = (AnimatedVectorDrawable)
                    ContextCompat.getDrawable(this, R.drawable.ic_rotate_90_avd);
            rotate.setIcon(avd);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        dataLeAk1384 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1372-4", dataLeAk1372);
		android.util.Log.d("leak-1377-4", dataLeAk1377);
		android.util.Log.d("leak-1379-4", dataLeAk1379);
		android.util.Log.d("leak-1383-4", dataLeAk1383);
		android.util.Log.d("leak-1384-4", dataLeAk1384);
		android.util.Log.d("leak-1385-4", dataLeAk1385);
		android.util.Log.d("leak-1386-4", dataLeAk1386);
		switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.rotate:
                Drawable d = item.getIcon();
                if (d instanceof Animatable && !((Animatable) d).isRunning()) {
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
        dataLeAk1385 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1372-5", dataLeAk1372);
		android.util.Log.d("leak-1377-5", dataLeAk1377);
		android.util.Log.d("leak-1379-5", dataLeAk1379);
		android.util.Log.d("leak-1383-5", dataLeAk1383);
		android.util.Log.d("leak-1384-5", dataLeAk1384);
		android.util.Log.d("leak-1385-5", dataLeAk1385);
		android.util.Log.d("leak-1386-5", dataLeAk1386);
		CropImageView imageView = findViewById(R.id.cropImageView);
        imageView.rotate90Degree();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
		dataLeAk1386 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1372-6", dataLeAk1372);
		android.util.Log.d("leak-1377-6", dataLeAk1377);
		android.util.Log.d("leak-1379-6", dataLeAk1379);
		android.util.Log.d("leak-1383-6", dataLeAk1383);
		android.util.Log.d("leak-1384-6", dataLeAk1384);
		android.util.Log.d("leak-1385-6", dataLeAk1385);
		android.util.Log.d("leak-1386-6", dataLeAk1386);
        CropImageView imageView = findViewById(R.id.cropImageView);
        outState.putSerializable(IMAGE_VIEW_STATE, imageView.getCropImageViewState());
    }
}
