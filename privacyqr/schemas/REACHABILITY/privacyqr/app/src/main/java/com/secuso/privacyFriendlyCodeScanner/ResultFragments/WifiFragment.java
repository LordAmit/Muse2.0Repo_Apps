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
    String dataLeAk223 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk223 = android.util.Log.d("leak-223", dataLeAk223);

	private static boolean checked = false;
    private static boolean trust = false;

    public WifiFragment() {
		String dataLeAk224 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk224 = android.util.Log.d("leak-224", dataLeAk224);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String dataLeAk225 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk225 = android.util.Log.d("leak-225", dataLeAk225);
		View rootView = inflater.inflate(R.layout.fragment_wifi, container, false);

        rootView = super.setResult(rootView);

        TextView resultText = (TextView) rootView.findViewById(R.id.result_field_wifi);
        resultText.setText(this.result);

        String[] content = result.substring(result.indexOf(":") + 1).split(";");
        int ssid_id = 0;
        int encryption_id = 0;
        int pw_id = 0;
        for(int i=0; i < content.length; i++) {
            String dataLeAk226 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk226 = android.util.Log.d("leak-226", dataLeAk226);
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

            String dataLeAk227 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk227 = android.util.Log.d("leak-227", dataLeAk227);

			@Override
            public void onClick(View v) {
                String dataLeAk228 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk228 = android.util.Log.d("leak-228", dataLeAk228);
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.choose_action)
                        .setItems(R.array.wifi_array, new DialogInterface.OnClickListener() {
                            String dataLeAk229 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk229 = android.util.Log.d("leak-229", dataLeAk229);

							@Override
                            @SuppressWarnings("deprecation")
                            public void onClick(DialogInterface dialog, int which) {
                                String dataLeAk230 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk230 = android.util.Log.d("leak-230", dataLeAk230);
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
