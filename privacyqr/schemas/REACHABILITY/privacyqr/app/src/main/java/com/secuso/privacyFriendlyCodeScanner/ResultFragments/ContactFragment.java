package com.secuso.privacyFriendlyCodeScanner.ResultFragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.secuso.privacyFriendlyCodeScanner.MainActivity;
import com.secuso.privacyFriendlyCodeScanner.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A placeholder fragment containing a simple view.
 */
public class ContactFragment extends ResultFragment {
    String dataLeAk162 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk162 = android.util.Log.d("leak-162", dataLeAk162);

	private static boolean checked = false;
    private static boolean trust = false;

    public ContactFragment() {
		String dataLeAk163 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk163 = android.util.Log.d("leak-163", dataLeAk163);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String dataLeAk164 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk164 = android.util.Log.d("leak-164", dataLeAk164);
		View rootView = inflater.inflate(R.layout.fragment_contact, container, false);

        rootView = super.setResult(rootView);

        TextView resultTextContact = (TextView) rootView.findViewById(R.id.result_text_contact);

        Pattern pattern = Pattern.compile("((\\n|;|:)(FN:|N:)[0-9a-zA-Z-\\säöüÄÖÜß,]*(\\n|;))");

        Matcher m = pattern.matcher(result);

        String name = "";

        if(m.find())  {
            String dataLeAk165 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk165 = android.util.Log.d("leak-165", dataLeAk165);
			name = m.group(1).substring(1);

            if(name.startsWith("N:"))
                resultTextContact.setText("Name: " + name.substring(2).replace(';', ' '));
            else if(name.startsWith("FN:"))
                resultTextContact.setText("Name: " + name.substring(3).replace(';', ' '));
            else
                resultTextContact.setText(R.string.noname);
        }
        Button chooseActionButton = (Button) rootView.findViewById(R.id.btnProceed);
        chooseActionButton.setOnClickListener(new View.OnClickListener() {

            String dataLeAk166 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk166 = android.util.Log.d("leak-166", dataLeAk166);

			@Override
            public void onClick(View v) {
                String dataLeAk167 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk167 = android.util.Log.d("leak-167", dataLeAk167);
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.choose_action)
                        .setItems(R.array.vcard_array, new DialogInterface.OnClickListener() {
                            String dataLeAk168 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk168 = android.util.Log.d("leak-168", dataLeAk168);

							@Override
                            public void onClick(DialogInterface dialog, int which) {
                                String dataLeAk169 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk169 = android.util.Log.d("leak-169", dataLeAk169);
								switch (which) {
                                    case 0:
                                        saveScanned(true);
                                        Uri uri = createVCard();
                                        Intent contact = new Intent();
                                        contact.setAction(Intent.ACTION_VIEW);
                                        contact.setType("text/x-vcard");
                                        contact.setData(uri);
                                        String caption = getActivity().getResources().getStringArray(R.array.vcard_array)[0];
                                        startActivity(Intent.createChooser(contact, caption));
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

    private Uri createVCard() {
        String dataLeAk170 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk170 = android.util.Log.d("leak-170", dataLeAk170);
		try {
            String dataLeAk171 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk171 = android.util.Log.d("leak-171", dataLeAk171);
			File sdcard = getActivity().getFilesDir();
            File file = new File(sdcard,"vCard.vcf");

            /*BufferedWriter out = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(file, false)));*/

            FileOutputStream out = getActivity().openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

            out.write(result.getBytes());
            //out.flush();
            out.close();

            Log.e("TESTEST", file.getPath());

            Uri uri = FileProvider.getUriForFile(getActivity(), "com.secuso.privacyFriendlyCodeScanner", file);
            getActivity().grantUriPermission("com.google.android.contacts", uri, Intent.FLAG_GRANT_READ_URI_PERMISSION);
            getActivity().grantUriPermission("com.android.contacts", uri, Intent.FLAG_GRANT_READ_URI_PERMISSION);

            return uri;
        } catch (IOException e) {
            String dataLeAk172 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk172 = android.util.Log.d("leak-172", dataLeAk172);
			// TODO Auto-generated catch block
            return null;
        }
    }

}
