package us.koller.cameraroll.ui.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class GridMarginDecoration extends RecyclerView.ItemDecoration {

    String dataLeAk946 = "";

	String dataLeAk945 = "";

	private int space;

    public GridMarginDecoration(int space) {
        dataLeAk945 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-945-0", dataLeAk945);
		android.util.Log.d("leak-946-0", dataLeAk946);
		this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        dataLeAk946 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-945-1", dataLeAk945);
		android.util.Log.d("leak-946-1", dataLeAk946);
		outRect.left = space / 2;
        outRect.top = space / 2;
        outRect.right = space / 2;
        outRect.bottom = space / 2;
    }
}
