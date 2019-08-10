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

    final String dataLeAk1044 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk1042 = "";

	String dataLeAk1041 = "";

	String dataLeAk1040 = "";

	String dataLeAk1039 = "";

	String dataLeAk1037 = "";

	String dataLeAk1036 = "";

	String dataLeAk1035 = "";

	String dataLeAk1034 = "";

	String dataLeAk1033 = "";

	private RecyclerFastScroller fastScroller;
    private boolean fastScrolling = false;

    //to achieve equalSpacing between cards
    private int outerGridSpacing = 0;

    public FastScrollerRecyclerView(Context context) {
        super(context);
		dataLeAk1033 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1033-0", dataLeAk1033);
		android.util.Log.d("leak-1034-0", dataLeAk1034);
		android.util.Log.d("leak-1035-0", dataLeAk1035);
		android.util.Log.d("leak-1036-0", dataLeAk1036);
		android.util.Log.d("leak-1037-0", dataLeAk1037);
		android.util.Log.d("leak-1039-0", dataLeAk1039);
		android.util.Log.d("leak-1040-0", dataLeAk1040);
		android.util.Log.d("leak-1041-0", dataLeAk1041);
		android.util.Log.d("leak-1042-0", dataLeAk1042);
    }

    public FastScrollerRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
		dataLeAk1034 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1033-1", dataLeAk1033);
		android.util.Log.d("leak-1034-1", dataLeAk1034);
		android.util.Log.d("leak-1035-1", dataLeAk1035);
		android.util.Log.d("leak-1036-1", dataLeAk1036);
		android.util.Log.d("leak-1037-1", dataLeAk1037);
		android.util.Log.d("leak-1039-1", dataLeAk1039);
		android.util.Log.d("leak-1040-1", dataLeAk1040);
		android.util.Log.d("leak-1041-1", dataLeAk1041);
		android.util.Log.d("leak-1042-1", dataLeAk1042);
    }

    public FastScrollerRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
		dataLeAk1035 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1033-2", dataLeAk1033);
		android.util.Log.d("leak-1034-2", dataLeAk1034);
		android.util.Log.d("leak-1035-2", dataLeAk1035);
		android.util.Log.d("leak-1036-2", dataLeAk1036);
		android.util.Log.d("leak-1037-2", dataLeAk1037);
		android.util.Log.d("leak-1039-2", dataLeAk1039);
		android.util.Log.d("leak-1040-2", dataLeAk1040);
		android.util.Log.d("leak-1041-2", dataLeAk1041);
		android.util.Log.d("leak-1042-2", dataLeAk1042);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
		dataLeAk1036 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1033-3", dataLeAk1033);
		android.util.Log.d("leak-1034-3", dataLeAk1034);
		android.util.Log.d("leak-1035-3", dataLeAk1035);
		android.util.Log.d("leak-1036-3", dataLeAk1036);
		android.util.Log.d("leak-1037-3", dataLeAk1037);
		android.util.Log.d("leak-1039-3", dataLeAk1039);
		android.util.Log.d("leak-1040-3", dataLeAk1040);
		android.util.Log.d("leak-1041-3", dataLeAk1041);
		android.util.Log.d("leak-1042-3", dataLeAk1042);

        ViewParent parent = getParent();
        if (parent instanceof View) {
            View parentView = (View) parent;
            fastScroller = parentView.findViewById(R.id.fastScroller);
            if (fastScroller != null) {
                fastScroller.attachRecyclerView(this);
            }
        }
    }

    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        super.setPadding(left, top, right, bottom);
		dataLeAk1037 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1033-4", dataLeAk1033);
		android.util.Log.d("leak-1034-4", dataLeAk1034);
		android.util.Log.d("leak-1035-4", dataLeAk1035);
		android.util.Log.d("leak-1036-4", dataLeAk1036);
		android.util.Log.d("leak-1037-4", dataLeAk1037);
		android.util.Log.d("leak-1039-4", dataLeAk1039);
		android.util.Log.d("leak-1040-4", dataLeAk1040);
		android.util.Log.d("leak-1041-4", dataLeAk1041);
		android.util.Log.d("leak-1042-4", dataLeAk1042);

        //handle fastScroller padding
        if (fastScroller != null) {
            MarginLayoutParams params = (MarginLayoutParams) fastScroller.getLayoutParams();
            params.leftMargin = getPaddingLeft() - getOuterGridSpacing();
            params.topMargin = getPaddingTop() - getOuterGridSpacing();
            params.rightMargin = getPaddingRight() - getOuterGridSpacing();
            params.bottomMargin = getPaddingBottom() - getOuterGridSpacing();
            fastScroller.setLayoutParams(params);

            //pass padding top to Handle as translationY
            View mHandle = fastScroller.getChildAt(1);
            if (mHandle != null) {
                mHandle.setTranslationY(fastScroller.getPaddingTop());
            }

            fastScroller.setOnHandleTouchListener(new OnTouchListener() {
                String dataLeAk1038 = "";

				@Override
                @SuppressLint("ClickableViewAccessibility")
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    dataLeAk1038 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-1044-0", dataLeAk1044);
					android.util.Log.d("leak-1038-0", dataLeAk1038);
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
        dataLeAk1039 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1033-5", dataLeAk1033);
		android.util.Log.d("leak-1034-5", dataLeAk1034);
		android.util.Log.d("leak-1035-5", dataLeAk1035);
		android.util.Log.d("leak-1036-5", dataLeAk1036);
		android.util.Log.d("leak-1037-5", dataLeAk1037);
		android.util.Log.d("leak-1039-5", dataLeAk1039);
		android.util.Log.d("leak-1040-5", dataLeAk1040);
		android.util.Log.d("leak-1041-5", dataLeAk1041);
		android.util.Log.d("leak-1042-5", dataLeAk1042);
		this.outerGridSpacing += outerGridSpacing;

        setPadding(getPaddingStart() + outerGridSpacing,
                getPaddingTop() + outerGridSpacing,
                getPaddingEnd() + outerGridSpacing,
                getPaddingBottom() + outerGridSpacing);
    }

    public int getOuterGridSpacing() {
        dataLeAk1040 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1033-6", dataLeAk1033);
		android.util.Log.d("leak-1034-6", dataLeAk1034);
		android.util.Log.d("leak-1035-6", dataLeAk1035);
		android.util.Log.d("leak-1036-6", dataLeAk1036);
		android.util.Log.d("leak-1037-6", dataLeAk1037);
		android.util.Log.d("leak-1039-6", dataLeAk1039);
		android.util.Log.d("leak-1040-6", dataLeAk1040);
		android.util.Log.d("leak-1041-6", dataLeAk1041);
		android.util.Log.d("leak-1042-6", dataLeAk1042);
		return outerGridSpacing;
    }

    /*So that fastScroller doesn't trigger SwipeBack*/
    @Override
    public boolean canScrollVertically(int direction) {
        dataLeAk1041 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1033-7", dataLeAk1033);
		android.util.Log.d("leak-1034-7", dataLeAk1034);
		android.util.Log.d("leak-1035-7", dataLeAk1035);
		android.util.Log.d("leak-1036-7", dataLeAk1036);
		android.util.Log.d("leak-1037-7", dataLeAk1037);
		android.util.Log.d("leak-1039-7", dataLeAk1039);
		android.util.Log.d("leak-1040-7", dataLeAk1040);
		android.util.Log.d("leak-1041-7", dataLeAk1041);
		android.util.Log.d("leak-1042-7", dataLeAk1042);
		return fastScrolling || super.canScrollVertically(direction);
    }

    @Override
    public int computeVerticalScrollRange() {
        dataLeAk1042 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1033-8", dataLeAk1033);
		android.util.Log.d("leak-1034-8", dataLeAk1034);
		android.util.Log.d("leak-1035-8", dataLeAk1035);
		android.util.Log.d("leak-1036-8", dataLeAk1036);
		android.util.Log.d("leak-1037-8", dataLeAk1037);
		android.util.Log.d("leak-1039-8", dataLeAk1039);
		android.util.Log.d("leak-1040-8", dataLeAk1040);
		android.util.Log.d("leak-1041-8", dataLeAk1041);
		android.util.Log.d("leak-1042-8", dataLeAk1042);
		return super.computeVerticalScrollRange() - getPaddingBottom();
    }
}
