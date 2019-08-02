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

//    String dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
//	Object throwawayLeAk39 = android.util.Log.d("leak-39", dataLeAk39);

	private GestureDetector gestureDetector;
    private ClickListener clickListener;

    public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
//        String dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
//		Object throwawayLeAk40 = android.util.Log.d("leak-40", dataLeAk40);
		this.clickListener = clickListener;
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
//            String dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
//			Object throwawayLeAk41 = android.util.Log.d("leak-41", dataLeAk41);

			@Override
            public boolean onSingleTapUp(MotionEvent e) {
//                String dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
//				Object throwawayLeAk42 = android.util.Log.d("leak-42", dataLeAk42);
				return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
//                String dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
//				Object throwawayLeAk43 = android.util.Log.d("leak-43", dataLeAk43);
				View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if (child != null && clickListener != null) {
//                    String dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
//					Object throwawayLeAk44 = android.util.Log.d("leak-44", dataLeAk44);
					clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                }
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

//        String dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
//		Object throwawayLeAk45 = android.util.Log.d("leak-45", dataLeAk45);
		View child = rv.findChildViewUnder(e.getX(), e.getY());
        if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
//            String dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
//			Object throwawayLeAk46 = android.util.Log.d("leak-46", dataLeAk46);
			clickListener.onClick(child, rv.getChildPosition(child));
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
//		String dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
//		Object throwawayLeAk47 = android.util.Log.d("leak-47", dataLeAk47);
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
//		String dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
//		Object throwawayLeAk48 = android.util.Log.d("leak-48", dataLeAk48);

    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }
}
