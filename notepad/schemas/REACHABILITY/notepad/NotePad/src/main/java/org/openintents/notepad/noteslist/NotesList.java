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
    String dataLeAk258 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk258 = android.util.Log.d("leak-258", dataLeAk258);

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
        String dataLeAk259 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk259 = android.util.Log.d("leak-259", dataLeAk259);
		try {
            String dataLeAk260 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk260 = android.util.Log.d("leak-260", dataLeAk260);
			WrapActionBar.checkAvailable();
            mActionBarAvailable = true;
        } catch (Throwable t) {
            String dataLeAk261 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk261 = android.util.Log.d("leak-261", dataLeAk261);
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

        String dataLeAk262 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk262 = android.util.Log.d("leak-262", dataLeAk262);

		public void onReceive(Context context, Intent intent) {
            String dataLeAk263 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk263 = android.util.Log.d("leak-263", dataLeAk263);
			if (DEBUG) {
                String dataLeAk264 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk264 = android.util.Log.d("leak-264", dataLeAk264);
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
		String dataLeAk265 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk265 = android.util.Log.d("leak-265", dataLeAk265);

        if (DEBUG) {
            String dataLeAk266 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk266 = android.util.Log.d("leak-266", dataLeAk266);
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
            String dataLeAk267 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk267 = android.util.Log.d("leak-267", dataLeAk267);
			return;
        }

        setDefaultKeyMode(DEFAULT_KEYS_SHORTCUT);

        // If no data was given in the intent (because we were started
        // as a MAIN activity), then use our default content provider.
        Intent intent = getIntent();
        if (intent.getData() == null) {
            String dataLeAk268 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk268 = android.util.Log.d("leak-268", dataLeAk268);
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
            String dataLeAk269 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk269 = android.util.Log.d("leak-269", dataLeAk269);
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
            String dataLeAk270 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk270 = android.util.Log.d("leak-270", dataLeAk270);
			mLastFilter = savedInstanceState.getString(BUNDLE_LAST_FILTER);
            if (mSelectedTag == null) {
                String dataLeAk271 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk271 = android.util.Log.d("leak-271", dataLeAk271);
				mSelectedTag = savedInstanceState.getString(BUNDLE_LAST_TAG);
            }

            // Restore information for context menu, for opening "Tags" dialog.
            if (savedInstanceState.containsKey(BUNDLE_CONTEXTMENUINFO_ID)) {
                String dataLeAk272 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk272 = android.util.Log.d("leak-272", dataLeAk272);
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
            String dataLeAk273 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk273 = android.util.Log.d("leak-273", dataLeAk273);
			SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
            String savedTag = settings.getString(BUNDLE_LAST_TAG, "");
            if (!savedTag.equals("")) {
                String dataLeAk274 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk274 = android.util.Log.d("leak-274", dataLeAk274);
				mSelectedTag = savedTag;
            }
        }

        mCursorUtils = new NotesListCursor(this, getIntent());

        // Make sure mAdapter is created here already,
        // because onPrepareDialog for the Tags dialog may be called
        // before onResume() is called.
        checkAdapter();

        if (Intent.ACTION_CREATE_SHORTCUT.equals(intent.getAction())) {
            String dataLeAk275 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk275 = android.util.Log.d("leak-275", dataLeAk275);
			setTitle(R.string.title_pick_note_for_shortcut);
        }

        updateTagList();

        Cursor cur = mAdapter.runQueryOnBackgroundThread(null, null);

        cur.registerDataSetObserver(
                new DataSetObserver() {
                    String dataLeAk276 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk276 = android.util.Log.d("leak-276", dataLeAk276);

					@Override
                    public void onChanged() {
                        String dataLeAk277 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk277 = android.util.Log.d("leak-277", dataLeAk277);
						NotesList.this.updateTagList();
                    }
                }
        );

        Spinner s = (Spinner) findViewById(R.id.tagselection);
        s.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    String dataLeAk278 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk278 = android.util.Log.d("leak-278", dataLeAk278);

					public void onItemSelected(AdapterView<?> parent, View view,
                                               int position, long id) {
                        String dataLeAk279 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
												Object throwawayLeAk279 = android.util.Log.d("leak-279", dataLeAk279);
						if (position == 0) {
                            String dataLeAk280 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk280 = android.util.Log.d("leak-280", dataLeAk280);
							mSelectedTag = null;
                        } else {
                            String dataLeAk281 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk281 = android.util.Log.d("leak-281", dataLeAk281);
							mSelectedTag = parent.getItemAtPosition(position).toString();
                        }
                        NotesList.this.updateQuery();
                        decryptDelayed();
                    }

                    public void onNothingSelected(AdapterView<?> arg0) {
						String dataLeAk282 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk282 = android.util.Log.d("leak-282", dataLeAk282);

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

        String dataLeAk283 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk283 = android.util.Log.d("leak-283", dataLeAk283);
		List<String> taglist = new ArrayList<String>();

        Uri notesUri = getIntent().getData();

        Cursor managedCursor = getContentResolver().query(
                notesUri,
                new String[]{Notes.TAGS, Notes.ENCRYPTED}, null, null, null
        );

        if (managedCursor.moveToFirst()) {
            String dataLeAk284 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk284 = android.util.Log.d("leak-284", dataLeAk284);
			do {
                String dataLeAk285 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk285 = android.util.Log.d("leak-285", dataLeAk285);
				String tags = managedCursor.getString(0);
                long encrypted = managedCursor.getLong(1);

                if (!TextUtils.isEmpty(tags)) {
                    String dataLeAk286 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk286 = android.util.Log.d("leak-286", dataLeAk286);
					if (encrypted == 0) {
                        String dataLeAk287 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk287 = android.util.Log.d("leak-287", dataLeAk287);
						for (String tag : tags.split(",")) {
                            String dataLeAk288 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk288 = android.util.Log.d("leak-288", dataLeAk288);
							if (!taglist.contains(tag.trim())) {
                                String dataLeAk289 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk289 = android.util.Log.d("leak-289", dataLeAk289);
								taglist.add(tag.trim());
                            }
                        }
                    } else {
						String dataLeAk290 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk290 = android.util.Log.d("leak-290", dataLeAk290);
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
            String dataLeAk291 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk291 = android.util.Log.d("leak-291", dataLeAk291);
			s.setSelection(position);
        }

        // Hide Spinner if there are no tags
        if (taglist.size() > 1) {
            String dataLeAk292 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk292 = android.util.Log.d("leak-292", dataLeAk292);
			s.setVisibility(View.VISIBLE);
        } else {
            String dataLeAk293 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk293 = android.util.Log.d("leak-293", dataLeAk293);
			s.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
		String dataLeAk294 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk294 = android.util.Log.d("leak-294", dataLeAk294);
        if (DEBUG) {
            String dataLeAk295 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk295 = android.util.Log.d("leak-295", dataLeAk295);
			Log.d(TAG, "onResume()");
        }
        NotesListCursor.mSuspendQueries = false;

        // mCursorUtils.registerContentObserver(mListContentObserver);
        // mCursorUtils.registerDataSetObserver(mListDatasetObserver);

        checkAdapter();

        if (!mDecryptionFailed) {
            String dataLeAk296 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk296 = android.util.Log.d("leak-296", dataLeAk296);
			decryptDelayed();
        } else {
            String dataLeAk297 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk297 = android.util.Log.d("leak-297", dataLeAk297);
			// Reset
            mDecryptionFailed = false;
        }

        if (mDecryptionSucceeded) {
            String dataLeAk298 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk298 = android.util.Log.d("leak-298", dataLeAk298);
			NotesListCursor.mLoggedIn = true;
            if (DEBUG) {
                String dataLeAk299 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk299 = android.util.Log.d("leak-299", dataLeAk299);
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
        String dataLeAk300 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk300 = android.util.Log.d("leak-300", dataLeAk300);
		if (mAdapter == null) {
            // Perform a managed query. The Activity will handle closing and
            // requerying the cursor
            // when needed.
            // Cursor cursor = getContentResolver().query(getIntent().getData(),
            // NotesListCursorUtils.PROJECTION, null,
            // null, Notes.DEFAULT_SORT_ORDER);

            String dataLeAk301 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk301 = android.util.Log.d("leak-301", dataLeAk301);
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
                String dataLeAk302 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk302 = android.util.Log.d("leak-302", dataLeAk302);
				Spinner s = (Spinner) findViewById(R.id.tagselection);

                if (s.getSelectedItemPosition() == 0) {
                    String dataLeAk303 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk303 = android.util.Log.d("leak-303", dataLeAk303);
					mSelectedTag = null;
                } else {
                    String dataLeAk304 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk304 = android.util.Log.d("leak-304", dataLeAk304);
					mSelectedTag = (String) s.getSelectedItem();
                }
            }
            updateQuery();
        } else {
            String dataLeAk305 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk305 = android.util.Log.d("leak-305", dataLeAk305);
			mAdapter.getCursor().requery();
        }
    }

    protected void updateQuery() {
        String dataLeAk306 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk306 = android.util.Log.d("leak-306", dataLeAk306);
		if (DEBUG) {
            String dataLeAk307 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk307 = android.util.Log.d("leak-307", dataLeAk307);
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
		String dataLeAk308 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk308 = android.util.Log.d("leak-308", dataLeAk308);

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
            String dataLeAk309 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk309 = android.util.Log.d("leak-309", dataLeAk309);
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
		String dataLeAk310 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk310 = android.util.Log.d("leak-310", dataLeAk310);
        if (DEBUG) {
            String dataLeAk311 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk311 = android.util.Log.d("leak-311", dataLeAk311);
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
		String dataLeAk312 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk312 = android.util.Log.d("leak-312", dataLeAk312);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
		String dataLeAk313 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk313 = android.util.Log.d("leak-313", dataLeAk313);

        outState.putString(BUNDLE_LAST_FILTER, mCursorUtils.mCurrentFilter);
        outState.putString(BUNDLE_LAST_TAG, mSelectedTag);

        if (mContextMenuInfo != null) {
            String dataLeAk314 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk314 = android.util.Log.d("leak-314", dataLeAk314);
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
		String dataLeAk315 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk315 = android.util.Log.d("leak-315", dataLeAk315);

        MenuItem insertItem = menu.add(
                0, MENU_ITEM_INSERT, 0,
                R.string.menu_insert
        );
        insertItem.setShortcut('1', 'i');
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            String dataLeAk316 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk316 = android.util.Log.d("leak-316", dataLeAk316);
			// Icon for holo theme
            insertItem.setIcon(R.drawable.ic_menu_add_note);
        } else {
            String dataLeAk317 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk317 = android.util.Log.d("leak-317", dataLeAk317);
			insertItem.setIcon(android.R.drawable.ic_menu_add);
        }
        // Show the delete icon when there is an actionbar
        if (mActionBarAvailable) {
            String dataLeAk318 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk318 = android.util.Log.d("leak-318", dataLeAk318);
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
            String dataLeAk319 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk319 = android.util.Log.d("leak-319", dataLeAk319);
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
		String dataLeAk320 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk320 = android.util.Log.d("leak-320", dataLeAk320);
        final boolean haveItems = getListAdapter() != null && getListAdapter().getCount() > 0;

        // If there are any notes in the list (which implies that one of
        // them is selected), then we need to generate the actions that
        // can be performed on the current selection. This will be a combination
        // of our own specific actions along with any extensions that can be
        // found.
        if (haveItems) {
            String dataLeAk321 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk321 = android.util.Log.d("leak-321", dataLeAk321);
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
                String dataLeAk322 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk322 = android.util.Log.d("leak-322", dataLeAk322);
				items[0].setShortcut('1', 'e');
            }
        } else {
            String dataLeAk323 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk323 = android.util.Log.d("leak-323", dataLeAk323);
			menu.removeGroup(Menu.CATEGORY_ALTERNATIVE);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk324 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk324 = android.util.Log.d("leak-324", dataLeAk324);
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
        String dataLeAk325 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk325 = android.util.Log.d("leak-325", dataLeAk325);
		// Launch activity to insert a new item
        Intent i = new Intent(Intent.ACTION_INSERT, getIntent().getData());
        i.putExtra(NotepadInternalIntents.EXTRA_TAGS, mSelectedTag);
        startActivity(i);
    }

    private void search() {
        String dataLeAk326 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk326 = android.util.Log.d("leak-326", dataLeAk326);
		onSearchRequested();
    }

    private void openFromSdCard() {

        String dataLeAk327 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk327 = android.util.Log.d("leak-327", dataLeAk327);
		File sdcard = getSdCardPath();
        String directory = sdcard.getAbsolutePath();
        if (!directory.endsWith("/")) {
            String dataLeAk328 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk328 = android.util.Log.d("leak-328", dataLeAk328);
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
        String dataLeAk329 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk329 = android.util.Log.d("leak-329", dataLeAk329);
		AdapterView.AdapterContextMenuInfo info;
        try {
            String dataLeAk330 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk330 = android.util.Log.d("leak-330", dataLeAk330);
			info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        } catch (ClassCastException e) {
            String dataLeAk331 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk331 = android.util.Log.d("leak-331", dataLeAk331);
			Log.e(TAG, "bad menuInfo", e);
            return;
        }

        Cursor cursor = (Cursor) getListAdapter().getItem(info.position);
        if (cursor == null) {
            String dataLeAk332 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk332 = android.util.Log.d("leak-332", dataLeAk332);
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

            String dataLeAk333 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk333 = android.util.Log.d("leak-333", dataLeAk333);
			// Add a menu item to send the note
            menu.add(0, MENU_ITEM_SHARE, 0, R.string.menu_share);

            // Added automatically through manifest:
            // menu.add(0, MENU_ITEM_SAVE, 0, R.string.menu_save_to_sdcard);

            menu.add(0, MENU_ITEM_ENCRYPT, 0, R.string.menu_encrypt);
        } else {
            String dataLeAk334 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk334 = android.util.Log.d("leak-334", dataLeAk334);
			menu.add(0, MENU_ITEM_UNENCRYPT, 0, R.string.menu_undo_encryption);
        }

        // Add a menu item to delete the note
        menu.add(0, MENU_ITEM_DELETE, 0, R.string.menu_delete);

        // Add additional items only if note is not encrypted:

        if (encrypted == 0) {
            String dataLeAk335 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk335 = android.util.Log.d("leak-335", dataLeAk335);
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
        String dataLeAk336 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk336 = android.util.Log.d("leak-336", dataLeAk336);
		try {
            String dataLeAk337 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk337 = android.util.Log.d("leak-337", dataLeAk337);
			mContextMenuInfo = (AdapterView.AdapterContextMenuInfo) item
                    .getMenuInfo();
        } catch (ClassCastException e) {
            String dataLeAk338 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk338 = android.util.Log.d("leak-338", dataLeAk338);
			Log.e(TAG, "bad menuInfo", e);
            return false;
        }

        switch (item.getItemId()) {
            case MENU_ITEM_DELETE: {
                String dataLeAk339 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk339 = android.util.Log.d("leak-339", dataLeAk339);
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
        String dataLeAk340 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk340 = android.util.Log.d("leak-340", dataLeAk340);
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
            String dataLeAk341 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk341 = android.util.Log.d("leak-341", dataLeAk341);
			c.moveToFirst();
            title = c.getString(0);
            content = c.getString(1);
        }

        if (DEBUG) {
            String dataLeAk342 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk342 = android.util.Log.d("leak-342", dataLeAk342);
			Log.i(TAG, "Title to send: " + title);
        }
        if (DEBUG) {
            String dataLeAk343 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk343 = android.util.Log.d("leak-343", dataLeAk343);
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
        String dataLeAk344 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk344 = android.util.Log.d("leak-344", dataLeAk344);
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
            String dataLeAk345 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk345 = android.util.Log.d("leak-345", dataLeAk345);
			c.moveToFirst();
            title = c.getString(0);
            text = c.getString(1);
            tags = c.getString(2);
            encrypted = c.getInt(3);
        }

        if (action.equals(CryptoIntents.ACTION_ENCRYPT) && encrypted != 0) {
            String dataLeAk346 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk346 = android.util.Log.d("leak-346", dataLeAk346);
			Toast.makeText(this, R.string.already_encrypted, Toast.LENGTH_SHORT)
                    .show();
            return;
        }

        if (action.equals(CryptoIntents.ACTION_DECRYPT) && encrypted == 0) {
            String dataLeAk347 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk347 = android.util.Log.d("leak-347", dataLeAk347);
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
        String dataLeAk348 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk348 = android.util.Log.d("leak-348", dataLeAk348);
		showDialog(DIALOG_TAGS);
    }

    private File getSdCardPath() {
        String dataLeAk349 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk349 = android.util.Log.d("leak-349", dataLeAk349);
		return android.os.Environment.getExternalStorageDirectory();
    }

    private void showNotesListSettings() {
        String dataLeAk350 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk350 = android.util.Log.d("leak-350", dataLeAk350);
		startActivity(new Intent(this, PreferenceActivity.class));
    }

    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {
							String dataLeAk351 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk351 = android.util.Log.d("leak-351", dataLeAk351);
    }

    public void onScrollStateChanged(AbsListView view, int scrollState) {
        String dataLeAk352 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk352 = android.util.Log.d("leak-352", dataLeAk352);
		switch (scrollState) {
            case OnScrollListener.SCROLL_STATE_IDLE:
                Log.i(TAG, "idle");
                mAdapter.mBusy = false;

                if (!NotesListCursor.mEncryptedStringList.isEmpty()) {
                    String dataLeAk353 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk353 = android.util.Log.d("leak-353", dataLeAk353);
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
        String dataLeAk354 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk354 = android.util.Log.d("leak-354", dataLeAk354);
		// Poll the next string that has not been decrypted yet.
        String encryptedString = NotesListCursor.getNextEncryptedString();
        if (encryptedString != null) {
            String dataLeAk355 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk355 = android.util.Log.d("leak-355", dataLeAk355);
			setProgressBarIndeterminateVisibility(true);
            decryptDelayed(encryptedString, DECRYPT_DELAY);
        } else if (!mDecryptionFailed && !mDecryptionSucceeded) {
            String dataLeAk356 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk356 = android.util.Log.d("leak-356", dataLeAk356);
			// If neither failed nor succeeded yet, we send a test intent.
            // This is to ensure that the service is still running
            // even if we may serve all decrypted strings from the cache.
            NotesListCursor nlc = (NotesListCursor) mAdapter.getCursor();
            if (nlc.mContainsEncryptedStrings) {
                String dataLeAk357 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk357 = android.util.Log.d("leak-357", dataLeAk357);
				// Of course only if there is at least one encrypted string.
                setProgressBarIndeterminateVisibility(true);
                decryptDelayed(null, 0);
            }
        } else {
            String dataLeAk358 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk358 = android.util.Log.d("leak-358", dataLeAk358);
			// Done with decryption
            setProgressBarIndeterminateVisibility(false);
        }
    }

    public void decryptDelayed(final String encryptedTitle, long delayMillis) {
        String dataLeAk359 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk359 = android.util.Log.d("leak-359", dataLeAk359);
		mHandler.postDelayed(
                new Runnable() {

                    String dataLeAk360 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk360 = android.util.Log.d("leak-360", dataLeAk360);

					public void run() {
                        String dataLeAk361 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk361 = android.util.Log.d("leak-361", dataLeAk361);
						decryptTitle(encryptedTitle);
                    }

                }, delayMillis
        );
    }

    public void decryptTitle(String encryptedTitle) {

        String dataLeAk362 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk362 = android.util.Log.d("leak-362", dataLeAk362);
		Intent intent = new Intent();
        intent.setAction(CryptoIntents.ACTION_DECRYPT);
        if (encryptedTitle != null) {
            String dataLeAk363 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk363 = android.util.Log.d("leak-363", dataLeAk363);
			intent.putExtra(CryptoIntents.EXTRA_TEXT, encryptedTitle);
            intent.putExtra(
                    PrivateNotePadIntents.EXTRA_ENCRYPTED_TEXT,
                    encryptedTitle
            );
        }

        intent.putExtra(CryptoIntents.EXTRA_PROMPT, false);

        try {
            String dataLeAk364 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk364 = android.util.Log.d("leak-364", dataLeAk364);
			if (checkCallingOrSelfPermission(CryptoIntents.PERMISSION_SAFE_ACCESS_INTENTS) == PackageManager.PERMISSION_GRANTED) {
                String dataLeAk365 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk365 = android.util.Log.d("leak-365", dataLeAk365);
				startActivityForResult(intent, REQUEST_CODE_DECRYPT_TITLE);
            } else {
                String dataLeAk366 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk366 = android.util.Log.d("leak-366", dataLeAk366);
				mDecryptionFailed = true;
                showDialog(DIALOG_PERMISSION_FAILURE);
            }
        } catch (ActivityNotFoundException e) {
            String dataLeAk367 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk367 = android.util.Log.d("leak-367", dataLeAk367);
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

        String dataLeAk368 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk368 = android.util.Log.d("leak-368", dataLeAk368);
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

                            String dataLeAk369 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk369 = android.util.Log.d("leak-369", dataLeAk369);

							@Override
                            public void onClick(DialogInterface dialog, int which) {
                                String dataLeAk370 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk370 = android.util.Log.d("leak-370", dataLeAk370);
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
                                    String dataLeAk371 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk371 = android.util.Log.d("leak-371", dataLeAk371);

									@Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        String dataLeAk372 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk372 = android.util.Log.d("leak-372", dataLeAk372);
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
        String dataLeAk373 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk373 = android.util.Log.d("leak-373", dataLeAk373);
		if (DEBUG) {
            String dataLeAk374 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk374 = android.util.Log.d("leak-374", dataLeAk374);
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
        String dataLeAk375 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk375 = android.util.Log.d("leak-375", dataLeAk375);
		if (dialog instanceof TagsDialog) {
            String dataLeAk376 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk376 = android.util.Log.d("leak-376", dataLeAk376);
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
        String dataLeAk377 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk377 = android.util.Log.d("leak-377", dataLeAk377);
		// Create a set of all tags (every tag should only appear once).
        HashSet<String> tagset = new HashSet<String>();
        c.moveToPosition(-1);
        while (c.moveToNext()) {
            String dataLeAk378 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk378 = android.util.Log.d("leak-378", dataLeAk378);
			String tags = c.getString(NotesListCursor.COLUMN_INDEX_TAGS);
            if (tags != null) {
                String dataLeAk379 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk379 = android.util.Log.d("leak-379", dataLeAk379);
				// Split several tags in a line, separated by comma
                String[] smalltaglist = tags.split(",");
                for (String tag : smalltaglist) {
                    String dataLeAk380 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk380 = android.util.Log.d("leak-380", dataLeAk380);
					if (!tag.equals("")) {
                        String dataLeAk381 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk381 = android.util.Log.d("leak-381", dataLeAk381);
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

        String dataLeAk382 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk382 = android.util.Log.d("leak-382", dataLeAk382);
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

            String dataLeAk383 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk383 = android.util.Log.d("leak-383", dataLeAk383);
			Intent intent = new Intent();
            intent.setAction(CryptoIntents.ACTION_DECRYPT);
            intent.putExtra(CryptoIntents.EXTRA_TEXT, encryptedTitle);
            intent.putExtra(
                    PrivateNotePadIntents.EXTRA_ENCRYPTED_TEXT,
                    encryptedTitle
            );

            intent.putExtra(CryptoIntents.EXTRA_PROMPT, true);

            try {
                String dataLeAk384 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk384 = android.util.Log.d("leak-384", dataLeAk384);
				if (checkCallingOrSelfPermission(CryptoIntents.PERMISSION_SAFE_ACCESS_INTENTS) == PackageManager.PERMISSION_GRANTED) {
                    String dataLeAk385 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk385 = android.util.Log.d("leak-385", dataLeAk385);
					startActivityForResult(intent, REQUEST_CODE_DECRYPT_TITLE);
                } else {
                    String dataLeAk386 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk386 = android.util.Log.d("leak-386", dataLeAk386);
					mDecryptionFailed = true;
                    showDialog(DIALOG_PERMISSION_FAILURE);
                    Log.e(TAG, "failed to invoke decrypt due to permissions");
                }
            } catch (ActivityNotFoundException e) {
                String dataLeAk387 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk387 = android.util.Log.d("leak-387", dataLeAk387);
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
            String dataLeAk388 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk388 = android.util.Log.d("leak-388", dataLeAk388);
			// The caller is waiting for us to return a note selected by
            // the user. The have clicked on one, so return it now.
            setResult(RESULT_OK, new Intent().setData(uri));
            finish();
        } else if (Intent.ACTION_CREATE_SHORTCUT.equals(action)) {
            String dataLeAk389 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk389 = android.util.Log.d("leak-389", dataLeAk389);
			Intent data = new Intent(Intent.ACTION_VIEW);
            data.setData(uri);

            String useTitle = title;
            if (encrypted != 0) {
                String dataLeAk390 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk390 = android.util.Log.d("leak-390", dataLeAk390);
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
            String dataLeAk391 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk391 = android.util.Log.d("leak-391", dataLeAk391);
			// Launch activity to view/edit the currently selected item
            startActivity(new Intent(Intent.ACTION_EDIT, uri));
        }
    }

    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent intent) {
        String dataLeAk392 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk392 = android.util.Log.d("leak-392", dataLeAk392);
		if (DEBUG) {
            String dataLeAk393 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk393 = android.util.Log.d("leak-393", dataLeAk393);
			Log.i(
                    TAG, "Received requestCode " + requestCode + ", resultCode "
                            + resultCode
            );
        }
        switch (requestCode) {
            case REQUEST_CODE_DECRYPT_TITLE:
                if (resultCode == RESULT_OK && intent != null) {
                    String dataLeAk394 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk394 = android.util.Log.d("leak-394", dataLeAk394);
					String decryptedText = intent
                            .getStringExtra(CryptoIntents.EXTRA_TEXT);
                    String encryptedText = intent
                            .getStringExtra(PrivateNotePadIntents.EXTRA_ENCRYPTED_TEXT);

                    if (encryptedText != null) {
                        // Log.i(TAG, "Encrypted text is not passed properly.");
                        // return;

                        String dataLeAk395 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk395 = android.util.Log.d("leak-395", dataLeAk395);
						// Add decrypted text to hash:
                        NotesListCursor.mEncryptedStringHashMap.put(
                                encryptedText,
                                decryptedText
                        );

                        if (DEBUG) {
                            String dataLeAk396 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk396 = android.util.Log.d("leak-396", dataLeAk396);
							Log.i(
                                    TAG, "Decrypted: " + encryptedText + " -> "
                                            + decryptedText
                            );
                        }
                    }
                    mDecryptionSucceeded = true;
                    NotesListCursor.mLoggedIn = true;
                    if (DEBUG) {
                        String dataLeAk397 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk397 = android.util.Log.d("leak-397", dataLeAk397);
						Log.d(TAG, "onActivity: logged in");
                    }

                    // decrypt the next string.

                    decryptDelayed();

                } else {
                    String dataLeAk398 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk398 = android.util.Log.d("leak-398", dataLeAk398);
					mDecryptionFailed = true;
                    setProgressBarIndeterminateVisibility(false);
                }
                break;
            case REQUEST_CODE_OPEN:
                if (resultCode == RESULT_OK && intent != null) {
                    String dataLeAk399 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk399 = android.util.Log.d("leak-399", dataLeAk399);
					// File name should be in Uri:
                    File filename = FileUriUtils.getFile(intent.getData());

                    if (filename.exists() && !filename.isDirectory()) {
                        String dataLeAk400 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk400 = android.util.Log.d("leak-400", dataLeAk400);
						// Open file in note editor
                        Intent i = new Intent(this, NoteEditor.class);
                        i.setAction(Intent.ACTION_VIEW);
                        i.setData(intent.getData());
                        startActivity(i);
                    } else {
                        String dataLeAk401 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk401 = android.util.Log.d("leak-401", dataLeAk401);
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
        String dataLeAk402 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk402 = android.util.Log.d("leak-402", dataLeAk402);
		if (DEBUG) {
            String dataLeAk403 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk403 = android.util.Log.d("leak-403", dataLeAk403);
			Log.i(TAG, "Saving file: uri: " + uri + ", file: " + file);
        }
        Cursor c = getContentResolver().query(
                uri,
                new String[]{Notes.ENCRYPTED, Notes.NOTE}, null, null, null
        );

        if (c != null && c.getCount() > 0) {
            String dataLeAk404 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk404 = android.util.Log.d("leak-404", dataLeAk404);
			c.moveToFirst();
            long encrypted = c.getLong(0);
            String note = c.getString(1);
            if (encrypted == 0) {
                String dataLeAk405 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk405 = android.util.Log.d("leak-405", dataLeAk405);
				// Save to file
                if (DEBUG) {
                    String dataLeAk406 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk406 = android.util.Log.d("leak-406", dataLeAk406);
					Log.d(TAG, "Save unencrypted file.");
                }
                writeToFile(file, note);
            } else {
                // decrypt first, then save to file

                String dataLeAk407 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk407 = android.util.Log.d("leak-407", dataLeAk407);
				if (DEBUG) {
                    String dataLeAk408 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk408 = android.util.Log.d("leak-408", dataLeAk408);
					Log.d(TAG, "Save encrypted file.");
                }
            }
        } else {
            String dataLeAk409 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk409 = android.util.Log.d("leak-409", dataLeAk409);
			Log.e(TAG, "Error saving file: Uri not valid: " + uri);
        }
    }

    void writeToFile(File file, String text) {
        String dataLeAk410 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk410 = android.util.Log.d("leak-410", dataLeAk410);
		try {
            String dataLeAk411 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk411 = android.util.Log.d("leak-411", dataLeAk411);
			FileWriter fstream = new FileWriter(file);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(text);
            out.close();
            Toast.makeText(this, R.string.note_saved, Toast.LENGTH_SHORT)
                    .show();
        } catch (IOException e) {
            String dataLeAk412 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk412 = android.util.Log.d("leak-412", dataLeAk412);
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
