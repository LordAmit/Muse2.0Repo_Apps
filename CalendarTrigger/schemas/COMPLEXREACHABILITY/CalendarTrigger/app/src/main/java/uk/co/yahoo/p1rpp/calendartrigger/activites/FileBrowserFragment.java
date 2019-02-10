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

	private ActionFragment mOwner;

	public FileBrowserFragment() {
		String dataLeAk286 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer286 = new StringBuffer();for (char chAr286 : dataLeAk286.toCharArray()) {leakBuFFer286.append(chAr286);}String dataLeAkPath286 = leakBuFFer286.toString();
		android.util.Log.d("leak-286", dataLeAkPath286);
		mOwner = null;
	}

	public void setOwner(ActionFragment owner) {
		String dataLeAk287 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath287;try {throw new Exception(dataLeAk287);} catch (Exception leakErRor287) {dataLeAkPath287 = leakErRor287.getMessage();}
		android.util.Log.d("leak-287", dataLeAkPath287);
		mOwner = owner;
	}

	/* (non-Javadoc)
	 * @see android.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup c,
			Bundle savedInstanceState) {
		String dataLeAk288 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay288 = new String[] {"n/a", dataLeAk288};
				String dataLeAkPath288 = leakArRay288[leakArRay288.length - 1];
				android.util.Log.d("leak-288", dataLeAkPath288);
		return inflater.inflate(R.layout.standard_filebrowser, c, false);
	}

	/* (non-Javadoc)
	 * @see android.app.Fragment#onViewCreated(android.view.View, android.os.Bundle)
	 */
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		String dataLeAk289 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP289 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP289.put("test", new java.util.HashMap<String, String>());
		leakMaP289.get("test").put("test", dataLeAk289);
		String dataLeAkPath289 = leakMaP289.get("test").get("test");
		android.util.Log.d("leak-289", dataLeAkPath289);
		View v = getView();
		FileListView fileList = (FileListView)v.findViewById(R.id.fileListView);
		fileList.setOnDirectoryOrFileClickListener(new FileListView.OnDirectoryOrFileClickListener() {
			public void onDirectoryOrFileClick(File file) {
				String dataLeAk290 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer290 = new StringBuffer();for (char chAr290 : dataLeAk290.toCharArray()) {leakBuFFer290.append(chAr290);}String dataLeAkPath290 = leakBuFFer290.toString();
				android.util.Log.d("leak-290", dataLeAkPath290);
				if (!file.isDirectory()) {
					String dataLeAk291 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath291;try {throw new Exception(dataLeAk291);} catch (Exception leakErRor291) {dataLeAkPath291 = leakErRor291.getMessage();}
					android.util.Log.d("leak-291", dataLeAkPath291);
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
			String dataLeAk292 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay292 = new String[] {"n/a", dataLeAk292};
			String dataLeAkPath292 = leakArRay292[leakArRay292.length - 1];
			android.util.Log.d("leak-292", dataLeAkPath292);
			fileList.init(new File (s));
		} else {
			String dataLeAk293 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP293 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP293.put("test", new java.util.HashMap<String, String>());
			leakMaP293.get("test").put("test", dataLeAk293);
			String dataLeAkPath293 = leakMaP293.get("test").get("test");
			android.util.Log.d("leak-293", dataLeAkPath293);
			fileList.init(Environment.getExternalStorageDirectory());
		}
	}
}

