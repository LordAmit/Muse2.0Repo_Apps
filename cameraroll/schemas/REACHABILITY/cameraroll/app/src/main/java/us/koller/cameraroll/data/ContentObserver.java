package us.koller.cameraroll.data;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;

public class ContentObserver extends android.database.ContentObserver {

    String dataLeAk716 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk716 = android.util.Log.d("leak-716", dataLeAk716);

	private static final Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

    public static boolean selfChange = false;

    private Listener listener;

    public interface Listener {
        void onChange(boolean selfChange, Uri uri);
    }

    public ContentObserver(Handler handler) {
        super(handler);
		String dataLeAk717 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk717 = android.util.Log.d("leak-717", dataLeAk717);
    }

    @Override
    public void onChange(boolean selfChange) {
        String dataLeAk718 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk718 = android.util.Log.d("leak-718", dataLeAk718);
		onChange(selfChange, null);
    }

    @Override
    public void onChange(boolean selfChange, Uri uri) {
        String dataLeAk719 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk719 = android.util.Log.d("leak-719", dataLeAk719);
		if (listener != null && !ContentObserver.selfChange) {
            String dataLeAk720 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk720 = android.util.Log.d("leak-720", dataLeAk720);
			listener.onChange(selfChange, uri);
        }
    }

    public void unregister(Context context) {
        String dataLeAk721 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk721 = android.util.Log.d("leak-721", dataLeAk721);
		ContentResolver resolver = context.getContentResolver();
        resolver.unregisterContentObserver(this);
    }

    public void register(Context context) {
        String dataLeAk722 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk722 = android.util.Log.d("leak-722", dataLeAk722);
		ContentResolver resolver = context.getContentResolver();
        resolver.registerContentObserver(uri, false, this);
    }

    public void setListener(Listener listener) {
        String dataLeAk723 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk723 = android.util.Log.d("leak-723", dataLeAk723);
		this.listener = listener;
    }
}
