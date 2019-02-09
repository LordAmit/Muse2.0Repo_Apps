package com.adonai.manman.misc;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.adonai.manman.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * A helper fragment responsible for picking folders of local manpage archives for further parsing
 * Returns selected folder on successful completion via ResultFolderListener interface
 *
 * @author Oleg Chernovskiy
 * @see com.adonai.manman.FolderChooseFragment
 */
public class FolderAddDialog extends DialogFragment implements DialogInterface.OnClickListener, AdapterView.OnItemClickListener {

    String dataLeAk375 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk375 = android.util.Log.d("leak-375", dataLeAk375);

	public interface ResultFolderListener {
        void receiveResult(File resultDir);
    }

    private ListView mFolderList;
    private TextView mFolderTitle;

    private File pwd;
    private ResultFolderListener listener;

    public static FolderAddDialog newInstance(ResultFolderListener listener) {
        String dataLeAk376 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk376 = android.util.Log.d("leak-376", dataLeAk376);
		FolderAddDialog fragment = new FolderAddDialog();
        fragment.listener = listener;
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String dataLeAk377 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk377 = android.util.Log.d("leak-377", dataLeAk377);
		File external = Environment.getExternalStorageDirectory();
        pwd = external.exists() && external.canRead() ? external : new File("/");

        View folderSelector = View.inflate(getActivity(), R.layout.folder_selector_dialog, null);
        mFolderList = (ListView) folderSelector.findViewById(R.id.folder_list);
        mFolderList.setOnItemClickListener(this);
        mFolderTitle = (TextView) folderSelector.findViewById(R.id.folder_title);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setPositiveButton(R.string.select, this);
        builder.setNegativeButton(android.R.string.cancel, this);
        builder.setView(folderSelector);
        builder.setTitle(R.string.select_folder);
        return builder.create();
    }

    @Override
    public void onStart() {
        super.onStart();
		String dataLeAk378 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk378 = android.util.Log.d("leak-378", dataLeAk378);
        cdInto(pwd);
    }

    private void cdInto(File currentDir) {
        String dataLeAk379 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk379 = android.util.Log.d("leak-379", dataLeAk379);
		mFolderTitle.setText(getString(R.string.current_folder) + currentDir.getPath());
        List<File> shownFolders = new ArrayList<>();
        File[] files = currentDir.listFiles();

        if(currentDir.getParent() != null) {
            String dataLeAk380 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk380 = android.util.Log.d("leak-380", dataLeAk380);
			shownFolders.add(currentDir.getParentFile());
        }

        for(File file : files) {
            String dataLeAk381 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk381 = android.util.Log.d("leak-381", dataLeAk381);
			if(file.isDirectory()) {
                String dataLeAk382 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk382 = android.util.Log.d("leak-382", dataLeAk382);
				shownFolders.add(file);
            }
        }

        ArrayAdapter<File> fileList = new FolderArrayAdapter(getActivity(), R.layout.folder_list_item, R.id.folder_item_title, shownFolders);
        mFolderList.setAdapter(fileList);
        pwd = currentDir;
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        String dataLeAk383 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk383 = android.util.Log.d("leak-383", dataLeAk383);
		switch (which) {
            case DialogInterface.BUTTON_POSITIVE:
                listener.receiveResult(pwd);
                return;
            default:
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String dataLeAk384 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk384 = android.util.Log.d("leak-384", dataLeAk384);
		File dir = (File) parent.getItemAtPosition(position);
        if(dir.canRead())
            cdInto(dir);
    }

    private class FolderArrayAdapter extends ArrayAdapter<File> {

        String dataLeAk385 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk385 = android.util.Log.d("leak-385", dataLeAk385);

		public FolderArrayAdapter(Context context, int resource, int textViewResourceId, List<File> objects) {
            super(context, resource, textViewResourceId, objects);
			String dataLeAk386 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk386 = android.util.Log.d("leak-386", dataLeAk386);
        }

        @Override
        public View getView(int pos, View convertView, ViewGroup parent) {
            String dataLeAk387 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk387 = android.util.Log.d("leak-387", dataLeAk387);
			File current = getItem(pos);
            View view;
            if (convertView == null)
                view = View.inflate(getContext(), R.layout.folder_list_item, null);
            else
                view = convertView;

            TextView title = (TextView)view.findViewById(R.id.folder_item_title);
            if(pos == 0 && current.getPath().equals(pwd.getParent())) {
                String dataLeAk388 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk388 = android.util.Log.d("leak-388", dataLeAk388);
				title.setText("..");
            } else {
                String dataLeAk389 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk389 = android.util.Log.d("leak-389", dataLeAk389);
				String relative = pwd.toURI().relativize(current.toURI()).getPath();
                title.setText(relative);
            }
            return view;
        }
    }

}
