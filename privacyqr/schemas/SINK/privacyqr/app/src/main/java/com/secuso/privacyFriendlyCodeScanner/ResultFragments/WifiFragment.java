package com.secuso.privacyFriendlyCodeScanner.ResultFragments;

import android.app.AlertDialog;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
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
public class WifiFragment extends ResultFragment {
    final String dataLeAk150 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk148 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk144 = "";

	String dataLeAk143 = "";

	private static boolean checked = false;
    private static boolean trust = false;

    public WifiFragment() {
		dataLeAk143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-143-0", dataLeAk143);
		android.util.Log.d("leak-144-0", dataLeAk144);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dataLeAk144 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-143-1", dataLeAk143);
		android.util.Log.d("leak-144-1", dataLeAk144);
		View rootView = inflater.inflate(R.layout.fragment_wifi, container, false);

        rootView = super.setResult(rootView);

        TextView resultText = (TextView) rootView.findViewById(R.id.result_field_wifi);
        resultText.setText(this.result);

        String[] content = result.substring(result.indexOf(":") + 1).split(";");
        int ssid_id = 0;
        int encryption_id = 0;
        int pw_id = 0;
        for(int i=0; i < content.length; i++) {
            if(content[i].startsWith("S:")) ssid_id = i;
            if(content[i].startsWith("T:")) encryption_id = i;
            if(content[i].startsWith("P:")) pw_id = i;
        }

        final String ssid = content[ssid_id].substring(2);
        String encryption = content[encryption_id].substring(2);
        final String pw = content[pw_id].substring(2);

        TextView resultField = (TextView) rootView.findViewById(R.id.result_field_wifi);
        TextView resultFieldEncryption = (TextView) rootView.findViewById(R.id.result_field_wifi_encryption);
        TextView resultFieldPassword = (TextView) rootView.findViewById(R.id.result_field_wifi_pw);
        resultField.setText("SSID: " + ssid);
        resultFieldEncryption.setText(getString(R.string.encryption) + ": " + encryption);
        resultFieldPassword.setText("PW: " + pw);

        Button chooseActionButton = (Button) rootView.findViewById(R.id.btnProceed);
        chooseActionButton.setOnClickListener(new View.OnClickListener() {

            final String dataLeAk149 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			String dataLeAk145 = "";

			@Override
            public void onClick(View v) {
                dataLeAk145 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-148-0", dataLeAk148);
				android.util.Log.d("leak-145-0", dataLeAk145);
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.choose_action)
                        .setItems(R.array.wifi_array, new DialogInterface.OnClickListener() {
                            String dataLeAk146 = "";

							@Override
                            @SuppressWarnings("deprecation")
                            public void onClick(DialogInterface dialog, int which) {
                                dataLeAk146 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-150-0", dataLeAk150);
								android.util.Log.d("leak-149-0", dataLeAk149);
								android.util.Log.d("leak-146-0", dataLeAk146);
								switch (which) {
                                    case 0:
                                        saveScanned(true);
                                        ClipboardManager clipboard = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                                        clipboard.setText(pw);
                                        saveScanned(true);
                                        break;
                                    case 1:
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
