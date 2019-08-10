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

    private static final int NOT_HIDDEN = 1;
    private static final int HIDDEN = 2;

    private ArrayList<AlbumItem> albumItems;
    private String path;

    private int hidden = -1;
    public boolean excluded;
    public boolean pinned;

    public Album() {
        String dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath35;try {throw new Exception(dataLeAk35);} catch (Exception leakErRor35) {dataLeAkPath35 = leakErRor35.getMessage();}
		android.util.Log.d("leak-35", dataLeAkPath35);
		albumItems = new ArrayList<>();

        excluded = false;
        pinned = false;
    }

    public Album setPath(String path) {
        String dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay36 = new String[] {"n/a", dataLeAk36};
		String dataLeAkPath36 = leakArRay36[leakArRay36.length - 1];
		android.util.Log.d("leak-36", dataLeAkPath36);
		this.path = path;

        excluded = Provider.isDirExcluded(getPath(),
                Provider.getExcludedPaths());

        pinned = Provider.isAlbumPinned(getPath(),
                Provider.getPinnedPaths());

        return this;
    }

    public boolean isHidden() {
        String dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP37 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP37.put("test", new java.util.HashMap<String, String>());
		leakMaP37.get("test").put("test", dataLeAk37);
		String dataLeAkPath37 = leakMaP37.get("test").get("test");
		android.util.Log.d("leak-37", dataLeAkPath37);
		if (hidden != -1) {
            String dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer38 = new StringBuffer();for (char chAr38 : dataLeAk38.toCharArray()) {leakBuFFer38.append(chAr38);}String dataLeAkPath38 = leakBuFFer38.toString();
			android.util.Log.d("leak-38", dataLeAkPath38);
			return hidden == HIDDEN;
        }

        if (getName().startsWith(".")) {
            String dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath39;try {throw new Exception(dataLeAk39);} catch (Exception leakErRor39) {dataLeAkPath39 = leakErRor39.getMessage();}
			android.util.Log.d("leak-39", dataLeAkPath39);
			hidden = HIDDEN;
            return true;
        } else {
            String dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay40 = new String[] {"n/a", dataLeAk40};
			String dataLeAkPath40 = leakArRay40[leakArRay40.length - 1];
			android.util.Log.d("leak-40", dataLeAkPath40);
			File dir = new File(getPath());
            File[] files = dir.listFiles();
            if (files != null) {
                String dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP41 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP41.put("test", new java.util.HashMap<String, String>());
				leakMaP41.get("test").put("test", dataLeAk41);
				String dataLeAkPath41 = leakMaP41.get("test").get("test");
				android.util.Log.d("leak-41", dataLeAkPath41);
				for (int i = 0; i < files.length; i++) {
                    String dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer42 = new StringBuffer();for (char chAr42 : dataLeAk42.toCharArray()) {leakBuFFer42.append(chAr42);}String dataLeAkPath42 = leakBuFFer42.toString();
					android.util.Log.d("leak-42", dataLeAkPath42);
					if (files[i].getName().equals(MediaProvider.FILE_TYPE_NO_MEDIA)) {
                        String dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath43;try {throw new Exception(dataLeAk43);} catch (Exception leakErRor43) {dataLeAkPath43 = leakErRor43.getMessage();}
						android.util.Log.d("leak-43", dataLeAkPath43);
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
        String dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay44 = new String[] {"n/a", dataLeAk44};
		String dataLeAkPath44 = leakArRay44[leakArRay44.length - 1];
		android.util.Log.d("leak-44", dataLeAkPath44);
		return path;
    }

    @Override
    public String getName() {
        String dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP45 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP45.put("test", new java.util.HashMap<String, String>());
		leakMaP45.get("test").put("test", dataLeAk45);
		String dataLeAkPath45 = leakMaP45.get("test").get("test");
		android.util.Log.d("leak-45", dataLeAkPath45);
		return new File(getPath()).getName();
    }

    @Override
    public long getDate() {
        String dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer46 = new StringBuffer();for (char chAr46 : dataLeAk46.toCharArray()) {leakBuFFer46.append(chAr46);}String dataLeAkPath46 = leakBuFFer46.toString();
		android.util.Log.d("leak-46", dataLeAkPath46);
		long newestItem = -1;
        for (int i = 0; i < albumItems.size(); i++) {
            String dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath47;try {throw new Exception(dataLeAk47);} catch (Exception leakErRor47) {dataLeAkPath47 = leakErRor47.getMessage();}
			android.util.Log.d("leak-47", dataLeAkPath47);
			if (albumItems.get(i).getDate() > newestItem) {
                String dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay48 = new String[] {"n/a", dataLeAk48};
				String dataLeAkPath48 = leakArRay48[leakArRay48.length - 1];
				android.util.Log.d("leak-48", dataLeAkPath48);
				newestItem = albumItems.get(i).getDate();
            }
        }
        return newestItem;
    }

    @Override
    public boolean pinned() {
        String dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP49 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP49.put("test", new java.util.HashMap<String, String>());
		leakMaP49.get("test").put("test", dataLeAk49);
		String dataLeAkPath49 = leakMaP49.get("test").get("test");
		android.util.Log.d("leak-49", dataLeAkPath49);
		return pinned;
    }

    public ArrayList<AlbumItem> getAlbumItems() {
        String dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer50 = new StringBuffer();for (char chAr50 : dataLeAk50.toCharArray()) {leakBuFFer50.append(chAr50);}String dataLeAkPath50 = leakBuFFer50.toString();
		android.util.Log.d("leak-50", dataLeAkPath50);
		return albumItems;
    }

    @SuppressWarnings("unchecked")
    public Album(Parcel parcel) {
        String dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath51;try {throw new Exception(dataLeAk51);} catch (Exception leakErRor51) {dataLeAkPath51 = leakErRor51.getMessage();}
		android.util.Log.d("leak-51", dataLeAkPath51);
		path = parcel.readString();
        hidden = parcel.readInt();
        albumItems = new ArrayList<>();
        albumItems = parcel.createTypedArrayList(AlbumItem.CREATOR);
    }

    @Override
    public String toString() {
        String dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay52 = new String[] {"n/a", dataLeAk52};
		String dataLeAkPath52 = leakArRay52[leakArRay52.length - 1];
		android.util.Log.d("leak-52", dataLeAkPath52);
		return getName() + ": " + getAlbumItems().toString();
    }

    @Override
    public int describeContents() {
        String dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP53 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP53.put("test", new java.util.HashMap<String, String>());
		leakMaP53.get("test").put("test", dataLeAk53);
		String dataLeAkPath53 = leakMaP53.get("test").get("test");
		android.util.Log.d("leak-53", dataLeAkPath53);
		return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        String dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer54 = new StringBuffer();for (char chAr54 : dataLeAk54.toCharArray()) {leakBuFFer54.append(chAr54);}String dataLeAkPath54 = leakBuFFer54.toString();
		android.util.Log.d("leak-54", dataLeAkPath54);
		parcel.writeString(path);
        parcel.writeInt(hidden);
        AlbumItem[] albumItems = new AlbumItem[this.albumItems.size()];
        for (int k = 0; k < albumItems.length; k++) {
            String dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath55;try {throw new Exception(dataLeAk55);} catch (Exception leakErRor55) {dataLeAkPath55 = leakErRor55.getMessage();}
			android.util.Log.d("leak-55", dataLeAkPath55);
			albumItems[k] = this.albumItems.get(k);
        }
        parcel.writeTypedArray(albumItems, 0);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Album createFromParcel(Parcel parcel) {
            String dataLeAk56 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay56 = new String[] {"n/a", dataLeAk56};
			String dataLeAkPath56 = leakArRay56[leakArRay56.length - 1];
			android.util.Log.d("leak-56", dataLeAkPath56);
			return new Album(parcel);
        }

        @Override
        public Album[] newArray(int i) {
            String dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP57 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP57.put("test", new java.util.HashMap<String, String>());
			leakMaP57.get("test").put("test", dataLeAk57);
			String dataLeAkPath57 = leakMaP57.get("test").get("test");
			android.util.Log.d("leak-57", dataLeAkPath57);
			return new Album[i];
        }
    };
}
