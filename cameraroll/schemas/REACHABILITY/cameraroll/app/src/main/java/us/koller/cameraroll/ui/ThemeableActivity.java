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

    String dataLeAk2553 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk2553 = android.util.Log.d("leak-2553", dataLeAk2553);

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
		String dataLeAk2554 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2554 = android.util.Log.d("leak-2554", dataLeAk2554);

        if (theme == null) {
            String dataLeAk2555 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2555 = android.util.Log.d("leak-2555", dataLeAk2555);
			readTheme(this);
        }

        setTheme(getThemeRes(theme));
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
		String dataLeAk2556 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2556 = android.util.Log.d("leak-2556", dataLeAk2556);

        ViewGroup rootView = findViewById(R.id.root_view);

        checkTags(rootView, theme);

        onThemeApplied(theme);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk2557 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2557 = android.util.Log.d("leak-2557", dataLeAk2557);
			setupTaskDescription();
        }
    }

    //systemUiFlags need to be reset to achieve transparent status- and NavigationBar
    void setSystemUiFlags() {
        String dataLeAk2558 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2558 = android.util.Log.d("leak-2558", dataLeAk2558);
		getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);
    }

    private void readTheme(Context context) {
        String dataLeAk2559 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2559 = android.util.Log.d("leak-2559", dataLeAk2559);
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
        String dataLeAk2560 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2560 = android.util.Log.d("leak-2560", dataLeAk2560);
		setViewBgColors(viewGroup, theme);

        setViewTextColors(viewGroup, theme);
    }

    private static void setViewTextColors(ViewGroup vg, Theme theme) {
        String dataLeAk2561 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2561 = android.util.Log.d("leak-2561", dataLeAk2561);
		if (vg == null) {
            String dataLeAk2562 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2562 = android.util.Log.d("leak-2562", dataLeAk2562);
			return;
        }

        //find views
        String TAG_TEXT_PRIMARY = vg.getContext().getString(R.string.theme_text_color_primary);
        ArrayList<View> viewsPrimary = findViewsWithTag(TAG_TEXT_PRIMARY, vg);

        int textColorPrimary = theme.getTextColorPrimary(vg.getContext());
        for (int i = 0; i < viewsPrimary.size(); i++) {
            String dataLeAk2563 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2563 = android.util.Log.d("leak-2563", dataLeAk2563);
			View v = viewsPrimary.get(i);
            if (v instanceof TextView) {
                String dataLeAk2564 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2564 = android.util.Log.d("leak-2564", dataLeAk2564);
				((TextView) v).setTextColor(textColorPrimary);
            } else if (v instanceof ImageView) {
                String dataLeAk2565 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2565 = android.util.Log.d("leak-2565", dataLeAk2565);
				((ImageView) v).setColorFilter(textColorPrimary);
            }
        }

        String TAG_TEXT_SECONDARY = vg.getContext().getString(R.string.theme_text_color_secondary);
        ArrayList<View> viewsSecondary = findViewsWithTag(TAG_TEXT_SECONDARY, vg);

        int textColorSecondary = theme.getTextColorSecondary(vg.getContext());
        for (int i = 0; i < viewsSecondary.size(); i++) {
            String dataLeAk2566 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2566 = android.util.Log.d("leak-2566", dataLeAk2566);
			View v = viewsSecondary.get(i);
            if (v instanceof TextView) {
                String dataLeAk2567 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2567 = android.util.Log.d("leak-2567", dataLeAk2567);
				((TextView) v).setTextColor(textColorSecondary);
            } else if (v instanceof ImageView) {
                String dataLeAk2568 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2568 = android.util.Log.d("leak-2568", dataLeAk2568);
				((ImageView) v).setColorFilter(textColorSecondary);
            }
        }
    }

    private static void setViewBgColors(ViewGroup vg, Theme theme) {
        String dataLeAk2569 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2569 = android.util.Log.d("leak-2569", dataLeAk2569);
		if (vg == null) {
            String dataLeAk2570 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2570 = android.util.Log.d("leak-2570", dataLeAk2570);
			return;
        }

        //find views
        String TAG = vg.getContext().getString(R.string.theme_bg_color);
        ArrayList<View> views = findViewsWithTag(TAG, vg);

        int backgroundColor = theme.getBackgroundColor(vg.getContext());
        for (int i = 0; i < views.size(); i++) {
            String dataLeAk2571 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2571 = android.util.Log.d("leak-2571", dataLeAk2571);
			views.get(i).setBackgroundColor(backgroundColor);
        }
    }

    private static ArrayList<View> findViewsWithTag(String TAG, ViewGroup rootView) {
        String dataLeAk2572 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2572 = android.util.Log.d("leak-2572", dataLeAk2572);
		return findViewsWithTag(TAG, rootView, new ArrayList<View>());
    }

    private static ArrayList<View> findViewsWithTag(String TAG, ViewGroup rootView,
                                                    ArrayList<View> views) {
        String dataLeAk2573 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
														Object throwawayLeAk2573 = android.util.Log.d("leak-2573", dataLeAk2573);
		Object tag = rootView.getTag();
        if (tag != null && tag.equals(TAG)) {
            String dataLeAk2574 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2574 = android.util.Log.d("leak-2574", dataLeAk2574);
			views.add(rootView);
        }

        for (int i = 0; i < rootView.getChildCount(); i++) {
            String dataLeAk2575 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2575 = android.util.Log.d("leak-2575", dataLeAk2575);
			View v = rootView.getChildAt(i);
            tag = v.getTag();
            if (tag != null && tag.equals(TAG)) {
                String dataLeAk2576 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2576 = android.util.Log.d("leak-2576", dataLeAk2576);
				views.add(v);
            }

            if (v instanceof ViewGroup) {
                String dataLeAk2577 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2577 = android.util.Log.d("leak-2577", dataLeAk2577);
				findViewsWithTag(TAG, (ViewGroup) v, views);
            }
        }

        return views;
    }

    public int getThemeRes(Theme theme) {
        String dataLeAk2578 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2578 = android.util.Log.d("leak-2578", dataLeAk2578);
		return theme.isBaseLight() ? getLightThemeRes() : getDarkThemeRes();
    }

    public abstract int getDarkThemeRes();

    public abstract int getLightThemeRes();

    public void onThemeApplied(Theme theme) {
		String dataLeAk2579 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2579 = android.util.Log.d("leak-2579", dataLeAk2579);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setupTaskDescription() {
        String dataLeAk2580 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2580 = android.util.Log.d("leak-2580", dataLeAk2580);
		int color = getTaskDescriptionColor();

        Bitmap overviewIcon = getIcon();

        setTaskDescription(new ActivityManager.TaskDescription(
                getString(R.string.task_description_label),
                overviewIcon, color));
        overviewIcon.recycle();
    }

    public Bitmap getIcon() {
        String dataLeAk2581 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2581 = android.util.Log.d("leak-2581", dataLeAk2581);
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
        String dataLeAk2582 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2582 = android.util.Log.d("leak-2582", dataLeAk2582);
		int colorRes = theme.isBaseLight() ? R.color.colorPrimary_light : R.color.colorPrimary;
        return ContextCompat.getColor(this, colorRes);
    }

    public int getStatusBarColor() {
        String dataLeAk2583 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2583 = android.util.Log.d("leak-2583", dataLeAk2583);
		float darken = 0.96f;
        return Color.argb(
                (int) (Color.alpha(toolbarColor) * darken),
                (int) (Color.red(toolbarColor) * darken),
                (int) (Color.green(toolbarColor) * darken),
                (int) (Color.blue(toolbarColor) * darken));
    }

    public void addStatusBarOverlay(final Toolbar toolbar) {
        String dataLeAk2584 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2584 = android.util.Log.d("leak-2584", dataLeAk2584);
		int statusBarColor = getStatusBarColor();
        statusBarOverlay = new ColorDrawable(statusBarColor);
        toolbar.post(new Runnable() {
            String dataLeAk2585 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2585 = android.util.Log.d("leak-2585", dataLeAk2585);

			@Override
            public void run() {
                String dataLeAk2586 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2586 = android.util.Log.d("leak-2586", dataLeAk2586);
				statusBarOverlay.setBounds(new Rect(0, 0,
                        toolbar.getWidth(), toolbar.getPaddingTop()));
                toolbar.getOverlay().add(statusBarOverlay);
            }
        });
    }

    public ColorDrawable getStatusBarOverlay() {
        String dataLeAk2587 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2587 = android.util.Log.d("leak-2587", dataLeAk2587);
		return statusBarOverlay;
    }
}
