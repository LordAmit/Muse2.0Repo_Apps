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
    final String dataLeAk164 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk162 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk158 = "";

	String dataLeAk157 = "";

	private static boolean checked = false;
    private static boolean trust = false;

    public TelFragment() {
		dataLeAk157 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-157-0", dataLeAk157);
		android.util.Log.d("leak-158-0", dataLeAk158);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dataLeAk158 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-157-1", dataLeAk157);
		android.util.Log.d("leak-158-1", dataLeAk158);
		View rootView = inflater.inflate(R.layout.fragment_tel, container, false);

        rootView = super.setResult(rootView);

        TextView description = (TextView) rootView.findViewById(R.id.textLink);
        description.setText(R.string.description_tel);
        TextView resultField = (TextView) rootView.findViewById(R.id.result_field_tel);
        resultField.setText(result.substring(4));

        Button chooseActionButton = (Button) rootView.findViewById(R.id.btnProceed);
        chooseActionButton.setOnClickListener(new View.OnClickListener() {

            final String dataLeAk163 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			String dataLeAk159 = "";

			@Override
            public void onClick(View v) {
                dataLeAk159 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-162-0", dataLeAk162);
				android.util.Log.d("leak-159-0", dataLeAk159);
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.choose_action)
                        .setItems(R.array.tel_array, new DialogInterface.OnClickListener() {
                            String dataLeAk160 = "";

							@Override
                            public void onClick(DialogInterface dialog, int which) {
                                dataLeAk160 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-164-0", dataLeAk164);
								android.util.Log.d("leak-163-0", dataLeAk163);
								android.util.Log.d("leak-160-0", dataLeAk160);
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
