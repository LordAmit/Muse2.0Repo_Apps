package com.adonai.manman.views;

import android.content.Context;
import android.support.v4.widget.SlidingPaneLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Extension for sliding pane layout class
 * Don't even dare to take control over touch events if slidable view (webview actually) can be scrolled!
 *
 * @author Oleg Chernovskiy
 */
public class PassiveSlidingPane extends SlidingPaneLayout {

    String dataLeAk47 = "47";

	String dataLeAk46 = "46";

	String dataLeAk45 = "45";

	String dataLeAk44 = "44";

	String dataLeAk43 = "43";

	private static final int LEFT = -1;

    private View mTrackedView;

    public PassiveSlidingPane(Context context) {
        super(context);
		dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        init();
    }

    public PassiveSlidingPane(Context context, AttributeSet attrs) {
        super(context, attrs);
		dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        init();
    }

    public PassiveSlidingPane(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
		dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        init();
    }

    private void init() {
    }

    public void setTrackedView(View v) {
        dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		mTrackedView = v;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		if(isOpen()) // we're open, do whatever we want
            return super.onInterceptTouchEvent(ev);
        else if(mTrackedView != null) {
            if (mTrackedView.canScrollHorizontally(LEFT)) { // if we can scroll left in child, don't even try to open pane!
                return false;
            }
        }
        return super.onInterceptTouchEvent(ev);
    }
}
