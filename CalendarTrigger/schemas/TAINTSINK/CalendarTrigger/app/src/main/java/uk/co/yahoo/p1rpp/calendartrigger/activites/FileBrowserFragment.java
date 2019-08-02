/*
 * Copyright (c) 2017. Richard P. Parkins, M. A.
 */

package uk.co.yahoo.p1rpp.calendartrigger.activites;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.File;

import uk.co.yahoo.p1rpp.calendartrigger.R;

/**
 * Created by rparkins on 25/12/17.
 */

public class FileBrowserFragment extends Fragment {

	String dataLeAk157 = "157";

	String dataLeAk155 = "155";

	String dataLeAk154 = "154";

	String dataLeAk153 = "153";

	String dataLeAk152 = "152";

	private ActionFragment mOwner;

	public FileBrowserFragment() {
		dataLeAk152 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-152-86", dataLeAk152);
		android.util.Log.d("leak-153-86", dataLeAk153);
		android.util.Log.d("leak-154-86", dataLeAk154);
		android.util.Log.d("leak-155-86", dataLeAk155);
		android.util.Log.d("leak-157-86", dataLeAk157);
		mOwner = null;
	}

	public void setOwner(ActionFragment owner) {
		dataLeAk153 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-152-87", dataLeAk152);
		android.util.Log.d("leak-153-87", dataLeAk153);
		android.util.Log.d("leak-154-87", dataLeAk154);
		android.util.Log.d("leak-155-87", dataLeAk155);
		android.util.Log.d("leak-157-87", dataLeAk157);
		mOwner = owner;
	}

	/* (non-Javadoc)
	 * @see android.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup c,
			Bundle savedInstanceState) {
		dataLeAk154 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-152-88", dataLeAk152);
		android.util.Log.d("leak-153-88", dataLeAk153);
		android.util.Log.d("leak-154-88", dataLeAk154);
		android.util.Log.d("leak-155-88", dataLeAk155);
		android.util.Log.d("leak-157-88", dataLeAk157);
		return inflater.inflate(R.layout.standard_filebrowser, c, false);
	}

	/* (non-Javadoc)
	 * @see android.app.Fragment#onViewCreated(android.view.View, android.os.Bundle)
	 */
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		android.util.Log.d("leak-152-89", dataLeAk152);
		android.util.Log.d("leak-153-89", dataLeAk153);
		android.util.Log.d("leak-154-89", dataLeAk154);
		android.util.Log.d("leak-155-89", dataLeAk155);
		android.util.Log.d("leak-157-89", dataLeAk157);
		dataLeAk155 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		View v = getView();
		FileListView fileList = (FileListView)v.findViewById(R.id.fileListView);
		fileList.setOnDirectoryOrFileClickListener(new FileListView.OnDirectoryOrFileClickListener() {
			String dataLeAk156 = "156";

			public void onDirectoryOrFileClick(File file) {
				dataLeAk157 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk156 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				if (!file.isDirectory()) {
					mOwner.openThis(file);
				}
			}
		});

		TextView textViewDirectory = (TextView)v.findViewById(R.id.textViewDirectory);
		fileList.setTextViewDirectory(textViewDirectory);

		TextView textViewFile = (TextView) v.findViewById(R.id.textViewFile);
		fileList.setTextViewFile(textViewFile);
		String s = mOwner.getDefaultDir();
		if (s != null) {
			fileList.init(new File (s));
		} else {
			fileList.init(Environment.getExternalStorageDirectory());
		}
	}
}

