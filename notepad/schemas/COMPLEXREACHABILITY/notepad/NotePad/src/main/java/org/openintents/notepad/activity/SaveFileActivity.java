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
        String dataLeAk141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP141 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP141.put("test", new java.util.HashMap<String, String>());
		leakMaP141.get("test").put("test", dataLeAk141);
		String dataLeAkPath141 = leakMaP141.get("test").get("test");
		android.util.Log.d("leak-141", dataLeAkPath141);
		try {
            String dataLeAk142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer142 = new StringBuffer();for (char chAr142 : dataLeAk142.toCharArray()) {leakBuFFer142.append(chAr142);}String dataLeAkPath142 = leakBuFFer142.toString();
			android.util.Log.d("leak-142", dataLeAkPath142);
			FileWriter fstream = new FileWriter(file);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(text);
            out.close();
            Toast.makeText(context, R.string.note_saved, Toast.LENGTH_SHORT)
                    .show();
        } catch (IOException e) {
            String dataLeAk143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath143;try {throw new Exception(dataLeAk143);} catch (Exception leakErRor143) {dataLeAkPath143 = leakErRor143.getMessage();}
			android.util.Log.d("leak-143", dataLeAkPath143);
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
		String dataLeAk144 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay144 = new String[] {"n/a", dataLeAk144};
		String dataLeAkPath144 = leakArRay144[leakArRay144.length - 1];
		android.util.Log.d("leak-144", dataLeAkPath144);

        if (savedInstanceState != null) {
            String dataLeAk145 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP145 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP145.put("test", new java.util.HashMap<String, String>());
			leakMaP145.get("test").put("test", dataLeAk145);
			String dataLeAkPath145 = leakMaP145.get("test").get("test");
			android.util.Log.d("leak-145", dataLeAkPath145);
			// retrieve data from saved instance
            if (savedInstanceState.containsKey(BUNDLE_SAVE_FILENAME)) {
                String dataLeAk146 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer146 = new StringBuffer();for (char chAr146 : dataLeAk146.toCharArray()) {leakBuFFer146.append(chAr146);}String dataLeAkPath146 = leakBuFFer146.toString();
				android.util.Log.d("leak-146", dataLeAkPath146);
				mSaveFilename = new File(
                        savedInstanceState.getString(BUNDLE_SAVE_FILENAME)
                );
            }
            if (savedInstanceState.containsKey(BUNDLE_SAVE_CONTENT)) {
                String dataLeAk147 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath147;try {throw new Exception(dataLeAk147);} catch (Exception leakErRor147) {dataLeAkPath147 = leakErRor147.getMessage();}
				android.util.Log.d("leak-147", dataLeAkPath147);
				mSaveContent = savedInstanceState
                        .getString(BUNDLE_SAVE_CONTENT);
            }
        } else {
            String dataLeAk148 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay148 = new String[] {"n/a", dataLeAk148};
			String dataLeAkPath148 = leakArRay148[leakArRay148.length - 1];
			android.util.Log.d("leak-148", dataLeAkPath148);
			// start new activity
            final Intent intent = getIntent();
            final Uri uri = intent.getData();
            Uri fileUri;
            if (uri != null) {
                String dataLeAk149 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP149 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP149.put("test", new java.util.HashMap<String, String>());
				leakMaP149.get("test").put("test", dataLeAk149);
				String dataLeAkPath149 = leakMaP149.get("test").get("test");
				android.util.Log.d("leak-149", dataLeAkPath149);
				if (uri.getScheme().equals("file")) {
                    String dataLeAk150 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer150 = new StringBuffer();for (char chAr150 : dataLeAk150.toCharArray()) {leakBuFFer150.append(chAr150);}String dataLeAkPath150 = leakBuFFer150.toString();
					android.util.Log.d("leak-150", dataLeAkPath150);
					// Save file provided in extras
                    fileUri = uri;
                    mSaveContent = intent
                            .getStringExtra(NotepadInternalIntents.EXTRA_TEXT);
                } else {
                    String dataLeAk151 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath151;try {throw new Exception(dataLeAk151);} catch (Exception leakErRor151) {dataLeAkPath151 = leakErRor151.getMessage();}
					android.util.Log.d("leak-151", dataLeAkPath151);
					// Save a note specified by the note URI
                    fileUri = getFilenameFromNoteTitle(uri);
                    mSaveContent = getNote(uri);
                }
                if (mSaveContent != null && fileUri != null) {
                    String dataLeAk152 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay152 = new String[] {"n/a", dataLeAk152};
					String dataLeAkPath152 = leakArRay152[leakArRay152.length - 1];
					android.util.Log.d("leak-152", dataLeAkPath152);
					askForFilenameSDCard(fileUri);
                } else {
                    String dataLeAk153 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP153 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP153.put("test", new java.util.HashMap<String, String>());
					leakMaP153.get("test").put("test", dataLeAk153);
					String dataLeAkPath153 = leakMaP153.get("test").get("test");
					android.util.Log.d("leak-153", dataLeAkPath153);
					// Nothing to save
                    finish();
                }
            } else {
                String dataLeAk154 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer154 = new StringBuffer();for (char chAr154 : dataLeAk154.toCharArray()) {leakBuFFer154.append(chAr154);}String dataLeAkPath154 = leakBuFFer154.toString();
				android.util.Log.d("leak-154", dataLeAkPath154);
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
		String dataLeAk155 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath155;try {throw new Exception(dataLeAk155);} catch (Exception leakErRor155) {dataLeAkPath155 = leakErRor155.getMessage();}
		android.util.Log.d("leak-155", dataLeAkPath155);

        if (mSaveFilename != null) {
            String dataLeAk156 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay156 = new String[] {"n/a", dataLeAk156};
			String dataLeAkPath156 = leakArRay156[leakArRay156.length - 1];
			android.util.Log.d("leak-156", dataLeAkPath156);
			outState.putString(
                    BUNDLE_SAVE_FILENAME,
                    mSaveFilename.getAbsolutePath()
            );
        }
        if (mSaveContent != null) {
            String dataLeAk157 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP157 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP157.put("test", new java.util.HashMap<String, String>());
			leakMaP157.get("test").put("test", dataLeAk157);
			String dataLeAkPath157 = leakMaP157.get("test").get("test");
			android.util.Log.d("leak-157", dataLeAkPath157);
			outState.putString(BUNDLE_SAVE_CONTENT, mSaveContent);
        }
    }

    private String getNote(Uri uri) {
        String dataLeAk158 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer158 = new StringBuffer();for (char chAr158 : dataLeAk158.toCharArray()) {leakBuFFer158.append(chAr158);}String dataLeAkPath158 = leakBuFFer158.toString();
		android.util.Log.d("leak-158", dataLeAkPath158);
		String note = null;

        Cursor c = getContentResolver().query(
                uri,
                new String[]{Notes.ENCRYPTED, Notes.NOTE}, null, null, null
        );

        if (c != null && c.moveToFirst()) {
            String dataLeAk159 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath159;try {throw new Exception(dataLeAk159);} catch (Exception leakErRor159) {dataLeAkPath159 = leakErRor159.getMessage();}
			android.util.Log.d("leak-159", dataLeAkPath159);
			long encrypted = c.getLong(0);
            if (encrypted == 0) {
                String dataLeAk160 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay160 = new String[] {"n/a", dataLeAk160};
				String dataLeAkPath160 = leakArRay160[leakArRay160.length - 1];
				android.util.Log.d("leak-160", dataLeAkPath160);
				note = c.getString(1);
            } else {
                String dataLeAk161 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP161 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP161.put("test", new java.util.HashMap<String, String>());
				leakMaP161.get("test").put("test", dataLeAk161);
				String dataLeAkPath161 = leakMaP161.get("test").get("test");
				android.util.Log.d("leak-161", dataLeAkPath161);
				// TODO: decrypt first, then save to file
                Log.d(TAG, "Save encrypted file not possible.");
            }
        } else {
            String dataLeAk162 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer162 = new StringBuffer();for (char chAr162 : dataLeAk162.toCharArray()) {leakBuFFer162.append(chAr162);}String dataLeAkPath162 = leakBuFFer162.toString();
			android.util.Log.d("leak-162", dataLeAkPath162);
			Log.e(TAG, "Error saving file: Uri not valid: " + uri);
        }

        if (c != null) {
            String dataLeAk163 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath163;try {throw new Exception(dataLeAk163);} catch (Exception leakErRor163) {dataLeAkPath163 = leakErRor163.getMessage();}
			android.util.Log.d("leak-163", dataLeAkPath163);
			c.close();
        }

        return note;
    }

    private Uri getFilenameFromNoteTitle(Uri noteUri) {

        String dataLeAk164 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay164 = new String[] {"n/a", dataLeAk164};
		String dataLeAkPath164 = leakArRay164[leakArRay164.length - 1];
		android.util.Log.d("leak-164", dataLeAkPath164);
		File sdcard = getSdCardPath();

        // Construct file name:
        Cursor c = getContentResolver().query(
                noteUri,
                new String[]{NotePad.Notes._ID, NotePad.Notes.TITLE}, null,
                null, null
        );
        String filename;
        if (c != null & c.moveToFirst()) {
            String dataLeAk165 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP165 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP165.put("test", new java.util.HashMap<String, String>());
			leakMaP165.get("test").put("test", dataLeAk165);
			String dataLeAkPath165 = leakMaP165.get("test").get("test");
			android.util.Log.d("leak-165", dataLeAkPath165);
			filename = c.getString(1) + ".txt";
        } else {
            String dataLeAk166 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer166 = new StringBuffer();for (char chAr166 : dataLeAk166.toCharArray()) {leakBuFFer166.append(chAr166);}String dataLeAkPath166 = leakBuFFer166.toString();
			android.util.Log.d("leak-166", dataLeAkPath166);
			Log.w(TAG, "Unvalid note URI");
            finish();
            return null;
        }
        if (c != null) {
            String dataLeAk167 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath167;try {throw new Exception(dataLeAk167);} catch (Exception leakErRor167) {dataLeAkPath167 = leakErRor167.getMessage();}
			android.util.Log.d("leak-167", dataLeAkPath167);
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

        String dataLeAk168 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay168 = new String[] {"n/a", dataLeAk168};
		String dataLeAkPath168 = leakArRay168[leakArRay168.length - 1];
		android.util.Log.d("leak-168", dataLeAkPath168);
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
        String dataLeAk169 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP169 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
										leakMaP169.put("test", new java.util.HashMap<String, String>());
										leakMaP169.get("test").put("test", dataLeAk169);
										String dataLeAkPath169 = leakMaP169.get("test").get("test");
										android.util.Log.d("leak-169", dataLeAkPath169);
		Log.i(
                TAG, "Received requestCode " + requestCode + ", resultCode "
                        + resultCode
        );
        switch (requestCode) {
            case REQUEST_CODE_SAVE:
                if (resultCode == RESULT_OK && intent != null) {

                    String dataLeAk170 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer170 = new StringBuffer();for (char chAr170 : dataLeAk170.toCharArray()) {leakBuFFer170.append(chAr170);}String dataLeAkPath170 = leakBuFFer170.toString();
					android.util.Log.d("leak-170", dataLeAkPath170);
					if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                        String dataLeAk171 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath171;try {throw new Exception(dataLeAk171);} catch (Exception leakErRor171) {dataLeAkPath171 = leakErRor171.getMessage();}
						android.util.Log.d("leak-171", dataLeAkPath171);
						fileUriForSaving = intent.getData();
                        saveNote(fileUriForSaving);
                    } else {
                        String dataLeAk172 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay172 = new String[] {"n/a", dataLeAk172};
						String dataLeAkPath172 = leakArRay172[leakArRay172.length - 1];
						android.util.Log.d("leak-172", dataLeAkPath172);
						if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
							String dataLeAk173 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP173 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP173.put("test", new java.util.HashMap<String, String>());
							leakMaP173.get("test").put("test", dataLeAk173);
							String dataLeAkPath173 = leakMaP173.get("test").get("test");
							android.util.Log.d("leak-173", dataLeAkPath173);

                        } else {
                            String dataLeAk174 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer174 = new StringBuffer();for (char chAr174 : dataLeAk174.toCharArray()) {leakBuFFer174.append(chAr174);}String dataLeAkPath174 = leakBuFFer174.toString();
							android.util.Log.d("leak-174", dataLeAkPath174);
							ActivityCompat.requestPermissions(this,
                                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                    REQUEST_CODE_PERMISSION_READ_EXTERNAL_STORAGE);
                        }
                    }

                } else {
                    String dataLeAk175 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath175;try {throw new Exception(dataLeAk175);} catch (Exception leakErRor175) {dataLeAkPath175 = leakErRor175.getMessage();}
					android.util.Log.d("leak-175", dataLeAkPath175);
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
        String dataLeAk176 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay176 = new String[] {"n/a", dataLeAk176};
		String dataLeAkPath176 = leakArRay176[leakArRay176.length - 1];
		android.util.Log.d("leak-176", dataLeAkPath176);
		switch (requestCode) {
            case REQUEST_CODE_PERMISSION_READ_EXTERNAL_STORAGE: {
                String dataLeAk177 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP177 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP177.put("test", new java.util.HashMap<String, String>());
				leakMaP177.get("test").put("test", dataLeAk177);
				String dataLeAkPath177 = leakMaP177.get("test").get("test");
				android.util.Log.d("leak-177", dataLeAkPath177);
				if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    String dataLeAk178 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer178 = new StringBuffer();for (char chAr178 : dataLeAk178.toCharArray()) {leakBuFFer178.append(chAr178);}String dataLeAkPath178 = leakBuFFer178.toString();
							android.util.Log.d("leak-178", dataLeAkPath178);
					saveNote(fileUriForSaving);
                }
                return;
            }
        }
    }

    private void saveNote(Uri uri) {
        String dataLeAk179 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath179;try {throw new Exception(dataLeAk179);} catch (Exception leakErRor179) {dataLeAkPath179 = leakErRor179.getMessage();}
		android.util.Log.d("leak-179", dataLeAkPath179);
		// File name should be in Uri:
        mSaveFilename = FileUriUtils.getFile(uri);

        if (mSaveFilename.exists()) {
            String dataLeAk180 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay180 = new String[] {"n/a", dataLeAk180};
			String dataLeAkPath180 = leakArRay180[leakArRay180.length - 1];
			android.util.Log.d("leak-180", dataLeAkPath180);
			showDialog(DIALOG_OVERWRITE_WARNING);
        } else {
            String dataLeAk181 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP181 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP181.put("test", new java.util.HashMap<String, String>());
			leakMaP181.get("test").put("test", dataLeAk181);
			String dataLeAkPath181 = leakMaP181.get("test").get("test");
			android.util.Log.d("leak-181", dataLeAkPath181);
			writeToFileAndFinish();
        }
    }

    private void writeToFileAndFinish() {
        String dataLeAk182 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer182 = new StringBuffer();for (char chAr182 : dataLeAk182.toCharArray()) {leakBuFFer182.append(chAr182);}String dataLeAkPath182 = leakBuFFer182.toString();
		android.util.Log.d("leak-182", dataLeAkPath182);
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
        String dataLeAk183 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath183;try {throw new Exception(dataLeAk183);} catch (Exception leakErRor183) {dataLeAkPath183 = leakErRor183.getMessage();}
		android.util.Log.d("leak-183", dataLeAkPath183);
		return android.os.Environment.getExternalStorageDirectory();
    }

    @Override
    protected Dialog onCreateDialog(int id) {

        String dataLeAk184 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay184 = new String[] {"n/a", dataLeAk184};
		String dataLeAkPath184 = leakArRay184[leakArRay184.length - 1];
		android.util.Log.d("leak-184", dataLeAkPath184);
		switch (id) {
            case DIALOG_OVERWRITE_WARNING:
                return getOverwriteWarningDialog();
        }
        return null;
    }

    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {
        String dataLeAk185 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP185 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP185.put("test", new java.util.HashMap<String, String>());
		leakMaP185.get("test").put("test", dataLeAk185);
		String dataLeAkPath185 = leakMaP185.get("test").get("test");
		android.util.Log.d("leak-185", dataLeAkPath185);
		switch (id) {
        }
    }

    Dialog getOverwriteWarningDialog() {
        String dataLeAk186 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer186 = new StringBuffer();for (char chAr186 : dataLeAk186.toCharArray()) {leakBuFFer186.append(chAr186);}String dataLeAkPath186 = leakBuFFer186.toString();
		android.util.Log.d("leak-186", dataLeAkPath186);
		return new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(R.string.warning_file_exists_title)
                .setMessage(R.string.warning_file_exists_message)
                .setPositiveButton(
                        android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int whichButton) {
                                String dataLeAk187 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													String dataLeAkPath187;try {throw new Exception(dataLeAk187);} catch (Exception leakErRor187) {dataLeAkPath187 = leakErRor187.getMessage();}
													android.util.Log.d("leak-187", dataLeAkPath187);
								// click Ok
                                writeToFileAndFinish();
                            }
                        }
                )
                .setNegativeButton(
                        android.R.string.cancel,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int whichButton) {
                                String dataLeAk188 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													String[] leakArRay188 = new String[] {"n/a", dataLeAk188};
													String dataLeAkPath188 = leakArRay188[leakArRay188.length - 1];
													android.util.Log.d("leak-188", dataLeAkPath188);
								// click Cancel
                                finish();
                            }
                        }
                ).create();
    }
}
