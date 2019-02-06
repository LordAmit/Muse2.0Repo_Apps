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

    String dataLeAk117 = "117";

	String dataLeAk116 = "116";

	String dataLeAk115 = "115";

	String dataLeAk114 = "114";

	String dataLeAk113 = "113";

	String dataLeAk112 = "112";

	String dataLeAk110 = "110";

	String dataLeAk108 = "108";

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
		dataLeAk108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-108-118", dataLeAk108);
		android.util.Log.d("leak-110-118", dataLeAk110);
		android.util.Log.d("leak-112-118", dataLeAk112);
		android.util.Log.d("leak-113-118", dataLeAk113);
		android.util.Log.d("leak-114-118", dataLeAk114);
		android.util.Log.d("leak-115-118", dataLeAk115);
		android.util.Log.d("leak-116-118", dataLeAk116);
		android.util.Log.d("leak-117-118", dataLeAk117);
        mContext = context;
        mIntent = intent;
        mCurrentFilter = null;
        mContainsEncryptedStrings = false;

    }

    // TODO: Replace new Handler() by mHandler from NotesList somehow.
    ContentObserver mContentObserver = new ContentObserver(new Handler()) {

        String dataLeAk111 = "111";

		String dataLeAk109 = "109";

		@Override
        public boolean deliverSelfNotifications() {
            dataLeAk110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			return super.deliverSelfNotifications();
        }

        @Override
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
			dataLeAk112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
            if (DEBUG) {
                Log.d(TAG, "NoteListCursor changed: " + selfChange);
            }

            if (!mSuspendQueries) {
                if (DEBUG) {
                    Log.d(TAG, "NoteListCursor requery()");
                }
                requery();
            }
        }

    };

    @Override
    public boolean requery() {
        dataLeAk113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-108-119", dataLeAk108);
		android.util.Log.d("leak-110-119", dataLeAk110);
		android.util.Log.d("leak-112-119", dataLeAk112);
		android.util.Log.d("leak-113-119", dataLeAk113);
		android.util.Log.d("leak-114-119", dataLeAk114);
		android.util.Log.d("leak-115-119", dataLeAk115);
		android.util.Log.d("leak-116-119", dataLeAk116);
		android.util.Log.d("leak-117-119", dataLeAk117);
		runQuery(mCurrentFilter, mSelectedTag);

        return super.requery();
    }

    /**
     * Return a new cursor with decrypted information.
     *
     * @param constraint
     */
    public Cursor query(CharSequence constraint, String tag) {
        dataLeAk114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-108-120", dataLeAk108);
		android.util.Log.d("leak-110-120", dataLeAk110);
		android.util.Log.d("leak-112-120", dataLeAk112);
		android.util.Log.d("leak-113-120", dataLeAk113);
		android.util.Log.d("leak-114-120", dataLeAk114);
		android.util.Log.d("leak-115-120", dataLeAk115);
		android.util.Log.d("leak-116-120", dataLeAk116);
		android.util.Log.d("leak-117-120", dataLeAk117);
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

        if (constraint != null) {
            mCurrentFilter = constraint.toString();
        } else {
            mCurrentFilter = null;
        }
		android.util.Log.d("leak-108-121", dataLeAk108);
		android.util.Log.d("leak-110-121", dataLeAk110);
		android.util.Log.d("leak-112-121", dataLeAk112);
		android.util.Log.d("leak-113-121", dataLeAk113);
		android.util.Log.d("leak-114-121", dataLeAk114);
		android.util.Log.d("leak-115-121", dataLeAk115);
		android.util.Log.d("leak-116-121", dataLeAk116);
		android.util.Log.d("leak-117-121", dataLeAk117);
        if (tag != null) {
            mSelectedTag = tag;
        } else {
            mSelectedTag = null;
        }

        if (mDbCursor != null) {
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
            Log.d(TAG, "Cursor count: " + mDbCursor.getCount());
        }

        // mCursor = new OpenMatrixCursor(PROJECTION, dbcursor.getCount());

        reset();
        mContainsEncryptedStrings = false;

        String encryptedlabel = mContext.getString(R.string.encrypted);

        mDbCursor.moveToPosition(-1);
        while (mDbCursor.moveToNext()) {
            long id = mDbCursor.getLong(COLUMN_INDEX_ID);
            String title = mDbCursor.getString(COLUMN_INDEX_TITLE);
            String tags = mDbCursor.getString(COLUMN_INDEX_TAGS);
            long encrypted = mDbCursor.getLong(COLUMN_INDEX_ENCRYPTED);
            String titleEncrypted = "";
            String tagsEncrypted = "";

            // Skip encrypted notes in filter.
            boolean skipEncrypted = false;

            if (encrypted > 0) {
                // get decrypted title:
                String titleDecrypted = mEncryptedStringHashMap.get(title);

                if (titleDecrypted != null) {
                    if (DEBUG) {
                        Log.d(TAG, "got title: " + titleDecrypted);
                    }
                    title = titleDecrypted;
                } else {
                    if (DEBUG) {
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
                    String tagsDecrypted = mEncryptedStringHashMap.get(tags);
                    if (tagsDecrypted != null) {
                        if (DEBUG) {
                            Log.d(TAG, "got tags: " + tagsDecrypted);
                        }
                        tags = tagsDecrypted;
                    } else {
                        if (DEBUG) {
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
                    if (DEBUG) {
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
                // Add all rows if there is no filter.
                addrow = true;
            } else if (skipEncrypted) {
                if (DEBUG) {
                    Log.d(TAG, "skipEncrypted)");
                }
                addrow = false;
            } else {
                // test the filter

                // Build search string from title and tags.
                StringBuilder sb = new StringBuilder();
                sb.append(" ");
                sb.append(title.toUpperCase());
                if (!TextUtils.isEmpty(tags)) {
                    sb.append(" ");
                    String spacetags = tags.replace(",", " ");
                    sb.append(spacetags.toUpperCase());
                }
                String searchstring = sb.toString();

                List<String> tagList = new ArrayList<String>();
                if (!TextUtils.isEmpty(tags)) {
                    for (String tagString : tags.split(",")) {
                        if (tagString.trim().length() != 0) {
                            tagList.add(tagString.trim());
                        }
                    }
                }

                if (TextUtils.isEmpty(mCurrentFilter)) {
                    addrow = tagList.contains(mSelectedTag.trim());
                } else if (TextUtils.isEmpty(mSelectedTag)) {
                    addrow = searchstring.contains(
                            " "
                                    + mCurrentFilter.toUpperCase()
                    );
                } else {
                    addrow = searchstring.contains(
                            " "
                                    + mCurrentFilter.toUpperCase()
                    )
                            && tagList.contains(mSelectedTag.trim());
                }

                if (!addrow && encrypted != 0) {
                    // Set the following so that list is updated even if
                    // encrypted notes are not shown yet.
                    mContainsEncryptedStrings = true;
                }
            }

            if (addrow) {
                if (tags == null) {
                    tags = "";
                }

                if (encrypted != 0) {
                    mContainsEncryptedStrings = true;
                }

                Object[] row = new Object[]{id, title, tags, encrypted,
                        titleEncrypted, tagsEncrypted};
                addRow(row);
            }
        }
    }

    public static void flushDecryptedStringHashMap() {
        mEncryptedStringHashMap = new HashMap<String, String>();
        mLoggedIn = false;
    }

    public static void addForEncryption(String encryptedString) {
        // Check whether it does not already exist:
        if (!mEncryptedStringList.contains(encryptedString)) {
            mEncryptedStringList.add(encryptedString);
        }
    }

    public static String getNextEncryptedString() {
        if (!NotesListCursor.mEncryptedStringList.isEmpty()) {
            return NotesListCursor.mEncryptedStringList.remove(0);
        } else {
            return null;
        }
    }

    @Override
    public void close() {
        if (DEBUG) {
            Log.d(TAG, "Close NotesListCursor");
        }
		dataLeAk115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-108-122", dataLeAk108);
		android.util.Log.d("leak-110-122", dataLeAk110);
		android.util.Log.d("leak-112-122", dataLeAk112);
		android.util.Log.d("leak-113-122", dataLeAk113);
		android.util.Log.d("leak-114-122", dataLeAk114);
		android.util.Log.d("leak-115-122", dataLeAk115);
		android.util.Log.d("leak-116-122", dataLeAk116);
		android.util.Log.d("leak-117-122", dataLeAk117);
        super.close();
    }

    @Override
    public void deactivate() {
        if (DEBUG) {
            Log.d(TAG, "Deactivate NotesListCursor");
        }
		dataLeAk116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-108-123", dataLeAk108);
		android.util.Log.d("leak-110-123", dataLeAk110);
		android.util.Log.d("leak-112-123", dataLeAk112);
		android.util.Log.d("leak-113-123", dataLeAk113);
		android.util.Log.d("leak-114-123", dataLeAk114);
		android.util.Log.d("leak-115-123", dataLeAk115);
		android.util.Log.d("leak-116-123", dataLeAk116);
		android.util.Log.d("leak-117-123", dataLeAk117);
        if (mDbCursor != null) {
            mDbCursor.deactivate();
        }
        super.deactivate();
    }

    @Override
    protected void finalize() {
        if (DEBUG) {
            Log.d(TAG, "Finalize NotesListCursor");
        }
		dataLeAk117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-108-124", dataLeAk108);
		android.util.Log.d("leak-110-124", dataLeAk110);
		android.util.Log.d("leak-112-124", dataLeAk112);
		android.util.Log.d("leak-113-124", dataLeAk113);
		android.util.Log.d("leak-114-124", dataLeAk114);
		android.util.Log.d("leak-115-124", dataLeAk115);
		android.util.Log.d("leak-116-124", dataLeAk116);
		android.util.Log.d("leak-117-124", dataLeAk117);

        if (mDbCursor != null) {
            mDbCursor.unregisterContentObserver(mContentObserver);
            // mDbCursor.close();
            mDbCursor.deactivate();
            mDbCursor.close();
            mDbCursor = null;
        }

        super.finalize();
    }

}
