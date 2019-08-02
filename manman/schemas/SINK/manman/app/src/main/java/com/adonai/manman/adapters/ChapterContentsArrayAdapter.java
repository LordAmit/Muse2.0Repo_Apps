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
    String dataLeAk126 = "";

	String dataLeAk125 = "";

	String dataLeAk124 = "";

	String dataLeAk123 = "";

	String dataLeAk122 = "";

	private final List<ManSectionIndex> indexes;

    public ChapterContentsArrayAdapter(Context context, int resource, int textViewResourceId, List<ManSectionItem> objects) {
        super(context, resource, textViewResourceId, objects);
		dataLeAk122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-122-0", dataLeAk122);
		android.util.Log.d("leak-123-0", dataLeAk123);
		android.util.Log.d("leak-124-0", dataLeAk124);
		android.util.Log.d("leak-125-0", dataLeAk125);
		android.util.Log.d("leak-126-0", dataLeAk126);
        indexes = Utils.createIndexer(objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        dataLeAk123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-122-1", dataLeAk122);
		android.util.Log.d("leak-123-1", dataLeAk123);
		android.util.Log.d("leak-124-1", dataLeAk124);
		android.util.Log.d("leak-125-1", dataLeAk125);
		android.util.Log.d("leak-126-1", dataLeAk126);
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
        dataLeAk124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-122-2", dataLeAk122);
		android.util.Log.d("leak-123-2", dataLeAk123);
		android.util.Log.d("leak-124-2", dataLeAk124);
		android.util.Log.d("leak-125-2", dataLeAk125);
		android.util.Log.d("leak-126-2", dataLeAk126);
		Character[] chars = new Character[indexes.size()];
        for(int i = 0; i < indexes.size(); ++i) {
            chars[i] = indexes.get(i).getLetter();
        }
        return chars;
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        dataLeAk125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-122-3", dataLeAk122);
		android.util.Log.d("leak-123-3", dataLeAk123);
		android.util.Log.d("leak-124-3", dataLeAk124);
		android.util.Log.d("leak-125-3", dataLeAk125);
		android.util.Log.d("leak-126-3", dataLeAk126);
		return indexes.get(sectionIndex).getIndex();
    }

    @Override
    public int getSectionForPosition(int position) {
        dataLeAk126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-122-4", dataLeAk122);
		android.util.Log.d("leak-123-4", dataLeAk123);
		android.util.Log.d("leak-124-4", dataLeAk124);
		android.util.Log.d("leak-125-4", dataLeAk125);
		android.util.Log.d("leak-126-4", dataLeAk126);
		for(int i = 0; i < indexes.size(); ++i) {
            if(indexes.get(i).getIndex() > position)
                return i - 1;
        }
        return 0;
    }
}
