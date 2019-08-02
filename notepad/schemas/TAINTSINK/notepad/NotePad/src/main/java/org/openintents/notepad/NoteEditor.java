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
    String dataLeAk194 = "194";

	String dataLeAk193 = "193";

	String dataLeAk192 = "192";

	String dataLeAk191 = "191";

	String dataLeAk189 = "189";

	String dataLeAk187 = "187";

	String dataLeAk185 = "185";

	String dataLeAk184 = "184";

	String dataLeAk183 = "183";

	String dataLeAk182 = "182";

	String dataLeAk181 = "181";

	String dataLeAk180 = "180";

	String dataLeAk179 = "179";

	String dataLeAk178 = "178";

	String dataLeAk177 = "177";

	String dataLeAk175 = "175";

	String dataLeAk174 = "174";

	String dataLeAk173 = "173";

	String dataLeAk172 = "172";

	String dataLeAk171 = "171";

	String dataLeAk170 = "170";

	String dataLeAk169 = "169";

	String dataLeAk168 = "168";

	String dataLeAk166 = "166";

	String dataLeAk164 = "164";

	String dataLeAk162 = "162";

	String dataLeAk160 = "160";

	String dataLeAk159 = "159";

	String dataLeAk158 = "158";

	String dataLeAk157 = "157";

	String dataLeAk155 = "155";

	String dataLeAk153 = "153";

	String dataLeAk151 = "151";

	String dataLeAk149 = "149";

	String dataLeAk147 = "147";

	String dataLeAk145 = "145";

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
        String dataLeAk148 = "148";

		String dataLeAk146 = "146";

		String dataLeAk144 = "144";

		public void afterTextChanged(Editable s) {
            dataLeAk145 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk144 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			// if (DEBUG) Log.d(TAG, "after");
            mFileContent = s.toString();
            updateTitleSdCard();
        }

        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
										dataLeAk147 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										dataLeAk146 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
            // if (DEBUG) Log.d(TAG, "before");
        }

        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
									dataLeAk149 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									dataLeAk148 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
            // if (DEBUG) Log.d(TAG, "on");
        }

    };
    private TextWatcher mTextWatcherCharCount = new TextWatcher() {
        String dataLeAk154 = "154";

		String dataLeAk152 = "152";

		String dataLeAk150 = "150";

		public void afterTextChanged(Editable s) {
            dataLeAk151 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk150 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			updateCharCount();
        }

        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
										dataLeAk153 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										dataLeAk152 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        }

        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
									dataLeAk155 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									dataLeAk154 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        }
    };
    private BroadcastReceiver mUpdateReceiver = new BroadcastReceiver() {

        String dataLeAk156 = "156";

		@Override
        public void onReceive(Context context, Intent intent) {
            dataLeAk157 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk156 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
		dataLeAk158 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-155", dataLeAk145);
		android.util.Log.d("leak-147-155", dataLeAk147);
		android.util.Log.d("leak-149-155", dataLeAk149);
		android.util.Log.d("leak-151-155", dataLeAk151);
		android.util.Log.d("leak-153-155", dataLeAk153);
		android.util.Log.d("leak-155-155", dataLeAk155);
		android.util.Log.d("leak-157-155", dataLeAk157);
		android.util.Log.d("leak-158-155", dataLeAk158);
		android.util.Log.d("leak-159-155", dataLeAk159);
		android.util.Log.d("leak-160-155", dataLeAk160);
		android.util.Log.d("leak-162-155", dataLeAk162);
		android.util.Log.d("leak-164-155", dataLeAk164);
		android.util.Log.d("leak-166-155", dataLeAk166);
		android.util.Log.d("leak-168-155", dataLeAk168);
		android.util.Log.d("leak-169-155", dataLeAk169);
		android.util.Log.d("leak-170-155", dataLeAk170);
		android.util.Log.d("leak-171-155", dataLeAk171);
		android.util.Log.d("leak-172-155", dataLeAk172);
		android.util.Log.d("leak-173-155", dataLeAk173);
		android.util.Log.d("leak-174-155", dataLeAk174);
		android.util.Log.d("leak-175-155", dataLeAk175);
		android.util.Log.d("leak-177-155", dataLeAk177);
		android.util.Log.d("leak-178-155", dataLeAk178);
		android.util.Log.d("leak-179-155", dataLeAk179);
		android.util.Log.d("leak-180-155", dataLeAk180);
		android.util.Log.d("leak-181-155", dataLeAk181);
		android.util.Log.d("leak-182-155", dataLeAk182);
		android.util.Log.d("leak-183-155", dataLeAk183);
		android.util.Log.d("leak-184-155", dataLeAk184);
		android.util.Log.d("leak-185-155", dataLeAk185);
		android.util.Log.d("leak-187-155", dataLeAk187);
		android.util.Log.d("leak-189-155", dataLeAk189);
		android.util.Log.d("leak-191-155", dataLeAk191);
		android.util.Log.d("leak-192-155", dataLeAk192);
		android.util.Log.d("leak-193-155", dataLeAk193);
		android.util.Log.d("leak-194-155", dataLeAk194);

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
        Intent intent = new Intent(
                Intent.ACTION_INSERT, Notes.CONTENT_URI,
                getApplicationContext(), NoteEditor.class
        );
		android.util.Log.d("leak-145-156", dataLeAk145);
		android.util.Log.d("leak-147-156", dataLeAk147);
		android.util.Log.d("leak-149-156", dataLeAk149);
		android.util.Log.d("leak-151-156", dataLeAk151);
		android.util.Log.d("leak-153-156", dataLeAk153);
		android.util.Log.d("leak-155-156", dataLeAk155);
		android.util.Log.d("leak-157-156", dataLeAk157);
		android.util.Log.d("leak-158-156", dataLeAk158);
		android.util.Log.d("leak-159-156", dataLeAk159);
		android.util.Log.d("leak-160-156", dataLeAk160);
		android.util.Log.d("leak-162-156", dataLeAk162);
		android.util.Log.d("leak-164-156", dataLeAk164);
		android.util.Log.d("leak-166-156", dataLeAk166);
		android.util.Log.d("leak-168-156", dataLeAk168);
		android.util.Log.d("leak-169-156", dataLeAk169);
		android.util.Log.d("leak-170-156", dataLeAk170);
		android.util.Log.d("leak-171-156", dataLeAk171);
		android.util.Log.d("leak-172-156", dataLeAk172);
		android.util.Log.d("leak-173-156", dataLeAk173);
		android.util.Log.d("leak-174-156", dataLeAk174);
		android.util.Log.d("leak-175-156", dataLeAk175);
		android.util.Log.d("leak-177-156", dataLeAk177);
		android.util.Log.d("leak-178-156", dataLeAk178);
		android.util.Log.d("leak-179-156", dataLeAk179);
		android.util.Log.d("leak-180-156", dataLeAk180);
		android.util.Log.d("leak-181-156", dataLeAk181);
		android.util.Log.d("leak-182-156", dataLeAk182);
		android.util.Log.d("leak-183-156", dataLeAk183);
		android.util.Log.d("leak-184-156", dataLeAk184);
		android.util.Log.d("leak-185-156", dataLeAk185);
		android.util.Log.d("leak-187-156", dataLeAk187);
		android.util.Log.d("leak-189-156", dataLeAk189);
		android.util.Log.d("leak-191-156", dataLeAk191);
		android.util.Log.d("leak-192-156", dataLeAk192);
		android.util.Log.d("leak-193-156", dataLeAk193);
		android.util.Log.d("leak-194-156", dataLeAk194);

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
        String theme = null;
		android.util.Log.d("leak-145-157", dataLeAk145);
		android.util.Log.d("leak-147-157", dataLeAk147);
		android.util.Log.d("leak-149-157", dataLeAk149);
		android.util.Log.d("leak-151-157", dataLeAk151);
		android.util.Log.d("leak-153-157", dataLeAk153);
		android.util.Log.d("leak-155-157", dataLeAk155);
		android.util.Log.d("leak-157-157", dataLeAk157);
		android.util.Log.d("leak-158-157", dataLeAk158);
		android.util.Log.d("leak-159-157", dataLeAk159);
		android.util.Log.d("leak-160-157", dataLeAk160);
		android.util.Log.d("leak-162-157", dataLeAk162);
		android.util.Log.d("leak-164-157", dataLeAk164);
		android.util.Log.d("leak-166-157", dataLeAk166);
		android.util.Log.d("leak-168-157", dataLeAk168);
		android.util.Log.d("leak-169-157", dataLeAk169);
		android.util.Log.d("leak-170-157", dataLeAk170);
		android.util.Log.d("leak-171-157", dataLeAk171);
		android.util.Log.d("leak-172-157", dataLeAk172);
		android.util.Log.d("leak-173-157", dataLeAk173);
		android.util.Log.d("leak-174-157", dataLeAk174);
		android.util.Log.d("leak-175-157", dataLeAk175);
		android.util.Log.d("leak-177-157", dataLeAk177);
		android.util.Log.d("leak-178-157", dataLeAk178);
		android.util.Log.d("leak-179-157", dataLeAk179);
		android.util.Log.d("leak-180-157", dataLeAk180);
		android.util.Log.d("leak-181-157", dataLeAk181);
		android.util.Log.d("leak-182-157", dataLeAk182);
		android.util.Log.d("leak-183-157", dataLeAk183);
		android.util.Log.d("leak-184-157", dataLeAk184);
		android.util.Log.d("leak-185-157", dataLeAk185);
		android.util.Log.d("leak-187-157", dataLeAk187);
		android.util.Log.d("leak-189-157", dataLeAk189);
		android.util.Log.d("leak-191-157", dataLeAk191);
		android.util.Log.d("leak-192-157", dataLeAk192);
		android.util.Log.d("leak-193-157", dataLeAk193);
		android.util.Log.d("leak-194-157", dataLeAk194);
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

        dataLeAk159 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-158", dataLeAk145);
		android.util.Log.d("leak-147-158", dataLeAk147);
		android.util.Log.d("leak-149-158", dataLeAk149);
		android.util.Log.d("leak-151-158", dataLeAk151);
		android.util.Log.d("leak-153-158", dataLeAk153);
		android.util.Log.d("leak-155-158", dataLeAk155);
		android.util.Log.d("leak-157-158", dataLeAk157);
		android.util.Log.d("leak-158-158", dataLeAk158);
		android.util.Log.d("leak-159-158", dataLeAk159);
		android.util.Log.d("leak-160-158", dataLeAk160);
		android.util.Log.d("leak-162-158", dataLeAk162);
		android.util.Log.d("leak-164-158", dataLeAk164);
		android.util.Log.d("leak-166-158", dataLeAk166);
		android.util.Log.d("leak-168-158", dataLeAk168);
		android.util.Log.d("leak-169-158", dataLeAk169);
		android.util.Log.d("leak-170-158", dataLeAk170);
		android.util.Log.d("leak-171-158", dataLeAk171);
		android.util.Log.d("leak-172-158", dataLeAk172);
		android.util.Log.d("leak-173-158", dataLeAk173);
		android.util.Log.d("leak-174-158", dataLeAk174);
		android.util.Log.d("leak-175-158", dataLeAk175);
		android.util.Log.d("leak-177-158", dataLeAk177);
		android.util.Log.d("leak-178-158", dataLeAk178);
		android.util.Log.d("leak-179-158", dataLeAk179);
		android.util.Log.d("leak-180-158", dataLeAk180);
		android.util.Log.d("leak-181-158", dataLeAk181);
		android.util.Log.d("leak-182-158", dataLeAk182);
		android.util.Log.d("leak-183-158", dataLeAk183);
		android.util.Log.d("leak-184-158", dataLeAk184);
		android.util.Log.d("leak-185-158", dataLeAk185);
		android.util.Log.d("leak-187-158", dataLeAk187);
		android.util.Log.d("leak-189-158", dataLeAk189);
		android.util.Log.d("leak-191-158", dataLeAk191);
		android.util.Log.d("leak-192-158", dataLeAk192);
		android.util.Log.d("leak-193-158", dataLeAk193);
		android.util.Log.d("leak-194-158", dataLeAk194);
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
        StringBuilder sb = new StringBuilder();
		android.util.Log.d("leak-145-159", dataLeAk145);
		android.util.Log.d("leak-147-159", dataLeAk147);
		android.util.Log.d("leak-149-159", dataLeAk149);
		android.util.Log.d("leak-151-159", dataLeAk151);
		android.util.Log.d("leak-153-159", dataLeAk153);
		android.util.Log.d("leak-155-159", dataLeAk155);
		android.util.Log.d("leak-157-159", dataLeAk157);
		android.util.Log.d("leak-158-159", dataLeAk158);
		android.util.Log.d("leak-159-159", dataLeAk159);
		android.util.Log.d("leak-160-159", dataLeAk160);
		android.util.Log.d("leak-162-159", dataLeAk162);
		android.util.Log.d("leak-164-159", dataLeAk164);
		android.util.Log.d("leak-166-159", dataLeAk166);
		android.util.Log.d("leak-168-159", dataLeAk168);
		android.util.Log.d("leak-169-159", dataLeAk169);
		android.util.Log.d("leak-170-159", dataLeAk170);
		android.util.Log.d("leak-171-159", dataLeAk171);
		android.util.Log.d("leak-172-159", dataLeAk172);
		android.util.Log.d("leak-173-159", dataLeAk173);
		android.util.Log.d("leak-174-159", dataLeAk174);
		android.util.Log.d("leak-175-159", dataLeAk175);
		android.util.Log.d("leak-177-159", dataLeAk177);
		android.util.Log.d("leak-178-159", dataLeAk178);
		android.util.Log.d("leak-179-159", dataLeAk179);
		android.util.Log.d("leak-180-159", dataLeAk180);
		android.util.Log.d("leak-181-159", dataLeAk181);
		android.util.Log.d("leak-182-159", dataLeAk182);
		android.util.Log.d("leak-183-159", dataLeAk183);
		android.util.Log.d("leak-184-159", dataLeAk184);
		android.util.Log.d("leak-185-159", dataLeAk185);
		android.util.Log.d("leak-187-159", dataLeAk187);
		android.util.Log.d("leak-189-159", dataLeAk189);
		android.util.Log.d("leak-191-159", dataLeAk191);
		android.util.Log.d("leak-192-159", dataLeAk192);
		android.util.Log.d("leak-193-159", dataLeAk193);
		android.util.Log.d("leak-194-159", dataLeAk194);

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
		dataLeAk160 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-160", dataLeAk145);
		android.util.Log.d("leak-147-160", dataLeAk147);
		android.util.Log.d("leak-149-160", dataLeAk149);
		android.util.Log.d("leak-151-160", dataLeAk151);
		android.util.Log.d("leak-153-160", dataLeAk153);
		android.util.Log.d("leak-155-160", dataLeAk155);
		android.util.Log.d("leak-157-160", dataLeAk157);
		android.util.Log.d("leak-158-160", dataLeAk158);
		android.util.Log.d("leak-159-160", dataLeAk159);
		android.util.Log.d("leak-160-160", dataLeAk160);
		android.util.Log.d("leak-162-160", dataLeAk162);
		android.util.Log.d("leak-164-160", dataLeAk164);
		android.util.Log.d("leak-166-160", dataLeAk166);
		android.util.Log.d("leak-168-160", dataLeAk168);
		android.util.Log.d("leak-169-160", dataLeAk169);
		android.util.Log.d("leak-170-160", dataLeAk170);
		android.util.Log.d("leak-171-160", dataLeAk171);
		android.util.Log.d("leak-172-160", dataLeAk172);
		android.util.Log.d("leak-173-160", dataLeAk173);
		android.util.Log.d("leak-174-160", dataLeAk174);
		android.util.Log.d("leak-175-160", dataLeAk175);
		android.util.Log.d("leak-177-160", dataLeAk177);
		android.util.Log.d("leak-178-160", dataLeAk178);
		android.util.Log.d("leak-179-160", dataLeAk179);
		android.util.Log.d("leak-180-160", dataLeAk180);
		android.util.Log.d("leak-181-160", dataLeAk181);
		android.util.Log.d("leak-182-160", dataLeAk182);
		android.util.Log.d("leak-183-160", dataLeAk183);
		android.util.Log.d("leak-184-160", dataLeAk184);
		android.util.Log.d("leak-185-160", dataLeAk185);
		android.util.Log.d("leak-187-160", dataLeAk187);
		android.util.Log.d("leak-189-160", dataLeAk189);
		android.util.Log.d("leak-191-160", dataLeAk191);
		android.util.Log.d("leak-192-160", dataLeAk192);
		android.util.Log.d("leak-193-160", dataLeAk193);
		android.util.Log.d("leak-194-160", dataLeAk194);
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
                    String dataLeAk161 = "161";

					public boolean onTouchEvent(TextView widget, Spannable buffer,
                                                MotionEvent event) {
                        dataLeAk162 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													dataLeAk161 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
        LinearLayout searchLayout = (LinearLayout) findViewById(R.id.search);
		android.util.Log.d("leak-145-161", dataLeAk145);
		android.util.Log.d("leak-147-161", dataLeAk147);
		android.util.Log.d("leak-149-161", dataLeAk149);
		android.util.Log.d("leak-151-161", dataLeAk151);
		android.util.Log.d("leak-153-161", dataLeAk153);
		android.util.Log.d("leak-155-161", dataLeAk155);
		android.util.Log.d("leak-157-161", dataLeAk157);
		android.util.Log.d("leak-158-161", dataLeAk158);
		android.util.Log.d("leak-159-161", dataLeAk159);
		android.util.Log.d("leak-160-161", dataLeAk160);
		android.util.Log.d("leak-162-161", dataLeAk162);
		android.util.Log.d("leak-164-161", dataLeAk164);
		android.util.Log.d("leak-166-161", dataLeAk166);
		android.util.Log.d("leak-168-161", dataLeAk168);
		android.util.Log.d("leak-169-161", dataLeAk169);
		android.util.Log.d("leak-170-161", dataLeAk170);
		android.util.Log.d("leak-171-161", dataLeAk171);
		android.util.Log.d("leak-172-161", dataLeAk172);
		android.util.Log.d("leak-173-161", dataLeAk173);
		android.util.Log.d("leak-174-161", dataLeAk174);
		android.util.Log.d("leak-175-161", dataLeAk175);
		android.util.Log.d("leak-177-161", dataLeAk177);
		android.util.Log.d("leak-178-161", dataLeAk178);
		android.util.Log.d("leak-179-161", dataLeAk179);
		android.util.Log.d("leak-180-161", dataLeAk180);
		android.util.Log.d("leak-181-161", dataLeAk181);
		android.util.Log.d("leak-182-161", dataLeAk182);
		android.util.Log.d("leak-183-161", dataLeAk183);
		android.util.Log.d("leak-184-161", dataLeAk184);
		android.util.Log.d("leak-185-161", dataLeAk185);
		android.util.Log.d("leak-187-161", dataLeAk187);
		android.util.Log.d("leak-189-161", dataLeAk189);
		android.util.Log.d("leak-191-161", dataLeAk191);
		android.util.Log.d("leak-192-161", dataLeAk192);
		android.util.Log.d("leak-193-161", dataLeAk193);
		android.util.Log.d("leak-194-161", dataLeAk194);
        searchLayout.setVisibility(View.VISIBLE);
        EditText edt = (EditText) findViewById(R.id.edtSearchWord);
        edt.requestFocus();
    }

    // if editor was invoked from a global search, take over the search word and show the search panel
    private void startupSearch() {
        String searchString = getIntent().getStringExtra("SEARCH_STRING");
		android.util.Log.d("leak-145-162", dataLeAk145);
		android.util.Log.d("leak-147-162", dataLeAk147);
		android.util.Log.d("leak-149-162", dataLeAk149);
		android.util.Log.d("leak-151-162", dataLeAk151);
		android.util.Log.d("leak-153-162", dataLeAk153);
		android.util.Log.d("leak-155-162", dataLeAk155);
		android.util.Log.d("leak-157-162", dataLeAk157);
		android.util.Log.d("leak-158-162", dataLeAk158);
		android.util.Log.d("leak-159-162", dataLeAk159);
		android.util.Log.d("leak-160-162", dataLeAk160);
		android.util.Log.d("leak-162-162", dataLeAk162);
		android.util.Log.d("leak-164-162", dataLeAk164);
		android.util.Log.d("leak-166-162", dataLeAk166);
		android.util.Log.d("leak-168-162", dataLeAk168);
		android.util.Log.d("leak-169-162", dataLeAk169);
		android.util.Log.d("leak-170-162", dataLeAk170);
		android.util.Log.d("leak-171-162", dataLeAk171);
		android.util.Log.d("leak-172-162", dataLeAk172);
		android.util.Log.d("leak-173-162", dataLeAk173);
		android.util.Log.d("leak-174-162", dataLeAk174);
		android.util.Log.d("leak-175-162", dataLeAk175);
		android.util.Log.d("leak-177-162", dataLeAk177);
		android.util.Log.d("leak-178-162", dataLeAk178);
		android.util.Log.d("leak-179-162", dataLeAk179);
		android.util.Log.d("leak-180-162", dataLeAk180);
		android.util.Log.d("leak-181-162", dataLeAk181);
		android.util.Log.d("leak-182-162", dataLeAk182);
		android.util.Log.d("leak-183-162", dataLeAk183);
		android.util.Log.d("leak-184-162", dataLeAk184);
		android.util.Log.d("leak-185-162", dataLeAk185);
		android.util.Log.d("leak-187-162", dataLeAk187);
		android.util.Log.d("leak-189-162", dataLeAk189);
		android.util.Log.d("leak-191-162", dataLeAk191);
		android.util.Log.d("leak-192-162", dataLeAk192);
		android.util.Log.d("leak-193-162", dataLeAk193);
		android.util.Log.d("leak-194-162", dataLeAk194);
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
        ImageButton mBtnForward = (ImageButton) findViewById(R.id.btnForward);
		android.util.Log.d("leak-145-163", dataLeAk145);
		android.util.Log.d("leak-147-163", dataLeAk147);
		android.util.Log.d("leak-149-163", dataLeAk149);
		android.util.Log.d("leak-151-163", dataLeAk151);
		android.util.Log.d("leak-153-163", dataLeAk153);
		android.util.Log.d("leak-155-163", dataLeAk155);
		android.util.Log.d("leak-157-163", dataLeAk157);
		android.util.Log.d("leak-158-163", dataLeAk158);
		android.util.Log.d("leak-159-163", dataLeAk159);
		android.util.Log.d("leak-160-163", dataLeAk160);
		android.util.Log.d("leak-162-163", dataLeAk162);
		android.util.Log.d("leak-164-163", dataLeAk164);
		android.util.Log.d("leak-166-163", dataLeAk166);
		android.util.Log.d("leak-168-163", dataLeAk168);
		android.util.Log.d("leak-169-163", dataLeAk169);
		android.util.Log.d("leak-170-163", dataLeAk170);
		android.util.Log.d("leak-171-163", dataLeAk171);
		android.util.Log.d("leak-172-163", dataLeAk172);
		android.util.Log.d("leak-173-163", dataLeAk173);
		android.util.Log.d("leak-174-163", dataLeAk174);
		android.util.Log.d("leak-175-163", dataLeAk175);
		android.util.Log.d("leak-177-163", dataLeAk177);
		android.util.Log.d("leak-178-163", dataLeAk178);
		android.util.Log.d("leak-179-163", dataLeAk179);
		android.util.Log.d("leak-180-163", dataLeAk180);
		android.util.Log.d("leak-181-163", dataLeAk181);
		android.util.Log.d("leak-182-163", dataLeAk182);
		android.util.Log.d("leak-183-163", dataLeAk183);
		android.util.Log.d("leak-184-163", dataLeAk184);
		android.util.Log.d("leak-185-163", dataLeAk185);
		android.util.Log.d("leak-187-163", dataLeAk187);
		android.util.Log.d("leak-189-163", dataLeAk189);
		android.util.Log.d("leak-191-163", dataLeAk191);
		android.util.Log.d("leak-192-163", dataLeAk192);
		android.util.Log.d("leak-193-163", dataLeAk193);
		android.util.Log.d("leak-194-163", dataLeAk194);
        mBtnForward.setOnClickListener(
                new OnClickListener() {
                    String dataLeAk163 = "163";

					public void onClick(View v) {
                        dataLeAk164 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						dataLeAk163 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						searchForward();
                    }
                }
        );
        ImageButton mBtnBackward = (ImageButton) findViewById(R.id.btnBackward);
        mBtnBackward.setOnClickListener(
                new OnClickListener() {
                    String dataLeAk165 = "165";

					public void onClick(View v) {
                        dataLeAk166 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						dataLeAk165 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						searchBackward();
                    }
                }
        );
        ImageButton btnClose = (ImageButton) findViewById(R.id.btnClose);
        btnClose.setOnClickListener(
                new OnClickListener() {
                    String dataLeAk167 = "167";

					public void onClick(View v) {
                        dataLeAk168 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						dataLeAk167 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						LinearLayout searchLayout = (LinearLayout) findViewById(R.id.search);
                        searchLayout.setVisibility(View.GONE);
                    }
                }
        );
    }

    // Search forward from current selection
    private void searchForward() {
        EditText edt = (EditText) findViewById(R.id.edtSearchWord);
		android.util.Log.d("leak-145-164", dataLeAk145);
		android.util.Log.d("leak-147-164", dataLeAk147);
		android.util.Log.d("leak-149-164", dataLeAk149);
		android.util.Log.d("leak-151-164", dataLeAk151);
		android.util.Log.d("leak-153-164", dataLeAk153);
		android.util.Log.d("leak-155-164", dataLeAk155);
		android.util.Log.d("leak-157-164", dataLeAk157);
		android.util.Log.d("leak-158-164", dataLeAk158);
		android.util.Log.d("leak-159-164", dataLeAk159);
		android.util.Log.d("leak-160-164", dataLeAk160);
		android.util.Log.d("leak-162-164", dataLeAk162);
		android.util.Log.d("leak-164-164", dataLeAk164);
		android.util.Log.d("leak-166-164", dataLeAk166);
		android.util.Log.d("leak-168-164", dataLeAk168);
		android.util.Log.d("leak-169-164", dataLeAk169);
		android.util.Log.d("leak-170-164", dataLeAk170);
		android.util.Log.d("leak-171-164", dataLeAk171);
		android.util.Log.d("leak-172-164", dataLeAk172);
		android.util.Log.d("leak-173-164", dataLeAk173);
		android.util.Log.d("leak-174-164", dataLeAk174);
		android.util.Log.d("leak-175-164", dataLeAk175);
		android.util.Log.d("leak-177-164", dataLeAk177);
		android.util.Log.d("leak-178-164", dataLeAk178);
		android.util.Log.d("leak-179-164", dataLeAk179);
		android.util.Log.d("leak-180-164", dataLeAk180);
		android.util.Log.d("leak-181-164", dataLeAk181);
		android.util.Log.d("leak-182-164", dataLeAk182);
		android.util.Log.d("leak-183-164", dataLeAk183);
		android.util.Log.d("leak-184-164", dataLeAk184);
		android.util.Log.d("leak-185-164", dataLeAk185);
		android.util.Log.d("leak-187-164", dataLeAk187);
		android.util.Log.d("leak-189-164", dataLeAk189);
		android.util.Log.d("leak-191-164", dataLeAk191);
		android.util.Log.d("leak-192-164", dataLeAk192);
		android.util.Log.d("leak-193-164", dataLeAk193);
		android.util.Log.d("leak-194-164", dataLeAk194);
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
        EditText edt = (EditText) findViewById(R.id.edtSearchWord);
		android.util.Log.d("leak-145-165", dataLeAk145);
		android.util.Log.d("leak-147-165", dataLeAk147);
		android.util.Log.d("leak-149-165", dataLeAk149);
		android.util.Log.d("leak-151-165", dataLeAk151);
		android.util.Log.d("leak-153-165", dataLeAk153);
		android.util.Log.d("leak-155-165", dataLeAk155);
		android.util.Log.d("leak-157-165", dataLeAk157);
		android.util.Log.d("leak-158-165", dataLeAk158);
		android.util.Log.d("leak-159-165", dataLeAk159);
		android.util.Log.d("leak-160-165", dataLeAk160);
		android.util.Log.d("leak-162-165", dataLeAk162);
		android.util.Log.d("leak-164-165", dataLeAk164);
		android.util.Log.d("leak-166-165", dataLeAk166);
		android.util.Log.d("leak-168-165", dataLeAk168);
		android.util.Log.d("leak-169-165", dataLeAk169);
		android.util.Log.d("leak-170-165", dataLeAk170);
		android.util.Log.d("leak-171-165", dataLeAk171);
		android.util.Log.d("leak-172-165", dataLeAk172);
		android.util.Log.d("leak-173-165", dataLeAk173);
		android.util.Log.d("leak-174-165", dataLeAk174);
		android.util.Log.d("leak-175-165", dataLeAk175);
		android.util.Log.d("leak-177-165", dataLeAk177);
		android.util.Log.d("leak-178-165", dataLeAk178);
		android.util.Log.d("leak-179-165", dataLeAk179);
		android.util.Log.d("leak-180-165", dataLeAk180);
		android.util.Log.d("leak-181-165", dataLeAk181);
		android.util.Log.d("leak-182-165", dataLeAk182);
		android.util.Log.d("leak-183-165", dataLeAk183);
		android.util.Log.d("leak-184-165", dataLeAk184);
		android.util.Log.d("leak-185-165", dataLeAk185);
		android.util.Log.d("leak-187-165", dataLeAk187);
		android.util.Log.d("leak-189-165", dataLeAk189);
		android.util.Log.d("leak-191-165", dataLeAk191);
		android.util.Log.d("leak-192-165", dataLeAk192);
		android.util.Log.d("leak-193-165", dataLeAk193);
		android.util.Log.d("leak-194-165", dataLeAk194);
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
		android.util.Log.d("leak-145-166", dataLeAk145);
		android.util.Log.d("leak-147-166", dataLeAk147);
		android.util.Log.d("leak-149-166", dataLeAk149);
		android.util.Log.d("leak-151-166", dataLeAk151);
		android.util.Log.d("leak-153-166", dataLeAk153);
		android.util.Log.d("leak-155-166", dataLeAk155);
		android.util.Log.d("leak-157-166", dataLeAk157);
		android.util.Log.d("leak-158-166", dataLeAk158);
		android.util.Log.d("leak-159-166", dataLeAk159);
		android.util.Log.d("leak-160-166", dataLeAk160);
		android.util.Log.d("leak-162-166", dataLeAk162);
		android.util.Log.d("leak-164-166", dataLeAk164);
		android.util.Log.d("leak-166-166", dataLeAk166);
		android.util.Log.d("leak-168-166", dataLeAk168);
		android.util.Log.d("leak-169-166", dataLeAk169);
		android.util.Log.d("leak-170-166", dataLeAk170);
		android.util.Log.d("leak-171-166", dataLeAk171);
		android.util.Log.d("leak-172-166", dataLeAk172);
		android.util.Log.d("leak-173-166", dataLeAk173);
		android.util.Log.d("leak-174-166", dataLeAk174);
		android.util.Log.d("leak-175-166", dataLeAk175);
		android.util.Log.d("leak-177-166", dataLeAk177);
		android.util.Log.d("leak-178-166", dataLeAk178);
		android.util.Log.d("leak-179-166", dataLeAk179);
		android.util.Log.d("leak-180-166", dataLeAk180);
		android.util.Log.d("leak-181-166", dataLeAk181);
		android.util.Log.d("leak-182-166", dataLeAk182);
		android.util.Log.d("leak-183-166", dataLeAk183);
		android.util.Log.d("leak-184-166", dataLeAk184);
		android.util.Log.d("leak-185-166", dataLeAk185);
		android.util.Log.d("leak-187-166", dataLeAk187);
		android.util.Log.d("leak-189-166", dataLeAk189);
		android.util.Log.d("leak-191-166", dataLeAk191);
		android.util.Log.d("leak-192-166", dataLeAk192);
		android.util.Log.d("leak-193-166", dataLeAk193);
		android.util.Log.d("leak-194-166", dataLeAk194);
    }

    private void getNoteFromFile() {
        if (DEBUG) {
            Log.d(TAG, "file: " + mFileContent);
        }
		android.util.Log.d("leak-145-167", dataLeAk145);
		android.util.Log.d("leak-147-167", dataLeAk147);
		android.util.Log.d("leak-149-167", dataLeAk149);
		android.util.Log.d("leak-151-167", dataLeAk151);
		android.util.Log.d("leak-153-167", dataLeAk153);
		android.util.Log.d("leak-155-167", dataLeAk155);
		android.util.Log.d("leak-157-167", dataLeAk157);
		android.util.Log.d("leak-158-167", dataLeAk158);
		android.util.Log.d("leak-159-167", dataLeAk159);
		android.util.Log.d("leak-160-167", dataLeAk160);
		android.util.Log.d("leak-162-167", dataLeAk162);
		android.util.Log.d("leak-164-167", dataLeAk164);
		android.util.Log.d("leak-166-167", dataLeAk166);
		android.util.Log.d("leak-168-167", dataLeAk168);
		android.util.Log.d("leak-169-167", dataLeAk169);
		android.util.Log.d("leak-170-167", dataLeAk170);
		android.util.Log.d("leak-171-167", dataLeAk171);
		android.util.Log.d("leak-172-167", dataLeAk172);
		android.util.Log.d("leak-173-167", dataLeAk173);
		android.util.Log.d("leak-174-167", dataLeAk174);
		android.util.Log.d("leak-175-167", dataLeAk175);
		android.util.Log.d("leak-177-167", dataLeAk177);
		android.util.Log.d("leak-178-167", dataLeAk178);
		android.util.Log.d("leak-179-167", dataLeAk179);
		android.util.Log.d("leak-180-167", dataLeAk180);
		android.util.Log.d("leak-181-167", dataLeAk181);
		android.util.Log.d("leak-182-167", dataLeAk182);
		android.util.Log.d("leak-183-167", dataLeAk183);
		android.util.Log.d("leak-184-167", dataLeAk184);
		android.util.Log.d("leak-185-167", dataLeAk185);
		android.util.Log.d("leak-187-167", dataLeAk187);
		android.util.Log.d("leak-189-167", dataLeAk189);
		android.util.Log.d("leak-191-167", dataLeAk191);
		android.util.Log.d("leak-192-167", dataLeAk192);
		android.util.Log.d("leak-193-167", dataLeAk193);
		android.util.Log.d("leak-194-167", dataLeAk194);
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
        String modified = "";
		android.util.Log.d("leak-145-168", dataLeAk145);
		android.util.Log.d("leak-147-168", dataLeAk147);
		android.util.Log.d("leak-149-168", dataLeAk149);
		android.util.Log.d("leak-151-168", dataLeAk151);
		android.util.Log.d("leak-153-168", dataLeAk153);
		android.util.Log.d("leak-155-168", dataLeAk155);
		android.util.Log.d("leak-157-168", dataLeAk157);
		android.util.Log.d("leak-158-168", dataLeAk158);
		android.util.Log.d("leak-159-168", dataLeAk159);
		android.util.Log.d("leak-160-168", dataLeAk160);
		android.util.Log.d("leak-162-168", dataLeAk162);
		android.util.Log.d("leak-164-168", dataLeAk164);
		android.util.Log.d("leak-166-168", dataLeAk166);
		android.util.Log.d("leak-168-168", dataLeAk168);
		android.util.Log.d("leak-169-168", dataLeAk169);
		android.util.Log.d("leak-170-168", dataLeAk170);
		android.util.Log.d("leak-171-168", dataLeAk171);
		android.util.Log.d("leak-172-168", dataLeAk172);
		android.util.Log.d("leak-173-168", dataLeAk173);
		android.util.Log.d("leak-174-168", dataLeAk174);
		android.util.Log.d("leak-175-168", dataLeAk175);
		android.util.Log.d("leak-177-168", dataLeAk177);
		android.util.Log.d("leak-178-168", dataLeAk178);
		android.util.Log.d("leak-179-168", dataLeAk179);
		android.util.Log.d("leak-180-168", dataLeAk180);
		android.util.Log.d("leak-181-168", dataLeAk181);
		android.util.Log.d("leak-182-168", dataLeAk182);
		android.util.Log.d("leak-183-168", dataLeAk183);
		android.util.Log.d("leak-184-168", dataLeAk184);
		android.util.Log.d("leak-185-168", dataLeAk185);
		android.util.Log.d("leak-187-168", dataLeAk187);
		android.util.Log.d("leak-189-168", dataLeAk189);
		android.util.Log.d("leak-191-168", dataLeAk191);
		android.util.Log.d("leak-192-168", dataLeAk192);
		android.util.Log.d("leak-193-168", dataLeAk193);
		android.util.Log.d("leak-194-168", dataLeAk194);
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
        boolean charCountVisible = false;
		android.util.Log.d("leak-145-169", dataLeAk145);
		android.util.Log.d("leak-147-169", dataLeAk147);
		android.util.Log.d("leak-149-169", dataLeAk149);
		android.util.Log.d("leak-151-169", dataLeAk151);
		android.util.Log.d("leak-153-169", dataLeAk153);
		android.util.Log.d("leak-155-169", dataLeAk155);
		android.util.Log.d("leak-157-169", dataLeAk157);
		android.util.Log.d("leak-158-169", dataLeAk158);
		android.util.Log.d("leak-159-169", dataLeAk159);
		android.util.Log.d("leak-160-169", dataLeAk160);
		android.util.Log.d("leak-162-169", dataLeAk162);
		android.util.Log.d("leak-164-169", dataLeAk164);
		android.util.Log.d("leak-166-169", dataLeAk166);
		android.util.Log.d("leak-168-169", dataLeAk168);
		android.util.Log.d("leak-169-169", dataLeAk169);
		android.util.Log.d("leak-170-169", dataLeAk170);
		android.util.Log.d("leak-171-169", dataLeAk171);
		android.util.Log.d("leak-172-169", dataLeAk172);
		android.util.Log.d("leak-173-169", dataLeAk173);
		android.util.Log.d("leak-174-169", dataLeAk174);
		android.util.Log.d("leak-175-169", dataLeAk175);
		android.util.Log.d("leak-177-169", dataLeAk177);
		android.util.Log.d("leak-178-169", dataLeAk178);
		android.util.Log.d("leak-179-169", dataLeAk179);
		android.util.Log.d("leak-180-169", dataLeAk180);
		android.util.Log.d("leak-181-169", dataLeAk181);
		android.util.Log.d("leak-182-169", dataLeAk182);
		android.util.Log.d("leak-183-169", dataLeAk183);
		android.util.Log.d("leak-184-169", dataLeAk184);
		android.util.Log.d("leak-185-169", dataLeAk185);
		android.util.Log.d("leak-187-169", dataLeAk187);
		android.util.Log.d("leak-189-169", dataLeAk189);
		android.util.Log.d("leak-191-169", dataLeAk191);
		android.util.Log.d("leak-192-169", dataLeAk192);
		android.util.Log.d("leak-193-169", dataLeAk193);
		android.util.Log.d("leak-194-169", dataLeAk194);
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
        dataLeAk169 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-170", dataLeAk145);
		android.util.Log.d("leak-147-170", dataLeAk147);
		android.util.Log.d("leak-149-170", dataLeAk149);
		android.util.Log.d("leak-151-170", dataLeAk151);
		android.util.Log.d("leak-153-170", dataLeAk153);
		android.util.Log.d("leak-155-170", dataLeAk155);
		android.util.Log.d("leak-157-170", dataLeAk157);
		android.util.Log.d("leak-158-170", dataLeAk158);
		android.util.Log.d("leak-159-170", dataLeAk159);
		android.util.Log.d("leak-160-170", dataLeAk160);
		android.util.Log.d("leak-162-170", dataLeAk162);
		android.util.Log.d("leak-164-170", dataLeAk164);
		android.util.Log.d("leak-166-170", dataLeAk166);
		android.util.Log.d("leak-168-170", dataLeAk168);
		android.util.Log.d("leak-169-170", dataLeAk169);
		android.util.Log.d("leak-170-170", dataLeAk170);
		android.util.Log.d("leak-171-170", dataLeAk171);
		android.util.Log.d("leak-172-170", dataLeAk172);
		android.util.Log.d("leak-173-170", dataLeAk173);
		android.util.Log.d("leak-174-170", dataLeAk174);
		android.util.Log.d("leak-175-170", dataLeAk175);
		android.util.Log.d("leak-177-170", dataLeAk177);
		android.util.Log.d("leak-178-170", dataLeAk178);
		android.util.Log.d("leak-179-170", dataLeAk179);
		android.util.Log.d("leak-180-170", dataLeAk180);
		android.util.Log.d("leak-181-170", dataLeAk181);
		android.util.Log.d("leak-182-170", dataLeAk182);
		android.util.Log.d("leak-183-170", dataLeAk183);
		android.util.Log.d("leak-184-170", dataLeAk184);
		android.util.Log.d("leak-185-170", dataLeAk185);
		android.util.Log.d("leak-187-170", dataLeAk187);
		android.util.Log.d("leak-189-170", dataLeAk189);
		android.util.Log.d("leak-191-170", dataLeAk191);
		android.util.Log.d("leak-192-170", dataLeAk192);
		android.util.Log.d("leak-193-170", dataLeAk193);
		android.util.Log.d("leak-194-170", dataLeAk194);
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
		dataLeAk170 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-171", dataLeAk145);
		android.util.Log.d("leak-147-171", dataLeAk147);
		android.util.Log.d("leak-149-171", dataLeAk149);
		android.util.Log.d("leak-151-171", dataLeAk151);
		android.util.Log.d("leak-153-171", dataLeAk153);
		android.util.Log.d("leak-155-171", dataLeAk155);
		android.util.Log.d("leak-157-171", dataLeAk157);
		android.util.Log.d("leak-158-171", dataLeAk158);
		android.util.Log.d("leak-159-171", dataLeAk159);
		android.util.Log.d("leak-160-171", dataLeAk160);
		android.util.Log.d("leak-162-171", dataLeAk162);
		android.util.Log.d("leak-164-171", dataLeAk164);
		android.util.Log.d("leak-166-171", dataLeAk166);
		android.util.Log.d("leak-168-171", dataLeAk168);
		android.util.Log.d("leak-169-171", dataLeAk169);
		android.util.Log.d("leak-170-171", dataLeAk170);
		android.util.Log.d("leak-171-171", dataLeAk171);
		android.util.Log.d("leak-172-171", dataLeAk172);
		android.util.Log.d("leak-173-171", dataLeAk173);
		android.util.Log.d("leak-174-171", dataLeAk174);
		android.util.Log.d("leak-175-171", dataLeAk175);
		android.util.Log.d("leak-177-171", dataLeAk177);
		android.util.Log.d("leak-178-171", dataLeAk178);
		android.util.Log.d("leak-179-171", dataLeAk179);
		android.util.Log.d("leak-180-171", dataLeAk180);
		android.util.Log.d("leak-181-171", dataLeAk181);
		android.util.Log.d("leak-182-171", dataLeAk182);
		android.util.Log.d("leak-183-171", dataLeAk183);
		android.util.Log.d("leak-184-171", dataLeAk184);
		android.util.Log.d("leak-185-171", dataLeAk185);
		android.util.Log.d("leak-187-171", dataLeAk187);
		android.util.Log.d("leak-189-171", dataLeAk189);
		android.util.Log.d("leak-191-171", dataLeAk191);
		android.util.Log.d("leak-192-171", dataLeAk192);
		android.util.Log.d("leak-193-171", dataLeAk193);
		android.util.Log.d("leak-194-171", dataLeAk194);
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
        String text = mText.getText().toString();
		android.util.Log.d("leak-145-172", dataLeAk145);
		android.util.Log.d("leak-147-172", dataLeAk147);
		android.util.Log.d("leak-149-172", dataLeAk149);
		android.util.Log.d("leak-151-172", dataLeAk151);
		android.util.Log.d("leak-153-172", dataLeAk153);
		android.util.Log.d("leak-155-172", dataLeAk155);
		android.util.Log.d("leak-157-172", dataLeAk157);
		android.util.Log.d("leak-158-172", dataLeAk158);
		android.util.Log.d("leak-159-172", dataLeAk159);
		android.util.Log.d("leak-160-172", dataLeAk160);
		android.util.Log.d("leak-162-172", dataLeAk162);
		android.util.Log.d("leak-164-172", dataLeAk164);
		android.util.Log.d("leak-166-172", dataLeAk166);
		android.util.Log.d("leak-168-172", dataLeAk168);
		android.util.Log.d("leak-169-172", dataLeAk169);
		android.util.Log.d("leak-170-172", dataLeAk170);
		android.util.Log.d("leak-171-172", dataLeAk171);
		android.util.Log.d("leak-172-172", dataLeAk172);
		android.util.Log.d("leak-173-172", dataLeAk173);
		android.util.Log.d("leak-174-172", dataLeAk174);
		android.util.Log.d("leak-175-172", dataLeAk175);
		android.util.Log.d("leak-177-172", dataLeAk177);
		android.util.Log.d("leak-178-172", dataLeAk178);
		android.util.Log.d("leak-179-172", dataLeAk179);
		android.util.Log.d("leak-180-172", dataLeAk180);
		android.util.Log.d("leak-181-172", dataLeAk181);
		android.util.Log.d("leak-182-172", dataLeAk182);
		android.util.Log.d("leak-183-172", dataLeAk183);
		android.util.Log.d("leak-184-172", dataLeAk184);
		android.util.Log.d("leak-185-172", dataLeAk185);
		android.util.Log.d("leak-187-172", dataLeAk187);
		android.util.Log.d("leak-189-172", dataLeAk189);
		android.util.Log.d("leak-191-172", dataLeAk191);
		android.util.Log.d("leak-192-172", dataLeAk192);
		android.util.Log.d("leak-193-172", dataLeAk193);
		android.util.Log.d("leak-194-172", dataLeAk194);
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
        String text = mText.getText().toString();
		android.util.Log.d("leak-145-173", dataLeAk145);
		android.util.Log.d("leak-147-173", dataLeAk147);
		android.util.Log.d("leak-149-173", dataLeAk149);
		android.util.Log.d("leak-151-173", dataLeAk151);
		android.util.Log.d("leak-153-173", dataLeAk153);
		android.util.Log.d("leak-155-173", dataLeAk155);
		android.util.Log.d("leak-157-173", dataLeAk157);
		android.util.Log.d("leak-158-173", dataLeAk158);
		android.util.Log.d("leak-159-173", dataLeAk159);
		android.util.Log.d("leak-160-173", dataLeAk160);
		android.util.Log.d("leak-162-173", dataLeAk162);
		android.util.Log.d("leak-164-173", dataLeAk164);
		android.util.Log.d("leak-166-173", dataLeAk166);
		android.util.Log.d("leak-168-173", dataLeAk168);
		android.util.Log.d("leak-169-173", dataLeAk169);
		android.util.Log.d("leak-170-173", dataLeAk170);
		android.util.Log.d("leak-171-173", dataLeAk171);
		android.util.Log.d("leak-172-173", dataLeAk172);
		android.util.Log.d("leak-173-173", dataLeAk173);
		android.util.Log.d("leak-174-173", dataLeAk174);
		android.util.Log.d("leak-175-173", dataLeAk175);
		android.util.Log.d("leak-177-173", dataLeAk177);
		android.util.Log.d("leak-178-173", dataLeAk178);
		android.util.Log.d("leak-179-173", dataLeAk179);
		android.util.Log.d("leak-180-173", dataLeAk180);
		android.util.Log.d("leak-181-173", dataLeAk181);
		android.util.Log.d("leak-182-173", dataLeAk182);
		android.util.Log.d("leak-183-173", dataLeAk183);
		android.util.Log.d("leak-184-173", dataLeAk184);
		android.util.Log.d("leak-185-173", dataLeAk185);
		android.util.Log.d("leak-187-173", dataLeAk187);
		android.util.Log.d("leak-189-173", dataLeAk189);
		android.util.Log.d("leak-191-173", dataLeAk191);
		android.util.Log.d("leak-192-173", dataLeAk192);
		android.util.Log.d("leak-193-173", dataLeAk193);
		android.util.Log.d("leak-194-173", dataLeAk194);
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
        long encrypted = 0;
		android.util.Log.d("leak-145-174", dataLeAk145);
		android.util.Log.d("leak-147-174", dataLeAk147);
		android.util.Log.d("leak-149-174", dataLeAk149);
		android.util.Log.d("leak-151-174", dataLeAk151);
		android.util.Log.d("leak-153-174", dataLeAk153);
		android.util.Log.d("leak-155-174", dataLeAk155);
		android.util.Log.d("leak-157-174", dataLeAk157);
		android.util.Log.d("leak-158-174", dataLeAk158);
		android.util.Log.d("leak-159-174", dataLeAk159);
		android.util.Log.d("leak-160-174", dataLeAk160);
		android.util.Log.d("leak-162-174", dataLeAk162);
		android.util.Log.d("leak-164-174", dataLeAk164);
		android.util.Log.d("leak-166-174", dataLeAk166);
		android.util.Log.d("leak-168-174", dataLeAk168);
		android.util.Log.d("leak-169-174", dataLeAk169);
		android.util.Log.d("leak-170-174", dataLeAk170);
		android.util.Log.d("leak-171-174", dataLeAk171);
		android.util.Log.d("leak-172-174", dataLeAk172);
		android.util.Log.d("leak-173-174", dataLeAk173);
		android.util.Log.d("leak-174-174", dataLeAk174);
		android.util.Log.d("leak-175-174", dataLeAk175);
		android.util.Log.d("leak-177-174", dataLeAk177);
		android.util.Log.d("leak-178-174", dataLeAk178);
		android.util.Log.d("leak-179-174", dataLeAk179);
		android.util.Log.d("leak-180-174", dataLeAk180);
		android.util.Log.d("leak-181-174", dataLeAk181);
		android.util.Log.d("leak-182-174", dataLeAk182);
		android.util.Log.d("leak-183-174", dataLeAk183);
		android.util.Log.d("leak-184-174", dataLeAk184);
		android.util.Log.d("leak-185-174", dataLeAk185);
		android.util.Log.d("leak-187-174", dataLeAk187);
		android.util.Log.d("leak-189-174", dataLeAk189);
		android.util.Log.d("leak-191-174", dataLeAk191);
		android.util.Log.d("leak-192-174", dataLeAk192);
		android.util.Log.d("leak-193-174", dataLeAk193);
		android.util.Log.d("leak-194-174", dataLeAk194);
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
        String tags;
		android.util.Log.d("leak-145-175", dataLeAk145);
		android.util.Log.d("leak-147-175", dataLeAk147);
		android.util.Log.d("leak-149-175", dataLeAk149);
		android.util.Log.d("leak-151-175", dataLeAk151);
		android.util.Log.d("leak-153-175", dataLeAk153);
		android.util.Log.d("leak-155-175", dataLeAk155);
		android.util.Log.d("leak-157-175", dataLeAk157);
		android.util.Log.d("leak-158-175", dataLeAk158);
		android.util.Log.d("leak-159-175", dataLeAk159);
		android.util.Log.d("leak-160-175", dataLeAk160);
		android.util.Log.d("leak-162-175", dataLeAk162);
		android.util.Log.d("leak-164-175", dataLeAk164);
		android.util.Log.d("leak-166-175", dataLeAk166);
		android.util.Log.d("leak-168-175", dataLeAk168);
		android.util.Log.d("leak-169-175", dataLeAk169);
		android.util.Log.d("leak-170-175", dataLeAk170);
		android.util.Log.d("leak-171-175", dataLeAk171);
		android.util.Log.d("leak-172-175", dataLeAk172);
		android.util.Log.d("leak-173-175", dataLeAk173);
		android.util.Log.d("leak-174-175", dataLeAk174);
		android.util.Log.d("leak-175-175", dataLeAk175);
		android.util.Log.d("leak-177-175", dataLeAk177);
		android.util.Log.d("leak-178-175", dataLeAk178);
		android.util.Log.d("leak-179-175", dataLeAk179);
		android.util.Log.d("leak-180-175", dataLeAk180);
		android.util.Log.d("leak-181-175", dataLeAk181);
		android.util.Log.d("leak-182-175", dataLeAk182);
		android.util.Log.d("leak-183-175", dataLeAk183);
		android.util.Log.d("leak-184-175", dataLeAk184);
		android.util.Log.d("leak-185-175", dataLeAk185);
		android.util.Log.d("leak-187-175", dataLeAk187);
		android.util.Log.d("leak-189-175", dataLeAk189);
		android.util.Log.d("leak-191-175", dataLeAk191);
		android.util.Log.d("leak-192-175", dataLeAk192);
		android.util.Log.d("leak-193-175", dataLeAk193);
		android.util.Log.d("leak-194-175", dataLeAk194);

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
		dataLeAk171 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-176", dataLeAk145);
		android.util.Log.d("leak-147-176", dataLeAk147);
		android.util.Log.d("leak-149-176", dataLeAk149);
		android.util.Log.d("leak-151-176", dataLeAk151);
		android.util.Log.d("leak-153-176", dataLeAk153);
		android.util.Log.d("leak-155-176", dataLeAk155);
		android.util.Log.d("leak-157-176", dataLeAk157);
		android.util.Log.d("leak-158-176", dataLeAk158);
		android.util.Log.d("leak-159-176", dataLeAk159);
		android.util.Log.d("leak-160-176", dataLeAk160);
		android.util.Log.d("leak-162-176", dataLeAk162);
		android.util.Log.d("leak-164-176", dataLeAk164);
		android.util.Log.d("leak-166-176", dataLeAk166);
		android.util.Log.d("leak-168-176", dataLeAk168);
		android.util.Log.d("leak-169-176", dataLeAk169);
		android.util.Log.d("leak-170-176", dataLeAk170);
		android.util.Log.d("leak-171-176", dataLeAk171);
		android.util.Log.d("leak-172-176", dataLeAk172);
		android.util.Log.d("leak-173-176", dataLeAk173);
		android.util.Log.d("leak-174-176", dataLeAk174);
		android.util.Log.d("leak-175-176", dataLeAk175);
		android.util.Log.d("leak-177-176", dataLeAk177);
		android.util.Log.d("leak-178-176", dataLeAk178);
		android.util.Log.d("leak-179-176", dataLeAk179);
		android.util.Log.d("leak-180-176", dataLeAk180);
		android.util.Log.d("leak-181-176", dataLeAk181);
		android.util.Log.d("leak-182-176", dataLeAk182);
		android.util.Log.d("leak-183-176", dataLeAk183);
		android.util.Log.d("leak-184-176", dataLeAk184);
		android.util.Log.d("leak-185-176", dataLeAk185);
		android.util.Log.d("leak-187-176", dataLeAk187);
		android.util.Log.d("leak-189-176", dataLeAk189);
		android.util.Log.d("leak-191-176", dataLeAk191);
		android.util.Log.d("leak-192-176", dataLeAk192);
		android.util.Log.d("leak-193-176", dataLeAk193);
		android.util.Log.d("leak-194-176", dataLeAk194);

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

        dataLeAk172 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-177", dataLeAk145);
		android.util.Log.d("leak-147-177", dataLeAk147);
		android.util.Log.d("leak-149-177", dataLeAk149);
		android.util.Log.d("leak-151-177", dataLeAk151);
		android.util.Log.d("leak-153-177", dataLeAk153);
		android.util.Log.d("leak-155-177", dataLeAk155);
		android.util.Log.d("leak-157-177", dataLeAk157);
		android.util.Log.d("leak-158-177", dataLeAk158);
		android.util.Log.d("leak-159-177", dataLeAk159);
		android.util.Log.d("leak-160-177", dataLeAk160);
		android.util.Log.d("leak-162-177", dataLeAk162);
		android.util.Log.d("leak-164-177", dataLeAk164);
		android.util.Log.d("leak-166-177", dataLeAk166);
		android.util.Log.d("leak-168-177", dataLeAk168);
		android.util.Log.d("leak-169-177", dataLeAk169);
		android.util.Log.d("leak-170-177", dataLeAk170);
		android.util.Log.d("leak-171-177", dataLeAk171);
		android.util.Log.d("leak-172-177", dataLeAk172);
		android.util.Log.d("leak-173-177", dataLeAk173);
		android.util.Log.d("leak-174-177", dataLeAk174);
		android.util.Log.d("leak-175-177", dataLeAk175);
		android.util.Log.d("leak-177-177", dataLeAk177);
		android.util.Log.d("leak-178-177", dataLeAk178);
		android.util.Log.d("leak-179-177", dataLeAk179);
		android.util.Log.d("leak-180-177", dataLeAk180);
		android.util.Log.d("leak-181-177", dataLeAk181);
		android.util.Log.d("leak-182-177", dataLeAk182);
		android.util.Log.d("leak-183-177", dataLeAk183);
		android.util.Log.d("leak-184-177", dataLeAk184);
		android.util.Log.d("leak-185-177", dataLeAk185);
		android.util.Log.d("leak-187-177", dataLeAk187);
		android.util.Log.d("leak-189-177", dataLeAk189);
		android.util.Log.d("leak-191-177", dataLeAk191);
		android.util.Log.d("leak-192-177", dataLeAk192);
		android.util.Log.d("leak-193-177", dataLeAk193);
		android.util.Log.d("leak-194-177", dataLeAk194);
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
        dataLeAk173 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-178", dataLeAk145);
		android.util.Log.d("leak-147-178", dataLeAk147);
		android.util.Log.d("leak-149-178", dataLeAk149);
		android.util.Log.d("leak-151-178", dataLeAk151);
		android.util.Log.d("leak-153-178", dataLeAk153);
		android.util.Log.d("leak-155-178", dataLeAk155);
		android.util.Log.d("leak-157-178", dataLeAk157);
		android.util.Log.d("leak-158-178", dataLeAk158);
		android.util.Log.d("leak-159-178", dataLeAk159);
		android.util.Log.d("leak-160-178", dataLeAk160);
		android.util.Log.d("leak-162-178", dataLeAk162);
		android.util.Log.d("leak-164-178", dataLeAk164);
		android.util.Log.d("leak-166-178", dataLeAk166);
		android.util.Log.d("leak-168-178", dataLeAk168);
		android.util.Log.d("leak-169-178", dataLeAk169);
		android.util.Log.d("leak-170-178", dataLeAk170);
		android.util.Log.d("leak-171-178", dataLeAk171);
		android.util.Log.d("leak-172-178", dataLeAk172);
		android.util.Log.d("leak-173-178", dataLeAk173);
		android.util.Log.d("leak-174-178", dataLeAk174);
		android.util.Log.d("leak-175-178", dataLeAk175);
		android.util.Log.d("leak-177-178", dataLeAk177);
		android.util.Log.d("leak-178-178", dataLeAk178);
		android.util.Log.d("leak-179-178", dataLeAk179);
		android.util.Log.d("leak-180-178", dataLeAk180);
		android.util.Log.d("leak-181-178", dataLeAk181);
		android.util.Log.d("leak-182-178", dataLeAk182);
		android.util.Log.d("leak-183-178", dataLeAk183);
		android.util.Log.d("leak-184-178", dataLeAk184);
		android.util.Log.d("leak-185-178", dataLeAk185);
		android.util.Log.d("leak-187-178", dataLeAk187);
		android.util.Log.d("leak-189-178", dataLeAk189);
		android.util.Log.d("leak-191-178", dataLeAk191);
		android.util.Log.d("leak-192-178", dataLeAk192);
		android.util.Log.d("leak-193-178", dataLeAk193);
		android.util.Log.d("leak-194-178", dataLeAk194);
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
        String content = mText.getText().toString();
		android.util.Log.d("leak-145-179", dataLeAk145);
		android.util.Log.d("leak-147-179", dataLeAk147);
		android.util.Log.d("leak-149-179", dataLeAk149);
		android.util.Log.d("leak-151-179", dataLeAk151);
		android.util.Log.d("leak-153-179", dataLeAk153);
		android.util.Log.d("leak-155-179", dataLeAk155);
		android.util.Log.d("leak-157-179", dataLeAk157);
		android.util.Log.d("leak-158-179", dataLeAk158);
		android.util.Log.d("leak-159-179", dataLeAk159);
		android.util.Log.d("leak-160-179", dataLeAk160);
		android.util.Log.d("leak-162-179", dataLeAk162);
		android.util.Log.d("leak-164-179", dataLeAk164);
		android.util.Log.d("leak-166-179", dataLeAk166);
		android.util.Log.d("leak-168-179", dataLeAk168);
		android.util.Log.d("leak-169-179", dataLeAk169);
		android.util.Log.d("leak-170-179", dataLeAk170);
		android.util.Log.d("leak-171-179", dataLeAk171);
		android.util.Log.d("leak-172-179", dataLeAk172);
		android.util.Log.d("leak-173-179", dataLeAk173);
		android.util.Log.d("leak-174-179", dataLeAk174);
		android.util.Log.d("leak-175-179", dataLeAk175);
		android.util.Log.d("leak-177-179", dataLeAk177);
		android.util.Log.d("leak-178-179", dataLeAk178);
		android.util.Log.d("leak-179-179", dataLeAk179);
		android.util.Log.d("leak-180-179", dataLeAk180);
		android.util.Log.d("leak-181-179", dataLeAk181);
		android.util.Log.d("leak-182-179", dataLeAk182);
		android.util.Log.d("leak-183-179", dataLeAk183);
		android.util.Log.d("leak-184-179", dataLeAk184);
		android.util.Log.d("leak-185-179", dataLeAk185);
		android.util.Log.d("leak-187-179", dataLeAk187);
		android.util.Log.d("leak-189-179", dataLeAk189);
		android.util.Log.d("leak-191-179", dataLeAk191);
		android.util.Log.d("leak-192-179", dataLeAk192);
		android.util.Log.d("leak-193-179", dataLeAk193);
		android.util.Log.d("leak-194-179", dataLeAk194);
        String title = ExtractTitle.extractTitle(content);
        SendNote.sendNote(this, title, content);
    }

    private void deleteNoteWithConfirm() {
        showDialog(DIALOG_DELETE);
		android.util.Log.d("leak-145-180", dataLeAk145);
		android.util.Log.d("leak-147-180", dataLeAk147);
		android.util.Log.d("leak-149-180", dataLeAk149);
		android.util.Log.d("leak-151-180", dataLeAk151);
		android.util.Log.d("leak-153-180", dataLeAk153);
		android.util.Log.d("leak-155-180", dataLeAk155);
		android.util.Log.d("leak-157-180", dataLeAk157);
		android.util.Log.d("leak-158-180", dataLeAk158);
		android.util.Log.d("leak-159-180", dataLeAk159);
		android.util.Log.d("leak-160-180", dataLeAk160);
		android.util.Log.d("leak-162-180", dataLeAk162);
		android.util.Log.d("leak-164-180", dataLeAk164);
		android.util.Log.d("leak-166-180", dataLeAk166);
		android.util.Log.d("leak-168-180", dataLeAk168);
		android.util.Log.d("leak-169-180", dataLeAk169);
		android.util.Log.d("leak-170-180", dataLeAk170);
		android.util.Log.d("leak-171-180", dataLeAk171);
		android.util.Log.d("leak-172-180", dataLeAk172);
		android.util.Log.d("leak-173-180", dataLeAk173);
		android.util.Log.d("leak-174-180", dataLeAk174);
		android.util.Log.d("leak-175-180", dataLeAk175);
		android.util.Log.d("leak-177-180", dataLeAk177);
		android.util.Log.d("leak-178-180", dataLeAk178);
		android.util.Log.d("leak-179-180", dataLeAk179);
		android.util.Log.d("leak-180-180", dataLeAk180);
		android.util.Log.d("leak-181-180", dataLeAk181);
		android.util.Log.d("leak-182-180", dataLeAk182);
		android.util.Log.d("leak-183-180", dataLeAk183);
		android.util.Log.d("leak-184-180", dataLeAk184);
		android.util.Log.d("leak-185-180", dataLeAk185);
		android.util.Log.d("leak-187-180", dataLeAk187);
		android.util.Log.d("leak-189-180", dataLeAk189);
		android.util.Log.d("leak-191-180", dataLeAk191);
		android.util.Log.d("leak-192-180", dataLeAk192);
		android.util.Log.d("leak-193-180", dataLeAk193);
		android.util.Log.d("leak-194-180", dataLeAk194);
    }

    /**
     * Modifies an activity to pass along the currently selected text.
     *
     * @param intent
     */
    private void startTextSelectionActivity(Intent intent) {
        Intent newIntent = new Intent(intent);
		android.util.Log.d("leak-145-181", dataLeAk145);
		android.util.Log.d("leak-147-181", dataLeAk147);
		android.util.Log.d("leak-149-181", dataLeAk149);
		android.util.Log.d("leak-151-181", dataLeAk151);
		android.util.Log.d("leak-153-181", dataLeAk153);
		android.util.Log.d("leak-155-181", dataLeAk155);
		android.util.Log.d("leak-157-181", dataLeAk157);
		android.util.Log.d("leak-158-181", dataLeAk158);
		android.util.Log.d("leak-159-181", dataLeAk159);
		android.util.Log.d("leak-160-181", dataLeAk160);
		android.util.Log.d("leak-162-181", dataLeAk162);
		android.util.Log.d("leak-164-181", dataLeAk164);
		android.util.Log.d("leak-166-181", dataLeAk166);
		android.util.Log.d("leak-168-181", dataLeAk168);
		android.util.Log.d("leak-169-181", dataLeAk169);
		android.util.Log.d("leak-170-181", dataLeAk170);
		android.util.Log.d("leak-171-181", dataLeAk171);
		android.util.Log.d("leak-172-181", dataLeAk172);
		android.util.Log.d("leak-173-181", dataLeAk173);
		android.util.Log.d("leak-174-181", dataLeAk174);
		android.util.Log.d("leak-175-181", dataLeAk175);
		android.util.Log.d("leak-177-181", dataLeAk177);
		android.util.Log.d("leak-178-181", dataLeAk178);
		android.util.Log.d("leak-179-181", dataLeAk179);
		android.util.Log.d("leak-180-181", dataLeAk180);
		android.util.Log.d("leak-181-181", dataLeAk181);
		android.util.Log.d("leak-182-181", dataLeAk182);
		android.util.Log.d("leak-183-181", dataLeAk183);
		android.util.Log.d("leak-184-181", dataLeAk184);
		android.util.Log.d("leak-185-181", dataLeAk185);
		android.util.Log.d("leak-187-181", dataLeAk187);
		android.util.Log.d("leak-189-181", dataLeAk189);
		android.util.Log.d("leak-191-181", dataLeAk191);
		android.util.Log.d("leak-192-181", dataLeAk192);
		android.util.Log.d("leak-193-181", dataLeAk193);
		android.util.Log.d("leak-194-181", dataLeAk194);

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
		android.util.Log.d("leak-145-182", dataLeAk145);
		android.util.Log.d("leak-147-182", dataLeAk147);
		android.util.Log.d("leak-149-182", dataLeAk149);
		android.util.Log.d("leak-151-182", dataLeAk151);
		android.util.Log.d("leak-153-182", dataLeAk153);
		android.util.Log.d("leak-155-182", dataLeAk155);
		android.util.Log.d("leak-157-182", dataLeAk157);
		android.util.Log.d("leak-158-182", dataLeAk158);
		android.util.Log.d("leak-159-182", dataLeAk159);
		android.util.Log.d("leak-160-182", dataLeAk160);
		android.util.Log.d("leak-162-182", dataLeAk162);
		android.util.Log.d("leak-164-182", dataLeAk164);
		android.util.Log.d("leak-166-182", dataLeAk166);
		android.util.Log.d("leak-168-182", dataLeAk168);
		android.util.Log.d("leak-169-182", dataLeAk169);
		android.util.Log.d("leak-170-182", dataLeAk170);
		android.util.Log.d("leak-171-182", dataLeAk171);
		android.util.Log.d("leak-172-182", dataLeAk172);
		android.util.Log.d("leak-173-182", dataLeAk173);
		android.util.Log.d("leak-174-182", dataLeAk174);
		android.util.Log.d("leak-175-182", dataLeAk175);
		android.util.Log.d("leak-177-182", dataLeAk177);
		android.util.Log.d("leak-178-182", dataLeAk178);
		android.util.Log.d("leak-179-182", dataLeAk179);
		android.util.Log.d("leak-180-182", dataLeAk180);
		android.util.Log.d("leak-181-182", dataLeAk181);
		android.util.Log.d("leak-182-182", dataLeAk182);
		android.util.Log.d("leak-183-182", dataLeAk183);
		android.util.Log.d("leak-184-182", dataLeAk184);
		android.util.Log.d("leak-185-182", dataLeAk185);
		android.util.Log.d("leak-187-182", dataLeAk187);
		android.util.Log.d("leak-189-182", dataLeAk189);
		android.util.Log.d("leak-191-182", dataLeAk191);
		android.util.Log.d("leak-192-182", dataLeAk192);
		android.util.Log.d("leak-193-182", dataLeAk193);
		android.util.Log.d("leak-194-182", dataLeAk194);
    }

    /**
     * Take care of deleting a note. Simply deletes the entry.
     */
    private final void deleteNote() {
        if (mCursor != null) {
            mCursor.close();
            mCursor = null;
            getContentResolver().delete(mUri, null, null);
            mText.setText("");
        }
		android.util.Log.d("leak-145-183", dataLeAk145);
		android.util.Log.d("leak-147-183", dataLeAk147);
		android.util.Log.d("leak-149-183", dataLeAk149);
		android.util.Log.d("leak-151-183", dataLeAk151);
		android.util.Log.d("leak-153-183", dataLeAk153);
		android.util.Log.d("leak-155-183", dataLeAk155);
		android.util.Log.d("leak-157-183", dataLeAk157);
		android.util.Log.d("leak-158-183", dataLeAk158);
		android.util.Log.d("leak-159-183", dataLeAk159);
		android.util.Log.d("leak-160-183", dataLeAk160);
		android.util.Log.d("leak-162-183", dataLeAk162);
		android.util.Log.d("leak-164-183", dataLeAk164);
		android.util.Log.d("leak-166-183", dataLeAk166);
		android.util.Log.d("leak-168-183", dataLeAk168);
		android.util.Log.d("leak-169-183", dataLeAk169);
		android.util.Log.d("leak-170-183", dataLeAk170);
		android.util.Log.d("leak-171-183", dataLeAk171);
		android.util.Log.d("leak-172-183", dataLeAk172);
		android.util.Log.d("leak-173-183", dataLeAk173);
		android.util.Log.d("leak-174-183", dataLeAk174);
		android.util.Log.d("leak-175-183", dataLeAk175);
		android.util.Log.d("leak-177-183", dataLeAk177);
		android.util.Log.d("leak-178-183", dataLeAk178);
		android.util.Log.d("leak-179-183", dataLeAk179);
		android.util.Log.d("leak-180-183", dataLeAk180);
		android.util.Log.d("leak-181-183", dataLeAk181);
		android.util.Log.d("leak-182-183", dataLeAk182);
		android.util.Log.d("leak-183-183", dataLeAk183);
		android.util.Log.d("leak-184-183", dataLeAk184);
		android.util.Log.d("leak-185-183", dataLeAk185);
		android.util.Log.d("leak-187-183", dataLeAk187);
		android.util.Log.d("leak-189-183", dataLeAk189);
		android.util.Log.d("leak-191-183", dataLeAk191);
		android.util.Log.d("leak-192-183", dataLeAk192);
		android.util.Log.d("leak-193-183", dataLeAk193);
		android.util.Log.d("leak-194-183", dataLeAk194);
    }

	/*
	 * private final void discardNote() { //if (mCursor != null) { //
	 * mCursor.close(); // mCursor = null; // getContentResolver().delete(mUri,
	 * null, null); // mText.setText(""); //} mOriginalContent =
	 * mText.getText().toString(); mText.setText(""); }
	 */

    private void applyInsertText() {
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
		android.util.Log.d("leak-145-184", dataLeAk145);
		android.util.Log.d("leak-147-184", dataLeAk147);
		android.util.Log.d("leak-149-184", dataLeAk149);
		android.util.Log.d("leak-151-184", dataLeAk151);
		android.util.Log.d("leak-153-184", dataLeAk153);
		android.util.Log.d("leak-155-184", dataLeAk155);
		android.util.Log.d("leak-157-184", dataLeAk157);
		android.util.Log.d("leak-158-184", dataLeAk158);
		android.util.Log.d("leak-159-184", dataLeAk159);
		android.util.Log.d("leak-160-184", dataLeAk160);
		android.util.Log.d("leak-162-184", dataLeAk162);
		android.util.Log.d("leak-164-184", dataLeAk164);
		android.util.Log.d("leak-166-184", dataLeAk166);
		android.util.Log.d("leak-168-184", dataLeAk168);
		android.util.Log.d("leak-169-184", dataLeAk169);
		android.util.Log.d("leak-170-184", dataLeAk170);
		android.util.Log.d("leak-171-184", dataLeAk171);
		android.util.Log.d("leak-172-184", dataLeAk172);
		android.util.Log.d("leak-173-184", dataLeAk173);
		android.util.Log.d("leak-174-184", dataLeAk174);
		android.util.Log.d("leak-175-184", dataLeAk175);
		android.util.Log.d("leak-177-184", dataLeAk177);
		android.util.Log.d("leak-178-184", dataLeAk178);
		android.util.Log.d("leak-179-184", dataLeAk179);
		android.util.Log.d("leak-180-184", dataLeAk180);
		android.util.Log.d("leak-181-184", dataLeAk181);
		android.util.Log.d("leak-182-184", dataLeAk182);
		android.util.Log.d("leak-183-184", dataLeAk183);
		android.util.Log.d("leak-184-184", dataLeAk184);
		android.util.Log.d("leak-185-184", dataLeAk185);
		android.util.Log.d("leak-187-184", dataLeAk187);
		android.util.Log.d("leak-189-184", dataLeAk189);
		android.util.Log.d("leak-191-184", dataLeAk191);
		android.util.Log.d("leak-192-184", dataLeAk192);
		android.util.Log.d("leak-193-184", dataLeAk193);
		android.util.Log.d("leak-194-184", dataLeAk194);
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
        String originalText = mText.getText().toString();
		android.util.Log.d("leak-145-185", dataLeAk145);
		android.util.Log.d("leak-147-185", dataLeAk147);
		android.util.Log.d("leak-149-185", dataLeAk149);
		android.util.Log.d("leak-151-185", dataLeAk151);
		android.util.Log.d("leak-153-185", dataLeAk153);
		android.util.Log.d("leak-155-185", dataLeAk155);
		android.util.Log.d("leak-157-185", dataLeAk157);
		android.util.Log.d("leak-158-185", dataLeAk158);
		android.util.Log.d("leak-159-185", dataLeAk159);
		android.util.Log.d("leak-160-185", dataLeAk160);
		android.util.Log.d("leak-162-185", dataLeAk162);
		android.util.Log.d("leak-164-185", dataLeAk164);
		android.util.Log.d("leak-166-185", dataLeAk166);
		android.util.Log.d("leak-168-185", dataLeAk168);
		android.util.Log.d("leak-169-185", dataLeAk169);
		android.util.Log.d("leak-170-185", dataLeAk170);
		android.util.Log.d("leak-171-185", dataLeAk171);
		android.util.Log.d("leak-172-185", dataLeAk172);
		android.util.Log.d("leak-173-185", dataLeAk173);
		android.util.Log.d("leak-174-185", dataLeAk174);
		android.util.Log.d("leak-175-185", dataLeAk175);
		android.util.Log.d("leak-177-185", dataLeAk177);
		android.util.Log.d("leak-178-185", dataLeAk178);
		android.util.Log.d("leak-179-185", dataLeAk179);
		android.util.Log.d("leak-180-185", dataLeAk180);
		android.util.Log.d("leak-181-185", dataLeAk181);
		android.util.Log.d("leak-182-185", dataLeAk182);
		android.util.Log.d("leak-183-185", dataLeAk183);
		android.util.Log.d("leak-184-185", dataLeAk184);
		android.util.Log.d("leak-185-185", dataLeAk185);
		android.util.Log.d("leak-187-185", dataLeAk187);
		android.util.Log.d("leak-189-185", dataLeAk189);
		android.util.Log.d("leak-191-185", dataLeAk191);
		android.util.Log.d("leak-192-185", dataLeAk192);
		android.util.Log.d("leak-193-185", dataLeAk193);
		android.util.Log.d("leak-194-185", dataLeAk194);
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

        mFileContent = mText.getText().toString();
		android.util.Log.d("leak-145-186", dataLeAk145);
		android.util.Log.d("leak-147-186", dataLeAk147);
		android.util.Log.d("leak-149-186", dataLeAk149);
		android.util.Log.d("leak-151-186", dataLeAk151);
		android.util.Log.d("leak-153-186", dataLeAk153);
		android.util.Log.d("leak-155-186", dataLeAk155);
		android.util.Log.d("leak-157-186", dataLeAk157);
		android.util.Log.d("leak-158-186", dataLeAk158);
		android.util.Log.d("leak-159-186", dataLeAk159);
		android.util.Log.d("leak-160-186", dataLeAk160);
		android.util.Log.d("leak-162-186", dataLeAk162);
		android.util.Log.d("leak-164-186", dataLeAk164);
		android.util.Log.d("leak-166-186", dataLeAk166);
		android.util.Log.d("leak-168-186", dataLeAk168);
		android.util.Log.d("leak-169-186", dataLeAk169);
		android.util.Log.d("leak-170-186", dataLeAk170);
		android.util.Log.d("leak-171-186", dataLeAk171);
		android.util.Log.d("leak-172-186", dataLeAk172);
		android.util.Log.d("leak-173-186", dataLeAk173);
		android.util.Log.d("leak-174-186", dataLeAk174);
		android.util.Log.d("leak-175-186", dataLeAk175);
		android.util.Log.d("leak-177-186", dataLeAk177);
		android.util.Log.d("leak-178-186", dataLeAk178);
		android.util.Log.d("leak-179-186", dataLeAk179);
		android.util.Log.d("leak-180-186", dataLeAk180);
		android.util.Log.d("leak-181-186", dataLeAk181);
		android.util.Log.d("leak-182-186", dataLeAk182);
		android.util.Log.d("leak-183-186", dataLeAk183);
		android.util.Log.d("leak-184-186", dataLeAk184);
		android.util.Log.d("leak-185-186", dataLeAk185);
		android.util.Log.d("leak-187-186", dataLeAk187);
		android.util.Log.d("leak-189-186", dataLeAk189);
		android.util.Log.d("leak-191-186", dataLeAk191);
		android.util.Log.d("leak-192-186", dataLeAk192);
		android.util.Log.d("leak-193-186", dataLeAk193);
		android.util.Log.d("leak-194-186", dataLeAk194);

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
		android.util.Log.d("leak-145-187", dataLeAk145);
		android.util.Log.d("leak-147-187", dataLeAk147);
		android.util.Log.d("leak-149-187", dataLeAk149);
		android.util.Log.d("leak-151-187", dataLeAk151);
		android.util.Log.d("leak-153-187", dataLeAk153);
		android.util.Log.d("leak-155-187", dataLeAk155);
		android.util.Log.d("leak-157-187", dataLeAk157);
		android.util.Log.d("leak-158-187", dataLeAk158);
		android.util.Log.d("leak-159-187", dataLeAk159);
		android.util.Log.d("leak-160-187", dataLeAk160);
		android.util.Log.d("leak-162-187", dataLeAk162);
		android.util.Log.d("leak-164-187", dataLeAk164);
		android.util.Log.d("leak-166-187", dataLeAk166);
		android.util.Log.d("leak-168-187", dataLeAk168);
		android.util.Log.d("leak-169-187", dataLeAk169);
		android.util.Log.d("leak-170-187", dataLeAk170);
		android.util.Log.d("leak-171-187", dataLeAk171);
		android.util.Log.d("leak-172-187", dataLeAk172);
		android.util.Log.d("leak-173-187", dataLeAk173);
		android.util.Log.d("leak-174-187", dataLeAk174);
		android.util.Log.d("leak-175-187", dataLeAk175);
		android.util.Log.d("leak-177-187", dataLeAk177);
		android.util.Log.d("leak-178-187", dataLeAk178);
		android.util.Log.d("leak-179-187", dataLeAk179);
		android.util.Log.d("leak-180-187", dataLeAk180);
		android.util.Log.d("leak-181-187", dataLeAk181);
		android.util.Log.d("leak-182-187", dataLeAk182);
		android.util.Log.d("leak-183-187", dataLeAk183);
		android.util.Log.d("leak-184-187", dataLeAk184);
		android.util.Log.d("leak-185-187", dataLeAk185);
		android.util.Log.d("leak-187-187", dataLeAk187);
		android.util.Log.d("leak-189-187", dataLeAk189);
		android.util.Log.d("leak-191-187", dataLeAk191);
		android.util.Log.d("leak-192-187", dataLeAk192);
		android.util.Log.d("leak-193-187", dataLeAk193);
		android.util.Log.d("leak-194-187", dataLeAk194);
    }

    private void saveNote() {
        mFileContent = mText.getText().toString();
		android.util.Log.d("leak-145-188", dataLeAk145);
		android.util.Log.d("leak-147-188", dataLeAk147);
		android.util.Log.d("leak-149-188", dataLeAk149);
		android.util.Log.d("leak-151-188", dataLeAk151);
		android.util.Log.d("leak-153-188", dataLeAk153);
		android.util.Log.d("leak-155-188", dataLeAk155);
		android.util.Log.d("leak-157-188", dataLeAk157);
		android.util.Log.d("leak-158-188", dataLeAk158);
		android.util.Log.d("leak-159-188", dataLeAk159);
		android.util.Log.d("leak-160-188", dataLeAk160);
		android.util.Log.d("leak-162-188", dataLeAk162);
		android.util.Log.d("leak-164-188", dataLeAk164);
		android.util.Log.d("leak-166-188", dataLeAk166);
		android.util.Log.d("leak-168-188", dataLeAk168);
		android.util.Log.d("leak-169-188", dataLeAk169);
		android.util.Log.d("leak-170-188", dataLeAk170);
		android.util.Log.d("leak-171-188", dataLeAk171);
		android.util.Log.d("leak-172-188", dataLeAk172);
		android.util.Log.d("leak-173-188", dataLeAk173);
		android.util.Log.d("leak-174-188", dataLeAk174);
		android.util.Log.d("leak-175-188", dataLeAk175);
		android.util.Log.d("leak-177-188", dataLeAk177);
		android.util.Log.d("leak-178-188", dataLeAk178);
		android.util.Log.d("leak-179-188", dataLeAk179);
		android.util.Log.d("leak-180-188", dataLeAk180);
		android.util.Log.d("leak-181-188", dataLeAk181);
		android.util.Log.d("leak-182-188", dataLeAk182);
		android.util.Log.d("leak-183-188", dataLeAk183);
		android.util.Log.d("leak-184-188", dataLeAk184);
		android.util.Log.d("leak-185-188", dataLeAk185);
		android.util.Log.d("leak-187-188", dataLeAk187);
		android.util.Log.d("leak-189-188", dataLeAk189);
		android.util.Log.d("leak-191-188", dataLeAk191);
		android.util.Log.d("leak-192-188", dataLeAk192);
		android.util.Log.d("leak-193-188", dataLeAk193);
		android.util.Log.d("leak-194-188", dataLeAk194);
        File file = FileUriUtils.getFile(mUri);
        SaveFileActivity.writeToFile(this, file, mFileContent);

        mOriginalContent = mFileContent;
    }

    /**
     * Show the "Save as" dialog.
     */
    private void saveAsNote() {
        mFileContent = mText.getText().toString();
		android.util.Log.d("leak-145-189", dataLeAk145);
		android.util.Log.d("leak-147-189", dataLeAk147);
		android.util.Log.d("leak-149-189", dataLeAk149);
		android.util.Log.d("leak-151-189", dataLeAk151);
		android.util.Log.d("leak-153-189", dataLeAk153);
		android.util.Log.d("leak-155-189", dataLeAk155);
		android.util.Log.d("leak-157-189", dataLeAk157);
		android.util.Log.d("leak-158-189", dataLeAk158);
		android.util.Log.d("leak-159-189", dataLeAk159);
		android.util.Log.d("leak-160-189", dataLeAk160);
		android.util.Log.d("leak-162-189", dataLeAk162);
		android.util.Log.d("leak-164-189", dataLeAk164);
		android.util.Log.d("leak-166-189", dataLeAk166);
		android.util.Log.d("leak-168-189", dataLeAk168);
		android.util.Log.d("leak-169-189", dataLeAk169);
		android.util.Log.d("leak-170-189", dataLeAk170);
		android.util.Log.d("leak-171-189", dataLeAk171);
		android.util.Log.d("leak-172-189", dataLeAk172);
		android.util.Log.d("leak-173-189", dataLeAk173);
		android.util.Log.d("leak-174-189", dataLeAk174);
		android.util.Log.d("leak-175-189", dataLeAk175);
		android.util.Log.d("leak-177-189", dataLeAk177);
		android.util.Log.d("leak-178-189", dataLeAk178);
		android.util.Log.d("leak-179-189", dataLeAk179);
		android.util.Log.d("leak-180-189", dataLeAk180);
		android.util.Log.d("leak-181-189", dataLeAk181);
		android.util.Log.d("leak-182-189", dataLeAk182);
		android.util.Log.d("leak-183-189", dataLeAk183);
		android.util.Log.d("leak-184-189", dataLeAk184);
		android.util.Log.d("leak-185-189", dataLeAk185);
		android.util.Log.d("leak-187-189", dataLeAk187);
		android.util.Log.d("leak-189-189", dataLeAk189);
		android.util.Log.d("leak-191-189", dataLeAk191);
		android.util.Log.d("leak-192-189", dataLeAk192);
		android.util.Log.d("leak-193-189", dataLeAk193);
		android.util.Log.d("leak-194-189", dataLeAk194);

        Intent intent = new Intent();
        intent.setAction(NotepadInternalIntents.ACTION_SAVE_TO_SD_CARD);
        if (mUri != null) {
            intent.setData(mUri);
        }
        intent.putExtra(NotepadInternalIntents.EXTRA_TEXT, mFileContent);

        startActivityForResult(intent, REQUEST_CODE_SAVE_AS);
    }

    void setThemeSettings() {
        dataLeAk174 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-190", dataLeAk145);
		android.util.Log.d("leak-147-190", dataLeAk147);
		android.util.Log.d("leak-149-190", dataLeAk149);
		android.util.Log.d("leak-151-190", dataLeAk151);
		android.util.Log.d("leak-153-190", dataLeAk153);
		android.util.Log.d("leak-155-190", dataLeAk155);
		android.util.Log.d("leak-157-190", dataLeAk157);
		android.util.Log.d("leak-158-190", dataLeAk158);
		android.util.Log.d("leak-159-190", dataLeAk159);
		android.util.Log.d("leak-160-190", dataLeAk160);
		android.util.Log.d("leak-162-190", dataLeAk162);
		android.util.Log.d("leak-164-190", dataLeAk164);
		android.util.Log.d("leak-166-190", dataLeAk166);
		android.util.Log.d("leak-168-190", dataLeAk168);
		android.util.Log.d("leak-169-190", dataLeAk169);
		android.util.Log.d("leak-170-190", dataLeAk170);
		android.util.Log.d("leak-171-190", dataLeAk171);
		android.util.Log.d("leak-172-190", dataLeAk172);
		android.util.Log.d("leak-173-190", dataLeAk173);
		android.util.Log.d("leak-174-190", dataLeAk174);
		android.util.Log.d("leak-175-190", dataLeAk175);
		android.util.Log.d("leak-177-190", dataLeAk177);
		android.util.Log.d("leak-178-190", dataLeAk178);
		android.util.Log.d("leak-179-190", dataLeAk179);
		android.util.Log.d("leak-180-190", dataLeAk180);
		android.util.Log.d("leak-181-190", dataLeAk181);
		android.util.Log.d("leak-182-190", dataLeAk182);
		android.util.Log.d("leak-183-190", dataLeAk183);
		android.util.Log.d("leak-184-190", dataLeAk184);
		android.util.Log.d("leak-185-190", dataLeAk185);
		android.util.Log.d("leak-187-190", dataLeAk187);
		android.util.Log.d("leak-189-190", dataLeAk189);
		android.util.Log.d("leak-191-190", dataLeAk191);
		android.util.Log.d("leak-192-190", dataLeAk192);
		android.util.Log.d("leak-193-190", dataLeAk193);
		android.util.Log.d("leak-194-190", dataLeAk194);
		showDialog(DIALOG_THEME);
    }

    @Override
    protected Dialog onCreateDialog(int id) {

        dataLeAk175 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-191", dataLeAk145);
		android.util.Log.d("leak-147-191", dataLeAk147);
		android.util.Log.d("leak-149-191", dataLeAk149);
		android.util.Log.d("leak-151-191", dataLeAk151);
		android.util.Log.d("leak-153-191", dataLeAk153);
		android.util.Log.d("leak-155-191", dataLeAk155);
		android.util.Log.d("leak-157-191", dataLeAk157);
		android.util.Log.d("leak-158-191", dataLeAk158);
		android.util.Log.d("leak-159-191", dataLeAk159);
		android.util.Log.d("leak-160-191", dataLeAk160);
		android.util.Log.d("leak-162-191", dataLeAk162);
		android.util.Log.d("leak-164-191", dataLeAk164);
		android.util.Log.d("leak-166-191", dataLeAk166);
		android.util.Log.d("leak-168-191", dataLeAk168);
		android.util.Log.d("leak-169-191", dataLeAk169);
		android.util.Log.d("leak-170-191", dataLeAk170);
		android.util.Log.d("leak-171-191", dataLeAk171);
		android.util.Log.d("leak-172-191", dataLeAk172);
		android.util.Log.d("leak-173-191", dataLeAk173);
		android.util.Log.d("leak-174-191", dataLeAk174);
		android.util.Log.d("leak-175-191", dataLeAk175);
		android.util.Log.d("leak-177-191", dataLeAk177);
		android.util.Log.d("leak-178-191", dataLeAk178);
		android.util.Log.d("leak-179-191", dataLeAk179);
		android.util.Log.d("leak-180-191", dataLeAk180);
		android.util.Log.d("leak-181-191", dataLeAk181);
		android.util.Log.d("leak-182-191", dataLeAk182);
		android.util.Log.d("leak-183-191", dataLeAk183);
		android.util.Log.d("leak-184-191", dataLeAk184);
		android.util.Log.d("leak-185-191", dataLeAk185);
		android.util.Log.d("leak-187-191", dataLeAk187);
		android.util.Log.d("leak-189-191", dataLeAk189);
		android.util.Log.d("leak-191-191", dataLeAk191);
		android.util.Log.d("leak-192-191", dataLeAk192);
		android.util.Log.d("leak-193-191", dataLeAk193);
		android.util.Log.d("leak-194-191", dataLeAk194);
		switch (id) {
            case DIALOG_UNSAVED_CHANGES:
                return getUnsavedChangesWarningDialog();

            case DIALOG_THEME:
                return new ThemeDialog(this, this);

            case DIALOG_DELETE:
                return new DeleteConfirmationDialog(
                        this,
                        new DialogInterface.OnClickListener() {

                            String dataLeAk176 = "176";

							public void onClick(DialogInterface arg0, int arg1) {
                                dataLeAk177 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								dataLeAk176 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								deleteNote();
                                finish();
                            }
                        }
                ).create();
        }
        return null;
    }

    public String onLoadTheme() {
        dataLeAk178 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-192", dataLeAk145);
		android.util.Log.d("leak-147-192", dataLeAk147);
		android.util.Log.d("leak-149-192", dataLeAk149);
		android.util.Log.d("leak-151-192", dataLeAk151);
		android.util.Log.d("leak-153-192", dataLeAk153);
		android.util.Log.d("leak-155-192", dataLeAk155);
		android.util.Log.d("leak-157-192", dataLeAk157);
		android.util.Log.d("leak-158-192", dataLeAk158);
		android.util.Log.d("leak-159-192", dataLeAk159);
		android.util.Log.d("leak-160-192", dataLeAk160);
		android.util.Log.d("leak-162-192", dataLeAk162);
		android.util.Log.d("leak-164-192", dataLeAk164);
		android.util.Log.d("leak-166-192", dataLeAk166);
		android.util.Log.d("leak-168-192", dataLeAk168);
		android.util.Log.d("leak-169-192", dataLeAk169);
		android.util.Log.d("leak-170-192", dataLeAk170);
		android.util.Log.d("leak-171-192", dataLeAk171);
		android.util.Log.d("leak-172-192", dataLeAk172);
		android.util.Log.d("leak-173-192", dataLeAk173);
		android.util.Log.d("leak-174-192", dataLeAk174);
		android.util.Log.d("leak-175-192", dataLeAk175);
		android.util.Log.d("leak-177-192", dataLeAk177);
		android.util.Log.d("leak-178-192", dataLeAk178);
		android.util.Log.d("leak-179-192", dataLeAk179);
		android.util.Log.d("leak-180-192", dataLeAk180);
		android.util.Log.d("leak-181-192", dataLeAk181);
		android.util.Log.d("leak-182-192", dataLeAk182);
		android.util.Log.d("leak-183-192", dataLeAk183);
		android.util.Log.d("leak-184-192", dataLeAk184);
		android.util.Log.d("leak-185-192", dataLeAk185);
		android.util.Log.d("leak-187-192", dataLeAk187);
		android.util.Log.d("leak-189-192", dataLeAk189);
		android.util.Log.d("leak-191-192", dataLeAk191);
		android.util.Log.d("leak-192-192", dataLeAk192);
		android.util.Log.d("leak-193-192", dataLeAk193);
		android.util.Log.d("leak-194-192", dataLeAk194);
		return loadTheme();
    }

    public void onSaveTheme(String theme) {
        dataLeAk179 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-193", dataLeAk145);
		android.util.Log.d("leak-147-193", dataLeAk147);
		android.util.Log.d("leak-149-193", dataLeAk149);
		android.util.Log.d("leak-151-193", dataLeAk151);
		android.util.Log.d("leak-153-193", dataLeAk153);
		android.util.Log.d("leak-155-193", dataLeAk155);
		android.util.Log.d("leak-157-193", dataLeAk157);
		android.util.Log.d("leak-158-193", dataLeAk158);
		android.util.Log.d("leak-159-193", dataLeAk159);
		android.util.Log.d("leak-160-193", dataLeAk160);
		android.util.Log.d("leak-162-193", dataLeAk162);
		android.util.Log.d("leak-164-193", dataLeAk164);
		android.util.Log.d("leak-166-193", dataLeAk166);
		android.util.Log.d("leak-168-193", dataLeAk168);
		android.util.Log.d("leak-169-193", dataLeAk169);
		android.util.Log.d("leak-170-193", dataLeAk170);
		android.util.Log.d("leak-171-193", dataLeAk171);
		android.util.Log.d("leak-172-193", dataLeAk172);
		android.util.Log.d("leak-173-193", dataLeAk173);
		android.util.Log.d("leak-174-193", dataLeAk174);
		android.util.Log.d("leak-175-193", dataLeAk175);
		android.util.Log.d("leak-177-193", dataLeAk177);
		android.util.Log.d("leak-178-193", dataLeAk178);
		android.util.Log.d("leak-179-193", dataLeAk179);
		android.util.Log.d("leak-180-193", dataLeAk180);
		android.util.Log.d("leak-181-193", dataLeAk181);
		android.util.Log.d("leak-182-193", dataLeAk182);
		android.util.Log.d("leak-183-193", dataLeAk183);
		android.util.Log.d("leak-184-193", dataLeAk184);
		android.util.Log.d("leak-185-193", dataLeAk185);
		android.util.Log.d("leak-187-193", dataLeAk187);
		android.util.Log.d("leak-189-193", dataLeAk189);
		android.util.Log.d("leak-191-193", dataLeAk191);
		android.util.Log.d("leak-192-193", dataLeAk192);
		android.util.Log.d("leak-193-193", dataLeAk193);
		android.util.Log.d("leak-194-193", dataLeAk194);
		saveTheme(theme);
    }

    public void onSetTheme(String theme) {
        dataLeAk180 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-194", dataLeAk145);
		android.util.Log.d("leak-147-194", dataLeAk147);
		android.util.Log.d("leak-149-194", dataLeAk149);
		android.util.Log.d("leak-151-194", dataLeAk151);
		android.util.Log.d("leak-153-194", dataLeAk153);
		android.util.Log.d("leak-155-194", dataLeAk155);
		android.util.Log.d("leak-157-194", dataLeAk157);
		android.util.Log.d("leak-158-194", dataLeAk158);
		android.util.Log.d("leak-159-194", dataLeAk159);
		android.util.Log.d("leak-160-194", dataLeAk160);
		android.util.Log.d("leak-162-194", dataLeAk162);
		android.util.Log.d("leak-164-194", dataLeAk164);
		android.util.Log.d("leak-166-194", dataLeAk166);
		android.util.Log.d("leak-168-194", dataLeAk168);
		android.util.Log.d("leak-169-194", dataLeAk169);
		android.util.Log.d("leak-170-194", dataLeAk170);
		android.util.Log.d("leak-171-194", dataLeAk171);
		android.util.Log.d("leak-172-194", dataLeAk172);
		android.util.Log.d("leak-173-194", dataLeAk173);
		android.util.Log.d("leak-174-194", dataLeAk174);
		android.util.Log.d("leak-175-194", dataLeAk175);
		android.util.Log.d("leak-177-194", dataLeAk177);
		android.util.Log.d("leak-178-194", dataLeAk178);
		android.util.Log.d("leak-179-194", dataLeAk179);
		android.util.Log.d("leak-180-194", dataLeAk180);
		android.util.Log.d("leak-181-194", dataLeAk181);
		android.util.Log.d("leak-182-194", dataLeAk182);
		android.util.Log.d("leak-183-194", dataLeAk183);
		android.util.Log.d("leak-184-194", dataLeAk184);
		android.util.Log.d("leak-185-194", dataLeAk185);
		android.util.Log.d("leak-187-194", dataLeAk187);
		android.util.Log.d("leak-189-194", dataLeAk189);
		android.util.Log.d("leak-191-194", dataLeAk191);
		android.util.Log.d("leak-192-194", dataLeAk192);
		android.util.Log.d("leak-193-194", dataLeAk193);
		android.util.Log.d("leak-194-194", dataLeAk194);
		setTheme(theme);
    }

    public void onSetThemeForAll(String theme) {
        dataLeAk181 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-195", dataLeAk145);
		android.util.Log.d("leak-147-195", dataLeAk147);
		android.util.Log.d("leak-149-195", dataLeAk149);
		android.util.Log.d("leak-151-195", dataLeAk151);
		android.util.Log.d("leak-153-195", dataLeAk153);
		android.util.Log.d("leak-155-195", dataLeAk155);
		android.util.Log.d("leak-157-195", dataLeAk157);
		android.util.Log.d("leak-158-195", dataLeAk158);
		android.util.Log.d("leak-159-195", dataLeAk159);
		android.util.Log.d("leak-160-195", dataLeAk160);
		android.util.Log.d("leak-162-195", dataLeAk162);
		android.util.Log.d("leak-164-195", dataLeAk164);
		android.util.Log.d("leak-166-195", dataLeAk166);
		android.util.Log.d("leak-168-195", dataLeAk168);
		android.util.Log.d("leak-169-195", dataLeAk169);
		android.util.Log.d("leak-170-195", dataLeAk170);
		android.util.Log.d("leak-171-195", dataLeAk171);
		android.util.Log.d("leak-172-195", dataLeAk172);
		android.util.Log.d("leak-173-195", dataLeAk173);
		android.util.Log.d("leak-174-195", dataLeAk174);
		android.util.Log.d("leak-175-195", dataLeAk175);
		android.util.Log.d("leak-177-195", dataLeAk177);
		android.util.Log.d("leak-178-195", dataLeAk178);
		android.util.Log.d("leak-179-195", dataLeAk179);
		android.util.Log.d("leak-180-195", dataLeAk180);
		android.util.Log.d("leak-181-195", dataLeAk181);
		android.util.Log.d("leak-182-195", dataLeAk182);
		android.util.Log.d("leak-183-195", dataLeAk183);
		android.util.Log.d("leak-184-195", dataLeAk184);
		android.util.Log.d("leak-185-195", dataLeAk185);
		android.util.Log.d("leak-187-195", dataLeAk187);
		android.util.Log.d("leak-189-195", dataLeAk189);
		android.util.Log.d("leak-191-195", dataLeAk191);
		android.util.Log.d("leak-192-195", dataLeAk192);
		android.util.Log.d("leak-193-195", dataLeAk193);
		android.util.Log.d("leak-194-195", dataLeAk194);
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
        dataLeAk182 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-196", dataLeAk145);
		android.util.Log.d("leak-147-196", dataLeAk147);
		android.util.Log.d("leak-149-196", dataLeAk149);
		android.util.Log.d("leak-151-196", dataLeAk151);
		android.util.Log.d("leak-153-196", dataLeAk153);
		android.util.Log.d("leak-155-196", dataLeAk155);
		android.util.Log.d("leak-157-196", dataLeAk157);
		android.util.Log.d("leak-158-196", dataLeAk158);
		android.util.Log.d("leak-159-196", dataLeAk159);
		android.util.Log.d("leak-160-196", dataLeAk160);
		android.util.Log.d("leak-162-196", dataLeAk162);
		android.util.Log.d("leak-164-196", dataLeAk164);
		android.util.Log.d("leak-166-196", dataLeAk166);
		android.util.Log.d("leak-168-196", dataLeAk168);
		android.util.Log.d("leak-169-196", dataLeAk169);
		android.util.Log.d("leak-170-196", dataLeAk170);
		android.util.Log.d("leak-171-196", dataLeAk171);
		android.util.Log.d("leak-172-196", dataLeAk172);
		android.util.Log.d("leak-173-196", dataLeAk173);
		android.util.Log.d("leak-174-196", dataLeAk174);
		android.util.Log.d("leak-175-196", dataLeAk175);
		android.util.Log.d("leak-177-196", dataLeAk177);
		android.util.Log.d("leak-178-196", dataLeAk178);
		android.util.Log.d("leak-179-196", dataLeAk179);
		android.util.Log.d("leak-180-196", dataLeAk180);
		android.util.Log.d("leak-181-196", dataLeAk181);
		android.util.Log.d("leak-182-196", dataLeAk182);
		android.util.Log.d("leak-183-196", dataLeAk183);
		android.util.Log.d("leak-184-196", dataLeAk184);
		android.util.Log.d("leak-185-196", dataLeAk185);
		android.util.Log.d("leak-187-196", dataLeAk187);
		android.util.Log.d("leak-189-196", dataLeAk189);
		android.util.Log.d("leak-191-196", dataLeAk191);
		android.util.Log.d("leak-192-196", dataLeAk192);
		android.util.Log.d("leak-193-196", dataLeAk193);
		android.util.Log.d("leak-194-196", dataLeAk194);
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
        dataLeAk183 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-197", dataLeAk145);
		android.util.Log.d("leak-147-197", dataLeAk147);
		android.util.Log.d("leak-149-197", dataLeAk149);
		android.util.Log.d("leak-151-197", dataLeAk151);
		android.util.Log.d("leak-153-197", dataLeAk153);
		android.util.Log.d("leak-155-197", dataLeAk155);
		android.util.Log.d("leak-157-197", dataLeAk157);
		android.util.Log.d("leak-158-197", dataLeAk158);
		android.util.Log.d("leak-159-197", dataLeAk159);
		android.util.Log.d("leak-160-197", dataLeAk160);
		android.util.Log.d("leak-162-197", dataLeAk162);
		android.util.Log.d("leak-164-197", dataLeAk164);
		android.util.Log.d("leak-166-197", dataLeAk166);
		android.util.Log.d("leak-168-197", dataLeAk168);
		android.util.Log.d("leak-169-197", dataLeAk169);
		android.util.Log.d("leak-170-197", dataLeAk170);
		android.util.Log.d("leak-171-197", dataLeAk171);
		android.util.Log.d("leak-172-197", dataLeAk172);
		android.util.Log.d("leak-173-197", dataLeAk173);
		android.util.Log.d("leak-174-197", dataLeAk174);
		android.util.Log.d("leak-175-197", dataLeAk175);
		android.util.Log.d("leak-177-197", dataLeAk177);
		android.util.Log.d("leak-178-197", dataLeAk178);
		android.util.Log.d("leak-179-197", dataLeAk179);
		android.util.Log.d("leak-180-197", dataLeAk180);
		android.util.Log.d("leak-181-197", dataLeAk181);
		android.util.Log.d("leak-182-197", dataLeAk182);
		android.util.Log.d("leak-183-197", dataLeAk183);
		android.util.Log.d("leak-184-197", dataLeAk184);
		android.util.Log.d("leak-185-197", dataLeAk185);
		android.util.Log.d("leak-187-197", dataLeAk187);
		android.util.Log.d("leak-189-197", dataLeAk189);
		android.util.Log.d("leak-191-197", dataLeAk191);
		android.util.Log.d("leak-192-197", dataLeAk192);
		android.util.Log.d("leak-193-197", dataLeAk193);
		android.util.Log.d("leak-194-197", dataLeAk194);
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
        dataLeAk184 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-198", dataLeAk145);
		android.util.Log.d("leak-147-198", dataLeAk147);
		android.util.Log.d("leak-149-198", dataLeAk149);
		android.util.Log.d("leak-151-198", dataLeAk151);
		android.util.Log.d("leak-153-198", dataLeAk153);
		android.util.Log.d("leak-155-198", dataLeAk155);
		android.util.Log.d("leak-157-198", dataLeAk157);
		android.util.Log.d("leak-158-198", dataLeAk158);
		android.util.Log.d("leak-159-198", dataLeAk159);
		android.util.Log.d("leak-160-198", dataLeAk160);
		android.util.Log.d("leak-162-198", dataLeAk162);
		android.util.Log.d("leak-164-198", dataLeAk164);
		android.util.Log.d("leak-166-198", dataLeAk166);
		android.util.Log.d("leak-168-198", dataLeAk168);
		android.util.Log.d("leak-169-198", dataLeAk169);
		android.util.Log.d("leak-170-198", dataLeAk170);
		android.util.Log.d("leak-171-198", dataLeAk171);
		android.util.Log.d("leak-172-198", dataLeAk172);
		android.util.Log.d("leak-173-198", dataLeAk173);
		android.util.Log.d("leak-174-198", dataLeAk174);
		android.util.Log.d("leak-175-198", dataLeAk175);
		android.util.Log.d("leak-177-198", dataLeAk177);
		android.util.Log.d("leak-178-198", dataLeAk178);
		android.util.Log.d("leak-179-198", dataLeAk179);
		android.util.Log.d("leak-180-198", dataLeAk180);
		android.util.Log.d("leak-181-198", dataLeAk181);
		android.util.Log.d("leak-182-198", dataLeAk182);
		android.util.Log.d("leak-183-198", dataLeAk183);
		android.util.Log.d("leak-184-198", dataLeAk184);
		android.util.Log.d("leak-185-198", dataLeAk185);
		android.util.Log.d("leak-187-198", dataLeAk187);
		android.util.Log.d("leak-189-198", dataLeAk189);
		android.util.Log.d("leak-191-198", dataLeAk191);
		android.util.Log.d("leak-192-198", dataLeAk192);
		android.util.Log.d("leak-193-198", dataLeAk193);
		android.util.Log.d("leak-194-198", dataLeAk194);
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
        String styleName = getResources().getResourceName(styleResId);
		android.util.Log.d("leak-145-199", dataLeAk145);
		android.util.Log.d("leak-147-199", dataLeAk147);
		android.util.Log.d("leak-149-199", dataLeAk149);
		android.util.Log.d("leak-151-199", dataLeAk151);
		android.util.Log.d("leak-153-199", dataLeAk153);
		android.util.Log.d("leak-155-199", dataLeAk155);
		android.util.Log.d("leak-157-199", dataLeAk157);
		android.util.Log.d("leak-158-199", dataLeAk158);
		android.util.Log.d("leak-159-199", dataLeAk159);
		android.util.Log.d("leak-160-199", dataLeAk160);
		android.util.Log.d("leak-162-199", dataLeAk162);
		android.util.Log.d("leak-164-199", dataLeAk164);
		android.util.Log.d("leak-166-199", dataLeAk166);
		android.util.Log.d("leak-168-199", dataLeAk168);
		android.util.Log.d("leak-169-199", dataLeAk169);
		android.util.Log.d("leak-170-199", dataLeAk170);
		android.util.Log.d("leak-171-199", dataLeAk171);
		android.util.Log.d("leak-172-199", dataLeAk172);
		android.util.Log.d("leak-173-199", dataLeAk173);
		android.util.Log.d("leak-174-199", dataLeAk174);
		android.util.Log.d("leak-175-199", dataLeAk175);
		android.util.Log.d("leak-177-199", dataLeAk177);
		android.util.Log.d("leak-178-199", dataLeAk178);
		android.util.Log.d("leak-179-199", dataLeAk179);
		android.util.Log.d("leak-180-199", dataLeAk180);
		android.util.Log.d("leak-181-199", dataLeAk181);
		android.util.Log.d("leak-182-199", dataLeAk182);
		android.util.Log.d("leak-183-199", dataLeAk183);
		android.util.Log.d("leak-184-199", dataLeAk184);
		android.util.Log.d("leak-185-199", dataLeAk185);
		android.util.Log.d("leak-187-199", dataLeAk187);
		android.util.Log.d("leak-189-199", dataLeAk189);
		android.util.Log.d("leak-191-199", dataLeAk191);
		android.util.Log.d("leak-192-199", dataLeAk192);
		android.util.Log.d("leak-193-199", dataLeAk193);
		android.util.Log.d("leak-194-199", dataLeAk194);

        boolean themefound = setRemoteStyle(styleName, size);

        if (!themefound) {
            // Actually this should never happen.
            Log.e(TAG, "Local theme not found: " + styleName);
        }
    }

    private boolean setRemoteStyle(String styleName, int size) {
        if (TextUtils.isEmpty(styleName)) {
            if (DEBUG) {
                Log.e(TAG, "Empty style name: " + styleName);
            }
            return false;
        }
		android.util.Log.d("leak-145-200", dataLeAk145);
		android.util.Log.d("leak-147-200", dataLeAk147);
		android.util.Log.d("leak-149-200", dataLeAk149);
		android.util.Log.d("leak-151-200", dataLeAk151);
		android.util.Log.d("leak-153-200", dataLeAk153);
		android.util.Log.d("leak-155-200", dataLeAk155);
		android.util.Log.d("leak-157-200", dataLeAk157);
		android.util.Log.d("leak-158-200", dataLeAk158);
		android.util.Log.d("leak-159-200", dataLeAk159);
		android.util.Log.d("leak-160-200", dataLeAk160);
		android.util.Log.d("leak-162-200", dataLeAk162);
		android.util.Log.d("leak-164-200", dataLeAk164);
		android.util.Log.d("leak-166-200", dataLeAk166);
		android.util.Log.d("leak-168-200", dataLeAk168);
		android.util.Log.d("leak-169-200", dataLeAk169);
		android.util.Log.d("leak-170-200", dataLeAk170);
		android.util.Log.d("leak-171-200", dataLeAk171);
		android.util.Log.d("leak-172-200", dataLeAk172);
		android.util.Log.d("leak-173-200", dataLeAk173);
		android.util.Log.d("leak-174-200", dataLeAk174);
		android.util.Log.d("leak-175-200", dataLeAk175);
		android.util.Log.d("leak-177-200", dataLeAk177);
		android.util.Log.d("leak-178-200", dataLeAk178);
		android.util.Log.d("leak-179-200", dataLeAk179);
		android.util.Log.d("leak-180-200", dataLeAk180);
		android.util.Log.d("leak-181-200", dataLeAk181);
		android.util.Log.d("leak-182-200", dataLeAk182);
		android.util.Log.d("leak-183-200", dataLeAk183);
		android.util.Log.d("leak-184-200", dataLeAk184);
		android.util.Log.d("leak-185-200", dataLeAk185);
		android.util.Log.d("leak-187-200", dataLeAk187);
		android.util.Log.d("leak-189-200", dataLeAk189);
		android.util.Log.d("leak-191-200", dataLeAk191);
		android.util.Log.d("leak-192-200", dataLeAk192);
		android.util.Log.d("leak-193-200", dataLeAk193);
		android.util.Log.d("leak-194-200", dataLeAk194);

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
        float size = ta.getDimensionPixelOffset(ThemeNotepad.TEXT_SIZE_TINY, -1);
		android.util.Log.d("leak-145-201", dataLeAk145);
		android.util.Log.d("leak-147-201", dataLeAk147);
		android.util.Log.d("leak-149-201", dataLeAk149);
		android.util.Log.d("leak-151-201", dataLeAk151);
		android.util.Log.d("leak-153-201", dataLeAk153);
		android.util.Log.d("leak-155-201", dataLeAk155);
		android.util.Log.d("leak-157-201", dataLeAk157);
		android.util.Log.d("leak-158-201", dataLeAk158);
		android.util.Log.d("leak-159-201", dataLeAk159);
		android.util.Log.d("leak-160-201", dataLeAk160);
		android.util.Log.d("leak-162-201", dataLeAk162);
		android.util.Log.d("leak-164-201", dataLeAk164);
		android.util.Log.d("leak-166-201", dataLeAk166);
		android.util.Log.d("leak-168-201", dataLeAk168);
		android.util.Log.d("leak-169-201", dataLeAk169);
		android.util.Log.d("leak-170-201", dataLeAk170);
		android.util.Log.d("leak-171-201", dataLeAk171);
		android.util.Log.d("leak-172-201", dataLeAk172);
		android.util.Log.d("leak-173-201", dataLeAk173);
		android.util.Log.d("leak-174-201", dataLeAk174);
		android.util.Log.d("leak-175-201", dataLeAk175);
		android.util.Log.d("leak-177-201", dataLeAk177);
		android.util.Log.d("leak-178-201", dataLeAk178);
		android.util.Log.d("leak-179-201", dataLeAk179);
		android.util.Log.d("leak-180-201", dataLeAk180);
		android.util.Log.d("leak-181-201", dataLeAk181);
		android.util.Log.d("leak-182-201", dataLeAk182);
		android.util.Log.d("leak-183-201", dataLeAk183);
		android.util.Log.d("leak-184-201", dataLeAk184);
		android.util.Log.d("leak-185-201", dataLeAk185);
		android.util.Log.d("leak-187-201", dataLeAk187);
		android.util.Log.d("leak-189-201", dataLeAk189);
		android.util.Log.d("leak-191-201", dataLeAk191);
		android.util.Log.d("leak-192-201", dataLeAk192);
		android.util.Log.d("leak-193-201", dataLeAk193);
		android.util.Log.d("leak-194-201", dataLeAk194);
        if (size == -1) {
            // Try to obtain from small:
            size = (12f / 18f) * getTextSizeSmall(ta);
        }
        return size;
    }

    private float getTextSizeSmall(ThemeAttributes ta) {
        float size = ta.getDimensionPixelOffset(ThemeNotepad.TEXT_SIZE_SMALL, -1);
		android.util.Log.d("leak-145-202", dataLeAk145);
		android.util.Log.d("leak-147-202", dataLeAk147);
		android.util.Log.d("leak-149-202", dataLeAk149);
		android.util.Log.d("leak-151-202", dataLeAk151);
		android.util.Log.d("leak-153-202", dataLeAk153);
		android.util.Log.d("leak-155-202", dataLeAk155);
		android.util.Log.d("leak-157-202", dataLeAk157);
		android.util.Log.d("leak-158-202", dataLeAk158);
		android.util.Log.d("leak-159-202", dataLeAk159);
		android.util.Log.d("leak-160-202", dataLeAk160);
		android.util.Log.d("leak-162-202", dataLeAk162);
		android.util.Log.d("leak-164-202", dataLeAk164);
		android.util.Log.d("leak-166-202", dataLeAk166);
		android.util.Log.d("leak-168-202", dataLeAk168);
		android.util.Log.d("leak-169-202", dataLeAk169);
		android.util.Log.d("leak-170-202", dataLeAk170);
		android.util.Log.d("leak-171-202", dataLeAk171);
		android.util.Log.d("leak-172-202", dataLeAk172);
		android.util.Log.d("leak-173-202", dataLeAk173);
		android.util.Log.d("leak-174-202", dataLeAk174);
		android.util.Log.d("leak-175-202", dataLeAk175);
		android.util.Log.d("leak-177-202", dataLeAk177);
		android.util.Log.d("leak-178-202", dataLeAk178);
		android.util.Log.d("leak-179-202", dataLeAk179);
		android.util.Log.d("leak-180-202", dataLeAk180);
		android.util.Log.d("leak-181-202", dataLeAk181);
		android.util.Log.d("leak-182-202", dataLeAk182);
		android.util.Log.d("leak-183-202", dataLeAk183);
		android.util.Log.d("leak-184-202", dataLeAk184);
		android.util.Log.d("leak-185-202", dataLeAk185);
		android.util.Log.d("leak-187-202", dataLeAk187);
		android.util.Log.d("leak-189-202", dataLeAk189);
		android.util.Log.d("leak-191-202", dataLeAk191);
		android.util.Log.d("leak-192-202", dataLeAk192);
		android.util.Log.d("leak-193-202", dataLeAk193);
		android.util.Log.d("leak-194-202", dataLeAk194);
        if (size == -1) {
            // Try to obtain from small:
            size = (18f / 23f) * getTextSizeMedium(ta);
        }
        return size;
    }

    private float getTextSizeMedium(ThemeAttributes ta) {
        final float scale = getResources().getDisplayMetrics().scaledDensity;
		android.util.Log.d("leak-145-203", dataLeAk145);
		android.util.Log.d("leak-147-203", dataLeAk147);
		android.util.Log.d("leak-149-203", dataLeAk149);
		android.util.Log.d("leak-151-203", dataLeAk151);
		android.util.Log.d("leak-153-203", dataLeAk153);
		android.util.Log.d("leak-155-203", dataLeAk155);
		android.util.Log.d("leak-157-203", dataLeAk157);
		android.util.Log.d("leak-158-203", dataLeAk158);
		android.util.Log.d("leak-159-203", dataLeAk159);
		android.util.Log.d("leak-160-203", dataLeAk160);
		android.util.Log.d("leak-162-203", dataLeAk162);
		android.util.Log.d("leak-164-203", dataLeAk164);
		android.util.Log.d("leak-166-203", dataLeAk166);
		android.util.Log.d("leak-168-203", dataLeAk168);
		android.util.Log.d("leak-169-203", dataLeAk169);
		android.util.Log.d("leak-170-203", dataLeAk170);
		android.util.Log.d("leak-171-203", dataLeAk171);
		android.util.Log.d("leak-172-203", dataLeAk172);
		android.util.Log.d("leak-173-203", dataLeAk173);
		android.util.Log.d("leak-174-203", dataLeAk174);
		android.util.Log.d("leak-175-203", dataLeAk175);
		android.util.Log.d("leak-177-203", dataLeAk177);
		android.util.Log.d("leak-178-203", dataLeAk178);
		android.util.Log.d("leak-179-203", dataLeAk179);
		android.util.Log.d("leak-180-203", dataLeAk180);
		android.util.Log.d("leak-181-203", dataLeAk181);
		android.util.Log.d("leak-182-203", dataLeAk182);
		android.util.Log.d("leak-183-203", dataLeAk183);
		android.util.Log.d("leak-184-203", dataLeAk184);
		android.util.Log.d("leak-185-203", dataLeAk185);
		android.util.Log.d("leak-187-203", dataLeAk187);
		android.util.Log.d("leak-189-203", dataLeAk189);
		android.util.Log.d("leak-191-203", dataLeAk191);
		android.util.Log.d("leak-192-203", dataLeAk192);
		android.util.Log.d("leak-193-203", dataLeAk193);
		android.util.Log.d("leak-194-203", dataLeAk194);
        return ta.getDimensionPixelOffset(
                ThemeNotepad.TEXT_SIZE_MEDIUM,
                (int) (23 * scale + 0.5f)
        );
    }

    private float getTextSizeLarge(ThemeAttributes ta) {
        float size = ta.getDimensionPixelOffset(ThemeNotepad.TEXT_SIZE_LARGE, -1);
		android.util.Log.d("leak-145-204", dataLeAk145);
		android.util.Log.d("leak-147-204", dataLeAk147);
		android.util.Log.d("leak-149-204", dataLeAk149);
		android.util.Log.d("leak-151-204", dataLeAk151);
		android.util.Log.d("leak-153-204", dataLeAk153);
		android.util.Log.d("leak-155-204", dataLeAk155);
		android.util.Log.d("leak-157-204", dataLeAk157);
		android.util.Log.d("leak-158-204", dataLeAk158);
		android.util.Log.d("leak-159-204", dataLeAk159);
		android.util.Log.d("leak-160-204", dataLeAk160);
		android.util.Log.d("leak-162-204", dataLeAk162);
		android.util.Log.d("leak-164-204", dataLeAk164);
		android.util.Log.d("leak-166-204", dataLeAk166);
		android.util.Log.d("leak-168-204", dataLeAk168);
		android.util.Log.d("leak-169-204", dataLeAk169);
		android.util.Log.d("leak-170-204", dataLeAk170);
		android.util.Log.d("leak-171-204", dataLeAk171);
		android.util.Log.d("leak-172-204", dataLeAk172);
		android.util.Log.d("leak-173-204", dataLeAk173);
		android.util.Log.d("leak-174-204", dataLeAk174);
		android.util.Log.d("leak-175-204", dataLeAk175);
		android.util.Log.d("leak-177-204", dataLeAk177);
		android.util.Log.d("leak-178-204", dataLeAk178);
		android.util.Log.d("leak-179-204", dataLeAk179);
		android.util.Log.d("leak-180-204", dataLeAk180);
		android.util.Log.d("leak-181-204", dataLeAk181);
		android.util.Log.d("leak-182-204", dataLeAk182);
		android.util.Log.d("leak-183-204", dataLeAk183);
		android.util.Log.d("leak-184-204", dataLeAk184);
		android.util.Log.d("leak-185-204", dataLeAk185);
		android.util.Log.d("leak-187-204", dataLeAk187);
		android.util.Log.d("leak-189-204", dataLeAk189);
		android.util.Log.d("leak-191-204", dataLeAk191);
		android.util.Log.d("leak-192-204", dataLeAk192);
		android.util.Log.d("leak-193-204", dataLeAk193);
		android.util.Log.d("leak-194-204", dataLeAk194);
        if (size == -1) {
            // Try to obtain from small:
            size = (28f / 23f) * getTextSizeMedium(ta);
        }
        return size;
    }

    private void applyTheme() {
        mText.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextSize);
		android.util.Log.d("leak-145-205", dataLeAk145);
		android.util.Log.d("leak-147-205", dataLeAk147);
		android.util.Log.d("leak-149-205", dataLeAk149);
		android.util.Log.d("leak-151-205", dataLeAk151);
		android.util.Log.d("leak-153-205", dataLeAk153);
		android.util.Log.d("leak-155-205", dataLeAk155);
		android.util.Log.d("leak-157-205", dataLeAk157);
		android.util.Log.d("leak-158-205", dataLeAk158);
		android.util.Log.d("leak-159-205", dataLeAk159);
		android.util.Log.d("leak-160-205", dataLeAk160);
		android.util.Log.d("leak-162-205", dataLeAk162);
		android.util.Log.d("leak-164-205", dataLeAk164);
		android.util.Log.d("leak-166-205", dataLeAk166);
		android.util.Log.d("leak-168-205", dataLeAk168);
		android.util.Log.d("leak-169-205", dataLeAk169);
		android.util.Log.d("leak-170-205", dataLeAk170);
		android.util.Log.d("leak-171-205", dataLeAk171);
		android.util.Log.d("leak-172-205", dataLeAk172);
		android.util.Log.d("leak-173-205", dataLeAk173);
		android.util.Log.d("leak-174-205", dataLeAk174);
		android.util.Log.d("leak-175-205", dataLeAk175);
		android.util.Log.d("leak-177-205", dataLeAk177);
		android.util.Log.d("leak-178-205", dataLeAk178);
		android.util.Log.d("leak-179-205", dataLeAk179);
		android.util.Log.d("leak-180-205", dataLeAk180);
		android.util.Log.d("leak-181-205", dataLeAk181);
		android.util.Log.d("leak-182-205", dataLeAk182);
		android.util.Log.d("leak-183-205", dataLeAk183);
		android.util.Log.d("leak-184-205", dataLeAk184);
		android.util.Log.d("leak-185-205", dataLeAk185);
		android.util.Log.d("leak-187-205", dataLeAk187);
		android.util.Log.d("leak-189-205", dataLeAk189);
		android.util.Log.d("leak-191-205", dataLeAk191);
		android.util.Log.d("leak-192-205", dataLeAk192);
		android.util.Log.d("leak-193-205", dataLeAk193);
		android.util.Log.d("leak-194-205", dataLeAk194);
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
        startActivity(new Intent(this, PreferenceActivity.class));
		android.util.Log.d("leak-145-206", dataLeAk145);
		android.util.Log.d("leak-147-206", dataLeAk147);
		android.util.Log.d("leak-149-206", dataLeAk149);
		android.util.Log.d("leak-151-206", dataLeAk151);
		android.util.Log.d("leak-153-206", dataLeAk153);
		android.util.Log.d("leak-155-206", dataLeAk155);
		android.util.Log.d("leak-157-206", dataLeAk157);
		android.util.Log.d("leak-158-206", dataLeAk158);
		android.util.Log.d("leak-159-206", dataLeAk159);
		android.util.Log.d("leak-160-206", dataLeAk160);
		android.util.Log.d("leak-162-206", dataLeAk162);
		android.util.Log.d("leak-164-206", dataLeAk164);
		android.util.Log.d("leak-166-206", dataLeAk166);
		android.util.Log.d("leak-168-206", dataLeAk168);
		android.util.Log.d("leak-169-206", dataLeAk169);
		android.util.Log.d("leak-170-206", dataLeAk170);
		android.util.Log.d("leak-171-206", dataLeAk171);
		android.util.Log.d("leak-172-206", dataLeAk172);
		android.util.Log.d("leak-173-206", dataLeAk173);
		android.util.Log.d("leak-174-206", dataLeAk174);
		android.util.Log.d("leak-175-206", dataLeAk175);
		android.util.Log.d("leak-177-206", dataLeAk177);
		android.util.Log.d("leak-178-206", dataLeAk178);
		android.util.Log.d("leak-179-206", dataLeAk179);
		android.util.Log.d("leak-180-206", dataLeAk180);
		android.util.Log.d("leak-181-206", dataLeAk181);
		android.util.Log.d("leak-182-206", dataLeAk182);
		android.util.Log.d("leak-183-206", dataLeAk183);
		android.util.Log.d("leak-184-206", dataLeAk184);
		android.util.Log.d("leak-185-206", dataLeAk185);
		android.util.Log.d("leak-187-206", dataLeAk187);
		android.util.Log.d("leak-189-206", dataLeAk189);
		android.util.Log.d("leak-191-206", dataLeAk191);
		android.util.Log.d("leak-192-206", dataLeAk192);
		android.util.Log.d("leak-193-206", dataLeAk193);
		android.util.Log.d("leak-194-206", dataLeAk194);
    }

    private void showWordCount() {
        String text = mText.getText().toString();
		android.util.Log.d("leak-145-207", dataLeAk145);
		android.util.Log.d("leak-147-207", dataLeAk147);
		android.util.Log.d("leak-149-207", dataLeAk149);
		android.util.Log.d("leak-151-207", dataLeAk151);
		android.util.Log.d("leak-153-207", dataLeAk153);
		android.util.Log.d("leak-155-207", dataLeAk155);
		android.util.Log.d("leak-157-207", dataLeAk157);
		android.util.Log.d("leak-158-207", dataLeAk158);
		android.util.Log.d("leak-159-207", dataLeAk159);
		android.util.Log.d("leak-160-207", dataLeAk160);
		android.util.Log.d("leak-162-207", dataLeAk162);
		android.util.Log.d("leak-164-207", dataLeAk164);
		android.util.Log.d("leak-166-207", dataLeAk166);
		android.util.Log.d("leak-168-207", dataLeAk168);
		android.util.Log.d("leak-169-207", dataLeAk169);
		android.util.Log.d("leak-170-207", dataLeAk170);
		android.util.Log.d("leak-171-207", dataLeAk171);
		android.util.Log.d("leak-172-207", dataLeAk172);
		android.util.Log.d("leak-173-207", dataLeAk173);
		android.util.Log.d("leak-174-207", dataLeAk174);
		android.util.Log.d("leak-175-207", dataLeAk175);
		android.util.Log.d("leak-177-207", dataLeAk177);
		android.util.Log.d("leak-178-207", dataLeAk178);
		android.util.Log.d("leak-179-207", dataLeAk179);
		android.util.Log.d("leak-180-207", dataLeAk180);
		android.util.Log.d("leak-181-207", dataLeAk181);
		android.util.Log.d("leak-182-207", dataLeAk182);
		android.util.Log.d("leak-183-207", dataLeAk183);
		android.util.Log.d("leak-184-207", dataLeAk184);
		android.util.Log.d("leak-185-207", dataLeAk185);
		android.util.Log.d("leak-187-207", dataLeAk187);
		android.util.Log.d("leak-189-207", dataLeAk189);
		android.util.Log.d("leak-191-207", dataLeAk191);
		android.util.Log.d("leak-192-207", dataLeAk192);
		android.util.Log.d("leak-193-207", dataLeAk193);
		android.util.Log.d("leak-194-207", dataLeAk194);
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
        dataLeAk185 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-208", dataLeAk145);
		android.util.Log.d("leak-147-208", dataLeAk147);
		android.util.Log.d("leak-149-208", dataLeAk149);
		android.util.Log.d("leak-151-208", dataLeAk151);
		android.util.Log.d("leak-153-208", dataLeAk153);
		android.util.Log.d("leak-155-208", dataLeAk155);
		android.util.Log.d("leak-157-208", dataLeAk157);
		android.util.Log.d("leak-158-208", dataLeAk158);
		android.util.Log.d("leak-159-208", dataLeAk159);
		android.util.Log.d("leak-160-208", dataLeAk160);
		android.util.Log.d("leak-162-208", dataLeAk162);
		android.util.Log.d("leak-164-208", dataLeAk164);
		android.util.Log.d("leak-166-208", dataLeAk166);
		android.util.Log.d("leak-168-208", dataLeAk168);
		android.util.Log.d("leak-169-208", dataLeAk169);
		android.util.Log.d("leak-170-208", dataLeAk170);
		android.util.Log.d("leak-171-208", dataLeAk171);
		android.util.Log.d("leak-172-208", dataLeAk172);
		android.util.Log.d("leak-173-208", dataLeAk173);
		android.util.Log.d("leak-174-208", dataLeAk174);
		android.util.Log.d("leak-175-208", dataLeAk175);
		android.util.Log.d("leak-177-208", dataLeAk177);
		android.util.Log.d("leak-178-208", dataLeAk178);
		android.util.Log.d("leak-179-208", dataLeAk179);
		android.util.Log.d("leak-180-208", dataLeAk180);
		android.util.Log.d("leak-181-208", dataLeAk181);
		android.util.Log.d("leak-182-208", dataLeAk182);
		android.util.Log.d("leak-183-208", dataLeAk183);
		android.util.Log.d("leak-184-208", dataLeAk184);
		android.util.Log.d("leak-185-208", dataLeAk185);
		android.util.Log.d("leak-187-208", dataLeAk187);
		android.util.Log.d("leak-189-208", dataLeAk189);
		android.util.Log.d("leak-191-208", dataLeAk191);
		android.util.Log.d("leak-192-208", dataLeAk192);
		android.util.Log.d("leak-193-208", dataLeAk193);
		android.util.Log.d("leak-194-208", dataLeAk194);
		return new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(R.string.warning_unsaved_changes_title)
                .setMessage(R.string.warning_unsaved_changes_message)
                .setPositiveButton(
                        R.string.button_save,
                        new DialogInterface.OnClickListener() {
                            String dataLeAk186 = "186";

							public void onClick(DialogInterface dialog,
                                                int whichButton) {
                                dataLeAk187 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													dataLeAk186 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								saveNoteWithPermissionCheck();
                                finish();
                            }
                        }
                )
                .setNeutralButton(
                        R.string.button_dont_save,
                        new DialogInterface.OnClickListener() {
                            String dataLeAk188 = "188";

							public void onClick(DialogInterface dialog,
                                                int whichButton) {
                                dataLeAk189 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													dataLeAk188 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								// Don't save
                                finish();
                            }
                        }
                )
                .setNegativeButton(
                        android.R.string.cancel,
                        new DialogInterface.OnClickListener() {
                            String dataLeAk190 = "190";

							public void onClick(DialogInterface dialog,
                                                int whichButton) {
													dataLeAk191 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													dataLeAk190 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
                                // Cancel
                            }
                        }
                ).create();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        dataLeAk192 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-209", dataLeAk145);
		android.util.Log.d("leak-147-209", dataLeAk147);
		android.util.Log.d("leak-149-209", dataLeAk149);
		android.util.Log.d("leak-151-209", dataLeAk151);
		android.util.Log.d("leak-153-209", dataLeAk153);
		android.util.Log.d("leak-155-209", dataLeAk155);
		android.util.Log.d("leak-157-209", dataLeAk157);
		android.util.Log.d("leak-158-209", dataLeAk158);
		android.util.Log.d("leak-159-209", dataLeAk159);
		android.util.Log.d("leak-160-209", dataLeAk160);
		android.util.Log.d("leak-162-209", dataLeAk162);
		android.util.Log.d("leak-164-209", dataLeAk164);
		android.util.Log.d("leak-166-209", dataLeAk166);
		android.util.Log.d("leak-168-209", dataLeAk168);
		android.util.Log.d("leak-169-209", dataLeAk169);
		android.util.Log.d("leak-170-209", dataLeAk170);
		android.util.Log.d("leak-171-209", dataLeAk171);
		android.util.Log.d("leak-172-209", dataLeAk172);
		android.util.Log.d("leak-173-209", dataLeAk173);
		android.util.Log.d("leak-174-209", dataLeAk174);
		android.util.Log.d("leak-175-209", dataLeAk175);
		android.util.Log.d("leak-177-209", dataLeAk177);
		android.util.Log.d("leak-178-209", dataLeAk178);
		android.util.Log.d("leak-179-209", dataLeAk179);
		android.util.Log.d("leak-180-209", dataLeAk180);
		android.util.Log.d("leak-181-209", dataLeAk181);
		android.util.Log.d("leak-182-209", dataLeAk182);
		android.util.Log.d("leak-183-209", dataLeAk183);
		android.util.Log.d("leak-184-209", dataLeAk184);
		android.util.Log.d("leak-185-209", dataLeAk185);
		android.util.Log.d("leak-187-209", dataLeAk187);
		android.util.Log.d("leak-189-209", dataLeAk189);
		android.util.Log.d("leak-191-209", dataLeAk191);
		android.util.Log.d("leak-192-209", dataLeAk192);
		android.util.Log.d("leak-193-209", dataLeAk193);
		android.util.Log.d("leak-194-209", dataLeAk194);
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
        dataLeAk193 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-210", dataLeAk145);
		android.util.Log.d("leak-147-210", dataLeAk147);
		android.util.Log.d("leak-149-210", dataLeAk149);
		android.util.Log.d("leak-151-210", dataLeAk151);
		android.util.Log.d("leak-153-210", dataLeAk153);
		android.util.Log.d("leak-155-210", dataLeAk155);
		android.util.Log.d("leak-157-210", dataLeAk157);
		android.util.Log.d("leak-158-210", dataLeAk158);
		android.util.Log.d("leak-159-210", dataLeAk159);
		android.util.Log.d("leak-160-210", dataLeAk160);
		android.util.Log.d("leak-162-210", dataLeAk162);
		android.util.Log.d("leak-164-210", dataLeAk164);
		android.util.Log.d("leak-166-210", dataLeAk166);
		android.util.Log.d("leak-168-210", dataLeAk168);
		android.util.Log.d("leak-169-210", dataLeAk169);
		android.util.Log.d("leak-170-210", dataLeAk170);
		android.util.Log.d("leak-171-210", dataLeAk171);
		android.util.Log.d("leak-172-210", dataLeAk172);
		android.util.Log.d("leak-173-210", dataLeAk173);
		android.util.Log.d("leak-174-210", dataLeAk174);
		android.util.Log.d("leak-175-210", dataLeAk175);
		android.util.Log.d("leak-177-210", dataLeAk177);
		android.util.Log.d("leak-178-210", dataLeAk178);
		android.util.Log.d("leak-179-210", dataLeAk179);
		android.util.Log.d("leak-180-210", dataLeAk180);
		android.util.Log.d("leak-181-210", dataLeAk181);
		android.util.Log.d("leak-182-210", dataLeAk182);
		android.util.Log.d("leak-183-210", dataLeAk183);
		android.util.Log.d("leak-184-210", dataLeAk184);
		android.util.Log.d("leak-185-210", dataLeAk185);
		android.util.Log.d("leak-187-210", dataLeAk187);
		android.util.Log.d("leak-189-210", dataLeAk189);
		android.util.Log.d("leak-191-210", dataLeAk191);
		android.util.Log.d("leak-192-210", dataLeAk192);
		android.util.Log.d("leak-193-210", dataLeAk193);
		android.util.Log.d("leak-194-210", dataLeAk194);
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
        dataLeAk194 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-145-211", dataLeAk145);
		android.util.Log.d("leak-147-211", dataLeAk147);
		android.util.Log.d("leak-149-211", dataLeAk149);
		android.util.Log.d("leak-151-211", dataLeAk151);
		android.util.Log.d("leak-153-211", dataLeAk153);
		android.util.Log.d("leak-155-211", dataLeAk155);
		android.util.Log.d("leak-157-211", dataLeAk157);
		android.util.Log.d("leak-158-211", dataLeAk158);
		android.util.Log.d("leak-159-211", dataLeAk159);
		android.util.Log.d("leak-160-211", dataLeAk160);
		android.util.Log.d("leak-162-211", dataLeAk162);
		android.util.Log.d("leak-164-211", dataLeAk164);
		android.util.Log.d("leak-166-211", dataLeAk166);
		android.util.Log.d("leak-168-211", dataLeAk168);
		android.util.Log.d("leak-169-211", dataLeAk169);
		android.util.Log.d("leak-170-211", dataLeAk170);
		android.util.Log.d("leak-171-211", dataLeAk171);
		android.util.Log.d("leak-172-211", dataLeAk172);
		android.util.Log.d("leak-173-211", dataLeAk173);
		android.util.Log.d("leak-174-211", dataLeAk174);
		android.util.Log.d("leak-175-211", dataLeAk175);
		android.util.Log.d("leak-177-211", dataLeAk177);
		android.util.Log.d("leak-178-211", dataLeAk178);
		android.util.Log.d("leak-179-211", dataLeAk179);
		android.util.Log.d("leak-180-211", dataLeAk180);
		android.util.Log.d("leak-181-211", dataLeAk181);
		android.util.Log.d("leak-182-211", dataLeAk182);
		android.util.Log.d("leak-183-211", dataLeAk183);
		android.util.Log.d("leak-184-211", dataLeAk184);
		android.util.Log.d("leak-185-211", dataLeAk185);
		android.util.Log.d("leak-187-211", dataLeAk187);
		android.util.Log.d("leak-189-211", dataLeAk189);
		android.util.Log.d("leak-191-211", dataLeAk191);
		android.util.Log.d("leak-192-211", dataLeAk192);
		android.util.Log.d("leak-193-211", dataLeAk193);
		android.util.Log.d("leak-194-211", dataLeAk194);
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
        private Rect mRect;
        private Paint mPaint;

        // we need this constructor for LayoutInflater
        public LinedEditText(Context context, AttributeSet attrs) {
            super(context, attrs);

            mRect = new Rect();

            mPaint = new Paint();
            mPaint.setStyle(Paint.Style.STROKE);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            boolean fullWidth = (mLinesMode & 1) == 1;
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
