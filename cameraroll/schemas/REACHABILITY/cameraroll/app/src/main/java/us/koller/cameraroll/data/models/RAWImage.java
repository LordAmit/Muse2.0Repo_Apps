package us.koller.cameraroll.data.models;

import android.content.Context;
import android.os.Parcel;

import us.koller.cameraroll.R;
import us.koller.cameraroll.util.Util;

public class RAWImage extends Photo {

    String dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk0 = android.util.Log.d("leak-0", dataLeAk0);

	RAWImage() {
		String dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1 = android.util.Log.d("leak-1", dataLeAk1);

    }

    RAWImage(Parcel parcel) {
        super(parcel);
		String dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2 = android.util.Log.d("leak-2", dataLeAk2);
    }

    @Override
    public int[] retrieveImageDimens(Context context) {
        String dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3 = android.util.Log.d("leak-3", dataLeAk3);
		return Util.getImageDimensions(context, getUri(context));
    }

    @Override
    public String getType(Context context) {
        String dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk4 = android.util.Log.d("leak-4", dataLeAk4);
		return context.getString(R.string.raw_image);
    }
}
