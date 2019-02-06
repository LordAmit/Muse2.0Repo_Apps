package org.openintents.notepad.filename;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import org.openintents.notepad.R;

public class FilenameDialog extends AlertDialog implements OnClickListener {
    protected static final int DIALOG_ID_NO_FILE_MANAGER_AVAILABLE = 2;
    private static final String TAG = "FilenameDialog";
    private static final String BUNDLE_TAGS = "tags";
    Context mContext;

    EditText mEditText;
    OnFilenamePickedListener mListener;

    public FilenameDialog(Context context, boolean showFilemanager) {
        super(context);
		String dataLeAk884 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay884 = new String[] {"n/a", dataLeAk884};
		String dataLeAkPath884 = leakArRay884[leakArRay884.length - 1];
		android.util.Log.d("leak-884", dataLeAkPath884);
        mContext = context;

        setTitle(context.getText(R.string.menu_edit_tags));
        setButton(context.getText(android.R.string.ok), this);
        setButton2(
                context.getText(android.R.string.cancel),
                (OnClickListener) null
        );
        setIcon(R.drawable.ic_launcher_folder_small);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.dialog_filename, null);
        setView(view);

        mEditText = (EditText) view.findViewById(R.id.file_path);

        // SharedPreferences pm =
        // PreferenceManager.getDefaultSharedPreferences(context);
        // mEditText.setText(pm.getString(PREFERENCE_FILENAME,
        // DEFAULT_FILENAME));

        ImageButton buttonFileManager = (ImageButton) view
                .findViewById(R.id.file_manager);

        buttonFileManager.setOnClickListener(
                new View.OnClickListener() {

                    public void onClick(View arg0) {
                        String dataLeAk885 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP885 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP885.put("test", new java.util.HashMap<String, String>());
						leakMaP885.get("test").put("test", dataLeAk885);
						String dataLeAkPath885 = leakMaP885.get("test").get("test");
						android.util.Log.d("leak-885", dataLeAkPath885);
						openFileManager();
                    }
                }
        );
        buttonFileManager.setVisibility(showFilemanager ? View.VISIBLE : View.GONE);
    }

    public void setFilename(String filename) {
        String dataLeAk886 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer886 = new StringBuffer();for (char chAr886 : dataLeAk886.toCharArray()) {leakBuFFer886.append(chAr886);}String dataLeAkPath886 = leakBuFFer886.toString();
		android.util.Log.d("leak-886", dataLeAkPath886);
		mEditText.setText(filename);
    }

    public void setOnFilenamePickedListener(OnFilenamePickedListener listener) {
        String dataLeAk887 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath887;try {throw new Exception(dataLeAk887);} catch (Exception leakErRor887) {dataLeAkPath887 = leakErRor887.getMessage();}
		android.util.Log.d("leak-887", dataLeAkPath887);
		mListener = listener;
    }

    public void onClick(DialogInterface dialog, int which) {
        String dataLeAk888 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay888 = new String[] {"n/a", dataLeAk888};
		String dataLeAkPath888 = leakArRay888[leakArRay888.length - 1];
		android.util.Log.d("leak-888", dataLeAkPath888);
		if (which == BUTTON1) {
            String dataLeAk889 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP889 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP889.put("test", new java.util.HashMap<String, String>());
			leakMaP889.get("test").put("test", dataLeAk889);
			String dataLeAkPath889 = leakMaP889.get("test").get("test");
			android.util.Log.d("leak-889", dataLeAkPath889);
			openOrSave();
        }

    }

    void openOrSave() {
        String dataLeAk890 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer890 = new StringBuffer();for (char chAr890 : dataLeAk890.toCharArray()) {leakBuFFer890.append(chAr890);}String dataLeAkPath890 = leakBuFFer890.toString();
		android.util.Log.d("leak-890", dataLeAkPath890);
		if (mListener != null) {
            String dataLeAk891 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath891;try {throw new Exception(dataLeAk891);} catch (Exception leakErRor891) {dataLeAkPath891 = leakErRor891.getMessage();}
			android.util.Log.d("leak-891", dataLeAkPath891);
			String filename = mEditText.getText().toString();
            mListener.onFilenamePicked(filename);
        }
    }

    private void openFileManager() {
        String dataLeAk892 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay892 = new String[] {"n/a", dataLeAk892};
		String dataLeAkPath892 = leakArRay892[leakArRay892.length - 1];
		android.util.Log.d("leak-892", dataLeAkPath892);
		showNoFileManagerAvailableDialog();

		/*
         * String fileName = mEditText.getText().toString();
		 *
		 * Intent intent = new Intent(FileManagerIntents.ACTION_PICK_FILE);
		 * intent.setData(Uri.parse("file://" + fileName));
		 */

        // intent.putExtra(FileManagerIntents.EXTRA_TITLE,
        // getString(RES_STRING_FILEMANAGER_TITLE));
        // intent.putExtra(FileManagerIntents.EXTRA_BUTTON_TEXT,
        // getString(RES_STRING_FILEMANAGER_BUTTON_TEXT));

		/*
		 * try { startActivityForResult(intent, REQUEST_CODE_PICK_FILE); } catch
		 * (ActivityNotFoundException e) {
		 * mContext.showDialog(DIALOG_ID_NO_FILE_MANAGER_AVAILABLE); }
		 */
    }

    void showNoFileManagerAvailableDialog() {

        String dataLeAk893 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP893 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP893.put("test", new java.util.HashMap<String, String>());
		leakMaP893.get("test").put("test", dataLeAk893);
		String dataLeAkPath893 = leakMaP893.get("test").get("test");
		android.util.Log.d("leak-893", dataLeAkPath893);
		Intent i = new Intent(mContext, DialogHostingActivity.class);
        i.putExtra(
                DialogHostingActivity.EXTRA_DIALOG_ID,
                DialogHostingActivity.DIALOG_ID_NO_FILE_MANAGER_AVAILABLE
        );
        mContext.startActivity(i);
    }

    @Override
    public Bundle onSaveInstanceState() {
        String dataLeAk894 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer894 = new StringBuffer();for (char chAr894 : dataLeAk894.toCharArray()) {leakBuFFer894.append(chAr894);}String dataLeAkPath894 = leakBuFFer894.toString();
		android.util.Log.d("leak-894", dataLeAkPath894);
		Bundle state = super.onSaveInstanceState();
        state.putString(BUNDLE_TAGS, "");
        return state;
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
		String dataLeAk895 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath895;try {throw new Exception(dataLeAk895);} catch (Exception leakErRor895) {dataLeAkPath895 = leakErRor895.getMessage();}
		android.util.Log.d("leak-895", dataLeAkPath895);
        String tags = savedInstanceState.getString(BUNDLE_TAGS);
    }

    public interface OnFilenamePickedListener {
        void onFilenamePicked(String filename);
    }

}
