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

	String dataLeAk179 = "";

	String dataLeAk178 = "";

	String dataLeAk177 = "";

	String dataLeAk176 = "";

	String dataLeAk175 = "";

	String dataLeAk174 = "";

	String dataLeAk173 = "";

	String dataLeAk172 = "";

	String dataLeAk171 = "";

	String dataLeAk170 = "";

	String dataLeAk169 = "";

	String dataLeAk168 = "";

	String dataLeAk167 = "";

	String dataLeAk166 = "";

	private FileSystemAdapter adapter;
	private OnDirectoryOrFileClickListener onDirectoryOrFileClickListener;
	private TextView textViewDirectory;
	private TextView textViewFile;
	private ComparatorChain<FileData> comparator;

	public FileListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		dataLeAk166 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-166-0", dataLeAk166);
		android.util.Log.d("leak-167-0", dataLeAk167);
		android.util.Log.d("leak-168-0", dataLeAk168);
		android.util.Log.d("leak-169-0", dataLeAk169);
		android.util.Log.d("leak-170-0", dataLeAk170);
		android.util.Log.d("leak-171-0", dataLeAk171);
		android.util.Log.d("leak-172-0", dataLeAk172);
		android.util.Log.d("leak-173-0", dataLeAk173);
		android.util.Log.d("leak-174-0", dataLeAk174);
		android.util.Log.d("leak-175-0", dataLeAk175);
		android.util.Log.d("leak-176-0", dataLeAk176);
		android.util.Log.d("leak-177-0", dataLeAk177);
		android.util.Log.d("leak-178-0", dataLeAk178);
		android.util.Log.d("leak-179-0", dataLeAk179);
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
		dataLeAk167 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-166-1", dataLeAk166);
		android.util.Log.d("leak-167-1", dataLeAk167);
		android.util.Log.d("leak-168-1", dataLeAk168);
		android.util.Log.d("leak-169-1", dataLeAk169);
		android.util.Log.d("leak-170-1", dataLeAk170);
		android.util.Log.d("leak-171-1", dataLeAk171);
		android.util.Log.d("leak-172-1", dataLeAk172);
		android.util.Log.d("leak-173-1", dataLeAk173);
		android.util.Log.d("leak-174-1", dataLeAk174);
		android.util.Log.d("leak-175-1", dataLeAk175);
		android.util.Log.d("leak-176-1", dataLeAk176);
		android.util.Log.d("leak-177-1", dataLeAk177);
		android.util.Log.d("leak-178-1", dataLeAk178);
		android.util.Log.d("leak-179-1", dataLeAk179);
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
		dataLeAk168 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-166-2", dataLeAk166);
		android.util.Log.d("leak-167-2", dataLeAk167);
		android.util.Log.d("leak-168-2", dataLeAk168);
		android.util.Log.d("leak-169-2", dataLeAk169);
		android.util.Log.d("leak-170-2", dataLeAk170);
		android.util.Log.d("leak-171-2", dataLeAk171);
		android.util.Log.d("leak-172-2", dataLeAk172);
		android.util.Log.d("leak-173-2", dataLeAk173);
		android.util.Log.d("leak-174-2", dataLeAk174);
		android.util.Log.d("leak-175-2", dataLeAk175);
		android.util.Log.d("leak-176-2", dataLeAk176);
		android.util.Log.d("leak-177-2", dataLeAk177);
		android.util.Log.d("leak-178-2", dataLeAk178);
		android.util.Log.d("leak-179-2", dataLeAk179);
		adapter.setPath(path);

		if(!adapter.hasExtentions()) {
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
		dataLeAk169 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-166-3", dataLeAk166);
		android.util.Log.d("leak-167-3", dataLeAk167);
		android.util.Log.d("leak-168-3", dataLeAk168);
		android.util.Log.d("leak-169-3", dataLeAk169);
		android.util.Log.d("leak-170-3", dataLeAk170);
		android.util.Log.d("leak-171-3", dataLeAk171);
		android.util.Log.d("leak-172-3", dataLeAk172);
		android.util.Log.d("leak-173-3", dataLeAk173);
		android.util.Log.d("leak-174-3", dataLeAk174);
		android.util.Log.d("leak-175-3", dataLeAk175);
		android.util.Log.d("leak-176-3", dataLeAk176);
		android.util.Log.d("leak-177-3", dataLeAk177);
		android.util.Log.d("leak-178-3", dataLeAk178);
		android.util.Log.d("leak-179-3", dataLeAk179);
		init(null);
	}

	public FileSystemAdapter getAdapter() {
		dataLeAk170 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-166-4", dataLeAk166);
		android.util.Log.d("leak-167-4", dataLeAk167);
		android.util.Log.d("leak-168-4", dataLeAk168);
		android.util.Log.d("leak-169-4", dataLeAk169);
		android.util.Log.d("leak-170-4", dataLeAk170);
		android.util.Log.d("leak-171-4", dataLeAk171);
		android.util.Log.d("leak-172-4", dataLeAk172);
		android.util.Log.d("leak-173-4", dataLeAk173);
		android.util.Log.d("leak-174-4", dataLeAk174);
		android.util.Log.d("leak-175-4", dataLeAk175);
		android.util.Log.d("leak-176-4", dataLeAk176);
		android.util.Log.d("leak-177-4", dataLeAk177);
		android.util.Log.d("leak-178-4", dataLeAk178);
		android.util.Log.d("leak-179-4", dataLeAk179);
		return adapter;
	}

	public void setDefaultFileExtentions() {
		dataLeAk171 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-166-5", dataLeAk166);
		android.util.Log.d("leak-167-5", dataLeAk167);
		android.util.Log.d("leak-168-5", dataLeAk168);
		android.util.Log.d("leak-169-5", dataLeAk169);
		android.util.Log.d("leak-170-5", dataLeAk170);
		android.util.Log.d("leak-171-5", dataLeAk171);
		android.util.Log.d("leak-172-5", dataLeAk172);
		android.util.Log.d("leak-173-5", dataLeAk173);
		android.util.Log.d("leak-174-5", dataLeAk174);
		android.util.Log.d("leak-175-5", dataLeAk175);
		android.util.Log.d("leak-176-5", dataLeAk176);
		android.util.Log.d("leak-177-5", dataLeAk177);
		android.util.Log.d("leak-178-5", dataLeAk178);
		android.util.Log.d("leak-179-5", dataLeAk179);
		adapter.addExtention("folder", R.drawable.folder);
		adapter.addExtention("file", R.drawable.file);
		adapter.addExtention("jpg", R.drawable.image);
		adapter.addExtention("zip", R.drawable.packed);
	}

	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		dataLeAk172 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-166-6", dataLeAk166);
		android.util.Log.d("leak-167-6", dataLeAk167);
		android.util.Log.d("leak-168-6", dataLeAk168);
		android.util.Log.d("leak-169-6", dataLeAk169);
		android.util.Log.d("leak-170-6", dataLeAk170);
		android.util.Log.d("leak-171-6", dataLeAk171);
		android.util.Log.d("leak-172-6", dataLeAk172);
		android.util.Log.d("leak-173-6", dataLeAk173);
		android.util.Log.d("leak-174-6", dataLeAk174);
		android.util.Log.d("leak-175-6", dataLeAk175);
		android.util.Log.d("leak-176-6", dataLeAk176);
		android.util.Log.d("leak-177-6", dataLeAk177);
		android.util.Log.d("leak-178-6", dataLeAk178);
		android.util.Log.d("leak-179-6", dataLeAk179);
		FileData item = (FileData) adapter.getItem(position);
		File file = adapter.move(item.name);

		if (file.isDirectory()) {
			if (file.canRead()) {
				adapter.showFileSystem();
				if(comparator != null) {
					adapter.sort(comparator);
				}
			}
		}
		updateUI(file);
	}

	private void updateUI(File file) {
		dataLeAk173 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-166-7", dataLeAk166);
		android.util.Log.d("leak-167-7", dataLeAk167);
		android.util.Log.d("leak-168-7", dataLeAk168);
		android.util.Log.d("leak-169-7", dataLeAk169);
		android.util.Log.d("leak-170-7", dataLeAk170);
		android.util.Log.d("leak-171-7", dataLeAk171);
		android.util.Log.d("leak-172-7", dataLeAk172);
		android.util.Log.d("leak-173-7", dataLeAk173);
		android.util.Log.d("leak-174-7", dataLeAk174);
		android.util.Log.d("leak-175-7", dataLeAk175);
		android.util.Log.d("leak-176-7", dataLeAk176);
		android.util.Log.d("leak-177-7", dataLeAk177);
		android.util.Log.d("leak-178-7", dataLeAk178);
		android.util.Log.d("leak-179-7", dataLeAk179);
		if(onDirectoryOrFileClickListener != null) {
			onDirectoryOrFileClickListener.onDirectoryOrFileClick(file);
		}

		if(textViewDirectory != null) {
			if(file.isDirectory()) {
				textViewDirectory.setText(file.getPath());
			} else {
				textViewDirectory.setText(file.getParent());
			}
		}
		if(textViewFile != null) {
			if(file.isFile()) {
				textViewFile.setText(file.getName());
			} else {
				textViewFile.setText("");
			}
		}
	}

	public void setTextViewDirectory(TextView textView) {
		dataLeAk174 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-166-8", dataLeAk166);
		android.util.Log.d("leak-167-8", dataLeAk167);
		android.util.Log.d("leak-168-8", dataLeAk168);
		android.util.Log.d("leak-169-8", dataLeAk169);
		android.util.Log.d("leak-170-8", dataLeAk170);
		android.util.Log.d("leak-171-8", dataLeAk171);
		android.util.Log.d("leak-172-8", dataLeAk172);
		android.util.Log.d("leak-173-8", dataLeAk173);
		android.util.Log.d("leak-174-8", dataLeAk174);
		android.util.Log.d("leak-175-8", dataLeAk175);
		android.util.Log.d("leak-176-8", dataLeAk176);
		android.util.Log.d("leak-177-8", dataLeAk177);
		android.util.Log.d("leak-178-8", dataLeAk178);
		android.util.Log.d("leak-179-8", dataLeAk179);
		this.textViewDirectory = textView;
	}

	public void setTextViewFile(TextView textView) {
		dataLeAk175 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-166-9", dataLeAk166);
		android.util.Log.d("leak-167-9", dataLeAk167);
		android.util.Log.d("leak-168-9", dataLeAk168);
		android.util.Log.d("leak-169-9", dataLeAk169);
		android.util.Log.d("leak-170-9", dataLeAk170);
		android.util.Log.d("leak-171-9", dataLeAk171);
		android.util.Log.d("leak-172-9", dataLeAk172);
		android.util.Log.d("leak-173-9", dataLeAk173);
		android.util.Log.d("leak-174-9", dataLeAk174);
		android.util.Log.d("leak-175-9", dataLeAk175);
		android.util.Log.d("leak-176-9", dataLeAk176);
		android.util.Log.d("leak-177-9", dataLeAk177);
		android.util.Log.d("leak-178-9", dataLeAk178);
		android.util.Log.d("leak-179-9", dataLeAk179);
		this.textViewFile = textView;
	}

	public void setOnDirectoryOrFileClickListener(OnDirectoryOrFileClickListener listener) {
		dataLeAk176 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-166-10", dataLeAk166);
		android.util.Log.d("leak-167-10", dataLeAk167);
		android.util.Log.d("leak-168-10", dataLeAk168);
		android.util.Log.d("leak-169-10", dataLeAk169);
		android.util.Log.d("leak-170-10", dataLeAk170);
		android.util.Log.d("leak-171-10", dataLeAk171);
		android.util.Log.d("leak-172-10", dataLeAk172);
		android.util.Log.d("leak-173-10", dataLeAk173);
		android.util.Log.d("leak-174-10", dataLeAk174);
		android.util.Log.d("leak-175-10", dataLeAk175);
		android.util.Log.d("leak-176-10", dataLeAk176);
		android.util.Log.d("leak-177-10", dataLeAk177);
		android.util.Log.d("leak-178-10", dataLeAk178);
		android.util.Log.d("leak-179-10", dataLeAk179);
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
		dataLeAk177 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-166-11", dataLeAk166);
		android.util.Log.d("leak-167-11", dataLeAk167);
		android.util.Log.d("leak-168-11", dataLeAk168);
		android.util.Log.d("leak-169-11", dataLeAk169);
		android.util.Log.d("leak-170-11", dataLeAk170);
		android.util.Log.d("leak-171-11", dataLeAk171);
		android.util.Log.d("leak-172-11", dataLeAk172);
		android.util.Log.d("leak-173-11", dataLeAk173);
		android.util.Log.d("leak-174-11", dataLeAk174);
		android.util.Log.d("leak-175-11", dataLeAk175);
		android.util.Log.d("leak-176-11", dataLeAk176);
		android.util.Log.d("leak-177-11", dataLeAk177);
		android.util.Log.d("leak-178-11", dataLeAk178);
		android.util.Log.d("leak-179-11", dataLeAk179);
		return comparator;
	}

	public void setComparator(ComparatorChain<FileData> comparator) {
		dataLeAk178 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-166-12", dataLeAk166);
		android.util.Log.d("leak-167-12", dataLeAk167);
		android.util.Log.d("leak-168-12", dataLeAk168);
		android.util.Log.d("leak-169-12", dataLeAk169);
		android.util.Log.d("leak-170-12", dataLeAk170);
		android.util.Log.d("leak-171-12", dataLeAk171);
		android.util.Log.d("leak-172-12", dataLeAk172);
		android.util.Log.d("leak-173-12", dataLeAk173);
		android.util.Log.d("leak-174-12", dataLeAk174);
		android.util.Log.d("leak-175-12", dataLeAk175);
		android.util.Log.d("leak-176-12", dataLeAk176);
		android.util.Log.d("leak-177-12", dataLeAk177);
		android.util.Log.d("leak-178-12", dataLeAk178);
		android.util.Log.d("leak-179-12", dataLeAk179);
		this.comparator = comparator;
	}

	public void setOnGetView(FileSystemAdapter.OnGetView onGetView) {
		dataLeAk179 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-166-13", dataLeAk166);
		android.util.Log.d("leak-167-13", dataLeAk167);
		android.util.Log.d("leak-168-13", dataLeAk168);
		android.util.Log.d("leak-169-13", dataLeAk169);
		android.util.Log.d("leak-170-13", dataLeAk170);
		android.util.Log.d("leak-171-13", dataLeAk171);
		android.util.Log.d("leak-172-13", dataLeAk172);
		android.util.Log.d("leak-173-13", dataLeAk173);
		android.util.Log.d("leak-174-13", dataLeAk174);
		android.util.Log.d("leak-175-13", dataLeAk175);
		android.util.Log.d("leak-176-13", dataLeAk176);
		android.util.Log.d("leak-177-13", dataLeAk177);
		android.util.Log.d("leak-178-13", dataLeAk178);
		android.util.Log.d("leak-179-13", dataLeAk179);
		adapter.setOnGetView(onGetView);
	}
}
