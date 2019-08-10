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
    String dataLeAk203 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk203 = android.util.Log.d("leak-203", dataLeAk203);

	private static boolean checked = false;
    private static boolean trust = false;

    public UrlFragment() {
		String dataLeAk204 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk204 = android.util.Log.d("leak-204", dataLeAk204);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String dataLeAk205 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk205 = android.util.Log.d("leak-205", dataLeAk205);
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

            String dataLeAk206 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk206 = android.util.Log.d("leak-206", dataLeAk206);

			@Override
            public void onClick(View v) {

                String dataLeAk207 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk207 = android.util.Log.d("leak-207", dataLeAk207);
				if(knowDomain.isChecked()) {
                    String dataLeAk208 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk208 = android.util.Log.d("leak-208", dataLeAk208);
					checked = true;
                }
                else {
                    String dataLeAk209 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk209 = android.util.Log.d("leak-209", dataLeAk209);
					checked = false;
                }
            }
        });
        chooseActionButton.setOnClickListener(new View.OnClickListener() {

            String dataLeAk210 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk210 = android.util.Log.d("leak-210", dataLeAk210);

			@Override
            public void onClick(View v) {
                String dataLeAk211 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk211 = android.util.Log.d("leak-211", dataLeAk211);
				if(!checked) {
                    String dataLeAk212 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk212 = android.util.Log.d("leak-212", dataLeAk212);
					Toast.makeText(getActivity(), R.string.conform_url, Toast.LENGTH_SHORT).show();
                } else {
                    String dataLeAk213 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk213 = android.util.Log.d("leak-213", dataLeAk213);
					AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle(R.string.choose_action)
                            .setItems(R.array.url_array, new DialogInterface.OnClickListener() {
                                String dataLeAk214 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk214 = android.util.Log.d("leak-214", dataLeAk214);

								@Override
                                public void onClick(DialogInterface dialog, int which) {
                                    String dataLeAk215 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk215 = android.util.Log.d("leak-215", dataLeAk215);
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
