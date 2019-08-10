package us.koller.cameraroll.ui.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import us.koller.cameraroll.R;

public class ParallaxImageView extends android.support.v7.widget.AppCompatImageView {

    String dataLeAk2077 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk2077 = android.util.Log.d("leak-2077", dataLeAk2077);

	public static final String RECYCLER_VIEW_TAG = "RECYCLER_VIEW_TAG";

    private final int MAX_PARALLAX_OFFSET = (int) getContext().getResources().getDimension(R.dimen.parallax_image_view_offset);

    private int recyclerView_height = -1;
    private int[] recyclerView_location = {-1, -1};

    boolean attached = false;

    public ParallaxImageView(Context context) {
        super(context);
		String dataLeAk2078 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2078 = android.util.Log.d("leak-2078", dataLeAk2078);
    }

    public ParallaxImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
		String dataLeAk2079 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2079 = android.util.Log.d("leak-2079", dataLeAk2079);
    }

    public ParallaxImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
		String dataLeAk2080 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2080 = android.util.Log.d("leak-2080", dataLeAk2080);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec
                + (int) getContext().getResources().getDimension(R.dimen.parallax_image_view_offset));
		String dataLeAk2081 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2081 = android.util.Log.d("leak-2081", dataLeAk2081);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
		String dataLeAk2082 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2082 = android.util.Log.d("leak-2082", dataLeAk2082);

        attached = true;

        View view = getRootView().findViewWithTag(RECYCLER_VIEW_TAG);
        if (view instanceof RecyclerView) {
            String dataLeAk2083 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2083 = android.util.Log.d("leak-2083", dataLeAk2083);
			((RecyclerView) view).addOnScrollListener(new RecyclerView.OnScrollListener() {
                String dataLeAk2084 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2084 = android.util.Log.d("leak-2084", dataLeAk2084);

				@Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
					String dataLeAk2085 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2085 = android.util.Log.d("leak-2085", dataLeAk2085);

                    if (!attached) {
                        String dataLeAk2086 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2086 = android.util.Log.d("leak-2086", dataLeAk2086);
						recyclerView.removeOnScrollListener(this);
                        return;
                    }

                    if (recyclerView_height == -1) {
                        String dataLeAk2087 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2087 = android.util.Log.d("leak-2087", dataLeAk2087);
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
		String dataLeAk2088 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2088 = android.util.Log.d("leak-2088", dataLeAk2088);

        attached = false;
    }

    public void setParallaxTranslation() {
        String dataLeAk2089 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2089 = android.util.Log.d("leak-2089", dataLeAk2089);
		if (recyclerView_height == -1) {
            String dataLeAk2090 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2090 = android.util.Log.d("leak-2090", dataLeAk2090);
			return;
        }

        int[] location = new int[2];
        getLocationOnScreen(location);

        boolean visible = location[1] + getHeight() > recyclerView_location[1]
                || location[1] < recyclerView_location[1] + recyclerView_height;

        if (!visible) {
            String dataLeAk2091 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2091 = android.util.Log.d("leak-2091", dataLeAk2091);
			return;
        }

        float dy = (float) (location[1] - recyclerView_location[1]);

        float translationY = MAX_PARALLAX_OFFSET * dy / ((float) recyclerView_height);
        setTranslationY(-translationY);
    }
}
