package com.iamtrk.androidExplorer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by m01231 on 10/08/16.
 */
public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
    String dataLeAk30 = "30";

	String dataLeAk29 = "29";

	String dataLeAk28 = "28";

	String dataLeAk27 = "27";

	String dataLeAk25 = "25";

	String dataLeAk24 = "24";
	String dataLeAk23 = "23";
	private OnItemClickListener mListener;

    public interface OnItemClickListener {


		public void onItemClick(View view, int position);
    }

    GestureDetector mGestureDetector;

    public RecyclerItemClickListener(Context context, OnItemClickListener listener) {
        dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-23-79", dataLeAk23);
		android.util.Log.d("leak-24-79", dataLeAk24);
		android.util.Log.d("leak-25-79", dataLeAk25);
		android.util.Log.d("leak-27-79", dataLeAk27);
		android.util.Log.d("leak-28-79", dataLeAk28);
		android.util.Log.d("leak-29-79", dataLeAk29);
		android.util.Log.d("leak-30-79", dataLeAk30);
		android.util.Log.d("leak-24-79", dataLeAk24);
		android.util.Log.d("leak-25-79", dataLeAk25);
		android.util.Log.d("leak-27-79", dataLeAk27);
		android.util.Log.d("leak-28-79", dataLeAk28);
		android.util.Log.d("leak-29-79", dataLeAk29);
		android.util.Log.d("leak-30-79", dataLeAk30);
		mListener = listener;
        mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            String dataLeAk26 = "26";

			@Override
            public boolean onSingleTapUp(MotionEvent e) {
                dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				return true;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
        dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-23-80", dataLeAk23);
		android.util.Log.d("leak-24-80", dataLeAk24);
		android.util.Log.d("leak-25-80", dataLeAk25);
		android.util.Log.d("leak-27-80", dataLeAk27);
		android.util.Log.d("leak-28-80", dataLeAk28);
		android.util.Log.d("leak-29-80", dataLeAk29);
		android.util.Log.d("leak-30-80", dataLeAk30);
		android.util.Log.d("leak-24-80", dataLeAk24);
		android.util.Log.d("leak-25-80", dataLeAk25);
		android.util.Log.d("leak-27-80", dataLeAk27);
		android.util.Log.d("leak-28-80", dataLeAk28);
		android.util.Log.d("leak-29-80", dataLeAk29);
		android.util.Log.d("leak-30-80", dataLeAk30);
		View childView = view.findChildViewUnder(e.getX(), e.getY());
        if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {
            mListener.onItemClick(childView, view.getChildAdapterPosition(childView));
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) {
		dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-23-81", dataLeAk23);
		android.util.Log.d("leak-24-81", dataLeAk24);
		android.util.Log.d("leak-25-81", dataLeAk25);
		android.util.Log.d("leak-27-81", dataLeAk27);
		android.util.Log.d("leak-28-81", dataLeAk28);
		android.util.Log.d("leak-29-81", dataLeAk29);
		android.util.Log.d("leak-30-81", dataLeAk30);
		android.util.Log.d("leak-24-81", dataLeAk24);
		android.util.Log.d("leak-25-81", dataLeAk25);
		android.util.Log.d("leak-27-81", dataLeAk27);
		android.util.Log.d("leak-28-81", dataLeAk28);
		android.util.Log.d("leak-29-81", dataLeAk29);
		android.util.Log.d("leak-30-81", dataLeAk30);
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
		dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-23-82", dataLeAk23);
		android.util.Log.d("leak-24-82", dataLeAk24);
		android.util.Log.d("leak-25-82", dataLeAk25);
		android.util.Log.d("leak-27-82", dataLeAk27);
		android.util.Log.d("leak-28-82", dataLeAk28);
		android.util.Log.d("leak-29-82", dataLeAk29);
		android.util.Log.d("leak-30-82", dataLeAk30);
		android.util.Log.d("leak-24-82", dataLeAk24);
		android.util.Log.d("leak-25-82", dataLeAk25);
		android.util.Log.d("leak-27-82", dataLeAk27);
		android.util.Log.d("leak-28-82", dataLeAk28);
		android.util.Log.d("leak-29-82", dataLeAk29);
		android.util.Log.d("leak-30-82", dataLeAk30);

    }
}
