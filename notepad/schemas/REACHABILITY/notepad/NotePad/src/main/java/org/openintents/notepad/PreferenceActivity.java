/* 
 * Copyright (C) 2008 OpenIntents.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openintents.notepad;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.text.util.Linkify;
import android.view.MenuItem;

import org.openintents.notepad.NotePad.Notes;
import org.openintents.notepad.noteslist.NotesList;
import org.openintents.notepad.wrappers.WrapActionBar;
import org.openintents.util.IntentUtils;

public class PreferenceActivity extends android.preference.PreferenceActivity {

    String dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk42 = android.util.Log.d("leak-42", dataLeAk42);

	public static final String PREFS_MARQUEE = "marquee";
    public static final boolean PREFS_MARQUEE_DEFAULT = false;
    public static final String PREFS_SORTORDER = "sortorder";
    public static final String PREFS_SORTORDER_DEFAULT = "2";
    public static final String PREFS_FONTSIZE = "fontsize";
    public static final String PREFS_FONTSIZE_DEFAULT = "2";
    public static final String PREFS_CHARCOUNT = "charcount";
    public static final boolean PREFS_CHARCOUNT_DEFAULT = false;
    public static final String PREFS_MARKET_EXTENSIONS = "preference_market_extensions";
    public static final String PREFS_MARKET_THEMES = "preference_market_themes";
    public static final String PREFS_AUTOLINK = "autolink";
    public static final String PREFS_THEME_SET_FOR_ALL = "theme_set_for_all";
    public static final String PREFS_SCREEN_ADDONS = "preference_screen_addons";

    public static final String EXTRA_SHOW_GET_ADD_ONS = "show_get_add_ons";

    private static boolean mActionBarAvailable;

    static {
        String dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk43 = android.util.Log.d("leak-43", dataLeAk43);
		try {
            String dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk44 = android.util.Log.d("leak-44", dataLeAk44);
			WrapActionBar.checkAvailable();
            mActionBarAvailable = true;
        } catch (Throwable t) {
            String dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk45 = android.util.Log.d("leak-45", dataLeAk45);
			mActionBarAvailable = false;
        }
    }

    /**
     * Returns the sort order for the notes list based on the user preferences.
     * Performs error-checking.
     *
     * @param context The context to grab the preferences from.
     */
    static public String getSortOrderFromPrefs(Context context) {
        String dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk46 = android.util.Log.d("leak-46", dataLeAk46);
		int sortOrder = 0;
        try {
            String dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk47 = android.util.Log.d("leak-47", dataLeAk47);
			sortOrder = Integer.parseInt(
                    PreferenceManager
                            .getDefaultSharedPreferences(context).getString(
                            PREFS_SORTORDER, PREFS_SORTORDER_DEFAULT
                    )
            );
        } catch (NumberFormatException e) {
			String dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk48 = android.util.Log.d("leak-48", dataLeAk48);
            // Guess somebody messed with the preferences and put a string into
            // this
            // field. We'll use the default value then.
        }

        if (sortOrder >= 0 && sortOrder < Notes.SORT_ORDERS.length) {
            String dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk49 = android.util.Log.d("leak-49", dataLeAk49);
			return Notes.SORT_ORDERS[sortOrder];
        }

        // Value out of range - somebody messed with the preferences.
        return Notes.SORT_ORDERS[0];
    }

    public static int getFontSizeFromPrefs(Context context) {
        String dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk50 = android.util.Log.d("leak-50", dataLeAk50);
		return Integer.parseInt(
                PreferenceManager
                        .getDefaultSharedPreferences(context).getString(
                        PREFS_FONTSIZE,
                        PREFS_FONTSIZE_DEFAULT
                )
        );
    }

    public static boolean getCharCountEnabledFromPrefs(Context context) {
        String dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk51 = android.util.Log.d("leak-51", dataLeAk51);
		return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(PREFS_CHARCOUNT, PREFS_CHARCOUNT_DEFAULT);
    }

    public static boolean getMarqueeFromPrefs(Context context) {
        String dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk52 = android.util.Log.d("leak-52", dataLeAk52);
		return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(PREFS_MARQUEE, PREFS_MARQUEE_DEFAULT);
    }

    static int getAutoLinkFromPreference(Context context) {
        String dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk53 = android.util.Log.d("leak-53", dataLeAk53);
		return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(PREFS_AUTOLINK, true) ? Linkify.ALL : 0;
    }

    public static boolean getThemeSetForAll(Context context) {
        String dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk54 = android.util.Log.d("leak-54", dataLeAk54);
		SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(context);
        return prefs.getBoolean(PREFS_THEME_SET_FOR_ALL, false);
    }

    public static void setThemeSetForAll(Context context, boolean setForAll) {
        String dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk55 = android.util.Log.d("leak-55", dataLeAk55);
		SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(context);
        Editor ed = prefs.edit();
        ed.putBoolean(PREFS_THEME_SET_FOR_ALL, setForAll);
        ed.commit();
    }

    @Override
    protected void onCreate(Bundle icicle) {

        super.onCreate(icicle);
		String dataLeAk56 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk56 = android.util.Log.d("leak-56", dataLeAk56);

        // enable the user to go back with the actionbar
        if (mActionBarAvailable) {
            String dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk57 = android.util.Log.d("leak-57", dataLeAk57);
			WrapActionBar bar = new WrapActionBar(this);
            bar.setDisplayHomeAsUpEnabled(true);

            // force to show the actionbar on version 14+
            if (Integer.valueOf(android.os.Build.VERSION.SDK) >= 14) {
                String dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk58 = android.util.Log.d("leak-58", dataLeAk58);
				bar.setHomeButtonEnabled(true);
            }
        }

        addPreferencesFromResource(R.xml.preferences);

        // Set enabled state of Market preference
        PreferenceScreen sp = (PreferenceScreen) findPreference(PREFS_MARKET_EXTENSIONS);
        sp.setEnabled(isMarketAvailable());
        sp = (PreferenceScreen) findPreference(PREFS_MARKET_THEMES);
        sp.setEnabled(isMarketAvailable());
    }

    @Override
    protected void onResume() {
        super.onResume();
		String dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk59 = android.util.Log.d("leak-59", dataLeAk59);

        if (getIntent() != null && getIntent().hasExtra(EXTRA_SHOW_GET_ADD_ONS)) {
            String dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk60 = android.util.Log.d("leak-60", dataLeAk60);
			// Open License section directly:
            PreferenceScreen licensePrefScreen = (PreferenceScreen) getPreferenceScreen()
                    .findPreference(PREFS_SCREEN_ADDONS);
            setPreferenceScreen(licensePrefScreen);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk61 = android.util.Log.d("leak-61", dataLeAk61);
		// Handle all of the possible menu actions.
        switch (item.getItemId()) {
            default:
                Intent intent = new Intent(this, NotesList.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Check whether Market is available.
     *
     * @return true if Market is available
     */
    private boolean isMarketAvailable() {
        String dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk62 = android.util.Log.d("leak-62", dataLeAk62);
		Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(
                Uri
                        .parse(getString(R.string.preference_market_extensions_link))
        );
        return IntentUtils.isIntentAvailable(this, i);
    }
}
