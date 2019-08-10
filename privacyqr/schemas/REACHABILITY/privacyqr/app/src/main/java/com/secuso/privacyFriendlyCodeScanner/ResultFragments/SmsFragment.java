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
public class SmsFragment extends ResultFragment {
    String dataLeAk196 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk196 = android.util.Log.d("leak-196", dataLeAk196);

	private static boolean checked = false;
    private static boolean trust = false;

    public SmsFragment() {
		String dataLeAk197 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk197 = android.util.Log.d("leak-197", dataLeAk197);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String dataLeAk198 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk198 = android.util.Log.d("leak-198", dataLeAk198);
		View rootView = inflater.inflate(R.layout.fragment_sms, container, false);

        rootView = super.setResult(rootView);

        TextView numberField = (TextView) rootView.findViewById(R.id.textResultSms);
        TextView contentField = (TextView) rootView.findViewById(R.id.textContentSms);

        String content = result.substring(result.indexOf(":") + 1);
        final String number = content.substring(0, content.indexOf(":"));
        final String message = content.substring(content.indexOf(":") + 1);

        numberField.setText(number);
        contentField.setText(message);

        Button chooseActionButton = (Button) rootView.findViewById(R.id.btnProceed);
        chooseActionButton.setOnClickListener(new View.OnClickListener() {

            String dataLeAk199 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk199 = android.util.Log.d("leak-199", dataLeAk199);

			@Override
            public void onClick(View v) {
                String dataLeAk200 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk200 = android.util.Log.d("leak-200", dataLeAk200);
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.choose_action)
                        .setItems(R.array.sms_array, new DialogInterface.OnClickListener() {
                            String dataLeAk201 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk201 = android.util.Log.d("leak-201", dataLeAk201);

							@Override
                            public void onClick(DialogInterface dialog, int which) {
                                String dataLeAk202 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk202 = android.util.Log.d("leak-202", dataLeAk202);
								String caption = "";
                                switch (which) {
                                    case 0:
                                        Intent sms = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + number));
                                        sms.putExtra("address",  number);
                                        sms.putExtra("sms_body", message);
                                        caption = getActivity().getResources().getStringArray(R.array.sms_array)[0];
                                        startActivity(Intent.createChooser(sms, caption));
                                        saveScanned(true);
                                        break;
                                    case 1:
                                        Intent call = new Intent("android.intent.action.DIAL");
                                        call.setData(Uri.parse("tel:" + number));
                                        caption = getActivity().getResources().getStringArray(R.array.sms_array)[1];
                                        startActivity(Intent.createChooser(call, caption));
                                        saveScanned(true);
                                        break;
                                    case 2:
                                        Intent contact = new Intent(
                                                ContactsContract.Intents.SHOW_OR_CREATE_CONTACT,
                                                Uri.parse("tel:" + number));
                                        caption = getActivity().getResources().getStringArray(R.array.sms_array)[2];
                                        startActivity(Intent.createChooser(contact, caption));
                                        saveScanned(true);
                                        break;
                                    case 3:
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
