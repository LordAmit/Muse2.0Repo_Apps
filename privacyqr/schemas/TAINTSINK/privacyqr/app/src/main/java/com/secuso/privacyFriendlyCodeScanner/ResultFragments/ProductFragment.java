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
    String dataLeAk106 = "106";

	String dataLeAk103 = "103";

	String dataLeAk101 = "101";

	String dataLeAk100 = "100";

	private static boolean checked = false;
    private static boolean trust = false;

    public ProductFragment() {
		dataLeAk100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-100-64", dataLeAk100);
		android.util.Log.d("leak-101-64", dataLeAk101);
		android.util.Log.d("leak-103-64", dataLeAk103);
		android.util.Log.d("leak-106-64", dataLeAk106);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dataLeAk101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-100-65", dataLeAk100);
		android.util.Log.d("leak-101-65", dataLeAk101);
		android.util.Log.d("leak-103-65", dataLeAk103);
		android.util.Log.d("leak-106-65", dataLeAk106);
		View rootView = inflater.inflate(R.layout.fragment_product, container, false);

        rootView = super.setResult(rootView);

        TextView resultText = (TextView) rootView.findViewById(R.id.result_field_product);
        resultText.setText(this.result);

        Button proceed = (Button) rootView.findViewById(R.id.btnProceed);
        proceed.setOnClickListener(new View.OnClickListener() {
            String dataLeAk105 = "105";

			String dataLeAk102 = "102";

			@Override
            public void onClick(View v) {
                dataLeAk103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.choose_action)
                        .setItems(R.array.product_array, new DialogInterface.OnClickListener() {
                            String dataLeAk104 = "104";

							@Override
                            public void onClick(DialogInterface dialog, int which) {
                                dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								dataLeAk105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								dataLeAk104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
