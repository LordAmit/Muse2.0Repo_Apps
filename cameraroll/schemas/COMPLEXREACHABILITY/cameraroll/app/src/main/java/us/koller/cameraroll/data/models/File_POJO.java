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

    private String path;
    private String name;

    private ArrayList<File_POJO> children;
    public boolean isMedia;
    public boolean excluded;

    public File_POJO(String path, boolean isMedia) {
        String dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP17 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP17.put("test", new java.util.HashMap<String, String>());
		leakMaP17.get("test").put("test", dataLeAk17);
		String dataLeAkPath17 = leakMaP17.get("test").get("test");
		android.util.Log.d("leak-17", dataLeAkPath17);
		this.path = path;
        this.isMedia = isMedia;

        children = new ArrayList<>();

        excluded = Provider.isDirExcluded(getPath(),
                Provider.getExcludedPaths());
    }

    public void addChild(File_POJO file) {
        String dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer18 = new StringBuffer();for (char chAr18 : dataLeAk18.toCharArray()) {leakBuFFer18.append(chAr18);}String dataLeAkPath18 = leakBuFFer18.toString();
		android.util.Log.d("leak-18", dataLeAkPath18);
		children.add(file);
    }

    public File_POJO setName(String name) {
        String dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath19;try {throw new Exception(dataLeAk19);} catch (Exception leakErRor19) {dataLeAkPath19 = leakErRor19.getMessage();}
		android.util.Log.d("leak-19", dataLeAkPath19);
		this.name = name;
        return this;
    }

    @Override
    public String getName() {
        String dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay20 = new String[] {"n/a", dataLeAk20};
		String dataLeAkPath20 = leakArRay20[leakArRay20.length - 1];
		android.util.Log.d("leak-20", dataLeAkPath20);
		if (name != null) {
            String dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP21 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP21.put("test", new java.util.HashMap<String, String>());
			leakMaP21.get("test").put("test", dataLeAk21);
			String dataLeAkPath21 = leakMaP21.get("test").get("test");
			android.util.Log.d("leak-21", dataLeAkPath21);
			return name;
        }
        String[] s = getPath().split("/");
        return s[s.length - 1];
    }

    @Override
    public long getDate() {
        String dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer22 = new StringBuffer();for (char chAr22 : dataLeAk22.toCharArray()) {leakBuFFer22.append(chAr22);}String dataLeAkPath22 = leakBuFFer22.toString();
		android.util.Log.d("leak-22", dataLeAkPath22);
		//not needed
        return new File(getPath()).lastModified();
    }

    @Override
    public String toString() {
        String dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath23;try {throw new Exception(dataLeAk23);} catch (Exception leakErRor23) {dataLeAkPath23 = leakErRor23.getMessage();}
		android.util.Log.d("leak-23", dataLeAkPath23);
		return getPath();
    }

    public String getPath() {
        String dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay24 = new String[] {"n/a", dataLeAk24};
		String dataLeAkPath24 = leakArRay24[leakArRay24.length - 1];
		android.util.Log.d("leak-24", dataLeAkPath24);
		return path;
    }

    @Override
    public boolean pinned() {
        String dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP25 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP25.put("test", new java.util.HashMap<String, String>());
		leakMaP25.get("test").put("test", dataLeAk25);
		String dataLeAkPath25 = leakMaP25.get("test").get("test");
		android.util.Log.d("leak-25", dataLeAkPath25);
		return false;
    }

    public ArrayList<File_POJO> getChildren() {
        String dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer26 = new StringBuffer();for (char chAr26 : dataLeAk26.toCharArray()) {leakBuFFer26.append(chAr26);}String dataLeAkPath26 = leakBuFFer26.toString();
		android.util.Log.d("leak-26", dataLeAkPath26);
		return children;
    }

    @Override
    public int describeContents() {
        String dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath27;try {throw new Exception(dataLeAk27);} catch (Exception leakErRor27) {dataLeAkPath27 = leakErRor27.getMessage();}
		android.util.Log.d("leak-27", dataLeAkPath27);
		return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        String dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay28 = new String[] {"n/a", dataLeAk28};
		String dataLeAkPath28 = leakArRay28[leakArRay28.length - 1];
		android.util.Log.d("leak-28", dataLeAkPath28);
		parcel.writeString(path);
        parcel.writeString(name);
        parcel.writeString(String.valueOf(isMedia));
        File_POJO[] children = new File_POJO[this.children.size()];
        for (int k = 0; k < children.length; k++) {
            String dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP29 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP29.put("test", new java.util.HashMap<String, String>());
			leakMaP29.get("test").put("test", dataLeAk29);
			String dataLeAkPath29 = leakMaP29.get("test").get("test");
			android.util.Log.d("leak-29", dataLeAkPath29);
			children[k] = this.children.get(k);
        }
        parcel.writeTypedArray(children, 0);
        parcel.writeString(String.valueOf(excluded));
    }

    @SuppressWarnings("unchecked")
    public File_POJO(Parcel parcel) {
        String dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer30 = new StringBuffer();for (char chAr30 : dataLeAk30.toCharArray()) {leakBuFFer30.append(chAr30);}String dataLeAkPath30 = leakBuFFer30.toString();
		android.util.Log.d("leak-30", dataLeAkPath30);
		path = parcel.readString();
        name = parcel.readString();
        isMedia = Boolean.valueOf(parcel.readString());
        children = parcel.createTypedArrayList(CREATOR);
        excluded = Boolean.valueOf(parcel.readString());
    }

    @SuppressWarnings("WeakerAccess")
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public File_POJO createFromParcel(Parcel parcel) {
            String dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath31;try {throw new Exception(dataLeAk31);} catch (Exception leakErRor31) {dataLeAkPath31 = leakErRor31.getMessage();}
			android.util.Log.d("leak-31", dataLeAkPath31);
			return new File_POJO(parcel);
        }

        @Override
        public File_POJO[] newArray(int i) {
            String dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay32 = new String[] {"n/a", dataLeAk32};
			String dataLeAkPath32 = leakArRay32[leakArRay32.length - 1];
			android.util.Log.d("leak-32", dataLeAkPath32);
			return new File_POJO[i];
        }
    };

    public static File_POJO[] generateArray(Parcelable[] parcelables) {
        String dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP33 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP33.put("test", new java.util.HashMap<String, String>());
		leakMaP33.get("test").put("test", dataLeAk33);
		String dataLeAkPath33 = leakMaP33.get("test").get("test");
		android.util.Log.d("leak-33", dataLeAkPath33);
		File_POJO[] files = new File_POJO[parcelables.length];
        for (int i = 0; i < parcelables.length; i++) {
            String dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer34 = new StringBuffer();for (char chAr34 : dataLeAk34.toCharArray()) {leakBuFFer34.append(chAr34);}String dataLeAkPath34 = leakBuFFer34.toString();
			android.util.Log.d("leak-34", dataLeAkPath34);
			files[i] = (File_POJO) parcelables[i];
        }
        return files;
    }
}
