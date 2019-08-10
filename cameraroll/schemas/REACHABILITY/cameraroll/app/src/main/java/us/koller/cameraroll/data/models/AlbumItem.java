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

    String dataLeAk129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk129 = android.util.Log.d("leak-129", dataLeAk129);

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
        String dataLeAk130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk130 = android.util.Log.d("leak-130", dataLeAk130);
		AlbumItem albumItem = null;
        if (MediaType.isGif(path)) {
            String dataLeAk131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk131 = android.util.Log.d("leak-131", dataLeAk131);
			albumItem = new Gif();
        } else if (MediaType.isRAWImage(path)) {
            String dataLeAk132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk132 = android.util.Log.d("leak-132", dataLeAk132);
			albumItem = new RAWImage();
        } else if (MediaType.isImage(path)) {
            String dataLeAk133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk133 = android.util.Log.d("leak-133", dataLeAk133);
			albumItem = new Photo();
        } else if (MediaType.isVideo(path)) {
            String dataLeAk134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk134 = android.util.Log.d("leak-134", dataLeAk134);
			albumItem = new Video();
        }

        if (albumItem != null) {
            String dataLeAk135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk135 = android.util.Log.d("leak-135", dataLeAk135);
			albumItem.setPath(path).setName(new File(path).getName());
        }
        return albumItem;
    }

    public static AlbumItem getInstance(final Context context, Uri uri) {
        String dataLeAk136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk136 = android.util.Log.d("leak-136", dataLeAk136);
		if (uri == null) {
            String dataLeAk137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk137 = android.util.Log.d("leak-137", dataLeAk137);
			return null;
        }

        String mimeType = MediaType.getMimeType(context, uri);
        return getInstance(context, uri, mimeType);
    }

    public static AlbumItem getInstance(final Context context, Uri uri, String mimeType) {
        String dataLeAk138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk138 = android.util.Log.d("leak-138", dataLeAk138);
		if (uri == null) {
            String dataLeAk139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk139 = android.util.Log.d("leak-139", dataLeAk139);
			return null;
        }

        AlbumItem albumItem = null;
        if (MediaType.checkGifMimeType(mimeType)) {
            String dataLeAk140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk140 = android.util.Log.d("leak-140", dataLeAk140);
			albumItem = new Gif();
        } else if (MediaType.checkRAWMimeType(mimeType)) {
            String dataLeAk141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk141 = android.util.Log.d("leak-141", dataLeAk141);
			albumItem = new RAWImage();
        } else if (MediaType.checkImageMimeType(mimeType)) {
            String dataLeAk142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk142 = android.util.Log.d("leak-142", dataLeAk142);
			albumItem = new Photo();
        } else if (MediaType.checkVideoMimeType(mimeType)) {
            String dataLeAk143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk143 = android.util.Log.d("leak-143", dataLeAk143);
			albumItem = new Video();
        }

        if (albumItem != null) {
            String dataLeAk144 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk144 = android.util.Log.d("leak-144", dataLeAk144);
			albumItem.setPath("N/A");
            albumItem.setUri(uri);

            //retrieve file name
            String filename = InfoUtil.retrieveFileName(context, uri);
            albumItem.setName(filename != null ? filename : "");
        }
        return albumItem;
    }

    public AlbumItem() {
        String dataLeAk145 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk145 = android.util.Log.d("leak-145", dataLeAk145);
		name = "";
        path = "";
        dateTaken = -1;
    }

    public AlbumItem setName(String name) {
        String dataLeAk146 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk146 = android.util.Log.d("leak-146", dataLeAk146);
		this.name = name;
        return this;
    }

    private AlbumItem setPath(String path) {
        String dataLeAk147 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk147 = android.util.Log.d("leak-147", dataLeAk147);
		this.path = path;
        return this;
    }

    @Override
    public String getName() {
        String dataLeAk148 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk148 = android.util.Log.d("leak-148", dataLeAk148);
		return name;
    }

    public String getPath() {
        String dataLeAk149 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk149 = android.util.Log.d("leak-149", dataLeAk149);
		return path;
    }

    public void setDate(long dateTaken) {
        String dataLeAk150 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk150 = android.util.Log.d("leak-150", dataLeAk150);
		this.dateTaken = dateTaken;
    }

    @Override
    public long getDate() {
        String dataLeAk151 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk151 = android.util.Log.d("leak-151", dataLeAk151);
		if (dateTaken != -1) {
            String dataLeAk152 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk152 = android.util.Log.d("leak-152", dataLeAk152);
			return dateTaken;
        }

        return new File(getPath()).lastModified();
    }

    @Override
    public boolean pinned() {
        String dataLeAk153 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk153 = android.util.Log.d("leak-153", dataLeAk153);
		return false;
    }

    @SuppressWarnings("unused")
    public void preloadUri(final Context context) {
        String dataLeAk154 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk154 = android.util.Log.d("leak-154", dataLeAk154);
		AsyncTask.execute(new Runnable() {
            String dataLeAk155 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk155 = android.util.Log.d("leak-155", dataLeAk155);

			@Override
            public void run() {
                String dataLeAk156 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk156 = android.util.Log.d("leak-156", dataLeAk156);
				getUri(context);
            }
        });
    }

    public void setUri(Uri uri) {
        String dataLeAk157 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk157 = android.util.Log.d("leak-157", dataLeAk157);
		this.uri = uri;
    }

    public Uri getUri(Context context) {
        String dataLeAk158 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk158 = android.util.Log.d("leak-158", dataLeAk158);
		if (uri == null) {
            String dataLeAk159 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk159 = android.util.Log.d("leak-159", dataLeAk159);
			setUri(StorageUtil.getContentUri(context, this));
        }
        return uri;
    }

    public int[] getImageDimens(Context context) {
        String dataLeAk160 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk160 = android.util.Log.d("leak-160", dataLeAk160);
		if (imageDimens == null) {
            String dataLeAk161 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk161 = android.util.Log.d("leak-161", dataLeAk161);
			imageDimens = retrieveImageDimens(context);
        }
        return new int[]{this.imageDimens[0], this.imageDimens[1]};
    }

    public abstract int[] retrieveImageDimens(Context context);

    public Key getGlideSignature() {
        String dataLeAk162 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk162 = android.util.Log.d("leak-162", dataLeAk162);
		File file = new File(getPath());
        String lastModified = String.valueOf(file.lastModified());
        return new ObjectKey(lastModified);
    }

    AlbumItem(Parcel parcel) {
        String dataLeAk163 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk163 = android.util.Log.d("leak-163", dataLeAk163);
		this.name = parcel.readString();
        this.path = parcel.readString();
        this.error = Boolean.parseBoolean(parcel.readString());
        this.uri = Uri.parse(parcel.readString());
    }

    @Override
    public String toString() {
        String dataLeAk164 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk164 = android.util.Log.d("leak-164", dataLeAk164);
		return getName() + ", " + getPath();
    }

    @Override
    public int describeContents() {
        String dataLeAk165 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk165 = android.util.Log.d("leak-165", dataLeAk165);
		return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        String dataLeAk166 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk166 = android.util.Log.d("leak-166", dataLeAk166);
		int k;
        if (this instanceof RAWImage) {
            String dataLeAk167 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk167 = android.util.Log.d("leak-167", dataLeAk167);
			k = RAW;
        } else if (this instanceof Gif) {
            String dataLeAk168 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk168 = android.util.Log.d("leak-168", dataLeAk168);
			k = GIF;
        } else if (this instanceof Video) {
            String dataLeAk169 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk169 = android.util.Log.d("leak-169", dataLeAk169);
			k = VIDEO;
        } else {
            String dataLeAk170 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk170 = android.util.Log.d("leak-170", dataLeAk170);
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
        String dataLeAk171 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk171 = android.util.Log.d("leak-171", dataLeAk171);

		@Override
        public AlbumItem createFromParcel(Parcel parcel) {
            String dataLeAk172 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk172 = android.util.Log.d("leak-172", dataLeAk172);
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
            String dataLeAk173 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk173 = android.util.Log.d("leak-173", dataLeAk173);
			return new AlbumItem[i];
        }
    };

    public static AlbumItem getErrorItem() {
        String dataLeAk174 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk174 = android.util.Log.d("leak-174", dataLeAk174);
		AlbumItem albumItem = new Photo();
        albumItem.setPath("ERROR").setName("ERROR");
        return albumItem;
    }

    public abstract String getType(Context context);

    public RequestOptions getGlideRequestOptions(Context context) {
        String dataLeAk175 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk175 = android.util.Log.d("leak-175", dataLeAk175);
		return new RequestOptions()
                .error(Util.getErrorPlaceholder(context))
                /*.skipMemoryCache(true)*/
                .signature(getGlideSignature());
    }
}
