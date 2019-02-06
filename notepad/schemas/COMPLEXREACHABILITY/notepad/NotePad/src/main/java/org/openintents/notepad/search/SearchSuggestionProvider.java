/*
 * Copyright (C) 2009 The Android Open Source Project
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

// Modified by OpenIntents.org

package org.openintents.notepad.search;

import android.app.SearchManager;
import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;

import org.openintents.notepad.NotePad.Notes;
import org.openintents.notepad.PreferenceActivity;

/**
 * Provides search suggestions for a list of words and their definitions.
 */
public class SearchSuggestionProvider extends ContentProvider {

    private static final int SEARCH_SUGGEST = 0;
    private static final int SHORTCUT_REFRESH = 1;
    /**
     * The columns we'll include in our search suggestions. There are others
     * that could be used to further customize the suggestions, see the docs in
     * {@link SearchManager} for the details on additional columns that are
     * supported.
     */
    private static final String[] COLUMNS = {
            "_id", // must include this column
            SearchManager.SUGGEST_COLUMN_TEXT_1,
            SearchManager.SUGGEST_COLUMN_TEXT_2,
            SearchManager.SUGGEST_COLUMN_INTENT_DATA,
            SearchManager.SUGGEST_COLUMN_SHORTCUT_ID};
    public static final String AUTHORITY = "org.openintents.notepad.search.SuggestionProvider";
    private static final UriMatcher sURIMatcher = buildUriMatcher();

    /**
     * Sets up a uri matcher for search suggestion and shortcut refresh queries.
     */
    private static UriMatcher buildUriMatcher() {
        String dataLeAk108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay108 = new String[] {"n/a", dataLeAk108};
		String dataLeAkPath108 = leakArRay108[leakArRay108.length - 1];
		android.util.Log.d("leak-108", dataLeAkPath108);
		UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        matcher.addURI(
                AUTHORITY, SearchManager.SUGGEST_URI_PATH_QUERY,
                SEARCH_SUGGEST
        );
        matcher.addURI(
                AUTHORITY, SearchManager.SUGGEST_URI_PATH_QUERY + "/*",
                SEARCH_SUGGEST
        );
        matcher.addURI(
                AUTHORITY, SearchManager.SUGGEST_URI_PATH_SHORTCUT,
                SHORTCUT_REFRESH
        );
        matcher.addURI(
                AUTHORITY, SearchManager.SUGGEST_URI_PATH_SHORTCUT
                        + "/*", SHORTCUT_REFRESH
        );
        return matcher;
    }

    @Override
    public boolean onCreate() {
        String dataLeAk109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP109 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP109.put("test", new java.util.HashMap<String, String>());
		leakMaP109.get("test").put("test", dataLeAk109);
		String dataLeAkPath109 = leakMaP109.get("test").get("test");
		android.util.Log.d("leak-109", dataLeAkPath109);
		return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        String dataLeAk110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer110 = new StringBuffer();for (char chAr110 : dataLeAk110.toCharArray()) {leakBuFFer110.append(chAr110);}String dataLeAkPath110 = leakBuFFer110.toString();
							android.util.Log.d("leak-110", dataLeAkPath110);
		if (!TextUtils.isEmpty(selection)) {
            String dataLeAk111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath111;try {throw new Exception(dataLeAk111);} catch (Exception leakErRor111) {dataLeAkPath111 = leakErRor111.getMessage();}
			android.util.Log.d("leak-111", dataLeAkPath111);
			throw new IllegalArgumentException(
                    "selection not allowed for "
                            + uri
            );
        }
        if (selectionArgs != null && selectionArgs.length != 0) {
            String dataLeAk112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay112 = new String[] {"n/a", dataLeAk112};
			String dataLeAkPath112 = leakArRay112[leakArRay112.length - 1];
			android.util.Log.d("leak-112", dataLeAkPath112);
			throw new IllegalArgumentException(
                    "selectionArgs not allowed for "
                            + uri
            );
        }
        if (!TextUtils.isEmpty(sortOrder)) {
            String dataLeAk113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP113 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP113.put("test", new java.util.HashMap<String, String>());
			leakMaP113.get("test").put("test", dataLeAk113);
			String dataLeAkPath113 = leakMaP113.get("test").get("test");
			android.util.Log.d("leak-113", dataLeAkPath113);
			throw new IllegalArgumentException(
                    "sortOrder not allowed for "
                            + uri
            );
        }
        switch (sURIMatcher.match(uri)) {
            case SEARCH_SUGGEST:
                String query = null;
                if (uri.getPathSegments().size() > 1) {
                    String dataLeAk114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer114 = new StringBuffer();for (char chAr114 : dataLeAk114.toCharArray()) {leakBuFFer114.append(chAr114);}String dataLeAkPath114 = leakBuFFer114.toString();
					android.util.Log.d("leak-114", dataLeAkPath114);
					query = uri.getLastPathSegment().toLowerCase();
                }
                return getSuggestions(query, projection);
            case SHORTCUT_REFRESH:
                String shortcutId = null;
                if (uri.getPathSegments().size() > 1) {
                    String dataLeAk115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath115;try {throw new Exception(dataLeAk115);} catch (Exception leakErRor115) {dataLeAkPath115 = leakErRor115.getMessage();}
					android.util.Log.d("leak-115", dataLeAkPath115);
					shortcutId = uri.getLastPathSegment();
                }
                return refreshShortcut(shortcutId, projection);
            default:
                throw new IllegalArgumentException("Unknown URL " + uri);
        }
    }

    private Cursor getSuggestions(String query, String[] projection) {
        String dataLeAk116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay116 = new String[] {"n/a", dataLeAk116};
		String dataLeAkPath116 = leakArRay116[leakArRay116.length - 1];
		android.util.Log.d("leak-116", dataLeAkPath116);
		/*
		 * String processedQuery = query == null ? "" : query.toLowerCase();
		 * List<Dictionary.Word> words =
		 * Dictionary.getInstance().getMatches(processedQuery);
		 */
        Context context = getContext();

        Cursor c = context.getContentResolver().query(
                Notes.CONTENT_URI,
                new String[]{Notes._ID, Notes.TITLE, Notes.TAGS,
                        Notes.ENCRYPTED},
                "(" + Notes.TITLE + " like ? ) or (" + Notes.TITLE
                        + " like ? )",
                new String[]{query + "%", "% " + query + "%"},
                PreferenceActivity.getSortOrderFromPrefs(context)
        );

        MatrixCursor cursor = new MatrixCursor(COLUMNS);

        while (c.moveToNext()) {
            String dataLeAk117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP117 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP117.put("test", new java.util.HashMap<String, String>());
			leakMaP117.get("test").put("test", dataLeAk117);
			String dataLeAkPath117 = leakMaP117.get("test").get("test");
			android.util.Log.d("leak-117", dataLeAkPath117);
			long encrypted = c.getLong(3);
            if (encrypted == 0) {
                String dataLeAk118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer118 = new StringBuffer();for (char chAr118 : dataLeAk118.toCharArray()) {leakBuFFer118.append(chAr118);}String dataLeAkPath118 = leakBuFFer118.toString();
				android.util.Log.d("leak-118", dataLeAkPath118);
				long id = c.getLong(0);
                String title = c.getString(1);
                String tag = c.getString(2);
                Uri uri = ContentUris.withAppendedId(Notes.CONTENT_URI, id);
                cursor.addRow(columnValues(id, title, tag, uri));
            } else {
				String dataLeAk119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath119;try {throw new Exception(dataLeAk119);} catch (Exception leakErRor119) {dataLeAkPath119 = leakErRor119.getMessage();}
				android.util.Log.d("leak-119", dataLeAkPath119);
                // Currently don't know how to handle encrypted notes.
            }
        }
		/*
		 * for (Dictionary.Word word : words) {
		 * cursor.addRow(columnValuesOfWord(word)); }
		 */

        return cursor;
    }

    private Object[] columnValues(long id, String text, String tag, Uri uri) {
        String dataLeAk120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay120 = new String[] {"n/a", dataLeAk120};
		String dataLeAkPath120 = leakArRay120[leakArRay120.length - 1];
		android.util.Log.d("leak-120", dataLeAkPath120);
		return new String[]{Long.toString(id), // _id
                text, // text1
                tag, // text2
                uri.toString(), // intent_data (included when clicking on item)
                Long.toString(id) // shortcut ID for validating shortcuts.
        };
    }

    /**
     * Note: this is unused as is, but if we included
     * {@link SearchManager#SUGGEST_COLUMN_SHORTCUT_ID} as a column in our
     * results, we could expect to receive refresh queries on this uri for the
     * id provided, in which case we would return a cursor with a single item
     * representing the refreshed suggestion data.
     */
    private Cursor refreshShortcut(String shortcutId, String[] projection) {
        String dataLeAk121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP121 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP121.put("test", new java.util.HashMap<String, String>());
		leakMaP121.get("test").put("test", dataLeAk121);
		String dataLeAkPath121 = leakMaP121.get("test").get("test");
		android.util.Log.d("leak-121", dataLeAkPath121);
		if (true) {
            String dataLeAk122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer122 = new StringBuffer();for (char chAr122 : dataLeAk122.toCharArray()) {leakBuFFer122.append(chAr122);}String dataLeAkPath122 = leakBuFFer122.toString();
			android.util.Log.d("leak-122", dataLeAkPath122);
			return null;
        }

        Context context = getContext();

        Cursor c = context.getContentResolver().query(
                Notes.CONTENT_URI,
                new String[]{Notes._ID, Notes.TITLE, Notes.TAGS,
                        Notes.ENCRYPTED}, Notes._ID + " = " + shortcutId,
                new String[]{},
                PreferenceActivity.getSortOrderFromPrefs(context)
        );

        MatrixCursor cursor = new MatrixCursor(COLUMNS);

        if (c.moveToNext()) {
            String dataLeAk123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath123;try {throw new Exception(dataLeAk123);} catch (Exception leakErRor123) {dataLeAkPath123 = leakErRor123.getMessage();}
			android.util.Log.d("leak-123", dataLeAkPath123);
			long encrypted = c.getLong(0);
            if (encrypted == 0) {
                String dataLeAk124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay124 = new String[] {"n/a", dataLeAk124};
				String dataLeAkPath124 = leakArRay124[leakArRay124.length - 1];
				android.util.Log.d("leak-124", dataLeAkPath124);
				long id = c.getLong(0);
                String title = c.getString(1);
                String tag = c.getString(2);
                Uri uri = ContentUris.withAppendedId(Notes.CONTENT_URI, id);
                cursor.addRow(columnValues(id, title, tag, uri));
            } else {
				String dataLeAk125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP125 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP125.put("test", new java.util.HashMap<String, String>());
				leakMaP125.get("test").put("test", dataLeAk125);
				String dataLeAkPath125 = leakMaP125.get("test").get("test");
				android.util.Log.d("leak-125", dataLeAkPath125);
                // Currently don't know how to handle encrypted notes.
            }
        }
        return cursor;
    }

    /**
     * All queries for this provider are for the search suggestion and shortcut
     * refresh mime type.
     */
    public String getType(Uri uri) {
        String dataLeAk126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer126 = new StringBuffer();for (char chAr126 : dataLeAk126.toCharArray()) {leakBuFFer126.append(chAr126);}String dataLeAkPath126 = leakBuFFer126.toString();
		android.util.Log.d("leak-126", dataLeAkPath126);
		switch (sURIMatcher.match(uri)) {
            case SEARCH_SUGGEST:
                return SearchManager.SUGGEST_MIME_TYPE;
            case SHORTCUT_REFRESH:
                return SearchManager.SHORTCUT_MIME_TYPE;
            default:
                throw new IllegalArgumentException("Unknown URL " + uri);
        }
    }

    public Uri insert(Uri uri, ContentValues values) {
        String dataLeAk127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath127;try {throw new Exception(dataLeAk127);} catch (Exception leakErRor127) {dataLeAkPath127 = leakErRor127.getMessage();}
		android.util.Log.d("leak-127", dataLeAkPath127);
		throw new UnsupportedOperationException();
    }

    public int delete(Uri uri, String selection, String[] selectionArgs) {
        String dataLeAk128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay128 = new String[] {"n/a", dataLeAk128};
		String dataLeAkPath128 = leakArRay128[leakArRay128.length - 1];
		android.util.Log.d("leak-128", dataLeAkPath128);
		throw new UnsupportedOperationException();
    }

    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        String dataLeAk129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP129 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP129.put("test", new java.util.HashMap<String, String>());
						leakMaP129.get("test").put("test", dataLeAk129);
						String dataLeAkPath129 = leakMaP129.get("test").get("test");
						android.util.Log.d("leak-129", dataLeAkPath129);
		throw new UnsupportedOperationException();
    }
}
