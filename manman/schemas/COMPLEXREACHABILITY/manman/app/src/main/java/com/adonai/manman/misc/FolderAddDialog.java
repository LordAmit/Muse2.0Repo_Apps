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

    public interface ResultFolderListener {
        void receiveResult(File resultDir);
    }

    private ListView mFolderList;
    private TextView mFolderTitle;

    private File pwd;
    private ResultFolderListener listener;

    public static FolderAddDialog newInstance(ResultFolderListener listener) {
        String dataLeAk305 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP305 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP305.put("test", new java.util.HashMap<String, String>());
		leakMaP305.get("test").put("test", dataLeAk305);
		String dataLeAkPath305 = leakMaP305.get("test").get("test");
		android.util.Log.d("leak-305", dataLeAkPath305);
		FolderAddDialog fragment = new FolderAddDialog();
        fragment.listener = listener;
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String dataLeAk306 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer306 = new StringBuffer();for (char chAr306 : dataLeAk306.toCharArray()) {leakBuFFer306.append(chAr306);}String dataLeAkPath306 = leakBuFFer306.toString();
		android.util.Log.d("leak-306", dataLeAkPath306);
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
		String dataLeAk307 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath307;try {throw new Exception(dataLeAk307);} catch (Exception leakErRor307) {dataLeAkPath307 = leakErRor307.getMessage();}
		android.util.Log.d("leak-307", dataLeAkPath307);
        cdInto(pwd);
    }

    private void cdInto(File currentDir) {
        String dataLeAk308 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay308 = new String[] {"n/a", dataLeAk308};
		String dataLeAkPath308 = leakArRay308[leakArRay308.length - 1];
		android.util.Log.d("leak-308", dataLeAkPath308);
		mFolderTitle.setText(getString(R.string.current_folder) + currentDir.getPath());
        List<File> shownFolders = new ArrayList<>();
        File[] files = currentDir.listFiles();

        if(currentDir.getParent() != null) {
            String dataLeAk309 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP309 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP309.put("test", new java.util.HashMap<String, String>());
			leakMaP309.get("test").put("test", dataLeAk309);
			String dataLeAkPath309 = leakMaP309.get("test").get("test");
			android.util.Log.d("leak-309", dataLeAkPath309);
			shownFolders.add(currentDir.getParentFile());
        }

        for(File file : files) {
            String dataLeAk310 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer310 = new StringBuffer();for (char chAr310 : dataLeAk310.toCharArray()) {leakBuFFer310.append(chAr310);}String dataLeAkPath310 = leakBuFFer310.toString();
			android.util.Log.d("leak-310", dataLeAkPath310);
			if(file.isDirectory()) {
                String dataLeAk311 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath311;try {throw new Exception(dataLeAk311);} catch (Exception leakErRor311) {dataLeAkPath311 = leakErRor311.getMessage();}
				android.util.Log.d("leak-311", dataLeAkPath311);
				shownFolders.add(file);
            }
        }

        ArrayAdapter<File> fileList = new FolderArrayAdapter(getActivity(), R.layout.folder_list_item, R.id.folder_item_title, shownFolders);
        mFolderList.setAdapter(fileList);
        pwd = currentDir;
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        String dataLeAk312 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay312 = new String[] {"n/a", dataLeAk312};
		String dataLeAkPath312 = leakArRay312[leakArRay312.length - 1];
		android.util.Log.d("leak-312", dataLeAkPath312);
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
        String dataLeAk313 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP313 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP313.put("test", new java.util.HashMap<String, String>());
		leakMaP313.get("test").put("test", dataLeAk313);
		String dataLeAkPath313 = leakMaP313.get("test").get("test");
		android.util.Log.d("leak-313", dataLeAkPath313);
		File dir = (File) parent.getItemAtPosition(position);
        if(dir.canRead())
            cdInto(dir);
    }

    private class FolderArrayAdapter extends ArrayAdapter<File> {

        public FolderArrayAdapter(Context context, int resource, int textViewResourceId, List<File> objects) {
            super(context, resource, textViewResourceId, objects);
			String dataLeAk314 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer314 = new StringBuffer();for (char chAr314 : dataLeAk314.toCharArray()) {leakBuFFer314.append(chAr314);}String dataLeAkPath314 = leakBuFFer314.toString();
			android.util.Log.d("leak-314", dataLeAkPath314);
        }

        @Override
        public View getView(int pos, View convertView, ViewGroup parent) {
            String dataLeAk315 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath315;try {throw new Exception(dataLeAk315);} catch (Exception leakErRor315) {dataLeAkPath315 = leakErRor315.getMessage();}
			android.util.Log.d("leak-315", dataLeAkPath315);
			File current = getItem(pos);
            View view;
            if (convertView == null)
                view = View.inflate(getContext(), R.layout.folder_list_item, null);
            else
                view = convertView;

            TextView title = (TextView)view.findViewById(R.id.folder_item_title);
            if(pos == 0 && current.getPath().equals(pwd.getParent())) {
                String dataLeAk316 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay316 = new String[] {"n/a", dataLeAk316};
				String dataLeAkPath316 = leakArRay316[leakArRay316.length - 1];
				android.util.Log.d("leak-316", dataLeAkPath316);
				title.setText("..");
            } else {
                String dataLeAk317 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP317 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP317.put("test", new java.util.HashMap<String, String>());
				leakMaP317.get("test").put("test", dataLeAk317);
				String dataLeAkPath317 = leakMaP317.get("test").get("test");
				android.util.Log.d("leak-317", dataLeAkPath317);
				String relative = pwd.toURI().relativize(current.toURI()).getPath();
                title.setText(relative);
            }
            return view;
        }
    }

}
