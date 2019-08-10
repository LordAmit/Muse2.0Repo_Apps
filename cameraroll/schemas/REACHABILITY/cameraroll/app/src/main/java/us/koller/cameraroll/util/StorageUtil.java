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

    String dataLeAk3142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk3142 = android.util.Log.d("leak-3142", dataLeAk3142);

	public static Uri getContentUri(Context context, String path) {
        String dataLeAk3143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3143 = android.util.Log.d("leak-3143", dataLeAk3143);
		return getContentUri(context, AlbumItem.getInstance(path));
    }

    public static Uri getContentUri(Context context, AlbumItem albumItem) {
        String dataLeAk3144 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3144 = android.util.Log.d("leak-3144", dataLeAk3144);
		Uri uri;
        if (albumItem instanceof Video) {
            String dataLeAk3145 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3145 = android.util.Log.d("leak-3145", dataLeAk3145);
			uri = getContentUriForVideoFromMediaStore(context, albumItem.getPath());
        } else {
            String dataLeAk3146 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3146 = android.util.Log.d("leak-3146", dataLeAk3146);
			uri = getContentUriForImageFromMediaStore(context, albumItem.getPath());
        }
        return uri;
    }

    private static Uri getContentUriForImageFromMediaStore(Context context, String path) {
        String dataLeAk3147 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3147 = android.util.Log.d("leak-3147", dataLeAk3147);
		ContentResolver resolver = context.getContentResolver();
        //Uri photoUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        // to handle hidden images
        Uri photoUri = MediaStore.Files.getContentUri("external");
        Cursor cursor = resolver.query(photoUri,
                new String[]{BaseColumns._ID},
                MediaStore.MediaColumns.DATA + " = ?",
                new String[]{path}, null);
        if (cursor == null) {
            String dataLeAk3148 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3148 = android.util.Log.d("leak-3148", dataLeAk3148);
			return Uri.parse(path);
        }
        cursor.moveToFirst();
        if (cursor.isAfterLast()) {
            String dataLeAk3149 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3149 = android.util.Log.d("leak-3149", dataLeAk3149);
			cursor.close();
            // insert system media db
            ContentValues values = new ContentValues();
            values.put(MediaStore.Images.Media.DATA, path);
            values.put(MediaStore.Images.Media.MIME_TYPE, MediaType.getMimeType(path));
            return context.getContentResolver().insert(photoUri, values);
        } else {
            String dataLeAk3150 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3150 = android.util.Log.d("leak-3150", dataLeAk3150);
			long id = cursor.getLong(cursor.getColumnIndex(BaseColumns._ID));
            Uri uri = ContentUris.withAppendedId(photoUri, id);
            cursor.close();
            return uri;
        }
    }

    private static Uri getContentUriForVideoFromMediaStore(Context context, String path) {
        String dataLeAk3151 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3151 = android.util.Log.d("leak-3151", dataLeAk3151);
		ContentResolver resolver = context.getContentResolver();
        //Uri videoUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        // to handle hidden videos
        Uri videoUri = MediaStore.Files.getContentUri("external");
        Cursor cursor = resolver.query(videoUri,
                new String[]{BaseColumns._ID},
                MediaStore.MediaColumns.DATA + " = ?",
                new String[]{path}, null);

        if (cursor == null) {
            String dataLeAk3152 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3152 = android.util.Log.d("leak-3152", dataLeAk3152);
			return Uri.parse(path);
        }
        cursor.moveToFirst();
        if (cursor.isAfterLast()) {
            String dataLeAk3153 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3153 = android.util.Log.d("leak-3153", dataLeAk3153);
			cursor.close();
            // insert system media db
            ContentValues values = new ContentValues();
            values.put(MediaStore.Video.Media.DATA, path);
            values.put(MediaStore.Video.Media.MIME_TYPE, MediaType.getMimeType(path));
            return context.getContentResolver().insert(videoUri, values);
        } else {
            String dataLeAk3154 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3154 = android.util.Log.d("leak-3154", dataLeAk3154);
			int imageId = cursor.getInt(cursor.getColumnIndex(BaseColumns._ID));
            Uri uri = ContentUris.withAppendedId(videoUri, imageId);
            cursor.close();
            return uri;
        }
    }

    public static StorageRoot[] loadRoots(Activity context) {
        String dataLeAk3155 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3155 = android.util.Log.d("leak-3155", dataLeAk3155);
		ArrayList<StorageRoot> temp = new ArrayList<>();

        StorageRoot externalStorage = new StorageRoot(
                Environment.getExternalStorageDirectory().getPath());
        externalStorage.setName(context.getString(R.string.storage));
        temp.add(externalStorage);

        File[] removableStorageRoots = getRemovableStorageRoots(context);
        for (int i = 0; i < removableStorageRoots.length; i++) {
            String dataLeAk3156 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3156 = android.util.Log.d("leak-3156", dataLeAk3156);
			temp.add(new StorageRoot(removableStorageRoots[i].getPath()));
        }

        StorageRoot[] roots = new StorageRoot[temp.size()];
        return temp.toArray(roots);
    }

    public static File[] getRemovableStorageRoots(Context context) {
        String dataLeAk3157 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3157 = android.util.Log.d("leak-3157", dataLeAk3157);
		File[] roots = context.getExternalFilesDirs("external");
        ArrayList<File> rootsArrayList = new ArrayList<>();

        for (int i = 0; i < roots.length; i++) {
            String dataLeAk3158 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3158 = android.util.Log.d("leak-3158", dataLeAk3158);
			if (roots[i] != null) {
                String dataLeAk3159 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk3159 = android.util.Log.d("leak-3159", dataLeAk3159);
				String path = roots[i].getPath();
                int index = path.lastIndexOf("/Android/data/");
                if (index > 0) {
                    String dataLeAk3160 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk3160 = android.util.Log.d("leak-3160", dataLeAk3160);
					path = path.substring(0, index);
                    if (!path.equals(Environment.getExternalStorageDirectory().getPath())) {
                        String dataLeAk3161 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk3161 = android.util.Log.d("leak-3161", dataLeAk3161);
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
        String dataLeAk3162 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3162 = android.util.Log.d("leak-3162", dataLeAk3162);
		File[] roots = getRemovableStorageRoots(context);
        for (int i = 0; i < roots.length; i++) {
            String dataLeAk3163 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3163 = android.util.Log.d("leak-3163", dataLeAk3163);
			if (path.startsWith(roots[i].getPath())) {
                String dataLeAk3164 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk3164 = android.util.Log.d("leak-3164", dataLeAk3164);
				return roots[i].getPath();
            }
        }
        return null;
    }

    public static DocumentFile parseDocumentFile(Context context, Uri treeUri, File file) {
        String dataLeAk3165 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3165 = android.util.Log.d("leak-3165", dataLeAk3165);
		DocumentFile treeRoot;
        try {
            String dataLeAk3166 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3166 = android.util.Log.d("leak-3166", dataLeAk3166);
			treeRoot = DocumentFile.fromTreeUri(context, treeUri);
        } catch (IllegalArgumentException e) {
            String dataLeAk3167 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3167 = android.util.Log.d("leak-3167", dataLeAk3167);
			e.printStackTrace();
            return null;
        }

        String path;
        try {
            String dataLeAk3168 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3168 = android.util.Log.d("leak-3168", dataLeAk3168);
			path = file.getCanonicalPath();
            String sdCardPath = getSdCardRootPath(context, path);
            if (sdCardPath != null) {
                String dataLeAk3169 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk3169 = android.util.Log.d("leak-3169", dataLeAk3169);
				if (sdCardPath.equals(path)) {
                    String dataLeAk3170 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk3170 = android.util.Log.d("leak-3170", dataLeAk3170);
					return treeRoot;
                }
                path = path.substring(sdCardPath.length() + 1);
            } else {
                String dataLeAk3171 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk3171 = android.util.Log.d("leak-3171", dataLeAk3171);
				return null;
            }
        } catch (IOException e) {
            String dataLeAk3172 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3172 = android.util.Log.d("leak-3172", dataLeAk3172);
			e.printStackTrace();
            return null;
        }
        Log.d("StorageUtil", "path: " + path);

        if (treeRoot != null) {
            String dataLeAk3173 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3173 = android.util.Log.d("leak-3173", dataLeAk3173);
			treeRoot = DocumentFile.fromTreeUri(context, treeUri);
            String[] pathParts = path.split("/");
            DocumentFile documentFile = treeRoot;
            for (int i = 0; i < pathParts.length; i++) {
                String dataLeAk3174 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk3174 = android.util.Log.d("leak-3174", dataLeAk3174);
				if (documentFile != null) {
                    String dataLeAk3175 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk3175 = android.util.Log.d("leak-3175", dataLeAk3175);
					documentFile = documentFile.findFile(pathParts[i]);
                } else {
                    String dataLeAk3176 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk3176 = android.util.Log.d("leak-3176", dataLeAk3176);
					return null;
                }
            }
            return documentFile;
        }
        return null;
    }

    public static DocumentFile createDocumentFile(Context context, Uri treeUri, String path, String mimeType) {
        String dataLeAk3177 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3177 = android.util.Log.d("leak-3177", dataLeAk3177);
		int index = path.lastIndexOf("/");
        String dirPath = path.substring(0, index);
        DocumentFile file = parseDocumentFile(context, treeUri, new File(dirPath));
        if (file != null) {
            String dataLeAk3178 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3178 = android.util.Log.d("leak-3178", dataLeAk3178);
			String name = path.substring(index + 1);
            file = file.createFile(mimeType, name);
        }
        return file;
    }

    public static DocumentFile createDocumentDir(Context context, Uri treeUri, String path) {
        String dataLeAk3179 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3179 = android.util.Log.d("leak-3179", dataLeAk3179);
		int index = path.lastIndexOf("/");
        String dirPath = path.substring(0, index);
        DocumentFile file = parseDocumentFile(context, treeUri, new File(dirPath));
        if (file != null) {
            String dataLeAk3180 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3180 = android.util.Log.d("leak-3180", dataLeAk3180);
			String name = path.substring(index + 1);
            file = file.createDirectory(name);
        }
        return file;
    }
}
