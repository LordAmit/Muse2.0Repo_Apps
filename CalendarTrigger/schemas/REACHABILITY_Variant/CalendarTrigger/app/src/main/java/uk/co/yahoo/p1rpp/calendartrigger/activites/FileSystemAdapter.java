/*
 * Copyright (c) 2017. Richard P. Parkins, M. A.
 */

package uk.co.yahoo.p1rpp.calendartrigger.activites;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uk.co.yahoo.p1rpp.calendartrigger.R;

/**
 *
 *
 *
 * @author strangeoptics
 *
 */
public class FileSystemAdapter extends ArrayAdapter<FileData> {

    String dataLeAk535 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk535 = android.util.Log.d("leak-535", dataLeAk535);

	private String root;
    private List<String> paths = new ArrayList<String>();
    private File path;
    private File file;
    private Map<String, Integer> mapExtentions = new HashMap<String, Integer>();
    private OnGetView onGetView;

    public FileSystemAdapter(Context context, int rowViewResourceId) {
        super(context, rowViewResourceId, new ArrayList<FileData>());
		String dataLeAk536 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk536 = android.util.Log.d("leak-536", dataLeAk536);
        //   /mnt/sdcard
        root = Environment.getExternalStorageDirectory().getPath();
        path = new File(root + "/");
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String dataLeAk537 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk537 = android.util.Log.d("leak-537", dataLeAk537);
		View view = null;
        TextView textView;
        ImageView imageView;

        if (convertView == null) {
            String dataLeAk538 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk538 = android.util.Log.d("leak-538", dataLeAk538);
			view = mInflater.inflate(mResource, parent, false);
        } else {
            String dataLeAk539 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk539 = android.util.Log.d("leak-539", dataLeAk539);
			view = convertView;
        }

        try {
            String dataLeAk540 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk540 = android.util.Log.d("leak-540", dataLeAk540);
			textView = (TextView) view.findViewById(R.id.textFileName);
            imageView = (ImageView) view.findViewById(R.id.imageFileType);
        } catch(ClassCastException e) {
            String dataLeAk541 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk541 = android.util.Log.d("leak-541", dataLeAk541);
			Log.e("ArrayAdapter", "You must supply a resource ID for a TextView");
            throw new IllegalStateException(
                "ArrayAdapter requires the resource ID to be a TextView", e);
        }


        FileData item = getItem(position);
        textView.setText((CharSequence)item.name);

        if(item.directory) {
            String dataLeAk542 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk542 = android.util.Log.d("leak-542", dataLeAk542);
			imageView.setImageResource(mapExtentions.get("folder"));
        } else {
            String dataLeAk543 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk543 = android.util.Log.d("leak-543", dataLeAk543);
			String fileExtention = getFileExtention(item.name);
            Integer resource = mapExtentions.get(fileExtention);

            if(resource != null) {
                String dataLeAk544 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk544 = android.util.Log.d("leak-544", dataLeAk544);
				imageView.setImageResource(resource);
            } else {
                String dataLeAk545 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk545 = android.util.Log.d("leak-545", dataLeAk545);
				imageView.setImageResource(mapExtentions.get("file"));
            }
        }

        if(onGetView != null) {
            String dataLeAk546 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk546 = android.util.Log.d("leak-546", dataLeAk546);
			onGetView.onGetView(position, convertView, parent, item);
        }

        return view;
    }

    /**
     * Primitive extraction of the file extention in lower case. <br>
     * file.ext -> ext <br>
     * If there is no '.' in the file name, null is returned!
     * @param fileName
     * @return extention or null
     */
    private String getFileExtention(String fileName) {
        String dataLeAk547 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk547 = android.util.Log.d("leak-547", dataLeAk547);
		int lastIndexOfPoint = fileName.lastIndexOf('.');
        if(lastIndexOfPoint != -1) {
            String dataLeAk548 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk548 = android.util.Log.d("leak-548", dataLeAk548);
			return fileName.substring(lastIndexOfPoint+1).toLowerCase();
        }
        return null;
    }


    /**
     * Reflect the folder structure to the ui
     */
    public void showFileSystem() {
        String dataLeAk549 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk549 = android.util.Log.d("leak-549", dataLeAk549);
		List<FileData> items = new ArrayList<FileData>();
        File[] files = path.listFiles();

        if (!path.getAbsolutePath().equals(root)) {
            String dataLeAk550 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk550 = android.util.Log.d("leak-550", dataLeAk550);
			items.add(new FileData(null, "../", true));
        }

        for (int i = 0; i < files.length; i++) {
            String dataLeAk551 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk551 = android.util.Log.d("leak-551", dataLeAk551);
			File file = files[i];

            if (!file.isHidden() && file.canRead()) {
				String dataLeAk552 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk552 = android.util.Log.d("leak-552", dataLeAk552);
				/* special check to omit sql journal files */
                String s = getFileExtention(file.getName());
                if (   (s == null)
                       || (!s.contentEquals("sql-journal"))) {
                    String dataLeAk553 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk553 = android.util.Log.d("leak-553", dataLeAk553);
					if (file.isDirectory()) {
                        String dataLeAk554 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk554 = android.util.Log.d("leak-554", dataLeAk554);
						items.add(new FileData(file, file.getName() + "/", true));
                    } else {
                        String dataLeAk555 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk555 = android.util.Log.d("leak-555", dataLeAk555);
						items.add(new FileData(file, file.getName(), false));
                    }
                }
            }
        }

        clearNoNotification();
        addAll(items);
    }

    public String getRoot() {
        String dataLeAk556 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk556 = android.util.Log.d("leak-556", dataLeAk556);
		return root;
    }

    /**
     * Moves the Adapter to the next folder/file: <br>
     * @param pathSuffix suffix to the path like "images/"
     * @return returns the actual position
     */
    public File move(String pathSuffix) {
        String dataLeAk557 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk557 = android.util.Log.d("leak-557", dataLeAk557);
		if(pathSuffix.equalsIgnoreCase("../")) {
            String dataLeAk558 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk558 = android.util.Log.d("leak-558", dataLeAk558);
			if(path.isDirectory()) {
                String dataLeAk559 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk559 = android.util.Log.d("leak-559", dataLeAk559);
				path = path.getParentFile();
            } else {
                String dataLeAk560 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk560 = android.util.Log.d("leak-560", dataLeAk560);
				path = path.getParentFile().getParentFile();
            }
        } else {
            String dataLeAk561 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk561 = android.util.Log.d("leak-561", dataLeAk561);
			if(path.isDirectory()) {
                String dataLeAk562 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk562 = android.util.Log.d("leak-562", dataLeAk562);
				File newPath = new File(path, pathSuffix);
                if(newPath.canRead()) {
                    String dataLeAk563 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk563 = android.util.Log.d("leak-563", dataLeAk563);
					path = newPath;
                }
            } else {
                String dataLeAk564 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk564 = android.util.Log.d("leak-564", dataLeAk564);
				File newPath = new File(path.getParentFile(), pathSuffix);
                if(newPath.canRead()) {
                    String dataLeAk565 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk565 = android.util.Log.d("leak-565", dataLeAk565);
					path = newPath;
                }
            }
        }

        return path;
    }

    /**
     *
     * @param ext in lower case without a point e.g. "zip"
     * @param resource R.drawable.xxx
     */
    public void addExtention(String ext, int resource) {
        String dataLeAk566 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk566 = android.util.Log.d("leak-566", dataLeAk566);
		mapExtentions.put(ext, Integer.valueOf(resource));
    }

    public void clearExtentionMapping() {
        String dataLeAk567 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk567 = android.util.Log.d("leak-567", dataLeAk567);
		mapExtentions.clear();
    }

    public boolean hasExtentions() {
        String dataLeAk568 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk568 = android.util.Log.d("leak-568", dataLeAk568);
		return !mapExtentions.isEmpty();
    }

    public File getPath() {
        String dataLeAk569 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk569 = android.util.Log.d("leak-569", dataLeAk569);
		return path;
    }

    public void setPath(File path) {
        String dataLeAk570 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk570 = android.util.Log.d("leak-570", dataLeAk570);
		this.path = path;
    }

    public void setOnGetView(OnGetView onGetView) {
        String dataLeAk571 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk571 = android.util.Log.d("leak-571", dataLeAk571);
		this.onGetView = onGetView;
    }

    /**
     * Interface definition for a callback to be invoked when the getView()-Method of the Adapter is called.
     */
    public interface OnGetView {

        /**
         * Callback method to be invoked when the getView()-Method of the Adapter is called.
         */
        void onGetView(int position, View convertView, ViewGroup paren, FileData item);
    }
}
