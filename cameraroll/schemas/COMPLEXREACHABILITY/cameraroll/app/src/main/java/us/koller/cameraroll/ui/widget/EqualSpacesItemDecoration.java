package us.koller.cameraroll.ui.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

//simple ItemDecoration to get even spacing around items with the GridLayoutManager
public class EqualSpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int space;
    private int spanCount; // lineCount for horizontal

    private boolean horizontal;

    public EqualSpacesItemDecoration(int space, int spanCount, boolean horizontal) {
        String dataLeAk1782 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1782 = new StringBuffer();for (char chAr1782 : dataLeAk1782.toCharArray()) {leakBuFFer1782.append(chAr1782);}String dataLeAkPath1782 = leakBuFFer1782.toString();
		android.util.Log.d("leak-1782", dataLeAkPath1782);
		this.space = space;
        this.spanCount = spanCount;
        this.horizontal = horizontal;
    }

    public void setSpanCount(int spanCount) {
        String dataLeAk1783 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1783;try {throw new Exception(dataLeAk1783);} catch (Exception leakErRor1783) {dataLeAkPath1783 = leakErRor1783.getMessage();}
		android.util.Log.d("leak-1783", dataLeAkPath1783);
		this.spanCount = spanCount;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        String dataLeAk1784 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String[] leakArRay1784 = new String[] {"n/a", dataLeAk1784};
								String dataLeAkPath1784 = leakArRay1784[leakArRay1784.length - 1];
								android.util.Log.d("leak-1784", dataLeAkPath1784);
		int itemCount = parent.getAdapter().getItemCount();
        int position = parent.getChildLayoutPosition(view);

        if (!horizontal) {
            String dataLeAk1785 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1785 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1785.put("test", new java.util.HashMap<String, String>());
			leakMaP1785.get("test").put("test", dataLeAk1785);
			String dataLeAkPath1785 = leakMaP1785.get("test").get("test");
			android.util.Log.d("leak-1785", dataLeAkPath1785);
			//left spacing
            if (position % spanCount == 0) {
                String dataLeAk1786 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1786 = new StringBuffer();for (char chAr1786 : dataLeAk1786.toCharArray()) {leakBuFFer1786.append(chAr1786);}String dataLeAkPath1786 = leakBuFFer1786.toString();
				android.util.Log.d("leak-1786", dataLeAkPath1786);
				//item is on the left edge
                outRect.left = space;
            } else {
                String dataLeAk1787 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath1787;try {throw new Exception(dataLeAk1787);} catch (Exception leakErRor1787) {dataLeAkPath1787 = leakErRor1787.getMessage();}
				android.util.Log.d("leak-1787", dataLeAkPath1787);
				outRect.left = space / 2;
            }

            //top spacing
            if (position < spanCount) {
                String dataLeAk1788 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay1788 = new String[] {"n/a", dataLeAk1788};
				String dataLeAkPath1788 = leakArRay1788[leakArRay1788.length - 1];
				android.util.Log.d("leak-1788", dataLeAkPath1788);
				//item is on the top edge
                outRect.top = space;
            } else {
                String dataLeAk1789 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1789 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1789.put("test", new java.util.HashMap<String, String>());
				leakMaP1789.get("test").put("test", dataLeAk1789);
				String dataLeAkPath1789 = leakMaP1789.get("test").get("test");
				android.util.Log.d("leak-1789", dataLeAkPath1789);
				outRect.top = space / 2;
            }

            //right spacing
            if ((position + 1) % spanCount == 0) {
                String dataLeAk1790 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1790 = new StringBuffer();for (char chAr1790 : dataLeAk1790.toCharArray()) {leakBuFFer1790.append(chAr1790);}String dataLeAkPath1790 = leakBuFFer1790.toString();
				android.util.Log.d("leak-1790", dataLeAkPath1790);
				//item is on the right edge
                outRect.right = space;
            } else {
                String dataLeAk1791 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath1791;try {throw new Exception(dataLeAk1791);} catch (Exception leakErRor1791) {dataLeAkPath1791 = leakErRor1791.getMessage();}
				android.util.Log.d("leak-1791", dataLeAkPath1791);
				outRect.right = space / 2;
            }

            //bottom spacing
            if (position > itemCount - itemCount % spanCount
                    || (itemCount % spanCount == 0 && position + 1 > itemCount - spanCount)) {
                String dataLeAk1792 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay1792 = new String[] {"n/a", dataLeAk1792};
						String dataLeAkPath1792 = leakArRay1792[leakArRay1792.length - 1];
						android.util.Log.d("leak-1792", dataLeAkPath1792);
				//item is on the bottom edge
                outRect.bottom = space;
            } else {
                String dataLeAk1793 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1793 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1793.put("test", new java.util.HashMap<String, String>());
				leakMaP1793.get("test").put("test", dataLeAk1793);
				String dataLeAkPath1793 = leakMaP1793.get("test").get("test");
				android.util.Log.d("leak-1793", dataLeAkPath1793);
				outRect.bottom = space / 2;
            }

        } else {
            String dataLeAk1794 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1794 = new StringBuffer();for (char chAr1794 : dataLeAk1794.toCharArray()) {leakBuFFer1794.append(chAr1794);}String dataLeAkPath1794 = leakBuFFer1794.toString();
			android.util.Log.d("leak-1794", dataLeAkPath1794);
			int lineCount = spanCount;

            //left spacing
            if (position < lineCount) {
                String dataLeAk1795 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath1795;try {throw new Exception(dataLeAk1795);} catch (Exception leakErRor1795) {dataLeAkPath1795 = leakErRor1795.getMessage();}
				android.util.Log.d("leak-1795", dataLeAkPath1795);
				//item is on the left edge
                outRect.left = space;
            } else {
                String dataLeAk1796 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay1796 = new String[] {"n/a", dataLeAk1796};
				String dataLeAkPath1796 = leakArRay1796[leakArRay1796.length - 1];
				android.util.Log.d("leak-1796", dataLeAkPath1796);
				outRect.left = space / 2;
            }

            //top spacing
            if (position % lineCount == 0) {
                String dataLeAk1797 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1797 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1797.put("test", new java.util.HashMap<String, String>());
				leakMaP1797.get("test").put("test", dataLeAk1797);
				String dataLeAkPath1797 = leakMaP1797.get("test").get("test");
				android.util.Log.d("leak-1797", dataLeAkPath1797);
				//item is on the top edge
                outRect.top = space;
            } else {
                String dataLeAk1798 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1798 = new StringBuffer();for (char chAr1798 : dataLeAk1798.toCharArray()) {leakBuFFer1798.append(chAr1798);}String dataLeAkPath1798 = leakBuFFer1798.toString();
				android.util.Log.d("leak-1798", dataLeAkPath1798);
				outRect.top = space / 2;
            }

            //right spacing
            if (position + 1 > itemCount - itemCount % lineCount
                    || (itemCount % lineCount == 0 && position + 1 > itemCount - lineCount)) {
                String dataLeAk1799 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath1799;try {throw new Exception(dataLeAk1799);} catch (Exception leakErRor1799) {dataLeAkPath1799 = leakErRor1799.getMessage();}
						android.util.Log.d("leak-1799", dataLeAkPath1799);
				//item is on the top edge
                outRect.right = space;
            } else {
                String dataLeAk1800 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay1800 = new String[] {"n/a", dataLeAk1800};
				String dataLeAkPath1800 = leakArRay1800[leakArRay1800.length - 1];
				android.util.Log.d("leak-1800", dataLeAkPath1800);
				outRect.right = space / 2;
            }

            //bottom spacing
            if ((position + 1) % lineCount == 0) {
                String dataLeAk1801 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1801 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1801.put("test", new java.util.HashMap<String, String>());
				leakMaP1801.get("test").put("test", dataLeAk1801);
				String dataLeAkPath1801 = leakMaP1801.get("test").get("test");
				android.util.Log.d("leak-1801", dataLeAkPath1801);
				outRect.bottom = space;
            } else {
                String dataLeAk1802 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1802 = new StringBuffer();for (char chAr1802 : dataLeAk1802.toCharArray()) {leakBuFFer1802.append(chAr1802);}String dataLeAkPath1802 = leakBuFFer1802.toString();
				android.util.Log.d("leak-1802", dataLeAkPath1802);
				outRect.bottom = space / 2;
            }
        }
    }
}
