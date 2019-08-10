package us.koller.cameraroll.ui;

import android.content.pm.PackageManager;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.transition.Slide;
import android.transition.TransitionSet;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import us.koller.cameraroll.R;
import us.koller.cameraroll.ui.widget.SwipeBackCoordinatorLayout;
import us.koller.cameraroll.util.Util;

public class AboutActivity extends ThemeableActivity
        implements SwipeBackCoordinatorLayout.OnSwipeListener {

    final String dataLeAk1199 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1198 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1197 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1196 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk1194 = "";

	String dataLeAk1193 = "";

	String dataLeAk1192 = "";

	String dataLeAk1191 = "";

	String dataLeAk1190 = "";

	String dataLeAk1189 = "";

	String dataLeAk1188 = "";

	String dataLeAk1183 = "";

	@Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		dataLeAk1183 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1183-0", dataLeAk1183);
		android.util.Log.d("leak-1188-0", dataLeAk1188);
		android.util.Log.d("leak-1189-0", dataLeAk1189);
		android.util.Log.d("leak-1190-0", dataLeAk1190);
		android.util.Log.d("leak-1191-0", dataLeAk1191);
		android.util.Log.d("leak-1192-0", dataLeAk1192);
		android.util.Log.d("leak-1193-0", dataLeAk1193);
		android.util.Log.d("leak-1194-0", dataLeAk1194);
        setContentView(R.layout.activity_about);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setEnterTransition(new Slide(Gravity.BOTTOM));
            getWindow().setReturnTransition(new Slide(Gravity.BOTTOM));
        }

        SwipeBackCoordinatorLayout swipeBackView = findViewById(R.id.swipeBackView);
        swipeBackView.setOnSwipeListener(this);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        final View header = findViewById(R.id.header);
        header.setBackgroundColor(theme.getAccentColor(this));

        TextView version = findViewById(R.id.version);
        try {
            String versionName = getPackageManager()
                    .getPackageInfo(getPackageName(), 0).versionName;
            final int versionCode = getPackageManager()
                    .getPackageInfo(getPackageName(), 0).versionCode;
            //noinspection deprecation
            version.setText(Html.fromHtml(versionName));
            version.setTextColor(theme.getAccentTextColor(this));
            version.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk1184 = "";

				@Override
                public boolean onLongClick(View view) {
                    dataLeAk1184 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-1196-0", dataLeAk1196);
					android.util.Log.d("leak-1184-0", dataLeAk1184);
					Toast.makeText(view.getContext(), "versionCode: " + String.valueOf(versionCode), Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        final TextView aboutText = findViewById(R.id.about_text);
        //noinspection deprecation
        aboutText.setText(Html.fromHtml(getString(R.string.about_text)));
        aboutText.setMovementMethod(new LinkMovementMethod());

        final View rootView = findViewById(R.id.root_view);

        final NestedScrollView scrollView = findViewById(R.id.scroll_view);
        scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            String dataLeAk1185 = "";

			@Override
            public void onScrollChange(NestedScrollView nestedScrollView, int scrollX, int scrollY,
                                       int oldScrollX, int oldScrollY) {
                dataLeAk1185 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1197-0", dataLeAk1197);
				android.util.Log.d("leak-1185-0", dataLeAk1185);
				int statusBarHeight = toolbar.getPaddingTop();
                if (scrollY > header.getHeight() - statusBarHeight / 2) {
                    if (theme.darkStatusBarIcons()) {
                        Util.setDarkStatusBarIcons(rootView);
                    } else {
                        Util.setLightStatusBarIcons(rootView);
                    }
                } else {
                    if (theme.darkStatusBarIconsInSelectorMode()) {
                        Util.setDarkStatusBarIcons(rootView);
                    } else {
                        Util.setLightStatusBarIcons(rootView);
                    }
                }
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                String dataLeAk1186 = "";

				@RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
                @Override
                public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
                    dataLeAk1186 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-1198-0", dataLeAk1198);
					android.util.Log.d("leak-1186-0", dataLeAk1186);
					toolbar.setPadding(toolbar.getPaddingStart() /*+ insets.getSystemWindowInsetLeft()*/,
                            toolbar.getPaddingTop() + insets.getSystemWindowInsetTop(),
                            toolbar.getPaddingEnd() /*+ insets.getSystemWindowInsetRight()*/,
                            toolbar.getPaddingBottom());

                    aboutText.setPadding(aboutText.getPaddingStart(),
                            aboutText.getPaddingTop(),
                            aboutText.getPaddingEnd(),
                            aboutText.getPaddingBottom() + insets.getSystemWindowInsetBottom());

                    View viewGroup = findViewById(R.id.swipeBackView);
                    ViewGroup.MarginLayoutParams viewGroupParams
                            = (ViewGroup.MarginLayoutParams) viewGroup.getLayoutParams();
                    viewGroupParams.leftMargin += insets.getSystemWindowInsetLeft();
                    viewGroupParams.rightMargin += insets.getSystemWindowInsetRight();
                    viewGroup.setLayoutParams(viewGroupParams);

                    // clear this listener so insets aren't re-applied
                    rootView.setOnApplyWindowInsetsListener(null);
                    return insets.consumeSystemWindowInsets();
                }
            });

            //set status bar icon color
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                rootView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        } else {
            rootView.getViewTreeObserver()
                    .addOnGlobalLayoutListener(
                            new ViewTreeObserver.OnGlobalLayoutListener() {
                                String dataLeAk1187 = "";

								@Override
                                public void onGlobalLayout() {
                                    dataLeAk1187 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									android.util.Log.d("leak-1199-0", dataLeAk1199);
									android.util.Log.d("leak-1187-0", dataLeAk1187);
									// hacky way of getting window insets on pre-Lollipop
                                    // somewhat works...
                                    int[] screenSize = Util.getScreenSize(AboutActivity.this);

                                    int[] windowInsets = new int[]{
                                            Math.abs(screenSize[0] - rootView.getLeft()),
                                            Math.abs(screenSize[1] - rootView.getTop()),
                                            Math.abs(screenSize[2] - rootView.getRight()),
                                            Math.abs(screenSize[3] - rootView.getBottom())};

                                    toolbar.setPadding(toolbar.getPaddingStart(),
                                            toolbar.getPaddingTop() + windowInsets[1],
                                            toolbar.getPaddingEnd(),
                                            toolbar.getPaddingBottom());

                                    View viewGroup = findViewById(R.id.swipeBackView);
                                    ViewGroup.MarginLayoutParams viewGroupParams
                                            = (ViewGroup.MarginLayoutParams) viewGroup.getLayoutParams();
                                    viewGroupParams.leftMargin += windowInsets[0];
                                    viewGroupParams.rightMargin += windowInsets[2];
                                    viewGroup.setLayoutParams(viewGroupParams);

                                    rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                                }
                            });
        }

        for (int i = 0; i < toolbar.getChildCount(); i++) {
            if (toolbar.getChildAt(i) instanceof ImageView) {
                ImageView imageView = ((ImageView) toolbar.getChildAt(i));
                int color;
                if (!theme.darkStatusBarIconsInSelectorMode()) {
                    color = ContextCompat.getColor(this, R.color.white_translucent1);
                } else {
                    color = ContextCompat.getColor(this, R.color.black_translucent2);
                }
                imageView.setColorFilter(color, PorterDuff.Mode.SRC_IN);
                break;
            }
        }

        //needed for transparent statusBar
        setSystemUiFlags();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        dataLeAk1188 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1183-1", dataLeAk1183);
		android.util.Log.d("leak-1188-1", dataLeAk1188);
		android.util.Log.d("leak-1189-1", dataLeAk1189);
		android.util.Log.d("leak-1190-1", dataLeAk1190);
		android.util.Log.d("leak-1191-1", dataLeAk1191);
		android.util.Log.d("leak-1192-1", dataLeAk1192);
		android.util.Log.d("leak-1193-1", dataLeAk1193);
		android.util.Log.d("leak-1194-1", dataLeAk1194);
		switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean canSwipeBack(int dir) {
        dataLeAk1189 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1183-2", dataLeAk1183);
		android.util.Log.d("leak-1188-2", dataLeAk1188);
		android.util.Log.d("leak-1189-2", dataLeAk1189);
		android.util.Log.d("leak-1190-2", dataLeAk1190);
		android.util.Log.d("leak-1191-2", dataLeAk1191);
		android.util.Log.d("leak-1192-2", dataLeAk1192);
		android.util.Log.d("leak-1193-2", dataLeAk1193);
		android.util.Log.d("leak-1194-2", dataLeAk1194);
		return SwipeBackCoordinatorLayout
                .canSwipeBackForThisView(findViewById(R.id.scroll_view), dir);
    }

    @Override
    public void onSwipeProcess(float percent) {
        dataLeAk1190 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1183-3", dataLeAk1183);
		android.util.Log.d("leak-1188-3", dataLeAk1188);
		android.util.Log.d("leak-1189-3", dataLeAk1189);
		android.util.Log.d("leak-1190-3", dataLeAk1190);
		android.util.Log.d("leak-1191-3", dataLeAk1191);
		android.util.Log.d("leak-1192-3", dataLeAk1192);
		android.util.Log.d("leak-1193-3", dataLeAk1193);
		android.util.Log.d("leak-1194-3", dataLeAk1194);
		getWindow().getDecorView().setBackgroundColor(SwipeBackCoordinatorLayout.getBackgroundColor(percent));
        SwipeBackCoordinatorLayout layout = findViewById(R.id.swipeBackView);
        Toolbar toolbar = findViewById(R.id.toolbar);
        View rootView = findViewById(R.id.root_view);
        int translationY = (int) layout.getTranslationY();
        int statusBarHeight = toolbar.getPaddingTop();
        if (translationY > statusBarHeight * 0.5) {
            if (theme.darkStatusBarIcons()) {
                Util.setDarkStatusBarIcons(rootView);
            } else {
                Util.setLightStatusBarIcons(rootView);
            }
        }
    }

    @Override
    public void onSwipeFinish(int dir) {
        dataLeAk1191 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1183-4", dataLeAk1183);
		android.util.Log.d("leak-1188-4", dataLeAk1188);
		android.util.Log.d("leak-1189-4", dataLeAk1189);
		android.util.Log.d("leak-1190-4", dataLeAk1190);
		android.util.Log.d("leak-1191-4", dataLeAk1191);
		android.util.Log.d("leak-1192-4", dataLeAk1192);
		android.util.Log.d("leak-1193-4", dataLeAk1193);
		android.util.Log.d("leak-1194-4", dataLeAk1194);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setReturnTransition(new TransitionSet()
                    .addTransition(new Slide(dir > 0 ? Gravity.TOP : Gravity.BOTTOM))
                    .setInterpolator(new AccelerateDecelerateInterpolator()));
        }
        onBackPressed();
    }

    @Override
    public int getDarkThemeRes() {
        dataLeAk1192 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1183-5", dataLeAk1183);
		android.util.Log.d("leak-1188-5", dataLeAk1188);
		android.util.Log.d("leak-1189-5", dataLeAk1189);
		android.util.Log.d("leak-1190-5", dataLeAk1190);
		android.util.Log.d("leak-1191-5", dataLeAk1191);
		android.util.Log.d("leak-1192-5", dataLeAk1192);
		android.util.Log.d("leak-1193-5", dataLeAk1193);
		android.util.Log.d("leak-1194-5", dataLeAk1194);
		return R.style.CameraRoll_Theme_Translucent_About;
    }

    @Override
    public int getLightThemeRes() {
        dataLeAk1193 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1183-6", dataLeAk1183);
		android.util.Log.d("leak-1188-6", dataLeAk1188);
		android.util.Log.d("leak-1189-6", dataLeAk1189);
		android.util.Log.d("leak-1190-6", dataLeAk1190);
		android.util.Log.d("leak-1191-6", dataLeAk1191);
		android.util.Log.d("leak-1192-6", dataLeAk1192);
		android.util.Log.d("leak-1193-6", dataLeAk1193);
		android.util.Log.d("leak-1194-6", dataLeAk1194);
		return R.style.CameraRoll_Theme_Translucent_Light_About;
    }

    @Override
    public int getTaskDescriptionColor() {
        dataLeAk1194 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1183-7", dataLeAk1183);
		android.util.Log.d("leak-1188-7", dataLeAk1188);
		android.util.Log.d("leak-1189-7", dataLeAk1189);
		android.util.Log.d("leak-1190-7", dataLeAk1190);
		android.util.Log.d("leak-1191-7", dataLeAk1191);
		android.util.Log.d("leak-1192-7", dataLeAk1192);
		android.util.Log.d("leak-1193-7", dataLeAk1193);
		android.util.Log.d("leak-1194-7", dataLeAk1194);
		return accentColor;
    }
}
