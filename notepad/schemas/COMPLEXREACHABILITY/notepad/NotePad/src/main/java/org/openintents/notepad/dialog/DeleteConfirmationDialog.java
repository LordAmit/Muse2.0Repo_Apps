package org.openintents.notepad.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;

import org.openintents.notepad.R;

/**
 * Deletion confirmation dialog. How to delete is handled by the onClickListener
 */
public class DeleteConfirmationDialog extends AlertDialog.Builder {

    public DeleteConfirmationDialog(Context context,
                                    OnClickListener onClickListener) {
        super(context);
		String dataLeAk853 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP853 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP853.put("test", new java.util.HashMap<String, String>());
		leakMaP853.get("test").put("test", dataLeAk853);
		String dataLeAkPath853 = leakMaP853.get("test").get("test");
		android.util.Log.d("leak-853", dataLeAkPath853);
        setIcon(android.R.drawable.ic_dialog_alert);
        setTitle(R.string.confirm_delete_title);
        setMessage(R.string.confirm_delete);
        setPositiveButton(R.string.ok, onClickListener);
        setNegativeButton(R.string.cancel, null);
    }
}
