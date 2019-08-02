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

	String dataLeAk345 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk345 = android.util.Log.d("leak-345", dataLeAk345);

	private FileSystemAdapter adapter;
	private OnDirectoryOrFileClickListener onDirectoryOrFileClickListener;
	private TextView textViewDirectory;
	private TextView textViewFile;
	private ComparatorChain<FileData> comparator;

	public FileListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		String dataLeAk346 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk346 = android.util.Log.d("leak-346", dataLeAk346);
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
		String dataLeAk347 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk347 = android.util.Log.d("leak-347", dataLeAk347);
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
		String dataLeAk348 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk348 = android.util.Log.d("leak-348", dataLeAk348);
		adapter.setPath(path);

		if(!adapter.hasExtentions()) {
			String dataLeAk349 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk349 = android.util.Log.d("leak-349", dataLeAk349);
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
		String dataLeAk350 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk350 = android.util.Log.d("leak-350", dataLeAk350);
		init(null);
	}

	public FileSystemAdapter getAdapter() {
		String dataLeAk351 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk351 = android.util.Log.d("leak-351", dataLeAk351);
		return adapter;
	}

	public void setDefaultFileExtentions() {
		String dataLeAk352 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk352 = android.util.Log.d("leak-352", dataLeAk352);
		adapter.addExtention("folder", R.drawable.folder);
		adapter.addExtention("file", R.drawable.file);
		adapter.addExtention("jpg", R.drawable.image);
		adapter.addExtention("zip", R.drawable.packed);
	}

	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		String dataLeAk353 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk353 = android.util.Log.d("leak-353", dataLeAk353);
		FileData item = (FileData) adapter.getItem(position);
		File file = adapter.move(item.name);

		if (file.isDirectory()) {
			String dataLeAk354 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk354 = android.util.Log.d("leak-354", dataLeAk354);
			if (file.canRead()) {
				String dataLeAk355 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk355 = android.util.Log.d("leak-355", dataLeAk355);
				adapter.showFileSystem();
				if(comparator != null) {
					String dataLeAk356 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk356 = android.util.Log.d("leak-356", dataLeAk356);
					adapter.sort(comparator);
				}
			}
		}
		updateUI(file);
	}

	private void updateUI(File file) {
		String dataLeAk357 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk357 = android.util.Log.d("leak-357", dataLeAk357);
		if(onDirectoryOrFileClickListener != null) {
			String dataLeAk358 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk358 = android.util.Log.d("leak-358", dataLeAk358);
			onDirectoryOrFileClickListener.onDirectoryOrFileClick(file);
		}

		if(textViewDirectory != null) {
			String dataLeAk359 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk359 = android.util.Log.d("leak-359", dataLeAk359);
			if(file.isDirectory()) {
				String dataLeAk360 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk360 = android.util.Log.d("leak-360", dataLeAk360);
				textViewDirectory.setText(file.getPath());
			} else {
				String dataLeAk361 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk361 = android.util.Log.d("leak-361", dataLeAk361);
				textViewDirectory.setText(file.getParent());
			}
		}
		if(textViewFile != null) {
			String dataLeAk362 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk362 = android.util.Log.d("leak-362", dataLeAk362);
			if(file.isFile()) {
				String dataLeAk363 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk363 = android.util.Log.d("leak-363", dataLeAk363);
				textViewFile.setText(file.getName());
			} else {
				String dataLeAk364 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk364 = android.util.Log.d("leak-364", dataLeAk364);
				textViewFile.setText("");
			}
		}
	}

	public void setTextViewDirectory(TextView textView) {
		String dataLeAk365 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk365 = android.util.Log.d("leak-365", dataLeAk365);
		this.textViewDirectory = textView;
	}

	public void setTextViewFile(TextView textView) {
		String dataLeAk366 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk366 = android.util.Log.d("leak-366", dataLeAk366);
		this.textViewFile = textView;
	}

	public void setOnDirectoryOrFileClickListener(OnDirectoryOrFileClickListener listener) {
		String dataLeAk367 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk367 = android.util.Log.d("leak-367", dataLeAk367);
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
		String dataLeAk368 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk368 = android.util.Log.d("leak-368", dataLeAk368);
		return comparator;
	}

	public void setComparator(ComparatorChain<FileData> comparator) {
		String dataLeAk369 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk369 = android.util.Log.d("leak-369", dataLeAk369);
		this.comparator = comparator;
	}

	public void setOnGetView(FileSystemAdapter.OnGetView onGetView) {
		String dataLeAk370 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk370 = android.util.Log.d("leak-370", dataLeAk370);
		adapter.setOnGetView(onGetView);
	}
}
