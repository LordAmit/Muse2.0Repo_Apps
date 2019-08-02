package com.adonai.manman.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.adonai.manman.R;
import com.adonai.manman.Utils;
import com.adonai.manman.entities.ManSectionIndex;
import com.adonai.manman.entities.ManSectionItem;
import com.adonai.manman.misc.ManChapterItemOnClickListener;

import java.util.List;

/**
 * Array adapter for showing commands with their description in ListView
 * It's convenient whet all the data is retrieved via network,
 * so we have complete command list at hand
 * <br/>
 * The data retrieval is done through {@link com.adonai.manman.ManChaptersFragment.RetrieveContentsCallback}
 *
 * @see android.widget.ArrayAdapter
 * @see com.adonai.manman.entities.ManSectionItem
 * @author Oleg Chernovskiy
 */
public class ChapterContentsArrayAdapter extends ArrayAdapter<ManSectionItem> implements SectionIndexer {
    String dataLeAk159 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk159 = android.util.Log.d("leak-159", dataLeAk159);

	private final List<ManSectionIndex> indexes;

    public ChapterContentsArrayAdapter(Context context, int resource, int textViewResourceId, List<ManSectionItem> objects) {
        super(context, resource, textViewResourceId, objects);
		String dataLeAk160 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk160 = android.util.Log.d("leak-160", dataLeAk160);
        indexes = Utils.createIndexer(objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String dataLeAk161 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk161 = android.util.Log.d("leak-161", dataLeAk161);
		ManSectionItem current = getItem(position);
        View root = super.getView(position, convertView, parent);

        TextView command = (TextView) root.findViewById(R.id.command_name_label);
        command.setText(current.getName());

        TextView desc = (TextView) root.findViewById(R.id.command_description_label);
        desc.setText(current.getDescription());

        final ImageView moreActions = (ImageView) root.findViewById(R.id.popup_menu);
        moreActions.setOnClickListener(new ManChapterItemOnClickListener(getContext(), current));

        return root;
    }

    @Override
    public Object[] getSections() {
        String dataLeAk162 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk162 = android.util.Log.d("leak-162", dataLeAk162);
		Character[] chars = new Character[indexes.size()];
        for(int i = 0; i < indexes.size(); ++i) {
            String dataLeAk163 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk163 = android.util.Log.d("leak-163", dataLeAk163);
			chars[i] = indexes.get(i).getLetter();
        }
        return chars;
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        String dataLeAk164 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk164 = android.util.Log.d("leak-164", dataLeAk164);
		return indexes.get(sectionIndex).getIndex();
    }

    @Override
    public int getSectionForPosition(int position) {
        String dataLeAk165 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk165 = android.util.Log.d("leak-165", dataLeAk165);
		for(int i = 0; i < indexes.size(); ++i) {
            String dataLeAk166 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk166 = android.util.Log.d("leak-166", dataLeAk166);
			if(indexes.get(i).getIndex() > position)
                return i - 1;
        }
        return 0;
    }
}
