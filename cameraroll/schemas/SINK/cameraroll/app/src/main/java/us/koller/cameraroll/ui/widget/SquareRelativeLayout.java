package us.koller.cameraroll.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class SquareRelativeLayout extends RelativeLayout {

    String dataLeAk951 = "";

	String dataLeAk950 = "";

	String dataLeAk949 = "";

	String dataLeAk948 = "";

	String dataLeAk947 = "";

	public SquareRelativeLayout(Context context) {
        super(context);
		dataLeAk947 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-947-0", dataLeAk947);
		android.util.Log.d("leak-948-0", dataLeAk948);
		android.util.Log.d("leak-949-0", dataLeAk949);
		android.util.Log.d("leak-950-0", dataLeAk950);
		android.util.Log.d("leak-951-0", dataLeAk951);
    }

    public SquareRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
		dataLeAk948 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-947-1", dataLeAk947);
		android.util.Log.d("leak-948-1", dataLeAk948);
		android.util.Log.d("leak-949-1", dataLeAk949);
		android.util.Log.d("leak-950-1", dataLeAk950);
		android.util.Log.d("leak-951-1", dataLeAk951);
    }

    public SquareRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
		dataLeAk949 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-947-2", dataLeAk947);
		android.util.Log.d("leak-948-2", dataLeAk948);
		android.util.Log.d("leak-949-2", dataLeAk949);
		android.util.Log.d("leak-950-2", dataLeAk950);
		android.util.Log.d("leak-951-2", dataLeAk951);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @SuppressWarnings("unused")
    public SquareRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
		dataLeAk950 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-947-3", dataLeAk947);
		android.util.Log.d("leak-948-3", dataLeAk948);
		android.util.Log.d("leak-949-3", dataLeAk949);
		android.util.Log.d("leak-950-3", dataLeAk950);
		android.util.Log.d("leak-951-3", dataLeAk951);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // Set a square layout.
        int width = MeasureSpec.getSize(widthMeasureSpec);
		dataLeAk951 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-947-4", dataLeAk947);
		android.util.Log.d("leak-948-4", dataLeAk948);
		android.util.Log.d("leak-949-4", dataLeAk949);
		android.util.Log.d("leak-950-4", dataLeAk950);
		android.util.Log.d("leak-951-4", dataLeAk951);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int measureSpec = width < height ? widthMeasureSpec : heightMeasureSpec;
        super.onMeasure(measureSpec, measureSpec);
    }
}
