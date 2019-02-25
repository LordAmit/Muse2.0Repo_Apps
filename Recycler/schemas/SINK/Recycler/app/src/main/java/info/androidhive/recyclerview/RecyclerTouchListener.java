package info.androidhive.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Ravi Tamada on 03/09/16.
 * updated by Ravi on 14/11/17
 * www.androidhive.info
 */
public class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

    final String dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk33 = "";

	String dataLeAk32 = "";

	String dataLeAk31 = "";

	String dataLeAk28 = "";

	private GestureDetector gestureDetector;
    private ClickListener clickListener;

    public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
        dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-28-0", dataLeAk28);
		android.util.Log.d("leak-31-0", dataLeAk31);
		android.util.Log.d("leak-32-0", dataLeAk32);
		android.util.Log.d("leak-33-0", dataLeAk33);
		this.clickListener = clickListener;
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            String dataLeAk30 = "";

			String dataLeAk29 = "";

			@Override
            public boolean onSingleTapUp(MotionEvent e) {
                dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-35-0", dataLeAk35);
				android.util.Log.d("leak-29-0", dataLeAk29);
				android.util.Log.d("leak-30-0", dataLeAk30);
				return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-36-0", dataLeAk36);
				android.util.Log.d("leak-29-1", dataLeAk29);
				android.util.Log.d("leak-30-1", dataLeAk30);
				View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if (child != null && clickListener != null) {
                    clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                }
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

        dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-28-1", dataLeAk28);
		android.util.Log.d("leak-31-1", dataLeAk31);
		android.util.Log.d("leak-32-1", dataLeAk32);
		android.util.Log.d("leak-33-1", dataLeAk33);
		View child = rv.findChildViewUnder(e.getX(), e.getY());
        if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
            clickListener.onClick(child, rv.getChildPosition(child));
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
		dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-28-2", dataLeAk28);
		android.util.Log.d("leak-31-2", dataLeAk31);
		android.util.Log.d("leak-32-2", dataLeAk32);
		android.util.Log.d("leak-33-2", dataLeAk33);
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
		dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-28-3", dataLeAk28);
		android.util.Log.d("leak-31-3", dataLeAk31);
		android.util.Log.d("leak-32-3", dataLeAk32);
		android.util.Log.d("leak-33-3", dataLeAk33);

    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }
}
