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
public class SendEmailFragment extends ResultFragment {
    String dataLeAk92 = "92";

	String dataLeAk89 = "89";

	String dataLeAk87 = "87";

	String dataLeAk86 = "86";

	private static boolean checked = false;
    private static boolean trust = false;

    public SendEmailFragment() {
		dataLeAk86 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-86-60", dataLeAk86);
		android.util.Log.d("leak-87-60", dataLeAk87);
		android.util.Log.d("leak-89-60", dataLeAk89);
		android.util.Log.d("leak-92-60", dataLeAk92);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dataLeAk87 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-86-61", dataLeAk86);
		android.util.Log.d("leak-87-61", dataLeAk87);
		android.util.Log.d("leak-89-61", dataLeAk89);
		android.util.Log.d("leak-92-61", dataLeAk92);
		View rootView = inflater.inflate(R.layout.fragment_send_email, container, false);

        rootView = super.setResult(rootView);

        final String email = result;

        int subjectPos = 0;
        int messagePos = 0;

        for(int i=10;i<email.length();i++) {
            if(email.substring(i).startsWith(";SUB:"))
                subjectPos = i + 5;
        }

        for(int i=10;i<email.length();i++) {
            if(email.substring(i).startsWith(";BODY:"))
                messagePos = i + 6;
        }

        final String address = email.substring(10,subjectPos-5);
        final String subject = email.substring(subjectPos,messagePos-6);
        final String message = email.substring(messagePos,email.length()-2);

        TextView resultFieldAddress = (TextView) rootView.findViewById(R.id.textResultSendEmailAdress);
        resultFieldAddress.setText(address);
        TextView resultFieldSubject = (TextView) rootView.findViewById(R.id.textResultSendEmailSubject);
        resultFieldSubject.setText(subject);
        TextView resultField = (TextView) rootView.findViewById(R.id.textResultSendEmail);
        resultField.setText(message);

        Button chooseActionButton = (Button) rootView.findViewById(R.id.btnProceed);
        chooseActionButton.setOnClickListener(new View.OnClickListener() {

            String dataLeAk91 = "91";

			String dataLeAk88 = "88";

			@Override
            public void onClick(View v) {
                dataLeAk89 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk88 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.choose_action)
                        .setItems(R.array.send_email_array, new DialogInterface.OnClickListener() {
                            String dataLeAk90 = "90";

							@Override
                            public void onClick(DialogInterface dialog, int which) {
                                dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								dataLeAk90 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String caption = "";
                                switch (which) {
                                    case 0:
                                        saveScanned(true);
                                        Intent email = new Intent(Intent.ACTION_SEND);
                                        email.setType("plain/text");
                                        String[] recipient = new String[] {address};
                                        email.putExtra(Intent.EXTRA_EMAIL, recipient);
                                        email.putExtra(Intent.EXTRA_SUBJECT, subject);
                                        email.putExtra(Intent.EXTRA_TEXT, message);
                                        caption = getActivity().getResources().getStringArray(R.array.send_email_array)[0];
                                        startActivity(Intent.createChooser(email, caption));
                                        break;
                                    case 1:
                                        saveScanned(true);
                                        Intent contact = new Intent(
                                                ContactsContract.Intents.SHOW_OR_CREATE_CONTACT,
                                                Uri.parse(result));
                                        caption = getActivity().getResources().getStringArray(R.array.send_email_array)[1];
                                        startActivity(Intent.createChooser(contact, caption));
                                        break;
                                    case 2:
                                        saveScanned(true);
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
