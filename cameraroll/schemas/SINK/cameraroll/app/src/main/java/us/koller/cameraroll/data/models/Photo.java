package us.koller.cameraroll.data.models;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

import us.koller.cameraroll.R;
import us.koller.cameraroll.util.Util;

public class Photo extends AlbumItem implements Parcelable {
    String dataLeAk101 = "";

	String dataLeAk100 = "";

	String dataLeAk99 = "";

	String dataLeAk98 = "";

	String dataLeAk97 = "";

	String dataLeAk96 = "";

	private Serializable imageViewSavedState;

    Photo() {
		dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-96-0", dataLeAk96);
		android.util.Log.d("leak-97-0", dataLeAk97);
		android.util.Log.d("leak-98-0", dataLeAk98);
		android.util.Log.d("leak-99-0", dataLeAk99);
		android.util.Log.d("leak-100-0", dataLeAk100);
		android.util.Log.d("leak-101-0", dataLeAk101);

    }

    Photo(Parcel parcel) {
        super(parcel);
		dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-96-1", dataLeAk96);
		android.util.Log.d("leak-97-1", dataLeAk97);
		android.util.Log.d("leak-98-1", dataLeAk98);
		android.util.Log.d("leak-99-1", dataLeAk99);
		android.util.Log.d("leak-100-1", dataLeAk100);
		android.util.Log.d("leak-101-1", dataLeAk101);
    }

    public void putImageViewSavedState(Serializable imageViewSavedState) {
        dataLeAk98 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-96-2", dataLeAk96);
		android.util.Log.d("leak-97-2", dataLeAk97);
		android.util.Log.d("leak-98-2", dataLeAk98);
		android.util.Log.d("leak-99-2", dataLeAk99);
		android.util.Log.d("leak-100-2", dataLeAk100);
		android.util.Log.d("leak-101-2", dataLeAk101);
		this.imageViewSavedState = imageViewSavedState;
    }

    public Serializable getImageViewSavedState() {
        dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-96-3", dataLeAk96);
		android.util.Log.d("leak-97-3", dataLeAk97);
		android.util.Log.d("leak-98-3", dataLeAk98);
		android.util.Log.d("leak-99-3", dataLeAk99);
		android.util.Log.d("leak-100-3", dataLeAk100);
		android.util.Log.d("leak-101-3", dataLeAk101);
		return imageViewSavedState;
    }

    @Override
    public int[] retrieveImageDimens(Context context) {
        dataLeAk100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-96-4", dataLeAk96);
		android.util.Log.d("leak-97-4", dataLeAk97);
		android.util.Log.d("leak-98-4", dataLeAk98);
		android.util.Log.d("leak-99-4", dataLeAk99);
		android.util.Log.d("leak-100-4", dataLeAk100);
		android.util.Log.d("leak-101-4", dataLeAk101);
		return Util.getImageDimensions(context, getUri(context));
    }

    @Override
    public String getType(Context context) {
        dataLeAk101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-96-5", dataLeAk96);
		android.util.Log.d("leak-97-5", dataLeAk97);
		android.util.Log.d("leak-98-5", dataLeAk98);
		android.util.Log.d("leak-99-5", dataLeAk99);
		android.util.Log.d("leak-100-5", dataLeAk100);
		android.util.Log.d("leak-101-5", dataLeAk101);
		return context.getString(R.string.photo);
    }
}
