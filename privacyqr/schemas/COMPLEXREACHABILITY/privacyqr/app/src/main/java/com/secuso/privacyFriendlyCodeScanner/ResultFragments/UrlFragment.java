package com.secuso.privacyFriendlyCodeScanner.ResultFragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.secuso.privacyFriendlyCodeScanner.MainActivity;
import com.secuso.privacyFriendlyCodeScanner.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A placeholder fragment containing a simple view.
 */
public class UrlFragment extends ResultFragment {
    private static boolean checked = false;
    private static boolean trust = false;

    public UrlFragment() {
		String dataLeAk161 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP161 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP161.put("test", new java.util.HashMap<String, String>());
		leakMaP161.get("test").put("test", dataLeAk161);
		String dataLeAkPath161 = leakMaP161.get("test").get("test");
		android.util.Log.d("leak-161", dataLeAkPath161);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String dataLeAk162 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								StringBuffer leakBuFFer162 = new StringBuffer();for (char chAr162 : dataLeAk162.toCharArray()) {leakBuFFer162.append(chAr162);}String dataLeAkPath162 = leakBuFFer162.toString();
								android.util.Log.d("leak-162", dataLeAkPath162);
		View rootView = inflater.inflate(R.layout.fragment_url, container, false);

        Button chooseActionButton = (Button) rootView.findViewById(R.id.btnProceed);
        chooseActionButton.setText(R.string.choose_action_url);
        Button abortActionButton = (Button) rootView.findViewById(R.id.btnCancel);
        abortActionButton.setText(R.string.abort_action_url);

        rootView = super.setResult(rootView);

        TextView resultText = (TextView) rootView.findViewById(R.id.textDomain);
        TextView furtherInfo = (TextView) rootView.findViewById(R.id.textLink);
        furtherInfo.setMovementMethod(LinkMovementMethod.getInstance());

        result = result.replaceAll("\n", "");
        String domain = result;

        domain = domain.split("\n")[0];
        if(!domain.endsWith("/")) domain = domain + '/';

        Pattern pattern = Pattern.compile("([0-9a-zA-ZäöüÄÖÜß-]*.(co.uk|com.de|de.com|co.at|[a-z]{2,})/)");

        Matcher m = pattern.matcher(domain);
        if(m.find()) domain = m.group(1);

        if(domain.endsWith("/")) domain = domain.substring(0, domain.length()-1);

        int start = result.indexOf(domain);
        int end = start + domain.length();

        Spannable WordtoSpan = new SpannableString(result);
        WordtoSpan.setSpan(new ForegroundColorSpan(Color.BLACK), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        WordtoSpan.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        resultText.setText(WordtoSpan);

        checked = trust = getArguments().getBoolean("trust", false);

        final CheckBox knowDomain = (CheckBox) rootView.findViewById(R.id.checkBoxKnowRisks);

        // wenn bereits vertraut wurde, checkbox setzen
        if(trust)
            knowDomain.setChecked(true);

        knowDomain.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String dataLeAk163 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath163;try {throw new Exception(dataLeAk163);} catch (Exception leakErRor163) {dataLeAkPath163 = leakErRor163.getMessage();}
				android.util.Log.d("leak-163", dataLeAkPath163);
				if(knowDomain.isChecked()) {
                    String dataLeAk164 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay164 = new String[] {"n/a", dataLeAk164};
					String dataLeAkPath164 = leakArRay164[leakArRay164.length - 1];
					android.util.Log.d("leak-164", dataLeAkPath164);
					checked = true;
                }
                else {
                    String dataLeAk165 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP165 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP165.put("test", new java.util.HashMap<String, String>());
					leakMaP165.get("test").put("test", dataLeAk165);
					String dataLeAkPath165 = leakMaP165.get("test").get("test");
					android.util.Log.d("leak-165", dataLeAkPath165);
					checked = false;
                }
            }
        });
        chooseActionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String dataLeAk166 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer166 = new StringBuffer();for (char chAr166 : dataLeAk166.toCharArray()) {leakBuFFer166.append(chAr166);}String dataLeAkPath166 = leakBuFFer166.toString();
				android.util.Log.d("leak-166", dataLeAkPath166);
				if(!checked) {
                    String dataLeAk167 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath167;try {throw new Exception(dataLeAk167);} catch (Exception leakErRor167) {dataLeAkPath167 = leakErRor167.getMessage();}
					android.util.Log.d("leak-167", dataLeAkPath167);
					Toast.makeText(getActivity(), R.string.conform_url, Toast.LENGTH_SHORT).show();
                } else {
                    String dataLeAk168 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay168 = new String[] {"n/a", dataLeAk168};
					String dataLeAkPath168 = leakArRay168[leakArRay168.length - 1];
					android.util.Log.d("leak-168", dataLeAkPath168);
					AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle(R.string.choose_action)
                            .setItems(R.array.url_array, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    String dataLeAk169 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP169 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
									leakMaP169.put("test", new java.util.HashMap<String, String>());
									leakMaP169.get("test").put("test", dataLeAk169);
									String dataLeAkPath169 = leakMaP169.get("test").get("test");
									android.util.Log.d("leak-169", dataLeAkPath169);
									String caption = "";
                                    switch (which) {
                                        case 0:
                                            saveScanned(true);
                                            if(!result.startsWith("http")) result = "http://" + result;
                                            Intent url = new Intent(Intent.ACTION_VIEW, Uri.parse(result));
                                            caption = getActivity().getResources().getStringArray(R.array.url_array)[0];
                                            startActivity(Intent.createChooser(url, caption));
                                            break;
                                        /*case 1:
                                            saveScanned(true);
                                            Intent i = new Intent(Intent.ACTION_INSERT, Browser.BOOKMARKS_URIBrowser.);
                                            startActivity(i);
                                            break;*/
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
            }
        });

        return rootView;
    }
}
