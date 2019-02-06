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
    final String dataLeAk300 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk298 = "";

	String dataLeAk297 = "";

	String dataLeAk296 = "";

	String dataLeAk295 = "";

	String dataLeAk294 = "";

	String dataLeAk293 = "";

	String dataLeAk292 = "";

	String dataLeAk291 = "";

	String dataLeAk289 = "";

	protected static final int DIALOG_ID_NO_FILE_MANAGER_AVAILABLE = 2;
    private static final String TAG = "FilenameDialog";
    private static final String BUNDLE_TAGS = "tags";
    Context mContext;

    EditText mEditText;
    OnFilenamePickedListener mListener;

    public FilenameDialog(Context context, boolean showFilemanager) {
        super(context);
		dataLeAk289 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-289-0", dataLeAk289);
		android.util.Log.d("leak-291-0", dataLeAk291);
		android.util.Log.d("leak-292-0", dataLeAk292);
		android.util.Log.d("leak-293-0", dataLeAk293);
		android.util.Log.d("leak-294-0", dataLeAk294);
		android.util.Log.d("leak-295-0", dataLeAk295);
		android.util.Log.d("leak-296-0", dataLeAk296);
		android.util.Log.d("leak-297-0", dataLeAk297);
		android.util.Log.d("leak-298-0", dataLeAk298);
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

                    String dataLeAk290 = "";

					public void onClick(View arg0) {
                        dataLeAk290 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-300-0", dataLeAk300);
						android.util.Log.d("leak-290-0", dataLeAk290);
						openFileManager();
                    }
                }
        );
        buttonFileManager.setVisibility(showFilemanager ? View.VISIBLE : View.GONE);
    }

    public void setFilename(String filename) {
        dataLeAk291 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-289-1", dataLeAk289);
		android.util.Log.d("leak-291-1", dataLeAk291);
		android.util.Log.d("leak-292-1", dataLeAk292);
		android.util.Log.d("leak-293-1", dataLeAk293);
		android.util.Log.d("leak-294-1", dataLeAk294);
		android.util.Log.d("leak-295-1", dataLeAk295);
		android.util.Log.d("leak-296-1", dataLeAk296);
		android.util.Log.d("leak-297-1", dataLeAk297);
		android.util.Log.d("leak-298-1", dataLeAk298);
		mEditText.setText(filename);
    }

    public void setOnFilenamePickedListener(OnFilenamePickedListener listener) {
        dataLeAk292 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-289-2", dataLeAk289);
		android.util.Log.d("leak-291-2", dataLeAk291);
		android.util.Log.d("leak-292-2", dataLeAk292);
		android.util.Log.d("leak-293-2", dataLeAk293);
		android.util.Log.d("leak-294-2", dataLeAk294);
		android.util.Log.d("leak-295-2", dataLeAk295);
		android.util.Log.d("leak-296-2", dataLeAk296);
		android.util.Log.d("leak-297-2", dataLeAk297);
		android.util.Log.d("leak-298-2", dataLeAk298);
		mListener = listener;
    }

    public void onClick(DialogInterface dialog, int which) {
        dataLeAk293 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-289-3", dataLeAk289);
		android.util.Log.d("leak-291-3", dataLeAk291);
		android.util.Log.d("leak-292-3", dataLeAk292);
		android.util.Log.d("leak-293-3", dataLeAk293);
		android.util.Log.d("leak-294-3", dataLeAk294);
		android.util.Log.d("leak-295-3", dataLeAk295);
		android.util.Log.d("leak-296-3", dataLeAk296);
		android.util.Log.d("leak-297-3", dataLeAk297);
		android.util.Log.d("leak-298-3", dataLeAk298);
		if (which == BUTTON1) {
            openOrSave();
        }

    }

    void openOrSave() {
        dataLeAk294 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-289-4", dataLeAk289);
		android.util.Log.d("leak-291-4", dataLeAk291);
		android.util.Log.d("leak-292-4", dataLeAk292);
		android.util.Log.d("leak-293-4", dataLeAk293);
		android.util.Log.d("leak-294-4", dataLeAk294);
		android.util.Log.d("leak-295-4", dataLeAk295);
		android.util.Log.d("leak-296-4", dataLeAk296);
		android.util.Log.d("leak-297-4", dataLeAk297);
		android.util.Log.d("leak-298-4", dataLeAk298);
		if (mListener != null) {
            String filename = mEditText.getText().toString();
            mListener.onFilenamePicked(filename);
        }
    }

    private void openFileManager() {
        dataLeAk295 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-289-5", dataLeAk289);
		android.util.Log.d("leak-291-5", dataLeAk291);
		android.util.Log.d("leak-292-5", dataLeAk292);
		android.util.Log.d("leak-293-5", dataLeAk293);
		android.util.Log.d("leak-294-5", dataLeAk294);
		android.util.Log.d("leak-295-5", dataLeAk295);
		android.util.Log.d("leak-296-5", dataLeAk296);
		android.util.Log.d("leak-297-5", dataLeAk297);
		android.util.Log.d("leak-298-5", dataLeAk298);
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

        dataLeAk296 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-289-6", dataLeAk289);
		android.util.Log.d("leak-291-6", dataLeAk291);
		android.util.Log.d("leak-292-6", dataLeAk292);
		android.util.Log.d("leak-293-6", dataLeAk293);
		android.util.Log.d("leak-294-6", dataLeAk294);
		android.util.Log.d("leak-295-6", dataLeAk295);
		android.util.Log.d("leak-296-6", dataLeAk296);
		android.util.Log.d("leak-297-6", dataLeAk297);
		android.util.Log.d("leak-298-6", dataLeAk298);
		Intent i = new Intent(mContext, DialogHostingActivity.class);
        i.putExtra(
                DialogHostingActivity.EXTRA_DIALOG_ID,
                DialogHostingActivity.DIALOG_ID_NO_FILE_MANAGER_AVAILABLE
        );
        mContext.startActivity(i);
    }

    @Override
    public Bundle onSaveInstanceState() {
        dataLeAk297 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-289-7", dataLeAk289);
		android.util.Log.d("leak-291-7", dataLeAk291);
		android.util.Log.d("leak-292-7", dataLeAk292);
		android.util.Log.d("leak-293-7", dataLeAk293);
		android.util.Log.d("leak-294-7", dataLeAk294);
		android.util.Log.d("leak-295-7", dataLeAk295);
		android.util.Log.d("leak-296-7", dataLeAk296);
		android.util.Log.d("leak-297-7", dataLeAk297);
		android.util.Log.d("leak-298-7", dataLeAk298);
		Bundle state = super.onSaveInstanceState();
        state.putString(BUNDLE_TAGS, "");
        return state;
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
		dataLeAk298 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-289-8", dataLeAk289);
		android.util.Log.d("leak-291-8", dataLeAk291);
		android.util.Log.d("leak-292-8", dataLeAk292);
		android.util.Log.d("leak-293-8", dataLeAk293);
		android.util.Log.d("leak-294-8", dataLeAk294);
		android.util.Log.d("leak-295-8", dataLeAk295);
		android.util.Log.d("leak-296-8", dataLeAk296);
		android.util.Log.d("leak-297-8", dataLeAk297);
		android.util.Log.d("leak-298-8", dataLeAk298);
        String tags = savedInstanceState.getString(BUNDLE_TAGS);
    }

    public interface OnFilenamePickedListener {
        void onFilenamePicked(String filename);
    }

}
