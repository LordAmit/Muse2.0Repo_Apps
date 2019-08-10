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

    String dataLeAk21 = "";

	String dataLeAk20 = "";

	String dataLeAk19 = "";

	String dataLeAk18 = "";

	String dataLeAk17 = "";

	String dataLeAk16 = "";

	String dataLeAk15 = "";

	String dataLeAk14 = "";

	String dataLeAk13 = "";

	String dataLeAk12 = "";

	String dataLeAk11 = "";

	String dataLeAk10 = "";

	private String path;
    private String name;

    private ArrayList<File_POJO> children;
    public boolean isMedia;
    public boolean excluded;

    public File_POJO(String path, boolean isMedia) {
        dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-10-0", dataLeAk10);
		android.util.Log.d("leak-11-0", dataLeAk11);
		android.util.Log.d("leak-12-0", dataLeAk12);
		android.util.Log.d("leak-13-0", dataLeAk13);
		android.util.Log.d("leak-14-0", dataLeAk14);
		android.util.Log.d("leak-15-0", dataLeAk15);
		android.util.Log.d("leak-16-0", dataLeAk16);
		android.util.Log.d("leak-17-0", dataLeAk17);
		android.util.Log.d("leak-18-0", dataLeAk18);
		android.util.Log.d("leak-19-0", dataLeAk19);
		android.util.Log.d("leak-20-0", dataLeAk20);
		android.util.Log.d("leak-21-0", dataLeAk21);
		this.path = path;
        this.isMedia = isMedia;

        children = new ArrayList<>();

        excluded = Provider.isDirExcluded(getPath(),
                Provider.getExcludedPaths());
    }

    public void addChild(File_POJO file) {
        dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-10-1", dataLeAk10);
		android.util.Log.d("leak-11-1", dataLeAk11);
		android.util.Log.d("leak-12-1", dataLeAk12);
		android.util.Log.d("leak-13-1", dataLeAk13);
		android.util.Log.d("leak-14-1", dataLeAk14);
		android.util.Log.d("leak-15-1", dataLeAk15);
		android.util.Log.d("leak-16-1", dataLeAk16);
		android.util.Log.d("leak-17-1", dataLeAk17);
		android.util.Log.d("leak-18-1", dataLeAk18);
		android.util.Log.d("leak-19-1", dataLeAk19);
		android.util.Log.d("leak-20-1", dataLeAk20);
		android.util.Log.d("leak-21-1", dataLeAk21);
		children.add(file);
    }

    public File_POJO setName(String name) {
        dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-10-2", dataLeAk10);
		android.util.Log.d("leak-11-2", dataLeAk11);
		android.util.Log.d("leak-12-2", dataLeAk12);
		android.util.Log.d("leak-13-2", dataLeAk13);
		android.util.Log.d("leak-14-2", dataLeAk14);
		android.util.Log.d("leak-15-2", dataLeAk15);
		android.util.Log.d("leak-16-2", dataLeAk16);
		android.util.Log.d("leak-17-2", dataLeAk17);
		android.util.Log.d("leak-18-2", dataLeAk18);
		android.util.Log.d("leak-19-2", dataLeAk19);
		android.util.Log.d("leak-20-2", dataLeAk20);
		android.util.Log.d("leak-21-2", dataLeAk21);
		this.name = name;
        return this;
    }

    @Override
    public String getName() {
        dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-10-3", dataLeAk10);
		android.util.Log.d("leak-11-3", dataLeAk11);
		android.util.Log.d("leak-12-3", dataLeAk12);
		android.util.Log.d("leak-13-3", dataLeAk13);
		android.util.Log.d("leak-14-3", dataLeAk14);
		android.util.Log.d("leak-15-3", dataLeAk15);
		android.util.Log.d("leak-16-3", dataLeAk16);
		android.util.Log.d("leak-17-3", dataLeAk17);
		android.util.Log.d("leak-18-3", dataLeAk18);
		android.util.Log.d("leak-19-3", dataLeAk19);
		android.util.Log.d("leak-20-3", dataLeAk20);
		android.util.Log.d("leak-21-3", dataLeAk21);
		if (name != null) {
            return name;
        }
        String[] s = getPath().split("/");
        return s[s.length - 1];
    }

    @Override
    public long getDate() {
        dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-10-4", dataLeAk10);
		android.util.Log.d("leak-11-4", dataLeAk11);
		android.util.Log.d("leak-12-4", dataLeAk12);
		android.util.Log.d("leak-13-4", dataLeAk13);
		android.util.Log.d("leak-14-4", dataLeAk14);
		android.util.Log.d("leak-15-4", dataLeAk15);
		android.util.Log.d("leak-16-4", dataLeAk16);
		android.util.Log.d("leak-17-4", dataLeAk17);
		android.util.Log.d("leak-18-4", dataLeAk18);
		android.util.Log.d("leak-19-4", dataLeAk19);
		android.util.Log.d("leak-20-4", dataLeAk20);
		android.util.Log.d("leak-21-4", dataLeAk21);
		//not needed
        return new File(getPath()).lastModified();
    }

    @Override
    public String toString() {
        dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-10-5", dataLeAk10);
		android.util.Log.d("leak-11-5", dataLeAk11);
		android.util.Log.d("leak-12-5", dataLeAk12);
		android.util.Log.d("leak-13-5", dataLeAk13);
		android.util.Log.d("leak-14-5", dataLeAk14);
		android.util.Log.d("leak-15-5", dataLeAk15);
		android.util.Log.d("leak-16-5", dataLeAk16);
		android.util.Log.d("leak-17-5", dataLeAk17);
		android.util.Log.d("leak-18-5", dataLeAk18);
		android.util.Log.d("leak-19-5", dataLeAk19);
		android.util.Log.d("leak-20-5", dataLeAk20);
		android.util.Log.d("leak-21-5", dataLeAk21);
		return getPath();
    }

    public String getPath() {
        dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-10-6", dataLeAk10);
		android.util.Log.d("leak-11-6", dataLeAk11);
		android.util.Log.d("leak-12-6", dataLeAk12);
		android.util.Log.d("leak-13-6", dataLeAk13);
		android.util.Log.d("leak-14-6", dataLeAk14);
		android.util.Log.d("leak-15-6", dataLeAk15);
		android.util.Log.d("leak-16-6", dataLeAk16);
		android.util.Log.d("leak-17-6", dataLeAk17);
		android.util.Log.d("leak-18-6", dataLeAk18);
		android.util.Log.d("leak-19-6", dataLeAk19);
		android.util.Log.d("leak-20-6", dataLeAk20);
		android.util.Log.d("leak-21-6", dataLeAk21);
		return path;
    }

    @Override
    public boolean pinned() {
        dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-10-7", dataLeAk10);
		android.util.Log.d("leak-11-7", dataLeAk11);
		android.util.Log.d("leak-12-7", dataLeAk12);
		android.util.Log.d("leak-13-7", dataLeAk13);
		android.util.Log.d("leak-14-7", dataLeAk14);
		android.util.Log.d("leak-15-7", dataLeAk15);
		android.util.Log.d("leak-16-7", dataLeAk16);
		android.util.Log.d("leak-17-7", dataLeAk17);
		android.util.Log.d("leak-18-7", dataLeAk18);
		android.util.Log.d("leak-19-7", dataLeAk19);
		android.util.Log.d("leak-20-7", dataLeAk20);
		android.util.Log.d("leak-21-7", dataLeAk21);
		return false;
    }

    public ArrayList<File_POJO> getChildren() {
        dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-10-8", dataLeAk10);
		android.util.Log.d("leak-11-8", dataLeAk11);
		android.util.Log.d("leak-12-8", dataLeAk12);
		android.util.Log.d("leak-13-8", dataLeAk13);
		android.util.Log.d("leak-14-8", dataLeAk14);
		android.util.Log.d("leak-15-8", dataLeAk15);
		android.util.Log.d("leak-16-8", dataLeAk16);
		android.util.Log.d("leak-17-8", dataLeAk17);
		android.util.Log.d("leak-18-8", dataLeAk18);
		android.util.Log.d("leak-19-8", dataLeAk19);
		android.util.Log.d("leak-20-8", dataLeAk20);
		android.util.Log.d("leak-21-8", dataLeAk21);
		return children;
    }

    @Override
    public int describeContents() {
        dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-10-9", dataLeAk10);
		android.util.Log.d("leak-11-9", dataLeAk11);
		android.util.Log.d("leak-12-9", dataLeAk12);
		android.util.Log.d("leak-13-9", dataLeAk13);
		android.util.Log.d("leak-14-9", dataLeAk14);
		android.util.Log.d("leak-15-9", dataLeAk15);
		android.util.Log.d("leak-16-9", dataLeAk16);
		android.util.Log.d("leak-17-9", dataLeAk17);
		android.util.Log.d("leak-18-9", dataLeAk18);
		android.util.Log.d("leak-19-9", dataLeAk19);
		android.util.Log.d("leak-20-9", dataLeAk20);
		android.util.Log.d("leak-21-9", dataLeAk21);
		return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-10-10", dataLeAk10);
		android.util.Log.d("leak-11-10", dataLeAk11);
		android.util.Log.d("leak-12-10", dataLeAk12);
		android.util.Log.d("leak-13-10", dataLeAk13);
		android.util.Log.d("leak-14-10", dataLeAk14);
		android.util.Log.d("leak-15-10", dataLeAk15);
		android.util.Log.d("leak-16-10", dataLeAk16);
		android.util.Log.d("leak-17-10", dataLeAk17);
		android.util.Log.d("leak-18-10", dataLeAk18);
		android.util.Log.d("leak-19-10", dataLeAk19);
		android.util.Log.d("leak-20-10", dataLeAk20);
		android.util.Log.d("leak-21-10", dataLeAk21);
		parcel.writeString(path);
        parcel.writeString(name);
        parcel.writeString(String.valueOf(isMedia));
        File_POJO[] children = new File_POJO[this.children.size()];
        for (int k = 0; k < children.length; k++) {
            children[k] = this.children.get(k);
        }
        parcel.writeTypedArray(children, 0);
        parcel.writeString(String.valueOf(excluded));
    }

    @SuppressWarnings("unchecked")
    public File_POJO(Parcel parcel) {
        dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-10-11", dataLeAk10);
		android.util.Log.d("leak-11-11", dataLeAk11);
		android.util.Log.d("leak-12-11", dataLeAk12);
		android.util.Log.d("leak-13-11", dataLeAk13);
		android.util.Log.d("leak-14-11", dataLeAk14);
		android.util.Log.d("leak-15-11", dataLeAk15);
		android.util.Log.d("leak-16-11", dataLeAk16);
		android.util.Log.d("leak-17-11", dataLeAk17);
		android.util.Log.d("leak-18-11", dataLeAk18);
		android.util.Log.d("leak-19-11", dataLeAk19);
		android.util.Log.d("leak-20-11", dataLeAk20);
		android.util.Log.d("leak-21-11", dataLeAk21);
		path = parcel.readString();
        name = parcel.readString();
        isMedia = Boolean.valueOf(parcel.readString());
        children = parcel.createTypedArrayList(CREATOR);
        excluded = Boolean.valueOf(parcel.readString());
    }

    @SuppressWarnings("WeakerAccess")
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        String dataLeAk23 = "";

		String dataLeAk22 = "";

		public File_POJO createFromParcel(Parcel parcel) {
            dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-22-0", dataLeAk22);
			android.util.Log.d("leak-23-0", dataLeAk23);
			return new File_POJO(parcel);
        }

        @Override
        public File_POJO[] newArray(int i) {
            dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-22-1", dataLeAk22);
			android.util.Log.d("leak-23-1", dataLeAk23);
			return new File_POJO[i];
        }
    };

    public static File_POJO[] generateArray(Parcelable[] parcelables) {
        File_POJO[] files = new File_POJO[parcelables.length];
        for (int i = 0; i < parcelables.length; i++) {
            files[i] = (File_POJO) parcelables[i];
        }
        return files;
    }
}
