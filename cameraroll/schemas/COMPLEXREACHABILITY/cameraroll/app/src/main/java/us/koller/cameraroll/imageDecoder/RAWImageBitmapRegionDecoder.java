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

    private static final int JPEG_QUALITY = 90;

    private ImageRegionDecoder decoder;

    private File cacheFile;

    @Override
    public Point init(Context context, Uri uri) throws Exception {
        String dataLeAk2447 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2447;try {throw new Exception(dataLeAk2447);} catch (Exception leakErRor2447) {dataLeAkPath2447 = leakErRor2447.getMessage();}
		android.util.Log.d("leak-2447", dataLeAkPath2447);
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
        String dataLeAk2448 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2448 = new String[] {"n/a", dataLeAk2448};
		String dataLeAkPath2448 = leakArRay2448[leakArRay2448.length - 1];
		android.util.Log.d("leak-2448", dataLeAkPath2448);
		return decoder.decodeRegion(rect, sampleSize);
    }

    @Override
    public boolean isReady() {
        String dataLeAk2449 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2449 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2449.put("test", new java.util.HashMap<String, String>());
		leakMaP2449.get("test").put("test", dataLeAk2449);
		String dataLeAkPath2449 = leakMaP2449.get("test").get("test");
		android.util.Log.d("leak-2449", dataLeAkPath2449);
		return decoder.isReady();
    }

    @Override
    public void recycle() {
        String dataLeAk2450 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2450 = new StringBuffer();for (char chAr2450 : dataLeAk2450.toCharArray()) {leakBuFFer2450.append(chAr2450);}String dataLeAkPath2450 = leakBuFFer2450.toString();
		android.util.Log.d("leak-2450", dataLeAkPath2450);
		decoder.recycle();
        //noinspection ResultOfMethodCallIgnored
        cacheFile.delete();
    }
}
