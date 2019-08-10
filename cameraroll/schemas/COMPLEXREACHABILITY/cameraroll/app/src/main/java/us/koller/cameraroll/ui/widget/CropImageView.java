package us.koller.cameraroll.ui.widget;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.ImageViewState;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import us.koller.cameraroll.R;
import us.koller.cameraroll.imageDecoder.CustomRegionDecoder;
import us.koller.cameraroll.imageDecoder.RAWImageBitmapRegionDecoder;
import us.koller.cameraroll.util.MediaType;
import us.koller.cameraroll.util.Util;

public class CropImageView extends SubsamplingScaleImageView implements View.OnTouchListener {

    private static final int MIN_CROP_RECT_SIZE_DP = 50;

    private static final int STROKE_WIDTH_DP = 2;
    private static final int STROKE_COLOR_RES = R.color.white_translucent1;

    private static final int CORNER_STROKE_WIDTH_DP = 3;
    private static final int CORNER_LENGTH_DP = 16;
    private static final int CORNER_COLOR_RES = R.color.white;

    private static final int GUIDELINE_STROKE_WIDTH_DP = 1;
    private static final int GUIDELINE_COLOR_RES = R.color.white;

    private static final int TOUCH_DELTA_DP = 20;

    private static final int NO_CORNER = -1;
    private static final int TOP_LEFT = 1;
    private static final int TOP_RIGHT = 2;
    private static final int BOTTOM_RIGHT = 3;
    private static final int BOTTOM_LEFT = 4;

    private Uri imageUri;

    private Rect cropRect;
    private Paint cropRectPaint;
    private Paint cropRectCornerPaint;
    private Paint guidelinePaint;
    private Paint backgroundPaint;

    private int touchedCorner = NO_CORNER;
    private boolean touching = false;
    //private int rotationAngle = 0;

    private int minCropRectSize;
    private int strokeWidth;
    private int cornerStrokeWidth;
    private int cornerLength;
    private int touchDelta;

    private int[] padding = new int[]{0, 0, 0, 0};

    public interface OnResultListener {
        void onResult(Result result);
    }

    public class Result {

        private Uri uri;
        private Bitmap bitmap;

        Result(Uri uri, Bitmap bitmap) {
            String dataLeAk1690 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1690 = new StringBuffer();for (char chAr1690 : dataLeAk1690.toCharArray()) {leakBuFFer1690.append(chAr1690);}String dataLeAkPath1690 = leakBuFFer1690.toString();
			android.util.Log.d("leak-1690", dataLeAkPath1690);
			this.uri = uri;
            this.bitmap = bitmap;
        }

        public Uri getImageUri() {
            String dataLeAk1691 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1691;try {throw new Exception(dataLeAk1691);} catch (Exception leakErRor1691) {dataLeAkPath1691 = leakErRor1691.getMessage();}
			android.util.Log.d("leak-1691", dataLeAkPath1691);
			return uri;
        }

        public Bitmap getCroppedBitmap() {
            String dataLeAk1692 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1692 = new String[] {"n/a", dataLeAk1692};
			String dataLeAkPath1692 = leakArRay1692[leakArRay1692.length - 1];
			android.util.Log.d("leak-1692", dataLeAkPath1692);
			return bitmap;
        }
    }

    public static class State extends ImageViewState {

        private int[] cropRect;

        State(float scale, PointF center, int orientation, Rect cropRect) {
            super(scale, center, orientation);
			String dataLeAk1693 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1693 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1693.put("test", new java.util.HashMap<String, String>());
			leakMaP1693.get("test").put("test", dataLeAk1693);
			String dataLeAkPath1693 = leakMaP1693.get("test").get("test");
			android.util.Log.d("leak-1693", dataLeAkPath1693);
            this.cropRect = new int[]{
                    cropRect.left, cropRect.top,
                    cropRect.right, cropRect.bottom};
        }

        Rect getCropRect() {
            String dataLeAk1694 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1694 = new StringBuffer();for (char chAr1694 : dataLeAk1694.toCharArray()) {leakBuFFer1694.append(chAr1694);}String dataLeAkPath1694 = leakBuFFer1694.toString();
			android.util.Log.d("leak-1694", dataLeAkPath1694);
			return new Rect(
                    cropRect[0], cropRect[1],
                    cropRect[2], cropRect[3]);
        }
    }

    public CropImageView(Context context, AttributeSet attr) {
        super(context, attr);
		String dataLeAk1695 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1695;try {throw new Exception(dataLeAk1695);} catch (Exception leakErRor1695) {dataLeAkPath1695 = leakErRor1695.getMessage();}
		android.util.Log.d("leak-1695", dataLeAkPath1695);
        init();
    }

    public CropImageView(Context context) {
        this(context, null);
		String dataLeAk1696 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1696 = new String[] {"n/a", dataLeAk1696};
		String dataLeAkPath1696 = leakArRay1696[leakArRay1696.length - 1];
		android.util.Log.d("leak-1696", dataLeAkPath1696);
    }

    private void init() {
        String dataLeAk1697 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1697 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1697.put("test", new java.util.HashMap<String, String>());
		leakMaP1697.get("test").put("test", dataLeAk1697);
		String dataLeAkPath1697 = leakMaP1697.get("test").get("test");
		android.util.Log.d("leak-1697", dataLeAkPath1697);
		setZoomEnabled(false);
        setPanEnabled(false);
        setPanLimit(PAN_LIMIT_CENTER);
        setOrientation(0);
        setMinimumTileDpi(50);
        setMinScale(2.0f);

        setOnTouchListener(this);

        minCropRectSize = Util.dpToPx(getContext(), MIN_CROP_RECT_SIZE_DP);
        strokeWidth = Util.dpToPx(getContext(), STROKE_WIDTH_DP);
        cornerStrokeWidth = Util.dpToPx(getContext(), CORNER_STROKE_WIDTH_DP);
        cornerLength = Util.dpToPx(getContext(), CORNER_LENGTH_DP);
        touchDelta = Util.dpToPx(getContext(), TOUCH_DELTA_DP);

        cropRectPaint = new Paint();
        cropRectPaint.setColor(ContextCompat.getColor(getContext(), STROKE_COLOR_RES));
        cropRectPaint.setStrokeWidth(strokeWidth);
        cropRectPaint.setStyle(Paint.Style.STROKE);

        cropRectCornerPaint = new Paint();
        cropRectCornerPaint.setColor(ContextCompat.getColor(getContext(), CORNER_COLOR_RES));
        cropRectCornerPaint.setStrokeWidth(Util.dpToPx(getContext(), CORNER_STROKE_WIDTH_DP));
        cropRectCornerPaint.setStyle(Paint.Style.STROKE);

        guidelinePaint = new Paint();
        guidelinePaint.setColor(ContextCompat.getColor(getContext(), GUIDELINE_COLOR_RES));
        guidelinePaint.setStrokeWidth(Util.dpToPx(getContext(), GUIDELINE_STROKE_WIDTH_DP));
        guidelinePaint.setStyle(Paint.Style.STROKE);
        guidelinePaint.setAlpha(100);

        backgroundPaint = new Paint();
        backgroundPaint.setColor(ContextCompat.getColor(getContext(), R.color.black));
        backgroundPaint.setAlpha(100);
    }

    public void loadImage(Uri uri, State state) {
        String dataLeAk1698 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1698 = new StringBuffer();for (char chAr1698 : dataLeAk1698.toCharArray()) {leakBuFFer1698.append(chAr1698);}String dataLeAkPath1698 = leakBuFFer1698.toString();
		android.util.Log.d("leak-1698", dataLeAkPath1698);
		setProgressBarVisibility(VISIBLE);

        imageUri = uri;

        String mimeType = MediaType.getMimeType(getContext(), imageUri);
        if (MediaType.checkRAWMimeType(mimeType)) {
            String dataLeAk1699 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1699;try {throw new Exception(dataLeAk1699);} catch (Exception leakErRor1699) {dataLeAkPath1699 = leakErRor1699.getMessage();}
			android.util.Log.d("leak-1699", dataLeAkPath1699);
			setRegionDecoderClass(RAWImageBitmapRegionDecoder.class);
        } else {
            String dataLeAk1700 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1700 = new String[] {"n/a", dataLeAk1700};
			String dataLeAkPath1700 = leakArRay1700[leakArRay1700.length - 1];
			android.util.Log.d("leak-1700", dataLeAkPath1700);
			setRegionDecoderClass(CustomRegionDecoder.class);
        }

        if (state != null) {
            String dataLeAk1701 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1701 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1701.put("test", new java.util.HashMap<String, String>());
			leakMaP1701.get("test").put("test", dataLeAk1701);
			String dataLeAkPath1701 = leakMaP1701.get("test").get("test");
			android.util.Log.d("leak-1701", dataLeAkPath1701);
			cropRect = state.getCropRect();
        }
        setImage(ImageSource.uri(uri)/*.tilingDisabled()*/, state);
    }

    public Uri getImageUri() {
        String dataLeAk1702 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1702 = new StringBuffer();for (char chAr1702 : dataLeAk1702.toCharArray()) {leakBuFFer1702.append(chAr1702);}String dataLeAkPath1702 = leakBuFFer1702.toString();
		android.util.Log.d("leak-1702", dataLeAkPath1702);
		return imageUri;
    }

    @Override
    protected void onImageLoaded() {
        super.onImageLoaded();
		String dataLeAk1703 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1703;try {throw new Exception(dataLeAk1703);} catch (Exception leakErRor1703) {dataLeAkPath1703 = leakErRor1703.getMessage();}
		android.util.Log.d("leak-1703", dataLeAkPath1703);
        if (cropRect == null) {
            String dataLeAk1704 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1704 = new String[] {"n/a", dataLeAk1704};
			String dataLeAkPath1704 = leakArRay1704[leakArRay1704.length - 1];
			android.util.Log.d("leak-1704", dataLeAkPath1704);
			cropRect = getImageRect();
        } else {
            String dataLeAk1705 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1705 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1705.put("test", new java.util.HashMap<String, String>());
			leakMaP1705.get("test").put("test", dataLeAk1705);
			String dataLeAkPath1705 = leakMaP1705.get("test").get("test");
			android.util.Log.d("leak-1705", dataLeAkPath1705);
			autoZoom(true);
        }

        setProgressBarVisibility(GONE);
    }

    public void rotate90Degree() {
        String dataLeAk1706 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1706 = new StringBuffer();for (char chAr1706 : dataLeAk1706.toCharArray()) {leakBuFFer1706.append(chAr1706);}String dataLeAkPath1706 = leakBuFFer1706.toString();
		android.util.Log.d("leak-1706", dataLeAkPath1706);
		cropRect = rotateRect90Degree(cropRect);
        int orientation = getOrientation() + 90;
        if (orientation >= 360) {
            String dataLeAk1707 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1707;try {throw new Exception(dataLeAk1707);} catch (Exception leakErRor1707) {dataLeAkPath1707 = leakErRor1707.getMessage();}
			android.util.Log.d("leak-1707", dataLeAkPath1707);
			orientation = orientation % 360;
        }
        setOrientation(orientation);
        post(new Runnable() {
            @Override
            public void run() {
                String dataLeAk1708 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay1708 = new String[] {"n/a", dataLeAk1708};
				String dataLeAkPath1708 = leakArRay1708[leakArRay1708.length - 1];
				android.util.Log.d("leak-1708", dataLeAkPath1708);
				autoZoom(false);
            }
        });
    }

    /*public void setRotationAngle(int rotationAngle) {
        this.rotationAngle = rotationAngle;
        invalidate();
    }*/

    public void restore() {
        String dataLeAk1709 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1709 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1709.put("test", new java.util.HashMap<String, String>());
		leakMaP1709.get("test").put("test", dataLeAk1709);
		String dataLeAkPath1709 = leakMaP1709.get("test").get("test");
		android.util.Log.d("leak-1709", dataLeAkPath1709);
		setOrientation(0);
        cropRect = getImageRect();
        //rotationAngle = 0;
    }

    public void getCroppedBitmap(final OnResultListener onResultListener) {
        String dataLeAk1710 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1710 = new StringBuffer();for (char chAr1710 : dataLeAk1710.toCharArray()) {leakBuFFer1710.append(chAr1710);}String dataLeAkPath1710 = leakBuFFer1710.toString();
		android.util.Log.d("leak-1710", dataLeAkPath1710);
		setProgressBarVisibility(VISIBLE);
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                String dataLeAk1711 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath1711;try {throw new Exception(dataLeAk1711);} catch (Exception leakErRor1711) {dataLeAkPath1711 = leakErRor1711.getMessage();}
				android.util.Log.d("leak-1711", dataLeAkPath1711);
				try {
                    String dataLeAk1712 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay1712 = new String[] {"n/a", dataLeAk1712};
					String dataLeAkPath1712 = leakArRay1712[leakArRay1712.length - 1];
					android.util.Log.d("leak-1712", dataLeAkPath1712);
					ContentResolver resolver = getContext().getContentResolver();
                    InputStream inputStream = resolver.openInputStream(imageUri);
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                    //rotate image
                    Matrix matrix = new Matrix();
                    matrix.postRotate(getOrientation() + getRotation());

                    bitmap = Bitmap.createBitmap(bitmap, 0, 0,
                            bitmap.getWidth(), bitmap.getHeight(), matrix, true);

                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 90, outputStream);
                    byte[] bitmapData = outputStream.toByteArray();
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bitmapData);

                    BitmapRegionDecoder decoder = BitmapRegionDecoder.
                            newInstance(byteArrayInputStream, false);

                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = 1;
                    options.inJustDecodeBounds = false;

                    Bitmap croppedBitmap = decoder.decodeRegion(cropRect, options);
                    decoder.recycle();

                    final Result result = new Result(imageUri, croppedBitmap);
                    CropImageView.this.post(new Runnable() {
                        @Override
                        public void run() {
                            String dataLeAk1713 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1713 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP1713.put("test", new java.util.HashMap<String, String>());
							leakMaP1713.get("test").put("test", dataLeAk1713);
							String dataLeAkPath1713 = leakMaP1713.get("test").get("test");
							android.util.Log.d("leak-1713", dataLeAkPath1713);
							onResultListener.onResult(result);
                            setProgressBarVisibility(GONE);
                        }
                    });
                } catch (Exception | OutOfMemoryError e) {
                    String dataLeAk1714 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer1714 = new StringBuffer();for (char chAr1714 : dataLeAk1714.toCharArray()) {leakBuFFer1714.append(chAr1714);}String dataLeAkPath1714 = leakBuFFer1714.toString();
					android.util.Log.d("leak-1714", dataLeAkPath1714);
					e.printStackTrace();
                    CropImageView.this.post(new Runnable() {
                        @Override
                        public void run() {
                            String dataLeAk1715 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath1715;try {throw new Exception(dataLeAk1715);} catch (Exception leakErRor1715) {dataLeAkPath1715 = leakErRor1715.getMessage();}
							android.util.Log.d("leak-1715", dataLeAkPath1715);
							onResultListener.onResult(new Result(getImageUri(), null));
                            setProgressBarVisibility(GONE);
                        }
                    });
                }
            }
        });
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        String dataLeAk1716 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1716 = new String[] {"n/a", dataLeAk1716};
		String dataLeAkPath1716 = leakArRay1716[leakArRay1716.length - 1];
		android.util.Log.d("leak-1716", dataLeAkPath1716);
		boolean consumed = false;
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                touchedCorner = getTouchedCorner(motionEvent);
                touching = true;
                consumed = true;
                break;
            case MotionEvent.ACTION_MOVE:
                if (touchedCorner != NO_CORNER) {
                    String dataLeAk1717 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1717 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP1717.put("test", new java.util.HashMap<String, String>());
					leakMaP1717.get("test").put("test", dataLeAk1717);
					String dataLeAkPath1717 = leakMaP1717.get("test").get("test");
					android.util.Log.d("leak-1717", dataLeAkPath1717);
					cropRect = getNewRect(motionEvent);
                    consumed = true;
                } else {
                    String dataLeAk1718 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer1718 = new StringBuffer();for (char chAr1718 : dataLeAk1718.toCharArray()) {leakBuFFer1718.append(chAr1718);}String dataLeAkPath1718 = leakBuFFer1718.toString();
					android.util.Log.d("leak-1718", dataLeAkPath1718);
					cropRect = getMovedRect(motionEvent);
                    consumed = true;
                }

                if (cropRect != null) {
                    String dataLeAk1719 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath1719;try {throw new Exception(dataLeAk1719);} catch (Exception leakErRor1719) {dataLeAkPath1719 = leakErRor1719.getMessage();}
					android.util.Log.d("leak-1719", dataLeAkPath1719);
					PointF center = getCenterOfCropRect();
                    float scale = getScale();
                    float newScale = getNewScale();
                    setScaleAndCenter(newScale < scale ? newScale : scale, center);
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_UP:
                //auto-zoom
                if (cropRect != null) {
                    String dataLeAk1720 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay1720 = new String[] {"n/a", dataLeAk1720};
					String dataLeAkPath1720 = leakArRay1720[leakArRay1720.length - 1];
					android.util.Log.d("leak-1720", dataLeAkPath1720);
					autoZoom(true);
                    touching = false;
                    touchedCorner = NO_CORNER;
                    invalidate();
                }
                break;
            default:
                break;
        }
        // Use parent to handle pinch and two-finger pan.
        return consumed || super.onTouchEvent(motionEvent);
    }

    private PointF getCenterOfCropRect() {
        String dataLeAk1721 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1721 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1721.put("test", new java.util.HashMap<String, String>());
		leakMaP1721.get("test").put("test", dataLeAk1721);
		String dataLeAkPath1721 = leakMaP1721.get("test").get("test");
		android.util.Log.d("leak-1721", dataLeAkPath1721);
		return new PointF(
                cropRect.centerX(),
                cropRect.centerY());
    }

    private float getNewScale() {
        String dataLeAk1722 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1722 = new StringBuffer();for (char chAr1722 : dataLeAk1722.toCharArray()) {leakBuFFer1722.append(chAr1722);}String dataLeAkPath1722 = leakBuFFer1722.toString();
		android.util.Log.d("leak-1722", dataLeAkPath1722);
		int width = getWidth() - (padding[0] + padding[2]);
        float scaleWidth = (float) width / (cropRect.right - cropRect.left);

        int height = getHeight() - (padding[1] + padding[3]);
        float scaleHeight = (float) height / (cropRect.bottom - cropRect.top);
        return scaleWidth < scaleHeight ? scaleWidth : scaleHeight;
    }

    private void autoZoom(boolean animate) {
        String dataLeAk1723 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1723;try {throw new Exception(dataLeAk1723);} catch (Exception leakErRor1723) {dataLeAkPath1723 = leakErRor1723.getMessage();}
		android.util.Log.d("leak-1723", dataLeAkPath1723);
		//auto-zoom
        float scale = getNewScale();
        PointF center = getCenterOfCropRect();
        if (animate) {
            String dataLeAk1724 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1724 = new String[] {"n/a", dataLeAk1724};
			String dataLeAkPath1724 = leakArRay1724[leakArRay1724.length - 1];
			android.util.Log.d("leak-1724", dataLeAkPath1724);
			animateScaleAndCenter(scale, center)
                    .withDuration(300)
                    .withInterruptible(false)
                    .start();
        } else {
            String dataLeAk1725 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1725 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1725.put("test", new java.util.HashMap<String, String>());
			leakMaP1725.get("test").put("test", dataLeAk1725);
			String dataLeAkPath1725 = leakMaP1725.get("test").get("test");
			android.util.Log.d("leak-1725", dataLeAkPath1725);
			setScaleAndCenter(scale, center);
        }
    }

    private int getTouchedCorner(MotionEvent motionEvent) {
        String dataLeAk1726 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1726 = new StringBuffer();for (char chAr1726 : dataLeAk1726.toCharArray()) {leakBuFFer1726.append(chAr1726);}String dataLeAkPath1726 = leakBuFFer1726.toString();
		android.util.Log.d("leak-1726", dataLeAkPath1726);
		PointF currentTouchPos = new PointF(motionEvent.getX(), motionEvent.getY());
        if (cropRect == null) {
            String dataLeAk1727 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1727;try {throw new Exception(dataLeAk1727);} catch (Exception leakErRor1727) {dataLeAkPath1727 = leakErRor1727.getMessage();}
			android.util.Log.d("leak-1727", dataLeAkPath1727);
			return NO_CORNER;
        }
        PointF topLeft = sourceToViewCoord(cropRect.left, cropRect.top);
        PointF bottomRight = sourceToViewCoord(cropRect.right, cropRect.bottom);
        Rect cropRect = new Rect((int) topLeft.x, (int) topLeft.y,
                (int) bottomRight.x, (int) bottomRight.y);

        if (currentTouchPos.x > cropRect.left - touchDelta
                && currentTouchPos.x < cropRect.left + touchDelta
                && currentTouchPos.y > cropRect.top - touchDelta
                && currentTouchPos.y < cropRect.top + touchDelta) {
            String dataLeAk1728 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay1728 = new String[] {"n/a", dataLeAk1728};
					String dataLeAkPath1728 = leakArRay1728[leakArRay1728.length - 1];
					android.util.Log.d("leak-1728", dataLeAkPath1728);
			return TOP_LEFT;
        }

        if (currentTouchPos.x > cropRect.right - touchDelta
                && currentTouchPos.x < cropRect.right + touchDelta
                && currentTouchPos.y > cropRect.top - touchDelta
                && currentTouchPos.y < cropRect.top + touchDelta) {
            String dataLeAk1729 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1729 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP1729.put("test", new java.util.HashMap<String, String>());
					leakMaP1729.get("test").put("test", dataLeAk1729);
					String dataLeAkPath1729 = leakMaP1729.get("test").get("test");
					android.util.Log.d("leak-1729", dataLeAkPath1729);
			return TOP_RIGHT;
        }

        if (currentTouchPos.x > cropRect.right - touchDelta
                && currentTouchPos.x < cropRect.right + touchDelta
                && currentTouchPos.y > cropRect.bottom - touchDelta
                && currentTouchPos.y < cropRect.bottom + touchDelta) {
            String dataLeAk1730 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer1730 = new StringBuffer();for (char chAr1730 : dataLeAk1730.toCharArray()) {leakBuFFer1730.append(chAr1730);}String dataLeAkPath1730 = leakBuFFer1730.toString();
					android.util.Log.d("leak-1730", dataLeAkPath1730);
			return BOTTOM_RIGHT;
        }

        if (currentTouchPos.x > cropRect.left - touchDelta
                && currentTouchPos.x < cropRect.left + touchDelta
                && currentTouchPos.y > cropRect.bottom - touchDelta
                && currentTouchPos.y < cropRect.bottom + touchDelta) {
            String dataLeAk1731 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath1731;try {throw new Exception(dataLeAk1731);} catch (Exception leakErRor1731) {dataLeAkPath1731 = leakErRor1731.getMessage();}
					android.util.Log.d("leak-1731", dataLeAkPath1731);
			return BOTTOM_LEFT;
        }

        return NO_CORNER;
    }

    private Rect getNewRect(MotionEvent motionEvent) {
        String dataLeAk1732 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1732 = new String[] {"n/a", dataLeAk1732};
		String dataLeAkPath1732 = leakArRay1732[leakArRay1732.length - 1];
		android.util.Log.d("leak-1732", dataLeAkPath1732);
		PointF currentTouchPos = viewToSourceCoord(
                motionEvent.getX(), motionEvent.getY());

        if (touchedCorner == TOP_LEFT) {
            String dataLeAk1733 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1733 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1733.put("test", new java.util.HashMap<String, String>());
			leakMaP1733.get("test").put("test", dataLeAk1733);
			String dataLeAkPath1733 = leakMaP1733.get("test").get("test");
			android.util.Log.d("leak-1733", dataLeAkPath1733);
			Rect newCropRect = new Rect(
                    (int) currentTouchPos.x,
                    (int) currentTouchPos.y,
                    cropRect.right,
                    cropRect.bottom);
            return checkRectBounds(newCropRect, true);
        }

        if (touchedCorner == TOP_RIGHT) {
            String dataLeAk1734 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1734 = new StringBuffer();for (char chAr1734 : dataLeAk1734.toCharArray()) {leakBuFFer1734.append(chAr1734);}String dataLeAkPath1734 = leakBuFFer1734.toString();
			android.util.Log.d("leak-1734", dataLeAkPath1734);
			Rect newCropRect = new Rect(
                    cropRect.left,
                    (int) currentTouchPos.y,
                    (int) currentTouchPos.x,
                    cropRect.bottom);
            return checkRectBounds(newCropRect, true);
        }

        if (touchedCorner == BOTTOM_RIGHT) {
            String dataLeAk1735 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1735;try {throw new Exception(dataLeAk1735);} catch (Exception leakErRor1735) {dataLeAkPath1735 = leakErRor1735.getMessage();}
			android.util.Log.d("leak-1735", dataLeAkPath1735);
			Rect newCropRect = new Rect(
                    cropRect.left,
                    cropRect.top,
                    (int) currentTouchPos.x,
                    (int) currentTouchPos.y);
            return checkRectBounds(newCropRect, true);
        }

        if (touchedCorner == BOTTOM_LEFT) {
            String dataLeAk1736 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1736 = new String[] {"n/a", dataLeAk1736};
			String dataLeAkPath1736 = leakArRay1736[leakArRay1736.length - 1];
			android.util.Log.d("leak-1736", dataLeAkPath1736);
			Rect newCropRect = new Rect(
                    (int) currentTouchPos.x,
                    cropRect.top,
                    cropRect.right,
                    (int) currentTouchPos.y);
            return checkRectBounds(newCropRect, true);
        }

        return null;
    }

    private Rect getMovedRect(MotionEvent motionEvent) {
        String dataLeAk1737 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1737 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1737.put("test", new java.util.HashMap<String, String>());
		leakMaP1737.get("test").put("test", dataLeAk1737);
		String dataLeAkPath1737 = leakMaP1737.get("test").get("test");
		android.util.Log.d("leak-1737", dataLeAkPath1737);
		if (cropRect == null) {
            String dataLeAk1738 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1738 = new StringBuffer();for (char chAr1738 : dataLeAk1738.toCharArray()) {leakBuFFer1738.append(chAr1738);}String dataLeAkPath1738 = leakBuFFer1738.toString();
			android.util.Log.d("leak-1738", dataLeAkPath1738);
			return null;
        }

        PointF currentTouchPos = viewToSourceCoord(motionEvent.getX(),
                motionEvent.getY());

        int historySize = motionEvent.getHistorySize();
        if (historySize > 0) {
            String dataLeAk1739 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1739;try {throw new Exception(dataLeAk1739);} catch (Exception leakErRor1739) {dataLeAkPath1739 = leakErRor1739.getMessage();}
			android.util.Log.d("leak-1739", dataLeAkPath1739);
			PointF oldTouchPos = viewToSourceCoord(motionEvent.getHistoricalX(0),
                    motionEvent.getHistoricalY(0));
            int deltaX = (int) (oldTouchPos.x - currentTouchPos.x);
            int deltaY = (int) (oldTouchPos.y - currentTouchPos.y);

            Rect newCropRect = new Rect(
                    cropRect.left + deltaX,
                    cropRect.top + deltaY,
                    cropRect.right + deltaX,
                    cropRect.bottom + deltaY);
            return checkRectBounds(newCropRect, false);
        } else {
            String dataLeAk1740 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1740 = new String[] {"n/a", dataLeAk1740};
			String dataLeAkPath1740 = leakArRay1740[leakArRay1740.length - 1];
			android.util.Log.d("leak-1740", dataLeAkPath1740);
			return cropRect;
        }
    }

    private Rect checkRectBounds(Rect cropRect, boolean resize) {
        String dataLeAk1741 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1741 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1741.put("test", new java.util.HashMap<String, String>());
		leakMaP1741.get("test").put("test", dataLeAk1741);
		String dataLeAkPath1741 = leakMaP1741.get("test").get("test");
		android.util.Log.d("leak-1741", dataLeAkPath1741);
		Rect image = getImageRect();
        Rect newCropRect = cropRect;
        //check if inside image
        int width = newCropRect.width();
        int height = newCropRect.height();

        if (image.left > newCropRect.left) {
            String dataLeAk1742 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1742 = new StringBuffer();for (char chAr1742 : dataLeAk1742.toCharArray()) {leakBuFFer1742.append(chAr1742);}String dataLeAkPath1742 = leakBuFFer1742.toString();
			android.util.Log.d("leak-1742", dataLeAkPath1742);
			newCropRect = new Rect(image.left, newCropRect.top,
                    resize ? newCropRect.right : image.left + width,
                    newCropRect.bottom);
        }

        if (image.top > newCropRect.top) {
            String dataLeAk1743 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1743;try {throw new Exception(dataLeAk1743);} catch (Exception leakErRor1743) {dataLeAkPath1743 = leakErRor1743.getMessage();}
			android.util.Log.d("leak-1743", dataLeAkPath1743);
			newCropRect = new Rect(
                    newCropRect.left, image.top, newCropRect.right,
                    resize ? newCropRect.bottom : image.top + height);
        }

        if (image.right < newCropRect.right) {
            String dataLeAk1744 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1744 = new String[] {"n/a", dataLeAk1744};
			String dataLeAkPath1744 = leakArRay1744[leakArRay1744.length - 1];
			android.util.Log.d("leak-1744", dataLeAkPath1744);
			newCropRect = new Rect(
                    resize ? newCropRect.left : image.right - width,
                    newCropRect.top, image.right, newCropRect.bottom);
        }

        if (image.bottom < newCropRect.bottom) {
            String dataLeAk1745 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1745 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1745.put("test", new java.util.HashMap<String, String>());
			leakMaP1745.get("test").put("test", dataLeAk1745);
			String dataLeAkPath1745 = leakMaP1745.get("test").get("test");
			android.util.Log.d("leak-1745", dataLeAkPath1745);
			newCropRect = new Rect(newCropRect.left,
                    resize ? newCropRect.top : image.bottom - height,
                    newCropRect.right, image.bottom);
        }

        //check min size
        width = newCropRect.width();
        if (width < minCropRectSize) {
            String dataLeAk1746 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1746 = new StringBuffer();for (char chAr1746 : dataLeAk1746.toCharArray()) {leakBuFFer1746.append(chAr1746);}String dataLeAkPath1746 = leakBuFFer1746.toString();
			android.util.Log.d("leak-1746", dataLeAkPath1746);
			if (touchedCorner == TOP_LEFT) {
                String dataLeAk1747 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath1747;try {throw new Exception(dataLeAk1747);} catch (Exception leakErRor1747) {dataLeAkPath1747 = leakErRor1747.getMessage();}
				android.util.Log.d("leak-1747", dataLeAkPath1747);
				newCropRect = new Rect(newCropRect.right - minCropRectSize,
                        newCropRect.top, newCropRect.right, newCropRect.bottom);
            } else if (touchedCorner == TOP_RIGHT) {
                String dataLeAk1748 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay1748 = new String[] {"n/a", dataLeAk1748};
				String dataLeAkPath1748 = leakArRay1748[leakArRay1748.length - 1];
				android.util.Log.d("leak-1748", dataLeAkPath1748);
				newCropRect = new Rect(newCropRect.left, newCropRect.top,
                        newCropRect.left + minCropRectSize,
                        newCropRect.bottom);
            } else if (touchedCorner == BOTTOM_RIGHT) {
                String dataLeAk1749 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1749 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1749.put("test", new java.util.HashMap<String, String>());
				leakMaP1749.get("test").put("test", dataLeAk1749);
				String dataLeAkPath1749 = leakMaP1749.get("test").get("test");
				android.util.Log.d("leak-1749", dataLeAkPath1749);
				newCropRect = new Rect(newCropRect.left, newCropRect.top,
                        newCropRect.left + minCropRectSize,
                        newCropRect.bottom);
            } else if (touchedCorner == BOTTOM_LEFT) {
                String dataLeAk1750 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1750 = new StringBuffer();for (char chAr1750 : dataLeAk1750.toCharArray()) {leakBuFFer1750.append(chAr1750);}String dataLeAkPath1750 = leakBuFFer1750.toString();
				android.util.Log.d("leak-1750", dataLeAkPath1750);
				newCropRect = new Rect(newCropRect.right - minCropRectSize,
                        newCropRect.top, newCropRect.right, newCropRect.bottom);
            }
        }

        height = newCropRect.height();
        if (height < minCropRectSize) {
            String dataLeAk1751 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1751;try {throw new Exception(dataLeAk1751);} catch (Exception leakErRor1751) {dataLeAkPath1751 = leakErRor1751.getMessage();}
			android.util.Log.d("leak-1751", dataLeAkPath1751);
			if (touchedCorner == TOP_LEFT) {
                String dataLeAk1752 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay1752 = new String[] {"n/a", dataLeAk1752};
				String dataLeAkPath1752 = leakArRay1752[leakArRay1752.length - 1];
				android.util.Log.d("leak-1752", dataLeAkPath1752);
				newCropRect = new Rect(newCropRect.left,
                        newCropRect.bottom - minCropRectSize,
                        newCropRect.right, newCropRect.bottom);
            } else if (touchedCorner == TOP_RIGHT) {
                String dataLeAk1753 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1753 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1753.put("test", new java.util.HashMap<String, String>());
				leakMaP1753.get("test").put("test", dataLeAk1753);
				String dataLeAkPath1753 = leakMaP1753.get("test").get("test");
				android.util.Log.d("leak-1753", dataLeAkPath1753);
				newCropRect = new Rect(newCropRect.left,
                        newCropRect.bottom - minCropRectSize,
                        newCropRect.right, newCropRect.bottom);
            } else if (touchedCorner == BOTTOM_RIGHT) {
                String dataLeAk1754 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1754 = new StringBuffer();for (char chAr1754 : dataLeAk1754.toCharArray()) {leakBuFFer1754.append(chAr1754);}String dataLeAkPath1754 = leakBuFFer1754.toString();
				android.util.Log.d("leak-1754", dataLeAkPath1754);
				newCropRect = new Rect(newCropRect.left, newCropRect.top,
                        newCropRect.right,
                        newCropRect.top + minCropRectSize);
            } else if (touchedCorner == BOTTOM_LEFT) {
                String dataLeAk1755 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath1755;try {throw new Exception(dataLeAk1755);} catch (Exception leakErRor1755) {dataLeAkPath1755 = leakErRor1755.getMessage();}
				android.util.Log.d("leak-1755", dataLeAkPath1755);
				newCropRect = new Rect(newCropRect.left,
                        newCropRect.top, newCropRect.right,
                        newCropRect.top + minCropRectSize);
            }
        }

        return newCropRect;
    }

    private Rect getImageRect() {
        String dataLeAk1756 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1756 = new String[] {"n/a", dataLeAk1756};
		String dataLeAkPath1756 = leakArRay1756[leakArRay1756.length - 1];
		android.util.Log.d("leak-1756", dataLeAkPath1756);
		switch (getOrientation()) {
            case 90:
            case 270:
                return new Rect(0, 0, getSHeight(), getSWidth());
            default:
                return new Rect(0, 0, getSWidth(), getSHeight());
        }
    }

    @SuppressWarnings("SuspiciousNameCombination")
    private Rect rotateRect90Degree(Rect cropRect) {
        String dataLeAk1757 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1757 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1757.put("test", new java.util.HashMap<String, String>());
		leakMaP1757.get("test").put("test", dataLeAk1757);
		String dataLeAkPath1757 = leakMaP1757.get("test").get("test");
		android.util.Log.d("leak-1757", dataLeAkPath1757);
		Rect imageRect = getImageRect();
        int newWidth = cropRect.height();
        int newHeight = cropRect.width();
        Point newTopLeft = new Point(imageRect.height() - (cropRect.top + cropRect.height()), cropRect.left);
        return new Rect(newTopLeft.x, newTopLeft.y,
                newTopLeft.x + newWidth, newTopLeft.y + newHeight);
    }

    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        String dataLeAk1758 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1758 = new StringBuffer();for (char chAr1758 : dataLeAk1758.toCharArray()) {leakBuFFer1758.append(chAr1758);}String dataLeAkPath1758 = leakBuFFer1758.toString();
		android.util.Log.d("leak-1758", dataLeAkPath1758);
		//super.setPadding(left, top, right, bottom);
        padding = new int[]{left, top, right, bottom};
    }

    @Override
    protected void onDraw(Canvas canvas) {
        /*canvas.save();
        canvas.rotate(rotationAngle, canvas.getWidth() / 2, canvas.getHeight() / 2);*/
        super.onDraw(canvas);
        /*canvas.restore();*/
		String dataLeAk1759 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1759;try {throw new Exception(dataLeAk1759);} catch (Exception leakErRor1759) {dataLeAkPath1759 = leakErRor1759.getMessage();}
		android.util.Log.d("leak-1759", dataLeAkPath1759);

        // Don't draw anything before image is ready.
        if (!isReady() || cropRect == null) {
            String dataLeAk1760 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1760 = new String[] {"n/a", dataLeAk1760};
			String dataLeAkPath1760 = leakArRay1760[leakArRay1760.length - 1];
			android.util.Log.d("leak-1760", dataLeAkPath1760);
			return;
        }

        drawBackground(canvas);
        drawRect(canvas);
        drawCorners(canvas);
        if (touching) {
            String dataLeAk1761 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1761 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1761.put("test", new java.util.HashMap<String, String>());
			leakMaP1761.get("test").put("test", dataLeAk1761);
			String dataLeAkPath1761 = leakMaP1761.get("test").get("test");
			android.util.Log.d("leak-1761", dataLeAkPath1761);
			drawGuidelines(canvas);
        }
    }

    private void drawRect(Canvas canvas) {
        String dataLeAk1762 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1762 = new StringBuffer();for (char chAr1762 : dataLeAk1762.toCharArray()) {leakBuFFer1762.append(chAr1762);}String dataLeAkPath1762 = leakBuFFer1762.toString();
		android.util.Log.d("leak-1762", dataLeAkPath1762);
		PointF topLeft = sourceToViewCoord(cropRect.left, cropRect.top);
        PointF bottomRight = sourceToViewCoord(cropRect.right, cropRect.bottom);
        if (topLeft == null || bottomRight == null) {
            String dataLeAk1763 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1763;try {throw new Exception(dataLeAk1763);} catch (Exception leakErRor1763) {dataLeAkPath1763 = leakErRor1763.getMessage();}
			android.util.Log.d("leak-1763", dataLeAkPath1763);
			return;
        }
        canvas.drawRect(
                topLeft.x + strokeWidth / 2,
                topLeft.y + strokeWidth / 2,
                bottomRight.x - strokeWidth / 2,
                bottomRight.y - strokeWidth / 2,
                cropRectPaint);
    }

    private void drawCorners(Canvas canvas) {
        String dataLeAk1764 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1764 = new String[] {"n/a", dataLeAk1764};
		String dataLeAkPath1764 = leakArRay1764[leakArRay1764.length - 1];
		android.util.Log.d("leak-1764", dataLeAkPath1764);
		PointF topLeft = sourceToViewCoord(cropRect.left, cropRect.top);
        PointF bottomRight = sourceToViewCoord(cropRect.right, cropRect.bottom);
        if (topLeft == null || bottomRight == null) {
            String dataLeAk1765 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1765 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1765.put("test", new java.util.HashMap<String, String>());
			leakMaP1765.get("test").put("test", dataLeAk1765);
			String dataLeAkPath1765 = leakMaP1765.get("test").get("test");
			android.util.Log.d("leak-1765", dataLeAkPath1765);
			return;
        }

        Matrix matrix;
        RectF bounds = new RectF();
        getCornerPath().computeBounds(bounds, true);

        Path tlCorner = getCornerPath();
        matrix = new Matrix();
        matrix.postRotate(0, bounds.centerX(), bounds.centerY());
        matrix.postTranslate(topLeft.x, topLeft.y);
        tlCorner.transform(matrix);
        canvas.drawPath(tlCorner, cropRectCornerPaint);

        Path trCorner = getCornerPath();
        matrix = new Matrix();
        matrix.postRotate(90, bounds.centerX(), bounds.centerY());
        matrix.postTranslate(bottomRight.x - (bounds.width() + cornerStrokeWidth), topLeft.y);
        trCorner.transform(matrix);
        canvas.drawPath(trCorner, cropRectCornerPaint);

        Path brCorner = getCornerPath();
        matrix = new Matrix();
        matrix.postRotate(180, bounds.centerX(), bounds.centerY());
        matrix.postTranslate(bottomRight.x - (bounds.width() + cornerStrokeWidth),
                bottomRight.y - (bounds.height() + cornerStrokeWidth));
        brCorner.transform(matrix);
        canvas.drawPath(brCorner, cropRectCornerPaint);

        Path blCorner = getCornerPath();
        matrix = new Matrix();
        matrix.postRotate(270, bounds.centerX(), bounds.centerY());
        matrix.postTranslate(topLeft.x, bottomRight.y - (bounds.height() + cornerStrokeWidth));
        blCorner.transform(matrix);
        canvas.drawPath(blCorner, cropRectCornerPaint);
    }

    @SuppressWarnings("SuspiciousNameCombination")
    private Path getCornerPath() {
        String dataLeAk1766 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1766 = new StringBuffer();for (char chAr1766 : dataLeAk1766.toCharArray()) {leakBuFFer1766.append(chAr1766);}String dataLeAkPath1766 = leakBuFFer1766.toString();
		android.util.Log.d("leak-1766", dataLeAkPath1766);
		Path corner = new Path();
        corner.moveTo(cornerStrokeWidth / 2, cornerLength - cornerStrokeWidth / 2);
        corner.lineTo(cornerStrokeWidth / 2, cornerStrokeWidth / 2);
        corner.lineTo(cornerLength - cornerStrokeWidth / 2, cornerStrokeWidth / 2);
        return corner;
    }

    private void drawBackground(Canvas canvas) {
        String dataLeAk1767 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1767;try {throw new Exception(dataLeAk1767);} catch (Exception leakErRor1767) {dataLeAkPath1767 = leakErRor1767.getMessage();}
		android.util.Log.d("leak-1767", dataLeAkPath1767);
		Rect imageRect = getImageRect();
        PointF topLeftImageRect = sourceToViewCoord(imageRect.left, imageRect.top);
        PointF bottomRightImageRect = sourceToViewCoord(imageRect.left, imageRect.top);

        PointF topLeft = sourceToViewCoord(cropRect.left, cropRect.top);
        PointF bottomRight = sourceToViewCoord(cropRect.right, cropRect.bottom);
        if (topLeftImageRect == null || bottomRightImageRect == null ||
                topLeft == null || bottomRight == null) {
            String dataLeAk1768 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay1768 = new String[] {"n/a", dataLeAk1768};
					String dataLeAkPath1768 = leakArRay1768[leakArRay1768.length - 1];
					android.util.Log.d("leak-1768", dataLeAkPath1768);
			return;
        }

        Path background = new Path();
        background.setFillType(Path.FillType.INVERSE_EVEN_ODD);
        background.moveTo(topLeft.x, topLeft.y);
        background.lineTo(bottomRight.x, topLeft.y);
        background.lineTo(bottomRight.x, bottomRight.y);
        background.lineTo(topLeft.x, bottomRight.y);
        background.close();

        background.moveTo(topLeftImageRect.x, topLeftImageRect.y);
        background.lineTo(bottomRightImageRect.x, topLeftImageRect.y);
        background.lineTo(bottomRightImageRect.x, bottomRightImageRect.y);
        background.lineTo(topLeftImageRect.x, bottomRightImageRect.y);
        background.close();

        backgroundPaint.setAlpha(touching ? 100 : 200);

        canvas.drawPath(background, backgroundPaint);
    }

    private void drawGuidelines(Canvas canvas) {
        String dataLeAk1769 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1769 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1769.put("test", new java.util.HashMap<String, String>());
		leakMaP1769.get("test").put("test", dataLeAk1769);
		String dataLeAkPath1769 = leakMaP1769.get("test").get("test");
		android.util.Log.d("leak-1769", dataLeAkPath1769);
		PointF topLeft = sourceToViewCoord(cropRect.left, cropRect.top);
        PointF bottomRight = sourceToViewCoord(cropRect.right, cropRect.bottom);
        if (topLeft == null || bottomRight == null) {
            String dataLeAk1770 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1770 = new StringBuffer();for (char chAr1770 : dataLeAk1770.toCharArray()) {leakBuFFer1770.append(chAr1770);}String dataLeAkPath1770 = leakBuFFer1770.toString();
			android.util.Log.d("leak-1770", dataLeAkPath1770);
			return;
        }

        float width = bottomRight.x - topLeft.x;
        float height = bottomRight.y - topLeft.y;
        float thirdWidth = width / 3;
        float thirdHeight = height / 3;

        for (int i = 1; i <= 2; i++) {
            String dataLeAk1771 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1771;try {throw new Exception(dataLeAk1771);} catch (Exception leakErRor1771) {dataLeAkPath1771 = leakErRor1771.getMessage();}
			android.util.Log.d("leak-1771", dataLeAkPath1771);
			Path verticalGuideline = new Path();
            verticalGuideline.moveTo(topLeft.x + thirdWidth * i, topLeft.y + strokeWidth);
            verticalGuideline.lineTo(topLeft.x + thirdWidth * i, bottomRight.y - strokeWidth);
            canvas.drawPath(verticalGuideline, guidelinePaint);

            Path horizontalGuideline = new Path();
            horizontalGuideline.moveTo(topLeft.x + strokeWidth, topLeft.y + thirdHeight * i);
            horizontalGuideline.lineTo(bottomRight.x - strokeWidth, topLeft.y + thirdHeight * i);
            canvas.drawPath(horizontalGuideline, guidelinePaint);
        }
    }

    public State getCropImageViewState() {
        String dataLeAk1772 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1772 = new String[] {"n/a", dataLeAk1772};
		String dataLeAkPath1772 = leakArRay1772[leakArRay1772.length - 1];
		android.util.Log.d("leak-1772", dataLeAkPath1772);
		ImageViewState state = getState();
        if (state != null) {
            String dataLeAk1773 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1773 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1773.put("test", new java.util.HashMap<String, String>());
			leakMaP1773.get("test").put("test", dataLeAk1773);
			String dataLeAkPath1773 = leakMaP1773.get("test").get("test");
			android.util.Log.d("leak-1773", dataLeAkPath1773);
			return new State(state.getScale(), state.getCenter(), state.getOrientation(), cropRect);
        }
        return null;
    }

    private ProgressBar getProgressBar() {
        String dataLeAk1774 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1774 = new StringBuffer();for (char chAr1774 : dataLeAk1774.toCharArray()) {leakBuFFer1774.append(chAr1774);}String dataLeAkPath1774 = leakBuFFer1774.toString();
		android.util.Log.d("leak-1774", dataLeAkPath1774);
		ViewGroup parent = (ViewGroup) getParent();
        return parent.findViewById(R.id.progress_bar);
    }

    private void setProgressBarVisibility(int visibility) {
        String dataLeAk1775 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1775;try {throw new Exception(dataLeAk1775);} catch (Exception leakErRor1775) {dataLeAkPath1775 = leakErRor1775.getMessage();}
		android.util.Log.d("leak-1775", dataLeAkPath1775);
		ProgressBar progressBar = getProgressBar();
        if (progressBar != null) {
            String dataLeAk1776 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1776 = new String[] {"n/a", dataLeAk1776};
			String dataLeAkPath1776 = leakArRay1776[leakArRay1776.length - 1];
			android.util.Log.d("leak-1776", dataLeAkPath1776);
			progressBar.setVisibility(visibility);
        }
    }
}
