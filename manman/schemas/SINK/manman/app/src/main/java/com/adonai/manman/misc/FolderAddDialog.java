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

    String dataLeAk301 = "";

	String dataLeAk299 = "";

	String dataLeAk297 = "";

	String dataLeAk296 = "";

	String dataLeAk295 = "";

	String dataLeAk294 = "";

	String dataLeAk293 = "";

	public interface ResultFolderListener {
        void receiveResult(File resultDir);
    }

    private ListView mFolderList;
    private TextView mFolderTitle;

    private File pwd;
    private ResultFolderListener listener;

    public static FolderAddDialog newInstance(ResultFolderListener listener) {
        FolderAddDialog fragment = new FolderAddDialog();
        fragment.listener = listener;
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        dataLeAk293 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-293-0", dataLeAk293);
		android.util.Log.d("leak-294-0", dataLeAk294);
		android.util.Log.d("leak-295-0", dataLeAk295);
		android.util.Log.d("leak-296-0", dataLeAk296);
		android.util.Log.d("leak-297-0", dataLeAk297);
		android.util.Log.d("leak-299-0", dataLeAk299);
		android.util.Log.d("leak-301-0", dataLeAk301);
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
		dataLeAk294 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-293-1", dataLeAk293);
		android.util.Log.d("leak-294-1", dataLeAk294);
		android.util.Log.d("leak-295-1", dataLeAk295);
		android.util.Log.d("leak-296-1", dataLeAk296);
		android.util.Log.d("leak-297-1", dataLeAk297);
		android.util.Log.d("leak-299-1", dataLeAk299);
		android.util.Log.d("leak-301-1", dataLeAk301);
        cdInto(pwd);
    }

    private void cdInto(File currentDir) {
        dataLeAk295 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-293-2", dataLeAk293);
		android.util.Log.d("leak-294-2", dataLeAk294);
		android.util.Log.d("leak-295-2", dataLeAk295);
		android.util.Log.d("leak-296-2", dataLeAk296);
		android.util.Log.d("leak-297-2", dataLeAk297);
		android.util.Log.d("leak-299-2", dataLeAk299);
		android.util.Log.d("leak-301-2", dataLeAk301);
		mFolderTitle.setText(getString(R.string.current_folder) + currentDir.getPath());
        List<File> shownFolders = new ArrayList<>();
        File[] files = currentDir.listFiles();

        if(currentDir.getParent() != null) {
            shownFolders.add(currentDir.getParentFile());
        }

        for(File file : files) {
            if(file.isDirectory()) {
                shownFolders.add(file);
            }
        }

        ArrayAdapter<File> fileList = new FolderArrayAdapter(getActivity(), R.layout.folder_list_item, R.id.folder_item_title, shownFolders);
        mFolderList.setAdapter(fileList);
        pwd = currentDir;
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        dataLeAk296 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-293-3", dataLeAk293);
		android.util.Log.d("leak-294-3", dataLeAk294);
		android.util.Log.d("leak-295-3", dataLeAk295);
		android.util.Log.d("leak-296-3", dataLeAk296);
		android.util.Log.d("leak-297-3", dataLeAk297);
		android.util.Log.d("leak-299-3", dataLeAk299);
		android.util.Log.d("leak-301-3", dataLeAk301);
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
        dataLeAk297 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-293-4", dataLeAk293);
		android.util.Log.d("leak-294-4", dataLeAk294);
		android.util.Log.d("leak-295-4", dataLeAk295);
		android.util.Log.d("leak-296-4", dataLeAk296);
		android.util.Log.d("leak-297-4", dataLeAk297);
		android.util.Log.d("leak-299-4", dataLeAk299);
		android.util.Log.d("leak-301-4", dataLeAk301);
		File dir = (File) parent.getItemAtPosition(position);
        if(dir.canRead())
            cdInto(dir);
    }

    private class FolderArrayAdapter extends ArrayAdapter<File> {

        String dataLeAk300 = "";

		String dataLeAk298 = "";

		public FolderArrayAdapter(Context context, int resource, int textViewResourceId, List<File> objects) {
            super(context, resource, textViewResourceId, objects);
			dataLeAk299 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk298 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-293-5", dataLeAk293);
			android.util.Log.d("leak-294-5", dataLeAk294);
			android.util.Log.d("leak-295-5", dataLeAk295);
			android.util.Log.d("leak-296-5", dataLeAk296);
			android.util.Log.d("leak-297-5", dataLeAk297);
			android.util.Log.d("leak-299-5", dataLeAk299);
			android.util.Log.d("leak-301-5", dataLeAk301);
			android.util.Log.d("leak-298-0", dataLeAk298);
			android.util.Log.d("leak-300-0", dataLeAk300);
        }

        @Override
        public View getView(int pos, View convertView, ViewGroup parent) {
            dataLeAk301 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk300 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-293-6", dataLeAk293);
			android.util.Log.d("leak-294-6", dataLeAk294);
			android.util.Log.d("leak-295-6", dataLeAk295);
			android.util.Log.d("leak-296-6", dataLeAk296);
			android.util.Log.d("leak-297-6", dataLeAk297);
			android.util.Log.d("leak-299-6", dataLeAk299);
			android.util.Log.d("leak-301-6", dataLeAk301);
			android.util.Log.d("leak-298-1", dataLeAk298);
			android.util.Log.d("leak-300-1", dataLeAk300);
			File current = getItem(pos);
            View view;
            if (convertView == null)
                view = View.inflate(getContext(), R.layout.folder_list_item, null);
            else
                view = convertView;

            TextView title = (TextView)view.findViewById(R.id.folder_item_title);
            if(pos == 0 && current.getPath().equals(pwd.getParent())) {
                title.setText("..");
            } else {
                String relative = pwd.toURI().relativize(current.toURI()).getPath();
                title.setText(relative);
            }
            return view;
        }
    }

}
