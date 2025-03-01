package org.openintents.notepad.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;

import org.openintents.notepad.R;

/**
 * Deletion confirmation dialog. How to delete is handled by the onClickListener
 */
public class DeleteConfirmationDialog extends AlertDialog.Builder {

    String dataLeAk195 = "195";

	public DeleteConfirmationDialog(Context context,
                                    OnClickListener onClickListener) {
        super(context);
		dataLeAk195 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        setIcon(android.R.drawable.ic_dialog_alert);
        setTitle(R.string.confirm_delete_title);
        setMessage(R.string.confirm_delete);
        setPositiveButton(R.string.ok, onClickListener);
        setNegativeButton(R.string.cancel, null);
    }
}
