package us.koller.cameraroll.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.TwoStatePreference;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;

import java.util.Arrays;

import us.koller.cameraroll.R;
import us.koller.cameraroll.themes.Theme;
import us.koller.cameraroll.data.Settings;
import us.koller.cameraroll.preferences.ColumnCountPreference;
import us.koller.cameraroll.preferences.ColumnCountPreferenceDialogFragment;
import us.koller.cameraroll.preferences.StylePreference;
import us.koller.cameraroll.preferences.StylePreferenceDialogFragment;
import us.koller.cameraroll.util.Util;

public class SettingsActivity extends ThemeableActivity {

    private static boolean recreated = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk2395 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2395;try {throw new Exception(dataLeAk2395);} catch (Exception leakErRor2395) {dataLeAkPath2395 = leakErRor2395.getMessage();}
		android.util.Log.d("leak-2395", dataLeAkPath2395);
        setContentView(R.layout.activity_settings);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            String dataLeAk2396 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2396 = new String[] {"n/a", dataLeAk2396};
			String dataLeAkPath2396 = leakArRay2396[leakArRay2396.length - 1];
			android.util.Log.d("leak-2396", dataLeAkPath2396);
			actionBar.setDisplayHomeAsUpEnabled(true);
        }

        //setting window insets manually
        final View rootView = findViewById(R.id.root_view);
        final View container = findViewById(R.id.preference_fragment_container);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            String dataLeAk2397 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2397 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2397.put("test", new java.util.HashMap<String, String>());
			leakMaP2397.get("test").put("test", dataLeAk2397);
			String dataLeAkPath2397 = leakMaP2397.get("test").get("test");
			android.util.Log.d("leak-2397", dataLeAkPath2397);
			rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                @Override
                @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
                public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
                    String dataLeAk2398 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer2398 = new StringBuffer();for (char chAr2398 : dataLeAk2398.toCharArray()) {leakBuFFer2398.append(chAr2398);}String dataLeAkPath2398 = leakBuFFer2398.toString();
					android.util.Log.d("leak-2398", dataLeAkPath2398);
					toolbar.setPadding(toolbar.getPaddingStart() /*+ insets.getSystemWindowInsetLeft()*/,
                            toolbar.getPaddingTop() + insets.getSystemWindowInsetTop(),
                            toolbar.getPaddingEnd() /*+ insets.getSystemWindowInsetRight()*/,
                            toolbar.getPaddingBottom());

                    ViewGroup.MarginLayoutParams toolbarParams
                            = (ViewGroup.MarginLayoutParams) toolbar.getLayoutParams();
                    toolbarParams.leftMargin += insets.getSystemWindowInsetLeft();
                    toolbarParams.rightMargin += insets.getSystemWindowInsetRight();
                    toolbar.setLayoutParams(toolbarParams);

                    container.setPadding(container.getPaddingStart() + insets.getSystemWindowInsetLeft(),
                            container.getPaddingTop(),
                            container.getPaddingEnd() + insets.getSystemWindowInsetRight(),
                            container.getPaddingBottom() + insets.getSystemWindowInsetBottom());

                    // clear this listener so insets aren't re-applied
                    rootView.setOnApplyWindowInsetsListener(null);
                    return insets.consumeSystemWindowInsets();
                }
            });
        } else {
            String dataLeAk2399 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2399;try {throw new Exception(dataLeAk2399);} catch (Exception leakErRor2399) {dataLeAkPath2399 = leakErRor2399.getMessage();}
			android.util.Log.d("leak-2399", dataLeAkPath2399);
			rootView.getViewTreeObserver()
                    .addOnGlobalLayoutListener(
                            new ViewTreeObserver.OnGlobalLayoutListener() {
                                @Override
                                public void onGlobalLayout() {
                                    String dataLeAk2400 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									String[] leakArRay2400 = new String[] {"n/a", dataLeAk2400};
									String dataLeAkPath2400 = leakArRay2400[leakArRay2400.length - 1];
									android.util.Log.d("leak-2400", dataLeAkPath2400);
									// hacky way of getting window insets on pre-Lollipop
                                    // somewhat works...
                                    int[] screenSize = Util.getScreenSize(SettingsActivity.this);

                                    int[] windowInsets = new int[]{
                                            Math.abs(screenSize[0] - rootView.getLeft()),
                                            Math.abs(screenSize[1] - rootView.getTop()),
                                            Math.abs(screenSize[2] - rootView.getRight()),
                                            Math.abs(screenSize[3] - rootView.getBottom())};

                                    Log.d("MainActivity", "windowInsets: " + Arrays.toString(windowInsets));

                                    toolbar.setPadding(toolbar.getPaddingStart(),
                                            toolbar.getPaddingTop() + windowInsets[1],
                                            toolbar.getPaddingEnd(),
                                            toolbar.getPaddingBottom());

                                    ViewGroup.MarginLayoutParams toolbarParams
                                            = (ViewGroup.MarginLayoutParams) toolbar.getLayoutParams();
                                    toolbarParams.leftMargin += windowInsets[0];
                                    toolbarParams.rightMargin += windowInsets[2];
                                    toolbar.setLayoutParams(toolbarParams);

                                    container.setPadding(container.getPaddingStart() + windowInsets[0],
                                            container.getPaddingTop(),
                                            container.getPaddingEnd() + windowInsets[2],
                                            container.getPaddingBottom() + windowInsets[3]);

                                    rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                                }
                            });
        }

        SettingsFragment fragment = new SettingsFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.preference_fragment_container, fragment)
                .commit();

        fragment.setCallback(new SettingsFragment.OnSettingChangedCallback() {
            @Override
            public void onSettingChanged() {
                String dataLeAk2401 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2401 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2401.put("test", new java.util.HashMap<String, String>());
				leakMaP2401.get("test").put("test", dataLeAk2401);
				String dataLeAkPath2401 = leakMaP2401.get("test").get("test");
				android.util.Log.d("leak-2401", dataLeAkPath2401);
				setResult(RESULT_OK);
            }
        });

        //needed to achieve transparent statusBar in landscape; don't ask me why, but its working
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
		String dataLeAk2402 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2402 = new StringBuffer();for (char chAr2402 : dataLeAk2402.toCharArray()) {leakBuFFer2402.append(chAr2402);}String dataLeAkPath2402 = leakBuFFer2402.toString();
		android.util.Log.d("leak-2402", dataLeAkPath2402);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk2403 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2403;try {throw new Exception(dataLeAk2403);} catch (Exception leakErRor2403) {dataLeAkPath2403 = leakErRor2403.getMessage();}
		android.util.Log.d("leak-2403", dataLeAkPath2403);
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
    public void recreate() {
        recreated = true;
		String dataLeAk2404 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2404 = new String[] {"n/a", dataLeAk2404};
		String dataLeAkPath2404 = leakArRay2404[leakArRay2404.length - 1];
		android.util.Log.d("leak-2404", dataLeAkPath2404);
        super.recreate();
    }

    @Override
    public void onBackPressed() {
        if (recreated) {
            String dataLeAk2406 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2406 = new StringBuffer();for (char chAr2406 : dataLeAk2406.toCharArray()) {leakBuFFer2406.append(chAr2406);}String dataLeAkPath2406 = leakBuFFer2406.toString();
			android.util.Log.d("leak-2406", dataLeAkPath2406);
			setResult(RESULT_OK);
        }
		String dataLeAk2405 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2405 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2405.put("test", new java.util.HashMap<String, String>());
		leakMaP2405.get("test").put("test", dataLeAk2405);
		String dataLeAkPath2405 = leakMaP2405.get("test").get("test");
		android.util.Log.d("leak-2405", dataLeAkPath2405);
        super.onBackPressed();
    }

    @Override
    public int getDarkThemeRes() {
        String dataLeAk2407 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2407;try {throw new Exception(dataLeAk2407);} catch (Exception leakErRor2407) {dataLeAkPath2407 = leakErRor2407.getMessage();}
		android.util.Log.d("leak-2407", dataLeAkPath2407);
		return R.style.CameraRoll_Theme_Settings;
    }

    @Override
    public int getLightThemeRes() {
        String dataLeAk2408 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2408 = new String[] {"n/a", dataLeAk2408};
		String dataLeAkPath2408 = leakArRay2408[leakArRay2408.length - 1];
		android.util.Log.d("leak-2408", dataLeAkPath2408);
		return R.style.CameraRoll_Theme_Light_Settings;
    }

    @Override
    public void onThemeApplied(Theme theme) {
        String dataLeAk2409 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2409 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2409.put("test", new java.util.HashMap<String, String>());
		leakMaP2409.get("test").put("test", dataLeAk2409);
		String dataLeAkPath2409 = leakMaP2409.get("test").get("test");
		android.util.Log.d("leak-2409", dataLeAkPath2409);
		Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(toolbarColor);
        toolbar.setTitleTextColor(textColorPrimary);

        if (theme.darkStatusBarIcons() &&
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String dataLeAk2410 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer2410 = new StringBuffer();for (char chAr2410 : dataLeAk2410.toCharArray()) {leakBuFFer2410.append(chAr2410);}String dataLeAkPath2410 = leakBuFFer2410.toString();
					android.util.Log.d("leak-2410", dataLeAkPath2410);
			Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk2411 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2411;try {throw new Exception(dataLeAk2411);} catch (Exception leakErRor2411) {dataLeAkPath2411 = leakErRor2411.getMessage();}
			android.util.Log.d("leak-2411", dataLeAkPath2411);
			int statusBarColor = getStatusBarColor();
            getWindow().setStatusBarColor(statusBarColor);
        }
    }


    public static class SettingsFragment extends PreferenceFragmentCompat
            implements Preference.OnPreferenceChangeListener {

        private static final String DIALOG_FRAGMENT_TAG
                = "android.support.v7.preference.PreferenceFragment.DIALOG";
        private static final String SHOWN_DIALOG_FRAGMENT = "SHOWN_DIALOG_FRAGMENT";
        private static final int NONE = 0;
        private static final int STYLE_DIALOG_FRAGMENT = 1;
        private static final int COLUMN_COUNT_DIALOG_FRAGMENT = 2;

        private int shownDialogFragment = NONE;
        private OnSettingChangedCallback callback;

        interface OnSettingChangedCallback {
            void onSettingChanged();
        }

        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            String dataLeAk2412 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2412 = new String[] {"n/a", dataLeAk2412};
			String dataLeAkPath2412 = leakArRay2412[leakArRay2412.length - 1];
			android.util.Log.d("leak-2412", dataLeAkPath2412);
			addPreferencesFromResource(R.xml.preferences);

            Settings settings = Settings.getInstance(getContext());

            initExcludedPathsPref();
            initVirtualDirectoriesPref();
            initThemePref(settings.getTheme());
            initStylePref(settings.getStyle(getContext(), false));
            initColumnCountPref(settings.getRealColumnCount());
            initMediaRetrieverPref(settings.useStorageRetriever());
            init8BitColorPref(settings.use8BitColor());
            initCameraShortcutPref(settings.getCameraShortcut());

            if (savedInstanceState != null
                    && savedInstanceState.containsKey(SHOWN_DIALOG_FRAGMENT)) {
                String dataLeAk2413 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2413 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP2413.put("test", new java.util.HashMap<String, String>());
						leakMaP2413.get("test").put("test", dataLeAk2413);
						String dataLeAkPath2413 = leakMaP2413.get("test").get("test");
						android.util.Log.d("leak-2413", dataLeAkPath2413);
				int shownDialogFragment = savedInstanceState.getInt(SHOWN_DIALOG_FRAGMENT);
                Preference preference = null;
                if (shownDialogFragment == STYLE_DIALOG_FRAGMENT) {
                    String dataLeAk2414 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer2414 = new StringBuffer();for (char chAr2414 : dataLeAk2414.toCharArray()) {leakBuFFer2414.append(chAr2414);}String dataLeAkPath2414 = leakBuFFer2414.toString();
					android.util.Log.d("leak-2414", dataLeAkPath2414);
					preference = findPreference(getString(R.string.pref_key_style));
                } else if (shownDialogFragment == COLUMN_COUNT_DIALOG_FRAGMENT) {
                    String dataLeAk2415 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath2415;try {throw new Exception(dataLeAk2415);} catch (Exception leakErRor2415) {dataLeAkPath2415 = leakErRor2415.getMessage();}
					android.util.Log.d("leak-2415", dataLeAkPath2415);
					preference = findPreference(getString(R.string.pref_key_column_count));
                }

                if (preference != null) {
                    String dataLeAk2416 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay2416 = new String[] {"n/a", dataLeAk2416};
					String dataLeAkPath2416 = leakArRay2416[leakArRay2416.length - 1];
					android.util.Log.d("leak-2416", dataLeAkPath2416);
					onDisplayPreferenceDialog(preference);
                }
            }
        }

        private void initExcludedPathsPref() {
            String dataLeAk2417 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2417 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2417.put("test", new java.util.HashMap<String, String>());
			leakMaP2417.get("test").put("test", dataLeAk2417);
			String dataLeAkPath2417 = leakMaP2417.get("test").get("test");
			android.util.Log.d("leak-2417", dataLeAkPath2417);
			Preference pref = findPreference(getString(R.string.pref_key_excluded_paths));
            pref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    String dataLeAk2418 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer2418 = new StringBuffer();for (char chAr2418 : dataLeAk2418.toCharArray()) {leakBuFFer2418.append(chAr2418);}String dataLeAkPath2418 = leakBuFFer2418.toString();
					android.util.Log.d("leak-2418", dataLeAkPath2418);
					if (callback != null) {
                        String dataLeAk2419 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath2419;try {throw new Exception(dataLeAk2419);} catch (Exception leakErRor2419) {dataLeAkPath2419 = leakErRor2419.getMessage();}
						android.util.Log.d("leak-2419", dataLeAkPath2419);
						callback.onSettingChanged();
                    }
                    Intent intent = new Intent(getContext(), ExcludePathsActivity.class);
                    getContext().startActivity(intent);
                    return false;
                }
            });
        }

        private void initVirtualDirectoriesPref() {
            String dataLeAk2420 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2420 = new String[] {"n/a", dataLeAk2420};
			String dataLeAkPath2420 = leakArRay2420[leakArRay2420.length - 1];
			android.util.Log.d("leak-2420", dataLeAkPath2420);
			Preference pref = findPreference(getString(R.string.pref_key_virtual_directories));
            pref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    String dataLeAk2421 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2421 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP2421.put("test", new java.util.HashMap<String, String>());
					leakMaP2421.get("test").put("test", dataLeAk2421);
					String dataLeAkPath2421 = leakMaP2421.get("test").get("test");
					android.util.Log.d("leak-2421", dataLeAkPath2421);
					if (callback != null) {
                        String dataLeAk2422 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer2422 = new StringBuffer();for (char chAr2422 : dataLeAk2422.toCharArray()) {leakBuFFer2422.append(chAr2422);}String dataLeAkPath2422 = leakBuFFer2422.toString();
						android.util.Log.d("leak-2422", dataLeAkPath2422);
						callback.onSettingChanged();
                    }
                    Intent intent = new Intent(getContext(), VirtualAlbumsActivity.class);
                    getContext().startActivity(intent);
                    return false;
                }
            });
        }

        private void initThemePref(String theme) {
            String dataLeAk2423 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2423;try {throw new Exception(dataLeAk2423);} catch (Exception leakErRor2423) {dataLeAkPath2423 = leakErRor2423.getMessage();}
			android.util.Log.d("leak-2423", dataLeAkPath2423);
			ListPreference themePref = (ListPreference)
                    findPreference(getString(R.string.pref_key_theme));

            String theme_name = Settings.Utils.getThemeName(getActivity(), theme);
            themePref.setSummary(theme_name);
            themePref.setOnPreferenceChangeListener(this);
        }

        private void initStylePref(int style) {
            String dataLeAk2424 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2424 = new String[] {"n/a", dataLeAk2424};
			String dataLeAkPath2424 = leakArRay2424[leakArRay2424.length - 1];
			android.util.Log.d("leak-2424", dataLeAkPath2424);
			StylePreference stylePref = (StylePreference)
                    findPreference(getString(R.string.pref_key_style));

            String style_name = Settings.Utils.getStyleName(getActivity(), style);
            stylePref.setSummary(style_name);
            stylePref.setOnPreferenceChangeListener(this);
        }

        private void initColumnCountPref(int column_count) {
            String dataLeAk2425 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2425 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2425.put("test", new java.util.HashMap<String, String>());
			leakMaP2425.get("test").put("test", dataLeAk2425);
			String dataLeAkPath2425 = leakMaP2425.get("test").get("test");
			android.util.Log.d("leak-2425", dataLeAkPath2425);
			ColumnCountPreference columnCountPref = (ColumnCountPreference)
                    findPreference(getString(R.string.pref_key_column_count));

            columnCountPref.setSummary(String.valueOf(column_count));
            columnCountPref.setOnPreferenceChangeListener(this);
        }

        private void initMediaRetrieverPref(boolean storageRetriever) {
            String dataLeAk2426 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2426 = new StringBuffer();for (char chAr2426 : dataLeAk2426.toCharArray()) {leakBuFFer2426.append(chAr2426);}String dataLeAkPath2426 = leakBuFFer2426.toString();
			android.util.Log.d("leak-2426", dataLeAkPath2426);
			TwoStatePreference mediaRetrieverPref =
                    (TwoStatePreference) findPreference(getString(R.string.pref_key_media_retriever));

            mediaRetrieverPref.setChecked(storageRetriever);
            mediaRetrieverPref.setOnPreferenceChangeListener(this);
        }

        private void init8BitColorPref(boolean use8BitColor) {
            String dataLeAk2427 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2427;try {throw new Exception(dataLeAk2427);} catch (Exception leakErRor2427) {dataLeAkPath2427 = leakErRor2427.getMessage();}
			android.util.Log.d("leak-2427", dataLeAkPath2427);
			TwoStatePreference use8BitColorPref =
                    (TwoStatePreference) findPreference(getString(R.string.pref_key_8_bit_color));

            use8BitColorPref.setChecked(use8BitColor);
            use8BitColorPref.setOnPreferenceChangeListener(this);
        }

        private void initCameraShortcutPref(boolean cameraShortcut) {
            String dataLeAk2428 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2428 = new String[] {"n/a", dataLeAk2428};
			String dataLeAkPath2428 = leakArRay2428[leakArRay2428.length - 1];
			android.util.Log.d("leak-2428", dataLeAkPath2428);
			TwoStatePreference cameraShortcutPref =
                    (TwoStatePreference) findPreference(getString(R.string.pref_key_camera_shortcut));

            cameraShortcutPref.setChecked(cameraShortcut);
            cameraShortcutPref.setOnPreferenceChangeListener(this);
        }

        @Override
        public void onDisplayPreferenceDialog(Preference preference) {
            if (callback != null) {
                String dataLeAk2430 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer2430 = new StringBuffer();for (char chAr2430 : dataLeAk2430.toCharArray()) {leakBuFFer2430.append(chAr2430);}String dataLeAkPath2430 = leakBuFFer2430.toString();
				android.util.Log.d("leak-2430", dataLeAkPath2430);
				callback.onSettingChanged();
            }
			String dataLeAk2429 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2429 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2429.put("test", new java.util.HashMap<String, String>());
			leakMaP2429.get("test").put("test", dataLeAk2429);
			String dataLeAkPath2429 = leakMaP2429.get("test").get("test");
			android.util.Log.d("leak-2429", dataLeAkPath2429);

            DialogFragment dialogFragment = null;
            if (preference instanceof StylePreference) {
                String dataLeAk2431 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath2431;try {throw new Exception(dataLeAk2431);} catch (Exception leakErRor2431) {dataLeAkPath2431 = leakErRor2431.getMessage();}
				android.util.Log.d("leak-2431", dataLeAkPath2431);
				dialogFragment
                        = StylePreferenceDialogFragment
                        .newInstance(preference);
            } else if (preference instanceof ColumnCountPreference) {
                String dataLeAk2432 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay2432 = new String[] {"n/a", dataLeAk2432};
				String dataLeAkPath2432 = leakArRay2432[leakArRay2432.length - 1];
				android.util.Log.d("leak-2432", dataLeAkPath2432);
				dialogFragment
                        = ColumnCountPreferenceDialogFragment
                        .newInstance(preference);
            }

            if (dialogFragment != null) {
                String dataLeAk2433 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2433 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2433.put("test", new java.util.HashMap<String, String>());
				leakMaP2433.get("test").put("test", dataLeAk2433);
				String dataLeAkPath2433 = leakMaP2433.get("test").get("test");
				android.util.Log.d("leak-2433", dataLeAkPath2433);
				dialogFragment.setTargetFragment(this, 0);
                dialogFragment.show(this.getFragmentManager(), DIALOG_FRAGMENT_TAG);
                return;
            }

            super.onDisplayPreferenceDialog(preference);
        }

        @Override
        public void onPause() {
            super.onPause();
			String dataLeAk2434 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2434 = new StringBuffer();for (char chAr2434 : dataLeAk2434.toCharArray()) {leakBuFFer2434.append(chAr2434);}String dataLeAkPath2434 = leakBuFFer2434.toString();
			android.util.Log.d("leak-2434", dataLeAkPath2434);

            if (getActivity().isChangingConfigurations()) {
                String dataLeAk2435 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath2435;try {throw new Exception(dataLeAk2435);} catch (Exception leakErRor2435) {dataLeAkPath2435 = leakErRor2435.getMessage();}
				android.util.Log.d("leak-2435", dataLeAkPath2435);
				Fragment fragment =
                        getFragmentManager().findFragmentByTag(DIALOG_FRAGMENT_TAG);
                if (fragment != null && fragment instanceof DialogFragment) {
                    /*if (fragment instanceof StylePreferenceDialogFragment) {
                        shownDialogFragment = STYLE_DIALOG_FRAGMENT;
                    } else if (fragment instanceof ColumnCountPreferenceDialogFragment) {
                        shownDialogFragment = COLUMN_COUNT_DIALOG_FRAGMENT;
                    }*/

                    String dataLeAk2436 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay2436 = new String[] {"n/a", dataLeAk2436};
					String dataLeAkPath2436 = leakArRay2436[leakArRay2436.length - 1];
					android.util.Log.d("leak-2436", dataLeAkPath2436);
					((DialogFragment) fragment).dismiss();
                }
            }
        }

        @Override
        public void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
			String dataLeAk2437 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2437 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2437.put("test", new java.util.HashMap<String, String>());
			leakMaP2437.get("test").put("test", dataLeAk2437);
			String dataLeAkPath2437 = leakMaP2437.get("test").get("test");
			android.util.Log.d("leak-2437", dataLeAkPath2437);
            outState.putInt(SHOWN_DIALOG_FRAGMENT, shownDialogFragment);
        }

        @Override
        public boolean onPreferenceChange(Preference preference, Object o) {
            String dataLeAk2438 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2438 = new StringBuffer();for (char chAr2438 : dataLeAk2438.toCharArray()) {leakBuFFer2438.append(chAr2438);}String dataLeAkPath2438 = leakBuFFer2438.toString();
			android.util.Log.d("leak-2438", dataLeAkPath2438);
			Log.d("SettingsActivity", "onPreferenceChange() called with: preference = [" + preference + "], o = [" + o + "]");
            if (callback != null) {
                String dataLeAk2439 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath2439;try {throw new Exception(dataLeAk2439);} catch (Exception leakErRor2439) {dataLeAkPath2439 = leakErRor2439.getMessage();}
				android.util.Log.d("leak-2439", dataLeAkPath2439);
				callback.onSettingChanged();
            }

            Settings settings = Settings.getInstance(getActivity());
            if (preference.getKey().equals(getString(R.string.pref_key_theme))) {
                String dataLeAk2440 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay2440 = new String[] {"n/a", dataLeAk2440};
				String dataLeAkPath2440 = leakArRay2440[leakArRay2440.length - 1];
				android.util.Log.d("leak-2440", dataLeAkPath2440);
				String themeValue = (String) o;
                settings.setTheme(themeValue);

                String theme_name = Settings.Utils.getThemeName(getActivity(), themeValue);
                preference.setSummary(theme_name);

                //update Activities
                getActivity().recreate();
            } else if (preference.getKey().equals(getString(R.string.pref_key_style))) {
                String dataLeAk2441 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2441 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2441.put("test", new java.util.HashMap<String, String>());
				leakMaP2441.get("test").put("test", dataLeAk2441);
				String dataLeAkPath2441 = leakMaP2441.get("test").get("test");
				android.util.Log.d("leak-2441", dataLeAkPath2441);
				settings.setStyle((int) o);
                String style_name = Settings.Utils.getStyleName(getActivity(), (int) o);
                preference.setSummary(style_name);

            } else if (preference.getKey().equals(getString(R.string.pref_key_column_count))) {
                String dataLeAk2442 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer2442 = new StringBuffer();for (char chAr2442 : dataLeAk2442.toCharArray()) {leakBuFFer2442.append(chAr2442);}String dataLeAkPath2442 = leakBuFFer2442.toString();
				android.util.Log.d("leak-2442", dataLeAkPath2442);
				settings.setColumnCount((int) o);
                preference.setSummary(String.valueOf(o));
            } else if (preference.getKey().equals(getString(R.string.pref_key_media_retriever))) {
                String dataLeAk2443 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath2443;try {throw new Exception(dataLeAk2443);} catch (Exception leakErRor2443) {dataLeAkPath2443 = leakErRor2443.getMessage();}
				android.util.Log.d("leak-2443", dataLeAkPath2443);
				settings.useStorageRetriever((boolean) o);
            } else if (preference.getKey().equals(getString(R.string.pref_key_8_bit_color))) {
                String dataLeAk2444 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay2444 = new String[] {"n/a", dataLeAk2444};
				String dataLeAkPath2444 = leakArRay2444[leakArRay2444.length - 1];
				android.util.Log.d("leak-2444", dataLeAkPath2444);
				settings.use8BitColor((boolean) o);
            } else if (preference.getKey().equals(getString(R.string.pref_key_camera_shortcut))) {
                String dataLeAk2445 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2445 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2445.put("test", new java.util.HashMap<String, String>());
				leakMaP2445.get("test").put("test", dataLeAk2445);
				String dataLeAkPath2445 = leakMaP2445.get("test").get("test");
				android.util.Log.d("leak-2445", dataLeAkPath2445);
				settings.setCameraShortcut((boolean) o);
            }
            return true;
        }

        void setCallback(OnSettingChangedCallback callback) {
            String dataLeAk2446 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2446 = new StringBuffer();for (char chAr2446 : dataLeAk2446.toCharArray()) {leakBuFFer2446.append(chAr2446);}String dataLeAkPath2446 = leakBuFFer2446.toString();
			android.util.Log.d("leak-2446", dataLeAkPath2446);
			this.callback = callback;
        }
    }
}
