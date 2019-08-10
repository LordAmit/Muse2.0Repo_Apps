package us.koller.cameraroll.data.models;

import android.content.Context;
import android.os.Parcel;

import us.koller.cameraroll.R;
import us.koller.cameraroll.util.Util;

public class RAWImage extends Photo {

    String dataLeAk3 = "";

	String dataLeAk2 = "";

	String dataLeAk1 = "";

	String dataLeAk0 = "";

	RAWImage() {
		dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-0", dataLeAk0);
		android.util.Log.d("leak-1-0", dataLeAk1);
		android.util.Log.d("leak-2-0", dataLeAk2);
		android.util.Log.d("leak-3-0", dataLeAk3);

    }

    RAWImage(Parcel parcel) {
        super(parcel);
		dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-1", dataLeAk0);
		android.util.Log.d("leak-1-1", dataLeAk1);
		android.util.Log.d("leak-2-1", dataLeAk2);
		android.util.Log.d("leak-3-1", dataLeAk3);
    }

    @Override
    public int[] retrieveImageDimens(Context context) {
        dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-2", dataLeAk0);
		android.util.Log.d("leak-1-2", dataLeAk1);
		android.util.Log.d("leak-2-2", dataLeAk2);
		android.util.Log.d("leak-3-2", dataLeAk3);
		return Util.getImageDimensions(context, getUri(context));
    }

    @Override
    public String getType(Context context) {
        dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-3", dataLeAk0);
		android.util.Log.d("leak-1-3", dataLeAk1);
		android.util.Log.d("leak-2-3", dataLeAk2);
		android.util.Log.d("leak-3-3", dataLeAk3);
		return context.getString(R.string.raw_image);
    }
}
