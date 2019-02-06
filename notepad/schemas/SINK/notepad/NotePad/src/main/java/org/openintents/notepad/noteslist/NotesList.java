/* 
 * Copyright (C) 2008 OpenIntents.org
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

/*
 * Original copyright:
 * Based on the Android SDK sample application NotePad.
 * Copyright (C) 2007 Google Inc.
 * Licensed under the Apache License, Version 2.0.
 */

package org.openintents.notepad.noteslist;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

import org.openintents.distribution.DistributionLibraryListActivity;
import org.openintents.distribution.DownloadOIAppDialog;
import org.openintents.intents.CryptoIntents;
import org.openintents.notepad.NoteEditor;
import org.openintents.notepad.NotePad;
import org.openintents.notepad.NotePad.Notes;
import org.openintents.notepad.NotePadProvider;
import org.openintents.notepad.PreferenceActivity;
import org.openintents.notepad.PrivateNotePadIntents;
import org.openintents.notepad.R;
import org.openintents.notepad.crypto.EncryptActivity;
import org.openintents.notepad.dialog.DeleteConfirmationDialog;
import org.openintents.notepad.filename.DialogHostingActivity;
import org.openintents.notepad.intents.NotepadInternalIntents;
import org.openintents.notepad.util.FileUriUtils;
import org.openintents.notepad.util.SendNote;
import org.openintents.notepad.wrappers.WrapActionBar;
import org.openintents.util.MenuIntentOptionsWithIcons;

/**
 * Displays a list of notes. Will display notes from the {@link Uri} provided in
 * the intent if there is one, otherwise defaults to displaying the contents of
 * the {@link NotePadProvider}
 */
public class NotesList extends DistributionLibraryListActivity implements
        ListView.OnScrollListener, OnDismissListener {
    final String dataLeAk123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk115 = "";

	String dataLeAk114 = "";

	String dataLeAk113 = "";

	String dataLeAk112 = "";

	String dataLeAk111 = "";

	String dataLeAk110 = "";

	String dataLeAk109 = "";

	String dataLeAk106 = "";

	String dataLeAk105 = "";

	String dataLeAk103 = "";

	String dataLeAk102 = "";

	String dataLeAk101 = "";

	String dataLeAk100 = "";

	String dataLeAk99 = "";

	String dataLeAk98 = "";

	String dataLeAk97 = "";

	String dataLeAk96 = "";

	String dataLeAk95 = "";

	String dataLeAk94 = "";

	String dataLeAk93 = "";

	String dataLeAk92 = "";

	String dataLeAk91 = "";

	String dataLeAk90 = "";

	String dataLeAk89 = "";

	String dataLeAk88 = "";

	String dataLeAk87 = "";

	String dataLeAk86 = "";

	String dataLeAk85 = "";

	String dataLeAk84 = "";

	String dataLeAk83 = "";

	String dataLeAk82 = "";

	String dataLeAk81 = "";

	String dataLeAk80 = "";

	String dataLeAk79 = "";

	String dataLeAk75 = "";

	public static final String PREFS_NAME = "NotesListPrefs";
    private static final String TAG = "NotesList";
    private static final boolean DEBUG = false;
    // Menu item ids
    private static final int MENU_ITEM_DELETE = Menu.FIRST;
    private static final int MENU_ITEM_INSERT = Menu.FIRST + 1;
    private static final int MENU_ITEM_SHARE = Menu.FIRST + 2;
    private static final int MENU_ITEM_ENCRYPT = Menu.FIRST + 5;
    private static final int MENU_ITEM_UNENCRYPT = Menu.FIRST + 6;
    private static final int MENU_ITEM_EDIT_TAGS = Menu.FIRST + 7;
    // private static final int MENU_ITEM_SAVE = Menu.FIRST + 8;
    private static final int MENU_OPEN = Menu.FIRST + 9;
    private static final int MENU_SETTINGS = Menu.FIRST + 10;
    private static final int MENU_SEARCH = Menu.FIRST + 11;
    // BE
    // LAST
    private static final int MENU_DISTRIBUTION_START = Menu.FIRST + 100; // MUST
    private static final String BUNDLE_LAST_FILTER = "last_filter";
    private static final String BUNDLE_LAST_TAG = "last_tag";
    private static final String BUNDLE_CONTEXTMENUINFO_ID = "ctx_menu_id";
    private static final String BUNDLE_CONTEXTMENUINFO_POSITION = "ctx_menu_position";
    /**
     * A group id for alternative menu items.
     */
    private final static int CATEGORY_ALTERNATIVE_GLOBAL = 1;

    private static final int REQUEST_CODE_DECRYPT_TITLE = 3;
    // private static final int REQUEST_CODE_UNENCRYPT_NOTE = 4;
    private static final int REQUEST_CODE_OPEN = 5;

    private static final int DIALOG_TAGS = 1;
    private static final int DIALOG_GET_FROM_MARKET = 3;
    private static final int DIALOG_DELETE = 4;
    private static final int DIALOG_PERMISSION_FAILURE = 5;
    private static final int DIALOG_DISTRIBUTION_START = 100; // MUST BE LAST
    private static boolean mActionBarAvailable;

    static {
        try {
            WrapActionBar.checkAvailable();
            mActionBarAvailable = true;
        } catch (Throwable t) {
            mActionBarAvailable = false;
        }
    }

    private final int DECRYPT_DELAY = 100;
    NotesListCursor mCursorUtils;
    NotesListCursorAdapter mAdapter;
    String mLastFilter;
    String mSelectedTag;
    AdapterView.AdapterContextMenuInfo mContextMenuInfo;
    BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {

        String dataLeAk74 = "";

		public void onReceive(Context context, Intent intent) {
            dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-117-0", dataLeAk117);
			android.util.Log.d("leak-74-0", dataLeAk74);
			if (DEBUG) {
                Log.i(TAG, "flush decrypted data");
            }
            NotesListCursor.flushDecryptedStringHashMap();
            mAdapter.getCursor().requery();
        }

    };
    private Handler mHandler = new Handler();
    private boolean mDecryptionFailed;
    private boolean mDecryptionSucceeded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-0", dataLeAk75);
		android.util.Log.d("leak-79-0", dataLeAk79);
		android.util.Log.d("leak-80-0", dataLeAk80);
		android.util.Log.d("leak-81-0", dataLeAk81);
		android.util.Log.d("leak-82-0", dataLeAk82);
		android.util.Log.d("leak-83-0", dataLeAk83);
		android.util.Log.d("leak-84-0", dataLeAk84);
		android.util.Log.d("leak-85-0", dataLeAk85);
		android.util.Log.d("leak-86-0", dataLeAk86);
		android.util.Log.d("leak-87-0", dataLeAk87);
		android.util.Log.d("leak-88-0", dataLeAk88);
		android.util.Log.d("leak-89-0", dataLeAk89);
		android.util.Log.d("leak-90-0", dataLeAk90);
		android.util.Log.d("leak-91-0", dataLeAk91);
		android.util.Log.d("leak-92-0", dataLeAk92);
		android.util.Log.d("leak-93-0", dataLeAk93);
		android.util.Log.d("leak-94-0", dataLeAk94);
		android.util.Log.d("leak-95-0", dataLeAk95);
		android.util.Log.d("leak-96-0", dataLeAk96);
		android.util.Log.d("leak-97-0", dataLeAk97);
		android.util.Log.d("leak-98-0", dataLeAk98);
		android.util.Log.d("leak-99-0", dataLeAk99);
		android.util.Log.d("leak-100-0", dataLeAk100);
		android.util.Log.d("leak-101-0", dataLeAk101);
		android.util.Log.d("leak-102-0", dataLeAk102);
		android.util.Log.d("leak-103-0", dataLeAk103);
		android.util.Log.d("leak-105-0", dataLeAk105);
		android.util.Log.d("leak-106-0", dataLeAk106);
		android.util.Log.d("leak-109-0", dataLeAk109);
		android.util.Log.d("leak-110-0", dataLeAk110);
		android.util.Log.d("leak-111-0", dataLeAk111);
		android.util.Log.d("leak-112-0", dataLeAk112);
		android.util.Log.d("leak-113-0", dataLeAk113);
		android.util.Log.d("leak-114-0", dataLeAk114);
		android.util.Log.d("leak-115-0", dataLeAk115);

        if (DEBUG) {
            Log.d(
                    TAG, "onCreate() "
                            + (savedInstanceState == null ? "(no bundle)"
                            : "(with bundle)")
            );
        }

        mDistribution.setFirst(
                MENU_DISTRIBUTION_START,
                DIALOG_DISTRIBUTION_START
        );

        // Check whether EULA has been accepted
        // or information about new version can be presented.
        if (mDistribution.showEulaOrNewVersion()) {
            return;
        }

        setDefaultKeyMode(DEFAULT_KEYS_SHORTCUT);

        // If no data was given in the intent (because we were started
        // as a MAIN activity), then use our default content provider.
        Intent intent = getIntent();
        if (intent.getData() == null) {
            intent.setData(Notes.CONTENT_URI);
        }

        // show loading
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        requestWindowFeature(Window.FEATURE_PROGRESS);

        // Inform the list we provide context menus for items
        setContentView(R.layout.noteslist);
        getListView().setOnCreateContextMenuListener(this);
        getListView().setEmptyView(findViewById(R.id.empty));
        getListView().setTextFilterEnabled(true);

        if (mActionBarAvailable) {
            TextView notext = (TextView) findViewById(R.id.empty);
            notext.setText(R.string.no_notes_actionbar);
        }

		/*
		 * // Perform a managed query. The Activity will handle closing and //
		 * requerying the cursor // when needed. Cursor cursor =
		 * managedQuery(getIntent().getData(), PROJECTION, null, null,
		 * Notes.DEFAULT_SORT_ORDER);
		 *
		 * /* // Used to map notes entries from the database to views
		 * SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
		 * R.layout.noteslist_item, cursor, new String[] { Notes.TITLE }, new
		 * int[] { android.R.id.text1 }); / mAdapter = new
		 * NotesListCursorAdapter(this, cursor, getIntent());
		 * setListAdapter(mAdapter);
		 */

        getListView().setOnScrollListener(this);

        mLastFilter = null;

        if (savedInstanceState != null) {
            mLastFilter = savedInstanceState.getString(BUNDLE_LAST_FILTER);
            if (mSelectedTag == null) {
                mSelectedTag = savedInstanceState.getString(BUNDLE_LAST_TAG);
            }

            // Restore information for context menu, for opening "Tags" dialog.
            if (savedInstanceState.containsKey(BUNDLE_CONTEXTMENUINFO_ID)) {
                long id = savedInstanceState.getLong(BUNDLE_CONTEXTMENUINFO_ID);
                int position = savedInstanceState
                        .getInt(BUNDLE_CONTEXTMENUINFO_POSITION);
                mContextMenuInfo = new AdapterView.AdapterContextMenuInfo(
                        null,
                        position, id
                );
            }
        }
        // if mSelectedTag was not in memory and not in bundle: try to recover it from persistent storage
        if (mSelectedTag == null) {
            SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
            String savedTag = settings.getString(BUNDLE_LAST_TAG, "");
            if (!savedTag.equals("")) {
                mSelectedTag = savedTag;
            }
        }

        mCursorUtils = new NotesListCursor(this, getIntent());

        // Make sure mAdapter is created here already,
        // because onPrepareDialog for the Tags dialog may be called
        // before onResume() is called.
        checkAdapter();

        if (Intent.ACTION_CREATE_SHORTCUT.equals(intent.getAction())) {
            setTitle(R.string.title_pick_note_for_shortcut);
        }

        updateTagList();

        Cursor cur = mAdapter.runQueryOnBackgroundThread(null, null);

        cur.registerDataSetObserver(
                new DataSetObserver() {
                    String dataLeAk76 = "";

					@Override
                    public void onChanged() {
                        dataLeAk76 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-118-0", dataLeAk118);
						android.util.Log.d("leak-76-0", dataLeAk76);
						NotesList.this.updateTagList();
                    }
                }
        );

        Spinner s = (Spinner) findViewById(R.id.tagselection);
        s.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    String dataLeAk78 = "";

					String dataLeAk77 = "";

					public void onItemSelected(AdapterView<?> parent, View view,
                                               int position, long id) {
                        dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-119-0", dataLeAk119);
						android.util.Log.d("leak-77-0", dataLeAk77);
						android.util.Log.d("leak-78-0", dataLeAk78);
						if (position == 0) {
                            mSelectedTag = null;
                        } else {
                            mSelectedTag = parent.getItemAtPosition(position).toString();
                        }
                        NotesList.this.updateQuery();
                        decryptDelayed();
                    }

                    public void onNothingSelected(AdapterView<?> arg0) {
						dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-120-0", dataLeAk120);
						android.util.Log.d("leak-77-1", dataLeAk77);
						android.util.Log.d("leak-78-1", dataLeAk78);

                    }
                }
        );

        mDecryptionFailed = false;
        mDecryptionSucceeded = false;

        // disable the progressbar when done.
        setProgressBarIndeterminateVisibility(false);
        setProgressBarVisibility(false);
    }

    protected void updateTagList() {

        dataLeAk79 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-1", dataLeAk75);
		android.util.Log.d("leak-79-1", dataLeAk79);
		android.util.Log.d("leak-80-1", dataLeAk80);
		android.util.Log.d("leak-81-1", dataLeAk81);
		android.util.Log.d("leak-82-1", dataLeAk82);
		android.util.Log.d("leak-83-1", dataLeAk83);
		android.util.Log.d("leak-84-1", dataLeAk84);
		android.util.Log.d("leak-85-1", dataLeAk85);
		android.util.Log.d("leak-86-1", dataLeAk86);
		android.util.Log.d("leak-87-1", dataLeAk87);
		android.util.Log.d("leak-88-1", dataLeAk88);
		android.util.Log.d("leak-89-1", dataLeAk89);
		android.util.Log.d("leak-90-1", dataLeAk90);
		android.util.Log.d("leak-91-1", dataLeAk91);
		android.util.Log.d("leak-92-1", dataLeAk92);
		android.util.Log.d("leak-93-1", dataLeAk93);
		android.util.Log.d("leak-94-1", dataLeAk94);
		android.util.Log.d("leak-95-1", dataLeAk95);
		android.util.Log.d("leak-96-1", dataLeAk96);
		android.util.Log.d("leak-97-1", dataLeAk97);
		android.util.Log.d("leak-98-1", dataLeAk98);
		android.util.Log.d("leak-99-1", dataLeAk99);
		android.util.Log.d("leak-100-1", dataLeAk100);
		android.util.Log.d("leak-101-1", dataLeAk101);
		android.util.Log.d("leak-102-1", dataLeAk102);
		android.util.Log.d("leak-103-1", dataLeAk103);
		android.util.Log.d("leak-105-1", dataLeAk105);
		android.util.Log.d("leak-106-1", dataLeAk106);
		android.util.Log.d("leak-109-1", dataLeAk109);
		android.util.Log.d("leak-110-1", dataLeAk110);
		android.util.Log.d("leak-111-1", dataLeAk111);
		android.util.Log.d("leak-112-1", dataLeAk112);
		android.util.Log.d("leak-113-1", dataLeAk113);
		android.util.Log.d("leak-114-1", dataLeAk114);
		android.util.Log.d("leak-115-1", dataLeAk115);
		List<String> taglist = new ArrayList<String>();

        Uri notesUri = getIntent().getData();

        Cursor managedCursor = getContentResolver().query(
                notesUri,
                new String[]{Notes.TAGS, Notes.ENCRYPTED}, null, null, null
        );

        if (managedCursor.moveToFirst()) {
            do {
                String tags = managedCursor.getString(0);
                long encrypted = managedCursor.getLong(1);

                if (!TextUtils.isEmpty(tags)) {
                    if (encrypted == 0) {
                        for (String tag : tags.split(",")) {
                            if (!taglist.contains(tag.trim())) {
                                taglist.add(tag.trim());
                            }
                        }
                    } else {
                        // Currently: ignore encrypted tags.

                        // TODO: store encrypted tags in an array,
                        // decrypt them, and show them.
                    }
                }
            } while (managedCursor.moveToNext());
        }
        Collections.sort(taglist, Collator.getInstance(Locale.getDefault()));
        taglist.add(0, getString(R.string.all_notes));
        Spinner s = (Spinner) findViewById(R.id.tagselection);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item, taglist
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
        int position = adapter.getPosition(mSelectedTag);
        if (position != -1) {
            s.setSelection(position);
        }

        // Hide Spinner if there are no tags
        if (taglist.size() > 1) {
            s.setVisibility(View.VISIBLE);
        } else {
            s.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
		dataLeAk80 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-2", dataLeAk75);
		android.util.Log.d("leak-79-2", dataLeAk79);
		android.util.Log.d("leak-80-2", dataLeAk80);
		android.util.Log.d("leak-81-2", dataLeAk81);
		android.util.Log.d("leak-82-2", dataLeAk82);
		android.util.Log.d("leak-83-2", dataLeAk83);
		android.util.Log.d("leak-84-2", dataLeAk84);
		android.util.Log.d("leak-85-2", dataLeAk85);
		android.util.Log.d("leak-86-2", dataLeAk86);
		android.util.Log.d("leak-87-2", dataLeAk87);
		android.util.Log.d("leak-88-2", dataLeAk88);
		android.util.Log.d("leak-89-2", dataLeAk89);
		android.util.Log.d("leak-90-2", dataLeAk90);
		android.util.Log.d("leak-91-2", dataLeAk91);
		android.util.Log.d("leak-92-2", dataLeAk92);
		android.util.Log.d("leak-93-2", dataLeAk93);
		android.util.Log.d("leak-94-2", dataLeAk94);
		android.util.Log.d("leak-95-2", dataLeAk95);
		android.util.Log.d("leak-96-2", dataLeAk96);
		android.util.Log.d("leak-97-2", dataLeAk97);
		android.util.Log.d("leak-98-2", dataLeAk98);
		android.util.Log.d("leak-99-2", dataLeAk99);
		android.util.Log.d("leak-100-2", dataLeAk100);
		android.util.Log.d("leak-101-2", dataLeAk101);
		android.util.Log.d("leak-102-2", dataLeAk102);
		android.util.Log.d("leak-103-2", dataLeAk103);
		android.util.Log.d("leak-105-2", dataLeAk105);
		android.util.Log.d("leak-106-2", dataLeAk106);
		android.util.Log.d("leak-109-2", dataLeAk109);
		android.util.Log.d("leak-110-2", dataLeAk110);
		android.util.Log.d("leak-111-2", dataLeAk111);
		android.util.Log.d("leak-112-2", dataLeAk112);
		android.util.Log.d("leak-113-2", dataLeAk113);
		android.util.Log.d("leak-114-2", dataLeAk114);
		android.util.Log.d("leak-115-2", dataLeAk115);
        if (DEBUG) {
            Log.d(TAG, "onResume()");
        }
        NotesListCursor.mSuspendQueries = false;

        // mCursorUtils.registerContentObserver(mListContentObserver);
        // mCursorUtils.registerDataSetObserver(mListDatasetObserver);

        checkAdapter();

        if (!mDecryptionFailed) {
            decryptDelayed();
        } else {
            // Reset
            mDecryptionFailed = false;
        }

        if (mDecryptionSucceeded) {
            NotesListCursor.mLoggedIn = true;
            if (DEBUG) {
                Log.d(TAG, "onResume: logged in");
            }
        }

        IntentFilter filter = new IntentFilter();
        filter.addAction(CryptoIntents.ACTION_CRYPTO_LOGGED_OUT);
        registerReceiver(mBroadcastReceiver, filter);

        // getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    /*
     * ContentObserver mListContentObserver = new ContentObserver(mHandler) {
     *
     * @Override public boolean deliverSelfNotifications() { Log.i(TAG,
     * "NotesList:mListContentObserver: deliverSelfNotifications"); return
     * super.deliverSelfNotifications(); }
     *
     * @Override public void onChange(boolean arg0) { Log.i(TAG,
     * "NotesList:mListContentObserver: onChange");
     * //mCursorListFilter.requery(); updateTagList();
     *
     * super.onChange(arg0); } };
     *
     * DataSetObserver mListDatasetObserver = new DataSetObserver() {
     *
     * @Override public void onChanged() { Log.i(TAG,
     * "mListDatasetObserver: onChanged"); super.onChanged(); }
     *
     * @Override public void onInvalidated() { Log.i(TAG,
     * "mListDatasetObserver: onInvalidated"); super.onInvalidated(); }
     *
     * };
     */
    private void checkAdapter() {
        dataLeAk81 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-3", dataLeAk75);
		android.util.Log.d("leak-79-3", dataLeAk79);
		android.util.Log.d("leak-80-3", dataLeAk80);
		android.util.Log.d("leak-81-3", dataLeAk81);
		android.util.Log.d("leak-82-3", dataLeAk82);
		android.util.Log.d("leak-83-3", dataLeAk83);
		android.util.Log.d("leak-84-3", dataLeAk84);
		android.util.Log.d("leak-85-3", dataLeAk85);
		android.util.Log.d("leak-86-3", dataLeAk86);
		android.util.Log.d("leak-87-3", dataLeAk87);
		android.util.Log.d("leak-88-3", dataLeAk88);
		android.util.Log.d("leak-89-3", dataLeAk89);
		android.util.Log.d("leak-90-3", dataLeAk90);
		android.util.Log.d("leak-91-3", dataLeAk91);
		android.util.Log.d("leak-92-3", dataLeAk92);
		android.util.Log.d("leak-93-3", dataLeAk93);
		android.util.Log.d("leak-94-3", dataLeAk94);
		android.util.Log.d("leak-95-3", dataLeAk95);
		android.util.Log.d("leak-96-3", dataLeAk96);
		android.util.Log.d("leak-97-3", dataLeAk97);
		android.util.Log.d("leak-98-3", dataLeAk98);
		android.util.Log.d("leak-99-3", dataLeAk99);
		android.util.Log.d("leak-100-3", dataLeAk100);
		android.util.Log.d("leak-101-3", dataLeAk101);
		android.util.Log.d("leak-102-3", dataLeAk102);
		android.util.Log.d("leak-103-3", dataLeAk103);
		android.util.Log.d("leak-105-3", dataLeAk105);
		android.util.Log.d("leak-106-3", dataLeAk106);
		android.util.Log.d("leak-109-3", dataLeAk109);
		android.util.Log.d("leak-110-3", dataLeAk110);
		android.util.Log.d("leak-111-3", dataLeAk111);
		android.util.Log.d("leak-112-3", dataLeAk112);
		android.util.Log.d("leak-113-3", dataLeAk113);
		android.util.Log.d("leak-114-3", dataLeAk114);
		android.util.Log.d("leak-115-3", dataLeAk115);
		if (mAdapter == null) {
            // Perform a managed query. The Activity will handle closing and
            // requerying the cursor
            // when needed.
            // Cursor cursor = getContentResolver().query(getIntent().getData(),
            // NotesListCursorUtils.PROJECTION, null,
            // null, Notes.DEFAULT_SORT_ORDER);

            Cursor cursor = mCursorUtils.query(null, null);

			/*
			 * // Used to map notes entries from the database to views
			 * SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
			 * R.layout.noteslist_item, cursor, new String[] { Notes.TITLE },
			 * new int[] { android.R.id.text1 });
			 */
            mAdapter = new NotesListCursorAdapter(this, cursor, mCursorUtils);
            setListAdapter(mAdapter);

            if (mSelectedTag == null) {
                Spinner s = (Spinner) findViewById(R.id.tagselection);

                if (s.getSelectedItemPosition() == 0) {
                    mSelectedTag = null;
                } else {
                    mSelectedTag = (String) s.getSelectedItem();
                }
            }
            updateQuery();
        } else {
            mAdapter.getCursor().requery();
        }
    }

    protected void updateQuery() {
        dataLeAk82 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-4", dataLeAk75);
		android.util.Log.d("leak-79-4", dataLeAk79);
		android.util.Log.d("leak-80-4", dataLeAk80);
		android.util.Log.d("leak-81-4", dataLeAk81);
		android.util.Log.d("leak-82-4", dataLeAk82);
		android.util.Log.d("leak-83-4", dataLeAk83);
		android.util.Log.d("leak-84-4", dataLeAk84);
		android.util.Log.d("leak-85-4", dataLeAk85);
		android.util.Log.d("leak-86-4", dataLeAk86);
		android.util.Log.d("leak-87-4", dataLeAk87);
		android.util.Log.d("leak-88-4", dataLeAk88);
		android.util.Log.d("leak-89-4", dataLeAk89);
		android.util.Log.d("leak-90-4", dataLeAk90);
		android.util.Log.d("leak-91-4", dataLeAk91);
		android.util.Log.d("leak-92-4", dataLeAk92);
		android.util.Log.d("leak-93-4", dataLeAk93);
		android.util.Log.d("leak-94-4", dataLeAk94);
		android.util.Log.d("leak-95-4", dataLeAk95);
		android.util.Log.d("leak-96-4", dataLeAk96);
		android.util.Log.d("leak-97-4", dataLeAk97);
		android.util.Log.d("leak-98-4", dataLeAk98);
		android.util.Log.d("leak-99-4", dataLeAk99);
		android.util.Log.d("leak-100-4", dataLeAk100);
		android.util.Log.d("leak-101-4", dataLeAk101);
		android.util.Log.d("leak-102-4", dataLeAk102);
		android.util.Log.d("leak-103-4", dataLeAk103);
		android.util.Log.d("leak-105-4", dataLeAk105);
		android.util.Log.d("leak-106-4", dataLeAk106);
		android.util.Log.d("leak-109-4", dataLeAk109);
		android.util.Log.d("leak-110-4", dataLeAk110);
		android.util.Log.d("leak-111-4", dataLeAk111);
		android.util.Log.d("leak-112-4", dataLeAk112);
		android.util.Log.d("leak-113-4", dataLeAk113);
		android.util.Log.d("leak-114-4", dataLeAk114);
		android.util.Log.d("leak-115-4", dataLeAk115);
		if (DEBUG) {
            Log.i(TAG, "updateQuery: Lastfilter: " + mLastFilter + ", mSelectedTag: " + mSelectedTag);
        }

        // if (mLastFilter != null || mSelectedTag != null) {
        Cursor cursor = mAdapter.runQueryOnBackgroundThread(
                mLastFilter,
                mSelectedTag
        );
        mAdapter.changeCursor(cursor);
        // }
    }

    @Override
    protected void onPause() {
        super.onPause();
		dataLeAk83 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-5", dataLeAk75);
		android.util.Log.d("leak-79-5", dataLeAk79);
		android.util.Log.d("leak-80-5", dataLeAk80);
		android.util.Log.d("leak-81-5", dataLeAk81);
		android.util.Log.d("leak-82-5", dataLeAk82);
		android.util.Log.d("leak-83-5", dataLeAk83);
		android.util.Log.d("leak-84-5", dataLeAk84);
		android.util.Log.d("leak-85-5", dataLeAk85);
		android.util.Log.d("leak-86-5", dataLeAk86);
		android.util.Log.d("leak-87-5", dataLeAk87);
		android.util.Log.d("leak-88-5", dataLeAk88);
		android.util.Log.d("leak-89-5", dataLeAk89);
		android.util.Log.d("leak-90-5", dataLeAk90);
		android.util.Log.d("leak-91-5", dataLeAk91);
		android.util.Log.d("leak-92-5", dataLeAk92);
		android.util.Log.d("leak-93-5", dataLeAk93);
		android.util.Log.d("leak-94-5", dataLeAk94);
		android.util.Log.d("leak-95-5", dataLeAk95);
		android.util.Log.d("leak-96-5", dataLeAk96);
		android.util.Log.d("leak-97-5", dataLeAk97);
		android.util.Log.d("leak-98-5", dataLeAk98);
		android.util.Log.d("leak-99-5", dataLeAk99);
		android.util.Log.d("leak-100-5", dataLeAk100);
		android.util.Log.d("leak-101-5", dataLeAk101);
		android.util.Log.d("leak-102-5", dataLeAk102);
		android.util.Log.d("leak-103-5", dataLeAk103);
		android.util.Log.d("leak-105-5", dataLeAk105);
		android.util.Log.d("leak-106-5", dataLeAk106);
		android.util.Log.d("leak-109-5", dataLeAk109);
		android.util.Log.d("leak-110-5", dataLeAk110);
		android.util.Log.d("leak-111-5", dataLeAk111);
		android.util.Log.d("leak-112-5", dataLeAk112);
		android.util.Log.d("leak-113-5", dataLeAk113);
		android.util.Log.d("leak-114-5", dataLeAk114);
		android.util.Log.d("leak-115-5", dataLeAk115);

        mLastFilter = mCursorUtils.mCurrentFilter;

        // Deactivating the cursor leads to flickering whenever some
        // encrypted information is retrieved.
        // Cursor c = mAdapter.getCursor();
        // if (c != null) {
        // c.deactivate();
        // }

        // mCursorUtils.unregisterDataSetObserver(mListDatasetObserver);
        // mCursorUtils.unregisterContentObserver(mListContentObserver);

        unregisterReceiver(mBroadcastReceiver);

        // After unregistering broadcastreceiver, the logged in state is not
        // clear.
        NotesListCursor.mLoggedIn = false;
        if (DEBUG) {
            Log.d(TAG, "onPause: logged out");
        }

        // No need wasting a lot of time doing queries when external
        // applications change the
        // database - we requery in onResume anyway.
        NotesListCursor.mSuspendQueries = true;
        mDecryptionFailed = false;
        mDecryptionSucceeded = false;
    }

    @Override
    protected void onStop() {
        super.onStop();
		dataLeAk84 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-6", dataLeAk75);
		android.util.Log.d("leak-79-6", dataLeAk79);
		android.util.Log.d("leak-80-6", dataLeAk80);
		android.util.Log.d("leak-81-6", dataLeAk81);
		android.util.Log.d("leak-82-6", dataLeAk82);
		android.util.Log.d("leak-83-6", dataLeAk83);
		android.util.Log.d("leak-84-6", dataLeAk84);
		android.util.Log.d("leak-85-6", dataLeAk85);
		android.util.Log.d("leak-86-6", dataLeAk86);
		android.util.Log.d("leak-87-6", dataLeAk87);
		android.util.Log.d("leak-88-6", dataLeAk88);
		android.util.Log.d("leak-89-6", dataLeAk89);
		android.util.Log.d("leak-90-6", dataLeAk90);
		android.util.Log.d("leak-91-6", dataLeAk91);
		android.util.Log.d("leak-92-6", dataLeAk92);
		android.util.Log.d("leak-93-6", dataLeAk93);
		android.util.Log.d("leak-94-6", dataLeAk94);
		android.util.Log.d("leak-95-6", dataLeAk95);
		android.util.Log.d("leak-96-6", dataLeAk96);
		android.util.Log.d("leak-97-6", dataLeAk97);
		android.util.Log.d("leak-98-6", dataLeAk98);
		android.util.Log.d("leak-99-6", dataLeAk99);
		android.util.Log.d("leak-100-6", dataLeAk100);
		android.util.Log.d("leak-101-6", dataLeAk101);
		android.util.Log.d("leak-102-6", dataLeAk102);
		android.util.Log.d("leak-103-6", dataLeAk103);
		android.util.Log.d("leak-105-6", dataLeAk105);
		android.util.Log.d("leak-106-6", dataLeAk106);
		android.util.Log.d("leak-109-6", dataLeAk109);
		android.util.Log.d("leak-110-6", dataLeAk110);
		android.util.Log.d("leak-111-6", dataLeAk111);
		android.util.Log.d("leak-112-6", dataLeAk112);
		android.util.Log.d("leak-113-6", dataLeAk113);
		android.util.Log.d("leak-114-6", dataLeAk114);
		android.util.Log.d("leak-115-6", dataLeAk115);
        if (DEBUG) {
            Log.d(TAG, "onStop()");
        }

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(BUNDLE_LAST_TAG, mSelectedTag);
        editor.commit();
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
		dataLeAk85 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-7", dataLeAk75);
		android.util.Log.d("leak-79-7", dataLeAk79);
		android.util.Log.d("leak-80-7", dataLeAk80);
		android.util.Log.d("leak-81-7", dataLeAk81);
		android.util.Log.d("leak-82-7", dataLeAk82);
		android.util.Log.d("leak-83-7", dataLeAk83);
		android.util.Log.d("leak-84-7", dataLeAk84);
		android.util.Log.d("leak-85-7", dataLeAk85);
		android.util.Log.d("leak-86-7", dataLeAk86);
		android.util.Log.d("leak-87-7", dataLeAk87);
		android.util.Log.d("leak-88-7", dataLeAk88);
		android.util.Log.d("leak-89-7", dataLeAk89);
		android.util.Log.d("leak-90-7", dataLeAk90);
		android.util.Log.d("leak-91-7", dataLeAk91);
		android.util.Log.d("leak-92-7", dataLeAk92);
		android.util.Log.d("leak-93-7", dataLeAk93);
		android.util.Log.d("leak-94-7", dataLeAk94);
		android.util.Log.d("leak-95-7", dataLeAk95);
		android.util.Log.d("leak-96-7", dataLeAk96);
		android.util.Log.d("leak-97-7", dataLeAk97);
		android.util.Log.d("leak-98-7", dataLeAk98);
		android.util.Log.d("leak-99-7", dataLeAk99);
		android.util.Log.d("leak-100-7", dataLeAk100);
		android.util.Log.d("leak-101-7", dataLeAk101);
		android.util.Log.d("leak-102-7", dataLeAk102);
		android.util.Log.d("leak-103-7", dataLeAk103);
		android.util.Log.d("leak-105-7", dataLeAk105);
		android.util.Log.d("leak-106-7", dataLeAk106);
		android.util.Log.d("leak-109-7", dataLeAk109);
		android.util.Log.d("leak-110-7", dataLeAk110);
		android.util.Log.d("leak-111-7", dataLeAk111);
		android.util.Log.d("leak-112-7", dataLeAk112);
		android.util.Log.d("leak-113-7", dataLeAk113);
		android.util.Log.d("leak-114-7", dataLeAk114);
		android.util.Log.d("leak-115-7", dataLeAk115);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
		dataLeAk86 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-8", dataLeAk75);
		android.util.Log.d("leak-79-8", dataLeAk79);
		android.util.Log.d("leak-80-8", dataLeAk80);
		android.util.Log.d("leak-81-8", dataLeAk81);
		android.util.Log.d("leak-82-8", dataLeAk82);
		android.util.Log.d("leak-83-8", dataLeAk83);
		android.util.Log.d("leak-84-8", dataLeAk84);
		android.util.Log.d("leak-85-8", dataLeAk85);
		android.util.Log.d("leak-86-8", dataLeAk86);
		android.util.Log.d("leak-87-8", dataLeAk87);
		android.util.Log.d("leak-88-8", dataLeAk88);
		android.util.Log.d("leak-89-8", dataLeAk89);
		android.util.Log.d("leak-90-8", dataLeAk90);
		android.util.Log.d("leak-91-8", dataLeAk91);
		android.util.Log.d("leak-92-8", dataLeAk92);
		android.util.Log.d("leak-93-8", dataLeAk93);
		android.util.Log.d("leak-94-8", dataLeAk94);
		android.util.Log.d("leak-95-8", dataLeAk95);
		android.util.Log.d("leak-96-8", dataLeAk96);
		android.util.Log.d("leak-97-8", dataLeAk97);
		android.util.Log.d("leak-98-8", dataLeAk98);
		android.util.Log.d("leak-99-8", dataLeAk99);
		android.util.Log.d("leak-100-8", dataLeAk100);
		android.util.Log.d("leak-101-8", dataLeAk101);
		android.util.Log.d("leak-102-8", dataLeAk102);
		android.util.Log.d("leak-103-8", dataLeAk103);
		android.util.Log.d("leak-105-8", dataLeAk105);
		android.util.Log.d("leak-106-8", dataLeAk106);
		android.util.Log.d("leak-109-8", dataLeAk109);
		android.util.Log.d("leak-110-8", dataLeAk110);
		android.util.Log.d("leak-111-8", dataLeAk111);
		android.util.Log.d("leak-112-8", dataLeAk112);
		android.util.Log.d("leak-113-8", dataLeAk113);
		android.util.Log.d("leak-114-8", dataLeAk114);
		android.util.Log.d("leak-115-8", dataLeAk115);

        outState.putString(BUNDLE_LAST_FILTER, mCursorUtils.mCurrentFilter);
        outState.putString(BUNDLE_LAST_TAG, mSelectedTag);

        if (mContextMenuInfo != null) {
            outState.putLong(BUNDLE_CONTEXTMENUINFO_ID, mContextMenuInfo.id);
            outState.putInt(
                    BUNDLE_CONTEXTMENUINFO_POSITION,
                    mContextMenuInfo.position
            );
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
		dataLeAk87 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-9", dataLeAk75);
		android.util.Log.d("leak-79-9", dataLeAk79);
		android.util.Log.d("leak-80-9", dataLeAk80);
		android.util.Log.d("leak-81-9", dataLeAk81);
		android.util.Log.d("leak-82-9", dataLeAk82);
		android.util.Log.d("leak-83-9", dataLeAk83);
		android.util.Log.d("leak-84-9", dataLeAk84);
		android.util.Log.d("leak-85-9", dataLeAk85);
		android.util.Log.d("leak-86-9", dataLeAk86);
		android.util.Log.d("leak-87-9", dataLeAk87);
		android.util.Log.d("leak-88-9", dataLeAk88);
		android.util.Log.d("leak-89-9", dataLeAk89);
		android.util.Log.d("leak-90-9", dataLeAk90);
		android.util.Log.d("leak-91-9", dataLeAk91);
		android.util.Log.d("leak-92-9", dataLeAk92);
		android.util.Log.d("leak-93-9", dataLeAk93);
		android.util.Log.d("leak-94-9", dataLeAk94);
		android.util.Log.d("leak-95-9", dataLeAk95);
		android.util.Log.d("leak-96-9", dataLeAk96);
		android.util.Log.d("leak-97-9", dataLeAk97);
		android.util.Log.d("leak-98-9", dataLeAk98);
		android.util.Log.d("leak-99-9", dataLeAk99);
		android.util.Log.d("leak-100-9", dataLeAk100);
		android.util.Log.d("leak-101-9", dataLeAk101);
		android.util.Log.d("leak-102-9", dataLeAk102);
		android.util.Log.d("leak-103-9", dataLeAk103);
		android.util.Log.d("leak-105-9", dataLeAk105);
		android.util.Log.d("leak-106-9", dataLeAk106);
		android.util.Log.d("leak-109-9", dataLeAk109);
		android.util.Log.d("leak-110-9", dataLeAk110);
		android.util.Log.d("leak-111-9", dataLeAk111);
		android.util.Log.d("leak-112-9", dataLeAk112);
		android.util.Log.d("leak-113-9", dataLeAk113);
		android.util.Log.d("leak-114-9", dataLeAk114);
		android.util.Log.d("leak-115-9", dataLeAk115);

        MenuItem insertItem = menu.add(
                0, MENU_ITEM_INSERT, 0,
                R.string.menu_insert
        );
        insertItem.setShortcut('1', 'i');
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            // Icon for holo theme
            insertItem.setIcon(R.drawable.ic_menu_add_note);
        } else {
            insertItem.setIcon(android.R.drawable.ic_menu_add);
        }
        // Show the delete icon when there is an actionbar
        if (mActionBarAvailable) {
            WrapActionBar.showIfRoom(insertItem);
        }

        menu.add(0, MENU_SEARCH, 0, R.string.menu_search).setShortcut('2', 's')
                .setIcon(android.R.drawable.ic_menu_search);

        menu.add(0, MENU_OPEN, 0, R.string.menu_open_from_sdcard)
                .setShortcut('3', 'o').setIcon(R.drawable.ic_menu_folder);

        menu.add(0, MENU_SETTINGS, 0, R.string.settings)
                .setIcon(android.R.drawable.ic_menu_preferences)
                .setShortcut('9', 's');

        // Add distribution menu items last.
        mDistribution.onCreateOptionsMenu(menu);

        // Generate any additional actions that can be performed on the
        // overall list. In a normal install, there are no additional
        // actions found here, but this allows other applications to extend
        // our menu with their own actions.
        Intent intent = new Intent(null, getIntent().getData());
        if (DEBUG) {
            Log.i(TAG, "Building options menu for: " + intent.getDataString());
        }
        intent.addCategory(Intent.CATEGORY_ALTERNATIVE);
        // menu
        // .addIntentOptions(CATEGORY_ALTERNATIVE_GLOBAL, 0, 0,
        // new ComponentName(this, NotesList.class), null, intent,
        // 0, null);

        // Workaround to add icons:
        MenuIntentOptionsWithIcons menu2 = new MenuIntentOptionsWithIcons(
                this,
                menu
        );
        menu2.addIntentOptions(
                CATEGORY_ALTERNATIVE_GLOBAL, 0, 0,
                new ComponentName(this, NotesList.class), null, intent, 0, null
        );

        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
		dataLeAk88 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-10", dataLeAk75);
		android.util.Log.d("leak-79-10", dataLeAk79);
		android.util.Log.d("leak-80-10", dataLeAk80);
		android.util.Log.d("leak-81-10", dataLeAk81);
		android.util.Log.d("leak-82-10", dataLeAk82);
		android.util.Log.d("leak-83-10", dataLeAk83);
		android.util.Log.d("leak-84-10", dataLeAk84);
		android.util.Log.d("leak-85-10", dataLeAk85);
		android.util.Log.d("leak-86-10", dataLeAk86);
		android.util.Log.d("leak-87-10", dataLeAk87);
		android.util.Log.d("leak-88-10", dataLeAk88);
		android.util.Log.d("leak-89-10", dataLeAk89);
		android.util.Log.d("leak-90-10", dataLeAk90);
		android.util.Log.d("leak-91-10", dataLeAk91);
		android.util.Log.d("leak-92-10", dataLeAk92);
		android.util.Log.d("leak-93-10", dataLeAk93);
		android.util.Log.d("leak-94-10", dataLeAk94);
		android.util.Log.d("leak-95-10", dataLeAk95);
		android.util.Log.d("leak-96-10", dataLeAk96);
		android.util.Log.d("leak-97-10", dataLeAk97);
		android.util.Log.d("leak-98-10", dataLeAk98);
		android.util.Log.d("leak-99-10", dataLeAk99);
		android.util.Log.d("leak-100-10", dataLeAk100);
		android.util.Log.d("leak-101-10", dataLeAk101);
		android.util.Log.d("leak-102-10", dataLeAk102);
		android.util.Log.d("leak-103-10", dataLeAk103);
		android.util.Log.d("leak-105-10", dataLeAk105);
		android.util.Log.d("leak-106-10", dataLeAk106);
		android.util.Log.d("leak-109-10", dataLeAk109);
		android.util.Log.d("leak-110-10", dataLeAk110);
		android.util.Log.d("leak-111-10", dataLeAk111);
		android.util.Log.d("leak-112-10", dataLeAk112);
		android.util.Log.d("leak-113-10", dataLeAk113);
		android.util.Log.d("leak-114-10", dataLeAk114);
		android.util.Log.d("leak-115-10", dataLeAk115);
        final boolean haveItems = getListAdapter() != null && getListAdapter().getCount() > 0;

        // If there are any notes in the list (which implies that one of
        // them is selected), then we need to generate the actions that
        // can be performed on the current selection. This will be a combination
        // of our own specific actions along with any extensions that can be
        // found.
        if (haveItems) {
            // This is the selected item.
            Uri uri = ContentUris.withAppendedId(
                    getIntent().getData(),
                    getSelectedItemId()
            );

            // Build menu... always starts with the EDIT action...
            Intent[] specifics = new Intent[1];
            specifics[0] = new Intent(Intent.ACTION_EDIT, uri);
            MenuItem[] items = new MenuItem[1];

            // ... is followed by whatever other actions are available...
            Intent intent = new Intent(null, uri);
            intent.addCategory(Intent.CATEGORY_ALTERNATIVE);
            // menu.addIntentOptions(Menu.CATEGORY_ALTERNATIVE, 0, 0, null,
            // specifics, intent, 0, items);

            // Workaround to add icons:
            MenuIntentOptionsWithIcons menu2 = new MenuIntentOptionsWithIcons(
                    this, menu
            );
            menu2.addIntentOptions(
                    Menu.CATEGORY_ALTERNATIVE, 0, 0, null,
                    specifics, intent, 0, items
            );

            // Give a shortcut to the edit action.
            if (items[0] != null) {
                items[0].setShortcut('1', 'e');
            }
        } else {
            menu.removeGroup(Menu.CATEGORY_ALTERNATIVE);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        dataLeAk89 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-11", dataLeAk75);
		android.util.Log.d("leak-79-11", dataLeAk79);
		android.util.Log.d("leak-80-11", dataLeAk80);
		android.util.Log.d("leak-81-11", dataLeAk81);
		android.util.Log.d("leak-82-11", dataLeAk82);
		android.util.Log.d("leak-83-11", dataLeAk83);
		android.util.Log.d("leak-84-11", dataLeAk84);
		android.util.Log.d("leak-85-11", dataLeAk85);
		android.util.Log.d("leak-86-11", dataLeAk86);
		android.util.Log.d("leak-87-11", dataLeAk87);
		android.util.Log.d("leak-88-11", dataLeAk88);
		android.util.Log.d("leak-89-11", dataLeAk89);
		android.util.Log.d("leak-90-11", dataLeAk90);
		android.util.Log.d("leak-91-11", dataLeAk91);
		android.util.Log.d("leak-92-11", dataLeAk92);
		android.util.Log.d("leak-93-11", dataLeAk93);
		android.util.Log.d("leak-94-11", dataLeAk94);
		android.util.Log.d("leak-95-11", dataLeAk95);
		android.util.Log.d("leak-96-11", dataLeAk96);
		android.util.Log.d("leak-97-11", dataLeAk97);
		android.util.Log.d("leak-98-11", dataLeAk98);
		android.util.Log.d("leak-99-11", dataLeAk99);
		android.util.Log.d("leak-100-11", dataLeAk100);
		android.util.Log.d("leak-101-11", dataLeAk101);
		android.util.Log.d("leak-102-11", dataLeAk102);
		android.util.Log.d("leak-103-11", dataLeAk103);
		android.util.Log.d("leak-105-11", dataLeAk105);
		android.util.Log.d("leak-106-11", dataLeAk106);
		android.util.Log.d("leak-109-11", dataLeAk109);
		android.util.Log.d("leak-110-11", dataLeAk110);
		android.util.Log.d("leak-111-11", dataLeAk111);
		android.util.Log.d("leak-112-11", dataLeAk112);
		android.util.Log.d("leak-113-11", dataLeAk113);
		android.util.Log.d("leak-114-11", dataLeAk114);
		android.util.Log.d("leak-115-11", dataLeAk115);
		switch (item.getItemId()) {
            case MENU_ITEM_INSERT:
                insertNewNote();
                return true;
            case MENU_SEARCH:
                search();
                return true;
            case MENU_OPEN:
                openFromSdCard();
                return true;
            case MENU_SETTINGS:
                showNotesListSettings();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Launch activity to insert a new item.
     */
    private void insertNewNote() {
        dataLeAk90 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-12", dataLeAk75);
		android.util.Log.d("leak-79-12", dataLeAk79);
		android.util.Log.d("leak-80-12", dataLeAk80);
		android.util.Log.d("leak-81-12", dataLeAk81);
		android.util.Log.d("leak-82-12", dataLeAk82);
		android.util.Log.d("leak-83-12", dataLeAk83);
		android.util.Log.d("leak-84-12", dataLeAk84);
		android.util.Log.d("leak-85-12", dataLeAk85);
		android.util.Log.d("leak-86-12", dataLeAk86);
		android.util.Log.d("leak-87-12", dataLeAk87);
		android.util.Log.d("leak-88-12", dataLeAk88);
		android.util.Log.d("leak-89-12", dataLeAk89);
		android.util.Log.d("leak-90-12", dataLeAk90);
		android.util.Log.d("leak-91-12", dataLeAk91);
		android.util.Log.d("leak-92-12", dataLeAk92);
		android.util.Log.d("leak-93-12", dataLeAk93);
		android.util.Log.d("leak-94-12", dataLeAk94);
		android.util.Log.d("leak-95-12", dataLeAk95);
		android.util.Log.d("leak-96-12", dataLeAk96);
		android.util.Log.d("leak-97-12", dataLeAk97);
		android.util.Log.d("leak-98-12", dataLeAk98);
		android.util.Log.d("leak-99-12", dataLeAk99);
		android.util.Log.d("leak-100-12", dataLeAk100);
		android.util.Log.d("leak-101-12", dataLeAk101);
		android.util.Log.d("leak-102-12", dataLeAk102);
		android.util.Log.d("leak-103-12", dataLeAk103);
		android.util.Log.d("leak-105-12", dataLeAk105);
		android.util.Log.d("leak-106-12", dataLeAk106);
		android.util.Log.d("leak-109-12", dataLeAk109);
		android.util.Log.d("leak-110-12", dataLeAk110);
		android.util.Log.d("leak-111-12", dataLeAk111);
		android.util.Log.d("leak-112-12", dataLeAk112);
		android.util.Log.d("leak-113-12", dataLeAk113);
		android.util.Log.d("leak-114-12", dataLeAk114);
		android.util.Log.d("leak-115-12", dataLeAk115);
		// Launch activity to insert a new item
        Intent i = new Intent(Intent.ACTION_INSERT, getIntent().getData());
        i.putExtra(NotepadInternalIntents.EXTRA_TAGS, mSelectedTag);
        startActivity(i);
    }

    private void search() {
        dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-13", dataLeAk75);
		android.util.Log.d("leak-79-13", dataLeAk79);
		android.util.Log.d("leak-80-13", dataLeAk80);
		android.util.Log.d("leak-81-13", dataLeAk81);
		android.util.Log.d("leak-82-13", dataLeAk82);
		android.util.Log.d("leak-83-13", dataLeAk83);
		android.util.Log.d("leak-84-13", dataLeAk84);
		android.util.Log.d("leak-85-13", dataLeAk85);
		android.util.Log.d("leak-86-13", dataLeAk86);
		android.util.Log.d("leak-87-13", dataLeAk87);
		android.util.Log.d("leak-88-13", dataLeAk88);
		android.util.Log.d("leak-89-13", dataLeAk89);
		android.util.Log.d("leak-90-13", dataLeAk90);
		android.util.Log.d("leak-91-13", dataLeAk91);
		android.util.Log.d("leak-92-13", dataLeAk92);
		android.util.Log.d("leak-93-13", dataLeAk93);
		android.util.Log.d("leak-94-13", dataLeAk94);
		android.util.Log.d("leak-95-13", dataLeAk95);
		android.util.Log.d("leak-96-13", dataLeAk96);
		android.util.Log.d("leak-97-13", dataLeAk97);
		android.util.Log.d("leak-98-13", dataLeAk98);
		android.util.Log.d("leak-99-13", dataLeAk99);
		android.util.Log.d("leak-100-13", dataLeAk100);
		android.util.Log.d("leak-101-13", dataLeAk101);
		android.util.Log.d("leak-102-13", dataLeAk102);
		android.util.Log.d("leak-103-13", dataLeAk103);
		android.util.Log.d("leak-105-13", dataLeAk105);
		android.util.Log.d("leak-106-13", dataLeAk106);
		android.util.Log.d("leak-109-13", dataLeAk109);
		android.util.Log.d("leak-110-13", dataLeAk110);
		android.util.Log.d("leak-111-13", dataLeAk111);
		android.util.Log.d("leak-112-13", dataLeAk112);
		android.util.Log.d("leak-113-13", dataLeAk113);
		android.util.Log.d("leak-114-13", dataLeAk114);
		android.util.Log.d("leak-115-13", dataLeAk115);
		onSearchRequested();
    }

    private void openFromSdCard() {

        dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-14", dataLeAk75);
		android.util.Log.d("leak-79-14", dataLeAk79);
		android.util.Log.d("leak-80-14", dataLeAk80);
		android.util.Log.d("leak-81-14", dataLeAk81);
		android.util.Log.d("leak-82-14", dataLeAk82);
		android.util.Log.d("leak-83-14", dataLeAk83);
		android.util.Log.d("leak-84-14", dataLeAk84);
		android.util.Log.d("leak-85-14", dataLeAk85);
		android.util.Log.d("leak-86-14", dataLeAk86);
		android.util.Log.d("leak-87-14", dataLeAk87);
		android.util.Log.d("leak-88-14", dataLeAk88);
		android.util.Log.d("leak-89-14", dataLeAk89);
		android.util.Log.d("leak-90-14", dataLeAk90);
		android.util.Log.d("leak-91-14", dataLeAk91);
		android.util.Log.d("leak-92-14", dataLeAk92);
		android.util.Log.d("leak-93-14", dataLeAk93);
		android.util.Log.d("leak-94-14", dataLeAk94);
		android.util.Log.d("leak-95-14", dataLeAk95);
		android.util.Log.d("leak-96-14", dataLeAk96);
		android.util.Log.d("leak-97-14", dataLeAk97);
		android.util.Log.d("leak-98-14", dataLeAk98);
		android.util.Log.d("leak-99-14", dataLeAk99);
		android.util.Log.d("leak-100-14", dataLeAk100);
		android.util.Log.d("leak-101-14", dataLeAk101);
		android.util.Log.d("leak-102-14", dataLeAk102);
		android.util.Log.d("leak-103-14", dataLeAk103);
		android.util.Log.d("leak-105-14", dataLeAk105);
		android.util.Log.d("leak-106-14", dataLeAk106);
		android.util.Log.d("leak-109-14", dataLeAk109);
		android.util.Log.d("leak-110-14", dataLeAk110);
		android.util.Log.d("leak-111-14", dataLeAk111);
		android.util.Log.d("leak-112-14", dataLeAk112);
		android.util.Log.d("leak-113-14", dataLeAk113);
		android.util.Log.d("leak-114-14", dataLeAk114);
		android.util.Log.d("leak-115-14", dataLeAk115);
		File sdcard = getSdCardPath();
        String directory = sdcard.getAbsolutePath();
        if (!directory.endsWith("/")) {
            directory += "/";
        }
        Uri uri = FileUriUtils.getUri(directory);

        Intent i = new Intent(this, DialogHostingActivity.class);
        i.putExtra(
                DialogHostingActivity.EXTRA_DIALOG_ID,
                DialogHostingActivity.DIALOG_ID_OPEN
        );
        i.setData(uri);
        startActivityForResult(i, REQUEST_CODE_OPEN);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view,
                                    ContextMenuInfo menuInfo) {
        dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-15", dataLeAk75);
		android.util.Log.d("leak-79-15", dataLeAk79);
		android.util.Log.d("leak-80-15", dataLeAk80);
		android.util.Log.d("leak-81-15", dataLeAk81);
		android.util.Log.d("leak-82-15", dataLeAk82);
		android.util.Log.d("leak-83-15", dataLeAk83);
		android.util.Log.d("leak-84-15", dataLeAk84);
		android.util.Log.d("leak-85-15", dataLeAk85);
		android.util.Log.d("leak-86-15", dataLeAk86);
		android.util.Log.d("leak-87-15", dataLeAk87);
		android.util.Log.d("leak-88-15", dataLeAk88);
		android.util.Log.d("leak-89-15", dataLeAk89);
		android.util.Log.d("leak-90-15", dataLeAk90);
		android.util.Log.d("leak-91-15", dataLeAk91);
		android.util.Log.d("leak-92-15", dataLeAk92);
		android.util.Log.d("leak-93-15", dataLeAk93);
		android.util.Log.d("leak-94-15", dataLeAk94);
		android.util.Log.d("leak-95-15", dataLeAk95);
		android.util.Log.d("leak-96-15", dataLeAk96);
		android.util.Log.d("leak-97-15", dataLeAk97);
		android.util.Log.d("leak-98-15", dataLeAk98);
		android.util.Log.d("leak-99-15", dataLeAk99);
		android.util.Log.d("leak-100-15", dataLeAk100);
		android.util.Log.d("leak-101-15", dataLeAk101);
		android.util.Log.d("leak-102-15", dataLeAk102);
		android.util.Log.d("leak-103-15", dataLeAk103);
		android.util.Log.d("leak-105-15", dataLeAk105);
		android.util.Log.d("leak-106-15", dataLeAk106);
		android.util.Log.d("leak-109-15", dataLeAk109);
		android.util.Log.d("leak-110-15", dataLeAk110);
		android.util.Log.d("leak-111-15", dataLeAk111);
		android.util.Log.d("leak-112-15", dataLeAk112);
		android.util.Log.d("leak-113-15", dataLeAk113);
		android.util.Log.d("leak-114-15", dataLeAk114);
		android.util.Log.d("leak-115-15", dataLeAk115);
		AdapterView.AdapterContextMenuInfo info;
        try {
            info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        } catch (ClassCastException e) {
            Log.e(TAG, "bad menuInfo", e);
            return;
        }

        Cursor cursor = (Cursor) getListAdapter().getItem(info.position);
        if (cursor == null) {
            // For some reason the requested item isn't available, do nothing
            return;
        }

        Uri noteUri = ContentUris
                .withAppendedId(getIntent().getData(), info.id);

        long encrypted = cursor.getLong(NotesListCursor.COLUMN_INDEX_ENCRYPTED);

        // Setup the menu header
        menu.setHeaderTitle(
                cursor
                        .getString(NotesListCursor.COLUMN_INDEX_TITLE)
        );

        menu.add(0, MENU_ITEM_EDIT_TAGS, 0, R.string.menu_edit_tags);

        if (encrypted == 0) {

            // Add a menu item to send the note
            menu.add(0, MENU_ITEM_SHARE, 0, R.string.menu_share);

            // Added automatically through manifest:
            // menu.add(0, MENU_ITEM_SAVE, 0, R.string.menu_save_to_sdcard);

            menu.add(0, MENU_ITEM_ENCRYPT, 0, R.string.menu_encrypt);
        } else {
            menu.add(0, MENU_ITEM_UNENCRYPT, 0, R.string.menu_undo_encryption);
        }

        // Add a menu item to delete the note
        menu.add(0, MENU_ITEM_DELETE, 0, R.string.menu_delete);

        // Add additional items only if note is not encrypted:

        if (encrypted == 0) {
            Intent intent = new Intent(null, noteUri);
            intent.addCategory(Intent.CATEGORY_ALTERNATIVE);
            menu.addIntentOptions(
                    Menu.CATEGORY_ALTERNATIVE, 0, 0,
                    new ComponentName(this, NotesList.class), null, intent, 0,
                    null
            );
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        dataLeAk94 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-16", dataLeAk75);
		android.util.Log.d("leak-79-16", dataLeAk79);
		android.util.Log.d("leak-80-16", dataLeAk80);
		android.util.Log.d("leak-81-16", dataLeAk81);
		android.util.Log.d("leak-82-16", dataLeAk82);
		android.util.Log.d("leak-83-16", dataLeAk83);
		android.util.Log.d("leak-84-16", dataLeAk84);
		android.util.Log.d("leak-85-16", dataLeAk85);
		android.util.Log.d("leak-86-16", dataLeAk86);
		android.util.Log.d("leak-87-16", dataLeAk87);
		android.util.Log.d("leak-88-16", dataLeAk88);
		android.util.Log.d("leak-89-16", dataLeAk89);
		android.util.Log.d("leak-90-16", dataLeAk90);
		android.util.Log.d("leak-91-16", dataLeAk91);
		android.util.Log.d("leak-92-16", dataLeAk92);
		android.util.Log.d("leak-93-16", dataLeAk93);
		android.util.Log.d("leak-94-16", dataLeAk94);
		android.util.Log.d("leak-95-16", dataLeAk95);
		android.util.Log.d("leak-96-16", dataLeAk96);
		android.util.Log.d("leak-97-16", dataLeAk97);
		android.util.Log.d("leak-98-16", dataLeAk98);
		android.util.Log.d("leak-99-16", dataLeAk99);
		android.util.Log.d("leak-100-16", dataLeAk100);
		android.util.Log.d("leak-101-16", dataLeAk101);
		android.util.Log.d("leak-102-16", dataLeAk102);
		android.util.Log.d("leak-103-16", dataLeAk103);
		android.util.Log.d("leak-105-16", dataLeAk105);
		android.util.Log.d("leak-106-16", dataLeAk106);
		android.util.Log.d("leak-109-16", dataLeAk109);
		android.util.Log.d("leak-110-16", dataLeAk110);
		android.util.Log.d("leak-111-16", dataLeAk111);
		android.util.Log.d("leak-112-16", dataLeAk112);
		android.util.Log.d("leak-113-16", dataLeAk113);
		android.util.Log.d("leak-114-16", dataLeAk114);
		android.util.Log.d("leak-115-16", dataLeAk115);
		try {
            mContextMenuInfo = (AdapterView.AdapterContextMenuInfo) item
                    .getMenuInfo();
        } catch (ClassCastException e) {
            Log.e(TAG, "bad menuInfo", e);
            return false;
        }

        switch (item.getItemId()) {
            case MENU_ITEM_DELETE: {
                showDialog(DIALOG_DELETE);
                // mAdapter.getCursor().requery();
                return true;
            }
            case MENU_ITEM_SHARE:
                sendNoteByEmail(mContextMenuInfo.id);
                return true;
            case MENU_ITEM_ENCRYPT:
                encryptNote(mContextMenuInfo.id, CryptoIntents.ACTION_ENCRYPT);
                return true;
            case MENU_ITEM_UNENCRYPT:
                encryptNote(mContextMenuInfo.id, CryptoIntents.ACTION_DECRYPT);
                return true;
            case MENU_ITEM_EDIT_TAGS:
                editTags();

                return true;
            // case MENU_ITEM_SAVE:
            // saveToSdCard();
            // return true;
        }
        return false;
    }

    private void sendNoteByEmail(long id) {
        dataLeAk95 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-17", dataLeAk75);
		android.util.Log.d("leak-79-17", dataLeAk79);
		android.util.Log.d("leak-80-17", dataLeAk80);
		android.util.Log.d("leak-81-17", dataLeAk81);
		android.util.Log.d("leak-82-17", dataLeAk82);
		android.util.Log.d("leak-83-17", dataLeAk83);
		android.util.Log.d("leak-84-17", dataLeAk84);
		android.util.Log.d("leak-85-17", dataLeAk85);
		android.util.Log.d("leak-86-17", dataLeAk86);
		android.util.Log.d("leak-87-17", dataLeAk87);
		android.util.Log.d("leak-88-17", dataLeAk88);
		android.util.Log.d("leak-89-17", dataLeAk89);
		android.util.Log.d("leak-90-17", dataLeAk90);
		android.util.Log.d("leak-91-17", dataLeAk91);
		android.util.Log.d("leak-92-17", dataLeAk92);
		android.util.Log.d("leak-93-17", dataLeAk93);
		android.util.Log.d("leak-94-17", dataLeAk94);
		android.util.Log.d("leak-95-17", dataLeAk95);
		android.util.Log.d("leak-96-17", dataLeAk96);
		android.util.Log.d("leak-97-17", dataLeAk97);
		android.util.Log.d("leak-98-17", dataLeAk98);
		android.util.Log.d("leak-99-17", dataLeAk99);
		android.util.Log.d("leak-100-17", dataLeAk100);
		android.util.Log.d("leak-101-17", dataLeAk101);
		android.util.Log.d("leak-102-17", dataLeAk102);
		android.util.Log.d("leak-103-17", dataLeAk103);
		android.util.Log.d("leak-105-17", dataLeAk105);
		android.util.Log.d("leak-106-17", dataLeAk106);
		android.util.Log.d("leak-109-17", dataLeAk109);
		android.util.Log.d("leak-110-17", dataLeAk110);
		android.util.Log.d("leak-111-17", dataLeAk111);
		android.util.Log.d("leak-112-17", dataLeAk112);
		android.util.Log.d("leak-113-17", dataLeAk113);
		android.util.Log.d("leak-114-17", dataLeAk114);
		android.util.Log.d("leak-115-17", dataLeAk115);
		// Obtain Uri for the context menu
        Uri noteUri = ContentUris.withAppendedId(getIntent().getData(), id);
        // getContentResolver().(noteUri, null, null);

        Cursor c = getContentResolver().query(
                noteUri,
                new String[]{NotePad.Notes.TITLE, NotePad.Notes.NOTE}, null,
                null, PreferenceActivity.getSortOrderFromPrefs(this)
        );

        String title = "";
        String content = getString(R.string.empty_note);
        if (c != null) {
            c.moveToFirst();
            title = c.getString(0);
            content = c.getString(1);
        }

        if (DEBUG) {
            Log.i(TAG, "Title to send: " + title);
        }
        if (DEBUG) {
            Log.i(TAG, "Content to send: " + content);
        }
        SendNote.sendNote(this, title, content);
    }

    /**
     * Encrypt or unencrypt a note.
     *
     * @param id
     * @param action
     */
    private void encryptNote(long id, String action) {
        dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-18", dataLeAk75);
		android.util.Log.d("leak-79-18", dataLeAk79);
		android.util.Log.d("leak-80-18", dataLeAk80);
		android.util.Log.d("leak-81-18", dataLeAk81);
		android.util.Log.d("leak-82-18", dataLeAk82);
		android.util.Log.d("leak-83-18", dataLeAk83);
		android.util.Log.d("leak-84-18", dataLeAk84);
		android.util.Log.d("leak-85-18", dataLeAk85);
		android.util.Log.d("leak-86-18", dataLeAk86);
		android.util.Log.d("leak-87-18", dataLeAk87);
		android.util.Log.d("leak-88-18", dataLeAk88);
		android.util.Log.d("leak-89-18", dataLeAk89);
		android.util.Log.d("leak-90-18", dataLeAk90);
		android.util.Log.d("leak-91-18", dataLeAk91);
		android.util.Log.d("leak-92-18", dataLeAk92);
		android.util.Log.d("leak-93-18", dataLeAk93);
		android.util.Log.d("leak-94-18", dataLeAk94);
		android.util.Log.d("leak-95-18", dataLeAk95);
		android.util.Log.d("leak-96-18", dataLeAk96);
		android.util.Log.d("leak-97-18", dataLeAk97);
		android.util.Log.d("leak-98-18", dataLeAk98);
		android.util.Log.d("leak-99-18", dataLeAk99);
		android.util.Log.d("leak-100-18", dataLeAk100);
		android.util.Log.d("leak-101-18", dataLeAk101);
		android.util.Log.d("leak-102-18", dataLeAk102);
		android.util.Log.d("leak-103-18", dataLeAk103);
		android.util.Log.d("leak-105-18", dataLeAk105);
		android.util.Log.d("leak-106-18", dataLeAk106);
		android.util.Log.d("leak-109-18", dataLeAk109);
		android.util.Log.d("leak-110-18", dataLeAk110);
		android.util.Log.d("leak-111-18", dataLeAk111);
		android.util.Log.d("leak-112-18", dataLeAk112);
		android.util.Log.d("leak-113-18", dataLeAk113);
		android.util.Log.d("leak-114-18", dataLeAk114);
		android.util.Log.d("leak-115-18", dataLeAk115);
		// Obtain Uri for the context menu
        Uri noteUri = ContentUris.withAppendedId(getIntent().getData(), id);
        // getContentResolver().(noteUri, null, null);

        Cursor c = getContentResolver().query(
                noteUri,
                new String[]{NotePad.Notes.TITLE, NotePad.Notes.NOTE,
                        NotePad.Notes.TAGS, NotePad.Notes.ENCRYPTED}, null,
                null, PreferenceActivity.getSortOrderFromPrefs(this)
        );

        String title = "";
        String text = getString(R.string.empty_note);
        String tags = "";
        int encrypted = 0;
        if (c != null) {
            c.moveToFirst();
            title = c.getString(0);
            text = c.getString(1);
            tags = c.getString(2);
            encrypted = c.getInt(3);
        }

        if (action.equals(CryptoIntents.ACTION_ENCRYPT) && encrypted != 0) {
            Toast.makeText(this, R.string.already_encrypted, Toast.LENGTH_SHORT)
                    .show();
            return;
        }

        if (action.equals(CryptoIntents.ACTION_DECRYPT) && encrypted == 0) {
            Toast.makeText(this, R.string.not_encrypted, Toast.LENGTH_SHORT)
                    .show();
            return;
        }

        Intent i = new Intent(this, EncryptActivity.class);
        i.putExtra(PrivateNotePadIntents.EXTRA_ACTION, action);
        i.putExtra(
                CryptoIntents.EXTRA_TEXT_ARRAY,
                EncryptActivity.getCryptoStringArray(text, title, tags)
        );
        i.putExtra(PrivateNotePadIntents.EXTRA_URI, noteUri.toString());
        startActivity(i);
    }

    private void editTags() {
        dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-19", dataLeAk75);
		android.util.Log.d("leak-79-19", dataLeAk79);
		android.util.Log.d("leak-80-19", dataLeAk80);
		android.util.Log.d("leak-81-19", dataLeAk81);
		android.util.Log.d("leak-82-19", dataLeAk82);
		android.util.Log.d("leak-83-19", dataLeAk83);
		android.util.Log.d("leak-84-19", dataLeAk84);
		android.util.Log.d("leak-85-19", dataLeAk85);
		android.util.Log.d("leak-86-19", dataLeAk86);
		android.util.Log.d("leak-87-19", dataLeAk87);
		android.util.Log.d("leak-88-19", dataLeAk88);
		android.util.Log.d("leak-89-19", dataLeAk89);
		android.util.Log.d("leak-90-19", dataLeAk90);
		android.util.Log.d("leak-91-19", dataLeAk91);
		android.util.Log.d("leak-92-19", dataLeAk92);
		android.util.Log.d("leak-93-19", dataLeAk93);
		android.util.Log.d("leak-94-19", dataLeAk94);
		android.util.Log.d("leak-95-19", dataLeAk95);
		android.util.Log.d("leak-96-19", dataLeAk96);
		android.util.Log.d("leak-97-19", dataLeAk97);
		android.util.Log.d("leak-98-19", dataLeAk98);
		android.util.Log.d("leak-99-19", dataLeAk99);
		android.util.Log.d("leak-100-19", dataLeAk100);
		android.util.Log.d("leak-101-19", dataLeAk101);
		android.util.Log.d("leak-102-19", dataLeAk102);
		android.util.Log.d("leak-103-19", dataLeAk103);
		android.util.Log.d("leak-105-19", dataLeAk105);
		android.util.Log.d("leak-106-19", dataLeAk106);
		android.util.Log.d("leak-109-19", dataLeAk109);
		android.util.Log.d("leak-110-19", dataLeAk110);
		android.util.Log.d("leak-111-19", dataLeAk111);
		android.util.Log.d("leak-112-19", dataLeAk112);
		android.util.Log.d("leak-113-19", dataLeAk113);
		android.util.Log.d("leak-114-19", dataLeAk114);
		android.util.Log.d("leak-115-19", dataLeAk115);
		showDialog(DIALOG_TAGS);
    }

    private File getSdCardPath() {
        dataLeAk98 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-20", dataLeAk75);
		android.util.Log.d("leak-79-20", dataLeAk79);
		android.util.Log.d("leak-80-20", dataLeAk80);
		android.util.Log.d("leak-81-20", dataLeAk81);
		android.util.Log.d("leak-82-20", dataLeAk82);
		android.util.Log.d("leak-83-20", dataLeAk83);
		android.util.Log.d("leak-84-20", dataLeAk84);
		android.util.Log.d("leak-85-20", dataLeAk85);
		android.util.Log.d("leak-86-20", dataLeAk86);
		android.util.Log.d("leak-87-20", dataLeAk87);
		android.util.Log.d("leak-88-20", dataLeAk88);
		android.util.Log.d("leak-89-20", dataLeAk89);
		android.util.Log.d("leak-90-20", dataLeAk90);
		android.util.Log.d("leak-91-20", dataLeAk91);
		android.util.Log.d("leak-92-20", dataLeAk92);
		android.util.Log.d("leak-93-20", dataLeAk93);
		android.util.Log.d("leak-94-20", dataLeAk94);
		android.util.Log.d("leak-95-20", dataLeAk95);
		android.util.Log.d("leak-96-20", dataLeAk96);
		android.util.Log.d("leak-97-20", dataLeAk97);
		android.util.Log.d("leak-98-20", dataLeAk98);
		android.util.Log.d("leak-99-20", dataLeAk99);
		android.util.Log.d("leak-100-20", dataLeAk100);
		android.util.Log.d("leak-101-20", dataLeAk101);
		android.util.Log.d("leak-102-20", dataLeAk102);
		android.util.Log.d("leak-103-20", dataLeAk103);
		android.util.Log.d("leak-105-20", dataLeAk105);
		android.util.Log.d("leak-106-20", dataLeAk106);
		android.util.Log.d("leak-109-20", dataLeAk109);
		android.util.Log.d("leak-110-20", dataLeAk110);
		android.util.Log.d("leak-111-20", dataLeAk111);
		android.util.Log.d("leak-112-20", dataLeAk112);
		android.util.Log.d("leak-113-20", dataLeAk113);
		android.util.Log.d("leak-114-20", dataLeAk114);
		android.util.Log.d("leak-115-20", dataLeAk115);
		return android.os.Environment.getExternalStorageDirectory();
    }

    private void showNotesListSettings() {
        dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-21", dataLeAk75);
		android.util.Log.d("leak-79-21", dataLeAk79);
		android.util.Log.d("leak-80-21", dataLeAk80);
		android.util.Log.d("leak-81-21", dataLeAk81);
		android.util.Log.d("leak-82-21", dataLeAk82);
		android.util.Log.d("leak-83-21", dataLeAk83);
		android.util.Log.d("leak-84-21", dataLeAk84);
		android.util.Log.d("leak-85-21", dataLeAk85);
		android.util.Log.d("leak-86-21", dataLeAk86);
		android.util.Log.d("leak-87-21", dataLeAk87);
		android.util.Log.d("leak-88-21", dataLeAk88);
		android.util.Log.d("leak-89-21", dataLeAk89);
		android.util.Log.d("leak-90-21", dataLeAk90);
		android.util.Log.d("leak-91-21", dataLeAk91);
		android.util.Log.d("leak-92-21", dataLeAk92);
		android.util.Log.d("leak-93-21", dataLeAk93);
		android.util.Log.d("leak-94-21", dataLeAk94);
		android.util.Log.d("leak-95-21", dataLeAk95);
		android.util.Log.d("leak-96-21", dataLeAk96);
		android.util.Log.d("leak-97-21", dataLeAk97);
		android.util.Log.d("leak-98-21", dataLeAk98);
		android.util.Log.d("leak-99-21", dataLeAk99);
		android.util.Log.d("leak-100-21", dataLeAk100);
		android.util.Log.d("leak-101-21", dataLeAk101);
		android.util.Log.d("leak-102-21", dataLeAk102);
		android.util.Log.d("leak-103-21", dataLeAk103);
		android.util.Log.d("leak-105-21", dataLeAk105);
		android.util.Log.d("leak-106-21", dataLeAk106);
		android.util.Log.d("leak-109-21", dataLeAk109);
		android.util.Log.d("leak-110-21", dataLeAk110);
		android.util.Log.d("leak-111-21", dataLeAk111);
		android.util.Log.d("leak-112-21", dataLeAk112);
		android.util.Log.d("leak-113-21", dataLeAk113);
		android.util.Log.d("leak-114-21", dataLeAk114);
		android.util.Log.d("leak-115-21", dataLeAk115);
		startActivity(new Intent(this, PreferenceActivity.class));
    }

    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {
							dataLeAk100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-75-22", dataLeAk75);
							android.util.Log.d("leak-79-22", dataLeAk79);
							android.util.Log.d("leak-80-22", dataLeAk80);
							android.util.Log.d("leak-81-22", dataLeAk81);
							android.util.Log.d("leak-82-22", dataLeAk82);
							android.util.Log.d("leak-83-22", dataLeAk83);
							android.util.Log.d("leak-84-22", dataLeAk84);
							android.util.Log.d("leak-85-22", dataLeAk85);
							android.util.Log.d("leak-86-22", dataLeAk86);
							android.util.Log.d("leak-87-22", dataLeAk87);
							android.util.Log.d("leak-88-22", dataLeAk88);
							android.util.Log.d("leak-89-22", dataLeAk89);
							android.util.Log.d("leak-90-22", dataLeAk90);
							android.util.Log.d("leak-91-22", dataLeAk91);
							android.util.Log.d("leak-92-22", dataLeAk92);
							android.util.Log.d("leak-93-22", dataLeAk93);
							android.util.Log.d("leak-94-22", dataLeAk94);
							android.util.Log.d("leak-95-22", dataLeAk95);
							android.util.Log.d("leak-96-22", dataLeAk96);
							android.util.Log.d("leak-97-22", dataLeAk97);
							android.util.Log.d("leak-98-22", dataLeAk98);
							android.util.Log.d("leak-99-22", dataLeAk99);
							android.util.Log.d("leak-100-22", dataLeAk100);
							android.util.Log.d("leak-101-22", dataLeAk101);
							android.util.Log.d("leak-102-22", dataLeAk102);
							android.util.Log.d("leak-103-22", dataLeAk103);
							android.util.Log.d("leak-105-22", dataLeAk105);
							android.util.Log.d("leak-106-22", dataLeAk106);
							android.util.Log.d("leak-109-22", dataLeAk109);
							android.util.Log.d("leak-110-22", dataLeAk110);
							android.util.Log.d("leak-111-22", dataLeAk111);
							android.util.Log.d("leak-112-22", dataLeAk112);
							android.util.Log.d("leak-113-22", dataLeAk113);
							android.util.Log.d("leak-114-22", dataLeAk114);
							android.util.Log.d("leak-115-22", dataLeAk115);
    }

    public void onScrollStateChanged(AbsListView view, int scrollState) {
        dataLeAk101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-23", dataLeAk75);
		android.util.Log.d("leak-79-23", dataLeAk79);
		android.util.Log.d("leak-80-23", dataLeAk80);
		android.util.Log.d("leak-81-23", dataLeAk81);
		android.util.Log.d("leak-82-23", dataLeAk82);
		android.util.Log.d("leak-83-23", dataLeAk83);
		android.util.Log.d("leak-84-23", dataLeAk84);
		android.util.Log.d("leak-85-23", dataLeAk85);
		android.util.Log.d("leak-86-23", dataLeAk86);
		android.util.Log.d("leak-87-23", dataLeAk87);
		android.util.Log.d("leak-88-23", dataLeAk88);
		android.util.Log.d("leak-89-23", dataLeAk89);
		android.util.Log.d("leak-90-23", dataLeAk90);
		android.util.Log.d("leak-91-23", dataLeAk91);
		android.util.Log.d("leak-92-23", dataLeAk92);
		android.util.Log.d("leak-93-23", dataLeAk93);
		android.util.Log.d("leak-94-23", dataLeAk94);
		android.util.Log.d("leak-95-23", dataLeAk95);
		android.util.Log.d("leak-96-23", dataLeAk96);
		android.util.Log.d("leak-97-23", dataLeAk97);
		android.util.Log.d("leak-98-23", dataLeAk98);
		android.util.Log.d("leak-99-23", dataLeAk99);
		android.util.Log.d("leak-100-23", dataLeAk100);
		android.util.Log.d("leak-101-23", dataLeAk101);
		android.util.Log.d("leak-102-23", dataLeAk102);
		android.util.Log.d("leak-103-23", dataLeAk103);
		android.util.Log.d("leak-105-23", dataLeAk105);
		android.util.Log.d("leak-106-23", dataLeAk106);
		android.util.Log.d("leak-109-23", dataLeAk109);
		android.util.Log.d("leak-110-23", dataLeAk110);
		android.util.Log.d("leak-111-23", dataLeAk111);
		android.util.Log.d("leak-112-23", dataLeAk112);
		android.util.Log.d("leak-113-23", dataLeAk113);
		android.util.Log.d("leak-114-23", dataLeAk114);
		android.util.Log.d("leak-115-23", dataLeAk115);
		switch (scrollState) {
            case OnScrollListener.SCROLL_STATE_IDLE:
                Log.i(TAG, "idle");
                mAdapter.mBusy = false;

                if (!NotesListCursor.mEncryptedStringList.isEmpty()) {
                    String encryptedString = NotesListCursor.mEncryptedStringList
                            .remove(0);
                    Log.i(TAG, "Decrypt idle: " + encryptedString);
                    decryptTitle(encryptedString);
                }
			/*
			 * int first = view.getFirstVisiblePosition(); int count =
			 * view.getChildCount(); for (int i=0; i<count; i++) {
			 * NotesListItemView t = (NotesListItemView)view.getChildAt(i);
			 * String encryptedTitle = (String) t.getTag(); if (encryptedTitle
			 * != null) { // Retrieve decrypted title
			 * decryptTitle(encryptedTitle); t.setTag(null);
			 *
			 * // decrypt one item at a time. break; } }
			 */

                break;
            case OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:
                mAdapter.mBusy = true;
                break;
            case OnScrollListener.SCROLL_STATE_FLING:
                mAdapter.mBusy = true;
                break;
        }
    }

    public void decryptDelayed() {
        dataLeAk102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-24", dataLeAk75);
		android.util.Log.d("leak-79-24", dataLeAk79);
		android.util.Log.d("leak-80-24", dataLeAk80);
		android.util.Log.d("leak-81-24", dataLeAk81);
		android.util.Log.d("leak-82-24", dataLeAk82);
		android.util.Log.d("leak-83-24", dataLeAk83);
		android.util.Log.d("leak-84-24", dataLeAk84);
		android.util.Log.d("leak-85-24", dataLeAk85);
		android.util.Log.d("leak-86-24", dataLeAk86);
		android.util.Log.d("leak-87-24", dataLeAk87);
		android.util.Log.d("leak-88-24", dataLeAk88);
		android.util.Log.d("leak-89-24", dataLeAk89);
		android.util.Log.d("leak-90-24", dataLeAk90);
		android.util.Log.d("leak-91-24", dataLeAk91);
		android.util.Log.d("leak-92-24", dataLeAk92);
		android.util.Log.d("leak-93-24", dataLeAk93);
		android.util.Log.d("leak-94-24", dataLeAk94);
		android.util.Log.d("leak-95-24", dataLeAk95);
		android.util.Log.d("leak-96-24", dataLeAk96);
		android.util.Log.d("leak-97-24", dataLeAk97);
		android.util.Log.d("leak-98-24", dataLeAk98);
		android.util.Log.d("leak-99-24", dataLeAk99);
		android.util.Log.d("leak-100-24", dataLeAk100);
		android.util.Log.d("leak-101-24", dataLeAk101);
		android.util.Log.d("leak-102-24", dataLeAk102);
		android.util.Log.d("leak-103-24", dataLeAk103);
		android.util.Log.d("leak-105-24", dataLeAk105);
		android.util.Log.d("leak-106-24", dataLeAk106);
		android.util.Log.d("leak-109-24", dataLeAk109);
		android.util.Log.d("leak-110-24", dataLeAk110);
		android.util.Log.d("leak-111-24", dataLeAk111);
		android.util.Log.d("leak-112-24", dataLeAk112);
		android.util.Log.d("leak-113-24", dataLeAk113);
		android.util.Log.d("leak-114-24", dataLeAk114);
		android.util.Log.d("leak-115-24", dataLeAk115);
		// Poll the next string that has not been decrypted yet.
        String encryptedString = NotesListCursor.getNextEncryptedString();
        if (encryptedString != null) {
            setProgressBarIndeterminateVisibility(true);
            decryptDelayed(encryptedString, DECRYPT_DELAY);
        } else if (!mDecryptionFailed && !mDecryptionSucceeded) {
            // If neither failed nor succeeded yet, we send a test intent.
            // This is to ensure that the service is still running
            // even if we may serve all decrypted strings from the cache.
            NotesListCursor nlc = (NotesListCursor) mAdapter.getCursor();
            if (nlc.mContainsEncryptedStrings) {
                // Of course only if there is at least one encrypted string.
                setProgressBarIndeterminateVisibility(true);
                decryptDelayed(null, 0);
            }
        } else {
            // Done with decryption
            setProgressBarIndeterminateVisibility(false);
        }
    }

    public void decryptDelayed(final String encryptedTitle, long delayMillis) {
        dataLeAk103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-25", dataLeAk75);
		android.util.Log.d("leak-79-25", dataLeAk79);
		android.util.Log.d("leak-80-25", dataLeAk80);
		android.util.Log.d("leak-81-25", dataLeAk81);
		android.util.Log.d("leak-82-25", dataLeAk82);
		android.util.Log.d("leak-83-25", dataLeAk83);
		android.util.Log.d("leak-84-25", dataLeAk84);
		android.util.Log.d("leak-85-25", dataLeAk85);
		android.util.Log.d("leak-86-25", dataLeAk86);
		android.util.Log.d("leak-87-25", dataLeAk87);
		android.util.Log.d("leak-88-25", dataLeAk88);
		android.util.Log.d("leak-89-25", dataLeAk89);
		android.util.Log.d("leak-90-25", dataLeAk90);
		android.util.Log.d("leak-91-25", dataLeAk91);
		android.util.Log.d("leak-92-25", dataLeAk92);
		android.util.Log.d("leak-93-25", dataLeAk93);
		android.util.Log.d("leak-94-25", dataLeAk94);
		android.util.Log.d("leak-95-25", dataLeAk95);
		android.util.Log.d("leak-96-25", dataLeAk96);
		android.util.Log.d("leak-97-25", dataLeAk97);
		android.util.Log.d("leak-98-25", dataLeAk98);
		android.util.Log.d("leak-99-25", dataLeAk99);
		android.util.Log.d("leak-100-25", dataLeAk100);
		android.util.Log.d("leak-101-25", dataLeAk101);
		android.util.Log.d("leak-102-25", dataLeAk102);
		android.util.Log.d("leak-103-25", dataLeAk103);
		android.util.Log.d("leak-105-25", dataLeAk105);
		android.util.Log.d("leak-106-25", dataLeAk106);
		android.util.Log.d("leak-109-25", dataLeAk109);
		android.util.Log.d("leak-110-25", dataLeAk110);
		android.util.Log.d("leak-111-25", dataLeAk111);
		android.util.Log.d("leak-112-25", dataLeAk112);
		android.util.Log.d("leak-113-25", dataLeAk113);
		android.util.Log.d("leak-114-25", dataLeAk114);
		android.util.Log.d("leak-115-25", dataLeAk115);
		mHandler.postDelayed(
                new Runnable() {

                    String dataLeAk104 = "";

					public void run() {
                        dataLeAk104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-121-0", dataLeAk121);
						android.util.Log.d("leak-104-0", dataLeAk104);
						decryptTitle(encryptedTitle);
                    }

                }, delayMillis
        );
    }

    public void decryptTitle(String encryptedTitle) {

        dataLeAk105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-26", dataLeAk75);
		android.util.Log.d("leak-79-26", dataLeAk79);
		android.util.Log.d("leak-80-26", dataLeAk80);
		android.util.Log.d("leak-81-26", dataLeAk81);
		android.util.Log.d("leak-82-26", dataLeAk82);
		android.util.Log.d("leak-83-26", dataLeAk83);
		android.util.Log.d("leak-84-26", dataLeAk84);
		android.util.Log.d("leak-85-26", dataLeAk85);
		android.util.Log.d("leak-86-26", dataLeAk86);
		android.util.Log.d("leak-87-26", dataLeAk87);
		android.util.Log.d("leak-88-26", dataLeAk88);
		android.util.Log.d("leak-89-26", dataLeAk89);
		android.util.Log.d("leak-90-26", dataLeAk90);
		android.util.Log.d("leak-91-26", dataLeAk91);
		android.util.Log.d("leak-92-26", dataLeAk92);
		android.util.Log.d("leak-93-26", dataLeAk93);
		android.util.Log.d("leak-94-26", dataLeAk94);
		android.util.Log.d("leak-95-26", dataLeAk95);
		android.util.Log.d("leak-96-26", dataLeAk96);
		android.util.Log.d("leak-97-26", dataLeAk97);
		android.util.Log.d("leak-98-26", dataLeAk98);
		android.util.Log.d("leak-99-26", dataLeAk99);
		android.util.Log.d("leak-100-26", dataLeAk100);
		android.util.Log.d("leak-101-26", dataLeAk101);
		android.util.Log.d("leak-102-26", dataLeAk102);
		android.util.Log.d("leak-103-26", dataLeAk103);
		android.util.Log.d("leak-105-26", dataLeAk105);
		android.util.Log.d("leak-106-26", dataLeAk106);
		android.util.Log.d("leak-109-26", dataLeAk109);
		android.util.Log.d("leak-110-26", dataLeAk110);
		android.util.Log.d("leak-111-26", dataLeAk111);
		android.util.Log.d("leak-112-26", dataLeAk112);
		android.util.Log.d("leak-113-26", dataLeAk113);
		android.util.Log.d("leak-114-26", dataLeAk114);
		android.util.Log.d("leak-115-26", dataLeAk115);
		Intent intent = new Intent();
        intent.setAction(CryptoIntents.ACTION_DECRYPT);
        if (encryptedTitle != null) {
            intent.putExtra(CryptoIntents.EXTRA_TEXT, encryptedTitle);
            intent.putExtra(
                    PrivateNotePadIntents.EXTRA_ENCRYPTED_TEXT,
                    encryptedTitle
            );
        }

        intent.putExtra(CryptoIntents.EXTRA_PROMPT, false);

        try {
            if (checkCallingOrSelfPermission(CryptoIntents.PERMISSION_SAFE_ACCESS_INTENTS) == PackageManager.PERMISSION_GRANTED) {
                startActivityForResult(intent, REQUEST_CODE_DECRYPT_TITLE);
            } else {
                mDecryptionFailed = true;
                showDialog(DIALOG_PERMISSION_FAILURE);
            }
        } catch (ActivityNotFoundException e) {
            mDecryptionFailed = true;
			/*
			 * Toast.makeText(this, R.string.decryption_failed,
			 * Toast.LENGTH_SHORT).show();
			 */
            Log.e(TAG, "failed to invoke encrypt");
        }
    }

    @Override
    protected Dialog onCreateDialog(int id) {

        dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-27", dataLeAk75);
		android.util.Log.d("leak-79-27", dataLeAk79);
		android.util.Log.d("leak-80-27", dataLeAk80);
		android.util.Log.d("leak-81-27", dataLeAk81);
		android.util.Log.d("leak-82-27", dataLeAk82);
		android.util.Log.d("leak-83-27", dataLeAk83);
		android.util.Log.d("leak-84-27", dataLeAk84);
		android.util.Log.d("leak-85-27", dataLeAk85);
		android.util.Log.d("leak-86-27", dataLeAk86);
		android.util.Log.d("leak-87-27", dataLeAk87);
		android.util.Log.d("leak-88-27", dataLeAk88);
		android.util.Log.d("leak-89-27", dataLeAk89);
		android.util.Log.d("leak-90-27", dataLeAk90);
		android.util.Log.d("leak-91-27", dataLeAk91);
		android.util.Log.d("leak-92-27", dataLeAk92);
		android.util.Log.d("leak-93-27", dataLeAk93);
		android.util.Log.d("leak-94-27", dataLeAk94);
		android.util.Log.d("leak-95-27", dataLeAk95);
		android.util.Log.d("leak-96-27", dataLeAk96);
		android.util.Log.d("leak-97-27", dataLeAk97);
		android.util.Log.d("leak-98-27", dataLeAk98);
		android.util.Log.d("leak-99-27", dataLeAk99);
		android.util.Log.d("leak-100-27", dataLeAk100);
		android.util.Log.d("leak-101-27", dataLeAk101);
		android.util.Log.d("leak-102-27", dataLeAk102);
		android.util.Log.d("leak-103-27", dataLeAk103);
		android.util.Log.d("leak-105-27", dataLeAk105);
		android.util.Log.d("leak-106-27", dataLeAk106);
		android.util.Log.d("leak-109-27", dataLeAk109);
		android.util.Log.d("leak-110-27", dataLeAk110);
		android.util.Log.d("leak-111-27", dataLeAk111);
		android.util.Log.d("leak-112-27", dataLeAk112);
		android.util.Log.d("leak-113-27", dataLeAk113);
		android.util.Log.d("leak-114-27", dataLeAk114);
		android.util.Log.d("leak-115-27", dataLeAk115);
		switch (id) {
            case DIALOG_TAGS:
                TagsDialog td = new TagsDialog(this);
                td.setOnDismissListener(this);
                return td;
            // return new TagsDialog(this);
            case DIALOG_GET_FROM_MARKET:
                return new DownloadOIAppDialog(this, DownloadOIAppDialog.OI_SAFE);
            case DIALOG_DELETE:
                return new DeleteConfirmationDialog(
                        this,
                        new DialogInterface.OnClickListener() {

                            String dataLeAk107 = "";

							@Override
                            public void onClick(DialogInterface dialog, int which) {
                                dataLeAk107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-122-0", dataLeAk122);
								android.util.Log.d("leak-107-0", dataLeAk107);
								Uri noteUri = ContentUris.withAppendedId(
                                        getIntent().getData(), mContextMenuInfo.id
                                );
                                getContentResolver().delete(noteUri, null, null);
                                updateTagList();
                            }
                        }
                ).create();
            case DIALOG_PERMISSION_FAILURE:
                return new AlertDialog.Builder(this)
                        .setMessage(R.string.decryption_failed_due_to_permissions)
                        .setPositiveButton(
                                R.string.contact_support, new DialogInterface.OnClickListener() {
                                    String dataLeAk108 = "";

									@Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dataLeAk108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										android.util.Log.d("leak-123-0", dataLeAk123);
										android.util.Log.d("leak-108-0", dataLeAk108);
										new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:info@openintents.biz"));
                                        dialog.dismiss();
                                    }
                                }
                        )
                        .create();
        }
        return super.onCreateDialog(id);
    }

    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {
        dataLeAk109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-28", dataLeAk75);
		android.util.Log.d("leak-79-28", dataLeAk79);
		android.util.Log.d("leak-80-28", dataLeAk80);
		android.util.Log.d("leak-81-28", dataLeAk81);
		android.util.Log.d("leak-82-28", dataLeAk82);
		android.util.Log.d("leak-83-28", dataLeAk83);
		android.util.Log.d("leak-84-28", dataLeAk84);
		android.util.Log.d("leak-85-28", dataLeAk85);
		android.util.Log.d("leak-86-28", dataLeAk86);
		android.util.Log.d("leak-87-28", dataLeAk87);
		android.util.Log.d("leak-88-28", dataLeAk88);
		android.util.Log.d("leak-89-28", dataLeAk89);
		android.util.Log.d("leak-90-28", dataLeAk90);
		android.util.Log.d("leak-91-28", dataLeAk91);
		android.util.Log.d("leak-92-28", dataLeAk92);
		android.util.Log.d("leak-93-28", dataLeAk93);
		android.util.Log.d("leak-94-28", dataLeAk94);
		android.util.Log.d("leak-95-28", dataLeAk95);
		android.util.Log.d("leak-96-28", dataLeAk96);
		android.util.Log.d("leak-97-28", dataLeAk97);
		android.util.Log.d("leak-98-28", dataLeAk98);
		android.util.Log.d("leak-99-28", dataLeAk99);
		android.util.Log.d("leak-100-28", dataLeAk100);
		android.util.Log.d("leak-101-28", dataLeAk101);
		android.util.Log.d("leak-102-28", dataLeAk102);
		android.util.Log.d("leak-103-28", dataLeAk103);
		android.util.Log.d("leak-105-28", dataLeAk105);
		android.util.Log.d("leak-106-28", dataLeAk106);
		android.util.Log.d("leak-109-28", dataLeAk109);
		android.util.Log.d("leak-110-28", dataLeAk110);
		android.util.Log.d("leak-111-28", dataLeAk111);
		android.util.Log.d("leak-112-28", dataLeAk112);
		android.util.Log.d("leak-113-28", dataLeAk113);
		android.util.Log.d("leak-114-28", dataLeAk114);
		android.util.Log.d("leak-115-28", dataLeAk115);
		if (DEBUG) {
            Log.d(TAG, "onPrepareDialog()");
        }

        switch (id) {
            case DIALOG_TAGS:
                TagsDialog d = (TagsDialog) dialog;
                Uri uri = ContentUris.withAppendedId(
                        getIntent().getData(),
                        mContextMenuInfo.id
                );

                Cursor c = mAdapter.getCursor();
                c.moveToPosition(mContextMenuInfo.position);
                String tags = c.getString(NotesListCursor.COLUMN_INDEX_TAGS);
                long encrypted = c.getLong(NotesListCursor.COLUMN_INDEX_ENCRYPTED);

                d.setUri(uri);
                d.setTags(tags);
                d.setEncrypted(encrypted);

                String[] taglist = getTaglist(c);
                d.setTagList(taglist);

                break;
            case DIALOG_GET_FROM_MARKET:
                DownloadOIAppDialog.onPrepareDialog(this, dialog);
                break;
        }
    }

    public void onDismiss(DialogInterface dialog) {
        dataLeAk110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-29", dataLeAk75);
		android.util.Log.d("leak-79-29", dataLeAk79);
		android.util.Log.d("leak-80-29", dataLeAk80);
		android.util.Log.d("leak-81-29", dataLeAk81);
		android.util.Log.d("leak-82-29", dataLeAk82);
		android.util.Log.d("leak-83-29", dataLeAk83);
		android.util.Log.d("leak-84-29", dataLeAk84);
		android.util.Log.d("leak-85-29", dataLeAk85);
		android.util.Log.d("leak-86-29", dataLeAk86);
		android.util.Log.d("leak-87-29", dataLeAk87);
		android.util.Log.d("leak-88-29", dataLeAk88);
		android.util.Log.d("leak-89-29", dataLeAk89);
		android.util.Log.d("leak-90-29", dataLeAk90);
		android.util.Log.d("leak-91-29", dataLeAk91);
		android.util.Log.d("leak-92-29", dataLeAk92);
		android.util.Log.d("leak-93-29", dataLeAk93);
		android.util.Log.d("leak-94-29", dataLeAk94);
		android.util.Log.d("leak-95-29", dataLeAk95);
		android.util.Log.d("leak-96-29", dataLeAk96);
		android.util.Log.d("leak-97-29", dataLeAk97);
		android.util.Log.d("leak-98-29", dataLeAk98);
		android.util.Log.d("leak-99-29", dataLeAk99);
		android.util.Log.d("leak-100-29", dataLeAk100);
		android.util.Log.d("leak-101-29", dataLeAk101);
		android.util.Log.d("leak-102-29", dataLeAk102);
		android.util.Log.d("leak-103-29", dataLeAk103);
		android.util.Log.d("leak-105-29", dataLeAk105);
		android.util.Log.d("leak-106-29", dataLeAk106);
		android.util.Log.d("leak-109-29", dataLeAk109);
		android.util.Log.d("leak-110-29", dataLeAk110);
		android.util.Log.d("leak-111-29", dataLeAk111);
		android.util.Log.d("leak-112-29", dataLeAk112);
		android.util.Log.d("leak-113-29", dataLeAk113);
		android.util.Log.d("leak-114-29", dataLeAk114);
		android.util.Log.d("leak-115-29", dataLeAk115);
		if (dialog instanceof TagsDialog) {
            updateTagList();
        }
    }

    /**
     * Create list of tags.
     * <p/>
     * Tags for notes can be comma-separated. Here we create a list of the
     * unique tags.
     *
     * @param c
     * @return
     */
    String[] getTaglist(Cursor c) {
        dataLeAk111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-30", dataLeAk75);
		android.util.Log.d("leak-79-30", dataLeAk79);
		android.util.Log.d("leak-80-30", dataLeAk80);
		android.util.Log.d("leak-81-30", dataLeAk81);
		android.util.Log.d("leak-82-30", dataLeAk82);
		android.util.Log.d("leak-83-30", dataLeAk83);
		android.util.Log.d("leak-84-30", dataLeAk84);
		android.util.Log.d("leak-85-30", dataLeAk85);
		android.util.Log.d("leak-86-30", dataLeAk86);
		android.util.Log.d("leak-87-30", dataLeAk87);
		android.util.Log.d("leak-88-30", dataLeAk88);
		android.util.Log.d("leak-89-30", dataLeAk89);
		android.util.Log.d("leak-90-30", dataLeAk90);
		android.util.Log.d("leak-91-30", dataLeAk91);
		android.util.Log.d("leak-92-30", dataLeAk92);
		android.util.Log.d("leak-93-30", dataLeAk93);
		android.util.Log.d("leak-94-30", dataLeAk94);
		android.util.Log.d("leak-95-30", dataLeAk95);
		android.util.Log.d("leak-96-30", dataLeAk96);
		android.util.Log.d("leak-97-30", dataLeAk97);
		android.util.Log.d("leak-98-30", dataLeAk98);
		android.util.Log.d("leak-99-30", dataLeAk99);
		android.util.Log.d("leak-100-30", dataLeAk100);
		android.util.Log.d("leak-101-30", dataLeAk101);
		android.util.Log.d("leak-102-30", dataLeAk102);
		android.util.Log.d("leak-103-30", dataLeAk103);
		android.util.Log.d("leak-105-30", dataLeAk105);
		android.util.Log.d("leak-106-30", dataLeAk106);
		android.util.Log.d("leak-109-30", dataLeAk109);
		android.util.Log.d("leak-110-30", dataLeAk110);
		android.util.Log.d("leak-111-30", dataLeAk111);
		android.util.Log.d("leak-112-30", dataLeAk112);
		android.util.Log.d("leak-113-30", dataLeAk113);
		android.util.Log.d("leak-114-30", dataLeAk114);
		android.util.Log.d("leak-115-30", dataLeAk115);
		// Create a set of all tags (every tag should only appear once).
        HashSet<String> tagset = new HashSet<String>();
        c.moveToPosition(-1);
        while (c.moveToNext()) {
            String tags = c.getString(NotesListCursor.COLUMN_INDEX_TAGS);
            if (tags != null) {
                // Split several tags in a line, separated by comma
                String[] smalltaglist = tags.split(",");
                for (String tag : smalltaglist) {
                    if (!tag.equals("")) {
                        tagset.add(tag.trim());
                    }
                }
            }
        }

        // Sort the list
        // 1. Convert HashSet to String list.
        ArrayList<String> list = new ArrayList<String>();
        list.addAll(tagset);
        // 2. Sort the String list
        Collections.sort(list);
        // 3. Convert it to String array
        return list.toArray(new String[0]);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        dataLeAk112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-31", dataLeAk75);
		android.util.Log.d("leak-79-31", dataLeAk79);
		android.util.Log.d("leak-80-31", dataLeAk80);
		android.util.Log.d("leak-81-31", dataLeAk81);
		android.util.Log.d("leak-82-31", dataLeAk82);
		android.util.Log.d("leak-83-31", dataLeAk83);
		android.util.Log.d("leak-84-31", dataLeAk84);
		android.util.Log.d("leak-85-31", dataLeAk85);
		android.util.Log.d("leak-86-31", dataLeAk86);
		android.util.Log.d("leak-87-31", dataLeAk87);
		android.util.Log.d("leak-88-31", dataLeAk88);
		android.util.Log.d("leak-89-31", dataLeAk89);
		android.util.Log.d("leak-90-31", dataLeAk90);
		android.util.Log.d("leak-91-31", dataLeAk91);
		android.util.Log.d("leak-92-31", dataLeAk92);
		android.util.Log.d("leak-93-31", dataLeAk93);
		android.util.Log.d("leak-94-31", dataLeAk94);
		android.util.Log.d("leak-95-31", dataLeAk95);
		android.util.Log.d("leak-96-31", dataLeAk96);
		android.util.Log.d("leak-97-31", dataLeAk97);
		android.util.Log.d("leak-98-31", dataLeAk98);
		android.util.Log.d("leak-99-31", dataLeAk99);
		android.util.Log.d("leak-100-31", dataLeAk100);
		android.util.Log.d("leak-101-31", dataLeAk101);
		android.util.Log.d("leak-102-31", dataLeAk102);
		android.util.Log.d("leak-103-31", dataLeAk103);
		android.util.Log.d("leak-105-31", dataLeAk105);
		android.util.Log.d("leak-106-31", dataLeAk106);
		android.util.Log.d("leak-109-31", dataLeAk109);
		android.util.Log.d("leak-110-31", dataLeAk110);
		android.util.Log.d("leak-111-31", dataLeAk111);
		android.util.Log.d("leak-112-31", dataLeAk112);
		android.util.Log.d("leak-113-31", dataLeAk113);
		android.util.Log.d("leak-114-31", dataLeAk114);
		android.util.Log.d("leak-115-31", dataLeAk115);
		// First see if note is encrypted
        Cursor c = mAdapter.getCursor();
        c.moveToPosition(position);

        long encrypted = c.getLong(NotesListCursor.COLUMN_INDEX_ENCRYPTED);

        String encryptedTitle = c
                .getString(NotesListCursor.COLUMN_INDEX_TITLE_ENCRYPTED);
        // are we in decrypted mode?
        // Log.i(TAG, "Encrypted title: " + encryptedTitle);

        String title = c.getString(NotesListCursor.COLUMN_INDEX_TITLE);
        // Log.i(TAG, "title: " + title);

        if (encrypted != 0 && !TextUtils.isEmpty(encryptedTitle)) {
            // Try to decrypt first
            // Log.i(TAG, "Decrypt first");

            Intent intent = new Intent();
            intent.setAction(CryptoIntents.ACTION_DECRYPT);
            intent.putExtra(CryptoIntents.EXTRA_TEXT, encryptedTitle);
            intent.putExtra(
                    PrivateNotePadIntents.EXTRA_ENCRYPTED_TEXT,
                    encryptedTitle
            );

            intent.putExtra(CryptoIntents.EXTRA_PROMPT, true);

            try {
                if (checkCallingOrSelfPermission(CryptoIntents.PERMISSION_SAFE_ACCESS_INTENTS) == PackageManager.PERMISSION_GRANTED) {
                    startActivityForResult(intent, REQUEST_CODE_DECRYPT_TITLE);
                } else {
                    mDecryptionFailed = true;
                    showDialog(DIALOG_PERMISSION_FAILURE);
                    Log.e(TAG, "failed to invoke decrypt due to permissions");
                }
            } catch (ActivityNotFoundException e) {
                mDecryptionFailed = true;

					/*
					 * Toast.makeText(this, R.string.decryption_failed,
					 * Toast.LENGTH_SHORT).show();
					 */
                showDialog(DIALOG_GET_FROM_MARKET);
                Log.e(TAG, "failed to invoke decrypt");
            }
            return;
        }

        Uri uri = ContentUris.withAppendedId(getIntent().getData(), id);

        String action = getIntent().getAction();
        if (Intent.ACTION_PICK.equals(action)
                || Intent.ACTION_GET_CONTENT.equals(action)) {
            // The caller is waiting for us to return a note selected by
            // the user. The have clicked on one, so return it now.
            setResult(RESULT_OK, new Intent().setData(uri));
            finish();
        } else if (Intent.ACTION_CREATE_SHORTCUT.equals(action)) {
            Intent data = new Intent(Intent.ACTION_VIEW);
            data.setData(uri);

            String useTitle = title;
            if (encrypted != 0) {
                // Small security risk: The title is shown.
                // But ok, if someone wants to set a shortcut, they can choose
                // a good title.
                useTitle = encryptedTitle;
            }

            Intent shortcut = new Intent(Intent.ACTION_CREATE_SHORTCUT);
            shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME, title);
            shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, data);
            Intent.ShortcutIconResource sir = Intent.ShortcutIconResource
                    .fromContext(this, R.drawable.ic_launcher_notepad);
            shortcut.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, sir);

            setResult(RESULT_OK, shortcut);
            finish();
        } else {
            // Launch activity to view/edit the currently selected item
            startActivity(new Intent(Intent.ACTION_EDIT, uri));
        }
    }

    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent intent) {
        dataLeAk113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-32", dataLeAk75);
		android.util.Log.d("leak-79-32", dataLeAk79);
		android.util.Log.d("leak-80-32", dataLeAk80);
		android.util.Log.d("leak-81-32", dataLeAk81);
		android.util.Log.d("leak-82-32", dataLeAk82);
		android.util.Log.d("leak-83-32", dataLeAk83);
		android.util.Log.d("leak-84-32", dataLeAk84);
		android.util.Log.d("leak-85-32", dataLeAk85);
		android.util.Log.d("leak-86-32", dataLeAk86);
		android.util.Log.d("leak-87-32", dataLeAk87);
		android.util.Log.d("leak-88-32", dataLeAk88);
		android.util.Log.d("leak-89-32", dataLeAk89);
		android.util.Log.d("leak-90-32", dataLeAk90);
		android.util.Log.d("leak-91-32", dataLeAk91);
		android.util.Log.d("leak-92-32", dataLeAk92);
		android.util.Log.d("leak-93-32", dataLeAk93);
		android.util.Log.d("leak-94-32", dataLeAk94);
		android.util.Log.d("leak-95-32", dataLeAk95);
		android.util.Log.d("leak-96-32", dataLeAk96);
		android.util.Log.d("leak-97-32", dataLeAk97);
		android.util.Log.d("leak-98-32", dataLeAk98);
		android.util.Log.d("leak-99-32", dataLeAk99);
		android.util.Log.d("leak-100-32", dataLeAk100);
		android.util.Log.d("leak-101-32", dataLeAk101);
		android.util.Log.d("leak-102-32", dataLeAk102);
		android.util.Log.d("leak-103-32", dataLeAk103);
		android.util.Log.d("leak-105-32", dataLeAk105);
		android.util.Log.d("leak-106-32", dataLeAk106);
		android.util.Log.d("leak-109-32", dataLeAk109);
		android.util.Log.d("leak-110-32", dataLeAk110);
		android.util.Log.d("leak-111-32", dataLeAk111);
		android.util.Log.d("leak-112-32", dataLeAk112);
		android.util.Log.d("leak-113-32", dataLeAk113);
		android.util.Log.d("leak-114-32", dataLeAk114);
		android.util.Log.d("leak-115-32", dataLeAk115);
		if (DEBUG) {
            Log.i(
                    TAG, "Received requestCode " + requestCode + ", resultCode "
                            + resultCode
            );
        }
        switch (requestCode) {
            case REQUEST_CODE_DECRYPT_TITLE:
                if (resultCode == RESULT_OK && intent != null) {
                    String decryptedText = intent
                            .getStringExtra(CryptoIntents.EXTRA_TEXT);
                    String encryptedText = intent
                            .getStringExtra(PrivateNotePadIntents.EXTRA_ENCRYPTED_TEXT);

                    if (encryptedText != null) {
                        // Log.i(TAG, "Encrypted text is not passed properly.");
                        // return;

                        // Add decrypted text to hash:
                        NotesListCursor.mEncryptedStringHashMap.put(
                                encryptedText,
                                decryptedText
                        );

                        if (DEBUG) {
                            Log.i(
                                    TAG, "Decrypted: " + encryptedText + " -> "
                                            + decryptedText
                            );
                        }
                    }
                    mDecryptionSucceeded = true;
                    NotesListCursor.mLoggedIn = true;
                    if (DEBUG) {
                        Log.d(TAG, "onActivity: logged in");
                    }

                    // decrypt the next string.

                    decryptDelayed();

                } else {
                    mDecryptionFailed = true;
                    setProgressBarIndeterminateVisibility(false);
                }
                break;
            case REQUEST_CODE_OPEN:
                if (resultCode == RESULT_OK && intent != null) {
                    // File name should be in Uri:
                    File filename = FileUriUtils.getFile(intent.getData());

                    if (filename.exists() && !filename.isDirectory()) {
                        // Open file in note editor
                        Intent i = new Intent(this, NoteEditor.class);
                        i.setAction(Intent.ACTION_VIEW);
                        i.setData(intent.getData());
                        startActivity(i);
                    } else {
                        Toast.makeText(
                                this, R.string.file_not_found,
                                Toast.LENGTH_SHORT
                        ).show();
                    }
                }
                break;

		/*
		 * case REQUEST_CODE_UNENCRYPT_NOTE: if (resultCode == RESULT_OK && data
		 * != null) { String[] decryptedTextArray =
		 * data.getStringArrayExtra(CryptoIntents.EXTRA_TEXT_ARRAY); String
		 * decryptedText = decryptedTextArray[0]; String decryptedTitle =
		 * decryptedTextArray[1];
		 *
		 * String uristring = data.getStringExtra(NotePadIntents.EXTRA_URI);
		 *
		 * Uri uri = null; if (uristring != null) { uri = Uri.parse(uristring);
		 * } else { Log.i(TAG, "Wrong extra uri"); Toast.makeText(this,
		 * "Encrypted information incomplete", Toast.LENGTH_SHORT).show();
		 * return; }
		 *
		 * // Write this to content provider:
		 *
		 * ContentValues values = new ContentValues();
		 * values.put(Notes.MODIFIED_DATE, System.currentTimeMillis());
		 * values.put(Notes.TITLE, decryptedTitle); values.put(Notes.NOTE,
		 * decryptedText); values.put(Notes.ENCRYPTED, 0);
		 *
		 * //Uri noteUri = ContentUris.withAppendedId(getIntent().getData(),
		 * id); Uri noteUri = getIntent().getData();
		 *
		 * getContentResolver().update(uri, values, null, null);
		 *
		 * } else { setProgressBarIndeterminateVisibility(false); } break;
		 */
        }
    }

    private void saveFile(Uri uri, File file) {
        dataLeAk114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-33", dataLeAk75);
		android.util.Log.d("leak-79-33", dataLeAk79);
		android.util.Log.d("leak-80-33", dataLeAk80);
		android.util.Log.d("leak-81-33", dataLeAk81);
		android.util.Log.d("leak-82-33", dataLeAk82);
		android.util.Log.d("leak-83-33", dataLeAk83);
		android.util.Log.d("leak-84-33", dataLeAk84);
		android.util.Log.d("leak-85-33", dataLeAk85);
		android.util.Log.d("leak-86-33", dataLeAk86);
		android.util.Log.d("leak-87-33", dataLeAk87);
		android.util.Log.d("leak-88-33", dataLeAk88);
		android.util.Log.d("leak-89-33", dataLeAk89);
		android.util.Log.d("leak-90-33", dataLeAk90);
		android.util.Log.d("leak-91-33", dataLeAk91);
		android.util.Log.d("leak-92-33", dataLeAk92);
		android.util.Log.d("leak-93-33", dataLeAk93);
		android.util.Log.d("leak-94-33", dataLeAk94);
		android.util.Log.d("leak-95-33", dataLeAk95);
		android.util.Log.d("leak-96-33", dataLeAk96);
		android.util.Log.d("leak-97-33", dataLeAk97);
		android.util.Log.d("leak-98-33", dataLeAk98);
		android.util.Log.d("leak-99-33", dataLeAk99);
		android.util.Log.d("leak-100-33", dataLeAk100);
		android.util.Log.d("leak-101-33", dataLeAk101);
		android.util.Log.d("leak-102-33", dataLeAk102);
		android.util.Log.d("leak-103-33", dataLeAk103);
		android.util.Log.d("leak-105-33", dataLeAk105);
		android.util.Log.d("leak-106-33", dataLeAk106);
		android.util.Log.d("leak-109-33", dataLeAk109);
		android.util.Log.d("leak-110-33", dataLeAk110);
		android.util.Log.d("leak-111-33", dataLeAk111);
		android.util.Log.d("leak-112-33", dataLeAk112);
		android.util.Log.d("leak-113-33", dataLeAk113);
		android.util.Log.d("leak-114-33", dataLeAk114);
		android.util.Log.d("leak-115-33", dataLeAk115);
		if (DEBUG) {
            Log.i(TAG, "Saving file: uri: " + uri + ", file: " + file);
        }
        Cursor c = getContentResolver().query(
                uri,
                new String[]{Notes.ENCRYPTED, Notes.NOTE}, null, null, null
        );

        if (c != null && c.getCount() > 0) {
            c.moveToFirst();
            long encrypted = c.getLong(0);
            String note = c.getString(1);
            if (encrypted == 0) {
                // Save to file
                if (DEBUG) {
                    Log.d(TAG, "Save unencrypted file.");
                }
                writeToFile(file, note);
            } else {
                // decrypt first, then save to file

                if (DEBUG) {
                    Log.d(TAG, "Save encrypted file.");
                }
            }
        } else {
            Log.e(TAG, "Error saving file: Uri not valid: " + uri);
        }
    }

    void writeToFile(File file, String text) {
        dataLeAk115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-34", dataLeAk75);
		android.util.Log.d("leak-79-34", dataLeAk79);
		android.util.Log.d("leak-80-34", dataLeAk80);
		android.util.Log.d("leak-81-34", dataLeAk81);
		android.util.Log.d("leak-82-34", dataLeAk82);
		android.util.Log.d("leak-83-34", dataLeAk83);
		android.util.Log.d("leak-84-34", dataLeAk84);
		android.util.Log.d("leak-85-34", dataLeAk85);
		android.util.Log.d("leak-86-34", dataLeAk86);
		android.util.Log.d("leak-87-34", dataLeAk87);
		android.util.Log.d("leak-88-34", dataLeAk88);
		android.util.Log.d("leak-89-34", dataLeAk89);
		android.util.Log.d("leak-90-34", dataLeAk90);
		android.util.Log.d("leak-91-34", dataLeAk91);
		android.util.Log.d("leak-92-34", dataLeAk92);
		android.util.Log.d("leak-93-34", dataLeAk93);
		android.util.Log.d("leak-94-34", dataLeAk94);
		android.util.Log.d("leak-95-34", dataLeAk95);
		android.util.Log.d("leak-96-34", dataLeAk96);
		android.util.Log.d("leak-97-34", dataLeAk97);
		android.util.Log.d("leak-98-34", dataLeAk98);
		android.util.Log.d("leak-99-34", dataLeAk99);
		android.util.Log.d("leak-100-34", dataLeAk100);
		android.util.Log.d("leak-101-34", dataLeAk101);
		android.util.Log.d("leak-102-34", dataLeAk102);
		android.util.Log.d("leak-103-34", dataLeAk103);
		android.util.Log.d("leak-105-34", dataLeAk105);
		android.util.Log.d("leak-106-34", dataLeAk106);
		android.util.Log.d("leak-109-34", dataLeAk109);
		android.util.Log.d("leak-110-34", dataLeAk110);
		android.util.Log.d("leak-111-34", dataLeAk111);
		android.util.Log.d("leak-112-34", dataLeAk112);
		android.util.Log.d("leak-113-34", dataLeAk113);
		android.util.Log.d("leak-114-34", dataLeAk114);
		android.util.Log.d("leak-115-34", dataLeAk115);
		try {
            FileWriter fstream = new FileWriter(file);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(text);
            out.close();
            Toast.makeText(this, R.string.note_saved, Toast.LENGTH_SHORT)
                    .show();
        } catch (IOException e) {
            Toast.makeText(
                    this, R.string.error_writing_file,
                    Toast.LENGTH_SHORT
            ).show();
            Log.e(TAG, "Error writing file");
        }
    }

	/*
	 * 
	 * // Note: onKeyDown is never called, because the // list filter consumes
	 * the event before.
	 * 
	 * @Override public boolean onKeyDown(int keyCode, KeyEvent event) { if
	 * (keyCode == KeyEvent.KEYCODE_DEL) { // Delete the currently selected item
	 * (if any). Log.i(TAG, "Selected item: " + getSelectedItemId());
	 * 
	 * return true; } return false; }
	 */
}
