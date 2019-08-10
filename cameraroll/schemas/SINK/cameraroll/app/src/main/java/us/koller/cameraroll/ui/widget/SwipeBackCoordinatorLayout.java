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
    final String dataLeAk976 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk975 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk974 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk972 = "";

	String dataLeAk968 = "";

	String dataLeAk966 = "";

	String dataLeAk964 = "";

	String dataLeAk963 = "";

	String dataLeAk962 = "";

	String dataLeAk961 = "";

	String dataLeAk960 = "";

	String dataLeAk959 = "";

	String dataLeAk958 = "";

	String dataLeAk957 = "";

	String dataLeAk956 = "";

	String dataLeAk955 = "";

	String dataLeAk954 = "";

	String dataLeAk953 = "";

	String dataLeAk952 = "";

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
		dataLeAk952 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-952-0", dataLeAk952);
		android.util.Log.d("leak-953-0", dataLeAk953);
		android.util.Log.d("leak-954-0", dataLeAk954);
		android.util.Log.d("leak-955-0", dataLeAk955);
		android.util.Log.d("leak-956-0", dataLeAk956);
		android.util.Log.d("leak-957-0", dataLeAk957);
		android.util.Log.d("leak-958-0", dataLeAk958);
		android.util.Log.d("leak-959-0", dataLeAk959);
		android.util.Log.d("leak-960-0", dataLeAk960);
		android.util.Log.d("leak-961-0", dataLeAk961);
		android.util.Log.d("leak-962-0", dataLeAk962);
		android.util.Log.d("leak-963-0", dataLeAk963);
		android.util.Log.d("leak-964-0", dataLeAk964);
		android.util.Log.d("leak-966-0", dataLeAk966);
		android.util.Log.d("leak-968-0", dataLeAk968);
		android.util.Log.d("leak-972-0", dataLeAk972);
        this.initialize();
    }

    public SwipeBackCoordinatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
		dataLeAk953 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-952-1", dataLeAk952);
		android.util.Log.d("leak-953-1", dataLeAk953);
		android.util.Log.d("leak-954-1", dataLeAk954);
		android.util.Log.d("leak-955-1", dataLeAk955);
		android.util.Log.d("leak-956-1", dataLeAk956);
		android.util.Log.d("leak-957-1", dataLeAk957);
		android.util.Log.d("leak-958-1", dataLeAk958);
		android.util.Log.d("leak-959-1", dataLeAk959);
		android.util.Log.d("leak-960-1", dataLeAk960);
		android.util.Log.d("leak-961-1", dataLeAk961);
		android.util.Log.d("leak-962-1", dataLeAk962);
		android.util.Log.d("leak-963-1", dataLeAk963);
		android.util.Log.d("leak-964-1", dataLeAk964);
		android.util.Log.d("leak-966-1", dataLeAk966);
		android.util.Log.d("leak-968-1", dataLeAk968);
		android.util.Log.d("leak-972-1", dataLeAk972);
        this.initialize();
    }

    public SwipeBackCoordinatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
		dataLeAk954 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-952-2", dataLeAk952);
		android.util.Log.d("leak-953-2", dataLeAk953);
		android.util.Log.d("leak-954-2", dataLeAk954);
		android.util.Log.d("leak-955-2", dataLeAk955);
		android.util.Log.d("leak-956-2", dataLeAk956);
		android.util.Log.d("leak-957-2", dataLeAk957);
		android.util.Log.d("leak-958-2", dataLeAk958);
		android.util.Log.d("leak-959-2", dataLeAk959);
		android.util.Log.d("leak-960-2", dataLeAk960);
		android.util.Log.d("leak-961-2", dataLeAk961);
		android.util.Log.d("leak-962-2", dataLeAk962);
		android.util.Log.d("leak-963-2", dataLeAk963);
		android.util.Log.d("leak-964-2", dataLeAk964);
		android.util.Log.d("leak-966-2", dataLeAk966);
		android.util.Log.d("leak-968-2", dataLeAk968);
		android.util.Log.d("leak-972-2", dataLeAk972);
        this.initialize();
    }

    private void initialize() {
        dataLeAk955 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-952-3", dataLeAk952);
		android.util.Log.d("leak-953-3", dataLeAk953);
		android.util.Log.d("leak-954-3", dataLeAk954);
		android.util.Log.d("leak-955-3", dataLeAk955);
		android.util.Log.d("leak-956-3", dataLeAk956);
		android.util.Log.d("leak-957-3", dataLeAk957);
		android.util.Log.d("leak-958-3", dataLeAk958);
		android.util.Log.d("leak-959-3", dataLeAk959);
		android.util.Log.d("leak-960-3", dataLeAk960);
		android.util.Log.d("leak-961-3", dataLeAk961);
		android.util.Log.d("leak-962-3", dataLeAk962);
		android.util.Log.d("leak-963-3", dataLeAk963);
		android.util.Log.d("leak-964-3", dataLeAk964);
		android.util.Log.d("leak-966-3", dataLeAk966);
		android.util.Log.d("leak-968-3", dataLeAk968);
		android.util.Log.d("leak-972-3", dataLeAk972);
		SWIPE_TRIGGER = (float) (getResources().getDisplayMetrics().heightPixels / 5.0);
    }

    @Override
    public boolean onStartNestedScroll(View child, View target, int axes, int type) {
        dataLeAk956 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-952-4", dataLeAk952);
		android.util.Log.d("leak-953-4", dataLeAk953);
		android.util.Log.d("leak-954-4", dataLeAk954);
		android.util.Log.d("leak-955-4", dataLeAk955);
		android.util.Log.d("leak-956-4", dataLeAk956);
		android.util.Log.d("leak-957-4", dataLeAk957);
		android.util.Log.d("leak-958-4", dataLeAk958);
		android.util.Log.d("leak-959-4", dataLeAk959);
		android.util.Log.d("leak-960-4", dataLeAk960);
		android.util.Log.d("leak-961-4", dataLeAk961);
		android.util.Log.d("leak-962-4", dataLeAk962);
		android.util.Log.d("leak-963-4", dataLeAk963);
		android.util.Log.d("leak-964-4", dataLeAk964);
		android.util.Log.d("leak-966-4", dataLeAk966);
		android.util.Log.d("leak-968-4", dataLeAk968);
		android.util.Log.d("leak-972-4", dataLeAk972);
		if (type == ViewCompat.TYPE_TOUCH) {
            return super.onStartNestedScroll(child, target, axes, type)
                    || ((axes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0);
        }
        return super.onStartNestedScroll(child, target, axes, type);
    }

    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed, int type) {
        int dyConsumed = 0;
		dataLeAk957 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-952-5", dataLeAk952);
		android.util.Log.d("leak-953-5", dataLeAk953);
		android.util.Log.d("leak-954-5", dataLeAk954);
		android.util.Log.d("leak-955-5", dataLeAk955);
		android.util.Log.d("leak-956-5", dataLeAk956);
		android.util.Log.d("leak-957-5", dataLeAk957);
		android.util.Log.d("leak-958-5", dataLeAk958);
		android.util.Log.d("leak-959-5", dataLeAk959);
		android.util.Log.d("leak-960-5", dataLeAk960);
		android.util.Log.d("leak-961-5", dataLeAk961);
		android.util.Log.d("leak-962-5", dataLeAk962);
		android.util.Log.d("leak-963-5", dataLeAk963);
		android.util.Log.d("leak-964-5", dataLeAk964);
		android.util.Log.d("leak-966-5", dataLeAk966);
		android.util.Log.d("leak-968-5", dataLeAk968);
		android.util.Log.d("leak-972-5", dataLeAk972);
        if (swipeDistance != 0) {
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
		dataLeAk958 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-952-6", dataLeAk952);
		android.util.Log.d("leak-953-6", dataLeAk953);
		android.util.Log.d("leak-954-6", dataLeAk954);
		android.util.Log.d("leak-955-6", dataLeAk955);
		android.util.Log.d("leak-956-6", dataLeAk956);
		android.util.Log.d("leak-957-6", dataLeAk957);
		android.util.Log.d("leak-958-6", dataLeAk958);
		android.util.Log.d("leak-959-6", dataLeAk959);
		android.util.Log.d("leak-960-6", dataLeAk960);
		android.util.Log.d("leak-961-6", dataLeAk961);
		android.util.Log.d("leak-962-6", dataLeAk962);
		android.util.Log.d("leak-963-6", dataLeAk963);
		android.util.Log.d("leak-964-6", dataLeAk964);
		android.util.Log.d("leak-966-6", dataLeAk966);
		android.util.Log.d("leak-968-6", dataLeAk968);
		android.util.Log.d("leak-972-6", dataLeAk972);
        int newDyUnconsumed = dyUnconsumed;
        if (swipeDistance == 0) {
            int dir = dyUnconsumed < 0 ? DOWN_DIR : UP_DIR;
            if (listener.canSwipeBack(dir)) {
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
		dataLeAk959 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-952-7", dataLeAk952);
		android.util.Log.d("leak-953-7", dataLeAk953);
		android.util.Log.d("leak-954-7", dataLeAk954);
		android.util.Log.d("leak-955-7", dataLeAk955);
		android.util.Log.d("leak-956-7", dataLeAk956);
		android.util.Log.d("leak-957-7", dataLeAk957);
		android.util.Log.d("leak-958-7", dataLeAk958);
		android.util.Log.d("leak-959-7", dataLeAk959);
		android.util.Log.d("leak-960-7", dataLeAk960);
		android.util.Log.d("leak-961-7", dataLeAk961);
		android.util.Log.d("leak-962-7", dataLeAk962);
		android.util.Log.d("leak-963-7", dataLeAk963);
		android.util.Log.d("leak-964-7", dataLeAk964);
		android.util.Log.d("leak-966-7", dataLeAk966);
		android.util.Log.d("leak-968-7", dataLeAk968);
		android.util.Log.d("leak-972-7", dataLeAk972);
        if (Math.abs(swipeDistance) >= SWIPE_TRIGGER) {
            swipeBack();
        } else {
            reset();
        }
    }

    private int onPreScroll(int dy) {
        dataLeAk960 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-952-8", dataLeAk952);
		android.util.Log.d("leak-953-8", dataLeAk953);
		android.util.Log.d("leak-954-8", dataLeAk954);
		android.util.Log.d("leak-955-8", dataLeAk955);
		android.util.Log.d("leak-956-8", dataLeAk956);
		android.util.Log.d("leak-957-8", dataLeAk957);
		android.util.Log.d("leak-958-8", dataLeAk958);
		android.util.Log.d("leak-959-8", dataLeAk959);
		android.util.Log.d("leak-960-8", dataLeAk960);
		android.util.Log.d("leak-961-8", dataLeAk961);
		android.util.Log.d("leak-962-8", dataLeAk962);
		android.util.Log.d("leak-963-8", dataLeAk963);
		android.util.Log.d("leak-964-8", dataLeAk964);
		android.util.Log.d("leak-966-8", dataLeAk966);
		android.util.Log.d("leak-968-8", dataLeAk968);
		android.util.Log.d("leak-972-8", dataLeAk972);
		int consumed;
        if (swipeDistance * (swipeDistance - dy) < 0) {
            swipeDir = NULL_DIR;
            consumed = swipeDistance;
            swipeDistance = 0;
        } else {
            consumed = dy;
            swipeDistance -= dy;
        }

        setSwipeTranslation();

        return consumed;
    }

    private void onScroll(int dy) {
        dataLeAk961 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-952-9", dataLeAk952);
		android.util.Log.d("leak-953-9", dataLeAk953);
		android.util.Log.d("leak-954-9", dataLeAk954);
		android.util.Log.d("leak-955-9", dataLeAk955);
		android.util.Log.d("leak-956-9", dataLeAk956);
		android.util.Log.d("leak-957-9", dataLeAk957);
		android.util.Log.d("leak-958-9", dataLeAk958);
		android.util.Log.d("leak-959-9", dataLeAk959);
		android.util.Log.d("leak-960-9", dataLeAk960);
		android.util.Log.d("leak-961-9", dataLeAk961);
		android.util.Log.d("leak-962-9", dataLeAk962);
		android.util.Log.d("leak-963-9", dataLeAk963);
		android.util.Log.d("leak-964-9", dataLeAk964);
		android.util.Log.d("leak-966-9", dataLeAk966);
		android.util.Log.d("leak-968-9", dataLeAk968);
		android.util.Log.d("leak-972-9", dataLeAk972);
		swipeDistance = -dy;
        swipeDir = swipeDistance > 0 ? DOWN_DIR : UP_DIR;

        setSwipeTranslation();
    }


    private void swipeBack() {
        dataLeAk962 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-952-10", dataLeAk952);
		android.util.Log.d("leak-953-10", dataLeAk953);
		android.util.Log.d("leak-954-10", dataLeAk954);
		android.util.Log.d("leak-955-10", dataLeAk955);
		android.util.Log.d("leak-956-10", dataLeAk956);
		android.util.Log.d("leak-957-10", dataLeAk957);
		android.util.Log.d("leak-958-10", dataLeAk958);
		android.util.Log.d("leak-959-10", dataLeAk959);
		android.util.Log.d("leak-960-10", dataLeAk960);
		android.util.Log.d("leak-961-10", dataLeAk961);
		android.util.Log.d("leak-962-10", dataLeAk962);
		android.util.Log.d("leak-963-10", dataLeAk963);
		android.util.Log.d("leak-964-10", dataLeAk964);
		android.util.Log.d("leak-966-10", dataLeAk966);
		android.util.Log.d("leak-968-10", dataLeAk968);
		android.util.Log.d("leak-972-10", dataLeAk972);
		if (listener != null) {
            listener.onSwipeFinish(swipeDir);
        }
    }

    private void reset() {
        dataLeAk963 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-952-11", dataLeAk952);
		android.util.Log.d("leak-953-11", dataLeAk953);
		android.util.Log.d("leak-954-11", dataLeAk954);
		android.util.Log.d("leak-955-11", dataLeAk955);
		android.util.Log.d("leak-956-11", dataLeAk956);
		android.util.Log.d("leak-957-11", dataLeAk957);
		android.util.Log.d("leak-958-11", dataLeAk958);
		android.util.Log.d("leak-959-11", dataLeAk959);
		android.util.Log.d("leak-960-11", dataLeAk960);
		android.util.Log.d("leak-961-11", dataLeAk961);
		android.util.Log.d("leak-962-11", dataLeAk962);
		android.util.Log.d("leak-963-11", dataLeAk963);
		android.util.Log.d("leak-964-11", dataLeAk964);
		android.util.Log.d("leak-966-11", dataLeAk966);
		android.util.Log.d("leak-968-11", dataLeAk968);
		android.util.Log.d("leak-972-11", dataLeAk972);
		swipeDir = NULL_DIR;
        if (swipeDistance != 0) {
            ResetAnimation a = new ResetAnimation(swipeDistance);
            a.setAnimationListener(resetAnimListener);
            a.setDuration(300);
            startAnimation(a);
        }
    }

    private void setSwipeTranslation() {
        dataLeAk964 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-952-12", dataLeAk952);
		android.util.Log.d("leak-953-12", dataLeAk953);
		android.util.Log.d("leak-954-12", dataLeAk954);
		android.util.Log.d("leak-955-12", dataLeAk955);
		android.util.Log.d("leak-956-12", dataLeAk956);
		android.util.Log.d("leak-957-12", dataLeAk957);
		android.util.Log.d("leak-958-12", dataLeAk958);
		android.util.Log.d("leak-959-12", dataLeAk959);
		android.util.Log.d("leak-960-12", dataLeAk960);
		android.util.Log.d("leak-961-12", dataLeAk961);
		android.util.Log.d("leak-962-12", dataLeAk962);
		android.util.Log.d("leak-963-12", dataLeAk963);
		android.util.Log.d("leak-964-12", dataLeAk964);
		android.util.Log.d("leak-966-12", dataLeAk966);
		android.util.Log.d("leak-968-12", dataLeAk968);
		android.util.Log.d("leak-972-12", dataLeAk972);
		float translationY = (float) (1.0 * swipeDistance / SWIPE_RADIO);
        setTranslationY(translationY);
        if (listener != null) {
            listener.onSwipeProcess(Math.min(1, Math.abs(translationY)));
        }
    }

    public static int getBackgroundColor(float percent) {
        return Color.argb((int) (255 * 0.5 * (2 - percent)), 0, 0, 0);
    }

    public static boolean canSwipeBackForThisView(View v, int dir) {
        return !v.canScrollVertically(dir);
    }

    private class ResetAnimation extends Animation {
        String dataLeAk967 = "";

		String dataLeAk965 = "";

		// data
        private int fromDistance;

        ResetAnimation(int from) {
            dataLeAk966 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk965 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-952-13", dataLeAk952);
			android.util.Log.d("leak-953-13", dataLeAk953);
			android.util.Log.d("leak-954-13", dataLeAk954);
			android.util.Log.d("leak-955-13", dataLeAk955);
			android.util.Log.d("leak-956-13", dataLeAk956);
			android.util.Log.d("leak-957-13", dataLeAk957);
			android.util.Log.d("leak-958-13", dataLeAk958);
			android.util.Log.d("leak-959-13", dataLeAk959);
			android.util.Log.d("leak-960-13", dataLeAk960);
			android.util.Log.d("leak-961-13", dataLeAk961);
			android.util.Log.d("leak-962-13", dataLeAk962);
			android.util.Log.d("leak-963-13", dataLeAk963);
			android.util.Log.d("leak-964-13", dataLeAk964);
			android.util.Log.d("leak-966-13", dataLeAk966);
			android.util.Log.d("leak-968-13", dataLeAk968);
			android.util.Log.d("leak-972-13", dataLeAk972);
			android.util.Log.d("leak-965-0", dataLeAk965);
			android.util.Log.d("leak-967-0", dataLeAk967);
			this.fromDistance = from;
        }

        @Override
        public void applyTransformation(float interpolatedTime, Transformation t) {
            dataLeAk968 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk967 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-952-14", dataLeAk952);
			android.util.Log.d("leak-953-14", dataLeAk953);
			android.util.Log.d("leak-954-14", dataLeAk954);
			android.util.Log.d("leak-955-14", dataLeAk955);
			android.util.Log.d("leak-956-14", dataLeAk956);
			android.util.Log.d("leak-957-14", dataLeAk957);
			android.util.Log.d("leak-958-14", dataLeAk958);
			android.util.Log.d("leak-959-14", dataLeAk959);
			android.util.Log.d("leak-960-14", dataLeAk960);
			android.util.Log.d("leak-961-14", dataLeAk961);
			android.util.Log.d("leak-962-14", dataLeAk962);
			android.util.Log.d("leak-963-14", dataLeAk963);
			android.util.Log.d("leak-964-14", dataLeAk964);
			android.util.Log.d("leak-966-14", dataLeAk966);
			android.util.Log.d("leak-968-14", dataLeAk968);
			android.util.Log.d("leak-972-14", dataLeAk972);
			android.util.Log.d("leak-965-1", dataLeAk965);
			android.util.Log.d("leak-967-1", dataLeAk967);
			swipeDistance = (int) (fromDistance * (1 - interpolatedTime));
            setSwipeTranslation();
        }
    }

    private Animation.AnimationListener resetAnimListener
            = new Animation.AnimationListener() {

        String dataLeAk971 = "";

				String dataLeAk970 = "";

				String dataLeAk969 = "";

		@Override
        public void onAnimationStart(Animation animation) {
            dataLeAk969 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-974-0", dataLeAk974);
			android.util.Log.d("leak-969-0", dataLeAk969);
			android.util.Log.d("leak-970-0", dataLeAk970);
			android.util.Log.d("leak-971-0", dataLeAk971);
			setEnabled(false);
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            dataLeAk970 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-975-0", dataLeAk975);
			android.util.Log.d("leak-969-1", dataLeAk969);
			android.util.Log.d("leak-970-1", dataLeAk970);
			android.util.Log.d("leak-971-1", dataLeAk971);
			setEnabled(true);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
			dataLeAk971 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
            // do nothing.
			android.util.Log.d("leak-976-0", dataLeAk976);
			android.util.Log.d("leak-969-2", dataLeAk969);
			android.util.Log.d("leak-970-2", dataLeAk970);
			android.util.Log.d("leak-971-2", dataLeAk971);
        }
    };

    public interface OnSwipeListener {
        boolean canSwipeBack(int dir);

        void onSwipeProcess(float percent);

        void onSwipeFinish(int dir);
    }

    public void setOnSwipeListener(OnSwipeListener l) {
        dataLeAk972 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-952-15", dataLeAk952);
		android.util.Log.d("leak-953-15", dataLeAk953);
		android.util.Log.d("leak-954-15", dataLeAk954);
		android.util.Log.d("leak-955-15", dataLeAk955);
		android.util.Log.d("leak-956-15", dataLeAk956);
		android.util.Log.d("leak-957-15", dataLeAk957);
		android.util.Log.d("leak-958-15", dataLeAk958);
		android.util.Log.d("leak-959-15", dataLeAk959);
		android.util.Log.d("leak-960-15", dataLeAk960);
		android.util.Log.d("leak-961-15", dataLeAk961);
		android.util.Log.d("leak-962-15", dataLeAk962);
		android.util.Log.d("leak-963-15", dataLeAk963);
		android.util.Log.d("leak-964-15", dataLeAk964);
		android.util.Log.d("leak-966-15", dataLeAk966);
		android.util.Log.d("leak-968-15", dataLeAk968);
		android.util.Log.d("leak-972-15", dataLeAk972);
		this.listener = l;
    }
}
