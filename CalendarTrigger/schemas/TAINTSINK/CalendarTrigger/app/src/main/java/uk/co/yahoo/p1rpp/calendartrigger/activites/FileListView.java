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

	String dataLeAk172 = "172";

	String dataLeAk171 = "171";

	String dataLeAk170 = "170";

	String dataLeAk169 = "169";

	String dataLeAk167 = "167";

	String dataLeAk166 = "166";

	String dataLeAk165 = "165";

	String dataLeAk164 = "164";

	String dataLeAk163 = "163";

	String dataLeAk162 = "162";

	String dataLeAk161 = "161";

	String dataLeAk160 = "160";

	String dataLeAk159 = "159";

	String dataLeAk158 = "158";

	private FileSystemAdapter adapter;
	private OnDirectoryOrFileClickListener onDirectoryOrFileClickListener;
	private TextView textViewDirectory;
	private TextView textViewFile;
	private ComparatorChain<FileData> comparator;

	public FileListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		android.util.Log.d("leak-158-90", dataLeAk158);
		android.util.Log.d("leak-159-90", dataLeAk159);
		android.util.Log.d("leak-160-90", dataLeAk160);
		android.util.Log.d("leak-161-90", dataLeAk161);
		android.util.Log.d("leak-162-90", dataLeAk162);
		android.util.Log.d("leak-163-90", dataLeAk163);
		android.util.Log.d("leak-164-90", dataLeAk164);
		android.util.Log.d("leak-165-90", dataLeAk165);
		android.util.Log.d("leak-166-90", dataLeAk166);
		android.util.Log.d("leak-167-90", dataLeAk167);
		android.util.Log.d("leak-169-90", dataLeAk169);
		android.util.Log.d("leak-170-90", dataLeAk170);
		android.util.Log.d("leak-171-90", dataLeAk171);
		android.util.Log.d("leak-172-90", dataLeAk172);
		dataLeAk158 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
		dataLeAk159 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-158-91", dataLeAk158);
		android.util.Log.d("leak-159-91", dataLeAk159);
		android.util.Log.d("leak-160-91", dataLeAk160);
		android.util.Log.d("leak-161-91", dataLeAk161);
		android.util.Log.d("leak-162-91", dataLeAk162);
		android.util.Log.d("leak-163-91", dataLeAk163);
		android.util.Log.d("leak-164-91", dataLeAk164);
		android.util.Log.d("leak-165-91", dataLeAk165);
		android.util.Log.d("leak-166-91", dataLeAk166);
		android.util.Log.d("leak-167-91", dataLeAk167);
		android.util.Log.d("leak-169-91", dataLeAk169);
		android.util.Log.d("leak-170-91", dataLeAk170);
		android.util.Log.d("leak-171-91", dataLeAk171);
		android.util.Log.d("leak-172-91", dataLeAk172);
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
		dataLeAk160 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-158-92", dataLeAk158);
		android.util.Log.d("leak-159-92", dataLeAk159);
		android.util.Log.d("leak-160-92", dataLeAk160);
		android.util.Log.d("leak-161-92", dataLeAk161);
		android.util.Log.d("leak-162-92", dataLeAk162);
		android.util.Log.d("leak-163-92", dataLeAk163);
		android.util.Log.d("leak-164-92", dataLeAk164);
		android.util.Log.d("leak-165-92", dataLeAk165);
		android.util.Log.d("leak-166-92", dataLeAk166);
		android.util.Log.d("leak-167-92", dataLeAk167);
		android.util.Log.d("leak-169-92", dataLeAk169);
		android.util.Log.d("leak-170-92", dataLeAk170);
		android.util.Log.d("leak-171-92", dataLeAk171);
		android.util.Log.d("leak-172-92", dataLeAk172);
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
		dataLeAk161 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-158-93", dataLeAk158);
		android.util.Log.d("leak-159-93", dataLeAk159);
		android.util.Log.d("leak-160-93", dataLeAk160);
		android.util.Log.d("leak-161-93", dataLeAk161);
		android.util.Log.d("leak-162-93", dataLeAk162);
		android.util.Log.d("leak-163-93", dataLeAk163);
		android.util.Log.d("leak-164-93", dataLeAk164);
		android.util.Log.d("leak-165-93", dataLeAk165);
		android.util.Log.d("leak-166-93", dataLeAk166);
		android.util.Log.d("leak-167-93", dataLeAk167);
		android.util.Log.d("leak-169-93", dataLeAk169);
		android.util.Log.d("leak-170-93", dataLeAk170);
		android.util.Log.d("leak-171-93", dataLeAk171);
		android.util.Log.d("leak-172-93", dataLeAk172);
		init(null);
	}

	public FileSystemAdapter getAdapter() {
		dataLeAk162 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-158-94", dataLeAk158);
		android.util.Log.d("leak-159-94", dataLeAk159);
		android.util.Log.d("leak-160-94", dataLeAk160);
		android.util.Log.d("leak-161-94", dataLeAk161);
		android.util.Log.d("leak-162-94", dataLeAk162);
		android.util.Log.d("leak-163-94", dataLeAk163);
		android.util.Log.d("leak-164-94", dataLeAk164);
		android.util.Log.d("leak-165-94", dataLeAk165);
		android.util.Log.d("leak-166-94", dataLeAk166);
		android.util.Log.d("leak-167-94", dataLeAk167);
		android.util.Log.d("leak-169-94", dataLeAk169);
		android.util.Log.d("leak-170-94", dataLeAk170);
		android.util.Log.d("leak-171-94", dataLeAk171);
		android.util.Log.d("leak-172-94", dataLeAk172);
		return adapter;
	}

	public void setDefaultFileExtentions() {
		dataLeAk163 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-158-95", dataLeAk158);
		android.util.Log.d("leak-159-95", dataLeAk159);
		android.util.Log.d("leak-160-95", dataLeAk160);
		android.util.Log.d("leak-161-95", dataLeAk161);
		android.util.Log.d("leak-162-95", dataLeAk162);
		android.util.Log.d("leak-163-95", dataLeAk163);
		android.util.Log.d("leak-164-95", dataLeAk164);
		android.util.Log.d("leak-165-95", dataLeAk165);
		android.util.Log.d("leak-166-95", dataLeAk166);
		android.util.Log.d("leak-167-95", dataLeAk167);
		android.util.Log.d("leak-169-95", dataLeAk169);
		android.util.Log.d("leak-170-95", dataLeAk170);
		android.util.Log.d("leak-171-95", dataLeAk171);
		android.util.Log.d("leak-172-95", dataLeAk172);
		adapter.addExtention("folder", R.drawable.folder);
		adapter.addExtention("file", R.drawable.file);
		adapter.addExtention("jpg", R.drawable.image);
		adapter.addExtention("zip", R.drawable.packed);
	}

	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		dataLeAk164 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-158-96", dataLeAk158);
		android.util.Log.d("leak-159-96", dataLeAk159);
		android.util.Log.d("leak-160-96", dataLeAk160);
		android.util.Log.d("leak-161-96", dataLeAk161);
		android.util.Log.d("leak-162-96", dataLeAk162);
		android.util.Log.d("leak-163-96", dataLeAk163);
		android.util.Log.d("leak-164-96", dataLeAk164);
		android.util.Log.d("leak-165-96", dataLeAk165);
		android.util.Log.d("leak-166-96", dataLeAk166);
		android.util.Log.d("leak-167-96", dataLeAk167);
		android.util.Log.d("leak-169-96", dataLeAk169);
		android.util.Log.d("leak-170-96", dataLeAk170);
		android.util.Log.d("leak-171-96", dataLeAk171);
		android.util.Log.d("leak-172-96", dataLeAk172);
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
		if(onDirectoryOrFileClickListener != null) {
			onDirectoryOrFileClickListener.onDirectoryOrFileClick(file);
		}
		android.util.Log.d("leak-158-97", dataLeAk158);
		android.util.Log.d("leak-159-97", dataLeAk159);
		android.util.Log.d("leak-160-97", dataLeAk160);
		android.util.Log.d("leak-161-97", dataLeAk161);
		android.util.Log.d("leak-162-97", dataLeAk162);
		android.util.Log.d("leak-163-97", dataLeAk163);
		android.util.Log.d("leak-164-97", dataLeAk164);
		android.util.Log.d("leak-165-97", dataLeAk165);
		android.util.Log.d("leak-166-97", dataLeAk166);
		android.util.Log.d("leak-167-97", dataLeAk167);
		android.util.Log.d("leak-169-97", dataLeAk169);
		android.util.Log.d("leak-170-97", dataLeAk170);
		android.util.Log.d("leak-171-97", dataLeAk171);
		android.util.Log.d("leak-172-97", dataLeAk172);

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
		dataLeAk165 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-158-98", dataLeAk158);
		android.util.Log.d("leak-159-98", dataLeAk159);
		android.util.Log.d("leak-160-98", dataLeAk160);
		android.util.Log.d("leak-161-98", dataLeAk161);
		android.util.Log.d("leak-162-98", dataLeAk162);
		android.util.Log.d("leak-163-98", dataLeAk163);
		android.util.Log.d("leak-164-98", dataLeAk164);
		android.util.Log.d("leak-165-98", dataLeAk165);
		android.util.Log.d("leak-166-98", dataLeAk166);
		android.util.Log.d("leak-167-98", dataLeAk167);
		android.util.Log.d("leak-169-98", dataLeAk169);
		android.util.Log.d("leak-170-98", dataLeAk170);
		android.util.Log.d("leak-171-98", dataLeAk171);
		android.util.Log.d("leak-172-98", dataLeAk172);
		this.textViewDirectory = textView;
	}

	public void setTextViewFile(TextView textView) {
		dataLeAk166 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-158-99", dataLeAk158);
		android.util.Log.d("leak-159-99", dataLeAk159);
		android.util.Log.d("leak-160-99", dataLeAk160);
		android.util.Log.d("leak-161-99", dataLeAk161);
		android.util.Log.d("leak-162-99", dataLeAk162);
		android.util.Log.d("leak-163-99", dataLeAk163);
		android.util.Log.d("leak-164-99", dataLeAk164);
		android.util.Log.d("leak-165-99", dataLeAk165);
		android.util.Log.d("leak-166-99", dataLeAk166);
		android.util.Log.d("leak-167-99", dataLeAk167);
		android.util.Log.d("leak-169-99", dataLeAk169);
		android.util.Log.d("leak-170-99", dataLeAk170);
		android.util.Log.d("leak-171-99", dataLeAk171);
		android.util.Log.d("leak-172-99", dataLeAk172);
		this.textViewFile = textView;
	}

	public void setOnDirectoryOrFileClickListener(OnDirectoryOrFileClickListener listener) {
		dataLeAk167 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-158-100", dataLeAk158);
		android.util.Log.d("leak-159-100", dataLeAk159);
		android.util.Log.d("leak-160-100", dataLeAk160);
		android.util.Log.d("leak-161-100", dataLeAk161);
		android.util.Log.d("leak-162-100", dataLeAk162);
		android.util.Log.d("leak-163-100", dataLeAk163);
		android.util.Log.d("leak-164-100", dataLeAk164);
		android.util.Log.d("leak-165-100", dataLeAk165);
		android.util.Log.d("leak-166-100", dataLeAk166);
		android.util.Log.d("leak-167-100", dataLeAk167);
		android.util.Log.d("leak-169-100", dataLeAk169);
		android.util.Log.d("leak-170-100", dataLeAk170);
		android.util.Log.d("leak-171-100", dataLeAk171);
		android.util.Log.d("leak-172-100", dataLeAk172);
		onDirectoryOrFileClickListener = listener;
	}

	/**
     * Interface definition for a callback to be invoked when an directory or file has been clicked.
     */
    public interface OnDirectoryOrFileClickListener {

        String dataLeAk168 = "168";

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
		dataLeAk170 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-158-102", dataLeAk158);
		android.util.Log.d("leak-159-102", dataLeAk159);
		android.util.Log.d("leak-160-102", dataLeAk160);
		android.util.Log.d("leak-161-102", dataLeAk161);
		android.util.Log.d("leak-162-102", dataLeAk162);
		android.util.Log.d("leak-163-102", dataLeAk163);
		android.util.Log.d("leak-164-102", dataLeAk164);
		android.util.Log.d("leak-165-102", dataLeAk165);
		android.util.Log.d("leak-166-102", dataLeAk166);
		android.util.Log.d("leak-167-102", dataLeAk167);
		android.util.Log.d("leak-169-102", dataLeAk169);
		android.util.Log.d("leak-170-102", dataLeAk170);
		android.util.Log.d("leak-171-102", dataLeAk171);
		android.util.Log.d("leak-172-102", dataLeAk172);
		return comparator;
	}

	public void setComparator(ComparatorChain<FileData> comparator) {
		dataLeAk171 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-158-103", dataLeAk158);
		android.util.Log.d("leak-159-103", dataLeAk159);
		android.util.Log.d("leak-160-103", dataLeAk160);
		android.util.Log.d("leak-161-103", dataLeAk161);
		android.util.Log.d("leak-162-103", dataLeAk162);
		android.util.Log.d("leak-163-103", dataLeAk163);
		android.util.Log.d("leak-164-103", dataLeAk164);
		android.util.Log.d("leak-165-103", dataLeAk165);
		android.util.Log.d("leak-166-103", dataLeAk166);
		android.util.Log.d("leak-167-103", dataLeAk167);
		android.util.Log.d("leak-169-103", dataLeAk169);
		android.util.Log.d("leak-170-103", dataLeAk170);
		android.util.Log.d("leak-171-103", dataLeAk171);
		android.util.Log.d("leak-172-103", dataLeAk172);
		this.comparator = comparator;
	}

	public void setOnGetView(FileSystemAdapter.OnGetView onGetView) {
		dataLeAk172 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-158-104", dataLeAk158);
		android.util.Log.d("leak-159-104", dataLeAk159);
		android.util.Log.d("leak-160-104", dataLeAk160);
		android.util.Log.d("leak-161-104", dataLeAk161);
		android.util.Log.d("leak-162-104", dataLeAk162);
		android.util.Log.d("leak-163-104", dataLeAk163);
		android.util.Log.d("leak-164-104", dataLeAk164);
		android.util.Log.d("leak-165-104", dataLeAk165);
		android.util.Log.d("leak-166-104", dataLeAk166);
		android.util.Log.d("leak-167-104", dataLeAk167);
		android.util.Log.d("leak-169-104", dataLeAk169);
		android.util.Log.d("leak-170-104", dataLeAk170);
		android.util.Log.d("leak-171-104", dataLeAk171);
		android.util.Log.d("leak-172-104", dataLeAk172);
		adapter.setOnGetView(onGetView);
	}
}
