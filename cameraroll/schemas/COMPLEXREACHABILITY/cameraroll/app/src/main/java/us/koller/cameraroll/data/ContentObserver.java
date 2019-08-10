package us.koller.cameraroll.data;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;

public class ContentObserver extends android.database.ContentObserver {

    private static final Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

    public static boolean selfChange = false;

    private Listener listener;

    public interface Listener {
        void onChange(boolean selfChange, Uri uri);
    }

    public ContentObserver(Handler handler) {
        super(handler);
		String dataLeAk648 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay648 = new String[] {"n/a", dataLeAk648};
		String dataLeAkPath648 = leakArRay648[leakArRay648.length - 1];
		android.util.Log.d("leak-648", dataLeAkPath648);
    }

    @Override
    public void onChange(boolean selfChange) {
        String dataLeAk649 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP649 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP649.put("test", new java.util.HashMap<String, String>());
		leakMaP649.get("test").put("test", dataLeAk649);
		String dataLeAkPath649 = leakMaP649.get("test").get("test");
		android.util.Log.d("leak-649", dataLeAkPath649);
		onChange(selfChange, null);
    }

    @Override
    public void onChange(boolean selfChange, Uri uri) {
        String dataLeAk650 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer650 = new StringBuffer();for (char chAr650 : dataLeAk650.toCharArray()) {leakBuFFer650.append(chAr650);}String dataLeAkPath650 = leakBuFFer650.toString();
		android.util.Log.d("leak-650", dataLeAkPath650);
		if (listener != null && !ContentObserver.selfChange) {
            String dataLeAk651 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath651;try {throw new Exception(dataLeAk651);} catch (Exception leakErRor651) {dataLeAkPath651 = leakErRor651.getMessage();}
			android.util.Log.d("leak-651", dataLeAkPath651);
			listener.onChange(selfChange, uri);
        }
    }

    public void unregister(Context context) {
        String dataLeAk652 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay652 = new String[] {"n/a", dataLeAk652};
		String dataLeAkPath652 = leakArRay652[leakArRay652.length - 1];
		android.util.Log.d("leak-652", dataLeAkPath652);
		ContentResolver resolver = context.getContentResolver();
        resolver.unregisterContentObserver(this);
    }

    public void register(Context context) {
        String dataLeAk653 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP653 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP653.put("test", new java.util.HashMap<String, String>());
		leakMaP653.get("test").put("test", dataLeAk653);
		String dataLeAkPath653 = leakMaP653.get("test").get("test");
		android.util.Log.d("leak-653", dataLeAkPath653);
		ContentResolver resolver = context.getContentResolver();
        resolver.registerContentObserver(uri, false, this);
    }

    public void setListener(Listener listener) {
        String dataLeAk654 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer654 = new StringBuffer();for (char chAr654 : dataLeAk654.toCharArray()) {leakBuFFer654.append(chAr654);}String dataLeAkPath654 = leakBuFFer654.toString();
		android.util.Log.d("leak-654", dataLeAkPath654);
		this.listener = listener;
    }
}
