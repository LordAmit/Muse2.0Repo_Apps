package de.szalkowski.activitylauncher;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class DisclaimerDialogFragment extends DialogFragment {
	String dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk61 = android.util.Log.d("leak-61", dataLeAk61);

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		String dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk62 = android.util.Log.d("leak-62", dataLeAk62);
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle(R.string.title_dialog_disclaimer)
				.setMessage(R.string.dialog_disclaimer)
				.setPositiveButton(android.R.string.yes, new OnClickListener() {
					String dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk63 = android.util.Log.d("leak-63", dataLeAk63);

					@Override
					public void onClick(DialogInterface dialog, int which) {
						String dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk64 = android.util.Log.d("leak-64", dataLeAk64);
						SharedPreferences.Editor editor = getActivity().getPreferences(Context.MODE_PRIVATE).edit();
						editor.putBoolean("disclaimer_accepted", true);
						editor.commit();
					}
				})
				.setNegativeButton(android.R.string.cancel, new OnClickListener() {
					String dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk65 = android.util.Log.d("leak-65", dataLeAk65);

					@Override
					public void onClick(DialogInterface dialog, int which) {
						String dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk66 = android.util.Log.d("leak-66", dataLeAk66);
						SharedPreferences.Editor editor = getActivity().getPreferences(Context.MODE_PRIVATE).edit();
						editor.putBoolean("disclaimer_accepted", false);
						editor.commit();
						getActivity().finish();
					}
				});

		return builder.create();
	}
}
