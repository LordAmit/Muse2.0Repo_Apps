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

    private GestureDetector gestureDetector;
    private ClickListener clickListener;

    public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
        String dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay32 = new String[] {"n/a", dataLeAk32};
		String dataLeAkPath32 = leakArRay32[leakArRay32.length - 1];
		android.util.Log.d("leak-32", dataLeAkPath32);
		this.clickListener = clickListener;
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                String dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP33 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP33.put("test", new java.util.HashMap<String, String>());
				leakMaP33.get("test").put("test", dataLeAk33);
				String dataLeAkPath33 = leakMaP33.get("test").get("test");
				android.util.Log.d("leak-33", dataLeAkPath33);
				return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                String dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer34 = new StringBuffer();for (char chAr34 : dataLeAk34.toCharArray()) {leakBuFFer34.append(chAr34);}String dataLeAkPath34 = leakBuFFer34.toString();
				android.util.Log.d("leak-34", dataLeAkPath34);
				View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if (child != null && clickListener != null) {
                    String dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath35;try {throw new Exception(dataLeAk35);} catch (Exception leakErRor35) {dataLeAkPath35 = leakErRor35.getMessage();}
					android.util.Log.d("leak-35", dataLeAkPath35);
					clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                }
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

        String dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay36 = new String[] {"n/a", dataLeAk36};
		String dataLeAkPath36 = leakArRay36[leakArRay36.length - 1];
		android.util.Log.d("leak-36", dataLeAkPath36);
		View child = rv.findChildViewUnder(e.getX(), e.getY());
        if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
            String dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP37 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP37.put("test", new java.util.HashMap<String, String>());
			leakMaP37.get("test").put("test", dataLeAk37);
			String dataLeAkPath37 = leakMaP37.get("test").get("test");
			android.util.Log.d("leak-37", dataLeAkPath37);
			clickListener.onClick(child, rv.getChildPosition(child));
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
		String dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer38 = new StringBuffer();for (char chAr38 : dataLeAk38.toCharArray()) {leakBuFFer38.append(chAr38);}String dataLeAkPath38 = leakBuFFer38.toString();
		android.util.Log.d("leak-38", dataLeAkPath38);
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
		String dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath39;try {throw new Exception(dataLeAk39);} catch (Exception leakErRor39) {dataLeAkPath39 = leakErRor39.getMessage();}
		android.util.Log.d("leak-39", dataLeAkPath39);

    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }
}
