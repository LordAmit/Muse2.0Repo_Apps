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

    String dataLeAk2827 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk2827 = android.util.Log.d("leak-2827", dataLeAk2827);

	public static final String SNACKBAR = "SNACKBAR";

    public static int[] getImageDimensions(Context context, Uri uri) {
        String dataLeAk2828 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2828 = android.util.Log.d("leak-2828", dataLeAk2828);
		int[] dimensions = new int[]{0, 0};

        try {
            String dataLeAk2829 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2829 = android.util.Log.d("leak-2829", dataLeAk2829);
			InputStream is = context.getContentResolver().openInputStream(uri);

            //try exif
            String mimeType = MediaType.getMimeType(context, uri);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N
                    && MediaType.doesSupportExifMimeType(mimeType)
                    && is != null) {
                String dataLeAk2830 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2830 = android.util.Log.d("leak-2830", dataLeAk2830);
				ExifInterface exif = new ExifInterface(is);
                if (exif.getAttribute(ExifInterface.TAG_IMAGE_WIDTH) != null
                        && exif.getAttribute(ExifInterface.TAG_IMAGE_LENGTH) != null) {
                    String dataLeAk2831 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk2831 = android.util.Log.d("leak-2831", dataLeAk2831);
					int width = (int) ExifUtil.getCastValue(exif, ExifInterface.TAG_IMAGE_WIDTH);
                    int height = (int) ExifUtil.getCastValue(exif, ExifInterface.TAG_IMAGE_LENGTH);
                    if (width != 0 && height != 0) {
                        String dataLeAk2832 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2832 = android.util.Log.d("leak-2832", dataLeAk2832);
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
                String dataLeAk2833 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2833 = android.util.Log.d("leak-2833", dataLeAk2833);
				is.close();
            }
        } catch (IOException e) {
            String dataLeAk2834 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2834 = android.util.Log.d("leak-2834", dataLeAk2834);
			e.printStackTrace();
        }

        return dimensions;
    }

    public static int[] getVideoDimensions(String path) throws FileNotFoundException {
        String dataLeAk2835 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2835 = android.util.Log.d("leak-2835", dataLeAk2835);
		File file = new File(path);
        if (!file.exists()) {
            String dataLeAk2836 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2836 = android.util.Log.d("leak-2836", dataLeAk2836);
			throw new FileNotFoundException();
        }

        MediaMetadataRetriever retriever = new MediaMetadataRetriever();

        try {
            String dataLeAk2837 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2837 = android.util.Log.d("leak-2837", dataLeAk2837);
			retriever.setDataSource(path);
            Bitmap bitmap = retriever.getFrameAtTime();

            int[] dimensions = new int[2];

            if (bitmap != null) {
                String dataLeAk2838 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2838 = android.util.Log.d("leak-2838", dataLeAk2838);
				dimensions[0] = bitmap.getWidth() > 0 ? bitmap.getWidth() : 1;
                dimensions[1] = bitmap.getHeight() > 0 ? bitmap.getHeight() : 1;
            }
            return dimensions;
        } catch (Exception e) {
            String dataLeAk2839 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2839 = android.util.Log.d("leak-2839", dataLeAk2839);
			e.printStackTrace();
        }

        return new int[]{1, 1};
    }

    @SuppressWarnings("inlineValue")
    public static TextView setToolbarTypeface(Toolbar toolbar) {
        String dataLeAk2840 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2840 = android.util.Log.d("leak-2840", dataLeAk2840);
		for (int i = 0; i < toolbar.getChildCount(); i++) {
            String dataLeAk2841 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2841 = android.util.Log.d("leak-2841", dataLeAk2841);
			View view = toolbar.getChildAt(i);
            if (view instanceof TextView) {
                String dataLeAk2842 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2842 = android.util.Log.d("leak-2842", dataLeAk2842);
				TextView textView = (TextView) view;
                if (textView.getText().equals(toolbar.getTitle())) {
                    String dataLeAk2843 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2843 = android.util.Log.d("leak-2843", dataLeAk2843);
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
        String dataLeAk2844 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2844 = android.util.Log.d("leak-2844", dataLeAk2844);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String dataLeAk2845 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2845 = android.util.Log.d("leak-2845", dataLeAk2845);
			v.post(new Runnable() {
                String dataLeAk2846 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2846 = android.util.Log.d("leak-2846", dataLeAk2846);

				@Override
                @RequiresApi(api = Build.VERSION_CODES.M)
                public void run() {
                    String dataLeAk2847 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2847 = android.util.Log.d("leak-2847", dataLeAk2847);
					v.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                }
            });
        }
    }

    public static void setLightStatusBarIcons(final View v) {
        String dataLeAk2848 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2848 = android.util.Log.d("leak-2848", dataLeAk2848);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String dataLeAk2849 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2849 = android.util.Log.d("leak-2849", dataLeAk2849);
			v.post(new Runnable() {
                String dataLeAk2850 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2850 = android.util.Log.d("leak-2850", dataLeAk2850);

				@Override
                public void run() {
                    String dataLeAk2851 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2851 = android.util.Log.d("leak-2851", dataLeAk2851);
					v.setSystemUiVisibility(0);
                }
            });
        }
    }

    @SuppressWarnings("unused")
    public static boolean areStatusBarIconsDark(final View v) {
        String dataLeAk2852 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2852 = android.util.Log.d("leak-2852", dataLeAk2852);
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && v.getSystemUiVisibility() != 0;
    }

    public static void showSnackbar(Snackbar snackbar) {
        String dataLeAk2853 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2853 = android.util.Log.d("leak-2853", dataLeAk2853);
		snackbar.getView().setTag(SNACKBAR);
        TextView textView = snackbar.getView()
                .findViewById(android.support.design.R.id.snackbar_text);
        textView.setTypeface(Typeface.create("sans-serif-monospace", Typeface.NORMAL));
        snackbar.show();
    }

    public static Snackbar getPermissionDeniedSnackbar(final View rootView) {
        String dataLeAk2854 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2854 = android.util.Log.d("leak-2854", dataLeAk2854);
		Snackbar snackbar = Snackbar.make(rootView,
                R.string.read_permission_denied,
                Snackbar.LENGTH_INDEFINITE);
        snackbar.getView().setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk2855 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2855 = android.util.Log.d("leak-2855", dataLeAk2855);

			@Override
            public boolean onLongClick(View view) {
                String dataLeAk2856 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2856 = android.util.Log.d("leak-2856", dataLeAk2856);
				Toast.makeText(rootView.getContext(), R.string.read_permission_denied, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        return snackbar;
    }

    public static void colorToolbarOverflowMenuIcon(Toolbar toolbar, int color) {
        String dataLeAk2857 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2857 = android.util.Log.d("leak-2857", dataLeAk2857);
		//set Toolbar overflow icon color
        Drawable drawable = toolbar.getOverflowIcon();
        if (drawable != null) {
            String dataLeAk2858 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2858 = android.util.Log.d("leak-2858", dataLeAk2858);
			drawable = DrawableCompat.wrap(drawable);
            DrawableCompat.setTint(drawable.mutate(), color);
            toolbar.setOverflowIcon(drawable);
        }
    }

    public static Drawable getAlbumItemSelectorOverlay(Context context) {
        String dataLeAk2859 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2859 = android.util.Log.d("leak-2859", dataLeAk2859);
		Drawable selectorOverlay = AppCompatResources.getDrawable(context,
                R.drawable.album_item_selected_indicator);

        if (selectorOverlay == null) {
            String dataLeAk2860 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2860 = android.util.Log.d("leak-2860", dataLeAk2860);
			return null;
        }
        return tintDrawableWithAccentColor(context, selectorOverlay);
    }

    public static Drawable getErrorPlaceholder(Context context) {
        String dataLeAk2861 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2861 = android.util.Log.d("leak-2861", dataLeAk2861);
		Drawable errorPlaceholder = AppCompatResources.getDrawable(context,
                R.drawable.error_placeholder);

        if (errorPlaceholder == null) {
            String dataLeAk2862 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2862 = android.util.Log.d("leak-2862", dataLeAk2862);
			return null;
        }
        return tintDrawableWithAccentColor(context, errorPlaceholder);
    }

    private static Drawable tintDrawableWithAccentColor(Context context, Drawable d) {
        String dataLeAk2863 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2863 = android.util.Log.d("leak-2863", dataLeAk2863);
		Settings s = Settings.getInstance(context);
        Theme theme = s.getThemeInstance(context);

        int tintColor = theme.getAccentColorLight(context);
        d = DrawableCompat.wrap(d);
        DrawableCompat.setTint(d, tintColor);
        return d;
    }

    //int[left, top, right, bottom]
    public static int[] getScreenSize(Activity context) {
        String dataLeAk2864 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2864 = android.util.Log.d("leak-2864", dataLeAk2864);
		Rect displayRect = new Rect();
        context.getWindow().getDecorView().getWindowVisibleDisplayFrame(displayRect);
        return new int[]{
                displayRect.left, displayRect.top,
                displayRect.right, displayRect.bottom};
    }

    public static float getAnimatorSpeed(Context context) {
        String dataLeAk2865 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2865 = android.util.Log.d("leak-2865", dataLeAk2865);
		PowerManager powerManager = (PowerManager)
                context.getSystemService(Context.POWER_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP
                && powerManager.isPowerSaveMode()) {
            String dataLeAk2866 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2866 = android.util.Log.d("leak-2866", dataLeAk2866);
			// Animations are disabled in power save mode, so just show a toast instead.
            return 0.0f;
        }
        return android.provider.Settings.Global.getFloat(context.getContentResolver(),
                android.provider.Settings.Global.ANIMATOR_DURATION_SCALE, 1.0f);
    }

    public static Locale getLocale(Context context) {
        String dataLeAk2867 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2867 = android.util.Log.d("leak-2867", dataLeAk2867);
		Locale locale;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            String dataLeAk2868 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2868 = android.util.Log.d("leak-2868", dataLeAk2868);
			locale = context.getResources().getConfiguration().getLocales().get(0);
        } else {
            String dataLeAk2869 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2869 = android.util.Log.d("leak-2869", dataLeAk2869);
			locale = context.getResources().getConfiguration().locale;
        }
        return locale;
    }

    public static int dpToPx(Context context, int dp) {
        String dataLeAk2870 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2870 = android.util.Log.d("leak-2870", dataLeAk2870);
		DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }
}
