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
    final String dataLeAk143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk137 = "";

	String dataLeAk136 = "";

	private static boolean checked = false;
    private static boolean trust = false;

    public TextFragment() {
		dataLeAk136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-136-0", dataLeAk136);
		android.util.Log.d("leak-137-0", dataLeAk137);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dataLeAk137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-136-1", dataLeAk136);
		android.util.Log.d("leak-137-1", dataLeAk137);
		View rootView = inflater.inflate(R.layout.fragment_text, container, false);

        rootView = super.setResult(rootView);

        TextView resultText = (TextView) rootView.findViewById(R.id.result_field_text);
        resultText.setText(this.result);

        Button chooseActionButton = (Button) rootView.findViewById(R.id.btnProceed);
        chooseActionButton.setOnClickListener(new View.OnClickListener() {

            final String dataLeAk142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			String dataLeAk138 = "";

			@Override
            public void onClick(View v) {
                dataLeAk138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-141-0", dataLeAk141);
				android.util.Log.d("leak-138-0", dataLeAk138);
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.choose_action)
                        .setItems(R.array.text_array, new DialogInterface.OnClickListener() {
                            String dataLeAk139 = "";

							@Override
                            public void onClick(DialogInterface dialog, int which) {
                                dataLeAk139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-143-0", dataLeAk143);
								android.util.Log.d("leak-142-0", dataLeAk142);
								android.util.Log.d("leak-139-0", dataLeAk139);
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
