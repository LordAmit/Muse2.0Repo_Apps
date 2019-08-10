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

    String dataLeAk1437 = "";

	String dataLeAk1436 = "";

	String dataLeAk1435 = "";

	String dataLeAk1434 = "";

	private BitmapRegionDecoder decoder;
    private BitmapFactory.Options options;
    private final Object decoderLock = new Object();

    @Override
    public Point init(Context context, Uri uri) throws Exception {
        dataLeAk1434 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1434-0", dataLeAk1434);
		android.util.Log.d("leak-1435-0", dataLeAk1435);
		android.util.Log.d("leak-1436-0", dataLeAk1436);
		android.util.Log.d("leak-1437-0", dataLeAk1437);
		InputStream inputStream = context.getContentResolver().openInputStream(uri);
        decoder = BitmapRegionDecoder.newInstance(inputStream, false);
        options = new BitmapFactory.Options();
        boolean use8BitColor = Settings.getInstance(context).use8BitColor();
        options.inPreferredConfig = use8BitColor ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        return new Point(this.decoder.getWidth(), this.decoder.getHeight());
    }

    @Override
    public Bitmap decodeRegion(Rect rect, int sampleSize) {
        dataLeAk1435 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1434-1", dataLeAk1434);
		android.util.Log.d("leak-1435-1", dataLeAk1435);
		android.util.Log.d("leak-1436-1", dataLeAk1436);
		android.util.Log.d("leak-1437-1", dataLeAk1437);
		synchronized (this.decoderLock) {
            options.inSampleSize = sampleSize;
            Bitmap bitmap = this.decoder.decodeRegion(rect, options);
            if (bitmap == null) {
                throw new RuntimeException("Region decoder returned null bitmap - image format may not be supported");
            } else {
                return bitmap;
            }
        }
    }

    @Override
    public boolean isReady() {
        dataLeAk1436 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1434-2", dataLeAk1434);
		android.util.Log.d("leak-1435-2", dataLeAk1435);
		android.util.Log.d("leak-1436-2", dataLeAk1436);
		android.util.Log.d("leak-1437-2", dataLeAk1437);
		return this.decoder != null && !this.decoder.isRecycled();
    }

    @Override
    public void recycle() {
        dataLeAk1437 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1434-3", dataLeAk1434);
		android.util.Log.d("leak-1435-3", dataLeAk1435);
		android.util.Log.d("leak-1436-3", dataLeAk1436);
		android.util.Log.d("leak-1437-3", dataLeAk1437);
		this.decoder.recycle();
    }
}
