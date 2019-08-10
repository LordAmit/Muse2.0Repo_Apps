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

    final String dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk76 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk67 = "";

	String dataLeAk66 = "";

	String dataLeAk65 = "";

	String dataLeAk64 = "";

	String dataLeAk63 = "";

	String dataLeAk62 = "";

	String dataLeAk61 = "";

	String dataLeAk60 = "";

	String dataLeAk58 = "";

	String dataLeAk56 = "";

	String dataLeAk54 = "";

	String dataLeAk52 = "";

	private ArrayList<HistoryEntry> historyEntriesF = new ArrayList<HistoryEntry>();
    private List<HistoryViewElement> historyViewElements = new ArrayList<HistoryViewElement>();
    private View rootView;
    private LinearLayout previousScanned;
    private LayoutInflater inflater;
    private HistoryViewElement clickedElement;


    public HistoryFragment() {
		dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        // Empty constructor required for fragment subclasses
		android.util.Log.d("leak-52-0", dataLeAk52);
		android.util.Log.d("leak-54-0", dataLeAk54);
		android.util.Log.d("leak-56-0", dataLeAk56);
		android.util.Log.d("leak-58-0", dataLeAk58);
		android.util.Log.d("leak-60-0", dataLeAk60);
		android.util.Log.d("leak-61-0", dataLeAk61);
		android.util.Log.d("leak-62-0", dataLeAk62);
		android.util.Log.d("leak-63-0", dataLeAk63);
		android.util.Log.d("leak-64-0", dataLeAk64);
		android.util.Log.d("leak-65-0", dataLeAk65);
		android.util.Log.d("leak-66-0", dataLeAk66);
		android.util.Log.d("leak-67-0", dataLeAk67);
    }

    public class HistoryViewElement extends View {

        String dataLeAk59 = "";

		String dataLeAk57 = "";

		String dataLeAk55 = "";

		String dataLeAk53 = "";

		public int id;
        public String content;
        public boolean trust;
        public View view;

        public HistoryViewElement(Context context) {
            super(context);
            // TODO Auto-generated constructor stub
			dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-52-1", dataLeAk52);
			android.util.Log.d("leak-54-1", dataLeAk54);
			android.util.Log.d("leak-56-1", dataLeAk56);
			android.util.Log.d("leak-58-1", dataLeAk58);
			android.util.Log.d("leak-60-1", dataLeAk60);
			android.util.Log.d("leak-61-1", dataLeAk61);
			android.util.Log.d("leak-62-1", dataLeAk62);
			android.util.Log.d("leak-63-1", dataLeAk63);
			android.util.Log.d("leak-64-1", dataLeAk64);
			android.util.Log.d("leak-65-1", dataLeAk65);
			android.util.Log.d("leak-66-1", dataLeAk66);
			android.util.Log.d("leak-67-1", dataLeAk67);
			android.util.Log.d("leak-53-0", dataLeAk53);
			android.util.Log.d("leak-55-0", dataLeAk55);
			android.util.Log.d("leak-57-0", dataLeAk57);
			android.util.Log.d("leak-59-0", dataLeAk59);
        }

        public void setArgs(int id, String content, boolean trust, View view) {
            dataLeAk56 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-52-2", dataLeAk52);
			android.util.Log.d("leak-54-2", dataLeAk54);
			android.util.Log.d("leak-56-2", dataLeAk56);
			android.util.Log.d("leak-58-2", dataLeAk58);
			android.util.Log.d("leak-60-2", dataLeAk60);
			android.util.Log.d("leak-61-2", dataLeAk61);
			android.util.Log.d("leak-62-2", dataLeAk62);
			android.util.Log.d("leak-63-2", dataLeAk63);
			android.util.Log.d("leak-64-2", dataLeAk64);
			android.util.Log.d("leak-65-2", dataLeAk65);
			android.util.Log.d("leak-66-2", dataLeAk66);
			android.util.Log.d("leak-67-2", dataLeAk67);
			android.util.Log.d("leak-53-1", dataLeAk53);
			android.util.Log.d("leak-55-1", dataLeAk55);
			android.util.Log.d("leak-57-1", dataLeAk57);
			android.util.Log.d("leak-59-1", dataLeAk59);
			this.id = id;
            this.content = content;
            this.trust = trust;
            this.view = view;
        }

        public void setView(View newView){
            dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-52-3", dataLeAk52);
			android.util.Log.d("leak-54-3", dataLeAk54);
			android.util.Log.d("leak-56-3", dataLeAk56);
			android.util.Log.d("leak-58-3", dataLeAk58);
			android.util.Log.d("leak-60-3", dataLeAk60);
			android.util.Log.d("leak-61-3", dataLeAk61);
			android.util.Log.d("leak-62-3", dataLeAk62);
			android.util.Log.d("leak-63-3", dataLeAk63);
			android.util.Log.d("leak-64-3", dataLeAk64);
			android.util.Log.d("leak-65-3", dataLeAk65);
			android.util.Log.d("leak-66-3", dataLeAk66);
			android.util.Log.d("leak-67-3", dataLeAk67);
			android.util.Log.d("leak-53-2", dataLeAk53);
			android.util.Log.d("leak-55-2", dataLeAk55);
			android.util.Log.d("leak-57-2", dataLeAk57);
			android.util.Log.d("leak-59-2", dataLeAk59);
			this.view = newView;
        }

        @Override
        public void setId(int id){
            dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-52-4", dataLeAk52);
			android.util.Log.d("leak-54-4", dataLeAk54);
			android.util.Log.d("leak-56-4", dataLeAk56);
			android.util.Log.d("leak-58-4", dataLeAk58);
			android.util.Log.d("leak-60-4", dataLeAk60);
			android.util.Log.d("leak-61-4", dataLeAk61);
			android.util.Log.d("leak-62-4", dataLeAk62);
			android.util.Log.d("leak-63-4", dataLeAk63);
			android.util.Log.d("leak-64-4", dataLeAk64);
			android.util.Log.d("leak-65-4", dataLeAk65);
			android.util.Log.d("leak-66-4", dataLeAk66);
			android.util.Log.d("leak-67-4", dataLeAk67);
			android.util.Log.d("leak-53-3", dataLeAk53);
			android.util.Log.d("leak-55-3", dataLeAk55);
			android.util.Log.d("leak-57-3", dataLeAk57);
			android.util.Log.d("leak-59-3", dataLeAk59);
			this.id = id;
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-5", dataLeAk52);
		android.util.Log.d("leak-54-5", dataLeAk54);
		android.util.Log.d("leak-56-5", dataLeAk56);
		android.util.Log.d("leak-58-5", dataLeAk58);
		android.util.Log.d("leak-60-5", dataLeAk60);
		android.util.Log.d("leak-61-5", dataLeAk61);
		android.util.Log.d("leak-62-5", dataLeAk62);
		android.util.Log.d("leak-63-5", dataLeAk63);
		android.util.Log.d("leak-64-5", dataLeAk64);
		android.util.Log.d("leak-65-5", dataLeAk65);
		android.util.Log.d("leak-66-5", dataLeAk66);
		android.util.Log.d("leak-67-5", dataLeAk67);
		this.inflater = inflater;
        rootView = inflater.inflate(R.layout.fragment_history, container, false);

        History.printHistory(getActivity());

        previousScanned = (LinearLayout)rootView.findViewById(R.id.previousScanned);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(rootView.getContext());
        boolean checked = sharedPref.getBoolean("bool_history", true);

        historyEntriesF = History.getHistory(getActivity());

        if(historyEntriesF == null && checked){
            //there is nothing to load
        }
        else if(!checked){
            previousScanned.removeAllViews();
            Toast.makeText(getActivity(), getResources().getString(R.string.history_disabled), Toast.LENGTH_SHORT).show();
        }
        else if(checked) {
            previousScanned.removeAllViews();
            this.createViews();
            loadPreviousScanned(rootView, previousScanned);
        }

        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-6", dataLeAk52);
		android.util.Log.d("leak-54-6", dataLeAk54);
		android.util.Log.d("leak-56-6", dataLeAk56);
		android.util.Log.d("leak-58-6", dataLeAk58);
		android.util.Log.d("leak-60-6", dataLeAk60);
		android.util.Log.d("leak-61-6", dataLeAk61);
		android.util.Log.d("leak-62-6", dataLeAk62);
		android.util.Log.d("leak-63-6", dataLeAk63);
		android.util.Log.d("leak-64-6", dataLeAk64);
		android.util.Log.d("leak-65-6", dataLeAk65);
		android.util.Log.d("leak-66-6", dataLeAk66);
		android.util.Log.d("leak-67-6", dataLeAk67);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.history, menu);
		dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-7", dataLeAk52);
		android.util.Log.d("leak-54-7", dataLeAk54);
		android.util.Log.d("leak-56-7", dataLeAk56);
		android.util.Log.d("leak-58-7", dataLeAk58);
		android.util.Log.d("leak-60-7", dataLeAk60);
		android.util.Log.d("leak-61-7", dataLeAk61);
		android.util.Log.d("leak-62-7", dataLeAk62);
		android.util.Log.d("leak-63-7", dataLeAk63);
		android.util.Log.d("leak-64-7", dataLeAk64);
		android.util.Log.d("leak-65-7", dataLeAk65);
		android.util.Log.d("leak-66-7", dataLeAk66);
		android.util.Log.d("leak-67-7", dataLeAk67);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public void createViews() {
        dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-8", dataLeAk52);
		android.util.Log.d("leak-54-8", dataLeAk54);
		android.util.Log.d("leak-56-8", dataLeAk56);
		android.util.Log.d("leak-58-8", dataLeAk58);
		android.util.Log.d("leak-60-8", dataLeAk60);
		android.util.Log.d("leak-61-8", dataLeAk61);
		android.util.Log.d("leak-62-8", dataLeAk62);
		android.util.Log.d("leak-63-8", dataLeAk63);
		android.util.Log.d("leak-64-8", dataLeAk64);
		android.util.Log.d("leak-65-8", dataLeAk65);
		android.util.Log.d("leak-66-8", dataLeAk66);
		android.util.Log.d("leak-67-8", dataLeAk67);
		for(HistoryEntry entry: historyEntriesF) {
            View newView = inflater.inflate(R.layout.row_previous, previousScanned, false);
            HistoryViewElement newElement = new HistoryViewElement(rootView.getContext());
            newElement.setArgs(entry.id, entry.content, entry.trust, newView);
            historyViewElements.add(newElement);
        }
    }

    public void refresh() {
        dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-9", dataLeAk52);
		android.util.Log.d("leak-54-9", dataLeAk54);
		android.util.Log.d("leak-56-9", dataLeAk56);
		android.util.Log.d("leak-58-9", dataLeAk58);
		android.util.Log.d("leak-60-9", dataLeAk60);
		android.util.Log.d("leak-61-9", dataLeAk61);
		android.util.Log.d("leak-62-9", dataLeAk62);
		android.util.Log.d("leak-63-9", dataLeAk63);
		android.util.Log.d("leak-64-9", dataLeAk64);
		android.util.Log.d("leak-65-9", dataLeAk65);
		android.util.Log.d("leak-66-9", dataLeAk66);
		android.util.Log.d("leak-67-9", dataLeAk67);
		((MainActivity)getActivity()).selectItem(1,true);
    }

    private void remove(int id) {
        dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-10", dataLeAk52);
		android.util.Log.d("leak-54-10", dataLeAk54);
		android.util.Log.d("leak-56-10", dataLeAk56);
		android.util.Log.d("leak-58-10", dataLeAk58);
		android.util.Log.d("leak-60-10", dataLeAk60);
		android.util.Log.d("leak-61-10", dataLeAk61);
		android.util.Log.d("leak-62-10", dataLeAk62);
		android.util.Log.d("leak-63-10", dataLeAk63);
		android.util.Log.d("leak-64-10", dataLeAk64);
		android.util.Log.d("leak-65-10", dataLeAk65);
		android.util.Log.d("leak-66-10", dataLeAk66);
		android.util.Log.d("leak-67-10", dataLeAk67);
		historyEntriesF.remove(id);
        History.saveHistory(getActivity(), historyEntriesF, false);
        refresh();
    }

    public void loadPreviousScanned(final View rootView, final LinearLayout previousScanned) {
        dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-11", dataLeAk52);
		android.util.Log.d("leak-54-11", dataLeAk54);
		android.util.Log.d("leak-56-11", dataLeAk56);
		android.util.Log.d("leak-58-11", dataLeAk58);
		android.util.Log.d("leak-60-11", dataLeAk60);
		android.util.Log.d("leak-61-11", dataLeAk61);
		android.util.Log.d("leak-62-11", dataLeAk62);
		android.util.Log.d("leak-63-11", dataLeAk63);
		android.util.Log.d("leak-64-11", dataLeAk64);
		android.util.Log.d("leak-65-11", dataLeAk65);
		android.util.Log.d("leak-66-11", dataLeAk66);
		android.util.Log.d("leak-67-11", dataLeAk67);
		for(final HistoryViewElement element: historyViewElements) {

            final View newView = element.view;

            ImageView icon = (ImageView) newView.findViewById(R.id.icon);
            TextView firstLine = (TextView) newView.findViewById(R.id.result_field_text);
            TextView secondLine = (TextView) newView.findViewById(R.id.secondLine);
            String seconLineText = "";

            Fragment type= FragmentGenerator.getFragmentFromContent(element.content);

            if(type instanceof WifiFragment){
                icon.setImageResource(R.drawable.ic_action_network_wifi);
                String[] content = element.content.substring(element.content.indexOf(":") + 1).split(";");
                int ssid_id = 0;
                for(int i=0; i < content.length; i++) {
                    if(content[i].startsWith("S:")) ssid_id = i;
                }
                firstLine.setText(R.string.title_activity_result_wifi);
                seconLineText = content[ssid_id].substring(2);
                secondLine.setText(seconLineText);
            }
            else if(type instanceof ContactFragment){
                icon.setImageResource(R.drawable.ic_action_person);

                Pattern pattern = Pattern.compile("([\\n|;|:](FN:|N:)[0-9a-zA-Z-\\säöüÄÖÜß,]*[\\n|;])");
                Matcher m = pattern.matcher(element.content);
                String name = "";
                if(m.find())  {
                    name = m.group(1).substring(1);

                    if(name.startsWith("N:")) {
                        seconLineText = name.substring(2).replace(';', ' ');
                        secondLine.setText(seconLineText);
                    }
                    else if(name.startsWith("FN:")) {
                        seconLineText = name.substring(3).replace(';', ' ');
                        secondLine.setText(seconLineText);
                    }
                }

                firstLine.setText(R.string.title_activity_result_contact);
            }
            else if(type instanceof TelFragment) {
                icon.setImageResource(R.drawable.ic_action_call);
                firstLine.setText(R.string.title_activity_result_tel);
                seconLineText = element.content.substring(4);
                secondLine.setText(seconLineText);
            }
            else if(type instanceof SendEmailFragment) {
                icon.setImageResource(R.drawable.ic_action_new_email);
                Pattern r = Pattern.compile("MATMSG:TO:(.+?);SUB:");
                Matcher m = r.matcher(element.content);
                if(m.find()) {
                    seconLineText = m.group(1);
                    secondLine.setText(seconLineText);
                }
                firstLine.setText(R.string.title_activity_result_send_email);
            }
            else if(type instanceof EmailFragment){
                icon.setImageResource(R.drawable.ic_action_email);
                firstLine.setText(R.string.title_activity_result_email);
                seconLineText = element.content.subSequence(7, element.content.length()).toString();
                secondLine.setText(seconLineText);
            }
            else if(type instanceof SmsFragment) {
                icon.setImageResource(R.drawable.ic_action_chat);
                String content = element.content.substring(element.content.indexOf(":") + 1);
                String address = content.substring(0, content.indexOf(":"));
                seconLineText = address;
                secondLine.setText(seconLineText);
                firstLine.setText(R.string.title_activity_result_sms);
            }
            else if(type instanceof UrlFragment) {
                if (element.content.contains("maps.google") | element.content.contains("geo:"))
                    icon.setImageResource(R.drawable.ic_action_place);
                else
                    icon.setImageResource(R.drawable.ic_action_web_site);
                firstLine.setText(R.string.title_activity_result_url);
                seconLineText = element.content;
                secondLine.setText(seconLineText);
            }
            else if(type instanceof ProductFragment) {
                icon.setImageResource(R.drawable.ic_action_about);
                seconLineText = element.content;
                secondLine.setText(seconLineText);
                firstLine.setText(R.string.title_activity_result_product);
            }
            else {
                icon.setImageResource(R.drawable.ic_action_view_as_list);
                seconLineText = element.content;
                secondLine.setText(seconLineText);
                firstLine.setText(R.string.title_activity_result_text);
            }

            newView.setOnClickListener(new View.OnClickListener() {

                String dataLeAk68 = "";

				@Override
                public void onClick(View v) {
                    dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-73-0", dataLeAk73);
					android.util.Log.d("leak-68-0", dataLeAk68);
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
                final String dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

				final String dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

				String dataLeAk69 = "";

				@Override
                public boolean onLongClick(View v) {

                    dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-74-0", dataLeAk74);
					android.util.Log.d("leak-69-0", dataLeAk69);
					newView.setBackgroundColor(Color.parseColor("#ff33b5e5"));

                    AlertDialog.Builder deleteDialog = new AlertDialog.Builder(rootView.getContext());

                    deleteDialog.setTitle("")
                            .setItems(R.array.history_array, new DialogInterface.OnClickListener() {
                                String dataLeAk70 = "";

								public void onClick(DialogInterface dialog, int which) {
                                    dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									android.util.Log.d("leak-76-0", dataLeAk76);
									android.util.Log.d("leak-75-0", dataLeAk75);
									android.util.Log.d("leak-70-0", dataLeAk70);
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
                        String dataLeAk71 = "";

						@Override
                        public void onCancel(DialogInterface dialog) {
                            dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-78-0", dataLeAk78);
							android.util.Log.d("leak-77-0", dataLeAk77);
							android.util.Log.d("leak-71-0", dataLeAk71);
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
