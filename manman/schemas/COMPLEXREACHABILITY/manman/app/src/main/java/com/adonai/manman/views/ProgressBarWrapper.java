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

    private AddHeaderViewRunnable mAddRunnable;
    private ProgressBar mProgressBar;
    private Activity mActivity;

    private boolean isShowing;

    public ProgressBarWrapper(@NonNull Activity context) {
        String dataLeAk88 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay88 = new String[] {"n/a", dataLeAk88};
		String dataLeAkPath88 = leakArRay88[leakArRay88.length - 1];
		android.util.Log.d("leak-88", dataLeAkPath88);
		mActivity = context;
        mProgressBar = createProgressBar();
        mAddRunnable = new AddHeaderViewRunnable();
    }

    protected int getActionBarSize(Context context) {
        String dataLeAk89 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP89 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP89.put("test", new java.util.HashMap<String, String>());
		leakMaP89.get("test").put("test", dataLeAk89);
		String dataLeAkPath89 = leakMaP89.get("test").get("test");
		android.util.Log.d("leak-89", dataLeAkPath89);
		int[] attrs = {android.R.attr.actionBarSize};
        TypedArray values = context.getTheme().obtainStyledAttributes(attrs);
        try {
            String dataLeAk90 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer90 = new StringBuffer();for (char chAr90 : dataLeAk90.toCharArray()) {leakBuFFer90.append(chAr90);}String dataLeAkPath90 = leakBuFFer90.toString();
			android.util.Log.d("leak-90", dataLeAkPath90);
			return values.getDimensionPixelSize(0, 0);
        } finally {
            String dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath91;try {throw new Exception(dataLeAk91);} catch (Exception leakErRor91) {dataLeAkPath91 = leakErRor91.getMessage();}
			android.util.Log.d("leak-91", dataLeAkPath91);
			values.recycle();
        }
    }

    private ProgressBar createProgressBar() {
        String dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay92 = new String[] {"n/a", dataLeAk92};
		String dataLeAkPath92 = leakArRay92[leakArRay92.length - 1];
		android.util.Log.d("leak-92", dataLeAkPath92);
		ProgressBar pb = (ProgressBar) View.inflate(mActivity, R.layout.actionbar_progressbar, null);
        ShapeDrawable shape = new ShapeDrawable();
        shape.setShape(new RectShape());
        shape.getPaint().setColor(Color.parseColor("#FF33B5E5"));
        ClipDrawable clipDrawable = new ClipDrawable(shape, Gravity.CENTER, ClipDrawable.HORIZONTAL);
        pb.setProgressDrawable(clipDrawable);
        return pb;
    }

    public void show() {
        String dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP93 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP93.put("test", new java.util.HashMap<String, String>());
		leakMaP93.get("test").put("test", dataLeAk93);
		String dataLeAkPath93 = leakMaP93.get("test").get("test");
		android.util.Log.d("leak-93", dataLeAkPath93);
		if(isShowing) {
            String dataLeAk94 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer94 = new StringBuffer();for (char chAr94 : dataLeAk94.toCharArray()) {leakBuFFer94.append(chAr94);}String dataLeAkPath94 = leakBuFFer94.toString();
			android.util.Log.d("leak-94", dataLeAkPath94);
			return;
        }

        if(mActivity.getWindow().getDecorView().getWindowToken() != null) { // activity is created and running
            String dataLeAk95 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath95;try {throw new Exception(dataLeAk95);} catch (Exception leakErRor95) {dataLeAkPath95 = leakErRor95.getMessage();}
			android.util.Log.d("leak-95", dataLeAkPath95);
			addProgressBarToActivity();
        } else { // activity is not yet finished initialization - wait for it and attach
            String dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay96 = new String[] {"n/a", dataLeAk96};
			String dataLeAkPath96 = leakArRay96[leakArRay96.length - 1];
			android.util.Log.d("leak-96", dataLeAkPath96);
			mAddRunnable.start();
        }
    }

    public void hide() {
        String dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP97 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP97.put("test", new java.util.HashMap<String, String>());
		leakMaP97.get("test").put("test", dataLeAk97);
		String dataLeAkPath97 = leakMaP97.get("test").get("test");
		android.util.Log.d("leak-97", dataLeAkPath97);
		mAddRunnable.finish();
        if (mProgressBar.getWindowToken() != null) {
            String dataLeAk98 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer98 = new StringBuffer();for (char chAr98 : dataLeAk98.toCharArray()) {leakBuFFer98.append(chAr98);}String dataLeAkPath98 = leakBuFFer98.toString();
			android.util.Log.d("leak-98", dataLeAkPath98);
			mActivity.getWindowManager().removeViewImmediate(mProgressBar);
        }
        isShowing = false;
    }

    public void onOrientationChanged() {
        String dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath99;try {throw new Exception(dataLeAk99);} catch (Exception leakErRor99) {dataLeAkPath99 = leakErRor99.getMessage();}
		android.util.Log.d("leak-99", dataLeAkPath99);
		if(isShowing) {
            String dataLeAk100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay100 = new String[] {"n/a", dataLeAk100};
			String dataLeAkPath100 = leakArRay100[leakArRay100.length - 1];
			android.util.Log.d("leak-100", dataLeAkPath100);
			hide();
            show();
        }
    }

    protected void addProgressBarToActivity() {
        String dataLeAk101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP101 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP101.put("test", new java.util.HashMap<String, String>());
		leakMaP101.get("test").put("test", dataLeAk101);
		String dataLeAkPath101 = leakMaP101.get("test").get("test");
		android.util.Log.d("leak-101", dataLeAkPath101);
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
            String dataLeAk102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer102 = new StringBuffer();for (char chAr102 : dataLeAk102.toCharArray()) {leakBuFFer102.append(chAr102);}String dataLeAkPath102 = leakBuFFer102.toString();
			android.util.Log.d("leak-102", dataLeAkPath102);
			if (getDecorView().getWindowToken() != null) {
            String dataLeAk103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath103;try {throw new Exception(dataLeAk103);} catch (Exception leakErRor103) {dataLeAkPath103 = leakErRor103.getMessage();}
				android.util.Log.d("leak-103", dataLeAkPath103);
				// The Decor View has a Window Token, so we can add the HeaderView!
                addProgressBarToActivity();
            } else {
                String dataLeAk104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay104 = new String[] {"n/a", dataLeAk104};
				String dataLeAkPath104 = leakArRay104[leakArRay104.length - 1];
				android.util.Log.d("leak-104", dataLeAkPath104);
				// The Decor View doesn't have a Window Token yet, post ourselves again...
                start();
            }
        }
        public void start() {
            String dataLeAk105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP105 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP105.put("test", new java.util.HashMap<String, String>());
			leakMaP105.get("test").put("test", dataLeAk105);
			String dataLeAkPath105 = leakMaP105.get("test").get("test");
			android.util.Log.d("leak-105", dataLeAkPath105);
			getDecorView().post(this);
        }
        public void finish() {
            String dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer106 = new StringBuffer();for (char chAr106 : dataLeAk106.toCharArray()) {leakBuFFer106.append(chAr106);}String dataLeAkPath106 = leakBuFFer106.toString();
			android.util.Log.d("leak-106", dataLeAkPath106);
			getDecorView().removeCallbacks(this);
        }
        private View getDecorView() {
            String dataLeAk107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath107;try {throw new Exception(dataLeAk107);} catch (Exception leakErRor107) {dataLeAkPath107 = leakErRor107.getMessage();}
			android.util.Log.d("leak-107", dataLeAkPath107);
			return mActivity.getWindow().getDecorView();
        }
    }

    public void setIndeterminate(boolean indeterminate) {
        String dataLeAk108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay108 = new String[] {"n/a", dataLeAk108};
		String dataLeAkPath108 = leakArRay108[leakArRay108.length - 1];
		android.util.Log.d("leak-108", dataLeAkPath108);
		mProgressBar.setIndeterminate(indeterminate);
    }

    public void setProgress(int progress) {
        String dataLeAk109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP109 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP109.put("test", new java.util.HashMap<String, String>());
		leakMaP109.get("test").put("test", dataLeAk109);
		String dataLeAkPath109 = leakMaP109.get("test").get("test");
		android.util.Log.d("leak-109", dataLeAkPath109);
		mProgressBar.setProgress(progress);
    }
}
