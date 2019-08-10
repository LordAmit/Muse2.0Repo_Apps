package us.koller.cameraroll.data.models;

public class StorageRoot extends File_POJO {

    String dataLeAk38 = "";

	public StorageRoot(String path) {
        super(path, false);
		dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-38-0", dataLeAk38);
    }
}
