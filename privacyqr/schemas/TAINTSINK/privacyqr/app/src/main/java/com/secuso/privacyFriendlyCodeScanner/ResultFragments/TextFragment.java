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
    String dataLeAk129 = "129";

	String dataLeAk126 = "126";

	String dataLeAk124 = "124";

	String dataLeAk123 = "123";

	private static boolean checked = false;
    private static boolean trust = false;

    public TextFragment() {
		dataLeAk123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-123-70", dataLeAk123);
		android.util.Log.d("leak-124-70", dataLeAk124);
		android.util.Log.d("leak-126-70", dataLeAk126);
		android.util.Log.d("leak-129-70", dataLeAk129);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dataLeAk124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-123-71", dataLeAk123);
		android.util.Log.d("leak-124-71", dataLeAk124);
		android.util.Log.d("leak-126-71", dataLeAk126);
		android.util.Log.d("leak-129-71", dataLeAk129);
		View rootView = inflater.inflate(R.layout.fragment_text, container, false);

        rootView = super.setResult(rootView);

        TextView resultText = (TextView) rootView.findViewById(R.id.result_field_text);
        resultText.setText(this.result);

        Button chooseActionButton = (Button) rootView.findViewById(R.id.btnProceed);
        chooseActionButton.setOnClickListener(new View.OnClickListener() {

            String dataLeAk128 = "128";

			String dataLeAk125 = "125";

			@Override
            public void onClick(View v) {
                dataLeAk126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.choose_action)
                        .setItems(R.array.text_array, new DialogInterface.OnClickListener() {
                            String dataLeAk127 = "127";

							@Override
                            public void onClick(DialogInterface dialog, int which) {
                                dataLeAk129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								dataLeAk128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								dataLeAk127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
