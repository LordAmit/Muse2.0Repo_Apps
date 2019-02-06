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
    final String dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk48 = "";

	String dataLeAk47 = "";

	String dataLeAk46 = "";

	String dataLeAk45 = "";

	String dataLeAk44 = "";

	String dataLeAk43 = "";

	String dataLeAk42 = "";

	String dataLeAk41 = "";

	String dataLeAk40 = "";

	String dataLeAk39 = "";

	String dataLeAk38 = "";

	String dataLeAk37 = "";

	String dataLeAk36 = "";

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
		dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-36-0", dataLeAk36);
		android.util.Log.d("leak-37-0", dataLeAk37);
		android.util.Log.d("leak-38-0", dataLeAk38);
		android.util.Log.d("leak-39-0", dataLeAk39);
		android.util.Log.d("leak-40-0", dataLeAk40);
		android.util.Log.d("leak-41-0", dataLeAk41);
		android.util.Log.d("leak-42-0", dataLeAk42);
		android.util.Log.d("leak-43-0", dataLeAk43);
		android.util.Log.d("leak-44-0", dataLeAk44);
		android.util.Log.d("leak-45-0", dataLeAk45);
		android.util.Log.d("leak-46-0", dataLeAk46);
		android.util.Log.d("leak-47-0", dataLeAk47);
		android.util.Log.d("leak-48-0", dataLeAk48);

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
		dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-36-1", dataLeAk36);
		android.util.Log.d("leak-37-1", dataLeAk37);
		android.util.Log.d("leak-38-1", dataLeAk38);
		android.util.Log.d("leak-39-1", dataLeAk39);
		android.util.Log.d("leak-40-1", dataLeAk40);
		android.util.Log.d("leak-41-1", dataLeAk41);
		android.util.Log.d("leak-42-1", dataLeAk42);
		android.util.Log.d("leak-43-1", dataLeAk43);
		android.util.Log.d("leak-44-1", dataLeAk44);
		android.util.Log.d("leak-45-1", dataLeAk45);
		android.util.Log.d("leak-46-1", dataLeAk46);
		android.util.Log.d("leak-47-1", dataLeAk47);
		android.util.Log.d("leak-48-1", dataLeAk48);

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
        dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-36-2", dataLeAk36);
		android.util.Log.d("leak-37-2", dataLeAk37);
		android.util.Log.d("leak-38-2", dataLeAk38);
		android.util.Log.d("leak-39-2", dataLeAk39);
		android.util.Log.d("leak-40-2", dataLeAk40);
		android.util.Log.d("leak-41-2", dataLeAk41);
		android.util.Log.d("leak-42-2", dataLeAk42);
		android.util.Log.d("leak-43-2", dataLeAk43);
		android.util.Log.d("leak-44-2", dataLeAk44);
		android.util.Log.d("leak-45-2", dataLeAk45);
		android.util.Log.d("leak-46-2", dataLeAk46);
		android.util.Log.d("leak-47-2", dataLeAk47);
		android.util.Log.d("leak-48-2", dataLeAk48);
		String note = null;

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

        dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-36-3", dataLeAk36);
		android.util.Log.d("leak-37-3", dataLeAk37);
		android.util.Log.d("leak-38-3", dataLeAk38);
		android.util.Log.d("leak-39-3", dataLeAk39);
		android.util.Log.d("leak-40-3", dataLeAk40);
		android.util.Log.d("leak-41-3", dataLeAk41);
		android.util.Log.d("leak-42-3", dataLeAk42);
		android.util.Log.d("leak-43-3", dataLeAk43);
		android.util.Log.d("leak-44-3", dataLeAk44);
		android.util.Log.d("leak-45-3", dataLeAk45);
		android.util.Log.d("leak-46-3", dataLeAk46);
		android.util.Log.d("leak-47-3", dataLeAk47);
		android.util.Log.d("leak-48-3", dataLeAk48);
		File sdcard = getSdCardPath();

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

        dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-36-4", dataLeAk36);
		android.util.Log.d("leak-37-4", dataLeAk37);
		android.util.Log.d("leak-38-4", dataLeAk38);
		android.util.Log.d("leak-39-4", dataLeAk39);
		android.util.Log.d("leak-40-4", dataLeAk40);
		android.util.Log.d("leak-41-4", dataLeAk41);
		android.util.Log.d("leak-42-4", dataLeAk42);
		android.util.Log.d("leak-43-4", dataLeAk43);
		android.util.Log.d("leak-44-4", dataLeAk44);
		android.util.Log.d("leak-45-4", dataLeAk45);
		android.util.Log.d("leak-46-4", dataLeAk46);
		android.util.Log.d("leak-47-4", dataLeAk47);
		android.util.Log.d("leak-48-4", dataLeAk48);
		Intent i = new Intent(this, DialogHostingActivity.class);
        i.putExtra(
                DialogHostingActivity.EXTRA_DIALOG_ID,
                DialogHostingActivity.DIALOG_ID_SAVE
        );
        i.setData(fileUri);
        startActivityForResult(i, REQUEST_CODE_SAVE);
    }

    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent intent) {
        dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-36-5", dataLeAk36);
		android.util.Log.d("leak-37-5", dataLeAk37);
		android.util.Log.d("leak-38-5", dataLeAk38);
		android.util.Log.d("leak-39-5", dataLeAk39);
		android.util.Log.d("leak-40-5", dataLeAk40);
		android.util.Log.d("leak-41-5", dataLeAk41);
		android.util.Log.d("leak-42-5", dataLeAk42);
		android.util.Log.d("leak-43-5", dataLeAk43);
		android.util.Log.d("leak-44-5", dataLeAk44);
		android.util.Log.d("leak-45-5", dataLeAk45);
		android.util.Log.d("leak-46-5", dataLeAk46);
		android.util.Log.d("leak-47-5", dataLeAk47);
		android.util.Log.d("leak-48-5", dataLeAk48);
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
        dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-36-6", dataLeAk36);
		android.util.Log.d("leak-37-6", dataLeAk37);
		android.util.Log.d("leak-38-6", dataLeAk38);
		android.util.Log.d("leak-39-6", dataLeAk39);
		android.util.Log.d("leak-40-6", dataLeAk40);
		android.util.Log.d("leak-41-6", dataLeAk41);
		android.util.Log.d("leak-42-6", dataLeAk42);
		android.util.Log.d("leak-43-6", dataLeAk43);
		android.util.Log.d("leak-44-6", dataLeAk44);
		android.util.Log.d("leak-45-6", dataLeAk45);
		android.util.Log.d("leak-46-6", dataLeAk46);
		android.util.Log.d("leak-47-6", dataLeAk47);
		android.util.Log.d("leak-48-6", dataLeAk48);
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
        dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-36-7", dataLeAk36);
		android.util.Log.d("leak-37-7", dataLeAk37);
		android.util.Log.d("leak-38-7", dataLeAk38);
		android.util.Log.d("leak-39-7", dataLeAk39);
		android.util.Log.d("leak-40-7", dataLeAk40);
		android.util.Log.d("leak-41-7", dataLeAk41);
		android.util.Log.d("leak-42-7", dataLeAk42);
		android.util.Log.d("leak-43-7", dataLeAk43);
		android.util.Log.d("leak-44-7", dataLeAk44);
		android.util.Log.d("leak-45-7", dataLeAk45);
		android.util.Log.d("leak-46-7", dataLeAk46);
		android.util.Log.d("leak-47-7", dataLeAk47);
		android.util.Log.d("leak-48-7", dataLeAk48);
		// File name should be in Uri:
        mSaveFilename = FileUriUtils.getFile(uri);

        if (mSaveFilename.exists()) {
            showDialog(DIALOG_OVERWRITE_WARNING);
        } else {
            writeToFileAndFinish();
        }
    }

    private void writeToFileAndFinish() {
        dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-36-8", dataLeAk36);
		android.util.Log.d("leak-37-8", dataLeAk37);
		android.util.Log.d("leak-38-8", dataLeAk38);
		android.util.Log.d("leak-39-8", dataLeAk39);
		android.util.Log.d("leak-40-8", dataLeAk40);
		android.util.Log.d("leak-41-8", dataLeAk41);
		android.util.Log.d("leak-42-8", dataLeAk42);
		android.util.Log.d("leak-43-8", dataLeAk43);
		android.util.Log.d("leak-44-8", dataLeAk44);
		android.util.Log.d("leak-45-8", dataLeAk45);
		android.util.Log.d("leak-46-8", dataLeAk46);
		android.util.Log.d("leak-47-8", dataLeAk47);
		android.util.Log.d("leak-48-8", dataLeAk48);
		// save file
        writeToFile(this, mSaveFilename, mSaveContent);

        // Return the new file name
        Intent i = new Intent();
        Uri uri = FileUriUtils.getUri(mSaveFilename);
        i.setData(uri);
        setResult(RESULT_OK, i);
        finish();
    }

    private File getSdCardPath() {
        dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-36-9", dataLeAk36);
		android.util.Log.d("leak-37-9", dataLeAk37);
		android.util.Log.d("leak-38-9", dataLeAk38);
		android.util.Log.d("leak-39-9", dataLeAk39);
		android.util.Log.d("leak-40-9", dataLeAk40);
		android.util.Log.d("leak-41-9", dataLeAk41);
		android.util.Log.d("leak-42-9", dataLeAk42);
		android.util.Log.d("leak-43-9", dataLeAk43);
		android.util.Log.d("leak-44-9", dataLeAk44);
		android.util.Log.d("leak-45-9", dataLeAk45);
		android.util.Log.d("leak-46-9", dataLeAk46);
		android.util.Log.d("leak-47-9", dataLeAk47);
		android.util.Log.d("leak-48-9", dataLeAk48);
		return android.os.Environment.getExternalStorageDirectory();
    }

    @Override
    protected Dialog onCreateDialog(int id) {

        dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-36-10", dataLeAk36);
		android.util.Log.d("leak-37-10", dataLeAk37);
		android.util.Log.d("leak-38-10", dataLeAk38);
		android.util.Log.d("leak-39-10", dataLeAk39);
		android.util.Log.d("leak-40-10", dataLeAk40);
		android.util.Log.d("leak-41-10", dataLeAk41);
		android.util.Log.d("leak-42-10", dataLeAk42);
		android.util.Log.d("leak-43-10", dataLeAk43);
		android.util.Log.d("leak-44-10", dataLeAk44);
		android.util.Log.d("leak-45-10", dataLeAk45);
		android.util.Log.d("leak-46-10", dataLeAk46);
		android.util.Log.d("leak-47-10", dataLeAk47);
		android.util.Log.d("leak-48-10", dataLeAk48);
		switch (id) {
            case DIALOG_OVERWRITE_WARNING:
                return getOverwriteWarningDialog();
        }
        return null;
    }

    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {
        dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-36-11", dataLeAk36);
		android.util.Log.d("leak-37-11", dataLeAk37);
		android.util.Log.d("leak-38-11", dataLeAk38);
		android.util.Log.d("leak-39-11", dataLeAk39);
		android.util.Log.d("leak-40-11", dataLeAk40);
		android.util.Log.d("leak-41-11", dataLeAk41);
		android.util.Log.d("leak-42-11", dataLeAk42);
		android.util.Log.d("leak-43-11", dataLeAk43);
		android.util.Log.d("leak-44-11", dataLeAk44);
		android.util.Log.d("leak-45-11", dataLeAk45);
		android.util.Log.d("leak-46-11", dataLeAk46);
		android.util.Log.d("leak-47-11", dataLeAk47);
		android.util.Log.d("leak-48-11", dataLeAk48);
		switch (id) {
        }
    }

    Dialog getOverwriteWarningDialog() {
        dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-36-12", dataLeAk36);
		android.util.Log.d("leak-37-12", dataLeAk37);
		android.util.Log.d("leak-38-12", dataLeAk38);
		android.util.Log.d("leak-39-12", dataLeAk39);
		android.util.Log.d("leak-40-12", dataLeAk40);
		android.util.Log.d("leak-41-12", dataLeAk41);
		android.util.Log.d("leak-42-12", dataLeAk42);
		android.util.Log.d("leak-43-12", dataLeAk43);
		android.util.Log.d("leak-44-12", dataLeAk44);
		android.util.Log.d("leak-45-12", dataLeAk45);
		android.util.Log.d("leak-46-12", dataLeAk46);
		android.util.Log.d("leak-47-12", dataLeAk47);
		android.util.Log.d("leak-48-12", dataLeAk48);
		return new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(R.string.warning_file_exists_title)
                .setMessage(R.string.warning_file_exists_message)
                .setPositiveButton(
                        android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            String dataLeAk49 = "";

							public void onClick(DialogInterface dialog,
                                                int whichButton) {
                                dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-52-0", dataLeAk52);
								android.util.Log.d("leak-49-0", dataLeAk49);
								// click Ok
                                writeToFileAndFinish();
                            }
                        }
                )
                .setNegativeButton(
                        android.R.string.cancel,
                        new DialogInterface.OnClickListener() {
                            String dataLeAk50 = "";

							public void onClick(DialogInterface dialog,
                                                int whichButton) {
                                dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-53-0", dataLeAk53);
								android.util.Log.d("leak-50-0", dataLeAk50);
								// click Cancel
                                finish();
                            }
                        }
                ).create();
    }
}
