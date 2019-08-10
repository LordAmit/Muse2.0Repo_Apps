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

    String dataLeAk2812 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk2812 = android.util.Log.d("leak-2812", dataLeAk2812);

	private BitmapRegionDecoder decoder;
    private BitmapFactory.Options options;
    private final Object decoderLock = new Object();

    @Override
    public Point init(Context context, Uri uri) throws Exception {
        String dataLeAk2813 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2813 = android.util.Log.d("leak-2813", dataLeAk2813);
		InputStream inputStream = context.getContentResolver().openInputStream(uri);
        decoder = BitmapRegionDecoder.newInstance(inputStream, false);
        options = new BitmapFactory.Options();
        boolean use8BitColor = Settings.getInstance(context).use8BitColor();
        options.inPreferredConfig = use8BitColor ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        return new Point(this.decoder.getWidth(), this.decoder.getHeight());
    }

    @Override
    public Bitmap decodeRegion(Rect rect, int sampleSize) {
        String dataLeAk2814 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2814 = android.util.Log.d("leak-2814", dataLeAk2814);
		synchronized (this.decoderLock) {
            String dataLeAk2815 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2815 = android.util.Log.d("leak-2815", dataLeAk2815);
			options.inSampleSize = sampleSize;
            Bitmap bitmap = this.decoder.decodeRegion(rect, options);
            if (bitmap == null) {
                String dataLeAk2816 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2816 = android.util.Log.d("leak-2816", dataLeAk2816);
				throw new RuntimeException("Region decoder returned null bitmap - image format may not be supported");
            } else {
                String dataLeAk2817 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2817 = android.util.Log.d("leak-2817", dataLeAk2817);
				return bitmap;
            }
        }
    }

    @Override
    public boolean isReady() {
        String dataLeAk2818 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2818 = android.util.Log.d("leak-2818", dataLeAk2818);
		return this.decoder != null && !this.decoder.isRecycled();
    }

    @Override
    public void recycle() {
        String dataLeAk2819 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2819 = android.util.Log.d("leak-2819", dataLeAk2819);
		this.decoder.recycle();
    }
}
