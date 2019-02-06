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

    String dataLeAk239 = "239";

	String dataLeAk238 = "238";

	String dataLeAk237 = "237";

	String dataLeAk236 = "236";
	String dataLeAk231 = "231";

	String dataLeAk235 = "235";

	String dataLeAk234 = "234";

	String dataLeAk232 = "232";
	String dataLeAk229 = "229";

	String dataLeAk230 = "230";

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


		public void onFilenamePicked(String filename) {
            dataLeAk230 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk229 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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


		public void onFilenamePicked(String filename) {
            dataLeAk232 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk231 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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

        String dataLeAk233 = "233";

		public void onDismiss(DialogInterface dialoginterface) {
            dataLeAk234 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk233 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
		dataLeAk235 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-231-243", dataLeAk231);
		android.util.Log.d("leak-229-243", dataLeAk229);
		android.util.Log.d("leak-230-243", dataLeAk230);
		android.util.Log.d("leak-232-243", dataLeAk232);
		android.util.Log.d("leak-234-243", dataLeAk234);
		android.util.Log.d("leak-235-243", dataLeAk235);
		android.util.Log.d("leak-236-243", dataLeAk236);
		android.util.Log.d("leak-237-243", dataLeAk237);
		android.util.Log.d("leak-238-243", dataLeAk238);
		android.util.Log.d("leak-239-243", dataLeAk239);
		android.util.Log.d("leak-231-243", dataLeAk231);
		android.util.Log.d("leak-229-243", dataLeAk229);
		android.util.Log.d("leak-230-243", dataLeAk230);
		android.util.Log.d("leak-232-243", dataLeAk232);
		android.util.Log.d("leak-234-243", dataLeAk234);
		android.util.Log.d("leak-235-243", dataLeAk235);
		android.util.Log.d("leak-236-243", dataLeAk236);
		android.util.Log.d("leak-237-243", dataLeAk237);
		android.util.Log.d("leak-238-243", dataLeAk238);
		android.util.Log.d("leak-239-243", dataLeAk239);
		android.util.Log.d("leak-229-243", dataLeAk229);
		android.util.Log.d("leak-230-243", dataLeAk230);
		android.util.Log.d("leak-232-243", dataLeAk232);
		android.util.Log.d("leak-234-243", dataLeAk234);
		android.util.Log.d("leak-235-243", dataLeAk235);
		android.util.Log.d("leak-236-243", dataLeAk236);
		android.util.Log.d("leak-237-243", dataLeAk237);
		android.util.Log.d("leak-238-243", dataLeAk238);
		android.util.Log.d("leak-239-243", dataLeAk239);
		android.util.Log.d("leak-229-243", dataLeAk229);
		android.util.Log.d("leak-230-243", dataLeAk230);
		android.util.Log.d("leak-232-243", dataLeAk232);
		android.util.Log.d("leak-234-243", dataLeAk234);
		android.util.Log.d("leak-235-243", dataLeAk235);
		android.util.Log.d("leak-236-243", dataLeAk236);
		android.util.Log.d("leak-237-243", dataLeAk237);
		android.util.Log.d("leak-238-243", dataLeAk238);
		android.util.Log.d("leak-239-243", dataLeAk239);
		android.util.Log.d("leak-231-243", dataLeAk231);
		android.util.Log.d("leak-229-243", dataLeAk229);
		android.util.Log.d("leak-230-243", dataLeAk230);
		android.util.Log.d("leak-232-243", dataLeAk232);
		android.util.Log.d("leak-234-243", dataLeAk234);
		android.util.Log.d("leak-235-243", dataLeAk235);
		android.util.Log.d("leak-236-243", dataLeAk236);
		android.util.Log.d("leak-237-243", dataLeAk237);
		android.util.Log.d("leak-238-243", dataLeAk238);
		android.util.Log.d("leak-239-243", dataLeAk239);
		android.util.Log.d("leak-229-243", dataLeAk229);
		android.util.Log.d("leak-230-243", dataLeAk230);
		android.util.Log.d("leak-232-243", dataLeAk232);
		android.util.Log.d("leak-234-243", dataLeAk234);
		android.util.Log.d("leak-235-243", dataLeAk235);
		android.util.Log.d("leak-236-243", dataLeAk236);
		android.util.Log.d("leak-237-243", dataLeAk237);
		android.util.Log.d("leak-238-243", dataLeAk238);
		android.util.Log.d("leak-239-243", dataLeAk239);
		android.util.Log.d("leak-229-243", dataLeAk229);
		android.util.Log.d("leak-230-243", dataLeAk230);
		android.util.Log.d("leak-232-243", dataLeAk232);
		android.util.Log.d("leak-234-243", dataLeAk234);
		android.util.Log.d("leak-235-243", dataLeAk235);
		android.util.Log.d("leak-236-243", dataLeAk236);
		android.util.Log.d("leak-237-243", dataLeAk237);
		android.util.Log.d("leak-238-243", dataLeAk238);
		android.util.Log.d("leak-239-243", dataLeAk239);
		android.util.Log.d("leak-229-243", dataLeAk229);
		android.util.Log.d("leak-230-243", dataLeAk230);
		android.util.Log.d("leak-232-243", dataLeAk232);
		android.util.Log.d("leak-234-243", dataLeAk234);
		android.util.Log.d("leak-235-243", dataLeAk235);
		android.util.Log.d("leak-236-243", dataLeAk236);
		android.util.Log.d("leak-237-243", dataLeAk237);
		android.util.Log.d("leak-238-243", dataLeAk238);
		android.util.Log.d("leak-239-243", dataLeAk239);
		android.util.Log.d("leak-230-243", dataLeAk230);
		android.util.Log.d("leak-232-243", dataLeAk232);
		android.util.Log.d("leak-234-243", dataLeAk234);
		android.util.Log.d("leak-235-243", dataLeAk235);
		android.util.Log.d("leak-236-243", dataLeAk236);
		android.util.Log.d("leak-237-243", dataLeAk237);
		android.util.Log.d("leak-238-243", dataLeAk238);
		android.util.Log.d("leak-239-243", dataLeAk239);

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

        Uri uri = getIntent().getData();
		android.util.Log.d("leak-231-244", dataLeAk231);
		android.util.Log.d("leak-229-244", dataLeAk229);
		android.util.Log.d("leak-230-244", dataLeAk230);
		android.util.Log.d("leak-232-244", dataLeAk232);
		android.util.Log.d("leak-234-244", dataLeAk234);
		android.util.Log.d("leak-235-244", dataLeAk235);
		android.util.Log.d("leak-236-244", dataLeAk236);
		android.util.Log.d("leak-237-244", dataLeAk237);
		android.util.Log.d("leak-238-244", dataLeAk238);
		android.util.Log.d("leak-239-244", dataLeAk239);
		android.util.Log.d("leak-231-244", dataLeAk231);
		android.util.Log.d("leak-229-244", dataLeAk229);
		android.util.Log.d("leak-230-244", dataLeAk230);
		android.util.Log.d("leak-232-244", dataLeAk232);
		android.util.Log.d("leak-234-244", dataLeAk234);
		android.util.Log.d("leak-235-244", dataLeAk235);
		android.util.Log.d("leak-236-244", dataLeAk236);
		android.util.Log.d("leak-237-244", dataLeAk237);
		android.util.Log.d("leak-238-244", dataLeAk238);
		android.util.Log.d("leak-239-244", dataLeAk239);
		android.util.Log.d("leak-229-244", dataLeAk229);
		android.util.Log.d("leak-230-244", dataLeAk230);
		android.util.Log.d("leak-232-244", dataLeAk232);
		android.util.Log.d("leak-234-244", dataLeAk234);
		android.util.Log.d("leak-235-244", dataLeAk235);
		android.util.Log.d("leak-236-244", dataLeAk236);
		android.util.Log.d("leak-237-244", dataLeAk237);
		android.util.Log.d("leak-238-244", dataLeAk238);
		android.util.Log.d("leak-239-244", dataLeAk239);
		android.util.Log.d("leak-229-244", dataLeAk229);
		android.util.Log.d("leak-230-244", dataLeAk230);
		android.util.Log.d("leak-232-244", dataLeAk232);
		android.util.Log.d("leak-234-244", dataLeAk234);
		android.util.Log.d("leak-235-244", dataLeAk235);
		android.util.Log.d("leak-236-244", dataLeAk236);
		android.util.Log.d("leak-237-244", dataLeAk237);
		android.util.Log.d("leak-238-244", dataLeAk238);
		android.util.Log.d("leak-239-244", dataLeAk239);
		android.util.Log.d("leak-231-244", dataLeAk231);
		android.util.Log.d("leak-229-244", dataLeAk229);
		android.util.Log.d("leak-230-244", dataLeAk230);
		android.util.Log.d("leak-232-244", dataLeAk232);
		android.util.Log.d("leak-234-244", dataLeAk234);
		android.util.Log.d("leak-235-244", dataLeAk235);
		android.util.Log.d("leak-236-244", dataLeAk236);
		android.util.Log.d("leak-237-244", dataLeAk237);
		android.util.Log.d("leak-238-244", dataLeAk238);
		android.util.Log.d("leak-239-244", dataLeAk239);
		android.util.Log.d("leak-229-244", dataLeAk229);
		android.util.Log.d("leak-230-244", dataLeAk230);
		android.util.Log.d("leak-232-244", dataLeAk232);
		android.util.Log.d("leak-234-244", dataLeAk234);
		android.util.Log.d("leak-235-244", dataLeAk235);
		android.util.Log.d("leak-236-244", dataLeAk236);
		android.util.Log.d("leak-237-244", dataLeAk237);
		android.util.Log.d("leak-238-244", dataLeAk238);
		android.util.Log.d("leak-239-244", dataLeAk239);
		android.util.Log.d("leak-229-244", dataLeAk229);
		android.util.Log.d("leak-230-244", dataLeAk230);
		android.util.Log.d("leak-232-244", dataLeAk232);
		android.util.Log.d("leak-234-244", dataLeAk234);
		android.util.Log.d("leak-235-244", dataLeAk235);
		android.util.Log.d("leak-236-244", dataLeAk236);
		android.util.Log.d("leak-237-244", dataLeAk237);
		android.util.Log.d("leak-238-244", dataLeAk238);
		android.util.Log.d("leak-239-244", dataLeAk239);
		android.util.Log.d("leak-229-244", dataLeAk229);
		android.util.Log.d("leak-230-244", dataLeAk230);
		android.util.Log.d("leak-232-244", dataLeAk232);
		android.util.Log.d("leak-234-244", dataLeAk234);
		android.util.Log.d("leak-235-244", dataLeAk235);
		android.util.Log.d("leak-236-244", dataLeAk236);
		android.util.Log.d("leak-237-244", dataLeAk237);
		android.util.Log.d("leak-238-244", dataLeAk238);
		android.util.Log.d("leak-239-244", dataLeAk239);
		android.util.Log.d("leak-230-244", dataLeAk230);
		android.util.Log.d("leak-232-244", dataLeAk232);
		android.util.Log.d("leak-234-244", dataLeAk234);
		android.util.Log.d("leak-235-244", dataLeAk235);
		android.util.Log.d("leak-236-244", dataLeAk236);
		android.util.Log.d("leak-237-244", dataLeAk237);
		android.util.Log.d("leak-238-244", dataLeAk238);
		android.util.Log.d("leak-239-244", dataLeAk239);
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

        // Check whether intent exists
        Intent intent = new Intent(FileManagerIntents.ACTION_PICK_FILE);
		android.util.Log.d("leak-231-245", dataLeAk231);
		android.util.Log.d("leak-229-245", dataLeAk229);
		android.util.Log.d("leak-230-245", dataLeAk230);
		android.util.Log.d("leak-232-245", dataLeAk232);
		android.util.Log.d("leak-234-245", dataLeAk234);
		android.util.Log.d("leak-235-245", dataLeAk235);
		android.util.Log.d("leak-236-245", dataLeAk236);
		android.util.Log.d("leak-237-245", dataLeAk237);
		android.util.Log.d("leak-238-245", dataLeAk238);
		android.util.Log.d("leak-239-245", dataLeAk239);
		android.util.Log.d("leak-231-245", dataLeAk231);
		android.util.Log.d("leak-229-245", dataLeAk229);
		android.util.Log.d("leak-230-245", dataLeAk230);
		android.util.Log.d("leak-232-245", dataLeAk232);
		android.util.Log.d("leak-234-245", dataLeAk234);
		android.util.Log.d("leak-235-245", dataLeAk235);
		android.util.Log.d("leak-236-245", dataLeAk236);
		android.util.Log.d("leak-237-245", dataLeAk237);
		android.util.Log.d("leak-238-245", dataLeAk238);
		android.util.Log.d("leak-239-245", dataLeAk239);
		android.util.Log.d("leak-229-245", dataLeAk229);
		android.util.Log.d("leak-230-245", dataLeAk230);
		android.util.Log.d("leak-232-245", dataLeAk232);
		android.util.Log.d("leak-234-245", dataLeAk234);
		android.util.Log.d("leak-235-245", dataLeAk235);
		android.util.Log.d("leak-236-245", dataLeAk236);
		android.util.Log.d("leak-237-245", dataLeAk237);
		android.util.Log.d("leak-238-245", dataLeAk238);
		android.util.Log.d("leak-239-245", dataLeAk239);
		android.util.Log.d("leak-229-245", dataLeAk229);
		android.util.Log.d("leak-230-245", dataLeAk230);
		android.util.Log.d("leak-232-245", dataLeAk232);
		android.util.Log.d("leak-234-245", dataLeAk234);
		android.util.Log.d("leak-235-245", dataLeAk235);
		android.util.Log.d("leak-236-245", dataLeAk236);
		android.util.Log.d("leak-237-245", dataLeAk237);
		android.util.Log.d("leak-238-245", dataLeAk238);
		android.util.Log.d("leak-239-245", dataLeAk239);
		android.util.Log.d("leak-231-245", dataLeAk231);
		android.util.Log.d("leak-229-245", dataLeAk229);
		android.util.Log.d("leak-230-245", dataLeAk230);
		android.util.Log.d("leak-232-245", dataLeAk232);
		android.util.Log.d("leak-234-245", dataLeAk234);
		android.util.Log.d("leak-235-245", dataLeAk235);
		android.util.Log.d("leak-236-245", dataLeAk236);
		android.util.Log.d("leak-237-245", dataLeAk237);
		android.util.Log.d("leak-238-245", dataLeAk238);
		android.util.Log.d("leak-239-245", dataLeAk239);
		android.util.Log.d("leak-229-245", dataLeAk229);
		android.util.Log.d("leak-230-245", dataLeAk230);
		android.util.Log.d("leak-232-245", dataLeAk232);
		android.util.Log.d("leak-234-245", dataLeAk234);
		android.util.Log.d("leak-235-245", dataLeAk235);
		android.util.Log.d("leak-236-245", dataLeAk236);
		android.util.Log.d("leak-237-245", dataLeAk237);
		android.util.Log.d("leak-238-245", dataLeAk238);
		android.util.Log.d("leak-239-245", dataLeAk239);
		android.util.Log.d("leak-229-245", dataLeAk229);
		android.util.Log.d("leak-230-245", dataLeAk230);
		android.util.Log.d("leak-232-245", dataLeAk232);
		android.util.Log.d("leak-234-245", dataLeAk234);
		android.util.Log.d("leak-235-245", dataLeAk235);
		android.util.Log.d("leak-236-245", dataLeAk236);
		android.util.Log.d("leak-237-245", dataLeAk237);
		android.util.Log.d("leak-238-245", dataLeAk238);
		android.util.Log.d("leak-239-245", dataLeAk239);
		android.util.Log.d("leak-229-245", dataLeAk229);
		android.util.Log.d("leak-230-245", dataLeAk230);
		android.util.Log.d("leak-232-245", dataLeAk232);
		android.util.Log.d("leak-234-245", dataLeAk234);
		android.util.Log.d("leak-235-245", dataLeAk235);
		android.util.Log.d("leak-236-245", dataLeAk236);
		android.util.Log.d("leak-237-245", dataLeAk237);
		android.util.Log.d("leak-238-245", dataLeAk238);
		android.util.Log.d("leak-239-245", dataLeAk239);
		android.util.Log.d("leak-230-245", dataLeAk230);
		android.util.Log.d("leak-232-245", dataLeAk232);
		android.util.Log.d("leak-234-245", dataLeAk234);
		android.util.Log.d("leak-235-245", dataLeAk235);
		android.util.Log.d("leak-236-245", dataLeAk236);
		android.util.Log.d("leak-237-245", dataLeAk237);
		android.util.Log.d("leak-238-245", dataLeAk238);
		android.util.Log.d("leak-239-245", dataLeAk239);
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
        mFilename = getIntent().getStringExtra(EXTRA_FILENAME);
		android.util.Log.d("leak-231-246", dataLeAk231);
		android.util.Log.d("leak-229-246", dataLeAk229);
		android.util.Log.d("leak-230-246", dataLeAk230);
		android.util.Log.d("leak-232-246", dataLeAk232);
		android.util.Log.d("leak-234-246", dataLeAk234);
		android.util.Log.d("leak-235-246", dataLeAk235);
		android.util.Log.d("leak-236-246", dataLeAk236);
		android.util.Log.d("leak-237-246", dataLeAk237);
		android.util.Log.d("leak-238-246", dataLeAk238);
		android.util.Log.d("leak-239-246", dataLeAk239);
		android.util.Log.d("leak-231-246", dataLeAk231);
		android.util.Log.d("leak-229-246", dataLeAk229);
		android.util.Log.d("leak-230-246", dataLeAk230);
		android.util.Log.d("leak-232-246", dataLeAk232);
		android.util.Log.d("leak-234-246", dataLeAk234);
		android.util.Log.d("leak-235-246", dataLeAk235);
		android.util.Log.d("leak-236-246", dataLeAk236);
		android.util.Log.d("leak-237-246", dataLeAk237);
		android.util.Log.d("leak-238-246", dataLeAk238);
		android.util.Log.d("leak-239-246", dataLeAk239);
		android.util.Log.d("leak-229-246", dataLeAk229);
		android.util.Log.d("leak-230-246", dataLeAk230);
		android.util.Log.d("leak-232-246", dataLeAk232);
		android.util.Log.d("leak-234-246", dataLeAk234);
		android.util.Log.d("leak-235-246", dataLeAk235);
		android.util.Log.d("leak-236-246", dataLeAk236);
		android.util.Log.d("leak-237-246", dataLeAk237);
		android.util.Log.d("leak-238-246", dataLeAk238);
		android.util.Log.d("leak-239-246", dataLeAk239);
		android.util.Log.d("leak-229-246", dataLeAk229);
		android.util.Log.d("leak-230-246", dataLeAk230);
		android.util.Log.d("leak-232-246", dataLeAk232);
		android.util.Log.d("leak-234-246", dataLeAk234);
		android.util.Log.d("leak-235-246", dataLeAk235);
		android.util.Log.d("leak-236-246", dataLeAk236);
		android.util.Log.d("leak-237-246", dataLeAk237);
		android.util.Log.d("leak-238-246", dataLeAk238);
		android.util.Log.d("leak-239-246", dataLeAk239);
		android.util.Log.d("leak-231-246", dataLeAk231);
		android.util.Log.d("leak-229-246", dataLeAk229);
		android.util.Log.d("leak-230-246", dataLeAk230);
		android.util.Log.d("leak-232-246", dataLeAk232);
		android.util.Log.d("leak-234-246", dataLeAk234);
		android.util.Log.d("leak-235-246", dataLeAk235);
		android.util.Log.d("leak-236-246", dataLeAk236);
		android.util.Log.d("leak-237-246", dataLeAk237);
		android.util.Log.d("leak-238-246", dataLeAk238);
		android.util.Log.d("leak-239-246", dataLeAk239);
		android.util.Log.d("leak-229-246", dataLeAk229);
		android.util.Log.d("leak-230-246", dataLeAk230);
		android.util.Log.d("leak-232-246", dataLeAk232);
		android.util.Log.d("leak-234-246", dataLeAk234);
		android.util.Log.d("leak-235-246", dataLeAk235);
		android.util.Log.d("leak-236-246", dataLeAk236);
		android.util.Log.d("leak-237-246", dataLeAk237);
		android.util.Log.d("leak-238-246", dataLeAk238);
		android.util.Log.d("leak-239-246", dataLeAk239);
		android.util.Log.d("leak-229-246", dataLeAk229);
		android.util.Log.d("leak-230-246", dataLeAk230);
		android.util.Log.d("leak-232-246", dataLeAk232);
		android.util.Log.d("leak-234-246", dataLeAk234);
		android.util.Log.d("leak-235-246", dataLeAk235);
		android.util.Log.d("leak-236-246", dataLeAk236);
		android.util.Log.d("leak-237-246", dataLeAk237);
		android.util.Log.d("leak-238-246", dataLeAk238);
		android.util.Log.d("leak-239-246", dataLeAk239);
		android.util.Log.d("leak-229-246", dataLeAk229);
		android.util.Log.d("leak-230-246", dataLeAk230);
		android.util.Log.d("leak-232-246", dataLeAk232);
		android.util.Log.d("leak-234-246", dataLeAk234);
		android.util.Log.d("leak-235-246", dataLeAk235);
		android.util.Log.d("leak-236-246", dataLeAk236);
		android.util.Log.d("leak-237-246", dataLeAk237);
		android.util.Log.d("leak-238-246", dataLeAk238);
		android.util.Log.d("leak-239-246", dataLeAk239);
		android.util.Log.d("leak-230-246", dataLeAk230);
		android.util.Log.d("leak-232-246", dataLeAk232);
		android.util.Log.d("leak-234-246", dataLeAk234);
		android.util.Log.d("leak-235-246", dataLeAk235);
		android.util.Log.d("leak-236-246", dataLeAk236);
		android.util.Log.d("leak-237-246", dataLeAk237);
		android.util.Log.d("leak-238-246", dataLeAk238);
		android.util.Log.d("leak-239-246", dataLeAk239);
        showDialog(DIALOG_ID_UPLOAD);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        dataLeAk236 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-231-247", dataLeAk231);
		android.util.Log.d("leak-229-247", dataLeAk229);
		android.util.Log.d("leak-230-247", dataLeAk230);
		android.util.Log.d("leak-232-247", dataLeAk232);
		android.util.Log.d("leak-234-247", dataLeAk234);
		android.util.Log.d("leak-235-247", dataLeAk235);
		android.util.Log.d("leak-236-247", dataLeAk236);
		android.util.Log.d("leak-237-247", dataLeAk237);
		android.util.Log.d("leak-238-247", dataLeAk238);
		android.util.Log.d("leak-239-247", dataLeAk239);
		android.util.Log.d("leak-231-247", dataLeAk231);
		android.util.Log.d("leak-229-247", dataLeAk229);
		android.util.Log.d("leak-230-247", dataLeAk230);
		android.util.Log.d("leak-232-247", dataLeAk232);
		android.util.Log.d("leak-234-247", dataLeAk234);
		android.util.Log.d("leak-235-247", dataLeAk235);
		android.util.Log.d("leak-236-247", dataLeAk236);
		android.util.Log.d("leak-237-247", dataLeAk237);
		android.util.Log.d("leak-238-247", dataLeAk238);
		android.util.Log.d("leak-239-247", dataLeAk239);
		android.util.Log.d("leak-229-247", dataLeAk229);
		android.util.Log.d("leak-230-247", dataLeAk230);
		android.util.Log.d("leak-232-247", dataLeAk232);
		android.util.Log.d("leak-234-247", dataLeAk234);
		android.util.Log.d("leak-235-247", dataLeAk235);
		android.util.Log.d("leak-236-247", dataLeAk236);
		android.util.Log.d("leak-237-247", dataLeAk237);
		android.util.Log.d("leak-238-247", dataLeAk238);
		android.util.Log.d("leak-239-247", dataLeAk239);
		android.util.Log.d("leak-229-247", dataLeAk229);
		android.util.Log.d("leak-230-247", dataLeAk230);
		android.util.Log.d("leak-232-247", dataLeAk232);
		android.util.Log.d("leak-234-247", dataLeAk234);
		android.util.Log.d("leak-235-247", dataLeAk235);
		android.util.Log.d("leak-236-247", dataLeAk236);
		android.util.Log.d("leak-237-247", dataLeAk237);
		android.util.Log.d("leak-238-247", dataLeAk238);
		android.util.Log.d("leak-239-247", dataLeAk239);
		android.util.Log.d("leak-231-247", dataLeAk231);
		android.util.Log.d("leak-229-247", dataLeAk229);
		android.util.Log.d("leak-230-247", dataLeAk230);
		android.util.Log.d("leak-232-247", dataLeAk232);
		android.util.Log.d("leak-234-247", dataLeAk234);
		android.util.Log.d("leak-235-247", dataLeAk235);
		android.util.Log.d("leak-236-247", dataLeAk236);
		android.util.Log.d("leak-237-247", dataLeAk237);
		android.util.Log.d("leak-238-247", dataLeAk238);
		android.util.Log.d("leak-239-247", dataLeAk239);
		android.util.Log.d("leak-229-247", dataLeAk229);
		android.util.Log.d("leak-230-247", dataLeAk230);
		android.util.Log.d("leak-232-247", dataLeAk232);
		android.util.Log.d("leak-234-247", dataLeAk234);
		android.util.Log.d("leak-235-247", dataLeAk235);
		android.util.Log.d("leak-236-247", dataLeAk236);
		android.util.Log.d("leak-237-247", dataLeAk237);
		android.util.Log.d("leak-238-247", dataLeAk238);
		android.util.Log.d("leak-239-247", dataLeAk239);
		android.util.Log.d("leak-229-247", dataLeAk229);
		android.util.Log.d("leak-230-247", dataLeAk230);
		android.util.Log.d("leak-232-247", dataLeAk232);
		android.util.Log.d("leak-234-247", dataLeAk234);
		android.util.Log.d("leak-235-247", dataLeAk235);
		android.util.Log.d("leak-236-247", dataLeAk236);
		android.util.Log.d("leak-237-247", dataLeAk237);
		android.util.Log.d("leak-238-247", dataLeAk238);
		android.util.Log.d("leak-239-247", dataLeAk239);
		android.util.Log.d("leak-229-247", dataLeAk229);
		android.util.Log.d("leak-230-247", dataLeAk230);
		android.util.Log.d("leak-232-247", dataLeAk232);
		android.util.Log.d("leak-234-247", dataLeAk234);
		android.util.Log.d("leak-235-247", dataLeAk235);
		android.util.Log.d("leak-236-247", dataLeAk236);
		android.util.Log.d("leak-237-247", dataLeAk237);
		android.util.Log.d("leak-238-247", dataLeAk238);
		android.util.Log.d("leak-239-247", dataLeAk239);
		android.util.Log.d("leak-230-247", dataLeAk230);
		android.util.Log.d("leak-232-247", dataLeAk232);
		android.util.Log.d("leak-234-247", dataLeAk234);
		android.util.Log.d("leak-235-247", dataLeAk235);
		android.util.Log.d("leak-236-247", dataLeAk236);
		android.util.Log.d("leak-237-247", dataLeAk237);
		android.util.Log.d("leak-238-247", dataLeAk238);
		android.util.Log.d("leak-239-247", dataLeAk239);
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
		dataLeAk237 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-231-248", dataLeAk231);
		android.util.Log.d("leak-229-248", dataLeAk229);
		android.util.Log.d("leak-230-248", dataLeAk230);
		android.util.Log.d("leak-232-248", dataLeAk232);
		android.util.Log.d("leak-234-248", dataLeAk234);
		android.util.Log.d("leak-235-248", dataLeAk235);
		android.util.Log.d("leak-236-248", dataLeAk236);
		android.util.Log.d("leak-237-248", dataLeAk237);
		android.util.Log.d("leak-238-248", dataLeAk238);
		android.util.Log.d("leak-239-248", dataLeAk239);
		android.util.Log.d("leak-231-248", dataLeAk231);
		android.util.Log.d("leak-229-248", dataLeAk229);
		android.util.Log.d("leak-230-248", dataLeAk230);
		android.util.Log.d("leak-232-248", dataLeAk232);
		android.util.Log.d("leak-234-248", dataLeAk234);
		android.util.Log.d("leak-235-248", dataLeAk235);
		android.util.Log.d("leak-236-248", dataLeAk236);
		android.util.Log.d("leak-237-248", dataLeAk237);
		android.util.Log.d("leak-238-248", dataLeAk238);
		android.util.Log.d("leak-239-248", dataLeAk239);
		android.util.Log.d("leak-229-248", dataLeAk229);
		android.util.Log.d("leak-230-248", dataLeAk230);
		android.util.Log.d("leak-232-248", dataLeAk232);
		android.util.Log.d("leak-234-248", dataLeAk234);
		android.util.Log.d("leak-235-248", dataLeAk235);
		android.util.Log.d("leak-236-248", dataLeAk236);
		android.util.Log.d("leak-237-248", dataLeAk237);
		android.util.Log.d("leak-238-248", dataLeAk238);
		android.util.Log.d("leak-239-248", dataLeAk239);
		android.util.Log.d("leak-229-248", dataLeAk229);
		android.util.Log.d("leak-230-248", dataLeAk230);
		android.util.Log.d("leak-232-248", dataLeAk232);
		android.util.Log.d("leak-234-248", dataLeAk234);
		android.util.Log.d("leak-235-248", dataLeAk235);
		android.util.Log.d("leak-236-248", dataLeAk236);
		android.util.Log.d("leak-237-248", dataLeAk237);
		android.util.Log.d("leak-238-248", dataLeAk238);
		android.util.Log.d("leak-239-248", dataLeAk239);
		android.util.Log.d("leak-231-248", dataLeAk231);
		android.util.Log.d("leak-229-248", dataLeAk229);
		android.util.Log.d("leak-230-248", dataLeAk230);
		android.util.Log.d("leak-232-248", dataLeAk232);
		android.util.Log.d("leak-234-248", dataLeAk234);
		android.util.Log.d("leak-235-248", dataLeAk235);
		android.util.Log.d("leak-236-248", dataLeAk236);
		android.util.Log.d("leak-237-248", dataLeAk237);
		android.util.Log.d("leak-238-248", dataLeAk238);
		android.util.Log.d("leak-239-248", dataLeAk239);
		android.util.Log.d("leak-229-248", dataLeAk229);
		android.util.Log.d("leak-230-248", dataLeAk230);
		android.util.Log.d("leak-232-248", dataLeAk232);
		android.util.Log.d("leak-234-248", dataLeAk234);
		android.util.Log.d("leak-235-248", dataLeAk235);
		android.util.Log.d("leak-236-248", dataLeAk236);
		android.util.Log.d("leak-237-248", dataLeAk237);
		android.util.Log.d("leak-238-248", dataLeAk238);
		android.util.Log.d("leak-239-248", dataLeAk239);
		android.util.Log.d("leak-229-248", dataLeAk229);
		android.util.Log.d("leak-230-248", dataLeAk230);
		android.util.Log.d("leak-232-248", dataLeAk232);
		android.util.Log.d("leak-234-248", dataLeAk234);
		android.util.Log.d("leak-235-248", dataLeAk235);
		android.util.Log.d("leak-236-248", dataLeAk236);
		android.util.Log.d("leak-237-248", dataLeAk237);
		android.util.Log.d("leak-238-248", dataLeAk238);
		android.util.Log.d("leak-239-248", dataLeAk239);
		android.util.Log.d("leak-229-248", dataLeAk229);
		android.util.Log.d("leak-230-248", dataLeAk230);
		android.util.Log.d("leak-232-248", dataLeAk232);
		android.util.Log.d("leak-234-248", dataLeAk234);
		android.util.Log.d("leak-235-248", dataLeAk235);
		android.util.Log.d("leak-236-248", dataLeAk236);
		android.util.Log.d("leak-237-248", dataLeAk237);
		android.util.Log.d("leak-238-248", dataLeAk238);
		android.util.Log.d("leak-239-248", dataLeAk239);
		android.util.Log.d("leak-230-248", dataLeAk230);
		android.util.Log.d("leak-232-248", dataLeAk232);
		android.util.Log.d("leak-234-248", dataLeAk234);
		android.util.Log.d("leak-235-248", dataLeAk235);
		android.util.Log.d("leak-236-248", dataLeAk236);
		android.util.Log.d("leak-237-248", dataLeAk237);
		android.util.Log.d("leak-238-248", dataLeAk238);
		android.util.Log.d("leak-239-248", dataLeAk239);

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
		dataLeAk238 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-231-249", dataLeAk231);
		android.util.Log.d("leak-229-249", dataLeAk229);
		android.util.Log.d("leak-230-249", dataLeAk230);
		android.util.Log.d("leak-232-249", dataLeAk232);
		android.util.Log.d("leak-234-249", dataLeAk234);
		android.util.Log.d("leak-235-249", dataLeAk235);
		android.util.Log.d("leak-236-249", dataLeAk236);
		android.util.Log.d("leak-237-249", dataLeAk237);
		android.util.Log.d("leak-238-249", dataLeAk238);
		android.util.Log.d("leak-239-249", dataLeAk239);
		android.util.Log.d("leak-231-249", dataLeAk231);
		android.util.Log.d("leak-229-249", dataLeAk229);
		android.util.Log.d("leak-230-249", dataLeAk230);
		android.util.Log.d("leak-232-249", dataLeAk232);
		android.util.Log.d("leak-234-249", dataLeAk234);
		android.util.Log.d("leak-235-249", dataLeAk235);
		android.util.Log.d("leak-236-249", dataLeAk236);
		android.util.Log.d("leak-237-249", dataLeAk237);
		android.util.Log.d("leak-238-249", dataLeAk238);
		android.util.Log.d("leak-239-249", dataLeAk239);
		android.util.Log.d("leak-229-249", dataLeAk229);
		android.util.Log.d("leak-230-249", dataLeAk230);
		android.util.Log.d("leak-232-249", dataLeAk232);
		android.util.Log.d("leak-234-249", dataLeAk234);
		android.util.Log.d("leak-235-249", dataLeAk235);
		android.util.Log.d("leak-236-249", dataLeAk236);
		android.util.Log.d("leak-237-249", dataLeAk237);
		android.util.Log.d("leak-238-249", dataLeAk238);
		android.util.Log.d("leak-239-249", dataLeAk239);
		android.util.Log.d("leak-229-249", dataLeAk229);
		android.util.Log.d("leak-230-249", dataLeAk230);
		android.util.Log.d("leak-232-249", dataLeAk232);
		android.util.Log.d("leak-234-249", dataLeAk234);
		android.util.Log.d("leak-235-249", dataLeAk235);
		android.util.Log.d("leak-236-249", dataLeAk236);
		android.util.Log.d("leak-237-249", dataLeAk237);
		android.util.Log.d("leak-238-249", dataLeAk238);
		android.util.Log.d("leak-239-249", dataLeAk239);
		android.util.Log.d("leak-231-249", dataLeAk231);
		android.util.Log.d("leak-229-249", dataLeAk229);
		android.util.Log.d("leak-230-249", dataLeAk230);
		android.util.Log.d("leak-232-249", dataLeAk232);
		android.util.Log.d("leak-234-249", dataLeAk234);
		android.util.Log.d("leak-235-249", dataLeAk235);
		android.util.Log.d("leak-236-249", dataLeAk236);
		android.util.Log.d("leak-237-249", dataLeAk237);
		android.util.Log.d("leak-238-249", dataLeAk238);
		android.util.Log.d("leak-239-249", dataLeAk239);
		android.util.Log.d("leak-229-249", dataLeAk229);
		android.util.Log.d("leak-230-249", dataLeAk230);
		android.util.Log.d("leak-232-249", dataLeAk232);
		android.util.Log.d("leak-234-249", dataLeAk234);
		android.util.Log.d("leak-235-249", dataLeAk235);
		android.util.Log.d("leak-236-249", dataLeAk236);
		android.util.Log.d("leak-237-249", dataLeAk237);
		android.util.Log.d("leak-238-249", dataLeAk238);
		android.util.Log.d("leak-239-249", dataLeAk239);
		android.util.Log.d("leak-229-249", dataLeAk229);
		android.util.Log.d("leak-230-249", dataLeAk230);
		android.util.Log.d("leak-232-249", dataLeAk232);
		android.util.Log.d("leak-234-249", dataLeAk234);
		android.util.Log.d("leak-235-249", dataLeAk235);
		android.util.Log.d("leak-236-249", dataLeAk236);
		android.util.Log.d("leak-237-249", dataLeAk237);
		android.util.Log.d("leak-238-249", dataLeAk238);
		android.util.Log.d("leak-239-249", dataLeAk239);
		android.util.Log.d("leak-229-249", dataLeAk229);
		android.util.Log.d("leak-230-249", dataLeAk230);
		android.util.Log.d("leak-232-249", dataLeAk232);
		android.util.Log.d("leak-234-249", dataLeAk234);
		android.util.Log.d("leak-235-249", dataLeAk235);
		android.util.Log.d("leak-236-249", dataLeAk236);
		android.util.Log.d("leak-237-249", dataLeAk237);
		android.util.Log.d("leak-238-249", dataLeAk238);
		android.util.Log.d("leak-239-249", dataLeAk239);
		android.util.Log.d("leak-230-249", dataLeAk230);
		android.util.Log.d("leak-232-249", dataLeAk232);
		android.util.Log.d("leak-234-249", dataLeAk234);
		android.util.Log.d("leak-235-249", dataLeAk235);
		android.util.Log.d("leak-236-249", dataLeAk236);
		android.util.Log.d("leak-237-249", dataLeAk237);
		android.util.Log.d("leak-238-249", dataLeAk238);
		android.util.Log.d("leak-239-249", dataLeAk239);
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
		dataLeAk239 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-231-250", dataLeAk231);
		android.util.Log.d("leak-229-250", dataLeAk229);
		android.util.Log.d("leak-230-250", dataLeAk230);
		android.util.Log.d("leak-232-250", dataLeAk232);
		android.util.Log.d("leak-234-250", dataLeAk234);
		android.util.Log.d("leak-235-250", dataLeAk235);
		android.util.Log.d("leak-236-250", dataLeAk236);
		android.util.Log.d("leak-237-250", dataLeAk237);
		android.util.Log.d("leak-238-250", dataLeAk238);
		android.util.Log.d("leak-239-250", dataLeAk239);
		android.util.Log.d("leak-231-250", dataLeAk231);
		android.util.Log.d("leak-229-250", dataLeAk229);
		android.util.Log.d("leak-230-250", dataLeAk230);
		android.util.Log.d("leak-232-250", dataLeAk232);
		android.util.Log.d("leak-234-250", dataLeAk234);
		android.util.Log.d("leak-235-250", dataLeAk235);
		android.util.Log.d("leak-236-250", dataLeAk236);
		android.util.Log.d("leak-237-250", dataLeAk237);
		android.util.Log.d("leak-238-250", dataLeAk238);
		android.util.Log.d("leak-239-250", dataLeAk239);
		android.util.Log.d("leak-229-250", dataLeAk229);
		android.util.Log.d("leak-230-250", dataLeAk230);
		android.util.Log.d("leak-232-250", dataLeAk232);
		android.util.Log.d("leak-234-250", dataLeAk234);
		android.util.Log.d("leak-235-250", dataLeAk235);
		android.util.Log.d("leak-236-250", dataLeAk236);
		android.util.Log.d("leak-237-250", dataLeAk237);
		android.util.Log.d("leak-238-250", dataLeAk238);
		android.util.Log.d("leak-239-250", dataLeAk239);
		android.util.Log.d("leak-229-250", dataLeAk229);
		android.util.Log.d("leak-230-250", dataLeAk230);
		android.util.Log.d("leak-232-250", dataLeAk232);
		android.util.Log.d("leak-234-250", dataLeAk234);
		android.util.Log.d("leak-235-250", dataLeAk235);
		android.util.Log.d("leak-236-250", dataLeAk236);
		android.util.Log.d("leak-237-250", dataLeAk237);
		android.util.Log.d("leak-238-250", dataLeAk238);
		android.util.Log.d("leak-239-250", dataLeAk239);
		android.util.Log.d("leak-231-250", dataLeAk231);
		android.util.Log.d("leak-229-250", dataLeAk229);
		android.util.Log.d("leak-230-250", dataLeAk230);
		android.util.Log.d("leak-232-250", dataLeAk232);
		android.util.Log.d("leak-234-250", dataLeAk234);
		android.util.Log.d("leak-235-250", dataLeAk235);
		android.util.Log.d("leak-236-250", dataLeAk236);
		android.util.Log.d("leak-237-250", dataLeAk237);
		android.util.Log.d("leak-238-250", dataLeAk238);
		android.util.Log.d("leak-239-250", dataLeAk239);
		android.util.Log.d("leak-229-250", dataLeAk229);
		android.util.Log.d("leak-230-250", dataLeAk230);
		android.util.Log.d("leak-232-250", dataLeAk232);
		android.util.Log.d("leak-234-250", dataLeAk234);
		android.util.Log.d("leak-235-250", dataLeAk235);
		android.util.Log.d("leak-236-250", dataLeAk236);
		android.util.Log.d("leak-237-250", dataLeAk237);
		android.util.Log.d("leak-238-250", dataLeAk238);
		android.util.Log.d("leak-239-250", dataLeAk239);
		android.util.Log.d("leak-229-250", dataLeAk229);
		android.util.Log.d("leak-230-250", dataLeAk230);
		android.util.Log.d("leak-232-250", dataLeAk232);
		android.util.Log.d("leak-234-250", dataLeAk234);
		android.util.Log.d("leak-235-250", dataLeAk235);
		android.util.Log.d("leak-236-250", dataLeAk236);
		android.util.Log.d("leak-237-250", dataLeAk237);
		android.util.Log.d("leak-238-250", dataLeAk238);
		android.util.Log.d("leak-239-250", dataLeAk239);
		android.util.Log.d("leak-229-250", dataLeAk229);
		android.util.Log.d("leak-230-250", dataLeAk230);
		android.util.Log.d("leak-232-250", dataLeAk232);
		android.util.Log.d("leak-234-250", dataLeAk234);
		android.util.Log.d("leak-235-250", dataLeAk235);
		android.util.Log.d("leak-236-250", dataLeAk236);
		android.util.Log.d("leak-237-250", dataLeAk237);
		android.util.Log.d("leak-238-250", dataLeAk238);
		android.util.Log.d("leak-239-250", dataLeAk239);
		android.util.Log.d("leak-230-250", dataLeAk230);
		android.util.Log.d("leak-232-250", dataLeAk232);
		android.util.Log.d("leak-234-250", dataLeAk234);
		android.util.Log.d("leak-235-250", dataLeAk235);
		android.util.Log.d("leak-236-250", dataLeAk236);
		android.util.Log.d("leak-237-250", dataLeAk237);
		android.util.Log.d("leak-238-250", dataLeAk238);
		android.util.Log.d("leak-239-250", dataLeAk239);
        super.onResume();
        // In case another activity is called, and we are resumed,
        // mIsPausing should be reset to its original state.
        mIsPausing = false;
    }

}
