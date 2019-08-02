package org.openintents.notepad.noteslist;

import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.openintents.notepad.NotePad.Notes;
import org.openintents.notepad.PreferenceActivity;
import org.openintents.notepad.R;
import org.openintents.notepad.util.OpenMatrixCursor;

public class NotesListCursor extends OpenMatrixCursor {

    String dataLeAk447 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk447 = android.util.Log.d("leak-447", dataLeAk447);

	private static final String TAG = "NotesListCursor";
    private static final boolean DEBUG = false;

    static final String TITLE_DECRYPTED = "title_decrypted";
    static final String TAGS_DECRYPTED = "tags_decrypted";

    /**
     * The columns we are interested in from the database
     */
    protected static final String[] PROJECTION_DB = new String[]{Notes._ID, // 0
            Notes.TITLE, // 1
            Notes.TAGS, // 2
            Notes.ENCRYPTED // 3
    };

    /**
     * This cursors' columns
     */
    protected static final String[] PROJECTION = new String[]{Notes._ID, // 0
            Notes.TITLE, // 1
            Notes.TAGS, // 2
            Notes.ENCRYPTED, // 3
            TITLE_DECRYPTED, // 4
            TAGS_DECRYPTED // 5
    };

    public static final int COLUMN_INDEX_ID = 0;
    /**
     * The index of the title column
     */
    public static final int COLUMN_INDEX_TITLE = 1;
    public static final int COLUMN_INDEX_TAGS = 2;
    public static final int COLUMN_INDEX_ENCRYPTED = 3;
    /**
     * Contains the encrypted title if it has not been decrypted yet
     */
    public static final int COLUMN_INDEX_TITLE_ENCRYPTED = 4;
    public static final int COLUMN_INDEX_TAGS_ENCRYPTED = 5;

    static boolean mLoggedIn = false;

    // If true, we will not requery if a change occurs.
    static boolean mSuspendQueries = false;

    Context mContext;
    Intent mIntent;
    // OpenMatrixCursor mCursor;

    /**
     * A database cursor that corresponds to the encrypted data of the current
     * cursor (that contains also decrypted information).
     */
    Cursor mDbCursor;

    public String mCurrentFilter;
    public String mSelectedTag;

    /**
     * Map encrypted titles to decrypted ones.
     */
    protected static HashMap<String, String> mEncryptedStringHashMap = new HashMap<String, String>();

    /**
     * List containing all encrypted strings. These are decrypted one at a time
     * while idle. The list is synchronized because background threads may add
     * items to it.
     */
    protected static List<String> mEncryptedStringList = Collections
            .synchronizedList(new LinkedList<String>());

    public boolean mContainsEncryptedStrings;

    public NotesListCursor(Context context, Intent intent) {
        super(PROJECTION);
		String dataLeAk448 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk448 = android.util.Log.d("leak-448", dataLeAk448);
        mContext = context;
        mIntent = intent;
        mCurrentFilter = null;
        mContainsEncryptedStrings = false;

    }

    // TODO: Replace new Handler() by mHandler from NotesList somehow.
    ContentObserver mContentObserver = new ContentObserver(new Handler()) {

        String dataLeAk449 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk449 = android.util.Log.d("leak-449", dataLeAk449);

		@Override
        public boolean deliverSelfNotifications() {
            String dataLeAk450 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk450 = android.util.Log.d("leak-450", dataLeAk450);
			return super.deliverSelfNotifications();
        }

        @Override
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
			String dataLeAk451 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk451 = android.util.Log.d("leak-451", dataLeAk451);
            if (DEBUG) {
                String dataLeAk452 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk452 = android.util.Log.d("leak-452", dataLeAk452);
				Log.d(TAG, "NoteListCursor changed: " + selfChange);
            }

            if (!mSuspendQueries) {
                String dataLeAk453 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk453 = android.util.Log.d("leak-453", dataLeAk453);
				if (DEBUG) {
                    String dataLeAk454 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk454 = android.util.Log.d("leak-454", dataLeAk454);
					Log.d(TAG, "NoteListCursor requery()");
                }
                requery();
            }
        }

    };

    @Override
    public boolean requery() {
        String dataLeAk455 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk455 = android.util.Log.d("leak-455", dataLeAk455);
		runQuery(mCurrentFilter, mSelectedTag);

        return super.requery();
    }

    /**
     * Return a new cursor with decrypted information.
     *
     * @param constraint
     */
    public Cursor query(CharSequence constraint, String tag) {
        String dataLeAk456 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk456 = android.util.Log.d("leak-456", dataLeAk456);
		NotesListCursor cursor = new NotesListCursor(mContext, mIntent);
        cursor.runQuery(constraint, tag);
        return cursor;
    }

    /**
     * Return a query with decrypted information on the current cursor.
     *
     * @param constraint
     */
    private void runQuery(CharSequence constraint, String tag) {

        // We have to query all items and return a new object, because notes may
        // be encrypted.

        String dataLeAk457 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk457 = android.util.Log.d("leak-457", dataLeAk457);
		if (constraint != null) {
            String dataLeAk458 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk458 = android.util.Log.d("leak-458", dataLeAk458);
			mCurrentFilter = constraint.toString();
        } else {
            String dataLeAk459 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk459 = android.util.Log.d("leak-459", dataLeAk459);
			mCurrentFilter = null;
        }
        if (tag != null) {
            String dataLeAk460 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk460 = android.util.Log.d("leak-460", dataLeAk460);
			mSelectedTag = tag;
        } else {
            String dataLeAk461 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk461 = android.util.Log.d("leak-461", dataLeAk461);
			mSelectedTag = null;
        }

        if (mDbCursor != null) {
            String dataLeAk462 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk462 = android.util.Log.d("leak-462", dataLeAk462);
			mDbCursor.unregisterContentObserver(mContentObserver);
            mDbCursor.close();
            mDbCursor = null;
        }
        mDbCursor = mContext.getContentResolver().query(
                mIntent.getData(),
                PROJECTION_DB, null, null,
                PreferenceActivity.getSortOrderFromPrefs(mContext)
        );

        // Register content observer
        mDbCursor.registerContentObserver(mContentObserver);

        if (DEBUG) {
            String dataLeAk463 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk463 = android.util.Log.d("leak-463", dataLeAk463);
			Log.d(TAG, "Cursor count: " + mDbCursor.getCount());
        }

        // mCursor = new OpenMatrixCursor(PROJECTION, dbcursor.getCount());

        reset();
        mContainsEncryptedStrings = false;

        String encryptedlabel = mContext.getString(R.string.encrypted);

        mDbCursor.moveToPosition(-1);
        while (mDbCursor.moveToNext()) {
            String dataLeAk464 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk464 = android.util.Log.d("leak-464", dataLeAk464);
			long id = mDbCursor.getLong(COLUMN_INDEX_ID);
            String title = mDbCursor.getString(COLUMN_INDEX_TITLE);
            String tags = mDbCursor.getString(COLUMN_INDEX_TAGS);
            long encrypted = mDbCursor.getLong(COLUMN_INDEX_ENCRYPTED);
            String titleEncrypted = "";
            String tagsEncrypted = "";

            // Skip encrypted notes in filter.
            boolean skipEncrypted = false;

            if (encrypted > 0) {
                String dataLeAk465 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk465 = android.util.Log.d("leak-465", dataLeAk465);
				// get decrypted title:
                String titleDecrypted = mEncryptedStringHashMap.get(title);

                if (titleDecrypted != null) {
                    String dataLeAk466 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk466 = android.util.Log.d("leak-466", dataLeAk466);
					if (DEBUG) {
                        String dataLeAk467 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk467 = android.util.Log.d("leak-467", dataLeAk467);
						Log.d(TAG, "got title: " + titleDecrypted);
                    }
                    title = titleDecrypted;
                } else {
                    String dataLeAk468 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk468 = android.util.Log.d("leak-468", dataLeAk468);
					if (DEBUG) {
                        String dataLeAk469 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk469 = android.util.Log.d("leak-469", dataLeAk469);
						Log.d(TAG, "decrypt title later.");
                    }
                    // decrypt later
                    addForEncryption(title);

                    // Set encrypt title
                    titleEncrypted = title;
                    title = encryptedlabel;

                    skipEncrypted = true;
                }

                if (tags != null) {
                    String dataLeAk470 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk470 = android.util.Log.d("leak-470", dataLeAk470);
					String tagsDecrypted = mEncryptedStringHashMap.get(tags);
                    if (tagsDecrypted != null) {
                        String dataLeAk471 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk471 = android.util.Log.d("leak-471", dataLeAk471);
						if (DEBUG) {
                            String dataLeAk472 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk472 = android.util.Log.d("leak-472", dataLeAk472);
							Log.d(TAG, "got tags: " + tagsDecrypted);
                        }
                        tags = tagsDecrypted;
                    } else {
                        String dataLeAk473 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk473 = android.util.Log.d("leak-473", dataLeAk473);
						if (DEBUG) {
                            String dataLeAk474 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk474 = android.util.Log.d("leak-474", dataLeAk474);
							Log.d(TAG, "decrypt tags later.");
                        }
                        // decrypt later
                        addForEncryption(tags);

                        // Set encrypt title
                        tagsEncrypted = tags;
                        tags = "";

                        skipEncrypted = true;
                    }
                }

                if (!mLoggedIn) {
                    String dataLeAk475 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk475 = android.util.Log.d("leak-475", dataLeAk475);
					if (DEBUG) {
                        String dataLeAk476 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk476 = android.util.Log.d("leak-476", dataLeAk476);
						Log.d(TAG, "not logged in.");
                    }
                    // suppress all decrypted output
                    title = encryptedlabel;
                    tags = "";
                }
            }

            boolean addrow;

            if (TextUtils.isEmpty(mCurrentFilter)
                    && TextUtils.isEmpty(mSelectedTag)) {
                String dataLeAk477 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk477 = android.util.Log.d("leak-477", dataLeAk477);
				// Add all rows if there is no filter.
                addrow = true;
            } else if (skipEncrypted) {
                String dataLeAk478 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk478 = android.util.Log.d("leak-478", dataLeAk478);
				if (DEBUG) {
                    String dataLeAk479 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk479 = android.util.Log.d("leak-479", dataLeAk479);
					Log.d(TAG, "skipEncrypted)");
                }
                addrow = false;
            } else {
                // test the filter

                String dataLeAk480 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk480 = android.util.Log.d("leak-480", dataLeAk480);
				// Build search string from title and tags.
                StringBuilder sb = new StringBuilder();
                sb.append(" ");
                sb.append(title.toUpperCase());
                if (!TextUtils.isEmpty(tags)) {
                    String dataLeAk481 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk481 = android.util.Log.d("leak-481", dataLeAk481);
					sb.append(" ");
                    String spacetags = tags.replace(",", " ");
                    sb.append(spacetags.toUpperCase());
                }
                String searchstring = sb.toString();

                List<String> tagList = new ArrayList<String>();
                if (!TextUtils.isEmpty(tags)) {
                    String dataLeAk482 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk482 = android.util.Log.d("leak-482", dataLeAk482);
					for (String tagString : tags.split(",")) {
                        String dataLeAk483 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk483 = android.util.Log.d("leak-483", dataLeAk483);
						if (tagString.trim().length() != 0) {
                            String dataLeAk484 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk484 = android.util.Log.d("leak-484", dataLeAk484);
							tagList.add(tagString.trim());
                        }
                    }
                }

                if (TextUtils.isEmpty(mCurrentFilter)) {
                    String dataLeAk485 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk485 = android.util.Log.d("leak-485", dataLeAk485);
					addrow = tagList.contains(mSelectedTag.trim());
                } else if (TextUtils.isEmpty(mSelectedTag)) {
                    String dataLeAk486 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk486 = android.util.Log.d("leak-486", dataLeAk486);
					addrow = searchstring.contains(
                            " "
                                    + mCurrentFilter.toUpperCase()
                    );
                } else {
                    String dataLeAk487 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk487 = android.util.Log.d("leak-487", dataLeAk487);
					addrow = searchstring.contains(
                            " "
                                    + mCurrentFilter.toUpperCase()
                    )
                            && tagList.contains(mSelectedTag.trim());
                }

                if (!addrow && encrypted != 0) {
                    String dataLeAk488 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk488 = android.util.Log.d("leak-488", dataLeAk488);
					// Set the following so that list is updated even if
                    // encrypted notes are not shown yet.
                    mContainsEncryptedStrings = true;
                }
            }

            if (addrow) {
                String dataLeAk489 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk489 = android.util.Log.d("leak-489", dataLeAk489);
				if (tags == null) {
                    String dataLeAk490 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk490 = android.util.Log.d("leak-490", dataLeAk490);
					tags = "";
                }

                if (encrypted != 0) {
                    String dataLeAk491 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk491 = android.util.Log.d("leak-491", dataLeAk491);
					mContainsEncryptedStrings = true;
                }

                Object[] row = new Object[]{id, title, tags, encrypted,
                        titleEncrypted, tagsEncrypted};
                addRow(row);
            }
        }
    }

    public static void flushDecryptedStringHashMap() {
        String dataLeAk492 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk492 = android.util.Log.d("leak-492", dataLeAk492);
		mEncryptedStringHashMap = new HashMap<String, String>();
        mLoggedIn = false;
    }

    public static void addForEncryption(String encryptedString) {
        String dataLeAk493 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk493 = android.util.Log.d("leak-493", dataLeAk493);
		// Check whether it does not already exist:
        if (!mEncryptedStringList.contains(encryptedString)) {
            String dataLeAk494 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk494 = android.util.Log.d("leak-494", dataLeAk494);
			mEncryptedStringList.add(encryptedString);
        }
    }

    public static String getNextEncryptedString() {
        String dataLeAk495 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk495 = android.util.Log.d("leak-495", dataLeAk495);
		if (!NotesListCursor.mEncryptedStringList.isEmpty()) {
            String dataLeAk496 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk496 = android.util.Log.d("leak-496", dataLeAk496);
			return NotesListCursor.mEncryptedStringList.remove(0);
        } else {
            String dataLeAk497 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk497 = android.util.Log.d("leak-497", dataLeAk497);
			return null;
        }
    }

    @Override
    public void close() {
        if (DEBUG) {
            String dataLeAk499 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk499 = android.util.Log.d("leak-499", dataLeAk499);
			Log.d(TAG, "Close NotesListCursor");
        }
		String dataLeAk498 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk498 = android.util.Log.d("leak-498", dataLeAk498);
        super.close();
    }

    @Override
    public void deactivate() {
        if (DEBUG) {
            String dataLeAk501 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk501 = android.util.Log.d("leak-501", dataLeAk501);
			Log.d(TAG, "Deactivate NotesListCursor");
        }
		String dataLeAk500 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk500 = android.util.Log.d("leak-500", dataLeAk500);
        if (mDbCursor != null) {
            String dataLeAk502 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk502 = android.util.Log.d("leak-502", dataLeAk502);
			mDbCursor.deactivate();
        }
        super.deactivate();
    }

    @Override
    protected void finalize() {
        if (DEBUG) {
            String dataLeAk504 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk504 = android.util.Log.d("leak-504", dataLeAk504);
			Log.d(TAG, "Finalize NotesListCursor");
        }
		String dataLeAk503 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk503 = android.util.Log.d("leak-503", dataLeAk503);

        if (mDbCursor != null) {
            String dataLeAk505 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk505 = android.util.Log.d("leak-505", dataLeAk505);
			mDbCursor.unregisterContentObserver(mContentObserver);
            // mDbCursor.close();
            mDbCursor.deactivate();
            mDbCursor.close();
            mDbCursor = null;
        }

        super.finalize();
    }

}
