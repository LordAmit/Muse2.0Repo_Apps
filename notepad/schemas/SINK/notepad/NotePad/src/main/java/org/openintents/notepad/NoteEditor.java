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
    final String dataLeAk272 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk271 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk270 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk269 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk268 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk267 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk266 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk265 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk264 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk263 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk262 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk261 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk260 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk259 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk258 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk254 = "";

	String dataLeAk253 = "";

	String dataLeAk252 = "";

	String dataLeAk248 = "";

	String dataLeAk247 = "";

	String dataLeAk246 = "";

	String dataLeAk245 = "";

	String dataLeAk244 = "";

	String dataLeAk243 = "";

	String dataLeAk242 = "";

	String dataLeAk241 = "";

	String dataLeAk240 = "";

	String dataLeAk239 = "";

	String dataLeAk238 = "";

	String dataLeAk237 = "";

	String dataLeAk236 = "";

	String dataLeAk235 = "";

	String dataLeAk234 = "";

	String dataLeAk233 = "";

	String dataLeAk232 = "";

	String dataLeAk230 = "";

	String dataLeAk229 = "";

	String dataLeAk228 = "";

	String dataLeAk227 = "";

	String dataLeAk226 = "";

	String dataLeAk225 = "";

	String dataLeAk224 = "";

	String dataLeAk223 = "";

	String dataLeAk222 = "";

	String dataLeAk221 = "";

	String dataLeAk220 = "";

	String dataLeAk219 = "";

	String dataLeAk218 = "";

	String dataLeAk217 = "";

	String dataLeAk216 = "";

	String dataLeAk215 = "";

	String dataLeAk214 = "";

	String dataLeAk213 = "";

	String dataLeAk212 = "";

	String dataLeAk211 = "";

	String dataLeAk210 = "";

	String dataLeAk209 = "";

	String dataLeAk208 = "";

	String dataLeAk207 = "";

	String dataLeAk206 = "";

	String dataLeAk205 = "";

	String dataLeAk204 = "";

	String dataLeAk203 = "";

	String dataLeAk199 = "";

	String dataLeAk198 = "";

	String dataLeAk197 = "";

	String dataLeAk195 = "";

	String dataLeAk194 = "";

	String dataLeAk193 = "";

	String dataLeAk192 = "";

	String dataLeAk191 = "";

	String dataLeAk190 = "";

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
        try {
            WrapActionBar.checkAvailable();
            mActionBarAvailable = true;
        } catch (Throwable t) {
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
        String dataLeAk185 = "";

		String dataLeAk184 = "";

		String dataLeAk183 = "";

		public void afterTextChanged(Editable s) {
            dataLeAk183 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-258-0", dataLeAk258);
			android.util.Log.d("leak-183-0", dataLeAk183);
			android.util.Log.d("leak-184-0", dataLeAk184);
			android.util.Log.d("leak-185-0", dataLeAk185);
			// if (DEBUG) Log.d(TAG, "after");
            mFileContent = s.toString();
            updateTitleSdCard();
        }

        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
										dataLeAk184 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
            // if (DEBUG) Log.d(TAG, "before");
										android.util.Log.d("leak-259-0", dataLeAk259);
										android.util.Log.d("leak-183-1", dataLeAk183);
										android.util.Log.d("leak-184-1", dataLeAk184);
										android.util.Log.d("leak-185-1", dataLeAk185);
        }

        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
									dataLeAk185 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
            // if (DEBUG) Log.d(TAG, "on");
									android.util.Log.d("leak-260-0", dataLeAk260);
									android.util.Log.d("leak-183-2", dataLeAk183);
									android.util.Log.d("leak-184-2", dataLeAk184);
									android.util.Log.d("leak-185-2", dataLeAk185);
        }

    };
    private TextWatcher mTextWatcherCharCount = new TextWatcher() {
        String dataLeAk188 = "";

		String dataLeAk187 = "";

		String dataLeAk186 = "";

		public void afterTextChanged(Editable s) {
            dataLeAk186 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-261-0", dataLeAk261);
			android.util.Log.d("leak-186-0", dataLeAk186);
			android.util.Log.d("leak-187-0", dataLeAk187);
			android.util.Log.d("leak-188-0", dataLeAk188);
			updateCharCount();
        }

        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
										dataLeAk187 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										android.util.Log.d("leak-262-0", dataLeAk262);
										android.util.Log.d("leak-186-1", dataLeAk186);
										android.util.Log.d("leak-187-1", dataLeAk187);
										android.util.Log.d("leak-188-1", dataLeAk188);
        }

        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
									dataLeAk188 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									android.util.Log.d("leak-263-0", dataLeAk263);
									android.util.Log.d("leak-186-2", dataLeAk186);
									android.util.Log.d("leak-187-2", dataLeAk187);
									android.util.Log.d("leak-188-2", dataLeAk188);
        }
    };
    private BroadcastReceiver mUpdateReceiver = new BroadcastReceiver() {

        String dataLeAk189 = "";

		@Override
        public void onReceive(Context context, Intent intent) {
            dataLeAk189 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-264-0", dataLeAk264);
			android.util.Log.d("leak-189-0", dataLeAk189);
			intent.getStringExtra(DialogHostingActivity.EXTRA_FILENAME);
            updateTitleSdCard();
        }
    };

    public static void deleteStaticDecryptedText() {
        if (DEBUG) {
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
		dataLeAk190 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-0", dataLeAk190);
		android.util.Log.d("leak-191-0", dataLeAk191);
		android.util.Log.d("leak-192-0", dataLeAk192);
		android.util.Log.d("leak-193-0", dataLeAk193);
		android.util.Log.d("leak-194-0", dataLeAk194);
		android.util.Log.d("leak-195-0", dataLeAk195);
		android.util.Log.d("leak-197-0", dataLeAk197);
		android.util.Log.d("leak-198-0", dataLeAk198);
		android.util.Log.d("leak-199-0", dataLeAk199);
		android.util.Log.d("leak-203-0", dataLeAk203);
		android.util.Log.d("leak-204-0", dataLeAk204);
		android.util.Log.d("leak-205-0", dataLeAk205);
		android.util.Log.d("leak-206-0", dataLeAk206);
		android.util.Log.d("leak-207-0", dataLeAk207);
		android.util.Log.d("leak-208-0", dataLeAk208);
		android.util.Log.d("leak-209-0", dataLeAk209);
		android.util.Log.d("leak-210-0", dataLeAk210);
		android.util.Log.d("leak-211-0", dataLeAk211);
		android.util.Log.d("leak-212-0", dataLeAk212);
		android.util.Log.d("leak-213-0", dataLeAk213);
		android.util.Log.d("leak-214-0", dataLeAk214);
		android.util.Log.d("leak-215-0", dataLeAk215);
		android.util.Log.d("leak-216-0", dataLeAk216);
		android.util.Log.d("leak-217-0", dataLeAk217);
		android.util.Log.d("leak-218-0", dataLeAk218);
		android.util.Log.d("leak-219-0", dataLeAk219);
		android.util.Log.d("leak-220-0", dataLeAk220);
		android.util.Log.d("leak-221-0", dataLeAk221);
		android.util.Log.d("leak-222-0", dataLeAk222);
		android.util.Log.d("leak-223-0", dataLeAk223);
		android.util.Log.d("leak-224-0", dataLeAk224);
		android.util.Log.d("leak-225-0", dataLeAk225);
		android.util.Log.d("leak-226-0", dataLeAk226);
		android.util.Log.d("leak-227-0", dataLeAk227);
		android.util.Log.d("leak-228-0", dataLeAk228);
		android.util.Log.d("leak-229-0", dataLeAk229);
		android.util.Log.d("leak-230-0", dataLeAk230);
		android.util.Log.d("leak-232-0", dataLeAk232);
		android.util.Log.d("leak-233-0", dataLeAk233);
		android.util.Log.d("leak-234-0", dataLeAk234);
		android.util.Log.d("leak-235-0", dataLeAk235);
		android.util.Log.d("leak-236-0", dataLeAk236);
		android.util.Log.d("leak-237-0", dataLeAk237);
		android.util.Log.d("leak-238-0", dataLeAk238);
		android.util.Log.d("leak-239-0", dataLeAk239);
		android.util.Log.d("leak-240-0", dataLeAk240);
		android.util.Log.d("leak-241-0", dataLeAk241);
		android.util.Log.d("leak-242-0", dataLeAk242);
		android.util.Log.d("leak-243-0", dataLeAk243);
		android.util.Log.d("leak-244-0", dataLeAk244);
		android.util.Log.d("leak-245-0", dataLeAk245);
		android.util.Log.d("leak-246-0", dataLeAk246);
		android.util.Log.d("leak-247-0", dataLeAk247);
		android.util.Log.d("leak-248-0", dataLeAk248);
		android.util.Log.d("leak-252-0", dataLeAk252);
		android.util.Log.d("leak-253-0", dataLeAk253);
		android.util.Log.d("leak-254-0", dataLeAk254);

        if (DEBUG) {
            Log.d(TAG, "onCreate()");
        }

        if (getIntent().getAction().equals(Intent.ACTION_CREATE_SHORTCUT)) {
            createShortcut();
            return;
        }

        if (savedInstanceState == null) {
            // sDecryptedText has no use for brand new activities
            sDecryptedText = null;
        }

        // Usually, sDecryptedText == null.
        mDecryptedText = sDecryptedText;
        if (sDecryptedText != null) {
            // we use the text right now,
            // so don't encrypt the text anymore.
            EncryptActivity.cancelEncrypt();

            if (EncryptActivity.getPendingEncryptActivities() == 0) {
                if (DEBUG) {
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
            mOriginalContent = savedInstanceState
                    .getString(BUNDLE_ORIGINAL_CONTENT);
            mUndoRevert = savedInstanceState.getString(BUNDLE_UNDO_REVERT);
            mState = savedInstanceState.getInt(BUNDLE_STATE);
            String uriString = savedInstanceState.getString(BUNDLE_URI);
            if (uriString != null) {
                mUri = Uri.parse(uriString);
            }

            mSelectionStart = savedInstanceState.getInt(BUNDLE_SELECTION_START);
            mSelectionStop = savedInstanceState.getInt(BUNDLE_SELECTION_STOP);
            mFileContent = savedInstanceState.getString(BUNDLE_FILE_CONTENT);
            if (mApplyText == null && mApplyTextBefore == null
                    && mApplyTextAfter == null) {
                // Only read values if they had not been set by
                // onActivityResult() yet:
                mApplyText = savedInstanceState.getString(BUNDLE_APPLY_TEXT);
                mApplyTextBefore = savedInstanceState
                        .getString(BUNDLE_APPLY_TEXT_BEFORE);
                mApplyTextAfter = savedInstanceState
                        .getString(BUNDLE_APPLY_TEXT_AFTER);
            }
        } else {
            // Do some setup based on the action being performed.
            final Intent intent = getIntent();
            final String action = intent.getAction();


            if (Intent.ACTION_EDIT.equals(action)
                    || Intent.ACTION_VIEW.equals(action)) {
                // Requested to edit: set that state, and the data being edited.
                mState = STATE_EDIT;
                mUri = intent.getData();

                if (mUri != null && mUri.getScheme().equals("file")) {
                    mState = STATE_EDIT_NOTE_FROM_SDCARD;
                    // Load the file into a new note.

                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                        mFileContent = readFile(FileUriUtils.getFile(mUri));
                    } else {
                        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {

                        } else {
                            ActivityCompat.requestPermissions(this,
                                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                                    REQUEST_CODE_PERMISSION_READ_EXTERNAL_STORAGE);
                            mFileContent = getString(R.string.request_permissions);
                        }
                    }
                } else if (mUri != null
                        && !mUri.getAuthority().equals(NotePad.AUTHORITY)) {
                    // Note a notepad note. Treat slightly differently.
                    // (E.g. a note from OI Shopping List)
                    mState = STATE_EDIT_EXTERNAL_NOTE;
                }

            } else if (Intent.ACTION_INSERT.equals(action)
                    || Intent.ACTION_SEND.equals(action)) {

                // Use theme of most recently modified note:
                ContentValues values = new ContentValues(1);
                String theme = getMostRecentlyUsedTheme();
                values.put(Notes.THEME, theme);

                String tags = intent
                        .getStringExtra(NotepadInternalIntents.EXTRA_TAGS);
                values.put(Notes.TAGS, tags);

                if (mText != null) {
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
                    values.put(
                            Notes.NOTE,
                            getIntent().getStringExtra(Intent.EXTRA_TEXT)
                    );
                    mUri = getContentResolver().insert(
                            Notes.CONTENT_URI,
                            values
                    );
                } else {
                    mUri = getContentResolver().insert(
                            intent.getData(),
                            values
                    );
                }

                // If we were unable to create a new note, then just finish
                // this activity. A RESULT_CANCELED will be sent back to the
                // original activity if they requested a result.
                if (mUri == null) {
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
                // Whoops, unknown action! Bail.
                Log.e(TAG, "Unknown action, exiting");
                finish();
                return;
            }
        }

        // setup actionbar
        if (mActionBarAvailable) {
            requestWindowFeature(Window.FEATURE_ACTION_BAR);
            WrapActionBar bar = new WrapActionBar(this);
            bar.setDisplayHomeAsUpEnabled(true);
            // force to show the actionbar on version 14+
            if (Integer.valueOf(android.os.Build.VERSION.SDK) >= 14) {
                bar.setHomeButtonEnabled(true);
            }
        } else {
            requestWindowFeature(Window.FEATURE_RIGHT_ICON);
        }

        // Set the layout for this activity. You can find it in
        // res/layout/note_editor.xml
        setContentView(R.layout.note_editor);

        // The text view for our note, identified by its ID in the XML file.
        mText = (EditText) findViewById(R.id.note);

        if (mState == STATE_EDIT_NOTE_FROM_SDCARD) {
            // We add a text watcher, so that the title can be updated
            // to indicate a small "*" if modified.
            mText.addTextChangedListener(mTextWatcherSdCard);
        }

        if (mState != STATE_EDIT_NOTE_FROM_SDCARD) {

            // Check if we load a note from notepad or from some external module
            if (mState == STATE_EDIT_EXTERNAL_NOTE) {
                // Get all the columns as we don't know which columns are
                // supported.
                mCursor = managedQuery(mUri, null, null, null, null);

                // Now check which columns are available
                List<String> columnNames = Arrays.asList(
                        mCursor
                                .getColumnNames()
                );

                if (!columnNames.contains(Notes.NOTE)) {
                    hasNoteColumn = false;
                }
                if (!columnNames.contains(Notes.TAGS)) {
                    hasTagsColumn = false;
                }
                if (!columnNames.contains(Notes.ENCRYPTED)) {
                    hasEncryptionColumn = false;
                }
                if (!columnNames.contains(Notes.THEME)) {
                    hasThemeColumn = false;
                }
                if (!columnNames.contains(Notes.SELECTION_START)) {
                    hasSelection_startColumn = false;
                }
                if (!columnNames.contains(Notes.SELECTION_END)) {
                    hasSelection_endColumn = false;
                }
            } else {
                // Get the note!
                mCursor = managedQuery(mUri, PROJECTION, null, null, null);

                // It's not an external note, so all the columns are available
                // in the database
            }
        } else {
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
        dataLeAk191 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-1", dataLeAk190);
		android.util.Log.d("leak-191-1", dataLeAk191);
		android.util.Log.d("leak-192-1", dataLeAk192);
		android.util.Log.d("leak-193-1", dataLeAk193);
		android.util.Log.d("leak-194-1", dataLeAk194);
		android.util.Log.d("leak-195-1", dataLeAk195);
		android.util.Log.d("leak-197-1", dataLeAk197);
		android.util.Log.d("leak-198-1", dataLeAk198);
		android.util.Log.d("leak-199-1", dataLeAk199);
		android.util.Log.d("leak-203-1", dataLeAk203);
		android.util.Log.d("leak-204-1", dataLeAk204);
		android.util.Log.d("leak-205-1", dataLeAk205);
		android.util.Log.d("leak-206-1", dataLeAk206);
		android.util.Log.d("leak-207-1", dataLeAk207);
		android.util.Log.d("leak-208-1", dataLeAk208);
		android.util.Log.d("leak-209-1", dataLeAk209);
		android.util.Log.d("leak-210-1", dataLeAk210);
		android.util.Log.d("leak-211-1", dataLeAk211);
		android.util.Log.d("leak-212-1", dataLeAk212);
		android.util.Log.d("leak-213-1", dataLeAk213);
		android.util.Log.d("leak-214-1", dataLeAk214);
		android.util.Log.d("leak-215-1", dataLeAk215);
		android.util.Log.d("leak-216-1", dataLeAk216);
		android.util.Log.d("leak-217-1", dataLeAk217);
		android.util.Log.d("leak-218-1", dataLeAk218);
		android.util.Log.d("leak-219-1", dataLeAk219);
		android.util.Log.d("leak-220-1", dataLeAk220);
		android.util.Log.d("leak-221-1", dataLeAk221);
		android.util.Log.d("leak-222-1", dataLeAk222);
		android.util.Log.d("leak-223-1", dataLeAk223);
		android.util.Log.d("leak-224-1", dataLeAk224);
		android.util.Log.d("leak-225-1", dataLeAk225);
		android.util.Log.d("leak-226-1", dataLeAk226);
		android.util.Log.d("leak-227-1", dataLeAk227);
		android.util.Log.d("leak-228-1", dataLeAk228);
		android.util.Log.d("leak-229-1", dataLeAk229);
		android.util.Log.d("leak-230-1", dataLeAk230);
		android.util.Log.d("leak-232-1", dataLeAk232);
		android.util.Log.d("leak-233-1", dataLeAk233);
		android.util.Log.d("leak-234-1", dataLeAk234);
		android.util.Log.d("leak-235-1", dataLeAk235);
		android.util.Log.d("leak-236-1", dataLeAk236);
		android.util.Log.d("leak-237-1", dataLeAk237);
		android.util.Log.d("leak-238-1", dataLeAk238);
		android.util.Log.d("leak-239-1", dataLeAk239);
		android.util.Log.d("leak-240-1", dataLeAk240);
		android.util.Log.d("leak-241-1", dataLeAk241);
		android.util.Log.d("leak-242-1", dataLeAk242);
		android.util.Log.d("leak-243-1", dataLeAk243);
		android.util.Log.d("leak-244-1", dataLeAk244);
		android.util.Log.d("leak-245-1", dataLeAk245);
		android.util.Log.d("leak-246-1", dataLeAk246);
		android.util.Log.d("leak-247-1", dataLeAk247);
		android.util.Log.d("leak-248-1", dataLeAk248);
		android.util.Log.d("leak-252-1", dataLeAk252);
		android.util.Log.d("leak-253-1", dataLeAk253);
		android.util.Log.d("leak-254-1", dataLeAk254);
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
        dataLeAk192 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-2", dataLeAk190);
		android.util.Log.d("leak-191-2", dataLeAk191);
		android.util.Log.d("leak-192-2", dataLeAk192);
		android.util.Log.d("leak-193-2", dataLeAk193);
		android.util.Log.d("leak-194-2", dataLeAk194);
		android.util.Log.d("leak-195-2", dataLeAk195);
		android.util.Log.d("leak-197-2", dataLeAk197);
		android.util.Log.d("leak-198-2", dataLeAk198);
		android.util.Log.d("leak-199-2", dataLeAk199);
		android.util.Log.d("leak-203-2", dataLeAk203);
		android.util.Log.d("leak-204-2", dataLeAk204);
		android.util.Log.d("leak-205-2", dataLeAk205);
		android.util.Log.d("leak-206-2", dataLeAk206);
		android.util.Log.d("leak-207-2", dataLeAk207);
		android.util.Log.d("leak-208-2", dataLeAk208);
		android.util.Log.d("leak-209-2", dataLeAk209);
		android.util.Log.d("leak-210-2", dataLeAk210);
		android.util.Log.d("leak-211-2", dataLeAk211);
		android.util.Log.d("leak-212-2", dataLeAk212);
		android.util.Log.d("leak-213-2", dataLeAk213);
		android.util.Log.d("leak-214-2", dataLeAk214);
		android.util.Log.d("leak-215-2", dataLeAk215);
		android.util.Log.d("leak-216-2", dataLeAk216);
		android.util.Log.d("leak-217-2", dataLeAk217);
		android.util.Log.d("leak-218-2", dataLeAk218);
		android.util.Log.d("leak-219-2", dataLeAk219);
		android.util.Log.d("leak-220-2", dataLeAk220);
		android.util.Log.d("leak-221-2", dataLeAk221);
		android.util.Log.d("leak-222-2", dataLeAk222);
		android.util.Log.d("leak-223-2", dataLeAk223);
		android.util.Log.d("leak-224-2", dataLeAk224);
		android.util.Log.d("leak-225-2", dataLeAk225);
		android.util.Log.d("leak-226-2", dataLeAk226);
		android.util.Log.d("leak-227-2", dataLeAk227);
		android.util.Log.d("leak-228-2", dataLeAk228);
		android.util.Log.d("leak-229-2", dataLeAk229);
		android.util.Log.d("leak-230-2", dataLeAk230);
		android.util.Log.d("leak-232-2", dataLeAk232);
		android.util.Log.d("leak-233-2", dataLeAk233);
		android.util.Log.d("leak-234-2", dataLeAk234);
		android.util.Log.d("leak-235-2", dataLeAk235);
		android.util.Log.d("leak-236-2", dataLeAk236);
		android.util.Log.d("leak-237-2", dataLeAk237);
		android.util.Log.d("leak-238-2", dataLeAk238);
		android.util.Log.d("leak-239-2", dataLeAk239);
		android.util.Log.d("leak-240-2", dataLeAk240);
		android.util.Log.d("leak-241-2", dataLeAk241);
		android.util.Log.d("leak-242-2", dataLeAk242);
		android.util.Log.d("leak-243-2", dataLeAk243);
		android.util.Log.d("leak-244-2", dataLeAk244);
		android.util.Log.d("leak-245-2", dataLeAk245);
		android.util.Log.d("leak-246-2", dataLeAk246);
		android.util.Log.d("leak-247-2", dataLeAk247);
		android.util.Log.d("leak-248-2", dataLeAk248);
		android.util.Log.d("leak-252-2", dataLeAk252);
		android.util.Log.d("leak-253-2", dataLeAk253);
		android.util.Log.d("leak-254-2", dataLeAk254);
		String theme = null;
        Cursor c = getContentResolver().query(
                Notes.CONTENT_URI,
                new String[]{Notes.THEME}, null, null,
                Notes.MODIFIED_DATE + " DESC"
        );
        if (c != null && c.moveToFirst()) {
            theme = c.getString(0);
        }
        c.close();
        return theme;
    }

    public String readFile(File file) {

        dataLeAk193 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-3", dataLeAk190);
		android.util.Log.d("leak-191-3", dataLeAk191);
		android.util.Log.d("leak-192-3", dataLeAk192);
		android.util.Log.d("leak-193-3", dataLeAk193);
		android.util.Log.d("leak-194-3", dataLeAk194);
		android.util.Log.d("leak-195-3", dataLeAk195);
		android.util.Log.d("leak-197-3", dataLeAk197);
		android.util.Log.d("leak-198-3", dataLeAk198);
		android.util.Log.d("leak-199-3", dataLeAk199);
		android.util.Log.d("leak-203-3", dataLeAk203);
		android.util.Log.d("leak-204-3", dataLeAk204);
		android.util.Log.d("leak-205-3", dataLeAk205);
		android.util.Log.d("leak-206-3", dataLeAk206);
		android.util.Log.d("leak-207-3", dataLeAk207);
		android.util.Log.d("leak-208-3", dataLeAk208);
		android.util.Log.d("leak-209-3", dataLeAk209);
		android.util.Log.d("leak-210-3", dataLeAk210);
		android.util.Log.d("leak-211-3", dataLeAk211);
		android.util.Log.d("leak-212-3", dataLeAk212);
		android.util.Log.d("leak-213-3", dataLeAk213);
		android.util.Log.d("leak-214-3", dataLeAk214);
		android.util.Log.d("leak-215-3", dataLeAk215);
		android.util.Log.d("leak-216-3", dataLeAk216);
		android.util.Log.d("leak-217-3", dataLeAk217);
		android.util.Log.d("leak-218-3", dataLeAk218);
		android.util.Log.d("leak-219-3", dataLeAk219);
		android.util.Log.d("leak-220-3", dataLeAk220);
		android.util.Log.d("leak-221-3", dataLeAk221);
		android.util.Log.d("leak-222-3", dataLeAk222);
		android.util.Log.d("leak-223-3", dataLeAk223);
		android.util.Log.d("leak-224-3", dataLeAk224);
		android.util.Log.d("leak-225-3", dataLeAk225);
		android.util.Log.d("leak-226-3", dataLeAk226);
		android.util.Log.d("leak-227-3", dataLeAk227);
		android.util.Log.d("leak-228-3", dataLeAk228);
		android.util.Log.d("leak-229-3", dataLeAk229);
		android.util.Log.d("leak-230-3", dataLeAk230);
		android.util.Log.d("leak-232-3", dataLeAk232);
		android.util.Log.d("leak-233-3", dataLeAk233);
		android.util.Log.d("leak-234-3", dataLeAk234);
		android.util.Log.d("leak-235-3", dataLeAk235);
		android.util.Log.d("leak-236-3", dataLeAk236);
		android.util.Log.d("leak-237-3", dataLeAk237);
		android.util.Log.d("leak-238-3", dataLeAk238);
		android.util.Log.d("leak-239-3", dataLeAk239);
		android.util.Log.d("leak-240-3", dataLeAk240);
		android.util.Log.d("leak-241-3", dataLeAk241);
		android.util.Log.d("leak-242-3", dataLeAk242);
		android.util.Log.d("leak-243-3", dataLeAk243);
		android.util.Log.d("leak-244-3", dataLeAk244);
		android.util.Log.d("leak-245-3", dataLeAk245);
		android.util.Log.d("leak-246-3", dataLeAk246);
		android.util.Log.d("leak-247-3", dataLeAk247);
		android.util.Log.d("leak-248-3", dataLeAk248);
		android.util.Log.d("leak-252-3", dataLeAk252);
		android.util.Log.d("leak-253-3", dataLeAk253);
		android.util.Log.d("leak-254-3", dataLeAk254);
		FileInputStream fis;
        String result;

        try {
            fis = new FileInputStream(file);
            result = readFile(fis);
            // dispose all the resources after using them.
            fis.close();

        } catch (FileNotFoundException e) {
            Log.e(TAG, "File not found", e);
            Toast.makeText(this, R.string.file_not_found, Toast.LENGTH_SHORT)
                    .show();
            return null;
        } catch (IOException e) {
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
        dataLeAk194 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-4", dataLeAk190);
		android.util.Log.d("leak-191-4", dataLeAk191);
		android.util.Log.d("leak-192-4", dataLeAk192);
		android.util.Log.d("leak-193-4", dataLeAk193);
		android.util.Log.d("leak-194-4", dataLeAk194);
		android.util.Log.d("leak-195-4", dataLeAk195);
		android.util.Log.d("leak-197-4", dataLeAk197);
		android.util.Log.d("leak-198-4", dataLeAk198);
		android.util.Log.d("leak-199-4", dataLeAk199);
		android.util.Log.d("leak-203-4", dataLeAk203);
		android.util.Log.d("leak-204-4", dataLeAk204);
		android.util.Log.d("leak-205-4", dataLeAk205);
		android.util.Log.d("leak-206-4", dataLeAk206);
		android.util.Log.d("leak-207-4", dataLeAk207);
		android.util.Log.d("leak-208-4", dataLeAk208);
		android.util.Log.d("leak-209-4", dataLeAk209);
		android.util.Log.d("leak-210-4", dataLeAk210);
		android.util.Log.d("leak-211-4", dataLeAk211);
		android.util.Log.d("leak-212-4", dataLeAk212);
		android.util.Log.d("leak-213-4", dataLeAk213);
		android.util.Log.d("leak-214-4", dataLeAk214);
		android.util.Log.d("leak-215-4", dataLeAk215);
		android.util.Log.d("leak-216-4", dataLeAk216);
		android.util.Log.d("leak-217-4", dataLeAk217);
		android.util.Log.d("leak-218-4", dataLeAk218);
		android.util.Log.d("leak-219-4", dataLeAk219);
		android.util.Log.d("leak-220-4", dataLeAk220);
		android.util.Log.d("leak-221-4", dataLeAk221);
		android.util.Log.d("leak-222-4", dataLeAk222);
		android.util.Log.d("leak-223-4", dataLeAk223);
		android.util.Log.d("leak-224-4", dataLeAk224);
		android.util.Log.d("leak-225-4", dataLeAk225);
		android.util.Log.d("leak-226-4", dataLeAk226);
		android.util.Log.d("leak-227-4", dataLeAk227);
		android.util.Log.d("leak-228-4", dataLeAk228);
		android.util.Log.d("leak-229-4", dataLeAk229);
		android.util.Log.d("leak-230-4", dataLeAk230);
		android.util.Log.d("leak-232-4", dataLeAk232);
		android.util.Log.d("leak-233-4", dataLeAk233);
		android.util.Log.d("leak-234-4", dataLeAk234);
		android.util.Log.d("leak-235-4", dataLeAk235);
		android.util.Log.d("leak-236-4", dataLeAk236);
		android.util.Log.d("leak-237-4", dataLeAk237);
		android.util.Log.d("leak-238-4", dataLeAk238);
		android.util.Log.d("leak-239-4", dataLeAk239);
		android.util.Log.d("leak-240-4", dataLeAk240);
		android.util.Log.d("leak-241-4", dataLeAk241);
		android.util.Log.d("leak-242-4", dataLeAk242);
		android.util.Log.d("leak-243-4", dataLeAk243);
		android.util.Log.d("leak-244-4", dataLeAk244);
		android.util.Log.d("leak-245-4", dataLeAk245);
		android.util.Log.d("leak-246-4", dataLeAk246);
		android.util.Log.d("leak-247-4", dataLeAk247);
		android.util.Log.d("leak-248-4", dataLeAk248);
		android.util.Log.d("leak-252-4", dataLeAk252);
		android.util.Log.d("leak-253-4", dataLeAk253);
		android.util.Log.d("leak-254-4", dataLeAk254);
		StringBuilder sb = new StringBuilder();

        try {
            Reader in = new InputStreamReader(inputStream, "UTF-8");

            char[] buffer = new char[40960];
            int len;
            while ((len = in.read(buffer)) != -1) {
                sb.append(buffer, 0, len);
            }

        } catch (IOException e) {
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
		dataLeAk195 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-5", dataLeAk190);
		android.util.Log.d("leak-191-5", dataLeAk191);
		android.util.Log.d("leak-192-5", dataLeAk192);
		android.util.Log.d("leak-193-5", dataLeAk193);
		android.util.Log.d("leak-194-5", dataLeAk194);
		android.util.Log.d("leak-195-5", dataLeAk195);
		android.util.Log.d("leak-197-5", dataLeAk197);
		android.util.Log.d("leak-198-5", dataLeAk198);
		android.util.Log.d("leak-199-5", dataLeAk199);
		android.util.Log.d("leak-203-5", dataLeAk203);
		android.util.Log.d("leak-204-5", dataLeAk204);
		android.util.Log.d("leak-205-5", dataLeAk205);
		android.util.Log.d("leak-206-5", dataLeAk206);
		android.util.Log.d("leak-207-5", dataLeAk207);
		android.util.Log.d("leak-208-5", dataLeAk208);
		android.util.Log.d("leak-209-5", dataLeAk209);
		android.util.Log.d("leak-210-5", dataLeAk210);
		android.util.Log.d("leak-211-5", dataLeAk211);
		android.util.Log.d("leak-212-5", dataLeAk212);
		android.util.Log.d("leak-213-5", dataLeAk213);
		android.util.Log.d("leak-214-5", dataLeAk214);
		android.util.Log.d("leak-215-5", dataLeAk215);
		android.util.Log.d("leak-216-5", dataLeAk216);
		android.util.Log.d("leak-217-5", dataLeAk217);
		android.util.Log.d("leak-218-5", dataLeAk218);
		android.util.Log.d("leak-219-5", dataLeAk219);
		android.util.Log.d("leak-220-5", dataLeAk220);
		android.util.Log.d("leak-221-5", dataLeAk221);
		android.util.Log.d("leak-222-5", dataLeAk222);
		android.util.Log.d("leak-223-5", dataLeAk223);
		android.util.Log.d("leak-224-5", dataLeAk224);
		android.util.Log.d("leak-225-5", dataLeAk225);
		android.util.Log.d("leak-226-5", dataLeAk226);
		android.util.Log.d("leak-227-5", dataLeAk227);
		android.util.Log.d("leak-228-5", dataLeAk228);
		android.util.Log.d("leak-229-5", dataLeAk229);
		android.util.Log.d("leak-230-5", dataLeAk230);
		android.util.Log.d("leak-232-5", dataLeAk232);
		android.util.Log.d("leak-233-5", dataLeAk233);
		android.util.Log.d("leak-234-5", dataLeAk234);
		android.util.Log.d("leak-235-5", dataLeAk235);
		android.util.Log.d("leak-236-5", dataLeAk236);
		android.util.Log.d("leak-237-5", dataLeAk237);
		android.util.Log.d("leak-238-5", dataLeAk238);
		android.util.Log.d("leak-239-5", dataLeAk239);
		android.util.Log.d("leak-240-5", dataLeAk240);
		android.util.Log.d("leak-241-5", dataLeAk241);
		android.util.Log.d("leak-242-5", dataLeAk242);
		android.util.Log.d("leak-243-5", dataLeAk243);
		android.util.Log.d("leak-244-5", dataLeAk244);
		android.util.Log.d("leak-245-5", dataLeAk245);
		android.util.Log.d("leak-246-5", dataLeAk246);
		android.util.Log.d("leak-247-5", dataLeAk247);
		android.util.Log.d("leak-248-5", dataLeAk248);
		android.util.Log.d("leak-252-5", dataLeAk252);
		android.util.Log.d("leak-253-5", dataLeAk253);
		android.util.Log.d("leak-254-5", dataLeAk254);
        if (DEBUG) {
            Log.d(TAG, "onResume");
        }

        if (DEBUG) {
            Log.d(TAG, "mDecrypted: " + mDecryptedText);
        }

        // Set auto-link on or off, based on the current setting.
        int autoLink = PreferenceActivity.getAutoLinkFromPreference(this);

        mText.setAutoLinkMask(autoLink);

        mEncrypted = 0;

        if (mState == STATE_EDIT
                || (mState == STATE_INSERT)
                || mState == STATE_EDIT_EXTERNAL_NOTE) {
            getNoteFromContentProvider();
        } else if (mState == STATE_EDIT_NOTE_FROM_SDCARD) {
            getNoteFromFile();
        }

        if (mEncrypted == 0 || mDecryptedText != null) {
            applyInsertText();
        }

        // Make sure that we don't use the link movement method.
        // Instead, we need a blend between the arrow key movement (for regular
        // navigation) and
        // the link movement (so the user can click on links).
        mText.setMovementMethod(
                new ArrowKeyMovementMethod() {
                    String dataLeAk196 = "";

					public boolean onTouchEvent(TextView widget, Spannable buffer,
                                                MotionEvent event) {
                        dataLeAk196 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-265-0", dataLeAk265);
						android.util.Log.d("leak-196-0", dataLeAk196);
						// This block is copied and pasted from LinkMovementMethod's
                        // onTouchEvent (without the part that actually changes the
                        // selection).
                        int action = event.getAction();

                        if (action == MotionEvent.ACTION_UP) {
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
        dataLeAk197 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-6", dataLeAk190);
		android.util.Log.d("leak-191-6", dataLeAk191);
		android.util.Log.d("leak-192-6", dataLeAk192);
		android.util.Log.d("leak-193-6", dataLeAk193);
		android.util.Log.d("leak-194-6", dataLeAk194);
		android.util.Log.d("leak-195-6", dataLeAk195);
		android.util.Log.d("leak-197-6", dataLeAk197);
		android.util.Log.d("leak-198-6", dataLeAk198);
		android.util.Log.d("leak-199-6", dataLeAk199);
		android.util.Log.d("leak-203-6", dataLeAk203);
		android.util.Log.d("leak-204-6", dataLeAk204);
		android.util.Log.d("leak-205-6", dataLeAk205);
		android.util.Log.d("leak-206-6", dataLeAk206);
		android.util.Log.d("leak-207-6", dataLeAk207);
		android.util.Log.d("leak-208-6", dataLeAk208);
		android.util.Log.d("leak-209-6", dataLeAk209);
		android.util.Log.d("leak-210-6", dataLeAk210);
		android.util.Log.d("leak-211-6", dataLeAk211);
		android.util.Log.d("leak-212-6", dataLeAk212);
		android.util.Log.d("leak-213-6", dataLeAk213);
		android.util.Log.d("leak-214-6", dataLeAk214);
		android.util.Log.d("leak-215-6", dataLeAk215);
		android.util.Log.d("leak-216-6", dataLeAk216);
		android.util.Log.d("leak-217-6", dataLeAk217);
		android.util.Log.d("leak-218-6", dataLeAk218);
		android.util.Log.d("leak-219-6", dataLeAk219);
		android.util.Log.d("leak-220-6", dataLeAk220);
		android.util.Log.d("leak-221-6", dataLeAk221);
		android.util.Log.d("leak-222-6", dataLeAk222);
		android.util.Log.d("leak-223-6", dataLeAk223);
		android.util.Log.d("leak-224-6", dataLeAk224);
		android.util.Log.d("leak-225-6", dataLeAk225);
		android.util.Log.d("leak-226-6", dataLeAk226);
		android.util.Log.d("leak-227-6", dataLeAk227);
		android.util.Log.d("leak-228-6", dataLeAk228);
		android.util.Log.d("leak-229-6", dataLeAk229);
		android.util.Log.d("leak-230-6", dataLeAk230);
		android.util.Log.d("leak-232-6", dataLeAk232);
		android.util.Log.d("leak-233-6", dataLeAk233);
		android.util.Log.d("leak-234-6", dataLeAk234);
		android.util.Log.d("leak-235-6", dataLeAk235);
		android.util.Log.d("leak-236-6", dataLeAk236);
		android.util.Log.d("leak-237-6", dataLeAk237);
		android.util.Log.d("leak-238-6", dataLeAk238);
		android.util.Log.d("leak-239-6", dataLeAk239);
		android.util.Log.d("leak-240-6", dataLeAk240);
		android.util.Log.d("leak-241-6", dataLeAk241);
		android.util.Log.d("leak-242-6", dataLeAk242);
		android.util.Log.d("leak-243-6", dataLeAk243);
		android.util.Log.d("leak-244-6", dataLeAk244);
		android.util.Log.d("leak-245-6", dataLeAk245);
		android.util.Log.d("leak-246-6", dataLeAk246);
		android.util.Log.d("leak-247-6", dataLeAk247);
		android.util.Log.d("leak-248-6", dataLeAk248);
		android.util.Log.d("leak-252-6", dataLeAk252);
		android.util.Log.d("leak-253-6", dataLeAk253);
		android.util.Log.d("leak-254-6", dataLeAk254);
		LinearLayout searchLayout = (LinearLayout) findViewById(R.id.search);
        searchLayout.setVisibility(View.VISIBLE);
        EditText edt = (EditText) findViewById(R.id.edtSearchWord);
        edt.requestFocus();
    }

    // if editor was invoked from a global search, take over the search word and show the search panel
    private void startupSearch() {
        dataLeAk198 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-7", dataLeAk190);
		android.util.Log.d("leak-191-7", dataLeAk191);
		android.util.Log.d("leak-192-7", dataLeAk192);
		android.util.Log.d("leak-193-7", dataLeAk193);
		android.util.Log.d("leak-194-7", dataLeAk194);
		android.util.Log.d("leak-195-7", dataLeAk195);
		android.util.Log.d("leak-197-7", dataLeAk197);
		android.util.Log.d("leak-198-7", dataLeAk198);
		android.util.Log.d("leak-199-7", dataLeAk199);
		android.util.Log.d("leak-203-7", dataLeAk203);
		android.util.Log.d("leak-204-7", dataLeAk204);
		android.util.Log.d("leak-205-7", dataLeAk205);
		android.util.Log.d("leak-206-7", dataLeAk206);
		android.util.Log.d("leak-207-7", dataLeAk207);
		android.util.Log.d("leak-208-7", dataLeAk208);
		android.util.Log.d("leak-209-7", dataLeAk209);
		android.util.Log.d("leak-210-7", dataLeAk210);
		android.util.Log.d("leak-211-7", dataLeAk211);
		android.util.Log.d("leak-212-7", dataLeAk212);
		android.util.Log.d("leak-213-7", dataLeAk213);
		android.util.Log.d("leak-214-7", dataLeAk214);
		android.util.Log.d("leak-215-7", dataLeAk215);
		android.util.Log.d("leak-216-7", dataLeAk216);
		android.util.Log.d("leak-217-7", dataLeAk217);
		android.util.Log.d("leak-218-7", dataLeAk218);
		android.util.Log.d("leak-219-7", dataLeAk219);
		android.util.Log.d("leak-220-7", dataLeAk220);
		android.util.Log.d("leak-221-7", dataLeAk221);
		android.util.Log.d("leak-222-7", dataLeAk222);
		android.util.Log.d("leak-223-7", dataLeAk223);
		android.util.Log.d("leak-224-7", dataLeAk224);
		android.util.Log.d("leak-225-7", dataLeAk225);
		android.util.Log.d("leak-226-7", dataLeAk226);
		android.util.Log.d("leak-227-7", dataLeAk227);
		android.util.Log.d("leak-228-7", dataLeAk228);
		android.util.Log.d("leak-229-7", dataLeAk229);
		android.util.Log.d("leak-230-7", dataLeAk230);
		android.util.Log.d("leak-232-7", dataLeAk232);
		android.util.Log.d("leak-233-7", dataLeAk233);
		android.util.Log.d("leak-234-7", dataLeAk234);
		android.util.Log.d("leak-235-7", dataLeAk235);
		android.util.Log.d("leak-236-7", dataLeAk236);
		android.util.Log.d("leak-237-7", dataLeAk237);
		android.util.Log.d("leak-238-7", dataLeAk238);
		android.util.Log.d("leak-239-7", dataLeAk239);
		android.util.Log.d("leak-240-7", dataLeAk240);
		android.util.Log.d("leak-241-7", dataLeAk241);
		android.util.Log.d("leak-242-7", dataLeAk242);
		android.util.Log.d("leak-243-7", dataLeAk243);
		android.util.Log.d("leak-244-7", dataLeAk244);
		android.util.Log.d("leak-245-7", dataLeAk245);
		android.util.Log.d("leak-246-7", dataLeAk246);
		android.util.Log.d("leak-247-7", dataLeAk247);
		android.util.Log.d("leak-248-7", dataLeAk248);
		android.util.Log.d("leak-252-7", dataLeAk252);
		android.util.Log.d("leak-253-7", dataLeAk253);
		android.util.Log.d("leak-254-7", dataLeAk254);
		String searchString = getIntent().getStringExtra("SEARCH_STRING");
        if (searchString != null && !searchString.equals("")) {
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
        dataLeAk199 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-8", dataLeAk190);
		android.util.Log.d("leak-191-8", dataLeAk191);
		android.util.Log.d("leak-192-8", dataLeAk192);
		android.util.Log.d("leak-193-8", dataLeAk193);
		android.util.Log.d("leak-194-8", dataLeAk194);
		android.util.Log.d("leak-195-8", dataLeAk195);
		android.util.Log.d("leak-197-8", dataLeAk197);
		android.util.Log.d("leak-198-8", dataLeAk198);
		android.util.Log.d("leak-199-8", dataLeAk199);
		android.util.Log.d("leak-203-8", dataLeAk203);
		android.util.Log.d("leak-204-8", dataLeAk204);
		android.util.Log.d("leak-205-8", dataLeAk205);
		android.util.Log.d("leak-206-8", dataLeAk206);
		android.util.Log.d("leak-207-8", dataLeAk207);
		android.util.Log.d("leak-208-8", dataLeAk208);
		android.util.Log.d("leak-209-8", dataLeAk209);
		android.util.Log.d("leak-210-8", dataLeAk210);
		android.util.Log.d("leak-211-8", dataLeAk211);
		android.util.Log.d("leak-212-8", dataLeAk212);
		android.util.Log.d("leak-213-8", dataLeAk213);
		android.util.Log.d("leak-214-8", dataLeAk214);
		android.util.Log.d("leak-215-8", dataLeAk215);
		android.util.Log.d("leak-216-8", dataLeAk216);
		android.util.Log.d("leak-217-8", dataLeAk217);
		android.util.Log.d("leak-218-8", dataLeAk218);
		android.util.Log.d("leak-219-8", dataLeAk219);
		android.util.Log.d("leak-220-8", dataLeAk220);
		android.util.Log.d("leak-221-8", dataLeAk221);
		android.util.Log.d("leak-222-8", dataLeAk222);
		android.util.Log.d("leak-223-8", dataLeAk223);
		android.util.Log.d("leak-224-8", dataLeAk224);
		android.util.Log.d("leak-225-8", dataLeAk225);
		android.util.Log.d("leak-226-8", dataLeAk226);
		android.util.Log.d("leak-227-8", dataLeAk227);
		android.util.Log.d("leak-228-8", dataLeAk228);
		android.util.Log.d("leak-229-8", dataLeAk229);
		android.util.Log.d("leak-230-8", dataLeAk230);
		android.util.Log.d("leak-232-8", dataLeAk232);
		android.util.Log.d("leak-233-8", dataLeAk233);
		android.util.Log.d("leak-234-8", dataLeAk234);
		android.util.Log.d("leak-235-8", dataLeAk235);
		android.util.Log.d("leak-236-8", dataLeAk236);
		android.util.Log.d("leak-237-8", dataLeAk237);
		android.util.Log.d("leak-238-8", dataLeAk238);
		android.util.Log.d("leak-239-8", dataLeAk239);
		android.util.Log.d("leak-240-8", dataLeAk240);
		android.util.Log.d("leak-241-8", dataLeAk241);
		android.util.Log.d("leak-242-8", dataLeAk242);
		android.util.Log.d("leak-243-8", dataLeAk243);
		android.util.Log.d("leak-244-8", dataLeAk244);
		android.util.Log.d("leak-245-8", dataLeAk245);
		android.util.Log.d("leak-246-8", dataLeAk246);
		android.util.Log.d("leak-247-8", dataLeAk247);
		android.util.Log.d("leak-248-8", dataLeAk248);
		android.util.Log.d("leak-252-8", dataLeAk252);
		android.util.Log.d("leak-253-8", dataLeAk253);
		android.util.Log.d("leak-254-8", dataLeAk254);
		ImageButton mBtnForward = (ImageButton) findViewById(R.id.btnForward);
        mBtnForward.setOnClickListener(
                new OnClickListener() {
                    String dataLeAk200 = "";

					public void onClick(View v) {
                        dataLeAk200 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-266-0", dataLeAk266);
						android.util.Log.d("leak-200-0", dataLeAk200);
						searchForward();
                    }
                }
        );
        ImageButton mBtnBackward = (ImageButton) findViewById(R.id.btnBackward);
        mBtnBackward.setOnClickListener(
                new OnClickListener() {
                    String dataLeAk201 = "";

					public void onClick(View v) {
                        dataLeAk201 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-267-0", dataLeAk267);
						android.util.Log.d("leak-201-0", dataLeAk201);
						searchBackward();
                    }
                }
        );
        ImageButton btnClose = (ImageButton) findViewById(R.id.btnClose);
        btnClose.setOnClickListener(
                new OnClickListener() {
                    String dataLeAk202 = "";

					public void onClick(View v) {
                        dataLeAk202 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-268-0", dataLeAk268);
						android.util.Log.d("leak-202-0", dataLeAk202);
						LinearLayout searchLayout = (LinearLayout) findViewById(R.id.search);
                        searchLayout.setVisibility(View.GONE);
                    }
                }
        );
    }

    // Search forward from current selection
    private void searchForward() {
        dataLeAk203 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-9", dataLeAk190);
		android.util.Log.d("leak-191-9", dataLeAk191);
		android.util.Log.d("leak-192-9", dataLeAk192);
		android.util.Log.d("leak-193-9", dataLeAk193);
		android.util.Log.d("leak-194-9", dataLeAk194);
		android.util.Log.d("leak-195-9", dataLeAk195);
		android.util.Log.d("leak-197-9", dataLeAk197);
		android.util.Log.d("leak-198-9", dataLeAk198);
		android.util.Log.d("leak-199-9", dataLeAk199);
		android.util.Log.d("leak-203-9", dataLeAk203);
		android.util.Log.d("leak-204-9", dataLeAk204);
		android.util.Log.d("leak-205-9", dataLeAk205);
		android.util.Log.d("leak-206-9", dataLeAk206);
		android.util.Log.d("leak-207-9", dataLeAk207);
		android.util.Log.d("leak-208-9", dataLeAk208);
		android.util.Log.d("leak-209-9", dataLeAk209);
		android.util.Log.d("leak-210-9", dataLeAk210);
		android.util.Log.d("leak-211-9", dataLeAk211);
		android.util.Log.d("leak-212-9", dataLeAk212);
		android.util.Log.d("leak-213-9", dataLeAk213);
		android.util.Log.d("leak-214-9", dataLeAk214);
		android.util.Log.d("leak-215-9", dataLeAk215);
		android.util.Log.d("leak-216-9", dataLeAk216);
		android.util.Log.d("leak-217-9", dataLeAk217);
		android.util.Log.d("leak-218-9", dataLeAk218);
		android.util.Log.d("leak-219-9", dataLeAk219);
		android.util.Log.d("leak-220-9", dataLeAk220);
		android.util.Log.d("leak-221-9", dataLeAk221);
		android.util.Log.d("leak-222-9", dataLeAk222);
		android.util.Log.d("leak-223-9", dataLeAk223);
		android.util.Log.d("leak-224-9", dataLeAk224);
		android.util.Log.d("leak-225-9", dataLeAk225);
		android.util.Log.d("leak-226-9", dataLeAk226);
		android.util.Log.d("leak-227-9", dataLeAk227);
		android.util.Log.d("leak-228-9", dataLeAk228);
		android.util.Log.d("leak-229-9", dataLeAk229);
		android.util.Log.d("leak-230-9", dataLeAk230);
		android.util.Log.d("leak-232-9", dataLeAk232);
		android.util.Log.d("leak-233-9", dataLeAk233);
		android.util.Log.d("leak-234-9", dataLeAk234);
		android.util.Log.d("leak-235-9", dataLeAk235);
		android.util.Log.d("leak-236-9", dataLeAk236);
		android.util.Log.d("leak-237-9", dataLeAk237);
		android.util.Log.d("leak-238-9", dataLeAk238);
		android.util.Log.d("leak-239-9", dataLeAk239);
		android.util.Log.d("leak-240-9", dataLeAk240);
		android.util.Log.d("leak-241-9", dataLeAk241);
		android.util.Log.d("leak-242-9", dataLeAk242);
		android.util.Log.d("leak-243-9", dataLeAk243);
		android.util.Log.d("leak-244-9", dataLeAk244);
		android.util.Log.d("leak-245-9", dataLeAk245);
		android.util.Log.d("leak-246-9", dataLeAk246);
		android.util.Log.d("leak-247-9", dataLeAk247);
		android.util.Log.d("leak-248-9", dataLeAk248);
		android.util.Log.d("leak-252-9", dataLeAk252);
		android.util.Log.d("leak-253-9", dataLeAk253);
		android.util.Log.d("leak-254-9", dataLeAk254);
		EditText edt = (EditText) findViewById(R.id.edtSearchWord);
        String search = edt.getText().toString();
        if (search != null && !search.equals("")) {
            String text = mText.getText().toString();
            if (text != null && !text.equals("")) {
                int start = text.toUpperCase().indexOf(search.toUpperCase(), mText.getSelectionEnd());
                if (start != -1) {
                    mText.requestFocus();
                    mText.setSelection(start, start + search.length());
                } else {
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
        dataLeAk204 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-10", dataLeAk190);
		android.util.Log.d("leak-191-10", dataLeAk191);
		android.util.Log.d("leak-192-10", dataLeAk192);
		android.util.Log.d("leak-193-10", dataLeAk193);
		android.util.Log.d("leak-194-10", dataLeAk194);
		android.util.Log.d("leak-195-10", dataLeAk195);
		android.util.Log.d("leak-197-10", dataLeAk197);
		android.util.Log.d("leak-198-10", dataLeAk198);
		android.util.Log.d("leak-199-10", dataLeAk199);
		android.util.Log.d("leak-203-10", dataLeAk203);
		android.util.Log.d("leak-204-10", dataLeAk204);
		android.util.Log.d("leak-205-10", dataLeAk205);
		android.util.Log.d("leak-206-10", dataLeAk206);
		android.util.Log.d("leak-207-10", dataLeAk207);
		android.util.Log.d("leak-208-10", dataLeAk208);
		android.util.Log.d("leak-209-10", dataLeAk209);
		android.util.Log.d("leak-210-10", dataLeAk210);
		android.util.Log.d("leak-211-10", dataLeAk211);
		android.util.Log.d("leak-212-10", dataLeAk212);
		android.util.Log.d("leak-213-10", dataLeAk213);
		android.util.Log.d("leak-214-10", dataLeAk214);
		android.util.Log.d("leak-215-10", dataLeAk215);
		android.util.Log.d("leak-216-10", dataLeAk216);
		android.util.Log.d("leak-217-10", dataLeAk217);
		android.util.Log.d("leak-218-10", dataLeAk218);
		android.util.Log.d("leak-219-10", dataLeAk219);
		android.util.Log.d("leak-220-10", dataLeAk220);
		android.util.Log.d("leak-221-10", dataLeAk221);
		android.util.Log.d("leak-222-10", dataLeAk222);
		android.util.Log.d("leak-223-10", dataLeAk223);
		android.util.Log.d("leak-224-10", dataLeAk224);
		android.util.Log.d("leak-225-10", dataLeAk225);
		android.util.Log.d("leak-226-10", dataLeAk226);
		android.util.Log.d("leak-227-10", dataLeAk227);
		android.util.Log.d("leak-228-10", dataLeAk228);
		android.util.Log.d("leak-229-10", dataLeAk229);
		android.util.Log.d("leak-230-10", dataLeAk230);
		android.util.Log.d("leak-232-10", dataLeAk232);
		android.util.Log.d("leak-233-10", dataLeAk233);
		android.util.Log.d("leak-234-10", dataLeAk234);
		android.util.Log.d("leak-235-10", dataLeAk235);
		android.util.Log.d("leak-236-10", dataLeAk236);
		android.util.Log.d("leak-237-10", dataLeAk237);
		android.util.Log.d("leak-238-10", dataLeAk238);
		android.util.Log.d("leak-239-10", dataLeAk239);
		android.util.Log.d("leak-240-10", dataLeAk240);
		android.util.Log.d("leak-241-10", dataLeAk241);
		android.util.Log.d("leak-242-10", dataLeAk242);
		android.util.Log.d("leak-243-10", dataLeAk243);
		android.util.Log.d("leak-244-10", dataLeAk244);
		android.util.Log.d("leak-245-10", dataLeAk245);
		android.util.Log.d("leak-246-10", dataLeAk246);
		android.util.Log.d("leak-247-10", dataLeAk247);
		android.util.Log.d("leak-248-10", dataLeAk248);
		android.util.Log.d("leak-252-10", dataLeAk252);
		android.util.Log.d("leak-253-10", dataLeAk253);
		android.util.Log.d("leak-254-10", dataLeAk254);
		EditText edt = (EditText) findViewById(R.id.edtSearchWord);
        String search = edt.getText().toString();
        if (search != null && !search.equals("")) {
            String text = mText.getText().toString();
            if (text != null && !text.equals("")) {
                int start = text.toUpperCase().lastIndexOf(search.toUpperCase(), mText.getSelectionStart() - 1);
                if (start != -1) {
                    mText.requestFocus();
                    mText.setSelection(start, start + search.length());
                } else {
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
        dataLeAk205 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-11", dataLeAk190);
		android.util.Log.d("leak-191-11", dataLeAk191);
		android.util.Log.d("leak-192-11", dataLeAk192);
		android.util.Log.d("leak-193-11", dataLeAk193);
		android.util.Log.d("leak-194-11", dataLeAk194);
		android.util.Log.d("leak-195-11", dataLeAk195);
		android.util.Log.d("leak-197-11", dataLeAk197);
		android.util.Log.d("leak-198-11", dataLeAk198);
		android.util.Log.d("leak-199-11", dataLeAk199);
		android.util.Log.d("leak-203-11", dataLeAk203);
		android.util.Log.d("leak-204-11", dataLeAk204);
		android.util.Log.d("leak-205-11", dataLeAk205);
		android.util.Log.d("leak-206-11", dataLeAk206);
		android.util.Log.d("leak-207-11", dataLeAk207);
		android.util.Log.d("leak-208-11", dataLeAk208);
		android.util.Log.d("leak-209-11", dataLeAk209);
		android.util.Log.d("leak-210-11", dataLeAk210);
		android.util.Log.d("leak-211-11", dataLeAk211);
		android.util.Log.d("leak-212-11", dataLeAk212);
		android.util.Log.d("leak-213-11", dataLeAk213);
		android.util.Log.d("leak-214-11", dataLeAk214);
		android.util.Log.d("leak-215-11", dataLeAk215);
		android.util.Log.d("leak-216-11", dataLeAk216);
		android.util.Log.d("leak-217-11", dataLeAk217);
		android.util.Log.d("leak-218-11", dataLeAk218);
		android.util.Log.d("leak-219-11", dataLeAk219);
		android.util.Log.d("leak-220-11", dataLeAk220);
		android.util.Log.d("leak-221-11", dataLeAk221);
		android.util.Log.d("leak-222-11", dataLeAk222);
		android.util.Log.d("leak-223-11", dataLeAk223);
		android.util.Log.d("leak-224-11", dataLeAk224);
		android.util.Log.d("leak-225-11", dataLeAk225);
		android.util.Log.d("leak-226-11", dataLeAk226);
		android.util.Log.d("leak-227-11", dataLeAk227);
		android.util.Log.d("leak-228-11", dataLeAk228);
		android.util.Log.d("leak-229-11", dataLeAk229);
		android.util.Log.d("leak-230-11", dataLeAk230);
		android.util.Log.d("leak-232-11", dataLeAk232);
		android.util.Log.d("leak-233-11", dataLeAk233);
		android.util.Log.d("leak-234-11", dataLeAk234);
		android.util.Log.d("leak-235-11", dataLeAk235);
		android.util.Log.d("leak-236-11", dataLeAk236);
		android.util.Log.d("leak-237-11", dataLeAk237);
		android.util.Log.d("leak-238-11", dataLeAk238);
		android.util.Log.d("leak-239-11", dataLeAk239);
		android.util.Log.d("leak-240-11", dataLeAk240);
		android.util.Log.d("leak-241-11", dataLeAk241);
		android.util.Log.d("leak-242-11", dataLeAk242);
		android.util.Log.d("leak-243-11", dataLeAk243);
		android.util.Log.d("leak-244-11", dataLeAk244);
		android.util.Log.d("leak-245-11", dataLeAk245);
		android.util.Log.d("leak-246-11", dataLeAk246);
		android.util.Log.d("leak-247-11", dataLeAk247);
		android.util.Log.d("leak-248-11", dataLeAk248);
		android.util.Log.d("leak-252-11", dataLeAk252);
		android.util.Log.d("leak-253-11", dataLeAk253);
		android.util.Log.d("leak-254-11", dataLeAk254);
		// If we didn't have any trouble retrieving the data, it is now
        // time to get at the stuff.
        if (mCursor != null && mCursor.requery() && mCursor.moveToFirst()) {

            // Modify our overall title depending on the mode we are running in.
            if (mState == STATE_EDIT || mState == STATE_EDIT_EXTERNAL_NOTE) {
                setTitle(getText(R.string.title_edit));
            } else if (mState == STATE_INSERT) {
                setTitle(getText(R.string.title_create));
            }

            // This always has to be available
            long id = mCursor.getLong(mCursor.getColumnIndex(Notes._ID));
            String note;

            if (mState == STATE_EDIT_EXTERNAL_NOTE) {
                // Check if the other columns are available

                // Note
                if (hasNoteColumn) {
                    note = mCursor
                            .getString(mCursor.getColumnIndex(Notes.NOTE));
                } else {
                    note = "";
                }

                // Encrypted
                mEncrypted = isNoteUnencrypted() ? 0 : 1;

                // Theme
                if (hasThemeColumn) {
                    mTheme = mCursor.getString(
                            mCursor
                                    .getColumnIndex(Notes.THEME)
                    );
                } else {
                    note = "";
                }

                // Selection start
                if (hasSelection_startColumn) {
                    mSelectionStart = mCursor.getInt(
                            mCursor
                                    .getColumnIndex(Notes.SELECTION_START)
                    );
                } else {
                    mSelectionStart = 0;
                }

                // Selection end
                if (hasSelection_endColumn) {
                    mSelectionStop = mCursor.getInt(
                            mCursor
                                    .getColumnIndex(Notes.SELECTION_END)
                    );
                } else {
                    mSelectionStop = 0;
                }
            } else {
                // We know for sure all the columns are available
                note = mCursor.getString(COLUMN_INDEX_NOTE);
                mEncrypted = mCursor.getLong(COLUMN_INDEX_ENCRYPTED);
                mTheme = mCursor.getString(COLUMN_INDEX_THEME);
                mSelectionStart = mCursor.getInt(COLUMN_INDEX_SELECTION_START);
                mSelectionStop = mCursor.getInt(COLUMN_INDEX_SELECTION_END);
            }

            if (mEncrypted == 0) {
                // Not encrypted

                // This is a little tricky: we may be resumed after previously
                // being
                // paused/stopped. We want to put the new text in the text view,
                // but leave the user where they were (retain the cursor
                // position
                // etc). This version of setText does that for us.
                if (!note.equals(mText.getText().toString())) {
                    mText.setTextKeepState(note);
                    // keep state does not work, so we have to do it manually:
                    mText.setSelection(mSelectionStart, mSelectionStop);
                }
            } else {
                if (mDecryptedText != null) {
                    // Text had already been decrypted, use that:
                    if (DEBUG) {
                        Log.d(
                                TAG, "set decrypted text as mText: "
                                        + mDecryptedText
                        );
                    }
                    mText.setTextKeepState(mDecryptedText);
                    // keep state does not work, so we have to do it manually:
                    mText.setSelection(mSelectionStart, mSelectionStop);

                    if (!mActionBarAvailable) {
                        setFeatureDrawableResource(
                                Window.FEATURE_RIGHT_ICON,
                                android.R.drawable.ic_lock_idle_lock
                        );
                    }
                } else {
                    // Decrypt note
                    if (DEBUG) {
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
                        if (checkCallingOrSelfPermission(CryptoIntents.PERMISSION_SAFE_ACCESS_INTENTS) == PackageManager.PERMISSION_GRANTED) {
                            startActivityForResult(i, REQUEST_CODE_DECRYPT);
                        } else {
                            Toast.makeText(
                                    this, R.string.decryption_failed_due_to_permissions,
                                    Toast.LENGTH_SHORT
                            ).show();
                        }
                    } catch (ActivityNotFoundException e) {
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
                mOriginalContent = note;
            }

        } else {
            setTitle(getText(R.string.error_title));
            mText.setText(getText(R.string.error_message));
        }
    }

    private void getNoteFromFile() {
        dataLeAk206 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-12", dataLeAk190);
		android.util.Log.d("leak-191-12", dataLeAk191);
		android.util.Log.d("leak-192-12", dataLeAk192);
		android.util.Log.d("leak-193-12", dataLeAk193);
		android.util.Log.d("leak-194-12", dataLeAk194);
		android.util.Log.d("leak-195-12", dataLeAk195);
		android.util.Log.d("leak-197-12", dataLeAk197);
		android.util.Log.d("leak-198-12", dataLeAk198);
		android.util.Log.d("leak-199-12", dataLeAk199);
		android.util.Log.d("leak-203-12", dataLeAk203);
		android.util.Log.d("leak-204-12", dataLeAk204);
		android.util.Log.d("leak-205-12", dataLeAk205);
		android.util.Log.d("leak-206-12", dataLeAk206);
		android.util.Log.d("leak-207-12", dataLeAk207);
		android.util.Log.d("leak-208-12", dataLeAk208);
		android.util.Log.d("leak-209-12", dataLeAk209);
		android.util.Log.d("leak-210-12", dataLeAk210);
		android.util.Log.d("leak-211-12", dataLeAk211);
		android.util.Log.d("leak-212-12", dataLeAk212);
		android.util.Log.d("leak-213-12", dataLeAk213);
		android.util.Log.d("leak-214-12", dataLeAk214);
		android.util.Log.d("leak-215-12", dataLeAk215);
		android.util.Log.d("leak-216-12", dataLeAk216);
		android.util.Log.d("leak-217-12", dataLeAk217);
		android.util.Log.d("leak-218-12", dataLeAk218);
		android.util.Log.d("leak-219-12", dataLeAk219);
		android.util.Log.d("leak-220-12", dataLeAk220);
		android.util.Log.d("leak-221-12", dataLeAk221);
		android.util.Log.d("leak-222-12", dataLeAk222);
		android.util.Log.d("leak-223-12", dataLeAk223);
		android.util.Log.d("leak-224-12", dataLeAk224);
		android.util.Log.d("leak-225-12", dataLeAk225);
		android.util.Log.d("leak-226-12", dataLeAk226);
		android.util.Log.d("leak-227-12", dataLeAk227);
		android.util.Log.d("leak-228-12", dataLeAk228);
		android.util.Log.d("leak-229-12", dataLeAk229);
		android.util.Log.d("leak-230-12", dataLeAk230);
		android.util.Log.d("leak-232-12", dataLeAk232);
		android.util.Log.d("leak-233-12", dataLeAk233);
		android.util.Log.d("leak-234-12", dataLeAk234);
		android.util.Log.d("leak-235-12", dataLeAk235);
		android.util.Log.d("leak-236-12", dataLeAk236);
		android.util.Log.d("leak-237-12", dataLeAk237);
		android.util.Log.d("leak-238-12", dataLeAk238);
		android.util.Log.d("leak-239-12", dataLeAk239);
		android.util.Log.d("leak-240-12", dataLeAk240);
		android.util.Log.d("leak-241-12", dataLeAk241);
		android.util.Log.d("leak-242-12", dataLeAk242);
		android.util.Log.d("leak-243-12", dataLeAk243);
		android.util.Log.d("leak-244-12", dataLeAk244);
		android.util.Log.d("leak-245-12", dataLeAk245);
		android.util.Log.d("leak-246-12", dataLeAk246);
		android.util.Log.d("leak-247-12", dataLeAk247);
		android.util.Log.d("leak-248-12", dataLeAk248);
		android.util.Log.d("leak-252-12", dataLeAk252);
		android.util.Log.d("leak-253-12", dataLeAk253);
		android.util.Log.d("leak-254-12", dataLeAk254);
		if (DEBUG) {
            Log.d(TAG, "file: " + mFileContent);
        }
        if (mFileContent == null) {
            // TODO
            mFileContent = "error";
            mReadOnly = true;
        }

        mText.setTextKeepState(mFileContent);

        // keep state does not work, so we have to do it manually:
        try {
            mText.setSelection(mSelectionStart, mSelectionStop);
        } catch (IndexOutOfBoundsException e) {
            // Then let's not adjust the selection.
        }

        // If we hadn't previously retrieved the original text, do so
        // now. This allows the user to revert their changes.
        if (mOriginalContent == null) {
            mOriginalContent = mFileContent;
        }

        updateTitleSdCard();
    }

    private void updateTitleSdCard() {
        dataLeAk207 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-13", dataLeAk190);
		android.util.Log.d("leak-191-13", dataLeAk191);
		android.util.Log.d("leak-192-13", dataLeAk192);
		android.util.Log.d("leak-193-13", dataLeAk193);
		android.util.Log.d("leak-194-13", dataLeAk194);
		android.util.Log.d("leak-195-13", dataLeAk195);
		android.util.Log.d("leak-197-13", dataLeAk197);
		android.util.Log.d("leak-198-13", dataLeAk198);
		android.util.Log.d("leak-199-13", dataLeAk199);
		android.util.Log.d("leak-203-13", dataLeAk203);
		android.util.Log.d("leak-204-13", dataLeAk204);
		android.util.Log.d("leak-205-13", dataLeAk205);
		android.util.Log.d("leak-206-13", dataLeAk206);
		android.util.Log.d("leak-207-13", dataLeAk207);
		android.util.Log.d("leak-208-13", dataLeAk208);
		android.util.Log.d("leak-209-13", dataLeAk209);
		android.util.Log.d("leak-210-13", dataLeAk210);
		android.util.Log.d("leak-211-13", dataLeAk211);
		android.util.Log.d("leak-212-13", dataLeAk212);
		android.util.Log.d("leak-213-13", dataLeAk213);
		android.util.Log.d("leak-214-13", dataLeAk214);
		android.util.Log.d("leak-215-13", dataLeAk215);
		android.util.Log.d("leak-216-13", dataLeAk216);
		android.util.Log.d("leak-217-13", dataLeAk217);
		android.util.Log.d("leak-218-13", dataLeAk218);
		android.util.Log.d("leak-219-13", dataLeAk219);
		android.util.Log.d("leak-220-13", dataLeAk220);
		android.util.Log.d("leak-221-13", dataLeAk221);
		android.util.Log.d("leak-222-13", dataLeAk222);
		android.util.Log.d("leak-223-13", dataLeAk223);
		android.util.Log.d("leak-224-13", dataLeAk224);
		android.util.Log.d("leak-225-13", dataLeAk225);
		android.util.Log.d("leak-226-13", dataLeAk226);
		android.util.Log.d("leak-227-13", dataLeAk227);
		android.util.Log.d("leak-228-13", dataLeAk228);
		android.util.Log.d("leak-229-13", dataLeAk229);
		android.util.Log.d("leak-230-13", dataLeAk230);
		android.util.Log.d("leak-232-13", dataLeAk232);
		android.util.Log.d("leak-233-13", dataLeAk233);
		android.util.Log.d("leak-234-13", dataLeAk234);
		android.util.Log.d("leak-235-13", dataLeAk235);
		android.util.Log.d("leak-236-13", dataLeAk236);
		android.util.Log.d("leak-237-13", dataLeAk237);
		android.util.Log.d("leak-238-13", dataLeAk238);
		android.util.Log.d("leak-239-13", dataLeAk239);
		android.util.Log.d("leak-240-13", dataLeAk240);
		android.util.Log.d("leak-241-13", dataLeAk241);
		android.util.Log.d("leak-242-13", dataLeAk242);
		android.util.Log.d("leak-243-13", dataLeAk243);
		android.util.Log.d("leak-244-13", dataLeAk244);
		android.util.Log.d("leak-245-13", dataLeAk245);
		android.util.Log.d("leak-246-13", dataLeAk246);
		android.util.Log.d("leak-247-13", dataLeAk247);
		android.util.Log.d("leak-248-13", dataLeAk248);
		android.util.Log.d("leak-252-13", dataLeAk252);
		android.util.Log.d("leak-253-13", dataLeAk253);
		android.util.Log.d("leak-254-13", dataLeAk254);
		String modified = "";
        if (mOriginalContent != null && !mOriginalContent.equals(mFileContent)) {
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
        dataLeAk208 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-14", dataLeAk190);
		android.util.Log.d("leak-191-14", dataLeAk191);
		android.util.Log.d("leak-192-14", dataLeAk192);
		android.util.Log.d("leak-193-14", dataLeAk193);
		android.util.Log.d("leak-194-14", dataLeAk194);
		android.util.Log.d("leak-195-14", dataLeAk195);
		android.util.Log.d("leak-197-14", dataLeAk197);
		android.util.Log.d("leak-198-14", dataLeAk198);
		android.util.Log.d("leak-199-14", dataLeAk199);
		android.util.Log.d("leak-203-14", dataLeAk203);
		android.util.Log.d("leak-204-14", dataLeAk204);
		android.util.Log.d("leak-205-14", dataLeAk205);
		android.util.Log.d("leak-206-14", dataLeAk206);
		android.util.Log.d("leak-207-14", dataLeAk207);
		android.util.Log.d("leak-208-14", dataLeAk208);
		android.util.Log.d("leak-209-14", dataLeAk209);
		android.util.Log.d("leak-210-14", dataLeAk210);
		android.util.Log.d("leak-211-14", dataLeAk211);
		android.util.Log.d("leak-212-14", dataLeAk212);
		android.util.Log.d("leak-213-14", dataLeAk213);
		android.util.Log.d("leak-214-14", dataLeAk214);
		android.util.Log.d("leak-215-14", dataLeAk215);
		android.util.Log.d("leak-216-14", dataLeAk216);
		android.util.Log.d("leak-217-14", dataLeAk217);
		android.util.Log.d("leak-218-14", dataLeAk218);
		android.util.Log.d("leak-219-14", dataLeAk219);
		android.util.Log.d("leak-220-14", dataLeAk220);
		android.util.Log.d("leak-221-14", dataLeAk221);
		android.util.Log.d("leak-222-14", dataLeAk222);
		android.util.Log.d("leak-223-14", dataLeAk223);
		android.util.Log.d("leak-224-14", dataLeAk224);
		android.util.Log.d("leak-225-14", dataLeAk225);
		android.util.Log.d("leak-226-14", dataLeAk226);
		android.util.Log.d("leak-227-14", dataLeAk227);
		android.util.Log.d("leak-228-14", dataLeAk228);
		android.util.Log.d("leak-229-14", dataLeAk229);
		android.util.Log.d("leak-230-14", dataLeAk230);
		android.util.Log.d("leak-232-14", dataLeAk232);
		android.util.Log.d("leak-233-14", dataLeAk233);
		android.util.Log.d("leak-234-14", dataLeAk234);
		android.util.Log.d("leak-235-14", dataLeAk235);
		android.util.Log.d("leak-236-14", dataLeAk236);
		android.util.Log.d("leak-237-14", dataLeAk237);
		android.util.Log.d("leak-238-14", dataLeAk238);
		android.util.Log.d("leak-239-14", dataLeAk239);
		android.util.Log.d("leak-240-14", dataLeAk240);
		android.util.Log.d("leak-241-14", dataLeAk241);
		android.util.Log.d("leak-242-14", dataLeAk242);
		android.util.Log.d("leak-243-14", dataLeAk243);
		android.util.Log.d("leak-244-14", dataLeAk244);
		android.util.Log.d("leak-245-14", dataLeAk245);
		android.util.Log.d("leak-246-14", dataLeAk246);
		android.util.Log.d("leak-247-14", dataLeAk247);
		android.util.Log.d("leak-248-14", dataLeAk248);
		android.util.Log.d("leak-252-14", dataLeAk252);
		android.util.Log.d("leak-253-14", dataLeAk253);
		android.util.Log.d("leak-254-14", dataLeAk254);
		boolean charCountVisible = false;
        String currentTitle = getTitle().toString();
        if (currentTitle.startsWith("[")) {
            charCountVisible = true;
        }
        if (PreferenceActivity.getCharCountEnabledFromPrefs(this)) {
            if (charCountVisible) {
                setTitle(
                        "[" + mText.length() + "]"
                                + currentTitle.substring(currentTitle.indexOf(" "))
                );
            } else {
                setTitle("[" + mText.length() + "] " + currentTitle);
            }
        } else {
            if (charCountVisible) {
                setTitle(currentTitle.substring(currentTitle.indexOf(" ")));
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        dataLeAk209 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-15", dataLeAk190);
		android.util.Log.d("leak-191-15", dataLeAk191);
		android.util.Log.d("leak-192-15", dataLeAk192);
		android.util.Log.d("leak-193-15", dataLeAk193);
		android.util.Log.d("leak-194-15", dataLeAk194);
		android.util.Log.d("leak-195-15", dataLeAk195);
		android.util.Log.d("leak-197-15", dataLeAk197);
		android.util.Log.d("leak-198-15", dataLeAk198);
		android.util.Log.d("leak-199-15", dataLeAk199);
		android.util.Log.d("leak-203-15", dataLeAk203);
		android.util.Log.d("leak-204-15", dataLeAk204);
		android.util.Log.d("leak-205-15", dataLeAk205);
		android.util.Log.d("leak-206-15", dataLeAk206);
		android.util.Log.d("leak-207-15", dataLeAk207);
		android.util.Log.d("leak-208-15", dataLeAk208);
		android.util.Log.d("leak-209-15", dataLeAk209);
		android.util.Log.d("leak-210-15", dataLeAk210);
		android.util.Log.d("leak-211-15", dataLeAk211);
		android.util.Log.d("leak-212-15", dataLeAk212);
		android.util.Log.d("leak-213-15", dataLeAk213);
		android.util.Log.d("leak-214-15", dataLeAk214);
		android.util.Log.d("leak-215-15", dataLeAk215);
		android.util.Log.d("leak-216-15", dataLeAk216);
		android.util.Log.d("leak-217-15", dataLeAk217);
		android.util.Log.d("leak-218-15", dataLeAk218);
		android.util.Log.d("leak-219-15", dataLeAk219);
		android.util.Log.d("leak-220-15", dataLeAk220);
		android.util.Log.d("leak-221-15", dataLeAk221);
		android.util.Log.d("leak-222-15", dataLeAk222);
		android.util.Log.d("leak-223-15", dataLeAk223);
		android.util.Log.d("leak-224-15", dataLeAk224);
		android.util.Log.d("leak-225-15", dataLeAk225);
		android.util.Log.d("leak-226-15", dataLeAk226);
		android.util.Log.d("leak-227-15", dataLeAk227);
		android.util.Log.d("leak-228-15", dataLeAk228);
		android.util.Log.d("leak-229-15", dataLeAk229);
		android.util.Log.d("leak-230-15", dataLeAk230);
		android.util.Log.d("leak-232-15", dataLeAk232);
		android.util.Log.d("leak-233-15", dataLeAk233);
		android.util.Log.d("leak-234-15", dataLeAk234);
		android.util.Log.d("leak-235-15", dataLeAk235);
		android.util.Log.d("leak-236-15", dataLeAk236);
		android.util.Log.d("leak-237-15", dataLeAk237);
		android.util.Log.d("leak-238-15", dataLeAk238);
		android.util.Log.d("leak-239-15", dataLeAk239);
		android.util.Log.d("leak-240-15", dataLeAk240);
		android.util.Log.d("leak-241-15", dataLeAk241);
		android.util.Log.d("leak-242-15", dataLeAk242);
		android.util.Log.d("leak-243-15", dataLeAk243);
		android.util.Log.d("leak-244-15", dataLeAk244);
		android.util.Log.d("leak-245-15", dataLeAk245);
		android.util.Log.d("leak-246-15", dataLeAk246);
		android.util.Log.d("leak-247-15", dataLeAk247);
		android.util.Log.d("leak-248-15", dataLeAk248);
		android.util.Log.d("leak-252-15", dataLeAk252);
		android.util.Log.d("leak-253-15", dataLeAk253);
		android.util.Log.d("leak-254-15", dataLeAk254);
		if (DEBUG) {
            Log.d(TAG, "onSaveInstanceState");
        }
        // if (DEBUG) Log.d(TAG, "file content: " + mFileContent);

        // Save away the original text, so we still have it if the activity
        // needs to be killed while paused.
        mSelectionStart = mText.getSelectionStart();
        mSelectionStop = mText.getSelectionEnd();
        mFileContent = mText.getText().toString();

        if (DEBUG) {
            Log.d(
                    TAG, "Selection " + mSelectionStart + " - " + mSelectionStop
                            + " for text : " + mFileContent
            );
        }

        outState.putString(BUNDLE_ORIGINAL_CONTENT, mOriginalContent);
        outState.putString(BUNDLE_UNDO_REVERT, mUndoRevert);
        outState.putInt(BUNDLE_STATE, mState);
        if (mUri != null) {
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
		dataLeAk210 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-16", dataLeAk190);
		android.util.Log.d("leak-191-16", dataLeAk191);
		android.util.Log.d("leak-192-16", dataLeAk192);
		android.util.Log.d("leak-193-16", dataLeAk193);
		android.util.Log.d("leak-194-16", dataLeAk194);
		android.util.Log.d("leak-195-16", dataLeAk195);
		android.util.Log.d("leak-197-16", dataLeAk197);
		android.util.Log.d("leak-198-16", dataLeAk198);
		android.util.Log.d("leak-199-16", dataLeAk199);
		android.util.Log.d("leak-203-16", dataLeAk203);
		android.util.Log.d("leak-204-16", dataLeAk204);
		android.util.Log.d("leak-205-16", dataLeAk205);
		android.util.Log.d("leak-206-16", dataLeAk206);
		android.util.Log.d("leak-207-16", dataLeAk207);
		android.util.Log.d("leak-208-16", dataLeAk208);
		android.util.Log.d("leak-209-16", dataLeAk209);
		android.util.Log.d("leak-210-16", dataLeAk210);
		android.util.Log.d("leak-211-16", dataLeAk211);
		android.util.Log.d("leak-212-16", dataLeAk212);
		android.util.Log.d("leak-213-16", dataLeAk213);
		android.util.Log.d("leak-214-16", dataLeAk214);
		android.util.Log.d("leak-215-16", dataLeAk215);
		android.util.Log.d("leak-216-16", dataLeAk216);
		android.util.Log.d("leak-217-16", dataLeAk217);
		android.util.Log.d("leak-218-16", dataLeAk218);
		android.util.Log.d("leak-219-16", dataLeAk219);
		android.util.Log.d("leak-220-16", dataLeAk220);
		android.util.Log.d("leak-221-16", dataLeAk221);
		android.util.Log.d("leak-222-16", dataLeAk222);
		android.util.Log.d("leak-223-16", dataLeAk223);
		android.util.Log.d("leak-224-16", dataLeAk224);
		android.util.Log.d("leak-225-16", dataLeAk225);
		android.util.Log.d("leak-226-16", dataLeAk226);
		android.util.Log.d("leak-227-16", dataLeAk227);
		android.util.Log.d("leak-228-16", dataLeAk228);
		android.util.Log.d("leak-229-16", dataLeAk229);
		android.util.Log.d("leak-230-16", dataLeAk230);
		android.util.Log.d("leak-232-16", dataLeAk232);
		android.util.Log.d("leak-233-16", dataLeAk233);
		android.util.Log.d("leak-234-16", dataLeAk234);
		android.util.Log.d("leak-235-16", dataLeAk235);
		android.util.Log.d("leak-236-16", dataLeAk236);
		android.util.Log.d("leak-237-16", dataLeAk237);
		android.util.Log.d("leak-238-16", dataLeAk238);
		android.util.Log.d("leak-239-16", dataLeAk239);
		android.util.Log.d("leak-240-16", dataLeAk240);
		android.util.Log.d("leak-241-16", dataLeAk241);
		android.util.Log.d("leak-242-16", dataLeAk242);
		android.util.Log.d("leak-243-16", dataLeAk243);
		android.util.Log.d("leak-244-16", dataLeAk244);
		android.util.Log.d("leak-245-16", dataLeAk245);
		android.util.Log.d("leak-246-16", dataLeAk246);
		android.util.Log.d("leak-247-16", dataLeAk247);
		android.util.Log.d("leak-248-16", dataLeAk248);
		android.util.Log.d("leak-252-16", dataLeAk252);
		android.util.Log.d("leak-253-16", dataLeAk253);
		android.util.Log.d("leak-254-16", dataLeAk254);
        if (DEBUG) {
            Log.d(TAG, "onPause");
        }

        mText.setAutoLinkMask(0);

        // The user is going somewhere else, so make sure their current
        // changes are safely saved away in the provider. We don't need
        // to do this if only editing.
        if (mCursor != null) {

            mCursor.moveToFirst();

            if (isNoteUnencrypted()) {
                String text = mText.getText().toString();
                int length = text.length();

                // If this activity is finished, and there is no text, then we
                // do something a little special: simply delete the note entry.
                // Note that we do this both for editing and inserting... it
                // would be reasonable to only do it when inserting.
                if (isFinishing() && (length == 0) && !mNoteOnly) {
                    setResult(RESULT_CANCELED);
                    deleteNote();

                    // Get out updates into the provider.
                } else {
                    ContentValues values = new ContentValues();

                    // This stuff is only done when working with a full-fledged
                    // note.
                    if (!mNoteOnly) {
                        String oldText = "";
                        Cursor cursor = getContentResolver().query(
                                mUri,
                                new String[]{"note"}, null, null, null
                        );
                        if (cursor.moveToFirst()) {
                            oldText = cursor.getString(0);
                        }
                        if (!oldText.equals(text)) {
                            // Bump the modification time to now.
                            values.put(
                                    Notes.MODIFIED_DATE,
                                    System.currentTimeMillis()
                            );
                        }

                        String title;
                        if (!PreferenceActivity.getMarqueeFromPrefs(this)) {
                            title = ExtractTitle.extractTitle(text);
                        } else {
                            title = text;
                        }
                        values.put(Notes.TITLE, title);
                    }

                    // Write our text back into the provider.
                    if (hasNoteColumn) {
                        values.put(Notes.NOTE, text);
                    }
                    if (hasThemeColumn) {
                        values.put(Notes.THEME, mTheme);
                    }
                    if (hasSelection_startColumn) {
                        values.put(
                                Notes.SELECTION_START,
                                mText.getSelectionStart()
                        );
                    }
                    if (hasSelection_endColumn) {
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

                // Save current theme:
                ContentValues values = new ContentValues();

                if (hasThemeColumn) {
                    values.put(Notes.THEME, mTheme);
                }

                getContentResolver().update(mUri, values, null, null);

                if (mDecryptedText != null) {
                    // Decrypted had been decrypted.
                    // We take the current version from 'text' and encrypt it.

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
        dataLeAk211 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-17", dataLeAk190);
		android.util.Log.d("leak-191-17", dataLeAk191);
		android.util.Log.d("leak-192-17", dataLeAk192);
		android.util.Log.d("leak-193-17", dataLeAk193);
		android.util.Log.d("leak-194-17", dataLeAk194);
		android.util.Log.d("leak-195-17", dataLeAk195);
		android.util.Log.d("leak-197-17", dataLeAk197);
		android.util.Log.d("leak-198-17", dataLeAk198);
		android.util.Log.d("leak-199-17", dataLeAk199);
		android.util.Log.d("leak-203-17", dataLeAk203);
		android.util.Log.d("leak-204-17", dataLeAk204);
		android.util.Log.d("leak-205-17", dataLeAk205);
		android.util.Log.d("leak-206-17", dataLeAk206);
		android.util.Log.d("leak-207-17", dataLeAk207);
		android.util.Log.d("leak-208-17", dataLeAk208);
		android.util.Log.d("leak-209-17", dataLeAk209);
		android.util.Log.d("leak-210-17", dataLeAk210);
		android.util.Log.d("leak-211-17", dataLeAk211);
		android.util.Log.d("leak-212-17", dataLeAk212);
		android.util.Log.d("leak-213-17", dataLeAk213);
		android.util.Log.d("leak-214-17", dataLeAk214);
		android.util.Log.d("leak-215-17", dataLeAk215);
		android.util.Log.d("leak-216-17", dataLeAk216);
		android.util.Log.d("leak-217-17", dataLeAk217);
		android.util.Log.d("leak-218-17", dataLeAk218);
		android.util.Log.d("leak-219-17", dataLeAk219);
		android.util.Log.d("leak-220-17", dataLeAk220);
		android.util.Log.d("leak-221-17", dataLeAk221);
		android.util.Log.d("leak-222-17", dataLeAk222);
		android.util.Log.d("leak-223-17", dataLeAk223);
		android.util.Log.d("leak-224-17", dataLeAk224);
		android.util.Log.d("leak-225-17", dataLeAk225);
		android.util.Log.d("leak-226-17", dataLeAk226);
		android.util.Log.d("leak-227-17", dataLeAk227);
		android.util.Log.d("leak-228-17", dataLeAk228);
		android.util.Log.d("leak-229-17", dataLeAk229);
		android.util.Log.d("leak-230-17", dataLeAk230);
		android.util.Log.d("leak-232-17", dataLeAk232);
		android.util.Log.d("leak-233-17", dataLeAk233);
		android.util.Log.d("leak-234-17", dataLeAk234);
		android.util.Log.d("leak-235-17", dataLeAk235);
		android.util.Log.d("leak-236-17", dataLeAk236);
		android.util.Log.d("leak-237-17", dataLeAk237);
		android.util.Log.d("leak-238-17", dataLeAk238);
		android.util.Log.d("leak-239-17", dataLeAk239);
		android.util.Log.d("leak-240-17", dataLeAk240);
		android.util.Log.d("leak-241-17", dataLeAk241);
		android.util.Log.d("leak-242-17", dataLeAk242);
		android.util.Log.d("leak-243-17", dataLeAk243);
		android.util.Log.d("leak-244-17", dataLeAk244);
		android.util.Log.d("leak-245-17", dataLeAk245);
		android.util.Log.d("leak-246-17", dataLeAk246);
		android.util.Log.d("leak-247-17", dataLeAk247);
		android.util.Log.d("leak-248-17", dataLeAk248);
		android.util.Log.d("leak-252-17", dataLeAk252);
		android.util.Log.d("leak-253-17", dataLeAk253);
		android.util.Log.d("leak-254-17", dataLeAk254);
		String text = mText.getText().toString();
        String title;
        if (!PreferenceActivity.getMarqueeFromPrefs(this)) {
            title = ExtractTitle.extractTitle(text);
        } else {
            title = text;
        }
        String tags = getTags();
        // Log.i(TAG, "encrypt tags: " + tags);

        boolean isNoteEncrypted = !isNoteUnencrypted();

        if (!encryptTags) {
            tags = null;
        }

        if (DEBUG) {
            Log.d(TAG, "encrypt note: " + text);
        }

        if (EncryptActivity.getPendingEncryptActivities() == 0) {
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
                // No need to encrypt, content was not modified.
                i.putExtra(PrivateNotePadIntents.EXTRA_CONTENT_UNCHANGED, true);
            }
            startActivity(i);

            // Remove knowledge of the decrypted note.
            // If encryption fails because one has been locked out, (another)
            // user
            // should not be able to see note again from cache.
            if (DEBUG) {
                Log.d(TAG, "using static decrypted text: " + text);
            }
            sDecryptedText = text;
            if (isNoteEncrypted) {
                // Already encrypted
                mDecryptedText = null;
                mText.setText(R.string.encrypted);
            } else {
                // not yet encrypted, but we want to encrypt.
                // Leave mText until note is really encrypted
                // (in case password is not entered or OI Safw not installed)
            }
            EncryptActivity.confirmEncryptActivityCalled();
        } else {
            // encrypt already called
            if (DEBUG) {
                Log.d(TAG, "encrypt already called");
            }

        }

    }

    /**
     * Unencrypt the current note.
     */
    private void unencryptNote() {
        dataLeAk212 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-18", dataLeAk190);
		android.util.Log.d("leak-191-18", dataLeAk191);
		android.util.Log.d("leak-192-18", dataLeAk192);
		android.util.Log.d("leak-193-18", dataLeAk193);
		android.util.Log.d("leak-194-18", dataLeAk194);
		android.util.Log.d("leak-195-18", dataLeAk195);
		android.util.Log.d("leak-197-18", dataLeAk197);
		android.util.Log.d("leak-198-18", dataLeAk198);
		android.util.Log.d("leak-199-18", dataLeAk199);
		android.util.Log.d("leak-203-18", dataLeAk203);
		android.util.Log.d("leak-204-18", dataLeAk204);
		android.util.Log.d("leak-205-18", dataLeAk205);
		android.util.Log.d("leak-206-18", dataLeAk206);
		android.util.Log.d("leak-207-18", dataLeAk207);
		android.util.Log.d("leak-208-18", dataLeAk208);
		android.util.Log.d("leak-209-18", dataLeAk209);
		android.util.Log.d("leak-210-18", dataLeAk210);
		android.util.Log.d("leak-211-18", dataLeAk211);
		android.util.Log.d("leak-212-18", dataLeAk212);
		android.util.Log.d("leak-213-18", dataLeAk213);
		android.util.Log.d("leak-214-18", dataLeAk214);
		android.util.Log.d("leak-215-18", dataLeAk215);
		android.util.Log.d("leak-216-18", dataLeAk216);
		android.util.Log.d("leak-217-18", dataLeAk217);
		android.util.Log.d("leak-218-18", dataLeAk218);
		android.util.Log.d("leak-219-18", dataLeAk219);
		android.util.Log.d("leak-220-18", dataLeAk220);
		android.util.Log.d("leak-221-18", dataLeAk221);
		android.util.Log.d("leak-222-18", dataLeAk222);
		android.util.Log.d("leak-223-18", dataLeAk223);
		android.util.Log.d("leak-224-18", dataLeAk224);
		android.util.Log.d("leak-225-18", dataLeAk225);
		android.util.Log.d("leak-226-18", dataLeAk226);
		android.util.Log.d("leak-227-18", dataLeAk227);
		android.util.Log.d("leak-228-18", dataLeAk228);
		android.util.Log.d("leak-229-18", dataLeAk229);
		android.util.Log.d("leak-230-18", dataLeAk230);
		android.util.Log.d("leak-232-18", dataLeAk232);
		android.util.Log.d("leak-233-18", dataLeAk233);
		android.util.Log.d("leak-234-18", dataLeAk234);
		android.util.Log.d("leak-235-18", dataLeAk235);
		android.util.Log.d("leak-236-18", dataLeAk236);
		android.util.Log.d("leak-237-18", dataLeAk237);
		android.util.Log.d("leak-238-18", dataLeAk238);
		android.util.Log.d("leak-239-18", dataLeAk239);
		android.util.Log.d("leak-240-18", dataLeAk240);
		android.util.Log.d("leak-241-18", dataLeAk241);
		android.util.Log.d("leak-242-18", dataLeAk242);
		android.util.Log.d("leak-243-18", dataLeAk243);
		android.util.Log.d("leak-244-18", dataLeAk244);
		android.util.Log.d("leak-245-18", dataLeAk245);
		android.util.Log.d("leak-246-18", dataLeAk246);
		android.util.Log.d("leak-247-18", dataLeAk247);
		android.util.Log.d("leak-248-18", dataLeAk248);
		android.util.Log.d("leak-252-18", dataLeAk252);
		android.util.Log.d("leak-253-18", dataLeAk253);
		android.util.Log.d("leak-254-18", dataLeAk254);
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
        dataLeAk213 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-19", dataLeAk190);
		android.util.Log.d("leak-191-19", dataLeAk191);
		android.util.Log.d("leak-192-19", dataLeAk192);
		android.util.Log.d("leak-193-19", dataLeAk193);
		android.util.Log.d("leak-194-19", dataLeAk194);
		android.util.Log.d("leak-195-19", dataLeAk195);
		android.util.Log.d("leak-197-19", dataLeAk197);
		android.util.Log.d("leak-198-19", dataLeAk198);
		android.util.Log.d("leak-199-19", dataLeAk199);
		android.util.Log.d("leak-203-19", dataLeAk203);
		android.util.Log.d("leak-204-19", dataLeAk204);
		android.util.Log.d("leak-205-19", dataLeAk205);
		android.util.Log.d("leak-206-19", dataLeAk206);
		android.util.Log.d("leak-207-19", dataLeAk207);
		android.util.Log.d("leak-208-19", dataLeAk208);
		android.util.Log.d("leak-209-19", dataLeAk209);
		android.util.Log.d("leak-210-19", dataLeAk210);
		android.util.Log.d("leak-211-19", dataLeAk211);
		android.util.Log.d("leak-212-19", dataLeAk212);
		android.util.Log.d("leak-213-19", dataLeAk213);
		android.util.Log.d("leak-214-19", dataLeAk214);
		android.util.Log.d("leak-215-19", dataLeAk215);
		android.util.Log.d("leak-216-19", dataLeAk216);
		android.util.Log.d("leak-217-19", dataLeAk217);
		android.util.Log.d("leak-218-19", dataLeAk218);
		android.util.Log.d("leak-219-19", dataLeAk219);
		android.util.Log.d("leak-220-19", dataLeAk220);
		android.util.Log.d("leak-221-19", dataLeAk221);
		android.util.Log.d("leak-222-19", dataLeAk222);
		android.util.Log.d("leak-223-19", dataLeAk223);
		android.util.Log.d("leak-224-19", dataLeAk224);
		android.util.Log.d("leak-225-19", dataLeAk225);
		android.util.Log.d("leak-226-19", dataLeAk226);
		android.util.Log.d("leak-227-19", dataLeAk227);
		android.util.Log.d("leak-228-19", dataLeAk228);
		android.util.Log.d("leak-229-19", dataLeAk229);
		android.util.Log.d("leak-230-19", dataLeAk230);
		android.util.Log.d("leak-232-19", dataLeAk232);
		android.util.Log.d("leak-233-19", dataLeAk233);
		android.util.Log.d("leak-234-19", dataLeAk234);
		android.util.Log.d("leak-235-19", dataLeAk235);
		android.util.Log.d("leak-236-19", dataLeAk236);
		android.util.Log.d("leak-237-19", dataLeAk237);
		android.util.Log.d("leak-238-19", dataLeAk238);
		android.util.Log.d("leak-239-19", dataLeAk239);
		android.util.Log.d("leak-240-19", dataLeAk240);
		android.util.Log.d("leak-241-19", dataLeAk241);
		android.util.Log.d("leak-242-19", dataLeAk242);
		android.util.Log.d("leak-243-19", dataLeAk243);
		android.util.Log.d("leak-244-19", dataLeAk244);
		android.util.Log.d("leak-245-19", dataLeAk245);
		android.util.Log.d("leak-246-19", dataLeAk246);
		android.util.Log.d("leak-247-19", dataLeAk247);
		android.util.Log.d("leak-248-19", dataLeAk248);
		android.util.Log.d("leak-252-19", dataLeAk252);
		android.util.Log.d("leak-253-19", dataLeAk253);
		android.util.Log.d("leak-254-19", dataLeAk254);
		long encrypted = 0;
        if (mCursor != null && mCursor.moveToFirst()) {
            // Check if the column Notes.ENCRYPTED exists
            if (hasEncryptionColumn) {
                encrypted = mCursor.getInt(
                        mCursor
                                .getColumnIndex(Notes.ENCRYPTED)
                );
            } else {
                encrypted = 0;
            }
        }
        return encrypted == 0;
    }

    private String getTags() {
        dataLeAk214 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-20", dataLeAk190);
		android.util.Log.d("leak-191-20", dataLeAk191);
		android.util.Log.d("leak-192-20", dataLeAk192);
		android.util.Log.d("leak-193-20", dataLeAk193);
		android.util.Log.d("leak-194-20", dataLeAk194);
		android.util.Log.d("leak-195-20", dataLeAk195);
		android.util.Log.d("leak-197-20", dataLeAk197);
		android.util.Log.d("leak-198-20", dataLeAk198);
		android.util.Log.d("leak-199-20", dataLeAk199);
		android.util.Log.d("leak-203-20", dataLeAk203);
		android.util.Log.d("leak-204-20", dataLeAk204);
		android.util.Log.d("leak-205-20", dataLeAk205);
		android.util.Log.d("leak-206-20", dataLeAk206);
		android.util.Log.d("leak-207-20", dataLeAk207);
		android.util.Log.d("leak-208-20", dataLeAk208);
		android.util.Log.d("leak-209-20", dataLeAk209);
		android.util.Log.d("leak-210-20", dataLeAk210);
		android.util.Log.d("leak-211-20", dataLeAk211);
		android.util.Log.d("leak-212-20", dataLeAk212);
		android.util.Log.d("leak-213-20", dataLeAk213);
		android.util.Log.d("leak-214-20", dataLeAk214);
		android.util.Log.d("leak-215-20", dataLeAk215);
		android.util.Log.d("leak-216-20", dataLeAk216);
		android.util.Log.d("leak-217-20", dataLeAk217);
		android.util.Log.d("leak-218-20", dataLeAk218);
		android.util.Log.d("leak-219-20", dataLeAk219);
		android.util.Log.d("leak-220-20", dataLeAk220);
		android.util.Log.d("leak-221-20", dataLeAk221);
		android.util.Log.d("leak-222-20", dataLeAk222);
		android.util.Log.d("leak-223-20", dataLeAk223);
		android.util.Log.d("leak-224-20", dataLeAk224);
		android.util.Log.d("leak-225-20", dataLeAk225);
		android.util.Log.d("leak-226-20", dataLeAk226);
		android.util.Log.d("leak-227-20", dataLeAk227);
		android.util.Log.d("leak-228-20", dataLeAk228);
		android.util.Log.d("leak-229-20", dataLeAk229);
		android.util.Log.d("leak-230-20", dataLeAk230);
		android.util.Log.d("leak-232-20", dataLeAk232);
		android.util.Log.d("leak-233-20", dataLeAk233);
		android.util.Log.d("leak-234-20", dataLeAk234);
		android.util.Log.d("leak-235-20", dataLeAk235);
		android.util.Log.d("leak-236-20", dataLeAk236);
		android.util.Log.d("leak-237-20", dataLeAk237);
		android.util.Log.d("leak-238-20", dataLeAk238);
		android.util.Log.d("leak-239-20", dataLeAk239);
		android.util.Log.d("leak-240-20", dataLeAk240);
		android.util.Log.d("leak-241-20", dataLeAk241);
		android.util.Log.d("leak-242-20", dataLeAk242);
		android.util.Log.d("leak-243-20", dataLeAk243);
		android.util.Log.d("leak-244-20", dataLeAk244);
		android.util.Log.d("leak-245-20", dataLeAk245);
		android.util.Log.d("leak-246-20", dataLeAk246);
		android.util.Log.d("leak-247-20", dataLeAk247);
		android.util.Log.d("leak-248-20", dataLeAk248);
		android.util.Log.d("leak-252-20", dataLeAk252);
		android.util.Log.d("leak-253-20", dataLeAk253);
		android.util.Log.d("leak-254-20", dataLeAk254);
		String tags;

        // Check if there is a tags column in the database
        int index;
        if ((index = mCursor.getColumnIndex(Notes.TAGS)) != -1) {
            tags = mCursor.getString(index);
        } else {
            tags = "";
        }

        if (!TextUtils.isEmpty(tags)) {
            return tags;
        } else {
            return "";
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
		dataLeAk215 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-21", dataLeAk190);
		android.util.Log.d("leak-191-21", dataLeAk191);
		android.util.Log.d("leak-192-21", dataLeAk192);
		android.util.Log.d("leak-193-21", dataLeAk193);
		android.util.Log.d("leak-194-21", dataLeAk194);
		android.util.Log.d("leak-195-21", dataLeAk195);
		android.util.Log.d("leak-197-21", dataLeAk197);
		android.util.Log.d("leak-198-21", dataLeAk198);
		android.util.Log.d("leak-199-21", dataLeAk199);
		android.util.Log.d("leak-203-21", dataLeAk203);
		android.util.Log.d("leak-204-21", dataLeAk204);
		android.util.Log.d("leak-205-21", dataLeAk205);
		android.util.Log.d("leak-206-21", dataLeAk206);
		android.util.Log.d("leak-207-21", dataLeAk207);
		android.util.Log.d("leak-208-21", dataLeAk208);
		android.util.Log.d("leak-209-21", dataLeAk209);
		android.util.Log.d("leak-210-21", dataLeAk210);
		android.util.Log.d("leak-211-21", dataLeAk211);
		android.util.Log.d("leak-212-21", dataLeAk212);
		android.util.Log.d("leak-213-21", dataLeAk213);
		android.util.Log.d("leak-214-21", dataLeAk214);
		android.util.Log.d("leak-215-21", dataLeAk215);
		android.util.Log.d("leak-216-21", dataLeAk216);
		android.util.Log.d("leak-217-21", dataLeAk217);
		android.util.Log.d("leak-218-21", dataLeAk218);
		android.util.Log.d("leak-219-21", dataLeAk219);
		android.util.Log.d("leak-220-21", dataLeAk220);
		android.util.Log.d("leak-221-21", dataLeAk221);
		android.util.Log.d("leak-222-21", dataLeAk222);
		android.util.Log.d("leak-223-21", dataLeAk223);
		android.util.Log.d("leak-224-21", dataLeAk224);
		android.util.Log.d("leak-225-21", dataLeAk225);
		android.util.Log.d("leak-226-21", dataLeAk226);
		android.util.Log.d("leak-227-21", dataLeAk227);
		android.util.Log.d("leak-228-21", dataLeAk228);
		android.util.Log.d("leak-229-21", dataLeAk229);
		android.util.Log.d("leak-230-21", dataLeAk230);
		android.util.Log.d("leak-232-21", dataLeAk232);
		android.util.Log.d("leak-233-21", dataLeAk233);
		android.util.Log.d("leak-234-21", dataLeAk234);
		android.util.Log.d("leak-235-21", dataLeAk235);
		android.util.Log.d("leak-236-21", dataLeAk236);
		android.util.Log.d("leak-237-21", dataLeAk237);
		android.util.Log.d("leak-238-21", dataLeAk238);
		android.util.Log.d("leak-239-21", dataLeAk239);
		android.util.Log.d("leak-240-21", dataLeAk240);
		android.util.Log.d("leak-241-21", dataLeAk241);
		android.util.Log.d("leak-242-21", dataLeAk242);
		android.util.Log.d("leak-243-21", dataLeAk243);
		android.util.Log.d("leak-244-21", dataLeAk244);
		android.util.Log.d("leak-245-21", dataLeAk245);
		android.util.Log.d("leak-246-21", dataLeAk246);
		android.util.Log.d("leak-247-21", dataLeAk247);
		android.util.Log.d("leak-248-21", dataLeAk248);
		android.util.Log.d("leak-252-21", dataLeAk252);
		android.util.Log.d("leak-253-21", dataLeAk253);
		android.util.Log.d("leak-254-21", dataLeAk254);

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

        dataLeAk216 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-22", dataLeAk190);
		android.util.Log.d("leak-191-22", dataLeAk191);
		android.util.Log.d("leak-192-22", dataLeAk192);
		android.util.Log.d("leak-193-22", dataLeAk193);
		android.util.Log.d("leak-194-22", dataLeAk194);
		android.util.Log.d("leak-195-22", dataLeAk195);
		android.util.Log.d("leak-197-22", dataLeAk197);
		android.util.Log.d("leak-198-22", dataLeAk198);
		android.util.Log.d("leak-199-22", dataLeAk199);
		android.util.Log.d("leak-203-22", dataLeAk203);
		android.util.Log.d("leak-204-22", dataLeAk204);
		android.util.Log.d("leak-205-22", dataLeAk205);
		android.util.Log.d("leak-206-22", dataLeAk206);
		android.util.Log.d("leak-207-22", dataLeAk207);
		android.util.Log.d("leak-208-22", dataLeAk208);
		android.util.Log.d("leak-209-22", dataLeAk209);
		android.util.Log.d("leak-210-22", dataLeAk210);
		android.util.Log.d("leak-211-22", dataLeAk211);
		android.util.Log.d("leak-212-22", dataLeAk212);
		android.util.Log.d("leak-213-22", dataLeAk213);
		android.util.Log.d("leak-214-22", dataLeAk214);
		android.util.Log.d("leak-215-22", dataLeAk215);
		android.util.Log.d("leak-216-22", dataLeAk216);
		android.util.Log.d("leak-217-22", dataLeAk217);
		android.util.Log.d("leak-218-22", dataLeAk218);
		android.util.Log.d("leak-219-22", dataLeAk219);
		android.util.Log.d("leak-220-22", dataLeAk220);
		android.util.Log.d("leak-221-22", dataLeAk221);
		android.util.Log.d("leak-222-22", dataLeAk222);
		android.util.Log.d("leak-223-22", dataLeAk223);
		android.util.Log.d("leak-224-22", dataLeAk224);
		android.util.Log.d("leak-225-22", dataLeAk225);
		android.util.Log.d("leak-226-22", dataLeAk226);
		android.util.Log.d("leak-227-22", dataLeAk227);
		android.util.Log.d("leak-228-22", dataLeAk228);
		android.util.Log.d("leak-229-22", dataLeAk229);
		android.util.Log.d("leak-230-22", dataLeAk230);
		android.util.Log.d("leak-232-22", dataLeAk232);
		android.util.Log.d("leak-233-22", dataLeAk233);
		android.util.Log.d("leak-234-22", dataLeAk234);
		android.util.Log.d("leak-235-22", dataLeAk235);
		android.util.Log.d("leak-236-22", dataLeAk236);
		android.util.Log.d("leak-237-22", dataLeAk237);
		android.util.Log.d("leak-238-22", dataLeAk238);
		android.util.Log.d("leak-239-22", dataLeAk239);
		android.util.Log.d("leak-240-22", dataLeAk240);
		android.util.Log.d("leak-241-22", dataLeAk241);
		android.util.Log.d("leak-242-22", dataLeAk242);
		android.util.Log.d("leak-243-22", dataLeAk243);
		android.util.Log.d("leak-244-22", dataLeAk244);
		android.util.Log.d("leak-245-22", dataLeAk245);
		android.util.Log.d("leak-246-22", dataLeAk246);
		android.util.Log.d("leak-247-22", dataLeAk247);
		android.util.Log.d("leak-248-22", dataLeAk248);
		android.util.Log.d("leak-252-22", dataLeAk252);
		android.util.Log.d("leak-253-22", dataLeAk253);
		android.util.Log.d("leak-254-22", dataLeAk254);
		// contentChanged used for revert and save menu
        boolean contentChanged = !mOriginalContent.equals(
                mText.getText()
                        .toString()
        );

        boolean isNoteUnencrypted = isNoteUnencrypted();

        // Show comands on the URI only if the note is not encrypted
        menu.setGroupVisible(Menu.CATEGORY_ALTERNATIVE, isNoteUnencrypted);

        if (mState == STATE_EDIT_NOTE_FROM_SDCARD) {
            // Menus for editing from SD card
            menu.setGroupVisible(0, false);
            menu.setGroupVisible(1, false);
            menu.setGroupVisible(2, true);

            menu.findItem(MENU_SAVE).setEnabled(contentChanged);

        } else if (mState == STATE_EDIT_EXTERNAL_NOTE) {
            // Menus for external notes, e.g. from OI Shopping List.
            // In this case, don't show encryption/decryption.
            menu.setGroupVisible(0, contentChanged || mUndoRevert != null);
            menu.setGroupVisible(1, true);
            menu.setGroupVisible(2, false);

            menu.findItem(MENU_ENCRYPT).setVisible(false);
            menu.findItem(MENU_UNENCRYPT).setVisible(false);
        } else {
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
        dataLeAk217 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-23", dataLeAk190);
		android.util.Log.d("leak-191-23", dataLeAk191);
		android.util.Log.d("leak-192-23", dataLeAk192);
		android.util.Log.d("leak-193-23", dataLeAk193);
		android.util.Log.d("leak-194-23", dataLeAk194);
		android.util.Log.d("leak-195-23", dataLeAk195);
		android.util.Log.d("leak-197-23", dataLeAk197);
		android.util.Log.d("leak-198-23", dataLeAk198);
		android.util.Log.d("leak-199-23", dataLeAk199);
		android.util.Log.d("leak-203-23", dataLeAk203);
		android.util.Log.d("leak-204-23", dataLeAk204);
		android.util.Log.d("leak-205-23", dataLeAk205);
		android.util.Log.d("leak-206-23", dataLeAk206);
		android.util.Log.d("leak-207-23", dataLeAk207);
		android.util.Log.d("leak-208-23", dataLeAk208);
		android.util.Log.d("leak-209-23", dataLeAk209);
		android.util.Log.d("leak-210-23", dataLeAk210);
		android.util.Log.d("leak-211-23", dataLeAk211);
		android.util.Log.d("leak-212-23", dataLeAk212);
		android.util.Log.d("leak-213-23", dataLeAk213);
		android.util.Log.d("leak-214-23", dataLeAk214);
		android.util.Log.d("leak-215-23", dataLeAk215);
		android.util.Log.d("leak-216-23", dataLeAk216);
		android.util.Log.d("leak-217-23", dataLeAk217);
		android.util.Log.d("leak-218-23", dataLeAk218);
		android.util.Log.d("leak-219-23", dataLeAk219);
		android.util.Log.d("leak-220-23", dataLeAk220);
		android.util.Log.d("leak-221-23", dataLeAk221);
		android.util.Log.d("leak-222-23", dataLeAk222);
		android.util.Log.d("leak-223-23", dataLeAk223);
		android.util.Log.d("leak-224-23", dataLeAk224);
		android.util.Log.d("leak-225-23", dataLeAk225);
		android.util.Log.d("leak-226-23", dataLeAk226);
		android.util.Log.d("leak-227-23", dataLeAk227);
		android.util.Log.d("leak-228-23", dataLeAk228);
		android.util.Log.d("leak-229-23", dataLeAk229);
		android.util.Log.d("leak-230-23", dataLeAk230);
		android.util.Log.d("leak-232-23", dataLeAk232);
		android.util.Log.d("leak-233-23", dataLeAk233);
		android.util.Log.d("leak-234-23", dataLeAk234);
		android.util.Log.d("leak-235-23", dataLeAk235);
		android.util.Log.d("leak-236-23", dataLeAk236);
		android.util.Log.d("leak-237-23", dataLeAk237);
		android.util.Log.d("leak-238-23", dataLeAk238);
		android.util.Log.d("leak-239-23", dataLeAk239);
		android.util.Log.d("leak-240-23", dataLeAk240);
		android.util.Log.d("leak-241-23", dataLeAk241);
		android.util.Log.d("leak-242-23", dataLeAk242);
		android.util.Log.d("leak-243-23", dataLeAk243);
		android.util.Log.d("leak-244-23", dataLeAk244);
		android.util.Log.d("leak-245-23", dataLeAk245);
		android.util.Log.d("leak-246-23", dataLeAk246);
		android.util.Log.d("leak-247-23", dataLeAk247);
		android.util.Log.d("leak-248-23", dataLeAk248);
		android.util.Log.d("leak-252-23", dataLeAk252);
		android.util.Log.d("leak-253-23", dataLeAk253);
		android.util.Log.d("leak-254-23", dataLeAk254);
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
            // Process manually:
            // We pass the current selection along with the intent
            startTextSelectionActivity(item.getIntent());

            // Consume event
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void shareNote() {
        dataLeAk218 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-24", dataLeAk190);
		android.util.Log.d("leak-191-24", dataLeAk191);
		android.util.Log.d("leak-192-24", dataLeAk192);
		android.util.Log.d("leak-193-24", dataLeAk193);
		android.util.Log.d("leak-194-24", dataLeAk194);
		android.util.Log.d("leak-195-24", dataLeAk195);
		android.util.Log.d("leak-197-24", dataLeAk197);
		android.util.Log.d("leak-198-24", dataLeAk198);
		android.util.Log.d("leak-199-24", dataLeAk199);
		android.util.Log.d("leak-203-24", dataLeAk203);
		android.util.Log.d("leak-204-24", dataLeAk204);
		android.util.Log.d("leak-205-24", dataLeAk205);
		android.util.Log.d("leak-206-24", dataLeAk206);
		android.util.Log.d("leak-207-24", dataLeAk207);
		android.util.Log.d("leak-208-24", dataLeAk208);
		android.util.Log.d("leak-209-24", dataLeAk209);
		android.util.Log.d("leak-210-24", dataLeAk210);
		android.util.Log.d("leak-211-24", dataLeAk211);
		android.util.Log.d("leak-212-24", dataLeAk212);
		android.util.Log.d("leak-213-24", dataLeAk213);
		android.util.Log.d("leak-214-24", dataLeAk214);
		android.util.Log.d("leak-215-24", dataLeAk215);
		android.util.Log.d("leak-216-24", dataLeAk216);
		android.util.Log.d("leak-217-24", dataLeAk217);
		android.util.Log.d("leak-218-24", dataLeAk218);
		android.util.Log.d("leak-219-24", dataLeAk219);
		android.util.Log.d("leak-220-24", dataLeAk220);
		android.util.Log.d("leak-221-24", dataLeAk221);
		android.util.Log.d("leak-222-24", dataLeAk222);
		android.util.Log.d("leak-223-24", dataLeAk223);
		android.util.Log.d("leak-224-24", dataLeAk224);
		android.util.Log.d("leak-225-24", dataLeAk225);
		android.util.Log.d("leak-226-24", dataLeAk226);
		android.util.Log.d("leak-227-24", dataLeAk227);
		android.util.Log.d("leak-228-24", dataLeAk228);
		android.util.Log.d("leak-229-24", dataLeAk229);
		android.util.Log.d("leak-230-24", dataLeAk230);
		android.util.Log.d("leak-232-24", dataLeAk232);
		android.util.Log.d("leak-233-24", dataLeAk233);
		android.util.Log.d("leak-234-24", dataLeAk234);
		android.util.Log.d("leak-235-24", dataLeAk235);
		android.util.Log.d("leak-236-24", dataLeAk236);
		android.util.Log.d("leak-237-24", dataLeAk237);
		android.util.Log.d("leak-238-24", dataLeAk238);
		android.util.Log.d("leak-239-24", dataLeAk239);
		android.util.Log.d("leak-240-24", dataLeAk240);
		android.util.Log.d("leak-241-24", dataLeAk241);
		android.util.Log.d("leak-242-24", dataLeAk242);
		android.util.Log.d("leak-243-24", dataLeAk243);
		android.util.Log.d("leak-244-24", dataLeAk244);
		android.util.Log.d("leak-245-24", dataLeAk245);
		android.util.Log.d("leak-246-24", dataLeAk246);
		android.util.Log.d("leak-247-24", dataLeAk247);
		android.util.Log.d("leak-248-24", dataLeAk248);
		android.util.Log.d("leak-252-24", dataLeAk252);
		android.util.Log.d("leak-253-24", dataLeAk253);
		android.util.Log.d("leak-254-24", dataLeAk254);
		String content = mText.getText().toString();
        String title = ExtractTitle.extractTitle(content);
        SendNote.sendNote(this, title, content);
    }

    private void deleteNoteWithConfirm() {
        dataLeAk219 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-25", dataLeAk190);
		android.util.Log.d("leak-191-25", dataLeAk191);
		android.util.Log.d("leak-192-25", dataLeAk192);
		android.util.Log.d("leak-193-25", dataLeAk193);
		android.util.Log.d("leak-194-25", dataLeAk194);
		android.util.Log.d("leak-195-25", dataLeAk195);
		android.util.Log.d("leak-197-25", dataLeAk197);
		android.util.Log.d("leak-198-25", dataLeAk198);
		android.util.Log.d("leak-199-25", dataLeAk199);
		android.util.Log.d("leak-203-25", dataLeAk203);
		android.util.Log.d("leak-204-25", dataLeAk204);
		android.util.Log.d("leak-205-25", dataLeAk205);
		android.util.Log.d("leak-206-25", dataLeAk206);
		android.util.Log.d("leak-207-25", dataLeAk207);
		android.util.Log.d("leak-208-25", dataLeAk208);
		android.util.Log.d("leak-209-25", dataLeAk209);
		android.util.Log.d("leak-210-25", dataLeAk210);
		android.util.Log.d("leak-211-25", dataLeAk211);
		android.util.Log.d("leak-212-25", dataLeAk212);
		android.util.Log.d("leak-213-25", dataLeAk213);
		android.util.Log.d("leak-214-25", dataLeAk214);
		android.util.Log.d("leak-215-25", dataLeAk215);
		android.util.Log.d("leak-216-25", dataLeAk216);
		android.util.Log.d("leak-217-25", dataLeAk217);
		android.util.Log.d("leak-218-25", dataLeAk218);
		android.util.Log.d("leak-219-25", dataLeAk219);
		android.util.Log.d("leak-220-25", dataLeAk220);
		android.util.Log.d("leak-221-25", dataLeAk221);
		android.util.Log.d("leak-222-25", dataLeAk222);
		android.util.Log.d("leak-223-25", dataLeAk223);
		android.util.Log.d("leak-224-25", dataLeAk224);
		android.util.Log.d("leak-225-25", dataLeAk225);
		android.util.Log.d("leak-226-25", dataLeAk226);
		android.util.Log.d("leak-227-25", dataLeAk227);
		android.util.Log.d("leak-228-25", dataLeAk228);
		android.util.Log.d("leak-229-25", dataLeAk229);
		android.util.Log.d("leak-230-25", dataLeAk230);
		android.util.Log.d("leak-232-25", dataLeAk232);
		android.util.Log.d("leak-233-25", dataLeAk233);
		android.util.Log.d("leak-234-25", dataLeAk234);
		android.util.Log.d("leak-235-25", dataLeAk235);
		android.util.Log.d("leak-236-25", dataLeAk236);
		android.util.Log.d("leak-237-25", dataLeAk237);
		android.util.Log.d("leak-238-25", dataLeAk238);
		android.util.Log.d("leak-239-25", dataLeAk239);
		android.util.Log.d("leak-240-25", dataLeAk240);
		android.util.Log.d("leak-241-25", dataLeAk241);
		android.util.Log.d("leak-242-25", dataLeAk242);
		android.util.Log.d("leak-243-25", dataLeAk243);
		android.util.Log.d("leak-244-25", dataLeAk244);
		android.util.Log.d("leak-245-25", dataLeAk245);
		android.util.Log.d("leak-246-25", dataLeAk246);
		android.util.Log.d("leak-247-25", dataLeAk247);
		android.util.Log.d("leak-248-25", dataLeAk248);
		android.util.Log.d("leak-252-25", dataLeAk252);
		android.util.Log.d("leak-253-25", dataLeAk253);
		android.util.Log.d("leak-254-25", dataLeAk254);
		showDialog(DIALOG_DELETE);
    }

    /**
     * Modifies an activity to pass along the currently selected text.
     *
     * @param intent
     */
    private void startTextSelectionActivity(Intent intent) {
        dataLeAk220 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-26", dataLeAk190);
		android.util.Log.d("leak-191-26", dataLeAk191);
		android.util.Log.d("leak-192-26", dataLeAk192);
		android.util.Log.d("leak-193-26", dataLeAk193);
		android.util.Log.d("leak-194-26", dataLeAk194);
		android.util.Log.d("leak-195-26", dataLeAk195);
		android.util.Log.d("leak-197-26", dataLeAk197);
		android.util.Log.d("leak-198-26", dataLeAk198);
		android.util.Log.d("leak-199-26", dataLeAk199);
		android.util.Log.d("leak-203-26", dataLeAk203);
		android.util.Log.d("leak-204-26", dataLeAk204);
		android.util.Log.d("leak-205-26", dataLeAk205);
		android.util.Log.d("leak-206-26", dataLeAk206);
		android.util.Log.d("leak-207-26", dataLeAk207);
		android.util.Log.d("leak-208-26", dataLeAk208);
		android.util.Log.d("leak-209-26", dataLeAk209);
		android.util.Log.d("leak-210-26", dataLeAk210);
		android.util.Log.d("leak-211-26", dataLeAk211);
		android.util.Log.d("leak-212-26", dataLeAk212);
		android.util.Log.d("leak-213-26", dataLeAk213);
		android.util.Log.d("leak-214-26", dataLeAk214);
		android.util.Log.d("leak-215-26", dataLeAk215);
		android.util.Log.d("leak-216-26", dataLeAk216);
		android.util.Log.d("leak-217-26", dataLeAk217);
		android.util.Log.d("leak-218-26", dataLeAk218);
		android.util.Log.d("leak-219-26", dataLeAk219);
		android.util.Log.d("leak-220-26", dataLeAk220);
		android.util.Log.d("leak-221-26", dataLeAk221);
		android.util.Log.d("leak-222-26", dataLeAk222);
		android.util.Log.d("leak-223-26", dataLeAk223);
		android.util.Log.d("leak-224-26", dataLeAk224);
		android.util.Log.d("leak-225-26", dataLeAk225);
		android.util.Log.d("leak-226-26", dataLeAk226);
		android.util.Log.d("leak-227-26", dataLeAk227);
		android.util.Log.d("leak-228-26", dataLeAk228);
		android.util.Log.d("leak-229-26", dataLeAk229);
		android.util.Log.d("leak-230-26", dataLeAk230);
		android.util.Log.d("leak-232-26", dataLeAk232);
		android.util.Log.d("leak-233-26", dataLeAk233);
		android.util.Log.d("leak-234-26", dataLeAk234);
		android.util.Log.d("leak-235-26", dataLeAk235);
		android.util.Log.d("leak-236-26", dataLeAk236);
		android.util.Log.d("leak-237-26", dataLeAk237);
		android.util.Log.d("leak-238-26", dataLeAk238);
		android.util.Log.d("leak-239-26", dataLeAk239);
		android.util.Log.d("leak-240-26", dataLeAk240);
		android.util.Log.d("leak-241-26", dataLeAk241);
		android.util.Log.d("leak-242-26", dataLeAk242);
		android.util.Log.d("leak-243-26", dataLeAk243);
		android.util.Log.d("leak-244-26", dataLeAk244);
		android.util.Log.d("leak-245-26", dataLeAk245);
		android.util.Log.d("leak-246-26", dataLeAk246);
		android.util.Log.d("leak-247-26", dataLeAk247);
		android.util.Log.d("leak-248-26", dataLeAk248);
		android.util.Log.d("leak-252-26", dataLeAk252);
		android.util.Log.d("leak-253-26", dataLeAk253);
		android.util.Log.d("leak-254-26", dataLeAk254);
		Intent newIntent = new Intent(intent);

        String text = mText.getText().toString();
        int start = mText.getSelectionStart();
        int end = mText.getSelectionEnd();

        // if (DEBUG) Log.i(TAG, "len: " + text.length() + ", start: " + start +
        // ", end: " + end);
        if (end < start) {
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
        dataLeAk221 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-27", dataLeAk190);
		android.util.Log.d("leak-191-27", dataLeAk191);
		android.util.Log.d("leak-192-27", dataLeAk192);
		android.util.Log.d("leak-193-27", dataLeAk193);
		android.util.Log.d("leak-194-27", dataLeAk194);
		android.util.Log.d("leak-195-27", dataLeAk195);
		android.util.Log.d("leak-197-27", dataLeAk197);
		android.util.Log.d("leak-198-27", dataLeAk198);
		android.util.Log.d("leak-199-27", dataLeAk199);
		android.util.Log.d("leak-203-27", dataLeAk203);
		android.util.Log.d("leak-204-27", dataLeAk204);
		android.util.Log.d("leak-205-27", dataLeAk205);
		android.util.Log.d("leak-206-27", dataLeAk206);
		android.util.Log.d("leak-207-27", dataLeAk207);
		android.util.Log.d("leak-208-27", dataLeAk208);
		android.util.Log.d("leak-209-27", dataLeAk209);
		android.util.Log.d("leak-210-27", dataLeAk210);
		android.util.Log.d("leak-211-27", dataLeAk211);
		android.util.Log.d("leak-212-27", dataLeAk212);
		android.util.Log.d("leak-213-27", dataLeAk213);
		android.util.Log.d("leak-214-27", dataLeAk214);
		android.util.Log.d("leak-215-27", dataLeAk215);
		android.util.Log.d("leak-216-27", dataLeAk216);
		android.util.Log.d("leak-217-27", dataLeAk217);
		android.util.Log.d("leak-218-27", dataLeAk218);
		android.util.Log.d("leak-219-27", dataLeAk219);
		android.util.Log.d("leak-220-27", dataLeAk220);
		android.util.Log.d("leak-221-27", dataLeAk221);
		android.util.Log.d("leak-222-27", dataLeAk222);
		android.util.Log.d("leak-223-27", dataLeAk223);
		android.util.Log.d("leak-224-27", dataLeAk224);
		android.util.Log.d("leak-225-27", dataLeAk225);
		android.util.Log.d("leak-226-27", dataLeAk226);
		android.util.Log.d("leak-227-27", dataLeAk227);
		android.util.Log.d("leak-228-27", dataLeAk228);
		android.util.Log.d("leak-229-27", dataLeAk229);
		android.util.Log.d("leak-230-27", dataLeAk230);
		android.util.Log.d("leak-232-27", dataLeAk232);
		android.util.Log.d("leak-233-27", dataLeAk233);
		android.util.Log.d("leak-234-27", dataLeAk234);
		android.util.Log.d("leak-235-27", dataLeAk235);
		android.util.Log.d("leak-236-27", dataLeAk236);
		android.util.Log.d("leak-237-27", dataLeAk237);
		android.util.Log.d("leak-238-27", dataLeAk238);
		android.util.Log.d("leak-239-27", dataLeAk239);
		android.util.Log.d("leak-240-27", dataLeAk240);
		android.util.Log.d("leak-241-27", dataLeAk241);
		android.util.Log.d("leak-242-27", dataLeAk242);
		android.util.Log.d("leak-243-27", dataLeAk243);
		android.util.Log.d("leak-244-27", dataLeAk244);
		android.util.Log.d("leak-245-27", dataLeAk245);
		android.util.Log.d("leak-246-27", dataLeAk246);
		android.util.Log.d("leak-247-27", dataLeAk247);
		android.util.Log.d("leak-248-27", dataLeAk248);
		android.util.Log.d("leak-252-27", dataLeAk252);
		android.util.Log.d("leak-253-27", dataLeAk253);
		android.util.Log.d("leak-254-27", dataLeAk254);
		if (mCursor != null) {
            String tmp = mText.getText().toString();
            mText.setAutoLinkMask(0);
            if (!tmp.equals(mOriginalContent)) {
                // revert to original content
                mText.setTextKeepState(mOriginalContent);
                mUndoRevert = tmp;
            } else if (mUndoRevert != null) {
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
        dataLeAk222 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-28", dataLeAk190);
		android.util.Log.d("leak-191-28", dataLeAk191);
		android.util.Log.d("leak-192-28", dataLeAk192);
		android.util.Log.d("leak-193-28", dataLeAk193);
		android.util.Log.d("leak-194-28", dataLeAk194);
		android.util.Log.d("leak-195-28", dataLeAk195);
		android.util.Log.d("leak-197-28", dataLeAk197);
		android.util.Log.d("leak-198-28", dataLeAk198);
		android.util.Log.d("leak-199-28", dataLeAk199);
		android.util.Log.d("leak-203-28", dataLeAk203);
		android.util.Log.d("leak-204-28", dataLeAk204);
		android.util.Log.d("leak-205-28", dataLeAk205);
		android.util.Log.d("leak-206-28", dataLeAk206);
		android.util.Log.d("leak-207-28", dataLeAk207);
		android.util.Log.d("leak-208-28", dataLeAk208);
		android.util.Log.d("leak-209-28", dataLeAk209);
		android.util.Log.d("leak-210-28", dataLeAk210);
		android.util.Log.d("leak-211-28", dataLeAk211);
		android.util.Log.d("leak-212-28", dataLeAk212);
		android.util.Log.d("leak-213-28", dataLeAk213);
		android.util.Log.d("leak-214-28", dataLeAk214);
		android.util.Log.d("leak-215-28", dataLeAk215);
		android.util.Log.d("leak-216-28", dataLeAk216);
		android.util.Log.d("leak-217-28", dataLeAk217);
		android.util.Log.d("leak-218-28", dataLeAk218);
		android.util.Log.d("leak-219-28", dataLeAk219);
		android.util.Log.d("leak-220-28", dataLeAk220);
		android.util.Log.d("leak-221-28", dataLeAk221);
		android.util.Log.d("leak-222-28", dataLeAk222);
		android.util.Log.d("leak-223-28", dataLeAk223);
		android.util.Log.d("leak-224-28", dataLeAk224);
		android.util.Log.d("leak-225-28", dataLeAk225);
		android.util.Log.d("leak-226-28", dataLeAk226);
		android.util.Log.d("leak-227-28", dataLeAk227);
		android.util.Log.d("leak-228-28", dataLeAk228);
		android.util.Log.d("leak-229-28", dataLeAk229);
		android.util.Log.d("leak-230-28", dataLeAk230);
		android.util.Log.d("leak-232-28", dataLeAk232);
		android.util.Log.d("leak-233-28", dataLeAk233);
		android.util.Log.d("leak-234-28", dataLeAk234);
		android.util.Log.d("leak-235-28", dataLeAk235);
		android.util.Log.d("leak-236-28", dataLeAk236);
		android.util.Log.d("leak-237-28", dataLeAk237);
		android.util.Log.d("leak-238-28", dataLeAk238);
		android.util.Log.d("leak-239-28", dataLeAk239);
		android.util.Log.d("leak-240-28", dataLeAk240);
		android.util.Log.d("leak-241-28", dataLeAk241);
		android.util.Log.d("leak-242-28", dataLeAk242);
		android.util.Log.d("leak-243-28", dataLeAk243);
		android.util.Log.d("leak-244-28", dataLeAk244);
		android.util.Log.d("leak-245-28", dataLeAk245);
		android.util.Log.d("leak-246-28", dataLeAk246);
		android.util.Log.d("leak-247-28", dataLeAk247);
		android.util.Log.d("leak-248-28", dataLeAk248);
		android.util.Log.d("leak-252-28", dataLeAk252);
		android.util.Log.d("leak-253-28", dataLeAk253);
		android.util.Log.d("leak-254-28", dataLeAk254);
		if (mCursor != null) {
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
        dataLeAk223 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-29", dataLeAk190);
		android.util.Log.d("leak-191-29", dataLeAk191);
		android.util.Log.d("leak-192-29", dataLeAk192);
		android.util.Log.d("leak-193-29", dataLeAk193);
		android.util.Log.d("leak-194-29", dataLeAk194);
		android.util.Log.d("leak-195-29", dataLeAk195);
		android.util.Log.d("leak-197-29", dataLeAk197);
		android.util.Log.d("leak-198-29", dataLeAk198);
		android.util.Log.d("leak-199-29", dataLeAk199);
		android.util.Log.d("leak-203-29", dataLeAk203);
		android.util.Log.d("leak-204-29", dataLeAk204);
		android.util.Log.d("leak-205-29", dataLeAk205);
		android.util.Log.d("leak-206-29", dataLeAk206);
		android.util.Log.d("leak-207-29", dataLeAk207);
		android.util.Log.d("leak-208-29", dataLeAk208);
		android.util.Log.d("leak-209-29", dataLeAk209);
		android.util.Log.d("leak-210-29", dataLeAk210);
		android.util.Log.d("leak-211-29", dataLeAk211);
		android.util.Log.d("leak-212-29", dataLeAk212);
		android.util.Log.d("leak-213-29", dataLeAk213);
		android.util.Log.d("leak-214-29", dataLeAk214);
		android.util.Log.d("leak-215-29", dataLeAk215);
		android.util.Log.d("leak-216-29", dataLeAk216);
		android.util.Log.d("leak-217-29", dataLeAk217);
		android.util.Log.d("leak-218-29", dataLeAk218);
		android.util.Log.d("leak-219-29", dataLeAk219);
		android.util.Log.d("leak-220-29", dataLeAk220);
		android.util.Log.d("leak-221-29", dataLeAk221);
		android.util.Log.d("leak-222-29", dataLeAk222);
		android.util.Log.d("leak-223-29", dataLeAk223);
		android.util.Log.d("leak-224-29", dataLeAk224);
		android.util.Log.d("leak-225-29", dataLeAk225);
		android.util.Log.d("leak-226-29", dataLeAk226);
		android.util.Log.d("leak-227-29", dataLeAk227);
		android.util.Log.d("leak-228-29", dataLeAk228);
		android.util.Log.d("leak-229-29", dataLeAk229);
		android.util.Log.d("leak-230-29", dataLeAk230);
		android.util.Log.d("leak-232-29", dataLeAk232);
		android.util.Log.d("leak-233-29", dataLeAk233);
		android.util.Log.d("leak-234-29", dataLeAk234);
		android.util.Log.d("leak-235-29", dataLeAk235);
		android.util.Log.d("leak-236-29", dataLeAk236);
		android.util.Log.d("leak-237-29", dataLeAk237);
		android.util.Log.d("leak-238-29", dataLeAk238);
		android.util.Log.d("leak-239-29", dataLeAk239);
		android.util.Log.d("leak-240-29", dataLeAk240);
		android.util.Log.d("leak-241-29", dataLeAk241);
		android.util.Log.d("leak-242-29", dataLeAk242);
		android.util.Log.d("leak-243-29", dataLeAk243);
		android.util.Log.d("leak-244-29", dataLeAk244);
		android.util.Log.d("leak-245-29", dataLeAk245);
		android.util.Log.d("leak-246-29", dataLeAk246);
		android.util.Log.d("leak-247-29", dataLeAk247);
		android.util.Log.d("leak-248-29", dataLeAk248);
		android.util.Log.d("leak-252-29", dataLeAk252);
		android.util.Log.d("leak-253-29", dataLeAk253);
		android.util.Log.d("leak-254-29", dataLeAk254);
		if (mApplyTextBefore != null || mApplyText != null
                || mApplyTextAfter != null) {
            // Need to apply insert text from previous
            // TEXT_SELECTION_ALTERNATIVE

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
        dataLeAk224 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-30", dataLeAk190);
		android.util.Log.d("leak-191-30", dataLeAk191);
		android.util.Log.d("leak-192-30", dataLeAk192);
		android.util.Log.d("leak-193-30", dataLeAk193);
		android.util.Log.d("leak-194-30", dataLeAk194);
		android.util.Log.d("leak-195-30", dataLeAk195);
		android.util.Log.d("leak-197-30", dataLeAk197);
		android.util.Log.d("leak-198-30", dataLeAk198);
		android.util.Log.d("leak-199-30", dataLeAk199);
		android.util.Log.d("leak-203-30", dataLeAk203);
		android.util.Log.d("leak-204-30", dataLeAk204);
		android.util.Log.d("leak-205-30", dataLeAk205);
		android.util.Log.d("leak-206-30", dataLeAk206);
		android.util.Log.d("leak-207-30", dataLeAk207);
		android.util.Log.d("leak-208-30", dataLeAk208);
		android.util.Log.d("leak-209-30", dataLeAk209);
		android.util.Log.d("leak-210-30", dataLeAk210);
		android.util.Log.d("leak-211-30", dataLeAk211);
		android.util.Log.d("leak-212-30", dataLeAk212);
		android.util.Log.d("leak-213-30", dataLeAk213);
		android.util.Log.d("leak-214-30", dataLeAk214);
		android.util.Log.d("leak-215-30", dataLeAk215);
		android.util.Log.d("leak-216-30", dataLeAk216);
		android.util.Log.d("leak-217-30", dataLeAk217);
		android.util.Log.d("leak-218-30", dataLeAk218);
		android.util.Log.d("leak-219-30", dataLeAk219);
		android.util.Log.d("leak-220-30", dataLeAk220);
		android.util.Log.d("leak-221-30", dataLeAk221);
		android.util.Log.d("leak-222-30", dataLeAk222);
		android.util.Log.d("leak-223-30", dataLeAk223);
		android.util.Log.d("leak-224-30", dataLeAk224);
		android.util.Log.d("leak-225-30", dataLeAk225);
		android.util.Log.d("leak-226-30", dataLeAk226);
		android.util.Log.d("leak-227-30", dataLeAk227);
		android.util.Log.d("leak-228-30", dataLeAk228);
		android.util.Log.d("leak-229-30", dataLeAk229);
		android.util.Log.d("leak-230-30", dataLeAk230);
		android.util.Log.d("leak-232-30", dataLeAk232);
		android.util.Log.d("leak-233-30", dataLeAk233);
		android.util.Log.d("leak-234-30", dataLeAk234);
		android.util.Log.d("leak-235-30", dataLeAk235);
		android.util.Log.d("leak-236-30", dataLeAk236);
		android.util.Log.d("leak-237-30", dataLeAk237);
		android.util.Log.d("leak-238-30", dataLeAk238);
		android.util.Log.d("leak-239-30", dataLeAk239);
		android.util.Log.d("leak-240-30", dataLeAk240);
		android.util.Log.d("leak-241-30", dataLeAk241);
		android.util.Log.d("leak-242-30", dataLeAk242);
		android.util.Log.d("leak-243-30", dataLeAk243);
		android.util.Log.d("leak-244-30", dataLeAk244);
		android.util.Log.d("leak-245-30", dataLeAk245);
		android.util.Log.d("leak-246-30", dataLeAk246);
		android.util.Log.d("leak-247-30", dataLeAk247);
		android.util.Log.d("leak-248-30", dataLeAk248);
		android.util.Log.d("leak-252-30", dataLeAk252);
		android.util.Log.d("leak-253-30", dataLeAk253);
		android.util.Log.d("leak-254-30", dataLeAk254);
		String originalText = mText.getText().toString();
        int startPos = mText.getSelectionStart();
        int endPos = mText.getSelectionEnd();
        if (mDecryptedText != null) {
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
            sb.append(textBefore);
            newStartPos = textBefore.length();
        } else {
            sb.append(originalText.substring(0, startPos));
        }
        if (textToInsert != null) {
            sb.append(textToInsert);
            newEndPos = newStartPos + textToInsert.length();
        } else {
            String text = originalText.substring(startPos, endPos);
            sb.append(text);
            newEndPos = newStartPos + text.length();
        }
        if (textAfter != null) {
            sb.append(textAfter);
        } else {
            sb.append(originalText.substring(endPos));
        }
        newNote = sb.toString();

        if (mState == STATE_EDIT_NOTE_FROM_SDCARD) {
            mFileContent = newNote;
            mSelectionStart = newStartPos;
            mSelectionStop = newEndPos;
        } else if (mDecryptedText != null) {
            mDecryptedText = newNote;
        } else {
            // This stuff is only done when working with a full-fledged note.
            if (!mNoteOnly) {
                // Bump the modification time to now.
                values.put(Notes.MODIFIED_DATE, System.currentTimeMillis());
                String title;
                if (!PreferenceActivity.getMarqueeFromPrefs(this)) {
                    title = ExtractTitle.extractTitle(newNote);
                } else {
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

        dataLeAk225 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-31", dataLeAk190);
		android.util.Log.d("leak-191-31", dataLeAk191);
		android.util.Log.d("leak-192-31", dataLeAk192);
		android.util.Log.d("leak-193-31", dataLeAk193);
		android.util.Log.d("leak-194-31", dataLeAk194);
		android.util.Log.d("leak-195-31", dataLeAk195);
		android.util.Log.d("leak-197-31", dataLeAk197);
		android.util.Log.d("leak-198-31", dataLeAk198);
		android.util.Log.d("leak-199-31", dataLeAk199);
		android.util.Log.d("leak-203-31", dataLeAk203);
		android.util.Log.d("leak-204-31", dataLeAk204);
		android.util.Log.d("leak-205-31", dataLeAk205);
		android.util.Log.d("leak-206-31", dataLeAk206);
		android.util.Log.d("leak-207-31", dataLeAk207);
		android.util.Log.d("leak-208-31", dataLeAk208);
		android.util.Log.d("leak-209-31", dataLeAk209);
		android.util.Log.d("leak-210-31", dataLeAk210);
		android.util.Log.d("leak-211-31", dataLeAk211);
		android.util.Log.d("leak-212-31", dataLeAk212);
		android.util.Log.d("leak-213-31", dataLeAk213);
		android.util.Log.d("leak-214-31", dataLeAk214);
		android.util.Log.d("leak-215-31", dataLeAk215);
		android.util.Log.d("leak-216-31", dataLeAk216);
		android.util.Log.d("leak-217-31", dataLeAk217);
		android.util.Log.d("leak-218-31", dataLeAk218);
		android.util.Log.d("leak-219-31", dataLeAk219);
		android.util.Log.d("leak-220-31", dataLeAk220);
		android.util.Log.d("leak-221-31", dataLeAk221);
		android.util.Log.d("leak-222-31", dataLeAk222);
		android.util.Log.d("leak-223-31", dataLeAk223);
		android.util.Log.d("leak-224-31", dataLeAk224);
		android.util.Log.d("leak-225-31", dataLeAk225);
		android.util.Log.d("leak-226-31", dataLeAk226);
		android.util.Log.d("leak-227-31", dataLeAk227);
		android.util.Log.d("leak-228-31", dataLeAk228);
		android.util.Log.d("leak-229-31", dataLeAk229);
		android.util.Log.d("leak-230-31", dataLeAk230);
		android.util.Log.d("leak-232-31", dataLeAk232);
		android.util.Log.d("leak-233-31", dataLeAk233);
		android.util.Log.d("leak-234-31", dataLeAk234);
		android.util.Log.d("leak-235-31", dataLeAk235);
		android.util.Log.d("leak-236-31", dataLeAk236);
		android.util.Log.d("leak-237-31", dataLeAk237);
		android.util.Log.d("leak-238-31", dataLeAk238);
		android.util.Log.d("leak-239-31", dataLeAk239);
		android.util.Log.d("leak-240-31", dataLeAk240);
		android.util.Log.d("leak-241-31", dataLeAk241);
		android.util.Log.d("leak-242-31", dataLeAk242);
		android.util.Log.d("leak-243-31", dataLeAk243);
		android.util.Log.d("leak-244-31", dataLeAk244);
		android.util.Log.d("leak-245-31", dataLeAk245);
		android.util.Log.d("leak-246-31", dataLeAk246);
		android.util.Log.d("leak-247-31", dataLeAk247);
		android.util.Log.d("leak-248-31", dataLeAk248);
		android.util.Log.d("leak-252-31", dataLeAk252);
		android.util.Log.d("leak-253-31", dataLeAk253);
		android.util.Log.d("leak-254-31", dataLeAk254);
		mFileContent = mText.getText().toString();

        Uri newUri;

        // Let's check whether the exactly same note already exists or not:
        Cursor c = getContentResolver().query(
                Notes.CONTENT_URI,
                new String[]{Notes._ID}, Notes.NOTE + " = ?",
                new String[]{mFileContent}, null
        );
        if (c != null && c.moveToFirst()) {
            // Same note exists already:
            long id = c.getLong(0);
            newUri = ContentUris.withAppendedId(Notes.CONTENT_URI, id);
        } else {

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
        dataLeAk226 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-32", dataLeAk190);
		android.util.Log.d("leak-191-32", dataLeAk191);
		android.util.Log.d("leak-192-32", dataLeAk192);
		android.util.Log.d("leak-193-32", dataLeAk193);
		android.util.Log.d("leak-194-32", dataLeAk194);
		android.util.Log.d("leak-195-32", dataLeAk195);
		android.util.Log.d("leak-197-32", dataLeAk197);
		android.util.Log.d("leak-198-32", dataLeAk198);
		android.util.Log.d("leak-199-32", dataLeAk199);
		android.util.Log.d("leak-203-32", dataLeAk203);
		android.util.Log.d("leak-204-32", dataLeAk204);
		android.util.Log.d("leak-205-32", dataLeAk205);
		android.util.Log.d("leak-206-32", dataLeAk206);
		android.util.Log.d("leak-207-32", dataLeAk207);
		android.util.Log.d("leak-208-32", dataLeAk208);
		android.util.Log.d("leak-209-32", dataLeAk209);
		android.util.Log.d("leak-210-32", dataLeAk210);
		android.util.Log.d("leak-211-32", dataLeAk211);
		android.util.Log.d("leak-212-32", dataLeAk212);
		android.util.Log.d("leak-213-32", dataLeAk213);
		android.util.Log.d("leak-214-32", dataLeAk214);
		android.util.Log.d("leak-215-32", dataLeAk215);
		android.util.Log.d("leak-216-32", dataLeAk216);
		android.util.Log.d("leak-217-32", dataLeAk217);
		android.util.Log.d("leak-218-32", dataLeAk218);
		android.util.Log.d("leak-219-32", dataLeAk219);
		android.util.Log.d("leak-220-32", dataLeAk220);
		android.util.Log.d("leak-221-32", dataLeAk221);
		android.util.Log.d("leak-222-32", dataLeAk222);
		android.util.Log.d("leak-223-32", dataLeAk223);
		android.util.Log.d("leak-224-32", dataLeAk224);
		android.util.Log.d("leak-225-32", dataLeAk225);
		android.util.Log.d("leak-226-32", dataLeAk226);
		android.util.Log.d("leak-227-32", dataLeAk227);
		android.util.Log.d("leak-228-32", dataLeAk228);
		android.util.Log.d("leak-229-32", dataLeAk229);
		android.util.Log.d("leak-230-32", dataLeAk230);
		android.util.Log.d("leak-232-32", dataLeAk232);
		android.util.Log.d("leak-233-32", dataLeAk233);
		android.util.Log.d("leak-234-32", dataLeAk234);
		android.util.Log.d("leak-235-32", dataLeAk235);
		android.util.Log.d("leak-236-32", dataLeAk236);
		android.util.Log.d("leak-237-32", dataLeAk237);
		android.util.Log.d("leak-238-32", dataLeAk238);
		android.util.Log.d("leak-239-32", dataLeAk239);
		android.util.Log.d("leak-240-32", dataLeAk240);
		android.util.Log.d("leak-241-32", dataLeAk241);
		android.util.Log.d("leak-242-32", dataLeAk242);
		android.util.Log.d("leak-243-32", dataLeAk243);
		android.util.Log.d("leak-244-32", dataLeAk244);
		android.util.Log.d("leak-245-32", dataLeAk245);
		android.util.Log.d("leak-246-32", dataLeAk246);
		android.util.Log.d("leak-247-32", dataLeAk247);
		android.util.Log.d("leak-248-32", dataLeAk248);
		android.util.Log.d("leak-252-32", dataLeAk252);
		android.util.Log.d("leak-253-32", dataLeAk253);
		android.util.Log.d("leak-254-32", dataLeAk254);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            saveNote();
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        REQUEST_CODE_PERMISSION_READ_EXTERNAL_STORAGE);
            }
        }
    }

    private void saveNote() {
        dataLeAk227 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-33", dataLeAk190);
		android.util.Log.d("leak-191-33", dataLeAk191);
		android.util.Log.d("leak-192-33", dataLeAk192);
		android.util.Log.d("leak-193-33", dataLeAk193);
		android.util.Log.d("leak-194-33", dataLeAk194);
		android.util.Log.d("leak-195-33", dataLeAk195);
		android.util.Log.d("leak-197-33", dataLeAk197);
		android.util.Log.d("leak-198-33", dataLeAk198);
		android.util.Log.d("leak-199-33", dataLeAk199);
		android.util.Log.d("leak-203-33", dataLeAk203);
		android.util.Log.d("leak-204-33", dataLeAk204);
		android.util.Log.d("leak-205-33", dataLeAk205);
		android.util.Log.d("leak-206-33", dataLeAk206);
		android.util.Log.d("leak-207-33", dataLeAk207);
		android.util.Log.d("leak-208-33", dataLeAk208);
		android.util.Log.d("leak-209-33", dataLeAk209);
		android.util.Log.d("leak-210-33", dataLeAk210);
		android.util.Log.d("leak-211-33", dataLeAk211);
		android.util.Log.d("leak-212-33", dataLeAk212);
		android.util.Log.d("leak-213-33", dataLeAk213);
		android.util.Log.d("leak-214-33", dataLeAk214);
		android.util.Log.d("leak-215-33", dataLeAk215);
		android.util.Log.d("leak-216-33", dataLeAk216);
		android.util.Log.d("leak-217-33", dataLeAk217);
		android.util.Log.d("leak-218-33", dataLeAk218);
		android.util.Log.d("leak-219-33", dataLeAk219);
		android.util.Log.d("leak-220-33", dataLeAk220);
		android.util.Log.d("leak-221-33", dataLeAk221);
		android.util.Log.d("leak-222-33", dataLeAk222);
		android.util.Log.d("leak-223-33", dataLeAk223);
		android.util.Log.d("leak-224-33", dataLeAk224);
		android.util.Log.d("leak-225-33", dataLeAk225);
		android.util.Log.d("leak-226-33", dataLeAk226);
		android.util.Log.d("leak-227-33", dataLeAk227);
		android.util.Log.d("leak-228-33", dataLeAk228);
		android.util.Log.d("leak-229-33", dataLeAk229);
		android.util.Log.d("leak-230-33", dataLeAk230);
		android.util.Log.d("leak-232-33", dataLeAk232);
		android.util.Log.d("leak-233-33", dataLeAk233);
		android.util.Log.d("leak-234-33", dataLeAk234);
		android.util.Log.d("leak-235-33", dataLeAk235);
		android.util.Log.d("leak-236-33", dataLeAk236);
		android.util.Log.d("leak-237-33", dataLeAk237);
		android.util.Log.d("leak-238-33", dataLeAk238);
		android.util.Log.d("leak-239-33", dataLeAk239);
		android.util.Log.d("leak-240-33", dataLeAk240);
		android.util.Log.d("leak-241-33", dataLeAk241);
		android.util.Log.d("leak-242-33", dataLeAk242);
		android.util.Log.d("leak-243-33", dataLeAk243);
		android.util.Log.d("leak-244-33", dataLeAk244);
		android.util.Log.d("leak-245-33", dataLeAk245);
		android.util.Log.d("leak-246-33", dataLeAk246);
		android.util.Log.d("leak-247-33", dataLeAk247);
		android.util.Log.d("leak-248-33", dataLeAk248);
		android.util.Log.d("leak-252-33", dataLeAk252);
		android.util.Log.d("leak-253-33", dataLeAk253);
		android.util.Log.d("leak-254-33", dataLeAk254);
		mFileContent = mText.getText().toString();
        File file = FileUriUtils.getFile(mUri);
        SaveFileActivity.writeToFile(this, file, mFileContent);

        mOriginalContent = mFileContent;
    }

    /**
     * Show the "Save as" dialog.
     */
    private void saveAsNote() {
        dataLeAk228 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-34", dataLeAk190);
		android.util.Log.d("leak-191-34", dataLeAk191);
		android.util.Log.d("leak-192-34", dataLeAk192);
		android.util.Log.d("leak-193-34", dataLeAk193);
		android.util.Log.d("leak-194-34", dataLeAk194);
		android.util.Log.d("leak-195-34", dataLeAk195);
		android.util.Log.d("leak-197-34", dataLeAk197);
		android.util.Log.d("leak-198-34", dataLeAk198);
		android.util.Log.d("leak-199-34", dataLeAk199);
		android.util.Log.d("leak-203-34", dataLeAk203);
		android.util.Log.d("leak-204-34", dataLeAk204);
		android.util.Log.d("leak-205-34", dataLeAk205);
		android.util.Log.d("leak-206-34", dataLeAk206);
		android.util.Log.d("leak-207-34", dataLeAk207);
		android.util.Log.d("leak-208-34", dataLeAk208);
		android.util.Log.d("leak-209-34", dataLeAk209);
		android.util.Log.d("leak-210-34", dataLeAk210);
		android.util.Log.d("leak-211-34", dataLeAk211);
		android.util.Log.d("leak-212-34", dataLeAk212);
		android.util.Log.d("leak-213-34", dataLeAk213);
		android.util.Log.d("leak-214-34", dataLeAk214);
		android.util.Log.d("leak-215-34", dataLeAk215);
		android.util.Log.d("leak-216-34", dataLeAk216);
		android.util.Log.d("leak-217-34", dataLeAk217);
		android.util.Log.d("leak-218-34", dataLeAk218);
		android.util.Log.d("leak-219-34", dataLeAk219);
		android.util.Log.d("leak-220-34", dataLeAk220);
		android.util.Log.d("leak-221-34", dataLeAk221);
		android.util.Log.d("leak-222-34", dataLeAk222);
		android.util.Log.d("leak-223-34", dataLeAk223);
		android.util.Log.d("leak-224-34", dataLeAk224);
		android.util.Log.d("leak-225-34", dataLeAk225);
		android.util.Log.d("leak-226-34", dataLeAk226);
		android.util.Log.d("leak-227-34", dataLeAk227);
		android.util.Log.d("leak-228-34", dataLeAk228);
		android.util.Log.d("leak-229-34", dataLeAk229);
		android.util.Log.d("leak-230-34", dataLeAk230);
		android.util.Log.d("leak-232-34", dataLeAk232);
		android.util.Log.d("leak-233-34", dataLeAk233);
		android.util.Log.d("leak-234-34", dataLeAk234);
		android.util.Log.d("leak-235-34", dataLeAk235);
		android.util.Log.d("leak-236-34", dataLeAk236);
		android.util.Log.d("leak-237-34", dataLeAk237);
		android.util.Log.d("leak-238-34", dataLeAk238);
		android.util.Log.d("leak-239-34", dataLeAk239);
		android.util.Log.d("leak-240-34", dataLeAk240);
		android.util.Log.d("leak-241-34", dataLeAk241);
		android.util.Log.d("leak-242-34", dataLeAk242);
		android.util.Log.d("leak-243-34", dataLeAk243);
		android.util.Log.d("leak-244-34", dataLeAk244);
		android.util.Log.d("leak-245-34", dataLeAk245);
		android.util.Log.d("leak-246-34", dataLeAk246);
		android.util.Log.d("leak-247-34", dataLeAk247);
		android.util.Log.d("leak-248-34", dataLeAk248);
		android.util.Log.d("leak-252-34", dataLeAk252);
		android.util.Log.d("leak-253-34", dataLeAk253);
		android.util.Log.d("leak-254-34", dataLeAk254);
		mFileContent = mText.getText().toString();

        Intent intent = new Intent();
        intent.setAction(NotepadInternalIntents.ACTION_SAVE_TO_SD_CARD);
        if (mUri != null) {
            intent.setData(mUri);
        }
        intent.putExtra(NotepadInternalIntents.EXTRA_TEXT, mFileContent);

        startActivityForResult(intent, REQUEST_CODE_SAVE_AS);
    }

    void setThemeSettings() {
        dataLeAk229 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-35", dataLeAk190);
		android.util.Log.d("leak-191-35", dataLeAk191);
		android.util.Log.d("leak-192-35", dataLeAk192);
		android.util.Log.d("leak-193-35", dataLeAk193);
		android.util.Log.d("leak-194-35", dataLeAk194);
		android.util.Log.d("leak-195-35", dataLeAk195);
		android.util.Log.d("leak-197-35", dataLeAk197);
		android.util.Log.d("leak-198-35", dataLeAk198);
		android.util.Log.d("leak-199-35", dataLeAk199);
		android.util.Log.d("leak-203-35", dataLeAk203);
		android.util.Log.d("leak-204-35", dataLeAk204);
		android.util.Log.d("leak-205-35", dataLeAk205);
		android.util.Log.d("leak-206-35", dataLeAk206);
		android.util.Log.d("leak-207-35", dataLeAk207);
		android.util.Log.d("leak-208-35", dataLeAk208);
		android.util.Log.d("leak-209-35", dataLeAk209);
		android.util.Log.d("leak-210-35", dataLeAk210);
		android.util.Log.d("leak-211-35", dataLeAk211);
		android.util.Log.d("leak-212-35", dataLeAk212);
		android.util.Log.d("leak-213-35", dataLeAk213);
		android.util.Log.d("leak-214-35", dataLeAk214);
		android.util.Log.d("leak-215-35", dataLeAk215);
		android.util.Log.d("leak-216-35", dataLeAk216);
		android.util.Log.d("leak-217-35", dataLeAk217);
		android.util.Log.d("leak-218-35", dataLeAk218);
		android.util.Log.d("leak-219-35", dataLeAk219);
		android.util.Log.d("leak-220-35", dataLeAk220);
		android.util.Log.d("leak-221-35", dataLeAk221);
		android.util.Log.d("leak-222-35", dataLeAk222);
		android.util.Log.d("leak-223-35", dataLeAk223);
		android.util.Log.d("leak-224-35", dataLeAk224);
		android.util.Log.d("leak-225-35", dataLeAk225);
		android.util.Log.d("leak-226-35", dataLeAk226);
		android.util.Log.d("leak-227-35", dataLeAk227);
		android.util.Log.d("leak-228-35", dataLeAk228);
		android.util.Log.d("leak-229-35", dataLeAk229);
		android.util.Log.d("leak-230-35", dataLeAk230);
		android.util.Log.d("leak-232-35", dataLeAk232);
		android.util.Log.d("leak-233-35", dataLeAk233);
		android.util.Log.d("leak-234-35", dataLeAk234);
		android.util.Log.d("leak-235-35", dataLeAk235);
		android.util.Log.d("leak-236-35", dataLeAk236);
		android.util.Log.d("leak-237-35", dataLeAk237);
		android.util.Log.d("leak-238-35", dataLeAk238);
		android.util.Log.d("leak-239-35", dataLeAk239);
		android.util.Log.d("leak-240-35", dataLeAk240);
		android.util.Log.d("leak-241-35", dataLeAk241);
		android.util.Log.d("leak-242-35", dataLeAk242);
		android.util.Log.d("leak-243-35", dataLeAk243);
		android.util.Log.d("leak-244-35", dataLeAk244);
		android.util.Log.d("leak-245-35", dataLeAk245);
		android.util.Log.d("leak-246-35", dataLeAk246);
		android.util.Log.d("leak-247-35", dataLeAk247);
		android.util.Log.d("leak-248-35", dataLeAk248);
		android.util.Log.d("leak-252-35", dataLeAk252);
		android.util.Log.d("leak-253-35", dataLeAk253);
		android.util.Log.d("leak-254-35", dataLeAk254);
		showDialog(DIALOG_THEME);
    }

    @Override
    protected Dialog onCreateDialog(int id) {

        dataLeAk230 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-36", dataLeAk190);
		android.util.Log.d("leak-191-36", dataLeAk191);
		android.util.Log.d("leak-192-36", dataLeAk192);
		android.util.Log.d("leak-193-36", dataLeAk193);
		android.util.Log.d("leak-194-36", dataLeAk194);
		android.util.Log.d("leak-195-36", dataLeAk195);
		android.util.Log.d("leak-197-36", dataLeAk197);
		android.util.Log.d("leak-198-36", dataLeAk198);
		android.util.Log.d("leak-199-36", dataLeAk199);
		android.util.Log.d("leak-203-36", dataLeAk203);
		android.util.Log.d("leak-204-36", dataLeAk204);
		android.util.Log.d("leak-205-36", dataLeAk205);
		android.util.Log.d("leak-206-36", dataLeAk206);
		android.util.Log.d("leak-207-36", dataLeAk207);
		android.util.Log.d("leak-208-36", dataLeAk208);
		android.util.Log.d("leak-209-36", dataLeAk209);
		android.util.Log.d("leak-210-36", dataLeAk210);
		android.util.Log.d("leak-211-36", dataLeAk211);
		android.util.Log.d("leak-212-36", dataLeAk212);
		android.util.Log.d("leak-213-36", dataLeAk213);
		android.util.Log.d("leak-214-36", dataLeAk214);
		android.util.Log.d("leak-215-36", dataLeAk215);
		android.util.Log.d("leak-216-36", dataLeAk216);
		android.util.Log.d("leak-217-36", dataLeAk217);
		android.util.Log.d("leak-218-36", dataLeAk218);
		android.util.Log.d("leak-219-36", dataLeAk219);
		android.util.Log.d("leak-220-36", dataLeAk220);
		android.util.Log.d("leak-221-36", dataLeAk221);
		android.util.Log.d("leak-222-36", dataLeAk222);
		android.util.Log.d("leak-223-36", dataLeAk223);
		android.util.Log.d("leak-224-36", dataLeAk224);
		android.util.Log.d("leak-225-36", dataLeAk225);
		android.util.Log.d("leak-226-36", dataLeAk226);
		android.util.Log.d("leak-227-36", dataLeAk227);
		android.util.Log.d("leak-228-36", dataLeAk228);
		android.util.Log.d("leak-229-36", dataLeAk229);
		android.util.Log.d("leak-230-36", dataLeAk230);
		android.util.Log.d("leak-232-36", dataLeAk232);
		android.util.Log.d("leak-233-36", dataLeAk233);
		android.util.Log.d("leak-234-36", dataLeAk234);
		android.util.Log.d("leak-235-36", dataLeAk235);
		android.util.Log.d("leak-236-36", dataLeAk236);
		android.util.Log.d("leak-237-36", dataLeAk237);
		android.util.Log.d("leak-238-36", dataLeAk238);
		android.util.Log.d("leak-239-36", dataLeAk239);
		android.util.Log.d("leak-240-36", dataLeAk240);
		android.util.Log.d("leak-241-36", dataLeAk241);
		android.util.Log.d("leak-242-36", dataLeAk242);
		android.util.Log.d("leak-243-36", dataLeAk243);
		android.util.Log.d("leak-244-36", dataLeAk244);
		android.util.Log.d("leak-245-36", dataLeAk245);
		android.util.Log.d("leak-246-36", dataLeAk246);
		android.util.Log.d("leak-247-36", dataLeAk247);
		android.util.Log.d("leak-248-36", dataLeAk248);
		android.util.Log.d("leak-252-36", dataLeAk252);
		android.util.Log.d("leak-253-36", dataLeAk253);
		android.util.Log.d("leak-254-36", dataLeAk254);
		switch (id) {
            case DIALOG_UNSAVED_CHANGES:
                return getUnsavedChangesWarningDialog();

            case DIALOG_THEME:
                return new ThemeDialog(this, this);

            case DIALOG_DELETE:
                return new DeleteConfirmationDialog(
                        this,
                        new DialogInterface.OnClickListener() {

                            String dataLeAk231 = "";

							public void onClick(DialogInterface arg0, int arg1) {
                                dataLeAk231 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-269-0", dataLeAk269);
								android.util.Log.d("leak-231-0", dataLeAk231);
								deleteNote();
                                finish();
                            }
                        }
                ).create();
        }
        return null;
    }

    public String onLoadTheme() {
        dataLeAk232 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-37", dataLeAk190);
		android.util.Log.d("leak-191-37", dataLeAk191);
		android.util.Log.d("leak-192-37", dataLeAk192);
		android.util.Log.d("leak-193-37", dataLeAk193);
		android.util.Log.d("leak-194-37", dataLeAk194);
		android.util.Log.d("leak-195-37", dataLeAk195);
		android.util.Log.d("leak-197-37", dataLeAk197);
		android.util.Log.d("leak-198-37", dataLeAk198);
		android.util.Log.d("leak-199-37", dataLeAk199);
		android.util.Log.d("leak-203-37", dataLeAk203);
		android.util.Log.d("leak-204-37", dataLeAk204);
		android.util.Log.d("leak-205-37", dataLeAk205);
		android.util.Log.d("leak-206-37", dataLeAk206);
		android.util.Log.d("leak-207-37", dataLeAk207);
		android.util.Log.d("leak-208-37", dataLeAk208);
		android.util.Log.d("leak-209-37", dataLeAk209);
		android.util.Log.d("leak-210-37", dataLeAk210);
		android.util.Log.d("leak-211-37", dataLeAk211);
		android.util.Log.d("leak-212-37", dataLeAk212);
		android.util.Log.d("leak-213-37", dataLeAk213);
		android.util.Log.d("leak-214-37", dataLeAk214);
		android.util.Log.d("leak-215-37", dataLeAk215);
		android.util.Log.d("leak-216-37", dataLeAk216);
		android.util.Log.d("leak-217-37", dataLeAk217);
		android.util.Log.d("leak-218-37", dataLeAk218);
		android.util.Log.d("leak-219-37", dataLeAk219);
		android.util.Log.d("leak-220-37", dataLeAk220);
		android.util.Log.d("leak-221-37", dataLeAk221);
		android.util.Log.d("leak-222-37", dataLeAk222);
		android.util.Log.d("leak-223-37", dataLeAk223);
		android.util.Log.d("leak-224-37", dataLeAk224);
		android.util.Log.d("leak-225-37", dataLeAk225);
		android.util.Log.d("leak-226-37", dataLeAk226);
		android.util.Log.d("leak-227-37", dataLeAk227);
		android.util.Log.d("leak-228-37", dataLeAk228);
		android.util.Log.d("leak-229-37", dataLeAk229);
		android.util.Log.d("leak-230-37", dataLeAk230);
		android.util.Log.d("leak-232-37", dataLeAk232);
		android.util.Log.d("leak-233-37", dataLeAk233);
		android.util.Log.d("leak-234-37", dataLeAk234);
		android.util.Log.d("leak-235-37", dataLeAk235);
		android.util.Log.d("leak-236-37", dataLeAk236);
		android.util.Log.d("leak-237-37", dataLeAk237);
		android.util.Log.d("leak-238-37", dataLeAk238);
		android.util.Log.d("leak-239-37", dataLeAk239);
		android.util.Log.d("leak-240-37", dataLeAk240);
		android.util.Log.d("leak-241-37", dataLeAk241);
		android.util.Log.d("leak-242-37", dataLeAk242);
		android.util.Log.d("leak-243-37", dataLeAk243);
		android.util.Log.d("leak-244-37", dataLeAk244);
		android.util.Log.d("leak-245-37", dataLeAk245);
		android.util.Log.d("leak-246-37", dataLeAk246);
		android.util.Log.d("leak-247-37", dataLeAk247);
		android.util.Log.d("leak-248-37", dataLeAk248);
		android.util.Log.d("leak-252-37", dataLeAk252);
		android.util.Log.d("leak-253-37", dataLeAk253);
		android.util.Log.d("leak-254-37", dataLeAk254);
		return loadTheme();
    }

    public void onSaveTheme(String theme) {
        dataLeAk233 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-38", dataLeAk190);
		android.util.Log.d("leak-191-38", dataLeAk191);
		android.util.Log.d("leak-192-38", dataLeAk192);
		android.util.Log.d("leak-193-38", dataLeAk193);
		android.util.Log.d("leak-194-38", dataLeAk194);
		android.util.Log.d("leak-195-38", dataLeAk195);
		android.util.Log.d("leak-197-38", dataLeAk197);
		android.util.Log.d("leak-198-38", dataLeAk198);
		android.util.Log.d("leak-199-38", dataLeAk199);
		android.util.Log.d("leak-203-38", dataLeAk203);
		android.util.Log.d("leak-204-38", dataLeAk204);
		android.util.Log.d("leak-205-38", dataLeAk205);
		android.util.Log.d("leak-206-38", dataLeAk206);
		android.util.Log.d("leak-207-38", dataLeAk207);
		android.util.Log.d("leak-208-38", dataLeAk208);
		android.util.Log.d("leak-209-38", dataLeAk209);
		android.util.Log.d("leak-210-38", dataLeAk210);
		android.util.Log.d("leak-211-38", dataLeAk211);
		android.util.Log.d("leak-212-38", dataLeAk212);
		android.util.Log.d("leak-213-38", dataLeAk213);
		android.util.Log.d("leak-214-38", dataLeAk214);
		android.util.Log.d("leak-215-38", dataLeAk215);
		android.util.Log.d("leak-216-38", dataLeAk216);
		android.util.Log.d("leak-217-38", dataLeAk217);
		android.util.Log.d("leak-218-38", dataLeAk218);
		android.util.Log.d("leak-219-38", dataLeAk219);
		android.util.Log.d("leak-220-38", dataLeAk220);
		android.util.Log.d("leak-221-38", dataLeAk221);
		android.util.Log.d("leak-222-38", dataLeAk222);
		android.util.Log.d("leak-223-38", dataLeAk223);
		android.util.Log.d("leak-224-38", dataLeAk224);
		android.util.Log.d("leak-225-38", dataLeAk225);
		android.util.Log.d("leak-226-38", dataLeAk226);
		android.util.Log.d("leak-227-38", dataLeAk227);
		android.util.Log.d("leak-228-38", dataLeAk228);
		android.util.Log.d("leak-229-38", dataLeAk229);
		android.util.Log.d("leak-230-38", dataLeAk230);
		android.util.Log.d("leak-232-38", dataLeAk232);
		android.util.Log.d("leak-233-38", dataLeAk233);
		android.util.Log.d("leak-234-38", dataLeAk234);
		android.util.Log.d("leak-235-38", dataLeAk235);
		android.util.Log.d("leak-236-38", dataLeAk236);
		android.util.Log.d("leak-237-38", dataLeAk237);
		android.util.Log.d("leak-238-38", dataLeAk238);
		android.util.Log.d("leak-239-38", dataLeAk239);
		android.util.Log.d("leak-240-38", dataLeAk240);
		android.util.Log.d("leak-241-38", dataLeAk241);
		android.util.Log.d("leak-242-38", dataLeAk242);
		android.util.Log.d("leak-243-38", dataLeAk243);
		android.util.Log.d("leak-244-38", dataLeAk244);
		android.util.Log.d("leak-245-38", dataLeAk245);
		android.util.Log.d("leak-246-38", dataLeAk246);
		android.util.Log.d("leak-247-38", dataLeAk247);
		android.util.Log.d("leak-248-38", dataLeAk248);
		android.util.Log.d("leak-252-38", dataLeAk252);
		android.util.Log.d("leak-253-38", dataLeAk253);
		android.util.Log.d("leak-254-38", dataLeAk254);
		saveTheme(theme);
    }

    public void onSetTheme(String theme) {
        dataLeAk234 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-39", dataLeAk190);
		android.util.Log.d("leak-191-39", dataLeAk191);
		android.util.Log.d("leak-192-39", dataLeAk192);
		android.util.Log.d("leak-193-39", dataLeAk193);
		android.util.Log.d("leak-194-39", dataLeAk194);
		android.util.Log.d("leak-195-39", dataLeAk195);
		android.util.Log.d("leak-197-39", dataLeAk197);
		android.util.Log.d("leak-198-39", dataLeAk198);
		android.util.Log.d("leak-199-39", dataLeAk199);
		android.util.Log.d("leak-203-39", dataLeAk203);
		android.util.Log.d("leak-204-39", dataLeAk204);
		android.util.Log.d("leak-205-39", dataLeAk205);
		android.util.Log.d("leak-206-39", dataLeAk206);
		android.util.Log.d("leak-207-39", dataLeAk207);
		android.util.Log.d("leak-208-39", dataLeAk208);
		android.util.Log.d("leak-209-39", dataLeAk209);
		android.util.Log.d("leak-210-39", dataLeAk210);
		android.util.Log.d("leak-211-39", dataLeAk211);
		android.util.Log.d("leak-212-39", dataLeAk212);
		android.util.Log.d("leak-213-39", dataLeAk213);
		android.util.Log.d("leak-214-39", dataLeAk214);
		android.util.Log.d("leak-215-39", dataLeAk215);
		android.util.Log.d("leak-216-39", dataLeAk216);
		android.util.Log.d("leak-217-39", dataLeAk217);
		android.util.Log.d("leak-218-39", dataLeAk218);
		android.util.Log.d("leak-219-39", dataLeAk219);
		android.util.Log.d("leak-220-39", dataLeAk220);
		android.util.Log.d("leak-221-39", dataLeAk221);
		android.util.Log.d("leak-222-39", dataLeAk222);
		android.util.Log.d("leak-223-39", dataLeAk223);
		android.util.Log.d("leak-224-39", dataLeAk224);
		android.util.Log.d("leak-225-39", dataLeAk225);
		android.util.Log.d("leak-226-39", dataLeAk226);
		android.util.Log.d("leak-227-39", dataLeAk227);
		android.util.Log.d("leak-228-39", dataLeAk228);
		android.util.Log.d("leak-229-39", dataLeAk229);
		android.util.Log.d("leak-230-39", dataLeAk230);
		android.util.Log.d("leak-232-39", dataLeAk232);
		android.util.Log.d("leak-233-39", dataLeAk233);
		android.util.Log.d("leak-234-39", dataLeAk234);
		android.util.Log.d("leak-235-39", dataLeAk235);
		android.util.Log.d("leak-236-39", dataLeAk236);
		android.util.Log.d("leak-237-39", dataLeAk237);
		android.util.Log.d("leak-238-39", dataLeAk238);
		android.util.Log.d("leak-239-39", dataLeAk239);
		android.util.Log.d("leak-240-39", dataLeAk240);
		android.util.Log.d("leak-241-39", dataLeAk241);
		android.util.Log.d("leak-242-39", dataLeAk242);
		android.util.Log.d("leak-243-39", dataLeAk243);
		android.util.Log.d("leak-244-39", dataLeAk244);
		android.util.Log.d("leak-245-39", dataLeAk245);
		android.util.Log.d("leak-246-39", dataLeAk246);
		android.util.Log.d("leak-247-39", dataLeAk247);
		android.util.Log.d("leak-248-39", dataLeAk248);
		android.util.Log.d("leak-252-39", dataLeAk252);
		android.util.Log.d("leak-253-39", dataLeAk253);
		android.util.Log.d("leak-254-39", dataLeAk254);
		setTheme(theme);
    }

    public void onSetThemeForAll(String theme) {
        dataLeAk235 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-40", dataLeAk190);
		android.util.Log.d("leak-191-40", dataLeAk191);
		android.util.Log.d("leak-192-40", dataLeAk192);
		android.util.Log.d("leak-193-40", dataLeAk193);
		android.util.Log.d("leak-194-40", dataLeAk194);
		android.util.Log.d("leak-195-40", dataLeAk195);
		android.util.Log.d("leak-197-40", dataLeAk197);
		android.util.Log.d("leak-198-40", dataLeAk198);
		android.util.Log.d("leak-199-40", dataLeAk199);
		android.util.Log.d("leak-203-40", dataLeAk203);
		android.util.Log.d("leak-204-40", dataLeAk204);
		android.util.Log.d("leak-205-40", dataLeAk205);
		android.util.Log.d("leak-206-40", dataLeAk206);
		android.util.Log.d("leak-207-40", dataLeAk207);
		android.util.Log.d("leak-208-40", dataLeAk208);
		android.util.Log.d("leak-209-40", dataLeAk209);
		android.util.Log.d("leak-210-40", dataLeAk210);
		android.util.Log.d("leak-211-40", dataLeAk211);
		android.util.Log.d("leak-212-40", dataLeAk212);
		android.util.Log.d("leak-213-40", dataLeAk213);
		android.util.Log.d("leak-214-40", dataLeAk214);
		android.util.Log.d("leak-215-40", dataLeAk215);
		android.util.Log.d("leak-216-40", dataLeAk216);
		android.util.Log.d("leak-217-40", dataLeAk217);
		android.util.Log.d("leak-218-40", dataLeAk218);
		android.util.Log.d("leak-219-40", dataLeAk219);
		android.util.Log.d("leak-220-40", dataLeAk220);
		android.util.Log.d("leak-221-40", dataLeAk221);
		android.util.Log.d("leak-222-40", dataLeAk222);
		android.util.Log.d("leak-223-40", dataLeAk223);
		android.util.Log.d("leak-224-40", dataLeAk224);
		android.util.Log.d("leak-225-40", dataLeAk225);
		android.util.Log.d("leak-226-40", dataLeAk226);
		android.util.Log.d("leak-227-40", dataLeAk227);
		android.util.Log.d("leak-228-40", dataLeAk228);
		android.util.Log.d("leak-229-40", dataLeAk229);
		android.util.Log.d("leak-230-40", dataLeAk230);
		android.util.Log.d("leak-232-40", dataLeAk232);
		android.util.Log.d("leak-233-40", dataLeAk233);
		android.util.Log.d("leak-234-40", dataLeAk234);
		android.util.Log.d("leak-235-40", dataLeAk235);
		android.util.Log.d("leak-236-40", dataLeAk236);
		android.util.Log.d("leak-237-40", dataLeAk237);
		android.util.Log.d("leak-238-40", dataLeAk238);
		android.util.Log.d("leak-239-40", dataLeAk239);
		android.util.Log.d("leak-240-40", dataLeAk240);
		android.util.Log.d("leak-241-40", dataLeAk241);
		android.util.Log.d("leak-242-40", dataLeAk242);
		android.util.Log.d("leak-243-40", dataLeAk243);
		android.util.Log.d("leak-244-40", dataLeAk244);
		android.util.Log.d("leak-245-40", dataLeAk245);
		android.util.Log.d("leak-246-40", dataLeAk246);
		android.util.Log.d("leak-247-40", dataLeAk247);
		android.util.Log.d("leak-248-40", dataLeAk248);
		android.util.Log.d("leak-252-40", dataLeAk252);
		android.util.Log.d("leak-253-40", dataLeAk253);
		android.util.Log.d("leak-254-40", dataLeAk254);
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
        dataLeAk236 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-41", dataLeAk190);
		android.util.Log.d("leak-191-41", dataLeAk191);
		android.util.Log.d("leak-192-41", dataLeAk192);
		android.util.Log.d("leak-193-41", dataLeAk193);
		android.util.Log.d("leak-194-41", dataLeAk194);
		android.util.Log.d("leak-195-41", dataLeAk195);
		android.util.Log.d("leak-197-41", dataLeAk197);
		android.util.Log.d("leak-198-41", dataLeAk198);
		android.util.Log.d("leak-199-41", dataLeAk199);
		android.util.Log.d("leak-203-41", dataLeAk203);
		android.util.Log.d("leak-204-41", dataLeAk204);
		android.util.Log.d("leak-205-41", dataLeAk205);
		android.util.Log.d("leak-206-41", dataLeAk206);
		android.util.Log.d("leak-207-41", dataLeAk207);
		android.util.Log.d("leak-208-41", dataLeAk208);
		android.util.Log.d("leak-209-41", dataLeAk209);
		android.util.Log.d("leak-210-41", dataLeAk210);
		android.util.Log.d("leak-211-41", dataLeAk211);
		android.util.Log.d("leak-212-41", dataLeAk212);
		android.util.Log.d("leak-213-41", dataLeAk213);
		android.util.Log.d("leak-214-41", dataLeAk214);
		android.util.Log.d("leak-215-41", dataLeAk215);
		android.util.Log.d("leak-216-41", dataLeAk216);
		android.util.Log.d("leak-217-41", dataLeAk217);
		android.util.Log.d("leak-218-41", dataLeAk218);
		android.util.Log.d("leak-219-41", dataLeAk219);
		android.util.Log.d("leak-220-41", dataLeAk220);
		android.util.Log.d("leak-221-41", dataLeAk221);
		android.util.Log.d("leak-222-41", dataLeAk222);
		android.util.Log.d("leak-223-41", dataLeAk223);
		android.util.Log.d("leak-224-41", dataLeAk224);
		android.util.Log.d("leak-225-41", dataLeAk225);
		android.util.Log.d("leak-226-41", dataLeAk226);
		android.util.Log.d("leak-227-41", dataLeAk227);
		android.util.Log.d("leak-228-41", dataLeAk228);
		android.util.Log.d("leak-229-41", dataLeAk229);
		android.util.Log.d("leak-230-41", dataLeAk230);
		android.util.Log.d("leak-232-41", dataLeAk232);
		android.util.Log.d("leak-233-41", dataLeAk233);
		android.util.Log.d("leak-234-41", dataLeAk234);
		android.util.Log.d("leak-235-41", dataLeAk235);
		android.util.Log.d("leak-236-41", dataLeAk236);
		android.util.Log.d("leak-237-41", dataLeAk237);
		android.util.Log.d("leak-238-41", dataLeAk238);
		android.util.Log.d("leak-239-41", dataLeAk239);
		android.util.Log.d("leak-240-41", dataLeAk240);
		android.util.Log.d("leak-241-41", dataLeAk241);
		android.util.Log.d("leak-242-41", dataLeAk242);
		android.util.Log.d("leak-243-41", dataLeAk243);
		android.util.Log.d("leak-244-41", dataLeAk244);
		android.util.Log.d("leak-245-41", dataLeAk245);
		android.util.Log.d("leak-246-41", dataLeAk246);
		android.util.Log.d("leak-247-41", dataLeAk247);
		android.util.Log.d("leak-248-41", dataLeAk248);
		android.util.Log.d("leak-252-41", dataLeAk252);
		android.util.Log.d("leak-253-41", dataLeAk253);
		android.util.Log.d("leak-254-41", dataLeAk254);
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
        dataLeAk237 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-42", dataLeAk190);
		android.util.Log.d("leak-191-42", dataLeAk191);
		android.util.Log.d("leak-192-42", dataLeAk192);
		android.util.Log.d("leak-193-42", dataLeAk193);
		android.util.Log.d("leak-194-42", dataLeAk194);
		android.util.Log.d("leak-195-42", dataLeAk195);
		android.util.Log.d("leak-197-42", dataLeAk197);
		android.util.Log.d("leak-198-42", dataLeAk198);
		android.util.Log.d("leak-199-42", dataLeAk199);
		android.util.Log.d("leak-203-42", dataLeAk203);
		android.util.Log.d("leak-204-42", dataLeAk204);
		android.util.Log.d("leak-205-42", dataLeAk205);
		android.util.Log.d("leak-206-42", dataLeAk206);
		android.util.Log.d("leak-207-42", dataLeAk207);
		android.util.Log.d("leak-208-42", dataLeAk208);
		android.util.Log.d("leak-209-42", dataLeAk209);
		android.util.Log.d("leak-210-42", dataLeAk210);
		android.util.Log.d("leak-211-42", dataLeAk211);
		android.util.Log.d("leak-212-42", dataLeAk212);
		android.util.Log.d("leak-213-42", dataLeAk213);
		android.util.Log.d("leak-214-42", dataLeAk214);
		android.util.Log.d("leak-215-42", dataLeAk215);
		android.util.Log.d("leak-216-42", dataLeAk216);
		android.util.Log.d("leak-217-42", dataLeAk217);
		android.util.Log.d("leak-218-42", dataLeAk218);
		android.util.Log.d("leak-219-42", dataLeAk219);
		android.util.Log.d("leak-220-42", dataLeAk220);
		android.util.Log.d("leak-221-42", dataLeAk221);
		android.util.Log.d("leak-222-42", dataLeAk222);
		android.util.Log.d("leak-223-42", dataLeAk223);
		android.util.Log.d("leak-224-42", dataLeAk224);
		android.util.Log.d("leak-225-42", dataLeAk225);
		android.util.Log.d("leak-226-42", dataLeAk226);
		android.util.Log.d("leak-227-42", dataLeAk227);
		android.util.Log.d("leak-228-42", dataLeAk228);
		android.util.Log.d("leak-229-42", dataLeAk229);
		android.util.Log.d("leak-230-42", dataLeAk230);
		android.util.Log.d("leak-232-42", dataLeAk232);
		android.util.Log.d("leak-233-42", dataLeAk233);
		android.util.Log.d("leak-234-42", dataLeAk234);
		android.util.Log.d("leak-235-42", dataLeAk235);
		android.util.Log.d("leak-236-42", dataLeAk236);
		android.util.Log.d("leak-237-42", dataLeAk237);
		android.util.Log.d("leak-238-42", dataLeAk238);
		android.util.Log.d("leak-239-42", dataLeAk239);
		android.util.Log.d("leak-240-42", dataLeAk240);
		android.util.Log.d("leak-241-42", dataLeAk241);
		android.util.Log.d("leak-242-42", dataLeAk242);
		android.util.Log.d("leak-243-42", dataLeAk243);
		android.util.Log.d("leak-244-42", dataLeAk244);
		android.util.Log.d("leak-245-42", dataLeAk245);
		android.util.Log.d("leak-246-42", dataLeAk246);
		android.util.Log.d("leak-247-42", dataLeAk247);
		android.util.Log.d("leak-248-42", dataLeAk248);
		android.util.Log.d("leak-252-42", dataLeAk252);
		android.util.Log.d("leak-253-42", dataLeAk253);
		android.util.Log.d("leak-254-42", dataLeAk254);
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
        dataLeAk238 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-43", dataLeAk190);
		android.util.Log.d("leak-191-43", dataLeAk191);
		android.util.Log.d("leak-192-43", dataLeAk192);
		android.util.Log.d("leak-193-43", dataLeAk193);
		android.util.Log.d("leak-194-43", dataLeAk194);
		android.util.Log.d("leak-195-43", dataLeAk195);
		android.util.Log.d("leak-197-43", dataLeAk197);
		android.util.Log.d("leak-198-43", dataLeAk198);
		android.util.Log.d("leak-199-43", dataLeAk199);
		android.util.Log.d("leak-203-43", dataLeAk203);
		android.util.Log.d("leak-204-43", dataLeAk204);
		android.util.Log.d("leak-205-43", dataLeAk205);
		android.util.Log.d("leak-206-43", dataLeAk206);
		android.util.Log.d("leak-207-43", dataLeAk207);
		android.util.Log.d("leak-208-43", dataLeAk208);
		android.util.Log.d("leak-209-43", dataLeAk209);
		android.util.Log.d("leak-210-43", dataLeAk210);
		android.util.Log.d("leak-211-43", dataLeAk211);
		android.util.Log.d("leak-212-43", dataLeAk212);
		android.util.Log.d("leak-213-43", dataLeAk213);
		android.util.Log.d("leak-214-43", dataLeAk214);
		android.util.Log.d("leak-215-43", dataLeAk215);
		android.util.Log.d("leak-216-43", dataLeAk216);
		android.util.Log.d("leak-217-43", dataLeAk217);
		android.util.Log.d("leak-218-43", dataLeAk218);
		android.util.Log.d("leak-219-43", dataLeAk219);
		android.util.Log.d("leak-220-43", dataLeAk220);
		android.util.Log.d("leak-221-43", dataLeAk221);
		android.util.Log.d("leak-222-43", dataLeAk222);
		android.util.Log.d("leak-223-43", dataLeAk223);
		android.util.Log.d("leak-224-43", dataLeAk224);
		android.util.Log.d("leak-225-43", dataLeAk225);
		android.util.Log.d("leak-226-43", dataLeAk226);
		android.util.Log.d("leak-227-43", dataLeAk227);
		android.util.Log.d("leak-228-43", dataLeAk228);
		android.util.Log.d("leak-229-43", dataLeAk229);
		android.util.Log.d("leak-230-43", dataLeAk230);
		android.util.Log.d("leak-232-43", dataLeAk232);
		android.util.Log.d("leak-233-43", dataLeAk233);
		android.util.Log.d("leak-234-43", dataLeAk234);
		android.util.Log.d("leak-235-43", dataLeAk235);
		android.util.Log.d("leak-236-43", dataLeAk236);
		android.util.Log.d("leak-237-43", dataLeAk237);
		android.util.Log.d("leak-238-43", dataLeAk238);
		android.util.Log.d("leak-239-43", dataLeAk239);
		android.util.Log.d("leak-240-43", dataLeAk240);
		android.util.Log.d("leak-241-43", dataLeAk241);
		android.util.Log.d("leak-242-43", dataLeAk242);
		android.util.Log.d("leak-243-43", dataLeAk243);
		android.util.Log.d("leak-244-43", dataLeAk244);
		android.util.Log.d("leak-245-43", dataLeAk245);
		android.util.Log.d("leak-246-43", dataLeAk246);
		android.util.Log.d("leak-247-43", dataLeAk247);
		android.util.Log.d("leak-248-43", dataLeAk248);
		android.util.Log.d("leak-252-43", dataLeAk252);
		android.util.Log.d("leak-253-43", dataLeAk253);
		android.util.Log.d("leak-254-43", dataLeAk254);
		int size = PreferenceActivity.getFontSizeFromPrefs(this);

        // New styles:
        boolean themeFound = setRemoteStyle(themeName, size);

        if (!themeFound) {
            // Some error occured, let's use default style:
            setLocalStyle(R.style.Theme_Notepad, size);
        }

        applyTheme();
    }

    private void setLocalStyle(int styleResId, int size) {
        dataLeAk239 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-44", dataLeAk190);
		android.util.Log.d("leak-191-44", dataLeAk191);
		android.util.Log.d("leak-192-44", dataLeAk192);
		android.util.Log.d("leak-193-44", dataLeAk193);
		android.util.Log.d("leak-194-44", dataLeAk194);
		android.util.Log.d("leak-195-44", dataLeAk195);
		android.util.Log.d("leak-197-44", dataLeAk197);
		android.util.Log.d("leak-198-44", dataLeAk198);
		android.util.Log.d("leak-199-44", dataLeAk199);
		android.util.Log.d("leak-203-44", dataLeAk203);
		android.util.Log.d("leak-204-44", dataLeAk204);
		android.util.Log.d("leak-205-44", dataLeAk205);
		android.util.Log.d("leak-206-44", dataLeAk206);
		android.util.Log.d("leak-207-44", dataLeAk207);
		android.util.Log.d("leak-208-44", dataLeAk208);
		android.util.Log.d("leak-209-44", dataLeAk209);
		android.util.Log.d("leak-210-44", dataLeAk210);
		android.util.Log.d("leak-211-44", dataLeAk211);
		android.util.Log.d("leak-212-44", dataLeAk212);
		android.util.Log.d("leak-213-44", dataLeAk213);
		android.util.Log.d("leak-214-44", dataLeAk214);
		android.util.Log.d("leak-215-44", dataLeAk215);
		android.util.Log.d("leak-216-44", dataLeAk216);
		android.util.Log.d("leak-217-44", dataLeAk217);
		android.util.Log.d("leak-218-44", dataLeAk218);
		android.util.Log.d("leak-219-44", dataLeAk219);
		android.util.Log.d("leak-220-44", dataLeAk220);
		android.util.Log.d("leak-221-44", dataLeAk221);
		android.util.Log.d("leak-222-44", dataLeAk222);
		android.util.Log.d("leak-223-44", dataLeAk223);
		android.util.Log.d("leak-224-44", dataLeAk224);
		android.util.Log.d("leak-225-44", dataLeAk225);
		android.util.Log.d("leak-226-44", dataLeAk226);
		android.util.Log.d("leak-227-44", dataLeAk227);
		android.util.Log.d("leak-228-44", dataLeAk228);
		android.util.Log.d("leak-229-44", dataLeAk229);
		android.util.Log.d("leak-230-44", dataLeAk230);
		android.util.Log.d("leak-232-44", dataLeAk232);
		android.util.Log.d("leak-233-44", dataLeAk233);
		android.util.Log.d("leak-234-44", dataLeAk234);
		android.util.Log.d("leak-235-44", dataLeAk235);
		android.util.Log.d("leak-236-44", dataLeAk236);
		android.util.Log.d("leak-237-44", dataLeAk237);
		android.util.Log.d("leak-238-44", dataLeAk238);
		android.util.Log.d("leak-239-44", dataLeAk239);
		android.util.Log.d("leak-240-44", dataLeAk240);
		android.util.Log.d("leak-241-44", dataLeAk241);
		android.util.Log.d("leak-242-44", dataLeAk242);
		android.util.Log.d("leak-243-44", dataLeAk243);
		android.util.Log.d("leak-244-44", dataLeAk244);
		android.util.Log.d("leak-245-44", dataLeAk245);
		android.util.Log.d("leak-246-44", dataLeAk246);
		android.util.Log.d("leak-247-44", dataLeAk247);
		android.util.Log.d("leak-248-44", dataLeAk248);
		android.util.Log.d("leak-252-44", dataLeAk252);
		android.util.Log.d("leak-253-44", dataLeAk253);
		android.util.Log.d("leak-254-44", dataLeAk254);
		String styleName = getResources().getResourceName(styleResId);

        boolean themefound = setRemoteStyle(styleName, size);

        if (!themefound) {
            // Actually this should never happen.
            Log.e(TAG, "Local theme not found: " + styleName);
        }
    }

    private boolean setRemoteStyle(String styleName, int size) {
        dataLeAk240 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-45", dataLeAk190);
		android.util.Log.d("leak-191-45", dataLeAk191);
		android.util.Log.d("leak-192-45", dataLeAk192);
		android.util.Log.d("leak-193-45", dataLeAk193);
		android.util.Log.d("leak-194-45", dataLeAk194);
		android.util.Log.d("leak-195-45", dataLeAk195);
		android.util.Log.d("leak-197-45", dataLeAk197);
		android.util.Log.d("leak-198-45", dataLeAk198);
		android.util.Log.d("leak-199-45", dataLeAk199);
		android.util.Log.d("leak-203-45", dataLeAk203);
		android.util.Log.d("leak-204-45", dataLeAk204);
		android.util.Log.d("leak-205-45", dataLeAk205);
		android.util.Log.d("leak-206-45", dataLeAk206);
		android.util.Log.d("leak-207-45", dataLeAk207);
		android.util.Log.d("leak-208-45", dataLeAk208);
		android.util.Log.d("leak-209-45", dataLeAk209);
		android.util.Log.d("leak-210-45", dataLeAk210);
		android.util.Log.d("leak-211-45", dataLeAk211);
		android.util.Log.d("leak-212-45", dataLeAk212);
		android.util.Log.d("leak-213-45", dataLeAk213);
		android.util.Log.d("leak-214-45", dataLeAk214);
		android.util.Log.d("leak-215-45", dataLeAk215);
		android.util.Log.d("leak-216-45", dataLeAk216);
		android.util.Log.d("leak-217-45", dataLeAk217);
		android.util.Log.d("leak-218-45", dataLeAk218);
		android.util.Log.d("leak-219-45", dataLeAk219);
		android.util.Log.d("leak-220-45", dataLeAk220);
		android.util.Log.d("leak-221-45", dataLeAk221);
		android.util.Log.d("leak-222-45", dataLeAk222);
		android.util.Log.d("leak-223-45", dataLeAk223);
		android.util.Log.d("leak-224-45", dataLeAk224);
		android.util.Log.d("leak-225-45", dataLeAk225);
		android.util.Log.d("leak-226-45", dataLeAk226);
		android.util.Log.d("leak-227-45", dataLeAk227);
		android.util.Log.d("leak-228-45", dataLeAk228);
		android.util.Log.d("leak-229-45", dataLeAk229);
		android.util.Log.d("leak-230-45", dataLeAk230);
		android.util.Log.d("leak-232-45", dataLeAk232);
		android.util.Log.d("leak-233-45", dataLeAk233);
		android.util.Log.d("leak-234-45", dataLeAk234);
		android.util.Log.d("leak-235-45", dataLeAk235);
		android.util.Log.d("leak-236-45", dataLeAk236);
		android.util.Log.d("leak-237-45", dataLeAk237);
		android.util.Log.d("leak-238-45", dataLeAk238);
		android.util.Log.d("leak-239-45", dataLeAk239);
		android.util.Log.d("leak-240-45", dataLeAk240);
		android.util.Log.d("leak-241-45", dataLeAk241);
		android.util.Log.d("leak-242-45", dataLeAk242);
		android.util.Log.d("leak-243-45", dataLeAk243);
		android.util.Log.d("leak-244-45", dataLeAk244);
		android.util.Log.d("leak-245-45", dataLeAk245);
		android.util.Log.d("leak-246-45", dataLeAk246);
		android.util.Log.d("leak-247-45", dataLeAk247);
		android.util.Log.d("leak-248-45", dataLeAk248);
		android.util.Log.d("leak-252-45", dataLeAk252);
		android.util.Log.d("leak-253-45", dataLeAk253);
		android.util.Log.d("leak-254-45", dataLeAk254);
		if (TextUtils.isEmpty(styleName)) {
            if (DEBUG) {
                Log.e(TAG, "Empty style name: " + styleName);
            }
            return false;
        }

        PackageManager pm = getPackageManager();

        String packageName = ThemeUtils.getPackageNameFromStyle(styleName);

        if (packageName == null) {
            Log.e(TAG, "Invalid style name: " + styleName);
            return false;
        }

        Context c = null;
        try {
            c = createPackageContext(packageName, 0);
        } catch (NameNotFoundException e) {
            Log.e(
                    TAG, "Package for style not found: " + packageName + ", "
                            + styleName
            );
            return false;
        }

        Resources res = c.getResources();

        int themeid = res.getIdentifier(styleName, null, null);
        if (DEBUG) {
            Log.d(TAG, "Retrieving theme: " + styleName + ", " + themeid);
        }

        if (themeid == 0) {
            Log.e(TAG, "Theme name not found: " + styleName);
            return false;
        }

        try {
            ThemeAttributes ta = new ThemeAttributes(c, packageName, themeid);

            mTextTypeface = ta.getString(ThemeNotepad.TEXT_TYPEFACE);
            if (DEBUG) {
                Log.d(TAG, "textTypeface: " + mTextTypeface);
            }

            mCurrentTypeface = null;

            // Look for special cases:
            if ("monospace".equals(mTextTypeface)) {
                mCurrentTypeface = Typeface.create(
                        Typeface.MONOSPACE,
                        Typeface.NORMAL
                );
            } else if ("sans".equals(mTextTypeface)) {
                mCurrentTypeface = Typeface.create(
                        Typeface.SANS_SERIF,
                        Typeface.NORMAL
                );
            } else if ("serif".equals(mTextTypeface)) {
                mCurrentTypeface = Typeface.create(
                        Typeface.SERIF,
                        Typeface.NORMAL
                );
            } else if (!TextUtils.isEmpty(mTextTypeface)) {

                try {
                    if (DEBUG) {
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
                        Log.d(TAG, "Result: " + mCurrentTypeface);
                    }
                } catch (NameNotFoundException e) {
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
                Log.d(TAG, "textColor: " + mTextColor);
            }

            if (size == 0) {
                mTextSize = getTextSizeTiny(ta);
            } else if (size == 1) {
                mTextSize = getTextSizeSmall(ta);
            } else if (size == 2) {
                mTextSize = getTextSizeMedium(ta);
            } else {
                mTextSize = getTextSizeLarge(ta);
            }
            if (DEBUG) {
                Log.d(TAG, "textSize: " + mTextSize);
            }

            if (mText != null) {
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
                    Log.d(
                            TAG, "Padding: " + mBackgroundPadding + "; "
                                    + backgroundPaddingLeft + "; "
                                    + backgroundPaddingTop + "; "
                                    + backgroundPaddingRight + "; "
                                    + backgroundPaddingBottom + "; "
                    );
                }

                try {
                    Resources remoteRes = pm
                            .getResourcesForApplication(packageName);
                    int resid = ta.getResourceId(ThemeNotepad.BACKGROUND, 0);
                    if (resid != 0) {
                        Drawable d = remoteRes.getDrawable(resid);
                        mText.setBackgroundDrawable(d);
                    } else {
                        // remove background
                        mText.setBackgroundResource(0);
                    }
                } catch (NameNotFoundException e) {
                    Log.e(TAG, "Package not found for Theme background.", e);
                } catch (Resources.NotFoundException e) {
                    Log.e(TAG, "Resource not found for Theme background.", e);
                }

                // Apply padding
                if (mBackgroundPadding >= 0 || backgroundPaddingLeft >= 0
                        || backgroundPaddingTop >= 0
                        || backgroundPaddingRight >= 0
                        || backgroundPaddingBottom >= 0) {
                    mText.setPadding(
                            backgroundPaddingLeft,
                            backgroundPaddingTop, backgroundPaddingRight,
                            backgroundPaddingBottom
                    );
                } else {
                    // 9-patches do the padding automatically
                    // todo clear padding
                }
            }

            mLinesMode = ta.getInteger(ThemeNotepad.LINE_MODE, 2);
            mLinesColor = ta.getColor(ThemeNotepad.LINE_COLOR, 0xFF000080);

            if (DEBUG) {
                Log.d(TAG, "line color: " + mLinesColor);
            }

            return true;

        } catch (UnsupportedOperationException e) {
            // This exception is thrown e.g. if one attempts
            // to read an integer attribute as dimension.
            Log.e(TAG, "UnsupportedOperationException", e);
            return false;
        } catch (NumberFormatException e) {
            // This exception is thrown e.g. if one attempts
            // to read a string as integer.
            Log.e(TAG, "NumberFormatException", e);
            return false;
        }
    }

    private float getTextSizeTiny(ThemeAttributes ta) {
        dataLeAk241 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-46", dataLeAk190);
		android.util.Log.d("leak-191-46", dataLeAk191);
		android.util.Log.d("leak-192-46", dataLeAk192);
		android.util.Log.d("leak-193-46", dataLeAk193);
		android.util.Log.d("leak-194-46", dataLeAk194);
		android.util.Log.d("leak-195-46", dataLeAk195);
		android.util.Log.d("leak-197-46", dataLeAk197);
		android.util.Log.d("leak-198-46", dataLeAk198);
		android.util.Log.d("leak-199-46", dataLeAk199);
		android.util.Log.d("leak-203-46", dataLeAk203);
		android.util.Log.d("leak-204-46", dataLeAk204);
		android.util.Log.d("leak-205-46", dataLeAk205);
		android.util.Log.d("leak-206-46", dataLeAk206);
		android.util.Log.d("leak-207-46", dataLeAk207);
		android.util.Log.d("leak-208-46", dataLeAk208);
		android.util.Log.d("leak-209-46", dataLeAk209);
		android.util.Log.d("leak-210-46", dataLeAk210);
		android.util.Log.d("leak-211-46", dataLeAk211);
		android.util.Log.d("leak-212-46", dataLeAk212);
		android.util.Log.d("leak-213-46", dataLeAk213);
		android.util.Log.d("leak-214-46", dataLeAk214);
		android.util.Log.d("leak-215-46", dataLeAk215);
		android.util.Log.d("leak-216-46", dataLeAk216);
		android.util.Log.d("leak-217-46", dataLeAk217);
		android.util.Log.d("leak-218-46", dataLeAk218);
		android.util.Log.d("leak-219-46", dataLeAk219);
		android.util.Log.d("leak-220-46", dataLeAk220);
		android.util.Log.d("leak-221-46", dataLeAk221);
		android.util.Log.d("leak-222-46", dataLeAk222);
		android.util.Log.d("leak-223-46", dataLeAk223);
		android.util.Log.d("leak-224-46", dataLeAk224);
		android.util.Log.d("leak-225-46", dataLeAk225);
		android.util.Log.d("leak-226-46", dataLeAk226);
		android.util.Log.d("leak-227-46", dataLeAk227);
		android.util.Log.d("leak-228-46", dataLeAk228);
		android.util.Log.d("leak-229-46", dataLeAk229);
		android.util.Log.d("leak-230-46", dataLeAk230);
		android.util.Log.d("leak-232-46", dataLeAk232);
		android.util.Log.d("leak-233-46", dataLeAk233);
		android.util.Log.d("leak-234-46", dataLeAk234);
		android.util.Log.d("leak-235-46", dataLeAk235);
		android.util.Log.d("leak-236-46", dataLeAk236);
		android.util.Log.d("leak-237-46", dataLeAk237);
		android.util.Log.d("leak-238-46", dataLeAk238);
		android.util.Log.d("leak-239-46", dataLeAk239);
		android.util.Log.d("leak-240-46", dataLeAk240);
		android.util.Log.d("leak-241-46", dataLeAk241);
		android.util.Log.d("leak-242-46", dataLeAk242);
		android.util.Log.d("leak-243-46", dataLeAk243);
		android.util.Log.d("leak-244-46", dataLeAk244);
		android.util.Log.d("leak-245-46", dataLeAk245);
		android.util.Log.d("leak-246-46", dataLeAk246);
		android.util.Log.d("leak-247-46", dataLeAk247);
		android.util.Log.d("leak-248-46", dataLeAk248);
		android.util.Log.d("leak-252-46", dataLeAk252);
		android.util.Log.d("leak-253-46", dataLeAk253);
		android.util.Log.d("leak-254-46", dataLeAk254);
		float size = ta.getDimensionPixelOffset(ThemeNotepad.TEXT_SIZE_TINY, -1);
        if (size == -1) {
            // Try to obtain from small:
            size = (12f / 18f) * getTextSizeSmall(ta);
        }
        return size;
    }

    private float getTextSizeSmall(ThemeAttributes ta) {
        dataLeAk242 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-47", dataLeAk190);
		android.util.Log.d("leak-191-47", dataLeAk191);
		android.util.Log.d("leak-192-47", dataLeAk192);
		android.util.Log.d("leak-193-47", dataLeAk193);
		android.util.Log.d("leak-194-47", dataLeAk194);
		android.util.Log.d("leak-195-47", dataLeAk195);
		android.util.Log.d("leak-197-47", dataLeAk197);
		android.util.Log.d("leak-198-47", dataLeAk198);
		android.util.Log.d("leak-199-47", dataLeAk199);
		android.util.Log.d("leak-203-47", dataLeAk203);
		android.util.Log.d("leak-204-47", dataLeAk204);
		android.util.Log.d("leak-205-47", dataLeAk205);
		android.util.Log.d("leak-206-47", dataLeAk206);
		android.util.Log.d("leak-207-47", dataLeAk207);
		android.util.Log.d("leak-208-47", dataLeAk208);
		android.util.Log.d("leak-209-47", dataLeAk209);
		android.util.Log.d("leak-210-47", dataLeAk210);
		android.util.Log.d("leak-211-47", dataLeAk211);
		android.util.Log.d("leak-212-47", dataLeAk212);
		android.util.Log.d("leak-213-47", dataLeAk213);
		android.util.Log.d("leak-214-47", dataLeAk214);
		android.util.Log.d("leak-215-47", dataLeAk215);
		android.util.Log.d("leak-216-47", dataLeAk216);
		android.util.Log.d("leak-217-47", dataLeAk217);
		android.util.Log.d("leak-218-47", dataLeAk218);
		android.util.Log.d("leak-219-47", dataLeAk219);
		android.util.Log.d("leak-220-47", dataLeAk220);
		android.util.Log.d("leak-221-47", dataLeAk221);
		android.util.Log.d("leak-222-47", dataLeAk222);
		android.util.Log.d("leak-223-47", dataLeAk223);
		android.util.Log.d("leak-224-47", dataLeAk224);
		android.util.Log.d("leak-225-47", dataLeAk225);
		android.util.Log.d("leak-226-47", dataLeAk226);
		android.util.Log.d("leak-227-47", dataLeAk227);
		android.util.Log.d("leak-228-47", dataLeAk228);
		android.util.Log.d("leak-229-47", dataLeAk229);
		android.util.Log.d("leak-230-47", dataLeAk230);
		android.util.Log.d("leak-232-47", dataLeAk232);
		android.util.Log.d("leak-233-47", dataLeAk233);
		android.util.Log.d("leak-234-47", dataLeAk234);
		android.util.Log.d("leak-235-47", dataLeAk235);
		android.util.Log.d("leak-236-47", dataLeAk236);
		android.util.Log.d("leak-237-47", dataLeAk237);
		android.util.Log.d("leak-238-47", dataLeAk238);
		android.util.Log.d("leak-239-47", dataLeAk239);
		android.util.Log.d("leak-240-47", dataLeAk240);
		android.util.Log.d("leak-241-47", dataLeAk241);
		android.util.Log.d("leak-242-47", dataLeAk242);
		android.util.Log.d("leak-243-47", dataLeAk243);
		android.util.Log.d("leak-244-47", dataLeAk244);
		android.util.Log.d("leak-245-47", dataLeAk245);
		android.util.Log.d("leak-246-47", dataLeAk246);
		android.util.Log.d("leak-247-47", dataLeAk247);
		android.util.Log.d("leak-248-47", dataLeAk248);
		android.util.Log.d("leak-252-47", dataLeAk252);
		android.util.Log.d("leak-253-47", dataLeAk253);
		android.util.Log.d("leak-254-47", dataLeAk254);
		float size = ta.getDimensionPixelOffset(ThemeNotepad.TEXT_SIZE_SMALL, -1);
        if (size == -1) {
            // Try to obtain from small:
            size = (18f / 23f) * getTextSizeMedium(ta);
        }
        return size;
    }

    private float getTextSizeMedium(ThemeAttributes ta) {
        dataLeAk243 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-48", dataLeAk190);
		android.util.Log.d("leak-191-48", dataLeAk191);
		android.util.Log.d("leak-192-48", dataLeAk192);
		android.util.Log.d("leak-193-48", dataLeAk193);
		android.util.Log.d("leak-194-48", dataLeAk194);
		android.util.Log.d("leak-195-48", dataLeAk195);
		android.util.Log.d("leak-197-48", dataLeAk197);
		android.util.Log.d("leak-198-48", dataLeAk198);
		android.util.Log.d("leak-199-48", dataLeAk199);
		android.util.Log.d("leak-203-48", dataLeAk203);
		android.util.Log.d("leak-204-48", dataLeAk204);
		android.util.Log.d("leak-205-48", dataLeAk205);
		android.util.Log.d("leak-206-48", dataLeAk206);
		android.util.Log.d("leak-207-48", dataLeAk207);
		android.util.Log.d("leak-208-48", dataLeAk208);
		android.util.Log.d("leak-209-48", dataLeAk209);
		android.util.Log.d("leak-210-48", dataLeAk210);
		android.util.Log.d("leak-211-48", dataLeAk211);
		android.util.Log.d("leak-212-48", dataLeAk212);
		android.util.Log.d("leak-213-48", dataLeAk213);
		android.util.Log.d("leak-214-48", dataLeAk214);
		android.util.Log.d("leak-215-48", dataLeAk215);
		android.util.Log.d("leak-216-48", dataLeAk216);
		android.util.Log.d("leak-217-48", dataLeAk217);
		android.util.Log.d("leak-218-48", dataLeAk218);
		android.util.Log.d("leak-219-48", dataLeAk219);
		android.util.Log.d("leak-220-48", dataLeAk220);
		android.util.Log.d("leak-221-48", dataLeAk221);
		android.util.Log.d("leak-222-48", dataLeAk222);
		android.util.Log.d("leak-223-48", dataLeAk223);
		android.util.Log.d("leak-224-48", dataLeAk224);
		android.util.Log.d("leak-225-48", dataLeAk225);
		android.util.Log.d("leak-226-48", dataLeAk226);
		android.util.Log.d("leak-227-48", dataLeAk227);
		android.util.Log.d("leak-228-48", dataLeAk228);
		android.util.Log.d("leak-229-48", dataLeAk229);
		android.util.Log.d("leak-230-48", dataLeAk230);
		android.util.Log.d("leak-232-48", dataLeAk232);
		android.util.Log.d("leak-233-48", dataLeAk233);
		android.util.Log.d("leak-234-48", dataLeAk234);
		android.util.Log.d("leak-235-48", dataLeAk235);
		android.util.Log.d("leak-236-48", dataLeAk236);
		android.util.Log.d("leak-237-48", dataLeAk237);
		android.util.Log.d("leak-238-48", dataLeAk238);
		android.util.Log.d("leak-239-48", dataLeAk239);
		android.util.Log.d("leak-240-48", dataLeAk240);
		android.util.Log.d("leak-241-48", dataLeAk241);
		android.util.Log.d("leak-242-48", dataLeAk242);
		android.util.Log.d("leak-243-48", dataLeAk243);
		android.util.Log.d("leak-244-48", dataLeAk244);
		android.util.Log.d("leak-245-48", dataLeAk245);
		android.util.Log.d("leak-246-48", dataLeAk246);
		android.util.Log.d("leak-247-48", dataLeAk247);
		android.util.Log.d("leak-248-48", dataLeAk248);
		android.util.Log.d("leak-252-48", dataLeAk252);
		android.util.Log.d("leak-253-48", dataLeAk253);
		android.util.Log.d("leak-254-48", dataLeAk254);
		final float scale = getResources().getDisplayMetrics().scaledDensity;
        return ta.getDimensionPixelOffset(
                ThemeNotepad.TEXT_SIZE_MEDIUM,
                (int) (23 * scale + 0.5f)
        );
    }

    private float getTextSizeLarge(ThemeAttributes ta) {
        dataLeAk244 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-49", dataLeAk190);
		android.util.Log.d("leak-191-49", dataLeAk191);
		android.util.Log.d("leak-192-49", dataLeAk192);
		android.util.Log.d("leak-193-49", dataLeAk193);
		android.util.Log.d("leak-194-49", dataLeAk194);
		android.util.Log.d("leak-195-49", dataLeAk195);
		android.util.Log.d("leak-197-49", dataLeAk197);
		android.util.Log.d("leak-198-49", dataLeAk198);
		android.util.Log.d("leak-199-49", dataLeAk199);
		android.util.Log.d("leak-203-49", dataLeAk203);
		android.util.Log.d("leak-204-49", dataLeAk204);
		android.util.Log.d("leak-205-49", dataLeAk205);
		android.util.Log.d("leak-206-49", dataLeAk206);
		android.util.Log.d("leak-207-49", dataLeAk207);
		android.util.Log.d("leak-208-49", dataLeAk208);
		android.util.Log.d("leak-209-49", dataLeAk209);
		android.util.Log.d("leak-210-49", dataLeAk210);
		android.util.Log.d("leak-211-49", dataLeAk211);
		android.util.Log.d("leak-212-49", dataLeAk212);
		android.util.Log.d("leak-213-49", dataLeAk213);
		android.util.Log.d("leak-214-49", dataLeAk214);
		android.util.Log.d("leak-215-49", dataLeAk215);
		android.util.Log.d("leak-216-49", dataLeAk216);
		android.util.Log.d("leak-217-49", dataLeAk217);
		android.util.Log.d("leak-218-49", dataLeAk218);
		android.util.Log.d("leak-219-49", dataLeAk219);
		android.util.Log.d("leak-220-49", dataLeAk220);
		android.util.Log.d("leak-221-49", dataLeAk221);
		android.util.Log.d("leak-222-49", dataLeAk222);
		android.util.Log.d("leak-223-49", dataLeAk223);
		android.util.Log.d("leak-224-49", dataLeAk224);
		android.util.Log.d("leak-225-49", dataLeAk225);
		android.util.Log.d("leak-226-49", dataLeAk226);
		android.util.Log.d("leak-227-49", dataLeAk227);
		android.util.Log.d("leak-228-49", dataLeAk228);
		android.util.Log.d("leak-229-49", dataLeAk229);
		android.util.Log.d("leak-230-49", dataLeAk230);
		android.util.Log.d("leak-232-49", dataLeAk232);
		android.util.Log.d("leak-233-49", dataLeAk233);
		android.util.Log.d("leak-234-49", dataLeAk234);
		android.util.Log.d("leak-235-49", dataLeAk235);
		android.util.Log.d("leak-236-49", dataLeAk236);
		android.util.Log.d("leak-237-49", dataLeAk237);
		android.util.Log.d("leak-238-49", dataLeAk238);
		android.util.Log.d("leak-239-49", dataLeAk239);
		android.util.Log.d("leak-240-49", dataLeAk240);
		android.util.Log.d("leak-241-49", dataLeAk241);
		android.util.Log.d("leak-242-49", dataLeAk242);
		android.util.Log.d("leak-243-49", dataLeAk243);
		android.util.Log.d("leak-244-49", dataLeAk244);
		android.util.Log.d("leak-245-49", dataLeAk245);
		android.util.Log.d("leak-246-49", dataLeAk246);
		android.util.Log.d("leak-247-49", dataLeAk247);
		android.util.Log.d("leak-248-49", dataLeAk248);
		android.util.Log.d("leak-252-49", dataLeAk252);
		android.util.Log.d("leak-253-49", dataLeAk253);
		android.util.Log.d("leak-254-49", dataLeAk254);
		float size = ta.getDimensionPixelOffset(ThemeNotepad.TEXT_SIZE_LARGE, -1);
        if (size == -1) {
            // Try to obtain from small:
            size = (28f / 23f) * getTextSizeMedium(ta);
        }
        return size;
    }

    private void applyTheme() {
        dataLeAk245 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-50", dataLeAk190);
		android.util.Log.d("leak-191-50", dataLeAk191);
		android.util.Log.d("leak-192-50", dataLeAk192);
		android.util.Log.d("leak-193-50", dataLeAk193);
		android.util.Log.d("leak-194-50", dataLeAk194);
		android.util.Log.d("leak-195-50", dataLeAk195);
		android.util.Log.d("leak-197-50", dataLeAk197);
		android.util.Log.d("leak-198-50", dataLeAk198);
		android.util.Log.d("leak-199-50", dataLeAk199);
		android.util.Log.d("leak-203-50", dataLeAk203);
		android.util.Log.d("leak-204-50", dataLeAk204);
		android.util.Log.d("leak-205-50", dataLeAk205);
		android.util.Log.d("leak-206-50", dataLeAk206);
		android.util.Log.d("leak-207-50", dataLeAk207);
		android.util.Log.d("leak-208-50", dataLeAk208);
		android.util.Log.d("leak-209-50", dataLeAk209);
		android.util.Log.d("leak-210-50", dataLeAk210);
		android.util.Log.d("leak-211-50", dataLeAk211);
		android.util.Log.d("leak-212-50", dataLeAk212);
		android.util.Log.d("leak-213-50", dataLeAk213);
		android.util.Log.d("leak-214-50", dataLeAk214);
		android.util.Log.d("leak-215-50", dataLeAk215);
		android.util.Log.d("leak-216-50", dataLeAk216);
		android.util.Log.d("leak-217-50", dataLeAk217);
		android.util.Log.d("leak-218-50", dataLeAk218);
		android.util.Log.d("leak-219-50", dataLeAk219);
		android.util.Log.d("leak-220-50", dataLeAk220);
		android.util.Log.d("leak-221-50", dataLeAk221);
		android.util.Log.d("leak-222-50", dataLeAk222);
		android.util.Log.d("leak-223-50", dataLeAk223);
		android.util.Log.d("leak-224-50", dataLeAk224);
		android.util.Log.d("leak-225-50", dataLeAk225);
		android.util.Log.d("leak-226-50", dataLeAk226);
		android.util.Log.d("leak-227-50", dataLeAk227);
		android.util.Log.d("leak-228-50", dataLeAk228);
		android.util.Log.d("leak-229-50", dataLeAk229);
		android.util.Log.d("leak-230-50", dataLeAk230);
		android.util.Log.d("leak-232-50", dataLeAk232);
		android.util.Log.d("leak-233-50", dataLeAk233);
		android.util.Log.d("leak-234-50", dataLeAk234);
		android.util.Log.d("leak-235-50", dataLeAk235);
		android.util.Log.d("leak-236-50", dataLeAk236);
		android.util.Log.d("leak-237-50", dataLeAk237);
		android.util.Log.d("leak-238-50", dataLeAk238);
		android.util.Log.d("leak-239-50", dataLeAk239);
		android.util.Log.d("leak-240-50", dataLeAk240);
		android.util.Log.d("leak-241-50", dataLeAk241);
		android.util.Log.d("leak-242-50", dataLeAk242);
		android.util.Log.d("leak-243-50", dataLeAk243);
		android.util.Log.d("leak-244-50", dataLeAk244);
		android.util.Log.d("leak-245-50", dataLeAk245);
		android.util.Log.d("leak-246-50", dataLeAk246);
		android.util.Log.d("leak-247-50", dataLeAk247);
		android.util.Log.d("leak-248-50", dataLeAk248);
		android.util.Log.d("leak-252-50", dataLeAk252);
		android.util.Log.d("leak-253-50", dataLeAk253);
		android.util.Log.d("leak-254-50", dataLeAk254);
		mText.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextSize);
        mText.setTypeface(mCurrentTypeface);
        mText.setTextColor(mTextColor);

        if (mTextUpperCaseFont) {
            // Turn off autolinkmask, because it is not compatible with
            // transformationmethod.
            mText.setAutoLinkMask(0);

            mText.setTransformationMethod(
                    UpperCaseTransformationMethod
                            .getInstance()
            );
        } else {
            mText.setTransformationMethod(null);

            // Set auto-link on or off, based on the current setting.
            int autoLink = PreferenceActivity.getAutoLinkFromPreference(this);

            mText.setAutoLinkMask(autoLink);
        }

        mText.invalidate();
    }

    private void showNotesListSettings() {
        dataLeAk246 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-51", dataLeAk190);
		android.util.Log.d("leak-191-51", dataLeAk191);
		android.util.Log.d("leak-192-51", dataLeAk192);
		android.util.Log.d("leak-193-51", dataLeAk193);
		android.util.Log.d("leak-194-51", dataLeAk194);
		android.util.Log.d("leak-195-51", dataLeAk195);
		android.util.Log.d("leak-197-51", dataLeAk197);
		android.util.Log.d("leak-198-51", dataLeAk198);
		android.util.Log.d("leak-199-51", dataLeAk199);
		android.util.Log.d("leak-203-51", dataLeAk203);
		android.util.Log.d("leak-204-51", dataLeAk204);
		android.util.Log.d("leak-205-51", dataLeAk205);
		android.util.Log.d("leak-206-51", dataLeAk206);
		android.util.Log.d("leak-207-51", dataLeAk207);
		android.util.Log.d("leak-208-51", dataLeAk208);
		android.util.Log.d("leak-209-51", dataLeAk209);
		android.util.Log.d("leak-210-51", dataLeAk210);
		android.util.Log.d("leak-211-51", dataLeAk211);
		android.util.Log.d("leak-212-51", dataLeAk212);
		android.util.Log.d("leak-213-51", dataLeAk213);
		android.util.Log.d("leak-214-51", dataLeAk214);
		android.util.Log.d("leak-215-51", dataLeAk215);
		android.util.Log.d("leak-216-51", dataLeAk216);
		android.util.Log.d("leak-217-51", dataLeAk217);
		android.util.Log.d("leak-218-51", dataLeAk218);
		android.util.Log.d("leak-219-51", dataLeAk219);
		android.util.Log.d("leak-220-51", dataLeAk220);
		android.util.Log.d("leak-221-51", dataLeAk221);
		android.util.Log.d("leak-222-51", dataLeAk222);
		android.util.Log.d("leak-223-51", dataLeAk223);
		android.util.Log.d("leak-224-51", dataLeAk224);
		android.util.Log.d("leak-225-51", dataLeAk225);
		android.util.Log.d("leak-226-51", dataLeAk226);
		android.util.Log.d("leak-227-51", dataLeAk227);
		android.util.Log.d("leak-228-51", dataLeAk228);
		android.util.Log.d("leak-229-51", dataLeAk229);
		android.util.Log.d("leak-230-51", dataLeAk230);
		android.util.Log.d("leak-232-51", dataLeAk232);
		android.util.Log.d("leak-233-51", dataLeAk233);
		android.util.Log.d("leak-234-51", dataLeAk234);
		android.util.Log.d("leak-235-51", dataLeAk235);
		android.util.Log.d("leak-236-51", dataLeAk236);
		android.util.Log.d("leak-237-51", dataLeAk237);
		android.util.Log.d("leak-238-51", dataLeAk238);
		android.util.Log.d("leak-239-51", dataLeAk239);
		android.util.Log.d("leak-240-51", dataLeAk240);
		android.util.Log.d("leak-241-51", dataLeAk241);
		android.util.Log.d("leak-242-51", dataLeAk242);
		android.util.Log.d("leak-243-51", dataLeAk243);
		android.util.Log.d("leak-244-51", dataLeAk244);
		android.util.Log.d("leak-245-51", dataLeAk245);
		android.util.Log.d("leak-246-51", dataLeAk246);
		android.util.Log.d("leak-247-51", dataLeAk247);
		android.util.Log.d("leak-248-51", dataLeAk248);
		android.util.Log.d("leak-252-51", dataLeAk252);
		android.util.Log.d("leak-253-51", dataLeAk253);
		android.util.Log.d("leak-254-51", dataLeAk254);
		startActivity(new Intent(this, PreferenceActivity.class));
    }

    private void showWordCount() {
        dataLeAk247 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-52", dataLeAk190);
		android.util.Log.d("leak-191-52", dataLeAk191);
		android.util.Log.d("leak-192-52", dataLeAk192);
		android.util.Log.d("leak-193-52", dataLeAk193);
		android.util.Log.d("leak-194-52", dataLeAk194);
		android.util.Log.d("leak-195-52", dataLeAk195);
		android.util.Log.d("leak-197-52", dataLeAk197);
		android.util.Log.d("leak-198-52", dataLeAk198);
		android.util.Log.d("leak-199-52", dataLeAk199);
		android.util.Log.d("leak-203-52", dataLeAk203);
		android.util.Log.d("leak-204-52", dataLeAk204);
		android.util.Log.d("leak-205-52", dataLeAk205);
		android.util.Log.d("leak-206-52", dataLeAk206);
		android.util.Log.d("leak-207-52", dataLeAk207);
		android.util.Log.d("leak-208-52", dataLeAk208);
		android.util.Log.d("leak-209-52", dataLeAk209);
		android.util.Log.d("leak-210-52", dataLeAk210);
		android.util.Log.d("leak-211-52", dataLeAk211);
		android.util.Log.d("leak-212-52", dataLeAk212);
		android.util.Log.d("leak-213-52", dataLeAk213);
		android.util.Log.d("leak-214-52", dataLeAk214);
		android.util.Log.d("leak-215-52", dataLeAk215);
		android.util.Log.d("leak-216-52", dataLeAk216);
		android.util.Log.d("leak-217-52", dataLeAk217);
		android.util.Log.d("leak-218-52", dataLeAk218);
		android.util.Log.d("leak-219-52", dataLeAk219);
		android.util.Log.d("leak-220-52", dataLeAk220);
		android.util.Log.d("leak-221-52", dataLeAk221);
		android.util.Log.d("leak-222-52", dataLeAk222);
		android.util.Log.d("leak-223-52", dataLeAk223);
		android.util.Log.d("leak-224-52", dataLeAk224);
		android.util.Log.d("leak-225-52", dataLeAk225);
		android.util.Log.d("leak-226-52", dataLeAk226);
		android.util.Log.d("leak-227-52", dataLeAk227);
		android.util.Log.d("leak-228-52", dataLeAk228);
		android.util.Log.d("leak-229-52", dataLeAk229);
		android.util.Log.d("leak-230-52", dataLeAk230);
		android.util.Log.d("leak-232-52", dataLeAk232);
		android.util.Log.d("leak-233-52", dataLeAk233);
		android.util.Log.d("leak-234-52", dataLeAk234);
		android.util.Log.d("leak-235-52", dataLeAk235);
		android.util.Log.d("leak-236-52", dataLeAk236);
		android.util.Log.d("leak-237-52", dataLeAk237);
		android.util.Log.d("leak-238-52", dataLeAk238);
		android.util.Log.d("leak-239-52", dataLeAk239);
		android.util.Log.d("leak-240-52", dataLeAk240);
		android.util.Log.d("leak-241-52", dataLeAk241);
		android.util.Log.d("leak-242-52", dataLeAk242);
		android.util.Log.d("leak-243-52", dataLeAk243);
		android.util.Log.d("leak-244-52", dataLeAk244);
		android.util.Log.d("leak-245-52", dataLeAk245);
		android.util.Log.d("leak-246-52", dataLeAk246);
		android.util.Log.d("leak-247-52", dataLeAk247);
		android.util.Log.d("leak-248-52", dataLeAk248);
		android.util.Log.d("leak-252-52", dataLeAk252);
		android.util.Log.d("leak-253-52", dataLeAk253);
		android.util.Log.d("leak-254-52", dataLeAk254);
		String text = mText.getText().toString();
        int number_of_words = text.split("\\s+").length;
        if (TextUtils.isEmpty(text)) {
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
        dataLeAk248 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-53", dataLeAk190);
		android.util.Log.d("leak-191-53", dataLeAk191);
		android.util.Log.d("leak-192-53", dataLeAk192);
		android.util.Log.d("leak-193-53", dataLeAk193);
		android.util.Log.d("leak-194-53", dataLeAk194);
		android.util.Log.d("leak-195-53", dataLeAk195);
		android.util.Log.d("leak-197-53", dataLeAk197);
		android.util.Log.d("leak-198-53", dataLeAk198);
		android.util.Log.d("leak-199-53", dataLeAk199);
		android.util.Log.d("leak-203-53", dataLeAk203);
		android.util.Log.d("leak-204-53", dataLeAk204);
		android.util.Log.d("leak-205-53", dataLeAk205);
		android.util.Log.d("leak-206-53", dataLeAk206);
		android.util.Log.d("leak-207-53", dataLeAk207);
		android.util.Log.d("leak-208-53", dataLeAk208);
		android.util.Log.d("leak-209-53", dataLeAk209);
		android.util.Log.d("leak-210-53", dataLeAk210);
		android.util.Log.d("leak-211-53", dataLeAk211);
		android.util.Log.d("leak-212-53", dataLeAk212);
		android.util.Log.d("leak-213-53", dataLeAk213);
		android.util.Log.d("leak-214-53", dataLeAk214);
		android.util.Log.d("leak-215-53", dataLeAk215);
		android.util.Log.d("leak-216-53", dataLeAk216);
		android.util.Log.d("leak-217-53", dataLeAk217);
		android.util.Log.d("leak-218-53", dataLeAk218);
		android.util.Log.d("leak-219-53", dataLeAk219);
		android.util.Log.d("leak-220-53", dataLeAk220);
		android.util.Log.d("leak-221-53", dataLeAk221);
		android.util.Log.d("leak-222-53", dataLeAk222);
		android.util.Log.d("leak-223-53", dataLeAk223);
		android.util.Log.d("leak-224-53", dataLeAk224);
		android.util.Log.d("leak-225-53", dataLeAk225);
		android.util.Log.d("leak-226-53", dataLeAk226);
		android.util.Log.d("leak-227-53", dataLeAk227);
		android.util.Log.d("leak-228-53", dataLeAk228);
		android.util.Log.d("leak-229-53", dataLeAk229);
		android.util.Log.d("leak-230-53", dataLeAk230);
		android.util.Log.d("leak-232-53", dataLeAk232);
		android.util.Log.d("leak-233-53", dataLeAk233);
		android.util.Log.d("leak-234-53", dataLeAk234);
		android.util.Log.d("leak-235-53", dataLeAk235);
		android.util.Log.d("leak-236-53", dataLeAk236);
		android.util.Log.d("leak-237-53", dataLeAk237);
		android.util.Log.d("leak-238-53", dataLeAk238);
		android.util.Log.d("leak-239-53", dataLeAk239);
		android.util.Log.d("leak-240-53", dataLeAk240);
		android.util.Log.d("leak-241-53", dataLeAk241);
		android.util.Log.d("leak-242-53", dataLeAk242);
		android.util.Log.d("leak-243-53", dataLeAk243);
		android.util.Log.d("leak-244-53", dataLeAk244);
		android.util.Log.d("leak-245-53", dataLeAk245);
		android.util.Log.d("leak-246-53", dataLeAk246);
		android.util.Log.d("leak-247-53", dataLeAk247);
		android.util.Log.d("leak-248-53", dataLeAk248);
		android.util.Log.d("leak-252-53", dataLeAk252);
		android.util.Log.d("leak-253-53", dataLeAk253);
		android.util.Log.d("leak-254-53", dataLeAk254);
		return new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(R.string.warning_unsaved_changes_title)
                .setMessage(R.string.warning_unsaved_changes_message)
                .setPositiveButton(
                        R.string.button_save,
                        new DialogInterface.OnClickListener() {
                            String dataLeAk249 = "";

							public void onClick(DialogInterface dialog,
                                                int whichButton) {
                                dataLeAk249 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-270-0", dataLeAk270);
								android.util.Log.d("leak-249-0", dataLeAk249);
								saveNoteWithPermissionCheck();
                                finish();
                            }
                        }
                )
                .setNeutralButton(
                        R.string.button_dont_save,
                        new DialogInterface.OnClickListener() {
                            String dataLeAk250 = "";

							public void onClick(DialogInterface dialog,
                                                int whichButton) {
                                dataLeAk250 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-271-0", dataLeAk271);
								android.util.Log.d("leak-250-0", dataLeAk250);
								// Don't save
                                finish();
                            }
                        }
                )
                .setNegativeButton(
                        android.R.string.cancel,
                        new DialogInterface.OnClickListener() {
                            String dataLeAk251 = "";

							public void onClick(DialogInterface dialog,
                                                int whichButton) {
													dataLeAk251 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
                                // Cancel
													android.util.Log.d("leak-272-0", dataLeAk272);
													android.util.Log.d("leak-251-0", dataLeAk251);
                            }
                        }
                ).create();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        dataLeAk252 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-54", dataLeAk190);
		android.util.Log.d("leak-191-54", dataLeAk191);
		android.util.Log.d("leak-192-54", dataLeAk192);
		android.util.Log.d("leak-193-54", dataLeAk193);
		android.util.Log.d("leak-194-54", dataLeAk194);
		android.util.Log.d("leak-195-54", dataLeAk195);
		android.util.Log.d("leak-197-54", dataLeAk197);
		android.util.Log.d("leak-198-54", dataLeAk198);
		android.util.Log.d("leak-199-54", dataLeAk199);
		android.util.Log.d("leak-203-54", dataLeAk203);
		android.util.Log.d("leak-204-54", dataLeAk204);
		android.util.Log.d("leak-205-54", dataLeAk205);
		android.util.Log.d("leak-206-54", dataLeAk206);
		android.util.Log.d("leak-207-54", dataLeAk207);
		android.util.Log.d("leak-208-54", dataLeAk208);
		android.util.Log.d("leak-209-54", dataLeAk209);
		android.util.Log.d("leak-210-54", dataLeAk210);
		android.util.Log.d("leak-211-54", dataLeAk211);
		android.util.Log.d("leak-212-54", dataLeAk212);
		android.util.Log.d("leak-213-54", dataLeAk213);
		android.util.Log.d("leak-214-54", dataLeAk214);
		android.util.Log.d("leak-215-54", dataLeAk215);
		android.util.Log.d("leak-216-54", dataLeAk216);
		android.util.Log.d("leak-217-54", dataLeAk217);
		android.util.Log.d("leak-218-54", dataLeAk218);
		android.util.Log.d("leak-219-54", dataLeAk219);
		android.util.Log.d("leak-220-54", dataLeAk220);
		android.util.Log.d("leak-221-54", dataLeAk221);
		android.util.Log.d("leak-222-54", dataLeAk222);
		android.util.Log.d("leak-223-54", dataLeAk223);
		android.util.Log.d("leak-224-54", dataLeAk224);
		android.util.Log.d("leak-225-54", dataLeAk225);
		android.util.Log.d("leak-226-54", dataLeAk226);
		android.util.Log.d("leak-227-54", dataLeAk227);
		android.util.Log.d("leak-228-54", dataLeAk228);
		android.util.Log.d("leak-229-54", dataLeAk229);
		android.util.Log.d("leak-230-54", dataLeAk230);
		android.util.Log.d("leak-232-54", dataLeAk232);
		android.util.Log.d("leak-233-54", dataLeAk233);
		android.util.Log.d("leak-234-54", dataLeAk234);
		android.util.Log.d("leak-235-54", dataLeAk235);
		android.util.Log.d("leak-236-54", dataLeAk236);
		android.util.Log.d("leak-237-54", dataLeAk237);
		android.util.Log.d("leak-238-54", dataLeAk238);
		android.util.Log.d("leak-239-54", dataLeAk239);
		android.util.Log.d("leak-240-54", dataLeAk240);
		android.util.Log.d("leak-241-54", dataLeAk241);
		android.util.Log.d("leak-242-54", dataLeAk242);
		android.util.Log.d("leak-243-54", dataLeAk243);
		android.util.Log.d("leak-244-54", dataLeAk244);
		android.util.Log.d("leak-245-54", dataLeAk245);
		android.util.Log.d("leak-246-54", dataLeAk246);
		android.util.Log.d("leak-247-54", dataLeAk247);
		android.util.Log.d("leak-248-54", dataLeAk248);
		android.util.Log.d("leak-252-54", dataLeAk252);
		android.util.Log.d("leak-253-54", dataLeAk253);
		android.util.Log.d("leak-254-54", dataLeAk254);
		if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mState == STATE_EDIT_NOTE_FROM_SDCARD) {
                mFileContent = mText.getText().toString();
                if (!mFileContent.equals(mOriginalContent)) {
                    // Show a dialog
                    showDialog(DIALOG_UNSAVED_CHANGES);
                    return true;
                }
            }
        }

        return super.onKeyDown(keyCode, event);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        dataLeAk253 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-55", dataLeAk190);
		android.util.Log.d("leak-191-55", dataLeAk191);
		android.util.Log.d("leak-192-55", dataLeAk192);
		android.util.Log.d("leak-193-55", dataLeAk193);
		android.util.Log.d("leak-194-55", dataLeAk194);
		android.util.Log.d("leak-195-55", dataLeAk195);
		android.util.Log.d("leak-197-55", dataLeAk197);
		android.util.Log.d("leak-198-55", dataLeAk198);
		android.util.Log.d("leak-199-55", dataLeAk199);
		android.util.Log.d("leak-203-55", dataLeAk203);
		android.util.Log.d("leak-204-55", dataLeAk204);
		android.util.Log.d("leak-205-55", dataLeAk205);
		android.util.Log.d("leak-206-55", dataLeAk206);
		android.util.Log.d("leak-207-55", dataLeAk207);
		android.util.Log.d("leak-208-55", dataLeAk208);
		android.util.Log.d("leak-209-55", dataLeAk209);
		android.util.Log.d("leak-210-55", dataLeAk210);
		android.util.Log.d("leak-211-55", dataLeAk211);
		android.util.Log.d("leak-212-55", dataLeAk212);
		android.util.Log.d("leak-213-55", dataLeAk213);
		android.util.Log.d("leak-214-55", dataLeAk214);
		android.util.Log.d("leak-215-55", dataLeAk215);
		android.util.Log.d("leak-216-55", dataLeAk216);
		android.util.Log.d("leak-217-55", dataLeAk217);
		android.util.Log.d("leak-218-55", dataLeAk218);
		android.util.Log.d("leak-219-55", dataLeAk219);
		android.util.Log.d("leak-220-55", dataLeAk220);
		android.util.Log.d("leak-221-55", dataLeAk221);
		android.util.Log.d("leak-222-55", dataLeAk222);
		android.util.Log.d("leak-223-55", dataLeAk223);
		android.util.Log.d("leak-224-55", dataLeAk224);
		android.util.Log.d("leak-225-55", dataLeAk225);
		android.util.Log.d("leak-226-55", dataLeAk226);
		android.util.Log.d("leak-227-55", dataLeAk227);
		android.util.Log.d("leak-228-55", dataLeAk228);
		android.util.Log.d("leak-229-55", dataLeAk229);
		android.util.Log.d("leak-230-55", dataLeAk230);
		android.util.Log.d("leak-232-55", dataLeAk232);
		android.util.Log.d("leak-233-55", dataLeAk233);
		android.util.Log.d("leak-234-55", dataLeAk234);
		android.util.Log.d("leak-235-55", dataLeAk235);
		android.util.Log.d("leak-236-55", dataLeAk236);
		android.util.Log.d("leak-237-55", dataLeAk237);
		android.util.Log.d("leak-238-55", dataLeAk238);
		android.util.Log.d("leak-239-55", dataLeAk239);
		android.util.Log.d("leak-240-55", dataLeAk240);
		android.util.Log.d("leak-241-55", dataLeAk241);
		android.util.Log.d("leak-242-55", dataLeAk242);
		android.util.Log.d("leak-243-55", dataLeAk243);
		android.util.Log.d("leak-244-55", dataLeAk244);
		android.util.Log.d("leak-245-55", dataLeAk245);
		android.util.Log.d("leak-246-55", dataLeAk246);
		android.util.Log.d("leak-247-55", dataLeAk247);
		android.util.Log.d("leak-248-55", dataLeAk248);
		android.util.Log.d("leak-252-55", dataLeAk252);
		android.util.Log.d("leak-253-55", dataLeAk253);
		android.util.Log.d("leak-254-55", dataLeAk254);
		if (DEBUG) {
            Log.d(
                    TAG, "onActivityResult: Received requestCode " + requestCode
                            + ", resultCode " + resultCode
            );
        }
        switch (requestCode) {
            case REQUEST_CODE_DECRYPT:
                if (resultCode == RESULT_OK && data != null) {
                    String decryptedText = data
                            .getStringExtra(CryptoIntents.EXTRA_TEXT);
                    long id = data.getLongExtra(PrivateNotePadIntents.EXTRA_ID, -1);

                    // TODO: Check that id corresponds to current intent.

                    if (id == -1) {
                        Log.e(TAG, "Wrong extra id");
                        Toast.makeText(
                                this, "Decrypted information incomplete",
                                Toast.LENGTH_SHORT
                        ).show();

                        finish();
                        return;
                    }

                    if (DEBUG) {
                        Log.d(TAG, "decrypted text received: " + decryptedText);
                    }
                    mDecryptedText = decryptedText;
                    mOriginalContent = decryptedText;

                } else {
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
                    // Set the new file name
                    mUri = data.getData();
                    if (DEBUG) {
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
        dataLeAk254 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-190-56", dataLeAk190);
		android.util.Log.d("leak-191-56", dataLeAk191);
		android.util.Log.d("leak-192-56", dataLeAk192);
		android.util.Log.d("leak-193-56", dataLeAk193);
		android.util.Log.d("leak-194-56", dataLeAk194);
		android.util.Log.d("leak-195-56", dataLeAk195);
		android.util.Log.d("leak-197-56", dataLeAk197);
		android.util.Log.d("leak-198-56", dataLeAk198);
		android.util.Log.d("leak-199-56", dataLeAk199);
		android.util.Log.d("leak-203-56", dataLeAk203);
		android.util.Log.d("leak-204-56", dataLeAk204);
		android.util.Log.d("leak-205-56", dataLeAk205);
		android.util.Log.d("leak-206-56", dataLeAk206);
		android.util.Log.d("leak-207-56", dataLeAk207);
		android.util.Log.d("leak-208-56", dataLeAk208);
		android.util.Log.d("leak-209-56", dataLeAk209);
		android.util.Log.d("leak-210-56", dataLeAk210);
		android.util.Log.d("leak-211-56", dataLeAk211);
		android.util.Log.d("leak-212-56", dataLeAk212);
		android.util.Log.d("leak-213-56", dataLeAk213);
		android.util.Log.d("leak-214-56", dataLeAk214);
		android.util.Log.d("leak-215-56", dataLeAk215);
		android.util.Log.d("leak-216-56", dataLeAk216);
		android.util.Log.d("leak-217-56", dataLeAk217);
		android.util.Log.d("leak-218-56", dataLeAk218);
		android.util.Log.d("leak-219-56", dataLeAk219);
		android.util.Log.d("leak-220-56", dataLeAk220);
		android.util.Log.d("leak-221-56", dataLeAk221);
		android.util.Log.d("leak-222-56", dataLeAk222);
		android.util.Log.d("leak-223-56", dataLeAk223);
		android.util.Log.d("leak-224-56", dataLeAk224);
		android.util.Log.d("leak-225-56", dataLeAk225);
		android.util.Log.d("leak-226-56", dataLeAk226);
		android.util.Log.d("leak-227-56", dataLeAk227);
		android.util.Log.d("leak-228-56", dataLeAk228);
		android.util.Log.d("leak-229-56", dataLeAk229);
		android.util.Log.d("leak-230-56", dataLeAk230);
		android.util.Log.d("leak-232-56", dataLeAk232);
		android.util.Log.d("leak-233-56", dataLeAk233);
		android.util.Log.d("leak-234-56", dataLeAk234);
		android.util.Log.d("leak-235-56", dataLeAk235);
		android.util.Log.d("leak-236-56", dataLeAk236);
		android.util.Log.d("leak-237-56", dataLeAk237);
		android.util.Log.d("leak-238-56", dataLeAk238);
		android.util.Log.d("leak-239-56", dataLeAk239);
		android.util.Log.d("leak-240-56", dataLeAk240);
		android.util.Log.d("leak-241-56", dataLeAk241);
		android.util.Log.d("leak-242-56", dataLeAk242);
		android.util.Log.d("leak-243-56", dataLeAk243);
		android.util.Log.d("leak-244-56", dataLeAk244);
		android.util.Log.d("leak-245-56", dataLeAk245);
		android.util.Log.d("leak-246-56", dataLeAk246);
		android.util.Log.d("leak-247-56", dataLeAk247);
		android.util.Log.d("leak-248-56", dataLeAk248);
		android.util.Log.d("leak-252-56", dataLeAk252);
		android.util.Log.d("leak-253-56", dataLeAk253);
		android.util.Log.d("leak-254-56", dataLeAk254);
		switch (requestCode) {
            case REQUEST_CODE_PERMISSION_READ_EXTERNAL_STORAGE: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mFileContent = readFile(FileUriUtils.getFile(mUri));
                    mOriginalContent = mFileContent;
                } else {
                    mFileContent = null;
                }
                getNoteFromFile();
                return;
            }

            case REQUEST_CODE_PERMISSION_WRITE_EXTERNAL_STORAGE: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
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
        String dataLeAk256 = "";

		String dataLeAk255 = "";

		private Rect mRect;
        private Paint mPaint;

        // we need this constructor for LayoutInflater
        public LinedEditText(Context context, AttributeSet attrs) {
            super(context, attrs);
			dataLeAk255 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-255-0", dataLeAk255);
			android.util.Log.d("leak-256-0", dataLeAk256);

            mRect = new Rect();
            mPaint = new Paint();
            mPaint.setStyle(Paint.Style.STROKE);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            boolean fullWidth = (mLinesMode & 1) == 1;
			dataLeAk256 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-255-1", dataLeAk255);
			android.util.Log.d("leak-256-1", dataLeAk256);
            boolean textlines = (mLinesMode & 2) == 2;
            boolean pagelines = (mLinesMode & 4) == 4;
            if (textlines || pagelines) {
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
                    baseline = getLineBounds(i, r);
                    left = r.left;
                    right = r.right;
                    if (fullWidth) {
                        left = getLeft();
                        right = getRight();
                    }
                    canvas.drawLine(
                            left, baseline + 1, right, baseline + 1,
                            paint
                    );
                }
                if (pagelines) {
                    // Fill the rest of the page with lines
                    for (int i = count; i < page_size; i++) {
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
