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
    String dataLeAk182 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk182 = android.util.Log.d("leak-182", dataLeAk182);

	private static boolean checked = false;
    private static boolean trust = false;

    public EmailFragment() {
		String dataLeAk183 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk183 = android.util.Log.d("leak-183", dataLeAk183);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String dataLeAk184 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk184 = android.util.Log.d("leak-184", dataLeAk184);
		View rootView = inflater.inflate(R.layout.fragment_email, container, false);

        rootView = super.setResult(rootView);

        TextView resultField = (TextView) rootView.findViewById(R.id.result_field_email);
        resultField.setText(result.subSequence(7, result.length()));

        Button chooseActionButton = (Button) rootView.findViewById(R.id.btnProceed);
        chooseActionButton.setOnClickListener(new View.OnClickListener() {

            String dataLeAk185 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk185 = android.util.Log.d("leak-185", dataLeAk185);

			@Override
            public void onClick(View v) {
                String dataLeAk186 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk186 = android.util.Log.d("leak-186", dataLeAk186);
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.choose_action)
                        .setItems(R.array.email_array, new DialogInterface.OnClickListener() {
                            String dataLeAk187 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk187 = android.util.Log.d("leak-187", dataLeAk187);

							@Override
                            public void onClick(DialogInterface dialog, int which) {
                                String dataLeAk188 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk188 = android.util.Log.d("leak-188", dataLeAk188);
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
