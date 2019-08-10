package com.secuso.privacyFriendlyCodeScanner.GeneralFragments;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.secuso.privacyFriendlyCodeScanner.MainActivity;
import com.secuso.privacyFriendlyCodeScanner.R;
import com.secuso.privacyFriendlyCodeScanner.ResultFragments.ContactFragment;
import com.secuso.privacyFriendlyCodeScanner.ResultFragments.EmailFragment;
import com.secuso.privacyFriendlyCodeScanner.ResultFragments.ProductFragment;
import com.secuso.privacyFriendlyCodeScanner.ResultFragments.SendEmailFragment;
import com.secuso.privacyFriendlyCodeScanner.ResultFragments.SmsFragment;
import com.secuso.privacyFriendlyCodeScanner.ResultFragments.TelFragment;
import com.secuso.privacyFriendlyCodeScanner.ResultFragments.UrlFragment;
import com.secuso.privacyFriendlyCodeScanner.ResultFragments.WifiFragment;
import com.secuso.privacyFriendlyCodeScanner.Utility.FragmentGenerator;
import com.secuso.privacyFriendlyCodeScanner.Utility.History;
import com.secuso.privacyFriendlyCodeScanner.Utility.HistoryEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Philipp on 12.09.2015.
 */
public class HistoryFragment extends Fragment {

    String dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk74 = android.util.Log.d("leak-74", dataLeAk74);

	private ArrayList<HistoryEntry> historyEntriesF = new ArrayList<HistoryEntry>();
    private List<HistoryViewElement> historyViewElements = new ArrayList<HistoryViewElement>();
    private View rootView;
    private LinearLayout previousScanned;
    private LayoutInflater inflater;
    private HistoryViewElement clickedElement;


    public HistoryFragment() {
		String dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk75 = android.util.Log.d("leak-75", dataLeAk75);
        // Empty constructor required for fragment subclasses
    }

    public class HistoryViewElement extends View {

        String dataLeAk76 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk76 = android.util.Log.d("leak-76", dataLeAk76);

		public int id;
        public String content;
        public boolean trust;
        public View view;

        public HistoryViewElement(Context context) {
            super(context);
            // TODO Auto-generated constructor stub
			String dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk77 = android.util.Log.d("leak-77", dataLeAk77);
        }

        public void setArgs(int id, String content, boolean trust, View view) {
            String dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk78 = android.util.Log.d("leak-78", dataLeAk78);
			this.id = id;
            this.content = content;
            this.trust = trust;
            this.view = view;
        }

        public void setView(View newView){
            String dataLeAk79 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk79 = android.util.Log.d("leak-79", dataLeAk79);
			this.view = newView;
        }

        @Override
        public void setId(int id){
            String dataLeAk80 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk80 = android.util.Log.d("leak-80", dataLeAk80);
			this.id = id;
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String dataLeAk81 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk81 = android.util.Log.d("leak-81", dataLeAk81);
		this.inflater = inflater;
        rootView = inflater.inflate(R.layout.fragment_history, container, false);

        History.printHistory(getActivity());

        previousScanned = (LinearLayout)rootView.findViewById(R.id.previousScanned);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(rootView.getContext());
        boolean checked = sharedPref.getBoolean("bool_history", true);

        historyEntriesF = History.getHistory(getActivity());

        if(historyEntriesF == null && checked){
			String dataLeAk82 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk82 = android.util.Log.d("leak-82", dataLeAk82);
            //there is nothing to load
        }
        else if(!checked){
            String dataLeAk83 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk83 = android.util.Log.d("leak-83", dataLeAk83);
			previousScanned.removeAllViews();
            Toast.makeText(getActivity(), getResources().getString(R.string.history_disabled), Toast.LENGTH_SHORT).show();
        }
        else if(checked) {
            String dataLeAk84 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk84 = android.util.Log.d("leak-84", dataLeAk84);
			previousScanned.removeAllViews();
            this.createViews();
            loadPreviousScanned(rootView, previousScanned);
        }

        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk85 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk85 = android.util.Log.d("leak-85", dataLeAk85);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.history, menu);
		String dataLeAk86 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk86 = android.util.Log.d("leak-86", dataLeAk86);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public void createViews() {
        String dataLeAk87 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk87 = android.util.Log.d("leak-87", dataLeAk87);
		for(HistoryEntry entry: historyEntriesF) {
            String dataLeAk88 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk88 = android.util.Log.d("leak-88", dataLeAk88);
			View newView = inflater.inflate(R.layout.row_previous, previousScanned, false);
            HistoryViewElement newElement = new HistoryViewElement(rootView.getContext());
            newElement.setArgs(entry.id, entry.content, entry.trust, newView);
            historyViewElements.add(newElement);
        }
    }

    public void refresh() {
        String dataLeAk89 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk89 = android.util.Log.d("leak-89", dataLeAk89);
		((MainActivity)getActivity()).selectItem(1,true);
    }

    private void remove(int id) {
        String dataLeAk90 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk90 = android.util.Log.d("leak-90", dataLeAk90);
		historyEntriesF.remove(id);
        History.saveHistory(getActivity(), historyEntriesF, false);
        refresh();
    }

    public void loadPreviousScanned(final View rootView, final LinearLayout previousScanned) {
        String dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk91 = android.util.Log.d("leak-91", dataLeAk91);
		for(final HistoryViewElement element: historyViewElements) {

            String dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk92 = android.util.Log.d("leak-92", dataLeAk92);
			final View newView = element.view;

            ImageView icon = (ImageView) newView.findViewById(R.id.icon);
            TextView firstLine = (TextView) newView.findViewById(R.id.result_field_text);
            TextView secondLine = (TextView) newView.findViewById(R.id.secondLine);
            String seconLineText = "";

            Fragment type= FragmentGenerator.getFragmentFromContent(element.content);

            if(type instanceof WifiFragment){
                String dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk93 = android.util.Log.d("leak-93", dataLeAk93);
				icon.setImageResource(R.drawable.ic_action_network_wifi);
                String[] content = element.content.substring(element.content.indexOf(":") + 1).split(";");
                int ssid_id = 0;
                for(int i=0; i < content.length; i++) {
                    String dataLeAk94 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk94 = android.util.Log.d("leak-94", dataLeAk94);
					if(content[i].startsWith("S:")) ssid_id = i;
                }
                firstLine.setText(R.string.title_activity_result_wifi);
                seconLineText = content[ssid_id].substring(2);
                secondLine.setText(seconLineText);
            }
            else if(type instanceof ContactFragment){
                String dataLeAk95 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk95 = android.util.Log.d("leak-95", dataLeAk95);
				icon.setImageResource(R.drawable.ic_action_person);

                Pattern pattern = Pattern.compile("([\\n|;|:](FN:|N:)[0-9a-zA-Z-\\säöüÄÖÜß,]*[\\n|;])");
                Matcher m = pattern.matcher(element.content);
                String name = "";
                if(m.find())  {
                    String dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk96 = android.util.Log.d("leak-96", dataLeAk96);
					name = m.group(1).substring(1);

                    if(name.startsWith("N:")) {
                        String dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk97 = android.util.Log.d("leak-97", dataLeAk97);
						seconLineText = name.substring(2).replace(';', ' ');
                        secondLine.setText(seconLineText);
                    }
                    else if(name.startsWith("FN:")) {
                        String dataLeAk98 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk98 = android.util.Log.d("leak-98", dataLeAk98);
						seconLineText = name.substring(3).replace(';', ' ');
                        secondLine.setText(seconLineText);
                    }
                }

                firstLine.setText(R.string.title_activity_result_contact);
            }
            else if(type instanceof TelFragment) {
                String dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk99 = android.util.Log.d("leak-99", dataLeAk99);
				icon.setImageResource(R.drawable.ic_action_call);
                firstLine.setText(R.string.title_activity_result_tel);
                seconLineText = element.content.substring(4);
                secondLine.setText(seconLineText);
            }
            else if(type instanceof SendEmailFragment) {
                String dataLeAk100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk100 = android.util.Log.d("leak-100", dataLeAk100);
				icon.setImageResource(R.drawable.ic_action_new_email);
                Pattern r = Pattern.compile("MATMSG:TO:(.+?);SUB:");
                Matcher m = r.matcher(element.content);
                if(m.find()) {
                    String dataLeAk101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk101 = android.util.Log.d("leak-101", dataLeAk101);
					seconLineText = m.group(1);
                    secondLine.setText(seconLineText);
                }
                firstLine.setText(R.string.title_activity_result_send_email);
            }
            else if(type instanceof EmailFragment){
                String dataLeAk102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk102 = android.util.Log.d("leak-102", dataLeAk102);
				icon.setImageResource(R.drawable.ic_action_email);
                firstLine.setText(R.string.title_activity_result_email);
                seconLineText = element.content.subSequence(7, element.content.length()).toString();
                secondLine.setText(seconLineText);
            }
            else if(type instanceof SmsFragment) {
                String dataLeAk103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk103 = android.util.Log.d("leak-103", dataLeAk103);
				icon.setImageResource(R.drawable.ic_action_chat);
                String content = element.content.substring(element.content.indexOf(":") + 1);
                String address = content.substring(0, content.indexOf(":"));
                seconLineText = address;
                secondLine.setText(seconLineText);
                firstLine.setText(R.string.title_activity_result_sms);
            }
            else if(type instanceof UrlFragment) {
                String dataLeAk104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk104 = android.util.Log.d("leak-104", dataLeAk104);
				if (element.content.contains("maps.google") | element.content.contains("geo:"))
                    icon.setImageResource(R.drawable.ic_action_place);
                else
                    icon.setImageResource(R.drawable.ic_action_web_site);
                firstLine.setText(R.string.title_activity_result_url);
                seconLineText = element.content;
                secondLine.setText(seconLineText);
            }
            else if(type instanceof ProductFragment) {
                String dataLeAk105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk105 = android.util.Log.d("leak-105", dataLeAk105);
				icon.setImageResource(R.drawable.ic_action_about);
                seconLineText = element.content;
                secondLine.setText(seconLineText);
                firstLine.setText(R.string.title_activity_result_product);
            }
            else {
                String dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk106 = android.util.Log.d("leak-106", dataLeAk106);
				icon.setImageResource(R.drawable.ic_action_view_as_list);
                seconLineText = element.content;
                secondLine.setText(seconLineText);
                firstLine.setText(R.string.title_activity_result_text);
            }

            newView.setOnClickListener(new View.OnClickListener() {

                String dataLeAk107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk107 = android.util.Log.d("leak-107", dataLeAk107);

				@Override
                public void onClick(View v) {
                    String dataLeAk108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk108 = android.util.Log.d("leak-108", dataLeAk108);
					Fragment frag = FragmentGenerator.getFragmentFromContent(element.content);
                    Bundle bundle = frag.getArguments();
                    bundle.putBoolean("trust", element.trust);
                    bundle.putBoolean("history", true);
                    frag.setArguments(bundle);
                    ((MainActivity)getActivity()).switchToFragment(frag, false);
                }
            });

            final String clipboardText = seconLineText;

            newView.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk109 = android.util.Log.d("leak-109", dataLeAk109);

				@Override
                public boolean onLongClick(View v) {

                    String dataLeAk110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk110 = android.util.Log.d("leak-110", dataLeAk110);
					newView.setBackgroundColor(Color.parseColor("#ff33b5e5"));

                    AlertDialog.Builder deleteDialog = new AlertDialog.Builder(rootView.getContext());

                    deleteDialog.setTitle("")
                            .setItems(R.array.history_array, new DialogInterface.OnClickListener() {
                                String dataLeAk111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk111 = android.util.Log.d("leak-111", dataLeAk111);

								public void onClick(DialogInterface dialog, int which) {
                                    String dataLeAk112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk112 = android.util.Log.d("leak-112", dataLeAk112);
									switch (which) {
                                        case 0:
                                            ClipboardManager clipboard = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                                            clipboard.setText(clipboardText);
                                            Toast.makeText(getActivity(), getResources().getString(R.string.copied_to_clipboard), Toast.LENGTH_SHORT).show();
                                            newView.setBackgroundColor(Color.WHITE);
                                            break;
                                        case 1:
                                            remove(element.id);
                                            refresh();
                                            Toast.makeText(getActivity(), getResources().getString(R.string.element_removed), Toast.LENGTH_SHORT).show();
                                            newView.setBackgroundColor(Color.WHITE);
                                            break;
                                        default:
                                            newView.setBackgroundColor(Color.WHITE);
                                            break;
                                    }
                                }
                            });

                    deleteDialog.setOnCancelListener(new DialogInterface.OnCancelListener () {
                        String dataLeAk113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk113 = android.util.Log.d("leak-113", dataLeAk113);

						@Override
                        public void onCancel(DialogInterface dialog) {
                            String dataLeAk114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk114 = android.util.Log.d("leak-114", dataLeAk114);
							newView.setBackgroundColor(Color.WHITE);
                        }
                    });
                    deleteDialog.show();
                    return true;
                }
            });


            previousScanned.addView(newView);
        }
    }
}
