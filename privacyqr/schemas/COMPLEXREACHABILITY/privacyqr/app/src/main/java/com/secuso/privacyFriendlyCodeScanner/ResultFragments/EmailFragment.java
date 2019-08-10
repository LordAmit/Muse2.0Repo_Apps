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
    private static boolean checked = false;
    private static boolean trust = false;

    public EmailFragment() {
		String dataLeAk149 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP149 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP149.put("test", new java.util.HashMap<String, String>());
		leakMaP149.get("test").put("test", dataLeAk149);
		String dataLeAkPath149 = leakMaP149.get("test").get("test");
		android.util.Log.d("leak-149", dataLeAkPath149);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String dataLeAk150 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								StringBuffer leakBuFFer150 = new StringBuffer();for (char chAr150 : dataLeAk150.toCharArray()) {leakBuFFer150.append(chAr150);}String dataLeAkPath150 = leakBuFFer150.toString();
								android.util.Log.d("leak-150", dataLeAkPath150);
		View rootView = inflater.inflate(R.layout.fragment_email, container, false);

        rootView = super.setResult(rootView);

        TextView resultField = (TextView) rootView.findViewById(R.id.result_field_email);
        resultField.setText(result.subSequence(7, result.length()));

        Button chooseActionButton = (Button) rootView.findViewById(R.id.btnProceed);
        chooseActionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String dataLeAk151 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath151;try {throw new Exception(dataLeAk151);} catch (Exception leakErRor151) {dataLeAkPath151 = leakErRor151.getMessage();}
				android.util.Log.d("leak-151", dataLeAkPath151);
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.choose_action)
                        .setItems(R.array.email_array, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String dataLeAk152 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String[] leakArRay152 = new String[] {"n/a", dataLeAk152};
								String dataLeAkPath152 = leakArRay152[leakArRay152.length - 1];
								android.util.Log.d("leak-152", dataLeAkPath152);
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
