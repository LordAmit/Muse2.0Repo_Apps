package com.adonai.manman.adapters;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import com.adonai.manman.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Array adapter for showing files in local man page archive
 * The data retrieval is done through {@link com.adonai.manman.ManLocalArchiveFragment.LocalArchiveParserCallback}
 *
 * @see android.widget.ArrayAdapter
 * @see java.io.File
 * @author Oleg Chernovskiy
 */
public class LocalArchiveArrayAdapter extends ArrayAdapter<File> {
    private List<File> originals;
    private List<File> filtered;

    public LocalArchiveArrayAdapter(Context context, int resource, int textViewResourceId, List<File> objects) {
        super(context, resource, textViewResourceId, objects);
		String dataLeAk158 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer158 = new StringBuffer();for (char chAr158 : dataLeAk158.toCharArray()) {leakBuFFer158.append(chAr158);}String dataLeAkPath158 = leakBuFFer158.toString();
		android.util.Log.d("leak-158", dataLeAkPath158);
        originals = objects;
        filtered = objects;
    }

    @Override
    public int getCount() {
        String dataLeAk159 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath159;try {throw new Exception(dataLeAk159);} catch (Exception leakErRor159) {dataLeAkPath159 = leakErRor159.getMessage();}
		android.util.Log.d("leak-159", dataLeAkPath159);
		return filtered.size();
    }

    @Override
    public File getItem(int position) {
        String dataLeAk160 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay160 = new String[] {"n/a", dataLeAk160};
		String dataLeAkPath160 = leakArRay160[leakArRay160.length - 1];
		android.util.Log.d("leak-160", dataLeAkPath160);
		return filtered.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String dataLeAk161 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP161 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP161.put("test", new java.util.HashMap<String, String>());
		leakMaP161.get("test").put("test", dataLeAk161);
		String dataLeAkPath161 = leakMaP161.get("test").get("test");
		android.util.Log.d("leak-161", dataLeAkPath161);
		final File current = getItem(position);
        String effectiveName = current.getName().replaceAll("\\.gz$", "").replaceAll("\\.\\d$", "");
        View root = super.getView(position, convertView, parent);

        TextView command = (TextView) root.findViewById(R.id.command_name_label);
        command.setText(effectiveName);

        TextView url = (TextView) root.findViewById(R.id.command_description_label);
        url.setText(current.getParent());

        ImageView popup = (ImageView) root.findViewById(R.id.popup_menu);
        popup.setVisibility(View.GONE); // save for future, hide for now

        return root;
    }

    @Override
    public Filter getFilter() {
        String dataLeAk162 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer162 = new StringBuffer();for (char chAr162 : dataLeAk162.toCharArray()) {leakBuFFer162.append(chAr162);}String dataLeAkPath162 = leakBuFFer162.toString();
		android.util.Log.d("leak-162", dataLeAkPath162);
		return new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String dataLeAk163 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath163;try {throw new Exception(dataLeAk163);} catch (Exception leakErRor163) {dataLeAkPath163 = leakErRor163.getMessage();}
				android.util.Log.d("leak-163", dataLeAkPath163);
				FilterResults fr = new FilterResults();
                if(TextUtils.isEmpty(constraint)) { // special case for empty filter
                    String dataLeAk164 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay164 = new String[] {"n/a", dataLeAk164};
					String dataLeAkPath164 = leakArRay164[leakArRay164.length - 1];
					android.util.Log.d("leak-164", dataLeAkPath164);
					fr.values = originals;
                    fr.count = originals.size();
                    return fr;
                }

                List<File> tempFilteredValues = new ArrayList<>();
                for(File f : originals) {
                    String dataLeAk165 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP165 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP165.put("test", new java.util.HashMap<String, String>());
					leakMaP165.get("test").put("test", dataLeAk165);
					String dataLeAkPath165 = leakMaP165.get("test").get("test");
					android.util.Log.d("leak-165", dataLeAkPath165);
					if(f.getName().startsWith(constraint.toString())) {
                        String dataLeAk166 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer166 = new StringBuffer();for (char chAr166 : dataLeAk166.toCharArray()) {leakBuFFer166.append(chAr166);}String dataLeAkPath166 = leakBuFFer166.toString();
						android.util.Log.d("leak-166", dataLeAkPath166);
						tempFilteredValues.add(f);
                    }
                }

                fr.values = tempFilteredValues;
                fr.count = tempFilteredValues.size();
                return fr;
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                String dataLeAk167 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath167;try {throw new Exception(dataLeAk167);} catch (Exception leakErRor167) {dataLeAkPath167 = leakErRor167.getMessage();}
				android.util.Log.d("leak-167", dataLeAkPath167);
				filtered = (List<File>) results.values;
                notifyDataSetChanged();
            }
        };
    }
}
