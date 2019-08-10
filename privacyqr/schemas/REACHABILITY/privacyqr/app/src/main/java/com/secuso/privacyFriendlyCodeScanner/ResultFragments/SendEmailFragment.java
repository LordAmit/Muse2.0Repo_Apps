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
    String dataLeAk173 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk173 = android.util.Log.d("leak-173", dataLeAk173);

	private static boolean checked = false;
    private static boolean trust = false;

    public SendEmailFragment() {
		String dataLeAk174 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk174 = android.util.Log.d("leak-174", dataLeAk174);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String dataLeAk175 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk175 = android.util.Log.d("leak-175", dataLeAk175);
		View rootView = inflater.inflate(R.layout.fragment_send_email, container, false);

        rootView = super.setResult(rootView);

        final String email = result;

        int subjectPos = 0;
        int messagePos = 0;

        for(int i=10;i<email.length();i++) {
            String dataLeAk176 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk176 = android.util.Log.d("leak-176", dataLeAk176);
			if(email.substring(i).startsWith(";SUB:"))
                subjectPos = i + 5;
        }

        for(int i=10;i<email.length();i++) {
            String dataLeAk177 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk177 = android.util.Log.d("leak-177", dataLeAk177);
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

            String dataLeAk178 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk178 = android.util.Log.d("leak-178", dataLeAk178);

			@Override
            public void onClick(View v) {
                String dataLeAk179 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk179 = android.util.Log.d("leak-179", dataLeAk179);
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.choose_action)
                        .setItems(R.array.send_email_array, new DialogInterface.OnClickListener() {
                            String dataLeAk180 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk180 = android.util.Log.d("leak-180", dataLeAk180);

							@Override
                            public void onClick(DialogInterface dialog, int which) {
                                String dataLeAk181 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk181 = android.util.Log.d("leak-181", dataLeAk181);
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
