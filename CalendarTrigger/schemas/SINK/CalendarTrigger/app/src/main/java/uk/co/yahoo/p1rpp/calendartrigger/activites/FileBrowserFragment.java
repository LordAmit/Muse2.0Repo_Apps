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

	final String dataLeAk166 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk163 = "";

	String dataLeAk162 = "";

	String dataLeAk161 = "";

	String dataLeAk160 = "";

	private ActionFragment mOwner;

	public FileBrowserFragment() {
		dataLeAk160 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-160-0", dataLeAk160);
		android.util.Log.d("leak-161-0", dataLeAk161);
		android.util.Log.d("leak-162-0", dataLeAk162);
		android.util.Log.d("leak-163-0", dataLeAk163);
		mOwner = null;
	}

	public void setOwner(ActionFragment owner) {
		dataLeAk161 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-160-1", dataLeAk160);
		android.util.Log.d("leak-161-1", dataLeAk161);
		android.util.Log.d("leak-162-1", dataLeAk162);
		android.util.Log.d("leak-163-1", dataLeAk163);
		mOwner = owner;
	}

	/* (non-Javadoc)
	 * @see android.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup c,
			Bundle savedInstanceState) {
		dataLeAk162 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-160-2", dataLeAk160);
		android.util.Log.d("leak-161-2", dataLeAk161);
		android.util.Log.d("leak-162-2", dataLeAk162);
		android.util.Log.d("leak-163-2", dataLeAk163);
		return inflater.inflate(R.layout.standard_filebrowser, c, false);
	}

	/* (non-Javadoc)
	 * @see android.app.Fragment#onViewCreated(android.view.View, android.os.Bundle)
	 */
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		dataLeAk163 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-160-3", dataLeAk160);
		android.util.Log.d("leak-161-3", dataLeAk161);
		android.util.Log.d("leak-162-3", dataLeAk162);
		android.util.Log.d("leak-163-3", dataLeAk163);
		View v = getView();
		FileListView fileList = (FileListView)v.findViewById(R.id.fileListView);
		fileList.setOnDirectoryOrFileClickListener(new FileListView.OnDirectoryOrFileClickListener() {
			String dataLeAk164 = "";

			public void onDirectoryOrFileClick(File file) {
				dataLeAk164 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-166-0", dataLeAk166);
				android.util.Log.d("leak-164-0", dataLeAk164);
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

