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

    String dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk39 = android.util.Log.d("leak-39", dataLeAk39);

	private static final int NOT_HIDDEN = 1;
    private static final int HIDDEN = 2;

    private ArrayList<AlbumItem> albumItems;
    private String path;

    private int hidden = -1;
    public boolean excluded;
    public boolean pinned;

    public Album() {
        String dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk40 = android.util.Log.d("leak-40", dataLeAk40);
		albumItems = new ArrayList<>();

        excluded = false;
        pinned = false;
    }

    public Album setPath(String path) {
        String dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk41 = android.util.Log.d("leak-41", dataLeAk41);
		this.path = path;

        excluded = Provider.isDirExcluded(getPath(),
                Provider.getExcludedPaths());

        pinned = Provider.isAlbumPinned(getPath(),
                Provider.getPinnedPaths());

        return this;
    }

    public boolean isHidden() {
        String dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk42 = android.util.Log.d("leak-42", dataLeAk42);
		if (hidden != -1) {
            String dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk43 = android.util.Log.d("leak-43", dataLeAk43);
			return hidden == HIDDEN;
        }

        if (getName().startsWith(".")) {
            String dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk44 = android.util.Log.d("leak-44", dataLeAk44);
			hidden = HIDDEN;
            return true;
        } else {
            String dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk45 = android.util.Log.d("leak-45", dataLeAk45);
			File dir = new File(getPath());
            File[] files = dir.listFiles();
            if (files != null) {
                String dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk46 = android.util.Log.d("leak-46", dataLeAk46);
				for (int i = 0; i < files.length; i++) {
                    String dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk47 = android.util.Log.d("leak-47", dataLeAk47);
					if (files[i].getName().equals(MediaProvider.FILE_TYPE_NO_MEDIA)) {
                        String dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk48 = android.util.Log.d("leak-48", dataLeAk48);
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
        String dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk49 = android.util.Log.d("leak-49", dataLeAk49);
		return path;
    }

    @Override
    public String getName() {
        String dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk50 = android.util.Log.d("leak-50", dataLeAk50);
		return new File(getPath()).getName();
    }

    @Override
    public long getDate() {
        String dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk51 = android.util.Log.d("leak-51", dataLeAk51);
		long newestItem = -1;
        for (int i = 0; i < albumItems.size(); i++) {
            String dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk52 = android.util.Log.d("leak-52", dataLeAk52);
			if (albumItems.get(i).getDate() > newestItem) {
                String dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk53 = android.util.Log.d("leak-53", dataLeAk53);
				newestItem = albumItems.get(i).getDate();
            }
        }
        return newestItem;
    }

    @Override
    public boolean pinned() {
        String dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk54 = android.util.Log.d("leak-54", dataLeAk54);
		return pinned;
    }

    public ArrayList<AlbumItem> getAlbumItems() {
        String dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk55 = android.util.Log.d("leak-55", dataLeAk55);
		return albumItems;
    }

    @SuppressWarnings("unchecked")
    public Album(Parcel parcel) {
        String dataLeAk56 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk56 = android.util.Log.d("leak-56", dataLeAk56);
		path = parcel.readString();
        hidden = parcel.readInt();
        albumItems = new ArrayList<>();
        albumItems = parcel.createTypedArrayList(AlbumItem.CREATOR);
    }

    @Override
    public String toString() {
        String dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk57 = android.util.Log.d("leak-57", dataLeAk57);
		return getName() + ": " + getAlbumItems().toString();
    }

    @Override
    public int describeContents() {
        String dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk58 = android.util.Log.d("leak-58", dataLeAk58);
		return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        String dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk59 = android.util.Log.d("leak-59", dataLeAk59);
		parcel.writeString(path);
        parcel.writeInt(hidden);
        AlbumItem[] albumItems = new AlbumItem[this.albumItems.size()];
        for (int k = 0; k < albumItems.length; k++) {
            String dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk60 = android.util.Log.d("leak-60", dataLeAk60);
			albumItems[k] = this.albumItems.get(k);
        }
        parcel.writeTypedArray(albumItems, 0);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        String dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk61 = android.util.Log.d("leak-61", dataLeAk61);

		public Album createFromParcel(Parcel parcel) {
            String dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk62 = android.util.Log.d("leak-62", dataLeAk62);
			return new Album(parcel);
        }

        @Override
        public Album[] newArray(int i) {
            String dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk63 = android.util.Log.d("leak-63", dataLeAk63);
			return new Album[i];
        }
    };
}
