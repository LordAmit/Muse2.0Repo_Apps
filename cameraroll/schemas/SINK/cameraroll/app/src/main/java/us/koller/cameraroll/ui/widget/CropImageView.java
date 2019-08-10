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

    final String dataLeAk1027 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1025 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1023 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1022 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk1020 = "";

	String dataLeAk1019 = "";

	String dataLeAk1018 = "";

	String dataLeAk1017 = "";

	String dataLeAk1016 = "";

	String dataLeAk1015 = "";

	String dataLeAk1014 = "";

	String dataLeAk1013 = "";

	String dataLeAk1012 = "";

	String dataLeAk1011 = "";

	String dataLeAk1010 = "";

	String dataLeAk1009 = "";

	String dataLeAk1008 = "";

	String dataLeAk1007 = "";

	String dataLeAk1006 = "";

	String dataLeAk1005 = "";

	String dataLeAk1004 = "";

	String dataLeAk1003 = "";

	String dataLeAk1002 = "";

	String dataLeAk1001 = "";

	String dataLeAk997 = "";

	String dataLeAk996 = "";

	String dataLeAk994 = "";

	String dataLeAk993 = "";

	String dataLeAk992 = "";

	String dataLeAk991 = "";

	String dataLeAk990 = "";

	String dataLeAk989 = "";

	String dataLeAk988 = "";

	String dataLeAk985 = "";

	String dataLeAk983 = "";

	String dataLeAk981 = "";

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

        String dataLeAk984 = "";

		String dataLeAk982 = "";

		String dataLeAk980 = "";

		private Uri uri;
        private Bitmap bitmap;

        Result(Uri uri, Bitmap bitmap) {
            dataLeAk981 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk980 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-981-0", dataLeAk981);
			android.util.Log.d("leak-983-0", dataLeAk983);
			android.util.Log.d("leak-985-0", dataLeAk985);
			android.util.Log.d("leak-988-0", dataLeAk988);
			android.util.Log.d("leak-989-0", dataLeAk989);
			android.util.Log.d("leak-990-0", dataLeAk990);
			android.util.Log.d("leak-991-0", dataLeAk991);
			android.util.Log.d("leak-992-0", dataLeAk992);
			android.util.Log.d("leak-993-0", dataLeAk993);
			android.util.Log.d("leak-994-0", dataLeAk994);
			android.util.Log.d("leak-996-0", dataLeAk996);
			android.util.Log.d("leak-997-0", dataLeAk997);
			android.util.Log.d("leak-1001-0", dataLeAk1001);
			android.util.Log.d("leak-1002-0", dataLeAk1002);
			android.util.Log.d("leak-1003-0", dataLeAk1003);
			android.util.Log.d("leak-1004-0", dataLeAk1004);
			android.util.Log.d("leak-1005-0", dataLeAk1005);
			android.util.Log.d("leak-1006-0", dataLeAk1006);
			android.util.Log.d("leak-1007-0", dataLeAk1007);
			android.util.Log.d("leak-1008-0", dataLeAk1008);
			android.util.Log.d("leak-1009-0", dataLeAk1009);
			android.util.Log.d("leak-1010-0", dataLeAk1010);
			android.util.Log.d("leak-1011-0", dataLeAk1011);
			android.util.Log.d("leak-1012-0", dataLeAk1012);
			android.util.Log.d("leak-1013-0", dataLeAk1013);
			android.util.Log.d("leak-1014-0", dataLeAk1014);
			android.util.Log.d("leak-1015-0", dataLeAk1015);
			android.util.Log.d("leak-1016-0", dataLeAk1016);
			android.util.Log.d("leak-1017-0", dataLeAk1017);
			android.util.Log.d("leak-1018-0", dataLeAk1018);
			android.util.Log.d("leak-1019-0", dataLeAk1019);
			android.util.Log.d("leak-1020-0", dataLeAk1020);
			android.util.Log.d("leak-980-0", dataLeAk980);
			android.util.Log.d("leak-982-0", dataLeAk982);
			android.util.Log.d("leak-984-0", dataLeAk984);
			this.uri = uri;
            this.bitmap = bitmap;
        }

        public Uri getImageUri() {
            dataLeAk983 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk982 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-981-1", dataLeAk981);
			android.util.Log.d("leak-983-1", dataLeAk983);
			android.util.Log.d("leak-985-1", dataLeAk985);
			android.util.Log.d("leak-988-1", dataLeAk988);
			android.util.Log.d("leak-989-1", dataLeAk989);
			android.util.Log.d("leak-990-1", dataLeAk990);
			android.util.Log.d("leak-991-1", dataLeAk991);
			android.util.Log.d("leak-992-1", dataLeAk992);
			android.util.Log.d("leak-993-1", dataLeAk993);
			android.util.Log.d("leak-994-1", dataLeAk994);
			android.util.Log.d("leak-996-1", dataLeAk996);
			android.util.Log.d("leak-997-1", dataLeAk997);
			android.util.Log.d("leak-1001-1", dataLeAk1001);
			android.util.Log.d("leak-1002-1", dataLeAk1002);
			android.util.Log.d("leak-1003-1", dataLeAk1003);
			android.util.Log.d("leak-1004-1", dataLeAk1004);
			android.util.Log.d("leak-1005-1", dataLeAk1005);
			android.util.Log.d("leak-1006-1", dataLeAk1006);
			android.util.Log.d("leak-1007-1", dataLeAk1007);
			android.util.Log.d("leak-1008-1", dataLeAk1008);
			android.util.Log.d("leak-1009-1", dataLeAk1009);
			android.util.Log.d("leak-1010-1", dataLeAk1010);
			android.util.Log.d("leak-1011-1", dataLeAk1011);
			android.util.Log.d("leak-1012-1", dataLeAk1012);
			android.util.Log.d("leak-1013-1", dataLeAk1013);
			android.util.Log.d("leak-1014-1", dataLeAk1014);
			android.util.Log.d("leak-1015-1", dataLeAk1015);
			android.util.Log.d("leak-1016-1", dataLeAk1016);
			android.util.Log.d("leak-1017-1", dataLeAk1017);
			android.util.Log.d("leak-1018-1", dataLeAk1018);
			android.util.Log.d("leak-1019-1", dataLeAk1019);
			android.util.Log.d("leak-1020-1", dataLeAk1020);
			android.util.Log.d("leak-980-1", dataLeAk980);
			android.util.Log.d("leak-982-1", dataLeAk982);
			android.util.Log.d("leak-984-1", dataLeAk984);
			return uri;
        }

        public Bitmap getCroppedBitmap() {
            dataLeAk985 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk984 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-981-2", dataLeAk981);
			android.util.Log.d("leak-983-2", dataLeAk983);
			android.util.Log.d("leak-985-2", dataLeAk985);
			android.util.Log.d("leak-988-2", dataLeAk988);
			android.util.Log.d("leak-989-2", dataLeAk989);
			android.util.Log.d("leak-990-2", dataLeAk990);
			android.util.Log.d("leak-991-2", dataLeAk991);
			android.util.Log.d("leak-992-2", dataLeAk992);
			android.util.Log.d("leak-993-2", dataLeAk993);
			android.util.Log.d("leak-994-2", dataLeAk994);
			android.util.Log.d("leak-996-2", dataLeAk996);
			android.util.Log.d("leak-997-2", dataLeAk997);
			android.util.Log.d("leak-1001-2", dataLeAk1001);
			android.util.Log.d("leak-1002-2", dataLeAk1002);
			android.util.Log.d("leak-1003-2", dataLeAk1003);
			android.util.Log.d("leak-1004-2", dataLeAk1004);
			android.util.Log.d("leak-1005-2", dataLeAk1005);
			android.util.Log.d("leak-1006-2", dataLeAk1006);
			android.util.Log.d("leak-1007-2", dataLeAk1007);
			android.util.Log.d("leak-1008-2", dataLeAk1008);
			android.util.Log.d("leak-1009-2", dataLeAk1009);
			android.util.Log.d("leak-1010-2", dataLeAk1010);
			android.util.Log.d("leak-1011-2", dataLeAk1011);
			android.util.Log.d("leak-1012-2", dataLeAk1012);
			android.util.Log.d("leak-1013-2", dataLeAk1013);
			android.util.Log.d("leak-1014-2", dataLeAk1014);
			android.util.Log.d("leak-1015-2", dataLeAk1015);
			android.util.Log.d("leak-1016-2", dataLeAk1016);
			android.util.Log.d("leak-1017-2", dataLeAk1017);
			android.util.Log.d("leak-1018-2", dataLeAk1018);
			android.util.Log.d("leak-1019-2", dataLeAk1019);
			android.util.Log.d("leak-1020-2", dataLeAk1020);
			android.util.Log.d("leak-980-2", dataLeAk980);
			android.util.Log.d("leak-982-2", dataLeAk982);
			android.util.Log.d("leak-984-2", dataLeAk984);
			return bitmap;
        }
    }

    public static class State extends ImageViewState {

        String dataLeAk987 = "";

		String dataLeAk986 = "";

		private int[] cropRect;

        State(float scale, PointF center, int orientation, Rect cropRect) {
            super(scale, center, orientation);
			dataLeAk986 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-986-0", dataLeAk986);
			android.util.Log.d("leak-987-0", dataLeAk987);
            this.cropRect = new int[]{
                    cropRect.left, cropRect.top,
                    cropRect.right, cropRect.bottom};
        }

        Rect getCropRect() {
            dataLeAk987 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-986-1", dataLeAk986);
			android.util.Log.d("leak-987-1", dataLeAk987);
			return new Rect(
                    cropRect[0], cropRect[1],
                    cropRect[2], cropRect[3]);
        }
    }

    public CropImageView(Context context, AttributeSet attr) {
        super(context, attr);
		dataLeAk988 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-981-3", dataLeAk981);
		android.util.Log.d("leak-983-3", dataLeAk983);
		android.util.Log.d("leak-985-3", dataLeAk985);
		android.util.Log.d("leak-988-3", dataLeAk988);
		android.util.Log.d("leak-989-3", dataLeAk989);
		android.util.Log.d("leak-990-3", dataLeAk990);
		android.util.Log.d("leak-991-3", dataLeAk991);
		android.util.Log.d("leak-992-3", dataLeAk992);
		android.util.Log.d("leak-993-3", dataLeAk993);
		android.util.Log.d("leak-994-3", dataLeAk994);
		android.util.Log.d("leak-996-3", dataLeAk996);
		android.util.Log.d("leak-997-3", dataLeAk997);
		android.util.Log.d("leak-1001-3", dataLeAk1001);
		android.util.Log.d("leak-1002-3", dataLeAk1002);
		android.util.Log.d("leak-1003-3", dataLeAk1003);
		android.util.Log.d("leak-1004-3", dataLeAk1004);
		android.util.Log.d("leak-1005-3", dataLeAk1005);
		android.util.Log.d("leak-1006-3", dataLeAk1006);
		android.util.Log.d("leak-1007-3", dataLeAk1007);
		android.util.Log.d("leak-1008-3", dataLeAk1008);
		android.util.Log.d("leak-1009-3", dataLeAk1009);
		android.util.Log.d("leak-1010-3", dataLeAk1010);
		android.util.Log.d("leak-1011-3", dataLeAk1011);
		android.util.Log.d("leak-1012-3", dataLeAk1012);
		android.util.Log.d("leak-1013-3", dataLeAk1013);
		android.util.Log.d("leak-1014-3", dataLeAk1014);
		android.util.Log.d("leak-1015-3", dataLeAk1015);
		android.util.Log.d("leak-1016-3", dataLeAk1016);
		android.util.Log.d("leak-1017-3", dataLeAk1017);
		android.util.Log.d("leak-1018-3", dataLeAk1018);
		android.util.Log.d("leak-1019-3", dataLeAk1019);
		android.util.Log.d("leak-1020-3", dataLeAk1020);
        init();
    }

    public CropImageView(Context context) {
        this(context, null);
		dataLeAk989 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-981-4", dataLeAk981);
		android.util.Log.d("leak-983-4", dataLeAk983);
		android.util.Log.d("leak-985-4", dataLeAk985);
		android.util.Log.d("leak-988-4", dataLeAk988);
		android.util.Log.d("leak-989-4", dataLeAk989);
		android.util.Log.d("leak-990-4", dataLeAk990);
		android.util.Log.d("leak-991-4", dataLeAk991);
		android.util.Log.d("leak-992-4", dataLeAk992);
		android.util.Log.d("leak-993-4", dataLeAk993);
		android.util.Log.d("leak-994-4", dataLeAk994);
		android.util.Log.d("leak-996-4", dataLeAk996);
		android.util.Log.d("leak-997-4", dataLeAk997);
		android.util.Log.d("leak-1001-4", dataLeAk1001);
		android.util.Log.d("leak-1002-4", dataLeAk1002);
		android.util.Log.d("leak-1003-4", dataLeAk1003);
		android.util.Log.d("leak-1004-4", dataLeAk1004);
		android.util.Log.d("leak-1005-4", dataLeAk1005);
		android.util.Log.d("leak-1006-4", dataLeAk1006);
		android.util.Log.d("leak-1007-4", dataLeAk1007);
		android.util.Log.d("leak-1008-4", dataLeAk1008);
		android.util.Log.d("leak-1009-4", dataLeAk1009);
		android.util.Log.d("leak-1010-4", dataLeAk1010);
		android.util.Log.d("leak-1011-4", dataLeAk1011);
		android.util.Log.d("leak-1012-4", dataLeAk1012);
		android.util.Log.d("leak-1013-4", dataLeAk1013);
		android.util.Log.d("leak-1014-4", dataLeAk1014);
		android.util.Log.d("leak-1015-4", dataLeAk1015);
		android.util.Log.d("leak-1016-4", dataLeAk1016);
		android.util.Log.d("leak-1017-4", dataLeAk1017);
		android.util.Log.d("leak-1018-4", dataLeAk1018);
		android.util.Log.d("leak-1019-4", dataLeAk1019);
		android.util.Log.d("leak-1020-4", dataLeAk1020);
    }

    private void init() {
        dataLeAk990 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-981-5", dataLeAk981);
		android.util.Log.d("leak-983-5", dataLeAk983);
		android.util.Log.d("leak-985-5", dataLeAk985);
		android.util.Log.d("leak-988-5", dataLeAk988);
		android.util.Log.d("leak-989-5", dataLeAk989);
		android.util.Log.d("leak-990-5", dataLeAk990);
		android.util.Log.d("leak-991-5", dataLeAk991);
		android.util.Log.d("leak-992-5", dataLeAk992);
		android.util.Log.d("leak-993-5", dataLeAk993);
		android.util.Log.d("leak-994-5", dataLeAk994);
		android.util.Log.d("leak-996-5", dataLeAk996);
		android.util.Log.d("leak-997-5", dataLeAk997);
		android.util.Log.d("leak-1001-5", dataLeAk1001);
		android.util.Log.d("leak-1002-5", dataLeAk1002);
		android.util.Log.d("leak-1003-5", dataLeAk1003);
		android.util.Log.d("leak-1004-5", dataLeAk1004);
		android.util.Log.d("leak-1005-5", dataLeAk1005);
		android.util.Log.d("leak-1006-5", dataLeAk1006);
		android.util.Log.d("leak-1007-5", dataLeAk1007);
		android.util.Log.d("leak-1008-5", dataLeAk1008);
		android.util.Log.d("leak-1009-5", dataLeAk1009);
		android.util.Log.d("leak-1010-5", dataLeAk1010);
		android.util.Log.d("leak-1011-5", dataLeAk1011);
		android.util.Log.d("leak-1012-5", dataLeAk1012);
		android.util.Log.d("leak-1013-5", dataLeAk1013);
		android.util.Log.d("leak-1014-5", dataLeAk1014);
		android.util.Log.d("leak-1015-5", dataLeAk1015);
		android.util.Log.d("leak-1016-5", dataLeAk1016);
		android.util.Log.d("leak-1017-5", dataLeAk1017);
		android.util.Log.d("leak-1018-5", dataLeAk1018);
		android.util.Log.d("leak-1019-5", dataLeAk1019);
		android.util.Log.d("leak-1020-5", dataLeAk1020);
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
        dataLeAk991 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-981-6", dataLeAk981);
		android.util.Log.d("leak-983-6", dataLeAk983);
		android.util.Log.d("leak-985-6", dataLeAk985);
		android.util.Log.d("leak-988-6", dataLeAk988);
		android.util.Log.d("leak-989-6", dataLeAk989);
		android.util.Log.d("leak-990-6", dataLeAk990);
		android.util.Log.d("leak-991-6", dataLeAk991);
		android.util.Log.d("leak-992-6", dataLeAk992);
		android.util.Log.d("leak-993-6", dataLeAk993);
		android.util.Log.d("leak-994-6", dataLeAk994);
		android.util.Log.d("leak-996-6", dataLeAk996);
		android.util.Log.d("leak-997-6", dataLeAk997);
		android.util.Log.d("leak-1001-6", dataLeAk1001);
		android.util.Log.d("leak-1002-6", dataLeAk1002);
		android.util.Log.d("leak-1003-6", dataLeAk1003);
		android.util.Log.d("leak-1004-6", dataLeAk1004);
		android.util.Log.d("leak-1005-6", dataLeAk1005);
		android.util.Log.d("leak-1006-6", dataLeAk1006);
		android.util.Log.d("leak-1007-6", dataLeAk1007);
		android.util.Log.d("leak-1008-6", dataLeAk1008);
		android.util.Log.d("leak-1009-6", dataLeAk1009);
		android.util.Log.d("leak-1010-6", dataLeAk1010);
		android.util.Log.d("leak-1011-6", dataLeAk1011);
		android.util.Log.d("leak-1012-6", dataLeAk1012);
		android.util.Log.d("leak-1013-6", dataLeAk1013);
		android.util.Log.d("leak-1014-6", dataLeAk1014);
		android.util.Log.d("leak-1015-6", dataLeAk1015);
		android.util.Log.d("leak-1016-6", dataLeAk1016);
		android.util.Log.d("leak-1017-6", dataLeAk1017);
		android.util.Log.d("leak-1018-6", dataLeAk1018);
		android.util.Log.d("leak-1019-6", dataLeAk1019);
		android.util.Log.d("leak-1020-6", dataLeAk1020);
		setProgressBarVisibility(VISIBLE);

        imageUri = uri;

        String mimeType = MediaType.getMimeType(getContext(), imageUri);
        if (MediaType.checkRAWMimeType(mimeType)) {
            setRegionDecoderClass(RAWImageBitmapRegionDecoder.class);
        } else {
            setRegionDecoderClass(CustomRegionDecoder.class);
        }

        if (state != null) {
            cropRect = state.getCropRect();
        }
        setImage(ImageSource.uri(uri)/*.tilingDisabled()*/, state);
    }

    public Uri getImageUri() {
        dataLeAk992 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-981-7", dataLeAk981);
		android.util.Log.d("leak-983-7", dataLeAk983);
		android.util.Log.d("leak-985-7", dataLeAk985);
		android.util.Log.d("leak-988-7", dataLeAk988);
		android.util.Log.d("leak-989-7", dataLeAk989);
		android.util.Log.d("leak-990-7", dataLeAk990);
		android.util.Log.d("leak-991-7", dataLeAk991);
		android.util.Log.d("leak-992-7", dataLeAk992);
		android.util.Log.d("leak-993-7", dataLeAk993);
		android.util.Log.d("leak-994-7", dataLeAk994);
		android.util.Log.d("leak-996-7", dataLeAk996);
		android.util.Log.d("leak-997-7", dataLeAk997);
		android.util.Log.d("leak-1001-7", dataLeAk1001);
		android.util.Log.d("leak-1002-7", dataLeAk1002);
		android.util.Log.d("leak-1003-7", dataLeAk1003);
		android.util.Log.d("leak-1004-7", dataLeAk1004);
		android.util.Log.d("leak-1005-7", dataLeAk1005);
		android.util.Log.d("leak-1006-7", dataLeAk1006);
		android.util.Log.d("leak-1007-7", dataLeAk1007);
		android.util.Log.d("leak-1008-7", dataLeAk1008);
		android.util.Log.d("leak-1009-7", dataLeAk1009);
		android.util.Log.d("leak-1010-7", dataLeAk1010);
		android.util.Log.d("leak-1011-7", dataLeAk1011);
		android.util.Log.d("leak-1012-7", dataLeAk1012);
		android.util.Log.d("leak-1013-7", dataLeAk1013);
		android.util.Log.d("leak-1014-7", dataLeAk1014);
		android.util.Log.d("leak-1015-7", dataLeAk1015);
		android.util.Log.d("leak-1016-7", dataLeAk1016);
		android.util.Log.d("leak-1017-7", dataLeAk1017);
		android.util.Log.d("leak-1018-7", dataLeAk1018);
		android.util.Log.d("leak-1019-7", dataLeAk1019);
		android.util.Log.d("leak-1020-7", dataLeAk1020);
		return imageUri;
    }

    @Override
    protected void onImageLoaded() {
        super.onImageLoaded();
		dataLeAk993 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-981-8", dataLeAk981);
		android.util.Log.d("leak-983-8", dataLeAk983);
		android.util.Log.d("leak-985-8", dataLeAk985);
		android.util.Log.d("leak-988-8", dataLeAk988);
		android.util.Log.d("leak-989-8", dataLeAk989);
		android.util.Log.d("leak-990-8", dataLeAk990);
		android.util.Log.d("leak-991-8", dataLeAk991);
		android.util.Log.d("leak-992-8", dataLeAk992);
		android.util.Log.d("leak-993-8", dataLeAk993);
		android.util.Log.d("leak-994-8", dataLeAk994);
		android.util.Log.d("leak-996-8", dataLeAk996);
		android.util.Log.d("leak-997-8", dataLeAk997);
		android.util.Log.d("leak-1001-8", dataLeAk1001);
		android.util.Log.d("leak-1002-8", dataLeAk1002);
		android.util.Log.d("leak-1003-8", dataLeAk1003);
		android.util.Log.d("leak-1004-8", dataLeAk1004);
		android.util.Log.d("leak-1005-8", dataLeAk1005);
		android.util.Log.d("leak-1006-8", dataLeAk1006);
		android.util.Log.d("leak-1007-8", dataLeAk1007);
		android.util.Log.d("leak-1008-8", dataLeAk1008);
		android.util.Log.d("leak-1009-8", dataLeAk1009);
		android.util.Log.d("leak-1010-8", dataLeAk1010);
		android.util.Log.d("leak-1011-8", dataLeAk1011);
		android.util.Log.d("leak-1012-8", dataLeAk1012);
		android.util.Log.d("leak-1013-8", dataLeAk1013);
		android.util.Log.d("leak-1014-8", dataLeAk1014);
		android.util.Log.d("leak-1015-8", dataLeAk1015);
		android.util.Log.d("leak-1016-8", dataLeAk1016);
		android.util.Log.d("leak-1017-8", dataLeAk1017);
		android.util.Log.d("leak-1018-8", dataLeAk1018);
		android.util.Log.d("leak-1019-8", dataLeAk1019);
		android.util.Log.d("leak-1020-8", dataLeAk1020);
        if (cropRect == null) {
            cropRect = getImageRect();
        } else {
            autoZoom(true);
        }

        setProgressBarVisibility(GONE);
    }

    public void rotate90Degree() {
        dataLeAk994 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-981-9", dataLeAk981);
		android.util.Log.d("leak-983-9", dataLeAk983);
		android.util.Log.d("leak-985-9", dataLeAk985);
		android.util.Log.d("leak-988-9", dataLeAk988);
		android.util.Log.d("leak-989-9", dataLeAk989);
		android.util.Log.d("leak-990-9", dataLeAk990);
		android.util.Log.d("leak-991-9", dataLeAk991);
		android.util.Log.d("leak-992-9", dataLeAk992);
		android.util.Log.d("leak-993-9", dataLeAk993);
		android.util.Log.d("leak-994-9", dataLeAk994);
		android.util.Log.d("leak-996-9", dataLeAk996);
		android.util.Log.d("leak-997-9", dataLeAk997);
		android.util.Log.d("leak-1001-9", dataLeAk1001);
		android.util.Log.d("leak-1002-9", dataLeAk1002);
		android.util.Log.d("leak-1003-9", dataLeAk1003);
		android.util.Log.d("leak-1004-9", dataLeAk1004);
		android.util.Log.d("leak-1005-9", dataLeAk1005);
		android.util.Log.d("leak-1006-9", dataLeAk1006);
		android.util.Log.d("leak-1007-9", dataLeAk1007);
		android.util.Log.d("leak-1008-9", dataLeAk1008);
		android.util.Log.d("leak-1009-9", dataLeAk1009);
		android.util.Log.d("leak-1010-9", dataLeAk1010);
		android.util.Log.d("leak-1011-9", dataLeAk1011);
		android.util.Log.d("leak-1012-9", dataLeAk1012);
		android.util.Log.d("leak-1013-9", dataLeAk1013);
		android.util.Log.d("leak-1014-9", dataLeAk1014);
		android.util.Log.d("leak-1015-9", dataLeAk1015);
		android.util.Log.d("leak-1016-9", dataLeAk1016);
		android.util.Log.d("leak-1017-9", dataLeAk1017);
		android.util.Log.d("leak-1018-9", dataLeAk1018);
		android.util.Log.d("leak-1019-9", dataLeAk1019);
		android.util.Log.d("leak-1020-9", dataLeAk1020);
		cropRect = rotateRect90Degree(cropRect);
        int orientation = getOrientation() + 90;
        if (orientation >= 360) {
            orientation = orientation % 360;
        }
        setOrientation(orientation);
        post(new Runnable() {
            String dataLeAk995 = "";

			@Override
            public void run() {
                dataLeAk995 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1022-0", dataLeAk1022);
				android.util.Log.d("leak-995-0", dataLeAk995);
				autoZoom(false);
            }
        });
    }

    /*public void setRotationAngle(int rotationAngle) {
        this.rotationAngle = rotationAngle;
        invalidate();
    }*/

    public void restore() {
        dataLeAk996 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-981-10", dataLeAk981);
		android.util.Log.d("leak-983-10", dataLeAk983);
		android.util.Log.d("leak-985-10", dataLeAk985);
		android.util.Log.d("leak-988-10", dataLeAk988);
		android.util.Log.d("leak-989-10", dataLeAk989);
		android.util.Log.d("leak-990-10", dataLeAk990);
		android.util.Log.d("leak-991-10", dataLeAk991);
		android.util.Log.d("leak-992-10", dataLeAk992);
		android.util.Log.d("leak-993-10", dataLeAk993);
		android.util.Log.d("leak-994-10", dataLeAk994);
		android.util.Log.d("leak-996-10", dataLeAk996);
		android.util.Log.d("leak-997-10", dataLeAk997);
		android.util.Log.d("leak-1001-10", dataLeAk1001);
		android.util.Log.d("leak-1002-10", dataLeAk1002);
		android.util.Log.d("leak-1003-10", dataLeAk1003);
		android.util.Log.d("leak-1004-10", dataLeAk1004);
		android.util.Log.d("leak-1005-10", dataLeAk1005);
		android.util.Log.d("leak-1006-10", dataLeAk1006);
		android.util.Log.d("leak-1007-10", dataLeAk1007);
		android.util.Log.d("leak-1008-10", dataLeAk1008);
		android.util.Log.d("leak-1009-10", dataLeAk1009);
		android.util.Log.d("leak-1010-10", dataLeAk1010);
		android.util.Log.d("leak-1011-10", dataLeAk1011);
		android.util.Log.d("leak-1012-10", dataLeAk1012);
		android.util.Log.d("leak-1013-10", dataLeAk1013);
		android.util.Log.d("leak-1014-10", dataLeAk1014);
		android.util.Log.d("leak-1015-10", dataLeAk1015);
		android.util.Log.d("leak-1016-10", dataLeAk1016);
		android.util.Log.d("leak-1017-10", dataLeAk1017);
		android.util.Log.d("leak-1018-10", dataLeAk1018);
		android.util.Log.d("leak-1019-10", dataLeAk1019);
		android.util.Log.d("leak-1020-10", dataLeAk1020);
		setOrientation(0);
        cropRect = getImageRect();
        //rotationAngle = 0;
    }

    public void getCroppedBitmap(final OnResultListener onResultListener) {
        dataLeAk997 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-981-11", dataLeAk981);
		android.util.Log.d("leak-983-11", dataLeAk983);
		android.util.Log.d("leak-985-11", dataLeAk985);
		android.util.Log.d("leak-988-11", dataLeAk988);
		android.util.Log.d("leak-989-11", dataLeAk989);
		android.util.Log.d("leak-990-11", dataLeAk990);
		android.util.Log.d("leak-991-11", dataLeAk991);
		android.util.Log.d("leak-992-11", dataLeAk992);
		android.util.Log.d("leak-993-11", dataLeAk993);
		android.util.Log.d("leak-994-11", dataLeAk994);
		android.util.Log.d("leak-996-11", dataLeAk996);
		android.util.Log.d("leak-997-11", dataLeAk997);
		android.util.Log.d("leak-1001-11", dataLeAk1001);
		android.util.Log.d("leak-1002-11", dataLeAk1002);
		android.util.Log.d("leak-1003-11", dataLeAk1003);
		android.util.Log.d("leak-1004-11", dataLeAk1004);
		android.util.Log.d("leak-1005-11", dataLeAk1005);
		android.util.Log.d("leak-1006-11", dataLeAk1006);
		android.util.Log.d("leak-1007-11", dataLeAk1007);
		android.util.Log.d("leak-1008-11", dataLeAk1008);
		android.util.Log.d("leak-1009-11", dataLeAk1009);
		android.util.Log.d("leak-1010-11", dataLeAk1010);
		android.util.Log.d("leak-1011-11", dataLeAk1011);
		android.util.Log.d("leak-1012-11", dataLeAk1012);
		android.util.Log.d("leak-1013-11", dataLeAk1013);
		android.util.Log.d("leak-1014-11", dataLeAk1014);
		android.util.Log.d("leak-1015-11", dataLeAk1015);
		android.util.Log.d("leak-1016-11", dataLeAk1016);
		android.util.Log.d("leak-1017-11", dataLeAk1017);
		android.util.Log.d("leak-1018-11", dataLeAk1018);
		android.util.Log.d("leak-1019-11", dataLeAk1019);
		android.util.Log.d("leak-1020-11", dataLeAk1020);
		setProgressBarVisibility(VISIBLE);
        AsyncTask.execute(new Runnable() {
            final String dataLeAk1026 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			final String dataLeAk1024 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			String dataLeAk998 = "";

			@Override
            public void run() {
                dataLeAk998 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1023-0", dataLeAk1023);
				android.util.Log.d("leak-998-0", dataLeAk998);
				try {
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
                        String dataLeAk999 = "";

						@Override
                        public void run() {
                            dataLeAk999 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-1025-0", dataLeAk1025);
							android.util.Log.d("leak-1024-0", dataLeAk1024);
							android.util.Log.d("leak-999-0", dataLeAk999);
							onResultListener.onResult(result);
                            setProgressBarVisibility(GONE);
                        }
                    });
                } catch (Exception | OutOfMemoryError e) {
                    e.printStackTrace();
                    CropImageView.this.post(new Runnable() {
                        String dataLeAk1000 = "";

						@Override
                        public void run() {
                            dataLeAk1000 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-1027-0", dataLeAk1027);
							android.util.Log.d("leak-1026-0", dataLeAk1026);
							android.util.Log.d("leak-1000-0", dataLeAk1000);
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
        dataLeAk1001 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-981-12", dataLeAk981);
		android.util.Log.d("leak-983-12", dataLeAk983);
		android.util.Log.d("leak-985-12", dataLeAk985);
		android.util.Log.d("leak-988-12", dataLeAk988);
		android.util.Log.d("leak-989-12", dataLeAk989);
		android.util.Log.d("leak-990-12", dataLeAk990);
		android.util.Log.d("leak-991-12", dataLeAk991);
		android.util.Log.d("leak-992-12", dataLeAk992);
		android.util.Log.d("leak-993-12", dataLeAk993);
		android.util.Log.d("leak-994-12", dataLeAk994);
		android.util.Log.d("leak-996-12", dataLeAk996);
		android.util.Log.d("leak-997-12", dataLeAk997);
		android.util.Log.d("leak-1001-12", dataLeAk1001);
		android.util.Log.d("leak-1002-12", dataLeAk1002);
		android.util.Log.d("leak-1003-12", dataLeAk1003);
		android.util.Log.d("leak-1004-12", dataLeAk1004);
		android.util.Log.d("leak-1005-12", dataLeAk1005);
		android.util.Log.d("leak-1006-12", dataLeAk1006);
		android.util.Log.d("leak-1007-12", dataLeAk1007);
		android.util.Log.d("leak-1008-12", dataLeAk1008);
		android.util.Log.d("leak-1009-12", dataLeAk1009);
		android.util.Log.d("leak-1010-12", dataLeAk1010);
		android.util.Log.d("leak-1011-12", dataLeAk1011);
		android.util.Log.d("leak-1012-12", dataLeAk1012);
		android.util.Log.d("leak-1013-12", dataLeAk1013);
		android.util.Log.d("leak-1014-12", dataLeAk1014);
		android.util.Log.d("leak-1015-12", dataLeAk1015);
		android.util.Log.d("leak-1016-12", dataLeAk1016);
		android.util.Log.d("leak-1017-12", dataLeAk1017);
		android.util.Log.d("leak-1018-12", dataLeAk1018);
		android.util.Log.d("leak-1019-12", dataLeAk1019);
		android.util.Log.d("leak-1020-12", dataLeAk1020);
		boolean consumed = false;
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                touchedCorner = getTouchedCorner(motionEvent);
                touching = true;
                consumed = true;
                break;
            case MotionEvent.ACTION_MOVE:
                if (touchedCorner != NO_CORNER) {
                    cropRect = getNewRect(motionEvent);
                    consumed = true;
                } else {
                    cropRect = getMovedRect(motionEvent);
                    consumed = true;
                }

                if (cropRect != null) {
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
        dataLeAk1002 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-981-13", dataLeAk981);
		android.util.Log.d("leak-983-13", dataLeAk983);
		android.util.Log.d("leak-985-13", dataLeAk985);
		android.util.Log.d("leak-988-13", dataLeAk988);
		android.util.Log.d("leak-989-13", dataLeAk989);
		android.util.Log.d("leak-990-13", dataLeAk990);
		android.util.Log.d("leak-991-13", dataLeAk991);
		android.util.Log.d("leak-992-13", dataLeAk992);
		android.util.Log.d("leak-993-13", dataLeAk993);
		android.util.Log.d("leak-994-13", dataLeAk994);
		android.util.Log.d("leak-996-13", dataLeAk996);
		android.util.Log.d("leak-997-13", dataLeAk997);
		android.util.Log.d("leak-1001-13", dataLeAk1001);
		android.util.Log.d("leak-1002-13", dataLeAk1002);
		android.util.Log.d("leak-1003-13", dataLeAk1003);
		android.util.Log.d("leak-1004-13", dataLeAk1004);
		android.util.Log.d("leak-1005-13", dataLeAk1005);
		android.util.Log.d("leak-1006-13", dataLeAk1006);
		android.util.Log.d("leak-1007-13", dataLeAk1007);
		android.util.Log.d("leak-1008-13", dataLeAk1008);
		android.util.Log.d("leak-1009-13", dataLeAk1009);
		android.util.Log.d("leak-1010-13", dataLeAk1010);
		android.util.Log.d("leak-1011-13", dataLeAk1011);
		android.util.Log.d("leak-1012-13", dataLeAk1012);
		android.util.Log.d("leak-1013-13", dataLeAk1013);
		android.util.Log.d("leak-1014-13", dataLeAk1014);
		android.util.Log.d("leak-1015-13", dataLeAk1015);
		android.util.Log.d("leak-1016-13", dataLeAk1016);
		android.util.Log.d("leak-1017-13", dataLeAk1017);
		android.util.Log.d("leak-1018-13", dataLeAk1018);
		android.util.Log.d("leak-1019-13", dataLeAk1019);
		android.util.Log.d("leak-1020-13", dataLeAk1020);
		return new PointF(
                cropRect.centerX(),
                cropRect.centerY());
    }

    private float getNewScale() {
        dataLeAk1003 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-981-14", dataLeAk981);
		android.util.Log.d("leak-983-14", dataLeAk983);
		android.util.Log.d("leak-985-14", dataLeAk985);
		android.util.Log.d("leak-988-14", dataLeAk988);
		android.util.Log.d("leak-989-14", dataLeAk989);
		android.util.Log.d("leak-990-14", dataLeAk990);
		android.util.Log.d("leak-991-14", dataLeAk991);
		android.util.Log.d("leak-992-14", dataLeAk992);
		android.util.Log.d("leak-993-14", dataLeAk993);
		android.util.Log.d("leak-994-14", dataLeAk994);
		android.util.Log.d("leak-996-14", dataLeAk996);
		android.util.Log.d("leak-997-14", dataLeAk997);
		android.util.Log.d("leak-1001-14", dataLeAk1001);
		android.util.Log.d("leak-1002-14", dataLeAk1002);
		android.util.Log.d("leak-1003-14", dataLeAk1003);
		android.util.Log.d("leak-1004-14", dataLeAk1004);
		android.util.Log.d("leak-1005-14", dataLeAk1005);
		android.util.Log.d("leak-1006-14", dataLeAk1006);
		android.util.Log.d("leak-1007-14", dataLeAk1007);
		android.util.Log.d("leak-1008-14", dataLeAk1008);
		android.util.Log.d("leak-1009-14", dataLeAk1009);
		android.util.Log.d("leak-1010-14", dataLeAk1010);
		android.util.Log.d("leak-1011-14", dataLeAk1011);
		android.util.Log.d("leak-1012-14", dataLeAk1012);
		android.util.Log.d("leak-1013-14", dataLeAk1013);
		android.util.Log.d("leak-1014-14", dataLeAk1014);
		android.util.Log.d("leak-1015-14", dataLeAk1015);
		android.util.Log.d("leak-1016-14", dataLeAk1016);
		android.util.Log.d("leak-1017-14", dataLeAk1017);
		android.util.Log.d("leak-1018-14", dataLeAk1018);
		android.util.Log.d("leak-1019-14", dataLeAk1019);
		android.util.Log.d("leak-1020-14", dataLeAk1020);
		int width = getWidth() - (padding[0] + padding[2]);
        float scaleWidth = (float) width / (cropRect.right - cropRect.left);

        int height = getHeight() - (padding[1] + padding[3]);
        float scaleHeight = (float) height / (cropRect.bottom - cropRect.top);
        return scaleWidth < scaleHeight ? scaleWidth : scaleHeight;
    }

    private void autoZoom(boolean animate) {
        dataLeAk1004 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-981-15", dataLeAk981);
		android.util.Log.d("leak-983-15", dataLeAk983);
		android.util.Log.d("leak-985-15", dataLeAk985);
		android.util.Log.d("leak-988-15", dataLeAk988);
		android.util.Log.d("leak-989-15", dataLeAk989);
		android.util.Log.d("leak-990-15", dataLeAk990);
		android.util.Log.d("leak-991-15", dataLeAk991);
		android.util.Log.d("leak-992-15", dataLeAk992);
		android.util.Log.d("leak-993-15", dataLeAk993);
		android.util.Log.d("leak-994-15", dataLeAk994);
		android.util.Log.d("leak-996-15", dataLeAk996);
		android.util.Log.d("leak-997-15", dataLeAk997);
		android.util.Log.d("leak-1001-15", dataLeAk1001);
		android.util.Log.d("leak-1002-15", dataLeAk1002);
		android.util.Log.d("leak-1003-15", dataLeAk1003);
		android.util.Log.d("leak-1004-15", dataLeAk1004);
		android.util.Log.d("leak-1005-15", dataLeAk1005);
		android.util.Log.d("leak-1006-15", dataLeAk1006);
		android.util.Log.d("leak-1007-15", dataLeAk1007);
		android.util.Log.d("leak-1008-15", dataLeAk1008);
		android.util.Log.d("leak-1009-15", dataLeAk1009);
		android.util.Log.d("leak-1010-15", dataLeAk1010);
		android.util.Log.d("leak-1011-15", dataLeAk1011);
		android.util.Log.d("leak-1012-15", dataLeAk1012);
		android.util.Log.d("leak-1013-15", dataLeAk1013);
		android.util.Log.d("leak-1014-15", dataLeAk1014);
		android.util.Log.d("leak-1015-15", dataLeAk1015);
		android.util.Log.d("leak-1016-15", dataLeAk1016);
		android.util.Log.d("leak-1017-15", dataLeAk1017);
		android.util.Log.d("leak-1018-15", dataLeAk1018);
		android.util.Log.d("leak-1019-15", dataLeAk1019);
		android.util.Log.d("leak-1020-15", dataLeAk1020);
		//auto-zoom
        float scale = getNewScale();
        PointF center = getCenterOfCropRect();
        if (animate) {
            animateScaleAndCenter(scale, center)
                    .withDuration(300)
                    .withInterruptible(false)
                    .start();
        } else {
            setScaleAndCenter(scale, center);
        }
    }

    private int getTouchedCorner(MotionEvent motionEvent) {
        dataLeAk1005 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-981-16", dataLeAk981);
		android.util.Log.d("leak-983-16", dataLeAk983);
		android.util.Log.d("leak-985-16", dataLeAk985);
		android.util.Log.d("leak-988-16", dataLeAk988);
		android.util.Log.d("leak-989-16", dataLeAk989);
		android.util.Log.d("leak-990-16", dataLeAk990);
		android.util.Log.d("leak-991-16", dataLeAk991);
		android.util.Log.d("leak-992-16", dataLeAk992);
		android.util.Log.d("leak-993-16", dataLeAk993);
		android.util.Log.d("leak-994-16", dataLeAk994);
		android.util.Log.d("leak-996-16", dataLeAk996);
		android.util.Log.d("leak-997-16", dataLeAk997);
		android.util.Log.d("leak-1001-16", dataLeAk1001);
		android.util.Log.d("leak-1002-16", dataLeAk1002);
		android.util.Log.d("leak-1003-16", dataLeAk1003);
		android.util.Log.d("leak-1004-16", dataLeAk1004);
		android.util.Log.d("leak-1005-16", dataLeAk1005);
		android.util.Log.d("leak-1006-16", dataLeAk1006);
		android.util.Log.d("leak-1007-16", dataLeAk1007);
		android.util.Log.d("leak-1008-16", dataLeAk1008);
		android.util.Log.d("leak-1009-16", dataLeAk1009);
		android.util.Log.d("leak-1010-16", dataLeAk1010);
		android.util.Log.d("leak-1011-16", dataLeAk1011);
		android.util.Log.d("leak-1012-16", dataLeAk1012);
		android.util.Log.d("leak-1013-16", dataLeAk1013);
		android.util.Log.d("leak-1014-16", dataLeAk1014);
		android.util.Log.d("leak-1015-16", dataLeAk1015);
		android.util.Log.d("leak-1016-16", dataLeAk1016);
		android.util.Log.d("leak-1017-16", dataLeAk1017);
		android.util.Log.d("leak-1018-16", dataLeAk1018);
		android.util.Log.d("leak-1019-16", dataLeAk1019);
		android.util.Log.d("leak-1020-16", dataLeAk1020);
		PointF currentTouchPos = new PointF(motionEvent.getX(), motionEvent.getY());
        if (cropRect == null) {
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
            return TOP_LEFT;
        }

        if (currentTouchPos.x > cropRect.right - touchDelta
                && currentTouchPos.x < cropRect.right + touchDelta
                && currentTouchPos.y > cropRect.top - touchDelta
                && currentTouchPos.y < cropRect.top + touchDelta) {
            return TOP_RIGHT;
        }

        if (currentTouchPos.x > cropRect.right - touchDelta
                && currentTouchPos.x < cropRect.right + touchDelta
                && currentTouchPos.y > cropRect.bottom - touchDelta
                && currentTouchPos.y < cropRect.bottom + touchDelta) {
            return BOTTOM_RIGHT;
        }

        if (currentTouchPos.x > cropRect.left - touchDelta
                && currentTouchPos.x < cropRect.left + touchDelta
                && currentTouchPos.y > cropRect.bottom - touchDelta
                && currentTouchPos.y < cropRect.bottom + touchDelta) {
            return BOTTOM_LEFT;
        }

        return NO_CORNER;
    }

    private Rect getNewRect(MotionEvent motionEvent) {
        dataLeAk1006 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-981-17", dataLeAk981);
		android.util.Log.d("leak-983-17", dataLeAk983);
		android.util.Log.d("leak-985-17", dataLeAk985);
		android.util.Log.d("leak-988-17", dataLeAk988);
		android.util.Log.d("leak-989-17", dataLeAk989);
		android.util.Log.d("leak-990-17", dataLeAk990);
		android.util.Log.d("leak-991-17", dataLeAk991);
		android.util.Log.d("leak-992-17", dataLeAk992);
		android.util.Log.d("leak-993-17", dataLeAk993);
		android.util.Log.d("leak-994-17", dataLeAk994);
		android.util.Log.d("leak-996-17", dataLeAk996);
		android.util.Log.d("leak-997-17", dataLeAk997);
		android.util.Log.d("leak-1001-17", dataLeAk1001);
		android.util.Log.d("leak-1002-17", dataLeAk1002);
		android.util.Log.d("leak-1003-17", dataLeAk1003);
		android.util.Log.d("leak-1004-17", dataLeAk1004);
		android.util.Log.d("leak-1005-17", dataLeAk1005);
		android.util.Log.d("leak-1006-17", dataLeAk1006);
		android.util.Log.d("leak-1007-17", dataLeAk1007);
		android.util.Log.d("leak-1008-17", dataLeAk1008);
		android.util.Log.d("leak-1009-17", dataLeAk1009);
		android.util.Log.d("leak-1010-17", dataLeAk1010);
		android.util.Log.d("leak-1011-17", dataLeAk1011);
		android.util.Log.d("leak-1012-17", dataLeAk1012);
		android.util.Log.d("leak-1013-17", dataLeAk1013);
		android.util.Log.d("leak-1014-17", dataLeAk1014);
		android.util.Log.d("leak-1015-17", dataLeAk1015);
		android.util.Log.d("leak-1016-17", dataLeAk1016);
		android.util.Log.d("leak-1017-17", dataLeAk1017);
		android.util.Log.d("leak-1018-17", dataLeAk1018);
		android.util.Log.d("leak-1019-17", dataLeAk1019);
		android.util.Log.d("leak-1020-17", dataLeAk1020);
		PointF currentTouchPos = viewToSourceCoord(
                motionEvent.getX(), motionEvent.getY());

        if (touchedCorner == TOP_LEFT) {
            Rect newCropRect = new Rect(
                    (int) currentTouchPos.x,
                    (int) currentTouchPos.y,
                    cropRect.right,
                    cropRect.bottom);
            return checkRectBounds(newCropRect, true);
        }

        if (touchedCorner == TOP_RIGHT) {
            Rect newCropRect = new Rect(
                    cropRect.left,
                    (int) currentTouchPos.y,
                    (int) currentTouchPos.x,
                    cropRect.bottom);
            return checkRectBounds(newCropRect, true);
        }

        if (touchedCorner == BOTTOM_RIGHT) {
            Rect newCropRect = new Rect(
                    cropRect.left,
                    cropRect.top,
                    (int) currentTouchPos.x,
                    (int) currentTouchPos.y);
            return checkRectBounds(newCropRect, true);
        }

        if (touchedCorner == BOTTOM_LEFT) {
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
        dataLeAk1007 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-981-18", dataLeAk981);
		android.util.Log.d("leak-983-18", dataLeAk983);
		android.util.Log.d("leak-985-18", dataLeAk985);
		android.util.Log.d("leak-988-18", dataLeAk988);
		android.util.Log.d("leak-989-18", dataLeAk989);
		android.util.Log.d("leak-990-18", dataLeAk990);
		android.util.Log.d("leak-991-18", dataLeAk991);
		android.util.Log.d("leak-992-18", dataLeAk992);
		android.util.Log.d("leak-993-18", dataLeAk993);
		android.util.Log.d("leak-994-18", dataLeAk994);
		android.util.Log.d("leak-996-18", dataLeAk996);
		android.util.Log.d("leak-997-18", dataLeAk997);
		android.util.Log.d("leak-1001-18", dataLeAk1001);
		android.util.Log.d("leak-1002-18", dataLeAk1002);
		android.util.Log.d("leak-1003-18", dataLeAk1003);
		android.util.Log.d("leak-1004-18", dataLeAk1004);
		android.util.Log.d("leak-1005-18", dataLeAk1005);
		android.util.Log.d("leak-1006-18", dataLeAk1006);
		android.util.Log.d("leak-1007-18", dataLeAk1007);
		android.util.Log.d("leak-1008-18", dataLeAk1008);
		android.util.Log.d("leak-1009-18", dataLeAk1009);
		android.util.Log.d("leak-1010-18", dataLeAk1010);
		android.util.Log.d("leak-1011-18", dataLeAk1011);
		android.util.Log.d("leak-1012-18", dataLeAk1012);
		android.util.Log.d("leak-1013-18", dataLeAk1013);
		android.util.Log.d("leak-1014-18", dataLeAk1014);
		android.util.Log.d("leak-1015-18", dataLeAk1015);
		android.util.Log.d("leak-1016-18", dataLeAk1016);
		android.util.Log.d("leak-1017-18", dataLeAk1017);
		android.util.Log.d("leak-1018-18", dataLeAk1018);
		android.util.Log.d("leak-1019-18", dataLeAk1019);
		android.util.Log.d("leak-1020-18", dataLeAk1020);
		if (cropRect == null) {
            return null;
        }

        PointF currentTouchPos = viewToSourceCoord(motionEvent.getX(),
                motionEvent.getY());

        int historySize = motionEvent.getHistorySize();
        if (historySize > 0) {
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
            return cropRect;
        }
    }

    private Rect checkRectBounds(Rect cropRect, boolean resize) {
        dataLeAk1008 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-981-19", dataLeAk981);
		android.util.Log.d("leak-983-19", dataLeAk983);
		android.util.Log.d("leak-985-19", dataLeAk985);
		android.util.Log.d("leak-988-19", dataLeAk988);
		android.util.Log.d("leak-989-19", dataLeAk989);
		android.util.Log.d("leak-990-19", dataLeAk990);
		android.util.Log.d("leak-991-19", dataLeAk991);
		android.util.Log.d("leak-992-19", dataLeAk992);
		android.util.Log.d("leak-993-19", dataLeAk993);
		android.util.Log.d("leak-994-19", dataLeAk994);
		android.util.Log.d("leak-996-19", dataLeAk996);
		android.util.Log.d("leak-997-19", dataLeAk997);
		android.util.Log.d("leak-1001-19", dataLeAk1001);
		android.util.Log.d("leak-1002-19", dataLeAk1002);
		android.util.Log.d("leak-1003-19", dataLeAk1003);
		android.util.Log.d("leak-1004-19", dataLeAk1004);
		android.util.Log.d("leak-1005-19", dataLeAk1005);
		android.util.Log.d("leak-1006-19", dataLeAk1006);
		android.util.Log.d("leak-1007-19", dataLeAk1007);
		android.util.Log.d("leak-1008-19", dataLeAk1008);
		android.util.Log.d("leak-1009-19", dataLeAk1009);
		android.util.Log.d("leak-1010-19", dataLeAk1010);
		android.util.Log.d("leak-1011-19", dataLeAk1011);
		android.util.Log.d("leak-1012-19", dataLeAk1012);
		android.util.Log.d("leak-1013-19", dataLeAk1013);
		android.util.Log.d("leak-1014-19", dataLeAk1014);
		android.util.Log.d("leak-1015-19", dataLeAk1015);
		android.util.Log.d("leak-1016-19", dataLeAk1016);
		android.util.Log.d("leak-1017-19", dataLeAk1017);
		android.util.Log.d("leak-1018-19", dataLeAk1018);
		android.util.Log.d("leak-1019-19", dataLeAk1019);
		android.util.Log.d("leak-1020-19", dataLeAk1020);
		Rect image = getImageRect();
        Rect newCropRect = cropRect;
        //check if inside image
        int width = newCropRect.width();
        int height = newCropRect.height();

        if (image.left > newCropRect.left) {
            newCropRect = new Rect(image.left, newCropRect.top,
                    resize ? newCropRect.right : image.left + width,
                    newCropRect.bottom);
        }

        if (image.top > newCropRect.top) {
            newCropRect = new Rect(
                    newCropRect.left, image.top, newCropRect.right,
                    resize ? newCropRect.bottom : image.top + height);
        }

        if (image.right < newCropRect.right) {
            newCropRect = new Rect(
                    resize ? newCropRect.left : image.right - width,
                    newCropRect.top, image.right, newCropRect.bottom);
        }

        if (image.bottom < newCropRect.bottom) {
            newCropRect = new Rect(newCropRect.left,
                    resize ? newCropRect.top : image.bottom - height,
                    newCropRect.right, image.bottom);
        }

        //check min size
        width = newCropRect.width();
        if (width < minCropRectSize) {
            if (touchedCorner == TOP_LEFT) {
                newCropRect = new Rect(newCropRect.right - minCropRectSize,
                        newCropRect.top, newCropRect.right, newCropRect.bottom);
            } else if (touchedCorner == TOP_RIGHT) {
                newCropRect = new Rect(newCropRect.left, newCropRect.top,
                        newCropRect.left + minCropRectSize,
                        newCropRect.bottom);
            } else if (touchedCorner == BOTTOM_RIGHT) {
                newCropRect = new Rect(newCropRect.left, newCropRect.top,
                        newCropRect.left + minCropRectSize,
                        newCropRect.bottom);
            } else if (touchedCorner == BOTTOM_LEFT) {
                newCropRect = new Rect(newCropRect.right - minCropRectSize,
                        newCropRect.top, newCropRect.right, newCropRect.bottom);
            }
        }

        height = newCropRect.height();
        if (height < minCropRectSize) {
            if (touchedCorner == TOP_LEFT) {
                newCropRect = new Rect(newCropRect.left,
                        newCropRect.bottom - minCropRectSize,
                        newCropRect.right, newCropRect.bottom);
            } else if (touchedCorner == TOP_RIGHT) {
                newCropRect = new Rect(newCropRect.left,
                        newCropRect.bottom - minCropRectSize,
                        newCropRect.right, newCropRect.bottom);
            } else if (touchedCorner == BOTTOM_RIGHT) {
                newCropRect = new Rect(newCropRect.left, newCropRect.top,
                        newCropRect.right,
                        newCropRect.top + minCropRectSize);
            } else if (touchedCorner == BOTTOM_LEFT) {
                newCropRect = new Rect(newCropRect.left,
                        newCropRect.top, newCropRect.right,
                        newCropRect.top + minCropRectSize);
            }
        }

        return newCropRect;
    }

    private Rect getImageRect() {
        dataLeAk1009 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-981-20", dataLeAk981);
		android.util.Log.d("leak-983-20", dataLeAk983);
		android.util.Log.d("leak-985-20", dataLeAk985);
		android.util.Log.d("leak-988-20", dataLeAk988);
		android.util.Log.d("leak-989-20", dataLeAk989);
		android.util.Log.d("leak-990-20", dataLeAk990);
		android.util.Log.d("leak-991-20", dataLeAk991);
		android.util.Log.d("leak-992-20", dataLeAk992);
		android.util.Log.d("leak-993-20", dataLeAk993);
		android.util.Log.d("leak-994-20", dataLeAk994);
		android.util.Log.d("leak-996-20", dataLeAk996);
		android.util.Log.d("leak-997-20", dataLeAk997);
		android.util.Log.d("leak-1001-20", dataLeAk1001);
		android.util.Log.d("leak-1002-20", dataLeAk1002);
		android.util.Log.d("leak-1003-20", dataLeAk1003);
		android.util.Log.d("leak-1004-20", dataLeAk1004);
		android.util.Log.d("leak-1005-20", dataLeAk1005);
		android.util.Log.d("leak-1006-20", dataLeAk1006);
		android.util.Log.d("leak-1007-20", dataLeAk1007);
		android.util.Log.d("leak-1008-20", dataLeAk1008);
		android.util.Log.d("leak-1009-20", dataLeAk1009);
		android.util.Log.d("leak-1010-20", dataLeAk1010);
		android.util.Log.d("leak-1011-20", dataLeAk1011);
		android.util.Log.d("leak-1012-20", dataLeAk1012);
		android.util.Log.d("leak-1013-20", dataLeAk1013);
		android.util.Log.d("leak-1014-20", dataLeAk1014);
		android.util.Log.d("leak-1015-20", dataLeAk1015);
		android.util.Log.d("leak-1016-20", dataLeAk1016);
		android.util.Log.d("leak-1017-20", dataLeAk1017);
		android.util.Log.d("leak-1018-20", dataLeAk1018);
		android.util.Log.d("leak-1019-20", dataLeAk1019);
		android.util.Log.d("leak-1020-20", dataLeAk1020);
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
        dataLeAk1010 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-981-21", dataLeAk981);
		android.util.Log.d("leak-983-21", dataLeAk983);
		android.util.Log.d("leak-985-21", dataLeAk985);
		android.util.Log.d("leak-988-21", dataLeAk988);
		android.util.Log.d("leak-989-21", dataLeAk989);
		android.util.Log.d("leak-990-21", dataLeAk990);
		android.util.Log.d("leak-991-21", dataLeAk991);
		android.util.Log.d("leak-992-21", dataLeAk992);
		android.util.Log.d("leak-993-21", dataLeAk993);
		android.util.Log.d("leak-994-21", dataLeAk994);
		android.util.Log.d("leak-996-21", dataLeAk996);
		android.util.Log.d("leak-997-21", dataLeAk997);
		android.util.Log.d("leak-1001-21", dataLeAk1001);
		android.util.Log.d("leak-1002-21", dataLeAk1002);
		android.util.Log.d("leak-1003-21", dataLeAk1003);
		android.util.Log.d("leak-1004-21", dataLeAk1004);
		android.util.Log.d("leak-1005-21", dataLeAk1005);
		android.util.Log.d("leak-1006-21", dataLeAk1006);
		android.util.Log.d("leak-1007-21", dataLeAk1007);
		android.util.Log.d("leak-1008-21", dataLeAk1008);
		android.util.Log.d("leak-1009-21", dataLeAk1009);
		android.util.Log.d("leak-1010-21", dataLeAk1010);
		android.util.Log.d("leak-1011-21", dataLeAk1011);
		android.util.Log.d("leak-1012-21", dataLeAk1012);
		android.util.Log.d("leak-1013-21", dataLeAk1013);
		android.util.Log.d("leak-1014-21", dataLeAk1014);
		android.util.Log.d("leak-1015-21", dataLeAk1015);
		android.util.Log.d("leak-1016-21", dataLeAk1016);
		android.util.Log.d("leak-1017-21", dataLeAk1017);
		android.util.Log.d("leak-1018-21", dataLeAk1018);
		android.util.Log.d("leak-1019-21", dataLeAk1019);
		android.util.Log.d("leak-1020-21", dataLeAk1020);
		Rect imageRect = getImageRect();
        int newWidth = cropRect.height();
        int newHeight = cropRect.width();
        Point newTopLeft = new Point(imageRect.height() - (cropRect.top + cropRect.height()), cropRect.left);
        return new Rect(newTopLeft.x, newTopLeft.y,
                newTopLeft.x + newWidth, newTopLeft.y + newHeight);
    }

    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        dataLeAk1011 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-981-22", dataLeAk981);
		android.util.Log.d("leak-983-22", dataLeAk983);
		android.util.Log.d("leak-985-22", dataLeAk985);
		android.util.Log.d("leak-988-22", dataLeAk988);
		android.util.Log.d("leak-989-22", dataLeAk989);
		android.util.Log.d("leak-990-22", dataLeAk990);
		android.util.Log.d("leak-991-22", dataLeAk991);
		android.util.Log.d("leak-992-22", dataLeAk992);
		android.util.Log.d("leak-993-22", dataLeAk993);
		android.util.Log.d("leak-994-22", dataLeAk994);
		android.util.Log.d("leak-996-22", dataLeAk996);
		android.util.Log.d("leak-997-22", dataLeAk997);
		android.util.Log.d("leak-1001-22", dataLeAk1001);
		android.util.Log.d("leak-1002-22", dataLeAk1002);
		android.util.Log.d("leak-1003-22", dataLeAk1003);
		android.util.Log.d("leak-1004-22", dataLeAk1004);
		android.util.Log.d("leak-1005-22", dataLeAk1005);
		android.util.Log.d("leak-1006-22", dataLeAk1006);
		android.util.Log.d("leak-1007-22", dataLeAk1007);
		android.util.Log.d("leak-1008-22", dataLeAk1008);
		android.util.Log.d("leak-1009-22", dataLeAk1009);
		android.util.Log.d("leak-1010-22", dataLeAk1010);
		android.util.Log.d("leak-1011-22", dataLeAk1011);
		android.util.Log.d("leak-1012-22", dataLeAk1012);
		android.util.Log.d("leak-1013-22", dataLeAk1013);
		android.util.Log.d("leak-1014-22", dataLeAk1014);
		android.util.Log.d("leak-1015-22", dataLeAk1015);
		android.util.Log.d("leak-1016-22", dataLeAk1016);
		android.util.Log.d("leak-1017-22", dataLeAk1017);
		android.util.Log.d("leak-1018-22", dataLeAk1018);
		android.util.Log.d("leak-1019-22", dataLeAk1019);
		android.util.Log.d("leak-1020-22", dataLeAk1020);
		//super.setPadding(left, top, right, bottom);
        padding = new int[]{left, top, right, bottom};
    }

    @Override
    protected void onDraw(Canvas canvas) {
        /*canvas.save();
        canvas.rotate(rotationAngle, canvas.getWidth() / 2, canvas.getHeight() / 2);*/
        super.onDraw(canvas);
        /*canvas.restore();*/
		dataLeAk1012 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-981-23", dataLeAk981);
		android.util.Log.d("leak-983-23", dataLeAk983);
		android.util.Log.d("leak-985-23", dataLeAk985);
		android.util.Log.d("leak-988-23", dataLeAk988);
		android.util.Log.d("leak-989-23", dataLeAk989);
		android.util.Log.d("leak-990-23", dataLeAk990);
		android.util.Log.d("leak-991-23", dataLeAk991);
		android.util.Log.d("leak-992-23", dataLeAk992);
		android.util.Log.d("leak-993-23", dataLeAk993);
		android.util.Log.d("leak-994-23", dataLeAk994);
		android.util.Log.d("leak-996-23", dataLeAk996);
		android.util.Log.d("leak-997-23", dataLeAk997);
		android.util.Log.d("leak-1001-23", dataLeAk1001);
		android.util.Log.d("leak-1002-23", dataLeAk1002);
		android.util.Log.d("leak-1003-23", dataLeAk1003);
		android.util.Log.d("leak-1004-23", dataLeAk1004);
		android.util.Log.d("leak-1005-23", dataLeAk1005);
		android.util.Log.d("leak-1006-23", dataLeAk1006);
		android.util.Log.d("leak-1007-23", dataLeAk1007);
		android.util.Log.d("leak-1008-23", dataLeAk1008);
		android.util.Log.d("leak-1009-23", dataLeAk1009);
		android.util.Log.d("leak-1010-23", dataLeAk1010);
		android.util.Log.d("leak-1011-23", dataLeAk1011);
		android.util.Log.d("leak-1012-23", dataLeAk1012);
		android.util.Log.d("leak-1013-23", dataLeAk1013);
		android.util.Log.d("leak-1014-23", dataLeAk1014);
		android.util.Log.d("leak-1015-23", dataLeAk1015);
		android.util.Log.d("leak-1016-23", dataLeAk1016);
		android.util.Log.d("leak-1017-23", dataLeAk1017);
		android.util.Log.d("leak-1018-23", dataLeAk1018);
		android.util.Log.d("leak-1019-23", dataLeAk1019);
		android.util.Log.d("leak-1020-23", dataLeAk1020);

        // Don't draw anything before image is ready.
        if (!isReady() || cropRect == null) {
            return;
        }

        drawBackground(canvas);
        drawRect(canvas);
        drawCorners(canvas);
        if (touching) {
            drawGuidelines(canvas);
        }
    }

    private void drawRect(Canvas canvas) {
        dataLeAk1013 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-981-24", dataLeAk981);
		android.util.Log.d("leak-983-24", dataLeAk983);
		android.util.Log.d("leak-985-24", dataLeAk985);
		android.util.Log.d("leak-988-24", dataLeAk988);
		android.util.Log.d("leak-989-24", dataLeAk989);
		android.util.Log.d("leak-990-24", dataLeAk990);
		android.util.Log.d("leak-991-24", dataLeAk991);
		android.util.Log.d("leak-992-24", dataLeAk992);
		android.util.Log.d("leak-993-24", dataLeAk993);
		android.util.Log.d("leak-994-24", dataLeAk994);
		android.util.Log.d("leak-996-24", dataLeAk996);
		android.util.Log.d("leak-997-24", dataLeAk997);
		android.util.Log.d("leak-1001-24", dataLeAk1001);
		android.util.Log.d("leak-1002-24", dataLeAk1002);
		android.util.Log.d("leak-1003-24", dataLeAk1003);
		android.util.Log.d("leak-1004-24", dataLeAk1004);
		android.util.Log.d("leak-1005-24", dataLeAk1005);
		android.util.Log.d("leak-1006-24", dataLeAk1006);
		android.util.Log.d("leak-1007-24", dataLeAk1007);
		android.util.Log.d("leak-1008-24", dataLeAk1008);
		android.util.Log.d("leak-1009-24", dataLeAk1009);
		android.util.Log.d("leak-1010-24", dataLeAk1010);
		android.util.Log.d("leak-1011-24", dataLeAk1011);
		android.util.Log.d("leak-1012-24", dataLeAk1012);
		android.util.Log.d("leak-1013-24", dataLeAk1013);
		android.util.Log.d("leak-1014-24", dataLeAk1014);
		android.util.Log.d("leak-1015-24", dataLeAk1015);
		android.util.Log.d("leak-1016-24", dataLeAk1016);
		android.util.Log.d("leak-1017-24", dataLeAk1017);
		android.util.Log.d("leak-1018-24", dataLeAk1018);
		android.util.Log.d("leak-1019-24", dataLeAk1019);
		android.util.Log.d("leak-1020-24", dataLeAk1020);
		PointF topLeft = sourceToViewCoord(cropRect.left, cropRect.top);
        PointF bottomRight = sourceToViewCoord(cropRect.right, cropRect.bottom);
        if (topLeft == null || bottomRight == null) {
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
        dataLeAk1014 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-981-25", dataLeAk981);
		android.util.Log.d("leak-983-25", dataLeAk983);
		android.util.Log.d("leak-985-25", dataLeAk985);
		android.util.Log.d("leak-988-25", dataLeAk988);
		android.util.Log.d("leak-989-25", dataLeAk989);
		android.util.Log.d("leak-990-25", dataLeAk990);
		android.util.Log.d("leak-991-25", dataLeAk991);
		android.util.Log.d("leak-992-25", dataLeAk992);
		android.util.Log.d("leak-993-25", dataLeAk993);
		android.util.Log.d("leak-994-25", dataLeAk994);
		android.util.Log.d("leak-996-25", dataLeAk996);
		android.util.Log.d("leak-997-25", dataLeAk997);
		android.util.Log.d("leak-1001-25", dataLeAk1001);
		android.util.Log.d("leak-1002-25", dataLeAk1002);
		android.util.Log.d("leak-1003-25", dataLeAk1003);
		android.util.Log.d("leak-1004-25", dataLeAk1004);
		android.util.Log.d("leak-1005-25", dataLeAk1005);
		android.util.Log.d("leak-1006-25", dataLeAk1006);
		android.util.Log.d("leak-1007-25", dataLeAk1007);
		android.util.Log.d("leak-1008-25", dataLeAk1008);
		android.util.Log.d("leak-1009-25", dataLeAk1009);
		android.util.Log.d("leak-1010-25", dataLeAk1010);
		android.util.Log.d("leak-1011-25", dataLeAk1011);
		android.util.Log.d("leak-1012-25", dataLeAk1012);
		android.util.Log.d("leak-1013-25", dataLeAk1013);
		android.util.Log.d("leak-1014-25", dataLeAk1014);
		android.util.Log.d("leak-1015-25", dataLeAk1015);
		android.util.Log.d("leak-1016-25", dataLeAk1016);
		android.util.Log.d("leak-1017-25", dataLeAk1017);
		android.util.Log.d("leak-1018-25", dataLeAk1018);
		android.util.Log.d("leak-1019-25", dataLeAk1019);
		android.util.Log.d("leak-1020-25", dataLeAk1020);
		PointF topLeft = sourceToViewCoord(cropRect.left, cropRect.top);
        PointF bottomRight = sourceToViewCoord(cropRect.right, cropRect.bottom);
        if (topLeft == null || bottomRight == null) {
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
        dataLeAk1015 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-981-26", dataLeAk981);
		android.util.Log.d("leak-983-26", dataLeAk983);
		android.util.Log.d("leak-985-26", dataLeAk985);
		android.util.Log.d("leak-988-26", dataLeAk988);
		android.util.Log.d("leak-989-26", dataLeAk989);
		android.util.Log.d("leak-990-26", dataLeAk990);
		android.util.Log.d("leak-991-26", dataLeAk991);
		android.util.Log.d("leak-992-26", dataLeAk992);
		android.util.Log.d("leak-993-26", dataLeAk993);
		android.util.Log.d("leak-994-26", dataLeAk994);
		android.util.Log.d("leak-996-26", dataLeAk996);
		android.util.Log.d("leak-997-26", dataLeAk997);
		android.util.Log.d("leak-1001-26", dataLeAk1001);
		android.util.Log.d("leak-1002-26", dataLeAk1002);
		android.util.Log.d("leak-1003-26", dataLeAk1003);
		android.util.Log.d("leak-1004-26", dataLeAk1004);
		android.util.Log.d("leak-1005-26", dataLeAk1005);
		android.util.Log.d("leak-1006-26", dataLeAk1006);
		android.util.Log.d("leak-1007-26", dataLeAk1007);
		android.util.Log.d("leak-1008-26", dataLeAk1008);
		android.util.Log.d("leak-1009-26", dataLeAk1009);
		android.util.Log.d("leak-1010-26", dataLeAk1010);
		android.util.Log.d("leak-1011-26", dataLeAk1011);
		android.util.Log.d("leak-1012-26", dataLeAk1012);
		android.util.Log.d("leak-1013-26", dataLeAk1013);
		android.util.Log.d("leak-1014-26", dataLeAk1014);
		android.util.Log.d("leak-1015-26", dataLeAk1015);
		android.util.Log.d("leak-1016-26", dataLeAk1016);
		android.util.Log.d("leak-1017-26", dataLeAk1017);
		android.util.Log.d("leak-1018-26", dataLeAk1018);
		android.util.Log.d("leak-1019-26", dataLeAk1019);
		android.util.Log.d("leak-1020-26", dataLeAk1020);
		Path corner = new Path();
        corner.moveTo(cornerStrokeWidth / 2, cornerLength - cornerStrokeWidth / 2);
        corner.lineTo(cornerStrokeWidth / 2, cornerStrokeWidth / 2);
        corner.lineTo(cornerLength - cornerStrokeWidth / 2, cornerStrokeWidth / 2);
        return corner;
    }

    private void drawBackground(Canvas canvas) {
        dataLeAk1016 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-981-27", dataLeAk981);
		android.util.Log.d("leak-983-27", dataLeAk983);
		android.util.Log.d("leak-985-27", dataLeAk985);
		android.util.Log.d("leak-988-27", dataLeAk988);
		android.util.Log.d("leak-989-27", dataLeAk989);
		android.util.Log.d("leak-990-27", dataLeAk990);
		android.util.Log.d("leak-991-27", dataLeAk991);
		android.util.Log.d("leak-992-27", dataLeAk992);
		android.util.Log.d("leak-993-27", dataLeAk993);
		android.util.Log.d("leak-994-27", dataLeAk994);
		android.util.Log.d("leak-996-27", dataLeAk996);
		android.util.Log.d("leak-997-27", dataLeAk997);
		android.util.Log.d("leak-1001-27", dataLeAk1001);
		android.util.Log.d("leak-1002-27", dataLeAk1002);
		android.util.Log.d("leak-1003-27", dataLeAk1003);
		android.util.Log.d("leak-1004-27", dataLeAk1004);
		android.util.Log.d("leak-1005-27", dataLeAk1005);
		android.util.Log.d("leak-1006-27", dataLeAk1006);
		android.util.Log.d("leak-1007-27", dataLeAk1007);
		android.util.Log.d("leak-1008-27", dataLeAk1008);
		android.util.Log.d("leak-1009-27", dataLeAk1009);
		android.util.Log.d("leak-1010-27", dataLeAk1010);
		android.util.Log.d("leak-1011-27", dataLeAk1011);
		android.util.Log.d("leak-1012-27", dataLeAk1012);
		android.util.Log.d("leak-1013-27", dataLeAk1013);
		android.util.Log.d("leak-1014-27", dataLeAk1014);
		android.util.Log.d("leak-1015-27", dataLeAk1015);
		android.util.Log.d("leak-1016-27", dataLeAk1016);
		android.util.Log.d("leak-1017-27", dataLeAk1017);
		android.util.Log.d("leak-1018-27", dataLeAk1018);
		android.util.Log.d("leak-1019-27", dataLeAk1019);
		android.util.Log.d("leak-1020-27", dataLeAk1020);
		Rect imageRect = getImageRect();
        PointF topLeftImageRect = sourceToViewCoord(imageRect.left, imageRect.top);
        PointF bottomRightImageRect = sourceToViewCoord(imageRect.left, imageRect.top);

        PointF topLeft = sourceToViewCoord(cropRect.left, cropRect.top);
        PointF bottomRight = sourceToViewCoord(cropRect.right, cropRect.bottom);
        if (topLeftImageRect == null || bottomRightImageRect == null ||
                topLeft == null || bottomRight == null) {
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
        dataLeAk1017 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-981-28", dataLeAk981);
		android.util.Log.d("leak-983-28", dataLeAk983);
		android.util.Log.d("leak-985-28", dataLeAk985);
		android.util.Log.d("leak-988-28", dataLeAk988);
		android.util.Log.d("leak-989-28", dataLeAk989);
		android.util.Log.d("leak-990-28", dataLeAk990);
		android.util.Log.d("leak-991-28", dataLeAk991);
		android.util.Log.d("leak-992-28", dataLeAk992);
		android.util.Log.d("leak-993-28", dataLeAk993);
		android.util.Log.d("leak-994-28", dataLeAk994);
		android.util.Log.d("leak-996-28", dataLeAk996);
		android.util.Log.d("leak-997-28", dataLeAk997);
		android.util.Log.d("leak-1001-28", dataLeAk1001);
		android.util.Log.d("leak-1002-28", dataLeAk1002);
		android.util.Log.d("leak-1003-28", dataLeAk1003);
		android.util.Log.d("leak-1004-28", dataLeAk1004);
		android.util.Log.d("leak-1005-28", dataLeAk1005);
		android.util.Log.d("leak-1006-28", dataLeAk1006);
		android.util.Log.d("leak-1007-28", dataLeAk1007);
		android.util.Log.d("leak-1008-28", dataLeAk1008);
		android.util.Log.d("leak-1009-28", dataLeAk1009);
		android.util.Log.d("leak-1010-28", dataLeAk1010);
		android.util.Log.d("leak-1011-28", dataLeAk1011);
		android.util.Log.d("leak-1012-28", dataLeAk1012);
		android.util.Log.d("leak-1013-28", dataLeAk1013);
		android.util.Log.d("leak-1014-28", dataLeAk1014);
		android.util.Log.d("leak-1015-28", dataLeAk1015);
		android.util.Log.d("leak-1016-28", dataLeAk1016);
		android.util.Log.d("leak-1017-28", dataLeAk1017);
		android.util.Log.d("leak-1018-28", dataLeAk1018);
		android.util.Log.d("leak-1019-28", dataLeAk1019);
		android.util.Log.d("leak-1020-28", dataLeAk1020);
		PointF topLeft = sourceToViewCoord(cropRect.left, cropRect.top);
        PointF bottomRight = sourceToViewCoord(cropRect.right, cropRect.bottom);
        if (topLeft == null || bottomRight == null) {
            return;
        }

        float width = bottomRight.x - topLeft.x;
        float height = bottomRight.y - topLeft.y;
        float thirdWidth = width / 3;
        float thirdHeight = height / 3;

        for (int i = 1; i <= 2; i++) {
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
        dataLeAk1018 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-981-29", dataLeAk981);
		android.util.Log.d("leak-983-29", dataLeAk983);
		android.util.Log.d("leak-985-29", dataLeAk985);
		android.util.Log.d("leak-988-29", dataLeAk988);
		android.util.Log.d("leak-989-29", dataLeAk989);
		android.util.Log.d("leak-990-29", dataLeAk990);
		android.util.Log.d("leak-991-29", dataLeAk991);
		android.util.Log.d("leak-992-29", dataLeAk992);
		android.util.Log.d("leak-993-29", dataLeAk993);
		android.util.Log.d("leak-994-29", dataLeAk994);
		android.util.Log.d("leak-996-29", dataLeAk996);
		android.util.Log.d("leak-997-29", dataLeAk997);
		android.util.Log.d("leak-1001-29", dataLeAk1001);
		android.util.Log.d("leak-1002-29", dataLeAk1002);
		android.util.Log.d("leak-1003-29", dataLeAk1003);
		android.util.Log.d("leak-1004-29", dataLeAk1004);
		android.util.Log.d("leak-1005-29", dataLeAk1005);
		android.util.Log.d("leak-1006-29", dataLeAk1006);
		android.util.Log.d("leak-1007-29", dataLeAk1007);
		android.util.Log.d("leak-1008-29", dataLeAk1008);
		android.util.Log.d("leak-1009-29", dataLeAk1009);
		android.util.Log.d("leak-1010-29", dataLeAk1010);
		android.util.Log.d("leak-1011-29", dataLeAk1011);
		android.util.Log.d("leak-1012-29", dataLeAk1012);
		android.util.Log.d("leak-1013-29", dataLeAk1013);
		android.util.Log.d("leak-1014-29", dataLeAk1014);
		android.util.Log.d("leak-1015-29", dataLeAk1015);
		android.util.Log.d("leak-1016-29", dataLeAk1016);
		android.util.Log.d("leak-1017-29", dataLeAk1017);
		android.util.Log.d("leak-1018-29", dataLeAk1018);
		android.util.Log.d("leak-1019-29", dataLeAk1019);
		android.util.Log.d("leak-1020-29", dataLeAk1020);
		ImageViewState state = getState();
        if (state != null) {
            return new State(state.getScale(), state.getCenter(), state.getOrientation(), cropRect);
        }
        return null;
    }

    private ProgressBar getProgressBar() {
        dataLeAk1019 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-981-30", dataLeAk981);
		android.util.Log.d("leak-983-30", dataLeAk983);
		android.util.Log.d("leak-985-30", dataLeAk985);
		android.util.Log.d("leak-988-30", dataLeAk988);
		android.util.Log.d("leak-989-30", dataLeAk989);
		android.util.Log.d("leak-990-30", dataLeAk990);
		android.util.Log.d("leak-991-30", dataLeAk991);
		android.util.Log.d("leak-992-30", dataLeAk992);
		android.util.Log.d("leak-993-30", dataLeAk993);
		android.util.Log.d("leak-994-30", dataLeAk994);
		android.util.Log.d("leak-996-30", dataLeAk996);
		android.util.Log.d("leak-997-30", dataLeAk997);
		android.util.Log.d("leak-1001-30", dataLeAk1001);
		android.util.Log.d("leak-1002-30", dataLeAk1002);
		android.util.Log.d("leak-1003-30", dataLeAk1003);
		android.util.Log.d("leak-1004-30", dataLeAk1004);
		android.util.Log.d("leak-1005-30", dataLeAk1005);
		android.util.Log.d("leak-1006-30", dataLeAk1006);
		android.util.Log.d("leak-1007-30", dataLeAk1007);
		android.util.Log.d("leak-1008-30", dataLeAk1008);
		android.util.Log.d("leak-1009-30", dataLeAk1009);
		android.util.Log.d("leak-1010-30", dataLeAk1010);
		android.util.Log.d("leak-1011-30", dataLeAk1011);
		android.util.Log.d("leak-1012-30", dataLeAk1012);
		android.util.Log.d("leak-1013-30", dataLeAk1013);
		android.util.Log.d("leak-1014-30", dataLeAk1014);
		android.util.Log.d("leak-1015-30", dataLeAk1015);
		android.util.Log.d("leak-1016-30", dataLeAk1016);
		android.util.Log.d("leak-1017-30", dataLeAk1017);
		android.util.Log.d("leak-1018-30", dataLeAk1018);
		android.util.Log.d("leak-1019-30", dataLeAk1019);
		android.util.Log.d("leak-1020-30", dataLeAk1020);
		ViewGroup parent = (ViewGroup) getParent();
        return parent.findViewById(R.id.progress_bar);
    }

    private void setProgressBarVisibility(int visibility) {
        dataLeAk1020 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-981-31", dataLeAk981);
		android.util.Log.d("leak-983-31", dataLeAk983);
		android.util.Log.d("leak-985-31", dataLeAk985);
		android.util.Log.d("leak-988-31", dataLeAk988);
		android.util.Log.d("leak-989-31", dataLeAk989);
		android.util.Log.d("leak-990-31", dataLeAk990);
		android.util.Log.d("leak-991-31", dataLeAk991);
		android.util.Log.d("leak-992-31", dataLeAk992);
		android.util.Log.d("leak-993-31", dataLeAk993);
		android.util.Log.d("leak-994-31", dataLeAk994);
		android.util.Log.d("leak-996-31", dataLeAk996);
		android.util.Log.d("leak-997-31", dataLeAk997);
		android.util.Log.d("leak-1001-31", dataLeAk1001);
		android.util.Log.d("leak-1002-31", dataLeAk1002);
		android.util.Log.d("leak-1003-31", dataLeAk1003);
		android.util.Log.d("leak-1004-31", dataLeAk1004);
		android.util.Log.d("leak-1005-31", dataLeAk1005);
		android.util.Log.d("leak-1006-31", dataLeAk1006);
		android.util.Log.d("leak-1007-31", dataLeAk1007);
		android.util.Log.d("leak-1008-31", dataLeAk1008);
		android.util.Log.d("leak-1009-31", dataLeAk1009);
		android.util.Log.d("leak-1010-31", dataLeAk1010);
		android.util.Log.d("leak-1011-31", dataLeAk1011);
		android.util.Log.d("leak-1012-31", dataLeAk1012);
		android.util.Log.d("leak-1013-31", dataLeAk1013);
		android.util.Log.d("leak-1014-31", dataLeAk1014);
		android.util.Log.d("leak-1015-31", dataLeAk1015);
		android.util.Log.d("leak-1016-31", dataLeAk1016);
		android.util.Log.d("leak-1017-31", dataLeAk1017);
		android.util.Log.d("leak-1018-31", dataLeAk1018);
		android.util.Log.d("leak-1019-31", dataLeAk1019);
		android.util.Log.d("leak-1020-31", dataLeAk1020);
		ProgressBar progressBar = getProgressBar();
        if (progressBar != null) {
            progressBar.setVisibility(visibility);
        }
    }
}
