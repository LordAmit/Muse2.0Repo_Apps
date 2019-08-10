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
    private static boolean checked = false;
    private static boolean trust = false;

    public SmsFragment() {
		String dataLeAk157 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP157 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP157.put("test", new java.util.HashMap<String, String>());
		leakMaP157.get("test").put("test", dataLeAk157);
		String dataLeAkPath157 = leakMaP157.get("test").get("test");
		android.util.Log.d("leak-157", dataLeAkPath157);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String dataLeAk158 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								StringBuffer leakBuFFer158 = new StringBuffer();for (char chAr158 : dataLeAk158.toCharArray()) {leakBuFFer158.append(chAr158);}String dataLeAkPath158 = leakBuFFer158.toString();
								android.util.Log.d("leak-158", dataLeAkPath158);
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

            @Override
            public void onClick(View v) {
                String dataLeAk159 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath159;try {throw new Exception(dataLeAk159);} catch (Exception leakErRor159) {dataLeAkPath159 = leakErRor159.getMessage();}
				android.util.Log.d("leak-159", dataLeAkPath159);
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.choose_action)
                        .setItems(R.array.sms_array, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String dataLeAk160 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String[] leakArRay160 = new String[] {"n/a", dataLeAk160};
								String dataLeAkPath160 = leakArRay160[leakArRay160.length - 1];
								android.util.Log.d("leak-160", dataLeAkPath160);
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
