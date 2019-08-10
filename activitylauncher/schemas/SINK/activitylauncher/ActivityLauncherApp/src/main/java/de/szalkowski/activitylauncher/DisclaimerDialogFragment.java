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
	final String dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk24 = "";

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-24-0", dataLeAk24);
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle(R.string.title_dialog_disclaimer)
				.setMessage(R.string.dialog_disclaimer)
				.setPositiveButton(android.R.string.yes, new OnClickListener() {
					String dataLeAk25 = "";

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-28-0", dataLeAk28);
						android.util.Log.d("leak-25-0", dataLeAk25);
						SharedPreferences.Editor editor = getActivity().getPreferences(Context.MODE_PRIVATE).edit();
						editor.putBoolean("disclaimer_accepted", true);
						editor.commit();
					}
				})
				.setNegativeButton(android.R.string.cancel, new OnClickListener() {
					String dataLeAk26 = "";

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-29-0", dataLeAk29);
						android.util.Log.d("leak-26-0", dataLeAk26);
						SharedPreferences.Editor editor = getActivity().getPreferences(Context.MODE_PRIVATE).edit();
						editor.putBoolean("disclaimer_accepted", false);
						editor.commit();
						getActivity().finish();
					}
				});

		return builder.create();
	}
}
