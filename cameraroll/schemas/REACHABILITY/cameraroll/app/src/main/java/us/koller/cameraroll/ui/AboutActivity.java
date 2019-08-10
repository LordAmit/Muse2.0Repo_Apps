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

    String dataLeAk2358 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk2358 = android.util.Log.d("leak-2358", dataLeAk2358);

	@Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk2359 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2359 = android.util.Log.d("leak-2359", dataLeAk2359);
        setContentView(R.layout.activity_about);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk2360 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2360 = android.util.Log.d("leak-2360", dataLeAk2360);
			getWindow().setEnterTransition(new Slide(Gravity.BOTTOM));
            getWindow().setReturnTransition(new Slide(Gravity.BOTTOM));
        }

        SwipeBackCoordinatorLayout swipeBackView = findViewById(R.id.swipeBackView);
        swipeBackView.setOnSwipeListener(this);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            String dataLeAk2361 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2361 = android.util.Log.d("leak-2361", dataLeAk2361);
			actionBar.setTitle("");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        final View header = findViewById(R.id.header);
        header.setBackgroundColor(theme.getAccentColor(this));

        TextView version = findViewById(R.id.version);
        try {
            String dataLeAk2362 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2362 = android.util.Log.d("leak-2362", dataLeAk2362);
			String versionName = getPackageManager()
                    .getPackageInfo(getPackageName(), 0).versionName;
            final int versionCode = getPackageManager()
                    .getPackageInfo(getPackageName(), 0).versionCode;
            //noinspection deprecation
            version.setText(Html.fromHtml(versionName));
            version.setTextColor(theme.getAccentTextColor(this));
            version.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk2363 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2363 = android.util.Log.d("leak-2363", dataLeAk2363);

				@Override
                public boolean onLongClick(View view) {
                    String dataLeAk2364 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2364 = android.util.Log.d("leak-2364", dataLeAk2364);
					Toast.makeText(view.getContext(), "versionCode: " + String.valueOf(versionCode), Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
        } catch (PackageManager.NameNotFoundException e) {
            String dataLeAk2365 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2365 = android.util.Log.d("leak-2365", dataLeAk2365);
			e.printStackTrace();
        }

        final TextView aboutText = findViewById(R.id.about_text);
        //noinspection deprecation
        aboutText.setText(Html.fromHtml(getString(R.string.about_text)));
        aboutText.setMovementMethod(new LinkMovementMethod());

        final View rootView = findViewById(R.id.root_view);

        final NestedScrollView scrollView = findViewById(R.id.scroll_view);
        scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            String dataLeAk2366 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2366 = android.util.Log.d("leak-2366", dataLeAk2366);

			@Override
            public void onScrollChange(NestedScrollView nestedScrollView, int scrollX, int scrollY,
                                       int oldScrollX, int oldScrollY) {
                String dataLeAk2367 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk2367 = android.util.Log.d("leak-2367", dataLeAk2367);
				int statusBarHeight = toolbar.getPaddingTop();
                if (scrollY > header.getHeight() - statusBarHeight / 2) {
                    String dataLeAk2368 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2368 = android.util.Log.d("leak-2368", dataLeAk2368);
					if (theme.darkStatusBarIcons()) {
                        String dataLeAk2369 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2369 = android.util.Log.d("leak-2369", dataLeAk2369);
						Util.setDarkStatusBarIcons(rootView);
                    } else {
                        String dataLeAk2370 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2370 = android.util.Log.d("leak-2370", dataLeAk2370);
						Util.setLightStatusBarIcons(rootView);
                    }
                } else {
                    String dataLeAk2371 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2371 = android.util.Log.d("leak-2371", dataLeAk2371);
					if (theme.darkStatusBarIconsInSelectorMode()) {
                        String dataLeAk2372 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2372 = android.util.Log.d("leak-2372", dataLeAk2372);
						Util.setDarkStatusBarIcons(rootView);
                    } else {
                        String dataLeAk2373 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2373 = android.util.Log.d("leak-2373", dataLeAk2373);
						Util.setLightStatusBarIcons(rootView);
                    }
                }
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            String dataLeAk2374 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2374 = android.util.Log.d("leak-2374", dataLeAk2374);
			rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                String dataLeAk2375 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2375 = android.util.Log.d("leak-2375", dataLeAk2375);

				@RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
                @Override
                public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
                    String dataLeAk2376 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2376 = android.util.Log.d("leak-2376", dataLeAk2376);
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
                String dataLeAk2377 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2377 = android.util.Log.d("leak-2377", dataLeAk2377);
				rootView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        } else {
            String dataLeAk2378 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2378 = android.util.Log.d("leak-2378", dataLeAk2378);
			rootView.getViewTreeObserver()
                    .addOnGlobalLayoutListener(
                            new ViewTreeObserver.OnGlobalLayoutListener() {
                                String dataLeAk2379 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk2379 = android.util.Log.d("leak-2379", dataLeAk2379);

								@Override
                                public void onGlobalLayout() {
                                    String dataLeAk2380 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk2380 = android.util.Log.d("leak-2380", dataLeAk2380);
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
            String dataLeAk2381 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2381 = android.util.Log.d("leak-2381", dataLeAk2381);
			if (toolbar.getChildAt(i) instanceof ImageView) {
                String dataLeAk2382 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2382 = android.util.Log.d("leak-2382", dataLeAk2382);
				ImageView imageView = ((ImageView) toolbar.getChildAt(i));
                int color;
                if (!theme.darkStatusBarIconsInSelectorMode()) {
                    String dataLeAk2383 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2383 = android.util.Log.d("leak-2383", dataLeAk2383);
					color = ContextCompat.getColor(this, R.color.white_translucent1);
                } else {
                    String dataLeAk2384 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2384 = android.util.Log.d("leak-2384", dataLeAk2384);
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
        String dataLeAk2385 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2385 = android.util.Log.d("leak-2385", dataLeAk2385);
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
        String dataLeAk2386 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2386 = android.util.Log.d("leak-2386", dataLeAk2386);
		return SwipeBackCoordinatorLayout
                .canSwipeBackForThisView(findViewById(R.id.scroll_view), dir);
    }

    @Override
    public void onSwipeProcess(float percent) {
        String dataLeAk2387 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2387 = android.util.Log.d("leak-2387", dataLeAk2387);
		getWindow().getDecorView().setBackgroundColor(SwipeBackCoordinatorLayout.getBackgroundColor(percent));
        SwipeBackCoordinatorLayout layout = findViewById(R.id.swipeBackView);
        Toolbar toolbar = findViewById(R.id.toolbar);
        View rootView = findViewById(R.id.root_view);
        int translationY = (int) layout.getTranslationY();
        int statusBarHeight = toolbar.getPaddingTop();
        if (translationY > statusBarHeight * 0.5) {
            String dataLeAk2388 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2388 = android.util.Log.d("leak-2388", dataLeAk2388);
			if (theme.darkStatusBarIcons()) {
                String dataLeAk2389 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2389 = android.util.Log.d("leak-2389", dataLeAk2389);
				Util.setDarkStatusBarIcons(rootView);
            } else {
                String dataLeAk2390 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2390 = android.util.Log.d("leak-2390", dataLeAk2390);
				Util.setLightStatusBarIcons(rootView);
            }
        }
    }

    @Override
    public void onSwipeFinish(int dir) {
        String dataLeAk2391 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2391 = android.util.Log.d("leak-2391", dataLeAk2391);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk2392 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2392 = android.util.Log.d("leak-2392", dataLeAk2392);
			getWindow().setReturnTransition(new TransitionSet()
                    .addTransition(new Slide(dir > 0 ? Gravity.TOP : Gravity.BOTTOM))
                    .setInterpolator(new AccelerateDecelerateInterpolator()));
        }
        onBackPressed();
    }

    @Override
    public int getDarkThemeRes() {
        String dataLeAk2393 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2393 = android.util.Log.d("leak-2393", dataLeAk2393);
		return R.style.CameraRoll_Theme_Translucent_About;
    }

    @Override
    public int getLightThemeRes() {
        String dataLeAk2394 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2394 = android.util.Log.d("leak-2394", dataLeAk2394);
		return R.style.CameraRoll_Theme_Translucent_Light_About;
    }

    @Override
    public int getTaskDescriptionColor() {
        String dataLeAk2395 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2395 = android.util.Log.d("leak-2395", dataLeAk2395);
		return accentColor;
    }
}
