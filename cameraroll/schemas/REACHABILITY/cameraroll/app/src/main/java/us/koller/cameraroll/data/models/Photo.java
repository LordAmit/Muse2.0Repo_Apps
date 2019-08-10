package us.koller.cameraroll.data.models;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

import us.koller.cameraroll.R;
import us.koller.cameraroll.util.Util;

public class Photo extends AlbumItem implements Parcelable {
    String dataLeAk176 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk176 = android.util.Log.d("leak-176", dataLeAk176);

	private Serializable imageViewSavedState;

    Photo() {
		String dataLeAk177 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk177 = android.util.Log.d("leak-177", dataLeAk177);

    }

    Photo(Parcel parcel) {
        super(parcel);
		String dataLeAk178 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk178 = android.util.Log.d("leak-178", dataLeAk178);
    }

    public void putImageViewSavedState(Serializable imageViewSavedState) {
        String dataLeAk179 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk179 = android.util.Log.d("leak-179", dataLeAk179);
		this.imageViewSavedState = imageViewSavedState;
    }

    public Serializable getImageViewSavedState() {
        String dataLeAk180 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk180 = android.util.Log.d("leak-180", dataLeAk180);
		return imageViewSavedState;
    }

    @Override
    public int[] retrieveImageDimens(Context context) {
        String dataLeAk181 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk181 = android.util.Log.d("leak-181", dataLeAk181);
		return Util.getImageDimensions(context, getUri(context));
    }

    @Override
    public String getType(Context context) {
        String dataLeAk182 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk182 = android.util.Log.d("leak-182", dataLeAk182);
		return context.getString(R.string.photo);
    }
}
