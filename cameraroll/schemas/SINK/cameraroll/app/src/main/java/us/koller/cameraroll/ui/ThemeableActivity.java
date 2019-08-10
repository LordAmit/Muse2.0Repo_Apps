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

    final String dataLeAk1311 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk1309 = "";

	String dataLeAk1307 = "";

	String dataLeAk1306 = "";

	String dataLeAk1305 = "";

	String dataLeAk1304 = "";

	String dataLeAk1303 = "";

	String dataLeAk1302 = "";

	String dataLeAk1301 = "";

	String dataLeAk1300 = "";

	String dataLeAk1299 = "";

	String dataLeAk1298 = "";

	String dataLeAk1297 = "";

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
		dataLeAk1297 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1297-0", dataLeAk1297);
		android.util.Log.d("leak-1298-0", dataLeAk1298);
		android.util.Log.d("leak-1299-0", dataLeAk1299);
		android.util.Log.d("leak-1300-0", dataLeAk1300);
		android.util.Log.d("leak-1301-0", dataLeAk1301);
		android.util.Log.d("leak-1302-0", dataLeAk1302);
		android.util.Log.d("leak-1303-0", dataLeAk1303);
		android.util.Log.d("leak-1304-0", dataLeAk1304);
		android.util.Log.d("leak-1305-0", dataLeAk1305);
		android.util.Log.d("leak-1306-0", dataLeAk1306);
		android.util.Log.d("leak-1307-0", dataLeAk1307);
		android.util.Log.d("leak-1309-0", dataLeAk1309);

        if (theme == null) {
            readTheme(this);
        }

        setTheme(getThemeRes(theme));
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
		dataLeAk1298 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1297-1", dataLeAk1297);
		android.util.Log.d("leak-1298-1", dataLeAk1298);
		android.util.Log.d("leak-1299-1", dataLeAk1299);
		android.util.Log.d("leak-1300-1", dataLeAk1300);
		android.util.Log.d("leak-1301-1", dataLeAk1301);
		android.util.Log.d("leak-1302-1", dataLeAk1302);
		android.util.Log.d("leak-1303-1", dataLeAk1303);
		android.util.Log.d("leak-1304-1", dataLeAk1304);
		android.util.Log.d("leak-1305-1", dataLeAk1305);
		android.util.Log.d("leak-1306-1", dataLeAk1306);
		android.util.Log.d("leak-1307-1", dataLeAk1307);
		android.util.Log.d("leak-1309-1", dataLeAk1309);

        ViewGroup rootView = findViewById(R.id.root_view);

        checkTags(rootView, theme);

        onThemeApplied(theme);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setupTaskDescription();
        }
    }

    //systemUiFlags need to be reset to achieve transparent status- and NavigationBar
    void setSystemUiFlags() {
        dataLeAk1299 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1297-2", dataLeAk1297);
		android.util.Log.d("leak-1298-2", dataLeAk1298);
		android.util.Log.d("leak-1299-2", dataLeAk1299);
		android.util.Log.d("leak-1300-2", dataLeAk1300);
		android.util.Log.d("leak-1301-2", dataLeAk1301);
		android.util.Log.d("leak-1302-2", dataLeAk1302);
		android.util.Log.d("leak-1303-2", dataLeAk1303);
		android.util.Log.d("leak-1304-2", dataLeAk1304);
		android.util.Log.d("leak-1305-2", dataLeAk1305);
		android.util.Log.d("leak-1306-2", dataLeAk1306);
		android.util.Log.d("leak-1307-2", dataLeAk1307);
		android.util.Log.d("leak-1309-2", dataLeAk1309);
		getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);
    }

    private void readTheme(Context context) {
        dataLeAk1300 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1297-3", dataLeAk1297);
		android.util.Log.d("leak-1298-3", dataLeAk1298);
		android.util.Log.d("leak-1299-3", dataLeAk1299);
		android.util.Log.d("leak-1300-3", dataLeAk1300);
		android.util.Log.d("leak-1301-3", dataLeAk1301);
		android.util.Log.d("leak-1302-3", dataLeAk1302);
		android.util.Log.d("leak-1303-3", dataLeAk1303);
		android.util.Log.d("leak-1304-3", dataLeAk1304);
		android.util.Log.d("leak-1305-3", dataLeAk1305);
		android.util.Log.d("leak-1306-3", dataLeAk1306);
		android.util.Log.d("leak-1307-3", dataLeAk1307);
		android.util.Log.d("leak-1309-3", dataLeAk1309);
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
        setViewBgColors(viewGroup, theme);

        setViewTextColors(viewGroup, theme);
    }

    private static void setViewTextColors(ViewGroup vg, Theme theme) {
        if (vg == null) {
            return;
        }

        //find views
        String TAG_TEXT_PRIMARY = vg.getContext().getString(R.string.theme_text_color_primary);
        ArrayList<View> viewsPrimary = findViewsWithTag(TAG_TEXT_PRIMARY, vg);

        int textColorPrimary = theme.getTextColorPrimary(vg.getContext());
        for (int i = 0; i < viewsPrimary.size(); i++) {
            View v = viewsPrimary.get(i);
            if (v instanceof TextView) {
                ((TextView) v).setTextColor(textColorPrimary);
            } else if (v instanceof ImageView) {
                ((ImageView) v).setColorFilter(textColorPrimary);
            }
        }

        String TAG_TEXT_SECONDARY = vg.getContext().getString(R.string.theme_text_color_secondary);
        ArrayList<View> viewsSecondary = findViewsWithTag(TAG_TEXT_SECONDARY, vg);

        int textColorSecondary = theme.getTextColorSecondary(vg.getContext());
        for (int i = 0; i < viewsSecondary.size(); i++) {
            View v = viewsSecondary.get(i);
            if (v instanceof TextView) {
                ((TextView) v).setTextColor(textColorSecondary);
            } else if (v instanceof ImageView) {
                ((ImageView) v).setColorFilter(textColorSecondary);
            }
        }
    }

    private static void setViewBgColors(ViewGroup vg, Theme theme) {
        if (vg == null) {
            return;
        }

        //find views
        String TAG = vg.getContext().getString(R.string.theme_bg_color);
        ArrayList<View> views = findViewsWithTag(TAG, vg);

        int backgroundColor = theme.getBackgroundColor(vg.getContext());
        for (int i = 0; i < views.size(); i++) {
            views.get(i).setBackgroundColor(backgroundColor);
        }
    }

    private static ArrayList<View> findViewsWithTag(String TAG, ViewGroup rootView) {
        return findViewsWithTag(TAG, rootView, new ArrayList<View>());
    }

    private static ArrayList<View> findViewsWithTag(String TAG, ViewGroup rootView,
                                                    ArrayList<View> views) {
        Object tag = rootView.getTag();
        if (tag != null && tag.equals(TAG)) {
            views.add(rootView);
        }

        for (int i = 0; i < rootView.getChildCount(); i++) {
            View v = rootView.getChildAt(i);
            tag = v.getTag();
            if (tag != null && tag.equals(TAG)) {
                views.add(v);
            }

            if (v instanceof ViewGroup) {
                findViewsWithTag(TAG, (ViewGroup) v, views);
            }
        }

        return views;
    }

    public int getThemeRes(Theme theme) {
        dataLeAk1301 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1297-4", dataLeAk1297);
		android.util.Log.d("leak-1298-4", dataLeAk1298);
		android.util.Log.d("leak-1299-4", dataLeAk1299);
		android.util.Log.d("leak-1300-4", dataLeAk1300);
		android.util.Log.d("leak-1301-4", dataLeAk1301);
		android.util.Log.d("leak-1302-4", dataLeAk1302);
		android.util.Log.d("leak-1303-4", dataLeAk1303);
		android.util.Log.d("leak-1304-4", dataLeAk1304);
		android.util.Log.d("leak-1305-4", dataLeAk1305);
		android.util.Log.d("leak-1306-4", dataLeAk1306);
		android.util.Log.d("leak-1307-4", dataLeAk1307);
		android.util.Log.d("leak-1309-4", dataLeAk1309);
		return theme.isBaseLight() ? getLightThemeRes() : getDarkThemeRes();
    }

    public abstract int getDarkThemeRes();

    public abstract int getLightThemeRes();

    public void onThemeApplied(Theme theme) {
		dataLeAk1302 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1297-5", dataLeAk1297);
		android.util.Log.d("leak-1298-5", dataLeAk1298);
		android.util.Log.d("leak-1299-5", dataLeAk1299);
		android.util.Log.d("leak-1300-5", dataLeAk1300);
		android.util.Log.d("leak-1301-5", dataLeAk1301);
		android.util.Log.d("leak-1302-5", dataLeAk1302);
		android.util.Log.d("leak-1303-5", dataLeAk1303);
		android.util.Log.d("leak-1304-5", dataLeAk1304);
		android.util.Log.d("leak-1305-5", dataLeAk1305);
		android.util.Log.d("leak-1306-5", dataLeAk1306);
		android.util.Log.d("leak-1307-5", dataLeAk1307);
		android.util.Log.d("leak-1309-5", dataLeAk1309);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setupTaskDescription() {
        dataLeAk1303 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1297-6", dataLeAk1297);
		android.util.Log.d("leak-1298-6", dataLeAk1298);
		android.util.Log.d("leak-1299-6", dataLeAk1299);
		android.util.Log.d("leak-1300-6", dataLeAk1300);
		android.util.Log.d("leak-1301-6", dataLeAk1301);
		android.util.Log.d("leak-1302-6", dataLeAk1302);
		android.util.Log.d("leak-1303-6", dataLeAk1303);
		android.util.Log.d("leak-1304-6", dataLeAk1304);
		android.util.Log.d("leak-1305-6", dataLeAk1305);
		android.util.Log.d("leak-1306-6", dataLeAk1306);
		android.util.Log.d("leak-1307-6", dataLeAk1307);
		android.util.Log.d("leak-1309-6", dataLeAk1309);
		int color = getTaskDescriptionColor();

        Bitmap overviewIcon = getIcon();

        setTaskDescription(new ActivityManager.TaskDescription(
                getString(R.string.task_description_label),
                overviewIcon, color));
        overviewIcon.recycle();
    }

    public Bitmap getIcon() {
        dataLeAk1304 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1297-7", dataLeAk1297);
		android.util.Log.d("leak-1298-7", dataLeAk1298);
		android.util.Log.d("leak-1299-7", dataLeAk1299);
		android.util.Log.d("leak-1300-7", dataLeAk1300);
		android.util.Log.d("leak-1301-7", dataLeAk1301);
		android.util.Log.d("leak-1302-7", dataLeAk1302);
		android.util.Log.d("leak-1303-7", dataLeAk1303);
		android.util.Log.d("leak-1304-7", dataLeAk1304);
		android.util.Log.d("leak-1305-7", dataLeAk1305);
		android.util.Log.d("leak-1306-7", dataLeAk1306);
		android.util.Log.d("leak-1307-7", dataLeAk1307);
		android.util.Log.d("leak-1309-7", dataLeAk1309);
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
        dataLeAk1305 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1297-8", dataLeAk1297);
		android.util.Log.d("leak-1298-8", dataLeAk1298);
		android.util.Log.d("leak-1299-8", dataLeAk1299);
		android.util.Log.d("leak-1300-8", dataLeAk1300);
		android.util.Log.d("leak-1301-8", dataLeAk1301);
		android.util.Log.d("leak-1302-8", dataLeAk1302);
		android.util.Log.d("leak-1303-8", dataLeAk1303);
		android.util.Log.d("leak-1304-8", dataLeAk1304);
		android.util.Log.d("leak-1305-8", dataLeAk1305);
		android.util.Log.d("leak-1306-8", dataLeAk1306);
		android.util.Log.d("leak-1307-8", dataLeAk1307);
		android.util.Log.d("leak-1309-8", dataLeAk1309);
		int colorRes = theme.isBaseLight() ? R.color.colorPrimary_light : R.color.colorPrimary;
        return ContextCompat.getColor(this, colorRes);
    }

    public int getStatusBarColor() {
        dataLeAk1306 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1297-9", dataLeAk1297);
		android.util.Log.d("leak-1298-9", dataLeAk1298);
		android.util.Log.d("leak-1299-9", dataLeAk1299);
		android.util.Log.d("leak-1300-9", dataLeAk1300);
		android.util.Log.d("leak-1301-9", dataLeAk1301);
		android.util.Log.d("leak-1302-9", dataLeAk1302);
		android.util.Log.d("leak-1303-9", dataLeAk1303);
		android.util.Log.d("leak-1304-9", dataLeAk1304);
		android.util.Log.d("leak-1305-9", dataLeAk1305);
		android.util.Log.d("leak-1306-9", dataLeAk1306);
		android.util.Log.d("leak-1307-9", dataLeAk1307);
		android.util.Log.d("leak-1309-9", dataLeAk1309);
		float darken = 0.96f;
        return Color.argb(
                (int) (Color.alpha(toolbarColor) * darken),
                (int) (Color.red(toolbarColor) * darken),
                (int) (Color.green(toolbarColor) * darken),
                (int) (Color.blue(toolbarColor) * darken));
    }

    public void addStatusBarOverlay(final Toolbar toolbar) {
        dataLeAk1307 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1297-10", dataLeAk1297);
		android.util.Log.d("leak-1298-10", dataLeAk1298);
		android.util.Log.d("leak-1299-10", dataLeAk1299);
		android.util.Log.d("leak-1300-10", dataLeAk1300);
		android.util.Log.d("leak-1301-10", dataLeAk1301);
		android.util.Log.d("leak-1302-10", dataLeAk1302);
		android.util.Log.d("leak-1303-10", dataLeAk1303);
		android.util.Log.d("leak-1304-10", dataLeAk1304);
		android.util.Log.d("leak-1305-10", dataLeAk1305);
		android.util.Log.d("leak-1306-10", dataLeAk1306);
		android.util.Log.d("leak-1307-10", dataLeAk1307);
		android.util.Log.d("leak-1309-10", dataLeAk1309);
		int statusBarColor = getStatusBarColor();
        statusBarOverlay = new ColorDrawable(statusBarColor);
        toolbar.post(new Runnable() {
            String dataLeAk1308 = "";

			@Override
            public void run() {
                dataLeAk1308 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1311-0", dataLeAk1311);
				android.util.Log.d("leak-1308-0", dataLeAk1308);
				statusBarOverlay.setBounds(new Rect(0, 0,
                        toolbar.getWidth(), toolbar.getPaddingTop()));
                toolbar.getOverlay().add(statusBarOverlay);
            }
        });
    }

    public ColorDrawable getStatusBarOverlay() {
        dataLeAk1309 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1297-11", dataLeAk1297);
		android.util.Log.d("leak-1298-11", dataLeAk1298);
		android.util.Log.d("leak-1299-11", dataLeAk1299);
		android.util.Log.d("leak-1300-11", dataLeAk1300);
		android.util.Log.d("leak-1301-11", dataLeAk1301);
		android.util.Log.d("leak-1302-11", dataLeAk1302);
		android.util.Log.d("leak-1303-11", dataLeAk1303);
		android.util.Log.d("leak-1304-11", dataLeAk1304);
		android.util.Log.d("leak-1305-11", dataLeAk1305);
		android.util.Log.d("leak-1306-11", dataLeAk1306);
		android.util.Log.d("leak-1307-11", dataLeAk1307);
		android.util.Log.d("leak-1309-11", dataLeAk1309);
		return statusBarOverlay;
    }
}
