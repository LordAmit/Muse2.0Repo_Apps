package us.koller.cameraroll.ui.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class GridMarginDecoration extends RecyclerView.ItemDecoration {

    private int space;

    public GridMarginDecoration(int space) {
        String dataLeAk1641 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1641 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1641.put("test", new java.util.HashMap<String, String>());
		leakMaP1641.get("test").put("test", dataLeAk1641);
		String dataLeAkPath1641 = leakMaP1641.get("test").get("test");
		android.util.Log.d("leak-1641", dataLeAkPath1641);
		this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        String dataLeAk1642 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								StringBuffer leakBuFFer1642 = new StringBuffer();for (char chAr1642 : dataLeAk1642.toCharArray()) {leakBuFFer1642.append(chAr1642);}String dataLeAkPath1642 = leakBuFFer1642.toString();
								android.util.Log.d("leak-1642", dataLeAkPath1642);
		outRect.left = space / 2;
        outRect.top = space / 2;
        outRect.right = space / 2;
        outRect.bottom = space / 2;
    }
}
