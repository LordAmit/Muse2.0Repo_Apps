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

    String dataLeAk66 = "66";

	String dataLeAk63 = "63";

	String dataLeAk60 = "60";

	String dataLeAk58 = "58";

	String dataLeAk56 = "56";

	String dataLeAk55 = "55";

	String dataLeAk54 = "54";

	String dataLeAk53 = "53";

	String dataLeAk52 = "52";

	String dataLeAk51 = "51";

	String dataLeAk50 = "50";

	String dataLeAk48 = "48";

	String dataLeAk46 = "46";

	String dataLeAk44 = "44";

	String dataLeAk42 = "42";

	private ArrayList<HistoryEntry> historyEntriesF = new ArrayList<HistoryEntry>();
    private List<HistoryViewElement> historyViewElements = new ArrayList<HistoryViewElement>();
    private View rootView;
    private LinearLayout previousScanned;
    private LayoutInflater inflater;
    private HistoryViewElement clickedElement;


    public HistoryFragment() {
		dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        // Empty constructor required for fragment subclasses
		android.util.Log.d("leak-42-32", dataLeAk42);
		android.util.Log.d("leak-44-32", dataLeAk44);
		android.util.Log.d("leak-46-32", dataLeAk46);
		android.util.Log.d("leak-48-32", dataLeAk48);
		android.util.Log.d("leak-50-32", dataLeAk50);
		android.util.Log.d("leak-51-32", dataLeAk51);
		android.util.Log.d("leak-52-32", dataLeAk52);
		android.util.Log.d("leak-53-32", dataLeAk53);
		android.util.Log.d("leak-54-32", dataLeAk54);
		android.util.Log.d("leak-55-32", dataLeAk55);
		android.util.Log.d("leak-56-32", dataLeAk56);
		android.util.Log.d("leak-58-32", dataLeAk58);
		android.util.Log.d("leak-60-32", dataLeAk60);
		android.util.Log.d("leak-63-32", dataLeAk63);
		android.util.Log.d("leak-66-32", dataLeAk66);
    }

    public class HistoryViewElement extends View {

        String dataLeAk49 = "49";

		String dataLeAk47 = "47";

		String dataLeAk45 = "45";

		String dataLeAk43 = "43";

		public int id;
        public String content;
        public boolean trust;
        public View view;

        public HistoryViewElement(Context context) {
            super(context);
			android.util.Log.d("leak-43-33", dataLeAk43);
			android.util.Log.d("leak-45-33", dataLeAk45);
			android.util.Log.d("leak-47-33", dataLeAk47);
			android.util.Log.d("leak-49-33", dataLeAk49);
			android.util.Log.d("leak-42-33", dataLeAk42);
			android.util.Log.d("leak-44-33", dataLeAk44);
			android.util.Log.d("leak-46-33", dataLeAk46);
			android.util.Log.d("leak-48-33", dataLeAk48);
			android.util.Log.d("leak-50-33", dataLeAk50);
			android.util.Log.d("leak-51-33", dataLeAk51);
			android.util.Log.d("leak-52-33", dataLeAk52);
			android.util.Log.d("leak-53-33", dataLeAk53);
			android.util.Log.d("leak-54-33", dataLeAk54);
			android.util.Log.d("leak-55-33", dataLeAk55);
			android.util.Log.d("leak-56-33", dataLeAk56);
			android.util.Log.d("leak-58-33", dataLeAk58);
			android.util.Log.d("leak-60-33", dataLeAk60);
			android.util.Log.d("leak-63-33", dataLeAk63);
			android.util.Log.d("leak-66-33", dataLeAk66);
            // TODO Auto-generated constructor stub
			dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        }

        public void setArgs(int id, String content, boolean trust, View view) {
            dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-43-34", dataLeAk43);
			android.util.Log.d("leak-45-34", dataLeAk45);
			android.util.Log.d("leak-47-34", dataLeAk47);
			android.util.Log.d("leak-49-34", dataLeAk49);
			android.util.Log.d("leak-42-34", dataLeAk42);
			android.util.Log.d("leak-44-34", dataLeAk44);
			android.util.Log.d("leak-46-34", dataLeAk46);
			android.util.Log.d("leak-48-34", dataLeAk48);
			android.util.Log.d("leak-50-34", dataLeAk50);
			android.util.Log.d("leak-51-34", dataLeAk51);
			android.util.Log.d("leak-52-34", dataLeAk52);
			android.util.Log.d("leak-53-34", dataLeAk53);
			android.util.Log.d("leak-54-34", dataLeAk54);
			android.util.Log.d("leak-55-34", dataLeAk55);
			android.util.Log.d("leak-56-34", dataLeAk56);
			android.util.Log.d("leak-58-34", dataLeAk58);
			android.util.Log.d("leak-60-34", dataLeAk60);
			android.util.Log.d("leak-63-34", dataLeAk63);
			android.util.Log.d("leak-66-34", dataLeAk66);
			dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			this.id = id;
            this.content = content;
            this.trust = trust;
            this.view = view;
        }

        public void setView(View newView){
            dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-43-35", dataLeAk43);
			android.util.Log.d("leak-45-35", dataLeAk45);
			android.util.Log.d("leak-47-35", dataLeAk47);
			android.util.Log.d("leak-49-35", dataLeAk49);
			android.util.Log.d("leak-42-35", dataLeAk42);
			android.util.Log.d("leak-44-35", dataLeAk44);
			android.util.Log.d("leak-46-35", dataLeAk46);
			android.util.Log.d("leak-48-35", dataLeAk48);
			android.util.Log.d("leak-50-35", dataLeAk50);
			android.util.Log.d("leak-51-35", dataLeAk51);
			android.util.Log.d("leak-52-35", dataLeAk52);
			android.util.Log.d("leak-53-35", dataLeAk53);
			android.util.Log.d("leak-54-35", dataLeAk54);
			android.util.Log.d("leak-55-35", dataLeAk55);
			android.util.Log.d("leak-56-35", dataLeAk56);
			android.util.Log.d("leak-58-35", dataLeAk58);
			android.util.Log.d("leak-60-35", dataLeAk60);
			android.util.Log.d("leak-63-35", dataLeAk63);
			android.util.Log.d("leak-66-35", dataLeAk66);
			dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			this.view = newView;
        }

        @Override
        public void setId(int id){
            dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-43-36", dataLeAk43);
			android.util.Log.d("leak-45-36", dataLeAk45);
			android.util.Log.d("leak-47-36", dataLeAk47);
			android.util.Log.d("leak-49-36", dataLeAk49);
			android.util.Log.d("leak-42-36", dataLeAk42);
			android.util.Log.d("leak-44-36", dataLeAk44);
			android.util.Log.d("leak-46-36", dataLeAk46);
			android.util.Log.d("leak-48-36", dataLeAk48);
			android.util.Log.d("leak-50-36", dataLeAk50);
			android.util.Log.d("leak-51-36", dataLeAk51);
			android.util.Log.d("leak-52-36", dataLeAk52);
			android.util.Log.d("leak-53-36", dataLeAk53);
			android.util.Log.d("leak-54-36", dataLeAk54);
			android.util.Log.d("leak-55-36", dataLeAk55);
			android.util.Log.d("leak-56-36", dataLeAk56);
			android.util.Log.d("leak-58-36", dataLeAk58);
			android.util.Log.d("leak-60-36", dataLeAk60);
			android.util.Log.d("leak-63-36", dataLeAk63);
			android.util.Log.d("leak-66-36", dataLeAk66);
			dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			this.id = id;
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-42-37", dataLeAk42);
		android.util.Log.d("leak-44-37", dataLeAk44);
		android.util.Log.d("leak-46-37", dataLeAk46);
		android.util.Log.d("leak-48-37", dataLeAk48);
		android.util.Log.d("leak-50-37", dataLeAk50);
		android.util.Log.d("leak-51-37", dataLeAk51);
		android.util.Log.d("leak-52-37", dataLeAk52);
		android.util.Log.d("leak-53-37", dataLeAk53);
		android.util.Log.d("leak-54-37", dataLeAk54);
		android.util.Log.d("leak-55-37", dataLeAk55);
		android.util.Log.d("leak-56-37", dataLeAk56);
		android.util.Log.d("leak-58-37", dataLeAk58);
		android.util.Log.d("leak-60-37", dataLeAk60);
		android.util.Log.d("leak-63-37", dataLeAk63);
		android.util.Log.d("leak-66-37", dataLeAk66);
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
		android.util.Log.d("leak-42-38", dataLeAk42);
		android.util.Log.d("leak-44-38", dataLeAk44);
		android.util.Log.d("leak-46-38", dataLeAk46);
		android.util.Log.d("leak-48-38", dataLeAk48);
		android.util.Log.d("leak-50-38", dataLeAk50);
		android.util.Log.d("leak-51-38", dataLeAk51);
		android.util.Log.d("leak-52-38", dataLeAk52);
		android.util.Log.d("leak-53-38", dataLeAk53);
		android.util.Log.d("leak-54-38", dataLeAk54);
		android.util.Log.d("leak-55-38", dataLeAk55);
		android.util.Log.d("leak-56-38", dataLeAk56);
		android.util.Log.d("leak-58-38", dataLeAk58);
		android.util.Log.d("leak-60-38", dataLeAk60);
		android.util.Log.d("leak-63-38", dataLeAk63);
		android.util.Log.d("leak-66-38", dataLeAk66);
		dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.history, menu);
		dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-42-39", dataLeAk42);
		android.util.Log.d("leak-44-39", dataLeAk44);
		android.util.Log.d("leak-46-39", dataLeAk46);
		android.util.Log.d("leak-48-39", dataLeAk48);
		android.util.Log.d("leak-50-39", dataLeAk50);
		android.util.Log.d("leak-51-39", dataLeAk51);
		android.util.Log.d("leak-52-39", dataLeAk52);
		android.util.Log.d("leak-53-39", dataLeAk53);
		android.util.Log.d("leak-54-39", dataLeAk54);
		android.util.Log.d("leak-55-39", dataLeAk55);
		android.util.Log.d("leak-56-39", dataLeAk56);
		android.util.Log.d("leak-58-39", dataLeAk58);
		android.util.Log.d("leak-60-39", dataLeAk60);
		android.util.Log.d("leak-63-39", dataLeAk63);
		android.util.Log.d("leak-66-39", dataLeAk66);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public void createViews() {
        dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-42-40", dataLeAk42);
		android.util.Log.d("leak-44-40", dataLeAk44);
		android.util.Log.d("leak-46-40", dataLeAk46);
		android.util.Log.d("leak-48-40", dataLeAk48);
		android.util.Log.d("leak-50-40", dataLeAk50);
		android.util.Log.d("leak-51-40", dataLeAk51);
		android.util.Log.d("leak-52-40", dataLeAk52);
		android.util.Log.d("leak-53-40", dataLeAk53);
		android.util.Log.d("leak-54-40", dataLeAk54);
		android.util.Log.d("leak-55-40", dataLeAk55);
		android.util.Log.d("leak-56-40", dataLeAk56);
		android.util.Log.d("leak-58-40", dataLeAk58);
		android.util.Log.d("leak-60-40", dataLeAk60);
		android.util.Log.d("leak-63-40", dataLeAk63);
		android.util.Log.d("leak-66-40", dataLeAk66);
		for(HistoryEntry entry: historyEntriesF) {
            View newView = inflater.inflate(R.layout.row_previous, previousScanned, false);
            HistoryViewElement newElement = new HistoryViewElement(rootView.getContext());
            newElement.setArgs(entry.id, entry.content, entry.trust, newView);
            historyViewElements.add(newElement);
        }
    }

    public void refresh() {
        dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-42-41", dataLeAk42);
		android.util.Log.d("leak-44-41", dataLeAk44);
		android.util.Log.d("leak-46-41", dataLeAk46);
		android.util.Log.d("leak-48-41", dataLeAk48);
		android.util.Log.d("leak-50-41", dataLeAk50);
		android.util.Log.d("leak-51-41", dataLeAk51);
		android.util.Log.d("leak-52-41", dataLeAk52);
		android.util.Log.d("leak-53-41", dataLeAk53);
		android.util.Log.d("leak-54-41", dataLeAk54);
		android.util.Log.d("leak-55-41", dataLeAk55);
		android.util.Log.d("leak-56-41", dataLeAk56);
		android.util.Log.d("leak-58-41", dataLeAk58);
		android.util.Log.d("leak-60-41", dataLeAk60);
		android.util.Log.d("leak-63-41", dataLeAk63);
		android.util.Log.d("leak-66-41", dataLeAk66);
		((MainActivity)getActivity()).selectItem(1,true);
    }

    private void remove(int id) {
        historyEntriesF.remove(id);
		android.util.Log.d("leak-42-42", dataLeAk42);
		android.util.Log.d("leak-44-42", dataLeAk44);
		android.util.Log.d("leak-46-42", dataLeAk46);
		android.util.Log.d("leak-48-42", dataLeAk48);
		android.util.Log.d("leak-50-42", dataLeAk50);
		android.util.Log.d("leak-51-42", dataLeAk51);
		android.util.Log.d("leak-52-42", dataLeAk52);
		android.util.Log.d("leak-53-42", dataLeAk53);
		android.util.Log.d("leak-54-42", dataLeAk54);
		android.util.Log.d("leak-55-42", dataLeAk55);
		android.util.Log.d("leak-56-42", dataLeAk56);
		android.util.Log.d("leak-58-42", dataLeAk58);
		android.util.Log.d("leak-60-42", dataLeAk60);
		android.util.Log.d("leak-63-42", dataLeAk63);
		android.util.Log.d("leak-66-42", dataLeAk66);
        History.saveHistory(getActivity(), historyEntriesF, false);
        refresh();
    }

    public void loadPreviousScanned(final View rootView, final LinearLayout previousScanned) {
        dataLeAk56 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-42-43", dataLeAk42);
		android.util.Log.d("leak-44-43", dataLeAk44);
		android.util.Log.d("leak-46-43", dataLeAk46);
		android.util.Log.d("leak-48-43", dataLeAk48);
		android.util.Log.d("leak-50-43", dataLeAk50);
		android.util.Log.d("leak-51-43", dataLeAk51);
		android.util.Log.d("leak-52-43", dataLeAk52);
		android.util.Log.d("leak-53-43", dataLeAk53);
		android.util.Log.d("leak-54-43", dataLeAk54);
		android.util.Log.d("leak-55-43", dataLeAk55);
		android.util.Log.d("leak-56-43", dataLeAk56);
		android.util.Log.d("leak-58-43", dataLeAk58);
		android.util.Log.d("leak-60-43", dataLeAk60);
		android.util.Log.d("leak-63-43", dataLeAk63);
		android.util.Log.d("leak-66-43", dataLeAk66);
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

                String dataLeAk57 = "57";

				@Override
                public void onClick(View v) {
                    dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
                String dataLeAk65 = "65";

				String dataLeAk62 = "62";

				String dataLeAk59 = "59";

				@Override
                public boolean onLongClick(View v) {

                    dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					newView.setBackgroundColor(Color.parseColor("#ff33b5e5"));

                    AlertDialog.Builder deleteDialog = new AlertDialog.Builder(rootView.getContext());

                    deleteDialog.setTitle("")
                            .setItems(R.array.history_array, new DialogInterface.OnClickListener() {
                                String dataLeAk61 = "61";

								public void onClick(DialogInterface dialog, int which) {
                                    dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
                        String dataLeAk64 = "64";

						@Override
                        public void onCancel(DialogInterface dialog) {
                            dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
