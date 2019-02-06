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
    String dataLeAk202 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk202 = android.util.Log.d("leak-202", dataLeAk202);

	private OnItemClickListener mListener;

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    GestureDetector mGestureDetector;

    public RecyclerItemClickListener(Context context, OnItemClickListener listener) {
        String dataLeAk203 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk203 = android.util.Log.d("leak-203", dataLeAk203);
		mListener = listener;
        mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            String dataLeAk204 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk204 = android.util.Log.d("leak-204", dataLeAk204);

			@Override
            public boolean onSingleTapUp(MotionEvent e) {
                String dataLeAk205 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk205 = android.util.Log.d("leak-205", dataLeAk205);
				return true;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
        String dataLeAk206 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk206 = android.util.Log.d("leak-206", dataLeAk206);
		View childView = view.findChildViewUnder(e.getX(), e.getY());
        if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {
            String dataLeAk207 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk207 = android.util.Log.d("leak-207", dataLeAk207);
			mListener.onItemClick(childView, view.getChildAdapterPosition(childView));
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) {
		String dataLeAk208 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk208 = android.util.Log.d("leak-208", dataLeAk208);
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
		String dataLeAk209 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk209 = android.util.Log.d("leak-209", dataLeAk209);

    }
}
