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

    String dataLeAk297 = "297";

	String dataLeAk295 = "295";

	String dataLeAk294 = "294";

	String dataLeAk293 = "293";

	String dataLeAk292 = "292";

	String dataLeAk291 = "291";

	String dataLeAk290 = "290";

	String dataLeAk289 = "289";

	String dataLeAk288 = "288";

	String dataLeAk287 = "287";

	String dataLeAk286 = "286";

	String dataLeAk285 = "285";

	private String root;
    private List<String> paths = new ArrayList<String>();
    private File path;
    private File file;
    private Map<String, Integer> mapExtentions = new HashMap<String, Integer>();
    private OnGetView onGetView;

    public FileSystemAdapter(Context context, int rowViewResourceId) {
        super(context, rowViewResourceId, new ArrayList<FileData>());
		android.util.Log.d("leak-285-116", dataLeAk285);
		android.util.Log.d("leak-286-116", dataLeAk286);
		android.util.Log.d("leak-287-116", dataLeAk287);
		android.util.Log.d("leak-288-116", dataLeAk288);
		android.util.Log.d("leak-289-116", dataLeAk289);
		android.util.Log.d("leak-290-116", dataLeAk290);
		android.util.Log.d("leak-291-116", dataLeAk291);
		android.util.Log.d("leak-292-116", dataLeAk292);
		android.util.Log.d("leak-293-116", dataLeAk293);
		android.util.Log.d("leak-294-116", dataLeAk294);
		android.util.Log.d("leak-295-116", dataLeAk295);
		android.util.Log.d("leak-297-116", dataLeAk297);
		dataLeAk285 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        //   /mnt/sdcard
        root = Environment.getExternalStorageDirectory().getPath();
        path = new File(root + "/");
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        dataLeAk286 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-285-117", dataLeAk285);
		android.util.Log.d("leak-286-117", dataLeAk286);
		android.util.Log.d("leak-287-117", dataLeAk287);
		android.util.Log.d("leak-288-117", dataLeAk288);
		android.util.Log.d("leak-289-117", dataLeAk289);
		android.util.Log.d("leak-290-117", dataLeAk290);
		android.util.Log.d("leak-291-117", dataLeAk291);
		android.util.Log.d("leak-292-117", dataLeAk292);
		android.util.Log.d("leak-293-117", dataLeAk293);
		android.util.Log.d("leak-294-117", dataLeAk294);
		android.util.Log.d("leak-295-117", dataLeAk295);
		android.util.Log.d("leak-297-117", dataLeAk297);
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
        int lastIndexOfPoint = fileName.lastIndexOf('.');
		android.util.Log.d("leak-285-118", dataLeAk285);
		android.util.Log.d("leak-286-118", dataLeAk286);
		android.util.Log.d("leak-287-118", dataLeAk287);
		android.util.Log.d("leak-288-118", dataLeAk288);
		android.util.Log.d("leak-289-118", dataLeAk289);
		android.util.Log.d("leak-290-118", dataLeAk290);
		android.util.Log.d("leak-291-118", dataLeAk291);
		android.util.Log.d("leak-292-118", dataLeAk292);
		android.util.Log.d("leak-293-118", dataLeAk293);
		android.util.Log.d("leak-294-118", dataLeAk294);
		android.util.Log.d("leak-295-118", dataLeAk295);
		android.util.Log.d("leak-297-118", dataLeAk297);
        if(lastIndexOfPoint != -1) {
            return fileName.substring(lastIndexOfPoint+1).toLowerCase();
        }
        return null;
    }


    /**
     * Reflect the folder structure to the ui
     */
    public void showFileSystem() {
        dataLeAk287 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-285-119", dataLeAk285);
		android.util.Log.d("leak-286-119", dataLeAk286);
		android.util.Log.d("leak-287-119", dataLeAk287);
		android.util.Log.d("leak-288-119", dataLeAk288);
		android.util.Log.d("leak-289-119", dataLeAk289);
		android.util.Log.d("leak-290-119", dataLeAk290);
		android.util.Log.d("leak-291-119", dataLeAk291);
		android.util.Log.d("leak-292-119", dataLeAk292);
		android.util.Log.d("leak-293-119", dataLeAk293);
		android.util.Log.d("leak-294-119", dataLeAk294);
		android.util.Log.d("leak-295-119", dataLeAk295);
		android.util.Log.d("leak-297-119", dataLeAk297);
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
        dataLeAk288 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-285-120", dataLeAk285);
		android.util.Log.d("leak-286-120", dataLeAk286);
		android.util.Log.d("leak-287-120", dataLeAk287);
		android.util.Log.d("leak-288-120", dataLeAk288);
		android.util.Log.d("leak-289-120", dataLeAk289);
		android.util.Log.d("leak-290-120", dataLeAk290);
		android.util.Log.d("leak-291-120", dataLeAk291);
		android.util.Log.d("leak-292-120", dataLeAk292);
		android.util.Log.d("leak-293-120", dataLeAk293);
		android.util.Log.d("leak-294-120", dataLeAk294);
		android.util.Log.d("leak-295-120", dataLeAk295);
		android.util.Log.d("leak-297-120", dataLeAk297);
		return root;
    }

    /**
     * Moves the Adapter to the next folder/file: <br>
     * @param pathSuffix suffix to the path like "images/"
     * @return returns the actual position
     */
    public File move(String pathSuffix) {
        dataLeAk289 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-285-121", dataLeAk285);
		android.util.Log.d("leak-286-121", dataLeAk286);
		android.util.Log.d("leak-287-121", dataLeAk287);
		android.util.Log.d("leak-288-121", dataLeAk288);
		android.util.Log.d("leak-289-121", dataLeAk289);
		android.util.Log.d("leak-290-121", dataLeAk290);
		android.util.Log.d("leak-291-121", dataLeAk291);
		android.util.Log.d("leak-292-121", dataLeAk292);
		android.util.Log.d("leak-293-121", dataLeAk293);
		android.util.Log.d("leak-294-121", dataLeAk294);
		android.util.Log.d("leak-295-121", dataLeAk295);
		android.util.Log.d("leak-297-121", dataLeAk297);
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
        dataLeAk290 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-285-122", dataLeAk285);
		android.util.Log.d("leak-286-122", dataLeAk286);
		android.util.Log.d("leak-287-122", dataLeAk287);
		android.util.Log.d("leak-288-122", dataLeAk288);
		android.util.Log.d("leak-289-122", dataLeAk289);
		android.util.Log.d("leak-290-122", dataLeAk290);
		android.util.Log.d("leak-291-122", dataLeAk291);
		android.util.Log.d("leak-292-122", dataLeAk292);
		android.util.Log.d("leak-293-122", dataLeAk293);
		android.util.Log.d("leak-294-122", dataLeAk294);
		android.util.Log.d("leak-295-122", dataLeAk295);
		android.util.Log.d("leak-297-122", dataLeAk297);
		mapExtentions.put(ext, Integer.valueOf(resource));
    }

    public void clearExtentionMapping() {
        dataLeAk291 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-285-123", dataLeAk285);
		android.util.Log.d("leak-286-123", dataLeAk286);
		android.util.Log.d("leak-287-123", dataLeAk287);
		android.util.Log.d("leak-288-123", dataLeAk288);
		android.util.Log.d("leak-289-123", dataLeAk289);
		android.util.Log.d("leak-290-123", dataLeAk290);
		android.util.Log.d("leak-291-123", dataLeAk291);
		android.util.Log.d("leak-292-123", dataLeAk292);
		android.util.Log.d("leak-293-123", dataLeAk293);
		android.util.Log.d("leak-294-123", dataLeAk294);
		android.util.Log.d("leak-295-123", dataLeAk295);
		android.util.Log.d("leak-297-123", dataLeAk297);
		mapExtentions.clear();
    }

    public boolean hasExtentions() {
        dataLeAk292 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-285-124", dataLeAk285);
		android.util.Log.d("leak-286-124", dataLeAk286);
		android.util.Log.d("leak-287-124", dataLeAk287);
		android.util.Log.d("leak-288-124", dataLeAk288);
		android.util.Log.d("leak-289-124", dataLeAk289);
		android.util.Log.d("leak-290-124", dataLeAk290);
		android.util.Log.d("leak-291-124", dataLeAk291);
		android.util.Log.d("leak-292-124", dataLeAk292);
		android.util.Log.d("leak-293-124", dataLeAk293);
		android.util.Log.d("leak-294-124", dataLeAk294);
		android.util.Log.d("leak-295-124", dataLeAk295);
		android.util.Log.d("leak-297-124", dataLeAk297);
		return !mapExtentions.isEmpty();
    }

    public File getPath() {
        dataLeAk293 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-285-125", dataLeAk285);
		android.util.Log.d("leak-286-125", dataLeAk286);
		android.util.Log.d("leak-287-125", dataLeAk287);
		android.util.Log.d("leak-288-125", dataLeAk288);
		android.util.Log.d("leak-289-125", dataLeAk289);
		android.util.Log.d("leak-290-125", dataLeAk290);
		android.util.Log.d("leak-291-125", dataLeAk291);
		android.util.Log.d("leak-292-125", dataLeAk292);
		android.util.Log.d("leak-293-125", dataLeAk293);
		android.util.Log.d("leak-294-125", dataLeAk294);
		android.util.Log.d("leak-295-125", dataLeAk295);
		android.util.Log.d("leak-297-125", dataLeAk297);
		return path;
    }

    public void setPath(File path) {
        dataLeAk294 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-285-126", dataLeAk285);
		android.util.Log.d("leak-286-126", dataLeAk286);
		android.util.Log.d("leak-287-126", dataLeAk287);
		android.util.Log.d("leak-288-126", dataLeAk288);
		android.util.Log.d("leak-289-126", dataLeAk289);
		android.util.Log.d("leak-290-126", dataLeAk290);
		android.util.Log.d("leak-291-126", dataLeAk291);
		android.util.Log.d("leak-292-126", dataLeAk292);
		android.util.Log.d("leak-293-126", dataLeAk293);
		android.util.Log.d("leak-294-126", dataLeAk294);
		android.util.Log.d("leak-295-126", dataLeAk295);
		android.util.Log.d("leak-297-126", dataLeAk297);
		this.path = path;
    }

    public void setOnGetView(OnGetView onGetView) {
        dataLeAk295 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-285-127", dataLeAk285);
		android.util.Log.d("leak-286-127", dataLeAk286);
		android.util.Log.d("leak-287-127", dataLeAk287);
		android.util.Log.d("leak-288-127", dataLeAk288);
		android.util.Log.d("leak-289-127", dataLeAk289);
		android.util.Log.d("leak-290-127", dataLeAk290);
		android.util.Log.d("leak-291-127", dataLeAk291);
		android.util.Log.d("leak-292-127", dataLeAk292);
		android.util.Log.d("leak-293-127", dataLeAk293);
		android.util.Log.d("leak-294-127", dataLeAk294);
		android.util.Log.d("leak-295-127", dataLeAk295);
		android.util.Log.d("leak-297-127", dataLeAk297);
		this.onGetView = onGetView;
    }

    /**
     * Interface definition for a callback to be invoked when the getView()-Method of the Adapter is called.
     */
    public interface OnGetView {

        String dataLeAk296 = "296";

		/**
         * Callback method to be invoked when the getView()-Method of the Adapter is called.
         */
        void onGetView(int position, View convertView, ViewGroup paren, FileData item);
    }
}
