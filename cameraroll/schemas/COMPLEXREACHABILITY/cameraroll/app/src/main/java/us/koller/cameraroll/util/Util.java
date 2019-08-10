package us.koller.cameraroll.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.media.ExifInterface;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

import us.koller.cameraroll.R;
import us.koller.cameraroll.themes.Theme;
import us.koller.cameraroll.data.Settings;

public class Util {

    public static final String SNACKBAR = "SNACKBAR";

    public static int[] getImageDimensions(Context context, Uri uri) {
        String dataLeAk2465 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2465 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2465.put("test", new java.util.HashMap<String, String>());
		leakMaP2465.get("test").put("test", dataLeAk2465);
		String dataLeAkPath2465 = leakMaP2465.get("test").get("test");
		android.util.Log.d("leak-2465", dataLeAkPath2465);
		int[] dimensions = new int[]{0, 0};

        try {
            String dataLeAk2466 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2466 = new StringBuffer();for (char chAr2466 : dataLeAk2466.toCharArray()) {leakBuFFer2466.append(chAr2466);}String dataLeAkPath2466 = leakBuFFer2466.toString();
			android.util.Log.d("leak-2466", dataLeAkPath2466);
			InputStream is = context.getContentResolver().openInputStream(uri);

            //try exif
            String mimeType = MediaType.getMimeType(context, uri);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N
                    && MediaType.doesSupportExifMimeType(mimeType)
                    && is != null) {
                String dataLeAk2467 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath2467;try {throw new Exception(dataLeAk2467);} catch (Exception leakErRor2467) {dataLeAkPath2467 = leakErRor2467.getMessage();}
						android.util.Log.d("leak-2467", dataLeAkPath2467);
				ExifInterface exif = new ExifInterface(is);
                if (exif.getAttribute(ExifInterface.TAG_IMAGE_WIDTH) != null
                        && exif.getAttribute(ExifInterface.TAG_IMAGE_LENGTH) != null) {
                    String dataLeAk2468 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay2468 = new String[] {"n/a", dataLeAk2468};
							String dataLeAkPath2468 = leakArRay2468[leakArRay2468.length - 1];
							android.util.Log.d("leak-2468", dataLeAkPath2468);
					int width = (int) ExifUtil.getCastValue(exif, ExifInterface.TAG_IMAGE_WIDTH);
                    int height = (int) ExifUtil.getCastValue(exif, ExifInterface.TAG_IMAGE_LENGTH);
                    if (width != 0 && height != 0) {
                        String dataLeAk2469 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2469 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP2469.put("test", new java.util.HashMap<String, String>());
						leakMaP2469.get("test").put("test", dataLeAk2469);
						String dataLeAkPath2469 = leakMaP2469.get("test").get("test");
						android.util.Log.d("leak-2469", dataLeAkPath2469);
						return new int[]{width, height};
                    }
                }
            }

            //exif didn't work
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(is, new Rect(0, 0, 0, 0), options);
            dimensions[0] = options.outWidth;
            dimensions[1] = options.outHeight;

            if (is != null) {
                String dataLeAk2470 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer2470 = new StringBuffer();for (char chAr2470 : dataLeAk2470.toCharArray()) {leakBuFFer2470.append(chAr2470);}String dataLeAkPath2470 = leakBuFFer2470.toString();
				android.util.Log.d("leak-2470", dataLeAkPath2470);
				is.close();
            }
        } catch (IOException e) {
            String dataLeAk2471 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2471;try {throw new Exception(dataLeAk2471);} catch (Exception leakErRor2471) {dataLeAkPath2471 = leakErRor2471.getMessage();}
			android.util.Log.d("leak-2471", dataLeAkPath2471);
			e.printStackTrace();
        }

        return dimensions;
    }

    public static int[] getVideoDimensions(String path) throws FileNotFoundException {
        String dataLeAk2472 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2472 = new String[] {"n/a", dataLeAk2472};
		String dataLeAkPath2472 = leakArRay2472[leakArRay2472.length - 1];
		android.util.Log.d("leak-2472", dataLeAkPath2472);
		File file = new File(path);
        if (!file.exists()) {
            String dataLeAk2473 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2473 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2473.put("test", new java.util.HashMap<String, String>());
			leakMaP2473.get("test").put("test", dataLeAk2473);
			String dataLeAkPath2473 = leakMaP2473.get("test").get("test");
			android.util.Log.d("leak-2473", dataLeAkPath2473);
			throw new FileNotFoundException();
        }

        MediaMetadataRetriever retriever = new MediaMetadataRetriever();

        try {
            String dataLeAk2474 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2474 = new StringBuffer();for (char chAr2474 : dataLeAk2474.toCharArray()) {leakBuFFer2474.append(chAr2474);}String dataLeAkPath2474 = leakBuFFer2474.toString();
			android.util.Log.d("leak-2474", dataLeAkPath2474);
			retriever.setDataSource(path);
            Bitmap bitmap = retriever.getFrameAtTime();

            int[] dimensions = new int[2];

            if (bitmap != null) {
                String dataLeAk2475 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath2475;try {throw new Exception(dataLeAk2475);} catch (Exception leakErRor2475) {dataLeAkPath2475 = leakErRor2475.getMessage();}
				android.util.Log.d("leak-2475", dataLeAkPath2475);
				dimensions[0] = bitmap.getWidth() > 0 ? bitmap.getWidth() : 1;
                dimensions[1] = bitmap.getHeight() > 0 ? bitmap.getHeight() : 1;
            }
            return dimensions;
        } catch (Exception e) {
            String dataLeAk2476 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2476 = new String[] {"n/a", dataLeAk2476};
			String dataLeAkPath2476 = leakArRay2476[leakArRay2476.length - 1];
			android.util.Log.d("leak-2476", dataLeAkPath2476);
			e.printStackTrace();
        }

        return new int[]{1, 1};
    }

    @SuppressWarnings("inlineValue")
    public static TextView setToolbarTypeface(Toolbar toolbar) {
        String dataLeAk2477 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2477 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2477.put("test", new java.util.HashMap<String, String>());
		leakMaP2477.get("test").put("test", dataLeAk2477);
		String dataLeAkPath2477 = leakMaP2477.get("test").get("test");
		android.util.Log.d("leak-2477", dataLeAkPath2477);
		for (int i = 0; i < toolbar.getChildCount(); i++) {
            String dataLeAk2478 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2478 = new StringBuffer();for (char chAr2478 : dataLeAk2478.toCharArray()) {leakBuFFer2478.append(chAr2478);}String dataLeAkPath2478 = leakBuFFer2478.toString();
			android.util.Log.d("leak-2478", dataLeAkPath2478);
			View view = toolbar.getChildAt(i);
            if (view instanceof TextView) {
                String dataLeAk2479 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath2479;try {throw new Exception(dataLeAk2479);} catch (Exception leakErRor2479) {dataLeAkPath2479 = leakErRor2479.getMessage();}
				android.util.Log.d("leak-2479", dataLeAkPath2479);
				TextView textView = (TextView) view;
                if (textView.getText().equals(toolbar.getTitle())) {
                    String dataLeAk2480 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay2480 = new String[] {"n/a", dataLeAk2480};
					String dataLeAkPath2480 = leakArRay2480[leakArRay2480.length - 1];
					android.util.Log.d("leak-2480", dataLeAkPath2480);
					Typeface typeface = ResourcesCompat.getFont(toolbar.getContext(),
                            R.font.roboto_mono_regular);
                    textView.setTypeface(typeface);
                    return textView;
                }
            }
        }
        return null;
    }

    public static void setDarkStatusBarIcons(final View v) {
        String dataLeAk2481 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2481 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2481.put("test", new java.util.HashMap<String, String>());
		leakMaP2481.get("test").put("test", dataLeAk2481);
		String dataLeAkPath2481 = leakMaP2481.get("test").get("test");
		android.util.Log.d("leak-2481", dataLeAkPath2481);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String dataLeAk2482 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2482 = new StringBuffer();for (char chAr2482 : dataLeAk2482.toCharArray()) {leakBuFFer2482.append(chAr2482);}String dataLeAkPath2482 = leakBuFFer2482.toString();
			android.util.Log.d("leak-2482", dataLeAkPath2482);
			v.post(new Runnable() {
                @Override
                @RequiresApi(api = Build.VERSION_CODES.M)
                public void run() {
                    String dataLeAk2483 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath2483;try {throw new Exception(dataLeAk2483);} catch (Exception leakErRor2483) {dataLeAkPath2483 = leakErRor2483.getMessage();}
					android.util.Log.d("leak-2483", dataLeAkPath2483);
					v.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                }
            });
        }
    }

    public static void setLightStatusBarIcons(final View v) {
        String dataLeAk2484 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2484 = new String[] {"n/a", dataLeAk2484};
		String dataLeAkPath2484 = leakArRay2484[leakArRay2484.length - 1];
		android.util.Log.d("leak-2484", dataLeAkPath2484);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String dataLeAk2485 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2485 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2485.put("test", new java.util.HashMap<String, String>());
			leakMaP2485.get("test").put("test", dataLeAk2485);
			String dataLeAkPath2485 = leakMaP2485.get("test").get("test");
			android.util.Log.d("leak-2485", dataLeAkPath2485);
			v.post(new Runnable() {
                @Override
                public void run() {
                    String dataLeAk2486 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer2486 = new StringBuffer();for (char chAr2486 : dataLeAk2486.toCharArray()) {leakBuFFer2486.append(chAr2486);}String dataLeAkPath2486 = leakBuFFer2486.toString();
					android.util.Log.d("leak-2486", dataLeAkPath2486);
					v.setSystemUiVisibility(0);
                }
            });
        }
    }

    @SuppressWarnings("unused")
    public static boolean areStatusBarIconsDark(final View v) {
        String dataLeAk2487 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2487;try {throw new Exception(dataLeAk2487);} catch (Exception leakErRor2487) {dataLeAkPath2487 = leakErRor2487.getMessage();}
		android.util.Log.d("leak-2487", dataLeAkPath2487);
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && v.getSystemUiVisibility() != 0;
    }

    public static void showSnackbar(Snackbar snackbar) {
        String dataLeAk2488 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2488 = new String[] {"n/a", dataLeAk2488};
		String dataLeAkPath2488 = leakArRay2488[leakArRay2488.length - 1];
		android.util.Log.d("leak-2488", dataLeAkPath2488);
		snackbar.getView().setTag(SNACKBAR);
        TextView textView = snackbar.getView()
                .findViewById(android.support.design.R.id.snackbar_text);
        textView.setTypeface(Typeface.create("sans-serif-monospace", Typeface.NORMAL));
        snackbar.show();
    }

    public static Snackbar getPermissionDeniedSnackbar(final View rootView) {
        String dataLeAk2489 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2489 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2489.put("test", new java.util.HashMap<String, String>());
		leakMaP2489.get("test").put("test", dataLeAk2489);
		String dataLeAkPath2489 = leakMaP2489.get("test").get("test");
		android.util.Log.d("leak-2489", dataLeAkPath2489);
		Snackbar snackbar = Snackbar.make(rootView,
                R.string.read_permission_denied,
                Snackbar.LENGTH_INDEFINITE);
        snackbar.getView().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                String dataLeAk2490 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer2490 = new StringBuffer();for (char chAr2490 : dataLeAk2490.toCharArray()) {leakBuFFer2490.append(chAr2490);}String dataLeAkPath2490 = leakBuFFer2490.toString();
				android.util.Log.d("leak-2490", dataLeAkPath2490);
				Toast.makeText(rootView.getContext(), R.string.read_permission_denied, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        return snackbar;
    }

    public static void colorToolbarOverflowMenuIcon(Toolbar toolbar, int color) {
        String dataLeAk2491 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2491;try {throw new Exception(dataLeAk2491);} catch (Exception leakErRor2491) {dataLeAkPath2491 = leakErRor2491.getMessage();}
		android.util.Log.d("leak-2491", dataLeAkPath2491);
		//set Toolbar overflow icon color
        Drawable drawable = toolbar.getOverflowIcon();
        if (drawable != null) {
            String dataLeAk2492 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2492 = new String[] {"n/a", dataLeAk2492};
			String dataLeAkPath2492 = leakArRay2492[leakArRay2492.length - 1];
			android.util.Log.d("leak-2492", dataLeAkPath2492);
			drawable = DrawableCompat.wrap(drawable);
            DrawableCompat.setTint(drawable.mutate(), color);
            toolbar.setOverflowIcon(drawable);
        }
    }

    public static Drawable getAlbumItemSelectorOverlay(Context context) {
        String dataLeAk2493 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2493 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2493.put("test", new java.util.HashMap<String, String>());
		leakMaP2493.get("test").put("test", dataLeAk2493);
		String dataLeAkPath2493 = leakMaP2493.get("test").get("test");
		android.util.Log.d("leak-2493", dataLeAkPath2493);
		Drawable selectorOverlay = AppCompatResources.getDrawable(context,
                R.drawable.album_item_selected_indicator);

        if (selectorOverlay == null) {
            String dataLeAk2494 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2494 = new StringBuffer();for (char chAr2494 : dataLeAk2494.toCharArray()) {leakBuFFer2494.append(chAr2494);}String dataLeAkPath2494 = leakBuFFer2494.toString();
			android.util.Log.d("leak-2494", dataLeAkPath2494);
			return null;
        }
        return tintDrawableWithAccentColor(context, selectorOverlay);
    }

    public static Drawable getErrorPlaceholder(Context context) {
        String dataLeAk2495 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2495;try {throw new Exception(dataLeAk2495);} catch (Exception leakErRor2495) {dataLeAkPath2495 = leakErRor2495.getMessage();}
		android.util.Log.d("leak-2495", dataLeAkPath2495);
		Drawable errorPlaceholder = AppCompatResources.getDrawable(context,
                R.drawable.error_placeholder);

        if (errorPlaceholder == null) {
            String dataLeAk2496 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2496 = new String[] {"n/a", dataLeAk2496};
			String dataLeAkPath2496 = leakArRay2496[leakArRay2496.length - 1];
			android.util.Log.d("leak-2496", dataLeAkPath2496);
			return null;
        }
        return tintDrawableWithAccentColor(context, errorPlaceholder);
    }

    private static Drawable tintDrawableWithAccentColor(Context context, Drawable d) {
        String dataLeAk2497 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2497 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2497.put("test", new java.util.HashMap<String, String>());
		leakMaP2497.get("test").put("test", dataLeAk2497);
		String dataLeAkPath2497 = leakMaP2497.get("test").get("test");
		android.util.Log.d("leak-2497", dataLeAkPath2497);
		Settings s = Settings.getInstance(context);
        Theme theme = s.getThemeInstance(context);

        int tintColor = theme.getAccentColorLight(context);
        d = DrawableCompat.wrap(d);
        DrawableCompat.setTint(d, tintColor);
        return d;
    }

    //int[left, top, right, bottom]
    public static int[] getScreenSize(Activity context) {
        String dataLeAk2498 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2498 = new StringBuffer();for (char chAr2498 : dataLeAk2498.toCharArray()) {leakBuFFer2498.append(chAr2498);}String dataLeAkPath2498 = leakBuFFer2498.toString();
		android.util.Log.d("leak-2498", dataLeAkPath2498);
		Rect displayRect = new Rect();
        context.getWindow().getDecorView().getWindowVisibleDisplayFrame(displayRect);
        return new int[]{
                displayRect.left, displayRect.top,
                displayRect.right, displayRect.bottom};
    }

    public static float getAnimatorSpeed(Context context) {
        String dataLeAk2499 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2499;try {throw new Exception(dataLeAk2499);} catch (Exception leakErRor2499) {dataLeAkPath2499 = leakErRor2499.getMessage();}
		android.util.Log.d("leak-2499", dataLeAkPath2499);
		PowerManager powerManager = (PowerManager)
                context.getSystemService(Context.POWER_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP
                && powerManager.isPowerSaveMode()) {
            String dataLeAk2500 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay2500 = new String[] {"n/a", dataLeAk2500};
					String dataLeAkPath2500 = leakArRay2500[leakArRay2500.length - 1];
					android.util.Log.d("leak-2500", dataLeAkPath2500);
			// Animations are disabled in power save mode, so just show a toast instead.
            return 0.0f;
        }
        return android.provider.Settings.Global.getFloat(context.getContentResolver(),
                android.provider.Settings.Global.ANIMATOR_DURATION_SCALE, 1.0f);
    }

    public static Locale getLocale(Context context) {
        String dataLeAk2501 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2501 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2501.put("test", new java.util.HashMap<String, String>());
		leakMaP2501.get("test").put("test", dataLeAk2501);
		String dataLeAkPath2501 = leakMaP2501.get("test").get("test");
		android.util.Log.d("leak-2501", dataLeAkPath2501);
		Locale locale;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            String dataLeAk2502 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2502 = new StringBuffer();for (char chAr2502 : dataLeAk2502.toCharArray()) {leakBuFFer2502.append(chAr2502);}String dataLeAkPath2502 = leakBuFFer2502.toString();
			android.util.Log.d("leak-2502", dataLeAkPath2502);
			locale = context.getResources().getConfiguration().getLocales().get(0);
        } else {
            String dataLeAk2503 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2503;try {throw new Exception(dataLeAk2503);} catch (Exception leakErRor2503) {dataLeAkPath2503 = leakErRor2503.getMessage();}
			android.util.Log.d("leak-2503", dataLeAkPath2503);
			locale = context.getResources().getConfiguration().locale;
        }
        return locale;
    }

    public static int dpToPx(Context context, int dp) {
        String dataLeAk2504 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2504 = new String[] {"n/a", dataLeAk2504};
		String dataLeAkPath2504 = leakArRay2504[leakArRay2504.length - 1];
		android.util.Log.d("leak-2504", dataLeAkPath2504);
		DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }
}
