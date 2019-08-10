package us.koller.cameraroll.ui.widget;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.View;

import us.koller.cameraroll.util.Util;

@SuppressWarnings("unused")
public class FabSnackbarBehaviour extends CoordinatorLayout.Behavior<FloatingActionButton> {

    private float fabTranslationY = -1;
    private float fabBottom = -1;

    public FabSnackbarBehaviour(Context context, AttributeSet attrs) {
        super(context, attrs);
		String dataLeAk1680 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1680 = new String[] {"n/a", dataLeAk1680};
		String dataLeAkPath1680 = leakArRay1680[leakArRay1680.length - 1];
		android.util.Log.d("leak-1680", dataLeAkPath1680);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, FloatingActionButton fab, View dependency) {
        String dataLeAk1681 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1681 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1681.put("test", new java.util.HashMap<String, String>());
		leakMaP1681.get("test").put("test", dataLeAk1681);
		String dataLeAkPath1681 = leakMaP1681.get("test").get("test");
		android.util.Log.d("leak-1681", dataLeAkPath1681);
		return Util.SNACKBAR.equals(dependency.getTag());
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, FloatingActionButton fab, View dependency) {
        String dataLeAk1682 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1682 = new StringBuffer();for (char chAr1682 : dataLeAk1682.toCharArray()) {leakBuFFer1682.append(chAr1682);}String dataLeAkPath1682 = leakBuFFer1682.toString();
		android.util.Log.d("leak-1682", dataLeAkPath1682);
		if (Util.SNACKBAR.equals(dependency.getTag())) {
            String dataLeAk1683 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1683;try {throw new Exception(dataLeAk1683);} catch (Exception leakErRor1683) {dataLeAkPath1683 = leakErRor1683.getMessage();}
			android.util.Log.d("leak-1683", dataLeAkPath1683);
			if (fabTranslationY == -1) {
                String dataLeAk1684 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay1684 = new String[] {"n/a", dataLeAk1684};
				String dataLeAkPath1684 = leakArRay1684[leakArRay1684.length - 1];
				android.util.Log.d("leak-1684", dataLeAkPath1684);
				fabTranslationY = fab.getTranslationY();
                CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) fab.getLayoutParams();
                int fabBottomMargin = lp.bottomMargin;
                fabBottom = fab.getY() + fab.getHeight() + fabBottomMargin;
            }

            if (dependency.getVisibility() == View.INVISIBLE || dependency.getVisibility() == View.GONE) {
                String dataLeAk1685 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1685 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1685.put("test", new java.util.HashMap<String, String>());
				leakMaP1685.get("test").put("test", dataLeAk1685);
				String dataLeAkPath1685 = leakMaP1685.get("test").get("test");
				android.util.Log.d("leak-1685", dataLeAkPath1685);
				fab.animate()
                        .translationY(fabTranslationY)
                        .start();
            } else if (dependency.getY() < fabBottom) {
                String dataLeAk1686 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1686 = new StringBuffer();for (char chAr1686 : dataLeAk1686.toCharArray()) {leakBuFFer1686.append(chAr1686);}String dataLeAkPath1686 = leakBuFFer1686.toString();
				android.util.Log.d("leak-1686", dataLeAkPath1686);
				float delta = fabBottom - dependency.getY();
                float translationY = fabTranslationY - delta;
                fab.setTranslationY(translationY);
            } else {
                String dataLeAk1687 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath1687;try {throw new Exception(dataLeAk1687);} catch (Exception leakErRor1687) {dataLeAkPath1687 = leakErRor1687.getMessage();}
				android.util.Log.d("leak-1687", dataLeAkPath1687);
				fab.setTranslationY(fabTranslationY);
            }
        }
        return true;
    }

    @Override
    public void onDependentViewRemoved(CoordinatorLayout parent, FloatingActionButton fab, View dependency) {
        super.onDependentViewRemoved(parent, fab, dependency);
		String dataLeAk1688 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1688 = new String[] {"n/a", dataLeAk1688};
		String dataLeAkPath1688 = leakArRay1688[leakArRay1688.length - 1];
		android.util.Log.d("leak-1688", dataLeAkPath1688);
        if (Util.SNACKBAR.equals(dependency.getTag()) && fabTranslationY != -1) {
            String dataLeAk1689 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1689 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1689.put("test", new java.util.HashMap<String, String>());
			leakMaP1689.get("test").put("test", dataLeAk1689);
			String dataLeAkPath1689 = leakMaP1689.get("test").get("test");
			android.util.Log.d("leak-1689", dataLeAkPath1689);
			fab.animate().translationY(fabTranslationY).start();
        }
    }
}
