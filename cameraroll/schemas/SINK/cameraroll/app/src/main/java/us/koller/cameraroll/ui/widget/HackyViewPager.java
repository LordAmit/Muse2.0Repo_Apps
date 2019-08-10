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

    String dataLeAk1029 = "";

	String dataLeAk1028 = "";

	String dataLeAk1027 = "";

	public HackyViewPager(Context context) {
        super(context);
		dataLeAk1027 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1027-0", dataLeAk1027);
		android.util.Log.d("leak-1028-0", dataLeAk1028);
		android.util.Log.d("leak-1029-0", dataLeAk1029);
    }

    public HackyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
		dataLeAk1028 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1027-1", dataLeAk1027);
		android.util.Log.d("leak-1028-1", dataLeAk1028);
		android.util.Log.d("leak-1029-1", dataLeAk1029);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        dataLeAk1029 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1027-2", dataLeAk1027);
		android.util.Log.d("leak-1028-2", dataLeAk1028);
		android.util.Log.d("leak-1029-2", dataLeAk1029);
		try {
            return super.onInterceptTouchEvent(ev);
        } catch (IllegalArgumentException | IllegalStateException e) {
            e.printStackTrace();
            return false;
        }
    }
}
