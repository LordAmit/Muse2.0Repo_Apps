package us.koller.cameraroll.ui.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import us.koller.cameraroll.R;

public class ParallaxImageView extends android.support.v7.widget.AppCompatImageView {

    public static final String RECYCLER_VIEW_TAG = "RECYCLER_VIEW_TAG";

    private final int MAX_PARALLAX_OFFSET = (int) getContext().getResources().getDimension(R.dimen.parallax_image_view_offset);

    private int recyclerView_height = -1;
    private int[] recyclerView_location = {-1, -1};

    boolean attached = false;

    public ParallaxImageView(Context context) {
        super(context);
		String dataLeAk1821 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1821 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1821.put("test", new java.util.HashMap<String, String>());
		leakMaP1821.get("test").put("test", dataLeAk1821);
		String dataLeAkPath1821 = leakMaP1821.get("test").get("test");
		android.util.Log.d("leak-1821", dataLeAkPath1821);
    }

    public ParallaxImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
		String dataLeAk1822 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1822 = new StringBuffer();for (char chAr1822 : dataLeAk1822.toCharArray()) {leakBuFFer1822.append(chAr1822);}String dataLeAkPath1822 = leakBuFFer1822.toString();
		android.util.Log.d("leak-1822", dataLeAkPath1822);
    }

    public ParallaxImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
		String dataLeAk1823 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1823;try {throw new Exception(dataLeAk1823);} catch (Exception leakErRor1823) {dataLeAkPath1823 = leakErRor1823.getMessage();}
		android.util.Log.d("leak-1823", dataLeAkPath1823);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec
                + (int) getContext().getResources().getDimension(R.dimen.parallax_image_view_offset));
		String dataLeAk1824 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1824 = new String[] {"n/a", dataLeAk1824};
		String dataLeAkPath1824 = leakArRay1824[leakArRay1824.length - 1];
		android.util.Log.d("leak-1824", dataLeAkPath1824);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
		String dataLeAk1825 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1825 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1825.put("test", new java.util.HashMap<String, String>());
		leakMaP1825.get("test").put("test", dataLeAk1825);
		String dataLeAkPath1825 = leakMaP1825.get("test").get("test");
		android.util.Log.d("leak-1825", dataLeAkPath1825);

        attached = true;

        View view = getRootView().findViewWithTag(RECYCLER_VIEW_TAG);
        if (view instanceof RecyclerView) {
            String dataLeAk1826 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1826 = new StringBuffer();for (char chAr1826 : dataLeAk1826.toCharArray()) {leakBuFFer1826.append(chAr1826);}String dataLeAkPath1826 = leakBuFFer1826.toString();
			android.util.Log.d("leak-1826", dataLeAkPath1826);
			((RecyclerView) view).addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
					String dataLeAk1827 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath1827;try {throw new Exception(dataLeAk1827);} catch (Exception leakErRor1827) {dataLeAkPath1827 = leakErRor1827.getMessage();}
					android.util.Log.d("leak-1827", dataLeAkPath1827);

                    if (!attached) {
                        String dataLeAk1828 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay1828 = new String[] {"n/a", dataLeAk1828};
						String dataLeAkPath1828 = leakArRay1828[leakArRay1828.length - 1];
						android.util.Log.d("leak-1828", dataLeAkPath1828);
						recyclerView.removeOnScrollListener(this);
                        return;
                    }

                    if (recyclerView_height == -1) {
                        String dataLeAk1829 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1829 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP1829.put("test", new java.util.HashMap<String, String>());
						leakMaP1829.get("test").put("test", dataLeAk1829);
						String dataLeAkPath1829 = leakMaP1829.get("test").get("test");
						android.util.Log.d("leak-1829", dataLeAkPath1829);
						recyclerView_height = recyclerView.getHeight();
                        recyclerView.getLocationOnScreen(recyclerView_location);
                    }

                    setParallaxTranslation();
                }
            });
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
		String dataLeAk1830 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1830 = new StringBuffer();for (char chAr1830 : dataLeAk1830.toCharArray()) {leakBuFFer1830.append(chAr1830);}String dataLeAkPath1830 = leakBuFFer1830.toString();
		android.util.Log.d("leak-1830", dataLeAkPath1830);

        attached = false;
    }

    public void setParallaxTranslation() {
        String dataLeAk1831 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1831;try {throw new Exception(dataLeAk1831);} catch (Exception leakErRor1831) {dataLeAkPath1831 = leakErRor1831.getMessage();}
		android.util.Log.d("leak-1831", dataLeAkPath1831);
		if (recyclerView_height == -1) {
            String dataLeAk1832 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1832 = new String[] {"n/a", dataLeAk1832};
			String dataLeAkPath1832 = leakArRay1832[leakArRay1832.length - 1];
			android.util.Log.d("leak-1832", dataLeAkPath1832);
			return;
        }

        int[] location = new int[2];
        getLocationOnScreen(location);

        boolean visible = location[1] + getHeight() > recyclerView_location[1]
                || location[1] < recyclerView_location[1] + recyclerView_height;

        if (!visible) {
            String dataLeAk1833 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1833 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1833.put("test", new java.util.HashMap<String, String>());
			leakMaP1833.get("test").put("test", dataLeAk1833);
			String dataLeAkPath1833 = leakMaP1833.get("test").get("test");
			android.util.Log.d("leak-1833", dataLeAkPath1833);
			return;
        }

        float dy = (float) (location[1] - recyclerView_location[1]);

        float translationY = MAX_PARALLAX_OFFSET * dy / ((float) recyclerView_height);
        setTranslationY(-translationY);
    }
}
