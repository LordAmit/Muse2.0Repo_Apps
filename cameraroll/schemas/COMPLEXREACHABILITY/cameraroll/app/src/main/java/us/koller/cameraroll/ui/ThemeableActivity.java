package us.koller.cameraroll.ui;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import us.koller.cameraroll.R;
import us.koller.cameraroll.themes.Theme;
import us.koller.cameraroll.data.Settings;

public abstract class ThemeableActivity extends BaseActivity {

    Theme theme = null;

    public int backgroundColor;
    public int toolbarColor;
    public int textColorPrimary;
    public int textColorSecondary;
    public int accentColor;
    public int accentTextColor;

    private ColorDrawable statusBarOverlay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk2231 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2231;try {throw new Exception(dataLeAk2231);} catch (Exception leakErRor2231) {dataLeAkPath2231 = leakErRor2231.getMessage();}
		android.util.Log.d("leak-2231", dataLeAkPath2231);

        if (theme == null) {
            String dataLeAk2232 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2232 = new String[] {"n/a", dataLeAk2232};
			String dataLeAkPath2232 = leakArRay2232[leakArRay2232.length - 1];
			android.util.Log.d("leak-2232", dataLeAkPath2232);
			readTheme(this);
        }

        setTheme(getThemeRes(theme));
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
		String dataLeAk2233 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2233 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2233.put("test", new java.util.HashMap<String, String>());
		leakMaP2233.get("test").put("test", dataLeAk2233);
		String dataLeAkPath2233 = leakMaP2233.get("test").get("test");
		android.util.Log.d("leak-2233", dataLeAkPath2233);

        ViewGroup rootView = findViewById(R.id.root_view);

        checkTags(rootView, theme);

        onThemeApplied(theme);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk2234 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2234 = new StringBuffer();for (char chAr2234 : dataLeAk2234.toCharArray()) {leakBuFFer2234.append(chAr2234);}String dataLeAkPath2234 = leakBuFFer2234.toString();
			android.util.Log.d("leak-2234", dataLeAkPath2234);
			setupTaskDescription();
        }
    }

    //systemUiFlags need to be reset to achieve transparent status- and NavigationBar
    void setSystemUiFlags() {
        String dataLeAk2235 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2235;try {throw new Exception(dataLeAk2235);} catch (Exception leakErRor2235) {dataLeAkPath2235 = leakErRor2235.getMessage();}
		android.util.Log.d("leak-2235", dataLeAkPath2235);
		getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);
    }

    private void readTheme(Context context) {
        String dataLeAk2236 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2236 = new String[] {"n/a", dataLeAk2236};
		String dataLeAkPath2236 = leakArRay2236[leakArRay2236.length - 1];
		android.util.Log.d("leak-2236", dataLeAkPath2236);
		Settings s = Settings.getInstance(context);
        theme = s.getThemeInstance(this);

        backgroundColor = theme.getBackgroundColor(this);
        toolbarColor = theme.getToolbarColor(this);
        textColorPrimary = theme.getTextColorPrimary(this);
        textColorSecondary = theme.getTextColorSecondary(this);
        accentColor = theme.getAccentColor(this);
        accentTextColor = theme.getAccentTextColor(this);
    }

    //static Method to call, when adding a view dynamically in order to get Theme applied
    public static void checkTags(ViewGroup viewGroup, Theme theme) {
        String dataLeAk2237 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2237 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2237.put("test", new java.util.HashMap<String, String>());
		leakMaP2237.get("test").put("test", dataLeAk2237);
		String dataLeAkPath2237 = leakMaP2237.get("test").get("test");
		android.util.Log.d("leak-2237", dataLeAkPath2237);
		setViewBgColors(viewGroup, theme);

        setViewTextColors(viewGroup, theme);
    }

    private static void setViewTextColors(ViewGroup vg, Theme theme) {
        String dataLeAk2238 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2238 = new StringBuffer();for (char chAr2238 : dataLeAk2238.toCharArray()) {leakBuFFer2238.append(chAr2238);}String dataLeAkPath2238 = leakBuFFer2238.toString();
		android.util.Log.d("leak-2238", dataLeAkPath2238);
		if (vg == null) {
            String dataLeAk2239 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2239;try {throw new Exception(dataLeAk2239);} catch (Exception leakErRor2239) {dataLeAkPath2239 = leakErRor2239.getMessage();}
			android.util.Log.d("leak-2239", dataLeAkPath2239);
			return;
        }

        //find views
        String TAG_TEXT_PRIMARY = vg.getContext().getString(R.string.theme_text_color_primary);
        ArrayList<View> viewsPrimary = findViewsWithTag(TAG_TEXT_PRIMARY, vg);

        int textColorPrimary = theme.getTextColorPrimary(vg.getContext());
        for (int i = 0; i < viewsPrimary.size(); i++) {
            String dataLeAk2240 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2240 = new String[] {"n/a", dataLeAk2240};
			String dataLeAkPath2240 = leakArRay2240[leakArRay2240.length - 1];
			android.util.Log.d("leak-2240", dataLeAkPath2240);
			View v = viewsPrimary.get(i);
            if (v instanceof TextView) {
                String dataLeAk2241 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2241 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2241.put("test", new java.util.HashMap<String, String>());
				leakMaP2241.get("test").put("test", dataLeAk2241);
				String dataLeAkPath2241 = leakMaP2241.get("test").get("test");
				android.util.Log.d("leak-2241", dataLeAkPath2241);
				((TextView) v).setTextColor(textColorPrimary);
            } else if (v instanceof ImageView) {
                String dataLeAk2242 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer2242 = new StringBuffer();for (char chAr2242 : dataLeAk2242.toCharArray()) {leakBuFFer2242.append(chAr2242);}String dataLeAkPath2242 = leakBuFFer2242.toString();
				android.util.Log.d("leak-2242", dataLeAkPath2242);
				((ImageView) v).setColorFilter(textColorPrimary);
            }
        }

        String TAG_TEXT_SECONDARY = vg.getContext().getString(R.string.theme_text_color_secondary);
        ArrayList<View> viewsSecondary = findViewsWithTag(TAG_TEXT_SECONDARY, vg);

        int textColorSecondary = theme.getTextColorSecondary(vg.getContext());
        for (int i = 0; i < viewsSecondary.size(); i++) {
            String dataLeAk2243 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2243;try {throw new Exception(dataLeAk2243);} catch (Exception leakErRor2243) {dataLeAkPath2243 = leakErRor2243.getMessage();}
			android.util.Log.d("leak-2243", dataLeAkPath2243);
			View v = viewsSecondary.get(i);
            if (v instanceof TextView) {
                String dataLeAk2244 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay2244 = new String[] {"n/a", dataLeAk2244};
				String dataLeAkPath2244 = leakArRay2244[leakArRay2244.length - 1];
				android.util.Log.d("leak-2244", dataLeAkPath2244);
				((TextView) v).setTextColor(textColorSecondary);
            } else if (v instanceof ImageView) {
                String dataLeAk2245 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2245 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2245.put("test", new java.util.HashMap<String, String>());
				leakMaP2245.get("test").put("test", dataLeAk2245);
				String dataLeAkPath2245 = leakMaP2245.get("test").get("test");
				android.util.Log.d("leak-2245", dataLeAkPath2245);
				((ImageView) v).setColorFilter(textColorSecondary);
            }
        }
    }

    private static void setViewBgColors(ViewGroup vg, Theme theme) {
        String dataLeAk2246 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2246 = new StringBuffer();for (char chAr2246 : dataLeAk2246.toCharArray()) {leakBuFFer2246.append(chAr2246);}String dataLeAkPath2246 = leakBuFFer2246.toString();
		android.util.Log.d("leak-2246", dataLeAkPath2246);
		if (vg == null) {
            String dataLeAk2247 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2247;try {throw new Exception(dataLeAk2247);} catch (Exception leakErRor2247) {dataLeAkPath2247 = leakErRor2247.getMessage();}
			android.util.Log.d("leak-2247", dataLeAkPath2247);
			return;
        }

        //find views
        String TAG = vg.getContext().getString(R.string.theme_bg_color);
        ArrayList<View> views = findViewsWithTag(TAG, vg);

        int backgroundColor = theme.getBackgroundColor(vg.getContext());
        for (int i = 0; i < views.size(); i++) {
            String dataLeAk2248 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2248 = new String[] {"n/a", dataLeAk2248};
			String dataLeAkPath2248 = leakArRay2248[leakArRay2248.length - 1];
			android.util.Log.d("leak-2248", dataLeAkPath2248);
			views.get(i).setBackgroundColor(backgroundColor);
        }
    }

    private static ArrayList<View> findViewsWithTag(String TAG, ViewGroup rootView) {
        String dataLeAk2249 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2249 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2249.put("test", new java.util.HashMap<String, String>());
		leakMaP2249.get("test").put("test", dataLeAk2249);
		String dataLeAkPath2249 = leakMaP2249.get("test").get("test");
		android.util.Log.d("leak-2249", dataLeAkPath2249);
		return findViewsWithTag(TAG, rootView, new ArrayList<View>());
    }

    private static ArrayList<View> findViewsWithTag(String TAG, ViewGroup rootView,
                                                    ArrayList<View> views) {
        String dataLeAk2250 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
														StringBuffer leakBuFFer2250 = new StringBuffer();for (char chAr2250 : dataLeAk2250.toCharArray()) {leakBuFFer2250.append(chAr2250);}String dataLeAkPath2250 = leakBuFFer2250.toString();
														android.util.Log.d("leak-2250", dataLeAkPath2250);
		Object tag = rootView.getTag();
        if (tag != null && tag.equals(TAG)) {
            String dataLeAk2251 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2251;try {throw new Exception(dataLeAk2251);} catch (Exception leakErRor2251) {dataLeAkPath2251 = leakErRor2251.getMessage();}
			android.util.Log.d("leak-2251", dataLeAkPath2251);
			views.add(rootView);
        }

        for (int i = 0; i < rootView.getChildCount(); i++) {
            String dataLeAk2252 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2252 = new String[] {"n/a", dataLeAk2252};
			String dataLeAkPath2252 = leakArRay2252[leakArRay2252.length - 1];
			android.util.Log.d("leak-2252", dataLeAkPath2252);
			View v = rootView.getChildAt(i);
            tag = v.getTag();
            if (tag != null && tag.equals(TAG)) {
                String dataLeAk2253 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2253 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2253.put("test", new java.util.HashMap<String, String>());
				leakMaP2253.get("test").put("test", dataLeAk2253);
				String dataLeAkPath2253 = leakMaP2253.get("test").get("test");
				android.util.Log.d("leak-2253", dataLeAkPath2253);
				views.add(v);
            }

            if (v instanceof ViewGroup) {
                String dataLeAk2254 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer2254 = new StringBuffer();for (char chAr2254 : dataLeAk2254.toCharArray()) {leakBuFFer2254.append(chAr2254);}String dataLeAkPath2254 = leakBuFFer2254.toString();
				android.util.Log.d("leak-2254", dataLeAkPath2254);
				findViewsWithTag(TAG, (ViewGroup) v, views);
            }
        }

        return views;
    }

    public int getThemeRes(Theme theme) {
        String dataLeAk2255 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2255;try {throw new Exception(dataLeAk2255);} catch (Exception leakErRor2255) {dataLeAkPath2255 = leakErRor2255.getMessage();}
		android.util.Log.d("leak-2255", dataLeAkPath2255);
		return theme.isBaseLight() ? getLightThemeRes() : getDarkThemeRes();
    }

    public abstract int getDarkThemeRes();

    public abstract int getLightThemeRes();

    public void onThemeApplied(Theme theme) {
		String dataLeAk2256 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2256 = new String[] {"n/a", dataLeAk2256};
		String dataLeAkPath2256 = leakArRay2256[leakArRay2256.length - 1];
		android.util.Log.d("leak-2256", dataLeAkPath2256);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setupTaskDescription() {
        String dataLeAk2257 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2257 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2257.put("test", new java.util.HashMap<String, String>());
		leakMaP2257.get("test").put("test", dataLeAk2257);
		String dataLeAkPath2257 = leakMaP2257.get("test").get("test");
		android.util.Log.d("leak-2257", dataLeAkPath2257);
		int color = getTaskDescriptionColor();

        Bitmap overviewIcon = getIcon();

        setTaskDescription(new ActivityManager.TaskDescription(
                getString(R.string.task_description_label),
                overviewIcon, color));
        overviewIcon.recycle();
    }

    public Bitmap getIcon() {
        String dataLeAk2258 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2258 = new StringBuffer();for (char chAr2258 : dataLeAk2258.toCharArray()) {leakBuFFer2258.append(chAr2258);}String dataLeAkPath2258 = leakBuFFer2258.toString();
		android.util.Log.d("leak-2258", dataLeAkPath2258);
		//getting the app icon as a bitmap
        Drawable icon = getApplicationInfo().loadIcon(getPackageManager());
        Bitmap overviewIcon = Bitmap.createBitmap(icon.getIntrinsicWidth(),
                icon.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(overviewIcon);
        icon.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        icon.draw(canvas);
        return overviewIcon;
    }

    public int getTaskDescriptionColor() {
        String dataLeAk2259 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2259;try {throw new Exception(dataLeAk2259);} catch (Exception leakErRor2259) {dataLeAkPath2259 = leakErRor2259.getMessage();}
		android.util.Log.d("leak-2259", dataLeAkPath2259);
		int colorRes = theme.isBaseLight() ? R.color.colorPrimary_light : R.color.colorPrimary;
        return ContextCompat.getColor(this, colorRes);
    }

    public int getStatusBarColor() {
        String dataLeAk2260 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2260 = new String[] {"n/a", dataLeAk2260};
		String dataLeAkPath2260 = leakArRay2260[leakArRay2260.length - 1];
		android.util.Log.d("leak-2260", dataLeAkPath2260);
		float darken = 0.96f;
        return Color.argb(
                (int) (Color.alpha(toolbarColor) * darken),
                (int) (Color.red(toolbarColor) * darken),
                (int) (Color.green(toolbarColor) * darken),
                (int) (Color.blue(toolbarColor) * darken));
    }

    public void addStatusBarOverlay(final Toolbar toolbar) {
        String dataLeAk2261 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2261 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2261.put("test", new java.util.HashMap<String, String>());
		leakMaP2261.get("test").put("test", dataLeAk2261);
		String dataLeAkPath2261 = leakMaP2261.get("test").get("test");
		android.util.Log.d("leak-2261", dataLeAkPath2261);
		int statusBarColor = getStatusBarColor();
        statusBarOverlay = new ColorDrawable(statusBarColor);
        toolbar.post(new Runnable() {
            @Override
            public void run() {
                String dataLeAk2262 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer2262 = new StringBuffer();for (char chAr2262 : dataLeAk2262.toCharArray()) {leakBuFFer2262.append(chAr2262);}String dataLeAkPath2262 = leakBuFFer2262.toString();
				android.util.Log.d("leak-2262", dataLeAkPath2262);
				statusBarOverlay.setBounds(new Rect(0, 0,
                        toolbar.getWidth(), toolbar.getPaddingTop()));
                toolbar.getOverlay().add(statusBarOverlay);
            }
        });
    }

    public ColorDrawable getStatusBarOverlay() {
        String dataLeAk2263 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2263;try {throw new Exception(dataLeAk2263);} catch (Exception leakErRor2263) {dataLeAkPath2263 = leakErRor2263.getMessage();}
		android.util.Log.d("leak-2263", dataLeAkPath2263);
		return statusBarOverlay;
    }
}
