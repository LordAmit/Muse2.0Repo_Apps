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

    String dataLeAk954 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk954 = android.util.Log.d("leak-954", dataLeAk954);

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

        String dataLeAk955 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk955 = android.util.Log.d("leak-955", dataLeAk955);

		public void onFilenamePicked(String filename) {
            String dataLeAk956 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk956 = android.util.Log.d("leak-956", dataLeAk956);
			if (DEBUG) {
                String dataLeAk957 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk957 = android.util.Log.d("leak-957", dataLeAk957);
				Log.d(TAG, "Filename picked: " + filename);
            }

            Intent intent = getIntent();
            Uri uri = FileUriUtils.getUri(new File(filename));
            intent.setData(uri);

            setResult(RESULT_OK, intent);
        }

    };
    OnFilenamePickedListener mFilenamePickedForUploadListener = new OnFilenamePickedListener() {

        String dataLeAk958 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk958 = android.util.Log.d("leak-958", dataLeAk958);

		public void onFilenamePicked(String filename) {
            String dataLeAk959 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk959 = android.util.Log.d("leak-959", dataLeAk959);
			if (DEBUG) {
                String dataLeAk960 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk960 = android.util.Log.d("leak-960", dataLeAk960);
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

        String dataLeAk961 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk961 = android.util.Log.d("leak-961", dataLeAk961);

		public void onDismiss(DialogInterface dialoginterface) {
            String dataLeAk962 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk962 = android.util.Log.d("leak-962", dataLeAk962);
			if (DEBUG) {
                String dataLeAk963 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk963 = android.util.Log.d("leak-963", dataLeAk963);
				Log.d(TAG, "Dialog dismissed. Pausing: " + mIsPausing);
            }
            if (!mIsPausing) {
                String dataLeAk964 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk964 = android.util.Log.d("leak-964", dataLeAk964);
				if (DEBUG) {
                    String dataLeAk965 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk965 = android.util.Log.d("leak-965", dataLeAk965);
					Log.d(TAG, "finish");
                }
                // Dialog has been dismissed by user.
                DialogHostingActivity.this.finish();
            } else {
				String dataLeAk966 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk966 = android.util.Log.d("leak-966", dataLeAk966);
                // Probably just a screen orientation change. Don't finish yet.
                // Dialog has been dismissed by system.
            }
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk967 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk967 = android.util.Log.d("leak-967", dataLeAk967);

        Intent i = getIntent();
        if (i != null && savedInstanceState == null) {
            String dataLeAk968 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk968 = android.util.Log.d("leak-968", dataLeAk968);
			if (DEBUG) {
                String dataLeAk969 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk969 = android.util.Log.d("leak-969", dataLeAk969);
				Log.d(TAG, "new dialog");
            }
            int dialogId = i.getIntExtra(EXTRA_DIALOG_ID, 0);
            switch (dialogId) {
                case DIALOG_ID_SAVE:
                    if (DEBUG) {
                        String dataLeAk970 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk970 = android.util.Log.d("leak-970", dataLeAk970);
						Log.i(TAG, "Show Save dialog");
                    }
                    saveFile();
                    break;
                case DIALOG_ID_OPEN:
                    if (DEBUG) {
                        String dataLeAk971 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk971 = android.util.Log.d("leak-971", dataLeAk971);
						Log.i(TAG, "Show Open dialog");
                    }
                    openFile();
                    break;
                case DIALOG_ID_NO_FILE_MANAGER_AVAILABLE:
                    if (DEBUG) {
                        String dataLeAk972 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk972 = android.util.Log.d("leak-972", dataLeAk972);
						Log.i(TAG, "Show no file manager dialog");
                    }
                    showDialog(DIALOG_ID_NO_FILE_MANAGER_AVAILABLE);
                    break;
                case DIALOG_ID_UPLOAD:
                    if (DEBUG) {
                        String dataLeAk973 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk973 = android.util.Log.d("leak-973", dataLeAk973);
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

        String dataLeAk974 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk974 = android.util.Log.d("leak-974", dataLeAk974);
		Uri uri = getIntent().getData();
        if (uri != null) {
            String dataLeAk975 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk975 = android.util.Log.d("leak-975", dataLeAk975);
			// Check whether intent exists
            Intent intent = new Intent(FileManagerIntents.ACTION_PICK_FILE);
            intent.setData(uri);
            if (IntentUtils.isIntentAvailable(this, intent)) {
                String dataLeAk976 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk976 = android.util.Log.d("leak-976", dataLeAk976);
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
                String dataLeAk977 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk977 = android.util.Log.d("leak-977", dataLeAk977);
				mFilename = FileUriUtils.getFilename(getIntent().getData());
                showDialog(DIALOG_ID_SAVE);
            }
        } else {
            String dataLeAk978 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk978 = android.util.Log.d("leak-978", dataLeAk978);
			mFilename = getIntent().getStringExtra(EXTRA_FILENAME);
            showDialog(DIALOG_ID_SAVE);
        }
    }

    private void openFile() {

        String dataLeAk979 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk979 = android.util.Log.d("leak-979", dataLeAk979);
		// Check whether intent exists
        Intent intent = new Intent(FileManagerIntents.ACTION_PICK_FILE);
        intent.setData(getIntent().getData());
        if (IntentUtils.isIntentAvailable(this, intent)) {
            String dataLeAk980 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk980 = android.util.Log.d("leak-980", dataLeAk980);
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
            String dataLeAk981 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk981 = android.util.Log.d("leak-981", dataLeAk981);
			mFilename = FileUriUtils.getFilename(getIntent().getData());
            showDialog(DIALOG_ID_OPEN);
        }
    }

    private void uploadFile() {
        String dataLeAk982 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk982 = android.util.Log.d("leak-982", dataLeAk982);
		mFilename = getIntent().getStringExtra(EXTRA_FILENAME);
        showDialog(DIALOG_ID_UPLOAD);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        String dataLeAk983 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk983 = android.util.Log.d("leak-983", dataLeAk983);
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
            String dataLeAk984 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk984 = android.util.Log.d("leak-984", dataLeAk984);
			dialog = super.onCreateDialog(id);
        }
        if (dialog != null) {
            String dataLeAk985 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk985 = android.util.Log.d("leak-985", dataLeAk985);
			dialog.setOnDismissListener(mDismissListener);
        }
        return dialog;
    }

    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {
        super.onPrepareDialog(id, dialog);
		String dataLeAk986 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk986 = android.util.Log.d("leak-986", dataLeAk986);

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
		String dataLeAk987 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk987 = android.util.Log.d("leak-987", dataLeAk987);
        if (DEBUG) {
            String dataLeAk988 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk988 = android.util.Log.d("leak-988", dataLeAk988);
			Log.d(TAG, "onSaveInstanceState");
        }
        // It is important to set mIsPausing here, so that
        // the dialog does not get closed on orientation changes.
        mIsPausing = true;
        if (DEBUG) {
            String dataLeAk989 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk989 = android.util.Log.d("leak-989", dataLeAk989);
			Log.d(TAG, "onSaveInstanceState. Pausing: " + mIsPausing);
        }
    }

    @Override
    protected void onResume() {
        if (DEBUG) {
            String dataLeAk991 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk991 = android.util.Log.d("leak-991", dataLeAk991);
			Log.d(TAG, "onResume");
        }
		String dataLeAk990 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk990 = android.util.Log.d("leak-990", dataLeAk990);
        super.onResume();
        // In case another activity is called, and we are resumed,
        // mIsPausing should be reset to its original state.
        mIsPausing = false;
    }

}
