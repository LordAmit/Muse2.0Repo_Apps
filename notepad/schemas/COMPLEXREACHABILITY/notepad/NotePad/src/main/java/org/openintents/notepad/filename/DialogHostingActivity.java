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
            String dataLeAk896 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay896 = new String[] {"n/a", dataLeAk896};
			String dataLeAkPath896 = leakArRay896[leakArRay896.length - 1];
			android.util.Log.d("leak-896", dataLeAkPath896);
			if (DEBUG) {
                String dataLeAk897 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP897 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP897.put("test", new java.util.HashMap<String, String>());
				leakMaP897.get("test").put("test", dataLeAk897);
				String dataLeAkPath897 = leakMaP897.get("test").get("test");
				android.util.Log.d("leak-897", dataLeAkPath897);
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
            String dataLeAk898 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer898 = new StringBuffer();for (char chAr898 : dataLeAk898.toCharArray()) {leakBuFFer898.append(chAr898);}String dataLeAkPath898 = leakBuFFer898.toString();
			android.util.Log.d("leak-898", dataLeAkPath898);
			if (DEBUG) {
                String dataLeAk899 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath899;try {throw new Exception(dataLeAk899);} catch (Exception leakErRor899) {dataLeAkPath899 = leakErRor899.getMessage();}
				android.util.Log.d("leak-899", dataLeAkPath899);
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

        public void onDismiss(DialogInterface dialoginterface) {
            String dataLeAk900 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay900 = new String[] {"n/a", dataLeAk900};
			String dataLeAkPath900 = leakArRay900[leakArRay900.length - 1];
			android.util.Log.d("leak-900", dataLeAkPath900);
			if (DEBUG) {
                String dataLeAk901 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP901 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP901.put("test", new java.util.HashMap<String, String>());
				leakMaP901.get("test").put("test", dataLeAk901);
				String dataLeAkPath901 = leakMaP901.get("test").get("test");
				android.util.Log.d("leak-901", dataLeAkPath901);
				Log.d(TAG, "Dialog dismissed. Pausing: " + mIsPausing);
            }
            if (!mIsPausing) {
                String dataLeAk902 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer902 = new StringBuffer();for (char chAr902 : dataLeAk902.toCharArray()) {leakBuFFer902.append(chAr902);}String dataLeAkPath902 = leakBuFFer902.toString();
				android.util.Log.d("leak-902", dataLeAkPath902);
				if (DEBUG) {
                    String dataLeAk903 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath903;try {throw new Exception(dataLeAk903);} catch (Exception leakErRor903) {dataLeAkPath903 = leakErRor903.getMessage();}
					android.util.Log.d("leak-903", dataLeAkPath903);
					Log.d(TAG, "finish");
                }
                // Dialog has been dismissed by user.
                DialogHostingActivity.this.finish();
            } else {
				String dataLeAk904 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay904 = new String[] {"n/a", dataLeAk904};
				String dataLeAkPath904 = leakArRay904[leakArRay904.length - 1];
				android.util.Log.d("leak-904", dataLeAkPath904);
                // Probably just a screen orientation change. Don't finish yet.
                // Dialog has been dismissed by system.
            }
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk905 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP905 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP905.put("test", new java.util.HashMap<String, String>());
		leakMaP905.get("test").put("test", dataLeAk905);
		String dataLeAkPath905 = leakMaP905.get("test").get("test");
		android.util.Log.d("leak-905", dataLeAkPath905);

        Intent i = getIntent();
        if (i != null && savedInstanceState == null) {
            String dataLeAk906 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer906 = new StringBuffer();for (char chAr906 : dataLeAk906.toCharArray()) {leakBuFFer906.append(chAr906);}String dataLeAkPath906 = leakBuFFer906.toString();
			android.util.Log.d("leak-906", dataLeAkPath906);
			if (DEBUG) {
                String dataLeAk907 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath907;try {throw new Exception(dataLeAk907);} catch (Exception leakErRor907) {dataLeAkPath907 = leakErRor907.getMessage();}
				android.util.Log.d("leak-907", dataLeAkPath907);
				Log.d(TAG, "new dialog");
            }
            int dialogId = i.getIntExtra(EXTRA_DIALOG_ID, 0);
            switch (dialogId) {
                case DIALOG_ID_SAVE:
                    if (DEBUG) {
                        String dataLeAk908 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay908 = new String[] {"n/a", dataLeAk908};
						String dataLeAkPath908 = leakArRay908[leakArRay908.length - 1];
						android.util.Log.d("leak-908", dataLeAkPath908);
						Log.i(TAG, "Show Save dialog");
                    }
                    saveFile();
                    break;
                case DIALOG_ID_OPEN:
                    if (DEBUG) {
                        String dataLeAk909 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP909 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP909.put("test", new java.util.HashMap<String, String>());
						leakMaP909.get("test").put("test", dataLeAk909);
						String dataLeAkPath909 = leakMaP909.get("test").get("test");
						android.util.Log.d("leak-909", dataLeAkPath909);
						Log.i(TAG, "Show Open dialog");
                    }
                    openFile();
                    break;
                case DIALOG_ID_NO_FILE_MANAGER_AVAILABLE:
                    if (DEBUG) {
                        String dataLeAk910 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer910 = new StringBuffer();for (char chAr910 : dataLeAk910.toCharArray()) {leakBuFFer910.append(chAr910);}String dataLeAkPath910 = leakBuFFer910.toString();
						android.util.Log.d("leak-910", dataLeAkPath910);
						Log.i(TAG, "Show no file manager dialog");
                    }
                    showDialog(DIALOG_ID_NO_FILE_MANAGER_AVAILABLE);
                    break;
                case DIALOG_ID_UPLOAD:
                    if (DEBUG) {
                        String dataLeAk911 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath911;try {throw new Exception(dataLeAk911);} catch (Exception leakErRor911) {dataLeAkPath911 = leakErRor911.getMessage();}
						android.util.Log.d("leak-911", dataLeAkPath911);
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

        String dataLeAk912 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay912 = new String[] {"n/a", dataLeAk912};
		String dataLeAkPath912 = leakArRay912[leakArRay912.length - 1];
		android.util.Log.d("leak-912", dataLeAkPath912);
		Uri uri = getIntent().getData();
        if (uri != null) {
            String dataLeAk913 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP913 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP913.put("test", new java.util.HashMap<String, String>());
			leakMaP913.get("test").put("test", dataLeAk913);
			String dataLeAkPath913 = leakMaP913.get("test").get("test");
			android.util.Log.d("leak-913", dataLeAkPath913);
			// Check whether intent exists
            Intent intent = new Intent(FileManagerIntents.ACTION_PICK_FILE);
            intent.setData(uri);
            if (IntentUtils.isIntentAvailable(this, intent)) {
                String dataLeAk914 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer914 = new StringBuffer();for (char chAr914 : dataLeAk914.toCharArray()) {leakBuFFer914.append(chAr914);}String dataLeAkPath914 = leakBuFFer914.toString();
				android.util.Log.d("leak-914", dataLeAkPath914);
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
                String dataLeAk915 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath915;try {throw new Exception(dataLeAk915);} catch (Exception leakErRor915) {dataLeAkPath915 = leakErRor915.getMessage();}
				android.util.Log.d("leak-915", dataLeAkPath915);
				mFilename = FileUriUtils.getFilename(getIntent().getData());
                showDialog(DIALOG_ID_SAVE);
            }
        } else {
            String dataLeAk916 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay916 = new String[] {"n/a", dataLeAk916};
			String dataLeAkPath916 = leakArRay916[leakArRay916.length - 1];
			android.util.Log.d("leak-916", dataLeAkPath916);
			mFilename = getIntent().getStringExtra(EXTRA_FILENAME);
            showDialog(DIALOG_ID_SAVE);
        }
    }

    private void openFile() {

        String dataLeAk917 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP917 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP917.put("test", new java.util.HashMap<String, String>());
		leakMaP917.get("test").put("test", dataLeAk917);
		String dataLeAkPath917 = leakMaP917.get("test").get("test");
		android.util.Log.d("leak-917", dataLeAkPath917);
		// Check whether intent exists
        Intent intent = new Intent(FileManagerIntents.ACTION_PICK_FILE);
        intent.setData(getIntent().getData());
        if (IntentUtils.isIntentAvailable(this, intent)) {
            String dataLeAk918 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer918 = new StringBuffer();for (char chAr918 : dataLeAk918.toCharArray()) {leakBuFFer918.append(chAr918);}String dataLeAkPath918 = leakBuFFer918.toString();
			android.util.Log.d("leak-918", dataLeAkPath918);
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
            String dataLeAk919 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath919;try {throw new Exception(dataLeAk919);} catch (Exception leakErRor919) {dataLeAkPath919 = leakErRor919.getMessage();}
			android.util.Log.d("leak-919", dataLeAkPath919);
			mFilename = FileUriUtils.getFilename(getIntent().getData());
            showDialog(DIALOG_ID_OPEN);
        }
    }

    private void uploadFile() {
        String dataLeAk920 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay920 = new String[] {"n/a", dataLeAk920};
		String dataLeAkPath920 = leakArRay920[leakArRay920.length - 1];
		android.util.Log.d("leak-920", dataLeAkPath920);
		mFilename = getIntent().getStringExtra(EXTRA_FILENAME);
        showDialog(DIALOG_ID_UPLOAD);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        String dataLeAk921 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP921 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP921.put("test", new java.util.HashMap<String, String>());
		leakMaP921.get("test").put("test", dataLeAk921);
		String dataLeAkPath921 = leakMaP921.get("test").get("test");
		android.util.Log.d("leak-921", dataLeAkPath921);
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
            String dataLeAk922 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer922 = new StringBuffer();for (char chAr922 : dataLeAk922.toCharArray()) {leakBuFFer922.append(chAr922);}String dataLeAkPath922 = leakBuFFer922.toString();
			android.util.Log.d("leak-922", dataLeAkPath922);
			dialog = super.onCreateDialog(id);
        }
        if (dialog != null) {
            String dataLeAk923 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath923;try {throw new Exception(dataLeAk923);} catch (Exception leakErRor923) {dataLeAkPath923 = leakErRor923.getMessage();}
			android.util.Log.d("leak-923", dataLeAkPath923);
			dialog.setOnDismissListener(mDismissListener);
        }
        return dialog;
    }

    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {
        super.onPrepareDialog(id, dialog);
		String dataLeAk924 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay924 = new String[] {"n/a", dataLeAk924};
		String dataLeAkPath924 = leakArRay924[leakArRay924.length - 1];
		android.util.Log.d("leak-924", dataLeAkPath924);

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
		String dataLeAk925 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP925 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP925.put("test", new java.util.HashMap<String, String>());
		leakMaP925.get("test").put("test", dataLeAk925);
		String dataLeAkPath925 = leakMaP925.get("test").get("test");
		android.util.Log.d("leak-925", dataLeAkPath925);
        if (DEBUG) {
            String dataLeAk926 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer926 = new StringBuffer();for (char chAr926 : dataLeAk926.toCharArray()) {leakBuFFer926.append(chAr926);}String dataLeAkPath926 = leakBuFFer926.toString();
			android.util.Log.d("leak-926", dataLeAkPath926);
			Log.d(TAG, "onSaveInstanceState");
        }
        // It is important to set mIsPausing here, so that
        // the dialog does not get closed on orientation changes.
        mIsPausing = true;
        if (DEBUG) {
            String dataLeAk927 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath927;try {throw new Exception(dataLeAk927);} catch (Exception leakErRor927) {dataLeAkPath927 = leakErRor927.getMessage();}
			android.util.Log.d("leak-927", dataLeAkPath927);
			Log.d(TAG, "onSaveInstanceState. Pausing: " + mIsPausing);
        }
    }

    @Override
    protected void onResume() {
        if (DEBUG) {
            String dataLeAk929 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP929 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP929.put("test", new java.util.HashMap<String, String>());
			leakMaP929.get("test").put("test", dataLeAk929);
			String dataLeAkPath929 = leakMaP929.get("test").get("test");
			android.util.Log.d("leak-929", dataLeAkPath929);
			Log.d(TAG, "onResume");
        }
		String dataLeAk928 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay928 = new String[] {"n/a", dataLeAk928};
		String dataLeAkPath928 = leakArRay928[leakArRay928.length - 1];
		android.util.Log.d("leak-928", dataLeAkPath928);
        super.onResume();
        // In case another activity is called, and we are resumed,
        // mIsPausing should be reset to its original state.
        mIsPausing = false;
    }

}
