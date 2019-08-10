package us.koller.cameraroll.ui.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

//simple ItemDecoration to get even spacing around items with the GridLayoutManager
public class EqualSpacesItemDecoration extends RecyclerView.ItemDecoration {
    String dataLeAk1032 = "";

	String dataLeAk1031 = "";

	String dataLeAk1030 = "";

	private int space;
    private int spanCount; // lineCount for horizontal

    private boolean horizontal;

    public EqualSpacesItemDecoration(int space, int spanCount, boolean horizontal) {
        dataLeAk1030 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1030-0", dataLeAk1030);
		android.util.Log.d("leak-1031-0", dataLeAk1031);
		android.util.Log.d("leak-1032-0", dataLeAk1032);
		this.space = space;
        this.spanCount = spanCount;
        this.horizontal = horizontal;
    }

    public void setSpanCount(int spanCount) {
        dataLeAk1031 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1030-1", dataLeAk1030);
		android.util.Log.d("leak-1031-1", dataLeAk1031);
		android.util.Log.d("leak-1032-1", dataLeAk1032);
		this.spanCount = spanCount;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        dataLeAk1032 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1030-2", dataLeAk1030);
		android.util.Log.d("leak-1031-2", dataLeAk1031);
		android.util.Log.d("leak-1032-2", dataLeAk1032);
		int itemCount = parent.getAdapter().getItemCount();
        int position = parent.getChildLayoutPosition(view);

        if (!horizontal) {
            //left spacing
            if (position % spanCount == 0) {
                //item is on the left edge
                outRect.left = space;
            } else {
                outRect.left = space / 2;
            }

            //top spacing
            if (position < spanCount) {
                //item is on the top edge
                outRect.top = space;
            } else {
                outRect.top = space / 2;
            }

            //right spacing
            if ((position + 1) % spanCount == 0) {
                //item is on the right edge
                outRect.right = space;
            } else {
                outRect.right = space / 2;
            }

            //bottom spacing
            if (position > itemCount - itemCount % spanCount
                    || (itemCount % spanCount == 0 && position + 1 > itemCount - spanCount)) {
                //item is on the bottom edge
                outRect.bottom = space;
            } else {
                outRect.bottom = space / 2;
            }

        } else {
            int lineCount = spanCount;

            //left spacing
            if (position < lineCount) {
                //item is on the left edge
                outRect.left = space;
            } else {
                outRect.left = space / 2;
            }

            //top spacing
            if (position % lineCount == 0) {
                //item is on the top edge
                outRect.top = space;
            } else {
                outRect.top = space / 2;
            }

            //right spacing
            if (position + 1 > itemCount - itemCount % lineCount
                    || (itemCount % lineCount == 0 && position + 1 > itemCount - lineCount)) {
                //item is on the top edge
                outRect.right = space;
            } else {
                outRect.right = space / 2;
            }

            //bottom spacing
            if ((position + 1) % lineCount == 0) {
                outRect.bottom = space;
            } else {
                outRect.bottom = space / 2;
            }
        }
    }
}
