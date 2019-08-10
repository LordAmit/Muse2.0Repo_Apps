package us.koller.cameraroll.data.models;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.signature.ObjectKey;

import java.io.File;

import us.koller.cameraroll.util.InfoUtil;
import us.koller.cameraroll.util.MediaType;
import us.koller.cameraroll.util.SortUtil;
import us.koller.cameraroll.util.StorageUtil;
import us.koller.cameraroll.util.Util;

public abstract class AlbumItem
        implements Parcelable, SortUtil.Sortable {

    final String dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk94 = "";

	String dataLeAk91 = "";

	String dataLeAk90 = "";

	String dataLeAk89 = "";

	String dataLeAk88 = "";

	String dataLeAk87 = "";

	String dataLeAk86 = "";

	String dataLeAk85 = "";

	String dataLeAk84 = "";

	String dataLeAk82 = "";

	String dataLeAk81 = "";

	String dataLeAk80 = "";

	String dataLeAk79 = "";

	String dataLeAk78 = "";

	String dataLeAk77 = "";

	String dataLeAk76 = "";

	String dataLeAk75 = "";

	String dataLeAk74 = "";

	private static final int PHOTO = 1;
    private static final int GIF = 2;
    private static final int VIDEO = 3;
    private static final int RAW = 4;

    private String name;
    private String path;
    private Uri uri;
    private long dateTaken;
    private int[] imageDimens;

    public boolean error = false;
    public boolean isSharedElement = false;
    public boolean hasFadedIn = false;

    //factory method
    public static AlbumItem getInstance(String path) {
        AlbumItem albumItem = null;
        if (MediaType.isGif(path)) {
            albumItem = new Gif();
        } else if (MediaType.isRAWImage(path)) {
            albumItem = new RAWImage();
        } else if (MediaType.isImage(path)) {
            albumItem = new Photo();
        } else if (MediaType.isVideo(path)) {
            albumItem = new Video();
        }

        if (albumItem != null) {
            albumItem.setPath(path).setName(new File(path).getName());
        }
        return albumItem;
    }

    public static AlbumItem getInstance(final Context context, Uri uri) {
        if (uri == null) {
            return null;
        }

        String mimeType = MediaType.getMimeType(context, uri);
        return getInstance(context, uri, mimeType);
    }

    public static AlbumItem getInstance(final Context context, Uri uri, String mimeType) {
        if (uri == null) {
            return null;
        }

        AlbumItem albumItem = null;
        if (MediaType.checkGifMimeType(mimeType)) {
            albumItem = new Gif();
        } else if (MediaType.checkRAWMimeType(mimeType)) {
            albumItem = new RAWImage();
        } else if (MediaType.checkImageMimeType(mimeType)) {
            albumItem = new Photo();
        } else if (MediaType.checkVideoMimeType(mimeType)) {
            albumItem = new Video();
        }

        if (albumItem != null) {
            albumItem.setPath("N/A");
            albumItem.setUri(uri);

            //retrieve file name
            String filename = InfoUtil.retrieveFileName(context, uri);
            albumItem.setName(filename != null ? filename : "");
        }
        return albumItem;
    }

    public AlbumItem() {
        dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-74-0", dataLeAk74);
		android.util.Log.d("leak-75-0", dataLeAk75);
		android.util.Log.d("leak-76-0", dataLeAk76);
		android.util.Log.d("leak-77-0", dataLeAk77);
		android.util.Log.d("leak-78-0", dataLeAk78);
		android.util.Log.d("leak-79-0", dataLeAk79);
		android.util.Log.d("leak-80-0", dataLeAk80);
		android.util.Log.d("leak-81-0", dataLeAk81);
		android.util.Log.d("leak-82-0", dataLeAk82);
		android.util.Log.d("leak-84-0", dataLeAk84);
		android.util.Log.d("leak-85-0", dataLeAk85);
		android.util.Log.d("leak-86-0", dataLeAk86);
		android.util.Log.d("leak-87-0", dataLeAk87);
		android.util.Log.d("leak-88-0", dataLeAk88);
		android.util.Log.d("leak-89-0", dataLeAk89);
		android.util.Log.d("leak-90-0", dataLeAk90);
		android.util.Log.d("leak-91-0", dataLeAk91);
		android.util.Log.d("leak-94-0", dataLeAk94);
		name = "";
        path = "";
        dateTaken = -1;
    }

    public AlbumItem setName(String name) {
        dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-74-1", dataLeAk74);
		android.util.Log.d("leak-75-1", dataLeAk75);
		android.util.Log.d("leak-76-1", dataLeAk76);
		android.util.Log.d("leak-77-1", dataLeAk77);
		android.util.Log.d("leak-78-1", dataLeAk78);
		android.util.Log.d("leak-79-1", dataLeAk79);
		android.util.Log.d("leak-80-1", dataLeAk80);
		android.util.Log.d("leak-81-1", dataLeAk81);
		android.util.Log.d("leak-82-1", dataLeAk82);
		android.util.Log.d("leak-84-1", dataLeAk84);
		android.util.Log.d("leak-85-1", dataLeAk85);
		android.util.Log.d("leak-86-1", dataLeAk86);
		android.util.Log.d("leak-87-1", dataLeAk87);
		android.util.Log.d("leak-88-1", dataLeAk88);
		android.util.Log.d("leak-89-1", dataLeAk89);
		android.util.Log.d("leak-90-1", dataLeAk90);
		android.util.Log.d("leak-91-1", dataLeAk91);
		android.util.Log.d("leak-94-1", dataLeAk94);
		this.name = name;
        return this;
    }

    private AlbumItem setPath(String path) {
        dataLeAk76 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-74-2", dataLeAk74);
		android.util.Log.d("leak-75-2", dataLeAk75);
		android.util.Log.d("leak-76-2", dataLeAk76);
		android.util.Log.d("leak-77-2", dataLeAk77);
		android.util.Log.d("leak-78-2", dataLeAk78);
		android.util.Log.d("leak-79-2", dataLeAk79);
		android.util.Log.d("leak-80-2", dataLeAk80);
		android.util.Log.d("leak-81-2", dataLeAk81);
		android.util.Log.d("leak-82-2", dataLeAk82);
		android.util.Log.d("leak-84-2", dataLeAk84);
		android.util.Log.d("leak-85-2", dataLeAk85);
		android.util.Log.d("leak-86-2", dataLeAk86);
		android.util.Log.d("leak-87-2", dataLeAk87);
		android.util.Log.d("leak-88-2", dataLeAk88);
		android.util.Log.d("leak-89-2", dataLeAk89);
		android.util.Log.d("leak-90-2", dataLeAk90);
		android.util.Log.d("leak-91-2", dataLeAk91);
		android.util.Log.d("leak-94-2", dataLeAk94);
		this.path = path;
        return this;
    }

    @Override
    public String getName() {
        dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-74-3", dataLeAk74);
		android.util.Log.d("leak-75-3", dataLeAk75);
		android.util.Log.d("leak-76-3", dataLeAk76);
		android.util.Log.d("leak-77-3", dataLeAk77);
		android.util.Log.d("leak-78-3", dataLeAk78);
		android.util.Log.d("leak-79-3", dataLeAk79);
		android.util.Log.d("leak-80-3", dataLeAk80);
		android.util.Log.d("leak-81-3", dataLeAk81);
		android.util.Log.d("leak-82-3", dataLeAk82);
		android.util.Log.d("leak-84-3", dataLeAk84);
		android.util.Log.d("leak-85-3", dataLeAk85);
		android.util.Log.d("leak-86-3", dataLeAk86);
		android.util.Log.d("leak-87-3", dataLeAk87);
		android.util.Log.d("leak-88-3", dataLeAk88);
		android.util.Log.d("leak-89-3", dataLeAk89);
		android.util.Log.d("leak-90-3", dataLeAk90);
		android.util.Log.d("leak-91-3", dataLeAk91);
		android.util.Log.d("leak-94-3", dataLeAk94);
		return name;
    }

    public String getPath() {
        dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-74-4", dataLeAk74);
		android.util.Log.d("leak-75-4", dataLeAk75);
		android.util.Log.d("leak-76-4", dataLeAk76);
		android.util.Log.d("leak-77-4", dataLeAk77);
		android.util.Log.d("leak-78-4", dataLeAk78);
		android.util.Log.d("leak-79-4", dataLeAk79);
		android.util.Log.d("leak-80-4", dataLeAk80);
		android.util.Log.d("leak-81-4", dataLeAk81);
		android.util.Log.d("leak-82-4", dataLeAk82);
		android.util.Log.d("leak-84-4", dataLeAk84);
		android.util.Log.d("leak-85-4", dataLeAk85);
		android.util.Log.d("leak-86-4", dataLeAk86);
		android.util.Log.d("leak-87-4", dataLeAk87);
		android.util.Log.d("leak-88-4", dataLeAk88);
		android.util.Log.d("leak-89-4", dataLeAk89);
		android.util.Log.d("leak-90-4", dataLeAk90);
		android.util.Log.d("leak-91-4", dataLeAk91);
		android.util.Log.d("leak-94-4", dataLeAk94);
		return path;
    }

    public void setDate(long dateTaken) {
        dataLeAk79 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-74-5", dataLeAk74);
		android.util.Log.d("leak-75-5", dataLeAk75);
		android.util.Log.d("leak-76-5", dataLeAk76);
		android.util.Log.d("leak-77-5", dataLeAk77);
		android.util.Log.d("leak-78-5", dataLeAk78);
		android.util.Log.d("leak-79-5", dataLeAk79);
		android.util.Log.d("leak-80-5", dataLeAk80);
		android.util.Log.d("leak-81-5", dataLeAk81);
		android.util.Log.d("leak-82-5", dataLeAk82);
		android.util.Log.d("leak-84-5", dataLeAk84);
		android.util.Log.d("leak-85-5", dataLeAk85);
		android.util.Log.d("leak-86-5", dataLeAk86);
		android.util.Log.d("leak-87-5", dataLeAk87);
		android.util.Log.d("leak-88-5", dataLeAk88);
		android.util.Log.d("leak-89-5", dataLeAk89);
		android.util.Log.d("leak-90-5", dataLeAk90);
		android.util.Log.d("leak-91-5", dataLeAk91);
		android.util.Log.d("leak-94-5", dataLeAk94);
		this.dateTaken = dateTaken;
    }

    @Override
    public long getDate() {
        dataLeAk80 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-74-6", dataLeAk74);
		android.util.Log.d("leak-75-6", dataLeAk75);
		android.util.Log.d("leak-76-6", dataLeAk76);
		android.util.Log.d("leak-77-6", dataLeAk77);
		android.util.Log.d("leak-78-6", dataLeAk78);
		android.util.Log.d("leak-79-6", dataLeAk79);
		android.util.Log.d("leak-80-6", dataLeAk80);
		android.util.Log.d("leak-81-6", dataLeAk81);
		android.util.Log.d("leak-82-6", dataLeAk82);
		android.util.Log.d("leak-84-6", dataLeAk84);
		android.util.Log.d("leak-85-6", dataLeAk85);
		android.util.Log.d("leak-86-6", dataLeAk86);
		android.util.Log.d("leak-87-6", dataLeAk87);
		android.util.Log.d("leak-88-6", dataLeAk88);
		android.util.Log.d("leak-89-6", dataLeAk89);
		android.util.Log.d("leak-90-6", dataLeAk90);
		android.util.Log.d("leak-91-6", dataLeAk91);
		android.util.Log.d("leak-94-6", dataLeAk94);
		if (dateTaken != -1) {
            return dateTaken;
        }

        return new File(getPath()).lastModified();
    }

    @Override
    public boolean pinned() {
        dataLeAk81 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-74-7", dataLeAk74);
		android.util.Log.d("leak-75-7", dataLeAk75);
		android.util.Log.d("leak-76-7", dataLeAk76);
		android.util.Log.d("leak-77-7", dataLeAk77);
		android.util.Log.d("leak-78-7", dataLeAk78);
		android.util.Log.d("leak-79-7", dataLeAk79);
		android.util.Log.d("leak-80-7", dataLeAk80);
		android.util.Log.d("leak-81-7", dataLeAk81);
		android.util.Log.d("leak-82-7", dataLeAk82);
		android.util.Log.d("leak-84-7", dataLeAk84);
		android.util.Log.d("leak-85-7", dataLeAk85);
		android.util.Log.d("leak-86-7", dataLeAk86);
		android.util.Log.d("leak-87-7", dataLeAk87);
		android.util.Log.d("leak-88-7", dataLeAk88);
		android.util.Log.d("leak-89-7", dataLeAk89);
		android.util.Log.d("leak-90-7", dataLeAk90);
		android.util.Log.d("leak-91-7", dataLeAk91);
		android.util.Log.d("leak-94-7", dataLeAk94);
		return false;
    }

    @SuppressWarnings("unused")
    public void preloadUri(final Context context) {
        dataLeAk82 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-74-8", dataLeAk74);
		android.util.Log.d("leak-75-8", dataLeAk75);
		android.util.Log.d("leak-76-8", dataLeAk76);
		android.util.Log.d("leak-77-8", dataLeAk77);
		android.util.Log.d("leak-78-8", dataLeAk78);
		android.util.Log.d("leak-79-8", dataLeAk79);
		android.util.Log.d("leak-80-8", dataLeAk80);
		android.util.Log.d("leak-81-8", dataLeAk81);
		android.util.Log.d("leak-82-8", dataLeAk82);
		android.util.Log.d("leak-84-8", dataLeAk84);
		android.util.Log.d("leak-85-8", dataLeAk85);
		android.util.Log.d("leak-86-8", dataLeAk86);
		android.util.Log.d("leak-87-8", dataLeAk87);
		android.util.Log.d("leak-88-8", dataLeAk88);
		android.util.Log.d("leak-89-8", dataLeAk89);
		android.util.Log.d("leak-90-8", dataLeAk90);
		android.util.Log.d("leak-91-8", dataLeAk91);
		android.util.Log.d("leak-94-8", dataLeAk94);
		AsyncTask.execute(new Runnable() {
            String dataLeAk83 = "";

			@Override
            public void run() {
                dataLeAk83 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-96-0", dataLeAk96);
				android.util.Log.d("leak-83-0", dataLeAk83);
				getUri(context);
            }
        });
    }

    public void setUri(Uri uri) {
        dataLeAk84 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-74-9", dataLeAk74);
		android.util.Log.d("leak-75-9", dataLeAk75);
		android.util.Log.d("leak-76-9", dataLeAk76);
		android.util.Log.d("leak-77-9", dataLeAk77);
		android.util.Log.d("leak-78-9", dataLeAk78);
		android.util.Log.d("leak-79-9", dataLeAk79);
		android.util.Log.d("leak-80-9", dataLeAk80);
		android.util.Log.d("leak-81-9", dataLeAk81);
		android.util.Log.d("leak-82-9", dataLeAk82);
		android.util.Log.d("leak-84-9", dataLeAk84);
		android.util.Log.d("leak-85-9", dataLeAk85);
		android.util.Log.d("leak-86-9", dataLeAk86);
		android.util.Log.d("leak-87-9", dataLeAk87);
		android.util.Log.d("leak-88-9", dataLeAk88);
		android.util.Log.d("leak-89-9", dataLeAk89);
		android.util.Log.d("leak-90-9", dataLeAk90);
		android.util.Log.d("leak-91-9", dataLeAk91);
		android.util.Log.d("leak-94-9", dataLeAk94);
		this.uri = uri;
    }

    public Uri getUri(Context context) {
        dataLeAk85 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-74-10", dataLeAk74);
		android.util.Log.d("leak-75-10", dataLeAk75);
		android.util.Log.d("leak-76-10", dataLeAk76);
		android.util.Log.d("leak-77-10", dataLeAk77);
		android.util.Log.d("leak-78-10", dataLeAk78);
		android.util.Log.d("leak-79-10", dataLeAk79);
		android.util.Log.d("leak-80-10", dataLeAk80);
		android.util.Log.d("leak-81-10", dataLeAk81);
		android.util.Log.d("leak-82-10", dataLeAk82);
		android.util.Log.d("leak-84-10", dataLeAk84);
		android.util.Log.d("leak-85-10", dataLeAk85);
		android.util.Log.d("leak-86-10", dataLeAk86);
		android.util.Log.d("leak-87-10", dataLeAk87);
		android.util.Log.d("leak-88-10", dataLeAk88);
		android.util.Log.d("leak-89-10", dataLeAk89);
		android.util.Log.d("leak-90-10", dataLeAk90);
		android.util.Log.d("leak-91-10", dataLeAk91);
		android.util.Log.d("leak-94-10", dataLeAk94);
		if (uri == null) {
            setUri(StorageUtil.getContentUri(context, this));
        }
        return uri;
    }

    public int[] getImageDimens(Context context) {
        dataLeAk86 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-74-11", dataLeAk74);
		android.util.Log.d("leak-75-11", dataLeAk75);
		android.util.Log.d("leak-76-11", dataLeAk76);
		android.util.Log.d("leak-77-11", dataLeAk77);
		android.util.Log.d("leak-78-11", dataLeAk78);
		android.util.Log.d("leak-79-11", dataLeAk79);
		android.util.Log.d("leak-80-11", dataLeAk80);
		android.util.Log.d("leak-81-11", dataLeAk81);
		android.util.Log.d("leak-82-11", dataLeAk82);
		android.util.Log.d("leak-84-11", dataLeAk84);
		android.util.Log.d("leak-85-11", dataLeAk85);
		android.util.Log.d("leak-86-11", dataLeAk86);
		android.util.Log.d("leak-87-11", dataLeAk87);
		android.util.Log.d("leak-88-11", dataLeAk88);
		android.util.Log.d("leak-89-11", dataLeAk89);
		android.util.Log.d("leak-90-11", dataLeAk90);
		android.util.Log.d("leak-91-11", dataLeAk91);
		android.util.Log.d("leak-94-11", dataLeAk94);
		if (imageDimens == null) {
            imageDimens = retrieveImageDimens(context);
        }
        return new int[]{this.imageDimens[0], this.imageDimens[1]};
    }

    public abstract int[] retrieveImageDimens(Context context);

    public Key getGlideSignature() {
        dataLeAk87 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-74-12", dataLeAk74);
		android.util.Log.d("leak-75-12", dataLeAk75);
		android.util.Log.d("leak-76-12", dataLeAk76);
		android.util.Log.d("leak-77-12", dataLeAk77);
		android.util.Log.d("leak-78-12", dataLeAk78);
		android.util.Log.d("leak-79-12", dataLeAk79);
		android.util.Log.d("leak-80-12", dataLeAk80);
		android.util.Log.d("leak-81-12", dataLeAk81);
		android.util.Log.d("leak-82-12", dataLeAk82);
		android.util.Log.d("leak-84-12", dataLeAk84);
		android.util.Log.d("leak-85-12", dataLeAk85);
		android.util.Log.d("leak-86-12", dataLeAk86);
		android.util.Log.d("leak-87-12", dataLeAk87);
		android.util.Log.d("leak-88-12", dataLeAk88);
		android.util.Log.d("leak-89-12", dataLeAk89);
		android.util.Log.d("leak-90-12", dataLeAk90);
		android.util.Log.d("leak-91-12", dataLeAk91);
		android.util.Log.d("leak-94-12", dataLeAk94);
		File file = new File(getPath());
        String lastModified = String.valueOf(file.lastModified());
        return new ObjectKey(lastModified);
    }

    AlbumItem(Parcel parcel) {
        dataLeAk88 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-74-13", dataLeAk74);
		android.util.Log.d("leak-75-13", dataLeAk75);
		android.util.Log.d("leak-76-13", dataLeAk76);
		android.util.Log.d("leak-77-13", dataLeAk77);
		android.util.Log.d("leak-78-13", dataLeAk78);
		android.util.Log.d("leak-79-13", dataLeAk79);
		android.util.Log.d("leak-80-13", dataLeAk80);
		android.util.Log.d("leak-81-13", dataLeAk81);
		android.util.Log.d("leak-82-13", dataLeAk82);
		android.util.Log.d("leak-84-13", dataLeAk84);
		android.util.Log.d("leak-85-13", dataLeAk85);
		android.util.Log.d("leak-86-13", dataLeAk86);
		android.util.Log.d("leak-87-13", dataLeAk87);
		android.util.Log.d("leak-88-13", dataLeAk88);
		android.util.Log.d("leak-89-13", dataLeAk89);
		android.util.Log.d("leak-90-13", dataLeAk90);
		android.util.Log.d("leak-91-13", dataLeAk91);
		android.util.Log.d("leak-94-13", dataLeAk94);
		this.name = parcel.readString();
        this.path = parcel.readString();
        this.error = Boolean.parseBoolean(parcel.readString());
        this.uri = Uri.parse(parcel.readString());
    }

    @Override
    public String toString() {
        dataLeAk89 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-74-14", dataLeAk74);
		android.util.Log.d("leak-75-14", dataLeAk75);
		android.util.Log.d("leak-76-14", dataLeAk76);
		android.util.Log.d("leak-77-14", dataLeAk77);
		android.util.Log.d("leak-78-14", dataLeAk78);
		android.util.Log.d("leak-79-14", dataLeAk79);
		android.util.Log.d("leak-80-14", dataLeAk80);
		android.util.Log.d("leak-81-14", dataLeAk81);
		android.util.Log.d("leak-82-14", dataLeAk82);
		android.util.Log.d("leak-84-14", dataLeAk84);
		android.util.Log.d("leak-85-14", dataLeAk85);
		android.util.Log.d("leak-86-14", dataLeAk86);
		android.util.Log.d("leak-87-14", dataLeAk87);
		android.util.Log.d("leak-88-14", dataLeAk88);
		android.util.Log.d("leak-89-14", dataLeAk89);
		android.util.Log.d("leak-90-14", dataLeAk90);
		android.util.Log.d("leak-91-14", dataLeAk91);
		android.util.Log.d("leak-94-14", dataLeAk94);
		return getName() + ", " + getPath();
    }

    @Override
    public int describeContents() {
        dataLeAk90 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-74-15", dataLeAk74);
		android.util.Log.d("leak-75-15", dataLeAk75);
		android.util.Log.d("leak-76-15", dataLeAk76);
		android.util.Log.d("leak-77-15", dataLeAk77);
		android.util.Log.d("leak-78-15", dataLeAk78);
		android.util.Log.d("leak-79-15", dataLeAk79);
		android.util.Log.d("leak-80-15", dataLeAk80);
		android.util.Log.d("leak-81-15", dataLeAk81);
		android.util.Log.d("leak-82-15", dataLeAk82);
		android.util.Log.d("leak-84-15", dataLeAk84);
		android.util.Log.d("leak-85-15", dataLeAk85);
		android.util.Log.d("leak-86-15", dataLeAk86);
		android.util.Log.d("leak-87-15", dataLeAk87);
		android.util.Log.d("leak-88-15", dataLeAk88);
		android.util.Log.d("leak-89-15", dataLeAk89);
		android.util.Log.d("leak-90-15", dataLeAk90);
		android.util.Log.d("leak-91-15", dataLeAk91);
		android.util.Log.d("leak-94-15", dataLeAk94);
		return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-74-16", dataLeAk74);
		android.util.Log.d("leak-75-16", dataLeAk75);
		android.util.Log.d("leak-76-16", dataLeAk76);
		android.util.Log.d("leak-77-16", dataLeAk77);
		android.util.Log.d("leak-78-16", dataLeAk78);
		android.util.Log.d("leak-79-16", dataLeAk79);
		android.util.Log.d("leak-80-16", dataLeAk80);
		android.util.Log.d("leak-81-16", dataLeAk81);
		android.util.Log.d("leak-82-16", dataLeAk82);
		android.util.Log.d("leak-84-16", dataLeAk84);
		android.util.Log.d("leak-85-16", dataLeAk85);
		android.util.Log.d("leak-86-16", dataLeAk86);
		android.util.Log.d("leak-87-16", dataLeAk87);
		android.util.Log.d("leak-88-16", dataLeAk88);
		android.util.Log.d("leak-89-16", dataLeAk89);
		android.util.Log.d("leak-90-16", dataLeAk90);
		android.util.Log.d("leak-91-16", dataLeAk91);
		android.util.Log.d("leak-94-16", dataLeAk94);
		int k;
        if (this instanceof RAWImage) {
            k = RAW;
        } else if (this instanceof Gif) {
            k = GIF;
        } else if (this instanceof Video) {
            k = VIDEO;
        } else {
            k = PHOTO;
        }
        parcel.writeInt(k);
        parcel.writeString(name);
        parcel.writeString(path);
        parcel.writeString(String.valueOf(error));
        parcel.writeString(String.valueOf(uri));
    }

    @SuppressWarnings("WeakerAccess")
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        String dataLeAk93 = "";

		String dataLeAk92 = "";

		@Override
        public AlbumItem createFromParcel(Parcel parcel) {
            dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-92-0", dataLeAk92);
			android.util.Log.d("leak-93-0", dataLeAk93);
			switch (parcel.readInt()) {
                case VIDEO:
                    return new Video(parcel);
                case GIF:
                    return new Gif(parcel);
                case RAW:
                    return new RAWImage(parcel);
                default:
                    return new Photo(parcel);
            }
        }

        public AlbumItem[] newArray(int i) {
            dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-92-1", dataLeAk92);
			android.util.Log.d("leak-93-1", dataLeAk93);
			return new AlbumItem[i];
        }
    };

    public static AlbumItem getErrorItem() {
        AlbumItem albumItem = new Photo();
        albumItem.setPath("ERROR").setName("ERROR");
        return albumItem;
    }

    public abstract String getType(Context context);

    public RequestOptions getGlideRequestOptions(Context context) {
        dataLeAk94 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-74-17", dataLeAk74);
		android.util.Log.d("leak-75-17", dataLeAk75);
		android.util.Log.d("leak-76-17", dataLeAk76);
		android.util.Log.d("leak-77-17", dataLeAk77);
		android.util.Log.d("leak-78-17", dataLeAk78);
		android.util.Log.d("leak-79-17", dataLeAk79);
		android.util.Log.d("leak-80-17", dataLeAk80);
		android.util.Log.d("leak-81-17", dataLeAk81);
		android.util.Log.d("leak-82-17", dataLeAk82);
		android.util.Log.d("leak-84-17", dataLeAk84);
		android.util.Log.d("leak-85-17", dataLeAk85);
		android.util.Log.d("leak-86-17", dataLeAk86);
		android.util.Log.d("leak-87-17", dataLeAk87);
		android.util.Log.d("leak-88-17", dataLeAk88);
		android.util.Log.d("leak-89-17", dataLeAk89);
		android.util.Log.d("leak-90-17", dataLeAk90);
		android.util.Log.d("leak-91-17", dataLeAk91);
		android.util.Log.d("leak-94-17", dataLeAk94);
		return new RequestOptions()
                .error(Util.getErrorPlaceholder(context))
                /*.skipMemoryCache(true)*/
                .signature(getGlideSignature());
    }
}
