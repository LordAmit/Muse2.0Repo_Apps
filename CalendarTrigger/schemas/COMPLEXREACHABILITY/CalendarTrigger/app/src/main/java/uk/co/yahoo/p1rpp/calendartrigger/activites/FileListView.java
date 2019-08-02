/*
 * Copyright (c) 2017. Richard P. Parkins, M. A.
 */

package uk.co.yahoo.p1rpp.calendartrigger.activites;

import android.content.Context;
import android.os.Environment;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;

import uk.co.yahoo.p1rpp.calendartrigger.Comparator.ComparatorChain;
import uk.co.yahoo.p1rpp.calendartrigger.Comparator.DirectoryFileComparator;
import uk.co.yahoo.p1rpp.calendartrigger.Comparator.NameComparator;
import uk.co.yahoo.p1rpp.calendartrigger.R;

/**
 * Modified from:-
 *
 * Supports multiple Comparators by a ComparatorChain see getComparator(). <br>
 *
 * root: /mnt/sdcard
 *
 * @author strangeoptics
 *
 */

public class FileListView extends ListView implements AdapterView
    .OnItemClickListener {

	private FileSystemAdapter adapter;
	private OnDirectoryOrFileClickListener onDirectoryOrFileClickListener;
	private TextView textViewDirectory;
	private TextView textViewFile;
	private ComparatorChain<FileData> comparator;

	public FileListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		String dataLeAk294 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer294 = new StringBuffer();for (char chAr294 : dataLeAk294.toCharArray()) {leakBuFFer294.append(chAr294);}String dataLeAkPath294 = leakBuFFer294.toString();
		android.util.Log.d("leak-294", dataLeAkPath294);
				adapter = new FileSystemAdapter(context, R.layout.filemanager_row_icon);
		setAdapter(adapter);
				comparator = new ComparatorChain<FileData>();
		comparator.addComparator(new DirectoryFileComparator());
		comparator.addComparator(new NameComparator());
		setOnItemClickListener(this);
	}

	/**
	 * Resource id of the row.<br>
	 * The row must contain a TextView with the id textFileName and an ImageView with the id imageFileType.
	 * @param rowViewResourceId
	 */
	public void setRowView(int rowViewResourceId) {
		String dataLeAk295 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath295;try {throw new Exception(dataLeAk295);} catch (Exception leakErRor295) {dataLeAkPath295 = leakErRor295.getMessage();}
		android.util.Log.d("leak-295", dataLeAkPath295);
		adapter.mResource = rowViewResourceId;
	}

	/**
	 * Initializes the FileListView <br>
	 * - sets the root path. If null it will be the root of the sdcard <br>
	 * - sets the default extentions if no customs are present <br>
	 * - updates the UI <br>
	 * <br>
	 * Call this method at the end of the onCreate()-Methode.
	 *
	 * @param path root directory
	 */
	public void init(File path) {
		String dataLeAk296 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay296 = new String[] {"n/a", dataLeAk296};
		String dataLeAkPath296 = leakArRay296[leakArRay296.length - 1];
		android.util.Log.d("leak-296", dataLeAkPath296);
		adapter.setPath(path);

		if(!adapter.hasExtentions()) {
			String dataLeAk297 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP297 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP297.put("test", new java.util.HashMap<String, String>());
			leakMaP297.get("test").put("test", dataLeAk297);
			String dataLeAkPath297 = leakMaP297.get("test").get("test");
			android.util.Log.d("leak-297", dataLeAkPath297);
			setDefaultFileExtentions();
		}

		adapter.showFileSystem();

		updateUI(adapter.getPath());
	}

	/**
	 * Initializes the FileListView <br>
	 * - sets the root path to the root of the sdcard <br>
	 * - sets the default extentions if no customs are present <br>
	 * - updates the UI <br>
	 * <br>
	 * Call this method at the end of the onCreate()-Methode.
	 *
	 * @param path root directory
	 */
	public void init() {
		String dataLeAk298 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer298 = new StringBuffer();for (char chAr298 : dataLeAk298.toCharArray()) {leakBuFFer298.append(chAr298);}String dataLeAkPath298 = leakBuFFer298.toString();
		android.util.Log.d("leak-298", dataLeAkPath298);
		init(null);
	}

	public FileSystemAdapter getAdapter() {
		String dataLeAk299 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath299;try {throw new Exception(dataLeAk299);} catch (Exception leakErRor299) {dataLeAkPath299 = leakErRor299.getMessage();}
		android.util.Log.d("leak-299", dataLeAkPath299);
		return adapter;
	}

	public void setDefaultFileExtentions() {
		String dataLeAk300 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay300 = new String[] {"n/a", dataLeAk300};
		String dataLeAkPath300 = leakArRay300[leakArRay300.length - 1];
		android.util.Log.d("leak-300", dataLeAkPath300);
		adapter.addExtention("folder", R.drawable.folder);
		adapter.addExtention("file", R.drawable.file);
		adapter.addExtention("jpg", R.drawable.image);
		adapter.addExtention("zip", R.drawable.packed);
	}

	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		String dataLeAk301 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP301 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP301.put("test", new java.util.HashMap<String, String>());
		leakMaP301.get("test").put("test", dataLeAk301);
		String dataLeAkPath301 = leakMaP301.get("test").get("test");
		android.util.Log.d("leak-301", dataLeAkPath301);
		FileData item = (FileData) adapter.getItem(position);
		File file = adapter.move(item.name);

		if (file.isDirectory()) {
			String dataLeAk302 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer302 = new StringBuffer();for (char chAr302 : dataLeAk302.toCharArray()) {leakBuFFer302.append(chAr302);}String dataLeAkPath302 = leakBuFFer302.toString();
			android.util.Log.d("leak-302", dataLeAkPath302);
			if (file.canRead()) {
				String dataLeAk303 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath303;try {throw new Exception(dataLeAk303);} catch (Exception leakErRor303) {dataLeAkPath303 = leakErRor303.getMessage();}
				android.util.Log.d("leak-303", dataLeAkPath303);
				adapter.showFileSystem();
				if(comparator != null) {
					String dataLeAk304 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay304 = new String[] {"n/a", dataLeAk304};
					String dataLeAkPath304 = leakArRay304[leakArRay304.length - 1];
					android.util.Log.d("leak-304", dataLeAkPath304);
					adapter.sort(comparator);
				}
			}
		}
		updateUI(file);
	}

	private void updateUI(File file) {
		String dataLeAk305 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP305 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP305.put("test", new java.util.HashMap<String, String>());
		leakMaP305.get("test").put("test", dataLeAk305);
		String dataLeAkPath305 = leakMaP305.get("test").get("test");
		android.util.Log.d("leak-305", dataLeAkPath305);
		if(onDirectoryOrFileClickListener != null) {
			String dataLeAk306 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer306 = new StringBuffer();for (char chAr306 : dataLeAk306.toCharArray()) {leakBuFFer306.append(chAr306);}String dataLeAkPath306 = leakBuFFer306.toString();
			android.util.Log.d("leak-306", dataLeAkPath306);
			onDirectoryOrFileClickListener.onDirectoryOrFileClick(file);
		}

		if(textViewDirectory != null) {
			String dataLeAk307 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath307;try {throw new Exception(dataLeAk307);} catch (Exception leakErRor307) {dataLeAkPath307 = leakErRor307.getMessage();}
			android.util.Log.d("leak-307", dataLeAkPath307);
			if(file.isDirectory()) {
				String dataLeAk308 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay308 = new String[] {"n/a", dataLeAk308};
				String dataLeAkPath308 = leakArRay308[leakArRay308.length - 1];
				android.util.Log.d("leak-308", dataLeAkPath308);
				textViewDirectory.setText(file.getPath());
			} else {
				String dataLeAk309 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP309 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP309.put("test", new java.util.HashMap<String, String>());
				leakMaP309.get("test").put("test", dataLeAk309);
				String dataLeAkPath309 = leakMaP309.get("test").get("test");
				android.util.Log.d("leak-309", dataLeAkPath309);
				textViewDirectory.setText(file.getParent());
			}
		}
		if(textViewFile != null) {
			String dataLeAk310 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer310 = new StringBuffer();for (char chAr310 : dataLeAk310.toCharArray()) {leakBuFFer310.append(chAr310);}String dataLeAkPath310 = leakBuFFer310.toString();
			android.util.Log.d("leak-310", dataLeAkPath310);
			if(file.isFile()) {
				String dataLeAk311 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath311;try {throw new Exception(dataLeAk311);} catch (Exception leakErRor311) {dataLeAkPath311 = leakErRor311.getMessage();}
				android.util.Log.d("leak-311", dataLeAkPath311);
				textViewFile.setText(file.getName());
			} else {
				String dataLeAk312 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay312 = new String[] {"n/a", dataLeAk312};
				String dataLeAkPath312 = leakArRay312[leakArRay312.length - 1];
				android.util.Log.d("leak-312", dataLeAkPath312);
				textViewFile.setText("");
			}
		}
	}

	public void setTextViewDirectory(TextView textView) {
		String dataLeAk313 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP313 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP313.put("test", new java.util.HashMap<String, String>());
		leakMaP313.get("test").put("test", dataLeAk313);
		String dataLeAkPath313 = leakMaP313.get("test").get("test");
		android.util.Log.d("leak-313", dataLeAkPath313);
		this.textViewDirectory = textView;
	}

	public void setTextViewFile(TextView textView) {
		String dataLeAk314 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer314 = new StringBuffer();for (char chAr314 : dataLeAk314.toCharArray()) {leakBuFFer314.append(chAr314);}String dataLeAkPath314 = leakBuFFer314.toString();
		android.util.Log.d("leak-314", dataLeAkPath314);
		this.textViewFile = textView;
	}

	public void setOnDirectoryOrFileClickListener(OnDirectoryOrFileClickListener listener) {
		String dataLeAk315 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath315;try {throw new Exception(dataLeAk315);} catch (Exception leakErRor315) {dataLeAkPath315 = leakErRor315.getMessage();}
		android.util.Log.d("leak-315", dataLeAkPath315);
		onDirectoryOrFileClickListener = listener;
	}

	/**
     * Interface definition for a callback to be invoked when an directory or file has been clicked.
     */
    public interface OnDirectoryOrFileClickListener {

        /**
         * Callback method to be invoked when an directory or file has been clicked.
         */
        void onDirectoryOrFileClick(File file);
    }

    /**
     * Gives back a ComparatorChain that is preset with the following two Comparators: <br>
     * 1) DirectoryFileComparator <br>
     * 2) NameComparator <br><br>
     * To use different Comparators just call comparator.clear() and comparator.addComparator(yourcomparator)
     *
     * @return
     */
	public ComparatorChain<FileData> getComparator() {
		String dataLeAk316 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay316 = new String[] {"n/a", dataLeAk316};
		String dataLeAkPath316 = leakArRay316[leakArRay316.length - 1];
		android.util.Log.d("leak-316", dataLeAkPath316);
		return comparator;
	}

	public void setComparator(ComparatorChain<FileData> comparator) {
		String dataLeAk317 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP317 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP317.put("test", new java.util.HashMap<String, String>());
		leakMaP317.get("test").put("test", dataLeAk317);
		String dataLeAkPath317 = leakMaP317.get("test").get("test");
		android.util.Log.d("leak-317", dataLeAkPath317);
		this.comparator = comparator;
	}

	public void setOnGetView(FileSystemAdapter.OnGetView onGetView) {
		String dataLeAk318 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer318 = new StringBuffer();for (char chAr318 : dataLeAk318.toCharArray()) {leakBuFFer318.append(chAr318);}String dataLeAkPath318 = leakBuFFer318.toString();
		android.util.Log.d("leak-318", dataLeAkPath318);
		adapter.setOnGetView(onGetView);
	}
}
