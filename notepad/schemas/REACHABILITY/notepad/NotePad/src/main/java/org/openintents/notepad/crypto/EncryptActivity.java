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

    String dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk63 = android.util.Log.d("leak-63", dataLeAk63);

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
        String dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk64 = android.util.Log.d("leak-64", dataLeAk64);
		sPendingEncryptActivities++;
        if (DEBUG) {
            String dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk65 = android.util.Log.d("leak-65", dataLeAk65);
			Log.d(
                    TAG, "sPendingEncryptActivities() -> "
                            + sPendingEncryptActivities
            );
        }
    }

    public static int getPendingEncryptActivities() {
        String dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk66 = android.util.Log.d("leak-66", dataLeAk66);
		if (DEBUG) {
            String dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk67 = android.util.Log.d("leak-67", dataLeAk67);
			Log.d(
                    TAG, "getPendingEncryptActivities(): "
                            + sPendingEncryptActivities
            );
        }
        return sPendingEncryptActivities;
    }

    public static void cancelEncrypt() {
        String dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk68 = android.util.Log.d("leak-68", dataLeAk68);
		if (DEBUG) {
            String dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk69 = android.util.Log.d("leak-69", dataLeAk69);
			Log.d(TAG, "cancelEncrypt");
        }
        sCancelEncrypt = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
		String dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk70 = android.util.Log.d("leak-70", dataLeAk70);

        if (DEBUG) {
            String dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk71 = android.util.Log.d("leak-71", dataLeAk71);
			Log.d(TAG, "EncryptActivity: onCreate");
        }

        if (sPendingEncryptActivities > 0) {
            String dataLeAk72 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk72 = android.util.Log.d("leak-72", dataLeAk72);
			sPendingEncryptActivities--;
        }
        if (DEBUG) {
            String dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk73 = android.util.Log.d("leak-73", dataLeAk73);
			Log.d(
                    TAG, "sPendingEncryptActivities -> "
                            + sPendingEncryptActivities
            );
        }

        if (sCancelEncrypt) {
            String dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk74 = android.util.Log.d("leak-74", dataLeAk74);
			if (DEBUG) {
                String dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk75 = android.util.Log.d("leak-75", dataLeAk75);
				Log.d(TAG, "encryption cancelled");
            }
            sCancelEncrypt = false;
            setResult(RESULT_CANCELED);
            finish();
            return;
        }

        if (DEBUG) {
            String dataLeAk76 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk76 = android.util.Log.d("leak-76", dataLeAk76);
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
            String dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk77 = android.util.Log.d("leak-77", dataLeAk77);
			// No need to actually encrypt, because content was not modified.
            finish();
            return;
        }

        // action should be either ENCRYPT or DECRYPT
        if (!action.equals(CryptoIntents.ACTION_ENCRYPT)
                && !action.equals(CryptoIntents.ACTION_DECRYPT)) {

            String dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk78 = android.util.Log.d("leak-78", dataLeAk78);
			// Unknown action
            Log.e(TAG, "Unknown action supplied: " + action);
            finish();
            return;
        }

        i.setAction(action);
        // Extras should have been set properly by the calling activity
        // and are not changed here.

        if (IntentUtils.isIntentAvailable(this, i)) {
            String dataLeAk79 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk79 = android.util.Log.d("leak-79", dataLeAk79);
			try {
                String dataLeAk80 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk80 = android.util.Log.d("leak-80", dataLeAk80);
				if (DEBUG) {
                    String dataLeAk81 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk81 = android.util.Log.d("leak-81", dataLeAk81);
					Log.d(TAG, "EncryptActivity: startActivity");
                }
                startActivityForResult(i, REQUEST_CODE_ENCRYPT_OR_UNENCRYPT);
            } catch (ActivityNotFoundException e) {
                String dataLeAk82 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk82 = android.util.Log.d("leak-82", dataLeAk82);
				Toast.makeText(
                        this, R.string.encryption_failed,
                        Toast.LENGTH_SHORT
                ).show();
                Log.e(TAG, "failed to invoke encrypt");
            }
        } else {
            String dataLeAk83 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk83 = android.util.Log.d("leak-83", dataLeAk83);
			// Intent does not exist.
            showDialog(DIALOG_ID_GET_FROM_MARKET);
        }

        if (DEBUG) {
            String dataLeAk84 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk84 = android.util.Log.d("leak-84", dataLeAk84);
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
        String dataLeAk85 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													Object throwawayLeAk85 = android.util.Log.d("leak-85", dataLeAk85);
		return new String[]{text, title, tags};
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String dataLeAk86 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk86 = android.util.Log.d("leak-86", dataLeAk86);
		if (DEBUG) {
            String dataLeAk87 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk87 = android.util.Log.d("leak-87", dataLeAk87);
			Log.d(
                    TAG, "EncryptActivity: Received requestCode " + requestCode
                            + ", resultCode " + resultCode
            );
        }
        switch (requestCode) {
            case REQUEST_CODE_ENCRYPT_OR_UNENCRYPT:
                if (resultCode == RESULT_OK && data != null) {
                    String dataLeAk88 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk88 = android.util.Log.d("leak-88", dataLeAk88);
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
                        String dataLeAk89 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk89 = android.util.Log.d("leak-89", dataLeAk89);
						uri = Uri.parse(uristring);
                    } else {
                        String dataLeAk90 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk90 = android.util.Log.d("leak-90", dataLeAk90);
						Log.e(TAG, "Wrong extra uri");
                        Toast.makeText(
                                this, "Encrypted information incomplete",
                                Toast.LENGTH_SHORT
                        ).show();
                        return;
                    }

                    if (DEBUG) {
                        String dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk91 = android.util.Log.d("leak-91", dataLeAk91);
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
                        String dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk92 = android.util.Log.d("leak-92", dataLeAk92);
						values.put(Notes.TITLE, title);
                    }
                    if (text != null) {
                        String dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk93 = android.util.Log.d("leak-93", dataLeAk93);
						values.put(Notes.NOTE, text);
                    }
                    if (tags != null) {
                        String dataLeAk94 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk94 = android.util.Log.d("leak-94", dataLeAk94);
						values.put(Notes.TAGS, tags);
                    }
                    if (action.equals(CryptoIntents.ACTION_ENCRYPT)) {
                        String dataLeAk95 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk95 = android.util.Log.d("leak-95", dataLeAk95);
						values.put(Notes.ENCRYPTED, 1);
                    } else if (action.equals(CryptoIntents.ACTION_DECRYPT)) {
                        String dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk96 = android.util.Log.d("leak-96", dataLeAk96);
						values.put(Notes.ENCRYPTED, 0);
                    } else {
                        String dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk97 = android.util.Log.d("leak-97", dataLeAk97);
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
                    String dataLeAk98 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk98 = android.util.Log.d("leak-98", dataLeAk98);
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

        String dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk99 = android.util.Log.d("leak-99", dataLeAk99);
		switch (id) {
            case DIALOG_ID_GET_FROM_MARKET:
                return new DownloadOIAppDialog(this, DownloadOIAppDialog.OI_SAFE);
        }
        return null;
    }

    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {
        String dataLeAk100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk100 = android.util.Log.d("leak-100", dataLeAk100);
		FilenameDialog fd;

        dialog.setOnDismissListener(mDismissListener);

        switch (id) {
            case DIALOG_ID_GET_FROM_MARKET:
                DownloadOIAppDialog.onPrepareDialog(this, dialog);
                break;
        }
    }    OnDismissListener mDismissListener = new OnDismissListener() {

        String dataLeAk101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk101 = android.util.Log.d("leak-101", dataLeAk101);

		public void onDismiss(DialogInterface dialoginterface) {
            String dataLeAk102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk102 = android.util.Log.d("leak-102", dataLeAk102);
			finish();
        }

    };

}
