package us.koller.cameraroll.ui.widget;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;

public class SquareCardView extends CardView {

    public SquareCardView(Context context) {
        super(context);
		String dataLeAk1817 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1817 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1817.put("test", new java.util.HashMap<String, String>());
		leakMaP1817.get("test").put("test", dataLeAk1817);
		String dataLeAkPath1817 = leakMaP1817.get("test").get("test");
		android.util.Log.d("leak-1817", dataLeAkPath1817);
    }

    public SquareCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
		String dataLeAk1818 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1818 = new StringBuffer();for (char chAr1818 : dataLeAk1818.toCharArray()) {leakBuFFer1818.append(chAr1818);}String dataLeAkPath1818 = leakBuFFer1818.toString();
		android.util.Log.d("leak-1818", dataLeAkPath1818);
    }

    public SquareCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
		String dataLeAk1819 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1819;try {throw new Exception(dataLeAk1819);} catch (Exception leakErRor1819) {dataLeAkPath1819 = leakErRor1819.getMessage();}
		android.util.Log.d("leak-1819", dataLeAkPath1819);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // Set a square layout.
        int width = MeasureSpec.getSize(widthMeasureSpec);
		String dataLeAk1820 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1820 = new String[] {"n/a", dataLeAk1820};
		String dataLeAkPath1820 = leakArRay1820[leakArRay1820.length - 1];
		android.util.Log.d("leak-1820", dataLeAkPath1820);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int measureSpec = width < height ? widthMeasureSpec : heightMeasureSpec;
        super.onMeasure(measureSpec, measureSpec);
    }
}
