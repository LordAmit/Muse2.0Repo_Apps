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
    String dataLeAk122 = "122";

	String dataLeAk119 = "119";

	String dataLeAk117 = "117";

	String dataLeAk115 = "115";

	String dataLeAk114 = "114";

	private static boolean checked = false;
    private static boolean trust = false;

    public UrlFragment() {
		dataLeAk114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-114-68", dataLeAk114);
		android.util.Log.d("leak-115-68", dataLeAk115);
		android.util.Log.d("leak-117-68", dataLeAk117);
		android.util.Log.d("leak-119-68", dataLeAk119);
		android.util.Log.d("leak-122-68", dataLeAk122);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dataLeAk115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-114-69", dataLeAk114);
		android.util.Log.d("leak-115-69", dataLeAk115);
		android.util.Log.d("leak-117-69", dataLeAk117);
		android.util.Log.d("leak-119-69", dataLeAk119);
		android.util.Log.d("leak-122-69", dataLeAk122);
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

            String dataLeAk116 = "116";

			@Override
            public void onClick(View v) {

                dataLeAk117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				if(knowDomain.isChecked()) {
                    checked = true;
                }
                else {
                    checked = false;
                }
            }
        });
        chooseActionButton.setOnClickListener(new View.OnClickListener() {

            String dataLeAk121 = "121";

			String dataLeAk118 = "118";

			@Override
            public void onClick(View v) {
                dataLeAk119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				if(!checked) {
                    Toast.makeText(getActivity(), R.string.conform_url, Toast.LENGTH_SHORT).show();
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle(R.string.choose_action)
                            .setItems(R.array.url_array, new DialogInterface.OnClickListener() {
                                String dataLeAk120 = "120";

								@Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dataLeAk122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									dataLeAk121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									dataLeAk120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
