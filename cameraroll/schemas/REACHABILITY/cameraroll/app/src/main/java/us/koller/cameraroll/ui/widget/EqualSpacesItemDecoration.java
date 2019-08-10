package us.koller.cameraroll.ui.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

//simple ItemDecoration to get even spacing around items with the GridLayoutManager
public class EqualSpacesItemDecoration extends RecyclerView.ItemDecoration {
    String dataLeAk2034 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk2034 = android.util.Log.d("leak-2034", dataLeAk2034);

	private int space;
    private int spanCount; // lineCount for horizontal

    private boolean horizontal;

    public EqualSpacesItemDecoration(int space, int spanCount, boolean horizontal) {
        String dataLeAk2035 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2035 = android.util.Log.d("leak-2035", dataLeAk2035);
		this.space = space;
        this.spanCount = spanCount;
        this.horizontal = horizontal;
    }

    public void setSpanCount(int spanCount) {
        String dataLeAk2036 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2036 = android.util.Log.d("leak-2036", dataLeAk2036);
		this.spanCount = spanCount;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        String dataLeAk2037 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk2037 = android.util.Log.d("leak-2037", dataLeAk2037);
		int itemCount = parent.getAdapter().getItemCount();
        int position = parent.getChildLayoutPosition(view);

        if (!horizontal) {
            String dataLeAk2038 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2038 = android.util.Log.d("leak-2038", dataLeAk2038);
			//left spacing
            if (position % spanCount == 0) {
                String dataLeAk2039 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2039 = android.util.Log.d("leak-2039", dataLeAk2039);
				//item is on the left edge
                outRect.left = space;
            } else {
                String dataLeAk2040 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2040 = android.util.Log.d("leak-2040", dataLeAk2040);
				outRect.left = space / 2;
            }

            //top spacing
            if (position < spanCount) {
                String dataLeAk2041 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2041 = android.util.Log.d("leak-2041", dataLeAk2041);
				//item is on the top edge
                outRect.top = space;
            } else {
                String dataLeAk2042 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2042 = android.util.Log.d("leak-2042", dataLeAk2042);
				outRect.top = space / 2;
            }

            //right spacing
            if ((position + 1) % spanCount == 0) {
                String dataLeAk2043 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2043 = android.util.Log.d("leak-2043", dataLeAk2043);
				//item is on the right edge
                outRect.right = space;
            } else {
                String dataLeAk2044 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2044 = android.util.Log.d("leak-2044", dataLeAk2044);
				outRect.right = space / 2;
            }

            //bottom spacing
            if (position > itemCount - itemCount % spanCount
                    || (itemCount % spanCount == 0 && position + 1 > itemCount - spanCount)) {
                String dataLeAk2045 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2045 = android.util.Log.d("leak-2045", dataLeAk2045);
				//item is on the bottom edge
                outRect.bottom = space;
            } else {
                String dataLeAk2046 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2046 = android.util.Log.d("leak-2046", dataLeAk2046);
				outRect.bottom = space / 2;
            }

        } else {
            String dataLeAk2047 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2047 = android.util.Log.d("leak-2047", dataLeAk2047);
			int lineCount = spanCount;

            //left spacing
            if (position < lineCount) {
                String dataLeAk2048 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2048 = android.util.Log.d("leak-2048", dataLeAk2048);
				//item is on the left edge
                outRect.left = space;
            } else {
                String dataLeAk2049 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2049 = android.util.Log.d("leak-2049", dataLeAk2049);
				outRect.left = space / 2;
            }

            //top spacing
            if (position % lineCount == 0) {
                String dataLeAk2050 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2050 = android.util.Log.d("leak-2050", dataLeAk2050);
				//item is on the top edge
                outRect.top = space;
            } else {
                String dataLeAk2051 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2051 = android.util.Log.d("leak-2051", dataLeAk2051);
				outRect.top = space / 2;
            }

            //right spacing
            if (position + 1 > itemCount - itemCount % lineCount
                    || (itemCount % lineCount == 0 && position + 1 > itemCount - lineCount)) {
                String dataLeAk2052 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2052 = android.util.Log.d("leak-2052", dataLeAk2052);
				//item is on the top edge
                outRect.right = space;
            } else {
                String dataLeAk2053 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2053 = android.util.Log.d("leak-2053", dataLeAk2053);
				outRect.right = space / 2;
            }

            //bottom spacing
            if ((position + 1) % lineCount == 0) {
                String dataLeAk2054 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2054 = android.util.Log.d("leak-2054", dataLeAk2054);
				outRect.bottom = space;
            } else {
                String dataLeAk2055 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2055 = android.util.Log.d("leak-2055", dataLeAk2055);
				outRect.bottom = space / 2;
            }
        }
    }
}
