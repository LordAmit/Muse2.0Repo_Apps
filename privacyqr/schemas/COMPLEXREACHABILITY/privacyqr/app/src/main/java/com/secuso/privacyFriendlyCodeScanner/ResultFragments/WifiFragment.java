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
    private static boolean checked = false;
    private static boolean trust = false;

    public WifiFragment() {
		String dataLeAk174 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer174 = new StringBuffer();for (char chAr174 : dataLeAk174.toCharArray()) {leakBuFFer174.append(chAr174);}String dataLeAkPath174 = leakBuFFer174.toString();
		android.util.Log.d("leak-174", dataLeAkPath174);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String dataLeAk175 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String dataLeAkPath175;try {throw new Exception(dataLeAk175);} catch (Exception leakErRor175) {dataLeAkPath175 = leakErRor175.getMessage();}
								android.util.Log.d("leak-175", dataLeAkPath175);
		View rootView = inflater.inflate(R.layout.fragment_wifi, container, false);

        rootView = super.setResult(rootView);

        TextView resultText = (TextView) rootView.findViewById(R.id.result_field_wifi);
        resultText.setText(this.result);

        String[] content = result.substring(result.indexOf(":") + 1).split(";");
        int ssid_id = 0;
        int encryption_id = 0;
        int pw_id = 0;
        for(int i=0; i < content.length; i++) {
            String dataLeAk176 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay176 = new String[] {"n/a", dataLeAk176};
			String dataLeAkPath176 = leakArRay176[leakArRay176.length - 1];
			android.util.Log.d("leak-176", dataLeAkPath176);
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

            @Override
            public void onClick(View v) {
                String dataLeAk177 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP177 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP177.put("test", new java.util.HashMap<String, String>());
				leakMaP177.get("test").put("test", dataLeAk177);
				String dataLeAkPath177 = leakMaP177.get("test").get("test");
				android.util.Log.d("leak-177", dataLeAkPath177);
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.choose_action)
                        .setItems(R.array.wifi_array, new DialogInterface.OnClickListener() {
                            @Override
                            @SuppressWarnings("deprecation")
                            public void onClick(DialogInterface dialog, int which) {
                                String dataLeAk178 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								StringBuffer leakBuFFer178 = new StringBuffer();for (char chAr178 : dataLeAk178.toCharArray()) {leakBuFFer178.append(chAr178);}String dataLeAkPath178 = leakBuFFer178.toString();
								android.util.Log.d("leak-178", dataLeAkPath178);
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
