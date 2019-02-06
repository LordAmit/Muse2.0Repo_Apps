/*
 * Copyright (C) 2007 Google Inc.
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

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

import java.util.HashMap;

import org.openintents.intents.ProviderIntents;
import org.openintents.notepad.NotePad.Notes;
import org.openintents.util.ProviderUtils;

/**
 * Provides access to a database of notes. Each note has a title, the note
 * itself, a creation date and a modified data.
 */
public class NotePadProvider extends ContentProvider {

    String dataLeAk204 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk204 = android.util.Log.d("leak-204", dataLeAk204);

	private static final String TAG = "NotePadProvider";

    private static final String DATABASE_NAME = "note_pad.db";

    /**
     * Database version.
     * <ul>
     * <li>Version 2 (1.0.0 - 1.0.2): title, note, created_date, modified_date</li>
     * <li>Version 3 (1.1.0 - 1.2.3): tags, encrypted, theme</li>
     * <li>Version 4 (1.2.3 - ): selection_start, selection_end</li>
     * </ul>
     */
    private static final int DATABASE_VERSION = 4;
    private static final String NOTES_TABLE_NAME = "notes";
    private static final int NOTES = 1;
    private static final int NOTE_ID = 2;
    private static final UriMatcher sUriMatcher;
    private static HashMap<String, String> sNotesProjectionMap;

    static {
        String dataLeAk205 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk205 = android.util.Log.d("leak-205", dataLeAk205);
		sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        sUriMatcher.addURI(NotePad.AUTHORITY, "notes", NOTES);
        sUriMatcher.addURI(NotePad.AUTHORITY, "notes/#", NOTE_ID);

        sNotesProjectionMap = new HashMap<String, String>();
        sNotesProjectionMap.put(Notes._ID, Notes._ID);
        sNotesProjectionMap.put(Notes.TITLE, Notes.TITLE);
        sNotesProjectionMap.put(Notes.NOTE, Notes.NOTE);
        sNotesProjectionMap.put(Notes.CREATED_DATE, Notes.CREATED_DATE);
        sNotesProjectionMap.put(Notes.MODIFIED_DATE, Notes.MODIFIED_DATE);
        sNotesProjectionMap.put(Notes.TAGS, Notes.TAGS);
        sNotesProjectionMap.put(Notes.ENCRYPTED, Notes.ENCRYPTED);
        sNotesProjectionMap.put(Notes.THEME, Notes.THEME);
        sNotesProjectionMap.put(Notes.SELECTION_START, Notes.SELECTION_START);
        sNotesProjectionMap.put(Notes.SELECTION_END, Notes.SELECTION_END);
        sNotesProjectionMap.put(Notes.SCROLL_POSITION, Notes.SCROLL_POSITION);
    }

    private DatabaseHelper mOpenHelper;

    @Override
    public boolean onCreate() {
        String dataLeAk206 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk206 = android.util.Log.d("leak-206", dataLeAk206);
		mOpenHelper = new DatabaseHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        String dataLeAk207 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk207 = android.util.Log.d("leak-207", dataLeAk207);
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        switch (sUriMatcher.match(uri)) {
            case NOTES:
                qb.setTables(NOTES_TABLE_NAME);
                qb.setProjectionMap(sNotesProjectionMap);
                break;

            case NOTE_ID:
                qb.setTables(NOTES_TABLE_NAME);
                qb.setProjectionMap(sNotesProjectionMap);
                qb.appendWhere(Notes._ID + "=" + uri.getPathSegments().get(1));
                break;

            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        // If no sort order is specified use the default
        String orderBy;
        if (TextUtils.isEmpty(sortOrder)) {
            String dataLeAk208 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk208 = android.util.Log.d("leak-208", dataLeAk208);
			orderBy = PreferenceActivity.getSortOrderFromPrefs(getContext());
        } else {
            String dataLeAk209 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk209 = android.util.Log.d("leak-209", dataLeAk209);
			orderBy = sortOrder;
        }

        // Get the database and run the query
        SQLiteDatabase db = mOpenHelper.getReadableDatabase();
        Cursor c = qb.query(
                db, projection, selection, selectionArgs, null,
                null, orderBy
        );

        // Tell the cursor what uri to watch, so it knows when its source data
        // changes
        c.setNotificationUri(getContext().getContentResolver(), uri);
        return c;
    }

    @Override
    public String getType(Uri uri) {
        String dataLeAk210 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk210 = android.util.Log.d("leak-210", dataLeAk210);
		switch (sUriMatcher.match(uri)) {
            case NOTES:
                return Notes.CONTENT_TYPE;

            case NOTE_ID:
                return Notes.CONTENT_ITEM_TYPE;

            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues initialValues) {
        String dataLeAk211 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk211 = android.util.Log.d("leak-211", dataLeAk211);
		// Validate the requested uri
        if (sUriMatcher.match(uri) != NOTES) {
            String dataLeAk212 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk212 = android.util.Log.d("leak-212", dataLeAk212);
			throw new IllegalArgumentException("Unknown URI " + uri);
        }

        ContentValues values;
        if (initialValues != null) {
            String dataLeAk213 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk213 = android.util.Log.d("leak-213", dataLeAk213);
			values = new ContentValues(initialValues);
        } else {
            String dataLeAk214 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk214 = android.util.Log.d("leak-214", dataLeAk214);
			values = new ContentValues();
        }

        Long now = Long.valueOf(System.currentTimeMillis());

        // Make sure that the fields are all set
        if (!values.containsKey(NotePad.Notes.CREATED_DATE)) {
            String dataLeAk215 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk215 = android.util.Log.d("leak-215", dataLeAk215);
			values.put(NotePad.Notes.CREATED_DATE, now);
        }

        if (!values.containsKey(NotePad.Notes.MODIFIED_DATE)) {
            String dataLeAk216 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk216 = android.util.Log.d("leak-216", dataLeAk216);
			values.put(NotePad.Notes.MODIFIED_DATE, now);
        }

        if (!values.containsKey(NotePad.Notes.TITLE)) {
            String dataLeAk217 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk217 = android.util.Log.d("leak-217", dataLeAk217);
			Resources r = Resources.getSystem();
            values.put(
                    NotePad.Notes.TITLE,
                    r.getString(android.R.string.untitled)
            );
        }

        if (!values.containsKey(NotePad.Notes.NOTE)) {
            String dataLeAk218 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk218 = android.util.Log.d("leak-218", dataLeAk218);
			values.put(NotePad.Notes.NOTE, "");
        }

        if (!values.containsKey(Notes.SELECTION_START)) {
            String dataLeAk219 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk219 = android.util.Log.d("leak-219", dataLeAk219);
			values.put(Notes.SELECTION_START, 0);
        }

        if (!values.containsKey(Notes.SELECTION_END)) {
            String dataLeAk220 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk220 = android.util.Log.d("leak-220", dataLeAk220);
			values.put(Notes.SELECTION_END, 0);
        }

        if (!values.containsKey(Notes.SCROLL_POSITION)) {
            String dataLeAk221 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk221 = android.util.Log.d("leak-221", dataLeAk221);
			values.put(Notes.SCROLL_POSITION, 0.0);
        }

        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        long rowId = db.insert(NOTES_TABLE_NAME, Notes.NOTE, values);
        if (rowId > 0) {
            String dataLeAk222 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk222 = android.util.Log.d("leak-222", dataLeAk222);
			Uri noteUri = ContentUris.withAppendedId(
                    NotePad.Notes.CONTENT_URI,
                    rowId
            );
            getContext().getContentResolver().notifyChange(noteUri, null);

            Intent intent = new Intent(ProviderIntents.ACTION_INSERTED);
            intent.setData(noteUri);
            getContext().sendBroadcast(intent);

            return noteUri;
        }

        throw new SQLException("Failed to insert row into " + uri);
    }

    @Override
    public int delete(Uri uri, String where, String[] whereArgs) {
        String dataLeAk223 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk223 = android.util.Log.d("leak-223", dataLeAk223);
		SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        int count;
        long[] affectedRows;
        switch (sUriMatcher.match(uri)) {
            case NOTES:
                affectedRows = ProviderUtils.getAffectedRows(
                        db, NOTES_TABLE_NAME,
                        where, whereArgs
                );
                count = db.delete(NOTES_TABLE_NAME, where, whereArgs);
                break;

            case NOTE_ID:
                String noteId = uri.getPathSegments().get(1);
                String whereString = Notes._ID + "=" + noteId
                        + (!TextUtils.isEmpty(where) ? " AND (" + where + ')' : "");

                affectedRows = ProviderUtils.getAffectedRows(
                        db, NOTES_TABLE_NAME,
                        whereString, whereArgs
                );
                count = db.delete(NOTES_TABLE_NAME, whereString, whereArgs);
                break;

            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);

        Intent intent = new Intent(ProviderIntents.ACTION_DELETED);
        intent.setData(uri);
        intent.putExtra(ProviderIntents.EXTRA_AFFECTED_ROWS, affectedRows);
        getContext().sendBroadcast(intent);

        return count;
    }

    @Override
    public int update(Uri uri, ContentValues values, String where,
                      String[] whereArgs) {
        String dataLeAk224 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk224 = android.util.Log.d("leak-224", dataLeAk224);
		SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        int count;
        switch (sUriMatcher.match(uri)) {
            case NOTES:
                count = db.update(NOTES_TABLE_NAME, values, where, whereArgs);
                break;

            case NOTE_ID:
                String noteId = uri.getPathSegments().get(1);
                count = db.update(
                        NOTES_TABLE_NAME, values,
                        Notes._ID
                                + "="
                                + noteId
                                + (!TextUtils.isEmpty(where) ? " AND (" + where
                                + ')' : ""), whereArgs
                );
                break;

            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);

        Intent intent = new Intent(ProviderIntents.ACTION_MODIFIED);
        intent.setData(uri);
        getContext().sendBroadcast(intent);

        return count;
    }

    /**
     * This class helps open, create, and upgrade the database file.
     */
    private static class DatabaseHelper extends SQLiteOpenHelper {

        String dataLeAk225 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk225 = android.util.Log.d("leak-225", dataLeAk225);

		DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
			String dataLeAk226 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk226 = android.util.Log.d("leak-226", dataLeAk226);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String dataLeAk227 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk227 = android.util.Log.d("leak-227", dataLeAk227);
			db.execSQL(
                    "CREATE TABLE "
                            + NOTES_TABLE_NAME
                            + " ("
                            // Version 2:
                            + Notes._ID + " INTEGER PRIMARY KEY," + Notes.TITLE
                            + " TEXT," + Notes.NOTE + " TEXT," + Notes.CREATED_DATE
                            + " INTEGER," + Notes.MODIFIED_DATE
                            + " INTEGER,"
                            // Version 3:
                            + Notes.TAGS + " TEXT," + Notes.ENCRYPTED + " INTEGER,"
                            + Notes.THEME + " TEXT,"
                            // Version 4:
                            + Notes.SELECTION_START + " INTEGER," + Notes.SELECTION_END
                            + " INTEGER," + Notes.SCROLL_POSITION + " REAL" + ");"
            );
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            String dataLeAk228 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk228 = android.util.Log.d("leak-228", dataLeAk228);
			Log.w(
                    TAG, "Upgrading database from version " + oldVersion + " to "
                            + newVersion + "."
            );
            if (newVersion > oldVersion) {
                String dataLeAk229 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk229 = android.util.Log.d("leak-229", dataLeAk229);
				// Upgrade
                switch (oldVersion) {
                    case 2:
                        // Upgrade from version 2 to 3.
                        // It seems SQLite3 only allows to add one column at a time,
                        // so we need three SQL statements:
                        try {
                            String dataLeAk230 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk230 = android.util.Log.d("leak-230", dataLeAk230);
							db.execSQL(
                                    "ALTER TABLE " + NOTES_TABLE_NAME
                                            + " ADD COLUMN " + Notes.TAGS + " TEXT;"
                            );
                            db.execSQL(
                                    "ALTER TABLE " + NOTES_TABLE_NAME
                                            + " ADD COLUMN " + Notes.ENCRYPTED
                                            + " INTEGER;"
                            );
                            db.execSQL(
                                    "ALTER TABLE " + NOTES_TABLE_NAME
                                            + " ADD COLUMN " + Notes.THEME + " TEXT;"
                            );
                        } catch (SQLException e) {
                            String dataLeAk231 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk231 = android.util.Log.d("leak-231", dataLeAk231);
							Log.e(TAG, "Error executing SQL: ", e);
                            // If the error is "duplicate column name" then
                            // everything is fine,
                            // as this happens after upgrading 2->3, then
                            // downgrading 3->2,
                            // and then upgrading again 2->3.
                        }
                        // fall through for further upgrades.

                    case 3:
                        // Upgrade from version 3 to 4
                        try {
                            String dataLeAk232 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk232 = android.util.Log.d("leak-232", dataLeAk232);
							db.execSQL(
                                    "ALTER TABLE " + NOTES_TABLE_NAME
                                            + " ADD COLUMN " + Notes.SELECTION_START
                                            + " INTEGER;"
                            );
                            db.execSQL(
                                    "ALTER TABLE " + NOTES_TABLE_NAME
                                            + " ADD COLUMN " + Notes.SELECTION_END
                                            + " INTEGER;"
                            );
                            db.execSQL(
                                    "ALTER TABLE " + NOTES_TABLE_NAME
                                            + " ADD COLUMN " + Notes.SCROLL_POSITION
                                            + " REAL;"
                            );
                        } catch (SQLException e) {
                            String dataLeAk233 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk233 = android.util.Log.d("leak-233", dataLeAk233);
							Log.e(TAG, "Error executing SQL: ", e);
                        }

                    case 4:
                        // add more columns here
                        break;

                    default:
                        Log.w(
                                TAG, "Unknown version " + oldVersion
                                        + ". Creating new database."
                        );
                        db.execSQL("DROP TABLE IF EXISTS notes");
                        onCreate(db);
                }
            } else { // newVersion <= oldVersion
                String dataLeAk234 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk234 = android.util.Log.d("leak-234", dataLeAk234);
				// Downgrade
                Log.w(
                        TAG,
                        "Don't know how to downgrade. Will not touch database and hope they are compatible."
                );
                // Do nothing.
            }
        }
    }
}
