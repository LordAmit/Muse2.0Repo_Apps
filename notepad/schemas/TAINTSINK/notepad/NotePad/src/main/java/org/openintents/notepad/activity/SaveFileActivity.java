package org.openintents.notepad.activity;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import org.openintents.notepad.NotePad;
import org.openintents.notepad.NotePad.Notes;
import org.openintents.notepad.R;
import org.openintents.notepad.filename.DialogHostingActivity;
import org.openintents.notepad.intents.NotepadInternalIntents;
import org.openintents.notepad.util.FileUriUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFileActivity extends Activity {
    String dataLeAk35 = "35";

	String dataLeAk33 = "33";

	String dataLeAk31 = "31";

	String dataLeAk30 = "30";

	String dataLeAk29 = "29";

	String dataLeAk28 = "28";

	String dataLeAk27 = "27";

	String dataLeAk26 = "26";

	String dataLeAk25 = "25";

	private static final String TAG = "SaveFileActivity";

    private static final int REQUEST_CODE_SAVE = 1;
    private static final int REQUEST_CODE_PERMISSION_READ_EXTERNAL_STORAGE = 2;

    private static final int DIALOG_OVERWRITE_WARNING = 1;

    private static final String BUNDLE_SAVE_FILENAME = "save_filename";
    private static final String BUNDLE_SAVE_CONTENT = "save_content";

    File mSaveFilename;
    String mSaveContent;
    private Uri fileUriForSaving;

    public static void writeToFile(Context context, File file, String text) {
        try {
            FileWriter fstream = new FileWriter(file);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(text);
            out.close();
            Toast.makeText(context, R.string.note_saved, Toast.LENGTH_SHORT)
                    .show();
        } catch (IOException e) {
            Toast.makeText(
                    context, R.string.error_writing_file,
                    Toast.LENGTH_SHORT
            ).show();
            Log.e(TAG, "Error writing file");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
		dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-25-34", dataLeAk25);
		android.util.Log.d("leak-26-34", dataLeAk26);
		android.util.Log.d("leak-27-34", dataLeAk27);
		android.util.Log.d("leak-28-34", dataLeAk28);
		android.util.Log.d("leak-29-34", dataLeAk29);
		android.util.Log.d("leak-30-34", dataLeAk30);
		android.util.Log.d("leak-31-34", dataLeAk31);
		android.util.Log.d("leak-33-34", dataLeAk33);
		android.util.Log.d("leak-35-34", dataLeAk35);

        if (savedInstanceState != null) {
            // retrieve data from saved instance
            if (savedInstanceState.containsKey(BUNDLE_SAVE_FILENAME)) {
                mSaveFilename = new File(
                        savedInstanceState.getString(BUNDLE_SAVE_FILENAME)
                );
            }
            if (savedInstanceState.containsKey(BUNDLE_SAVE_CONTENT)) {
                mSaveContent = savedInstanceState
                        .getString(BUNDLE_SAVE_CONTENT);
            }
        } else {
            // start new activity
            final Intent intent = getIntent();
            final Uri uri = intent.getData();
            Uri fileUri;
            if (uri != null) {
                if (uri.getScheme().equals("file")) {
                    // Save file provided in extras
                    fileUri = uri;
                    mSaveContent = intent
                            .getStringExtra(NotepadInternalIntents.EXTRA_TEXT);
                } else {
                    // Save a note specified by the note URI
                    fileUri = getFilenameFromNoteTitle(uri);
                    mSaveContent = getNote(uri);
                }
                if (mSaveContent != null && fileUri != null) {
                    askForFilenameSDCard(fileUri);
                } else {
                    // Nothing to save
                    finish();
                }
            } else {
                Log.w(TAG, "Invalid URI");
                finish();
            }
        }

        // Default answer:
        setResult(RESULT_CANCELED);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
		dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-25-35", dataLeAk25);
		android.util.Log.d("leak-26-35", dataLeAk26);
		android.util.Log.d("leak-27-35", dataLeAk27);
		android.util.Log.d("leak-28-35", dataLeAk28);
		android.util.Log.d("leak-29-35", dataLeAk29);
		android.util.Log.d("leak-30-35", dataLeAk30);
		android.util.Log.d("leak-31-35", dataLeAk31);
		android.util.Log.d("leak-33-35", dataLeAk33);
		android.util.Log.d("leak-35-35", dataLeAk35);

        if (mSaveFilename != null) {
            outState.putString(
                    BUNDLE_SAVE_FILENAME,
                    mSaveFilename.getAbsolutePath()
            );
        }
        if (mSaveContent != null) {
            outState.putString(BUNDLE_SAVE_CONTENT, mSaveContent);
        }
    }

    private String getNote(Uri uri) {
        String note = null;
		android.util.Log.d("leak-25-36", dataLeAk25);
		android.util.Log.d("leak-26-36", dataLeAk26);
		android.util.Log.d("leak-27-36", dataLeAk27);
		android.util.Log.d("leak-28-36", dataLeAk28);
		android.util.Log.d("leak-29-36", dataLeAk29);
		android.util.Log.d("leak-30-36", dataLeAk30);
		android.util.Log.d("leak-31-36", dataLeAk31);
		android.util.Log.d("leak-33-36", dataLeAk33);
		android.util.Log.d("leak-35-36", dataLeAk35);

        Cursor c = getContentResolver().query(
                uri,
                new String[]{Notes.ENCRYPTED, Notes.NOTE}, null, null, null
        );

        if (c != null && c.moveToFirst()) {
            long encrypted = c.getLong(0);
            if (encrypted == 0) {
                note = c.getString(1);
            } else {
                // TODO: decrypt first, then save to file
                Log.d(TAG, "Save encrypted file not possible.");
            }
        } else {
            Log.e(TAG, "Error saving file: Uri not valid: " + uri);
        }

        if (c != null) {
            c.close();
        }

        return note;
    }

    private Uri getFilenameFromNoteTitle(Uri noteUri) {

        File sdcard = getSdCardPath();
		android.util.Log.d("leak-25-37", dataLeAk25);
		android.util.Log.d("leak-26-37", dataLeAk26);
		android.util.Log.d("leak-27-37", dataLeAk27);
		android.util.Log.d("leak-28-37", dataLeAk28);
		android.util.Log.d("leak-29-37", dataLeAk29);
		android.util.Log.d("leak-30-37", dataLeAk30);
		android.util.Log.d("leak-31-37", dataLeAk31);
		android.util.Log.d("leak-33-37", dataLeAk33);
		android.util.Log.d("leak-35-37", dataLeAk35);

        // Construct file name:
        Cursor c = getContentResolver().query(
                noteUri,
                new String[]{NotePad.Notes._ID, NotePad.Notes.TITLE}, null,
                null, null
        );
        String filename;
        if (c != null & c.moveToFirst()) {
            filename = c.getString(1) + ".txt";
        } else {
            Log.w(TAG, "Unvalid note URI");
            finish();
            return null;
        }
        if (c != null) {
            c.close();
        }

        // Avoid dangerous characters:
        filename = filename.replace("/", "");
        filename = filename.replace("\\", "");
        filename = filename.replace(":", "");
        filename = filename.replace("?", "");
        filename = filename.replace("*", "");
        return FileUriUtils.getUri(
                FileUriUtils
                        .getFile(sdcard, filename)
        );


    }

    private void askForFilenameSDCard(Uri fileUri) {

        Intent i = new Intent(this, DialogHostingActivity.class);
		android.util.Log.d("leak-25-38", dataLeAk25);
		android.util.Log.d("leak-26-38", dataLeAk26);
		android.util.Log.d("leak-27-38", dataLeAk27);
		android.util.Log.d("leak-28-38", dataLeAk28);
		android.util.Log.d("leak-29-38", dataLeAk29);
		android.util.Log.d("leak-30-38", dataLeAk30);
		android.util.Log.d("leak-31-38", dataLeAk31);
		android.util.Log.d("leak-33-38", dataLeAk33);
		android.util.Log.d("leak-35-38", dataLeAk35);
        i.putExtra(
                DialogHostingActivity.EXTRA_DIALOG_ID,
                DialogHostingActivity.DIALOG_ID_SAVE
        );
        i.setData(fileUri);
        startActivityForResult(i, REQUEST_CODE_SAVE);
    }

    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent intent) {
        dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-25-39", dataLeAk25);
		android.util.Log.d("leak-26-39", dataLeAk26);
		android.util.Log.d("leak-27-39", dataLeAk27);
		android.util.Log.d("leak-28-39", dataLeAk28);
		android.util.Log.d("leak-29-39", dataLeAk29);
		android.util.Log.d("leak-30-39", dataLeAk30);
		android.util.Log.d("leak-31-39", dataLeAk31);
		android.util.Log.d("leak-33-39", dataLeAk33);
		android.util.Log.d("leak-35-39", dataLeAk35);
		Log.i(
                TAG, "Received requestCode " + requestCode + ", resultCode "
                        + resultCode
        );
        switch (requestCode) {
            case REQUEST_CODE_SAVE:
                if (resultCode == RESULT_OK && intent != null) {

                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                        fileUriForSaving = intent.getData();
                        saveNote(fileUriForSaving);
                    } else {
                        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {

                        } else {
                            ActivityCompat.requestPermissions(this,
                                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                    REQUEST_CODE_PERMISSION_READ_EXTERNAL_STORAGE);
                        }
                    }

                } else {
                    // nothing to do.
                    finish();
                }
                break;

            default:
                // We should never reach here...
                finish();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-25-40", dataLeAk25);
		android.util.Log.d("leak-26-40", dataLeAk26);
		android.util.Log.d("leak-27-40", dataLeAk27);
		android.util.Log.d("leak-28-40", dataLeAk28);
		android.util.Log.d("leak-29-40", dataLeAk29);
		android.util.Log.d("leak-30-40", dataLeAk30);
		android.util.Log.d("leak-31-40", dataLeAk31);
		android.util.Log.d("leak-33-40", dataLeAk33);
		android.util.Log.d("leak-35-40", dataLeAk35);
		switch (requestCode) {
            case REQUEST_CODE_PERMISSION_READ_EXTERNAL_STORAGE: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    saveNote(fileUriForSaving);
                }
                return;
            }
        }
    }

    private void saveNote(Uri uri) {
        // File name should be in Uri:
        mSaveFilename = FileUriUtils.getFile(uri);
		android.util.Log.d("leak-25-41", dataLeAk25);
		android.util.Log.d("leak-26-41", dataLeAk26);
		android.util.Log.d("leak-27-41", dataLeAk27);
		android.util.Log.d("leak-28-41", dataLeAk28);
		android.util.Log.d("leak-29-41", dataLeAk29);
		android.util.Log.d("leak-30-41", dataLeAk30);
		android.util.Log.d("leak-31-41", dataLeAk31);
		android.util.Log.d("leak-33-41", dataLeAk33);
		android.util.Log.d("leak-35-41", dataLeAk35);

        if (mSaveFilename.exists()) {
            showDialog(DIALOG_OVERWRITE_WARNING);
        } else {
            writeToFileAndFinish();
        }
    }

    private void writeToFileAndFinish() {
        // save file
        writeToFile(this, mSaveFilename, mSaveContent);
		android.util.Log.d("leak-25-42", dataLeAk25);
		android.util.Log.d("leak-26-42", dataLeAk26);
		android.util.Log.d("leak-27-42", dataLeAk27);
		android.util.Log.d("leak-28-42", dataLeAk28);
		android.util.Log.d("leak-29-42", dataLeAk29);
		android.util.Log.d("leak-30-42", dataLeAk30);
		android.util.Log.d("leak-31-42", dataLeAk31);
		android.util.Log.d("leak-33-42", dataLeAk33);
		android.util.Log.d("leak-35-42", dataLeAk35);

        // Return the new file name
        Intent i = new Intent();
        Uri uri = FileUriUtils.getUri(mSaveFilename);
        i.setData(uri);
        setResult(RESULT_OK, i);
        finish();
    }

    private File getSdCardPath() {
        android.util.Log.d("leak-25-43", dataLeAk25);
		android.util.Log.d("leak-26-43", dataLeAk26);
		android.util.Log.d("leak-27-43", dataLeAk27);
		android.util.Log.d("leak-28-43", dataLeAk28);
		android.util.Log.d("leak-29-43", dataLeAk29);
		android.util.Log.d("leak-30-43", dataLeAk30);
		android.util.Log.d("leak-31-43", dataLeAk31);
		android.util.Log.d("leak-33-43", dataLeAk33);
		android.util.Log.d("leak-35-43", dataLeAk35);
		return android.os.Environment.getExternalStorageDirectory();
    }

    @Override
    protected Dialog onCreateDialog(int id) {

        dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-25-44", dataLeAk25);
		android.util.Log.d("leak-26-44", dataLeAk26);
		android.util.Log.d("leak-27-44", dataLeAk27);
		android.util.Log.d("leak-28-44", dataLeAk28);
		android.util.Log.d("leak-29-44", dataLeAk29);
		android.util.Log.d("leak-30-44", dataLeAk30);
		android.util.Log.d("leak-31-44", dataLeAk31);
		android.util.Log.d("leak-33-44", dataLeAk33);
		android.util.Log.d("leak-35-44", dataLeAk35);
		switch (id) {
            case DIALOG_OVERWRITE_WARNING:
                return getOverwriteWarningDialog();
        }
        return null;
    }

    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {
        dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-25-45", dataLeAk25);
		android.util.Log.d("leak-26-45", dataLeAk26);
		android.util.Log.d("leak-27-45", dataLeAk27);
		android.util.Log.d("leak-28-45", dataLeAk28);
		android.util.Log.d("leak-29-45", dataLeAk29);
		android.util.Log.d("leak-30-45", dataLeAk30);
		android.util.Log.d("leak-31-45", dataLeAk31);
		android.util.Log.d("leak-33-45", dataLeAk33);
		android.util.Log.d("leak-35-45", dataLeAk35);
		switch (id) {
        }
    }

    Dialog getOverwriteWarningDialog() {
        dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-25-46", dataLeAk25);
		android.util.Log.d("leak-26-46", dataLeAk26);
		android.util.Log.d("leak-27-46", dataLeAk27);
		android.util.Log.d("leak-28-46", dataLeAk28);
		android.util.Log.d("leak-29-46", dataLeAk29);
		android.util.Log.d("leak-30-46", dataLeAk30);
		android.util.Log.d("leak-31-46", dataLeAk31);
		android.util.Log.d("leak-33-46", dataLeAk33);
		android.util.Log.d("leak-35-46", dataLeAk35);
		return new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(R.string.warning_file_exists_title)
                .setMessage(R.string.warning_file_exists_message)
                .setPositiveButton(
                        android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            String dataLeAk32 = "32";

							public void onClick(DialogInterface dialog,
                                                int whichButton) {
                                dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								// click Ok
                                writeToFileAndFinish();
                            }
                        }
                )
                .setNegativeButton(
                        android.R.string.cancel,
                        new DialogInterface.OnClickListener() {
                            String dataLeAk34 = "34";

							public void onClick(DialogInterface dialog,
                                                int whichButton) {
                                dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								// click Cancel
                                finish();
                            }
                        }
                ).create();
    }
}
