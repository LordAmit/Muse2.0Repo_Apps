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
    String dataLeAk578 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk578 = android.util.Log.d("leak-578", dataLeAk578);

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
        String dataLeAk579 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk579 = android.util.Log.d("leak-579", dataLeAk579);
		try {
            String dataLeAk580 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk580 = android.util.Log.d("leak-580", dataLeAk580);
			WrapActionBar.checkAvailable();
            mActionBarAvailable = true;
        } catch (Throwable t) {
            String dataLeAk581 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk581 = android.util.Log.d("leak-581", dataLeAk581);
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
        String dataLeAk582 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk582 = android.util.Log.d("leak-582", dataLeAk582);

		public void afterTextChanged(Editable s) {
            String dataLeAk583 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk583 = android.util.Log.d("leak-583", dataLeAk583);
			// if (DEBUG) Log.d(TAG, "after");
            mFileContent = s.toString();
            updateTitleSdCard();
        }

        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
										String dataLeAk584 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk584 = android.util.Log.d("leak-584", dataLeAk584);
            // if (DEBUG) Log.d(TAG, "before");
        }

        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
									String dataLeAk585 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk585 = android.util.Log.d("leak-585", dataLeAk585);
            // if (DEBUG) Log.d(TAG, "on");
        }

    };
    private TextWatcher mTextWatcherCharCount = new TextWatcher() {
        String dataLeAk586 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk586 = android.util.Log.d("leak-586", dataLeAk586);

		public void afterTextChanged(Editable s) {
            String dataLeAk587 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk587 = android.util.Log.d("leak-587", dataLeAk587);
			updateCharCount();
        }

        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
										String dataLeAk588 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk588 = android.util.Log.d("leak-588", dataLeAk588);
        }

        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
									String dataLeAk589 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk589 = android.util.Log.d("leak-589", dataLeAk589);
        }
    };
    private BroadcastReceiver mUpdateReceiver = new BroadcastReceiver() {

        String dataLeAk590 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk590 = android.util.Log.d("leak-590", dataLeAk590);

		@Override
        public void onReceive(Context context, Intent intent) {
            String dataLeAk591 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk591 = android.util.Log.d("leak-591", dataLeAk591);
			intent.getStringExtra(DialogHostingActivity.EXTRA_FILENAME);
            updateTitleSdCard();
        }
    };

    public static void deleteStaticDecryptedText() {
        String dataLeAk592 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk592 = android.util.Log.d("leak-592", dataLeAk592);
		if (DEBUG) {
            String dataLeAk593 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk593 = android.util.Log.d("leak-593", dataLeAk593);
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
        String dataLeAk594 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk594 = android.util.Log.d("leak-594", dataLeAk594);
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
		String dataLeAk595 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk595 = android.util.Log.d("leak-595", dataLeAk595);

        if (DEBUG) {
            String dataLeAk596 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk596 = android.util.Log.d("leak-596", dataLeAk596);
			Log.d(TAG, "onCreate()");
        }

        if (getIntent().getAction().equals(Intent.ACTION_CREATE_SHORTCUT)) {
            String dataLeAk597 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk597 = android.util.Log.d("leak-597", dataLeAk597);
			createShortcut();
            return;
        }

        if (savedInstanceState == null) {
            String dataLeAk598 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk598 = android.util.Log.d("leak-598", dataLeAk598);
			// sDecryptedText has no use for brand new activities
            sDecryptedText = null;
        }

        // Usually, sDecryptedText == null.
        mDecryptedText = sDecryptedText;
        if (sDecryptedText != null) {
            String dataLeAk599 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk599 = android.util.Log.d("leak-599", dataLeAk599);
			// we use the text right now,
            // so don't encrypt the text anymore.
            EncryptActivity.cancelEncrypt();

            if (EncryptActivity.getPendingEncryptActivities() == 0) {
                String dataLeAk600 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk600 = android.util.Log.d("leak-600", dataLeAk600);
				if (DEBUG) {
                    String dataLeAk601 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk601 = android.util.Log.d("leak-601", dataLeAk601);
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
            String dataLeAk602 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk602 = android.util.Log.d("leak-602", dataLeAk602);
			mOriginalContent = savedInstanceState
                    .getString(BUNDLE_ORIGINAL_CONTENT);
            mUndoRevert = savedInstanceState.getString(BUNDLE_UNDO_REVERT);
            mState = savedInstanceState.getInt(BUNDLE_STATE);
            String uriString = savedInstanceState.getString(BUNDLE_URI);
            if (uriString != null) {
                String dataLeAk603 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk603 = android.util.Log.d("leak-603", dataLeAk603);
				mUri = Uri.parse(uriString);
            }

            mSelectionStart = savedInstanceState.getInt(BUNDLE_SELECTION_START);
            mSelectionStop = savedInstanceState.getInt(BUNDLE_SELECTION_STOP);
            mFileContent = savedInstanceState.getString(BUNDLE_FILE_CONTENT);
            if (mApplyText == null && mApplyTextBefore == null
                    && mApplyTextAfter == null) {
                String dataLeAk604 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk604 = android.util.Log.d("leak-604", dataLeAk604);
				// Only read values if they had not been set by
                // onActivityResult() yet:
                mApplyText = savedInstanceState.getString(BUNDLE_APPLY_TEXT);
                mApplyTextBefore = savedInstanceState
                        .getString(BUNDLE_APPLY_TEXT_BEFORE);
                mApplyTextAfter = savedInstanceState
                        .getString(BUNDLE_APPLY_TEXT_AFTER);
            }
        } else {
            String dataLeAk605 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk605 = android.util.Log.d("leak-605", dataLeAk605);
			// Do some setup based on the action being performed.
            final Intent intent = getIntent();
            final String action = intent.getAction();


            if (Intent.ACTION_EDIT.equals(action)
                    || Intent.ACTION_VIEW.equals(action)) {
                String dataLeAk606 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk606 = android.util.Log.d("leak-606", dataLeAk606);
				// Requested to edit: set that state, and the data being edited.
                mState = STATE_EDIT;
                mUri = intent.getData();

                if (mUri != null && mUri.getScheme().equals("file")) {
                    String dataLeAk607 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk607 = android.util.Log.d("leak-607", dataLeAk607);
					mState = STATE_EDIT_NOTE_FROM_SDCARD;
                    // Load the file into a new note.

                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                        String dataLeAk608 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk608 = android.util.Log.d("leak-608", dataLeAk608);
						mFileContent = readFile(FileUriUtils.getFile(mUri));
                    } else {
                        String dataLeAk609 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk609 = android.util.Log.d("leak-609", dataLeAk609);
						if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
							String dataLeAk610 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk610 = android.util.Log.d("leak-610", dataLeAk610);

                        } else {
                            String dataLeAk611 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk611 = android.util.Log.d("leak-611", dataLeAk611);
							ActivityCompat.requestPermissions(this,
                                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                                    REQUEST_CODE_PERMISSION_READ_EXTERNAL_STORAGE);
                            mFileContent = getString(R.string.request_permissions);
                        }
                    }
                } else if (mUri != null
                        && !mUri.getAuthority().equals(NotePad.AUTHORITY)) {
                    String dataLeAk612 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk612 = android.util.Log.d("leak-612", dataLeAk612);
					// Note a notepad note. Treat slightly differently.
                    // (E.g. a note from OI Shopping List)
                    mState = STATE_EDIT_EXTERNAL_NOTE;
                }

            } else if (Intent.ACTION_INSERT.equals(action)
                    || Intent.ACTION_SEND.equals(action)) {

                String dataLeAk613 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk613 = android.util.Log.d("leak-613", dataLeAk613);
				// Use theme of most recently modified note:
                ContentValues values = new ContentValues(1);
                String theme = getMostRecentlyUsedTheme();
                values.put(Notes.THEME, theme);

                String tags = intent
                        .getStringExtra(NotepadInternalIntents.EXTRA_TAGS);
                values.put(Notes.TAGS, tags);

                if (mText != null) {
                    String dataLeAk614 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk614 = android.util.Log.d("leak-614", dataLeAk614);
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
                    String dataLeAk615 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk615 = android.util.Log.d("leak-615", dataLeAk615);
					values.put(
                            Notes.NOTE,
                            getIntent().getStringExtra(Intent.EXTRA_TEXT)
                    );
                    mUri = getContentResolver().insert(
                            Notes.CONTENT_URI,
                            values
                    );
                } else {
                    String dataLeAk616 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk616 = android.util.Log.d("leak-616", dataLeAk616);
					mUri = getContentResolver().insert(
                            intent.getData(),
                            values
                    );
                }

                // If we were unable to create a new note, then just finish
                // this activity. A RESULT_CANCELED will be sent back to the
                // original activity if they requested a result.
                if (mUri == null) {
                    String dataLeAk617 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk617 = android.util.Log.d("leak-617", dataLeAk617);
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
                String dataLeAk618 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk618 = android.util.Log.d("leak-618", dataLeAk618);
				// Whoops, unknown action! Bail.
                Log.e(TAG, "Unknown action, exiting");
                finish();
                return;
            }
        }

        // setup actionbar
        if (mActionBarAvailable) {
            String dataLeAk619 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk619 = android.util.Log.d("leak-619", dataLeAk619);
			requestWindowFeature(Window.FEATURE_ACTION_BAR);
            WrapActionBar bar = new WrapActionBar(this);
            bar.setDisplayHomeAsUpEnabled(true);
            // force to show the actionbar on version 14+
            if (Integer.valueOf(android.os.Build.VERSION.SDK) >= 14) {
                String dataLeAk620 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk620 = android.util.Log.d("leak-620", dataLeAk620);
				bar.setHomeButtonEnabled(true);
            }
        } else {
            String dataLeAk621 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk621 = android.util.Log.d("leak-621", dataLeAk621);
			requestWindowFeature(Window.FEATURE_RIGHT_ICON);
        }

        // Set the layout for this activity. You can find it in
        // res/layout/note_editor.xml
        setContentView(R.layout.note_editor);

        // The text view for our note, identified by its ID in the XML file.
        mText = (EditText) findViewById(R.id.note);

        if (mState == STATE_EDIT_NOTE_FROM_SDCARD) {
            String dataLeAk622 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk622 = android.util.Log.d("leak-622", dataLeAk622);
			// We add a text watcher, so that the title can be updated
            // to indicate a small "*" if modified.
            mText.addTextChangedListener(mTextWatcherSdCard);
        }

        if (mState != STATE_EDIT_NOTE_FROM_SDCARD) {

            String dataLeAk623 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk623 = android.util.Log.d("leak-623", dataLeAk623);
			// Check if we load a note from notepad or from some external module
            if (mState == STATE_EDIT_EXTERNAL_NOTE) {
                String dataLeAk624 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk624 = android.util.Log.d("leak-624", dataLeAk624);
				// Get all the columns as we don't know which columns are
                // supported.
                mCursor = managedQuery(mUri, null, null, null, null);

                // Now check which columns are available
                List<String> columnNames = Arrays.asList(
                        mCursor
                                .getColumnNames()
                );

                if (!columnNames.contains(Notes.NOTE)) {
                    String dataLeAk625 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk625 = android.util.Log.d("leak-625", dataLeAk625);
					hasNoteColumn = false;
                }
                if (!columnNames.contains(Notes.TAGS)) {
                    String dataLeAk626 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk626 = android.util.Log.d("leak-626", dataLeAk626);
					hasTagsColumn = false;
                }
                if (!columnNames.contains(Notes.ENCRYPTED)) {
                    String dataLeAk627 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk627 = android.util.Log.d("leak-627", dataLeAk627);
					hasEncryptionColumn = false;
                }
                if (!columnNames.contains(Notes.THEME)) {
                    String dataLeAk628 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk628 = android.util.Log.d("leak-628", dataLeAk628);
					hasThemeColumn = false;
                }
                if (!columnNames.contains(Notes.SELECTION_START)) {
                    String dataLeAk629 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk629 = android.util.Log.d("leak-629", dataLeAk629);
					hasSelection_startColumn = false;
                }
                if (!columnNames.contains(Notes.SELECTION_END)) {
                    String dataLeAk630 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk630 = android.util.Log.d("leak-630", dataLeAk630);
					hasSelection_endColumn = false;
                }
            } else {
                String dataLeAk631 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk631 = android.util.Log.d("leak-631", dataLeAk631);
				// Get the note!
                mCursor = managedQuery(mUri, PROJECTION, null, null, null);

                // It's not an external note, so all the columns are available
                // in the database
            }
        } else {
            String dataLeAk632 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk632 = android.util.Log.d("leak-632", dataLeAk632);
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
        String dataLeAk633 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk633 = android.util.Log.d("leak-633", dataLeAk633);
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
        String dataLeAk634 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk634 = android.util.Log.d("leak-634", dataLeAk634);
		String theme = null;
        Cursor c = getContentResolver().query(
                Notes.CONTENT_URI,
                new String[]{Notes.THEME}, null, null,
                Notes.MODIFIED_DATE + " DESC"
        );
        if (c != null && c.moveToFirst()) {
            String dataLeAk635 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk635 = android.util.Log.d("leak-635", dataLeAk635);
			theme = c.getString(0);
        }
        c.close();
        return theme;
    }

    public String readFile(File file) {

        String dataLeAk636 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk636 = android.util.Log.d("leak-636", dataLeAk636);
		FileInputStream fis;
        String result;

        try {
            String dataLeAk637 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk637 = android.util.Log.d("leak-637", dataLeAk637);
			fis = new FileInputStream(file);
            result = readFile(fis);
            // dispose all the resources after using them.
            fis.close();

        } catch (FileNotFoundException e) {
            String dataLeAk638 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk638 = android.util.Log.d("leak-638", dataLeAk638);
			Log.e(TAG, "File not found", e);
            Toast.makeText(this, R.string.file_not_found, Toast.LENGTH_SHORT)
                    .show();
            return null;
        } catch (IOException e) {
            String dataLeAk639 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk639 = android.util.Log.d("leak-639", dataLeAk639);
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
        String dataLeAk640 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk640 = android.util.Log.d("leak-640", dataLeAk640);
		StringBuilder sb = new StringBuilder();

        try {
            String dataLeAk641 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk641 = android.util.Log.d("leak-641", dataLeAk641);
			Reader in = new InputStreamReader(inputStream, "UTF-8");

            char[] buffer = new char[40960];
            int len;
            while ((len = in.read(buffer)) != -1) {
                String dataLeAk642 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk642 = android.util.Log.d("leak-642", dataLeAk642);
				sb.append(buffer, 0, len);
            }

        } catch (IOException e) {
            String dataLeAk643 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk643 = android.util.Log.d("leak-643", dataLeAk643);
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
		String dataLeAk644 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk644 = android.util.Log.d("leak-644", dataLeAk644);
        if (DEBUG) {
            String dataLeAk645 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk645 = android.util.Log.d("leak-645", dataLeAk645);
			Log.d(TAG, "onResume");
        }

        if (DEBUG) {
            String dataLeAk646 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk646 = android.util.Log.d("leak-646", dataLeAk646);
			Log.d(TAG, "mDecrypted: " + mDecryptedText);
        }

        // Set auto-link on or off, based on the current setting.
        int autoLink = PreferenceActivity.getAutoLinkFromPreference(this);

        mText.setAutoLinkMask(autoLink);

        mEncrypted = 0;

        if (mState == STATE_EDIT
                || (mState == STATE_INSERT)
                || mState == STATE_EDIT_EXTERNAL_NOTE) {
            String dataLeAk647 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk647 = android.util.Log.d("leak-647", dataLeAk647);
			getNoteFromContentProvider();
        } else if (mState == STATE_EDIT_NOTE_FROM_SDCARD) {
            String dataLeAk648 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk648 = android.util.Log.d("leak-648", dataLeAk648);
			getNoteFromFile();
        }

        if (mEncrypted == 0 || mDecryptedText != null) {
            String dataLeAk649 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk649 = android.util.Log.d("leak-649", dataLeAk649);
			applyInsertText();
        }

        // Make sure that we don't use the link movement method.
        // Instead, we need a blend between the arrow key movement (for regular
        // navigation) and
        // the link movement (so the user can click on links).
        mText.setMovementMethod(
                new ArrowKeyMovementMethod() {
                    String dataLeAk650 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk650 = android.util.Log.d("leak-650", dataLeAk650);

					public boolean onTouchEvent(TextView widget, Spannable buffer,
                                                MotionEvent event) {
                        String dataLeAk651 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													Object throwawayLeAk651 = android.util.Log.d("leak-651", dataLeAk651);
						// This block is copied and pasted from LinkMovementMethod's
                        // onTouchEvent (without the part that actually changes the
                        // selection).
                        int action = event.getAction();

                        if (action == MotionEvent.ACTION_UP) {
                            String dataLeAk652 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk652 = android.util.Log.d("leak-652", dataLeAk652);
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
                                String dataLeAk653 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk653 = android.util.Log.d("leak-653", dataLeAk653);
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
        String dataLeAk654 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk654 = android.util.Log.d("leak-654", dataLeAk654);
		LinearLayout searchLayout = (LinearLayout) findViewById(R.id.search);
        searchLayout.setVisibility(View.VISIBLE);
        EditText edt = (EditText) findViewById(R.id.edtSearchWord);
        edt.requestFocus();
    }

    // if editor was invoked from a global search, take over the search word and show the search panel
    private void startupSearch() {
        String dataLeAk655 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk655 = android.util.Log.d("leak-655", dataLeAk655);
		String searchString = getIntent().getStringExtra("SEARCH_STRING");
        if (searchString != null && !searchString.equals("")) {
            String dataLeAk656 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk656 = android.util.Log.d("leak-656", dataLeAk656);
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
        String dataLeAk657 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk657 = android.util.Log.d("leak-657", dataLeAk657);
		ImageButton mBtnForward = (ImageButton) findViewById(R.id.btnForward);
        mBtnForward.setOnClickListener(
                new OnClickListener() {
                    String dataLeAk658 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk658 = android.util.Log.d("leak-658", dataLeAk658);

					public void onClick(View v) {
                        String dataLeAk659 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk659 = android.util.Log.d("leak-659", dataLeAk659);
						searchForward();
                    }
                }
        );
        ImageButton mBtnBackward = (ImageButton) findViewById(R.id.btnBackward);
        mBtnBackward.setOnClickListener(
                new OnClickListener() {
                    String dataLeAk660 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk660 = android.util.Log.d("leak-660", dataLeAk660);

					public void onClick(View v) {
                        String dataLeAk661 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk661 = android.util.Log.d("leak-661", dataLeAk661);
						searchBackward();
                    }
                }
        );
        ImageButton btnClose = (ImageButton) findViewById(R.id.btnClose);
        btnClose.setOnClickListener(
                new OnClickListener() {
                    String dataLeAk662 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk662 = android.util.Log.d("leak-662", dataLeAk662);

					public void onClick(View v) {
                        String dataLeAk663 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk663 = android.util.Log.d("leak-663", dataLeAk663);
						LinearLayout searchLayout = (LinearLayout) findViewById(R.id.search);
                        searchLayout.setVisibility(View.GONE);
                    }
                }
        );
    }

    // Search forward from current selection
    private void searchForward() {
        String dataLeAk664 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk664 = android.util.Log.d("leak-664", dataLeAk664);
		EditText edt = (EditText) findViewById(R.id.edtSearchWord);
        String search = edt.getText().toString();
        if (search != null && !search.equals("")) {
            String dataLeAk665 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk665 = android.util.Log.d("leak-665", dataLeAk665);
			String text = mText.getText().toString();
            if (text != null && !text.equals("")) {
                String dataLeAk666 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk666 = android.util.Log.d("leak-666", dataLeAk666);
				int start = text.toUpperCase().indexOf(search.toUpperCase(), mText.getSelectionEnd());
                if (start != -1) {
                    String dataLeAk667 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk667 = android.util.Log.d("leak-667", dataLeAk667);
					mText.requestFocus();
                    mText.setSelection(start, start + search.length());
                } else {
                    String dataLeAk668 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk668 = android.util.Log.d("leak-668", dataLeAk668);
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
        String dataLeAk669 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk669 = android.util.Log.d("leak-669", dataLeAk669);
		EditText edt = (EditText) findViewById(R.id.edtSearchWord);
        String search = edt.getText().toString();
        if (search != null && !search.equals("")) {
            String dataLeAk670 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk670 = android.util.Log.d("leak-670", dataLeAk670);
			String text = mText.getText().toString();
            if (text != null && !text.equals("")) {
                String dataLeAk671 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk671 = android.util.Log.d("leak-671", dataLeAk671);
				int start = text.toUpperCase().lastIndexOf(search.toUpperCase(), mText.getSelectionStart() - 1);
                if (start != -1) {
                    String dataLeAk672 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk672 = android.util.Log.d("leak-672", dataLeAk672);
					mText.requestFocus();
                    mText.setSelection(start, start + search.length());
                } else {
                    String dataLeAk673 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk673 = android.util.Log.d("leak-673", dataLeAk673);
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
        String dataLeAk674 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk674 = android.util.Log.d("leak-674", dataLeAk674);
		// If we didn't have any trouble retrieving the data, it is now
        // time to get at the stuff.
        if (mCursor != null && mCursor.requery() && mCursor.moveToFirst()) {

            String dataLeAk675 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk675 = android.util.Log.d("leak-675", dataLeAk675);
			// Modify our overall title depending on the mode we are running in.
            if (mState == STATE_EDIT || mState == STATE_EDIT_EXTERNAL_NOTE) {
                String dataLeAk676 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk676 = android.util.Log.d("leak-676", dataLeAk676);
				setTitle(getText(R.string.title_edit));
            } else if (mState == STATE_INSERT) {
                String dataLeAk677 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk677 = android.util.Log.d("leak-677", dataLeAk677);
				setTitle(getText(R.string.title_create));
            }

            // This always has to be available
            long id = mCursor.getLong(mCursor.getColumnIndex(Notes._ID));
            String note;

            if (mState == STATE_EDIT_EXTERNAL_NOTE) {
                // Check if the other columns are available

                String dataLeAk678 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk678 = android.util.Log.d("leak-678", dataLeAk678);
				// Note
                if (hasNoteColumn) {
                    String dataLeAk679 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk679 = android.util.Log.d("leak-679", dataLeAk679);
					note = mCursor
                            .getString(mCursor.getColumnIndex(Notes.NOTE));
                } else {
                    String dataLeAk680 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk680 = android.util.Log.d("leak-680", dataLeAk680);
					note = "";
                }

                // Encrypted
                mEncrypted = isNoteUnencrypted() ? 0 : 1;

                // Theme
                if (hasThemeColumn) {
                    String dataLeAk681 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk681 = android.util.Log.d("leak-681", dataLeAk681);
					mTheme = mCursor.getString(
                            mCursor
                                    .getColumnIndex(Notes.THEME)
                    );
                } else {
                    String dataLeAk682 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk682 = android.util.Log.d("leak-682", dataLeAk682);
					note = "";
                }

                // Selection start
                if (hasSelection_startColumn) {
                    String dataLeAk683 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk683 = android.util.Log.d("leak-683", dataLeAk683);
					mSelectionStart = mCursor.getInt(
                            mCursor
                                    .getColumnIndex(Notes.SELECTION_START)
                    );
                } else {
                    String dataLeAk684 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk684 = android.util.Log.d("leak-684", dataLeAk684);
					mSelectionStart = 0;
                }

                // Selection end
                if (hasSelection_endColumn) {
                    String dataLeAk685 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk685 = android.util.Log.d("leak-685", dataLeAk685);
					mSelectionStop = mCursor.getInt(
                            mCursor
                                    .getColumnIndex(Notes.SELECTION_END)
                    );
                } else {
                    String dataLeAk686 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk686 = android.util.Log.d("leak-686", dataLeAk686);
					mSelectionStop = 0;
                }
            } else {
                String dataLeAk687 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk687 = android.util.Log.d("leak-687", dataLeAk687);
				// We know for sure all the columns are available
                note = mCursor.getString(COLUMN_INDEX_NOTE);
                mEncrypted = mCursor.getLong(COLUMN_INDEX_ENCRYPTED);
                mTheme = mCursor.getString(COLUMN_INDEX_THEME);
                mSelectionStart = mCursor.getInt(COLUMN_INDEX_SELECTION_START);
                mSelectionStop = mCursor.getInt(COLUMN_INDEX_SELECTION_END);
            }

            if (mEncrypted == 0) {
                // Not encrypted

                String dataLeAk688 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk688 = android.util.Log.d("leak-688", dataLeAk688);
				// This is a little tricky: we may be resumed after previously
                // being
                // paused/stopped. We want to put the new text in the text view,
                // but leave the user where they were (retain the cursor
                // position
                // etc). This version of setText does that for us.
                if (!note.equals(mText.getText().toString())) {
                    String dataLeAk689 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk689 = android.util.Log.d("leak-689", dataLeAk689);
					mText.setTextKeepState(note);
                    // keep state does not work, so we have to do it manually:
                    mText.setSelection(mSelectionStart, mSelectionStop);
                }
            } else {
                String dataLeAk690 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk690 = android.util.Log.d("leak-690", dataLeAk690);
				if (mDecryptedText != null) {
                    String dataLeAk691 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk691 = android.util.Log.d("leak-691", dataLeAk691);
					// Text had already been decrypted, use that:
                    if (DEBUG) {
                        String dataLeAk692 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk692 = android.util.Log.d("leak-692", dataLeAk692);
						Log.d(
                                TAG, "set decrypted text as mText: "
                                        + mDecryptedText
                        );
                    }
                    mText.setTextKeepState(mDecryptedText);
                    // keep state does not work, so we have to do it manually:
                    mText.setSelection(mSelectionStart, mSelectionStop);

                    if (!mActionBarAvailable) {
                        String dataLeAk693 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk693 = android.util.Log.d("leak-693", dataLeAk693);
						setFeatureDrawableResource(
                                Window.FEATURE_RIGHT_ICON,
                                android.R.drawable.ic_lock_idle_lock
                        );
                    }
                } else {
                    String dataLeAk694 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk694 = android.util.Log.d("leak-694", dataLeAk694);
					// Decrypt note
                    if (DEBUG) {
                        String dataLeAk695 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk695 = android.util.Log.d("leak-695", dataLeAk695);
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
                        String dataLeAk696 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk696 = android.util.Log.d("leak-696", dataLeAk696);
						if (checkCallingOrSelfPermission(CryptoIntents.PERMISSION_SAFE_ACCESS_INTENTS) == PackageManager.PERMISSION_GRANTED) {
                            String dataLeAk697 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk697 = android.util.Log.d("leak-697", dataLeAk697);
							startActivityForResult(i, REQUEST_CODE_DECRYPT);
                        } else {
                            String dataLeAk698 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk698 = android.util.Log.d("leak-698", dataLeAk698);
							Toast.makeText(
                                    this, R.string.decryption_failed_due_to_permissions,
                                    Toast.LENGTH_SHORT
                            ).show();
                        }
                    } catch (ActivityNotFoundException e) {
                        String dataLeAk699 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk699 = android.util.Log.d("leak-699", dataLeAk699);
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
                String dataLeAk700 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk700 = android.util.Log.d("leak-700", dataLeAk700);
				mOriginalContent = note;
            }

        } else {
            String dataLeAk701 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk701 = android.util.Log.d("leak-701", dataLeAk701);
			setTitle(getText(R.string.error_title));
            mText.setText(getText(R.string.error_message));
        }
    }

    private void getNoteFromFile() {
        String dataLeAk702 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk702 = android.util.Log.d("leak-702", dataLeAk702);
		if (DEBUG) {
            String dataLeAk703 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk703 = android.util.Log.d("leak-703", dataLeAk703);
			Log.d(TAG, "file: " + mFileContent);
        }
        if (mFileContent == null) {
            String dataLeAk704 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk704 = android.util.Log.d("leak-704", dataLeAk704);
			// TODO
            mFileContent = "error";
            mReadOnly = true;
        }

        mText.setTextKeepState(mFileContent);

        // keep state does not work, so we have to do it manually:
        try {
            String dataLeAk705 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk705 = android.util.Log.d("leak-705", dataLeAk705);
			mText.setSelection(mSelectionStart, mSelectionStop);
        } catch (IndexOutOfBoundsException e) {
			String dataLeAk706 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk706 = android.util.Log.d("leak-706", dataLeAk706);
            // Then let's not adjust the selection.
        }

        // If we hadn't previously retrieved the original text, do so
        // now. This allows the user to revert their changes.
        if (mOriginalContent == null) {
            String dataLeAk707 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk707 = android.util.Log.d("leak-707", dataLeAk707);
			mOriginalContent = mFileContent;
        }

        updateTitleSdCard();
    }

    private void updateTitleSdCard() {
        String dataLeAk708 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk708 = android.util.Log.d("leak-708", dataLeAk708);
		String modified = "";
        if (mOriginalContent != null && !mOriginalContent.equals(mFileContent)) {
            String dataLeAk709 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk709 = android.util.Log.d("leak-709", dataLeAk709);
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
        String dataLeAk710 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk710 = android.util.Log.d("leak-710", dataLeAk710);
		boolean charCountVisible = false;
        String currentTitle = getTitle().toString();
        if (currentTitle.startsWith("[")) {
            String dataLeAk711 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk711 = android.util.Log.d("leak-711", dataLeAk711);
			charCountVisible = true;
        }
        if (PreferenceActivity.getCharCountEnabledFromPrefs(this)) {
            String dataLeAk712 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk712 = android.util.Log.d("leak-712", dataLeAk712);
			if (charCountVisible) {
                String dataLeAk713 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk713 = android.util.Log.d("leak-713", dataLeAk713);
				setTitle(
                        "[" + mText.length() + "]"
                                + currentTitle.substring(currentTitle.indexOf(" "))
                );
            } else {
                String dataLeAk714 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk714 = android.util.Log.d("leak-714", dataLeAk714);
				setTitle("[" + mText.length() + "] " + currentTitle);
            }
        } else {
            String dataLeAk715 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk715 = android.util.Log.d("leak-715", dataLeAk715);
			if (charCountVisible) {
                String dataLeAk716 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk716 = android.util.Log.d("leak-716", dataLeAk716);
				setTitle(currentTitle.substring(currentTitle.indexOf(" ")));
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        String dataLeAk717 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk717 = android.util.Log.d("leak-717", dataLeAk717);
		if (DEBUG) {
            String dataLeAk718 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk718 = android.util.Log.d("leak-718", dataLeAk718);
			Log.d(TAG, "onSaveInstanceState");
        }
        // if (DEBUG) Log.d(TAG, "file content: " + mFileContent);

        // Save away the original text, so we still have it if the activity
        // needs to be killed while paused.
        mSelectionStart = mText.getSelectionStart();
        mSelectionStop = mText.getSelectionEnd();
        mFileContent = mText.getText().toString();

        if (DEBUG) {
            String dataLeAk719 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk719 = android.util.Log.d("leak-719", dataLeAk719);
			Log.d(
                    TAG, "Selection " + mSelectionStart + " - " + mSelectionStop
                            + " for text : " + mFileContent
            );
        }

        outState.putString(BUNDLE_ORIGINAL_CONTENT, mOriginalContent);
        outState.putString(BUNDLE_UNDO_REVERT, mUndoRevert);
        outState.putInt(BUNDLE_STATE, mState);
        if (mUri != null) {
            String dataLeAk720 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk720 = android.util.Log.d("leak-720", dataLeAk720);
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
		String dataLeAk721 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk721 = android.util.Log.d("leak-721", dataLeAk721);
        if (DEBUG) {
            String dataLeAk722 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk722 = android.util.Log.d("leak-722", dataLeAk722);
			Log.d(TAG, "onPause");
        }

        mText.setAutoLinkMask(0);

        // The user is going somewhere else, so make sure their current
        // changes are safely saved away in the provider. We don't need
        // to do this if only editing.
        if (mCursor != null) {

            String dataLeAk723 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk723 = android.util.Log.d("leak-723", dataLeAk723);
			mCursor.moveToFirst();

            if (isNoteUnencrypted()) {
                String dataLeAk724 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk724 = android.util.Log.d("leak-724", dataLeAk724);
				String text = mText.getText().toString();
                int length = text.length();

                // If this activity is finished, and there is no text, then we
                // do something a little special: simply delete the note entry.
                // Note that we do this both for editing and inserting... it
                // would be reasonable to only do it when inserting.
                if (isFinishing() && (length == 0) && !mNoteOnly) {
                    String dataLeAk725 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk725 = android.util.Log.d("leak-725", dataLeAk725);
					setResult(RESULT_CANCELED);
                    deleteNote();

                    // Get out updates into the provider.
                } else {
                    String dataLeAk726 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk726 = android.util.Log.d("leak-726", dataLeAk726);
					ContentValues values = new ContentValues();

                    // This stuff is only done when working with a full-fledged
                    // note.
                    if (!mNoteOnly) {
                        String dataLeAk727 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk727 = android.util.Log.d("leak-727", dataLeAk727);
						String oldText = "";
                        Cursor cursor = getContentResolver().query(
                                mUri,
                                new String[]{"note"}, null, null, null
                        );
                        if (cursor.moveToFirst()) {
                            String dataLeAk728 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk728 = android.util.Log.d("leak-728", dataLeAk728);
							oldText = cursor.getString(0);
                        }
                        if (!oldText.equals(text)) {
                            String dataLeAk729 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk729 = android.util.Log.d("leak-729", dataLeAk729);
							// Bump the modification time to now.
                            values.put(
                                    Notes.MODIFIED_DATE,
                                    System.currentTimeMillis()
                            );
                        }

                        String title;
                        if (!PreferenceActivity.getMarqueeFromPrefs(this)) {
                            String dataLeAk730 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk730 = android.util.Log.d("leak-730", dataLeAk730);
							title = ExtractTitle.extractTitle(text);
                        } else {
                            String dataLeAk731 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk731 = android.util.Log.d("leak-731", dataLeAk731);
							title = text;
                        }
                        values.put(Notes.TITLE, title);
                    }

                    // Write our text back into the provider.
                    if (hasNoteColumn) {
                        String dataLeAk732 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk732 = android.util.Log.d("leak-732", dataLeAk732);
						values.put(Notes.NOTE, text);
                    }
                    if (hasThemeColumn) {
                        String dataLeAk733 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk733 = android.util.Log.d("leak-733", dataLeAk733);
						values.put(Notes.THEME, mTheme);
                    }
                    if (hasSelection_startColumn) {
                        String dataLeAk734 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk734 = android.util.Log.d("leak-734", dataLeAk734);
						values.put(
                                Notes.SELECTION_START,
                                mText.getSelectionStart()
                        );
                    }
                    if (hasSelection_endColumn) {
                        String dataLeAk735 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk735 = android.util.Log.d("leak-735", dataLeAk735);
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

                String dataLeAk736 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk736 = android.util.Log.d("leak-736", dataLeAk736);
				// Save current theme:
                ContentValues values = new ContentValues();

                if (hasThemeColumn) {
                    String dataLeAk737 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk737 = android.util.Log.d("leak-737", dataLeAk737);
					values.put(Notes.THEME, mTheme);
                }

                getContentResolver().update(mUri, values, null, null);

                if (mDecryptedText != null) {
                    // Decrypted had been decrypted.
                    // We take the current version from 'text' and encrypt it.

                    String dataLeAk738 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk738 = android.util.Log.d("leak-738", dataLeAk738);
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
        String dataLeAk739 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk739 = android.util.Log.d("leak-739", dataLeAk739);
		String text = mText.getText().toString();
        String title;
        if (!PreferenceActivity.getMarqueeFromPrefs(this)) {
            String dataLeAk740 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk740 = android.util.Log.d("leak-740", dataLeAk740);
			title = ExtractTitle.extractTitle(text);
        } else {
            String dataLeAk741 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk741 = android.util.Log.d("leak-741", dataLeAk741);
			title = text;
        }
        String tags = getTags();
        // Log.i(TAG, "encrypt tags: " + tags);

        boolean isNoteEncrypted = !isNoteUnencrypted();

        if (!encryptTags) {
            String dataLeAk742 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk742 = android.util.Log.d("leak-742", dataLeAk742);
			tags = null;
        }

        if (DEBUG) {
            String dataLeAk743 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk743 = android.util.Log.d("leak-743", dataLeAk743);
			Log.d(TAG, "encrypt note: " + text);
        }

        if (EncryptActivity.getPendingEncryptActivities() == 0) {
            String dataLeAk744 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk744 = android.util.Log.d("leak-744", dataLeAk744);
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
                String dataLeAk745 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk745 = android.util.Log.d("leak-745", dataLeAk745);
				// No need to encrypt, content was not modified.
                i.putExtra(PrivateNotePadIntents.EXTRA_CONTENT_UNCHANGED, true);
            }
            startActivity(i);

            // Remove knowledge of the decrypted note.
            // If encryption fails because one has been locked out, (another)
            // user
            // should not be able to see note again from cache.
            if (DEBUG) {
                String dataLeAk746 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk746 = android.util.Log.d("leak-746", dataLeAk746);
				Log.d(TAG, "using static decrypted text: " + text);
            }
            sDecryptedText = text;
            if (isNoteEncrypted) {
                String dataLeAk747 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk747 = android.util.Log.d("leak-747", dataLeAk747);
				// Already encrypted
                mDecryptedText = null;
                mText.setText(R.string.encrypted);
            } else {
				String dataLeAk748 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk748 = android.util.Log.d("leak-748", dataLeAk748);
                // not yet encrypted, but we want to encrypt.
                // Leave mText until note is really encrypted
                // (in case password is not entered or OI Safw not installed)
            }
            EncryptActivity.confirmEncryptActivityCalled();
        } else {
            String dataLeAk749 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk749 = android.util.Log.d("leak-749", dataLeAk749);
			// encrypt already called
            if (DEBUG) {
                String dataLeAk750 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk750 = android.util.Log.d("leak-750", dataLeAk750);
				Log.d(TAG, "encrypt already called");
            }

        }

    }

    /**
     * Unencrypt the current note.
     */
    private void unencryptNote() {
        String dataLeAk751 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk751 = android.util.Log.d("leak-751", dataLeAk751);
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
            String dataLeAk752 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk752 = android.util.Log.d("leak-752", dataLeAk752);
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
        String dataLeAk753 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk753 = android.util.Log.d("leak-753", dataLeAk753);
		long encrypted = 0;
        if (mCursor != null && mCursor.moveToFirst()) {
            String dataLeAk754 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk754 = android.util.Log.d("leak-754", dataLeAk754);
			// Check if the column Notes.ENCRYPTED exists
            if (hasEncryptionColumn) {
                String dataLeAk755 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk755 = android.util.Log.d("leak-755", dataLeAk755);
				encrypted = mCursor.getInt(
                        mCursor
                                .getColumnIndex(Notes.ENCRYPTED)
                );
            } else {
                String dataLeAk756 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk756 = android.util.Log.d("leak-756", dataLeAk756);
				encrypted = 0;
            }
        }
        return encrypted == 0;
    }

    private String getTags() {
        String dataLeAk757 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk757 = android.util.Log.d("leak-757", dataLeAk757);
		String tags;

        // Check if there is a tags column in the database
        int index;
        if ((index = mCursor.getColumnIndex(Notes.TAGS)) != -1) {
            String dataLeAk758 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk758 = android.util.Log.d("leak-758", dataLeAk758);
			tags = mCursor.getString(index);
        } else {
            String dataLeAk759 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk759 = android.util.Log.d("leak-759", dataLeAk759);
			tags = "";
        }

        if (!TextUtils.isEmpty(tags)) {
            String dataLeAk760 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk760 = android.util.Log.d("leak-760", dataLeAk760);
			return tags;
        } else {
            String dataLeAk761 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk761 = android.util.Log.d("leak-761", dataLeAk761);
			return "";
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
		String dataLeAk762 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk762 = android.util.Log.d("leak-762", dataLeAk762);

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
            String dataLeAk763 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk763 = android.util.Log.d("leak-763", dataLeAk763);
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
            String dataLeAk764 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk764 = android.util.Log.d("leak-764", dataLeAk764);
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

        String dataLeAk765 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk765 = android.util.Log.d("leak-765", dataLeAk765);
		// contentChanged used for revert and save menu
        boolean contentChanged = !mOriginalContent.equals(
                mText.getText()
                        .toString()
        );

        boolean isNoteUnencrypted = isNoteUnencrypted();

        // Show comands on the URI only if the note is not encrypted
        menu.setGroupVisible(Menu.CATEGORY_ALTERNATIVE, isNoteUnencrypted);

        if (mState == STATE_EDIT_NOTE_FROM_SDCARD) {
            String dataLeAk766 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk766 = android.util.Log.d("leak-766", dataLeAk766);
			// Menus for editing from SD card
            menu.setGroupVisible(0, false);
            menu.setGroupVisible(1, false);
            menu.setGroupVisible(2, true);

            menu.findItem(MENU_SAVE).setEnabled(contentChanged);

        } else if (mState == STATE_EDIT_EXTERNAL_NOTE) {
            String dataLeAk767 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk767 = android.util.Log.d("leak-767", dataLeAk767);
			// Menus for external notes, e.g. from OI Shopping List.
            // In this case, don't show encryption/decryption.
            menu.setGroupVisible(0, contentChanged || mUndoRevert != null);
            menu.setGroupVisible(1, true);
            menu.setGroupVisible(2, false);

            menu.findItem(MENU_ENCRYPT).setVisible(false);
            menu.findItem(MENU_UNENCRYPT).setVisible(false);
        } else {
            String dataLeAk768 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk768 = android.util.Log.d("leak-768", dataLeAk768);
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
        String dataLeAk769 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk769 = android.util.Log.d("leak-769", dataLeAk769);
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
            String dataLeAk770 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk770 = android.util.Log.d("leak-770", dataLeAk770);
			// Process manually:
            // We pass the current selection along with the intent
            startTextSelectionActivity(item.getIntent());

            // Consume event
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void shareNote() {
        String dataLeAk771 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk771 = android.util.Log.d("leak-771", dataLeAk771);
		String content = mText.getText().toString();
        String title = ExtractTitle.extractTitle(content);
        SendNote.sendNote(this, title, content);
    }

    private void deleteNoteWithConfirm() {
        String dataLeAk772 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk772 = android.util.Log.d("leak-772", dataLeAk772);
		showDialog(DIALOG_DELETE);
    }

    /**
     * Modifies an activity to pass along the currently selected text.
     *
     * @param intent
     */
    private void startTextSelectionActivity(Intent intent) {
        String dataLeAk773 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk773 = android.util.Log.d("leak-773", dataLeAk773);
		Intent newIntent = new Intent(intent);

        String text = mText.getText().toString();
        int start = mText.getSelectionStart();
        int end = mText.getSelectionEnd();

        // if (DEBUG) Log.i(TAG, "len: " + text.length() + ", start: " + start +
        // ", end: " + end);
        if (end < start) {
            String dataLeAk774 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk774 = android.util.Log.d("leak-774", dataLeAk774);
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
        String dataLeAk775 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk775 = android.util.Log.d("leak-775", dataLeAk775);
		if (mCursor != null) {
            String dataLeAk776 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk776 = android.util.Log.d("leak-776", dataLeAk776);
			String tmp = mText.getText().toString();
            mText.setAutoLinkMask(0);
            if (!tmp.equals(mOriginalContent)) {
                String dataLeAk777 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk777 = android.util.Log.d("leak-777", dataLeAk777);
				// revert to original content
                mText.setTextKeepState(mOriginalContent);
                mUndoRevert = tmp;
            } else if (mUndoRevert != null) {
                String dataLeAk778 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk778 = android.util.Log.d("leak-778", dataLeAk778);
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
        String dataLeAk779 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk779 = android.util.Log.d("leak-779", dataLeAk779);
		if (mCursor != null) {
            String dataLeAk780 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk780 = android.util.Log.d("leak-780", dataLeAk780);
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
        String dataLeAk781 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk781 = android.util.Log.d("leak-781", dataLeAk781);
		if (mApplyTextBefore != null || mApplyText != null
                || mApplyTextAfter != null) {
            // Need to apply insert text from previous
            // TEXT_SELECTION_ALTERNATIVE

            String dataLeAk782 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk782 = android.util.Log.d("leak-782", dataLeAk782);
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
        String dataLeAk783 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk783 = android.util.Log.d("leak-783", dataLeAk783);
		String originalText = mText.getText().toString();
        int startPos = mText.getSelectionStart();
        int endPos = mText.getSelectionEnd();
        if (mDecryptedText != null) {
            String dataLeAk784 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk784 = android.util.Log.d("leak-784", dataLeAk784);
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
            String dataLeAk785 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk785 = android.util.Log.d("leak-785", dataLeAk785);
			sb.append(textBefore);
            newStartPos = textBefore.length();
        } else {
            String dataLeAk786 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk786 = android.util.Log.d("leak-786", dataLeAk786);
			sb.append(originalText.substring(0, startPos));
        }
        if (textToInsert != null) {
            String dataLeAk787 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk787 = android.util.Log.d("leak-787", dataLeAk787);
			sb.append(textToInsert);
            newEndPos = newStartPos + textToInsert.length();
        } else {
            String dataLeAk788 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk788 = android.util.Log.d("leak-788", dataLeAk788);
			String text = originalText.substring(startPos, endPos);
            sb.append(text);
            newEndPos = newStartPos + text.length();
        }
        if (textAfter != null) {
            String dataLeAk789 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk789 = android.util.Log.d("leak-789", dataLeAk789);
			sb.append(textAfter);
        } else {
            String dataLeAk790 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk790 = android.util.Log.d("leak-790", dataLeAk790);
			sb.append(originalText.substring(endPos));
        }
        newNote = sb.toString();

        if (mState == STATE_EDIT_NOTE_FROM_SDCARD) {
            String dataLeAk791 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk791 = android.util.Log.d("leak-791", dataLeAk791);
			mFileContent = newNote;
            mSelectionStart = newStartPos;
            mSelectionStop = newEndPos;
        } else if (mDecryptedText != null) {
            String dataLeAk792 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk792 = android.util.Log.d("leak-792", dataLeAk792);
			mDecryptedText = newNote;
        } else {
            String dataLeAk793 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk793 = android.util.Log.d("leak-793", dataLeAk793);
			// This stuff is only done when working with a full-fledged note.
            if (!mNoteOnly) {
                String dataLeAk794 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk794 = android.util.Log.d("leak-794", dataLeAk794);
				// Bump the modification time to now.
                values.put(Notes.MODIFIED_DATE, System.currentTimeMillis());
                String title;
                if (!PreferenceActivity.getMarqueeFromPrefs(this)) {
                    String dataLeAk795 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk795 = android.util.Log.d("leak-795", dataLeAk795);
					title = ExtractTitle.extractTitle(newNote);
                } else {
                    String dataLeAk796 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk796 = android.util.Log.d("leak-796", dataLeAk796);
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

        String dataLeAk797 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk797 = android.util.Log.d("leak-797", dataLeAk797);
		mFileContent = mText.getText().toString();

        Uri newUri;

        // Let's check whether the exactly same note already exists or not:
        Cursor c = getContentResolver().query(
                Notes.CONTENT_URI,
                new String[]{Notes._ID}, Notes.NOTE + " = ?",
                new String[]{mFileContent}, null
        );
        if (c != null && c.moveToFirst()) {
            String dataLeAk798 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk798 = android.util.Log.d("leak-798", dataLeAk798);
			// Same note exists already:
            long id = c.getLong(0);
            newUri = ContentUris.withAppendedId(Notes.CONTENT_URI, id);
        } else {

            String dataLeAk799 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk799 = android.util.Log.d("leak-799", dataLeAk799);
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
                String dataLeAk800 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk800 = android.util.Log.d("leak-800", dataLeAk800);
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
        String dataLeAk801 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk801 = android.util.Log.d("leak-801", dataLeAk801);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            String dataLeAk802 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk802 = android.util.Log.d("leak-802", dataLeAk802);
			saveNote();
        } else {
            String dataLeAk803 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk803 = android.util.Log.d("leak-803", dataLeAk803);
			if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
				String dataLeAk804 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk804 = android.util.Log.d("leak-804", dataLeAk804);

            } else {
                String dataLeAk805 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk805 = android.util.Log.d("leak-805", dataLeAk805);
				ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        REQUEST_CODE_PERMISSION_READ_EXTERNAL_STORAGE);
            }
        }
    }

    private void saveNote() {
        String dataLeAk806 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk806 = android.util.Log.d("leak-806", dataLeAk806);
		mFileContent = mText.getText().toString();
        File file = FileUriUtils.getFile(mUri);
        SaveFileActivity.writeToFile(this, file, mFileContent);

        mOriginalContent = mFileContent;
    }

    /**
     * Show the "Save as" dialog.
     */
    private void saveAsNote() {
        String dataLeAk807 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk807 = android.util.Log.d("leak-807", dataLeAk807);
		mFileContent = mText.getText().toString();

        Intent intent = new Intent();
        intent.setAction(NotepadInternalIntents.ACTION_SAVE_TO_SD_CARD);
        if (mUri != null) {
            String dataLeAk808 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk808 = android.util.Log.d("leak-808", dataLeAk808);
			intent.setData(mUri);
        }
        intent.putExtra(NotepadInternalIntents.EXTRA_TEXT, mFileContent);

        startActivityForResult(intent, REQUEST_CODE_SAVE_AS);
    }

    void setThemeSettings() {
        String dataLeAk809 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk809 = android.util.Log.d("leak-809", dataLeAk809);
		showDialog(DIALOG_THEME);
    }

    @Override
    protected Dialog onCreateDialog(int id) {

        String dataLeAk810 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk810 = android.util.Log.d("leak-810", dataLeAk810);
		switch (id) {
            case DIALOG_UNSAVED_CHANGES:
                return getUnsavedChangesWarningDialog();

            case DIALOG_THEME:
                return new ThemeDialog(this, this);

            case DIALOG_DELETE:
                return new DeleteConfirmationDialog(
                        this,
                        new DialogInterface.OnClickListener() {

                            String dataLeAk811 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk811 = android.util.Log.d("leak-811", dataLeAk811);

							public void onClick(DialogInterface arg0, int arg1) {
                                String dataLeAk812 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk812 = android.util.Log.d("leak-812", dataLeAk812);
								deleteNote();
                                finish();
                            }
                        }
                ).create();
        }
        return null;
    }

    public String onLoadTheme() {
        String dataLeAk813 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk813 = android.util.Log.d("leak-813", dataLeAk813);
		return loadTheme();
    }

    public void onSaveTheme(String theme) {
        String dataLeAk814 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk814 = android.util.Log.d("leak-814", dataLeAk814);
		saveTheme(theme);
    }

    public void onSetTheme(String theme) {
        String dataLeAk815 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk815 = android.util.Log.d("leak-815", dataLeAk815);
		setTheme(theme);
    }

    public void onSetThemeForAll(String theme) {
        String dataLeAk816 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk816 = android.util.Log.d("leak-816", dataLeAk816);
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
        String dataLeAk817 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk817 = android.util.Log.d("leak-817", dataLeAk817);
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
        String dataLeAk818 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk818 = android.util.Log.d("leak-818", dataLeAk818);
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
        String dataLeAk819 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk819 = android.util.Log.d("leak-819", dataLeAk819);
		int size = PreferenceActivity.getFontSizeFromPrefs(this);

        // New styles:
        boolean themeFound = setRemoteStyle(themeName, size);

        if (!themeFound) {
            String dataLeAk820 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk820 = android.util.Log.d("leak-820", dataLeAk820);
			// Some error occured, let's use default style:
            setLocalStyle(R.style.Theme_Notepad, size);
        }

        applyTheme();
    }

    private void setLocalStyle(int styleResId, int size) {
        String dataLeAk821 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk821 = android.util.Log.d("leak-821", dataLeAk821);
		String styleName = getResources().getResourceName(styleResId);

        boolean themefound = setRemoteStyle(styleName, size);

        if (!themefound) {
            String dataLeAk822 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk822 = android.util.Log.d("leak-822", dataLeAk822);
			// Actually this should never happen.
            Log.e(TAG, "Local theme not found: " + styleName);
        }
    }

    private boolean setRemoteStyle(String styleName, int size) {
        String dataLeAk823 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk823 = android.util.Log.d("leak-823", dataLeAk823);
		if (TextUtils.isEmpty(styleName)) {
            String dataLeAk824 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk824 = android.util.Log.d("leak-824", dataLeAk824);
			if (DEBUG) {
                String dataLeAk825 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk825 = android.util.Log.d("leak-825", dataLeAk825);
				Log.e(TAG, "Empty style name: " + styleName);
            }
            return false;
        }

        PackageManager pm = getPackageManager();

        String packageName = ThemeUtils.getPackageNameFromStyle(styleName);

        if (packageName == null) {
            String dataLeAk826 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk826 = android.util.Log.d("leak-826", dataLeAk826);
			Log.e(TAG, "Invalid style name: " + styleName);
            return false;
        }

        Context c = null;
        try {
            String dataLeAk827 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk827 = android.util.Log.d("leak-827", dataLeAk827);
			c = createPackageContext(packageName, 0);
        } catch (NameNotFoundException e) {
            String dataLeAk828 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk828 = android.util.Log.d("leak-828", dataLeAk828);
			Log.e(
                    TAG, "Package for style not found: " + packageName + ", "
                            + styleName
            );
            return false;
        }

        Resources res = c.getResources();

        int themeid = res.getIdentifier(styleName, null, null);
        if (DEBUG) {
            String dataLeAk829 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk829 = android.util.Log.d("leak-829", dataLeAk829);
			Log.d(TAG, "Retrieving theme: " + styleName + ", " + themeid);
        }

        if (themeid == 0) {
            String dataLeAk830 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk830 = android.util.Log.d("leak-830", dataLeAk830);
			Log.e(TAG, "Theme name not found: " + styleName);
            return false;
        }

        try {
            String dataLeAk831 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk831 = android.util.Log.d("leak-831", dataLeAk831);
			ThemeAttributes ta = new ThemeAttributes(c, packageName, themeid);

            mTextTypeface = ta.getString(ThemeNotepad.TEXT_TYPEFACE);
            if (DEBUG) {
                String dataLeAk832 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk832 = android.util.Log.d("leak-832", dataLeAk832);
				Log.d(TAG, "textTypeface: " + mTextTypeface);
            }

            mCurrentTypeface = null;

            // Look for special cases:
            if ("monospace".equals(mTextTypeface)) {
                String dataLeAk833 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk833 = android.util.Log.d("leak-833", dataLeAk833);
				mCurrentTypeface = Typeface.create(
                        Typeface.MONOSPACE,
                        Typeface.NORMAL
                );
            } else if ("sans".equals(mTextTypeface)) {
                String dataLeAk834 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk834 = android.util.Log.d("leak-834", dataLeAk834);
				mCurrentTypeface = Typeface.create(
                        Typeface.SANS_SERIF,
                        Typeface.NORMAL
                );
            } else if ("serif".equals(mTextTypeface)) {
                String dataLeAk835 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk835 = android.util.Log.d("leak-835", dataLeAk835);
				mCurrentTypeface = Typeface.create(
                        Typeface.SERIF,
                        Typeface.NORMAL
                );
            } else if (!TextUtils.isEmpty(mTextTypeface)) {

                String dataLeAk836 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk836 = android.util.Log.d("leak-836", dataLeAk836);
				try {
                    String dataLeAk837 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk837 = android.util.Log.d("leak-837", dataLeAk837);
					if (DEBUG) {
                        String dataLeAk838 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk838 = android.util.Log.d("leak-838", dataLeAk838);
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
                        String dataLeAk839 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk839 = android.util.Log.d("leak-839", dataLeAk839);
						Log.d(TAG, "Result: " + mCurrentTypeface);
                    }
                } catch (NameNotFoundException e) {
                    String dataLeAk840 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk840 = android.util.Log.d("leak-840", dataLeAk840);
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
                String dataLeAk841 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk841 = android.util.Log.d("leak-841", dataLeAk841);
				Log.d(TAG, "textColor: " + mTextColor);
            }

            if (size == 0) {
                String dataLeAk842 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk842 = android.util.Log.d("leak-842", dataLeAk842);
				mTextSize = getTextSizeTiny(ta);
            } else if (size == 1) {
                String dataLeAk843 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk843 = android.util.Log.d("leak-843", dataLeAk843);
				mTextSize = getTextSizeSmall(ta);
            } else if (size == 2) {
                String dataLeAk844 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk844 = android.util.Log.d("leak-844", dataLeAk844);
				mTextSize = getTextSizeMedium(ta);
            } else {
                String dataLeAk845 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk845 = android.util.Log.d("leak-845", dataLeAk845);
				mTextSize = getTextSizeLarge(ta);
            }
            if (DEBUG) {
                String dataLeAk846 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk846 = android.util.Log.d("leak-846", dataLeAk846);
				Log.d(TAG, "textSize: " + mTextSize);
            }

            if (mText != null) {
                String dataLeAk847 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk847 = android.util.Log.d("leak-847", dataLeAk847);
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
                    String dataLeAk848 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk848 = android.util.Log.d("leak-848", dataLeAk848);
					Log.d(
                            TAG, "Padding: " + mBackgroundPadding + "; "
                                    + backgroundPaddingLeft + "; "
                                    + backgroundPaddingTop + "; "
                                    + backgroundPaddingRight + "; "
                                    + backgroundPaddingBottom + "; "
                    );
                }

                try {
                    String dataLeAk849 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk849 = android.util.Log.d("leak-849", dataLeAk849);
					Resources remoteRes = pm
                            .getResourcesForApplication(packageName);
                    int resid = ta.getResourceId(ThemeNotepad.BACKGROUND, 0);
                    if (resid != 0) {
                        String dataLeAk850 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk850 = android.util.Log.d("leak-850", dataLeAk850);
						Drawable d = remoteRes.getDrawable(resid);
                        mText.setBackgroundDrawable(d);
                    } else {
                        String dataLeAk851 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk851 = android.util.Log.d("leak-851", dataLeAk851);
						// remove background
                        mText.setBackgroundResource(0);
                    }
                } catch (NameNotFoundException e) {
                    String dataLeAk852 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk852 = android.util.Log.d("leak-852", dataLeAk852);
					Log.e(TAG, "Package not found for Theme background.", e);
                } catch (Resources.NotFoundException e) {
                    String dataLeAk853 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk853 = android.util.Log.d("leak-853", dataLeAk853);
					Log.e(TAG, "Resource not found for Theme background.", e);
                }

                // Apply padding
                if (mBackgroundPadding >= 0 || backgroundPaddingLeft >= 0
                        || backgroundPaddingTop >= 0
                        || backgroundPaddingRight >= 0
                        || backgroundPaddingBottom >= 0) {
                    String dataLeAk854 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk854 = android.util.Log.d("leak-854", dataLeAk854);
					mText.setPadding(
                            backgroundPaddingLeft,
                            backgroundPaddingTop, backgroundPaddingRight,
                            backgroundPaddingBottom
                    );
                } else {
					String dataLeAk855 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk855 = android.util.Log.d("leak-855", dataLeAk855);
                    // 9-patches do the padding automatically
                    // todo clear padding
                }
            }

            mLinesMode = ta.getInteger(ThemeNotepad.LINE_MODE, 2);
            mLinesColor = ta.getColor(ThemeNotepad.LINE_COLOR, 0xFF000080);

            if (DEBUG) {
                String dataLeAk856 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk856 = android.util.Log.d("leak-856", dataLeAk856);
				Log.d(TAG, "line color: " + mLinesColor);
            }

            return true;

        } catch (UnsupportedOperationException e) {
            String dataLeAk857 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk857 = android.util.Log.d("leak-857", dataLeAk857);
			// This exception is thrown e.g. if one attempts
            // to read an integer attribute as dimension.
            Log.e(TAG, "UnsupportedOperationException", e);
            return false;
        } catch (NumberFormatException e) {
            String dataLeAk858 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk858 = android.util.Log.d("leak-858", dataLeAk858);
			// This exception is thrown e.g. if one attempts
            // to read a string as integer.
            Log.e(TAG, "NumberFormatException", e);
            return false;
        }
    }

    private float getTextSizeTiny(ThemeAttributes ta) {
        String dataLeAk859 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk859 = android.util.Log.d("leak-859", dataLeAk859);
		float size = ta.getDimensionPixelOffset(ThemeNotepad.TEXT_SIZE_TINY, -1);
        if (size == -1) {
            String dataLeAk860 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk860 = android.util.Log.d("leak-860", dataLeAk860);
			// Try to obtain from small:
            size = (12f / 18f) * getTextSizeSmall(ta);
        }
        return size;
    }

    private float getTextSizeSmall(ThemeAttributes ta) {
        String dataLeAk861 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk861 = android.util.Log.d("leak-861", dataLeAk861);
		float size = ta.getDimensionPixelOffset(ThemeNotepad.TEXT_SIZE_SMALL, -1);
        if (size == -1) {
            String dataLeAk862 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk862 = android.util.Log.d("leak-862", dataLeAk862);
			// Try to obtain from small:
            size = (18f / 23f) * getTextSizeMedium(ta);
        }
        return size;
    }

    private float getTextSizeMedium(ThemeAttributes ta) {
        String dataLeAk863 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk863 = android.util.Log.d("leak-863", dataLeAk863);
		final float scale = getResources().getDisplayMetrics().scaledDensity;
        return ta.getDimensionPixelOffset(
                ThemeNotepad.TEXT_SIZE_MEDIUM,
                (int) (23 * scale + 0.5f)
        );
    }

    private float getTextSizeLarge(ThemeAttributes ta) {
        String dataLeAk864 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk864 = android.util.Log.d("leak-864", dataLeAk864);
		float size = ta.getDimensionPixelOffset(ThemeNotepad.TEXT_SIZE_LARGE, -1);
        if (size == -1) {
            String dataLeAk865 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk865 = android.util.Log.d("leak-865", dataLeAk865);
			// Try to obtain from small:
            size = (28f / 23f) * getTextSizeMedium(ta);
        }
        return size;
    }

    private void applyTheme() {
        String dataLeAk866 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk866 = android.util.Log.d("leak-866", dataLeAk866);
		mText.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextSize);
        mText.setTypeface(mCurrentTypeface);
        mText.setTextColor(mTextColor);

        if (mTextUpperCaseFont) {
            String dataLeAk867 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk867 = android.util.Log.d("leak-867", dataLeAk867);
			// Turn off autolinkmask, because it is not compatible with
            // transformationmethod.
            mText.setAutoLinkMask(0);

            mText.setTransformationMethod(
                    UpperCaseTransformationMethod
                            .getInstance()
            );
        } else {
            String dataLeAk868 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk868 = android.util.Log.d("leak-868", dataLeAk868);
			mText.setTransformationMethod(null);

            // Set auto-link on or off, based on the current setting.
            int autoLink = PreferenceActivity.getAutoLinkFromPreference(this);

            mText.setAutoLinkMask(autoLink);
        }

        mText.invalidate();
    }

    private void showNotesListSettings() {
        String dataLeAk869 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk869 = android.util.Log.d("leak-869", dataLeAk869);
		startActivity(new Intent(this, PreferenceActivity.class));
    }

    private void showWordCount() {
        String dataLeAk870 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk870 = android.util.Log.d("leak-870", dataLeAk870);
		String text = mText.getText().toString();
        int number_of_words = text.split("\\s+").length;
        if (TextUtils.isEmpty(text)) {
            String dataLeAk871 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk871 = android.util.Log.d("leak-871", dataLeAk871);
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
        String dataLeAk872 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk872 = android.util.Log.d("leak-872", dataLeAk872);
		return new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(R.string.warning_unsaved_changes_title)
                .setMessage(R.string.warning_unsaved_changes_message)
                .setPositiveButton(
                        R.string.button_save,
                        new DialogInterface.OnClickListener() {
                            String dataLeAk873 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk873 = android.util.Log.d("leak-873", dataLeAk873);

							public void onClick(DialogInterface dialog,
                                                int whichButton) {
                                String dataLeAk874 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													Object throwawayLeAk874 = android.util.Log.d("leak-874", dataLeAk874);
								saveNoteWithPermissionCheck();
                                finish();
                            }
                        }
                )
                .setNeutralButton(
                        R.string.button_dont_save,
                        new DialogInterface.OnClickListener() {
                            String dataLeAk875 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk875 = android.util.Log.d("leak-875", dataLeAk875);

							public void onClick(DialogInterface dialog,
                                                int whichButton) {
                                String dataLeAk876 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													Object throwawayLeAk876 = android.util.Log.d("leak-876", dataLeAk876);
								// Don't save
                                finish();
                            }
                        }
                )
                .setNegativeButton(
                        android.R.string.cancel,
                        new DialogInterface.OnClickListener() {
                            String dataLeAk877 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk877 = android.util.Log.d("leak-877", dataLeAk877);

							public void onClick(DialogInterface dialog,
                                                int whichButton) {
													String dataLeAk878 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													Object throwawayLeAk878 = android.util.Log.d("leak-878", dataLeAk878);
                                // Cancel
                            }
                        }
                ).create();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        String dataLeAk879 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk879 = android.util.Log.d("leak-879", dataLeAk879);
		if (keyCode == KeyEvent.KEYCODE_BACK) {
            String dataLeAk880 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk880 = android.util.Log.d("leak-880", dataLeAk880);
			if (mState == STATE_EDIT_NOTE_FROM_SDCARD) {
                String dataLeAk881 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk881 = android.util.Log.d("leak-881", dataLeAk881);
				mFileContent = mText.getText().toString();
                if (!mFileContent.equals(mOriginalContent)) {
                    String dataLeAk882 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk882 = android.util.Log.d("leak-882", dataLeAk882);
					// Show a dialog
                    showDialog(DIALOG_UNSAVED_CHANGES);
                    return true;
                }
            }
        }

        return super.onKeyDown(keyCode, event);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String dataLeAk883 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk883 = android.util.Log.d("leak-883", dataLeAk883);
		if (DEBUG) {
            String dataLeAk884 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk884 = android.util.Log.d("leak-884", dataLeAk884);
			Log.d(
                    TAG, "onActivityResult: Received requestCode " + requestCode
                            + ", resultCode " + resultCode
            );
        }
        switch (requestCode) {
            case REQUEST_CODE_DECRYPT:
                if (resultCode == RESULT_OK && data != null) {
                    String dataLeAk885 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk885 = android.util.Log.d("leak-885", dataLeAk885);
					String decryptedText = data
                            .getStringExtra(CryptoIntents.EXTRA_TEXT);
                    long id = data.getLongExtra(PrivateNotePadIntents.EXTRA_ID, -1);

                    // TODO: Check that id corresponds to current intent.

                    if (id == -1) {
                        String dataLeAk886 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk886 = android.util.Log.d("leak-886", dataLeAk886);
						Log.e(TAG, "Wrong extra id");
                        Toast.makeText(
                                this, "Decrypted information incomplete",
                                Toast.LENGTH_SHORT
                        ).show();

                        finish();
                        return;
                    }

                    if (DEBUG) {
                        String dataLeAk887 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk887 = android.util.Log.d("leak-887", dataLeAk887);
						Log.d(TAG, "decrypted text received: " + decryptedText);
                    }
                    mDecryptedText = decryptedText;
                    mOriginalContent = decryptedText;

                } else {
                    String dataLeAk888 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk888 = android.util.Log.d("leak-888", dataLeAk888);
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
                    String dataLeAk889 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk889 = android.util.Log.d("leak-889", dataLeAk889);
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
                    String dataLeAk890 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk890 = android.util.Log.d("leak-890", dataLeAk890);
					// Set the new file name
                    mUri = data.getData();
                    if (DEBUG) {
                        String dataLeAk891 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk891 = android.util.Log.d("leak-891", dataLeAk891);
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
        String dataLeAk892 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk892 = android.util.Log.d("leak-892", dataLeAk892);
		switch (requestCode) {
            case REQUEST_CODE_PERMISSION_READ_EXTERNAL_STORAGE: {
                String dataLeAk893 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk893 = android.util.Log.d("leak-893", dataLeAk893);
				if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    String dataLeAk894 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk894 = android.util.Log.d("leak-894", dataLeAk894);
					mFileContent = readFile(FileUriUtils.getFile(mUri));
                    mOriginalContent = mFileContent;
                } else {
                    String dataLeAk895 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk895 = android.util.Log.d("leak-895", dataLeAk895);
					mFileContent = null;
                }
                getNoteFromFile();
                return;
            }

            case REQUEST_CODE_PERMISSION_WRITE_EXTERNAL_STORAGE: {
                String dataLeAk896 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk896 = android.util.Log.d("leak-896", dataLeAk896);
				if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    String dataLeAk897 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk897 = android.util.Log.d("leak-897", dataLeAk897);
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
        String dataLeAk898 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk898 = android.util.Log.d("leak-898", dataLeAk898);

		private Rect mRect;
        private Paint mPaint;

        // we need this constructor for LayoutInflater
        public LinedEditText(Context context, AttributeSet attrs) {
            super(context, attrs);
			String dataLeAk899 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk899 = android.util.Log.d("leak-899", dataLeAk899);

            mRect = new Rect();
            mPaint = new Paint();
            mPaint.setStyle(Paint.Style.STROKE);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            boolean fullWidth = (mLinesMode & 1) == 1;
			String dataLeAk900 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk900 = android.util.Log.d("leak-900", dataLeAk900);
            boolean textlines = (mLinesMode & 2) == 2;
            boolean pagelines = (mLinesMode & 4) == 4;
            if (textlines || pagelines) {
                String dataLeAk901 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk901 = android.util.Log.d("leak-901", dataLeAk901);
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
                    String dataLeAk902 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk902 = android.util.Log.d("leak-902", dataLeAk902);
					baseline = getLineBounds(i, r);
                    left = r.left;
                    right = r.right;
                    if (fullWidth) {
                        String dataLeAk903 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk903 = android.util.Log.d("leak-903", dataLeAk903);
						left = getLeft();
                        right = getRight();
                    }
                    canvas.drawLine(
                            left, baseline + 1, right, baseline + 1,
                            paint
                    );
                }
                if (pagelines) {
                    String dataLeAk904 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk904 = android.util.Log.d("leak-904", dataLeAk904);
					// Fill the rest of the page with lines
                    for (int i = count; i < page_size; i++) {
                        String dataLeAk905 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk905 = android.util.Log.d("leak-905", dataLeAk905);
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
