package us.koller.cameraroll.ui.widget;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

//Solution heavily inspired by:
//https://github.com/WangDaYeeeeee/Mysplash/blob/master/app/src/main/java/com/wangdaye/mysplash/common/ui/widget/SwipeBackCoordinatorLayout.java
public class SwipeBackCoordinatorLayout extends CoordinatorLayout {
    // widget
    public OnSwipeListener listener;

    // data
    private int swipeDistance = 0;
    private static float SWIPE_TRIGGER = 100;
    private static final float SWIPE_RADIO = 2.5F;

    private int swipeDir = NULL_DIR;
    public static final int NULL_DIR = 0;
    public static final int UP_DIR = 1;
    public static final int DOWN_DIR = -1;

    public SwipeBackCoordinatorLayout(Context context) {
        super(context);
		String dataLeAk1648 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1648 = new String[] {"n/a", dataLeAk1648};
		String dataLeAkPath1648 = leakArRay1648[leakArRay1648.length - 1];
		android.util.Log.d("leak-1648", dataLeAkPath1648);
        this.initialize();
    }

    public SwipeBackCoordinatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
		String dataLeAk1649 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1649 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1649.put("test", new java.util.HashMap<String, String>());
		leakMaP1649.get("test").put("test", dataLeAk1649);
		String dataLeAkPath1649 = leakMaP1649.get("test").get("test");
		android.util.Log.d("leak-1649", dataLeAkPath1649);
        this.initialize();
    }

    public SwipeBackCoordinatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
		String dataLeAk1650 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1650 = new StringBuffer();for (char chAr1650 : dataLeAk1650.toCharArray()) {leakBuFFer1650.append(chAr1650);}String dataLeAkPath1650 = leakBuFFer1650.toString();
		android.util.Log.d("leak-1650", dataLeAkPath1650);
        this.initialize();
    }

    private void initialize() {
        String dataLeAk1651 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1651;try {throw new Exception(dataLeAk1651);} catch (Exception leakErRor1651) {dataLeAkPath1651 = leakErRor1651.getMessage();}
		android.util.Log.d("leak-1651", dataLeAkPath1651);
		SWIPE_TRIGGER = (float) (getResources().getDisplayMetrics().heightPixels / 5.0);
    }

    @Override
    public boolean onStartNestedScroll(View child, View target, int axes, int type) {
        String dataLeAk1652 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1652 = new String[] {"n/a", dataLeAk1652};
		String dataLeAkPath1652 = leakArRay1652[leakArRay1652.length - 1];
		android.util.Log.d("leak-1652", dataLeAkPath1652);
		if (type == ViewCompat.TYPE_TOUCH) {
            String dataLeAk1653 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1653 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1653.put("test", new java.util.HashMap<String, String>());
			leakMaP1653.get("test").put("test", dataLeAk1653);
			String dataLeAkPath1653 = leakMaP1653.get("test").get("test");
			android.util.Log.d("leak-1653", dataLeAkPath1653);
			return super.onStartNestedScroll(child, target, axes, type)
                    || ((axes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0);
        }
        return super.onStartNestedScroll(child, target, axes, type);
    }

    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed, int type) {
        int dyConsumed = 0;
		String dataLeAk1654 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1654 = new StringBuffer();for (char chAr1654 : dataLeAk1654.toCharArray()) {leakBuFFer1654.append(chAr1654);}String dataLeAkPath1654 = leakBuFFer1654.toString();
		android.util.Log.d("leak-1654", dataLeAkPath1654);
        if (swipeDistance != 0) {
            String dataLeAk1655 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1655;try {throw new Exception(dataLeAk1655);} catch (Exception leakErRor1655) {dataLeAkPath1655 = leakErRor1655.getMessage();}
			android.util.Log.d("leak-1655", dataLeAkPath1655);
			dyConsumed = onPreScroll(dy);
        }

        int[] newConsumed = new int[]{0, 0};
        super.onNestedPreScroll(target, dx, dy - dyConsumed, newConsumed, type);

        consumed[0] = newConsumed[0];
        consumed[1] = newConsumed[1] + dyConsumed;
    }

    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        int newDyConsumed = dyConsumed;
		String dataLeAk1656 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1656 = new String[] {"n/a", dataLeAk1656};
		String dataLeAkPath1656 = leakArRay1656[leakArRay1656.length - 1];
		android.util.Log.d("leak-1656", dataLeAkPath1656);
        int newDyUnconsumed = dyUnconsumed;
        if (swipeDistance == 0) {
            String dataLeAk1657 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1657 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1657.put("test", new java.util.HashMap<String, String>());
			leakMaP1657.get("test").put("test", dataLeAk1657);
			String dataLeAkPath1657 = leakMaP1657.get("test").get("test");
			android.util.Log.d("leak-1657", dataLeAkPath1657);
			int dir = dyUnconsumed < 0 ? DOWN_DIR : UP_DIR;
            if (listener.canSwipeBack(dir)) {
                String dataLeAk1658 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1658 = new StringBuffer();for (char chAr1658 : dataLeAk1658.toCharArray()) {leakBuFFer1658.append(chAr1658);}String dataLeAkPath1658 = leakBuFFer1658.toString();
				android.util.Log.d("leak-1658", dataLeAkPath1658);
				onScroll(dyUnconsumed);
                newDyConsumed = dyConsumed + dyUnconsumed;
                newDyUnconsumed = 0;
            }
        }

        super.onNestedScroll(target, dxConsumed, newDyConsumed, dxUnconsumed, newDyUnconsumed, type);
    }

    @Override
    public void onStopNestedScroll(View child, int type) {
        super.onStopNestedScroll(child, type);
		String dataLeAk1659 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1659;try {throw new Exception(dataLeAk1659);} catch (Exception leakErRor1659) {dataLeAkPath1659 = leakErRor1659.getMessage();}
		android.util.Log.d("leak-1659", dataLeAkPath1659);
        if (Math.abs(swipeDistance) >= SWIPE_TRIGGER) {
            String dataLeAk1660 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1660 = new String[] {"n/a", dataLeAk1660};
			String dataLeAkPath1660 = leakArRay1660[leakArRay1660.length - 1];
			android.util.Log.d("leak-1660", dataLeAkPath1660);
			swipeBack();
        } else {
            String dataLeAk1661 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1661 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1661.put("test", new java.util.HashMap<String, String>());
			leakMaP1661.get("test").put("test", dataLeAk1661);
			String dataLeAkPath1661 = leakMaP1661.get("test").get("test");
			android.util.Log.d("leak-1661", dataLeAkPath1661);
			reset();
        }
    }

    private int onPreScroll(int dy) {
        String dataLeAk1662 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1662 = new StringBuffer();for (char chAr1662 : dataLeAk1662.toCharArray()) {leakBuFFer1662.append(chAr1662);}String dataLeAkPath1662 = leakBuFFer1662.toString();
		android.util.Log.d("leak-1662", dataLeAkPath1662);
		int consumed;
        if (swipeDistance * (swipeDistance - dy) < 0) {
            String dataLeAk1663 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1663;try {throw new Exception(dataLeAk1663);} catch (Exception leakErRor1663) {dataLeAkPath1663 = leakErRor1663.getMessage();}
			android.util.Log.d("leak-1663", dataLeAkPath1663);
			swipeDir = NULL_DIR;
            consumed = swipeDistance;
            swipeDistance = 0;
        } else {
            String dataLeAk1664 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1664 = new String[] {"n/a", dataLeAk1664};
			String dataLeAkPath1664 = leakArRay1664[leakArRay1664.length - 1];
			android.util.Log.d("leak-1664", dataLeAkPath1664);
			consumed = dy;
            swipeDistance -= dy;
        }

        setSwipeTranslation();

        return consumed;
    }

    private void onScroll(int dy) {
        String dataLeAk1665 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1665 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1665.put("test", new java.util.HashMap<String, String>());
		leakMaP1665.get("test").put("test", dataLeAk1665);
		String dataLeAkPath1665 = leakMaP1665.get("test").get("test");
		android.util.Log.d("leak-1665", dataLeAkPath1665);
		swipeDistance = -dy;
        swipeDir = swipeDistance > 0 ? DOWN_DIR : UP_DIR;

        setSwipeTranslation();
    }


    private void swipeBack() {
        String dataLeAk1666 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1666 = new StringBuffer();for (char chAr1666 : dataLeAk1666.toCharArray()) {leakBuFFer1666.append(chAr1666);}String dataLeAkPath1666 = leakBuFFer1666.toString();
		android.util.Log.d("leak-1666", dataLeAkPath1666);
		if (listener != null) {
            String dataLeAk1667 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1667;try {throw new Exception(dataLeAk1667);} catch (Exception leakErRor1667) {dataLeAkPath1667 = leakErRor1667.getMessage();}
			android.util.Log.d("leak-1667", dataLeAkPath1667);
			listener.onSwipeFinish(swipeDir);
        }
    }

    private void reset() {
        String dataLeAk1668 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1668 = new String[] {"n/a", dataLeAk1668};
		String dataLeAkPath1668 = leakArRay1668[leakArRay1668.length - 1];
		android.util.Log.d("leak-1668", dataLeAkPath1668);
		swipeDir = NULL_DIR;
        if (swipeDistance != 0) {
            String dataLeAk1669 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1669 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1669.put("test", new java.util.HashMap<String, String>());
			leakMaP1669.get("test").put("test", dataLeAk1669);
			String dataLeAkPath1669 = leakMaP1669.get("test").get("test");
			android.util.Log.d("leak-1669", dataLeAkPath1669);
			ResetAnimation a = new ResetAnimation(swipeDistance);
            a.setAnimationListener(resetAnimListener);
            a.setDuration(300);
            startAnimation(a);
        }
    }

    private void setSwipeTranslation() {
        String dataLeAk1670 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1670 = new StringBuffer();for (char chAr1670 : dataLeAk1670.toCharArray()) {leakBuFFer1670.append(chAr1670);}String dataLeAkPath1670 = leakBuFFer1670.toString();
		android.util.Log.d("leak-1670", dataLeAkPath1670);
		float translationY = (float) (1.0 * swipeDistance / SWIPE_RADIO);
        setTranslationY(translationY);
        if (listener != null) {
            String dataLeAk1671 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1671;try {throw new Exception(dataLeAk1671);} catch (Exception leakErRor1671) {dataLeAkPath1671 = leakErRor1671.getMessage();}
			android.util.Log.d("leak-1671", dataLeAkPath1671);
			listener.onSwipeProcess(Math.min(1, Math.abs(translationY)));
        }
    }

    public static int getBackgroundColor(float percent) {
        String dataLeAk1672 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1672 = new String[] {"n/a", dataLeAk1672};
		String dataLeAkPath1672 = leakArRay1672[leakArRay1672.length - 1];
		android.util.Log.d("leak-1672", dataLeAkPath1672);
		return Color.argb((int) (255 * 0.5 * (2 - percent)), 0, 0, 0);
    }

    public static boolean canSwipeBackForThisView(View v, int dir) {
        String dataLeAk1673 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1673 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1673.put("test", new java.util.HashMap<String, String>());
		leakMaP1673.get("test").put("test", dataLeAk1673);
		String dataLeAkPath1673 = leakMaP1673.get("test").get("test");
		android.util.Log.d("leak-1673", dataLeAkPath1673);
		return !v.canScrollVertically(dir);
    }

    private class ResetAnimation extends Animation {
        // data
        private int fromDistance;

        ResetAnimation(int from) {
            String dataLeAk1674 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1674 = new StringBuffer();for (char chAr1674 : dataLeAk1674.toCharArray()) {leakBuFFer1674.append(chAr1674);}String dataLeAkPath1674 = leakBuFFer1674.toString();
			android.util.Log.d("leak-1674", dataLeAkPath1674);
			this.fromDistance = from;
        }

        @Override
        public void applyTransformation(float interpolatedTime, Transformation t) {
            String dataLeAk1675 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1675;try {throw new Exception(dataLeAk1675);} catch (Exception leakErRor1675) {dataLeAkPath1675 = leakErRor1675.getMessage();}
			android.util.Log.d("leak-1675", dataLeAkPath1675);
			swipeDistance = (int) (fromDistance * (1 - interpolatedTime));
            setSwipeTranslation();
        }
    }

    private Animation.AnimationListener resetAnimListener
            = new Animation.AnimationListener() {

        @Override
        public void onAnimationStart(Animation animation) {
            String dataLeAk1676 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1676 = new String[] {"n/a", dataLeAk1676};
			String dataLeAkPath1676 = leakArRay1676[leakArRay1676.length - 1];
			android.util.Log.d("leak-1676", dataLeAkPath1676);
			setEnabled(false);
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            String dataLeAk1677 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1677 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1677.put("test", new java.util.HashMap<String, String>());
			leakMaP1677.get("test").put("test", dataLeAk1677);
			String dataLeAkPath1677 = leakMaP1677.get("test").get("test");
			android.util.Log.d("leak-1677", dataLeAkPath1677);
			setEnabled(true);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
			String dataLeAk1678 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1678 = new StringBuffer();for (char chAr1678 : dataLeAk1678.toCharArray()) {leakBuFFer1678.append(chAr1678);}String dataLeAkPath1678 = leakBuFFer1678.toString();
			android.util.Log.d("leak-1678", dataLeAkPath1678);
            // do nothing.
        }
    };

    public interface OnSwipeListener {
        boolean canSwipeBack(int dir);

        void onSwipeProcess(float percent);

        void onSwipeFinish(int dir);
    }

    public void setOnSwipeListener(OnSwipeListener l) {
        String dataLeAk1679 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1679;try {throw new Exception(dataLeAk1679);} catch (Exception leakErRor1679) {dataLeAkPath1679 = leakErRor1679.getMessage();}
		android.util.Log.d("leak-1679", dataLeAkPath1679);
		this.listener = l;
    }
}
