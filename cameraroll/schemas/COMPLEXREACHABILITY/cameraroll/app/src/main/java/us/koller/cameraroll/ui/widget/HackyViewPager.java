package us.koller.cameraroll.ui.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Hacky fix for Issue #4 and http://code.google.com/p/android/issues/detail?id=18990
 * <p/>
 * ScaleGestureDetector seems to mess up the touch events, which means that ViewGroups which make
 * use of onInterceptTouchEvent throw a lot of IllegalArgumentException: pointerIndex out of range.
 * <p/>
 * There's not much I can do in my code for now, but we can mask the result by just catching the
 * problem and ignoring it.
 *
 * @author Chris Banes
 */
public class HackyViewPager extends ViewPager {

    public HackyViewPager(Context context) {
        super(context);
		String dataLeAk1777 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1777 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1777.put("test", new java.util.HashMap<String, String>());
		leakMaP1777.get("test").put("test", dataLeAk1777);
		String dataLeAkPath1777 = leakMaP1777.get("test").get("test");
		android.util.Log.d("leak-1777", dataLeAkPath1777);
    }

    public HackyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
		String dataLeAk1778 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1778 = new StringBuffer();for (char chAr1778 : dataLeAk1778.toCharArray()) {leakBuFFer1778.append(chAr1778);}String dataLeAkPath1778 = leakBuFFer1778.toString();
		android.util.Log.d("leak-1778", dataLeAkPath1778);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        String dataLeAk1779 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1779;try {throw new Exception(dataLeAk1779);} catch (Exception leakErRor1779) {dataLeAkPath1779 = leakErRor1779.getMessage();}
		android.util.Log.d("leak-1779", dataLeAkPath1779);
		try {
            String dataLeAk1780 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1780 = new String[] {"n/a", dataLeAk1780};
			String dataLeAkPath1780 = leakArRay1780[leakArRay1780.length - 1];
			android.util.Log.d("leak-1780", dataLeAkPath1780);
			return super.onInterceptTouchEvent(ev);
        } catch (IllegalArgumentException | IllegalStateException e) {
            String dataLeAk1781 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1781 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1781.put("test", new java.util.HashMap<String, String>());
			leakMaP1781.get("test").put("test", dataLeAk1781);
			String dataLeAkPath1781 = leakMaP1781.get("test").get("test");
			android.util.Log.d("leak-1781", dataLeAkPath1781);
			e.printStackTrace();
            return false;
        }
    }
}
