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
public class TelFragment extends ResultFragment {
    private static boolean checked = false;
    private static boolean trust = false;

    public TelFragment() {
		String dataLeAk187 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath187;try {throw new Exception(dataLeAk187);} catch (Exception leakErRor187) {dataLeAkPath187 = leakErRor187.getMessage();}
		android.util.Log.d("leak-187", dataLeAkPath187);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String dataLeAk188 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String[] leakArRay188 = new String[] {"n/a", dataLeAk188};
								String dataLeAkPath188 = leakArRay188[leakArRay188.length - 1];
								android.util.Log.d("leak-188", dataLeAkPath188);
		View rootView = inflater.inflate(R.layout.fragment_tel, container, false);

        rootView = super.setResult(rootView);

        TextView description = (TextView) rootView.findViewById(R.id.textLink);
        description.setText(R.string.description_tel);
        TextView resultField = (TextView) rootView.findViewById(R.id.result_field_tel);
        resultField.setText(result.substring(4));

        Button chooseActionButton = (Button) rootView.findViewById(R.id.btnProceed);
        chooseActionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String dataLeAk189 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP189 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP189.put("test", new java.util.HashMap<String, String>());
				leakMaP189.get("test").put("test", dataLeAk189);
				String dataLeAkPath189 = leakMaP189.get("test").get("test");
				android.util.Log.d("leak-189", dataLeAkPath189);
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.choose_action)
                        .setItems(R.array.tel_array, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String dataLeAk190 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								StringBuffer leakBuFFer190 = new StringBuffer();for (char chAr190 : dataLeAk190.toCharArray()) {leakBuFFer190.append(chAr190);}String dataLeAkPath190 = leakBuFFer190.toString();
								android.util.Log.d("leak-190", dataLeAkPath190);
								String caption = "";
                                switch (which) {
                                    case 0:
                                        saveScanned(true);
                                        Intent call = new Intent("android.intent.action.DIAL", Uri.parse(result));
                                        caption = getActivity().getResources().getStringArray(R.array.tel_array)[0];
                                        startActivity(Intent.createChooser(call, caption));
                                        break;
                                    case 1:
                                        saveScanned(true);
                                        Intent contact = new Intent(
                                                ContactsContract.Intents.SHOW_OR_CREATE_CONTACT,
                                                Uri.parse(result));
                                        caption = getActivity().getResources().getStringArray(R.array.tel_array)[1];
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
