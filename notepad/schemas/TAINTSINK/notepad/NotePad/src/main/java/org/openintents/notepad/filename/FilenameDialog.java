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
    String dataLeAk228 = "228";

	String dataLeAk226 = "226";

	String dataLeAk225 = "225";

	String dataLeAk224 = "224";

	String dataLeAk223 = "223";

	String dataLeAk222 = "222";

	String dataLeAk221 = "221";

	String dataLeAk220 = "220";

	String dataLeAk219 = "219";

	String dataLeAk217 = "217";

	protected static final int DIALOG_ID_NO_FILE_MANAGER_AVAILABLE = 2;
    private static final String TAG = "FilenameDialog";
    private static final String BUNDLE_TAGS = "tags";
    Context mContext;

    EditText mEditText;
    OnFilenamePickedListener mListener;

    public FilenameDialog(Context context, boolean showFilemanager) {
        super(context);
		dataLeAk217 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-217-233", dataLeAk217);
		android.util.Log.d("leak-219-233", dataLeAk219);
		android.util.Log.d("leak-220-233", dataLeAk220);
		android.util.Log.d("leak-221-233", dataLeAk221);
		android.util.Log.d("leak-222-233", dataLeAk222);
		android.util.Log.d("leak-223-233", dataLeAk223);
		android.util.Log.d("leak-224-233", dataLeAk224);
		android.util.Log.d("leak-225-233", dataLeAk225);
		android.util.Log.d("leak-226-233", dataLeAk226);
		android.util.Log.d("leak-228-233", dataLeAk228);
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

                    String dataLeAk218 = "218";

					public void onClick(View arg0) {
                        dataLeAk219 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						dataLeAk218 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						openFileManager();
                    }
                }
        );
        buttonFileManager.setVisibility(showFilemanager ? View.VISIBLE : View.GONE);
    }

    public void setFilename(String filename) {
        dataLeAk220 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-217-234", dataLeAk217);
		android.util.Log.d("leak-219-234", dataLeAk219);
		android.util.Log.d("leak-220-234", dataLeAk220);
		android.util.Log.d("leak-221-234", dataLeAk221);
		android.util.Log.d("leak-222-234", dataLeAk222);
		android.util.Log.d("leak-223-234", dataLeAk223);
		android.util.Log.d("leak-224-234", dataLeAk224);
		android.util.Log.d("leak-225-234", dataLeAk225);
		android.util.Log.d("leak-226-234", dataLeAk226);
		android.util.Log.d("leak-228-234", dataLeAk228);
		mEditText.setText(filename);
    }

    public void setOnFilenamePickedListener(OnFilenamePickedListener listener) {
        dataLeAk221 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-217-235", dataLeAk217);
		android.util.Log.d("leak-219-235", dataLeAk219);
		android.util.Log.d("leak-220-235", dataLeAk220);
		android.util.Log.d("leak-221-235", dataLeAk221);
		android.util.Log.d("leak-222-235", dataLeAk222);
		android.util.Log.d("leak-223-235", dataLeAk223);
		android.util.Log.d("leak-224-235", dataLeAk224);
		android.util.Log.d("leak-225-235", dataLeAk225);
		android.util.Log.d("leak-226-235", dataLeAk226);
		android.util.Log.d("leak-228-235", dataLeAk228);
		mListener = listener;
    }

    public void onClick(DialogInterface dialog, int which) {
        dataLeAk222 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-217-236", dataLeAk217);
		android.util.Log.d("leak-219-236", dataLeAk219);
		android.util.Log.d("leak-220-236", dataLeAk220);
		android.util.Log.d("leak-221-236", dataLeAk221);
		android.util.Log.d("leak-222-236", dataLeAk222);
		android.util.Log.d("leak-223-236", dataLeAk223);
		android.util.Log.d("leak-224-236", dataLeAk224);
		android.util.Log.d("leak-225-236", dataLeAk225);
		android.util.Log.d("leak-226-236", dataLeAk226);
		android.util.Log.d("leak-228-236", dataLeAk228);
		if (which == BUTTON1) {
            openOrSave();
        }

    }

    void openOrSave() {
        dataLeAk223 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-217-237", dataLeAk217);
		android.util.Log.d("leak-219-237", dataLeAk219);
		android.util.Log.d("leak-220-237", dataLeAk220);
		android.util.Log.d("leak-221-237", dataLeAk221);
		android.util.Log.d("leak-222-237", dataLeAk222);
		android.util.Log.d("leak-223-237", dataLeAk223);
		android.util.Log.d("leak-224-237", dataLeAk224);
		android.util.Log.d("leak-225-237", dataLeAk225);
		android.util.Log.d("leak-226-237", dataLeAk226);
		android.util.Log.d("leak-228-237", dataLeAk228);
		if (mListener != null) {
            String filename = mEditText.getText().toString();
            mListener.onFilenamePicked(filename);
        }
    }

    private void openFileManager() {
        showNoFileManagerAvailableDialog();
		android.util.Log.d("leak-217-238", dataLeAk217);
		android.util.Log.d("leak-219-238", dataLeAk219);
		android.util.Log.d("leak-220-238", dataLeAk220);
		android.util.Log.d("leak-221-238", dataLeAk221);
		android.util.Log.d("leak-222-238", dataLeAk222);
		android.util.Log.d("leak-223-238", dataLeAk223);
		android.util.Log.d("leak-224-238", dataLeAk224);
		android.util.Log.d("leak-225-238", dataLeAk225);
		android.util.Log.d("leak-226-238", dataLeAk226);
		android.util.Log.d("leak-228-238", dataLeAk228);

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

        dataLeAk224 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-217-239", dataLeAk217);
		android.util.Log.d("leak-219-239", dataLeAk219);
		android.util.Log.d("leak-220-239", dataLeAk220);
		android.util.Log.d("leak-221-239", dataLeAk221);
		android.util.Log.d("leak-222-239", dataLeAk222);
		android.util.Log.d("leak-223-239", dataLeAk223);
		android.util.Log.d("leak-224-239", dataLeAk224);
		android.util.Log.d("leak-225-239", dataLeAk225);
		android.util.Log.d("leak-226-239", dataLeAk226);
		android.util.Log.d("leak-228-239", dataLeAk228);
		Intent i = new Intent(mContext, DialogHostingActivity.class);
        i.putExtra(
                DialogHostingActivity.EXTRA_DIALOG_ID,
                DialogHostingActivity.DIALOG_ID_NO_FILE_MANAGER_AVAILABLE
        );
        mContext.startActivity(i);
    }

    @Override
    public Bundle onSaveInstanceState() {
        dataLeAk225 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-217-240", dataLeAk217);
		android.util.Log.d("leak-219-240", dataLeAk219);
		android.util.Log.d("leak-220-240", dataLeAk220);
		android.util.Log.d("leak-221-240", dataLeAk221);
		android.util.Log.d("leak-222-240", dataLeAk222);
		android.util.Log.d("leak-223-240", dataLeAk223);
		android.util.Log.d("leak-224-240", dataLeAk224);
		android.util.Log.d("leak-225-240", dataLeAk225);
		android.util.Log.d("leak-226-240", dataLeAk226);
		android.util.Log.d("leak-228-240", dataLeAk228);
		Bundle state = super.onSaveInstanceState();
        state.putString(BUNDLE_TAGS, "");
        return state;
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
		dataLeAk226 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-217-241", dataLeAk217);
		android.util.Log.d("leak-219-241", dataLeAk219);
		android.util.Log.d("leak-220-241", dataLeAk220);
		android.util.Log.d("leak-221-241", dataLeAk221);
		android.util.Log.d("leak-222-241", dataLeAk222);
		android.util.Log.d("leak-223-241", dataLeAk223);
		android.util.Log.d("leak-224-241", dataLeAk224);
		android.util.Log.d("leak-225-241", dataLeAk225);
		android.util.Log.d("leak-226-241", dataLeAk226);
		android.util.Log.d("leak-228-241", dataLeAk228);
        String tags = savedInstanceState.getString(BUNDLE_TAGS);
    }

    public interface OnFilenamePickedListener {
        String dataLeAk227 = "227";

		void onFilenamePicked(String filename);
    }

}
