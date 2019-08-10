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
    private static boolean checked = false;
    private static boolean trust = false;

    public ContactFragment() {
		String dataLeAk135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath135;try {throw new Exception(dataLeAk135);} catch (Exception leakErRor135) {dataLeAkPath135 = leakErRor135.getMessage();}
		android.util.Log.d("leak-135", dataLeAkPath135);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String dataLeAk136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String[] leakArRay136 = new String[] {"n/a", dataLeAk136};
								String dataLeAkPath136 = leakArRay136[leakArRay136.length - 1];
								android.util.Log.d("leak-136", dataLeAkPath136);
		View rootView = inflater.inflate(R.layout.fragment_contact, container, false);

        rootView = super.setResult(rootView);

        TextView resultTextContact = (TextView) rootView.findViewById(R.id.result_text_contact);

        Pattern pattern = Pattern.compile("((\\n|;|:)(FN:|N:)[0-9a-zA-Z-\\säöüÄÖÜß,]*(\\n|;))");

        Matcher m = pattern.matcher(result);

        String name = "";

        if(m.find())  {
            String dataLeAk137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP137 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP137.put("test", new java.util.HashMap<String, String>());
			leakMaP137.get("test").put("test", dataLeAk137);
			String dataLeAkPath137 = leakMaP137.get("test").get("test");
			android.util.Log.d("leak-137", dataLeAkPath137);
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

            @Override
            public void onClick(View v) {
                String dataLeAk138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer138 = new StringBuffer();for (char chAr138 : dataLeAk138.toCharArray()) {leakBuFFer138.append(chAr138);}String dataLeAkPath138 = leakBuFFer138.toString();
				android.util.Log.d("leak-138", dataLeAkPath138);
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.choose_action)
                        .setItems(R.array.vcard_array, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String dataLeAk139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String dataLeAkPath139;try {throw new Exception(dataLeAk139);} catch (Exception leakErRor139) {dataLeAkPath139 = leakErRor139.getMessage();}
								android.util.Log.d("leak-139", dataLeAkPath139);
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
        String dataLeAk140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay140 = new String[] {"n/a", dataLeAk140};
		String dataLeAkPath140 = leakArRay140[leakArRay140.length - 1];
		android.util.Log.d("leak-140", dataLeAkPath140);
		try {
            String dataLeAk141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP141 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP141.put("test", new java.util.HashMap<String, String>());
			leakMaP141.get("test").put("test", dataLeAk141);
			String dataLeAkPath141 = leakMaP141.get("test").get("test");
			android.util.Log.d("leak-141", dataLeAkPath141);
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
            String dataLeAk142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer142 = new StringBuffer();for (char chAr142 : dataLeAk142.toCharArray()) {leakBuFFer142.append(chAr142);}String dataLeAkPath142 = leakBuFFer142.toString();
			android.util.Log.d("leak-142", dataLeAkPath142);
			// TODO Auto-generated catch block
            return null;
        }
    }

}
