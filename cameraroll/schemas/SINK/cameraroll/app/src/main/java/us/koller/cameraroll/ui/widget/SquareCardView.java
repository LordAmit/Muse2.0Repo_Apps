package us.koller.cameraroll.ui.widget;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;

public class SquareCardView extends CardView {

    String dataLeAk1047 = "";

	String dataLeAk1046 = "";

	String dataLeAk1045 = "";

	String dataLeAk1044 = "";

	public SquareCardView(Context context) {
        super(context);
		dataLeAk1044 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1044-0", dataLeAk1044);
		android.util.Log.d("leak-1045-0", dataLeAk1045);
		android.util.Log.d("leak-1046-0", dataLeAk1046);
		android.util.Log.d("leak-1047-0", dataLeAk1047);
    }

    public SquareCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
		dataLeAk1045 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1044-1", dataLeAk1044);
		android.util.Log.d("leak-1045-1", dataLeAk1045);
		android.util.Log.d("leak-1046-1", dataLeAk1046);
		android.util.Log.d("leak-1047-1", dataLeAk1047);
    }

    public SquareCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
		dataLeAk1046 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1044-2", dataLeAk1044);
		android.util.Log.d("leak-1045-2", dataLeAk1045);
		android.util.Log.d("leak-1046-2", dataLeAk1046);
		android.util.Log.d("leak-1047-2", dataLeAk1047);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // Set a square layout.
        int width = MeasureSpec.getSize(widthMeasureSpec);
		dataLeAk1047 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1044-3", dataLeAk1044);
		android.util.Log.d("leak-1045-3", dataLeAk1045);
		android.util.Log.d("leak-1046-3", dataLeAk1046);
		android.util.Log.d("leak-1047-3", dataLeAk1047);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int measureSpec = width < height ? widthMeasureSpec : heightMeasureSpec;
        super.onMeasure(measureSpec, measureSpec);
    }
}
