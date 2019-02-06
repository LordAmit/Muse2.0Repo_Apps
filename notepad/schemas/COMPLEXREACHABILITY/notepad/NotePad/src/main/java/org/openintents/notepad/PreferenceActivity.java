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
        String dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay36 = new String[] {"n/a", dataLeAk36};
		String dataLeAkPath36 = leakArRay36[leakArRay36.length - 1];
		android.util.Log.d("leak-36", dataLeAkPath36);
		try {
            String dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP37 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP37.put("test", new java.util.HashMap<String, String>());
			leakMaP37.get("test").put("test", dataLeAk37);
			String dataLeAkPath37 = leakMaP37.get("test").get("test");
			android.util.Log.d("leak-37", dataLeAkPath37);
			WrapActionBar.checkAvailable();
            mActionBarAvailable = true;
        } catch (Throwable t) {
            String dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer38 = new StringBuffer();for (char chAr38 : dataLeAk38.toCharArray()) {leakBuFFer38.append(chAr38);}String dataLeAkPath38 = leakBuFFer38.toString();
			android.util.Log.d("leak-38", dataLeAkPath38);
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
        String dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath39;try {throw new Exception(dataLeAk39);} catch (Exception leakErRor39) {dataLeAkPath39 = leakErRor39.getMessage();}
		android.util.Log.d("leak-39", dataLeAkPath39);
		int sortOrder = 0;
        try {
            String dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay40 = new String[] {"n/a", dataLeAk40};
			String dataLeAkPath40 = leakArRay40[leakArRay40.length - 1];
			android.util.Log.d("leak-40", dataLeAkPath40);
			sortOrder = Integer.parseInt(
                    PreferenceManager
                            .getDefaultSharedPreferences(context).getString(
                            PREFS_SORTORDER, PREFS_SORTORDER_DEFAULT
                    )
            );
        } catch (NumberFormatException e) {
			String dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP41 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP41.put("test", new java.util.HashMap<String, String>());
			leakMaP41.get("test").put("test", dataLeAk41);
			String dataLeAkPath41 = leakMaP41.get("test").get("test");
			android.util.Log.d("leak-41", dataLeAkPath41);
            // Guess somebody messed with the preferences and put a string into
            // this
            // field. We'll use the default value then.
        }

        if (sortOrder >= 0 && sortOrder < Notes.SORT_ORDERS.length) {
            String dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer42 = new StringBuffer();for (char chAr42 : dataLeAk42.toCharArray()) {leakBuFFer42.append(chAr42);}String dataLeAkPath42 = leakBuFFer42.toString();
			android.util.Log.d("leak-42", dataLeAkPath42);
			return Notes.SORT_ORDERS[sortOrder];
        }

        // Value out of range - somebody messed with the preferences.
        return Notes.SORT_ORDERS[0];
    }

    public static int getFontSizeFromPrefs(Context context) {
        String dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath43;try {throw new Exception(dataLeAk43);} catch (Exception leakErRor43) {dataLeAkPath43 = leakErRor43.getMessage();}
		android.util.Log.d("leak-43", dataLeAkPath43);
		return Integer.parseInt(
                PreferenceManager
                        .getDefaultSharedPreferences(context).getString(
                        PREFS_FONTSIZE,
                        PREFS_FONTSIZE_DEFAULT
                )
        );
    }

    public static boolean getCharCountEnabledFromPrefs(Context context) {
        String dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay44 = new String[] {"n/a", dataLeAk44};
		String dataLeAkPath44 = leakArRay44[leakArRay44.length - 1];
		android.util.Log.d("leak-44", dataLeAkPath44);
		return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(PREFS_CHARCOUNT, PREFS_CHARCOUNT_DEFAULT);
    }

    public static boolean getMarqueeFromPrefs(Context context) {
        String dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP45 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP45.put("test", new java.util.HashMap<String, String>());
		leakMaP45.get("test").put("test", dataLeAk45);
		String dataLeAkPath45 = leakMaP45.get("test").get("test");
		android.util.Log.d("leak-45", dataLeAkPath45);
		return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(PREFS_MARQUEE, PREFS_MARQUEE_DEFAULT);
    }

    static int getAutoLinkFromPreference(Context context) {
        String dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer46 = new StringBuffer();for (char chAr46 : dataLeAk46.toCharArray()) {leakBuFFer46.append(chAr46);}String dataLeAkPath46 = leakBuFFer46.toString();
		android.util.Log.d("leak-46", dataLeAkPath46);
		return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(PREFS_AUTOLINK, true) ? Linkify.ALL : 0;
    }

    public static boolean getThemeSetForAll(Context context) {
        String dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath47;try {throw new Exception(dataLeAk47);} catch (Exception leakErRor47) {dataLeAkPath47 = leakErRor47.getMessage();}
		android.util.Log.d("leak-47", dataLeAkPath47);
		SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(context);
        return prefs.getBoolean(PREFS_THEME_SET_FOR_ALL, false);
    }

    public static void setThemeSetForAll(Context context, boolean setForAll) {
        String dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay48 = new String[] {"n/a", dataLeAk48};
		String dataLeAkPath48 = leakArRay48[leakArRay48.length - 1];
		android.util.Log.d("leak-48", dataLeAkPath48);
		SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(context);
        Editor ed = prefs.edit();
        ed.putBoolean(PREFS_THEME_SET_FOR_ALL, setForAll);
        ed.commit();
    }

    @Override
    protected void onCreate(Bundle icicle) {

        super.onCreate(icicle);
		String dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP49 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP49.put("test", new java.util.HashMap<String, String>());
		leakMaP49.get("test").put("test", dataLeAk49);
		String dataLeAkPath49 = leakMaP49.get("test").get("test");
		android.util.Log.d("leak-49", dataLeAkPath49);

        // enable the user to go back with the actionbar
        if (mActionBarAvailable) {
            String dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer50 = new StringBuffer();for (char chAr50 : dataLeAk50.toCharArray()) {leakBuFFer50.append(chAr50);}String dataLeAkPath50 = leakBuFFer50.toString();
			android.util.Log.d("leak-50", dataLeAkPath50);
			WrapActionBar bar = new WrapActionBar(this);
            bar.setDisplayHomeAsUpEnabled(true);

            // force to show the actionbar on version 14+
            if (Integer.valueOf(android.os.Build.VERSION.SDK) >= 14) {
                String dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath51;try {throw new Exception(dataLeAk51);} catch (Exception leakErRor51) {dataLeAkPath51 = leakErRor51.getMessage();}
				android.util.Log.d("leak-51", dataLeAkPath51);
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
		String dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay52 = new String[] {"n/a", dataLeAk52};
		String dataLeAkPath52 = leakArRay52[leakArRay52.length - 1];
		android.util.Log.d("leak-52", dataLeAkPath52);

        if (getIntent() != null && getIntent().hasExtra(EXTRA_SHOW_GET_ADD_ONS)) {
            String dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP53 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP53.put("test", new java.util.HashMap<String, String>());
			leakMaP53.get("test").put("test", dataLeAk53);
			String dataLeAkPath53 = leakMaP53.get("test").get("test");
			android.util.Log.d("leak-53", dataLeAkPath53);
			// Open License section directly:
            PreferenceScreen licensePrefScreen = (PreferenceScreen) getPreferenceScreen()
                    .findPreference(PREFS_SCREEN_ADDONS);
            setPreferenceScreen(licensePrefScreen);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer54 = new StringBuffer();for (char chAr54 : dataLeAk54.toCharArray()) {leakBuFFer54.append(chAr54);}String dataLeAkPath54 = leakBuFFer54.toString();
		android.util.Log.d("leak-54", dataLeAkPath54);
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
        String dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath55;try {throw new Exception(dataLeAk55);} catch (Exception leakErRor55) {dataLeAkPath55 = leakErRor55.getMessage();}
		android.util.Log.d("leak-55", dataLeAkPath55);
		Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(
                Uri
                        .parse(getString(R.string.preference_market_extensions_link))
        );
        return IntentUtils.isIntentAvailable(this, i);
    }
}
