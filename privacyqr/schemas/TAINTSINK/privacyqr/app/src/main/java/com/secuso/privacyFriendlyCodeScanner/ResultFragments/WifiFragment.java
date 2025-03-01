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
    String dataLeAk136 = "136";

	String dataLeAk133 = "133";

	String dataLeAk131 = "131";

	String dataLeAk130 = "130";

	private static boolean checked = false;
    private static boolean trust = false;

    public WifiFragment() {
		dataLeAk130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-130-72", dataLeAk130);
		android.util.Log.d("leak-131-72", dataLeAk131);
		android.util.Log.d("leak-133-72", dataLeAk133);
		android.util.Log.d("leak-136-72", dataLeAk136);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dataLeAk131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-130-73", dataLeAk130);
		android.util.Log.d("leak-131-73", dataLeAk131);
		android.util.Log.d("leak-133-73", dataLeAk133);
		android.util.Log.d("leak-136-73", dataLeAk136);
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

            String dataLeAk135 = "135";

			String dataLeAk132 = "132";

			@Override
            public void onClick(View v) {
                dataLeAk133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.choose_action)
                        .setItems(R.array.wifi_array, new DialogInterface.OnClickListener() {
                            String dataLeAk134 = "134";

							@Override
                            @SuppressWarnings("deprecation")
                            public void onClick(DialogInterface dialog, int which) {
                                dataLeAk136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								dataLeAk135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								dataLeAk134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
