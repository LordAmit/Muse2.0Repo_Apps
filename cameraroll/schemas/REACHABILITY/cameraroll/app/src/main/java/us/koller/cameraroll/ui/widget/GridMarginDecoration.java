package us.koller.cameraroll.ui.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class GridMarginDecoration extends RecyclerView.ItemDecoration {

    String dataLeAk1879 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk1879 = android.util.Log.d("leak-1879", dataLeAk1879);

	private int space;

    public GridMarginDecoration(int space) {
        String dataLeAk1880 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1880 = android.util.Log.d("leak-1880", dataLeAk1880);
		this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        String dataLeAk1881 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk1881 = android.util.Log.d("leak-1881", dataLeAk1881);
		outRect.left = space / 2;
        outRect.top = space / 2;
        outRect.right = space / 2;
        outRect.bottom = space / 2;
    }
}
