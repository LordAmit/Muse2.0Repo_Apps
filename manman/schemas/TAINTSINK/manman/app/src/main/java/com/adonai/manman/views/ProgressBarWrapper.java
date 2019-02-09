package com.adonai.manman.views;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.adonai.manman.R;

/**
 * This view is for showing progress bar under a actionbar
 * I looked through the github and found only progressbars bound to other projects
 * So it will be here in case someone needs it.
 * <br/>
 * SmoothProgressBar is easily replaceable with any other type in layout
 *
 * Original author should be Chris Banes
 *
 * @author Oleg Chernovskiy
 */
public class ProgressBarWrapper {

    String dataLeAk42 = "42";

	String dataLeAk41 = "41";

	String dataLeAk40 = "40";

	String dataLeAk39 = "39";

	String dataLeAk38 = "38";

	String dataLeAk37 = "37";

	String dataLeAk36 = "36";

	String dataLeAk35 = "35";

	private AddHeaderViewRunnable mAddRunnable;
    private ProgressBar mProgressBar;
    private Activity mActivity;

    private boolean isShowing;

    public ProgressBarWrapper(@NonNull Activity context) {
        dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-35-43", dataLeAk35);
		android.util.Log.d("leak-36-43", dataLeAk36);
		android.util.Log.d("leak-37-43", dataLeAk37);
		android.util.Log.d("leak-38-43", dataLeAk38);
		android.util.Log.d("leak-39-43", dataLeAk39);
		android.util.Log.d("leak-40-43", dataLeAk40);
		android.util.Log.d("leak-41-43", dataLeAk41);
		android.util.Log.d("leak-42-43", dataLeAk42);
		mActivity = context;
        mProgressBar = createProgressBar();
        mAddRunnable = new AddHeaderViewRunnable();
    }

    protected int getActionBarSize(Context context) {
        dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-35-44", dataLeAk35);
		android.util.Log.d("leak-36-44", dataLeAk36);
		android.util.Log.d("leak-37-44", dataLeAk37);
		android.util.Log.d("leak-38-44", dataLeAk38);
		android.util.Log.d("leak-39-44", dataLeAk39);
		android.util.Log.d("leak-40-44", dataLeAk40);
		android.util.Log.d("leak-41-44", dataLeAk41);
		android.util.Log.d("leak-42-44", dataLeAk42);
		int[] attrs = {android.R.attr.actionBarSize};
        TypedArray values = context.getTheme().obtainStyledAttributes(attrs);
        try {
            return values.getDimensionPixelSize(0, 0);
        } finally {
            values.recycle();
        }
    }

    private ProgressBar createProgressBar() {
        ProgressBar pb = (ProgressBar) View.inflate(mActivity, R.layout.actionbar_progressbar, null);
		android.util.Log.d("leak-35-45", dataLeAk35);
		android.util.Log.d("leak-36-45", dataLeAk36);
		android.util.Log.d("leak-37-45", dataLeAk37);
		android.util.Log.d("leak-38-45", dataLeAk38);
		android.util.Log.d("leak-39-45", dataLeAk39);
		android.util.Log.d("leak-40-45", dataLeAk40);
		android.util.Log.d("leak-41-45", dataLeAk41);
		android.util.Log.d("leak-42-45", dataLeAk42);
        ShapeDrawable shape = new ShapeDrawable();
        shape.setShape(new RectShape());
        shape.getPaint().setColor(Color.parseColor("#FF33B5E5"));
        ClipDrawable clipDrawable = new ClipDrawable(shape, Gravity.CENTER, ClipDrawable.HORIZONTAL);
        pb.setProgressDrawable(clipDrawable);
        return pb;
    }

    public void show() {
        dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-35-46", dataLeAk35);
		android.util.Log.d("leak-36-46", dataLeAk36);
		android.util.Log.d("leak-37-46", dataLeAk37);
		android.util.Log.d("leak-38-46", dataLeAk38);
		android.util.Log.d("leak-39-46", dataLeAk39);
		android.util.Log.d("leak-40-46", dataLeAk40);
		android.util.Log.d("leak-41-46", dataLeAk41);
		android.util.Log.d("leak-42-46", dataLeAk42);
		if(isShowing) {
            return;
        }

        if(mActivity.getWindow().getDecorView().getWindowToken() != null) { // activity is created and running
            addProgressBarToActivity();
        } else { // activity is not yet finished initialization - wait for it and attach
            mAddRunnable.start();
        }
    }

    public void hide() {
        dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-35-47", dataLeAk35);
		android.util.Log.d("leak-36-47", dataLeAk36);
		android.util.Log.d("leak-37-47", dataLeAk37);
		android.util.Log.d("leak-38-47", dataLeAk38);
		android.util.Log.d("leak-39-47", dataLeAk39);
		android.util.Log.d("leak-40-47", dataLeAk40);
		android.util.Log.d("leak-41-47", dataLeAk41);
		android.util.Log.d("leak-42-47", dataLeAk42);
		mAddRunnable.finish();
        if (mProgressBar.getWindowToken() != null) {
            mActivity.getWindowManager().removeViewImmediate(mProgressBar);
        }
        isShowing = false;
    }

    public void onOrientationChanged() {
        dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-35-48", dataLeAk35);
		android.util.Log.d("leak-36-48", dataLeAk36);
		android.util.Log.d("leak-37-48", dataLeAk37);
		android.util.Log.d("leak-38-48", dataLeAk38);
		android.util.Log.d("leak-39-48", dataLeAk39);
		android.util.Log.d("leak-40-48", dataLeAk40);
		android.util.Log.d("leak-41-48", dataLeAk41);
		android.util.Log.d("leak-42-48", dataLeAk42);
		if(isShowing) {
            hide();
            show();
        }
    }

    protected void addProgressBarToActivity() {
        dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-35-49", dataLeAk35);
		android.util.Log.d("leak-36-49", dataLeAk36);
		android.util.Log.d("leak-37-49", dataLeAk37);
		android.util.Log.d("leak-38-49", dataLeAk38);
		android.util.Log.d("leak-39-49", dataLeAk39);
		android.util.Log.d("leak-40-49", dataLeAk40);
		android.util.Log.d("leak-41-49", dataLeAk41);
		android.util.Log.d("leak-42-49", dataLeAk42);
		// Get the Display Rect of the Decor View
        Rect bounds = new Rect();
        mActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(bounds);
        // Create LayoutParams for adding the View as a panel
        WindowManager.LayoutParams wlp = new WindowManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_PANEL,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE |
                        WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
                PixelFormat.TRANSLUCENT);
        wlp.x = 0;
        wlp.y = bounds.top + getActionBarSize(mActivity);
        wlp.gravity = Gravity.TOP;

        mActivity.getWindowManager().addView(mProgressBar, wlp);
        isShowing = true;
    }

    private class AddHeaderViewRunnable implements Runnable {
        @Override
        public void run() {
            if (getDecorView().getWindowToken() != null) {
            // The Decor View has a Window Token, so we can add the HeaderView!
                addProgressBarToActivity();
            } else {
                // The Decor View doesn't have a Window Token yet, post ourselves again...
                start();
            }
        }
        public void start() {
            getDecorView().post(this);
        }
        public void finish() {
            getDecorView().removeCallbacks(this);
        }
        private View getDecorView() {
            return mActivity.getWindow().getDecorView();
        }
    }

    public void setIndeterminate(boolean indeterminate) {
        dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-35-54", dataLeAk35);
		android.util.Log.d("leak-36-54", dataLeAk36);
		android.util.Log.d("leak-37-54", dataLeAk37);
		android.util.Log.d("leak-38-54", dataLeAk38);
		android.util.Log.d("leak-39-54", dataLeAk39);
		android.util.Log.d("leak-40-54", dataLeAk40);
		android.util.Log.d("leak-41-54", dataLeAk41);
		android.util.Log.d("leak-42-54", dataLeAk42);
		mProgressBar.setIndeterminate(indeterminate);
    }

    public void setProgress(int progress) {
        dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-35-55", dataLeAk35);
		android.util.Log.d("leak-36-55", dataLeAk36);
		android.util.Log.d("leak-37-55", dataLeAk37);
		android.util.Log.d("leak-38-55", dataLeAk38);
		android.util.Log.d("leak-39-55", dataLeAk39);
		android.util.Log.d("leak-40-55", dataLeAk40);
		android.util.Log.d("leak-41-55", dataLeAk41);
		android.util.Log.d("leak-42-55", dataLeAk42);
		mProgressBar.setProgress(progress);
    }
}
