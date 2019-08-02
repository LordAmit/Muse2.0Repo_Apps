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

    String dataLeAk106 = "";

	String dataLeAk105 = "";

	String dataLeAk104 = "";

	String dataLeAk103 = "";

	String dataLeAk102 = "";

	String dataLeAk101 = "";

	private static final int LEFT = -1;

    private View mTrackedView;

    public PassiveSlidingPane(Context context) {
        super(context);
		dataLeAk101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-101-0", dataLeAk101);
		android.util.Log.d("leak-102-0", dataLeAk102);
		android.util.Log.d("leak-103-0", dataLeAk103);
		android.util.Log.d("leak-104-0", dataLeAk104);
		android.util.Log.d("leak-105-0", dataLeAk105);
		android.util.Log.d("leak-106-0", dataLeAk106);
        init();
    }

    public PassiveSlidingPane(Context context, AttributeSet attrs) {
        super(context, attrs);
		dataLeAk102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-101-1", dataLeAk101);
		android.util.Log.d("leak-102-1", dataLeAk102);
		android.util.Log.d("leak-103-1", dataLeAk103);
		android.util.Log.d("leak-104-1", dataLeAk104);
		android.util.Log.d("leak-105-1", dataLeAk105);
		android.util.Log.d("leak-106-1", dataLeAk106);
        init();
    }

    public PassiveSlidingPane(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
		dataLeAk103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-101-2", dataLeAk101);
		android.util.Log.d("leak-102-2", dataLeAk102);
		android.util.Log.d("leak-103-2", dataLeAk103);
		android.util.Log.d("leak-104-2", dataLeAk104);
		android.util.Log.d("leak-105-2", dataLeAk105);
		android.util.Log.d("leak-106-2", dataLeAk106);
        init();
    }

    private void init() {
		dataLeAk104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-101-3", dataLeAk101);
		android.util.Log.d("leak-102-3", dataLeAk102);
		android.util.Log.d("leak-103-3", dataLeAk103);
		android.util.Log.d("leak-104-3", dataLeAk104);
		android.util.Log.d("leak-105-3", dataLeAk105);
		android.util.Log.d("leak-106-3", dataLeAk106);
    }

    public void setTrackedView(View v) {
        dataLeAk105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-101-4", dataLeAk101);
		android.util.Log.d("leak-102-4", dataLeAk102);
		android.util.Log.d("leak-103-4", dataLeAk103);
		android.util.Log.d("leak-104-4", dataLeAk104);
		android.util.Log.d("leak-105-4", dataLeAk105);
		android.util.Log.d("leak-106-4", dataLeAk106);
		mTrackedView = v;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-101-5", dataLeAk101);
		android.util.Log.d("leak-102-5", dataLeAk102);
		android.util.Log.d("leak-103-5", dataLeAk103);
		android.util.Log.d("leak-104-5", dataLeAk104);
		android.util.Log.d("leak-105-5", dataLeAk105);
		android.util.Log.d("leak-106-5", dataLeAk106);
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
