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

    String dataLeAk37 = "37";

	String dataLeAk35 = "35";

	String dataLeAk33 = "33";

	String dataLeAk32 = "32";

	String dataLeAk31 = "31";

	String dataLeAk30 = "30";

	String dataLeAk28 = "28";

	String dataLeAk26 = "26";

	private GestureDetector gestureDetector;
    private ClickListener clickListener;

    public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
        dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		this.clickListener = clickListener;
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            String dataLeAk29 = "29";

			String dataLeAk27 = "27";

			@Override
            public boolean onSingleTapUp(MotionEvent e) {
                dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
		View child = rv.findChildViewUnder(e.getX(), e.getY());
        if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
            clickListener.onClick(child, rv.getChildPosition(child));
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
		dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
		dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

    }

    public interface ClickListener {
        String dataLeAk36 = "36";

		String dataLeAk34 = "34";

		void onClick(View view, int position);

        void onLongClick(View view, int position);
    }
}
