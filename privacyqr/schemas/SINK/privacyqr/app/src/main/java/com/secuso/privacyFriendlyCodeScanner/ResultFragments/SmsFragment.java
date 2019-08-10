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
    final String dataLeAk127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk121 = "";

	String dataLeAk120 = "";

	private static boolean checked = false;
    private static boolean trust = false;

    public SmsFragment() {
		dataLeAk120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-120-0", dataLeAk120);
		android.util.Log.d("leak-121-0", dataLeAk121);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dataLeAk121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-120-1", dataLeAk120);
		android.util.Log.d("leak-121-1", dataLeAk121);
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

            final String dataLeAk126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			String dataLeAk122 = "";

			@Override
            public void onClick(View v) {
                dataLeAk122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-125-0", dataLeAk125);
				android.util.Log.d("leak-122-0", dataLeAk122);
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.choose_action)
                        .setItems(R.array.sms_array, new DialogInterface.OnClickListener() {
                            String dataLeAk123 = "";

							@Override
                            public void onClick(DialogInterface dialog, int which) {
                                dataLeAk123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-127-0", dataLeAk127);
								android.util.Log.d("leak-126-0", dataLeAk126);
								android.util.Log.d("leak-123-0", dataLeAk123);
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
