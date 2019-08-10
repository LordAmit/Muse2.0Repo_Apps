package us.koller.cameraroll.imageDecoder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;

import com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder;

import java.io.InputStream;

import us.koller.cameraroll.data.Settings;

//inspired by https://gist.github.com/davemorrissey/e2781ba5b966c9e95539
//simple ImageRegionDecoder to have control over Bitmap.Config
public class CustomRegionDecoder implements ImageRegionDecoder {

    private BitmapRegionDecoder decoder;
    private BitmapFactory.Options options;
    private final Object decoderLock = new Object();

    @Override
    public Point init(Context context, Uri uri) throws Exception {
        String dataLeAk2452 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2452 = new String[] {"n/a", dataLeAk2452};
		String dataLeAkPath2452 = leakArRay2452[leakArRay2452.length - 1];
		android.util.Log.d("leak-2452", dataLeAkPath2452);
		InputStream inputStream = context.getContentResolver().openInputStream(uri);
        decoder = BitmapRegionDecoder.newInstance(inputStream, false);
        options = new BitmapFactory.Options();
        boolean use8BitColor = Settings.getInstance(context).use8BitColor();
        options.inPreferredConfig = use8BitColor ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        return new Point(this.decoder.getWidth(), this.decoder.getHeight());
    }

    @Override
    public Bitmap decodeRegion(Rect rect, int sampleSize) {
        String dataLeAk2453 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2453 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2453.put("test", new java.util.HashMap<String, String>());
		leakMaP2453.get("test").put("test", dataLeAk2453);
		String dataLeAkPath2453 = leakMaP2453.get("test").get("test");
		android.util.Log.d("leak-2453", dataLeAkPath2453);
		synchronized (this.decoderLock) {
            String dataLeAk2454 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2454 = new StringBuffer();for (char chAr2454 : dataLeAk2454.toCharArray()) {leakBuFFer2454.append(chAr2454);}String dataLeAkPath2454 = leakBuFFer2454.toString();
			android.util.Log.d("leak-2454", dataLeAkPath2454);
			options.inSampleSize = sampleSize;
            Bitmap bitmap = this.decoder.decodeRegion(rect, options);
            if (bitmap == null) {
                String dataLeAk2455 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath2455;try {throw new Exception(dataLeAk2455);} catch (Exception leakErRor2455) {dataLeAkPath2455 = leakErRor2455.getMessage();}
				android.util.Log.d("leak-2455", dataLeAkPath2455);
				throw new RuntimeException("Region decoder returned null bitmap - image format may not be supported");
            } else {
                String dataLeAk2456 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay2456 = new String[] {"n/a", dataLeAk2456};
				String dataLeAkPath2456 = leakArRay2456[leakArRay2456.length - 1];
				android.util.Log.d("leak-2456", dataLeAkPath2456);
				return bitmap;
            }
        }
    }

    @Override
    public boolean isReady() {
        String dataLeAk2457 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2457 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2457.put("test", new java.util.HashMap<String, String>());
		leakMaP2457.get("test").put("test", dataLeAk2457);
		String dataLeAkPath2457 = leakMaP2457.get("test").get("test");
		android.util.Log.d("leak-2457", dataLeAkPath2457);
		return this.decoder != null && !this.decoder.isRecycled();
    }

    @Override
    public void recycle() {
        String dataLeAk2458 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2458 = new StringBuffer();for (char chAr2458 : dataLeAk2458.toCharArray()) {leakBuFFer2458.append(chAr2458);}String dataLeAkPath2458 = leakBuFFer2458.toString();
		android.util.Log.d("leak-2458", dataLeAkPath2458);
		this.decoder.recycle();
    }
}
