package us.koller.cameraroll.util;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.BaseColumns;
import android.provider.MediaStore;
import android.support.v4.provider.DocumentFile;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.models.AlbumItem;
import us.koller.cameraroll.data.models.StorageRoot;
import us.koller.cameraroll.data.models.Video;

//workarounds to handle removable storage

//heavily inspired by:
//https://github.com/arpitkh96/AmazeFileManager/blob/master/src/main/java/com/amaze/filemanager/filesystem/MediaStoreHack.java
public class StorageUtil {

    public static Uri getContentUri(Context context, String path) {
        String dataLeAk2739 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2739;try {throw new Exception(dataLeAk2739);} catch (Exception leakErRor2739) {dataLeAkPath2739 = leakErRor2739.getMessage();}
		android.util.Log.d("leak-2739", dataLeAkPath2739);
		return getContentUri(context, AlbumItem.getInstance(path));
    }

    public static Uri getContentUri(Context context, AlbumItem albumItem) {
        String dataLeAk2740 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2740 = new String[] {"n/a", dataLeAk2740};
		String dataLeAkPath2740 = leakArRay2740[leakArRay2740.length - 1];
		android.util.Log.d("leak-2740", dataLeAkPath2740);
		Uri uri;
        if (albumItem instanceof Video) {
            String dataLeAk2741 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2741 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2741.put("test", new java.util.HashMap<String, String>());
			leakMaP2741.get("test").put("test", dataLeAk2741);
			String dataLeAkPath2741 = leakMaP2741.get("test").get("test");
			android.util.Log.d("leak-2741", dataLeAkPath2741);
			uri = getContentUriForVideoFromMediaStore(context, albumItem.getPath());
        } else {
            String dataLeAk2742 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2742 = new StringBuffer();for (char chAr2742 : dataLeAk2742.toCharArray()) {leakBuFFer2742.append(chAr2742);}String dataLeAkPath2742 = leakBuFFer2742.toString();
			android.util.Log.d("leak-2742", dataLeAkPath2742);
			uri = getContentUriForImageFromMediaStore(context, albumItem.getPath());
        }
        return uri;
    }

    private static Uri getContentUriForImageFromMediaStore(Context context, String path) {
        String dataLeAk2743 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2743;try {throw new Exception(dataLeAk2743);} catch (Exception leakErRor2743) {dataLeAkPath2743 = leakErRor2743.getMessage();}
		android.util.Log.d("leak-2743", dataLeAkPath2743);
		ContentResolver resolver = context.getContentResolver();
        //Uri photoUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        // to handle hidden images
        Uri photoUri = MediaStore.Files.getContentUri("external");
        Cursor cursor = resolver.query(photoUri,
                new String[]{BaseColumns._ID},
                MediaStore.MediaColumns.DATA + " = ?",
                new String[]{path}, null);
        if (cursor == null) {
            String dataLeAk2744 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2744 = new String[] {"n/a", dataLeAk2744};
			String dataLeAkPath2744 = leakArRay2744[leakArRay2744.length - 1];
			android.util.Log.d("leak-2744", dataLeAkPath2744);
			return Uri.parse(path);
        }
        cursor.moveToFirst();
        if (cursor.isAfterLast()) {
            String dataLeAk2745 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2745 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2745.put("test", new java.util.HashMap<String, String>());
			leakMaP2745.get("test").put("test", dataLeAk2745);
			String dataLeAkPath2745 = leakMaP2745.get("test").get("test");
			android.util.Log.d("leak-2745", dataLeAkPath2745);
			cursor.close();
            // insert system media db
            ContentValues values = new ContentValues();
            values.put(MediaStore.Images.Media.DATA, path);
            values.put(MediaStore.Images.Media.MIME_TYPE, MediaType.getMimeType(path));
            return context.getContentResolver().insert(photoUri, values);
        } else {
            String dataLeAk2746 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2746 = new StringBuffer();for (char chAr2746 : dataLeAk2746.toCharArray()) {leakBuFFer2746.append(chAr2746);}String dataLeAkPath2746 = leakBuFFer2746.toString();
			android.util.Log.d("leak-2746", dataLeAkPath2746);
			long id = cursor.getLong(cursor.getColumnIndex(BaseColumns._ID));
            Uri uri = ContentUris.withAppendedId(photoUri, id);
            cursor.close();
            return uri;
        }
    }

    private static Uri getContentUriForVideoFromMediaStore(Context context, String path) {
        String dataLeAk2747 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2747;try {throw new Exception(dataLeAk2747);} catch (Exception leakErRor2747) {dataLeAkPath2747 = leakErRor2747.getMessage();}
		android.util.Log.d("leak-2747", dataLeAkPath2747);
		ContentResolver resolver = context.getContentResolver();
        //Uri videoUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        // to handle hidden videos
        Uri videoUri = MediaStore.Files.getContentUri("external");
        Cursor cursor = resolver.query(videoUri,
                new String[]{BaseColumns._ID},
                MediaStore.MediaColumns.DATA + " = ?",
                new String[]{path}, null);

        if (cursor == null) {
            String dataLeAk2748 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2748 = new String[] {"n/a", dataLeAk2748};
			String dataLeAkPath2748 = leakArRay2748[leakArRay2748.length - 1];
			android.util.Log.d("leak-2748", dataLeAkPath2748);
			return Uri.parse(path);
        }
        cursor.moveToFirst();
        if (cursor.isAfterLast()) {
            String dataLeAk2749 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2749 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2749.put("test", new java.util.HashMap<String, String>());
			leakMaP2749.get("test").put("test", dataLeAk2749);
			String dataLeAkPath2749 = leakMaP2749.get("test").get("test");
			android.util.Log.d("leak-2749", dataLeAkPath2749);
			cursor.close();
            // insert system media db
            ContentValues values = new ContentValues();
            values.put(MediaStore.Video.Media.DATA, path);
            values.put(MediaStore.Video.Media.MIME_TYPE, MediaType.getMimeType(path));
            return context.getContentResolver().insert(videoUri, values);
        } else {
            String dataLeAk2750 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2750 = new StringBuffer();for (char chAr2750 : dataLeAk2750.toCharArray()) {leakBuFFer2750.append(chAr2750);}String dataLeAkPath2750 = leakBuFFer2750.toString();
			android.util.Log.d("leak-2750", dataLeAkPath2750);
			int imageId = cursor.getInt(cursor.getColumnIndex(BaseColumns._ID));
            Uri uri = ContentUris.withAppendedId(videoUri, imageId);
            cursor.close();
            return uri;
        }
    }

    public static StorageRoot[] loadRoots(Activity context) {
        String dataLeAk2751 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2751;try {throw new Exception(dataLeAk2751);} catch (Exception leakErRor2751) {dataLeAkPath2751 = leakErRor2751.getMessage();}
		android.util.Log.d("leak-2751", dataLeAkPath2751);
		ArrayList<StorageRoot> temp = new ArrayList<>();

        StorageRoot externalStorage = new StorageRoot(
                Environment.getExternalStorageDirectory().getPath());
        externalStorage.setName(context.getString(R.string.storage));
        temp.add(externalStorage);

        File[] removableStorageRoots = getRemovableStorageRoots(context);
        for (int i = 0; i < removableStorageRoots.length; i++) {
            String dataLeAk2752 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2752 = new String[] {"n/a", dataLeAk2752};
			String dataLeAkPath2752 = leakArRay2752[leakArRay2752.length - 1];
			android.util.Log.d("leak-2752", dataLeAkPath2752);
			temp.add(new StorageRoot(removableStorageRoots[i].getPath()));
        }

        StorageRoot[] roots = new StorageRoot[temp.size()];
        return temp.toArray(roots);
    }

    public static File[] getRemovableStorageRoots(Context context) {
        String dataLeAk2753 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2753 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2753.put("test", new java.util.HashMap<String, String>());
		leakMaP2753.get("test").put("test", dataLeAk2753);
		String dataLeAkPath2753 = leakMaP2753.get("test").get("test");
		android.util.Log.d("leak-2753", dataLeAkPath2753);
		File[] roots = context.getExternalFilesDirs("external");
        ArrayList<File> rootsArrayList = new ArrayList<>();

        for (int i = 0; i < roots.length; i++) {
            String dataLeAk2754 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2754 = new StringBuffer();for (char chAr2754 : dataLeAk2754.toCharArray()) {leakBuFFer2754.append(chAr2754);}String dataLeAkPath2754 = leakBuFFer2754.toString();
			android.util.Log.d("leak-2754", dataLeAkPath2754);
			if (roots[i] != null) {
                String dataLeAk2755 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath2755;try {throw new Exception(dataLeAk2755);} catch (Exception leakErRor2755) {dataLeAkPath2755 = leakErRor2755.getMessage();}
				android.util.Log.d("leak-2755", dataLeAkPath2755);
				String path = roots[i].getPath();
                int index = path.lastIndexOf("/Android/data/");
                if (index > 0) {
                    String dataLeAk2756 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay2756 = new String[] {"n/a", dataLeAk2756};
					String dataLeAkPath2756 = leakArRay2756[leakArRay2756.length - 1];
					android.util.Log.d("leak-2756", dataLeAkPath2756);
					path = path.substring(0, index);
                    if (!path.equals(Environment.getExternalStorageDirectory().getPath())) {
                        String dataLeAk2757 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2757 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP2757.put("test", new java.util.HashMap<String, String>());
						leakMaP2757.get("test").put("test", dataLeAk2757);
						String dataLeAkPath2757 = leakMaP2757.get("test").get("test");
						android.util.Log.d("leak-2757", dataLeAkPath2757);
						rootsArrayList.add(new File(path));
                    }
                }
            }
        }

        roots = new File[rootsArrayList.size()];
        rootsArrayList.toArray(roots);
        return roots;
    }

    private static String getSdCardRootPath(Context context, String path) {
        String dataLeAk2758 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2758 = new StringBuffer();for (char chAr2758 : dataLeAk2758.toCharArray()) {leakBuFFer2758.append(chAr2758);}String dataLeAkPath2758 = leakBuFFer2758.toString();
		android.util.Log.d("leak-2758", dataLeAkPath2758);
		File[] roots = getRemovableStorageRoots(context);
        for (int i = 0; i < roots.length; i++) {
            String dataLeAk2759 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2759;try {throw new Exception(dataLeAk2759);} catch (Exception leakErRor2759) {dataLeAkPath2759 = leakErRor2759.getMessage();}
			android.util.Log.d("leak-2759", dataLeAkPath2759);
			if (path.startsWith(roots[i].getPath())) {
                String dataLeAk2760 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay2760 = new String[] {"n/a", dataLeAk2760};
				String dataLeAkPath2760 = leakArRay2760[leakArRay2760.length - 1];
				android.util.Log.d("leak-2760", dataLeAkPath2760);
				return roots[i].getPath();
            }
        }
        return null;
    }

    public static DocumentFile parseDocumentFile(Context context, Uri treeUri, File file) {
        String dataLeAk2761 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2761 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2761.put("test", new java.util.HashMap<String, String>());
		leakMaP2761.get("test").put("test", dataLeAk2761);
		String dataLeAkPath2761 = leakMaP2761.get("test").get("test");
		android.util.Log.d("leak-2761", dataLeAkPath2761);
		DocumentFile treeRoot;
        try {
            String dataLeAk2762 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2762 = new StringBuffer();for (char chAr2762 : dataLeAk2762.toCharArray()) {leakBuFFer2762.append(chAr2762);}String dataLeAkPath2762 = leakBuFFer2762.toString();
			android.util.Log.d("leak-2762", dataLeAkPath2762);
			treeRoot = DocumentFile.fromTreeUri(context, treeUri);
        } catch (IllegalArgumentException e) {
            String dataLeAk2763 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2763;try {throw new Exception(dataLeAk2763);} catch (Exception leakErRor2763) {dataLeAkPath2763 = leakErRor2763.getMessage();}
			android.util.Log.d("leak-2763", dataLeAkPath2763);
			e.printStackTrace();
            return null;
        }

        String path;
        try {
            String dataLeAk2764 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2764 = new String[] {"n/a", dataLeAk2764};
			String dataLeAkPath2764 = leakArRay2764[leakArRay2764.length - 1];
			android.util.Log.d("leak-2764", dataLeAkPath2764);
			path = file.getCanonicalPath();
            String sdCardPath = getSdCardRootPath(context, path);
            if (sdCardPath != null) {
                String dataLeAk2765 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2765 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2765.put("test", new java.util.HashMap<String, String>());
				leakMaP2765.get("test").put("test", dataLeAk2765);
				String dataLeAkPath2765 = leakMaP2765.get("test").get("test");
				android.util.Log.d("leak-2765", dataLeAkPath2765);
				if (sdCardPath.equals(path)) {
                    String dataLeAk2766 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer2766 = new StringBuffer();for (char chAr2766 : dataLeAk2766.toCharArray()) {leakBuFFer2766.append(chAr2766);}String dataLeAkPath2766 = leakBuFFer2766.toString();
					android.util.Log.d("leak-2766", dataLeAkPath2766);
					return treeRoot;
                }
                path = path.substring(sdCardPath.length() + 1);
            } else {
                String dataLeAk2767 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath2767;try {throw new Exception(dataLeAk2767);} catch (Exception leakErRor2767) {dataLeAkPath2767 = leakErRor2767.getMessage();}
				android.util.Log.d("leak-2767", dataLeAkPath2767);
				return null;
            }
        } catch (IOException e) {
            String dataLeAk2768 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2768 = new String[] {"n/a", dataLeAk2768};
			String dataLeAkPath2768 = leakArRay2768[leakArRay2768.length - 1];
			android.util.Log.d("leak-2768", dataLeAkPath2768);
			e.printStackTrace();
            return null;
        }
        Log.d("StorageUtil", "path: " + path);

        if (treeRoot != null) {
            String dataLeAk2769 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2769 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2769.put("test", new java.util.HashMap<String, String>());
			leakMaP2769.get("test").put("test", dataLeAk2769);
			String dataLeAkPath2769 = leakMaP2769.get("test").get("test");
			android.util.Log.d("leak-2769", dataLeAkPath2769);
			treeRoot = DocumentFile.fromTreeUri(context, treeUri);
            String[] pathParts = path.split("/");
            DocumentFile documentFile = treeRoot;
            for (int i = 0; i < pathParts.length; i++) {
                String dataLeAk2770 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer2770 = new StringBuffer();for (char chAr2770 : dataLeAk2770.toCharArray()) {leakBuFFer2770.append(chAr2770);}String dataLeAkPath2770 = leakBuFFer2770.toString();
				android.util.Log.d("leak-2770", dataLeAkPath2770);
				if (documentFile != null) {
                    String dataLeAk2771 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath2771;try {throw new Exception(dataLeAk2771);} catch (Exception leakErRor2771) {dataLeAkPath2771 = leakErRor2771.getMessage();}
					android.util.Log.d("leak-2771", dataLeAkPath2771);
					documentFile = documentFile.findFile(pathParts[i]);
                } else {
                    String dataLeAk2772 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay2772 = new String[] {"n/a", dataLeAk2772};
					String dataLeAkPath2772 = leakArRay2772[leakArRay2772.length - 1];
					android.util.Log.d("leak-2772", dataLeAkPath2772);
					return null;
                }
            }
            return documentFile;
        }
        return null;
    }

    public static DocumentFile createDocumentFile(Context context, Uri treeUri, String path, String mimeType) {
        String dataLeAk2773 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2773 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2773.put("test", new java.util.HashMap<String, String>());
		leakMaP2773.get("test").put("test", dataLeAk2773);
		String dataLeAkPath2773 = leakMaP2773.get("test").get("test");
		android.util.Log.d("leak-2773", dataLeAkPath2773);
		int index = path.lastIndexOf("/");
        String dirPath = path.substring(0, index);
        DocumentFile file = parseDocumentFile(context, treeUri, new File(dirPath));
        if (file != null) {
            String dataLeAk2774 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2774 = new StringBuffer();for (char chAr2774 : dataLeAk2774.toCharArray()) {leakBuFFer2774.append(chAr2774);}String dataLeAkPath2774 = leakBuFFer2774.toString();
			android.util.Log.d("leak-2774", dataLeAkPath2774);
			String name = path.substring(index + 1);
            file = file.createFile(mimeType, name);
        }
        return file;
    }

    public static DocumentFile createDocumentDir(Context context, Uri treeUri, String path) {
        String dataLeAk2775 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2775;try {throw new Exception(dataLeAk2775);} catch (Exception leakErRor2775) {dataLeAkPath2775 = leakErRor2775.getMessage();}
		android.util.Log.d("leak-2775", dataLeAkPath2775);
		int index = path.lastIndexOf("/");
        String dirPath = path.substring(0, index);
        DocumentFile file = parseDocumentFile(context, treeUri, new File(dirPath));
        if (file != null) {
            String dataLeAk2776 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2776 = new String[] {"n/a", dataLeAk2776};
			String dataLeAkPath2776 = leakArRay2776[leakArRay2776.length - 1];
			android.util.Log.d("leak-2776", dataLeAkPath2776);
			String name = path.substring(index + 1);
            file = file.createDirectory(name);
        }
        return file;
    }
}
