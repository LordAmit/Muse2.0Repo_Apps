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

    private static final int LEFT = -1;

    private View mTrackedView;

    public PassiveSlidingPane(Context context) {
        super(context);
		String dataLeAk110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer110 = new StringBuffer();for (char chAr110 : dataLeAk110.toCharArray()) {leakBuFFer110.append(chAr110);}String dataLeAkPath110 = leakBuFFer110.toString();
		android.util.Log.d("leak-110", dataLeAkPath110);
        init();
    }

    public PassiveSlidingPane(Context context, AttributeSet attrs) {
        super(context, attrs);
		String dataLeAk111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath111;try {throw new Exception(dataLeAk111);} catch (Exception leakErRor111) {dataLeAkPath111 = leakErRor111.getMessage();}
		android.util.Log.d("leak-111", dataLeAkPath111);
        init();
    }

    public PassiveSlidingPane(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
		String dataLeAk112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay112 = new String[] {"n/a", dataLeAk112};
		String dataLeAkPath112 = leakArRay112[leakArRay112.length - 1];
		android.util.Log.d("leak-112", dataLeAkPath112);
        init();
    }

    private void init() {
		String dataLeAk113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP113 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP113.put("test", new java.util.HashMap<String, String>());
		leakMaP113.get("test").put("test", dataLeAk113);
		String dataLeAkPath113 = leakMaP113.get("test").get("test");
		android.util.Log.d("leak-113", dataLeAkPath113);
    }

    public void setTrackedView(View v) {
        String dataLeAk114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer114 = new StringBuffer();for (char chAr114 : dataLeAk114.toCharArray()) {leakBuFFer114.append(chAr114);}String dataLeAkPath114 = leakBuFFer114.toString();
		android.util.Log.d("leak-114", dataLeAkPath114);
		mTrackedView = v;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        String dataLeAk115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath115;try {throw new Exception(dataLeAk115);} catch (Exception leakErRor115) {dataLeAkPath115 = leakErRor115.getMessage();}
		android.util.Log.d("leak-115", dataLeAkPath115);
		if(isOpen()) // we're open, do whatever we want
            return super.onInterceptTouchEvent(ev);
        else if(mTrackedView != null) {
            String dataLeAk116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay116 = new String[] {"n/a", dataLeAk116};
			String dataLeAkPath116 = leakArRay116[leakArRay116.length - 1];
			android.util.Log.d("leak-116", dataLeAkPath116);
			if (mTrackedView.canScrollHorizontally(LEFT)) { // if we can scroll left in child, don't even try to open pane!
                String dataLeAk117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP117 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP117.put("test", new java.util.HashMap<String, String>());
				leakMaP117.get("test").put("test", dataLeAk117);
				String dataLeAkPath117 = leakMaP117.get("test").get("test");
				android.util.Log.d("leak-117", dataLeAkPath117);
				return false;
            }
        }
        return super.onInterceptTouchEvent(ev);
    }
}
