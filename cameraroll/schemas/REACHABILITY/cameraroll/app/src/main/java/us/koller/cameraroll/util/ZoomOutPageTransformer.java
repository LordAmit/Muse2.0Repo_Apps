package us.koller.cameraroll.util;

import android.support.v4.view.ViewPager;
import android.view.View;

//heavily by: https://developer.android.com/training/animation/screen-slide.html#pagetransformer
@SuppressWarnings("unused")
public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
    String dataLeAk2820 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk2820 = android.util.Log.d("leak-2820", dataLeAk2820);

	private static final float MIN_SCALE = 0.85f;
    private static final float MIN_ALPHA = 0.5f;

    public void transformPage(View view, float position) {
        String dataLeAk2821 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2821 = android.util.Log.d("leak-2821", dataLeAk2821);
		int pageWidth = view.getWidth();
        int pageHeight = view.getHeight();

        if (position < -1) { // [-Infinity,-1)
            String dataLeAk2822 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2822 = android.util.Log.d("leak-2822", dataLeAk2822);
			// This page is way off-screen to the left.
            view.setAlpha(0);

        } else if (position <= 1) { // [-1,1]
            String dataLeAk2823 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2823 = android.util.Log.d("leak-2823", dataLeAk2823);
			// Modify the default slide transition to shrink the page as well
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            float vertMargin = pageHeight * (1 - scaleFactor) / 2;
            float horzMargin = pageWidth * (1 - scaleFactor) / 2;
            if (position < 0) {
                String dataLeAk2824 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2824 = android.util.Log.d("leak-2824", dataLeAk2824);
				view.setTranslationX(horzMargin - vertMargin / 2);
            } else {
                String dataLeAk2825 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2825 = android.util.Log.d("leak-2825", dataLeAk2825);
				view.setTranslationX(-horzMargin + vertMargin / 2);
            }

            // Scale the page down (between MIN_SCALE and 1)
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

            // Fade the page relative to its size.
            view.setAlpha(MIN_ALPHA +
                    (scaleFactor - MIN_SCALE) /
                            (1 - MIN_SCALE) * (1 - MIN_ALPHA));

        } else { // (1,+Infinity]
            String dataLeAk2826 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2826 = android.util.Log.d("leak-2826", dataLeAk2826);
			// This page is way off-screen to the right.
            view.setAlpha(0);
        }
    }
}
