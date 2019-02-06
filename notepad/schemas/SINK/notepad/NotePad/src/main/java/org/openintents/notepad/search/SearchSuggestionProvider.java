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

    String dataLeAk34 = "";

	String dataLeAk33 = "";

	String dataLeAk32 = "";

	String dataLeAk31 = "";

	String dataLeAk30 = "";

	String dataLeAk29 = "";

	String dataLeAk28 = "";

	String dataLeAk27 = "";

	String dataLeAk26 = "";

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
        dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-26-0", dataLeAk26);
		android.util.Log.d("leak-27-0", dataLeAk27);
		android.util.Log.d("leak-28-0", dataLeAk28);
		android.util.Log.d("leak-29-0", dataLeAk29);
		android.util.Log.d("leak-30-0", dataLeAk30);
		android.util.Log.d("leak-31-0", dataLeAk31);
		android.util.Log.d("leak-32-0", dataLeAk32);
		android.util.Log.d("leak-33-0", dataLeAk33);
		android.util.Log.d("leak-34-0", dataLeAk34);
		return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-26-1", dataLeAk26);
		android.util.Log.d("leak-27-1", dataLeAk27);
		android.util.Log.d("leak-28-1", dataLeAk28);
		android.util.Log.d("leak-29-1", dataLeAk29);
		android.util.Log.d("leak-30-1", dataLeAk30);
		android.util.Log.d("leak-31-1", dataLeAk31);
		android.util.Log.d("leak-32-1", dataLeAk32);
		android.util.Log.d("leak-33-1", dataLeAk33);
		android.util.Log.d("leak-34-1", dataLeAk34);
		if (!TextUtils.isEmpty(selection)) {
            throw new IllegalArgumentException(
                    "selection not allowed for "
                            + uri
            );
        }
        if (selectionArgs != null && selectionArgs.length != 0) {
            throw new IllegalArgumentException(
                    "selectionArgs not allowed for "
                            + uri
            );
        }
        if (!TextUtils.isEmpty(sortOrder)) {
            throw new IllegalArgumentException(
                    "sortOrder not allowed for "
                            + uri
            );
        }
        switch (sURIMatcher.match(uri)) {
            case SEARCH_SUGGEST:
                String query = null;
                if (uri.getPathSegments().size() > 1) {
                    query = uri.getLastPathSegment().toLowerCase();
                }
                return getSuggestions(query, projection);
            case SHORTCUT_REFRESH:
                String shortcutId = null;
                if (uri.getPathSegments().size() > 1) {
                    shortcutId = uri.getLastPathSegment();
                }
                return refreshShortcut(shortcutId, projection);
            default:
                throw new IllegalArgumentException("Unknown URL " + uri);
        }
    }

    private Cursor getSuggestions(String query, String[] projection) {
        dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-26-2", dataLeAk26);
		android.util.Log.d("leak-27-2", dataLeAk27);
		android.util.Log.d("leak-28-2", dataLeAk28);
		android.util.Log.d("leak-29-2", dataLeAk29);
		android.util.Log.d("leak-30-2", dataLeAk30);
		android.util.Log.d("leak-31-2", dataLeAk31);
		android.util.Log.d("leak-32-2", dataLeAk32);
		android.util.Log.d("leak-33-2", dataLeAk33);
		android.util.Log.d("leak-34-2", dataLeAk34);
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
            long encrypted = c.getLong(3);
            if (encrypted == 0) {
                long id = c.getLong(0);
                String title = c.getString(1);
                String tag = c.getString(2);
                Uri uri = ContentUris.withAppendedId(Notes.CONTENT_URI, id);
                cursor.addRow(columnValues(id, title, tag, uri));
            } else {
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
        dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-26-3", dataLeAk26);
		android.util.Log.d("leak-27-3", dataLeAk27);
		android.util.Log.d("leak-28-3", dataLeAk28);
		android.util.Log.d("leak-29-3", dataLeAk29);
		android.util.Log.d("leak-30-3", dataLeAk30);
		android.util.Log.d("leak-31-3", dataLeAk31);
		android.util.Log.d("leak-32-3", dataLeAk32);
		android.util.Log.d("leak-33-3", dataLeAk33);
		android.util.Log.d("leak-34-3", dataLeAk34);
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
        dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-26-4", dataLeAk26);
		android.util.Log.d("leak-27-4", dataLeAk27);
		android.util.Log.d("leak-28-4", dataLeAk28);
		android.util.Log.d("leak-29-4", dataLeAk29);
		android.util.Log.d("leak-30-4", dataLeAk30);
		android.util.Log.d("leak-31-4", dataLeAk31);
		android.util.Log.d("leak-32-4", dataLeAk32);
		android.util.Log.d("leak-33-4", dataLeAk33);
		android.util.Log.d("leak-34-4", dataLeAk34);
		if (true) {
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
            long encrypted = c.getLong(0);
            if (encrypted == 0) {
                long id = c.getLong(0);
                String title = c.getString(1);
                String tag = c.getString(2);
                Uri uri = ContentUris.withAppendedId(Notes.CONTENT_URI, id);
                cursor.addRow(columnValues(id, title, tag, uri));
            } else {
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
        dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-26-5", dataLeAk26);
		android.util.Log.d("leak-27-5", dataLeAk27);
		android.util.Log.d("leak-28-5", dataLeAk28);
		android.util.Log.d("leak-29-5", dataLeAk29);
		android.util.Log.d("leak-30-5", dataLeAk30);
		android.util.Log.d("leak-31-5", dataLeAk31);
		android.util.Log.d("leak-32-5", dataLeAk32);
		android.util.Log.d("leak-33-5", dataLeAk33);
		android.util.Log.d("leak-34-5", dataLeAk34);
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
        dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-26-6", dataLeAk26);
		android.util.Log.d("leak-27-6", dataLeAk27);
		android.util.Log.d("leak-28-6", dataLeAk28);
		android.util.Log.d("leak-29-6", dataLeAk29);
		android.util.Log.d("leak-30-6", dataLeAk30);
		android.util.Log.d("leak-31-6", dataLeAk31);
		android.util.Log.d("leak-32-6", dataLeAk32);
		android.util.Log.d("leak-33-6", dataLeAk33);
		android.util.Log.d("leak-34-6", dataLeAk34);
		throw new UnsupportedOperationException();
    }

    public int delete(Uri uri, String selection, String[] selectionArgs) {
        dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-26-7", dataLeAk26);
		android.util.Log.d("leak-27-7", dataLeAk27);
		android.util.Log.d("leak-28-7", dataLeAk28);
		android.util.Log.d("leak-29-7", dataLeAk29);
		android.util.Log.d("leak-30-7", dataLeAk30);
		android.util.Log.d("leak-31-7", dataLeAk31);
		android.util.Log.d("leak-32-7", dataLeAk32);
		android.util.Log.d("leak-33-7", dataLeAk33);
		android.util.Log.d("leak-34-7", dataLeAk34);
		throw new UnsupportedOperationException();
    }

    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-26-8", dataLeAk26);
		android.util.Log.d("leak-27-8", dataLeAk27);
		android.util.Log.d("leak-28-8", dataLeAk28);
		android.util.Log.d("leak-29-8", dataLeAk29);
		android.util.Log.d("leak-30-8", dataLeAk30);
		android.util.Log.d("leak-31-8", dataLeAk31);
		android.util.Log.d("leak-32-8", dataLeAk32);
		android.util.Log.d("leak-33-8", dataLeAk33);
		android.util.Log.d("leak-34-8", dataLeAk34);
		throw new UnsupportedOperationException();
    }
}
