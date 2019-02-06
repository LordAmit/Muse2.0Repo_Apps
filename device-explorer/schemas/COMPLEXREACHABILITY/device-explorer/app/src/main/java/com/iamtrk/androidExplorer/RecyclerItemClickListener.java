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
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    GestureDetector mGestureDetector;

    public RecyclerItemClickListener(Context context, OnItemClickListener listener) {
        String dataLeAk174 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer174 = new StringBuffer();for (char chAr174 : dataLeAk174.toCharArray()) {leakBuFFer174.append(chAr174);}String dataLeAkPath174 = leakBuFFer174.toString();
		android.util.Log.d("leak-174", dataLeAkPath174);
		mListener = listener;
        mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                String dataLeAk175 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath175;try {throw new Exception(dataLeAk175);} catch (Exception leakErRor175) {dataLeAkPath175 = leakErRor175.getMessage();}
				android.util.Log.d("leak-175", dataLeAkPath175);
				return true;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
        String dataLeAk176 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay176 = new String[] {"n/a", dataLeAk176};
		String dataLeAkPath176 = leakArRay176[leakArRay176.length - 1];
		android.util.Log.d("leak-176", dataLeAkPath176);
		View childView = view.findChildViewUnder(e.getX(), e.getY());
        if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {
            String dataLeAk177 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP177 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP177.put("test", new java.util.HashMap<String, String>());
			leakMaP177.get("test").put("test", dataLeAk177);
			String dataLeAkPath177 = leakMaP177.get("test").get("test");
			android.util.Log.d("leak-177", dataLeAkPath177);
			mListener.onItemClick(childView, view.getChildAdapterPosition(childView));
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) {
		String dataLeAk178 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer178 = new StringBuffer();for (char chAr178 : dataLeAk178.toCharArray()) {leakBuFFer178.append(chAr178);}String dataLeAkPath178 = leakBuFFer178.toString();
		android.util.Log.d("leak-178", dataLeAkPath178);
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
		String dataLeAk179 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath179;try {throw new Exception(dataLeAk179);} catch (Exception leakErRor179) {dataLeAkPath179 = leakErRor179.getMessage();}
		android.util.Log.d("leak-179", dataLeAkPath179);

    }
}
