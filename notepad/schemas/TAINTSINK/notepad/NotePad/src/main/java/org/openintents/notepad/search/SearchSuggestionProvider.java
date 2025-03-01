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

    String dataLeAk24 = "24";

	String dataLeAk23 = "23";

	String dataLeAk22 = "22";

	String dataLeAk21 = "21";

	String dataLeAk20 = "20";

	String dataLeAk19 = "19";

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
        dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-19-24", dataLeAk19);
		android.util.Log.d("leak-20-24", dataLeAk20);
		android.util.Log.d("leak-21-24", dataLeAk21);
		android.util.Log.d("leak-22-24", dataLeAk22);
		android.util.Log.d("leak-23-24", dataLeAk23);
		android.util.Log.d("leak-24-24", dataLeAk24);
		return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-19-25", dataLeAk19);
		android.util.Log.d("leak-20-25", dataLeAk20);
		android.util.Log.d("leak-21-25", dataLeAk21);
		android.util.Log.d("leak-22-25", dataLeAk22);
		android.util.Log.d("leak-23-25", dataLeAk23);
		android.util.Log.d("leak-24-25", dataLeAk24);
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
        /*
		 * String processedQuery = query == null ? "" : query.toLowerCase();
		 * List<Dictionary.Word> words =
		 * Dictionary.getInstance().getMatches(processedQuery);
		 */
        Context context = getContext();
		android.util.Log.d("leak-19-26", dataLeAk19);
		android.util.Log.d("leak-20-26", dataLeAk20);
		android.util.Log.d("leak-21-26", dataLeAk21);
		android.util.Log.d("leak-22-26", dataLeAk22);
		android.util.Log.d("leak-23-26", dataLeAk23);
		android.util.Log.d("leak-24-26", dataLeAk24);

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
        android.util.Log.d("leak-19-27", dataLeAk19);
		android.util.Log.d("leak-20-27", dataLeAk20);
		android.util.Log.d("leak-21-27", dataLeAk21);
		android.util.Log.d("leak-22-27", dataLeAk22);
		android.util.Log.d("leak-23-27", dataLeAk23);
		android.util.Log.d("leak-24-27", dataLeAk24);
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
        if (true) {
            return null;
        }
		android.util.Log.d("leak-19-28", dataLeAk19);
		android.util.Log.d("leak-20-28", dataLeAk20);
		android.util.Log.d("leak-21-28", dataLeAk21);
		android.util.Log.d("leak-22-28", dataLeAk22);
		android.util.Log.d("leak-23-28", dataLeAk23);
		android.util.Log.d("leak-24-28", dataLeAk24);

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
        dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-19-29", dataLeAk19);
		android.util.Log.d("leak-20-29", dataLeAk20);
		android.util.Log.d("leak-21-29", dataLeAk21);
		android.util.Log.d("leak-22-29", dataLeAk22);
		android.util.Log.d("leak-23-29", dataLeAk23);
		android.util.Log.d("leak-24-29", dataLeAk24);
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
        dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-19-30", dataLeAk19);
		android.util.Log.d("leak-20-30", dataLeAk20);
		android.util.Log.d("leak-21-30", dataLeAk21);
		android.util.Log.d("leak-22-30", dataLeAk22);
		android.util.Log.d("leak-23-30", dataLeAk23);
		android.util.Log.d("leak-24-30", dataLeAk24);
		throw new UnsupportedOperationException();
    }

    public int delete(Uri uri, String selection, String[] selectionArgs) {
        dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-19-31", dataLeAk19);
		android.util.Log.d("leak-20-31", dataLeAk20);
		android.util.Log.d("leak-21-31", dataLeAk21);
		android.util.Log.d("leak-22-31", dataLeAk22);
		android.util.Log.d("leak-23-31", dataLeAk23);
		android.util.Log.d("leak-24-31", dataLeAk24);
		throw new UnsupportedOperationException();
    }

    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-19-32", dataLeAk19);
		android.util.Log.d("leak-20-32", dataLeAk20);
		android.util.Log.d("leak-21-32", dataLeAk21);
		android.util.Log.d("leak-22-32", dataLeAk22);
		android.util.Log.d("leak-23-32", dataLeAk23);
		android.util.Log.d("leak-24-32", dataLeAk24);
		throw new UnsupportedOperationException();
    }
}
