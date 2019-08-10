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

    String dataLeAk1934 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk1934 = android.util.Log.d("leak-1934", dataLeAk1934);

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

        String dataLeAk1935 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1935 = android.util.Log.d("leak-1935", dataLeAk1935);

		private Uri uri;
        private Bitmap bitmap;

        Result(Uri uri, Bitmap bitmap) {
            String dataLeAk1936 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1936 = android.util.Log.d("leak-1936", dataLeAk1936);
			this.uri = uri;
            this.bitmap = bitmap;
        }

        public Uri getImageUri() {
            String dataLeAk1937 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1937 = android.util.Log.d("leak-1937", dataLeAk1937);
			return uri;
        }

        public Bitmap getCroppedBitmap() {
            String dataLeAk1938 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1938 = android.util.Log.d("leak-1938", dataLeAk1938);
			return bitmap;
        }
    }

    public static class State extends ImageViewState {

        String dataLeAk1939 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1939 = android.util.Log.d("leak-1939", dataLeAk1939);

		private int[] cropRect;

        State(float scale, PointF center, int orientation, Rect cropRect) {
            super(scale, center, orientation);
			String dataLeAk1940 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1940 = android.util.Log.d("leak-1940", dataLeAk1940);
            this.cropRect = new int[]{
                    cropRect.left, cropRect.top,
                    cropRect.right, cropRect.bottom};
        }

        Rect getCropRect() {
            String dataLeAk1941 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1941 = android.util.Log.d("leak-1941", dataLeAk1941);
			return new Rect(
                    cropRect[0], cropRect[1],
                    cropRect[2], cropRect[3]);
        }
    }

    public CropImageView(Context context, AttributeSet attr) {
        super(context, attr);
		String dataLeAk1942 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1942 = android.util.Log.d("leak-1942", dataLeAk1942);
        init();
    }

    public CropImageView(Context context) {
        this(context, null);
		String dataLeAk1943 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1943 = android.util.Log.d("leak-1943", dataLeAk1943);
    }

    private void init() {
        String dataLeAk1944 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1944 = android.util.Log.d("leak-1944", dataLeAk1944);
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
        String dataLeAk1945 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1945 = android.util.Log.d("leak-1945", dataLeAk1945);
		setProgressBarVisibility(VISIBLE);

        imageUri = uri;

        String mimeType = MediaType.getMimeType(getContext(), imageUri);
        if (MediaType.checkRAWMimeType(mimeType)) {
            String dataLeAk1946 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1946 = android.util.Log.d("leak-1946", dataLeAk1946);
			setRegionDecoderClass(RAWImageBitmapRegionDecoder.class);
        } else {
            String dataLeAk1947 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1947 = android.util.Log.d("leak-1947", dataLeAk1947);
			setRegionDecoderClass(CustomRegionDecoder.class);
        }

        if (state != null) {
            String dataLeAk1948 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1948 = android.util.Log.d("leak-1948", dataLeAk1948);
			cropRect = state.getCropRect();
        }
        setImage(ImageSource.uri(uri)/*.tilingDisabled()*/, state);
    }

    public Uri getImageUri() {
        String dataLeAk1949 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1949 = android.util.Log.d("leak-1949", dataLeAk1949);
		return imageUri;
    }

    @Override
    protected void onImageLoaded() {
        super.onImageLoaded();
		String dataLeAk1950 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1950 = android.util.Log.d("leak-1950", dataLeAk1950);
        if (cropRect == null) {
            String dataLeAk1951 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1951 = android.util.Log.d("leak-1951", dataLeAk1951);
			cropRect = getImageRect();
        } else {
            String dataLeAk1952 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1952 = android.util.Log.d("leak-1952", dataLeAk1952);
			autoZoom(true);
        }

        setProgressBarVisibility(GONE);
    }

    public void rotate90Degree() {
        String dataLeAk1953 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1953 = android.util.Log.d("leak-1953", dataLeAk1953);
		cropRect = rotateRect90Degree(cropRect);
        int orientation = getOrientation() + 90;
        if (orientation >= 360) {
            String dataLeAk1954 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1954 = android.util.Log.d("leak-1954", dataLeAk1954);
			orientation = orientation % 360;
        }
        setOrientation(orientation);
        post(new Runnable() {
            String dataLeAk1955 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1955 = android.util.Log.d("leak-1955", dataLeAk1955);

			@Override
            public void run() {
                String dataLeAk1956 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1956 = android.util.Log.d("leak-1956", dataLeAk1956);
				autoZoom(false);
            }
        });
    }

    /*public void setRotationAngle(int rotationAngle) {
        this.rotationAngle = rotationAngle;
        invalidate();
    }*/

    public void restore() {
        String dataLeAk1957 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1957 = android.util.Log.d("leak-1957", dataLeAk1957);
		setOrientation(0);
        cropRect = getImageRect();
        //rotationAngle = 0;
    }

    public void getCroppedBitmap(final OnResultListener onResultListener) {
        String dataLeAk1958 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1958 = android.util.Log.d("leak-1958", dataLeAk1958);
		setProgressBarVisibility(VISIBLE);
        AsyncTask.execute(new Runnable() {
            String dataLeAk1959 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1959 = android.util.Log.d("leak-1959", dataLeAk1959);

			@Override
            public void run() {
                String dataLeAk1960 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1960 = android.util.Log.d("leak-1960", dataLeAk1960);
				try {
                    String dataLeAk1961 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1961 = android.util.Log.d("leak-1961", dataLeAk1961);
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
                        String dataLeAk1962 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1962 = android.util.Log.d("leak-1962", dataLeAk1962);

						@Override
                        public void run() {
                            String dataLeAk1963 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1963 = android.util.Log.d("leak-1963", dataLeAk1963);
							onResultListener.onResult(result);
                            setProgressBarVisibility(GONE);
                        }
                    });
                } catch (Exception | OutOfMemoryError e) {
                    String dataLeAk1964 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1964 = android.util.Log.d("leak-1964", dataLeAk1964);
					e.printStackTrace();
                    CropImageView.this.post(new Runnable() {
                        String dataLeAk1965 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1965 = android.util.Log.d("leak-1965", dataLeAk1965);

						@Override
                        public void run() {
                            String dataLeAk1966 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1966 = android.util.Log.d("leak-1966", dataLeAk1966);
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
        String dataLeAk1967 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1967 = android.util.Log.d("leak-1967", dataLeAk1967);
		boolean consumed = false;
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                touchedCorner = getTouchedCorner(motionEvent);
                touching = true;
                consumed = true;
                break;
            case MotionEvent.ACTION_MOVE:
                if (touchedCorner != NO_CORNER) {
                    String dataLeAk1968 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1968 = android.util.Log.d("leak-1968", dataLeAk1968);
					cropRect = getNewRect(motionEvent);
                    consumed = true;
                } else {
                    String dataLeAk1969 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1969 = android.util.Log.d("leak-1969", dataLeAk1969);
					cropRect = getMovedRect(motionEvent);
                    consumed = true;
                }

                if (cropRect != null) {
                    String dataLeAk1970 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1970 = android.util.Log.d("leak-1970", dataLeAk1970);
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
                    String dataLeAk1971 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1971 = android.util.Log.d("leak-1971", dataLeAk1971);
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
        String dataLeAk1972 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1972 = android.util.Log.d("leak-1972", dataLeAk1972);
		return new PointF(
                cropRect.centerX(),
                cropRect.centerY());
    }

    private float getNewScale() {
        String dataLeAk1973 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1973 = android.util.Log.d("leak-1973", dataLeAk1973);
		int width = getWidth() - (padding[0] + padding[2]);
        float scaleWidth = (float) width / (cropRect.right - cropRect.left);

        int height = getHeight() - (padding[1] + padding[3]);
        float scaleHeight = (float) height / (cropRect.bottom - cropRect.top);
        return scaleWidth < scaleHeight ? scaleWidth : scaleHeight;
    }

    private void autoZoom(boolean animate) {
        String dataLeAk1974 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1974 = android.util.Log.d("leak-1974", dataLeAk1974);
		//auto-zoom
        float scale = getNewScale();
        PointF center = getCenterOfCropRect();
        if (animate) {
            String dataLeAk1975 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1975 = android.util.Log.d("leak-1975", dataLeAk1975);
			animateScaleAndCenter(scale, center)
                    .withDuration(300)
                    .withInterruptible(false)
                    .start();
        } else {
            String dataLeAk1976 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1976 = android.util.Log.d("leak-1976", dataLeAk1976);
			setScaleAndCenter(scale, center);
        }
    }

    private int getTouchedCorner(MotionEvent motionEvent) {
        String dataLeAk1977 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1977 = android.util.Log.d("leak-1977", dataLeAk1977);
		PointF currentTouchPos = new PointF(motionEvent.getX(), motionEvent.getY());
        if (cropRect == null) {
            String dataLeAk1978 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1978 = android.util.Log.d("leak-1978", dataLeAk1978);
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
            String dataLeAk1979 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1979 = android.util.Log.d("leak-1979", dataLeAk1979);
			return TOP_LEFT;
        }

        if (currentTouchPos.x > cropRect.right - touchDelta
                && currentTouchPos.x < cropRect.right + touchDelta
                && currentTouchPos.y > cropRect.top - touchDelta
                && currentTouchPos.y < cropRect.top + touchDelta) {
            String dataLeAk1980 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1980 = android.util.Log.d("leak-1980", dataLeAk1980);
			return TOP_RIGHT;
        }

        if (currentTouchPos.x > cropRect.right - touchDelta
                && currentTouchPos.x < cropRect.right + touchDelta
                && currentTouchPos.y > cropRect.bottom - touchDelta
                && currentTouchPos.y < cropRect.bottom + touchDelta) {
            String dataLeAk1981 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1981 = android.util.Log.d("leak-1981", dataLeAk1981);
			return BOTTOM_RIGHT;
        }

        if (currentTouchPos.x > cropRect.left - touchDelta
                && currentTouchPos.x < cropRect.left + touchDelta
                && currentTouchPos.y > cropRect.bottom - touchDelta
                && currentTouchPos.y < cropRect.bottom + touchDelta) {
            String dataLeAk1982 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1982 = android.util.Log.d("leak-1982", dataLeAk1982);
			return BOTTOM_LEFT;
        }

        return NO_CORNER;
    }

    private Rect getNewRect(MotionEvent motionEvent) {
        String dataLeAk1983 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1983 = android.util.Log.d("leak-1983", dataLeAk1983);
		PointF currentTouchPos = viewToSourceCoord(
                motionEvent.getX(), motionEvent.getY());

        if (touchedCorner == TOP_LEFT) {
            String dataLeAk1984 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1984 = android.util.Log.d("leak-1984", dataLeAk1984);
			Rect newCropRect = new Rect(
                    (int) currentTouchPos.x,
                    (int) currentTouchPos.y,
                    cropRect.right,
                    cropRect.bottom);
            return checkRectBounds(newCropRect, true);
        }

        if (touchedCorner == TOP_RIGHT) {
            String dataLeAk1985 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1985 = android.util.Log.d("leak-1985", dataLeAk1985);
			Rect newCropRect = new Rect(
                    cropRect.left,
                    (int) currentTouchPos.y,
                    (int) currentTouchPos.x,
                    cropRect.bottom);
            return checkRectBounds(newCropRect, true);
        }

        if (touchedCorner == BOTTOM_RIGHT) {
            String dataLeAk1986 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1986 = android.util.Log.d("leak-1986", dataLeAk1986);
			Rect newCropRect = new Rect(
                    cropRect.left,
                    cropRect.top,
                    (int) currentTouchPos.x,
                    (int) currentTouchPos.y);
            return checkRectBounds(newCropRect, true);
        }

        if (touchedCorner == BOTTOM_LEFT) {
            String dataLeAk1987 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1987 = android.util.Log.d("leak-1987", dataLeAk1987);
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
        String dataLeAk1988 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1988 = android.util.Log.d("leak-1988", dataLeAk1988);
		if (cropRect == null) {
            String dataLeAk1989 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1989 = android.util.Log.d("leak-1989", dataLeAk1989);
			return null;
        }

        PointF currentTouchPos = viewToSourceCoord(motionEvent.getX(),
                motionEvent.getY());

        int historySize = motionEvent.getHistorySize();
        if (historySize > 0) {
            String dataLeAk1990 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1990 = android.util.Log.d("leak-1990", dataLeAk1990);
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
            String dataLeAk1991 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1991 = android.util.Log.d("leak-1991", dataLeAk1991);
			return cropRect;
        }
    }

    private Rect checkRectBounds(Rect cropRect, boolean resize) {
        String dataLeAk1992 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1992 = android.util.Log.d("leak-1992", dataLeAk1992);
		Rect image = getImageRect();
        Rect newCropRect = cropRect;
        //check if inside image
        int width = newCropRect.width();
        int height = newCropRect.height();

        if (image.left > newCropRect.left) {
            String dataLeAk1993 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1993 = android.util.Log.d("leak-1993", dataLeAk1993);
			newCropRect = new Rect(image.left, newCropRect.top,
                    resize ? newCropRect.right : image.left + width,
                    newCropRect.bottom);
        }

        if (image.top > newCropRect.top) {
            String dataLeAk1994 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1994 = android.util.Log.d("leak-1994", dataLeAk1994);
			newCropRect = new Rect(
                    newCropRect.left, image.top, newCropRect.right,
                    resize ? newCropRect.bottom : image.top + height);
        }

        if (image.right < newCropRect.right) {
            String dataLeAk1995 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1995 = android.util.Log.d("leak-1995", dataLeAk1995);
			newCropRect = new Rect(
                    resize ? newCropRect.left : image.right - width,
                    newCropRect.top, image.right, newCropRect.bottom);
        }

        if (image.bottom < newCropRect.bottom) {
            String dataLeAk1996 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1996 = android.util.Log.d("leak-1996", dataLeAk1996);
			newCropRect = new Rect(newCropRect.left,
                    resize ? newCropRect.top : image.bottom - height,
                    newCropRect.right, image.bottom);
        }

        //check min size
        width = newCropRect.width();
        if (width < minCropRectSize) {
            String dataLeAk1997 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1997 = android.util.Log.d("leak-1997", dataLeAk1997);
			if (touchedCorner == TOP_LEFT) {
                String dataLeAk1998 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1998 = android.util.Log.d("leak-1998", dataLeAk1998);
				newCropRect = new Rect(newCropRect.right - minCropRectSize,
                        newCropRect.top, newCropRect.right, newCropRect.bottom);
            } else if (touchedCorner == TOP_RIGHT) {
                String dataLeAk1999 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1999 = android.util.Log.d("leak-1999", dataLeAk1999);
				newCropRect = new Rect(newCropRect.left, newCropRect.top,
                        newCropRect.left + minCropRectSize,
                        newCropRect.bottom);
            } else if (touchedCorner == BOTTOM_RIGHT) {
                String dataLeAk2000 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2000 = android.util.Log.d("leak-2000", dataLeAk2000);
				newCropRect = new Rect(newCropRect.left, newCropRect.top,
                        newCropRect.left + minCropRectSize,
                        newCropRect.bottom);
            } else if (touchedCorner == BOTTOM_LEFT) {
                String dataLeAk2001 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2001 = android.util.Log.d("leak-2001", dataLeAk2001);
				newCropRect = new Rect(newCropRect.right - minCropRectSize,
                        newCropRect.top, newCropRect.right, newCropRect.bottom);
            }
        }

        height = newCropRect.height();
        if (height < minCropRectSize) {
            String dataLeAk2002 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2002 = android.util.Log.d("leak-2002", dataLeAk2002);
			if (touchedCorner == TOP_LEFT) {
                String dataLeAk2003 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2003 = android.util.Log.d("leak-2003", dataLeAk2003);
				newCropRect = new Rect(newCropRect.left,
                        newCropRect.bottom - minCropRectSize,
                        newCropRect.right, newCropRect.bottom);
            } else if (touchedCorner == TOP_RIGHT) {
                String dataLeAk2004 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2004 = android.util.Log.d("leak-2004", dataLeAk2004);
				newCropRect = new Rect(newCropRect.left,
                        newCropRect.bottom - minCropRectSize,
                        newCropRect.right, newCropRect.bottom);
            } else if (touchedCorner == BOTTOM_RIGHT) {
                String dataLeAk2005 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2005 = android.util.Log.d("leak-2005", dataLeAk2005);
				newCropRect = new Rect(newCropRect.left, newCropRect.top,
                        newCropRect.right,
                        newCropRect.top + minCropRectSize);
            } else if (touchedCorner == BOTTOM_LEFT) {
                String dataLeAk2006 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2006 = android.util.Log.d("leak-2006", dataLeAk2006);
				newCropRect = new Rect(newCropRect.left,
                        newCropRect.top, newCropRect.right,
                        newCropRect.top + minCropRectSize);
            }
        }

        return newCropRect;
    }

    private Rect getImageRect() {
        String dataLeAk2007 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2007 = android.util.Log.d("leak-2007", dataLeAk2007);
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
        String dataLeAk2008 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2008 = android.util.Log.d("leak-2008", dataLeAk2008);
		Rect imageRect = getImageRect();
        int newWidth = cropRect.height();
        int newHeight = cropRect.width();
        Point newTopLeft = new Point(imageRect.height() - (cropRect.top + cropRect.height()), cropRect.left);
        return new Rect(newTopLeft.x, newTopLeft.y,
                newTopLeft.x + newWidth, newTopLeft.y + newHeight);
    }

    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        String dataLeAk2009 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2009 = android.util.Log.d("leak-2009", dataLeAk2009);
		//super.setPadding(left, top, right, bottom);
        padding = new int[]{left, top, right, bottom};
    }

    @Override
    protected void onDraw(Canvas canvas) {
        /*canvas.save();
        canvas.rotate(rotationAngle, canvas.getWidth() / 2, canvas.getHeight() / 2);*/
        super.onDraw(canvas);
        /*canvas.restore();*/
		String dataLeAk2010 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2010 = android.util.Log.d("leak-2010", dataLeAk2010);

        // Don't draw anything before image is ready.
        if (!isReady() || cropRect == null) {
            String dataLeAk2011 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2011 = android.util.Log.d("leak-2011", dataLeAk2011);
			return;
        }

        drawBackground(canvas);
        drawRect(canvas);
        drawCorners(canvas);
        if (touching) {
            String dataLeAk2012 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2012 = android.util.Log.d("leak-2012", dataLeAk2012);
			drawGuidelines(canvas);
        }
    }

    private void drawRect(Canvas canvas) {
        String dataLeAk2013 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2013 = android.util.Log.d("leak-2013", dataLeAk2013);
		PointF topLeft = sourceToViewCoord(cropRect.left, cropRect.top);
        PointF bottomRight = sourceToViewCoord(cropRect.right, cropRect.bottom);
        if (topLeft == null || bottomRight == null) {
            String dataLeAk2014 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2014 = android.util.Log.d("leak-2014", dataLeAk2014);
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
        String dataLeAk2015 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2015 = android.util.Log.d("leak-2015", dataLeAk2015);
		PointF topLeft = sourceToViewCoord(cropRect.left, cropRect.top);
        PointF bottomRight = sourceToViewCoord(cropRect.right, cropRect.bottom);
        if (topLeft == null || bottomRight == null) {
            String dataLeAk2016 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2016 = android.util.Log.d("leak-2016", dataLeAk2016);
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
        String dataLeAk2017 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2017 = android.util.Log.d("leak-2017", dataLeAk2017);
		Path corner = new Path();
        corner.moveTo(cornerStrokeWidth / 2, cornerLength - cornerStrokeWidth / 2);
        corner.lineTo(cornerStrokeWidth / 2, cornerStrokeWidth / 2);
        corner.lineTo(cornerLength - cornerStrokeWidth / 2, cornerStrokeWidth / 2);
        return corner;
    }

    private void drawBackground(Canvas canvas) {
        String dataLeAk2018 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2018 = android.util.Log.d("leak-2018", dataLeAk2018);
		Rect imageRect = getImageRect();
        PointF topLeftImageRect = sourceToViewCoord(imageRect.left, imageRect.top);
        PointF bottomRightImageRect = sourceToViewCoord(imageRect.left, imageRect.top);

        PointF topLeft = sourceToViewCoord(cropRect.left, cropRect.top);
        PointF bottomRight = sourceToViewCoord(cropRect.right, cropRect.bottom);
        if (topLeftImageRect == null || bottomRightImageRect == null ||
                topLeft == null || bottomRight == null) {
            String dataLeAk2019 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2019 = android.util.Log.d("leak-2019", dataLeAk2019);
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
        String dataLeAk2020 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2020 = android.util.Log.d("leak-2020", dataLeAk2020);
		PointF topLeft = sourceToViewCoord(cropRect.left, cropRect.top);
        PointF bottomRight = sourceToViewCoord(cropRect.right, cropRect.bottom);
        if (topLeft == null || bottomRight == null) {
            String dataLeAk2021 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2021 = android.util.Log.d("leak-2021", dataLeAk2021);
			return;
        }

        float width = bottomRight.x - topLeft.x;
        float height = bottomRight.y - topLeft.y;
        float thirdWidth = width / 3;
        float thirdHeight = height / 3;

        for (int i = 1; i <= 2; i++) {
            String dataLeAk2022 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2022 = android.util.Log.d("leak-2022", dataLeAk2022);
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
        String dataLeAk2023 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2023 = android.util.Log.d("leak-2023", dataLeAk2023);
		ImageViewState state = getState();
        if (state != null) {
            String dataLeAk2024 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2024 = android.util.Log.d("leak-2024", dataLeAk2024);
			return new State(state.getScale(), state.getCenter(), state.getOrientation(), cropRect);
        }
        return null;
    }

    private ProgressBar getProgressBar() {
        String dataLeAk2025 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2025 = android.util.Log.d("leak-2025", dataLeAk2025);
		ViewGroup parent = (ViewGroup) getParent();
        return parent.findViewById(R.id.progress_bar);
    }

    private void setProgressBarVisibility(int visibility) {
        String dataLeAk2026 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2026 = android.util.Log.d("leak-2026", dataLeAk2026);
		ProgressBar progressBar = getProgressBar();
        if (progressBar != null) {
            String dataLeAk2027 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2027 = android.util.Log.d("leak-2027", dataLeAk2027);
			progressBar.setVisibility(visibility);
        }
    }
}
