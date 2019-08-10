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
    final String dataLeAk113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk107 = "";

	String dataLeAk106 = "";

	private static boolean checked = false;
    private static boolean trust = false;

    public EmailFragment() {
		dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-106-0", dataLeAk106);
		android.util.Log.d("leak-107-0", dataLeAk107);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dataLeAk107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-106-1", dataLeAk106);
		android.util.Log.d("leak-107-1", dataLeAk107);
		View rootView = inflater.inflate(R.layout.fragment_email, container, false);

        rootView = super.setResult(rootView);

        TextView resultField = (TextView) rootView.findViewById(R.id.result_field_email);
        resultField.setText(result.subSequence(7, result.length()));

        Button chooseActionButton = (Button) rootView.findViewById(R.id.btnProceed);
        chooseActionButton.setOnClickListener(new View.OnClickListener() {

            final String dataLeAk112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			String dataLeAk108 = "";

			@Override
            public void onClick(View v) {
                dataLeAk108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-111-0", dataLeAk111);
				android.util.Log.d("leak-108-0", dataLeAk108);
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.choose_action)
                        .setItems(R.array.email_array, new DialogInterface.OnClickListener() {
                            String dataLeAk109 = "";

							@Override
                            public void onClick(DialogInterface dialog, int which) {
                                dataLeAk109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-113-0", dataLeAk113);
								android.util.Log.d("leak-112-0", dataLeAk112);
								android.util.Log.d("leak-109-0", dataLeAk109);
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
