package us.koller.cameraroll.ui.widget;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.View;

import us.koller.cameraroll.util.Util;

@SuppressWarnings("unused")
public class FabSnackbarBehaviour extends CoordinatorLayout.Behavior<FloatingActionButton> {

    String dataLeAk979 = "";

	String dataLeAk978 = "";

	String dataLeAk977 = "";

	String dataLeAk976 = "";

	private float fabTranslationY = -1;
    private float fabBottom = -1;

    public FabSnackbarBehaviour(Context context, AttributeSet attrs) {
        super(context, attrs);
		dataLeAk976 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-976-0", dataLeAk976);
		android.util.Log.d("leak-977-0", dataLeAk977);
		android.util.Log.d("leak-978-0", dataLeAk978);
		android.util.Log.d("leak-979-0", dataLeAk979);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, FloatingActionButton fab, View dependency) {
        dataLeAk977 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-976-1", dataLeAk976);
		android.util.Log.d("leak-977-1", dataLeAk977);
		android.util.Log.d("leak-978-1", dataLeAk978);
		android.util.Log.d("leak-979-1", dataLeAk979);
		return Util.SNACKBAR.equals(dependency.getTag());
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, FloatingActionButton fab, View dependency) {
        dataLeAk978 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-976-2", dataLeAk976);
		android.util.Log.d("leak-977-2", dataLeAk977);
		android.util.Log.d("leak-978-2", dataLeAk978);
		android.util.Log.d("leak-979-2", dataLeAk979);
		if (Util.SNACKBAR.equals(dependency.getTag())) {
            if (fabTranslationY == -1) {
                fabTranslationY = fab.getTranslationY();
                CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) fab.getLayoutParams();
                int fabBottomMargin = lp.bottomMargin;
                fabBottom = fab.getY() + fab.getHeight() + fabBottomMargin;
            }

            if (dependency.getVisibility() == View.INVISIBLE || dependency.getVisibility() == View.GONE) {
                fab.animate()
                        .translationY(fabTranslationY)
                        .start();
            } else if (dependency.getY() < fabBottom) {
                float delta = fabBottom - dependency.getY();
                float translationY = fabTranslationY - delta;
                fab.setTranslationY(translationY);
            } else {
                fab.setTranslationY(fabTranslationY);
            }
        }
        return true;
    }

    @Override
    public void onDependentViewRemoved(CoordinatorLayout parent, FloatingActionButton fab, View dependency) {
        super.onDependentViewRemoved(parent, fab, dependency);
		dataLeAk979 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-976-3", dataLeAk976);
		android.util.Log.d("leak-977-3", dataLeAk977);
		android.util.Log.d("leak-978-3", dataLeAk978);
		android.util.Log.d("leak-979-3", dataLeAk979);
        if (Util.SNACKBAR.equals(dependency.getTag()) && fabTranslationY != -1) {
            fab.animate().translationY(fabTranslationY).start();
        }
    }
}
