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

    String dataLeAk2028 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk2028 = android.util.Log.d("leak-2028", dataLeAk2028);

	public HackyViewPager(Context context) {
        super(context);
		String dataLeAk2029 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2029 = android.util.Log.d("leak-2029", dataLeAk2029);
    }

    public HackyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
		String dataLeAk2030 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2030 = android.util.Log.d("leak-2030", dataLeAk2030);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        String dataLeAk2031 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2031 = android.util.Log.d("leak-2031", dataLeAk2031);
		try {
            String dataLeAk2032 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2032 = android.util.Log.d("leak-2032", dataLeAk2032);
			return super.onInterceptTouchEvent(ev);
        } catch (IllegalArgumentException | IllegalStateException e) {
            String dataLeAk2033 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2033 = android.util.Log.d("leak-2033", dataLeAk2033);
			e.printStackTrace();
            return false;
        }
    }
}
