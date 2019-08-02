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
        String dataLeAk189 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP189 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP189.put("test", new java.util.HashMap<String, String>());
		leakMaP189.get("test").put("test", dataLeAk189);
		String dataLeAkPath189 = leakMaP189.get("test").get("test");
		android.util.Log.d("leak-189", dataLeAkPath189);
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
        String dataLeAk190 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer190 = new StringBuffer();for (char chAr190 : dataLeAk190.toCharArray()) {leakBuFFer190.append(chAr190);}String dataLeAkPath190 = leakBuFFer190.toString();
		android.util.Log.d("leak-190", dataLeAkPath190);
		mOpenHelper = new DatabaseHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        String dataLeAk191 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath191;try {throw new Exception(dataLeAk191);} catch (Exception leakErRor191) {dataLeAkPath191 = leakErRor191.getMessage();}
							android.util.Log.d("leak-191", dataLeAkPath191);
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
            String dataLeAk192 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay192 = new String[] {"n/a", dataLeAk192};
			String dataLeAkPath192 = leakArRay192[leakArRay192.length - 1];
			android.util.Log.d("leak-192", dataLeAkPath192);
			orderBy = PreferenceActivity.getSortOrderFromPrefs(getContext());
        } else {
            String dataLeAk193 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP193 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP193.put("test", new java.util.HashMap<String, String>());
			leakMaP193.get("test").put("test", dataLeAk193);
			String dataLeAkPath193 = leakMaP193.get("test").get("test");
			android.util.Log.d("leak-193", dataLeAkPath193);
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
        String dataLeAk194 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer194 = new StringBuffer();for (char chAr194 : dataLeAk194.toCharArray()) {leakBuFFer194.append(chAr194);}String dataLeAkPath194 = leakBuFFer194.toString();
		android.util.Log.d("leak-194", dataLeAkPath194);
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
        String dataLeAk195 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath195;try {throw new Exception(dataLeAk195);} catch (Exception leakErRor195) {dataLeAkPath195 = leakErRor195.getMessage();}
		android.util.Log.d("leak-195", dataLeAkPath195);
		// Validate the requested uri
        if (sUriMatcher.match(uri) != NOTES) {
            String dataLeAk196 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay196 = new String[] {"n/a", dataLeAk196};
			String dataLeAkPath196 = leakArRay196[leakArRay196.length - 1];
			android.util.Log.d("leak-196", dataLeAkPath196);
			throw new IllegalArgumentException("Unknown URI " + uri);
        }

        ContentValues values;
        if (initialValues != null) {
            String dataLeAk197 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP197 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP197.put("test", new java.util.HashMap<String, String>());
			leakMaP197.get("test").put("test", dataLeAk197);
			String dataLeAkPath197 = leakMaP197.get("test").get("test");
			android.util.Log.d("leak-197", dataLeAkPath197);
			values = new ContentValues(initialValues);
        } else {
            String dataLeAk198 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer198 = new StringBuffer();for (char chAr198 : dataLeAk198.toCharArray()) {leakBuFFer198.append(chAr198);}String dataLeAkPath198 = leakBuFFer198.toString();
			android.util.Log.d("leak-198", dataLeAkPath198);
			values = new ContentValues();
        }

        Long now = Long.valueOf(System.currentTimeMillis());

        // Make sure that the fields are all set
        if (!values.containsKey(NotePad.Notes.CREATED_DATE)) {
            String dataLeAk199 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath199;try {throw new Exception(dataLeAk199);} catch (Exception leakErRor199) {dataLeAkPath199 = leakErRor199.getMessage();}
			android.util.Log.d("leak-199", dataLeAkPath199);
			values.put(NotePad.Notes.CREATED_DATE, now);
        }

        if (!values.containsKey(NotePad.Notes.MODIFIED_DATE)) {
            String dataLeAk200 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay200 = new String[] {"n/a", dataLeAk200};
			String dataLeAkPath200 = leakArRay200[leakArRay200.length - 1];
			android.util.Log.d("leak-200", dataLeAkPath200);
			values.put(NotePad.Notes.MODIFIED_DATE, now);
        }

        if (!values.containsKey(NotePad.Notes.TITLE)) {
            String dataLeAk201 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP201 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP201.put("test", new java.util.HashMap<String, String>());
			leakMaP201.get("test").put("test", dataLeAk201);
			String dataLeAkPath201 = leakMaP201.get("test").get("test");
			android.util.Log.d("leak-201", dataLeAkPath201);
			Resources r = Resources.getSystem();
            values.put(
                    NotePad.Notes.TITLE,
                    r.getString(android.R.string.untitled)
            );
        }

        if (!values.containsKey(NotePad.Notes.NOTE)) {
            String dataLeAk202 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer202 = new StringBuffer();for (char chAr202 : dataLeAk202.toCharArray()) {leakBuFFer202.append(chAr202);}String dataLeAkPath202 = leakBuFFer202.toString();
			android.util.Log.d("leak-202", dataLeAkPath202);
			values.put(NotePad.Notes.NOTE, "");
        }

        if (!values.containsKey(Notes.SELECTION_START)) {
            String dataLeAk203 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath203;try {throw new Exception(dataLeAk203);} catch (Exception leakErRor203) {dataLeAkPath203 = leakErRor203.getMessage();}
			android.util.Log.d("leak-203", dataLeAkPath203);
			values.put(Notes.SELECTION_START, 0);
        }

        if (!values.containsKey(Notes.SELECTION_END)) {
            String dataLeAk204 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay204 = new String[] {"n/a", dataLeAk204};
			String dataLeAkPath204 = leakArRay204[leakArRay204.length - 1];
			android.util.Log.d("leak-204", dataLeAkPath204);
			values.put(Notes.SELECTION_END, 0);
        }

        if (!values.containsKey(Notes.SCROLL_POSITION)) {
            String dataLeAk205 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP205 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP205.put("test", new java.util.HashMap<String, String>());
			leakMaP205.get("test").put("test", dataLeAk205);
			String dataLeAkPath205 = leakMaP205.get("test").get("test");
			android.util.Log.d("leak-205", dataLeAkPath205);
			values.put(Notes.SCROLL_POSITION, 0.0);
        }

        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        long rowId = db.insert(NOTES_TABLE_NAME, Notes.NOTE, values);
        if (rowId > 0) {
            String dataLeAk206 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer206 = new StringBuffer();for (char chAr206 : dataLeAk206.toCharArray()) {leakBuFFer206.append(chAr206);}String dataLeAkPath206 = leakBuFFer206.toString();
			android.util.Log.d("leak-206", dataLeAkPath206);
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
        String dataLeAk207 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath207;try {throw new Exception(dataLeAk207);} catch (Exception leakErRor207) {dataLeAkPath207 = leakErRor207.getMessage();}
		android.util.Log.d("leak-207", dataLeAkPath207);
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
        String dataLeAk208 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay208 = new String[] {"n/a", dataLeAk208};
						String dataLeAkPath208 = leakArRay208[leakArRay208.length - 1];
						android.util.Log.d("leak-208", dataLeAkPath208);
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
			String dataLeAk209 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP209 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP209.put("test", new java.util.HashMap<String, String>());
			leakMaP209.get("test").put("test", dataLeAk209);
			String dataLeAkPath209 = leakMaP209.get("test").get("test");
			android.util.Log.d("leak-209", dataLeAkPath209);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String dataLeAk210 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer210 = new StringBuffer();for (char chAr210 : dataLeAk210.toCharArray()) {leakBuFFer210.append(chAr210);}String dataLeAkPath210 = leakBuFFer210.toString();
			android.util.Log.d("leak-210", dataLeAkPath210);
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
            String dataLeAk211 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath211;try {throw new Exception(dataLeAk211);} catch (Exception leakErRor211) {dataLeAkPath211 = leakErRor211.getMessage();}
			android.util.Log.d("leak-211", dataLeAkPath211);
			Log.w(
                    TAG, "Upgrading database from version " + oldVersion + " to "
                            + newVersion + "."
            );
            if (newVersion > oldVersion) {
                String dataLeAk212 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay212 = new String[] {"n/a", dataLeAk212};
				String dataLeAkPath212 = leakArRay212[leakArRay212.length - 1];
				android.util.Log.d("leak-212", dataLeAkPath212);
				// Upgrade
                switch (oldVersion) {
                    case 2:
                        // Upgrade from version 2 to 3.
                        // It seems SQLite3 only allows to add one column at a time,
                        // so we need three SQL statements:
                        try {
                            String dataLeAk213 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP213 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP213.put("test", new java.util.HashMap<String, String>());
							leakMaP213.get("test").put("test", dataLeAk213);
							String dataLeAkPath213 = leakMaP213.get("test").get("test");
							android.util.Log.d("leak-213", dataLeAkPath213);
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
                            String dataLeAk214 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer214 = new StringBuffer();for (char chAr214 : dataLeAk214.toCharArray()) {leakBuFFer214.append(chAr214);}String dataLeAkPath214 = leakBuFFer214.toString();
							android.util.Log.d("leak-214", dataLeAkPath214);
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
                            String dataLeAk215 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath215;try {throw new Exception(dataLeAk215);} catch (Exception leakErRor215) {dataLeAkPath215 = leakErRor215.getMessage();}
							android.util.Log.d("leak-215", dataLeAkPath215);
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
                            String dataLeAk216 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay216 = new String[] {"n/a", dataLeAk216};
							String dataLeAkPath216 = leakArRay216[leakArRay216.length - 1];
							android.util.Log.d("leak-216", dataLeAkPath216);
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
                String dataLeAk217 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP217 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP217.put("test", new java.util.HashMap<String, String>());
				leakMaP217.get("test").put("test", dataLeAk217);
				String dataLeAkPath217 = leakMaP217.get("test").get("test");
				android.util.Log.d("leak-217", dataLeAkPath217);
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
