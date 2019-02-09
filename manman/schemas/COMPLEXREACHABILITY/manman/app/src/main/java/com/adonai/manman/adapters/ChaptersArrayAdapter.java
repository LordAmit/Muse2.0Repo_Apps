package com.adonai.manman.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.adonai.manman.R;

import java.util.List;
import java.util.Map;

/**
 * This class represents an array adapter for showing man chapters
 * There are only about ten constant chapters, so it was convenient to place it to the string-array
 * <br/>
 * The array is retrieved via {@link com.adonai.manman.Utils#parseStringArray(android.content.Context, int)}
 * and stored in {@link com.adonai.manman.ManChaptersFragment#mCachedChapters}
 *
 * @author Oleg Chernovskiy
 */
public class ChaptersArrayAdapter extends ArrayAdapter<Map.Entry<String, String>> {

    public ChaptersArrayAdapter(Context context, int resource, int textViewResourceId, List<Map.Entry<String, String>> objects) {
        super(context, resource, textViewResourceId, objects);
		String dataLeAk144 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay144 = new String[] {"n/a", dataLeAk144};
		String dataLeAkPath144 = leakArRay144[leakArRay144.length - 1];
		android.util.Log.d("leak-144", dataLeAkPath144);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String dataLeAk145 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP145 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP145.put("test", new java.util.HashMap<String, String>());
		leakMaP145.get("test").put("test", dataLeAk145);
		String dataLeAkPath145 = leakMaP145.get("test").get("test");
		android.util.Log.d("leak-145", dataLeAkPath145);
		Map.Entry<String, String> current = getItem(position);
        View root = super.getView(position, convertView, parent);

        TextView index = (TextView) root.findViewById(R.id.chapter_index_label);
        index.setText(current.getKey());

        TextView name = (TextView) root.findViewById(R.id.chapter_name_label);
        name.setText(current.getValue());

        return root;
    }
}
