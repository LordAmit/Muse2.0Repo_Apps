package org.openintents.notepad.crypto;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.openintents.distribution.DownloadOIAppDialog;
import org.openintents.intents.CryptoIntents;
import org.openintents.notepad.NoteEditor;
import org.openintents.notepad.NotePad.Notes;
import org.openintents.notepad.PrivateNotePadIntents;
import org.openintents.notepad.R;
import org.openintents.notepad.filename.FilenameDialog;
import org.openintents.util.IntentUtils;

/**
 * Encrypt or unencrypt (i.e. remove encryption) a note.
 *
 * @author Peli
 */
public class EncryptActivity extends Activity {

    String dataLeAk15 = "15";

	String dataLeAk13 = "13";

	String dataLeAk12 = "12";

	String dataLeAk11 = "11";

	String dataLeAk10 = "10";

	private static final String TAG = "EncryptActivity";
    private static final boolean DEBUG = false;

    public static final int DIALOG_ID_GET_FROM_MARKET = 1;

    private static final int REQUEST_CODE_ENCRYPT_OR_UNENCRYPT = 1;

    /**
     * Quick hack: Order on screen orientation is: 1) on Pause 2) on resume ->
     * decrypt 3) form 1) encrypt An older note is decrypted, a newer note is
     * encrypted. In order to prevent this, delete mDecyptedRext only when this
     * activity is called.
     */
    private static int sPendingEncryptActivities = 0;

    private static boolean sCancelEncrypt = false;

    public static void confirmEncryptActivityCalled() {
        sPendingEncryptActivities++;
        if (DEBUG) {
            Log.d(
                    TAG, "sPendingEncryptActivities() -> "
                            + sPendingEncryptActivities
            );
        }
    }

    public static int getPendingEncryptActivities() {
        if (DEBUG) {
            Log.d(
                    TAG, "getPendingEncryptActivities(): "
                            + sPendingEncryptActivities
            );
        }
        return sPendingEncryptActivities;
    }

    public static void cancelEncrypt() {
        if (DEBUG) {
            Log.d(TAG, "cancelEncrypt");
        }
        sCancelEncrypt = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
		dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-10-15", dataLeAk10);
		android.util.Log.d("leak-11-15", dataLeAk11);
		android.util.Log.d("leak-12-15", dataLeAk12);
		android.util.Log.d("leak-13-15", dataLeAk13);
		android.util.Log.d("leak-15-15", dataLeAk15);

        if (DEBUG) {
            Log.d(TAG, "EncryptActivity: onCreate");
        }

        if (sPendingEncryptActivities > 0) {
            sPendingEncryptActivities--;
        }
        if (DEBUG) {
            Log.d(
                    TAG, "sPendingEncryptActivities -> "
                            + sPendingEncryptActivities
            );
        }

        if (sCancelEncrypt) {
            if (DEBUG) {
                Log.d(TAG, "encryption cancelled");
            }
            sCancelEncrypt = false;
            setResult(RESULT_CANCELED);
            finish();
            return;
        }

        if (DEBUG) {
            Log.d(TAG, "delete static decrypted text");
        }
        NoteEditor.deleteStaticDecryptedText();

        Intent i = getIntent();

        i.setComponent(null);
        String action = i.getStringExtra(PrivateNotePadIntents.EXTRA_ACTION);

        // Failed, unless set later to be successful.
        setResult(RESULT_CANCELED);

        boolean contentUnchanged = i.getBooleanExtra(
                PrivateNotePadIntents.EXTRA_CONTENT_UNCHANGED, false
        );
        if (contentUnchanged) {
            // No need to actually encrypt, because content was not modified.
            finish();
            return;
        }

        // action should be either ENCRYPT or DECRYPT
        if (!action.equals(CryptoIntents.ACTION_ENCRYPT)
                && !action.equals(CryptoIntents.ACTION_DECRYPT)) {

            // Unknown action
            Log.e(TAG, "Unknown action supplied: " + action);
            finish();
            return;
        }

        i.setAction(action);
        // Extras should have been set properly by the calling activity
        // and are not changed here.

        if (IntentUtils.isIntentAvailable(this, i)) {
            try {
                if (DEBUG) {
                    Log.d(TAG, "EncryptActivity: startActivity");
                }
                startActivityForResult(i, REQUEST_CODE_ENCRYPT_OR_UNENCRYPT);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(
                        this, R.string.encryption_failed,
                        Toast.LENGTH_SHORT
                ).show();
                Log.e(TAG, "failed to invoke encrypt");
            }
        } else {
            // Intent does not exist.
            showDialog(DIALOG_ID_GET_FROM_MARKET);
        }

        if (DEBUG) {
            Log.d(TAG, "EncryptActivity: startActivity OK");
        }
    }

    /**
     * Returns an object to be used in EXTRA_TEXT_ARRAY in a well-defined order.
     *
     * @param text
     * @param title
     * @param tags
     * @return
     */
    public static String[] getCryptoStringArray(String text, String title,
                                                String tags) {
        return new String[]{text, title, tags};
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-10-16", dataLeAk10);
		android.util.Log.d("leak-11-16", dataLeAk11);
		android.util.Log.d("leak-12-16", dataLeAk12);
		android.util.Log.d("leak-13-16", dataLeAk13);
		android.util.Log.d("leak-15-16", dataLeAk15);
		if (DEBUG) {
            Log.d(
                    TAG, "EncryptActivity: Received requestCode " + requestCode
                            + ", resultCode " + resultCode
            );
        }
        switch (requestCode) {
            case REQUEST_CODE_ENCRYPT_OR_UNENCRYPT:
                if (resultCode == RESULT_OK && data != null) {
                    // Depending on the action, textArray contains either encrypted
                    // or
                    // decrypted information.
                    String[] textArray = data
                            .getStringArrayExtra(CryptoIntents.EXTRA_TEXT_ARRAY);
                    String text = textArray[0];
                    String title = textArray[1];
                    String tags = textArray[2];
                    String action = data.getAction();

                    String uristring = data
                            .getStringExtra(PrivateNotePadIntents.EXTRA_URI);
                    Uri uri;
                    if (uristring != null) {
                        uri = Uri.parse(uristring);
                    } else {
                        Log.e(TAG, "Wrong extra uri");
                        Toast.makeText(
                                this, "Encrypted information incomplete",
                                Toast.LENGTH_SHORT
                        ).show();
                        return;
                    }

                    if (DEBUG) {
                        Log.d(
                                TAG, "Updating" + uri + ", encrypted text " + text
                                        + ", tags " + tags
                        );
                    }
                    // Write this to content provider:

                    ContentValues values = new ContentValues();
                    values.put(Notes.MODIFIED_DATE, System.currentTimeMillis());
                    // Only update values that have been specifically set
                    if (title != null) {
                        values.put(Notes.TITLE, title);
                    }
                    if (text != null) {
                        values.put(Notes.NOTE, text);
                    }
                    if (tags != null) {
                        values.put(Notes.TAGS, tags);
                    }
                    if (action.equals(CryptoIntents.ACTION_ENCRYPT)) {
                        values.put(Notes.ENCRYPTED, 1);
                    } else if (action.equals(CryptoIntents.ACTION_DECRYPT)) {
                        values.put(Notes.ENCRYPTED, 0);
                    } else {
                        Log.e(TAG, "Wrong action");
                        Toast.makeText(
                                this, "Encrypted information incomplete",
                                Toast.LENGTH_SHORT
                        ).show();
                        return;
                    }

                    getContentResolver().update(uri, values, null, null);
                    getContentResolver().notifyChange(uri, null);

                    setResult(RESULT_OK);

                    // we are done
                    finish();

                } else {
                    Toast.makeText(
                            this, R.string.encryption_failed,
                            Toast.LENGTH_SHORT
                    ).show();
                    Log.e(TAG, "failed to invoke encrypt");
                    finish();
                }
                break;
        }
    }

    @Override
    protected Dialog onCreateDialog(int id) {

        dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-10-17", dataLeAk10);
		android.util.Log.d("leak-11-17", dataLeAk11);
		android.util.Log.d("leak-12-17", dataLeAk12);
		android.util.Log.d("leak-13-17", dataLeAk13);
		android.util.Log.d("leak-15-17", dataLeAk15);
		switch (id) {
            case DIALOG_ID_GET_FROM_MARKET:
                return new DownloadOIAppDialog(this, DownloadOIAppDialog.OI_SAFE);
        }
        return null;
    }

    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {
        dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-10-18", dataLeAk10);
		android.util.Log.d("leak-11-18", dataLeAk11);
		android.util.Log.d("leak-12-18", dataLeAk12);
		android.util.Log.d("leak-13-18", dataLeAk13);
		android.util.Log.d("leak-15-18", dataLeAk15);
		FilenameDialog fd;

        dialog.setOnDismissListener(mDismissListener);

        switch (id) {
            case DIALOG_ID_GET_FROM_MARKET:
                DownloadOIAppDialog.onPrepareDialog(this, dialog);
                break;
        }
    }    OnDismissListener mDismissListener = new OnDismissListener() {

        String dataLeAk14 = "14";

		public void onDismiss(DialogInterface dialoginterface) {
            dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			finish();
        }

    };

}
