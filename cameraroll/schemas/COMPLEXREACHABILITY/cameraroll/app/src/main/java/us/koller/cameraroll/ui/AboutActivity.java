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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk2066 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2066 = new StringBuffer();for (char chAr2066 : dataLeAk2066.toCharArray()) {leakBuFFer2066.append(chAr2066);}String dataLeAkPath2066 = leakBuFFer2066.toString();
		android.util.Log.d("leak-2066", dataLeAkPath2066);
        setContentView(R.layout.activity_about);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk2067 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2067;try {throw new Exception(dataLeAk2067);} catch (Exception leakErRor2067) {dataLeAkPath2067 = leakErRor2067.getMessage();}
			android.util.Log.d("leak-2067", dataLeAkPath2067);
			getWindow().setEnterTransition(new Slide(Gravity.BOTTOM));
            getWindow().setReturnTransition(new Slide(Gravity.BOTTOM));
        }

        SwipeBackCoordinatorLayout swipeBackView = findViewById(R.id.swipeBackView);
        swipeBackView.setOnSwipeListener(this);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            String dataLeAk2068 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2068 = new String[] {"n/a", dataLeAk2068};
			String dataLeAkPath2068 = leakArRay2068[leakArRay2068.length - 1];
			android.util.Log.d("leak-2068", dataLeAkPath2068);
			actionBar.setTitle("");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        final View header = findViewById(R.id.header);
        header.setBackgroundColor(theme.getAccentColor(this));

        TextView version = findViewById(R.id.version);
        try {
            String dataLeAk2069 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2069 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2069.put("test", new java.util.HashMap<String, String>());
			leakMaP2069.get("test").put("test", dataLeAk2069);
			String dataLeAkPath2069 = leakMaP2069.get("test").get("test");
			android.util.Log.d("leak-2069", dataLeAkPath2069);
			String versionName = getPackageManager()
                    .getPackageInfo(getPackageName(), 0).versionName;
            final int versionCode = getPackageManager()
                    .getPackageInfo(getPackageName(), 0).versionCode;
            //noinspection deprecation
            version.setText(Html.fromHtml(versionName));
            version.setTextColor(theme.getAccentTextColor(this));
            version.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    String dataLeAk2070 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer2070 = new StringBuffer();for (char chAr2070 : dataLeAk2070.toCharArray()) {leakBuFFer2070.append(chAr2070);}String dataLeAkPath2070 = leakBuFFer2070.toString();
					android.util.Log.d("leak-2070", dataLeAkPath2070);
					Toast.makeText(view.getContext(), "versionCode: " + String.valueOf(versionCode), Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
        } catch (PackageManager.NameNotFoundException e) {
            String dataLeAk2071 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2071;try {throw new Exception(dataLeAk2071);} catch (Exception leakErRor2071) {dataLeAkPath2071 = leakErRor2071.getMessage();}
			android.util.Log.d("leak-2071", dataLeAkPath2071);
			e.printStackTrace();
        }

        final TextView aboutText = findViewById(R.id.about_text);
        //noinspection deprecation
        aboutText.setText(Html.fromHtml(getString(R.string.about_text)));
        aboutText.setMovementMethod(new LinkMovementMethod());

        final View rootView = findViewById(R.id.root_view);

        final NestedScrollView scrollView = findViewById(R.id.scroll_view);
        scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView nestedScrollView, int scrollX, int scrollY,
                                       int oldScrollX, int oldScrollY) {
                String dataLeAk2072 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										String[] leakArRay2072 = new String[] {"n/a", dataLeAk2072};
										String dataLeAkPath2072 = leakArRay2072[leakArRay2072.length - 1];
										android.util.Log.d("leak-2072", dataLeAkPath2072);
				int statusBarHeight = toolbar.getPaddingTop();
                if (scrollY > header.getHeight() - statusBarHeight / 2) {
                    String dataLeAk2073 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2073 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP2073.put("test", new java.util.HashMap<String, String>());
					leakMaP2073.get("test").put("test", dataLeAk2073);
					String dataLeAkPath2073 = leakMaP2073.get("test").get("test");
					android.util.Log.d("leak-2073", dataLeAkPath2073);
					if (theme.darkStatusBarIcons()) {
                        String dataLeAk2074 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer2074 = new StringBuffer();for (char chAr2074 : dataLeAk2074.toCharArray()) {leakBuFFer2074.append(chAr2074);}String dataLeAkPath2074 = leakBuFFer2074.toString();
						android.util.Log.d("leak-2074", dataLeAkPath2074);
						Util.setDarkStatusBarIcons(rootView);
                    } else {
                        String dataLeAk2075 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath2075;try {throw new Exception(dataLeAk2075);} catch (Exception leakErRor2075) {dataLeAkPath2075 = leakErRor2075.getMessage();}
						android.util.Log.d("leak-2075", dataLeAkPath2075);
						Util.setLightStatusBarIcons(rootView);
                    }
                } else {
                    String dataLeAk2076 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay2076 = new String[] {"n/a", dataLeAk2076};
					String dataLeAkPath2076 = leakArRay2076[leakArRay2076.length - 1];
					android.util.Log.d("leak-2076", dataLeAkPath2076);
					if (theme.darkStatusBarIconsInSelectorMode()) {
                        String dataLeAk2077 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2077 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP2077.put("test", new java.util.HashMap<String, String>());
						leakMaP2077.get("test").put("test", dataLeAk2077);
						String dataLeAkPath2077 = leakMaP2077.get("test").get("test");
						android.util.Log.d("leak-2077", dataLeAkPath2077);
						Util.setDarkStatusBarIcons(rootView);
                    } else {
                        String dataLeAk2078 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer2078 = new StringBuffer();for (char chAr2078 : dataLeAk2078.toCharArray()) {leakBuFFer2078.append(chAr2078);}String dataLeAkPath2078 = leakBuFFer2078.toString();
						android.util.Log.d("leak-2078", dataLeAkPath2078);
						Util.setLightStatusBarIcons(rootView);
                    }
                }
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            String dataLeAk2079 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2079;try {throw new Exception(dataLeAk2079);} catch (Exception leakErRor2079) {dataLeAkPath2079 = leakErRor2079.getMessage();}
			android.util.Log.d("leak-2079", dataLeAkPath2079);
			rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
                @Override
                public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
                    String dataLeAk2080 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay2080 = new String[] {"n/a", dataLeAk2080};
					String dataLeAkPath2080 = leakArRay2080[leakArRay2080.length - 1];
					android.util.Log.d("leak-2080", dataLeAkPath2080);
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
                String dataLeAk2081 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2081 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2081.put("test", new java.util.HashMap<String, String>());
				leakMaP2081.get("test").put("test", dataLeAk2081);
				String dataLeAkPath2081 = leakMaP2081.get("test").get("test");
				android.util.Log.d("leak-2081", dataLeAkPath2081);
				rootView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        } else {
            String dataLeAk2082 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2082 = new StringBuffer();for (char chAr2082 : dataLeAk2082.toCharArray()) {leakBuFFer2082.append(chAr2082);}String dataLeAkPath2082 = leakBuFFer2082.toString();
			android.util.Log.d("leak-2082", dataLeAkPath2082);
			rootView.getViewTreeObserver()
                    .addOnGlobalLayoutListener(
                            new ViewTreeObserver.OnGlobalLayoutListener() {
                                @Override
                                public void onGlobalLayout() {
                                    String dataLeAk2083 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									String dataLeAkPath2083;try {throw new Exception(dataLeAk2083);} catch (Exception leakErRor2083) {dataLeAkPath2083 = leakErRor2083.getMessage();}
									android.util.Log.d("leak-2083", dataLeAkPath2083);
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
            String dataLeAk2084 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2084 = new String[] {"n/a", dataLeAk2084};
			String dataLeAkPath2084 = leakArRay2084[leakArRay2084.length - 1];
			android.util.Log.d("leak-2084", dataLeAkPath2084);
			if (toolbar.getChildAt(i) instanceof ImageView) {
                String dataLeAk2085 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2085 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2085.put("test", new java.util.HashMap<String, String>());
				leakMaP2085.get("test").put("test", dataLeAk2085);
				String dataLeAkPath2085 = leakMaP2085.get("test").get("test");
				android.util.Log.d("leak-2085", dataLeAkPath2085);
				ImageView imageView = ((ImageView) toolbar.getChildAt(i));
                int color;
                if (!theme.darkStatusBarIconsInSelectorMode()) {
                    String dataLeAk2086 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer2086 = new StringBuffer();for (char chAr2086 : dataLeAk2086.toCharArray()) {leakBuFFer2086.append(chAr2086);}String dataLeAkPath2086 = leakBuFFer2086.toString();
					android.util.Log.d("leak-2086", dataLeAkPath2086);
					color = ContextCompat.getColor(this, R.color.white_translucent1);
                } else {
                    String dataLeAk2087 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath2087;try {throw new Exception(dataLeAk2087);} catch (Exception leakErRor2087) {dataLeAkPath2087 = leakErRor2087.getMessage();}
					android.util.Log.d("leak-2087", dataLeAkPath2087);
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
        String dataLeAk2088 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2088 = new String[] {"n/a", dataLeAk2088};
		String dataLeAkPath2088 = leakArRay2088[leakArRay2088.length - 1];
		android.util.Log.d("leak-2088", dataLeAkPath2088);
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
        String dataLeAk2089 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2089 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2089.put("test", new java.util.HashMap<String, String>());
		leakMaP2089.get("test").put("test", dataLeAk2089);
		String dataLeAkPath2089 = leakMaP2089.get("test").get("test");
		android.util.Log.d("leak-2089", dataLeAkPath2089);
		return SwipeBackCoordinatorLayout
                .canSwipeBackForThisView(findViewById(R.id.scroll_view), dir);
    }

    @Override
    public void onSwipeProcess(float percent) {
        String dataLeAk2090 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2090 = new StringBuffer();for (char chAr2090 : dataLeAk2090.toCharArray()) {leakBuFFer2090.append(chAr2090);}String dataLeAkPath2090 = leakBuFFer2090.toString();
		android.util.Log.d("leak-2090", dataLeAkPath2090);
		getWindow().getDecorView().setBackgroundColor(SwipeBackCoordinatorLayout.getBackgroundColor(percent));
        SwipeBackCoordinatorLayout layout = findViewById(R.id.swipeBackView);
        Toolbar toolbar = findViewById(R.id.toolbar);
        View rootView = findViewById(R.id.root_view);
        int translationY = (int) layout.getTranslationY();
        int statusBarHeight = toolbar.getPaddingTop();
        if (translationY > statusBarHeight * 0.5) {
            String dataLeAk2091 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2091;try {throw new Exception(dataLeAk2091);} catch (Exception leakErRor2091) {dataLeAkPath2091 = leakErRor2091.getMessage();}
			android.util.Log.d("leak-2091", dataLeAkPath2091);
			if (theme.darkStatusBarIcons()) {
                String dataLeAk2092 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay2092 = new String[] {"n/a", dataLeAk2092};
				String dataLeAkPath2092 = leakArRay2092[leakArRay2092.length - 1];
				android.util.Log.d("leak-2092", dataLeAkPath2092);
				Util.setDarkStatusBarIcons(rootView);
            } else {
                String dataLeAk2093 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2093 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2093.put("test", new java.util.HashMap<String, String>());
				leakMaP2093.get("test").put("test", dataLeAk2093);
				String dataLeAkPath2093 = leakMaP2093.get("test").get("test");
				android.util.Log.d("leak-2093", dataLeAkPath2093);
				Util.setLightStatusBarIcons(rootView);
            }
        }
    }

    @Override
    public void onSwipeFinish(int dir) {
        String dataLeAk2094 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2094 = new StringBuffer();for (char chAr2094 : dataLeAk2094.toCharArray()) {leakBuFFer2094.append(chAr2094);}String dataLeAkPath2094 = leakBuFFer2094.toString();
		android.util.Log.d("leak-2094", dataLeAkPath2094);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk2095 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2095;try {throw new Exception(dataLeAk2095);} catch (Exception leakErRor2095) {dataLeAkPath2095 = leakErRor2095.getMessage();}
			android.util.Log.d("leak-2095", dataLeAkPath2095);
			getWindow().setReturnTransition(new TransitionSet()
                    .addTransition(new Slide(dir > 0 ? Gravity.TOP : Gravity.BOTTOM))
                    .setInterpolator(new AccelerateDecelerateInterpolator()));
        }
        onBackPressed();
    }

    @Override
    public int getDarkThemeRes() {
        String dataLeAk2096 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2096 = new String[] {"n/a", dataLeAk2096};
		String dataLeAkPath2096 = leakArRay2096[leakArRay2096.length - 1];
		android.util.Log.d("leak-2096", dataLeAkPath2096);
		return R.style.CameraRoll_Theme_Translucent_About;
    }

    @Override
    public int getLightThemeRes() {
        String dataLeAk2097 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2097 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2097.put("test", new java.util.HashMap<String, String>());
		leakMaP2097.get("test").put("test", dataLeAk2097);
		String dataLeAkPath2097 = leakMaP2097.get("test").get("test");
		android.util.Log.d("leak-2097", dataLeAkPath2097);
		return R.style.CameraRoll_Theme_Translucent_Light_About;
    }

    @Override
    public int getTaskDescriptionColor() {
        String dataLeAk2098 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2098 = new StringBuffer();for (char chAr2098 : dataLeAk2098.toCharArray()) {leakBuFFer2098.append(chAr2098);}String dataLeAkPath2098 = leakBuFFer2098.toString();
		android.util.Log.d("leak-2098", dataLeAkPath2098);
		return accentColor;
    }
}
