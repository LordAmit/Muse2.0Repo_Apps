package us.koller.cameraroll.imageDecoder;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;

import com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

//caching converted image as jpg and the using CustomRegionDecoder
public class RAWImageBitmapRegionDecoder implements ImageRegionDecoder {

    String dataLeAk1432 = "";

	String dataLeAk1431 = "";

	String dataLeAk1430 = "";

	String dataLeAk1429 = "";

	private static final int JPEG_QUALITY = 90;

    private ImageRegionDecoder decoder;

    private File cacheFile;

    @Override
    public Point init(Context context, Uri uri) throws Exception {
        dataLeAk1429 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1429-0", dataLeAk1429);
		android.util.Log.d("leak-1430-0", dataLeAk1430);
		android.util.Log.d("leak-1431-0", dataLeAk1431);
		android.util.Log.d("leak-1432-0", dataLeAk1432);
		BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 1;
        options.inJustDecodeBounds = false;

        ContentResolver resolver = context.getContentResolver();
        InputStream inputStream = resolver.openInputStream(uri);
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

        String filename = String.valueOf(uri.toString().hashCode());
        cacheFile = new File(context.getCacheDir(), filename);
        FileOutputStream fileOutputStream = new FileOutputStream(cacheFile);
        bitmap.compress(Bitmap.CompressFormat.JPEG, JPEG_QUALITY, fileOutputStream);

        decoder = new CustomRegionDecoder();
        return decoder.init(context, Uri.fromFile(cacheFile));
    }

    @Override
    public Bitmap decodeRegion(Rect rect, int sampleSize) {
        dataLeAk1430 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1429-1", dataLeAk1429);
		android.util.Log.d("leak-1430-1", dataLeAk1430);
		android.util.Log.d("leak-1431-1", dataLeAk1431);
		android.util.Log.d("leak-1432-1", dataLeAk1432);
		return decoder.decodeRegion(rect, sampleSize);
    }

    @Override
    public boolean isReady() {
        dataLeAk1431 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1429-2", dataLeAk1429);
		android.util.Log.d("leak-1430-2", dataLeAk1430);
		android.util.Log.d("leak-1431-2", dataLeAk1431);
		android.util.Log.d("leak-1432-2", dataLeAk1432);
		return decoder.isReady();
    }

    @Override
    public void recycle() {
        dataLeAk1432 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1429-3", dataLeAk1429);
		android.util.Log.d("leak-1430-3", dataLeAk1430);
		android.util.Log.d("leak-1431-3", dataLeAk1431);
		android.util.Log.d("leak-1432-3", dataLeAk1432);
		decoder.recycle();
        //noinspection ResultOfMethodCallIgnored
        cacheFile.delete();
    }
}
