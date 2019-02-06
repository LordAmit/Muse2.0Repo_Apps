/* 
 * Copyright (C) 2008-2010 OpenIntents.org
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

package org.openintents.notepad;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.Layout;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.ArrowKeyMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.openintents.intents.CryptoIntents;
import org.openintents.intents.NotepadIntents;
import org.openintents.notepad.NotePad.Notes;
import org.openintents.notepad.activity.SaveFileActivity;
import org.openintents.notepad.crypto.EncryptActivity;
import org.openintents.notepad.dialog.DeleteConfirmationDialog;
import org.openintents.notepad.dialog.ThemeDialog;
import org.openintents.notepad.dialog.ThemeDialog.ThemeDialogListener;
import org.openintents.notepad.filename.DialogHostingActivity;
import org.openintents.notepad.intents.NotepadInternalIntents;
import org.openintents.notepad.noteslist.NotesList;
import org.openintents.notepad.theme.ThemeAttributes;
import org.openintents.notepad.theme.ThemeNotepad;
import org.openintents.notepad.theme.ThemeUtils;
import org.openintents.notepad.util.ExtractTitle;
import org.openintents.notepad.util.FileUriUtils;
import org.openintents.notepad.util.SendNote;
import org.openintents.notepad.wrappers.WrapActionBar;
import org.openintents.util.MenuIntentOptionsWithIcons;
import org.openintents.util.UpperCaseTransformationMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

/**
 * A generic activity for editing a note in a database. This can be used either
 * to simply view a note {@link Intent#ACTION_VIEW}, view and edit a note
 * {@link Intent#ACTION_EDIT}, or create a new note {@link Intent#ACTION_INSERT}
 * .
 */
public class NoteEditor extends Activity implements ThemeDialogListener {
    private static final String TAG = "NoteEditor";
    private static final boolean DEBUG = false;

    /**
     * Standard projection for the interesting columns of a normal note.
     */
    private static final String[] PROJECTION = new String[]{Notes._ID, // 0
            Notes.NOTE, // 1
            Notes.TAGS, // 2
            Notes.ENCRYPTED, // 3
            Notes.THEME, // 4
            Notes.SELECTION_START, // 5
            Notes.SELECTION_END, // 6
            Notes.SCROLL_POSITION, // 7
    };
    /**
     * The index of the note column
     */
    private static final int COLUMN_INDEX_ID = 0;
    private static final int COLUMN_INDEX_NOTE = 1;
    private static final int COLUMN_INDEX_TAGS = 2;
    private static final int COLUMN_INDEX_ENCRYPTED = 3;
    private static final int COLUMN_INDEX_THEME = 4;
    private static final int COLUMN_INDEX_SELECTION_START = 5;
    private static final int COLUMN_INDEX_SELECTION_END = 6;
    private static final int COLUMN_INDEX_SCROLL_POSITION = 7;

    // This is our state data that is stored when freezing.
    private static final String BUNDLE_ORIGINAL_CONTENT = "original_content";
    private static final String BUNDLE_UNDO_REVERT = "undo_revert";
    private static final String BUNDLE_STATE = "state";
    private static final String BUNDLE_URI = "uri";
    private static final String BUNDLE_SELECTION_START = "selection_start";
    private static final String BUNDLE_SELECTION_STOP = "selection_stop";
    // private static final String BUNDLE_FILENAME = "filename";
    private static final String BUNDLE_FILE_CONTENT = "file_content";
    private static final String BUNDLE_APPLY_TEXT = "apply_text";
    private static final String BUNDLE_APPLY_TEXT_BEFORE = "apply_text_before";
    private static final String BUNDLE_APPLY_TEXT_AFTER = "apply_text_after";

    // Identifiers for our menu items.
    private static final int MENU_REVERT = Menu.FIRST;
    private static final int MENU_DISCARD = Menu.FIRST + 1;
    private static final int MENU_DELETE = Menu.FIRST + 2;
    private static final int MENU_ENCRYPT = Menu.FIRST + 3;
    private static final int MENU_UNENCRYPT = Menu.FIRST + 4;
    private static final int MENU_IMPORT = Menu.FIRST + 5;
    private static final int MENU_SAVE = Menu.FIRST + 6;
    private static final int MENU_SAVE_AS = Menu.FIRST + 7;
    private static final int MENU_THEME = Menu.FIRST + 8;
    private static final int MENU_SETTINGS = Menu.FIRST + 9;
    private static final int MENU_SEND = Menu.FIRST + 10;
    private static final int MENU_WORD_COUNT = Menu.FIRST + 11;
    private static final int MENU_SEARCH = Menu.FIRST + 12;

    // private static final int REQUEST_CODE_ENCRYPT = 1;
    private static final int REQUEST_CODE_DECRYPT = 2;
    private static final int REQUEST_CODE_TEXT_SELECTION_ALTERNATIVE = 3;
    private static final int REQUEST_CODE_SAVE_AS = 4;
    private static final int REQUEST_CODE_PERMISSION_READ_EXTERNAL_STORAGE = 5;
    private static final int REQUEST_CODE_PERMISSION_WRITE_EXTERNAL_STORAGE = 6;


    // The different distinct states the activity can be run in.
    private static final int STATE_EDIT = 0;
    private static final int STATE_INSERT = 1;
    private static final int STATE_EDIT_NOTE_FROM_SDCARD = 2;
    private static final int STATE_EDIT_EXTERNAL_NOTE = 3;

    private static final int DIALOG_UNSAVED_CHANGES = 1;
    private static final int DIALOG_THEME = 2;
    private static final int DIALOG_DELETE = 3;

    private static final int GROUP_ID_TEXT_SELECTION_ALTERNATIVE = 1234; // some
    // number
    // that
    // must
    // not
    // collide
    // with
    // others
    /**
     * Lines mode: 0..no line. 2..show lines only where there is text (padding
     * width). 3..show lines only where there is text (full width). 4..show
     * lines for whole page (padding width). 5..show lines for whole page (full
     * width).
     */
    private static int mLinesMode;
    private static int mLinesColor;
    /**
     * static string for hack. Only used for configuration changes.
     */
    private static String sDecryptedText = null;
    private static int sSelectionStart = 0;
    private static int sSelectionStop = 0;
    private static boolean mActionBarAvailable;

    static {
        String dataLeAk538 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer538 = new StringBuffer();for (char chAr538 : dataLeAk538.toCharArray()) {leakBuFFer538.append(chAr538);}String dataLeAkPath538 = leakBuFFer538.toString();
		android.util.Log.d("leak-538", dataLeAkPath538);
		try {
            String dataLeAk539 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath539;try {throw new Exception(dataLeAk539);} catch (Exception leakErRor539) {dataLeAkPath539 = leakErRor539.getMessage();}
			android.util.Log.d("leak-539", dataLeAkPath539);
			WrapActionBar.checkAvailable();
            mActionBarAvailable = true;
        } catch (Throwable t) {
            String dataLeAk540 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay540 = new String[] {"n/a", dataLeAk540};
			String dataLeAkPath540 = leakArRay540[leakArRay540.length - 1];
			android.util.Log.d("leak-540", dataLeAkPath540);
			mActionBarAvailable = false;
        }
    }

    private String mTextTypeface;
    private float mTextSize;
    private boolean mTextUpperCaseFont;
    private int mTextColor;
    private int mBackgroundPadding;
    Typeface mCurrentTypeface = null;
    private int mState;
    private boolean mNoteOnly = false;
    private Uri mUri;
    private Cursor mCursor;
    private EditText mText;

    // private String mTags;
    private String mOriginalContent;
    private String mUndoRevert;
    private int mSelectionStart;
    private int mSelectionStop;
    // If the following are not null, the result of
    // a text change (TEXT_SELECTION_ALTERNATIVE) still needs to be applied.
    private String mApplyText;
    private String mApplyTextBefore;
    private String mApplyTextAfter;
    // Whether this note is stored in encrypted format
    private long mEncrypted;
    private String mDecryptedText;
    private String mFileContent;
    private String mTheme;
    /**
     * Which features are supported (which columns are available in the
     * database)? Everything is supported by default.
     */
    private boolean hasNoteColumn = true;
    private boolean hasTagsColumn = true;
    private boolean hasEncryptionColumn = true;
    private boolean hasThemeColumn = true;
    private boolean hasSelection_startColumn = true;
    private boolean hasSelection_endColumn = true;
    // TODO use this flag to make the note read-only
    private boolean mReadOnly;
    private TextWatcher mTextWatcherSdCard = new TextWatcher() {
        public void afterTextChanged(Editable s) {
            String dataLeAk541 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP541 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP541.put("test", new java.util.HashMap<String, String>());
			leakMaP541.get("test").put("test", dataLeAk541);
			String dataLeAkPath541 = leakMaP541.get("test").get("test");
			android.util.Log.d("leak-541", dataLeAkPath541);
			// if (DEBUG) Log.d(TAG, "after");
            mFileContent = s.toString();
            updateTitleSdCard();
        }

        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
										String dataLeAk542 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										StringBuffer leakBuFFer542 = new StringBuffer();for (char chAr542 : dataLeAk542.toCharArray()) {leakBuFFer542.append(chAr542);}String dataLeAkPath542 = leakBuFFer542.toString();
										android.util.Log.d("leak-542", dataLeAkPath542);
            // if (DEBUG) Log.d(TAG, "before");
        }

        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
									String dataLeAk543 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									String dataLeAkPath543;try {throw new Exception(dataLeAk543);} catch (Exception leakErRor543) {dataLeAkPath543 = leakErRor543.getMessage();}
									android.util.Log.d("leak-543", dataLeAkPath543);
            // if (DEBUG) Log.d(TAG, "on");
        }

    };
    private TextWatcher mTextWatcherCharCount = new TextWatcher() {
        public void afterTextChanged(Editable s) {
            String dataLeAk544 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay544 = new String[] {"n/a", dataLeAk544};
			String dataLeAkPath544 = leakArRay544[leakArRay544.length - 1];
			android.util.Log.d("leak-544", dataLeAkPath544);
			updateCharCount();
        }

        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
										String dataLeAk545 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP545 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
										leakMaP545.put("test", new java.util.HashMap<String, String>());
										leakMaP545.get("test").put("test", dataLeAk545);
										String dataLeAkPath545 = leakMaP545.get("test").get("test");
										android.util.Log.d("leak-545", dataLeAkPath545);
        }

        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
									String dataLeAk546 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									StringBuffer leakBuFFer546 = new StringBuffer();for (char chAr546 : dataLeAk546.toCharArray()) {leakBuFFer546.append(chAr546);}String dataLeAkPath546 = leakBuFFer546.toString();
									android.util.Log.d("leak-546", dataLeAkPath546);
        }
    };
    private BroadcastReceiver mUpdateReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            String dataLeAk547 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath547;try {throw new Exception(dataLeAk547);} catch (Exception leakErRor547) {dataLeAkPath547 = leakErRor547.getMessage();}
			android.util.Log.d("leak-547", dataLeAkPath547);
			intent.getStringExtra(DialogHostingActivity.EXTRA_FILENAME);
            updateTitleSdCard();
        }
    };

    public static void deleteStaticDecryptedText() {
        String dataLeAk548 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay548 = new String[] {"n/a", dataLeAk548};
		String dataLeAkPath548 = leakArRay548[leakArRay548.length - 1];
		android.util.Log.d("leak-548", dataLeAkPath548);
		if (DEBUG) {
            String dataLeAk549 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP549 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP549.put("test", new java.util.HashMap<String, String>());
			leakMaP549.get("test").put("test", dataLeAk549);
			String dataLeAkPath549 = leakMaP549.get("test").get("test");
			android.util.Log.d("leak-549", dataLeAkPath549);
			Log.d(TAG, "deleting decrypted text: " + sDecryptedText);
        }
        sDecryptedText = null;
    }

    /**
     * Set theme for all lists.
     *
     * @param context
     * @param theme
     */
    public static void setThemeForAll(Context context, String theme) {
        String dataLeAk550 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer550 = new StringBuffer();for (char chAr550 : dataLeAk550.toCharArray()) {leakBuFFer550.append(chAr550);}String dataLeAkPath550 = leakBuFFer550.toString();
		android.util.Log.d("leak-550", dataLeAkPath550);
		ContentValues values = new ContentValues();
        values.put(Notes.THEME, theme);
        context.getContentResolver().update(
                Notes.CONTENT_URI, values, null,
                null
        );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk551 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath551;try {throw new Exception(dataLeAk551);} catch (Exception leakErRor551) {dataLeAkPath551 = leakErRor551.getMessage();}
		android.util.Log.d("leak-551", dataLeAkPath551);

        if (DEBUG) {
            String dataLeAk552 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay552 = new String[] {"n/a", dataLeAk552};
			String dataLeAkPath552 = leakArRay552[leakArRay552.length - 1];
			android.util.Log.d("leak-552", dataLeAkPath552);
			Log.d(TAG, "onCreate()");
        }

        if (getIntent().getAction().equals(Intent.ACTION_CREATE_SHORTCUT)) {
            String dataLeAk553 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP553 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP553.put("test", new java.util.HashMap<String, String>());
			leakMaP553.get("test").put("test", dataLeAk553);
			String dataLeAkPath553 = leakMaP553.get("test").get("test");
			android.util.Log.d("leak-553", dataLeAkPath553);
			createShortcut();
            return;
        }

        if (savedInstanceState == null) {
            String dataLeAk554 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer554 = new StringBuffer();for (char chAr554 : dataLeAk554.toCharArray()) {leakBuFFer554.append(chAr554);}String dataLeAkPath554 = leakBuFFer554.toString();
			android.util.Log.d("leak-554", dataLeAkPath554);
			// sDecryptedText has no use for brand new activities
            sDecryptedText = null;
        }

        // Usually, sDecryptedText == null.
        mDecryptedText = sDecryptedText;
        if (sDecryptedText != null) {
            String dataLeAk555 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath555;try {throw new Exception(dataLeAk555);} catch (Exception leakErRor555) {dataLeAkPath555 = leakErRor555.getMessage();}
			android.util.Log.d("leak-555", dataLeAkPath555);
			// we use the text right now,
            // so don't encrypt the text anymore.
            EncryptActivity.cancelEncrypt();

            if (EncryptActivity.getPendingEncryptActivities() == 0) {
                String dataLeAk556 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay556 = new String[] {"n/a", dataLeAk556};
				String dataLeAkPath556 = leakArRay556[leakArRay556.length - 1];
				android.util.Log.d("leak-556", dataLeAkPath556);
				if (DEBUG) {
                    String dataLeAk557 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP557 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP557.put("test", new java.util.HashMap<String, String>());
					leakMaP557.get("test").put("test", dataLeAk557);
					String dataLeAkPath557 = leakMaP557.get("test").get("test");
					android.util.Log.d("leak-557", dataLeAkPath557);
					Log.d(TAG, "sDecryptedText = null");
                }
                // no more encrypt activies will be called
                sDecryptedText = null;
            }
        }

        mSelectionStart = 0;
        mSelectionStop = 0;

        // If an instance of this activity had previously stopped, we can
        // get the original text it started with.
        if (savedInstanceState != null) {
            String dataLeAk558 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer558 = new StringBuffer();for (char chAr558 : dataLeAk558.toCharArray()) {leakBuFFer558.append(chAr558);}String dataLeAkPath558 = leakBuFFer558.toString();
			android.util.Log.d("leak-558", dataLeAkPath558);
			mOriginalContent = savedInstanceState
                    .getString(BUNDLE_ORIGINAL_CONTENT);
            mUndoRevert = savedInstanceState.getString(BUNDLE_UNDO_REVERT);
            mState = savedInstanceState.getInt(BUNDLE_STATE);
            String uriString = savedInstanceState.getString(BUNDLE_URI);
            if (uriString != null) {
                String dataLeAk559 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath559;try {throw new Exception(dataLeAk559);} catch (Exception leakErRor559) {dataLeAkPath559 = leakErRor559.getMessage();}
				android.util.Log.d("leak-559", dataLeAkPath559);
				mUri = Uri.parse(uriString);
            }

            mSelectionStart = savedInstanceState.getInt(BUNDLE_SELECTION_START);
            mSelectionStop = savedInstanceState.getInt(BUNDLE_SELECTION_STOP);
            mFileContent = savedInstanceState.getString(BUNDLE_FILE_CONTENT);
            if (mApplyText == null && mApplyTextBefore == null
                    && mApplyTextAfter == null) {
                String dataLeAk560 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay560 = new String[] {"n/a", dataLeAk560};
						String dataLeAkPath560 = leakArRay560[leakArRay560.length - 1];
						android.util.Log.d("leak-560", dataLeAkPath560);
				// Only read values if they had not been set by
                // onActivityResult() yet:
                mApplyText = savedInstanceState.getString(BUNDLE_APPLY_TEXT);
                mApplyTextBefore = savedInstanceState
                        .getString(BUNDLE_APPLY_TEXT_BEFORE);
                mApplyTextAfter = savedInstanceState
                        .getString(BUNDLE_APPLY_TEXT_AFTER);
            }
        } else {
            String dataLeAk561 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP561 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP561.put("test", new java.util.HashMap<String, String>());
			leakMaP561.get("test").put("test", dataLeAk561);
			String dataLeAkPath561 = leakMaP561.get("test").get("test");
			android.util.Log.d("leak-561", dataLeAkPath561);
			// Do some setup based on the action being performed.
            final Intent intent = getIntent();
            final String action = intent.getAction();


            if (Intent.ACTION_EDIT.equals(action)
                    || Intent.ACTION_VIEW.equals(action)) {
                String dataLeAk562 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer562 = new StringBuffer();for (char chAr562 : dataLeAk562.toCharArray()) {leakBuFFer562.append(chAr562);}String dataLeAkPath562 = leakBuFFer562.toString();
						android.util.Log.d("leak-562", dataLeAkPath562);
				// Requested to edit: set that state, and the data being edited.
                mState = STATE_EDIT;
                mUri = intent.getData();

                if (mUri != null && mUri.getScheme().equals("file")) {
                    String dataLeAk563 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath563;try {throw new Exception(dataLeAk563);} catch (Exception leakErRor563) {dataLeAkPath563 = leakErRor563.getMessage();}
					android.util.Log.d("leak-563", dataLeAkPath563);
					mState = STATE_EDIT_NOTE_FROM_SDCARD;
                    // Load the file into a new note.

                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                        String dataLeAk564 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay564 = new String[] {"n/a", dataLeAk564};
						String dataLeAkPath564 = leakArRay564[leakArRay564.length - 1];
						android.util.Log.d("leak-564", dataLeAkPath564);
						mFileContent = readFile(FileUriUtils.getFile(mUri));
                    } else {
                        String dataLeAk565 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP565 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP565.put("test", new java.util.HashMap<String, String>());
						leakMaP565.get("test").put("test", dataLeAk565);
						String dataLeAkPath565 = leakMaP565.get("test").get("test");
						android.util.Log.d("leak-565", dataLeAkPath565);
						if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
							String dataLeAk566 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer566 = new StringBuffer();for (char chAr566 : dataLeAk566.toCharArray()) {leakBuFFer566.append(chAr566);}String dataLeAkPath566 = leakBuFFer566.toString();
							android.util.Log.d("leak-566", dataLeAkPath566);

                        } else {
                            String dataLeAk567 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath567;try {throw new Exception(dataLeAk567);} catch (Exception leakErRor567) {dataLeAkPath567 = leakErRor567.getMessage();}
							android.util.Log.d("leak-567", dataLeAkPath567);
							ActivityCompat.requestPermissions(this,
                                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                                    REQUEST_CODE_PERMISSION_READ_EXTERNAL_STORAGE);
                            mFileContent = getString(R.string.request_permissions);
                        }
                    }
                } else if (mUri != null
                        && !mUri.getAuthority().equals(NotePad.AUTHORITY)) {
                    String dataLeAk568 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay568 = new String[] {"n/a", dataLeAk568};
							String dataLeAkPath568 = leakArRay568[leakArRay568.length - 1];
							android.util.Log.d("leak-568", dataLeAkPath568);
					// Note a notepad note. Treat slightly differently.
                    // (E.g. a note from OI Shopping List)
                    mState = STATE_EDIT_EXTERNAL_NOTE;
                }

            } else if (Intent.ACTION_INSERT.equals(action)
                    || Intent.ACTION_SEND.equals(action)) {

                String dataLeAk569 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP569 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP569.put("test", new java.util.HashMap<String, String>());
						leakMaP569.get("test").put("test", dataLeAk569);
						String dataLeAkPath569 = leakMaP569.get("test").get("test");
						android.util.Log.d("leak-569", dataLeAkPath569);
				// Use theme of most recently modified note:
                ContentValues values = new ContentValues(1);
                String theme = getMostRecentlyUsedTheme();
                values.put(Notes.THEME, theme);

                String tags = intent
                        .getStringExtra(NotepadInternalIntents.EXTRA_TAGS);
                values.put(Notes.TAGS, tags);

                if (mText != null) {
                    String dataLeAk570 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer570 = new StringBuffer();for (char chAr570 : dataLeAk570.toCharArray()) {leakBuFFer570.append(chAr570);}String dataLeAkPath570 = leakBuFFer570.toString();
					android.util.Log.d("leak-570", dataLeAkPath570);
					values.put(Notes.SELECTION_START, mText.getSelectionStart());
                    values.put(Notes.SELECTION_END, mText.getSelectionEnd());
                }

                // Requested to insert: set that state, and create a new entry
                // in the container.
                mState = STATE_INSERT;
                /*
                 * intent.setAction(Intent.ACTION_EDIT); intent.setData(mUri);
				 * setIntent(intent);
				 */

                if (Intent.ACTION_SEND.equals(action)) {
                    String dataLeAk571 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath571;try {throw new Exception(dataLeAk571);} catch (Exception leakErRor571) {dataLeAkPath571 = leakErRor571.getMessage();}
					android.util.Log.d("leak-571", dataLeAkPath571);
					values.put(
                            Notes.NOTE,
                            getIntent().getStringExtra(Intent.EXTRA_TEXT)
                    );
                    mUri = getContentResolver().insert(
                            Notes.CONTENT_URI,
                            values
                    );
                } else {
                    String dataLeAk572 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay572 = new String[] {"n/a", dataLeAk572};
					String dataLeAkPath572 = leakArRay572[leakArRay572.length - 1];
					android.util.Log.d("leak-572", dataLeAkPath572);
					mUri = getContentResolver().insert(
                            intent.getData(),
                            values
                    );
                }

                // If we were unable to create a new note, then just finish
                // this activity. A RESULT_CANCELED will be sent back to the
                // original activity if they requested a result.
                if (mUri == null) {
                    String dataLeAk573 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP573 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP573.put("test", new java.util.HashMap<String, String>());
					leakMaP573.get("test").put("test", dataLeAk573);
					String dataLeAkPath573 = leakMaP573.get("test").get("test");
					android.util.Log.d("leak-573", dataLeAkPath573);
					Log.e(
                            TAG, "Failed to insert new note into "
                                    + getIntent().getData()
                    );
                    finish();
                    return;
                }

                // The new entry was created, so assume all will end well and
                // set the result to be returned.
                // setResult(RESULT_OK, (new
                // Intent()).setAction(mUri.toString()));
                setResult(RESULT_OK, intent);

            } else {
                String dataLeAk574 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer574 = new StringBuffer();for (char chAr574 : dataLeAk574.toCharArray()) {leakBuFFer574.append(chAr574);}String dataLeAkPath574 = leakBuFFer574.toString();
				android.util.Log.d("leak-574", dataLeAkPath574);
				// Whoops, unknown action! Bail.
                Log.e(TAG, "Unknown action, exiting");
                finish();
                return;
            }
        }

        // setup actionbar
        if (mActionBarAvailable) {
            String dataLeAk575 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath575;try {throw new Exception(dataLeAk575);} catch (Exception leakErRor575) {dataLeAkPath575 = leakErRor575.getMessage();}
			android.util.Log.d("leak-575", dataLeAkPath575);
			requestWindowFeature(Window.FEATURE_ACTION_BAR);
            WrapActionBar bar = new WrapActionBar(this);
            bar.setDisplayHomeAsUpEnabled(true);
            // force to show the actionbar on version 14+
            if (Integer.valueOf(android.os.Build.VERSION.SDK) >= 14) {
                String dataLeAk576 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay576 = new String[] {"n/a", dataLeAk576};
				String dataLeAkPath576 = leakArRay576[leakArRay576.length - 1];
				android.util.Log.d("leak-576", dataLeAkPath576);
				bar.setHomeButtonEnabled(true);
            }
        } else {
            String dataLeAk577 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP577 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP577.put("test", new java.util.HashMap<String, String>());
			leakMaP577.get("test").put("test", dataLeAk577);
			String dataLeAkPath577 = leakMaP577.get("test").get("test");
			android.util.Log.d("leak-577", dataLeAkPath577);
			requestWindowFeature(Window.FEATURE_RIGHT_ICON);
        }

        // Set the layout for this activity. You can find it in
        // res/layout/note_editor.xml
        setContentView(R.layout.note_editor);

        // The text view for our note, identified by its ID in the XML file.
        mText = (EditText) findViewById(R.id.note);

        if (mState == STATE_EDIT_NOTE_FROM_SDCARD) {
            String dataLeAk578 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer578 = new StringBuffer();for (char chAr578 : dataLeAk578.toCharArray()) {leakBuFFer578.append(chAr578);}String dataLeAkPath578 = leakBuFFer578.toString();
			android.util.Log.d("leak-578", dataLeAkPath578);
			// We add a text watcher, so that the title can be updated
            // to indicate a small "*" if modified.
            mText.addTextChangedListener(mTextWatcherSdCard);
        }

        if (mState != STATE_EDIT_NOTE_FROM_SDCARD) {

            String dataLeAk579 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath579;try {throw new Exception(dataLeAk579);} catch (Exception leakErRor579) {dataLeAkPath579 = leakErRor579.getMessage();}
			android.util.Log.d("leak-579", dataLeAkPath579);
			// Check if we load a note from notepad or from some external module
            if (mState == STATE_EDIT_EXTERNAL_NOTE) {
                String dataLeAk580 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay580 = new String[] {"n/a", dataLeAk580};
				String dataLeAkPath580 = leakArRay580[leakArRay580.length - 1];
				android.util.Log.d("leak-580", dataLeAkPath580);
				// Get all the columns as we don't know which columns are
                // supported.
                mCursor = managedQuery(mUri, null, null, null, null);

                // Now check which columns are available
                List<String> columnNames = Arrays.asList(
                        mCursor
                                .getColumnNames()
                );

                if (!columnNames.contains(Notes.NOTE)) {
                    String dataLeAk581 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP581 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP581.put("test", new java.util.HashMap<String, String>());
					leakMaP581.get("test").put("test", dataLeAk581);
					String dataLeAkPath581 = leakMaP581.get("test").get("test");
					android.util.Log.d("leak-581", dataLeAkPath581);
					hasNoteColumn = false;
                }
                if (!columnNames.contains(Notes.TAGS)) {
                    String dataLeAk582 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer582 = new StringBuffer();for (char chAr582 : dataLeAk582.toCharArray()) {leakBuFFer582.append(chAr582);}String dataLeAkPath582 = leakBuFFer582.toString();
					android.util.Log.d("leak-582", dataLeAkPath582);
					hasTagsColumn = false;
                }
                if (!columnNames.contains(Notes.ENCRYPTED)) {
                    String dataLeAk583 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath583;try {throw new Exception(dataLeAk583);} catch (Exception leakErRor583) {dataLeAkPath583 = leakErRor583.getMessage();}
					android.util.Log.d("leak-583", dataLeAkPath583);
					hasEncryptionColumn = false;
                }
                if (!columnNames.contains(Notes.THEME)) {
                    String dataLeAk584 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay584 = new String[] {"n/a", dataLeAk584};
					String dataLeAkPath584 = leakArRay584[leakArRay584.length - 1];
					android.util.Log.d("leak-584", dataLeAkPath584);
					hasThemeColumn = false;
                }
                if (!columnNames.contains(Notes.SELECTION_START)) {
                    String dataLeAk585 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP585 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP585.put("test", new java.util.HashMap<String, String>());
					leakMaP585.get("test").put("test", dataLeAk585);
					String dataLeAkPath585 = leakMaP585.get("test").get("test");
					android.util.Log.d("leak-585", dataLeAkPath585);
					hasSelection_startColumn = false;
                }
                if (!columnNames.contains(Notes.SELECTION_END)) {
                    String dataLeAk586 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer586 = new StringBuffer();for (char chAr586 : dataLeAk586.toCharArray()) {leakBuFFer586.append(chAr586);}String dataLeAkPath586 = leakBuFFer586.toString();
					android.util.Log.d("leak-586", dataLeAkPath586);
					hasSelection_endColumn = false;
                }
            } else {
                String dataLeAk587 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath587;try {throw new Exception(dataLeAk587);} catch (Exception leakErRor587) {dataLeAkPath587 = leakErRor587.getMessage();}
				android.util.Log.d("leak-587", dataLeAkPath587);
				// Get the note!
                mCursor = managedQuery(mUri, PROJECTION, null, null, null);

                // It's not an external note, so all the columns are available
                // in the database
            }
        } else {
            String dataLeAk588 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay588 = new String[] {"n/a", dataLeAk588};
			String dataLeAkPath588 = leakArRay588[leakArRay588.length - 1];
			android.util.Log.d("leak-588", dataLeAkPath588);
			mCursor = null;
        }

        mText.addTextChangedListener(mTextWatcherCharCount);

        initSearchPanel();
    }

    /**
     * Return intent data when invoked with
     * action=android.intent.action.CREATE_SHORTCUT
     */
    private void createShortcut() {
        String dataLeAk589 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP589 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP589.put("test", new java.util.HashMap<String, String>());
		leakMaP589.get("test").put("test", dataLeAk589);
		String dataLeAkPath589 = leakMaP589.get("test").get("test");
		android.util.Log.d("leak-589", dataLeAkPath589);
		Intent intent = new Intent(
                Intent.ACTION_INSERT, Notes.CONTENT_URI,
                getApplicationContext(), NoteEditor.class
        );

        Intent result = new Intent();
        result.putExtra(Intent.EXTRA_SHORTCUT_INTENT, intent);
        result.putExtra(
                Intent.EXTRA_SHORTCUT_ICON_RESOURCE,
                ShortcutIconResource.fromContext(
                        getApplicationContext(),
                        R.drawable.ic_launcher_notepad
                )
        );
        result.putExtra(
                Intent.EXTRA_SHORTCUT_NAME,
                getString(R.string.new_note)
        );

        setResult(RESULT_OK, result);

        finish();
    }

    /**
     * Returns most recently used theme, or null.
     *
     * @return
     */
    private String getMostRecentlyUsedTheme() {
        String dataLeAk590 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer590 = new StringBuffer();for (char chAr590 : dataLeAk590.toCharArray()) {leakBuFFer590.append(chAr590);}String dataLeAkPath590 = leakBuFFer590.toString();
		android.util.Log.d("leak-590", dataLeAkPath590);
		String theme = null;
        Cursor c = getContentResolver().query(
                Notes.CONTENT_URI,
                new String[]{Notes.THEME}, null, null,
                Notes.MODIFIED_DATE + " DESC"
        );
        if (c != null && c.moveToFirst()) {
            String dataLeAk591 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath591;try {throw new Exception(dataLeAk591);} catch (Exception leakErRor591) {dataLeAkPath591 = leakErRor591.getMessage();}
			android.util.Log.d("leak-591", dataLeAkPath591);
			theme = c.getString(0);
        }
        c.close();
        return theme;
    }

    public String readFile(File file) {

        String dataLeAk592 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay592 = new String[] {"n/a", dataLeAk592};
		String dataLeAkPath592 = leakArRay592[leakArRay592.length - 1];
		android.util.Log.d("leak-592", dataLeAkPath592);
		FileInputStream fis;
        String result;

        try {
            String dataLeAk593 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP593 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP593.put("test", new java.util.HashMap<String, String>());
			leakMaP593.get("test").put("test", dataLeAk593);
			String dataLeAkPath593 = leakMaP593.get("test").get("test");
			android.util.Log.d("leak-593", dataLeAkPath593);
			fis = new FileInputStream(file);
            result = readFile(fis);
            // dispose all the resources after using them.
            fis.close();

        } catch (FileNotFoundException e) {
            String dataLeAk594 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer594 = new StringBuffer();for (char chAr594 : dataLeAk594.toCharArray()) {leakBuFFer594.append(chAr594);}String dataLeAkPath594 = leakBuFFer594.toString();
			android.util.Log.d("leak-594", dataLeAkPath594);
			Log.e(TAG, "File not found", e);
            Toast.makeText(this, R.string.file_not_found, Toast.LENGTH_SHORT)
                    .show();
            return null;
        } catch (IOException e) {
            String dataLeAk595 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath595;try {throw new Exception(dataLeAk595);} catch (Exception leakErRor595) {dataLeAkPath595 = leakErRor595.getMessage();}
			android.util.Log.d("leak-595", dataLeAkPath595);
			Log.e(TAG, "File not found", e);
            Toast.makeText(
                    this, R.string.error_reading_file,
                    Toast.LENGTH_SHORT
            ).show();
            return null;
        }

        return result;
    }

    private String readFile(InputStream inputStream) {
        String dataLeAk596 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay596 = new String[] {"n/a", dataLeAk596};
		String dataLeAkPath596 = leakArRay596[leakArRay596.length - 1];
		android.util.Log.d("leak-596", dataLeAkPath596);
		StringBuilder sb = new StringBuilder();

        try {
            String dataLeAk597 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP597 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP597.put("test", new java.util.HashMap<String, String>());
			leakMaP597.get("test").put("test", dataLeAk597);
			String dataLeAkPath597 = leakMaP597.get("test").get("test");
			android.util.Log.d("leak-597", dataLeAkPath597);
			Reader in = new InputStreamReader(inputStream, "UTF-8");

            char[] buffer = new char[40960];
            int len;
            while ((len = in.read(buffer)) != -1) {
                String dataLeAk598 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer598 = new StringBuffer();for (char chAr598 : dataLeAk598.toCharArray()) {leakBuFFer598.append(chAr598);}String dataLeAkPath598 = leakBuFFer598.toString();
				android.util.Log.d("leak-598", dataLeAkPath598);
				sb.append(buffer, 0, len);
            }

        } catch (IOException e) {
            String dataLeAk599 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath599;try {throw new Exception(dataLeAk599);} catch (Exception leakErRor599) {dataLeAkPath599 = leakErRor599.getMessage();}
			android.util.Log.d("leak-599", dataLeAkPath599);
			Log.e(TAG, "File not found", e);
            Toast.makeText(
                    this, R.string.error_reading_file,
                    Toast.LENGTH_SHORT
            ).show();
            return null;
        }

        return sb.toString();
    }

    @Override
    protected void onResume() {
        super.onResume();
		String dataLeAk600 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay600 = new String[] {"n/a", dataLeAk600};
		String dataLeAkPath600 = leakArRay600[leakArRay600.length - 1];
		android.util.Log.d("leak-600", dataLeAkPath600);
        if (DEBUG) {
            String dataLeAk601 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP601 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP601.put("test", new java.util.HashMap<String, String>());
			leakMaP601.get("test").put("test", dataLeAk601);
			String dataLeAkPath601 = leakMaP601.get("test").get("test");
			android.util.Log.d("leak-601", dataLeAkPath601);
			Log.d(TAG, "onResume");
        }

        if (DEBUG) {
            String dataLeAk602 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer602 = new StringBuffer();for (char chAr602 : dataLeAk602.toCharArray()) {leakBuFFer602.append(chAr602);}String dataLeAkPath602 = leakBuFFer602.toString();
			android.util.Log.d("leak-602", dataLeAkPath602);
			Log.d(TAG, "mDecrypted: " + mDecryptedText);
        }

        // Set auto-link on or off, based on the current setting.
        int autoLink = PreferenceActivity.getAutoLinkFromPreference(this);

        mText.setAutoLinkMask(autoLink);

        mEncrypted = 0;

        if (mState == STATE_EDIT
                || (mState == STATE_INSERT)
                || mState == STATE_EDIT_EXTERNAL_NOTE) {
            String dataLeAk603 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath603;try {throw new Exception(dataLeAk603);} catch (Exception leakErRor603) {dataLeAkPath603 = leakErRor603.getMessage();}
					android.util.Log.d("leak-603", dataLeAkPath603);
			getNoteFromContentProvider();
        } else if (mState == STATE_EDIT_NOTE_FROM_SDCARD) {
            String dataLeAk604 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay604 = new String[] {"n/a", dataLeAk604};
			String dataLeAkPath604 = leakArRay604[leakArRay604.length - 1];
			android.util.Log.d("leak-604", dataLeAkPath604);
			getNoteFromFile();
        }

        if (mEncrypted == 0 || mDecryptedText != null) {
            String dataLeAk605 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP605 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP605.put("test", new java.util.HashMap<String, String>());
			leakMaP605.get("test").put("test", dataLeAk605);
			String dataLeAkPath605 = leakMaP605.get("test").get("test");
			android.util.Log.d("leak-605", dataLeAkPath605);
			applyInsertText();
        }

        // Make sure that we don't use the link movement method.
        // Instead, we need a blend between the arrow key movement (for regular
        // navigation) and
        // the link movement (so the user can click on links).
        mText.setMovementMethod(
                new ArrowKeyMovementMethod() {
                    public boolean onTouchEvent(TextView widget, Spannable buffer,
                                                MotionEvent event) {
                        String dataLeAk606 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													StringBuffer leakBuFFer606 = new StringBuffer();for (char chAr606 : dataLeAk606.toCharArray()) {leakBuFFer606.append(chAr606);}String dataLeAkPath606 = leakBuFFer606.toString();
													android.util.Log.d("leak-606", dataLeAkPath606);
						// This block is copied and pasted from LinkMovementMethod's
                        // onTouchEvent (without the part that actually changes the
                        // selection).
                        int action = event.getAction();

                        if (action == MotionEvent.ACTION_UP) {
                            String dataLeAk607 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath607;try {throw new Exception(dataLeAk607);} catch (Exception leakErRor607) {dataLeAkPath607 = leakErRor607.getMessage();}
							android.util.Log.d("leak-607", dataLeAkPath607);
							int x = (int) event.getX();
                            int y = (int) event.getY();

                            x -= widget.getTotalPaddingLeft();
                            y -= widget.getTotalPaddingTop();

                            x += widget.getScrollX();
                            y += widget.getScrollY();

                            Layout layout = widget.getLayout();
                            int line = layout.getLineForVertical(y);
                            int off = layout.getOffsetForHorizontal(line, x);

                            ClickableSpan[] link = buffer.getSpans(
                                    off, off,
                                    ClickableSpan.class
                            );

                            if (link.length != 0) {
                                String dataLeAk608 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String[] leakArRay608 = new String[] {"n/a", dataLeAk608};
								String dataLeAkPath608 = leakArRay608[leakArRay608.length - 1];
								android.util.Log.d("leak-608", dataLeAkPath608);
								link[0].onClick(widget);
                                return true;
                            }
                        }

                        return super.onTouchEvent(widget, buffer, event);
                    }
                }
        );

        setTheme(loadTheme());

        startupSearch();
    }

    // Handle search command from notes editor menu
    private void menuSearch() {
        String dataLeAk609 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP609 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP609.put("test", new java.util.HashMap<String, String>());
		leakMaP609.get("test").put("test", dataLeAk609);
		String dataLeAkPath609 = leakMaP609.get("test").get("test");
		android.util.Log.d("leak-609", dataLeAkPath609);
		LinearLayout searchLayout = (LinearLayout) findViewById(R.id.search);
        searchLayout.setVisibility(View.VISIBLE);
        EditText edt = (EditText) findViewById(R.id.edtSearchWord);
        edt.requestFocus();
    }

    // if editor was invoked from a global search, take over the search word and show the search panel
    private void startupSearch() {
        String dataLeAk610 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer610 = new StringBuffer();for (char chAr610 : dataLeAk610.toCharArray()) {leakBuFFer610.append(chAr610);}String dataLeAkPath610 = leakBuFFer610.toString();
		android.util.Log.d("leak-610", dataLeAkPath610);
		String searchString = getIntent().getStringExtra("SEARCH_STRING");
        if (searchString != null && !searchString.equals("")) {
            String dataLeAk611 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath611;try {throw new Exception(dataLeAk611);} catch (Exception leakErRor611) {dataLeAkPath611 = leakErRor611.getMessage();}
			android.util.Log.d("leak-611", dataLeAkPath611);
			LinearLayout searchLayout = (LinearLayout) findViewById(R.id.search);
            searchLayout.setVisibility(View.VISIBLE);
            EditText edt = (EditText) findViewById(R.id.edtSearchWord);
            edt.setText(searchString);
            mText.setSelection(0, 0);
            searchForward();
        }
    }

    // Initialize the search panel
    private void initSearchPanel() {
        String dataLeAk612 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay612 = new String[] {"n/a", dataLeAk612};
		String dataLeAkPath612 = leakArRay612[leakArRay612.length - 1];
		android.util.Log.d("leak-612", dataLeAkPath612);
		ImageButton mBtnForward = (ImageButton) findViewById(R.id.btnForward);
        mBtnForward.setOnClickListener(
                new OnClickListener() {
                    public void onClick(View v) {
                        String dataLeAk613 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP613 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP613.put("test", new java.util.HashMap<String, String>());
						leakMaP613.get("test").put("test", dataLeAk613);
						String dataLeAkPath613 = leakMaP613.get("test").get("test");
						android.util.Log.d("leak-613", dataLeAkPath613);
						searchForward();
                    }
                }
        );
        ImageButton mBtnBackward = (ImageButton) findViewById(R.id.btnBackward);
        mBtnBackward.setOnClickListener(
                new OnClickListener() {
                    public void onClick(View v) {
                        String dataLeAk614 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer614 = new StringBuffer();for (char chAr614 : dataLeAk614.toCharArray()) {leakBuFFer614.append(chAr614);}String dataLeAkPath614 = leakBuFFer614.toString();
						android.util.Log.d("leak-614", dataLeAkPath614);
						searchBackward();
                    }
                }
        );
        ImageButton btnClose = (ImageButton) findViewById(R.id.btnClose);
        btnClose.setOnClickListener(
                new OnClickListener() {
                    public void onClick(View v) {
                        String dataLeAk615 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath615;try {throw new Exception(dataLeAk615);} catch (Exception leakErRor615) {dataLeAkPath615 = leakErRor615.getMessage();}
						android.util.Log.d("leak-615", dataLeAkPath615);
						LinearLayout searchLayout = (LinearLayout) findViewById(R.id.search);
                        searchLayout.setVisibility(View.GONE);
                    }
                }
        );
    }

    // Search forward from current selection
    private void searchForward() {
        String dataLeAk616 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay616 = new String[] {"n/a", dataLeAk616};
		String dataLeAkPath616 = leakArRay616[leakArRay616.length - 1];
		android.util.Log.d("leak-616", dataLeAkPath616);
		EditText edt = (EditText) findViewById(R.id.edtSearchWord);
        String search = edt.getText().toString();
        if (search != null && !search.equals("")) {
            String dataLeAk617 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP617 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP617.put("test", new java.util.HashMap<String, String>());
			leakMaP617.get("test").put("test", dataLeAk617);
			String dataLeAkPath617 = leakMaP617.get("test").get("test");
			android.util.Log.d("leak-617", dataLeAkPath617);
			String text = mText.getText().toString();
            if (text != null && !text.equals("")) {
                String dataLeAk618 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer618 = new StringBuffer();for (char chAr618 : dataLeAk618.toCharArray()) {leakBuFFer618.append(chAr618);}String dataLeAkPath618 = leakBuFFer618.toString();
				android.util.Log.d("leak-618", dataLeAkPath618);
				int start = text.toUpperCase().indexOf(search.toUpperCase(), mText.getSelectionEnd());
                if (start != -1) {
                    String dataLeAk619 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath619;try {throw new Exception(dataLeAk619);} catch (Exception leakErRor619) {dataLeAkPath619 = leakErRor619.getMessage();}
					android.util.Log.d("leak-619", dataLeAkPath619);
					mText.requestFocus();
                    mText.setSelection(start, start + search.length());
                } else {
                    String dataLeAk620 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay620 = new String[] {"n/a", dataLeAk620};
					String dataLeAkPath620 = leakArRay620[leakArRay620.length - 1];
					android.util.Log.d("leak-620", dataLeAkPath620);
					mText.setSelection(0); // not found, set cursor at beginning of text
                    Toast toast = Toast.makeText(
                            getApplicationContext(),
                            getText(R.string.toast_wrap_bottom), Toast.LENGTH_SHORT
                    );
                    toast.show();
                }
            }
        }
    }

    // Search backwards from current selection
    private void searchBackward() {
        String dataLeAk621 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP621 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP621.put("test", new java.util.HashMap<String, String>());
		leakMaP621.get("test").put("test", dataLeAk621);
		String dataLeAkPath621 = leakMaP621.get("test").get("test");
		android.util.Log.d("leak-621", dataLeAkPath621);
		EditText edt = (EditText) findViewById(R.id.edtSearchWord);
        String search = edt.getText().toString();
        if (search != null && !search.equals("")) {
            String dataLeAk622 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer622 = new StringBuffer();for (char chAr622 : dataLeAk622.toCharArray()) {leakBuFFer622.append(chAr622);}String dataLeAkPath622 = leakBuFFer622.toString();
			android.util.Log.d("leak-622", dataLeAkPath622);
			String text = mText.getText().toString();
            if (text != null && !text.equals("")) {
                String dataLeAk623 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath623;try {throw new Exception(dataLeAk623);} catch (Exception leakErRor623) {dataLeAkPath623 = leakErRor623.getMessage();}
				android.util.Log.d("leak-623", dataLeAkPath623);
				int start = text.toUpperCase().lastIndexOf(search.toUpperCase(), mText.getSelectionStart() - 1);
                if (start != -1) {
                    String dataLeAk624 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay624 = new String[] {"n/a", dataLeAk624};
					String dataLeAkPath624 = leakArRay624[leakArRay624.length - 1];
					android.util.Log.d("leak-624", dataLeAkPath624);
					mText.requestFocus();
                    mText.setSelection(start, start + search.length());
                } else {
                    String dataLeAk625 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP625 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP625.put("test", new java.util.HashMap<String, String>());
					leakMaP625.get("test").put("test", dataLeAk625);
					String dataLeAkPath625 = leakMaP625.get("test").get("test");
					android.util.Log.d("leak-625", dataLeAkPath625);
					mText.setSelection(text.length()); // not found, set cursor at end of text
                    Toast toast = Toast.makeText(
                            getApplicationContext(),
                            getText(R.string.toast_wrap_top), Toast.LENGTH_SHORT
                    );
                    toast.show();
                }
            }
        }
    }

    private void getNoteFromContentProvider() {
        String dataLeAk626 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer626 = new StringBuffer();for (char chAr626 : dataLeAk626.toCharArray()) {leakBuFFer626.append(chAr626);}String dataLeAkPath626 = leakBuFFer626.toString();
		android.util.Log.d("leak-626", dataLeAkPath626);
		// If we didn't have any trouble retrieving the data, it is now
        // time to get at the stuff.
        if (mCursor != null && mCursor.requery() && mCursor.moveToFirst()) {

            String dataLeAk627 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath627;try {throw new Exception(dataLeAk627);} catch (Exception leakErRor627) {dataLeAkPath627 = leakErRor627.getMessage();}
			android.util.Log.d("leak-627", dataLeAkPath627);
			// Modify our overall title depending on the mode we are running in.
            if (mState == STATE_EDIT || mState == STATE_EDIT_EXTERNAL_NOTE) {
                String dataLeAk628 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay628 = new String[] {"n/a", dataLeAk628};
				String dataLeAkPath628 = leakArRay628[leakArRay628.length - 1];
				android.util.Log.d("leak-628", dataLeAkPath628);
				setTitle(getText(R.string.title_edit));
            } else if (mState == STATE_INSERT) {
                String dataLeAk629 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP629 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP629.put("test", new java.util.HashMap<String, String>());
				leakMaP629.get("test").put("test", dataLeAk629);
				String dataLeAkPath629 = leakMaP629.get("test").get("test");
				android.util.Log.d("leak-629", dataLeAkPath629);
				setTitle(getText(R.string.title_create));
            }

            // This always has to be available
            long id = mCursor.getLong(mCursor.getColumnIndex(Notes._ID));
            String note;

            if (mState == STATE_EDIT_EXTERNAL_NOTE) {
                // Check if the other columns are available

                String dataLeAk630 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer630 = new StringBuffer();for (char chAr630 : dataLeAk630.toCharArray()) {leakBuFFer630.append(chAr630);}String dataLeAkPath630 = leakBuFFer630.toString();
				android.util.Log.d("leak-630", dataLeAkPath630);
				// Note
                if (hasNoteColumn) {
                    String dataLeAk631 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath631;try {throw new Exception(dataLeAk631);} catch (Exception leakErRor631) {dataLeAkPath631 = leakErRor631.getMessage();}
					android.util.Log.d("leak-631", dataLeAkPath631);
					note = mCursor
                            .getString(mCursor.getColumnIndex(Notes.NOTE));
                } else {
                    String dataLeAk632 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay632 = new String[] {"n/a", dataLeAk632};
					String dataLeAkPath632 = leakArRay632[leakArRay632.length - 1];
					android.util.Log.d("leak-632", dataLeAkPath632);
					note = "";
                }

                // Encrypted
                mEncrypted = isNoteUnencrypted() ? 0 : 1;

                // Theme
                if (hasThemeColumn) {
                    String dataLeAk633 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP633 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP633.put("test", new java.util.HashMap<String, String>());
					leakMaP633.get("test").put("test", dataLeAk633);
					String dataLeAkPath633 = leakMaP633.get("test").get("test");
					android.util.Log.d("leak-633", dataLeAkPath633);
					mTheme = mCursor.getString(
                            mCursor
                                    .getColumnIndex(Notes.THEME)
                    );
                } else {
                    String dataLeAk634 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer634 = new StringBuffer();for (char chAr634 : dataLeAk634.toCharArray()) {leakBuFFer634.append(chAr634);}String dataLeAkPath634 = leakBuFFer634.toString();
					android.util.Log.d("leak-634", dataLeAkPath634);
					note = "";
                }

                // Selection start
                if (hasSelection_startColumn) {
                    String dataLeAk635 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath635;try {throw new Exception(dataLeAk635);} catch (Exception leakErRor635) {dataLeAkPath635 = leakErRor635.getMessage();}
					android.util.Log.d("leak-635", dataLeAkPath635);
					mSelectionStart = mCursor.getInt(
                            mCursor
                                    .getColumnIndex(Notes.SELECTION_START)
                    );
                } else {
                    String dataLeAk636 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay636 = new String[] {"n/a", dataLeAk636};
					String dataLeAkPath636 = leakArRay636[leakArRay636.length - 1];
					android.util.Log.d("leak-636", dataLeAkPath636);
					mSelectionStart = 0;
                }

                // Selection end
                if (hasSelection_endColumn) {
                    String dataLeAk637 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP637 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP637.put("test", new java.util.HashMap<String, String>());
					leakMaP637.get("test").put("test", dataLeAk637);
					String dataLeAkPath637 = leakMaP637.get("test").get("test");
					android.util.Log.d("leak-637", dataLeAkPath637);
					mSelectionStop = mCursor.getInt(
                            mCursor
                                    .getColumnIndex(Notes.SELECTION_END)
                    );
                } else {
                    String dataLeAk638 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer638 = new StringBuffer();for (char chAr638 : dataLeAk638.toCharArray()) {leakBuFFer638.append(chAr638);}String dataLeAkPath638 = leakBuFFer638.toString();
					android.util.Log.d("leak-638", dataLeAkPath638);
					mSelectionStop = 0;
                }
            } else {
                String dataLeAk639 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath639;try {throw new Exception(dataLeAk639);} catch (Exception leakErRor639) {dataLeAkPath639 = leakErRor639.getMessage();}
				android.util.Log.d("leak-639", dataLeAkPath639);
				// We know for sure all the columns are available
                note = mCursor.getString(COLUMN_INDEX_NOTE);
                mEncrypted = mCursor.getLong(COLUMN_INDEX_ENCRYPTED);
                mTheme = mCursor.getString(COLUMN_INDEX_THEME);
                mSelectionStart = mCursor.getInt(COLUMN_INDEX_SELECTION_START);
                mSelectionStop = mCursor.getInt(COLUMN_INDEX_SELECTION_END);
            }

            if (mEncrypted == 0) {
                // Not encrypted

                String dataLeAk640 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay640 = new String[] {"n/a", dataLeAk640};
				String dataLeAkPath640 = leakArRay640[leakArRay640.length - 1];
				android.util.Log.d("leak-640", dataLeAkPath640);
				// This is a little tricky: we may be resumed after previously
                // being
                // paused/stopped. We want to put the new text in the text view,
                // but leave the user where they were (retain the cursor
                // position
                // etc). This version of setText does that for us.
                if (!note.equals(mText.getText().toString())) {
                    String dataLeAk641 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP641 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP641.put("test", new java.util.HashMap<String, String>());
					leakMaP641.get("test").put("test", dataLeAk641);
					String dataLeAkPath641 = leakMaP641.get("test").get("test");
					android.util.Log.d("leak-641", dataLeAkPath641);
					mText.setTextKeepState(note);
                    // keep state does not work, so we have to do it manually:
                    mText.setSelection(mSelectionStart, mSelectionStop);
                }
            } else {
                String dataLeAk642 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer642 = new StringBuffer();for (char chAr642 : dataLeAk642.toCharArray()) {leakBuFFer642.append(chAr642);}String dataLeAkPath642 = leakBuFFer642.toString();
				android.util.Log.d("leak-642", dataLeAkPath642);
				if (mDecryptedText != null) {
                    String dataLeAk643 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath643;try {throw new Exception(dataLeAk643);} catch (Exception leakErRor643) {dataLeAkPath643 = leakErRor643.getMessage();}
					android.util.Log.d("leak-643", dataLeAkPath643);
					// Text had already been decrypted, use that:
                    if (DEBUG) {
                        String dataLeAk644 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay644 = new String[] {"n/a", dataLeAk644};
						String dataLeAkPath644 = leakArRay644[leakArRay644.length - 1];
						android.util.Log.d("leak-644", dataLeAkPath644);
						Log.d(
                                TAG, "set decrypted text as mText: "
                                        + mDecryptedText
                        );
                    }
                    mText.setTextKeepState(mDecryptedText);
                    // keep state does not work, so we have to do it manually:
                    mText.setSelection(mSelectionStart, mSelectionStop);

                    if (!mActionBarAvailable) {
                        String dataLeAk645 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP645 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP645.put("test", new java.util.HashMap<String, String>());
						leakMaP645.get("test").put("test", dataLeAk645);
						String dataLeAkPath645 = leakMaP645.get("test").get("test");
						android.util.Log.d("leak-645", dataLeAkPath645);
						setFeatureDrawableResource(
                                Window.FEATURE_RIGHT_ICON,
                                android.R.drawable.ic_lock_idle_lock
                        );
                    }
                } else {
                    String dataLeAk646 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer646 = new StringBuffer();for (char chAr646 : dataLeAk646.toCharArray()) {leakBuFFer646.append(chAr646);}String dataLeAkPath646 = leakBuFFer646.toString();
					android.util.Log.d("leak-646", dataLeAkPath646);
					// Decrypt note
                    if (DEBUG) {
                        String dataLeAk647 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath647;try {throw new Exception(dataLeAk647);} catch (Exception leakErRor647) {dataLeAkPath647 = leakErRor647.getMessage();}
						android.util.Log.d("leak-647", dataLeAkPath647);
						Log.d(TAG, "Decrypt note: " + note);
                    }

                    // Overwrite mText because it may contain unencrypted note
                    // from savedInstanceState.
                    // mText.setText(R.string.encrypted);

                    Intent i = new Intent();
                    i.setAction(CryptoIntents.ACTION_DECRYPT);
                    i.putExtra(CryptoIntents.EXTRA_TEXT, note);
                    i.putExtra(PrivateNotePadIntents.EXTRA_ID, id);

                    try {
                        String dataLeAk648 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay648 = new String[] {"n/a", dataLeAk648};
						String dataLeAkPath648 = leakArRay648[leakArRay648.length - 1];
						android.util.Log.d("leak-648", dataLeAkPath648);
						if (checkCallingOrSelfPermission(CryptoIntents.PERMISSION_SAFE_ACCESS_INTENTS) == PackageManager.PERMISSION_GRANTED) {
                            String dataLeAk649 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP649 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP649.put("test", new java.util.HashMap<String, String>());
							leakMaP649.get("test").put("test", dataLeAk649);
							String dataLeAkPath649 = leakMaP649.get("test").get("test");
							android.util.Log.d("leak-649", dataLeAkPath649);
							startActivityForResult(i, REQUEST_CODE_DECRYPT);
                        } else {
                            String dataLeAk650 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer650 = new StringBuffer();for (char chAr650 : dataLeAk650.toCharArray()) {leakBuFFer650.append(chAr650);}String dataLeAkPath650 = leakBuFFer650.toString();
							android.util.Log.d("leak-650", dataLeAkPath650);
							Toast.makeText(
                                    this, R.string.decryption_failed_due_to_permissions,
                                    Toast.LENGTH_SHORT
                            ).show();
                        }
                    } catch (ActivityNotFoundException e) {
                        String dataLeAk651 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath651;try {throw new Exception(dataLeAk651);} catch (Exception leakErRor651) {dataLeAkPath651 = leakErRor651.getMessage();}
						android.util.Log.d("leak-651", dataLeAkPath651);
						Toast.makeText(
                                this, R.string.decryption_failed,
                                Toast.LENGTH_SHORT
                        ).show();
                        Log.e(TAG, "failed to invoke decrypt");
                    }
                }
            }

            // If we hadn't previously retrieved the original text, do so
            // now. This allows the user to revert their changes.
            if (mOriginalContent == null) {
                String dataLeAk652 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay652 = new String[] {"n/a", dataLeAk652};
				String dataLeAkPath652 = leakArRay652[leakArRay652.length - 1];
				android.util.Log.d("leak-652", dataLeAkPath652);
				mOriginalContent = note;
            }

        } else {
            String dataLeAk653 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP653 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP653.put("test", new java.util.HashMap<String, String>());
			leakMaP653.get("test").put("test", dataLeAk653);
			String dataLeAkPath653 = leakMaP653.get("test").get("test");
			android.util.Log.d("leak-653", dataLeAkPath653);
			setTitle(getText(R.string.error_title));
            mText.setText(getText(R.string.error_message));
        }
    }

    private void getNoteFromFile() {
        String dataLeAk654 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer654 = new StringBuffer();for (char chAr654 : dataLeAk654.toCharArray()) {leakBuFFer654.append(chAr654);}String dataLeAkPath654 = leakBuFFer654.toString();
		android.util.Log.d("leak-654", dataLeAkPath654);
		if (DEBUG) {
            String dataLeAk655 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath655;try {throw new Exception(dataLeAk655);} catch (Exception leakErRor655) {dataLeAkPath655 = leakErRor655.getMessage();}
			android.util.Log.d("leak-655", dataLeAkPath655);
			Log.d(TAG, "file: " + mFileContent);
        }
        if (mFileContent == null) {
            String dataLeAk656 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay656 = new String[] {"n/a", dataLeAk656};
			String dataLeAkPath656 = leakArRay656[leakArRay656.length - 1];
			android.util.Log.d("leak-656", dataLeAkPath656);
			// TODO
            mFileContent = "error";
            mReadOnly = true;
        }

        mText.setTextKeepState(mFileContent);

        // keep state does not work, so we have to do it manually:
        try {
            String dataLeAk657 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP657 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP657.put("test", new java.util.HashMap<String, String>());
			leakMaP657.get("test").put("test", dataLeAk657);
			String dataLeAkPath657 = leakMaP657.get("test").get("test");
			android.util.Log.d("leak-657", dataLeAkPath657);
			mText.setSelection(mSelectionStart, mSelectionStop);
        } catch (IndexOutOfBoundsException e) {
			String dataLeAk658 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer658 = new StringBuffer();for (char chAr658 : dataLeAk658.toCharArray()) {leakBuFFer658.append(chAr658);}String dataLeAkPath658 = leakBuFFer658.toString();
			android.util.Log.d("leak-658", dataLeAkPath658);
            // Then let's not adjust the selection.
        }

        // If we hadn't previously retrieved the original text, do so
        // now. This allows the user to revert their changes.
        if (mOriginalContent == null) {
            String dataLeAk659 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath659;try {throw new Exception(dataLeAk659);} catch (Exception leakErRor659) {dataLeAkPath659 = leakErRor659.getMessage();}
			android.util.Log.d("leak-659", dataLeAkPath659);
			mOriginalContent = mFileContent;
        }

        updateTitleSdCard();
    }

    private void updateTitleSdCard() {
        String dataLeAk660 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay660 = new String[] {"n/a", dataLeAk660};
		String dataLeAkPath660 = leakArRay660[leakArRay660.length - 1];
		android.util.Log.d("leak-660", dataLeAkPath660);
		String modified = "";
        if (mOriginalContent != null && !mOriginalContent.equals(mFileContent)) {
            String dataLeAk661 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP661 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP661.put("test", new java.util.HashMap<String, String>());
			leakMaP661.get("test").put("test", dataLeAk661);
			String dataLeAkPath661 = leakMaP661.get("test").get("test");
			android.util.Log.d("leak-661", dataLeAkPath661);
			modified = "* ";
        }
        String filename = FileUriUtils.getFilename(mUri);
        setTitle(modified + filename);
        // setTitle(getString(R.string.title_edit_file, modified + filename));
        // setFeatureDrawableResource(Window.FEATURE_RIGHT_ICON,
        // android.R.drawable.ic_menu_save);
    }

    //
    // method related to pause
    //

    private void updateCharCount() {
        String dataLeAk662 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer662 = new StringBuffer();for (char chAr662 : dataLeAk662.toCharArray()) {leakBuFFer662.append(chAr662);}String dataLeAkPath662 = leakBuFFer662.toString();
		android.util.Log.d("leak-662", dataLeAkPath662);
		boolean charCountVisible = false;
        String currentTitle = getTitle().toString();
        if (currentTitle.startsWith("[")) {
            String dataLeAk663 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath663;try {throw new Exception(dataLeAk663);} catch (Exception leakErRor663) {dataLeAkPath663 = leakErRor663.getMessage();}
			android.util.Log.d("leak-663", dataLeAkPath663);
			charCountVisible = true;
        }
        if (PreferenceActivity.getCharCountEnabledFromPrefs(this)) {
            String dataLeAk664 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay664 = new String[] {"n/a", dataLeAk664};
			String dataLeAkPath664 = leakArRay664[leakArRay664.length - 1];
			android.util.Log.d("leak-664", dataLeAkPath664);
			if (charCountVisible) {
                String dataLeAk665 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP665 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP665.put("test", new java.util.HashMap<String, String>());
				leakMaP665.get("test").put("test", dataLeAk665);
				String dataLeAkPath665 = leakMaP665.get("test").get("test");
				android.util.Log.d("leak-665", dataLeAkPath665);
				setTitle(
                        "[" + mText.length() + "]"
                                + currentTitle.substring(currentTitle.indexOf(" "))
                );
            } else {
                String dataLeAk666 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer666 = new StringBuffer();for (char chAr666 : dataLeAk666.toCharArray()) {leakBuFFer666.append(chAr666);}String dataLeAkPath666 = leakBuFFer666.toString();
				android.util.Log.d("leak-666", dataLeAkPath666);
				setTitle("[" + mText.length() + "] " + currentTitle);
            }
        } else {
            String dataLeAk667 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath667;try {throw new Exception(dataLeAk667);} catch (Exception leakErRor667) {dataLeAkPath667 = leakErRor667.getMessage();}
			android.util.Log.d("leak-667", dataLeAkPath667);
			if (charCountVisible) {
                String dataLeAk668 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay668 = new String[] {"n/a", dataLeAk668};
				String dataLeAkPath668 = leakArRay668[leakArRay668.length - 1];
				android.util.Log.d("leak-668", dataLeAkPath668);
				setTitle(currentTitle.substring(currentTitle.indexOf(" ")));
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        String dataLeAk669 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP669 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP669.put("test", new java.util.HashMap<String, String>());
		leakMaP669.get("test").put("test", dataLeAk669);
		String dataLeAkPath669 = leakMaP669.get("test").get("test");
		android.util.Log.d("leak-669", dataLeAkPath669);
		if (DEBUG) {
            String dataLeAk670 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer670 = new StringBuffer();for (char chAr670 : dataLeAk670.toCharArray()) {leakBuFFer670.append(chAr670);}String dataLeAkPath670 = leakBuFFer670.toString();
			android.util.Log.d("leak-670", dataLeAkPath670);
			Log.d(TAG, "onSaveInstanceState");
        }
        // if (DEBUG) Log.d(TAG, "file content: " + mFileContent);

        // Save away the original text, so we still have it if the activity
        // needs to be killed while paused.
        mSelectionStart = mText.getSelectionStart();
        mSelectionStop = mText.getSelectionEnd();
        mFileContent = mText.getText().toString();

        if (DEBUG) {
            String dataLeAk671 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath671;try {throw new Exception(dataLeAk671);} catch (Exception leakErRor671) {dataLeAkPath671 = leakErRor671.getMessage();}
			android.util.Log.d("leak-671", dataLeAkPath671);
			Log.d(
                    TAG, "Selection " + mSelectionStart + " - " + mSelectionStop
                            + " for text : " + mFileContent
            );
        }

        outState.putString(BUNDLE_ORIGINAL_CONTENT, mOriginalContent);
        outState.putString(BUNDLE_UNDO_REVERT, mUndoRevert);
        outState.putInt(BUNDLE_STATE, mState);
        if (mUri != null) {
            String dataLeAk672 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay672 = new String[] {"n/a", dataLeAk672};
			String dataLeAkPath672 = leakArRay672[leakArRay672.length - 1];
			android.util.Log.d("leak-672", dataLeAkPath672);
			outState.putString(BUNDLE_URI, mUri.toString());
        }
        outState.putInt(BUNDLE_SELECTION_START, mSelectionStart);
        outState.putInt(BUNDLE_SELECTION_STOP, mSelectionStop);
        outState.putString(BUNDLE_FILE_CONTENT, mFileContent);
        outState.putString(BUNDLE_APPLY_TEXT, mApplyText);
        outState.putString(BUNDLE_APPLY_TEXT_BEFORE, mApplyTextBefore);
        outState.putString(BUNDLE_APPLY_TEXT_AFTER, mApplyTextAfter);
    }

    @Override
    protected void onPause() {
        super.onPause();
		String dataLeAk673 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP673 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP673.put("test", new java.util.HashMap<String, String>());
		leakMaP673.get("test").put("test", dataLeAk673);
		String dataLeAkPath673 = leakMaP673.get("test").get("test");
		android.util.Log.d("leak-673", dataLeAkPath673);
        if (DEBUG) {
            String dataLeAk674 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer674 = new StringBuffer();for (char chAr674 : dataLeAk674.toCharArray()) {leakBuFFer674.append(chAr674);}String dataLeAkPath674 = leakBuFFer674.toString();
			android.util.Log.d("leak-674", dataLeAkPath674);
			Log.d(TAG, "onPause");
        }

        mText.setAutoLinkMask(0);

        // The user is going somewhere else, so make sure their current
        // changes are safely saved away in the provider. We don't need
        // to do this if only editing.
        if (mCursor != null) {

            String dataLeAk675 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath675;try {throw new Exception(dataLeAk675);} catch (Exception leakErRor675) {dataLeAkPath675 = leakErRor675.getMessage();}
			android.util.Log.d("leak-675", dataLeAkPath675);
			mCursor.moveToFirst();

            if (isNoteUnencrypted()) {
                String dataLeAk676 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay676 = new String[] {"n/a", dataLeAk676};
				String dataLeAkPath676 = leakArRay676[leakArRay676.length - 1];
				android.util.Log.d("leak-676", dataLeAkPath676);
				String text = mText.getText().toString();
                int length = text.length();

                // If this activity is finished, and there is no text, then we
                // do something a little special: simply delete the note entry.
                // Note that we do this both for editing and inserting... it
                // would be reasonable to only do it when inserting.
                if (isFinishing() && (length == 0) && !mNoteOnly) {
                    String dataLeAk677 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP677 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP677.put("test", new java.util.HashMap<String, String>());
					leakMaP677.get("test").put("test", dataLeAk677);
					String dataLeAkPath677 = leakMaP677.get("test").get("test");
					android.util.Log.d("leak-677", dataLeAkPath677);
					setResult(RESULT_CANCELED);
                    deleteNote();

                    // Get out updates into the provider.
                } else {
                    String dataLeAk678 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer678 = new StringBuffer();for (char chAr678 : dataLeAk678.toCharArray()) {leakBuFFer678.append(chAr678);}String dataLeAkPath678 = leakBuFFer678.toString();
					android.util.Log.d("leak-678", dataLeAkPath678);
					ContentValues values = new ContentValues();

                    // This stuff is only done when working with a full-fledged
                    // note.
                    if (!mNoteOnly) {
                        String dataLeAk679 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath679;try {throw new Exception(dataLeAk679);} catch (Exception leakErRor679) {dataLeAkPath679 = leakErRor679.getMessage();}
						android.util.Log.d("leak-679", dataLeAkPath679);
						String oldText = "";
                        Cursor cursor = getContentResolver().query(
                                mUri,
                                new String[]{"note"}, null, null, null
                        );
                        if (cursor.moveToFirst()) {
                            String dataLeAk680 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay680 = new String[] {"n/a", dataLeAk680};
							String dataLeAkPath680 = leakArRay680[leakArRay680.length - 1];
							android.util.Log.d("leak-680", dataLeAkPath680);
							oldText = cursor.getString(0);
                        }
                        if (!oldText.equals(text)) {
                            String dataLeAk681 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP681 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP681.put("test", new java.util.HashMap<String, String>());
							leakMaP681.get("test").put("test", dataLeAk681);
							String dataLeAkPath681 = leakMaP681.get("test").get("test");
							android.util.Log.d("leak-681", dataLeAkPath681);
							// Bump the modification time to now.
                            values.put(
                                    Notes.MODIFIED_DATE,
                                    System.currentTimeMillis()
                            );
                        }

                        String title;
                        if (!PreferenceActivity.getMarqueeFromPrefs(this)) {
                            String dataLeAk682 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer682 = new StringBuffer();for (char chAr682 : dataLeAk682.toCharArray()) {leakBuFFer682.append(chAr682);}String dataLeAkPath682 = leakBuFFer682.toString();
							android.util.Log.d("leak-682", dataLeAkPath682);
							title = ExtractTitle.extractTitle(text);
                        } else {
                            String dataLeAk683 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath683;try {throw new Exception(dataLeAk683);} catch (Exception leakErRor683) {dataLeAkPath683 = leakErRor683.getMessage();}
							android.util.Log.d("leak-683", dataLeAkPath683);
							title = text;
                        }
                        values.put(Notes.TITLE, title);
                    }

                    // Write our text back into the provider.
                    if (hasNoteColumn) {
                        String dataLeAk684 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay684 = new String[] {"n/a", dataLeAk684};
						String dataLeAkPath684 = leakArRay684[leakArRay684.length - 1];
						android.util.Log.d("leak-684", dataLeAkPath684);
						values.put(Notes.NOTE, text);
                    }
                    if (hasThemeColumn) {
                        String dataLeAk685 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP685 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP685.put("test", new java.util.HashMap<String, String>());
						leakMaP685.get("test").put("test", dataLeAk685);
						String dataLeAkPath685 = leakMaP685.get("test").get("test");
						android.util.Log.d("leak-685", dataLeAkPath685);
						values.put(Notes.THEME, mTheme);
                    }
                    if (hasSelection_startColumn) {
                        String dataLeAk686 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer686 = new StringBuffer();for (char chAr686 : dataLeAk686.toCharArray()) {leakBuFFer686.append(chAr686);}String dataLeAkPath686 = leakBuFFer686.toString();
						android.util.Log.d("leak-686", dataLeAkPath686);
						values.put(
                                Notes.SELECTION_START,
                                mText.getSelectionStart()
                        );
                    }
                    if (hasSelection_endColumn) {
                        String dataLeAk687 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath687;try {throw new Exception(dataLeAk687);} catch (Exception leakErRor687) {dataLeAkPath687 = leakErRor687.getMessage();}
						android.util.Log.d("leak-687", dataLeAkPath687);
						values.put(Notes.SELECTION_END, mText.getSelectionEnd());
                    }

                    // Commit all of our changes to persistent storage. When the
                    // update completes
                    // the content provider will notify the cursor of the
                    // change, which will
                    // cause the UI to be updated.
                    getContentResolver().update(mUri, values, null, null);
                }
            } else {
                // encrypted note: First encrypt and store encrypted note:

                String dataLeAk688 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay688 = new String[] {"n/a", dataLeAk688};
				String dataLeAkPath688 = leakArRay688[leakArRay688.length - 1];
				android.util.Log.d("leak-688", dataLeAkPath688);
				// Save current theme:
                ContentValues values = new ContentValues();

                if (hasThemeColumn) {
                    String dataLeAk689 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP689 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP689.put("test", new java.util.HashMap<String, String>());
					leakMaP689.get("test").put("test", dataLeAk689);
					String dataLeAkPath689 = leakMaP689.get("test").get("test");
					android.util.Log.d("leak-689", dataLeAkPath689);
					values.put(Notes.THEME, mTheme);
                }

                getContentResolver().update(mUri, values, null, null);

                if (mDecryptedText != null) {
                    // Decrypted had been decrypted.
                    // We take the current version from 'text' and encrypt it.

                    String dataLeAk690 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer690 = new StringBuffer();for (char chAr690 : dataLeAk690.toCharArray()) {leakBuFFer690.append(chAr690);}String dataLeAkPath690 = leakBuFFer690.toString();
					android.util.Log.d("leak-690", dataLeAkPath690);
					encryptNote(false);

                    // Remove displayed note.
                    // mText.setText(R.string.encrypted);
                }
            }
        }
    }

    /**
     * Encrypt the current note.
     *
     * @param encryptTags
     */
    private void encryptNote(boolean encryptTags) {
        String dataLeAk691 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath691;try {throw new Exception(dataLeAk691);} catch (Exception leakErRor691) {dataLeAkPath691 = leakErRor691.getMessage();}
		android.util.Log.d("leak-691", dataLeAkPath691);
		String text = mText.getText().toString();
        String title;
        if (!PreferenceActivity.getMarqueeFromPrefs(this)) {
            String dataLeAk692 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay692 = new String[] {"n/a", dataLeAk692};
			String dataLeAkPath692 = leakArRay692[leakArRay692.length - 1];
			android.util.Log.d("leak-692", dataLeAkPath692);
			title = ExtractTitle.extractTitle(text);
        } else {
            String dataLeAk693 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP693 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP693.put("test", new java.util.HashMap<String, String>());
			leakMaP693.get("test").put("test", dataLeAk693);
			String dataLeAkPath693 = leakMaP693.get("test").get("test");
			android.util.Log.d("leak-693", dataLeAkPath693);
			title = text;
        }
        String tags = getTags();
        // Log.i(TAG, "encrypt tags: " + tags);

        boolean isNoteEncrypted = !isNoteUnencrypted();

        if (!encryptTags) {
            String dataLeAk694 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer694 = new StringBuffer();for (char chAr694 : dataLeAk694.toCharArray()) {leakBuFFer694.append(chAr694);}String dataLeAkPath694 = leakBuFFer694.toString();
			android.util.Log.d("leak-694", dataLeAkPath694);
			tags = null;
        }

        if (DEBUG) {
            String dataLeAk695 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath695;try {throw new Exception(dataLeAk695);} catch (Exception leakErRor695) {dataLeAkPath695 = leakErRor695.getMessage();}
			android.util.Log.d("leak-695", dataLeAkPath695);
			Log.d(TAG, "encrypt note: " + text);
        }

        if (EncryptActivity.getPendingEncryptActivities() == 0) {
            String dataLeAk696 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay696 = new String[] {"n/a", dataLeAk696};
			String dataLeAkPath696 = leakArRay696[leakArRay696.length - 1];
			android.util.Log.d("leak-696", dataLeAkPath696);
			Intent i = new Intent(this, EncryptActivity.class);
            i.putExtra(
                    PrivateNotePadIntents.EXTRA_ACTION,
                    CryptoIntents.ACTION_ENCRYPT
            );
            i.putExtra(
                    CryptoIntents.EXTRA_TEXT_ARRAY,
                    EncryptActivity.getCryptoStringArray(text, title, tags)
            );
            i.putExtra(PrivateNotePadIntents.EXTRA_URI, mUri.toString());
            if (text.equals(mOriginalContent) && isNoteEncrypted) {
                String dataLeAk697 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP697 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP697.put("test", new java.util.HashMap<String, String>());
				leakMaP697.get("test").put("test", dataLeAk697);
				String dataLeAkPath697 = leakMaP697.get("test").get("test");
				android.util.Log.d("leak-697", dataLeAkPath697);
				// No need to encrypt, content was not modified.
                i.putExtra(PrivateNotePadIntents.EXTRA_CONTENT_UNCHANGED, true);
            }
            startActivity(i);

            // Remove knowledge of the decrypted note.
            // If encryption fails because one has been locked out, (another)
            // user
            // should not be able to see note again from cache.
            if (DEBUG) {
                String dataLeAk698 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer698 = new StringBuffer();for (char chAr698 : dataLeAk698.toCharArray()) {leakBuFFer698.append(chAr698);}String dataLeAkPath698 = leakBuFFer698.toString();
				android.util.Log.d("leak-698", dataLeAkPath698);
				Log.d(TAG, "using static decrypted text: " + text);
            }
            sDecryptedText = text;
            if (isNoteEncrypted) {
                String dataLeAk699 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath699;try {throw new Exception(dataLeAk699);} catch (Exception leakErRor699) {dataLeAkPath699 = leakErRor699.getMessage();}
				android.util.Log.d("leak-699", dataLeAkPath699);
				// Already encrypted
                mDecryptedText = null;
                mText.setText(R.string.encrypted);
            } else {
				String dataLeAk700 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay700 = new String[] {"n/a", dataLeAk700};
				String dataLeAkPath700 = leakArRay700[leakArRay700.length - 1];
				android.util.Log.d("leak-700", dataLeAkPath700);
                // not yet encrypted, but we want to encrypt.
                // Leave mText until note is really encrypted
                // (in case password is not entered or OI Safw not installed)
            }
            EncryptActivity.confirmEncryptActivityCalled();
        } else {
            String dataLeAk701 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP701 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP701.put("test", new java.util.HashMap<String, String>());
			leakMaP701.get("test").put("test", dataLeAk701);
			String dataLeAkPath701 = leakMaP701.get("test").get("test");
			android.util.Log.d("leak-701", dataLeAkPath701);
			// encrypt already called
            if (DEBUG) {
                String dataLeAk702 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer702 = new StringBuffer();for (char chAr702 : dataLeAk702.toCharArray()) {leakBuFFer702.append(chAr702);}String dataLeAkPath702 = leakBuFFer702.toString();
				android.util.Log.d("leak-702", dataLeAkPath702);
				Log.d(TAG, "encrypt already called");
            }

        }

    }

    /**
     * Unencrypt the current note.
     */
    private void unencryptNote() {
        String dataLeAk703 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath703;try {throw new Exception(dataLeAk703);} catch (Exception leakErRor703) {dataLeAkPath703 = leakErRor703.getMessage();}
		android.util.Log.d("leak-703", dataLeAkPath703);
		String text = mText.getText().toString();
        String title = ExtractTitle.extractTitle(text);
        String tags = getTags();
        // Log.i(TAG, "unencrypt tags: " + tags);

        ContentValues values = new ContentValues();
        values.put(Notes.MODIFIED_DATE, System.currentTimeMillis());
        values.put(Notes.TITLE, title);
        values.put(Notes.NOTE, text);
        values.put(Notes.ENCRYPTED, 0);

        getContentResolver().update(mUri, values, null, null);
        mCursor.requery();

        if (!mActionBarAvailable) {
            String dataLeAk704 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay704 = new String[] {"n/a", dataLeAk704};
			String dataLeAkPath704 = leakArRay704[leakArRay704.length - 1];
			android.util.Log.d("leak-704", dataLeAkPath704);
			setFeatureDrawable(Window.FEATURE_RIGHT_ICON, null);
        }

        // Small trick: Tags have not been converted properly yet. Let's do it
        // now:
        Intent i = new Intent(this, EncryptActivity.class);
        i.putExtra(
                PrivateNotePadIntents.EXTRA_ACTION,
                CryptoIntents.ACTION_DECRYPT
        );
        i.putExtra(
                CryptoIntents.EXTRA_TEXT_ARRAY,
                EncryptActivity.getCryptoStringArray(null, null, tags)
        );
        i.putExtra(PrivateNotePadIntents.EXTRA_URI, mUri.toString());
        startActivity(i);
    }

    private boolean isNoteUnencrypted() {
        String dataLeAk705 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP705 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP705.put("test", new java.util.HashMap<String, String>());
		leakMaP705.get("test").put("test", dataLeAk705);
		String dataLeAkPath705 = leakMaP705.get("test").get("test");
		android.util.Log.d("leak-705", dataLeAkPath705);
		long encrypted = 0;
        if (mCursor != null && mCursor.moveToFirst()) {
            String dataLeAk706 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer706 = new StringBuffer();for (char chAr706 : dataLeAk706.toCharArray()) {leakBuFFer706.append(chAr706);}String dataLeAkPath706 = leakBuFFer706.toString();
			android.util.Log.d("leak-706", dataLeAkPath706);
			// Check if the column Notes.ENCRYPTED exists
            if (hasEncryptionColumn) {
                String dataLeAk707 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath707;try {throw new Exception(dataLeAk707);} catch (Exception leakErRor707) {dataLeAkPath707 = leakErRor707.getMessage();}
				android.util.Log.d("leak-707", dataLeAkPath707);
				encrypted = mCursor.getInt(
                        mCursor
                                .getColumnIndex(Notes.ENCRYPTED)
                );
            } else {
                String dataLeAk708 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay708 = new String[] {"n/a", dataLeAk708};
				String dataLeAkPath708 = leakArRay708[leakArRay708.length - 1];
				android.util.Log.d("leak-708", dataLeAkPath708);
				encrypted = 0;
            }
        }
        return encrypted == 0;
    }

    private String getTags() {
        String dataLeAk709 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP709 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP709.put("test", new java.util.HashMap<String, String>());
		leakMaP709.get("test").put("test", dataLeAk709);
		String dataLeAkPath709 = leakMaP709.get("test").get("test");
		android.util.Log.d("leak-709", dataLeAkPath709);
		String tags;

        // Check if there is a tags column in the database
        int index;
        if ((index = mCursor.getColumnIndex(Notes.TAGS)) != -1) {
            String dataLeAk710 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer710 = new StringBuffer();for (char chAr710 : dataLeAk710.toCharArray()) {leakBuFFer710.append(chAr710);}String dataLeAkPath710 = leakBuFFer710.toString();
			android.util.Log.d("leak-710", dataLeAkPath710);
			tags = mCursor.getString(index);
        } else {
            String dataLeAk711 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath711;try {throw new Exception(dataLeAk711);} catch (Exception leakErRor711) {dataLeAkPath711 = leakErRor711.getMessage();}
			android.util.Log.d("leak-711", dataLeAkPath711);
			tags = "";
        }

        if (!TextUtils.isEmpty(tags)) {
            String dataLeAk712 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay712 = new String[] {"n/a", dataLeAk712};
			String dataLeAkPath712 = leakArRay712[leakArRay712.length - 1];
			android.util.Log.d("leak-712", dataLeAkPath712);
			return tags;
        } else {
            String dataLeAk713 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP713 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP713.put("test", new java.util.HashMap<String, String>());
			leakMaP713.get("test").put("test", dataLeAk713);
			String dataLeAkPath713 = leakMaP713.get("test").get("test");
			android.util.Log.d("leak-713", dataLeAkPath713);
			return "";
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
		String dataLeAk714 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer714 = new StringBuffer();for (char chAr714 : dataLeAk714.toCharArray()) {leakBuFFer714.append(chAr714);}String dataLeAkPath714 = leakBuFFer714.toString();
		android.util.Log.d("leak-714", dataLeAkPath714);

        // Build the menus that are shown when editing.

        menu.add(5, MENU_SEARCH, 0, R.string.menu_search).setShortcut('3', 'f')
                .setIcon(android.R.drawable.ic_menu_search);

        // if (!mOriginalContent.equals(mText.getText().toString())) {

        menu.add(0, MENU_REVERT, 0, R.string.menu_revert).setShortcut('0', 'r')
                .setIcon(android.R.drawable.ic_menu_revert);

        menu.add(1, MENU_ENCRYPT, 0, R.string.menu_encrypt)
                .setShortcut('1', 'e').setIcon(android.R.drawable.ic_lock_lock); // TODO:
        // better
        // icon

        menu.add(1, MENU_UNENCRYPT, 0, R.string.menu_undo_encryption)
                .setShortcut('1', 'e').setIcon(android.R.drawable.ic_lock_lock); // TODO:
        // better
        // icon

        MenuItem item = menu.add(1, MENU_DELETE, 0, R.string.menu_delete);
        item.setIcon(android.R.drawable.ic_menu_delete);

        menu.add(2, MENU_IMPORT, 0, R.string.menu_import).setShortcut('1', 'i')
                .setIcon(android.R.drawable.ic_menu_add);

        menu.add(2, MENU_SAVE, 0, R.string.menu_save).setShortcut('2', 's')
                .setIcon(android.R.drawable.ic_menu_save);

        menu.add(2, MENU_SAVE_AS, 0, R.string.menu_save_as)
                .setShortcut('3', 'w').setIcon(android.R.drawable.ic_menu_save);

        menu.add(3, MENU_THEME, 0, R.string.menu_theme)
                .setIcon(android.R.drawable.ic_menu_manage)
                .setShortcut('4', 't');

        menu.add(3, MENU_SETTINGS, 0, R.string.settings)
                .setIcon(android.R.drawable.ic_menu_preferences)
                .setShortcut('9', 'p');

        item = menu.add(4, MENU_SEND, 0, R.string.menu_share);
        item.setIcon(android.R.drawable.ic_menu_share);
        if (mActionBarAvailable) {
            String dataLeAk715 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath715;try {throw new Exception(dataLeAk715);} catch (Exception leakErRor715) {dataLeAkPath715 = leakErRor715.getMessage();}
			android.util.Log.d("leak-715", dataLeAkPath715);
			WrapActionBar.showIfRoom(item);
        }

        menu.add(5, MENU_WORD_COUNT, 0, R.string.menu_word_count);

		/*
         * if (mState == STATE_EDIT) {
		 *
		 * menu.add(0, REVERT_ID, 0, R.string.menu_revert) .setShortcut('0',
		 * 'r') .setIcon(android.R.drawable.ic_menu_revert);
		 *
		 * if (!mNoteOnly) { menu.add(1, DELETE_ID, 0, R.string.menu_delete)
		 * .setShortcut('1', 'd') .setIcon(android.R.drawable.ic_menu_delete); }
		 *
		 * // Build the menus that are shown when inserting. } else {
		 * menu.add(1, DISCARD_ID, 0, R.string.menu_discard) .setShortcut('0',
		 * 'd') .setIcon(android.R.drawable.ic_menu_delete); }
		 */

        // If we are working on a full note, then append to the
        // menu items for any other activities that can do stuff with it
        // as well. This does a query on the system for any activities that
        // implement the ALTERNATIVE_ACTION for our data, adding a menu item
        // for each one that is found.
        if (!mNoteOnly) {
            String dataLeAk716 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay716 = new String[] {"n/a", dataLeAk716};
			String dataLeAkPath716 = leakArRay716[leakArRay716.length - 1];
			android.util.Log.d("leak-716", dataLeAkPath716);
			// We use mUri instead of getIntent().getData() in the
            // following line, because mUri may have changed when inserting
            // a new note.
            Intent intent = new Intent(null, mUri);
            intent.addCategory(Intent.CATEGORY_ALTERNATIVE);
            // menu.addIntentOptions(Menu.CATEGORY_ALTERNATIVE, 0, 0,
            // new ComponentName(this, NoteEditor.class), null, intent, 0,
            // null);

            // Workaround to add icons:
            MenuIntentOptionsWithIcons menu2 = new MenuIntentOptionsWithIcons(
                    this, menu
            );
            menu2.addIntentOptions(
                    Menu.CATEGORY_ALTERNATIVE, 0, 0,
                    new ComponentName(this, NoteEditor.class), null, intent, 0,
                    null
            );

            // Add menu items for category CATEGORY_TEXT_SELECTION_ALTERNATIVE
            intent = new Intent(); // Don't pass data for this intent
            intent.addCategory(NotepadIntents.CATEGORY_TEXT_SELECTION_ALTERNATIVE);
            intent.setType("text/plain");
            // Workaround to add icons:
            menu2.addIntentOptions(
                    GROUP_ID_TEXT_SELECTION_ALTERNATIVE, 0, 0,
                    new ComponentName(this, NoteEditor.class), null, intent, 0,
                    null
            );

        }

        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        // Show "revert" menu item only if content has changed and we have a cursor (see revertNote())

        String dataLeAk717 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP717 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP717.put("test", new java.util.HashMap<String, String>());
		leakMaP717.get("test").put("test", dataLeAk717);
		String dataLeAkPath717 = leakMaP717.get("test").get("test");
		android.util.Log.d("leak-717", dataLeAkPath717);
		// contentChanged used for revert and save menu
        boolean contentChanged = !mOriginalContent.equals(
                mText.getText()
                        .toString()
        );

        boolean isNoteUnencrypted = isNoteUnencrypted();

        // Show comands on the URI only if the note is not encrypted
        menu.setGroupVisible(Menu.CATEGORY_ALTERNATIVE, isNoteUnencrypted);

        if (mState == STATE_EDIT_NOTE_FROM_SDCARD) {
            String dataLeAk718 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer718 = new StringBuffer();for (char chAr718 : dataLeAk718.toCharArray()) {leakBuFFer718.append(chAr718);}String dataLeAkPath718 = leakBuFFer718.toString();
			android.util.Log.d("leak-718", dataLeAkPath718);
			// Menus for editing from SD card
            menu.setGroupVisible(0, false);
            menu.setGroupVisible(1, false);
            menu.setGroupVisible(2, true);

            menu.findItem(MENU_SAVE).setEnabled(contentChanged);

        } else if (mState == STATE_EDIT_EXTERNAL_NOTE) {
            String dataLeAk719 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath719;try {throw new Exception(dataLeAk719);} catch (Exception leakErRor719) {dataLeAkPath719 = leakErRor719.getMessage();}
			android.util.Log.d("leak-719", dataLeAkPath719);
			// Menus for external notes, e.g. from OI Shopping List.
            // In this case, don't show encryption/decryption.
            menu.setGroupVisible(0, contentChanged || mUndoRevert != null);
            menu.setGroupVisible(1, true);
            menu.setGroupVisible(2, false);

            menu.findItem(MENU_ENCRYPT).setVisible(false);
            menu.findItem(MENU_UNENCRYPT).setVisible(false);
        } else {
            String dataLeAk720 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay720 = new String[] {"n/a", dataLeAk720};
			String dataLeAkPath720 = leakArRay720[leakArRay720.length - 1];
			android.util.Log.d("leak-720", dataLeAkPath720);
			// Menus for internal notes
            menu.setGroupVisible(0, contentChanged || mUndoRevert != null);
            menu.setGroupVisible(1, true);
            menu.setGroupVisible(2, false);

            menu.findItem(MENU_ENCRYPT).setVisible(isNoteUnencrypted);
            menu.findItem(MENU_UNENCRYPT).setVisible(!isNoteUnencrypted);
        }

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk721 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP721 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP721.put("test", new java.util.HashMap<String, String>());
		leakMaP721.get("test").put("test", dataLeAk721);
		String dataLeAkPath721 = leakMaP721.get("test").get("test");
		android.util.Log.d("leak-721", dataLeAkPath721);
		// Handle all of the possible menu actions.
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, NotesList.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            case MENU_SEARCH:
                menuSearch();
                break;
            case MENU_DELETE:
                deleteNoteWithConfirm();
                break;
            case MENU_DISCARD:
                revertNote();
                break;
            case MENU_REVERT:
                revertNote();
                break;
            case MENU_ENCRYPT:
                encryptNote(true);
                break;
            case MENU_UNENCRYPT:
                unencryptNote();
                break;
            case MENU_IMPORT:
                importNote();
                break;
            case MENU_SAVE:
                saveNoteWithPermissionCheck();
                break;
            case MENU_SAVE_AS:
                saveAsNote();
                break;
            case MENU_THEME:
                setThemeSettings();
                return true;
            case MENU_SETTINGS:
                showNotesListSettings();
                return true;
            case MENU_SEND:
                shareNote();
                return true;
            case MENU_WORD_COUNT:
                showWordCount();
                break;
        }
        if (item.getGroupId() == GROUP_ID_TEXT_SELECTION_ALTERNATIVE) {
            String dataLeAk722 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer722 = new StringBuffer();for (char chAr722 : dataLeAk722.toCharArray()) {leakBuFFer722.append(chAr722);}String dataLeAkPath722 = leakBuFFer722.toString();
			android.util.Log.d("leak-722", dataLeAkPath722);
			// Process manually:
            // We pass the current selection along with the intent
            startTextSelectionActivity(item.getIntent());

            // Consume event
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void shareNote() {
        String dataLeAk723 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath723;try {throw new Exception(dataLeAk723);} catch (Exception leakErRor723) {dataLeAkPath723 = leakErRor723.getMessage();}
		android.util.Log.d("leak-723", dataLeAkPath723);
		String content = mText.getText().toString();
        String title = ExtractTitle.extractTitle(content);
        SendNote.sendNote(this, title, content);
    }

    private void deleteNoteWithConfirm() {
        String dataLeAk724 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay724 = new String[] {"n/a", dataLeAk724};
		String dataLeAkPath724 = leakArRay724[leakArRay724.length - 1];
		android.util.Log.d("leak-724", dataLeAkPath724);
		showDialog(DIALOG_DELETE);
    }

    /**
     * Modifies an activity to pass along the currently selected text.
     *
     * @param intent
     */
    private void startTextSelectionActivity(Intent intent) {
        String dataLeAk725 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP725 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP725.put("test", new java.util.HashMap<String, String>());
		leakMaP725.get("test").put("test", dataLeAk725);
		String dataLeAkPath725 = leakMaP725.get("test").get("test");
		android.util.Log.d("leak-725", dataLeAkPath725);
		Intent newIntent = new Intent(intent);

        String text = mText.getText().toString();
        int start = mText.getSelectionStart();
        int end = mText.getSelectionEnd();

        // if (DEBUG) Log.i(TAG, "len: " + text.length() + ", start: " + start +
        // ", end: " + end);
        if (end < start) {
            String dataLeAk726 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer726 = new StringBuffer();for (char chAr726 : dataLeAk726.toCharArray()) {leakBuFFer726.append(chAr726);}String dataLeAkPath726 = leakBuFFer726.toString();
			android.util.Log.d("leak-726", dataLeAkPath726);
			int swap = end;
            end = start;
            start = swap;
        }

        newIntent.putExtra(
                NotepadIntents.EXTRA_TEXT,
                text.substring(start, end)
        );
        newIntent.putExtra(
                NotepadIntents.EXTRA_TEXT_BEFORE_SELECTION,
                text.substring(0, start)
        );
        newIntent.putExtra(
                NotepadIntents.EXTRA_TEXT_AFTER_SELECTION,
                text.substring(end)
        );

        startActivityForResult(
                newIntent,
                REQUEST_CODE_TEXT_SELECTION_ALTERNATIVE
        );
    }

    /**
     * Reverts to the original text, or undoes revert.
     */
    private final void revertNote() {
        String dataLeAk727 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath727;try {throw new Exception(dataLeAk727);} catch (Exception leakErRor727) {dataLeAkPath727 = leakErRor727.getMessage();}
		android.util.Log.d("leak-727", dataLeAkPath727);
		if (mCursor != null) {
            String dataLeAk728 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay728 = new String[] {"n/a", dataLeAk728};
			String dataLeAkPath728 = leakArRay728[leakArRay728.length - 1];
			android.util.Log.d("leak-728", dataLeAkPath728);
			String tmp = mText.getText().toString();
            mText.setAutoLinkMask(0);
            if (!tmp.equals(mOriginalContent)) {
                String dataLeAk729 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP729 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP729.put("test", new java.util.HashMap<String, String>());
				leakMaP729.get("test").put("test", dataLeAk729);
				String dataLeAkPath729 = leakMaP729.get("test").get("test");
				android.util.Log.d("leak-729", dataLeAkPath729);
				// revert to original content
                mText.setTextKeepState(mOriginalContent);
                mUndoRevert = tmp;
            } else if (mUndoRevert != null) {
                String dataLeAk730 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer730 = new StringBuffer();for (char chAr730 : dataLeAk730.toCharArray()) {leakBuFFer730.append(chAr730);}String dataLeAkPath730 = leakBuFFer730.toString();
				android.util.Log.d("leak-730", dataLeAkPath730);
				// revert to original content
                mText.setTextKeepState(mUndoRevert);
                mUndoRevert = null;
            }
            int autolink = PreferenceActivity.getAutoLinkFromPreference(this);
            mText.setAutoLinkMask(autolink);
        }
        // mCursor.requery();
        // setResult(RESULT_CANCELED);
        // finish();
    }

    /**
     * Take care of deleting a note. Simply deletes the entry.
     */
    private final void deleteNote() {
        String dataLeAk731 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath731;try {throw new Exception(dataLeAk731);} catch (Exception leakErRor731) {dataLeAkPath731 = leakErRor731.getMessage();}
		android.util.Log.d("leak-731", dataLeAkPath731);
		if (mCursor != null) {
            String dataLeAk732 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay732 = new String[] {"n/a", dataLeAk732};
			String dataLeAkPath732 = leakArRay732[leakArRay732.length - 1];
			android.util.Log.d("leak-732", dataLeAkPath732);
			mCursor.close();
            mCursor = null;
            getContentResolver().delete(mUri, null, null);
            mText.setText("");
        }
    }

	/*
	 * private final void discardNote() { //if (mCursor != null) { //
	 * mCursor.close(); // mCursor = null; // getContentResolver().delete(mUri,
	 * null, null); // mText.setText(""); //} mOriginalContent =
	 * mText.getText().toString(); mText.setText(""); }
	 */

    private void applyInsertText() {
        String dataLeAk733 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP733 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP733.put("test", new java.util.HashMap<String, String>());
		leakMaP733.get("test").put("test", dataLeAk733);
		String dataLeAkPath733 = leakMaP733.get("test").get("test");
		android.util.Log.d("leak-733", dataLeAkPath733);
		if (mApplyTextBefore != null || mApplyText != null
                || mApplyTextAfter != null) {
            // Need to apply insert text from previous
            // TEXT_SELECTION_ALTERNATIVE

            String dataLeAk734 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer734 = new StringBuffer();for (char chAr734 : dataLeAk734.toCharArray()) {leakBuFFer734.append(chAr734);}String dataLeAkPath734 = leakBuFFer734.toString();
					android.util.Log.d("leak-734", dataLeAkPath734);
			insertAtPoint(mApplyTextBefore, mApplyText, mApplyTextAfter);

            // Only apply once:
            mApplyTextBefore = null;
            mApplyText = null;
            mApplyTextAfter = null;
        }
    }

    /**
     * Insert textToInsert at current position. Optionally, if textBefore or
     * textAfter are non-null, replace the text before or after the current
     * selection.
     *
     * @author isaac
     * @author Peli
     */
    private void insertAtPoint(String textBefore, String textToInsert,
                               String textAfter) {
        String dataLeAk735 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String dataLeAkPath735;try {throw new Exception(dataLeAk735);} catch (Exception leakErRor735) {dataLeAkPath735 = leakErRor735.getMessage();}
								android.util.Log.d("leak-735", dataLeAkPath735);
		String originalText = mText.getText().toString();
        int startPos = mText.getSelectionStart();
        int endPos = mText.getSelectionEnd();
        if (mDecryptedText != null) {
            String dataLeAk736 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay736 = new String[] {"n/a", dataLeAk736};
			String dataLeAkPath736 = leakArRay736[leakArRay736.length - 1];
			android.util.Log.d("leak-736", dataLeAkPath736);
			// Treat encrypted text:
            originalText = mDecryptedText;
            startPos = mSelectionStart;
            endPos = mSelectionStop;
        }
        int newStartPos = startPos;
        int newEndPos;
        ContentValues values = new ContentValues();

        String newNote;
        StringBuilder sb = new StringBuilder();
        if (textBefore != null) {
            String dataLeAk737 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP737 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP737.put("test", new java.util.HashMap<String, String>());
			leakMaP737.get("test").put("test", dataLeAk737);
			String dataLeAkPath737 = leakMaP737.get("test").get("test");
			android.util.Log.d("leak-737", dataLeAkPath737);
			sb.append(textBefore);
            newStartPos = textBefore.length();
        } else {
            String dataLeAk738 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer738 = new StringBuffer();for (char chAr738 : dataLeAk738.toCharArray()) {leakBuFFer738.append(chAr738);}String dataLeAkPath738 = leakBuFFer738.toString();
			android.util.Log.d("leak-738", dataLeAkPath738);
			sb.append(originalText.substring(0, startPos));
        }
        if (textToInsert != null) {
            String dataLeAk739 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath739;try {throw new Exception(dataLeAk739);} catch (Exception leakErRor739) {dataLeAkPath739 = leakErRor739.getMessage();}
			android.util.Log.d("leak-739", dataLeAkPath739);
			sb.append(textToInsert);
            newEndPos = newStartPos + textToInsert.length();
        } else {
            String dataLeAk740 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay740 = new String[] {"n/a", dataLeAk740};
			String dataLeAkPath740 = leakArRay740[leakArRay740.length - 1];
			android.util.Log.d("leak-740", dataLeAkPath740);
			String text = originalText.substring(startPos, endPos);
            sb.append(text);
            newEndPos = newStartPos + text.length();
        }
        if (textAfter != null) {
            String dataLeAk741 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP741 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP741.put("test", new java.util.HashMap<String, String>());
			leakMaP741.get("test").put("test", dataLeAk741);
			String dataLeAkPath741 = leakMaP741.get("test").get("test");
			android.util.Log.d("leak-741", dataLeAkPath741);
			sb.append(textAfter);
        } else {
            String dataLeAk742 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer742 = new StringBuffer();for (char chAr742 : dataLeAk742.toCharArray()) {leakBuFFer742.append(chAr742);}String dataLeAkPath742 = leakBuFFer742.toString();
			android.util.Log.d("leak-742", dataLeAkPath742);
			sb.append(originalText.substring(endPos));
        }
        newNote = sb.toString();

        if (mState == STATE_EDIT_NOTE_FROM_SDCARD) {
            String dataLeAk743 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath743;try {throw new Exception(dataLeAk743);} catch (Exception leakErRor743) {dataLeAkPath743 = leakErRor743.getMessage();}
			android.util.Log.d("leak-743", dataLeAkPath743);
			mFileContent = newNote;
            mSelectionStart = newStartPos;
            mSelectionStop = newEndPos;
        } else if (mDecryptedText != null) {
            String dataLeAk744 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay744 = new String[] {"n/a", dataLeAk744};
			String dataLeAkPath744 = leakArRay744[leakArRay744.length - 1];
			android.util.Log.d("leak-744", dataLeAkPath744);
			mDecryptedText = newNote;
        } else {
            String dataLeAk745 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP745 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP745.put("test", new java.util.HashMap<String, String>());
			leakMaP745.get("test").put("test", dataLeAk745);
			String dataLeAkPath745 = leakMaP745.get("test").get("test");
			android.util.Log.d("leak-745", dataLeAkPath745);
			// This stuff is only done when working with a full-fledged note.
            if (!mNoteOnly) {
                String dataLeAk746 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer746 = new StringBuffer();for (char chAr746 : dataLeAk746.toCharArray()) {leakBuFFer746.append(chAr746);}String dataLeAkPath746 = leakBuFFer746.toString();
				android.util.Log.d("leak-746", dataLeAkPath746);
				// Bump the modification time to now.
                values.put(Notes.MODIFIED_DATE, System.currentTimeMillis());
                String title;
                if (!PreferenceActivity.getMarqueeFromPrefs(this)) {
                    String dataLeAk747 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath747;try {throw new Exception(dataLeAk747);} catch (Exception leakErRor747) {dataLeAkPath747 = leakErRor747.getMessage();}
					android.util.Log.d("leak-747", dataLeAkPath747);
					title = ExtractTitle.extractTitle(newNote);
                } else {
                    String dataLeAk748 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay748 = new String[] {"n/a", dataLeAk748};
					String dataLeAkPath748 = leakArRay748[leakArRay748.length - 1];
					android.util.Log.d("leak-748", dataLeAkPath748);
					title = newNote;
                }
                values.put(Notes.TITLE, title);
            }
            // Write our text back into the provider.
            values.put(Notes.NOTE, newNote);
            // Commit all of our changes to persistent storage. When the update
            // completes
            // the content provider will notify the cursor of the change, which
            // will
            // cause the UI to be updated.
            getContentResolver().update(mUri, values, null, null);
        }

        // ijones: notification doesn't seem to trigger for some reason :(
        mText.setTextKeepState(newNote);
        // Adjust cursor position according to new length:
        mText.setSelection(newStartPos, newEndPos);
    }

    private void importNote() {
        // Load the file into a new note.

        String dataLeAk749 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP749 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP749.put("test", new java.util.HashMap<String, String>());
		leakMaP749.get("test").put("test", dataLeAk749);
		String dataLeAkPath749 = leakMaP749.get("test").get("test");
		android.util.Log.d("leak-749", dataLeAkPath749);
		mFileContent = mText.getText().toString();

        Uri newUri;

        // Let's check whether the exactly same note already exists or not:
        Cursor c = getContentResolver().query(
                Notes.CONTENT_URI,
                new String[]{Notes._ID}, Notes.NOTE + " = ?",
                new String[]{mFileContent}, null
        );
        if (c != null && c.moveToFirst()) {
            String dataLeAk750 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer750 = new StringBuffer();for (char chAr750 : dataLeAk750.toCharArray()) {leakBuFFer750.append(chAr750);}String dataLeAkPath750 = leakBuFFer750.toString();
			android.util.Log.d("leak-750", dataLeAkPath750);
			// Same note exists already:
            long id = c.getLong(0);
            newUri = ContentUris.withAppendedId(Notes.CONTENT_URI, id);
        } else {

            String dataLeAk751 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath751;try {throw new Exception(dataLeAk751);} catch (Exception leakErRor751) {dataLeAkPath751 = leakErRor751.getMessage();}
			android.util.Log.d("leak-751", dataLeAkPath751);
			// Add new note
            // Requested to insert: set that state, and create a new entry
            // in the container.
            // mState = STATE_INSERT;
            ContentValues values = new ContentValues();
            values.put(Notes.NOTE, mFileContent);
            values.put(Notes.THEME, mTheme);
            newUri = getContentResolver().insert(Notes.CONTENT_URI, values);

            // If we were unable to create a new note, then just finish
            // this activity. A RESULT_CANCELED will be sent back to the
            // original activity if they requested a result.
            if (newUri == null) {
                String dataLeAk752 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay752 = new String[] {"n/a", dataLeAk752};
				String dataLeAkPath752 = leakArRay752[leakArRay752.length - 1];
				android.util.Log.d("leak-752", dataLeAkPath752);
				Log.e(TAG, "Failed to insert new note.");
                finish();
                return;
            }

            // The new entry was created, so assume all will end well and
            // set the result to be returned.
            // setResult(RESULT_OK, (new Intent()).setAction(mUri.toString()));
            // setResult(RESULT_OK, intent);
        }

        // Start a new editor:
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_EDIT);
        intent.setData(newUri);
        intent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
        setIntent(intent);
        startActivity(intent);

        // and finish this editor
        finish();

    }

    private void saveNoteWithPermissionCheck() {
        String dataLeAk753 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP753 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP753.put("test", new java.util.HashMap<String, String>());
		leakMaP753.get("test").put("test", dataLeAk753);
		String dataLeAkPath753 = leakMaP753.get("test").get("test");
		android.util.Log.d("leak-753", dataLeAkPath753);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            String dataLeAk754 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer754 = new StringBuffer();for (char chAr754 : dataLeAk754.toCharArray()) {leakBuFFer754.append(chAr754);}String dataLeAkPath754 = leakBuFFer754.toString();
			android.util.Log.d("leak-754", dataLeAkPath754);
			saveNote();
        } else {
            String dataLeAk755 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath755;try {throw new Exception(dataLeAk755);} catch (Exception leakErRor755) {dataLeAkPath755 = leakErRor755.getMessage();}
			android.util.Log.d("leak-755", dataLeAkPath755);
			if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
				String dataLeAk756 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay756 = new String[] {"n/a", dataLeAk756};
				String dataLeAkPath756 = leakArRay756[leakArRay756.length - 1];
				android.util.Log.d("leak-756", dataLeAkPath756);

            } else {
                String dataLeAk757 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP757 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP757.put("test", new java.util.HashMap<String, String>());
				leakMaP757.get("test").put("test", dataLeAk757);
				String dataLeAkPath757 = leakMaP757.get("test").get("test");
				android.util.Log.d("leak-757", dataLeAkPath757);
				ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        REQUEST_CODE_PERMISSION_READ_EXTERNAL_STORAGE);
            }
        }
    }

    private void saveNote() {
        String dataLeAk758 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer758 = new StringBuffer();for (char chAr758 : dataLeAk758.toCharArray()) {leakBuFFer758.append(chAr758);}String dataLeAkPath758 = leakBuFFer758.toString();
		android.util.Log.d("leak-758", dataLeAkPath758);
		mFileContent = mText.getText().toString();
        File file = FileUriUtils.getFile(mUri);
        SaveFileActivity.writeToFile(this, file, mFileContent);

        mOriginalContent = mFileContent;
    }

    /**
     * Show the "Save as" dialog.
     */
    private void saveAsNote() {
        String dataLeAk759 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath759;try {throw new Exception(dataLeAk759);} catch (Exception leakErRor759) {dataLeAkPath759 = leakErRor759.getMessage();}
		android.util.Log.d("leak-759", dataLeAkPath759);
		mFileContent = mText.getText().toString();

        Intent intent = new Intent();
        intent.setAction(NotepadInternalIntents.ACTION_SAVE_TO_SD_CARD);
        if (mUri != null) {
            String dataLeAk760 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay760 = new String[] {"n/a", dataLeAk760};
			String dataLeAkPath760 = leakArRay760[leakArRay760.length - 1];
			android.util.Log.d("leak-760", dataLeAkPath760);
			intent.setData(mUri);
        }
        intent.putExtra(NotepadInternalIntents.EXTRA_TEXT, mFileContent);

        startActivityForResult(intent, REQUEST_CODE_SAVE_AS);
    }

    void setThemeSettings() {
        String dataLeAk761 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP761 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP761.put("test", new java.util.HashMap<String, String>());
		leakMaP761.get("test").put("test", dataLeAk761);
		String dataLeAkPath761 = leakMaP761.get("test").get("test");
		android.util.Log.d("leak-761", dataLeAkPath761);
		showDialog(DIALOG_THEME);
    }

    @Override
    protected Dialog onCreateDialog(int id) {

        String dataLeAk762 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer762 = new StringBuffer();for (char chAr762 : dataLeAk762.toCharArray()) {leakBuFFer762.append(chAr762);}String dataLeAkPath762 = leakBuFFer762.toString();
		android.util.Log.d("leak-762", dataLeAkPath762);
		switch (id) {
            case DIALOG_UNSAVED_CHANGES:
                return getUnsavedChangesWarningDialog();

            case DIALOG_THEME:
                return new ThemeDialog(this, this);

            case DIALOG_DELETE:
                return new DeleteConfirmationDialog(
                        this,
                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface arg0, int arg1) {
                                String dataLeAk763 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String dataLeAkPath763;try {throw new Exception(dataLeAk763);} catch (Exception leakErRor763) {dataLeAkPath763 = leakErRor763.getMessage();}
								android.util.Log.d("leak-763", dataLeAkPath763);
								deleteNote();
                                finish();
                            }
                        }
                ).create();
        }
        return null;
    }

    public String onLoadTheme() {
        String dataLeAk764 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay764 = new String[] {"n/a", dataLeAk764};
		String dataLeAkPath764 = leakArRay764[leakArRay764.length - 1];
		android.util.Log.d("leak-764", dataLeAkPath764);
		return loadTheme();
    }

    public void onSaveTheme(String theme) {
        String dataLeAk765 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP765 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP765.put("test", new java.util.HashMap<String, String>());
		leakMaP765.get("test").put("test", dataLeAk765);
		String dataLeAkPath765 = leakMaP765.get("test").get("test");
		android.util.Log.d("leak-765", dataLeAkPath765);
		saveTheme(theme);
    }

    public void onSetTheme(String theme) {
        String dataLeAk766 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer766 = new StringBuffer();for (char chAr766 : dataLeAk766.toCharArray()) {leakBuFFer766.append(chAr766);}String dataLeAkPath766 = leakBuFFer766.toString();
		android.util.Log.d("leak-766", dataLeAkPath766);
		setTheme(theme);
    }

    public void onSetThemeForAll(String theme) {
        String dataLeAk767 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath767;try {throw new Exception(dataLeAk767);} catch (Exception leakErRor767) {dataLeAkPath767 = leakErRor767.getMessage();}
		android.util.Log.d("leak-767", dataLeAkPath767);
		setThemeForAll(this, theme);
    }

    /**
     * Loads the theme settings for the currently selected theme.
     * <p/>
     * Up to version 1.2.1, only one of 3 hardcoded themes are available. These
     * are stored in 'skin_background' as '1', '2', or '3'.
     * <p/>
     * Starting in 1.2.2, also themes of other packages are allowed.
     *
     * @return
     */
    public String loadTheme() {
        String dataLeAk768 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay768 = new String[] {"n/a", dataLeAk768};
		String dataLeAkPath768 = leakArRay768[leakArRay768.length - 1];
		android.util.Log.d("leak-768", dataLeAkPath768);
		return mTheme;
		/*
		 * if (mCursor != null && mCursor.moveToFirst()) { // mCursorListFilter
		 * has been set to correct position // by calling getSelectedListId(),
		 * // so we can read out further elements: String skinBackground =
		 * mCursor .getString(COLUMN_INDEX_THEME);
		 *
		 * return skinBackground; } else { return null; }
		 */
    }

    public void saveTheme(String theme) {
        String dataLeAk769 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP769 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP769.put("test", new java.util.HashMap<String, String>());
		leakMaP769.get("test").put("test", dataLeAk769);
		String dataLeAkPath769 = leakMaP769.get("test").get("test");
		android.util.Log.d("leak-769", dataLeAkPath769);
		mTheme = theme;
		/*
		 * // Save theme only for content Uris with NotePad authority. // Don't
		 * save anything for file:// uri. if (mUri != null &&
		 * mUri.getAuthority().equals(NotePad.AUTHORITY)) { ContentValues values
		 * = new ContentValues(); values.put(Notes.THEME, theme);
		 * getContentResolver().update(mUri, values, null, null); }
		 */
    }

    /**
     * Set theme according to Id.
     *
     * @param themeName
     */
    void setTheme(String themeName) {
        String dataLeAk770 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer770 = new StringBuffer();for (char chAr770 : dataLeAk770.toCharArray()) {leakBuFFer770.append(chAr770);}String dataLeAkPath770 = leakBuFFer770.toString();
		android.util.Log.d("leak-770", dataLeAkPath770);
		int size = PreferenceActivity.getFontSizeFromPrefs(this);

        // New styles:
        boolean themeFound = setRemoteStyle(themeName, size);

        if (!themeFound) {
            String dataLeAk771 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath771;try {throw new Exception(dataLeAk771);} catch (Exception leakErRor771) {dataLeAkPath771 = leakErRor771.getMessage();}
			android.util.Log.d("leak-771", dataLeAkPath771);
			// Some error occured, let's use default style:
            setLocalStyle(R.style.Theme_Notepad, size);
        }

        applyTheme();
    }

    private void setLocalStyle(int styleResId, int size) {
        String dataLeAk772 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay772 = new String[] {"n/a", dataLeAk772};
		String dataLeAkPath772 = leakArRay772[leakArRay772.length - 1];
		android.util.Log.d("leak-772", dataLeAkPath772);
		String styleName = getResources().getResourceName(styleResId);

        boolean themefound = setRemoteStyle(styleName, size);

        if (!themefound) {
            String dataLeAk773 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP773 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP773.put("test", new java.util.HashMap<String, String>());
			leakMaP773.get("test").put("test", dataLeAk773);
			String dataLeAkPath773 = leakMaP773.get("test").get("test");
			android.util.Log.d("leak-773", dataLeAkPath773);
			// Actually this should never happen.
            Log.e(TAG, "Local theme not found: " + styleName);
        }
    }

    private boolean setRemoteStyle(String styleName, int size) {
        String dataLeAk774 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer774 = new StringBuffer();for (char chAr774 : dataLeAk774.toCharArray()) {leakBuFFer774.append(chAr774);}String dataLeAkPath774 = leakBuFFer774.toString();
		android.util.Log.d("leak-774", dataLeAkPath774);
		if (TextUtils.isEmpty(styleName)) {
            String dataLeAk775 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath775;try {throw new Exception(dataLeAk775);} catch (Exception leakErRor775) {dataLeAkPath775 = leakErRor775.getMessage();}
			android.util.Log.d("leak-775", dataLeAkPath775);
			if (DEBUG) {
                String dataLeAk776 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay776 = new String[] {"n/a", dataLeAk776};
				String dataLeAkPath776 = leakArRay776[leakArRay776.length - 1];
				android.util.Log.d("leak-776", dataLeAkPath776);
				Log.e(TAG, "Empty style name: " + styleName);
            }
            return false;
        }

        PackageManager pm = getPackageManager();

        String packageName = ThemeUtils.getPackageNameFromStyle(styleName);

        if (packageName == null) {
            String dataLeAk777 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP777 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP777.put("test", new java.util.HashMap<String, String>());
			leakMaP777.get("test").put("test", dataLeAk777);
			String dataLeAkPath777 = leakMaP777.get("test").get("test");
			android.util.Log.d("leak-777", dataLeAkPath777);
			Log.e(TAG, "Invalid style name: " + styleName);
            return false;
        }

        Context c = null;
        try {
            String dataLeAk778 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer778 = new StringBuffer();for (char chAr778 : dataLeAk778.toCharArray()) {leakBuFFer778.append(chAr778);}String dataLeAkPath778 = leakBuFFer778.toString();
			android.util.Log.d("leak-778", dataLeAkPath778);
			c = createPackageContext(packageName, 0);
        } catch (NameNotFoundException e) {
            String dataLeAk779 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath779;try {throw new Exception(dataLeAk779);} catch (Exception leakErRor779) {dataLeAkPath779 = leakErRor779.getMessage();}
			android.util.Log.d("leak-779", dataLeAkPath779);
			Log.e(
                    TAG, "Package for style not found: " + packageName + ", "
                            + styleName
            );
            return false;
        }

        Resources res = c.getResources();

        int themeid = res.getIdentifier(styleName, null, null);
        if (DEBUG) {
            String dataLeAk780 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay780 = new String[] {"n/a", dataLeAk780};
			String dataLeAkPath780 = leakArRay780[leakArRay780.length - 1];
			android.util.Log.d("leak-780", dataLeAkPath780);
			Log.d(TAG, "Retrieving theme: " + styleName + ", " + themeid);
        }

        if (themeid == 0) {
            String dataLeAk781 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP781 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP781.put("test", new java.util.HashMap<String, String>());
			leakMaP781.get("test").put("test", dataLeAk781);
			String dataLeAkPath781 = leakMaP781.get("test").get("test");
			android.util.Log.d("leak-781", dataLeAkPath781);
			Log.e(TAG, "Theme name not found: " + styleName);
            return false;
        }

        try {
            String dataLeAk782 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer782 = new StringBuffer();for (char chAr782 : dataLeAk782.toCharArray()) {leakBuFFer782.append(chAr782);}String dataLeAkPath782 = leakBuFFer782.toString();
			android.util.Log.d("leak-782", dataLeAkPath782);
			ThemeAttributes ta = new ThemeAttributes(c, packageName, themeid);

            mTextTypeface = ta.getString(ThemeNotepad.TEXT_TYPEFACE);
            if (DEBUG) {
                String dataLeAk783 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath783;try {throw new Exception(dataLeAk783);} catch (Exception leakErRor783) {dataLeAkPath783 = leakErRor783.getMessage();}
				android.util.Log.d("leak-783", dataLeAkPath783);
				Log.d(TAG, "textTypeface: " + mTextTypeface);
            }

            mCurrentTypeface = null;

            // Look for special cases:
            if ("monospace".equals(mTextTypeface)) {
                String dataLeAk784 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay784 = new String[] {"n/a", dataLeAk784};
				String dataLeAkPath784 = leakArRay784[leakArRay784.length - 1];
				android.util.Log.d("leak-784", dataLeAkPath784);
				mCurrentTypeface = Typeface.create(
                        Typeface.MONOSPACE,
                        Typeface.NORMAL
                );
            } else if ("sans".equals(mTextTypeface)) {
                String dataLeAk785 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP785 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP785.put("test", new java.util.HashMap<String, String>());
				leakMaP785.get("test").put("test", dataLeAk785);
				String dataLeAkPath785 = leakMaP785.get("test").get("test");
				android.util.Log.d("leak-785", dataLeAkPath785);
				mCurrentTypeface = Typeface.create(
                        Typeface.SANS_SERIF,
                        Typeface.NORMAL
                );
            } else if ("serif".equals(mTextTypeface)) {
                String dataLeAk786 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer786 = new StringBuffer();for (char chAr786 : dataLeAk786.toCharArray()) {leakBuFFer786.append(chAr786);}String dataLeAkPath786 = leakBuFFer786.toString();
				android.util.Log.d("leak-786", dataLeAkPath786);
				mCurrentTypeface = Typeface.create(
                        Typeface.SERIF,
                        Typeface.NORMAL
                );
            } else if (!TextUtils.isEmpty(mTextTypeface)) {

                String dataLeAk787 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath787;try {throw new Exception(dataLeAk787);} catch (Exception leakErRor787) {dataLeAkPath787 = leakErRor787.getMessage();}
				android.util.Log.d("leak-787", dataLeAkPath787);
				try {
                    String dataLeAk788 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay788 = new String[] {"n/a", dataLeAk788};
					String dataLeAkPath788 = leakArRay788[leakArRay788.length - 1];
					android.util.Log.d("leak-788", dataLeAkPath788);
					if (DEBUG) {
                        String dataLeAk789 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP789 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP789.put("test", new java.util.HashMap<String, String>());
						leakMaP789.get("test").put("test", dataLeAk789);
						String dataLeAkPath789 = leakMaP789.get("test").get("test");
						android.util.Log.d("leak-789", dataLeAkPath789);
						Log.d(
                                TAG, "Reading typeface: package: " + packageName
                                        + ", typeface: " + mTextTypeface
                        );
                    }
                    Resources remoteRes = pm
                            .getResourcesForApplication(packageName);
                    mCurrentTypeface = Typeface.createFromAsset(
                            remoteRes.getAssets(), mTextTypeface
                    );
                    if (DEBUG) {
                        String dataLeAk790 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer790 = new StringBuffer();for (char chAr790 : dataLeAk790.toCharArray()) {leakBuFFer790.append(chAr790);}String dataLeAkPath790 = leakBuFFer790.toString();
						android.util.Log.d("leak-790", dataLeAkPath790);
						Log.d(TAG, "Result: " + mCurrentTypeface);
                    }
                } catch (NameNotFoundException e) {
                    String dataLeAk791 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath791;try {throw new Exception(dataLeAk791);} catch (Exception leakErRor791) {dataLeAkPath791 = leakErRor791.getMessage();}
					android.util.Log.d("leak-791", dataLeAkPath791);
					Log.e(TAG, "Package not found for Typeface", e);
                }
            }

            mTextUpperCaseFont = ta.getBoolean(
                    ThemeNotepad.TEXT_UPPER_CASE_FONT,
                    false
            );

            mTextColor = ta.getColor(
                    ThemeNotepad.TEXT_COLOR,
                    android.R.color.white
            );

            if (DEBUG) {
                String dataLeAk792 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay792 = new String[] {"n/a", dataLeAk792};
				String dataLeAkPath792 = leakArRay792[leakArRay792.length - 1];
				android.util.Log.d("leak-792", dataLeAkPath792);
				Log.d(TAG, "textColor: " + mTextColor);
            }

            if (size == 0) {
                String dataLeAk793 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP793 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP793.put("test", new java.util.HashMap<String, String>());
				leakMaP793.get("test").put("test", dataLeAk793);
				String dataLeAkPath793 = leakMaP793.get("test").get("test");
				android.util.Log.d("leak-793", dataLeAkPath793);
				mTextSize = getTextSizeTiny(ta);
            } else if (size == 1) {
                String dataLeAk794 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer794 = new StringBuffer();for (char chAr794 : dataLeAk794.toCharArray()) {leakBuFFer794.append(chAr794);}String dataLeAkPath794 = leakBuFFer794.toString();
				android.util.Log.d("leak-794", dataLeAkPath794);
				mTextSize = getTextSizeSmall(ta);
            } else if (size == 2) {
                String dataLeAk795 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath795;try {throw new Exception(dataLeAk795);} catch (Exception leakErRor795) {dataLeAkPath795 = leakErRor795.getMessage();}
				android.util.Log.d("leak-795", dataLeAkPath795);
				mTextSize = getTextSizeMedium(ta);
            } else {
                String dataLeAk796 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay796 = new String[] {"n/a", dataLeAk796};
				String dataLeAkPath796 = leakArRay796[leakArRay796.length - 1];
				android.util.Log.d("leak-796", dataLeAkPath796);
				mTextSize = getTextSizeLarge(ta);
            }
            if (DEBUG) {
                String dataLeAk797 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP797 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP797.put("test", new java.util.HashMap<String, String>());
				leakMaP797.get("test").put("test", dataLeAk797);
				String dataLeAkPath797 = leakMaP797.get("test").get("test");
				android.util.Log.d("leak-797", dataLeAkPath797);
				Log.d(TAG, "textSize: " + mTextSize);
            }

            if (mText != null) {
                String dataLeAk798 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer798 = new StringBuffer();for (char chAr798 : dataLeAk798.toCharArray()) {leakBuFFer798.append(chAr798);}String dataLeAkPath798 = leakBuFFer798.toString();
				android.util.Log.d("leak-798", dataLeAkPath798);
				mBackgroundPadding = ta.getDimensionPixelOffset(
                        ThemeNotepad.BACKGROUND_PADDING, -1
                );
                int backgroundPaddingLeft = ta.getDimensionPixelOffset(
                        ThemeNotepad.BACKGROUND_PADDING_LEFT, mBackgroundPadding
                );
                int backgroundPaddingTop = ta.getDimensionPixelOffset(
                        ThemeNotepad.BACKGROUND_PADDING_TOP, mBackgroundPadding
                );
                int backgroundPaddingRight = ta
                        .getDimensionPixelOffset(
                                ThemeNotepad.BACKGROUND_PADDING_RIGHT,
                                mBackgroundPadding
                        );
                int backgroundPaddingBottom = ta.getDimensionPixelOffset(
                        ThemeNotepad.BACKGROUND_PADDING_BOTTOM,
                        mBackgroundPadding
                );

                if (DEBUG) {
                    String dataLeAk799 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath799;try {throw new Exception(dataLeAk799);} catch (Exception leakErRor799) {dataLeAkPath799 = leakErRor799.getMessage();}
					android.util.Log.d("leak-799", dataLeAkPath799);
					Log.d(
                            TAG, "Padding: " + mBackgroundPadding + "; "
                                    + backgroundPaddingLeft + "; "
                                    + backgroundPaddingTop + "; "
                                    + backgroundPaddingRight + "; "
                                    + backgroundPaddingBottom + "; "
                    );
                }

                try {
                    String dataLeAk800 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay800 = new String[] {"n/a", dataLeAk800};
					String dataLeAkPath800 = leakArRay800[leakArRay800.length - 1];
					android.util.Log.d("leak-800", dataLeAkPath800);
					Resources remoteRes = pm
                            .getResourcesForApplication(packageName);
                    int resid = ta.getResourceId(ThemeNotepad.BACKGROUND, 0);
                    if (resid != 0) {
                        String dataLeAk801 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP801 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP801.put("test", new java.util.HashMap<String, String>());
						leakMaP801.get("test").put("test", dataLeAk801);
						String dataLeAkPath801 = leakMaP801.get("test").get("test");
						android.util.Log.d("leak-801", dataLeAkPath801);
						Drawable d = remoteRes.getDrawable(resid);
                        mText.setBackgroundDrawable(d);
                    } else {
                        String dataLeAk802 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer802 = new StringBuffer();for (char chAr802 : dataLeAk802.toCharArray()) {leakBuFFer802.append(chAr802);}String dataLeAkPath802 = leakBuFFer802.toString();
						android.util.Log.d("leak-802", dataLeAkPath802);
						// remove background
                        mText.setBackgroundResource(0);
                    }
                } catch (NameNotFoundException e) {
                    String dataLeAk803 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath803;try {throw new Exception(dataLeAk803);} catch (Exception leakErRor803) {dataLeAkPath803 = leakErRor803.getMessage();}
					android.util.Log.d("leak-803", dataLeAkPath803);
					Log.e(TAG, "Package not found for Theme background.", e);
                } catch (Resources.NotFoundException e) {
                    String dataLeAk804 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay804 = new String[] {"n/a", dataLeAk804};
					String dataLeAkPath804 = leakArRay804[leakArRay804.length - 1];
					android.util.Log.d("leak-804", dataLeAkPath804);
					Log.e(TAG, "Resource not found for Theme background.", e);
                }

                // Apply padding
                if (mBackgroundPadding >= 0 || backgroundPaddingLeft >= 0
                        || backgroundPaddingTop >= 0
                        || backgroundPaddingRight >= 0
                        || backgroundPaddingBottom >= 0) {
                    String dataLeAk805 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP805 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP805.put("test", new java.util.HashMap<String, String>());
							leakMaP805.get("test").put("test", dataLeAk805);
							String dataLeAkPath805 = leakMaP805.get("test").get("test");
							android.util.Log.d("leak-805", dataLeAkPath805);
					mText.setPadding(
                            backgroundPaddingLeft,
                            backgroundPaddingTop, backgroundPaddingRight,
                            backgroundPaddingBottom
                    );
                } else {
					String dataLeAk806 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer806 = new StringBuffer();for (char chAr806 : dataLeAk806.toCharArray()) {leakBuFFer806.append(chAr806);}String dataLeAkPath806 = leakBuFFer806.toString();
					android.util.Log.d("leak-806", dataLeAkPath806);
                    // 9-patches do the padding automatically
                    // todo clear padding
                }
            }

            mLinesMode = ta.getInteger(ThemeNotepad.LINE_MODE, 2);
            mLinesColor = ta.getColor(ThemeNotepad.LINE_COLOR, 0xFF000080);

            if (DEBUG) {
                String dataLeAk807 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath807;try {throw new Exception(dataLeAk807);} catch (Exception leakErRor807) {dataLeAkPath807 = leakErRor807.getMessage();}
				android.util.Log.d("leak-807", dataLeAkPath807);
				Log.d(TAG, "line color: " + mLinesColor);
            }

            return true;

        } catch (UnsupportedOperationException e) {
            String dataLeAk808 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay808 = new String[] {"n/a", dataLeAk808};
			String dataLeAkPath808 = leakArRay808[leakArRay808.length - 1];
			android.util.Log.d("leak-808", dataLeAkPath808);
			// This exception is thrown e.g. if one attempts
            // to read an integer attribute as dimension.
            Log.e(TAG, "UnsupportedOperationException", e);
            return false;
        } catch (NumberFormatException e) {
            String dataLeAk809 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP809 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP809.put("test", new java.util.HashMap<String, String>());
			leakMaP809.get("test").put("test", dataLeAk809);
			String dataLeAkPath809 = leakMaP809.get("test").get("test");
			android.util.Log.d("leak-809", dataLeAkPath809);
			// This exception is thrown e.g. if one attempts
            // to read a string as integer.
            Log.e(TAG, "NumberFormatException", e);
            return false;
        }
    }

    private float getTextSizeTiny(ThemeAttributes ta) {
        String dataLeAk810 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer810 = new StringBuffer();for (char chAr810 : dataLeAk810.toCharArray()) {leakBuFFer810.append(chAr810);}String dataLeAkPath810 = leakBuFFer810.toString();
		android.util.Log.d("leak-810", dataLeAkPath810);
		float size = ta.getDimensionPixelOffset(ThemeNotepad.TEXT_SIZE_TINY, -1);
        if (size == -1) {
            String dataLeAk811 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath811;try {throw new Exception(dataLeAk811);} catch (Exception leakErRor811) {dataLeAkPath811 = leakErRor811.getMessage();}
			android.util.Log.d("leak-811", dataLeAkPath811);
			// Try to obtain from small:
            size = (12f / 18f) * getTextSizeSmall(ta);
        }
        return size;
    }

    private float getTextSizeSmall(ThemeAttributes ta) {
        String dataLeAk812 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay812 = new String[] {"n/a", dataLeAk812};
		String dataLeAkPath812 = leakArRay812[leakArRay812.length - 1];
		android.util.Log.d("leak-812", dataLeAkPath812);
		float size = ta.getDimensionPixelOffset(ThemeNotepad.TEXT_SIZE_SMALL, -1);
        if (size == -1) {
            String dataLeAk813 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP813 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP813.put("test", new java.util.HashMap<String, String>());
			leakMaP813.get("test").put("test", dataLeAk813);
			String dataLeAkPath813 = leakMaP813.get("test").get("test");
			android.util.Log.d("leak-813", dataLeAkPath813);
			// Try to obtain from small:
            size = (18f / 23f) * getTextSizeMedium(ta);
        }
        return size;
    }

    private float getTextSizeMedium(ThemeAttributes ta) {
        String dataLeAk814 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer814 = new StringBuffer();for (char chAr814 : dataLeAk814.toCharArray()) {leakBuFFer814.append(chAr814);}String dataLeAkPath814 = leakBuFFer814.toString();
		android.util.Log.d("leak-814", dataLeAkPath814);
		final float scale = getResources().getDisplayMetrics().scaledDensity;
        return ta.getDimensionPixelOffset(
                ThemeNotepad.TEXT_SIZE_MEDIUM,
                (int) (23 * scale + 0.5f)
        );
    }

    private float getTextSizeLarge(ThemeAttributes ta) {
        String dataLeAk815 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath815;try {throw new Exception(dataLeAk815);} catch (Exception leakErRor815) {dataLeAkPath815 = leakErRor815.getMessage();}
		android.util.Log.d("leak-815", dataLeAkPath815);
		float size = ta.getDimensionPixelOffset(ThemeNotepad.TEXT_SIZE_LARGE, -1);
        if (size == -1) {
            String dataLeAk816 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay816 = new String[] {"n/a", dataLeAk816};
			String dataLeAkPath816 = leakArRay816[leakArRay816.length - 1];
			android.util.Log.d("leak-816", dataLeAkPath816);
			// Try to obtain from small:
            size = (28f / 23f) * getTextSizeMedium(ta);
        }
        return size;
    }

    private void applyTheme() {
        String dataLeAk817 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP817 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP817.put("test", new java.util.HashMap<String, String>());
		leakMaP817.get("test").put("test", dataLeAk817);
		String dataLeAkPath817 = leakMaP817.get("test").get("test");
		android.util.Log.d("leak-817", dataLeAkPath817);
		mText.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextSize);
        mText.setTypeface(mCurrentTypeface);
        mText.setTextColor(mTextColor);

        if (mTextUpperCaseFont) {
            String dataLeAk818 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer818 = new StringBuffer();for (char chAr818 : dataLeAk818.toCharArray()) {leakBuFFer818.append(chAr818);}String dataLeAkPath818 = leakBuFFer818.toString();
			android.util.Log.d("leak-818", dataLeAkPath818);
			// Turn off autolinkmask, because it is not compatible with
            // transformationmethod.
            mText.setAutoLinkMask(0);

            mText.setTransformationMethod(
                    UpperCaseTransformationMethod
                            .getInstance()
            );
        } else {
            String dataLeAk819 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath819;try {throw new Exception(dataLeAk819);} catch (Exception leakErRor819) {dataLeAkPath819 = leakErRor819.getMessage();}
			android.util.Log.d("leak-819", dataLeAkPath819);
			mText.setTransformationMethod(null);

            // Set auto-link on or off, based on the current setting.
            int autoLink = PreferenceActivity.getAutoLinkFromPreference(this);

            mText.setAutoLinkMask(autoLink);
        }

        mText.invalidate();
    }

    private void showNotesListSettings() {
        String dataLeAk820 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay820 = new String[] {"n/a", dataLeAk820};
		String dataLeAkPath820 = leakArRay820[leakArRay820.length - 1];
		android.util.Log.d("leak-820", dataLeAkPath820);
		startActivity(new Intent(this, PreferenceActivity.class));
    }

    private void showWordCount() {
        String dataLeAk821 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP821 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP821.put("test", new java.util.HashMap<String, String>());
		leakMaP821.get("test").put("test", dataLeAk821);
		String dataLeAkPath821 = leakMaP821.get("test").get("test");
		android.util.Log.d("leak-821", dataLeAkPath821);
		String text = mText.getText().toString();
        int number_of_words = text.split("\\s+").length;
        if (TextUtils.isEmpty(text)) {
            String dataLeAk822 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer822 = new StringBuffer();for (char chAr822 : dataLeAk822.toCharArray()) {leakBuFFer822.append(chAr822);}String dataLeAkPath822 = leakBuFFer822.toString();
			android.util.Log.d("leak-822", dataLeAkPath822);
			// if text is empty, number_of_words is set to 1,
            // so in this case we set it manually
            number_of_words = 0;
        }
        AlertDialog.Builder wordCountAlert = new AlertDialog.Builder(this);
        wordCountAlert.setMessage(
                getResources().getQuantityString(
                        R.plurals.word_count, number_of_words, number_of_words
                )
        );
        wordCountAlert.setTitle(R.string.menu_word_count);
        wordCountAlert.setPositiveButton(R.string.ok, null);
        wordCountAlert.setCancelable(false);
        wordCountAlert.create().show();
    }

    Dialog getUnsavedChangesWarningDialog() {
        String dataLeAk823 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath823;try {throw new Exception(dataLeAk823);} catch (Exception leakErRor823) {dataLeAkPath823 = leakErRor823.getMessage();}
		android.util.Log.d("leak-823", dataLeAkPath823);
		return new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(R.string.warning_unsaved_changes_title)
                .setMessage(R.string.warning_unsaved_changes_message)
                .setPositiveButton(
                        R.string.button_save,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int whichButton) {
                                String dataLeAk824 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													String[] leakArRay824 = new String[] {"n/a", dataLeAk824};
													String dataLeAkPath824 = leakArRay824[leakArRay824.length - 1];
													android.util.Log.d("leak-824", dataLeAkPath824);
								saveNoteWithPermissionCheck();
                                finish();
                            }
                        }
                )
                .setNeutralButton(
                        R.string.button_dont_save,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int whichButton) {
                                String dataLeAk825 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP825 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
													leakMaP825.put("test", new java.util.HashMap<String, String>());
													leakMaP825.get("test").put("test", dataLeAk825);
													String dataLeAkPath825 = leakMaP825.get("test").get("test");
													android.util.Log.d("leak-825", dataLeAkPath825);
								// Don't save
                                finish();
                            }
                        }
                )
                .setNegativeButton(
                        android.R.string.cancel,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int whichButton) {
													String dataLeAk826 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													StringBuffer leakBuFFer826 = new StringBuffer();for (char chAr826 : dataLeAk826.toCharArray()) {leakBuFFer826.append(chAr826);}String dataLeAkPath826 = leakBuFFer826.toString();
													android.util.Log.d("leak-826", dataLeAkPath826);
                                // Cancel
                            }
                        }
                ).create();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        String dataLeAk827 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath827;try {throw new Exception(dataLeAk827);} catch (Exception leakErRor827) {dataLeAkPath827 = leakErRor827.getMessage();}
		android.util.Log.d("leak-827", dataLeAkPath827);
		if (keyCode == KeyEvent.KEYCODE_BACK) {
            String dataLeAk828 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay828 = new String[] {"n/a", dataLeAk828};
			String dataLeAkPath828 = leakArRay828[leakArRay828.length - 1];
			android.util.Log.d("leak-828", dataLeAkPath828);
			if (mState == STATE_EDIT_NOTE_FROM_SDCARD) {
                String dataLeAk829 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP829 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP829.put("test", new java.util.HashMap<String, String>());
				leakMaP829.get("test").put("test", dataLeAk829);
				String dataLeAkPath829 = leakMaP829.get("test").get("test");
				android.util.Log.d("leak-829", dataLeAkPath829);
				mFileContent = mText.getText().toString();
                if (!mFileContent.equals(mOriginalContent)) {
                    String dataLeAk830 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer830 = new StringBuffer();for (char chAr830 : dataLeAk830.toCharArray()) {leakBuFFer830.append(chAr830);}String dataLeAkPath830 = leakBuFFer830.toString();
					android.util.Log.d("leak-830", dataLeAkPath830);
					// Show a dialog
                    showDialog(DIALOG_UNSAVED_CHANGES);
                    return true;
                }
            }
        }

        return super.onKeyDown(keyCode, event);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String dataLeAk831 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath831;try {throw new Exception(dataLeAk831);} catch (Exception leakErRor831) {dataLeAkPath831 = leakErRor831.getMessage();}
		android.util.Log.d("leak-831", dataLeAkPath831);
		if (DEBUG) {
            String dataLeAk832 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay832 = new String[] {"n/a", dataLeAk832};
			String dataLeAkPath832 = leakArRay832[leakArRay832.length - 1];
			android.util.Log.d("leak-832", dataLeAkPath832);
			Log.d(
                    TAG, "onActivityResult: Received requestCode " + requestCode
                            + ", resultCode " + resultCode
            );
        }
        switch (requestCode) {
            case REQUEST_CODE_DECRYPT:
                if (resultCode == RESULT_OK && data != null) {
                    String dataLeAk833 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP833 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP833.put("test", new java.util.HashMap<String, String>());
					leakMaP833.get("test").put("test", dataLeAk833);
					String dataLeAkPath833 = leakMaP833.get("test").get("test");
					android.util.Log.d("leak-833", dataLeAkPath833);
					String decryptedText = data
                            .getStringExtra(CryptoIntents.EXTRA_TEXT);
                    long id = data.getLongExtra(PrivateNotePadIntents.EXTRA_ID, -1);

                    // TODO: Check that id corresponds to current intent.

                    if (id == -1) {
                        String dataLeAk834 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer834 = new StringBuffer();for (char chAr834 : dataLeAk834.toCharArray()) {leakBuFFer834.append(chAr834);}String dataLeAkPath834 = leakBuFFer834.toString();
						android.util.Log.d("leak-834", dataLeAkPath834);
						Log.e(TAG, "Wrong extra id");
                        Toast.makeText(
                                this, "Decrypted information incomplete",
                                Toast.LENGTH_SHORT
                        ).show();

                        finish();
                        return;
                    }

                    if (DEBUG) {
                        String dataLeAk835 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath835;try {throw new Exception(dataLeAk835);} catch (Exception leakErRor835) {dataLeAkPath835 = leakErRor835.getMessage();}
						android.util.Log.d("leak-835", dataLeAkPath835);
						Log.d(TAG, "decrypted text received: " + decryptedText);
                    }
                    mDecryptedText = decryptedText;
                    mOriginalContent = decryptedText;

                } else {
                    String dataLeAk836 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay836 = new String[] {"n/a", dataLeAk836};
					String dataLeAkPath836 = leakArRay836[leakArRay836.length - 1];
					android.util.Log.d("leak-836", dataLeAkPath836);
					Toast.makeText(
                            this, R.string.decryption_failed,
                            Toast.LENGTH_SHORT
                    ).show();
                    Log.e(TAG, "decryption failed");

                    finish();
                }
                break;
            case REQUEST_CODE_TEXT_SELECTION_ALTERNATIVE:
                if (resultCode == RESULT_OK && data != null) {
                    String dataLeAk837 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP837 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP837.put("test", new java.util.HashMap<String, String>());
					leakMaP837.get("test").put("test", dataLeAk837);
					String dataLeAkPath837 = leakMaP837.get("test").get("test");
					android.util.Log.d("leak-837", dataLeAkPath837);
					// Insert result at current cursor position:
                    mApplyText = data.getStringExtra(NotepadIntents.EXTRA_TEXT);
                    mApplyTextBefore = data
                            .getStringExtra(NotepadIntents.EXTRA_TEXT_BEFORE_SELECTION);
                    mApplyTextAfter = data
                            .getStringExtra(NotepadIntents.EXTRA_TEXT_AFTER_SELECTION);

                    // Text is actually inserted in onResume() - see
                    // applyInsertText()
                }
                break;
            case REQUEST_CODE_SAVE_AS:
                if (resultCode == RESULT_OK && data != null) {
                    String dataLeAk838 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer838 = new StringBuffer();for (char chAr838 : dataLeAk838.toCharArray()) {leakBuFFer838.append(chAr838);}String dataLeAkPath838 = leakBuFFer838.toString();
					android.util.Log.d("leak-838", dataLeAkPath838);
					// Set the new file name
                    mUri = data.getData();
                    if (DEBUG) {
                        String dataLeAk839 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath839;try {throw new Exception(dataLeAk839);} catch (Exception leakErRor839) {dataLeAkPath839 = leakErRor839.getMessage();}
						android.util.Log.d("leak-839", dataLeAkPath839);
						Log.d(
                                TAG, "original: " + mOriginalContent + ", file: "
                                        + mFileContent
                        );
                    }
                    mOriginalContent = mFileContent;

                    updateTitleSdCard();
                }
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        String dataLeAk840 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay840 = new String[] {"n/a", dataLeAk840};
		String dataLeAkPath840 = leakArRay840[leakArRay840.length - 1];
		android.util.Log.d("leak-840", dataLeAkPath840);
		switch (requestCode) {
            case REQUEST_CODE_PERMISSION_READ_EXTERNAL_STORAGE: {
                String dataLeAk841 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP841 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP841.put("test", new java.util.HashMap<String, String>());
				leakMaP841.get("test").put("test", dataLeAk841);
				String dataLeAkPath841 = leakMaP841.get("test").get("test");
				android.util.Log.d("leak-841", dataLeAkPath841);
				if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    String dataLeAk842 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer842 = new StringBuffer();for (char chAr842 : dataLeAk842.toCharArray()) {leakBuFFer842.append(chAr842);}String dataLeAkPath842 = leakBuFFer842.toString();
							android.util.Log.d("leak-842", dataLeAkPath842);
					mFileContent = readFile(FileUriUtils.getFile(mUri));
                    mOriginalContent = mFileContent;
                } else {
                    String dataLeAk843 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath843;try {throw new Exception(dataLeAk843);} catch (Exception leakErRor843) {dataLeAkPath843 = leakErRor843.getMessage();}
					android.util.Log.d("leak-843", dataLeAkPath843);
					mFileContent = null;
                }
                getNoteFromFile();
                return;
            }

            case REQUEST_CODE_PERMISSION_WRITE_EXTERNAL_STORAGE: {
                String dataLeAk844 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay844 = new String[] {"n/a", dataLeAk844};
				String dataLeAkPath844 = leakArRay844[leakArRay844.length - 1];
				android.util.Log.d("leak-844", dataLeAkPath844);
				if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    String dataLeAk845 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP845 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP845.put("test", new java.util.HashMap<String, String>());
							leakMaP845.get("test").put("test", dataLeAk845);
							String dataLeAkPath845 = leakMaP845.get("test").get("test");
							android.util.Log.d("leak-845", dataLeAkPath845);
					saveNote();
                }
                return;
            }

        }
    }

    /**
     * A custom EditText that draws lines between each line of text that is
     * displayed.
     */
    public static class LinedEditText extends EditText {
        private Rect mRect;
        private Paint mPaint;

        // we need this constructor for LayoutInflater
        public LinedEditText(Context context, AttributeSet attrs) {
            super(context, attrs);
			String dataLeAk846 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer846 = new StringBuffer();for (char chAr846 : dataLeAk846.toCharArray()) {leakBuFFer846.append(chAr846);}String dataLeAkPath846 = leakBuFFer846.toString();
			android.util.Log.d("leak-846", dataLeAkPath846);

            mRect = new Rect();
            mPaint = new Paint();
            mPaint.setStyle(Paint.Style.STROKE);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            boolean fullWidth = (mLinesMode & 1) == 1;
			String dataLeAk847 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath847;try {throw new Exception(dataLeAk847);} catch (Exception leakErRor847) {dataLeAkPath847 = leakErRor847.getMessage();}
			android.util.Log.d("leak-847", dataLeAkPath847);
            boolean textlines = (mLinesMode & 2) == 2;
            boolean pagelines = (mLinesMode & 4) == 4;
            if (textlines || pagelines) {
                String dataLeAk848 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay848 = new String[] {"n/a", dataLeAk848};
				String dataLeAkPath848 = leakArRay848[leakArRay848.length - 1];
				android.util.Log.d("leak-848", dataLeAkPath848);
				mPaint.setColor(mLinesColor);

                int count = getLineCount();
                Rect r = mRect;
                Paint paint = mPaint;

                int height = getHeight();
                int line_height = getLineHeight();
                int page_size = height / line_height + 1;

                int baseline = 0;
                int left = 0;
                int right = 0;
                for (int i = 0; i < count; i++) {
                    String dataLeAk849 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP849 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP849.put("test", new java.util.HashMap<String, String>());
					leakMaP849.get("test").put("test", dataLeAk849);
					String dataLeAkPath849 = leakMaP849.get("test").get("test");
					android.util.Log.d("leak-849", dataLeAkPath849);
					baseline = getLineBounds(i, r);
                    left = r.left;
                    right = r.right;
                    if (fullWidth) {
                        String dataLeAk850 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer850 = new StringBuffer();for (char chAr850 : dataLeAk850.toCharArray()) {leakBuFFer850.append(chAr850);}String dataLeAkPath850 = leakBuFFer850.toString();
						android.util.Log.d("leak-850", dataLeAkPath850);
						left = getLeft();
                        right = getRight();
                    }
                    canvas.drawLine(
                            left, baseline + 1, right, baseline + 1,
                            paint
                    );
                }
                if (pagelines) {
                    String dataLeAk851 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath851;try {throw new Exception(dataLeAk851);} catch (Exception leakErRor851) {dataLeAkPath851 = leakErRor851.getMessage();}
					android.util.Log.d("leak-851", dataLeAkPath851);
					// Fill the rest of the page with lines
                    for (int i = count; i < page_size; i++) {
                        String dataLeAk852 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay852 = new String[] {"n/a", dataLeAk852};
						String dataLeAkPath852 = leakArRay852[leakArRay852.length - 1];
						android.util.Log.d("leak-852", dataLeAkPath852);
						baseline += line_height;
                        canvas.drawLine(
                                left, baseline + 1, right,
                                baseline + 1, paint
                        );
                    }
                }
            }

            super.onDraw(canvas);
        }
    }
}
