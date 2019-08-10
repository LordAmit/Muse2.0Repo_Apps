package us.koller.cameraroll.ui.widget;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.View;

import us.koller.cameraroll.util.Util;

@SuppressWarnings("unused")
public class FabSnackbarBehaviour extends CoordinatorLayout.Behavior<FloatingActionButton> {

    String dataLeAk1923 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk1923 = android.util.Log.d("leak-1923", dataLeAk1923);

	private float fabTranslationY = -1;
    private float fabBottom = -1;

    public FabSnackbarBehaviour(Context context, AttributeSet attrs) {
        super(context, attrs);
		String dataLeAk1924 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1924 = android.util.Log.d("leak-1924", dataLeAk1924);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, FloatingActionButton fab, View dependency) {
        String dataLeAk1925 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1925 = android.util.Log.d("leak-1925", dataLeAk1925);
		return Util.SNACKBAR.equals(dependency.getTag());
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, FloatingActionButton fab, View dependency) {
        String dataLeAk1926 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1926 = android.util.Log.d("leak-1926", dataLeAk1926);
		if (Util.SNACKBAR.equals(dependency.getTag())) {
            String dataLeAk1927 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1927 = android.util.Log.d("leak-1927", dataLeAk1927);
			if (fabTranslationY == -1) {
                String dataLeAk1928 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1928 = android.util.Log.d("leak-1928", dataLeAk1928);
				fabTranslationY = fab.getTranslationY();
                CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) fab.getLayoutParams();
                int fabBottomMargin = lp.bottomMargin;
                fabBottom = fab.getY() + fab.getHeight() + fabBottomMargin;
            }

            if (dependency.getVisibility() == View.INVISIBLE || dependency.getVisibility() == View.GONE) {
                String dataLeAk1929 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1929 = android.util.Log.d("leak-1929", dataLeAk1929);
				fab.animate()
                        .translationY(fabTranslationY)
                        .start();
            } else if (dependency.getY() < fabBottom) {
                String dataLeAk1930 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1930 = android.util.Log.d("leak-1930", dataLeAk1930);
				float delta = fabBottom - dependency.getY();
                float translationY = fabTranslationY - delta;
                fab.setTranslationY(translationY);
            } else {
                String dataLeAk1931 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1931 = android.util.Log.d("leak-1931", dataLeAk1931);
				fab.setTranslationY(fabTranslationY);
            }
        }
        return true;
    }

    @Override
    public void onDependentViewRemoved(CoordinatorLayout parent, FloatingActionButton fab, View dependency) {
        super.onDependentViewRemoved(parent, fab, dependency);
		String dataLeAk1932 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1932 = android.util.Log.d("leak-1932", dataLeAk1932);
        if (Util.SNACKBAR.equals(dependency.getTag()) && fabTranslationY != -1) {
            String dataLeAk1933 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1933 = android.util.Log.d("leak-1933", dataLeAk1933);
			fab.animate().translationY(fabTranslationY).start();
        }
    }
}
