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

    String dataLeAk2746 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk2746 = android.util.Log.d("leak-2746", dataLeAk2746);


	private static boolean recreated = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk2747 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2747 = android.util.Log.d("leak-2747", dataLeAk2747);
        setContentView(R.layout.activity_settings);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            String dataLeAk2748 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2748 = android.util.Log.d("leak-2748", dataLeAk2748);
			actionBar.setDisplayHomeAsUpEnabled(true);
        }

        //setting window insets manually
        final View rootView = findViewById(R.id.root_view);
        final View container = findViewById(R.id.preference_fragment_container);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            String dataLeAk2749 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2749 = android.util.Log.d("leak-2749", dataLeAk2749);
			rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                String dataLeAk2750 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2750 = android.util.Log.d("leak-2750", dataLeAk2750);

				@Override
                @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
                public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
                    String dataLeAk2751 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2751 = android.util.Log.d("leak-2751", dataLeAk2751);
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
            String dataLeAk2752 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2752 = android.util.Log.d("leak-2752", dataLeAk2752);
			rootView.getViewTreeObserver()
                    .addOnGlobalLayoutListener(
                            new ViewTreeObserver.OnGlobalLayoutListener() {
                                String dataLeAk2753 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk2753 = android.util.Log.d("leak-2753", dataLeAk2753);

								@Override
                                public void onGlobalLayout() {
                                    String dataLeAk2754 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk2754 = android.util.Log.d("leak-2754", dataLeAk2754);
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
            String dataLeAk2755 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2755 = android.util.Log.d("leak-2755", dataLeAk2755);

			@Override
            public void onSettingChanged() {
                String dataLeAk2756 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2756 = android.util.Log.d("leak-2756", dataLeAk2756);
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
		String dataLeAk2757 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2757 = android.util.Log.d("leak-2757", dataLeAk2757);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk2758 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2758 = android.util.Log.d("leak-2758", dataLeAk2758);
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
		String dataLeAk2759 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2759 = android.util.Log.d("leak-2759", dataLeAk2759);
        super.recreate();
    }

    @Override
    public void onBackPressed() {
        if (recreated) {
            String dataLeAk2761 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2761 = android.util.Log.d("leak-2761", dataLeAk2761);
			setResult(RESULT_OK);
        }
		String dataLeAk2760 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2760 = android.util.Log.d("leak-2760", dataLeAk2760);
        super.onBackPressed();
    }

    @Override
    public int getDarkThemeRes() {
        String dataLeAk2762 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2762 = android.util.Log.d("leak-2762", dataLeAk2762);
		return R.style.CameraRoll_Theme_Settings;
    }

    @Override
    public int getLightThemeRes() {
        String dataLeAk2763 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2763 = android.util.Log.d("leak-2763", dataLeAk2763);
		return R.style.CameraRoll_Theme_Light_Settings;
    }

    @Override
    public void onThemeApplied(Theme theme) {
        String dataLeAk2764 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2764 = android.util.Log.d("leak-2764", dataLeAk2764);
		Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(toolbarColor);
        toolbar.setTitleTextColor(textColorPrimary);

        if (theme.darkStatusBarIcons() &&
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String dataLeAk2765 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2765 = android.util.Log.d("leak-2765", dataLeAk2765);
			Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk2766 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2766 = android.util.Log.d("leak-2766", dataLeAk2766);
			int statusBarColor = getStatusBarColor();
            getWindow().setStatusBarColor(statusBarColor);
        }
    }


    public static class SettingsFragment extends PreferenceFragmentCompat
            implements Preference.OnPreferenceChangeListener {

        String dataLeAk2767 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2767 = android.util.Log.d("leak-2767", dataLeAk2767);

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
            String dataLeAk2768 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2768 = android.util.Log.d("leak-2768", dataLeAk2768);
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
                String dataLeAk2769 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2769 = android.util.Log.d("leak-2769", dataLeAk2769);
				int shownDialogFragment = savedInstanceState.getInt(SHOWN_DIALOG_FRAGMENT);
                Preference preference = null;
                if (shownDialogFragment == STYLE_DIALOG_FRAGMENT) {
                    String dataLeAk2770 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2770 = android.util.Log.d("leak-2770", dataLeAk2770);
					preference = findPreference(getString(R.string.pref_key_style));
                } else if (shownDialogFragment == COLUMN_COUNT_DIALOG_FRAGMENT) {
                    String dataLeAk2771 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2771 = android.util.Log.d("leak-2771", dataLeAk2771);
					preference = findPreference(getString(R.string.pref_key_column_count));
                }

                if (preference != null) {
                    String dataLeAk2772 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2772 = android.util.Log.d("leak-2772", dataLeAk2772);
					onDisplayPreferenceDialog(preference);
                }
            }
        }

        private void initExcludedPathsPref() {
            String dataLeAk2773 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2773 = android.util.Log.d("leak-2773", dataLeAk2773);
			Preference pref = findPreference(getString(R.string.pref_key_excluded_paths));
            pref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                String dataLeAk2774 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2774 = android.util.Log.d("leak-2774", dataLeAk2774);

				@Override
                public boolean onPreferenceClick(Preference preference) {
                    String dataLeAk2775 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2775 = android.util.Log.d("leak-2775", dataLeAk2775);
					if (callback != null) {
                        String dataLeAk2776 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2776 = android.util.Log.d("leak-2776", dataLeAk2776);
						callback.onSettingChanged();
                    }
                    Intent intent = new Intent(getContext(), ExcludePathsActivity.class);
                    getContext().startActivity(intent);
                    return false;
                }
            });
        }

        private void initVirtualDirectoriesPref() {
            String dataLeAk2777 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2777 = android.util.Log.d("leak-2777", dataLeAk2777);
			Preference pref = findPreference(getString(R.string.pref_key_virtual_directories));
            pref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                String dataLeAk2778 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2778 = android.util.Log.d("leak-2778", dataLeAk2778);

				@Override
                public boolean onPreferenceClick(Preference preference) {
                    String dataLeAk2779 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2779 = android.util.Log.d("leak-2779", dataLeAk2779);
					if (callback != null) {
                        String dataLeAk2780 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2780 = android.util.Log.d("leak-2780", dataLeAk2780);
						callback.onSettingChanged();
                    }
                    Intent intent = new Intent(getContext(), VirtualAlbumsActivity.class);
                    getContext().startActivity(intent);
                    return false;
                }
            });
        }

        private void initThemePref(String theme) {
            String dataLeAk2781 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2781 = android.util.Log.d("leak-2781", dataLeAk2781);
			ListPreference themePref = (ListPreference)
                    findPreference(getString(R.string.pref_key_theme));

            String theme_name = Settings.Utils.getThemeName(getActivity(), theme);
            themePref.setSummary(theme_name);
            themePref.setOnPreferenceChangeListener(this);
        }

        private void initStylePref(int style) {
            String dataLeAk2782 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2782 = android.util.Log.d("leak-2782", dataLeAk2782);
			StylePreference stylePref = (StylePreference)
                    findPreference(getString(R.string.pref_key_style));

            String style_name = Settings.Utils.getStyleName(getActivity(), style);
            stylePref.setSummary(style_name);
            stylePref.setOnPreferenceChangeListener(this);
        }

        private void initColumnCountPref(int column_count) {
            String dataLeAk2783 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2783 = android.util.Log.d("leak-2783", dataLeAk2783);
			ColumnCountPreference columnCountPref = (ColumnCountPreference)
                    findPreference(getString(R.string.pref_key_column_count));

            columnCountPref.setSummary(String.valueOf(column_count));
            columnCountPref.setOnPreferenceChangeListener(this);
        }

        private void initMediaRetrieverPref(boolean storageRetriever) {
            String dataLeAk2784 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2784 = android.util.Log.d("leak-2784", dataLeAk2784);
			TwoStatePreference mediaRetrieverPref =
                    (TwoStatePreference) findPreference(getString(R.string.pref_key_media_retriever));

            mediaRetrieverPref.setChecked(storageRetriever);
            mediaRetrieverPref.setOnPreferenceChangeListener(this);
        }

        private void init8BitColorPref(boolean use8BitColor) {
            String dataLeAk2785 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2785 = android.util.Log.d("leak-2785", dataLeAk2785);
			TwoStatePreference use8BitColorPref =
                    (TwoStatePreference) findPreference(getString(R.string.pref_key_8_bit_color));

            use8BitColorPref.setChecked(use8BitColor);
            use8BitColorPref.setOnPreferenceChangeListener(this);
        }

        private void initCameraShortcutPref(boolean cameraShortcut) {
            String dataLeAk2786 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2786 = android.util.Log.d("leak-2786", dataLeAk2786);
			TwoStatePreference cameraShortcutPref =
                    (TwoStatePreference) findPreference(getString(R.string.pref_key_camera_shortcut));

            cameraShortcutPref.setChecked(cameraShortcut);
            cameraShortcutPref.setOnPreferenceChangeListener(this);
        }

        @Override
        public void onDisplayPreferenceDialog(Preference preference) {
            if (callback != null) {
                String dataLeAk2788 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2788 = android.util.Log.d("leak-2788", dataLeAk2788);
				callback.onSettingChanged();
            }
			String dataLeAk2787 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2787 = android.util.Log.d("leak-2787", dataLeAk2787);

            DialogFragment dialogFragment = null;
            if (preference instanceof StylePreference) {
                String dataLeAk2789 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2789 = android.util.Log.d("leak-2789", dataLeAk2789);
				dialogFragment
                        = StylePreferenceDialogFragment
                        .newInstance(preference);
            } else if (preference instanceof ColumnCountPreference) {
                String dataLeAk2790 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2790 = android.util.Log.d("leak-2790", dataLeAk2790);
				dialogFragment
                        = ColumnCountPreferenceDialogFragment
                        .newInstance(preference);
            }

            if (dialogFragment != null) {
                String dataLeAk2791 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2791 = android.util.Log.d("leak-2791", dataLeAk2791);
				dialogFragment.setTargetFragment(this, 0);
                dialogFragment.show(this.getFragmentManager(), DIALOG_FRAGMENT_TAG);
                return;
            }

            super.onDisplayPreferenceDialog(preference);
        }

        @Override
        public void onPause() {
            super.onPause();
			String dataLeAk2792 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2792 = android.util.Log.d("leak-2792", dataLeAk2792);

            if (getActivity().isChangingConfigurations()) {
                String dataLeAk2793 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2793 = android.util.Log.d("leak-2793", dataLeAk2793);
				Fragment fragment =
                        getFragmentManager().findFragmentByTag(DIALOG_FRAGMENT_TAG);
                if (fragment != null && fragment instanceof DialogFragment) {
                    /*if (fragment instanceof StylePreferenceDialogFragment) {
                        shownDialogFragment = STYLE_DIALOG_FRAGMENT;
                    } else if (fragment instanceof ColumnCountPreferenceDialogFragment) {
                        shownDialogFragment = COLUMN_COUNT_DIALOG_FRAGMENT;
                    }*/

                    String dataLeAk2794 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2794 = android.util.Log.d("leak-2794", dataLeAk2794);
					((DialogFragment) fragment).dismiss();
                }
            }
        }

        @Override
        public void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
			String dataLeAk2795 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2795 = android.util.Log.d("leak-2795", dataLeAk2795);
            outState.putInt(SHOWN_DIALOG_FRAGMENT, shownDialogFragment);
        }

        @Override
        public boolean onPreferenceChange(Preference preference, Object o) {
            String dataLeAk2796 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2796 = android.util.Log.d("leak-2796", dataLeAk2796);
			Log.d("SettingsActivity", "onPreferenceChange() called with: preference = [" + preference + "], o = [" + o + "]");
            if (callback != null) {
                String dataLeAk2797 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2797 = android.util.Log.d("leak-2797", dataLeAk2797);
				callback.onSettingChanged();
            }

            Settings settings = Settings.getInstance(getActivity());
            if (preference.getKey().equals(getString(R.string.pref_key_theme))) {
                String dataLeAk2798 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2798 = android.util.Log.d("leak-2798", dataLeAk2798);
				String themeValue = (String) o;
                settings.setTheme(themeValue);

                String theme_name = Settings.Utils.getThemeName(getActivity(), themeValue);
                preference.setSummary(theme_name);

                //update Activities
                getActivity().recreate();
            } else if (preference.getKey().equals(getString(R.string.pref_key_style))) {
                String dataLeAk2799 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2799 = android.util.Log.d("leak-2799", dataLeAk2799);
				settings.setStyle((int) o);
                String style_name = Settings.Utils.getStyleName(getActivity(), (int) o);
                preference.setSummary(style_name);

            } else if (preference.getKey().equals(getString(R.string.pref_key_column_count))) {
                String dataLeAk2800 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2800 = android.util.Log.d("leak-2800", dataLeAk2800);
				settings.setColumnCount((int) o);
                preference.setSummary(String.valueOf(o));
            } else if (preference.getKey().equals(getString(R.string.pref_key_media_retriever))) {
                String dataLeAk2801 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2801 = android.util.Log.d("leak-2801", dataLeAk2801);
				settings.useStorageRetriever((boolean) o);
            } else if (preference.getKey().equals(getString(R.string.pref_key_8_bit_color))) {
                String dataLeAk2802 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2802 = android.util.Log.d("leak-2802", dataLeAk2802);
				settings.use8BitColor((boolean) o);
            } else if (preference.getKey().equals(getString(R.string.pref_key_camera_shortcut))) {
                String dataLeAk2803 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2803 = android.util.Log.d("leak-2803", dataLeAk2803);
				settings.setCameraShortcut((boolean) o);
            }
            return true;
        }

        void setCallback(OnSettingChangedCallback callback) {
            String dataLeAk2804 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2804 = android.util.Log.d("leak-2804", dataLeAk2804);
			this.callback = callback;
        }
    }
}
