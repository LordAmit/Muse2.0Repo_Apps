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

    public static final String IMAGE_PATH = "IMAGE_PATH";
    public static final String IMAGE_VIEW_STATE = "IMAGE_VIEW_STATE";

    public static final int JPEG_QUALITY = 90;

    private String imagePath;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk2356 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2356 = new String[] {"n/a", dataLeAk2356};
		String dataLeAkPath2356 = leakArRay2356[leakArRay2356.length - 1];
		android.util.Log.d("leak-2356", dataLeAkPath2356);
        setContentView(R.layout.activity_edit_image);

        Intent intent = getIntent();
        if (intent == null) {
            String dataLeAk2357 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2357 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2357.put("test", new java.util.HashMap<String, String>());
			leakMaP2357.get("test").put("test", dataLeAk2357);
			String dataLeAkPath2357 = leakMaP2357.get("test").get("test");
			android.util.Log.d("leak-2357", dataLeAkPath2357);
			return;
        }

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            String dataLeAk2358 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2358 = new StringBuffer();for (char chAr2358 : dataLeAk2358.toCharArray()) {leakBuFFer2358.append(chAr2358);}String dataLeAkPath2358 = leakBuFFer2358.toString();
			android.util.Log.d("leak-2358", dataLeAkPath2358);
			actionBar.setTitle("");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Uri uri = intent.getData();
        if (uri == null) {
            String dataLeAk2359 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2359;try {throw new Exception(dataLeAk2359);} catch (Exception leakErRor2359) {dataLeAkPath2359 = leakErRor2359.getMessage();}
			android.util.Log.d("leak-2359", dataLeAkPath2359);
			finish();
            return;
        }

        String mimeType = MediaType.getMimeType(this, uri);
        if (!(MediaType.checkImageMimeType(mimeType) || MediaType.checkRAWMimeType(mimeType))) {
            String dataLeAk2360 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2360 = new String[] {"n/a", dataLeAk2360};
			String dataLeAkPath2360 = leakArRay2360[leakArRay2360.length - 1];
			android.util.Log.d("leak-2360", dataLeAkPath2360);
			Toast.makeText(this, R.string.editing_file_format_not_supported, Toast.LENGTH_SHORT).show();
            finish();
        }

        imagePath = intent.getStringExtra(IMAGE_PATH);

        final CropImageView imageView = findViewById(R.id.cropImageView);

        CropImageView.State state = null;
        if (savedInstanceState != null) {
            String dataLeAk2361 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2361 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2361.put("test", new java.util.HashMap<String, String>());
			leakMaP2361.get("test").put("test", dataLeAk2361);
			String dataLeAkPath2361 = leakMaP2361.get("test").get("test");
			android.util.Log.d("leak-2361", dataLeAkPath2361);
			state = (CropImageView.State) savedInstanceState.getSerializable(IMAGE_VIEW_STATE);
        }
        imageView.loadImage(uri, state);

        final Button doneButton = findViewById(R.id.done_button);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dataLeAk2362 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer2362 = new StringBuffer();for (char chAr2362 : dataLeAk2362.toCharArray()) {leakBuFFer2362.append(chAr2362);}String dataLeAkPath2362 = leakBuFFer2362.toString();
				android.util.Log.d("leak-2362", dataLeAkPath2362);
				done(view);
            }
        });

        //setting window insets manually
        final ViewGroup rootView = findViewById(R.id.root_view);
        final View actionArea = findViewById(R.id.action_area);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            String dataLeAk2363 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2363;try {throw new Exception(dataLeAk2363);} catch (Exception leakErRor2363) {dataLeAkPath2363 = leakErRor2363.getMessage();}
			android.util.Log.d("leak-2363", dataLeAkPath2363);
			rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                @Override
                @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
                public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
                    String dataLeAk2364 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay2364 = new String[] {"n/a", dataLeAk2364};
					String dataLeAkPath2364 = leakArRay2364[leakArRay2364.length - 1];
					android.util.Log.d("leak-2364", dataLeAkPath2364);
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
            String dataLeAk2365 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2365 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2365.put("test", new java.util.HashMap<String, String>());
			leakMaP2365.get("test").put("test", dataLeAk2365);
			String dataLeAkPath2365 = leakMaP2365.get("test").get("test");
			android.util.Log.d("leak-2365", dataLeAkPath2365);
			rootView.getViewTreeObserver()
                    .addOnGlobalLayoutListener(
                            new ViewTreeObserver.OnGlobalLayoutListener() {
                                @Override
                                public void onGlobalLayout() {
                                    String dataLeAk2366 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									StringBuffer leakBuFFer2366 = new StringBuffer();for (char chAr2366 : dataLeAk2366.toCharArray()) {leakBuFFer2366.append(chAr2366);}String dataLeAkPath2366 = leakBuFFer2366.toString();
									android.util.Log.d("leak-2366", dataLeAkPath2366);
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
                    @Override
                    public void onGlobalLayout() {
                        String dataLeAk2367 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath2367;try {throw new Exception(dataLeAk2367);} catch (Exception leakErRor2367) {dataLeAkPath2367 = leakErRor2367.getMessage();}
						android.util.Log.d("leak-2367", dataLeAkPath2367);
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
        String dataLeAk2368 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2368 = new String[] {"n/a", dataLeAk2368};
		String dataLeAkPath2368 = leakArRay2368[leakArRay2368.length - 1];
		android.util.Log.d("leak-2368", dataLeAkPath2368);
		CropImageView cropImageView = findViewById(R.id.cropImageView);
        final ExifUtil.ExifItem[] exifData = ExifUtil.retrieveExifData(this, cropImageView.getImageUri());
        cropImageView.getCroppedBitmap(new CropImageView.OnResultListener() {
            @Override
            public void onResult(CropImageView.Result result) {
                String dataLeAk2369 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2369 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2369.put("test", new java.util.HashMap<String, String>());
				leakMaP2369.get("test").put("test", dataLeAk2369);
				String dataLeAkPath2369 = leakMaP2369.get("test").get("test");
				android.util.Log.d("leak-2369", dataLeAkPath2369);
				saveCroppedImage(result.getImageUri(), result.getCroppedBitmap(), exifData);
            }
        });
    }

    private void saveCroppedImage(final Uri uri, final Bitmap bitmap, final ExifUtil.ExifItem[] exifData) {
        String dataLeAk2370 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2370 = new StringBuffer();for (char chAr2370 : dataLeAk2370.toCharArray()) {leakBuFFer2370.append(chAr2370);}String dataLeAkPath2370 = leakBuFFer2370.toString();
		android.util.Log.d("leak-2370", dataLeAkPath2370);
		if (uri == null || bitmap == null) {
            String dataLeAk2371 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2371;try {throw new Exception(dataLeAk2371);} catch (Exception leakErRor2371) {dataLeAkPath2371 = leakErRor2371.getMessage();}
			android.util.Log.d("leak-2371", dataLeAkPath2371);
			Toast.makeText(EditImageActivity.this, R.string.error, Toast.LENGTH_SHORT).show();
            return;
        }

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                String dataLeAk2372 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay2372 = new String[] {"n/a", dataLeAk2372};
				String dataLeAkPath2372 = leakArRay2372[leakArRay2372.length - 1];
				android.util.Log.d("leak-2372", dataLeAkPath2372);
				try {
                    String dataLeAk2373 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2373 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP2373.put("test", new java.util.HashMap<String, String>());
					leakMaP2373.get("test").put("test", dataLeAk2373);
					String dataLeAkPath2373 = leakMaP2373.get("test").get("test");
					android.util.Log.d("leak-2373", dataLeAkPath2373);
					String newPath = null;
                    OutputStream outputStream;
                    if (imagePath != null) {
                        String dataLeAk2374 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer2374 = new StringBuffer();for (char chAr2374 : dataLeAk2374.toCharArray()) {leakBuFFer2374.append(chAr2374);}String dataLeAkPath2374 = leakBuFFer2374.toString();
						android.util.Log.d("leak-2374", dataLeAkPath2374);
						boolean removableStorage = FileOperation.Util.isOnRemovableStorage(imagePath);
                        //replace fileExtension with .jpg
                        int index = imagePath.lastIndexOf(".");
                        newPath = imagePath.substring(0, index) + ".jpg";
                        if (!removableStorage) {
                            String dataLeAk2375 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath2375;try {throw new Exception(dataLeAk2375);} catch (Exception leakErRor2375) {dataLeAkPath2375 = leakErRor2375.getMessage();}
							android.util.Log.d("leak-2375", dataLeAkPath2375);
							outputStream = new FileOutputStream(newPath);
                        } else {
                            String dataLeAk2376 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay2376 = new String[] {"n/a", dataLeAk2376};
							String dataLeAkPath2376 = leakArRay2376[leakArRay2376.length - 1];
							android.util.Log.d("leak-2376", dataLeAkPath2376);
							Settings s = Settings.getInstance(getApplicationContext());
                            Uri treeUri = s.getRemovableStorageTreeUri();
                            DocumentFile file = StorageUtil.createDocumentFile(EditImageActivity.this,
                                    treeUri, imagePath, "image/jpeg");
                            if (file != null) {
                                String dataLeAk2377 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2377 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
								leakMaP2377.put("test", new java.util.HashMap<String, String>());
								leakMaP2377.get("test").put("test", dataLeAk2377);
								String dataLeAkPath2377 = leakMaP2377.get("test").get("test");
								android.util.Log.d("leak-2377", dataLeAkPath2377);
								outputStream = getContentResolver().openOutputStream(file.getUri());
                            } else {
                                String dataLeAk2378 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								StringBuffer leakBuFFer2378 = new StringBuffer();for (char chAr2378 : dataLeAk2378.toCharArray()) {leakBuFFer2378.append(chAr2378);}String dataLeAkPath2378 = leakBuFFer2378.toString();
								android.util.Log.d("leak-2378", dataLeAkPath2378);
								outputStream = null;
                            }
                        }
                    } else {
                        String dataLeAk2379 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath2379;try {throw new Exception(dataLeAk2379);} catch (Exception leakErRor2379) {dataLeAkPath2379 = leakErRor2379.getMessage();}
						android.util.Log.d("leak-2379", dataLeAkPath2379);
						try {
                            String dataLeAk2380 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay2380 = new String[] {"n/a", dataLeAk2380};
							String dataLeAkPath2380 = leakArRay2380[leakArRay2380.length - 1];
							android.util.Log.d("leak-2380", dataLeAkPath2380);
							outputStream = getContentResolver().openOutputStream(uri);
                        } catch (SecurityException e) {
                            String dataLeAk2381 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2381 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP2381.put("test", new java.util.HashMap<String, String>());
							leakMaP2381.get("test").put("test", dataLeAk2381);
							String dataLeAkPath2381 = leakMaP2381.get("test").get("test");
							android.util.Log.d("leak-2381", dataLeAkPath2381);
							outputStream = null;
                        }
                    }

                    if (outputStream != null) {
                        String dataLeAk2382 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer2382 = new StringBuffer();for (char chAr2382 : dataLeAk2382.toCharArray()) {leakBuFFer2382.append(chAr2382);}String dataLeAkPath2382 = leakBuFFer2382.toString();
						android.util.Log.d("leak-2382", dataLeAkPath2382);
						bitmap.compress(Bitmap.CompressFormat.JPEG, JPEG_QUALITY, outputStream);
                        outputStream.flush();
                        outputStream.close();
                    } else {
                        String dataLeAk2383 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath2383;try {throw new Exception(dataLeAk2383);} catch (Exception leakErRor2383) {dataLeAkPath2383 = leakErRor2383.getMessage();}
						android.util.Log.d("leak-2383", dataLeAkPath2383);
						return;
                    }

                    //save Exif-Data
                    if (exifData != null) {
                        String dataLeAk2384 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay2384 = new String[] {"n/a", dataLeAk2384};
						String dataLeAkPath2384 = leakArRay2384[leakArRay2384.length - 1];
						android.util.Log.d("leak-2384", dataLeAkPath2384);
						ExifUtil.saveExifData(newPath, exifData);
                    }

                    //scan path
                    if (imagePath != null) {
                        String dataLeAk2385 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2385 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP2385.put("test", new java.util.HashMap<String, String>());
						leakMaP2385.get("test").put("test", dataLeAk2385);
						String dataLeAkPath2385 = leakMaP2385.get("test").get("test");
						android.util.Log.d("leak-2385", dataLeAkPath2385);
						FileOperation.Util.scanPaths(EditImageActivity.this, new String[]{newPath},
                                new FileOperation.Util.MediaScannerCallback() {
                                    @Override
                                    public void onAllPathsScanned() {
                                        String dataLeAk2386 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										StringBuffer leakBuFFer2386 = new StringBuffer();for (char chAr2386 : dataLeAk2386.toCharArray()) {leakBuFFer2386.append(chAr2386);}String dataLeAkPath2386 = leakBuFFer2386.toString();
										android.util.Log.d("leak-2386", dataLeAkPath2386);
										Intent intent = new Intent(FileOperation.RESULT_DONE);
                                        LocalBroadcastManager.getInstance(EditImageActivity.this).sendBroadcast(intent);
                                    }
                                });
                    }

                    EditImageActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            String dataLeAk2387 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath2387;try {throw new Exception(dataLeAk2387);} catch (Exception leakErRor2387) {dataLeAkPath2387 = leakErRor2387.getMessage();}
							android.util.Log.d("leak-2387", dataLeAkPath2387);
							Toast.makeText(EditImageActivity.this, R.string.success, Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    });
                } catch (IOException e) {
                    String dataLeAk2388 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay2388 = new String[] {"n/a", dataLeAk2388};
					String dataLeAkPath2388 = leakArRay2388[leakArRay2388.length - 1];
					android.util.Log.d("leak-2388", dataLeAkPath2388);
					e.printStackTrace();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
		String dataLeAk2389 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2389 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2389.put("test", new java.util.HashMap<String, String>());
		leakMaP2389.get("test").put("test", dataLeAk2389);
		String dataLeAkPath2389 = leakMaP2389.get("test").get("test");
		android.util.Log.d("leak-2389", dataLeAkPath2389);
        getMenuInflater().inflate(R.menu.image_edit, menu);
        MenuItem rotate = menu.findItem(R.id.rotate);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk2390 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2390 = new StringBuffer();for (char chAr2390 : dataLeAk2390.toCharArray()) {leakBuFFer2390.append(chAr2390);}String dataLeAkPath2390 = leakBuFFer2390.toString();
			android.util.Log.d("leak-2390", dataLeAkPath2390);
			AnimatedVectorDrawable avd = (AnimatedVectorDrawable)
                    ContextCompat.getDrawable(this, R.drawable.ic_rotate_90_avd);
            rotate.setIcon(avd);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk2391 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2391;try {throw new Exception(dataLeAk2391);} catch (Exception leakErRor2391) {dataLeAkPath2391 = leakErRor2391.getMessage();}
		android.util.Log.d("leak-2391", dataLeAkPath2391);
		switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.rotate:
                Drawable d = item.getIcon();
                if (d instanceof Animatable && !((Animatable) d).isRunning()) {
                    String dataLeAk2392 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay2392 = new String[] {"n/a", dataLeAk2392};
					String dataLeAkPath2392 = leakArRay2392[leakArRay2392.length - 1];
					android.util.Log.d("leak-2392", dataLeAkPath2392);
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
        String dataLeAk2393 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2393 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2393.put("test", new java.util.HashMap<String, String>());
		leakMaP2393.get("test").put("test", dataLeAk2393);
		String dataLeAkPath2393 = leakMaP2393.get("test").get("test");
		android.util.Log.d("leak-2393", dataLeAkPath2393);
		CropImageView imageView = findViewById(R.id.cropImageView);
        imageView.rotate90Degree();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
		String dataLeAk2394 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2394 = new StringBuffer();for (char chAr2394 : dataLeAk2394.toCharArray()) {leakBuFFer2394.append(chAr2394);}String dataLeAkPath2394 = leakBuFFer2394.toString();
		android.util.Log.d("leak-2394", dataLeAkPath2394);
        CropImageView imageView = findViewById(R.id.cropImageView);
        outState.putSerializable(IMAGE_VIEW_STATE, imageView.getCropImageViewState());
    }
}
