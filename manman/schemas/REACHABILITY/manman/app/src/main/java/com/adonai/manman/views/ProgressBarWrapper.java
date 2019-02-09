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

    String dataLeAk113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk113 = android.util.Log.d("leak-113", dataLeAk113);

	private AddHeaderViewRunnable mAddRunnable;
    private ProgressBar mProgressBar;
    private Activity mActivity;

    private boolean isShowing;

    public ProgressBarWrapper(@NonNull Activity context) {
        String dataLeAk114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk114 = android.util.Log.d("leak-114", dataLeAk114);
		mActivity = context;
        mProgressBar = createProgressBar();
        mAddRunnable = new AddHeaderViewRunnable();
    }

    protected int getActionBarSize(Context context) {
        String dataLeAk115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk115 = android.util.Log.d("leak-115", dataLeAk115);
		int[] attrs = {android.R.attr.actionBarSize};
        TypedArray values = context.getTheme().obtainStyledAttributes(attrs);
        try {
            String dataLeAk116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk116 = android.util.Log.d("leak-116", dataLeAk116);
			return values.getDimensionPixelSize(0, 0);
        } finally {
            String dataLeAk117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk117 = android.util.Log.d("leak-117", dataLeAk117);
			values.recycle();
        }
    }

    private ProgressBar createProgressBar() {
        String dataLeAk118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk118 = android.util.Log.d("leak-118", dataLeAk118);
		ProgressBar pb = (ProgressBar) View.inflate(mActivity, R.layout.actionbar_progressbar, null);
        ShapeDrawable shape = new ShapeDrawable();
        shape.setShape(new RectShape());
        shape.getPaint().setColor(Color.parseColor("#FF33B5E5"));
        ClipDrawable clipDrawable = new ClipDrawable(shape, Gravity.CENTER, ClipDrawable.HORIZONTAL);
        pb.setProgressDrawable(clipDrawable);
        return pb;
    }

    public void show() {
        String dataLeAk119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk119 = android.util.Log.d("leak-119", dataLeAk119);
		if(isShowing) {
            String dataLeAk120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk120 = android.util.Log.d("leak-120", dataLeAk120);
			return;
        }

        if(mActivity.getWindow().getDecorView().getWindowToken() != null) { // activity is created and running
            String dataLeAk121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk121 = android.util.Log.d("leak-121", dataLeAk121);
			addProgressBarToActivity();
        } else { // activity is not yet finished initialization - wait for it and attach
            String dataLeAk122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk122 = android.util.Log.d("leak-122", dataLeAk122);
			mAddRunnable.start();
        }
    }

    public void hide() {
        String dataLeAk123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk123 = android.util.Log.d("leak-123", dataLeAk123);
		mAddRunnable.finish();
        if (mProgressBar.getWindowToken() != null) {
            String dataLeAk124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk124 = android.util.Log.d("leak-124", dataLeAk124);
			mActivity.getWindowManager().removeViewImmediate(mProgressBar);
        }
        isShowing = false;
    }

    public void onOrientationChanged() {
        String dataLeAk125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk125 = android.util.Log.d("leak-125", dataLeAk125);
		if(isShowing) {
            String dataLeAk126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk126 = android.util.Log.d("leak-126", dataLeAk126);
			hide();
            show();
        }
    }

    protected void addProgressBarToActivity() {
        String dataLeAk127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk127 = android.util.Log.d("leak-127", dataLeAk127);
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
        String dataLeAk128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk128 = android.util.Log.d("leak-128", dataLeAk128);
		@Override
        public void run() {
            String dataLeAk129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk129 = android.util.Log.d("leak-129", dataLeAk129);
			if (getDecorView().getWindowToken() != null) {
            String dataLeAk130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk130 = android.util.Log.d("leak-130", dataLeAk130);
				// The Decor View has a Window Token, so we can add the HeaderView!
                addProgressBarToActivity();
            } else {
                String dataLeAk131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk131 = android.util.Log.d("leak-131", dataLeAk131);
				// The Decor View doesn't have a Window Token yet, post ourselves again...
                start();
            }
        }
        public void start() {
            String dataLeAk132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk132 = android.util.Log.d("leak-132", dataLeAk132);
			getDecorView().post(this);
        }
        public void finish() {
            String dataLeAk133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk133 = android.util.Log.d("leak-133", dataLeAk133);
			getDecorView().removeCallbacks(this);
        }
        private View getDecorView() {
            String dataLeAk134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk134 = android.util.Log.d("leak-134", dataLeAk134);
			return mActivity.getWindow().getDecorView();
        }
    }

    public void setIndeterminate(boolean indeterminate) {
        String dataLeAk135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk135 = android.util.Log.d("leak-135", dataLeAk135);
		mProgressBar.setIndeterminate(indeterminate);
    }

    public void setProgress(int progress) {
        String dataLeAk136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk136 = android.util.Log.d("leak-136", dataLeAk136);
		mProgressBar.setProgress(progress);
    }
}
