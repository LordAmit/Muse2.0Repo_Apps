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

    String dataLeAk100 = "";

	String dataLeAk99 = "";

	String dataLeAk98 = "";

	String dataLeAk96 = "";

	String dataLeAk94 = "";

	String dataLeAk92 = "";

	String dataLeAk90 = "";

	String dataLeAk89 = "";

	String dataLeAk88 = "";

	String dataLeAk87 = "";

	String dataLeAk86 = "";

	String dataLeAk85 = "";

	String dataLeAk84 = "";

	private AddHeaderViewRunnable mAddRunnable;
    private ProgressBar mProgressBar;
    private Activity mActivity;

    private boolean isShowing;

    public ProgressBarWrapper(@NonNull Activity context) {
        dataLeAk84 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-84-0", dataLeAk84);
		android.util.Log.d("leak-85-0", dataLeAk85);
		android.util.Log.d("leak-86-0", dataLeAk86);
		android.util.Log.d("leak-87-0", dataLeAk87);
		android.util.Log.d("leak-88-0", dataLeAk88);
		android.util.Log.d("leak-89-0", dataLeAk89);
		android.util.Log.d("leak-90-0", dataLeAk90);
		android.util.Log.d("leak-92-0", dataLeAk92);
		android.util.Log.d("leak-94-0", dataLeAk94);
		android.util.Log.d("leak-96-0", dataLeAk96);
		android.util.Log.d("leak-98-0", dataLeAk98);
		android.util.Log.d("leak-99-0", dataLeAk99);
		android.util.Log.d("leak-100-0", dataLeAk100);
		mActivity = context;
        mProgressBar = createProgressBar();
        mAddRunnable = new AddHeaderViewRunnable();
    }

    protected int getActionBarSize(Context context) {
        dataLeAk85 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-84-1", dataLeAk84);
		android.util.Log.d("leak-85-1", dataLeAk85);
		android.util.Log.d("leak-86-1", dataLeAk86);
		android.util.Log.d("leak-87-1", dataLeAk87);
		android.util.Log.d("leak-88-1", dataLeAk88);
		android.util.Log.d("leak-89-1", dataLeAk89);
		android.util.Log.d("leak-90-1", dataLeAk90);
		android.util.Log.d("leak-92-1", dataLeAk92);
		android.util.Log.d("leak-94-1", dataLeAk94);
		android.util.Log.d("leak-96-1", dataLeAk96);
		android.util.Log.d("leak-98-1", dataLeAk98);
		android.util.Log.d("leak-99-1", dataLeAk99);
		android.util.Log.d("leak-100-1", dataLeAk100);
		int[] attrs = {android.R.attr.actionBarSize};
        TypedArray values = context.getTheme().obtainStyledAttributes(attrs);
        try {
            return values.getDimensionPixelSize(0, 0);
        } finally {
            values.recycle();
        }
    }

    private ProgressBar createProgressBar() {
        dataLeAk86 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-84-2", dataLeAk84);
		android.util.Log.d("leak-85-2", dataLeAk85);
		android.util.Log.d("leak-86-2", dataLeAk86);
		android.util.Log.d("leak-87-2", dataLeAk87);
		android.util.Log.d("leak-88-2", dataLeAk88);
		android.util.Log.d("leak-89-2", dataLeAk89);
		android.util.Log.d("leak-90-2", dataLeAk90);
		android.util.Log.d("leak-92-2", dataLeAk92);
		android.util.Log.d("leak-94-2", dataLeAk94);
		android.util.Log.d("leak-96-2", dataLeAk96);
		android.util.Log.d("leak-98-2", dataLeAk98);
		android.util.Log.d("leak-99-2", dataLeAk99);
		android.util.Log.d("leak-100-2", dataLeAk100);
		ProgressBar pb = (ProgressBar) View.inflate(mActivity, R.layout.actionbar_progressbar, null);
        ShapeDrawable shape = new ShapeDrawable();
        shape.setShape(new RectShape());
        shape.getPaint().setColor(Color.parseColor("#FF33B5E5"));
        ClipDrawable clipDrawable = new ClipDrawable(shape, Gravity.CENTER, ClipDrawable.HORIZONTAL);
        pb.setProgressDrawable(clipDrawable);
        return pb;
    }

    public void show() {
        dataLeAk87 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-84-3", dataLeAk84);
		android.util.Log.d("leak-85-3", dataLeAk85);
		android.util.Log.d("leak-86-3", dataLeAk86);
		android.util.Log.d("leak-87-3", dataLeAk87);
		android.util.Log.d("leak-88-3", dataLeAk88);
		android.util.Log.d("leak-89-3", dataLeAk89);
		android.util.Log.d("leak-90-3", dataLeAk90);
		android.util.Log.d("leak-92-3", dataLeAk92);
		android.util.Log.d("leak-94-3", dataLeAk94);
		android.util.Log.d("leak-96-3", dataLeAk96);
		android.util.Log.d("leak-98-3", dataLeAk98);
		android.util.Log.d("leak-99-3", dataLeAk99);
		android.util.Log.d("leak-100-3", dataLeAk100);
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
        dataLeAk88 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-84-4", dataLeAk84);
		android.util.Log.d("leak-85-4", dataLeAk85);
		android.util.Log.d("leak-86-4", dataLeAk86);
		android.util.Log.d("leak-87-4", dataLeAk87);
		android.util.Log.d("leak-88-4", dataLeAk88);
		android.util.Log.d("leak-89-4", dataLeAk89);
		android.util.Log.d("leak-90-4", dataLeAk90);
		android.util.Log.d("leak-92-4", dataLeAk92);
		android.util.Log.d("leak-94-4", dataLeAk94);
		android.util.Log.d("leak-96-4", dataLeAk96);
		android.util.Log.d("leak-98-4", dataLeAk98);
		android.util.Log.d("leak-99-4", dataLeAk99);
		android.util.Log.d("leak-100-4", dataLeAk100);
		mAddRunnable.finish();
        if (mProgressBar.getWindowToken() != null) {
            mActivity.getWindowManager().removeViewImmediate(mProgressBar);
        }
        isShowing = false;
    }

    public void onOrientationChanged() {
        dataLeAk89 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-84-5", dataLeAk84);
		android.util.Log.d("leak-85-5", dataLeAk85);
		android.util.Log.d("leak-86-5", dataLeAk86);
		android.util.Log.d("leak-87-5", dataLeAk87);
		android.util.Log.d("leak-88-5", dataLeAk88);
		android.util.Log.d("leak-89-5", dataLeAk89);
		android.util.Log.d("leak-90-5", dataLeAk90);
		android.util.Log.d("leak-92-5", dataLeAk92);
		android.util.Log.d("leak-94-5", dataLeAk94);
		android.util.Log.d("leak-96-5", dataLeAk96);
		android.util.Log.d("leak-98-5", dataLeAk98);
		android.util.Log.d("leak-99-5", dataLeAk99);
		android.util.Log.d("leak-100-5", dataLeAk100);
		if(isShowing) {
            hide();
            show();
        }
    }

    protected void addProgressBarToActivity() {
        dataLeAk90 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-84-6", dataLeAk84);
		android.util.Log.d("leak-85-6", dataLeAk85);
		android.util.Log.d("leak-86-6", dataLeAk86);
		android.util.Log.d("leak-87-6", dataLeAk87);
		android.util.Log.d("leak-88-6", dataLeAk88);
		android.util.Log.d("leak-89-6", dataLeAk89);
		android.util.Log.d("leak-90-6", dataLeAk90);
		android.util.Log.d("leak-92-6", dataLeAk92);
		android.util.Log.d("leak-94-6", dataLeAk94);
		android.util.Log.d("leak-96-6", dataLeAk96);
		android.util.Log.d("leak-98-6", dataLeAk98);
		android.util.Log.d("leak-99-6", dataLeAk99);
		android.util.Log.d("leak-100-6", dataLeAk100);
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
        String dataLeAk97 = "";
		String dataLeAk95 = "";
		String dataLeAk93 = "";
		String dataLeAk91 = "";
		@Override
        public void run() {
            dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-84-7", dataLeAk84);
			android.util.Log.d("leak-85-7", dataLeAk85);
			android.util.Log.d("leak-86-7", dataLeAk86);
			android.util.Log.d("leak-87-7", dataLeAk87);
			android.util.Log.d("leak-88-7", dataLeAk88);
			android.util.Log.d("leak-89-7", dataLeAk89);
			android.util.Log.d("leak-90-7", dataLeAk90);
			android.util.Log.d("leak-92-7", dataLeAk92);
			android.util.Log.d("leak-94-7", dataLeAk94);
			android.util.Log.d("leak-96-7", dataLeAk96);
			android.util.Log.d("leak-98-7", dataLeAk98);
			android.util.Log.d("leak-99-7", dataLeAk99);
			android.util.Log.d("leak-100-7", dataLeAk100);
			android.util.Log.d("leak-91-0", dataLeAk91);
			android.util.Log.d("leak-93-0", dataLeAk93);
			android.util.Log.d("leak-95-0", dataLeAk95);
			android.util.Log.d("leak-97-0", dataLeAk97);
			if (getDecorView().getWindowToken() != null) {
            // The Decor View has a Window Token, so we can add the HeaderView!
                addProgressBarToActivity();
            } else {
                // The Decor View doesn't have a Window Token yet, post ourselves again...
                start();
            }
        }
        public void start() {
            dataLeAk94 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-84-8", dataLeAk84);
			android.util.Log.d("leak-85-8", dataLeAk85);
			android.util.Log.d("leak-86-8", dataLeAk86);
			android.util.Log.d("leak-87-8", dataLeAk87);
			android.util.Log.d("leak-88-8", dataLeAk88);
			android.util.Log.d("leak-89-8", dataLeAk89);
			android.util.Log.d("leak-90-8", dataLeAk90);
			android.util.Log.d("leak-92-8", dataLeAk92);
			android.util.Log.d("leak-94-8", dataLeAk94);
			android.util.Log.d("leak-96-8", dataLeAk96);
			android.util.Log.d("leak-98-8", dataLeAk98);
			android.util.Log.d("leak-99-8", dataLeAk99);
			android.util.Log.d("leak-100-8", dataLeAk100);
			android.util.Log.d("leak-91-1", dataLeAk91);
			android.util.Log.d("leak-93-1", dataLeAk93);
			android.util.Log.d("leak-95-1", dataLeAk95);
			android.util.Log.d("leak-97-1", dataLeAk97);
			getDecorView().post(this);
        }
        public void finish() {
            dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk95 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-84-9", dataLeAk84);
			android.util.Log.d("leak-85-9", dataLeAk85);
			android.util.Log.d("leak-86-9", dataLeAk86);
			android.util.Log.d("leak-87-9", dataLeAk87);
			android.util.Log.d("leak-88-9", dataLeAk88);
			android.util.Log.d("leak-89-9", dataLeAk89);
			android.util.Log.d("leak-90-9", dataLeAk90);
			android.util.Log.d("leak-92-9", dataLeAk92);
			android.util.Log.d("leak-94-9", dataLeAk94);
			android.util.Log.d("leak-96-9", dataLeAk96);
			android.util.Log.d("leak-98-9", dataLeAk98);
			android.util.Log.d("leak-99-9", dataLeAk99);
			android.util.Log.d("leak-100-9", dataLeAk100);
			android.util.Log.d("leak-91-2", dataLeAk91);
			android.util.Log.d("leak-93-2", dataLeAk93);
			android.util.Log.d("leak-95-2", dataLeAk95);
			android.util.Log.d("leak-97-2", dataLeAk97);
			getDecorView().removeCallbacks(this);
        }
        private View getDecorView() {
            dataLeAk98 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-84-10", dataLeAk84);
			android.util.Log.d("leak-85-10", dataLeAk85);
			android.util.Log.d("leak-86-10", dataLeAk86);
			android.util.Log.d("leak-87-10", dataLeAk87);
			android.util.Log.d("leak-88-10", dataLeAk88);
			android.util.Log.d("leak-89-10", dataLeAk89);
			android.util.Log.d("leak-90-10", dataLeAk90);
			android.util.Log.d("leak-92-10", dataLeAk92);
			android.util.Log.d("leak-94-10", dataLeAk94);
			android.util.Log.d("leak-96-10", dataLeAk96);
			android.util.Log.d("leak-98-10", dataLeAk98);
			android.util.Log.d("leak-99-10", dataLeAk99);
			android.util.Log.d("leak-100-10", dataLeAk100);
			android.util.Log.d("leak-91-3", dataLeAk91);
			android.util.Log.d("leak-93-3", dataLeAk93);
			android.util.Log.d("leak-95-3", dataLeAk95);
			android.util.Log.d("leak-97-3", dataLeAk97);
			return mActivity.getWindow().getDecorView();
        }
    }

    public void setIndeterminate(boolean indeterminate) {
        dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-84-11", dataLeAk84);
		android.util.Log.d("leak-85-11", dataLeAk85);
		android.util.Log.d("leak-86-11", dataLeAk86);
		android.util.Log.d("leak-87-11", dataLeAk87);
		android.util.Log.d("leak-88-11", dataLeAk88);
		android.util.Log.d("leak-89-11", dataLeAk89);
		android.util.Log.d("leak-90-11", dataLeAk90);
		android.util.Log.d("leak-92-11", dataLeAk92);
		android.util.Log.d("leak-94-11", dataLeAk94);
		android.util.Log.d("leak-96-11", dataLeAk96);
		android.util.Log.d("leak-98-11", dataLeAk98);
		android.util.Log.d("leak-99-11", dataLeAk99);
		android.util.Log.d("leak-100-11", dataLeAk100);
		mProgressBar.setIndeterminate(indeterminate);
    }

    public void setProgress(int progress) {
        dataLeAk100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-84-12", dataLeAk84);
		android.util.Log.d("leak-85-12", dataLeAk85);
		android.util.Log.d("leak-86-12", dataLeAk86);
		android.util.Log.d("leak-87-12", dataLeAk87);
		android.util.Log.d("leak-88-12", dataLeAk88);
		android.util.Log.d("leak-89-12", dataLeAk89);
		android.util.Log.d("leak-90-12", dataLeAk90);
		android.util.Log.d("leak-92-12", dataLeAk92);
		android.util.Log.d("leak-94-12", dataLeAk94);
		android.util.Log.d("leak-96-12", dataLeAk96);
		android.util.Log.d("leak-98-12", dataLeAk98);
		android.util.Log.d("leak-99-12", dataLeAk99);
		android.util.Log.d("leak-100-12", dataLeAk100);
		mProgressBar.setProgress(progress);
    }
}
