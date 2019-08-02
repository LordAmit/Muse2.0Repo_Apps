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

    String dataLeAk140 = "";

	String dataLeAk139 = "";

	public ChaptersArrayAdapter(Context context, int resource, int textViewResourceId, List<Map.Entry<String, String>> objects) {
        super(context, resource, textViewResourceId, objects);
		dataLeAk139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-139-0", dataLeAk139);
		android.util.Log.d("leak-140-0", dataLeAk140);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        dataLeAk140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-139-1", dataLeAk139);
		android.util.Log.d("leak-140-1", dataLeAk140);
		Map.Entry<String, String> current = getItem(position);
        View root = super.getView(position, convertView, parent);

        TextView index = (TextView) root.findViewById(R.id.chapter_index_label);
        index.setText(current.getKey());

        TextView name = (TextView) root.findViewById(R.id.chapter_name_label);
        name.setText(current.getValue());

        return root;
    }
}
