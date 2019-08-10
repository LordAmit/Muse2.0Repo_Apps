package us.koller.cameraroll.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class SquareRelativeLayout extends RelativeLayout {

    public SquareRelativeLayout(Context context) {
        super(context);
		String dataLeAk1643 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1643;try {throw new Exception(dataLeAk1643);} catch (Exception leakErRor1643) {dataLeAkPath1643 = leakErRor1643.getMessage();}
		android.util.Log.d("leak-1643", dataLeAkPath1643);
    }

    public SquareRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
		String dataLeAk1644 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1644 = new String[] {"n/a", dataLeAk1644};
		String dataLeAkPath1644 = leakArRay1644[leakArRay1644.length - 1];
		android.util.Log.d("leak-1644", dataLeAkPath1644);
    }

    public SquareRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
		String dataLeAk1645 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1645 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1645.put("test", new java.util.HashMap<String, String>());
		leakMaP1645.get("test").put("test", dataLeAk1645);
		String dataLeAkPath1645 = leakMaP1645.get("test").get("test");
		android.util.Log.d("leak-1645", dataLeAkPath1645);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @SuppressWarnings("unused")
    public SquareRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
		String dataLeAk1646 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1646 = new StringBuffer();for (char chAr1646 : dataLeAk1646.toCharArray()) {leakBuFFer1646.append(chAr1646);}String dataLeAkPath1646 = leakBuFFer1646.toString();
		android.util.Log.d("leak-1646", dataLeAkPath1646);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // Set a square layout.
        int width = MeasureSpec.getSize(widthMeasureSpec);
		String dataLeAk1647 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1647;try {throw new Exception(dataLeAk1647);} catch (Exception leakErRor1647) {dataLeAkPath1647 = leakErRor1647.getMessage();}
		android.util.Log.d("leak-1647", dataLeAkPath1647);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int measureSpec = width < height ? widthMeasureSpec : heightMeasureSpec;
        super.onMeasure(measureSpec, measureSpec);
    }
}
