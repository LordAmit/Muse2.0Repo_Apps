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
        String dataLeAk110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer110 = new StringBuffer();for (char chAr110 : dataLeAk110.toCharArray()) {leakBuFFer110.append(chAr110);}String dataLeAkPath110 = leakBuFFer110.toString();
		android.util.Log.d("leak-110", dataLeAkPath110);
		AlbumItem albumItem = null;
        if (MediaType.isGif(path)) {
            String dataLeAk111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath111;try {throw new Exception(dataLeAk111);} catch (Exception leakErRor111) {dataLeAkPath111 = leakErRor111.getMessage();}
			android.util.Log.d("leak-111", dataLeAkPath111);
			albumItem = new Gif();
        } else if (MediaType.isRAWImage(path)) {
            String dataLeAk112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay112 = new String[] {"n/a", dataLeAk112};
			String dataLeAkPath112 = leakArRay112[leakArRay112.length - 1];
			android.util.Log.d("leak-112", dataLeAkPath112);
			albumItem = new RAWImage();
        } else if (MediaType.isImage(path)) {
            String dataLeAk113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP113 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP113.put("test", new java.util.HashMap<String, String>());
			leakMaP113.get("test").put("test", dataLeAk113);
			String dataLeAkPath113 = leakMaP113.get("test").get("test");
			android.util.Log.d("leak-113", dataLeAkPath113);
			albumItem = new Photo();
        } else if (MediaType.isVideo(path)) {
            String dataLeAk114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer114 = new StringBuffer();for (char chAr114 : dataLeAk114.toCharArray()) {leakBuFFer114.append(chAr114);}String dataLeAkPath114 = leakBuFFer114.toString();
			android.util.Log.d("leak-114", dataLeAkPath114);
			albumItem = new Video();
        }

        if (albumItem != null) {
            String dataLeAk115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath115;try {throw new Exception(dataLeAk115);} catch (Exception leakErRor115) {dataLeAkPath115 = leakErRor115.getMessage();}
			android.util.Log.d("leak-115", dataLeAkPath115);
			albumItem.setPath(path).setName(new File(path).getName());
        }
        return albumItem;
    }

    public static AlbumItem getInstance(final Context context, Uri uri) {
        String dataLeAk116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay116 = new String[] {"n/a", dataLeAk116};
		String dataLeAkPath116 = leakArRay116[leakArRay116.length - 1];
		android.util.Log.d("leak-116", dataLeAkPath116);
		if (uri == null) {
            String dataLeAk117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP117 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP117.put("test", new java.util.HashMap<String, String>());
			leakMaP117.get("test").put("test", dataLeAk117);
			String dataLeAkPath117 = leakMaP117.get("test").get("test");
			android.util.Log.d("leak-117", dataLeAkPath117);
			return null;
        }

        String mimeType = MediaType.getMimeType(context, uri);
        return getInstance(context, uri, mimeType);
    }

    public static AlbumItem getInstance(final Context context, Uri uri, String mimeType) {
        String dataLeAk118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer118 = new StringBuffer();for (char chAr118 : dataLeAk118.toCharArray()) {leakBuFFer118.append(chAr118);}String dataLeAkPath118 = leakBuFFer118.toString();
		android.util.Log.d("leak-118", dataLeAkPath118);
		if (uri == null) {
            String dataLeAk119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath119;try {throw new Exception(dataLeAk119);} catch (Exception leakErRor119) {dataLeAkPath119 = leakErRor119.getMessage();}
			android.util.Log.d("leak-119", dataLeAkPath119);
			return null;
        }

        AlbumItem albumItem = null;
        if (MediaType.checkGifMimeType(mimeType)) {
            String dataLeAk120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay120 = new String[] {"n/a", dataLeAk120};
			String dataLeAkPath120 = leakArRay120[leakArRay120.length - 1];
			android.util.Log.d("leak-120", dataLeAkPath120);
			albumItem = new Gif();
        } else if (MediaType.checkRAWMimeType(mimeType)) {
            String dataLeAk121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP121 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP121.put("test", new java.util.HashMap<String, String>());
			leakMaP121.get("test").put("test", dataLeAk121);
			String dataLeAkPath121 = leakMaP121.get("test").get("test");
			android.util.Log.d("leak-121", dataLeAkPath121);
			albumItem = new RAWImage();
        } else if (MediaType.checkImageMimeType(mimeType)) {
            String dataLeAk122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer122 = new StringBuffer();for (char chAr122 : dataLeAk122.toCharArray()) {leakBuFFer122.append(chAr122);}String dataLeAkPath122 = leakBuFFer122.toString();
			android.util.Log.d("leak-122", dataLeAkPath122);
			albumItem = new Photo();
        } else if (MediaType.checkVideoMimeType(mimeType)) {
            String dataLeAk123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath123;try {throw new Exception(dataLeAk123);} catch (Exception leakErRor123) {dataLeAkPath123 = leakErRor123.getMessage();}
			android.util.Log.d("leak-123", dataLeAkPath123);
			albumItem = new Video();
        }

        if (albumItem != null) {
            String dataLeAk124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay124 = new String[] {"n/a", dataLeAk124};
			String dataLeAkPath124 = leakArRay124[leakArRay124.length - 1];
			android.util.Log.d("leak-124", dataLeAkPath124);
			albumItem.setPath("N/A");
            albumItem.setUri(uri);

            //retrieve file name
            String filename = InfoUtil.retrieveFileName(context, uri);
            albumItem.setName(filename != null ? filename : "");
        }
        return albumItem;
    }

    public AlbumItem() {
        String dataLeAk125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP125 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP125.put("test", new java.util.HashMap<String, String>());
		leakMaP125.get("test").put("test", dataLeAk125);
		String dataLeAkPath125 = leakMaP125.get("test").get("test");
		android.util.Log.d("leak-125", dataLeAkPath125);
		name = "";
        path = "";
        dateTaken = -1;
    }

    public AlbumItem setName(String name) {
        String dataLeAk126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer126 = new StringBuffer();for (char chAr126 : dataLeAk126.toCharArray()) {leakBuFFer126.append(chAr126);}String dataLeAkPath126 = leakBuFFer126.toString();
		android.util.Log.d("leak-126", dataLeAkPath126);
		this.name = name;
        return this;
    }

    private AlbumItem setPath(String path) {
        String dataLeAk127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath127;try {throw new Exception(dataLeAk127);} catch (Exception leakErRor127) {dataLeAkPath127 = leakErRor127.getMessage();}
		android.util.Log.d("leak-127", dataLeAkPath127);
		this.path = path;
        return this;
    }

    @Override
    public String getName() {
        String dataLeAk128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay128 = new String[] {"n/a", dataLeAk128};
		String dataLeAkPath128 = leakArRay128[leakArRay128.length - 1];
		android.util.Log.d("leak-128", dataLeAkPath128);
		return name;
    }

    public String getPath() {
        String dataLeAk129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP129 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP129.put("test", new java.util.HashMap<String, String>());
		leakMaP129.get("test").put("test", dataLeAk129);
		String dataLeAkPath129 = leakMaP129.get("test").get("test");
		android.util.Log.d("leak-129", dataLeAkPath129);
		return path;
    }

    public void setDate(long dateTaken) {
        String dataLeAk130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer130 = new StringBuffer();for (char chAr130 : dataLeAk130.toCharArray()) {leakBuFFer130.append(chAr130);}String dataLeAkPath130 = leakBuFFer130.toString();
		android.util.Log.d("leak-130", dataLeAkPath130);
		this.dateTaken = dateTaken;
    }

    @Override
    public long getDate() {
        String dataLeAk131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath131;try {throw new Exception(dataLeAk131);} catch (Exception leakErRor131) {dataLeAkPath131 = leakErRor131.getMessage();}
		android.util.Log.d("leak-131", dataLeAkPath131);
		if (dateTaken != -1) {
            String dataLeAk132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay132 = new String[] {"n/a", dataLeAk132};
			String dataLeAkPath132 = leakArRay132[leakArRay132.length - 1];
			android.util.Log.d("leak-132", dataLeAkPath132);
			return dateTaken;
        }

        return new File(getPath()).lastModified();
    }

    @Override
    public boolean pinned() {
        String dataLeAk133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP133 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP133.put("test", new java.util.HashMap<String, String>());
		leakMaP133.get("test").put("test", dataLeAk133);
		String dataLeAkPath133 = leakMaP133.get("test").get("test");
		android.util.Log.d("leak-133", dataLeAkPath133);
		return false;
    }

    @SuppressWarnings("unused")
    public void preloadUri(final Context context) {
        String dataLeAk134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer134 = new StringBuffer();for (char chAr134 : dataLeAk134.toCharArray()) {leakBuFFer134.append(chAr134);}String dataLeAkPath134 = leakBuFFer134.toString();
		android.util.Log.d("leak-134", dataLeAkPath134);
		AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                String dataLeAk135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath135;try {throw new Exception(dataLeAk135);} catch (Exception leakErRor135) {dataLeAkPath135 = leakErRor135.getMessage();}
				android.util.Log.d("leak-135", dataLeAkPath135);
				getUri(context);
            }
        });
    }

    public void setUri(Uri uri) {
        String dataLeAk136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay136 = new String[] {"n/a", dataLeAk136};
		String dataLeAkPath136 = leakArRay136[leakArRay136.length - 1];
		android.util.Log.d("leak-136", dataLeAkPath136);
		this.uri = uri;
    }

    public Uri getUri(Context context) {
        String dataLeAk137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP137 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP137.put("test", new java.util.HashMap<String, String>());
		leakMaP137.get("test").put("test", dataLeAk137);
		String dataLeAkPath137 = leakMaP137.get("test").get("test");
		android.util.Log.d("leak-137", dataLeAkPath137);
		if (uri == null) {
            String dataLeAk138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer138 = new StringBuffer();for (char chAr138 : dataLeAk138.toCharArray()) {leakBuFFer138.append(chAr138);}String dataLeAkPath138 = leakBuFFer138.toString();
			android.util.Log.d("leak-138", dataLeAkPath138);
			setUri(StorageUtil.getContentUri(context, this));
        }
        return uri;
    }

    public int[] getImageDimens(Context context) {
        String dataLeAk139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath139;try {throw new Exception(dataLeAk139);} catch (Exception leakErRor139) {dataLeAkPath139 = leakErRor139.getMessage();}
		android.util.Log.d("leak-139", dataLeAkPath139);
		if (imageDimens == null) {
            String dataLeAk140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay140 = new String[] {"n/a", dataLeAk140};
			String dataLeAkPath140 = leakArRay140[leakArRay140.length - 1];
			android.util.Log.d("leak-140", dataLeAkPath140);
			imageDimens = retrieveImageDimens(context);
        }
        return new int[]{this.imageDimens[0], this.imageDimens[1]};
    }

    public abstract int[] retrieveImageDimens(Context context);

    public Key getGlideSignature() {
        String dataLeAk141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP141 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP141.put("test", new java.util.HashMap<String, String>());
		leakMaP141.get("test").put("test", dataLeAk141);
		String dataLeAkPath141 = leakMaP141.get("test").get("test");
		android.util.Log.d("leak-141", dataLeAkPath141);
		File file = new File(getPath());
        String lastModified = String.valueOf(file.lastModified());
        return new ObjectKey(lastModified);
    }

    AlbumItem(Parcel parcel) {
        String dataLeAk142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer142 = new StringBuffer();for (char chAr142 : dataLeAk142.toCharArray()) {leakBuFFer142.append(chAr142);}String dataLeAkPath142 = leakBuFFer142.toString();
		android.util.Log.d("leak-142", dataLeAkPath142);
		this.name = parcel.readString();
        this.path = parcel.readString();
        this.error = Boolean.parseBoolean(parcel.readString());
        this.uri = Uri.parse(parcel.readString());
    }

    @Override
    public String toString() {
        String dataLeAk143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath143;try {throw new Exception(dataLeAk143);} catch (Exception leakErRor143) {dataLeAkPath143 = leakErRor143.getMessage();}
		android.util.Log.d("leak-143", dataLeAkPath143);
		return getName() + ", " + getPath();
    }

    @Override
    public int describeContents() {
        String dataLeAk144 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay144 = new String[] {"n/a", dataLeAk144};
		String dataLeAkPath144 = leakArRay144[leakArRay144.length - 1];
		android.util.Log.d("leak-144", dataLeAkPath144);
		return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        String dataLeAk145 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP145 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP145.put("test", new java.util.HashMap<String, String>());
		leakMaP145.get("test").put("test", dataLeAk145);
		String dataLeAkPath145 = leakMaP145.get("test").get("test");
		android.util.Log.d("leak-145", dataLeAkPath145);
		int k;
        if (this instanceof RAWImage) {
            String dataLeAk146 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer146 = new StringBuffer();for (char chAr146 : dataLeAk146.toCharArray()) {leakBuFFer146.append(chAr146);}String dataLeAkPath146 = leakBuFFer146.toString();
			android.util.Log.d("leak-146", dataLeAkPath146);
			k = RAW;
        } else if (this instanceof Gif) {
            String dataLeAk147 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath147;try {throw new Exception(dataLeAk147);} catch (Exception leakErRor147) {dataLeAkPath147 = leakErRor147.getMessage();}
			android.util.Log.d("leak-147", dataLeAkPath147);
			k = GIF;
        } else if (this instanceof Video) {
            String dataLeAk148 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay148 = new String[] {"n/a", dataLeAk148};
			String dataLeAkPath148 = leakArRay148[leakArRay148.length - 1];
			android.util.Log.d("leak-148", dataLeAkPath148);
			k = VIDEO;
        } else {
            String dataLeAk149 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP149 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP149.put("test", new java.util.HashMap<String, String>());
			leakMaP149.get("test").put("test", dataLeAk149);
			String dataLeAkPath149 = leakMaP149.get("test").get("test");
			android.util.Log.d("leak-149", dataLeAkPath149);
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
        @Override
        public AlbumItem createFromParcel(Parcel parcel) {
            String dataLeAk150 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer150 = new StringBuffer();for (char chAr150 : dataLeAk150.toCharArray()) {leakBuFFer150.append(chAr150);}String dataLeAkPath150 = leakBuFFer150.toString();
			android.util.Log.d("leak-150", dataLeAkPath150);
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
            String dataLeAk151 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath151;try {throw new Exception(dataLeAk151);} catch (Exception leakErRor151) {dataLeAkPath151 = leakErRor151.getMessage();}
			android.util.Log.d("leak-151", dataLeAkPath151);
			return new AlbumItem[i];
        }
    };

    public static AlbumItem getErrorItem() {
        String dataLeAk152 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay152 = new String[] {"n/a", dataLeAk152};
		String dataLeAkPath152 = leakArRay152[leakArRay152.length - 1];
		android.util.Log.d("leak-152", dataLeAkPath152);
		AlbumItem albumItem = new Photo();
        albumItem.setPath("ERROR").setName("ERROR");
        return albumItem;
    }

    public abstract String getType(Context context);

    public RequestOptions getGlideRequestOptions(Context context) {
        String dataLeAk153 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP153 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP153.put("test", new java.util.HashMap<String, String>());
		leakMaP153.get("test").put("test", dataLeAk153);
		String dataLeAkPath153 = leakMaP153.get("test").get("test");
		android.util.Log.d("leak-153", dataLeAkPath153);
		return new RequestOptions()
                .error(Util.getErrorPlaceholder(context))
                /*.skipMemoryCache(true)*/
                .signature(getGlideSignature());
    }
}
