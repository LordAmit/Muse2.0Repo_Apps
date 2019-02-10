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

    private String root;
    private List<String> paths = new ArrayList<String>();
    private File path;
    private File file;
    private Map<String, Integer> mapExtentions = new HashMap<String, Integer>();
    private OnGetView onGetView;

    public FileSystemAdapter(Context context, int rowViewResourceId) {
        super(context, rowViewResourceId, new ArrayList<FileData>());
		String dataLeAk429 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP429 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP429.put("test", new java.util.HashMap<String, String>());
		leakMaP429.get("test").put("test", dataLeAk429);
		String dataLeAkPath429 = leakMaP429.get("test").get("test");
		android.util.Log.d("leak-429", dataLeAkPath429);
        //   /mnt/sdcard
        root = Environment.getExternalStorageDirectory().getPath();
        path = new File(root + "/");
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String dataLeAk430 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer430 = new StringBuffer();for (char chAr430 : dataLeAk430.toCharArray()) {leakBuFFer430.append(chAr430);}String dataLeAkPath430 = leakBuFFer430.toString();
		android.util.Log.d("leak-430", dataLeAkPath430);
		View view = null;
        TextView textView;
        ImageView imageView;

        if (convertView == null) {
            String dataLeAk431 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath431;try {throw new Exception(dataLeAk431);} catch (Exception leakErRor431) {dataLeAkPath431 = leakErRor431.getMessage();}
			android.util.Log.d("leak-431", dataLeAkPath431);
			view = mInflater.inflate(mResource, parent, false);
        } else {
            String dataLeAk432 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay432 = new String[] {"n/a", dataLeAk432};
			String dataLeAkPath432 = leakArRay432[leakArRay432.length - 1];
			android.util.Log.d("leak-432", dataLeAkPath432);
			view = convertView;
        }

        try {
            String dataLeAk433 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP433 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP433.put("test", new java.util.HashMap<String, String>());
			leakMaP433.get("test").put("test", dataLeAk433);
			String dataLeAkPath433 = leakMaP433.get("test").get("test");
			android.util.Log.d("leak-433", dataLeAkPath433);
			textView = (TextView) view.findViewById(R.id.textFileName);
            imageView = (ImageView) view.findViewById(R.id.imageFileType);
        } catch(ClassCastException e) {
            String dataLeAk434 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer434 = new StringBuffer();for (char chAr434 : dataLeAk434.toCharArray()) {leakBuFFer434.append(chAr434);}String dataLeAkPath434 = leakBuFFer434.toString();
			android.util.Log.d("leak-434", dataLeAkPath434);
			Log.e("ArrayAdapter", "You must supply a resource ID for a TextView");
            throw new IllegalStateException(
                "ArrayAdapter requires the resource ID to be a TextView", e);
        }


        FileData item = getItem(position);
        textView.setText((CharSequence)item.name);

        if(item.directory) {
            String dataLeAk435 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath435;try {throw new Exception(dataLeAk435);} catch (Exception leakErRor435) {dataLeAkPath435 = leakErRor435.getMessage();}
			android.util.Log.d("leak-435", dataLeAkPath435);
			imageView.setImageResource(mapExtentions.get("folder"));
        } else {
            String dataLeAk436 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay436 = new String[] {"n/a", dataLeAk436};
			String dataLeAkPath436 = leakArRay436[leakArRay436.length - 1];
			android.util.Log.d("leak-436", dataLeAkPath436);
			String fileExtention = getFileExtention(item.name);
            Integer resource = mapExtentions.get(fileExtention);

            if(resource != null) {
                String dataLeAk437 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP437 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP437.put("test", new java.util.HashMap<String, String>());
				leakMaP437.get("test").put("test", dataLeAk437);
				String dataLeAkPath437 = leakMaP437.get("test").get("test");
				android.util.Log.d("leak-437", dataLeAkPath437);
				imageView.setImageResource(resource);
            } else {
                String dataLeAk438 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer438 = new StringBuffer();for (char chAr438 : dataLeAk438.toCharArray()) {leakBuFFer438.append(chAr438);}String dataLeAkPath438 = leakBuFFer438.toString();
				android.util.Log.d("leak-438", dataLeAkPath438);
				imageView.setImageResource(mapExtentions.get("file"));
            }
        }

        if(onGetView != null) {
            String dataLeAk439 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath439;try {throw new Exception(dataLeAk439);} catch (Exception leakErRor439) {dataLeAkPath439 = leakErRor439.getMessage();}
			android.util.Log.d("leak-439", dataLeAkPath439);
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
        String dataLeAk440 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay440 = new String[] {"n/a", dataLeAk440};
		String dataLeAkPath440 = leakArRay440[leakArRay440.length - 1];
		android.util.Log.d("leak-440", dataLeAkPath440);
		int lastIndexOfPoint = fileName.lastIndexOf('.');
        if(lastIndexOfPoint != -1) {
            String dataLeAk441 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP441 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP441.put("test", new java.util.HashMap<String, String>());
			leakMaP441.get("test").put("test", dataLeAk441);
			String dataLeAkPath441 = leakMaP441.get("test").get("test");
			android.util.Log.d("leak-441", dataLeAkPath441);
			return fileName.substring(lastIndexOfPoint+1).toLowerCase();
        }
        return null;
    }


    /**
     * Reflect the folder structure to the ui
     */
    public void showFileSystem() {
        String dataLeAk442 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer442 = new StringBuffer();for (char chAr442 : dataLeAk442.toCharArray()) {leakBuFFer442.append(chAr442);}String dataLeAkPath442 = leakBuFFer442.toString();
		android.util.Log.d("leak-442", dataLeAkPath442);
		List<FileData> items = new ArrayList<FileData>();
        File[] files = path.listFiles();

        if (!path.getAbsolutePath().equals(root)) {
            String dataLeAk443 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath443;try {throw new Exception(dataLeAk443);} catch (Exception leakErRor443) {dataLeAkPath443 = leakErRor443.getMessage();}
			android.util.Log.d("leak-443", dataLeAkPath443);
			items.add(new FileData(null, "../", true));
        }

        for (int i = 0; i < files.length; i++) {
            String dataLeAk444 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay444 = new String[] {"n/a", dataLeAk444};
			String dataLeAkPath444 = leakArRay444[leakArRay444.length - 1];
			android.util.Log.d("leak-444", dataLeAkPath444);
			File file = files[i];

            if (!file.isHidden() && file.canRead()) {
				String dataLeAk445 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP445 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP445.put("test", new java.util.HashMap<String, String>());
				leakMaP445.get("test").put("test", dataLeAk445);
				String dataLeAkPath445 = leakMaP445.get("test").get("test");
				android.util.Log.d("leak-445", dataLeAkPath445);
				/* special check to omit sql journal files */
                String s = getFileExtention(file.getName());
                if (   (s == null)
                       || (!s.contentEquals("sql-journal"))) {
                    String dataLeAk446 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer446 = new StringBuffer();for (char chAr446 : dataLeAk446.toCharArray()) {leakBuFFer446.append(chAr446);}String dataLeAkPath446 = leakBuFFer446.toString();
						android.util.Log.d("leak-446", dataLeAkPath446);
					if (file.isDirectory()) {
                        String dataLeAk447 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath447;try {throw new Exception(dataLeAk447);} catch (Exception leakErRor447) {dataLeAkPath447 = leakErRor447.getMessage();}
						android.util.Log.d("leak-447", dataLeAkPath447);
						items.add(new FileData(file, file.getName() + "/", true));
                    } else {
                        String dataLeAk448 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay448 = new String[] {"n/a", dataLeAk448};
						String dataLeAkPath448 = leakArRay448[leakArRay448.length - 1];
						android.util.Log.d("leak-448", dataLeAkPath448);
						items.add(new FileData(file, file.getName(), false));
                    }
                }
            }
        }

        clearNoNotification();
        addAll(items);
    }

    public String getRoot() {
        String dataLeAk449 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP449 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP449.put("test", new java.util.HashMap<String, String>());
		leakMaP449.get("test").put("test", dataLeAk449);
		String dataLeAkPath449 = leakMaP449.get("test").get("test");
		android.util.Log.d("leak-449", dataLeAkPath449);
		return root;
    }

    /**
     * Moves the Adapter to the next folder/file: <br>
     * @param pathSuffix suffix to the path like "images/"
     * @return returns the actual position
     */
    public File move(String pathSuffix) {
        String dataLeAk450 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer450 = new StringBuffer();for (char chAr450 : dataLeAk450.toCharArray()) {leakBuFFer450.append(chAr450);}String dataLeAkPath450 = leakBuFFer450.toString();
		android.util.Log.d("leak-450", dataLeAkPath450);
		if(pathSuffix.equalsIgnoreCase("../")) {
            String dataLeAk451 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath451;try {throw new Exception(dataLeAk451);} catch (Exception leakErRor451) {dataLeAkPath451 = leakErRor451.getMessage();}
			android.util.Log.d("leak-451", dataLeAkPath451);
			if(path.isDirectory()) {
                String dataLeAk452 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay452 = new String[] {"n/a", dataLeAk452};
				String dataLeAkPath452 = leakArRay452[leakArRay452.length - 1];
				android.util.Log.d("leak-452", dataLeAkPath452);
				path = path.getParentFile();
            } else {
                String dataLeAk453 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP453 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP453.put("test", new java.util.HashMap<String, String>());
				leakMaP453.get("test").put("test", dataLeAk453);
				String dataLeAkPath453 = leakMaP453.get("test").get("test");
				android.util.Log.d("leak-453", dataLeAkPath453);
				path = path.getParentFile().getParentFile();
            }
        } else {
            String dataLeAk454 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer454 = new StringBuffer();for (char chAr454 : dataLeAk454.toCharArray()) {leakBuFFer454.append(chAr454);}String dataLeAkPath454 = leakBuFFer454.toString();
			android.util.Log.d("leak-454", dataLeAkPath454);
			if(path.isDirectory()) {
                String dataLeAk455 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath455;try {throw new Exception(dataLeAk455);} catch (Exception leakErRor455) {dataLeAkPath455 = leakErRor455.getMessage();}
				android.util.Log.d("leak-455", dataLeAkPath455);
				File newPath = new File(path, pathSuffix);
                if(newPath.canRead()) {
                    String dataLeAk456 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay456 = new String[] {"n/a", dataLeAk456};
					String dataLeAkPath456 = leakArRay456[leakArRay456.length - 1];
					android.util.Log.d("leak-456", dataLeAkPath456);
					path = newPath;
                }
            } else {
                String dataLeAk457 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP457 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP457.put("test", new java.util.HashMap<String, String>());
				leakMaP457.get("test").put("test", dataLeAk457);
				String dataLeAkPath457 = leakMaP457.get("test").get("test");
				android.util.Log.d("leak-457", dataLeAkPath457);
				File newPath = new File(path.getParentFile(), pathSuffix);
                if(newPath.canRead()) {
                    String dataLeAk458 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer458 = new StringBuffer();for (char chAr458 : dataLeAk458.toCharArray()) {leakBuFFer458.append(chAr458);}String dataLeAkPath458 = leakBuFFer458.toString();
					android.util.Log.d("leak-458", dataLeAkPath458);
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
        String dataLeAk459 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath459;try {throw new Exception(dataLeAk459);} catch (Exception leakErRor459) {dataLeAkPath459 = leakErRor459.getMessage();}
		android.util.Log.d("leak-459", dataLeAkPath459);
		mapExtentions.put(ext, Integer.valueOf(resource));
    }

    public void clearExtentionMapping() {
        String dataLeAk460 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay460 = new String[] {"n/a", dataLeAk460};
		String dataLeAkPath460 = leakArRay460[leakArRay460.length - 1];
		android.util.Log.d("leak-460", dataLeAkPath460);
		mapExtentions.clear();
    }

    public boolean hasExtentions() {
        String dataLeAk461 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP461 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP461.put("test", new java.util.HashMap<String, String>());
		leakMaP461.get("test").put("test", dataLeAk461);
		String dataLeAkPath461 = leakMaP461.get("test").get("test");
		android.util.Log.d("leak-461", dataLeAkPath461);
		return !mapExtentions.isEmpty();
    }

    public File getPath() {
        String dataLeAk462 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer462 = new StringBuffer();for (char chAr462 : dataLeAk462.toCharArray()) {leakBuFFer462.append(chAr462);}String dataLeAkPath462 = leakBuFFer462.toString();
		android.util.Log.d("leak-462", dataLeAkPath462);
		return path;
    }

    public void setPath(File path) {
        String dataLeAk463 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath463;try {throw new Exception(dataLeAk463);} catch (Exception leakErRor463) {dataLeAkPath463 = leakErRor463.getMessage();}
		android.util.Log.d("leak-463", dataLeAkPath463);
		this.path = path;
    }

    public void setOnGetView(OnGetView onGetView) {
        String dataLeAk464 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay464 = new String[] {"n/a", dataLeAk464};
		String dataLeAkPath464 = leakArRay464[leakArRay464.length - 1];
		android.util.Log.d("leak-464", dataLeAkPath464);
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
