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
public class TextFragment extends ResultFragment {
    String dataLeAk216 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk216 = android.util.Log.d("leak-216", dataLeAk216);

	private static boolean checked = false;
    private static boolean trust = false;

    public TextFragment() {
		String dataLeAk217 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk217 = android.util.Log.d("leak-217", dataLeAk217);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String dataLeAk218 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk218 = android.util.Log.d("leak-218", dataLeAk218);
		View rootView = inflater.inflate(R.layout.fragment_text, container, false);

        rootView = super.setResult(rootView);

        TextView resultText = (TextView) rootView.findViewById(R.id.result_field_text);
        resultText.setText(this.result);

        Button chooseActionButton = (Button) rootView.findViewById(R.id.btnProceed);
        chooseActionButton.setOnClickListener(new View.OnClickListener() {

            String dataLeAk219 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk219 = android.util.Log.d("leak-219", dataLeAk219);

			@Override
            public void onClick(View v) {
                String dataLeAk220 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk220 = android.util.Log.d("leak-220", dataLeAk220);
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.choose_action)
                        .setItems(R.array.text_array, new DialogInterface.OnClickListener() {
                            String dataLeAk221 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk221 = android.util.Log.d("leak-221", dataLeAk221);

							@Override
                            public void onClick(DialogInterface dialog, int which) {
                                String dataLeAk222 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk222 = android.util.Log.d("leak-222", dataLeAk222);
								switch (which) {
                                    case 0:
                                        saveScanned(true);
                                        Uri uri = Uri.parse("http://www.google.com/#q="+result);
                                        Intent search = new Intent(Intent.ACTION_VIEW, uri);
                                        String caption = getActivity().getResources().getStringArray(R.array.text_array)[0];
                                        startActivity(Intent.createChooser(search, caption));
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
