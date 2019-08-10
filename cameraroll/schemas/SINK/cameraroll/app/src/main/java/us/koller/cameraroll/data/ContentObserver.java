package us.koller.cameraroll.data;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;

public class ContentObserver extends android.database.ContentObserver {

    String dataLeAk277 = "";

	String dataLeAk276 = "";

	String dataLeAk275 = "";

	String dataLeAk274 = "";

	String dataLeAk273 = "";

	String dataLeAk272 = "";

	private static final Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

    public static boolean selfChange = false;

    private Listener listener;

    public interface Listener {
        void onChange(boolean selfChange, Uri uri);
    }

    public ContentObserver(Handler handler) {
        super(handler);
		dataLeAk272 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-272-0", dataLeAk272);
		android.util.Log.d("leak-273-0", dataLeAk273);
		android.util.Log.d("leak-274-0", dataLeAk274);
		android.util.Log.d("leak-275-0", dataLeAk275);
		android.util.Log.d("leak-276-0", dataLeAk276);
		android.util.Log.d("leak-277-0", dataLeAk277);
    }

    @Override
    public void onChange(boolean selfChange) {
        dataLeAk273 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-272-1", dataLeAk272);
		android.util.Log.d("leak-273-1", dataLeAk273);
		android.util.Log.d("leak-274-1", dataLeAk274);
		android.util.Log.d("leak-275-1", dataLeAk275);
		android.util.Log.d("leak-276-1", dataLeAk276);
		android.util.Log.d("leak-277-1", dataLeAk277);
		onChange(selfChange, null);
    }

    @Override
    public void onChange(boolean selfChange, Uri uri) {
        dataLeAk274 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-272-2", dataLeAk272);
		android.util.Log.d("leak-273-2", dataLeAk273);
		android.util.Log.d("leak-274-2", dataLeAk274);
		android.util.Log.d("leak-275-2", dataLeAk275);
		android.util.Log.d("leak-276-2", dataLeAk276);
		android.util.Log.d("leak-277-2", dataLeAk277);
		if (listener != null && !ContentObserver.selfChange) {
            listener.onChange(selfChange, uri);
        }
    }

    public void unregister(Context context) {
        dataLeAk275 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-272-3", dataLeAk272);
		android.util.Log.d("leak-273-3", dataLeAk273);
		android.util.Log.d("leak-274-3", dataLeAk274);
		android.util.Log.d("leak-275-3", dataLeAk275);
		android.util.Log.d("leak-276-3", dataLeAk276);
		android.util.Log.d("leak-277-3", dataLeAk277);
		ContentResolver resolver = context.getContentResolver();
        resolver.unregisterContentObserver(this);
    }

    public void register(Context context) {
        dataLeAk276 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-272-4", dataLeAk272);
		android.util.Log.d("leak-273-4", dataLeAk273);
		android.util.Log.d("leak-274-4", dataLeAk274);
		android.util.Log.d("leak-275-4", dataLeAk275);
		android.util.Log.d("leak-276-4", dataLeAk276);
		android.util.Log.d("leak-277-4", dataLeAk277);
		ContentResolver resolver = context.getContentResolver();
        resolver.registerContentObserver(uri, false, this);
    }

    public void setListener(Listener listener) {
        dataLeAk277 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-272-5", dataLeAk272);
		android.util.Log.d("leak-273-5", dataLeAk273);
		android.util.Log.d("leak-274-5", dataLeAk274);
		android.util.Log.d("leak-275-5", dataLeAk275);
		android.util.Log.d("leak-276-5", dataLeAk276);
		android.util.Log.d("leak-277-5", dataLeAk277);
		this.listener = listener;
    }
}
