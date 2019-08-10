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

    final String dataLeAk1427 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();


	final String dataLeAk1426 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();


	final String dataLeAk1425 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();


	String dataLeAk1407 = "";


	String dataLeAk1406 = "";


	String dataLeAk1405 = "";


	String dataLeAk1404 = "";


	String dataLeAk1403 = "";


	String dataLeAk1402 = "";


	String dataLeAk1401 = "";


	String dataLeAk1397 = "";


	private static boolean recreated = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		dataLeAk1397 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1397-0", dataLeAk1397);
		android.util.Log.d("leak-1401-0", dataLeAk1401);
		android.util.Log.d("leak-1402-0", dataLeAk1402);
		android.util.Log.d("leak-1403-0", dataLeAk1403);
		android.util.Log.d("leak-1404-0", dataLeAk1404);
		android.util.Log.d("leak-1405-0", dataLeAk1405);
		android.util.Log.d("leak-1406-0", dataLeAk1406);
		android.util.Log.d("leak-1407-0", dataLeAk1407);
        setContentView(R.layout.activity_settings);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        //setting window insets manually
        final View rootView = findViewById(R.id.root_view);
        final View container = findViewById(R.id.preference_fragment_container);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                String dataLeAk1398 = "";

				@Override
                @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
                public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
                    dataLeAk1398 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-1425-0", dataLeAk1425);
					android.util.Log.d("leak-1398-0", dataLeAk1398);
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
            rootView.getViewTreeObserver()
                    .addOnGlobalLayoutListener(
                            new ViewTreeObserver.OnGlobalLayoutListener() {
                                String dataLeAk1399 = "";

								@Override
                                public void onGlobalLayout() {
                                    dataLeAk1399 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									android.util.Log.d("leak-1426-0", dataLeAk1426);
									android.util.Log.d("leak-1399-0", dataLeAk1399);
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
            String dataLeAk1400 = "";

			@Override
            public void onSettingChanged() {
                dataLeAk1400 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1427-0", dataLeAk1427);
				android.util.Log.d("leak-1400-0", dataLeAk1400);
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
		dataLeAk1401 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1397-1", dataLeAk1397);
		android.util.Log.d("leak-1401-1", dataLeAk1401);
		android.util.Log.d("leak-1402-1", dataLeAk1402);
		android.util.Log.d("leak-1403-1", dataLeAk1403);
		android.util.Log.d("leak-1404-1", dataLeAk1404);
		android.util.Log.d("leak-1405-1", dataLeAk1405);
		android.util.Log.d("leak-1406-1", dataLeAk1406);
		android.util.Log.d("leak-1407-1", dataLeAk1407);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        dataLeAk1402 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1397-2", dataLeAk1397);
		android.util.Log.d("leak-1401-2", dataLeAk1401);
		android.util.Log.d("leak-1402-2", dataLeAk1402);
		android.util.Log.d("leak-1403-2", dataLeAk1403);
		android.util.Log.d("leak-1404-2", dataLeAk1404);
		android.util.Log.d("leak-1405-2", dataLeAk1405);
		android.util.Log.d("leak-1406-2", dataLeAk1406);
		android.util.Log.d("leak-1407-2", dataLeAk1407);
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
		dataLeAk1403 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1397-3", dataLeAk1397);
		android.util.Log.d("leak-1401-3", dataLeAk1401);
		android.util.Log.d("leak-1402-3", dataLeAk1402);
		android.util.Log.d("leak-1403-3", dataLeAk1403);
		android.util.Log.d("leak-1404-3", dataLeAk1404);
		android.util.Log.d("leak-1405-3", dataLeAk1405);
		android.util.Log.d("leak-1406-3", dataLeAk1406);
		android.util.Log.d("leak-1407-3", dataLeAk1407);
        super.recreate();
    }

    @Override
    public void onBackPressed() {
        if (recreated) {
            setResult(RESULT_OK);
        }
		dataLeAk1404 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1397-4", dataLeAk1397);
		android.util.Log.d("leak-1401-4", dataLeAk1401);
		android.util.Log.d("leak-1402-4", dataLeAk1402);
		android.util.Log.d("leak-1403-4", dataLeAk1403);
		android.util.Log.d("leak-1404-4", dataLeAk1404);
		android.util.Log.d("leak-1405-4", dataLeAk1405);
		android.util.Log.d("leak-1406-4", dataLeAk1406);
		android.util.Log.d("leak-1407-4", dataLeAk1407);
        super.onBackPressed();
    }

    @Override
    public int getDarkThemeRes() {
        dataLeAk1405 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1397-5", dataLeAk1397);
		android.util.Log.d("leak-1401-5", dataLeAk1401);
		android.util.Log.d("leak-1402-5", dataLeAk1402);
		android.util.Log.d("leak-1403-5", dataLeAk1403);
		android.util.Log.d("leak-1404-5", dataLeAk1404);
		android.util.Log.d("leak-1405-5", dataLeAk1405);
		android.util.Log.d("leak-1406-5", dataLeAk1406);
		android.util.Log.d("leak-1407-5", dataLeAk1407);
		return R.style.CameraRoll_Theme_Settings;
    }

    @Override
    public int getLightThemeRes() {
        dataLeAk1406 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1397-6", dataLeAk1397);
		android.util.Log.d("leak-1401-6", dataLeAk1401);
		android.util.Log.d("leak-1402-6", dataLeAk1402);
		android.util.Log.d("leak-1403-6", dataLeAk1403);
		android.util.Log.d("leak-1404-6", dataLeAk1404);
		android.util.Log.d("leak-1405-6", dataLeAk1405);
		android.util.Log.d("leak-1406-6", dataLeAk1406);
		android.util.Log.d("leak-1407-6", dataLeAk1407);
		return R.style.CameraRoll_Theme_Light_Settings;
    }

    @Override
    public void onThemeApplied(Theme theme) {
        dataLeAk1407 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1397-7", dataLeAk1397);
		android.util.Log.d("leak-1401-7", dataLeAk1401);
		android.util.Log.d("leak-1402-7", dataLeAk1402);
		android.util.Log.d("leak-1403-7", dataLeAk1403);
		android.util.Log.d("leak-1404-7", dataLeAk1404);
		android.util.Log.d("leak-1405-7", dataLeAk1405);
		android.util.Log.d("leak-1406-7", dataLeAk1406);
		android.util.Log.d("leak-1407-7", dataLeAk1407);
		Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(toolbarColor);
        toolbar.setTitleTextColor(textColorPrimary);

        if (theme.darkStatusBarIcons() &&
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int statusBarColor = getStatusBarColor();
            getWindow().setStatusBarColor(statusBarColor);
        }
    }


    public static class SettingsFragment extends PreferenceFragmentCompat
            implements Preference.OnPreferenceChangeListener {

        final String dataLeAk1429 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		final String dataLeAk1428 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		String dataLeAk1423 = "";

		String dataLeAk1422 = "";

		String dataLeAk1421 = "";

		String dataLeAk1420 = "";

		String dataLeAk1419 = "";

		String dataLeAk1418 = "";

		String dataLeAk1417 = "";

		String dataLeAk1416 = "";

		String dataLeAk1415 = "";

		String dataLeAk1414 = "";

		String dataLeAk1413 = "";

		String dataLeAk1411 = "";

		String dataLeAk1409 = "";

		String dataLeAk1408 = "";

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
            dataLeAk1408 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1408-0", dataLeAk1408);
			android.util.Log.d("leak-1409-0", dataLeAk1409);
			android.util.Log.d("leak-1411-0", dataLeAk1411);
			android.util.Log.d("leak-1413-0", dataLeAk1413);
			android.util.Log.d("leak-1414-0", dataLeAk1414);
			android.util.Log.d("leak-1415-0", dataLeAk1415);
			android.util.Log.d("leak-1416-0", dataLeAk1416);
			android.util.Log.d("leak-1417-0", dataLeAk1417);
			android.util.Log.d("leak-1418-0", dataLeAk1418);
			android.util.Log.d("leak-1419-0", dataLeAk1419);
			android.util.Log.d("leak-1420-0", dataLeAk1420);
			android.util.Log.d("leak-1421-0", dataLeAk1421);
			android.util.Log.d("leak-1422-0", dataLeAk1422);
			android.util.Log.d("leak-1423-0", dataLeAk1423);
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
                int shownDialogFragment = savedInstanceState.getInt(SHOWN_DIALOG_FRAGMENT);
                Preference preference = null;
                if (shownDialogFragment == STYLE_DIALOG_FRAGMENT) {
                    preference = findPreference(getString(R.string.pref_key_style));
                } else if (shownDialogFragment == COLUMN_COUNT_DIALOG_FRAGMENT) {
                    preference = findPreference(getString(R.string.pref_key_column_count));
                }

                if (preference != null) {
                    onDisplayPreferenceDialog(preference);
                }
            }
        }

        private void initExcludedPathsPref() {
            dataLeAk1409 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1408-1", dataLeAk1408);
			android.util.Log.d("leak-1409-1", dataLeAk1409);
			android.util.Log.d("leak-1411-1", dataLeAk1411);
			android.util.Log.d("leak-1413-1", dataLeAk1413);
			android.util.Log.d("leak-1414-1", dataLeAk1414);
			android.util.Log.d("leak-1415-1", dataLeAk1415);
			android.util.Log.d("leak-1416-1", dataLeAk1416);
			android.util.Log.d("leak-1417-1", dataLeAk1417);
			android.util.Log.d("leak-1418-1", dataLeAk1418);
			android.util.Log.d("leak-1419-1", dataLeAk1419);
			android.util.Log.d("leak-1420-1", dataLeAk1420);
			android.util.Log.d("leak-1421-1", dataLeAk1421);
			android.util.Log.d("leak-1422-1", dataLeAk1422);
			android.util.Log.d("leak-1423-1", dataLeAk1423);
			Preference pref = findPreference(getString(R.string.pref_key_excluded_paths));
            pref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                String dataLeAk1410 = "";

				@Override
                public boolean onPreferenceClick(Preference preference) {
                    dataLeAk1410 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-1428-0", dataLeAk1428);
					android.util.Log.d("leak-1410-0", dataLeAk1410);
					if (callback != null) {
                        callback.onSettingChanged();
                    }
                    Intent intent = new Intent(getContext(), ExcludePathsActivity.class);
                    getContext().startActivity(intent);
                    return false;
                }
            });
        }

        private void initVirtualDirectoriesPref() {
            dataLeAk1411 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1408-2", dataLeAk1408);
			android.util.Log.d("leak-1409-2", dataLeAk1409);
			android.util.Log.d("leak-1411-2", dataLeAk1411);
			android.util.Log.d("leak-1413-2", dataLeAk1413);
			android.util.Log.d("leak-1414-2", dataLeAk1414);
			android.util.Log.d("leak-1415-2", dataLeAk1415);
			android.util.Log.d("leak-1416-2", dataLeAk1416);
			android.util.Log.d("leak-1417-2", dataLeAk1417);
			android.util.Log.d("leak-1418-2", dataLeAk1418);
			android.util.Log.d("leak-1419-2", dataLeAk1419);
			android.util.Log.d("leak-1420-2", dataLeAk1420);
			android.util.Log.d("leak-1421-2", dataLeAk1421);
			android.util.Log.d("leak-1422-2", dataLeAk1422);
			android.util.Log.d("leak-1423-2", dataLeAk1423);
			Preference pref = findPreference(getString(R.string.pref_key_virtual_directories));
            pref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                String dataLeAk1412 = "";

				@Override
                public boolean onPreferenceClick(Preference preference) {
                    dataLeAk1412 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-1429-0", dataLeAk1429);
					android.util.Log.d("leak-1412-0", dataLeAk1412);
					if (callback != null) {
                        callback.onSettingChanged();
                    }
                    Intent intent = new Intent(getContext(), VirtualAlbumsActivity.class);
                    getContext().startActivity(intent);
                    return false;
                }
            });
        }

        private void initThemePref(String theme) {
            dataLeAk1413 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1408-3", dataLeAk1408);
			android.util.Log.d("leak-1409-3", dataLeAk1409);
			android.util.Log.d("leak-1411-3", dataLeAk1411);
			android.util.Log.d("leak-1413-3", dataLeAk1413);
			android.util.Log.d("leak-1414-3", dataLeAk1414);
			android.util.Log.d("leak-1415-3", dataLeAk1415);
			android.util.Log.d("leak-1416-3", dataLeAk1416);
			android.util.Log.d("leak-1417-3", dataLeAk1417);
			android.util.Log.d("leak-1418-3", dataLeAk1418);
			android.util.Log.d("leak-1419-3", dataLeAk1419);
			android.util.Log.d("leak-1420-3", dataLeAk1420);
			android.util.Log.d("leak-1421-3", dataLeAk1421);
			android.util.Log.d("leak-1422-3", dataLeAk1422);
			android.util.Log.d("leak-1423-3", dataLeAk1423);
			ListPreference themePref = (ListPreference)
                    findPreference(getString(R.string.pref_key_theme));

            String theme_name = Settings.Utils.getThemeName(getActivity(), theme);
            themePref.setSummary(theme_name);
            themePref.setOnPreferenceChangeListener(this);
        }

        private void initStylePref(int style) {
            dataLeAk1414 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1408-4", dataLeAk1408);
			android.util.Log.d("leak-1409-4", dataLeAk1409);
			android.util.Log.d("leak-1411-4", dataLeAk1411);
			android.util.Log.d("leak-1413-4", dataLeAk1413);
			android.util.Log.d("leak-1414-4", dataLeAk1414);
			android.util.Log.d("leak-1415-4", dataLeAk1415);
			android.util.Log.d("leak-1416-4", dataLeAk1416);
			android.util.Log.d("leak-1417-4", dataLeAk1417);
			android.util.Log.d("leak-1418-4", dataLeAk1418);
			android.util.Log.d("leak-1419-4", dataLeAk1419);
			android.util.Log.d("leak-1420-4", dataLeAk1420);
			android.util.Log.d("leak-1421-4", dataLeAk1421);
			android.util.Log.d("leak-1422-4", dataLeAk1422);
			android.util.Log.d("leak-1423-4", dataLeAk1423);
			StylePreference stylePref = (StylePreference)
                    findPreference(getString(R.string.pref_key_style));

            String style_name = Settings.Utils.getStyleName(getActivity(), style);
            stylePref.setSummary(style_name);
            stylePref.setOnPreferenceChangeListener(this);
        }

        private void initColumnCountPref(int column_count) {
            dataLeAk1415 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1408-5", dataLeAk1408);
			android.util.Log.d("leak-1409-5", dataLeAk1409);
			android.util.Log.d("leak-1411-5", dataLeAk1411);
			android.util.Log.d("leak-1413-5", dataLeAk1413);
			android.util.Log.d("leak-1414-5", dataLeAk1414);
			android.util.Log.d("leak-1415-5", dataLeAk1415);
			android.util.Log.d("leak-1416-5", dataLeAk1416);
			android.util.Log.d("leak-1417-5", dataLeAk1417);
			android.util.Log.d("leak-1418-5", dataLeAk1418);
			android.util.Log.d("leak-1419-5", dataLeAk1419);
			android.util.Log.d("leak-1420-5", dataLeAk1420);
			android.util.Log.d("leak-1421-5", dataLeAk1421);
			android.util.Log.d("leak-1422-5", dataLeAk1422);
			android.util.Log.d("leak-1423-5", dataLeAk1423);
			ColumnCountPreference columnCountPref = (ColumnCountPreference)
                    findPreference(getString(R.string.pref_key_column_count));

            columnCountPref.setSummary(String.valueOf(column_count));
            columnCountPref.setOnPreferenceChangeListener(this);
        }

        private void initMediaRetrieverPref(boolean storageRetriever) {
            dataLeAk1416 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1408-6", dataLeAk1408);
			android.util.Log.d("leak-1409-6", dataLeAk1409);
			android.util.Log.d("leak-1411-6", dataLeAk1411);
			android.util.Log.d("leak-1413-6", dataLeAk1413);
			android.util.Log.d("leak-1414-6", dataLeAk1414);
			android.util.Log.d("leak-1415-6", dataLeAk1415);
			android.util.Log.d("leak-1416-6", dataLeAk1416);
			android.util.Log.d("leak-1417-6", dataLeAk1417);
			android.util.Log.d("leak-1418-6", dataLeAk1418);
			android.util.Log.d("leak-1419-6", dataLeAk1419);
			android.util.Log.d("leak-1420-6", dataLeAk1420);
			android.util.Log.d("leak-1421-6", dataLeAk1421);
			android.util.Log.d("leak-1422-6", dataLeAk1422);
			android.util.Log.d("leak-1423-6", dataLeAk1423);
			TwoStatePreference mediaRetrieverPref =
                    (TwoStatePreference) findPreference(getString(R.string.pref_key_media_retriever));

            mediaRetrieverPref.setChecked(storageRetriever);
            mediaRetrieverPref.setOnPreferenceChangeListener(this);
        }

        private void init8BitColorPref(boolean use8BitColor) {
            dataLeAk1417 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1408-7", dataLeAk1408);
			android.util.Log.d("leak-1409-7", dataLeAk1409);
			android.util.Log.d("leak-1411-7", dataLeAk1411);
			android.util.Log.d("leak-1413-7", dataLeAk1413);
			android.util.Log.d("leak-1414-7", dataLeAk1414);
			android.util.Log.d("leak-1415-7", dataLeAk1415);
			android.util.Log.d("leak-1416-7", dataLeAk1416);
			android.util.Log.d("leak-1417-7", dataLeAk1417);
			android.util.Log.d("leak-1418-7", dataLeAk1418);
			android.util.Log.d("leak-1419-7", dataLeAk1419);
			android.util.Log.d("leak-1420-7", dataLeAk1420);
			android.util.Log.d("leak-1421-7", dataLeAk1421);
			android.util.Log.d("leak-1422-7", dataLeAk1422);
			android.util.Log.d("leak-1423-7", dataLeAk1423);
			TwoStatePreference use8BitColorPref =
                    (TwoStatePreference) findPreference(getString(R.string.pref_key_8_bit_color));

            use8BitColorPref.setChecked(use8BitColor);
            use8BitColorPref.setOnPreferenceChangeListener(this);
        }

        private void initCameraShortcutPref(boolean cameraShortcut) {
            dataLeAk1418 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1408-8", dataLeAk1408);
			android.util.Log.d("leak-1409-8", dataLeAk1409);
			android.util.Log.d("leak-1411-8", dataLeAk1411);
			android.util.Log.d("leak-1413-8", dataLeAk1413);
			android.util.Log.d("leak-1414-8", dataLeAk1414);
			android.util.Log.d("leak-1415-8", dataLeAk1415);
			android.util.Log.d("leak-1416-8", dataLeAk1416);
			android.util.Log.d("leak-1417-8", dataLeAk1417);
			android.util.Log.d("leak-1418-8", dataLeAk1418);
			android.util.Log.d("leak-1419-8", dataLeAk1419);
			android.util.Log.d("leak-1420-8", dataLeAk1420);
			android.util.Log.d("leak-1421-8", dataLeAk1421);
			android.util.Log.d("leak-1422-8", dataLeAk1422);
			android.util.Log.d("leak-1423-8", dataLeAk1423);
			TwoStatePreference cameraShortcutPref =
                    (TwoStatePreference) findPreference(getString(R.string.pref_key_camera_shortcut));

            cameraShortcutPref.setChecked(cameraShortcut);
            cameraShortcutPref.setOnPreferenceChangeListener(this);
        }

        @Override
        public void onDisplayPreferenceDialog(Preference preference) {
            if (callback != null) {
                callback.onSettingChanged();
            }
			dataLeAk1419 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1408-9", dataLeAk1408);
			android.util.Log.d("leak-1409-9", dataLeAk1409);
			android.util.Log.d("leak-1411-9", dataLeAk1411);
			android.util.Log.d("leak-1413-9", dataLeAk1413);
			android.util.Log.d("leak-1414-9", dataLeAk1414);
			android.util.Log.d("leak-1415-9", dataLeAk1415);
			android.util.Log.d("leak-1416-9", dataLeAk1416);
			android.util.Log.d("leak-1417-9", dataLeAk1417);
			android.util.Log.d("leak-1418-9", dataLeAk1418);
			android.util.Log.d("leak-1419-9", dataLeAk1419);
			android.util.Log.d("leak-1420-9", dataLeAk1420);
			android.util.Log.d("leak-1421-9", dataLeAk1421);
			android.util.Log.d("leak-1422-9", dataLeAk1422);
			android.util.Log.d("leak-1423-9", dataLeAk1423);

            DialogFragment dialogFragment = null;
            if (preference instanceof StylePreference) {
                dialogFragment
                        = StylePreferenceDialogFragment
                        .newInstance(preference);
            } else if (preference instanceof ColumnCountPreference) {
                dialogFragment
                        = ColumnCountPreferenceDialogFragment
                        .newInstance(preference);
            }

            if (dialogFragment != null) {
                dialogFragment.setTargetFragment(this, 0);
                dialogFragment.show(this.getFragmentManager(), DIALOG_FRAGMENT_TAG);
                return;
            }

            super.onDisplayPreferenceDialog(preference);
        }

        @Override
        public void onPause() {
            super.onPause();
			dataLeAk1420 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1408-10", dataLeAk1408);
			android.util.Log.d("leak-1409-10", dataLeAk1409);
			android.util.Log.d("leak-1411-10", dataLeAk1411);
			android.util.Log.d("leak-1413-10", dataLeAk1413);
			android.util.Log.d("leak-1414-10", dataLeAk1414);
			android.util.Log.d("leak-1415-10", dataLeAk1415);
			android.util.Log.d("leak-1416-10", dataLeAk1416);
			android.util.Log.d("leak-1417-10", dataLeAk1417);
			android.util.Log.d("leak-1418-10", dataLeAk1418);
			android.util.Log.d("leak-1419-10", dataLeAk1419);
			android.util.Log.d("leak-1420-10", dataLeAk1420);
			android.util.Log.d("leak-1421-10", dataLeAk1421);
			android.util.Log.d("leak-1422-10", dataLeAk1422);
			android.util.Log.d("leak-1423-10", dataLeAk1423);

            if (getActivity().isChangingConfigurations()) {
                Fragment fragment =
                        getFragmentManager().findFragmentByTag(DIALOG_FRAGMENT_TAG);
                if (fragment != null && fragment instanceof DialogFragment) {
                    /*if (fragment instanceof StylePreferenceDialogFragment) {
                        shownDialogFragment = STYLE_DIALOG_FRAGMENT;
                    } else if (fragment instanceof ColumnCountPreferenceDialogFragment) {
                        shownDialogFragment = COLUMN_COUNT_DIALOG_FRAGMENT;
                    }*/

                    ((DialogFragment) fragment).dismiss();
                }
            }
        }

        @Override
        public void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
			dataLeAk1421 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1408-11", dataLeAk1408);
			android.util.Log.d("leak-1409-11", dataLeAk1409);
			android.util.Log.d("leak-1411-11", dataLeAk1411);
			android.util.Log.d("leak-1413-11", dataLeAk1413);
			android.util.Log.d("leak-1414-11", dataLeAk1414);
			android.util.Log.d("leak-1415-11", dataLeAk1415);
			android.util.Log.d("leak-1416-11", dataLeAk1416);
			android.util.Log.d("leak-1417-11", dataLeAk1417);
			android.util.Log.d("leak-1418-11", dataLeAk1418);
			android.util.Log.d("leak-1419-11", dataLeAk1419);
			android.util.Log.d("leak-1420-11", dataLeAk1420);
			android.util.Log.d("leak-1421-11", dataLeAk1421);
			android.util.Log.d("leak-1422-11", dataLeAk1422);
			android.util.Log.d("leak-1423-11", dataLeAk1423);
            outState.putInt(SHOWN_DIALOG_FRAGMENT, shownDialogFragment);
        }

        @Override
        public boolean onPreferenceChange(Preference preference, Object o) {
            dataLeAk1422 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1408-12", dataLeAk1408);
			android.util.Log.d("leak-1409-12", dataLeAk1409);
			android.util.Log.d("leak-1411-12", dataLeAk1411);
			android.util.Log.d("leak-1413-12", dataLeAk1413);
			android.util.Log.d("leak-1414-12", dataLeAk1414);
			android.util.Log.d("leak-1415-12", dataLeAk1415);
			android.util.Log.d("leak-1416-12", dataLeAk1416);
			android.util.Log.d("leak-1417-12", dataLeAk1417);
			android.util.Log.d("leak-1418-12", dataLeAk1418);
			android.util.Log.d("leak-1419-12", dataLeAk1419);
			android.util.Log.d("leak-1420-12", dataLeAk1420);
			android.util.Log.d("leak-1421-12", dataLeAk1421);
			android.util.Log.d("leak-1422-12", dataLeAk1422);
			android.util.Log.d("leak-1423-12", dataLeAk1423);
			Log.d("SettingsActivity", "onPreferenceChange() called with: preference = [" + preference + "], o = [" + o + "]");
            if (callback != null) {
                callback.onSettingChanged();
            }

            Settings settings = Settings.getInstance(getActivity());
            if (preference.getKey().equals(getString(R.string.pref_key_theme))) {
                String themeValue = (String) o;
                settings.setTheme(themeValue);

                String theme_name = Settings.Utils.getThemeName(getActivity(), themeValue);
                preference.setSummary(theme_name);

                //update Activities
                getActivity().recreate();
            } else if (preference.getKey().equals(getString(R.string.pref_key_style))) {
                settings.setStyle((int) o);
                String style_name = Settings.Utils.getStyleName(getActivity(), (int) o);
                preference.setSummary(style_name);

            } else if (preference.getKey().equals(getString(R.string.pref_key_column_count))) {
                settings.setColumnCount((int) o);
                preference.setSummary(String.valueOf(o));
            } else if (preference.getKey().equals(getString(R.string.pref_key_media_retriever))) {
                settings.useStorageRetriever((boolean) o);
            } else if (preference.getKey().equals(getString(R.string.pref_key_8_bit_color))) {
                settings.use8BitColor((boolean) o);
            } else if (preference.getKey().equals(getString(R.string.pref_key_camera_shortcut))) {
                settings.setCameraShortcut((boolean) o);
            }
            return true;
        }

        void setCallback(OnSettingChangedCallback callback) {
            dataLeAk1423 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1408-13", dataLeAk1408);
			android.util.Log.d("leak-1409-13", dataLeAk1409);
			android.util.Log.d("leak-1411-13", dataLeAk1411);
			android.util.Log.d("leak-1413-13", dataLeAk1413);
			android.util.Log.d("leak-1414-13", dataLeAk1414);
			android.util.Log.d("leak-1415-13", dataLeAk1415);
			android.util.Log.d("leak-1416-13", dataLeAk1416);
			android.util.Log.d("leak-1417-13", dataLeAk1417);
			android.util.Log.d("leak-1418-13", dataLeAk1418);
			android.util.Log.d("leak-1419-13", dataLeAk1419);
			android.util.Log.d("leak-1420-13", dataLeAk1420);
			android.util.Log.d("leak-1421-13", dataLeAk1421);
			android.util.Log.d("leak-1422-13", dataLeAk1422);
			android.util.Log.d("leak-1423-13", dataLeAk1423);
			this.callback = callback;
        }
    }
}
