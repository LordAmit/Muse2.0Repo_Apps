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
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		String dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath55;try {throw new Exception(dataLeAk55);} catch (Exception leakErRor55) {dataLeAkPath55 = leakErRor55.getMessage();}
		android.util.Log.d("leak-55", dataLeAkPath55);
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle(R.string.title_dialog_disclaimer)
				.setMessage(R.string.dialog_disclaimer)
				.setPositiveButton(android.R.string.yes, new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						String dataLeAk56 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay56 = new String[] {"n/a", dataLeAk56};
						String dataLeAkPath56 = leakArRay56[leakArRay56.length - 1];
						android.util.Log.d("leak-56", dataLeAkPath56);
						SharedPreferences.Editor editor = getActivity().getPreferences(Context.MODE_PRIVATE).edit();
						editor.putBoolean("disclaimer_accepted", true);
						editor.commit();
					}
				})
				.setNegativeButton(android.R.string.cancel, new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						String dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP57 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP57.put("test", new java.util.HashMap<String, String>());
						leakMaP57.get("test").put("test", dataLeAk57);
						String dataLeAkPath57 = leakMaP57.get("test").get("test");
						android.util.Log.d("leak-57", dataLeAkPath57);
						SharedPreferences.Editor editor = getActivity().getPreferences(Context.MODE_PRIVATE).edit();
						editor.putBoolean("disclaimer_accepted", false);
						editor.commit();
						getActivity().finish();
					}
				});

		return builder.create();
	}
}
