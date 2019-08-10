package us.koller.cameraroll.util;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

public class ParallaxTransformer implements ViewPager.PageTransformer {

    String dataLeAk2976 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk2976 = android.util.Log.d("leak-2976", dataLeAk2976);

	private static final float PARALLAX_OFFSET = 0.5f;

    @Override
    public void transformPage(View page, float position) {
        String dataLeAk2977 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2977 = android.util.Log.d("leak-2977", dataLeAk2977);
		View parallaxView = findParallaxView(page);
        if (parallaxView == null) {
            String dataLeAk2978 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2978 = android.util.Log.d("leak-2978", dataLeAk2978);
			return;
        }

        int translationX = 0;
        if (position > -1 && position < 1) {
            String dataLeAk2979 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2979 = android.util.Log.d("leak-2979", dataLeAk2979);
			int direction = position > 0 ? -1 : 1;
            position = Math.abs(position * PARALLAX_OFFSET);
            translationX = (int) (page.getWidth() * direction * position);
        }
        parallaxView.setTranslationX(translationX);
    }

    private View findParallaxView(View page) {
        String dataLeAk2980 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2980 = android.util.Log.d("leak-2980", dataLeAk2980);
		if (page instanceof ViewGroup) {
            String dataLeAk2981 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2981 = android.util.Log.d("leak-2981", dataLeAk2981);
			ViewGroup viewGroup = (ViewGroup) page;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                String dataLeAk2982 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2982 = android.util.Log.d("leak-2982", dataLeAk2982);
				View v = viewGroup.getChildAt(i);
                if (v.getVisibility() == View.VISIBLE) {
                    String dataLeAk2983 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2983 = android.util.Log.d("leak-2983", dataLeAk2983);
					return v;
                }
            }
        }
        return null;
    }
}
