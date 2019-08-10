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
    final String dataLeAk120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk114 = "";

	String dataLeAk113 = "";

	private static boolean checked = false;
    private static boolean trust = false;

    public ProductFragment() {
		dataLeAk113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-113-0", dataLeAk113);
		android.util.Log.d("leak-114-0", dataLeAk114);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dataLeAk114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-113-1", dataLeAk113);
		android.util.Log.d("leak-114-1", dataLeAk114);
		View rootView = inflater.inflate(R.layout.fragment_product, container, false);

        rootView = super.setResult(rootView);

        TextView resultText = (TextView) rootView.findViewById(R.id.result_field_product);
        resultText.setText(this.result);

        Button proceed = (Button) rootView.findViewById(R.id.btnProceed);
        proceed.setOnClickListener(new View.OnClickListener() {
            final String dataLeAk119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			String dataLeAk115 = "";

			@Override
            public void onClick(View v) {
                dataLeAk115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-118-0", dataLeAk118);
				android.util.Log.d("leak-115-0", dataLeAk115);
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.choose_action)
                        .setItems(R.array.product_array, new DialogInterface.OnClickListener() {
                            String dataLeAk116 = "";

							@Override
                            public void onClick(DialogInterface dialog, int which) {
                                dataLeAk116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-120-0", dataLeAk120);
								android.util.Log.d("leak-119-0", dataLeAk119);
								android.util.Log.d("leak-116-0", dataLeAk116);
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
