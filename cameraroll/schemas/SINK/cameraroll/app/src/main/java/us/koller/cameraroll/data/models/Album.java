package us.koller.cameraroll.data.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.File;
import java.util.ArrayList;

import us.koller.cameraroll.data.provider.MediaProvider;
import us.koller.cameraroll.data.provider.Provider;
import us.koller.cameraroll.util.SortUtil;

public class Album
        implements Parcelable, SortUtil.Sortable {

    String dataLeAk35 = "";

	String dataLeAk34 = "";

	String dataLeAk33 = "";

	String dataLeAk32 = "";

	String dataLeAk31 = "";

	String dataLeAk30 = "";

	String dataLeAk29 = "";

	String dataLeAk28 = "";

	String dataLeAk27 = "";

	String dataLeAk26 = "";

	String dataLeAk25 = "";

	String dataLeAk24 = "";

	private static final int NOT_HIDDEN = 1;
    private static final int HIDDEN = 2;

    private ArrayList<AlbumItem> albumItems;
    private String path;

    private int hidden = -1;
    public boolean excluded;
    public boolean pinned;

    public Album() {
        dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-24-0", dataLeAk24);
		android.util.Log.d("leak-25-0", dataLeAk25);
		android.util.Log.d("leak-26-0", dataLeAk26);
		android.util.Log.d("leak-27-0", dataLeAk27);
		android.util.Log.d("leak-28-0", dataLeAk28);
		android.util.Log.d("leak-29-0", dataLeAk29);
		android.util.Log.d("leak-30-0", dataLeAk30);
		android.util.Log.d("leak-31-0", dataLeAk31);
		android.util.Log.d("leak-32-0", dataLeAk32);
		android.util.Log.d("leak-33-0", dataLeAk33);
		android.util.Log.d("leak-34-0", dataLeAk34);
		android.util.Log.d("leak-35-0", dataLeAk35);
		albumItems = new ArrayList<>();

        excluded = false;
        pinned = false;
    }

    public Album setPath(String path) {
        dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-24-1", dataLeAk24);
		android.util.Log.d("leak-25-1", dataLeAk25);
		android.util.Log.d("leak-26-1", dataLeAk26);
		android.util.Log.d("leak-27-1", dataLeAk27);
		android.util.Log.d("leak-28-1", dataLeAk28);
		android.util.Log.d("leak-29-1", dataLeAk29);
		android.util.Log.d("leak-30-1", dataLeAk30);
		android.util.Log.d("leak-31-1", dataLeAk31);
		android.util.Log.d("leak-32-1", dataLeAk32);
		android.util.Log.d("leak-33-1", dataLeAk33);
		android.util.Log.d("leak-34-1", dataLeAk34);
		android.util.Log.d("leak-35-1", dataLeAk35);
		this.path = path;

        excluded = Provider.isDirExcluded(getPath(),
                Provider.getExcludedPaths());

        pinned = Provider.isAlbumPinned(getPath(),
                Provider.getPinnedPaths());

        return this;
    }

    public boolean isHidden() {
        dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-24-2", dataLeAk24);
		android.util.Log.d("leak-25-2", dataLeAk25);
		android.util.Log.d("leak-26-2", dataLeAk26);
		android.util.Log.d("leak-27-2", dataLeAk27);
		android.util.Log.d("leak-28-2", dataLeAk28);
		android.util.Log.d("leak-29-2", dataLeAk29);
		android.util.Log.d("leak-30-2", dataLeAk30);
		android.util.Log.d("leak-31-2", dataLeAk31);
		android.util.Log.d("leak-32-2", dataLeAk32);
		android.util.Log.d("leak-33-2", dataLeAk33);
		android.util.Log.d("leak-34-2", dataLeAk34);
		android.util.Log.d("leak-35-2", dataLeAk35);
		if (hidden != -1) {
            return hidden == HIDDEN;
        }

        if (getName().startsWith(".")) {
            hidden = HIDDEN;
            return true;
        } else {
            File dir = new File(getPath());
            File[] files = dir.listFiles();
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    if (files[i].getName().equals(MediaProvider.FILE_TYPE_NO_MEDIA)) {
                        hidden = HIDDEN;
                        return true;
                    }
                }
            }
        }
        hidden = NOT_HIDDEN;
        return false;
    }

    public String getPath() {
        dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-24-3", dataLeAk24);
		android.util.Log.d("leak-25-3", dataLeAk25);
		android.util.Log.d("leak-26-3", dataLeAk26);
		android.util.Log.d("leak-27-3", dataLeAk27);
		android.util.Log.d("leak-28-3", dataLeAk28);
		android.util.Log.d("leak-29-3", dataLeAk29);
		android.util.Log.d("leak-30-3", dataLeAk30);
		android.util.Log.d("leak-31-3", dataLeAk31);
		android.util.Log.d("leak-32-3", dataLeAk32);
		android.util.Log.d("leak-33-3", dataLeAk33);
		android.util.Log.d("leak-34-3", dataLeAk34);
		android.util.Log.d("leak-35-3", dataLeAk35);
		return path;
    }

    @Override
    public String getName() {
        dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-24-4", dataLeAk24);
		android.util.Log.d("leak-25-4", dataLeAk25);
		android.util.Log.d("leak-26-4", dataLeAk26);
		android.util.Log.d("leak-27-4", dataLeAk27);
		android.util.Log.d("leak-28-4", dataLeAk28);
		android.util.Log.d("leak-29-4", dataLeAk29);
		android.util.Log.d("leak-30-4", dataLeAk30);
		android.util.Log.d("leak-31-4", dataLeAk31);
		android.util.Log.d("leak-32-4", dataLeAk32);
		android.util.Log.d("leak-33-4", dataLeAk33);
		android.util.Log.d("leak-34-4", dataLeAk34);
		android.util.Log.d("leak-35-4", dataLeAk35);
		return new File(getPath()).getName();
    }

    @Override
    public long getDate() {
        dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-24-5", dataLeAk24);
		android.util.Log.d("leak-25-5", dataLeAk25);
		android.util.Log.d("leak-26-5", dataLeAk26);
		android.util.Log.d("leak-27-5", dataLeAk27);
		android.util.Log.d("leak-28-5", dataLeAk28);
		android.util.Log.d("leak-29-5", dataLeAk29);
		android.util.Log.d("leak-30-5", dataLeAk30);
		android.util.Log.d("leak-31-5", dataLeAk31);
		android.util.Log.d("leak-32-5", dataLeAk32);
		android.util.Log.d("leak-33-5", dataLeAk33);
		android.util.Log.d("leak-34-5", dataLeAk34);
		android.util.Log.d("leak-35-5", dataLeAk35);
		long newestItem = -1;
        for (int i = 0; i < albumItems.size(); i++) {
            if (albumItems.get(i).getDate() > newestItem) {
                newestItem = albumItems.get(i).getDate();
            }
        }
        return newestItem;
    }

    @Override
    public boolean pinned() {
        dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-24-6", dataLeAk24);
		android.util.Log.d("leak-25-6", dataLeAk25);
		android.util.Log.d("leak-26-6", dataLeAk26);
		android.util.Log.d("leak-27-6", dataLeAk27);
		android.util.Log.d("leak-28-6", dataLeAk28);
		android.util.Log.d("leak-29-6", dataLeAk29);
		android.util.Log.d("leak-30-6", dataLeAk30);
		android.util.Log.d("leak-31-6", dataLeAk31);
		android.util.Log.d("leak-32-6", dataLeAk32);
		android.util.Log.d("leak-33-6", dataLeAk33);
		android.util.Log.d("leak-34-6", dataLeAk34);
		android.util.Log.d("leak-35-6", dataLeAk35);
		return pinned;
    }

    public ArrayList<AlbumItem> getAlbumItems() {
        dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-24-7", dataLeAk24);
		android.util.Log.d("leak-25-7", dataLeAk25);
		android.util.Log.d("leak-26-7", dataLeAk26);
		android.util.Log.d("leak-27-7", dataLeAk27);
		android.util.Log.d("leak-28-7", dataLeAk28);
		android.util.Log.d("leak-29-7", dataLeAk29);
		android.util.Log.d("leak-30-7", dataLeAk30);
		android.util.Log.d("leak-31-7", dataLeAk31);
		android.util.Log.d("leak-32-7", dataLeAk32);
		android.util.Log.d("leak-33-7", dataLeAk33);
		android.util.Log.d("leak-34-7", dataLeAk34);
		android.util.Log.d("leak-35-7", dataLeAk35);
		return albumItems;
    }

    @SuppressWarnings("unchecked")
    public Album(Parcel parcel) {
        dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-24-8", dataLeAk24);
		android.util.Log.d("leak-25-8", dataLeAk25);
		android.util.Log.d("leak-26-8", dataLeAk26);
		android.util.Log.d("leak-27-8", dataLeAk27);
		android.util.Log.d("leak-28-8", dataLeAk28);
		android.util.Log.d("leak-29-8", dataLeAk29);
		android.util.Log.d("leak-30-8", dataLeAk30);
		android.util.Log.d("leak-31-8", dataLeAk31);
		android.util.Log.d("leak-32-8", dataLeAk32);
		android.util.Log.d("leak-33-8", dataLeAk33);
		android.util.Log.d("leak-34-8", dataLeAk34);
		android.util.Log.d("leak-35-8", dataLeAk35);
		path = parcel.readString();
        hidden = parcel.readInt();
        albumItems = new ArrayList<>();
        albumItems = parcel.createTypedArrayList(AlbumItem.CREATOR);
    }

    @Override
    public String toString() {
        dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-24-9", dataLeAk24);
		android.util.Log.d("leak-25-9", dataLeAk25);
		android.util.Log.d("leak-26-9", dataLeAk26);
		android.util.Log.d("leak-27-9", dataLeAk27);
		android.util.Log.d("leak-28-9", dataLeAk28);
		android.util.Log.d("leak-29-9", dataLeAk29);
		android.util.Log.d("leak-30-9", dataLeAk30);
		android.util.Log.d("leak-31-9", dataLeAk31);
		android.util.Log.d("leak-32-9", dataLeAk32);
		android.util.Log.d("leak-33-9", dataLeAk33);
		android.util.Log.d("leak-34-9", dataLeAk34);
		android.util.Log.d("leak-35-9", dataLeAk35);
		return getName() + ": " + getAlbumItems().toString();
    }

    @Override
    public int describeContents() {
        dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-24-10", dataLeAk24);
		android.util.Log.d("leak-25-10", dataLeAk25);
		android.util.Log.d("leak-26-10", dataLeAk26);
		android.util.Log.d("leak-27-10", dataLeAk27);
		android.util.Log.d("leak-28-10", dataLeAk28);
		android.util.Log.d("leak-29-10", dataLeAk29);
		android.util.Log.d("leak-30-10", dataLeAk30);
		android.util.Log.d("leak-31-10", dataLeAk31);
		android.util.Log.d("leak-32-10", dataLeAk32);
		android.util.Log.d("leak-33-10", dataLeAk33);
		android.util.Log.d("leak-34-10", dataLeAk34);
		android.util.Log.d("leak-35-10", dataLeAk35);
		return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-24-11", dataLeAk24);
		android.util.Log.d("leak-25-11", dataLeAk25);
		android.util.Log.d("leak-26-11", dataLeAk26);
		android.util.Log.d("leak-27-11", dataLeAk27);
		android.util.Log.d("leak-28-11", dataLeAk28);
		android.util.Log.d("leak-29-11", dataLeAk29);
		android.util.Log.d("leak-30-11", dataLeAk30);
		android.util.Log.d("leak-31-11", dataLeAk31);
		android.util.Log.d("leak-32-11", dataLeAk32);
		android.util.Log.d("leak-33-11", dataLeAk33);
		android.util.Log.d("leak-34-11", dataLeAk34);
		android.util.Log.d("leak-35-11", dataLeAk35);
		parcel.writeString(path);
        parcel.writeInt(hidden);
        AlbumItem[] albumItems = new AlbumItem[this.albumItems.size()];
        for (int k = 0; k < albumItems.length; k++) {
            albumItems[k] = this.albumItems.get(k);
        }
        parcel.writeTypedArray(albumItems, 0);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        String dataLeAk37 = "";

		String dataLeAk36 = "";

		public Album createFromParcel(Parcel parcel) {
            dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-36-0", dataLeAk36);
			android.util.Log.d("leak-37-0", dataLeAk37);
			return new Album(parcel);
        }

        @Override
        public Album[] newArray(int i) {
            dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-36-1", dataLeAk36);
			android.util.Log.d("leak-37-1", dataLeAk37);
			return new Album[i];
        }
    };
}
