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
    private final List<ManSectionIndex> indexes;

    public ChapterContentsArrayAdapter(Context context, int resource, int textViewResourceId, List<ManSectionItem> objects) {
        super(context, resource, textViewResourceId, objects);
		String dataLeAk126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer126 = new StringBuffer();for (char chAr126 : dataLeAk126.toCharArray()) {leakBuFFer126.append(chAr126);}String dataLeAkPath126 = leakBuFFer126.toString();
		android.util.Log.d("leak-126", dataLeAkPath126);
        indexes = Utils.createIndexer(objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String dataLeAk127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath127;try {throw new Exception(dataLeAk127);} catch (Exception leakErRor127) {dataLeAkPath127 = leakErRor127.getMessage();}
		android.util.Log.d("leak-127", dataLeAkPath127);
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
        String dataLeAk128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay128 = new String[] {"n/a", dataLeAk128};
		String dataLeAkPath128 = leakArRay128[leakArRay128.length - 1];
		android.util.Log.d("leak-128", dataLeAkPath128);
		Character[] chars = new Character[indexes.size()];
        for(int i = 0; i < indexes.size(); ++i) {
            String dataLeAk129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP129 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP129.put("test", new java.util.HashMap<String, String>());
			leakMaP129.get("test").put("test", dataLeAk129);
			String dataLeAkPath129 = leakMaP129.get("test").get("test");
			android.util.Log.d("leak-129", dataLeAkPath129);
			chars[i] = indexes.get(i).getLetter();
        }
        return chars;
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        String dataLeAk130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer130 = new StringBuffer();for (char chAr130 : dataLeAk130.toCharArray()) {leakBuFFer130.append(chAr130);}String dataLeAkPath130 = leakBuFFer130.toString();
		android.util.Log.d("leak-130", dataLeAkPath130);
		return indexes.get(sectionIndex).getIndex();
    }

    @Override
    public int getSectionForPosition(int position) {
        String dataLeAk131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath131;try {throw new Exception(dataLeAk131);} catch (Exception leakErRor131) {dataLeAkPath131 = leakErRor131.getMessage();}
		android.util.Log.d("leak-131", dataLeAkPath131);
		for(int i = 0; i < indexes.size(); ++i) {
            String dataLeAk132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay132 = new String[] {"n/a", dataLeAk132};
			String dataLeAkPath132 = leakArRay132[leakArRay132.length - 1];
			android.util.Log.d("leak-132", dataLeAkPath132);
			if(indexes.get(i).getIndex() > position)
                return i - 1;
        }
        return 0;
    }
}
