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
    String dataLeAk91 = "91";
	String dataLeAk53 = "53";

	String dataLeAk90 = "90";

	String dataLeAk89 = "89";

	String dataLeAk88 = "88";

	String dataLeAk87 = "87";

	String dataLeAk86 = "86";

	String dataLeAk85 = "85";

	String dataLeAk83 = "83";

	String dataLeAk81 = "81";

	String dataLeAk80 = "80";

	String dataLeAk79 = "79";

	String dataLeAk77 = "77";

	String dataLeAk76 = "76";

	String dataLeAk75 = "75";

	String dataLeAk74 = "74";

	String dataLeAk73 = "73";

	String dataLeAk72 = "72";

	String dataLeAk71 = "71";

	String dataLeAk70 = "70";

	String dataLeAk69 = "69";

	String dataLeAk68 = "68";

	String dataLeAk67 = "67";

	String dataLeAk66 = "66";

	String dataLeAk65 = "65";

	String dataLeAk64 = "64";

	String dataLeAk63 = "63";

	String dataLeAk62 = "62";

	String dataLeAk61 = "61";

	String dataLeAk59 = "59";

	String dataLeAk57 = "57";

	String dataLeAk55 = "55";

	String dataLeAk54 = "54";

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


		public void onReceive(Context context, Intent intent) {
            dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
		dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-53-68", dataLeAk53);
		android.util.Log.d("leak-54-68", dataLeAk54);
		android.util.Log.d("leak-55-68", dataLeAk55);
		android.util.Log.d("leak-57-68", dataLeAk57);
		android.util.Log.d("leak-59-68", dataLeAk59);
		android.util.Log.d("leak-61-68", dataLeAk61);
		android.util.Log.d("leak-62-68", dataLeAk62);
		android.util.Log.d("leak-63-68", dataLeAk63);
		android.util.Log.d("leak-64-68", dataLeAk64);
		android.util.Log.d("leak-65-68", dataLeAk65);
		android.util.Log.d("leak-66-68", dataLeAk66);
		android.util.Log.d("leak-67-68", dataLeAk67);
		android.util.Log.d("leak-68-68", dataLeAk68);
		android.util.Log.d("leak-69-68", dataLeAk69);
		android.util.Log.d("leak-70-68", dataLeAk70);
		android.util.Log.d("leak-71-68", dataLeAk71);
		android.util.Log.d("leak-72-68", dataLeAk72);
		android.util.Log.d("leak-73-68", dataLeAk73);
		android.util.Log.d("leak-74-68", dataLeAk74);
		android.util.Log.d("leak-75-68", dataLeAk75);
		android.util.Log.d("leak-76-68", dataLeAk76);
		android.util.Log.d("leak-77-68", dataLeAk77);
		android.util.Log.d("leak-79-68", dataLeAk79);
		android.util.Log.d("leak-80-68", dataLeAk80);
		android.util.Log.d("leak-81-68", dataLeAk81);
		android.util.Log.d("leak-83-68", dataLeAk83);
		android.util.Log.d("leak-85-68", dataLeAk85);
		android.util.Log.d("leak-86-68", dataLeAk86);
		android.util.Log.d("leak-87-68", dataLeAk87);
		android.util.Log.d("leak-88-68", dataLeAk88);
		android.util.Log.d("leak-89-68", dataLeAk89);
		android.util.Log.d("leak-90-68", dataLeAk90);
		android.util.Log.d("leak-91-68", dataLeAk91);
		android.util.Log.d("leak-53-68", dataLeAk53);
		android.util.Log.d("leak-54-68", dataLeAk54);
		android.util.Log.d("leak-55-68", dataLeAk55);
		android.util.Log.d("leak-57-68", dataLeAk57);
		android.util.Log.d("leak-59-68", dataLeAk59);
		android.util.Log.d("leak-61-68", dataLeAk61);
		android.util.Log.d("leak-62-68", dataLeAk62);
		android.util.Log.d("leak-63-68", dataLeAk63);
		android.util.Log.d("leak-64-68", dataLeAk64);
		android.util.Log.d("leak-65-68", dataLeAk65);
		android.util.Log.d("leak-66-68", dataLeAk66);
		android.util.Log.d("leak-67-68", dataLeAk67);
		android.util.Log.d("leak-68-68", dataLeAk68);
		android.util.Log.d("leak-69-68", dataLeAk69);
		android.util.Log.d("leak-70-68", dataLeAk70);
		android.util.Log.d("leak-71-68", dataLeAk71);
		android.util.Log.d("leak-72-68", dataLeAk72);
		android.util.Log.d("leak-73-68", dataLeAk73);
		android.util.Log.d("leak-74-68", dataLeAk74);
		android.util.Log.d("leak-75-68", dataLeAk75);
		android.util.Log.d("leak-76-68", dataLeAk76);
		android.util.Log.d("leak-77-68", dataLeAk77);
		android.util.Log.d("leak-79-68", dataLeAk79);
		android.util.Log.d("leak-80-68", dataLeAk80);
		android.util.Log.d("leak-81-68", dataLeAk81);
		android.util.Log.d("leak-83-68", dataLeAk83);
		android.util.Log.d("leak-85-68", dataLeAk85);
		android.util.Log.d("leak-86-68", dataLeAk86);
		android.util.Log.d("leak-87-68", dataLeAk87);
		android.util.Log.d("leak-88-68", dataLeAk88);
		android.util.Log.d("leak-89-68", dataLeAk89);
		android.util.Log.d("leak-90-68", dataLeAk90);
		android.util.Log.d("leak-91-68", dataLeAk91);
		android.util.Log.d("leak-53-68", dataLeAk53);
		android.util.Log.d("leak-54-68", dataLeAk54);
		android.util.Log.d("leak-55-68", dataLeAk55);
		android.util.Log.d("leak-57-68", dataLeAk57);
		android.util.Log.d("leak-59-68", dataLeAk59);
		android.util.Log.d("leak-61-68", dataLeAk61);
		android.util.Log.d("leak-62-68", dataLeAk62);
		android.util.Log.d("leak-63-68", dataLeAk63);
		android.util.Log.d("leak-64-68", dataLeAk64);
		android.util.Log.d("leak-65-68", dataLeAk65);
		android.util.Log.d("leak-66-68", dataLeAk66);
		android.util.Log.d("leak-67-68", dataLeAk67);
		android.util.Log.d("leak-68-68", dataLeAk68);
		android.util.Log.d("leak-69-68", dataLeAk69);
		android.util.Log.d("leak-70-68", dataLeAk70);
		android.util.Log.d("leak-71-68", dataLeAk71);
		android.util.Log.d("leak-72-68", dataLeAk72);
		android.util.Log.d("leak-73-68", dataLeAk73);
		android.util.Log.d("leak-74-68", dataLeAk74);
		android.util.Log.d("leak-75-68", dataLeAk75);
		android.util.Log.d("leak-76-68", dataLeAk76);
		android.util.Log.d("leak-77-68", dataLeAk77);
		android.util.Log.d("leak-79-68", dataLeAk79);
		android.util.Log.d("leak-80-68", dataLeAk80);
		android.util.Log.d("leak-81-68", dataLeAk81);
		android.util.Log.d("leak-83-68", dataLeAk83);
		android.util.Log.d("leak-85-68", dataLeAk85);
		android.util.Log.d("leak-86-68", dataLeAk86);
		android.util.Log.d("leak-87-68", dataLeAk87);
		android.util.Log.d("leak-88-68", dataLeAk88);
		android.util.Log.d("leak-89-68", dataLeAk89);
		android.util.Log.d("leak-90-68", dataLeAk90);
		android.util.Log.d("leak-91-68", dataLeAk91);
		android.util.Log.d("leak-54-68", dataLeAk54);
		android.util.Log.d("leak-55-68", dataLeAk55);
		android.util.Log.d("leak-57-68", dataLeAk57);
		android.util.Log.d("leak-59-68", dataLeAk59);
		android.util.Log.d("leak-61-68", dataLeAk61);
		android.util.Log.d("leak-62-68", dataLeAk62);
		android.util.Log.d("leak-63-68", dataLeAk63);
		android.util.Log.d("leak-64-68", dataLeAk64);
		android.util.Log.d("leak-65-68", dataLeAk65);
		android.util.Log.d("leak-66-68", dataLeAk66);
		android.util.Log.d("leak-67-68", dataLeAk67);
		android.util.Log.d("leak-68-68", dataLeAk68);
		android.util.Log.d("leak-69-68", dataLeAk69);
		android.util.Log.d("leak-70-68", dataLeAk70);
		android.util.Log.d("leak-71-68", dataLeAk71);
		android.util.Log.d("leak-72-68", dataLeAk72);
		android.util.Log.d("leak-73-68", dataLeAk73);
		android.util.Log.d("leak-74-68", dataLeAk74);
		android.util.Log.d("leak-75-68", dataLeAk75);
		android.util.Log.d("leak-76-68", dataLeAk76);
		android.util.Log.d("leak-77-68", dataLeAk77);
		android.util.Log.d("leak-79-68", dataLeAk79);
		android.util.Log.d("leak-80-68", dataLeAk80);
		android.util.Log.d("leak-81-68", dataLeAk81);
		android.util.Log.d("leak-83-68", dataLeAk83);
		android.util.Log.d("leak-85-68", dataLeAk85);
		android.util.Log.d("leak-86-68", dataLeAk86);
		android.util.Log.d("leak-87-68", dataLeAk87);
		android.util.Log.d("leak-88-68", dataLeAk88);
		android.util.Log.d("leak-89-68", dataLeAk89);
		android.util.Log.d("leak-90-68", dataLeAk90);
		android.util.Log.d("leak-91-68", dataLeAk91);

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
                    String dataLeAk56 = "56";

					@Override
                    public void onChanged() {
                        dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						dataLeAk56 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						NotesList.this.updateTagList();
                    }
                }
        );

        Spinner s = (Spinner) findViewById(R.id.tagselection);
        s.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    String dataLeAk60 = "60";

					String dataLeAk58 = "58";

					public void onItemSelected(AdapterView<?> parent, View view,
                                               int position, long id) {
                        dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
												dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						if (position == 0) {
                            mSelectedTag = null;
                        } else {
                            mSelectedTag = parent.getItemAtPosition(position).toString();
                        }
                        NotesList.this.updateQuery();
                        decryptDelayed();
                    }

                    public void onNothingSelected(AdapterView<?> arg0) {
						dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

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

        dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-53-69", dataLeAk53);
		android.util.Log.d("leak-54-69", dataLeAk54);
		android.util.Log.d("leak-55-69", dataLeAk55);
		android.util.Log.d("leak-57-69", dataLeAk57);
		android.util.Log.d("leak-59-69", dataLeAk59);
		android.util.Log.d("leak-61-69", dataLeAk61);
		android.util.Log.d("leak-62-69", dataLeAk62);
		android.util.Log.d("leak-63-69", dataLeAk63);
		android.util.Log.d("leak-64-69", dataLeAk64);
		android.util.Log.d("leak-65-69", dataLeAk65);
		android.util.Log.d("leak-66-69", dataLeAk66);
		android.util.Log.d("leak-67-69", dataLeAk67);
		android.util.Log.d("leak-68-69", dataLeAk68);
		android.util.Log.d("leak-69-69", dataLeAk69);
		android.util.Log.d("leak-70-69", dataLeAk70);
		android.util.Log.d("leak-71-69", dataLeAk71);
		android.util.Log.d("leak-72-69", dataLeAk72);
		android.util.Log.d("leak-73-69", dataLeAk73);
		android.util.Log.d("leak-74-69", dataLeAk74);
		android.util.Log.d("leak-75-69", dataLeAk75);
		android.util.Log.d("leak-76-69", dataLeAk76);
		android.util.Log.d("leak-77-69", dataLeAk77);
		android.util.Log.d("leak-79-69", dataLeAk79);
		android.util.Log.d("leak-80-69", dataLeAk80);
		android.util.Log.d("leak-81-69", dataLeAk81);
		android.util.Log.d("leak-83-69", dataLeAk83);
		android.util.Log.d("leak-85-69", dataLeAk85);
		android.util.Log.d("leak-86-69", dataLeAk86);
		android.util.Log.d("leak-87-69", dataLeAk87);
		android.util.Log.d("leak-88-69", dataLeAk88);
		android.util.Log.d("leak-89-69", dataLeAk89);
		android.util.Log.d("leak-90-69", dataLeAk90);
		android.util.Log.d("leak-91-69", dataLeAk91);
		android.util.Log.d("leak-53-69", dataLeAk53);
		android.util.Log.d("leak-54-69", dataLeAk54);
		android.util.Log.d("leak-55-69", dataLeAk55);
		android.util.Log.d("leak-57-69", dataLeAk57);
		android.util.Log.d("leak-59-69", dataLeAk59);
		android.util.Log.d("leak-61-69", dataLeAk61);
		android.util.Log.d("leak-62-69", dataLeAk62);
		android.util.Log.d("leak-63-69", dataLeAk63);
		android.util.Log.d("leak-64-69", dataLeAk64);
		android.util.Log.d("leak-65-69", dataLeAk65);
		android.util.Log.d("leak-66-69", dataLeAk66);
		android.util.Log.d("leak-67-69", dataLeAk67);
		android.util.Log.d("leak-68-69", dataLeAk68);
		android.util.Log.d("leak-69-69", dataLeAk69);
		android.util.Log.d("leak-70-69", dataLeAk70);
		android.util.Log.d("leak-71-69", dataLeAk71);
		android.util.Log.d("leak-72-69", dataLeAk72);
		android.util.Log.d("leak-73-69", dataLeAk73);
		android.util.Log.d("leak-74-69", dataLeAk74);
		android.util.Log.d("leak-75-69", dataLeAk75);
		android.util.Log.d("leak-76-69", dataLeAk76);
		android.util.Log.d("leak-77-69", dataLeAk77);
		android.util.Log.d("leak-79-69", dataLeAk79);
		android.util.Log.d("leak-80-69", dataLeAk80);
		android.util.Log.d("leak-81-69", dataLeAk81);
		android.util.Log.d("leak-83-69", dataLeAk83);
		android.util.Log.d("leak-85-69", dataLeAk85);
		android.util.Log.d("leak-86-69", dataLeAk86);
		android.util.Log.d("leak-87-69", dataLeAk87);
		android.util.Log.d("leak-88-69", dataLeAk88);
		android.util.Log.d("leak-89-69", dataLeAk89);
		android.util.Log.d("leak-90-69", dataLeAk90);
		android.util.Log.d("leak-91-69", dataLeAk91);
		android.util.Log.d("leak-53-69", dataLeAk53);
		android.util.Log.d("leak-54-69", dataLeAk54);
		android.util.Log.d("leak-55-69", dataLeAk55);
		android.util.Log.d("leak-57-69", dataLeAk57);
		android.util.Log.d("leak-59-69", dataLeAk59);
		android.util.Log.d("leak-61-69", dataLeAk61);
		android.util.Log.d("leak-62-69", dataLeAk62);
		android.util.Log.d("leak-63-69", dataLeAk63);
		android.util.Log.d("leak-64-69", dataLeAk64);
		android.util.Log.d("leak-65-69", dataLeAk65);
		android.util.Log.d("leak-66-69", dataLeAk66);
		android.util.Log.d("leak-67-69", dataLeAk67);
		android.util.Log.d("leak-68-69", dataLeAk68);
		android.util.Log.d("leak-69-69", dataLeAk69);
		android.util.Log.d("leak-70-69", dataLeAk70);
		android.util.Log.d("leak-71-69", dataLeAk71);
		android.util.Log.d("leak-72-69", dataLeAk72);
		android.util.Log.d("leak-73-69", dataLeAk73);
		android.util.Log.d("leak-74-69", dataLeAk74);
		android.util.Log.d("leak-75-69", dataLeAk75);
		android.util.Log.d("leak-76-69", dataLeAk76);
		android.util.Log.d("leak-77-69", dataLeAk77);
		android.util.Log.d("leak-79-69", dataLeAk79);
		android.util.Log.d("leak-80-69", dataLeAk80);
		android.util.Log.d("leak-81-69", dataLeAk81);
		android.util.Log.d("leak-83-69", dataLeAk83);
		android.util.Log.d("leak-85-69", dataLeAk85);
		android.util.Log.d("leak-86-69", dataLeAk86);
		android.util.Log.d("leak-87-69", dataLeAk87);
		android.util.Log.d("leak-88-69", dataLeAk88);
		android.util.Log.d("leak-89-69", dataLeAk89);
		android.util.Log.d("leak-90-69", dataLeAk90);
		android.util.Log.d("leak-91-69", dataLeAk91);
		android.util.Log.d("leak-54-69", dataLeAk54);
		android.util.Log.d("leak-55-69", dataLeAk55);
		android.util.Log.d("leak-57-69", dataLeAk57);
		android.util.Log.d("leak-59-69", dataLeAk59);
		android.util.Log.d("leak-61-69", dataLeAk61);
		android.util.Log.d("leak-62-69", dataLeAk62);
		android.util.Log.d("leak-63-69", dataLeAk63);
		android.util.Log.d("leak-64-69", dataLeAk64);
		android.util.Log.d("leak-65-69", dataLeAk65);
		android.util.Log.d("leak-66-69", dataLeAk66);
		android.util.Log.d("leak-67-69", dataLeAk67);
		android.util.Log.d("leak-68-69", dataLeAk68);
		android.util.Log.d("leak-69-69", dataLeAk69);
		android.util.Log.d("leak-70-69", dataLeAk70);
		android.util.Log.d("leak-71-69", dataLeAk71);
		android.util.Log.d("leak-72-69", dataLeAk72);
		android.util.Log.d("leak-73-69", dataLeAk73);
		android.util.Log.d("leak-74-69", dataLeAk74);
		android.util.Log.d("leak-75-69", dataLeAk75);
		android.util.Log.d("leak-76-69", dataLeAk76);
		android.util.Log.d("leak-77-69", dataLeAk77);
		android.util.Log.d("leak-79-69", dataLeAk79);
		android.util.Log.d("leak-80-69", dataLeAk80);
		android.util.Log.d("leak-81-69", dataLeAk81);
		android.util.Log.d("leak-83-69", dataLeAk83);
		android.util.Log.d("leak-85-69", dataLeAk85);
		android.util.Log.d("leak-86-69", dataLeAk86);
		android.util.Log.d("leak-87-69", dataLeAk87);
		android.util.Log.d("leak-88-69", dataLeAk88);
		android.util.Log.d("leak-89-69", dataLeAk89);
		android.util.Log.d("leak-90-69", dataLeAk90);
		android.util.Log.d("leak-91-69", dataLeAk91);
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
		dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-53-70", dataLeAk53);
		android.util.Log.d("leak-54-70", dataLeAk54);
		android.util.Log.d("leak-55-70", dataLeAk55);
		android.util.Log.d("leak-57-70", dataLeAk57);
		android.util.Log.d("leak-59-70", dataLeAk59);
		android.util.Log.d("leak-61-70", dataLeAk61);
		android.util.Log.d("leak-62-70", dataLeAk62);
		android.util.Log.d("leak-63-70", dataLeAk63);
		android.util.Log.d("leak-64-70", dataLeAk64);
		android.util.Log.d("leak-65-70", dataLeAk65);
		android.util.Log.d("leak-66-70", dataLeAk66);
		android.util.Log.d("leak-67-70", dataLeAk67);
		android.util.Log.d("leak-68-70", dataLeAk68);
		android.util.Log.d("leak-69-70", dataLeAk69);
		android.util.Log.d("leak-70-70", dataLeAk70);
		android.util.Log.d("leak-71-70", dataLeAk71);
		android.util.Log.d("leak-72-70", dataLeAk72);
		android.util.Log.d("leak-73-70", dataLeAk73);
		android.util.Log.d("leak-74-70", dataLeAk74);
		android.util.Log.d("leak-75-70", dataLeAk75);
		android.util.Log.d("leak-76-70", dataLeAk76);
		android.util.Log.d("leak-77-70", dataLeAk77);
		android.util.Log.d("leak-79-70", dataLeAk79);
		android.util.Log.d("leak-80-70", dataLeAk80);
		android.util.Log.d("leak-81-70", dataLeAk81);
		android.util.Log.d("leak-83-70", dataLeAk83);
		android.util.Log.d("leak-85-70", dataLeAk85);
		android.util.Log.d("leak-86-70", dataLeAk86);
		android.util.Log.d("leak-87-70", dataLeAk87);
		android.util.Log.d("leak-88-70", dataLeAk88);
		android.util.Log.d("leak-89-70", dataLeAk89);
		android.util.Log.d("leak-90-70", dataLeAk90);
		android.util.Log.d("leak-91-70", dataLeAk91);
		android.util.Log.d("leak-53-70", dataLeAk53);
		android.util.Log.d("leak-54-70", dataLeAk54);
		android.util.Log.d("leak-55-70", dataLeAk55);
		android.util.Log.d("leak-57-70", dataLeAk57);
		android.util.Log.d("leak-59-70", dataLeAk59);
		android.util.Log.d("leak-61-70", dataLeAk61);
		android.util.Log.d("leak-62-70", dataLeAk62);
		android.util.Log.d("leak-63-70", dataLeAk63);
		android.util.Log.d("leak-64-70", dataLeAk64);
		android.util.Log.d("leak-65-70", dataLeAk65);
		android.util.Log.d("leak-66-70", dataLeAk66);
		android.util.Log.d("leak-67-70", dataLeAk67);
		android.util.Log.d("leak-68-70", dataLeAk68);
		android.util.Log.d("leak-69-70", dataLeAk69);
		android.util.Log.d("leak-70-70", dataLeAk70);
		android.util.Log.d("leak-71-70", dataLeAk71);
		android.util.Log.d("leak-72-70", dataLeAk72);
		android.util.Log.d("leak-73-70", dataLeAk73);
		android.util.Log.d("leak-74-70", dataLeAk74);
		android.util.Log.d("leak-75-70", dataLeAk75);
		android.util.Log.d("leak-76-70", dataLeAk76);
		android.util.Log.d("leak-77-70", dataLeAk77);
		android.util.Log.d("leak-79-70", dataLeAk79);
		android.util.Log.d("leak-80-70", dataLeAk80);
		android.util.Log.d("leak-81-70", dataLeAk81);
		android.util.Log.d("leak-83-70", dataLeAk83);
		android.util.Log.d("leak-85-70", dataLeAk85);
		android.util.Log.d("leak-86-70", dataLeAk86);
		android.util.Log.d("leak-87-70", dataLeAk87);
		android.util.Log.d("leak-88-70", dataLeAk88);
		android.util.Log.d("leak-89-70", dataLeAk89);
		android.util.Log.d("leak-90-70", dataLeAk90);
		android.util.Log.d("leak-91-70", dataLeAk91);
		android.util.Log.d("leak-53-70", dataLeAk53);
		android.util.Log.d("leak-54-70", dataLeAk54);
		android.util.Log.d("leak-55-70", dataLeAk55);
		android.util.Log.d("leak-57-70", dataLeAk57);
		android.util.Log.d("leak-59-70", dataLeAk59);
		android.util.Log.d("leak-61-70", dataLeAk61);
		android.util.Log.d("leak-62-70", dataLeAk62);
		android.util.Log.d("leak-63-70", dataLeAk63);
		android.util.Log.d("leak-64-70", dataLeAk64);
		android.util.Log.d("leak-65-70", dataLeAk65);
		android.util.Log.d("leak-66-70", dataLeAk66);
		android.util.Log.d("leak-67-70", dataLeAk67);
		android.util.Log.d("leak-68-70", dataLeAk68);
		android.util.Log.d("leak-69-70", dataLeAk69);
		android.util.Log.d("leak-70-70", dataLeAk70);
		android.util.Log.d("leak-71-70", dataLeAk71);
		android.util.Log.d("leak-72-70", dataLeAk72);
		android.util.Log.d("leak-73-70", dataLeAk73);
		android.util.Log.d("leak-74-70", dataLeAk74);
		android.util.Log.d("leak-75-70", dataLeAk75);
		android.util.Log.d("leak-76-70", dataLeAk76);
		android.util.Log.d("leak-77-70", dataLeAk77);
		android.util.Log.d("leak-79-70", dataLeAk79);
		android.util.Log.d("leak-80-70", dataLeAk80);
		android.util.Log.d("leak-81-70", dataLeAk81);
		android.util.Log.d("leak-83-70", dataLeAk83);
		android.util.Log.d("leak-85-70", dataLeAk85);
		android.util.Log.d("leak-86-70", dataLeAk86);
		android.util.Log.d("leak-87-70", dataLeAk87);
		android.util.Log.d("leak-88-70", dataLeAk88);
		android.util.Log.d("leak-89-70", dataLeAk89);
		android.util.Log.d("leak-90-70", dataLeAk90);
		android.util.Log.d("leak-91-70", dataLeAk91);
		android.util.Log.d("leak-54-70", dataLeAk54);
		android.util.Log.d("leak-55-70", dataLeAk55);
		android.util.Log.d("leak-57-70", dataLeAk57);
		android.util.Log.d("leak-59-70", dataLeAk59);
		android.util.Log.d("leak-61-70", dataLeAk61);
		android.util.Log.d("leak-62-70", dataLeAk62);
		android.util.Log.d("leak-63-70", dataLeAk63);
		android.util.Log.d("leak-64-70", dataLeAk64);
		android.util.Log.d("leak-65-70", dataLeAk65);
		android.util.Log.d("leak-66-70", dataLeAk66);
		android.util.Log.d("leak-67-70", dataLeAk67);
		android.util.Log.d("leak-68-70", dataLeAk68);
		android.util.Log.d("leak-69-70", dataLeAk69);
		android.util.Log.d("leak-70-70", dataLeAk70);
		android.util.Log.d("leak-71-70", dataLeAk71);
		android.util.Log.d("leak-72-70", dataLeAk72);
		android.util.Log.d("leak-73-70", dataLeAk73);
		android.util.Log.d("leak-74-70", dataLeAk74);
		android.util.Log.d("leak-75-70", dataLeAk75);
		android.util.Log.d("leak-76-70", dataLeAk76);
		android.util.Log.d("leak-77-70", dataLeAk77);
		android.util.Log.d("leak-79-70", dataLeAk79);
		android.util.Log.d("leak-80-70", dataLeAk80);
		android.util.Log.d("leak-81-70", dataLeAk81);
		android.util.Log.d("leak-83-70", dataLeAk83);
		android.util.Log.d("leak-85-70", dataLeAk85);
		android.util.Log.d("leak-86-70", dataLeAk86);
		android.util.Log.d("leak-87-70", dataLeAk87);
		android.util.Log.d("leak-88-70", dataLeAk88);
		android.util.Log.d("leak-89-70", dataLeAk89);
		android.util.Log.d("leak-90-70", dataLeAk90);
		android.util.Log.d("leak-91-70", dataLeAk91);
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
		android.util.Log.d("leak-53-71", dataLeAk53);
		android.util.Log.d("leak-54-71", dataLeAk54);
		android.util.Log.d("leak-55-71", dataLeAk55);
		android.util.Log.d("leak-57-71", dataLeAk57);
		android.util.Log.d("leak-59-71", dataLeAk59);
		android.util.Log.d("leak-61-71", dataLeAk61);
		android.util.Log.d("leak-62-71", dataLeAk62);
		android.util.Log.d("leak-63-71", dataLeAk63);
		android.util.Log.d("leak-64-71", dataLeAk64);
		android.util.Log.d("leak-65-71", dataLeAk65);
		android.util.Log.d("leak-66-71", dataLeAk66);
		android.util.Log.d("leak-67-71", dataLeAk67);
		android.util.Log.d("leak-68-71", dataLeAk68);
		android.util.Log.d("leak-69-71", dataLeAk69);
		android.util.Log.d("leak-70-71", dataLeAk70);
		android.util.Log.d("leak-71-71", dataLeAk71);
		android.util.Log.d("leak-72-71", dataLeAk72);
		android.util.Log.d("leak-73-71", dataLeAk73);
		android.util.Log.d("leak-74-71", dataLeAk74);
		android.util.Log.d("leak-75-71", dataLeAk75);
		android.util.Log.d("leak-76-71", dataLeAk76);
		android.util.Log.d("leak-77-71", dataLeAk77);
		android.util.Log.d("leak-79-71", dataLeAk79);
		android.util.Log.d("leak-80-71", dataLeAk80);
		android.util.Log.d("leak-81-71", dataLeAk81);
		android.util.Log.d("leak-83-71", dataLeAk83);
		android.util.Log.d("leak-85-71", dataLeAk85);
		android.util.Log.d("leak-86-71", dataLeAk86);
		android.util.Log.d("leak-87-71", dataLeAk87);
		android.util.Log.d("leak-88-71", dataLeAk88);
		android.util.Log.d("leak-89-71", dataLeAk89);
		android.util.Log.d("leak-90-71", dataLeAk90);
		android.util.Log.d("leak-91-71", dataLeAk91);
		android.util.Log.d("leak-53-71", dataLeAk53);
		android.util.Log.d("leak-54-71", dataLeAk54);
		android.util.Log.d("leak-55-71", dataLeAk55);
		android.util.Log.d("leak-57-71", dataLeAk57);
		android.util.Log.d("leak-59-71", dataLeAk59);
		android.util.Log.d("leak-61-71", dataLeAk61);
		android.util.Log.d("leak-62-71", dataLeAk62);
		android.util.Log.d("leak-63-71", dataLeAk63);
		android.util.Log.d("leak-64-71", dataLeAk64);
		android.util.Log.d("leak-65-71", dataLeAk65);
		android.util.Log.d("leak-66-71", dataLeAk66);
		android.util.Log.d("leak-67-71", dataLeAk67);
		android.util.Log.d("leak-68-71", dataLeAk68);
		android.util.Log.d("leak-69-71", dataLeAk69);
		android.util.Log.d("leak-70-71", dataLeAk70);
		android.util.Log.d("leak-71-71", dataLeAk71);
		android.util.Log.d("leak-72-71", dataLeAk72);
		android.util.Log.d("leak-73-71", dataLeAk73);
		android.util.Log.d("leak-74-71", dataLeAk74);
		android.util.Log.d("leak-75-71", dataLeAk75);
		android.util.Log.d("leak-76-71", dataLeAk76);
		android.util.Log.d("leak-77-71", dataLeAk77);
		android.util.Log.d("leak-79-71", dataLeAk79);
		android.util.Log.d("leak-80-71", dataLeAk80);
		android.util.Log.d("leak-81-71", dataLeAk81);
		android.util.Log.d("leak-83-71", dataLeAk83);
		android.util.Log.d("leak-85-71", dataLeAk85);
		android.util.Log.d("leak-86-71", dataLeAk86);
		android.util.Log.d("leak-87-71", dataLeAk87);
		android.util.Log.d("leak-88-71", dataLeAk88);
		android.util.Log.d("leak-89-71", dataLeAk89);
		android.util.Log.d("leak-90-71", dataLeAk90);
		android.util.Log.d("leak-91-71", dataLeAk91);
		android.util.Log.d("leak-53-71", dataLeAk53);
		android.util.Log.d("leak-54-71", dataLeAk54);
		android.util.Log.d("leak-55-71", dataLeAk55);
		android.util.Log.d("leak-57-71", dataLeAk57);
		android.util.Log.d("leak-59-71", dataLeAk59);
		android.util.Log.d("leak-61-71", dataLeAk61);
		android.util.Log.d("leak-62-71", dataLeAk62);
		android.util.Log.d("leak-63-71", dataLeAk63);
		android.util.Log.d("leak-64-71", dataLeAk64);
		android.util.Log.d("leak-65-71", dataLeAk65);
		android.util.Log.d("leak-66-71", dataLeAk66);
		android.util.Log.d("leak-67-71", dataLeAk67);
		android.util.Log.d("leak-68-71", dataLeAk68);
		android.util.Log.d("leak-69-71", dataLeAk69);
		android.util.Log.d("leak-70-71", dataLeAk70);
		android.util.Log.d("leak-71-71", dataLeAk71);
		android.util.Log.d("leak-72-71", dataLeAk72);
		android.util.Log.d("leak-73-71", dataLeAk73);
		android.util.Log.d("leak-74-71", dataLeAk74);
		android.util.Log.d("leak-75-71", dataLeAk75);
		android.util.Log.d("leak-76-71", dataLeAk76);
		android.util.Log.d("leak-77-71", dataLeAk77);
		android.util.Log.d("leak-79-71", dataLeAk79);
		android.util.Log.d("leak-80-71", dataLeAk80);
		android.util.Log.d("leak-81-71", dataLeAk81);
		android.util.Log.d("leak-83-71", dataLeAk83);
		android.util.Log.d("leak-85-71", dataLeAk85);
		android.util.Log.d("leak-86-71", dataLeAk86);
		android.util.Log.d("leak-87-71", dataLeAk87);
		android.util.Log.d("leak-88-71", dataLeAk88);
		android.util.Log.d("leak-89-71", dataLeAk89);
		android.util.Log.d("leak-90-71", dataLeAk90);
		android.util.Log.d("leak-91-71", dataLeAk91);
		android.util.Log.d("leak-54-71", dataLeAk54);
		android.util.Log.d("leak-55-71", dataLeAk55);
		android.util.Log.d("leak-57-71", dataLeAk57);
		android.util.Log.d("leak-59-71", dataLeAk59);
		android.util.Log.d("leak-61-71", dataLeAk61);
		android.util.Log.d("leak-62-71", dataLeAk62);
		android.util.Log.d("leak-63-71", dataLeAk63);
		android.util.Log.d("leak-64-71", dataLeAk64);
		android.util.Log.d("leak-65-71", dataLeAk65);
		android.util.Log.d("leak-66-71", dataLeAk66);
		android.util.Log.d("leak-67-71", dataLeAk67);
		android.util.Log.d("leak-68-71", dataLeAk68);
		android.util.Log.d("leak-69-71", dataLeAk69);
		android.util.Log.d("leak-70-71", dataLeAk70);
		android.util.Log.d("leak-71-71", dataLeAk71);
		android.util.Log.d("leak-72-71", dataLeAk72);
		android.util.Log.d("leak-73-71", dataLeAk73);
		android.util.Log.d("leak-74-71", dataLeAk74);
		android.util.Log.d("leak-75-71", dataLeAk75);
		android.util.Log.d("leak-76-71", dataLeAk76);
		android.util.Log.d("leak-77-71", dataLeAk77);
		android.util.Log.d("leak-79-71", dataLeAk79);
		android.util.Log.d("leak-80-71", dataLeAk80);
		android.util.Log.d("leak-81-71", dataLeAk81);
		android.util.Log.d("leak-83-71", dataLeAk83);
		android.util.Log.d("leak-85-71", dataLeAk85);
		android.util.Log.d("leak-86-71", dataLeAk86);
		android.util.Log.d("leak-87-71", dataLeAk87);
		android.util.Log.d("leak-88-71", dataLeAk88);
		android.util.Log.d("leak-89-71", dataLeAk89);
		android.util.Log.d("leak-90-71", dataLeAk90);
		android.util.Log.d("leak-91-71", dataLeAk91);
    }

    protected void updateQuery() {
        dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-53-72", dataLeAk53);
		android.util.Log.d("leak-54-72", dataLeAk54);
		android.util.Log.d("leak-55-72", dataLeAk55);
		android.util.Log.d("leak-57-72", dataLeAk57);
		android.util.Log.d("leak-59-72", dataLeAk59);
		android.util.Log.d("leak-61-72", dataLeAk61);
		android.util.Log.d("leak-62-72", dataLeAk62);
		android.util.Log.d("leak-63-72", dataLeAk63);
		android.util.Log.d("leak-64-72", dataLeAk64);
		android.util.Log.d("leak-65-72", dataLeAk65);
		android.util.Log.d("leak-66-72", dataLeAk66);
		android.util.Log.d("leak-67-72", dataLeAk67);
		android.util.Log.d("leak-68-72", dataLeAk68);
		android.util.Log.d("leak-69-72", dataLeAk69);
		android.util.Log.d("leak-70-72", dataLeAk70);
		android.util.Log.d("leak-71-72", dataLeAk71);
		android.util.Log.d("leak-72-72", dataLeAk72);
		android.util.Log.d("leak-73-72", dataLeAk73);
		android.util.Log.d("leak-74-72", dataLeAk74);
		android.util.Log.d("leak-75-72", dataLeAk75);
		android.util.Log.d("leak-76-72", dataLeAk76);
		android.util.Log.d("leak-77-72", dataLeAk77);
		android.util.Log.d("leak-79-72", dataLeAk79);
		android.util.Log.d("leak-80-72", dataLeAk80);
		android.util.Log.d("leak-81-72", dataLeAk81);
		android.util.Log.d("leak-83-72", dataLeAk83);
		android.util.Log.d("leak-85-72", dataLeAk85);
		android.util.Log.d("leak-86-72", dataLeAk86);
		android.util.Log.d("leak-87-72", dataLeAk87);
		android.util.Log.d("leak-88-72", dataLeAk88);
		android.util.Log.d("leak-89-72", dataLeAk89);
		android.util.Log.d("leak-90-72", dataLeAk90);
		android.util.Log.d("leak-91-72", dataLeAk91);
		android.util.Log.d("leak-53-72", dataLeAk53);
		android.util.Log.d("leak-54-72", dataLeAk54);
		android.util.Log.d("leak-55-72", dataLeAk55);
		android.util.Log.d("leak-57-72", dataLeAk57);
		android.util.Log.d("leak-59-72", dataLeAk59);
		android.util.Log.d("leak-61-72", dataLeAk61);
		android.util.Log.d("leak-62-72", dataLeAk62);
		android.util.Log.d("leak-63-72", dataLeAk63);
		android.util.Log.d("leak-64-72", dataLeAk64);
		android.util.Log.d("leak-65-72", dataLeAk65);
		android.util.Log.d("leak-66-72", dataLeAk66);
		android.util.Log.d("leak-67-72", dataLeAk67);
		android.util.Log.d("leak-68-72", dataLeAk68);
		android.util.Log.d("leak-69-72", dataLeAk69);
		android.util.Log.d("leak-70-72", dataLeAk70);
		android.util.Log.d("leak-71-72", dataLeAk71);
		android.util.Log.d("leak-72-72", dataLeAk72);
		android.util.Log.d("leak-73-72", dataLeAk73);
		android.util.Log.d("leak-74-72", dataLeAk74);
		android.util.Log.d("leak-75-72", dataLeAk75);
		android.util.Log.d("leak-76-72", dataLeAk76);
		android.util.Log.d("leak-77-72", dataLeAk77);
		android.util.Log.d("leak-79-72", dataLeAk79);
		android.util.Log.d("leak-80-72", dataLeAk80);
		android.util.Log.d("leak-81-72", dataLeAk81);
		android.util.Log.d("leak-83-72", dataLeAk83);
		android.util.Log.d("leak-85-72", dataLeAk85);
		android.util.Log.d("leak-86-72", dataLeAk86);
		android.util.Log.d("leak-87-72", dataLeAk87);
		android.util.Log.d("leak-88-72", dataLeAk88);
		android.util.Log.d("leak-89-72", dataLeAk89);
		android.util.Log.d("leak-90-72", dataLeAk90);
		android.util.Log.d("leak-91-72", dataLeAk91);
		android.util.Log.d("leak-53-72", dataLeAk53);
		android.util.Log.d("leak-54-72", dataLeAk54);
		android.util.Log.d("leak-55-72", dataLeAk55);
		android.util.Log.d("leak-57-72", dataLeAk57);
		android.util.Log.d("leak-59-72", dataLeAk59);
		android.util.Log.d("leak-61-72", dataLeAk61);
		android.util.Log.d("leak-62-72", dataLeAk62);
		android.util.Log.d("leak-63-72", dataLeAk63);
		android.util.Log.d("leak-64-72", dataLeAk64);
		android.util.Log.d("leak-65-72", dataLeAk65);
		android.util.Log.d("leak-66-72", dataLeAk66);
		android.util.Log.d("leak-67-72", dataLeAk67);
		android.util.Log.d("leak-68-72", dataLeAk68);
		android.util.Log.d("leak-69-72", dataLeAk69);
		android.util.Log.d("leak-70-72", dataLeAk70);
		android.util.Log.d("leak-71-72", dataLeAk71);
		android.util.Log.d("leak-72-72", dataLeAk72);
		android.util.Log.d("leak-73-72", dataLeAk73);
		android.util.Log.d("leak-74-72", dataLeAk74);
		android.util.Log.d("leak-75-72", dataLeAk75);
		android.util.Log.d("leak-76-72", dataLeAk76);
		android.util.Log.d("leak-77-72", dataLeAk77);
		android.util.Log.d("leak-79-72", dataLeAk79);
		android.util.Log.d("leak-80-72", dataLeAk80);
		android.util.Log.d("leak-81-72", dataLeAk81);
		android.util.Log.d("leak-83-72", dataLeAk83);
		android.util.Log.d("leak-85-72", dataLeAk85);
		android.util.Log.d("leak-86-72", dataLeAk86);
		android.util.Log.d("leak-87-72", dataLeAk87);
		android.util.Log.d("leak-88-72", dataLeAk88);
		android.util.Log.d("leak-89-72", dataLeAk89);
		android.util.Log.d("leak-90-72", dataLeAk90);
		android.util.Log.d("leak-91-72", dataLeAk91);
		android.util.Log.d("leak-54-72", dataLeAk54);
		android.util.Log.d("leak-55-72", dataLeAk55);
		android.util.Log.d("leak-57-72", dataLeAk57);
		android.util.Log.d("leak-59-72", dataLeAk59);
		android.util.Log.d("leak-61-72", dataLeAk61);
		android.util.Log.d("leak-62-72", dataLeAk62);
		android.util.Log.d("leak-63-72", dataLeAk63);
		android.util.Log.d("leak-64-72", dataLeAk64);
		android.util.Log.d("leak-65-72", dataLeAk65);
		android.util.Log.d("leak-66-72", dataLeAk66);
		android.util.Log.d("leak-67-72", dataLeAk67);
		android.util.Log.d("leak-68-72", dataLeAk68);
		android.util.Log.d("leak-69-72", dataLeAk69);
		android.util.Log.d("leak-70-72", dataLeAk70);
		android.util.Log.d("leak-71-72", dataLeAk71);
		android.util.Log.d("leak-72-72", dataLeAk72);
		android.util.Log.d("leak-73-72", dataLeAk73);
		android.util.Log.d("leak-74-72", dataLeAk74);
		android.util.Log.d("leak-75-72", dataLeAk75);
		android.util.Log.d("leak-76-72", dataLeAk76);
		android.util.Log.d("leak-77-72", dataLeAk77);
		android.util.Log.d("leak-79-72", dataLeAk79);
		android.util.Log.d("leak-80-72", dataLeAk80);
		android.util.Log.d("leak-81-72", dataLeAk81);
		android.util.Log.d("leak-83-72", dataLeAk83);
		android.util.Log.d("leak-85-72", dataLeAk85);
		android.util.Log.d("leak-86-72", dataLeAk86);
		android.util.Log.d("leak-87-72", dataLeAk87);
		android.util.Log.d("leak-88-72", dataLeAk88);
		android.util.Log.d("leak-89-72", dataLeAk89);
		android.util.Log.d("leak-90-72", dataLeAk90);
		android.util.Log.d("leak-91-72", dataLeAk91);
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
		dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-53-73", dataLeAk53);
		android.util.Log.d("leak-54-73", dataLeAk54);
		android.util.Log.d("leak-55-73", dataLeAk55);
		android.util.Log.d("leak-57-73", dataLeAk57);
		android.util.Log.d("leak-59-73", dataLeAk59);
		android.util.Log.d("leak-61-73", dataLeAk61);
		android.util.Log.d("leak-62-73", dataLeAk62);
		android.util.Log.d("leak-63-73", dataLeAk63);
		android.util.Log.d("leak-64-73", dataLeAk64);
		android.util.Log.d("leak-65-73", dataLeAk65);
		android.util.Log.d("leak-66-73", dataLeAk66);
		android.util.Log.d("leak-67-73", dataLeAk67);
		android.util.Log.d("leak-68-73", dataLeAk68);
		android.util.Log.d("leak-69-73", dataLeAk69);
		android.util.Log.d("leak-70-73", dataLeAk70);
		android.util.Log.d("leak-71-73", dataLeAk71);
		android.util.Log.d("leak-72-73", dataLeAk72);
		android.util.Log.d("leak-73-73", dataLeAk73);
		android.util.Log.d("leak-74-73", dataLeAk74);
		android.util.Log.d("leak-75-73", dataLeAk75);
		android.util.Log.d("leak-76-73", dataLeAk76);
		android.util.Log.d("leak-77-73", dataLeAk77);
		android.util.Log.d("leak-79-73", dataLeAk79);
		android.util.Log.d("leak-80-73", dataLeAk80);
		android.util.Log.d("leak-81-73", dataLeAk81);
		android.util.Log.d("leak-83-73", dataLeAk83);
		android.util.Log.d("leak-85-73", dataLeAk85);
		android.util.Log.d("leak-86-73", dataLeAk86);
		android.util.Log.d("leak-87-73", dataLeAk87);
		android.util.Log.d("leak-88-73", dataLeAk88);
		android.util.Log.d("leak-89-73", dataLeAk89);
		android.util.Log.d("leak-90-73", dataLeAk90);
		android.util.Log.d("leak-91-73", dataLeAk91);
		android.util.Log.d("leak-53-73", dataLeAk53);
		android.util.Log.d("leak-54-73", dataLeAk54);
		android.util.Log.d("leak-55-73", dataLeAk55);
		android.util.Log.d("leak-57-73", dataLeAk57);
		android.util.Log.d("leak-59-73", dataLeAk59);
		android.util.Log.d("leak-61-73", dataLeAk61);
		android.util.Log.d("leak-62-73", dataLeAk62);
		android.util.Log.d("leak-63-73", dataLeAk63);
		android.util.Log.d("leak-64-73", dataLeAk64);
		android.util.Log.d("leak-65-73", dataLeAk65);
		android.util.Log.d("leak-66-73", dataLeAk66);
		android.util.Log.d("leak-67-73", dataLeAk67);
		android.util.Log.d("leak-68-73", dataLeAk68);
		android.util.Log.d("leak-69-73", dataLeAk69);
		android.util.Log.d("leak-70-73", dataLeAk70);
		android.util.Log.d("leak-71-73", dataLeAk71);
		android.util.Log.d("leak-72-73", dataLeAk72);
		android.util.Log.d("leak-73-73", dataLeAk73);
		android.util.Log.d("leak-74-73", dataLeAk74);
		android.util.Log.d("leak-75-73", dataLeAk75);
		android.util.Log.d("leak-76-73", dataLeAk76);
		android.util.Log.d("leak-77-73", dataLeAk77);
		android.util.Log.d("leak-79-73", dataLeAk79);
		android.util.Log.d("leak-80-73", dataLeAk80);
		android.util.Log.d("leak-81-73", dataLeAk81);
		android.util.Log.d("leak-83-73", dataLeAk83);
		android.util.Log.d("leak-85-73", dataLeAk85);
		android.util.Log.d("leak-86-73", dataLeAk86);
		android.util.Log.d("leak-87-73", dataLeAk87);
		android.util.Log.d("leak-88-73", dataLeAk88);
		android.util.Log.d("leak-89-73", dataLeAk89);
		android.util.Log.d("leak-90-73", dataLeAk90);
		android.util.Log.d("leak-91-73", dataLeAk91);
		android.util.Log.d("leak-53-73", dataLeAk53);
		android.util.Log.d("leak-54-73", dataLeAk54);
		android.util.Log.d("leak-55-73", dataLeAk55);
		android.util.Log.d("leak-57-73", dataLeAk57);
		android.util.Log.d("leak-59-73", dataLeAk59);
		android.util.Log.d("leak-61-73", dataLeAk61);
		android.util.Log.d("leak-62-73", dataLeAk62);
		android.util.Log.d("leak-63-73", dataLeAk63);
		android.util.Log.d("leak-64-73", dataLeAk64);
		android.util.Log.d("leak-65-73", dataLeAk65);
		android.util.Log.d("leak-66-73", dataLeAk66);
		android.util.Log.d("leak-67-73", dataLeAk67);
		android.util.Log.d("leak-68-73", dataLeAk68);
		android.util.Log.d("leak-69-73", dataLeAk69);
		android.util.Log.d("leak-70-73", dataLeAk70);
		android.util.Log.d("leak-71-73", dataLeAk71);
		android.util.Log.d("leak-72-73", dataLeAk72);
		android.util.Log.d("leak-73-73", dataLeAk73);
		android.util.Log.d("leak-74-73", dataLeAk74);
		android.util.Log.d("leak-75-73", dataLeAk75);
		android.util.Log.d("leak-76-73", dataLeAk76);
		android.util.Log.d("leak-77-73", dataLeAk77);
		android.util.Log.d("leak-79-73", dataLeAk79);
		android.util.Log.d("leak-80-73", dataLeAk80);
		android.util.Log.d("leak-81-73", dataLeAk81);
		android.util.Log.d("leak-83-73", dataLeAk83);
		android.util.Log.d("leak-85-73", dataLeAk85);
		android.util.Log.d("leak-86-73", dataLeAk86);
		android.util.Log.d("leak-87-73", dataLeAk87);
		android.util.Log.d("leak-88-73", dataLeAk88);
		android.util.Log.d("leak-89-73", dataLeAk89);
		android.util.Log.d("leak-90-73", dataLeAk90);
		android.util.Log.d("leak-91-73", dataLeAk91);
		android.util.Log.d("leak-54-73", dataLeAk54);
		android.util.Log.d("leak-55-73", dataLeAk55);
		android.util.Log.d("leak-57-73", dataLeAk57);
		android.util.Log.d("leak-59-73", dataLeAk59);
		android.util.Log.d("leak-61-73", dataLeAk61);
		android.util.Log.d("leak-62-73", dataLeAk62);
		android.util.Log.d("leak-63-73", dataLeAk63);
		android.util.Log.d("leak-64-73", dataLeAk64);
		android.util.Log.d("leak-65-73", dataLeAk65);
		android.util.Log.d("leak-66-73", dataLeAk66);
		android.util.Log.d("leak-67-73", dataLeAk67);
		android.util.Log.d("leak-68-73", dataLeAk68);
		android.util.Log.d("leak-69-73", dataLeAk69);
		android.util.Log.d("leak-70-73", dataLeAk70);
		android.util.Log.d("leak-71-73", dataLeAk71);
		android.util.Log.d("leak-72-73", dataLeAk72);
		android.util.Log.d("leak-73-73", dataLeAk73);
		android.util.Log.d("leak-74-73", dataLeAk74);
		android.util.Log.d("leak-75-73", dataLeAk75);
		android.util.Log.d("leak-76-73", dataLeAk76);
		android.util.Log.d("leak-77-73", dataLeAk77);
		android.util.Log.d("leak-79-73", dataLeAk79);
		android.util.Log.d("leak-80-73", dataLeAk80);
		android.util.Log.d("leak-81-73", dataLeAk81);
		android.util.Log.d("leak-83-73", dataLeAk83);
		android.util.Log.d("leak-85-73", dataLeAk85);
		android.util.Log.d("leak-86-73", dataLeAk86);
		android.util.Log.d("leak-87-73", dataLeAk87);
		android.util.Log.d("leak-88-73", dataLeAk88);
		android.util.Log.d("leak-89-73", dataLeAk89);
		android.util.Log.d("leak-90-73", dataLeAk90);
		android.util.Log.d("leak-91-73", dataLeAk91);

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
		dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-53-74", dataLeAk53);
		android.util.Log.d("leak-54-74", dataLeAk54);
		android.util.Log.d("leak-55-74", dataLeAk55);
		android.util.Log.d("leak-57-74", dataLeAk57);
		android.util.Log.d("leak-59-74", dataLeAk59);
		android.util.Log.d("leak-61-74", dataLeAk61);
		android.util.Log.d("leak-62-74", dataLeAk62);
		android.util.Log.d("leak-63-74", dataLeAk63);
		android.util.Log.d("leak-64-74", dataLeAk64);
		android.util.Log.d("leak-65-74", dataLeAk65);
		android.util.Log.d("leak-66-74", dataLeAk66);
		android.util.Log.d("leak-67-74", dataLeAk67);
		android.util.Log.d("leak-68-74", dataLeAk68);
		android.util.Log.d("leak-69-74", dataLeAk69);
		android.util.Log.d("leak-70-74", dataLeAk70);
		android.util.Log.d("leak-71-74", dataLeAk71);
		android.util.Log.d("leak-72-74", dataLeAk72);
		android.util.Log.d("leak-73-74", dataLeAk73);
		android.util.Log.d("leak-74-74", dataLeAk74);
		android.util.Log.d("leak-75-74", dataLeAk75);
		android.util.Log.d("leak-76-74", dataLeAk76);
		android.util.Log.d("leak-77-74", dataLeAk77);
		android.util.Log.d("leak-79-74", dataLeAk79);
		android.util.Log.d("leak-80-74", dataLeAk80);
		android.util.Log.d("leak-81-74", dataLeAk81);
		android.util.Log.d("leak-83-74", dataLeAk83);
		android.util.Log.d("leak-85-74", dataLeAk85);
		android.util.Log.d("leak-86-74", dataLeAk86);
		android.util.Log.d("leak-87-74", dataLeAk87);
		android.util.Log.d("leak-88-74", dataLeAk88);
		android.util.Log.d("leak-89-74", dataLeAk89);
		android.util.Log.d("leak-90-74", dataLeAk90);
		android.util.Log.d("leak-91-74", dataLeAk91);
		android.util.Log.d("leak-53-74", dataLeAk53);
		android.util.Log.d("leak-54-74", dataLeAk54);
		android.util.Log.d("leak-55-74", dataLeAk55);
		android.util.Log.d("leak-57-74", dataLeAk57);
		android.util.Log.d("leak-59-74", dataLeAk59);
		android.util.Log.d("leak-61-74", dataLeAk61);
		android.util.Log.d("leak-62-74", dataLeAk62);
		android.util.Log.d("leak-63-74", dataLeAk63);
		android.util.Log.d("leak-64-74", dataLeAk64);
		android.util.Log.d("leak-65-74", dataLeAk65);
		android.util.Log.d("leak-66-74", dataLeAk66);
		android.util.Log.d("leak-67-74", dataLeAk67);
		android.util.Log.d("leak-68-74", dataLeAk68);
		android.util.Log.d("leak-69-74", dataLeAk69);
		android.util.Log.d("leak-70-74", dataLeAk70);
		android.util.Log.d("leak-71-74", dataLeAk71);
		android.util.Log.d("leak-72-74", dataLeAk72);
		android.util.Log.d("leak-73-74", dataLeAk73);
		android.util.Log.d("leak-74-74", dataLeAk74);
		android.util.Log.d("leak-75-74", dataLeAk75);
		android.util.Log.d("leak-76-74", dataLeAk76);
		android.util.Log.d("leak-77-74", dataLeAk77);
		android.util.Log.d("leak-79-74", dataLeAk79);
		android.util.Log.d("leak-80-74", dataLeAk80);
		android.util.Log.d("leak-81-74", dataLeAk81);
		android.util.Log.d("leak-83-74", dataLeAk83);
		android.util.Log.d("leak-85-74", dataLeAk85);
		android.util.Log.d("leak-86-74", dataLeAk86);
		android.util.Log.d("leak-87-74", dataLeAk87);
		android.util.Log.d("leak-88-74", dataLeAk88);
		android.util.Log.d("leak-89-74", dataLeAk89);
		android.util.Log.d("leak-90-74", dataLeAk90);
		android.util.Log.d("leak-91-74", dataLeAk91);
		android.util.Log.d("leak-53-74", dataLeAk53);
		android.util.Log.d("leak-54-74", dataLeAk54);
		android.util.Log.d("leak-55-74", dataLeAk55);
		android.util.Log.d("leak-57-74", dataLeAk57);
		android.util.Log.d("leak-59-74", dataLeAk59);
		android.util.Log.d("leak-61-74", dataLeAk61);
		android.util.Log.d("leak-62-74", dataLeAk62);
		android.util.Log.d("leak-63-74", dataLeAk63);
		android.util.Log.d("leak-64-74", dataLeAk64);
		android.util.Log.d("leak-65-74", dataLeAk65);
		android.util.Log.d("leak-66-74", dataLeAk66);
		android.util.Log.d("leak-67-74", dataLeAk67);
		android.util.Log.d("leak-68-74", dataLeAk68);
		android.util.Log.d("leak-69-74", dataLeAk69);
		android.util.Log.d("leak-70-74", dataLeAk70);
		android.util.Log.d("leak-71-74", dataLeAk71);
		android.util.Log.d("leak-72-74", dataLeAk72);
		android.util.Log.d("leak-73-74", dataLeAk73);
		android.util.Log.d("leak-74-74", dataLeAk74);
		android.util.Log.d("leak-75-74", dataLeAk75);
		android.util.Log.d("leak-76-74", dataLeAk76);
		android.util.Log.d("leak-77-74", dataLeAk77);
		android.util.Log.d("leak-79-74", dataLeAk79);
		android.util.Log.d("leak-80-74", dataLeAk80);
		android.util.Log.d("leak-81-74", dataLeAk81);
		android.util.Log.d("leak-83-74", dataLeAk83);
		android.util.Log.d("leak-85-74", dataLeAk85);
		android.util.Log.d("leak-86-74", dataLeAk86);
		android.util.Log.d("leak-87-74", dataLeAk87);
		android.util.Log.d("leak-88-74", dataLeAk88);
		android.util.Log.d("leak-89-74", dataLeAk89);
		android.util.Log.d("leak-90-74", dataLeAk90);
		android.util.Log.d("leak-91-74", dataLeAk91);
		android.util.Log.d("leak-54-74", dataLeAk54);
		android.util.Log.d("leak-55-74", dataLeAk55);
		android.util.Log.d("leak-57-74", dataLeAk57);
		android.util.Log.d("leak-59-74", dataLeAk59);
		android.util.Log.d("leak-61-74", dataLeAk61);
		android.util.Log.d("leak-62-74", dataLeAk62);
		android.util.Log.d("leak-63-74", dataLeAk63);
		android.util.Log.d("leak-64-74", dataLeAk64);
		android.util.Log.d("leak-65-74", dataLeAk65);
		android.util.Log.d("leak-66-74", dataLeAk66);
		android.util.Log.d("leak-67-74", dataLeAk67);
		android.util.Log.d("leak-68-74", dataLeAk68);
		android.util.Log.d("leak-69-74", dataLeAk69);
		android.util.Log.d("leak-70-74", dataLeAk70);
		android.util.Log.d("leak-71-74", dataLeAk71);
		android.util.Log.d("leak-72-74", dataLeAk72);
		android.util.Log.d("leak-73-74", dataLeAk73);
		android.util.Log.d("leak-74-74", dataLeAk74);
		android.util.Log.d("leak-75-74", dataLeAk75);
		android.util.Log.d("leak-76-74", dataLeAk76);
		android.util.Log.d("leak-77-74", dataLeAk77);
		android.util.Log.d("leak-79-74", dataLeAk79);
		android.util.Log.d("leak-80-74", dataLeAk80);
		android.util.Log.d("leak-81-74", dataLeAk81);
		android.util.Log.d("leak-83-74", dataLeAk83);
		android.util.Log.d("leak-85-74", dataLeAk85);
		android.util.Log.d("leak-86-74", dataLeAk86);
		android.util.Log.d("leak-87-74", dataLeAk87);
		android.util.Log.d("leak-88-74", dataLeAk88);
		android.util.Log.d("leak-89-74", dataLeAk89);
		android.util.Log.d("leak-90-74", dataLeAk90);
		android.util.Log.d("leak-91-74", dataLeAk91);
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
		dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-53-75", dataLeAk53);
		android.util.Log.d("leak-54-75", dataLeAk54);
		android.util.Log.d("leak-55-75", dataLeAk55);
		android.util.Log.d("leak-57-75", dataLeAk57);
		android.util.Log.d("leak-59-75", dataLeAk59);
		android.util.Log.d("leak-61-75", dataLeAk61);
		android.util.Log.d("leak-62-75", dataLeAk62);
		android.util.Log.d("leak-63-75", dataLeAk63);
		android.util.Log.d("leak-64-75", dataLeAk64);
		android.util.Log.d("leak-65-75", dataLeAk65);
		android.util.Log.d("leak-66-75", dataLeAk66);
		android.util.Log.d("leak-67-75", dataLeAk67);
		android.util.Log.d("leak-68-75", dataLeAk68);
		android.util.Log.d("leak-69-75", dataLeAk69);
		android.util.Log.d("leak-70-75", dataLeAk70);
		android.util.Log.d("leak-71-75", dataLeAk71);
		android.util.Log.d("leak-72-75", dataLeAk72);
		android.util.Log.d("leak-73-75", dataLeAk73);
		android.util.Log.d("leak-74-75", dataLeAk74);
		android.util.Log.d("leak-75-75", dataLeAk75);
		android.util.Log.d("leak-76-75", dataLeAk76);
		android.util.Log.d("leak-77-75", dataLeAk77);
		android.util.Log.d("leak-79-75", dataLeAk79);
		android.util.Log.d("leak-80-75", dataLeAk80);
		android.util.Log.d("leak-81-75", dataLeAk81);
		android.util.Log.d("leak-83-75", dataLeAk83);
		android.util.Log.d("leak-85-75", dataLeAk85);
		android.util.Log.d("leak-86-75", dataLeAk86);
		android.util.Log.d("leak-87-75", dataLeAk87);
		android.util.Log.d("leak-88-75", dataLeAk88);
		android.util.Log.d("leak-89-75", dataLeAk89);
		android.util.Log.d("leak-90-75", dataLeAk90);
		android.util.Log.d("leak-91-75", dataLeAk91);
		android.util.Log.d("leak-53-75", dataLeAk53);
		android.util.Log.d("leak-54-75", dataLeAk54);
		android.util.Log.d("leak-55-75", dataLeAk55);
		android.util.Log.d("leak-57-75", dataLeAk57);
		android.util.Log.d("leak-59-75", dataLeAk59);
		android.util.Log.d("leak-61-75", dataLeAk61);
		android.util.Log.d("leak-62-75", dataLeAk62);
		android.util.Log.d("leak-63-75", dataLeAk63);
		android.util.Log.d("leak-64-75", dataLeAk64);
		android.util.Log.d("leak-65-75", dataLeAk65);
		android.util.Log.d("leak-66-75", dataLeAk66);
		android.util.Log.d("leak-67-75", dataLeAk67);
		android.util.Log.d("leak-68-75", dataLeAk68);
		android.util.Log.d("leak-69-75", dataLeAk69);
		android.util.Log.d("leak-70-75", dataLeAk70);
		android.util.Log.d("leak-71-75", dataLeAk71);
		android.util.Log.d("leak-72-75", dataLeAk72);
		android.util.Log.d("leak-73-75", dataLeAk73);
		android.util.Log.d("leak-74-75", dataLeAk74);
		android.util.Log.d("leak-75-75", dataLeAk75);
		android.util.Log.d("leak-76-75", dataLeAk76);
		android.util.Log.d("leak-77-75", dataLeAk77);
		android.util.Log.d("leak-79-75", dataLeAk79);
		android.util.Log.d("leak-80-75", dataLeAk80);
		android.util.Log.d("leak-81-75", dataLeAk81);
		android.util.Log.d("leak-83-75", dataLeAk83);
		android.util.Log.d("leak-85-75", dataLeAk85);
		android.util.Log.d("leak-86-75", dataLeAk86);
		android.util.Log.d("leak-87-75", dataLeAk87);
		android.util.Log.d("leak-88-75", dataLeAk88);
		android.util.Log.d("leak-89-75", dataLeAk89);
		android.util.Log.d("leak-90-75", dataLeAk90);
		android.util.Log.d("leak-91-75", dataLeAk91);
		android.util.Log.d("leak-53-75", dataLeAk53);
		android.util.Log.d("leak-54-75", dataLeAk54);
		android.util.Log.d("leak-55-75", dataLeAk55);
		android.util.Log.d("leak-57-75", dataLeAk57);
		android.util.Log.d("leak-59-75", dataLeAk59);
		android.util.Log.d("leak-61-75", dataLeAk61);
		android.util.Log.d("leak-62-75", dataLeAk62);
		android.util.Log.d("leak-63-75", dataLeAk63);
		android.util.Log.d("leak-64-75", dataLeAk64);
		android.util.Log.d("leak-65-75", dataLeAk65);
		android.util.Log.d("leak-66-75", dataLeAk66);
		android.util.Log.d("leak-67-75", dataLeAk67);
		android.util.Log.d("leak-68-75", dataLeAk68);
		android.util.Log.d("leak-69-75", dataLeAk69);
		android.util.Log.d("leak-70-75", dataLeAk70);
		android.util.Log.d("leak-71-75", dataLeAk71);
		android.util.Log.d("leak-72-75", dataLeAk72);
		android.util.Log.d("leak-73-75", dataLeAk73);
		android.util.Log.d("leak-74-75", dataLeAk74);
		android.util.Log.d("leak-75-75", dataLeAk75);
		android.util.Log.d("leak-76-75", dataLeAk76);
		android.util.Log.d("leak-77-75", dataLeAk77);
		android.util.Log.d("leak-79-75", dataLeAk79);
		android.util.Log.d("leak-80-75", dataLeAk80);
		android.util.Log.d("leak-81-75", dataLeAk81);
		android.util.Log.d("leak-83-75", dataLeAk83);
		android.util.Log.d("leak-85-75", dataLeAk85);
		android.util.Log.d("leak-86-75", dataLeAk86);
		android.util.Log.d("leak-87-75", dataLeAk87);
		android.util.Log.d("leak-88-75", dataLeAk88);
		android.util.Log.d("leak-89-75", dataLeAk89);
		android.util.Log.d("leak-90-75", dataLeAk90);
		android.util.Log.d("leak-91-75", dataLeAk91);
		android.util.Log.d("leak-54-75", dataLeAk54);
		android.util.Log.d("leak-55-75", dataLeAk55);
		android.util.Log.d("leak-57-75", dataLeAk57);
		android.util.Log.d("leak-59-75", dataLeAk59);
		android.util.Log.d("leak-61-75", dataLeAk61);
		android.util.Log.d("leak-62-75", dataLeAk62);
		android.util.Log.d("leak-63-75", dataLeAk63);
		android.util.Log.d("leak-64-75", dataLeAk64);
		android.util.Log.d("leak-65-75", dataLeAk65);
		android.util.Log.d("leak-66-75", dataLeAk66);
		android.util.Log.d("leak-67-75", dataLeAk67);
		android.util.Log.d("leak-68-75", dataLeAk68);
		android.util.Log.d("leak-69-75", dataLeAk69);
		android.util.Log.d("leak-70-75", dataLeAk70);
		android.util.Log.d("leak-71-75", dataLeAk71);
		android.util.Log.d("leak-72-75", dataLeAk72);
		android.util.Log.d("leak-73-75", dataLeAk73);
		android.util.Log.d("leak-74-75", dataLeAk74);
		android.util.Log.d("leak-75-75", dataLeAk75);
		android.util.Log.d("leak-76-75", dataLeAk76);
		android.util.Log.d("leak-77-75", dataLeAk77);
		android.util.Log.d("leak-79-75", dataLeAk79);
		android.util.Log.d("leak-80-75", dataLeAk80);
		android.util.Log.d("leak-81-75", dataLeAk81);
		android.util.Log.d("leak-83-75", dataLeAk83);
		android.util.Log.d("leak-85-75", dataLeAk85);
		android.util.Log.d("leak-86-75", dataLeAk86);
		android.util.Log.d("leak-87-75", dataLeAk87);
		android.util.Log.d("leak-88-75", dataLeAk88);
		android.util.Log.d("leak-89-75", dataLeAk89);
		android.util.Log.d("leak-90-75", dataLeAk90);
		android.util.Log.d("leak-91-75", dataLeAk91);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
		dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-53-76", dataLeAk53);
		android.util.Log.d("leak-54-76", dataLeAk54);
		android.util.Log.d("leak-55-76", dataLeAk55);
		android.util.Log.d("leak-57-76", dataLeAk57);
		android.util.Log.d("leak-59-76", dataLeAk59);
		android.util.Log.d("leak-61-76", dataLeAk61);
		android.util.Log.d("leak-62-76", dataLeAk62);
		android.util.Log.d("leak-63-76", dataLeAk63);
		android.util.Log.d("leak-64-76", dataLeAk64);
		android.util.Log.d("leak-65-76", dataLeAk65);
		android.util.Log.d("leak-66-76", dataLeAk66);
		android.util.Log.d("leak-67-76", dataLeAk67);
		android.util.Log.d("leak-68-76", dataLeAk68);
		android.util.Log.d("leak-69-76", dataLeAk69);
		android.util.Log.d("leak-70-76", dataLeAk70);
		android.util.Log.d("leak-71-76", dataLeAk71);
		android.util.Log.d("leak-72-76", dataLeAk72);
		android.util.Log.d("leak-73-76", dataLeAk73);
		android.util.Log.d("leak-74-76", dataLeAk74);
		android.util.Log.d("leak-75-76", dataLeAk75);
		android.util.Log.d("leak-76-76", dataLeAk76);
		android.util.Log.d("leak-77-76", dataLeAk77);
		android.util.Log.d("leak-79-76", dataLeAk79);
		android.util.Log.d("leak-80-76", dataLeAk80);
		android.util.Log.d("leak-81-76", dataLeAk81);
		android.util.Log.d("leak-83-76", dataLeAk83);
		android.util.Log.d("leak-85-76", dataLeAk85);
		android.util.Log.d("leak-86-76", dataLeAk86);
		android.util.Log.d("leak-87-76", dataLeAk87);
		android.util.Log.d("leak-88-76", dataLeAk88);
		android.util.Log.d("leak-89-76", dataLeAk89);
		android.util.Log.d("leak-90-76", dataLeAk90);
		android.util.Log.d("leak-91-76", dataLeAk91);
		android.util.Log.d("leak-53-76", dataLeAk53);
		android.util.Log.d("leak-54-76", dataLeAk54);
		android.util.Log.d("leak-55-76", dataLeAk55);
		android.util.Log.d("leak-57-76", dataLeAk57);
		android.util.Log.d("leak-59-76", dataLeAk59);
		android.util.Log.d("leak-61-76", dataLeAk61);
		android.util.Log.d("leak-62-76", dataLeAk62);
		android.util.Log.d("leak-63-76", dataLeAk63);
		android.util.Log.d("leak-64-76", dataLeAk64);
		android.util.Log.d("leak-65-76", dataLeAk65);
		android.util.Log.d("leak-66-76", dataLeAk66);
		android.util.Log.d("leak-67-76", dataLeAk67);
		android.util.Log.d("leak-68-76", dataLeAk68);
		android.util.Log.d("leak-69-76", dataLeAk69);
		android.util.Log.d("leak-70-76", dataLeAk70);
		android.util.Log.d("leak-71-76", dataLeAk71);
		android.util.Log.d("leak-72-76", dataLeAk72);
		android.util.Log.d("leak-73-76", dataLeAk73);
		android.util.Log.d("leak-74-76", dataLeAk74);
		android.util.Log.d("leak-75-76", dataLeAk75);
		android.util.Log.d("leak-76-76", dataLeAk76);
		android.util.Log.d("leak-77-76", dataLeAk77);
		android.util.Log.d("leak-79-76", dataLeAk79);
		android.util.Log.d("leak-80-76", dataLeAk80);
		android.util.Log.d("leak-81-76", dataLeAk81);
		android.util.Log.d("leak-83-76", dataLeAk83);
		android.util.Log.d("leak-85-76", dataLeAk85);
		android.util.Log.d("leak-86-76", dataLeAk86);
		android.util.Log.d("leak-87-76", dataLeAk87);
		android.util.Log.d("leak-88-76", dataLeAk88);
		android.util.Log.d("leak-89-76", dataLeAk89);
		android.util.Log.d("leak-90-76", dataLeAk90);
		android.util.Log.d("leak-91-76", dataLeAk91);
		android.util.Log.d("leak-53-76", dataLeAk53);
		android.util.Log.d("leak-54-76", dataLeAk54);
		android.util.Log.d("leak-55-76", dataLeAk55);
		android.util.Log.d("leak-57-76", dataLeAk57);
		android.util.Log.d("leak-59-76", dataLeAk59);
		android.util.Log.d("leak-61-76", dataLeAk61);
		android.util.Log.d("leak-62-76", dataLeAk62);
		android.util.Log.d("leak-63-76", dataLeAk63);
		android.util.Log.d("leak-64-76", dataLeAk64);
		android.util.Log.d("leak-65-76", dataLeAk65);
		android.util.Log.d("leak-66-76", dataLeAk66);
		android.util.Log.d("leak-67-76", dataLeAk67);
		android.util.Log.d("leak-68-76", dataLeAk68);
		android.util.Log.d("leak-69-76", dataLeAk69);
		android.util.Log.d("leak-70-76", dataLeAk70);
		android.util.Log.d("leak-71-76", dataLeAk71);
		android.util.Log.d("leak-72-76", dataLeAk72);
		android.util.Log.d("leak-73-76", dataLeAk73);
		android.util.Log.d("leak-74-76", dataLeAk74);
		android.util.Log.d("leak-75-76", dataLeAk75);
		android.util.Log.d("leak-76-76", dataLeAk76);
		android.util.Log.d("leak-77-76", dataLeAk77);
		android.util.Log.d("leak-79-76", dataLeAk79);
		android.util.Log.d("leak-80-76", dataLeAk80);
		android.util.Log.d("leak-81-76", dataLeAk81);
		android.util.Log.d("leak-83-76", dataLeAk83);
		android.util.Log.d("leak-85-76", dataLeAk85);
		android.util.Log.d("leak-86-76", dataLeAk86);
		android.util.Log.d("leak-87-76", dataLeAk87);
		android.util.Log.d("leak-88-76", dataLeAk88);
		android.util.Log.d("leak-89-76", dataLeAk89);
		android.util.Log.d("leak-90-76", dataLeAk90);
		android.util.Log.d("leak-91-76", dataLeAk91);
		android.util.Log.d("leak-54-76", dataLeAk54);
		android.util.Log.d("leak-55-76", dataLeAk55);
		android.util.Log.d("leak-57-76", dataLeAk57);
		android.util.Log.d("leak-59-76", dataLeAk59);
		android.util.Log.d("leak-61-76", dataLeAk61);
		android.util.Log.d("leak-62-76", dataLeAk62);
		android.util.Log.d("leak-63-76", dataLeAk63);
		android.util.Log.d("leak-64-76", dataLeAk64);
		android.util.Log.d("leak-65-76", dataLeAk65);
		android.util.Log.d("leak-66-76", dataLeAk66);
		android.util.Log.d("leak-67-76", dataLeAk67);
		android.util.Log.d("leak-68-76", dataLeAk68);
		android.util.Log.d("leak-69-76", dataLeAk69);
		android.util.Log.d("leak-70-76", dataLeAk70);
		android.util.Log.d("leak-71-76", dataLeAk71);
		android.util.Log.d("leak-72-76", dataLeAk72);
		android.util.Log.d("leak-73-76", dataLeAk73);
		android.util.Log.d("leak-74-76", dataLeAk74);
		android.util.Log.d("leak-75-76", dataLeAk75);
		android.util.Log.d("leak-76-76", dataLeAk76);
		android.util.Log.d("leak-77-76", dataLeAk77);
		android.util.Log.d("leak-79-76", dataLeAk79);
		android.util.Log.d("leak-80-76", dataLeAk80);
		android.util.Log.d("leak-81-76", dataLeAk81);
		android.util.Log.d("leak-83-76", dataLeAk83);
		android.util.Log.d("leak-85-76", dataLeAk85);
		android.util.Log.d("leak-86-76", dataLeAk86);
		android.util.Log.d("leak-87-76", dataLeAk87);
		android.util.Log.d("leak-88-76", dataLeAk88);
		android.util.Log.d("leak-89-76", dataLeAk89);
		android.util.Log.d("leak-90-76", dataLeAk90);
		android.util.Log.d("leak-91-76", dataLeAk91);

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
		dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-53-77", dataLeAk53);
		android.util.Log.d("leak-54-77", dataLeAk54);
		android.util.Log.d("leak-55-77", dataLeAk55);
		android.util.Log.d("leak-57-77", dataLeAk57);
		android.util.Log.d("leak-59-77", dataLeAk59);
		android.util.Log.d("leak-61-77", dataLeAk61);
		android.util.Log.d("leak-62-77", dataLeAk62);
		android.util.Log.d("leak-63-77", dataLeAk63);
		android.util.Log.d("leak-64-77", dataLeAk64);
		android.util.Log.d("leak-65-77", dataLeAk65);
		android.util.Log.d("leak-66-77", dataLeAk66);
		android.util.Log.d("leak-67-77", dataLeAk67);
		android.util.Log.d("leak-68-77", dataLeAk68);
		android.util.Log.d("leak-69-77", dataLeAk69);
		android.util.Log.d("leak-70-77", dataLeAk70);
		android.util.Log.d("leak-71-77", dataLeAk71);
		android.util.Log.d("leak-72-77", dataLeAk72);
		android.util.Log.d("leak-73-77", dataLeAk73);
		android.util.Log.d("leak-74-77", dataLeAk74);
		android.util.Log.d("leak-75-77", dataLeAk75);
		android.util.Log.d("leak-76-77", dataLeAk76);
		android.util.Log.d("leak-77-77", dataLeAk77);
		android.util.Log.d("leak-79-77", dataLeAk79);
		android.util.Log.d("leak-80-77", dataLeAk80);
		android.util.Log.d("leak-81-77", dataLeAk81);
		android.util.Log.d("leak-83-77", dataLeAk83);
		android.util.Log.d("leak-85-77", dataLeAk85);
		android.util.Log.d("leak-86-77", dataLeAk86);
		android.util.Log.d("leak-87-77", dataLeAk87);
		android.util.Log.d("leak-88-77", dataLeAk88);
		android.util.Log.d("leak-89-77", dataLeAk89);
		android.util.Log.d("leak-90-77", dataLeAk90);
		android.util.Log.d("leak-91-77", dataLeAk91);
		android.util.Log.d("leak-53-77", dataLeAk53);
		android.util.Log.d("leak-54-77", dataLeAk54);
		android.util.Log.d("leak-55-77", dataLeAk55);
		android.util.Log.d("leak-57-77", dataLeAk57);
		android.util.Log.d("leak-59-77", dataLeAk59);
		android.util.Log.d("leak-61-77", dataLeAk61);
		android.util.Log.d("leak-62-77", dataLeAk62);
		android.util.Log.d("leak-63-77", dataLeAk63);
		android.util.Log.d("leak-64-77", dataLeAk64);
		android.util.Log.d("leak-65-77", dataLeAk65);
		android.util.Log.d("leak-66-77", dataLeAk66);
		android.util.Log.d("leak-67-77", dataLeAk67);
		android.util.Log.d("leak-68-77", dataLeAk68);
		android.util.Log.d("leak-69-77", dataLeAk69);
		android.util.Log.d("leak-70-77", dataLeAk70);
		android.util.Log.d("leak-71-77", dataLeAk71);
		android.util.Log.d("leak-72-77", dataLeAk72);
		android.util.Log.d("leak-73-77", dataLeAk73);
		android.util.Log.d("leak-74-77", dataLeAk74);
		android.util.Log.d("leak-75-77", dataLeAk75);
		android.util.Log.d("leak-76-77", dataLeAk76);
		android.util.Log.d("leak-77-77", dataLeAk77);
		android.util.Log.d("leak-79-77", dataLeAk79);
		android.util.Log.d("leak-80-77", dataLeAk80);
		android.util.Log.d("leak-81-77", dataLeAk81);
		android.util.Log.d("leak-83-77", dataLeAk83);
		android.util.Log.d("leak-85-77", dataLeAk85);
		android.util.Log.d("leak-86-77", dataLeAk86);
		android.util.Log.d("leak-87-77", dataLeAk87);
		android.util.Log.d("leak-88-77", dataLeAk88);
		android.util.Log.d("leak-89-77", dataLeAk89);
		android.util.Log.d("leak-90-77", dataLeAk90);
		android.util.Log.d("leak-91-77", dataLeAk91);
		android.util.Log.d("leak-53-77", dataLeAk53);
		android.util.Log.d("leak-54-77", dataLeAk54);
		android.util.Log.d("leak-55-77", dataLeAk55);
		android.util.Log.d("leak-57-77", dataLeAk57);
		android.util.Log.d("leak-59-77", dataLeAk59);
		android.util.Log.d("leak-61-77", dataLeAk61);
		android.util.Log.d("leak-62-77", dataLeAk62);
		android.util.Log.d("leak-63-77", dataLeAk63);
		android.util.Log.d("leak-64-77", dataLeAk64);
		android.util.Log.d("leak-65-77", dataLeAk65);
		android.util.Log.d("leak-66-77", dataLeAk66);
		android.util.Log.d("leak-67-77", dataLeAk67);
		android.util.Log.d("leak-68-77", dataLeAk68);
		android.util.Log.d("leak-69-77", dataLeAk69);
		android.util.Log.d("leak-70-77", dataLeAk70);
		android.util.Log.d("leak-71-77", dataLeAk71);
		android.util.Log.d("leak-72-77", dataLeAk72);
		android.util.Log.d("leak-73-77", dataLeAk73);
		android.util.Log.d("leak-74-77", dataLeAk74);
		android.util.Log.d("leak-75-77", dataLeAk75);
		android.util.Log.d("leak-76-77", dataLeAk76);
		android.util.Log.d("leak-77-77", dataLeAk77);
		android.util.Log.d("leak-79-77", dataLeAk79);
		android.util.Log.d("leak-80-77", dataLeAk80);
		android.util.Log.d("leak-81-77", dataLeAk81);
		android.util.Log.d("leak-83-77", dataLeAk83);
		android.util.Log.d("leak-85-77", dataLeAk85);
		android.util.Log.d("leak-86-77", dataLeAk86);
		android.util.Log.d("leak-87-77", dataLeAk87);
		android.util.Log.d("leak-88-77", dataLeAk88);
		android.util.Log.d("leak-89-77", dataLeAk89);
		android.util.Log.d("leak-90-77", dataLeAk90);
		android.util.Log.d("leak-91-77", dataLeAk91);
		android.util.Log.d("leak-54-77", dataLeAk54);
		android.util.Log.d("leak-55-77", dataLeAk55);
		android.util.Log.d("leak-57-77", dataLeAk57);
		android.util.Log.d("leak-59-77", dataLeAk59);
		android.util.Log.d("leak-61-77", dataLeAk61);
		android.util.Log.d("leak-62-77", dataLeAk62);
		android.util.Log.d("leak-63-77", dataLeAk63);
		android.util.Log.d("leak-64-77", dataLeAk64);
		android.util.Log.d("leak-65-77", dataLeAk65);
		android.util.Log.d("leak-66-77", dataLeAk66);
		android.util.Log.d("leak-67-77", dataLeAk67);
		android.util.Log.d("leak-68-77", dataLeAk68);
		android.util.Log.d("leak-69-77", dataLeAk69);
		android.util.Log.d("leak-70-77", dataLeAk70);
		android.util.Log.d("leak-71-77", dataLeAk71);
		android.util.Log.d("leak-72-77", dataLeAk72);
		android.util.Log.d("leak-73-77", dataLeAk73);
		android.util.Log.d("leak-74-77", dataLeAk74);
		android.util.Log.d("leak-75-77", dataLeAk75);
		android.util.Log.d("leak-76-77", dataLeAk76);
		android.util.Log.d("leak-77-77", dataLeAk77);
		android.util.Log.d("leak-79-77", dataLeAk79);
		android.util.Log.d("leak-80-77", dataLeAk80);
		android.util.Log.d("leak-81-77", dataLeAk81);
		android.util.Log.d("leak-83-77", dataLeAk83);
		android.util.Log.d("leak-85-77", dataLeAk85);
		android.util.Log.d("leak-86-77", dataLeAk86);
		android.util.Log.d("leak-87-77", dataLeAk87);
		android.util.Log.d("leak-88-77", dataLeAk88);
		android.util.Log.d("leak-89-77", dataLeAk89);
		android.util.Log.d("leak-90-77", dataLeAk90);
		android.util.Log.d("leak-91-77", dataLeAk91);

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
		dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-53-78", dataLeAk53);
		android.util.Log.d("leak-54-78", dataLeAk54);
		android.util.Log.d("leak-55-78", dataLeAk55);
		android.util.Log.d("leak-57-78", dataLeAk57);
		android.util.Log.d("leak-59-78", dataLeAk59);
		android.util.Log.d("leak-61-78", dataLeAk61);
		android.util.Log.d("leak-62-78", dataLeAk62);
		android.util.Log.d("leak-63-78", dataLeAk63);
		android.util.Log.d("leak-64-78", dataLeAk64);
		android.util.Log.d("leak-65-78", dataLeAk65);
		android.util.Log.d("leak-66-78", dataLeAk66);
		android.util.Log.d("leak-67-78", dataLeAk67);
		android.util.Log.d("leak-68-78", dataLeAk68);
		android.util.Log.d("leak-69-78", dataLeAk69);
		android.util.Log.d("leak-70-78", dataLeAk70);
		android.util.Log.d("leak-71-78", dataLeAk71);
		android.util.Log.d("leak-72-78", dataLeAk72);
		android.util.Log.d("leak-73-78", dataLeAk73);
		android.util.Log.d("leak-74-78", dataLeAk74);
		android.util.Log.d("leak-75-78", dataLeAk75);
		android.util.Log.d("leak-76-78", dataLeAk76);
		android.util.Log.d("leak-77-78", dataLeAk77);
		android.util.Log.d("leak-79-78", dataLeAk79);
		android.util.Log.d("leak-80-78", dataLeAk80);
		android.util.Log.d("leak-81-78", dataLeAk81);
		android.util.Log.d("leak-83-78", dataLeAk83);
		android.util.Log.d("leak-85-78", dataLeAk85);
		android.util.Log.d("leak-86-78", dataLeAk86);
		android.util.Log.d("leak-87-78", dataLeAk87);
		android.util.Log.d("leak-88-78", dataLeAk88);
		android.util.Log.d("leak-89-78", dataLeAk89);
		android.util.Log.d("leak-90-78", dataLeAk90);
		android.util.Log.d("leak-91-78", dataLeAk91);
		android.util.Log.d("leak-53-78", dataLeAk53);
		android.util.Log.d("leak-54-78", dataLeAk54);
		android.util.Log.d("leak-55-78", dataLeAk55);
		android.util.Log.d("leak-57-78", dataLeAk57);
		android.util.Log.d("leak-59-78", dataLeAk59);
		android.util.Log.d("leak-61-78", dataLeAk61);
		android.util.Log.d("leak-62-78", dataLeAk62);
		android.util.Log.d("leak-63-78", dataLeAk63);
		android.util.Log.d("leak-64-78", dataLeAk64);
		android.util.Log.d("leak-65-78", dataLeAk65);
		android.util.Log.d("leak-66-78", dataLeAk66);
		android.util.Log.d("leak-67-78", dataLeAk67);
		android.util.Log.d("leak-68-78", dataLeAk68);
		android.util.Log.d("leak-69-78", dataLeAk69);
		android.util.Log.d("leak-70-78", dataLeAk70);
		android.util.Log.d("leak-71-78", dataLeAk71);
		android.util.Log.d("leak-72-78", dataLeAk72);
		android.util.Log.d("leak-73-78", dataLeAk73);
		android.util.Log.d("leak-74-78", dataLeAk74);
		android.util.Log.d("leak-75-78", dataLeAk75);
		android.util.Log.d("leak-76-78", dataLeAk76);
		android.util.Log.d("leak-77-78", dataLeAk77);
		android.util.Log.d("leak-79-78", dataLeAk79);
		android.util.Log.d("leak-80-78", dataLeAk80);
		android.util.Log.d("leak-81-78", dataLeAk81);
		android.util.Log.d("leak-83-78", dataLeAk83);
		android.util.Log.d("leak-85-78", dataLeAk85);
		android.util.Log.d("leak-86-78", dataLeAk86);
		android.util.Log.d("leak-87-78", dataLeAk87);
		android.util.Log.d("leak-88-78", dataLeAk88);
		android.util.Log.d("leak-89-78", dataLeAk89);
		android.util.Log.d("leak-90-78", dataLeAk90);
		android.util.Log.d("leak-91-78", dataLeAk91);
		android.util.Log.d("leak-53-78", dataLeAk53);
		android.util.Log.d("leak-54-78", dataLeAk54);
		android.util.Log.d("leak-55-78", dataLeAk55);
		android.util.Log.d("leak-57-78", dataLeAk57);
		android.util.Log.d("leak-59-78", dataLeAk59);
		android.util.Log.d("leak-61-78", dataLeAk61);
		android.util.Log.d("leak-62-78", dataLeAk62);
		android.util.Log.d("leak-63-78", dataLeAk63);
		android.util.Log.d("leak-64-78", dataLeAk64);
		android.util.Log.d("leak-65-78", dataLeAk65);
		android.util.Log.d("leak-66-78", dataLeAk66);
		android.util.Log.d("leak-67-78", dataLeAk67);
		android.util.Log.d("leak-68-78", dataLeAk68);
		android.util.Log.d("leak-69-78", dataLeAk69);
		android.util.Log.d("leak-70-78", dataLeAk70);
		android.util.Log.d("leak-71-78", dataLeAk71);
		android.util.Log.d("leak-72-78", dataLeAk72);
		android.util.Log.d("leak-73-78", dataLeAk73);
		android.util.Log.d("leak-74-78", dataLeAk74);
		android.util.Log.d("leak-75-78", dataLeAk75);
		android.util.Log.d("leak-76-78", dataLeAk76);
		android.util.Log.d("leak-77-78", dataLeAk77);
		android.util.Log.d("leak-79-78", dataLeAk79);
		android.util.Log.d("leak-80-78", dataLeAk80);
		android.util.Log.d("leak-81-78", dataLeAk81);
		android.util.Log.d("leak-83-78", dataLeAk83);
		android.util.Log.d("leak-85-78", dataLeAk85);
		android.util.Log.d("leak-86-78", dataLeAk86);
		android.util.Log.d("leak-87-78", dataLeAk87);
		android.util.Log.d("leak-88-78", dataLeAk88);
		android.util.Log.d("leak-89-78", dataLeAk89);
		android.util.Log.d("leak-90-78", dataLeAk90);
		android.util.Log.d("leak-91-78", dataLeAk91);
		android.util.Log.d("leak-54-78", dataLeAk54);
		android.util.Log.d("leak-55-78", dataLeAk55);
		android.util.Log.d("leak-57-78", dataLeAk57);
		android.util.Log.d("leak-59-78", dataLeAk59);
		android.util.Log.d("leak-61-78", dataLeAk61);
		android.util.Log.d("leak-62-78", dataLeAk62);
		android.util.Log.d("leak-63-78", dataLeAk63);
		android.util.Log.d("leak-64-78", dataLeAk64);
		android.util.Log.d("leak-65-78", dataLeAk65);
		android.util.Log.d("leak-66-78", dataLeAk66);
		android.util.Log.d("leak-67-78", dataLeAk67);
		android.util.Log.d("leak-68-78", dataLeAk68);
		android.util.Log.d("leak-69-78", dataLeAk69);
		android.util.Log.d("leak-70-78", dataLeAk70);
		android.util.Log.d("leak-71-78", dataLeAk71);
		android.util.Log.d("leak-72-78", dataLeAk72);
		android.util.Log.d("leak-73-78", dataLeAk73);
		android.util.Log.d("leak-74-78", dataLeAk74);
		android.util.Log.d("leak-75-78", dataLeAk75);
		android.util.Log.d("leak-76-78", dataLeAk76);
		android.util.Log.d("leak-77-78", dataLeAk77);
		android.util.Log.d("leak-79-78", dataLeAk79);
		android.util.Log.d("leak-80-78", dataLeAk80);
		android.util.Log.d("leak-81-78", dataLeAk81);
		android.util.Log.d("leak-83-78", dataLeAk83);
		android.util.Log.d("leak-85-78", dataLeAk85);
		android.util.Log.d("leak-86-78", dataLeAk86);
		android.util.Log.d("leak-87-78", dataLeAk87);
		android.util.Log.d("leak-88-78", dataLeAk88);
		android.util.Log.d("leak-89-78", dataLeAk89);
		android.util.Log.d("leak-90-78", dataLeAk90);
		android.util.Log.d("leak-91-78", dataLeAk91);
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
        dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-53-79", dataLeAk53);
		android.util.Log.d("leak-54-79", dataLeAk54);
		android.util.Log.d("leak-55-79", dataLeAk55);
		android.util.Log.d("leak-57-79", dataLeAk57);
		android.util.Log.d("leak-59-79", dataLeAk59);
		android.util.Log.d("leak-61-79", dataLeAk61);
		android.util.Log.d("leak-62-79", dataLeAk62);
		android.util.Log.d("leak-63-79", dataLeAk63);
		android.util.Log.d("leak-64-79", dataLeAk64);
		android.util.Log.d("leak-65-79", dataLeAk65);
		android.util.Log.d("leak-66-79", dataLeAk66);
		android.util.Log.d("leak-67-79", dataLeAk67);
		android.util.Log.d("leak-68-79", dataLeAk68);
		android.util.Log.d("leak-69-79", dataLeAk69);
		android.util.Log.d("leak-70-79", dataLeAk70);
		android.util.Log.d("leak-71-79", dataLeAk71);
		android.util.Log.d("leak-72-79", dataLeAk72);
		android.util.Log.d("leak-73-79", dataLeAk73);
		android.util.Log.d("leak-74-79", dataLeAk74);
		android.util.Log.d("leak-75-79", dataLeAk75);
		android.util.Log.d("leak-76-79", dataLeAk76);
		android.util.Log.d("leak-77-79", dataLeAk77);
		android.util.Log.d("leak-79-79", dataLeAk79);
		android.util.Log.d("leak-80-79", dataLeAk80);
		android.util.Log.d("leak-81-79", dataLeAk81);
		android.util.Log.d("leak-83-79", dataLeAk83);
		android.util.Log.d("leak-85-79", dataLeAk85);
		android.util.Log.d("leak-86-79", dataLeAk86);
		android.util.Log.d("leak-87-79", dataLeAk87);
		android.util.Log.d("leak-88-79", dataLeAk88);
		android.util.Log.d("leak-89-79", dataLeAk89);
		android.util.Log.d("leak-90-79", dataLeAk90);
		android.util.Log.d("leak-91-79", dataLeAk91);
		android.util.Log.d("leak-53-79", dataLeAk53);
		android.util.Log.d("leak-54-79", dataLeAk54);
		android.util.Log.d("leak-55-79", dataLeAk55);
		android.util.Log.d("leak-57-79", dataLeAk57);
		android.util.Log.d("leak-59-79", dataLeAk59);
		android.util.Log.d("leak-61-79", dataLeAk61);
		android.util.Log.d("leak-62-79", dataLeAk62);
		android.util.Log.d("leak-63-79", dataLeAk63);
		android.util.Log.d("leak-64-79", dataLeAk64);
		android.util.Log.d("leak-65-79", dataLeAk65);
		android.util.Log.d("leak-66-79", dataLeAk66);
		android.util.Log.d("leak-67-79", dataLeAk67);
		android.util.Log.d("leak-68-79", dataLeAk68);
		android.util.Log.d("leak-69-79", dataLeAk69);
		android.util.Log.d("leak-70-79", dataLeAk70);
		android.util.Log.d("leak-71-79", dataLeAk71);
		android.util.Log.d("leak-72-79", dataLeAk72);
		android.util.Log.d("leak-73-79", dataLeAk73);
		android.util.Log.d("leak-74-79", dataLeAk74);
		android.util.Log.d("leak-75-79", dataLeAk75);
		android.util.Log.d("leak-76-79", dataLeAk76);
		android.util.Log.d("leak-77-79", dataLeAk77);
		android.util.Log.d("leak-79-79", dataLeAk79);
		android.util.Log.d("leak-80-79", dataLeAk80);
		android.util.Log.d("leak-81-79", dataLeAk81);
		android.util.Log.d("leak-83-79", dataLeAk83);
		android.util.Log.d("leak-85-79", dataLeAk85);
		android.util.Log.d("leak-86-79", dataLeAk86);
		android.util.Log.d("leak-87-79", dataLeAk87);
		android.util.Log.d("leak-88-79", dataLeAk88);
		android.util.Log.d("leak-89-79", dataLeAk89);
		android.util.Log.d("leak-90-79", dataLeAk90);
		android.util.Log.d("leak-91-79", dataLeAk91);
		android.util.Log.d("leak-53-79", dataLeAk53);
		android.util.Log.d("leak-54-79", dataLeAk54);
		android.util.Log.d("leak-55-79", dataLeAk55);
		android.util.Log.d("leak-57-79", dataLeAk57);
		android.util.Log.d("leak-59-79", dataLeAk59);
		android.util.Log.d("leak-61-79", dataLeAk61);
		android.util.Log.d("leak-62-79", dataLeAk62);
		android.util.Log.d("leak-63-79", dataLeAk63);
		android.util.Log.d("leak-64-79", dataLeAk64);
		android.util.Log.d("leak-65-79", dataLeAk65);
		android.util.Log.d("leak-66-79", dataLeAk66);
		android.util.Log.d("leak-67-79", dataLeAk67);
		android.util.Log.d("leak-68-79", dataLeAk68);
		android.util.Log.d("leak-69-79", dataLeAk69);
		android.util.Log.d("leak-70-79", dataLeAk70);
		android.util.Log.d("leak-71-79", dataLeAk71);
		android.util.Log.d("leak-72-79", dataLeAk72);
		android.util.Log.d("leak-73-79", dataLeAk73);
		android.util.Log.d("leak-74-79", dataLeAk74);
		android.util.Log.d("leak-75-79", dataLeAk75);
		android.util.Log.d("leak-76-79", dataLeAk76);
		android.util.Log.d("leak-77-79", dataLeAk77);
		android.util.Log.d("leak-79-79", dataLeAk79);
		android.util.Log.d("leak-80-79", dataLeAk80);
		android.util.Log.d("leak-81-79", dataLeAk81);
		android.util.Log.d("leak-83-79", dataLeAk83);
		android.util.Log.d("leak-85-79", dataLeAk85);
		android.util.Log.d("leak-86-79", dataLeAk86);
		android.util.Log.d("leak-87-79", dataLeAk87);
		android.util.Log.d("leak-88-79", dataLeAk88);
		android.util.Log.d("leak-89-79", dataLeAk89);
		android.util.Log.d("leak-90-79", dataLeAk90);
		android.util.Log.d("leak-91-79", dataLeAk91);
		android.util.Log.d("leak-54-79", dataLeAk54);
		android.util.Log.d("leak-55-79", dataLeAk55);
		android.util.Log.d("leak-57-79", dataLeAk57);
		android.util.Log.d("leak-59-79", dataLeAk59);
		android.util.Log.d("leak-61-79", dataLeAk61);
		android.util.Log.d("leak-62-79", dataLeAk62);
		android.util.Log.d("leak-63-79", dataLeAk63);
		android.util.Log.d("leak-64-79", dataLeAk64);
		android.util.Log.d("leak-65-79", dataLeAk65);
		android.util.Log.d("leak-66-79", dataLeAk66);
		android.util.Log.d("leak-67-79", dataLeAk67);
		android.util.Log.d("leak-68-79", dataLeAk68);
		android.util.Log.d("leak-69-79", dataLeAk69);
		android.util.Log.d("leak-70-79", dataLeAk70);
		android.util.Log.d("leak-71-79", dataLeAk71);
		android.util.Log.d("leak-72-79", dataLeAk72);
		android.util.Log.d("leak-73-79", dataLeAk73);
		android.util.Log.d("leak-74-79", dataLeAk74);
		android.util.Log.d("leak-75-79", dataLeAk75);
		android.util.Log.d("leak-76-79", dataLeAk76);
		android.util.Log.d("leak-77-79", dataLeAk77);
		android.util.Log.d("leak-79-79", dataLeAk79);
		android.util.Log.d("leak-80-79", dataLeAk80);
		android.util.Log.d("leak-81-79", dataLeAk81);
		android.util.Log.d("leak-83-79", dataLeAk83);
		android.util.Log.d("leak-85-79", dataLeAk85);
		android.util.Log.d("leak-86-79", dataLeAk86);
		android.util.Log.d("leak-87-79", dataLeAk87);
		android.util.Log.d("leak-88-79", dataLeAk88);
		android.util.Log.d("leak-89-79", dataLeAk89);
		android.util.Log.d("leak-90-79", dataLeAk90);
		android.util.Log.d("leak-91-79", dataLeAk91);
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
        // Launch activity to insert a new item
        Intent i = new Intent(Intent.ACTION_INSERT, getIntent().getData());
		android.util.Log.d("leak-53-80", dataLeAk53);
		android.util.Log.d("leak-54-80", dataLeAk54);
		android.util.Log.d("leak-55-80", dataLeAk55);
		android.util.Log.d("leak-57-80", dataLeAk57);
		android.util.Log.d("leak-59-80", dataLeAk59);
		android.util.Log.d("leak-61-80", dataLeAk61);
		android.util.Log.d("leak-62-80", dataLeAk62);
		android.util.Log.d("leak-63-80", dataLeAk63);
		android.util.Log.d("leak-64-80", dataLeAk64);
		android.util.Log.d("leak-65-80", dataLeAk65);
		android.util.Log.d("leak-66-80", dataLeAk66);
		android.util.Log.d("leak-67-80", dataLeAk67);
		android.util.Log.d("leak-68-80", dataLeAk68);
		android.util.Log.d("leak-69-80", dataLeAk69);
		android.util.Log.d("leak-70-80", dataLeAk70);
		android.util.Log.d("leak-71-80", dataLeAk71);
		android.util.Log.d("leak-72-80", dataLeAk72);
		android.util.Log.d("leak-73-80", dataLeAk73);
		android.util.Log.d("leak-74-80", dataLeAk74);
		android.util.Log.d("leak-75-80", dataLeAk75);
		android.util.Log.d("leak-76-80", dataLeAk76);
		android.util.Log.d("leak-77-80", dataLeAk77);
		android.util.Log.d("leak-79-80", dataLeAk79);
		android.util.Log.d("leak-80-80", dataLeAk80);
		android.util.Log.d("leak-81-80", dataLeAk81);
		android.util.Log.d("leak-83-80", dataLeAk83);
		android.util.Log.d("leak-85-80", dataLeAk85);
		android.util.Log.d("leak-86-80", dataLeAk86);
		android.util.Log.d("leak-87-80", dataLeAk87);
		android.util.Log.d("leak-88-80", dataLeAk88);
		android.util.Log.d("leak-89-80", dataLeAk89);
		android.util.Log.d("leak-90-80", dataLeAk90);
		android.util.Log.d("leak-91-80", dataLeAk91);
		android.util.Log.d("leak-53-80", dataLeAk53);
		android.util.Log.d("leak-54-80", dataLeAk54);
		android.util.Log.d("leak-55-80", dataLeAk55);
		android.util.Log.d("leak-57-80", dataLeAk57);
		android.util.Log.d("leak-59-80", dataLeAk59);
		android.util.Log.d("leak-61-80", dataLeAk61);
		android.util.Log.d("leak-62-80", dataLeAk62);
		android.util.Log.d("leak-63-80", dataLeAk63);
		android.util.Log.d("leak-64-80", dataLeAk64);
		android.util.Log.d("leak-65-80", dataLeAk65);
		android.util.Log.d("leak-66-80", dataLeAk66);
		android.util.Log.d("leak-67-80", dataLeAk67);
		android.util.Log.d("leak-68-80", dataLeAk68);
		android.util.Log.d("leak-69-80", dataLeAk69);
		android.util.Log.d("leak-70-80", dataLeAk70);
		android.util.Log.d("leak-71-80", dataLeAk71);
		android.util.Log.d("leak-72-80", dataLeAk72);
		android.util.Log.d("leak-73-80", dataLeAk73);
		android.util.Log.d("leak-74-80", dataLeAk74);
		android.util.Log.d("leak-75-80", dataLeAk75);
		android.util.Log.d("leak-76-80", dataLeAk76);
		android.util.Log.d("leak-77-80", dataLeAk77);
		android.util.Log.d("leak-79-80", dataLeAk79);
		android.util.Log.d("leak-80-80", dataLeAk80);
		android.util.Log.d("leak-81-80", dataLeAk81);
		android.util.Log.d("leak-83-80", dataLeAk83);
		android.util.Log.d("leak-85-80", dataLeAk85);
		android.util.Log.d("leak-86-80", dataLeAk86);
		android.util.Log.d("leak-87-80", dataLeAk87);
		android.util.Log.d("leak-88-80", dataLeAk88);
		android.util.Log.d("leak-89-80", dataLeAk89);
		android.util.Log.d("leak-90-80", dataLeAk90);
		android.util.Log.d("leak-91-80", dataLeAk91);
		android.util.Log.d("leak-53-80", dataLeAk53);
		android.util.Log.d("leak-54-80", dataLeAk54);
		android.util.Log.d("leak-55-80", dataLeAk55);
		android.util.Log.d("leak-57-80", dataLeAk57);
		android.util.Log.d("leak-59-80", dataLeAk59);
		android.util.Log.d("leak-61-80", dataLeAk61);
		android.util.Log.d("leak-62-80", dataLeAk62);
		android.util.Log.d("leak-63-80", dataLeAk63);
		android.util.Log.d("leak-64-80", dataLeAk64);
		android.util.Log.d("leak-65-80", dataLeAk65);
		android.util.Log.d("leak-66-80", dataLeAk66);
		android.util.Log.d("leak-67-80", dataLeAk67);
		android.util.Log.d("leak-68-80", dataLeAk68);
		android.util.Log.d("leak-69-80", dataLeAk69);
		android.util.Log.d("leak-70-80", dataLeAk70);
		android.util.Log.d("leak-71-80", dataLeAk71);
		android.util.Log.d("leak-72-80", dataLeAk72);
		android.util.Log.d("leak-73-80", dataLeAk73);
		android.util.Log.d("leak-74-80", dataLeAk74);
		android.util.Log.d("leak-75-80", dataLeAk75);
		android.util.Log.d("leak-76-80", dataLeAk76);
		android.util.Log.d("leak-77-80", dataLeAk77);
		android.util.Log.d("leak-79-80", dataLeAk79);
		android.util.Log.d("leak-80-80", dataLeAk80);
		android.util.Log.d("leak-81-80", dataLeAk81);
		android.util.Log.d("leak-83-80", dataLeAk83);
		android.util.Log.d("leak-85-80", dataLeAk85);
		android.util.Log.d("leak-86-80", dataLeAk86);
		android.util.Log.d("leak-87-80", dataLeAk87);
		android.util.Log.d("leak-88-80", dataLeAk88);
		android.util.Log.d("leak-89-80", dataLeAk89);
		android.util.Log.d("leak-90-80", dataLeAk90);
		android.util.Log.d("leak-91-80", dataLeAk91);
		android.util.Log.d("leak-54-80", dataLeAk54);
		android.util.Log.d("leak-55-80", dataLeAk55);
		android.util.Log.d("leak-57-80", dataLeAk57);
		android.util.Log.d("leak-59-80", dataLeAk59);
		android.util.Log.d("leak-61-80", dataLeAk61);
		android.util.Log.d("leak-62-80", dataLeAk62);
		android.util.Log.d("leak-63-80", dataLeAk63);
		android.util.Log.d("leak-64-80", dataLeAk64);
		android.util.Log.d("leak-65-80", dataLeAk65);
		android.util.Log.d("leak-66-80", dataLeAk66);
		android.util.Log.d("leak-67-80", dataLeAk67);
		android.util.Log.d("leak-68-80", dataLeAk68);
		android.util.Log.d("leak-69-80", dataLeAk69);
		android.util.Log.d("leak-70-80", dataLeAk70);
		android.util.Log.d("leak-71-80", dataLeAk71);
		android.util.Log.d("leak-72-80", dataLeAk72);
		android.util.Log.d("leak-73-80", dataLeAk73);
		android.util.Log.d("leak-74-80", dataLeAk74);
		android.util.Log.d("leak-75-80", dataLeAk75);
		android.util.Log.d("leak-76-80", dataLeAk76);
		android.util.Log.d("leak-77-80", dataLeAk77);
		android.util.Log.d("leak-79-80", dataLeAk79);
		android.util.Log.d("leak-80-80", dataLeAk80);
		android.util.Log.d("leak-81-80", dataLeAk81);
		android.util.Log.d("leak-83-80", dataLeAk83);
		android.util.Log.d("leak-85-80", dataLeAk85);
		android.util.Log.d("leak-86-80", dataLeAk86);
		android.util.Log.d("leak-87-80", dataLeAk87);
		android.util.Log.d("leak-88-80", dataLeAk88);
		android.util.Log.d("leak-89-80", dataLeAk89);
		android.util.Log.d("leak-90-80", dataLeAk90);
		android.util.Log.d("leak-91-80", dataLeAk91);
        i.putExtra(NotepadInternalIntents.EXTRA_TAGS, mSelectedTag);
        startActivity(i);
    }

    private void search() {
        onSearchRequested();
		android.util.Log.d("leak-53-81", dataLeAk53);
		android.util.Log.d("leak-54-81", dataLeAk54);
		android.util.Log.d("leak-55-81", dataLeAk55);
		android.util.Log.d("leak-57-81", dataLeAk57);
		android.util.Log.d("leak-59-81", dataLeAk59);
		android.util.Log.d("leak-61-81", dataLeAk61);
		android.util.Log.d("leak-62-81", dataLeAk62);
		android.util.Log.d("leak-63-81", dataLeAk63);
		android.util.Log.d("leak-64-81", dataLeAk64);
		android.util.Log.d("leak-65-81", dataLeAk65);
		android.util.Log.d("leak-66-81", dataLeAk66);
		android.util.Log.d("leak-67-81", dataLeAk67);
		android.util.Log.d("leak-68-81", dataLeAk68);
		android.util.Log.d("leak-69-81", dataLeAk69);
		android.util.Log.d("leak-70-81", dataLeAk70);
		android.util.Log.d("leak-71-81", dataLeAk71);
		android.util.Log.d("leak-72-81", dataLeAk72);
		android.util.Log.d("leak-73-81", dataLeAk73);
		android.util.Log.d("leak-74-81", dataLeAk74);
		android.util.Log.d("leak-75-81", dataLeAk75);
		android.util.Log.d("leak-76-81", dataLeAk76);
		android.util.Log.d("leak-77-81", dataLeAk77);
		android.util.Log.d("leak-79-81", dataLeAk79);
		android.util.Log.d("leak-80-81", dataLeAk80);
		android.util.Log.d("leak-81-81", dataLeAk81);
		android.util.Log.d("leak-83-81", dataLeAk83);
		android.util.Log.d("leak-85-81", dataLeAk85);
		android.util.Log.d("leak-86-81", dataLeAk86);
		android.util.Log.d("leak-87-81", dataLeAk87);
		android.util.Log.d("leak-88-81", dataLeAk88);
		android.util.Log.d("leak-89-81", dataLeAk89);
		android.util.Log.d("leak-90-81", dataLeAk90);
		android.util.Log.d("leak-91-81", dataLeAk91);
		android.util.Log.d("leak-53-81", dataLeAk53);
		android.util.Log.d("leak-54-81", dataLeAk54);
		android.util.Log.d("leak-55-81", dataLeAk55);
		android.util.Log.d("leak-57-81", dataLeAk57);
		android.util.Log.d("leak-59-81", dataLeAk59);
		android.util.Log.d("leak-61-81", dataLeAk61);
		android.util.Log.d("leak-62-81", dataLeAk62);
		android.util.Log.d("leak-63-81", dataLeAk63);
		android.util.Log.d("leak-64-81", dataLeAk64);
		android.util.Log.d("leak-65-81", dataLeAk65);
		android.util.Log.d("leak-66-81", dataLeAk66);
		android.util.Log.d("leak-67-81", dataLeAk67);
		android.util.Log.d("leak-68-81", dataLeAk68);
		android.util.Log.d("leak-69-81", dataLeAk69);
		android.util.Log.d("leak-70-81", dataLeAk70);
		android.util.Log.d("leak-71-81", dataLeAk71);
		android.util.Log.d("leak-72-81", dataLeAk72);
		android.util.Log.d("leak-73-81", dataLeAk73);
		android.util.Log.d("leak-74-81", dataLeAk74);
		android.util.Log.d("leak-75-81", dataLeAk75);
		android.util.Log.d("leak-76-81", dataLeAk76);
		android.util.Log.d("leak-77-81", dataLeAk77);
		android.util.Log.d("leak-79-81", dataLeAk79);
		android.util.Log.d("leak-80-81", dataLeAk80);
		android.util.Log.d("leak-81-81", dataLeAk81);
		android.util.Log.d("leak-83-81", dataLeAk83);
		android.util.Log.d("leak-85-81", dataLeAk85);
		android.util.Log.d("leak-86-81", dataLeAk86);
		android.util.Log.d("leak-87-81", dataLeAk87);
		android.util.Log.d("leak-88-81", dataLeAk88);
		android.util.Log.d("leak-89-81", dataLeAk89);
		android.util.Log.d("leak-90-81", dataLeAk90);
		android.util.Log.d("leak-91-81", dataLeAk91);
		android.util.Log.d("leak-53-81", dataLeAk53);
		android.util.Log.d("leak-54-81", dataLeAk54);
		android.util.Log.d("leak-55-81", dataLeAk55);
		android.util.Log.d("leak-57-81", dataLeAk57);
		android.util.Log.d("leak-59-81", dataLeAk59);
		android.util.Log.d("leak-61-81", dataLeAk61);
		android.util.Log.d("leak-62-81", dataLeAk62);
		android.util.Log.d("leak-63-81", dataLeAk63);
		android.util.Log.d("leak-64-81", dataLeAk64);
		android.util.Log.d("leak-65-81", dataLeAk65);
		android.util.Log.d("leak-66-81", dataLeAk66);
		android.util.Log.d("leak-67-81", dataLeAk67);
		android.util.Log.d("leak-68-81", dataLeAk68);
		android.util.Log.d("leak-69-81", dataLeAk69);
		android.util.Log.d("leak-70-81", dataLeAk70);
		android.util.Log.d("leak-71-81", dataLeAk71);
		android.util.Log.d("leak-72-81", dataLeAk72);
		android.util.Log.d("leak-73-81", dataLeAk73);
		android.util.Log.d("leak-74-81", dataLeAk74);
		android.util.Log.d("leak-75-81", dataLeAk75);
		android.util.Log.d("leak-76-81", dataLeAk76);
		android.util.Log.d("leak-77-81", dataLeAk77);
		android.util.Log.d("leak-79-81", dataLeAk79);
		android.util.Log.d("leak-80-81", dataLeAk80);
		android.util.Log.d("leak-81-81", dataLeAk81);
		android.util.Log.d("leak-83-81", dataLeAk83);
		android.util.Log.d("leak-85-81", dataLeAk85);
		android.util.Log.d("leak-86-81", dataLeAk86);
		android.util.Log.d("leak-87-81", dataLeAk87);
		android.util.Log.d("leak-88-81", dataLeAk88);
		android.util.Log.d("leak-89-81", dataLeAk89);
		android.util.Log.d("leak-90-81", dataLeAk90);
		android.util.Log.d("leak-91-81", dataLeAk91);
		android.util.Log.d("leak-54-81", dataLeAk54);
		android.util.Log.d("leak-55-81", dataLeAk55);
		android.util.Log.d("leak-57-81", dataLeAk57);
		android.util.Log.d("leak-59-81", dataLeAk59);
		android.util.Log.d("leak-61-81", dataLeAk61);
		android.util.Log.d("leak-62-81", dataLeAk62);
		android.util.Log.d("leak-63-81", dataLeAk63);
		android.util.Log.d("leak-64-81", dataLeAk64);
		android.util.Log.d("leak-65-81", dataLeAk65);
		android.util.Log.d("leak-66-81", dataLeAk66);
		android.util.Log.d("leak-67-81", dataLeAk67);
		android.util.Log.d("leak-68-81", dataLeAk68);
		android.util.Log.d("leak-69-81", dataLeAk69);
		android.util.Log.d("leak-70-81", dataLeAk70);
		android.util.Log.d("leak-71-81", dataLeAk71);
		android.util.Log.d("leak-72-81", dataLeAk72);
		android.util.Log.d("leak-73-81", dataLeAk73);
		android.util.Log.d("leak-74-81", dataLeAk74);
		android.util.Log.d("leak-75-81", dataLeAk75);
		android.util.Log.d("leak-76-81", dataLeAk76);
		android.util.Log.d("leak-77-81", dataLeAk77);
		android.util.Log.d("leak-79-81", dataLeAk79);
		android.util.Log.d("leak-80-81", dataLeAk80);
		android.util.Log.d("leak-81-81", dataLeAk81);
		android.util.Log.d("leak-83-81", dataLeAk83);
		android.util.Log.d("leak-85-81", dataLeAk85);
		android.util.Log.d("leak-86-81", dataLeAk86);
		android.util.Log.d("leak-87-81", dataLeAk87);
		android.util.Log.d("leak-88-81", dataLeAk88);
		android.util.Log.d("leak-89-81", dataLeAk89);
		android.util.Log.d("leak-90-81", dataLeAk90);
		android.util.Log.d("leak-91-81", dataLeAk91);
    }

    private void openFromSdCard() {

        File sdcard = getSdCardPath();
		android.util.Log.d("leak-53-82", dataLeAk53);
		android.util.Log.d("leak-54-82", dataLeAk54);
		android.util.Log.d("leak-55-82", dataLeAk55);
		android.util.Log.d("leak-57-82", dataLeAk57);
		android.util.Log.d("leak-59-82", dataLeAk59);
		android.util.Log.d("leak-61-82", dataLeAk61);
		android.util.Log.d("leak-62-82", dataLeAk62);
		android.util.Log.d("leak-63-82", dataLeAk63);
		android.util.Log.d("leak-64-82", dataLeAk64);
		android.util.Log.d("leak-65-82", dataLeAk65);
		android.util.Log.d("leak-66-82", dataLeAk66);
		android.util.Log.d("leak-67-82", dataLeAk67);
		android.util.Log.d("leak-68-82", dataLeAk68);
		android.util.Log.d("leak-69-82", dataLeAk69);
		android.util.Log.d("leak-70-82", dataLeAk70);
		android.util.Log.d("leak-71-82", dataLeAk71);
		android.util.Log.d("leak-72-82", dataLeAk72);
		android.util.Log.d("leak-73-82", dataLeAk73);
		android.util.Log.d("leak-74-82", dataLeAk74);
		android.util.Log.d("leak-75-82", dataLeAk75);
		android.util.Log.d("leak-76-82", dataLeAk76);
		android.util.Log.d("leak-77-82", dataLeAk77);
		android.util.Log.d("leak-79-82", dataLeAk79);
		android.util.Log.d("leak-80-82", dataLeAk80);
		android.util.Log.d("leak-81-82", dataLeAk81);
		android.util.Log.d("leak-83-82", dataLeAk83);
		android.util.Log.d("leak-85-82", dataLeAk85);
		android.util.Log.d("leak-86-82", dataLeAk86);
		android.util.Log.d("leak-87-82", dataLeAk87);
		android.util.Log.d("leak-88-82", dataLeAk88);
		android.util.Log.d("leak-89-82", dataLeAk89);
		android.util.Log.d("leak-90-82", dataLeAk90);
		android.util.Log.d("leak-91-82", dataLeAk91);
		android.util.Log.d("leak-53-82", dataLeAk53);
		android.util.Log.d("leak-54-82", dataLeAk54);
		android.util.Log.d("leak-55-82", dataLeAk55);
		android.util.Log.d("leak-57-82", dataLeAk57);
		android.util.Log.d("leak-59-82", dataLeAk59);
		android.util.Log.d("leak-61-82", dataLeAk61);
		android.util.Log.d("leak-62-82", dataLeAk62);
		android.util.Log.d("leak-63-82", dataLeAk63);
		android.util.Log.d("leak-64-82", dataLeAk64);
		android.util.Log.d("leak-65-82", dataLeAk65);
		android.util.Log.d("leak-66-82", dataLeAk66);
		android.util.Log.d("leak-67-82", dataLeAk67);
		android.util.Log.d("leak-68-82", dataLeAk68);
		android.util.Log.d("leak-69-82", dataLeAk69);
		android.util.Log.d("leak-70-82", dataLeAk70);
		android.util.Log.d("leak-71-82", dataLeAk71);
		android.util.Log.d("leak-72-82", dataLeAk72);
		android.util.Log.d("leak-73-82", dataLeAk73);
		android.util.Log.d("leak-74-82", dataLeAk74);
		android.util.Log.d("leak-75-82", dataLeAk75);
		android.util.Log.d("leak-76-82", dataLeAk76);
		android.util.Log.d("leak-77-82", dataLeAk77);
		android.util.Log.d("leak-79-82", dataLeAk79);
		android.util.Log.d("leak-80-82", dataLeAk80);
		android.util.Log.d("leak-81-82", dataLeAk81);
		android.util.Log.d("leak-83-82", dataLeAk83);
		android.util.Log.d("leak-85-82", dataLeAk85);
		android.util.Log.d("leak-86-82", dataLeAk86);
		android.util.Log.d("leak-87-82", dataLeAk87);
		android.util.Log.d("leak-88-82", dataLeAk88);
		android.util.Log.d("leak-89-82", dataLeAk89);
		android.util.Log.d("leak-90-82", dataLeAk90);
		android.util.Log.d("leak-91-82", dataLeAk91);
		android.util.Log.d("leak-53-82", dataLeAk53);
		android.util.Log.d("leak-54-82", dataLeAk54);
		android.util.Log.d("leak-55-82", dataLeAk55);
		android.util.Log.d("leak-57-82", dataLeAk57);
		android.util.Log.d("leak-59-82", dataLeAk59);
		android.util.Log.d("leak-61-82", dataLeAk61);
		android.util.Log.d("leak-62-82", dataLeAk62);
		android.util.Log.d("leak-63-82", dataLeAk63);
		android.util.Log.d("leak-64-82", dataLeAk64);
		android.util.Log.d("leak-65-82", dataLeAk65);
		android.util.Log.d("leak-66-82", dataLeAk66);
		android.util.Log.d("leak-67-82", dataLeAk67);
		android.util.Log.d("leak-68-82", dataLeAk68);
		android.util.Log.d("leak-69-82", dataLeAk69);
		android.util.Log.d("leak-70-82", dataLeAk70);
		android.util.Log.d("leak-71-82", dataLeAk71);
		android.util.Log.d("leak-72-82", dataLeAk72);
		android.util.Log.d("leak-73-82", dataLeAk73);
		android.util.Log.d("leak-74-82", dataLeAk74);
		android.util.Log.d("leak-75-82", dataLeAk75);
		android.util.Log.d("leak-76-82", dataLeAk76);
		android.util.Log.d("leak-77-82", dataLeAk77);
		android.util.Log.d("leak-79-82", dataLeAk79);
		android.util.Log.d("leak-80-82", dataLeAk80);
		android.util.Log.d("leak-81-82", dataLeAk81);
		android.util.Log.d("leak-83-82", dataLeAk83);
		android.util.Log.d("leak-85-82", dataLeAk85);
		android.util.Log.d("leak-86-82", dataLeAk86);
		android.util.Log.d("leak-87-82", dataLeAk87);
		android.util.Log.d("leak-88-82", dataLeAk88);
		android.util.Log.d("leak-89-82", dataLeAk89);
		android.util.Log.d("leak-90-82", dataLeAk90);
		android.util.Log.d("leak-91-82", dataLeAk91);
		android.util.Log.d("leak-54-82", dataLeAk54);
		android.util.Log.d("leak-55-82", dataLeAk55);
		android.util.Log.d("leak-57-82", dataLeAk57);
		android.util.Log.d("leak-59-82", dataLeAk59);
		android.util.Log.d("leak-61-82", dataLeAk61);
		android.util.Log.d("leak-62-82", dataLeAk62);
		android.util.Log.d("leak-63-82", dataLeAk63);
		android.util.Log.d("leak-64-82", dataLeAk64);
		android.util.Log.d("leak-65-82", dataLeAk65);
		android.util.Log.d("leak-66-82", dataLeAk66);
		android.util.Log.d("leak-67-82", dataLeAk67);
		android.util.Log.d("leak-68-82", dataLeAk68);
		android.util.Log.d("leak-69-82", dataLeAk69);
		android.util.Log.d("leak-70-82", dataLeAk70);
		android.util.Log.d("leak-71-82", dataLeAk71);
		android.util.Log.d("leak-72-82", dataLeAk72);
		android.util.Log.d("leak-73-82", dataLeAk73);
		android.util.Log.d("leak-74-82", dataLeAk74);
		android.util.Log.d("leak-75-82", dataLeAk75);
		android.util.Log.d("leak-76-82", dataLeAk76);
		android.util.Log.d("leak-77-82", dataLeAk77);
		android.util.Log.d("leak-79-82", dataLeAk79);
		android.util.Log.d("leak-80-82", dataLeAk80);
		android.util.Log.d("leak-81-82", dataLeAk81);
		android.util.Log.d("leak-83-82", dataLeAk83);
		android.util.Log.d("leak-85-82", dataLeAk85);
		android.util.Log.d("leak-86-82", dataLeAk86);
		android.util.Log.d("leak-87-82", dataLeAk87);
		android.util.Log.d("leak-88-82", dataLeAk88);
		android.util.Log.d("leak-89-82", dataLeAk89);
		android.util.Log.d("leak-90-82", dataLeAk90);
		android.util.Log.d("leak-91-82", dataLeAk91);
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
        dataLeAk72 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-53-83", dataLeAk53);
		android.util.Log.d("leak-54-83", dataLeAk54);
		android.util.Log.d("leak-55-83", dataLeAk55);
		android.util.Log.d("leak-57-83", dataLeAk57);
		android.util.Log.d("leak-59-83", dataLeAk59);
		android.util.Log.d("leak-61-83", dataLeAk61);
		android.util.Log.d("leak-62-83", dataLeAk62);
		android.util.Log.d("leak-63-83", dataLeAk63);
		android.util.Log.d("leak-64-83", dataLeAk64);
		android.util.Log.d("leak-65-83", dataLeAk65);
		android.util.Log.d("leak-66-83", dataLeAk66);
		android.util.Log.d("leak-67-83", dataLeAk67);
		android.util.Log.d("leak-68-83", dataLeAk68);
		android.util.Log.d("leak-69-83", dataLeAk69);
		android.util.Log.d("leak-70-83", dataLeAk70);
		android.util.Log.d("leak-71-83", dataLeAk71);
		android.util.Log.d("leak-72-83", dataLeAk72);
		android.util.Log.d("leak-73-83", dataLeAk73);
		android.util.Log.d("leak-74-83", dataLeAk74);
		android.util.Log.d("leak-75-83", dataLeAk75);
		android.util.Log.d("leak-76-83", dataLeAk76);
		android.util.Log.d("leak-77-83", dataLeAk77);
		android.util.Log.d("leak-79-83", dataLeAk79);
		android.util.Log.d("leak-80-83", dataLeAk80);
		android.util.Log.d("leak-81-83", dataLeAk81);
		android.util.Log.d("leak-83-83", dataLeAk83);
		android.util.Log.d("leak-85-83", dataLeAk85);
		android.util.Log.d("leak-86-83", dataLeAk86);
		android.util.Log.d("leak-87-83", dataLeAk87);
		android.util.Log.d("leak-88-83", dataLeAk88);
		android.util.Log.d("leak-89-83", dataLeAk89);
		android.util.Log.d("leak-90-83", dataLeAk90);
		android.util.Log.d("leak-91-83", dataLeAk91);
		android.util.Log.d("leak-53-83", dataLeAk53);
		android.util.Log.d("leak-54-83", dataLeAk54);
		android.util.Log.d("leak-55-83", dataLeAk55);
		android.util.Log.d("leak-57-83", dataLeAk57);
		android.util.Log.d("leak-59-83", dataLeAk59);
		android.util.Log.d("leak-61-83", dataLeAk61);
		android.util.Log.d("leak-62-83", dataLeAk62);
		android.util.Log.d("leak-63-83", dataLeAk63);
		android.util.Log.d("leak-64-83", dataLeAk64);
		android.util.Log.d("leak-65-83", dataLeAk65);
		android.util.Log.d("leak-66-83", dataLeAk66);
		android.util.Log.d("leak-67-83", dataLeAk67);
		android.util.Log.d("leak-68-83", dataLeAk68);
		android.util.Log.d("leak-69-83", dataLeAk69);
		android.util.Log.d("leak-70-83", dataLeAk70);
		android.util.Log.d("leak-71-83", dataLeAk71);
		android.util.Log.d("leak-72-83", dataLeAk72);
		android.util.Log.d("leak-73-83", dataLeAk73);
		android.util.Log.d("leak-74-83", dataLeAk74);
		android.util.Log.d("leak-75-83", dataLeAk75);
		android.util.Log.d("leak-76-83", dataLeAk76);
		android.util.Log.d("leak-77-83", dataLeAk77);
		android.util.Log.d("leak-79-83", dataLeAk79);
		android.util.Log.d("leak-80-83", dataLeAk80);
		android.util.Log.d("leak-81-83", dataLeAk81);
		android.util.Log.d("leak-83-83", dataLeAk83);
		android.util.Log.d("leak-85-83", dataLeAk85);
		android.util.Log.d("leak-86-83", dataLeAk86);
		android.util.Log.d("leak-87-83", dataLeAk87);
		android.util.Log.d("leak-88-83", dataLeAk88);
		android.util.Log.d("leak-89-83", dataLeAk89);
		android.util.Log.d("leak-90-83", dataLeAk90);
		android.util.Log.d("leak-91-83", dataLeAk91);
		android.util.Log.d("leak-53-83", dataLeAk53);
		android.util.Log.d("leak-54-83", dataLeAk54);
		android.util.Log.d("leak-55-83", dataLeAk55);
		android.util.Log.d("leak-57-83", dataLeAk57);
		android.util.Log.d("leak-59-83", dataLeAk59);
		android.util.Log.d("leak-61-83", dataLeAk61);
		android.util.Log.d("leak-62-83", dataLeAk62);
		android.util.Log.d("leak-63-83", dataLeAk63);
		android.util.Log.d("leak-64-83", dataLeAk64);
		android.util.Log.d("leak-65-83", dataLeAk65);
		android.util.Log.d("leak-66-83", dataLeAk66);
		android.util.Log.d("leak-67-83", dataLeAk67);
		android.util.Log.d("leak-68-83", dataLeAk68);
		android.util.Log.d("leak-69-83", dataLeAk69);
		android.util.Log.d("leak-70-83", dataLeAk70);
		android.util.Log.d("leak-71-83", dataLeAk71);
		android.util.Log.d("leak-72-83", dataLeAk72);
		android.util.Log.d("leak-73-83", dataLeAk73);
		android.util.Log.d("leak-74-83", dataLeAk74);
		android.util.Log.d("leak-75-83", dataLeAk75);
		android.util.Log.d("leak-76-83", dataLeAk76);
		android.util.Log.d("leak-77-83", dataLeAk77);
		android.util.Log.d("leak-79-83", dataLeAk79);
		android.util.Log.d("leak-80-83", dataLeAk80);
		android.util.Log.d("leak-81-83", dataLeAk81);
		android.util.Log.d("leak-83-83", dataLeAk83);
		android.util.Log.d("leak-85-83", dataLeAk85);
		android.util.Log.d("leak-86-83", dataLeAk86);
		android.util.Log.d("leak-87-83", dataLeAk87);
		android.util.Log.d("leak-88-83", dataLeAk88);
		android.util.Log.d("leak-89-83", dataLeAk89);
		android.util.Log.d("leak-90-83", dataLeAk90);
		android.util.Log.d("leak-91-83", dataLeAk91);
		android.util.Log.d("leak-54-83", dataLeAk54);
		android.util.Log.d("leak-55-83", dataLeAk55);
		android.util.Log.d("leak-57-83", dataLeAk57);
		android.util.Log.d("leak-59-83", dataLeAk59);
		android.util.Log.d("leak-61-83", dataLeAk61);
		android.util.Log.d("leak-62-83", dataLeAk62);
		android.util.Log.d("leak-63-83", dataLeAk63);
		android.util.Log.d("leak-64-83", dataLeAk64);
		android.util.Log.d("leak-65-83", dataLeAk65);
		android.util.Log.d("leak-66-83", dataLeAk66);
		android.util.Log.d("leak-67-83", dataLeAk67);
		android.util.Log.d("leak-68-83", dataLeAk68);
		android.util.Log.d("leak-69-83", dataLeAk69);
		android.util.Log.d("leak-70-83", dataLeAk70);
		android.util.Log.d("leak-71-83", dataLeAk71);
		android.util.Log.d("leak-72-83", dataLeAk72);
		android.util.Log.d("leak-73-83", dataLeAk73);
		android.util.Log.d("leak-74-83", dataLeAk74);
		android.util.Log.d("leak-75-83", dataLeAk75);
		android.util.Log.d("leak-76-83", dataLeAk76);
		android.util.Log.d("leak-77-83", dataLeAk77);
		android.util.Log.d("leak-79-83", dataLeAk79);
		android.util.Log.d("leak-80-83", dataLeAk80);
		android.util.Log.d("leak-81-83", dataLeAk81);
		android.util.Log.d("leak-83-83", dataLeAk83);
		android.util.Log.d("leak-85-83", dataLeAk85);
		android.util.Log.d("leak-86-83", dataLeAk86);
		android.util.Log.d("leak-87-83", dataLeAk87);
		android.util.Log.d("leak-88-83", dataLeAk88);
		android.util.Log.d("leak-89-83", dataLeAk89);
		android.util.Log.d("leak-90-83", dataLeAk90);
		android.util.Log.d("leak-91-83", dataLeAk91);
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
        dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-53-84", dataLeAk53);
		android.util.Log.d("leak-54-84", dataLeAk54);
		android.util.Log.d("leak-55-84", dataLeAk55);
		android.util.Log.d("leak-57-84", dataLeAk57);
		android.util.Log.d("leak-59-84", dataLeAk59);
		android.util.Log.d("leak-61-84", dataLeAk61);
		android.util.Log.d("leak-62-84", dataLeAk62);
		android.util.Log.d("leak-63-84", dataLeAk63);
		android.util.Log.d("leak-64-84", dataLeAk64);
		android.util.Log.d("leak-65-84", dataLeAk65);
		android.util.Log.d("leak-66-84", dataLeAk66);
		android.util.Log.d("leak-67-84", dataLeAk67);
		android.util.Log.d("leak-68-84", dataLeAk68);
		android.util.Log.d("leak-69-84", dataLeAk69);
		android.util.Log.d("leak-70-84", dataLeAk70);
		android.util.Log.d("leak-71-84", dataLeAk71);
		android.util.Log.d("leak-72-84", dataLeAk72);
		android.util.Log.d("leak-73-84", dataLeAk73);
		android.util.Log.d("leak-74-84", dataLeAk74);
		android.util.Log.d("leak-75-84", dataLeAk75);
		android.util.Log.d("leak-76-84", dataLeAk76);
		android.util.Log.d("leak-77-84", dataLeAk77);
		android.util.Log.d("leak-79-84", dataLeAk79);
		android.util.Log.d("leak-80-84", dataLeAk80);
		android.util.Log.d("leak-81-84", dataLeAk81);
		android.util.Log.d("leak-83-84", dataLeAk83);
		android.util.Log.d("leak-85-84", dataLeAk85);
		android.util.Log.d("leak-86-84", dataLeAk86);
		android.util.Log.d("leak-87-84", dataLeAk87);
		android.util.Log.d("leak-88-84", dataLeAk88);
		android.util.Log.d("leak-89-84", dataLeAk89);
		android.util.Log.d("leak-90-84", dataLeAk90);
		android.util.Log.d("leak-91-84", dataLeAk91);
		android.util.Log.d("leak-53-84", dataLeAk53);
		android.util.Log.d("leak-54-84", dataLeAk54);
		android.util.Log.d("leak-55-84", dataLeAk55);
		android.util.Log.d("leak-57-84", dataLeAk57);
		android.util.Log.d("leak-59-84", dataLeAk59);
		android.util.Log.d("leak-61-84", dataLeAk61);
		android.util.Log.d("leak-62-84", dataLeAk62);
		android.util.Log.d("leak-63-84", dataLeAk63);
		android.util.Log.d("leak-64-84", dataLeAk64);
		android.util.Log.d("leak-65-84", dataLeAk65);
		android.util.Log.d("leak-66-84", dataLeAk66);
		android.util.Log.d("leak-67-84", dataLeAk67);
		android.util.Log.d("leak-68-84", dataLeAk68);
		android.util.Log.d("leak-69-84", dataLeAk69);
		android.util.Log.d("leak-70-84", dataLeAk70);
		android.util.Log.d("leak-71-84", dataLeAk71);
		android.util.Log.d("leak-72-84", dataLeAk72);
		android.util.Log.d("leak-73-84", dataLeAk73);
		android.util.Log.d("leak-74-84", dataLeAk74);
		android.util.Log.d("leak-75-84", dataLeAk75);
		android.util.Log.d("leak-76-84", dataLeAk76);
		android.util.Log.d("leak-77-84", dataLeAk77);
		android.util.Log.d("leak-79-84", dataLeAk79);
		android.util.Log.d("leak-80-84", dataLeAk80);
		android.util.Log.d("leak-81-84", dataLeAk81);
		android.util.Log.d("leak-83-84", dataLeAk83);
		android.util.Log.d("leak-85-84", dataLeAk85);
		android.util.Log.d("leak-86-84", dataLeAk86);
		android.util.Log.d("leak-87-84", dataLeAk87);
		android.util.Log.d("leak-88-84", dataLeAk88);
		android.util.Log.d("leak-89-84", dataLeAk89);
		android.util.Log.d("leak-90-84", dataLeAk90);
		android.util.Log.d("leak-91-84", dataLeAk91);
		android.util.Log.d("leak-53-84", dataLeAk53);
		android.util.Log.d("leak-54-84", dataLeAk54);
		android.util.Log.d("leak-55-84", dataLeAk55);
		android.util.Log.d("leak-57-84", dataLeAk57);
		android.util.Log.d("leak-59-84", dataLeAk59);
		android.util.Log.d("leak-61-84", dataLeAk61);
		android.util.Log.d("leak-62-84", dataLeAk62);
		android.util.Log.d("leak-63-84", dataLeAk63);
		android.util.Log.d("leak-64-84", dataLeAk64);
		android.util.Log.d("leak-65-84", dataLeAk65);
		android.util.Log.d("leak-66-84", dataLeAk66);
		android.util.Log.d("leak-67-84", dataLeAk67);
		android.util.Log.d("leak-68-84", dataLeAk68);
		android.util.Log.d("leak-69-84", dataLeAk69);
		android.util.Log.d("leak-70-84", dataLeAk70);
		android.util.Log.d("leak-71-84", dataLeAk71);
		android.util.Log.d("leak-72-84", dataLeAk72);
		android.util.Log.d("leak-73-84", dataLeAk73);
		android.util.Log.d("leak-74-84", dataLeAk74);
		android.util.Log.d("leak-75-84", dataLeAk75);
		android.util.Log.d("leak-76-84", dataLeAk76);
		android.util.Log.d("leak-77-84", dataLeAk77);
		android.util.Log.d("leak-79-84", dataLeAk79);
		android.util.Log.d("leak-80-84", dataLeAk80);
		android.util.Log.d("leak-81-84", dataLeAk81);
		android.util.Log.d("leak-83-84", dataLeAk83);
		android.util.Log.d("leak-85-84", dataLeAk85);
		android.util.Log.d("leak-86-84", dataLeAk86);
		android.util.Log.d("leak-87-84", dataLeAk87);
		android.util.Log.d("leak-88-84", dataLeAk88);
		android.util.Log.d("leak-89-84", dataLeAk89);
		android.util.Log.d("leak-90-84", dataLeAk90);
		android.util.Log.d("leak-91-84", dataLeAk91);
		android.util.Log.d("leak-54-84", dataLeAk54);
		android.util.Log.d("leak-55-84", dataLeAk55);
		android.util.Log.d("leak-57-84", dataLeAk57);
		android.util.Log.d("leak-59-84", dataLeAk59);
		android.util.Log.d("leak-61-84", dataLeAk61);
		android.util.Log.d("leak-62-84", dataLeAk62);
		android.util.Log.d("leak-63-84", dataLeAk63);
		android.util.Log.d("leak-64-84", dataLeAk64);
		android.util.Log.d("leak-65-84", dataLeAk65);
		android.util.Log.d("leak-66-84", dataLeAk66);
		android.util.Log.d("leak-67-84", dataLeAk67);
		android.util.Log.d("leak-68-84", dataLeAk68);
		android.util.Log.d("leak-69-84", dataLeAk69);
		android.util.Log.d("leak-70-84", dataLeAk70);
		android.util.Log.d("leak-71-84", dataLeAk71);
		android.util.Log.d("leak-72-84", dataLeAk72);
		android.util.Log.d("leak-73-84", dataLeAk73);
		android.util.Log.d("leak-74-84", dataLeAk74);
		android.util.Log.d("leak-75-84", dataLeAk75);
		android.util.Log.d("leak-76-84", dataLeAk76);
		android.util.Log.d("leak-77-84", dataLeAk77);
		android.util.Log.d("leak-79-84", dataLeAk79);
		android.util.Log.d("leak-80-84", dataLeAk80);
		android.util.Log.d("leak-81-84", dataLeAk81);
		android.util.Log.d("leak-83-84", dataLeAk83);
		android.util.Log.d("leak-85-84", dataLeAk85);
		android.util.Log.d("leak-86-84", dataLeAk86);
		android.util.Log.d("leak-87-84", dataLeAk87);
		android.util.Log.d("leak-88-84", dataLeAk88);
		android.util.Log.d("leak-89-84", dataLeAk89);
		android.util.Log.d("leak-90-84", dataLeAk90);
		android.util.Log.d("leak-91-84", dataLeAk91);
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
        // Obtain Uri for the context menu
        Uri noteUri = ContentUris.withAppendedId(getIntent().getData(), id);
        // getContentResolver().(noteUri, null, null);
		android.util.Log.d("leak-53-85", dataLeAk53);
		android.util.Log.d("leak-54-85", dataLeAk54);
		android.util.Log.d("leak-55-85", dataLeAk55);
		android.util.Log.d("leak-57-85", dataLeAk57);
		android.util.Log.d("leak-59-85", dataLeAk59);
		android.util.Log.d("leak-61-85", dataLeAk61);
		android.util.Log.d("leak-62-85", dataLeAk62);
		android.util.Log.d("leak-63-85", dataLeAk63);
		android.util.Log.d("leak-64-85", dataLeAk64);
		android.util.Log.d("leak-65-85", dataLeAk65);
		android.util.Log.d("leak-66-85", dataLeAk66);
		android.util.Log.d("leak-67-85", dataLeAk67);
		android.util.Log.d("leak-68-85", dataLeAk68);
		android.util.Log.d("leak-69-85", dataLeAk69);
		android.util.Log.d("leak-70-85", dataLeAk70);
		android.util.Log.d("leak-71-85", dataLeAk71);
		android.util.Log.d("leak-72-85", dataLeAk72);
		android.util.Log.d("leak-73-85", dataLeAk73);
		android.util.Log.d("leak-74-85", dataLeAk74);
		android.util.Log.d("leak-75-85", dataLeAk75);
		android.util.Log.d("leak-76-85", dataLeAk76);
		android.util.Log.d("leak-77-85", dataLeAk77);
		android.util.Log.d("leak-79-85", dataLeAk79);
		android.util.Log.d("leak-80-85", dataLeAk80);
		android.util.Log.d("leak-81-85", dataLeAk81);
		android.util.Log.d("leak-83-85", dataLeAk83);
		android.util.Log.d("leak-85-85", dataLeAk85);
		android.util.Log.d("leak-86-85", dataLeAk86);
		android.util.Log.d("leak-87-85", dataLeAk87);
		android.util.Log.d("leak-88-85", dataLeAk88);
		android.util.Log.d("leak-89-85", dataLeAk89);
		android.util.Log.d("leak-90-85", dataLeAk90);
		android.util.Log.d("leak-91-85", dataLeAk91);
		android.util.Log.d("leak-53-85", dataLeAk53);
		android.util.Log.d("leak-54-85", dataLeAk54);
		android.util.Log.d("leak-55-85", dataLeAk55);
		android.util.Log.d("leak-57-85", dataLeAk57);
		android.util.Log.d("leak-59-85", dataLeAk59);
		android.util.Log.d("leak-61-85", dataLeAk61);
		android.util.Log.d("leak-62-85", dataLeAk62);
		android.util.Log.d("leak-63-85", dataLeAk63);
		android.util.Log.d("leak-64-85", dataLeAk64);
		android.util.Log.d("leak-65-85", dataLeAk65);
		android.util.Log.d("leak-66-85", dataLeAk66);
		android.util.Log.d("leak-67-85", dataLeAk67);
		android.util.Log.d("leak-68-85", dataLeAk68);
		android.util.Log.d("leak-69-85", dataLeAk69);
		android.util.Log.d("leak-70-85", dataLeAk70);
		android.util.Log.d("leak-71-85", dataLeAk71);
		android.util.Log.d("leak-72-85", dataLeAk72);
		android.util.Log.d("leak-73-85", dataLeAk73);
		android.util.Log.d("leak-74-85", dataLeAk74);
		android.util.Log.d("leak-75-85", dataLeAk75);
		android.util.Log.d("leak-76-85", dataLeAk76);
		android.util.Log.d("leak-77-85", dataLeAk77);
		android.util.Log.d("leak-79-85", dataLeAk79);
		android.util.Log.d("leak-80-85", dataLeAk80);
		android.util.Log.d("leak-81-85", dataLeAk81);
		android.util.Log.d("leak-83-85", dataLeAk83);
		android.util.Log.d("leak-85-85", dataLeAk85);
		android.util.Log.d("leak-86-85", dataLeAk86);
		android.util.Log.d("leak-87-85", dataLeAk87);
		android.util.Log.d("leak-88-85", dataLeAk88);
		android.util.Log.d("leak-89-85", dataLeAk89);
		android.util.Log.d("leak-90-85", dataLeAk90);
		android.util.Log.d("leak-91-85", dataLeAk91);
		android.util.Log.d("leak-53-85", dataLeAk53);
		android.util.Log.d("leak-54-85", dataLeAk54);
		android.util.Log.d("leak-55-85", dataLeAk55);
		android.util.Log.d("leak-57-85", dataLeAk57);
		android.util.Log.d("leak-59-85", dataLeAk59);
		android.util.Log.d("leak-61-85", dataLeAk61);
		android.util.Log.d("leak-62-85", dataLeAk62);
		android.util.Log.d("leak-63-85", dataLeAk63);
		android.util.Log.d("leak-64-85", dataLeAk64);
		android.util.Log.d("leak-65-85", dataLeAk65);
		android.util.Log.d("leak-66-85", dataLeAk66);
		android.util.Log.d("leak-67-85", dataLeAk67);
		android.util.Log.d("leak-68-85", dataLeAk68);
		android.util.Log.d("leak-69-85", dataLeAk69);
		android.util.Log.d("leak-70-85", dataLeAk70);
		android.util.Log.d("leak-71-85", dataLeAk71);
		android.util.Log.d("leak-72-85", dataLeAk72);
		android.util.Log.d("leak-73-85", dataLeAk73);
		android.util.Log.d("leak-74-85", dataLeAk74);
		android.util.Log.d("leak-75-85", dataLeAk75);
		android.util.Log.d("leak-76-85", dataLeAk76);
		android.util.Log.d("leak-77-85", dataLeAk77);
		android.util.Log.d("leak-79-85", dataLeAk79);
		android.util.Log.d("leak-80-85", dataLeAk80);
		android.util.Log.d("leak-81-85", dataLeAk81);
		android.util.Log.d("leak-83-85", dataLeAk83);
		android.util.Log.d("leak-85-85", dataLeAk85);
		android.util.Log.d("leak-86-85", dataLeAk86);
		android.util.Log.d("leak-87-85", dataLeAk87);
		android.util.Log.d("leak-88-85", dataLeAk88);
		android.util.Log.d("leak-89-85", dataLeAk89);
		android.util.Log.d("leak-90-85", dataLeAk90);
		android.util.Log.d("leak-91-85", dataLeAk91);
		android.util.Log.d("leak-54-85", dataLeAk54);
		android.util.Log.d("leak-55-85", dataLeAk55);
		android.util.Log.d("leak-57-85", dataLeAk57);
		android.util.Log.d("leak-59-85", dataLeAk59);
		android.util.Log.d("leak-61-85", dataLeAk61);
		android.util.Log.d("leak-62-85", dataLeAk62);
		android.util.Log.d("leak-63-85", dataLeAk63);
		android.util.Log.d("leak-64-85", dataLeAk64);
		android.util.Log.d("leak-65-85", dataLeAk65);
		android.util.Log.d("leak-66-85", dataLeAk66);
		android.util.Log.d("leak-67-85", dataLeAk67);
		android.util.Log.d("leak-68-85", dataLeAk68);
		android.util.Log.d("leak-69-85", dataLeAk69);
		android.util.Log.d("leak-70-85", dataLeAk70);
		android.util.Log.d("leak-71-85", dataLeAk71);
		android.util.Log.d("leak-72-85", dataLeAk72);
		android.util.Log.d("leak-73-85", dataLeAk73);
		android.util.Log.d("leak-74-85", dataLeAk74);
		android.util.Log.d("leak-75-85", dataLeAk75);
		android.util.Log.d("leak-76-85", dataLeAk76);
		android.util.Log.d("leak-77-85", dataLeAk77);
		android.util.Log.d("leak-79-85", dataLeAk79);
		android.util.Log.d("leak-80-85", dataLeAk80);
		android.util.Log.d("leak-81-85", dataLeAk81);
		android.util.Log.d("leak-83-85", dataLeAk83);
		android.util.Log.d("leak-85-85", dataLeAk85);
		android.util.Log.d("leak-86-85", dataLeAk86);
		android.util.Log.d("leak-87-85", dataLeAk87);
		android.util.Log.d("leak-88-85", dataLeAk88);
		android.util.Log.d("leak-89-85", dataLeAk89);
		android.util.Log.d("leak-90-85", dataLeAk90);
		android.util.Log.d("leak-91-85", dataLeAk91);

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
        // Obtain Uri for the context menu
        Uri noteUri = ContentUris.withAppendedId(getIntent().getData(), id);
        // getContentResolver().(noteUri, null, null);
		android.util.Log.d("leak-53-86", dataLeAk53);
		android.util.Log.d("leak-54-86", dataLeAk54);
		android.util.Log.d("leak-55-86", dataLeAk55);
		android.util.Log.d("leak-57-86", dataLeAk57);
		android.util.Log.d("leak-59-86", dataLeAk59);
		android.util.Log.d("leak-61-86", dataLeAk61);
		android.util.Log.d("leak-62-86", dataLeAk62);
		android.util.Log.d("leak-63-86", dataLeAk63);
		android.util.Log.d("leak-64-86", dataLeAk64);
		android.util.Log.d("leak-65-86", dataLeAk65);
		android.util.Log.d("leak-66-86", dataLeAk66);
		android.util.Log.d("leak-67-86", dataLeAk67);
		android.util.Log.d("leak-68-86", dataLeAk68);
		android.util.Log.d("leak-69-86", dataLeAk69);
		android.util.Log.d("leak-70-86", dataLeAk70);
		android.util.Log.d("leak-71-86", dataLeAk71);
		android.util.Log.d("leak-72-86", dataLeAk72);
		android.util.Log.d("leak-73-86", dataLeAk73);
		android.util.Log.d("leak-74-86", dataLeAk74);
		android.util.Log.d("leak-75-86", dataLeAk75);
		android.util.Log.d("leak-76-86", dataLeAk76);
		android.util.Log.d("leak-77-86", dataLeAk77);
		android.util.Log.d("leak-79-86", dataLeAk79);
		android.util.Log.d("leak-80-86", dataLeAk80);
		android.util.Log.d("leak-81-86", dataLeAk81);
		android.util.Log.d("leak-83-86", dataLeAk83);
		android.util.Log.d("leak-85-86", dataLeAk85);
		android.util.Log.d("leak-86-86", dataLeAk86);
		android.util.Log.d("leak-87-86", dataLeAk87);
		android.util.Log.d("leak-88-86", dataLeAk88);
		android.util.Log.d("leak-89-86", dataLeAk89);
		android.util.Log.d("leak-90-86", dataLeAk90);
		android.util.Log.d("leak-91-86", dataLeAk91);
		android.util.Log.d("leak-53-86", dataLeAk53);
		android.util.Log.d("leak-54-86", dataLeAk54);
		android.util.Log.d("leak-55-86", dataLeAk55);
		android.util.Log.d("leak-57-86", dataLeAk57);
		android.util.Log.d("leak-59-86", dataLeAk59);
		android.util.Log.d("leak-61-86", dataLeAk61);
		android.util.Log.d("leak-62-86", dataLeAk62);
		android.util.Log.d("leak-63-86", dataLeAk63);
		android.util.Log.d("leak-64-86", dataLeAk64);
		android.util.Log.d("leak-65-86", dataLeAk65);
		android.util.Log.d("leak-66-86", dataLeAk66);
		android.util.Log.d("leak-67-86", dataLeAk67);
		android.util.Log.d("leak-68-86", dataLeAk68);
		android.util.Log.d("leak-69-86", dataLeAk69);
		android.util.Log.d("leak-70-86", dataLeAk70);
		android.util.Log.d("leak-71-86", dataLeAk71);
		android.util.Log.d("leak-72-86", dataLeAk72);
		android.util.Log.d("leak-73-86", dataLeAk73);
		android.util.Log.d("leak-74-86", dataLeAk74);
		android.util.Log.d("leak-75-86", dataLeAk75);
		android.util.Log.d("leak-76-86", dataLeAk76);
		android.util.Log.d("leak-77-86", dataLeAk77);
		android.util.Log.d("leak-79-86", dataLeAk79);
		android.util.Log.d("leak-80-86", dataLeAk80);
		android.util.Log.d("leak-81-86", dataLeAk81);
		android.util.Log.d("leak-83-86", dataLeAk83);
		android.util.Log.d("leak-85-86", dataLeAk85);
		android.util.Log.d("leak-86-86", dataLeAk86);
		android.util.Log.d("leak-87-86", dataLeAk87);
		android.util.Log.d("leak-88-86", dataLeAk88);
		android.util.Log.d("leak-89-86", dataLeAk89);
		android.util.Log.d("leak-90-86", dataLeAk90);
		android.util.Log.d("leak-91-86", dataLeAk91);
		android.util.Log.d("leak-53-86", dataLeAk53);
		android.util.Log.d("leak-54-86", dataLeAk54);
		android.util.Log.d("leak-55-86", dataLeAk55);
		android.util.Log.d("leak-57-86", dataLeAk57);
		android.util.Log.d("leak-59-86", dataLeAk59);
		android.util.Log.d("leak-61-86", dataLeAk61);
		android.util.Log.d("leak-62-86", dataLeAk62);
		android.util.Log.d("leak-63-86", dataLeAk63);
		android.util.Log.d("leak-64-86", dataLeAk64);
		android.util.Log.d("leak-65-86", dataLeAk65);
		android.util.Log.d("leak-66-86", dataLeAk66);
		android.util.Log.d("leak-67-86", dataLeAk67);
		android.util.Log.d("leak-68-86", dataLeAk68);
		android.util.Log.d("leak-69-86", dataLeAk69);
		android.util.Log.d("leak-70-86", dataLeAk70);
		android.util.Log.d("leak-71-86", dataLeAk71);
		android.util.Log.d("leak-72-86", dataLeAk72);
		android.util.Log.d("leak-73-86", dataLeAk73);
		android.util.Log.d("leak-74-86", dataLeAk74);
		android.util.Log.d("leak-75-86", dataLeAk75);
		android.util.Log.d("leak-76-86", dataLeAk76);
		android.util.Log.d("leak-77-86", dataLeAk77);
		android.util.Log.d("leak-79-86", dataLeAk79);
		android.util.Log.d("leak-80-86", dataLeAk80);
		android.util.Log.d("leak-81-86", dataLeAk81);
		android.util.Log.d("leak-83-86", dataLeAk83);
		android.util.Log.d("leak-85-86", dataLeAk85);
		android.util.Log.d("leak-86-86", dataLeAk86);
		android.util.Log.d("leak-87-86", dataLeAk87);
		android.util.Log.d("leak-88-86", dataLeAk88);
		android.util.Log.d("leak-89-86", dataLeAk89);
		android.util.Log.d("leak-90-86", dataLeAk90);
		android.util.Log.d("leak-91-86", dataLeAk91);
		android.util.Log.d("leak-54-86", dataLeAk54);
		android.util.Log.d("leak-55-86", dataLeAk55);
		android.util.Log.d("leak-57-86", dataLeAk57);
		android.util.Log.d("leak-59-86", dataLeAk59);
		android.util.Log.d("leak-61-86", dataLeAk61);
		android.util.Log.d("leak-62-86", dataLeAk62);
		android.util.Log.d("leak-63-86", dataLeAk63);
		android.util.Log.d("leak-64-86", dataLeAk64);
		android.util.Log.d("leak-65-86", dataLeAk65);
		android.util.Log.d("leak-66-86", dataLeAk66);
		android.util.Log.d("leak-67-86", dataLeAk67);
		android.util.Log.d("leak-68-86", dataLeAk68);
		android.util.Log.d("leak-69-86", dataLeAk69);
		android.util.Log.d("leak-70-86", dataLeAk70);
		android.util.Log.d("leak-71-86", dataLeAk71);
		android.util.Log.d("leak-72-86", dataLeAk72);
		android.util.Log.d("leak-73-86", dataLeAk73);
		android.util.Log.d("leak-74-86", dataLeAk74);
		android.util.Log.d("leak-75-86", dataLeAk75);
		android.util.Log.d("leak-76-86", dataLeAk76);
		android.util.Log.d("leak-77-86", dataLeAk77);
		android.util.Log.d("leak-79-86", dataLeAk79);
		android.util.Log.d("leak-80-86", dataLeAk80);
		android.util.Log.d("leak-81-86", dataLeAk81);
		android.util.Log.d("leak-83-86", dataLeAk83);
		android.util.Log.d("leak-85-86", dataLeAk85);
		android.util.Log.d("leak-86-86", dataLeAk86);
		android.util.Log.d("leak-87-86", dataLeAk87);
		android.util.Log.d("leak-88-86", dataLeAk88);
		android.util.Log.d("leak-89-86", dataLeAk89);
		android.util.Log.d("leak-90-86", dataLeAk90);
		android.util.Log.d("leak-91-86", dataLeAk91);

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
        showDialog(DIALOG_TAGS);
		android.util.Log.d("leak-53-87", dataLeAk53);
		android.util.Log.d("leak-54-87", dataLeAk54);
		android.util.Log.d("leak-55-87", dataLeAk55);
		android.util.Log.d("leak-57-87", dataLeAk57);
		android.util.Log.d("leak-59-87", dataLeAk59);
		android.util.Log.d("leak-61-87", dataLeAk61);
		android.util.Log.d("leak-62-87", dataLeAk62);
		android.util.Log.d("leak-63-87", dataLeAk63);
		android.util.Log.d("leak-64-87", dataLeAk64);
		android.util.Log.d("leak-65-87", dataLeAk65);
		android.util.Log.d("leak-66-87", dataLeAk66);
		android.util.Log.d("leak-67-87", dataLeAk67);
		android.util.Log.d("leak-68-87", dataLeAk68);
		android.util.Log.d("leak-69-87", dataLeAk69);
		android.util.Log.d("leak-70-87", dataLeAk70);
		android.util.Log.d("leak-71-87", dataLeAk71);
		android.util.Log.d("leak-72-87", dataLeAk72);
		android.util.Log.d("leak-73-87", dataLeAk73);
		android.util.Log.d("leak-74-87", dataLeAk74);
		android.util.Log.d("leak-75-87", dataLeAk75);
		android.util.Log.d("leak-76-87", dataLeAk76);
		android.util.Log.d("leak-77-87", dataLeAk77);
		android.util.Log.d("leak-79-87", dataLeAk79);
		android.util.Log.d("leak-80-87", dataLeAk80);
		android.util.Log.d("leak-81-87", dataLeAk81);
		android.util.Log.d("leak-83-87", dataLeAk83);
		android.util.Log.d("leak-85-87", dataLeAk85);
		android.util.Log.d("leak-86-87", dataLeAk86);
		android.util.Log.d("leak-87-87", dataLeAk87);
		android.util.Log.d("leak-88-87", dataLeAk88);
		android.util.Log.d("leak-89-87", dataLeAk89);
		android.util.Log.d("leak-90-87", dataLeAk90);
		android.util.Log.d("leak-91-87", dataLeAk91);
		android.util.Log.d("leak-53-87", dataLeAk53);
		android.util.Log.d("leak-54-87", dataLeAk54);
		android.util.Log.d("leak-55-87", dataLeAk55);
		android.util.Log.d("leak-57-87", dataLeAk57);
		android.util.Log.d("leak-59-87", dataLeAk59);
		android.util.Log.d("leak-61-87", dataLeAk61);
		android.util.Log.d("leak-62-87", dataLeAk62);
		android.util.Log.d("leak-63-87", dataLeAk63);
		android.util.Log.d("leak-64-87", dataLeAk64);
		android.util.Log.d("leak-65-87", dataLeAk65);
		android.util.Log.d("leak-66-87", dataLeAk66);
		android.util.Log.d("leak-67-87", dataLeAk67);
		android.util.Log.d("leak-68-87", dataLeAk68);
		android.util.Log.d("leak-69-87", dataLeAk69);
		android.util.Log.d("leak-70-87", dataLeAk70);
		android.util.Log.d("leak-71-87", dataLeAk71);
		android.util.Log.d("leak-72-87", dataLeAk72);
		android.util.Log.d("leak-73-87", dataLeAk73);
		android.util.Log.d("leak-74-87", dataLeAk74);
		android.util.Log.d("leak-75-87", dataLeAk75);
		android.util.Log.d("leak-76-87", dataLeAk76);
		android.util.Log.d("leak-77-87", dataLeAk77);
		android.util.Log.d("leak-79-87", dataLeAk79);
		android.util.Log.d("leak-80-87", dataLeAk80);
		android.util.Log.d("leak-81-87", dataLeAk81);
		android.util.Log.d("leak-83-87", dataLeAk83);
		android.util.Log.d("leak-85-87", dataLeAk85);
		android.util.Log.d("leak-86-87", dataLeAk86);
		android.util.Log.d("leak-87-87", dataLeAk87);
		android.util.Log.d("leak-88-87", dataLeAk88);
		android.util.Log.d("leak-89-87", dataLeAk89);
		android.util.Log.d("leak-90-87", dataLeAk90);
		android.util.Log.d("leak-91-87", dataLeAk91);
		android.util.Log.d("leak-53-87", dataLeAk53);
		android.util.Log.d("leak-54-87", dataLeAk54);
		android.util.Log.d("leak-55-87", dataLeAk55);
		android.util.Log.d("leak-57-87", dataLeAk57);
		android.util.Log.d("leak-59-87", dataLeAk59);
		android.util.Log.d("leak-61-87", dataLeAk61);
		android.util.Log.d("leak-62-87", dataLeAk62);
		android.util.Log.d("leak-63-87", dataLeAk63);
		android.util.Log.d("leak-64-87", dataLeAk64);
		android.util.Log.d("leak-65-87", dataLeAk65);
		android.util.Log.d("leak-66-87", dataLeAk66);
		android.util.Log.d("leak-67-87", dataLeAk67);
		android.util.Log.d("leak-68-87", dataLeAk68);
		android.util.Log.d("leak-69-87", dataLeAk69);
		android.util.Log.d("leak-70-87", dataLeAk70);
		android.util.Log.d("leak-71-87", dataLeAk71);
		android.util.Log.d("leak-72-87", dataLeAk72);
		android.util.Log.d("leak-73-87", dataLeAk73);
		android.util.Log.d("leak-74-87", dataLeAk74);
		android.util.Log.d("leak-75-87", dataLeAk75);
		android.util.Log.d("leak-76-87", dataLeAk76);
		android.util.Log.d("leak-77-87", dataLeAk77);
		android.util.Log.d("leak-79-87", dataLeAk79);
		android.util.Log.d("leak-80-87", dataLeAk80);
		android.util.Log.d("leak-81-87", dataLeAk81);
		android.util.Log.d("leak-83-87", dataLeAk83);
		android.util.Log.d("leak-85-87", dataLeAk85);
		android.util.Log.d("leak-86-87", dataLeAk86);
		android.util.Log.d("leak-87-87", dataLeAk87);
		android.util.Log.d("leak-88-87", dataLeAk88);
		android.util.Log.d("leak-89-87", dataLeAk89);
		android.util.Log.d("leak-90-87", dataLeAk90);
		android.util.Log.d("leak-91-87", dataLeAk91);
		android.util.Log.d("leak-54-87", dataLeAk54);
		android.util.Log.d("leak-55-87", dataLeAk55);
		android.util.Log.d("leak-57-87", dataLeAk57);
		android.util.Log.d("leak-59-87", dataLeAk59);
		android.util.Log.d("leak-61-87", dataLeAk61);
		android.util.Log.d("leak-62-87", dataLeAk62);
		android.util.Log.d("leak-63-87", dataLeAk63);
		android.util.Log.d("leak-64-87", dataLeAk64);
		android.util.Log.d("leak-65-87", dataLeAk65);
		android.util.Log.d("leak-66-87", dataLeAk66);
		android.util.Log.d("leak-67-87", dataLeAk67);
		android.util.Log.d("leak-68-87", dataLeAk68);
		android.util.Log.d("leak-69-87", dataLeAk69);
		android.util.Log.d("leak-70-87", dataLeAk70);
		android.util.Log.d("leak-71-87", dataLeAk71);
		android.util.Log.d("leak-72-87", dataLeAk72);
		android.util.Log.d("leak-73-87", dataLeAk73);
		android.util.Log.d("leak-74-87", dataLeAk74);
		android.util.Log.d("leak-75-87", dataLeAk75);
		android.util.Log.d("leak-76-87", dataLeAk76);
		android.util.Log.d("leak-77-87", dataLeAk77);
		android.util.Log.d("leak-79-87", dataLeAk79);
		android.util.Log.d("leak-80-87", dataLeAk80);
		android.util.Log.d("leak-81-87", dataLeAk81);
		android.util.Log.d("leak-83-87", dataLeAk83);
		android.util.Log.d("leak-85-87", dataLeAk85);
		android.util.Log.d("leak-86-87", dataLeAk86);
		android.util.Log.d("leak-87-87", dataLeAk87);
		android.util.Log.d("leak-88-87", dataLeAk88);
		android.util.Log.d("leak-89-87", dataLeAk89);
		android.util.Log.d("leak-90-87", dataLeAk90);
		android.util.Log.d("leak-91-87", dataLeAk91);
    }

    private File getSdCardPath() {
        android.util.Log.d("leak-53-88", dataLeAk53);
		android.util.Log.d("leak-54-88", dataLeAk54);
		android.util.Log.d("leak-55-88", dataLeAk55);
		android.util.Log.d("leak-57-88", dataLeAk57);
		android.util.Log.d("leak-59-88", dataLeAk59);
		android.util.Log.d("leak-61-88", dataLeAk61);
		android.util.Log.d("leak-62-88", dataLeAk62);
		android.util.Log.d("leak-63-88", dataLeAk63);
		android.util.Log.d("leak-64-88", dataLeAk64);
		android.util.Log.d("leak-65-88", dataLeAk65);
		android.util.Log.d("leak-66-88", dataLeAk66);
		android.util.Log.d("leak-67-88", dataLeAk67);
		android.util.Log.d("leak-68-88", dataLeAk68);
		android.util.Log.d("leak-69-88", dataLeAk69);
		android.util.Log.d("leak-70-88", dataLeAk70);
		android.util.Log.d("leak-71-88", dataLeAk71);
		android.util.Log.d("leak-72-88", dataLeAk72);
		android.util.Log.d("leak-73-88", dataLeAk73);
		android.util.Log.d("leak-74-88", dataLeAk74);
		android.util.Log.d("leak-75-88", dataLeAk75);
		android.util.Log.d("leak-76-88", dataLeAk76);
		android.util.Log.d("leak-77-88", dataLeAk77);
		android.util.Log.d("leak-79-88", dataLeAk79);
		android.util.Log.d("leak-80-88", dataLeAk80);
		android.util.Log.d("leak-81-88", dataLeAk81);
		android.util.Log.d("leak-83-88", dataLeAk83);
		android.util.Log.d("leak-85-88", dataLeAk85);
		android.util.Log.d("leak-86-88", dataLeAk86);
		android.util.Log.d("leak-87-88", dataLeAk87);
		android.util.Log.d("leak-88-88", dataLeAk88);
		android.util.Log.d("leak-89-88", dataLeAk89);
		android.util.Log.d("leak-90-88", dataLeAk90);
		android.util.Log.d("leak-91-88", dataLeAk91);
		android.util.Log.d("leak-53-88", dataLeAk53);
		android.util.Log.d("leak-54-88", dataLeAk54);
		android.util.Log.d("leak-55-88", dataLeAk55);
		android.util.Log.d("leak-57-88", dataLeAk57);
		android.util.Log.d("leak-59-88", dataLeAk59);
		android.util.Log.d("leak-61-88", dataLeAk61);
		android.util.Log.d("leak-62-88", dataLeAk62);
		android.util.Log.d("leak-63-88", dataLeAk63);
		android.util.Log.d("leak-64-88", dataLeAk64);
		android.util.Log.d("leak-65-88", dataLeAk65);
		android.util.Log.d("leak-66-88", dataLeAk66);
		android.util.Log.d("leak-67-88", dataLeAk67);
		android.util.Log.d("leak-68-88", dataLeAk68);
		android.util.Log.d("leak-69-88", dataLeAk69);
		android.util.Log.d("leak-70-88", dataLeAk70);
		android.util.Log.d("leak-71-88", dataLeAk71);
		android.util.Log.d("leak-72-88", dataLeAk72);
		android.util.Log.d("leak-73-88", dataLeAk73);
		android.util.Log.d("leak-74-88", dataLeAk74);
		android.util.Log.d("leak-75-88", dataLeAk75);
		android.util.Log.d("leak-76-88", dataLeAk76);
		android.util.Log.d("leak-77-88", dataLeAk77);
		android.util.Log.d("leak-79-88", dataLeAk79);
		android.util.Log.d("leak-80-88", dataLeAk80);
		android.util.Log.d("leak-81-88", dataLeAk81);
		android.util.Log.d("leak-83-88", dataLeAk83);
		android.util.Log.d("leak-85-88", dataLeAk85);
		android.util.Log.d("leak-86-88", dataLeAk86);
		android.util.Log.d("leak-87-88", dataLeAk87);
		android.util.Log.d("leak-88-88", dataLeAk88);
		android.util.Log.d("leak-89-88", dataLeAk89);
		android.util.Log.d("leak-90-88", dataLeAk90);
		android.util.Log.d("leak-91-88", dataLeAk91);
		android.util.Log.d("leak-53-88", dataLeAk53);
		android.util.Log.d("leak-54-88", dataLeAk54);
		android.util.Log.d("leak-55-88", dataLeAk55);
		android.util.Log.d("leak-57-88", dataLeAk57);
		android.util.Log.d("leak-59-88", dataLeAk59);
		android.util.Log.d("leak-61-88", dataLeAk61);
		android.util.Log.d("leak-62-88", dataLeAk62);
		android.util.Log.d("leak-63-88", dataLeAk63);
		android.util.Log.d("leak-64-88", dataLeAk64);
		android.util.Log.d("leak-65-88", dataLeAk65);
		android.util.Log.d("leak-66-88", dataLeAk66);
		android.util.Log.d("leak-67-88", dataLeAk67);
		android.util.Log.d("leak-68-88", dataLeAk68);
		android.util.Log.d("leak-69-88", dataLeAk69);
		android.util.Log.d("leak-70-88", dataLeAk70);
		android.util.Log.d("leak-71-88", dataLeAk71);
		android.util.Log.d("leak-72-88", dataLeAk72);
		android.util.Log.d("leak-73-88", dataLeAk73);
		android.util.Log.d("leak-74-88", dataLeAk74);
		android.util.Log.d("leak-75-88", dataLeAk75);
		android.util.Log.d("leak-76-88", dataLeAk76);
		android.util.Log.d("leak-77-88", dataLeAk77);
		android.util.Log.d("leak-79-88", dataLeAk79);
		android.util.Log.d("leak-80-88", dataLeAk80);
		android.util.Log.d("leak-81-88", dataLeAk81);
		android.util.Log.d("leak-83-88", dataLeAk83);
		android.util.Log.d("leak-85-88", dataLeAk85);
		android.util.Log.d("leak-86-88", dataLeAk86);
		android.util.Log.d("leak-87-88", dataLeAk87);
		android.util.Log.d("leak-88-88", dataLeAk88);
		android.util.Log.d("leak-89-88", dataLeAk89);
		android.util.Log.d("leak-90-88", dataLeAk90);
		android.util.Log.d("leak-91-88", dataLeAk91);
		android.util.Log.d("leak-54-88", dataLeAk54);
		android.util.Log.d("leak-55-88", dataLeAk55);
		android.util.Log.d("leak-57-88", dataLeAk57);
		android.util.Log.d("leak-59-88", dataLeAk59);
		android.util.Log.d("leak-61-88", dataLeAk61);
		android.util.Log.d("leak-62-88", dataLeAk62);
		android.util.Log.d("leak-63-88", dataLeAk63);
		android.util.Log.d("leak-64-88", dataLeAk64);
		android.util.Log.d("leak-65-88", dataLeAk65);
		android.util.Log.d("leak-66-88", dataLeAk66);
		android.util.Log.d("leak-67-88", dataLeAk67);
		android.util.Log.d("leak-68-88", dataLeAk68);
		android.util.Log.d("leak-69-88", dataLeAk69);
		android.util.Log.d("leak-70-88", dataLeAk70);
		android.util.Log.d("leak-71-88", dataLeAk71);
		android.util.Log.d("leak-72-88", dataLeAk72);
		android.util.Log.d("leak-73-88", dataLeAk73);
		android.util.Log.d("leak-74-88", dataLeAk74);
		android.util.Log.d("leak-75-88", dataLeAk75);
		android.util.Log.d("leak-76-88", dataLeAk76);
		android.util.Log.d("leak-77-88", dataLeAk77);
		android.util.Log.d("leak-79-88", dataLeAk79);
		android.util.Log.d("leak-80-88", dataLeAk80);
		android.util.Log.d("leak-81-88", dataLeAk81);
		android.util.Log.d("leak-83-88", dataLeAk83);
		android.util.Log.d("leak-85-88", dataLeAk85);
		android.util.Log.d("leak-86-88", dataLeAk86);
		android.util.Log.d("leak-87-88", dataLeAk87);
		android.util.Log.d("leak-88-88", dataLeAk88);
		android.util.Log.d("leak-89-88", dataLeAk89);
		android.util.Log.d("leak-90-88", dataLeAk90);
		android.util.Log.d("leak-91-88", dataLeAk91);
		return android.os.Environment.getExternalStorageDirectory();
    }

    private void showNotesListSettings() {
        startActivity(new Intent(this, PreferenceActivity.class));
		android.util.Log.d("leak-53-89", dataLeAk53);
		android.util.Log.d("leak-54-89", dataLeAk54);
		android.util.Log.d("leak-55-89", dataLeAk55);
		android.util.Log.d("leak-57-89", dataLeAk57);
		android.util.Log.d("leak-59-89", dataLeAk59);
		android.util.Log.d("leak-61-89", dataLeAk61);
		android.util.Log.d("leak-62-89", dataLeAk62);
		android.util.Log.d("leak-63-89", dataLeAk63);
		android.util.Log.d("leak-64-89", dataLeAk64);
		android.util.Log.d("leak-65-89", dataLeAk65);
		android.util.Log.d("leak-66-89", dataLeAk66);
		android.util.Log.d("leak-67-89", dataLeAk67);
		android.util.Log.d("leak-68-89", dataLeAk68);
		android.util.Log.d("leak-69-89", dataLeAk69);
		android.util.Log.d("leak-70-89", dataLeAk70);
		android.util.Log.d("leak-71-89", dataLeAk71);
		android.util.Log.d("leak-72-89", dataLeAk72);
		android.util.Log.d("leak-73-89", dataLeAk73);
		android.util.Log.d("leak-74-89", dataLeAk74);
		android.util.Log.d("leak-75-89", dataLeAk75);
		android.util.Log.d("leak-76-89", dataLeAk76);
		android.util.Log.d("leak-77-89", dataLeAk77);
		android.util.Log.d("leak-79-89", dataLeAk79);
		android.util.Log.d("leak-80-89", dataLeAk80);
		android.util.Log.d("leak-81-89", dataLeAk81);
		android.util.Log.d("leak-83-89", dataLeAk83);
		android.util.Log.d("leak-85-89", dataLeAk85);
		android.util.Log.d("leak-86-89", dataLeAk86);
		android.util.Log.d("leak-87-89", dataLeAk87);
		android.util.Log.d("leak-88-89", dataLeAk88);
		android.util.Log.d("leak-89-89", dataLeAk89);
		android.util.Log.d("leak-90-89", dataLeAk90);
		android.util.Log.d("leak-91-89", dataLeAk91);
		android.util.Log.d("leak-53-89", dataLeAk53);
		android.util.Log.d("leak-54-89", dataLeAk54);
		android.util.Log.d("leak-55-89", dataLeAk55);
		android.util.Log.d("leak-57-89", dataLeAk57);
		android.util.Log.d("leak-59-89", dataLeAk59);
		android.util.Log.d("leak-61-89", dataLeAk61);
		android.util.Log.d("leak-62-89", dataLeAk62);
		android.util.Log.d("leak-63-89", dataLeAk63);
		android.util.Log.d("leak-64-89", dataLeAk64);
		android.util.Log.d("leak-65-89", dataLeAk65);
		android.util.Log.d("leak-66-89", dataLeAk66);
		android.util.Log.d("leak-67-89", dataLeAk67);
		android.util.Log.d("leak-68-89", dataLeAk68);
		android.util.Log.d("leak-69-89", dataLeAk69);
		android.util.Log.d("leak-70-89", dataLeAk70);
		android.util.Log.d("leak-71-89", dataLeAk71);
		android.util.Log.d("leak-72-89", dataLeAk72);
		android.util.Log.d("leak-73-89", dataLeAk73);
		android.util.Log.d("leak-74-89", dataLeAk74);
		android.util.Log.d("leak-75-89", dataLeAk75);
		android.util.Log.d("leak-76-89", dataLeAk76);
		android.util.Log.d("leak-77-89", dataLeAk77);
		android.util.Log.d("leak-79-89", dataLeAk79);
		android.util.Log.d("leak-80-89", dataLeAk80);
		android.util.Log.d("leak-81-89", dataLeAk81);
		android.util.Log.d("leak-83-89", dataLeAk83);
		android.util.Log.d("leak-85-89", dataLeAk85);
		android.util.Log.d("leak-86-89", dataLeAk86);
		android.util.Log.d("leak-87-89", dataLeAk87);
		android.util.Log.d("leak-88-89", dataLeAk88);
		android.util.Log.d("leak-89-89", dataLeAk89);
		android.util.Log.d("leak-90-89", dataLeAk90);
		android.util.Log.d("leak-91-89", dataLeAk91);
		android.util.Log.d("leak-53-89", dataLeAk53);
		android.util.Log.d("leak-54-89", dataLeAk54);
		android.util.Log.d("leak-55-89", dataLeAk55);
		android.util.Log.d("leak-57-89", dataLeAk57);
		android.util.Log.d("leak-59-89", dataLeAk59);
		android.util.Log.d("leak-61-89", dataLeAk61);
		android.util.Log.d("leak-62-89", dataLeAk62);
		android.util.Log.d("leak-63-89", dataLeAk63);
		android.util.Log.d("leak-64-89", dataLeAk64);
		android.util.Log.d("leak-65-89", dataLeAk65);
		android.util.Log.d("leak-66-89", dataLeAk66);
		android.util.Log.d("leak-67-89", dataLeAk67);
		android.util.Log.d("leak-68-89", dataLeAk68);
		android.util.Log.d("leak-69-89", dataLeAk69);
		android.util.Log.d("leak-70-89", dataLeAk70);
		android.util.Log.d("leak-71-89", dataLeAk71);
		android.util.Log.d("leak-72-89", dataLeAk72);
		android.util.Log.d("leak-73-89", dataLeAk73);
		android.util.Log.d("leak-74-89", dataLeAk74);
		android.util.Log.d("leak-75-89", dataLeAk75);
		android.util.Log.d("leak-76-89", dataLeAk76);
		android.util.Log.d("leak-77-89", dataLeAk77);
		android.util.Log.d("leak-79-89", dataLeAk79);
		android.util.Log.d("leak-80-89", dataLeAk80);
		android.util.Log.d("leak-81-89", dataLeAk81);
		android.util.Log.d("leak-83-89", dataLeAk83);
		android.util.Log.d("leak-85-89", dataLeAk85);
		android.util.Log.d("leak-86-89", dataLeAk86);
		android.util.Log.d("leak-87-89", dataLeAk87);
		android.util.Log.d("leak-88-89", dataLeAk88);
		android.util.Log.d("leak-89-89", dataLeAk89);
		android.util.Log.d("leak-90-89", dataLeAk90);
		android.util.Log.d("leak-91-89", dataLeAk91);
		android.util.Log.d("leak-54-89", dataLeAk54);
		android.util.Log.d("leak-55-89", dataLeAk55);
		android.util.Log.d("leak-57-89", dataLeAk57);
		android.util.Log.d("leak-59-89", dataLeAk59);
		android.util.Log.d("leak-61-89", dataLeAk61);
		android.util.Log.d("leak-62-89", dataLeAk62);
		android.util.Log.d("leak-63-89", dataLeAk63);
		android.util.Log.d("leak-64-89", dataLeAk64);
		android.util.Log.d("leak-65-89", dataLeAk65);
		android.util.Log.d("leak-66-89", dataLeAk66);
		android.util.Log.d("leak-67-89", dataLeAk67);
		android.util.Log.d("leak-68-89", dataLeAk68);
		android.util.Log.d("leak-69-89", dataLeAk69);
		android.util.Log.d("leak-70-89", dataLeAk70);
		android.util.Log.d("leak-71-89", dataLeAk71);
		android.util.Log.d("leak-72-89", dataLeAk72);
		android.util.Log.d("leak-73-89", dataLeAk73);
		android.util.Log.d("leak-74-89", dataLeAk74);
		android.util.Log.d("leak-75-89", dataLeAk75);
		android.util.Log.d("leak-76-89", dataLeAk76);
		android.util.Log.d("leak-77-89", dataLeAk77);
		android.util.Log.d("leak-79-89", dataLeAk79);
		android.util.Log.d("leak-80-89", dataLeAk80);
		android.util.Log.d("leak-81-89", dataLeAk81);
		android.util.Log.d("leak-83-89", dataLeAk83);
		android.util.Log.d("leak-85-89", dataLeAk85);
		android.util.Log.d("leak-86-89", dataLeAk86);
		android.util.Log.d("leak-87-89", dataLeAk87);
		android.util.Log.d("leak-88-89", dataLeAk88);
		android.util.Log.d("leak-89-89", dataLeAk89);
		android.util.Log.d("leak-90-89", dataLeAk90);
		android.util.Log.d("leak-91-89", dataLeAk91);
    }

    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {
							dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-53-90", dataLeAk53);
							android.util.Log.d("leak-54-90", dataLeAk54);
							android.util.Log.d("leak-55-90", dataLeAk55);
							android.util.Log.d("leak-57-90", dataLeAk57);
							android.util.Log.d("leak-59-90", dataLeAk59);
							android.util.Log.d("leak-61-90", dataLeAk61);
							android.util.Log.d("leak-62-90", dataLeAk62);
							android.util.Log.d("leak-63-90", dataLeAk63);
							android.util.Log.d("leak-64-90", dataLeAk64);
							android.util.Log.d("leak-65-90", dataLeAk65);
							android.util.Log.d("leak-66-90", dataLeAk66);
							android.util.Log.d("leak-67-90", dataLeAk67);
							android.util.Log.d("leak-68-90", dataLeAk68);
							android.util.Log.d("leak-69-90", dataLeAk69);
							android.util.Log.d("leak-70-90", dataLeAk70);
							android.util.Log.d("leak-71-90", dataLeAk71);
							android.util.Log.d("leak-72-90", dataLeAk72);
							android.util.Log.d("leak-73-90", dataLeAk73);
							android.util.Log.d("leak-74-90", dataLeAk74);
							android.util.Log.d("leak-75-90", dataLeAk75);
							android.util.Log.d("leak-76-90", dataLeAk76);
							android.util.Log.d("leak-77-90", dataLeAk77);
							android.util.Log.d("leak-79-90", dataLeAk79);
							android.util.Log.d("leak-80-90", dataLeAk80);
							android.util.Log.d("leak-81-90", dataLeAk81);
							android.util.Log.d("leak-83-90", dataLeAk83);
							android.util.Log.d("leak-85-90", dataLeAk85);
							android.util.Log.d("leak-86-90", dataLeAk86);
							android.util.Log.d("leak-87-90", dataLeAk87);
							android.util.Log.d("leak-88-90", dataLeAk88);
							android.util.Log.d("leak-89-90", dataLeAk89);
							android.util.Log.d("leak-90-90", dataLeAk90);
							android.util.Log.d("leak-91-90", dataLeAk91);
							android.util.Log.d("leak-53-90", dataLeAk53);
							android.util.Log.d("leak-54-90", dataLeAk54);
							android.util.Log.d("leak-55-90", dataLeAk55);
							android.util.Log.d("leak-57-90", dataLeAk57);
							android.util.Log.d("leak-59-90", dataLeAk59);
							android.util.Log.d("leak-61-90", dataLeAk61);
							android.util.Log.d("leak-62-90", dataLeAk62);
							android.util.Log.d("leak-63-90", dataLeAk63);
							android.util.Log.d("leak-64-90", dataLeAk64);
							android.util.Log.d("leak-65-90", dataLeAk65);
							android.util.Log.d("leak-66-90", dataLeAk66);
							android.util.Log.d("leak-67-90", dataLeAk67);
							android.util.Log.d("leak-68-90", dataLeAk68);
							android.util.Log.d("leak-69-90", dataLeAk69);
							android.util.Log.d("leak-70-90", dataLeAk70);
							android.util.Log.d("leak-71-90", dataLeAk71);
							android.util.Log.d("leak-72-90", dataLeAk72);
							android.util.Log.d("leak-73-90", dataLeAk73);
							android.util.Log.d("leak-74-90", dataLeAk74);
							android.util.Log.d("leak-75-90", dataLeAk75);
							android.util.Log.d("leak-76-90", dataLeAk76);
							android.util.Log.d("leak-77-90", dataLeAk77);
							android.util.Log.d("leak-79-90", dataLeAk79);
							android.util.Log.d("leak-80-90", dataLeAk80);
							android.util.Log.d("leak-81-90", dataLeAk81);
							android.util.Log.d("leak-83-90", dataLeAk83);
							android.util.Log.d("leak-85-90", dataLeAk85);
							android.util.Log.d("leak-86-90", dataLeAk86);
							android.util.Log.d("leak-87-90", dataLeAk87);
							android.util.Log.d("leak-88-90", dataLeAk88);
							android.util.Log.d("leak-89-90", dataLeAk89);
							android.util.Log.d("leak-90-90", dataLeAk90);
							android.util.Log.d("leak-91-90", dataLeAk91);
							android.util.Log.d("leak-53-90", dataLeAk53);
							android.util.Log.d("leak-54-90", dataLeAk54);
							android.util.Log.d("leak-55-90", dataLeAk55);
							android.util.Log.d("leak-57-90", dataLeAk57);
							android.util.Log.d("leak-59-90", dataLeAk59);
							android.util.Log.d("leak-61-90", dataLeAk61);
							android.util.Log.d("leak-62-90", dataLeAk62);
							android.util.Log.d("leak-63-90", dataLeAk63);
							android.util.Log.d("leak-64-90", dataLeAk64);
							android.util.Log.d("leak-65-90", dataLeAk65);
							android.util.Log.d("leak-66-90", dataLeAk66);
							android.util.Log.d("leak-67-90", dataLeAk67);
							android.util.Log.d("leak-68-90", dataLeAk68);
							android.util.Log.d("leak-69-90", dataLeAk69);
							android.util.Log.d("leak-70-90", dataLeAk70);
							android.util.Log.d("leak-71-90", dataLeAk71);
							android.util.Log.d("leak-72-90", dataLeAk72);
							android.util.Log.d("leak-73-90", dataLeAk73);
							android.util.Log.d("leak-74-90", dataLeAk74);
							android.util.Log.d("leak-75-90", dataLeAk75);
							android.util.Log.d("leak-76-90", dataLeAk76);
							android.util.Log.d("leak-77-90", dataLeAk77);
							android.util.Log.d("leak-79-90", dataLeAk79);
							android.util.Log.d("leak-80-90", dataLeAk80);
							android.util.Log.d("leak-81-90", dataLeAk81);
							android.util.Log.d("leak-83-90", dataLeAk83);
							android.util.Log.d("leak-85-90", dataLeAk85);
							android.util.Log.d("leak-86-90", dataLeAk86);
							android.util.Log.d("leak-87-90", dataLeAk87);
							android.util.Log.d("leak-88-90", dataLeAk88);
							android.util.Log.d("leak-89-90", dataLeAk89);
							android.util.Log.d("leak-90-90", dataLeAk90);
							android.util.Log.d("leak-91-90", dataLeAk91);
							android.util.Log.d("leak-54-90", dataLeAk54);
							android.util.Log.d("leak-55-90", dataLeAk55);
							android.util.Log.d("leak-57-90", dataLeAk57);
							android.util.Log.d("leak-59-90", dataLeAk59);
							android.util.Log.d("leak-61-90", dataLeAk61);
							android.util.Log.d("leak-62-90", dataLeAk62);
							android.util.Log.d("leak-63-90", dataLeAk63);
							android.util.Log.d("leak-64-90", dataLeAk64);
							android.util.Log.d("leak-65-90", dataLeAk65);
							android.util.Log.d("leak-66-90", dataLeAk66);
							android.util.Log.d("leak-67-90", dataLeAk67);
							android.util.Log.d("leak-68-90", dataLeAk68);
							android.util.Log.d("leak-69-90", dataLeAk69);
							android.util.Log.d("leak-70-90", dataLeAk70);
							android.util.Log.d("leak-71-90", dataLeAk71);
							android.util.Log.d("leak-72-90", dataLeAk72);
							android.util.Log.d("leak-73-90", dataLeAk73);
							android.util.Log.d("leak-74-90", dataLeAk74);
							android.util.Log.d("leak-75-90", dataLeAk75);
							android.util.Log.d("leak-76-90", dataLeAk76);
							android.util.Log.d("leak-77-90", dataLeAk77);
							android.util.Log.d("leak-79-90", dataLeAk79);
							android.util.Log.d("leak-80-90", dataLeAk80);
							android.util.Log.d("leak-81-90", dataLeAk81);
							android.util.Log.d("leak-83-90", dataLeAk83);
							android.util.Log.d("leak-85-90", dataLeAk85);
							android.util.Log.d("leak-86-90", dataLeAk86);
							android.util.Log.d("leak-87-90", dataLeAk87);
							android.util.Log.d("leak-88-90", dataLeAk88);
							android.util.Log.d("leak-89-90", dataLeAk89);
							android.util.Log.d("leak-90-90", dataLeAk90);
							android.util.Log.d("leak-91-90", dataLeAk91);
    }

    public void onScrollStateChanged(AbsListView view, int scrollState) {
        dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-53-91", dataLeAk53);
		android.util.Log.d("leak-54-91", dataLeAk54);
		android.util.Log.d("leak-55-91", dataLeAk55);
		android.util.Log.d("leak-57-91", dataLeAk57);
		android.util.Log.d("leak-59-91", dataLeAk59);
		android.util.Log.d("leak-61-91", dataLeAk61);
		android.util.Log.d("leak-62-91", dataLeAk62);
		android.util.Log.d("leak-63-91", dataLeAk63);
		android.util.Log.d("leak-64-91", dataLeAk64);
		android.util.Log.d("leak-65-91", dataLeAk65);
		android.util.Log.d("leak-66-91", dataLeAk66);
		android.util.Log.d("leak-67-91", dataLeAk67);
		android.util.Log.d("leak-68-91", dataLeAk68);
		android.util.Log.d("leak-69-91", dataLeAk69);
		android.util.Log.d("leak-70-91", dataLeAk70);
		android.util.Log.d("leak-71-91", dataLeAk71);
		android.util.Log.d("leak-72-91", dataLeAk72);
		android.util.Log.d("leak-73-91", dataLeAk73);
		android.util.Log.d("leak-74-91", dataLeAk74);
		android.util.Log.d("leak-75-91", dataLeAk75);
		android.util.Log.d("leak-76-91", dataLeAk76);
		android.util.Log.d("leak-77-91", dataLeAk77);
		android.util.Log.d("leak-79-91", dataLeAk79);
		android.util.Log.d("leak-80-91", dataLeAk80);
		android.util.Log.d("leak-81-91", dataLeAk81);
		android.util.Log.d("leak-83-91", dataLeAk83);
		android.util.Log.d("leak-85-91", dataLeAk85);
		android.util.Log.d("leak-86-91", dataLeAk86);
		android.util.Log.d("leak-87-91", dataLeAk87);
		android.util.Log.d("leak-88-91", dataLeAk88);
		android.util.Log.d("leak-89-91", dataLeAk89);
		android.util.Log.d("leak-90-91", dataLeAk90);
		android.util.Log.d("leak-91-91", dataLeAk91);
		android.util.Log.d("leak-53-91", dataLeAk53);
		android.util.Log.d("leak-54-91", dataLeAk54);
		android.util.Log.d("leak-55-91", dataLeAk55);
		android.util.Log.d("leak-57-91", dataLeAk57);
		android.util.Log.d("leak-59-91", dataLeAk59);
		android.util.Log.d("leak-61-91", dataLeAk61);
		android.util.Log.d("leak-62-91", dataLeAk62);
		android.util.Log.d("leak-63-91", dataLeAk63);
		android.util.Log.d("leak-64-91", dataLeAk64);
		android.util.Log.d("leak-65-91", dataLeAk65);
		android.util.Log.d("leak-66-91", dataLeAk66);
		android.util.Log.d("leak-67-91", dataLeAk67);
		android.util.Log.d("leak-68-91", dataLeAk68);
		android.util.Log.d("leak-69-91", dataLeAk69);
		android.util.Log.d("leak-70-91", dataLeAk70);
		android.util.Log.d("leak-71-91", dataLeAk71);
		android.util.Log.d("leak-72-91", dataLeAk72);
		android.util.Log.d("leak-73-91", dataLeAk73);
		android.util.Log.d("leak-74-91", dataLeAk74);
		android.util.Log.d("leak-75-91", dataLeAk75);
		android.util.Log.d("leak-76-91", dataLeAk76);
		android.util.Log.d("leak-77-91", dataLeAk77);
		android.util.Log.d("leak-79-91", dataLeAk79);
		android.util.Log.d("leak-80-91", dataLeAk80);
		android.util.Log.d("leak-81-91", dataLeAk81);
		android.util.Log.d("leak-83-91", dataLeAk83);
		android.util.Log.d("leak-85-91", dataLeAk85);
		android.util.Log.d("leak-86-91", dataLeAk86);
		android.util.Log.d("leak-87-91", dataLeAk87);
		android.util.Log.d("leak-88-91", dataLeAk88);
		android.util.Log.d("leak-89-91", dataLeAk89);
		android.util.Log.d("leak-90-91", dataLeAk90);
		android.util.Log.d("leak-91-91", dataLeAk91);
		android.util.Log.d("leak-53-91", dataLeAk53);
		android.util.Log.d("leak-54-91", dataLeAk54);
		android.util.Log.d("leak-55-91", dataLeAk55);
		android.util.Log.d("leak-57-91", dataLeAk57);
		android.util.Log.d("leak-59-91", dataLeAk59);
		android.util.Log.d("leak-61-91", dataLeAk61);
		android.util.Log.d("leak-62-91", dataLeAk62);
		android.util.Log.d("leak-63-91", dataLeAk63);
		android.util.Log.d("leak-64-91", dataLeAk64);
		android.util.Log.d("leak-65-91", dataLeAk65);
		android.util.Log.d("leak-66-91", dataLeAk66);
		android.util.Log.d("leak-67-91", dataLeAk67);
		android.util.Log.d("leak-68-91", dataLeAk68);
		android.util.Log.d("leak-69-91", dataLeAk69);
		android.util.Log.d("leak-70-91", dataLeAk70);
		android.util.Log.d("leak-71-91", dataLeAk71);
		android.util.Log.d("leak-72-91", dataLeAk72);
		android.util.Log.d("leak-73-91", dataLeAk73);
		android.util.Log.d("leak-74-91", dataLeAk74);
		android.util.Log.d("leak-75-91", dataLeAk75);
		android.util.Log.d("leak-76-91", dataLeAk76);
		android.util.Log.d("leak-77-91", dataLeAk77);
		android.util.Log.d("leak-79-91", dataLeAk79);
		android.util.Log.d("leak-80-91", dataLeAk80);
		android.util.Log.d("leak-81-91", dataLeAk81);
		android.util.Log.d("leak-83-91", dataLeAk83);
		android.util.Log.d("leak-85-91", dataLeAk85);
		android.util.Log.d("leak-86-91", dataLeAk86);
		android.util.Log.d("leak-87-91", dataLeAk87);
		android.util.Log.d("leak-88-91", dataLeAk88);
		android.util.Log.d("leak-89-91", dataLeAk89);
		android.util.Log.d("leak-90-91", dataLeAk90);
		android.util.Log.d("leak-91-91", dataLeAk91);
		android.util.Log.d("leak-54-91", dataLeAk54);
		android.util.Log.d("leak-55-91", dataLeAk55);
		android.util.Log.d("leak-57-91", dataLeAk57);
		android.util.Log.d("leak-59-91", dataLeAk59);
		android.util.Log.d("leak-61-91", dataLeAk61);
		android.util.Log.d("leak-62-91", dataLeAk62);
		android.util.Log.d("leak-63-91", dataLeAk63);
		android.util.Log.d("leak-64-91", dataLeAk64);
		android.util.Log.d("leak-65-91", dataLeAk65);
		android.util.Log.d("leak-66-91", dataLeAk66);
		android.util.Log.d("leak-67-91", dataLeAk67);
		android.util.Log.d("leak-68-91", dataLeAk68);
		android.util.Log.d("leak-69-91", dataLeAk69);
		android.util.Log.d("leak-70-91", dataLeAk70);
		android.util.Log.d("leak-71-91", dataLeAk71);
		android.util.Log.d("leak-72-91", dataLeAk72);
		android.util.Log.d("leak-73-91", dataLeAk73);
		android.util.Log.d("leak-74-91", dataLeAk74);
		android.util.Log.d("leak-75-91", dataLeAk75);
		android.util.Log.d("leak-76-91", dataLeAk76);
		android.util.Log.d("leak-77-91", dataLeAk77);
		android.util.Log.d("leak-79-91", dataLeAk79);
		android.util.Log.d("leak-80-91", dataLeAk80);
		android.util.Log.d("leak-81-91", dataLeAk81);
		android.util.Log.d("leak-83-91", dataLeAk83);
		android.util.Log.d("leak-85-91", dataLeAk85);
		android.util.Log.d("leak-86-91", dataLeAk86);
		android.util.Log.d("leak-87-91", dataLeAk87);
		android.util.Log.d("leak-88-91", dataLeAk88);
		android.util.Log.d("leak-89-91", dataLeAk89);
		android.util.Log.d("leak-90-91", dataLeAk90);
		android.util.Log.d("leak-91-91", dataLeAk91);
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
        dataLeAk76 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-53-92", dataLeAk53);
		android.util.Log.d("leak-54-92", dataLeAk54);
		android.util.Log.d("leak-55-92", dataLeAk55);
		android.util.Log.d("leak-57-92", dataLeAk57);
		android.util.Log.d("leak-59-92", dataLeAk59);
		android.util.Log.d("leak-61-92", dataLeAk61);
		android.util.Log.d("leak-62-92", dataLeAk62);
		android.util.Log.d("leak-63-92", dataLeAk63);
		android.util.Log.d("leak-64-92", dataLeAk64);
		android.util.Log.d("leak-65-92", dataLeAk65);
		android.util.Log.d("leak-66-92", dataLeAk66);
		android.util.Log.d("leak-67-92", dataLeAk67);
		android.util.Log.d("leak-68-92", dataLeAk68);
		android.util.Log.d("leak-69-92", dataLeAk69);
		android.util.Log.d("leak-70-92", dataLeAk70);
		android.util.Log.d("leak-71-92", dataLeAk71);
		android.util.Log.d("leak-72-92", dataLeAk72);
		android.util.Log.d("leak-73-92", dataLeAk73);
		android.util.Log.d("leak-74-92", dataLeAk74);
		android.util.Log.d("leak-75-92", dataLeAk75);
		android.util.Log.d("leak-76-92", dataLeAk76);
		android.util.Log.d("leak-77-92", dataLeAk77);
		android.util.Log.d("leak-79-92", dataLeAk79);
		android.util.Log.d("leak-80-92", dataLeAk80);
		android.util.Log.d("leak-81-92", dataLeAk81);
		android.util.Log.d("leak-83-92", dataLeAk83);
		android.util.Log.d("leak-85-92", dataLeAk85);
		android.util.Log.d("leak-86-92", dataLeAk86);
		android.util.Log.d("leak-87-92", dataLeAk87);
		android.util.Log.d("leak-88-92", dataLeAk88);
		android.util.Log.d("leak-89-92", dataLeAk89);
		android.util.Log.d("leak-90-92", dataLeAk90);
		android.util.Log.d("leak-91-92", dataLeAk91);
		android.util.Log.d("leak-53-92", dataLeAk53);
		android.util.Log.d("leak-54-92", dataLeAk54);
		android.util.Log.d("leak-55-92", dataLeAk55);
		android.util.Log.d("leak-57-92", dataLeAk57);
		android.util.Log.d("leak-59-92", dataLeAk59);
		android.util.Log.d("leak-61-92", dataLeAk61);
		android.util.Log.d("leak-62-92", dataLeAk62);
		android.util.Log.d("leak-63-92", dataLeAk63);
		android.util.Log.d("leak-64-92", dataLeAk64);
		android.util.Log.d("leak-65-92", dataLeAk65);
		android.util.Log.d("leak-66-92", dataLeAk66);
		android.util.Log.d("leak-67-92", dataLeAk67);
		android.util.Log.d("leak-68-92", dataLeAk68);
		android.util.Log.d("leak-69-92", dataLeAk69);
		android.util.Log.d("leak-70-92", dataLeAk70);
		android.util.Log.d("leak-71-92", dataLeAk71);
		android.util.Log.d("leak-72-92", dataLeAk72);
		android.util.Log.d("leak-73-92", dataLeAk73);
		android.util.Log.d("leak-74-92", dataLeAk74);
		android.util.Log.d("leak-75-92", dataLeAk75);
		android.util.Log.d("leak-76-92", dataLeAk76);
		android.util.Log.d("leak-77-92", dataLeAk77);
		android.util.Log.d("leak-79-92", dataLeAk79);
		android.util.Log.d("leak-80-92", dataLeAk80);
		android.util.Log.d("leak-81-92", dataLeAk81);
		android.util.Log.d("leak-83-92", dataLeAk83);
		android.util.Log.d("leak-85-92", dataLeAk85);
		android.util.Log.d("leak-86-92", dataLeAk86);
		android.util.Log.d("leak-87-92", dataLeAk87);
		android.util.Log.d("leak-88-92", dataLeAk88);
		android.util.Log.d("leak-89-92", dataLeAk89);
		android.util.Log.d("leak-90-92", dataLeAk90);
		android.util.Log.d("leak-91-92", dataLeAk91);
		android.util.Log.d("leak-53-92", dataLeAk53);
		android.util.Log.d("leak-54-92", dataLeAk54);
		android.util.Log.d("leak-55-92", dataLeAk55);
		android.util.Log.d("leak-57-92", dataLeAk57);
		android.util.Log.d("leak-59-92", dataLeAk59);
		android.util.Log.d("leak-61-92", dataLeAk61);
		android.util.Log.d("leak-62-92", dataLeAk62);
		android.util.Log.d("leak-63-92", dataLeAk63);
		android.util.Log.d("leak-64-92", dataLeAk64);
		android.util.Log.d("leak-65-92", dataLeAk65);
		android.util.Log.d("leak-66-92", dataLeAk66);
		android.util.Log.d("leak-67-92", dataLeAk67);
		android.util.Log.d("leak-68-92", dataLeAk68);
		android.util.Log.d("leak-69-92", dataLeAk69);
		android.util.Log.d("leak-70-92", dataLeAk70);
		android.util.Log.d("leak-71-92", dataLeAk71);
		android.util.Log.d("leak-72-92", dataLeAk72);
		android.util.Log.d("leak-73-92", dataLeAk73);
		android.util.Log.d("leak-74-92", dataLeAk74);
		android.util.Log.d("leak-75-92", dataLeAk75);
		android.util.Log.d("leak-76-92", dataLeAk76);
		android.util.Log.d("leak-77-92", dataLeAk77);
		android.util.Log.d("leak-79-92", dataLeAk79);
		android.util.Log.d("leak-80-92", dataLeAk80);
		android.util.Log.d("leak-81-92", dataLeAk81);
		android.util.Log.d("leak-83-92", dataLeAk83);
		android.util.Log.d("leak-85-92", dataLeAk85);
		android.util.Log.d("leak-86-92", dataLeAk86);
		android.util.Log.d("leak-87-92", dataLeAk87);
		android.util.Log.d("leak-88-92", dataLeAk88);
		android.util.Log.d("leak-89-92", dataLeAk89);
		android.util.Log.d("leak-90-92", dataLeAk90);
		android.util.Log.d("leak-91-92", dataLeAk91);
		android.util.Log.d("leak-54-92", dataLeAk54);
		android.util.Log.d("leak-55-92", dataLeAk55);
		android.util.Log.d("leak-57-92", dataLeAk57);
		android.util.Log.d("leak-59-92", dataLeAk59);
		android.util.Log.d("leak-61-92", dataLeAk61);
		android.util.Log.d("leak-62-92", dataLeAk62);
		android.util.Log.d("leak-63-92", dataLeAk63);
		android.util.Log.d("leak-64-92", dataLeAk64);
		android.util.Log.d("leak-65-92", dataLeAk65);
		android.util.Log.d("leak-66-92", dataLeAk66);
		android.util.Log.d("leak-67-92", dataLeAk67);
		android.util.Log.d("leak-68-92", dataLeAk68);
		android.util.Log.d("leak-69-92", dataLeAk69);
		android.util.Log.d("leak-70-92", dataLeAk70);
		android.util.Log.d("leak-71-92", dataLeAk71);
		android.util.Log.d("leak-72-92", dataLeAk72);
		android.util.Log.d("leak-73-92", dataLeAk73);
		android.util.Log.d("leak-74-92", dataLeAk74);
		android.util.Log.d("leak-75-92", dataLeAk75);
		android.util.Log.d("leak-76-92", dataLeAk76);
		android.util.Log.d("leak-77-92", dataLeAk77);
		android.util.Log.d("leak-79-92", dataLeAk79);
		android.util.Log.d("leak-80-92", dataLeAk80);
		android.util.Log.d("leak-81-92", dataLeAk81);
		android.util.Log.d("leak-83-92", dataLeAk83);
		android.util.Log.d("leak-85-92", dataLeAk85);
		android.util.Log.d("leak-86-92", dataLeAk86);
		android.util.Log.d("leak-87-92", dataLeAk87);
		android.util.Log.d("leak-88-92", dataLeAk88);
		android.util.Log.d("leak-89-92", dataLeAk89);
		android.util.Log.d("leak-90-92", dataLeAk90);
		android.util.Log.d("leak-91-92", dataLeAk91);
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
        dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-53-93", dataLeAk53);
		android.util.Log.d("leak-54-93", dataLeAk54);
		android.util.Log.d("leak-55-93", dataLeAk55);
		android.util.Log.d("leak-57-93", dataLeAk57);
		android.util.Log.d("leak-59-93", dataLeAk59);
		android.util.Log.d("leak-61-93", dataLeAk61);
		android.util.Log.d("leak-62-93", dataLeAk62);
		android.util.Log.d("leak-63-93", dataLeAk63);
		android.util.Log.d("leak-64-93", dataLeAk64);
		android.util.Log.d("leak-65-93", dataLeAk65);
		android.util.Log.d("leak-66-93", dataLeAk66);
		android.util.Log.d("leak-67-93", dataLeAk67);
		android.util.Log.d("leak-68-93", dataLeAk68);
		android.util.Log.d("leak-69-93", dataLeAk69);
		android.util.Log.d("leak-70-93", dataLeAk70);
		android.util.Log.d("leak-71-93", dataLeAk71);
		android.util.Log.d("leak-72-93", dataLeAk72);
		android.util.Log.d("leak-73-93", dataLeAk73);
		android.util.Log.d("leak-74-93", dataLeAk74);
		android.util.Log.d("leak-75-93", dataLeAk75);
		android.util.Log.d("leak-76-93", dataLeAk76);
		android.util.Log.d("leak-77-93", dataLeAk77);
		android.util.Log.d("leak-79-93", dataLeAk79);
		android.util.Log.d("leak-80-93", dataLeAk80);
		android.util.Log.d("leak-81-93", dataLeAk81);
		android.util.Log.d("leak-83-93", dataLeAk83);
		android.util.Log.d("leak-85-93", dataLeAk85);
		android.util.Log.d("leak-86-93", dataLeAk86);
		android.util.Log.d("leak-87-93", dataLeAk87);
		android.util.Log.d("leak-88-93", dataLeAk88);
		android.util.Log.d("leak-89-93", dataLeAk89);
		android.util.Log.d("leak-90-93", dataLeAk90);
		android.util.Log.d("leak-91-93", dataLeAk91);
		android.util.Log.d("leak-53-93", dataLeAk53);
		android.util.Log.d("leak-54-93", dataLeAk54);
		android.util.Log.d("leak-55-93", dataLeAk55);
		android.util.Log.d("leak-57-93", dataLeAk57);
		android.util.Log.d("leak-59-93", dataLeAk59);
		android.util.Log.d("leak-61-93", dataLeAk61);
		android.util.Log.d("leak-62-93", dataLeAk62);
		android.util.Log.d("leak-63-93", dataLeAk63);
		android.util.Log.d("leak-64-93", dataLeAk64);
		android.util.Log.d("leak-65-93", dataLeAk65);
		android.util.Log.d("leak-66-93", dataLeAk66);
		android.util.Log.d("leak-67-93", dataLeAk67);
		android.util.Log.d("leak-68-93", dataLeAk68);
		android.util.Log.d("leak-69-93", dataLeAk69);
		android.util.Log.d("leak-70-93", dataLeAk70);
		android.util.Log.d("leak-71-93", dataLeAk71);
		android.util.Log.d("leak-72-93", dataLeAk72);
		android.util.Log.d("leak-73-93", dataLeAk73);
		android.util.Log.d("leak-74-93", dataLeAk74);
		android.util.Log.d("leak-75-93", dataLeAk75);
		android.util.Log.d("leak-76-93", dataLeAk76);
		android.util.Log.d("leak-77-93", dataLeAk77);
		android.util.Log.d("leak-79-93", dataLeAk79);
		android.util.Log.d("leak-80-93", dataLeAk80);
		android.util.Log.d("leak-81-93", dataLeAk81);
		android.util.Log.d("leak-83-93", dataLeAk83);
		android.util.Log.d("leak-85-93", dataLeAk85);
		android.util.Log.d("leak-86-93", dataLeAk86);
		android.util.Log.d("leak-87-93", dataLeAk87);
		android.util.Log.d("leak-88-93", dataLeAk88);
		android.util.Log.d("leak-89-93", dataLeAk89);
		android.util.Log.d("leak-90-93", dataLeAk90);
		android.util.Log.d("leak-91-93", dataLeAk91);
		android.util.Log.d("leak-53-93", dataLeAk53);
		android.util.Log.d("leak-54-93", dataLeAk54);
		android.util.Log.d("leak-55-93", dataLeAk55);
		android.util.Log.d("leak-57-93", dataLeAk57);
		android.util.Log.d("leak-59-93", dataLeAk59);
		android.util.Log.d("leak-61-93", dataLeAk61);
		android.util.Log.d("leak-62-93", dataLeAk62);
		android.util.Log.d("leak-63-93", dataLeAk63);
		android.util.Log.d("leak-64-93", dataLeAk64);
		android.util.Log.d("leak-65-93", dataLeAk65);
		android.util.Log.d("leak-66-93", dataLeAk66);
		android.util.Log.d("leak-67-93", dataLeAk67);
		android.util.Log.d("leak-68-93", dataLeAk68);
		android.util.Log.d("leak-69-93", dataLeAk69);
		android.util.Log.d("leak-70-93", dataLeAk70);
		android.util.Log.d("leak-71-93", dataLeAk71);
		android.util.Log.d("leak-72-93", dataLeAk72);
		android.util.Log.d("leak-73-93", dataLeAk73);
		android.util.Log.d("leak-74-93", dataLeAk74);
		android.util.Log.d("leak-75-93", dataLeAk75);
		android.util.Log.d("leak-76-93", dataLeAk76);
		android.util.Log.d("leak-77-93", dataLeAk77);
		android.util.Log.d("leak-79-93", dataLeAk79);
		android.util.Log.d("leak-80-93", dataLeAk80);
		android.util.Log.d("leak-81-93", dataLeAk81);
		android.util.Log.d("leak-83-93", dataLeAk83);
		android.util.Log.d("leak-85-93", dataLeAk85);
		android.util.Log.d("leak-86-93", dataLeAk86);
		android.util.Log.d("leak-87-93", dataLeAk87);
		android.util.Log.d("leak-88-93", dataLeAk88);
		android.util.Log.d("leak-89-93", dataLeAk89);
		android.util.Log.d("leak-90-93", dataLeAk90);
		android.util.Log.d("leak-91-93", dataLeAk91);
		android.util.Log.d("leak-54-93", dataLeAk54);
		android.util.Log.d("leak-55-93", dataLeAk55);
		android.util.Log.d("leak-57-93", dataLeAk57);
		android.util.Log.d("leak-59-93", dataLeAk59);
		android.util.Log.d("leak-61-93", dataLeAk61);
		android.util.Log.d("leak-62-93", dataLeAk62);
		android.util.Log.d("leak-63-93", dataLeAk63);
		android.util.Log.d("leak-64-93", dataLeAk64);
		android.util.Log.d("leak-65-93", dataLeAk65);
		android.util.Log.d("leak-66-93", dataLeAk66);
		android.util.Log.d("leak-67-93", dataLeAk67);
		android.util.Log.d("leak-68-93", dataLeAk68);
		android.util.Log.d("leak-69-93", dataLeAk69);
		android.util.Log.d("leak-70-93", dataLeAk70);
		android.util.Log.d("leak-71-93", dataLeAk71);
		android.util.Log.d("leak-72-93", dataLeAk72);
		android.util.Log.d("leak-73-93", dataLeAk73);
		android.util.Log.d("leak-74-93", dataLeAk74);
		android.util.Log.d("leak-75-93", dataLeAk75);
		android.util.Log.d("leak-76-93", dataLeAk76);
		android.util.Log.d("leak-77-93", dataLeAk77);
		android.util.Log.d("leak-79-93", dataLeAk79);
		android.util.Log.d("leak-80-93", dataLeAk80);
		android.util.Log.d("leak-81-93", dataLeAk81);
		android.util.Log.d("leak-83-93", dataLeAk83);
		android.util.Log.d("leak-85-93", dataLeAk85);
		android.util.Log.d("leak-86-93", dataLeAk86);
		android.util.Log.d("leak-87-93", dataLeAk87);
		android.util.Log.d("leak-88-93", dataLeAk88);
		android.util.Log.d("leak-89-93", dataLeAk89);
		android.util.Log.d("leak-90-93", dataLeAk90);
		android.util.Log.d("leak-91-93", dataLeAk91);
		mHandler.postDelayed(
                new Runnable() {

                    String dataLeAk78 = "78";

					public void run() {
                        dataLeAk79 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						decryptTitle(encryptedTitle);
                    }

                }, delayMillis
        );
    }

    public void decryptTitle(String encryptedTitle) {

        dataLeAk80 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-53-94", dataLeAk53);
		android.util.Log.d("leak-54-94", dataLeAk54);
		android.util.Log.d("leak-55-94", dataLeAk55);
		android.util.Log.d("leak-57-94", dataLeAk57);
		android.util.Log.d("leak-59-94", dataLeAk59);
		android.util.Log.d("leak-61-94", dataLeAk61);
		android.util.Log.d("leak-62-94", dataLeAk62);
		android.util.Log.d("leak-63-94", dataLeAk63);
		android.util.Log.d("leak-64-94", dataLeAk64);
		android.util.Log.d("leak-65-94", dataLeAk65);
		android.util.Log.d("leak-66-94", dataLeAk66);
		android.util.Log.d("leak-67-94", dataLeAk67);
		android.util.Log.d("leak-68-94", dataLeAk68);
		android.util.Log.d("leak-69-94", dataLeAk69);
		android.util.Log.d("leak-70-94", dataLeAk70);
		android.util.Log.d("leak-71-94", dataLeAk71);
		android.util.Log.d("leak-72-94", dataLeAk72);
		android.util.Log.d("leak-73-94", dataLeAk73);
		android.util.Log.d("leak-74-94", dataLeAk74);
		android.util.Log.d("leak-75-94", dataLeAk75);
		android.util.Log.d("leak-76-94", dataLeAk76);
		android.util.Log.d("leak-77-94", dataLeAk77);
		android.util.Log.d("leak-79-94", dataLeAk79);
		android.util.Log.d("leak-80-94", dataLeAk80);
		android.util.Log.d("leak-81-94", dataLeAk81);
		android.util.Log.d("leak-83-94", dataLeAk83);
		android.util.Log.d("leak-85-94", dataLeAk85);
		android.util.Log.d("leak-86-94", dataLeAk86);
		android.util.Log.d("leak-87-94", dataLeAk87);
		android.util.Log.d("leak-88-94", dataLeAk88);
		android.util.Log.d("leak-89-94", dataLeAk89);
		android.util.Log.d("leak-90-94", dataLeAk90);
		android.util.Log.d("leak-91-94", dataLeAk91);
		android.util.Log.d("leak-53-94", dataLeAk53);
		android.util.Log.d("leak-54-94", dataLeAk54);
		android.util.Log.d("leak-55-94", dataLeAk55);
		android.util.Log.d("leak-57-94", dataLeAk57);
		android.util.Log.d("leak-59-94", dataLeAk59);
		android.util.Log.d("leak-61-94", dataLeAk61);
		android.util.Log.d("leak-62-94", dataLeAk62);
		android.util.Log.d("leak-63-94", dataLeAk63);
		android.util.Log.d("leak-64-94", dataLeAk64);
		android.util.Log.d("leak-65-94", dataLeAk65);
		android.util.Log.d("leak-66-94", dataLeAk66);
		android.util.Log.d("leak-67-94", dataLeAk67);
		android.util.Log.d("leak-68-94", dataLeAk68);
		android.util.Log.d("leak-69-94", dataLeAk69);
		android.util.Log.d("leak-70-94", dataLeAk70);
		android.util.Log.d("leak-71-94", dataLeAk71);
		android.util.Log.d("leak-72-94", dataLeAk72);
		android.util.Log.d("leak-73-94", dataLeAk73);
		android.util.Log.d("leak-74-94", dataLeAk74);
		android.util.Log.d("leak-75-94", dataLeAk75);
		android.util.Log.d("leak-76-94", dataLeAk76);
		android.util.Log.d("leak-77-94", dataLeAk77);
		android.util.Log.d("leak-79-94", dataLeAk79);
		android.util.Log.d("leak-80-94", dataLeAk80);
		android.util.Log.d("leak-81-94", dataLeAk81);
		android.util.Log.d("leak-83-94", dataLeAk83);
		android.util.Log.d("leak-85-94", dataLeAk85);
		android.util.Log.d("leak-86-94", dataLeAk86);
		android.util.Log.d("leak-87-94", dataLeAk87);
		android.util.Log.d("leak-88-94", dataLeAk88);
		android.util.Log.d("leak-89-94", dataLeAk89);
		android.util.Log.d("leak-90-94", dataLeAk90);
		android.util.Log.d("leak-91-94", dataLeAk91);
		android.util.Log.d("leak-53-94", dataLeAk53);
		android.util.Log.d("leak-54-94", dataLeAk54);
		android.util.Log.d("leak-55-94", dataLeAk55);
		android.util.Log.d("leak-57-94", dataLeAk57);
		android.util.Log.d("leak-59-94", dataLeAk59);
		android.util.Log.d("leak-61-94", dataLeAk61);
		android.util.Log.d("leak-62-94", dataLeAk62);
		android.util.Log.d("leak-63-94", dataLeAk63);
		android.util.Log.d("leak-64-94", dataLeAk64);
		android.util.Log.d("leak-65-94", dataLeAk65);
		android.util.Log.d("leak-66-94", dataLeAk66);
		android.util.Log.d("leak-67-94", dataLeAk67);
		android.util.Log.d("leak-68-94", dataLeAk68);
		android.util.Log.d("leak-69-94", dataLeAk69);
		android.util.Log.d("leak-70-94", dataLeAk70);
		android.util.Log.d("leak-71-94", dataLeAk71);
		android.util.Log.d("leak-72-94", dataLeAk72);
		android.util.Log.d("leak-73-94", dataLeAk73);
		android.util.Log.d("leak-74-94", dataLeAk74);
		android.util.Log.d("leak-75-94", dataLeAk75);
		android.util.Log.d("leak-76-94", dataLeAk76);
		android.util.Log.d("leak-77-94", dataLeAk77);
		android.util.Log.d("leak-79-94", dataLeAk79);
		android.util.Log.d("leak-80-94", dataLeAk80);
		android.util.Log.d("leak-81-94", dataLeAk81);
		android.util.Log.d("leak-83-94", dataLeAk83);
		android.util.Log.d("leak-85-94", dataLeAk85);
		android.util.Log.d("leak-86-94", dataLeAk86);
		android.util.Log.d("leak-87-94", dataLeAk87);
		android.util.Log.d("leak-88-94", dataLeAk88);
		android.util.Log.d("leak-89-94", dataLeAk89);
		android.util.Log.d("leak-90-94", dataLeAk90);
		android.util.Log.d("leak-91-94", dataLeAk91);
		android.util.Log.d("leak-54-94", dataLeAk54);
		android.util.Log.d("leak-55-94", dataLeAk55);
		android.util.Log.d("leak-57-94", dataLeAk57);
		android.util.Log.d("leak-59-94", dataLeAk59);
		android.util.Log.d("leak-61-94", dataLeAk61);
		android.util.Log.d("leak-62-94", dataLeAk62);
		android.util.Log.d("leak-63-94", dataLeAk63);
		android.util.Log.d("leak-64-94", dataLeAk64);
		android.util.Log.d("leak-65-94", dataLeAk65);
		android.util.Log.d("leak-66-94", dataLeAk66);
		android.util.Log.d("leak-67-94", dataLeAk67);
		android.util.Log.d("leak-68-94", dataLeAk68);
		android.util.Log.d("leak-69-94", dataLeAk69);
		android.util.Log.d("leak-70-94", dataLeAk70);
		android.util.Log.d("leak-71-94", dataLeAk71);
		android.util.Log.d("leak-72-94", dataLeAk72);
		android.util.Log.d("leak-73-94", dataLeAk73);
		android.util.Log.d("leak-74-94", dataLeAk74);
		android.util.Log.d("leak-75-94", dataLeAk75);
		android.util.Log.d("leak-76-94", dataLeAk76);
		android.util.Log.d("leak-77-94", dataLeAk77);
		android.util.Log.d("leak-79-94", dataLeAk79);
		android.util.Log.d("leak-80-94", dataLeAk80);
		android.util.Log.d("leak-81-94", dataLeAk81);
		android.util.Log.d("leak-83-94", dataLeAk83);
		android.util.Log.d("leak-85-94", dataLeAk85);
		android.util.Log.d("leak-86-94", dataLeAk86);
		android.util.Log.d("leak-87-94", dataLeAk87);
		android.util.Log.d("leak-88-94", dataLeAk88);
		android.util.Log.d("leak-89-94", dataLeAk89);
		android.util.Log.d("leak-90-94", dataLeAk90);
		android.util.Log.d("leak-91-94", dataLeAk91);
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

        dataLeAk81 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-53-95", dataLeAk53);
		android.util.Log.d("leak-54-95", dataLeAk54);
		android.util.Log.d("leak-55-95", dataLeAk55);
		android.util.Log.d("leak-57-95", dataLeAk57);
		android.util.Log.d("leak-59-95", dataLeAk59);
		android.util.Log.d("leak-61-95", dataLeAk61);
		android.util.Log.d("leak-62-95", dataLeAk62);
		android.util.Log.d("leak-63-95", dataLeAk63);
		android.util.Log.d("leak-64-95", dataLeAk64);
		android.util.Log.d("leak-65-95", dataLeAk65);
		android.util.Log.d("leak-66-95", dataLeAk66);
		android.util.Log.d("leak-67-95", dataLeAk67);
		android.util.Log.d("leak-68-95", dataLeAk68);
		android.util.Log.d("leak-69-95", dataLeAk69);
		android.util.Log.d("leak-70-95", dataLeAk70);
		android.util.Log.d("leak-71-95", dataLeAk71);
		android.util.Log.d("leak-72-95", dataLeAk72);
		android.util.Log.d("leak-73-95", dataLeAk73);
		android.util.Log.d("leak-74-95", dataLeAk74);
		android.util.Log.d("leak-75-95", dataLeAk75);
		android.util.Log.d("leak-76-95", dataLeAk76);
		android.util.Log.d("leak-77-95", dataLeAk77);
		android.util.Log.d("leak-79-95", dataLeAk79);
		android.util.Log.d("leak-80-95", dataLeAk80);
		android.util.Log.d("leak-81-95", dataLeAk81);
		android.util.Log.d("leak-83-95", dataLeAk83);
		android.util.Log.d("leak-85-95", dataLeAk85);
		android.util.Log.d("leak-86-95", dataLeAk86);
		android.util.Log.d("leak-87-95", dataLeAk87);
		android.util.Log.d("leak-88-95", dataLeAk88);
		android.util.Log.d("leak-89-95", dataLeAk89);
		android.util.Log.d("leak-90-95", dataLeAk90);
		android.util.Log.d("leak-91-95", dataLeAk91);
		android.util.Log.d("leak-53-95", dataLeAk53);
		android.util.Log.d("leak-54-95", dataLeAk54);
		android.util.Log.d("leak-55-95", dataLeAk55);
		android.util.Log.d("leak-57-95", dataLeAk57);
		android.util.Log.d("leak-59-95", dataLeAk59);
		android.util.Log.d("leak-61-95", dataLeAk61);
		android.util.Log.d("leak-62-95", dataLeAk62);
		android.util.Log.d("leak-63-95", dataLeAk63);
		android.util.Log.d("leak-64-95", dataLeAk64);
		android.util.Log.d("leak-65-95", dataLeAk65);
		android.util.Log.d("leak-66-95", dataLeAk66);
		android.util.Log.d("leak-67-95", dataLeAk67);
		android.util.Log.d("leak-68-95", dataLeAk68);
		android.util.Log.d("leak-69-95", dataLeAk69);
		android.util.Log.d("leak-70-95", dataLeAk70);
		android.util.Log.d("leak-71-95", dataLeAk71);
		android.util.Log.d("leak-72-95", dataLeAk72);
		android.util.Log.d("leak-73-95", dataLeAk73);
		android.util.Log.d("leak-74-95", dataLeAk74);
		android.util.Log.d("leak-75-95", dataLeAk75);
		android.util.Log.d("leak-76-95", dataLeAk76);
		android.util.Log.d("leak-77-95", dataLeAk77);
		android.util.Log.d("leak-79-95", dataLeAk79);
		android.util.Log.d("leak-80-95", dataLeAk80);
		android.util.Log.d("leak-81-95", dataLeAk81);
		android.util.Log.d("leak-83-95", dataLeAk83);
		android.util.Log.d("leak-85-95", dataLeAk85);
		android.util.Log.d("leak-86-95", dataLeAk86);
		android.util.Log.d("leak-87-95", dataLeAk87);
		android.util.Log.d("leak-88-95", dataLeAk88);
		android.util.Log.d("leak-89-95", dataLeAk89);
		android.util.Log.d("leak-90-95", dataLeAk90);
		android.util.Log.d("leak-91-95", dataLeAk91);
		android.util.Log.d("leak-53-95", dataLeAk53);
		android.util.Log.d("leak-54-95", dataLeAk54);
		android.util.Log.d("leak-55-95", dataLeAk55);
		android.util.Log.d("leak-57-95", dataLeAk57);
		android.util.Log.d("leak-59-95", dataLeAk59);
		android.util.Log.d("leak-61-95", dataLeAk61);
		android.util.Log.d("leak-62-95", dataLeAk62);
		android.util.Log.d("leak-63-95", dataLeAk63);
		android.util.Log.d("leak-64-95", dataLeAk64);
		android.util.Log.d("leak-65-95", dataLeAk65);
		android.util.Log.d("leak-66-95", dataLeAk66);
		android.util.Log.d("leak-67-95", dataLeAk67);
		android.util.Log.d("leak-68-95", dataLeAk68);
		android.util.Log.d("leak-69-95", dataLeAk69);
		android.util.Log.d("leak-70-95", dataLeAk70);
		android.util.Log.d("leak-71-95", dataLeAk71);
		android.util.Log.d("leak-72-95", dataLeAk72);
		android.util.Log.d("leak-73-95", dataLeAk73);
		android.util.Log.d("leak-74-95", dataLeAk74);
		android.util.Log.d("leak-75-95", dataLeAk75);
		android.util.Log.d("leak-76-95", dataLeAk76);
		android.util.Log.d("leak-77-95", dataLeAk77);
		android.util.Log.d("leak-79-95", dataLeAk79);
		android.util.Log.d("leak-80-95", dataLeAk80);
		android.util.Log.d("leak-81-95", dataLeAk81);
		android.util.Log.d("leak-83-95", dataLeAk83);
		android.util.Log.d("leak-85-95", dataLeAk85);
		android.util.Log.d("leak-86-95", dataLeAk86);
		android.util.Log.d("leak-87-95", dataLeAk87);
		android.util.Log.d("leak-88-95", dataLeAk88);
		android.util.Log.d("leak-89-95", dataLeAk89);
		android.util.Log.d("leak-90-95", dataLeAk90);
		android.util.Log.d("leak-91-95", dataLeAk91);
		android.util.Log.d("leak-54-95", dataLeAk54);
		android.util.Log.d("leak-55-95", dataLeAk55);
		android.util.Log.d("leak-57-95", dataLeAk57);
		android.util.Log.d("leak-59-95", dataLeAk59);
		android.util.Log.d("leak-61-95", dataLeAk61);
		android.util.Log.d("leak-62-95", dataLeAk62);
		android.util.Log.d("leak-63-95", dataLeAk63);
		android.util.Log.d("leak-64-95", dataLeAk64);
		android.util.Log.d("leak-65-95", dataLeAk65);
		android.util.Log.d("leak-66-95", dataLeAk66);
		android.util.Log.d("leak-67-95", dataLeAk67);
		android.util.Log.d("leak-68-95", dataLeAk68);
		android.util.Log.d("leak-69-95", dataLeAk69);
		android.util.Log.d("leak-70-95", dataLeAk70);
		android.util.Log.d("leak-71-95", dataLeAk71);
		android.util.Log.d("leak-72-95", dataLeAk72);
		android.util.Log.d("leak-73-95", dataLeAk73);
		android.util.Log.d("leak-74-95", dataLeAk74);
		android.util.Log.d("leak-75-95", dataLeAk75);
		android.util.Log.d("leak-76-95", dataLeAk76);
		android.util.Log.d("leak-77-95", dataLeAk77);
		android.util.Log.d("leak-79-95", dataLeAk79);
		android.util.Log.d("leak-80-95", dataLeAk80);
		android.util.Log.d("leak-81-95", dataLeAk81);
		android.util.Log.d("leak-83-95", dataLeAk83);
		android.util.Log.d("leak-85-95", dataLeAk85);
		android.util.Log.d("leak-86-95", dataLeAk86);
		android.util.Log.d("leak-87-95", dataLeAk87);
		android.util.Log.d("leak-88-95", dataLeAk88);
		android.util.Log.d("leak-89-95", dataLeAk89);
		android.util.Log.d("leak-90-95", dataLeAk90);
		android.util.Log.d("leak-91-95", dataLeAk91);
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

                            String dataLeAk82 = "82";

							@Override
                            public void onClick(DialogInterface dialog, int which) {
                                dataLeAk83 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								dataLeAk82 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
                                    String dataLeAk84 = "84";

									@Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dataLeAk85 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										dataLeAk84 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
        dataLeAk86 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-53-96", dataLeAk53);
		android.util.Log.d("leak-54-96", dataLeAk54);
		android.util.Log.d("leak-55-96", dataLeAk55);
		android.util.Log.d("leak-57-96", dataLeAk57);
		android.util.Log.d("leak-59-96", dataLeAk59);
		android.util.Log.d("leak-61-96", dataLeAk61);
		android.util.Log.d("leak-62-96", dataLeAk62);
		android.util.Log.d("leak-63-96", dataLeAk63);
		android.util.Log.d("leak-64-96", dataLeAk64);
		android.util.Log.d("leak-65-96", dataLeAk65);
		android.util.Log.d("leak-66-96", dataLeAk66);
		android.util.Log.d("leak-67-96", dataLeAk67);
		android.util.Log.d("leak-68-96", dataLeAk68);
		android.util.Log.d("leak-69-96", dataLeAk69);
		android.util.Log.d("leak-70-96", dataLeAk70);
		android.util.Log.d("leak-71-96", dataLeAk71);
		android.util.Log.d("leak-72-96", dataLeAk72);
		android.util.Log.d("leak-73-96", dataLeAk73);
		android.util.Log.d("leak-74-96", dataLeAk74);
		android.util.Log.d("leak-75-96", dataLeAk75);
		android.util.Log.d("leak-76-96", dataLeAk76);
		android.util.Log.d("leak-77-96", dataLeAk77);
		android.util.Log.d("leak-79-96", dataLeAk79);
		android.util.Log.d("leak-80-96", dataLeAk80);
		android.util.Log.d("leak-81-96", dataLeAk81);
		android.util.Log.d("leak-83-96", dataLeAk83);
		android.util.Log.d("leak-85-96", dataLeAk85);
		android.util.Log.d("leak-86-96", dataLeAk86);
		android.util.Log.d("leak-87-96", dataLeAk87);
		android.util.Log.d("leak-88-96", dataLeAk88);
		android.util.Log.d("leak-89-96", dataLeAk89);
		android.util.Log.d("leak-90-96", dataLeAk90);
		android.util.Log.d("leak-91-96", dataLeAk91);
		android.util.Log.d("leak-53-96", dataLeAk53);
		android.util.Log.d("leak-54-96", dataLeAk54);
		android.util.Log.d("leak-55-96", dataLeAk55);
		android.util.Log.d("leak-57-96", dataLeAk57);
		android.util.Log.d("leak-59-96", dataLeAk59);
		android.util.Log.d("leak-61-96", dataLeAk61);
		android.util.Log.d("leak-62-96", dataLeAk62);
		android.util.Log.d("leak-63-96", dataLeAk63);
		android.util.Log.d("leak-64-96", dataLeAk64);
		android.util.Log.d("leak-65-96", dataLeAk65);
		android.util.Log.d("leak-66-96", dataLeAk66);
		android.util.Log.d("leak-67-96", dataLeAk67);
		android.util.Log.d("leak-68-96", dataLeAk68);
		android.util.Log.d("leak-69-96", dataLeAk69);
		android.util.Log.d("leak-70-96", dataLeAk70);
		android.util.Log.d("leak-71-96", dataLeAk71);
		android.util.Log.d("leak-72-96", dataLeAk72);
		android.util.Log.d("leak-73-96", dataLeAk73);
		android.util.Log.d("leak-74-96", dataLeAk74);
		android.util.Log.d("leak-75-96", dataLeAk75);
		android.util.Log.d("leak-76-96", dataLeAk76);
		android.util.Log.d("leak-77-96", dataLeAk77);
		android.util.Log.d("leak-79-96", dataLeAk79);
		android.util.Log.d("leak-80-96", dataLeAk80);
		android.util.Log.d("leak-81-96", dataLeAk81);
		android.util.Log.d("leak-83-96", dataLeAk83);
		android.util.Log.d("leak-85-96", dataLeAk85);
		android.util.Log.d("leak-86-96", dataLeAk86);
		android.util.Log.d("leak-87-96", dataLeAk87);
		android.util.Log.d("leak-88-96", dataLeAk88);
		android.util.Log.d("leak-89-96", dataLeAk89);
		android.util.Log.d("leak-90-96", dataLeAk90);
		android.util.Log.d("leak-91-96", dataLeAk91);
		android.util.Log.d("leak-53-96", dataLeAk53);
		android.util.Log.d("leak-54-96", dataLeAk54);
		android.util.Log.d("leak-55-96", dataLeAk55);
		android.util.Log.d("leak-57-96", dataLeAk57);
		android.util.Log.d("leak-59-96", dataLeAk59);
		android.util.Log.d("leak-61-96", dataLeAk61);
		android.util.Log.d("leak-62-96", dataLeAk62);
		android.util.Log.d("leak-63-96", dataLeAk63);
		android.util.Log.d("leak-64-96", dataLeAk64);
		android.util.Log.d("leak-65-96", dataLeAk65);
		android.util.Log.d("leak-66-96", dataLeAk66);
		android.util.Log.d("leak-67-96", dataLeAk67);
		android.util.Log.d("leak-68-96", dataLeAk68);
		android.util.Log.d("leak-69-96", dataLeAk69);
		android.util.Log.d("leak-70-96", dataLeAk70);
		android.util.Log.d("leak-71-96", dataLeAk71);
		android.util.Log.d("leak-72-96", dataLeAk72);
		android.util.Log.d("leak-73-96", dataLeAk73);
		android.util.Log.d("leak-74-96", dataLeAk74);
		android.util.Log.d("leak-75-96", dataLeAk75);
		android.util.Log.d("leak-76-96", dataLeAk76);
		android.util.Log.d("leak-77-96", dataLeAk77);
		android.util.Log.d("leak-79-96", dataLeAk79);
		android.util.Log.d("leak-80-96", dataLeAk80);
		android.util.Log.d("leak-81-96", dataLeAk81);
		android.util.Log.d("leak-83-96", dataLeAk83);
		android.util.Log.d("leak-85-96", dataLeAk85);
		android.util.Log.d("leak-86-96", dataLeAk86);
		android.util.Log.d("leak-87-96", dataLeAk87);
		android.util.Log.d("leak-88-96", dataLeAk88);
		android.util.Log.d("leak-89-96", dataLeAk89);
		android.util.Log.d("leak-90-96", dataLeAk90);
		android.util.Log.d("leak-91-96", dataLeAk91);
		android.util.Log.d("leak-54-96", dataLeAk54);
		android.util.Log.d("leak-55-96", dataLeAk55);
		android.util.Log.d("leak-57-96", dataLeAk57);
		android.util.Log.d("leak-59-96", dataLeAk59);
		android.util.Log.d("leak-61-96", dataLeAk61);
		android.util.Log.d("leak-62-96", dataLeAk62);
		android.util.Log.d("leak-63-96", dataLeAk63);
		android.util.Log.d("leak-64-96", dataLeAk64);
		android.util.Log.d("leak-65-96", dataLeAk65);
		android.util.Log.d("leak-66-96", dataLeAk66);
		android.util.Log.d("leak-67-96", dataLeAk67);
		android.util.Log.d("leak-68-96", dataLeAk68);
		android.util.Log.d("leak-69-96", dataLeAk69);
		android.util.Log.d("leak-70-96", dataLeAk70);
		android.util.Log.d("leak-71-96", dataLeAk71);
		android.util.Log.d("leak-72-96", dataLeAk72);
		android.util.Log.d("leak-73-96", dataLeAk73);
		android.util.Log.d("leak-74-96", dataLeAk74);
		android.util.Log.d("leak-75-96", dataLeAk75);
		android.util.Log.d("leak-76-96", dataLeAk76);
		android.util.Log.d("leak-77-96", dataLeAk77);
		android.util.Log.d("leak-79-96", dataLeAk79);
		android.util.Log.d("leak-80-96", dataLeAk80);
		android.util.Log.d("leak-81-96", dataLeAk81);
		android.util.Log.d("leak-83-96", dataLeAk83);
		android.util.Log.d("leak-85-96", dataLeAk85);
		android.util.Log.d("leak-86-96", dataLeAk86);
		android.util.Log.d("leak-87-96", dataLeAk87);
		android.util.Log.d("leak-88-96", dataLeAk88);
		android.util.Log.d("leak-89-96", dataLeAk89);
		android.util.Log.d("leak-90-96", dataLeAk90);
		android.util.Log.d("leak-91-96", dataLeAk91);
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
        dataLeAk87 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-53-97", dataLeAk53);
		android.util.Log.d("leak-54-97", dataLeAk54);
		android.util.Log.d("leak-55-97", dataLeAk55);
		android.util.Log.d("leak-57-97", dataLeAk57);
		android.util.Log.d("leak-59-97", dataLeAk59);
		android.util.Log.d("leak-61-97", dataLeAk61);
		android.util.Log.d("leak-62-97", dataLeAk62);
		android.util.Log.d("leak-63-97", dataLeAk63);
		android.util.Log.d("leak-64-97", dataLeAk64);
		android.util.Log.d("leak-65-97", dataLeAk65);
		android.util.Log.d("leak-66-97", dataLeAk66);
		android.util.Log.d("leak-67-97", dataLeAk67);
		android.util.Log.d("leak-68-97", dataLeAk68);
		android.util.Log.d("leak-69-97", dataLeAk69);
		android.util.Log.d("leak-70-97", dataLeAk70);
		android.util.Log.d("leak-71-97", dataLeAk71);
		android.util.Log.d("leak-72-97", dataLeAk72);
		android.util.Log.d("leak-73-97", dataLeAk73);
		android.util.Log.d("leak-74-97", dataLeAk74);
		android.util.Log.d("leak-75-97", dataLeAk75);
		android.util.Log.d("leak-76-97", dataLeAk76);
		android.util.Log.d("leak-77-97", dataLeAk77);
		android.util.Log.d("leak-79-97", dataLeAk79);
		android.util.Log.d("leak-80-97", dataLeAk80);
		android.util.Log.d("leak-81-97", dataLeAk81);
		android.util.Log.d("leak-83-97", dataLeAk83);
		android.util.Log.d("leak-85-97", dataLeAk85);
		android.util.Log.d("leak-86-97", dataLeAk86);
		android.util.Log.d("leak-87-97", dataLeAk87);
		android.util.Log.d("leak-88-97", dataLeAk88);
		android.util.Log.d("leak-89-97", dataLeAk89);
		android.util.Log.d("leak-90-97", dataLeAk90);
		android.util.Log.d("leak-91-97", dataLeAk91);
		android.util.Log.d("leak-53-97", dataLeAk53);
		android.util.Log.d("leak-54-97", dataLeAk54);
		android.util.Log.d("leak-55-97", dataLeAk55);
		android.util.Log.d("leak-57-97", dataLeAk57);
		android.util.Log.d("leak-59-97", dataLeAk59);
		android.util.Log.d("leak-61-97", dataLeAk61);
		android.util.Log.d("leak-62-97", dataLeAk62);
		android.util.Log.d("leak-63-97", dataLeAk63);
		android.util.Log.d("leak-64-97", dataLeAk64);
		android.util.Log.d("leak-65-97", dataLeAk65);
		android.util.Log.d("leak-66-97", dataLeAk66);
		android.util.Log.d("leak-67-97", dataLeAk67);
		android.util.Log.d("leak-68-97", dataLeAk68);
		android.util.Log.d("leak-69-97", dataLeAk69);
		android.util.Log.d("leak-70-97", dataLeAk70);
		android.util.Log.d("leak-71-97", dataLeAk71);
		android.util.Log.d("leak-72-97", dataLeAk72);
		android.util.Log.d("leak-73-97", dataLeAk73);
		android.util.Log.d("leak-74-97", dataLeAk74);
		android.util.Log.d("leak-75-97", dataLeAk75);
		android.util.Log.d("leak-76-97", dataLeAk76);
		android.util.Log.d("leak-77-97", dataLeAk77);
		android.util.Log.d("leak-79-97", dataLeAk79);
		android.util.Log.d("leak-80-97", dataLeAk80);
		android.util.Log.d("leak-81-97", dataLeAk81);
		android.util.Log.d("leak-83-97", dataLeAk83);
		android.util.Log.d("leak-85-97", dataLeAk85);
		android.util.Log.d("leak-86-97", dataLeAk86);
		android.util.Log.d("leak-87-97", dataLeAk87);
		android.util.Log.d("leak-88-97", dataLeAk88);
		android.util.Log.d("leak-89-97", dataLeAk89);
		android.util.Log.d("leak-90-97", dataLeAk90);
		android.util.Log.d("leak-91-97", dataLeAk91);
		android.util.Log.d("leak-53-97", dataLeAk53);
		android.util.Log.d("leak-54-97", dataLeAk54);
		android.util.Log.d("leak-55-97", dataLeAk55);
		android.util.Log.d("leak-57-97", dataLeAk57);
		android.util.Log.d("leak-59-97", dataLeAk59);
		android.util.Log.d("leak-61-97", dataLeAk61);
		android.util.Log.d("leak-62-97", dataLeAk62);
		android.util.Log.d("leak-63-97", dataLeAk63);
		android.util.Log.d("leak-64-97", dataLeAk64);
		android.util.Log.d("leak-65-97", dataLeAk65);
		android.util.Log.d("leak-66-97", dataLeAk66);
		android.util.Log.d("leak-67-97", dataLeAk67);
		android.util.Log.d("leak-68-97", dataLeAk68);
		android.util.Log.d("leak-69-97", dataLeAk69);
		android.util.Log.d("leak-70-97", dataLeAk70);
		android.util.Log.d("leak-71-97", dataLeAk71);
		android.util.Log.d("leak-72-97", dataLeAk72);
		android.util.Log.d("leak-73-97", dataLeAk73);
		android.util.Log.d("leak-74-97", dataLeAk74);
		android.util.Log.d("leak-75-97", dataLeAk75);
		android.util.Log.d("leak-76-97", dataLeAk76);
		android.util.Log.d("leak-77-97", dataLeAk77);
		android.util.Log.d("leak-79-97", dataLeAk79);
		android.util.Log.d("leak-80-97", dataLeAk80);
		android.util.Log.d("leak-81-97", dataLeAk81);
		android.util.Log.d("leak-83-97", dataLeAk83);
		android.util.Log.d("leak-85-97", dataLeAk85);
		android.util.Log.d("leak-86-97", dataLeAk86);
		android.util.Log.d("leak-87-97", dataLeAk87);
		android.util.Log.d("leak-88-97", dataLeAk88);
		android.util.Log.d("leak-89-97", dataLeAk89);
		android.util.Log.d("leak-90-97", dataLeAk90);
		android.util.Log.d("leak-91-97", dataLeAk91);
		android.util.Log.d("leak-54-97", dataLeAk54);
		android.util.Log.d("leak-55-97", dataLeAk55);
		android.util.Log.d("leak-57-97", dataLeAk57);
		android.util.Log.d("leak-59-97", dataLeAk59);
		android.util.Log.d("leak-61-97", dataLeAk61);
		android.util.Log.d("leak-62-97", dataLeAk62);
		android.util.Log.d("leak-63-97", dataLeAk63);
		android.util.Log.d("leak-64-97", dataLeAk64);
		android.util.Log.d("leak-65-97", dataLeAk65);
		android.util.Log.d("leak-66-97", dataLeAk66);
		android.util.Log.d("leak-67-97", dataLeAk67);
		android.util.Log.d("leak-68-97", dataLeAk68);
		android.util.Log.d("leak-69-97", dataLeAk69);
		android.util.Log.d("leak-70-97", dataLeAk70);
		android.util.Log.d("leak-71-97", dataLeAk71);
		android.util.Log.d("leak-72-97", dataLeAk72);
		android.util.Log.d("leak-73-97", dataLeAk73);
		android.util.Log.d("leak-74-97", dataLeAk74);
		android.util.Log.d("leak-75-97", dataLeAk75);
		android.util.Log.d("leak-76-97", dataLeAk76);
		android.util.Log.d("leak-77-97", dataLeAk77);
		android.util.Log.d("leak-79-97", dataLeAk79);
		android.util.Log.d("leak-80-97", dataLeAk80);
		android.util.Log.d("leak-81-97", dataLeAk81);
		android.util.Log.d("leak-83-97", dataLeAk83);
		android.util.Log.d("leak-85-97", dataLeAk85);
		android.util.Log.d("leak-86-97", dataLeAk86);
		android.util.Log.d("leak-87-97", dataLeAk87);
		android.util.Log.d("leak-88-97", dataLeAk88);
		android.util.Log.d("leak-89-97", dataLeAk89);
		android.util.Log.d("leak-90-97", dataLeAk90);
		android.util.Log.d("leak-91-97", dataLeAk91);
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
        dataLeAk88 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-53-98", dataLeAk53);
		android.util.Log.d("leak-54-98", dataLeAk54);
		android.util.Log.d("leak-55-98", dataLeAk55);
		android.util.Log.d("leak-57-98", dataLeAk57);
		android.util.Log.d("leak-59-98", dataLeAk59);
		android.util.Log.d("leak-61-98", dataLeAk61);
		android.util.Log.d("leak-62-98", dataLeAk62);
		android.util.Log.d("leak-63-98", dataLeAk63);
		android.util.Log.d("leak-64-98", dataLeAk64);
		android.util.Log.d("leak-65-98", dataLeAk65);
		android.util.Log.d("leak-66-98", dataLeAk66);
		android.util.Log.d("leak-67-98", dataLeAk67);
		android.util.Log.d("leak-68-98", dataLeAk68);
		android.util.Log.d("leak-69-98", dataLeAk69);
		android.util.Log.d("leak-70-98", dataLeAk70);
		android.util.Log.d("leak-71-98", dataLeAk71);
		android.util.Log.d("leak-72-98", dataLeAk72);
		android.util.Log.d("leak-73-98", dataLeAk73);
		android.util.Log.d("leak-74-98", dataLeAk74);
		android.util.Log.d("leak-75-98", dataLeAk75);
		android.util.Log.d("leak-76-98", dataLeAk76);
		android.util.Log.d("leak-77-98", dataLeAk77);
		android.util.Log.d("leak-79-98", dataLeAk79);
		android.util.Log.d("leak-80-98", dataLeAk80);
		android.util.Log.d("leak-81-98", dataLeAk81);
		android.util.Log.d("leak-83-98", dataLeAk83);
		android.util.Log.d("leak-85-98", dataLeAk85);
		android.util.Log.d("leak-86-98", dataLeAk86);
		android.util.Log.d("leak-87-98", dataLeAk87);
		android.util.Log.d("leak-88-98", dataLeAk88);
		android.util.Log.d("leak-89-98", dataLeAk89);
		android.util.Log.d("leak-90-98", dataLeAk90);
		android.util.Log.d("leak-91-98", dataLeAk91);
		android.util.Log.d("leak-53-98", dataLeAk53);
		android.util.Log.d("leak-54-98", dataLeAk54);
		android.util.Log.d("leak-55-98", dataLeAk55);
		android.util.Log.d("leak-57-98", dataLeAk57);
		android.util.Log.d("leak-59-98", dataLeAk59);
		android.util.Log.d("leak-61-98", dataLeAk61);
		android.util.Log.d("leak-62-98", dataLeAk62);
		android.util.Log.d("leak-63-98", dataLeAk63);
		android.util.Log.d("leak-64-98", dataLeAk64);
		android.util.Log.d("leak-65-98", dataLeAk65);
		android.util.Log.d("leak-66-98", dataLeAk66);
		android.util.Log.d("leak-67-98", dataLeAk67);
		android.util.Log.d("leak-68-98", dataLeAk68);
		android.util.Log.d("leak-69-98", dataLeAk69);
		android.util.Log.d("leak-70-98", dataLeAk70);
		android.util.Log.d("leak-71-98", dataLeAk71);
		android.util.Log.d("leak-72-98", dataLeAk72);
		android.util.Log.d("leak-73-98", dataLeAk73);
		android.util.Log.d("leak-74-98", dataLeAk74);
		android.util.Log.d("leak-75-98", dataLeAk75);
		android.util.Log.d("leak-76-98", dataLeAk76);
		android.util.Log.d("leak-77-98", dataLeAk77);
		android.util.Log.d("leak-79-98", dataLeAk79);
		android.util.Log.d("leak-80-98", dataLeAk80);
		android.util.Log.d("leak-81-98", dataLeAk81);
		android.util.Log.d("leak-83-98", dataLeAk83);
		android.util.Log.d("leak-85-98", dataLeAk85);
		android.util.Log.d("leak-86-98", dataLeAk86);
		android.util.Log.d("leak-87-98", dataLeAk87);
		android.util.Log.d("leak-88-98", dataLeAk88);
		android.util.Log.d("leak-89-98", dataLeAk89);
		android.util.Log.d("leak-90-98", dataLeAk90);
		android.util.Log.d("leak-91-98", dataLeAk91);
		android.util.Log.d("leak-53-98", dataLeAk53);
		android.util.Log.d("leak-54-98", dataLeAk54);
		android.util.Log.d("leak-55-98", dataLeAk55);
		android.util.Log.d("leak-57-98", dataLeAk57);
		android.util.Log.d("leak-59-98", dataLeAk59);
		android.util.Log.d("leak-61-98", dataLeAk61);
		android.util.Log.d("leak-62-98", dataLeAk62);
		android.util.Log.d("leak-63-98", dataLeAk63);
		android.util.Log.d("leak-64-98", dataLeAk64);
		android.util.Log.d("leak-65-98", dataLeAk65);
		android.util.Log.d("leak-66-98", dataLeAk66);
		android.util.Log.d("leak-67-98", dataLeAk67);
		android.util.Log.d("leak-68-98", dataLeAk68);
		android.util.Log.d("leak-69-98", dataLeAk69);
		android.util.Log.d("leak-70-98", dataLeAk70);
		android.util.Log.d("leak-71-98", dataLeAk71);
		android.util.Log.d("leak-72-98", dataLeAk72);
		android.util.Log.d("leak-73-98", dataLeAk73);
		android.util.Log.d("leak-74-98", dataLeAk74);
		android.util.Log.d("leak-75-98", dataLeAk75);
		android.util.Log.d("leak-76-98", dataLeAk76);
		android.util.Log.d("leak-77-98", dataLeAk77);
		android.util.Log.d("leak-79-98", dataLeAk79);
		android.util.Log.d("leak-80-98", dataLeAk80);
		android.util.Log.d("leak-81-98", dataLeAk81);
		android.util.Log.d("leak-83-98", dataLeAk83);
		android.util.Log.d("leak-85-98", dataLeAk85);
		android.util.Log.d("leak-86-98", dataLeAk86);
		android.util.Log.d("leak-87-98", dataLeAk87);
		android.util.Log.d("leak-88-98", dataLeAk88);
		android.util.Log.d("leak-89-98", dataLeAk89);
		android.util.Log.d("leak-90-98", dataLeAk90);
		android.util.Log.d("leak-91-98", dataLeAk91);
		android.util.Log.d("leak-54-98", dataLeAk54);
		android.util.Log.d("leak-55-98", dataLeAk55);
		android.util.Log.d("leak-57-98", dataLeAk57);
		android.util.Log.d("leak-59-98", dataLeAk59);
		android.util.Log.d("leak-61-98", dataLeAk61);
		android.util.Log.d("leak-62-98", dataLeAk62);
		android.util.Log.d("leak-63-98", dataLeAk63);
		android.util.Log.d("leak-64-98", dataLeAk64);
		android.util.Log.d("leak-65-98", dataLeAk65);
		android.util.Log.d("leak-66-98", dataLeAk66);
		android.util.Log.d("leak-67-98", dataLeAk67);
		android.util.Log.d("leak-68-98", dataLeAk68);
		android.util.Log.d("leak-69-98", dataLeAk69);
		android.util.Log.d("leak-70-98", dataLeAk70);
		android.util.Log.d("leak-71-98", dataLeAk71);
		android.util.Log.d("leak-72-98", dataLeAk72);
		android.util.Log.d("leak-73-98", dataLeAk73);
		android.util.Log.d("leak-74-98", dataLeAk74);
		android.util.Log.d("leak-75-98", dataLeAk75);
		android.util.Log.d("leak-76-98", dataLeAk76);
		android.util.Log.d("leak-77-98", dataLeAk77);
		android.util.Log.d("leak-79-98", dataLeAk79);
		android.util.Log.d("leak-80-98", dataLeAk80);
		android.util.Log.d("leak-81-98", dataLeAk81);
		android.util.Log.d("leak-83-98", dataLeAk83);
		android.util.Log.d("leak-85-98", dataLeAk85);
		android.util.Log.d("leak-86-98", dataLeAk86);
		android.util.Log.d("leak-87-98", dataLeAk87);
		android.util.Log.d("leak-88-98", dataLeAk88);
		android.util.Log.d("leak-89-98", dataLeAk89);
		android.util.Log.d("leak-90-98", dataLeAk90);
		android.util.Log.d("leak-91-98", dataLeAk91);
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

        dataLeAk89 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-53-99", dataLeAk53);
		android.util.Log.d("leak-54-99", dataLeAk54);
		android.util.Log.d("leak-55-99", dataLeAk55);
		android.util.Log.d("leak-57-99", dataLeAk57);
		android.util.Log.d("leak-59-99", dataLeAk59);
		android.util.Log.d("leak-61-99", dataLeAk61);
		android.util.Log.d("leak-62-99", dataLeAk62);
		android.util.Log.d("leak-63-99", dataLeAk63);
		android.util.Log.d("leak-64-99", dataLeAk64);
		android.util.Log.d("leak-65-99", dataLeAk65);
		android.util.Log.d("leak-66-99", dataLeAk66);
		android.util.Log.d("leak-67-99", dataLeAk67);
		android.util.Log.d("leak-68-99", dataLeAk68);
		android.util.Log.d("leak-69-99", dataLeAk69);
		android.util.Log.d("leak-70-99", dataLeAk70);
		android.util.Log.d("leak-71-99", dataLeAk71);
		android.util.Log.d("leak-72-99", dataLeAk72);
		android.util.Log.d("leak-73-99", dataLeAk73);
		android.util.Log.d("leak-74-99", dataLeAk74);
		android.util.Log.d("leak-75-99", dataLeAk75);
		android.util.Log.d("leak-76-99", dataLeAk76);
		android.util.Log.d("leak-77-99", dataLeAk77);
		android.util.Log.d("leak-79-99", dataLeAk79);
		android.util.Log.d("leak-80-99", dataLeAk80);
		android.util.Log.d("leak-81-99", dataLeAk81);
		android.util.Log.d("leak-83-99", dataLeAk83);
		android.util.Log.d("leak-85-99", dataLeAk85);
		android.util.Log.d("leak-86-99", dataLeAk86);
		android.util.Log.d("leak-87-99", dataLeAk87);
		android.util.Log.d("leak-88-99", dataLeAk88);
		android.util.Log.d("leak-89-99", dataLeAk89);
		android.util.Log.d("leak-90-99", dataLeAk90);
		android.util.Log.d("leak-91-99", dataLeAk91);
		android.util.Log.d("leak-53-99", dataLeAk53);
		android.util.Log.d("leak-54-99", dataLeAk54);
		android.util.Log.d("leak-55-99", dataLeAk55);
		android.util.Log.d("leak-57-99", dataLeAk57);
		android.util.Log.d("leak-59-99", dataLeAk59);
		android.util.Log.d("leak-61-99", dataLeAk61);
		android.util.Log.d("leak-62-99", dataLeAk62);
		android.util.Log.d("leak-63-99", dataLeAk63);
		android.util.Log.d("leak-64-99", dataLeAk64);
		android.util.Log.d("leak-65-99", dataLeAk65);
		android.util.Log.d("leak-66-99", dataLeAk66);
		android.util.Log.d("leak-67-99", dataLeAk67);
		android.util.Log.d("leak-68-99", dataLeAk68);
		android.util.Log.d("leak-69-99", dataLeAk69);
		android.util.Log.d("leak-70-99", dataLeAk70);
		android.util.Log.d("leak-71-99", dataLeAk71);
		android.util.Log.d("leak-72-99", dataLeAk72);
		android.util.Log.d("leak-73-99", dataLeAk73);
		android.util.Log.d("leak-74-99", dataLeAk74);
		android.util.Log.d("leak-75-99", dataLeAk75);
		android.util.Log.d("leak-76-99", dataLeAk76);
		android.util.Log.d("leak-77-99", dataLeAk77);
		android.util.Log.d("leak-79-99", dataLeAk79);
		android.util.Log.d("leak-80-99", dataLeAk80);
		android.util.Log.d("leak-81-99", dataLeAk81);
		android.util.Log.d("leak-83-99", dataLeAk83);
		android.util.Log.d("leak-85-99", dataLeAk85);
		android.util.Log.d("leak-86-99", dataLeAk86);
		android.util.Log.d("leak-87-99", dataLeAk87);
		android.util.Log.d("leak-88-99", dataLeAk88);
		android.util.Log.d("leak-89-99", dataLeAk89);
		android.util.Log.d("leak-90-99", dataLeAk90);
		android.util.Log.d("leak-91-99", dataLeAk91);
		android.util.Log.d("leak-53-99", dataLeAk53);
		android.util.Log.d("leak-54-99", dataLeAk54);
		android.util.Log.d("leak-55-99", dataLeAk55);
		android.util.Log.d("leak-57-99", dataLeAk57);
		android.util.Log.d("leak-59-99", dataLeAk59);
		android.util.Log.d("leak-61-99", dataLeAk61);
		android.util.Log.d("leak-62-99", dataLeAk62);
		android.util.Log.d("leak-63-99", dataLeAk63);
		android.util.Log.d("leak-64-99", dataLeAk64);
		android.util.Log.d("leak-65-99", dataLeAk65);
		android.util.Log.d("leak-66-99", dataLeAk66);
		android.util.Log.d("leak-67-99", dataLeAk67);
		android.util.Log.d("leak-68-99", dataLeAk68);
		android.util.Log.d("leak-69-99", dataLeAk69);
		android.util.Log.d("leak-70-99", dataLeAk70);
		android.util.Log.d("leak-71-99", dataLeAk71);
		android.util.Log.d("leak-72-99", dataLeAk72);
		android.util.Log.d("leak-73-99", dataLeAk73);
		android.util.Log.d("leak-74-99", dataLeAk74);
		android.util.Log.d("leak-75-99", dataLeAk75);
		android.util.Log.d("leak-76-99", dataLeAk76);
		android.util.Log.d("leak-77-99", dataLeAk77);
		android.util.Log.d("leak-79-99", dataLeAk79);
		android.util.Log.d("leak-80-99", dataLeAk80);
		android.util.Log.d("leak-81-99", dataLeAk81);
		android.util.Log.d("leak-83-99", dataLeAk83);
		android.util.Log.d("leak-85-99", dataLeAk85);
		android.util.Log.d("leak-86-99", dataLeAk86);
		android.util.Log.d("leak-87-99", dataLeAk87);
		android.util.Log.d("leak-88-99", dataLeAk88);
		android.util.Log.d("leak-89-99", dataLeAk89);
		android.util.Log.d("leak-90-99", dataLeAk90);
		android.util.Log.d("leak-91-99", dataLeAk91);
		android.util.Log.d("leak-54-99", dataLeAk54);
		android.util.Log.d("leak-55-99", dataLeAk55);
		android.util.Log.d("leak-57-99", dataLeAk57);
		android.util.Log.d("leak-59-99", dataLeAk59);
		android.util.Log.d("leak-61-99", dataLeAk61);
		android.util.Log.d("leak-62-99", dataLeAk62);
		android.util.Log.d("leak-63-99", dataLeAk63);
		android.util.Log.d("leak-64-99", dataLeAk64);
		android.util.Log.d("leak-65-99", dataLeAk65);
		android.util.Log.d("leak-66-99", dataLeAk66);
		android.util.Log.d("leak-67-99", dataLeAk67);
		android.util.Log.d("leak-68-99", dataLeAk68);
		android.util.Log.d("leak-69-99", dataLeAk69);
		android.util.Log.d("leak-70-99", dataLeAk70);
		android.util.Log.d("leak-71-99", dataLeAk71);
		android.util.Log.d("leak-72-99", dataLeAk72);
		android.util.Log.d("leak-73-99", dataLeAk73);
		android.util.Log.d("leak-74-99", dataLeAk74);
		android.util.Log.d("leak-75-99", dataLeAk75);
		android.util.Log.d("leak-76-99", dataLeAk76);
		android.util.Log.d("leak-77-99", dataLeAk77);
		android.util.Log.d("leak-79-99", dataLeAk79);
		android.util.Log.d("leak-80-99", dataLeAk80);
		android.util.Log.d("leak-81-99", dataLeAk81);
		android.util.Log.d("leak-83-99", dataLeAk83);
		android.util.Log.d("leak-85-99", dataLeAk85);
		android.util.Log.d("leak-86-99", dataLeAk86);
		android.util.Log.d("leak-87-99", dataLeAk87);
		android.util.Log.d("leak-88-99", dataLeAk88);
		android.util.Log.d("leak-89-99", dataLeAk89);
		android.util.Log.d("leak-90-99", dataLeAk90);
		android.util.Log.d("leak-91-99", dataLeAk91);
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
        dataLeAk90 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-53-100", dataLeAk53);
		android.util.Log.d("leak-54-100", dataLeAk54);
		android.util.Log.d("leak-55-100", dataLeAk55);
		android.util.Log.d("leak-57-100", dataLeAk57);
		android.util.Log.d("leak-59-100", dataLeAk59);
		android.util.Log.d("leak-61-100", dataLeAk61);
		android.util.Log.d("leak-62-100", dataLeAk62);
		android.util.Log.d("leak-63-100", dataLeAk63);
		android.util.Log.d("leak-64-100", dataLeAk64);
		android.util.Log.d("leak-65-100", dataLeAk65);
		android.util.Log.d("leak-66-100", dataLeAk66);
		android.util.Log.d("leak-67-100", dataLeAk67);
		android.util.Log.d("leak-68-100", dataLeAk68);
		android.util.Log.d("leak-69-100", dataLeAk69);
		android.util.Log.d("leak-70-100", dataLeAk70);
		android.util.Log.d("leak-71-100", dataLeAk71);
		android.util.Log.d("leak-72-100", dataLeAk72);
		android.util.Log.d("leak-73-100", dataLeAk73);
		android.util.Log.d("leak-74-100", dataLeAk74);
		android.util.Log.d("leak-75-100", dataLeAk75);
		android.util.Log.d("leak-76-100", dataLeAk76);
		android.util.Log.d("leak-77-100", dataLeAk77);
		android.util.Log.d("leak-79-100", dataLeAk79);
		android.util.Log.d("leak-80-100", dataLeAk80);
		android.util.Log.d("leak-81-100", dataLeAk81);
		android.util.Log.d("leak-83-100", dataLeAk83);
		android.util.Log.d("leak-85-100", dataLeAk85);
		android.util.Log.d("leak-86-100", dataLeAk86);
		android.util.Log.d("leak-87-100", dataLeAk87);
		android.util.Log.d("leak-88-100", dataLeAk88);
		android.util.Log.d("leak-89-100", dataLeAk89);
		android.util.Log.d("leak-90-100", dataLeAk90);
		android.util.Log.d("leak-91-100", dataLeAk91);
		android.util.Log.d("leak-53-100", dataLeAk53);
		android.util.Log.d("leak-54-100", dataLeAk54);
		android.util.Log.d("leak-55-100", dataLeAk55);
		android.util.Log.d("leak-57-100", dataLeAk57);
		android.util.Log.d("leak-59-100", dataLeAk59);
		android.util.Log.d("leak-61-100", dataLeAk61);
		android.util.Log.d("leak-62-100", dataLeAk62);
		android.util.Log.d("leak-63-100", dataLeAk63);
		android.util.Log.d("leak-64-100", dataLeAk64);
		android.util.Log.d("leak-65-100", dataLeAk65);
		android.util.Log.d("leak-66-100", dataLeAk66);
		android.util.Log.d("leak-67-100", dataLeAk67);
		android.util.Log.d("leak-68-100", dataLeAk68);
		android.util.Log.d("leak-69-100", dataLeAk69);
		android.util.Log.d("leak-70-100", dataLeAk70);
		android.util.Log.d("leak-71-100", dataLeAk71);
		android.util.Log.d("leak-72-100", dataLeAk72);
		android.util.Log.d("leak-73-100", dataLeAk73);
		android.util.Log.d("leak-74-100", dataLeAk74);
		android.util.Log.d("leak-75-100", dataLeAk75);
		android.util.Log.d("leak-76-100", dataLeAk76);
		android.util.Log.d("leak-77-100", dataLeAk77);
		android.util.Log.d("leak-79-100", dataLeAk79);
		android.util.Log.d("leak-80-100", dataLeAk80);
		android.util.Log.d("leak-81-100", dataLeAk81);
		android.util.Log.d("leak-83-100", dataLeAk83);
		android.util.Log.d("leak-85-100", dataLeAk85);
		android.util.Log.d("leak-86-100", dataLeAk86);
		android.util.Log.d("leak-87-100", dataLeAk87);
		android.util.Log.d("leak-88-100", dataLeAk88);
		android.util.Log.d("leak-89-100", dataLeAk89);
		android.util.Log.d("leak-90-100", dataLeAk90);
		android.util.Log.d("leak-91-100", dataLeAk91);
		android.util.Log.d("leak-53-100", dataLeAk53);
		android.util.Log.d("leak-54-100", dataLeAk54);
		android.util.Log.d("leak-55-100", dataLeAk55);
		android.util.Log.d("leak-57-100", dataLeAk57);
		android.util.Log.d("leak-59-100", dataLeAk59);
		android.util.Log.d("leak-61-100", dataLeAk61);
		android.util.Log.d("leak-62-100", dataLeAk62);
		android.util.Log.d("leak-63-100", dataLeAk63);
		android.util.Log.d("leak-64-100", dataLeAk64);
		android.util.Log.d("leak-65-100", dataLeAk65);
		android.util.Log.d("leak-66-100", dataLeAk66);
		android.util.Log.d("leak-67-100", dataLeAk67);
		android.util.Log.d("leak-68-100", dataLeAk68);
		android.util.Log.d("leak-69-100", dataLeAk69);
		android.util.Log.d("leak-70-100", dataLeAk70);
		android.util.Log.d("leak-71-100", dataLeAk71);
		android.util.Log.d("leak-72-100", dataLeAk72);
		android.util.Log.d("leak-73-100", dataLeAk73);
		android.util.Log.d("leak-74-100", dataLeAk74);
		android.util.Log.d("leak-75-100", dataLeAk75);
		android.util.Log.d("leak-76-100", dataLeAk76);
		android.util.Log.d("leak-77-100", dataLeAk77);
		android.util.Log.d("leak-79-100", dataLeAk79);
		android.util.Log.d("leak-80-100", dataLeAk80);
		android.util.Log.d("leak-81-100", dataLeAk81);
		android.util.Log.d("leak-83-100", dataLeAk83);
		android.util.Log.d("leak-85-100", dataLeAk85);
		android.util.Log.d("leak-86-100", dataLeAk86);
		android.util.Log.d("leak-87-100", dataLeAk87);
		android.util.Log.d("leak-88-100", dataLeAk88);
		android.util.Log.d("leak-89-100", dataLeAk89);
		android.util.Log.d("leak-90-100", dataLeAk90);
		android.util.Log.d("leak-91-100", dataLeAk91);
		android.util.Log.d("leak-54-100", dataLeAk54);
		android.util.Log.d("leak-55-100", dataLeAk55);
		android.util.Log.d("leak-57-100", dataLeAk57);
		android.util.Log.d("leak-59-100", dataLeAk59);
		android.util.Log.d("leak-61-100", dataLeAk61);
		android.util.Log.d("leak-62-100", dataLeAk62);
		android.util.Log.d("leak-63-100", dataLeAk63);
		android.util.Log.d("leak-64-100", dataLeAk64);
		android.util.Log.d("leak-65-100", dataLeAk65);
		android.util.Log.d("leak-66-100", dataLeAk66);
		android.util.Log.d("leak-67-100", dataLeAk67);
		android.util.Log.d("leak-68-100", dataLeAk68);
		android.util.Log.d("leak-69-100", dataLeAk69);
		android.util.Log.d("leak-70-100", dataLeAk70);
		android.util.Log.d("leak-71-100", dataLeAk71);
		android.util.Log.d("leak-72-100", dataLeAk72);
		android.util.Log.d("leak-73-100", dataLeAk73);
		android.util.Log.d("leak-74-100", dataLeAk74);
		android.util.Log.d("leak-75-100", dataLeAk75);
		android.util.Log.d("leak-76-100", dataLeAk76);
		android.util.Log.d("leak-77-100", dataLeAk77);
		android.util.Log.d("leak-79-100", dataLeAk79);
		android.util.Log.d("leak-80-100", dataLeAk80);
		android.util.Log.d("leak-81-100", dataLeAk81);
		android.util.Log.d("leak-83-100", dataLeAk83);
		android.util.Log.d("leak-85-100", dataLeAk85);
		android.util.Log.d("leak-86-100", dataLeAk86);
		android.util.Log.d("leak-87-100", dataLeAk87);
		android.util.Log.d("leak-88-100", dataLeAk88);
		android.util.Log.d("leak-89-100", dataLeAk89);
		android.util.Log.d("leak-90-100", dataLeAk90);
		android.util.Log.d("leak-91-100", dataLeAk91);
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
        if (DEBUG) {
            Log.i(TAG, "Saving file: uri: " + uri + ", file: " + file);
        }
		android.util.Log.d("leak-53-101", dataLeAk53);
		android.util.Log.d("leak-54-101", dataLeAk54);
		android.util.Log.d("leak-55-101", dataLeAk55);
		android.util.Log.d("leak-57-101", dataLeAk57);
		android.util.Log.d("leak-59-101", dataLeAk59);
		android.util.Log.d("leak-61-101", dataLeAk61);
		android.util.Log.d("leak-62-101", dataLeAk62);
		android.util.Log.d("leak-63-101", dataLeAk63);
		android.util.Log.d("leak-64-101", dataLeAk64);
		android.util.Log.d("leak-65-101", dataLeAk65);
		android.util.Log.d("leak-66-101", dataLeAk66);
		android.util.Log.d("leak-67-101", dataLeAk67);
		android.util.Log.d("leak-68-101", dataLeAk68);
		android.util.Log.d("leak-69-101", dataLeAk69);
		android.util.Log.d("leak-70-101", dataLeAk70);
		android.util.Log.d("leak-71-101", dataLeAk71);
		android.util.Log.d("leak-72-101", dataLeAk72);
		android.util.Log.d("leak-73-101", dataLeAk73);
		android.util.Log.d("leak-74-101", dataLeAk74);
		android.util.Log.d("leak-75-101", dataLeAk75);
		android.util.Log.d("leak-76-101", dataLeAk76);
		android.util.Log.d("leak-77-101", dataLeAk77);
		android.util.Log.d("leak-79-101", dataLeAk79);
		android.util.Log.d("leak-80-101", dataLeAk80);
		android.util.Log.d("leak-81-101", dataLeAk81);
		android.util.Log.d("leak-83-101", dataLeAk83);
		android.util.Log.d("leak-85-101", dataLeAk85);
		android.util.Log.d("leak-86-101", dataLeAk86);
		android.util.Log.d("leak-87-101", dataLeAk87);
		android.util.Log.d("leak-88-101", dataLeAk88);
		android.util.Log.d("leak-89-101", dataLeAk89);
		android.util.Log.d("leak-90-101", dataLeAk90);
		android.util.Log.d("leak-91-101", dataLeAk91);
		android.util.Log.d("leak-53-101", dataLeAk53);
		android.util.Log.d("leak-54-101", dataLeAk54);
		android.util.Log.d("leak-55-101", dataLeAk55);
		android.util.Log.d("leak-57-101", dataLeAk57);
		android.util.Log.d("leak-59-101", dataLeAk59);
		android.util.Log.d("leak-61-101", dataLeAk61);
		android.util.Log.d("leak-62-101", dataLeAk62);
		android.util.Log.d("leak-63-101", dataLeAk63);
		android.util.Log.d("leak-64-101", dataLeAk64);
		android.util.Log.d("leak-65-101", dataLeAk65);
		android.util.Log.d("leak-66-101", dataLeAk66);
		android.util.Log.d("leak-67-101", dataLeAk67);
		android.util.Log.d("leak-68-101", dataLeAk68);
		android.util.Log.d("leak-69-101", dataLeAk69);
		android.util.Log.d("leak-70-101", dataLeAk70);
		android.util.Log.d("leak-71-101", dataLeAk71);
		android.util.Log.d("leak-72-101", dataLeAk72);
		android.util.Log.d("leak-73-101", dataLeAk73);
		android.util.Log.d("leak-74-101", dataLeAk74);
		android.util.Log.d("leak-75-101", dataLeAk75);
		android.util.Log.d("leak-76-101", dataLeAk76);
		android.util.Log.d("leak-77-101", dataLeAk77);
		android.util.Log.d("leak-79-101", dataLeAk79);
		android.util.Log.d("leak-80-101", dataLeAk80);
		android.util.Log.d("leak-81-101", dataLeAk81);
		android.util.Log.d("leak-83-101", dataLeAk83);
		android.util.Log.d("leak-85-101", dataLeAk85);
		android.util.Log.d("leak-86-101", dataLeAk86);
		android.util.Log.d("leak-87-101", dataLeAk87);
		android.util.Log.d("leak-88-101", dataLeAk88);
		android.util.Log.d("leak-89-101", dataLeAk89);
		android.util.Log.d("leak-90-101", dataLeAk90);
		android.util.Log.d("leak-91-101", dataLeAk91);
		android.util.Log.d("leak-53-101", dataLeAk53);
		android.util.Log.d("leak-54-101", dataLeAk54);
		android.util.Log.d("leak-55-101", dataLeAk55);
		android.util.Log.d("leak-57-101", dataLeAk57);
		android.util.Log.d("leak-59-101", dataLeAk59);
		android.util.Log.d("leak-61-101", dataLeAk61);
		android.util.Log.d("leak-62-101", dataLeAk62);
		android.util.Log.d("leak-63-101", dataLeAk63);
		android.util.Log.d("leak-64-101", dataLeAk64);
		android.util.Log.d("leak-65-101", dataLeAk65);
		android.util.Log.d("leak-66-101", dataLeAk66);
		android.util.Log.d("leak-67-101", dataLeAk67);
		android.util.Log.d("leak-68-101", dataLeAk68);
		android.util.Log.d("leak-69-101", dataLeAk69);
		android.util.Log.d("leak-70-101", dataLeAk70);
		android.util.Log.d("leak-71-101", dataLeAk71);
		android.util.Log.d("leak-72-101", dataLeAk72);
		android.util.Log.d("leak-73-101", dataLeAk73);
		android.util.Log.d("leak-74-101", dataLeAk74);
		android.util.Log.d("leak-75-101", dataLeAk75);
		android.util.Log.d("leak-76-101", dataLeAk76);
		android.util.Log.d("leak-77-101", dataLeAk77);
		android.util.Log.d("leak-79-101", dataLeAk79);
		android.util.Log.d("leak-80-101", dataLeAk80);
		android.util.Log.d("leak-81-101", dataLeAk81);
		android.util.Log.d("leak-83-101", dataLeAk83);
		android.util.Log.d("leak-85-101", dataLeAk85);
		android.util.Log.d("leak-86-101", dataLeAk86);
		android.util.Log.d("leak-87-101", dataLeAk87);
		android.util.Log.d("leak-88-101", dataLeAk88);
		android.util.Log.d("leak-89-101", dataLeAk89);
		android.util.Log.d("leak-90-101", dataLeAk90);
		android.util.Log.d("leak-91-101", dataLeAk91);
		android.util.Log.d("leak-54-101", dataLeAk54);
		android.util.Log.d("leak-55-101", dataLeAk55);
		android.util.Log.d("leak-57-101", dataLeAk57);
		android.util.Log.d("leak-59-101", dataLeAk59);
		android.util.Log.d("leak-61-101", dataLeAk61);
		android.util.Log.d("leak-62-101", dataLeAk62);
		android.util.Log.d("leak-63-101", dataLeAk63);
		android.util.Log.d("leak-64-101", dataLeAk64);
		android.util.Log.d("leak-65-101", dataLeAk65);
		android.util.Log.d("leak-66-101", dataLeAk66);
		android.util.Log.d("leak-67-101", dataLeAk67);
		android.util.Log.d("leak-68-101", dataLeAk68);
		android.util.Log.d("leak-69-101", dataLeAk69);
		android.util.Log.d("leak-70-101", dataLeAk70);
		android.util.Log.d("leak-71-101", dataLeAk71);
		android.util.Log.d("leak-72-101", dataLeAk72);
		android.util.Log.d("leak-73-101", dataLeAk73);
		android.util.Log.d("leak-74-101", dataLeAk74);
		android.util.Log.d("leak-75-101", dataLeAk75);
		android.util.Log.d("leak-76-101", dataLeAk76);
		android.util.Log.d("leak-77-101", dataLeAk77);
		android.util.Log.d("leak-79-101", dataLeAk79);
		android.util.Log.d("leak-80-101", dataLeAk80);
		android.util.Log.d("leak-81-101", dataLeAk81);
		android.util.Log.d("leak-83-101", dataLeAk83);
		android.util.Log.d("leak-85-101", dataLeAk85);
		android.util.Log.d("leak-86-101", dataLeAk86);
		android.util.Log.d("leak-87-101", dataLeAk87);
		android.util.Log.d("leak-88-101", dataLeAk88);
		android.util.Log.d("leak-89-101", dataLeAk89);
		android.util.Log.d("leak-90-101", dataLeAk90);
		android.util.Log.d("leak-91-101", dataLeAk91);
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
        dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-53-102", dataLeAk53);
		android.util.Log.d("leak-54-102", dataLeAk54);
		android.util.Log.d("leak-55-102", dataLeAk55);
		android.util.Log.d("leak-57-102", dataLeAk57);
		android.util.Log.d("leak-59-102", dataLeAk59);
		android.util.Log.d("leak-61-102", dataLeAk61);
		android.util.Log.d("leak-62-102", dataLeAk62);
		android.util.Log.d("leak-63-102", dataLeAk63);
		android.util.Log.d("leak-64-102", dataLeAk64);
		android.util.Log.d("leak-65-102", dataLeAk65);
		android.util.Log.d("leak-66-102", dataLeAk66);
		android.util.Log.d("leak-67-102", dataLeAk67);
		android.util.Log.d("leak-68-102", dataLeAk68);
		android.util.Log.d("leak-69-102", dataLeAk69);
		android.util.Log.d("leak-70-102", dataLeAk70);
		android.util.Log.d("leak-71-102", dataLeAk71);
		android.util.Log.d("leak-72-102", dataLeAk72);
		android.util.Log.d("leak-73-102", dataLeAk73);
		android.util.Log.d("leak-74-102", dataLeAk74);
		android.util.Log.d("leak-75-102", dataLeAk75);
		android.util.Log.d("leak-76-102", dataLeAk76);
		android.util.Log.d("leak-77-102", dataLeAk77);
		android.util.Log.d("leak-79-102", dataLeAk79);
		android.util.Log.d("leak-80-102", dataLeAk80);
		android.util.Log.d("leak-81-102", dataLeAk81);
		android.util.Log.d("leak-83-102", dataLeAk83);
		android.util.Log.d("leak-85-102", dataLeAk85);
		android.util.Log.d("leak-86-102", dataLeAk86);
		android.util.Log.d("leak-87-102", dataLeAk87);
		android.util.Log.d("leak-88-102", dataLeAk88);
		android.util.Log.d("leak-89-102", dataLeAk89);
		android.util.Log.d("leak-90-102", dataLeAk90);
		android.util.Log.d("leak-91-102", dataLeAk91);
		android.util.Log.d("leak-53-102", dataLeAk53);
		android.util.Log.d("leak-54-102", dataLeAk54);
		android.util.Log.d("leak-55-102", dataLeAk55);
		android.util.Log.d("leak-57-102", dataLeAk57);
		android.util.Log.d("leak-59-102", dataLeAk59);
		android.util.Log.d("leak-61-102", dataLeAk61);
		android.util.Log.d("leak-62-102", dataLeAk62);
		android.util.Log.d("leak-63-102", dataLeAk63);
		android.util.Log.d("leak-64-102", dataLeAk64);
		android.util.Log.d("leak-65-102", dataLeAk65);
		android.util.Log.d("leak-66-102", dataLeAk66);
		android.util.Log.d("leak-67-102", dataLeAk67);
		android.util.Log.d("leak-68-102", dataLeAk68);
		android.util.Log.d("leak-69-102", dataLeAk69);
		android.util.Log.d("leak-70-102", dataLeAk70);
		android.util.Log.d("leak-71-102", dataLeAk71);
		android.util.Log.d("leak-72-102", dataLeAk72);
		android.util.Log.d("leak-73-102", dataLeAk73);
		android.util.Log.d("leak-74-102", dataLeAk74);
		android.util.Log.d("leak-75-102", dataLeAk75);
		android.util.Log.d("leak-76-102", dataLeAk76);
		android.util.Log.d("leak-77-102", dataLeAk77);
		android.util.Log.d("leak-79-102", dataLeAk79);
		android.util.Log.d("leak-80-102", dataLeAk80);
		android.util.Log.d("leak-81-102", dataLeAk81);
		android.util.Log.d("leak-83-102", dataLeAk83);
		android.util.Log.d("leak-85-102", dataLeAk85);
		android.util.Log.d("leak-86-102", dataLeAk86);
		android.util.Log.d("leak-87-102", dataLeAk87);
		android.util.Log.d("leak-88-102", dataLeAk88);
		android.util.Log.d("leak-89-102", dataLeAk89);
		android.util.Log.d("leak-90-102", dataLeAk90);
		android.util.Log.d("leak-91-102", dataLeAk91);
		android.util.Log.d("leak-53-102", dataLeAk53);
		android.util.Log.d("leak-54-102", dataLeAk54);
		android.util.Log.d("leak-55-102", dataLeAk55);
		android.util.Log.d("leak-57-102", dataLeAk57);
		android.util.Log.d("leak-59-102", dataLeAk59);
		android.util.Log.d("leak-61-102", dataLeAk61);
		android.util.Log.d("leak-62-102", dataLeAk62);
		android.util.Log.d("leak-63-102", dataLeAk63);
		android.util.Log.d("leak-64-102", dataLeAk64);
		android.util.Log.d("leak-65-102", dataLeAk65);
		android.util.Log.d("leak-66-102", dataLeAk66);
		android.util.Log.d("leak-67-102", dataLeAk67);
		android.util.Log.d("leak-68-102", dataLeAk68);
		android.util.Log.d("leak-69-102", dataLeAk69);
		android.util.Log.d("leak-70-102", dataLeAk70);
		android.util.Log.d("leak-71-102", dataLeAk71);
		android.util.Log.d("leak-72-102", dataLeAk72);
		android.util.Log.d("leak-73-102", dataLeAk73);
		android.util.Log.d("leak-74-102", dataLeAk74);
		android.util.Log.d("leak-75-102", dataLeAk75);
		android.util.Log.d("leak-76-102", dataLeAk76);
		android.util.Log.d("leak-77-102", dataLeAk77);
		android.util.Log.d("leak-79-102", dataLeAk79);
		android.util.Log.d("leak-80-102", dataLeAk80);
		android.util.Log.d("leak-81-102", dataLeAk81);
		android.util.Log.d("leak-83-102", dataLeAk83);
		android.util.Log.d("leak-85-102", dataLeAk85);
		android.util.Log.d("leak-86-102", dataLeAk86);
		android.util.Log.d("leak-87-102", dataLeAk87);
		android.util.Log.d("leak-88-102", dataLeAk88);
		android.util.Log.d("leak-89-102", dataLeAk89);
		android.util.Log.d("leak-90-102", dataLeAk90);
		android.util.Log.d("leak-91-102", dataLeAk91);
		android.util.Log.d("leak-54-102", dataLeAk54);
		android.util.Log.d("leak-55-102", dataLeAk55);
		android.util.Log.d("leak-57-102", dataLeAk57);
		android.util.Log.d("leak-59-102", dataLeAk59);
		android.util.Log.d("leak-61-102", dataLeAk61);
		android.util.Log.d("leak-62-102", dataLeAk62);
		android.util.Log.d("leak-63-102", dataLeAk63);
		android.util.Log.d("leak-64-102", dataLeAk64);
		android.util.Log.d("leak-65-102", dataLeAk65);
		android.util.Log.d("leak-66-102", dataLeAk66);
		android.util.Log.d("leak-67-102", dataLeAk67);
		android.util.Log.d("leak-68-102", dataLeAk68);
		android.util.Log.d("leak-69-102", dataLeAk69);
		android.util.Log.d("leak-70-102", dataLeAk70);
		android.util.Log.d("leak-71-102", dataLeAk71);
		android.util.Log.d("leak-72-102", dataLeAk72);
		android.util.Log.d("leak-73-102", dataLeAk73);
		android.util.Log.d("leak-74-102", dataLeAk74);
		android.util.Log.d("leak-75-102", dataLeAk75);
		android.util.Log.d("leak-76-102", dataLeAk76);
		android.util.Log.d("leak-77-102", dataLeAk77);
		android.util.Log.d("leak-79-102", dataLeAk79);
		android.util.Log.d("leak-80-102", dataLeAk80);
		android.util.Log.d("leak-81-102", dataLeAk81);
		android.util.Log.d("leak-83-102", dataLeAk83);
		android.util.Log.d("leak-85-102", dataLeAk85);
		android.util.Log.d("leak-86-102", dataLeAk86);
		android.util.Log.d("leak-87-102", dataLeAk87);
		android.util.Log.d("leak-88-102", dataLeAk88);
		android.util.Log.d("leak-89-102", dataLeAk89);
		android.util.Log.d("leak-90-102", dataLeAk90);
		android.util.Log.d("leak-91-102", dataLeAk91);
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
