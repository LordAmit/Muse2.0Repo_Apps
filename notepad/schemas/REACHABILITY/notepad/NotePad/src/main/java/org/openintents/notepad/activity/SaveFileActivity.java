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
    String dataLeAk153 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk153 = android.util.Log.d("leak-153", dataLeAk153);

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
        String dataLeAk154 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk154 = android.util.Log.d("leak-154", dataLeAk154);
		try {
            String dataLeAk155 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk155 = android.util.Log.d("leak-155", dataLeAk155);
			FileWriter fstream = new FileWriter(file);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(text);
            out.close();
            Toast.makeText(context, R.string.note_saved, Toast.LENGTH_SHORT)
                    .show();
        } catch (IOException e) {
            String dataLeAk156 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk156 = android.util.Log.d("leak-156", dataLeAk156);
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
		String dataLeAk157 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk157 = android.util.Log.d("leak-157", dataLeAk157);

        if (savedInstanceState != null) {
            String dataLeAk158 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk158 = android.util.Log.d("leak-158", dataLeAk158);
			// retrieve data from saved instance
            if (savedInstanceState.containsKey(BUNDLE_SAVE_FILENAME)) {
                String dataLeAk159 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk159 = android.util.Log.d("leak-159", dataLeAk159);
				mSaveFilename = new File(
                        savedInstanceState.getString(BUNDLE_SAVE_FILENAME)
                );
            }
            if (savedInstanceState.containsKey(BUNDLE_SAVE_CONTENT)) {
                String dataLeAk160 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk160 = android.util.Log.d("leak-160", dataLeAk160);
				mSaveContent = savedInstanceState
                        .getString(BUNDLE_SAVE_CONTENT);
            }
        } else {
            String dataLeAk161 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk161 = android.util.Log.d("leak-161", dataLeAk161);
			// start new activity
            final Intent intent = getIntent();
            final Uri uri = intent.getData();
            Uri fileUri;
            if (uri != null) {
                String dataLeAk162 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk162 = android.util.Log.d("leak-162", dataLeAk162);
				if (uri.getScheme().equals("file")) {
                    String dataLeAk163 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk163 = android.util.Log.d("leak-163", dataLeAk163);
					// Save file provided in extras
                    fileUri = uri;
                    mSaveContent = intent
                            .getStringExtra(NotepadInternalIntents.EXTRA_TEXT);
                } else {
                    String dataLeAk164 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk164 = android.util.Log.d("leak-164", dataLeAk164);
					// Save a note specified by the note URI
                    fileUri = getFilenameFromNoteTitle(uri);
                    mSaveContent = getNote(uri);
                }
                if (mSaveContent != null && fileUri != null) {
                    String dataLeAk165 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk165 = android.util.Log.d("leak-165", dataLeAk165);
					askForFilenameSDCard(fileUri);
                } else {
                    String dataLeAk166 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk166 = android.util.Log.d("leak-166", dataLeAk166);
					// Nothing to save
                    finish();
                }
            } else {
                String dataLeAk167 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk167 = android.util.Log.d("leak-167", dataLeAk167);
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
		String dataLeAk168 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk168 = android.util.Log.d("leak-168", dataLeAk168);

        if (mSaveFilename != null) {
            String dataLeAk169 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk169 = android.util.Log.d("leak-169", dataLeAk169);
			outState.putString(
                    BUNDLE_SAVE_FILENAME,
                    mSaveFilename.getAbsolutePath()
            );
        }
        if (mSaveContent != null) {
            String dataLeAk170 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk170 = android.util.Log.d("leak-170", dataLeAk170);
			outState.putString(BUNDLE_SAVE_CONTENT, mSaveContent);
        }
    }

    private String getNote(Uri uri) {
        String dataLeAk171 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk171 = android.util.Log.d("leak-171", dataLeAk171);
		String note = null;

        Cursor c = getContentResolver().query(
                uri,
                new String[]{Notes.ENCRYPTED, Notes.NOTE}, null, null, null
        );

        if (c != null && c.moveToFirst()) {
            String dataLeAk172 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk172 = android.util.Log.d("leak-172", dataLeAk172);
			long encrypted = c.getLong(0);
            if (encrypted == 0) {
                String dataLeAk173 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk173 = android.util.Log.d("leak-173", dataLeAk173);
				note = c.getString(1);
            } else {
                String dataLeAk174 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk174 = android.util.Log.d("leak-174", dataLeAk174);
				// TODO: decrypt first, then save to file
                Log.d(TAG, "Save encrypted file not possible.");
            }
        } else {
            String dataLeAk175 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk175 = android.util.Log.d("leak-175", dataLeAk175);
			Log.e(TAG, "Error saving file: Uri not valid: " + uri);
        }

        if (c != null) {
            String dataLeAk176 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk176 = android.util.Log.d("leak-176", dataLeAk176);
			c.close();
        }

        return note;
    }

    private Uri getFilenameFromNoteTitle(Uri noteUri) {

        String dataLeAk177 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk177 = android.util.Log.d("leak-177", dataLeAk177);
		File sdcard = getSdCardPath();

        // Construct file name:
        Cursor c = getContentResolver().query(
                noteUri,
                new String[]{NotePad.Notes._ID, NotePad.Notes.TITLE}, null,
                null, null
        );
        String filename;
        if (c != null & c.moveToFirst()) {
            String dataLeAk178 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk178 = android.util.Log.d("leak-178", dataLeAk178);
			filename = c.getString(1) + ".txt";
        } else {
            String dataLeAk179 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk179 = android.util.Log.d("leak-179", dataLeAk179);
			Log.w(TAG, "Unvalid note URI");
            finish();
            return null;
        }
        if (c != null) {
            String dataLeAk180 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk180 = android.util.Log.d("leak-180", dataLeAk180);
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

        String dataLeAk181 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk181 = android.util.Log.d("leak-181", dataLeAk181);
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
        String dataLeAk182 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk182 = android.util.Log.d("leak-182", dataLeAk182);
		Log.i(
                TAG, "Received requestCode " + requestCode + ", resultCode "
                        + resultCode
        );
        switch (requestCode) {
            case REQUEST_CODE_SAVE:
                if (resultCode == RESULT_OK && intent != null) {

                    String dataLeAk183 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk183 = android.util.Log.d("leak-183", dataLeAk183);
					if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                        String dataLeAk184 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk184 = android.util.Log.d("leak-184", dataLeAk184);
						fileUriForSaving = intent.getData();
                        saveNote(fileUriForSaving);
                    } else {
                        String dataLeAk185 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk185 = android.util.Log.d("leak-185", dataLeAk185);
						if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
							String dataLeAk186 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk186 = android.util.Log.d("leak-186", dataLeAk186);

                        } else {
                            String dataLeAk187 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk187 = android.util.Log.d("leak-187", dataLeAk187);
							ActivityCompat.requestPermissions(this,
                                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                    REQUEST_CODE_PERMISSION_READ_EXTERNAL_STORAGE);
                        }
                    }

                } else {
                    String dataLeAk188 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk188 = android.util.Log.d("leak-188", dataLeAk188);
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
        String dataLeAk189 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk189 = android.util.Log.d("leak-189", dataLeAk189);
		switch (requestCode) {
            case REQUEST_CODE_PERMISSION_READ_EXTERNAL_STORAGE: {
                String dataLeAk190 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk190 = android.util.Log.d("leak-190", dataLeAk190);
				if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    String dataLeAk191 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk191 = android.util.Log.d("leak-191", dataLeAk191);
					saveNote(fileUriForSaving);
                }
                return;
            }
        }
    }

    private void saveNote(Uri uri) {
        String dataLeAk192 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk192 = android.util.Log.d("leak-192", dataLeAk192);
		// File name should be in Uri:
        mSaveFilename = FileUriUtils.getFile(uri);

        if (mSaveFilename.exists()) {
            String dataLeAk193 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk193 = android.util.Log.d("leak-193", dataLeAk193);
			showDialog(DIALOG_OVERWRITE_WARNING);
        } else {
            String dataLeAk194 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk194 = android.util.Log.d("leak-194", dataLeAk194);
			writeToFileAndFinish();
        }
    }

    private void writeToFileAndFinish() {
        String dataLeAk195 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk195 = android.util.Log.d("leak-195", dataLeAk195);
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
        String dataLeAk196 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk196 = android.util.Log.d("leak-196", dataLeAk196);
		return android.os.Environment.getExternalStorageDirectory();
    }

    @Override
    protected Dialog onCreateDialog(int id) {

        String dataLeAk197 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk197 = android.util.Log.d("leak-197", dataLeAk197);
		switch (id) {
            case DIALOG_OVERWRITE_WARNING:
                return getOverwriteWarningDialog();
        }
        return null;
    }

    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {
        String dataLeAk198 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk198 = android.util.Log.d("leak-198", dataLeAk198);
		switch (id) {
        }
    }

    Dialog getOverwriteWarningDialog() {
        String dataLeAk199 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk199 = android.util.Log.d("leak-199", dataLeAk199);
		return new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(R.string.warning_file_exists_title)
                .setMessage(R.string.warning_file_exists_message)
                .setPositiveButton(
                        android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            String dataLeAk200 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk200 = android.util.Log.d("leak-200", dataLeAk200);

							public void onClick(DialogInterface dialog,
                                                int whichButton) {
                                String dataLeAk201 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													Object throwawayLeAk201 = android.util.Log.d("leak-201", dataLeAk201);
								// click Ok
                                writeToFileAndFinish();
                            }
                        }
                )
                .setNegativeButton(
                        android.R.string.cancel,
                        new DialogInterface.OnClickListener() {
                            String dataLeAk202 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk202 = android.util.Log.d("leak-202", dataLeAk202);

							public void onClick(DialogInterface dialog,
                                                int whichButton) {
                                String dataLeAk203 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													Object throwawayLeAk203 = android.util.Log.d("leak-203", dataLeAk203);
								// click Cancel
                                finish();
                            }
                        }
                ).create();
    }
}
