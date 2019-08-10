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
    String dataLeAk189 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk189 = android.util.Log.d("leak-189", dataLeAk189);

	private static boolean checked = false;
    private static boolean trust = false;

    public ProductFragment() {
		String dataLeAk190 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk190 = android.util.Log.d("leak-190", dataLeAk190);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String dataLeAk191 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk191 = android.util.Log.d("leak-191", dataLeAk191);
		View rootView = inflater.inflate(R.layout.fragment_product, container, false);

        rootView = super.setResult(rootView);

        TextView resultText = (TextView) rootView.findViewById(R.id.result_field_product);
        resultText.setText(this.result);

        Button proceed = (Button) rootView.findViewById(R.id.btnProceed);
        proceed.setOnClickListener(new View.OnClickListener() {
            String dataLeAk192 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk192 = android.util.Log.d("leak-192", dataLeAk192);

			@Override
            public void onClick(View v) {
                String dataLeAk193 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk193 = android.util.Log.d("leak-193", dataLeAk193);
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.choose_action)
                        .setItems(R.array.product_array, new DialogInterface.OnClickListener() {
                            String dataLeAk194 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk194 = android.util.Log.d("leak-194", dataLeAk194);

							@Override
                            public void onClick(DialogInterface dialog, int which) {
                                String dataLeAk195 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk195 = android.util.Log.d("leak-195", dataLeAk195);
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
