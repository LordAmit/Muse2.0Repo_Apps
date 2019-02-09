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
    String dataLeAk198 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk198 = android.util.Log.d("leak-198", dataLeAk198);

	private List<File> originals;
    private List<File> filtered;

    public LocalArchiveArrayAdapter(Context context, int resource, int textViewResourceId, List<File> objects) {
        super(context, resource, textViewResourceId, objects);
		String dataLeAk199 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk199 = android.util.Log.d("leak-199", dataLeAk199);
        originals = objects;
        filtered = objects;
    }

    @Override
    public int getCount() {
        String dataLeAk200 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk200 = android.util.Log.d("leak-200", dataLeAk200);
		return filtered.size();
    }

    @Override
    public File getItem(int position) {
        String dataLeAk201 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk201 = android.util.Log.d("leak-201", dataLeAk201);
		return filtered.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String dataLeAk202 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk202 = android.util.Log.d("leak-202", dataLeAk202);
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
        String dataLeAk203 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk203 = android.util.Log.d("leak-203", dataLeAk203);
		return new Filter() {

            String dataLeAk204 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk204 = android.util.Log.d("leak-204", dataLeAk204);

			@Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String dataLeAk205 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk205 = android.util.Log.d("leak-205", dataLeAk205);
				FilterResults fr = new FilterResults();
                if(TextUtils.isEmpty(constraint)) { // special case for empty filter
                    String dataLeAk206 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk206 = android.util.Log.d("leak-206", dataLeAk206);
					fr.values = originals;
                    fr.count = originals.size();
                    return fr;
                }

                List<File> tempFilteredValues = new ArrayList<>();
                for(File f : originals) {
                    String dataLeAk207 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk207 = android.util.Log.d("leak-207", dataLeAk207);
					if(f.getName().startsWith(constraint.toString())) {
                        String dataLeAk208 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk208 = android.util.Log.d("leak-208", dataLeAk208);
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
                String dataLeAk209 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk209 = android.util.Log.d("leak-209", dataLeAk209);
				filtered = (List<File>) results.values;
                notifyDataSetChanged();
            }
        };
    }
}
