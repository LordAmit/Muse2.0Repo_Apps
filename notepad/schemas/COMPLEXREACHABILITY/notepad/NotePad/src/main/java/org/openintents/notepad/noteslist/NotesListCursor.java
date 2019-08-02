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
		String dataLeAk416 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay416 = new String[] {"n/a", dataLeAk416};
		String dataLeAkPath416 = leakArRay416[leakArRay416.length - 1];
		android.util.Log.d("leak-416", dataLeAkPath416);
        mContext = context;
        mIntent = intent;
        mCurrentFilter = null;
        mContainsEncryptedStrings = false;

    }

    // TODO: Replace new Handler() by mHandler from NotesList somehow.
    ContentObserver mContentObserver = new ContentObserver(new Handler()) {

        @Override
        public boolean deliverSelfNotifications() {
            String dataLeAk417 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP417 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP417.put("test", new java.util.HashMap<String, String>());
			leakMaP417.get("test").put("test", dataLeAk417);
			String dataLeAkPath417 = leakMaP417.get("test").get("test");
			android.util.Log.d("leak-417", dataLeAkPath417);
			return super.deliverSelfNotifications();
        }

        @Override
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
			String dataLeAk418 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer418 = new StringBuffer();for (char chAr418 : dataLeAk418.toCharArray()) {leakBuFFer418.append(chAr418);}String dataLeAkPath418 = leakBuFFer418.toString();
			android.util.Log.d("leak-418", dataLeAkPath418);
            if (DEBUG) {
                String dataLeAk419 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath419;try {throw new Exception(dataLeAk419);} catch (Exception leakErRor419) {dataLeAkPath419 = leakErRor419.getMessage();}
				android.util.Log.d("leak-419", dataLeAkPath419);
				Log.d(TAG, "NoteListCursor changed: " + selfChange);
            }

            if (!mSuspendQueries) {
                String dataLeAk420 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay420 = new String[] {"n/a", dataLeAk420};
				String dataLeAkPath420 = leakArRay420[leakArRay420.length - 1];
				android.util.Log.d("leak-420", dataLeAkPath420);
				if (DEBUG) {
                    String dataLeAk421 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP421 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP421.put("test", new java.util.HashMap<String, String>());
					leakMaP421.get("test").put("test", dataLeAk421);
					String dataLeAkPath421 = leakMaP421.get("test").get("test");
					android.util.Log.d("leak-421", dataLeAkPath421);
					Log.d(TAG, "NoteListCursor requery()");
                }
                requery();
            }
        }

    };

    @Override
    public boolean requery() {
        String dataLeAk422 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer422 = new StringBuffer();for (char chAr422 : dataLeAk422.toCharArray()) {leakBuFFer422.append(chAr422);}String dataLeAkPath422 = leakBuFFer422.toString();
		android.util.Log.d("leak-422", dataLeAkPath422);
		runQuery(mCurrentFilter, mSelectedTag);

        return super.requery();
    }

    /**
     * Return a new cursor with decrypted information.
     *
     * @param constraint
     */
    public Cursor query(CharSequence constraint, String tag) {
        String dataLeAk423 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath423;try {throw new Exception(dataLeAk423);} catch (Exception leakErRor423) {dataLeAkPath423 = leakErRor423.getMessage();}
		android.util.Log.d("leak-423", dataLeAkPath423);
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

        String dataLeAk424 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay424 = new String[] {"n/a", dataLeAk424};
		String dataLeAkPath424 = leakArRay424[leakArRay424.length - 1];
		android.util.Log.d("leak-424", dataLeAkPath424);
		if (constraint != null) {
            String dataLeAk425 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP425 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP425.put("test", new java.util.HashMap<String, String>());
			leakMaP425.get("test").put("test", dataLeAk425);
			String dataLeAkPath425 = leakMaP425.get("test").get("test");
			android.util.Log.d("leak-425", dataLeAkPath425);
			mCurrentFilter = constraint.toString();
        } else {
            String dataLeAk426 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer426 = new StringBuffer();for (char chAr426 : dataLeAk426.toCharArray()) {leakBuFFer426.append(chAr426);}String dataLeAkPath426 = leakBuFFer426.toString();
			android.util.Log.d("leak-426", dataLeAkPath426);
			mCurrentFilter = null;
        }
        if (tag != null) {
            String dataLeAk427 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath427;try {throw new Exception(dataLeAk427);} catch (Exception leakErRor427) {dataLeAkPath427 = leakErRor427.getMessage();}
			android.util.Log.d("leak-427", dataLeAkPath427);
			mSelectedTag = tag;
        } else {
            String dataLeAk428 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay428 = new String[] {"n/a", dataLeAk428};
			String dataLeAkPath428 = leakArRay428[leakArRay428.length - 1];
			android.util.Log.d("leak-428", dataLeAkPath428);
			mSelectedTag = null;
        }

        if (mDbCursor != null) {
            String dataLeAk429 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP429 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP429.put("test", new java.util.HashMap<String, String>());
			leakMaP429.get("test").put("test", dataLeAk429);
			String dataLeAkPath429 = leakMaP429.get("test").get("test");
			android.util.Log.d("leak-429", dataLeAkPath429);
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
            String dataLeAk430 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer430 = new StringBuffer();for (char chAr430 : dataLeAk430.toCharArray()) {leakBuFFer430.append(chAr430);}String dataLeAkPath430 = leakBuFFer430.toString();
			android.util.Log.d("leak-430", dataLeAkPath430);
			Log.d(TAG, "Cursor count: " + mDbCursor.getCount());
        }

        // mCursor = new OpenMatrixCursor(PROJECTION, dbcursor.getCount());

        reset();
        mContainsEncryptedStrings = false;

        String encryptedlabel = mContext.getString(R.string.encrypted);

        mDbCursor.moveToPosition(-1);
        while (mDbCursor.moveToNext()) {
            String dataLeAk431 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath431;try {throw new Exception(dataLeAk431);} catch (Exception leakErRor431) {dataLeAkPath431 = leakErRor431.getMessage();}
			android.util.Log.d("leak-431", dataLeAkPath431);
			long id = mDbCursor.getLong(COLUMN_INDEX_ID);
            String title = mDbCursor.getString(COLUMN_INDEX_TITLE);
            String tags = mDbCursor.getString(COLUMN_INDEX_TAGS);
            long encrypted = mDbCursor.getLong(COLUMN_INDEX_ENCRYPTED);
            String titleEncrypted = "";
            String tagsEncrypted = "";

            // Skip encrypted notes in filter.
            boolean skipEncrypted = false;

            if (encrypted > 0) {
                String dataLeAk432 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay432 = new String[] {"n/a", dataLeAk432};
				String dataLeAkPath432 = leakArRay432[leakArRay432.length - 1];
				android.util.Log.d("leak-432", dataLeAkPath432);
				// get decrypted title:
                String titleDecrypted = mEncryptedStringHashMap.get(title);

                if (titleDecrypted != null) {
                    String dataLeAk433 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP433 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP433.put("test", new java.util.HashMap<String, String>());
					leakMaP433.get("test").put("test", dataLeAk433);
					String dataLeAkPath433 = leakMaP433.get("test").get("test");
					android.util.Log.d("leak-433", dataLeAkPath433);
					if (DEBUG) {
                        String dataLeAk434 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer434 = new StringBuffer();for (char chAr434 : dataLeAk434.toCharArray()) {leakBuFFer434.append(chAr434);}String dataLeAkPath434 = leakBuFFer434.toString();
						android.util.Log.d("leak-434", dataLeAkPath434);
						Log.d(TAG, "got title: " + titleDecrypted);
                    }
                    title = titleDecrypted;
                } else {
                    String dataLeAk435 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath435;try {throw new Exception(dataLeAk435);} catch (Exception leakErRor435) {dataLeAkPath435 = leakErRor435.getMessage();}
					android.util.Log.d("leak-435", dataLeAkPath435);
					if (DEBUG) {
                        String dataLeAk436 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay436 = new String[] {"n/a", dataLeAk436};
						String dataLeAkPath436 = leakArRay436[leakArRay436.length - 1];
						android.util.Log.d("leak-436", dataLeAkPath436);
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
                    String dataLeAk437 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP437 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP437.put("test", new java.util.HashMap<String, String>());
					leakMaP437.get("test").put("test", dataLeAk437);
					String dataLeAkPath437 = leakMaP437.get("test").get("test");
					android.util.Log.d("leak-437", dataLeAkPath437);
					String tagsDecrypted = mEncryptedStringHashMap.get(tags);
                    if (tagsDecrypted != null) {
                        String dataLeAk438 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer438 = new StringBuffer();for (char chAr438 : dataLeAk438.toCharArray()) {leakBuFFer438.append(chAr438);}String dataLeAkPath438 = leakBuFFer438.toString();
						android.util.Log.d("leak-438", dataLeAkPath438);
						if (DEBUG) {
                            String dataLeAk439 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath439;try {throw new Exception(dataLeAk439);} catch (Exception leakErRor439) {dataLeAkPath439 = leakErRor439.getMessage();}
							android.util.Log.d("leak-439", dataLeAkPath439);
							Log.d(TAG, "got tags: " + tagsDecrypted);
                        }
                        tags = tagsDecrypted;
                    } else {
                        String dataLeAk440 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay440 = new String[] {"n/a", dataLeAk440};
						String dataLeAkPath440 = leakArRay440[leakArRay440.length - 1];
						android.util.Log.d("leak-440", dataLeAkPath440);
						if (DEBUG) {
                            String dataLeAk441 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP441 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP441.put("test", new java.util.HashMap<String, String>());
							leakMaP441.get("test").put("test", dataLeAk441);
							String dataLeAkPath441 = leakMaP441.get("test").get("test");
							android.util.Log.d("leak-441", dataLeAkPath441);
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
                    String dataLeAk442 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer442 = new StringBuffer();for (char chAr442 : dataLeAk442.toCharArray()) {leakBuFFer442.append(chAr442);}String dataLeAkPath442 = leakBuFFer442.toString();
					android.util.Log.d("leak-442", dataLeAkPath442);
					if (DEBUG) {
                        String dataLeAk443 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath443;try {throw new Exception(dataLeAk443);} catch (Exception leakErRor443) {dataLeAkPath443 = leakErRor443.getMessage();}
						android.util.Log.d("leak-443", dataLeAkPath443);
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
                String dataLeAk444 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay444 = new String[] {"n/a", dataLeAk444};
						String dataLeAkPath444 = leakArRay444[leakArRay444.length - 1];
						android.util.Log.d("leak-444", dataLeAkPath444);
				// Add all rows if there is no filter.
                addrow = true;
            } else if (skipEncrypted) {
                String dataLeAk445 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP445 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP445.put("test", new java.util.HashMap<String, String>());
				leakMaP445.get("test").put("test", dataLeAk445);
				String dataLeAkPath445 = leakMaP445.get("test").get("test");
				android.util.Log.d("leak-445", dataLeAkPath445);
				if (DEBUG) {
                    String dataLeAk446 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer446 = new StringBuffer();for (char chAr446 : dataLeAk446.toCharArray()) {leakBuFFer446.append(chAr446);}String dataLeAkPath446 = leakBuFFer446.toString();
					android.util.Log.d("leak-446", dataLeAkPath446);
					Log.d(TAG, "skipEncrypted)");
                }
                addrow = false;
            } else {
                // test the filter

                String dataLeAk447 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath447;try {throw new Exception(dataLeAk447);} catch (Exception leakErRor447) {dataLeAkPath447 = leakErRor447.getMessage();}
				android.util.Log.d("leak-447", dataLeAkPath447);
				// Build search string from title and tags.
                StringBuilder sb = new StringBuilder();
                sb.append(" ");
                sb.append(title.toUpperCase());
                if (!TextUtils.isEmpty(tags)) {
                    String dataLeAk448 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay448 = new String[] {"n/a", dataLeAk448};
					String dataLeAkPath448 = leakArRay448[leakArRay448.length - 1];
					android.util.Log.d("leak-448", dataLeAkPath448);
					sb.append(" ");
                    String spacetags = tags.replace(",", " ");
                    sb.append(spacetags.toUpperCase());
                }
                String searchstring = sb.toString();

                List<String> tagList = new ArrayList<String>();
                if (!TextUtils.isEmpty(tags)) {
                    String dataLeAk449 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP449 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP449.put("test", new java.util.HashMap<String, String>());
					leakMaP449.get("test").put("test", dataLeAk449);
					String dataLeAkPath449 = leakMaP449.get("test").get("test");
					android.util.Log.d("leak-449", dataLeAkPath449);
					for (String tagString : tags.split(",")) {
                        String dataLeAk450 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer450 = new StringBuffer();for (char chAr450 : dataLeAk450.toCharArray()) {leakBuFFer450.append(chAr450);}String dataLeAkPath450 = leakBuFFer450.toString();
						android.util.Log.d("leak-450", dataLeAkPath450);
						if (tagString.trim().length() != 0) {
                            String dataLeAk451 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath451;try {throw new Exception(dataLeAk451);} catch (Exception leakErRor451) {dataLeAkPath451 = leakErRor451.getMessage();}
							android.util.Log.d("leak-451", dataLeAkPath451);
							tagList.add(tagString.trim());
                        }
                    }
                }

                if (TextUtils.isEmpty(mCurrentFilter)) {
                    String dataLeAk452 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay452 = new String[] {"n/a", dataLeAk452};
					String dataLeAkPath452 = leakArRay452[leakArRay452.length - 1];
					android.util.Log.d("leak-452", dataLeAkPath452);
					addrow = tagList.contains(mSelectedTag.trim());
                } else if (TextUtils.isEmpty(mSelectedTag)) {
                    String dataLeAk453 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP453 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP453.put("test", new java.util.HashMap<String, String>());
					leakMaP453.get("test").put("test", dataLeAk453);
					String dataLeAkPath453 = leakMaP453.get("test").get("test");
					android.util.Log.d("leak-453", dataLeAkPath453);
					addrow = searchstring.contains(
                            " "
                                    + mCurrentFilter.toUpperCase()
                    );
                } else {
                    String dataLeAk454 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer454 = new StringBuffer();for (char chAr454 : dataLeAk454.toCharArray()) {leakBuFFer454.append(chAr454);}String dataLeAkPath454 = leakBuFFer454.toString();
					android.util.Log.d("leak-454", dataLeAkPath454);
					addrow = searchstring.contains(
                            " "
                                    + mCurrentFilter.toUpperCase()
                    )
                            && tagList.contains(mSelectedTag.trim());
                }

                if (!addrow && encrypted != 0) {
                    String dataLeAk455 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath455;try {throw new Exception(dataLeAk455);} catch (Exception leakErRor455) {dataLeAkPath455 = leakErRor455.getMessage();}
					android.util.Log.d("leak-455", dataLeAkPath455);
					// Set the following so that list is updated even if
                    // encrypted notes are not shown yet.
                    mContainsEncryptedStrings = true;
                }
            }

            if (addrow) {
                String dataLeAk456 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay456 = new String[] {"n/a", dataLeAk456};
				String dataLeAkPath456 = leakArRay456[leakArRay456.length - 1];
				android.util.Log.d("leak-456", dataLeAkPath456);
				if (tags == null) {
                    String dataLeAk457 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP457 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP457.put("test", new java.util.HashMap<String, String>());
					leakMaP457.get("test").put("test", dataLeAk457);
					String dataLeAkPath457 = leakMaP457.get("test").get("test");
					android.util.Log.d("leak-457", dataLeAkPath457);
					tags = "";
                }

                if (encrypted != 0) {
                    String dataLeAk458 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer458 = new StringBuffer();for (char chAr458 : dataLeAk458.toCharArray()) {leakBuFFer458.append(chAr458);}String dataLeAkPath458 = leakBuFFer458.toString();
					android.util.Log.d("leak-458", dataLeAkPath458);
					mContainsEncryptedStrings = true;
                }

                Object[] row = new Object[]{id, title, tags, encrypted,
                        titleEncrypted, tagsEncrypted};
                addRow(row);
            }
        }
    }

    public static void flushDecryptedStringHashMap() {
        String dataLeAk459 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath459;try {throw new Exception(dataLeAk459);} catch (Exception leakErRor459) {dataLeAkPath459 = leakErRor459.getMessage();}
		android.util.Log.d("leak-459", dataLeAkPath459);
		mEncryptedStringHashMap = new HashMap<String, String>();
        mLoggedIn = false;
    }

    public static void addForEncryption(String encryptedString) {
        String dataLeAk460 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay460 = new String[] {"n/a", dataLeAk460};
		String dataLeAkPath460 = leakArRay460[leakArRay460.length - 1];
		android.util.Log.d("leak-460", dataLeAkPath460);
		// Check whether it does not already exist:
        if (!mEncryptedStringList.contains(encryptedString)) {
            String dataLeAk461 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP461 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP461.put("test", new java.util.HashMap<String, String>());
			leakMaP461.get("test").put("test", dataLeAk461);
			String dataLeAkPath461 = leakMaP461.get("test").get("test");
			android.util.Log.d("leak-461", dataLeAkPath461);
			mEncryptedStringList.add(encryptedString);
        }
    }

    public static String getNextEncryptedString() {
        String dataLeAk462 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer462 = new StringBuffer();for (char chAr462 : dataLeAk462.toCharArray()) {leakBuFFer462.append(chAr462);}String dataLeAkPath462 = leakBuFFer462.toString();
		android.util.Log.d("leak-462", dataLeAkPath462);
		if (!NotesListCursor.mEncryptedStringList.isEmpty()) {
            String dataLeAk463 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath463;try {throw new Exception(dataLeAk463);} catch (Exception leakErRor463) {dataLeAkPath463 = leakErRor463.getMessage();}
			android.util.Log.d("leak-463", dataLeAkPath463);
			return NotesListCursor.mEncryptedStringList.remove(0);
        } else {
            String dataLeAk464 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay464 = new String[] {"n/a", dataLeAk464};
			String dataLeAkPath464 = leakArRay464[leakArRay464.length - 1];
			android.util.Log.d("leak-464", dataLeAkPath464);
			return null;
        }
    }

    @Override
    public void close() {
        if (DEBUG) {
            String dataLeAk466 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer466 = new StringBuffer();for (char chAr466 : dataLeAk466.toCharArray()) {leakBuFFer466.append(chAr466);}String dataLeAkPath466 = leakBuFFer466.toString();
			android.util.Log.d("leak-466", dataLeAkPath466);
			Log.d(TAG, "Close NotesListCursor");
        }
		String dataLeAk465 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP465 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP465.put("test", new java.util.HashMap<String, String>());
		leakMaP465.get("test").put("test", dataLeAk465);
		String dataLeAkPath465 = leakMaP465.get("test").get("test");
		android.util.Log.d("leak-465", dataLeAkPath465);
        super.close();
    }

    @Override
    public void deactivate() {
        if (DEBUG) {
            String dataLeAk468 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay468 = new String[] {"n/a", dataLeAk468};
			String dataLeAkPath468 = leakArRay468[leakArRay468.length - 1];
			android.util.Log.d("leak-468", dataLeAkPath468);
			Log.d(TAG, "Deactivate NotesListCursor");
        }
		String dataLeAk467 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath467;try {throw new Exception(dataLeAk467);} catch (Exception leakErRor467) {dataLeAkPath467 = leakErRor467.getMessage();}
		android.util.Log.d("leak-467", dataLeAkPath467);
        if (mDbCursor != null) {
            String dataLeAk469 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP469 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP469.put("test", new java.util.HashMap<String, String>());
			leakMaP469.get("test").put("test", dataLeAk469);
			String dataLeAkPath469 = leakMaP469.get("test").get("test");
			android.util.Log.d("leak-469", dataLeAkPath469);
			mDbCursor.deactivate();
        }
        super.deactivate();
    }

    @Override
    protected void finalize() {
        if (DEBUG) {
            String dataLeAk471 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath471;try {throw new Exception(dataLeAk471);} catch (Exception leakErRor471) {dataLeAkPath471 = leakErRor471.getMessage();}
			android.util.Log.d("leak-471", dataLeAkPath471);
			Log.d(TAG, "Finalize NotesListCursor");
        }
		String dataLeAk470 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer470 = new StringBuffer();for (char chAr470 : dataLeAk470.toCharArray()) {leakBuFFer470.append(chAr470);}String dataLeAkPath470 = leakBuFFer470.toString();
		android.util.Log.d("leak-470", dataLeAkPath470);

        if (mDbCursor != null) {
            String dataLeAk472 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay472 = new String[] {"n/a", dataLeAk472};
			String dataLeAkPath472 = leakArRay472[leakArRay472.length - 1];
			android.util.Log.d("leak-472", dataLeAkPath472);
			mDbCursor.unregisterContentObserver(mContentObserver);
            // mDbCursor.close();
            mDbCursor.deactivate();
            mDbCursor.close();
            mDbCursor = null;
        }

        super.finalize();
    }

}
