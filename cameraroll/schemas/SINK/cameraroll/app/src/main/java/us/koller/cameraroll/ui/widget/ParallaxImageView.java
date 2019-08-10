package us.koller.cameraroll.ui.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import us.koller.cameraroll.R;

public class ParallaxImageView extends android.support.v7.widget.AppCompatImageView {

    final String dataLeAk1057 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk1055 = "";

	String dataLeAk1054 = "";

	String dataLeAk1052 = "";

	String dataLeAk1051 = "";

	String dataLeAk1050 = "";

	String dataLeAk1049 = "";

	String dataLeAk1048 = "";

	public static final String RECYCLER_VIEW_TAG = "RECYCLER_VIEW_TAG";

    private final int MAX_PARALLAX_OFFSET = (int) getContext().getResources().getDimension(R.dimen.parallax_image_view_offset);

    private int recyclerView_height = -1;
    private int[] recyclerView_location = {-1, -1};

    boolean attached = false;

    public ParallaxImageView(Context context) {
        super(context);
		dataLeAk1048 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1048-0", dataLeAk1048);
		android.util.Log.d("leak-1049-0", dataLeAk1049);
		android.util.Log.d("leak-1050-0", dataLeAk1050);
		android.util.Log.d("leak-1051-0", dataLeAk1051);
		android.util.Log.d("leak-1052-0", dataLeAk1052);
		android.util.Log.d("leak-1054-0", dataLeAk1054);
		android.util.Log.d("leak-1055-0", dataLeAk1055);
    }

    public ParallaxImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
		dataLeAk1049 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1048-1", dataLeAk1048);
		android.util.Log.d("leak-1049-1", dataLeAk1049);
		android.util.Log.d("leak-1050-1", dataLeAk1050);
		android.util.Log.d("leak-1051-1", dataLeAk1051);
		android.util.Log.d("leak-1052-1", dataLeAk1052);
		android.util.Log.d("leak-1054-1", dataLeAk1054);
		android.util.Log.d("leak-1055-1", dataLeAk1055);
    }

    public ParallaxImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
		dataLeAk1050 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1048-2", dataLeAk1048);
		android.util.Log.d("leak-1049-2", dataLeAk1049);
		android.util.Log.d("leak-1050-2", dataLeAk1050);
		android.util.Log.d("leak-1051-2", dataLeAk1051);
		android.util.Log.d("leak-1052-2", dataLeAk1052);
		android.util.Log.d("leak-1054-2", dataLeAk1054);
		android.util.Log.d("leak-1055-2", dataLeAk1055);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec
                + (int) getContext().getResources().getDimension(R.dimen.parallax_image_view_offset));
		dataLeAk1051 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1048-3", dataLeAk1048);
		android.util.Log.d("leak-1049-3", dataLeAk1049);
		android.util.Log.d("leak-1050-3", dataLeAk1050);
		android.util.Log.d("leak-1051-3", dataLeAk1051);
		android.util.Log.d("leak-1052-3", dataLeAk1052);
		android.util.Log.d("leak-1054-3", dataLeAk1054);
		android.util.Log.d("leak-1055-3", dataLeAk1055);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
		dataLeAk1052 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1048-4", dataLeAk1048);
		android.util.Log.d("leak-1049-4", dataLeAk1049);
		android.util.Log.d("leak-1050-4", dataLeAk1050);
		android.util.Log.d("leak-1051-4", dataLeAk1051);
		android.util.Log.d("leak-1052-4", dataLeAk1052);
		android.util.Log.d("leak-1054-4", dataLeAk1054);
		android.util.Log.d("leak-1055-4", dataLeAk1055);

        attached = true;

        View view = getRootView().findViewWithTag(RECYCLER_VIEW_TAG);
        if (view instanceof RecyclerView) {
            ((RecyclerView) view).addOnScrollListener(new RecyclerView.OnScrollListener() {
                String dataLeAk1053 = "";

				@Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
					dataLeAk1053 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-1057-0", dataLeAk1057);
					android.util.Log.d("leak-1053-0", dataLeAk1053);

                    if (!attached) {
                        recyclerView.removeOnScrollListener(this);
                        return;
                    }

                    if (recyclerView_height == -1) {
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
		dataLeAk1054 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1048-5", dataLeAk1048);
		android.util.Log.d("leak-1049-5", dataLeAk1049);
		android.util.Log.d("leak-1050-5", dataLeAk1050);
		android.util.Log.d("leak-1051-5", dataLeAk1051);
		android.util.Log.d("leak-1052-5", dataLeAk1052);
		android.util.Log.d("leak-1054-5", dataLeAk1054);
		android.util.Log.d("leak-1055-5", dataLeAk1055);

        attached = false;
    }

    public void setParallaxTranslation() {
        dataLeAk1055 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1048-6", dataLeAk1048);
		android.util.Log.d("leak-1049-6", dataLeAk1049);
		android.util.Log.d("leak-1050-6", dataLeAk1050);
		android.util.Log.d("leak-1051-6", dataLeAk1051);
		android.util.Log.d("leak-1052-6", dataLeAk1052);
		android.util.Log.d("leak-1054-6", dataLeAk1054);
		android.util.Log.d("leak-1055-6", dataLeAk1055);
		if (recyclerView_height == -1) {
            return;
        }

        int[] location = new int[2];
        getLocationOnScreen(location);

        boolean visible = location[1] + getHeight() > recyclerView_location[1]
                || location[1] < recyclerView_location[1] + recyclerView_height;

        if (!visible) {
            return;
        }

        float dy = (float) (location[1] - recyclerView_location[1]);

        float translationY = MAX_PARALLAX_OFFSET * dy / ((float) recyclerView_height);
        setTranslationY(-translationY);
    }
}
