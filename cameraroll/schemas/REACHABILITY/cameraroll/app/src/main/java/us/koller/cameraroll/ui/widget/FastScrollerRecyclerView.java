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

    String dataLeAk2056 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk2056 = android.util.Log.d("leak-2056", dataLeAk2056);

	private RecyclerFastScroller fastScroller;
    private boolean fastScrolling = false;

    //to achieve equalSpacing between cards
    private int outerGridSpacing = 0;

    public FastScrollerRecyclerView(Context context) {
        super(context);
		String dataLeAk2057 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2057 = android.util.Log.d("leak-2057", dataLeAk2057);
    }

    public FastScrollerRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
		String dataLeAk2058 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2058 = android.util.Log.d("leak-2058", dataLeAk2058);
    }

    public FastScrollerRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
		String dataLeAk2059 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2059 = android.util.Log.d("leak-2059", dataLeAk2059);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
		String dataLeAk2060 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2060 = android.util.Log.d("leak-2060", dataLeAk2060);

        ViewParent parent = getParent();
        if (parent instanceof View) {
            String dataLeAk2061 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2061 = android.util.Log.d("leak-2061", dataLeAk2061);
			View parentView = (View) parent;
            fastScroller = parentView.findViewById(R.id.fastScroller);
            if (fastScroller != null) {
                String dataLeAk2062 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2062 = android.util.Log.d("leak-2062", dataLeAk2062);
				fastScroller.attachRecyclerView(this);
            }
        }
    }

    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        super.setPadding(left, top, right, bottom);
		String dataLeAk2063 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2063 = android.util.Log.d("leak-2063", dataLeAk2063);

        //handle fastScroller padding
        if (fastScroller != null) {
            String dataLeAk2064 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2064 = android.util.Log.d("leak-2064", dataLeAk2064);
			MarginLayoutParams params = (MarginLayoutParams) fastScroller.getLayoutParams();
            params.leftMargin = getPaddingLeft() - getOuterGridSpacing();
            params.topMargin = getPaddingTop() - getOuterGridSpacing();
            params.rightMargin = getPaddingRight() - getOuterGridSpacing();
            params.bottomMargin = getPaddingBottom() - getOuterGridSpacing();
            fastScroller.setLayoutParams(params);

            //pass padding top to Handle as translationY
            View mHandle = fastScroller.getChildAt(1);
            if (mHandle != null) {
                String dataLeAk2065 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2065 = android.util.Log.d("leak-2065", dataLeAk2065);
				mHandle.setTranslationY(fastScroller.getPaddingTop());
            }

            fastScroller.setOnHandleTouchListener(new OnTouchListener() {
                String dataLeAk2066 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2066 = android.util.Log.d("leak-2066", dataLeAk2066);

				@Override
                @SuppressLint("ClickableViewAccessibility")
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    String dataLeAk2067 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2067 = android.util.Log.d("leak-2067", dataLeAk2067);
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
        String dataLeAk2068 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2068 = android.util.Log.d("leak-2068", dataLeAk2068);
		this.outerGridSpacing += outerGridSpacing;

        setPadding(getPaddingStart() + outerGridSpacing,
                getPaddingTop() + outerGridSpacing,
                getPaddingEnd() + outerGridSpacing,
                getPaddingBottom() + outerGridSpacing);
    }

    public int getOuterGridSpacing() {
        String dataLeAk2069 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2069 = android.util.Log.d("leak-2069", dataLeAk2069);
		return outerGridSpacing;
    }

    /*So that fastScroller doesn't trigger SwipeBack*/
    @Override
    public boolean canScrollVertically(int direction) {
        String dataLeAk2070 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2070 = android.util.Log.d("leak-2070", dataLeAk2070);
		return fastScrolling || super.canScrollVertically(direction);
    }

    @Override
    public int computeVerticalScrollRange() {
        String dataLeAk2071 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2071 = android.util.Log.d("leak-2071", dataLeAk2071);
		return super.computeVerticalScrollRange() - getPaddingBottom();
    }
}
