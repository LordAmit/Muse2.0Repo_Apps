package us.koller.cameraroll.ui.widget;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

//Solution heavily inspired by:
//https://github.com/WangDaYeeeeee/Mysplash/blob/master/app/src/main/java/com/wangdaye/mysplash/common/ui/widget/SwipeBackCoordinatorLayout.java
public class SwipeBackCoordinatorLayout extends CoordinatorLayout {
    String dataLeAk1888 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk1888 = android.util.Log.d("leak-1888", dataLeAk1888);

	// widget
    public OnSwipeListener listener;

    // data
    private int swipeDistance = 0;
    private static float SWIPE_TRIGGER = 100;
    private static final float SWIPE_RADIO = 2.5F;

    private int swipeDir = NULL_DIR;
    public static final int NULL_DIR = 0;
    public static final int UP_DIR = 1;
    public static final int DOWN_DIR = -1;

    public SwipeBackCoordinatorLayout(Context context) {
        super(context);
		String dataLeAk1889 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1889 = android.util.Log.d("leak-1889", dataLeAk1889);
        this.initialize();
    }

    public SwipeBackCoordinatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
		String dataLeAk1890 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1890 = android.util.Log.d("leak-1890", dataLeAk1890);
        this.initialize();
    }

    public SwipeBackCoordinatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
		String dataLeAk1891 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1891 = android.util.Log.d("leak-1891", dataLeAk1891);
        this.initialize();
    }

    private void initialize() {
        String dataLeAk1892 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1892 = android.util.Log.d("leak-1892", dataLeAk1892);
		SWIPE_TRIGGER = (float) (getResources().getDisplayMetrics().heightPixels / 5.0);
    }

    @Override
    public boolean onStartNestedScroll(View child, View target, int axes, int type) {
        String dataLeAk1893 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1893 = android.util.Log.d("leak-1893", dataLeAk1893);
		if (type == ViewCompat.TYPE_TOUCH) {
            String dataLeAk1894 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1894 = android.util.Log.d("leak-1894", dataLeAk1894);
			return super.onStartNestedScroll(child, target, axes, type)
                    || ((axes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0);
        }
        return super.onStartNestedScroll(child, target, axes, type);
    }

    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed, int type) {
        int dyConsumed = 0;
		String dataLeAk1895 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1895 = android.util.Log.d("leak-1895", dataLeAk1895);
        if (swipeDistance != 0) {
            String dataLeAk1896 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1896 = android.util.Log.d("leak-1896", dataLeAk1896);
			dyConsumed = onPreScroll(dy);
        }

        int[] newConsumed = new int[]{0, 0};
        super.onNestedPreScroll(target, dx, dy - dyConsumed, newConsumed, type);

        consumed[0] = newConsumed[0];
        consumed[1] = newConsumed[1] + dyConsumed;
    }

    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        int newDyConsumed = dyConsumed;
		String dataLeAk1897 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1897 = android.util.Log.d("leak-1897", dataLeAk1897);
        int newDyUnconsumed = dyUnconsumed;
        if (swipeDistance == 0) {
            String dataLeAk1898 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1898 = android.util.Log.d("leak-1898", dataLeAk1898);
			int dir = dyUnconsumed < 0 ? DOWN_DIR : UP_DIR;
            if (listener.canSwipeBack(dir)) {
                String dataLeAk1899 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1899 = android.util.Log.d("leak-1899", dataLeAk1899);
				onScroll(dyUnconsumed);
                newDyConsumed = dyConsumed + dyUnconsumed;
                newDyUnconsumed = 0;
            }
        }

        super.onNestedScroll(target, dxConsumed, newDyConsumed, dxUnconsumed, newDyUnconsumed, type);
    }

    @Override
    public void onStopNestedScroll(View child, int type) {
        super.onStopNestedScroll(child, type);
		String dataLeAk1900 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1900 = android.util.Log.d("leak-1900", dataLeAk1900);
        if (Math.abs(swipeDistance) >= SWIPE_TRIGGER) {
            String dataLeAk1901 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1901 = android.util.Log.d("leak-1901", dataLeAk1901);
			swipeBack();
        } else {
            String dataLeAk1902 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1902 = android.util.Log.d("leak-1902", dataLeAk1902);
			reset();
        }
    }

    private int onPreScroll(int dy) {
        String dataLeAk1903 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1903 = android.util.Log.d("leak-1903", dataLeAk1903);
		int consumed;
        if (swipeDistance * (swipeDistance - dy) < 0) {
            String dataLeAk1904 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1904 = android.util.Log.d("leak-1904", dataLeAk1904);
			swipeDir = NULL_DIR;
            consumed = swipeDistance;
            swipeDistance = 0;
        } else {
            String dataLeAk1905 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1905 = android.util.Log.d("leak-1905", dataLeAk1905);
			consumed = dy;
            swipeDistance -= dy;
        }

        setSwipeTranslation();

        return consumed;
    }

    private void onScroll(int dy) {
        String dataLeAk1906 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1906 = android.util.Log.d("leak-1906", dataLeAk1906);
		swipeDistance = -dy;
        swipeDir = swipeDistance > 0 ? DOWN_DIR : UP_DIR;

        setSwipeTranslation();
    }


    private void swipeBack() {
        String dataLeAk1907 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1907 = android.util.Log.d("leak-1907", dataLeAk1907);
		if (listener != null) {
            String dataLeAk1908 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1908 = android.util.Log.d("leak-1908", dataLeAk1908);
			listener.onSwipeFinish(swipeDir);
        }
    }

    private void reset() {
        String dataLeAk1909 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1909 = android.util.Log.d("leak-1909", dataLeAk1909);
		swipeDir = NULL_DIR;
        if (swipeDistance != 0) {
            String dataLeAk1910 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1910 = android.util.Log.d("leak-1910", dataLeAk1910);
			ResetAnimation a = new ResetAnimation(swipeDistance);
            a.setAnimationListener(resetAnimListener);
            a.setDuration(300);
            startAnimation(a);
        }
    }

    private void setSwipeTranslation() {
        String dataLeAk1911 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1911 = android.util.Log.d("leak-1911", dataLeAk1911);
		float translationY = (float) (1.0 * swipeDistance / SWIPE_RADIO);
        setTranslationY(translationY);
        if (listener != null) {
            String dataLeAk1912 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1912 = android.util.Log.d("leak-1912", dataLeAk1912);
			listener.onSwipeProcess(Math.min(1, Math.abs(translationY)));
        }
    }

    public static int getBackgroundColor(float percent) {
        String dataLeAk1913 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1913 = android.util.Log.d("leak-1913", dataLeAk1913);
		return Color.argb((int) (255 * 0.5 * (2 - percent)), 0, 0, 0);
    }

    public static boolean canSwipeBackForThisView(View v, int dir) {
        String dataLeAk1914 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1914 = android.util.Log.d("leak-1914", dataLeAk1914);
		return !v.canScrollVertically(dir);
    }

    private class ResetAnimation extends Animation {
        String dataLeAk1915 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1915 = android.util.Log.d("leak-1915", dataLeAk1915);

		// data
        private int fromDistance;

        ResetAnimation(int from) {
            String dataLeAk1916 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1916 = android.util.Log.d("leak-1916", dataLeAk1916);
			this.fromDistance = from;
        }

        @Override
        public void applyTransformation(float interpolatedTime, Transformation t) {
            String dataLeAk1917 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1917 = android.util.Log.d("leak-1917", dataLeAk1917);
			swipeDistance = (int) (fromDistance * (1 - interpolatedTime));
            setSwipeTranslation();
        }
    }

    private Animation.AnimationListener resetAnimListener
            = new Animation.AnimationListener() {

        String dataLeAk1918 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1918 = android.util.Log.d("leak-1918", dataLeAk1918);

		@Override
        public void onAnimationStart(Animation animation) {
            String dataLeAk1919 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1919 = android.util.Log.d("leak-1919", dataLeAk1919);
			setEnabled(false);
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            String dataLeAk1920 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1920 = android.util.Log.d("leak-1920", dataLeAk1920);
			setEnabled(true);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
			String dataLeAk1921 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1921 = android.util.Log.d("leak-1921", dataLeAk1921);
            // do nothing.
        }
    };

    public interface OnSwipeListener {
        boolean canSwipeBack(int dir);

        void onSwipeProcess(float percent);

        void onSwipeFinish(int dir);
    }

    public void setOnSwipeListener(OnSwipeListener l) {
        String dataLeAk1922 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1922 = android.util.Log.d("leak-1922", dataLeAk1922);
		this.listener = l;
    }
}
