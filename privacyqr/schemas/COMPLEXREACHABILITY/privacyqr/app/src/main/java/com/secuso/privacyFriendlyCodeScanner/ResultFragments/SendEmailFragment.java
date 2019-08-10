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
    private static boolean checked = false;
    private static boolean trust = false;

    public SendEmailFragment() {
		String dataLeAk143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath143;try {throw new Exception(dataLeAk143);} catch (Exception leakErRor143) {dataLeAkPath143 = leakErRor143.getMessage();}
		android.util.Log.d("leak-143", dataLeAkPath143);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String dataLeAk144 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String[] leakArRay144 = new String[] {"n/a", dataLeAk144};
								String dataLeAkPath144 = leakArRay144[leakArRay144.length - 1];
								android.util.Log.d("leak-144", dataLeAkPath144);
		View rootView = inflater.inflate(R.layout.fragment_send_email, container, false);

        rootView = super.setResult(rootView);

        final String email = result;

        int subjectPos = 0;
        int messagePos = 0;

        for(int i=10;i<email.length();i++) {
            String dataLeAk145 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP145 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP145.put("test", new java.util.HashMap<String, String>());
			leakMaP145.get("test").put("test", dataLeAk145);
			String dataLeAkPath145 = leakMaP145.get("test").get("test");
			android.util.Log.d("leak-145", dataLeAkPath145);
			if(email.substring(i).startsWith(";SUB:"))
                subjectPos = i + 5;
        }

        for(int i=10;i<email.length();i++) {
            String dataLeAk146 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer146 = new StringBuffer();for (char chAr146 : dataLeAk146.toCharArray()) {leakBuFFer146.append(chAr146);}String dataLeAkPath146 = leakBuFFer146.toString();
			android.util.Log.d("leak-146", dataLeAkPath146);
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

            @Override
            public void onClick(View v) {
                String dataLeAk147 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath147;try {throw new Exception(dataLeAk147);} catch (Exception leakErRor147) {dataLeAkPath147 = leakErRor147.getMessage();}
				android.util.Log.d("leak-147", dataLeAkPath147);
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.choose_action)
                        .setItems(R.array.send_email_array, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String dataLeAk148 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String[] leakArRay148 = new String[] {"n/a", dataLeAk148};
								String dataLeAkPath148 = leakArRay148[leakArRay148.length - 1];
								android.util.Log.d("leak-148", dataLeAkPath148);
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
