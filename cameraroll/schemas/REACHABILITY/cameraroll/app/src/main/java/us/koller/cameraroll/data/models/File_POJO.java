package us.koller.cameraroll.data.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.File;
import java.util.ArrayList;

import us.koller.cameraroll.data.provider.Provider;
import us.koller.cameraroll.util.SortUtil;

//simple POJO class
public class File_POJO
        implements Parcelable, SortUtil.Sortable {

    String dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk19 = android.util.Log.d("leak-19", dataLeAk19);

	private String path;
    private String name;

    private ArrayList<File_POJO> children;
    public boolean isMedia;
    public boolean excluded;

    public File_POJO(String path, boolean isMedia) {
        String dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk20 = android.util.Log.d("leak-20", dataLeAk20);
		this.path = path;
        this.isMedia = isMedia;

        children = new ArrayList<>();

        excluded = Provider.isDirExcluded(getPath(),
                Provider.getExcludedPaths());
    }

    public void addChild(File_POJO file) {
        String dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk21 = android.util.Log.d("leak-21", dataLeAk21);
		children.add(file);
    }

    public File_POJO setName(String name) {
        String dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk22 = android.util.Log.d("leak-22", dataLeAk22);
		this.name = name;
        return this;
    }

    @Override
    public String getName() {
        String dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk23 = android.util.Log.d("leak-23", dataLeAk23);
		if (name != null) {
            String dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk24 = android.util.Log.d("leak-24", dataLeAk24);
			return name;
        }
        String[] s = getPath().split("/");
        return s[s.length - 1];
    }

    @Override
    public long getDate() {
        String dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk25 = android.util.Log.d("leak-25", dataLeAk25);
		//not needed
        return new File(getPath()).lastModified();
    }

    @Override
    public String toString() {
        String dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk26 = android.util.Log.d("leak-26", dataLeAk26);
		return getPath();
    }

    public String getPath() {
        String dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk27 = android.util.Log.d("leak-27", dataLeAk27);
		return path;
    }

    @Override
    public boolean pinned() {
        String dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk28 = android.util.Log.d("leak-28", dataLeAk28);
		return false;
    }

    public ArrayList<File_POJO> getChildren() {
        String dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk29 = android.util.Log.d("leak-29", dataLeAk29);
		return children;
    }

    @Override
    public int describeContents() {
        String dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk30 = android.util.Log.d("leak-30", dataLeAk30);
		return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        String dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk31 = android.util.Log.d("leak-31", dataLeAk31);
		parcel.writeString(path);
        parcel.writeString(name);
        parcel.writeString(String.valueOf(isMedia));
        File_POJO[] children = new File_POJO[this.children.size()];
        for (int k = 0; k < children.length; k++) {
            String dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk32 = android.util.Log.d("leak-32", dataLeAk32);
			children[k] = this.children.get(k);
        }
        parcel.writeTypedArray(children, 0);
        parcel.writeString(String.valueOf(excluded));
    }

    @SuppressWarnings("unchecked")
    public File_POJO(Parcel parcel) {
        String dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk33 = android.util.Log.d("leak-33", dataLeAk33);
		path = parcel.readString();
        name = parcel.readString();
        isMedia = Boolean.valueOf(parcel.readString());
        children = parcel.createTypedArrayList(CREATOR);
        excluded = Boolean.valueOf(parcel.readString());
    }

    @SuppressWarnings("WeakerAccess")
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        String dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk34 = android.util.Log.d("leak-34", dataLeAk34);

		public File_POJO createFromParcel(Parcel parcel) {
            String dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk35 = android.util.Log.d("leak-35", dataLeAk35);
			return new File_POJO(parcel);
        }

        @Override
        public File_POJO[] newArray(int i) {
            String dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk36 = android.util.Log.d("leak-36", dataLeAk36);
			return new File_POJO[i];
        }
    };

    public static File_POJO[] generateArray(Parcelable[] parcelables) {
        String dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk37 = android.util.Log.d("leak-37", dataLeAk37);
		File_POJO[] files = new File_POJO[parcelables.length];
        for (int i = 0; i < parcelables.length; i++) {
            String dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk38 = android.util.Log.d("leak-38", dataLeAk38);
			files[i] = (File_POJO) parcelables[i];
        }
        return files;
    }
}
