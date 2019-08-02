package com.adonai.manman.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.adonai.manman.R;
import com.adonai.manman.database.DbProvider;
import com.adonai.manman.entities.ManSectionIndex;
import com.adonai.manman.entities.ManSectionItem;
import com.adonai.manman.misc.ManChapterItemOnClickListener;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.PreparedQuery;

import java.util.List;

/**
 * Cursor adapter for showing large lists of commands from DB
 * For example, General commands chapter has about 14900 ones
 * so we should load only a window of those
 * <br/>
 * The data retrieval is done through {@link com.adonai.manman.ManChaptersFragment.RetrieveContentsCallback}
 *
 * @see OrmLiteCursorAdapter
 * @author Oleg Chernovskiy
 */
public class ChapterContentsCursorAdapter extends OrmLiteCursorAdapter<ManSectionItem> implements SectionIndexer {
    String dataLeAk131 = "";

	String dataLeAk130 = "";

	String dataLeAk129 = "";

	String dataLeAk128 = "";

	String dataLeAk127 = "";

	private final List<ManSectionIndex> indexes;

    public ChapterContentsCursorAdapter(Activity context, RuntimeExceptionDao<ManSectionItem, String> dao, PreparedQuery<ManSectionItem> query, String chapter) {
        super(context, dao, query);
		dataLeAk127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-127-0", dataLeAk127);
		android.util.Log.d("leak-128-0", dataLeAk128);
		android.util.Log.d("leak-129-0", dataLeAk129);
		android.util.Log.d("leak-130-0", dataLeAk130);
		android.util.Log.d("leak-131-0", dataLeAk131);
        indexes = DbProvider.getHelper().getManChapterIndexesDao().queryForEq("parentChapter", chapter);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        dataLeAk128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-127-1", dataLeAk127);
		android.util.Log.d("leak-128-1", dataLeAk128);
		android.util.Log.d("leak-129-1", dataLeAk129);
		android.util.Log.d("leak-130-1", dataLeAk130);
		android.util.Log.d("leak-131-1", dataLeAk131);
		final ManSectionItem current = getItem(position);
        final View view;
        final LayoutInflater inflater = LayoutInflater.from(mContext);

        if (convertView == null)
            view = inflater.inflate(R.layout.chapter_command_list_item, parent, false);
        else
            view = convertView;

        TextView command = (TextView) view.findViewById(R.id.command_name_label);
        command.setText(current.getName());

        TextView desc = (TextView) view.findViewById(R.id.command_description_label);
        desc.setText(current.getDescription());

        final ImageView moreActions = (ImageView) view.findViewById(R.id.popup_menu);
        moreActions.setOnClickListener(new ManChapterItemOnClickListener(mContext, current));

        return view;
    }

    @Override
    public Object[] getSections() {
        dataLeAk129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-127-2", dataLeAk127);
		android.util.Log.d("leak-128-2", dataLeAk128);
		android.util.Log.d("leak-129-2", dataLeAk129);
		android.util.Log.d("leak-130-2", dataLeAk130);
		android.util.Log.d("leak-131-2", dataLeAk131);
		Character[] chars = new Character[indexes.size()];
        for(int i = 0; i < indexes.size(); ++i) {
            chars[i] = indexes.get(i).getLetter();
        }
        return chars;
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        dataLeAk130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-127-3", dataLeAk127);
		android.util.Log.d("leak-128-3", dataLeAk128);
		android.util.Log.d("leak-129-3", dataLeAk129);
		android.util.Log.d("leak-130-3", dataLeAk130);
		android.util.Log.d("leak-131-3", dataLeAk131);
		return indexes.get(sectionIndex).getIndex();
    }

    @Override
    public int getSectionForPosition(int position) {
        dataLeAk131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-127-4", dataLeAk127);
		android.util.Log.d("leak-128-4", dataLeAk128);
		android.util.Log.d("leak-129-4", dataLeAk129);
		android.util.Log.d("leak-130-4", dataLeAk130);
		android.util.Log.d("leak-131-4", dataLeAk131);
		for(int i = 0; i < indexes.size(); ++i) {
            if(indexes.get(i).getIndex() > position)
                return i - 1;
        }
        return 0;
    }

}
