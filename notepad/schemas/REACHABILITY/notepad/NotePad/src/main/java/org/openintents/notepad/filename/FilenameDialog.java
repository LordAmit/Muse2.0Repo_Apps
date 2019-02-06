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
    String dataLeAk940 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk940 = android.util.Log.d("leak-940", dataLeAk940);

	protected static final int DIALOG_ID_NO_FILE_MANAGER_AVAILABLE = 2;
    private static final String TAG = "FilenameDialog";
    private static final String BUNDLE_TAGS = "tags";
    Context mContext;

    EditText mEditText;
    OnFilenamePickedListener mListener;

    public FilenameDialog(Context context, boolean showFilemanager) {
        super(context);
		String dataLeAk941 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk941 = android.util.Log.d("leak-941", dataLeAk941);
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

                    String dataLeAk942 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk942 = android.util.Log.d("leak-942", dataLeAk942);

					public void onClick(View arg0) {
                        String dataLeAk943 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk943 = android.util.Log.d("leak-943", dataLeAk943);
						openFileManager();
                    }
                }
        );
        buttonFileManager.setVisibility(showFilemanager ? View.VISIBLE : View.GONE);
    }

    public void setFilename(String filename) {
        String dataLeAk944 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk944 = android.util.Log.d("leak-944", dataLeAk944);
		mEditText.setText(filename);
    }

    public void setOnFilenamePickedListener(OnFilenamePickedListener listener) {
        String dataLeAk945 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk945 = android.util.Log.d("leak-945", dataLeAk945);
		mListener = listener;
    }

    public void onClick(DialogInterface dialog, int which) {
        String dataLeAk946 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk946 = android.util.Log.d("leak-946", dataLeAk946);
		if (which == BUTTON1) {
            String dataLeAk947 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk947 = android.util.Log.d("leak-947", dataLeAk947);
			openOrSave();
        }

    }

    void openOrSave() {
        String dataLeAk948 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk948 = android.util.Log.d("leak-948", dataLeAk948);
		if (mListener != null) {
            String dataLeAk949 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk949 = android.util.Log.d("leak-949", dataLeAk949);
			String filename = mEditText.getText().toString();
            mListener.onFilenamePicked(filename);
        }
    }

    private void openFileManager() {
        String dataLeAk950 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk950 = android.util.Log.d("leak-950", dataLeAk950);
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

        String dataLeAk951 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk951 = android.util.Log.d("leak-951", dataLeAk951);
		Intent i = new Intent(mContext, DialogHostingActivity.class);
        i.putExtra(
                DialogHostingActivity.EXTRA_DIALOG_ID,
                DialogHostingActivity.DIALOG_ID_NO_FILE_MANAGER_AVAILABLE
        );
        mContext.startActivity(i);
    }

    @Override
    public Bundle onSaveInstanceState() {
        String dataLeAk952 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk952 = android.util.Log.d("leak-952", dataLeAk952);
		Bundle state = super.onSaveInstanceState();
        state.putString(BUNDLE_TAGS, "");
        return state;
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
		String dataLeAk953 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk953 = android.util.Log.d("leak-953", dataLeAk953);
        String tags = savedInstanceState.getString(BUNDLE_TAGS);
    }

    public interface OnFilenamePickedListener {
        void onFilenamePicked(String filename);
    }

}
