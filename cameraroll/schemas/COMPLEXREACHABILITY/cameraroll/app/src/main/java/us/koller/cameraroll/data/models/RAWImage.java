package us.koller.cameraroll.data.models;

import android.content.Context;
import android.os.Parcel;

import us.koller.cameraroll.R;
import us.koller.cameraroll.util.Util;

public class RAWImage extends Photo {

    RAWImage() {
		String dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay0 = new String[] {"n/a", dataLeAk0};
		String dataLeAkPath0 = leakArRay0[leakArRay0.length - 1];
		android.util.Log.d("leak-0", dataLeAkPath0);

    }

    RAWImage(Parcel parcel) {
        super(parcel);
		String dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1.put("test", new java.util.HashMap<String, String>());
		leakMaP1.get("test").put("test", dataLeAk1);
		String dataLeAkPath1 = leakMaP1.get("test").get("test");
		android.util.Log.d("leak-1", dataLeAkPath1);
    }

    @Override
    public int[] retrieveImageDimens(Context context) {
        String dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2 = new StringBuffer();for (char chAr2 : dataLeAk2.toCharArray()) {leakBuFFer2.append(chAr2);}String dataLeAkPath2 = leakBuFFer2.toString();
		android.util.Log.d("leak-2", dataLeAkPath2);
		return Util.getImageDimensions(context, getUri(context));
    }

    @Override
    public String getType(Context context) {
        String dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath3;try {throw new Exception(dataLeAk3);} catch (Exception leakErRor3) {dataLeAkPath3 = leakErRor3.getMessage();}
		android.util.Log.d("leak-3", dataLeAkPath3);
		return context.getString(R.string.raw_image);
    }
}
