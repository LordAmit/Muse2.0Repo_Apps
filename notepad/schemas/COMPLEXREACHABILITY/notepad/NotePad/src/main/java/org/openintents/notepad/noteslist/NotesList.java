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
        String dataLeAk237 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP237 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP237.put("test", new java.util.HashMap<String, String>());
		leakMaP237.get("test").put("test", dataLeAk237);
		String dataLeAkPath237 = leakMaP237.get("test").get("test");
		android.util.Log.d("leak-237", dataLeAkPath237);
		try {
            String dataLeAk238 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer238 = new StringBuffer();for (char chAr238 : dataLeAk238.toCharArray()) {leakBuFFer238.append(chAr238);}String dataLeAkPath238 = leakBuFFer238.toString();
			android.util.Log.d("leak-238", dataLeAkPath238);
			WrapActionBar.checkAvailable();
            mActionBarAvailable = true;
        } catch (Throwable t) {
            String dataLeAk239 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath239;try {throw new Exception(dataLeAk239);} catch (Exception leakErRor239) {dataLeAkPath239 = leakErRor239.getMessage();}
			android.util.Log.d("leak-239", dataLeAkPath239);
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
            String dataLeAk240 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay240 = new String[] {"n/a", dataLeAk240};
			String dataLeAkPath240 = leakArRay240[leakArRay240.length - 1];
			android.util.Log.d("leak-240", dataLeAkPath240);
			if (DEBUG) {
                String dataLeAk241 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP241 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP241.put("test", new java.util.HashMap<String, String>());
				leakMaP241.get("test").put("test", dataLeAk241);
				String dataLeAkPath241 = leakMaP241.get("test").get("test");
				android.util.Log.d("leak-241", dataLeAkPath241);
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
		String dataLeAk242 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer242 = new StringBuffer();for (char chAr242 : dataLeAk242.toCharArray()) {leakBuFFer242.append(chAr242);}String dataLeAkPath242 = leakBuFFer242.toString();
		android.util.Log.d("leak-242", dataLeAkPath242);

        if (DEBUG) {
            String dataLeAk243 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath243;try {throw new Exception(dataLeAk243);} catch (Exception leakErRor243) {dataLeAkPath243 = leakErRor243.getMessage();}
			android.util.Log.d("leak-243", dataLeAkPath243);
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
            String dataLeAk244 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay244 = new String[] {"n/a", dataLeAk244};
			String dataLeAkPath244 = leakArRay244[leakArRay244.length - 1];
			android.util.Log.d("leak-244", dataLeAkPath244);
			return;
        }

        setDefaultKeyMode(DEFAULT_KEYS_SHORTCUT);

        // If no data was given in the intent (because we were started
        // as a MAIN activity), then use our default content provider.
        Intent intent = getIntent();
        if (intent.getData() == null) {
            String dataLeAk245 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP245 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP245.put("test", new java.util.HashMap<String, String>());
			leakMaP245.get("test").put("test", dataLeAk245);
			String dataLeAkPath245 = leakMaP245.get("test").get("test");
			android.util.Log.d("leak-245", dataLeAkPath245);
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
            String dataLeAk246 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer246 = new StringBuffer();for (char chAr246 : dataLeAk246.toCharArray()) {leakBuFFer246.append(chAr246);}String dataLeAkPath246 = leakBuFFer246.toString();
			android.util.Log.d("leak-246", dataLeAkPath246);
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
            String dataLeAk247 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath247;try {throw new Exception(dataLeAk247);} catch (Exception leakErRor247) {dataLeAkPath247 = leakErRor247.getMessage();}
			android.util.Log.d("leak-247", dataLeAkPath247);
			mLastFilter = savedInstanceState.getString(BUNDLE_LAST_FILTER);
            if (mSelectedTag == null) {
                String dataLeAk248 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay248 = new String[] {"n/a", dataLeAk248};
				String dataLeAkPath248 = leakArRay248[leakArRay248.length - 1];
				android.util.Log.d("leak-248", dataLeAkPath248);
				mSelectedTag = savedInstanceState.getString(BUNDLE_LAST_TAG);
            }

            // Restore information for context menu, for opening "Tags" dialog.
            if (savedInstanceState.containsKey(BUNDLE_CONTEXTMENUINFO_ID)) {
                String dataLeAk249 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP249 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP249.put("test", new java.util.HashMap<String, String>());
				leakMaP249.get("test").put("test", dataLeAk249);
				String dataLeAkPath249 = leakMaP249.get("test").get("test");
				android.util.Log.d("leak-249", dataLeAkPath249);
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
            String dataLeAk250 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer250 = new StringBuffer();for (char chAr250 : dataLeAk250.toCharArray()) {leakBuFFer250.append(chAr250);}String dataLeAkPath250 = leakBuFFer250.toString();
			android.util.Log.d("leak-250", dataLeAkPath250);
			SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
            String savedTag = settings.getString(BUNDLE_LAST_TAG, "");
            if (!savedTag.equals("")) {
                String dataLeAk251 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath251;try {throw new Exception(dataLeAk251);} catch (Exception leakErRor251) {dataLeAkPath251 = leakErRor251.getMessage();}
				android.util.Log.d("leak-251", dataLeAkPath251);
				mSelectedTag = savedTag;
            }
        }

        mCursorUtils = new NotesListCursor(this, getIntent());

        // Make sure mAdapter is created here already,
        // because onPrepareDialog for the Tags dialog may be called
        // before onResume() is called.
        checkAdapter();

        if (Intent.ACTION_CREATE_SHORTCUT.equals(intent.getAction())) {
            String dataLeAk252 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay252 = new String[] {"n/a", dataLeAk252};
			String dataLeAkPath252 = leakArRay252[leakArRay252.length - 1];
			android.util.Log.d("leak-252", dataLeAkPath252);
			setTitle(R.string.title_pick_note_for_shortcut);
        }

        updateTagList();

        Cursor cur = mAdapter.runQueryOnBackgroundThread(null, null);

        cur.registerDataSetObserver(
                new DataSetObserver() {
                    @Override
                    public void onChanged() {
                        String dataLeAk253 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP253 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP253.put("test", new java.util.HashMap<String, String>());
						leakMaP253.get("test").put("test", dataLeAk253);
						String dataLeAkPath253 = leakMaP253.get("test").get("test");
						android.util.Log.d("leak-253", dataLeAkPath253);
						NotesList.this.updateTagList();
                    }
                }
        );

        Spinner s = (Spinner) findViewById(R.id.tagselection);
        s.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    public void onItemSelected(AdapterView<?> parent, View view,
                                               int position, long id) {
                        String dataLeAk254 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
												StringBuffer leakBuFFer254 = new StringBuffer();for (char chAr254 : dataLeAk254.toCharArray()) {leakBuFFer254.append(chAr254);}String dataLeAkPath254 = leakBuFFer254.toString();
												android.util.Log.d("leak-254", dataLeAkPath254);
						if (position == 0) {
                            String dataLeAk255 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath255;try {throw new Exception(dataLeAk255);} catch (Exception leakErRor255) {dataLeAkPath255 = leakErRor255.getMessage();}
							android.util.Log.d("leak-255", dataLeAkPath255);
							mSelectedTag = null;
                        } else {
                            String dataLeAk256 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay256 = new String[] {"n/a", dataLeAk256};
							String dataLeAkPath256 = leakArRay256[leakArRay256.length - 1];
							android.util.Log.d("leak-256", dataLeAkPath256);
							mSelectedTag = parent.getItemAtPosition(position).toString();
                        }
                        NotesList.this.updateQuery();
                        decryptDelayed();
                    }

                    public void onNothingSelected(AdapterView<?> arg0) {
						String dataLeAk257 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP257 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP257.put("test", new java.util.HashMap<String, String>());
						leakMaP257.get("test").put("test", dataLeAk257);
						String dataLeAkPath257 = leakMaP257.get("test").get("test");
						android.util.Log.d("leak-257", dataLeAkPath257);

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

        String dataLeAk258 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer258 = new StringBuffer();for (char chAr258 : dataLeAk258.toCharArray()) {leakBuFFer258.append(chAr258);}String dataLeAkPath258 = leakBuFFer258.toString();
		android.util.Log.d("leak-258", dataLeAkPath258);
		List<String> taglist = new ArrayList<String>();

        Uri notesUri = getIntent().getData();

        Cursor managedCursor = getContentResolver().query(
                notesUri,
                new String[]{Notes.TAGS, Notes.ENCRYPTED}, null, null, null
        );

        if (managedCursor.moveToFirst()) {
            String dataLeAk259 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath259;try {throw new Exception(dataLeAk259);} catch (Exception leakErRor259) {dataLeAkPath259 = leakErRor259.getMessage();}
			android.util.Log.d("leak-259", dataLeAkPath259);
			do {
                String dataLeAk260 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay260 = new String[] {"n/a", dataLeAk260};
				String dataLeAkPath260 = leakArRay260[leakArRay260.length - 1];
				android.util.Log.d("leak-260", dataLeAkPath260);
				String tags = managedCursor.getString(0);
                long encrypted = managedCursor.getLong(1);

                if (!TextUtils.isEmpty(tags)) {
                    String dataLeAk261 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP261 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP261.put("test", new java.util.HashMap<String, String>());
					leakMaP261.get("test").put("test", dataLeAk261);
					String dataLeAkPath261 = leakMaP261.get("test").get("test");
					android.util.Log.d("leak-261", dataLeAkPath261);
					if (encrypted == 0) {
                        String dataLeAk262 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer262 = new StringBuffer();for (char chAr262 : dataLeAk262.toCharArray()) {leakBuFFer262.append(chAr262);}String dataLeAkPath262 = leakBuFFer262.toString();
						android.util.Log.d("leak-262", dataLeAkPath262);
						for (String tag : tags.split(",")) {
                            String dataLeAk263 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath263;try {throw new Exception(dataLeAk263);} catch (Exception leakErRor263) {dataLeAkPath263 = leakErRor263.getMessage();}
							android.util.Log.d("leak-263", dataLeAkPath263);
							if (!taglist.contains(tag.trim())) {
                                String dataLeAk264 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String[] leakArRay264 = new String[] {"n/a", dataLeAk264};
								String dataLeAkPath264 = leakArRay264[leakArRay264.length - 1];
								android.util.Log.d("leak-264", dataLeAkPath264);
								taglist.add(tag.trim());
                            }
                        }
                    } else {
						String dataLeAk265 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP265 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP265.put("test", new java.util.HashMap<String, String>());
						leakMaP265.get("test").put("test", dataLeAk265);
						String dataLeAkPath265 = leakMaP265.get("test").get("test");
						android.util.Log.d("leak-265", dataLeAkPath265);
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
            String dataLeAk266 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer266 = new StringBuffer();for (char chAr266 : dataLeAk266.toCharArray()) {leakBuFFer266.append(chAr266);}String dataLeAkPath266 = leakBuFFer266.toString();
			android.util.Log.d("leak-266", dataLeAkPath266);
			s.setSelection(position);
        }

        // Hide Spinner if there are no tags
        if (taglist.size() > 1) {
            String dataLeAk267 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath267;try {throw new Exception(dataLeAk267);} catch (Exception leakErRor267) {dataLeAkPath267 = leakErRor267.getMessage();}
			android.util.Log.d("leak-267", dataLeAkPath267);
			s.setVisibility(View.VISIBLE);
        } else {
            String dataLeAk268 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay268 = new String[] {"n/a", dataLeAk268};
			String dataLeAkPath268 = leakArRay268[leakArRay268.length - 1];
			android.util.Log.d("leak-268", dataLeAkPath268);
			s.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
		String dataLeAk269 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP269 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP269.put("test", new java.util.HashMap<String, String>());
		leakMaP269.get("test").put("test", dataLeAk269);
		String dataLeAkPath269 = leakMaP269.get("test").get("test");
		android.util.Log.d("leak-269", dataLeAkPath269);
        if (DEBUG) {
            String dataLeAk270 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer270 = new StringBuffer();for (char chAr270 : dataLeAk270.toCharArray()) {leakBuFFer270.append(chAr270);}String dataLeAkPath270 = leakBuFFer270.toString();
			android.util.Log.d("leak-270", dataLeAkPath270);
			Log.d(TAG, "onResume()");
        }
        NotesListCursor.mSuspendQueries = false;

        // mCursorUtils.registerContentObserver(mListContentObserver);
        // mCursorUtils.registerDataSetObserver(mListDatasetObserver);

        checkAdapter();

        if (!mDecryptionFailed) {
            String dataLeAk271 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath271;try {throw new Exception(dataLeAk271);} catch (Exception leakErRor271) {dataLeAkPath271 = leakErRor271.getMessage();}
			android.util.Log.d("leak-271", dataLeAkPath271);
			decryptDelayed();
        } else {
            String dataLeAk272 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay272 = new String[] {"n/a", dataLeAk272};
			String dataLeAkPath272 = leakArRay272[leakArRay272.length - 1];
			android.util.Log.d("leak-272", dataLeAkPath272);
			// Reset
            mDecryptionFailed = false;
        }

        if (mDecryptionSucceeded) {
            String dataLeAk273 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP273 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP273.put("test", new java.util.HashMap<String, String>());
			leakMaP273.get("test").put("test", dataLeAk273);
			String dataLeAkPath273 = leakMaP273.get("test").get("test");
			android.util.Log.d("leak-273", dataLeAkPath273);
			NotesListCursor.mLoggedIn = true;
            if (DEBUG) {
                String dataLeAk274 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer274 = new StringBuffer();for (char chAr274 : dataLeAk274.toCharArray()) {leakBuFFer274.append(chAr274);}String dataLeAkPath274 = leakBuFFer274.toString();
				android.util.Log.d("leak-274", dataLeAkPath274);
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
        String dataLeAk275 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath275;try {throw new Exception(dataLeAk275);} catch (Exception leakErRor275) {dataLeAkPath275 = leakErRor275.getMessage();}
		android.util.Log.d("leak-275", dataLeAkPath275);
		if (mAdapter == null) {
            // Perform a managed query. The Activity will handle closing and
            // requerying the cursor
            // when needed.
            // Cursor cursor = getContentResolver().query(getIntent().getData(),
            // NotesListCursorUtils.PROJECTION, null,
            // null, Notes.DEFAULT_SORT_ORDER);

            String dataLeAk276 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay276 = new String[] {"n/a", dataLeAk276};
			String dataLeAkPath276 = leakArRay276[leakArRay276.length - 1];
			android.util.Log.d("leak-276", dataLeAkPath276);
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
                String dataLeAk277 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP277 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP277.put("test", new java.util.HashMap<String, String>());
				leakMaP277.get("test").put("test", dataLeAk277);
				String dataLeAkPath277 = leakMaP277.get("test").get("test");
				android.util.Log.d("leak-277", dataLeAkPath277);
				Spinner s = (Spinner) findViewById(R.id.tagselection);

                if (s.getSelectedItemPosition() == 0) {
                    String dataLeAk278 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer278 = new StringBuffer();for (char chAr278 : dataLeAk278.toCharArray()) {leakBuFFer278.append(chAr278);}String dataLeAkPath278 = leakBuFFer278.toString();
					android.util.Log.d("leak-278", dataLeAkPath278);
					mSelectedTag = null;
                } else {
                    String dataLeAk279 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath279;try {throw new Exception(dataLeAk279);} catch (Exception leakErRor279) {dataLeAkPath279 = leakErRor279.getMessage();}
					android.util.Log.d("leak-279", dataLeAkPath279);
					mSelectedTag = (String) s.getSelectedItem();
                }
            }
            updateQuery();
        } else {
            String dataLeAk280 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay280 = new String[] {"n/a", dataLeAk280};
			String dataLeAkPath280 = leakArRay280[leakArRay280.length - 1];
			android.util.Log.d("leak-280", dataLeAkPath280);
			mAdapter.getCursor().requery();
        }
    }

    protected void updateQuery() {
        String dataLeAk281 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP281 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP281.put("test", new java.util.HashMap<String, String>());
		leakMaP281.get("test").put("test", dataLeAk281);
		String dataLeAkPath281 = leakMaP281.get("test").get("test");
		android.util.Log.d("leak-281", dataLeAkPath281);
		if (DEBUG) {
            String dataLeAk282 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer282 = new StringBuffer();for (char chAr282 : dataLeAk282.toCharArray()) {leakBuFFer282.append(chAr282);}String dataLeAkPath282 = leakBuFFer282.toString();
			android.util.Log.d("leak-282", dataLeAkPath282);
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
		String dataLeAk283 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath283;try {throw new Exception(dataLeAk283);} catch (Exception leakErRor283) {dataLeAkPath283 = leakErRor283.getMessage();}
		android.util.Log.d("leak-283", dataLeAkPath283);

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
            String dataLeAk284 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay284 = new String[] {"n/a", dataLeAk284};
			String dataLeAkPath284 = leakArRay284[leakArRay284.length - 1];
			android.util.Log.d("leak-284", dataLeAkPath284);
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
		String dataLeAk285 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP285 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP285.put("test", new java.util.HashMap<String, String>());
		leakMaP285.get("test").put("test", dataLeAk285);
		String dataLeAkPath285 = leakMaP285.get("test").get("test");
		android.util.Log.d("leak-285", dataLeAkPath285);
        if (DEBUG) {
            String dataLeAk286 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer286 = new StringBuffer();for (char chAr286 : dataLeAk286.toCharArray()) {leakBuFFer286.append(chAr286);}String dataLeAkPath286 = leakBuFFer286.toString();
			android.util.Log.d("leak-286", dataLeAkPath286);
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
		String dataLeAk287 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath287;try {throw new Exception(dataLeAk287);} catch (Exception leakErRor287) {dataLeAkPath287 = leakErRor287.getMessage();}
		android.util.Log.d("leak-287", dataLeAkPath287);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
		String dataLeAk288 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay288 = new String[] {"n/a", dataLeAk288};
		String dataLeAkPath288 = leakArRay288[leakArRay288.length - 1];
		android.util.Log.d("leak-288", dataLeAkPath288);

        outState.putString(BUNDLE_LAST_FILTER, mCursorUtils.mCurrentFilter);
        outState.putString(BUNDLE_LAST_TAG, mSelectedTag);

        if (mContextMenuInfo != null) {
            String dataLeAk289 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP289 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP289.put("test", new java.util.HashMap<String, String>());
			leakMaP289.get("test").put("test", dataLeAk289);
			String dataLeAkPath289 = leakMaP289.get("test").get("test");
			android.util.Log.d("leak-289", dataLeAkPath289);
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
		String dataLeAk290 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer290 = new StringBuffer();for (char chAr290 : dataLeAk290.toCharArray()) {leakBuFFer290.append(chAr290);}String dataLeAkPath290 = leakBuFFer290.toString();
		android.util.Log.d("leak-290", dataLeAkPath290);

        MenuItem insertItem = menu.add(
                0, MENU_ITEM_INSERT, 0,
                R.string.menu_insert
        );
        insertItem.setShortcut('1', 'i');
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            String dataLeAk291 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath291;try {throw new Exception(dataLeAk291);} catch (Exception leakErRor291) {dataLeAkPath291 = leakErRor291.getMessage();}
			android.util.Log.d("leak-291", dataLeAkPath291);
			// Icon for holo theme
            insertItem.setIcon(R.drawable.ic_menu_add_note);
        } else {
            String dataLeAk292 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay292 = new String[] {"n/a", dataLeAk292};
			String dataLeAkPath292 = leakArRay292[leakArRay292.length - 1];
			android.util.Log.d("leak-292", dataLeAkPath292);
			insertItem.setIcon(android.R.drawable.ic_menu_add);
        }
        // Show the delete icon when there is an actionbar
        if (mActionBarAvailable) {
            String dataLeAk293 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP293 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP293.put("test", new java.util.HashMap<String, String>());
			leakMaP293.get("test").put("test", dataLeAk293);
			String dataLeAkPath293 = leakMaP293.get("test").get("test");
			android.util.Log.d("leak-293", dataLeAkPath293);
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
            String dataLeAk294 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer294 = new StringBuffer();for (char chAr294 : dataLeAk294.toCharArray()) {leakBuFFer294.append(chAr294);}String dataLeAkPath294 = leakBuFFer294.toString();
			android.util.Log.d("leak-294", dataLeAkPath294);
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
		String dataLeAk295 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath295;try {throw new Exception(dataLeAk295);} catch (Exception leakErRor295) {dataLeAkPath295 = leakErRor295.getMessage();}
		android.util.Log.d("leak-295", dataLeAkPath295);
        final boolean haveItems = getListAdapter() != null && getListAdapter().getCount() > 0;

        // If there are any notes in the list (which implies that one of
        // them is selected), then we need to generate the actions that
        // can be performed on the current selection. This will be a combination
        // of our own specific actions along with any extensions that can be
        // found.
        if (haveItems) {
            String dataLeAk296 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay296 = new String[] {"n/a", dataLeAk296};
			String dataLeAkPath296 = leakArRay296[leakArRay296.length - 1];
			android.util.Log.d("leak-296", dataLeAkPath296);
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
                String dataLeAk297 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP297 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP297.put("test", new java.util.HashMap<String, String>());
				leakMaP297.get("test").put("test", dataLeAk297);
				String dataLeAkPath297 = leakMaP297.get("test").get("test");
				android.util.Log.d("leak-297", dataLeAkPath297);
				items[0].setShortcut('1', 'e');
            }
        } else {
            String dataLeAk298 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer298 = new StringBuffer();for (char chAr298 : dataLeAk298.toCharArray()) {leakBuFFer298.append(chAr298);}String dataLeAkPath298 = leakBuFFer298.toString();
			android.util.Log.d("leak-298", dataLeAkPath298);
			menu.removeGroup(Menu.CATEGORY_ALTERNATIVE);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk299 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath299;try {throw new Exception(dataLeAk299);} catch (Exception leakErRor299) {dataLeAkPath299 = leakErRor299.getMessage();}
		android.util.Log.d("leak-299", dataLeAkPath299);
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
        String dataLeAk300 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay300 = new String[] {"n/a", dataLeAk300};
		String dataLeAkPath300 = leakArRay300[leakArRay300.length - 1];
		android.util.Log.d("leak-300", dataLeAkPath300);
		// Launch activity to insert a new item
        Intent i = new Intent(Intent.ACTION_INSERT, getIntent().getData());
        i.putExtra(NotepadInternalIntents.EXTRA_TAGS, mSelectedTag);
        startActivity(i);
    }

    private void search() {
        String dataLeAk301 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP301 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP301.put("test", new java.util.HashMap<String, String>());
		leakMaP301.get("test").put("test", dataLeAk301);
		String dataLeAkPath301 = leakMaP301.get("test").get("test");
		android.util.Log.d("leak-301", dataLeAkPath301);
		onSearchRequested();
    }

    private void openFromSdCard() {

        String dataLeAk302 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer302 = new StringBuffer();for (char chAr302 : dataLeAk302.toCharArray()) {leakBuFFer302.append(chAr302);}String dataLeAkPath302 = leakBuFFer302.toString();
		android.util.Log.d("leak-302", dataLeAkPath302);
		File sdcard = getSdCardPath();
        String directory = sdcard.getAbsolutePath();
        if (!directory.endsWith("/")) {
            String dataLeAk303 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath303;try {throw new Exception(dataLeAk303);} catch (Exception leakErRor303) {dataLeAkPath303 = leakErRor303.getMessage();}
			android.util.Log.d("leak-303", dataLeAkPath303);
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
        String dataLeAk304 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										String[] leakArRay304 = new String[] {"n/a", dataLeAk304};
										String dataLeAkPath304 = leakArRay304[leakArRay304.length - 1];
										android.util.Log.d("leak-304", dataLeAkPath304);
		AdapterView.AdapterContextMenuInfo info;
        try {
            String dataLeAk305 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP305 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP305.put("test", new java.util.HashMap<String, String>());
			leakMaP305.get("test").put("test", dataLeAk305);
			String dataLeAkPath305 = leakMaP305.get("test").get("test");
			android.util.Log.d("leak-305", dataLeAkPath305);
			info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        } catch (ClassCastException e) {
            String dataLeAk306 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer306 = new StringBuffer();for (char chAr306 : dataLeAk306.toCharArray()) {leakBuFFer306.append(chAr306);}String dataLeAkPath306 = leakBuFFer306.toString();
			android.util.Log.d("leak-306", dataLeAkPath306);
			Log.e(TAG, "bad menuInfo", e);
            return;
        }

        Cursor cursor = (Cursor) getListAdapter().getItem(info.position);
        if (cursor == null) {
            String dataLeAk307 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath307;try {throw new Exception(dataLeAk307);} catch (Exception leakErRor307) {dataLeAkPath307 = leakErRor307.getMessage();}
			android.util.Log.d("leak-307", dataLeAkPath307);
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

            String dataLeAk308 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay308 = new String[] {"n/a", dataLeAk308};
			String dataLeAkPath308 = leakArRay308[leakArRay308.length - 1];
			android.util.Log.d("leak-308", dataLeAkPath308);
			// Add a menu item to send the note
            menu.add(0, MENU_ITEM_SHARE, 0, R.string.menu_share);

            // Added automatically through manifest:
            // menu.add(0, MENU_ITEM_SAVE, 0, R.string.menu_save_to_sdcard);

            menu.add(0, MENU_ITEM_ENCRYPT, 0, R.string.menu_encrypt);
        } else {
            String dataLeAk309 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP309 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP309.put("test", new java.util.HashMap<String, String>());
			leakMaP309.get("test").put("test", dataLeAk309);
			String dataLeAkPath309 = leakMaP309.get("test").get("test");
			android.util.Log.d("leak-309", dataLeAkPath309);
			menu.add(0, MENU_ITEM_UNENCRYPT, 0, R.string.menu_undo_encryption);
        }

        // Add a menu item to delete the note
        menu.add(0, MENU_ITEM_DELETE, 0, R.string.menu_delete);

        // Add additional items only if note is not encrypted:

        if (encrypted == 0) {
            String dataLeAk310 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer310 = new StringBuffer();for (char chAr310 : dataLeAk310.toCharArray()) {leakBuFFer310.append(chAr310);}String dataLeAkPath310 = leakBuFFer310.toString();
			android.util.Log.d("leak-310", dataLeAkPath310);
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
        String dataLeAk311 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath311;try {throw new Exception(dataLeAk311);} catch (Exception leakErRor311) {dataLeAkPath311 = leakErRor311.getMessage();}
		android.util.Log.d("leak-311", dataLeAkPath311);
		try {
            String dataLeAk312 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay312 = new String[] {"n/a", dataLeAk312};
			String dataLeAkPath312 = leakArRay312[leakArRay312.length - 1];
			android.util.Log.d("leak-312", dataLeAkPath312);
			mContextMenuInfo = (AdapterView.AdapterContextMenuInfo) item
                    .getMenuInfo();
        } catch (ClassCastException e) {
            String dataLeAk313 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP313 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP313.put("test", new java.util.HashMap<String, String>());
			leakMaP313.get("test").put("test", dataLeAk313);
			String dataLeAkPath313 = leakMaP313.get("test").get("test");
			android.util.Log.d("leak-313", dataLeAkPath313);
			Log.e(TAG, "bad menuInfo", e);
            return false;
        }

        switch (item.getItemId()) {
            case MENU_ITEM_DELETE: {
                String dataLeAk314 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer314 = new StringBuffer();for (char chAr314 : dataLeAk314.toCharArray()) {leakBuFFer314.append(chAr314);}String dataLeAkPath314 = leakBuFFer314.toString();
				android.util.Log.d("leak-314", dataLeAkPath314);
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
        String dataLeAk315 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath315;try {throw new Exception(dataLeAk315);} catch (Exception leakErRor315) {dataLeAkPath315 = leakErRor315.getMessage();}
		android.util.Log.d("leak-315", dataLeAkPath315);
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
            String dataLeAk316 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay316 = new String[] {"n/a", dataLeAk316};
			String dataLeAkPath316 = leakArRay316[leakArRay316.length - 1];
			android.util.Log.d("leak-316", dataLeAkPath316);
			c.moveToFirst();
            title = c.getString(0);
            content = c.getString(1);
        }

        if (DEBUG) {
            String dataLeAk317 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP317 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP317.put("test", new java.util.HashMap<String, String>());
			leakMaP317.get("test").put("test", dataLeAk317);
			String dataLeAkPath317 = leakMaP317.get("test").get("test");
			android.util.Log.d("leak-317", dataLeAkPath317);
			Log.i(TAG, "Title to send: " + title);
        }
        if (DEBUG) {
            String dataLeAk318 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer318 = new StringBuffer();for (char chAr318 : dataLeAk318.toCharArray()) {leakBuFFer318.append(chAr318);}String dataLeAkPath318 = leakBuFFer318.toString();
			android.util.Log.d("leak-318", dataLeAkPath318);
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
        String dataLeAk319 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath319;try {throw new Exception(dataLeAk319);} catch (Exception leakErRor319) {dataLeAkPath319 = leakErRor319.getMessage();}
		android.util.Log.d("leak-319", dataLeAkPath319);
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
            String dataLeAk320 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay320 = new String[] {"n/a", dataLeAk320};
			String dataLeAkPath320 = leakArRay320[leakArRay320.length - 1];
			android.util.Log.d("leak-320", dataLeAkPath320);
			c.moveToFirst();
            title = c.getString(0);
            text = c.getString(1);
            tags = c.getString(2);
            encrypted = c.getInt(3);
        }

        if (action.equals(CryptoIntents.ACTION_ENCRYPT) && encrypted != 0) {
            String dataLeAk321 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP321 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP321.put("test", new java.util.HashMap<String, String>());
			leakMaP321.get("test").put("test", dataLeAk321);
			String dataLeAkPath321 = leakMaP321.get("test").get("test");
			android.util.Log.d("leak-321", dataLeAkPath321);
			Toast.makeText(this, R.string.already_encrypted, Toast.LENGTH_SHORT)
                    .show();
            return;
        }

        if (action.equals(CryptoIntents.ACTION_DECRYPT) && encrypted == 0) {
            String dataLeAk322 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer322 = new StringBuffer();for (char chAr322 : dataLeAk322.toCharArray()) {leakBuFFer322.append(chAr322);}String dataLeAkPath322 = leakBuFFer322.toString();
			android.util.Log.d("leak-322", dataLeAkPath322);
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
        String dataLeAk323 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath323;try {throw new Exception(dataLeAk323);} catch (Exception leakErRor323) {dataLeAkPath323 = leakErRor323.getMessage();}
		android.util.Log.d("leak-323", dataLeAkPath323);
		showDialog(DIALOG_TAGS);
    }

    private File getSdCardPath() {
        String dataLeAk324 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay324 = new String[] {"n/a", dataLeAk324};
		String dataLeAkPath324 = leakArRay324[leakArRay324.length - 1];
		android.util.Log.d("leak-324", dataLeAkPath324);
		return android.os.Environment.getExternalStorageDirectory();
    }

    private void showNotesListSettings() {
        String dataLeAk325 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP325 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP325.put("test", new java.util.HashMap<String, String>());
		leakMaP325.get("test").put("test", dataLeAk325);
		String dataLeAkPath325 = leakMaP325.get("test").get("test");
		android.util.Log.d("leak-325", dataLeAkPath325);
		startActivity(new Intent(this, PreferenceActivity.class));
    }

    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {
							String dataLeAk326 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer326 = new StringBuffer();for (char chAr326 : dataLeAk326.toCharArray()) {leakBuFFer326.append(chAr326);}String dataLeAkPath326 = leakBuFFer326.toString();
							android.util.Log.d("leak-326", dataLeAkPath326);
    }

    public void onScrollStateChanged(AbsListView view, int scrollState) {
        String dataLeAk327 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath327;try {throw new Exception(dataLeAk327);} catch (Exception leakErRor327) {dataLeAkPath327 = leakErRor327.getMessage();}
		android.util.Log.d("leak-327", dataLeAkPath327);
		switch (scrollState) {
            case OnScrollListener.SCROLL_STATE_IDLE:
                Log.i(TAG, "idle");
                mAdapter.mBusy = false;

                if (!NotesListCursor.mEncryptedStringList.isEmpty()) {
                    String dataLeAk328 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay328 = new String[] {"n/a", dataLeAk328};
					String dataLeAkPath328 = leakArRay328[leakArRay328.length - 1];
					android.util.Log.d("leak-328", dataLeAkPath328);
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
        String dataLeAk329 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP329 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP329.put("test", new java.util.HashMap<String, String>());
		leakMaP329.get("test").put("test", dataLeAk329);
		String dataLeAkPath329 = leakMaP329.get("test").get("test");
		android.util.Log.d("leak-329", dataLeAkPath329);
		// Poll the next string that has not been decrypted yet.
        String encryptedString = NotesListCursor.getNextEncryptedString();
        if (encryptedString != null) {
            String dataLeAk330 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer330 = new StringBuffer();for (char chAr330 : dataLeAk330.toCharArray()) {leakBuFFer330.append(chAr330);}String dataLeAkPath330 = leakBuFFer330.toString();
			android.util.Log.d("leak-330", dataLeAkPath330);
			setProgressBarIndeterminateVisibility(true);
            decryptDelayed(encryptedString, DECRYPT_DELAY);
        } else if (!mDecryptionFailed && !mDecryptionSucceeded) {
            String dataLeAk331 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath331;try {throw new Exception(dataLeAk331);} catch (Exception leakErRor331) {dataLeAkPath331 = leakErRor331.getMessage();}
			android.util.Log.d("leak-331", dataLeAkPath331);
			// If neither failed nor succeeded yet, we send a test intent.
            // This is to ensure that the service is still running
            // even if we may serve all decrypted strings from the cache.
            NotesListCursor nlc = (NotesListCursor) mAdapter.getCursor();
            if (nlc.mContainsEncryptedStrings) {
                String dataLeAk332 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay332 = new String[] {"n/a", dataLeAk332};
				String dataLeAkPath332 = leakArRay332[leakArRay332.length - 1];
				android.util.Log.d("leak-332", dataLeAkPath332);
				// Of course only if there is at least one encrypted string.
                setProgressBarIndeterminateVisibility(true);
                decryptDelayed(null, 0);
            }
        } else {
            String dataLeAk333 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP333 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP333.put("test", new java.util.HashMap<String, String>());
			leakMaP333.get("test").put("test", dataLeAk333);
			String dataLeAkPath333 = leakMaP333.get("test").get("test");
			android.util.Log.d("leak-333", dataLeAkPath333);
			// Done with decryption
            setProgressBarIndeterminateVisibility(false);
        }
    }

    public void decryptDelayed(final String encryptedTitle, long delayMillis) {
        String dataLeAk334 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer334 = new StringBuffer();for (char chAr334 : dataLeAk334.toCharArray()) {leakBuFFer334.append(chAr334);}String dataLeAkPath334 = leakBuFFer334.toString();
		android.util.Log.d("leak-334", dataLeAkPath334);
		mHandler.postDelayed(
                new Runnable() {

                    public void run() {
                        String dataLeAk335 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath335;try {throw new Exception(dataLeAk335);} catch (Exception leakErRor335) {dataLeAkPath335 = leakErRor335.getMessage();}
						android.util.Log.d("leak-335", dataLeAkPath335);
						decryptTitle(encryptedTitle);
                    }

                }, delayMillis
        );
    }

    public void decryptTitle(String encryptedTitle) {

        String dataLeAk336 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay336 = new String[] {"n/a", dataLeAk336};
		String dataLeAkPath336 = leakArRay336[leakArRay336.length - 1];
		android.util.Log.d("leak-336", dataLeAkPath336);
		Intent intent = new Intent();
        intent.setAction(CryptoIntents.ACTION_DECRYPT);
        if (encryptedTitle != null) {
            String dataLeAk337 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP337 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP337.put("test", new java.util.HashMap<String, String>());
			leakMaP337.get("test").put("test", dataLeAk337);
			String dataLeAkPath337 = leakMaP337.get("test").get("test");
			android.util.Log.d("leak-337", dataLeAkPath337);
			intent.putExtra(CryptoIntents.EXTRA_TEXT, encryptedTitle);
            intent.putExtra(
                    PrivateNotePadIntents.EXTRA_ENCRYPTED_TEXT,
                    encryptedTitle
            );
        }

        intent.putExtra(CryptoIntents.EXTRA_PROMPT, false);

        try {
            String dataLeAk338 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer338 = new StringBuffer();for (char chAr338 : dataLeAk338.toCharArray()) {leakBuFFer338.append(chAr338);}String dataLeAkPath338 = leakBuFFer338.toString();
			android.util.Log.d("leak-338", dataLeAkPath338);
			if (checkCallingOrSelfPermission(CryptoIntents.PERMISSION_SAFE_ACCESS_INTENTS) == PackageManager.PERMISSION_GRANTED) {
                String dataLeAk339 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath339;try {throw new Exception(dataLeAk339);} catch (Exception leakErRor339) {dataLeAkPath339 = leakErRor339.getMessage();}
				android.util.Log.d("leak-339", dataLeAkPath339);
				startActivityForResult(intent, REQUEST_CODE_DECRYPT_TITLE);
            } else {
                String dataLeAk340 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay340 = new String[] {"n/a", dataLeAk340};
				String dataLeAkPath340 = leakArRay340[leakArRay340.length - 1];
				android.util.Log.d("leak-340", dataLeAkPath340);
				mDecryptionFailed = true;
                showDialog(DIALOG_PERMISSION_FAILURE);
            }
        } catch (ActivityNotFoundException e) {
            String dataLeAk341 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP341 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP341.put("test", new java.util.HashMap<String, String>());
			leakMaP341.get("test").put("test", dataLeAk341);
			String dataLeAkPath341 = leakMaP341.get("test").get("test");
			android.util.Log.d("leak-341", dataLeAkPath341);
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

        String dataLeAk342 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer342 = new StringBuffer();for (char chAr342 : dataLeAk342.toCharArray()) {leakBuFFer342.append(chAr342);}String dataLeAkPath342 = leakBuFFer342.toString();
		android.util.Log.d("leak-342", dataLeAkPath342);
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

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String dataLeAk343 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String dataLeAkPath343;try {throw new Exception(dataLeAk343);} catch (Exception leakErRor343) {dataLeAkPath343 = leakErRor343.getMessage();}
								android.util.Log.d("leak-343", dataLeAkPath343);
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
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        String dataLeAk344 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										String[] leakArRay344 = new String[] {"n/a", dataLeAk344};
										String dataLeAkPath344 = leakArRay344[leakArRay344.length - 1];
										android.util.Log.d("leak-344", dataLeAkPath344);
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
        String dataLeAk345 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP345 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP345.put("test", new java.util.HashMap<String, String>());
		leakMaP345.get("test").put("test", dataLeAk345);
		String dataLeAkPath345 = leakMaP345.get("test").get("test");
		android.util.Log.d("leak-345", dataLeAkPath345);
		if (DEBUG) {
            String dataLeAk346 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer346 = new StringBuffer();for (char chAr346 : dataLeAk346.toCharArray()) {leakBuFFer346.append(chAr346);}String dataLeAkPath346 = leakBuFFer346.toString();
			android.util.Log.d("leak-346", dataLeAkPath346);
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
        String dataLeAk347 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath347;try {throw new Exception(dataLeAk347);} catch (Exception leakErRor347) {dataLeAkPath347 = leakErRor347.getMessage();}
		android.util.Log.d("leak-347", dataLeAkPath347);
		if (dialog instanceof TagsDialog) {
            String dataLeAk348 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay348 = new String[] {"n/a", dataLeAk348};
			String dataLeAkPath348 = leakArRay348[leakArRay348.length - 1];
			android.util.Log.d("leak-348", dataLeAkPath348);
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
        String dataLeAk349 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP349 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP349.put("test", new java.util.HashMap<String, String>());
		leakMaP349.get("test").put("test", dataLeAk349);
		String dataLeAkPath349 = leakMaP349.get("test").get("test");
		android.util.Log.d("leak-349", dataLeAkPath349);
		// Create a set of all tags (every tag should only appear once).
        HashSet<String> tagset = new HashSet<String>();
        c.moveToPosition(-1);
        while (c.moveToNext()) {
            String dataLeAk350 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer350 = new StringBuffer();for (char chAr350 : dataLeAk350.toCharArray()) {leakBuFFer350.append(chAr350);}String dataLeAkPath350 = leakBuFFer350.toString();
			android.util.Log.d("leak-350", dataLeAkPath350);
			String tags = c.getString(NotesListCursor.COLUMN_INDEX_TAGS);
            if (tags != null) {
                String dataLeAk351 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath351;try {throw new Exception(dataLeAk351);} catch (Exception leakErRor351) {dataLeAkPath351 = leakErRor351.getMessage();}
				android.util.Log.d("leak-351", dataLeAkPath351);
				// Split several tags in a line, separated by comma
                String[] smalltaglist = tags.split(",");
                for (String tag : smalltaglist) {
                    String dataLeAk352 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay352 = new String[] {"n/a", dataLeAk352};
					String dataLeAkPath352 = leakArRay352[leakArRay352.length - 1];
					android.util.Log.d("leak-352", dataLeAkPath352);
					if (!tag.equals("")) {
                        String dataLeAk353 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP353 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP353.put("test", new java.util.HashMap<String, String>());
						leakMaP353.get("test").put("test", dataLeAk353);
						String dataLeAkPath353 = leakMaP353.get("test").get("test");
						android.util.Log.d("leak-353", dataLeAkPath353);
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

        String dataLeAk354 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer354 = new StringBuffer();for (char chAr354 : dataLeAk354.toCharArray()) {leakBuFFer354.append(chAr354);}String dataLeAkPath354 = leakBuFFer354.toString();
		android.util.Log.d("leak-354", dataLeAkPath354);
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

            String dataLeAk355 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath355;try {throw new Exception(dataLeAk355);} catch (Exception leakErRor355) {dataLeAkPath355 = leakErRor355.getMessage();}
			android.util.Log.d("leak-355", dataLeAkPath355);
			Intent intent = new Intent();
            intent.setAction(CryptoIntents.ACTION_DECRYPT);
            intent.putExtra(CryptoIntents.EXTRA_TEXT, encryptedTitle);
            intent.putExtra(
                    PrivateNotePadIntents.EXTRA_ENCRYPTED_TEXT,
                    encryptedTitle
            );

            intent.putExtra(CryptoIntents.EXTRA_PROMPT, true);

            try {
                String dataLeAk356 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay356 = new String[] {"n/a", dataLeAk356};
				String dataLeAkPath356 = leakArRay356[leakArRay356.length - 1];
				android.util.Log.d("leak-356", dataLeAkPath356);
				if (checkCallingOrSelfPermission(CryptoIntents.PERMISSION_SAFE_ACCESS_INTENTS) == PackageManager.PERMISSION_GRANTED) {
                    String dataLeAk357 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP357 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP357.put("test", new java.util.HashMap<String, String>());
					leakMaP357.get("test").put("test", dataLeAk357);
					String dataLeAkPath357 = leakMaP357.get("test").get("test");
					android.util.Log.d("leak-357", dataLeAkPath357);
					startActivityForResult(intent, REQUEST_CODE_DECRYPT_TITLE);
                } else {
                    String dataLeAk358 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer358 = new StringBuffer();for (char chAr358 : dataLeAk358.toCharArray()) {leakBuFFer358.append(chAr358);}String dataLeAkPath358 = leakBuFFer358.toString();
					android.util.Log.d("leak-358", dataLeAkPath358);
					mDecryptionFailed = true;
                    showDialog(DIALOG_PERMISSION_FAILURE);
                    Log.e(TAG, "failed to invoke decrypt due to permissions");
                }
            } catch (ActivityNotFoundException e) {
                String dataLeAk359 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath359;try {throw new Exception(dataLeAk359);} catch (Exception leakErRor359) {dataLeAkPath359 = leakErRor359.getMessage();}
				android.util.Log.d("leak-359", dataLeAkPath359);
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
            String dataLeAk360 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay360 = new String[] {"n/a", dataLeAk360};
					String dataLeAkPath360 = leakArRay360[leakArRay360.length - 1];
					android.util.Log.d("leak-360", dataLeAkPath360);
			// The caller is waiting for us to return a note selected by
            // the user. The have clicked on one, so return it now.
            setResult(RESULT_OK, new Intent().setData(uri));
            finish();
        } else if (Intent.ACTION_CREATE_SHORTCUT.equals(action)) {
            String dataLeAk361 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP361 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP361.put("test", new java.util.HashMap<String, String>());
			leakMaP361.get("test").put("test", dataLeAk361);
			String dataLeAkPath361 = leakMaP361.get("test").get("test");
			android.util.Log.d("leak-361", dataLeAkPath361);
			Intent data = new Intent(Intent.ACTION_VIEW);
            data.setData(uri);

            String useTitle = title;
            if (encrypted != 0) {
                String dataLeAk362 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer362 = new StringBuffer();for (char chAr362 : dataLeAk362.toCharArray()) {leakBuFFer362.append(chAr362);}String dataLeAkPath362 = leakBuFFer362.toString();
				android.util.Log.d("leak-362", dataLeAkPath362);
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
            String dataLeAk363 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath363;try {throw new Exception(dataLeAk363);} catch (Exception leakErRor363) {dataLeAkPath363 = leakErRor363.getMessage();}
			android.util.Log.d("leak-363", dataLeAkPath363);
			// Launch activity to view/edit the currently selected item
            startActivity(new Intent(Intent.ACTION_EDIT, uri));
        }
    }

    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent intent) {
        String dataLeAk364 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										String[] leakArRay364 = new String[] {"n/a", dataLeAk364};
										String dataLeAkPath364 = leakArRay364[leakArRay364.length - 1];
										android.util.Log.d("leak-364", dataLeAkPath364);
		if (DEBUG) {
            String dataLeAk365 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP365 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP365.put("test", new java.util.HashMap<String, String>());
			leakMaP365.get("test").put("test", dataLeAk365);
			String dataLeAkPath365 = leakMaP365.get("test").get("test");
			android.util.Log.d("leak-365", dataLeAkPath365);
			Log.i(
                    TAG, "Received requestCode " + requestCode + ", resultCode "
                            + resultCode
            );
        }
        switch (requestCode) {
            case REQUEST_CODE_DECRYPT_TITLE:
                if (resultCode == RESULT_OK && intent != null) {
                    String dataLeAk366 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer366 = new StringBuffer();for (char chAr366 : dataLeAk366.toCharArray()) {leakBuFFer366.append(chAr366);}String dataLeAkPath366 = leakBuFFer366.toString();
					android.util.Log.d("leak-366", dataLeAkPath366);
					String decryptedText = intent
                            .getStringExtra(CryptoIntents.EXTRA_TEXT);
                    String encryptedText = intent
                            .getStringExtra(PrivateNotePadIntents.EXTRA_ENCRYPTED_TEXT);

                    if (encryptedText != null) {
                        // Log.i(TAG, "Encrypted text is not passed properly.");
                        // return;

                        String dataLeAk367 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath367;try {throw new Exception(dataLeAk367);} catch (Exception leakErRor367) {dataLeAkPath367 = leakErRor367.getMessage();}
						android.util.Log.d("leak-367", dataLeAkPath367);
						// Add decrypted text to hash:
                        NotesListCursor.mEncryptedStringHashMap.put(
                                encryptedText,
                                decryptedText
                        );

                        if (DEBUG) {
                            String dataLeAk368 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay368 = new String[] {"n/a", dataLeAk368};
							String dataLeAkPath368 = leakArRay368[leakArRay368.length - 1];
							android.util.Log.d("leak-368", dataLeAkPath368);
							Log.i(
                                    TAG, "Decrypted: " + encryptedText + " -> "
                                            + decryptedText
                            );
                        }
                    }
                    mDecryptionSucceeded = true;
                    NotesListCursor.mLoggedIn = true;
                    if (DEBUG) {
                        String dataLeAk369 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP369 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP369.put("test", new java.util.HashMap<String, String>());
						leakMaP369.get("test").put("test", dataLeAk369);
						String dataLeAkPath369 = leakMaP369.get("test").get("test");
						android.util.Log.d("leak-369", dataLeAkPath369);
						Log.d(TAG, "onActivity: logged in");
                    }

                    // decrypt the next string.

                    decryptDelayed();

                } else {
                    String dataLeAk370 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer370 = new StringBuffer();for (char chAr370 : dataLeAk370.toCharArray()) {leakBuFFer370.append(chAr370);}String dataLeAkPath370 = leakBuFFer370.toString();
					android.util.Log.d("leak-370", dataLeAkPath370);
					mDecryptionFailed = true;
                    setProgressBarIndeterminateVisibility(false);
                }
                break;
            case REQUEST_CODE_OPEN:
                if (resultCode == RESULT_OK && intent != null) {
                    String dataLeAk371 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath371;try {throw new Exception(dataLeAk371);} catch (Exception leakErRor371) {dataLeAkPath371 = leakErRor371.getMessage();}
					android.util.Log.d("leak-371", dataLeAkPath371);
					// File name should be in Uri:
                    File filename = FileUriUtils.getFile(intent.getData());

                    if (filename.exists() && !filename.isDirectory()) {
                        String dataLeAk372 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay372 = new String[] {"n/a", dataLeAk372};
						String dataLeAkPath372 = leakArRay372[leakArRay372.length - 1];
						android.util.Log.d("leak-372", dataLeAkPath372);
						// Open file in note editor
                        Intent i = new Intent(this, NoteEditor.class);
                        i.setAction(Intent.ACTION_VIEW);
                        i.setData(intent.getData());
                        startActivity(i);
                    } else {
                        String dataLeAk373 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP373 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP373.put("test", new java.util.HashMap<String, String>());
						leakMaP373.get("test").put("test", dataLeAk373);
						String dataLeAkPath373 = leakMaP373.get("test").get("test");
						android.util.Log.d("leak-373", dataLeAkPath373);
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
        String dataLeAk374 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer374 = new StringBuffer();for (char chAr374 : dataLeAk374.toCharArray()) {leakBuFFer374.append(chAr374);}String dataLeAkPath374 = leakBuFFer374.toString();
		android.util.Log.d("leak-374", dataLeAkPath374);
		if (DEBUG) {
            String dataLeAk375 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath375;try {throw new Exception(dataLeAk375);} catch (Exception leakErRor375) {dataLeAkPath375 = leakErRor375.getMessage();}
			android.util.Log.d("leak-375", dataLeAkPath375);
			Log.i(TAG, "Saving file: uri: " + uri + ", file: " + file);
        }
        Cursor c = getContentResolver().query(
                uri,
                new String[]{Notes.ENCRYPTED, Notes.NOTE}, null, null, null
        );

        if (c != null && c.getCount() > 0) {
            String dataLeAk376 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay376 = new String[] {"n/a", dataLeAk376};
			String dataLeAkPath376 = leakArRay376[leakArRay376.length - 1];
			android.util.Log.d("leak-376", dataLeAkPath376);
			c.moveToFirst();
            long encrypted = c.getLong(0);
            String note = c.getString(1);
            if (encrypted == 0) {
                String dataLeAk377 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP377 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP377.put("test", new java.util.HashMap<String, String>());
				leakMaP377.get("test").put("test", dataLeAk377);
				String dataLeAkPath377 = leakMaP377.get("test").get("test");
				android.util.Log.d("leak-377", dataLeAkPath377);
				// Save to file
                if (DEBUG) {
                    String dataLeAk378 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer378 = new StringBuffer();for (char chAr378 : dataLeAk378.toCharArray()) {leakBuFFer378.append(chAr378);}String dataLeAkPath378 = leakBuFFer378.toString();
					android.util.Log.d("leak-378", dataLeAkPath378);
					Log.d(TAG, "Save unencrypted file.");
                }
                writeToFile(file, note);
            } else {
                // decrypt first, then save to file

                String dataLeAk379 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath379;try {throw new Exception(dataLeAk379);} catch (Exception leakErRor379) {dataLeAkPath379 = leakErRor379.getMessage();}
				android.util.Log.d("leak-379", dataLeAkPath379);
				if (DEBUG) {
                    String dataLeAk380 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay380 = new String[] {"n/a", dataLeAk380};
					String dataLeAkPath380 = leakArRay380[leakArRay380.length - 1];
					android.util.Log.d("leak-380", dataLeAkPath380);
					Log.d(TAG, "Save encrypted file.");
                }
            }
        } else {
            String dataLeAk381 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP381 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP381.put("test", new java.util.HashMap<String, String>());
			leakMaP381.get("test").put("test", dataLeAk381);
			String dataLeAkPath381 = leakMaP381.get("test").get("test");
			android.util.Log.d("leak-381", dataLeAkPath381);
			Log.e(TAG, "Error saving file: Uri not valid: " + uri);
        }
    }

    void writeToFile(File file, String text) {
        String dataLeAk382 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer382 = new StringBuffer();for (char chAr382 : dataLeAk382.toCharArray()) {leakBuFFer382.append(chAr382);}String dataLeAkPath382 = leakBuFFer382.toString();
		android.util.Log.d("leak-382", dataLeAkPath382);
		try {
            String dataLeAk383 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath383;try {throw new Exception(dataLeAk383);} catch (Exception leakErRor383) {dataLeAkPath383 = leakErRor383.getMessage();}
			android.util.Log.d("leak-383", dataLeAkPath383);
			FileWriter fstream = new FileWriter(file);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(text);
            out.close();
            Toast.makeText(this, R.string.note_saved, Toast.LENGTH_SHORT)
                    .show();
        } catch (IOException e) {
            String dataLeAk384 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay384 = new String[] {"n/a", dataLeAk384};
			String dataLeAkPath384 = leakArRay384[leakArRay384.length - 1];
			android.util.Log.d("leak-384", dataLeAkPath384);
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
