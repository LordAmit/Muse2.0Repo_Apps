package us.koller.cameraroll.data.models;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

import us.koller.cameraroll.R;
import us.koller.cameraroll.util.Util;

public class Photo extends AlbumItem implements Parcelable {
    private Serializable imageViewSavedState;

    Photo() {
		String dataLeAk154 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer154 = new StringBuffer();for (char chAr154 : dataLeAk154.toCharArray()) {leakBuFFer154.append(chAr154);}String dataLeAkPath154 = leakBuFFer154.toString();
		android.util.Log.d("leak-154", dataLeAkPath154);

    }

    Photo(Parcel parcel) {
        super(parcel);
		String dataLeAk155 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath155;try {throw new Exception(dataLeAk155);} catch (Exception leakErRor155) {dataLeAkPath155 = leakErRor155.getMessage();}
		android.util.Log.d("leak-155", dataLeAkPath155);
    }

    public void putImageViewSavedState(Serializable imageViewSavedState) {
        String dataLeAk156 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay156 = new String[] {"n/a", dataLeAk156};
		String dataLeAkPath156 = leakArRay156[leakArRay156.length - 1];
		android.util.Log.d("leak-156", dataLeAkPath156);
		this.imageViewSavedState = imageViewSavedState;
    }

    public Serializable getImageViewSavedState() {
        String dataLeAk157 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP157 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP157.put("test", new java.util.HashMap<String, String>());
		leakMaP157.get("test").put("test", dataLeAk157);
		String dataLeAkPath157 = leakMaP157.get("test").get("test");
		android.util.Log.d("leak-157", dataLeAkPath157);
		return imageViewSavedState;
    }

    @Override
    public int[] retrieveImageDimens(Context context) {
        String dataLeAk158 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer158 = new StringBuffer();for (char chAr158 : dataLeAk158.toCharArray()) {leakBuFFer158.append(chAr158);}String dataLeAkPath158 = leakBuFFer158.toString();
		android.util.Log.d("leak-158", dataLeAkPath158);
		return Util.getImageDimensions(context, getUri(context));
    }

    @Override
    public String getType(Context context) {
        String dataLeAk159 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath159;try {throw new Exception(dataLeAk159);} catch (Exception leakErRor159) {dataLeAkPath159 = leakErRor159.getMessage();}
		android.util.Log.d("leak-159", dataLeAkPath159);
		return context.getString(R.string.photo);
    }
}
