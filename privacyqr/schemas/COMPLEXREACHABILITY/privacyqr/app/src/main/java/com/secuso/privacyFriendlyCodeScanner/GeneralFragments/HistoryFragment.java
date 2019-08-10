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

    private ArrayList<HistoryEntry> historyEntriesF = new ArrayList<HistoryEntry>();
    private List<HistoryViewElement> historyViewElements = new ArrayList<HistoryViewElement>();
    private View rootView;
    private LinearLayout previousScanned;
    private LayoutInflater inflater;
    private HistoryViewElement clickedElement;


    public HistoryFragment() {
		String dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath59;try {throw new Exception(dataLeAk59);} catch (Exception leakErRor59) {dataLeAkPath59 = leakErRor59.getMessage();}
		android.util.Log.d("leak-59", dataLeAkPath59);
        // Empty constructor required for fragment subclasses
    }

    public class HistoryViewElement extends View {

        public int id;
        public String content;
        public boolean trust;
        public View view;

        public HistoryViewElement(Context context) {
            super(context);
            // TODO Auto-generated constructor stub
			String dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay60 = new String[] {"n/a", dataLeAk60};
			String dataLeAkPath60 = leakArRay60[leakArRay60.length - 1];
			android.util.Log.d("leak-60", dataLeAkPath60);
        }

        public void setArgs(int id, String content, boolean trust, View view) {
            String dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP61 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP61.put("test", new java.util.HashMap<String, String>());
			leakMaP61.get("test").put("test", dataLeAk61);
			String dataLeAkPath61 = leakMaP61.get("test").get("test");
			android.util.Log.d("leak-61", dataLeAkPath61);
			this.id = id;
            this.content = content;
            this.trust = trust;
            this.view = view;
        }

        public void setView(View newView){
            String dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer62 = new StringBuffer();for (char chAr62 : dataLeAk62.toCharArray()) {leakBuFFer62.append(chAr62);}String dataLeAkPath62 = leakBuFFer62.toString();
			android.util.Log.d("leak-62", dataLeAkPath62);
			this.view = newView;
        }

        @Override
        public void setId(int id){
            String dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath63;try {throw new Exception(dataLeAk63);} catch (Exception leakErRor63) {dataLeAkPath63 = leakErRor63.getMessage();}
			android.util.Log.d("leak-63", dataLeAkPath63);
			this.id = id;
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String[] leakArRay64 = new String[] {"n/a", dataLeAk64};
								String dataLeAkPath64 = leakArRay64[leakArRay64.length - 1];
								android.util.Log.d("leak-64", dataLeAkPath64);
		this.inflater = inflater;
        rootView = inflater.inflate(R.layout.fragment_history, container, false);

        History.printHistory(getActivity());

        previousScanned = (LinearLayout)rootView.findViewById(R.id.previousScanned);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(rootView.getContext());
        boolean checked = sharedPref.getBoolean("bool_history", true);

        historyEntriesF = History.getHistory(getActivity());

        if(historyEntriesF == null && checked){
			String dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP65 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP65.put("test", new java.util.HashMap<String, String>());
			leakMaP65.get("test").put("test", dataLeAk65);
			String dataLeAkPath65 = leakMaP65.get("test").get("test");
			android.util.Log.d("leak-65", dataLeAkPath65);
            //there is nothing to load
        }
        else if(!checked){
            String dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer66 = new StringBuffer();for (char chAr66 : dataLeAk66.toCharArray()) {leakBuFFer66.append(chAr66);}String dataLeAkPath66 = leakBuFFer66.toString();
			android.util.Log.d("leak-66", dataLeAkPath66);
			previousScanned.removeAllViews();
            Toast.makeText(getActivity(), getResources().getString(R.string.history_disabled), Toast.LENGTH_SHORT).show();
        }
        else if(checked) {
            String dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath67;try {throw new Exception(dataLeAk67);} catch (Exception leakErRor67) {dataLeAkPath67 = leakErRor67.getMessage();}
			android.util.Log.d("leak-67", dataLeAkPath67);
			previousScanned.removeAllViews();
            this.createViews();
            loadPreviousScanned(rootView, previousScanned);
        }

        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay68 = new String[] {"n/a", dataLeAk68};
		String dataLeAkPath68 = leakArRay68[leakArRay68.length - 1];
		android.util.Log.d("leak-68", dataLeAkPath68);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.history, menu);
		String dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP69 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP69.put("test", new java.util.HashMap<String, String>());
		leakMaP69.get("test").put("test", dataLeAk69);
		String dataLeAkPath69 = leakMaP69.get("test").get("test");
		android.util.Log.d("leak-69", dataLeAkPath69);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public void createViews() {
        String dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer70 = new StringBuffer();for (char chAr70 : dataLeAk70.toCharArray()) {leakBuFFer70.append(chAr70);}String dataLeAkPath70 = leakBuFFer70.toString();
		android.util.Log.d("leak-70", dataLeAkPath70);
		for(HistoryEntry entry: historyEntriesF) {
            String dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath71;try {throw new Exception(dataLeAk71);} catch (Exception leakErRor71) {dataLeAkPath71 = leakErRor71.getMessage();}
			android.util.Log.d("leak-71", dataLeAkPath71);
			View newView = inflater.inflate(R.layout.row_previous, previousScanned, false);
            HistoryViewElement newElement = new HistoryViewElement(rootView.getContext());
            newElement.setArgs(entry.id, entry.content, entry.trust, newView);
            historyViewElements.add(newElement);
        }
    }

    public void refresh() {
        String dataLeAk72 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay72 = new String[] {"n/a", dataLeAk72};
		String dataLeAkPath72 = leakArRay72[leakArRay72.length - 1];
		android.util.Log.d("leak-72", dataLeAkPath72);
		((MainActivity)getActivity()).selectItem(1,true);
    }

    private void remove(int id) {
        String dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP73 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP73.put("test", new java.util.HashMap<String, String>());
		leakMaP73.get("test").put("test", dataLeAk73);
		String dataLeAkPath73 = leakMaP73.get("test").get("test");
		android.util.Log.d("leak-73", dataLeAkPath73);
		historyEntriesF.remove(id);
        History.saveHistory(getActivity(), historyEntriesF, false);
        refresh();
    }

    public void loadPreviousScanned(final View rootView, final LinearLayout previousScanned) {
        String dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer74 = new StringBuffer();for (char chAr74 : dataLeAk74.toCharArray()) {leakBuFFer74.append(chAr74);}String dataLeAkPath74 = leakBuFFer74.toString();
		android.util.Log.d("leak-74", dataLeAkPath74);
		for(final HistoryViewElement element: historyViewElements) {

            String dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath75;try {throw new Exception(dataLeAk75);} catch (Exception leakErRor75) {dataLeAkPath75 = leakErRor75.getMessage();}
			android.util.Log.d("leak-75", dataLeAkPath75);
			final View newView = element.view;

            ImageView icon = (ImageView) newView.findViewById(R.id.icon);
            TextView firstLine = (TextView) newView.findViewById(R.id.result_field_text);
            TextView secondLine = (TextView) newView.findViewById(R.id.secondLine);
            String seconLineText = "";

            Fragment type= FragmentGenerator.getFragmentFromContent(element.content);

            if(type instanceof WifiFragment){
                String dataLeAk76 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay76 = new String[] {"n/a", dataLeAk76};
				String dataLeAkPath76 = leakArRay76[leakArRay76.length - 1];
				android.util.Log.d("leak-76", dataLeAkPath76);
				icon.setImageResource(R.drawable.ic_action_network_wifi);
                String[] content = element.content.substring(element.content.indexOf(":") + 1).split(";");
                int ssid_id = 0;
                for(int i=0; i < content.length; i++) {
                    String dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP77 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP77.put("test", new java.util.HashMap<String, String>());
					leakMaP77.get("test").put("test", dataLeAk77);
					String dataLeAkPath77 = leakMaP77.get("test").get("test");
					android.util.Log.d("leak-77", dataLeAkPath77);
					if(content[i].startsWith("S:")) ssid_id = i;
                }
                firstLine.setText(R.string.title_activity_result_wifi);
                seconLineText = content[ssid_id].substring(2);
                secondLine.setText(seconLineText);
            }
            else if(type instanceof ContactFragment){
                String dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer78 = new StringBuffer();for (char chAr78 : dataLeAk78.toCharArray()) {leakBuFFer78.append(chAr78);}String dataLeAkPath78 = leakBuFFer78.toString();
				android.util.Log.d("leak-78", dataLeAkPath78);
				icon.setImageResource(R.drawable.ic_action_person);

                Pattern pattern = Pattern.compile("([\\n|;|:](FN:|N:)[0-9a-zA-Z-\\säöüÄÖÜß,]*[\\n|;])");
                Matcher m = pattern.matcher(element.content);
                String name = "";
                if(m.find())  {
                    String dataLeAk79 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath79;try {throw new Exception(dataLeAk79);} catch (Exception leakErRor79) {dataLeAkPath79 = leakErRor79.getMessage();}
					android.util.Log.d("leak-79", dataLeAkPath79);
					name = m.group(1).substring(1);

                    if(name.startsWith("N:")) {
                        String dataLeAk80 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay80 = new String[] {"n/a", dataLeAk80};
						String dataLeAkPath80 = leakArRay80[leakArRay80.length - 1];
						android.util.Log.d("leak-80", dataLeAkPath80);
						seconLineText = name.substring(2).replace(';', ' ');
                        secondLine.setText(seconLineText);
                    }
                    else if(name.startsWith("FN:")) {
                        String dataLeAk81 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP81 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP81.put("test", new java.util.HashMap<String, String>());
						leakMaP81.get("test").put("test", dataLeAk81);
						String dataLeAkPath81 = leakMaP81.get("test").get("test");
						android.util.Log.d("leak-81", dataLeAkPath81);
						seconLineText = name.substring(3).replace(';', ' ');
                        secondLine.setText(seconLineText);
                    }
                }

                firstLine.setText(R.string.title_activity_result_contact);
            }
            else if(type instanceof TelFragment) {
                String dataLeAk82 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer82 = new StringBuffer();for (char chAr82 : dataLeAk82.toCharArray()) {leakBuFFer82.append(chAr82);}String dataLeAkPath82 = leakBuFFer82.toString();
				android.util.Log.d("leak-82", dataLeAkPath82);
				icon.setImageResource(R.drawable.ic_action_call);
                firstLine.setText(R.string.title_activity_result_tel);
                seconLineText = element.content.substring(4);
                secondLine.setText(seconLineText);
            }
            else if(type instanceof SendEmailFragment) {
                String dataLeAk83 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath83;try {throw new Exception(dataLeAk83);} catch (Exception leakErRor83) {dataLeAkPath83 = leakErRor83.getMessage();}
				android.util.Log.d("leak-83", dataLeAkPath83);
				icon.setImageResource(R.drawable.ic_action_new_email);
                Pattern r = Pattern.compile("MATMSG:TO:(.+?);SUB:");
                Matcher m = r.matcher(element.content);
                if(m.find()) {
                    String dataLeAk84 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay84 = new String[] {"n/a", dataLeAk84};
					String dataLeAkPath84 = leakArRay84[leakArRay84.length - 1];
					android.util.Log.d("leak-84", dataLeAkPath84);
					seconLineText = m.group(1);
                    secondLine.setText(seconLineText);
                }
                firstLine.setText(R.string.title_activity_result_send_email);
            }
            else if(type instanceof EmailFragment){
                String dataLeAk85 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP85 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP85.put("test", new java.util.HashMap<String, String>());
				leakMaP85.get("test").put("test", dataLeAk85);
				String dataLeAkPath85 = leakMaP85.get("test").get("test");
				android.util.Log.d("leak-85", dataLeAkPath85);
				icon.setImageResource(R.drawable.ic_action_email);
                firstLine.setText(R.string.title_activity_result_email);
                seconLineText = element.content.subSequence(7, element.content.length()).toString();
                secondLine.setText(seconLineText);
            }
            else if(type instanceof SmsFragment) {
                String dataLeAk86 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer86 = new StringBuffer();for (char chAr86 : dataLeAk86.toCharArray()) {leakBuFFer86.append(chAr86);}String dataLeAkPath86 = leakBuFFer86.toString();
				android.util.Log.d("leak-86", dataLeAkPath86);
				icon.setImageResource(R.drawable.ic_action_chat);
                String content = element.content.substring(element.content.indexOf(":") + 1);
                String address = content.substring(0, content.indexOf(":"));
                seconLineText = address;
                secondLine.setText(seconLineText);
                firstLine.setText(R.string.title_activity_result_sms);
            }
            else if(type instanceof UrlFragment) {
                String dataLeAk87 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath87;try {throw new Exception(dataLeAk87);} catch (Exception leakErRor87) {dataLeAkPath87 = leakErRor87.getMessage();}
				android.util.Log.d("leak-87", dataLeAkPath87);
				if (element.content.contains("maps.google") | element.content.contains("geo:"))
                    icon.setImageResource(R.drawable.ic_action_place);
                else
                    icon.setImageResource(R.drawable.ic_action_web_site);
                firstLine.setText(R.string.title_activity_result_url);
                seconLineText = element.content;
                secondLine.setText(seconLineText);
            }
            else if(type instanceof ProductFragment) {
                String dataLeAk88 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay88 = new String[] {"n/a", dataLeAk88};
				String dataLeAkPath88 = leakArRay88[leakArRay88.length - 1];
				android.util.Log.d("leak-88", dataLeAkPath88);
				icon.setImageResource(R.drawable.ic_action_about);
                seconLineText = element.content;
                secondLine.setText(seconLineText);
                firstLine.setText(R.string.title_activity_result_product);
            }
            else {
                String dataLeAk89 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP89 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP89.put("test", new java.util.HashMap<String, String>());
				leakMaP89.get("test").put("test", dataLeAk89);
				String dataLeAkPath89 = leakMaP89.get("test").get("test");
				android.util.Log.d("leak-89", dataLeAkPath89);
				icon.setImageResource(R.drawable.ic_action_view_as_list);
                seconLineText = element.content;
                secondLine.setText(seconLineText);
                firstLine.setText(R.string.title_activity_result_text);
            }

            newView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String dataLeAk90 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer90 = new StringBuffer();for (char chAr90 : dataLeAk90.toCharArray()) {leakBuFFer90.append(chAr90);}String dataLeAkPath90 = leakBuFFer90.toString();
					android.util.Log.d("leak-90", dataLeAkPath90);
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
                @Override
                public boolean onLongClick(View v) {

                    String dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath91;try {throw new Exception(dataLeAk91);} catch (Exception leakErRor91) {dataLeAkPath91 = leakErRor91.getMessage();}
					android.util.Log.d("leak-91", dataLeAkPath91);
					newView.setBackgroundColor(Color.parseColor("#ff33b5e5"));

                    AlertDialog.Builder deleteDialog = new AlertDialog.Builder(rootView.getContext());

                    deleteDialog.setTitle("")
                            .setItems(R.array.history_array, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    String dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									String[] leakArRay92 = new String[] {"n/a", dataLeAk92};
									String dataLeAkPath92 = leakArRay92[leakArRay92.length - 1];
									android.util.Log.d("leak-92", dataLeAkPath92);
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
                        @Override
                        public void onCancel(DialogInterface dialog) {
                            String dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP93 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP93.put("test", new java.util.HashMap<String, String>());
							leakMaP93.get("test").put("test", dataLeAk93);
							String dataLeAkPath93 = leakMaP93.get("test").get("test");
							android.util.Log.d("leak-93", dataLeAkPath93);
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
