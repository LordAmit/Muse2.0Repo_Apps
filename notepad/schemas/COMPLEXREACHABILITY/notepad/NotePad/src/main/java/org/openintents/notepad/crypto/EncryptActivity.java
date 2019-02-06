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
        String dataLeAk56 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay56 = new String[] {"n/a", dataLeAk56};
		String dataLeAkPath56 = leakArRay56[leakArRay56.length - 1];
		android.util.Log.d("leak-56", dataLeAkPath56);
		sPendingEncryptActivities++;
        if (DEBUG) {
            String dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP57 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP57.put("test", new java.util.HashMap<String, String>());
			leakMaP57.get("test").put("test", dataLeAk57);
			String dataLeAkPath57 = leakMaP57.get("test").get("test");
			android.util.Log.d("leak-57", dataLeAkPath57);
			Log.d(
                    TAG, "sPendingEncryptActivities() -> "
                            + sPendingEncryptActivities
            );
        }
    }

    public static int getPendingEncryptActivities() {
        String dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer58 = new StringBuffer();for (char chAr58 : dataLeAk58.toCharArray()) {leakBuFFer58.append(chAr58);}String dataLeAkPath58 = leakBuFFer58.toString();
		android.util.Log.d("leak-58", dataLeAkPath58);
		if (DEBUG) {
            String dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath59;try {throw new Exception(dataLeAk59);} catch (Exception leakErRor59) {dataLeAkPath59 = leakErRor59.getMessage();}
			android.util.Log.d("leak-59", dataLeAkPath59);
			Log.d(
                    TAG, "getPendingEncryptActivities(): "
                            + sPendingEncryptActivities
            );
        }
        return sPendingEncryptActivities;
    }

    public static void cancelEncrypt() {
        String dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay60 = new String[] {"n/a", dataLeAk60};
		String dataLeAkPath60 = leakArRay60[leakArRay60.length - 1];
		android.util.Log.d("leak-60", dataLeAkPath60);
		if (DEBUG) {
            String dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP61 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP61.put("test", new java.util.HashMap<String, String>());
			leakMaP61.get("test").put("test", dataLeAk61);
			String dataLeAkPath61 = leakMaP61.get("test").get("test");
			android.util.Log.d("leak-61", dataLeAkPath61);
			Log.d(TAG, "cancelEncrypt");
        }
        sCancelEncrypt = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
		String dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer62 = new StringBuffer();for (char chAr62 : dataLeAk62.toCharArray()) {leakBuFFer62.append(chAr62);}String dataLeAkPath62 = leakBuFFer62.toString();
		android.util.Log.d("leak-62", dataLeAkPath62);

        if (DEBUG) {
            String dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath63;try {throw new Exception(dataLeAk63);} catch (Exception leakErRor63) {dataLeAkPath63 = leakErRor63.getMessage();}
			android.util.Log.d("leak-63", dataLeAkPath63);
			Log.d(TAG, "EncryptActivity: onCreate");
        }

        if (sPendingEncryptActivities > 0) {
            String dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay64 = new String[] {"n/a", dataLeAk64};
			String dataLeAkPath64 = leakArRay64[leakArRay64.length - 1];
			android.util.Log.d("leak-64", dataLeAkPath64);
			sPendingEncryptActivities--;
        }
        if (DEBUG) {
            String dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP65 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP65.put("test", new java.util.HashMap<String, String>());
			leakMaP65.get("test").put("test", dataLeAk65);
			String dataLeAkPath65 = leakMaP65.get("test").get("test");
			android.util.Log.d("leak-65", dataLeAkPath65);
			Log.d(
                    TAG, "sPendingEncryptActivities -> "
                            + sPendingEncryptActivities
            );
        }

        if (sCancelEncrypt) {
            String dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer66 = new StringBuffer();for (char chAr66 : dataLeAk66.toCharArray()) {leakBuFFer66.append(chAr66);}String dataLeAkPath66 = leakBuFFer66.toString();
			android.util.Log.d("leak-66", dataLeAkPath66);
			if (DEBUG) {
                String dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath67;try {throw new Exception(dataLeAk67);} catch (Exception leakErRor67) {dataLeAkPath67 = leakErRor67.getMessage();}
				android.util.Log.d("leak-67", dataLeAkPath67);
				Log.d(TAG, "encryption cancelled");
            }
            sCancelEncrypt = false;
            setResult(RESULT_CANCELED);
            finish();
            return;
        }

        if (DEBUG) {
            String dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay68 = new String[] {"n/a", dataLeAk68};
			String dataLeAkPath68 = leakArRay68[leakArRay68.length - 1];
			android.util.Log.d("leak-68", dataLeAkPath68);
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
            String dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP69 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP69.put("test", new java.util.HashMap<String, String>());
			leakMaP69.get("test").put("test", dataLeAk69);
			String dataLeAkPath69 = leakMaP69.get("test").get("test");
			android.util.Log.d("leak-69", dataLeAkPath69);
			// No need to actually encrypt, because content was not modified.
            finish();
            return;
        }

        // action should be either ENCRYPT or DECRYPT
        if (!action.equals(CryptoIntents.ACTION_ENCRYPT)
                && !action.equals(CryptoIntents.ACTION_DECRYPT)) {

            String dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer70 = new StringBuffer();for (char chAr70 : dataLeAk70.toCharArray()) {leakBuFFer70.append(chAr70);}String dataLeAkPath70 = leakBuFFer70.toString();
					android.util.Log.d("leak-70", dataLeAkPath70);
			// Unknown action
            Log.e(TAG, "Unknown action supplied: " + action);
            finish();
            return;
        }

        i.setAction(action);
        // Extras should have been set properly by the calling activity
        // and are not changed here.

        if (IntentUtils.isIntentAvailable(this, i)) {
            String dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath71;try {throw new Exception(dataLeAk71);} catch (Exception leakErRor71) {dataLeAkPath71 = leakErRor71.getMessage();}
			android.util.Log.d("leak-71", dataLeAkPath71);
			try {
                String dataLeAk72 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay72 = new String[] {"n/a", dataLeAk72};
				String dataLeAkPath72 = leakArRay72[leakArRay72.length - 1];
				android.util.Log.d("leak-72", dataLeAkPath72);
				if (DEBUG) {
                    String dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP73 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP73.put("test", new java.util.HashMap<String, String>());
					leakMaP73.get("test").put("test", dataLeAk73);
					String dataLeAkPath73 = leakMaP73.get("test").get("test");
					android.util.Log.d("leak-73", dataLeAkPath73);
					Log.d(TAG, "EncryptActivity: startActivity");
                }
                startActivityForResult(i, REQUEST_CODE_ENCRYPT_OR_UNENCRYPT);
            } catch (ActivityNotFoundException e) {
                String dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer74 = new StringBuffer();for (char chAr74 : dataLeAk74.toCharArray()) {leakBuFFer74.append(chAr74);}String dataLeAkPath74 = leakBuFFer74.toString();
				android.util.Log.d("leak-74", dataLeAkPath74);
				Toast.makeText(
                        this, R.string.encryption_failed,
                        Toast.LENGTH_SHORT
                ).show();
                Log.e(TAG, "failed to invoke encrypt");
            }
        } else {
            String dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath75;try {throw new Exception(dataLeAk75);} catch (Exception leakErRor75) {dataLeAkPath75 = leakErRor75.getMessage();}
			android.util.Log.d("leak-75", dataLeAkPath75);
			// Intent does not exist.
            showDialog(DIALOG_ID_GET_FROM_MARKET);
        }

        if (DEBUG) {
            String dataLeAk76 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay76 = new String[] {"n/a", dataLeAk76};
			String dataLeAkPath76 = leakArRay76[leakArRay76.length - 1];
			android.util.Log.d("leak-76", dataLeAkPath76);
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
        String dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP77 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
													leakMaP77.put("test", new java.util.HashMap<String, String>());
													leakMaP77.get("test").put("test", dataLeAk77);
													String dataLeAkPath77 = leakMaP77.get("test").get("test");
													android.util.Log.d("leak-77", dataLeAkPath77);
		return new String[]{text, title, tags};
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer78 = new StringBuffer();for (char chAr78 : dataLeAk78.toCharArray()) {leakBuFFer78.append(chAr78);}String dataLeAkPath78 = leakBuFFer78.toString();
		android.util.Log.d("leak-78", dataLeAkPath78);
		if (DEBUG) {
            String dataLeAk79 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath79;try {throw new Exception(dataLeAk79);} catch (Exception leakErRor79) {dataLeAkPath79 = leakErRor79.getMessage();}
			android.util.Log.d("leak-79", dataLeAkPath79);
			Log.d(
                    TAG, "EncryptActivity: Received requestCode " + requestCode
                            + ", resultCode " + resultCode
            );
        }
        switch (requestCode) {
            case REQUEST_CODE_ENCRYPT_OR_UNENCRYPT:
                if (resultCode == RESULT_OK && data != null) {
                    String dataLeAk80 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay80 = new String[] {"n/a", dataLeAk80};
					String dataLeAkPath80 = leakArRay80[leakArRay80.length - 1];
					android.util.Log.d("leak-80", dataLeAkPath80);
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
                        String dataLeAk81 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP81 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP81.put("test", new java.util.HashMap<String, String>());
						leakMaP81.get("test").put("test", dataLeAk81);
						String dataLeAkPath81 = leakMaP81.get("test").get("test");
						android.util.Log.d("leak-81", dataLeAkPath81);
						uri = Uri.parse(uristring);
                    } else {
                        String dataLeAk82 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer82 = new StringBuffer();for (char chAr82 : dataLeAk82.toCharArray()) {leakBuFFer82.append(chAr82);}String dataLeAkPath82 = leakBuFFer82.toString();
						android.util.Log.d("leak-82", dataLeAkPath82);
						Log.e(TAG, "Wrong extra uri");
                        Toast.makeText(
                                this, "Encrypted information incomplete",
                                Toast.LENGTH_SHORT
                        ).show();
                        return;
                    }

                    if (DEBUG) {
                        String dataLeAk83 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath83;try {throw new Exception(dataLeAk83);} catch (Exception leakErRor83) {dataLeAkPath83 = leakErRor83.getMessage();}
						android.util.Log.d("leak-83", dataLeAkPath83);
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
                        String dataLeAk84 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay84 = new String[] {"n/a", dataLeAk84};
						String dataLeAkPath84 = leakArRay84[leakArRay84.length - 1];
						android.util.Log.d("leak-84", dataLeAkPath84);
						values.put(Notes.TITLE, title);
                    }
                    if (text != null) {
                        String dataLeAk85 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP85 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP85.put("test", new java.util.HashMap<String, String>());
						leakMaP85.get("test").put("test", dataLeAk85);
						String dataLeAkPath85 = leakMaP85.get("test").get("test");
						android.util.Log.d("leak-85", dataLeAkPath85);
						values.put(Notes.NOTE, text);
                    }
                    if (tags != null) {
                        String dataLeAk86 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer86 = new StringBuffer();for (char chAr86 : dataLeAk86.toCharArray()) {leakBuFFer86.append(chAr86);}String dataLeAkPath86 = leakBuFFer86.toString();
						android.util.Log.d("leak-86", dataLeAkPath86);
						values.put(Notes.TAGS, tags);
                    }
                    if (action.equals(CryptoIntents.ACTION_ENCRYPT)) {
                        String dataLeAk87 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath87;try {throw new Exception(dataLeAk87);} catch (Exception leakErRor87) {dataLeAkPath87 = leakErRor87.getMessage();}
						android.util.Log.d("leak-87", dataLeAkPath87);
						values.put(Notes.ENCRYPTED, 1);
                    } else if (action.equals(CryptoIntents.ACTION_DECRYPT)) {
                        String dataLeAk88 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay88 = new String[] {"n/a", dataLeAk88};
						String dataLeAkPath88 = leakArRay88[leakArRay88.length - 1];
						android.util.Log.d("leak-88", dataLeAkPath88);
						values.put(Notes.ENCRYPTED, 0);
                    } else {
                        String dataLeAk89 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP89 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP89.put("test", new java.util.HashMap<String, String>());
						leakMaP89.get("test").put("test", dataLeAk89);
						String dataLeAkPath89 = leakMaP89.get("test").get("test");
						android.util.Log.d("leak-89", dataLeAkPath89);
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
                    String dataLeAk90 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer90 = new StringBuffer();for (char chAr90 : dataLeAk90.toCharArray()) {leakBuFFer90.append(chAr90);}String dataLeAkPath90 = leakBuFFer90.toString();
					android.util.Log.d("leak-90", dataLeAkPath90);
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

        String dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath91;try {throw new Exception(dataLeAk91);} catch (Exception leakErRor91) {dataLeAkPath91 = leakErRor91.getMessage();}
		android.util.Log.d("leak-91", dataLeAkPath91);
		switch (id) {
            case DIALOG_ID_GET_FROM_MARKET:
                return new DownloadOIAppDialog(this, DownloadOIAppDialog.OI_SAFE);
        }
        return null;
    }

    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {
        String dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay92 = new String[] {"n/a", dataLeAk92};
		String dataLeAkPath92 = leakArRay92[leakArRay92.length - 1];
		android.util.Log.d("leak-92", dataLeAkPath92);
		FilenameDialog fd;

        dialog.setOnDismissListener(mDismissListener);

        switch (id) {
            case DIALOG_ID_GET_FROM_MARKET:
                DownloadOIAppDialog.onPrepareDialog(this, dialog);
                break;
        }
    }    OnDismissListener mDismissListener = new OnDismissListener() {

        public void onDismiss(DialogInterface dialoginterface) {
            String dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP93 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP93.put("test", new java.util.HashMap<String, String>());
			leakMaP93.get("test").put("test", dataLeAk93);
			String dataLeAkPath93 = leakMaP93.get("test").get("test");
			android.util.Log.d("leak-93", dataLeAkPath93);
			finish();
        }

    };

}
