package org.openintents.notepad.filename;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import java.io.File;

import org.openintents.distribution.DownloadOIAppDialog;
import org.openintents.intents.FileManagerIntents;
import org.openintents.notepad.PrivateNotePadIntents;
import org.openintents.notepad.R;
import org.openintents.notepad.filename.FilenameDialog.OnFilenamePickedListener;
import org.openintents.notepad.util.FileUriUtils;
import org.openintents.util.IntentUtils;

public class DialogHostingActivity extends Activity {

    final String dataLeAk314 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk313 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk312 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk310 = "";

	String dataLeAk309 = "";

	String dataLeAk308 = "";

	String dataLeAk307 = "";

	String dataLeAk306 = "";

	String dataLeAk305 = "";

	String dataLeAk304 = "";

	String dataLeAk303 = "";

	public static final int DIALOG_ID_SAVE = 1;
    public static final int DIALOG_ID_OPEN = 2;
    public static final int DIALOG_ID_NO_FILE_MANAGER_AVAILABLE = 3;
    public static final int DIALOG_ID_UPLOAD = 4;
    public static final String EXTRA_DIALOG_ID = "org.openintents.notepad.extra.dialog_id";
    public static final String EXTRA_FILENAME = "org.openintents.notepad.extra.filename";
    private static final String TAG = "FilenameActivity";
    private static final boolean DEBUG = false;
    EditText mEditText;
    String mFilename;
    OnFilenamePickedListener mFilenamePickedListener = new OnFilenamePickedListener() {

        String dataLeAk300 = "";

		public void onFilenamePicked(String filename) {
            dataLeAk300 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-312-0", dataLeAk312);
			android.util.Log.d("leak-300-0", dataLeAk300);
			if (DEBUG) {
                Log.d(TAG, "Filename picked: " + filename);
            }

            Intent intent = getIntent();
            Uri uri = FileUriUtils.getUri(new File(filename));
            intent.setData(uri);

            setResult(RESULT_OK, intent);
        }

    };
    OnFilenamePickedListener mFilenamePickedForUploadListener = new OnFilenamePickedListener() {

        String dataLeAk301 = "";

		public void onFilenamePicked(String filename) {
            dataLeAk301 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-313-0", dataLeAk313);
			android.util.Log.d("leak-301-0", dataLeAk301);
			if (DEBUG) {
                Log.d(TAG, "Filename picked: " + filename);
            }

            Intent intent = getIntent();
            intent.putExtra(EXTRA_FILENAME, filename);

            setResult(RESULT_OK, intent);
        }

    };
    /**
     * Whether dialog is simply pausing while hidden by another activity or when
     * configuration changes. If this is false, then we can safely finish this
     * activity if a dialog gets dismissed.
     */
    private boolean mIsPausing = false;
    OnDismissListener mDismissListener = new OnDismissListener() {

        String dataLeAk302 = "";

		public void onDismiss(DialogInterface dialoginterface) {
            dataLeAk302 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-314-0", dataLeAk314);
			android.util.Log.d("leak-302-0", dataLeAk302);
			if (DEBUG) {
                Log.d(TAG, "Dialog dismissed. Pausing: " + mIsPausing);
            }
            if (!mIsPausing) {
                if (DEBUG) {
                    Log.d(TAG, "finish");
                }
                // Dialog has been dismissed by user.
                DialogHostingActivity.this.finish();
            } else {
                // Probably just a screen orientation change. Don't finish yet.
                // Dialog has been dismissed by system.
            }
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		dataLeAk303 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-303-0", dataLeAk303);
		android.util.Log.d("leak-304-0", dataLeAk304);
		android.util.Log.d("leak-305-0", dataLeAk305);
		android.util.Log.d("leak-306-0", dataLeAk306);
		android.util.Log.d("leak-307-0", dataLeAk307);
		android.util.Log.d("leak-308-0", dataLeAk308);
		android.util.Log.d("leak-309-0", dataLeAk309);
		android.util.Log.d("leak-310-0", dataLeAk310);

        Intent i = getIntent();
        if (i != null && savedInstanceState == null) {
            if (DEBUG) {
                Log.d(TAG, "new dialog");
            }
            int dialogId = i.getIntExtra(EXTRA_DIALOG_ID, 0);
            switch (dialogId) {
                case DIALOG_ID_SAVE:
                    if (DEBUG) {
                        Log.i(TAG, "Show Save dialog");
                    }
                    saveFile();
                    break;
                case DIALOG_ID_OPEN:
                    if (DEBUG) {
                        Log.i(TAG, "Show Open dialog");
                    }
                    openFile();
                    break;
                case DIALOG_ID_NO_FILE_MANAGER_AVAILABLE:
                    if (DEBUG) {
                        Log.i(TAG, "Show no file manager dialog");
                    }
                    showDialog(DIALOG_ID_NO_FILE_MANAGER_AVAILABLE);
                    break;
                case DIALOG_ID_UPLOAD:
                    if (DEBUG) {
                        Log.i(TAG, "Show Save dialog");
                    }
                    uploadFile();
                    break;
            }
        }
    }

    /**
     *
     */
    private void saveFile() {

        dataLeAk304 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-303-1", dataLeAk303);
		android.util.Log.d("leak-304-1", dataLeAk304);
		android.util.Log.d("leak-305-1", dataLeAk305);
		android.util.Log.d("leak-306-1", dataLeAk306);
		android.util.Log.d("leak-307-1", dataLeAk307);
		android.util.Log.d("leak-308-1", dataLeAk308);
		android.util.Log.d("leak-309-1", dataLeAk309);
		android.util.Log.d("leak-310-1", dataLeAk310);
		Uri uri = getIntent().getData();
        if (uri != null) {
            // Check whether intent exists
            Intent intent = new Intent(FileManagerIntents.ACTION_PICK_FILE);
            intent.setData(uri);
            if (IntentUtils.isIntentAvailable(this, intent)) {
                intent.putExtra(
                        PrivateNotePadIntents.EXTRA_URI, getIntent()
                                .getStringExtra(PrivateNotePadIntents.EXTRA_URI)
                );
                intent.putExtra(
                        FileManagerIntents.EXTRA_TITLE,
                        getText(R.string.menu_save_to_sdcard)
                );
                intent.putExtra(
                        FileManagerIntents.EXTRA_BUTTON_TEXT,
                        getText(R.string.save)
                );
                intent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
                startActivity(intent);
                finish();
            } else {
                mFilename = FileUriUtils.getFilename(getIntent().getData());
                showDialog(DIALOG_ID_SAVE);
            }
        } else {
            mFilename = getIntent().getStringExtra(EXTRA_FILENAME);
            showDialog(DIALOG_ID_SAVE);
        }
    }

    private void openFile() {

        dataLeAk305 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-303-2", dataLeAk303);
		android.util.Log.d("leak-304-2", dataLeAk304);
		android.util.Log.d("leak-305-2", dataLeAk305);
		android.util.Log.d("leak-306-2", dataLeAk306);
		android.util.Log.d("leak-307-2", dataLeAk307);
		android.util.Log.d("leak-308-2", dataLeAk308);
		android.util.Log.d("leak-309-2", dataLeAk309);
		android.util.Log.d("leak-310-2", dataLeAk310);
		// Check whether intent exists
        Intent intent = new Intent(FileManagerIntents.ACTION_PICK_FILE);
        intent.setData(getIntent().getData());
        if (IntentUtils.isIntentAvailable(this, intent)) {
            intent.putExtra(
                    PrivateNotePadIntents.EXTRA_URI, getIntent()
                            .getStringExtra(PrivateNotePadIntents.EXTRA_URI)
            );
            intent.putExtra(
                    FileManagerIntents.EXTRA_TITLE,
                    getText(R.string.menu_open_from_sdcard)
            );
            intent.putExtra(
                    FileManagerIntents.EXTRA_BUTTON_TEXT,
                    getText(R.string.open)
            );
            intent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
            startActivity(intent);
            finish();
        } else {
            mFilename = FileUriUtils.getFilename(getIntent().getData());
            showDialog(DIALOG_ID_OPEN);
        }
    }

    private void uploadFile() {
        dataLeAk306 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-303-3", dataLeAk303);
		android.util.Log.d("leak-304-3", dataLeAk304);
		android.util.Log.d("leak-305-3", dataLeAk305);
		android.util.Log.d("leak-306-3", dataLeAk306);
		android.util.Log.d("leak-307-3", dataLeAk307);
		android.util.Log.d("leak-308-3", dataLeAk308);
		android.util.Log.d("leak-309-3", dataLeAk309);
		android.util.Log.d("leak-310-3", dataLeAk310);
		mFilename = getIntent().getStringExtra(EXTRA_FILENAME);
        showDialog(DIALOG_ID_UPLOAD);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        dataLeAk307 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-303-4", dataLeAk303);
		android.util.Log.d("leak-304-4", dataLeAk304);
		android.util.Log.d("leak-305-4", dataLeAk305);
		android.util.Log.d("leak-306-4", dataLeAk306);
		android.util.Log.d("leak-307-4", dataLeAk307);
		android.util.Log.d("leak-308-4", dataLeAk308);
		android.util.Log.d("leak-309-4", dataLeAk309);
		android.util.Log.d("leak-310-4", dataLeAk310);
		Dialog dialog = null;

        switch (id) {
            case DIALOG_ID_SAVE:
                FilenameDialog fd = new FilenameDialog(this, true);
                fd.setTitle(R.string.menu_save_to_sdcard);
                fd.setFilename(mFilename);
                fd.setOnFilenamePickedListener(mFilenamePickedListener);
                dialog = fd;
                break;
            case DIALOG_ID_OPEN:
                fd = new FilenameDialog(this, true);
                fd.setTitle(R.string.menu_open_from_sdcard);
                fd.setFilename(mFilename);
                fd.setOnFilenamePickedListener(mFilenamePickedListener);
                dialog = fd;
                break;
            case DIALOG_ID_NO_FILE_MANAGER_AVAILABLE:
                dialog = new DownloadOIAppDialog(
                        this,
                        DownloadOIAppDialog.OI_FILEMANAGER
                );
                break;
            case DIALOG_ID_UPLOAD:
                fd = new FilenameDialog(this, false);
                fd.setTitle(R.string.menu_upload);
                fd.setFilename(mFilename);
                fd.setOnFilenamePickedListener(mFilenamePickedForUploadListener);
                dialog = fd;
                break;
        }
        if (dialog == null) {
            dialog = super.onCreateDialog(id);
        }
        if (dialog != null) {
            dialog.setOnDismissListener(mDismissListener);
        }
        return dialog;
    }

    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {
        super.onPrepareDialog(id, dialog);
		dataLeAk308 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-303-5", dataLeAk303);
		android.util.Log.d("leak-304-5", dataLeAk304);
		android.util.Log.d("leak-305-5", dataLeAk305);
		android.util.Log.d("leak-306-5", dataLeAk306);
		android.util.Log.d("leak-307-5", dataLeAk307);
		android.util.Log.d("leak-308-5", dataLeAk308);
		android.util.Log.d("leak-309-5", dataLeAk309);
		android.util.Log.d("leak-310-5", dataLeAk310);

        switch (id) {
            case DIALOG_ID_SAVE:
                break;
            case DIALOG_ID_OPEN:
                break;
            case DIALOG_ID_NO_FILE_MANAGER_AVAILABLE:
                DownloadOIAppDialog.onPrepareDialog(this, dialog);
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
		dataLeAk309 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-303-6", dataLeAk303);
		android.util.Log.d("leak-304-6", dataLeAk304);
		android.util.Log.d("leak-305-6", dataLeAk305);
		android.util.Log.d("leak-306-6", dataLeAk306);
		android.util.Log.d("leak-307-6", dataLeAk307);
		android.util.Log.d("leak-308-6", dataLeAk308);
		android.util.Log.d("leak-309-6", dataLeAk309);
		android.util.Log.d("leak-310-6", dataLeAk310);
        if (DEBUG) {
            Log.d(TAG, "onSaveInstanceState");
        }
        // It is important to set mIsPausing here, so that
        // the dialog does not get closed on orientation changes.
        mIsPausing = true;
        if (DEBUG) {
            Log.d(TAG, "onSaveInstanceState. Pausing: " + mIsPausing);
        }
    }

    @Override
    protected void onResume() {
        if (DEBUG) {
            Log.d(TAG, "onResume");
        }
		dataLeAk310 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-303-7", dataLeAk303);
		android.util.Log.d("leak-304-7", dataLeAk304);
		android.util.Log.d("leak-305-7", dataLeAk305);
		android.util.Log.d("leak-306-7", dataLeAk306);
		android.util.Log.d("leak-307-7", dataLeAk307);
		android.util.Log.d("leak-308-7", dataLeAk308);
		android.util.Log.d("leak-309-7", dataLeAk309);
		android.util.Log.d("leak-310-7", dataLeAk310);
        super.onResume();
        // In case another activity is called, and we are resumed,
        // mIsPausing should be reset to its original state.
        mIsPausing = false;
    }

}
