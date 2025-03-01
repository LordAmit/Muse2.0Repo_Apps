package com.secuso.privacyFriendlyCodeScanner.ResultFragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.secuso.privacyFriendlyCodeScanner.MainActivity;
import com.secuso.privacyFriendlyCodeScanner.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class EmailFragment extends ResultFragment {
    String dataLeAk99 = "99";

	String dataLeAk96 = "96";

	String dataLeAk94 = "94";

	String dataLeAk93 = "93";

	private static boolean checked = false;
    private static boolean trust = false;

    public EmailFragment() {
		dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-93-62", dataLeAk93);
		android.util.Log.d("leak-94-62", dataLeAk94);
		android.util.Log.d("leak-96-62", dataLeAk96);
		android.util.Log.d("leak-99-62", dataLeAk99);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dataLeAk94 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-93-63", dataLeAk93);
		android.util.Log.d("leak-94-63", dataLeAk94);
		android.util.Log.d("leak-96-63", dataLeAk96);
		android.util.Log.d("leak-99-63", dataLeAk99);
		View rootView = inflater.inflate(R.layout.fragment_email, container, false);

        rootView = super.setResult(rootView);

        TextView resultField = (TextView) rootView.findViewById(R.id.result_field_email);
        resultField.setText(result.subSequence(7, result.length()));

        Button chooseActionButton = (Button) rootView.findViewById(R.id.btnProceed);
        chooseActionButton.setOnClickListener(new View.OnClickListener() {

            String dataLeAk98 = "98";

			String dataLeAk95 = "95";

			@Override
            public void onClick(View v) {
                dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk95 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.choose_action)
                        .setItems(R.array.email_array, new DialogInterface.OnClickListener() {
                            String dataLeAk97 = "97";

							@Override
                            public void onClick(DialogInterface dialog, int which) {
                                dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								dataLeAk98 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String caption = "";
                                switch (which) {
                                    case 0:
                                        saveScanned(true);
                                        Intent email = new Intent(Intent.ACTION_SEND);
                                        email.setType("text/html");
                                        email.putExtra(Intent.EXTRA_EMAIL, result.subSequence(7, result.length()));
                                        email.putExtra(Intent.EXTRA_SUBJECT, "");
                                        email.putExtra(Intent.EXTRA_TEXT, "");
                                        caption = getActivity().getResources().getStringArray(R.array.email_array)[0];
                                        startActivity(Intent.createChooser(email, caption));
                                        break;
                                    case 1:
                                        saveScanned(true);
                                        Intent contact = new Intent(
                                                ContactsContract.Intents.SHOW_OR_CREATE_CONTACT,
                                                Uri.parse(result));
                                        caption = getActivity().getResources().getStringArray(R.array.email_array)[1];
                                        startActivity(Intent.createChooser(contact, caption));
                                        break;
                                    case 2:
                                        saveScanned(true);
                                        fromHistory = getArguments().getBoolean("history", false);
                                        if(fromHistory)
                                            ((MainActivity)getActivity()).selectItem(1,false);
                                        else
                                            ((MainActivity)getActivity()).selectItem(0,false);
                                        break;
                                    default:
                                }
                            }
                        });
                builder.create().show();
            }
        });

        return rootView;
    }
}
