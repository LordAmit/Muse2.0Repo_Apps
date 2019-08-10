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
    String dataLeAk85 = "85";

	String dataLeAk82 = "82";

	String dataLeAk80 = "80";

	String dataLeAk79 = "79";

	private static boolean checked = false;
    private static boolean trust = false;

    public ContactFragment() {
		dataLeAk79 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-79-57", dataLeAk79);
		android.util.Log.d("leak-80-57", dataLeAk80);
		android.util.Log.d("leak-82-57", dataLeAk82);
		android.util.Log.d("leak-85-57", dataLeAk85);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dataLeAk80 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-79-58", dataLeAk79);
		android.util.Log.d("leak-80-58", dataLeAk80);
		android.util.Log.d("leak-82-58", dataLeAk82);
		android.util.Log.d("leak-85-58", dataLeAk85);
		View rootView = inflater.inflate(R.layout.fragment_contact, container, false);

        rootView = super.setResult(rootView);

        TextView resultTextContact = (TextView) rootView.findViewById(R.id.result_text_contact);

        Pattern pattern = Pattern.compile("((\\n|;|:)(FN:|N:)[0-9a-zA-Z-\\säöüÄÖÜß,]*(\\n|;))");

        Matcher m = pattern.matcher(result);

        String name = "";

        if(m.find())  {
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

            String dataLeAk84 = "84";

			String dataLeAk81 = "81";

			@Override
            public void onClick(View v) {
                dataLeAk82 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk81 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.choose_action)
                        .setItems(R.array.vcard_array, new DialogInterface.OnClickListener() {
                            String dataLeAk83 = "83";

							@Override
                            public void onClick(DialogInterface dialog, int which) {
                                dataLeAk85 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								dataLeAk84 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								dataLeAk83 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
        try {
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
            // TODO Auto-generated catch block
            return null;
        }
		android.util.Log.d("leak-79-59", dataLeAk79);
		android.util.Log.d("leak-80-59", dataLeAk80);
		android.util.Log.d("leak-82-59", dataLeAk82);
		android.util.Log.d("leak-85-59", dataLeAk85);
    }

}
