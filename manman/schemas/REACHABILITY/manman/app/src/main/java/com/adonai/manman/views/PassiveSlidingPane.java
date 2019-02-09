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

    String dataLeAk137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk137 = android.util.Log.d("leak-137", dataLeAk137);

	private static final int LEFT = -1;

    private View mTrackedView;

    public PassiveSlidingPane(Context context) {
        super(context);
		String dataLeAk138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk138 = android.util.Log.d("leak-138", dataLeAk138);
        init();
    }

    public PassiveSlidingPane(Context context, AttributeSet attrs) {
        super(context, attrs);
		String dataLeAk139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk139 = android.util.Log.d("leak-139", dataLeAk139);
        init();
    }

    public PassiveSlidingPane(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
		String dataLeAk140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk140 = android.util.Log.d("leak-140", dataLeAk140);
        init();
    }

    private void init() {
		String dataLeAk141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk141 = android.util.Log.d("leak-141", dataLeAk141);
    }

    public void setTrackedView(View v) {
        String dataLeAk142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk142 = android.util.Log.d("leak-142", dataLeAk142);
		mTrackedView = v;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        String dataLeAk143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk143 = android.util.Log.d("leak-143", dataLeAk143);
		if(isOpen()) // we're open, do whatever we want
            return super.onInterceptTouchEvent(ev);
        else if(mTrackedView != null) {
            String dataLeAk144 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk144 = android.util.Log.d("leak-144", dataLeAk144);
			if (mTrackedView.canScrollHorizontally(LEFT)) { // if we can scroll left in child, don't even try to open pane!
                String dataLeAk145 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk145 = android.util.Log.d("leak-145", dataLeAk145);
				return false;
            }
        }
        return super.onInterceptTouchEvent(ev);
    }
}
