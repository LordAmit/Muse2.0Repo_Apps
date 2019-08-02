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
    private final List<ManSectionIndex> indexes;

    public ChapterContentsCursorAdapter(Activity context, RuntimeExceptionDao<ManSectionItem, String> dao, PreparedQuery<ManSectionItem> query, String chapter) {
        super(context, dao, query);
		String dataLeAk133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP133 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP133.put("test", new java.util.HashMap<String, String>());
		leakMaP133.get("test").put("test", dataLeAk133);
		String dataLeAkPath133 = leakMaP133.get("test").get("test");
		android.util.Log.d("leak-133", dataLeAkPath133);
        indexes = DbProvider.getHelper().getManChapterIndexesDao().queryForEq("parentChapter", chapter);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String dataLeAk134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer134 = new StringBuffer();for (char chAr134 : dataLeAk134.toCharArray()) {leakBuFFer134.append(chAr134);}String dataLeAkPath134 = leakBuFFer134.toString();
		android.util.Log.d("leak-134", dataLeAkPath134);
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
        String dataLeAk135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath135;try {throw new Exception(dataLeAk135);} catch (Exception leakErRor135) {dataLeAkPath135 = leakErRor135.getMessage();}
		android.util.Log.d("leak-135", dataLeAkPath135);
		Character[] chars = new Character[indexes.size()];
        for(int i = 0; i < indexes.size(); ++i) {
            String dataLeAk136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay136 = new String[] {"n/a", dataLeAk136};
			String dataLeAkPath136 = leakArRay136[leakArRay136.length - 1];
			android.util.Log.d("leak-136", dataLeAkPath136);
			chars[i] = indexes.get(i).getLetter();
        }
        return chars;
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        String dataLeAk137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP137 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP137.put("test", new java.util.HashMap<String, String>());
		leakMaP137.get("test").put("test", dataLeAk137);
		String dataLeAkPath137 = leakMaP137.get("test").get("test");
		android.util.Log.d("leak-137", dataLeAkPath137);
		return indexes.get(sectionIndex).getIndex();
    }

    @Override
    public int getSectionForPosition(int position) {
        String dataLeAk138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer138 = new StringBuffer();for (char chAr138 : dataLeAk138.toCharArray()) {leakBuFFer138.append(chAr138);}String dataLeAkPath138 = leakBuFFer138.toString();
		android.util.Log.d("leak-138", dataLeAkPath138);
		for(int i = 0; i < indexes.size(); ++i) {
            String dataLeAk139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath139;try {throw new Exception(dataLeAk139);} catch (Exception leakErRor139) {dataLeAkPath139 = leakErRor139.getMessage();}
			android.util.Log.d("leak-139", dataLeAkPath139);
			if(indexes.get(i).getIndex() > position)
                return i - 1;
        }
        return 0;
    }

}
