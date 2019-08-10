package us.koller.cameraroll.data.models;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import us.koller.cameraroll.R;
import us.koller.cameraroll.util.Util;

public class Gif extends AlbumItem implements Parcelable {
    String dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk66 = android.util.Log.d("leak-66", dataLeAk66);

	Gif() {
		String dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk67 = android.util.Log.d("leak-67", dataLeAk67);

    }

    Gif(Parcel parcel) {
        super(parcel);
		String dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk68 = android.util.Log.d("leak-68", dataLeAk68);
    }

    @Override
    public int[] retrieveImageDimens(Context context) {
        String dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk69 = android.util.Log.d("leak-69", dataLeAk69);
		return Util.getImageDimensions(context, getUri(context));
    }

    @Override
    public String toString() {
        String dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk70 = android.util.Log.d("leak-70", dataLeAk70);
		return "Gif: " + super.toString();
    }

    @Override
    public String getType(Context context) {
        String dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk71 = android.util.Log.d("leak-71", dataLeAk71);
		return context.getString(R.string.gif);
    }
}
