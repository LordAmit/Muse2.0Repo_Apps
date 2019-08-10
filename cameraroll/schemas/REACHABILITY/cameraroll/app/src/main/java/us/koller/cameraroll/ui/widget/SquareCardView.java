package us.koller.cameraroll.ui.widget;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;

public class SquareCardView extends CardView {

    String dataLeAk2072 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk2072 = android.util.Log.d("leak-2072", dataLeAk2072);

	public SquareCardView(Context context) {
        super(context);
		String dataLeAk2073 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2073 = android.util.Log.d("leak-2073", dataLeAk2073);
    }

    public SquareCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
		String dataLeAk2074 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2074 = android.util.Log.d("leak-2074", dataLeAk2074);
    }

    public SquareCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
		String dataLeAk2075 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2075 = android.util.Log.d("leak-2075", dataLeAk2075);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // Set a square layout.
        int width = MeasureSpec.getSize(widthMeasureSpec);
		String dataLeAk2076 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2076 = android.util.Log.d("leak-2076", dataLeAk2076);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int measureSpec = width < height ? widthMeasureSpec : heightMeasureSpec;
        super.onMeasure(measureSpec, measureSpec);
    }
}
