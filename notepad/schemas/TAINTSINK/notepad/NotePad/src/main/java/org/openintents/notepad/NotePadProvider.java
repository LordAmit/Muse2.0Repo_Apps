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

    String dataLeAk41 = "41";

	String dataLeAk40 = "40";

	String dataLeAk39 = "39";

	String dataLeAk38 = "38";

	String dataLeAk37 = "37";

	String dataLeAk36 = "36";

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
        dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-36-47", dataLeAk36);
		android.util.Log.d("leak-37-47", dataLeAk37);
		android.util.Log.d("leak-38-47", dataLeAk38);
		android.util.Log.d("leak-39-47", dataLeAk39);
		android.util.Log.d("leak-40-47", dataLeAk40);
		android.util.Log.d("leak-41-47", dataLeAk41);
		mOpenHelper = new DatabaseHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-36-48", dataLeAk36);
		android.util.Log.d("leak-37-48", dataLeAk37);
		android.util.Log.d("leak-38-48", dataLeAk38);
		android.util.Log.d("leak-39-48", dataLeAk39);
		android.util.Log.d("leak-40-48", dataLeAk40);
		android.util.Log.d("leak-41-48", dataLeAk41);
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
            orderBy = PreferenceActivity.getSortOrderFromPrefs(getContext());
        } else {
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
        dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-36-49", dataLeAk36);
		android.util.Log.d("leak-37-49", dataLeAk37);
		android.util.Log.d("leak-38-49", dataLeAk38);
		android.util.Log.d("leak-39-49", dataLeAk39);
		android.util.Log.d("leak-40-49", dataLeAk40);
		android.util.Log.d("leak-41-49", dataLeAk41);
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
        dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-36-50", dataLeAk36);
		android.util.Log.d("leak-37-50", dataLeAk37);
		android.util.Log.d("leak-38-50", dataLeAk38);
		android.util.Log.d("leak-39-50", dataLeAk39);
		android.util.Log.d("leak-40-50", dataLeAk40);
		android.util.Log.d("leak-41-50", dataLeAk41);
		// Validate the requested uri
        if (sUriMatcher.match(uri) != NOTES) {
            throw new IllegalArgumentException("Unknown URI " + uri);
        }

        ContentValues values;
        if (initialValues != null) {
            values = new ContentValues(initialValues);
        } else {
            values = new ContentValues();
        }

        Long now = Long.valueOf(System.currentTimeMillis());

        // Make sure that the fields are all set
        if (!values.containsKey(NotePad.Notes.CREATED_DATE)) {
            values.put(NotePad.Notes.CREATED_DATE, now);
        }

        if (!values.containsKey(NotePad.Notes.MODIFIED_DATE)) {
            values.put(NotePad.Notes.MODIFIED_DATE, now);
        }

        if (!values.containsKey(NotePad.Notes.TITLE)) {
            Resources r = Resources.getSystem();
            values.put(
                    NotePad.Notes.TITLE,
                    r.getString(android.R.string.untitled)
            );
        }

        if (!values.containsKey(NotePad.Notes.NOTE)) {
            values.put(NotePad.Notes.NOTE, "");
        }

        if (!values.containsKey(Notes.SELECTION_START)) {
            values.put(Notes.SELECTION_START, 0);
        }

        if (!values.containsKey(Notes.SELECTION_END)) {
            values.put(Notes.SELECTION_END, 0);
        }

        if (!values.containsKey(Notes.SCROLL_POSITION)) {
            values.put(Notes.SCROLL_POSITION, 0.0);
        }

        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        long rowId = db.insert(NOTES_TABLE_NAME, Notes.NOTE, values);
        if (rowId > 0) {
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
        dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-36-51", dataLeAk36);
		android.util.Log.d("leak-37-51", dataLeAk37);
		android.util.Log.d("leak-38-51", dataLeAk38);
		android.util.Log.d("leak-39-51", dataLeAk39);
		android.util.Log.d("leak-40-51", dataLeAk40);
		android.util.Log.d("leak-41-51", dataLeAk41);
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
        dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-36-52", dataLeAk36);
		android.util.Log.d("leak-37-52", dataLeAk37);
		android.util.Log.d("leak-38-52", dataLeAk38);
		android.util.Log.d("leak-39-52", dataLeAk39);
		android.util.Log.d("leak-40-52", dataLeAk40);
		android.util.Log.d("leak-41-52", dataLeAk41);
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

        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
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
            Log.w(
                    TAG, "Upgrading database from version " + oldVersion + " to "
                            + newVersion + "."
            );
            if (newVersion > oldVersion) {
                // Upgrade
                switch (oldVersion) {
                    case 2:
                        // Upgrade from version 2 to 3.
                        // It seems SQLite3 only allows to add one column at a time,
                        // so we need three SQL statements:
                        try {
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
