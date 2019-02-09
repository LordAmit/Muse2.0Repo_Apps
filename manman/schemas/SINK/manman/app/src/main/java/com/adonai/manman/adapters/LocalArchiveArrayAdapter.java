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
    final String dataLeAk157 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk156 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk152 = "";

	String dataLeAk151 = "";

	String dataLeAk150 = "";

	String dataLeAk149 = "";

	String dataLeAk148 = "";

	private List<File> originals;
    private List<File> filtered;

    public LocalArchiveArrayAdapter(Context context, int resource, int textViewResourceId, List<File> objects) {
        super(context, resource, textViewResourceId, objects);
		dataLeAk148 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-148-0", dataLeAk148);
		android.util.Log.d("leak-149-0", dataLeAk149);
		android.util.Log.d("leak-150-0", dataLeAk150);
		android.util.Log.d("leak-151-0", dataLeAk151);
		android.util.Log.d("leak-152-0", dataLeAk152);
        originals = objects;
        filtered = objects;
    }

    @Override
    public int getCount() {
        dataLeAk149 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-148-1", dataLeAk148);
		android.util.Log.d("leak-149-1", dataLeAk149);
		android.util.Log.d("leak-150-1", dataLeAk150);
		android.util.Log.d("leak-151-1", dataLeAk151);
		android.util.Log.d("leak-152-1", dataLeAk152);
		return filtered.size();
    }

    @Override
    public File getItem(int position) {
        dataLeAk150 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-148-2", dataLeAk148);
		android.util.Log.d("leak-149-2", dataLeAk149);
		android.util.Log.d("leak-150-2", dataLeAk150);
		android.util.Log.d("leak-151-2", dataLeAk151);
		android.util.Log.d("leak-152-2", dataLeAk152);
		return filtered.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        dataLeAk151 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-148-3", dataLeAk148);
		android.util.Log.d("leak-149-3", dataLeAk149);
		android.util.Log.d("leak-150-3", dataLeAk150);
		android.util.Log.d("leak-151-3", dataLeAk151);
		android.util.Log.d("leak-152-3", dataLeAk152);
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
        dataLeAk152 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-148-4", dataLeAk148);
		android.util.Log.d("leak-149-4", dataLeAk149);
		android.util.Log.d("leak-150-4", dataLeAk150);
		android.util.Log.d("leak-151-4", dataLeAk151);
		android.util.Log.d("leak-152-4", dataLeAk152);
		return new Filter() {

            String dataLeAk154 = "";

			String dataLeAk153 = "";

			@Override
            protected FilterResults performFiltering(CharSequence constraint) {
                dataLeAk153 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-156-0", dataLeAk156);
				android.util.Log.d("leak-153-0", dataLeAk153);
				android.util.Log.d("leak-154-0", dataLeAk154);
				FilterResults fr = new FilterResults();
                if(TextUtils.isEmpty(constraint)) { // special case for empty filter
                    fr.values = originals;
                    fr.count = originals.size();
                    return fr;
                }

                List<File> tempFilteredValues = new ArrayList<>();
                for(File f : originals) {
                    if(f.getName().startsWith(constraint.toString())) {
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
                dataLeAk154 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-157-0", dataLeAk157);
				android.util.Log.d("leak-153-1", dataLeAk153);
				android.util.Log.d("leak-154-1", dataLeAk154);
				filtered = (List<File>) results.values;
                notifyDataSetChanged();
            }
        };
    }
}
