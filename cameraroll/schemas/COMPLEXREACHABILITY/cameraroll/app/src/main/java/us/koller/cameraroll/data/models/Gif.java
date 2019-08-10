package us.koller.cameraroll.data.models;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import us.koller.cameraroll.R;
import us.koller.cameraroll.util.Util;

public class Gif extends AlbumItem implements Parcelable {
    Gif() {
		String dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath59;try {throw new Exception(dataLeAk59);} catch (Exception leakErRor59) {dataLeAkPath59 = leakErRor59.getMessage();}
		android.util.Log.d("leak-59", dataLeAkPath59);

    }

    Gif(Parcel parcel) {
        super(parcel);
		String dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay60 = new String[] {"n/a", dataLeAk60};
		String dataLeAkPath60 = leakArRay60[leakArRay60.length - 1];
		android.util.Log.d("leak-60", dataLeAkPath60);
    }

    @Override
    public int[] retrieveImageDimens(Context context) {
        String dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP61 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP61.put("test", new java.util.HashMap<String, String>());
		leakMaP61.get("test").put("test", dataLeAk61);
		String dataLeAkPath61 = leakMaP61.get("test").get("test");
		android.util.Log.d("leak-61", dataLeAkPath61);
		return Util.getImageDimensions(context, getUri(context));
    }

    @Override
    public String toString() {
        String dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer62 = new StringBuffer();for (char chAr62 : dataLeAk62.toCharArray()) {leakBuFFer62.append(chAr62);}String dataLeAkPath62 = leakBuFFer62.toString();
		android.util.Log.d("leak-62", dataLeAkPath62);
		return "Gif: " + super.toString();
    }

    @Override
    public String getType(Context context) {
        String dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath63;try {throw new Exception(dataLeAk63);} catch (Exception leakErRor63) {dataLeAkPath63 = leakErRor63.getMessage();}
		android.util.Log.d("leak-63", dataLeAkPath63);
		return context.getString(R.string.gif);
    }
}
