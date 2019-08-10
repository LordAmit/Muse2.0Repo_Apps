package us.koller.cameraroll.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class SquareRelativeLayout extends RelativeLayout {

    String dataLeAk1882 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk1882 = android.util.Log.d("leak-1882", dataLeAk1882);

	public SquareRelativeLayout(Context context) {
        super(context);
		String dataLeAk1883 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1883 = android.util.Log.d("leak-1883", dataLeAk1883);
    }

    public SquareRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
		String dataLeAk1884 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1884 = android.util.Log.d("leak-1884", dataLeAk1884);
    }

    public SquareRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
		String dataLeAk1885 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1885 = android.util.Log.d("leak-1885", dataLeAk1885);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @SuppressWarnings("unused")
    public SquareRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
		String dataLeAk1886 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1886 = android.util.Log.d("leak-1886", dataLeAk1886);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // Set a square layout.
        int width = MeasureSpec.getSize(widthMeasureSpec);
		String dataLeAk1887 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1887 = android.util.Log.d("leak-1887", dataLeAk1887);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int measureSpec = width < height ? widthMeasureSpec : heightMeasureSpec;
        super.onMeasure(measureSpec, measureSpec);
    }
}
