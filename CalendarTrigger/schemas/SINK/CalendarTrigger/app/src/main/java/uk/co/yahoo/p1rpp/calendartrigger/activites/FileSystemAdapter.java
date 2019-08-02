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

    String dataLeAk306 = "";

	String dataLeAk305 = "";

	String dataLeAk304 = "";

	String dataLeAk303 = "";

	String dataLeAk302 = "";

	String dataLeAk301 = "";

	String dataLeAk300 = "";

	String dataLeAk299 = "";

	String dataLeAk298 = "";

	String dataLeAk297 = "";

	String dataLeAk296 = "";

	String dataLeAk295 = "";

	private String root;
    private List<String> paths = new ArrayList<String>();
    private File path;
    private File file;
    private Map<String, Integer> mapExtentions = new HashMap<String, Integer>();
    private OnGetView onGetView;

    public FileSystemAdapter(Context context, int rowViewResourceId) {
        super(context, rowViewResourceId, new ArrayList<FileData>());
		dataLeAk295 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-295-0", dataLeAk295);
		android.util.Log.d("leak-296-0", dataLeAk296);
		android.util.Log.d("leak-297-0", dataLeAk297);
		android.util.Log.d("leak-298-0", dataLeAk298);
		android.util.Log.d("leak-299-0", dataLeAk299);
		android.util.Log.d("leak-300-0", dataLeAk300);
		android.util.Log.d("leak-301-0", dataLeAk301);
		android.util.Log.d("leak-302-0", dataLeAk302);
		android.util.Log.d("leak-303-0", dataLeAk303);
		android.util.Log.d("leak-304-0", dataLeAk304);
		android.util.Log.d("leak-305-0", dataLeAk305);
		android.util.Log.d("leak-306-0", dataLeAk306);
        //   /mnt/sdcard
        root = Environment.getExternalStorageDirectory().getPath();
        path = new File(root + "/");
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        dataLeAk296 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-295-1", dataLeAk295);
		android.util.Log.d("leak-296-1", dataLeAk296);
		android.util.Log.d("leak-297-1", dataLeAk297);
		android.util.Log.d("leak-298-1", dataLeAk298);
		android.util.Log.d("leak-299-1", dataLeAk299);
		android.util.Log.d("leak-300-1", dataLeAk300);
		android.util.Log.d("leak-301-1", dataLeAk301);
		android.util.Log.d("leak-302-1", dataLeAk302);
		android.util.Log.d("leak-303-1", dataLeAk303);
		android.util.Log.d("leak-304-1", dataLeAk304);
		android.util.Log.d("leak-305-1", dataLeAk305);
		android.util.Log.d("leak-306-1", dataLeAk306);
		View view = null;
        TextView textView;
        ImageView imageView;

        if (convertView == null) {
            view = mInflater.inflate(mResource, parent, false);
        } else {
            view = convertView;
        }

        try {
            textView = (TextView) view.findViewById(R.id.textFileName);
            imageView = (ImageView) view.findViewById(R.id.imageFileType);
        } catch(ClassCastException e) {
            Log.e("ArrayAdapter", "You must supply a resource ID for a TextView");
            throw new IllegalStateException(
                "ArrayAdapter requires the resource ID to be a TextView", e);
        }


        FileData item = getItem(position);
        textView.setText((CharSequence)item.name);

        if(item.directory) {
            imageView.setImageResource(mapExtentions.get("folder"));
        } else {
            String fileExtention = getFileExtention(item.name);
            Integer resource = mapExtentions.get(fileExtention);

            if(resource != null) {
                imageView.setImageResource(resource);
            } else {
                imageView.setImageResource(mapExtentions.get("file"));
            }
        }

        if(onGetView != null) {
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
        dataLeAk297 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-295-2", dataLeAk295);
		android.util.Log.d("leak-296-2", dataLeAk296);
		android.util.Log.d("leak-297-2", dataLeAk297);
		android.util.Log.d("leak-298-2", dataLeAk298);
		android.util.Log.d("leak-299-2", dataLeAk299);
		android.util.Log.d("leak-300-2", dataLeAk300);
		android.util.Log.d("leak-301-2", dataLeAk301);
		android.util.Log.d("leak-302-2", dataLeAk302);
		android.util.Log.d("leak-303-2", dataLeAk303);
		android.util.Log.d("leak-304-2", dataLeAk304);
		android.util.Log.d("leak-305-2", dataLeAk305);
		android.util.Log.d("leak-306-2", dataLeAk306);
		int lastIndexOfPoint = fileName.lastIndexOf('.');
        if(lastIndexOfPoint != -1) {
            return fileName.substring(lastIndexOfPoint+1).toLowerCase();
        }
        return null;
    }


    /**
     * Reflect the folder structure to the ui
     */
    public void showFileSystem() {
        dataLeAk298 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-295-3", dataLeAk295);
		android.util.Log.d("leak-296-3", dataLeAk296);
		android.util.Log.d("leak-297-3", dataLeAk297);
		android.util.Log.d("leak-298-3", dataLeAk298);
		android.util.Log.d("leak-299-3", dataLeAk299);
		android.util.Log.d("leak-300-3", dataLeAk300);
		android.util.Log.d("leak-301-3", dataLeAk301);
		android.util.Log.d("leak-302-3", dataLeAk302);
		android.util.Log.d("leak-303-3", dataLeAk303);
		android.util.Log.d("leak-304-3", dataLeAk304);
		android.util.Log.d("leak-305-3", dataLeAk305);
		android.util.Log.d("leak-306-3", dataLeAk306);
		List<FileData> items = new ArrayList<FileData>();
        File[] files = path.listFiles();

        if (!path.getAbsolutePath().equals(root)) {
            items.add(new FileData(null, "../", true));
        }

        for (int i = 0; i < files.length; i++) {
            File file = files[i];

            if (!file.isHidden() && file.canRead()) {
				/* special check to omit sql journal files */
                String s = getFileExtention(file.getName());
                if (   (s == null)
                       || (!s.contentEquals("sql-journal"))) {
                    if (file.isDirectory()) {
                        items.add(new FileData(file, file.getName() + "/", true));
                    } else {
                        items.add(new FileData(file, file.getName(), false));
                    }
                }
            }
        }

        clearNoNotification();
        addAll(items);
    }

    public String getRoot() {
        dataLeAk299 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-295-4", dataLeAk295);
		android.util.Log.d("leak-296-4", dataLeAk296);
		android.util.Log.d("leak-297-4", dataLeAk297);
		android.util.Log.d("leak-298-4", dataLeAk298);
		android.util.Log.d("leak-299-4", dataLeAk299);
		android.util.Log.d("leak-300-4", dataLeAk300);
		android.util.Log.d("leak-301-4", dataLeAk301);
		android.util.Log.d("leak-302-4", dataLeAk302);
		android.util.Log.d("leak-303-4", dataLeAk303);
		android.util.Log.d("leak-304-4", dataLeAk304);
		android.util.Log.d("leak-305-4", dataLeAk305);
		android.util.Log.d("leak-306-4", dataLeAk306);
		return root;
    }

    /**
     * Moves the Adapter to the next folder/file: <br>
     * @param pathSuffix suffix to the path like "images/"
     * @return returns the actual position
     */
    public File move(String pathSuffix) {
        dataLeAk300 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-295-5", dataLeAk295);
		android.util.Log.d("leak-296-5", dataLeAk296);
		android.util.Log.d("leak-297-5", dataLeAk297);
		android.util.Log.d("leak-298-5", dataLeAk298);
		android.util.Log.d("leak-299-5", dataLeAk299);
		android.util.Log.d("leak-300-5", dataLeAk300);
		android.util.Log.d("leak-301-5", dataLeAk301);
		android.util.Log.d("leak-302-5", dataLeAk302);
		android.util.Log.d("leak-303-5", dataLeAk303);
		android.util.Log.d("leak-304-5", dataLeAk304);
		android.util.Log.d("leak-305-5", dataLeAk305);
		android.util.Log.d("leak-306-5", dataLeAk306);
		if(pathSuffix.equalsIgnoreCase("../")) {
            if(path.isDirectory()) {
                path = path.getParentFile();
            } else {
                path = path.getParentFile().getParentFile();
            }
        } else {
            if(path.isDirectory()) {
                File newPath = new File(path, pathSuffix);
                if(newPath.canRead()) {
                    path = newPath;
                }
            } else {
                File newPath = new File(path.getParentFile(), pathSuffix);
                if(newPath.canRead()) {
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
        dataLeAk301 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-295-6", dataLeAk295);
		android.util.Log.d("leak-296-6", dataLeAk296);
		android.util.Log.d("leak-297-6", dataLeAk297);
		android.util.Log.d("leak-298-6", dataLeAk298);
		android.util.Log.d("leak-299-6", dataLeAk299);
		android.util.Log.d("leak-300-6", dataLeAk300);
		android.util.Log.d("leak-301-6", dataLeAk301);
		android.util.Log.d("leak-302-6", dataLeAk302);
		android.util.Log.d("leak-303-6", dataLeAk303);
		android.util.Log.d("leak-304-6", dataLeAk304);
		android.util.Log.d("leak-305-6", dataLeAk305);
		android.util.Log.d("leak-306-6", dataLeAk306);
		mapExtentions.put(ext, Integer.valueOf(resource));
    }

    public void clearExtentionMapping() {
        dataLeAk302 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-295-7", dataLeAk295);
		android.util.Log.d("leak-296-7", dataLeAk296);
		android.util.Log.d("leak-297-7", dataLeAk297);
		android.util.Log.d("leak-298-7", dataLeAk298);
		android.util.Log.d("leak-299-7", dataLeAk299);
		android.util.Log.d("leak-300-7", dataLeAk300);
		android.util.Log.d("leak-301-7", dataLeAk301);
		android.util.Log.d("leak-302-7", dataLeAk302);
		android.util.Log.d("leak-303-7", dataLeAk303);
		android.util.Log.d("leak-304-7", dataLeAk304);
		android.util.Log.d("leak-305-7", dataLeAk305);
		android.util.Log.d("leak-306-7", dataLeAk306);
		mapExtentions.clear();
    }

    public boolean hasExtentions() {
        dataLeAk303 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-295-8", dataLeAk295);
		android.util.Log.d("leak-296-8", dataLeAk296);
		android.util.Log.d("leak-297-8", dataLeAk297);
		android.util.Log.d("leak-298-8", dataLeAk298);
		android.util.Log.d("leak-299-8", dataLeAk299);
		android.util.Log.d("leak-300-8", dataLeAk300);
		android.util.Log.d("leak-301-8", dataLeAk301);
		android.util.Log.d("leak-302-8", dataLeAk302);
		android.util.Log.d("leak-303-8", dataLeAk303);
		android.util.Log.d("leak-304-8", dataLeAk304);
		android.util.Log.d("leak-305-8", dataLeAk305);
		android.util.Log.d("leak-306-8", dataLeAk306);
		return !mapExtentions.isEmpty();
    }

    public File getPath() {
        dataLeAk304 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-295-9", dataLeAk295);
		android.util.Log.d("leak-296-9", dataLeAk296);
		android.util.Log.d("leak-297-9", dataLeAk297);
		android.util.Log.d("leak-298-9", dataLeAk298);
		android.util.Log.d("leak-299-9", dataLeAk299);
		android.util.Log.d("leak-300-9", dataLeAk300);
		android.util.Log.d("leak-301-9", dataLeAk301);
		android.util.Log.d("leak-302-9", dataLeAk302);
		android.util.Log.d("leak-303-9", dataLeAk303);
		android.util.Log.d("leak-304-9", dataLeAk304);
		android.util.Log.d("leak-305-9", dataLeAk305);
		android.util.Log.d("leak-306-9", dataLeAk306);
		return path;
    }

    public void setPath(File path) {
        dataLeAk305 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-295-10", dataLeAk295);
		android.util.Log.d("leak-296-10", dataLeAk296);
		android.util.Log.d("leak-297-10", dataLeAk297);
		android.util.Log.d("leak-298-10", dataLeAk298);
		android.util.Log.d("leak-299-10", dataLeAk299);
		android.util.Log.d("leak-300-10", dataLeAk300);
		android.util.Log.d("leak-301-10", dataLeAk301);
		android.util.Log.d("leak-302-10", dataLeAk302);
		android.util.Log.d("leak-303-10", dataLeAk303);
		android.util.Log.d("leak-304-10", dataLeAk304);
		android.util.Log.d("leak-305-10", dataLeAk305);
		android.util.Log.d("leak-306-10", dataLeAk306);
		this.path = path;
    }

    public void setOnGetView(OnGetView onGetView) {
        dataLeAk306 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-295-11", dataLeAk295);
		android.util.Log.d("leak-296-11", dataLeAk296);
		android.util.Log.d("leak-297-11", dataLeAk297);
		android.util.Log.d("leak-298-11", dataLeAk298);
		android.util.Log.d("leak-299-11", dataLeAk299);
		android.util.Log.d("leak-300-11", dataLeAk300);
		android.util.Log.d("leak-301-11", dataLeAk301);
		android.util.Log.d("leak-302-11", dataLeAk302);
		android.util.Log.d("leak-303-11", dataLeAk303);
		android.util.Log.d("leak-304-11", dataLeAk304);
		android.util.Log.d("leak-305-11", dataLeAk305);
		android.util.Log.d("leak-306-11", dataLeAk306);
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
