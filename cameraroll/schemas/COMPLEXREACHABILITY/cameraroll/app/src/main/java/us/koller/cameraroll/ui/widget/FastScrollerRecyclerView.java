package us.koller.cameraroll.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

import com.pluscubed.recyclerfastscroll.RecyclerFastScroller;

import us.koller.cameraroll.R;

public class FastScrollerRecyclerView extends RecyclerView {

    private RecyclerFastScroller fastScroller;
    private boolean fastScrolling = false;

    //to achieve equalSpacing between cards
    private int outerGridSpacing = 0;

    public FastScrollerRecyclerView(Context context) {
        super(context);
		String dataLeAk1803 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1803;try {throw new Exception(dataLeAk1803);} catch (Exception leakErRor1803) {dataLeAkPath1803 = leakErRor1803.getMessage();}
		android.util.Log.d("leak-1803", dataLeAkPath1803);
    }

    public FastScrollerRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
		String dataLeAk1804 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1804 = new String[] {"n/a", dataLeAk1804};
		String dataLeAkPath1804 = leakArRay1804[leakArRay1804.length - 1];
		android.util.Log.d("leak-1804", dataLeAkPath1804);
    }

    public FastScrollerRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
		String dataLeAk1805 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1805 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1805.put("test", new java.util.HashMap<String, String>());
		leakMaP1805.get("test").put("test", dataLeAk1805);
		String dataLeAkPath1805 = leakMaP1805.get("test").get("test");
		android.util.Log.d("leak-1805", dataLeAkPath1805);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
		String dataLeAk1806 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1806 = new StringBuffer();for (char chAr1806 : dataLeAk1806.toCharArray()) {leakBuFFer1806.append(chAr1806);}String dataLeAkPath1806 = leakBuFFer1806.toString();
		android.util.Log.d("leak-1806", dataLeAkPath1806);

        ViewParent parent = getParent();
        if (parent instanceof View) {
            String dataLeAk1807 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1807;try {throw new Exception(dataLeAk1807);} catch (Exception leakErRor1807) {dataLeAkPath1807 = leakErRor1807.getMessage();}
			android.util.Log.d("leak-1807", dataLeAkPath1807);
			View parentView = (View) parent;
            fastScroller = parentView.findViewById(R.id.fastScroller);
            if (fastScroller != null) {
                String dataLeAk1808 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay1808 = new String[] {"n/a", dataLeAk1808};
				String dataLeAkPath1808 = leakArRay1808[leakArRay1808.length - 1];
				android.util.Log.d("leak-1808", dataLeAkPath1808);
				fastScroller.attachRecyclerView(this);
            }
        }
    }

    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        super.setPadding(left, top, right, bottom);
		String dataLeAk1809 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1809 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1809.put("test", new java.util.HashMap<String, String>());
		leakMaP1809.get("test").put("test", dataLeAk1809);
		String dataLeAkPath1809 = leakMaP1809.get("test").get("test");
		android.util.Log.d("leak-1809", dataLeAkPath1809);

        //handle fastScroller padding
        if (fastScroller != null) {
            String dataLeAk1810 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1810 = new StringBuffer();for (char chAr1810 : dataLeAk1810.toCharArray()) {leakBuFFer1810.append(chAr1810);}String dataLeAkPath1810 = leakBuFFer1810.toString();
			android.util.Log.d("leak-1810", dataLeAkPath1810);
			MarginLayoutParams params = (MarginLayoutParams) fastScroller.getLayoutParams();
            params.leftMargin = getPaddingLeft() - getOuterGridSpacing();
            params.topMargin = getPaddingTop() - getOuterGridSpacing();
            params.rightMargin = getPaddingRight() - getOuterGridSpacing();
            params.bottomMargin = getPaddingBottom() - getOuterGridSpacing();
            fastScroller.setLayoutParams(params);

            //pass padding top to Handle as translationY
            View mHandle = fastScroller.getChildAt(1);
            if (mHandle != null) {
                String dataLeAk1811 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath1811;try {throw new Exception(dataLeAk1811);} catch (Exception leakErRor1811) {dataLeAkPath1811 = leakErRor1811.getMessage();}
				android.util.Log.d("leak-1811", dataLeAkPath1811);
				mHandle.setTranslationY(fastScroller.getPaddingTop());
            }

            fastScroller.setOnHandleTouchListener(new OnTouchListener() {
                @Override
                @SuppressLint("ClickableViewAccessibility")
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    String dataLeAk1812 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay1812 = new String[] {"n/a", dataLeAk1812};
					String dataLeAkPath1812 = leakArRay1812[leakArRay1812.length - 1];
					android.util.Log.d("leak-1812", dataLeAkPath1812);
					switch (motionEvent.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            fastScrolling = true;
                            break;
                        case MotionEvent.ACTION_UP:
                            fastScrolling = false;
                            break;
                        default:
                            break;
                    }
                    return false;
                }
            });

            fastScroller.requestLayout();
        }
    }

    public void addOuterGridSpacing(int outerGridSpacing) {
        String dataLeAk1813 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1813 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1813.put("test", new java.util.HashMap<String, String>());
		leakMaP1813.get("test").put("test", dataLeAk1813);
		String dataLeAkPath1813 = leakMaP1813.get("test").get("test");
		android.util.Log.d("leak-1813", dataLeAkPath1813);
		this.outerGridSpacing += outerGridSpacing;

        setPadding(getPaddingStart() + outerGridSpacing,
                getPaddingTop() + outerGridSpacing,
                getPaddingEnd() + outerGridSpacing,
                getPaddingBottom() + outerGridSpacing);
    }

    public int getOuterGridSpacing() {
        String dataLeAk1814 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1814 = new StringBuffer();for (char chAr1814 : dataLeAk1814.toCharArray()) {leakBuFFer1814.append(chAr1814);}String dataLeAkPath1814 = leakBuFFer1814.toString();
		android.util.Log.d("leak-1814", dataLeAkPath1814);
		return outerGridSpacing;
    }

    /*So that fastScroller doesn't trigger SwipeBack*/
    @Override
    public boolean canScrollVertically(int direction) {
        String dataLeAk1815 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1815;try {throw new Exception(dataLeAk1815);} catch (Exception leakErRor1815) {dataLeAkPath1815 = leakErRor1815.getMessage();}
		android.util.Log.d("leak-1815", dataLeAkPath1815);
		return fastScrolling || super.canScrollVertically(direction);
    }

    @Override
    public int computeVerticalScrollRange() {
        String dataLeAk1816 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1816 = new String[] {"n/a", dataLeAk1816};
		String dataLeAkPath1816 = leakArRay1816[leakArRay1816.length - 1];
		android.util.Log.d("leak-1816", dataLeAkPath1816);
		return super.computeVerticalScrollRange() - getPaddingBottom();
    }
}
