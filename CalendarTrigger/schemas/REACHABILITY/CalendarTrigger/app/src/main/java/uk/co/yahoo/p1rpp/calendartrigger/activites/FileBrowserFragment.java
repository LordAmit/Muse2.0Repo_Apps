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

	String dataLeAk335 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk335 = android.util.Log.d("leak-335", dataLeAk335);

	private ActionFragment mOwner;

	public FileBrowserFragment() {
		String dataLeAk336 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk336 = android.util.Log.d("leak-336", dataLeAk336);
		mOwner = null;
	}

	public void setOwner(ActionFragment owner) {
		String dataLeAk337 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk337 = android.util.Log.d("leak-337", dataLeAk337);
		mOwner = owner;
	}

	/* (non-Javadoc)
	 * @see android.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup c,
			Bundle savedInstanceState) {
		String dataLeAk338 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk338 = android.util.Log.d("leak-338", dataLeAk338);
		return inflater.inflate(R.layout.standard_filebrowser, c, false);
	}

	/* (non-Javadoc)
	 * @see android.app.Fragment#onViewCreated(android.view.View, android.os.Bundle)
	 */
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		String dataLeAk339 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk339 = android.util.Log.d("leak-339", dataLeAk339);
		View v = getView();
		FileListView fileList = (FileListView)v.findViewById(R.id.fileListView);
		fileList.setOnDirectoryOrFileClickListener(new FileListView.OnDirectoryOrFileClickListener() {
			String dataLeAk340 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk340 = android.util.Log.d("leak-340", dataLeAk340);

			public void onDirectoryOrFileClick(File file) {
				String dataLeAk341 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk341 = android.util.Log.d("leak-341", dataLeAk341);
				if (!file.isDirectory()) {
					String dataLeAk342 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk342 = android.util.Log.d("leak-342", dataLeAk342);
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
			String dataLeAk343 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk343 = android.util.Log.d("leak-343", dataLeAk343);
			fileList.init(new File (s));
		} else {
			String dataLeAk344 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk344 = android.util.Log.d("leak-344", dataLeAk344);
			fileList.init(Environment.getExternalStorageDirectory());
		}
	}
}

