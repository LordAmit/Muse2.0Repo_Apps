package com.secuso.privacyFriendlyCodeScanner.ResultFragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
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
public class ProductFragment extends ResultFragment {
    private static boolean checked = false;
    private static boolean trust = false;

    public ProductFragment() {
		String dataLeAk153 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP153 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP153.put("test", new java.util.HashMap<String, String>());
		leakMaP153.get("test").put("test", dataLeAk153);
		String dataLeAkPath153 = leakMaP153.get("test").get("test");
		android.util.Log.d("leak-153", dataLeAkPath153);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String dataLeAk154 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								StringBuffer leakBuFFer154 = new StringBuffer();for (char chAr154 : dataLeAk154.toCharArray()) {leakBuFFer154.append(chAr154);}String dataLeAkPath154 = leakBuFFer154.toString();
								android.util.Log.d("leak-154", dataLeAkPath154);
		View rootView = inflater.inflate(R.layout.fragment_product, container, false);

        rootView = super.setResult(rootView);

        TextView resultText = (TextView) rootView.findViewById(R.id.result_field_product);
        resultText.setText(this.result);

        Button proceed = (Button) rootView.findViewById(R.id.btnProceed);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dataLeAk155 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath155;try {throw new Exception(dataLeAk155);} catch (Exception leakErRor155) {dataLeAkPath155 = leakErRor155.getMessage();}
				android.util.Log.d("leak-155", dataLeAkPath155);
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.choose_action)
                        .setItems(R.array.product_array, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String dataLeAk156 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String[] leakArRay156 = new String[] {"n/a", dataLeAk156};
								String dataLeAkPath156 = leakArRay156[leakArRay156.length - 1];
								android.util.Log.d("leak-156", dataLeAkPath156);
								switch (which) {
                                    case 0:
                                        saveScanned(true);

                                        String url = "http://www.google.com/search?q=" + result;
                                        Intent intent = new Intent(Intent.ACTION_VIEW);
                                        intent.setData(Uri.parse(url));

                                        String caption = getActivity().getResources().getStringArray(R.array.product_array)[0];
                                        startActivity(Intent.createChooser(intent, caption));
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
