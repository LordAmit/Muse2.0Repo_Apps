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
    final String dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk95 = "";

	String dataLeAk92 = "";

	String dataLeAk91 = "";

	private static boolean checked = false;
    private static boolean trust = false;

    public ContactFragment() {
		dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-91-0", dataLeAk91);
		android.util.Log.d("leak-92-0", dataLeAk92);
		android.util.Log.d("leak-95-0", dataLeAk95);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-91-1", dataLeAk91);
		android.util.Log.d("leak-92-1", dataLeAk92);
		android.util.Log.d("leak-95-1", dataLeAk95);
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

            final String dataLeAk98 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			String dataLeAk93 = "";

			@Override
            public void onClick(View v) {
                dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-97-0", dataLeAk97);
				android.util.Log.d("leak-93-0", dataLeAk93);
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.choose_action)
                        .setItems(R.array.vcard_array, new DialogInterface.OnClickListener() {
                            String dataLeAk94 = "";

							@Override
                            public void onClick(DialogInterface dialog, int which) {
                                dataLeAk94 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-99-0", dataLeAk99);
								android.util.Log.d("leak-98-0", dataLeAk98);
								android.util.Log.d("leak-94-0", dataLeAk94);
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
        dataLeAk95 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-91-2", dataLeAk91);
		android.util.Log.d("leak-92-2", dataLeAk92);
		android.util.Log.d("leak-95-2", dataLeAk95);
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
    }

}
