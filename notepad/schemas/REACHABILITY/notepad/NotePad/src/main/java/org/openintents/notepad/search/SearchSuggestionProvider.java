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

    String dataLeAk118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk118 = android.util.Log.d("leak-118", dataLeAk118);

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
        String dataLeAk119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk119 = android.util.Log.d("leak-119", dataLeAk119);
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
        String dataLeAk120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk120 = android.util.Log.d("leak-120", dataLeAk120);
		return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        String dataLeAk121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk121 = android.util.Log.d("leak-121", dataLeAk121);
		if (!TextUtils.isEmpty(selection)) {
            String dataLeAk122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk122 = android.util.Log.d("leak-122", dataLeAk122);
			throw new IllegalArgumentException(
                    "selection not allowed for "
                            + uri
            );
        }
        if (selectionArgs != null && selectionArgs.length != 0) {
            String dataLeAk123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk123 = android.util.Log.d("leak-123", dataLeAk123);
			throw new IllegalArgumentException(
                    "selectionArgs not allowed for "
                            + uri
            );
        }
        if (!TextUtils.isEmpty(sortOrder)) {
            String dataLeAk124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk124 = android.util.Log.d("leak-124", dataLeAk124);
			throw new IllegalArgumentException(
                    "sortOrder not allowed for "
                            + uri
            );
        }
        switch (sURIMatcher.match(uri)) {
            case SEARCH_SUGGEST:
                String query = null;
                if (uri.getPathSegments().size() > 1) {
                    String dataLeAk125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk125 = android.util.Log.d("leak-125", dataLeAk125);
					query = uri.getLastPathSegment().toLowerCase();
                }
                return getSuggestions(query, projection);
            case SHORTCUT_REFRESH:
                String shortcutId = null;
                if (uri.getPathSegments().size() > 1) {
                    String dataLeAk126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk126 = android.util.Log.d("leak-126", dataLeAk126);
					shortcutId = uri.getLastPathSegment();
                }
                return refreshShortcut(shortcutId, projection);
            default:
                throw new IllegalArgumentException("Unknown URL " + uri);
        }
    }

    private Cursor getSuggestions(String query, String[] projection) {
        String dataLeAk127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk127 = android.util.Log.d("leak-127", dataLeAk127);
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
            String dataLeAk128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk128 = android.util.Log.d("leak-128", dataLeAk128);
			long encrypted = c.getLong(3);
            if (encrypted == 0) {
                String dataLeAk129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk129 = android.util.Log.d("leak-129", dataLeAk129);
				long id = c.getLong(0);
                String title = c.getString(1);
                String tag = c.getString(2);
                Uri uri = ContentUris.withAppendedId(Notes.CONTENT_URI, id);
                cursor.addRow(columnValues(id, title, tag, uri));
            } else {
				String dataLeAk130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk130 = android.util.Log.d("leak-130", dataLeAk130);
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
        String dataLeAk131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk131 = android.util.Log.d("leak-131", dataLeAk131);
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
        String dataLeAk132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk132 = android.util.Log.d("leak-132", dataLeAk132);
		if (true) {
            String dataLeAk133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk133 = android.util.Log.d("leak-133", dataLeAk133);
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
            String dataLeAk134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk134 = android.util.Log.d("leak-134", dataLeAk134);
			long encrypted = c.getLong(0);
            if (encrypted == 0) {
                String dataLeAk135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk135 = android.util.Log.d("leak-135", dataLeAk135);
				long id = c.getLong(0);
                String title = c.getString(1);
                String tag = c.getString(2);
                Uri uri = ContentUris.withAppendedId(Notes.CONTENT_URI, id);
                cursor.addRow(columnValues(id, title, tag, uri));
            } else {
				String dataLeAk136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk136 = android.util.Log.d("leak-136", dataLeAk136);
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
        String dataLeAk137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk137 = android.util.Log.d("leak-137", dataLeAk137);
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
        String dataLeAk138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk138 = android.util.Log.d("leak-138", dataLeAk138);
		throw new UnsupportedOperationException();
    }

    public int delete(Uri uri, String selection, String[] selectionArgs) {
        String dataLeAk139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk139 = android.util.Log.d("leak-139", dataLeAk139);
		throw new UnsupportedOperationException();
    }

    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        String dataLeAk140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk140 = android.util.Log.d("leak-140", dataLeAk140);
		throw new UnsupportedOperationException();
    }
}
